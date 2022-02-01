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
  private final f aiJy;
  
  public j(g paramg, f paramf)
  {
    super(paramg);
    this.aiJy = paramf;
  }
  
  public static String i(l paraml)
  {
    try
    {
      String str1 = c.ajgB.k(paraml) + "[" + paraml.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(paraml)) + "]";
      paraml = str1;
      if (str1 == null)
      {
        aKu(5);
        paraml = str1;
      }
    }
    finally
    {
      String str2;
      do
      {
        str2 = paraml.getClass().getSimpleName() + " " + paraml.kok();
        paraml = str2;
      } while (str2 != null);
      aKu(6);
      return str2;
    }
    return paraml;
  }
  
  public final f kok()
  {
    f localf = this.aiJy;
    if (localf == null) {
      aKu(2);
    }
    return localf;
  }
  
  public l kor()
  {
    if (this == null) {
      aKu(3);
    }
    return this;
  }
  
  public String toString()
  {
    return i(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.j
 * JD-Core Version:    0.7.0.1
 */