package kotlin.l.b.a.b.b.c;

import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.f.c;

public abstract class y
  extends k
  implements ah
{
  public final c aiIl;
  private final String aiLB;
  
  public y(ae paramae, c paramc)
  {
    super(locall, g.a.kpB(), paramc.kxU(), av.aiHu);
    this.aiIl = paramc;
    this.aiLB = ("package " + this.aiIl + " of " + paramae);
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    s.u(paramn, "visitor");
    return paramn.a((ah)this, paramD);
  }
  
  public av knm()
  {
    av localav = av.aiHu;
    s.s(localav, "NO_SOURCE");
    return localav;
  }
  
  public final ae koX()
  {
    return (ae)super.knp();
  }
  
  public final c koY()
  {
    return this.aiIl;
  }
  
  public String toString()
  {
    return this.aiLB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.y
 * JD-Core Version:    0.7.0.1
 */