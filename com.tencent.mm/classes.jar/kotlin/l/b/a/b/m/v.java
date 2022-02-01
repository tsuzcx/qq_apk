package kotlin.l.b.a.b.m;

import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.i.c;
import kotlin.l.b.a.b.i.i;
import kotlin.l.b.a.b.j.f.h;

public abstract class v
  extends bg
  implements ar, kotlin.l.b.a.b.m.c.g
{
  public final aj TNV;
  public final aj TNW;
  
  public v(aj paramaj1, aj paramaj2)
  {
    super((byte)0);
    this.TNV = paramaj1;
    this.TNW = paramaj2;
  }
  
  public abstract String a(c paramc, i parami);
  
  public final boolean ac(ab paramab)
  {
    p.h(paramab, "type");
    return false;
  }
  
  public h hAp()
  {
    return hDW().hAp();
  }
  
  public abstract aj hDW();
  
  public boolean hEa()
  {
    return hDW().hEa();
  }
  
  public final List<av> hKB()
  {
    return hDW().hKB();
  }
  
  public final ab hKC()
  {
    return (ab)this.TNV;
  }
  
  public final ab hKD()
  {
    return (ab)this.TNW;
  }
  
  public final at hKE()
  {
    return hDW().hKE();
  }
  
  public kotlin.l.b.a.b.b.a.g hzL()
  {
    return hDW().hzL();
  }
  
  public String toString()
  {
    return c.TFj.b((ab)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.v
 * JD-Core Version:    0.7.0.1
 */