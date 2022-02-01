package d.l.b.a.b.m;

import d.g.b.p;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.j.f.h;
import d.l.b.a.b.m.a.i;
import d.v;
import java.util.List;

public abstract class n
  extends aj
{
  public abstract n b(aj paramaj);
  
  public g ghH()
  {
    return glS().ghH();
  }
  
  public final h gil()
  {
    return glS().gil();
  }
  
  protected abstract aj glS();
  
  public boolean glW()
  {
    return glS().glW();
  }
  
  public final List<av> gsW()
  {
    return glS().gsW();
  }
  
  public final at gsZ()
  {
    return glS().gsZ();
  }
  
  public aj i(i parami)
  {
    p.h(parami, "kotlinTypeRefiner");
    parami = parami.aL((ab)glS());
    if (parami == null) {
      throw new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
    }
    return (aj)b((aj)parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.n
 * JD-Core Version:    0.7.0.1
 */