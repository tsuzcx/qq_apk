package d.l.b.a.b.m;

import d.g.b.p;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.m.c.l;
import d.n.n;
import java.util.Collection;
import java.util.Iterator;

public abstract class aj
  extends bg
  implements d.l.b.a.b.m.c.j, l
{
  public aj()
  {
    super((byte)0);
  }
  
  public abstract aj Ap(boolean paramBoolean);
  
  public abstract aj d(g paramg);
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    Iterator localIterator = gmj().iterator();
    while (localIterator.hasNext())
    {
      d.l.b.a.b.b.a.c localc = (d.l.b.a.b.b.a.c)localIterator.next();
      n.a((StringBuilder)localObject, new String[] { "[", d.l.b.a.b.i.c.a(d.l.b.a.b.i.c.NQl, localc), "] " });
    }
    ((StringBuilder)localObject).append(gxB());
    if (!((Collection)gxy()).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        d.a.j.a((Iterable)gxy(), (Appendable)localObject, (CharSequence)", ", (CharSequence)"<", (CharSequence)">", 0, null, null, 112);
      }
      if (gqy()) {
        ((StringBuilder)localObject).append("?");
      }
      localObject = ((StringBuilder)localObject).toString();
      p.g(localObject, "StringBuilder().apply(builderAction).toString()");
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.aj
 * JD-Core Version:    0.7.0.1
 */