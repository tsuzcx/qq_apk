package g.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.c.b;
import java.io.InputStream;
import java.io.OutputStream;

public final class a
{
  g.a.c.a CSA;
  a.a CSB;
  a.a CSC;
  a.b CSD;
  int CSE;
  int CSF;
  int CSG;
  g.a.a.a CSq;
  b CSr;
  short[] CSs;
  short[] CSt;
  short[] CSu;
  short[] CSv;
  short[] CSw;
  short[] CSx;
  g.a.c.a[] CSy;
  short[] CSz;
  
  public a()
  {
    AppMethodBeat.i(86242);
    this.CSq = new g.a.a.a();
    this.CSr = new b();
    this.CSs = new short['À'];
    this.CSt = new short[12];
    this.CSu = new short[12];
    this.CSv = new short[12];
    this.CSw = new short[12];
    this.CSx = new short['À'];
    this.CSy = new g.a.c.a[4];
    this.CSz = new short[114];
    this.CSA = new g.a.c.a(4);
    this.CSB = new a.a(this);
    this.CSC = new a.a(this);
    this.CSD = new a.b(this);
    this.CSE = -1;
    this.CSF = -1;
    int i = 0;
    while (i < 4)
    {
      this.CSy[i] = new g.a.c.a(6);
      i += 1;
    }
    AppMethodBeat.o(86242);
  }
  
