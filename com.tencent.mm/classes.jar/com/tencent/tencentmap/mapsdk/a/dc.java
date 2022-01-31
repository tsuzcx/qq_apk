package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.map.lib.element.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class dc
  implements ct
{
  private int a;
  private boolean b;
  private dd c;
  private String d;
  private boolean e;
  private ar f;
  private boolean g;
  private int h;
  private boolean i;
  private ah.m j;
  private Object k;
  
  public dc(dd paramdd, ar paramar, String paramString)
  {
    AppMethodBeat.i(150043);
    this.a = -1;
    this.b = false;
    this.c = null;
    this.d = "";
    this.e = false;
    this.f = null;
    this.g = false;
    this.h = 0;
    this.i = false;
    this.d = paramString;
    this.c = paramdd;
    this.f = paramar;
    this.i = paramdd.q();
    this.h = paramdd.p();
    this.k = this.c.u();
    AppMethodBeat.o(150043);
  }
  
  public final int a(Context paramContext)
  {
    AppMethodBeat.i(150070);
    ck localck = this.c.e();
    if (localck == null)
    {
      AppMethodBeat.o(150070);
      return 0;
    }
    paramContext = localck.a().a(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(150070);
      return 0;
    }
    int m = paramContext.getWidth();
    AppMethodBeat.o(150070);
    return m;
  }
  
  public final List<j> a()
  {
    AppMethodBeat.i(150075);
    List localList = this.f.h(this.d);
    AppMethodBeat.o(150075);
    return localList;
  }
  
  public final void a(float paramFloat)
  {
    AppMethodBeat.i(150061);
    if (this.f == null)
    {
      AppMethodBeat.o(150061);
      return;
    }
    this.f.a(this.d, paramFloat);
    this.c.a(paramFloat);
    AppMethodBeat.o(150061);
  }
  
  public final void a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(150058);
    if (this.f == null)
    {
      AppMethodBeat.o(150058);
      return;
    }
    this.f.a(this.d, paramFloat1, paramFloat2);
    this.c.a(paramFloat1, paramFloat2);
    AppMethodBeat.o(150058);
  }
  
  public final void a(int paramInt)
  {
    AppMethodBeat.i(150079);
    if ((paramInt < dg.a) || (paramInt > dg.c))
    {
      AppMethodBeat.o(150079);
      return;
    }
    this.f.a(this.d, paramInt);
    this.c.a(paramInt);
    AppMethodBeat.o(150079);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150067);
    this.f.a(this.d, paramInt1, paramInt2);
    this.f.a(this.d, false);
    this.c.a(false);
    AppMethodBeat.o(150067);
  }
  
  public final void a(ck paramck)
  {
    AppMethodBeat.i(150060);
    if (this.f == null)
    {
      AppMethodBeat.o(150060);
      return;
    }
    this.f.a(this.d, paramck);
    this.c.a(paramck);
    AppMethodBeat.o(150060);
  }
  
  public final void a(cz paramcz)
  {
    AppMethodBeat.i(150045);
    if ((this.f == null) || (paramcz == null))
    {
      AppMethodBeat.o(150045);
      return;
    }
    this.f.a(this.d, paramcz);
    this.c.a(paramcz);
    AppMethodBeat.o(150045);
  }
  
  public final void a(Object paramObject)
  {
    this.k = paramObject;
  }
  
  public final void a(String paramString)
  {
    AppMethodBeat.i(150048);
    if (this.f == null)
    {
      AppMethodBeat.o(150048);
      return;
    }
    this.c.a(paramString);
    this.f.b(this.d, paramString);
    AppMethodBeat.o(150048);
  }
  
  public final void a(boolean paramBoolean)
  {
    AppMethodBeat.i(150053);
    if (this.f == null)
    {
      AppMethodBeat.o(150053);
      return;
    }
    this.f.a(this.d, paramBoolean);
    ar localar = this.f;
    String str = this.d;
    if ((!paramBoolean) && (o())) {}
    for (boolean bool = true;; bool = false)
    {
      localar.d(str, bool);
      this.c.a(paramBoolean);
      AppMethodBeat.o(150053);
      return;
    }
  }
  
  public final int b(Context paramContext)
  {
    AppMethodBeat.i(150071);
    ck localck = this.c.e();
    if (localck == null)
    {
      AppMethodBeat.o(150071);
      return 0;
    }
    paramContext = localck.a().a(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(150071);
      return 0;
    }
    int m = paramContext.getHeight();
    AppMethodBeat.o(150071);
    return m;
  }
  
  public final void b()
  {
    AppMethodBeat.i(150044);
    if (this.f == null)
    {
      AppMethodBeat.o(150044);
      return;
    }
    this.f.a(this.d);
    AppMethodBeat.o(150044);
  }
  
  public final void b(float paramFloat)
  {
    AppMethodBeat.i(150064);
    if (this.f == null)
    {
      AppMethodBeat.o(150064);
      return;
    }
    this.f.b(this.d, paramFloat);
    this.c.b(paramFloat);
    AppMethodBeat.o(150064);
  }
  
  public final void b(String paramString)
  {
    AppMethodBeat.i(150050);
    if (this.f == null)
    {
      AppMethodBeat.o(150050);
      return;
    }
    this.c.b(paramString);
    this.f.a(this.d, paramString);
    AppMethodBeat.o(150050);
  }
  
  public final void b(boolean paramBoolean)
  {
    AppMethodBeat.i(150059);
    if (this.f == null)
    {
      AppMethodBeat.o(150059);
      return;
    }
    this.f.b(this.d, paramBoolean);
    this.c.b(paramBoolean);
    AppMethodBeat.o(150059);
  }
  
  public final String c()
  {
    return this.d;
  }
  
  public final void c(float paramFloat)
  {
    AppMethodBeat.i(150068);
    this.f.c(this.d, paramFloat);
    this.c.c(paramFloat);
    AppMethodBeat.o(150068);
  }
  
  public final void c(String paramString)
  {
    AppMethodBeat.i(150076);
    if (this.c != null) {
      this.c.c(paramString);
    }
    AppMethodBeat.o(150076);
  }
  
  public final void c(boolean paramBoolean)
  {
    AppMethodBeat.i(150065);
    if (this.f == null)
    {
      AppMethodBeat.o(150065);
      return;
    }
    this.f.c(this.d, paramBoolean);
    AppMethodBeat.o(150065);
  }
  
  public final boolean d()
  {
    AppMethodBeat.i(150046);
    boolean bool = this.c.j();
    AppMethodBeat.o(150046);
    return bool;
  }
  
  public final cz e()
  {
    AppMethodBeat.i(150047);
    cz localcz2 = this.f.b(this.d);
    cz localcz1 = localcz2;
    if (localcz2 == null) {
      localcz1 = this.c.b();
    }
    AppMethodBeat.o(150047);
    return localcz1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(100995);
    if (!(paramObject instanceof dc))
    {
      AppMethodBeat.o(100995);
      return false;
    }
    paramObject = (dc)paramObject;
    boolean bool = this.d.equals(paramObject.d);
    AppMethodBeat.o(100995);
    return bool;
  }
  
  public final String f()
  {
    AppMethodBeat.i(150049);
    String str = this.c.c();
    AppMethodBeat.o(150049);
    return str;
  }
  
  public final String g()
  {
    AppMethodBeat.i(150051);
    String str = this.c.d();
    AppMethodBeat.o(150051);
    return str;
  }
  
  public final float h()
  {
    AppMethodBeat.i(150052);
    float f1 = this.c.k();
    AppMethodBeat.o(150052);
    return f1;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(150074);
    int m = this.d.hashCode();
    AppMethodBeat.o(150074);
    return m;
  }
  
  public final boolean i()
  {
    AppMethodBeat.i(150054);
    boolean bool = this.c.h();
    AppMethodBeat.o(150054);
    return bool;
  }
  
  public final void j()
  {
    AppMethodBeat.i(150055);
    if (this.f == null)
    {
      AppMethodBeat.o(150055);
      return;
    }
    this.f.c(this.d);
    AppMethodBeat.o(150055);
  }
  
  public final void k()
  {
    AppMethodBeat.i(150056);
    if (this.f == null)
    {
      AppMethodBeat.o(150056);
      return;
    }
    this.f.d(this.d);
    AppMethodBeat.o(150056);
  }
  
  public final boolean l()
  {
    AppMethodBeat.i(150057);
    if (this.f == null)
    {
      AppMethodBeat.o(150057);
      return false;
    }
    boolean bool = this.f.e(this.d);
    AppMethodBeat.o(150057);
    return bool;
  }
  
  public final float m()
  {
    AppMethodBeat.i(150062);
    if (this.f == null)
    {
      AppMethodBeat.o(150062);
      return 0.0F;
    }
    float f1 = this.f.f(this.d);
    AppMethodBeat.o(150062);
    return f1;
  }
  
  public final boolean n()
  {
    AppMethodBeat.i(150063);
    if (this.f == null)
    {
      AppMethodBeat.o(150063);
      return false;
    }
    boolean bool = this.c.i();
    AppMethodBeat.o(150063);
    return bool;
  }
  
  final boolean o()
  {
    AppMethodBeat.i(150066);
    boolean bool = this.f.g(this.d);
    AppMethodBeat.o(150066);
    return bool;
  }
  
  public final float p()
  {
    AppMethodBeat.i(150069);
    if (this.c != null)
    {
      float f1 = this.c.l();
      AppMethodBeat.o(150069);
      return f1;
    }
    AppMethodBeat.o(150069);
    return 0.0F;
  }
  
  public final float q()
  {
    AppMethodBeat.i(150072);
    float f1 = this.c.f();
    AppMethodBeat.o(150072);
    return f1;
  }
  
  public final float r()
  {
    AppMethodBeat.i(150073);
    float f1 = this.c.g();
    AppMethodBeat.o(150073);
    return f1;
  }
  
  public final ah.m s()
  {
    return this.j;
  }
  
  public final Object t()
  {
    return this.k;
  }
  
  public final String u()
  {
    AppMethodBeat.i(150077);
    if (this.c != null)
    {
      String str = this.c.w();
      AppMethodBeat.o(150077);
      return str;
    }
    AppMethodBeat.o(150077);
    return null;
  }
  
  public final int v()
  {
    AppMethodBeat.i(150078);
    int m = this.c.x();
    AppMethodBeat.o(150078);
    return m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dc
 * JD-Core Version:    0.7.0.1
 */