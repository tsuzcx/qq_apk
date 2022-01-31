package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.f;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.hj;
import com.tencent.tencentmap.mapsdk.maps.a.ht;
import com.tencent.tencentmap.mapsdk.maps.a.hu;
import com.tencent.tencentmap.mapsdk.maps.a.hv;
import com.tencent.tencentmap.mapsdk.maps.a.ie;
import com.tencent.tencentmap.mapsdk.maps.a.ii.a;
import com.tencent.tencentmap.mapsdk.maps.a.iq;
import com.tencent.tencentmap.mapsdk.maps.a.iq.b;
import com.tencent.tencentmap.mapsdk.maps.a.ka;
import com.tencent.tencentmap.mapsdk.maps.a.kk;
import com.tencent.tencentmap.mapsdk.maps.a.kk.a;
import com.tencent.tencentmap.mapsdk.maps.a.kx;
import com.tencent.tencentmap.mapsdk.maps.a.lh;
import com.tencent.tencentmap.mapsdk.maps.a.ne.a;
import com.tencent.tencentmap.mapsdk.maps.a.np;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class ap
  implements aq, bu, cc, ce
{
  private ie a;
  private kx b;
  private Context c;
  private String d;
  private bg e;
  private lh f;
  private o g;
  private final GeoPoint h;
  private final GeoPoint i;
  private int j;
  private int k;
  private int l;
  private int m;
  private byte[] n;
  private int o;
  private boolean p;
  private float q;
  private boolean r;
  private final ap.c s;
  private final ap.c t;
  private ii.a u;
  private kk.a v;
  private ht w;
  
  public ap(int paramInt, aa paramaa, ai paramai)
  {
    AppMethodBeat.i(149652);
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = null;
    this.i = null;
    this.j = 0;
    this.k = 0;
    this.l = 0;
    this.m = 0;
    this.n = new byte[0];
    this.o = 0;
    this.p = false;
    this.q = 1.0F;
    this.r = false;
    this.s = new ap.c(this, false);
    this.t = new ap.c(this, true);
    this.u = new ii.a()
    {
      public void a(hv paramAnonymoushv)
      {
        AppMethodBeat.i(149636);
        if (paramAnonymoushv.a != 10000)
        {
          AppMethodBeat.o(149636);
          return;
        }
        if (!(paramAnonymoushv instanceof kk))
        {
          AppMethodBeat.o(149636);
          return;
        }
        paramAnonymoushv = (kk)paramAnonymoushv;
        int i;
        int j;
        if (paramAnonymoushv.j())
        {
          i = paramAnonymoushv.k();
          j = paramAnonymoushv.l();
          ap.a(ap.this).b().c(ap.a(ap.this).T / 2 - i, ap.a(ap.this).U / 2 - j);
        }
        if (paramAnonymoushv.e())
        {
          i = paramAnonymoushv.f();
          j = paramAnonymoushv.g();
          ap.a(ap.this).b().c(i, j);
        }
        float f;
        if (paramAnonymoushv.h())
        {
          f = paramAnonymoushv.i();
          ap.a(ap.this).b().b(f);
        }
        if (paramAnonymoushv.m())
        {
          i = paramAnonymoushv.n();
          j = paramAnonymoushv.o();
          ap.a(ap.this).b().a(i, j);
          if (paramAnonymoushv.t()) {
            ap.a(ap.this).c(i, j);
          }
        }
        if (paramAnonymoushv.q())
        {
          f = paramAnonymoushv.p();
          ap.a(ap.this).b().b(f);
        }
        if (paramAnonymoushv.r())
        {
          f = paramAnonymoushv.s();
          ap.a(ap.this).b().a(f);
        }
        if (paramAnonymoushv.j())
        {
          i = paramAnonymoushv.k();
          j = paramAnonymoushv.l();
          ap.a(ap.this).b().c(i - ap.a(ap.this).T / 2, j - ap.a(ap.this).U / 2);
        }
        AppMethodBeat.o(149636);
      }
    };
    this.v = new ap.2(this);
    this.w = new ap.4(this);
    this.c = paramaa.getContext().getApplicationContext();
    this.q = SystemUtil.getDensity(this.c);
    if (this.a == null)
    {
      this.a = ap.a.a(paramInt, this.c, paramai);
      this.b = ((kx)this.a.getVectorMapDelegate());
      this.b.a(this.c, paramai);
    }
    if (ka.u == null) {
      ka.u = new ao(10);
    }
    this.b.a(this);
    this.b.b().a(this.u);
    this.b.b().a(this.w);
    this.b.b().e(0, 0);
    a(false, false);
    if ((paramai != null) && (!StringUtil.isEmpty(paramai.h()))) {
      this.d = paramai.h();
    }
    this.g = new o(this.c, this.d);
    if (this.e == null) {
      this.e = new bg(paramaa, this.a);
    }
    AppMethodBeat.o(149652);
  }
  
  private int a(da paramda, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, long paramLong, ah.a parama)
  {
    AppMethodBeat.i(149671);
    if (paramda == null)
    {
      AppMethodBeat.o(149671);
      return -1;
    }
    if ((paramda.b == null) || (paramda.a == null))
    {
      AppMethodBeat.o(149671);
      return -1;
    }
    if ((this.b.T == 0) || (this.b.U == 0))
    {
      this.b.M = paramda.a;
      this.b.N = paramda.b;
      this.b.P = paramInt1;
      this.b.Q = paramInt2;
      this.b.R = paramInt3;
      this.b.S = paramInt4;
      this.b.w = parama;
      if (paramBoolean) {
        this.b.a(this.t);
      }
      for (;;)
      {
        int i1 = SystemUtil.getWindowWidth(this.c);
        int i2 = SystemUtil.getWindowHeight(this.c);
        if ((paramInt1 + paramInt2 + this.j + this.l <= i1) && (paramInt3 + paramInt4 + this.k + this.m <= i2)) {
          break;
        }
        AppMethodBeat.o(149671);
        return -1;
        this.b.a(this.s);
      }
      AppMethodBeat.o(149671);
      return 0;
    }
    this.b.a(null);
    GeoPoint localGeoPoint = new GeoPoint();
    float f1 = a(paramInt1, paramInt2, paramInt3, paramInt4, paramda.a, paramda.b, localGeoPoint);
    if (f1 < 0.0F)
    {
      paramInt1 = (int)f1;
      AppMethodBeat.o(149671);
      return paramInt1;
    }
    paramInt1 = localGeoPoint.getLatitudeE6();
    paramInt2 = localGeoPoint.getLongitudeE6();
    if (!paramBoolean)
    {
      this.b.b().a(paramInt1, paramInt2);
      a(f1, false, paramLong, null);
      this.b.b().b(0.0F);
      this.b.b().a(0.0F);
    }
    for (;;)
    {
      AppMethodBeat.o(149671);
      return 0;
      paramda = new kk(10000);
      paramda.c(0.0F);
      paramda.d(0.0F);
      paramda.c(paramInt1, paramInt2);
      paramda.a(f1);
      paramda.a(this.v);
      paramda.a(parama);
      paramda.a(paramLong);
      this.b.b().a(paramda);
    }
  }
  
  private int a(da paramda, int paramInt, boolean paramBoolean, long paramLong, ah.a parama)
  {
    AppMethodBeat.i(149669);
    if (paramda == null)
    {
      AppMethodBeat.o(149669);
      return -1;
    }
    if ((paramda.b == null) || (paramda.a == null))
    {
      AppMethodBeat.o(149669);
      return -1;
    }
    if ((this.b.T == 0) || (this.b.U == 0))
    {
      this.b.M = paramda.a;
      this.b.N = paramda.b;
      this.b.O = paramInt;
      this.b.w = parama;
      if (paramBoolean) {
        this.b.a(this.t);
      }
      for (;;)
      {
        i1 = SystemUtil.getWindowWidth(this.c);
        int i2 = SystemUtil.getWindowHeight(this.c);
        if ((paramInt * 2 + this.j + this.l <= i1) && (paramInt * 2 + this.k + this.m <= i2)) {
          break;
        }
        AppMethodBeat.o(149669);
        return -1;
        this.b.a(this.s);
      }
      AppMethodBeat.o(149669);
      return 0;
    }
    this.b.a(null);
    GeoPoint localGeoPoint = new GeoPoint();
    float f1 = a(paramInt, paramInt, paramInt, paramInt, paramda.a, paramda.b, localGeoPoint);
    if (f1 < 0.0F)
    {
      paramInt = (int)f1;
      AppMethodBeat.o(149669);
      return paramInt;
    }
    paramInt = localGeoPoint.getLatitudeE6();
    int i1 = localGeoPoint.getLongitudeE6();
    if (!paramBoolean)
    {
      this.b.b().a(paramInt, i1);
      a(f1, false, paramLong, null);
      this.b.b().b(0.0F);
      this.b.b().a(0.0F);
    }
    for (;;)
    {
      AppMethodBeat.o(149669);
      return 0;
      paramda = new kk(10000);
      paramda.c(0.0F);
      paramda.d(0.0F);
      paramda.c(paramInt, i1);
      paramda.a(f1);
      paramda.a(this.v);
      paramda.a(parama);
      paramda.a(paramLong);
      this.b.b().a(paramda);
    }
  }
  
  private int a(List<bv> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, long paramLong, ah.a parama)
  {
    AppMethodBeat.i(149672);
    hj localhj = (hj)this.b.b().u();
    if (localhj == null)
    {
      AppMethodBeat.o(149672);
      return -2147483648;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(149672);
      return -1;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bv localbv = (bv)paramList.next();
      if ((localbv != null) && (localbv.a() != null)) {
        localArrayList.addAll(localbv.a());
      }
    }
    if ((this.b.T == 0) || (this.b.U == 0))
    {
      int i1 = SystemUtil.getWindowWidth(this.c);
      int i2 = SystemUtil.getWindowHeight(this.c);
      if ((paramInt1 + paramInt2 > i1) || (paramInt3 + paramInt4 > i2))
      {
        AppMethodBeat.o(149672);
        return -1;
      }
      AppMethodBeat.o(149672);
      return 0;
    }
    if ((paramInt1 + paramInt2 > this.b.T) || (paramInt3 + paramInt4 > this.b.U))
    {
      AppMethodBeat.o(149672);
      return -1;
    }
    localhj.a(localArrayList, new Rect(paramInt1, paramInt3, paramInt2, paramInt4), new ap.3(this, paramBoolean, parama, paramLong));
    AppMethodBeat.o(149672);
    return 0;
  }
  
  private GeoPoint a(DoublePoint paramDoublePoint, GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(149693);
    double d3 = 2.684355E+008F * this.q;
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
    AppMethodBeat.o(149693);
    return paramDoublePoint;
  }
  
  private void a(double paramDouble1, double paramDouble2, float paramFloat, boolean paramBoolean, long paramLong, ah.a parama)
  {
    AppMethodBeat.i(149667);
    if (this.b == null)
    {
      AppMethodBeat.o(149667);
      return;
    }
    int i1 = (int)(1000000.0D * paramDouble1);
    int i2 = (int)(1000000.0D * paramDouble2);
    int i3 = this.b.b().d();
    int i4 = this.b.b().b();
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
        this.b.b().a(i1, i2);
        this.b.b().c((float)paramDouble1);
        AppMethodBeat.o(149667);
        return;
      }
      kk localkk = new kk(10000);
      localkk.c(i1, i2);
      localkk.a(f1);
      localkk.a(this.v);
      localkk.a(parama);
      localkk.a(paramLong);
      this.b.b().a(localkk);
      AppMethodBeat.o(149667);
      return;
    }
  }
  
  private void a(double paramDouble1, double paramDouble2, boolean paramBoolean, long paramLong, ah.a parama)
  {
    AppMethodBeat.i(149668);
    if (this.b == null)
    {
      AppMethodBeat.o(149668);
      return;
    }
    int i1 = (int)(paramDouble1 * 1000000.0D);
    int i2 = (int)(1000000.0D * paramDouble2);
    if (!paramBoolean)
    {
      this.b.b().a(i1, i2);
      AppMethodBeat.o(149668);
      return;
    }
    kk localkk = new kk(10000);
    localkk.c(i1, i2);
    localkk.a(this.v);
    localkk.a(parama);
    localkk.a(paramLong);
    this.b.b().a(localkk);
    AppMethodBeat.o(149668);
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, long paramLong, ah.a parama)
  {
    AppMethodBeat.i(149665);
    if (this.b == null)
    {
      AppMethodBeat.o(149665);
      return;
    }
    if (paramFloat1 == 0.0F)
    {
      AppMethodBeat.o(149665);
      return;
    }
    if (!paramBoolean)
    {
      if (paramFloat1 < 0.0F) {}
      for (paramFloat1 = (float)(1.0D / Math.pow(2.0D, Math.abs(paramFloat1)));; paramFloat1 = (float)(1.0D / Math.pow(0.5D, Math.abs(paramFloat1))))
      {
        this.b.b().a(paramFloat1, paramFloat2, paramFloat3, paramFloat2, paramFloat3, null);
        AppMethodBeat.o(149665);
        return;
      }
    }
    kk localkk = new kk(10000);
    localkk.b((int)paramFloat2, (int)paramFloat3);
    localkk.b(paramFloat1);
    localkk.a(this.v);
    localkk.a(parama);
    localkk.a(paramLong);
    this.b.b().a(localkk);
    AppMethodBeat.o(149665);
  }
  
  private void a(float paramFloat1, float paramFloat2, boolean paramBoolean, long paramLong, ah.a parama)
  {
    AppMethodBeat.i(149662);
    if (this.b == null)
    {
      AppMethodBeat.o(149662);
      return;
    }
    if ((paramFloat1 == 0.0F) && (paramFloat2 == 0.0F))
    {
      AppMethodBeat.o(149662);
      return;
    }
    if (!paramBoolean)
    {
      this.b.b().c((int)paramFloat1, (int)paramFloat2);
      AppMethodBeat.o(149662);
      return;
    }
    kk localkk = new kk(10000);
    localkk.a((int)paramFloat1, (int)paramFloat2);
    localkk.a(this.v);
    localkk.a(parama);
    localkk.a(paramLong);
    this.b.b().a(localkk);
    AppMethodBeat.o(149662);
  }
  
  private void a(float paramFloat, boolean paramBoolean, long paramLong, ah.a parama)
  {
    AppMethodBeat.i(149663);
    if (this.b == null)
    {
      AppMethodBeat.o(149663);
      return;
    }
    if (!paramBoolean)
    {
      int i2 = this.b.b().d();
      paramBoolean = this.b.H().c();
      int i3 = this.b.b().c();
      if (paramBoolean) {}
      for (int i1 = 22;; i1 = 20)
      {
        paramFloat = Math.min(paramFloat, Math.min(i3, i1));
        double d1 = 1.0D / Math.pow(2.0D, i2 - paramFloat);
        this.b.b().a((float)d1);
        AppMethodBeat.o(149663);
        return;
      }
    }
    kk localkk = new kk(10000);
    localkk.a(paramFloat);
    localkk.a(this.v);
    localkk.a(parama);
    localkk.a(paramLong);
    this.b.b().a(localkk);
    AppMethodBeat.o(149663);
  }
  
  private void a(cn paramcn, boolean paramBoolean, long paramLong, ah.a parama)
  {
    AppMethodBeat.i(149666);
    if (this.b == null)
    {
      AppMethodBeat.o(149666);
      return;
    }
    if (paramcn == null)
    {
      AppMethodBeat.o(149666);
      return;
    }
    GeoPoint localGeoPoint = ka.a(paramcn.a);
    float f2 = paramcn.b;
    int i1 = this.b.b().d();
    int i2 = this.b.b().b();
    float f1 = f2;
    if (f2 < i2) {
      f1 = i2;
    }
    f2 = f1;
    if (f1 > i1) {
      f2 = i1;
    }
    if (!paramBoolean)
    {
      double d1 = 1.0D / Math.pow(2.0D, i1 - f2);
      if (localGeoPoint != null) {
        this.b.b().a(localGeoPoint.getLatitudeE6(), localGeoPoint.getLongitudeE6());
      }
      this.b.b().c((float)d1);
      this.b.b().b(paramcn.d);
      if (paramcn.c >= 0.0F) {
        this.b.b().a(paramcn.c);
      }
      AppMethodBeat.o(149666);
      return;
    }
    kk localkk = new kk(10000);
    if (localGeoPoint != null) {
      localkk.c(localGeoPoint.getLatitudeE6(), localGeoPoint.getLongitudeE6());
    }
    localkk.a(f2);
    localkk.c(paramcn.d);
    if (paramcn.c >= 0.0F) {
      localkk.d(paramcn.c);
    }
    localkk.a(this.v);
    localkk.a(paramLong);
    localkk.a(parama);
    this.b.b().a(localkk);
    AppMethodBeat.o(149666);
  }
  
  private void a(boolean paramBoolean, long paramLong, ah.a parama)
  {
    AppMethodBeat.i(149660);
    if (!paramBoolean)
    {
      int i1 = this.b.b().h();
      this.b.b().b(i1 + 1);
      AppMethodBeat.o(149660);
      return;
    }
    kk localkk = new kk(10000);
    localkk.b(1.0F);
    localkk.a(this.v);
    localkk.a(parama);
    localkk.a(paramLong);
    this.b.b().a(localkk);
    AppMethodBeat.o(149660);
  }
  
  private void b(float paramFloat1, float paramFloat2, boolean paramBoolean, long paramLong, ah.a parama)
  {
    AppMethodBeat.i(149670);
    if (paramBoolean == true)
    {
      kk localkk = new kk(10000);
      localkk.c(paramFloat1);
      if (paramFloat2 >= 0.0F) {
        localkk.d(paramFloat2);
      }
      localkk.a(this.v);
      localkk.a(parama);
      localkk.a(paramLong);
      this.b.b().a(localkk);
      AppMethodBeat.o(149670);
      return;
    }
    this.b.b().b(paramFloat1);
    if (paramFloat2 >= 0.0F) {
      this.b.b().a(paramFloat2);
    }
    AppMethodBeat.o(149670);
  }
  
  private void b(float paramFloat, boolean paramBoolean, long paramLong, ah.a parama)
  {
    AppMethodBeat.i(149664);
    if (this.b == null)
    {
      AppMethodBeat.o(149664);
      return;
    }
    if (paramFloat == 0.0F)
    {
      AppMethodBeat.o(149664);
      return;
    }
    if (!paramBoolean)
    {
      if (paramFloat < 0.0F) {}
      for (paramFloat = (float)(1.0D / Math.pow(2.0D, Math.abs(paramFloat)));; paramFloat = (float)(1.0D / Math.pow(0.5D, Math.abs(paramFloat))))
      {
        float f1 = this.b.b().i();
        this.b.b().a(paramFloat * f1);
        AppMethodBeat.o(149664);
        return;
      }
    }
    kk localkk = new kk(10000);
    localkk.b(paramFloat);
    localkk.a(this.v);
    localkk.a(parama);
    localkk.a(paramLong);
    this.b.b().a(localkk);
    AppMethodBeat.o(149664);
  }
  
  private void b(boolean paramBoolean, long paramLong, ah.a parama)
  {
    AppMethodBeat.i(149661);
    if (!paramBoolean)
    {
      int i1 = this.b.b().h();
      this.b.b().b(i1 - 1);
      AppMethodBeat.o(149661);
      return;
    }
    kk localkk = new kk(10000);
    localkk.b(-1.0F);
    localkk.a(this.v);
    localkk.a(parama);
    localkk.a(paramLong);
    this.b.b().a(localkk);
    AppMethodBeat.o(149661);
  }
  
  public final double a(double paramDouble)
  {
    AppMethodBeat.i(149658);
    paramDouble = this.b.b().t().a(paramDouble);
    AppMethodBeat.o(149658);
    return paramDouble;
  }
  
  public final float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, cz paramcz1, cz paramcz2, GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(149692);
    int i4 = this.b.T;
    int i5 = this.b.U;
    if ((i4 == 0) || (i5 == 0) || (paramcz1 == null) || (paramcz2 == null))
    {
      AppMethodBeat.o(149692);
      return -2.0F;
    }
    if ((paramInt1 + paramInt2 + this.j + this.l > i4) || (paramInt3 + paramInt4 + this.k + this.m > i5))
    {
      AppMethodBeat.o(149692);
      return -1.0F;
    }
    Object localObject2 = ka.a(paramcz1);
    Object localObject1 = ka.a(paramcz2);
    int i6 = this.b.b().d();
    localObject2 = a((GeoPoint)localObject2, null);
    localObject1 = a((GeoPoint)localObject1, null);
    double d2 = ((DoublePoint)localObject1).x - ((DoublePoint)localObject2).x;
    double d1 = d2;
    if (d2 < 0.0D) {
      d1 = Math.abs(d2);
    }
    double d3 = ((DoublePoint)localObject1).y - ((DoublePoint)localObject2).y;
    d2 = d3;
    if (d3 < 0.0D) {
      d2 = Math.abs(d3);
    }
    int i2 = i4 - paramInt1 - paramInt2 - this.j - this.l;
    int i3 = i5 - paramInt3 - paramInt4 - this.k - this.m;
    int i1 = i2;
    if (i2 <= 0) {
      i1 = 1;
    }
    i2 = i3;
    if (i3 <= 0) {
      i2 = 1;
    }
    d1 = Math.max(d1 / i1, d2 / i2);
    float f1 = (float)(i6 - Math.log(d1) / Math.log(2.0D));
    float f3 = g();
    float f2 = h();
    if (f3 < f1)
    {
      d1 = Math.pow(2.0D, i6 - f3);
      f1 = f3;
    }
    for (;;)
    {
      if (f2 > f1)
      {
        d1 = Math.pow(2.0D, i6 - f2);
        f1 = f2;
      }
      for (;;)
      {
        double d4;
        double d5;
        if (paramGeoPoint != null)
        {
          paramcz1 = new cz((paramcz1.a + paramcz2.a) / 2.0D, (paramcz1.b + paramcz2.b) / 2.0D);
          d2 = (paramInt2 - paramInt1) * d1 / 2.0D;
          d3 = (paramInt3 - paramInt4) * d1 / 2.0D;
          paramcz1 = a(ka.a(paramcz1), null);
          paramcz1.x = (d2 + paramcz1.x);
          paramcz1.y = (d3 + paramcz1.y);
          d4 = paramcz1.x;
          d5 = paramcz1.y;
          if (!this.r) {
            break label798;
          }
          paramInt1 = this.j - this.l;
          paramInt2 = this.k - this.m;
          f2 = (this.j - this.l) / (2.0F * i4) + 0.5F;
          if (f2 >= 0.25D) {
            break label735;
          }
          paramInt1 = (int)(-0.5D * i4);
          f2 = (this.k - this.m) / (2.0F * i5) + 0.5F;
          if (f2 >= 0.25D) {
            break label757;
          }
          paramInt2 = (int)(-0.5D * i5);
          label602:
          double d7 = paramInt1 * d1 / 2.0D;
          double d6 = paramInt2 * d1 / 2.0D;
          paramcz1 = this.b.b().y().q();
          if (paramcz1 != null) {
            break label779;
          }
          d3 = 0.0D;
          d2 = 0.0D;
          label650:
          d3 = d4 - d7 + d3 * i4 * d1;
          d1 = d5 - d6 - d2 * i5 * d1;
        }
        for (d2 = d3;; d2 = d4)
        {
          paramcz1 = a(new DoublePoint(d2, d1), null);
          paramGeoPoint.setLatitudeE6(paramcz1.getLatitudeE6());
          paramGeoPoint.setLongitudeE6(paramcz1.getLongitudeE6());
          AppMethodBeat.o(149692);
          return f1;
          label735:
          if (f2 <= 0.75D) {
            break;
          }
          paramInt1 = (int)(0.5D * i4);
          break;
          label757:
          if (f2 <= 0.75D) {
            break label602;
          }
          paramInt2 = (int)(0.5D * i5);
          break label602;
          label779:
          d3 = paramcz1.a();
          d2 = paramcz1.b();
          break label650;
          label798:
          d1 = d5;
        }
      }
    }
  }
  
  public final int a(ab paramab)
  {
    AppMethodBeat.i(149676);
    if (paramab == null)
    {
      AppMethodBeat.o(149676);
      return -1;
    }
    paramab = paramab.a();
    if (paramab == null)
    {
      AppMethodBeat.o(149676);
      return -1;
    }
    switch (paramab.o)
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
        AppMethodBeat.o(149676);
        return 0;
        a(false, 0L, null);
        continue;
        b(false, 0L, null);
        continue;
        a(paramab.p, paramab.q, false, 0L, null);
        continue;
        a(paramab.r, false, 0L, null);
        continue;
        b(paramab.s, false, 0L, null);
        continue;
        a(paramab.t, paramab.u.x, paramab.u.y, false, 0L, null);
        continue;
        a(paramab.v, false, 0L, null);
        continue;
        a(paramab.w.a, paramab.w.b, false, 0L, null);
        continue;
        a(paramab.x.a, paramab.x.b, paramab.y, false, 0L, null);
        continue;
        i1 = a(paramab.z, paramab.A, false, 0L, null);
        AppMethodBeat.o(149676);
        return i1;
        i1 = a(paramab.B, paramab.E, paramab.E, paramab.E, paramab.E, false, 0L, null);
        AppMethodBeat.o(149676);
        return i1;
        i1 = a(paramab.B, paramab.F, paramab.G, paramab.H, paramab.I, false, 0L, null);
        AppMethodBeat.o(149676);
        return i1;
        b(paramab.J, paramab.K, false, 0L, null);
      }
    }
    int i1 = a(paramab.L, paramab.F, paramab.G, paramab.H, paramab.I, false, 0L, null);
    AppMethodBeat.o(149676);
    return i1;
  }
  
  public final int a(ab paramab, long paramLong, ah.a parama)
  {
    AppMethodBeat.i(149677);
    if (paramab == null)
    {
      AppMethodBeat.o(149677);
      return -1;
    }
    paramab = paramab.a();
    if (paramab == null)
    {
      AppMethodBeat.o(149677);
      return -1;
    }
    if (paramLong < 0L) {
      paramLong = 0L;
    }
    switch (paramab.o)
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
        AppMethodBeat.o(149677);
        return 0;
        break;
        a(true, paramLong, parama);
        continue;
        b(true, paramLong, parama);
        continue;
        a(paramab.p, paramab.q, true, paramLong, parama);
        continue;
        a(paramab.r, true, paramLong, parama);
        continue;
        b(paramab.s, true, paramLong, parama);
        continue;
        a(paramab.t, paramab.u.x, paramab.u.y, true, paramLong, parama);
        continue;
        a(paramab.v, true, paramLong, parama);
        continue;
        a(paramab.w.a, paramab.w.b, true, paramLong, parama);
        continue;
        a(paramab.x.a, paramab.x.b, paramab.y, true, paramLong, parama);
        continue;
        i1 = a(paramab.z, paramab.A, true, paramLong, parama);
        AppMethodBeat.o(149677);
        return i1;
        i1 = a(paramab.B, paramab.E, paramab.E, paramab.E, paramab.E, true, paramLong, parama);
        AppMethodBeat.o(149677);
        return i1;
        i1 = a(paramab.B, paramab.F, paramab.G, paramab.H, paramab.I, true, paramLong, parama);
        AppMethodBeat.o(149677);
        return i1;
        b(paramab.J, paramab.K, true, paramLong, parama);
      }
    }
    int i1 = a(paramab.L, paramab.F, paramab.G, paramab.H, paramab.I, true, paramLong, parama);
    AppMethodBeat.o(149677);
    return i1;
  }
  
  public final Point a(cz paramcz)
  {
    AppMethodBeat.i(149657);
    if (this.b == null)
    {
      AppMethodBeat.o(149657);
      return null;
    }
    paramcz = ka.a(paramcz);
    paramcz = this.b.b().t().b(paramcz);
    if (paramcz == null)
    {
      AppMethodBeat.o(149657);
      return null;
    }
    Point localPoint = new Point();
    localPoint.x = ((int)Math.round(paramcz.x));
    localPoint.y = ((int)Math.round(paramcz.y));
    AppMethodBeat.o(149657);
    return localPoint;
  }
  
  public final DoublePoint a(GeoPoint paramGeoPoint, DoublePoint paramDoublePoint)
  {
    AppMethodBeat.i(149691);
    double d3 = 2.684355E+008F * this.q;
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
    AppMethodBeat.o(149691);
    return paramGeoPoint;
  }
  
  public final bg a()
  {
    return this.e;
  }
  
  public final cz a(Point paramPoint)
  {
    AppMethodBeat.i(149656);
    if (paramPoint == null)
    {
      AppMethodBeat.o(149656);
      return null;
    }
    paramPoint = new DoublePoint(paramPoint.x, paramPoint.y);
    paramPoint = ka.a(this.b.b().t().a(paramPoint));
    AppMethodBeat.o(149656);
    return paramPoint;
  }
  
  public final void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(149695);
    if (this.b == null)
    {
      AppMethodBeat.o(149695);
      return;
    }
    this.r = true;
    this.b.b().a(paramFloat1, paramFloat2, 0, paramBoolean);
    AppMethodBeat.o(149695);
  }
  
  public final void a(int paramInt)
  {
    AppMethodBeat.i(149679);
    if (this.p)
    {
      AppMethodBeat.o(149679);
      return;
    }
    int i1 = paramInt;
    if (this.g != null) {
      i1 = this.g.a(paramInt);
    }
    this.o = i1;
    this.b.b().a(i1);
    ka.a(true);
    AppMethodBeat.o(149679);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149687);
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(149687);
      return;
    }
    if (this.e != null) {
      this.e.a(paramInt1, paramInt2);
    }
    AppMethodBeat.o(149687);
  }
  
  public final void a(Handler paramHandler, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(149688);
    this.b.a(paramHandler, paramConfig);
    AppMethodBeat.o(149688);
  }
  
  public final void a(ah.c paramc)
  {
    AppMethodBeat.i(149686);
    this.b.a(paramc);
    AppMethodBeat.o(149686);
  }
  
  public final void a(ah.f paramf)
  {
    AppMethodBeat.i(149698);
    this.b.a(paramf);
    AppMethodBeat.o(149698);
  }
  
  public final void a(ah.g paramg)
  {
    this.b.t = paramg;
  }
  
  public final void a(ah.h paramh)
  {
    this.b.m = paramh;
  }
  
  public final void a(ah.i parami)
  {
    this.b.q = parami;
  }
  
  public final void a(ah.j paramj)
  {
    this.b.p = paramj;
  }
  
  public final void a(ah.k paramk)
  {
    AppMethodBeat.i(149705);
    this.b.a(paramk);
    AppMethodBeat.o(149705);
  }
  
  public final void a(ah.l paraml)
  {
    this.b.s = paraml;
  }
  
  public final void a(bg.a parama)
  {
    AppMethodBeat.i(149653);
    this.e.a(parama);
    AppMethodBeat.o(149653);
  }
  
  public final void a(cy paramcy)
  {
    AppMethodBeat.i(149709);
    if ((this.b == null) || (this.b.r() == null))
    {
      AppMethodBeat.o(149709);
      return;
    }
    this.b.r().a(paramcy);
    AppMethodBeat.o(149709);
  }
  
  public final void a(dl paramdl)
  {
    AppMethodBeat.i(149689);
    if (this.b == null)
    {
      AppMethodBeat.o(149689);
      return;
    }
    this.b.a(paramdl);
    AppMethodBeat.o(149689);
  }
  
  public final void a(ne.a parama, ai paramai)
  {
    AppMethodBeat.i(149654);
    this.e.a(parama, paramai);
    AppMethodBeat.o(149654);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(149711);
    if ((this.b == null) || (this.b.b() == null))
    {
      AppMethodBeat.o(149711);
      return;
    }
    f localf = this.b.b();
    if (localf != null) {
      localf.a(paramString1, paramString2);
    }
    AppMethodBeat.o(149711);
  }
  
  public final void a(boolean paramBoolean)
  {
    AppMethodBeat.i(149680);
    f localf = this.b.b();
    if (paramBoolean)
    {
      localf.a(true);
      AppMethodBeat.o(149680);
      return;
    }
    localf.a(false);
    AppMethodBeat.o(149680);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(149697);
    this.b.b().c(paramBoolean2);
    this.b.b().b(paramBoolean1);
    AppMethodBeat.o(149697);
  }
  
  public final o b()
  {
    return this.g;
  }
  
  public final String b(cz paramcz)
  {
    AppMethodBeat.i(149703);
    if ((this.b == null) || (this.b.H() == null))
    {
      AppMethodBeat.o(149703);
      return null;
    }
    paramcz = this.b.H().a(paramcz);
    AppMethodBeat.o(149703);
    return paramcz;
  }
  
  public final void b(int paramInt)
  {
    AppMethodBeat.i(149700);
    if ((this.b == null) || (this.b.H() == null))
    {
      AppMethodBeat.o(149700);
      return;
    }
    this.b.H().a(paramInt);
    AppMethodBeat.o(149700);
  }
  
  public final void b(dl paramdl)
  {
    AppMethodBeat.i(149690);
    if (this.b == null)
    {
      AppMethodBeat.o(149690);
      return;
    }
    this.b.b(paramdl);
    AppMethodBeat.o(149690);
  }
  
  public final void b(boolean paramBoolean)
  {
    AppMethodBeat.i(149681);
    this.p = paramBoolean;
    if (paramBoolean)
    {
      this.b.b().a(11);
      AppMethodBeat.o(149681);
      return;
    }
    this.b.b().a(this.o);
    AppMethodBeat.o(149681);
  }
  
  public final cu c(cz paramcz)
  {
    AppMethodBeat.i(149704);
    if ((this.b == null) || (this.b.H() == null))
    {
      AppMethodBeat.o(149704);
      return null;
    }
    paramcz = this.b.H().b(paramcz);
    AppMethodBeat.o(149704);
    return paramcz;
  }
  
  public final void c()
  {
    AppMethodBeat.i(149655);
    if (this.b != null)
    {
      this.b.b().b(this.w);
      this.b.D();
      this.b = null;
    }
    if (this.c != null) {
      this.c = null;
    }
    if (ka.u != null) {
      ka.u.a();
    }
    AppMethodBeat.o(149655);
  }
  
  public final void c(boolean paramBoolean)
  {
    AppMethodBeat.i(149696);
    this.a.setZOrderMediaOverlay(paramBoolean);
    AppMethodBeat.o(149696);
  }
  
  public final dm d()
  {
    AppMethodBeat.i(149659);
    Object localObject2 = new Point(0, this.b.U);
    Object localObject4 = new Point(this.b.T, this.b.U);
    Object localObject3 = new Point(0, 0);
    Object localObject1 = new Point(this.b.T, 0);
    localObject2 = a((Point)localObject2);
    localObject4 = a((Point)localObject4);
    localObject3 = a((Point)localObject3);
    localObject1 = a((Point)localObject1);
    localObject1 = new dm((cz)localObject2, (cz)localObject4, (cz)localObject3, (cz)localObject1, da.a().a((cz)localObject2).a((cz)localObject4).a((cz)localObject3).a((cz)localObject1).a());
    AppMethodBeat.o(149659);
    return localObject1;
  }
  
  public final void d(boolean paramBoolean)
  {
    AppMethodBeat.i(149699);
    if ((this.b == null) || (this.b.H() == null))
    {
      AppMethodBeat.o(149699);
      return;
    }
    this.b.H().a(paramBoolean);
    AppMethodBeat.o(149699);
  }
  
  public final ie e()
  {
    return this.a;
  }
  
  public final void e(boolean paramBoolean)
  {
    AppMethodBeat.i(149706);
    if (this.b == null)
    {
      AppMethodBeat.o(149706);
      return;
    }
    if (paramBoolean)
    {
      this.b.O();
      AppMethodBeat.o(149706);
      return;
    }
    this.b.P();
    AppMethodBeat.o(149706);
  }
  
  public final cn f()
  {
    AppMethodBeat.i(149673);
    Object localObject = ka.a(this.b.b().f());
    float f2 = this.b.b().q();
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = f2 % 360.0F + 360.0F;
    }
    f2 = this.b.b().r();
    float f3 = r();
    localObject = cn.a().a(f3).a((cz)localObject).c(f1).b(f2).a();
    AppMethodBeat.o(149673);
    return localObject;
  }
  
  public final void f(boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.V = paramBoolean;
    }
  }
  
  public final float g()
  {
    AppMethodBeat.i(149674);
    float f1 = this.b.b().c();
    AppMethodBeat.o(149674);
    return f1;
  }
  
  public final float h()
  {
    AppMethodBeat.i(149675);
    float f1 = this.b.b().b();
    AppMethodBeat.o(149675);
    return f1;
  }
  
  public final void i()
  {
    AppMethodBeat.i(149678);
    this.b.b().v();
    AppMethodBeat.o(149678);
  }
  
  public final boolean j()
  {
    AppMethodBeat.i(149682);
    boolean bool = this.b.b().g();
    AppMethodBeat.o(149682);
    return bool;
  }
  
  public final kx k()
  {
    return this.b;
  }
  
  public final Context l()
  {
    return this.c;
  }
  
  public final void m() {}
  
  public final void n()
  {
    AppMethodBeat.i(149683);
    this.a.e();
    if (this.e != null) {
      this.e.f();
    }
    AppMethodBeat.o(149683);
  }
  
  public final void o()
  {
    AppMethodBeat.i(149684);
    this.a.f();
    AppMethodBeat.o(149684);
  }
  
  public final void p()
  {
    AppMethodBeat.i(149685);
    this.a.g();
    if (this.f != null)
    {
      this.f.b();
      this.f = null;
    }
    if (this.e != null)
    {
      this.e.a();
      this.e = null;
    }
    AppMethodBeat.o(149685);
  }
  
  public final String q()
  {
    return "4.2.3";
  }
  
  public final float r()
  {
    AppMethodBeat.i(149694);
    float f1 = this.b.b().j();
    AppMethodBeat.o(149694);
    return f1;
  }
  
  public final void s() {}
  
  public final void t() {}
  
  public final int u()
  {
    AppMethodBeat.i(149701);
    if ((this.b == null) || (this.b.H() == null))
    {
      AppMethodBeat.o(149701);
      return -1;
    }
    int i1 = this.b.H().e();
    AppMethodBeat.o(149701);
    return i1;
  }
  
  public final String[] v()
  {
    AppMethodBeat.i(149702);
    if ((this.b == null) || (this.b.H() == null))
    {
      AppMethodBeat.o(149702);
      return null;
    }
    String[] arrayOfString = this.b.H().f();
    AppMethodBeat.o(149702);
    return arrayOfString;
  }
  
  public final boolean w()
  {
    AppMethodBeat.i(149707);
    if (this.b == null)
    {
      AppMethodBeat.o(149707);
      return false;
    }
    boolean bool = this.b.Q();
    AppMethodBeat.o(149707);
    return bool;
  }
  
  public final boolean x()
  {
    AppMethodBeat.i(149708);
    if (this.b == null)
    {
      AppMethodBeat.o(149708);
      return false;
    }
    boolean bool = this.b.R();
    AppMethodBeat.o(149708);
    return bool;
  }
  
  public final String y()
  {
    AppMethodBeat.i(149710);
    if ((this.c == null) || (this.b == null))
    {
      AppMethodBeat.o(149710);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (!StringUtil.isEmpty(this.d)) {}
      for (Object localObject = s.a(this.c, this.d);; localObject = u.a(this.c))
      {
        localJSONObject.put("cfgVer", ((q)localObject).b());
        int i1 = SystemUtil.getWindowWidth(this.c);
        int i2 = SystemUtil.getWindowHeight(this.c);
        localJSONObject.put("resolution", "{" + i1 + "," + i2 + "}");
        localJSONObject.put("density", this.q);
        localJSONObject.put("renderStatus", this.b.b().H());
        localJSONObject.put("renderError", this.b.b().I());
        localJSONObject.put("sdkver", "4.2.3.3");
        localObject = localJSONObject.toString();
        AppMethodBeat.o(149710);
        return localObject;
      }
      return null;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(149710);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ap
 * JD-Core Version:    0.7.0.1
 */