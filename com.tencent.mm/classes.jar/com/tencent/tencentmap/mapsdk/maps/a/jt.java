package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.l;
import com.tencent.map.lib.element.m;
import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.cj;
import com.tencent.tencentmap.mapsdk.a.dc;
import com.tencent.tencentmap.mapsdk.a.dd;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.opengles.GL10;

public class jt
  extends jx
{
  private static AtomicInteger S;
  protected kd A;
  protected boolean B;
  protected int C;
  protected int D;
  protected float E;
  protected float F;
  public int G;
  public int H;
  private boolean R;
  private Runnable T;
  private Runnable U;
  private kd.a V;
  private kd.b W;
  protected l a;
  protected Bitmap b;
  boolean c;
  protected byte[] d;
  protected float e;
  protected boolean f;
  protected float g;
  protected float h;
  protected float i;
  protected String j;
  String k;
  public int l;
  public int m;
  protected GeoPoint n;
  protected GeoPoint o;
  protected GeoPoint p;
  protected float q;
  protected float r;
  protected float s;
  public boolean t;
  public boolean u;
  public boolean v;
  protected kx w;
  public dc x;
  public dd y;
  protected cj z;
  
  static
  {
    AppMethodBeat.i(148769);
    S = new AtomicInteger(0);
    AppMethodBeat.o(148769);
  }
  
  public jt(kx paramkx)
  {
    AppMethodBeat.i(148754);
    this.b = null;
    this.c = false;
    this.d = new byte[0];
    this.e = 0.0F;
    this.f = false;
    this.g = 0.0F;
    this.h = 0.0F;
    this.i = -1.0F;
    this.j = null;
    this.k = null;
    this.l = 0;
    this.m = 0;
    this.R = false;
    this.n = null;
    this.o = null;
    this.p = null;
    this.q = 1.0F;
    this.r = 1.0F;
    this.s = 1.0F;
    this.t = false;
    this.u = false;
    this.v = true;
    this.w = null;
    this.x = null;
    this.y = null;
    this.z = null;
    this.A = null;
    this.B = false;
    this.C = 0;
    this.D = 0;
    this.E = 0.5F;
    this.F = 0.5F;
    this.G = 0;
    this.H = 0;
    this.T = new jt.1(this);
    this.U = new jt.2(this);
    this.V = new jt.3(this);
    this.W = new jt.4(this);
    this.w = paramkx;
    i();
    AppMethodBeat.o(148754);
  }
  
  private void b(dd paramdd)
  {
    AppMethodBeat.i(148766);
    if ((paramdd == null) || (this.a != null))
    {
      AppMethodBeat.o(148766);
      return;
    }
    paramdd = d(paramdd);
    if (paramdd == null)
    {
      AppMethodBeat.o(148766);
      return;
    }
    this.a = new l(paramdd);
    AppMethodBeat.o(148766);
  }
  
  private void c(dd paramdd)
  {
    AppMethodBeat.i(148767);
    if (paramdd == null)
    {
      AppMethodBeat.o(148767);
      return;
    }
    paramdd = d(paramdd);
    if (paramdd == null)
    {
      AppMethodBeat.o(148767);
      return;
    }
    if (this.a == null)
    {
      this.a = new l(paramdd);
      AppMethodBeat.o(148767);
      return;
    }
    this.a.a(paramdd);
    AppMethodBeat.o(148767);
  }
  
  private m d(dd paramdd)
  {
    AppMethodBeat.i(148768);
    if (paramdd == null)
    {
      AppMethodBeat.o(148768);
      return null;
    }
    int i1 = paramdd.s();
    int i2 = paramdd.t();
    float f1 = this.E;
    float f2 = i1 * 1.0F / this.l;
    float f3 = this.F;
    float f4 = i2 * 1.0F / this.m;
    paramdd = new m().a(paramdd.k()).a(f1 - f2, f3 - f4).a(paramdd.s(), paramdd.t()).b(false).b((int)paramdd.l()).c(paramdd.x()).d(this.B).a(true);
    AppMethodBeat.o(148768);
    return paramdd;
  }
  
  private void i()
  {
    AppMethodBeat.i(148765);
    m localm = new m();
    if (this.a == null)
    {
      this.a = new l(localm);
      AppMethodBeat.o(148765);
      return;
    }
    this.a.a(localm);
    AppMethodBeat.o(148765);
  }
  
  public void a(float paramFloat)
  {
    this.e = paramFloat;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148756);
    this.C = paramInt1;
    this.D = paramInt2;
    if (this.a != null)
    {
      b(true);
      GeoPoint localGeoPoint = new GeoPoint(this.D, this.C);
      this.a.a(localGeoPoint);
    }
    AppMethodBeat.o(148756);
  }
  
  protected void a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(148757);
    synchronized (this.d)
    {
      this.j = (paramBitmap.hashCode() + S.getAndIncrement());
      if (this.a != null) {
        this.a.a(this.j, new Bitmap[] { paramBitmap });
      }
      this.l = paramBitmap.getWidth();
      this.m = paramBitmap.getHeight();
      AppMethodBeat.o(148757);
      return;
    }
  }
  
  public void a(dd paramdd)
  {
    AppMethodBeat.i(148755);
    if (paramdd == null)
    {
      AppMethodBeat.o(148755);
      return;
    }
    this.y = paramdd;
    a(paramdd.i());
    a(paramdd.o());
    b(paramdd.k());
    a_(paramdd.x());
    c(paramdd);
    AppMethodBeat.o(148755);
  }
  
  public void a(kd paramkd)
  {
    AppMethodBeat.i(148762);
    this.A = paramkd;
    if (this.A != null)
    {
      this.A.a(this.V);
      this.A.a(this.W);
    }
    AppMethodBeat.o(148762);
  }
  
  public void a(GL10 paramGL10)
  {
    AppMethodBeat.i(148760);
    if (!a())
    {
      AppMethodBeat.o(148760);
      return;
    }
    b(this.y);
    b(paramGL10);
    paramGL10 = this.w.b().x();
    if ((paramGL10 != null) && (this.a != null)) {
      this.a.b(paramGL10, this.w.b().t());
    }
    AppMethodBeat.o(148760);
  }
  
  public void a(boolean paramBoolean)
  {
    this.O = paramBoolean;
  }
  
  public boolean a()
  {
    return this.O;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    boolean bool = false;
    AppMethodBeat.i(148761);
    if ((!this.v) || (this.a == null))
    {
      AppMethodBeat.o(148761);
      return false;
    }
    Rect localRect;
    if (this.a != null)
    {
      bool = this.a.a(this.w.b().t(), paramFloat1, paramFloat2);
      localRect = this.a.b(this.w.b().t());
      if ((bool != true) || (localRect == null)) {
        break label118;
      }
      this.G = ((int)paramFloat1 - localRect.left);
    }
    for (this.H = ((int)paramFloat2 - localRect.top);; this.H = -1)
    {
      AppMethodBeat.o(148761);
      return bool;
      label118:
      this.G = -1;
    }
  }
  
  public void b() {}
  
  public void b(float paramFloat)
  {
    this.q = paramFloat;
  }
  
  public void b(Bitmap paramBitmap)
  {
    AppMethodBeat.i(148758);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(148758);
      return;
    }
    a(paramBitmap);
    e();
    AppMethodBeat.o(148758);
  }
  
  public void b(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }
  
  protected boolean b(GL10 paramGL10)
  {
    AppMethodBeat.i(148764);
    if (this.A != null)
    {
      this.A.d();
      if (this.A.c() == true) {
        this.w.b().a();
      }
      AppMethodBeat.o(148764);
      return true;
    }
    AppMethodBeat.o(148764);
    return false;
  }
  
  public void c() {}
  
  public void d()
  {
    this.w = null;
    this.n = null;
  }
  
  public void e()
  {
    AppMethodBeat.i(148759);
    synchronized (this.d)
    {
      if ((this.b != null) && (!this.b.isRecycled())) {
        this.c = true;
      }
      AppMethodBeat.o(148759);
      return;
    }
  }
  
  public void f()
  {
    if (this.o != null) {
      this.R = true;
    }
  }
  
  public boolean g()
  {
    AppMethodBeat.i(148763);
    if (this.A == null)
    {
      AppMethodBeat.o(148763);
      return false;
    }
    boolean bool = this.A.a(this.n, this.p);
    AppMethodBeat.o(148763);
    return bool;
  }
  
  protected void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jt
 * JD-Core Version:    0.7.0.1
 */