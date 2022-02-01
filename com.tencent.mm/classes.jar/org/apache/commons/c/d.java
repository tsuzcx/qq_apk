package org.apache.commons.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
{
  private int Jfu;
  private transient a[] ajVC;
  private final float ajVD;
  private transient int count;
  
  public d()
  {
    this((byte)0);
  }
  
  private d(byte paramByte)
  {
    AppMethodBeat.i(40732);
    this.ajVD = 0.75F;
    this.ajVC = new a[20];
    this.Jfu = 15;
    AppMethodBeat.o(40732);
  }
  
  public final Object z(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(40733);
    Object localObject2 = this.ajVC;
    int i = (paramInt & 0x7FFFFFFF) % localObject2.length;
    for (Object localObject1 = localObject2[i]; localObject1 != null; localObject1 = ((a)localObject1).ajVE) {
      if (((a)localObject1).dIL == paramInt)
      {
        localObject2 = ((a)localObject1).value;
        ((a)localObject1).value = paramObject;
        AppMethodBeat.o(40733);
        return localObject2;
      }
    }
    localObject1 = localObject2;
    if (this.count >= this.Jfu)
    {
      i = this.ajVC.length;
      a[] arrayOfa1 = this.ajVC;
      int k = i * 2 + 1;
      a[] arrayOfa2 = new a[k];
      this.Jfu = ((int)(k * this.ajVD));
      this.ajVC = arrayOfa2;
      for (;;)
      {
        int j = i - 1;
        if (i <= 0) {
          break;
        }
        for (localObject1 = arrayOfa1[j]; localObject1 != null; localObject1 = localObject2)
        {
          localObject2 = ((a)localObject1).ajVE;
          i = (((a)localObject1).dIL & 0x7FFFFFFF) % k;
          ((a)localObject1).ajVE = arrayOfa2[i];
          arrayOfa2[i] = localObject1;
        }
        i = j;
      }
      localObject1 = this.ajVC;
      i = (paramInt & 0x7FFFFFFF) % localObject1.length;
    }
    localObject1[i] = new a(paramInt, paramInt, paramObject, localObject1[i]);
    this.count += 1;
    AppMethodBeat.o(40733);
    return null;
  }
  
  static final class a
  {
    a ajVE;
    final int dIL;
    final int key;
    Object value;
    
    protected a(int paramInt1, int paramInt2, Object paramObject, a parama)
    {
      this.dIL = paramInt1;
      this.key = paramInt2;
      this.value = paramObject;
      this.ajVE = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.apache.commons.c.d
 * JD-Core Version:    0.7.0.1
 */