package d.l.b.a.b.m;

import d.a.j;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.m.c.i;
import d.n.n;
import java.util.Collection;
import java.util.Iterator;

public abstract class aj
  extends bg
  implements i, d.l.b.a.b.m.c.k
{
  public aj()
  {
    super((byte)0);
  }
  
  public abstract aj d(g paramg);
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    Iterator localIterator = fQj().iterator();
    while (localIterator.hasNext())
    {
      d.l.b.a.b.b.a.c localc = (d.l.b.a.b.b.a.c)localIterator.next();
      n.a((StringBuilder)localObject, new String[] { "[", d.l.b.a.b.i.c.a(d.l.b.a.b.i.c.LCi, localc), "] " });
    }
    ((StringBuilder)localObject).append(gbz());
    if (!((Collection)gbw()).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        j.a((Iterable)gbw(), (Appendable)localObject, (CharSequence)", ", (CharSequence)"<", (CharSequence)">", 0, null, null, 112);
      }
      if (fUx()) {
        ((StringBuilder)localObject).append("?");
      }
      localObject = ((StringBuilder)localObject).toString();
      d.g.b.k.g(localObject, "StringBuilder().apply(builderAction).toString()");
      return localObject;
    }
  }
  
  public abstract aj zo(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.aj
 * JD-Core Version:    0.7.0.1
 */