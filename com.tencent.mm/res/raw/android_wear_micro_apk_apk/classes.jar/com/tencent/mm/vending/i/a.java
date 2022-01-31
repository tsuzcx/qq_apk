package com.tencent.mm.vending.i;

public class a
{
  private Object[] aap;
  
  public static <$1> b<$1> Q($1 param$1)
  {
    b localb = new b();
    localb.aap = new Object[] { param$1 };
    return (b)localb;
  }
  
  public final <T> T lK()
  {
    if (this.aap.length <= 0) {
      return null;
    }
    return this.aap[0];
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 1;
    Object[] arrayOfObject = this.aap;
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
 * Qualified Name:     com.tencent.mm.vending.i.a
 * JD-Core Version:    0.7.0.1
 */