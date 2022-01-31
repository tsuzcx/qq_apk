package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.face.EmptyStatusChecker;
import com.tencent.ttpic.face.EyesStatusChecker;
import com.tencent.ttpic.face.FaceStatusChecker;
import com.tencent.ttpic.face.LeftEyeStatusChecker;
import com.tencent.ttpic.face.MouthStatusChecker;
import com.tencent.ttpic.face.RightEyeStatusChecker;
import com.tencent.ttpic.face.SingleEyeStatusChecker;

public enum VideoMaterialUtil$RANGE_TRIGGER_TYPE
{
  public final FaceStatusChecker checker;
  public final int value;
  
  static
  {
    AppMethodBeat.i(84122);
    NO_CHECK = new RANGE_TRIGGER_TYPE("NO_CHECK", 0, 0, EmptyStatusChecker.getInstance());
    EYES = new RANGE_TRIGGER_TYPE("EYES", 1, 1, EyesStatusChecker.getInstance());
    MOUTH = new RANGE_TRIGGER_TYPE("MOUTH", 2, 2, MouthStatusChecker.getInstance());
    SINGLE_EYE = new RANGE_TRIGGER_TYPE("SINGLE_EYE", 3, 3, SingleEyeStatusChecker.getInstance());
    LEFT_EYE = new RANGE_TRIGGER_TYPE("LEFT_EYE", 4, 4, LeftEyeStatusChecker.getInstance());
    RIGHT_EYE = new RANGE_TRIGGER_TYPE("RIGHT_EYE", 5, 5, RightEyeStatusChecker.getInstance());
    $VALUES = new RANGE_TRIGGER_TYPE[] { NO_CHECK, EYES, MOUTH, SINGLE_EYE, LEFT_EYE, RIGHT_EYE };
    AppMethodBeat.o(84122);
  }
  
  private VideoMaterialUtil$RANGE_TRIGGER_TYPE(int paramInt, FaceStatusChecker paramFaceStatusChecker)
  {
    this.value = paramInt;
    this.checker = paramFaceStatusChecker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialUtil.RANGE_TRIGGER_TYPE
 * JD-Core Version:    0.7.0.1
 */