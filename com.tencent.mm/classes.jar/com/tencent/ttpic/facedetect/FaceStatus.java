package com.tencent.ttpic.facedetect;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FaceStatus
{
  public float[] denseFaceModel;
  public int illumination_score;
  public float pitch;
  public float roll;
  public float scale;
  public float[] transform;
  public float tx;
  public float ty;
  public float[] xys;
  public float yaw;
  
  public FaceStatus()
  {
    AppMethodBeat.i(49936);
    this.xys = new float['¼'];
    AppMethodBeat.o(49936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.facedetect.FaceStatus
 * JD-Core Version:    0.7.0.1
 */