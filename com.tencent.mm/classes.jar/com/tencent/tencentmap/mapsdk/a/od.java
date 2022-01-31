package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Color;

public class od
{
  protected float K = 1.0F;
  protected int L = Color.argb(17, 0, 163, 255);
  protected int M = Color.argb(255, 0, 163, 255);
  protected float N = 0.0F;
  protected boolean O = true;
  protected boolean P = false;
  
  public void a_(boolean paramBoolean)
  {
    this.O = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.M = paramInt;
    this.P = true;
  }
  
  public void c(float paramFloat)
  {
    this.N = paramFloat;
    this.P = true;
  }
  
  public void c(int paramInt)
  {
    this.L = paramInt;
    this.P = true;
  }
  
  public void d(float paramFloat)
  {
    this.K = paramFloat;
    this.P = true;
  }
  
  public float x()
  {
    return this.N;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.od
 * JD-Core Version:    0.7.0.1
 */