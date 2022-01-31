package com.tencent.ttpic.ar.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.filter.m.j;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.oscarcamera.particlesystem.ParticleSystemEx;
import com.tencent.oscarcamera.particlesystem.Sprite;
import com.tencent.ttpic.ar.util.ARMatrixUtil;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.filter.VideoFilterBase;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.model.Point3D;
import com.tencent.ttpic.util.PlayerUtil;
import com.tencent.ttpic.util.PlayerUtil.Player;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ARParticleFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER_COMMON;
  private static final String VERTEX_SHADER_COMMON;
  private String TAG;
  private float far;
  private FrameData[] frameDataBufferQueue;
  private int frameDataBufferQueueIndex;
  private float mCanvasHeight;
  private float mCanvasWidth;
  private BaseFilter mCopyFilter;
  private h mCopyFrame;
  private FrameData mLastFrameData;
  private ARParticleFilter.ParticleCalculationHandler mParticleCalculationHandler;
  private List<String> mParticleDirList;
  private ParticleSystemEx mParticleSystem;
  private Map<String, Integer> mPathToBitmapIndexMapping;
  private Map<String, PlayerUtil.Player> mPlayerMapping;
  private List<Sprite> mSpriteList;
  private List<ArrayList<ARParticleFilter.TexCoord>> mTexCoords;
  private Bitmap[] mTextureBitmaps;
  private ARParticleFilter.Size[] mTextureSizes;
  private int[] mTextures;
  private float mViewDistance;
  private float near;
  
  static
  {
    AppMethodBeat.i(81676);
    VERTEX_SHADER_COMMON = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ARParticleVertexShader.dat");
    FRAGMENT_SHADER_COMMON = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ARParticleFragmentShader.dat");
    AppMethodBeat.o(81676);
  }
  
  public ARParticleFilter(List<String> paramList, String paramString)
  {
    super(VERTEX_SHADER_COMMON, FRAGMENT_SHADER_COMMON);
    AppMethodBeat.i(81655);
    this.TAG = ARParticleFilter.class.getSimpleName();
    this.near = 100.0F;
    this.far = 2000.0F;
    this.mParticleSystem = new ParticleSystemEx(VideoGlobalContext.getContext());
    this.mPathToBitmapIndexMapping = new HashMap();
    this.mTexCoords = new ArrayList();
    this.mPlayerMapping = new HashMap();
    this.frameDataBufferQueue = new FrameData[2];
    this.frameDataBufferQueueIndex = 0;
    this.mCopyFilter = new BaseFilter(GLSLRender.btg);
    this.mCopyFrame = new h();
    this.dataPath = paramString;
    setDrawMode(GlUtil.DRAW_MODE.TRIANGLES);
    initParticle(paramList);
    AppMethodBeat.o(81655);
  }
  
  private void calTexCoordList(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(81668);
    if (paramInt1 < this.mTexCoords.size())
    {
      Object localObject = (ArrayList)this.mTexCoords.get(paramInt1);
      if (paramInt2 >= 0)
      {
        paramInt1 = paramInt2;
        if (paramInt2 < ((ArrayList)localObject).size()) {}
      }
      else
      {
        paramInt1 = 0;
      }
      if (paramInt1 < ((ArrayList)localObject).size())
      {
        localObject = (ARParticleFilter.TexCoord)((ArrayList)localObject).get(paramInt1);
        paramInt1 = paramInt3 * 12;
        paramInt2 = 0;
        while ((paramInt2 < 12) && (paramInt1 < paramArrayOfFloat.length))
        {
          paramArrayOfFloat[paramInt1] = localObject.texCoord[paramInt2];
          paramInt2 += 1;
          paramInt1 += 1;
        }
      }
    }
    AppMethodBeat.o(81668);
  }
  
  private boolean changeTexture(String paramString)
  {
    AppMethodBeat.i(81666);
    if (!this.mPathToBitmapIndexMapping.containsKey(paramString))
    {
      AppMethodBeat.o(81666);
      return false;
    }
    int i = ((Integer)this.mPathToBitmapIndexMapping.get(paramString)).intValue();
    if (this.mTextures[i] == 0)
    {
      paramString = this.mTextureBitmaps[i];
      if (isBitmapLegal(paramString))
      {
        this.mTextureSizes[i] = new ARParticleFilter.Size(this, paramString.getWidth(), paramString.getHeight());
        GLES20.glGenTextures(1, this.mTextures, i);
        GLES20.glBindTexture(3553, this.mTextures[i]);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
      }
    }
    else
    {
      try
      {
        GLUtils.texImage2D(3553, 0, paramString, 0);
        paramString.recycle();
        paramString = new m.n("inputImageTexture2", this.mTextures[i], 33986);
        paramString.initialParams(getProgramIds());
        addParam(paramString);
        if ((this.mTextureSizes[i] == null) || (!this.mTextureSizes[i].isValid())) {
          break label246;
        }
        AppMethodBeat.o(81666);
        return true;
      }
      catch (OutOfMemoryError paramString)
      {
        AppMethodBeat.o(81666);
        return false;
      }
    }
    AppMethodBeat.o(81666);
    return false;
    label246:
    AppMethodBeat.o(81666);
    return false;
  }
  
  private void initParticle(List<String> paramList)
  {
    AppMethodBeat.i(81656);
    if (paramList != null)
    {
      this.mParticleDirList = new ArrayList();
      paramList = new ArrayList(paramList);
      int i = 0;
      while (i < paramList.size())
      {
        this.mParticleDirList.add(((String)paramList.get(i)).substring(0, ((String)paramList.get(i)).lastIndexOf("/")));
        paramList.set(i, FileUtils.getRealPath(this.dataPath + File.separator + (String)paramList.get(i)));
        i += 1;
      }
      this.mParticleSystem.loadParticleData(paramList);
      this.mSpriteList = this.mParticleSystem.getSprites();
      this.mTextureBitmaps = new Bitmap[this.mSpriteList.size()];
      this.mTextures = new int[this.mSpriteList.size()];
      this.mTextureSizes = new ARParticleFilter.Size[this.mSpriteList.size()];
      i = 0;
      while ((i < this.mSpriteList.size()) && (i < this.mParticleDirList.size()))
      {
        this.mPathToBitmapIndexMapping.put((String)this.mParticleDirList.get(i) + File.separator + ((Sprite)this.mSpriteList.get(i)).path, Integer.valueOf(i));
        this.mTexCoords.add(new ArrayList());
        i += 1;
      }
      new ARParticleFilter.BitmapDecodeTask(this).execute(new Void[0]);
    }
    paramList = new HandlerThread("ParticleCalculationThread", -16);
    paramList.start();
    this.mParticleCalculationHandler = new ARParticleFilter.ParticleCalculationHandler(this, paramList.getLooper());
    this.mParticleCalculationHandler.sendEmptyMessage(0);
    AppMethodBeat.o(81656);
  }
  
  private boolean isBitmapLegal(Bitmap paramBitmap)
  {
    AppMethodBeat.i(81667);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(81667);
      return true;
    }
    AppMethodBeat.o(81667);
    return false;
  }
  
  private void playMusicIfNeeded(FrameData paramFrameData)
  {
    AppMethodBeat.i(81661);
    if (paramFrameData.needPlayMusic)
    {
      Iterator localIterator = paramFrameData.frameParticleData.iterator();
      while (localIterator.hasNext())
      {
        paramFrameData = (ARParticleFilter.FrameParticleData)localIterator.next();
        if (!TextUtils.isEmpty(paramFrameData.audioPath))
        {
          String str = paramFrameData.audioPath;
          if (!this.mPlayerMapping.containsKey(str)) {
            if (!str.startsWith("assets://")) {
              break label136;
            }
          }
          label136:
          for (paramFrameData = PlayerUtil.createPlayerFromAssets(VideoGlobalContext.getContext(), str.replace("assets://", ""), false);; paramFrameData = PlayerUtil.createPlayerFromUri(VideoGlobalContext.getContext(), str, false))
          {
            this.mPlayerMapping.put(str, paramFrameData);
            paramFrameData = (PlayerUtil.Player)this.mPlayerMapping.get(str);
            if (paramFrameData == null) {
              break;
            }
            PlayerUtil.startPlayer(paramFrameData, true);
            break;
          }
        }
      }
    }
    AppMethodBeat.o(81661);
  }
  
  private float pow2(float paramFloat)
  {
    return paramFloat * paramFloat;
  }
  
  private void vectorNormalization(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(81659);
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length < 3))
    {
      AppMethodBeat.o(81659);
      return;
    }
    float f = (float)Math.sqrt(pow2(paramArrayOfFloat[0]) + pow2(paramArrayOfFloat[1]) + pow2(paramArrayOfFloat[2]));
    if (f > 0.0F)
    {
      paramArrayOfFloat[0] /= f;
      paramArrayOfFloat[1] /= f;
      paramArrayOfFloat[2] /= f;
    }
    AppMethodBeat.o(81659);
  }
  
  public void addTouchPoint(PointF paramPointF)
  {
    AppMethodBeat.i(81669);
    float f1 = ARMatrixUtil.nearRectHeight / ARMatrixUtil.nearRectWidth;
    float f2 = ARMatrixUtil.nearRectWidth;
    float f3 = this.mViewDistance / ARMatrixUtil.near;
    float f4 = ARMatrixUtil.nearRectHeight;
    float f5 = this.mViewDistance / ARMatrixUtil.near;
    Object localObject2 = new Point3D();
    ((Point3D)localObject2).x = (this.mViewDistance * ARMatrixUtil.cameraX);
    ((Point3D)localObject2).y = (this.mViewDistance * ARMatrixUtil.cameraY);
    ((Point3D)localObject2).z = (this.mViewDistance * ARMatrixUtil.cameraZ);
    Object localObject1 = new float[3];
    localObject1[0] = (ARMatrixUtil.cameraUpX * f1 + ARMatrixUtil.cameraRightX);
    localObject1[1] = (ARMatrixUtil.cameraUpY * f1 + ARMatrixUtil.cameraRightY);
    localObject1[2] = (ARMatrixUtil.cameraUpZ * f1 + ARMatrixUtil.cameraRightZ);
    vectorNormalization((float[])localObject1);
    f2 = (float)Math.sqrt(pow2(f2 * f3) + pow2(f4 * f5)) / 2.0F;
    Point3D localPoint3D1 = new Point3D();
    localPoint3D1.x = (((Point3D)localObject2).x - localObject1[0] * f2);
    localPoint3D1.y = (((Point3D)localObject2).y - localObject1[1] * f2);
    localPoint3D1.z = (((Point3D)localObject2).z - localObject1[2] * f2);
    float[] arrayOfFloat = new float[3];
    arrayOfFloat[0] = (ARMatrixUtil.cameraUpX * f1 - ARMatrixUtil.cameraRightX);
    arrayOfFloat[1] = (ARMatrixUtil.cameraUpY * f1 - ARMatrixUtil.cameraRightY);
    arrayOfFloat[2] = (f1 * ARMatrixUtil.cameraUpZ - ARMatrixUtil.cameraRightZ);
    vectorNormalization(arrayOfFloat);
    localObject1 = new Point3D();
    ((Point3D)localObject2).x += arrayOfFloat[0] * f2;
    ((Point3D)localObject2).y += arrayOfFloat[1] * f2;
    ((Point3D)localObject2).z += arrayOfFloat[2] * f2;
    Point3D localPoint3D2 = new Point3D();
    localPoint3D2.x = (((Point3D)localObject2).x - arrayOfFloat[0] * f2);
    localPoint3D2.y = (((Point3D)localObject2).y - arrayOfFloat[1] * f2);
    localPoint3D2.z = (((Point3D)localObject2).z - f2 * arrayOfFloat[2]);
    f2 = paramPointF.x / this.width;
    f1 = f2;
    if (ARMatrixUtil.isFrontCamera) {
      f1 = 1.0F - f2;
    }
    localObject2 = new float[3];
    localObject2[0] = ((localPoint3D2.x - localPoint3D1.x) * f1);
    localObject2[1] = ((localPoint3D2.y - localPoint3D1.y) * f1);
    localObject2[2] = (f1 * (localPoint3D2.z - localPoint3D1.z));
    f1 = 1.0F - paramPointF.y / this.height;
    paramPointF = new float[3];
    paramPointF[0] = ((((Point3D)localObject1).x - localPoint3D1.x) * f1);
    paramPointF[1] = ((((Point3D)localObject1).y - localPoint3D1.y) * f1);
    paramPointF[2] = (f1 * (((Point3D)localObject1).z - localPoint3D1.z));
    localObject1 = new Point3D();
    ((Point3D)localObject1).x = (localPoint3D1.x + localObject2[0] + paramPointF[0]);
    ((Point3D)localObject1).y = (localPoint3D1.y + localObject2[1] + paramPointF[1]);
    f1 = localPoint3D1.z;
    ((Point3D)localObject1).z = (localObject2[2] + f1 + paramPointF[2]);
    this.mParticleSystem.emitImmediately(((Point3D)localObject1).x, ((Point3D)localObject1).y, ((Point3D)localObject1).z);
    AppMethodBeat.o(81669);
  }
  
  public void clear()
  {
    AppMethodBeat.i(81673);
    super.clearGLSLSelf();
    ARMatrixUtil.stopOrientationSensor();
    Bitmap[] arrayOfBitmap = this.mTextureBitmaps;
    int j = arrayOfBitmap.length;
    int i = 0;
    while (i < j)
    {
      Bitmap localBitmap = arrayOfBitmap[i];
      if (isBitmapLegal(localBitmap)) {
        localBitmap.recycle();
      }
      i += 1;
    }
    GLES20.glDeleteTextures(this.mTextures.length, this.mTextures, 0);
    this.mCopyFilter.ClearGLSL();
    this.mCopyFrame.clear();
    destroyAudioPlayer();
    if (this.mParticleCalculationHandler != null)
    {
      this.mParticleCalculationHandler.isStopped = true;
      this.mParticleCalculationHandler.getLooper().quit();
    }
    this.mParticleSystem.release();
    System.gc();
    AppMethodBeat.o(81673);
  }
  
  public void destroyAudioPlayer()
  {
    AppMethodBeat.i(81674);
    Iterator localIterator = this.mPlayerMapping.values().iterator();
    while (localIterator.hasNext()) {
      PlayerUtil.destroyPlayer((PlayerUtil.Player)localIterator.next());
    }
    this.mPlayerMapping.clear();
    AppMethodBeat.o(81674);
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(81670);
    setTexCords(new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F });
    setCoordNum(4);
    addAttribParam(new AttributeParam("positionIndex", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 1));
    addAttribParam(new AttributeParam("particleCenter", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 3));
    addAttribParam(new AttributeParam("particleSize", new float[] { 0.0F, 0.0F }, 2));
    addAttribParam(new AttributeParam("particleColor", new float[] { 0.0F, 0.0F, 0.0F, 0.0F }, 4));
    initParams();
    AppMethodBeat.o(81670);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(81657);
    this.mViewDistance = (this.near + (this.far - this.near) * 0.5F);
    addParam(new m.j("u_MVPMatrix", ARMatrixUtil.getMovedMVPMatrix(this.near, this.far)));
    addParam(new m.i("blendMode", 0));
    addParam(new m.f("canvasWidth", 1.0F));
    addParam(new m.f("canvasHeight", 1.0F));
    addParam(new m.i("isFrontCamera", 0));
    ARMatrixUtil.startOrientationSensor();
    this.mCopyFilter.ApplyGLSLFilter();
    AppMethodBeat.o(81657);
  }
  
  public boolean needCopyTex()
  {
    AppMethodBeat.i(81671);
    if (this.mSpriteList != null)
    {
      Iterator localIterator = this.mSpriteList.iterator();
      while (localIterator.hasNext())
      {
        Sprite localSprite = (Sprite)localIterator.next();
        if ((localSprite.blendMode >= 2) && (localSprite.blendMode <= 12))
        {
          AppMethodBeat.o(81671);
          return true;
        }
      }
    }
    AppMethodBeat.o(81671);
    return false;
  }
  
  public boolean needCopyTex(int paramInt)
  {
    return (paramInt >= 2) && (paramInt <= 12);
  }
  
  public void render(h paramh)
  {
    AppMethodBeat.i(81660);
    FrameData localFrameData = this.frameDataBufferQueue[this.frameDataBufferQueueIndex];
    if ((localFrameData == null) || (!localFrameData.ready)) {
      if (this.mLastFrameData != null) {
        localFrameData = this.mLastFrameData;
      }
    }
    for (;;)
    {
      this.mLastFrameData = localFrameData;
      localFrameData.ready = false;
      this.frameDataBufferQueueIndex = ((this.frameDataBufferQueueIndex + 1) % 2);
      this.mParticleCalculationHandler.sendEmptyMessage(this.frameDataBufferQueueIndex);
      int i = 0;
      if ((i < localFrameData.frameParticleData.size()) && (i < this.mParticleDirList.size()))
      {
        int j = paramh.texture[0];
        ARParticleFilter.FrameParticleData localFrameParticleData = (ARParticleFilter.FrameParticleData)localFrameData.frameParticleData.get(i);
        if (needCopyTex(localFrameParticleData.blendMode))
        {
          this.mCopyFilter.RenderProcess(paramh.texture[0], this.width, this.height, -1, 0.0D, this.mCopyFrame);
          j = this.mCopyFrame.texture[0];
          paramh.a(-1, paramh.width, paramh.height, 0.0D);
        }
        if (changeTexture((String)this.mParticleDirList.get(i) + File.separator + localFrameParticleData.tex))
        {
          setPositionIndex(localFrameParticleData.positionIndex);
          setParticleCenter(localFrameParticleData.particleCenter);
          setParticleSize(localFrameParticleData.particleSize);
          setParticleColor(localFrameParticleData.particleColor);
          setCoordNum(localFrameParticleData.particleCount * 6);
          setTexCords(localFrameParticleData.texCoords);
          addParam(new m.i("blendMode", localFrameParticleData.blendMode));
          addParam(new m.j("u_MVPMatrix", ARMatrixUtil.getMovedMVPMatrix(this.near, this.far)));
          addParam(new m.f("canvasWidth", this.mCanvasWidth));
          addParam(new m.f("canvasHeight", this.mCanvasHeight));
          if (!ARMatrixUtil.isFrontCamera) {
            break label441;
          }
        }
        label441:
        for (int k = 1;; k = 0)
        {
          addParam(new m.i("isFrontCamera", k));
          OnDrawFrameGLSL();
          super.renderTexture(j, this.width, this.height);
          i += 1;
          break;
          AppMethodBeat.o(81660);
          return;
        }
      }
      playMusicIfNeeded(localFrameData);
      AppMethodBeat.o(81660);
      return;
    }
  }
  
  public boolean setParticleCenter(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(81663);
    addAttribParam(new AttributeParam("particleCenter", paramArrayOfFloat, 3));
    AppMethodBeat.o(81663);
    return true;
  }
  
  public boolean setParticleColor(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(81665);
    addAttribParam(new AttributeParam("particleColor", paramArrayOfFloat, 4));
    AppMethodBeat.o(81665);
    return true;
  }
  
  public boolean setParticleSize(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(81664);
    addAttribParam(new AttributeParam("particleSize", paramArrayOfFloat, 2));
    AppMethodBeat.o(81664);
    return true;
  }
  
  public boolean setPositionIndex(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(81662);
    addAttribParam(new AttributeParam("positionIndex", paramArrayOfFloat, 1));
    AppMethodBeat.o(81662);
    return true;
  }
  
  public void updateAndRender(h paramh)
  {
    AppMethodBeat.i(81672);
    ARMatrixUtil.updateOrientation();
    render(paramh);
    AppMethodBeat.o(81672);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(81658);
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.mCanvasWidth = paramInt1;
    this.mCanvasHeight = paramInt2;
    ARMatrixUtil.updateRenderSize(paramInt1, paramInt2);
    AppMethodBeat.o(81658);
  }
  
  class FrameData
  {
    public List<ARParticleFilter.FrameParticleData> frameParticleData;
    public boolean needPlayMusic;
    public boolean ready;
    
    FrameData()
    {
      AppMethodBeat.i(81652);
      this.frameParticleData = new ArrayList();
      AppMethodBeat.o(81652);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.ar.filter.ARParticleFilter
 * JD-Core Version:    0.7.0.1
 */