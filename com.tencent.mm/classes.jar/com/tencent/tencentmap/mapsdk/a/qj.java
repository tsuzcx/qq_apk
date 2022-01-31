package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qj
{
  private final List<qc> a = new ArrayList();
  private float b = 1.0F;
  private int c = -16777216;
  private int d = lq.k;
  private int e = 0;
  private boolean f = true;
  private boolean g = false;
  private String h = "";
  private int i = -16777216;
  private Typeface j = Typeface.DEFAULT;
  private int k = 2147483647;
  private int l = 1;
  private int m = -1;
  
  public qj a(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      this.b = 1.0F;
      return this;
    }
    this.b = paramFloat;
    return this;
  }
  
  public qj a(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public qj a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public List<qc> a()
  {
    return this.a;
  }
  
  public void a(Iterable<qc> paramIterable)
  {
    if (this.a == null) {}
    do
    {
      return;
      this.a.clear();
    } while (paramIterable == null);
    b(paramIterable);
  }
  
  public float b()
  {
    return this.b;
  }
  
  public qj b(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public qj b(Iterable<qc> paramIterable)
  {
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        qc localqc = (qc)paramIterable.next();
        this.a.add(localqc);
      }
    }
    return this;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public qj c(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public float e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.f;
  }
  
  public String g()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.qj
 * JD-Core Version:    0.7.0.1
 */