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
  private final f MXf;
  
  public j(g paramg, f paramf)
  {
    super(paramg);
    this.MXf = paramf;
  }
  
  public static String i(l paraml)
  {
    try
    {
      String str1 = c.Ntf.k(paraml) + "[" + paraml.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(paraml)) + "]";
      paraml = str1;
      if (str1 == null)
      {
        ajm(5);
        paraml = str1;
      }
    }
    catch (Throwable localThrowable)
    {
      String str2;
      do
      {
        str2 = paraml.getClass().getSimpleName() + " " + paraml.giD();
        paraml = str2;
      } while (str2 != null);
      ajm(6);
      return str2;
    }
    return paraml;
  }
  
  public l giA()
  {
    if (this == null) {
      ajm(3);
    }
    return this;
  }
  
  public final f giD()
  {
    f localf = this.MXf;
    if (localf == null) {
      ajm(2);
    }
    return localf;
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