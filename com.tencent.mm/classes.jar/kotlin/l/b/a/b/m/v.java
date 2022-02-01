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
  public final aj abqv;
  public final aj abqw;
  
  public v(aj paramaj1, aj paramaj2)
  {
    super((byte)0);
    this.abqv = paramaj1;
    this.abqw = paramaj2;
  }
  
  public abstract String a(c paramc, i parami);
  
  public final boolean ac(ab paramab)
  {
    p.k(paramab, "type");
    return false;
  }
  
  public kotlin.l.b.a.b.b.a.g iDY()
  {
    return iIq().iDY();
  }
  
  public h iEC()
  {
    return iIq().iEC();
  }
  
  public abstract aj iIq();
  
  public boolean iIu()
  {
    return iIq().iIu();
  }
  
  public final List<av> iOR()
  {
    return iIq().iOR();
  }
  
  public final ab iOS()
  {
    return (ab)this.abqv;
  }
  
  public final ab iOT()
  {
    return (ab)this.abqw;
  }
  
  public final at iOU()
  {
    return iIq().iOU();
  }
  
  public String toString()
  {
    return c.abhN.b((ab)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.v
 * JD-Core Version:    0.7.0.1
 */