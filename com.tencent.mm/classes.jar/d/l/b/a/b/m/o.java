package d.l.b.a.b.m;

import d.g.b.k;
import d.l.b.a.b.b.a.g;

public abstract class o
  extends n
{
  private final aj Lqj;
  
  public o(aj paramaj)
  {
    this.Lqj = paramaj;
  }
  
  private o i(g paramg)
  {
    k.h(paramg, "newAnnotations");
    if (paramg != fQj()) {
      return (o)new i((aj)this, paramg);
    }
    return this;
  }
  
  protected final aj fUt()
  {
    return this.Lqj;
  }
  
  public final aj zo(boolean paramBoolean)
  {
    if (paramBoolean == fUx()) {
      return (aj)this;
    }
    return this.Lqj.zo(paramBoolean).d(fQj());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.o
 * JD-Core Version:    0.7.0.1
 */