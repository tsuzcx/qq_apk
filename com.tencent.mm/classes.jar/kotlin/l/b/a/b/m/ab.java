package kotlin.l.b.a.b.m;

import java.util.List;
import kotlin.l.b.a.b.b.a.a;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.a.t;

public abstract class ab
  implements a, kotlin.l.b.a.b.m.c.h
{
  private int abqG;
  
  public abstract ab d(i parami);
  
  public final boolean equals(Object paramObject)
  {
    if ((ab)this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ab)) {
      return false;
    }
    if (iIu() == ((ab)paramObject).iIu())
    {
      t localt = t.abrV;
      if (t.a(iPX(), ((ab)paramObject).iPX())) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    int i = this.abqG;
    if (i != 0) {
      return i;
    }
    if (ad.ap(this))
    {
      i = super.hashCode();
      this.abqG = i;
      return i;
    }
    int j = iOU().hashCode();
    int k = iOR().hashCode();
    if (iIu()) {}
    for (i = 1;; i = 0)
    {
      i += (j * 31 + k) * 31;
      break;
    }
  }
  
  public abstract kotlin.l.b.a.b.j.f.h iEC();
  
  public abstract boolean iIu();
  
  public abstract List<av> iOR();
  
  public abstract at iOU();
  
  public abstract bg iPX();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.ab
 * JD-Core Version:    0.7.0.1
 */