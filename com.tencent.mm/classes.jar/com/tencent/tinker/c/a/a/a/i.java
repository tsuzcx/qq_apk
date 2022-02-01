package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.o;
import com.tencent.tinker.a.a.s.a;
import com.tencent.tinker.a.a.s.a.a;
import com.tencent.tinker.c.a.c.c;
import java.util.Arrays;

public abstract class i<T extends Comparable<T>>
{
  protected final com.tencent.tinker.a.a.i ahPj;
  protected final com.tencent.tinker.c.a.b.a ahPl;
  private final c ahPm;
  
  public i(com.tencent.tinker.c.a.b.a parama, com.tencent.tinker.a.a.i parami, c paramc)
  {
    this.ahPl = parama;
    this.ahPj = parami;
    this.ahPm = paramc;
  }
  
  private static int a(int paramInt, T paramT)
  {
    if ((paramT instanceof s.a.a)) {
      paramInt = ((s.a.a)paramT).off;
    }
    return paramInt;
  }
  
  private int[] aIH(int paramInt)
  {
    int[] arrayOfInt = new int[paramInt];
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      j = o.a(this.ahPl.ahQi) + j;
      arrayOfInt[i] = j;
      i += 1;
    }
    return arrayOfInt;
  }
  
  protected abstract T a(com.tencent.tinker.a.a.a.a parama);
  
  protected T a(com.tencent.tinker.c.a.c.a parama, T paramT)
  {
    return paramT;
  }
  
  protected void a(c paramc, int paramInt1, int paramInt2) {}
  
  protected void a(c paramc, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected abstract s.a c(com.tencent.tinker.a.a.i parami);
  
  public final void execute()
  {
    int[] arrayOfInt1 = aIH(o.b(this.ahPl.ahQi));
    int[] arrayOfInt2 = aIH(o.b(this.ahPl.ahQi));
    int[] arrayOfInt3 = aIH(o.b(this.ahPl.ahQi));
    Object localObject = c(this.ahPj);
    i.e locale;
    int k;
    if (((s.a)localObject).jKS())
    {
      locale = this.ahPj.a((s.a)localObject);
      k = ((s.a)localObject).size;
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
          f(a(this.ahPl.ahQi));
          i += 1;
          n += 1;
        }
        else if ((i1 < i4) && (arrayOfInt3[i1] == i))
        {
          f(a(this.ahPl.ahQi));
          i += 1;
          i1 += 1;
        }
        else if (Arrays.binarySearch(arrayOfInt1, j) >= 0)
        {
          localObject = a(locale);
          a(this.ahPm, j, a(j, (Comparable)localObject));
          j += 1;
          m += 1;
        }
        else if (Arrays.binarySearch(arrayOfInt3, j) >= 0)
        {
          localObject = a(locale);
          a(this.ahPm, j, a(j, (Comparable)localObject));
          j += 1;
        }
        else if (j < k)
        {
          localObject = a(this.ahPm, a(locale));
          int i5 = f((Comparable)localObject);
          a(this.ahPm, j, a(j, (Comparable)localObject), i, i5);
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
  
  protected abstract int f(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.tinker.c.a.a.a.i
 * JD-Core Version:    0.7.0.1
 */