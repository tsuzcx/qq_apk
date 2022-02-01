package d.l.b.a.b.b.c;

import d.l.b.a.b.b.an;
import d.l.b.a.b.b.l;
import d.l.b.a.b.f.f;

public abstract class al
  extends ak
{
  protected final boolean MZO;
  protected d.l.b.a.b.l.g<d.l.b.a.b.j.b.g<?>> MZP;
  
  static
  {
    if (!al.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public al(l paraml, d.l.b.a.b.b.a.g paramg, f paramf, boolean paramBoolean, an paraman)
  {
    super(paraml, paramg, paramf, null, paraman);
    this.MZO = paramBoolean;
  }
  
  public final void a(d.l.b.a.b.l.g<d.l.b.a.b.j.b.g<?>> paramg)
  {
    if (paramg == null) {
      ajm(4);
    }
    assert (!this.MZO) : ("Constant value for variable initializer should be recorded only for final variables: " + giD());
    this.MZP = paramg;
  }
  
  public final boolean gjB()
  {
    return this.MZO;
  }
  
  public final d.l.b.a.b.j.b.g<?> gjC()
  {
    if (this.MZP != null) {
      return (d.l.b.a.b.j.b.g)this.MZP.invoke();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.al
 * JD-Core Version:    0.7.0.1
 */