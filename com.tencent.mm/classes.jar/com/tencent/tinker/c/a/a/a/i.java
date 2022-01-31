package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.o;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.a.a.t.a.a;
import com.tencent.tinker.c.a.c.c;
import java.util.Arrays;

public abstract class i<T extends Comparable<T>>
{
  protected final com.tencent.tinker.a.a.i wTR;
  protected final com.tencent.tinker.c.a.b.a wTT;
  private final c wTU;
  
  public i(com.tencent.tinker.c.a.b.a parama, com.tencent.tinker.a.a.i parami, c paramc)
  {
    this.wTT = parama;
    this.wTR = parami;
    this.wTU = paramc;
  }
  
  private int[] JU(int paramInt)
  {
    int[] arrayOfInt = new int[paramInt];
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      j = o.a(this.wTT.wUQ) + j;
      arrayOfInt[i] = j;
      i += 1;
    }
    return arrayOfInt;
  }
  
  private static int a(int paramInt, T paramT)
  {
    if ((paramT instanceof t.a.a)) {
      paramInt = ((t.a.a)paramT).off;
    }
    return paramInt;
  }
  
  protected abstract T a(com.tencent.tinker.a.a.a.a parama);
  
  protected T a(com.tencent.tinker.c.a.c.a parama, T paramT)
  {
    return paramT;
  }
  
  protected void a(c paramc, int paramInt1, int paramInt2) {}
  
  protected void a(c paramc, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected abstract t.a c(com.tencent.tinker.a.a.i parami);
  
  protected abstract int e(T paramT);
  
  public final void execute()
  {
    int[] arrayOfInt1 = JU(o.b(this.wTT.wUQ));
    int[] arrayOfInt2 = JU(o.b(this.wTT.wUQ));
    int[] arrayOfInt3 = JU(o.b(this.wTT.wUQ));
    Object localObject = c(this.wTR);
    i.e locale;
    int k;
    if (((t.a)localObject).exists())
    {
      locale = this.wTR.a((t.a)localObject);
      k = ((t.a)localObject).size;
    }
    for (;;)
    {
      int i2 = arrayOfInt1.length;
      int i3 = arrayOfInt2.length;
      int i4 = arrayOfInt3.length;
      int j = 0;
      int i = 0;
      int i1 = 0;
      int n = 0;
      int m = 0;
      while ((j < k) || (i < k + i3 - i2)) {
        if ((n < i3) && (arrayOfInt2[n] == i))
        {
          e(a(this.wTT.wUQ));
          i += 1;
          n += 1;
        }
        else if ((i1 < i4) && (arrayOfInt3[i1] == i))
        {
          e(a(this.wTT.wUQ));
          i += 1;
          i1 += 1;
        }
        else if (Arrays.binarySearch(arrayOfInt1, j) >= 0)
        {
          localObject = a(locale);
          a(this.wTU, j, a(j, (Comparable)localObject));
          j += 1;
          m += 1;
        }
        else if (Arrays.binarySearch(arrayOfInt3, j) >= 0)
        {
          localObject = a(locale);
          a(this.wTU, j, a(j, (Comparable)localObject));
          j += 1;
        }
        else if (j < k)
        {
          localObject = a(this.wTU, a(locale));
          int i5 = e((Comparable)localObject);
          a(this.wTU, j, a(j, (Comparable)localObject), i, i5);
          j += 1;
          i += 1;
        }
      }
      if ((n != i3) || (m != i2) || (i1 != i4)) {
        throw new IllegalStateException(String.format("bad patch operation sequence. addCounter: %d, addCount: %d, delCounter: %d, delCount: %d, replaceCounter: %d, replaceCount:%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i3), Integer.valueOf(m), Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(i4) }));
      }
      return;
      k = 0;
      locale = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.c.a.a.a.i
 * JD-Core Version:    0.7.0.1
 */