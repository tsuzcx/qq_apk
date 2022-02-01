package com.tencent.mm.vending.j;

public class a
{
  private Object[] adQ;
  
  public static <$1> b<$1> Z($1 param$1)
  {
    b localb = new b();
    localb.adQ = new Object[] { param$1 };
    return (b)localb;
  }
  
  public final <T> T mx()
  {
    if (this.adQ.length <= 0) {
      return null;
    }
    return this.adQ[0];
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 1;
    Object[] arrayOfObject = this.adQ;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.j.a
 * JD-Core Version:    0.7.0.1
 */