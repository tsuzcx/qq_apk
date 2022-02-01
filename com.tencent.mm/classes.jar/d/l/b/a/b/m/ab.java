package d.l.b.a.b.m;

import d.l.b.a.b.b.a.a;
import d.l.b.a.b.m.a.i;
import d.l.b.a.b.m.a.t;
import java.util.List;

public abstract class ab
  implements a, d.l.b.a.b.m.c.h
{
  private int NCg;
  
  public abstract ab d(i parami);
  
  public final boolean equals(Object paramObject)
  {
    if ((ab)this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ab)) {
      return false;
    }
    if (glW() == ((ab)paramObject).glW())
    {
      t localt = t.NDv;
      if (t.a(gua(), ((ab)paramObject).gua())) {
        return true;
      }
    }
    return false;
  }
  
  public abstract d.l.b.a.b.j.f.h gil();
  
  public abstract boolean glW();
  
  public abstract List<av> gsW();
  
  public abstract at gsZ();
  
  public abstract bg gua();
  
  public final int hashCode()
  {
    int i = this.NCg;
    if (i != 0) {
      return i;
    }
    if (ad.aq(this))
    {
      i = super.hashCode();
      this.NCg = i;
      return i;
    }
    int j = gsZ().hashCode();
    int k = gsW().hashCode();
    if (glW()) {}
    for (i = 1;; i = 0)
    {
      i += (j * 31 + k) * 31;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.ab
 * JD-Core Version:    0.7.0.1
 */