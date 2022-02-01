package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.e.a.b;
import kotlin.l.b.a.b.e.a.b.b;
import kotlin.l.b.a.b.e.b.b.a;
import kotlin.l.b.a.b.e.b.b.c;
import kotlin.l.b.a.b.e.b.g;

public abstract class y
{
  public final av aiHP;
  public final kotlin.l.b.a.b.e.b.c aiyk;
  public final g aiyl;
  
  private y(kotlin.l.b.a.b.e.b.c paramc, g paramg, av paramav)
  {
    this.aiyk = paramc;
    this.aiyl = paramg;
    this.aiHP = paramav;
  }
  
  public abstract kotlin.l.b.a.b.f.c kzZ();
  
  public String toString()
  {
    return getClass().getSimpleName() + ": " + kzZ();
  }
  
  public static final class a
    extends y
  {
    public final kotlin.l.b.a.b.f.b aiEe;
    public final boolean aiHg;
    final a.b ajlM;
    public final a ajmM;
    public final a.b.b ajmN;
    
    public a(a.b paramb, kotlin.l.b.a.b.e.b.c paramc, g paramg, av paramav, a parama)
    {
      super(paramg, paramav, (byte)0);
      AppMethodBeat.i(60347);
      this.ajlM = paramb;
      this.ajmM = parama;
      this.aiEe = w.a(paramc, this.ajlM.aiYH);
      paramc = (a.b.b)kotlin.l.b.a.b.e.b.b.ajco.get(this.ajlM.aiYq);
      paramb = paramc;
      if (paramc == null) {
        paramb = a.b.b.aiZc;
      }
      this.ajmN = paramb;
      paramb = kotlin.l.b.a.b.e.b.b.ajcp.aLV(this.ajlM.aiYq);
      s.s(paramb, "IS_INNER.get(classProto.flags)");
      this.aiHg = paramb.booleanValue();
      AppMethodBeat.o(60347);
    }
    
    public final kotlin.l.b.a.b.f.c kzZ()
    {
      AppMethodBeat.i(60346);
      kotlin.l.b.a.b.f.c localc = this.aiEe.kxQ();
      s.s(localc, "classId.asSingleFqName()");
      AppMethodBeat.o(60346);
      return localc;
    }
  }
  
  public static final class b
    extends y
  {
    private final kotlin.l.b.a.b.f.c aiIl;
    
    public b(kotlin.l.b.a.b.f.c paramc, kotlin.l.b.a.b.e.b.c paramc1, g paramg, av paramav)
    {
      super(paramg, paramav, (byte)0);
      AppMethodBeat.i(60348);
      this.aiIl = paramc;
      AppMethodBeat.o(60348);
    }
    
    public final kotlin.l.b.a.b.f.c kzZ()
    {
      return this.aiIl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.y
 * JD-Core Version:    0.7.0.1
 */