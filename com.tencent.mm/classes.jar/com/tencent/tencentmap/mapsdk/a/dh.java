package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.element.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class dh
  implements ct
{
  private di a = null;
  private String b = "";
  private ay c = null;
  
  public dh(di paramdi, ay paramay, String paramString)
  {
    this.b = paramString;
    this.a = paramdi;
    this.c = paramay;
  }
  
  public final List<j> a()
  {
    AppMethodBeat.i(150098);
    if (this.c != null)
    {
      List localList = this.c.b(this.b);
      AppMethodBeat.o(150098);
      return localList;
    }
    AppMethodBeat.o(150098);
    return null;
  }
  
  public final void a(float paramFloat)
  {
    AppMethodBeat.i(150085);
    this.c.a(this.b, paramFloat);
    this.a.a(paramFloat);
    AppMethodBeat.o(150085);
  }
  
  public final void a(int paramInt)
  {
    AppMethodBeat.i(150087);
    this.c.b(this.b, paramInt);
    this.a.a(paramInt);
    AppMethodBeat.o(150087);
  }
  
  public final void a(List<cz> paramList)
  {
    AppMethodBeat.i(150083);
    if (this.c == null)
    {
      AppMethodBeat.o(150083);
      return;
    }
    this.c.a(this.b, paramList);
    this.a.a(paramList);
    AppMethodBeat.o(150083);
  }
  
  public final void a(boolean paramBoolean)
  {
    AppMethodBeat.i(150093);
    this.c.a(this.b, paramBoolean);
    this.a.a(paramBoolean);
    AppMethodBeat.o(150093);
  }
  
  public final boolean a(cz paramcz)
  {
    AppMethodBeat.i(150097);
    List localList = d();
    if ((localList == null) || (localList.size() < 3) || (paramcz == null))
    {
      AppMethodBeat.o(150097);
      return false;
    }
    int j = localList.size() - 1;
    int k = 0;
    int i = 0;
    while (i < localList.size())
    {
      if (((cz)localList.get(i)).equals(paramcz))
      {
        AppMethodBeat.o(150097);
        return true;
      }
      i += 1;
    }
    i = 0;
    if (i < localList.size())
    {
      int m;
      if ((((cz)localList.get(i)).a >= paramcz.a) || (((cz)localList.get(j)).a < paramcz.a))
      {
        m = k;
        if (((cz)localList.get(j)).a < paramcz.a)
        {
          m = k;
          if (((cz)localList.get(i)).a < paramcz.a) {}
        }
      }
      else if (((cz)localList.get(i)).b > paramcz.b)
      {
        m = k;
        if (((cz)localList.get(j)).b > paramcz.b) {}
      }
      else
      {
        if (((cz)localList.get(i)).b + (paramcz.a - ((cz)localList.get(i)).a) / (((cz)localList.get(j)).a - ((cz)localList.get(i)).a) * (((cz)localList.get(j)).b - ((cz)localList.get(i)).b) > paramcz.b) {
          break label376;
        }
      }
      label376:
      for (j = 1;; j = 0)
      {
        m = k ^ j;
        j = i;
        i += 1;
        k = m;
        break;
      }
    }
    AppMethodBeat.o(150097);
    return k;
  }
  
  public final void b()
  {
    AppMethodBeat.i(150082);
    if (this.c == null)
    {
      AppMethodBeat.o(150082);
      return;
    }
    this.c.a(this.b);
    AppMethodBeat.o(150082);
  }
  
  public final void b(int paramInt)
  {
    AppMethodBeat.i(150089);
    this.c.a(this.b, paramInt);
    this.a.b(paramInt);
    AppMethodBeat.o(150089);
  }
  
  public final String c()
  {
    return this.b;
  }
  
  public final void c(int paramInt)
  {
    AppMethodBeat.i(150091);
    this.c.b(this.b, paramInt);
    this.a.c(paramInt);
    AppMethodBeat.o(150091);
  }
  
  public final List<cz> d()
  {
    AppMethodBeat.i(150084);
    List localList = this.a.a();
    AppMethodBeat.o(150084);
    return localList;
  }
  
  public final void d(int paramInt)
  {
    AppMethodBeat.i(150100);
    if ((paramInt < dg.a) || (paramInt > dg.c))
    {
      AppMethodBeat.o(150100);
      return;
    }
    this.c.c(this.b, paramInt);
    this.a.d(paramInt);
    AppMethodBeat.o(150100);
  }
  
  public final float e()
  {
    AppMethodBeat.i(150086);
    float f = this.a.b();
    AppMethodBeat.o(150086);
    return f;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(150095);
    if (!(paramObject instanceof dh))
    {
      AppMethodBeat.o(150095);
      return false;
    }
    paramObject = (dh)paramObject;
    boolean bool = this.b.equals(paramObject.b);
    AppMethodBeat.o(150095);
    return bool;
  }
  
  public final int f()
  {
    AppMethodBeat.i(150088);
    int i = this.a.c();
    AppMethodBeat.o(150088);
    return i;
  }
  
  public final int g()
  {
    AppMethodBeat.i(150090);
    int i = this.a.d();
    AppMethodBeat.o(150090);
    return i;
  }
  
  public final float h()
  {
    AppMethodBeat.i(150092);
    float f = this.a.e();
    AppMethodBeat.o(150092);
    return f;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(150096);
    int i = this.b.hashCode();
    AppMethodBeat.o(150096);
    return i;
  }
  
  public final boolean i()
  {
    AppMethodBeat.i(150094);
    boolean bool = this.a.f();
    AppMethodBeat.o(150094);
    return bool;
  }
  
  public final int j()
  {
    AppMethodBeat.i(150099);
    int i = this.a.h();
    AppMethodBeat.o(150099);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dh
 * JD-Core Version:    0.7.0.1
 */