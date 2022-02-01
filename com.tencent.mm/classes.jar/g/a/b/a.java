package g.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.c.b;
import java.io.InputStream;
import java.io.OutputStream;

public final class a
{
  a KtA;
  b KtB;
  int KtC;
  int KtD;
  int KtE;
  g.a.a.a Kto;
  b Ktp;
  short[] Ktq;
  short[] Ktr;
  short[] Kts;
  short[] Ktt;
  short[] Ktu;
  short[] Ktv;
  g.a.c.a[] Ktw;
  short[] Ktx;
  g.a.c.a Kty;
  a Ktz;
  
  public a()
  {
    AppMethodBeat.i(155357);
    this.Kto = new g.a.a.a();
    this.Ktp = new b();
    this.Ktq = new short['À'];
    this.Ktr = new short[12];
    this.Kts = new short[12];
    this.Ktt = new short[12];
    this.Ktu = new short[12];
    this.Ktv = new short['À'];
    this.Ktw = new g.a.c.a[4];
    this.Ktx = new short[114];
    this.Kty = new g.a.c.a(4);
    this.Ktz = new a();
    this.KtA = new a();
    this.KtB = new b();
    this.KtC = -1;
    this.KtD = -1;
    int i = 0;
    while (i < 4)
    {
      this.Ktw[i] = new g.a.c.a(6);
      i += 1;
    }
    AppMethodBeat.o(155357);
  }
  
