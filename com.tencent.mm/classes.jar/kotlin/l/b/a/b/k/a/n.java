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
  public final c aaCB;
  public final h aaCC;
  public final kotlin.l.b.a.b.b.l aaNi;
  public final l aaYm;
  public final ad abnB;
  public final w abnC;
  final i abnD;
  final f abnE;
  private final a abne;
  
  public n(l paraml, c paramc, kotlin.l.b.a.b.b.l paraml1, h paramh, i parami, a parama, f paramf, ad paramad, List<a.r> paramList)
  {
    AppMethodBeat.i(60309);
    this.aaYm = paraml;
    this.aaCB = paramc;
    this.aaNi = paraml1;
    this.aaCC = paramh;
    this.abnD = parami;
    this.abne = parama;
    this.abnE = paramf;
    paraml1 = "Deserializer for \"" + this.aaNi.iEU() + '"';
    paraml = this.abnE;
    if (paraml != null)
    {
      paramc = paraml.iIF();
      paraml = paramc;
      if (paramc != null) {}
    }
    else
    {
      paraml = "[container not found]";
    }
    this.abnB = new ad(this, paramad, paramList, paraml1, paraml, (byte)0);
    this.abnC = new w(this);
    AppMethodBeat.o(60309);
  }
  
  public final n a(kotlin.l.b.a.b.b.l paraml, List<a.r> paramList, c paramc, h paramh, i parami, a parama)
  {
    AppMethodBeat.i(60307);
    p.k(paraml, "descriptor");
    p.k(paramList, "typeParameterProtos");
    p.k(paramc, "nameResolver");
    p.k(paramh, "typeTable");
    p.k(parami, "versionRequirementTable");
    p.k(parama, "metadataVersion");
    l locall = this.aaYm;
    p.k(parama, "version");
    p.k(parama, "version");
    int i;
    if ((parama.oey == 1) && (parama.oez >= 4))
    {
      i = 1;
      if (i == 0) {
        break label130;
      }
    }
    for (;;)
    {
      paraml = new n(locall, paramc, paraml, paramh, parami, parama, this.abnE, this.abnB, paramList);
      AppMethodBeat.o(60307);
      return paraml;
      i = 0;
      break;
      label130:
      parami = this.abnD;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.n
 * JD-Core Version:    0.7.0.1
 */