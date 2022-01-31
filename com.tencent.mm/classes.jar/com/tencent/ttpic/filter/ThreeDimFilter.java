package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.filter.m.d;
import com.tencent.filter.m.j;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.glmodel.Sphere;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.MatrixUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeDimFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SimpleFragmentShader.dat");
  private static final String VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ThreeDimVertexShader.dat");
  private StickerItem item;
  private Sphere mSphere;
  private String materialId;
  
  public ThreeDimFilter(StickerItem paramStickerItem, String paramString)
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER);
    this.item = paramStickerItem;
    this.mSphere = new Sphere(3, 1.0F);
    this.dataPath = paramString;
    this.materialId = VideoMaterialUtil.getMaterialId(paramString);
    initParams();
  }
  
  private Bitmap getNextFrame(int paramInt)
  {
    new StringBuilder().append(this.materialId).append(File.separator).append(this.item.id).append("_").append(paramInt).append(".png");
    return VideoMemoryManager.getInstance().loadImage(this.item.id, paramInt);
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    addAttribParam(new AttributeParam("color", new float[1], 3));
  }
  
  public void initParams()
  {
    addParam(new m.d("texRotate", 0.0F, 0.0F, 0.0F));
    addParam(new m.j("u_MVPMatrix", MatrixUtil.getMVPMatrix(2.0F, 1.0F, 3.0F)));
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glDisable(3042);
    GLES20.glEnable(2929);
    GLES20.glDepthFunc(515);
    GLES20.glDepthMask(true);
    GLES20.glClear(256);
    this.mSphere.draw(getAttribParam("position").handle, getAttribParam("inputTextureCoordinate").handle, getAttribParam("color").handle, this.mSTextureHandle);
    GLES20.glDisable(2929);
    return true;
  }
  
  public void updatePreview(List<PointF> paramList1, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, float paramFloat, long paramLong)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length < 3)) {
      return;
    }
    addParam(new m.d("texRotate", paramArrayOfFloat[0] * 2.0F, paramArrayOfFloat[1] * 2.0F, paramArrayOfFloat[2]));
    this.mSphere.loadGLTexture(getNextFrame(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.ThreeDimFilter
 * JD-Core Version:    0.7.0.1
 */