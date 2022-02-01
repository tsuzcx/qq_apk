package kotlin.l.b.a.b.m;

import java.util.List;
import kotlin.l.b.a.b.b.a.a;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.a.t;

public abstract class ab
  implements a, kotlin.l.b.a.b.m.c.h
{
  private int TOg;
  
  public abstract ab d(i parami);
  
  public final boolean equals(Object paramObject)
  {
    if ((ab)this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ab)) {
      return false;
    }
    if (hEa() == ((ab)paramObject).hEa())
    {
      t localt = t.TPw;
      if (t.a(hLF(), ((ab)paramObject).hLF())) {
        return true;
      }
    }
    return false;
  }
  
  public abstract kotlin.l.b.a.b.j.f.h hAp();
  
  public abstract boolean hEa();
  
  public abstract List<av> hKB();
  
  public abstract at hKE();
  
  public abstract bg hLF();
  
  public final int hashCode()
  {
    int i = this.TOg;
    if (i != 0) {
      return i;
    }
    if (ad.ap(this))
    {
      i = super.hashCode();
      this.TOg = i;
      return i;
    }
    int j = hKE().hashCode();
    int k = hKB().hashCode();
    if (hEa()) {}
    for (i = 1;; i = 0)
    {
      i += (j * 31 + k) * 31;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.ab
 * JD-Core Version:    0.7.0.1
 */