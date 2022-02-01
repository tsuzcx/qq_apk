package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a.g;

public abstract class bc
{
  public static final bc.a ajqw = new bc.a((byte)0);
  public static final bc ajqx = (bc)new b();
  
  public abstract az G(ad paramad);
  
  public ad a(ad paramad, bl parambl)
  {
    s.u(paramad, "topLevelType");
    s.u(parambl, "position");
    return paramad;
  }
  
  public g h(g paramg)
  {
    s.u(paramg, "annotations");
    return paramg;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean kAD()
  {
    return false;
  }
  
  public final be kAO()
  {
    be localbe = be.d(this);
    s.s(localbe, "create(this)");
    return localbe;
  }
  
  public final bc kAP()
  {
    return (bc)new c(this);
  }
  
  public boolean kzo()
  {
    return false;
  }
  
  public static final class b
    extends bc
  {
    public final boolean isEmpty()
    {
      return true;
    }
    
    public final String toString()
    {
      return "Empty TypeSubstitution";
    }
  }
  
  public static final class c
    extends bc
  {
    c(bc parambc) {}
    
    public final az G(ad paramad)
    {
      AppMethodBeat.i(191602);
      s.u(paramad, "key");
      paramad = this.ajqy.G(paramad);
      AppMethodBeat.o(191602);
      return paramad;
    }
    
    public final ad a(ad paramad, bl parambl)
    {
      AppMethodBeat.i(191610);
      s.u(paramad, "topLevelType");
      s.u(parambl, "position");
      paramad = this.ajqy.a(paramad, parambl);
      AppMethodBeat.o(191610);
      return paramad;
    }
    
    public final g h(g paramg)
    {
      AppMethodBeat.i(191606);
      s.u(paramg, "annotations");
      paramg = this.ajqy.h(paramg);
      AppMethodBeat.o(191606);
      return paramg;
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(191613);
      boolean bool = this.ajqy.isEmpty();
      AppMethodBeat.o(191613);
      return bool;
    }
    
    public final boolean kAD()
    {
      return false;
    }
    
    public final boolean kzo()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.bc
 * JD-Core Version:    0.7.0.1
 */