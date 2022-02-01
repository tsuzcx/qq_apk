package kotlin.l.b.a.b.m;

import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;

public abstract class ay
{
  public static final ay abrd = (ay)new b();
  public static final a abre = new a((byte)0);
  
  public abstract av N(ab paramab);
  
  public ab a(ab paramab, bh parambh)
  {
    p.k(paramab, "topLevelType");
    p.k(parambh, "position");
    return paramab;
  }
  
  public g h(g paramg)
  {
    p.k(paramg, "annotations");
    return paramg;
  }
  
  public boolean iOW()
  {
    return false;
  }
  
  public boolean iPR()
  {
    return false;
  }
  
  public final ba iQb()
  {
    ba localba = ba.d(this);
    p.j(localba, "TypeSubstitutor.create(this)");
    return localba;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public static final class a {}
  
  public static final class b
    extends ay
  {
    public final boolean isEmpty()
    {
      return true;
    }
    
    public final String toString()
    {
      return "Empty TypeSubstitution";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.ay
 * JD-Core Version:    0.7.0.1
 */