package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.s;
import kotlin.l.b.a.b.e.a.r;
import kotlin.l.b.a.b.e.b.a;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.b.i;

public final class l
{
  public final kotlin.l.b.a.b.b.l aiJT;
  public final j aiWx;
  public final c aiyk;
  public final kotlin.l.b.a.b.e.b.g aiyl;
  private final a ajlN;
  final i ajml;
  final kotlin.l.b.a.b.k.a.b.g ajmm;
  public final ac ajmn;
  public final v ajmo;
  
  public l(j paramj, c paramc, kotlin.l.b.a.b.b.l paraml, kotlin.l.b.a.b.e.b.g paramg, i parami, a parama, kotlin.l.b.a.b.k.a.b.g paramg1, ac paramac, List<a.r> paramList)
  {
    AppMethodBeat.i(60309);
    this.aiWx = paramj;
    this.aiyk = paramc;
    this.aiJT = paraml;
    this.aiyl = paramg;
    this.ajml = parami;
    this.ajlN = parama;
    this.ajmm = paramg1;
    paraml = "Deserializer for \"" + this.aiJT.kok() + '"';
    paramj = this.ajmm;
    if (paramj == null) {
      paramj = "[container not found]";
    }
    for (;;)
    {
      this.ajmn = new ac(this, paramac, paramList, paraml, paramj, (byte)0);
      this.ajmo = new v(this);
      AppMethodBeat.o(60309);
      return;
      paramc = paramj.ksM();
      paramj = paramc;
      if (paramc == null) {
        paramj = "[container not found]";
      }
    }
  }
  
  public final l a(kotlin.l.b.a.b.b.l paraml, List<a.r> paramList, c paramc, kotlin.l.b.a.b.e.b.g paramg, i parami, a parama)
  {
    AppMethodBeat.i(60307);
    s.u(paraml, "descriptor");
    s.u(paramList, "typeParameterProtos");
    s.u(paramc, "nameResolver");
    s.u(paramg, "typeTable");
    s.u(parami, "versionRequirementTable");
    s.u(parama, "metadataVersion");
    j localj = this.aiWx;
    s.u(parama, "version");
    s.u(parama, "version");
    int i;
    if ((parama.rid == 1) && (parama.rie >= 4))
    {
      i = 1;
      if (i == 0) {
        break label130;
      }
    }
    for (;;)
    {
      paraml = new l(localj, paramc, paraml, paramg, parami, parama, this.ajmm, this.ajmn, paramList);
      AppMethodBeat.o(60307);
      return paraml;
      i = 0;
      break;
      label130:
      parami = this.ajml;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.l
 * JD-Core Version:    0.7.0.1
 */