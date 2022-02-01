package kotlin.l.b.a.b.b.c;

import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;

public abstract class al
  extends ak
{
  protected final boolean TmC;
  protected kotlin.l.b.a.b.l.g<kotlin.l.b.a.b.j.b.g<?>> TmD;
  
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
    this.TmC = paramBoolean;
  }
  
  public final void a(kotlin.l.b.a.b.l.g<kotlin.l.b.a.b.j.b.g<?>> paramg)
  {
    if (paramg == null) {
      atM(4);
    }
    assert (!this.TmC) : ("Constant value for variable initializer should be recorded only for final variables: " + hAH());
    this.TmD = paramg;
  }
  
  public final boolean hBF()
  {
    return this.TmC;
  }
  
  public final kotlin.l.b.a.b.j.b.g<?> hBG()
  {
    if (this.TmD != null) {
      return (kotlin.l.b.a.b.j.b.g)this.TmD.invoke();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.al
 * JD-Core Version:    0.7.0.1
 */