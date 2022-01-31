package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.List;

public final class qf
  implements px
{
  private int a = -1;
  private boolean b = false;
  private qg c = null;
  private String d = "";
  private boolean e = false;
  private nx f = null;
  private boolean g = false;
  private int h = 0;
  private boolean i = false;
  private ah.m j;
  private Object k;
  
  public qf(qg paramqg, nx paramnx, String paramString)
  {
    this.d = paramString;
    this.c = paramqg;
    this.f = paramnx;
    this.i = paramqg.q();
    this.h = paramqg.p();
    this.k = this.c.u();
  }
  
  public final int a(Context paramContext)
  {
    pr localpr = this.c.e();
    if (localpr == null) {}
    do
    {
      return 0;
      paramContext = localpr.a().a(paramContext);
    } while (paramContext == null);
    return paramContext.getWidth();
  }
  
  public final List<kj> a()
  {
    return this.f.h(this.d);
  }
  
  public final void a(float paramFloat)
  {
    if (this.f == null) {
      return;
    }
    this.f.a(this.d, paramFloat);
    this.c.a(paramFloat);
  }
  
  public final void a(float paramFloat1, float paramFloat2)
  {
    if (this.f == null) {
      return;
    }
    this.f.a(this.d, paramFloat1, paramFloat2);
    this.c.a(paramFloat1, paramFloat2);
  }
  
  public final void a(pr parampr)
  {
    if (this.f == null) {
      return;
    }
    this.f.a(this.d, parampr);
    this.c.a(parampr);
  }
  
  public final void a(qc paramqc)
  {
    if ((this.f == null) || (paramqc == null)) {
      return;
    }
    this.f.a(this.d, paramqc);
    this.c.a(paramqc);
  }
  
  public final void a(Object paramObject)
  {
    this.k = paramObject;
  }
  
  public final void a(String paramString)
  {
    if (this.f == null) {
      return;
    }
    this.c.a(paramString);
    this.f.b(this.d, paramString);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.f == null) {
      return;
    }
    this.f.a(this.d, paramBoolean);
    nx localnx = this.f;
    String str = this.d;
    if ((!paramBoolean) && (o())) {}
    for (boolean bool = true;; bool = false)
    {
      localnx.c(str, bool);
      this.c.a(paramBoolean);
      return;
    }
  }
  
  public final int b(Context paramContext)
  {
    pr localpr = this.c.e();
    if (localpr == null) {}
    do
    {
      return 0;
      paramContext = localpr.a().a(paramContext);
    } while (paramContext == null);
    return paramContext.getHeight();
  }
  
  public final void b()
  {
    if (this.f == null) {
      return;
    }
    this.f.a(this.d);
  }
  
  public final void b(float paramFloat)
  {
    if (this.f == null) {
      return;
    }
    this.f.b(this.d, paramFloat);
    this.c.b(paramFloat);
  }
  
  public final void b(String paramString)
  {
    if (this.f == null) {
      return;
    }
    this.c.b(paramString);
    this.f.a(this.d, paramString);
  }
  
  public final void b(boolean paramBoolean)
  {
    if (this.f == null) {
      return;
    }
    this.f.b(this.d, paramBoolean);
    this.c.b(paramBoolean);
  }
  
  public final String c()
  {
    return this.d;
  }
  
  public final void c(float paramFloat)
  {
    this.f.c(this.d, paramFloat);
    this.c.c(paramFloat);
  }
  
  public final boolean d()
  {
    return this.c.j();
  }
  
  public final qc e()
  {
    qc localqc2 = this.f.b(this.d);
    qc localqc1 = localqc2;
    if (localqc2 == null) {
      localqc1 = this.c.b();
    }
    return localqc1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof qf)) {
      return false;
    }
    paramObject = (qf)paramObject;
    return this.d.equals(paramObject.d);
  }
  
  public final String f()
  {
    return this.c.c();
  }
  
  public final String g()
  {
    return this.c.d();
  }
  
  public final float h()
  {
    return this.c.k();
  }
  
  public final int hashCode()
  {
    return this.d.hashCode();
  }
  
  public final boolean i()
  {
    return this.c.h();
  }
  
  public final void j()
  {
    if (this.f == null) {
      return;
    }
    this.f.c(this.d);
  }
  
  public final void k()
  {
    if (this.f == null) {
      return;
    }
    this.f.d(this.d);
  }
  
  public final boolean l()
  {
    if (this.f == null) {
      return false;
    }
    return this.f.e(this.d);
  }
  
  public final float m()
  {
    if (this.f == null) {
      return 0.0F;
    }
    return this.f.f(this.d);
  }
  
  public final boolean n()
  {
    if (this.f == null) {
      return false;
    }
    return this.c.i();
  }
  
  final boolean o()
  {
    return this.f.g(this.d);
  }
  
  public final float p()
  {
    if (this.c != null) {
      return this.c.l();
    }
    return 0.0F;
  }
  
  public final float q()
  {
    return this.c.f();
  }
  
  public final float r()
  {
    return this.c.g();
  }
  
  public final ah.m s()
  {
    return this.j;
  }
  
  public final Object t()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.qf
 * JD-Core Version:    0.7.0.1
 */