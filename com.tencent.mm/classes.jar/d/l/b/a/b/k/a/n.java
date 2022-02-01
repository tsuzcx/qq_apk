package d.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.e.a.r;
import d.l.b.a.b.e.b.a;
import d.l.b.a.b.e.b.c;
import d.l.b.a.b.e.b.h;
import d.l.b.a.b.e.b.i;
import d.l.b.a.b.k.a.b.f;
import java.util.List;

public final class n
{
  public final l NFN;
  private final a NVF;
  public final ad NWc;
  public final w NWd;
  final i NWe;
  final f NWf;
  public final c NjZ;
  public final h Nka;
  public final d.l.b.a.b.b.l NuG;
  
  public n(l paraml, c paramc, d.l.b.a.b.b.l paraml1, h paramh, i parami, a parama, f paramf, ad paramad, List<a.r> paramList)
  {
    AppMethodBeat.i(60309);
    this.NFN = paraml;
    this.NjZ = paramc;
    this.NuG = paraml1;
    this.Nka = paramh;
    this.NWe = parami;
    this.NVF = parama;
    this.NWf = paramf;
    paraml1 = "Deserializer for \"" + this.NuG.gnf() + '"';
    paraml = this.NWf;
    if (paraml != null)
    {
      paramc = paraml.gqJ();
      paraml = paramc;
      if (paramc != null) {}
    }
    else
    {
      paraml = "[container not found]";
    }
    this.NWc = new ad(this, paramad, paramList, paraml1, paraml, (byte)0);
    this.NWd = new w(this);
    AppMethodBeat.o(60309);
  }
  
  public final n a(d.l.b.a.b.b.l paraml, List<a.r> paramList, c paramc, h paramh, i parami, a parama)
  {
    AppMethodBeat.i(60307);
    p.h(paraml, "descriptor");
    p.h(paramList, "typeParameterProtos");
    p.h(paramc, "nameResolver");
    p.h(paramh, "typeTable");
    p.h(parami, "versionRequirementTable");
    p.h(parama, "metadataVersion");
    l locall = this.NFN;
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
      paraml = new n(locall, paramc, paraml, paramh, parami, parama, this.NWf, this.NWc, paramList);
      AppMethodBeat.o(60307);
      return paraml;
      i = 0;
      break;
      label130:
      parami = this.NWe;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.n
 * JD-Core Version:    0.7.0.1
 */