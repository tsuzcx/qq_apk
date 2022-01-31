package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.element.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.kb;
import java.util.List;

public final class co
  implements ct
{
  private cp a = null;
  private String b = "";
  private bn c = null;
  
  public co(cp paramcp, bn parambn, String paramString)
  {
    this.b = paramString;
    this.a = paramcp;
    this.c = parambn;
  }
  
  public final List<j> a()
  {
    AppMethodBeat.i(150016);
    if (this.c != null)
    {
      List localList = this.c.b(this.b);
      AppMethodBeat.o(150016);
      return localList;
    }
    AppMethodBeat.o(150016);
    return null;
  }
  
  public final void a(double paramDouble)
  {
    AppMethodBeat.i(150003);
    if (paramDouble < 0.0D)
    {
      AppMethodBeat.o(150003);
      return;
    }
    if (this.c == null)
    {
      AppMethodBeat.o(150003);
      return;
    }
    this.c.a(this.b, paramDouble);
    this.a.a(paramDouble);
    AppMethodBeat.o(150003);
  }
  
  public final void a(float paramFloat)
  {
    AppMethodBeat.i(150005);
    if (paramFloat < 0.0F)
    {
      AppMethodBeat.o(150005);
      return;
    }
    this.c.a(this.b, paramFloat);
    this.a.a(paramFloat);
    AppMethodBeat.o(150005);
  }
  
  public final void a(int paramInt)
  {
    AppMethodBeat.i(150007);
    this.c.b(this.b, paramInt);
    this.a.a(paramInt);
    AppMethodBeat.o(150007);
  }
  
  public final void a(boolean paramBoolean)
  {
    AppMethodBeat.i(150013);
    this.c.a(this.b, paramBoolean);
    this.a.a(paramBoolean);
    AppMethodBeat.o(150013);
  }
  
  public final boolean a(cz paramcz)
  {
    AppMethodBeat.i(149999);
    if (kb.a(d(), paramcz) < e())
    {
      AppMethodBeat.o(149999);
      return true;
    }
    AppMethodBeat.o(149999);
    return false;
  }
  
  public final void b()
  {
    AppMethodBeat.i(150000);
    if (this.c == null)
    {
      AppMethodBeat.o(150000);
      return;
    }
    this.c.a(this.b);
    AppMethodBeat.o(150000);
  }
  
  public final void b(int paramInt)
  {
    AppMethodBeat.i(150009);
    this.c.a(this.b, paramInt);
    this.a.b(paramInt);
    AppMethodBeat.o(150009);
  }
  
  public final void b(cz paramcz)
  {
    AppMethodBeat.i(150001);
    if (this.c == null)
    {
      AppMethodBeat.o(150001);
      return;
    }
    this.c.a(this.b, paramcz);
    this.a.a(paramcz);
    AppMethodBeat.o(150001);
  }
  
  public final String c()
  {
    return this.b;
  }
  
  public final void c(int paramInt)
  {
    AppMethodBeat.i(150011);
    this.c.b(this.b, paramInt);
    this.a.c(paramInt);
    AppMethodBeat.o(150011);
  }
  
  public final cz d()
  {
    AppMethodBeat.i(150002);
    cz localcz = new cz(this.a.a().a, this.a.a().b);
    AppMethodBeat.o(150002);
    return localcz;
  }
  
  public final void d(int paramInt)
  {
    AppMethodBeat.i(150018);
    if ((paramInt < dg.a) || (paramInt > dg.c))
    {
      AppMethodBeat.o(150018);
      return;
    }
    this.c.c(this.b, paramInt);
    this.a.d(paramInt);
    AppMethodBeat.o(150018);
  }
  
  public final double e()
  {
    AppMethodBeat.i(150004);
    double d = this.a.b();
    AppMethodBeat.o(150004);
    return d;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(150015);
    if (!(paramObject instanceof co))
    {
      AppMethodBeat.o(150015);
      return false;
    }
    paramObject = (co)paramObject;
    boolean bool = this.b.equals(paramObject.b);
    AppMethodBeat.o(150015);
    return bool;
  }
  
  public final float f()
  {
    AppMethodBeat.i(150006);
    float f = this.a.c();
    AppMethodBeat.o(150006);
    return f;
  }
  
  public final int g()
  {
    AppMethodBeat.i(150008);
    int i = this.a.d();
    AppMethodBeat.o(150008);
    return i;
  }
  
  public final int h()
  {
    AppMethodBeat.i(150010);
    int i = this.a.e();
    AppMethodBeat.o(150010);
    return i;
  }
  
  public final int hashCode()
  {
    return 0;
  }
  
  public final float i()
  {
    AppMethodBeat.i(150012);
    float f = this.a.f();
    AppMethodBeat.o(150012);
    return f;
  }
  
  public final boolean j()
  {
    AppMethodBeat.i(150014);
    boolean bool = this.a.g();
    AppMethodBeat.o(150014);
    return bool;
  }
  
  public final int k()
  {
    AppMethodBeat.i(150017);
    int i = this.a.h();
    AppMethodBeat.o(150017);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.co
 * JD-Core Version:    0.7.0.1
 */