  public final boolean a(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong)
  {
    AppMethodBeat.i(155358);
    this.Ktp.KtU = paramInputStream;
    paramInputStream = this.Kto;
    paramInputStream.fOk();
    paramInputStream.Ktn = paramOutputStream;
    paramInputStream = this.Kto;
    paramInputStream.Ktm = 0;
    paramInputStream.KhZ = 0;
    b.c(this.Ktq);
    b.c(this.Ktv);
    b.c(this.Ktr);
    b.c(this.Kts);
    b.c(this.Ktt);
    b.c(this.Ktu);
    b.c(this.Ktx);
    paramInputStream = this.KtB;
    int k = paramInputStream.KtM;
    int m = paramInputStream.KtN;
    int j = 0;
    while (j < 1 << k + m)
    {
      b.c(paramInputStream.KtL[j].KtP);
      j += 1;
    }
    j = 0;
    while (j < 4)
    {
      b.c(this.Ktw[j].KtR);
      j += 1;
    }
    this.Ktz.fOm();
    this.KtA.fOm();
    b.c(this.Kty.KtR);
    paramInputStream = this.Ktp;
    paramInputStream.Epz = 0;
    paramInputStream.KtT = -1;
    j = 0;
    while (j < 5)
    {
      paramInputStream.Epz = (paramInputStream.Epz << 8 | paramInputStream.KtU.read());
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
      i4 = (int)l & this.KtE;
      if (this.Ktp.f(this.Ktq, (i1 << 4) + i4) == 0)
      {
        paramInputStream = this.KtB;
        i3 = (int)l;
        paramOutputStream = paramInputStream.KtL;
        i4 = paramInputStream.KtO;
        i5 = paramInputStream.KtM;
        paramInputStream = paramOutputStream[(((i2 & 0xFF) >>> 8 - paramInputStream.KtM) + ((i3 & i4) << i5))];
        int i;
        if (i1 < 7)
        {
          i2 = 1;
          if (i2 == 0)
          {
            paramOutputStream = this.Ktp;
            i4 = this.Kto.agu(m);
            i3 = 1;
          }
        }
        else
        {
          do
          {
            i5 = i4 >> 7 & 0x1;
            i4 = (byte)(i4 << 1);
            i6 = paramOutputStream.f(paramInputStream.KtP, (i5 + 1 << 8) + i3);
            i2 = i3 << 1 | i6;
            if (i5 != i6)
            {
              for (;;)
              {
                i3 = i2;
                if (i2 >= 256) {
                  break;
                }
                i2 = paramOutputStream.f(paramInputStream.KtP, i2) | i2 << 1;
              }
              i2 = 0;
              break;
            }
            i3 = i2;
          } while (i2 < 256);
          i3 = i2;
          i = (byte)i3;
          label515:
          paramInputStream = this.Kto;
          paramOutputStream = paramInputStream.Ktk;
          i2 = paramInputStream.KhZ;
          paramInputStream.KhZ = (i2 + 1);
          paramOutputStream[i2] = i;
          if (paramInputStream.KhZ >= paramInputStream.Ktl) {
            paramInputStream.fOl();
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
          paramOutputStream = this.Ktp;
          i2 = 1;
          do
          {
            i3 = paramOutputStream.f(paramInputStream.KtP, i2) | i2 << 1;
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
      if (this.Ktp.f(this.Ktr, i1) == 1)
      {
        i3 = 0;
        if (this.Ktp.f(this.Kts, i1) == 0)
        {
          if (this.Ktp.f(this.Ktv, (i1 << 4) + i4) != 0) {
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
        i4 = this.KtA.a(this.Ktp, i4) + 2;
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
        if ((i2 >= l) || (i2 >= this.KtD))
        {
          AppMethodBeat.o(155358);
          return false;
          i1 = 11;
          break label721;
          if (this.Ktp.f(this.Ktt, i1) == 0)
          {
            i2 = m;
            m = k;
            k = i2;
            i2 = i3;
            break label724;
          }
          if (this.Ktp.f(this.Ktu, i1) == 0) {}
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
          i2 = this.Ktz.a(this.Ktp, i4) + 2;
          if (i1 < 7)
          {
            n = 7;
            paramInputStream = this.Ktw;
            i1 = i2 - 2;
            if (i1 >= 4) {
              break label1069;
            }
          }
          int i7;
          for (;;)
          {
            i5 = paramInputStream[i1].a(this.Ktp);
            if (i5 < 4) {
              break label1383;
            }
            i7 = (i5 >> 1) - 1;
            i6 = (i5 & 0x1 | 0x2) << i7;
            if (i5 >= 14) {
              break label1121;
            }
            paramInputStream = this.Ktx;
            paramOutputStream = this.Ktp;
            i4 = 1;
            i1 = 0;
            i3 = 0;
            while (i3 < i7)
            {
              int i8 = paramOutputStream.f(paramInputStream, i6 - i5 - 1 + i4);
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
          paramInputStream = this.Ktp;
          i3 = i7 - 4;
          i1 = 0;
          while (i3 != 0)
          {
            paramInputStream.KtT >>>= 1;
            i4 = paramInputStream.Epz - paramInputStream.KtT >>> 31;
            paramInputStream.Epz -= (paramInputStream.KtT & i4 - 1);
            i1 = i1 << 1 | 1 - i4;
            if ((paramInputStream.KtT & 0xFF000000) == 0)
            {
              paramInputStream.Epz = (paramInputStream.Epz << 8 | paramInputStream.KtU.read());
              paramInputStream.KtT <<= 8;
            }
            i3 -= 1;
          }
          paramInputStream = this.Kty;
          paramOutputStream = this.Ktp;
          i5 = 1;
          i4 = 0;
          i3 = 0;
          while (i3 < paramInputStream.KtS)
          {
            i7 = paramOutputStream.f(paramInputStream.KtR, i5);
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
            AppMethodBeat.o(155358);
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
        paramInputStream = this.Kto;
        i3 = paramInputStream.KhZ - i2 - 1;
        if (i3 < 0)
        {
          i3 += paramInputStream.Ktl;
          i4 = j;
        }
        for (;;)
        {
          if (i4 != 0)
          {
            i5 = i3;
            if (i3 >= paramInputStream.Ktl) {
              i5 = 0;
            }
            paramOutputStream = paramInputStream.Ktk;
            i3 = paramInputStream.KhZ;
            paramInputStream.KhZ = (i3 + 1);
            paramOutputStream[i3] = paramInputStream.Ktk[i5];
            if (paramInputStream.KhZ >= paramInputStream.Ktl) {
              paramInputStream.fOl();
            }
            i4 -= 1;
            i3 = i5 + 1;
          }
          else
          {
            l += j;
            i4 = this.Kto.agu(0);
            j = m;
            m = n;
            i3 = i2;
            i2 = i4;
            n = k;
            k = m;
            m = i3;
            break;
            label1590:
            this.Kto.fOl();
            this.Kto.fOk();
            this.Ktp.KtU = null;
            AppMethodBeat.o(155358);
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
  
  public final boolean dn(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(155359);
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
      AppMethodBeat.o(155359);
      return false;
      paramArrayOfByte = this.KtB;
      if ((paramArrayOfByte.KtL == null) || (paramArrayOfByte.KtM != m) || (paramArrayOfByte.KtN != n))
      {
        paramArrayOfByte.KtN = n;
        paramArrayOfByte.KtO = ((1 << n) - 1);
        paramArrayOfByte.KtM = m;
        m = 1 << paramArrayOfByte.KtM + paramArrayOfByte.KtN;
        paramArrayOfByte.KtL = new a.b.a[m];
        j = 0;
        while (j < m)
        {
          paramArrayOfByte.KtL[j] = new a.b.a(paramArrayOfByte);
          j += 1;
        }
      }
      j = 1 << k;
      this.Ktz.agv(j);
      this.KtA.agv(j);
      this.KtE = (j - 1);
    }
    if (i < 0)
    {
      AppMethodBeat.o(155359);
      return false;
    }
    if (this.KtC != i)
    {
      this.KtC = i;
      this.KtD = Math.max(this.KtC, 1);
      paramArrayOfByte = this.Kto;
      i = Math.max(this.KtD, 4096);
      if ((paramArrayOfByte.Ktk == null) || (paramArrayOfByte.Ktl != i)) {
        paramArrayOfByte.Ktk = new byte[i];
      }
      paramArrayOfByte.Ktl = i;
      paramArrayOfByte.KhZ = 0;
      paramArrayOfByte.Ktm = 0;
    }
    AppMethodBeat.o(155359);
    return true;
  }
  
  final class a
  {
    short[] KtF;
    g.a.c.a[] KtG;
    g.a.c.a[] KtH;
    g.a.c.a KtI;
    int KtJ;
    
    a()
    {
      AppMethodBeat.i(155352);
      this.KtF = new short[2];
      this.KtG = new g.a.c.a[16];
      this.KtH = new g.a.c.a[16];
      this.KtI = new g.a.c.a(8);
      this.KtJ = 0;
      AppMethodBeat.o(155352);
    }
    
    public final int a(b paramb, int paramInt)
    {
      AppMethodBeat.i(155355);
      if (paramb.f(this.KtF, 0) == 0)
      {
        paramInt = this.KtG[paramInt].a(paramb);
        AppMethodBeat.o(155355);
        return paramInt;
      }
      if (paramb.f(this.KtF, 1) == 0) {}
      for (paramInt = this.KtH[paramInt].a(paramb) + 8;; paramInt = this.KtI.a(paramb) + 8 + 8)
      {
        AppMethodBeat.o(155355);
        return paramInt;
      }
    }
    
    public final void agv(int paramInt)
    {
      AppMethodBeat.i(155353);
      while (this.KtJ < paramInt)
      {
        this.KtG[this.KtJ] = new g.a.c.a(3);
        this.KtH[this.KtJ] = new g.a.c.a(3);
        this.KtJ += 1;
      }
      AppMethodBeat.o(155353);
    }
    
    public final void fOm()
    {
      AppMethodBeat.i(155354);
      b.c(this.KtF);
      int i = 0;
      while (i < this.KtJ)
      {
        b.c(this.KtG[i].KtR);
        b.c(this.KtH[i].KtR);
        i += 1;
      }
      b.c(this.KtI.KtR);
      AppMethodBeat.o(155354);
    }
  }
  
  final class b
  {
    a[] KtL;
    int KtM;
    int KtN;
    int KtO;
    
    b() {}
    
    final class a
    {
      short[] KtP;
      
      a()
      {
        AppMethodBeat.i(155356);
        this.KtP = new short[768];
        AppMethodBeat.o(155356);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     g.a.b.a
 * JD-Core Version:    0.7.0.1
 */