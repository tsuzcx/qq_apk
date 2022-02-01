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
  public final c Jiu;
  public final h Jiv;
  public final an Jrj;
  
  private z(c paramc, h paramh, an paraman)
  {
    this.Jiu = paramc;
    this.Jiv = paramh;
    this.Jrj = paraman;
  }
  
  public abstract d.l.b.a.b.f.b fJy();
  
  public String toString()
  {
    return getClass().getSimpleName() + ": " + fJy();
  }
  
  public static final class a
    extends z
  {
    final a.b JUg;
    public final a.b.b JVg;
    public final a JVh;
    public final a Joh;
    public final boolean Jqy;
    
    public a(a.b paramb, c paramc, h paramh, an paraman, a parama)
    {
      super(paramh, paraman, (byte)0);
      AppMethodBeat.i(60347);
      this.JUg = paramb;
      this.JVh = parama;
      this.Joh = x.a(paramc, this.JUg.JGu);
      paramc = (a.b.b)d.l.b.a.b.e.b.b.JJY.get(this.JUg.JGd);
      paramb = paramc;
      if (paramc == null) {
        paramb = a.b.b.JGM;
      }
      this.JVg = paramb;
      paramb = d.l.b.a.b.e.b.b.JJZ.afn(this.JUg.JGd);
      k.g(paramb, "Flags.IS_INNER.get(classProto.flags)");
      this.Jqy = paramb.booleanValue();
      AppMethodBeat.o(60347);
    }
    
    public final d.l.b.a.b.f.b fJy()
    {
      AppMethodBeat.i(60346);
      d.l.b.a.b.f.b localb = this.Joh.fHb();
      k.g(localb, "classId.asSingleFqName()");
      AppMethodBeat.o(60346);
      return localb;
    }
  }
  
  public static final class b
    extends z
  {
    private final d.l.b.a.b.f.b JrG;
    
    public b(d.l.b.a.b.f.b paramb, c paramc, h paramh, an paraman)
    {
      super(paramh, paraman, (byte)0);
      AppMethodBeat.i(60348);
      this.JrG = paramb;
      AppMethodBeat.o(60348);
    }
    
    public final d.l.b.a.b.f.b fJy()
    {
      return this.JrG;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.k.a.z
 * JD-Core Version:    0.7.0.1
 */