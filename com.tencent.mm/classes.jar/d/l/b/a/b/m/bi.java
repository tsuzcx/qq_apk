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
  
  public final h gmN()
  {
    return gyD().gmN();
  }
  
  public final g gmj()
  {
    return gyD().gmj();
  }
  
  public final boolean gqy()
  {
    return gyD().gqy();
  }
  
  public final at gxB()
  {
    return gyD().gxB();
  }
  
  public final List<av> gxy()
  {
    return gyD().gxy();
  }
  
  public final bg gyC()
  {
    for (ab localab = gyD(); (localab instanceof bi); localab = ((bi)localab).gyD()) {}
    if (localab == null) {
      throw new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
    }
    return (bg)localab;
  }
  
  protected abstract ab gyD();
  
  public boolean gyq()
  {
    return true;
  }
  
  public String toString()
  {
    if (gyq()) {
      return gyD().toString();
    }
    return "<Not computed yet>";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.bi
 * JD-Core Version:    0.7.0.1
 */