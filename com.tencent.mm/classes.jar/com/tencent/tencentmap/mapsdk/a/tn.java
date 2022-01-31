package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;

public final class tn
  implements sx.a, tg.a
{
  public static int a = 0;
  public static int b = 0;
  public static int c = 0;
  public static int d = 0;
  public static int e = 0;
  public static int f = 0;
  public static int g = 0;
  public static int h = 0;
  private static volatile Context i;
  private static boolean x = true;
  private static volatile String z = sg.a(sg.b);
  private boolean A = false;
  private boolean B = false;
  private st C;
  private sm D;
  private uy j;
  private th k;
  private tj l;
  private to m;
  private uf.1 n;
  private us o;
  private ti p;
  private tk q;
  private th.1 r;
  private volatile ud s;
  private uc t;
  private int u = 1;
  private vb.j v = null;
  private boolean w = false;
  private Rect y = null;
  
  public tn(uy paramuy)
  {
    i = paramuy.getContext().getApplicationContext();
    ug.a().a(i);
    ua.a().a(i);
    tm.a().a(i);
    tp.l();
    this.j = paramuy;
    this.r = new th.1(this);
    this.s = new ud(this);
    this.p = new ti(this);
    this.q = new tk(this);
    this.t = new uc(this);
    this.k = new th(this);
    this.l = new tj(this);
    this.m = new to(this);
    this.n = new uf.1(this);
    this.o = new us(this);
    this.q.a();
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    paramuy.addView(this.l, localLayoutParams);
    paramuy.addView(this.t, localLayoutParams);
    paramuy.addView(this.s, localLayoutParams);
    this.r.b(1);
    this.r.a(true);
    this.r.c(0);
    this.D = new sm();
    this.D.a();
    new sx(i, this).a();
    new tg(i, this).a();
  }
  
  public static Context a()
  {
    return i;
  }
  
  public static void a(String paramString)
  {
    z = paramString;
  }
  
  public static void e(boolean paramBoolean)
  {
    x = false;
  }
  
  public static void n() {}
  
  public static boolean p()
  {
    return x;
  }
  
  public static String q()
  {
    return z;
  }
  
  private st s()
  {
    sw[] arrayOfsw = this.q.b();
    sw localsw = this.l.b();
    float f1 = this.q.d().c();
    if (this.C == null) {
      this.C = new st(localsw, arrayOfsw, f1);
    }
    for (;;)
    {
      return this.C;
      this.C.a(localsw, arrayOfsw, f1);
    }
  }
  
  public final void a(float paramFloat)
  {
    if (this.s != null)
    {
      this.s.a(paramFloat);
      this.s.invalidate();
    }
  }
  
  public final void a(int paramInt)
  {
    this.u = paramInt;
    a(false, false);
  }
  
  public final void a(int paramInt, int[] paramArrayOfInt)
  {
    if (this.s != null) {
      this.s.a(paramArrayOfInt);
    }
  }
  
  public final void a(Bitmap paramBitmap)
  {
    if (this.s != null)
    {
      this.s.a(paramBitmap);
      this.s.invalidate();
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.r.d(paramBundle.getBoolean("ANIMATION_ENABLED", true));
      this.r.b(paramBundle.getBoolean("SCROLL_ENABLED", true));
      this.r.c(paramBundle.getBoolean("ZOOM_ENABLED", true));
      this.r.b(paramBundle.getInt("LOGO_POSITION", 0));
      this.r.c(paramBundle.getInt("SCALEVIEW_POSITION", 0));
      this.r.a(paramBundle.getBoolean("SCALE_CONTROLL_ENABLED", true));
      this.l.b(paramBundle.getDouble("ZOOM", this.l.c()), false, null);
      Double localDouble = Double.valueOf(paramBundle.getDouble("CENTERX", (0.0D / 0.0D)));
      paramBundle = Double.valueOf(paramBundle.getDouble("CENTERY", (0.0D / 0.0D)));
      if ((!localDouble.isNaN()) && (!paramBundle.isNaN())) {
        this.l.a(new sw(localDouble.doubleValue(), paramBundle.doubleValue()));
      }
    }
  }
  
  public final void a(vb.j paramj)
  {
    a(paramj, null);
  }
  
  public final void a(vb.j paramj, Rect paramRect)
  {
    this.v = paramj;
    this.y = paramRect;
    if ((Build.VERSION.SDK_INT > 11) && (this.l != null)) {
      this.l.setLayerType(1, null);
    }
    if (this.w)
    {
      o();
      return;
    }
    if (this.l != null) {
      this.l.a(true);
    }
    a(false, false);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      a(false, false);
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.w = false;
    if (this.p != null) {
      this.p.a(s());
    }
    this.n.a(paramBoolean1, paramBoolean2);
    this.j.f();
    this.j.postInvalidate();
  }
  
  public final tk b()
  {
    return this.q;
  }
  
  public final void b(int paramInt)
  {
    if (this.s != null)
    {
      this.s.a(paramInt);
      this.s.invalidate();
      if (this.t.getVisibility() == 0) {
        this.t.invalidate();
      }
    }
  }
  
  public final void b(Bitmap paramBitmap)
  {
    this.j.post(new tn.2(this, paramBitmap));
  }
  
  public final void b(Bundle paramBundle)
  {
    paramBundle.putBoolean("ANIMATION_ENABLED", this.r.k());
    paramBundle.putBoolean("SCROLL_ENABLED", this.r.h());
    paramBundle.putBoolean("ZOOM_ENABLED", this.r.i());
    paramBundle.putInt("LOGO_POSITION", this.r.j());
    paramBundle.putInt("SCALEVIEW_POSITION", this.r.f());
    paramBundle.putBoolean("SCALE_CONTROLL_ENABLED", this.r.g());
    paramBundle.putDouble("ZOOM", this.l.c());
    paramBundle.putDouble("CENTERX", this.l.b().b());
    paramBundle.putDouble("CENTERY", this.l.b().a());
  }
  
  public final void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.p.a();
    }
    ti.a(tp.j());
    this.p.a(s());
    a(false, false);
  }
  
  public final tj c()
  {
    return this.l;
  }
  
  public final void c(int paramInt)
  {
    if ((this.t != null) && (this.t.getVisibility() == 0))
    {
      this.t.a(paramInt);
      this.t.invalidate();
    }
  }
  
  public final void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.t.setVisibility(0);
      this.t.d();
      return;
    }
    uc.b();
    uc.c();
    this.t.setVisibility(8);
  }
  
  public final uy d()
  {
    return this.j;
  }
  
  protected final void d(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public final th e()
  {
    return this.k;
  }
  
  public final th.1 f()
  {
    return this.r;
  }
  
  protected final void f(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }
  
  public final uf.1 g()
  {
    return this.n;
  }
  
  public final void g(boolean paramBoolean)
  {
    if (paramBoolean != this.B)
    {
      this.B = paramBoolean;
      a(false, false);
    }
  }
  
  public final to h()
  {
    return this.m;
  }
  
  public final us i()
  {
    return this.o;
  }
  
  public final void j()
  {
    this.t.e();
  }
  
  public final void k()
  {
    this.t.d();
  }
  
  public final int l()
  {
    return this.u;
  }
  
  public final void m()
  {
    uo.a();
    this.t.a();
    this.s.a();
    this.k.b();
    this.j.g();
    this.j.removeAllViews();
    this.n.a();
    this.p.b();
    tm.a().b();
    ug.a().c();
    new tn.1(this).start();
    System.gc();
  }
  
  protected final void o()
  {
    if (this.v != null)
    {
      this.j.setDrawingCacheEnabled(true);
      this.j.buildDrawingCache();
      if (this.y != null) {
        break label89;
      }
    }
    label89:
    for (Bitmap localBitmap = Bitmap.createBitmap(this.j.getDrawingCache());; localBitmap = Bitmap.createBitmap(this.j.getDrawingCache(), this.y.left, this.y.top, this.y.width(), this.y.height()))
    {
      this.j.destroyDrawingCache();
      this.v.a(localBitmap);
      if ((Build.VERSION.SDK_INT > 11) && (this.A) && (this.l != null)) {
        this.l.setLayerType(2, null);
      }
      return;
    }
  }
  
  public final boolean r()
  {
    return this.B;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.tn
 * JD-Core Version:    0.7.0.1
 */