package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.j.g.h;

public class u
  extends al
{
  private final List<az> aiHl;
  private final h aiLf;
  private final boolean ajjw;
  private final ax ajpu;
  private final String ajpv;
  
  public u(ax paramax, h paramh)
  {
    this(paramax, paramh, null, false, null, 28);
    AppMethodBeat.i(60665);
    AppMethodBeat.o(60665);
  }
  
  public u(ax paramax, h paramh, List<? extends az> paramList)
  {
    this(paramax, paramh, paramList, false, null, 16);
    AppMethodBeat.i(191617);
    AppMethodBeat.o(191617);
  }
  
  private u(ax paramax, h paramh, List<? extends az> paramList, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(191612);
    this.ajpu = paramax;
    this.aiLf = paramh;
    this.aiHl = paramList;
    this.ajjw = paramBoolean;
    this.ajpv = paramString;
    AppMethodBeat.o(191612);
  }
  
  public al Pq(boolean paramBoolean)
  {
    AppMethodBeat.i(60659);
    al localal = (al)new u(this.ajpu, this.aiLf, this.aiHl, paramBoolean, null, 16);
    AppMethodBeat.o(60659);
    return localal;
  }
  
  public final al d(kotlin.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(60657);
    s.u(paramg, "newAnnotations");
    paramg = (al)this;
    AppMethodBeat.o(60657);
    return paramg;
  }
  
  public u k(kotlin.l.b.a.b.m.a.g paramg)
  {
    AppMethodBeat.i(60661);
    s.u(paramg, "kotlinTypeRefiner");
    AppMethodBeat.o(60661);
    return this;
  }
  
  public String kAE()
  {
    return this.ajpv;
  }
  
  public final List<az> klR()
  {
    return this.aiHl;
  }
  
  public final h knP()
  {
    return this.aiLf;
  }
  
  public final kotlin.l.b.a.b.b.a.g knl()
  {
    AppMethodBeat.i(60655);
    Object localObject = kotlin.l.b.a.b.b.a.g.aiIh;
    localObject = g.a.kpB();
    AppMethodBeat.o(60655);
    return localObject;
  }
  
  public final boolean ksB()
  {
    return this.ajjw;
  }
  
  public final ax kzm()
  {
    return this.ajpu;
  }
  
  public String toString()
  {
    AppMethodBeat.i(60656);
    StringBuilder localStringBuilder = new StringBuilder().append(this.ajpu);
    if (this.aiHl.isEmpty()) {}
    for (String str = "";; str = p.a((Iterable)this.aiHl, (CharSequence)", ", (CharSequence)"<", (CharSequence)">", -1, (CharSequence)"...", null))
    {
      str = str;
      AppMethodBeat.o(60656);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.u
 * JD-Core Version:    0.7.0.1
 */