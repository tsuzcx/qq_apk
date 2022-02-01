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
  
  public final h hAp()
  {
    return hDW().hAp();
  }
  
  protected abstract aj hDW();
  
  public boolean hEa()
  {
    return hDW().hEa();
  }
  
  public final List<av> hKB()
  {
    return hDW().hKB();
  }
  
  public final at hKE()
  {
    return hDW().hKE();
  }
  
  public g hzL()
  {
    return hDW().hzL();
  }
  
  public aj i(i parami)
  {
    p.h(parami, "kotlinTypeRefiner");
    parami = parami.aK((ab)hDW());
    if (parami == null) {
      throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
    }
    return (aj)b((aj)parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.n
 * JD-Core Version:    0.7.0.1
 */