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
  public final aj LLa;
  public final aj LLb;
  
  public v(aj paramaj1, aj paramaj2)
  {
    super((byte)0);
    this.LLa = paramaj1;
    this.LLb = paramaj2;
  }
  
  public abstract String a(c paramc, i parami);
  
  public final boolean ad(ab paramab)
  {
    k.h(paramab, "type");
    return false;
  }
  
  public h fQN()
  {
    return fUt().fQN();
  }
  
  public g fQj()
  {
    return fUt().fQj();
  }
  
  public abstract aj fUt();
  
  public boolean fUx()
  {
    return fUt().fUx();
  }
  
  public final List<av> gbw()
  {
    return fUt().gbw();
  }
  
  public final ab gbx()
  {
    return (ab)this.LLa;
  }
  
  public final ab gby()
  {
    return (ab)this.LLb;
  }
  
  public final at gbz()
  {
    return fUt().gbz();
  }
  
  public String toString()
  {
    return c.LCi.b((ab)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.v
 * JD-Core Version:    0.7.0.1
 */