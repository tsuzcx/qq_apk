package kotlin.l.b.a.b.m;

import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;

public abstract class ay
{
  public static final ay TOD = (ay)new b();
  public static final a TOE = new a((byte)0);
  
  public abstract av N(ab paramab);
  
  public ab a(ab paramab, bh parambh)
  {
    p.h(paramab, "topLevelType");
    p.h(parambh, "position");
    return paramab;
  }
  
  public g h(g paramg)
  {
    p.h(paramg, "annotations");
    return paramg;
  }
  
  public boolean hKG()
  {
    return false;
  }
  
  public final ba hLJ()
  {
    ba localba = ba.d(this);
    p.g(localba, "TypeSubstitutor.create(this)");
    return localba;
  }
  
  public boolean hLy()
  {
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.ay
 * JD-Core Version:    0.7.0.1
 */