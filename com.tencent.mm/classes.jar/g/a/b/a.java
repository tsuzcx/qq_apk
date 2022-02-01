package g.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.c.b;
import java.io.InputStream;
import java.io.OutputStream;

public final class a
{
  g.a.a.a MgX;
  b MgY;
  short[] MgZ;
  short[] Mha;
  short[] Mhb;
  short[] Mhc;
  short[] Mhd;
  short[] Mhe;
  g.a.c.a[] Mhf;
  short[] Mhg;
  g.a.c.a Mhh;
  a Mhi;
  a Mhj;
  b Mhk;
  int Mhl;
  int Mhm;
  int Mhn;
  
  public a()
  {
    AppMethodBeat.i(155357);
    this.MgX = new g.a.a.a();
    this.MgY = new b();
    this.MgZ = new short['À'];
    this.Mha = new short[12];
    this.Mhb = new short[12];
    this.Mhc = new short[12];
    this.Mhd = new short[12];
    this.Mhe = new short['À'];
    this.Mhf = new g.a.c.a[4];
    this.Mhg = new short[114];
    this.Mhh = new g.a.c.a(4);
    this.Mhi = new a();
    this.Mhj = new a();
    this.Mhk = new b();
    this.Mhl = -1;
    this.Mhm = -1;
    int i = 0;
    while (i < 4)
    {
      this.Mhf[i] = new g.a.c.a(6);
      i += 1;
    }
    AppMethodBeat.o(155357);
  }
  
