package kotlin.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.j.d.a;
import kotlin.l.b.a.b.m.ad;

public abstract class k
  implements b
{
  private final kotlin.g.a.b<h, ad> ajtg;
  private final String description;
  private final String name;
  
  private k(String paramString, kotlin.g.a.b<? super h, ? extends ad> paramb)
  {
    this.name = paramString;
    this.ajtg = paramb;
    this.description = s.X("must return ", this.name);
  }
  
  public final String getDescription()
  {
    return this.description;
  }
  
  public final boolean h(x paramx)
  {
    s.u(paramx, "functionDescriptor");
    return s.p(paramx.kob(), this.ajtg.invoke(a.G((l)paramx)));
  }
  
  public final String i(x paramx)
  {
    return b.a.a(this, paramx);
  }
  
  public static final class a
    extends k
  {
    public static final a ajth;
    
    static
    {
      AppMethodBeat.i(61320);
      ajth = new a();
      AppMethodBeat.o(61320);
    }
    
    private a()
    {
      super((kotlin.g.a.b)1.ajti, (byte)0);
      AppMethodBeat.i(61319);
      AppMethodBeat.o(61319);
    }
  }
  
  public static final class b
    extends k
  {
    public static final b ajtj;
    
    static
    {
      AppMethodBeat.i(61324);
      ajtj = new b();
      AppMethodBeat.o(61324);
    }
    
    private b()
    {
      super((kotlin.g.a.b)1.ajtk, (byte)0);
      AppMethodBeat.i(61323);
      AppMethodBeat.o(61323);
    }
  }
  
  public static final class c
    extends k
  {
    public static final c ajtl;
    
    static
    {
      AppMethodBeat.i(61328);
      ajtl = new c();
      AppMethodBeat.o(61328);
    }
    
    private c()
    {
      super((kotlin.g.a.b)1.ajtm, (byte)0);
      AppMethodBeat.i(61327);
      AppMethodBeat.o(61327);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.n.k
 * JD-Core Version:    0.7.0.1
 */