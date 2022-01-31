package org.c.d;

import java.io.Serializable;
import org.c.g.d;

public final class i
  implements Serializable
{
  public final String token;
  public final String tsv;
  private final String xuK;
  
  public i(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null);
  }
  
  public i(String paramString1, String paramString2, String paramString3)
  {
    d.l(paramString1, "Token can't be null");
    d.l(paramString2, "Secret can't be null");
    this.token = paramString1;
    this.tsv = paramString2;
    this.xuK = paramString3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (i)paramObject;
    } while ((this.token.equals(paramObject.token)) && (this.tsv.equals(paramObject.tsv)));
    return false;
  }
  
  public final int hashCode()
  {
    return this.token.hashCode() * 31 + this.tsv.hashCode();
  }
  
  public final String toString()
  {
    return String.format("Token[%s , %s]", new Object[] { this.token, this.tsv });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     org.c.d.i
 * JD-Core Version:    0.7.0.1
 */