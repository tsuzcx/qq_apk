package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.RenderParam;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.Transition;
import com.tencent.ttpic.particlesystemx.ParticleItemX;
import com.tencent.ttpic.particlesystemx.ParticleSystemX;
import com.tencent.ttpic.particlesystemx.ParticleX;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.BenchUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

public class ParticleXFilter
  extends NormalVideoFilter
{
  private FastRenderFilter fastRenderFilter;
  private float frameInterval;
  private long lastFrameTimestamp;
  private FloatBuffer particleDataBuffer;
  private ParticleItemX particleItemX;
  private List<RenderParam> renderParams;
  private int templateIndex;
  
  public ParticleXFilter(StickerItem paramStickerItem, String paramString, int paramInt)
  {
    super(paramStickerItem, paramString);
    AppMethodBeat.i(82720);
    this.particleItemX = new ParticleItemX();
    this.lastFrameTimestamp = -1L;
    this.fastRenderFilter = new FastRenderFilter();
    this.renderParams = new ArrayList();
    this.templateIndex = paramInt;
    this.particleDataBuffer = ByteBuffer.allocateDirect(paramStickerItem.transition.particleCountMax * 6 * 2 * 32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    AppMethodBeat.o(82720);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82721);
    super.ApplyGLSLFilter();
    this.fastRenderFilter.applyGLSLFilter();
    this.fastRenderFilter.setBlendMode(this.item.blendMode);
    AppMethodBeat.o(82721);
  }
  
  public void clearGLSLSelf()
  {
    AppMethodBeat.i(82726);
    super.clearGLSLSelf();
    this.fastRenderFilter.clearGLSLSelf();
    ParticleSystemX.getInstance().release();
    AppMethodBeat.o(82726);
  }
  
  protected void clearTextureParam()
  {
    AppMethodBeat.i(82723);
    super.clearTextureParam();
    this.renderParams.clear();
    ParticleSystemX.getInstance().clearParticles(this.templateIndex);
    AppMethodBeat.o(82723);
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(82725);
    BenchUtil.benchStart("fastRenderFilter.render");
    this.fastRenderFilter.render(paramInt1, this.renderParams, null, true);
    BenchUtil.benchEnd("fastRenderFilter.render");
    AppMethodBeat.o(82725);
    return true;
  }
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    AppMethodBeat.i(82722);
    this.renderParams.clear();
    long l = System.currentTimeMillis();
    if (this.lastFrameTimestamp != -1L) {
      this.frameInterval = ((float)(l - this.lastFrameTimestamp) * 1.0F / 1000.0F);
    }
    this.lastFrameTimestamp = l;
    float f1;
    Object localObject;
    float f2;
    switch (this.item.type)
    {
    case 3: 
    default: 
      paramArrayOfFloat = ParticleSystemX.getInstance();
      i = this.templateIndex;
      paramFloat = this.particleItemX.emitterX;
      f1 = this.particleItemX.emitterY;
      localObject = this.particleDataBuffer;
      f2 = this.frameInterval;
      if ((paramList == null) || (paramList.isEmpty())) {
        break;
      }
    }
    int k;
    for (boolean bool = true;; bool = false)
    {
      i = paramArrayOfFloat.advanceByTemplate(i, paramFloat, f1, (FloatBuffer)localObject, f2, bool);
      paramArrayOfFloat = new float[i * 6];
      this.particleDataBuffer.position(0);
      this.particleDataBuffer.get(paramArrayOfFloat);
      paramList = new ParticleX[i];
      i = 0;
      while (i < paramList.length)
      {
        localObject = new ParticleX();
        ((ParticleX)localObject).startX = paramArrayOfFloat[(i * 6 + 0)];
        ((ParticleX)localObject).startY = paramArrayOfFloat[(i * 6 + 1)];
        ((ParticleX)localObject).positionX = paramArrayOfFloat[(i * 6 + 2)];
        ((ParticleX)localObject).positionY = paramArrayOfFloat[(i * 6 + 3)];
        ((ParticleX)localObject).scale = paramArrayOfFloat[(i * 6 + 4)];
        ((ParticleX)localObject).rotate = paramArrayOfFloat[(i * 6 + 5)];
        paramList[i] = localObject;
        i += 1;
      }
      if (this.width / this.height >= 0.75D)
      {
        k = (int)(this.width / 0.75D);
        i = (int)(k * this.item.position[1]);
        j = (int)(this.width * this.item.position[0]);
        k = (k - this.height) / 2;
        this.particleItemX.emitterX = j;
        this.particleItemX.emitterY = (i - k);
        this.particleItemX.screenRatioScale = (this.width * 1.0F / 720.0F);
        break;
      }
      k = (int)(this.height * 0.75D);
      i = (int)(this.height * this.item.position[1]);
      j = (int)(k * this.item.position[0]);
      k = (k - this.width) / 2;
      this.particleItemX.emitterX = (j - k);
      this.particleItemX.emitterY = i;
      this.particleItemX.screenRatioScale = (this.height * 1.0F / 960.0F);
      break;
      if ((paramList == null) || (paramList.isEmpty())) {
        break;
      }
      paramArrayOfFloat = (PointF)paramList.get(this.item.alignFacePoints[0]);
      if (this.item.alignFacePoints.length == 1) {}
      for (i = this.item.alignFacePoints[0];; i = this.item.alignFacePoints[1])
      {
        localObject = (PointF)paramList.get(i);
        paramArrayOfFloat = new PointF((paramArrayOfFloat.x + ((PointF)localObject).x) / 2.0F, (paramArrayOfFloat.y + ((PointF)localObject).y) / 2.0F);
        paramArrayOfFloat.x = ((float)(paramArrayOfFloat.x / this.mFaceDetScale));
        paramArrayOfFloat.y = ((float)(paramArrayOfFloat.y / this.mFaceDetScale));
        this.particleItemX.emitterX = paramArrayOfFloat.x;
        this.particleItemX.emitterY = paramArrayOfFloat.y;
        break;
      }
    }
    int m = paramList.length;
    int i = 0;
    if (i < m)
    {
      paramArrayOfFloat = paramList[i];
      switch (this.item.transition.emissionMode)
      {
      default: 
        paramFloat = 0.0F;
        f1 = 0.0F;
        label769:
        k = 0;
        if (this.item.anchorPoint != null) {
          k = this.item.anchorPoint[0];
        }
        break;
      }
    }
    for (int j = this.item.anchorPoint[1];; j = 0)
    {
      paramFloat -= k;
      f1 -= j;
      f2 = paramFloat + this.item.width * this.particleItemX.screenRatioScale;
      float f3 = this.item.height * this.particleItemX.screenRatioScale + f1;
      localObject = new RenderParam();
      ((RenderParam)localObject).texture = getTextureId();
      ((RenderParam)localObject).texCords = GlUtil.ORIGIN_TEX_COORDS_TRIANGLES;
      ((RenderParam)localObject).texScale = paramArrayOfFloat.scale;
      ((RenderParam)localObject).texAnchor[0] = ((paramFloat + f2) / 2.0F - this.width / 2);
      ((RenderParam)localObject).texAnchor[1] = ((f3 + f1) / 2.0F - this.height / 2);
      ((RenderParam)localObject).texRotate[2] = paramArrayOfFloat.rotate;
      ((RenderParam)localObject).position = AlgoUtils.calPositionsTriangles(paramFloat, f3, f2, f1, this.width, this.height);
      this.renderParams.add(localObject);
      i += 1;
      break;
      paramFloat = paramArrayOfFloat.startX;
      float f4 = paramArrayOfFloat.positionX;
      float f5 = this.particleItemX.screenRatioScale;
      f1 = paramArrayOfFloat.startY;
      f2 = paramArrayOfFloat.positionY;
      f3 = this.particleItemX.screenRatioScale;
      paramFloat += f4 * f5;
      f1 += f2 * f3;
      break label769;
      paramFloat = this.particleItemX.emitterX;
      f4 = paramArrayOfFloat.positionX;
      f5 = this.particleItemX.screenRatioScale;
      f1 = this.particleItemX.emitterY;
      f2 = paramArrayOfFloat.positionY;
      f3 = this.particleItemX.screenRatioScale;
      paramFloat += f4 * f5;
      f1 += f2 * f3;
      break label769;
      paramFloat = paramArrayOfFloat.positionX;
      f3 = this.particleItemX.screenRatioScale;
      f1 = paramArrayOfFloat.positionY;
      f2 = this.particleItemX.screenRatioScale;
      paramFloat *= f3;
      f1 *= f2;
      break label769;
      AppMethodBeat.o(82722);
      return;
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(82724);
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.fastRenderFilter.updateVideoSize(paramInt1, paramInt2);
    AppMethodBeat.o(82724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.filter.ParticleXFilter
 * JD-Core Version:    0.7.0.1
 */