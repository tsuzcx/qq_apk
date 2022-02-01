package d.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.e.a.r;
import d.l.b.a.b.e.b.a;
import d.l.b.a.b.e.b.c;
import d.l.b.a.b.e.b.h;
import d.l.b.a.b.e.b.i;
import d.l.b.a.b.k.a.b.f;
import java.util.List;

public final class n
{
  public final c KVO;
  public final h KVP;
  private final a LHA;
  public final ad LHX;
  public final w LHY;
  final i LHZ;
  final f LIa;
  public final d.l.b.a.b.b.l LgE;
  public final l LrK;
  
  public n(l paraml, c paramc, d.l.b.a.b.b.l paraml1, h paramh, i parami, a parama, f paramf, ad paramad, List<a.r> paramList)
  {
    AppMethodBeat.i(60309);
    this.LrK = paraml;
    this.KVO = paramc;
    this.LgE = paraml1;
    this.KVP = paramh;
    this.LHZ = parami;
    this.LHA = parama;
    this.LIa = paramf;
    paraml1 = "Deserializer for \"" + this.LgE.fRf() + '"';
    paraml = this.LIa;
    if (paraml != null)
    {
      paramc = paraml.fUI();
      paraml = paramc;
      if (paramc != null) {}
    }
    else
    {
      paraml = "[container not found]";
    }
    this.LHX = new ad(this, paramad, paramList, paraml1, paraml, (byte)0);
    this.LHY = new w(this);
    AppMethodBeat.o(60309);
  }
  
  public final n a(d.l.b.a.b.b.l paraml, List<a.r> paramList, c paramc, h paramh, i parami, a parama)
  {
    AppMethodBeat.i(60307);
    k.h(paraml, "descriptor");
    k.h(paramList, "typeParameterProtos");
    k.h(paramc, "nameResolver");
    k.h(paramh, "typeTable");
    k.h(parami, "versionRequirementTable");
    k.h(parama, "metadataVersion");
    l locall = this.LrK;
    k.h(parama, "version");
    k.h(parama, "version");
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
      paraml = new n(locall, paramc, paraml, paramh, parami, parama, this.LIa, this.LHX, paramList);
      AppMethodBeat.o(60307);
      return paraml;
      i = 0;
      break;
      label130:
      parami = this.LHZ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.n
 * JD-Core Version:    0.7.0.1
 */