package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.element.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class dj
  implements ct
{
  private dk a = null;
  private String b = "";
  private ba c = null;
  
  public dj(dk paramdk, ba paramba, String paramString)
  {
    this.b = paramString;
    this.a = paramdk;
    this.c = paramba;
  }
  
  public final List<j> a()
  {
    AppMethodBeat.i(101053);
    List localList = this.c.b(this.b);
    AppMethodBeat.o(101053);
    return localList;
  }
  
  public final void a(float paramFloat)
  {
    AppMethodBeat.i(101040);
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = 1.0F;
    }
    this.c.a(this.b, f);
    this.a.a(f);
    AppMethodBeat.o(101040);
  }
  
  public final void a(int paramInt)
  {
    AppMethodBeat.i(101042);
    this.c.a(this.b, paramInt);
    this.a.a(paramInt);
    AppMethodBeat.o(101042);
  }
  
  public final void a(int paramInt, cz paramcz)
  {
    AppMethodBeat.i(150107);
    this.c.a(this.b, paramInt, paramcz);
    AppMethodBeat.o(150107);
  }
  
  public final void a(ck paramck)
  {
    AppMethodBeat.i(150104);
    this.c.a(this.b, paramck);
    AppMethodBeat.o(150104);
  }
  
  public final void a(List<cz> paramList)
  {
    AppMethodBeat.i(101038);
    this.c.a(this.b, paramList);
    this.a.a(paramList);
    AppMethodBeat.o(101038);
  }
  
  public final void a(boolean paramBoolean)
  {
    AppMethodBeat.i(101048);
    this.c.a(this.b, paramBoolean);
    this.a.a(paramBoolean);
    AppMethodBeat.o(101048);
  }
  
  public final void b()
  {
    AppMethodBeat.i(101037);
    if (this.c == null)
    {
      AppMethodBeat.o(101037);
      return;
    }
    this.c.a(this.b);
    AppMethodBeat.o(101037);
  }
  
  public final void b(int paramInt)
  {
    AppMethodBeat.i(101044);
    this.c.b(this.b, Math.max(0, paramInt));
    this.a.d(Math.max(0, paramInt));
    AppMethodBeat.o(101044);
  }
  
  public final void b(boolean paramBoolean)
  {
    AppMethodBeat.i(150108);
    this.c.b(this.b, paramBoolean);
    AppMethodBeat.o(150108);
  }
  
  public final String c()
  {
    return this.b;
  }
  
  public final void c(int paramInt)
  {
    AppMethodBeat.i(101046);
    if ((paramInt < dg.a) || (paramInt > dg.c))
    {
      AppMethodBeat.o(101046);
      return;
    }
    this.c.b(this.b, paramInt);
    this.a.f(paramInt);
    AppMethodBeat.o(101046);
  }
  
  public final List<cz> d()
  {
    AppMethodBeat.i(101039);
    List localList = this.a.e();
    AppMethodBeat.o(101039);
    return localList;
  }
  
  public final float e()
  {
    AppMethodBeat.i(101041);
    float f = this.a.f();
    AppMethodBeat.o(101041);
    return f;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(101050);
    if (!(paramObject instanceof dj))
    {
      AppMethodBeat.o(101050);
      return false;
    }
    paramObject = (dj)paramObject;
    boolean bool = this.b.equals(paramObject.b);
    AppMethodBeat.o(101050);
    return bool;
  }
  
  public final int f()
  {
    AppMethodBeat.i(101043);
    int i = this.a.g();
    AppMethodBeat.o(101043);
    return i;
  }
  
  public final int g()
  {
    AppMethodBeat.i(101045);
    int i = this.a.i();
    AppMethodBeat.o(101045);
    return i;
  }
  
  public final boolean h()
  {
    AppMethodBeat.i(150105);
    boolean bool = this.a.k();
    AppMethodBeat.o(150105);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(101051);
    int i = this.b.hashCode();
    AppMethodBeat.o(101051);
    return i;
  }
  
  public final List<Integer> i()
  {
    AppMethodBeat.i(150106);
    List localList = this.a.x();
    AppMethodBeat.o(150106);
    return localList;
  }
  
  public final boolean j()
  {
    AppMethodBeat.i(150109);
    if (this.a != null)
    {
      boolean bool = this.a.w();
      AppMethodBeat.o(150109);
      return bool;
    }
    AppMethodBeat.o(150109);
    return false;
  }
  
  public final int k()
  {
    AppMethodBeat.i(150110);
    int i = this.a.t();
    AppMethodBeat.o(150110);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dj
 * JD-Core Version:    0.7.0.1
 */