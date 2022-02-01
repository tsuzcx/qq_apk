package kotlin.l.b.a.b.m;

import java.util.List;
import kotlin.a.ab;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.j.g.h;

public abstract class e
  extends al
{
  public static final e.a ajoQ = new e.a((byte)0);
  private final h aiLf;
  private final boolean ajjw;
  public final ax ajoR;
  
  public e(ax paramax, boolean paramBoolean)
  {
    this.ajoR = paramax;
    this.ajjw = paramBoolean;
    paramax = v.bJs(s.X("Scope for stub type: ", this.ajoR));
    s.s(paramax, "createErrorScope(\"Scope …: $originalTypeVariable\")");
    this.aiLf = paramax;
  }
  
  public abstract e PF(boolean paramBoolean);
  
  public final al Pq(boolean paramBoolean)
  {
    if (paramBoolean == this.ajjw) {
      return (al)this;
    }
    return (al)PF(paramBoolean);
  }
  
  public final al d(g paramg)
  {
    s.u(paramg, "newAnnotations");
    return (al)this;
  }
  
  public final List<az> klR()
  {
    return (List)ab.aivy;
  }
  
  public h knP()
  {
    return this.aiLf;
  }
  
  public final g knl()
  {
    g.a locala = g.aiIh;
    return g.a.kpB();
  }
  
  public final boolean ksB()
  {
    return this.ajjw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.e
 * JD-Core Version:    0.7.0.1
 */