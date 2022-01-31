package f.a.b;

import f.a.c.b;
import java.io.InputStream;
import java.io.OutputStream;

public final class a
{
  f.a.a.a xvg = new f.a.a.a();
  b xvh = new b();
  short[] xvi = new short['À'];
  short[] xvj = new short[12];
  short[] xvk = new short[12];
  short[] xvl = new short[12];
  short[] xvm = new short[12];
  short[] xvn = new short['À'];
  f.a.c.a[] xvo = new f.a.c.a[4];
  short[] xvp = new short[114];
  f.a.c.a xvq = new f.a.c.a(4);
  a xvr = new a();
  a xvs = new a();
  a.b xvt = new a.b(this);
  int xvu = -1;
  int xvv = -1;
  int xvw;
  
  public a()
  {
    int i = 0;
    while (i < 4)
    {
      this.xvo[i] = new f.a.c.a(6);
      i += 1;
    }
  }
  
  public final boolean a(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong)
  {
    this.xvh.xvM = paramInputStream;
    paramInputStream = this.xvg;
    paramInputStream.cVi();
    paramInputStream.xvf = paramOutputStream;
    paramInputStream = this.xvg;
    paramInputStream.xve = 0;
    paramInputStream.xqf = 0;
    b.c(this.xvi);
    b.c(this.xvn);
    b.c(this.xvj);
    b.c(this.xvk);
    b.c(this.xvl);
    b.c(this.xvm);
    b.c(this.xvp);
    paramInputStream = this.xvt;
    int k = paramInputStream.xvE;
    int m = paramInputStream.xvF;
    int j = 0;
    while (j < 1 << k + m)
    {
      b.c(paramInputStream.xvD[j].xvH);
      j += 1;
    }
    j = 0;
    while (j < 4)
    {
      b.c(this.xvo[j].xvJ);
      j += 1;
    }
    this.xvr.cVk();
    this.xvs.cVk();
    b.c(this.xvq.xvJ);
    paramInputStream = this.xvh;
    paramInputStream.tMt = 0;
    paramInputStream.xvL = -1;
    j = 0;
    while (j < 5)
    {
      paramInputStream.tMt = (paramInputStream.tMt << 8 | paramInputStream.xvM.read());
      j += 1;
    }
    int i1 = 0;
    k = 0;
    m = 0;
    j = 0;
    int n = 0;
    long l1 = 0L;
    int i2 = 0;
    int i5;
    int i3;
    int i4;
    int i6;
    if ((paramLong < 0L) || (l1 < paramLong))
    {
      i5 = (int)l1 & this.xvw;
      if (this.xvh.e(this.xvi, (i1 << 4) + i5) == 0)
      {
        paramInputStream = this.xvt;
        i3 = (int)l1;
        paramOutputStream = paramInputStream.xvD;
        i4 = paramInputStream.xvG;
        i5 = paramInputStream.xvE;
        paramInputStream = paramOutputStream[(((i2 & 0xFF) >>> 8 - paramInputStream.xvE) + ((i3 & i4) << i5))];
        int i;
        if (i1 < 7)
        {
          i2 = 1;
          if (i2 == 0)
          {
            paramOutputStream = this.xvh;
            i4 = this.xvg.KR(k);
            i3 = 1;
          }
        }
        else
        {
          do
          {
            i5 = i4 >> 7 & 0x1;
            i4 = (byte)(i4 << 1);
            i6 = paramOutputStream.e(paramInputStream.xvH, (i5 + 1 << 8) + i3);
            i2 = i3 << 1 | i6;
            if (i5 != i6)
            {
              for (;;)
              {
                i3 = i2;
                if (i2 >= 256) {
                  break;
                }
                i2 = paramOutputStream.e(paramInputStream.xvH, i2) | i2 << 1;
              }
              i2 = 0;
              break;
            }
            i3 = i2;
          } while (i2 < 256);
          i3 = i2;
          i = (byte)i3;
          label510:
          paramInputStream = this.xvg;
          paramOutputStream = paramInputStream.xvc;
          i2 = paramInputStream.xqf;
          paramInputStream.xqf = (i2 + 1);
          paramOutputStream[i2] = i;
          if (paramInputStream.xqf >= paramInputStream.xvd) {
            paramInputStream.cVj();
          }
          if (i1 >= 4) {
            break label622;
          }
          i1 = 0;
        }
        for (;;)
        {
          l1 = 1L + l1;
          i2 = i;
          break;
          paramOutputStream = this.xvh;
          i2 = 1;
          do
          {
            i3 = paramOutputStream.e(paramInputStream.xvH, i2) | i2 << 1;
            i2 = i3;
          } while (i3 < 256);
          i = (byte)i3;
          break label510;
          label622:
          if (i1 < 10) {
            i1 -= 3;
          } else {
            i1 -= 6;
          }
        }
      }
      if (this.xvh.e(this.xvj, i1) == 1) {
        if (this.xvh.e(this.xvk, i1) == 0)
        {
          if (this.xvh.e(this.xvn, (i1 << 4) + i5) != 0) {
            break label1621;
          }
          if (i1 < 7)
          {
            i1 = 9;
            label713:
            i3 = 1;
            i2 = n;
            n = i3;
          }
        }
      }
    }
    for (;;)
    {
      label724:
      if (n == 0)
      {
        i3 = this.xvs.a(this.xvh, i5) + 2;
        if (i1 < 7)
        {
          n = 8;
          label757:
          i1 = n;
          n = k;
          k = j;
          j = i3;
        }
      }
      for (;;)
      {
        if ((n >= l1) || (n >= this.xvv))
        {
          return false;
          i1 = 11;
          break label713;
          if (this.xvh.e(this.xvl, i1) == 0)
          {
            i4 = 0;
            i2 = n;
            i3 = k;
            k = m;
            n = i4;
            m = i3;
            break label724;
          }
          if (this.xvh.e(this.xvm, i1) == 0) {}
          for (;;)
          {
            i2 = m;
            m = j;
            j = i2;
            break;
            i2 = j;
            j = n;
            n = i2;
          }
          n = 11;
          break label757;
          i2 = this.xvr.a(this.xvh, i5) + 2;
          if (i1 < 7)
          {
            n = 7;
            paramInputStream = this.xvo;
            i1 = i2 - 2;
            if (i1 >= 4) {
              break label1063;
            }
          }
          int i7;
          for (;;)
          {
            i5 = paramInputStream[i1].a(this.xvh);
            if (i5 < 4) {
              break label1364;
            }
            i7 = (i5 >> 1) - 1;
            i6 = (i5 & 0x1 | 0x2) << i7;
            if (i5 >= 14) {
              break label1111;
            }
            paramInputStream = this.xvp;
            paramOutputStream = this.xvh;
            i4 = 1;
            i1 = 0;
            i3 = 0;
            while (i3 < i7)
            {
              int i8 = paramOutputStream.e(paramInputStream, i6 - i5 - 1 + i4);
              i4 = (i4 << 1) + i8;
              i1 |= i8 << i3;
              i3 += 1;
            }
            n = 10;
            break;
            label1063:
            i1 = 3;
          }
          i3 = j;
          i4 = k;
          i5 = i1 + i6;
          i1 = n;
          j = i2;
          i2 = i3;
          k = m;
          m = i4;
          n = i5;
          continue;
          label1111:
          paramInputStream = this.xvh;
          i3 = i7 - 4;
          i1 = 0;
          while (i3 != 0)
          {
            paramInputStream.xvL >>>= 1;
            i4 = paramInputStream.tMt - paramInputStream.xvL >>> 31;
            paramInputStream.tMt -= (paramInputStream.xvL & i4 - 1);
            i1 = i1 << 1 | 1 - i4;
            if ((paramInputStream.xvL & 0xFF000000) == 0)
            {
              paramInputStream.tMt = (paramInputStream.tMt << 8 | paramInputStream.xvM.read());
              paramInputStream.xvL <<= 8;
            }
            i3 -= 1;
          }
          paramInputStream = this.xvq;
          paramOutputStream = this.xvh;
          i5 = 1;
          i4 = 0;
          i3 = 0;
          while (i3 < paramInputStream.xvK)
          {
            i7 = paramOutputStream.e(paramInputStream.xvJ, i5);
            i5 = (i5 << 1) + i7;
            i4 |= i7 << i3;
            i3 += 1;
          }
          i4 = i6 + (i1 << 4) + i4;
          if (i4 < 0)
          {
            if (i4 == -1) {
              break label1563;
            }
            return false;
          }
          i1 = j;
          i3 = k;
          i5 = n;
          j = i2;
          i2 = i1;
          k = m;
          m = i3;
          n = i4;
          i1 = i5;
          continue;
          label1364:
          i1 = j;
          i3 = k;
          i4 = i5;
          i5 = n;
          j = i2;
          i2 = i1;
          k = m;
          m = i3;
          n = i4;
          i1 = i5;
          continue;
        }
        paramInputStream = this.xvg;
        i3 = paramInputStream.xqf - n - 1;
        if (i3 < 0)
        {
          i3 += paramInputStream.xvd;
          i4 = j;
        }
        for (;;)
        {
          if (i4 != 0)
          {
            i5 = i3;
            if (i3 >= paramInputStream.xvd) {
              i5 = 0;
            }
            paramOutputStream = paramInputStream.xvc;
            i3 = paramInputStream.xqf;
            paramInputStream.xqf = (i3 + 1);
            paramOutputStream[i3] = paramInputStream.xvc[i5];
            if (paramInputStream.xqf >= paramInputStream.xvd) {
              paramInputStream.cVj();
            }
            i4 -= 1;
            i3 = i5 + 1;
          }
          else
          {
            long l2 = j;
            i3 = this.xvg.KR(0);
            l1 = l2 + l1;
            j = k;
            k = n;
            n = i2;
            i2 = i3;
            break;
            label1563:
            this.xvg.cVj();
            this.xvg.cVi();
            this.xvh.xvM = null;
            return true;
            i4 = j;
          }
        }
        i4 = n;
        n = j;
        i3 = k;
        j = i4;
        k = n;
        n = i3;
      }
      label1621:
      i3 = 0;
      i2 = n;
      n = i3;
    }
  }
  
