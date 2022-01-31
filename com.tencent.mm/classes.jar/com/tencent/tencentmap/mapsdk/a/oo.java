package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.map.lib.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class oo
  extends pk
  implements mt.a, nw
{
  public Handler a = new oo.1(this, Looper.getMainLooper());
  private ViewGroup b = null;
  private ma c = null;
  private mu d;
  private ms e;
  private mq f;
  private mo g;
  private int h;
  private List<mp> i = new ArrayList();
  private boolean j = false;
  
  public oo(ViewGroup paramViewGroup, View paramView)
  {
    this.b = paramViewGroup;
    this.c = ((ma)paramView);
    paramViewGroup = this.b.getContext().getApplicationContext();
    if (this.b.indexOfChild(this.c) < 0)
    {
      paramView = new FrameLayout.LayoutParams(-1, -1);
      this.b.addView(this.c, 0, paramView);
      this.b.requestLayout();
    }
    int m = 4;
    int k = 20;
    if (this.c.getMap() != null)
    {
      m = this.c.getMap().b();
      k = ok.a(this.c.getMap().c());
    }
    this.e = new ms(paramViewGroup, m, k);
    this.c.setLogoAndScaleManager(this.e);
    this.f = new mq(paramViewGroup, (af)this.b);
    this.c.setIndoorFloorControlManager(this.f);
    this.d = new mu(paramViewGroup, this.c);
    this.i.add(this.e);
    this.i.add(this.d);
    this.c.setMapEventHandler(this);
    this.c.a(this);
  }
  
  private void g()
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((mp)localIterator.next()).a(this.b);
    }
  }
  
  public void a()
  {
    if ((this.b == null) || (this.c == null)) {
      return;
    }
    if (this.a != null) {
      this.a.removeCallbacksAndMessages(null);
    }
    this.b.removeAllViews();
    this.c.setMapEventHandler(null);
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((mp)localIterator.next()).a();
    }
    this.d = null;
    this.d = null;
    this.i.clear();
    this.i = null;
    this.c = null;
    this.b = null;
  }
  
  void a(float paramFloat)
  {
    if (this.e != null) {
      this.e.a(paramFloat);
    }
  }
  
  void a(int paramInt)
  {
    if (this.e != null)
    {
      this.e.a(mp.b.a(paramInt));
      g();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.h = paramInt2;
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      mp localmp = (mp)localIterator.next();
      localmp.a(paramInt1, paramInt2);
      localmp.a(this.b);
    }
  }
  
  void a(int paramInt, int[] paramArrayOfInt)
  {
    if (this.e != null)
    {
      mp.b localb = mp.b.a(paramInt);
      this.e.a(localb);
      switch (oo.2.a[localb.ordinal()])
      {
      }
    }
    for (;;)
    {
      this.e.c();
      g();
      return;
      this.e.a(mp.a.d, paramArrayOfInt[0]);
      this.e.a(mp.a.a, paramArrayOfInt[1]);
      continue;
      this.e.a(mp.a.c, paramArrayOfInt[0]);
      this.e.a(mp.a.a, paramArrayOfInt[1]);
      continue;
      this.e.a(mp.a.c, paramArrayOfInt[0]);
      this.e.a(mp.a.b, paramArrayOfInt[1]);
      continue;
      this.e.a(mp.a.d, paramArrayOfInt[0]);
      this.e.a(mp.a.b, paramArrayOfInt[1]);
    }
  }
  
  public void a(mt parammt)
  {
    if ((parammt != null) && (parammt.a != -1))
    {
      parammt = this.a.obtainMessage(parammt.a, parammt);
      this.a.sendMessage(parammt);
    }
  }
  
  public void a(oo.a parama)
  {
    if (this.d != null) {
      this.d.a(parama);
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.d.a(paramBoolean);
  }
  
  void b(int paramInt)
  {
    if (this.e != null)
    {
      this.e.b(mp.b.a(paramInt));
      g();
    }
  }
  
  void b(boolean paramBoolean)
  {
    this.c.setCompassEnable(paramBoolean);
  }
  
  boolean b()
  {
    return this.c.n();
  }
  
  void c(boolean paramBoolean)
  {
    this.c.setScrollGestureEnable(paramBoolean);
  }
  
  boolean c()
  {
    return this.c.o();
  }
  
  void d(boolean paramBoolean)
  {
    this.c.setZoomGestureEnable(paramBoolean);
  }
  
  boolean d()
  {
    return this.c.p();
  }
  
  void e(boolean paramBoolean)
  {
    this.c.setSkewGestureEnable(paramBoolean);
  }
  
  public boolean e()
  {
    if (this.f != null) {
      return this.f.b();
    }
    return false;
  }
  
  void f(boolean paramBoolean)
  {
    this.c.setRotateGestureEnable(paramBoolean);
  }
  
  boolean f()
  {
    if (this.e != null) {
      return this.e.d();
    }
    return false;
  }
  
  void g(boolean paramBoolean)
  {
    this.c.setAllGestureEnable(paramBoolean);
    c(paramBoolean);
    d(paramBoolean);
    e(paramBoolean);
    f(paramBoolean);
  }
  
  void h(boolean paramBoolean)
  {
    if (this.e != null) {
      this.e.a(paramBoolean);
    }
  }
  
  public void i(boolean paramBoolean)
  {
    if ((this.e == null) || (this.c == null) || (this.c.getMap() == null)) {
      return;
    }
    if (paramBoolean) {
      this.e.b();
    }
    this.e.a(nb.g());
    this.e.a(this.c.getMapRegion(), this.c.getMap().e());
  }
  
  void j(boolean paramBoolean)
  {
    if ((this.c != null) && (this.c.getMap() != null)) {
      this.c.getMap().j(paramBoolean);
    }
  }
  
  public void k(boolean paramBoolean)
  {
    this.f.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.oo
 * JD-Core Version:    0.7.0.1
 */