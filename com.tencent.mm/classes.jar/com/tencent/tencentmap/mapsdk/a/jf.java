package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.e;
import com.tencent.map.lib.gl.JNICallback.g;
import com.tencent.map.lib.util.MathUtil;
import com.tencent.map.lib.util.SystemUtil;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

public class jf
  implements JNICallback.g, hu, is, ix.a, jq
{
  private static int c = 116307503;
  private static int d = 39984186;
  private float A = 0.5F;
  private boolean B = true;
  private int C = 0;
  private int D = 0;
  private int E = 0;
  private int F = 0;
  private Runnable G;
  private boolean H = false;
  public ix a;
  public jj b;
  private List<in> e;
  private List<ij> f;
  private List<com.tencent.map.lib.gl.d> g;
  private List<il> h;
  private List<iq> i;
  private List<ip> j;
  private List<is> k;
  private List<jp> l;
  private List<jn> m;
  private List<io> n;
  private List<ir> o;
  private boolean p = true;
  private Stack<jo> q = new Stack();
  private WeakReference<jb> r;
  private ik s;
  private jo t;
  private im u;
  private Rect v;
  private Rect w;
  private Handler x = null;
  private jf.a y = null;
  private float z = 0.5F;
  
  public jf(ik paramik)
  {
    this.s = paramik;
    this.r = paramik.b();
    this.t = paramik.e();
    this.u = ((im)paramik.d());
    this.v = paramik.g();
    this.a = new ix(this);
    this.a.a(this);
    a(this.a);
    this.b = new jj(paramik);
    this.i = new CopyOnWriteArrayList();
    this.j = new CopyOnWriteArrayList();
    this.e = new CopyOnWriteArrayList();
    this.f = new CopyOnWriteArrayList();
    this.g = new CopyOnWriteArrayList();
    this.m = new CopyOnWriteArrayList();
    this.n = new CopyOnWriteArrayList();
    this.o = new CopyOnWriteArrayList();
    this.k = new CopyOnWriteArrayList();
    a(jd.a(1));
    this.x = new Handler();
  }
  
  private PointF E()
  {
    int i2;
    int i1;
    if (this.v != null)
    {
      i2 = this.v.width();
      i1 = this.v.height();
    }
    for (;;)
    {
      int i3 = this.C;
      int i4 = (i2 - this.C - this.E) / 2;
      int i5 = this.D;
      int i6 = (i1 - this.D - this.F) / 2;
      if ((i2 != 0) && (i1 != 0)) {
        return new PointF((i4 + i3) * 1.0F / i2, (i6 + i5) * 1.0F / i1);
      }
      return new PointF(0.5F, 0.5F);
      i1 = 0;
      i2 = 0;
    }
  }
  
  private boolean F()
  {
    return (this.v != null) && (this.v.width() > 0) && (this.v.height() > 0);
  }
  
  private void G()
  {
    if (this.l == null) {
      return;
    }
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      jp localjp = (jp)localIterator.next();
      if (localjp != null) {
        try
        {
          localjp.a(this.t);
        }
        catch (Exception localException) {}
      }
    }
    z();
  }
  
  private void H()
  {
    this.t.a(0.0F);
    this.t.b(0.0F);
    a(0.0D);
    b(0.0D);
    G();
  }
  
  private boolean I()
  {
    return m() < this.t.l();
  }
  
  private boolean J()
  {
    return m() > this.t.k();
  }
  
  private void K()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      in localin = (in)localIterator.next();
      if (localin != null) {
        try
        {
          localin.a();
        }
        catch (Exception localException) {}
      }
    }
    G();
  }
  
  private void L()
  {
    jc localjc = this.s.f();
    if ((t()) && (this.B)) {}
    for (boolean bool = true;; bool = false)
    {
      localjc.c(bool);
      return;
    }
  }
  
  private void a(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    double d1 = k(paramDouble1 - o());
    double d2 = paramDouble2 - p();
    if ((d1 == 0.0D) && (d2 == 0.0D)) {
      return;
    }
    com.tencent.map.lib.d.a("postRotateAndSkew distance:" + d1 + "," + d2);
    long l1 = System.currentTimeMillis();
    float f1 = (float)(0.1000000014901161D * d1);
    float f2 = (float)(0.1000000014901161D * d2);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      c(new jf.2(this, 102, new double[] { paramDouble1, paramDouble2, 0.0D, 0.0D }, paramBoolean, l1, f1, f2, d1, d2, paramDouble1, paramDouble2));
      return;
    }
  }
  
  private void c(int paramInt)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      ij localij = (ij)localIterator.next();
      if (localij != null) {
        try
        {
          localij.a(paramInt);
        }
        catch (Exception localException) {}
      }
    }
    K();
  }
  
  private void d(int paramInt)
  {
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      jn localjn = (jn)localIterator.next();
      if (localjn != null) {
        try
        {
          localjn.a(paramInt);
        }
        catch (Exception localException) {}
      }
    }
    G();
  }
  
  private void d(iv paramiv)
  {
    switch (paramiv.a)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.r == null) || (this.r.get() == null));
        ((jb)this.r.get()).f();
        return;
        a(paramiv.b[0], paramiv.b[1]);
        return;
        g(paramiv.b[0]);
        return;
        h(paramiv.b[0]);
        return;
        int i6 = this.s.g().width();
        int i5 = this.s.g().height();
        int i4 = i6 / 2;
        int i3 = i5 / 2;
        jo.b localb = D().p();
        int i2 = i3;
        int i1 = i4;
        if (localb != null)
        {
          float f1 = i4;
          float f2 = localb.a();
          i1 = (int)(f1 + i6 * f2);
          i2 = (int)(i3 + localb.b() * i5);
        }
        double d1 = i1;
        double d2 = paramiv.b[1];
        double d3 = i2;
        double d4 = paramiv.b[2];
        double d5 = paramiv.b[3] - i1;
        double d6 = paramiv.b[4] - i2;
        com.tencent.map.lib.d.a("Debug ScaleFix innerPerform        before   center:" + this.t.o().toString());
        a(d1 - d2, d3 - d4);
        g(paramiv.b[0]);
        com.tencent.map.lib.d.a("Debug ScaleFix innerPerform        after      center:" + this.t.o().toString());
        a(d5, d6);
        com.tencent.map.lib.d.a("Debug ScaleFix finally scale move by:" + d5 + "," + d6 + " curCenter:" + this.t.o().toString());
        return;
        e(paramiv.b[0]);
        c(paramiv.b[1]);
        return;
        i1 = this.s.g().width() / 2;
        i2 = this.s.g().height() / 2;
        a(i1 - paramiv.b[1], i2 - paramiv.b[2]);
        e(paramiv.b[0]);
        a(paramiv.b[3] - i1, paramiv.b[4] - i2);
        return;
        f(paramiv.b[0]);
        return;
        d(paramiv.b[0]);
        return;
        H();
        return;
        if (paramiv.b.length > 2) {}
        for (i1 = (int)paramiv.b[2];; i1 = 1)
        {
          a((int)paramiv.b[0], (int)paramiv.b[1], i1);
          return;
        }
        h(paramiv.b[0]);
        a((int)paramiv.b[1], (int)paramiv.b[2]);
        return;
      } while (paramiv.f == null);
      paramiv.f.run();
      return;
    } while (this.y == null);
    this.y.a(paramiv);
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.h == null) {}
    for (;;)
    {
      return;
      boolean bool = t();
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext())
      {
        il localil = (il)localIterator.next();
        if (localil != null) {
          try
          {
            localil.a(bool, paramBoolean);
          }
          catch (Exception localException) {}
        }
      }
    }
  }
  
  private double k(double paramDouble)
  {
    double d1 = paramDouble % 360.0D;
    if (d1 > 180.0D) {
      paramDouble = d1 - 360.0D;
    }
    do
    {
      return paramDouble;
      paramDouble = d1;
    } while (d1 >= -180.0D);
    return d1 + 360.0D;
  }
  
  public void A()
  {
    this.a.j();
  }
  
  public boolean B()
  {
    return this.p;
  }
  
  boolean C()
  {
    return this.a.k();
  }
  
  public jo D()
  {
    return this.t;
  }
  
  public float a(Rect paramRect1, Rect paramRect2)
  {
    GeoPoint localGeoPoint = new GeoPoint(paramRect1.top, paramRect1.left);
    paramRect1 = new GeoPoint(paramRect1.bottom, paramRect1.right);
    Rect localRect = new Rect();
    localRect.left = Math.min(localGeoPoint.getLongitudeE6(), paramRect1.getLongitudeE6());
    localRect.right = Math.max(localGeoPoint.getLongitudeE6(), paramRect1.getLongitudeE6());
    localRect.top = Math.min(localGeoPoint.getLatitudeE6(), paramRect1.getLatitudeE6());
    localRect.bottom = Math.max(localGeoPoint.getLatitudeE6(), paramRect1.getLatitudeE6());
    return (float)this.s.f().a(localRect, paramRect2);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.C = paramInt1;
    this.D = paramInt2;
    this.E = paramInt3;
    this.F = paramInt4;
    Object localObject;
    if ((this.v != null) && (this.v.width() > 0) && (this.v.height() > 0))
    {
      if ((paramInt1 + paramInt3 > this.v.width()) || (paramInt2 + paramInt4 > this.v.height())) {
        return -1;
      }
      localObject = E();
      a(((PointF)localObject).x, ((PointF)localObject).y, false);
      return 0;
    }
    a(new jf.1(this));
    if ((this.s instanceof jh))
    {
      localObject = ((jh)this.s).l();
      if ((paramInt1 + paramInt3 > SystemUtil.getWindowWidth((Context)localObject)) || (paramInt2 + paramInt4 > SystemUtil.getWindowHeight((Context)localObject))) {
        return -1;
      }
      return 0;
    }
    return -2;
  }
  
  public void a()
  {
    x();
  }
  
  public void a(double paramDouble)
  {
    L();
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext())
    {
      io localio = (io)localIterator.next();
      if (localio != null) {
        try
        {
          localio.a(paramDouble);
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public void a(double paramDouble1, double paramDouble2)
  {
    this.s.f().a((float)paramDouble1, (float)paramDouble2, false);
    c(1);
    G();
  }
  
  public void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5)
  {
    if (!t()) {
      return;
    }
    this.a.j();
    c(new iv(103, new double[] { paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5 }));
  }
  
  public void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, Runnable paramRunnable)
  {
    this.a.j();
    float f1 = this.s.g().width() / 2.0F;
    float f2 = this.s.g().height() / 2.0F;
    jo.b localb = D().p();
    if (this.H)
    {
      if (localb == null) {
        break label169;
      }
      paramDouble2 = f1 + localb.a() * f1 * 2.0F;
    }
    for (paramDouble3 = localb.b() * f2 * 2.0F + f2;; paramDouble3 = f2)
    {
      paramDouble5 = paramDouble3;
      paramDouble4 = paramDouble2;
      c(new iv(101, new double[] { paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5 }));
      paramRunnable = new iv(paramRunnable);
      paramRunnable.e = false;
      paramRunnable.c = 0L;
      c(paramRunnable);
      return;
      label169:
      paramDouble2 = f1;
    }
  }
  
  public void a(float paramFloat)
  {
    a(this.t.c(paramFloat));
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.s != null)
    {
      jc localjc = this.s.f();
      if (localjc != null)
      {
        localjc.a(paramFloat1, paramFloat2, false);
        G();
      }
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, Runnable paramRunnable)
  {
    if (this.H)
    {
      jo.b localb = D().p();
      if (localb != null)
      {
        paramFloat1 = this.s.g().width() * (localb.a() + 0.5F);
        paramFloat2 = this.s.g().height() * (localb.b() + 0.5F);
      }
    }
    else
    {
      a(paramFloat1, paramFloat2, paramRunnable, null);
      return;
    }
    a(paramRunnable);
  }
  
  public void a(float paramFloat1, float paramFloat2, Runnable paramRunnable, iw paramiw)
  {
    if (!I()) {}
    do
    {
      return;
      this.s.f().b(paramFloat1, paramFloat2);
    } while (paramRunnable == null);
    paramRunnable.run();
  }
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.t.a(paramFloat1 - 0.5F, paramFloat2 - 0.5F, paramBoolean);
    if (paramBoolean) {
      G();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.t.b(paramInt)) {
      a(jo.c.c);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, 1);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.t.a(paramInt1, paramInt2, false);
    if (paramInt3 == 1)
    {
      c(paramInt3);
      G();
    }
  }
  
  public void a(Rect paramRect)
  {
    if (!F()) {
      return;
    }
    float f1 = a(paramRect, this.v);
    this.t.a(paramRect);
    this.t.e(f1);
  }
  
  public void a(Rect paramRect1, Rect paramRect2, boolean paramBoolean)
  {
    if (!F()) {
      return;
    }
    Rect localRect1 = new Rect(this.v);
    if (paramRect2 != null)
    {
      localRect1.left += paramRect2.left;
      localRect1.right -= paramRect2.right;
      localRect1.top += paramRect2.top;
      localRect1.bottom -= paramRect2.bottom;
    }
    paramRect2 = new GeoPoint(paramRect1.top, paramRect1.left);
    paramRect1 = new GeoPoint(paramRect1.bottom, paramRect1.right);
    Rect localRect2 = new Rect();
    localRect2.left = Math.min(paramRect2.getLongitudeE6(), paramRect1.getLongitudeE6());
    localRect2.right = Math.max(paramRect2.getLongitudeE6(), paramRect1.getLongitudeE6());
    localRect2.top = Math.min(paramRect2.getLatitudeE6(), paramRect1.getLatitudeE6());
    localRect2.bottom = Math.max(paramRect2.getLatitudeE6(), paramRect1.getLatitudeE6());
    this.s.f().a(localRect2, localRect1, paramBoolean);
    z();
  }
  
  public void a(e parame)
  {
    this.b.a(parame);
  }
  
  public void a(com.tencent.map.lib.gl.d paramd)
  {
    if (paramd == null) {}
    while (this.g.contains(paramd)) {
      return;
    }
    this.g.add(paramd);
  }
  
  public void a(in paramin)
  {
    if (paramin == null) {
      return;
    }
    synchronized (this.e)
    {
      if (!this.e.contains(paramin)) {
        this.e.add(paramin);
      }
      return;
    }
  }
  
  public void a(io paramio)
  {
    if (paramio == null) {
      return;
    }
    synchronized (this.n)
    {
      if (!this.n.contains(paramio)) {
        this.n.add(paramio);
      }
      return;
    }
  }
  
  public void a(iq paramiq)
  {
    if (paramiq == null) {
      return;
    }
    synchronized (this.i)
    {
      if (!this.i.contains(paramiq)) {
        this.i.add(paramiq);
      }
      return;
    }
  }
  
  public void a(ir paramir)
  {
    if (paramir == null) {
      return;
    }
    synchronized (this.o)
    {
      com.tencent.map.lib.d.a("skew addSkewListener");
      if (!this.o.contains(paramir)) {
        this.o.add(paramir);
      }
      return;
    }
  }
  
  public void a(is paramis)
  {
    if (paramis == null) {
      return;
    }
    synchronized (this.k)
    {
      if (!this.k.contains(paramis)) {
        this.k.add(paramis);
      }
      return;
    }
  }
  
  public void a(iv paramiv)
  {
    if (paramiv != null) {
      d(paramiv);
    }
  }
  
  public void a(jf.a parama)
  {
    this.y = parama;
  }
  
  public void a(jo.c paramc)
  {
    if (paramc == jo.c.a) {}
    while (this.x == null) {
      return;
    }
    this.x.post(new jf.3(this, paramc));
  }
  
  public void a(jp paramjp)
  {
    if (paramjp == null) {
      return;
    }
    if (this.l == null) {
      this.l = new CopyOnWriteArrayList();
    }
    synchronized (this.l)
    {
      if (!this.l.contains(paramjp)) {
        this.l.add(paramjp);
      }
      return;
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    a(paramRunnable, null);
  }
  
  public void a(Runnable paramRunnable, iw paramiw)
  {
    if (!I()) {}
    do
    {
      return;
      float f1 = this.s.g().width() / 2.0F;
      float f2 = this.s.g().height() / 2.0F;
      this.s.f().b(f1, f2);
    } while (paramRunnable == null);
    paramRunnable.run();
  }
  
  public void a(boolean paramBoolean)
  {
    this.B = paramBoolean;
    L();
  }
  
  public Rect b()
  {
    return new Rect(this.C, this.D, this.E, this.F);
  }
  
  public void b(double paramDouble)
  {
    L();
    com.tencent.map.lib.d.a("skew notifySkew");
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
    {
      ir localir = (ir)localIterator.next();
      if (localir != null) {
        try
        {
          localir.a(paramDouble);
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public void b(float paramFloat)
  {
    f(paramFloat);
  }
  
  public void b(int paramInt)
  {
    if (this.t.a(paramInt)) {
      d(paramInt);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
  
  public void b(Rect paramRect)
  {
    if ((this.v == null) || (paramRect == null)) {
      return;
    }
    this.w = paramRect;
    if ((this.s instanceof jh)) {
      ((jh)this.s).a(paramRect);
    }
    G();
  }
  
  public void b(Rect paramRect1, Rect paramRect2)
  {
    if (paramRect1 == null) {
      return;
    }
    if ((paramRect1.height() > 0) || (paramRect1.width() > 0)) {
      a(paramRect1, paramRect2, false);
    }
    c(1);
  }
  
  public void b(com.tencent.map.lib.gl.d paramd)
  {
    synchronized (this.g)
    {
      this.g.remove(paramd);
      return;
    }
  }
  
  public void b(in paramin)
  {
    synchronized (this.e)
    {
      this.e.remove(paramin);
      return;
    }
  }
  
  public void b(iq paramiq)
  {
    synchronized (this.i)
    {
      this.i.remove(paramiq);
      return;
    }
  }
  
  public void b(ir paramir)
  {
    synchronized (this.o)
    {
      com.tencent.map.lib.d.a("skew addSkewListener");
      this.o.remove(paramir);
      return;
    }
  }
  
  public void b(is paramis)
  {
    synchronized (this.k)
    {
      this.k.remove(paramis);
      return;
    }
  }
  
  public void b(iv paramiv)
  {
    this.a.j();
    c(paramiv);
  }
  
  public void b(Runnable paramRunnable)
  {
    b(paramRunnable, null);
  }
  
  public void b(Runnable paramRunnable, iw paramiw)
  {
    if (!J()) {}
    do
    {
      return;
      this.s.f().v();
    } while (paramRunnable == null);
    paramRunnable.run();
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.G != null)
      {
        this.G.run();
        this.G = null;
      }
      G();
    }
  }
  
  public ix c()
  {
    this.a.a();
    return this.a;
  }
  
  public void c(double paramDouble)
  {
    if (paramDouble == 0.0D) {
      return;
    }
    float f1 = this.t.b(this.t.d() + (float)paramDouble);
    G();
    b(f1);
  }
  
  public void c(float paramFloat)
  {
    d(paramFloat);
  }
  
  public void c(iv paramiv)
  {
    this.a.a(paramiv);
  }
  
  public void c(boolean paramBoolean)
  {
    this.H = paramBoolean;
  }
  
  public void d()
  {
    if (this.a != null) {
      this.a.d();
    }
  }
  
  public void d(double paramDouble)
  {
    if (paramDouble == this.t.d()) {
      return;
    }
    float f1 = this.t.b((float)paramDouble);
    G();
    b(f1);
  }
  
  public void e()
  {
    if (this.a != null) {
      this.a.c();
    }
  }
  
  public void e(double paramDouble)
  {
    if (paramDouble == 0.0D) {
      return;
    }
    float f1 = this.t.a(this.t.c() + (float)paramDouble);
    G();
    a(f1);
  }
  
  public void f()
  {
    if (this.a != null) {
      this.a.b();
    }
  }
  
  public void f(double paramDouble)
  {
    if (MathUtil.calShortestAngleDistance(paramDouble - this.t.c()) == 0.0D) {
      return;
    }
    float f1 = this.t.a((float)paramDouble);
    G();
    a(f1);
  }
  
  public ix g()
  {
    return this.a;
  }
  
  public void g(double paramDouble)
  {
    h(this.t.h() * (float)paramDouble);
  }
  
  public void h()
  {
    try
    {
      jo localjo = (jo)this.t.clone();
      com.tencent.map.lib.d.a("mapParam stack saveMapParam:" + localjo.toString());
      this.q.push(localjo);
      return;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
  }
  
  public void h(double paramDouble)
  {
    a((float)paramDouble);
  }
  
  public void i()
  {
    try
    {
      jo localjo = (jo)this.q.pop();
      if (localjo.i() != this.t.i()) {
        a(jo.c.c);
      }
      for (;;)
      {
        if (localjo.c() != this.t.c()) {
          a(localjo.c());
        }
        if (localjo.d() != this.t.d()) {
          b(localjo.d());
        }
        this.t.a(localjo);
        G();
        return;
        if (localjo.h() != this.t.h()) {
          a(jo.c.b);
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void i(double paramDouble)
  {
    this.a.j();
    c(new iv(102, new double[] { 0.0D, paramDouble }));
  }
  
  public jo j()
  {
    try
    {
      jo localjo = (jo)this.t.clone();
      return localjo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public void j(double paramDouble)
  {
    this.a.j();
    c(new iv(108, new double[] { paramDouble }));
  }
  
  public void k()
  {
    GeoPoint localGeoPoint = new GeoPoint(d, c);
    this.t.a(this.s.g(), localGeoPoint.getLatitudeE6(), localGeoPoint.getLongitudeE6(), 18);
    G();
    L();
  }
  
  public float l()
  {
    return this.t.h();
  }
  
  public int m()
  {
    return this.t.i();
  }
  
  public GeoPoint n()
  {
    return this.t.o();
  }
  
  public float o()
  {
    return this.t.c();
  }
  
  public float p()
  {
    return this.t.d();
  }
  
  public float q()
  {
    return this.t.j();
  }
  
  public void r()
  {
    this.a.j();
    a(0.0D, 0.0D, true);
  }
  
  public void s()
  {
    d(false);
    r();
  }
  
  public boolean t()
  {
    return (Math.abs(p()) > 1.0E-006D) || (Math.abs(o()) > 1.0F);
  }
  
  public int u()
  {
    return this.t.b();
  }
  
  public void v()
  {
    b(this.w);
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.map.lib.gl.d locald = (com.tencent.map.lib.gl.d)localIterator.next();
      if (locald != null) {
        try
        {
          locald.a();
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public void w()
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      ip localip = (ip)localIterator.next();
      if (localip != null) {
        try
        {
          localip.a();
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public void x()
  {
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext())
    {
      is localis = (is)localIterator.next();
      if (localis != null) {
        try
        {
          localis.a();
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public Rect y()
  {
    Object localObject = new DoublePoint(this.s.g().width(), this.s.g().height());
    GeoPoint localGeoPoint = this.u.a((DoublePoint)localObject);
    ((DoublePoint)localObject).set(0.0D, 0.0D);
    localObject = this.u.a((DoublePoint)localObject);
    return new Rect(Math.min(((GeoPoint)localObject).getLongitudeE6(), localGeoPoint.getLongitudeE6()), Math.min(((GeoPoint)localObject).getLatitudeE6(), localGeoPoint.getLatitudeE6()), Math.max(((GeoPoint)localObject).getLongitudeE6(), localGeoPoint.getLongitudeE6()), Math.max(((GeoPoint)localObject).getLatitudeE6(), localGeoPoint.getLatitudeE6()));
  }
  
  public void z()
  {
    this.a.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.jf
 * JD-Core Version:    0.7.0.1
 */