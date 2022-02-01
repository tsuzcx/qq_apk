package d.l.b.a.b.m;

import d.g.b.p;
import d.l.b.a.b.i.c;
import d.l.b.a.b.i.i;
import d.l.b.a.b.j.f.h;
import java.util.List;

public abstract class v
  extends bg
  implements ar, d.l.b.a.b.m.c.g
{
  public final aj NZc;
  public final aj NZd;
  
  public v(aj paramaj1, aj paramaj2)
  {
    super((byte)0);
    this.NZc = paramaj1;
    this.NZd = paramaj2;
  }
  
  public abstract String a(c paramc, i parami);
  
  public final boolean ad(ab paramab)
  {
    p.h(paramab, "type");
    return false;
  }
  
  public h gmN()
  {
    return gqu().gmN();
  }
  
  public d.l.b.a.b.b.a.g gmj()
  {
    return gqu().gmj();
  }
  
  public abstract aj gqu();
  
  public boolean gqy()
  {
    return gqu().gqy();
  }
  
  public final ab gxA()
  {
    return (ab)this.NZd;
  }
  
  public final at gxB()
  {
    return gqu().gxB();
  }
  
  public final List<av> gxy()
  {
    return gqu().gxy();
  }
  
  public final ab gxz()
  {
    return (ab)this.NZc;
  }
  
  public String toString()
  {
    return c.NQl.b((ab)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.v
 * JD-Core Version:    0.7.0.1
 */