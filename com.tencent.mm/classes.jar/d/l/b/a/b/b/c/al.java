package d.l.b.a.b.b.c;

import d.l.b.a.b.b.an;
import d.l.b.a.b.b.l;
import d.l.b.a.b.f.f;

public abstract class al
  extends ak
{
  protected final boolean LiS;
  protected d.l.b.a.b.l.g<d.l.b.a.b.j.b.g<?>> LiT;
  
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
    this.LiS = paramBoolean;
  }
  
  public final void a(d.l.b.a.b.l.g<d.l.b.a.b.j.b.g<?>> paramg)
  {
    if (paramg == null) {
      agL(4);
    }
    assert (!this.LiS) : ("Constant value for variable initializer should be recorded only for final variables: " + fRf());
    this.LiT = paramg;
  }
  
  public final boolean fSc()
  {
    return this.LiS;
  }
  
  public final d.l.b.a.b.j.b.g<?> fSd()
  {
    if (this.LiT != null) {
      return (d.l.b.a.b.j.b.g)this.LiT.invoke();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.al
 * JD-Core Version:    0.7.0.1
 */