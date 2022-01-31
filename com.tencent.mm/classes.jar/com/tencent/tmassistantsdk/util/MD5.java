package com.tencent.tmassistantsdk.util;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

public class MD5
{
  static final byte[] PADDING = { -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  static final int S11 = 7;
  static final int S12 = 12;
  static final int S13 = 17;
  static final int S14 = 22;
  static final int S21 = 5;
  static final int S22 = 9;
  static final int S23 = 14;
  static final int S24 = 20;
  static final int S31 = 4;
  static final int S32 = 11;
  static final int S33 = 16;
  static final int S34 = 23;
  static final int S41 = 6;
  static final int S42 = 10;
  static final int S43 = 15;
  static final int S44 = 21;
  protected final byte[] buffer = new byte[64];
  protected final long[] count = new long[2];
  protected final byte[] digest = new byte[16];
  protected final long[] state = new long[4];
  
  public MD5()
  {
    md5Init();
  }
  
  private void Decode(long[] paramArrayOfLong, byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      paramArrayOfLong[i] = (b2iu(paramArrayOfByte[j]) | b2iu(paramArrayOfByte[(j + 1)]) << 8 | b2iu(paramArrayOfByte[(j + 2)]) << 16 | b2iu(paramArrayOfByte[(j + 3)]) << 24);
      j += 4;
      i += 1;
    }
  }
  
