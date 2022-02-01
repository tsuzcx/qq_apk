package i.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.c.b;
import java.io.InputStream;
import java.io.OutputStream;

public final class a
{
  i.a.a.a abSg;
  b abSh;
  short[] abSi;
  short[] abSj;
  short[] abSk;
  short[] abSl;
  short[] abSm;
  short[] abSn;
  i.a.c.a[] abSo;
  short[] abSp;
  i.a.c.a abSq;
  a abSr;
  a abSs;
  b abSt;
  int abSu;
  int abSv;
  int abSw;
  
  public a()
  {
    AppMethodBeat.i(155357);
    this.abSg = new i.a.a.a();
    this.abSh = new b();
    this.abSi = new short['À'];
    this.abSj = new short[12];
    this.abSk = new short[12];
    this.abSl = new short[12];
    this.abSm = new short[12];
    this.abSn = new short['À'];
    this.abSo = new i.a.c.a[4];
    this.abSp = new short[114];
    this.abSq = new i.a.c.a(4);
    this.abSr = new a();
    this.abSs = new a();
    this.abSt = new b();
    this.abSu = -1;
    this.abSv = -1;
    int i = 0;
    while (i < 4)
    {
      this.abSo[i] = new i.a.c.a(6);
      i += 1;
    }
    AppMethodBeat.o(155357);
  }
  
