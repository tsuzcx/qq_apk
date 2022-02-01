package kotlin.l.b.a.b.b.c;

import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.l.i;

public abstract class am
  extends al
{
  private final boolean aiMo;
  protected i<kotlin.l.b.a.b.j.b.g<?>> aiMp;
  
  static
  {
    if (!am.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public am(l paraml, kotlin.l.b.a.b.b.a.g paramg, f paramf, boolean paramBoolean, av paramav)
  {
    super(paraml, paramg, paramf, null, paramav);
    this.aiMo = paramBoolean;
  }
  
  public final void a(i<kotlin.l.b.a.b.j.b.g<?>> parami)
  {
    if (parami == null) {
      aKu(4);
    }
    assert (!this.aiMo) : ("Constant value for variable initializer should be recorded only for final variables: " + kok());
    this.aiMp = parami;
  }
  
  public final boolean kpu()
  {
    return this.aiMo;
  }
  
  public final kotlin.l.b.a.b.j.b.g<?> kpv()
  {
    if (this.aiMp != null) {
      return (kotlin.l.b.a.b.j.b.g)this.aiMp.invoke();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.am
 * JD-Core Version:    0.7.0.1
 */