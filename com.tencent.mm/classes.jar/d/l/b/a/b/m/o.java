package d.l.b.a.b.m;

import d.g.b.p;
import d.l.b.a.b.b.a.g;

public abstract class o
  extends n
{
  private final aj NEl;
  
  public o(aj paramaj)
  {
    this.NEl = paramaj;
  }
  
  private o i(g paramg)
  {
    p.h(paramg, "newAnnotations");
    if (paramg != gmj()) {
      return (o)new i((aj)this, paramg);
    }
    return this;
  }
  
  public final aj Ap(boolean paramBoolean)
  {
    if (paramBoolean == gqy()) {
      return (aj)this;
    }
    return this.NEl.Ap(paramBoolean).d(gmj());
  }
  
  protected final aj gqu()
  {
    return this.NEl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.o
 * JD-Core Version:    0.7.0.1
 */