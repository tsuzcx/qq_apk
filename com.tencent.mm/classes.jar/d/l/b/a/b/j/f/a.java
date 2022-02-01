package d.l.b.a.b.j.f;

import d.g.a.b;
import d.g.b.k;
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
    k.h(paramf, "name");
    k.h(parama, "location");
    return gbI().a(paramf, parama);
  }
  
  public Collection<l> a(d paramd, b<? super f, Boolean> paramb)
  {
    k.h(paramd, "kindFilter");
    k.h(paramb, "nameFilter");
    return gbI().a(paramd, paramb);
  }
  
  public Collection<am> b(f paramf, d.l.b.a.b.c.a.a parama)
  {
    k.h(paramf, "name");
    k.h(parama, "location");
    return gbI().b(paramf, parama);
  }
  
  public final d.l.b.a.b.b.h c(f paramf, d.l.b.a.b.c.a.a parama)
  {
    k.h(paramf, "name");
    k.h(parama, "location");
    return gbI().c(paramf, parama);
  }
  
  public final Set<f> fSy()
  {
    return gbI().fSy();
  }
  
  public final Set<f> fSz()
  {
    return gbI().fSz();
  }
  
  protected abstract h gbI();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.f.a
 * JD-Core Version:    0.7.0.1
 */