package com.tencent.mm.plugin.multitalk.model;

import android.annotation.SuppressLint;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.pb.talkroom.sdk.d;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class j
  extends Thread
{
  private static String waA;
  public static byte[] waD;
  public static byte[] waE;
  public static byte[] waF;
  public static int waH;
  public static int waI;
  public static int waz;
  public byte[] configbyte;
  private BufferedOutputStream outputStream;
  private Surface surface;
  public int vac;
  public int vad;
  private BufferedOutputStream waB;
  private com.tencent.mm.compatible.deviceinfo.z waC;
  private boolean waG;
  private boolean waJ;
  public boolean waK;
  public boolean waL;
  public boolean waM;
  public int waN;
  public byte[] waO;
  public int waP;
  public int waQ;
  public int waR;
  private int waS;
  private int waT;
  private a waU;
  public byte[] waV;
  public byte[] waW;
  public byte[] waX;
  private int waY;
  
  static
  {
    AppMethodBeat.i(206543);
    waz = 10;
    waA = b.arU();
    waD = null;
    waE = null;
    waF = null;
    waH = 640;
    waI = 480;
    AppMethodBeat.o(206543);
  }
  
  public j(Surface paramSurface)
  {
    AppMethodBeat.i(206535);
    this.outputStream = null;
    this.waB = null;
    this.configbyte = null;
    this.waG = false;
    this.waJ = false;
    this.waK = true;
    this.waL = true;
    this.waM = false;
    this.waN = 0;
    this.waO = new byte[] { 0, 0, 0, 1 };
    this.waP = 0;
    this.waQ = 0;
    this.waR = 0;
    this.waS = 0;
    this.waT = 0;
    this.vac = 0;
    this.vad = 0;
    this.waV = new byte[] { 103, 100, 0, 13, -84, -74, 10, 15, -120 };
    this.waW = new byte[] { 0, 0, 0, 1, 40, -50, 60, 48 };
    this.waX = new byte[] { 13, 0, -15, 98, -22 };
    this.waY = 39;
    this.waK = true;
    this.waL = true;
    this.waC = null;
    this.waG = false;
    this.waR = 0;
    if (paramSurface != null) {
      this.surface = paramSurface;
    }
    AppMethodBeat.o(206535);
  }
  
  private static String bu(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(206537);
    String str1 = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str3 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      String str2 = str3;
      if (str3.length() == 1) {
        str2 = "0".concat(String.valueOf(str3));
      }
      str1 = str1 + str2;
      i += 1;
    }
    AppMethodBeat.o(206537);
    return str1;
  }
  
  private long bv(byte[] paramArrayOfByte)
  {
    long l1 = 0L;
    long l2 = 0L;
    while ((this.waT < this.waS << 3) && ((paramArrayOfByte[(this.waT >> 3)] & 128 >> (this.waT & 0x7)) == 0))
    {
      l2 += 1L;
      this.waT += 1;
    }
    this.waT += 1;
    int i = 0;
    while (i < l2)
    {
      long l3 = l1 << 1;
      l1 = l3;
      if ((paramArrayOfByte[(this.waT >> 3)] & 128 >> (this.waT & 0x7)) != 0) {
        l1 = l3 + 1L;
      }
      this.waT += 1;
      i += 1;
    }
    return (1 << (int)l2) - 1 + l1;
  }
  
  private long bw(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(206539);
    long l3 = bv(paramArrayOfByte);
    long l2 = 1L + l3 >> 1;
    long l1 = l2;
    if (l3 % 2L == 0L) {
      l1 = -l2;
    }
    AppMethodBeat.o(206539);
    return l1;
  }
  
  private boolean bx(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(206540);
    this.waT = 0;
    f(1L, paramArrayOfByte);
    f(2L, paramArrayOfByte);
    if (f(5L, paramArrayOfByte) == 7L)
    {
      long l1 = f(8L, paramArrayOfByte);
      f(1L, paramArrayOfByte);
      f(1L, paramArrayOfByte);
      f(1L, paramArrayOfByte);
      f(1L, paramArrayOfByte);
      f(4L, paramArrayOfByte);
      f(8L, paramArrayOfByte);
      bv(paramArrayOfByte);
      long[] arrayOfLong;
      int i;
      if ((l1 == 100L) || (l1 == 110L) || (l1 == 122L) || (l1 == 144L))
      {
        if (bv(paramArrayOfByte) == 3L) {
          f(1L, paramArrayOfByte);
        }
        bv(paramArrayOfByte);
        bv(paramArrayOfByte);
        f(1L, paramArrayOfByte);
        l1 = f(1L, paramArrayOfByte);
        arrayOfLong = new long[8];
        if (l1 != 0L)
        {
          i = 0;
          while (i < 8)
          {
            arrayOfLong[i] = f(1L, paramArrayOfByte);
            i += 1;
          }
        }
      }
      bv(paramArrayOfByte);
      l1 = bv(paramArrayOfByte);
      if (l1 == 0L) {
        bv(paramArrayOfByte);
      }
      for (;;)
      {
        bv(paramArrayOfByte);
        f(1L, paramArrayOfByte);
        l1 = bv(paramArrayOfByte);
        long l2 = bv(paramArrayOfByte);
        i = (int)(l1 + 1L) * 16;
        int j = (int)(l2 + 1L) * 16;
        ad.i("MeidaCodec[HWDec]", "newWidth[%d], newHeight[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if ((i != this.vac) || (j != this.vad))
        {
          this.vac = i;
          this.vad = j;
          if (this.waU != null) {
            this.waU.onSizeChanged(i, j);
          }
        }
        AppMethodBeat.o(206540);
        return true;
        if (l1 == 1L)
        {
          f(1L, paramArrayOfByte);
          bw(paramArrayOfByte);
          bw(paramArrayOfByte);
          j = (int)bv(paramArrayOfByte);
          arrayOfLong = new long[j];
          i = 0;
          while (i < j)
          {
            arrayOfLong[i] = bw(paramArrayOfByte);
            i += 1;
          }
        }
      }
    }
    AppMethodBeat.o(206540);
    return false;
  }
  
  private int dpe()
  {
    AppMethodBeat.i(206536);
    this.waN += 1;
    ad.i("MeidaCodec[HWDec]", "[HW]:DecFrmError: I Req mIReqFlag = " + this.waM + ", mIsHWDecEnable = " + this.waK + ", mHWErrorDecFrmCount = " + this.waN);
    if ((!this.waK) || (this.waN > waz))
    {
      int i = 8;
      if (this.waG) {
        i = 16;
      }
      localByteBuffer = ByteBuffer.allocate(6);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer.putShort((short)0);
      localByteBuffer.putShort((short)i);
      localByteBuffer.putShort((short)0);
      z.dqw().wbf.setAppCmd(this.waY, localByteBuffer.array(), 6);
      dpf();
      this.waR |= 0x40;
      ad.i("MeidaCodec[HWDec]", "[HW]: ErrFrm > threshold, end HWDec!!");
      AppMethodBeat.o(206536);
      return 0;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(1);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.put((byte)1);
    z.dqw().wbf.setAppCmd(28, localByteBuffer.array(), 1);
    this.waM = true;
    AppMethodBeat.o(206536);
    return 1;
  }
  
  private long f(long paramLong, byte[] paramArrayOfByte)
  {
    long l1 = 0L;
    int i = 0;
    int j;
    if (i < paramLong)
    {
      j = 1;
      label17:
      if (this.waT >= this.waS << 3) {
        break label105;
      }
    }
    label105:
    for (int k = 1;; k = 0)
    {
      if ((j & k) == 0) {
        break label111;
      }
      long l2 = l1 << 1;
      l1 = l2;
      if ((paramArrayOfByte[(this.waT >> 3)] & 128 >> (this.waT & 0x7)) != 0) {
        l1 = l2 + 1L;
      }
      this.waT += 1;
      i += 1;
      break;
      j = 0;
      break label17;
    }
    label111:
    return l1;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(206534);
    this.waU = parama;
    if ((this.vac != 0) && (this.vad != 0)) {
      this.waU.onSizeChanged(this.vac, this.vad);
    }
    AppMethodBeat.o(206534);
  }
  
  public final void dpf()
  {
    AppMethodBeat.i(206542);
    this.waK = false;
    this.waL = false;
    this.waN = 0;
    ad.d("MeidaCodec[HWDec]", "steve: Stop Decode Thread!");
    try
    {
      if (this.outputStream != null)
      {
        this.outputStream.flush();
        this.outputStream.close();
      }
      if (this.waB != null)
      {
        this.waB.flush();
        this.waB.close();
      }
      AppMethodBeat.o(206542);
      return;
    }
    catch (IOException localIOException)
    {
      ad.e("MeidaCodec[HWDec]", " error:" + localIOException.toString());
      AppMethodBeat.o(206542);
    }
  }
  
  /* Error */
  public final int f(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 338
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +20 -> 27
    //   10: ldc_w 340
    //   13: ldc_w 342
    //   16: invokestatic 320	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc_w 338
    //   22: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: iconst_m1
    //   26: ireturn
    //   27: aload_0
    //   28: getfield 96	com/tencent/mm/plugin/multitalk/model/j:waK	Z
    //   31: ifne +30 -> 61
    //   34: aload_0
    //   35: aload_0
    //   36: getfield 112	com/tencent/mm/plugin/multitalk/model/j:waR	I
    //   39: iconst_1
    //   40: ior
    //   41: putfield 112	com/tencent/mm/plugin/multitalk/model/j:waR	I
    //   44: ldc_w 340
    //   47: ldc_w 344
    //   50: invokestatic 320	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: ldc_w 338
    //   56: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: iconst_m1
    //   60: ireturn
    //   61: iload_3
    //   62: ifeq +15 -> 77
    //   65: aload_0
    //   66: getfield 145	com/tencent/mm/plugin/multitalk/model/j:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   69: ifnull +8 -> 77
    //   72: aload_0
    //   73: iconst_0
    //   74: putfield 94	com/tencent/mm/plugin/multitalk/model/j:waJ	Z
    //   77: invokestatic 350	java/lang/System:currentTimeMillis	()J
    //   80: pop2
    //   81: aconst_null
    //   82: astore 12
    //   84: iload_2
    //   85: iconst_2
    //   86: if_icmpne +874 -> 960
    //   89: new 352	com/tencent/mm/protocal/protobuf/bng
    //   92: dup
    //   93: invokespecial 353	com/tencent/mm/protocal/protobuf/bng:<init>	()V
    //   96: aload_1
    //   97: invokevirtual 357	com/tencent/mm/protocal/protobuf/bng:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   100: checkcast 352	com/tencent/mm/protocal/protobuf/bng
    //   103: astore_1
    //   104: aload_1
    //   105: getfield 361	com/tencent/mm/protocal/protobuf/bng:GHl	Lcom/tencent/mm/bx/b;
    //   108: ifnonnull +472 -> 580
    //   111: iconst_0
    //   112: istore_2
    //   113: aload_1
    //   114: getfield 364	com/tencent/mm/protocal/protobuf/bng:GHj	Lcom/tencent/mm/bx/b;
    //   117: getfield 369	com/tencent/mm/bx/b:zr	[B
    //   120: arraylength
    //   121: istore 5
    //   123: aload_1
    //   124: getfield 372	com/tencent/mm/protocal/protobuf/bng:GHk	Lcom/tencent/mm/bx/b;
    //   127: getfield 369	com/tencent/mm/bx/b:zr	[B
    //   130: arraylength
    //   131: istore 6
    //   133: iload_2
    //   134: ifeq +458 -> 592
    //   137: aload_0
    //   138: getfield 92	com/tencent/mm/plugin/multitalk/model/j:waG	Z
    //   141: ifne +8 -> 149
    //   144: aload_0
    //   145: iconst_0
    //   146: putfield 94	com/tencent/mm/plugin/multitalk/model/j:waJ	Z
    //   149: aload_0
    //   150: iconst_1
    //   151: putfield 92	com/tencent/mm/plugin/multitalk/model/j:waG	Z
    //   154: iload_2
    //   155: iconst_4
    //   156: iadd
    //   157: newarray byte
    //   159: putstatic 67	com/tencent/mm/plugin/multitalk/model/j:waD	[B
    //   162: iload 5
    //   164: iconst_4
    //   165: iadd
    //   166: newarray byte
    //   168: putstatic 69	com/tencent/mm/plugin/multitalk/model/j:waE	[B
    //   171: iload 6
    //   173: iconst_4
    //   174: iadd
    //   175: newarray byte
    //   177: putstatic 71	com/tencent/mm/plugin/multitalk/model/j:waF	[B
    //   180: aload_0
    //   181: getfield 106	com/tencent/mm/plugin/multitalk/model/j:waO	[B
    //   184: iconst_0
    //   185: getstatic 67	com/tencent/mm/plugin/multitalk/model/j:waD	[B
    //   188: iconst_0
    //   189: iconst_4
    //   190: invokestatic 376	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   193: aload_0
    //   194: getfield 106	com/tencent/mm/plugin/multitalk/model/j:waO	[B
    //   197: iconst_0
    //   198: getstatic 69	com/tencent/mm/plugin/multitalk/model/j:waE	[B
    //   201: iconst_0
    //   202: iconst_4
    //   203: invokestatic 376	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   206: aload_0
    //   207: getfield 106	com/tencent/mm/plugin/multitalk/model/j:waO	[B
    //   210: iconst_0
    //   211: getstatic 71	com/tencent/mm/plugin/multitalk/model/j:waF	[B
    //   214: iconst_0
    //   215: iconst_4
    //   216: invokestatic 376	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   219: aload_1
    //   220: getfield 361	com/tencent/mm/protocal/protobuf/bng:GHl	Lcom/tencent/mm/bx/b;
    //   223: getstatic 67	com/tencent/mm/plugin/multitalk/model/j:waD	[B
    //   226: invokevirtual 380	com/tencent/mm/bx/b:ck	([B)V
    //   229: aload_1
    //   230: getfield 364	com/tencent/mm/protocal/protobuf/bng:GHj	Lcom/tencent/mm/bx/b;
    //   233: getstatic 69	com/tencent/mm/plugin/multitalk/model/j:waE	[B
    //   236: invokevirtual 380	com/tencent/mm/bx/b:ck	([B)V
    //   239: aload_1
    //   240: getfield 372	com/tencent/mm/protocal/protobuf/bng:GHk	Lcom/tencent/mm/bx/b;
    //   243: getstatic 71	com/tencent/mm/plugin/multitalk/model/j:waF	[B
    //   246: invokevirtual 380	com/tencent/mm/bx/b:ck	([B)V
    //   249: aload_0
    //   250: getstatic 67	com/tencent/mm/plugin/multitalk/model/j:waD	[B
    //   253: arraylength
    //   254: getstatic 69	com/tencent/mm/plugin/multitalk/model/j:waE	[B
    //   257: arraylength
    //   258: iadd
    //   259: getstatic 71	com/tencent/mm/plugin/multitalk/model/j:waF	[B
    //   262: arraylength
    //   263: iadd
    //   264: newarray byte
    //   266: putfield 90	com/tencent/mm/plugin/multitalk/model/j:configbyte	[B
    //   269: getstatic 67	com/tencent/mm/plugin/multitalk/model/j:waD	[B
    //   272: iconst_0
    //   273: aload_0
    //   274: getfield 90	com/tencent/mm/plugin/multitalk/model/j:configbyte	[B
    //   277: iconst_0
    //   278: getstatic 67	com/tencent/mm/plugin/multitalk/model/j:waD	[B
    //   281: arraylength
    //   282: invokestatic 376	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   285: getstatic 67	com/tencent/mm/plugin/multitalk/model/j:waD	[B
    //   288: arraylength
    //   289: iconst_0
    //   290: iadd
    //   291: istore_2
    //   292: getstatic 69	com/tencent/mm/plugin/multitalk/model/j:waE	[B
    //   295: iconst_0
    //   296: aload_0
    //   297: getfield 90	com/tencent/mm/plugin/multitalk/model/j:configbyte	[B
    //   300: iload_2
    //   301: getstatic 69	com/tencent/mm/plugin/multitalk/model/j:waE	[B
    //   304: arraylength
    //   305: invokestatic 376	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   308: getstatic 69	com/tencent/mm/plugin/multitalk/model/j:waE	[B
    //   311: arraylength
    //   312: istore 6
    //   314: getstatic 71	com/tencent/mm/plugin/multitalk/model/j:waF	[B
    //   317: iconst_0
    //   318: aload_0
    //   319: getfield 90	com/tencent/mm/plugin/multitalk/model/j:configbyte	[B
    //   322: iload_2
    //   323: iload 6
    //   325: iadd
    //   326: getstatic 71	com/tencent/mm/plugin/multitalk/model/j:waF	[B
    //   329: arraylength
    //   330: invokestatic 376	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   333: aload_0
    //   334: iload 5
    //   336: putfield 114	com/tencent/mm/plugin/multitalk/model/j:waS	I
    //   339: getstatic 69	com/tencent/mm/plugin/multitalk/model/j:waE	[B
    //   342: arraylength
    //   343: iconst_4
    //   344: isub
    //   345: newarray byte
    //   347: astore_1
    //   348: getstatic 69	com/tencent/mm/plugin/multitalk/model/j:waE	[B
    //   351: iconst_4
    //   352: aload_1
    //   353: iconst_0
    //   354: getstatic 69	com/tencent/mm/plugin/multitalk/model/j:waE	[B
    //   357: arraylength
    //   358: iconst_4
    //   359: isub
    //   360: invokestatic 376	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   363: aload_0
    //   364: aload_1
    //   365: invokespecial 382	com/tencent/mm/plugin/multitalk/model/j:bx	([B)Z
    //   368: pop
    //   369: iconst_1
    //   370: istore_2
    //   371: aload 12
    //   373: astore_1
    //   374: aload_1
    //   375: ifnull +21 -> 396
    //   378: aload_0
    //   379: getfield 88	com/tencent/mm/plugin/multitalk/model/j:waB	Ljava/io/BufferedOutputStream;
    //   382: ifnull +14 -> 396
    //   385: aload_0
    //   386: getfield 88	com/tencent/mm/plugin/multitalk/model/j:waB	Ljava/io/BufferedOutputStream;
    //   389: aload_1
    //   390: iconst_0
    //   391: aload_1
    //   392: arraylength
    //   393: invokevirtual 386	java/io/BufferedOutputStream:write	([BII)V
    //   396: iload_2
    //   397: ifeq +958 -> 1355
    //   400: getstatic 69	com/tencent/mm/plugin/multitalk/model/j:waE	[B
    //   403: ifnull +952 -> 1355
    //   406: getstatic 71	com/tencent/mm/plugin/multitalk/model/j:waF	[B
    //   409: ifnull +946 -> 1355
    //   412: aload_0
    //   413: getfield 94	com/tencent/mm/plugin/multitalk/model/j:waJ	Z
    //   416: ifne +156 -> 572
    //   419: aload_0
    //   420: getfield 145	com/tencent/mm/plugin/multitalk/model/j:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   423: astore 12
    //   425: aload 12
    //   427: ifnull +22 -> 449
    //   430: aload_0
    //   431: getfield 145	com/tencent/mm/plugin/multitalk/model/j:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   434: invokevirtual 391	com/tencent/mm/compatible/deviceinfo/z:stop	()V
    //   437: aload_0
    //   438: getfield 145	com/tencent/mm/plugin/multitalk/model/j:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   441: invokevirtual 394	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   444: aload_0
    //   445: aconst_null
    //   446: putfield 145	com/tencent/mm/plugin/multitalk/model/j:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   449: aload_0
    //   450: getfield 92	com/tencent/mm/plugin/multitalk/model/j:waG	Z
    //   453: ifeq +930 -> 1383
    //   456: ldc_w 396
    //   459: getstatic 73	com/tencent/mm/plugin/multitalk/model/j:waH	I
    //   462: getstatic 75	com/tencent/mm/plugin/multitalk/model/j:waI	I
    //   465: invokestatic 402	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   468: astore 12
    //   470: aload 12
    //   472: ldc_w 404
    //   475: bipush 90
    //   477: invokevirtual 408	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   480: ldc 219
    //   482: ldc_w 410
    //   485: aload 12
    //   487: invokestatic 170	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   490: invokevirtual 174	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   493: invokestatic 259	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   496: aload 12
    //   498: ldc_w 412
    //   501: invokevirtual 415	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   504: astore 13
    //   506: aload 13
    //   508: ldc_w 417
    //   511: invokevirtual 421	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   514: ifeq +58 -> 572
    //   517: aload_0
    //   518: aload 13
    //   520: invokestatic 425	com/tencent/mm/compatible/deviceinfo/z:vm	(Ljava/lang/String;)Lcom/tencent/mm/compatible/deviceinfo/z;
    //   523: putfield 145	com/tencent/mm/plugin/multitalk/model/j:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   526: ldc 219
    //   528: ldc_w 427
    //   531: aload 12
    //   533: invokestatic 170	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   536: invokevirtual 174	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   539: invokestatic 320	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   542: aload_0
    //   543: getfield 145	com/tencent/mm/plugin/multitalk/model/j:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   546: aload 12
    //   548: aload_0
    //   549: getfield 147	com/tencent/mm/plugin/multitalk/model/j:surface	Landroid/view/Surface;
    //   552: iconst_0
    //   553: invokevirtual 430	com/tencent/mm/compatible/deviceinfo/z:a	(Landroid/media/MediaFormat;Landroid/view/Surface;I)V
    //   556: aload_0
    //   557: getfield 145	com/tencent/mm/plugin/multitalk/model/j:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   560: invokevirtual 433	com/tencent/mm/compatible/deviceinfo/z:start	()V
    //   563: aload_0
    //   564: iconst_1
    //   565: putfield 94	com/tencent/mm/plugin/multitalk/model/j:waJ	Z
    //   568: aload_0
    //   569: invokevirtual 434	com/tencent/mm/plugin/multitalk/model/j:start	()V
    //   572: ldc_w 338
    //   575: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   578: iconst_1
    //   579: ireturn
    //   580: aload_1
    //   581: getfield 361	com/tencent/mm/protocal/protobuf/bng:GHl	Lcom/tencent/mm/bx/b;
    //   584: getfield 369	com/tencent/mm/bx/b:zr	[B
    //   587: arraylength
    //   588: istore_2
    //   589: goto -476 -> 113
    //   592: aload_0
    //   593: getfield 92	com/tencent/mm/plugin/multitalk/model/j:waG	Z
    //   596: ifeq +8 -> 604
    //   599: aload_0
    //   600: iconst_0
    //   601: putfield 94	com/tencent/mm/plugin/multitalk/model/j:waJ	Z
    //   604: aload_0
    //   605: iconst_0
    //   606: putfield 92	com/tencent/mm/plugin/multitalk/model/j:waG	Z
    //   609: iload 5
    //   611: iconst_4
    //   612: iadd
    //   613: newarray byte
    //   615: astore 13
    //   617: aload_0
    //   618: getfield 106	com/tencent/mm/plugin/multitalk/model/j:waO	[B
    //   621: iconst_0
    //   622: aload 13
    //   624: iconst_0
    //   625: iconst_4
    //   626: invokestatic 376	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   629: aload_1
    //   630: getfield 364	com/tencent/mm/protocal/protobuf/bng:GHj	Lcom/tencent/mm/bx/b;
    //   633: aload 13
    //   635: invokevirtual 380	com/tencent/mm/bx/b:ck	([B)V
    //   638: ldc 219
    //   640: ldc_w 436
    //   643: aload 13
    //   645: invokestatic 170	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   648: invokevirtual 174	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   651: invokestatic 320	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   654: aload 13
    //   656: invokestatic 438	com/tencent/mm/plugin/multitalk/model/j:bu	([B)Ljava/lang/String;
    //   659: astore 14
    //   661: iconst_3
    //   662: newarray byte
    //   664: dup
    //   665: iconst_0
    //   666: ldc 103
    //   668: bastore
    //   669: dup
    //   670: iconst_1
    //   671: ldc 103
    //   673: bastore
    //   674: dup
    //   675: iconst_2
    //   676: ldc_w 439
    //   679: bastore
    //   680: invokestatic 438	com/tencent/mm/plugin/multitalk/model/j:bu	([B)Ljava/lang/String;
    //   683: astore 15
    //   685: ldc 219
    //   687: new 176	java/lang/StringBuilder
    //   690: dup
    //   691: ldc_w 441
    //   694: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   697: aload 14
    //   699: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: ldc_w 443
    //   705: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: aload 15
    //   710: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   716: invokestatic 320	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   719: aload 14
    //   721: aload 15
    //   723: iconst_0
    //   724: invokevirtual 447	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   727: istore_2
    //   728: iload_2
    //   729: iconst_m1
    //   730: if_icmpeq +206 -> 936
    //   733: ldc 219
    //   735: ldc_w 449
    //   738: iload_2
    //   739: invokestatic 451	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   742: invokevirtual 174	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   745: invokestatic 320	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   748: iconst_1
    //   749: istore_2
    //   750: iload_2
    //   751: ifeq +190 -> 941
    //   754: ldc 219
    //   756: ldc_w 453
    //   759: invokestatic 259	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   762: aload 13
    //   764: putstatic 69	com/tencent/mm/plugin/multitalk/model/j:waE	[B
    //   767: ldc 219
    //   769: new 176	java/lang/StringBuilder
    //   772: dup
    //   773: ldc_w 455
    //   776: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   779: getstatic 69	com/tencent/mm/plugin/multitalk/model/j:waE	[B
    //   782: arraylength
    //   783: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   786: ldc_w 457
    //   789: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: iload 5
    //   794: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   797: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   800: invokestatic 320	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   803: iload 6
    //   805: iconst_4
    //   806: iadd
    //   807: newarray byte
    //   809: putstatic 71	com/tencent/mm/plugin/multitalk/model/j:waF	[B
    //   812: aload_0
    //   813: getfield 106	com/tencent/mm/plugin/multitalk/model/j:waO	[B
    //   816: iconst_0
    //   817: getstatic 71	com/tencent/mm/plugin/multitalk/model/j:waF	[B
    //   820: iconst_0
    //   821: iconst_4
    //   822: invokestatic 376	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   825: aload_1
    //   826: getfield 372	com/tencent/mm/protocal/protobuf/bng:GHk	Lcom/tencent/mm/bx/b;
    //   829: getstatic 71	com/tencent/mm/plugin/multitalk/model/j:waF	[B
    //   832: invokevirtual 380	com/tencent/mm/bx/b:ck	([B)V
    //   835: aload_0
    //   836: getstatic 69	com/tencent/mm/plugin/multitalk/model/j:waE	[B
    //   839: arraylength
    //   840: getstatic 71	com/tencent/mm/plugin/multitalk/model/j:waF	[B
    //   843: arraylength
    //   844: iadd
    //   845: newarray byte
    //   847: putfield 90	com/tencent/mm/plugin/multitalk/model/j:configbyte	[B
    //   850: getstatic 69	com/tencent/mm/plugin/multitalk/model/j:waE	[B
    //   853: iconst_0
    //   854: aload_0
    //   855: getfield 90	com/tencent/mm/plugin/multitalk/model/j:configbyte	[B
    //   858: iconst_0
    //   859: getstatic 69	com/tencent/mm/plugin/multitalk/model/j:waE	[B
    //   862: arraylength
    //   863: invokestatic 376	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   866: getstatic 69	com/tencent/mm/plugin/multitalk/model/j:waE	[B
    //   869: arraylength
    //   870: istore_2
    //   871: getstatic 71	com/tencent/mm/plugin/multitalk/model/j:waF	[B
    //   874: iconst_0
    //   875: aload_0
    //   876: getfield 90	com/tencent/mm/plugin/multitalk/model/j:configbyte	[B
    //   879: iload_2
    //   880: iconst_0
    //   881: iadd
    //   882: getstatic 71	com/tencent/mm/plugin/multitalk/model/j:waF	[B
    //   885: arraylength
    //   886: invokestatic 376	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   889: goto -556 -> 333
    //   892: astore_1
    //   893: aload_0
    //   894: aload_0
    //   895: getfield 112	com/tencent/mm/plugin/multitalk/model/j:waR	I
    //   898: iconst_2
    //   899: ior
    //   900: putfield 112	com/tencent/mm/plugin/multitalk/model/j:waR	I
    //   903: ldc 219
    //   905: new 176	java/lang/StringBuilder
    //   908: dup
    //   909: ldc_w 459
    //   912: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   915: aload_1
    //   916: invokevirtual 460	java/lang/Exception:toString	()Ljava/lang/String;
    //   919: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   925: invokestatic 334	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   928: iconst_0
    //   929: istore_2
    //   930: aload 12
    //   932: astore_1
    //   933: goto -559 -> 374
    //   936: iconst_0
    //   937: istore_2
    //   938: goto -188 -> 750
    //   941: new 462	com/tencent/mm/plugin/voip/model/g
    //   944: dup
    //   945: invokespecial 463	com/tencent/mm/plugin/voip/model/g:<init>	()V
    //   948: pop
    //   949: aload 13
    //   951: invokestatic 467	com/tencent/mm/plugin/voip/model/g:bM	([B)[B
    //   954: putstatic 69	com/tencent/mm/plugin/multitalk/model/j:waE	[B
    //   957: goto -190 -> 767
    //   960: new 469	com/tencent/mm/protocal/protobuf/bnf
    //   963: dup
    //   964: invokespecial 470	com/tencent/mm/protocal/protobuf/bnf:<init>	()V
    //   967: aload_1
    //   968: invokevirtual 471	com/tencent/mm/protocal/protobuf/bnf:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   971: checkcast 469	com/tencent/mm/protocal/protobuf/bnf
    //   974: astore 13
    //   976: aload 13
    //   978: getfield 475	com/tencent/mm/protocal/protobuf/bnf:GHh	Ljava/util/LinkedList;
    //   981: invokevirtual 481	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   984: checkcast 154	java/lang/Integer
    //   987: invokevirtual 484	java/lang/Integer:intValue	()I
    //   990: istore 7
    //   992: iconst_0
    //   993: istore 5
    //   995: ldc 219
    //   997: ldc_w 486
    //   1000: iload 7
    //   1002: invokestatic 451	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1005: invokevirtual 174	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1008: invokestatic 320	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1011: iload_2
    //   1012: iconst_1
    //   1013: if_icmpne +185 -> 1198
    //   1016: aload_0
    //   1017: getfield 90	com/tencent/mm/plugin/multitalk/model/j:configbyte	[B
    //   1020: arraylength
    //   1021: istore 5
    //   1023: iload 7
    //   1025: iload 5
    //   1027: iadd
    //   1028: istore 6
    //   1030: iload 6
    //   1032: newarray byte
    //   1034: astore_1
    //   1035: aload_0
    //   1036: getfield 90	com/tencent/mm/plugin/multitalk/model/j:configbyte	[B
    //   1039: iconst_0
    //   1040: aload_1
    //   1041: iconst_0
    //   1042: iload 5
    //   1044: invokestatic 376	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1047: iload 5
    //   1049: iconst_0
    //   1050: iadd
    //   1051: istore 5
    //   1053: goto +870 -> 1923
    //   1056: iconst_4
    //   1057: invokestatic 265	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1060: astore 14
    //   1062: aload 13
    //   1064: getfield 489	com/tencent/mm/protocal/protobuf/bnf:GHe	Lcom/tencent/mm/bx/b;
    //   1067: aload 14
    //   1069: invokevirtual 295	java/nio/ByteBuffer:array	()[B
    //   1072: iload 7
    //   1074: iconst_0
    //   1075: iconst_4
    //   1076: invokevirtual 492	com/tencent/mm/bx/b:i	([BIII)V
    //   1079: aload 14
    //   1081: getstatic 495	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   1084: invokevirtual 275	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1087: pop
    //   1088: aload 14
    //   1090: iconst_0
    //   1091: invokevirtual 499	java/nio/ByteBuffer:getInt	(I)I
    //   1094: istore 9
    //   1096: aload_0
    //   1097: getfield 106	com/tencent/mm/plugin/multitalk/model/j:waO	[B
    //   1100: iconst_0
    //   1101: aload_1
    //   1102: iload 7
    //   1104: iload 5
    //   1106: iadd
    //   1107: iconst_4
    //   1108: invokestatic 376	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1111: iload 7
    //   1113: iconst_4
    //   1114: iadd
    //   1115: istore 7
    //   1117: aload 13
    //   1119: getfield 489	com/tencent/mm/protocal/protobuf/bnf:GHe	Lcom/tencent/mm/bx/b;
    //   1122: aload_1
    //   1123: iload 7
    //   1125: iload 7
    //   1127: iload 5
    //   1129: iadd
    //   1130: iload 9
    //   1132: invokevirtual 492	com/tencent/mm/bx/b:i	([BIII)V
    //   1135: iload 8
    //   1137: iload 9
    //   1139: iconst_4
    //   1140: iadd
    //   1141: isub
    //   1142: istore 8
    //   1144: ldc 219
    //   1146: new 176	java/lang/StringBuilder
    //   1149: dup
    //   1150: ldc_w 501
    //   1153: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1156: iload 9
    //   1158: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1161: ldc_w 503
    //   1164: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1167: iload 6
    //   1169: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1172: ldc_w 505
    //   1175: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: iload_2
    //   1179: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1182: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1185: invokestatic 320	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1188: iload 8
    //   1190: ifgt +723 -> 1913
    //   1193: iconst_0
    //   1194: istore_2
    //   1195: goto -821 -> 374
    //   1198: iload 7
    //   1200: newarray byte
    //   1202: astore_1
    //   1203: iload 7
    //   1205: istore 6
    //   1207: goto +716 -> 1923
    //   1210: astore_1
    //   1211: aload_0
    //   1212: aload_0
    //   1213: getfield 112	com/tencent/mm/plugin/multitalk/model/j:waR	I
    //   1216: iconst_4
    //   1217: ior
    //   1218: putfield 112	com/tencent/mm/plugin/multitalk/model/j:waR	I
    //   1221: ldc 219
    //   1223: new 176	java/lang/StringBuilder
    //   1226: dup
    //   1227: ldc_w 507
    //   1230: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1233: aload_1
    //   1234: invokevirtual 460	java/lang/Exception:toString	()Ljava/lang/String;
    //   1237: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1243: invokestatic 334	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1246: iconst_0
    //   1247: istore_2
    //   1248: aload 12
    //   1250: astore_1
    //   1251: goto -877 -> 374
    //   1254: astore 12
    //   1256: ldc 219
    //   1258: new 176	java/lang/StringBuilder
    //   1261: dup
    //   1262: ldc_w 330
    //   1265: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1268: aload 12
    //   1270: invokevirtual 331	java/io/IOException:toString	()Ljava/lang/String;
    //   1273: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1276: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1279: invokestatic 334	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1282: goto -886 -> 396
    //   1285: astore 12
    //   1287: ldc 219
    //   1289: new 176	java/lang/StringBuilder
    //   1292: dup
    //   1293: ldc_w 509
    //   1296: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1299: aload 12
    //   1301: invokevirtual 460	java/lang/Exception:toString	()Ljava/lang/String;
    //   1304: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1310: invokestatic 334	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1313: goto -864 -> 449
    //   1316: astore 12
    //   1318: aload_0
    //   1319: aload_0
    //   1320: getfield 112	com/tencent/mm/plugin/multitalk/model/j:waR	I
    //   1323: bipush 16
    //   1325: ior
    //   1326: putfield 112	com/tencent/mm/plugin/multitalk/model/j:waR	I
    //   1329: ldc 219
    //   1331: new 176	java/lang/StringBuilder
    //   1334: dup
    //   1335: ldc_w 330
    //   1338: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1341: aload 12
    //   1343: invokevirtual 460	java/lang/Exception:toString	()Ljava/lang/String;
    //   1346: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1349: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1352: invokestatic 334	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1355: aload_0
    //   1356: getfield 94	com/tencent/mm/plugin/multitalk/model/j:waJ	Z
    //   1359: ifne +106 -> 1465
    //   1362: ldc 219
    //   1364: ldc_w 511
    //   1367: invokestatic 334	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1370: aload_0
    //   1371: invokespecial 513	com/tencent/mm/plugin/multitalk/model/j:dpe	()I
    //   1374: pop
    //   1375: ldc_w 338
    //   1378: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1381: iconst_m1
    //   1382: ireturn
    //   1383: ldc_w 515
    //   1386: getstatic 73	com/tencent/mm/plugin/multitalk/model/j:waH	I
    //   1389: getstatic 75	com/tencent/mm/plugin/multitalk/model/j:waI	I
    //   1392: invokestatic 402	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   1395: astore 12
    //   1397: goto -927 -> 470
    //   1400: astore 12
    //   1402: aload_0
    //   1403: aload_0
    //   1404: getfield 112	com/tencent/mm/plugin/multitalk/model/j:waR	I
    //   1407: bipush 8
    //   1409: ior
    //   1410: putfield 112	com/tencent/mm/plugin/multitalk/model/j:waR	I
    //   1413: ldc 219
    //   1415: new 176	java/lang/StringBuilder
    //   1418: dup
    //   1419: ldc_w 517
    //   1422: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1425: aload 13
    //   1427: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1430: ldc_w 519
    //   1433: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: aload 12
    //   1438: invokevirtual 522	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1441: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1444: invokestatic 334	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1447: aload_0
    //   1448: iconst_0
    //   1449: putfield 96	com/tencent/mm/plugin/multitalk/model/j:waK	Z
    //   1452: aload_0
    //   1453: invokespecial 513	com/tencent/mm/plugin/multitalk/model/j:dpe	()I
    //   1456: pop
    //   1457: ldc_w 338
    //   1460: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1463: iconst_m1
    //   1464: ireturn
    //   1465: aload_1
    //   1466: ifnonnull +19 -> 1485
    //   1469: ldc 219
    //   1471: ldc_w 524
    //   1474: invokestatic 334	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1477: ldc_w 338
    //   1480: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1483: iconst_m1
    //   1484: ireturn
    //   1485: aload_0
    //   1486: getfield 98	com/tencent/mm/plugin/multitalk/model/j:waL	Z
    //   1489: ifne +8 -> 1497
    //   1492: aload_0
    //   1493: iconst_1
    //   1494: putfield 98	com/tencent/mm/plugin/multitalk/model/j:waL	Z
    //   1497: aload_1
    //   1498: arraylength
    //   1499: istore_2
    //   1500: aload_1
    //   1501: iconst_4
    //   1502: baload
    //   1503: bipush 31
    //   1505: iand
    //   1506: istore 5
    //   1508: iload 5
    //   1510: bipush 7
    //   1512: if_icmpeq +10 -> 1522
    //   1515: iload 5
    //   1517: bipush 8
    //   1519: if_icmpne +95 -> 1614
    //   1522: bipush 83
    //   1524: istore 4
    //   1526: ldc 219
    //   1528: new 176	java/lang/StringBuilder
    //   1531: dup
    //   1532: ldc_w 526
    //   1535: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1538: iload_2
    //   1539: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1542: ldc_w 528
    //   1545: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1548: iload 5
    //   1550: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1553: ldc_w 530
    //   1556: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1559: iload 4
    //   1561: invokevirtual 533	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1564: ldc_w 535
    //   1567: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1570: aload_0
    //   1571: getfield 110	com/tencent/mm/plugin/multitalk/model/j:waQ	I
    //   1574: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1577: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1580: invokestatic 320	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1583: aload_0
    //   1584: getfield 100	com/tencent/mm/plugin/multitalk/model/j:waM	Z
    //   1587: ifeq +54 -> 1641
    //   1590: iload 4
    //   1592: bipush 80
    //   1594: if_icmpne +47 -> 1641
    //   1597: ldc 219
    //   1599: ldc_w 537
    //   1602: invokestatic 334	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1605: ldc_w 338
    //   1608: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1611: bipush 254
    //   1613: ireturn
    //   1614: iload 5
    //   1616: iconst_5
    //   1617: if_icmpeq +10 -> 1627
    //   1620: iload 5
    //   1622: bipush 6
    //   1624: if_icmpne +10 -> 1634
    //   1627: bipush 73
    //   1629: istore 4
    //   1631: goto -105 -> 1526
    //   1634: bipush 80
    //   1636: istore 4
    //   1638: goto -112 -> 1526
    //   1641: aload_0
    //   1642: getfield 145	com/tencent/mm/plugin/multitalk/model/j:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1645: ldc2_w 538
    //   1648: invokevirtual 543	com/tencent/mm/compatible/deviceinfo/z:dequeueInputBuffer	(J)I
    //   1651: istore 5
    //   1653: iload 5
    //   1655: iflt +212 -> 1867
    //   1658: aload_1
    //   1659: ifnull +186 -> 1845
    //   1662: iload_2
    //   1663: ifle +182 -> 1845
    //   1666: invokestatic 350	java/lang/System:currentTimeMillis	()J
    //   1669: lstore 10
    //   1671: ldc 219
    //   1673: new 176	java/lang/StringBuilder
    //   1676: dup
    //   1677: ldc_w 545
    //   1680: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1683: iload 5
    //   1685: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1688: ldc_w 547
    //   1691: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1694: iload_2
    //   1695: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1698: ldc_w 530
    //   1701: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1704: iload 4
    //   1706: invokevirtual 533	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1709: ldc_w 549
    //   1712: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1715: lload 10
    //   1717: invokevirtual 552	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1720: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1723: invokestatic 320	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1726: getstatic 557	android/os/Build$VERSION:SDK_INT	I
    //   1729: bipush 21
    //   1731: if_icmpge +122 -> 1853
    //   1734: aload_0
    //   1735: getfield 145	com/tencent/mm/plugin/multitalk/model/j:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1738: invokevirtual 561	com/tencent/mm/compatible/deviceinfo/z:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   1741: iload 5
    //   1743: aaload
    //   1744: astore 12
    //   1746: aload 12
    //   1748: invokevirtual 565	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1751: pop
    //   1752: aload 12
    //   1754: invokevirtual 565	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1757: pop
    //   1758: aload 12
    //   1760: aload_1
    //   1761: iconst_0
    //   1762: iload_2
    //   1763: invokevirtual 568	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1766: pop
    //   1767: aload_0
    //   1768: getfield 145	com/tencent/mm/plugin/multitalk/model/j:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1771: iload 5
    //   1773: iload_2
    //   1774: lload 10
    //   1776: iconst_0
    //   1777: invokevirtual 571	com/tencent/mm/compatible/deviceinfo/z:a	(IIJI)V
    //   1780: aload_0
    //   1781: aload_0
    //   1782: getfield 110	com/tencent/mm/plugin/multitalk/model/j:waQ	I
    //   1785: iconst_1
    //   1786: iadd
    //   1787: putfield 110	com/tencent/mm/plugin/multitalk/model/j:waQ	I
    //   1790: aload_0
    //   1791: iconst_0
    //   1792: putfield 102	com/tencent/mm/plugin/multitalk/model/j:waN	I
    //   1795: aload_0
    //   1796: getfield 100	com/tencent/mm/plugin/multitalk/model/j:waM	Z
    //   1799: ifeq +46 -> 1845
    //   1802: iconst_1
    //   1803: invokestatic 265	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1806: astore_1
    //   1807: aload_1
    //   1808: getstatic 271	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   1811: invokevirtual 275	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1814: pop
    //   1815: aload_1
    //   1816: iconst_0
    //   1817: invokevirtual 310	java/nio/ByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   1820: pop
    //   1821: invokestatic 285	com/tencent/mm/plugin/multitalk/model/z:dqw	()Lcom/tencent/mm/plugin/multitalk/model/m;
    //   1824: getfield 291	com/tencent/mm/plugin/multitalk/model/m:wbf	Lcom/tencent/pb/talkroom/sdk/d;
    //   1827: bipush 28
    //   1829: aload_1
    //   1830: invokevirtual 295	java/nio/ByteBuffer:array	()[B
    //   1833: iconst_1
    //   1834: invokeinterface 301 4 0
    //   1839: pop
    //   1840: aload_0
    //   1841: iconst_0
    //   1842: putfield 100	com/tencent/mm/plugin/multitalk/model/j:waM	Z
    //   1845: ldc_w 338
    //   1848: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1851: iconst_0
    //   1852: ireturn
    //   1853: aload_0
    //   1854: getfield 145	com/tencent/mm/plugin/multitalk/model/j:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1857: iload 5
    //   1859: invokevirtual 574	com/tencent/mm/compatible/deviceinfo/z:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   1862: astore 12
    //   1864: goto -112 -> 1752
    //   1867: aload_0
    //   1868: getfield 100	com/tencent/mm/plugin/multitalk/model/j:waM	Z
    //   1871: ifeq +26 -> 1897
    //   1874: iload 4
    //   1876: bipush 80
    //   1878: if_icmpeq +19 -> 1897
    //   1881: aload_0
    //   1882: iconst_0
    //   1883: putfield 96	com/tencent/mm/plugin/multitalk/model/j:waK	Z
    //   1886: aload_0
    //   1887: aload_0
    //   1888: getfield 112	com/tencent/mm/plugin/multitalk/model/j:waR	I
    //   1891: bipush 32
    //   1893: ior
    //   1894: putfield 112	com/tencent/mm/plugin/multitalk/model/j:waR	I
    //   1897: aload_0
    //   1898: invokespecial 513	com/tencent/mm/plugin/multitalk/model/j:dpe	()I
    //   1901: pop
    //   1902: ldc 219
    //   1904: ldc_w 576
    //   1907: invokestatic 334	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1910: goto -65 -> 1845
    //   1913: iload 7
    //   1915: iload 9
    //   1917: iadd
    //   1918: istore 7
    //   1920: goto -864 -> 1056
    //   1923: iconst_0
    //   1924: istore 9
    //   1926: iload 7
    //   1928: istore 8
    //   1930: iload 9
    //   1932: istore 7
    //   1934: goto -878 -> 1056
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1937	0	this	j
    //   0	1937	1	paramArrayOfByte	byte[]
    //   0	1937	2	paramInt	int
    //   0	1937	3	paramBoolean	boolean
    //   1524	355	4	c	char
    //   121	1737	5	i	int
    //   131	1075	6	j	int
    //   990	943	7	k	int
    //   1135	794	8	m	int
    //   1094	837	9	n	int
    //   1669	106	10	l	long
    //   82	1167	12	localObject1	Object
    //   1254	15	12	localIOException	IOException
    //   1285	15	12	localException1	Exception
    //   1316	26	12	localException2	Exception
    //   1395	1	12	localMediaFormat	MediaFormat
    //   1400	37	12	localException3	Exception
    //   1744	119	12	localByteBuffer	ByteBuffer
    //   504	922	13	localObject2	Object
    //   659	430	14	localObject3	Object
    //   683	39	15	str	String
    // Exception table:
    //   from	to	target	type
    //   89	111	892	java/lang/Exception
    //   113	133	892	java/lang/Exception
    //   137	149	892	java/lang/Exception
    //   149	333	892	java/lang/Exception
    //   333	369	892	java/lang/Exception
    //   580	589	892	java/lang/Exception
    //   592	604	892	java/lang/Exception
    //   604	728	892	java/lang/Exception
    //   733	748	892	java/lang/Exception
    //   754	767	892	java/lang/Exception
    //   767	889	892	java/lang/Exception
    //   941	957	892	java/lang/Exception
    //   960	992	1210	java/lang/Exception
    //   995	1011	1210	java/lang/Exception
    //   1016	1023	1210	java/lang/Exception
    //   1030	1047	1210	java/lang/Exception
    //   1056	1111	1210	java/lang/Exception
    //   1117	1135	1210	java/lang/Exception
    //   1144	1188	1210	java/lang/Exception
    //   1198	1203	1210	java/lang/Exception
    //   385	396	1254	java/io/IOException
    //   430	449	1285	java/lang/Exception
    //   400	425	1316	java/lang/Exception
    //   449	470	1316	java/lang/Exception
    //   470	526	1316	java/lang/Exception
    //   556	572	1316	java/lang/Exception
    //   1287	1313	1316	java/lang/Exception
    //   1383	1397	1316	java/lang/Exception
    //   1402	1457	1316	java/lang/Exception
    //   526	556	1400	java/lang/Exception
  }
  
  @SuppressLint({"NewApi"})
  public final void run()
  {
    AppMethodBeat.i(206541);
    if ((!Thread.interrupted()) && (this.waK)) {
      if ((this.waC == null) || (!this.waJ) || (!this.waL)) {}
    }
    for (;;)
    {
      for (;;)
      {
        int i;
        try
        {
          MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
          i = this.waC.dequeueOutputBuffer(localBufferInfo, 10000L);
          ad.d("MeidaCodec[HWDec]", "steve:  outIndex=".concat(String.valueOf(i)));
          switch (i)
          {
          case -3: 
            if (localBufferInfo.size <= 0) {
              break label386;
            }
            long l1 = localBufferInfo.presentationTimeUs;
            long l2 = System.currentTimeMillis();
            ad.d("MeidaCodec[HWDec]", "DECODER_THREAD:: decoded SUCCESSFULLY!!! cnt : " + this.waP + ", size:" + localBufferInfo.size + ", pts:" + localBufferInfo.presentationTimeUs + ", latency:" + (l2 - l1));
            this.waP += 1;
            this.waC.releaseOutputBuffer(i, true);
            l2 = System.currentTimeMillis();
            ad.d("MeidaCodec[HWDec]", "steve: Avcdecoder frame processTime = " + (l2 - l1) + ", decFrameCnt=" + this.waP + ", endTime=" + l2);
          }
        }
        catch (Exception localException1)
        {
          this.waK = false;
          this.waR |= 0x80;
          dpe();
          ad.e("MeidaCodec[HWDec]", " dequeueOutputBuffer/releaseOutputBuffer error:" + localException1.toString());
        }
        break;
        ad.d("MeidaCodec[HWDec]", "INFO_OUTPUT_BUFFERS_CHANGED");
        break;
        MediaFormat localMediaFormat = this.waC.getOutputFormat();
        ad.i("MeidaCodec[HWDec]", "DECODER_THREAD:: New format : ".concat(String.valueOf(localMediaFormat)));
        localMediaFormat.getInteger("width");
        localMediaFormat.getInteger("height");
        break;
        ad.d("MeidaCodec[HWDec]", "DECODER_THREAD:: dequeueOutputBuffer timed out!");
        break;
        label386:
        ad.d("MeidaCodec[HWDec]", "steve: drop frame: " + this.waP + ", size:" + localMediaFormat.size + ", pts:" + localMediaFormat.presentationTimeUs);
        this.waC.releaseOutputBuffer(i, false);
        break;
        try
        {
          Thread.sleep(20L);
        }
        catch (InterruptedException localInterruptedException)
        {
          ad.e("MeidaCodec[HWDec]", " error:" + localInterruptedException.toString());
        }
      }
      break;
      if ((!this.waK) && (this.waC != null)) {
        try
        {
          this.waC.stop();
          this.waC.release();
          this.waC = null;
          AppMethodBeat.o(206541);
          return;
        }
        catch (Exception localException2)
        {
          ad.e("MeidaCodec[HWDec]", " decoder stop  error:" + localException2.toString());
        }
      }
      AppMethodBeat.o(206541);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onSizeChanged(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.j
 * JD-Core Version:    0.7.0.1
 */