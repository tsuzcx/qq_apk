package kotlin.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.j.d.a;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;

public abstract class k
  implements b
{
  private final kotlin.g.a.b<g, ab> abtL;
  private final String description;
  private final String name;
  
  private k(String paramString, kotlin.g.a.b<? super g, ? extends ab> paramb)
  {
    this.name = paramString;
    this.abtL = paramb;
    this.description = ("must return " + this.name);
  }
  
  public final String getDescription()
  {
    return this.description;
  }
  
  public final boolean h(t paramt)
  {
    p.k(paramt, "functionDescriptor");
    return p.h(paramt.iEH(), (ab)this.abtL.invoke(a.G((l)paramt)));
  }
  
  public final String i(t paramt)
  {
    p.k(paramt, "functionDescriptor");
    return b.a.a(this, paramt);
  }
  
  public static final class a
    extends k
  {
    public static final a abtM;
    
    static
    {
      AppMethodBeat.i(61320);
      abtM = new a();
      AppMethodBeat.o(61320);
    }
    
    private a()
    {
      super((kotlin.g.a.b)1.abtN, (byte)0);
      AppMethodBeat.i(61319);
      AppMethodBeat.o(61319);
    }
  }
  
  public static final class b
    extends k
  {
    public static final b abtO;
    
    static
    {
      AppMethodBeat.i(61324);
      abtO = new b();
      AppMethodBeat.o(61324);
    }
    
    private b()
    {
      super((kotlin.g.a.b)1.abtP, (byte)0);
      AppMethodBeat.i(61323);
      AppMethodBeat.o(61323);
    }
  }
  
  public static final class c
    extends k
  {
    public static final c abtQ;
    
    static
    {
      AppMethodBeat.i(61328);
      abtQ = new c();
      AppMethodBeat.o(61328);
    }
    
    private c()
    {
      super((kotlin.g.a.b)1.abtR, (byte)0);
      AppMethodBeat.i(61327);
      AppMethodBeat.o(61327);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.n.k
 * JD-Core Version:    0.7.0.1
 */