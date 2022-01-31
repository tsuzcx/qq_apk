package com.tencent.mm.vending.j;

public class a
{
  public Object[] a;
  
  public static <$1> b<$1> ck($1 param$1)
  {
    b localb = new b();
    localb.a = new Object[] { param$1 };
    return (b)localb;
  }
  
  public static <$1, $2, $3> d<$1, $2, $3> d($1 param$1, $2 param$2, $3 param$3)
  {
    d locald = new d();
    locald.a = new Object[] { param$1, param$2, param$3 };
    return (d)locald;
  }
  
  public static <$1, $2> c<$1, $2> r($1 param$1, $2 param$2)
  {
    c localc = new c();
    localc.a = new Object[] { param$1, param$2 };
    return (c)localc;
  }
  
  public final <T> T get(int paramInt)
  {
    if (this.a.length <= paramInt) {
      return null;
    }
    return this.a[paramInt];
  }
  
  public final int size()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.length;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 1;
    Object[] arrayOfObject = this.a;
    int k = arrayOfObject.length;
    int i = 0;
    if (i < k)
    {
      Object localObject = arrayOfObject[i];
      if (j != 0) {
        j = 0;
      }
      for (;;)
      {
        localStringBuilder.append(localObject);
        i += 1;
        break;
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.j.a
 * JD-Core Version:    0.7.0.1
 */