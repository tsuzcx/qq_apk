package d.l.b.a.b.m;

import d.l.b.a.b.b.a.g;
import d.l.b.a.b.j.f.h;
import d.v;
import java.util.List;

public abstract class bi
  extends ab
{
  public bi()
  {
    super((byte)0);
  }
  
  public final h fQN()
  {
    return gcA().fQN();
  }
  
  public final g fQj()
  {
    return gcA().fQj();
  }
  
  public final boolean fUx()
  {
    return gcA().fUx();
  }
  
  public final List<av> gbw()
  {
    return gcA().gbw();
  }
  
  public final at gbz()
  {
    return gcA().gbz();
  }
  
  protected abstract ab gcA();
  
  public boolean gcp()
  {
    return true;
  }
  
  public final bg gcz()
  {
    for (ab localab = gcA(); (localab instanceof bi); localab = ((bi)localab).gcA()) {}
    if (localab == null) {
      throw new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
    }
    return (bg)localab;
  }
  
  public String toString()
  {
    if (gcp()) {
      return gcA().toString();
    }
    return "<Not computed yet>";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.bi
 * JD-Core Version:    0.7.0.1
 */