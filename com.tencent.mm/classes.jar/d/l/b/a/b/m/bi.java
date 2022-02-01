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
  
  public final g ghH()
  {
    return gub().ghH();
  }
  
  public final h gil()
  {
    return gub().gil();
  }
  
  public final boolean glW()
  {
    return gub().glW();
  }
  
  public final List<av> gsW()
  {
    return gub().gsW();
  }
  
  public final at gsZ()
  {
    return gub().gsZ();
  }
  
  public boolean gtO()
  {
    return true;
  }
  
  public final bg gua()
  {
    for (ab localab = gub(); (localab instanceof bi); localab = ((bi)localab).gub()) {}
    if (localab == null) {
      throw new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
    }
    return (bg)localab;
  }
  
  protected abstract ab gub();
  
  public String toString()
  {
    if (gtO()) {
      return gub().toString();
    }
    return "<Not computed yet>";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.bi
 * JD-Core Version:    0.7.0.1
 */