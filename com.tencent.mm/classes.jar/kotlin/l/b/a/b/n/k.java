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
  private final kotlin.g.a.b<g, ab> TRm;
  private final String description;
  private final String name;
  
  private k(String paramString, kotlin.g.a.b<? super g, ? extends ab> paramb)
  {
    this.name = paramString;
    this.TRm = paramb;
    this.description = ("must return " + this.name);
  }
  
  public final String getDescription()
  {
    return this.description;
  }
  
  public final boolean h(t paramt)
  {
    p.h(paramt, "functionDescriptor");
    return p.j(paramt.hAu(), (ab)this.TRm.invoke(a.G((l)paramt)));
  }
  
  public final String i(t paramt)
  {
    p.h(paramt, "functionDescriptor");
    return b.a.a(this, paramt);
  }
  
  public static final class a
    extends k
  {
    public static final a TRn;
    
    static
    {
      AppMethodBeat.i(61320);
      TRn = new a();
      AppMethodBeat.o(61320);
    }
    
    private a()
    {
      super((kotlin.g.a.b)1.TRo, (byte)0);
      AppMethodBeat.i(61319);
      AppMethodBeat.o(61319);
    }
  }
  
  public static final class b
    extends k
  {
    public static final b TRp;
    
    static
    {
      AppMethodBeat.i(61324);
      TRp = new b();
      AppMethodBeat.o(61324);
    }
    
    private b()
    {
      super((kotlin.g.a.b)1.TRq, (byte)0);
      AppMethodBeat.i(61323);
      AppMethodBeat.o(61323);
    }
  }
  
  public static final class c
    extends k
  {
    public static final c TRr;
    
    static
    {
      AppMethodBeat.i(61328);
      TRr = new c();
      AppMethodBeat.o(61328);
    }
    
    private c()
    {
      super((kotlin.g.a.b)1.TRs, (byte)0);
      AppMethodBeat.i(61327);
      AppMethodBeat.o(61327);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.n.k
 * JD-Core Version:    0.7.0.1
 */