package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.m.bk;
import kotlin.l.b.a.b.m.bl;
import kotlin.l.b.a.b.m.c.i;
import kotlin.l.b.a.b.m.c.k;
import kotlin.l.b.a.b.m.g.b.a;

public final class a
  extends kotlin.l.b.a.b.m.g
{
  public static final a.a ajqQ;
  private final g ajjc;
  private final boolean ajqR;
  private final boolean ajqS;
  private final boolean ajqT;
  private final f ajqU;
  private final c ajqV;
  
  static
  {
    AppMethodBeat.i(60923);
    ajqQ = new a.a((byte)0);
    AppMethodBeat.o(60923);
  }
  
  private a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, g paramg, f paramf, c paramc)
  {
    AppMethodBeat.i(191717);
    this.ajqR = paramBoolean1;
    this.ajqS = paramBoolean2;
    this.ajqT = paramBoolean3;
    this.ajjc = paramg;
    this.ajqU = paramf;
    this.ajqV = paramc;
    AppMethodBeat.o(191717);
  }
  
  public final boolean kAA()
  {
    return this.ajqR;
  }
  
  public final boolean kAB()
  {
    return this.ajqS;
  }
  
  public final i t(i parami)
  {
    AppMethodBeat.i(60917);
    s.u(parami, "type");
    if (!(parami instanceof ad))
    {
      parami = (Throwable)new IllegalArgumentException(b.in(parami).toString());
      AppMethodBeat.o(60917);
      throw parami;
    }
    parami = (i)this.ajjc.aD((ad)parami);
    AppMethodBeat.o(60917);
    return parami;
  }
  
  public final i u(i parami)
  {
    AppMethodBeat.i(60916);
    s.u(parami, "type");
    if (!(parami instanceof ad))
    {
      parami = (Throwable)new IllegalArgumentException(b.in(parami).toString());
      AppMethodBeat.o(60916);
      throw parami;
    }
    parami = (i)this.ajqU.x((i)((ad)parami).kAK());
    AppMethodBeat.o(60916);
    return parami;
  }
  
  public final boolean v(i parami)
  {
    AppMethodBeat.i(60920);
    s.u(parami, "<this>");
    if (((parami instanceof bk)) && (this.ajqT) && ((((bk)parami).kzm() instanceof n)))
    {
      AppMethodBeat.o(60920);
      return true;
    }
    AppMethodBeat.o(60920);
    return false;
  }
  
  public static final class a$a
    extends g.b.a
  {
    a$a(c paramc, be parambe) {}
    
    public final k a(kotlin.l.b.a.b.m.g paramg, i parami)
    {
      AppMethodBeat.i(60915);
      s.u(paramg, "context");
      s.u(parami, "type");
      paramg = this.ajqW;
      parami = this.ajqX.b((ad)this.ajqW.n(parami), bl.ajqM);
      s.s(parami, "substitutor.safeSubstitu…ANT\n                    )");
      paramg = paramg.c((i)parami);
      s.checkNotNull(paramg);
      AppMethodBeat.o(60915);
      return paramg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.a
 * JD-Core Version:    0.7.0.1
 */