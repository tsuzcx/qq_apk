package d.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
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
  public final c KVO;
  public final h KVP;
  public final an LeC;
  
  private z(c paramc, h paramh, an paraman)
  {
    this.KVO = paramc;
    this.KVP = paramh;
    this.LeC = paraman;
  }
  
  public abstract d.l.b.a.b.f.b gcb();
  
  public String toString()
  {
    return getClass().getSimpleName() + ": " + gcb();
  }
  
  public static final class a
    extends z
  {
    final a.b LHz;
    public final a LIA;
    public final a.b.b LIz;
    public final a LbB;
    public final boolean LdR;
    
    public a(a.b paramb, c paramc, h paramh, an paraman, a parama)
    {
      super(paramh, paraman, (byte)0);
      AppMethodBeat.i(60347);
      this.LHz = paramb;
      this.LIA = parama;
      this.LbB = x.a(paramc, this.LHz.LtN);
      paramc = (a.b.b)d.l.b.a.b.e.b.b.Lxr.get(this.LHz.Ltw);
      paramb = paramc;
      if (paramc == null) {
        paramb = a.b.b.Luf;
      }
      this.LIz = paramb;
      paramb = d.l.b.a.b.e.b.b.Lxs.aij(this.LHz.Ltw);
      k.g(paramb, "Flags.IS_INNER.get(classProto.flags)");
      this.LdR = paramb.booleanValue();
      AppMethodBeat.o(60347);
    }
    
    public final d.l.b.a.b.f.b gcb()
    {
      AppMethodBeat.i(60346);
      d.l.b.a.b.f.b localb = this.LbB.fZF();
      k.g(localb, "classId.asSingleFqName()");
      AppMethodBeat.o(60346);
      return localb;
    }
  }
  
  public static final class b
    extends z
  {
    private final d.l.b.a.b.f.b LeZ;
    
    public b(d.l.b.a.b.f.b paramb, c paramc, h paramh, an paraman)
    {
      super(paramh, paraman, (byte)0);
      AppMethodBeat.i(60348);
      this.LeZ = paramb;
      AppMethodBeat.o(60348);
    }
    
    public final d.l.b.a.b.f.b gcb()
    {
      return this.LeZ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.z
 * JD-Core Version:    0.7.0.1
 */