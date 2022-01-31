package com.tencent.tencentmap.mapsdk.maps.a;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

public class ii
  implements JNICallback.g, gv, ht, hx.a, is
{
  private static int c = 116307503;
  private static int d = 39984186;
  private ii.a A;
  private float B;
  private float C;
  private boolean D;
  private int E;
  private int F;
  private int G;
  private int H;
  private Runnable I;
  private boolean J;
  public hx a;
  public im b;
  private List<ho> e;
  private List<hk> f;
  private List<com.tencent.map.lib.gl.d> g;
  private List<hm> h;
  private final byte[] i;
  private List<hr> j;
  private List<hq> k;
  private List<ht> l;
  private List<ir> m;
  private final byte[] n;
  private List<ip> o;
  private List<hp> p;
  private List<hs> q;
  private boolean r;
  private Stack<iq> s;
  private WeakReference<ic> t;
  private hl u;
  private iq v;
  private hn w;
  private Rect x;
  private Rect y;
  private Handler z;
  
  public ii(hl paramhl)
  {
    AppMethodBeat.i(148343);
    this.i = new byte[0];
    this.n = new byte[0];
    this.r = true;
    this.s = new Stack();
    this.z = null;
    this.A = null;
    this.B = 0.5F;
    this.C = 0.5F;
    this.D = true;
    this.E = 0;
    this.F = 0;
    this.G = 0;
    this.H = 0;
    this.J = false;
    this.u = paramhl;
    this.t = paramhl.b();
    this.v = paramhl.e();
    this.w = ((hn)paramhl.d());
    this.x = paramhl.g();
    this.a = new hx(this);
    this.a.a(this);
    a(this.a);
    this.b = new im(paramhl);
    this.j = new CopyOnWriteArrayList();
    this.k = new CopyOnWriteArrayList();
    this.e = new CopyOnWriteArrayList();
    this.f = new CopyOnWriteArrayList();
    this.g = new CopyOnWriteArrayList();
    this.o = new CopyOnWriteArrayList();
    this.p = new CopyOnWriteArrayList();
    this.q = new CopyOnWriteArrayList();
    this.l = new CopyOnWriteArrayList();
    a(ig.a(1));
    this.z = new Handler();
    AppMethodBeat.o(148343);
  }
  
  private PointF E()
  {
    AppMethodBeat.i(148345);
    int i2;
    int i1;
    if (this.x != null)
    {
      i2 = this.x.width();
      i1 = this.x.height();
    }
    for (;;)
    {
      int i3 = this.E;
      int i4 = (i2 - i3 - this.G) / 2;
      int i5 = this.F;
      int i6 = (i1 - i5 - this.H) / 2;
      if ((i2 != 0) && (i1 != 0))
      {
        localPointF = new PointF((i4 + i3) * 1.0F / i2, (i6 + i5) * 1.0F / i1);
        AppMethodBeat.o(148345);
        return localPointF;
      }
      PointF localPointF = new PointF(0.5F, 0.5F);
      AppMethodBeat.o(148345);
      return localPointF;
      i1 = 0;
      i2 = 0;
    }
  }
  
  private boolean F()
  {
    AppMethodBeat.i(148347);
    if ((this.x != null) && (this.x.width() > 0) && (this.x.height() > 0))
    {
      AppMethodBeat.o(148347);
      return true;
    }
    AppMethodBeat.o(148347);
    return false;
  }
  
  private void G()
  {
    AppMethodBeat.i(148353);
    if (this.m == null)
    {
      AppMethodBeat.o(148353);
      return;
    }
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      ir localir = (ir)localIterator.next();
      if (localir != null) {
        try
        {
          localir.a(this.v);
        }
        catch (Exception localException) {}
      }
    }
    z();
    AppMethodBeat.o(148353);
  }
  
  private void H()
  {
    AppMethodBeat.i(148388);
    this.v.a(0.0F);
    this.v.b(0.0F);
    a(0.0D);
    b(0.0D);
    G();
    AppMethodBeat.o(148388);
  }
  
  private boolean I()
  {
    AppMethodBeat.i(148404);
    if (m() < this.v.m())
    {
      AppMethodBeat.o(148404);
      return true;
    }
    AppMethodBeat.o(148404);
    return false;
  }
  
  private boolean J()
  {
    AppMethodBeat.i(148405);
    if (m() > this.v.l())
    {
      AppMethodBeat.o(148405);
      return true;
    }
    AppMethodBeat.o(148405);
    return false;
  }
  
  private void K()
  {
    AppMethodBeat.i(148412);
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      ho localho = (ho)localIterator.next();
      if (localho != null) {
        try
        {
          localho.c_();
        }
        catch (Exception localException) {}
      }
    }
    G();
    AppMethodBeat.o(148412);
  }
  
  private void L()
  {
    AppMethodBeat.i(148438);
    if localif = this.u.f();
    if ((t()) && (this.D)) {}
    for (boolean bool = true;; bool = false)
    {
      localif.c(bool);
      AppMethodBeat.o(148438);
      return;
    }
  }
  
  private void a(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    AppMethodBeat.i(148401);
    double d1 = k(paramDouble1 - o());
    double d2 = paramDouble2 - p();
    if ((d1 == 0.0D) && (d2 == 0.0D))
    {
      AppMethodBeat.o(148401);
      return;
    }
    com.tencent.map.lib.d.a("postRotateAndSkew distance:" + d1 + "," + d2);
    long l1 = System.currentTimeMillis();
    float f1 = (float)(0.1000000014901161D * d1);
    float f2 = (float)(0.1000000014901161D * d2);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      c(new ii.2(this, 102, new double[] { paramDouble1, paramDouble2, 0.0D, 0.0D }, paramBoolean, l1, f1, f2, d1, d2, paramDouble1, paramDouble2));
      AppMethodBeat.o(148401);
      return;
    }
  }
  
  private void c(int paramInt)
  {
    AppMethodBeat.i(148413);
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      hk localhk = (hk)localIterator.next();
      if (localhk != null) {
        try
        {
          localhk.a(paramInt);
        }
        catch (Exception localException) {}
      }
    }
    K();
    AppMethodBeat.o(148413);
  }
  
  private void d(int paramInt)
  {
    AppMethodBeat.i(148427);
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
    {
      ip localip = (ip)localIterator.next();
      if (localip != null) {
        try
        {
          localip.a(paramInt);
        }
        catch (Exception localException) {}
      }
    }
    G();
    AppMethodBeat.o(148427);
  }
  
  private void d(hv paramhv)
  {
    AppMethodBeat.i(148406);
    switch (paramhv.a)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(148406);
      return;
      if ((this.t != null) && (this.t.get() != null))
      {
        ((ic)this.t.get()).a_();
        AppMethodBeat.o(148406);
        return;
        a(paramhv.b[0], paramhv.b[1]);
        AppMethodBeat.o(148406);
        return;
        g(paramhv.b[0]);
        AppMethodBeat.o(148406);
        return;
        h(paramhv.b[0]);
        AppMethodBeat.o(148406);
        return;
        int i6 = this.u.g().width();
        int i5 = this.u.g().height();
        int i4 = i6 / 2;
        int i3 = i5 / 2;
        iq.b localb = D().q();
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
        double d2 = paramhv.b[1];
        double d3 = i2;
        double d4 = paramhv.b[2];
        double d5 = paramhv.b[3] - i1;
        double d6 = paramhv.b[4] - i2;
        com.tencent.map.lib.d.a("Debug ScaleFix innerPerform        before   center:" + this.v.p().toString());
        a(d1 - d2, d3 - d4);
        g(paramhv.b[0]);
        com.tencent.map.lib.d.a("Debug ScaleFix innerPerform        after      center:" + this.v.p().toString());
        a(d5, d6);
        com.tencent.map.lib.d.a("Debug ScaleFix finally scale move by:" + d5 + "," + d6 + " curCenter:" + this.v.p().toString());
        AppMethodBeat.o(148406);
        return;
        e(paramhv.b[0]);
        c(paramhv.b[1]);
        AppMethodBeat.o(148406);
        return;
        i1 = this.u.g().width() / 2;
        i2 = this.u.g().height() / 2;
        a(i1 - paramhv.b[1], i2 - paramhv.b[2]);
        e(paramhv.b[0]);
        a(paramhv.b[3] - i1, paramhv.b[4] - i2);
        AppMethodBeat.o(148406);
        return;
        f(paramhv.b[0]);
        AppMethodBeat.o(148406);
        return;
        d(paramhv.b[0]);
        AppMethodBeat.o(148406);
        return;
        H();
        AppMethodBeat.o(148406);
        return;
        if (paramhv.b.length > 2) {}
        for (i1 = (int)paramhv.b[2];; i1 = 1)
        {
          a((int)paramhv.b[0], (int)paramhv.b[1], i1);
          AppMethodBeat.o(148406);
          return;
        }
        h(paramhv.b[0]);
        a((int)paramhv.b[1], (int)paramhv.b[2]);
        AppMethodBeat.o(148406);
        return;
        if (paramhv.f != null)
        {
          paramhv.f.run();
          AppMethodBeat.o(148406);
          return;
          if (this.A != null) {
            this.A.a(paramhv);
          }
        }
      }
    }
  }
  
  private void d(boolean paramBoolean)
  {
    AppMethodBeat.i(148415);
    if (this.h == null)
    {
      AppMethodBeat.o(148415);
      return;
    }
    boolean bool = t();
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      hm localhm = (hm)localIterator.next();
      if (localhm != null) {
        try
        {
          localhm.a(bool, paramBoolean);
        }
        catch (Exception localException) {}
      }
    }
    AppMethodBeat.o(148415);
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
    AppMethodBeat.i(148433);
    this.a.j();
    AppMethodBeat.o(148433);
  }
  
  public boolean B()
  {
    return this.r;
  }
  
  boolean C()
  {
    AppMethodBeat.i(148436);
    boolean bool = this.a.k();
    AppMethodBeat.o(148436);
    return bool;
  }
  
  public iq D()
  {
    return this.v;
  }
  
  public float a(Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(148371);
    GeoPoint localGeoPoint = new GeoPoint(paramRect1.top, paramRect1.left);
    paramRect1 = new GeoPoint(paramRect1.bottom, paramRect1.right);
    Rect localRect = new Rect();
    localRect.left = Math.min(localGeoPoint.getLongitudeE6(), paramRect1.getLongitudeE6());
    localRect.right = Math.max(localGeoPoint.getLongitudeE6(), paramRect1.getLongitudeE6());
    localRect.top = Math.min(localGeoPoint.getLatitudeE6(), paramRect1.getLatitudeE6());
    localRect.bottom = Math.max(localGeoPoint.getLatitudeE6(), paramRect1.getLatitudeE6());
    float f1 = (float)this.u.f().a(localRect, paramRect2);
    AppMethodBeat.o(148371);
    return f1;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(148344);
    this.E = paramInt1;
    this.F = paramInt2;
    this.G = paramInt3;
    this.H = paramInt4;
    Object localObject;
    if ((this.x != null) && (this.x.width() > 0) && (this.x.height() > 0))
    {
      if ((paramInt1 + paramInt3 > this.x.width()) || (paramInt2 + paramInt4 > this.x.height()))
      {
        AppMethodBeat.o(148344);
        return -1;
      }
      localObject = E();
      a(((PointF)localObject).x, ((PointF)localObject).y, false);
      AppMethodBeat.o(148344);
      return 0;
    }
    a(new ii.1(this));
    if ((this.u instanceof ik))
    {
      localObject = ((ik)this.u).k();
      if ((paramInt1 + paramInt3 > SystemUtil.getWindowWidth((Context)localObject)) || (paramInt2 + paramInt4 > SystemUtil.getWindowHeight((Context)localObject)))
      {
        AppMethodBeat.o(148344);
        return -1;
      }
      AppMethodBeat.o(148344);
      return 0;
    }
    AppMethodBeat.o(148344);
    return -2;
  }
  
  public void a()
  {
    AppMethodBeat.i(148435);
    x();
    AppMethodBeat.o(148435);
  }
  
  public void a(double paramDouble)
  {
    AppMethodBeat.i(148360);
    L();
    Iterator localIterator = this.p.iterator();
    while (localIterator.hasNext())
    {
      hp localhp = (hp)localIterator.next();
      if (localhp != null) {
        try
        {
          localhp.a(paramDouble);
        }
        catch (Exception localException) {}
      }
    }
    AppMethodBeat.o(148360);
  }
  
  public void a(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(148381);
    this.u.f().a((float)paramDouble1, (float)paramDouble2, false);
    c(1);
    G();
    AppMethodBeat.o(148381);
  }
  
  public void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5)
  {
    AppMethodBeat.i(148392);
    if (!t())
    {
      AppMethodBeat.o(148392);
      return;
    }
    this.a.j();
    c(new hv(103, new double[] { paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5 }));
    AppMethodBeat.o(148392);
  }
  
  public void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, Runnable paramRunnable)
  {
    AppMethodBeat.i(148393);
    this.a.j();
    float f1 = this.u.g().width() / 2.0F;
    float f2 = this.u.g().height() / 2.0F;
    iq.b localb = D().q();
    if (this.J)
    {
      if (localb == null) {
        break label181;
      }
      paramDouble2 = f1 + localb.a() * f1 * 2.0F;
    }
    for (paramDouble3 = localb.b() * f2 * 2.0F + f2;; paramDouble3 = f2)
    {
      paramDouble5 = paramDouble3;
      paramDouble4 = paramDouble2;
      c(new hv(101, new double[] { paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5 }));
      paramRunnable = new hv(paramRunnable);
      paramRunnable.e = false;
      paramRunnable.c = 0L;
      c(paramRunnable);
      AppMethodBeat.o(148393);
      return;
      label181:
      paramDouble2 = f1;
    }
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(148373);
    a(this.v.c(paramFloat));
    AppMethodBeat.o(148373);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148370);
    if (this.u != null)
    {
      if localif = this.u.f();
      if (localif != null)
      {
        localif.a(paramFloat1, paramFloat2, false);
        G();
      }
    }
    AppMethodBeat.o(148370);
  }
  
  public void a(float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(148409);
    if (this.v.a(paramFloat1 - 0.5F, paramFloat2 - 0.5F, paramBoolean)) {
      G();
    }
    AppMethodBeat.o(148409);
  }
  
  public void a(float paramFloat1, float paramFloat2, Runnable paramRunnable)
  {
    AppMethodBeat.i(148396);
    if (this.J)
    {
      iq.b localb = D().q();
      if (localb != null)
      {
        paramFloat1 = this.u.g().width() * (localb.a() + 0.5F);
        paramFloat2 = this.u.g().height() * (localb.b() + 0.5F);
      }
    }
    else
    {
      a(paramFloat1, paramFloat2, paramRunnable, null);
      AppMethodBeat.o(148396);
      return;
    }
    a(paramRunnable);
    AppMethodBeat.o(148396);
  }
  
  public void a(float paramFloat1, float paramFloat2, Runnable paramRunnable, hw paramhw)
  {
    AppMethodBeat.i(148397);
    if (!I())
    {
      AppMethodBeat.o(148397);
      return;
    }
    this.u.f().b(paramFloat1, paramFloat2);
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    AppMethodBeat.o(148397);
  }
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(148408);
    this.v.a(paramFloat1 - 0.5F, paramFloat2 - 0.5F, paramBoolean);
    if (paramBoolean) {
      G();
    }
    AppMethodBeat.o(148408);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(148366);
    if (this.v.b(paramInt)) {
      a(iq.c.c);
    }
    AppMethodBeat.o(148366);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148368);
    a(paramInt1, paramInt2, 1);
    AppMethodBeat.o(148368);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(148369);
    this.v.a(paramInt1, paramInt2, false);
    if (paramInt3 == 1)
    {
      c(paramInt3);
      G();
    }
    AppMethodBeat.o(148369);
  }
  
  public void a(int paramInt, Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(148429);
    this.u.f().b(paramInt, true);
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    AppMethodBeat.o(148429);
  }
  
  public void a(Rect paramRect)
  {
    AppMethodBeat.i(148357);
    if (!F())
    {
      AppMethodBeat.o(148357);
      return;
    }
    float f1 = a(paramRect, this.x);
    this.v.a(paramRect);
    this.v.e(f1);
    AppMethodBeat.o(148357);
  }
  
  public void a(Rect paramRect1, Rect paramRect2, boolean paramBoolean)
  {
    AppMethodBeat.i(148372);
    if (!F())
    {
      AppMethodBeat.o(148372);
      return;
    }
    Rect localRect1 = new Rect(this.x);
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
    this.u.f().a(localRect2, localRect1, paramBoolean);
    z();
    AppMethodBeat.o(148372);
  }
  
  public void a(e parame)
  {
    AppMethodBeat.i(148364);
    this.b.a(parame);
    AppMethodBeat.o(148364);
  }
  
  public void a(com.tencent.map.lib.gl.d paramd)
  {
    AppMethodBeat.i(148425);
    if (paramd == null)
    {
      AppMethodBeat.o(148425);
      return;
    }
    if (!this.g.contains(paramd)) {
      this.g.add(paramd);
    }
    AppMethodBeat.o(148425);
  }
  
  public void a(ho paramho)
  {
    AppMethodBeat.i(148423);
    if (paramho == null)
    {
      AppMethodBeat.o(148423);
      return;
    }
    synchronized (this.e)
    {
      if (!this.e.contains(paramho)) {
        this.e.add(paramho);
      }
      AppMethodBeat.o(148423);
      return;
    }
  }
  
  public void a(hp paramhp)
  {
    AppMethodBeat.i(148359);
    if (paramhp == null)
    {
      AppMethodBeat.o(148359);
      return;
    }
    synchronized (this.p)
    {
      if (!this.p.contains(paramhp)) {
        this.p.add(paramhp);
      }
      AppMethodBeat.o(148359);
      return;
    }
  }
  
  public void a(hr paramhr)
  {
    AppMethodBeat.i(148416);
    if (paramhr == null)
    {
      AppMethodBeat.o(148416);
      return;
    }
    synchronized (this.j)
    {
      if (!this.j.contains(paramhr)) {
        this.j.add(paramhr);
      }
      AppMethodBeat.o(148416);
      return;
    }
  }
  
  public void a(hs paramhs)
  {
    AppMethodBeat.i(148361);
    if (paramhs == null)
    {
      AppMethodBeat.o(148361);
      return;
    }
    synchronized (this.q)
    {
      com.tencent.map.lib.d.a("skew addSkewListener");
      if (!this.q.contains(paramhs)) {
        this.q.add(paramhs);
      }
      AppMethodBeat.o(148361);
      return;
    }
  }
  
  public void a(ht paramht)
  {
    AppMethodBeat.i(148420);
    if (paramht == null)
    {
      AppMethodBeat.o(148420);
      return;
    }
    synchronized (this.l)
    {
      if (!this.l.contains(paramht)) {
        this.l.add(paramht);
      }
      AppMethodBeat.o(148420);
      return;
    }
  }
  
  public void a(hv paramhv)
  {
    AppMethodBeat.i(148434);
    if (paramhv != null) {
      d(paramhv);
    }
    AppMethodBeat.o(148434);
  }
  
  public void a(ii.a parama)
  {
    this.A = parama;
  }
  
  public void a(iq.c paramc)
  {
    AppMethodBeat.i(148418);
    if (paramc == iq.c.a)
    {
      AppMethodBeat.o(148418);
      return;
    }
    if (this.z != null) {
      this.z.post(new ii.3(this, paramc));
    }
    AppMethodBeat.o(148418);
  }
  
  public void a(ir paramir)
  {
    AppMethodBeat.i(148352);
    if (paramir == null)
    {
      AppMethodBeat.o(148352);
      return;
    }
    if (this.m == null) {
      this.m = new CopyOnWriteArrayList();
    }
    synchronized (this.n)
    {
      if (!this.m.contains(paramir)) {
        this.m.add(paramir);
      }
      AppMethodBeat.o(148352);
      return;
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(148394);
    a(paramRunnable, null);
    AppMethodBeat.o(148394);
  }
  
  public void a(Runnable paramRunnable, hw paramhw)
  {
    AppMethodBeat.i(148395);
    if (!I())
    {
      AppMethodBeat.o(148395);
      return;
    }
    float f1 = this.u.g().width() / 2.0F;
    float f2 = this.u.g().height() / 2.0F;
    this.u.f().b(f1, f2);
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    AppMethodBeat.o(148395);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(148356);
    this.D = paramBoolean;
    L();
    AppMethodBeat.o(148356);
  }
  
  public Rect b()
  {
    AppMethodBeat.i(148346);
    Rect localRect = new Rect(this.E, this.F, this.G, this.H);
    AppMethodBeat.o(148346);
    return localRect;
  }
  
  public void b(double paramDouble)
  {
    AppMethodBeat.i(148363);
    L();
    com.tencent.map.lib.d.a("skew notifySkew");
    Iterator localIterator = this.q.iterator();
    while (localIterator.hasNext())
    {
      hs localhs = (hs)localIterator.next();
      if (localhs != null) {
        try
        {
          localhs.a(paramDouble);
        }
        catch (Exception localException) {}
      }
    }
    AppMethodBeat.o(148363);
  }
  
  public void b(float paramFloat)
  {
    AppMethodBeat.i(148376);
    f(paramFloat);
    AppMethodBeat.o(148376);
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(148407);
    if (this.v.a(paramInt)) {
      d(paramInt);
    }
    AppMethodBeat.o(148407);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148437);
    a(paramInt1, paramInt2);
    AppMethodBeat.o(148437);
  }
  
  public void b(Rect paramRect)
  {
    AppMethodBeat.i(148410);
    if ((this.x == null) || (paramRect == null))
    {
      AppMethodBeat.o(148410);
      return;
    }
    this.y = paramRect;
    if ((this.u instanceof ik)) {
      ((ik)this.u).a(paramRect);
    }
    G();
    AppMethodBeat.o(148410);
  }
  
  public void b(Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(148428);
    if (paramRect1 == null)
    {
      AppMethodBeat.o(148428);
      return;
    }
    if ((paramRect1.height() > 0) || (paramRect1.width() > 0)) {
      a(paramRect1, paramRect2, false);
    }
    c(1);
    AppMethodBeat.o(148428);
  }
  
  public void b(com.tencent.map.lib.gl.d paramd)
  {
    AppMethodBeat.i(148426);
    synchronized (this.g)
    {
      this.g.remove(paramd);
      AppMethodBeat.o(148426);
      return;
    }
  }
  
  public void b(ho paramho)
  {
    AppMethodBeat.i(148424);
    synchronized (this.e)
    {
      this.e.remove(paramho);
      AppMethodBeat.o(148424);
      return;
    }
  }
  
  public void b(hr paramhr)
  {
    AppMethodBeat.i(148417);
    synchronized (this.j)
    {
      this.j.remove(paramhr);
      AppMethodBeat.o(148417);
      return;
    }
  }
  
  public void b(hs paramhs)
  {
    AppMethodBeat.i(148362);
    synchronized (this.q)
    {
      com.tencent.map.lib.d.a("skew addSkewListener");
      this.q.remove(paramhs);
      AppMethodBeat.o(148362);
      return;
    }
  }
  
  public void b(ht paramht)
  {
    AppMethodBeat.i(148421);
    synchronized (this.l)
    {
      this.l.remove(paramht);
      AppMethodBeat.o(148421);
      return;
    }
  }
  
  public void b(hv paramhv)
  {
    AppMethodBeat.i(148389);
    this.a.j();
    c(paramhv);
    AppMethodBeat.o(148389);
  }
  
  public void b(Runnable paramRunnable)
  {
    AppMethodBeat.i(148398);
    b(paramRunnable, null);
    AppMethodBeat.o(148398);
  }
  
  public void b(Runnable paramRunnable, hw paramhw)
  {
    AppMethodBeat.i(148399);
    if (!J())
    {
      AppMethodBeat.o(148399);
      return;
    }
    this.u.f().s();
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    AppMethodBeat.o(148399);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(148439);
    if (paramBoolean)
    {
      if (this.I != null)
      {
        this.I.run();
        this.I = null;
      }
      G();
    }
    AppMethodBeat.o(148439);
  }
  
  public hx c()
  {
    AppMethodBeat.i(148348);
    this.a.a();
    hx localhx = this.a;
    AppMethodBeat.o(148348);
    return localhx;
  }
  
  public void c(double paramDouble)
  {
    AppMethodBeat.i(148382);
    if (paramDouble == 0.0D)
    {
      AppMethodBeat.o(148382);
      return;
    }
    float f1 = this.v.b(this.v.d() + (float)paramDouble);
    G();
    b(f1);
    AppMethodBeat.o(148382);
  }
  
  public void c(float paramFloat)
  {
    AppMethodBeat.i(148378);
    d(paramFloat);
    AppMethodBeat.o(148378);
  }
  
  public void c(hv paramhv)
  {
    AppMethodBeat.i(148432);
    this.a.a(paramhv);
    AppMethodBeat.o(148432);
  }
  
  public void c(boolean paramBoolean)
  {
    this.J = paramBoolean;
  }
  
  public void d()
  {
    AppMethodBeat.i(148349);
    if (this.a != null) {
      this.a.d();
    }
    AppMethodBeat.o(148349);
  }
  
  public void d(double paramDouble)
  {
    AppMethodBeat.i(148383);
    if (paramDouble == this.v.d())
    {
      AppMethodBeat.o(148383);
      return;
    }
    float f1 = this.v.b((float)paramDouble);
    G();
    b(f1);
    AppMethodBeat.o(148383);
  }
  
  public void e()
  {
    AppMethodBeat.i(148350);
    if (this.a != null) {
      this.a.c();
    }
    AppMethodBeat.o(148350);
  }
  
  public void e(double paramDouble)
  {
    AppMethodBeat.i(148384);
    if (paramDouble == 0.0D)
    {
      AppMethodBeat.o(148384);
      return;
    }
    float f1 = this.v.a(this.v.c() + (float)paramDouble);
    G();
    a(f1);
    AppMethodBeat.o(148384);
  }
  
  public void f()
  {
    AppMethodBeat.i(148351);
    if (this.a != null) {
      this.a.b();
    }
    AppMethodBeat.o(148351);
  }
  
  public void f(double paramDouble)
  {
    AppMethodBeat.i(148385);
    if (MathUtil.calShortestAngleDistance(paramDouble - this.v.c()) == 0.0D)
    {
      AppMethodBeat.o(148385);
      return;
    }
    float f1 = this.v.a((float)paramDouble);
    G();
    a(f1);
    AppMethodBeat.o(148385);
  }
  
  public hx g()
  {
    return this.a;
  }
  
  public void g(double paramDouble)
  {
    AppMethodBeat.i(148386);
    h(this.v.i() * (float)paramDouble);
    AppMethodBeat.o(148386);
  }
  
  public void h()
  {
    AppMethodBeat.i(148354);
    try
    {
      iq localiq = (iq)this.v.clone();
      com.tencent.map.lib.d.a("mapParam stack saveMapParam:" + localiq.toString());
      this.s.push(localiq);
      AppMethodBeat.o(148354);
      return;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      AppMethodBeat.o(148354);
    }
  }
  
  public void h(double paramDouble)
  {
    AppMethodBeat.i(148387);
    a((float)paramDouble);
    AppMethodBeat.o(148387);
  }
  
  public void i()
  {
    AppMethodBeat.i(148355);
    try
    {
      iq localiq = (iq)this.s.pop();
      if (localiq.j() != this.v.j()) {
        a(iq.c.c);
      }
      for (;;)
      {
        if (localiq.c() != this.v.c()) {
          a(localiq.c());
        }
        if (localiq.d() != this.v.d()) {
          b(localiq.d());
        }
        this.v.a(localiq);
        G();
        AppMethodBeat.o(148355);
        return;
        if (localiq.i() != this.v.i()) {
          a(iq.c.b);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(148355);
    }
  }
  
  public void i(double paramDouble)
  {
    AppMethodBeat.i(148390);
    this.a.j();
    c(new hv(102, new double[] { 0.0D, paramDouble }));
    AppMethodBeat.o(148390);
  }
  
  public iq j()
  {
    AppMethodBeat.i(148358);
    try
    {
      iq localiq = (iq)this.v.clone();
      AppMethodBeat.o(148358);
      return localiq;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      AppMethodBeat.o(148358);
    }
    return null;
  }
  
  public void j(double paramDouble)
  {
    AppMethodBeat.i(148391);
    this.a.j();
    c(new hv(108, new double[] { paramDouble }));
    AppMethodBeat.o(148391);
  }
  
  public void k()
  {
    AppMethodBeat.i(148365);
    GeoPoint localGeoPoint = new GeoPoint(d, c);
    this.v.a(this.u.g(), localGeoPoint.getLatitudeE6(), localGeoPoint.getLongitudeE6(), 13);
    G();
    L();
    AppMethodBeat.o(148365);
  }
  
  public float l()
  {
    AppMethodBeat.i(148367);
    float f1 = this.v.i();
    AppMethodBeat.o(148367);
    return f1;
  }
  
  public int m()
  {
    AppMethodBeat.i(148374);
    int i1 = this.v.j();
    AppMethodBeat.o(148374);
    return i1;
  }
  
  public GeoPoint n()
  {
    AppMethodBeat.i(148375);
    GeoPoint localGeoPoint = this.v.p();
    AppMethodBeat.o(148375);
    return localGeoPoint;
  }
  
  public float o()
  {
    AppMethodBeat.i(148377);
    float f1 = this.v.c();
    AppMethodBeat.o(148377);
    return f1;
  }
  
  public float p()
  {
    AppMethodBeat.i(148379);
    float f1 = this.v.d();
    AppMethodBeat.o(148379);
    return f1;
  }
  
  public float q()
  {
    AppMethodBeat.i(148380);
    float f1 = this.v.k();
    AppMethodBeat.o(148380);
    return f1;
  }
  
  public void r()
  {
    AppMethodBeat.i(148400);
    this.a.j();
    a(0.0D, 0.0D, true);
    AppMethodBeat.o(148400);
  }
  
  public void s()
  {
    AppMethodBeat.i(148402);
    d(false);
    r();
    AppMethodBeat.o(148402);
  }
  
  public boolean t()
  {
    AppMethodBeat.i(148403);
    if ((Math.abs(p()) > 1.0E-006D) || (Math.abs(o()) > 1.0F))
    {
      AppMethodBeat.o(148403);
      return true;
    }
    AppMethodBeat.o(148403);
    return false;
  }
  
  public int u()
  {
    AppMethodBeat.i(148411);
    int i1 = this.v.b();
    AppMethodBeat.o(148411);
    return i1;
  }
  
  public void v()
  {
    AppMethodBeat.i(148414);
    b(this.y);
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
    AppMethodBeat.o(148414);
  }
  
  public void w()
  {
    AppMethodBeat.i(148419);
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext())
    {
      hq localhq = (hq)localIterator.next();
      if (localhq != null) {
        try
        {
          localhq.a();
        }
        catch (Exception localException) {}
      }
    }
    AppMethodBeat.o(148419);
  }
  
  public void x()
  {
    AppMethodBeat.i(148422);
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      ht localht = (ht)localIterator.next();
      if (localht != null) {
        try
        {
          localht.a();
        }
        catch (Exception localException) {}
      }
    }
    AppMethodBeat.o(148422);
  }
  
  public Rect y()
  {
    AppMethodBeat.i(148430);
    Object localObject2 = new DoublePoint(this.u.g().width(), this.u.g().height());
    Object localObject1 = this.w.a((DoublePoint)localObject2);
    ((DoublePoint)localObject2).set(0.0D, 0.0D);
    localObject2 = this.w.a((DoublePoint)localObject2);
    localObject1 = new Rect(Math.min(((GeoPoint)localObject2).getLongitudeE6(), ((GeoPoint)localObject1).getLongitudeE6()), Math.min(((GeoPoint)localObject2).getLatitudeE6(), ((GeoPoint)localObject1).getLatitudeE6()), Math.max(((GeoPoint)localObject2).getLongitudeE6(), ((GeoPoint)localObject1).getLongitudeE6()), Math.max(((GeoPoint)localObject2).getLatitudeE6(), ((GeoPoint)localObject1).getLatitudeE6()));
    AppMethodBeat.o(148430);
    return localObject1;
  }
  
  public void z()
  {
    AppMethodBeat.i(148431);
    this.a.i();
    AppMethodBeat.o(148431);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ii
 * JD-Core Version:    0.7.0.1
 */