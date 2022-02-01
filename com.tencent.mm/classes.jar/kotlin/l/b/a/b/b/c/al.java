package kotlin.l.b.a.b.b.c;

import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;

public abstract class al
  extends ak
{
  private final boolean aaPw;
  protected kotlin.l.b.a.b.l.g<kotlin.l.b.a.b.j.b.g<?>> aaPx;
  
  static
  {
    if (!al.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public al(l paraml, kotlin.l.b.a.b.b.a.g paramg, f paramf, boolean paramBoolean, an paraman)
  {
    super(paraml, paramg, paramf, null, paraman);
    this.aaPw = paramBoolean;
  }
  
  public final void a(kotlin.l.b.a.b.l.g<kotlin.l.b.a.b.j.b.g<?>> paramg)
  {
    if (paramg == null) {
      aDG(4);
    }
    assert (!this.aaPw) : ("Constant value for variable initializer should be recorded only for final variables: " + iEU());
    this.aaPx = paramg;
  }
  
  public final boolean iFU()
  {
    return this.aaPw;
  }
  
  public final kotlin.l.b.a.b.j.b.g<?> iFV()
  {
    if (this.aaPx != null) {
      return (kotlin.l.b.a.b.j.b.g)this.aaPx.invoke();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.al
 * JD-Core Version:    0.7.0.1
 */