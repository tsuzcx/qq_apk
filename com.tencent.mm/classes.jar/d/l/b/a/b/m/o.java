package d.l.b.a.b.m;

import d.g.b.p;
import d.l.b.a.b.b.a.g;

public abstract class o
  extends n
{
  private final aj Nhg;
  
  public o(aj paramaj)
  {
    this.Nhg = paramaj;
  }
  
  private o i(g paramg)
  {
    p.h(paramg, "newAnnotations");
    if (paramg != ghH()) {
      return (o)new i((aj)this, paramg);
    }
    return this;
  }
  
  public final aj Ac(boolean paramBoolean)
  {
    if (paramBoolean == glW()) {
      return (aj)this;
    }
    return this.Nhg.Ac(paramBoolean).d(ghH());
  }
  
  protected final aj glS()
  {
    return this.Nhg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.o
 * JD-Core Version:    0.7.0.1
 */