  public final boolean a(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong)
  {
    AppMethodBeat.i(86243);
    this.CSr.CSW = paramInputStream;
    paramInputStream = this.CSq;
    paramInputStream.erO();
    paramInputStream.CSp = paramOutputStream;
    paramInputStream = this.CSq;
    paramInputStream.CSo = 0;
    paramInputStream.CMs = 0;
    b.c(this.CSs);
    b.c(this.CSx);
    b.c(this.CSt);
    b.c(this.CSu);
    b.c(this.CSv);
    b.c(this.CSw);
    b.c(this.CSz);
    paramInputStream = this.CSD;
    int k = paramInputStream.CSO;
    int m = paramInputStream.CSP;
    int j = 0;
    while (j < 1 << k + m)
    {
      b.c(paramInputStream.CSN[j].CSR);
      j += 1;
    }
    j = 0;
    while (j < 4)
    {
      b.c(this.CSy[j].CST);
      j += 1;
    }
    this.CSB.erQ();
    this.CSC.erQ();
    b.c(this.CSA.CST);
    paramInputStream = this.CSr;
    paramInputStream.xRf = 0;
    paramInputStream.CSV = -1;
    j = 0;
    while (j < 5)
    {
      paramInputStream.xRf = (paramInputStream.xRf << 8 | paramInputStream.CSW.read());
      j += 1;
    }
    int i1 = 0;
    m = 0;
    k = 0;
    j = 0;
    int n = 0;
    int i2 = 0;
    long l = 0L;
    int i4;
    int i3;
    int i5;
    int i6;
    if ((paramLong < 0L) || (l < paramLong))
    {
      i4 = (int)l & this.CSG;
      if (this.CSr.g(this.CSs, (i1 << 4) + i4) == 0)
      {
        paramInputStream = this.CSD;
        i3 = (int)l;
        paramOutputStream = paramInputStream.CSN;
        i4 = paramInputStream.CSQ;
        i5 = paramInputStream.CSO;
        paramInputStream = paramOutputStream[(((i2 & 0xFF) >>> 8 - paramInputStream.CSO) + ((i3 & i4) << i5))];
        int i;
        if (i1 < 7)
        {
          i2 = 1;
          if (i2 == 0)
          {
            paramOutputStream = this.CSr;
            i4 = this.CSq.Wv(m);
            i3 = 1;
          }
        }
        else
        {
          do
          {
            i5 = i4 >> 7 & 0x1;
            i4 = (byte)(i4 << 1);
            i6 = paramOutputStream.g(paramInputStream.CSR, (i5 + 1 << 8) + i3);
            i2 = i3 << 1 | i6;
            if (i5 != i6)
            {
              for (;;)
              {
                i3 = i2;
                if (i2 >= 256) {
                  break;
                }
                i2 = paramOutputStream.g(paramInputStream.CSR, i2) | i2 << 1;
              }
              i2 = 0;
              break;
            }
            i3 = i2;
          } while (i2 < 256);
          i3 = i2;
          i = (byte)i3;
          label515:
          paramInputStream = this.CSq;
          paramOutputStream = paramInputStream.CSm;
          i2 = paramInputStream.CMs;
          paramInputStream.CMs = (i2 + 1);
          paramOutputStream[i2] = i;
          if (paramInputStream.CMs >= paramInputStream.CSn) {
            paramInputStream.erP();
          }
          if (i1 >= 4) {
            break label627;
          }
          i1 = 0;
        }
        for (;;)
        {
          l = 1L + l;
          i2 = i;
          break;
          paramOutputStream = this.CSr;
          i2 = 1;
          do
          {
            i3 = paramOutputStream.g(paramInputStream.CSR, i2) | i2 << 1;
            i2 = i3;
          } while (i3 < 256);
          i = (byte)i3;
          break label515;
          label627:
          if (i1 < 10) {
            i1 -= 3;
          } else {
            i1 -= 6;
          }
        }
      }
      if (this.CSr.g(this.CSt, i1) == 1)
      {
        i3 = 0;
        if (this.CSr.g(this.CSu, i1) == 0)
        {
          if (this.CSr.g(this.CSx, (i1 << 4) + i4) != 0) {
            break label1661;
          }
          if (i1 < 7)
          {
            i1 = 9;
            label721:
            i2 = 1;
          }
        }
      }
    }
    for (;;)
    {
      label724:
      if (i2 == 0)
      {
        i4 = this.CSC.a(this.CSr, i4) + 2;
        if (i1 < 7)
        {
          i1 = 8;
          label757:
          i3 = n;
          i2 = m;
          n = k;
          m = j;
          k = i3;
          j = i4;
        }
      }
      for (;;)
      {
        if ((i2 >= l) || (i2 >= this.CSF))
        {
          AppMethodBeat.o(86243);
          return false;
          i1 = 11;
          break label721;
          if (this.CSr.g(this.CSv, i1) == 0)
          {
            i2 = m;
            m = k;
            k = i2;
            i2 = i3;
            break label724;
          }
          if (this.CSr.g(this.CSw, i1) == 0) {}
          for (;;)
          {
            i2 = k;
            k = j;
            j = i2;
            break;
            i2 = n;
            n = j;
            j = i2;
          }
          i1 = 11;
          break label757;
          i2 = this.CSB.a(this.CSr, i4) + 2;
          if (i1 < 7)
          {
            n = 7;
            paramInputStream = this.CSy;
            i1 = i2 - 2;
            if (i1 >= 4) {
              break label1069;
            }
          }
          int i7;
          for (;;)
          {
            i5 = paramInputStream[i1].a(this.CSr);
            if (i5 < 4) {
              break label1383;
            }
            i7 = (i5 >> 1) - 1;
            i6 = (i5 & 0x1 | 0x2) << i7;
            if (i5 >= 14) {
              break label1121;
            }
            paramInputStream = this.CSz;
            paramOutputStream = this.CSr;
            i4 = 1;
            i1 = 0;
            i3 = 0;
            while (i3 < i7)
            {
              int i8 = paramOutputStream.g(paramInputStream, i6 - i5 - 1 + i4);
              i4 = (i4 << 1) + i8;
              i1 |= i8 << i3;
              i3 += 1;
            }
            n = 10;
            break;
            label1069:
            i1 = 3;
          }
          i3 = j;
          i4 = k;
          i5 = m;
          i6 = i1 + i6;
          i1 = n;
          j = i2;
          k = i3;
          m = i4;
          n = i5;
          i2 = i6;
          continue;
          label1121:
          paramInputStream = this.CSr;
          i3 = i7 - 4;
          i1 = 0;
          while (i3 != 0)
          {
            paramInputStream.CSV >>>= 1;
            i4 = paramInputStream.xRf - paramInputStream.CSV >>> 31;
            paramInputStream.xRf -= (paramInputStream.CSV & i4 - 1);
            i1 = i1 << 1 | 1 - i4;
            if ((paramInputStream.CSV & 0xFF000000) == 0)
            {
              paramInputStream.xRf = (paramInputStream.xRf << 8 | paramInputStream.CSW.read());
              paramInputStream.CSV <<= 8;
            }
            i3 -= 1;
          }
          paramInputStream = this.CSA;
          paramOutputStream = this.CSr;
          i5 = 1;
          i4 = 0;
          i3 = 0;
          while (i3 < paramInputStream.CSU)
          {
            i7 = paramOutputStream.g(paramInputStream.CST, i5);
            i5 = (i5 << 1) + i7;
            i4 |= i7 << i3;
            i3 += 1;
          }
          i5 = i6 + (i1 << 4) + i4;
          if (i5 < 0)
          {
            if (i5 == -1) {
              break label1590;
            }
            AppMethodBeat.o(86243);
            return false;
          }
          i1 = j;
          i3 = k;
          i4 = m;
          i6 = n;
          j = i2;
          k = i1;
          m = i3;
          n = i4;
          i2 = i5;
          i1 = i6;
          continue;
          label1383:
          i1 = j;
          i3 = k;
          i4 = m;
          i6 = n;
          j = i2;
          k = i1;
          m = i3;
          n = i4;
          i2 = i5;
          i1 = i6;
          continue;
        }
        paramInputStream = this.CSq;
        i3 = paramInputStream.CMs - i2 - 1;
        if (i3 < 0)
        {
          i3 += paramInputStream.CSn;
          i4 = j;
        }
        for (;;)
        {
          if (i4 != 0)
          {
            i5 = i3;
            if (i3 >= paramInputStream.CSn) {
              i5 = 0;
            }
            paramOutputStream = paramInputStream.CSm;
            i3 = paramInputStream.CMs;
            paramInputStream.CMs = (i3 + 1);
            paramOutputStream[i3] = paramInputStream.CSm[i5];
            if (paramInputStream.CMs >= paramInputStream.CSn) {
              paramInputStream.erP();
            }
            i4 -= 1;
            i3 = i5 + 1;
          }
          else
          {
            l += j;
            i4 = this.CSq.Wv(0);
            j = m;
            m = n;
            i3 = i2;
            i2 = i4;
            n = k;
            k = m;
            m = i3;
            break;
            label1590:
            this.CSq.erP();
            this.CSq.erO();
            this.CSr.CSW = null;
            AppMethodBeat.o(86243);
            return true;
            i4 = j;
          }
        }
        i3 = j;
        i4 = k;
        i5 = m;
        j = i2;
        k = n;
        m = i3;
        n = i4;
        i2 = i5;
      }
      label1661:
      i2 = i3;
    }
  }
  
