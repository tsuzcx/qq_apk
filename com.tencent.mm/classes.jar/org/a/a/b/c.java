package org.a.a.b;

final class c
{
  private transient int count;
  private int uRY = 15;
  private transient c.a[] xsJ = new c.a[20];
  private final float xsK = 0.75F;
  
  public c()
  {
    this((byte)0);
  }
  
  private c(byte paramByte) {}
  
  public final Object n(int paramInt, Object paramObject)
  {
    Object localObject2 = this.xsJ;
    int i = (paramInt & 0x7FFFFFFF) % localObject2.length;
    for (Object localObject1 = localObject2[i]; localObject1 != null; localObject1 = ((c.a)localObject1).xsL) {
      if (((c.a)localObject1).ndO == paramInt)
      {
        localObject2 = ((c.a)localObject1).value;
        ((c.a)localObject1).value = paramObject;
        return localObject2;
      }
    }
    localObject1 = localObject2;
    if (this.count >= this.uRY)
    {
      i = this.xsJ.length;
      c.a[] arrayOfa1 = this.xsJ;
      int k = i * 2 + 1;
      c.a[] arrayOfa2 = new c.a[k];
      this.uRY = ((int)(k * this.xsK));
      this.xsJ = arrayOfa2;
      for (;;)
      {
        int j = i - 1;
        if (i <= 0) {
          break;
        }
        for (localObject1 = arrayOfa1[j]; localObject1 != null; localObject1 = localObject2)
        {
          localObject2 = ((c.a)localObject1).xsL;
          i = (((c.a)localObject1).ndO & 0x7FFFFFFF) % k;
          ((c.a)localObject1).xsL = arrayOfa2[i];
          arrayOfa2[i] = localObject1;
        }
        i = j;
      }
      localObject1 = this.xsJ;
      i = (paramInt & 0x7FFFFFFF) % localObject1.length;
    }
    localObject1[i] = new c.a(paramInt, paramInt, paramObject, localObject1[i]);
    this.count += 1;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.a.a.b.c
 * JD-Core Version:    0.7.0.1
 */