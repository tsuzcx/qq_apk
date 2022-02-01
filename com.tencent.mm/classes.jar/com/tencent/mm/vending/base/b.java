package com.tencent.mm.vending.base;

import android.os.Handler;
import com.tencent.mm.vending.f.a;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class b<_Struct, _Change>
  extends Vending<_Struct, Integer, _Change>
{
  public int HPl = 5;
  private a HPm = new a((byte)0);
  public int mCount = 0;
  
  private void jS(int paramInt1, int paramInt2)
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
      synchronized (this.HPm)
      {
        Object localObject1 = this.HPm;
        if (!((a)localObject1).initialized)
        {
          ((a)localObject1).set(j, paramInt1);
          ((a)localObject1).initialized = true;
          localObject1 = new int[] { j, paramInt1 };
          if (localObject1 != null) {}
        }
        else
        {
          paramInt2 = ((a)localObject1).xo;
          k = ((a)localObject1).xq;
          if (paramInt2 > paramInt1) {
            break label479;
          }
          if (k < j)
          {
            break label479;
            ((a)localObject1).set(j, paramInt1);
            localObject1 = new int[] { j, paramInt1 };
            continue;
          }
          if (j < paramInt2)
          {
            if (paramInt1 > k)
            {
              ((a)localObject1).set(j, paramInt1);
              localObject1 = new int[] { j, paramInt2 - 1, k + 1, paramInt1 };
              continue;
            }
            ((a)localObject1).set(j, k);
            localObject1 = new int[] { j, paramInt2 - 1 };
            continue;
          }
          if (paramInt1 <= k) {
            break label498;
          }
          ((a)localObject1).set(paramInt2, paramInt1);
          localObject1 = new int[] { k + 1, paramInt1 };
        }
      }
      if (i != 0) {
        paramInt1 = localObject2.length - 2;
      }
      for (;;)
      {
        label269:
        label295:
        label311:
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
            break label455;
          }
          if (i == 0) {
            break label398;
          }
          j = m - paramInt2;
          localf = getLoader();
          localInteger = Integer.valueOf(j);
          if (localf.iQZ.get()) {}
        }
        synchronized (localf.HPs)
        {
          Vending.f.b localb = (Vending.f.b)localf.HPq.get(localInteger);
          if ((localb != null) && (localb != Vending.f.b.HPu))
          {
            paramInt2 += 1;
            break label295;
            paramInt1 = 0;
            continue;
            if (paramInt1 >= localObject2.length) {
              break;
            }
            break label269;
            label398:
            j = k + paramInt2;
            break label311;
          }
          localf.HPq.put(localInteger, Vending.f.b.HPv);
          localf.mVendingHandler.sendMessage(localf.mVendingHandler.obtainMessage(0, localInteger));
        }
        label455:
        if (i != 0) {
          paramInt1 -= 2;
        } else {
          paramInt1 += 2;
        }
      }
      return;
      i = 0;
      break;
      label479:
      if (paramInt2 <= paramInt1 + 1) {
        if (k < j - 1)
        {
          continue;
          label498:
          Object localObject4 = null;
        }
      }
    }
  }
  
  protected abstract _Struct NM(int paramInt);
  
  protected abstract int fgZ();
  
  public final <T> T get(int paramInt)
  {
    if (this.mCount == 0)
    {
      a.e("Vending.ForwardVending", "mCount is 0, why call get()?", new Object[0]);
      return null;
    }
    return super.get(Integer.valueOf(paramInt));
  }
  
  protected void loaderClear()
  {
    synchronized (this.HPm)
    {
      a locala2 = this.HPm;
      locala2.xo = -1;
      locala2.xq = -1;
      locala2.initialized = false;
      return;
    }
  }
  
  protected void synchronizing(int paramInt, Object paramObject)
  {
    this.mCount = fgZ();
    a.i("Vending.ForwardVending", "the count %s", new Object[] { Integer.valueOf(this.mCount) });
  }
  
  static final class a
  {
    boolean initialized = false;
    public int xo = -1;
    public int xq = -1;
    
    final void set(int paramInt1, int paramInt2)
    {
      this.xo = paramInt1;
      this.xq = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.base.b
 * JD-Core Version:    0.7.0.1
 */