  public final boolean a(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong)
  {
    AppMethodBeat.i(155358);
    this.MgY.MhD = paramInputStream;
    paramInputStream = this.MgX;
    paramInputStream.gha();
    paramInputStream.MgW = paramOutputStream;
    paramInputStream = this.MgX;
    paramInputStream.MgV = 0;
    paramInputStream.LVI = 0;
    b.c(this.MgZ);
    b.c(this.Mhe);
    b.c(this.Mha);
    b.c(this.Mhb);
    b.c(this.Mhc);
    b.c(this.Mhd);
    b.c(this.Mhg);
    paramInputStream = this.Mhk;
    int k = paramInputStream.Mhv;
    int m = paramInputStream.Mhw;
    int j = 0;
    while (j < 1 << k + m)
    {
      b.c(paramInputStream.Mhu[j].Mhy);
      j += 1;
    }
    j = 0;
    while (j < 4)
    {
      b.c(this.Mhf[j].MhA);
      j += 1;
    }
    this.Mhi.ghc();
    this.Mhj.ghc();
    b.c(this.Mhh.MhA);
    paramInputStream = this.MgY;
    paramInputStream.FMB = 0;
    paramInputStream.MhC = -1;
    j = 0;
    while (j < 5)
    {
      paramInputStream.FMB = (paramInputStream.FMB << 8 | paramInputStream.MhD.read());
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
      i4 = (int)l & this.Mhn;
      if (this.MgY.f(this.MgZ, (i1 << 4) + i4) == 0)
      {
        paramInputStream = this.Mhk;
        i3 = (int)l;
        paramOutputStream = paramInputStream.Mhu;
        i4 = paramInputStream.Mhx;
        i5 = paramInputStream.Mhv;
        paramInputStream = paramOutputStream[(((i2 & 0xFF) >>> 8 - paramInputStream.Mhv) + ((i3 & i4) << i5))];
        int i;
        if (i1 < 7)
        {
          i2 = 1;
          if (i2 == 0)
          {
            paramOutputStream = this.MgY;
            i4 = this.MgX.ajq(m);
            i3 = 1;
          }
        }
        else
        {
          do
          {
            i5 = i4 >> 7 & 0x1;
            i4 = (byte)(i4 << 1);
            i6 = paramOutputStream.f(paramInputStream.Mhy, (i5 + 1 << 8) + i3);
            i2 = i3 << 1 | i6;
            if (i5 != i6)
            {
              for (;;)
              {
                i3 = i2;
                if (i2 >= 256) {
                  break;
                }
                i2 = paramOutputStream.f(paramInputStream.Mhy, i2) | i2 << 1;
              }
              i2 = 0;
              break;
            }
            i3 = i2;
          } while (i2 < 256);
          i3 = i2;
          i = (byte)i3;
          label515:
          paramInputStream = this.MgX;
          paramOutputStream = paramInputStream.MgT;
          i2 = paramInputStream.LVI;
          paramInputStream.LVI = (i2 + 1);
          paramOutputStream[i2] = i;
          if (paramInputStream.LVI >= paramInputStream.MgU) {
            paramInputStream.ghb();
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
          paramOutputStream = this.MgY;
          i2 = 1;
          do
          {
            i3 = paramOutputStream.f(paramInputStream.Mhy, i2) | i2 << 1;
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
      if (this.MgY.f(this.Mha, i1) == 1)
      {
        i3 = 0;
        if (this.MgY.f(this.Mhb, i1) == 0)
        {
          if (this.MgY.f(this.Mhe, (i1 << 4) + i4) != 0) {
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
        i4 = this.Mhj.a(this.MgY, i4) + 2;
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
        if ((i2 >= l) || (i2 >= this.Mhm))
        {
          AppMethodBeat.o(155358);
          return false;
          i1 = 11;
          break label721;
          if (this.MgY.f(this.Mhc, i1) == 0)
          {
            i2 = m;
            m = k;
            k = i2;
            i2 = i3;
            break label724;
          }
          if (this.MgY.f(this.Mhd, i1) == 0) {}
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
          i2 = this.Mhi.a(this.MgY, i4) + 2;
          if (i1 < 7)
          {
            n = 7;
            paramInputStream = this.Mhf;
            i1 = i2 - 2;
            if (i1 >= 4) {
              break label1069;
            }
          }
          int i7;
          for (;;)
          {
            i5 = paramInputStream[i1].a(this.MgY);
            if (i5 < 4) {
              break label1383;
            }
            i7 = (i5 >> 1) - 1;
            i6 = (i5 & 0x1 | 0x2) << i7;
            if (i5 >= 14) {
              break label1121;
            }
            paramInputStream = this.Mhg;
            paramOutputStream = this.MgY;
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
          paramInputStream = this.MgY;
          i3 = i7 - 4;
          i1 = 0;
          while (i3 != 0)
          {
            paramInputStream.MhC >>>= 1;
            i4 = paramInputStream.FMB - paramInputStream.MhC >>> 31;
            paramInputStream.FMB -= (paramInputStream.MhC & i4 - 1);
            i1 = i1 << 1 | 1 - i4;
            if ((paramInputStream.MhC & 0xFF000000) == 0)
            {
              paramInputStream.FMB = (paramInputStream.FMB << 8 | paramInputStream.MhD.read());
              paramInputStream.MhC <<= 8;
            }
            i3 -= 1;
          }
          paramInputStream = this.Mhh;
          paramOutputStream = this.MgY;
          i5 = 1;
          i4 = 0;
          i3 = 0;
          while (i3 < paramInputStream.MhB)
          {
            i7 = paramOutputStream.f(paramInputStream.MhA, i5);
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
        paramInputStream = this.MgX;
        i3 = paramInputStream.LVI - i2 - 1;
        if (i3 < 0)
        {
          i3 += paramInputStream.MgU;
          i4 = j;
        }
        for (;;)
        {
          if (i4 != 0)
          {
            i5 = i3;
            if (i3 >= paramInputStream.MgU) {
              i5 = 0;
            }
            paramOutputStream = paramInputStream.MgT;
            i3 = paramInputStream.LVI;
            paramInputStream.LVI = (i3 + 1);
            paramOutputStream[i3] = paramInputStream.MgT[i5];
            if (paramInputStream.LVI >= paramInputStream.MgU) {
              paramInputStream.ghb();
            }
            i4 -= 1;
            i3 = i5 + 1;
          }
          else
          {
            l += j;
            i4 = this.MgX.ajq(0);
            j = m;
            m = n;
            i3 = i2;
            i2 = i4;
            n = k;
            k = m;
            m = i3;
            break;
            label1590:
            this.MgX.ghb();
            this.MgX.gha();
            this.MgY.MhD = null;
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
      paramArrayOfByte = this.Mhk;
      if ((paramArrayOfByte.Mhu == null) || (paramArrayOfByte.Mhv != m) || (paramArrayOfByte.Mhw != n))
      {
        paramArrayOfByte.Mhw = n;
        paramArrayOfByte.Mhx = ((1 << n) - 1);
        paramArrayOfByte.Mhv = m;
        m = 1 << paramArrayOfByte.Mhv + paramArrayOfByte.Mhw;
        paramArrayOfByte.Mhu = new a.b.a[m];
        j = 0;
        while (j < m)
        {
          paramArrayOfByte.Mhu[j] = new a.b.a(paramArrayOfByte);
          j += 1;
        }
      }
      j = 1 << k;
      this.Mhi.ajr(j);
      this.Mhj.ajr(j);
      this.Mhn = (j - 1);
    }
    if (i < 0)
    {
      AppMethodBeat.o(155359);
      return false;
    }
    if (this.Mhl != i)
    {
      this.Mhl = i;
      this.Mhm = Math.max(this.Mhl, 1);
      paramArrayOfByte = this.MgX;
      i = Math.max(this.Mhm, 4096);
      if ((paramArrayOfByte.MgT == null) || (paramArrayOfByte.MgU != i)) {
        paramArrayOfByte.MgT = new byte[i];
      }
      paramArrayOfByte.MgU = i;
      paramArrayOfByte.LVI = 0;
      paramArrayOfByte.MgV = 0;
    }
    AppMethodBeat.o(155359);
    return true;
  }
  
  final class a
  {
    short[] Mho;
    g.a.c.a[] Mhp;
    g.a.c.a[] Mhq;
    g.a.c.a Mhr;
    int Mhs;
    
    a()
    {
      AppMethodBeat.i(155352);
      this.Mho = new short[2];
      this.Mhp = new g.a.c.a[16];
      this.Mhq = new g.a.c.a[16];
      this.Mhr = new g.a.c.a(8);
      this.Mhs = 0;
      AppMethodBeat.o(155352);
    }
    
    public final int a(b paramb, int paramInt)
    {
      AppMethodBeat.i(155355);
      if (paramb.f(this.Mho, 0) == 0)
      {
        paramInt = this.Mhp[paramInt].a(paramb);
        AppMethodBeat.o(155355);
        return paramInt;
      }
      if (paramb.f(this.Mho, 1) == 0) {}
      for (paramInt = this.Mhq[paramInt].a(paramb) + 8;; paramInt = this.Mhr.a(paramb) + 8 + 8)
      {
        AppMethodBeat.o(155355);
        return paramInt;
      }
    }
    
    public final void ajr(int paramInt)
    {
      AppMethodBeat.i(155353);
      while (this.Mhs < paramInt)
      {
        this.Mhp[this.Mhs] = new g.a.c.a(3);
        this.Mhq[this.Mhs] = new g.a.c.a(3);
        this.Mhs += 1;
      }
      AppMethodBeat.o(155353);
    }
    
    public final void ghc()
    {
      AppMethodBeat.i(155354);
      b.c(this.Mho);
      int i = 0;
      while (i < this.Mhs)
      {
        b.c(this.Mhp[i].MhA);
        b.c(this.Mhq[i].MhA);
        i += 1;
      }
      b.c(this.Mhr.MhA);
      AppMethodBeat.o(155354);
    }
  }
  
  final class b
  {
    a[] Mhu;
    int Mhv;
    int Mhw;
    int Mhx;
    
    b() {}
    
    final class a
    {
      short[] Mhy;
      
      a()
      {
        AppMethodBeat.i(155356);
        this.Mhy = new short[768];
        AppMethodBeat.o(155356);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     g.a.b.a
 * JD-Core Version:    0.7.0.1
 */