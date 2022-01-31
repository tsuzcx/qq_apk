package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.f;

public class ll
  extends lk
{
  private boolean Q = false;
  private Bitmap R = null;
  private boolean S = false;
  private boolean T = false;
  private boolean U = true;
  private ll.a V = ll.a.a;
  private boolean W = false;
  private boolean X = true;
  private boolean Y = false;
  private qg Z = null;
  private final byte[] aa = new byte[0];
  private boolean ab = false;
  private boolean ac = false;
  private Bitmap ad;
  private Bitmap ae;
  private Bitmap af;
  private int ag = 0;
  private int ah = 0;
  private int ai = 0;
  
  public ll(ma paramma)
  {
    super(paramma);
    this.t = true;
  }
  
  private void e(boolean paramBoolean)
  {
    int i = this.m;
    if (this.ad != null) {
      i = this.ad.getHeight();
    }
    int j = i;
    if (i == 0) {
      j = 1;
    }
    if (paramBoolean)
    {
      this.F = (-(this.ai + 5.0F) / j);
      return;
    }
    this.F = ((this.ag + 5.0F + j) / j);
  }
  
  private void l()
  {
    int j = this.l;
    int i = j;
    if (j == 0) {
      i = 1;
    }
    this.E = (this.ah * 1.0F / i + 0.5F);
  }
  
  public void a(int paramInt)
  {
    this.ah = paramInt;
    l();
  }
  
  public void a(GeoPoint paramGeoPoint)
  {
    this.p = paramGeoPoint;
  }
  
  public void a(qg paramqg)
  {
    super.a(paramqg);
    this.Z = paramqg;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        d(true);
        if ((paramBoolean1) && (paramBoolean2))
        {
          this.Q = false;
          if (!this.X)
          {
            e();
            f();
            this.W = true;
            this.w.getMap().a();
          }
        }
        else
        {
          this.Q = true;
          continue;
        }
        if (paramBoolean1 != true) {
          break label78;
        }
      }
      finally {}
      this.V = ll.a.a;
      label78:
      if (!this.Y) {
        this.V = ll.a.d;
      }
      if ((paramBoolean1 == true) && (this.A != null) && (this.A.b()))
      {
        this.A.a();
        if (this.z != null) {
          this.z.b();
        }
      }
      if (this.V == ll.a.a)
      {
        this.V = ll.a.c;
        if (this.w.g != null)
        {
          a(this.w.g);
          g();
          continue;
        }
      }
      if (this.V == ll.a.c)
      {
        this.V = ll.a.d;
        if (this.w.i != null)
        {
          a(this.w.i);
          g();
        }
        else
        {
          e();
          f();
          this.W = true;
          this.w.getMap().a();
        }
      }
      else if (this.V == ll.a.d)
      {
        this.V = ll.a.b;
        if (this.w.h != null)
        {
          a(this.w.h);
          g();
        }
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.ag = paramInt1;
    this.ai = paramInt2;
    e(false);
  }
  
  public void b(Bitmap arg1)
  {
    if (??? == null) {
      return;
    }
    synchronized (this.d)
    {
      this.b = ???;
    }
    synchronized (this.aa)
    {
      if (!this.ac) {
        a(???);
      }
      synchronized (this.d)
      {
        if (this.W == true) {
          e();
        }
        return;
      }
      ??? = finally;
      throw ???;
    }
  }
  
  public void b(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint == null) {
      return;
    }
    if (this.o == null) {
      this.o = new GeoPoint(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6());
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.a(this.o);
      }
      if (this.W != true) {
        break;
      }
      f();
      return;
      this.o.setLatitudeE6(paramGeoPoint.getLatitudeE6());
      this.o.setLongitudeE6(paramGeoPoint.getLongitudeE6());
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.W = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    this.T = paramBoolean;
    this.w.getMap().a();
  }
  
  public void e()
  {
    synchronized (this.d)
    {
      if ((this.af != null) && (!this.af.isRecycled())) {
        this.c = true;
      }
      return;
    }
  }
  
  protected void h()
  {
    if (this.V == ll.a.d)
    {
      e();
      f();
      this.w.getMap().a();
    }
    if (this.V != ll.a.b)
    {
      a(false, false);
      return;
    }
    this.W = true;
    this.w.getMap().a();
  }
  
  public void i()
  {
    if (this.b != null)
    {
      this.b.recycle();
      this.b = null;
    }
    if (this.R != null)
    {
      this.R.recycle();
      this.R = null;
    }
    if (this.ad != null)
    {
      this.ad.recycle();
      this.ad = null;
    }
    if (this.ae != null)
    {
      this.ae.recycle();
      this.ae = null;
    }
    synchronized (this.d)
    {
      if (this.af != null)
      {
        this.af.recycle();
        this.af = null;
      }
      return;
    }
  }
  
  public boolean j()
  {
    return this.T;
  }
  
  public kl k()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ll
 * JD-Core Version:    0.7.0.1
 */