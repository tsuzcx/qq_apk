package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.j;
import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ie;
import com.tencent.tencentmap.mapsdk.maps.a.ju;
import com.tencent.tencentmap.mapsdk.maps.a.jv;
import com.tencent.tencentmap.mapsdk.maps.a.jx;
import com.tencent.tencentmap.mapsdk.maps.a.ka;
import com.tencent.tencentmap.mapsdk.maps.a.kx;
import java.util.ArrayList;
import java.util.List;

public class au
  extends bw
  implements bz
{
  private kx a;
  private ar b;
  private aa c;
  private View d;
  private View e;
  private View f;
  private View g;
  private ViewGroup h;
  private LinearLayout i;
  private boolean j;
  private final int k;
  private final int l;
  private al m;
  private ah.m n;
  private ah.b o;
  private Handler p;
  private au.a q;
  private al.a r;
  
  public au(aa paramaa, ie paramie)
  {
    AppMethodBeat.i(149747);
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = null;
    this.i = null;
    this.j = false;
    this.k = 1;
    this.l = 2;
    this.m = null;
    this.n = null;
    this.o = null;
    this.p = new au.1(this);
    this.q = new au.2(this);
    this.r = new au.3(this);
    this.a = ((kx)paramie.getVectorMapDelegate());
    this.c = paramaa;
    if (this.a == null)
    {
      AppMethodBeat.o(149747);
      return;
    }
    this.a.n = this.q;
    if (this.a.a(jv.class) == null) {
      this.a.a(jv.class, this);
    }
    AppMethodBeat.o(149747);
  }
  
  private void a(au.b paramb)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    AppMethodBeat.i(149764);
    if (paramb == null)
    {
      AppMethodBeat.o(149764);
      return;
    }
    if (this.a == null)
    {
      AppMethodBeat.o(149764);
      return;
    }
    String str = paramb.a;
    jv localjv = paramb.d;
    boolean bool3 = paramb.c;
    if (localjv == null) {}
    for (paramb = null; paramb == null; paramb = localjv.y)
    {
      this.a.a("", true);
      AppMethodBeat.o(149764);
      return;
    }
    if ((this.a.s != null) && (bool3 == true) && (this.a.s.a(paramb)))
    {
      AppMethodBeat.o(149764);
      return;
    }
    if (!paramb.d())
    {
      AppMethodBeat.o(149764);
      return;
    }
    if ((this.a.W != null) && (!this.a.V))
    {
      if (this.a.W == localjv.z)
      {
        bool1 = this.a.W.j();
        if (localjv.h()) {
          localjv.a(bool3, true);
        }
        if (bool3)
        {
          paramb = this.a.W;
          if (!bool1) {}
          for (bool1 = bool2;; bool1 = false)
          {
            paramb.d(bool1);
            AppMethodBeat.o(149764);
            return;
          }
        }
        this.a.W.d(true);
        AppMethodBeat.o(149764);
        return;
      }
      this.a.W.d(false);
    }
    if (localjv.z != null)
    {
      bool2 = localjv.z.j();
      if (bool3)
      {
        paramb = localjv.z;
        if (!bool2) {
          bool1 = true;
        }
        paramb.d(bool1);
        if (!bool2) {
          this.a.W = localjv.z;
        }
      }
    }
    a(localjv, bool3, bool3);
    this.a.a(str, true);
    AppMethodBeat.o(149764);
  }
  
  private void a(jv paramjv, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(149765);
    if (this.o == null) {
      paramjv.v();
    }
    for (;;)
    {
      paramjv.a(paramBoolean1, paramBoolean2);
      AppMethodBeat.o(149765);
      return;
      paramjv.a(this.c, this.o);
    }
  }
  
  private void i(String paramString)
  {
    AppMethodBeat.i(149759);
    paramString = k(paramString);
    if ((paramString == null) || (!paramString.y.d()))
    {
      AppMethodBeat.o(149759);
      return;
    }
    a(paramString, true, false);
    AppMethodBeat.o(149759);
  }
  
  private dc j(String paramString)
  {
    AppMethodBeat.i(149762);
    if ((paramString == null) || (paramString.equals("")) || (this.a == null))
    {
      AppMethodBeat.o(149762);
      return null;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149762);
        return null;
      }
      if (!(paramString instanceof jv))
      {
        AppMethodBeat.o(149762);
        return null;
      }
      paramString = ((jv)paramString).y;
      AppMethodBeat.o(149762);
      return paramString;
    }
  }
  
  private jv k(String paramString)
  {
    AppMethodBeat.i(149778);
    paramString = this.a.b(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(149778);
      return null;
    }
    if (!(paramString instanceof jv))
    {
      AppMethodBeat.o(149778);
      return null;
    }
    paramString = (jv)paramString;
    AppMethodBeat.o(149778);
    return paramString;
  }
  
  dc a(dd paramdd, ar paramar)
  {
    AppMethodBeat.i(149749);
    if (this.a == null)
    {
      AppMethodBeat.o(149749);
      return null;
    }
    if (this.b == null) {
      this.b = paramar;
    }
    jv localjv = new jv(this.a);
    localjv.a(paramdd);
    this.a.a(localjv);
    if (this.a.a(jv.class) == null) {
      this.a.a(jv.class, this);
    }
    this.a.b().a();
    paramdd = new dc(paramdd, paramar, localjv.A());
    localjv.y = paramdd;
    this.a.a(localjv);
    AppMethodBeat.o(149749);
    return paramdd;
  }
  
  public void a()
  {
    AppMethodBeat.i(149748);
    if (this.a == null)
    {
      AppMethodBeat.o(149748);
      return;
    }
    this.j = true;
    if (this.p != null) {
      this.p.removeCallbacksAndMessages(null);
    }
    this.a.b(jv.class);
    this.a = null;
    if (this.n != null) {
      this.n = null;
    }
    if (this.o != null) {
      this.o = null;
    }
    if (this.d != null) {
      this.d = null;
    }
    if (this.h != null)
    {
      this.h.removeAllViews();
      this.h = null;
    }
    if (this.i != null) {
      this.i = null;
    }
    if (this.b != null) {
      this.b = null;
    }
    if (this.c != null) {
      this.c = null;
    }
    if (this.d != null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.d;
      if (localViewGroup != null) {
        localViewGroup.removeAllViews();
      }
      this.d.setBackgroundDrawable(null);
      this.d = null;
    }
    AppMethodBeat.o(149748);
  }
  
  void a(ah.b paramb)
  {
    this.o = paramb;
  }
  
  void a(ah.m paramm)
  {
    this.n = paramm;
  }
  
  void a(String paramString)
  {
    AppMethodBeat.i(149750);
    if (this.a == null)
    {
      AppMethodBeat.o(149750);
      return;
    }
    synchronized (this.a.b)
    {
      jx localjx = this.a.b(paramString, false);
      if ((localjx == null) || (!(localjx instanceof jv)))
      {
        AppMethodBeat.o(149750);
        return;
      }
      localjx.d();
      if (paramString.equals(this.a.u())) {
        this.a.a("", false);
      }
      this.a.b().a();
      AppMethodBeat.o(149750);
      return;
    }
  }
  
  void a(String paramString, float paramFloat)
  {
    AppMethodBeat.i(149767);
    if (this.a == null)
    {
      AppMethodBeat.o(149767);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149767);
        return;
      }
      if (!(paramString instanceof jv))
      {
        AppMethodBeat.o(149767);
        return;
      }
      ((jv)paramString).a(paramFloat);
      this.a.b().a();
      AppMethodBeat.o(149767);
      return;
    }
  }
  
  void a(String paramString, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(149751);
    if (this.a == null)
    {
      AppMethodBeat.o(149751);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149751);
        return;
      }
      if (!(paramString instanceof jv))
      {
        AppMethodBeat.o(149751);
        return;
      }
      ((jv)paramString).b(paramFloat1, paramFloat2);
      this.a.b().a();
      AppMethodBeat.o(149751);
      return;
    }
  }
  
  void a(String paramString, int paramInt)
  {
    AppMethodBeat.i(149777);
    if (this.a == null)
    {
      AppMethodBeat.o(149777);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149777);
        return;
      }
      if (!(paramString instanceof jv))
      {
        AppMethodBeat.o(149777);
        return;
      }
      ((jv)paramString).a_(paramInt);
      this.a.b().a();
      AppMethodBeat.o(149777);
      return;
    }
  }
  
  void a(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149774);
    if (this.a == null)
    {
      AppMethodBeat.o(149774);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149774);
        return;
      }
      if (!(paramString instanceof jv))
      {
        AppMethodBeat.o(149774);
        return;
      }
      ((jv)paramString).a(paramInt1, paramInt2);
      AppMethodBeat.o(149774);
      return;
    }
  }
  
  void a(String paramString, ck paramck)
  {
    AppMethodBeat.i(149753);
    if (this.a == null)
    {
      AppMethodBeat.o(149753);
      return;
    }
    synchronized (this.a.b)
    {
      jv localjv = k(paramString);
      if (localjv != null) {
        localjv.a(paramck);
      }
      i(paramString);
      this.a.b().a();
      AppMethodBeat.o(149753);
      return;
    }
  }
  
  void a(String paramString, cz paramcz)
  {
    AppMethodBeat.i(149754);
    if (this.a == null)
    {
      AppMethodBeat.o(149754);
      return;
    }
    synchronized (this.a.b)
    {
      Object localObject = this.a.b(paramString);
      if (localObject == null)
      {
        AppMethodBeat.o(149754);
        return;
      }
      if (!(localObject instanceof jv))
      {
        AppMethodBeat.o(149754);
        return;
      }
      localObject = (jv)localObject;
      ((jv)localObject).a(ka.a(paramcz));
      if ((paramString.equals(this.a.u())) && (((jv)localObject).z != null))
      {
        paramString = ka.a(paramcz);
        ((jv)localObject).z.b(paramString);
      }
      this.a.b().a();
      AppMethodBeat.o(149754);
      return;
    }
  }
  
  void a(String paramString1, String arg2)
  {
    AppMethodBeat.i(149755);
    if (this.a == null)
    {
      AppMethodBeat.o(149755);
      return;
    }
    synchronized (this.a.b)
    {
      this.a.a("", true, true);
      i(paramString1);
      AppMethodBeat.o(149755);
      return;
    }
  }
  
  void a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(149752);
    if (this.a == null)
    {
      AppMethodBeat.o(149752);
      return;
    }
    this.a.b().a();
    AppMethodBeat.o(149752);
  }
  
  public boolean a(jx paramjx, boolean paramBoolean, GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(149763);
    paramGeoPoint = (jv)paramjx;
    paramjx = new au.b(null);
    paramjx.a = paramGeoPoint.A();
    paramjx.b = paramGeoPoint.g();
    paramjx.d = paramGeoPoint;
    paramjx.c = paramBoolean;
    if (this.p != null)
    {
      this.p.removeCallbacksAndMessages(paramjx);
      paramGeoPoint = this.p.obtainMessage();
      paramGeoPoint.obj = paramjx;
      this.p.sendMessage(paramGeoPoint);
    }
    AppMethodBeat.o(149763);
    return true;
  }
  
  void b()
  {
    AppMethodBeat.i(149766);
    if (this.a == null)
    {
      AppMethodBeat.o(149766);
      return;
    }
    this.a.c(jv.class);
    this.a.a("", false);
    this.q.a();
    AppMethodBeat.o(149766);
  }
  
  void b(String paramString, float paramFloat)
  {
    AppMethodBeat.i(149768);
    if (this.a == null)
    {
      AppMethodBeat.o(149768);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149768);
        return;
      }
      if (!(paramString instanceof jv))
      {
        AppMethodBeat.o(149768);
        return;
      }
      ((jv)paramString).b(paramFloat);
      this.a.b().a();
      AppMethodBeat.o(149768);
      return;
    }
  }
  
  void b(String paramString1, String arg2)
  {
    AppMethodBeat.i(149756);
    if (this.a == null)
    {
      AppMethodBeat.o(149756);
      return;
    }
    synchronized (this.a.b)
    {
      i(paramString1);
      AppMethodBeat.o(149756);
      return;
    }
  }
  
  void b(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(149757);
    if (this.a == null)
    {
      AppMethodBeat.o(149757);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149757);
        return;
      }
      paramString.a(paramBoolean);
      this.a.b().a();
      AppMethodBeat.o(149757);
      return;
    }
  }
  
  boolean b(String paramString)
  {
    AppMethodBeat.i(149758);
    if (this.a == null)
    {
      AppMethodBeat.o(149758);
      return false;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149758);
        return false;
      }
      if (!(paramString instanceof jv))
      {
        AppMethodBeat.o(149758);
        return false;
      }
      paramString = (jv)paramString;
      if (!paramString.y.d())
      {
        AppMethodBeat.o(149758);
        return false;
      }
      a(paramString, false, null);
      this.a.b().a();
      AppMethodBeat.o(149758);
      return true;
    }
  }
  
  void c(String paramString, float paramFloat)
  {
    AppMethodBeat.i(149775);
    if (this.a == null)
    {
      AppMethodBeat.o(149775);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString, false);
      if (paramString == null)
      {
        AppMethodBeat.o(149775);
        return;
      }
      paramString.c(paramFloat);
      this.a.a(paramString);
      this.a.b().a();
      AppMethodBeat.o(149775);
      return;
    }
  }
  
  void c(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(149769);
    if (this.a == null)
    {
      AppMethodBeat.o(149769);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149769);
        return;
      }
      if (!(paramString instanceof jv))
      {
        AppMethodBeat.o(149769);
        return;
      }
      ((jv)paramString).b(paramBoolean);
      this.a.b().a();
      AppMethodBeat.o(149769);
      return;
    }
  }
  
  boolean c(String paramString)
  {
    AppMethodBeat.i(149760);
    if (this.a == null)
    {
      AppMethodBeat.o(149760);
      return false;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149760);
        return false;
      }
      if (!(paramString instanceof jv))
      {
        AppMethodBeat.o(149760);
        return false;
      }
      ((jv)paramString).u();
      AppMethodBeat.o(149760);
      return true;
    }
  }
  
  void d(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(149772);
    if (this.a == null)
    {
      AppMethodBeat.o(149772);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149772);
        return;
      }
      if (!(paramString instanceof jv))
      {
        AppMethodBeat.o(149772);
        return;
      }
      paramString = (jv)paramString;
      paramString.c(paramBoolean);
      if (!paramBoolean) {
        paramString.a(paramString.g());
      }
      AppMethodBeat.o(149772);
      return;
    }
  }
  
  boolean d(String paramString)
  {
    AppMethodBeat.i(149761);
    if (this.a == null)
    {
      AppMethodBeat.o(149761);
      return false;
    }
    paramString = this.a.b(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(149761);
      return false;
    }
    if (!(paramString instanceof jv))
    {
      AppMethodBeat.o(149761);
      return false;
    }
    paramString = (jv)paramString;
    if ((paramString.z != null) && (paramString.z.j()))
    {
      AppMethodBeat.o(149761);
      return true;
    }
    AppMethodBeat.o(149761);
    return false;
  }
  
  float e(String paramString)
  {
    AppMethodBeat.i(149770);
    if (this.a == null)
    {
      AppMethodBeat.o(149770);
      return 0.0F;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149770);
        return 0.0F;
      }
      if (!(paramString instanceof jv))
      {
        AppMethodBeat.o(149770);
        return 0.0F;
      }
      float f1 = ((jv)paramString).n();
      AppMethodBeat.o(149770);
      return f1;
    }
  }
  
  cz f(String paramString)
  {
    AppMethodBeat.i(149771);
    if (this.a == null)
    {
      AppMethodBeat.o(149771);
      return null;
    }
    for (;;)
    {
      synchronized (this.a.b)
      {
        paramString = this.a.b(paramString);
        if (paramString == null)
        {
          AppMethodBeat.o(149771);
          return null;
        }
        if (!(paramString instanceof jv))
        {
          AppMethodBeat.o(149771);
          return null;
        }
        paramString = ((jv)paramString).g();
        if (paramString != null)
        {
          paramString = ka.a(paramString);
          AppMethodBeat.o(149771);
          return paramString;
        }
      }
      paramString = null;
    }
  }
  
  boolean g(String paramString)
  {
    AppMethodBeat.i(149773);
    if (this.a == null)
    {
      AppMethodBeat.o(149773);
      return false;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149773);
        return false;
      }
      if (!(paramString instanceof jv))
      {
        AppMethodBeat.o(149773);
        return false;
      }
      boolean bool = ((jv)paramString).o();
      AppMethodBeat.o(149773);
      return bool;
    }
  }
  
  List<j> h(String paramString)
  {
    AppMethodBeat.i(149776);
    if (this.a == null)
    {
      AppMethodBeat.o(149776);
      return null;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149776);
        return null;
      }
      if (!(paramString instanceof jv))
      {
        AppMethodBeat.o(149776);
        return null;
      }
      paramString = (jv)paramString;
      ??? = new ArrayList(2);
      ((List)???).add(paramString.t());
      ju localju = paramString.z;
      if ((localju != null) && (localju.j())) {
        ((List)???).add(paramString.z.k());
      }
      AppMethodBeat.o(149776);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.au
 * JD-Core Version:    0.7.0.1
 */