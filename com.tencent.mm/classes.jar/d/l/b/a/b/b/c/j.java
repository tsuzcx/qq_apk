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
  private final f JsQ;
  
  public j(g paramg, f paramf)
  {
    super(paramg);
    this.JsQ = paramf;
  }
  
  public static String i(l paraml)
  {
    try
    {
      String str1 = c.JOO.k(paraml) + "[" + paraml.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(paraml)) + "]";
      paraml = str1;
      if (str1 == null)
      {
        adP(5);
        paraml = str1;
      }
    }
    catch (Throwable localThrowable)
    {
      String str2;
      do
      {
        str2 = paraml.getClass().getSimpleName() + " " + paraml.fyB();
        paraml = str2;
      } while (str2 != null);
      adP(6);
      return str2;
    }
    return paraml;
  }
  
  public final f fyB()
  {
    f localf = this.JsQ;
    if (localf == null) {
      adP(2);
    }
    return localf;
  }
  
  public l fyy()
  {
    if (this == null) {
      adP(3);
    }
    return this;
  }
  
  public String toString()
  {
    return i(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.j
 * JD-Core Version:    0.7.0.1
 */