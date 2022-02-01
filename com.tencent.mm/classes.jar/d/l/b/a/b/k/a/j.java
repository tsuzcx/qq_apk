package d.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ak;
import d.g.a.b;
import d.g.b.k;
import d.l.b.a.b.a.g;
import d.l.b.a.b.a.g.a;
import d.l.b.a.b.b.e;
import d.l.b.a.b.f.a;
import d.l.b.a.b.f.c;
import d.l.b.a.b.l.i;
import java.util.Set;

public final class j
{
  private static final Set<a> JUk;
  public static final b JUl;
  private final l JEr;
  private final b<a, e> JUj;
  
  static
  {
    AppMethodBeat.i(60299);
    JUl = new b((byte)0);
    JUk = ak.setOf(a.p(g.JlM.JlS.fHh()));
    AppMethodBeat.o(60299);
  }
  
  public j(l paraml)
  {
    AppMethodBeat.i(60298);
    this.JEr = paraml;
    this.JUj = ((b)this.JEr.JlL.B((b)new c(this)));
    AppMethodBeat.o(60298);
  }
  
  public final e a(a parama, h paramh)
  {
    AppMethodBeat.i(60296);
    k.h(parama, "classId");
    parama = (e)this.JUj.aA(new a(parama, paramh));
    AppMethodBeat.o(60296);
    return parama;
  }
  
  static final class a
  {
    final h JUm;
    final a Joh;
    
    public a(a parama, h paramh)
    {
      AppMethodBeat.i(60294);
      this.Joh = parama;
      this.JUm = paramh;
      AppMethodBeat.o(60294);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(60292);
      if (((paramObject instanceof a)) && (k.g(this.Joh, ((a)paramObject).Joh)))
      {
        AppMethodBeat.o(60292);
        return true;
      }
      AppMethodBeat.o(60292);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(60293);
      int i = this.Joh.hashCode();
      AppMethodBeat.o(60293);
      return i;
    }
  }
  
  public static final class b {}
  
  static final class c
    extends d.g.b.l
    implements b<j.a, e>
  {
    c(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.k.a.j
 * JD-Core Version:    0.7.0.1
 */