package d.l.b.a.b.m;

import d.l.b.a.b.b.a.a;
import d.l.b.a.b.m.a.i;
import d.l.b.a.b.m.a.t;
import java.util.List;

public abstract class ab
  implements a, d.l.b.a.b.m.c.h
{
  private int NZn;
  
  public abstract ab d(i parami);
  
  public final boolean equals(Object paramObject)
  {
    if ((ab)this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ab)) {
      return false;
    }
    if (gqy() == ((ab)paramObject).gqy())
    {
      t localt = t.OaC;
      if (t.a(gyC(), ((ab)paramObject).gyC())) {
        return true;
      }
    }
    return false;
  }
  
  public abstract d.l.b.a.b.j.f.h gmN();
  
  public abstract boolean gqy();
  
  public abstract at gxB();
  
  public abstract List<av> gxy();
  
  public abstract bg gyC();
  
  public final int hashCode()
  {
    int i = this.NZn;
    if (i != 0) {
      return i;
    }
    if (ad.aq(this))
    {
      i = super.hashCode();
      this.NZn = i;
      return i;
    }
    int j = gxB().hashCode();
    int k = gxy().hashCode();
    if (gqy()) {}
    for (i = 1;; i = 0)
    {
      i += (j * 31 + k) * 31;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.ab
 * JD-Core Version:    0.7.0.1
 */