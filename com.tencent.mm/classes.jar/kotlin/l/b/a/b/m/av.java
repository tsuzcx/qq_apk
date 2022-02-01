package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a.c;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.ba;

public abstract interface av
{
  public abstract void a(az paramaz, ad paramad);
  
  public abstract void a(be parambe, ad paramad1, ad paramad2, ba paramba);
  
  public abstract void c(az paramaz);
  
  public abstract void l(c paramc);
  
  public static final class a
    implements av
  {
    public static final a ajqr;
    
    static
    {
      AppMethodBeat.i(191646);
      ajqr = new a();
      AppMethodBeat.o(191646);
    }
    
    public final void a(az paramaz, ad paramad)
    {
      AppMethodBeat.i(191652);
      s.u(paramaz, "typeAlias");
      s.u(paramad, "substitutedArgument");
      AppMethodBeat.o(191652);
    }
    
    public final void a(be parambe, ad paramad1, ad paramad2, ba paramba)
    {
      AppMethodBeat.i(191656);
      s.u(parambe, "substitutor");
      s.u(paramad1, "unsubstitutedArgument");
      s.u(paramad2, "argument");
      s.u(paramba, "typeParameter");
      AppMethodBeat.o(191656);
    }
    
    public final void c(az paramaz)
    {
      AppMethodBeat.i(191654);
      s.u(paramaz, "typeAlias");
      AppMethodBeat.o(191654);
    }
    
    public final void l(c paramc)
    {
      AppMethodBeat.i(191660);
      s.u(paramc, "annotation");
      AppMethodBeat.o(191660);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.av
 * JD-Core Version:    0.7.0.1
 */