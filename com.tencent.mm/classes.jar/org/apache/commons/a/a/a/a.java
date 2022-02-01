package org.apache.commons.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

public final class a
  extends org.apache.commons.a.a.a
{
  private int aixs;
  private int ajTN;
  private int ajTO;
  private boolean ajTP;
  private int ajTQ;
  private int ajTR;
  private final b ajTS;
  private int ajTT;
  private InputStream ajTU;
  private int ajTV;
  private int ajTW;
  private int ajTX;
  private int ajTY;
  private int ajTZ;
  private int ajUa;
  private int ajUb;
  private int ajUc;
  private int ajUd;
  private int ajUe;
  private int ajUf;
  private int ajUg;
  private int ajUh;
  private char ajUi;
  private a ajUj;
  private int currentState;
  
  public a(InputStream paramInputStream)
  {
    AppMethodBeat.i(187179);
    this.ajTS = new b();
    this.ajTV = -1;
    this.currentState = 1;
    this.ajTU = paramInputStream;
    if (this.ajTU == null)
    {
      paramInputStream = new IOException("No InputStream");
      AppMethodBeat.o(187179);
      throw paramInputStream;
    }
    b('B', "first");
    b('Z', "second");
    b('h', "third");
    int i = this.ajTU.read();
    if ((i < 49) || (i > 57))
    {
      paramInputStream = new IOException("Stream is not BZip2 formatted: illegal blocksize " + (char)i);
      AppMethodBeat.o(187179);
      throw paramInputStream;
    }
    this.ajTO = (i - 48);
    kJh();
    kJm();
    AppMethodBeat.o(187179);
  }
  
  private void GK()
  {
    AppMethodBeat.i(187196);
    this.ajTX = kJk();
    this.currentState = 0;
    this.ajUj = null;
    if (this.ajTX != this.ajTZ)
    {
      IOException localIOException = new IOException("BZip2 CRC error");
      AppMethodBeat.o(187196);
      throw localIOException;
    }
    AppMethodBeat.o(187196);
  }
  
  private int aNr(int paramInt)
  {
    AppMethodBeat.i(187202);
    int k = this.ajTR;
    int j = this.ajTQ;
    int m = j;
    int i = k;
    if (k < paramInt)
    {
      Object localObject = this.ajTU;
      i = k;
      do
      {
        k = ((InputStream)localObject).read();
        if (k < 0)
        {
          localObject = new IOException("unexpected end of stream");
          AppMethodBeat.o(187202);
          throw ((Throwable)localObject);
        }
        k = j << 8 | k;
        m = i + 8;
        j = k;
        i = m;
      } while (m < paramInt);
      this.ajTQ = k;
      i = m;
      m = k;
    }
    this.ajTR = (i - paramInt);
    AppMethodBeat.o(187202);
    return m >> i - paramInt & (1 << paramInt) - 1;
  }
  
  private void b(char paramChar, String paramString)
  {
    AppMethodBeat.i(187185);
    char c = this.ajTU.read();
    if (c != paramChar)
    {
      paramString = new IOException("Stream is not BZip2 formatted: expected '" + paramChar + "' as " + paramString + " byte but got '" + (char)c + "'");
      AppMethodBeat.o(187185);
      throw paramString;
    }
    AppMethodBeat.o(187185);
  }
  
  private int kJg()
  {
    AppMethodBeat.i(187184);
    int i = this.ajTV;
    IllegalStateException localIllegalStateException;
    switch (this.currentState)
    {
    default: 
      localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(187184);
      throw localIllegalStateException;
    case 0: 
      AppMethodBeat.o(187184);
      return -1;
    case 1: 
      localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(187184);
      throw localIllegalStateException;
    case 2: 
      localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(187184);
      throw localIllegalStateException;
    case 3: 
      kJp();
    }
    for (;;)
    {
      AppMethodBeat.o(187184);
      return i;
      kJq();
      continue;
      localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(187184);
      throw localIllegalStateException;
      kJr();
      continue;
      kJs();
    }
  }
  
  private void kJh()
  {
    boolean bool = false;
    AppMethodBeat.i(187190);
    int i = (char)aNr(8);
    int j = (char)aNr(8);
    int k = (char)aNr(8);
    int m = (char)aNr(8);
    int n = (char)aNr(8);
    int i1 = (char)aNr(8);
    if ((i == 23) && (j == 114) && (k == 69) && (m == 56) && (n == 80) && (i1 == 144))
    {
      GK();
      AppMethodBeat.o(187190);
      return;
    }
    if ((i != 49) || (j != 65) || (k != 89) || (m != 38) || (n != 83) || (i1 != 89))
    {
      this.currentState = 0;
      IOException localIOException = new IOException("bad block header");
      AppMethodBeat.o(187190);
      throw localIOException;
    }
    this.ajTW = kJk();
    if (aNr(1) == 1) {
      bool = true;
    }
    this.ajTP = bool;
    if (this.ajUj == null) {
      this.ajUj = new a(this.ajTO);
    }
    kJl();
    this.ajTS.ajUA = -1;
    this.currentState = 1;
    AppMethodBeat.o(187190);
  }
  
  private void kJi()
  {
    AppMethodBeat.i(187193);
    this.ajTY = (this.ajTS.ajUA ^ 0xFFFFFFFF);
    if (this.ajTW != this.ajTY)
    {
      this.ajTZ = (this.ajTX << 1 | this.ajTX >>> 31);
      this.ajTZ ^= this.ajTW;
      IOException localIOException = new IOException("BZip2 CRC error");
      AppMethodBeat.o(187193);
      throw localIOException;
    }
    this.ajTZ = (this.ajTZ << 1 | this.ajTZ >>> 31);
    this.ajTZ ^= this.ajTY;
    AppMethodBeat.o(187193);
  }
  
  private boolean kJj()
  {
    AppMethodBeat.i(187205);
    int k = this.ajTR;
    int m = this.ajTQ;
    int j = m;
    int i = k;
    if (k <= 0)
    {
      i = this.ajTU.read();
      if (i < 0)
      {
        IOException localIOException = new IOException("unexpected end of stream");
        AppMethodBeat.o(187205);
        throw localIOException;
      }
      j = m << 8 | i;
      i = k + 8;
      this.ajTQ = j;
    }
    this.ajTR = (i - 1);
    if ((j >> i - 1 & 0x1) != 0)
    {
      AppMethodBeat.o(187205);
      return true;
    }
    AppMethodBeat.o(187205);
    return false;
  }
  
  private int kJk()
  {
    AppMethodBeat.i(187210);
    int i = aNr(8);
    int j = aNr(8);
    int k = aNr(8);
    int m = aNr(8);
    AppMethodBeat.o(187210);
    return ((i << 8 | j) << 8 | k) << 8 | m;
  }
  
  private void kJl()
  {
    AppMethodBeat.i(187232);
    this.ajTN = aNr(24);
    Object localObject1 = this.ajUj;
    Object localObject5 = ((a)localObject1).ajUk;
    Object localObject2 = ((a)localObject1).ajUw;
    Object localObject3 = ((a)localObject1).ajUm;
    Object localObject4 = ((a)localObject1).ajUn;
    int k = 0;
    int m = 0;
    int n;
    while (m < 16)
    {
      n = k;
      if (kJj()) {
        n = k | 1 << m;
      }
      m += 1;
      k = n;
    }
    m = 256;
    for (;;)
    {
      m -= 1;
      if (m < 0) {
        break;
      }
      localObject5[m] = 0;
    }
    m = 0;
    while (m < 16)
    {
      if ((1 << m & k) != 0)
      {
        n = 0;
        while (n < 16)
        {
          if (kJj()) {
            localObject5[((m << 4) + n)] = 1;
          }
          n += 1;
        }
      }
      m += 1;
    }
    localObject5 = this.ajUj.ajUk;
    Object localObject6 = this.ajUj.ajUl;
    k = 0;
    m = 0;
    if (m < 256)
    {
      if (localObject5[m] == 0) {
        break label2189;
      }
      n = k + 1;
      localObject6[k] = ((byte)m);
      k = n;
    }
    label642:
    label652:
    label2189:
    for (;;)
    {
      m += 1;
      break;
      this.ajTT = k;
      int i4 = this.ajTT + 2;
      int i5 = aNr(3);
      n = aNr(15);
      k = 0;
      while (k < n)
      {
        m = 0;
        while (kJj()) {
          m += 1;
        }
        localObject4[k] = ((byte)m);
        k += 1;
      }
      k = i5;
      for (;;)
      {
        k -= 1;
        if (k < 0) {
          break;
        }
        localObject2[k] = ((byte)k);
      }
      k = 0;
      int i;
      while (k < n)
      {
        m = localObject4[k] & 0xFF;
        i = localObject2[m];
        while (m > 0)
        {
          localObject2[m] = localObject2[(m - 1)];
          m -= 1;
        }
        localObject2[0] = i;
        localObject3[k] = i;
        k += 1;
      }
      localObject1 = ((a)localObject1).ajUv;
      k = 0;
      while (k < i5)
      {
        n = aNr(5);
        localObject2 = localObject1[k];
        m = 0;
        while (m < i4)
        {
          if (kJj())
          {
            if (kJj()) {}
            for (i1 = -1;; i1 = 1)
            {
              n += i1;
              break;
            }
          }
          localObject2[m] = ((char)n);
          m += 1;
        }
        k += 1;
      }
      localObject5 = this.ajUj;
      localObject1 = ((a)localObject5).ajUv;
      localObject2 = ((a)localObject5).ajUs;
      localObject3 = ((a)localObject5).ajUp;
      localObject4 = ((a)localObject5).ajUq;
      localObject5 = ((a)localObject5).ajUr;
      int i1 = 0;
      int i2;
      label592:
      label601:
      byte[] arrayOfByte1;
      byte[] arrayOfByte2;
      char[] arrayOfChar;
      int i3;
      int i6;
      if (i1 < i5)
      {
        k = 32;
        m = 0;
        localObject6 = localObject1[i1];
        for (n = i4;; n = i2)
        {
          i2 = n - 1;
          if (i2 < 0) {
            break;
          }
          n = localObject6[i2];
          if (n <= m) {
            break label2183;
          }
          m = n;
          if (n >= k) {
            break label2180;
          }
          k = n;
        }
        localObject6 = localObject3[i1];
        arrayOfByte1 = localObject4[i1];
        arrayOfByte2 = localObject5[i1];
        arrayOfChar = localObject1[i1];
        n = 0;
        i2 = k;
        if (i2 <= m)
        {
          i3 = 0;
          if (i3 < i4)
          {
            if (arrayOfChar[i3] != i2) {
              break label2186;
            }
            i6 = n + 1;
            arrayOfByte2[n] = i3;
            n = i6;
          }
        }
      }
      for (;;)
      {
        i3 += 1;
        break label652;
        i2 += 1;
        break label642;
        n = 23;
        for (;;)
        {
          n -= 1;
          if (n <= 0) {
            break;
          }
          arrayOfByte1[n] = 0;
          localObject6[n] = 0;
        }
        n = 0;
        while (n < i4)
        {
          i2 = arrayOfChar[n] + 1;
          arrayOfByte1[i2] += 1;
          n += 1;
        }
        n = 1;
        i2 = arrayOfByte1[0];
        while (n < 23)
        {
          i2 += arrayOfByte1[n];
          arrayOfByte1[n] = i2;
          n += 1;
        }
        i2 = arrayOfByte1[k];
        i3 = 0;
        n = k;
        while (n <= m)
        {
          i6 = arrayOfByte1[(n + 1)];
          i2 = i6 - i2 + i3;
          localObject6[n] = (i2 - 1);
          i3 = i2 << 1;
          n += 1;
          i2 = i6;
        }
        n = k + 1;
        while (n <= m)
        {
          arrayOfByte1[n] = ((localObject6[(n - 1)] + 1 << 1) - arrayOfByte1[n]);
          n += 1;
        }
        localObject2[i1] = k;
        i1 += 1;
        break;
        localObject4 = this.ajTU;
        localObject1 = this.ajUj;
        localObject5 = ((a)localObject1).ajUy;
        localObject6 = ((a)localObject1).ajUo;
        arrayOfByte1 = ((a)localObject1).ajUm;
        arrayOfByte2 = ((a)localObject1).ajUl;
        arrayOfChar = ((a)localObject1).ajUu;
        int[] arrayOfInt = ((a)localObject1).ajUs;
        int[][] arrayOfInt1 = ((a)localObject1).ajUp;
        int[][] arrayOfInt2 = ((a)localObject1).ajUq;
        int[][] arrayOfInt3 = ((a)localObject1).ajUr;
        int i10 = this.ajTO * 100000;
        k = 256;
        for (;;)
        {
          k -= 1;
          if (k < 0) {
            break;
          }
          arrayOfChar[k] = ((char)k);
          localObject6[k] = 0;
        }
        i2 = 49;
        int i11 = this.ajTT;
        localObject1 = this.ajTU;
        localObject2 = this.ajUj;
        i3 = localObject2.ajUm[0] & 0xFF;
        localObject3 = localObject2.ajUp[i3];
        i1 = localObject2.ajUs[i3];
        m = aNr(i1);
        k = this.ajTR;
        n = this.ajTQ;
        while (m > localObject3[i1])
        {
          i1 += 1;
          while (k <= 0)
          {
            i4 = ((InputStream)localObject1).read();
            if (i4 >= 0)
            {
              n = n << 8 | i4;
              k += 8;
            }
            else
            {
              localObject1 = new IOException("unexpected end of stream");
              AppMethodBeat.o(187232);
              throw ((Throwable)localObject1);
            }
          }
          k -= 1;
          m = m << 1 | n >> k & 0x1;
        }
        this.ajTR = k;
        this.ajTQ = n;
        i4 = localObject2.ajUr[i3][(m - localObject2.ajUq[i3][i1])];
        n = this.ajTQ;
        k = this.ajTR;
        m = -1;
        i1 = arrayOfByte1[0] & 0xFF;
        localObject3 = arrayOfInt2[i1];
        localObject2 = arrayOfInt1[i1];
        localObject1 = arrayOfInt3[i1];
        i3 = arrayOfInt[i1];
        i5 = 0;
        i1 = i2;
        i2 = i5;
        while (i4 != i11 + 1) {
          if ((i4 == 0) || (i4 == 1))
          {
            i5 = -1;
            i6 = 1;
            int i9 = i4;
            i4 = i1;
            i1 = n;
            int i8 = i3;
            int i7 = i2;
            for (;;)
            {
              if (i9 == 0)
              {
                n = i5 + i6;
                if (i4 != 0) {
                  break label1478;
                }
                i3 = 49;
                i4 = i7 + 1;
                i2 = arrayOfByte1[i4] & 0xFF;
                localObject3 = arrayOfInt2[i2];
                localObject2 = arrayOfInt1[i2];
                localObject1 = arrayOfInt3[i2];
                i2 = arrayOfInt[i2];
              }
              for (;;)
              {
                if (k < i2)
                {
                  i5 = ((InputStream)localObject4).read();
                  if (i5 >= 0)
                  {
                    i1 = i1 << 8 | i5;
                    k += 8;
                    continue;
                    if (i9 != 1) {
                      break label1666;
                    }
                    n = (i6 << 1) + i5;
                    break;
                    label1478:
                    i3 = i4 - 1;
                    i4 = i7;
                    i2 = i8;
                    continue;
                  }
                  localObject1 = new IOException("unexpected end of stream");
                  AppMethodBeat.o(187232);
                  throw ((Throwable)localObject1);
                }
              }
              i5 = i1 >> k - i2 & (1 << i2) - 1;
              k -= i2;
              i7 = i2;
              while (i5 > localObject2[i7])
              {
                i7 += 1;
                while (k <= 0)
                {
                  i8 = ((InputStream)localObject4).read();
                  if (i8 >= 0)
                  {
                    i1 = i1 << 8 | i8;
                    k += 8;
                  }
                  else
                  {
                    localObject1 = new IOException("unexpected end of stream");
                    AppMethodBeat.o(187232);
                    throw ((Throwable)localObject1);
                  }
                }
                k -= 1;
                i5 = i5 << 1 | i1 >> k & 0x1;
              }
              i9 = localObject1[(i5 - localObject3[i7])];
              i6 <<= 1;
              i7 = i4;
              i8 = i2;
              i5 = n;
              i4 = i3;
            }
            i = arrayOfByte2[arrayOfChar[0]];
            n = i & 0xFF;
            localObject6[n] += i5 + 1;
            while (i5 >= 0)
            {
              m += 1;
              localObject5[m] = i;
              i5 -= 1;
            }
            if (m >= i10)
            {
              localObject1 = new IOException("block overrun");
              AppMethodBeat.o(187232);
              throw ((Throwable)localObject1);
            }
            i2 = i7;
            i3 = i8;
            n = i1;
            i1 = i4;
            i4 = i9;
          }
          else
          {
            i5 = m + 1;
            if (i5 >= i10)
            {
              localObject1 = new IOException("block overrun");
              AppMethodBeat.o(187232);
              throw ((Throwable)localObject1);
            }
            int j = arrayOfChar[(i4 - 1)];
            m = arrayOfByte2[j] & 0xFF;
            localObject6[m] += 1;
            localObject5[i5] = arrayOfByte2[j];
            if (i4 <= 16) {
              for (m = i4 - 1; m > 0; m = i4)
              {
                i4 = m - 1;
                arrayOfChar[m] = arrayOfChar[i4];
              }
            }
            System.arraycopy(arrayOfChar, 0, arrayOfChar, 1, i4 - 1);
            arrayOfChar[0] = j;
            if (i1 == 0)
            {
              m = 49;
              i2 += 1;
              i1 = arrayOfByte1[i2] & 0xFF;
              localObject3 = arrayOfInt2[i1];
              localObject2 = arrayOfInt1[i1];
              localObject1 = arrayOfInt3[i1];
              i3 = arrayOfInt[i1];
            }
            while (k < i3)
            {
              i1 = ((InputStream)localObject4).read();
              if (i1 >= 0)
              {
                n = n << 8 | i1;
                k += 8;
                continue;
                m = i1 - 1;
              }
              else
              {
                localObject1 = new IOException("unexpected end of stream");
                AppMethodBeat.o(187232);
                throw ((Throwable)localObject1);
              }
            }
            i1 = (1 << i3) - 1 & n >> k - i3;
            k -= i3;
            i4 = i3;
            while (i1 > localObject2[i4])
            {
              i4 += 1;
              while (k <= 0)
              {
                i6 = ((InputStream)localObject4).read();
                if (i6 >= 0)
                {
                  n = n << 8 | i6;
                  k += 8;
                }
                else
                {
                  localObject1 = new IOException("unexpected end of stream");
                  AppMethodBeat.o(187232);
                  throw ((Throwable)localObject1);
                }
              }
              k -= 1;
              i1 = i1 << 1 | n >> k & 0x1;
            }
            i4 = localObject1[(i1 - localObject3[i4])];
            i1 = m;
            m = i5;
          }
        }
        this.aixs = m;
        this.ajTR = k;
        this.ajTQ = n;
        AppMethodBeat.o(187232);
        return;
        break label601;
        break label592;
      }
    }
  }
  
  private void kJm()
  {
    int i = 1;
    AppMethodBeat.i(187239);
    if (this.ajUj == null)
    {
      AppMethodBeat.o(187239);
      return;
    }
    int[] arrayOfInt = this.ajUj.ajUt;
    a locala = this.ajUj;
    int j = this.aixs + 1;
    Object localObject2 = locala.ajUx;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length >= j) {}
    }
    else
    {
      localObject1 = new int[j];
      locala.ajUx = ((int[])localObject1);
    }
    localObject2 = this.ajUj.ajUy;
    arrayOfInt[0] = 0;
    System.arraycopy(this.ajUj.ajUo, 0, arrayOfInt, 1, 256);
    j = arrayOfInt[0];
    while (i <= 256)
    {
      j += arrayOfInt[i];
      arrayOfInt[i] = j;
      i += 1;
    }
    j = this.aixs;
    i = 0;
    while (i <= j)
    {
      int k = localObject2[i] & 0xFF;
      int m = arrayOfInt[k];
      arrayOfInt[k] = (m + 1);
      localObject1[m] = i;
      i += 1;
    }
    if ((this.ajTN < 0) || (this.ajTN >= localObject1.length))
    {
      localObject1 = new IOException("stream corrupted");
      AppMethodBeat.o(187239);
      throw ((Throwable)localObject1);
    }
    this.ajUh = localObject1[this.ajTN];
    this.ajUa = 0;
    this.ajUd = 0;
    this.ajUb = 256;
    if (this.ajTP)
    {
      this.ajUf = 0;
      this.ajUg = 0;
      kJn();
      AppMethodBeat.o(187239);
      return;
    }
    kJo();
    AppMethodBeat.o(187239);
  }
  
  private void kJn()
  {
    int i = 1;
    AppMethodBeat.i(187246);
    if (this.ajUd <= this.aixs)
    {
      this.ajUc = this.ajUb;
      int j = this.ajUj.ajUy[this.ajUh];
      this.ajUh = this.ajUj.ajUx[this.ajUh];
      if (this.ajUf == 0)
      {
        this.ajUf = (c.aNt(this.ajUg) - 1);
        int k = this.ajUg + 1;
        this.ajUg = k;
        if (k == 512) {
          this.ajUg = 0;
        }
        if (this.ajUf != 1) {
          break label169;
        }
      }
      for (;;)
      {
        i ^= j & 0xFF;
        this.ajUb = i;
        this.ajUd += 1;
        this.ajTV = i;
        this.currentState = 3;
        this.ajTS.aNs(i);
        AppMethodBeat.o(187246);
        return;
        this.ajUf -= 1;
        break;
        label169:
        i = 0;
      }
    }
    kJi();
    kJh();
    kJm();
    AppMethodBeat.o(187246);
  }
  
  private void kJo()
  {
    AppMethodBeat.i(187258);
    if (this.ajUd <= this.aixs)
    {
      this.ajUc = this.ajUb;
      int i = this.ajUj.ajUy[this.ajUh] & 0xFF;
      this.ajUb = i;
      this.ajUh = this.ajUj.ajUx[this.ajUh];
      this.ajUd += 1;
      this.ajTV = i;
      this.currentState = 6;
      this.ajTS.aNs(i);
      AppMethodBeat.o(187258);
      return;
    }
    this.currentState = 5;
    kJi();
    kJh();
    kJm();
    AppMethodBeat.o(187258);
  }
  
  private void kJp()
  {
    AppMethodBeat.i(187273);
    if (this.ajUb != this.ajUc)
    {
      this.currentState = 2;
      this.ajUa = 1;
      kJn();
      AppMethodBeat.o(187273);
      return;
    }
    int i = this.ajUa + 1;
    this.ajUa = i;
    if (i >= 4)
    {
      this.ajUi = ((char)(this.ajUj.ajUy[this.ajUh] & 0xFF));
      this.ajUh = this.ajUj.ajUx[this.ajUh];
      if (this.ajUf == 0)
      {
        this.ajUf = (c.aNt(this.ajUg) - 1);
        i = this.ajUg + 1;
        this.ajUg = i;
        if (i == 512) {
          this.ajUg = 0;
        }
      }
      for (;;)
      {
        this.ajUe = 0;
        this.currentState = 4;
        if (this.ajUf == 1) {
          this.ajUi = ((char)(this.ajUi ^ 0x1));
        }
        kJq();
        AppMethodBeat.o(187273);
        return;
        this.ajUf -= 1;
      }
    }
    this.currentState = 2;
    kJn();
    AppMethodBeat.o(187273);
  }
  
  private void kJq()
  {
    AppMethodBeat.i(187280);
    if (this.ajUe < this.ajUi)
    {
      this.ajTV = this.ajUb;
      this.ajTS.aNs(this.ajUb);
      this.ajUe += 1;
      AppMethodBeat.o(187280);
      return;
    }
    this.currentState = 2;
    this.ajUd += 1;
    this.ajUa = 0;
    kJn();
    AppMethodBeat.o(187280);
  }
  
  private void kJr()
  {
    AppMethodBeat.i(187291);
    if (this.ajUb != this.ajUc) {
      this.ajUa = 1;
    }
    int i;
    do
    {
      kJo();
      AppMethodBeat.o(187291);
      return;
      i = this.ajUa + 1;
      this.ajUa = i;
    } while (i < 4);
    this.ajUi = ((char)(this.ajUj.ajUy[this.ajUh] & 0xFF));
    this.ajUh = this.ajUj.ajUx[this.ajUh];
    this.ajUe = 0;
    kJs();
    AppMethodBeat.o(187291);
  }
  
  private void kJs()
  {
    AppMethodBeat.i(187298);
    if (this.ajUe < this.ajUi)
    {
      int i = this.ajUb;
      this.ajTV = i;
      this.ajTS.aNs(i);
      this.ajUe += 1;
      this.currentState = 7;
      AppMethodBeat.o(187298);
      return;
    }
    this.ajUd += 1;
    this.ajUa = 0;
    kJo();
    AppMethodBeat.o(187298);
  }
  
  public final void close()
  {
    AppMethodBeat.i(187323);
    InputStream localInputStream = this.ajTU;
    if (localInputStream != null) {
      try
      {
        if (localInputStream != System.in) {
          localInputStream.close();
        }
        return;
      }
      finally
      {
        this.ajUj = null;
        this.ajTU = null;
        AppMethodBeat.o(187323);
      }
    }
    AppMethodBeat.o(187323);
  }
  
  public final int read()
  {
    AppMethodBeat.i(187306);
    if (this.ajTU != null)
    {
      int j = kJg();
      if (j < 0) {}
      for (int i = -1;; i = 1)
      {
        aNq(i);
        AppMethodBeat.o(187306);
        return j;
      }
    }
    IOException localIOException = new IOException("stream closed");
    AppMethodBeat.o(187306);
    throw localIOException;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187313);
    if (paramInt1 < 0)
    {
      paramArrayOfByte = new IndexOutOfBoundsException("offs(" + paramInt1 + ") < 0.");
      AppMethodBeat.o(187313);
      throw paramArrayOfByte;
    }
    if (paramInt2 < 0)
    {
      paramArrayOfByte = new IndexOutOfBoundsException("len(" + paramInt2 + ") < 0.");
      AppMethodBeat.o(187313);
      throw paramArrayOfByte;
    }
    if (paramInt1 + paramInt2 > paramArrayOfByte.length)
    {
      paramArrayOfByte = new IndexOutOfBoundsException("offs(" + paramInt1 + ") + len(" + paramInt2 + ") > dest.length(" + paramArrayOfByte.length + ").");
      AppMethodBeat.o(187313);
      throw paramArrayOfByte;
    }
    if (this.ajTU == null)
    {
      paramArrayOfByte = new IOException("stream closed");
      AppMethodBeat.o(187313);
      throw paramArrayOfByte;
    }
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      int j = kJg();
      if (j < 0) {
        break;
      }
      paramArrayOfByte[i] = ((byte)j);
      i += 1;
    }
    if (i == paramInt1) {}
    for (paramInt1 = -1;; paramInt1 = i - paramInt1)
    {
      aNq(paramInt1);
      AppMethodBeat.o(187313);
      return paramInt1;
    }
  }
  
  static final class a
  {
    final boolean[] ajUk;
    final byte[] ajUl;
    final byte[] ajUm;
    final byte[] ajUn;
    final int[] ajUo;
    final int[][] ajUp;
    final int[][] ajUq;
    final int[][] ajUr;
    final int[] ajUs;
    final int[] ajUt;
    final char[] ajUu;
    final char[][] ajUv;
    final byte[] ajUw;
    int[] ajUx;
    byte[] ajUy;
    
    a(int paramInt)
    {
      AppMethodBeat.i(187189);
      this.ajUk = new boolean[256];
      this.ajUl = new byte[256];
      this.ajUm = new byte[18002];
      this.ajUn = new byte[18002];
      this.ajUo = new int[256];
      this.ajUp = ((int[][])Array.newInstance(Integer.TYPE, new int[] { 6, 258 }));
      this.ajUq = ((int[][])Array.newInstance(Integer.TYPE, new int[] { 6, 258 }));
      this.ajUr = ((int[][])Array.newInstance(Integer.TYPE, new int[] { 6, 258 }));
      this.ajUs = new int[6];
      this.ajUt = new int[257];
      this.ajUu = new char[256];
      this.ajUv = ((char[][])Array.newInstance(Character.TYPE, new int[] { 6, 258 }));
      this.ajUw = new byte[6];
      this.ajUy = new byte[100000 * paramInt];
      AppMethodBeat.o(187189);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     org.apache.commons.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */