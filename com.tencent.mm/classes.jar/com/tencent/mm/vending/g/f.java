package com.tencent.mm.vending.g;

import java.util.Stack;

public final class f
{
  private static final a wtV = new a();
  
  public static final <Var1, Var2, Var3, Var4> c<com.tencent.mm.vending.j.e<Var1, Var2, Var3, Var4>> a(Var1 paramVar1, Var2 paramVar2, Var3 paramVar3, Var4 paramVar4)
  {
    return new e().y(new Object[] { paramVar1, paramVar2, paramVar3, paramVar4 });
  }
  
  public static final <Var1, Var2, Var3, Var4, Var5> c<com.tencent.mm.vending.j.f<Var1, Var2, Var3, Var4, Var5>> a(Var1 paramVar1, Var2 paramVar2, Var3 paramVar3, Var4 paramVar4, Var5 paramVar5)
  {
    return new e().y(new Object[] { paramVar1, paramVar2, paramVar3, paramVar4, paramVar5 });
  }
  
  public static final void a(b paramVarArgs)
  {
    if (paramVarArgs == null)
    {
      com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
      return;
    }
    paramVarArgs.cg(null);
  }
  
  public static final void a(b paramb, Object... paramVarArgs)
  {
    if (paramb == null)
    {
      com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
      return;
    }
    if (paramVarArgs.length > 0)
    {
      paramb.x(paramVarArgs);
      return;
    }
    paramb.resume();
  }
  
  public static final <_Var> void a(d<_Var> paramd)
  {
    b localb = cLc();
    paramd.a(new d.b()
    {
      public final void ag(_Var paramAnonymous_Var)
      {
        f.a(this.wtW, new Object[] { paramAnonymous_Var });
      }
    }).a(new d.a()
    {
      public final void aE(Object paramAnonymousObject)
      {
        this.wtW.cg(paramAnonymousObject);
      }
    });
  }
  
  public static final <Var1, Var2, Var3> c<com.tencent.mm.vending.j.d<Var1, Var2, Var3>> c(Var1 paramVar1, Var2 paramVar2, Var3 paramVar3)
  {
    return new e().y(new Object[] { paramVar1, paramVar2, paramVar3 });
  }
  
  public static final b cKX()
  {
    Object localObject = g.cLd();
    Stack localStack = (Stack)((g)localObject).b.get();
    if (localStack == null) {
      localObject = null;
    }
    while (localObject != null)
    {
      return ((c)localObject).cKX();
      if (localStack.size() == 0) {
        localObject = null;
      } else {
        localObject = (c)((Stack)((g)localObject).b.get()).peek();
      }
    }
    return wtV;
  }
  
  public static final c<Void> cLb()
  {
    return new e().y(new Object[0]);
  }
  
  public static final b cLc()
  {
    b localb = cKX();
    if (localb != null)
    {
      localb.cKW();
      return localb;
    }
    com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
    return localb;
  }
  
  public static final <Var1> c<Var1> ci(Var1 paramVar1)
  {
    return new e().y(new Object[] { paramVar1 });
  }
  
  public static <$1> com.tencent.mm.vending.j.b<$1> cj($1 param$1)
  {
    new com.tencent.mm.vending.j.b();
    return com.tencent.mm.vending.j.b.ck(param$1);
  }
  
  public static final <Var1, Var2> c<com.tencent.mm.vending.j.c<Var1, Var2>> p(Var1 paramVar1, Var2 paramVar2)
  {
    return new e().y(new Object[] { paramVar1, paramVar2 });
  }
  
  public static <$1, $2> com.tencent.mm.vending.j.c<$1, $2> q($1 param$1, $2 param$2)
  {
    new com.tencent.mm.vending.j.c();
    return com.tencent.mm.vending.j.c.r(param$1, param$2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.g.f
 * JD-Core Version:    0.7.0.1
 */