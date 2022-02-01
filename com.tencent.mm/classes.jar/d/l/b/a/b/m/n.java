package d.l.b.a.b.m;

import d.g.b.k;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.j.f.h;
import d.l.b.a.b.m.a.i;
import d.v;
import java.util.List;

public abstract class n
  extends aj
{
  public abstract n b(aj paramaj);
  
  public final h fQN()
  {
    return fUt().fQN();
  }
  
  public g fQj()
  {
    return fUt().fQj();
  }
  
  protected abstract aj fUt();
  
  public boolean fUx()
  {
    return fUt().fUx();
  }
  
  public final List<av> gbw()
  {
    return fUt().gbw();
  }
  
  public final at gbz()
  {
    return fUt().gbz();
  }
  
  public aj i(i parami)
  {
    k.h(parami, "kotlinTypeRefiner");
    parami = parami.aL((ab)fUt());
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