package kotlin.l.b.a.b.m;

import java.util.List;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.j.f.h;
import kotlin.t;

public abstract class bi
  extends ab
{
  public bi()
  {
    super((byte)0);
  }
  
  public final h hAp()
  {
    return hLG().hAp();
  }
  
  public final boolean hEa()
  {
    return hLG().hEa();
  }
  
  public final List<av> hKB()
  {
    return hLG().hKB();
  }
  
  public final at hKE()
  {
    return hLG().hKE();
  }
  
  public final bg hLF()
  {
    for (ab localab = hLG(); (localab instanceof bi); localab = ((bi)localab).hLG()) {}
    if (localab == null) {
      throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
    }
    return (bg)localab;
  }
  
  protected abstract ab hLG();
  
  public boolean hLt()
  {
    return true;
  }
  
  public final g hzL()
  {
    return hLG().hzL();
  }
  
  public String toString()
  {
    if (hLt()) {
      return hLG().toString();
    }
    return "<Not computed yet>";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.bi
 * JD-Core Version:    0.7.0.1
 */