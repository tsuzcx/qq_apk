package kotlin.l.b.a.b.m;

import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.m.a.i;
import kotlin.t;

public abstract class n
  extends aj
{
  public abstract n b(aj paramaj);
  
  public aj i(i parami)
  {
    p.k(parami, "kotlinTypeRefiner");
    parami = parami.aK((ab)iIq());
    if (parami == null) {
      throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
    }
    return (aj)b((aj)parami);
  }
  
  public g iDY()
  {
    return iIq().iDY();
  }
  
  public final h iEC()
  {
    return iIq().iEC();
  }
  
  protected abstract aj iIq();
  
  public boolean iIu()
  {
    return iIq().iIu();
  }
  
  public final List<av> iOR()
  {
    return iIq().iOR();
  }
  
  public final at iOU()
  {
    return iIq().iOU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.n
 * JD-Core Version:    0.7.0.1
 */