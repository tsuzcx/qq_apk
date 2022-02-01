package com.tencent.tinker.a.b.a;

import com.tencent.tinker.a.a.j;

public final class d
{
  private final g ahPa;
  
  public d(g paramg)
  {
    this.ahPa = paramg;
  }
  
  public final void a(e parame)
  {
    Object localObject = this.ahPa;
    ((a)localObject).ahOX.mSize = 0;
    ((a)localObject).bGj = 0;
    for (;;)
    {
      localObject = this.ahPa;
      if (((a)localObject).bGj < ((g)localObject).ahPf.length) {}
      int i1;
      int n;
      for (int i = 1; i != 0; i = 0)
      {
        i1 = this.ahPa.bGj;
        n = this.ahPa.read();
        j = n & 0xFF;
        if (j != 0)
        {
          i = j;
          if (j != 255) {}
        }
        else
        {
          i = n;
        }
        switch (i)
        {
        default: 
          throw new IllegalStateException("Unknown opcode: " + com.tencent.tinker.a.b.b.a.aIz(i));
        }
      }
      parame.a(i1, n, 0, 1, 0, 0L);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, i1 + (byte)b.aIt(n), 0L);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, b.aIt(n));
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, (n >> 12 & 0xF) << 28 >> 28, n >> 8 & 0xF);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, 0L, b.aIt(n));
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, 0L, n >> 8 & 0xF, n >> 12 & 0xF);
      continue;
      i = b.aIt(n);
      parame.a(i1, n & 0xFF, 0, 1, i1 + (short)this.ahPa.read(), i);
      continue;
      i = n & 0xFF;
      int j = b.aIt(n);
      parame.a(i1, i, this.ahPa.read(), b.aIw(i), 0, 0L, j);
      continue;
      j = n & 0xFF;
      int k = b.aIt(n);
      long l = (short)this.ahPa.read();
      if (j == 21) {}
      for (i = 16;; i = 48)
      {
        parame.a(i1, j, 0, 1, 0, l << i, k);
        break;
      }
      i = b.aIt(n);
      parame.a(i1, n & 0xFF, 0, 1, 0, (short)this.ahPa.read(), i);
      continue;
      i = b.aIt(n);
      parame.a(i1, n & 0xFF, 0, 1, i1 + (short)this.ahPa.read(), 0L, i);
      continue;
      i = b.aIt(n);
      j = this.ahPa.read();
      parame.a(i1, n & 0xFF, 0, 1, 0, (byte)b.aIt(j), i, j & 0xFF);
      continue;
      i = n & 0xFF;
      parame.a(i1, i, this.ahPa.read(), b.aIw(i), 0, 0L, n >> 8 & 0xF, n >> 12 & 0xF);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, (short)this.ahPa.read(), n >> 8 & 0xF, n >> 12 & 0xF);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, i1 + (short)this.ahPa.read(), 0L, n >> 8 & 0xF, n >> 12 & 0xF);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, 0L, b.aIt(n), this.ahPa.read());
      continue;
      i = b.aIt(n);
      j = this.ahPa.read();
      parame.a(i1, n & 0xFF, 0, 1, 0, 0L, i, j & 0xFF, b.aIt(j));
      continue;
      i = b.aIt(n);
      parame.a(i1, n & 0xFF, 0, 1, i1 + this.ahPa.readInt(), i);
      continue;
      i = n & 0xFF;
      j = b.aIt(n);
      parame.a(i1, i, this.ahPa.readInt(), b.aIw(i), 0, 0L, j);
      continue;
      i = b.aIt(n);
      parame.a(i1, n & 0xFF, 0, 1, 0, this.ahPa.readInt(), i);
      continue;
      i = n & 0xFF;
      j = b.aIt(n);
      k = i1 + this.ahPa.readInt();
      switch (i)
      {
      }
      for (;;)
      {
        parame.a(i1, i, 0, 1, k, 0L, j);
        break;
        this.ahPa.pT(k + 1, i1);
      }
      i = b.aIt(n);
      j = this.ahPa.read();
      k = this.ahPa.read();
      parame.a(i1, n & 0xFF, 0, 1, 0, i, j, k);
      continue;
      i = n & 0xFF;
      j = n >> 12 & 0xF;
      k = this.ahPa.read();
      int i4 = this.ahPa.read();
      int m = i4 & 0xF;
      int i2 = i4 >> 4 & 0xF;
      int i3 = i4 >> 8 & 0xF;
      i4 = i4 >> 12 & 0xF;
      int i5 = b.aIw(i);
      switch (j)
      {
      default: 
        throw new j("bogus registerCount: " + new String(new char[] { Character.forDigit(j & 0xF, 16) }));
      case 0: 
        parame.a(i1, i, k, i5, 0, 0L);
        break;
      case 1: 
        parame.a(i1, i, k, i5, 0, 0L, m);
        break;
      case 2: 
        parame.a(i1, i, k, i5, 0, 0L, m, i2);
        break;
      case 3: 
        parame.a(i1, i, k, i5, 0, 0L, m, i2, i3);
        break;
      case 4: 
        parame.a(i1, i, k, i5, 0, 0L, m, i2, i3, i4);
        break;
      case 5: 
        parame.a(i1, i, k, i5, 0, 0L, m, i2, i3, i4, n >> 8 & 0xF);
        continue;
        i = n & 0xFF;
        j = b.aIt(n);
        k = this.ahPa.read();
        m = this.ahPa.read();
        parame.b(i1, i, k, b.aIw(i), 0, 0L, m, j);
        continue;
        i = b.aIt(n);
        parame.a(i1, n & 0xFF, 0, 1, 0, this.ahPa.readLong(), i);
        continue;
        i = this.ahPa.read();
        i2 = this.ahPa.readInt();
        switch (i)
        {
        case 3: 
        case 5: 
        case 6: 
        case 7: 
        default: 
          throw new j("bogus element_width: " + com.tencent.tinker.a.b.b.a.aIA(i));
        case 1: 
          localObject = new byte[i2];
          i = 0;
          k = 0;
          j = 1;
          if (k < i2)
          {
            m = i;
            if (j != 0) {
              m = this.ahPa.read();
            }
            localObject[k] = ((byte)(m & 0xFF));
            k += 1;
            if (j == 0) {}
            for (i = 1;; i = 0)
            {
              m >>= 8;
              j = i;
              i = m;
              break;
            }
          }
          parame.a(i1, n, localObject, i2, 1);
          break;
        case 2: 
          localObject = new short[i2];
          i = 0;
          while (i < i2)
          {
            localObject[i] = ((short)this.ahPa.read());
            i += 1;
          }
          parame.a(i1, n, localObject, i2, 2);
          break;
        case 4: 
          localObject = new int[i2];
          i = 0;
          while (i < i2)
          {
            localObject[i] = this.ahPa.readInt();
            i += 1;
          }
          parame.a(i1, n, localObject, i2, 4);
          break;
        case 8: 
          localObject = new long[i2];
          i = 0;
          while (i < i2)
          {
            localObject[i] = this.ahPa.readLong();
            i += 1;
          }
          parame.a(i1, n, localObject, i2, 8);
          continue;
          j = this.ahPa.kbY();
          k = this.ahPa.read();
          m = this.ahPa.readInt();
          localObject = new int[k];
          i = 0;
          while (i < k)
          {
            localObject[i] = (this.ahPa.readInt() + j);
            i += 1;
          }
          parame.a(i1, n, m, (int[])localObject);
          continue;
          j = this.ahPa.kbY();
          k = this.ahPa.read();
          localObject = new int[k];
          int[] arrayOfInt = new int[k];
          i = 0;
          while (i < k)
          {
            localObject[i] = this.ahPa.readInt();
            i += 1;
          }
          i = 0;
          while (i < k)
          {
            arrayOfInt[i] = (this.ahPa.readInt() + j);
            i += 1;
          }
          parame.a(i1, n, (int[])localObject, arrayOfInt);
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.tinker.a.b.a.d
 * JD-Core Version:    0.7.0.1
 */