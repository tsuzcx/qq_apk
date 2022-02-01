package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
{
  private int KVM;
  private transient a[] Uft;
  private final float Ufu;
  private transient int count;
  
  public d()
  {
    this((byte)0);
  }
  
  private d(byte paramByte)
  {
    AppMethodBeat.i(40732);
    this.Ufu = 0.75F;
    this.Uft = new a[20];
    this.KVM = 15;
    AppMethodBeat.o(40732);
  }
  
  public final Object e(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(40733);
    Object localObject2 = this.Uft;
    int i = (paramInt & 0x7FFFFFFF) % localObject2.length;
    for (Object localObject1 = localObject2[i]; localObject1 != null; localObject1 = ((a)localObject1).Ufv) {
      if (((a)localObject1).bNi == paramInt)
      {
        localObject2 = ((a)localObject1).value;
        ((a)localObject1).value = paramObject;
        AppMethodBeat.o(40733);
        return localObject2;
      }
    }
    localObject1 = localObject2;
    if (this.count >= this.KVM)
    {
      i = this.Uft.length;
      a[] arrayOfa1 = this.Uft;
      int k = i * 2 + 1;
      a[] arrayOfa2 = new a[k];
      this.KVM = ((int)(k * this.Ufu));
      this.Uft = arrayOfa2;
      for (;;)
      {
        int j = i - 1;
        if (i <= 0) {
          break;
        }
        for (localObject1 = arrayOfa1[j]; localObject1 != null; localObject1 = localObject2)
        {
          localObject2 = ((a)localObject1).Ufv;
          i = (((a)localObject1).bNi & 0x7FFFFFFF) % k;
          ((a)localObject1).Ufv = arrayOfa2[i];
          arrayOfa2[i] = localObject1;
        }
        i = j;
      }
      localObject1 = this.Uft;
      i = (paramInt & 0x7FFFFFFF) % localObject1.length;
    }
    localObject1[i] = new a(paramInt, paramInt, paramObject, localObject1[i]);
    this.count += 1;
    AppMethodBeat.o(40733);
    return null;
  }
  
  static final class a
  {
    a Ufv;
    final int bNi;
    final int key;
    Object value;
    
    protected a(int paramInt1, int paramInt2, Object paramObject, a parama)
    {
      this.bNi = paramInt1;
      this.key = paramInt2;
      this.value = paramObject;
      this.Ufv = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.apache.commons.b.d
 * JD-Core Version:    0.7.0.1
 */