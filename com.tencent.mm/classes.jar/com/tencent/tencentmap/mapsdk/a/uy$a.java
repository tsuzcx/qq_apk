package com.tencent.tencentmap.mapsdk.a;

import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;

public class uy$a
  extends FrameLayout.LayoutParams
{
  public int a = 1;
  private int b = 51;
  private ry c = null;
  private int d = 0;
  private int e = 0;
  
  public uy$a(int paramInt1, int paramInt2, ry paramry, int paramInt3)
  {
    this(paramInt1, paramInt2, paramry, 0, 0, paramInt3);
  }
  
  public uy$a(int paramInt1, int paramInt2, ry paramry, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramInt1, paramInt2);
    this.a = 0;
    a(paramry);
    this.d = paramInt3;
    this.e = paramInt4;
    this.b = paramInt5;
  }
  
  protected uy$a(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public ry a()
  {
    return this.c;
  }
  
  public void a(ry paramry)
  {
    this.c = paramry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.uy.a
 * JD-Core Version:    0.7.0.1
 */