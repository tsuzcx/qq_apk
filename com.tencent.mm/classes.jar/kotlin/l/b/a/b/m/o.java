package kotlin.l.b.a.b.m;

import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;

public abstract class o
  extends n
{
  private final aj TtS;
  
  public o(aj paramaj)
  {
    this.TtS = paramaj;
  }
  
  private o i(g paramg)
  {
    p.h(paramg, "newAnnotations");
    if (paramg != hzL()) {
      return (o)new i((aj)this, paramg);
    }
    return this;
  }
  
  public final aj EG(boolean paramBoolean)
  {
    if (paramBoolean == hEa()) {
      return (aj)this;
    }
    return this.TtS.EG(paramBoolean).d(hzL());
  }
  
  protected final aj hDW()
  {
    return this.TtS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.o
 * JD-Core Version:    0.7.0.1
 */