package com.tencent.mm.vending.base;

import android.os.Handler;
import com.tencent.mm.vending.f.a;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class c<_Struct, _Change>
  extends Vending<_Struct, Integer, _Change>
{
  public int Yzy = 5;
  private a Yzz = new a((byte)0);
  public int mCount = 0;
  
  private void ni(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    if (paramInt1 >= paramInt2)
    {
      i = 1;
      j = Math.min(paramInt1, paramInt2);
      paramInt1 = Math.max(paramInt1, paramInt2);
    }
    for (;;)
    {
      int k;
      synchronized (this.Yzz)
      {
        Object localObject1 = this.Yzz;
        if (!((a)localObject1).initialized)
        {
          ((a)localObject1).ca(j, paramInt1);
          ((a)localObject1).initialized = true;
          localObject1 = new int[] { j, paramInt1 };
          if (localObject1 != null) {}
        }
        else
        {
          paramInt2 = ((a)localObject1).tF;
          k = ((a)localObject1).tG;
          if (paramInt2 > paramInt1) {
            break label485;
          }
          if (k < j)
          {
            break label485;
            ((a)localObject1).ca(j, paramInt1);
            localObject1 = new int[] { j, paramInt1 };
            continue;
          }
          if (j < paramInt2)
          {
            if (paramInt1 > k)
            {
              ((a)localObject1).ca(j, paramInt1);
              localObject1 = new int[] { j, paramInt2 - 1, k + 1, paramInt1 };
              continue;
            }
            ((a)localObject1).ca(j, k);
            localObject1 = new int[] { j, paramInt2 - 1 };
            continue;
          }
          if (paramInt1 > k)
          {
            ((a)localObject1).ca(paramInt2, paramInt1);
            localObject1 = new int[] { k + 1, paramInt1 };
            continue;
          }
          localObject1 = null;
        }
      }
      if (i != 0) {
        paramInt1 = localObject2.length - 2;
      }
      for (;;)
      {
        label275:
        label301:
        label317:
        Vending.f localf;
        Integer localInteger;
        if (i != 0)
        {
          if (paramInt1 < 0) {
            break;
          }
          k = localObject2[paramInt1];
          int m = localObject2[(paramInt1 + 1)];
          int n = Math.abs(k - m);
          paramInt2 = 0;
          if (paramInt2 > n) {
            break label461;
          }
          if (i == 0) {
            break label404;
          }
          j = m - paramInt2;
          localf = getLoader();
          localInteger = Integer.valueOf(j);
          if (localf.nLe.get()) {}
        }
        synchronized (localf.YzF)
        {
          Vending.f.b localb = (Vending.f.b)localf.YzD.get(localInteger);
          if ((localb != null) && (localb != Vending.f.b.YzH))
          {
            paramInt2 += 1;
            break label301;
            paramInt1 = 0;
            continue;
            if (paramInt1 >= localObject2.length) {
              break;
            }
            break label275;
            label404:
            j = k + paramInt2;
            break label317;
          }
          localf.YzD.put(localInteger, Vending.f.b.YzI);
          localf.mVendingHandler.sendMessage(localf.mVendingHandler.obtainMessage(0, localInteger));
        }
        label461:
        if (i != 0) {
          paramInt1 -= 2;
        } else {
          paramInt1 += 2;
        }
      }
      return;
      i = 0;
      break;
      label485:
      if (paramInt2 <= paramInt1 + 1) {
        if (k >= j - 1) {}
      }
    }
  }
  
  protected abstract _Struct ahx(int paramInt);
  
  public final <T> T get(int paramInt)
  {
    if (this.mCount == 0)
    {
      a.e("Vending.ForwardVending", "mCount is 0, why call get()?", new Object[0]);
      return null;
    }
    return super.get(Integer.valueOf(paramInt));
  }
  
  protected abstract int ieu();
  
  protected void loaderClear()
  {
    synchronized (this.Yzz)
    {
      a locala2 = this.Yzz;
      locala2.tF = -1;
      locala2.tG = -1;
      locala2.initialized = false;
      return;
    }
  }
  
  protected void synchronizing(int paramInt, Object paramObject)
  {
    this.mCount = ieu();
    a.i("Vending.ForwardVending", "the count %s", new Object[] { Integer.valueOf(this.mCount) });
  }
  
  static final class a
  {
    boolean initialized = false;
    public int tF = -1;
    public int tG = -1;
    
    final void ca(int paramInt1, int paramInt2)
    {
      this.tF = paramInt1;
      this.tG = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.vending.base.c
 * JD-Core Version:    0.7.0.1
 */