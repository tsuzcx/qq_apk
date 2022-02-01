package oicq.wlogin_sdk.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

public final class c
{
  static final byte[] PADDING;
  private byte[] buffer;
  private long[] count;
  private byte[] digest;
  private long[] state;
  
  static
  {
    byte[] arrayOfByte = new byte[64];
    arrayOfByte[0] = -128;
    PADDING = arrayOfByte;
  }
  
  public c()
  {
    AppMethodBeat.i(88145);
    this.state = new long[4];
    this.count = new long[2];
    this.buffer = new byte[64];
    this.digest = new byte[16];
    md5Init();
    AppMethodBeat.o(88145);
  }
  
  private static void Encode(byte[] paramArrayOfByte, long[] paramArrayOfLong, int paramInt)
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (j >= paramInt) {
        return;
      }
      paramArrayOfByte[j] = ((byte)(int)(paramArrayOfLong[i] & 0xFF));
      paramArrayOfByte[(j + 1)] = ((byte)(int)(paramArrayOfLong[i] >>> 8 & 0xFF));
      paramArrayOfByte[(j + 2)] = ((byte)(int)(paramArrayOfLong[i] >>> 16 & 0xFF));
      paramArrayOfByte[(j + 3)] = ((byte)(int)(paramArrayOfLong[i] >>> 24 & 0xFF));
      j += 4;
      i += 1;
    }
  }
  
  private static long FF(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = (paramLong2 & paramLong3 | (0xFFFFFFFF ^ paramLong2) & paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private static long GG(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = (paramLong2 & paramLong4 | (0xFFFFFFFF ^ paramLong4) & paramLong3) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private static long HH(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = (paramLong2 ^ paramLong3 ^ paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private static long II(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = ((0xFFFFFFFF ^ paramLong4 | paramLong2) ^ paramLong3) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private static void a(long[] paramArrayOfLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88149);
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (j >= 64)
      {
        AppMethodBeat.o(88149);
        return;
      }
      paramArrayOfLong[i] = (b2iu(paramArrayOfByte[j]) | b2iu(paramArrayOfByte[(j + 1)]) << 8 | b2iu(paramArrayOfByte[(j + 2)]) << 16 | b2iu(paramArrayOfByte[(j + 3)]) << 24);
      j += 4;
      i += 1;
    }
  }
  
  private static long b2iu(byte paramByte)
  {
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte & 0xFF;
    }
    return i;
  }
  
  public static byte[] bKd(String paramString)
  {
    AppMethodBeat.i(88151);
    try
    {
      byte[] arrayOfByte = paramString.getBytes("ISO8859_1");
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        paramString = paramString.getBytes();
      }
    }
    paramString = new c().getMD5(paramString);
    AppMethodBeat.o(88151);
    return paramString;
  }
  
  public static byte[] dW(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88150);
    paramArrayOfByte = new c().getMD5(paramArrayOfByte);
    AppMethodBeat.o(88150);
    return paramArrayOfByte;
  }
  
  private byte[] getMD5(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88144);
    md5Init();
    md5Update(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length);
    paramArrayOfByte = new byte[8];
    Encode(paramArrayOfByte, this.count, 8);
    int i = (int)(this.count[0] >>> 3) & 0x3F;
    if (i < 56) {}
    for (i = 56 - i;; i = 120 - i)
    {
      md5Update(PADDING, i);
      md5Update(paramArrayOfByte, 8);
      Encode(this.digest, this.state, 16);
      paramArrayOfByte = this.digest;
      AppMethodBeat.o(88144);
      return paramArrayOfByte;
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
  
  private static void md5Memcpy(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    for (;;)
    {
      if (i >= paramInt3) {
        return;
      }
      paramArrayOfByte1[(paramInt1 + i)] = paramArrayOfByte2[(paramInt2 + i)];
      i += 1;
    }
  }
  
  private void md5Transform(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88148);
    long l2 = this.state[0];
    long l1 = this.state[1];
    long l4 = this.state[2];
    long l3 = this.state[3];
    long[] arrayOfLong = new long[16];
    a(arrayOfLong, paramArrayOfByte);
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
    AppMethodBeat.o(88148);
  }
  
  private void md5Update(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(88147);
    byte[] arrayOfByte = new byte[64];
    int j = (int)(this.count[0] >>> 3) & 0x3F;
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
    int i = 64 - j;
    if (paramInt >= i)
    {
      md5Memcpy(this.buffer, paramArrayOfByte, j, 0, i);
      md5Transform(this.buffer);
      if (i + 63 >= paramInt) {
        j = 0;
      }
    }
    for (;;)
    {
      md5Memcpy(this.buffer, paramArrayOfByte, j, i, paramInt - i);
      AppMethodBeat.o(88147);
      return;
      md5Memcpy(arrayOfByte, paramArrayOfByte, 0, i, 64);
      md5Transform(arrayOfByte);
      i += 64;
      break;
      i = 0;
    }
  }
  
  /* Error */
  private boolean md5Update(java.io.InputStream paramInputStream, long paramLong)
  {
    // Byte code:
    //   0: ldc_w 287
    //   3: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: bipush 64
    //   8: newarray byte
    //   10: astore 8
    //   12: aload_0
    //   13: getfield 30	oicq/wlogin_sdk/tools/c:count	[J
    //   16: iconst_0
    //   17: laload
    //   18: iconst_3
    //   19: lushr
    //   20: l2i
    //   21: bipush 63
    //   23: iand
    //   24: istore 5
    //   26: aload_0
    //   27: getfield 30	oicq/wlogin_sdk/tools/c:count	[J
    //   30: astore 9
    //   32: aload 9
    //   34: iconst_0
    //   35: laload
    //   36: lload_2
    //   37: iconst_3
    //   38: lshl
    //   39: ladd
    //   40: lstore 6
    //   42: aload 9
    //   44: iconst_0
    //   45: lload 6
    //   47: lastore
    //   48: lload 6
    //   50: lload_2
    //   51: iconst_3
    //   52: lshl
    //   53: lcmp
    //   54: ifge +19 -> 73
    //   57: aload_0
    //   58: getfield 30	oicq/wlogin_sdk/tools/c:count	[J
    //   61: astore 9
    //   63: aload 9
    //   65: iconst_1
    //   66: aload 9
    //   68: iconst_1
    //   69: laload
    //   70: lconst_1
    //   71: ladd
    //   72: lastore
    //   73: aload_0
    //   74: getfield 30	oicq/wlogin_sdk/tools/c:count	[J
    //   77: astore 9
    //   79: aload 9
    //   81: iconst_1
    //   82: aload 9
    //   84: iconst_1
    //   85: laload
    //   86: lload_2
    //   87: bipush 29
    //   89: lushr
    //   90: ladd
    //   91: lastore
    //   92: bipush 64
    //   94: iload 5
    //   96: isub
    //   97: istore 4
    //   99: lload_2
    //   100: iload 4
    //   102: i2l
    //   103: lcmp
    //   104: iflt +136 -> 240
    //   107: iload 4
    //   109: newarray byte
    //   111: astore 9
    //   113: aload_1
    //   114: aload 9
    //   116: iconst_0
    //   117: iload 4
    //   119: invokevirtual 293	java/io/InputStream:read	([BII)I
    //   122: pop
    //   123: aload_0
    //   124: getfield 32	oicq/wlogin_sdk/tools/c:buffer	[B
    //   127: aload 9
    //   129: iload 5
    //   131: iconst_0
    //   132: iload 4
    //   134: invokestatic 282	oicq/wlogin_sdk/tools/c:md5Memcpy	([B[BIII)V
    //   137: aload_0
    //   138: aload_0
    //   139: getfield 32	oicq/wlogin_sdk/tools/c:buffer	[B
    //   142: invokespecial 284	oicq/wlogin_sdk/tools/c:md5Transform	([B)V
    //   145: iload 4
    //   147: bipush 63
    //   149: iadd
    //   150: i2l
    //   151: lload_2
    //   152: lcmp
    //   153: iflt +55 -> 208
    //   156: iconst_0
    //   157: istore 5
    //   159: lload_2
    //   160: iload 4
    //   162: i2l
    //   163: lsub
    //   164: l2i
    //   165: newarray byte
    //   167: astore 8
    //   169: aload_1
    //   170: aload 8
    //   172: invokevirtual 296	java/io/InputStream:read	([B)I
    //   175: pop
    //   176: aload_0
    //   177: getfield 32	oicq/wlogin_sdk/tools/c:buffer	[B
    //   180: aload 8
    //   182: iload 5
    //   184: iconst_0
    //   185: aload 8
    //   187: arraylength
    //   188: invokestatic 282	oicq/wlogin_sdk/tools/c:md5Memcpy	([B[BIII)V
    //   191: ldc_w 287
    //   194: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: iconst_1
    //   198: ireturn
    //   199: astore_1
    //   200: ldc_w 287
    //   203: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: iconst_0
    //   207: ireturn
    //   208: aload_1
    //   209: aload 8
    //   211: invokevirtual 296	java/io/InputStream:read	([B)I
    //   214: pop
    //   215: aload_0
    //   216: aload 8
    //   218: invokespecial 284	oicq/wlogin_sdk/tools/c:md5Transform	([B)V
    //   221: iload 4
    //   223: bipush 64
    //   225: iadd
    //   226: istore 4
    //   228: goto -83 -> 145
    //   231: astore_1
    //   232: ldc_w 287
    //   235: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: iconst_0
    //   239: ireturn
    //   240: iconst_0
    //   241: istore 4
    //   243: goto -84 -> 159
    //   246: astore_1
    //   247: ldc_w 287
    //   250: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   253: iconst_0
    //   254: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	c
    //   0	255	1	paramInputStream	java.io.InputStream
    //   0	255	2	paramLong	long
    //   97	145	4	i	int
    //   24	159	5	j	int
    //   40	9	6	l	long
    //   10	207	8	arrayOfByte	byte[]
    //   30	98	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   113	123	199	java/lang/Exception
    //   208	215	231	java/lang/Exception
    //   169	176	246	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.c
 * JD-Core Version:    0.7.0.1
 */