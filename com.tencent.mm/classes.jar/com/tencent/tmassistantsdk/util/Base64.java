package com.tencent.tmassistantsdk.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;

public class Base64
{
  public static final int CRLF = 4;
  public static final int DEFAULT = 0;
  public static final int NO_CLOSE = 16;
  public static final int NO_PADDING = 1;
  public static final int NO_WRAP = 2;
  public static final int URL_SAFE = 8;
  
  static
  {
    AppMethodBeat.i(102469);
    if (!Base64.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(102469);
      return;
    }
  }
  
  public static byte[] decode(String paramString, int paramInt)
  {
    AppMethodBeat.i(102463);
    paramString = decode(paramString.getBytes(), paramInt);
    AppMethodBeat.o(102463);
    return paramString;
  }
  
  public static byte[] decode(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(102464);
    paramArrayOfByte = decode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
    AppMethodBeat.o(102464);
    return paramArrayOfByte;
  }
  
  public static byte[] decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(102465);
    Decoder localDecoder = new Decoder(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (!localDecoder.process(paramArrayOfByte, paramInt1, paramInt2, true))
    {
      paramArrayOfByte = new IllegalArgumentException("bad base-64");
      AppMethodBeat.o(102465);
      throw paramArrayOfByte;
    }
    if (localDecoder.op == localDecoder.output.length)
    {
      paramArrayOfByte = localDecoder.output;
      AppMethodBeat.o(102465);
      return paramArrayOfByte;
    }
    paramArrayOfByte = new byte[localDecoder.op];
    System.arraycopy(localDecoder.output, 0, paramArrayOfByte, 0, localDecoder.op);
    AppMethodBeat.o(102465);
    return paramArrayOfByte;
  }
  
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(102467);
    paramArrayOfByte = encode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
    AppMethodBeat.o(102467);
    return paramArrayOfByte;
  }
  
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(102468);
    Encoder localEncoder = new Encoder(paramInt3, null);
    int i = paramInt2 / 3 * 4;
    int j;
    if (localEncoder.do_padding)
    {
      paramInt3 = i;
      if (paramInt2 % 3 > 0) {
        paramInt3 = i + 4;
      }
      i = paramInt3;
      if (localEncoder.do_newline)
      {
        i = paramInt3;
        if (paramInt2 > 0)
        {
          j = (paramInt2 - 1) / 57;
          if (!localEncoder.do_cr) {
            break label198;
          }
        }
      }
    }
    label198:
    for (i = 2;; i = 1)
    {
      i = paramInt3 + i * (j + 1);
      localEncoder.output = new byte[i];
      localEncoder.process(paramArrayOfByte, paramInt1, paramInt2, true);
      if (($assertionsDisabled) || (localEncoder.op == i)) {
        break label204;
      }
      paramArrayOfByte = new AssertionError();
      AppMethodBeat.o(102468);
      throw paramArrayOfByte;
      paramInt3 = i;
      switch (paramInt2 % 3)
      {
      case 0: 
      default: 
        paramInt3 = i;
        break;
      case 1: 
        paramInt3 = i + 2;
        break;
      case 2: 
        paramInt3 = i + 3;
        break;
      }
    }
    label204:
    paramArrayOfByte = localEncoder.output;
    AppMethodBeat.o(102468);
    return paramArrayOfByte;
  }
  
  public static String encodeToString(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(102466);
    try
    {
      paramArrayOfByte = new String(encode(paramArrayOfByte, paramInt), "US-ASCII");
      AppMethodBeat.o(102466);
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      paramArrayOfByte = new AssertionError(paramArrayOfByte);
      AppMethodBeat.o(102466);
      throw paramArrayOfByte;
    }
  }
  
  static abstract class Coder
  {
    public int op;
    public byte[] output;
    
    public abstract int maxOutputSize(int paramInt);
    
    public abstract boolean process(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
  }
  
  static class Decoder
    extends Base64.Coder
  {
    private static final int[] DECODE = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    private static final int[] DECODE_WEBSAFE = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    private static final int EQUALS = -2;
    private static final int SKIP = -1;
    private final int[] alphabet;
    private int state;
    private int value;
    
    public Decoder(int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(102459);
      this.output = paramArrayOfByte;
      if ((paramInt & 0x8) == 0) {}
      for (paramArrayOfByte = DECODE;; paramArrayOfByte = DECODE_WEBSAFE)
      {
        this.alphabet = paramArrayOfByte;
        this.state = 0;
        this.value = 0;
        AppMethodBeat.o(102459);
        return;
      }
    }
    
    public int maxOutputSize(int paramInt)
    {
      return paramInt * 3 / 4 + 10;
    }
    
    public boolean process(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      if (this.state == 6) {
        return false;
      }
      int i1 = paramInt2 + paramInt1;
      paramInt2 = this.state;
      int i = this.value;
      int j = 0;
      byte[] arrayOfByte = this.output;
      int[] arrayOfInt = this.alphabet;
      int m = j;
      int n = i;
      if (paramInt1 < i1)
      {
        int k = j;
        m = i;
        n = paramInt1;
        if (paramInt2 == 0)
        {
          k = paramInt1;
          for (paramInt1 = i; k + 4 <= i1; paramInt1 = i)
          {
            i = arrayOfInt[(paramArrayOfByte[k] & 0xFF)] << 18 | arrayOfInt[(paramArrayOfByte[(k + 1)] & 0xFF)] << 12 | arrayOfInt[(paramArrayOfByte[(k + 2)] & 0xFF)] << 6 | arrayOfInt[(paramArrayOfByte[(k + 3)] & 0xFF)];
            paramInt1 = i;
            if (i < 0) {
              break;
            }
            arrayOfByte[(j + 2)] = ((byte)i);
            arrayOfByte[(j + 1)] = ((byte)(i >> 8));
            arrayOfByte[j] = ((byte)(i >> 16));
            j += 3;
            k += 4;
          }
          m = j;
          n = paramInt1;
          if (k < i1)
          {
            n = k;
            m = paramInt1;
            k = j;
          }
        }
        else
        {
          paramInt1 = n + 1;
          i = arrayOfInt[(paramArrayOfByte[n] & 0xFF)];
          switch (paramInt2)
          {
          }
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      j = k;
                      i = m;
                      break;
                      if (i >= 0)
                      {
                        paramInt2 += 1;
                        j = k;
                        break;
                      }
                    } while (i == -1);
                    this.state = 6;
                    return false;
                    if (i >= 0)
                    {
                      i = m << 6 | i;
                      paramInt2 += 1;
                      j = k;
                      break;
                    }
                  } while (i == -1);
                  this.state = 6;
                  return false;
                  if (i >= 0)
                  {
                    i = m << 6 | i;
                    paramInt2 += 1;
                    j = k;
                    break;
                  }
                  if (i == -2)
                  {
                    arrayOfByte[k] = ((byte)(m >> 4));
                    paramInt2 = 4;
                    j = k + 1;
                    i = m;
                    break;
                  }
                } while (i == -1);
                this.state = 6;
                return false;
                if (i >= 0)
                {
                  i = m << 6 | i;
                  arrayOfByte[(k + 2)] = ((byte)i);
                  arrayOfByte[(k + 1)] = ((byte)(i >> 8));
                  arrayOfByte[k] = ((byte)(i >> 16));
                  j = k + 3;
                  paramInt2 = 0;
                  break;
                }
                if (i == -2)
                {
                  arrayOfByte[(k + 1)] = ((byte)(m >> 2));
                  arrayOfByte[k] = ((byte)(m >> 10));
                  j = k + 2;
                  paramInt2 = 5;
                  i = m;
                  break;
                }
              } while (i == -1);
              this.state = 6;
              return false;
              if (i == -2)
              {
                paramInt2 += 1;
                j = k;
                i = m;
                break;
              }
            } while (i == -1);
            this.state = 6;
            return false;
          } while (i == -1);
          this.state = 6;
          return false;
        }
      }
      if (!paramBoolean)
      {
        this.state = paramInt2;
        this.value = n;
        this.op = m;
        return true;
      }
      paramInt1 = m;
      switch (paramInt2)
      {
      default: 
        paramInt1 = m;
      case 0: 
      case 1: 
      case 2: 
      case 3: 
        for (;;)
        {
          this.state = paramInt2;
          this.op = paramInt1;
          return true;
          this.state = 6;
          return false;
          arrayOfByte[m] = ((byte)(n >> 4));
          paramInt1 = m + 1;
          continue;
          i = m + 1;
          arrayOfByte[m] = ((byte)(n >> 10));
          paramInt1 = i + 1;
          arrayOfByte[i] = ((byte)(n >> 2));
        }
      }
      this.state = 6;
      return false;
    }
  }
  
  static class Encoder
    extends Base64.Coder
  {
    private static final byte[] ENCODE;
    private static final byte[] ENCODE_WEBSAFE;
    public static final int LINE_GROUPS = 19;
    private final byte[] alphabet;
    private int count;
    public final boolean do_cr;
    public final boolean do_newline;
    public final boolean do_padding;
    private final byte[] tail;
    int tailLen;
    
    static
    {
      AppMethodBeat.i(102462);
      if (!Base64.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        ENCODE = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
        ENCODE_WEBSAFE = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
        AppMethodBeat.o(102462);
        return;
      }
    }
    
    public Encoder(int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(102460);
      this.output = paramArrayOfByte;
      boolean bool1;
      if ((paramInt & 0x1) == 0)
      {
        bool1 = true;
        this.do_padding = bool1;
        if ((paramInt & 0x2) != 0) {
          break label111;
        }
        bool1 = true;
        label38:
        this.do_newline = bool1;
        if ((paramInt & 0x4) == 0) {
          break label116;
        }
        bool1 = bool2;
        label52:
        this.do_cr = bool1;
        if ((paramInt & 0x8) != 0) {
          break label121;
        }
        paramArrayOfByte = ENCODE;
        label68:
        this.alphabet = paramArrayOfByte;
        this.tail = new byte[2];
        this.tailLen = 0;
        if (!this.do_newline) {
          break label128;
        }
      }
      label128:
      for (paramInt = 19;; paramInt = -1)
      {
        this.count = paramInt;
        AppMethodBeat.o(102460);
        return;
        bool1 = false;
        break;
        label111:
        bool1 = false;
        break label38;
        label116:
        bool1 = false;
        break label52;
        label121:
        paramArrayOfByte = ENCODE_WEBSAFE;
        break label68;
      }
    }
    
    public int maxOutputSize(int paramInt)
    {
      return paramInt * 8 / 5 + 10;
    }
    
    public boolean process(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(102461);
      byte[] arrayOfByte1 = this.alphabet;
      byte[] arrayOfByte2 = this.output;
      int j = 0;
      int k = this.count;
      int n = paramInt2 + paramInt1;
      int i;
      switch (this.tailLen)
      {
      default: 
        paramInt2 = -1;
        i = paramInt1;
        paramInt1 = paramInt2;
        label67:
        if (paramInt1 != -1)
        {
          arrayOfByte2[0] = arrayOfByte1[(paramInt1 >> 18 & 0x3F)];
          arrayOfByte2[1] = arrayOfByte1[(paramInt1 >> 12 & 0x3F)];
          arrayOfByte2[2] = arrayOfByte1[(paramInt1 >> 6 & 0x3F)];
          paramInt2 = 4;
          arrayOfByte2[3] = arrayOfByte1[(paramInt1 & 0x3F)];
          paramInt1 = k - 1;
          if (paramInt1 == 0)
          {
            paramInt1 = paramInt2;
            if (this.do_cr)
            {
              paramInt1 = 5;
              arrayOfByte2[4] = 13;
            }
            j = paramInt1 + 1;
            arrayOfByte2[paramInt1] = 10;
            paramInt2 = 19;
            paramInt1 = j;
          }
        }
        break;
      }
      for (;;)
      {
        label170:
        if (i + 3 <= n)
        {
          j = (paramArrayOfByte[i] & 0xFF) << 16 | (paramArrayOfByte[(i + 1)] & 0xFF) << 8 | paramArrayOfByte[(i + 2)] & 0xFF;
          arrayOfByte2[paramInt1] = arrayOfByte1[(j >> 18 & 0x3F)];
          arrayOfByte2[(paramInt1 + 1)] = arrayOfByte1[(j >> 12 & 0x3F)];
          arrayOfByte2[(paramInt1 + 2)] = arrayOfByte1[(j >> 6 & 0x3F)];
          arrayOfByte2[(paramInt1 + 3)] = arrayOfByte1[(j & 0x3F)];
          i += 3;
          paramInt1 += 4;
          paramInt2 -= 1;
          if (paramInt2 != 0) {
            break label1224;
          }
          if (!this.do_cr) {
            break label1221;
          }
          paramInt2 = paramInt1 + 1;
          arrayOfByte2[paramInt1] = 13;
          paramInt1 = paramInt2;
        }
        label772:
        label950:
        label1218:
        label1221:
        for (;;)
        {
          paramInt2 = paramInt1 + 1;
          arrayOfByte2[paramInt1] = 10;
          j = 19;
          paramInt1 = paramInt2;
          paramInt2 = j;
          break label170;
          paramInt2 = -1;
          i = paramInt1;
          paramInt1 = paramInt2;
          break label67;
          if (paramInt1 + 2 > n) {
            break;
          }
          i = this.tail[0];
          paramInt2 = paramInt1 + 1;
          paramInt1 = paramArrayOfByte[paramInt1];
          int m = paramArrayOfByte[paramInt2];
          this.tailLen = 0;
          paramInt1 = (i & 0xFF) << 16 | (paramInt1 & 0xFF) << 8 | m & 0xFF;
          i = paramInt2 + 1;
          break label67;
          if (paramInt1 + 1 > n) {
            break;
          }
          paramInt2 = this.tail[0];
          m = this.tail[1];
          i = paramInt1 + 1;
          paramInt1 = paramArrayOfByte[paramInt1];
          this.tailLen = 0;
          paramInt1 = (paramInt2 & 0xFF) << 16 | (m & 0xFF) << 8 | paramInt1 & 0xFF;
          break label67;
          if (paramBoolean)
          {
            if (i - this.tailLen == n - 1)
            {
              j = 0;
              if (this.tailLen > 0)
              {
                paramArrayOfByte = this.tail;
                j = 1;
                k = paramArrayOfByte[0];
              }
              for (;;)
              {
                k = (k & 0xFF) << 4;
                this.tailLen -= j;
                m = paramInt1 + 1;
                arrayOfByte2[paramInt1] = arrayOfByte1[(k >> 6 & 0x3F)];
                j = m + 1;
                arrayOfByte2[m] = arrayOfByte1[(k & 0x3F)];
                paramInt1 = j;
                if (this.do_padding)
                {
                  k = j + 1;
                  arrayOfByte2[j] = 61;
                  paramInt1 = k + 1;
                  arrayOfByte2[k] = 61;
                }
                j = paramInt1;
                if (this.do_newline)
                {
                  j = paramInt1;
                  if (this.do_cr)
                  {
                    arrayOfByte2[paramInt1] = 13;
                    j = paramInt1 + 1;
                  }
                  arrayOfByte2[j] = 10;
                  j += 1;
                }
                k = i;
                if (($assertionsDisabled) || (this.tailLen == 0)) {
                  break;
                }
                paramArrayOfByte = new AssertionError();
                AppMethodBeat.o(102461);
                throw paramArrayOfByte;
                m = i + 1;
                k = paramArrayOfByte[i];
                i = m;
              }
            }
            if (i - this.tailLen == n - 2)
            {
              j = 0;
              if (this.tailLen > 1)
              {
                k = this.tail[0];
                j = 1;
                label750:
                if (this.tailLen <= 0) {
                  break label950;
                }
                m = this.tail[j];
                j += 1;
                k = (m & 0xFF) << 2 | (k & 0xFF) << 10;
                this.tailLen -= j;
                j = paramInt1 + 1;
                arrayOfByte2[paramInt1] = arrayOfByte1[(k >> 12 & 0x3F)];
                m = j + 1;
                arrayOfByte2[j] = arrayOfByte1[(k >> 6 & 0x3F)];
                paramInt1 = m + 1;
                arrayOfByte2[m] = arrayOfByte1[(k & 0x3F)];
                if (!this.do_padding) {
                  break label1218;
                }
                j = paramInt1 + 1;
                arrayOfByte2[paramInt1] = 61;
                paramInt1 = j;
              }
            }
          }
          for (;;)
          {
            j = paramInt1;
            if (this.do_newline)
            {
              j = paramInt1;
              if (this.do_cr)
              {
                arrayOfByte2[paramInt1] = 13;
                j = paramInt1 + 1;
              }
              arrayOfByte2[j] = 10;
              j += 1;
            }
            k = i;
            break;
            k = paramArrayOfByte[i];
            i += 1;
            break label750;
            m = paramArrayOfByte[i];
            i += 1;
            break label772;
            k = i;
            j = paramInt1;
            if (!this.do_newline) {
              break;
            }
            k = i;
            j = paramInt1;
            if (paramInt1 <= 0) {
              break;
            }
            k = i;
            j = paramInt1;
            if (paramInt2 == 19) {
              break;
            }
            if (this.do_cr)
            {
              j = paramInt1 + 1;
              arrayOfByte2[paramInt1] = 13;
              paramInt1 = j;
            }
            for (;;)
            {
              j = paramInt1 + 1;
              arrayOfByte2[paramInt1] = 10;
              k = i;
              break;
              m = j;
              if (!$assertionsDisabled)
              {
                m = j;
                if (k != n)
                {
                  paramArrayOfByte = new AssertionError();
                  AppMethodBeat.o(102461);
                  throw paramArrayOfByte;
                  if (i != n - 1) {
                    break label1137;
                  }
                  arrayOfByte1 = this.tail;
                  j = this.tailLen;
                  this.tailLen = (j + 1);
                  arrayOfByte1[j] = paramArrayOfByte[i];
                  m = paramInt1;
                }
              }
              for (;;)
              {
                this.op = m;
                this.count = paramInt2;
                AppMethodBeat.o(102461);
                return true;
                label1137:
                m = paramInt1;
                if (i == n - 2)
                {
                  arrayOfByte1 = this.tail;
                  j = this.tailLen;
                  this.tailLen = (j + 1);
                  arrayOfByte1[j] = paramArrayOfByte[i];
                  arrayOfByte1 = this.tail;
                  j = this.tailLen;
                  this.tailLen = (j + 1);
                  arrayOfByte1[j] = paramArrayOfByte[(i + 1)];
                  m = paramInt1;
                }
              }
            }
          }
        }
        label1224:
        continue;
        paramInt2 = paramInt1;
        paramInt1 = 4;
        continue;
        paramInt2 = k;
        paramInt1 = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tmassistantsdk.util.Base64
 * JD-Core Version:    0.7.0.1
 */