package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Set;
import kotlin.ak;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.l.b.a.b.m.c.i;
import kotlin.l.b.a.b.m.c.k;
import kotlin.l.b.a.b.m.c.r;
import kotlin.l.b.a.b.o.f;
import kotlin.l.b.a.b.o.f.b;

public abstract class g
{
  int ajoU;
  private boolean ajoV;
  ArrayDeque<k> ajoW;
  Set<k> ajoX;
  
  public static Boolean a(i parami1, i parami2)
  {
    s.u(parami1, "subType");
    s.u(parami2, "superType");
    return null;
  }
  
  public final void clear()
  {
    Object localObject = this.ajoW;
    s.checkNotNull(localObject);
    ((ArrayDeque)localObject).clear();
    localObject = this.ajoX;
    s.checkNotNull(localObject);
    ((Set)localObject).clear();
    this.ajoV = false;
  }
  
  public final void initialize()
  {
    if (!this.ajoV) {}
    for (int i = 1; (ak.aiuY) && (i == 0); i = 0) {
      throw ((Throwable)new AssertionError(s.X("Supertypes were locked for ", ai.cz(getClass()))));
    }
    this.ajoV = true;
    if (this.ajoW == null) {
      this.ajoW = new ArrayDeque(4);
    }
    if (this.ajoX == null)
    {
      f.b localb = f.ajtJ;
      this.ajoX = ((Set)f.b.kBe());
    }
  }
  
  public abstract boolean kAA();
  
  public abstract boolean kAB();
  
  public abstract r kAz();
  
  public abstract b m(k paramk);
  
  public i t(i parami)
  {
    s.u(parami, "type");
    return parami;
  }
  
  public i u(i parami)
  {
    s.u(parami, "type");
    return parami;
  }
  
  public abstract boolean v(i parami);
  
  public final boolean w(i parami)
  {
    s.u(parami, "type");
    return v(parami);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(60590);
      ajoY = new a("CHECK_ONLY_LOWER", 0);
      ajoZ = new a("CHECK_SUBTYPE_AND_LOWER", 1);
      ajpa = new a("SKIP_LOWER", 2);
      ajpb = new a[] { ajoY, ajoZ, ajpa };
      AppMethodBeat.o(60590);
    }
    
    private a() {}
  }
  
  public static abstract class b
  {
    public abstract k a(g paramg, i parami);
    
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
      public static final b ajpc;
      
      static
      {
        AppMethodBeat.i(60597);
        ajpc = new b();
        AppMethodBeat.o(60597);
      }
      
      private b()
      {
        super();
      }
      
      public final k a(g paramg, i parami)
      {
        AppMethodBeat.i(60596);
        s.u(paramg, "context");
        s.u(parami, "type");
        paramg = paramg.kAz().n(parami);
        AppMethodBeat.o(60596);
        return paramg;
      }
    }
    
    public static final class c
      extends g.b
    {
      public static final c ajpd;
      
      static
      {
        AppMethodBeat.i(60599);
        ajpd = new c();
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
      public static final d ajpe;
      
      static
      {
        AppMethodBeat.i(60601);
        ajpe = new d();
        AppMethodBeat.o(60601);
      }
      
      private d()
      {
        super();
      }
      
      public final k a(g paramg, i parami)
      {
        AppMethodBeat.i(60600);
        s.u(paramg, "context");
        s.u(parami, "type");
        paramg = paramg.kAz().r(parami);
        AppMethodBeat.o(60600);
        return paramg;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.g
 * JD-Core Version:    0.7.0.1
 */