  public final boolean cV(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(86244);
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
    if ((m > 8) || (n > 4) || (k > 4)) {}
    for (j = 0; j == 0; j = 1)
    {
      AppMethodBeat.o(86244);
      return false;
      paramArrayOfByte = this.CSD;
      if ((paramArrayOfByte.CSN == null) || (paramArrayOfByte.CSO != m) || (paramArrayOfByte.CSP != n))
      {
        paramArrayOfByte.CSP = n;
        paramArrayOfByte.CSQ = ((1 << n) - 1);
        paramArrayOfByte.CSO = m;
        m = 1 << paramArrayOfByte.CSO + paramArrayOfByte.CSP;
        paramArrayOfByte.CSN = new a.b.a[m];
        j = 0;
        while (j < m)
        {
          paramArrayOfByte.CSN[j] = new a.b.a(paramArrayOfByte);
          j += 1;
        }
      }
      j = 1 << k;
      this.CSB.Ww(j);
      this.CSC.Ww(j);
      this.CSG = (j - 1);
    }
    if (i < 0)
    {
      AppMethodBeat.o(86244);
      return false;
    }
    if (this.CSE != i)
    {
      this.CSE = i;
      this.CSF = Math.max(this.CSE, 1);
      paramArrayOfByte = this.CSq;
      i = Math.max(this.CSF, 4096);
      if ((paramArrayOfByte.CSm == null) || (paramArrayOfByte.CSn != i)) {
        paramArrayOfByte.CSm = new byte[i];
      }
      paramArrayOfByte.CSn = i;
      paramArrayOfByte.CMs = 0;
      paramArrayOfByte.CSo = 0;
    }
    AppMethodBeat.o(86244);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     g.a.b.a
 * JD-Core Version:    0.7.0.1
 */