package com.tencent.mm.vending.base;

import android.os.Handler;
import com.tencent.mm.vending.f.a;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class b<_Struct, _Change>
  extends Vending<_Struct, Integer, _Change>
{
  public int QZi = 5;
  private a QZj = new a((byte)0);
  public int mCount = 0;
  
  private void lR(int paramInt1, int paramInt2)
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
      synchronized (this.QZj)
      {
        Object localObject1 = this.QZj;
        if (!((a)localObject1).initialized)
        {
          ((a)localObject1).set(j, paramInt1);
          ((a)localObject1).initialized = true;
          localObject1 = new int[] { j, paramInt1 };
          if (localObject1 != null) {}
        }
        else
        {
          paramInt2 = ((a)localObject1).Al;
          k = ((a)localObject1).An;
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
          if (localf.kQW.get()) {}
        }
        synchronized (localf.QZp)
        {
          Vending.f.b localb = (Vending.f.b)localf.QZn.get(localInteger);
          if ((localb != null) && (localb != Vending.f.b.QZr))
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
          localf.QZn.put(localInteger, Vending.f.b.QZs);
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
  
  protected abstract _Struct aac(int paramInt);
  
  public final <T> T get(int paramInt)
  {
    if (this.mCount == 0)
    {
      a.e("Vending.ForwardVending", "mCount is 0, why call get()?", new Object[0]);
      return null;
    }
    return super.get(Integer.valueOf(paramInt));
  }
  
  protected abstract int hdn();
  
  protected void loaderClear()
  {
    synchronized (this.QZj)
    {
      a locala2 = this.QZj;
      locala2.Al = -1;
      locala2.An = -1;
      locala2.initialized = false;
      return;
    }
  }
  
  protected void synchronizing(int paramInt, Object paramObject)
  {
    this.mCount = hdn();
    a.i("Vending.ForwardVending", "the count %s", new Object[] { Integer.valueOf(this.mCount) });
  }
  
  static final class a
  {
    public int Al = -1;
    public int An = -1;
    boolean initialized = false;
    
    final void set(int paramInt1, int paramInt2)
    {
      this.Al = paramInt1;
      this.An = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.vending.base.b
 * JD-Core Version:    0.7.0.1
 */