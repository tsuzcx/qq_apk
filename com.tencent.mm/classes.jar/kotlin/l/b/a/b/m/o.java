package kotlin.l.b.a.b.m;

import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;

public abstract class o
  extends n
{
  private final aj aaWM;
  
  public o(aj paramaj)
  {
    this.aaWM = paramaj;
  }
  
  private o i(g paramg)
  {
    p.k(paramg, "newAnnotations");
    if (paramg != iDY()) {
      return (o)new i((aj)this, paramg);
    }
    return this;
  }
  
  public final aj Jn(boolean paramBoolean)
  {
    if (paramBoolean == iIu()) {
      return (aj)this;
    }
    return this.aaWM.Jn(paramBoolean).d(iDY());
  }
  
  protected final aj iIq()
  {
    return this.aaWM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.o
 * JD-Core Version:    0.7.0.1
 */