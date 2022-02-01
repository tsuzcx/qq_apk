package com.tencent.mm.vending.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.j.h;
import com.tencent.mm.vending.j.i;
import java.util.Stack;

public final class g
{
  private static final a agvs;
  
  static
  {
    AppMethodBeat.i(74824);
    agvs = new a();
    AppMethodBeat.o(74824);
  }
  
  public static final <Var1, Var2> c<com.tencent.mm.vending.j.c<Var1, Var2>> S(Var1 paramVar1, Var2 paramVar2)
  {
    AppMethodBeat.i(74811);
    paramVar1 = new e().L(new Object[] { paramVar1, paramVar2 });
    AppMethodBeat.o(74811);
    return paramVar1;
  }
  
  public static <$1, $2> com.tencent.mm.vending.j.c<$1, $2> T($1 param$1, $2 param$2)
  {
    AppMethodBeat.i(74818);
    param$1 = com.tencent.mm.vending.j.a.U(param$1, param$2);
    AppMethodBeat.o(74818);
    return param$1;
  }
  
  public static final <Var1, Var2, Var3, Var4, Var5, Var6, Var7> c<h<Var1, Var2, Var3, Var4, Var5, Var6, Var7>> a(Var1 paramVar1, Var2 paramVar2, Var3 paramVar3, Var4 paramVar4, Var5 paramVar5, Var6 paramVar6, Var7 paramVar7)
  {
    AppMethodBeat.i(74816);
    paramVar1 = new e().L(new Object[] { paramVar1, paramVar2, paramVar3, paramVar4, paramVar5, paramVar6, paramVar7 });
    AppMethodBeat.o(74816);
    return paramVar1;
  }
  
  public static final <Var1, Var2, Var3, Var4, Var5, Var6, Var7, Var8> c<i<Var1, Var2, Var3, Var4, Var5, Var6, Var7, Var8>> a(Var1 paramVar1, Var2 paramVar2, Var3 paramVar3, Var4 paramVar4, Var5 paramVar5, Var6 paramVar6, Var7 paramVar7, Var8 paramVar8)
  {
    AppMethodBeat.i(235632);
    paramVar1 = new e().L(new Object[] { paramVar1, paramVar2, paramVar3, paramVar4, paramVar5, paramVar6, paramVar7, paramVar8 });
    AppMethodBeat.o(235632);
    return paramVar1;
  }
  
  public static final void a(b paramb, Object... paramVarArgs)
  {
    AppMethodBeat.i(74821);
    if (paramb == null)
    {
      com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
      AppMethodBeat.o(74821);
      return;
    }
    if (paramVarArgs.length > 0)
    {
      paramb.K(paramVarArgs);
      AppMethodBeat.o(74821);
      return;
    }
    paramb.resume();
    AppMethodBeat.o(74821);
  }
  
  public static final <_Var> void a(d<_Var> paramd)
  {
    AppMethodBeat.i(74823);
    b localb = jJV();
    paramd.a(new d.b()
    {
      public final void onTerminate(_Var paramAnonymous_Var)
      {
        AppMethodBeat.i(74808);
        g.a(this.eqI, new Object[] { paramAnonymous_Var });
        AppMethodBeat.o(74808);
      }
    }).a(new d.a()
    {
      public final void onInterrupt(Object paramAnonymousObject)
      {
        AppMethodBeat.i(74825);
        this.eqI.gM(paramAnonymousObject);
        AppMethodBeat.o(74825);
      }
    });
    AppMethodBeat.o(74823);
  }
  
  public static final <Var1, Var2, Var3, Var4> c<com.tencent.mm.vending.j.e<Var1, Var2, Var3, Var4>> b(Var1 paramVar1, Var2 paramVar2, Var3 paramVar3, Var4 paramVar4)
  {
    AppMethodBeat.i(74813);
    paramVar1 = new e().L(new Object[] { paramVar1, paramVar2, paramVar3, paramVar4 });
    AppMethodBeat.o(74813);
    return paramVar1;
  }
  
  public static final <Var1, Var2, Var3, Var4, Var5> c<com.tencent.mm.vending.j.f<Var1, Var2, Var3, Var4, Var5>> b(Var1 paramVar1, Var2 paramVar2, Var3 paramVar3, Var4 paramVar4, Var5 paramVar5)
  {
    AppMethodBeat.i(74814);
    paramVar1 = new e().L(new Object[] { paramVar1, paramVar2, paramVar3, paramVar4, paramVar5 });
    AppMethodBeat.o(74814);
    return paramVar1;
  }
  
  public static final void d(b paramVarArgs)
  {
    AppMethodBeat.i(74822);
    if (paramVarArgs == null)
    {
      com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
      AppMethodBeat.o(74822);
      return;
    }
    paramVarArgs.gM(null);
    AppMethodBeat.o(74822);
  }
  
  public static final <Var1, Var2, Var3> c<com.tencent.mm.vending.j.d<Var1, Var2, Var3>> f(Var1 paramVar1, Var2 paramVar2, Var3 paramVar3)
  {
    AppMethodBeat.i(74812);
    paramVar1 = new e().L(new Object[] { paramVar1, paramVar2, paramVar3 });
    AppMethodBeat.o(74812);
    return paramVar1;
  }
  
  public static final <Var1> c<Var1> gR(Var1 paramVar1)
  {
    AppMethodBeat.i(74810);
    paramVar1 = new e().L(new Object[] { paramVar1 });
    AppMethodBeat.o(74810);
    return paramVar1;
  }
  
  public static <$1> com.tencent.mm.vending.j.b<$1> gS($1 param$1)
  {
    AppMethodBeat.i(74817);
    param$1 = com.tencent.mm.vending.j.a.gT(param$1);
    AppMethodBeat.o(74817);
    return param$1;
  }
  
  public static final b jJL()
  {
    AppMethodBeat.i(74819);
    Object localObject = f.jJT();
    Stack localStack = (Stack)((f)localObject).agvr.get();
    if (localStack == null) {
      localObject = null;
    }
    while (localObject != null)
    {
      localObject = ((c)localObject).jJL();
      AppMethodBeat.o(74819);
      return localObject;
      if (localStack.size() == 0) {
        localObject = null;
      } else {
        localObject = (c)((Stack)((f)localObject).agvr.get()).peek();
      }
    }
    localObject = agvs;
    AppMethodBeat.o(74819);
    return localObject;
  }
  
  public static final c<Void> jJU()
  {
    AppMethodBeat.i(74809);
    c localc = new e().L(new Object[0]);
    AppMethodBeat.o(74809);
    return localc;
  }
  
  public static final b jJV()
  {
    AppMethodBeat.i(74820);
    b localb = jJL();
    if (localb != null) {
      localb.jJK();
    }
    for (;;)
    {
      AppMethodBeat.o(74820);
      return localb;
      com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vending.g.g
 * JD-Core Version:    0.7.0.1
 */