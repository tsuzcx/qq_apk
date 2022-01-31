package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.f;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.map.lib.util.SystemUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class nv
  extends pb
  implements nw, pj, pl
{
  private ma a = null;
  private Context b = null;
  private oo c = null;
  private mc d = null;
  private q e = null;
  private mb f = null;
  private final GeoPoint g = null;
  private final GeoPoint h = null;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  private byte[] m = new byte[0];
  private int n = 0;
  private float o = 1.0F;
  private final nv.b p = new nv.b(this, false);
  private final nv.b q = new nv.b(this, true);
  private jf.a r = new nv.1(this);
  private lx.a s = new lx.a()
  {
    public float a()
    {
      if (nv.a(nv.this) == null) {
        return 0.0F;
      }
      return nv.this.s();
    }
    
    public void a(Runnable paramAnonymousRunnable)
    {
      if (paramAnonymousRunnable == null) {}
      while ((nv.a(nv.this) == null) || (nv.a(nv.this).v == null)) {
        return;
      }
      nv.a(nv.this).v.postDelayed(paramAnonymousRunnable, 100L);
    }
    
    public int b()
    {
      if (nv.a(nv.this) == null) {
        return 0;
      }
      return ok.a(nv.a(nv.this).getMap().d());
    }
    
    public GeoPoint c()
    {
      if (nv.a(nv.this) == null) {
        return null;
      }
      return nv.a(nv.this).getMap().f();
    }
    
    public float d()
    {
      if (nv.a(nv.this) == null) {
        return 0.0F;
      }
      return nv.a(nv.this).getMap().q();
    }
    
    public float e()
    {
      if (nv.a(nv.this) == null) {
        return 0.0F;
      }
      return nv.a(nv.this).getMap().r();
    }
    
    public GeoPoint f()
    {
      if (nv.a(nv.this) == null) {
        return null;
      }
      return nv.a(nv.this).getNaviCenter();
    }
  };
  private boolean t = false;
  private is u = new nv.4(this);
  
  public nv(ViewGroup paramViewGroup, Context paramContext, ai paramai)
  {
    this.b = paramContext;
    this.o = SystemUtil.getDensity(paramContext);
    if (this.a == null)
    {
      this.a = new ma(this.b, paramai);
      this.a.a(this.b);
    }
    if (lq.t == null) {
      lq.t = new nu(10);
    }
    this.a.a(this);
    this.a.getMap().a(this.r);
    this.a.getMap().a(this.u);
    this.a.getMap().e(0, 0);
    a(false, false);
    paramContext = localObject;
    if (paramai != null)
    {
      paramContext = localObject;
      if (!StringUtil.isEmpty(paramai.f())) {
        paramContext = paramai.f();
      }
    }
    this.e = new q(this.b, paramContext);
    this.f = new mb(this.b, this.a.getMap(), paramContext);
    if (this.c == null) {
      this.c = new oo(paramViewGroup, this.a);
    }
    this.d = new mc(this, paramai);
  }
  
  private int a(qd paramqd, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, long paramLong, ah.a parama)
  {
    if (paramqd == null) {
      return -1;
    }
    if ((paramqd.b == null) || (paramqd.a == null)) {
      return -1;
    }
    if ((this.a.D == 0) || (this.a.E == 0))
    {
      this.a.w = paramqd.a;
      this.a.x = paramqd.b;
      this.a.z = paramInt1;
      this.a.A = paramInt2;
      this.a.B = paramInt3;
      this.a.C = paramInt4;
      this.a.F = parama;
      if (paramBoolean) {
        this.a.setOnSurfaceChangedListener(this.q);
      }
      for (;;)
      {
        int i1 = SystemUtil.getWindowWidth(this.b);
        int i2 = SystemUtil.getWindowHeight(this.b);
        if ((paramInt1 + paramInt2 <= i1) && (paramInt3 + paramInt4 <= i2)) {
          break;
        }
        return -1;
        this.a.setOnSurfaceChangedListener(this.p);
      }
      return 0;
    }
    this.a.setOnSurfaceChangedListener(null);
    GeoPoint localGeoPoint = new GeoPoint();
    float f1 = a(paramInt1, paramInt2, paramInt3, paramInt4, paramqd.a, paramqd.b, localGeoPoint);
    if (f1 < 0.0F) {
      return (int)f1;
    }
    paramInt1 = localGeoPoint.getLatitudeE6();
    paramInt2 = localGeoPoint.getLongitudeE6();
    if (!paramBoolean)
    {
      this.a.getMap().a(paramInt1, paramInt2);
      a(f1, false, paramLong, null);
      this.a.getMap().b(0.0F);
      this.a.getMap().a(0.0F);
    }
    for (;;)
    {
      return 0;
      paramqd = new lx(10000);
      paramqd.c(0.0F);
      paramqd.d(0.0F);
      paramqd.c(paramInt1, paramInt2);
      paramqd.a(f1);
      paramqd.a(this.s);
      paramqd.a(parama);
      paramqd.a(paramLong);
      this.a.getMap().a(paramqd);
    }
  }
  
  private int a(qd paramqd, int paramInt, boolean paramBoolean, long paramLong, ah.a parama)
  {
    if (paramqd == null) {
      return -1;
    }
    if ((paramqd.b == null) || (paramqd.a == null)) {
      return -1;
    }
    if ((this.a.D == 0) || (this.a.E == 0))
    {
      this.a.w = paramqd.a;
      this.a.x = paramqd.b;
      this.a.y = paramInt;
      this.a.F = parama;
      if (paramBoolean) {
        this.a.setOnSurfaceChangedListener(this.q);
      }
      for (;;)
      {
        i1 = SystemUtil.getWindowWidth(this.b);
        int i2 = SystemUtil.getWindowHeight(this.b);
        if ((paramInt * 2 <= i1) && (paramInt * 2 <= i2)) {
          break;
        }
        return -1;
        this.a.setOnSurfaceChangedListener(this.p);
      }
      return 0;
    }
    this.a.setOnSurfaceChangedListener(null);
    GeoPoint localGeoPoint = new GeoPoint();
    float f1 = a(paramInt, paramInt, paramInt, paramInt, paramqd.a, paramqd.b, localGeoPoint);
    if (f1 < 0.0F) {
      return (int)f1;
    }
    paramInt = localGeoPoint.getLatitudeE6();
    int i1 = localGeoPoint.getLongitudeE6();
    if (!paramBoolean)
    {
      this.a.getMap().a(paramInt, i1);
      a(f1, false, paramLong, null);
      this.a.getMap().b(0.0F);
      this.a.getMap().a(0.0F);
    }
    for (;;)
    {
      return 0;
      paramqd = new lx(10000);
      paramqd.c(0.0F);
      paramqd.d(0.0F);
      paramqd.c(paramInt, i1);
      paramqd.a(f1);
      paramqd.a(this.s);
      paramqd.a(parama);
      paramqd.a(paramLong);
      this.a.getMap().a(paramqd);
    }
  }
  
  private int a(List<pc> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, long paramLong, ah.a parama)
  {
    ii localii = (ii)this.a.getMap().u();
    if (localii == null) {
      return -2147483648;
    }
    if ((paramList == null) || (paramList.isEmpty())) {
      return -1;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      pc localpc = (pc)paramList.next();
      if ((localpc != null) && (localpc.a() != null)) {
        localArrayList.addAll(localpc.a());
      }
    }
    if ((this.a.D == 0) || (this.a.E == 0))
    {
      int i1 = SystemUtil.getWindowWidth(this.b);
      int i2 = SystemUtil.getWindowHeight(this.b);
      if ((paramInt1 + paramInt2 > i1) || (paramInt3 + paramInt4 > i2)) {
        return -1;
      }
      return 0;
    }
    if ((paramInt1 + paramInt2 > this.a.D) || (paramInt3 + paramInt4 > this.a.E)) {
      return -1;
    }
    localii.a(localArrayList, new Rect(paramInt1, paramInt3, paramInt2, paramInt4), new nv.3(this, paramBoolean, parama, paramLong));
    return 0;
  }
  
  private GeoPoint a(DoublePoint paramDoublePoint, GeoPoint paramGeoPoint)
  {
    double d3 = 2.684355E+008F * this.o;
    double d1 = d3 / 2.0D;
    double d2 = d3 / 360.0D;
    d3 /= 6.283185307179586D;
    d2 = (paramDoublePoint.x - d1) / d2;
    d1 = Math.asin(1.0D - 2.0D / (Math.pow(2.718281828459045D, (paramDoublePoint.y - d1) / 0.5D / d3) + 1.0D)) * 180.0D / 3.141592653589793D;
    paramDoublePoint = paramGeoPoint;
    if (paramGeoPoint == null) {
      paramDoublePoint = new GeoPoint(0, 0);
    }
    paramDoublePoint.setLatitudeE6((int)(d1 * 1000000.0D));
    paramDoublePoint.setLongitudeE6((int)(1000000.0D * d2));
    return paramDoublePoint;
  }
  
  private void a(double paramDouble1, double paramDouble2, float paramFloat, boolean paramBoolean, long paramLong, ah.a parama)
  {
    if (this.a == null) {
      return;
    }
    int i1 = (int)(1000000.0D * paramDouble1);
    int i2 = (int)(1000000.0D * paramDouble2);
    int i3 = ok.a(this.a.getMap().d());
    int i4 = this.a.getMap().b();
    if (paramFloat < i4) {
      paramFloat = i4;
    }
    for (;;)
    {
      float f1 = paramFloat;
      if (paramFloat > i3) {
        f1 = i3;
      }
      paramDouble1 = 1.0D / Math.pow(2.0D, i3 - f1);
      if (!paramBoolean)
      {
        this.a.getMap().a(i1, i2);
        this.a.getMap().c((float)paramDouble1);
        return;
      }
      lx locallx = new lx(10000);
      locallx.c(i1, i2);
      locallx.a(f1);
      locallx.a(this.s);
      locallx.a(parama);
      locallx.a(paramLong);
      this.a.getMap().a(locallx);
      return;
    }
  }
  
  private void a(double paramDouble1, double paramDouble2, boolean paramBoolean, long paramLong, ah.a parama)
  {
    if (this.a == null) {
      return;
    }
    int i1 = (int)(paramDouble1 * 1000000.0D);
    int i2 = (int)(1000000.0D * paramDouble2);
    if (!paramBoolean)
    {
      this.a.getMap().a(i1, i2);
      return;
    }
    lx locallx = new lx(10000);
    locallx.c(i1, i2);
    locallx.a(this.s);
    locallx.a(parama);
    locallx.a(paramLong);
    this.a.getMap().a(locallx);
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, long paramLong, ah.a parama)
  {
    if (this.a == null) {}
    while (paramFloat1 == 0.0F) {
      return;
    }
    if (!paramBoolean)
    {
      if (paramFloat1 < 0.0F) {}
      for (paramFloat1 = (float)(1.0D / Math.pow(2.0D, Math.abs(paramFloat1)));; paramFloat1 = (float)(1.0D / Math.pow(0.5D, Math.abs(paramFloat1))))
      {
        this.a.getMap().a(paramFloat1, paramFloat2, paramFloat3, paramFloat2, paramFloat3, null);
        return;
      }
    }
    lx locallx = new lx(10000);
    locallx.b((int)paramFloat2, (int)paramFloat3);
    locallx.b(paramFloat1);
    locallx.a(this.s);
    locallx.a(parama);
    locallx.a(paramLong);
    this.a.getMap().a(locallx);
  }
  
  private void a(float paramFloat1, float paramFloat2, boolean paramBoolean, long paramLong, ah.a parama)
  {
    if (this.a == null) {}
    while ((paramFloat1 == 0.0F) && (paramFloat2 == 0.0F)) {
      return;
    }
    if (!paramBoolean)
    {
      this.a.getMap().c((int)paramFloat1, (int)paramFloat2);
      return;
    }
    lx locallx = new lx(10000);
    locallx.a((int)paramFloat1, (int)paramFloat2);
    locallx.a(this.s);
    locallx.a(parama);
    locallx.a(paramLong);
    this.a.getMap().a(locallx);
  }
  
  private void a(float paramFloat, boolean paramBoolean, long paramLong, ah.a parama)
  {
    if (this.a == null) {
      return;
    }
    if (!paramBoolean)
    {
      int i1 = ok.a(this.a.getMap().d());
      float f1 = paramFloat;
      if (paramFloat >= i1) {
        f1 = i1;
      }
      double d1 = 1.0D / Math.pow(2.0D, i1 - f1);
      this.a.getMap().a((float)d1);
      return;
    }
    lx locallx = new lx(10000);
    locallx.a(paramFloat);
    locallx.a(this.s);
    locallx.a(parama);
    locallx.a(paramLong);
    this.a.getMap().a(locallx);
  }
  
  private void a(pu parampu, boolean paramBoolean, long paramLong, ah.a parama)
  {
    if (this.a == null) {}
    GeoPoint localGeoPoint;
    float f2;
    do
    {
      do
      {
        return;
      } while (parampu == null);
      localGeoPoint = lq.a(parampu.a);
      f2 = parampu.b;
      int i1 = ok.a(this.a.getMap().d());
      int i2 = this.a.getMap().b();
      float f1 = f2;
      if (f2 < i2) {
        f1 = i2;
      }
      f2 = f1;
      if (f1 > i1) {
        f2 = i1;
      }
      if (paramBoolean) {
        break;
      }
      double d1 = 1.0D / Math.pow(2.0D, i1 - f2);
      if (localGeoPoint != null) {
        this.a.getMap().a(localGeoPoint.getLatitudeE6(), localGeoPoint.getLongitudeE6());
      }
      this.a.getMap().c((float)d1);
      this.a.getMap().b(parampu.d);
    } while (parampu.c < 0.0F);
    this.a.getMap().a(parampu.c);
    return;
    lx locallx = new lx(10000);
    if (localGeoPoint != null) {
      locallx.c(localGeoPoint.getLatitudeE6(), localGeoPoint.getLongitudeE6());
    }
    locallx.a(f2);
    locallx.c(parampu.d);
    if (parampu.c >= 0.0F) {
      locallx.d(parampu.c);
    }
    locallx.a(this.s);
    locallx.a(paramLong);
    locallx.a(parama);
    this.a.getMap().a(locallx);
  }
  
  private void a(boolean paramBoolean, long paramLong, ah.a parama)
  {
    if (!paramBoolean)
    {
      int i1 = this.a.getMap().h();
      this.a.getMap().b(i1 + 1);
      return;
    }
    lx locallx = new lx(10000);
    locallx.b(1.0F);
    locallx.a(this.s);
    locallx.a(parama);
    locallx.a(paramLong);
    this.a.getMap().a(locallx);
  }
  
  private void b(float paramFloat1, float paramFloat2, boolean paramBoolean, long paramLong, ah.a parama)
  {
    if (paramBoolean == true)
    {
      lx locallx = new lx(10000);
      locallx.c(paramFloat1);
      if (paramFloat2 >= 0.0F) {
        locallx.d(paramFloat2);
      }
      locallx.a(this.s);
      locallx.a(parama);
      locallx.a(paramLong);
      this.a.getMap().a(locallx);
    }
    do
    {
      return;
      this.a.getMap().b(paramFloat1);
    } while (paramFloat2 < 0.0F);
    this.a.getMap().a(paramFloat2);
  }
  
  private void b(float paramFloat, boolean paramBoolean, long paramLong, ah.a parama)
  {
    if (this.a == null) {}
    while (paramFloat == 0.0F) {
      return;
    }
    if (!paramBoolean)
    {
      if (paramFloat < 0.0F) {}
      for (paramFloat = (float)(1.0D / Math.pow(2.0D, Math.abs(paramFloat)));; paramFloat = (float)(1.0D / Math.pow(0.5D, Math.abs(paramFloat))))
      {
        float f1 = this.a.getMap().i();
        this.a.getMap().a(paramFloat * f1);
        return;
      }
    }
    lx locallx = new lx(10000);
    locallx.b(paramFloat);
    locallx.a(this.s);
    locallx.a(parama);
    locallx.a(paramLong);
    this.a.getMap().a(locallx);
  }
  
  private void b(boolean paramBoolean, long paramLong, ah.a parama)
  {
    if (!paramBoolean)
    {
      int i1 = this.a.getMap().h();
      this.a.getMap().b(i1 - 1);
      return;
    }
    lx locallx = new lx(10000);
    locallx.b(-1.0F);
    locallx.a(this.s);
    locallx.a(parama);
    locallx.a(paramLong);
    this.a.getMap().a(locallx);
  }
  
  public final double a(double paramDouble)
  {
    return this.a.getMap().t().a(paramDouble);
  }
  
  public final float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, qc paramqc1, qc paramqc2, GeoPoint paramGeoPoint)
  {
    int i4 = this.a.D;
    int i5 = this.a.E;
    if ((i4 == 0) || (i5 == 0) || (paramqc1 == null) || (paramqc2 == null)) {
      return -2.0F;
    }
    if ((paramInt1 + paramInt2 > i4) || (paramInt3 + paramInt4 > i5)) {
      return -1.0F;
    }
    Object localObject1 = this.a.getMap().C().p();
    double d1;
    double d2;
    int i6;
    double d4;
    double d3;
    if (localObject1 == null)
    {
      d1 = 0.0D;
      d2 = 0.0D;
      Object localObject2 = lq.a(paramqc1);
      localObject1 = lq.a(paramqc2);
      i6 = ok.a(this.a.getMap().d());
      localObject2 = a((GeoPoint)localObject2, null);
      localObject1 = a((GeoPoint)localObject1, null);
      d4 = ((DoublePoint)localObject1).x - ((DoublePoint)localObject2).x;
      d3 = d4;
      if (d4 < 0.0D) {
        d3 = Math.abs(d4);
      }
      d4 = ((DoublePoint)localObject1).y - ((DoublePoint)localObject2).y;
      if (d4 >= 0.0D) {
        break label644;
      }
      d4 = Math.abs(d4);
    }
    label644:
    for (;;)
    {
      int i2 = i4 - paramInt1 - paramInt2;
      int i3 = i5 - paramInt3 - paramInt4;
      int i1 = i2;
      if (i2 <= 0) {
        i1 = 1;
      }
      i2 = i3;
      if (i3 <= 0) {
        i2 = 1;
      }
      d3 = Math.max(d3 / i1, d4 / i2);
      float f1 = (float)(i6 - Math.log(d3) / Math.log(2.0D));
      double d5;
      float f2;
      if (paramGeoPoint != null)
      {
        paramqc1 = new qc((paramqc1.a + paramqc2.a) / 2.0D, (paramqc1.b + paramqc2.b) / 2.0D);
        d4 = (paramInt2 - paramInt1) * d3 / 2.0D;
        d5 = (paramInt3 - paramInt4) * d3 / 2.0D;
        paramqc1 = a(lq.a(paramqc1), null);
        paramqc1.x = (d4 + paramqc1.x);
        paramqc1.y = (d5 + paramqc1.y);
        paramInt1 = this.i - this.k;
        paramInt2 = this.j - this.l;
        f2 = (this.i - this.k) / (2.0F * i4) + 0.5F;
        if (f2 >= 0.25D) {
          break label600;
        }
        paramInt1 = (int)(-0.5D * i4);
        label441:
        f2 = (this.j - this.l) / (2.0F * i5) + 0.5F;
        if (f2 >= 0.25D) {
          break label622;
        }
        paramInt2 = (int)(-0.5D * i5);
      }
      for (;;)
      {
        d4 = paramInt1 * d3 / 2.0D;
        d5 = paramInt2 * d3 / 2.0D;
        double d6 = paramqc1.x;
        paramqc1 = a(new DoublePoint(d2 * i4 * d3 + (d6 - d4), paramqc1.y - d5 - d1 * i5 * d3), null);
        paramGeoPoint.setLatitudeE6(paramqc1.getLatitudeE6());
        paramGeoPoint.setLongitudeE6(paramqc1.getLongitudeE6());
        return f1;
        d2 = ((jo.b)localObject1).a();
        d1 = ((jo.b)localObject1).b();
        break;
        label600:
        if (f2 <= 0.75D) {
          break label441;
        }
        paramInt1 = (int)(0.5D * i4);
        break label441;
        label622:
        if (f2 > 0.75D) {
          paramInt2 = (int)(0.5D * i5);
        }
      }
    }
  }
  
  public final int a(ac paramac)
  {
    if (paramac == null) {
      return -1;
    }
    paramac = paramac.a();
    if (paramac == null) {
      return -1;
    }
    switch (paramac.o)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      for (;;)
      {
        return 0;
        a(false, 0L, null);
        continue;
        b(false, 0L, null);
        continue;
        a(paramac.p, paramac.q, false, 0L, null);
        continue;
        a(paramac.r, false, 0L, null);
        continue;
        b(paramac.s, false, 0L, null);
        continue;
        a(paramac.t, paramac.u.x, paramac.u.y, false, 0L, null);
        continue;
        a(paramac.v, false, 0L, null);
        continue;
        a(paramac.w.a, paramac.w.b, false, 0L, null);
        continue;
        a(paramac.x.a, paramac.x.b, paramac.y, false, 0L, null);
        continue;
        return a(paramac.z, paramac.A, false, 0L, null);
        return a(paramac.B, paramac.E, paramac.E, paramac.E, paramac.E, false, 0L, null);
        return a(paramac.B, paramac.F, paramac.G, paramac.H, paramac.I, false, 0L, null);
        b(paramac.J, paramac.K, false, 0L, null);
      }
    }
    return a(paramac.L, paramac.F, paramac.G, paramac.H, paramac.I, false, 0L, null);
  }
  
  public final int a(ac paramac, long paramLong, ah.a parama)
  {
    if (paramac == null) {
      return -1;
    }
    paramac = paramac.a();
    if (paramac == null) {
      return -1;
    }
    if (paramLong < 0L) {
      paramLong = 0L;
    }
    switch (paramac.o)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      for (;;)
      {
        return 0;
        break;
        a(true, paramLong, parama);
        continue;
        b(true, paramLong, parama);
        continue;
        a(paramac.p, paramac.q, true, paramLong, parama);
        continue;
        a(paramac.r, true, paramLong, parama);
        continue;
        b(paramac.s, true, paramLong, parama);
        continue;
        a(paramac.t, paramac.u.x, paramac.u.y, true, paramLong, parama);
        continue;
        a(paramac.v, true, paramLong, parama);
        continue;
        a(paramac.w.a, paramac.w.b, true, paramLong, parama);
        continue;
        a(paramac.x.a, paramac.x.b, paramac.y, true, paramLong, parama);
        continue;
        return a(paramac.z, paramac.A, true, paramLong, parama);
        return a(paramac.B, paramac.E, paramac.E, paramac.E, paramac.E, true, paramLong, parama);
        return a(paramac.B, paramac.F, paramac.G, paramac.H, paramac.I, true, paramLong, parama);
        b(paramac.J, paramac.K, true, paramLong, parama);
      }
    }
    return a(paramac.L, paramac.F, paramac.G, paramac.H, paramac.I, true, paramLong, parama);
  }
  
  public final Point a(qc paramqc)
  {
    if (this.a == null) {}
    do
    {
      return null;
      paramqc = lq.a(paramqc);
      paramqc = this.a.getMap().t().b(paramqc);
    } while (paramqc == null);
    Point localPoint = new Point();
    localPoint.x = ((int)Math.round(paramqc.x));
    localPoint.y = ((int)Math.round(paramqc.y));
    return localPoint;
  }
  
  public final DoublePoint a(GeoPoint paramGeoPoint, DoublePoint paramDoublePoint)
  {
    double d3 = 2.684355E+008F * this.o;
    double d1 = d3 / 2.0D;
    double d2 = d3 / 360.0D;
    d3 /= 6.283185307179586D;
    double d5 = Math.min(Math.max(Math.sin(paramGeoPoint.getLatitudeE6() / 1000000.0D * 0.0174532925199433D), -0.9999D), 0.9999D);
    double d4 = paramGeoPoint.getLongitudeE6() / 1000000.0D;
    d5 = Math.log((1.0D + d5) / (1.0D - d5));
    paramGeoPoint = paramDoublePoint;
    if (paramDoublePoint == null) {
      paramGeoPoint = new DoublePoint();
    }
    paramGeoPoint.set(d2 * d4 + d1, d3 * d5 * 0.5D + d1);
    return paramGeoPoint;
  }
  
  public final oo a()
  {
    return this.c;
  }
  
  public final qc a(Point paramPoint)
  {
    if (paramPoint == null) {
      return null;
    }
    paramPoint = new DoublePoint(paramPoint.x, paramPoint.y);
    return lq.a(this.a.getMap().t().a(paramPoint));
  }
  
  final void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    this.a.getMap().a(paramFloat1, paramFloat2, 0, paramBoolean);
  }
  
  public final void a(int paramInt)
  {
    int i1 = paramInt;
    if (this.e != null) {
      i1 = this.e.a(paramInt);
    }
    this.n = i1;
    this.a.getMap().a(i1);
    lq.a(true);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {}
    while ((this.g == null) || (this.h != null)) {
      return;
    }
  }
  
  final void a(Handler paramHandler, Bitmap.Config paramConfig)
  {
    this.a.a(paramHandler, paramConfig);
  }
  
  final void a(ah.c paramc)
  {
    this.a.n = paramc;
    ma localma = this.a;
    if (paramc == null) {}
    for (boolean bool = true;; bool = false)
    {
      localma.setCamerChangeListener(bool);
      return;
    }
  }
  
  final void a(ah.f paramf)
  {
    this.a.setOnIndoorMapStateChangeCallback(paramf);
  }
  
  final void a(ah.g paramg)
  {
    this.a.t = paramg;
  }
  
  final void a(ah.h paramh)
  {
    this.a.l = paramh;
  }
  
  final void a(ah.i parami)
  {
    this.a.p = parami;
  }
  
  final void a(ah.j paramj)
  {
    this.a.o = paramj;
  }
  
  final void a(ah.k paramk)
  {
    this.a.setOnAnnocationClickedCallback(paramk);
  }
  
  final void a(ah.l paraml)
  {
    this.a.s = paraml;
  }
  
  public final void a(oo.a parama)
  {
    this.c.a(parama);
  }
  
  final void a(qn paramqn)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramqn);
  }
  
  final void a(String paramString1, String paramString2)
  {
    if ((this.a == null) || (this.a.getMap() == null)) {}
    f localf;
    do
    {
      return;
      localf = this.a.getMap();
    } while (localf == null);
    localf.a(paramString1, paramString2);
  }
  
  public final void a(boolean paramBoolean)
  {
    f localf = this.a.getMap();
    if (paramBoolean)
    {
      localf.a(true);
      return;
    }
    localf.a(false);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.getMap().c(paramBoolean2);
    this.a.getMap().b(paramBoolean1);
  }
  
  public final q b()
  {
    return this.e;
  }
  
  final String b(qc paramqc)
  {
    if ((this.a == null) || (paramqc == null)) {}
    do
    {
      return null;
      localObject = this.a.getMap();
    } while (localObject == null);
    GeoPoint localGeoPoint = new GeoPoint();
    Object localObject = ((f)localObject).c(localGeoPoint);
    paramqc.a = (localGeoPoint.getLatitudeE6() * 1.0D / 1000000.0D);
    paramqc.b = (localGeoPoint.getLongitudeE6() * 1.0D / 1000000.0D);
    return localObject;
  }
  
  final void b(int paramInt)
  {
    if (this.a == null) {}
    f localf;
    do
    {
      return;
      localf = this.a.getMap();
    } while (localf == null);
    localf.e(paramInt);
  }
  
  final void b(qn paramqn)
  {
    if (this.a == null) {
      return;
    }
    this.a.b(paramqn);
  }
  
  public final void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.getMap().a(11);
      return;
    }
    this.a.getMap().a(this.n);
  }
  
  public final mb c()
  {
    return this.f;
  }
  
  public final py c(qc paramqc)
  {
    String str = v();
    paramqc = b(paramqc);
    String[] arrayOfString = x();
    if ((str == null) || (paramqc == null) || (arrayOfString == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i2 = arrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localArrayList.add(new qa(arrayOfString[i1]));
      i1 += 1;
    }
    return new py(str, paramqc, localArrayList, w());
  }
  
  public final void c(boolean paramBoolean)
  {
    this.a.setZOrderMediaOverlay(paramBoolean);
  }
  
  public final void d()
  {
    if (this.a != null)
    {
      this.a.getMap().b(this.u);
      this.a.q();
      this.a = null;
    }
    if (this.b != null) {
      this.b = null;
    }
    if (lq.t != null) {
      lq.t.a();
    }
  }
  
  final void d(boolean paramBoolean)
  {
    if (this.f == null) {
      return;
    }
    this.f.a(paramBoolean);
  }
  
  public final qo e()
  {
    Object localObject2 = new Point(0, this.a.E);
    Object localObject4 = new Point(this.a.D, this.a.E);
    Object localObject3 = new Point(0, 0);
    Object localObject1 = new Point(this.a.D, 0);
    localObject2 = a((Point)localObject2);
    localObject4 = a((Point)localObject4);
    localObject3 = a((Point)localObject3);
    localObject1 = a((Point)localObject1);
    return new qo((qc)localObject2, (qc)localObject4, (qc)localObject3, (qc)localObject1, qd.a().a((qc)localObject2).a((qc)localObject4).a((qc)localObject3).a((qc)localObject1).a());
  }
  
  final void e(boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    if (paramBoolean)
    {
      this.a.s();
      return;
    }
    this.a.t();
  }
  
  public final View f()
  {
    return this.a;
  }
  
  final void f(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.q = paramBoolean;
    }
  }
  
  public final pu g()
  {
    qc localqc = lq.a(this.a.getMap().f());
    float f2 = this.a.getMap().q();
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = f2 % 360.0F + 360.0F;
    }
    f2 = this.a.getMap().r();
    float f3 = s();
    return pu.a().a(f3).a(localqc).c(f1).b(f2).a();
  }
  
  public final float h()
  {
    return this.a.getMap().c();
  }
  
  public final float i()
  {
    return this.a.getMap().b();
  }
  
  public final void j()
  {
    this.a.getMap().v();
  }
  
  public final boolean k()
  {
    return this.a.getMap().g();
  }
  
  public final ma l()
  {
    return this.a;
  }
  
  public final Context m()
  {
    return this.b;
  }
  
  final void n() {}
  
  final void o()
  {
    this.a.b();
  }
  
  final void p()
  {
    this.a.c();
  }
  
  final void q()
  {
    this.a.i();
    if (this.d != null)
    {
      this.d.a();
      this.d = null;
    }
    if (this.c != null)
    {
      this.c.a();
      this.c = null;
    }
  }
  
  final String r()
  {
    return "4.1.1";
  }
  
  public final float s()
  {
    return this.a.getMap().j();
  }
  
  final void t() {}
  
  final void u() {}
  
  final String v()
  {
    if (this.a == null) {}
    f localf;
    do
    {
      return null;
      localf = this.a.getMap();
    } while (localf == null);
    return localf.z();
  }
  
  final int w()
  {
    if (this.a == null) {}
    f localf;
    do
    {
      return -1;
      localf = this.a.getMap();
    } while (localf == null);
    return localf.x();
  }
  
  final String[] x()
  {
    if (this.a == null) {}
    f localf;
    do
    {
      return null;
      localf = this.a.getMap();
    } while (localf == null);
    return localf.y();
  }
  
  final boolean y()
  {
    if (this.a == null) {
      return false;
    }
    return this.a.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.nv
 * JD-Core Version:    0.7.0.1
 */