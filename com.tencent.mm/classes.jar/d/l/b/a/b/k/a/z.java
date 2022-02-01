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
  public final c NjZ;
  public final h Nka;
  public final an NsC;
  
  private z(c paramc, h paramh, an paraman)
  {
    this.NjZ = paramc;
    this.Nka = paramh;
    this.NsC = paraman;
  }
  
  public abstract d.l.b.a.b.f.b gyc();
  
  public String toString()
  {
    return getClass().getSimpleName() + ": " + gyc();
  }
  
  public static final class a
    extends z
  {
    final a.b NVE;
    public final a.b.b NWE;
    public final a NWF;
    public final a NpB;
    public final boolean NrR;
    
    public a(a.b paramb, c paramc, h paramh, an paraman, a parama)
    {
      super(paramh, paraman, (byte)0);
      AppMethodBeat.i(60347);
      this.NVE = paramb;
      this.NWF = parama;
      this.NpB = x.a(paramc, this.NVE.NHQ);
      paramc = (a.b.b)d.l.b.a.b.e.b.b.NLu.get(this.NVE.NHz);
      paramb = paramc;
      if (paramc == null) {
        paramb = a.b.b.NIi;
      }
      this.NWE = paramb;
      paramb = d.l.b.a.b.e.b.b.NLv.alu(this.NVE.NHz);
      p.g(paramb, "Flags.IS_INNER.get(classProto.flags)");
      this.NrR = paramb.booleanValue();
      AppMethodBeat.o(60347);
    }
    
    public final d.l.b.a.b.f.b gyc()
    {
      AppMethodBeat.i(60346);
      d.l.b.a.b.f.b localb = this.NpB.gvG();
      p.g(localb, "classId.asSingleFqName()");
      AppMethodBeat.o(60346);
      return localb;
    }
  }
  
  public static final class b
    extends z
  {
    private final d.l.b.a.b.f.b Nta;
    
    public b(d.l.b.a.b.f.b paramb, c paramc, h paramh, an paraman)
    {
      super(paramh, paraman, (byte)0);
      AppMethodBeat.i(60348);
      this.Nta = paramb;
      AppMethodBeat.o(60348);
    }
    
    public final d.l.b.a.b.f.b gyc()
    {
      return this.Nta;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.z
 * JD-Core Version:    0.7.0.1
 */