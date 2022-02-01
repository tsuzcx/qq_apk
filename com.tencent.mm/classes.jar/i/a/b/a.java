package i.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.c.b;
import java.io.InputStream;
import java.io.OutputStream;

public final class a
{
  i.a.a.a UoR;
  b UoS;
  short[] UoT;
  short[] UoU;
  short[] UoV;
  short[] UoW;
  short[] UoX;
  short[] UoY;
  i.a.c.a[] UoZ;
  short[] Upa;
  i.a.c.a Upb;
  a Upc;
  a Upd;
  b Upe;
  int Upf;
  int Upg;
  int Uph;
  
  public a()
  {
    AppMethodBeat.i(155357);
    this.UoR = new i.a.a.a();
    this.UoS = new b();
    this.UoT = new short['À'];
    this.UoU = new short[12];
    this.UoV = new short[12];
    this.UoW = new short[12];
    this.UoX = new short[12];
    this.UoY = new short['À'];
    this.UoZ = new i.a.c.a[4];
    this.Upa = new short[114];
    this.Upb = new i.a.c.a(4);
    this.Upc = new a();
    this.Upd = new a();
    this.Upe = new b();
    this.Upf = -1;
    this.Upg = -1;
    int i = 0;
    while (i < 4)
    {
      this.UoZ[i] = new i.a.c.a(6);
      i += 1;
    }
    AppMethodBeat.o(155357);
  }
  
