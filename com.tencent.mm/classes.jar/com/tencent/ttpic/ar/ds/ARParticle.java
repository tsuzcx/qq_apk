package com.tencent.ttpic.ar.ds;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.Point3D;

public class ARParticle
{
  public Point3D center;
  public float height;
  public Point3D leftBottom;
  public Point3D leftTop;
  public Point3D rightBottom;
  public Point3D rightTop;
  public float width;
  
  public ARParticle()
  {
    AppMethodBeat.i(81648);
    this.center = new Point3D();
    this.leftBottom = new Point3D();
    this.leftTop = new Point3D();
    this.rightTop = new Point3D();
    this.rightBottom = new Point3D();
    AppMethodBeat.o(81648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.ttpic.ar.ds.ARParticle
 * JD-Core Version:    0.7.0.1
 */