  public final boolean a(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong)
  {
    AppMethodBeat.i(155358);
    this.abSh.abSM = paramInputStream;
    paramInputStream = this.abSg;
    paramInputStream.iWy();
    paramInputStream.abSf = paramOutputStream;
    paramInputStream = this.abSg;
    paramInputStream.abSe = 0;
    paramInputStream.abFB = 0;
    b.c(this.abSi);
    b.c(this.abSn);
    b.c(this.abSj);
    b.c(this.abSk);
    b.c(this.abSl);
    b.c(this.abSm);
    b.c(this.abSp);
    paramInputStream = this.abSt;
    int k = paramInputStream.abSE;
    int m = paramInputStream.abSF;
    int j = 0;
    while (j < 1 << k + m)
    {
      b.c(paramInputStream.abSD[j].abSH);
      j += 1;
    }
    j = 0;
    while (j < 4)
    {
      b.c(this.abSo[j].abSJ);
      j += 1;
    }
    this.abSr.iWA();
    this.abSs.iWA();
    b.c(this.abSq.abSJ);
    paramInputStream = this.abSh;
    paramInputStream.Upv = 0;
    paramInputStream.abSL = -1;
    j = 0;
    while (j < 5)
    {
      paramInputStream.Upv = (paramInputStream.Upv << 8 | paramInputStream.abSM.read());
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
      i4 = (int)l & this.abSw;
      if (this.abSh.g(this.abSi, (i1 << 4) + i4) == 0)
      {
        paramInputStream = this.abSt;
        i3 = (int)l;
        paramOutputStream = paramInputStream.abSD;
        i4 = paramInputStream.abSG;
        i5 = paramInputStream.abSE;
        paramInputStream = paramOutputStream[(((i2 & 0xFF) >>> 8 - paramInputStream.abSE) + ((i3 & i4) << i5))];
        int i;
        if (i1 < 7)
        {
          i2 = 1;
          if (i2 == 0)
          {
            paramOutputStream = this.abSh;
            i4 = this.abSg.aGl(m);
            i3 = 1;
          }
        }
        else
        {
          do
          {
            i5 = i4 >> 7 & 0x1;
            i4 = (byte)(i4 << 1);
            i6 = paramOutputStream.g(paramInputStream.abSH, (i5 + 1 << 8) + i3);
            i2 = i3 << 1 | i6;
            if (i5 != i6)
            {
              for (;;)
              {
                i3 = i2;
                if (i2 >= 256) {
                  break;
                }
                i2 = paramOutputStream.g(paramInputStream.abSH, i2) | i2 << 1;
              }
              i2 = 0;
              break;
            }
            i3 = i2;
          } while (i2 < 256);
          i3 = i2;
          i = (byte)i3;
          label515:
          paramInputStream = this.abSg;
          paramOutputStream = paramInputStream.abSc;
          i2 = paramInputStream.abFB;
          paramInputStream.abFB = (i2 + 1);
          paramOutputStream[i2] = i;
          if (paramInputStream.abFB >= paramInputStream.abSd) {
            paramInputStream.iWz();
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
          paramOutputStream = this.abSh;
          i2 = 1;
          do
          {
            i3 = paramOutputStream.g(paramInputStream.abSH, i2) | i2 << 1;
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
      if (this.abSh.g(this.abSj, i1) == 1)
      {
        i3 = 0;
        if (this.abSh.g(this.abSk, i1) == 0)
        {
          if (this.abSh.g(this.abSn, (i1 << 4) + i4) != 0) {
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
        i4 = this.abSs.a(this.abSh, i4) + 2;
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
        if ((i2 >= l) || (i2 >= this.abSv))
        {
          AppMethodBeat.o(155358);
          return false;
          i1 = 11;
          break label721;
          if (this.abSh.g(this.abSl, i1) == 0)
          {
            i2 = m;
            m = k;
            k = i2;
            i2 = i3;
            break label724;
          }
          if (this.abSh.g(this.abSm, i1) == 0) {}
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
          i2 = this.abSr.a(this.abSh, i4) + 2;
          if (i1 < 7)
          {
            n = 7;
            paramInputStream = this.abSo;
            i1 = i2 - 2;
            if (i1 >= 4) {
              break label1069;
            }
          }
          int i7;
          for (;;)
          {
            i5 = paramInputStream[i1].a(this.abSh);
            if (i5 < 4) {
              break label1383;
            }
            i7 = (i5 >> 1) - 1;
            i6 = (i5 & 0x1 | 0x2) << i7;
            if (i5 >= 14) {
              break label1121;
            }
            paramInputStream = this.abSp;
            paramOutputStream = this.abSh;
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
          paramInputStream = this.abSh;
          i3 = i7 - 4;
          i1 = 0;
          while (i3 != 0)
          {
            paramInputStream.abSL >>>= 1;
            i4 = paramInputStream.Upv - paramInputStream.abSL >>> 31;
            paramInputStream.Upv -= (paramInputStream.abSL & i4 - 1);
            i1 = i1 << 1 | 1 - i4;
            if ((paramInputStream.abSL & 0xFF000000) == 0)
            {
              paramInputStream.Upv = (paramInputStream.Upv << 8 | paramInputStream.abSM.read());
              paramInputStream.abSL <<= 8;
            }
            i3 -= 1;
          }
          paramInputStream = this.abSq;
          paramOutputStream = this.abSh;
          i5 = 1;
          i4 = 0;
          i3 = 0;
          while (i3 < paramInputStream.abSK)
          {
            i7 = paramOutputStream.g(paramInputStream.abSJ, i5);
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
        paramInputStream = this.abSg;
        i3 = paramInputStream.abFB - i2 - 1;
        if (i3 < 0)
        {
          i3 += paramInputStream.abSd;
          i4 = j;
        }
        for (;;)
        {
          if (i4 != 0)
          {
            i5 = i3;
            if (i3 >= paramInputStream.abSd) {
              i5 = 0;
            }
            paramOutputStream = paramInputStream.abSc;
            i3 = paramInputStream.abFB;
            paramInputStream.abFB = (i3 + 1);
            paramOutputStream[i3] = paramInputStream.abSc[i5];
            if (paramInputStream.abFB >= paramInputStream.abSd) {
              paramInputStream.iWz();
            }
            i4 -= 1;
            i3 = i5 + 1;
          }
          else
          {
            l += j;
            i4 = this.abSg.aGl(0);
            j = m;
            m = n;
            i3 = i2;
            i2 = i4;
            n = k;
            k = m;
            m = i3;
            break;
            label1590:
            this.abSg.iWz();
            this.abSg.iWy();
            this.abSh.abSM = null;
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
  
  public final boolean dY(byte[] paramArrayOfByte)
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
      paramArrayOfByte = this.abSt;
      if ((paramArrayOfByte.abSD == null) || (paramArrayOfByte.abSE != m) || (paramArrayOfByte.abSF != n))
      {
        paramArrayOfByte.abSF = n;
        paramArrayOfByte.abSG = ((1 << n) - 1);
        paramArrayOfByte.abSE = m;
        m = 1 << paramArrayOfByte.abSE + paramArrayOfByte.abSF;
        paramArrayOfByte.abSD = new a.b.a[m];
        j = 0;
        while (j < m)
        {
          paramArrayOfByte.abSD[j] = new a.b.a(paramArrayOfByte);
          j += 1;
        }
      }
      j = 1 << k;
      this.abSr.aGm(j);
      this.abSs.aGm(j);
      this.abSw = (j - 1);
    }
    if (i < 0)
    {
      AppMethodBeat.o(155359);
      return false;
    }
    if (this.abSu != i)
    {
      this.abSu = i;
      this.abSv = Math.max(this.abSu, 1);
      paramArrayOfByte = this.abSg;
      i = Math.max(this.abSv, 4096);
      if ((paramArrayOfByte.abSc == null) || (paramArrayOfByte.abSd != i)) {
        paramArrayOfByte.abSc = new byte[i];
      }
      paramArrayOfByte.abSd = i;
      paramArrayOfByte.abFB = 0;
      paramArrayOfByte.abSe = 0;
    }
    AppMethodBeat.o(155359);
    return true;
  }
  
  final class a
  {
    i.a.c.a abSA;
    int abSB;
    short[] abSx;
    i.a.c.a[] abSy;
    i.a.c.a[] abSz;
    
    a()
    {
      AppMethodBeat.i(155352);
      this.abSx = new short[2];
      this.abSy = new i.a.c.a[16];
      this.abSz = new i.a.c.a[16];
      this.abSA = new i.a.c.a(8);
      this.abSB = 0;
      AppMethodBeat.o(155352);
    }
    
    public final int a(b paramb, int paramInt)
    {
      AppMethodBeat.i(155355);
      if (paramb.g(this.abSx, 0) == 0)
      {
        paramInt = this.abSy[paramInt].a(paramb);
        AppMethodBeat.o(155355);
        return paramInt;
      }
      if (paramb.g(this.abSx, 1) == 0) {}
      for (paramInt = this.abSz[paramInt].a(paramb) + 8;; paramInt = this.abSA.a(paramb) + 8 + 8)
      {
        AppMethodBeat.o(155355);
        return paramInt;
      }
    }
    
    public final void aGm(int paramInt)
    {
      AppMethodBeat.i(155353);
      while (this.abSB < paramInt)
      {
        this.abSy[this.abSB] = new i.a.c.a(3);
        this.abSz[this.abSB] = new i.a.c.a(3);
        this.abSB += 1;
      }
      AppMethodBeat.o(155353);
    }
    
    public final void iWA()
    {
      AppMethodBeat.i(155354);
      b.c(this.abSx);
      int i = 0;
      while (i < this.abSB)
      {
        b.c(this.abSy[i].abSJ);
        b.c(this.abSz[i].abSJ);
        i += 1;
      }
      b.c(this.abSA.abSJ);
      AppMethodBeat.o(155354);
    }
  }
  
  final class b
  {
    a[] abSD;
    int abSE;
    int abSF;
    int abSG;
    
    b() {}
    
    final class a
    {
      short[] abSH;
      
      a()
      {
        AppMethodBeat.i(155356);
        this.abSH = new short[768];
        AppMethodBeat.o(155356);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     i.a.b.a
 * JD-Core Version:    0.7.0.1
 */