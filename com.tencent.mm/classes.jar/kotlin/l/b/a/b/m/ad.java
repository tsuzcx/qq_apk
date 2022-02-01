package kotlin.l.b.a.b.m;

import java.util.List;
import kotlin.l.b.a.b.b.a.a;
import kotlin.l.b.a.b.j.g.h;
import kotlin.l.b.a.b.m.a.g;
import kotlin.l.b.a.b.m.a.r;
import kotlin.l.b.a.b.m.c.i;

public abstract class ad
  implements a, i
{
  private int ajpT;
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ad)) {
      return false;
    }
    if (ksB() == ((ad)paramObject).ksB())
    {
      r localr = r.ajrr;
      if (r.a(kAK(), ((ad)paramObject).kAK())) {
        return true;
      }
    }
    return false;
  }
  
  public abstract ad f(g paramg);
  
  public final int hashCode()
  {
    int i = this.ajpT;
    if (i != 0) {
      return i;
    }
    if (af.ai(this))
    {
      i = super.hashCode();
      this.ajpT = i;
      return i;
    }
    int j = kzm().hashCode();
    int k = klR().hashCode();
    if (ksB()) {}
    for (i = 1;; i = 0)
    {
      i += (j * 31 + k) * 31;
      break;
    }
  }
  
  public abstract bk kAK();
  
  public abstract List<az> klR();
  
  public abstract h knP();
  
  public abstract boolean ksB();
  
  public abstract ax kzm();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.ad
 * JD-Core Version:    0.7.0.1
 */