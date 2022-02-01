package kotlin.l.b.a.b.b.c;

import kotlin.l.b.a.b.b.a.b;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.i.c;

public abstract class j
  extends b
  implements l
{
  private final f TjT;
  
  public j(g paramg, f paramf)
  {
    super(paramg);
    this.TjT = paramf;
  }
  
  public static String i(l paraml)
  {
    try
    {
      String str1 = c.TFj.k(paraml) + "[" + paraml.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(paraml)) + "]";
      paraml = str1;
      if (str1 == null)
      {
        atM(5);
        paraml = str1;
      }
    }
    catch (Throwable localThrowable)
    {
      String str2;
      do
      {
        str2 = paraml.getClass().getSimpleName() + " " + paraml.hAH();
        paraml = str2;
      } while (str2 != null);
      atM(6);
      return str2;
    }
    return paraml;
  }
  
  public l hAE()
  {
    if (this == null) {
      atM(3);
    }
    return this;
  }
  
  public final f hAH()
  {
    f localf = this.TjT;
    if (localf == null) {
      atM(2);
    }
    return localf;
  }
  
  public String toString()
  {
    return i(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.j
 * JD-Core Version:    0.7.0.1
 */