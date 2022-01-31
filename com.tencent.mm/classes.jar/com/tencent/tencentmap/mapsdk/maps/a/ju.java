package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.l;
import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.cj;
import com.tencent.tencentmap.mapsdk.a.dd;

public class ju
  extends jt
{
  private boolean R;
  private Bitmap S;
  private boolean T;
  private boolean U;
  private boolean V;
  private ju.a W;
  private boolean X;
  private boolean Y;
  private boolean Z;
  private final byte[] aa;
  private boolean ab;
  private boolean ac;
  private Bitmap ad;
  private Bitmap ae;
  private Bitmap af;
  private int ag;
  private int ah;
  private int ai;
  
  public ju(kx paramkx)
  {
    super(paramkx);
    AppMethodBeat.i(148773);
    this.R = false;
    this.S = null;
    this.T = false;
    this.U = false;
    this.V = true;
    this.W = ju.a.a;
    this.X = false;
    this.Y = true;
    this.Z = false;
    this.aa = new byte[0];
    this.ab = false;
    this.ac = false;
    this.ag = 0;
    this.ah = 0;
    this.ai = 0;
    this.t = true;
    AppMethodBeat.o(148773);
  }
  
  private void f(boolean paramBoolean)
  {
    AppMethodBeat.i(148785);
    arrayOfByte = this.d;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        if (this.ad != null) {
          a(this.ad);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(148785);
      }
      if (this.b != null) {
        a(this.b);
      }
    }
  }
  
  private void g(boolean paramBoolean)
  {
    AppMethodBeat.i(148787);
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
      AppMethodBeat.o(148787);
      return;
    }
    this.F = ((this.ag + 5.0F + j) / j);
    AppMethodBeat.o(148787);
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
  
  public Rect a(hu paramhu)
  {
    AppMethodBeat.i(148782);
    synchronized (this.aa)
    {
      if (this.a != null)
      {
        e(false);
        f(false);
        paramhu = this.a.a(paramhu);
        e(this.ac);
        f(this.ac);
        AppMethodBeat.o(148782);
        return paramhu;
      }
      paramhu = new Rect(0, 0, 0, 0);
      AppMethodBeat.o(148782);
      return paramhu;
    }
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(148784);
    this.ah = paramInt;
    l();
    AppMethodBeat.o(148784);
  }
  
  public void a(GeoPoint paramGeoPoint)
  {
    this.p = paramGeoPoint;
  }
  
  public void a(dd paramdd)
  {
    AppMethodBeat.i(148774);
    super.a(paramdd);
    this.y = paramdd;
    AppMethodBeat.o(148774);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(148775);
        d(true);
        if ((paramBoolean1) && (paramBoolean2))
        {
          this.R = false;
          if (!this.Y)
          {
            e();
            f();
            this.X = true;
            this.w.b().a();
            AppMethodBeat.o(148775);
          }
        }
        else
        {
          this.R = true;
          continue;
        }
        if (paramBoolean1 != true) {
          break label88;
        }
      }
      finally {}
      this.W = ju.a.a;
      label88:
      if (!this.Z) {
        this.W = ju.a.d;
      }
      if ((paramBoolean1 == true) && (this.A != null) && (this.A.c()))
      {
        this.A.b();
        if (this.z != null) {
          this.z.b();
        }
      }
      if (this.W == ju.a.a)
      {
        this.W = ju.a.c;
        if (this.w.d != null)
        {
          a(this.w.d);
          g();
          AppMethodBeat.o(148775);
          continue;
        }
      }
      if (this.W == ju.a.c)
      {
        this.W = ju.a.d;
        if (this.w.f != null)
        {
          a(this.w.f);
          g();
          AppMethodBeat.o(148775);
        }
        else
        {
          e();
          f();
          this.X = true;
          this.w.b().a();
        }
      }
      else
      {
        if (this.W == ju.a.d)
        {
          this.W = ju.a.b;
          if (this.w.e != null)
          {
            a(this.w.e);
            g();
            AppMethodBeat.o(148775);
            continue;
          }
        }
        AppMethodBeat.o(148775);
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148783);
    this.ag = paramInt1;
    this.ai = paramInt2;
    g(false);
    AppMethodBeat.o(148783);
  }
  
  public void b(Bitmap arg1)
  {
    AppMethodBeat.i(148778);
    if (??? == null)
    {
      AppMethodBeat.o(148778);
      return;
    }
    synchronized (this.d)
    {
      this.b = ???;
      synchronized (this.aa)
      {
        if (!this.ac) {
          a(???);
        }
      }
    }
    synchronized (this.d)
    {
      if (this.X == true) {
        e();
      }
      AppMethodBeat.o(148778);
      return;
      ??? = finally;
      AppMethodBeat.o(148778);
      throw ???;
      ??? = finally;
      AppMethodBeat.o(148778);
      throw ???;
    }
  }
  
  public void b(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(148779);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(148779);
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
      if (this.X == true) {
        f();
      }
      AppMethodBeat.o(148779);
      return;
      this.o.setLatitudeE6(paramGeoPoint.getLatitudeE6());
      this.o.setLongitudeE6(paramGeoPoint.getLongitudeE6());
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.X = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    AppMethodBeat.i(148781);
    this.U = paramBoolean;
    this.w.b().a();
    AppMethodBeat.o(148781);
  }
  
  public void e()
  {
    AppMethodBeat.i(148777);
    synchronized (this.d)
    {
      if ((this.af != null) && (!this.af.isRecycled())) {
        this.c = true;
      }
      AppMethodBeat.o(148777);
      return;
    }
  }
  
  public void e(boolean paramBoolean)
  {
    AppMethodBeat.i(148786);
    g(paramBoolean);
    if (this.a != null) {
      this.a.a(this.E, this.F);
    }
    AppMethodBeat.o(148786);
  }
  
  protected void h()
  {
    AppMethodBeat.i(148776);
    if (this.W == ju.a.d)
    {
      e();
      f();
      this.w.b().a();
    }
    if (this.W != ju.a.b)
    {
      a(false, false);
      AppMethodBeat.o(148776);
      return;
    }
    this.X = true;
    this.w.b().a();
    AppMethodBeat.o(148776);
  }
  
  public void i()
  {
    AppMethodBeat.i(148780);
    if (this.b != null)
    {
      this.b.recycle();
      this.b = null;
    }
    if (this.S != null)
    {
      this.S.recycle();
      this.S = null;
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
      AppMethodBeat.o(148780);
      return;
    }
  }
  
  public boolean j()
  {
    return this.U;
  }
  
  public l k()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ju
 * JD-Core Version:    0.7.0.1
 */