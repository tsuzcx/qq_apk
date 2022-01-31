package com.tencent.ttpic.facedetect;

import android.graphics.PointF;
import java.util.List;

public class FaceInfo
{
  public float[] angles = new float[3];
  public float[] denseFaceModel;
  public float pitch;
  public List<PointF> points;
  public float roll;
  public float scale;
  public float[] transform;
  public float tx;
  public float ty;
  public float yaw;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.facedetect.FaceInfo
 * JD-Core Version:    0.7.0.1
 */