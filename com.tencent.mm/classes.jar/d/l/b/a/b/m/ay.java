package d.l.b.a.b.m;

import d.g.b.p;
import d.l.b.a.b.b.a.g;

public abstract class ay
{
  public static final ay NZK = (ay)new b();
  public static final a NZL = new a((byte)0);
  
  public abstract av O(ab paramab);
  
  public ab a(ab paramab, bh parambh)
  {
    p.h(paramab, "topLevelType");
    p.h(parambh, "position");
    return paramab;
  }
  
  public boolean gxD()
  {
    return false;
  }
  
  public final ba gyG()
  {
    ba localba = ba.d(this);
    p.g(localba, "TypeSubstitutor.create(this)");
    return localba;
  }
  
  public boolean gyv()
  {
    return false;
  }
  
  public g h(g paramg)
  {
    p.h(paramg, "annotations");
    return paramg;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.ay
 * JD-Core Version:    0.7.0.1
 */