  public final boolean ck(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[0] & 0xFF;
    int m = i % 9;
    i /= 9;
    int n = i % 5;
    int k = i / 5;
    int j = 0;
    i = 0;
    while (j < 4)
    {
      i += ((paramArrayOfByte[(j + 1)] & 0xFF) << j * 8);
      j += 1;
    }
    if ((m > 8) || (n > 4) || (k > 4))
    {
      j = 0;
      if (j != 0) {
        break label225;
      }
    }
    label225:
    while (i < 0)
    {
      return false;
      paramArrayOfByte = this.xvt;
      if ((paramArrayOfByte.xvD == null) || (paramArrayOfByte.xvE != m) || (paramArrayOfByte.xvF != n))
      {
        paramArrayOfByte.xvF = n;
        paramArrayOfByte.xvG = ((1 << n) - 1);
        paramArrayOfByte.xvE = m;
        m = 1 << paramArrayOfByte.xvE + paramArrayOfByte.xvF;
        paramArrayOfByte.xvD = new a.b.a[m];
        j = 0;
        while (j < m)
        {
          paramArrayOfByte.xvD[j] = new a.b.a(paramArrayOfByte);
          j += 1;
        }
      }
      j = 1 << k;
      this.xvr.KS(j);
      this.xvs.KS(j);
      this.xvw = (j - 1);
      j = 1;
      break;
    }
    if (this.xvu != i)
    {
      this.xvu = i;
      this.xvv = Math.max(this.xvu, 1);
      paramArrayOfByte = this.xvg;
      i = Math.max(this.xvv, 4096);
      if ((paramArrayOfByte.xvc == null) || (paramArrayOfByte.xvd != i)) {
        paramArrayOfByte.xvc = new byte[i];
      }
      paramArrayOfByte.xvd = i;
      paramArrayOfByte.xqf = 0;
      paramArrayOfByte.xve = 0;
    }
    return true;
  }
  
