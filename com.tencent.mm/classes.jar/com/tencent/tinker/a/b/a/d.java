package com.tencent.tinker.a.b.a;

import com.tencent.tinker.a.a.j;

public final class d
{
  private final g Meo;
  
  public d(g paramg)
  {
    this.Meo = paramg;
  }
  
  public final void a(e parame)
  {
    Object localObject = this.Meo;
    ((a)localObject).Mel.mSize = 0;
    ((a)localObject).aoY = 0;
    for (;;)
    {
      localObject = this.Meo;
      if (((a)localObject).aoY < ((g)localObject).Met.length) {}
      int i1;
      int n;
      for (int i = 1; i != 0; i = 0)
      {
        i1 = this.Meo.aoY;
        n = this.Meo.read();
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
          throw new IllegalStateException("Unknown opcode: " + com.tencent.tinker.a.b.b.a.ahQ(i));
        }
      }
      parame.a(i1, n, 0, 1, 0, 0L);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, i1 + (byte)b.ahK(n), 0L);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, b.ahK(n));
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, (n >> 12 & 0xF) << 28 >> 28, n >> 8 & 0xF);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, 0L, b.ahK(n));
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, 0L, n >> 8 & 0xF, n >> 12 & 0xF);
      continue;
      i = b.ahK(n);
      parame.a(i1, n & 0xFF, 0, 1, i1 + (short)this.Meo.read(), i);
      continue;
      i = n & 0xFF;
      int j = b.ahK(n);
      parame.a(i1, i, this.Meo.read(), b.ahN(i), 0, 0L, j);
      continue;
      j = n & 0xFF;
      int k = b.ahK(n);
      long l = (short)this.Meo.read();
      if (j == 21) {}
      for (i = 16;; i = 48)
      {
        parame.a(i1, j, 0, 1, 0, l << i, k);
        break;
      }
      i = b.ahK(n);
      parame.a(i1, n & 0xFF, 0, 1, 0, (short)this.Meo.read(), i);
      continue;
      i = b.ahK(n);
      parame.a(i1, n & 0xFF, 0, 1, i1 + (short)this.Meo.read(), 0L, i);
      continue;
      i = b.ahK(n);
      j = this.Meo.read();
      parame.a(i1, n & 0xFF, 0, 1, 0, (byte)b.ahK(j), i, j & 0xFF);
      continue;
      i = n & 0xFF;
      parame.a(i1, i, this.Meo.read(), b.ahN(i), 0, 0L, n >> 8 & 0xF, n >> 12 & 0xF);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, (short)this.Meo.read(), n >> 8 & 0xF, n >> 12 & 0xF);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, i1 + (short)this.Meo.read(), 0L, n >> 8 & 0xF, n >> 12 & 0xF);
      continue;
      parame.a(i1, n & 0xFF, 0, 1, 0, 0L, b.ahK(n), this.Meo.read());
      continue;
      i = b.ahK(n);
      j = this.Meo.read();
      parame.a(i1, n & 0xFF, 0, 1, 0, 0L, i, j & 0xFF, b.ahK(j));
      continue;
      i = b.ahK(n);
      parame.a(i1, n & 0xFF, 0, 1, i1 + this.Meo.readInt(), i);
      continue;
      i = n & 0xFF;
      j = b.ahK(n);
      parame.a(i1, i, this.Meo.readInt(), b.ahN(i), 0, 0L, j);
      continue;
      i = b.ahK(n);
      parame.a(i1, n & 0xFF, 0, 1, 0, this.Meo.readInt(), i);
      continue;
      i = n & 0xFF;
      j = b.ahK(n);
      k = i1 + this.Meo.readInt();
      switch (i)
      {
      }
      for (;;)
      {
        parame.a(i1, i, 0, 1, k, 0L, j);
        break;
        this.Meo.la(k + 1, i1);
      }
      i = b.ahK(n);
      j = this.Meo.read();
      k = this.Meo.read();
      parame.a(i1, n & 0xFF, 0, 1, 0, i, j, k);
      continue;
      i = n & 0xFF;
      j = n >> 12 & 0xF;
      k = this.Meo.read();
      int i4 = this.Meo.read();
      int m = i4 & 0xF;
      int i2 = i4 >> 4 & 0xF;
      int i3 = i4 >> 8 & 0xF;
      i4 = i4 >> 12 & 0xF;
      int i5 = b.ahN(i);
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
        j = b.ahK(n);
        k = this.Meo.read();
        m = this.Meo.read();
        parame.b(i1, i, k, b.ahN(i), 0, 0L, m, j);
        continue;
        i = b.ahK(n);
        parame.a(i1, n & 0xFF, 0, 1, 0, this.Meo.readLong(), i);
        continue;
        i = this.Meo.read();
        i2 = this.Meo.readInt();
        switch (i)
        {
        case 3: 
        case 5: 
        case 6: 
        case 7: 
        default: 
          throw new j("bogus element_width: " + com.tencent.tinker.a.b.b.a.ahR(i));
        case 1: 
          localObject = new byte[i2];
          i = 0;
          k = 0;
          j = 1;
          if (k < i2)
          {
            m = i;
            if (j != 0) {
              m = this.Meo.read();
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
            localObject[i] = ((short)this.Meo.read());
            i += 1;
          }
          parame.a(i1, n, localObject, localObject.length, 2);
          break;
        case 4: 
          localObject = new int[i2];
          i = 0;
          while (i < i2)
          {
            localObject[i] = this.Meo.readInt();
            i += 1;
          }
          parame.a(i1, n, localObject, localObject.length, 4);
          break;
        case 8: 
          localObject = new long[i2];
          i = 0;
          while (i < i2)
          {
            localObject[i] = this.Meo.readLong();
            i += 1;
          }
          parame.a(i1, n, localObject, localObject.length, 8);
          continue;
          j = this.Meo.fYq();
          k = this.Meo.read();
          m = this.Meo.readInt();
          localObject = new int[k];
          i = 0;
          while (i < k)
          {
            localObject[i] = (this.Meo.readInt() + j);
            i += 1;
          }
          parame.a(i1, n, m, (int[])localObject);
          continue;
          j = this.Meo.fYq();
          k = this.Meo.read();
          localObject = new int[k];
          int[] arrayOfInt = new int[k];
          i = 0;
          while (i < k)
          {
            localObject[i] = this.Meo.readInt();
            i += 1;
          }
          i = 0;
          while (i < k)
          {
            arrayOfInt[i] = (this.Meo.readInt() + j);
            i += 1;
          }
          parame.a(i1, n, (int[])localObject, arrayOfInt);
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.b.a.d
 * JD-Core Version:    0.7.0.1
 */