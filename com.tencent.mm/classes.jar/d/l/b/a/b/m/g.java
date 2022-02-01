package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.ac;
import d.g.b.p;
import d.l.b.a.b.m.c.h;
import d.l.b.a.b.m.c.j;
import d.l.b.a.b.m.c.l;
import d.l.b.a.b.m.c.m;
import d.l.b.a.b.m.c.n;
import d.l.b.a.b.m.c.q;
import d.l.b.a.b.m.c.q.a;
import d.l.b.a.b.o.i;
import d.l.b.a.b.o.i.b;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Set;

public abstract class g
  implements q
{
  int NYu;
  private boolean NYv;
  ArrayDeque<j> NYw;
  Set<j> NYx;
  
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
  
  public List<j> a(j paramj, n paramn)
  {
    p.h(paramj, "$this$fastCorrespondingSupertypes");
    p.h(paramn, "constructor");
    return q.a.b(paramj, paramn);
  }
  
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
    Object localObject = this.NYw;
    if (localObject == null) {
      p.gkB();
    }
    ((ArrayDeque)localObject).clear();
    localObject = this.NYx;
    if (localObject == null) {
      p.gkB();
    }
    ((Set)localObject).clear();
    this.NYv = false;
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
  
  public abstract boolean gys();
  
  public abstract boolean gyt();
  
  public boolean h(h paramh)
  {
    p.h(paramh, "$this$isDefinitelyNotNullType");
    return q.a.d(this, paramh);
  }
  
  public boolean i(h paramh)
  {
    p.h(paramh, "$this$hasFlexibleNullability");
    return q.a.e(this, paramh);
  }
  
  public final void initialize()
  {
    if (!this.NYv) {}
    for (int i = 1; (ac.Nhs) && (i == 0); i = 0) {
      throw ((Throwable)new AssertionError("Assertion failed"));
    }
    this.NYv = true;
    if (this.NYw == null) {
      this.NYw = new ArrayDeque(4);
    }
    if (this.NYx == null)
    {
      i.b localb = i.Odl;
      this.NYx = ((Set)i.b.gyW());
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
      NYy = locala1;
      a locala2 = new a("CHECK_SUBTYPE_AND_LOWER", 1);
      NYz = locala2;
      a locala3 = new a("SKIP_LOWER", 2);
      NYA = locala3;
      NYB = new a[] { locala1, locala2, locala3 };
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
      public static final b NYC;
      
      static
      {
        AppMethodBeat.i(60597);
        NYC = new b();
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
      public static final c NYD;
      
      static
      {
        AppMethodBeat.i(60599);
        NYD = new c();
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
      public static final d NYE;
      
      static
      {
        AppMethodBeat.i(60601);
        NYE = new d();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.g
 * JD-Core Version:    0.7.0.1
 */