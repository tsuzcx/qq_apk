package g.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.c.b;
import java.io.InputStream;
import java.io.OutputStream;

public final class a
{
  g.a.a.a ObZ;
  b Oca;
  short[] Ocb;
  short[] Occ;
  short[] Ocd;
  short[] Oce;
  short[] Ocf;
  short[] Ocg;
  g.a.c.a[] Och;
  short[] Oci;
  g.a.c.a Ocj;
  a Ock;
  a Ocl;
  b Ocm;
  int Ocn;
  int Oco;
  int Ocp;
  
  public a()
  {
    AppMethodBeat.i(155357);
    this.ObZ = new g.a.a.a();
    this.Oca = new b();
    this.Ocb = new short['À'];
    this.Occ = new short[12];
    this.Ocd = new short[12];
    this.Oce = new short[12];
    this.Ocf = new short[12];
    this.Ocg = new short['À'];
    this.Och = new g.a.c.a[4];
    this.Oci = new short[114];
    this.Ocj = new g.a.c.a(4);
    this.Ock = new a();
    this.Ocl = new a();
    this.Ocm = new b();
    this.Ocn = -1;
    this.Oco = -1;
    int i = 0;
    while (i < 4)
    {
      this.Och[i] = new g.a.c.a(6);
      i += 1;
    }
    AppMethodBeat.o(155357);
  }
  
