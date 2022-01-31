package com.tencent.ttpic.model;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MeshDistortionType
{
  public float direction;
  public float faceDegree;
  public float faceRatio;
  public float offsetX;
  public float offsetY;
  public PointF point;
  public float radius;
  public float strength;
  public int type;
  
  public MeshDistortionType()
  {
    AppMethodBeat.i(83508);
    this.point = new PointF();
    AppMethodBeat.o(83508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.model.MeshDistortionType
 * JD-Core Version:    0.7.0.1
 */