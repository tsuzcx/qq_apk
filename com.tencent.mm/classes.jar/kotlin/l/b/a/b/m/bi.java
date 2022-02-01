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
  
  public final g iDY()
  {
    return iPY().iDY();
  }
  
  public final h iEC()
  {
    return iPY().iEC();
  }
  
  public final boolean iIu()
  {
    return iPY().iIu();
  }
  
  public final List<av> iOR()
  {
    return iPY().iOR();
  }
  
  public final at iOU()
  {
    return iPY().iOU();
  }
  
  public boolean iPL()
  {
    return true;
  }
  
  public final bg iPX()
  {
    for (ab localab = iPY(); (localab instanceof bi); localab = ((bi)localab).iPY()) {}
    if (localab == null) {
      throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
    }
    return (bg)localab;
  }
  
  protected abstract ab iPY();
  
  public String toString()
  {
    if (iPL()) {
      return iPY().toString();
    }
    return "<Not computed yet>";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.bi
 * JD-Core Version:    0.7.0.1
 */