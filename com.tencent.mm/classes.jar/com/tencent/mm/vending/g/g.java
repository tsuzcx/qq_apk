package com.tencent.mm.vending.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.j.h;
import java.util.Stack;

public final class g
{
  private static final a Jrf;
  
  static
  {
    AppMethodBeat.i(74824);
    Jrf = new a();
    AppMethodBeat.o(74824);
  }
  
  public static final <Var1, Var2> c<com.tencent.mm.vending.j.c<Var1, Var2>> J(Var1 paramVar1, Var2 paramVar2)
  {
    AppMethodBeat.i(74811);
    paramVar1 = new e().G(new Object[] { paramVar1, paramVar2 });
    AppMethodBeat.o(74811);
    return paramVar1;
  }
  
  public static <$1, $2> com.tencent.mm.vending.j.c<$1, $2> K($1 param$1, $2 param$2)
  {
    AppMethodBeat.i(74818);
    param$1 = com.tencent.mm.vending.j.a.L(param$1, param$2);
    AppMethodBeat.o(74818);
    return param$1;
  }
  
  public static final <Var1, Var2, Var3, Var4, Var5, Var6> c<com.tencent.mm.vending.j.g<Var1, Var2, Var3, Var4, Var5, Var6>> a(Var1 paramVar1, Var2 paramVar2, Var3 paramVar3, Var4 paramVar4, Var5 paramVar5, Var6 paramVar6)
  {
    AppMethodBeat.i(74815);
    paramVar1 = new e().G(new Object[] { paramVar1, paramVar2, paramVar3, paramVar4, paramVar5, paramVar6 });
    AppMethodBeat.o(74815);
    return paramVar1;
  }
  
  public static final <Var1, Var2, Var3, Var4, Var5, Var6, Var7> c<h<Var1, Var2, Var3, Var4, Var5, Var6, Var7>> a(Var1 paramVar1, Var2 paramVar2, Var3 paramVar3, Var4 paramVar4, Var5 paramVar5, Var6 paramVar6, Var7 paramVar7)
  {
    AppMethodBeat.i(74816);
    paramVar1 = new e().G(new Object[] { paramVar1, paramVar2, paramVar3, paramVar4, paramVar5, paramVar6, paramVar7 });
    AppMethodBeat.o(74816);
    return paramVar1;
  }
  
  public static final void a(b paramVarArgs)
  {
    AppMethodBeat.i(74822);
    if (paramVarArgs == null)
    {
      com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
      AppMethodBeat.o(74822);
      return;
    }
    paramVarArgs.eb(null);
    AppMethodBeat.o(74822);
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
      paramb.F(paramVarArgs);
      AppMethodBeat.o(74821);
      return;
    }
    paramb.resume();
    AppMethodBeat.o(74821);
  }
  
  public static final <_Var> void a(d<_Var> paramd)
  {
    AppMethodBeat.i(74823);
    b localb = fxt();
    paramd.a(new d.b()
    {
      public final void bo(_Var paramAnonymous_Var)
      {
        AppMethodBeat.i(74808);
        g.a(this.cda, new Object[] { paramAnonymous_Var });
        AppMethodBeat.o(74808);
      }
    }).a(new d.a()
    {
      public final void cc(Object paramAnonymousObject)
      {
        AppMethodBeat.i(74825);
        this.cda.eb(paramAnonymousObject);
        AppMethodBeat.o(74825);
      }
    });
    AppMethodBeat.o(74823);
  }
  
  public static final <Var1, Var2, Var3, Var4> c<com.tencent.mm.vending.j.e<Var1, Var2, Var3, Var4>> b(Var1 paramVar1, Var2 paramVar2, Var3 paramVar3, Var4 paramVar4)
  {
    AppMethodBeat.i(74813);
    paramVar1 = new e().G(new Object[] { paramVar1, paramVar2, paramVar3, paramVar4 });
    AppMethodBeat.o(74813);
    return paramVar1;
  }
  
  public static final <Var1, Var2, Var3, Var4, Var5> c<com.tencent.mm.vending.j.f<Var1, Var2, Var3, Var4, Var5>> b(Var1 paramVar1, Var2 paramVar2, Var3 paramVar3, Var4 paramVar4, Var5 paramVar5)
  {
    AppMethodBeat.i(74814);
    paramVar1 = new e().G(new Object[] { paramVar1, paramVar2, paramVar3, paramVar4, paramVar5 });
    AppMethodBeat.o(74814);
    return paramVar1;
  }
  
  public static final <Var1> c<Var1> ef(Var1 paramVar1)
  {
    AppMethodBeat.i(74810);
    paramVar1 = new e().G(new Object[] { paramVar1 });
    AppMethodBeat.o(74810);
    return paramVar1;
  }
  
  public static <$1> com.tencent.mm.vending.j.b<$1> eg($1 param$1)
  {
    AppMethodBeat.i(74817);
    param$1 = com.tencent.mm.vending.j.a.eh(param$1);
    AppMethodBeat.o(74817);
    return param$1;
  }
  
  public static final b fxn()
  {
    AppMethodBeat.i(74819);
    Object localObject = f.fxr();
    Stack localStack = (Stack)((f)localObject).Jre.get();
    if (localStack == null) {
      localObject = null;
    }
    while (localObject != null)
    {
      localObject = ((c)localObject).fxn();
      AppMethodBeat.o(74819);
      return localObject;
      if (localStack.size() == 0) {
        localObject = null;
      } else {
        localObject = (c)((Stack)((f)localObject).Jre.get()).peek();
      }
    }
    localObject = Jrf;
    AppMethodBeat.o(74819);
    return localObject;
  }
  
  public static final c<Void> fxs()
  {
    AppMethodBeat.i(74809);
    c localc = new e().G(new Object[0]);
    AppMethodBeat.o(74809);
    return localc;
  }
  
  public static final b fxt()
  {
    AppMethodBeat.i(74820);
    b localb = fxn();
    if (localb != null) {
      localb.fxm();
    }
    for (;;)
    {
      AppMethodBeat.o(74820);
      return localb;
      com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
    }
  }
  
  public static final <Var1, Var2, Var3> c<com.tencent.mm.vending.j.d<Var1, Var2, Var3>> h(Var1 paramVar1, Var2 paramVar2, Var3 paramVar3)
  {
    AppMethodBeat.i(74812);
    paramVar1 = new e().G(new Object[] { paramVar1, paramVar2, paramVar3 });
    AppMethodBeat.o(74812);
    return paramVar1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.g.g
 * JD-Core Version:    0.7.0.1
 */