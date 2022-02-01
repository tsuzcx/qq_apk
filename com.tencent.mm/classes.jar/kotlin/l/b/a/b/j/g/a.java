package kotlin.l.b.a.b.j.g;

import java.util.Collection;
import java.util.Set;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;

public abstract class a
  implements h
{
  public Collection<ap> a(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    s.u(paramf, "name");
    s.u(paramb, "location");
    return kzw().a(paramf, paramb);
  }
  
  public Collection<l> a(d paramd, kotlin.g.a.b<? super f, Boolean> paramb)
  {
    s.u(paramd, "kindFilter");
    s.u(paramb, "nameFilter");
    return kzw().a(paramd, paramb);
  }
  
  public Collection<au> b(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    s.u(paramf, "name");
    s.u(paramb, "location");
    return kzw().b(paramf, paramb);
  }
  
  public final kotlin.l.b.a.b.b.h c(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    s.u(paramf, "name");
    s.u(paramb, "location");
    return kzw().c(paramf, paramb);
  }
  
  public final void d(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    s.u(paramf, "name");
    s.u(paramb, "location");
    kzw().d(paramf, paramb);
  }
  
  public final Set<f> kpL()
  {
    return kzw().kpL();
  }
  
  public final Set<f> kpM()
  {
    return kzw().kpM();
  }
  
  public final Set<f> kpN()
  {
    return kzw().kpN();
  }
  
  protected abstract h kzw();
  
  public final h kzx()
  {
    for (a locala = this; (locala.kzw() instanceof a); locala = (a)locala.kzw()) {}
    return locala.kzw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.g.a
 * JD-Core Version:    0.7.0.1
 */