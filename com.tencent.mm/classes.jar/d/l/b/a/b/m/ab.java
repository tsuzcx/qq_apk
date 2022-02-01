package d.l.b.a.b.m;

import d.l.b.a.b.b.a.a;
import d.l.b.a.b.j.f.h;
import d.l.b.a.b.m.a.i;
import d.l.b.a.b.m.a.t;
import d.l.b.a.b.m.c.g;
import java.util.List;

public abstract class ab
  implements a, g
{
  private int JXS;
  
  public abstract ab d(i parami);
  
  public final boolean equals(Object paramObject)
  {
    if ((ab)this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ab)) {
      return false;
    }
    if (fBT() == ((ab)paramObject).fBT())
    {
      t localt = t.JZh;
      if (t.a(fJW(), ((ab)paramObject).fJW())) {
        return true;
      }
    }
    return false;
  }
  
  public abstract boolean fBT();
  
  public abstract List<av> fIT();
  
  public abstract at fIW();
  
  public abstract bg fJW();
  
  public abstract h fyj();
  
  public final int hashCode()
  {
    int i = this.JXS;
    if (i != 0) {
      return i;
    }
    if (ad.aq(this))
    {
      i = super.hashCode();
      this.JXS = i;
      return i;
    }
    int j = fIW().hashCode();
    int k = fIT().hashCode();
    if (fBT()) {}
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