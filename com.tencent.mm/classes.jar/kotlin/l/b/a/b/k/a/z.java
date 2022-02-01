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
  public final c aaCB;
  public final h aaCC;
  public final an aaLe;
  
  private z(c paramc, h paramh, an paraman)
  {
    this.aaCB = paramc;
    this.aaCC = paramh;
    this.aaLe = paraman;
  }
  
  public abstract kotlin.l.b.a.b.f.b iPx();
  
  public String toString()
  {
    return getClass().getSimpleName() + ": " + iPx();
  }
  
  public static final class a
    extends z
  {
    public final a aaId;
    public final boolean aaKt;
    final a.b abnd;
    public final a.b.b abod;
    public final a aboe;
    
    public a(a.b paramb, c paramc, h paramh, an paraman, a parama)
    {
      super(paramh, paraman, (byte)0);
      AppMethodBeat.i(60347);
      this.abnd = paramb;
      this.aboe = parama;
      this.aaId = x.a(paramc, this.abnd.abaj);
      paramc = (a.b.b)kotlin.l.b.a.b.e.b.b.abdM.get(this.abnd.aaZS);
      paramb = paramc;
      if (paramc == null) {
        paramb = a.b.b.abaB;
      }
      this.abod = paramb;
      paramb = kotlin.l.b.a.b.e.b.b.abdN.aFe(this.abnd.aaZS);
      p.j(paramb, "Flags.IS_INNER.get(classProto.flags)");
      this.aaKt = paramb.booleanValue();
      AppMethodBeat.o(60347);
    }
    
    public final kotlin.l.b.a.b.f.b iPx()
    {
      AppMethodBeat.i(60346);
      kotlin.l.b.a.b.f.b localb = this.aaId.iNx();
      p.j(localb, "classId.asSingleFqName()");
      AppMethodBeat.o(60346);
      return localb;
    }
  }
  
  public static final class b
    extends z
  {
    private final kotlin.l.b.a.b.f.b aaLC;
    
    public b(kotlin.l.b.a.b.f.b paramb, c paramc, h paramh, an paraman)
    {
      super(paramh, paraman, (byte)0);
      AppMethodBeat.i(60348);
      this.aaLC = paramb;
      AppMethodBeat.o(60348);
    }
    
    public final kotlin.l.b.a.b.f.b iPx()
    {
      return this.aaLC;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.z
 * JD-Core Version:    0.7.0.1
 */