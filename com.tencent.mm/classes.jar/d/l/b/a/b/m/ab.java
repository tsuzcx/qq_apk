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
  private int LLl;
  
  public abstract ab d(i parami);
  
  public final boolean equals(Object paramObject)
  {
    if ((ab)this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ab)) {
      return false;
    }
    if (fUx() == ((ab)paramObject).fUx())
    {
      t localt = t.LMA;
      if (t.a(gcz(), ((ab)paramObject).gcz())) {
        return true;
      }
    }
    return false;
  }
  
  public abstract h fQN();
  
  public abstract boolean fUx();
  
  public abstract List<av> gbw();
  
  public abstract at gbz();
  
  public abstract bg gcz();
  
  public final int hashCode()
  {
    int i = this.LLl;
    if (i != 0) {
      return i;
    }
    if (ad.aq(this))
    {
      i = super.hashCode();
      this.LLl = i;
      return i;
    }
    int j = gbz().hashCode();
    int k = gbw().hashCode();
    if (fUx()) {}
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