package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.ViewConfiguration;
import com.tencent.map.lib.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class im
  implements id
{
  private final long a;
  private final long b;
  private float c;
  private float d;
  private hl e;
  private boolean f;
  private float g;
  private e h;
  private boolean i;
  private final float j;
  private WeakReference<ic> k;
  
  public im(hl paramhl)
  {
    AppMethodBeat.i(148551);
    this.a = 250L;
    this.b = 1200L;
    this.c = ViewConfiguration.getMinimumFlingVelocity();
    this.d = ViewConfiguration.getMaximumFlingVelocity();
    this.i = false;
    this.e = paramhl;
    this.k = paramhl.b();
    if ((this.k != null) && (this.k.get() != null))
    {
      ((ic)this.k.get()).a(this);
      Object localObject = ((ic)this.k.get()).i();
      if (localObject != null)
      {
        localObject = ViewConfiguration.get((Context)localObject);
        this.c = ((ViewConfiguration)localObject).getScaledMinimumFlingVelocity();
        this.d = ((ViewConfiguration)localObject).getScaledMaximumFlingVelocity();
      }
    }
    this.h = new e();
    this.j = (paramhl.h() * 2.5F);
    AppMethodBeat.o(148551);
  }
  
  private static float b(float paramFloat)
  {
    if (paramFloat < 5.0F) {
      return 0.2F + 0.8F * paramFloat / 5.0F;
    }
    return 1.0F + (paramFloat - 5.0F) * 4.0F / 5.0F;
  }
  
  private void l(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148565);
    this.i = true;
    if (this.f)
    {
      AppMethodBeat.o(148565);
      return;
    }
    float f1 = paramFloat1 / 64.0F;
    float f2 = paramFloat2 / 64.0F;
    if ((Math.abs(f1) < this.j) && (Math.abs(f2) < this.j))
    {
      AppMethodBeat.o(148565);
      return;
    }
    long l1 = ((Math.max(Math.abs(paramFloat1), Math.abs(paramFloat2)) - this.c) / (this.d - this.c) * 950.0F);
    Object localObject = new PointF(f1, f2);
    long l2 = System.currentTimeMillis();
    this.f = true;
    localObject = new im.4(this, 3, new double[] { 0.0D, 0.0D }, l2, l1 + 250L, (PointF)localObject);
    this.e.a().b((hv)localObject);
    AppMethodBeat.o(148565);
  }
  
  private boolean m(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148566);
    boolean bool = this.e.c().a(this.e.d(), paramFloat1, paramFloat2);
    AppMethodBeat.o(148566);
    return bool;
  }
  
  public void a() {}
  
  public void a(e parame)
  {
    AppMethodBeat.i(148552);
    this.h = parame;
    boolean bool = parame.a();
    if ((this.k == null) || (this.k.get() != null))
    {
      AppMethodBeat.o(148552);
      return;
    }
    if (bool)
    {
      ((ic)this.k.get()).b(this);
      AppMethodBeat.o(148552);
      return;
    }
    ((ic)this.k.get()).a(this);
    AppMethodBeat.o(148552);
  }
  
  public boolean a(float paramFloat)
  {
    AppMethodBeat.i(148561);
    if (this.h.d())
    {
      if (!this.e.a().B())
      {
        AppMethodBeat.o(148561);
        return false;
      }
      double d1 = paramFloat / 8.0F * 2.0F;
      this.e.a().i(d1);
      AppMethodBeat.o(148561);
      return true;
    }
    AppMethodBeat.o(148561);
    return false;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148553);
    if (this.h.f())
    {
      ii localii = this.e.a();
      localii.a(paramFloat1, paramFloat2, new im.1(this, localii));
    }
    AppMethodBeat.o(148553);
    return false;
  }
  
  public boolean a(PointF paramPointF1, PointF paramPointF2, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(148563);
    if (this.h.i())
    {
      paramDouble1 = paramDouble2 / paramDouble1;
      ii localii = this.e.a();
      localii.a(paramDouble1, paramPointF1.x, paramPointF1.y, paramPointF2.x, paramPointF2.y, new im.3(this, localii));
    }
    AppMethodBeat.o(148563);
    return false;
  }
  
  public boolean a(PointF paramPointF1, PointF paramPointF2, float paramFloat)
  {
    AppMethodBeat.i(148562);
    if ((this.h.e()) && (this.e.a().B())) {
      this.e.a().a(paramFloat, paramPointF1.x, paramPointF1.y, paramPointF2.x, paramPointF2.y);
    }
    AppMethodBeat.o(148562);
    return false;
  }
  
  public boolean b()
  {
    AppMethodBeat.i(148559);
    if (this.h.h())
    {
      ii localii = this.e.a();
      localii.b(new im.2(this, localii));
    }
    AppMethodBeat.o(148559);
    return false;
  }
  
  public boolean b(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148554);
    if (this.h.g())
    {
      boolean bool = m(paramFloat1, paramFloat2);
      AppMethodBeat.o(148554);
      return bool;
    }
    AppMethodBeat.o(148554);
    return false;
  }
  
  public boolean c()
  {
    AppMethodBeat.i(148560);
    if (this.f)
    {
      this.e.a().A();
      this.f = false;
    }
    AppMethodBeat.o(148560);
    return false;
  }
  
  public boolean c(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148555);
    if ((this.h.b()) && (this.h.c())) {
      l(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(148555);
    return false;
  }
  
  public boolean d()
  {
    return false;
  }
  
  public boolean d(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148556);
    if (this.h.b()) {
      this.e.a().a(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(148556);
    return false;
  }
  
  public boolean e(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean f(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148557);
    if (this.h.f()) {
      this.g = this.e.a().l();
    }
    AppMethodBeat.o(148557);
    return false;
  }
  
  public boolean g(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148558);
    if (this.h.f()) {
      this.e.a().j(b((1.0F - paramFloat2 / this.e.g().height()) * 10.0F) * this.g);
    }
    AppMethodBeat.o(148558);
    return true;
  }
  
  public boolean h(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean i(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148564);
    this.e.a().A();
    AppMethodBeat.o(148564);
    return false;
  }
  
  public boolean j(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean k(float paramFloat1, float paramFloat2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.im
 * JD-Core Version:    0.7.0.1
 */