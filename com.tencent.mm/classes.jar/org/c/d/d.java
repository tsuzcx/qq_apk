package org.c.d;

public final class d
  implements Comparable<d>
{
  final String key;
  final String value;
  
  public d(String paramString1, String paramString2)
  {
    this.key = paramString1;
    this.value = paramString2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if (paramObject == this) {
          return true;
        }
      } while (!(paramObject instanceof d));
      paramObject = (d)paramObject;
    } while ((!paramObject.key.equals(this.key)) || (!paramObject.value.equals(this.value)));
    return true;
  }
  
  public final int hashCode()
  {
    return this.key.hashCode() + this.value.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.c.d.d
 * JD-Core Version:    0.7.0.1
 */