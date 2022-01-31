package com.tencent.ttpic.particle;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.filter.m.i;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.filter.VideoFilterBase;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.model.ParticleParam;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.TRIGGERED_STATUS;
import com.tencent.ttpic.model.TriggerCtrlItem;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;

public class ParticleFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER;
  private static final String TAG;
  private static final String VERTEX_SHADER;
  protected StickerItem item;
  private boolean mHasBodyDetected;
  private boolean mHasSeenValid;
  private List<PointF> mPreviousBodyPoints;
  private long mPreviousLostTime;
  private long mTimesForLostProtect;
  private ParticleEmitter particleEmitter;
  private ParticleParam particleParam;
  protected TriggerCtrlItem triggerCtrlItem;
  protected boolean triggered;
  
  static
  {
    AppMethodBeat.i(83631);
    TAG = ParticleFilter.class.getSimpleName();
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ParticleVertexShader.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ParticleFragmentShader.dat");
    AppMethodBeat.o(83631);
  }
  
  public ParticleFilter(String paramString, StickerItem paramStickerItem)
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER);
    AppMethodBeat.i(83619);
    this.particleParam = new ParticleParam();
    this.triggered = false;
    this.mPreviousBodyPoints = null;
    this.mHasBodyDetected = false;
    this.mHasSeenValid = false;
    this.mTimesForLostProtect = 2000L;
    this.mPreviousLostTime = System.currentTimeMillis();
    this.item = paramStickerItem;
    this.particleEmitter = new ParticleEmitter();
    this.particleEmitter.initEmitter(paramString, paramStickerItem.particleConfig);
    this.triggerCtrlItem = new TriggerCtrlItem(paramStickerItem);
    initParams();
    setDrawMode(GlUtil.DRAW_MODE.TRIANGLES);
    AppMethodBeat.o(83619);
  }
  
  private void avoidBodyPointsShake(PTDetectInfo paramPTDetectInfo)
  {
    AppMethodBeat.i(83630);
    if ((paramPTDetectInfo.bodyPoints == null) || (paramPTDetectInfo.bodyPoints.isEmpty()))
    {
      this.mHasBodyDetected = false;
      if (this.mHasSeenValid)
      {
        if (System.currentTimeMillis() - this.mPreviousLostTime < this.mTimesForLostProtect) {
          paramPTDetectInfo.bodyPoints = this.mPreviousBodyPoints;
        }
        AppMethodBeat.o(83630);
        return;
      }
      this.mHasSeenValid = false;
      AppMethodBeat.o(83630);
      return;
    }
    this.mHasBodyDetected = true;
    this.mHasSeenValid = true;
    this.mPreviousLostTime = System.currentTimeMillis();
    this.mPreviousBodyPoints = paramPTDetectInfo.bodyPoints;
    AppMethodBeat.o(83630);
  }
  
  private float[] normalizePosition(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat = new float[paramArrayOfFloat.length];
    int i = 0;
    while (i < arrayOfFloat.length / 3)
    {
      arrayOfFloat[(i * 3)] = (paramArrayOfFloat[(i * 3)] / paramInt1 * 2.0F - 1.0F);
      arrayOfFloat[(i * 3 + 1)] = (paramArrayOfFloat[(i * 3 + 1)] / paramInt2 * 2.0F - 1.0F);
      arrayOfFloat[(i * 3 + 2)] = paramArrayOfFloat[(i * 3 + 2)];
      i += 1;
    }
    return arrayOfFloat;
  }
  
  private void resetParams()
  {
    int i = 1;
    AppMethodBeat.i(83620);
    addParam(new m.i("isPartical2", 1));
    if (this.particleEmitter.opacityModifyRGB) {}
    for (;;)
    {
      addParam(new m.i("u_opacityModifyRGB", i));
      addParam(new m.n("inputImageTexture2", 0, 33986));
      setCoordNum(6);
      addAttribParam(new AttributeParam("position", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 3));
      addAttribParam(new AttributeParam("inputTextureCoordinate", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 2));
      addAttribParam(new AttributeParam("aColor", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 4));
      this.mHasSeenValid = false;
      this.mPreviousBodyPoints = null;
      this.particleParam.needRender = false;
      AppMethodBeat.o(83620);
      return;
      i = 0;
    }
  }
  
  private ParticleFilter.ParticleEmitterParam updateEmitterParam(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(83625);
    ParticleFilter.ParticleEmitterParam localParticleEmitterParam = new ParticleFilter.ParticleEmitterParam(this, null);
    PointF localPointF2 = null;
    PointF localPointF1 = localPointF2;
    switch (this.item.type)
    {
    default: 
      localPointF1 = localPointF2;
    }
    int i;
    do
    {
      do
      {
        for (;;)
        {
          localParticleEmitterParam.emitPosition = localPointF1;
          localParticleEmitterParam.extraScale *= (float)this.triggerCtrlItem.getAudioScaleFactor();
          localParticleEmitterParam.extraScale *= this.width * 1.0F / 720.0F;
          AppMethodBeat.o(83625);
          return localParticleEmitterParam;
          localPointF1 = new PointF();
          int j;
          if (this.width / this.height >= 0.75D)
          {
            int k = (int)(this.width / 0.75D);
            i = (int)(k * this.item.position[1]);
            j = (int)(this.width * this.item.position[0]);
            k = (k - this.height) / 2;
            localPointF1.x = j;
            localPointF1.y = (i - k);
          }
          else
          {
            i = (int)(this.height * 0.75D);
            j = (int)(this.height * this.item.position[1]);
            localPointF1.x = ((int)(i * this.item.position[0]) - (i - this.width) / 2);
            localPointF1.y = j;
          }
        }
        localPointF1 = localPointF2;
      } while (paramList == null);
      localPointF1 = localPointF2;
    } while (paramList.isEmpty());
    localPointF1 = new PointF();
    localPointF2 = (PointF)paramList.get(this.item.alignFacePoints[0]);
    if (this.item.alignFacePoints.length == 1)
    {
      i = this.item.alignFacePoints[0];
      label377:
      PointF localPointF3 = (PointF)paramList.get(i);
      localPointF2 = new PointF((localPointF2.x + localPointF3.x) / 2.0F, (localPointF2.y + localPointF3.y) / 2.0F);
      localPointF2.x = ((float)(localPointF2.x / this.mFaceDetScale));
      localPointF2.y = ((float)(localPointF2.y / this.mFaceDetScale));
      localPointF1.x = localPointF2.x;
      localPointF1.y = localPointF2.y;
      localPointF2 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
      localPointF2.x = ((float)(localPointF2.x / this.mFaceDetScale));
      localPointF2.y = ((float)(localPointF2.y / this.mFaceDetScale));
      paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
      paramList.x = ((float)(paramList.x / this.mFaceDetScale));
      paramList.y = ((float)(paramList.y / this.mFaceDetScale));
      double d = Math.pow(localPointF2.x - paramList.x, 2.0D);
      d = Math.sqrt(Math.pow(localPointF2.y - paramList.y, 2.0D) + d) / this.item.scaleFactor;
      if (this.item.type == 2) {
        localParticleEmitterParam.extraScale = ((float)d);
      }
      if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length < 3)) {
        break label751;
      }
    }
    label751:
    for (float f = paramArrayOfFloat[2];; f = 0.0F)
    {
      localParticleEmitterParam.extraRotate = f;
      break;
      i = this.item.alignFacePoints[1];
      break label377;
    }
  }
  
  private void updateParticle(ParticleFilter.ParticleEmitterParam paramParticleEmitterParam)
  {
    AppMethodBeat.i(83626);
    Object localObject1 = paramParticleEmitterParam.emitPosition;
    float f1 = paramParticleEmitterParam.extraScale;
    float f2 = paramParticleEmitterParam.extraRotate;
    Object localObject2;
    int i4;
    int n;
    int j;
    int m;
    int k;
    int i2;
    int i1;
    if (this.particleEmitter.totalFinished())
    {
      this.particleEmitter.reset();
      this.particleEmitter.startTime = -1L;
      localObject2 = this.particleEmitter;
      if (localObject1 != null)
      {
        paramParticleEmitterParam = new Vector2(((PointF)localObject1).x, this.height - ((PointF)localObject1).y);
        ((ParticleEmitter)localObject2).setSourcePosition(paramParticleEmitterParam);
        this.particleEmitter.setExtraRotate(0.0F);
        this.particleEmitter.setExtraScale(1.0F);
        this.particleEmitter.startTime = System.currentTimeMillis();
        i4 = this.particleEmitter.activeParticleCount();
        if (i4 <= 0) {
          break label973;
        }
        paramParticleEmitterParam = new float[i4 * 18];
        localObject1 = new float[i4 * 12];
        localObject2 = new float[i4 * 24];
        i = 0;
        n = 0;
        j = 0;
        m = 0;
        k = 0;
        i2 = 0;
        BenchUtil.benchStart("setValue");
        i1 = 0;
      }
    }
    for (;;)
    {
      if (i1 >= this.particleEmitter.activeParticleCount()) {
        break label599;
      }
      int i3 = 0;
      for (;;)
      {
        if (i3 < 24)
        {
          localObject2[(k + i3)] = this.particleEmitter.particleColors[(i2 + i3)];
          i3 += 1;
          continue;
          paramParticleEmitterParam = new Vector2();
          break;
          float f3 = (float)this.triggerCtrlItem.getAudioScaleFactor();
          LogUtils.e(TAG, "AudioScaleFactor = ".concat(String.valueOf(f3)));
          this.particleEmitter.setExtraScale(f3);
          localObject2 = this.particleEmitter;
          label317:
          long l;
          if (localObject1 != null)
          {
            paramParticleEmitterParam = new Vector2(((PointF)localObject1).x, this.height - ((PointF)localObject1).y);
            ((ParticleEmitter)localObject2).setSourcePosition(paramParticleEmitterParam);
            this.particleEmitter.setExtraScale(f1);
            this.particleEmitter.setExtraRotate((float)Math.toDegrees(f2));
            BenchUtil.benchStart("updateWithCurrentTime");
            paramParticleEmitterParam = this.particleEmitter;
            l = System.currentTimeMillis();
            if (localObject1 == null) {
              break label397;
            }
          }
          label397:
          for (boolean bool = true;; bool = false)
          {
            paramParticleEmitterParam.updateWithCurrentTime(l, bool);
            BenchUtil.benchEnd("updateWithCurrentTime");
            break;
            paramParticleEmitterParam = new Vector2();
            break label317;
          }
        }
      }
      i3 = 0;
      if (i3 < 18)
      {
        if ((i3 + 2) % 3 == 0) {
          paramParticleEmitterParam[(i + i3)] = (this.height - this.particleEmitter.particleVertices[(n + i3)]);
        }
        for (;;)
        {
          i3 += 1;
          break;
          paramParticleEmitterParam[(i + i3)] = this.particleEmitter.particleVertices[(n + i3)];
        }
      }
      i3 = 0;
      if (i3 < 12)
      {
        if (i3 % 2 != 0) {}
        for (f1 = 1.0F - this.particleEmitter.particleTextureCoordinates[(m + i3)];; f1 = this.particleEmitter.particleTextureCoordinates[(m + i3)])
        {
          localObject1[(j + i3)] = f1;
          i3 += 1;
          break;
        }
      }
      i2 += 24;
      n += 18;
      m += 12;
      k += 24;
      i += 18;
      j += 12;
      i1 += 1;
    }
    label599:
    BenchUtil.benchEnd("setValue");
    setCoordNum(i4 * 6);
    addParam(new m.n("inputImageTexture2", this.particleEmitter.texture, 33986));
    addParam(new m.i("isPartical2", 1));
    addAttribParam(new AttributeParam("aColor", (float[])localObject2, 4));
    addAttribParam(new AttributeParam("position", normalizePosition(paramParticleEmitterParam, this.width, this.height), 3));
    setTexCords((float[])localObject1);
    ParticleParam localParticleParam;
    if (this.particleEmitter.opacityModifyRGB)
    {
      i = 1;
      addParam(new m.i("u_opacityModifyRGB", i));
      if (VideoMaterialUtil.isBodyDetectItem(this.item))
      {
        if (this.particleParam == null) {
          this.particleParam = new ParticleParam();
        }
        this.particleParam.id = (this.item.id + this.item.alignFacePoints[0]);
        this.particleParam.needRender = true;
        this.particleParam.coordNum = (i4 * 6);
        this.particleParam.blendFuncSrc = this.particleEmitter.blendFuncSource;
        this.particleParam.blendFuncDst = this.particleEmitter.blendFuncDestination;
        this.particleParam.texture = this.particleEmitter.texture;
        this.particleParam.isPartical2 = 1;
        localParticleParam = this.particleParam;
        if (!this.particleEmitter.opacityModifyRGB) {
          break label967;
        }
      }
    }
    label967:
    for (int i = 1;; i = 0)
    {
      localParticleParam.u_opacityModifyRGB = i;
      this.particleParam.maxParticleNum = this.item.particleConfig.getParticleEmitterConfig().getMaxParticles().getValue();
      this.particleParam.aColor = ((float[])localObject2);
      this.particleParam.position = normalizePosition(paramParticleEmitterParam, this.width, this.height);
      this.particleParam.inputTextureCoordinate = ((float[])localObject1);
      AppMethodBeat.o(83626);
      return;
      i = 0;
      break;
    }
    label973:
    resetParams();
    AppMethodBeat.o(83626);
  }
  
  public void clearGLSLSelf()
  {
    AppMethodBeat.i(83629);
    super.clearGLSLSelf();
    this.particleEmitter.clear();
    AppMethodBeat.o(83629);
  }
  
  public ParticleParam getParticleParam()
  {
    return this.particleParam;
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(83622);
    super.initAttribParams();
    addAttribParam(new AttributeParam("position", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 3));
    addAttribParam(new AttributeParam("inputTextureCoordinate", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 2));
    addAttribParam(new AttributeParam("aColor", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 4));
    AppMethodBeat.o(83622);
  }
  
  public void initParams()
  {
    int i = 1;
    AppMethodBeat.i(83621);
    addParam(new m.i("isPartical2", 1));
    if (this.particleEmitter.opacityModifyRGB) {}
    for (;;)
    {
      addParam(new m.i("u_opacityModifyRGB", i));
      addParam(new m.n("inputImageTexture2", 0, 33986));
      setCoordNum(6);
      this.particleParam.needRender = false;
      AppMethodBeat.o(83621);
      return;
      i = 0;
    }
  }
  
  public boolean isBodyNeeded()
  {
    return this.item.type == VideoFilterFactory.POSITION_TYPE.BODY.type;
  }
  
  public boolean isStatic()
  {
    return (this.item.type == VideoFilterFactory.POSITION_TYPE.STATIC.type) || (this.item.type == VideoFilterFactory.POSITION_TYPE.RELATIVE.type);
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(83628);
    boolean bool1 = GlUtil.curBlendModeEnabled;
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(this.particleEmitter.blendFuncSource, this.particleEmitter.blendFuncDestination);
    boolean bool2 = super.renderTexture(paramInt1, paramInt2, paramInt3);
    GlUtil.setBlendMode(bool1);
    AppMethodBeat.o(83628);
    return bool2;
  }
  
  protected void update(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(83624);
    updateParticle(updateEmitterParam(paramList, paramArrayOfFloat));
    AppMethodBeat.o(83624);
  }
  
  protected TRIGGERED_STATUS updateActionTriggered(PTDetectInfo paramPTDetectInfo)
  {
    AppMethodBeat.i(83627);
    paramPTDetectInfo = this.triggerCtrlItem.getTriggeredStatus(paramPTDetectInfo);
    AppMethodBeat.o(83627);
    return paramPTDetectInfo;
  }
  
  public void updatePreview(PTDetectInfo paramPTDetectInfo)
  {
    AppMethodBeat.i(83623);
    if (VideoMaterialUtil.isBodyDetectItem(this.item)) {
      avoidBodyPointsShake(paramPTDetectInfo);
    }
    updateActionTriggered(paramPTDetectInfo);
    if (!this.triggerCtrlItem.isTriggered())
    {
      resetParams();
      AppMethodBeat.o(83623);
      return;
    }
    if (VideoMaterialUtil.isGestureItem(this.item))
    {
      update(paramPTDetectInfo.handPoints, paramPTDetectInfo.faceAngles);
      AppMethodBeat.o(83623);
      return;
    }
    if (VideoMaterialUtil.isBodyDetectItem(this.item))
    {
      update(paramPTDetectInfo.bodyPoints, paramPTDetectInfo.faceAngles);
      if (!this.mHasBodyDetected)
      {
        paramPTDetectInfo.bodyPoints = null;
        AppMethodBeat.o(83623);
      }
    }
    else
    {
      update(paramPTDetectInfo.facePoints, paramPTDetectInfo.faceAngles);
    }
    AppMethodBeat.o(83623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.particle.ParticleFilter
 * JD-Core Version:    0.7.0.1
 */