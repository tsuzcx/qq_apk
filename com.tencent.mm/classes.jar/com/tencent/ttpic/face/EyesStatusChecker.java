package com.tencent.ttpic.face;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.StickerItem.ValueRange;

public class EyesStatusChecker
  implements FaceStatusChecker
{
  private static EyesStatusChecker instance;
  
  static
  {
    AppMethodBeat.i(81887);
    instance = new EyesStatusChecker();
    AppMethodBeat.o(81887);
  }
  
  public static EyesStatusChecker getInstance()
  {
    return instance;
  }
  
  public float getLevel(FaceRangeStatus paramFaceRangeStatus, StickerItem.ValueRange paramValueRange)
  {
    return (paramFaceRangeStatus.leftEye + paramFaceRangeStatus.rightEye) / 2.0F;
  }
  
  public boolean isInRange(FaceRangeStatus paramFaceRangeStatus, StickerItem.ValueRange paramValueRange)
  {
    if ((paramFaceRangeStatus == null) || (paramValueRange == null)) {}
    while ((paramFaceRangeStatus.leftEye < paramValueRange.min) || (paramFaceRangeStatus.leftEye > paramValueRange.max) || (paramFaceRangeStatus.rightEye < paramValueRange.min) || (paramFaceRangeStatus.rightEye > paramValueRange.max)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.face.EyesStatusChecker
 * JD-Core Version:    0.7.0.1
 */