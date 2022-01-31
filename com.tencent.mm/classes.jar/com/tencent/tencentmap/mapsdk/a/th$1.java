package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;

public class th$1
{
  protected float a = 0.9F;
  protected int b = 0;
  final Handler c = new tl(this);
  private ue.a d = ue.a.a;
  private int e = 256;
  private boolean f = true;
  private boolean g = true;
  private boolean h = false;
  private boolean i = true;
  private int j = 0;
  private int k = 0;
  private tn l;
  
  protected th$1(tn paramtn)
  {
    this.l = paramtn;
    new DisplayMetrics();
    int m = tn.a().getResources().getDisplayMetrics().densityDpi;
    if (m <= 120)
    {
      this.b = 1;
      this.a = 0.5F;
      return;
    }
    if (m <= 160)
    {
      this.b = 2;
      this.a = 0.8F;
      return;
    }
    if (m <= 240)
    {
      this.b = 3;
      this.a = 0.87F;
      return;
    }
    if (m <= 320)
    {
      this.a = 1.0F;
      this.b = 4;
      return;
    }
    if (m <= 480)
    {
      this.a = 1.5F;
      this.b = 5;
      return;
    }
    this.a = 1.8F;
    this.b = 6;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public void a(float paramFloat)
  {
    if (this.l != null) {
      this.l.a(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(int paramInt, int[] paramArrayOfInt)
  {
    if (this.l != null) {
      this.l.a(paramInt, paramArrayOfInt);
    }
  }
  
  public void a(ue.a parama)
  {
    this.d = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    this.c.obtainMessage(1).sendToTarget();
  }
  
  public float b()
  {
    return this.a;
  }
  
  public void b(int paramInt)
  {
    this.j = paramInt;
    this.l.b(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public ue.a c()
  {
    return this.d;
  }
  
  public void c(int paramInt)
  {
    this.k = paramInt;
    this.l.c(paramInt);
  }
  
  public void c(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public void d(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public boolean e()
  {
    return this.d == ue.a.b;
  }
  
  public int f()
  {
    return this.k;
  }
  
  public boolean g()
  {
    return this.h;
  }
  
  public boolean h()
  {
    return this.f;
  }
  
  public boolean i()
  {
    return this.g;
  }
  
  public int j()
  {
    return this.j;
  }
  
  public boolean k()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.th.1
 * JD-Core Version:    0.7.0.1
 */