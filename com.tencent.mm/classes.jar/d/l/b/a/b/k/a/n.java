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
  public final c MMU;
  public final h MMV;
  public final d.l.b.a.b.b.l MXA;
  public final l NiH;
  public final ad NyV;
  public final w NyW;
  final i NyX;
  final f NyY;
  private final a Nyy;
  
  public n(l paraml, c paramc, d.l.b.a.b.b.l paraml1, h paramh, i parami, a parama, f paramf, ad paramad, List<a.r> paramList)
  {
    AppMethodBeat.i(60309);
    this.NiH = paraml;
    this.MMU = paramc;
    this.MXA = paraml1;
    this.MMV = paramh;
    this.NyX = parami;
    this.Nyy = parama;
    this.NyY = paramf;
    paraml1 = "Deserializer for \"" + this.MXA.giD() + '"';
    paraml = this.NyY;
    if (paraml != null)
    {
      paramc = paraml.gmh();
      paraml = paramc;
      if (paramc != null) {}
    }
    else
    {
      paraml = "[container not found]";
    }
    this.NyV = new ad(this, paramad, paramList, paraml1, paraml, (byte)0);
    this.NyW = new w(this);
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
    l locall = this.NiH;
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
      paraml = new n(locall, paramc, paraml, paramh, parami, parama, this.NyY, this.NyV, paramList);
      AppMethodBeat.o(60307);
      return paraml;
      i = 0;
      break;
      label130:
      parami = this.NyX;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.k.a.n
 * JD-Core Version:    0.7.0.1
 */