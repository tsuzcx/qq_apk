package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ba;

public final class au
{
  public static final a ajqn;
  final List<az> aiHl;
  private final au ajqo;
  final kotlin.l.b.a.b.b.az ajqp;
  private final Map<ba, az> ajqq;
  
  static
  {
    AppMethodBeat.i(191561);
    ajqn = new a((byte)0);
    AppMethodBeat.o(191561);
  }
  
  private au(au paramau, kotlin.l.b.a.b.b.az paramaz, List<? extends az> paramList, Map<ba, ? extends az> paramMap)
  {
    this.ajqo = paramau;
    this.ajqp = paramaz;
    this.aiHl = paramList;
    this.ajqq = paramMap;
  }
  
  public final boolean b(kotlin.l.b.a.b.b.az paramaz)
  {
    AppMethodBeat.i(191567);
    s.u(paramaz, "descriptor");
    au localau;
    if (!s.p(this.ajqp, paramaz))
    {
      localau = this.ajqo;
      if (localau != null) {
        break label44;
      }
    }
    label44:
    for (boolean bool = false; bool; bool = localau.b(paramaz))
    {
      AppMethodBeat.o(191567);
      return true;
    }
    AppMethodBeat.o(191567);
    return false;
  }
  
  public final az d(ax paramax)
  {
    AppMethodBeat.i(191563);
    s.u(paramax, "constructor");
    paramax = paramax.knA();
    if ((paramax instanceof ba))
    {
      paramax = (az)this.ajqq.get(paramax);
      AppMethodBeat.o(191563);
      return paramax;
    }
    AppMethodBeat.o(191563);
    return null;
  }
  
  public static final class a
  {
    public static au a(au paramau, kotlin.l.b.a.b.b.az paramaz, List<? extends az> paramList)
    {
      AppMethodBeat.i(191574);
      s.u(paramaz, "typeAliasDescriptor");
      s.u(paramList, "arguments");
      Object localObject1 = paramaz.kmZ().klq();
      s.s(localObject1, "typeAliasDescriptor.typeConstructor.parameters");
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((ba)((Iterator)localObject2).next()).kop());
      }
      paramau = new au(paramau, paramaz, paramList, ak.F((Iterable)p.d((Iterable)localObject1, (Iterable)paramList)), (byte)0);
      AppMethodBeat.o(191574);
      return paramau;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.au
 * JD-Core Version:    0.7.0.1
 */