package d.l.b.a.b.b.c;

import d.l.b.a.b.b.a.b;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.l;
import d.l.b.a.b.f.f;
import d.l.b.a.b.i.c;

public abstract class j
  extends b
  implements l
{
  private final f Lgj;
  
  public j(g paramg, f paramf)
  {
    super(paramg);
    this.Lgj = paramf;
  }
  
  public static String i(l paraml)
  {
    try
    {
      String str1 = c.LCi.k(paraml) + "[" + paraml.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(paraml)) + "]";
      paraml = str1;
      if (str1 == null)
      {
        agL(5);
        paraml = str1;
      }
    }
    catch (Throwable localThrowable)
    {
      String str2;
      do
      {
        str2 = paraml.getClass().getSimpleName() + " " + paraml.fRf();
        paraml = str2;
      } while (str2 != null);
      agL(6);
      return str2;
    }
    return paraml;
  }
  
  public l fRc()
  {
    if (this == null) {
      agL(3);
    }
    return this;
  }
  
  public final f fRf()
  {
    f localf = this.Lgj;
    if (localf == null) {
      agL(2);
    }
    return localf;
  }
  
  public String toString()
  {
    return i(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.j
 * JD-Core Version:    0.7.0.1
 */