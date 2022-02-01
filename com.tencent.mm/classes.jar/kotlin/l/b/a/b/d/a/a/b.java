package kotlin.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.g.b.af;
import kotlin.g.b.ag;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.d.a.e.l;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.l.m;
import kotlin.l.b.a.b.m.al;
import kotlin.l.e;
import kotlin.l.o;

public class b
  implements kotlin.l.b.a.b.d.a.b.g
{
  private final av aiHP;
  final kotlin.l.b.a.b.f.c aiIl;
  private final kotlin.l.b.a.b.l.h aiQP;
  final kotlin.l.b.a.b.d.a.e.b aiQQ;
  private final boolean aiQR;
  
  static
  {
    AppMethodBeat.i(57654);
    aYe = new o[] { (o)ai.a((af)new ag((e)ai.cz(b.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")) };
    AppMethodBeat.o(57654);
  }
  
  public b(kotlin.l.b.a.b.d.a.c.h paramh, kotlin.l.b.a.b.d.a.e.a parama, kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(57657);
    this.aiIl = paramc;
    if (parama == null)
    {
      paramc = null;
      if (paramc != null) {
        break label139;
      }
      paramc = av.aiHu;
      s.s(paramc, "NO_SOURCE");
      label46:
      this.aiHP = paramc;
      this.aiQP = paramh.aiSp.aiBu.cq((kotlin.g.a.a)new a(paramh, this));
      if (parama != null) {
        break label147;
      }
      paramh = null;
      label85:
      this.aiQQ = paramh;
      if ((parama == null) || (parama.kqt() != true)) {
        break label177;
      }
    }
    label139:
    label147:
    label177:
    for (boolean bool = true;; bool = false)
    {
      this.aiQR = bool;
      AppMethodBeat.o(57657);
      return;
      paramc = paramh.aiSp.aiRS.a((l)parama);
      break;
      paramc = (av)paramc;
      break label46;
      paramh = parama.kqr();
      if (paramh == null)
      {
        paramh = null;
        break label85;
      }
      paramh = (kotlin.l.b.a.b.d.a.e.b)p.f((Iterable)paramh);
      break label85;
    }
  }
  
  public final av knm()
  {
    return this.aiHP;
  }
  
  public final kotlin.l.b.a.b.f.c koY()
  {
    return this.aiIl;
  }
  
  public Map<f, kotlin.l.b.a.b.j.b.g<?>> kpA()
  {
    AppMethodBeat.i(57656);
    Map localMap = ak.kkZ();
    AppMethodBeat.o(57656);
    return localMap;
  }
  
  public final boolean kqt()
  {
    return this.aiQR;
  }
  
  static final class a
    extends u
    implements kotlin.g.a.a<al>
  {
    a(kotlin.l.b.a.b.d.a.c.h paramh, b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.a.b
 * JD-Core Version:    0.7.0.1
 */