  final class a
  {
    f.a.c.a xvA = new f.a.c.a(8);
    int xvB = 0;
    short[] xvx = new short[2];
    f.a.c.a[] xvy = new f.a.c.a[16];
    f.a.c.a[] xvz = new f.a.c.a[16];
    
    a() {}
    
    public final void KS(int paramInt)
    {
      while (this.xvB < paramInt)
      {
        this.xvy[this.xvB] = new f.a.c.a(3);
        this.xvz[this.xvB] = new f.a.c.a(3);
        this.xvB += 1;
      }
    }
    
    public final int a(b paramb, int paramInt)
    {
      if (paramb.e(this.xvx, 0) == 0) {
        return this.xvy[paramInt].a(paramb);
      }
      if (paramb.e(this.xvx, 1) == 0) {
        return this.xvz[paramInt].a(paramb) + 8;
      }
      return this.xvA.a(paramb) + 8 + 8;
    }
    
    public final void cVk()
    {
      b.c(this.xvx);
      int i = 0;
      while (i < this.xvB)
      {
        b.c(this.xvy[i].xvJ);
        b.c(this.xvz[i].xvJ);
        i += 1;
      }
      b.c(this.xvA.xvJ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     f.a.b.a
 * JD-Core Version:    0.7.0.1
 */