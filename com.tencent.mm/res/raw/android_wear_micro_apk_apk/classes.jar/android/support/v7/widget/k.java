package android.support.v7.widget;

import android.util.SparseIntArray;

public abstract class k
{
  final SparseIntArray tR;
  private boolean tS;
  
  private int aq(int paramInt)
  {
    int i = 0;
    int j = this.tR.size() - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      if (this.tR.keyAt(k) < paramInt) {
        i = k + 1;
      } else {
        j = k - 1;
      }
    }
    paramInt = i - 1;
    if ((paramInt >= 0) && (paramInt < this.tR.size())) {
      return this.tR.keyAt(paramInt);
    }
    return -1;
  }
  
  private int w(int paramInt1, int paramInt2)
  {
    int n = cW();
    if (n == paramInt2) {
      return 0;
    }
    int j;
    int i;
    if ((this.tS) && (this.tR.size() > 0))
    {
      j = aq(paramInt1);
      if (j >= 0)
      {
        i = this.tR.get(j) + cW();
        j += 1;
      }
    }
    for (;;)
    {
      if (j < paramInt1)
      {
        int k = cW();
        int m = i + k;
        if (m == paramInt2) {
          i = 0;
        }
        for (;;)
        {
          j += 1;
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
      j = 0;
      i = 0;
    }
  }
  
  public abstract int cW();
  
  final int v(int paramInt1, int paramInt2)
  {
    int i;
    if (!this.tS) {
      i = w(paramInt1, paramInt2);
    }
    int j;
    do
    {
      return i;
      j = this.tR.get(paramInt1, -1);
      i = j;
    } while (j != -1);
    paramInt2 = w(paramInt1, paramInt2);
    this.tR.put(paramInt1, paramInt2);
    return paramInt2;
  }
  
  public final int x(int paramInt1, int paramInt2)
  {
    int n = cW();
    int k = 0;
    int i = 0;
    int j = 0;
    int m;
    if (k < paramInt1)
    {
      m = cW();
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