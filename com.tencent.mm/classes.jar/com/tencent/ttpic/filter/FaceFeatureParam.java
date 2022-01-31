package com.tencent.ttpic.filter;

public class FaceFeatureParam
{
  public float faceFeatureMultiplyAdjustValue = 0.8F;
  public String faceFeatureMultiplyImage = "beauty_multiply.png";
  public float faceFeatureNormalAdjustValue = 0.8F;
  public String faceFeatureNormalImage = "beauty_normal.png";
  public float faceFeatureSoftlightAdjustValue = 0.8F;
  public String faceFeatureSoftlightImage = "beauty_softlight.png";
  
  public FaceFeatureParam(float paramFloat)
  {
    this.faceFeatureNormalAdjustValue = paramFloat;
    this.faceFeatureMultiplyAdjustValue = paramFloat;
    this.faceFeatureSoftlightAdjustValue = paramFloat;
  }
  
  public FaceFeatureParam(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.faceFeatureNormalAdjustValue = paramFloat1;
    this.faceFeatureMultiplyAdjustValue = paramFloat2;
    this.faceFeatureSoftlightAdjustValue = paramFloat3;
  }
  
  public FaceFeatureParam(float paramFloat1, float paramFloat2, float paramFloat3, String paramString1, String paramString2, String paramString3)
  {
    this.faceFeatureNormalAdjustValue = paramFloat1;
    this.faceFeatureMultiplyAdjustValue = paramFloat2;
    this.faceFeatureSoftlightAdjustValue = paramFloat3;
    this.faceFeatureNormalImage = paramString1;
    this.faceFeatureMultiplyImage = paramString2;
    this.faceFeatureSoftlightImage = paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceFeatureParam
 * JD-Core Version:    0.7.0.1
 */