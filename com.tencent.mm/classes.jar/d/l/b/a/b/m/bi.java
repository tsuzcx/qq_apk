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
  
  public final boolean fBT()
  {
    return fJX().fBT();
  }
  
  public final List<av> fIT()
  {
    return fJX().fIT();
  }
  
  public final at fIW()
  {
    return fJX().fIW();
  }
  
  public boolean fJM()
  {
    return true;
  }
  
  public final bg fJW()
  {
    for (ab localab = fJX(); (localab instanceof bi); localab = ((bi)localab).fJX()) {}
    if (localab == null) {
      throw new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
    }
    return (bg)localab;
  }
  
  protected abstract ab fJX();
  
  public final g fxF()
  {
    return fJX().fxF();
  }
  
  public final h fyj()
  {
    return fJX().fyj();
  }
  
  public String toString()
  {
    if (fJM()) {
      return fJX().toString();
    }
    return "<Not computed yet>";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.bi
 * JD-Core Version:    0.7.0.1
 */