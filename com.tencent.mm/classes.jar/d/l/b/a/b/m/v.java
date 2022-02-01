package d.l.b.a.b.m;

import d.g.b.k;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.i.c;
import d.l.b.a.b.i.i;
import d.l.b.a.b.j.f.h;
import d.l.b.a.b.m.c.f;
import java.util.List;

public abstract class v
  extends bg
  implements ar, f
{
  public final aj JXH;
  public final aj JXI;
  
  public v(aj paramaj1, aj paramaj2)
  {
    super((byte)0);
    this.JXH = paramaj1;
    this.JXI = paramaj2;
  }
  
  public abstract String a(c paramc, i parami);
  
  public final boolean ad(ab paramab)
  {
    k.h(paramab, "type");
    return false;
  }
  
  public abstract aj fBP();
  
  public boolean fBT()
  {
    return fBP().fBT();
  }
  
  public final List<av> fIT()
  {
    return fBP().fIT();
  }
  
  public final ab fIU()
  {
    return (ab)this.JXH;
  }
  
  public final ab fIV()
  {
    return (ab)this.JXI;
  }
  
  public final at fIW()
  {
    return fBP().fIW();
  }
  
  public g fxF()
  {
    return fBP().fxF();
  }
  
  public h fyj()
  {
    return fBP().fyj();
  }
  
  public String toString()
  {
    return c.JOO.b((ab)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.v
 * JD-Core Version:    0.7.0.1
 */