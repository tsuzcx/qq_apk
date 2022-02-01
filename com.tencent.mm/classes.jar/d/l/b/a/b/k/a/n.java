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
  public final l JEr;
  public final ad JUE;
  public final w JUF;
  final i JUG;
  final f JUH;
  private final a JUh;
  public final c Jiu;
  public final h Jiv;
  public final d.l.b.a.b.b.l Jtl;
  
  public n(l paraml, c paramc, d.l.b.a.b.b.l paraml1, h paramh, i parami, a parama, f paramf, ad paramad, List<a.r> paramList)
  {
    AppMethodBeat.i(60309);
    this.JEr = paraml;
    this.Jiu = paramc;
    this.Jtl = paraml1;
    this.Jiv = paramh;
    this.JUG = parami;
    this.JUh = parama;
    this.JUH = paramf;
    paraml1 = "Deserializer for \"" + this.Jtl.fyB() + '"';
    paraml = this.JUH;
    if (paraml != null)
    {
      paramc = paraml.fCe();
      paraml = paramc;
      if (paramc != null) {}
    }
    else
    {
      paraml = "[container not found]";
    }
    this.JUE = new ad(this, paramad, paramList, paraml1, paraml, (byte)0);
    this.JUF = new w(this);
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
    l locall = this.JEr;
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
      paraml = new n(locall, paramc, paraml, paramh, parami, parama, this.JUH, this.JUE, paramList);
      AppMethodBeat.o(60307);
      return paraml;
      i = 0;
      break;
      label130:
      parami = this.JUG;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.k.a.n
 * JD-Core Version:    0.7.0.1
 */