package d.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.an;
import d.l.b.a.b.e.a.b;
import d.l.b.a.b.e.a.b.b;
import d.l.b.a.b.e.b.b.a;
import d.l.b.a.b.e.b.b.c;
import d.l.b.a.b.e.b.c;
import d.l.b.a.b.e.b.h;
import d.l.b.a.b.f.a;

public abstract class z
{
  public final c MMU;
  public final h MMV;
  public final an MVx;
  
  private z(c paramc, h paramh, an paraman)
  {
    this.MMU = paramc;
    this.MMV = paramh;
    this.MVx = paraman;
  }
  
  public abstract d.l.b.a.b.f.b gtA();
  
  public String toString()
  {
    return getClass().getSimpleName() + ": " + gtA();
  }
  
  public static final class a
    extends z
  {
    public final a MSw;
    public final boolean MUM;
    final a.b Nyx;
    public final a.b.b Nzx;
    public final a Nzy;
    
    public a(a.b paramb, c paramc, h paramh, an paraman, a parama)
    {
      super(paramh, paraman, (byte)0);
      AppMethodBeat.i(60347);
      this.Nyx = paramb;
      this.Nzy = parama;
      this.MSw = x.a(paramc, this.Nyx.NkK);
      paramc = (a.b.b)d.l.b.a.b.e.b.b.Noo.get(this.Nyx.Nkt);
      paramb = paramc;
      if (paramc == null) {
        paramb = a.b.b.Nlc;
      }
      this.Nzx = paramb;
      paramb = d.l.b.a.b.e.b.b.Nop.akK(this.Nyx.Nkt);
      p.g(paramb, "Flags.IS_INNER.get(classProto.flags)");
      this.MUM = paramb.booleanValue();
      AppMethodBeat.o(60347);
    }
    
    public final d.l.b.a.b.f.b gtA()
    {
      AppMethodBeat.i(60346);
      d.l.b.a.b.f.b localb = this.MSw.gre();
      p.g(localb, "classId.asSingleFqName()");
      AppMethodBeat.o(60346);
      return localb;
    }
  }
  
  public static final class b
    extends z
  {
    private final d.l.b.a.b.f.b MVU;
    
    public b(d.l.b.a.b.f.b paramb, c paramc, h paramh, an paraman)
    {
      super(paramh, paraman, (byte)0);
      AppMethodBeat.i(60348);
      this.MVU = paramb;
      AppMethodBeat.o(60348);
    }
    
    public final d.l.b.a.b.f.b gtA()
    {
      return this.MVU;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.k.a.z
 * JD-Core Version:    0.7.0.1
 */