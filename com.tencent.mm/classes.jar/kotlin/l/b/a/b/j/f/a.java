package kotlin.l.b.a.b.j.f;

import java.util.Collection;
import java.util.Set;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;

public abstract class a
  implements h
{
  public Collection<ah> a(f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    p.k(paramf, "name");
    p.k(parama, "location");
    return iPc().a(paramf, parama);
  }
  
  public Collection<l> a(d paramd, b<? super f, Boolean> paramb)
  {
    p.k(paramd, "kindFilter");
    p.k(paramb, "nameFilter");
    return iPc().a(paramd, paramb);
  }
  
  public Collection<am> b(f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    p.k(paramf, "name");
    p.k(parama, "location");
    return iPc().b(paramf, parama);
  }
  
  public final kotlin.l.b.a.b.b.h c(f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    p.k(paramf, "name");
    p.k(parama, "location");
    return iPc().c(paramf, parama);
  }
  
  public final Set<f> iGp()
  {
    return iPc().iGp();
  }
  
  public final Set<f> iGq()
  {
    return iPc().iGq();
  }
  
  protected abstract h iPc();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.f.a
 * JD-Core Version:    0.7.0.1
 */