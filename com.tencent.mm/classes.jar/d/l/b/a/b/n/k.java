package d.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.a.g;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.t;
import d.l.b.a.b.j.d.a;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.aj;

public abstract class k
  implements b
{
  private final d.g.a.b<g, ab> NFm;
  private final String description;
  private final String name;
  
  private k(String paramString, d.g.a.b<? super g, ? extends ab> paramb)
  {
    this.name = paramString;
    this.NFm = paramb;
    this.description = ("must return " + this.name);
  }
  
  public final String getDescription()
  {
    return this.description;
  }
  
  public final boolean h(t paramt)
  {
    p.h(paramt, "functionDescriptor");
    return p.i(paramt.giq(), (ab)this.NFm.invoke(a.G((l)paramt)));
  }
  
  public final String i(t paramt)
  {
    p.h(paramt, "functionDescriptor");
    return b.a.a(this, paramt);
  }
  
  public static final class a
    extends k
  {
    public static final a NFn;
    
    static
    {
      AppMethodBeat.i(61320);
      NFn = new a();
      AppMethodBeat.o(61320);
    }
    
    private a()
    {
      super((d.g.a.b)1.NFo, (byte)0);
      AppMethodBeat.i(61319);
      AppMethodBeat.o(61319);
    }
  }
  
  public static final class b
    extends k
  {
    public static final b NFp;
    
    static
    {
      AppMethodBeat.i(61324);
      NFp = new b();
      AppMethodBeat.o(61324);
    }
    
    private b()
    {
      super((d.g.a.b)1.NFq, (byte)0);
      AppMethodBeat.i(61323);
      AppMethodBeat.o(61323);
    }
  }
  
  public static final class c
    extends k
  {
    public static final c NFr;
    
    static
    {
      AppMethodBeat.i(61328);
      NFr = new c();
      AppMethodBeat.o(61328);
    }
    
    private c()
    {
      super((d.g.a.b)1.NFs, (byte)0);
      AppMethodBeat.i(61327);
      AppMethodBeat.o(61327);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.n.k
 * JD-Core Version:    0.7.0.1
 */