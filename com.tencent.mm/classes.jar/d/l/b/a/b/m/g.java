package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.aa;
import d.l.b.a.b.m.c.l;
import d.l.b.a.b.m.c.m;
import d.l.b.a.b.m.c.p;
import d.l.b.a.b.m.c.p.a;
import d.l.b.a.b.o.i.b;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Set;

public abstract class g
  implements p
{
  int LKo;
  private boolean LKp;
  ArrayDeque<d.l.b.a.b.m.c.i> LKq;
  Set<d.l.b.a.b.m.c.i> LKr;
  
  public static Boolean a(d.l.b.a.b.m.c.g paramg1, d.l.b.a.b.m.c.g paramg2)
  {
    d.g.b.k.h(paramg1, "subType");
    d.g.b.k.h(paramg2, "superType");
    return null;
  }
  
  public int a(d.l.b.a.b.m.c.k paramk)
  {
    d.g.b.k.h(paramk, "$this$size");
    return p.a.a(this, paramk);
  }
  
  public d.l.b.a.b.m.c.g a(d.l.b.a.b.m.c.g paramg)
  {
    d.g.b.k.h(paramg, "type");
    return paramg;
  }
  
  public l a(d.l.b.a.b.m.c.i parami, int paramInt)
  {
    d.g.b.k.h(parami, "$this$getArgumentOrNull");
    return p.a.a(this, parami, paramInt);
  }
  
  public l a(d.l.b.a.b.m.c.k paramk, int paramInt)
  {
    d.g.b.k.h(paramk, "$this$get");
    return p.a.a(this, paramk, paramInt);
  }
  
  public abstract c a(d.l.b.a.b.m.c.i parami);
  
  public List<d.l.b.a.b.m.c.i> a(d.l.b.a.b.m.c.i parami, m paramm)
  {
    d.g.b.k.h(parami, "$this$fastCorrespondingSupertypes");
    d.g.b.k.h(paramm, "constructor");
    return p.a.b(parami, paramm);
  }
  
  public abstract boolean a(m paramm1, m paramm2);
  
  public d.l.b.a.b.m.c.g b(d.l.b.a.b.m.c.g paramg)
  {
    d.g.b.k.h(paramg, "type");
    return paramg;
  }
  
  public boolean b(d.l.b.a.b.m.c.i parami)
  {
    d.g.b.k.h(parami, "$this$isClassType");
    return p.a.a(this, parami);
  }
  
  public boolean b(d.l.b.a.b.m.c.i parami1, d.l.b.a.b.m.c.i parami2)
  {
    d.g.b.k.h(parami1, "a");
    d.g.b.k.h(parami2, "b");
    d.g.b.k.h(parami1, "a");
    d.g.b.k.h(parami2, "b");
    d.g.b.k.h(parami1, "a");
    d.g.b.k.h(parami2, "b");
    return false;
  }
  
  public abstract boolean c(d.l.b.a.b.m.c.g paramg);
  
  public boolean c(d.l.b.a.b.m.c.i parami)
  {
    d.g.b.k.h(parami, "$this$isIntegerLiteralType");
    return p.a.b(this, parami);
  }
  
  public final void clear()
  {
    Object localObject = this.LKq;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    ((ArrayDeque)localObject).clear();
    localObject = this.LKr;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    ((Set)localObject).clear();
    this.LKp = false;
  }
  
  public m d(d.l.b.a.b.m.c.g paramg)
  {
    d.g.b.k.h(paramg, "$this$typeConstructor");
    return p.a.f(this, paramg);
  }
  
  public d.l.b.a.b.m.c.i e(d.l.b.a.b.m.c.g paramg)
  {
    d.g.b.k.h(paramg, "$this$lowerBoundIfFlexible");
    return p.a.a(this, paramg);
  }
  
  public d.l.b.a.b.m.c.i f(d.l.b.a.b.m.c.g paramg)
  {
    d.g.b.k.h(paramg, "$this$upperBoundIfFlexible");
    return p.a.b(this, paramg);
  }
  
  public boolean g(d.l.b.a.b.m.c.g paramg)
  {
    d.g.b.k.h(paramg, "$this$isDynamic");
    return p.a.c(this, paramg);
  }
  
  public abstract boolean gcr();
  
  public boolean h(d.l.b.a.b.m.c.g paramg)
  {
    d.g.b.k.h(paramg, "$this$isDefinitelyNotNullType");
    return p.a.d(this, paramg);
  }
  
  public boolean i(d.l.b.a.b.m.c.g paramg)
  {
    d.g.b.k.h(paramg, "$this$hasFlexibleNullability");
    return p.a.e(this, paramg);
  }
  
  public final void initialize()
  {
    if (!this.LKp) {}
    for (int i = 1; (aa.KTq) && (i == 0); i = 0) {
      throw ((Throwable)new AssertionError("Assertion failed"));
    }
    this.LKp = true;
    if (this.LKq == null) {
      this.LKq = new ArrayDeque(4);
    }
    if (this.LKr == null)
    {
      i.b localb = d.l.b.a.b.o.i.LPk;
      this.LKr = ((Set)i.b.gcT());
    }
  }
  
  public boolean j(d.l.b.a.b.m.c.g paramg)
  {
    d.g.b.k.h(paramg, "$this$isNothing");
    return p.a.g(this, paramg);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(60590);
      a locala1 = new a("CHECK_ONLY_LOWER", 0);
      LKs = locala1;
      a locala2 = new a("CHECK_SUBTYPE_AND_LOWER", 1);
      LKt = locala2;
      a locala3 = new a("SKIP_LOWER", 2);
      LKu = locala3;
      LKv = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(60590);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(60593);
      b localb1 = new b("TAKE_FIRST_FOR_SUBTYPING", 0);
      LKw = localb1;
      b localb2 = new b("FORCE_NOT_SUBTYPE", 1);
      LKx = localb2;
      b localb3 = new b("CHECK_ANY_OF_THEM", 2);
      LKy = localb3;
      b localb4 = new b("INTERSECT_ARGUMENTS_AND_CHECK_AGAIN", 3);
      LKz = localb4;
      LKA = new b[] { localb1, localb2, localb3, localb4 };
      AppMethodBeat.o(60593);
    }
    
    private b() {}
  }
  
  public static abstract class c
  {
    public abstract d.l.b.a.b.m.c.i b(g paramg, d.l.b.a.b.m.c.g paramg1);
    
    public static abstract class a
      extends g.c
    {
      public a()
      {
        super();
      }
    }
    
    public static final class b
      extends g.c
    {
      public static final b LKB;
      
      static
      {
        AppMethodBeat.i(60597);
        LKB = new b();
        AppMethodBeat.o(60597);
      }
      
      private b()
      {
        super();
      }
      
      public final d.l.b.a.b.m.c.i b(g paramg, d.l.b.a.b.m.c.g paramg1)
      {
        AppMethodBeat.i(60596);
        d.g.b.k.h(paramg, "context");
        d.g.b.k.h(paramg1, "type");
        paramg = paramg.e(paramg1);
        AppMethodBeat.o(60596);
        return paramg;
      }
    }
    
    public static final class c
      extends g.c
    {
      public static final c LKC;
      
      static
      {
        AppMethodBeat.i(60599);
        LKC = new c();
        AppMethodBeat.o(60599);
      }
      
      private c()
      {
        super();
      }
    }
    
    public static final class d
      extends g.c
    {
      public static final d LKD;
      
      static
      {
        AppMethodBeat.i(60601);
        LKD = new d();
        AppMethodBeat.o(60601);
      }
      
      private d()
      {
        super();
      }
      
      public final d.l.b.a.b.m.c.i b(g paramg, d.l.b.a.b.m.c.g paramg1)
      {
        AppMethodBeat.i(60600);
        d.g.b.k.h(paramg, "context");
        d.g.b.k.h(paramg1, "type");
        paramg = paramg.f(paramg1);
        AppMethodBeat.o(60600);
        return paramg;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.g
 * JD-Core Version:    0.7.0.1
 */