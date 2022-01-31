package com.tencent.ttpic.face;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.StickerItem.ValueRange;

public class SingleEyeStatusChecker
  implements FaceStatusChecker
{
  private static SingleEyeStatusChecker instance;
  
  static
  {
    AppMethodBeat.i(81907);
    instance = new SingleEyeStatusChecker();
    AppMethodBeat.o(81907);
  }
  
  public static SingleEyeStatusChecker getInstance()
  {
    return instance;
  }
  
  public float getLevel(FaceRangeStatus paramFaceRangeStatus, StickerItem.ValueRange paramValueRange)
  {
    AppMethodBeat.i(81906);
    float f = Math.max(paramFaceRangeStatus.leftEye, paramFaceRangeStatus.rightEye);
    AppMethodBeat.o(81906);
    return f;
  }
  
  public boolean isInRange(FaceRangeStatus paramFaceRangeStatus, StickerItem.ValueRange paramValueRange)
  {
    if ((paramFaceRangeStatus == null) || (paramValueRange == null)) {}
    while (((paramFaceRangeStatus.leftEye < paramValueRange.min) || (paramFaceRangeStatus.leftEye > paramValueRange.max)) && ((paramFaceRangeStatus.rightEye < paramValueRange.min) || (paramFaceRangeStatus.rightEye > paramValueRange.max))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.face.SingleEyeStatusChecker
 * JD-Core Version:    0.7.0.1
 */