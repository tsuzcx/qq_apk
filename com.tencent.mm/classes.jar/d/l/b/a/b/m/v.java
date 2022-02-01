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
  public final aj NBV;
  public final aj NBW;
  
  public v(aj paramaj1, aj paramaj2)
  {
    super((byte)0);
    this.NBV = paramaj1;
    this.NBW = paramaj2;
  }
  
  public abstract String a(c paramc, i parami);
  
  public final boolean ad(ab paramab)
  {
    p.h(paramab, "type");
    return false;
  }
  
  public d.l.b.a.b.b.a.g ghH()
  {
    return glS().ghH();
  }
  
  public h gil()
  {
    return glS().gil();
  }
  
  public abstract aj glS();
  
  public boolean glW()
  {
    return glS().glW();
  }
  
  public final List<av> gsW()
  {
    return glS().gsW();
  }
  
  public final ab gsX()
  {
    return (ab)this.NBV;
  }
  
  public final ab gsY()
  {
    return (ab)this.NBW;
  }
  
  public final at gsZ()
  {
    return glS().gsZ();
  }
  
  public String toString()
  {
    return c.Ntf.b((ab)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.v
 * JD-Core Version:    0.7.0.1
 */