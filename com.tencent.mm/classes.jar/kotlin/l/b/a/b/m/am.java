package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.j.g.h;

final class am
  extends al
{
  private final List<az> aiHl;
  private final h aiLf;
  private final boolean ajjw;
  private final ax ajpu;
  private final b<kotlin.l.b.a.b.m.a.g, al> ajqe;
  
  public am(ax paramax, List<? extends az> paramList, boolean paramBoolean, h paramh, b<? super kotlin.l.b.a.b.m.a.g, ? extends al> paramb)
  {
    AppMethodBeat.i(60791);
    this.ajpu = paramax;
    this.aiHl = paramList;
    this.ajjw = paramBoolean;
    this.aiLf = paramh;
    this.ajqe = paramb;
    if ((this.aiLf instanceof v.b))
    {
      paramax = new IllegalStateException("SimpleTypeImpl should not be created for error type: " + this.aiLf + '\n' + this.ajpu);
      AppMethodBeat.o(60791);
      throw paramax;
    }
    AppMethodBeat.o(60791);
  }
  
  private al j(kotlin.l.b.a.b.m.a.g paramg)
  {
    AppMethodBeat.i(60788);
    s.u(paramg, "kotlinTypeRefiner");
    paramg = (al)this.ajqe.invoke(paramg);
    if (paramg == null)
    {
      paramg = (al)this;
      AppMethodBeat.o(60788);
      return paramg;
    }
    AppMethodBeat.o(60788);
    return paramg;
  }
  
  public final al Pq(boolean paramBoolean)
  {
    AppMethodBeat.i(60786);
    if (paramBoolean == this.ajjw)
    {
      localal = (al)this;
      AppMethodBeat.o(60786);
      return localal;
    }
    if (paramBoolean)
    {
      localal = (al)new aj((al)this);
      AppMethodBeat.o(60786);
      return localal;
    }
    al localal = (al)new ah((al)this);
    AppMethodBeat.o(60786);
    return localal;
  }
  
  public final al d(kotlin.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(60784);
    s.u(paramg, "newAnnotations");
    if (paramg.isEmpty())
    {
      paramg = (al)this;
      AppMethodBeat.o(60784);
      return paramg;
    }
    paramg = (al)new i((al)this, paramg);
    AppMethodBeat.o(60784);
    return paramg;
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
    AppMethodBeat.i(60783);
    Object localObject = kotlin.l.b.a.b.b.a.g.aiIh;
    localObject = g.a.kpB();
    AppMethodBeat.o(60783);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.am
 * JD-Core Version:    0.7.0.1
 */