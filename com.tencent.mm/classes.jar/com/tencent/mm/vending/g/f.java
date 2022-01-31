package com.tencent.mm.vending.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.j.h;
import java.util.Stack;

public final class f
{
  private static final a AOT;
  
  static
  {
    AppMethodBeat.i(126032);
    AOT = new a();
    AppMethodBeat.o(126032);
  }
  
  public static final <Var1, Var2> c<com.tencent.mm.vending.j.c<Var1, Var2>> A(Var1 paramVar1, Var2 paramVar2)
  {
    AppMethodBeat.i(126020);
    paramVar1 = new e().D(new Object[] { paramVar1, paramVar2 });
    AppMethodBeat.o(126020);
    return paramVar1;
  }
  
  public static <$1, $2> com.tencent.mm.vending.j.c<$1, $2> B($1 param$1, $2 param$2)
  {
    AppMethodBeat.i(126026);
    param$1 = com.tencent.mm.vending.j.a.C(param$1, param$2);
    AppMethodBeat.o(126026);
    return param$1;
  }
  
  public static final <Var1, Var2, Var3, Var4, Var5> c<com.tencent.mm.vending.j.f<Var1, Var2, Var3, Var4, Var5>> a(Var1 paramVar1, Var2 paramVar2, Var3 paramVar3, Var4 paramVar4, Var5 paramVar5)
  {
    AppMethodBeat.i(126023);
    paramVar1 = new e().D(new Object[] { paramVar1, paramVar2, paramVar3, paramVar4, paramVar5 });
    AppMethodBeat.o(126023);
    return paramVar1;
  }
  
  public static final <Var1, Var2, Var3, Var4, Var5, Var6, Var7> c<h<Var1, Var2, Var3, Var4, Var5, Var6, Var7>> a(Var1 paramVar1, Var2 paramVar2, Var3 paramVar3, Var4 paramVar4, Var5 paramVar5, Var6 paramVar6, Var7 paramVar7)
  {
    AppMethodBeat.i(126024);
    paramVar1 = new e().D(new Object[] { paramVar1, paramVar2, paramVar3, paramVar4, paramVar5, paramVar6, paramVar7 });
    AppMethodBeat.o(126024);
    return paramVar1;
  }
  
  public static final void a(b paramVarArgs)
  {
    AppMethodBeat.i(126030);
    if (paramVarArgs == null)
    {
      com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
      AppMethodBeat.o(126030);
      return;
    }
    paramVarArgs.cK(null);
    AppMethodBeat.o(126030);
  }
  
  public static final void a(b paramb, Object... paramVarArgs)
  {
    AppMethodBeat.i(126029);
    if (paramb == null)
    {
      com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
      AppMethodBeat.o(126029);
      return;
    }
    if (paramVarArgs.length > 0)
    {
      paramb.C(paramVarArgs);
      AppMethodBeat.o(126029);
      return;
    }
    paramb.resume();
    AppMethodBeat.o(126029);
  }
  
  public static final <_Var> void a(d<_Var> paramd)
  {
    AppMethodBeat.i(126031);
    b localb = dQs();
    paramd.a(new d.b()
    {
      public final void ap(_Var paramAnonymous_Var)
      {
        AppMethodBeat.i(126017);
        f.a(this.AOU, new Object[] { paramAnonymous_Var });
        AppMethodBeat.o(126017);
      }
    }).a(new d.a()
    {
      public final void aX(Object paramAnonymousObject)
      {
        AppMethodBeat.i(126033);
        this.AOU.cK(paramAnonymousObject);
        AppMethodBeat.o(126033);
      }
    });
    AppMethodBeat.o(126031);
  }
  
  public static final <Var1, Var2, Var3, Var4> c<com.tencent.mm.vending.j.e<Var1, Var2, Var3, Var4>> b(Var1 paramVar1, Var2 paramVar2, Var3 paramVar3, Var4 paramVar4)
  {
    AppMethodBeat.i(126022);
    paramVar1 = new e().D(new Object[] { paramVar1, paramVar2, paramVar3, paramVar4 });
    AppMethodBeat.o(126022);
    return paramVar1;
  }
  
  public static final <Var1> c<Var1> cN(Var1 paramVar1)
  {
    AppMethodBeat.i(126019);
    paramVar1 = new e().D(new Object[] { paramVar1 });
    AppMethodBeat.o(126019);
    return paramVar1;
  }
  
  public static <$1> com.tencent.mm.vending.j.b<$1> cO($1 param$1)
  {
    AppMethodBeat.i(126025);
    param$1 = com.tencent.mm.vending.j.a.cP(param$1);
    AppMethodBeat.o(126025);
    return param$1;
  }
  
  public static final b dQn()
  {
    AppMethodBeat.i(126027);
    Object localObject = g.dQt();
    Stack localStack = (Stack)((g)localObject).b.get();
    if (localStack == null) {
      localObject = null;
    }
    while (localObject != null)
    {
      localObject = ((c)localObject).dQn();
      AppMethodBeat.o(126027);
      return localObject;
      if (localStack.size() == 0) {
        localObject = null;
      } else {
        localObject = (c)((Stack)((g)localObject).b.get()).peek();
      }
    }
    localObject = AOT;
    AppMethodBeat.o(126027);
    return localObject;
  }
  
  public static final c<Void> dQr()
  {
    AppMethodBeat.i(126018);
    c localc = new e().D(new Object[0]);
    AppMethodBeat.o(126018);
    return localc;
  }
  
  public static final b dQs()
  {
    AppMethodBeat.i(126028);
    b localb = dQn();
    if (localb != null) {
      localb.dQm();
    }
    for (;;)
    {
      AppMethodBeat.o(126028);
      return localb;
      com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
    }
  }
  
  public static final <Var1, Var2, Var3> c<com.tencent.mm.vending.j.d<Var1, Var2, Var3>> h(Var1 paramVar1, Var2 paramVar2, Var3 paramVar3)
  {
    AppMethodBeat.i(126021);
    paramVar1 = new e().D(new Object[] { paramVar1, paramVar2, paramVar3 });
    AppMethodBeat.o(126021);
    return paramVar1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.g.f
 * JD-Core Version:    0.7.0.1
 */