package com.tencent.ttpic.ar.sensor.representation;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Vector3f
{
  protected float[] points;
  
  public Vector3f()
  {
    AppMethodBeat.i(81731);
    this.points = new float[3];
    AppMethodBeat.o(81731);
  }
  
  public Vector3f(float paramFloat)
  {
    AppMethodBeat.i(81730);
    this.points = new float[3];
    this.points[0] = paramFloat;
    this.points[1] = paramFloat;
    this.points[2] = paramFloat;
    AppMethodBeat.o(81730);
  }
  
  public Vector3f(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(81729);
    this.points = new float[3];
    this.points[0] = paramFloat1;
    this.points[1] = paramFloat2;
    this.points[2] = paramFloat3;
    AppMethodBeat.o(81729);
  }
  
  public Vector3f(Vector3f paramVector3f)
  {
    AppMethodBeat.i(81732);
    this.points = new float[3];
    this.points[0] = paramVector3f.points[0];
    this.points[1] = paramVector3f.points[1];
    this.points[2] = paramVector3f.points[2];
    AppMethodBeat.o(81732);
  }
  
  public Vector3f(Vector4f paramVector4f)
  {
    AppMethodBeat.i(81733);
    this.points = new float[3];
    if (paramVector4f.w() != 0.0F)
    {
      this.points[0] = (paramVector4f.x() / paramVector4f.w());
      this.points[1] = (paramVector4f.y() / paramVector4f.w());
      this.points[2] = (paramVector4f.z() / paramVector4f.w());
      AppMethodBeat.o(81733);
      return;
    }
    this.points[0] = paramVector4f.x();
    this.points[1] = paramVector4f.y();
    this.points[2] = paramVector4f.z();
    AppMethodBeat.o(81733);
  }
  
  public void add(float paramFloat)
  {
    float[] arrayOfFloat = this.points;
    arrayOfFloat[0] += paramFloat;
    arrayOfFloat = this.points;
    arrayOfFloat[1] += paramFloat;
    arrayOfFloat = this.points;
    arrayOfFloat[2] += paramFloat;
  }
  
  public void add(Vector3f paramVector3f)
  {
    float[] arrayOfFloat = this.points;
    arrayOfFloat[0] += paramVector3f.points[0];
    arrayOfFloat = this.points;
    arrayOfFloat[1] += paramVector3f.points[1];
    arrayOfFloat = this.points;
    arrayOfFloat[2] += paramVector3f.points[2];
  }
  
  public void crossProduct(Vector3f paramVector3f1, Vector3f paramVector3f2)
  {
    AppMethodBeat.i(81735);
    paramVector3f2.setX(this.points[1] * paramVector3f1.points[2] - this.points[2] * paramVector3f1.points[1]);
    paramVector3f2.setY(this.points[2] * paramVector3f1.points[0] - this.points[0] * paramVector3f1.points[2]);
    paramVector3f2.setZ(this.points[0] * paramVector3f1.points[1] - this.points[1] * paramVector3f1.points[0]);
    AppMethodBeat.o(81735);
  }
  
  public float dotProduct(Vector3f paramVector3f)
  {
    return this.points[0] * paramVector3f.points[0] + this.points[1] * paramVector3f.points[1] + this.points[2] * paramVector3f.points[2];
  }
  
  public float getLength()
  {
    AppMethodBeat.i(81736);
    float f = (float)Math.sqrt(this.points[0] * this.points[0] + this.points[1] * this.points[1] + this.points[2] * this.points[2]);
    AppMethodBeat.o(81736);
    return f;
  }
  
  public float getX()
  {
    return this.points[0];
  }
  
  public float getY()
  {
    return this.points[1];
  }
  
  public float getZ()
  {
    return this.points[2];
  }
  
  public void multiplyByScalar(float paramFloat)
  {
    float[] arrayOfFloat = this.points;
    arrayOfFloat[0] *= paramFloat;
    arrayOfFloat = this.points;
    arrayOfFloat[1] *= paramFloat;
    arrayOfFloat = this.points;
    arrayOfFloat[2] *= paramFloat;
  }
  
  public void normalize()
  {
    AppMethodBeat.i(81734);
    double d = Math.sqrt(this.points[0] * this.points[0] + this.points[1] * this.points[1] + this.points[2] * this.points[2]);
    this.points[0] = ((float)(this.points[0] / d));
    this.points[1] = ((float)(this.points[1] / d));
    this.points[2] = ((float)(this.points[2] / d));
    AppMethodBeat.o(81734);
  }
  
  public void set(Vector3f paramVector3f)
  {
    AppMethodBeat.i(81738);
    set(paramVector3f.points);
    AppMethodBeat.o(81738);
  }
  
  public void set(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(81739);
    System.arraycopy(paramArrayOfFloat, 0, this.points, 0, 3);
    AppMethodBeat.o(81739);
  }
  
  public void setX(float paramFloat)
  {
    this.points[0] = paramFloat;
  }
  
  public void setXYZ(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.points[0] = paramFloat1;
    this.points[1] = paramFloat2;
    this.points[2] = paramFloat3;
  }
  
  public void setY(float paramFloat)
  {
    this.points[1] = paramFloat;
  }
  
  public void setZ(float paramFloat)
  {
    this.points[2] = paramFloat;
  }
  
  public void subtract(Vector3f paramVector3f)
  {
    float[] arrayOfFloat = this.points;
    arrayOfFloat[0] -= paramVector3f.points[0];
    arrayOfFloat = this.points;
    arrayOfFloat[1] -= paramVector3f.points[1];
    arrayOfFloat = this.points;
    arrayOfFloat[2] -= paramVector3f.points[2];
  }
  
  public float[] toArray()
  {
    return this.points;
  }
  
  public String toString()
  {
    AppMethodBeat.i(81737);
    String str = "X:" + this.points[0] + " Y:" + this.points[1] + " Z:" + this.points[2];
    AppMethodBeat.o(81737);
    return str;
  }
  
  public float x()
  {
    return this.points[0];
  }
  
  public void x(float paramFloat)
  {
    this.points[0] = paramFloat;
  }
  
  public float y()
  {
    return this.points[1];
  }
  
  public void y(float paramFloat)
  {
    this.points[1] = paramFloat;
  }
  
  public float z()
  {
    return this.points[2];
  }
  
  public void z(float paramFloat)
  {
    this.points[2] = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.ar.sensor.representation.Vector3f
 * JD-Core Version:    0.7.0.1
 */