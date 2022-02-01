package d.l.b.a.b.j.f;

import d.g.a.b;
import d.g.b.p;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.l;
import d.l.b.a.b.f.f;
import java.util.Collection;
import java.util.Set;

public abstract class a
  implements h
{
  public Collection<ah> a(f paramf, d.l.b.a.b.c.a.a parama)
  {
    p.h(paramf, "name");
    p.h(parama, "location");
    return gxJ().a(paramf, parama);
  }
  
  public Collection<l> a(d paramd, b<? super f, Boolean> paramb)
  {
    p.h(paramd, "kindFilter");
    p.h(paramb, "nameFilter");
    return gxJ().a(paramd, paramb);
  }
  
  public Collection<am> b(f paramf, d.l.b.a.b.c.a.a parama)
  {
    p.h(paramf, "name");
    p.h(parama, "location");
    return gxJ().b(paramf, parama);
  }
  
  public final d.l.b.a.b.b.h c(f paramf, d.l.b.a.b.c.a.a parama)
  {
    p.h(paramf, "name");
    p.h(parama, "location");
    return gxJ().c(paramf, parama);
  }
  
  public final Set<f> goy()
  {
    return gxJ().goy();
  }
  
  public final Set<f> goz()
  {
    return gxJ().goz();
  }
  
  protected abstract h gxJ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.f.a
 * JD-Core Version:    0.7.0.1
 */