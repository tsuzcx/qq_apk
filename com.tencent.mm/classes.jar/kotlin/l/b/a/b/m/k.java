package kotlin.l.b.a.b.m;

import java.util.List;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.l;

public abstract class k
  implements ax
{
  private int cHb;
  
  private static boolean e(h paramh)
  {
    return (!v.L((l)paramh)) && (!kotlin.l.b.a.b.j.d.m((l)paramh));
  }
  
  protected abstract boolean a(h paramh);
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ax)) {
      return false;
    }
    if (paramObject.hashCode() != hashCode()) {
      return false;
    }
    if (((ax)paramObject).klq().size() != klq().size()) {
      return false;
    }
    h localh = knA();
    paramObject = ((ax)paramObject).knA();
    if (paramObject == null) {
      return false;
    }
    if ((!e(localh)) || (!e(paramObject))) {
      return false;
    }
    return a(paramObject);
  }
  
  public int hashCode()
  {
    int i = this.cHb;
    if (i != 0) {
      return i;
    }
    h localh = knA();
    if (e(localh)) {}
    for (i = kotlin.l.b.a.b.j.d.n((l)localh).hashCode();; i = System.identityHashCode(this))
    {
      this.cHb = i;
      return i;
    }
  }
  
  public abstract h knA();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.k
 * JD-Core Version:    0.7.0.1
 */