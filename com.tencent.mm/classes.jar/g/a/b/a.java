package g.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.c.b;
import java.io.InputStream;
import java.io.OutputStream;

public final class a
{
  g.a.a.a Oze;
  b Ozf;
  short[] Ozg;
  short[] Ozh;
  short[] Ozi;
  short[] Ozj;
  short[] Ozk;
  short[] Ozl;
  g.a.c.a[] Ozm;
  short[] Ozn;
  g.a.c.a Ozo;
  a Ozp;
  a Ozq;
  b Ozr;
  int Ozs;
  int Ozt;
  int Ozu;
  
  public a()
  {
    AppMethodBeat.i(155357);
    this.Oze = new g.a.a.a();
    this.Ozf = new b();
    this.Ozg = new short['À'];
    this.Ozh = new short[12];
    this.Ozi = new short[12];
    this.Ozj = new short[12];
    this.Ozk = new short[12];
    this.Ozl = new short['À'];
    this.Ozm = new g.a.c.a[4];
    this.Ozn = new short[114];
    this.Ozo = new g.a.c.a(4);
    this.Ozp = new a();
    this.Ozq = new a();
    this.Ozr = new b();
    this.Ozs = -1;
    this.Ozt = -1;
    int i = 0;
    while (i < 4)
    {
      this.Ozm[i] = new g.a.c.a(6);
      i += 1;
    }
    AppMethodBeat.o(155357);
  }
  
