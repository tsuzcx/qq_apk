package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.util.Comparator;

public final class uf
{
  private static final Comparator<uf> m = new uf.a((byte)0);
  private final int a;
  private final int b;
  private final int c;
  private ue.a d;
  private int e;
  private int f = 0;
  private sj g;
  private Bitmap h;
  private String i;
  private boolean j = true;
  private volatile boolean k = false;
  private tw l;
  
  public uf(sj paramsj, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, ue.a parama)
  {
    this.g = paramsj;
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = parama;
    this.e = paramInt5;
    this.f = paramInt4;
  }
  
  public uf(tw paramtw, int paramInt1, int paramInt2, int paramInt3)
  {
    this.g = paramtw.d();
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.l = paramtw;
    this.i = paramtw.e();
    this.j = paramtw.f();
  }
  
  public static Comparator<uf> k()
  {
    return m;
  }
  
  public final String a()
  {
    return this.i;
  }
  
  public final void a(Bitmap paramBitmap)
  {
    this.h = paramBitmap;
  }
  
  public final boolean a(Canvas paramCanvas)
  {
    if ((this.l != null) && (!this.l.c())) {}
    while ((this.h == null) || (this.h.isRecycled())) {
      return false;
    }
    try
    {
      paramCanvas.drawBitmap(this.h, 0.0F, 0.0F, null);
      return true;
    }
    catch (Exception paramCanvas)
    {
      if ((this.h != null) && (!this.h.isRecycled())) {
        this.h.recycle();
      }
      this.h = null;
    }
    return false;
  }
  
  public final boolean a(tw paramtw)
  {
    if (this.l == null) {
      return false;
    }
    return this.l.equals(paramtw);
  }
  
  public final byte[] a(boolean paramBoolean, String paramString)
  {
    try
    {
      if ((this.f != 7) || (this.d != ue.a.a))
      {
        sh localsh = this.g.a(this.a, this.b, this.c, this.d, new Object[] { Integer.valueOf(this.e), paramString, Boolean.valueOf(paramBoolean) });
        paramString = localsh;
        if (localsh != null) {
          return localsh.a();
        }
      }
      else
      {
        paramString = this.g.a(this.a, this.b, this.c, this.d, new Object[] { Integer.valueOf(this.e), Integer.valueOf(this.f) });
      }
      if (paramString != null)
      {
        paramString = paramString.a();
        return paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      new StringBuilder("get tile raises exception:").append(paramString.getMessage());
    }
    return null;
  }
  
  public final int b()
  {
    return this.a;
  }
  
  public final int c()
  {
    return this.b;
  }
  
  public final int d()
  {
    return this.c;
  }
  
  public final sj e()
  {
    return this.g;
  }
  
  public final Bitmap f()
  {
    return this.h;
  }
  
  public final boolean g()
  {
    return this.j;
  }
  
  public final void h()
  {
    this.k = true;
    if ((this.h != null) && (!this.h.isRecycled())) {
      this.h.recycle();
    }
    this.h = null;
  }
  
  public final boolean i()
  {
    return this.k;
  }
  
  public final float j()
  {
    if (this.l != null) {
      return this.l.a();
    }
    return (1.0F / -1.0F);
  }
  
  public final int l()
  {
    return this.e;
  }
  
  public final ue.a m()
  {
    return this.d;
  }
  
  public final int n()
  {
    return this.f;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(this.a);
    localStringBuilder.append("_");
    localStringBuilder.append(this.b);
    localStringBuilder.append("_");
    localStringBuilder.append(this.c);
    localStringBuilder.append("_");
    localStringBuilder.append(this.f);
    localStringBuilder.append("_");
    localStringBuilder.append(this.e);
    localStringBuilder.append("_");
    localStringBuilder.append(this.d);
    localStringBuilder.append("_");
    localStringBuilder.append(this.g.getClass().getCanonicalName());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.uf
 * JD-Core Version:    0.7.0.1
 */