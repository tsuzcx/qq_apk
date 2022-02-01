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
  
  public final h gmN()
  {
    return gqu().gmN();
  }
  
  public g gmj()
  {
    return gqu().gmj();
  }
  
  protected abstract aj gqu();
  
  public boolean gqy()
  {
    return gqu().gqy();
  }
  
  public final at gxB()
  {
    return gqu().gxB();
  }
  
  public final List<av> gxy()
  {
    return gqu().gxy();
  }
  
  public aj i(i parami)
  {
    p.h(parami, "kotlinTypeRefiner");
    parami = parami.aL((ab)gqu());
    if (parami == null) {
      throw new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
    }
    return (aj)b((aj)parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.n
 * JD-Core Version:    0.7.0.1
 */