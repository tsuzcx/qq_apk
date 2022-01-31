package com.tencent.mm.vending.base;

import android.os.Handler;
import com.tencent.mm.vending.f.a;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class b<_Struct, _Change>
  extends Vending<_Struct, Integer, _Change>
{
  private b.a ANU = new b.a((byte)0);
  public int a = 5;
  public int c = 0;
  
  private void a(int paramInt1, int paramInt2)
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
      synchronized (this.ANU)
      {
        Object localObject1 = this.ANU;
        if (!((b.a)localObject1).c)
        {
          ((b.a)localObject1).b(j, paramInt1);
          ((b.a)localObject1).c = true;
          localObject1 = new int[] { j, paramInt1 };
          if (localObject1 != null) {}
        }
        else
        {
          paramInt2 = ((b.a)localObject1).a;
          k = ((b.a)localObject1).b;
          if (paramInt2 > paramInt1) {
            break label479;
          }
          if (k < j)
          {
            break label479;
            ((b.a)localObject1).b(j, paramInt1);
            localObject1 = new int[] { j, paramInt1 };
            continue;
          }
          if (j < paramInt2)
          {
            if (paramInt1 > k)
            {
              ((b.a)localObject1).b(j, paramInt1);
              localObject1 = new int[] { j, paramInt2 - 1, k + 1, paramInt1 };
              continue;
            }
            ((b.a)localObject1).b(j, k);
            localObject1 = new int[] { j, paramInt2 - 1 };
            continue;
          }
          if (paramInt1 <= k) {
            break label498;
          }
          ((b.a)localObject1).b(paramInt2, paramInt1);
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
        Vending.c localc;
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
          localc = a();
          localInteger = Integer.valueOf(j);
          if (localc.ANX.get()) {}
        }
        synchronized (localc.b)
        {
          Vending.c.b localb = (Vending.c.b)localc.a.get(localInteger);
          if ((localb != null) && (localb != Vending.c.b.ANZ))
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
          localc.a.put(localInteger, Vending.c.b.AOa);
          localc.e.sendMessage(localc.e.obtainMessage(0, localInteger));
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
  
  protected abstract _Struct Fh(int paramInt);
  
  protected abstract int dQe();
  
  public final <T> T get(int paramInt)
  {
    if (this.c == 0)
    {
      a.e("Vending.ForwardVending", "mCount is 0, why call get()?", new Object[0]);
      return null;
    }
    return super.get(Integer.valueOf(paramInt));
  }
  
  protected void loaderClear()
  {
    synchronized (this.ANU)
    {
      b.a locala2 = this.ANU;
      locala2.a = -1;
      locala2.b = -1;
      locala2.c = false;
      return;
    }
  }
  
  protected void synchronizing(int paramInt, Object paramObject)
  {
    this.c = dQe();
    a.i("Vending.ForwardVending", "the count %s", new Object[] { Integer.valueOf(this.c) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.vending.base.b
 * JD-Core Version:    0.7.0.1
 */