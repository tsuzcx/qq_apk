package android.support.v7.widget;

import android.support.v4.b.o;
import android.support.v4.b.p;
import java.util.ArrayList;
import java.util.List;

final class a
  implements r
{
  private o<c> qX = new p();
  final ArrayList<c> qY = new ArrayList();
  final ArrayList<c> qZ = new ArrayList();
  final b ra;
  Runnable rb;
  final boolean rc;
  final q rd;
  
  a(b paramb)
  {
    this(paramb, (byte)0);
  }
  
  private a(b paramb, byte paramByte)
  {
    this.ra = paramb;
    this.rc = false;
    this.rd = new q(this);
  }
  
  private boolean X(int paramInt)
  {
    int k = this.qZ.size();
    int i = 0;
    while (i < k)
    {
      c localc = (c)this.qZ.get(i);
      if (localc.al == 3)
      {
        if (l(localc.rg, i + 1) == paramInt) {
          return true;
        }
      }
      else if (localc.al == 0)
      {
        int m = localc.re;
        int n = localc.rg;
        int j = localc.re;
        while (j < m + n)
        {
          if (l(j, i + 1) == paramInt) {
            return true;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return false;
  }
  
  private void a(c paramc)
  {
    if ((paramc.al == 0) || (paramc.al == 3)) {
      throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }
    int i1 = k(paramc.re, paramc.al);
    int j = paramc.re;
    int k;
    int m;
    int n;
    label105:
    int i2;
    switch (paramc.al)
    {
    default: 
      throw new IllegalArgumentException("op should be remove or update." + paramc);
    case 2: 
      k = 1;
      m = 1;
      n = 1;
      if (m >= paramc.rg) {
        break label286;
      }
      i2 = k(paramc.re + k * m, paramc.al);
      switch (paramc.al)
      {
      default: 
        i = 0;
        label162:
        if (i == 0) {}
        break;
      }
      break;
    }
    for (int i = n + 1;; i = n)
    {
      m += 1;
      n = i;
      break label105;
      k = 0;
      break;
      if (i2 == i1 + 1)
      {
        i = 1;
        break label162;
      }
      i = 0;
      break label162;
      if (i2 == i1)
      {
        i = 1;
        break label162;
      }
      i = 0;
      break label162;
      localObject = a(paramc.al, i1, n, paramc.rf);
      a((c)localObject, j);
      c((c)localObject);
      i = j;
      if (paramc.al == 2) {
        i = j + n;
      }
      n = 1;
      i1 = i2;
      j = i;
    }
    label286:
    Object localObject = paramc.rf;
    c(paramc);
    if (n > 0)
    {
      paramc = a(paramc.al, i1, n, localObject);
      a(paramc, j);
      c(paramc);
    }
  }
  
  private void a(c paramc, int paramInt)
  {
    this.ra.d(paramc);
    switch (paramc.al)
    {
    default: 
      throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    case 1: 
      this.ra.m(paramInt, paramc.rg);
      return;
    }
    this.ra.a(paramInt, paramc.rg, paramc.rf);
  }
  
  private void b(c paramc)
  {
    this.qZ.add(paramc);
    switch (paramc.al)
    {
    default: 
      throw new IllegalArgumentException("Unknown update op type for " + paramc);
    case 0: 
      this.ra.o(paramc.re, paramc.rg);
      return;
    case 3: 
      this.ra.p(paramc.re, paramc.rg);
      return;
    case 1: 
      this.ra.n(paramc.re, paramc.rg);
      return;
    }
    this.ra.a(paramc.re, paramc.rg, paramc.rf);
  }
  
  private void g(List<c> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      c((c)paramList.get(i));
      i += 1;
    }
    paramList.clear();
  }
  
  private int k(int paramInt1, int paramInt2)
  {
    int i = this.qZ.size() - 1;
    c localc;
    if (i >= 0)
    {
      localc = (c)this.qZ.get(i);
      int k;
      int j;
      if (localc.al == 3) {
        if (localc.re < localc.rg)
        {
          k = localc.re;
          j = localc.rg;
          label63:
          if ((paramInt1 < k) || (paramInt1 > j)) {
            break label192;
          }
          if (k != localc.re) {
            break label149;
          }
          if (paramInt2 != 0) {
            break label129;
          }
          localc.rg += 1;
          label101:
          paramInt1 += 1;
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        k = localc.rg;
        j = localc.re;
        break label63;
        label129:
        if (paramInt2 != 1) {
          break label101;
        }
        localc.rg -= 1;
        break label101;
        label149:
        if (paramInt2 == 0) {
          localc.re += 1;
        }
        for (;;)
        {
          paramInt1 -= 1;
          break;
          if (paramInt2 == 1) {
            localc.re -= 1;
          }
        }
        label192:
        if (paramInt1 < localc.re)
        {
          if (paramInt2 == 0)
          {
            localc.re += 1;
            localc.rg += 1;
            continue;
          }
          if (paramInt2 == 1)
          {
            localc.re -= 1;
            localc.rg -= 1;
          }
        }
        continue;
        if (localc.re <= paramInt1)
        {
          if (localc.al == 0) {
            paramInt1 -= localc.rg;
          } else if (localc.al == 1) {
            paramInt1 = localc.rg + paramInt1;
          }
        }
        else if (paramInt2 == 0) {
          localc.re += 1;
        } else if (paramInt2 == 1) {
          localc.re -= 1;
        }
      }
    }
    paramInt2 = this.qZ.size() - 1;
    if (paramInt2 >= 0)
    {
      localc = (c)this.qZ.get(paramInt2);
      if (localc.al == 3) {
        if ((localc.rg == localc.re) || (localc.rg < 0))
        {
          this.qZ.remove(paramInt2);
          c(localc);
        }
      }
      for (;;)
      {
        paramInt2 -= 1;
        break;
        if (localc.rg <= 0)
        {
          this.qZ.remove(paramInt2);
          c(localc);
        }
      }
    }
    return paramInt1;
  }
  
  final int Y(int paramInt)
  {
    return l(paramInt, 0);
  }
  
  public final c a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    c localc = (c)this.qX.bl();
    if (localc == null) {
      return new c(paramInt1, paramInt2, paramInt3, paramObject);
    }
    localc.al = paramInt1;
    localc.re = paramInt2;
    localc.rg = paramInt3;
    localc.rf = paramObject;
    return localc;
  }
  
  public final void c(c paramc)
  {
    if (!this.rc)
    {
      paramc.rf = null;
      this.qX.m(paramc);
    }
  }
  
  final void cA()
  {
    q localq = this.rd;
    ArrayList localArrayList = this.qY;
    int i;
    label24:
    label52:
    int i1;
    c localc2;
    c localc3;
    int k;
    for (;;)
    {
      j = 0;
      i = localArrayList.size() - 1;
      if (i < 0) {
        break label264;
      }
      if (((c)localArrayList.get(i)).al != 3) {
        break;
      }
      if (j == 0) {
        break label1809;
      }
      j = i;
      if (j == -1) {
        break label1247;
      }
      i1 = j + 1;
      localc2 = (c)localArrayList.get(j);
      localc3 = (c)localArrayList.get(i1);
      switch (localc3.al)
      {
      default: 
        break;
      case 0: 
        i = 0;
        if (localc2.rg < localc3.re) {
          i = -1;
        }
        k = i;
        if (localc2.re < localc3.re) {
          k = i + 1;
        }
        if (localc3.re <= localc2.re) {
          localc2.re += localc3.rg;
        }
        if (localc3.re <= localc2.rg) {
          localc2.rg += localc3.rg;
        }
        localc3.re = (k + localc3.re);
        localArrayList.set(j, localc3);
        localArrayList.set(i1, localc2);
      }
    }
    int j = 1;
    label264:
    label651:
    label1809:
    for (;;)
    {
      i -= 1;
      break label24;
      j = -1;
      break label52;
      c localc1 = null;
      int m = 0;
      int n;
      if (localc2.re < localc2.rg)
      {
        n = 0;
        k = n;
        i = m;
        if (localc3.re == localc2.re)
        {
          k = n;
          i = m;
          if (localc3.rg == localc2.rg - localc2.re)
          {
            i = 1;
            k = n;
          }
        }
        label340:
        if (localc2.rg >= localc3.re) {
          break label487;
        }
        localc3.re -= 1;
        label365:
        if (localc2.re > localc3.re) {
          break label563;
        }
        localc3.re += 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label651;
        }
        localArrayList.set(j, localc3);
        localArrayList.remove(i1);
        localq.sS.c(localc2);
        break;
        n = 1;
        k = n;
        i = m;
        if (localc3.re != localc2.rg + 1) {
          break label340;
        }
        k = n;
        i = m;
        if (localc3.rg != localc2.re - localc2.rg) {
          break label340;
        }
        i = 1;
        k = n;
        break label340;
        label487:
        if (localc2.rg >= localc3.re + localc3.rg) {
          break label365;
        }
        localc3.rg -= 1;
        localc2.al = 1;
        localc2.rg = 1;
        if (localc3.rg != 0) {
          break;
        }
        localArrayList.remove(i1);
        localq.sS.c(localc3);
        break;
        label563:
        if (localc2.re < localc3.re + localc3.rg)
        {
          m = localc3.re;
          n = localc3.rg;
          i2 = localc2.re;
          localc1 = localq.sS.a(1, localc2.re + 1, m + n - i2, null);
          localc3.rg = (localc2.re - localc3.re);
        }
      }
      if (k != 0)
      {
        if (localc1 != null)
        {
          if (localc2.re > localc1.re) {
            localc2.re -= localc1.rg;
          }
          if (localc2.rg > localc1.re) {
            localc2.rg -= localc1.rg;
          }
        }
        if (localc2.re > localc3.re) {
          localc2.re -= localc3.rg;
        }
        if (localc2.rg > localc3.re) {
          localc2.rg -= localc3.rg;
        }
        localArrayList.set(j, localc3);
        if (localc2.re == localc2.rg) {
          break label954;
        }
        localArrayList.set(i1, localc2);
      }
      while (localc1 != null)
      {
        localArrayList.add(j, localc1);
        break;
        if (localc1 != null)
        {
          if (localc2.re >= localc1.re) {
            localc2.re -= localc1.rg;
          }
          if (localc2.rg >= localc1.re) {
            localc2.rg -= localc1.rg;
          }
        }
        if (localc2.re >= localc3.re) {
          localc2.re -= localc3.rg;
        }
        if (localc2.rg < localc3.re) {
          break label776;
        }
        localc2.rg -= localc3.rg;
        break label776;
        label954:
        localArrayList.remove(i1);
      }
      localc1 = null;
      Object localObject = null;
      if (localc2.rg < localc3.re)
      {
        localc3.re -= 1;
        label998:
        if (localc2.re > localc3.re) {
          break label1145;
        }
        localc3.re += 1;
        label1023:
        localArrayList.set(i1, localc2);
        if (localc3.rg <= 0) {
          break label1223;
        }
        localArrayList.set(j, localc3);
      }
      for (;;)
      {
        if (localc1 != null) {
          localArrayList.add(j, localc1);
        }
        if (localObject == null) {
          break;
        }
        localArrayList.add(j, localObject);
        break;
        if (localc2.rg >= localc3.re + localc3.rg) {
          break label998;
        }
        localc3.rg -= 1;
        localc1 = localq.sS.a(2, localc2.re, 1, localc3.rf);
        break label998;
        label1145:
        if (localc2.re >= localc3.re + localc3.rg) {
          break label1023;
        }
        i = localc3.re + localc3.rg - localc2.re;
        localObject = localq.sS.a(2, localc2.re + 1, i, localc3.rf);
        localc3.rg -= i;
        break label1023;
        label1223:
        localArrayList.remove(j);
        localq.sS.c(localc3);
      }
      label1247:
      int i4 = this.qY.size();
      int i2 = 0;
      if (i2 < i4)
      {
        localc1 = (c)this.qY.get(i2);
        switch (localc1.al)
        {
        }
        for (;;)
        {
          if (this.rb != null) {
            this.rb.run();
          }
          i2 += 1;
          break;
          b(localc1);
          continue;
          int i3 = localc1.re;
          m = localc1.re + localc1.rg;
          i1 = -1;
          i = localc1.re;
          n = 0;
          if (i < m)
          {
            j = 0;
            k = 0;
            if ((this.ra.Z(i) != null) || (X(i)))
            {
              if (i1 == 0)
              {
                a(a(1, i3, n, null));
                k = 1;
              }
              j = 1;
              label1436:
              if (k == 0) {
                break label1502;
              }
              k = i - n;
              i = 1;
              m -= n;
            }
            for (;;)
            {
              k += 1;
              n = i;
              i = k;
              i1 = j;
              break;
              if (i1 == 1)
              {
                b(a(1, i3, n, null));
                j = 1;
              }
              i1 = 0;
              k = j;
              j = i1;
              break label1436;
              label1502:
              n += 1;
              k = i;
              i = n;
            }
          }
          localObject = localc1;
          if (n != localc1.rg)
          {
            c(localc1);
            localObject = a(1, i3, n, null);
          }
          if (i1 == 0)
          {
            a((c)localObject);
          }
          else
          {
            b((c)localObject);
            continue;
            k = localc1.re;
            j = 0;
            int i5 = localc1.re;
            int i6 = localc1.rg;
            i3 = -1;
            i = localc1.re;
            if (i < i5 + i6)
            {
              if ((this.ra.Z(i) != null) || (X(i)))
              {
                n = j;
                i1 = k;
                if (i3 == 0)
                {
                  a(a(2, k, j, localc1.rf));
                  n = 0;
                  i1 = i;
                }
                m = 1;
                k = i1;
              }
              for (;;)
              {
                j = n + 1;
                i += 1;
                i3 = m;
                break;
                n = j;
                m = k;
                if (i3 == 1)
                {
                  b(a(2, k, j, localc1.rf));
                  n = 0;
                  m = i;
                }
                j = 0;
                k = m;
                m = j;
              }
            }
            localObject = localc1;
            if (j != localc1.rg)
            {
              localObject = localc1.rf;
              c(localc1);
              localObject = a(2, k, j, localObject);
            }
            if (i3 == 0)
            {
              a((c)localObject);
            }
            else
            {
              b((c)localObject);
              continue;
              b(localc1);
            }
          }
        }
      }
      this.qY.clear();
      return;
    }
  }
  
  final void cB()
  {
    int j = this.qZ.size();
    int i = 0;
    while (i < j)
    {
      this.ra.e((c)this.qZ.get(i));
      i += 1;
    }
    g(this.qZ);
  }
  
  final boolean cC()
  {
    return this.qY.size() > 0;
  }
  
  final void cD()
  {
    cB();
    int j = this.qY.size();
    int i = 0;
    if (i < j)
    {
      c localc = (c)this.qY.get(i);
      switch (localc.al)
      {
      }
      for (;;)
      {
        if (this.rb != null) {
          this.rb.run();
        }
        i += 1;
        break;
        this.ra.e(localc);
        this.ra.o(localc.re, localc.rg);
        continue;
        this.ra.e(localc);
        this.ra.m(localc.re, localc.rg);
        continue;
        this.ra.e(localc);
        this.ra.a(localc.re, localc.rg, localc.rf);
        continue;
        this.ra.e(localc);
        this.ra.p(localc.re, localc.rg);
      }
    }
    g(this.qY);
  }
  
  final int l(int paramInt1, int paramInt2)
  {
    int k = this.qZ.size();
    int j = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = paramInt2;
    c localc;
    if (j < k)
    {
      localc = (c)this.qZ.get(j);
      if (localc.al == 3) {
        if (localc.re == paramInt2) {
          paramInt1 = localc.rg;
        }
      }
    }
    for (;;)
    {
      j += 1;
      paramInt2 = paramInt1;
      break;
      int i = paramInt2;
      if (localc.re < paramInt2) {
        i = paramInt2 - 1;
      }
      paramInt1 = i;
      if (localc.rg <= i)
      {
        paramInt1 = i + 1;
        continue;
        paramInt1 = paramInt2;
        if (localc.re <= paramInt2) {
          if (localc.al == 1)
          {
            if (paramInt2 < localc.re + localc.rg)
            {
              paramInt1 = -1;
              return paramInt1;
            }
            paramInt1 = paramInt2 - localc.rg;
          }
          else
          {
            paramInt1 = paramInt2;
            if (localc.al == 0) {
              paramInt1 = paramInt2 + localc.rg;
            }
          }
        }
      }
    }
  }
  
  final void reset()
  {
    g(this.qY);
    g(this.qZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.a
 * JD-Core Version:    0.7.0.1
 */