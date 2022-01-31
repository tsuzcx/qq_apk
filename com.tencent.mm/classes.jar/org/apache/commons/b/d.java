package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
{
  private transient d.a[] CPq;
  private final float CPr;
  private transient int count;
  private int zgz;
  
  public d()
  {
    this((byte)0);
  }
  
  private d(byte paramByte)
  {
    AppMethodBeat.i(116954);
    this.CPr = 0.75F;
    this.CPq = new d.a[20];
    this.zgz = 15;
    AppMethodBeat.o(116954);
  }
  
  public final Object w(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(116955);
    Object localObject2 = this.CPq;
    int i = (paramInt & 0x7FFFFFFF) % localObject2.length;
    for (Object localObject1 = localObject2[i]; localObject1 != null; localObject1 = ((d.a)localObject1).CPs) {
      if (((d.a)localObject1).pJe == paramInt)
      {
        localObject2 = ((d.a)localObject1).value;
        ((d.a)localObject1).value = paramObject;
        AppMethodBeat.o(116955);
        return localObject2;
      }
    }
    localObject1 = localObject2;
    if (this.count >= this.zgz)
    {
      i = this.CPq.length;
      d.a[] arrayOfa1 = this.CPq;
      int k = i * 2 + 1;
      d.a[] arrayOfa2 = new d.a[k];
      this.zgz = ((int)(k * this.CPr));
      this.CPq = arrayOfa2;
      for (;;)
      {
        int j = i - 1;
        if (i <= 0) {
          break;
        }
        for (localObject1 = arrayOfa1[j]; localObject1 != null; localObject1 = localObject2)
        {
          localObject2 = ((d.a)localObject1).CPs;
          i = (((d.a)localObject1).pJe & 0x7FFFFFFF) % k;
          ((d.a)localObject1).CPs = arrayOfa2[i];
          arrayOfa2[i] = localObject1;
        }
        i = j;
      }
      localObject1 = this.CPq;
      i = (paramInt & 0x7FFFFFFF) % localObject1.length;
    }
    localObject1[i] = new d.a(paramInt, paramInt, paramObject, localObject1[i]);
    this.count += 1;
    AppMethodBeat.o(116955);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     org.apache.commons.b.d
 * JD-Core Version:    0.7.0.1
 */