  public final boolean a(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong)
  {
    AppMethodBeat.i(155358);
    this.Oca.OcF = paramInputStream;
    paramInputStream = this.ObZ;
    paramInputStream.gzE();
    paramInputStream.ObY = paramOutputStream;
    paramInputStream = this.ObZ;
    paramInputStream.ObX = 0;
    paramInputStream.NQh = 0;
    b.c(this.Ocb);
    b.c(this.Ocg);
    b.c(this.Occ);
    b.c(this.Ocd);
    b.c(this.Oce);
    b.c(this.Ocf);
    b.c(this.Oci);
    paramInputStream = this.Ocm;
    int k = paramInputStream.Ocx;
    int m = paramInputStream.Ocy;
    int j = 0;
    while (j < 1 << k + m)
    {
      b.c(paramInputStream.Ocw[j].OcA);
      j += 1;
    }
    j = 0;
    while (j < 4)
    {
      b.c(this.Och[j].OcC);
      j += 1;
    }
    this.Ock.gzG();
    this.Ocl.gzG();
    b.c(this.Ocj.OcC);
    paramInputStream = this.Oca;
    paramInputStream.Hxm = 0;
    paramInputStream.OcE = -1;
    j = 0;
    while (j < 5)
    {
      paramInputStream.Hxm = (paramInputStream.Hxm << 8 | paramInputStream.OcF.read());
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
      i4 = (int)l & this.Ocp;
      if (this.Oca.f(this.Ocb, (i1 << 4) + i4) == 0)
      {
        paramInputStream = this.Ocm;
        i3 = (int)l;
        paramOutputStream = paramInputStream.Ocw;
        i4 = paramInputStream.Ocz;
        i5 = paramInputStream.Ocx;
        paramInputStream = paramOutputStream[(((i2 & 0xFF) >>> 8 - paramInputStream.Ocx) + ((i3 & i4) << i5))];
        int i;
        if (i1 < 7)
        {
          i2 = 1;
          if (i2 == 0)
          {
            paramOutputStream = this.Oca;
            i4 = this.ObZ.amb(m);
            i3 = 1;
          }
        }
        else
        {
          do
          {
            i5 = i4 >> 7 & 0x1;
            i4 = (byte)(i4 << 1);
            i6 = paramOutputStream.f(paramInputStream.OcA, (i5 + 1 << 8) + i3);
            i2 = i3 << 1 | i6;
            if (i5 != i6)
            {
              for (;;)
              {
                i3 = i2;
                if (i2 >= 256) {
                  break;
                }
                i2 = paramOutputStream.f(paramInputStream.OcA, i2) | i2 << 1;
              }
              i2 = 0;
              break;
            }
            i3 = i2;
          } while (i2 < 256);
          i3 = i2;
          i = (byte)i3;
          label515:
          paramInputStream = this.ObZ;
          paramOutputStream = paramInputStream.ObV;
          i2 = paramInputStream.NQh;
          paramInputStream.NQh = (i2 + 1);
          paramOutputStream[i2] = i;
          if (paramInputStream.NQh >= paramInputStream.ObW) {
            paramInputStream.gzF();
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
          paramOutputStream = this.Oca;
          i2 = 1;
          do
          {
            i3 = paramOutputStream.f(paramInputStream.OcA, i2) | i2 << 1;
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
      if (this.Oca.f(this.Occ, i1) == 1)
      {
        i3 = 0;
        if (this.Oca.f(this.Ocd, i1) == 0)
        {
          if (this.Oca.f(this.Ocg, (i1 << 4) + i4) != 0) {
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
        i4 = this.Ocl.a(this.Oca, i4) + 2;
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
        if ((i2 >= l) || (i2 >= this.Oco))
        {
          AppMethodBeat.o(155358);
          return false;
          i1 = 11;
          break label721;
          if (this.Oca.f(this.Oce, i1) == 0)
          {
            i2 = m;
            m = k;
            k = i2;
            i2 = i3;
            break label724;
          }
          if (this.Oca.f(this.Ocf, i1) == 0) {}
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
          i2 = this.Ock.a(this.Oca, i4) + 2;
          if (i1 < 7)
          {
            n = 7;
            paramInputStream = this.Och;
            i1 = i2 - 2;
            if (i1 >= 4) {
              break label1069;
            }
          }
          int i7;
          for (;;)
          {
            i5 = paramInputStream[i1].a(this.Oca);
            if (i5 < 4) {
              break label1383;
            }
            i7 = (i5 >> 1) - 1;
            i6 = (i5 & 0x1 | 0x2) << i7;
            if (i5 >= 14) {
              break label1121;
            }
            paramInputStream = this.Oci;
            paramOutputStream = this.Oca;
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
          paramInputStream = this.Oca;
          i3 = i7 - 4;
          i1 = 0;
          while (i3 != 0)
          {
            paramInputStream.OcE >>>= 1;
            i4 = paramInputStream.Hxm - paramInputStream.OcE >>> 31;
            paramInputStream.Hxm -= (paramInputStream.OcE & i4 - 1);
            i1 = i1 << 1 | 1 - i4;
            if ((paramInputStream.OcE & 0xFF000000) == 0)
            {
              paramInputStream.Hxm = (paramInputStream.Hxm << 8 | paramInputStream.OcF.read());
              paramInputStream.OcE <<= 8;
            }
            i3 -= 1;
          }
          paramInputStream = this.Ocj;
          paramOutputStream = this.Oca;
          i5 = 1;
          i4 = 0;
          i3 = 0;
          while (i3 < paramInputStream.OcD)
          {
            i7 = paramOutputStream.f(paramInputStream.OcC, i5);
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
        paramInputStream = this.ObZ;
        i3 = paramInputStream.NQh - i2 - 1;
        if (i3 < 0)
        {
          i3 += paramInputStream.ObW;
          i4 = j;
        }
        for (;;)
        {
          if (i4 != 0)
          {
            i5 = i3;
            if (i3 >= paramInputStream.ObW) {
              i5 = 0;
            }
            paramOutputStream = paramInputStream.ObV;
            i3 = paramInputStream.NQh;
            paramInputStream.NQh = (i3 + 1);
            paramOutputStream[i3] = paramInputStream.ObV[i5];
            if (paramInputStream.NQh >= paramInputStream.ObW) {
              paramInputStream.gzF();
            }
            i4 -= 1;
            i3 = i5 + 1;
          }
          else
          {
            l += j;
            i4 = this.ObZ.amb(0);
            j = m;
            m = n;
            i3 = i2;
            i2 = i4;
            n = k;
            k = m;
            m = i3;
            break;
            label1590:
            this.ObZ.gzF();
            this.ObZ.gzE();
            this.Oca.OcF = null;
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
  
  public final boolean du(byte[] paramArrayOfByte)
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
      paramArrayOfByte = this.Ocm;
      if ((paramArrayOfByte.Ocw == null) || (paramArrayOfByte.Ocx != m) || (paramArrayOfByte.Ocy != n))
      {
        paramArrayOfByte.Ocy = n;
        paramArrayOfByte.Ocz = ((1 << n) - 1);
        paramArrayOfByte.Ocx = m;
        m = 1 << paramArrayOfByte.Ocx + paramArrayOfByte.Ocy;
        paramArrayOfByte.Ocw = new a.b.a[m];
        j = 0;
        while (j < m)
        {
          paramArrayOfByte.Ocw[j] = new a.b.a(paramArrayOfByte);
          j += 1;
        }
      }
      j = 1 << k;
      this.Ock.amc(j);
      this.Ocl.amc(j);
      this.Ocp = (j - 1);
    }
    if (i < 0)
    {
      AppMethodBeat.o(155359);
      return false;
    }
    if (this.Ocn != i)
    {
      this.Ocn = i;
      this.Oco = Math.max(this.Ocn, 1);
      paramArrayOfByte = this.ObZ;
      i = Math.max(this.Oco, 4096);
      if ((paramArrayOfByte.ObV == null) || (paramArrayOfByte.ObW != i)) {
        paramArrayOfByte.ObV = new byte[i];
      }
      paramArrayOfByte.ObW = i;
      paramArrayOfByte.NQh = 0;
      paramArrayOfByte.ObX = 0;
    }
    AppMethodBeat.o(155359);
    return true;
  }
  
  final class a
  {
    short[] Ocq;
    g.a.c.a[] Ocr;
    g.a.c.a[] Ocs;
    g.a.c.a Oct;
    int Ocu;
    
    a()
    {
      AppMethodBeat.i(155352);
      this.Ocq = new short[2];
      this.Ocr = new g.a.c.a[16];
      this.Ocs = new g.a.c.a[16];
      this.Oct = new g.a.c.a(8);
      this.Ocu = 0;
      AppMethodBeat.o(155352);
    }
    
    public final int a(b paramb, int paramInt)
    {
      AppMethodBeat.i(155355);
      if (paramb.f(this.Ocq, 0) == 0)
      {
        paramInt = this.Ocr[paramInt].a(paramb);
        AppMethodBeat.o(155355);
        return paramInt;
      }
      if (paramb.f(this.Ocq, 1) == 0) {}
      for (paramInt = this.Ocs[paramInt].a(paramb) + 8;; paramInt = this.Oct.a(paramb) + 8 + 8)
      {
        AppMethodBeat.o(155355);
        return paramInt;
      }
    }
    
    public final void amc(int paramInt)
    {
      AppMethodBeat.i(155353);
      while (this.Ocu < paramInt)
      {
        this.Ocr[this.Ocu] = new g.a.c.a(3);
        this.Ocs[this.Ocu] = new g.a.c.a(3);
        this.Ocu += 1;
      }
      AppMethodBeat.o(155353);
    }
    
    public final void gzG()
    {
      AppMethodBeat.i(155354);
      b.c(this.Ocq);
      int i = 0;
      while (i < this.Ocu)
      {
        b.c(this.Ocr[i].OcC);
        b.c(this.Ocs[i].OcC);
        i += 1;
      }
      b.c(this.Oct.OcC);
      AppMethodBeat.o(155354);
    }
  }
  
  final class b
  {
    a[] Ocw;
    int Ocx;
    int Ocy;
    int Ocz;
    
    b() {}
    
    final class a
    {
      short[] OcA;
      
      a()
      {
        AppMethodBeat.i(155356);
        this.OcA = new short[768];
        AppMethodBeat.o(155356);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     g.a.b.a
 * JD-Core Version:    0.7.0.1
 */