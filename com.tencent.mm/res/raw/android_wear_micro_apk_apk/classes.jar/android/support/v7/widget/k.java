package android.support.v7.widget;

import android.util.SparseIntArray;

public abstract class k
{
  final SparseIntArray sb;
  private boolean sc;
  
  private int v(int paramInt1, int paramInt2)
  {
    int n = cO();
    if (n == paramInt2) {
      return 0;
    }
    int j;
    int i;
    int k;
    if ((this.sc) && (this.sb.size() > 0))
    {
      j = this.sb.size() - 1;
      i = 0;
      while (i <= j)
      {
        k = i + j >>> 1;
        if (this.sb.keyAt(k) < paramInt1) {
          i = k + 1;
        } else {
          j = k - 1;
        }
      }
      i -= 1;
      if ((i >= 0) && (i < this.sb.size()))
      {
        i = this.sb.keyAt(i);
        if (i < 0) {
          break label212;
        }
        j = this.sb.get(i) + cO();
        k = i + 1;
        i = j;
        j = k;
      }
    }
    for (;;)
    {
      label147:
      if (j < paramInt1)
      {
        k = cO();
        int m = i + k;
        if (m == paramInt2) {
          i = 0;
        }
        for (;;)
        {
          j += 1;
          break label147;
          i = -1;
          break;
          i = k;
          if (m <= paramInt2) {
            i = m;
          }
        }
      }
      if (i + n > paramInt2) {
        break;
      }
      return i;
      label212:
      j = 0;
      i = 0;
    }
  }
  
  public abstract int cO();
  
  final int u(int paramInt1, int paramInt2)
  {
    int i;
    if (!this.sc) {
      i = v(paramInt1, paramInt2);
    }
    int j;
    do
    {
      return i;
      j = this.sb.get(paramInt1, -1);
      i = j;
    } while (j != -1);
    paramInt2 = v(paramInt1, paramInt2);
    this.sb.put(paramInt1, paramInt2);
    return paramInt2;
  }
  
  public final int w(int paramInt1, int paramInt2)
  {
    int n = cO();
    int k = 0;
    int i = 0;
    int j = 0;
    int m;
    if (k < paramInt1)
    {
      m = cO();
      j += m;
      if (j == paramInt2)
      {
        j = i + 1;
        i = 0;
      }
    }
    for (;;)
    {
      k += 1;
      m = i;
      i = j;
      j = m;
      break;
      if (j > paramInt2)
      {
        j = i + 1;
        i = m;
        continue;
        paramInt1 = i;
        if (j + n > paramInt2) {
          paramInt1 = i + 1;
        }
        return paramInt1;
      }
      else
      {
        m = j;
        j = i;
        i = m;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.k
 * JD-Core Version:    0.7.0.1
 */