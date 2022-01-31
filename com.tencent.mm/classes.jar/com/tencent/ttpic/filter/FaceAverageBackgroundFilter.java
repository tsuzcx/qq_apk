package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.filter.m.k;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.model.VideoMaterial.FaceImageLayer;
import com.tencent.ttpic.util.FaceOffUtil;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FaceAverageBackgroundFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = " precision mediump float;\n varying lowp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main(void) {\n         gl_FragColor = texture2D(inputImageTexture2, textureCoordinate);\n }";
  private static final String VERTEX_SHADER = " attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }";
  private VideoMaterial.FaceImageLayer mFaceLayer = null;
  private FaceItem mItem = null;
  private Bitmap materialBitmap = null;
  private int materialImageHeight = 0;
  private int materialImageWidth = 0;
  
  public FaceAverageBackgroundFilter(String paramString, VideoMaterial.FaceImageLayer paramFaceImageLayer)
  {
    super(" attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }", " precision mediump float;\n varying lowp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main(void) {\n         gl_FragColor = texture2D(inputImageTexture2, textureCoordinate);\n }");
    this.dataPath = paramString;
    this.mFaceLayer = paramFaceImageLayer;
    initParams();
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    float f1 = this.materialImageHeight / this.height;
    if (this.materialImageHeight / this.materialImageWidth > this.height / this.width) {
      f1 = this.materialImageWidth / this.width;
    }
    float f2 = this.materialImageWidth / f1;
    f1 = this.materialImageHeight / f1;
    float f3 = (f2 - this.width) / 2.0F / f2;
    float f4 = (f1 - this.height) / 2.0F / f1;
    float f5 = (f2 - this.width) / 2.0F / f2;
    float f6 = (f1 - this.height) / 2.0F / f1;
    float f7 = (f2 - this.width) / 2.0F / f2;
    float f8 = (f1 - this.height) / 2.0F / f1;
    addAttribParam("inputTextureCoordinate", new float[] { f5, f6, f3, 1.0F - f4, 1.0F - (f2 - this.width) / 2.0F / f2, 1.0F - (f1 - this.height) / 2.0F / f1, 1.0F - f7, f8 });
  }
  
  public void initParams()
  {
    if ((this.materialBitmap == null) && (this.mFaceLayer != null)) {
      this.materialBitmap = FaceOffUtil.getFaceBitmap(this.dataPath + File.separator + this.mFaceLayer.imagePath);
    }
    if (this.materialBitmap != null)
    {
      this.materialImageWidth = this.materialBitmap.getWidth();
      this.materialImageHeight = this.materialBitmap.getHeight();
    }
    addParam(new m.k("inputImageTexture2", this.materialBitmap, 33986, true));
  }
  
  public void updatePreview(List<PointF> paramList1, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, float paramFloat, long paramLong)
  {
    paramFloat = this.materialImageHeight / this.height;
    if (this.materialImageHeight / this.materialImageWidth > this.height / this.width) {
      paramFloat = this.materialImageWidth / this.width;
    }
    float f1 = this.materialImageWidth / paramFloat;
    paramFloat = this.materialImageHeight / paramFloat;
    float f2 = (f1 - this.width) / 2.0F / f1;
    float f3 = (paramFloat - this.height) / 2.0F / paramFloat;
    float f4 = (f1 - this.width) / 2.0F / f1;
    float f5 = (paramFloat - this.height) / 2.0F / paramFloat;
    float f6 = (f1 - this.width) / 2.0F / f1;
    float f7 = (paramFloat - this.height) / 2.0F / paramFloat;
    addAttribParam("inputTextureCoordinate", new float[] { f4, f5, f2, 1.0F - f3, 1.0F - (f1 - this.width) / 2.0F / f1, 1.0F - (paramFloat - this.height) / 2.0F / paramFloat, 1.0F - f6, f7 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceAverageBackgroundFilter
 * JD-Core Version:    0.7.0.1
 */