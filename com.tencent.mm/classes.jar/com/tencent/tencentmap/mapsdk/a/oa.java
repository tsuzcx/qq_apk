package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.f;
import java.util.ArrayList;
import java.util.List;

public class oa
  extends pd
  implements pg
{
  private ma a = null;
  private nx b = null;
  private af c = null;
  private View d = null;
  private View e = null;
  private View f = null;
  private View g = null;
  private ViewGroup h = null;
  private LinearLayout i = null;
  private boolean j = false;
  private final int k = 1;
  private final int l = 2;
  private ak m = null;
  private ah.m n = null;
  private ah.b o = null;
  private Handler p = new oa.1(this);
  private oa.a q = new oa.2(this);
  private ak.a r = new oa.3(this);
  
  public oa(af paramaf, View paramView)
  {
    this.a = ((ma)paramView);
    this.c = paramaf;
    if (this.a == null) {}
    do
    {
      return;
      this.a.m = this.q;
    } while (this.a.a(lm.class) != null);
    this.a.a(lm.class, this);
  }
  
  private void a(lm paramlm, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.o == null) {
      paramlm.r();
    }
    for (;;)
    {
      paramlm.a(paramBoolean1, paramBoolean2);
      return;
      paramlm.a(this.c, this.o);
    }
  }
  
  private void a(oa.b paramb)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    if (paramb == null) {}
    String str;
    lm locallm;
    boolean bool3;
    do
    {
      do
      {
        return;
      } while (this.a == null);
      str = paramb.a;
      locallm = paramb.d;
      bool3 = paramb.c;
      if (locallm == null) {}
      for (paramb = null; paramb == null; paramb = locallm.y)
      {
        this.a.a("", true);
        return;
      }
    } while (((this.a.s != null) && (bool3 == true) && (this.a.s.a(paramb))) || (!paramb.d()));
    if ((this.a.r != null) && (!this.a.q))
    {
      if (this.a.r == locallm.z)
      {
        bool1 = this.a.r.j();
        if (locallm.h()) {
          locallm.a(bool3, true);
        }
        if (bool3)
        {
          paramb = this.a.r;
          if (!bool1) {}
          for (bool1 = bool2;; bool1 = false)
          {
            paramb.d(bool1);
            return;
          }
        }
        this.a.r.d(true);
        return;
      }
      this.a.r.d(false);
    }
    if (locallm.z != null)
    {
      bool2 = locallm.z.j();
      if (bool3)
      {
        paramb = locallm.z;
        if (!bool2) {
          bool1 = true;
        }
        paramb.d(bool1);
        if (!bool2) {
          this.a.r = locallm.z;
        }
      }
    }
    a(locallm, bool3, bool3);
    this.a.a(str, true);
  }
  
  private void i(String paramString)
  {
    paramString = k(paramString);
    if ((paramString == null) || (!paramString.y.d())) {
      return;
    }
    a(paramString, true, false);
  }
  
  private qf j(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")) || (this.a == null)) {
      return null;
    }
    synchronized (this.a.e)
    {
      paramString = this.a.a(paramString);
      if (paramString == null) {
        return null;
      }
      if (!(paramString instanceof lm)) {
        return null;
      }
      paramString = ((lm)paramString).y;
      return paramString;
    }
  }
  
  private lm k(String paramString)
  {
    paramString = this.a.a(paramString);
    if (paramString == null) {
      return null;
    }
    if (!(paramString instanceof lm)) {
      return null;
    }
    return (lm)paramString;
  }
  
  qf a(qg paramqg, nx paramnx)
  {
    if (this.a == null) {
      return null;
    }
    if (this.b == null) {
      this.b = paramnx;
    }
    lm locallm = new lm(this.a);
    locallm.a(paramqg);
    this.a.a(locallm);
    if (this.a.a(lm.class) == null) {
      this.a.a(lm.class, this);
    }
    this.a.getMap().a();
    paramqg = new qf(paramqg, paramnx, locallm.u());
    locallm.y = paramqg;
    return paramqg;
  }
  
  public void a()
  {
    if (this.a == null) {}
    do
    {
      return;
      this.j = true;
      if (this.p != null) {
        this.p.removeCallbacksAndMessages(null);
      }
      this.a.b(lm.class);
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
    } while (this.d == null);
    ViewGroup localViewGroup = (ViewGroup)this.d;
    if (localViewGroup != null) {
      localViewGroup.removeAllViews();
    }
    this.d.setBackgroundDrawable(null);
    this.d = null;
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
    if (this.a == null) {
      return;
    }
    ln localln;
    synchronized (this.a.e)
    {
      localln = this.a.b(paramString, false);
      if ((localln == null) || (!(localln instanceof lm))) {
        return;
      }
    }
    localln.d();
    if (paramString.equals(this.a.getMarkerOnTapedId())) {
      this.a.a("", false);
    }
    this.a.getMap().a();
  }
  
  void a(String paramString, float paramFloat)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.e)
    {
      paramString = this.a.a(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof lm)) {
      return;
    }
    ((lm)paramString).a(paramFloat);
    this.a.getMap().a();
  }
  
  void a(String paramString, float paramFloat1, float paramFloat2)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.e)
    {
      paramString = this.a.a(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof lm)) {
      return;
    }
    ((lm)paramString).b(paramFloat1, paramFloat2);
    this.a.getMap().a();
  }
  
  void a(String paramString, pr parampr)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.e)
    {
      lm locallm = k(paramString);
      if (locallm != null) {
        locallm.a(parampr);
      }
      i(paramString);
      this.a.getMap().a();
      return;
    }
  }
  
  void a(String paramString, qc paramqc)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.e)
    {
      localObject = this.a.a(paramString);
      if (localObject == null) {
        return;
      }
    }
    if (!(localObject instanceof lm)) {
      return;
    }
    Object localObject = (lm)localObject;
    ((lm)localObject).a(lq.a(paramqc));
    if ((paramString.equals(this.a.getMarkerOnTapedId())) && (((lm)localObject).z != null))
    {
      paramString = lq.a(paramqc);
      ((lm)localObject).z.b(paramString);
    }
    this.a.getMap().a();
  }
  
  void a(String paramString1, String arg2)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.e)
    {
      this.a.a("", true, true);
      i(paramString1);
      return;
    }
  }
  
  void a(String paramString, boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    this.a.getMap().a();
  }
  
  public boolean a(ln paramln, boolean paramBoolean, GeoPoint paramGeoPoint)
  {
    paramGeoPoint = (lm)paramln;
    paramln = new oa.b(null);
    paramln.a = paramGeoPoint.u();
    paramln.b = paramGeoPoint.g();
    paramln.d = paramGeoPoint;
    paramln.c = paramBoolean;
    if (this.p != null)
    {
      this.p.removeCallbacksAndMessages(paramln);
      paramGeoPoint = this.p.obtainMessage();
      paramGeoPoint.obj = paramln;
      this.p.sendMessage(paramGeoPoint);
    }
    return true;
  }
  
  void b()
  {
    if (this.a == null) {
      return;
    }
    this.a.c(lm.class);
    this.a.a("", false);
    this.q.a();
  }
  
  void b(String paramString, float paramFloat)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.e)
    {
      paramString = this.a.a(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof lm)) {
      return;
    }
    ((lm)paramString).b(paramFloat);
    this.a.getMap().a();
  }
  
  void b(String paramString1, String arg2)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.e)
    {
      i(paramString1);
      return;
    }
  }
  
  void b(String paramString, boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.e)
    {
      paramString = this.a.a(paramString);
      if (paramString == null) {
        return;
      }
    }
    paramString.a_(paramBoolean);
    this.a.getMap().a();
  }
  
  boolean b(String paramString)
  {
    if (this.a == null) {
      return false;
    }
    synchronized (this.a.e)
    {
      paramString = this.a.a(paramString);
      if (paramString == null) {
        return false;
      }
      if (!(paramString instanceof lm)) {
        return false;
      }
      paramString = (lm)paramString;
      if (!paramString.y.d()) {
        return false;
      }
      a(paramString, false, null);
      this.a.getMap().a();
      return true;
    }
  }
  
  void c(String paramString, float paramFloat)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.e)
    {
      paramString = this.a.b(paramString, false);
      if (paramString == null) {
        return;
      }
    }
    paramString.c(paramFloat);
    this.a.a(paramString);
    this.a.getMap().a();
  }
  
  void c(String paramString, boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.e)
    {
      paramString = this.a.a(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof lm)) {
      return;
    }
    paramString = (lm)paramString;
    paramString.b(paramBoolean);
    if (!paramBoolean) {
      paramString.a(paramString.g());
    }
  }
  
  boolean c(String paramString)
  {
    if (this.a == null) {
      return false;
    }
    synchronized (this.a.e)
    {
      paramString = this.a.a(paramString);
      if (paramString == null) {
        return false;
      }
      if (!(paramString instanceof lm)) {
        return false;
      }
      ((lm)paramString).q();
      return true;
    }
  }
  
  boolean d(String paramString)
  {
    if (this.a == null) {
      return false;
    }
    paramString = this.a.a(paramString);
    if (paramString == null) {
      return false;
    }
    if (!(paramString instanceof lm)) {
      return false;
    }
    paramString = (lm)paramString;
    return (paramString.z != null) && (paramString.z.j());
  }
  
  float e(String paramString)
  {
    if (this.a == null) {
      return 0.0F;
    }
    synchronized (this.a.e)
    {
      paramString = this.a.a(paramString);
      if (paramString == null) {
        return 0.0F;
      }
      if (!(paramString instanceof lm)) {
        return 0.0F;
      }
      float f1 = ((lm)paramString).j();
      return f1;
    }
  }
  
  qc f(String paramString)
  {
    if (this.a == null) {
      return null;
    }
    for (;;)
    {
      synchronized (this.a.e)
      {
        paramString = this.a.a(paramString);
        if (paramString == null) {
          return null;
        }
        if (!(paramString instanceof lm)) {
          return null;
        }
        paramString = ((lm)paramString).g();
        if (paramString != null)
        {
          paramString = lq.a(paramString);
          return paramString;
        }
      }
      paramString = null;
    }
  }
  
  boolean g(String paramString)
  {
    if (this.a == null) {
      return false;
    }
    synchronized (this.a.e)
    {
      paramString = this.a.a(paramString);
      if (paramString == null) {
        return false;
      }
      if (!(paramString instanceof lm)) {
        return false;
      }
      boolean bool = ((lm)paramString).k();
      return bool;
    }
  }
  
  List<kj> h(String paramString)
  {
    if (this.a == null) {
      return null;
    }
    synchronized (this.a.e)
    {
      paramString = this.a.a(paramString);
      if (paramString == null) {
        return null;
      }
      if (!(paramString instanceof lm)) {
        return null;
      }
      paramString = (lm)paramString;
      ??? = new ArrayList(2);
      ((List)???).add(paramString.p());
      ll localll = paramString.z;
      if ((localll != null) && (localll.j())) {
        ((List)???).add(paramString.z.k());
      }
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.oa
 * JD-Core Version:    0.7.0.1
 */