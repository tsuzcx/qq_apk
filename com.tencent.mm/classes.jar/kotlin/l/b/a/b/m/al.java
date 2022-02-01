package kotlin.l.b.a.b.m;

import java.util.Collection;
import java.util.Iterator;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.m.c.k;
import kotlin.l.b.a.b.m.c.m;
import kotlin.n.n;

public abstract class al
  extends bk
  implements k, m
{
  public al()
  {
    super((byte)0);
  }
  
  public abstract al Pq(boolean paramBoolean);
  
  public abstract al d(g paramg);
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    Iterator localIterator = knl().iterator();
    while (localIterator.hasNext())
    {
      kotlin.l.b.a.b.b.a.c localc = (kotlin.l.b.a.b.b.a.c)localIterator.next();
      n.a((StringBuilder)localObject, new String[] { "[", kotlin.l.b.a.b.i.c.a(kotlin.l.b.a.b.i.c.ajgB, localc), "] " });
    }
    ((StringBuilder)localObject).append(kzm());
    if (!((Collection)klR()).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        p.a((Iterable)klR(), (Appendable)localObject, (CharSequence)", ", (CharSequence)"<", (CharSequence)">", 0, null, null, 112);
      }
      if (ksB()) {
        ((StringBuilder)localObject).append("?");
      }
      localObject = ((StringBuilder)localObject).toString();
      s.s(localObject, "StringBuilder().apply(builderAction).toString()");
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.al
 * JD-Core Version:    0.7.0.1
 */