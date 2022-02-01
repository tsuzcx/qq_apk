package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.e.a.b;
import kotlin.l.b.a.b.e.a.b.b;
import kotlin.l.b.a.b.e.b.b.a;
import kotlin.l.b.a.b.e.b.b.c;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.b.h;
import kotlin.l.b.a.b.f.a;

public abstract class z
{
  public final c SZH;
  public final h SZI;
  public final an Tik;
  
  private z(c paramc, h paramh, an paraman)
  {
    this.SZH = paramc;
    this.SZI = paramh;
    this.Tik = paraman;
  }
  
  public abstract kotlin.l.b.a.b.f.b hLf();
  
  public String toString()
  {
    return getClass().getSimpleName() + ": " + hLf();
  }
  
  public static final class a
    extends z
  {
    final a.b TKA;
    public final a.b.b TLA;
    public final a TLB;
    public final a Tfj;
    public final boolean Thz;
    
    public a(a.b paramb, c paramc, h paramh, an paraman, a parama)
    {
      super(paramh, paraman, (byte)0);
      AppMethodBeat.i(60347);
      this.TKA = paramb;
      this.TLB = parama;
      this.Tfj = x.a(paramc, this.TKA.Txs);
      paramc = (a.b.b)kotlin.l.b.a.b.e.b.b.TAY.get(this.TKA.Txb);
      paramb = paramc;
      if (paramc == null) {
        paramb = a.b.b.TxK;
      }
      this.TLA = paramb;
      paramb = kotlin.l.b.a.b.e.b.b.TAZ.avk(this.TKA.Txb);
      p.g(paramb, "Flags.IS_INNER.get(classProto.flags)");
      this.Thz = paramb.booleanValue();
      AppMethodBeat.o(60347);
    }
    
    public final kotlin.l.b.a.b.f.b hLf()
    {
      AppMethodBeat.i(60346);
      kotlin.l.b.a.b.f.b localb = this.Tfj.hJd();
      p.g(localb, "classId.asSingleFqName()");
      AppMethodBeat.o(60346);
      return localb;
    }
  }
  
  public static final class b
    extends z
  {
    private final kotlin.l.b.a.b.f.b TiI;
    
    public b(kotlin.l.b.a.b.f.b paramb, c paramc, h paramh, an paraman)
    {
      super(paramh, paraman, (byte)0);
      AppMethodBeat.i(60348);
      this.TiI = paramb;
      AppMethodBeat.o(60348);
    }
    
    public final kotlin.l.b.a.b.f.b hLf()
    {
      return this.TiI;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.z
 * JD-Core Version:    0.7.0.1
 */