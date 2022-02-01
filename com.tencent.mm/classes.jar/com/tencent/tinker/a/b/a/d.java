package com.tencent.tinker.a.b.a;

import com.tencent.tinker.a.a.j;

public final class d
{
  private final g Koq;
  
  public d(g paramg)
  {
    this.Koq = paramg;
  }
  
  public final void a(e parame)
  {
    Object localObject = this.Koq;
    ((a)localObject).Kon.mSize = 0;
    ((a)localObject).anh = 0;
    for (;;)
    {
      localObject = this.Koq;
      if (((a)localObject).anh < ((g)localObject).Kov.length) {}
      int i1;
      int n;
      for (int i = 1; i != 0; i = 0)
      {
        i1 = this.Koq.anh;
        n = this.Koq.read();
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
          throw new IllegalStateException("Unknown opcode: " + com.tencent.tinker.a.b.b.a.afq(i));
        }
      }
      parame.a(i1, n, 0, 1, 0, 0L);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, i1 + (byte)b.afk(n), 0L);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, b.afk(n));
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, (n >> 12 & 0xF) << 28 >> 28, n >> 8 & 0xF);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, 0L, b.afk(n));
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, 0L, n >> 8 & 0xF, n >> 12 & 0xF);
      continue;
      i = b.afk(n);
      parame.a(i1, n & 0xFF, 0, 1, i1 + (short)this.Koq.read(), i);
      continue;
      i = n & 0xFF;
      int j = b.afk(n);
      parame.a(i1, i, this.Koq.read(), b.afn(i), 0, 0L, j);
      continue;
      j = n & 0xFF;
      int k = b.afk(n);
      long l = (short)this.Koq.read();
      if (j == 21) {}
      for (i = 16;; i = 48)
      {
        parame.a(i1, j, 0, 1, 0, l << i, k);
        break;
      }
      i = b.afk(n);
      parame.a(i1, n & 0xFF, 0, 1, 0, (short)this.Koq.read(), i);
      continue;
      i = b.afk(n);
      parame.a(i1, n & 0xFF, 0, 1, i1 + (short)this.Koq.read(), 0L, i);
      continue;
      i = b.afk(n);
      j = this.Koq.read();
      parame.a(i1, n & 0xFF, 0, 1, 0, (byte)b.afk(j), i, j & 0xFF);
      continue;
      i = n & 0xFF;
      parame.a(i1, i, this.Koq.read(), b.afn(i), 0, 0L, n >> 8 & 0xF, n >> 12 & 0xF);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, (short)this.Koq.read(), n >> 8 & 0xF, n >> 12 & 0xF);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, i1 + (short)this.Koq.read(), 0L, n >> 8 & 0xF, n >> 12 & 0xF);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, 0L, b.afk(n), this.Koq.read());
      continue;
      i = b.afk(n);
      j = this.Koq.read();
      parame.a(i1, n & 0xFF, 0, 1, 0, 0L, i, j & 0xFF, b.afk(j));
      continue;
      i = b.afk(n);
      parame.a(i1, n & 0xFF, 0, 1, i1 + this.Koq.readInt(), i);
      continue;
      i = n & 0xFF;
      j = b.afk(n);
      parame.a(i1, i, this.Koq.readInt(), b.afn(i), 0, 0L, j);
      continue;
      i = b.afk(n);
      parame.a(i1, n & 0xFF, 0, 1, 0, this.Koq.readInt(), i);
      continue;
      i = n & 0xFF;
      j = b.afk(n);
      k = i1 + this.Koq.readInt();
      switch (i)
      {
      }
      for (;;)
      {
        parame.a(i1, i, 0, 1, k, 0L, j);
        break;
        this.Koq.kL(k + 1, i1);
      }
      i = b.afk(n);
      j = this.Koq.read();
      k = this.Koq.read();
      parame.a(i1, n & 0xFF, 0, 1, 0, i, j, k);
      continue;
      i = n & 0xFF;
      j = n >> 12 & 0xF;
      k = this.Koq.read();
      int i4 = this.Koq.read();
      int m = i4 & 0xF;
      int i2 = i4 >> 4 & 0xF;
      int i3 = i4 >> 8 & 0xF;
      i4 = i4 >> 12 & 0xF;
      int i5 = b.afn(i);
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
        j = b.afk(n);
        k = this.Koq.read();
        m = this.Koq.read();
        parame.b(i1, i, k, b.afn(i), 0, 0L, m, j);
        continue;
        i = b.afk(n);
        parame.a(i1, n & 0xFF, 0, 1, 0, this.Koq.readLong(), i);
        continue;
        i = this.Koq.read();
        i2 = this.Koq.readInt();
        switch (i)
        {
        case 3: 
        case 5: 
        case 6: 
        case 7: 
        default: 
          throw new j("bogus element_width: " + com.tencent.tinker.a.b.b.a.afr(i));
        case 1: 
          localObject = new byte[i2];
          i = 0;
          k = 0;
          j = 1;
          if (k < i2)
          {
            m = i;
            if (j != 0) {
              m = this.Koq.read();
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
          parame.a(i1, n, localObject, localObject.length, 1);
          break;
        case 2: 
          localObject = new short[i2];
          i = 0;
          while (i < i2)
          {
            localObject[i] = ((short)this.Koq.read());
            i += 1;
          }
          parame.a(i1, n, localObject, localObject.length, 2);
          break;
        case 4: 
          localObject = new int[i2];
          i = 0;
          while (i < i2)
          {
            localObject[i] = this.Koq.readInt();
            i += 1;
          }
          parame.a(i1, n, localObject, localObject.length, 4);
          break;
        case 8: 
          localObject = new long[i2];
          i = 0;
          while (i < i2)
          {
            localObject[i] = this.Koq.readLong();
            i += 1;
          }
          parame.a(i1, n, localObject, localObject.length, 8);
          continue;
          j = this.Koq.fHe();
          k = this.Koq.read();
          m = this.Koq.readInt();
          localObject = new int[k];
          i = 0;
          while (i < k)
          {
            localObject[i] = (this.Koq.readInt() + j);
            i += 1;
          }
          parame.a(i1, n, m, (int[])localObject);
          continue;
          j = this.Koq.fHe();
          k = this.Koq.read();
          localObject = new int[k];
          int[] arrayOfInt = new int[k];
          i = 0;
          while (i < k)
          {
            localObject[i] = this.Koq.readInt();
            i += 1;
          }
          i = 0;
          while (i < k)
          {
            arrayOfInt[i] = (this.Koq.readInt() + j);
            i += 1;
          }
          parame.a(i1, n, (int[])localObject, arrayOfInt);
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.b.a.d
 * JD-Core Version:    0.7.0.1
 */