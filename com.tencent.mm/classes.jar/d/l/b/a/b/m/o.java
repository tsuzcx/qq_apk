package d.l.b.a.b.m;

import d.g.b.k;
import d.l.b.a.b.b.a.g;

public abstract class o
  extends n
{
  private final aj JCQ;
  
  public o(aj paramaj)
  {
    this.JCQ = paramaj;
  }
  
  private o i(g paramg)
  {
    k.h(paramg, "newAnnotations");
    if (paramg != fxF()) {
      return (o)new i((aj)this, paramg);
    }
    return this;
  }
  
  protected final aj fBP()
  {
    return this.JCQ;
  }
  
  public final aj xW(boolean paramBoolean)
  {
    if (paramBoolean == fBT()) {
      return (aj)this;
    }
    return this.JCQ.xW(paramBoolean).d(fxF());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.o
 * JD-Core Version:    0.7.0.1
 */