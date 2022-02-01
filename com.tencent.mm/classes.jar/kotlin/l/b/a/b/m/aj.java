package kotlin.l.b.a.b.m;

import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.m.c.l;
import kotlin.n.n;

public abstract class aj
  extends bg
  implements kotlin.l.b.a.b.m.c.j, l
{
  public aj()
  {
    super((byte)0);
  }
  
  public abstract aj Jn(boolean paramBoolean);
  
  public abstract aj d(g paramg);
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    Iterator localIterator = iDY().iterator();
    while (localIterator.hasNext())
    {
      kotlin.l.b.a.b.b.a.c localc = (kotlin.l.b.a.b.b.a.c)localIterator.next();
      n.a((StringBuilder)localObject, new String[] { "[", kotlin.l.b.a.b.i.c.a(kotlin.l.b.a.b.i.c.abhN, localc), "] " });
    }
    ((StringBuilder)localObject).append(iOU());
    if (!((Collection)iOR()).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        kotlin.a.j.a((Iterable)iOR(), (Appendable)localObject, (CharSequence)", ", (CharSequence)"<", (CharSequence)">", 0, null, null, 112);
      }
      if (iIu()) {
        ((StringBuilder)localObject).append("?");
      }
      localObject = ((StringBuilder)localObject).toString();
      p.j(localObject, "StringBuilder().apply(builderAction).toString()");
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.aj
 * JD-Core Version:    0.7.0.1
 */