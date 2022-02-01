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
    p.h(paramf, "name");
    p.h(parama, "location");
    return hKM().a(paramf, parama);
  }
  
  public Collection<l> a(d paramd, b<? super f, Boolean> paramb)
  {
    p.h(paramd, "kindFilter");
    p.h(paramb, "nameFilter");
    return hKM().a(paramd, paramb);
  }
  
  public Collection<am> b(f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    p.h(paramf, "name");
    p.h(parama, "location");
    return hKM().b(paramf, parama);
  }
  
  public final kotlin.l.b.a.b.b.h c(f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    p.h(paramf, "name");
    p.h(parama, "location");
    return hKM().c(paramf, parama);
  }
  
  public final Set<f> hCa()
  {
    return hKM().hCa();
  }
  
  public final Set<f> hCb()
  {
    return hKM().hCb();
  }
  
  protected abstract h hKM();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.f.a
 * JD-Core Version:    0.7.0.1
 */