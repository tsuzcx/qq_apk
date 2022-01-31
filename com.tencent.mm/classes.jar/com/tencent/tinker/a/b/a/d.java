package com.tencent.tinker.a.b.a;

import com.tencent.tinker.a.a.j;

public final class d
{
  private final g wTI;
  
  public d(g paramg)
  {
    this.wTI = paramg;
  }
  
  public final void a(e parame)
  {
    Object localObject = this.wTI;
    ((a)localObject).wTE.mSize = 0;
    ((a)localObject).wTF = 0;
    for (;;)
    {
      localObject = this.wTI;
      if (((a)localObject).wTF < ((g)localObject).wTN.length) {}
      int n;
      int m;
      for (int i = 1; i != 0; i = 0)
      {
        n = this.wTI.wTF;
        m = this.wTI.read();
        j = m & 0xFF;
        if (j != 0)
        {
          i = j;
          if (j != 255) {}
        }
        else
        {
          i = m;
        }
        switch (i)
        {
        default: 
          throw new IllegalStateException("Unknown opcode: " + com.tencent.tinker.a.b.b.a.JO(i));
        }
      }
      parame.a(n, m, 0, 1, 0, 0L);
      continue;
      parame.a(n, m & 0xFF, 0, 1, n + (byte)b.JI(m), 0L);
      continue;
      parame.a(n, m & 0xFF, 0, 1, 0, b.JI(m));
      continue;
      parame.a(n, m & 0xFF, 0, 1, 0, (m >> 12 & 0xF) << 28 >> 28, m >> 8 & 0xF);
      continue;
      parame.a(n, m & 0xFF, 0, 1, 0, 0L, b.JI(m));
      continue;
      parame.a(n, m & 0xFF, 0, 1, 0, 0L, m >> 8 & 0xF, m >> 12 & 0xF);
      continue;
      i = b.JI(m);
      parame.a(n, m & 0xFF, 0, 1, n + (short)this.wTI.read(), i);
      continue;
      i = m & 0xFF;
      int j = b.JI(m);
      parame.a(n, i, this.wTI.read(), b.JL(i), 0, 0L, j);
      continue;
      j = m & 0xFF;
      int k = b.JI(m);
      long l = (short)this.wTI.read();
      if (j == 21) {}
      for (i = 16;; i = 48)
      {
        parame.a(n, j, 0, 1, 0, l << i, k);
        break;
      }
      i = b.JI(m);
      parame.a(n, m & 0xFF, 0, 1, 0, (short)this.wTI.read(), i);
      continue;
      i = b.JI(m);
      parame.a(n, m & 0xFF, 0, 1, n + (short)this.wTI.read(), 0L, i);
      continue;
      i = b.JI(m);
      j = this.wTI.read();
      parame.a(n, m & 0xFF, 0, 1, 0, (byte)b.JI(j), i, j & 0xFF);
      continue;
      i = m & 0xFF;
      parame.a(n, i, this.wTI.read(), b.JL(i), 0, 0L, m >> 8 & 0xF, m >> 12 & 0xF);
      continue;
      parame.a(n, m & 0xFF, 0, 1, 0, (short)this.wTI.read(), m >> 8 & 0xF, m >> 12 & 0xF);
      continue;
      parame.a(n, m & 0xFF, 0, 1, n + (short)this.wTI.read(), 0L, m >> 8 & 0xF, m >> 12 & 0xF);
      continue;
      parame.a(n, m & 0xFF, 0, 1, 0, 0L, b.JI(m), this.wTI.read());
      continue;
      i = b.JI(m);
      j = this.wTI.read();
      parame.a(n, m & 0xFF, 0, 1, 0, 0L, i, j & 0xFF, b.JI(j));
      continue;
      i = b.JI(m);
      parame.a(n, m & 0xFF, 0, 1, n + this.wTI.readInt(), i);
      continue;
      i = m & 0xFF;
      j = b.JI(m);
      parame.a(n, i, this.wTI.readInt(), b.JL(i), 0, 0L, j);
      continue;
      i = b.JI(m);
      parame.a(n, m & 0xFF, 0, 1, 0, this.wTI.readInt(), i);
      continue;
      i = m & 0xFF;
      j = b.JI(m);
      k = n + this.wTI.readInt();
      switch (i)
      {
      }
      for (;;)
      {
        parame.a(n, i, 0, 1, k, 0L, j);
        break;
        this.wTI.gj(k + 1, n);
      }
      i = b.JI(m);
      j = this.wTI.read();
      k = this.wTI.read();
      parame.a(n, m & 0xFF, 0, 1, 0, i, j, k);
      continue;
      i = m & 0xFF;
      j = m >> 12 & 0xF;
      k = this.wTI.read();
      int i4 = this.wTI.read();
      int i1 = i4 & 0xF;
      int i2 = i4 >> 4 & 0xF;
      int i3 = i4 >> 8 & 0xF;
      i4 = i4 >> 12 & 0xF;
      int i5 = b.JL(i);
      switch (j)
      {
      default: 
        throw new j("bogus registerCount: " + new String(new char[] { Character.forDigit(j & 0xF, 16) }));
      case 0: 
        parame.a(n, i, k, i5, 0, 0L);
        break;
      case 1: 
        parame.a(n, i, k, i5, 0, 0L, i1);
        break;
      case 2: 
        parame.a(n, i, k, i5, 0, 0L, i1, i2);
        break;
      case 3: 
        parame.a(n, i, k, i5, 0, 0L, i1, i2, i3);
        break;
      case 4: 
        parame.a(n, i, k, i5, 0, 0L, i1, i2, i3, i4);
        break;
      case 5: 
        parame.a(n, i, k, i5, 0, 0L, i1, i2, i3, i4, m >> 8 & 0xF);
        continue;
        i = m & 0xFF;
        j = b.JI(m);
        k = this.wTI.read();
        m = this.wTI.read();
        parame.b(n, i, k, b.JL(i), 0, 0L, m, j);
        continue;
        i = b.JI(m);
        parame.a(n, m & 0xFF, 0, 1, 0, this.wTI.readLong(), i);
        continue;
        i = this.wTI.read();
        i1 = this.wTI.readInt();
        switch (i)
        {
        case 3: 
        case 5: 
        case 6: 
        case 7: 
        default: 
          throw new j("bogus element_width: " + com.tencent.tinker.a.b.b.a.JP(i));
        case 1: 
          localObject = new byte[i1];
          j = 1;
          i = 0;
          k = 0;
          if (k < i1)
          {
            if (j != 0) {
              i = this.wTI.read();
            }
            localObject[k] = ((byte)(i & 0xFF));
            k += 1;
            if (j == 0) {}
            for (j = 1;; j = 0)
            {
              i >>= 8;
              break;
            }
          }
          parame.a(n, m, localObject, localObject.length, 1);
          break;
        case 2: 
          localObject = new short[i1];
          i = 0;
          while (i < i1)
          {
            localObject[i] = ((short)this.wTI.read());
            i += 1;
          }
          parame.a(n, m, localObject, localObject.length, 2);
          break;
        case 4: 
          localObject = new int[i1];
          i = 0;
          while (i < i1)
          {
            localObject[i] = this.wTI.readInt();
            i += 1;
          }
          parame.a(n, m, localObject, localObject.length, 4);
          break;
        case 8: 
          localObject = new long[i1];
          i = 0;
          while (i < i1)
          {
            localObject[i] = this.wTI.readLong();
            i += 1;
          }
          parame.a(n, m, localObject, localObject.length, 8);
          continue;
          j = this.wTI.cQB();
          k = this.wTI.read();
          i1 = this.wTI.readInt();
          localObject = new int[k];
          i = 0;
          while (i < k)
          {
            localObject[i] = (this.wTI.readInt() + j);
            i += 1;
          }
          parame.a(n, m, i1, (int[])localObject);
          continue;
          j = this.wTI.cQB();
          k = this.wTI.read();
          localObject = new int[k];
          int[] arrayOfInt = new int[k];
          i = 0;
          while (i < k)
          {
            localObject[i] = this.wTI.readInt();
            i += 1;
          }
          i = 0;
          while (i < k)
          {
            arrayOfInt[i] = (this.wTI.readInt() + j);
            i += 1;
          }
          parame.a(n, m, (int[])localObject, arrayOfInt);
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tinker.a.b.a.d
 * JD-Core Version:    0.7.0.1
 */