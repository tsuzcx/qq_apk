package com.tencent.tinker.a.b.a;

import com.tencent.tinker.a.a.j;

public final class d
{
  private final g Shn;
  
  public d(g paramg)
  {
    this.Shn = paramg;
  }
  
  public final void a(e parame)
  {
    Object localObject = this.Shn;
    ((a)localObject).Shk.mSize = 0;
    ((a)localObject).apk = 0;
    for (;;)
    {
      localObject = this.Shn;
      if (((a)localObject).apk < ((g)localObject).Shs.length) {}
      int i1;
      int n;
      for (int i = 1; i != 0; i = 0)
      {
        i1 = this.Shn.apk;
        n = this.Shn.read();
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
          throw new IllegalStateException("Unknown opcode: " + com.tencent.tinker.a.b.b.a.arZ(i));
        }
      }
      parame.a(i1, n, 0, 1, 0, 0L);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, i1 + (byte)b.arT(n), 0L);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, b.arT(n));
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, (n >> 12 & 0xF) << 28 >> 28, n >> 8 & 0xF);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, 0L, b.arT(n));
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, 0L, n >> 8 & 0xF, n >> 12 & 0xF);
      continue;
      i = b.arT(n);
      parame.a(i1, n & 0xFF, 0, 1, i1 + (short)this.Shn.read(), i);
      continue;
      i = n & 0xFF;
      int j = b.arT(n);
      parame.a(i1, i, this.Shn.read(), b.arW(i), 0, 0L, j);
      continue;
      j = n & 0xFF;
      int k = b.arT(n);
      long l = (short)this.Shn.read();
      if (j == 21) {}
      for (i = 16;; i = 48)
      {
        parame.a(i1, j, 0, 1, 0, l << i, k);
        break;
      }
      i = b.arT(n);
      parame.a(i1, n & 0xFF, 0, 1, 0, (short)this.Shn.read(), i);
      continue;
      i = b.arT(n);
      parame.a(i1, n & 0xFF, 0, 1, i1 + (short)this.Shn.read(), 0L, i);
      continue;
      i = b.arT(n);
      j = this.Shn.read();
      parame.a(i1, n & 0xFF, 0, 1, 0, (byte)b.arT(j), i, j & 0xFF);
      continue;
      i = n & 0xFF;
      parame.a(i1, i, this.Shn.read(), b.arW(i), 0, 0L, n >> 8 & 0xF, n >> 12 & 0xF);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, (short)this.Shn.read(), n >> 8 & 0xF, n >> 12 & 0xF);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, i1 + (short)this.Shn.read(), 0L, n >> 8 & 0xF, n >> 12 & 0xF);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, 0L, b.arT(n), this.Shn.read());
      continue;
      i = b.arT(n);
      j = this.Shn.read();
      parame.a(i1, n & 0xFF, 0, 1, 0, 0L, i, j & 0xFF, b.arT(j));
      continue;
      i = b.arT(n);
      parame.a(i1, n & 0xFF, 0, 1, i1 + this.Shn.readInt(), i);
      continue;
      i = n & 0xFF;
      j = b.arT(n);
      parame.a(i1, i, this.Shn.readInt(), b.arW(i), 0, 0L, j);
      continue;
      i = b.arT(n);
      parame.a(i1, n & 0xFF, 0, 1, 0, this.Shn.readInt(), i);
      continue;
      i = n & 0xFF;
      j = b.arT(n);
      k = i1 + this.Shn.readInt();
      switch (i)
      {
      }
      for (;;)
      {
        parame.a(i1, i, 0, 1, k, 0L, j);
        break;
        this.Shn.mF(k + 1, i1);
      }
      i = b.arT(n);
      j = this.Shn.read();
      k = this.Shn.read();
      parame.a(i1, n & 0xFF, 0, 1, 0, i, j, k);
      continue;
      i = n & 0xFF;
      j = n >> 12 & 0xF;
      k = this.Shn.read();
      int i4 = this.Shn.read();
      int m = i4 & 0xF;
      int i2 = i4 >> 4 & 0xF;
      int i3 = i4 >> 8 & 0xF;
      i4 = i4 >> 12 & 0xF;
      int i5 = b.arW(i);
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
        j = b.arT(n);
        k = this.Shn.read();
        m = this.Shn.read();
        parame.b(i1, i, k, b.arW(i), 0, 0L, m, j);
        continue;
        i = b.arT(n);
        parame.a(i1, n & 0xFF, 0, 1, 0, this.Shn.readLong(), i);
        continue;
        i = this.Shn.read();
        i2 = this.Shn.readInt();
        switch (i)
        {
        case 3: 
        case 5: 
        case 6: 
        case 7: 
        default: 
          throw new j("bogus element_width: " + com.tencent.tinker.a.b.b.a.asa(i));
        case 1: 
          localObject = new byte[i2];
          i = 0;
          k = 0;
          j = 1;
          if (k < i2)
          {
            m = i;
            if (j != 0) {
              m = this.Shn.read();
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
            localObject[i] = ((short)this.Shn.read());
            i += 1;
          }
          parame.a(i1, n, localObject, localObject.length, 2);
          break;
        case 4: 
          localObject = new int[i2];
          i = 0;
          while (i < i2)
          {
            localObject[i] = this.Shn.readInt();
            i += 1;
          }
          parame.a(i1, n, localObject, localObject.length, 4);
          break;
        case 8: 
          localObject = new long[i2];
          i = 0;
          while (i < i2)
          {
            localObject[i] = this.Shn.readLong();
            i += 1;
          }
          parame.a(i1, n, localObject, localObject.length, 8);
          continue;
          j = this.Shn.hoX();
          k = this.Shn.read();
          m = this.Shn.readInt();
          localObject = new int[k];
          i = 0;
          while (i < k)
          {
            localObject[i] = (this.Shn.readInt() + j);
            i += 1;
          }
          parame.a(i1, n, m, (int[])localObject);
          continue;
          j = this.Shn.hoX();
          k = this.Shn.read();
          localObject = new int[k];
          int[] arrayOfInt = new int[k];
          i = 0;
          while (i < k)
          {
            localObject[i] = this.Shn.readInt();
            i += 1;
          }
          i = 0;
          while (i < k)
          {
            arrayOfInt[i] = (this.Shn.readInt() + j);
            i += 1;
          }
          parame.a(i1, n, (int[])localObject, arrayOfInt);
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.a.b.a.d
 * JD-Core Version:    0.7.0.1
 */