  public final boolean a(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong)
  {
    AppMethodBeat.i(155358);
    this.UoS.Upx = paramInputStream;
    paramInputStream = this.UoR;
    paramInputStream.hRo();
    paramInputStream.UoQ = paramOutputStream;
    paramInputStream = this.UoR;
    paramInputStream.UoP = 0;
    paramInputStream.Ucm = 0;
    b.c(this.UoT);
    b.c(this.UoY);
    b.c(this.UoU);
    b.c(this.UoV);
    b.c(this.UoW);
    b.c(this.UoX);
    b.c(this.Upa);
    paramInputStream = this.Upe;
    int k = paramInputStream.Upp;
    int m = paramInputStream.Upq;
    int j = 0;
    while (j < 1 << k + m)
    {
      b.c(paramInputStream.Upo[j].Ups);
      j += 1;
    }
    j = 0;
    while (j < 4)
    {
      b.c(this.UoZ[j].Upu);
      j += 1;
    }
    this.Upc.hRq();
    this.Upd.hRq();
    b.c(this.Upb.Upu);
    paramInputStream = this.UoS;
    paramInputStream.NcY = 0;
    paramInputStream.Upw = -1;
    j = 0;
    while (j < 5)
    {
      paramInputStream.NcY = (paramInputStream.NcY << 8 | paramInputStream.Upx.read());
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
      i4 = (int)l & this.Uph;
      if (this.UoS.g(this.UoT, (i1 << 4) + i4) == 0)
      {
        paramInputStream = this.Upe;
        i3 = (int)l;
        paramOutputStream = paramInputStream.Upo;
        i4 = paramInputStream.Upr;
        i5 = paramInputStream.Upp;
        paramInputStream = paramOutputStream[(((i2 & 0xFF) >>> 8 - paramInputStream.Upp) + ((i3 & i4) << i5))];
        int i;
        if (i1 < 7)
        {
          i2 = 1;
          if (i2 == 0)
          {
            paramOutputStream = this.UoS;
            i4 = this.UoR.awq(m);
            i3 = 1;
          }
        }
        else
        {
          do
          {
            i5 = i4 >> 7 & 0x1;
            i4 = (byte)(i4 << 1);
            i6 = paramOutputStream.g(paramInputStream.Ups, (i5 + 1 << 8) + i3);
            i2 = i3 << 1 | i6;
            if (i5 != i6)
            {
              for (;;)
              {
                i3 = i2;
                if (i2 >= 256) {
                  break;
                }
                i2 = paramOutputStream.g(paramInputStream.Ups, i2) | i2 << 1;
              }
              i2 = 0;
              break;
            }
            i3 = i2;
          } while (i2 < 256);
          i3 = i2;
          i = (byte)i3;
          label515:
          paramInputStream = this.UoR;
          paramOutputStream = paramInputStream.UoN;
          i2 = paramInputStream.Ucm;
          paramInputStream.Ucm = (i2 + 1);
          paramOutputStream[i2] = i;
          if (paramInputStream.Ucm >= paramInputStream.UoO) {
            paramInputStream.hRp();
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
          paramOutputStream = this.UoS;
          i2 = 1;
          do
          {
            i3 = paramOutputStream.g(paramInputStream.Ups, i2) | i2 << 1;
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
      if (this.UoS.g(this.UoU, i1) == 1)
      {
        i3 = 0;
        if (this.UoS.g(this.UoV, i1) == 0)
        {
          if (this.UoS.g(this.UoY, (i1 << 4) + i4) != 0) {
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
        i4 = this.Upd.a(this.UoS, i4) + 2;
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
        if ((i2 >= l) || (i2 >= this.Upg))
        {
          AppMethodBeat.o(155358);
          return false;
          i1 = 11;
          break label721;
          if (this.UoS.g(this.UoW, i1) == 0)
          {
            i2 = m;
            m = k;
            k = i2;
            i2 = i3;
            break label724;
          }
          if (this.UoS.g(this.UoX, i1) == 0) {}
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
          i2 = this.Upc.a(this.UoS, i4) + 2;
          if (i1 < 7)
          {
            n = 7;
            paramInputStream = this.UoZ;
            i1 = i2 - 2;
            if (i1 >= 4) {
              break label1069;
            }
          }
          int i7;
          for (;;)
          {
            i5 = paramInputStream[i1].a(this.UoS);
            if (i5 < 4) {
              break label1383;
            }
            i7 = (i5 >> 1) - 1;
            i6 = (i5 & 0x1 | 0x2) << i7;
            if (i5 >= 14) {
              break label1121;
            }
            paramInputStream = this.Upa;
            paramOutputStream = this.UoS;
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
          paramInputStream = this.UoS;
          i3 = i7 - 4;
          i1 = 0;
          while (i3 != 0)
          {
            paramInputStream.Upw >>>= 1;
            i4 = paramInputStream.NcY - paramInputStream.Upw >>> 31;
            paramInputStream.NcY -= (paramInputStream.Upw & i4 - 1);
            i1 = i1 << 1 | 1 - i4;
            if ((paramInputStream.Upw & 0xFF000000) == 0)
            {
              paramInputStream.NcY = (paramInputStream.NcY << 8 | paramInputStream.Upx.read());
              paramInputStream.Upw <<= 8;
            }
            i3 -= 1;
          }
          paramInputStream = this.Upb;
          paramOutputStream = this.UoS;
          i5 = 1;
          i4 = 0;
          i3 = 0;
          while (i3 < paramInputStream.Upv)
          {
            i7 = paramOutputStream.g(paramInputStream.Upu, i5);
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
        paramInputStream = this.UoR;
        i3 = paramInputStream.Ucm - i2 - 1;
        if (i3 < 0)
        {
          i3 += paramInputStream.UoO;
          i4 = j;
        }
        for (;;)
        {
          if (i4 != 0)
          {
            i5 = i3;
            if (i3 >= paramInputStream.UoO) {
              i5 = 0;
            }
            paramOutputStream = paramInputStream.UoN;
            i3 = paramInputStream.Ucm;
            paramInputStream.Ucm = (i3 + 1);
            paramOutputStream[i3] = paramInputStream.UoN[i5];
            if (paramInputStream.Ucm >= paramInputStream.UoO) {
              paramInputStream.hRp();
            }
            i4 -= 1;
            i3 = i5 + 1;
          }
          else
          {
            l += j;
            i4 = this.UoR.awq(0);
            j = m;
            m = n;
            i3 = i2;
            i2 = i4;
            n = k;
            k = m;
            m = i3;
            break;
            label1590:
            this.UoR.hRp();
            this.UoR.hRo();
            this.UoS.Upx = null;
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
  
  public final boolean dz(byte[] paramArrayOfByte)
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
      paramArrayOfByte = this.Upe;
      if ((paramArrayOfByte.Upo == null) || (paramArrayOfByte.Upp != m) || (paramArrayOfByte.Upq != n))
      {
        paramArrayOfByte.Upq = n;
        paramArrayOfByte.Upr = ((1 << n) - 1);
        paramArrayOfByte.Upp = m;
        m = 1 << paramArrayOfByte.Upp + paramArrayOfByte.Upq;
        paramArrayOfByte.Upo = new a.b.a[m];
        j = 0;
        while (j < m)
        {
          paramArrayOfByte.Upo[j] = new a.b.a(paramArrayOfByte);
          j += 1;
        }
      }
      j = 1 << k;
      this.Upc.awr(j);
      this.Upd.awr(j);
      this.Uph = (j - 1);
    }
    if (i < 0)
    {
      AppMethodBeat.o(155359);
      return false;
    }
    if (this.Upf != i)
    {
      this.Upf = i;
      this.Upg = Math.max(this.Upf, 1);
      paramArrayOfByte = this.UoR;
      i = Math.max(this.Upg, 4096);
      if ((paramArrayOfByte.UoN == null) || (paramArrayOfByte.UoO != i)) {
        paramArrayOfByte.UoN = new byte[i];
      }
      paramArrayOfByte.UoO = i;
      paramArrayOfByte.Ucm = 0;
      paramArrayOfByte.UoP = 0;
    }
    AppMethodBeat.o(155359);
    return true;
  }
  
  final class a
  {
    short[] Upi;
    i.a.c.a[] Upj;
    i.a.c.a[] Upk;
    i.a.c.a Upl;
    int Upm;
    
    a()
    {
      AppMethodBeat.i(155352);
      this.Upi = new short[2];
      this.Upj = new i.a.c.a[16];
      this.Upk = new i.a.c.a[16];
      this.Upl = new i.a.c.a(8);
      this.Upm = 0;
      AppMethodBeat.o(155352);
    }
    
    public final int a(b paramb, int paramInt)
    {
      AppMethodBeat.i(155355);
      if (paramb.g(this.Upi, 0) == 0)
      {
        paramInt = this.Upj[paramInt].a(paramb);
        AppMethodBeat.o(155355);
        return paramInt;
      }
      if (paramb.g(this.Upi, 1) == 0) {}
      for (paramInt = this.Upk[paramInt].a(paramb) + 8;; paramInt = this.Upl.a(paramb) + 8 + 8)
      {
        AppMethodBeat.o(155355);
        return paramInt;
      }
    }
    
    public final void awr(int paramInt)
    {
      AppMethodBeat.i(155353);
      while (this.Upm < paramInt)
      {
        this.Upj[this.Upm] = new i.a.c.a(3);
        this.Upk[this.Upm] = new i.a.c.a(3);
        this.Upm += 1;
      }
      AppMethodBeat.o(155353);
    }
    
    public final void hRq()
    {
      AppMethodBeat.i(155354);
      b.c(this.Upi);
      int i = 0;
      while (i < this.Upm)
      {
        b.c(this.Upj[i].Upu);
        b.c(this.Upk[i].Upu);
        i += 1;
      }
      b.c(this.Upl.Upu);
      AppMethodBeat.o(155354);
    }
  }
  
  final class b
  {
    a[] Upo;
    int Upp;
    int Upq;
    int Upr;
    
    b() {}
    
    final class a
    {
      short[] Ups;
      
      a()
      {
        AppMethodBeat.i(155356);
        this.Ups = new short[768];
        AppMethodBeat.o(155356);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     i.a.b.a
 * JD-Core Version:    0.7.0.1
 */