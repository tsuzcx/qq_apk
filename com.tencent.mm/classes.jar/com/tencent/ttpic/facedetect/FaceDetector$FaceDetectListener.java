package com.tencent.ttpic.facedetect;

import android.graphics.PointF;
import java.util.List;

public abstract interface FaceDetector$FaceDetectListener
{
  public abstract void onFaceDetectResult(List<List<PointF>> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.facedetect.FaceDetector.FaceDetectListener
 * JD-Core Version:    0.7.0.1
 */