  public final boolean a(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong)
  {
    AppMethodBeat.i(155358);
    this.Ozf.OzK = paramInputStream;
    paramInputStream = this.Oze;
    paramInputStream.gEg();
    paramInputStream.Ozd = paramOutputStream;
    paramInputStream = this.Oze;
    paramInputStream.Ozc = 0;
    paramInputStream.Onn = 0;
    b.c(this.Ozg);
    b.c(this.Ozl);
    b.c(this.Ozh);
    b.c(this.Ozi);
    b.c(this.Ozj);
    b.c(this.Ozk);
    b.c(this.Ozn);
    paramInputStream = this.Ozr;
    int k = paramInputStream.OzC;
    int m = paramInputStream.OzD;
    int j = 0;
    while (j < 1 << k + m)
    {
      b.c(paramInputStream.OzB[j].OzF);
      j += 1;
    }
    j = 0;
    while (j < 4)
    {
      b.c(this.Ozm[j].OzH);
      j += 1;
    }
    this.Ozp.gEi();
    this.Ozq.gEi();
    b.c(this.Ozo.OzH);
    paramInputStream = this.Ozf;
    paramInputStream.HQX = 0;
    paramInputStream.OzJ = -1;
    j = 0;
    while (j < 5)
    {
      paramInputStream.HQX = (paramInputStream.HQX << 8 | paramInputStream.OzK.read());
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
      i4 = (int)l & this.Ozu;
      if (this.Ozf.f(this.Ozg, (i1 << 4) + i4) == 0)
      {
        paramInputStream = this.Ozr;
        i3 = (int)l;
        paramOutputStream = paramInputStream.OzB;
        i4 = paramInputStream.OzE;
        i5 = paramInputStream.OzC;
        paramInputStream = paramOutputStream[(((i2 & 0xFF) >>> 8 - paramInputStream.OzC) + ((i3 & i4) << i5))];
        int i;
        if (i1 < 7)
        {
          i2 = 1;
          if (i2 == 0)
          {
            paramOutputStream = this.Ozf;
            i4 = this.Oze.amL(m);
            i3 = 1;
          }
        }
        else
        {
          do
          {
            i5 = i4 >> 7 & 0x1;
            i4 = (byte)(i4 << 1);
            i6 = paramOutputStream.f(paramInputStream.OzF, (i5 + 1 << 8) + i3);
            i2 = i3 << 1 | i6;
            if (i5 != i6)
            {
              for (;;)
              {
                i3 = i2;
                if (i2 >= 256) {
                  break;
                }
                i2 = paramOutputStream.f(paramInputStream.OzF, i2) | i2 << 1;
              }
              i2 = 0;
              break;
            }
            i3 = i2;
          } while (i2 < 256);
          i3 = i2;
          i = (byte)i3;
          label515:
          paramInputStream = this.Oze;
          paramOutputStream = paramInputStream.Oza;
          i2 = paramInputStream.Onn;
          paramInputStream.Onn = (i2 + 1);
          paramOutputStream[i2] = i;
          if (paramInputStream.Onn >= paramInputStream.Ozb) {
            paramInputStream.gEh();
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
          paramOutputStream = this.Ozf;
          i2 = 1;
          do
          {
            i3 = paramOutputStream.f(paramInputStream.OzF, i2) | i2 << 1;
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
      if (this.Ozf.f(this.Ozh, i1) == 1)
      {
        i3 = 0;
        if (this.Ozf.f(this.Ozi, i1) == 0)
        {
          if (this.Ozf.f(this.Ozl, (i1 << 4) + i4) != 0) {
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
        i4 = this.Ozq.a(this.Ozf, i4) + 2;
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
        if ((i2 >= l) || (i2 >= this.Ozt))
        {
          AppMethodBeat.o(155358);
          return false;
          i1 = 11;
          break label721;
          if (this.Ozf.f(this.Ozj, i1) == 0)
          {
            i2 = m;
            m = k;
            k = i2;
            i2 = i3;
            break label724;
          }
          if (this.Ozf.f(this.Ozk, i1) == 0) {}
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
          i2 = this.Ozp.a(this.Ozf, i4) + 2;
          if (i1 < 7)
          {
            n = 7;
            paramInputStream = this.Ozm;
            i1 = i2 - 2;
            if (i1 >= 4) {
              break label1069;
            }
          }
          int i7;
          for (;;)
          {
            i5 = paramInputStream[i1].a(this.Ozf);
            if (i5 < 4) {
              break label1383;
            }
            i7 = (i5 >> 1) - 1;
            i6 = (i5 & 0x1 | 0x2) << i7;
            if (i5 >= 14) {
              break label1121;
            }
            paramInputStream = this.Ozn;
            paramOutputStream = this.Ozf;
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
          paramInputStream = this.Ozf;
          i3 = i7 - 4;
          i1 = 0;
          while (i3 != 0)
          {
            paramInputStream.OzJ >>>= 1;
            i4 = paramInputStream.HQX - paramInputStream.OzJ >>> 31;
            paramInputStream.HQX -= (paramInputStream.OzJ & i4 - 1);
            i1 = i1 << 1 | 1 - i4;
            if ((paramInputStream.OzJ & 0xFF000000) == 0)
            {
              paramInputStream.HQX = (paramInputStream.HQX << 8 | paramInputStream.OzK.read());
              paramInputStream.OzJ <<= 8;
            }
            i3 -= 1;
          }
          paramInputStream = this.Ozo;
          paramOutputStream = this.Ozf;
          i5 = 1;
          i4 = 0;
          i3 = 0;
          while (i3 < paramInputStream.OzI)
          {
            i7 = paramOutputStream.f(paramInputStream.OzH, i5);
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
        paramInputStream = this.Oze;
        i3 = paramInputStream.Onn - i2 - 1;
        if (i3 < 0)
        {
          i3 += paramInputStream.Ozb;
          i4 = j;
        }
        for (;;)
        {
          if (i4 != 0)
          {
            i5 = i3;
            if (i3 >= paramInputStream.Ozb) {
              i5 = 0;
            }
            paramOutputStream = paramInputStream.Oza;
            i3 = paramInputStream.Onn;
            paramInputStream.Onn = (i3 + 1);
            paramOutputStream[i3] = paramInputStream.Oza[i5];
            if (paramInputStream.Onn >= paramInputStream.Ozb) {
              paramInputStream.gEh();
            }
            i4 -= 1;
            i3 = i5 + 1;
          }
          else
          {
            l += j;
            i4 = this.Oze.amL(0);
            j = m;
            m = n;
            i3 = i2;
            i2 = i4;
            n = k;
            k = m;
            m = i3;
            break;
            label1590:
            this.Oze.gEh();
            this.Oze.gEg();
            this.Ozf.OzK = null;
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
  
  public final boolean dx(byte[] paramArrayOfByte)
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
      paramArrayOfByte = this.Ozr;
      if ((paramArrayOfByte.OzB == null) || (paramArrayOfByte.OzC != m) || (paramArrayOfByte.OzD != n))
      {
        paramArrayOfByte.OzD = n;
        paramArrayOfByte.OzE = ((1 << n) - 1);
        paramArrayOfByte.OzC = m;
        m = 1 << paramArrayOfByte.OzC + paramArrayOfByte.OzD;
        paramArrayOfByte.OzB = new a.b.a[m];
        j = 0;
        while (j < m)
        {
          paramArrayOfByte.OzB[j] = new a.b.a(paramArrayOfByte);
          j += 1;
        }
      }
      j = 1 << k;
      this.Ozp.amM(j);
      this.Ozq.amM(j);
      this.Ozu = (j - 1);
    }
    if (i < 0)
    {
      AppMethodBeat.o(155359);
      return false;
    }
    if (this.Ozs != i)
    {
      this.Ozs = i;
      this.Ozt = Math.max(this.Ozs, 1);
      paramArrayOfByte = this.Oze;
      i = Math.max(this.Ozt, 4096);
      if ((paramArrayOfByte.Oza == null) || (paramArrayOfByte.Ozb != i)) {
        paramArrayOfByte.Oza = new byte[i];
      }
      paramArrayOfByte.Ozb = i;
      paramArrayOfByte.Onn = 0;
      paramArrayOfByte.Ozc = 0;
    }
    AppMethodBeat.o(155359);
    return true;
  }
  
  final class a
  {
    short[] Ozv;
    g.a.c.a[] Ozw;
    g.a.c.a[] Ozx;
    g.a.c.a Ozy;
    int Ozz;
    
    a()
    {
      AppMethodBeat.i(155352);
      this.Ozv = new short[2];
      this.Ozw = new g.a.c.a[16];
      this.Ozx = new g.a.c.a[16];
      this.Ozy = new g.a.c.a(8);
      this.Ozz = 0;
      AppMethodBeat.o(155352);
    }
    
    public final int a(b paramb, int paramInt)
    {
      AppMethodBeat.i(155355);
      if (paramb.f(this.Ozv, 0) == 0)
      {
        paramInt = this.Ozw[paramInt].a(paramb);
        AppMethodBeat.o(155355);
        return paramInt;
      }
      if (paramb.f(this.Ozv, 1) == 0) {}
      for (paramInt = this.Ozx[paramInt].a(paramb) + 8;; paramInt = this.Ozy.a(paramb) + 8 + 8)
      {
        AppMethodBeat.o(155355);
        return paramInt;
      }
    }
    
    public final void amM(int paramInt)
    {
      AppMethodBeat.i(155353);
      while (this.Ozz < paramInt)
      {
        this.Ozw[this.Ozz] = new g.a.c.a(3);
        this.Ozx[this.Ozz] = new g.a.c.a(3);
        this.Ozz += 1;
      }
      AppMethodBeat.o(155353);
    }
    
    public final void gEi()
    {
      AppMethodBeat.i(155354);
      b.c(this.Ozv);
      int i = 0;
      while (i < this.Ozz)
      {
        b.c(this.Ozw[i].OzH);
        b.c(this.Ozx[i].OzH);
        i += 1;
      }
      b.c(this.Ozy.OzH);
      AppMethodBeat.o(155354);
    }
  }
  
  final class b
  {
    a[] OzB;
    int OzC;
    int OzD;
    int OzE;
    
    b() {}
    
    final class a
    {
      short[] OzF;
      
      a()
      {
        AppMethodBeat.i(155356);
        this.OzF = new short[768];
        AppMethodBeat.o(155356);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     g.a.b.a
 * JD-Core Version:    0.7.0.1
 */