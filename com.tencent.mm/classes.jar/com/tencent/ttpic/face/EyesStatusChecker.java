package com.tencent.ttpic.face;

import com.tencent.ttpic.model.StickerItem.FeatureStatValueRange;

public class EyesStatusChecker
  implements FaceStatusChecker
{
  private static EyesStatusChecker instance = new EyesStatusChecker();
  
  public static EyesStatusChecker getInstance()
  {
    return instance;
  }
  
  public float getLevel(FaceRangeStatus paramFaceRangeStatus, StickerItem.FeatureStatValueRange paramFeatureStatValueRange)
  {
    return (paramFaceRangeStatus.leftEye + paramFaceRangeStatus.rightEye) / 2.0F;
  }
  
  public boolean isInRange(FaceRangeStatus paramFaceRangeStatus, StickerItem.FeatureStatValueRange paramFeatureStatValueRange)
  {
    if ((paramFaceRangeStatus == null) || (paramFeatureStatValueRange == null)) {}
    while ((paramFaceRangeStatus.leftEye < paramFeatureStatValueRange.min) || (paramFaceRangeStatus.leftEye > paramFeatureStatValueRange.max) || (paramFaceRangeStatus.rightEye < paramFeatureStatValueRange.min) || (paramFaceRangeStatus.rightEye > paramFeatureStatValueRange.max)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.face.EyesStatusChecker
 * JD-Core Version:    0.7.0.1
 */