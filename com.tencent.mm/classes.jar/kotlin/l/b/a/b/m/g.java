package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Set;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.m.c.h;
import kotlin.l.b.a.b.m.c.j;
import kotlin.l.b.a.b.m.c.l;
import kotlin.l.b.a.b.m.c.m;
import kotlin.l.b.a.b.m.c.n;
import kotlin.l.b.a.b.m.c.q;
import kotlin.l.b.a.b.m.c.q.a;
import kotlin.l.b.a.b.o.i;
import kotlin.l.b.a.b.o.i.b;

public abstract class g
  implements q
{
  int TNn;
  private boolean TNo;
  ArrayDeque<j> TNp;
  Set<j> TNq;
  
  public static Boolean a(h paramh1, h paramh2)
  {
    p.h(paramh1, "subType");
    p.h(paramh2, "superType");
    return null;
  }
  
  public int a(l paraml)
  {
    p.h(paraml, "$this$size");
    return q.a.a(this, paraml);
  }
  
  public List<j> a(j paramj, n paramn)
  {
    p.h(paramj, "$this$fastCorrespondingSupertypes");
    p.h(paramn, "constructor");
    return q.a.b(paramj, paramn);
  }
  
  public h a(h paramh)
  {
    p.h(paramh, "type");
    return paramh;
  }
  
  public m a(j paramj, int paramInt)
  {
    p.h(paramj, "$this$getArgumentOrNull");
    return q.a.a(this, paramj, paramInt);
  }
  
  public m a(l paraml, int paramInt)
  {
    p.h(paraml, "$this$get");
    return q.a.a(this, paraml, paramInt);
  }
  
  public abstract b a(j paramj);
  
  public boolean a(j paramj1, j paramj2)
  {
    p.h(paramj1, "a");
    p.h(paramj2, "b");
    p.h(paramj1, "a");
    p.h(paramj2, "b");
    p.h(paramj1, "a");
    p.h(paramj2, "b");
    return false;
  }
  
  public abstract boolean a(n paramn1, n paramn2);
  
  public h b(h paramh)
  {
    p.h(paramh, "type");
    return paramh;
  }
  
  public boolean b(j paramj)
  {
    p.h(paramj, "$this$isClassType");
    return q.a.a(this, paramj);
  }
  
  public abstract boolean c(h paramh);
  
  public boolean c(j paramj)
  {
    p.h(paramj, "$this$isIntegerLiteralType");
    return q.a.b(this, paramj);
  }
  
  public final void clear()
  {
    Object localObject = this.TNp;
    if (localObject == null) {
      p.hyc();
    }
    ((ArrayDeque)localObject).clear();
    localObject = this.TNq;
    if (localObject == null) {
      p.hyc();
    }
    ((Set)localObject).clear();
    this.TNo = false;
  }
  
  public n d(h paramh)
  {
    p.h(paramh, "$this$typeConstructor");
    return q.a.f(this, paramh);
  }
  
  public j e(h paramh)
  {
    p.h(paramh, "$this$lowerBoundIfFlexible");
    return q.a.a(this, paramh);
  }
  
  public j f(h paramh)
  {
    p.h(paramh, "$this$upperBoundIfFlexible");
    return q.a.b(this, paramh);
  }
  
  public boolean g(h paramh)
  {
    p.h(paramh, "$this$isDynamic");
    return q.a.c(this, paramh);
  }
  
  public boolean h(h paramh)
  {
    p.h(paramh, "$this$isDefinitelyNotNullType");
    return q.a.d(this, paramh);
  }
  
  public abstract boolean hLv();
  
  public abstract boolean hLw();
  
  public boolean i(h paramh)
  {
    p.h(paramh, "$this$hasFlexibleNullability");
    return q.a.e(this, paramh);
  }
  
  public final void initialize()
  {
    if (!this.TNo) {}
    for (int i = 1; (aa.SXc) && (i == 0); i = 0) {
      throw ((Throwable)new AssertionError("Assertion failed"));
    }
    this.TNo = true;
    if (this.TNp == null) {
      this.TNp = new ArrayDeque(4);
    }
    if (this.TNq == null)
    {
      i.b localb = i.TSf;
      this.TNq = ((Set)i.b.hLZ());
    }
  }
  
  public boolean j(h paramh)
  {
    p.h(paramh, "$this$isNothing");
    return q.a.g(this, paramh);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(60590);
      a locala1 = new a("CHECK_ONLY_LOWER", 0);
      TNr = locala1;
      a locala2 = new a("CHECK_SUBTYPE_AND_LOWER", 1);
      TNs = locala2;
      a locala3 = new a("SKIP_LOWER", 2);
      TNt = locala3;
      TNu = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(60590);
    }
    
    private a() {}
  }
  
  public static abstract class b
  {
    public abstract j b(g paramg, h paramh);
    
    public static abstract class a
      extends g.b
    {
      public a()
      {
        super();
      }
    }
    
    public static final class b
      extends g.b
    {
      public static final b TNv;
      
      static
      {
        AppMethodBeat.i(60597);
        TNv = new b();
        AppMethodBeat.o(60597);
      }
      
      private b()
      {
        super();
      }
      
      public final j b(g paramg, h paramh)
      {
        AppMethodBeat.i(60596);
        p.h(paramg, "context");
        p.h(paramh, "type");
        paramg = paramg.e(paramh);
        AppMethodBeat.o(60596);
        return paramg;
      }
    }
    
    public static final class c
      extends g.b
    {
      public static final c TNw;
      
      static
      {
        AppMethodBeat.i(60599);
        TNw = new c();
        AppMethodBeat.o(60599);
      }
      
      private c()
      {
        super();
      }
    }
    
    public static final class d
      extends g.b
    {
      public static final d TNx;
      
      static
      {
        AppMethodBeat.i(60601);
        TNx = new d();
        AppMethodBeat.o(60601);
      }
      
      private d()
      {
        super();
      }
      
      public final j b(g paramg, h paramh)
      {
        AppMethodBeat.i(60600);
        p.h(paramg, "context");
        p.h(paramh, "type");
        paramg = paramg.f(paramh);
        AppMethodBeat.o(60600);
        return paramg;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.g
 * JD-Core Version:    0.7.0.1
 */