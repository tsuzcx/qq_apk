package com.tencent.ttpic.facedetect;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class FaceInfo
{
  public float[] angles;
  public float[] denseFaceModel;
  public List<PointF> irisPoints;
  public float pitch;
  public List<PointF> points;
  public float roll;
  public float scale;
  public float[] transform;
  public float tx;
  public float ty;
  public float yaw;
  
  public FaceInfo()
  {
    AppMethodBeat.i(81915);
    this.angles = new float[3];
    AppMethodBeat.o(81915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.facedetect.FaceInfo
 * JD-Core Version:    0.7.0.1
 */