  private void Encode(byte[] paramArrayOfByte, long[] paramArrayOfLong, int paramInt)
  {
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      paramArrayOfByte[j] = ((byte)(int)(paramArrayOfLong[i] & 0xFF));
      paramArrayOfByte[(j + 1)] = ((byte)(int)(paramArrayOfLong[i] >>> 8 & 0xFF));
      paramArrayOfByte[(j + 2)] = ((byte)(int)(paramArrayOfLong[i] >>> 16 & 0xFF));
      paramArrayOfByte[(j + 3)] = ((byte)(int)(paramArrayOfLong[i] >>> 24 & 0xFF));
      j += 4;
      i += 1;
    }
  }
  
  private long F(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 & paramLong2 | (0xFFFFFFFF ^ paramLong1) & paramLong3;
  }
  
  private long FF(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = F(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private long G(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 & paramLong3 | (0xFFFFFFFF ^ paramLong3) & paramLong2;
  }
  
  private long GG(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = G(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private long H(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 ^ paramLong2 ^ paramLong3;
  }
  
  private long HH(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = H(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private long I(long paramLong1, long paramLong2, long paramLong3)
  {
    return (0xFFFFFFFF ^ paramLong3 | paramLong1) ^ paramLong2;
  }
  
  private long II(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = I(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  public static long b2iu(byte paramByte)
  {
    if (paramByte < 0) {
      return paramByte & 0xFF;
    }
    return paramByte;
  }
  
  public static String byteHEX(byte paramByte)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp6_5 = arrayOfChar;
    tmp6_5[0] = 48;
    char[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 49;
    char[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 50;
    char[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 51;
    char[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 52;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 53;
    char[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 54;
    char[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 55;
    char[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 56;
    char[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 57;
    char[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 65;
    char[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 66;
    char[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 67;
    char[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 68;
    char[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 69;
    char[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 70;
    tmp90_84;
    return new String(new char[] { arrayOfChar[(paramByte >>> 4 & 0xF)], arrayOfChar[(paramByte & 0xF)] });
  }
  
  public static String convertHashToString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    String str = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      str = str + Integer.toString((paramArrayOfByte[i] & 0xFF) + 256, 16).substring(1);
      i += 1;
    }
    return str.toUpperCase();
  }
  
  /* Error */
  public static String fileToMD5(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 152	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 155	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: sipush 1024
    //   14: newarray byte
    //   16: astore_3
    //   17: ldc 157
    //   19: invokestatic 163	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   22: astore 4
    //   24: iload_1
    //   25: iconst_m1
    //   26: if_icmpeq +39 -> 65
    //   29: aload_0
    //   30: aload_3
    //   31: invokevirtual 169	java/io/InputStream:read	([B)I
    //   34: istore_2
    //   35: iload_2
    //   36: istore_1
    //   37: iload_2
    //   38: ifle -14 -> 24
    //   41: aload 4
    //   43: aload_3
    //   44: iconst_0
    //   45: iload_2
    //   46: invokevirtual 173	java/security/MessageDigest:update	([BII)V
    //   49: iload_2
    //   50: istore_1
    //   51: goto -27 -> 24
    //   54: astore_3
    //   55: aload_0
    //   56: ifnull +7 -> 63
    //   59: aload_0
    //   60: invokevirtual 176	java/io/InputStream:close	()V
    //   63: aconst_null
    //   64: areturn
    //   65: aload 4
    //   67: invokevirtual 179	java/security/MessageDigest:digest	()[B
    //   70: invokestatic 181	com/tencent/tmassistantsdk/util/MD5:convertHashToString	([B)Ljava/lang/String;
    //   73: astore_3
    //   74: aload_0
    //   75: invokevirtual 176	java/io/InputStream:close	()V
    //   78: aload_3
    //   79: areturn
    //   80: astore_0
    //   81: aload_3
    //   82: areturn
    //   83: astore_0
    //   84: aconst_null
    //   85: astore_3
    //   86: aload_3
    //   87: ifnull +7 -> 94
    //   90: aload_3
    //   91: invokevirtual 176	java/io/InputStream:close	()V
    //   94: aload_0
    //   95: athrow
    //   96: astore_0
    //   97: aconst_null
    //   98: areturn
    //   99: astore_3
    //   100: goto -6 -> 94
    //   103: astore_3
    //   104: aload_0
    //   105: astore 4
    //   107: aload_3
    //   108: astore_0
    //   109: aload 4
    //   111: astore_3
    //   112: goto -26 -> 86
    //   115: astore_0
    //   116: aconst_null
    //   117: astore_0
    //   118: goto -63 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramString	String
    //   1	50	1	i	int
    //   34	16	2	j	int
    //   16	28	3	arrayOfByte	byte[]
    //   54	1	3	localException1	java.lang.Exception
    //   73	18	3	str	String
    //   99	1	3	localException2	java.lang.Exception
    //   103	5	3	localObject1	Object
    //   111	1	3	localObject2	Object
    //   22	88	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   11	24	54	java/lang/Exception
    //   29	35	54	java/lang/Exception
    //   41	49	54	java/lang/Exception
    //   65	74	54	java/lang/Exception
    //   74	78	80	java/lang/Exception
    //   2	11	83	finally
    //   59	63	96	java/lang/Exception
    //   90	94	99	java/lang/Exception
    //   11	24	103	finally
    //   29	35	103	finally
    //   41	49	103	finally
    //   65	74	103	finally
    //   2	11	115	java/lang/Exception
  }
  
  private void md5Final()
  {
    byte[] arrayOfByte = new byte[8];
    Encode(arrayOfByte, this.count, 8);
    int i = (int)(this.count[0] >>> 3) & 0x3F;
    if (i < 56) {}
    for (i = 56 - i;; i = 120 - i)
    {
      md5Update(PADDING, i);
      md5Update(arrayOfByte, 8);
      Encode(this.digest, this.state, 16);
      return;
    }
  }
  
  private void md5Init()
  {
    this.count[0] = 0L;
    this.count[1] = 0L;
    this.state[0] = 1732584193L;
    this.state[1] = 4023233417L;
    this.state[2] = 2562383102L;
    this.state[3] = 271733878L;
  }
  
  private void md5Memcpy(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt3)
    {
      paramArrayOfByte1[(paramInt1 + i)] = paramArrayOfByte2[(paramInt2 + i)];
      i += 1;
    }
  }
  
  private void md5Transform(byte[] paramArrayOfByte)
  {
    long l2 = this.state[0];
    long l1 = this.state[1];
    long l4 = this.state[2];
    long l3 = this.state[3];
    long[] arrayOfLong = new long[16];
    Decode(arrayOfLong, paramArrayOfByte, 64);
    l2 = FF(l2, l1, l4, l3, arrayOfLong[0], 7L, 3614090360L);
    l3 = FF(l3, l2, l1, l4, arrayOfLong[1], 12L, 3905402710L);
    l4 = FF(l4, l3, l2, l1, arrayOfLong[2], 17L, 606105819L);
    l1 = FF(l1, l4, l3, l2, arrayOfLong[3], 22L, 3250441966L);
    l2 = FF(l2, l1, l4, l3, arrayOfLong[4], 7L, 4118548399L);
    l3 = FF(l3, l2, l1, l4, arrayOfLong[5], 12L, 1200080426L);
    l4 = FF(l4, l3, l2, l1, arrayOfLong[6], 17L, 2821735955L);
    l1 = FF(l1, l4, l3, l2, arrayOfLong[7], 22L, 4249261313L);
    l2 = FF(l2, l1, l4, l3, arrayOfLong[8], 7L, 1770035416L);
    l3 = FF(l3, l2, l1, l4, arrayOfLong[9], 12L, 2336552879L);
    l4 = FF(l4, l3, l2, l1, arrayOfLong[10], 17L, 4294925233L);
    l1 = FF(l1, l4, l3, l2, arrayOfLong[11], 22L, 2304563134L);
    l2 = FF(l2, l1, l4, l3, arrayOfLong[12], 7L, 1804603682L);
    l3 = FF(l3, l2, l1, l4, arrayOfLong[13], 12L, 4254626195L);
    l4 = FF(l4, l3, l2, l1, arrayOfLong[14], 17L, 2792965006L);
    l1 = FF(l1, l4, l3, l2, arrayOfLong[15], 22L, 1236535329L);
    l2 = GG(l2, l1, l4, l3, arrayOfLong[1], 5L, 4129170786L);
    l3 = GG(l3, l2, l1, l4, arrayOfLong[6], 9L, 3225465664L);
    l4 = GG(l4, l3, l2, l1, arrayOfLong[11], 14L, 643717713L);
    l1 = GG(l1, l4, l3, l2, arrayOfLong[0], 20L, 3921069994L);
    l2 = GG(l2, l1, l4, l3, arrayOfLong[5], 5L, 3593408605L);
    l3 = GG(l3, l2, l1, l4, arrayOfLong[10], 9L, 38016083L);
    l4 = GG(l4, l3, l2, l1, arrayOfLong[15], 14L, 3634488961L);
    l1 = GG(l1, l4, l3, l2, arrayOfLong[4], 20L, 3889429448L);
    l2 = GG(l2, l1, l4, l3, arrayOfLong[9], 5L, 568446438L);
    l3 = GG(l3, l2, l1, l4, arrayOfLong[14], 9L, 3275163606L);
    l4 = GG(l4, l3, l2, l1, arrayOfLong[3], 14L, 4107603335L);
    l1 = GG(l1, l4, l3, l2, arrayOfLong[8], 20L, 1163531501L);
    l2 = GG(l2, l1, l4, l3, arrayOfLong[13], 5L, 2850285829L);
    l3 = GG(l3, l2, l1, l4, arrayOfLong[2], 9L, 4243563512L);
    l4 = GG(l4, l3, l2, l1, arrayOfLong[7], 14L, 1735328473L);
    l1 = GG(l1, l4, l3, l2, arrayOfLong[12], 20L, 2368359562L);
    l2 = HH(l2, l1, l4, l3, arrayOfLong[5], 4L, 4294588738L);
    l3 = HH(l3, l2, l1, l4, arrayOfLong[8], 11L, 2272392833L);
    l4 = HH(l4, l3, l2, l1, arrayOfLong[11], 16L, 1839030562L);
    l1 = HH(l1, l4, l3, l2, arrayOfLong[14], 23L, 4259657740L);
    l2 = HH(l2, l1, l4, l3, arrayOfLong[1], 4L, 2763975236L);
    l3 = HH(l3, l2, l1, l4, arrayOfLong[4], 11L, 1272893353L);
    l4 = HH(l4, l3, l2, l1, arrayOfLong[7], 16L, 4139469664L);
    l1 = HH(l1, l4, l3, l2, arrayOfLong[10], 23L, 3200236656L);
    l2 = HH(l2, l1, l4, l3, arrayOfLong[13], 4L, 681279174L);
    l3 = HH(l3, l2, l1, l4, arrayOfLong[0], 11L, 3936430074L);
    l4 = HH(l4, l3, l2, l1, arrayOfLong[3], 16L, 3572445317L);
    l1 = HH(l1, l4, l3, l2, arrayOfLong[6], 23L, 76029189L);
    l2 = HH(l2, l1, l4, l3, arrayOfLong[9], 4L, 3654602809L);
    l3 = HH(l3, l2, l1, l4, arrayOfLong[12], 11L, 3873151461L);
    l4 = HH(l4, l3, l2, l1, arrayOfLong[15], 16L, 530742520L);
    l1 = HH(l1, l4, l3, l2, arrayOfLong[2], 23L, 3299628645L);
    l2 = II(l2, l1, l4, l3, arrayOfLong[0], 6L, 4096336452L);
    l3 = II(l3, l2, l1, l4, arrayOfLong[7], 10L, 1126891415L);
    l4 = II(l4, l3, l2, l1, arrayOfLong[14], 15L, 2878612391L);
    l1 = II(l1, l4, l3, l2, arrayOfLong[5], 21L, 4237533241L);
    l2 = II(l2, l1, l4, l3, arrayOfLong[12], 6L, 1700485571L);
    l3 = II(l3, l2, l1, l4, arrayOfLong[3], 10L, 2399980690L);
    l4 = II(l4, l3, l2, l1, arrayOfLong[10], 15L, 4293915773L);
    l1 = II(l1, l4, l3, l2, arrayOfLong[1], 21L, 2240044497L);
    l2 = II(l2, l1, l4, l3, arrayOfLong[8], 6L, 1873313359L);
    l3 = II(l3, l2, l1, l4, arrayOfLong[15], 10L, 4264355552L);
    l4 = II(l4, l3, l2, l1, arrayOfLong[6], 15L, 2734768916L);
    l1 = II(l1, l4, l3, l2, arrayOfLong[13], 21L, 1309151649L);
    l2 = II(l2, l1, l4, l3, arrayOfLong[4], 6L, 4149444226L);
    l3 = II(l3, l2, l1, l4, arrayOfLong[11], 10L, 3174756917L);
    l4 = II(l4, l3, l2, l1, arrayOfLong[2], 15L, 718787259L);
    l1 = II(l1, l4, l3, l2, arrayOfLong[9], 21L, 3951481745L);
    paramArrayOfByte = this.state;
    paramArrayOfByte[0] += l2;
    paramArrayOfByte = this.state;
    paramArrayOfByte[1] = (l1 + paramArrayOfByte[1]);
    paramArrayOfByte = this.state;
    paramArrayOfByte[2] += l4;
    paramArrayOfByte = this.state;
    paramArrayOfByte[3] += l3;
  }
  
  private void md5Update(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[64];
    int i = (int)(this.count[0] >>> 3) & 0x3F;
    long[] arrayOfLong = this.count;
    long l = arrayOfLong[0] + (paramInt << 3);
    arrayOfLong[0] = l;
    if (l < paramInt << 3)
    {
      arrayOfLong = this.count;
      arrayOfLong[1] += 1L;
    }
    arrayOfLong = this.count;
    arrayOfLong[1] += (paramInt >>> 29);
    int j = 64 - i;
    if (paramInt >= j)
    {
      md5Memcpy(this.buffer, paramArrayOfByte, i, 0, j);
      md5Transform(this.buffer);
      i = j;
      while (i + 63 < paramInt)
      {
        md5Memcpy(arrayOfByte, paramArrayOfByte, 0, i, 64);
        md5Transform(arrayOfByte);
        i += 64;
      }
      int k = 0;
      j = i;
      i = k;
    }
    for (;;)
    {
      md5Memcpy(this.buffer, paramArrayOfByte, i, j, paramInt - j);
      return;
      j = 0;
    }
  }
  
  /* Error */
  private boolean md5Update(java.io.InputStream paramInputStream, long paramLong)
  {
    // Byte code:
    //   0: bipush 64
    //   2: newarray byte
    //   4: astore 8
    //   6: aload_0
    //   7: getfield 58	com/tencent/tmassistantsdk/util/MD5:count	[J
    //   10: iconst_0
    //   11: laload
    //   12: iconst_3
    //   13: lushr
    //   14: l2i
    //   15: bipush 63
    //   17: iand
    //   18: istore 5
    //   20: aload_0
    //   21: getfield 58	com/tencent/tmassistantsdk/util/MD5:count	[J
    //   24: astore 9
    //   26: aload 9
    //   28: iconst_0
    //   29: laload
    //   30: lload_2
    //   31: iconst_3
    //   32: lshl
    //   33: ladd
    //   34: lstore 6
    //   36: aload 9
    //   38: iconst_0
    //   39: lload 6
    //   41: lastore
    //   42: lload 6
    //   44: lload_2
    //   45: iconst_3
    //   46: lshl
    //   47: lcmp
    //   48: ifge +19 -> 67
    //   51: aload_0
    //   52: getfield 58	com/tencent/tmassistantsdk/util/MD5:count	[J
    //   55: astore 9
    //   57: aload 9
    //   59: iconst_1
    //   60: aload 9
    //   62: iconst_1
    //   63: laload
    //   64: lconst_1
    //   65: ladd
    //   66: lastore
    //   67: aload_0
    //   68: getfield 58	com/tencent/tmassistantsdk/util/MD5:count	[J
    //   71: astore 9
    //   73: aload 9
    //   75: iconst_1
    //   76: aload 9
    //   78: iconst_1
    //   79: laload
    //   80: lload_2
    //   81: bipush 29
    //   83: lushr
    //   84: ladd
    //   85: lastore
    //   86: bipush 64
    //   88: iload 5
    //   90: isub
    //   91: istore 4
    //   93: lload_2
    //   94: iload 4
    //   96: i2l
    //   97: lcmp
    //   98: iflt +114 -> 212
    //   101: iload 4
    //   103: newarray byte
    //   105: astore 9
    //   107: aload_1
    //   108: aload 9
    //   110: iconst_0
    //   111: iload 4
    //   113: invokevirtual 378	java/io/InputStream:read	([BII)I
    //   116: pop
    //   117: aload_0
    //   118: aload_0
    //   119: getfield 60	com/tencent/tmassistantsdk/util/MD5:buffer	[B
    //   122: aload 9
    //   124: iload 5
    //   126: iconst_0
    //   127: iload 4
    //   129: invokespecial 372	com/tencent/tmassistantsdk/util/MD5:md5Memcpy	([B[BIII)V
    //   132: aload_0
    //   133: aload_0
    //   134: getfield 60	com/tencent/tmassistantsdk/util/MD5:buffer	[B
    //   137: invokespecial 374	com/tencent/tmassistantsdk/util/MD5:md5Transform	([B)V
    //   140: iload 4
    //   142: bipush 63
    //   144: iadd
    //   145: i2l
    //   146: lload_2
    //   147: lcmp
    //   148: ifge +26 -> 174
    //   151: aload_1
    //   152: aload 8
    //   154: invokevirtual 169	java/io/InputStream:read	([B)I
    //   157: pop
    //   158: aload_0
    //   159: aload 8
    //   161: invokespecial 374	com/tencent/tmassistantsdk/util/MD5:md5Transform	([B)V
    //   164: iload 4
    //   166: bipush 64
    //   168: iadd
    //   169: istore 4
    //   171: goto -31 -> 140
    //   174: iconst_0
    //   175: istore 5
    //   177: lload_2
    //   178: iload 4
    //   180: i2l
    //   181: lsub
    //   182: l2i
    //   183: newarray byte
    //   185: astore 8
    //   187: aload_1
    //   188: aload 8
    //   190: invokevirtual 169	java/io/InputStream:read	([B)I
    //   193: pop
    //   194: aload_0
    //   195: aload_0
    //   196: getfield 60	com/tencent/tmassistantsdk/util/MD5:buffer	[B
    //   199: aload 8
    //   201: iload 5
    //   203: iconst_0
    //   204: aload 8
    //   206: arraylength
    //   207: invokespecial 372	com/tencent/tmassistantsdk/util/MD5:md5Memcpy	([B[BIII)V
    //   210: iconst_1
    //   211: ireturn
    //   212: iconst_0
    //   213: istore 4
    //   215: goto -38 -> 177
    //   218: astore_1
    //   219: iconst_0
    //   220: ireturn
    //   221: astore_1
    //   222: iconst_0
    //   223: ireturn
    //   224: astore_1
    //   225: iconst_0
    //   226: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	MD5
    //   0	227	1	paramInputStream	java.io.InputStream
    //   0	227	2	paramLong	long
    //   91	123	4	i	int
    //   18	184	5	j	int
    //   34	9	6	l	long
    //   4	201	8	arrayOfByte	byte[]
    //   24	99	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   107	117	218	java/lang/Exception
    //   151	158	221	java/lang/Exception
    //   187	194	224	java/lang/Exception
  }
  
  public static String toMD5(String paramString)
  {
    try
    {
      arrayOfByte = paramString.getBytes("ISO8859_1");
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        int i;
        paramString = paramString.getBytes();
      }
    }
    arrayOfByte = new MD5().getMD5(paramString);
    paramString = "";
    i = 0;
    while (i < 16)
    {
      paramString = paramString + byteHEX(arrayOfByte[i]);
      i += 1;
    }
    return paramString;
  }
  
  public byte[] getMD5(byte[] paramArrayOfByte)
  {
    md5Init();
    md5Update(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length);
    md5Final();
    return this.digest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.util.MD5
 * JD-Core Version:    0.7.0.1
 */