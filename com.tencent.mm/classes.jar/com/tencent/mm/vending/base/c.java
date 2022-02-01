package com.tencent.mm.vending.base;

import android.os.Handler;
import com.tencent.mm.vending.f.a;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class c<_Struct, _Change>
  extends Vending<_Struct, Integer, _Change>
{
  public int agtW = 5;
  private a agtX = new a((byte)0);
  public int mCount = 0;
  
  private void pe(int paramInt1, int paramInt2)
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
      synchronized (this.agtX)
      {
        Object localObject1 = this.agtX;
        if (!((a)localObject1).initialized)
        {
          ((a)localObject1).pf(j, paramInt1);
          ((a)localObject1).initialized = true;
          localObject1 = new int[] { j, paramInt1 };
          if (localObject1 != null) {}
        }
        else
        {
          paramInt2 = ((a)localObject1).uE;
          k = ((a)localObject1).uF;
          if (paramInt2 > paramInt1) {
            break label485;
          }
          if (k < j)
          {
            break label485;
            ((a)localObject1).pf(j, paramInt1);
            localObject1 = new int[] { j, paramInt1 };
            continue;
          }
          if (j < paramInt2)
          {
            if (paramInt1 > k)
            {
              ((a)localObject1).pf(j, paramInt1);
              localObject1 = new int[] { j, paramInt2 - 1, k + 1, paramInt1 };
              continue;
            }
            ((a)localObject1).pf(j, k);
            localObject1 = new int[] { j, paramInt2 - 1 };
            continue;
          }
          if (paramInt1 > k)
          {
            ((a)localObject1).pf(paramInt2, paramInt1);
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
          if (localf.qKN.get()) {}
        }
        synchronized (localf.agud)
        {
          Vending.f.b localb = (Vending.f.b)localf.agub.get(localInteger);
          if ((localb != null) && (localb != Vending.f.b.aguf))
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
          localf.agub.put(localInteger, Vending.f.b.agug);
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
  
  protected abstract _Struct amr(int paramInt);
  
  public final <T> T get(int paramInt)
  {
    if (this.mCount == 0)
    {
      a.e("Vending.ForwardVending", "mCount is 0, why call get()?", new Object[0]);
      return null;
    }
    return super.get(Integer.valueOf(paramInt));
  }
  
  protected abstract int jJB();
  
  protected void loaderClear()
  {
    synchronized (this.agtX)
    {
      a locala2 = this.agtX;
      locala2.uE = -1;
      locala2.uF = -1;
      locala2.initialized = false;
      return;
    }
  }
  
  protected void synchronizing(int paramInt, Object paramObject)
  {
    this.mCount = jJB();
    a.i("Vending.ForwardVending", "the count %s", new Object[] { Integer.valueOf(this.mCount) });
  }
  
  static final class a
  {
    boolean initialized = false;
    public int uE = -1;
    public int uF = -1;
    
    final void pf(int paramInt1, int paramInt2)
    {
      this.uE = paramInt1;
      this.uF = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.vending.base.c
 * JD-Core Version:    0.7.0.1
 */