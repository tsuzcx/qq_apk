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
    return gth().a(paramf, parama);
  }
  
  public Collection<l> a(d paramd, b<? super f, Boolean> paramb)
  {
    p.h(paramd, "kindFilter");
    p.h(paramb, "nameFilter");
    return gth().a(paramd, paramb);
  }
  
  public Collection<am> b(f paramf, d.l.b.a.b.c.a.a parama)
  {
    p.h(paramf, "name");
    p.h(parama, "location");
    return gth().b(paramf, parama);
  }
  
  public final d.l.b.a.b.b.h c(f paramf, d.l.b.a.b.c.a.a parama)
  {
    p.h(paramf, "name");
    p.h(parama, "location");
    return gth().c(paramf, parama);
  }
  
  public final Set<f> gjW()
  {
    return gth().gjW();
  }
  
  public final Set<f> gjX()
  {
    return gth().gjX();
  }
  
  protected abstract h gth();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.f.a
 * JD-Core Version:    0.7.0.1
 */