package android.support.v7.widget;

import android.support.v4.b.o;
import android.support.v4.b.p;
import java.util.ArrayList;
import java.util.List;

final class a
  implements r
{
  private o<c> sN = new p(30);
  final ArrayList<c> sO = new ArrayList();
  final ArrayList<c> sP = new ArrayList();
  final b sQ;
  Runnable sR;
  final boolean sS;
  final q sT;
  
  a(b paramb)
  {
    this(paramb, (byte)0);
  }
  
  private a(b paramb, byte paramByte)
  {
    this.sQ = paramb;
    this.sS = false;
    this.sT = new q(this);
  }
  
  private void a(c paramc)
  {
    if ((paramc.bU == 0) || (paramc.bU == 3)) {
      throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }
    int i1 = l(paramc.sU, paramc.bU);
    int j = paramc.sU;
    int k;
    int m;
    int n;
    label98:
    int i2;
    switch (paramc.bU)
    {
    default: 
      throw new IllegalArgumentException("op should be remove or update.".concat(String.valueOf(paramc)));
    case 2: 
      k = 1;
      m = 1;
      n = 1;
      if (m >= paramc.sW) {
        break label278;
      }
      i2 = l(paramc.sU + k * m, paramc.bU);
      switch (paramc.bU)
      {
      default: 
        i = 0;
        label154:
        if (i == 0) {}
        break;
      }
      break;
    }
    for (int i = n + 1;; i = n)
    {
      m += 1;
      n = i;
      break label98;
      k = 0;
      break;
      if (i2 == i1 + 1)
      {
        i = 1;
        break label154;
      }
      i = 0;
      break label154;
      if (i2 == i1)
      {
        i = 1;
        break label154;
      }
      i = 0;
      break label154;
      localObject = a(paramc.bU, i1, n, paramc.sV);
      a((c)localObject, j);
      c((c)localObject);
      i = j;
      if (paramc.bU == 2) {
        i = j + n;
      }
      n = 1;
      i1 = i2;
      j = i;
    }
    label278:
    Object localObject = paramc.sV;
    c(paramc);
    if (n > 0)
    {
      paramc = a(paramc.bU, i1, n, localObject);
      a(paramc, j);
      c(paramc);
    }
  }
  
  private void a(c paramc, int paramInt)
  {
    this.sQ.d(paramc);
    switch (paramc.bU)
    {
    default: 
      throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    case 1: 
      this.sQ.n(paramInt, paramc.sW);
      return;
    }
    this.sQ.a(paramInt, paramc.sW, paramc.sV);
  }
  
  private boolean ai(int paramInt)
  {
    int k = this.sP.size();
    int i = 0;
    while (i < k)
    {
      c localc = (c)this.sP.get(i);
      if (localc.bU == 3)
      {
        if (m(localc.sW, i + 1) == paramInt) {
          return true;
        }
      }
      else if (localc.bU == 0)
      {
        int m = localc.sU;
        int n = localc.sW;
        int j = localc.sU;
        while (j < m + n)
        {
          if (m(j, i + 1) == paramInt) {
            return true;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return false;
  }
  
  private void b(c paramc)
  {
    this.sP.add(paramc);
    switch (paramc.bU)
    {
    default: 
      throw new IllegalArgumentException("Unknown update op type for ".concat(String.valueOf(paramc)));
    case 0: 
      this.sQ.p(paramc.sU, paramc.sW);
      return;
    case 3: 
      this.sQ.q(paramc.sU, paramc.sW);
      return;
    case 1: 
      this.sQ.o(paramc.sU, paramc.sW);
      return;
    }
    this.sQ.a(paramc.sU, paramc.sW, paramc.sV);
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
  
  private int l(int paramInt1, int paramInt2)
  {
    int i = this.sP.size() - 1;
    c localc;
    if (i >= 0)
    {
      localc = (c)this.sP.get(i);
      int k;
      int j;
      if (localc.bU == 3) {
        if (localc.sU < localc.sW)
        {
          k = localc.sU;
          j = localc.sW;
          label63:
          if ((paramInt1 < k) || (paramInt1 > j)) {
            break label192;
          }
          if (k != localc.sU) {
            break label149;
          }
          if (paramInt2 != 0) {
            break label129;
          }
          localc.sW += 1;
          label101:
          paramInt1 += 1;
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        k = localc.sW;
        j = localc.sU;
        break label63;
        label129:
        if (paramInt2 != 1) {
          break label101;
        }
        localc.sW -= 1;
        break label101;
        label149:
        if (paramInt2 == 0) {
          localc.sU += 1;
        }
        for (;;)
        {
          paramInt1 -= 1;
          break;
          if (paramInt2 == 1) {
            localc.sU -= 1;
          }
        }
        label192:
        if (paramInt1 < localc.sU)
        {
          if (paramInt2 == 0)
          {
            localc.sU += 1;
            localc.sW += 1;
            continue;
          }
          if (paramInt2 == 1)
          {
            localc.sU -= 1;
            localc.sW -= 1;
          }
        }
        continue;
        if (localc.sU <= paramInt1)
        {
          if (localc.bU == 0) {
            paramInt1 -= localc.sW;
          } else if (localc.bU == 1) {
            paramInt1 = localc.sW + paramInt1;
          }
        }
        else if (paramInt2 == 0) {
          localc.sU += 1;
        } else if (paramInt2 == 1) {
          localc.sU -= 1;
        }
      }
    }
    paramInt2 = this.sP.size() - 1;
    if (paramInt2 >= 0)
    {
      localc = (c)this.sP.get(paramInt2);
      if (localc.bU == 3) {
        if ((localc.sW == localc.sU) || (localc.sW < 0))
        {
          this.sP.remove(paramInt2);
          c(localc);
        }
      }
      for (;;)
      {
        paramInt2 -= 1;
        break;
        if (localc.sW <= 0)
        {
          this.sP.remove(paramInt2);
          c(localc);
        }
      }
    }
    return paramInt1;
  }
  
  public final c a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    c localc = (c)this.sN.bC();
    if (localc == null) {
      return new c(paramInt1, paramInt2, paramInt3, paramObject);
    }
    localc.bU = paramInt1;
    localc.sU = paramInt2;
    localc.sW = paramInt3;
    localc.sV = paramObject;
    return localc;
  }
  
  final int aj(int paramInt)
  {
    return m(paramInt, 0);
  }
  
  public final void c(c paramc)
  {
    if (!this.sS)
    {
      paramc.sV = null;
      this.sN.t(paramc);
    }
  }
  
  final void cH()
  {
    q localq = this.sT;
    ArrayList localArrayList = this.sO;
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
      if (((c)localArrayList.get(i)).bU != 3) {
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
      switch (localc3.bU)
      {
      default: 
        break;
      case 0: 
        i = 0;
        if (localc2.sW < localc3.sU) {
          i = -1;
        }
        k = i;
        if (localc2.sU < localc3.sU) {
          k = i + 1;
        }
        if (localc3.sU <= localc2.sU) {
          localc2.sU += localc3.sW;
        }
        if (localc3.sU <= localc2.sW) {
          localc2.sW += localc3.sW;
        }
        localc3.sU = (k + localc3.sU);
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
      if (localc2.sU < localc2.sW)
      {
        n = 0;
        k = n;
        i = m;
        if (localc3.sU == localc2.sU)
        {
          k = n;
          i = m;
          if (localc3.sW == localc2.sW - localc2.sU)
          {
            i = 1;
            k = n;
          }
        }
        label340:
        if (localc2.sW >= localc3.sU) {
          break label487;
        }
        localc3.sU -= 1;
        label365:
        if (localc2.sU > localc3.sU) {
          break label563;
        }
        localc3.sU += 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label651;
        }
        localArrayList.set(j, localc3);
        localArrayList.remove(i1);
        localq.uI.c(localc2);
        break;
        n = 1;
        k = n;
        i = m;
        if (localc3.sU != localc2.sW + 1) {
          break label340;
        }
        k = n;
        i = m;
        if (localc3.sW != localc2.sU - localc2.sW) {
          break label340;
        }
        i = 1;
        k = n;
        break label340;
        label487:
        if (localc2.sW >= localc3.sU + localc3.sW) {
          break label365;
        }
        localc3.sW -= 1;
        localc2.bU = 1;
        localc2.sW = 1;
        if (localc3.sW != 0) {
          break;
        }
        localArrayList.remove(i1);
        localq.uI.c(localc3);
        break;
        label563:
        if (localc2.sU < localc3.sU + localc3.sW)
        {
          m = localc3.sU;
          n = localc3.sW;
          i2 = localc2.sU;
          localc1 = localq.uI.a(1, localc2.sU + 1, m + n - i2, null);
          localc3.sW = (localc2.sU - localc3.sU);
        }
      }
      if (k != 0)
      {
        if (localc1 != null)
        {
          if (localc2.sU > localc1.sU) {
            localc2.sU -= localc1.sW;
          }
          if (localc2.sW > localc1.sU) {
            localc2.sW -= localc1.sW;
          }
        }
        if (localc2.sU > localc3.sU) {
          localc2.sU -= localc3.sW;
        }
        if (localc2.sW > localc3.sU) {
          localc2.sW -= localc3.sW;
        }
        localArrayList.set(j, localc3);
        if (localc2.sU == localc2.sW) {
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
          if (localc2.sU >= localc1.sU) {
            localc2.sU -= localc1.sW;
          }
          if (localc2.sW >= localc1.sU) {
            localc2.sW -= localc1.sW;
          }
        }
        if (localc2.sU >= localc3.sU) {
          localc2.sU -= localc3.sW;
        }
        if (localc2.sW < localc3.sU) {
          break label776;
        }
        localc2.sW -= localc3.sW;
        break label776;
        label954:
        localArrayList.remove(i1);
      }
      localc1 = null;
      Object localObject = null;
      if (localc2.sW < localc3.sU)
      {
        localc3.sU -= 1;
        label998:
        if (localc2.sU > localc3.sU) {
          break label1145;
        }
        localc3.sU += 1;
        label1023:
        localArrayList.set(i1, localc2);
        if (localc3.sW <= 0) {
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
        if (localc2.sW >= localc3.sU + localc3.sW) {
          break label998;
        }
        localc3.sW -= 1;
        localc1 = localq.uI.a(2, localc2.sU, 1, localc3.sV);
        break label998;
        label1145:
        if (localc2.sU >= localc3.sU + localc3.sW) {
          break label1023;
        }
        i = localc3.sU + localc3.sW - localc2.sU;
        localObject = localq.uI.a(2, localc2.sU + 1, i, localc3.sV);
        localc3.sW -= i;
        break label1023;
        label1223:
        localArrayList.remove(j);
        localq.uI.c(localc3);
      }
      label1247:
      int i4 = this.sO.size();
      int i2 = 0;
      if (i2 < i4)
      {
        localc1 = (c)this.sO.get(i2);
        switch (localc1.bU)
        {
        }
        for (;;)
        {
          if (this.sR != null) {
            this.sR.run();
          }
          i2 += 1;
          break;
          b(localc1);
          continue;
          int i3 = localc1.sU;
          m = localc1.sU + localc1.sW;
          i1 = -1;
          i = localc1.sU;
          n = 0;
          if (i < m)
          {
            j = 0;
            k = 0;
            if ((this.sQ.ak(i) != null) || (ai(i)))
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
          if (n != localc1.sW)
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
            k = localc1.sU;
            j = 0;
            int i5 = localc1.sU;
            int i6 = localc1.sW;
            i3 = -1;
            i = localc1.sU;
            if (i < i5 + i6)
            {
              if ((this.sQ.ak(i) != null) || (ai(i)))
              {
                n = j;
                i1 = k;
                if (i3 == 0)
                {
                  a(a(2, k, j, localc1.sV));
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
                  b(a(2, k, j, localc1.sV));
                  n = 0;
                  m = i;
                }
                j = 0;
                k = m;
                m = j;
              }
            }
            localObject = localc1;
            if (j != localc1.sW)
            {
              localObject = localc1.sV;
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
      this.sO.clear();
      return;
    }
  }
  
  final void cI()
  {
    int j = this.sP.size();
    int i = 0;
    while (i < j)
    {
      this.sQ.e((c)this.sP.get(i));
      i += 1;
    }
    g(this.sP);
  }
  
  final boolean cJ()
  {
    return this.sO.size() > 0;
  }
  
  final void cK()
  {
    cI();
    int j = this.sO.size();
    int i = 0;
    if (i < j)
    {
      c localc = (c)this.sO.get(i);
      switch (localc.bU)
      {
      }
      for (;;)
      {
        if (this.sR != null) {
          this.sR.run();
        }
        i += 1;
        break;
        this.sQ.e(localc);
        this.sQ.p(localc.sU, localc.sW);
        continue;
        this.sQ.e(localc);
        this.sQ.n(localc.sU, localc.sW);
        continue;
        this.sQ.e(localc);
        this.sQ.a(localc.sU, localc.sW, localc.sV);
        continue;
        this.sQ.e(localc);
        this.sQ.q(localc.sU, localc.sW);
      }
    }
    g(this.sO);
  }
  
  final int m(int paramInt1, int paramInt2)
  {
    int k = this.sP.size();
    int j = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = paramInt2;
    c localc;
    if (j < k)
    {
      localc = (c)this.sP.get(j);
      if (localc.bU == 3) {
        if (localc.sU == paramInt2) {
          paramInt1 = localc.sW;
        }
      }
    }
    for (;;)
    {
      j += 1;
      paramInt2 = paramInt1;
      break;
      int i = paramInt2;
      if (localc.sU < paramInt2) {
        i = paramInt2 - 1;
      }
      paramInt1 = i;
      if (localc.sW <= i)
      {
        paramInt1 = i + 1;
        continue;
        paramInt1 = paramInt2;
        if (localc.sU <= paramInt2) {
          if (localc.bU == 1)
          {
            if (paramInt2 < localc.sU + localc.sW)
            {
              paramInt1 = -1;
              return paramInt1;
            }
            paramInt1 = paramInt2 - localc.sW;
          }
          else
          {
            paramInt1 = paramInt2;
            if (localc.bU == 0) {
              paramInt1 = paramInt2 + localc.sW;
            }
          }
        }
      }
    }
  }
  
  final void reset()
  {
    g(this.sO);
    g(this.sP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.a
 * JD-Core Version:    0.7.0.1
 */