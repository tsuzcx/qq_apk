package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.e.a.r;
import kotlin.l.b.a.b.e.b.a;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.b.h;
import kotlin.l.b.a.b.e.b.i;
import kotlin.l.b.a.b.k.a.b.f;

public final class n
{
  public final c SZH;
  public final h SZI;
  private final a TKB;
  public final ad TKY;
  public final w TKZ;
  final i TLa;
  final f TLb;
  public final kotlin.l.b.a.b.b.l Tko;
  public final l Tvt;
  
  public n(l paraml, c paramc, kotlin.l.b.a.b.b.l paraml1, h paramh, i parami, a parama, f paramf, ad paramad, List<a.r> paramList)
  {
    AppMethodBeat.i(60309);
    this.Tvt = paraml;
    this.SZH = paramc;
    this.Tko = paraml1;
    this.SZI = paramh;
    this.TLa = parami;
    this.TKB = parama;
    this.TLb = paramf;
    paraml1 = "Deserializer for \"" + this.Tko.hAH() + '"';
    paraml = this.TLb;
    if (paraml != null)
    {
      paramc = paraml.hEl();
      paraml = paramc;
      if (paramc != null) {}
    }
    else
    {
      paraml = "[container not found]";
    }
    this.TKY = new ad(this, paramad, paramList, paraml1, paraml, (byte)0);
    this.TKZ = new w(this);
    AppMethodBeat.o(60309);
  }
  
  public final n a(kotlin.l.b.a.b.b.l paraml, List<a.r> paramList, c paramc, h paramh, i parami, a parama)
  {
    AppMethodBeat.i(60307);
    p.h(paraml, "descriptor");
    p.h(paramList, "typeParameterProtos");
    p.h(paramc, "nameResolver");
    p.h(paramh, "typeTable");
    p.h(parami, "versionRequirementTable");
    p.h(parama, "metadataVersion");
    l locall = this.Tvt;
    p.h(parama, "version");
    p.h(parama, "version");
    int i;
    if ((parama.major == 1) && (parama.minor >= 4))
    {
      i = 1;
      if (i == 0) {
        break label130;
      }
    }
    for (;;)
    {
      paraml = new n(locall, paramc, paraml, paramh, parami, parama, this.TLb, this.TKY, paramList);
      AppMethodBeat.o(60307);
      return paraml;
      i = 0;
      break;
      label130:
      parami = this.TLa;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.n
 * JD-Core Version:    0.7.0.1
 */