package com.tencent.tmassistantsdk.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
  protected final byte[] buffer;
  protected final long[] count;
  protected final byte[] digest;
  protected final long[] state;
  
  public MD5()
  {
    AppMethodBeat.i(102501);
    this.state = new long[4];
    this.count = new long[2];
    this.buffer = new byte[64];
    this.digest = new byte[16];
    md5Init();
    AppMethodBeat.o(102501);
  }
  
  private void Decode(long[] paramArrayOfLong, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(102510);
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      paramArrayOfLong[i] = (b2iu(paramArrayOfByte[j]) | b2iu(paramArrayOfByte[(j + 1)]) << 8 | b2iu(paramArrayOfByte[(j + 2)]) << 16 | b2iu(paramArrayOfByte[(j + 3)]) << 24);
      j += 4;
      i += 1;
    }
    AppMethodBeat.o(102510);
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
    AppMethodBeat.i(102502);
    paramLong1 = F(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    paramLong1 = (int)paramLong1 >>> (int)(32L - paramLong6) | i << j;
    AppMethodBeat.o(102502);
    return paramLong1 + paramLong2;
  }
  
  private long G(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 & paramLong3 | (0xFFFFFFFF ^ paramLong3) & paramLong2;
  }
  
  private long GG(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    AppMethodBeat.i(102503);
    paramLong1 = G(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    paramLong1 = (int)paramLong1 >>> (int)(32L - paramLong6) | i << j;
    AppMethodBeat.o(102503);
    return paramLong1 + paramLong2;
  }
  
  private long H(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 ^ paramLong2 ^ paramLong3;
  }
  
  private long HH(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    AppMethodBeat.i(102504);
    paramLong1 = H(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    paramLong1 = (int)paramLong1 >>> (int)(32L - paramLong6) | i << j;
    AppMethodBeat.o(102504);
    return paramLong1 + paramLong2;
  }
  
  private long I(long paramLong1, long paramLong2, long paramLong3)
  {
    return (0xFFFFFFFF ^ paramLong3 | paramLong1) ^ paramLong2;
  }
  
  private long II(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    AppMethodBeat.i(102505);
    paramLong1 = I(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    paramLong1 = (int)paramLong1 >>> (int)(32L - paramLong6) | i << j;
    AppMethodBeat.o(102505);
    return paramLong1 + paramLong2;
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
    AppMethodBeat.i(102511);
    Object localObject = new char[16];
    Object tmp11_10 = localObject;
    tmp11_10[0] = 48;
    Object tmp16_11 = tmp11_10;
    tmp16_11[1] = 49;
    Object tmp21_16 = tmp16_11;
    tmp21_16[2] = 50;
    Object tmp26_21 = tmp21_16;
    tmp26_21[3] = 51;
    Object tmp31_26 = tmp26_21;
    tmp31_26[4] = 52;
    Object tmp36_31 = tmp31_26;
    tmp36_31[5] = 53;
    Object tmp41_36 = tmp36_31;
    tmp41_36[6] = 54;
    Object tmp47_41 = tmp41_36;
    tmp47_41[7] = 55;
    Object tmp53_47 = tmp47_41;
    tmp53_47[8] = 56;
    Object tmp59_53 = tmp53_47;
    tmp59_53[9] = 57;
    Object tmp65_59 = tmp59_53;
    tmp65_59[10] = 65;
    Object tmp71_65 = tmp65_59;
    tmp71_65[11] = 66;
    Object tmp77_71 = tmp71_65;
    tmp77_71[12] = 67;
    Object tmp83_77 = tmp77_71;
    tmp83_77[13] = 68;
    Object tmp89_83 = tmp83_77;
    tmp89_83[14] = 69;
    Object tmp95_89 = tmp89_83;
    tmp95_89[15] = 70;
    tmp95_89;
    localObject = new String(new char[] { localObject[(paramByte >>> 4 & 0xF)], localObject[(paramByte & 0xF)] });
    AppMethodBeat.o(102511);
    return localObject;
  }
  
  public static String convertHashToString(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(102514);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(102514);
      return "";
    }
    String str = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      str = str + Integer.toString((paramArrayOfByte[i] & 0xFF) + 256, 16).substring(1);
      i += 1;
    }
    paramArrayOfByte = str.toUpperCase();
    AppMethodBeat.o(102514);
    return paramArrayOfByte;
  }
  
  /* Error */
  public static String fileToMD5(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 168
    //   4: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokestatic 174	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   11: astore_0
    //   12: sipush 1024
    //   15: newarray byte
    //   17: astore_3
    //   18: ldc 176
    //   20: invokestatic 182	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   23: astore 4
    //   25: iload_1
    //   26: iconst_m1
    //   27: if_icmpeq +44 -> 71
    //   30: aload_0
    //   31: aload_3
    //   32: invokevirtual 188	java/io/InputStream:read	([B)I
    //   35: istore_2
    //   36: iload_2
    //   37: istore_1
    //   38: iload_2
    //   39: ifle -14 -> 25
    //   42: aload 4
    //   44: aload_3
    //   45: iconst_0
    //   46: iload_2
    //   47: invokevirtual 192	java/security/MessageDigest:update	([BII)V
    //   50: iload_2
    //   51: istore_1
    //   52: goto -27 -> 25
    //   55: astore_3
    //   56: aload_0
    //   57: ifnull +7 -> 64
    //   60: aload_0
    //   61: invokevirtual 195	java/io/InputStream:close	()V
    //   64: ldc 168
    //   66: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aconst_null
    //   70: areturn
    //   71: aload 4
    //   73: invokevirtual 198	java/security/MessageDigest:digest	()[B
    //   76: invokestatic 200	com/tencent/tmassistantsdk/util/MD5:convertHashToString	([B)Ljava/lang/String;
    //   79: astore_3
    //   80: aload_0
    //   81: ifnull +7 -> 88
    //   84: aload_0
    //   85: invokevirtual 195	java/io/InputStream:close	()V
    //   88: ldc 168
    //   90: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_3
    //   94: areturn
    //   95: astore_0
    //   96: aconst_null
    //   97: astore_3
    //   98: aload_3
    //   99: ifnull +7 -> 106
    //   102: aload_3
    //   103: invokevirtual 195	java/io/InputStream:close	()V
    //   106: ldc 168
    //   108: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_0
    //   112: athrow
    //   113: astore_0
    //   114: goto -26 -> 88
    //   117: astore_0
    //   118: goto -54 -> 64
    //   121: astore_3
    //   122: goto -16 -> 106
    //   125: astore_3
    //   126: aload_0
    //   127: astore 4
    //   129: aload_3
    //   130: astore_0
    //   131: aload 4
    //   133: astore_3
    //   134: goto -36 -> 98
    //   137: astore_0
    //   138: aconst_null
    //   139: astore_0
    //   140: goto -84 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramString	String
    //   1	51	1	i	int
    //   35	16	2	j	int
    //   17	28	3	arrayOfByte	byte[]
    //   55	1	3	localException1	Exception
    //   79	24	3	str	String
    //   121	1	3	localException2	Exception
    //   125	5	3	localObject1	Object
    //   133	1	3	localObject2	Object
    //   23	109	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   12	25	55	java/lang/Exception
    //   30	36	55	java/lang/Exception
    //   42	50	55	java/lang/Exception
    //   71	80	55	java/lang/Exception
    //   7	12	95	finally
    //   84	88	113	java/lang/Exception
    //   60	64	117	java/lang/Exception
    //   102	106	121	java/lang/Exception
    //   12	25	125	finally
    //   30	36	125	finally
    //   42	50	125	finally
    //   71	80	125	finally
    //   7	12	137	java/lang/Exception
  }
  
  private void md5Final()
  {
    AppMethodBeat.i(102508);
    byte[] arrayOfByte = new byte[8];
    Encode(arrayOfByte, this.count, 8);
    int i = (int)(this.count[0] >>> 3) & 0x3F;
    if (i < 56) {}
    for (i = 56 - i;; i = 120 - i)
    {
      md5Update(PADDING, i);
      md5Update(arrayOfByte, 8);
      Encode(this.digest, this.state, 16);
      AppMethodBeat.o(102508);
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
    AppMethodBeat.i(102509);
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
    AppMethodBeat.o(102509);
  }
  
  private void md5Update(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(102507);
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
      AppMethodBeat.o(102507);
      return;
      j = 0;
    }
  }
  
  private boolean md5Update(InputStream paramInputStream, long paramLong)
  {
    AppMethodBeat.i(102506);
    byte[] arrayOfByte = new byte[64];
    int j = (int)(this.count[0] >>> 3) & 0x3F;
    Object localObject = this.count;
    long l = localObject[0] + (paramLong << 3);
    localObject[0] = l;
    if (l < paramLong << 3)
    {
      localObject = this.count;
      localObject[1] += 1L;
    }
    localObject = this.count;
    localObject[1] += (paramLong >>> 29);
    int i = 64 - j;
    if (paramLong >= i)
    {
      localObject = new byte[i];
      try
      {
        paramInputStream.read((byte[])localObject, 0, i);
        md5Memcpy(this.buffer, (byte[])localObject, j, 0, i);
        md5Transform(this.buffer);
      }
      catch (Exception paramInputStream)
      {
        try
        {
          paramInputStream.read(arrayOfByte);
          md5Transform(arrayOfByte);
          i += 64;
        }
        catch (Exception paramInputStream)
        {
          AppMethodBeat.o(102506);
          return false;
        }
        paramInputStream = paramInputStream;
        AppMethodBeat.o(102506);
        return false;
      }
      if (i + 63 < paramLong) {}
      j = 0;
    }
    for (;;)
    {
      arrayOfByte = new byte[(int)(paramLong - i)];
      try
      {
        paramInputStream.read(arrayOfByte);
        md5Memcpy(this.buffer, arrayOfByte, j, 0, arrayOfByte.length);
        AppMethodBeat.o(102506);
        return true;
      }
      catch (Exception paramInputStream)
      {
        AppMethodBeat.o(102506);
      }
      i = 0;
    }
    return false;
  }
  
  public static String toMD5(String paramString)
  {
    AppMethodBeat.i(102512);
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
      AppMethodBeat.o(102512);
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
    AppMethodBeat.i(102500);
    md5Init();
    md5Update(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length);
    md5Final();
    paramArrayOfByte = this.digest;
    AppMethodBeat.o(102500);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.util.MD5
 * JD-Core Version:    0.7.0.1
 */