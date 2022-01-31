package com.tencent.ttpic.facedetect;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum FaceDetector$FACE_DETECT_MODE
{
  static
  {
    AppMethodBeat.i(81914);
    SINGLE = new FACE_DETECT_MODE("SINGLE", 0);
    MULTIPLE = new FACE_DETECT_MODE("MULTIPLE", 1);
    $VALUES = new FACE_DETECT_MODE[] { SINGLE, MULTIPLE };
    AppMethodBeat.o(81914);
  }
  
  private FaceDetector$FACE_DETECT_MODE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.facedetect.FaceDetector.FACE_DETECT_MODE
 * JD-Core Version:    0.7.0.1
 */