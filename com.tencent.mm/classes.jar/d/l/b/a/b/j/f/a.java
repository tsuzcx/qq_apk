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
    return fJf().a(paramf, parama);
  }
  
  public Collection<l> a(d paramd, b<? super f, Boolean> paramb)
  {
    k.h(paramd, "kindFilter");
    k.h(paramb, "nameFilter");
    return fJf().a(paramd, paramb);
  }
  
  public Collection<am> b(f paramf, d.l.b.a.b.c.a.a parama)
  {
    k.h(paramf, "name");
    k.h(parama, "location");
    return fJf().b(paramf, parama);
  }
  
  public final d.l.b.a.b.b.h c(f paramf, d.l.b.a.b.c.a.a parama)
  {
    k.h(paramf, "name");
    k.h(parama, "location");
    return fJf().c(paramf, parama);
  }
  
  protected abstract h fJf();
  
  public final Set<f> fzU()
  {
    return fJf().fzU();
  }
  
  public final Set<f> fzV()
  {
    return fJf().fzV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.l.b.a.b.j.f.a
 * JD-Core Version:    0.7.0.1
 */