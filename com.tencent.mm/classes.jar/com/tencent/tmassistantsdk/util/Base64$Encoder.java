package com.tencent.tmassistantsdk.util;

class Base64$Encoder
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
    if (!Base64.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ENCODE = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
      ENCODE_WEBSAFE = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
      return;
    }
  }
  
  public Base64$Encoder(int paramInt, byte[] paramArrayOfByte)
  {
    this.output = paramArrayOfByte;
    boolean bool1;
    if ((paramInt & 0x1) == 0)
    {
      bool1 = true;
      this.do_padding = bool1;
      if ((paramInt & 0x2) != 0) {
        break label101;
      }
      bool1 = true;
      label33:
      this.do_newline = bool1;
      if ((paramInt & 0x4) == 0) {
        break label106;
      }
      bool1 = bool2;
      label47:
      this.do_cr = bool1;
      if ((paramInt & 0x8) != 0) {
        break label111;
      }
      paramArrayOfByte = ENCODE;
      label63:
      this.alphabet = paramArrayOfByte;
      this.tail = new byte[2];
      this.tailLen = 0;
      if (!this.do_newline) {
        break label118;
      }
    }
    label101:
    label106:
    label111:
    label118:
    for (paramInt = 19;; paramInt = -1)
    {
      this.count = paramInt;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label33;
      bool1 = false;
      break label47;
      paramArrayOfByte = ENCODE_WEBSAFE;
      break label63;
    }
  }
  
  public int maxOutputSize(int paramInt)
  {
    return paramInt * 8 / 5 + 10;
  }
  
  public boolean process(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
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
      label63:
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
      label166:
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
          break label1201;
        }
        if (!this.do_cr) {
          break label1198;
        }
        paramInt2 = paramInt1 + 1;
        arrayOfByte2[paramInt1] = 13;
        paramInt1 = paramInt2;
      }
      label939:
      label1198:
      for (;;)
      {
        paramInt2 = paramInt1 + 1;
        arrayOfByte2[paramInt1] = 10;
        j = 19;
        paramInt1 = paramInt2;
        paramInt2 = j;
        break label166;
        paramInt2 = -1;
        i = paramInt1;
        paramInt1 = paramInt2;
        break label63;
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
        break label63;
        if (paramInt1 + 1 > n) {
          break;
        }
        paramInt2 = this.tail[0];
        m = this.tail[1];
        i = paramInt1 + 1;
        paramInt1 = paramArrayOfByte[paramInt1];
        this.tailLen = 0;
        paramInt1 = (paramInt2 & 0xFF) << 16 | (m & 0xFF) << 8 | paramInt1 & 0xFF;
        break label63;
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
              throw new AssertionError();
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
              label739:
              if (this.tailLen <= 0) {
                break label939;
              }
              m = this.tail[j];
              j += 1;
              label761:
              k = (m & 0xFF) << 2 | (k & 0xFF) << 10;
              this.tailLen -= j;
              j = paramInt1 + 1;
              arrayOfByte2[paramInt1] = arrayOfByte1[(k >> 12 & 0x3F)];
              m = j + 1;
              arrayOfByte2[j] = arrayOfByte1[(k >> 6 & 0x3F)];
              paramInt1 = m + 1;
              arrayOfByte2[m] = arrayOfByte1[(k & 0x3F)];
              if (!this.do_padding) {
                break label1195;
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
          break label739;
          m = paramArrayOfByte[i];
          i += 1;
          break label761;
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
                throw new AssertionError();
                if (i != n - 1) {
                  break label1114;
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
              return true;
              label1114:
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
      label1195:
      label1201:
      continue;
      paramInt2 = paramInt1;
      paramInt1 = 4;
      continue;
      paramInt2 = k;
      paramInt1 = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmassistantsdk.util.Base64.Encoder
 * JD-Core Version:    0.7.0.1
 */