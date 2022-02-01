package com.tencent.mm.plugin.multitalk.model;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.pb.talkroom.sdk.d;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class j
  extends Thread
{
  public static int LmL;
  private static String LmM;
  public static byte[] LmP;
  public static byte[] LmQ;
  public static byte[] LmR;
  public static int LmT;
  public static int LmU;
  public int KcH;
  public int KcI;
  private BufferedOutputStream LmN;
  private aa LmO;
  private boolean LmS;
  private boolean LmV;
  public boolean LmW;
  public boolean LmX;
  public boolean LmY;
  public int LmZ;
  public byte[] Lna;
  public int Lnb;
  public int Lnc;
  public int Lnd;
  private int Lne;
  private int Lnf;
  j.a Lng;
  public byte[] Lnh;
  public byte[] Lni;
  public byte[] Lnj;
  private int Lnk;
  public byte[] configbyte;
  private BufferedOutputStream outputStream;
  private Surface surface;
  
  static
  {
    AppMethodBeat.i(284844);
    LmL = 10;
    LmM = b.bmz();
    LmP = null;
    LmQ = null;
    LmR = null;
    LmT = 640;
    LmU = 480;
    AppMethodBeat.o(284844);
  }
  
  public j(Surface paramSurface)
  {
    AppMethodBeat.i(284769);
    this.outputStream = null;
    this.LmN = null;
    this.configbyte = null;
    this.LmS = false;
    this.LmV = false;
    this.LmW = true;
    this.LmX = true;
    this.LmY = false;
    this.LmZ = 0;
    this.Lna = new byte[] { 0, 0, 0, 1 };
    this.Lnb = 0;
    this.Lnc = 0;
    this.Lnd = 0;
    this.Lne = 0;
    this.Lnf = 0;
    this.KcH = 0;
    this.KcI = 0;
    this.Lnh = new byte[] { 103, 100, 0, 13, -84, -74, 10, 15, -120 };
    this.Lni = new byte[] { 0, 0, 0, 1, 40, -50, 60, 48 };
    this.Lnj = new byte[] { 13, 0, -15, 98, -22 };
    this.Lnk = 39;
    this.LmW = true;
    this.LmX = true;
    this.LmO = null;
    this.LmS = false;
    this.Lnd = 0;
    if (paramSurface != null) {
      this.surface = paramSurface;
    }
    AppMethodBeat.o(284769);
  }
  
  private static String cg(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(284792);
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
    AppMethodBeat.o(284792);
    return str1;
  }
  
  private long ch(byte[] paramArrayOfByte)
  {
    long l1 = 0L;
    long l2 = 0L;
    while ((this.Lnf < this.Lne << 3) && ((paramArrayOfByte[(this.Lnf >> 3)] & 128 >> (this.Lnf & 0x7)) == 0))
    {
      l2 += 1L;
      this.Lnf += 1;
    }
    this.Lnf += 1;
    int i = 0;
    while (i < l2)
    {
      long l3 = l1 << 1;
      l1 = l3;
      if ((paramArrayOfByte[(this.Lnf >> 3)] & 128 >> (this.Lnf & 0x7)) != 0) {
        l1 = l3 + 1L;
      }
      this.Lnf += 1;
      i += 1;
    }
    return (1 << (int)l2) - 1 + l1;
  }
  
  private long ci(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(284809);
    long l3 = ch(paramArrayOfByte);
    long l2 = 1L + l3 >> 1;
    long l1 = l2;
    if (l3 % 2L == 0L) {
      l1 = -l2;
    }
    AppMethodBeat.o(284809);
    return l1;
  }
  
  private boolean cj(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(284832);
    this.Lnf = 0;
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
      ch(paramArrayOfByte);
      long[] arrayOfLong;
      int i;
      if ((l1 == 100L) || (l1 == 110L) || (l1 == 122L) || (l1 == 144L))
      {
        if (ch(paramArrayOfByte) == 3L) {
          f(1L, paramArrayOfByte);
        }
        ch(paramArrayOfByte);
        ch(paramArrayOfByte);
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
      ch(paramArrayOfByte);
      l1 = ch(paramArrayOfByte);
      if (l1 == 0L) {
        ch(paramArrayOfByte);
      }
      for (;;)
      {
        ch(paramArrayOfByte);
        f(1L, paramArrayOfByte);
        l1 = ch(paramArrayOfByte);
        long l2 = ch(paramArrayOfByte);
        i = (int)(l1 + 1L) * 16;
        int j = (int)(l2 + 1L) * 16;
        Log.i("MeidaCodec[HWDec]", "newWidth[%d], newHeight[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if ((i != this.KcH) || (j != this.KcI))
        {
          this.KcH = i;
          this.KcI = j;
          if (this.Lng != null) {
            this.Lng.onSizeChanged(i, j);
          }
        }
        AppMethodBeat.o(284832);
        return true;
        if (l1 == 1L)
        {
          f(1L, paramArrayOfByte);
          ci(paramArrayOfByte);
          ci(paramArrayOfByte);
          j = (int)ch(paramArrayOfByte);
          arrayOfLong = new long[j];
          i = 0;
          while (i < j)
          {
            arrayOfLong[i] = ci(paramArrayOfByte);
            i += 1;
          }
        }
      }
    }
    AppMethodBeat.o(284832);
    return false;
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
      if (this.Lnf >= this.Lne << 3) {
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
      if ((paramArrayOfByte[(this.Lnf >> 3)] & 128 >> (this.Lnf & 0x7)) != 0) {
        l1 = l2 + 1L;
      }
      this.Lnf += 1;
      i += 1;
      break;
      j = 0;
      break label17;
    }
    label111:
    return l1;
  }
  
  private int gff()
  {
    AppMethodBeat.i(284782);
    this.LmZ += 1;
    Log.i("MeidaCodec[HWDec]", "[HW]:DecFrmError: I Req mIReqFlag = " + this.LmY + ", mIsHWDecEnable = " + this.LmW + ", mHWErrorDecFrmCount = " + this.LmZ);
    if ((!this.LmW) || (this.LmZ > LmL))
    {
      int i = 8;
      if (this.LmS) {
        i = 16;
      }
      localByteBuffer = ByteBuffer.allocate(6);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer.putShort((short)0);
      localByteBuffer.putShort((short)i);
      localByteBuffer.putShort((short)0);
      ac.ggR().LnJ.setAppCmd(this.Lnk, localByteBuffer.array(), 6);
      gfg();
      this.Lnd |= 0x40;
      Log.i("MeidaCodec[HWDec]", "[HW]: ErrFrm > threshold, end HWDec!!");
      AppMethodBeat.o(284782);
      return 0;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(1);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.put((byte)1);
    ac.ggR().LnJ.setAppCmd(28, localByteBuffer.array(), 1);
    this.LmY = true;
    AppMethodBeat.o(284782);
    return 1;
  }
  
  /* Error */
  public final int f(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 315
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +20 -> 27
    //   10: ldc_w 317
    //   13: ldc_w 319
    //   16: invokestatic 322	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc_w 315
    //   22: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: iconst_m1
    //   26: ireturn
    //   27: aload_0
    //   28: getfield 95	com/tencent/mm/plugin/multitalk/model/j:LmW	Z
    //   31: ifne +30 -> 61
    //   34: aload_0
    //   35: aload_0
    //   36: getfield 111	com/tencent/mm/plugin/multitalk/model/j:Lnd	I
    //   39: iconst_1
    //   40: ior
    //   41: putfield 111	com/tencent/mm/plugin/multitalk/model/j:Lnd	I
    //   44: ldc_w 317
    //   47: ldc_w 324
    //   50: invokestatic 322	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: ldc_w 315
    //   56: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: iconst_m1
    //   60: ireturn
    //   61: iload_3
    //   62: ifeq +15 -> 77
    //   65: aload_0
    //   66: getfield 144	com/tencent/mm/plugin/multitalk/model/j:LmO	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   69: ifnull +8 -> 77
    //   72: aload_0
    //   73: iconst_0
    //   74: putfield 93	com/tencent/mm/plugin/multitalk/model/j:LmV	Z
    //   77: invokestatic 330	java/lang/System:currentTimeMillis	()J
    //   80: pop2
    //   81: aconst_null
    //   82: astore 12
    //   84: iload_2
    //   85: iconst_2
    //   86: if_icmpne +873 -> 959
    //   89: new 332	com/tencent/mm/protocal/protobuf/cyt
    //   92: dup
    //   93: invokespecial 333	com/tencent/mm/protocal/protobuf/cyt:<init>	()V
    //   96: aload_1
    //   97: invokevirtual 337	com/tencent/mm/protocal/protobuf/cyt:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   100: checkcast 332	com/tencent/mm/protocal/protobuf/cyt
    //   103: astore_1
    //   104: aload_1
    //   105: getfield 341	com/tencent/mm/protocal/protobuf/cyt:aaDB	Lcom/tencent/mm/bx/b;
    //   108: ifnonnull +472 -> 580
    //   111: iconst_0
    //   112: istore_2
    //   113: aload_1
    //   114: getfield 344	com/tencent/mm/protocal/protobuf/cyt:aaDz	Lcom/tencent/mm/bx/b;
    //   117: getfield 349	com/tencent/mm/bx/b:Op	[B
    //   120: arraylength
    //   121: istore 5
    //   123: aload_1
    //   124: getfield 352	com/tencent/mm/protocal/protobuf/cyt:aaDA	Lcom/tencent/mm/bx/b;
    //   127: getfield 349	com/tencent/mm/bx/b:Op	[B
    //   130: arraylength
    //   131: istore 6
    //   133: iload_2
    //   134: ifeq +458 -> 592
    //   137: aload_0
    //   138: getfield 91	com/tencent/mm/plugin/multitalk/model/j:LmS	Z
    //   141: ifne +8 -> 149
    //   144: aload_0
    //   145: iconst_0
    //   146: putfield 93	com/tencent/mm/plugin/multitalk/model/j:LmV	Z
    //   149: aload_0
    //   150: iconst_1
    //   151: putfield 91	com/tencent/mm/plugin/multitalk/model/j:LmS	Z
    //   154: iload_2
    //   155: iconst_4
    //   156: iadd
    //   157: newarray byte
    //   159: putstatic 66	com/tencent/mm/plugin/multitalk/model/j:LmP	[B
    //   162: iload 5
    //   164: iconst_4
    //   165: iadd
    //   166: newarray byte
    //   168: putstatic 68	com/tencent/mm/plugin/multitalk/model/j:LmQ	[B
    //   171: iload 6
    //   173: iconst_4
    //   174: iadd
    //   175: newarray byte
    //   177: putstatic 70	com/tencent/mm/plugin/multitalk/model/j:LmR	[B
    //   180: aload_0
    //   181: getfield 105	com/tencent/mm/plugin/multitalk/model/j:Lna	[B
    //   184: iconst_0
    //   185: getstatic 66	com/tencent/mm/plugin/multitalk/model/j:LmP	[B
    //   188: iconst_0
    //   189: iconst_4
    //   190: invokestatic 356	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   193: aload_0
    //   194: getfield 105	com/tencent/mm/plugin/multitalk/model/j:Lna	[B
    //   197: iconst_0
    //   198: getstatic 68	com/tencent/mm/plugin/multitalk/model/j:LmQ	[B
    //   201: iconst_0
    //   202: iconst_4
    //   203: invokestatic 356	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   206: aload_0
    //   207: getfield 105	com/tencent/mm/plugin/multitalk/model/j:Lna	[B
    //   210: iconst_0
    //   211: getstatic 70	com/tencent/mm/plugin/multitalk/model/j:LmR	[B
    //   214: iconst_0
    //   215: iconst_4
    //   216: invokestatic 356	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   219: aload_1
    //   220: getfield 341	com/tencent/mm/protocal/protobuf/cyt:aaDB	Lcom/tencent/mm/bx/b;
    //   223: getstatic 66	com/tencent/mm/plugin/multitalk/model/j:LmP	[B
    //   226: invokevirtual 360	com/tencent/mm/bx/b:cY	([B)V
    //   229: aload_1
    //   230: getfield 344	com/tencent/mm/protocal/protobuf/cyt:aaDz	Lcom/tencent/mm/bx/b;
    //   233: getstatic 68	com/tencent/mm/plugin/multitalk/model/j:LmQ	[B
    //   236: invokevirtual 360	com/tencent/mm/bx/b:cY	([B)V
    //   239: aload_1
    //   240: getfield 352	com/tencent/mm/protocal/protobuf/cyt:aaDA	Lcom/tencent/mm/bx/b;
    //   243: getstatic 70	com/tencent/mm/plugin/multitalk/model/j:LmR	[B
    //   246: invokevirtual 360	com/tencent/mm/bx/b:cY	([B)V
    //   249: aload_0
    //   250: getstatic 66	com/tencent/mm/plugin/multitalk/model/j:LmP	[B
    //   253: arraylength
    //   254: getstatic 68	com/tencent/mm/plugin/multitalk/model/j:LmQ	[B
    //   257: arraylength
    //   258: iadd
    //   259: getstatic 70	com/tencent/mm/plugin/multitalk/model/j:LmR	[B
    //   262: arraylength
    //   263: iadd
    //   264: newarray byte
    //   266: putfield 89	com/tencent/mm/plugin/multitalk/model/j:configbyte	[B
    //   269: getstatic 66	com/tencent/mm/plugin/multitalk/model/j:LmP	[B
    //   272: iconst_0
    //   273: aload_0
    //   274: getfield 89	com/tencent/mm/plugin/multitalk/model/j:configbyte	[B
    //   277: iconst_0
    //   278: getstatic 66	com/tencent/mm/plugin/multitalk/model/j:LmP	[B
    //   281: arraylength
    //   282: invokestatic 356	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   285: getstatic 66	com/tencent/mm/plugin/multitalk/model/j:LmP	[B
    //   288: arraylength
    //   289: iconst_0
    //   290: iadd
    //   291: istore_2
    //   292: getstatic 68	com/tencent/mm/plugin/multitalk/model/j:LmQ	[B
    //   295: iconst_0
    //   296: aload_0
    //   297: getfield 89	com/tencent/mm/plugin/multitalk/model/j:configbyte	[B
    //   300: iload_2
    //   301: getstatic 68	com/tencent/mm/plugin/multitalk/model/j:LmQ	[B
    //   304: arraylength
    //   305: invokestatic 356	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   308: getstatic 68	com/tencent/mm/plugin/multitalk/model/j:LmQ	[B
    //   311: arraylength
    //   312: istore 6
    //   314: getstatic 70	com/tencent/mm/plugin/multitalk/model/j:LmR	[B
    //   317: iconst_0
    //   318: aload_0
    //   319: getfield 89	com/tencent/mm/plugin/multitalk/model/j:configbyte	[B
    //   322: iload_2
    //   323: iload 6
    //   325: iadd
    //   326: getstatic 70	com/tencent/mm/plugin/multitalk/model/j:LmR	[B
    //   329: arraylength
    //   330: invokestatic 356	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   333: aload_0
    //   334: iload 5
    //   336: putfield 113	com/tencent/mm/plugin/multitalk/model/j:Lne	I
    //   339: getstatic 68	com/tencent/mm/plugin/multitalk/model/j:LmQ	[B
    //   342: arraylength
    //   343: iconst_4
    //   344: isub
    //   345: newarray byte
    //   347: astore_1
    //   348: getstatic 68	com/tencent/mm/plugin/multitalk/model/j:LmQ	[B
    //   351: iconst_4
    //   352: aload_1
    //   353: iconst_0
    //   354: getstatic 68	com/tencent/mm/plugin/multitalk/model/j:LmQ	[B
    //   357: arraylength
    //   358: iconst_4
    //   359: isub
    //   360: invokestatic 356	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   363: aload_0
    //   364: aload_1
    //   365: invokespecial 362	com/tencent/mm/plugin/multitalk/model/j:cj	([B)Z
    //   368: pop
    //   369: iconst_1
    //   370: istore_2
    //   371: aload 12
    //   373: astore_1
    //   374: aload_1
    //   375: ifnull +21 -> 396
    //   378: aload_0
    //   379: getfield 87	com/tencent/mm/plugin/multitalk/model/j:LmN	Ljava/io/BufferedOutputStream;
    //   382: ifnull +14 -> 396
    //   385: aload_0
    //   386: getfield 87	com/tencent/mm/plugin/multitalk/model/j:LmN	Ljava/io/BufferedOutputStream;
    //   389: aload_1
    //   390: iconst_0
    //   391: aload_1
    //   392: arraylength
    //   393: invokevirtual 368	java/io/BufferedOutputStream:write	([BII)V
    //   396: iload_2
    //   397: ifeq +957 -> 1354
    //   400: getstatic 68	com/tencent/mm/plugin/multitalk/model/j:LmQ	[B
    //   403: ifnull +951 -> 1354
    //   406: getstatic 70	com/tencent/mm/plugin/multitalk/model/j:LmR	[B
    //   409: ifnull +945 -> 1354
    //   412: aload_0
    //   413: getfield 93	com/tencent/mm/plugin/multitalk/model/j:LmV	Z
    //   416: ifne +156 -> 572
    //   419: aload_0
    //   420: getfield 144	com/tencent/mm/plugin/multitalk/model/j:LmO	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   423: astore 12
    //   425: aload 12
    //   427: ifnull +22 -> 449
    //   430: aload_0
    //   431: getfield 144	com/tencent/mm/plugin/multitalk/model/j:LmO	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   434: invokevirtual 373	com/tencent/mm/compatible/deviceinfo/aa:stop	()V
    //   437: aload_0
    //   438: getfield 144	com/tencent/mm/plugin/multitalk/model/j:LmO	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   441: invokevirtual 376	com/tencent/mm/compatible/deviceinfo/aa:release	()V
    //   444: aload_0
    //   445: aconst_null
    //   446: putfield 144	com/tencent/mm/plugin/multitalk/model/j:LmO	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   449: aload_0
    //   450: getfield 91	com/tencent/mm/plugin/multitalk/model/j:LmS	Z
    //   453: ifeq +929 -> 1382
    //   456: ldc_w 378
    //   459: getstatic 72	com/tencent/mm/plugin/multitalk/model/j:LmT	I
    //   462: getstatic 74	com/tencent/mm/plugin/multitalk/model/j:LmU	I
    //   465: invokestatic 384	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   468: astore 12
    //   470: aload 12
    //   472: ldc_w 386
    //   475: bipush 90
    //   477: invokevirtual 390	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   480: ldc 218
    //   482: ldc_w 392
    //   485: aload 12
    //   487: invokestatic 169	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   490: invokevirtual 173	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   493: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   496: aload 12
    //   498: ldc_w 394
    //   501: invokevirtual 397	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   504: astore 13
    //   506: aload 13
    //   508: ldc_w 399
    //   511: invokevirtual 403	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   514: ifeq +58 -> 572
    //   517: aload_0
    //   518: aload 13
    //   520: invokestatic 407	com/tencent/mm/compatible/deviceinfo/aa:Dw	(Ljava/lang/String;)Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   523: putfield 144	com/tencent/mm/plugin/multitalk/model/j:LmO	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   526: ldc 218
    //   528: ldc_w 409
    //   531: aload 12
    //   533: invokestatic 169	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   536: invokevirtual 173	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   539: invokestatic 322	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   542: aload_0
    //   543: getfield 144	com/tencent/mm/plugin/multitalk/model/j:LmO	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   546: aload 12
    //   548: aload_0
    //   549: getfield 146	com/tencent/mm/plugin/multitalk/model/j:surface	Landroid/view/Surface;
    //   552: iconst_0
    //   553: invokevirtual 413	com/tencent/mm/compatible/deviceinfo/aa:a	(Landroid/media/MediaFormat;Landroid/view/Surface;I)V
    //   556: aload_0
    //   557: getfield 144	com/tencent/mm/plugin/multitalk/model/j:LmO	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   560: invokevirtual 416	com/tencent/mm/compatible/deviceinfo/aa:start	()V
    //   563: aload_0
    //   564: iconst_1
    //   565: putfield 93	com/tencent/mm/plugin/multitalk/model/j:LmV	Z
    //   568: aload_0
    //   569: invokevirtual 417	com/tencent/mm/plugin/multitalk/model/j:start	()V
    //   572: ldc_w 315
    //   575: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   578: iconst_1
    //   579: ireturn
    //   580: aload_1
    //   581: getfield 341	com/tencent/mm/protocal/protobuf/cyt:aaDB	Lcom/tencent/mm/bx/b;
    //   584: getfield 349	com/tencent/mm/bx/b:Op	[B
    //   587: arraylength
    //   588: istore_2
    //   589: goto -476 -> 113
    //   592: aload_0
    //   593: getfield 91	com/tencent/mm/plugin/multitalk/model/j:LmS	Z
    //   596: ifeq +8 -> 604
    //   599: aload_0
    //   600: iconst_0
    //   601: putfield 93	com/tencent/mm/plugin/multitalk/model/j:LmV	Z
    //   604: aload_0
    //   605: iconst_0
    //   606: putfield 91	com/tencent/mm/plugin/multitalk/model/j:LmS	Z
    //   609: iload 5
    //   611: iconst_4
    //   612: iadd
    //   613: newarray byte
    //   615: astore 13
    //   617: aload_0
    //   618: getfield 105	com/tencent/mm/plugin/multitalk/model/j:Lna	[B
    //   621: iconst_0
    //   622: aload 13
    //   624: iconst_0
    //   625: iconst_4
    //   626: invokestatic 356	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   629: aload_1
    //   630: getfield 344	com/tencent/mm/protocal/protobuf/cyt:aaDz	Lcom/tencent/mm/bx/b;
    //   633: aload 13
    //   635: invokevirtual 360	com/tencent/mm/bx/b:cY	([B)V
    //   638: ldc 218
    //   640: ldc_w 419
    //   643: aload 13
    //   645: invokestatic 169	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   648: invokevirtual 173	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   651: invokestatic 322	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   654: aload 13
    //   656: invokestatic 421	com/tencent/mm/plugin/multitalk/model/j:cg	([B)Ljava/lang/String;
    //   659: astore 14
    //   661: iconst_3
    //   662: newarray byte
    //   664: dup
    //   665: iconst_0
    //   666: ldc 102
    //   668: bastore
    //   669: dup
    //   670: iconst_1
    //   671: ldc 102
    //   673: bastore
    //   674: dup
    //   675: iconst_2
    //   676: ldc_w 422
    //   679: bastore
    //   680: invokestatic 421	com/tencent/mm/plugin/multitalk/model/j:cg	([B)Ljava/lang/String;
    //   683: astore 15
    //   685: ldc 218
    //   687: new 175	java/lang/StringBuilder
    //   690: dup
    //   691: ldc_w 424
    //   694: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   697: aload 14
    //   699: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: ldc_w 426
    //   705: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: aload 15
    //   710: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   716: invokestatic 322	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   719: aload 14
    //   721: aload 15
    //   723: iconst_0
    //   724: invokevirtual 430	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   727: istore_2
    //   728: iload_2
    //   729: iconst_m1
    //   730: if_icmpeq +206 -> 936
    //   733: ldc 218
    //   735: ldc_w 432
    //   738: iload_2
    //   739: invokestatic 434	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   742: invokevirtual 173	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   745: invokestatic 322	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   748: iconst_1
    //   749: istore_2
    //   750: iload_2
    //   751: ifeq +190 -> 941
    //   754: ldc 218
    //   756: ldc_w 436
    //   759: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   762: aload 13
    //   764: putstatic 68	com/tencent/mm/plugin/multitalk/model/j:LmQ	[B
    //   767: ldc 218
    //   769: new 175	java/lang/StringBuilder
    //   772: dup
    //   773: ldc_w 438
    //   776: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   779: getstatic 68	com/tencent/mm/plugin/multitalk/model/j:LmQ	[B
    //   782: arraylength
    //   783: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   786: ldc_w 440
    //   789: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: iload 5
    //   794: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   797: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   800: invokestatic 322	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   803: iload 6
    //   805: iconst_4
    //   806: iadd
    //   807: newarray byte
    //   809: putstatic 70	com/tencent/mm/plugin/multitalk/model/j:LmR	[B
    //   812: aload_0
    //   813: getfield 105	com/tencent/mm/plugin/multitalk/model/j:Lna	[B
    //   816: iconst_0
    //   817: getstatic 70	com/tencent/mm/plugin/multitalk/model/j:LmR	[B
    //   820: iconst_0
    //   821: iconst_4
    //   822: invokestatic 356	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   825: aload_1
    //   826: getfield 352	com/tencent/mm/protocal/protobuf/cyt:aaDA	Lcom/tencent/mm/bx/b;
    //   829: getstatic 70	com/tencent/mm/plugin/multitalk/model/j:LmR	[B
    //   832: invokevirtual 360	com/tencent/mm/bx/b:cY	([B)V
    //   835: aload_0
    //   836: getstatic 68	com/tencent/mm/plugin/multitalk/model/j:LmQ	[B
    //   839: arraylength
    //   840: getstatic 70	com/tencent/mm/plugin/multitalk/model/j:LmR	[B
    //   843: arraylength
    //   844: iadd
    //   845: newarray byte
    //   847: putfield 89	com/tencent/mm/plugin/multitalk/model/j:configbyte	[B
    //   850: getstatic 68	com/tencent/mm/plugin/multitalk/model/j:LmQ	[B
    //   853: iconst_0
    //   854: aload_0
    //   855: getfield 89	com/tencent/mm/plugin/multitalk/model/j:configbyte	[B
    //   858: iconst_0
    //   859: getstatic 68	com/tencent/mm/plugin/multitalk/model/j:LmQ	[B
    //   862: arraylength
    //   863: invokestatic 356	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   866: getstatic 68	com/tencent/mm/plugin/multitalk/model/j:LmQ	[B
    //   869: arraylength
    //   870: istore_2
    //   871: getstatic 70	com/tencent/mm/plugin/multitalk/model/j:LmR	[B
    //   874: iconst_0
    //   875: aload_0
    //   876: getfield 89	com/tencent/mm/plugin/multitalk/model/j:configbyte	[B
    //   879: iload_2
    //   880: iconst_0
    //   881: iadd
    //   882: getstatic 70	com/tencent/mm/plugin/multitalk/model/j:LmR	[B
    //   885: arraylength
    //   886: invokestatic 356	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   889: goto -556 -> 333
    //   892: astore_1
    //   893: aload_0
    //   894: aload_0
    //   895: getfield 111	com/tencent/mm/plugin/multitalk/model/j:Lnd	I
    //   898: iconst_2
    //   899: ior
    //   900: putfield 111	com/tencent/mm/plugin/multitalk/model/j:Lnd	I
    //   903: ldc 218
    //   905: new 175	java/lang/StringBuilder
    //   908: dup
    //   909: ldc_w 442
    //   912: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   915: aload_1
    //   916: invokevirtual 443	java/lang/Exception:toString	()Ljava/lang/String;
    //   919: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   925: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   928: iconst_0
    //   929: istore_2
    //   930: aload 12
    //   932: astore_1
    //   933: goto -559 -> 374
    //   936: iconst_0
    //   937: istore_2
    //   938: goto -188 -> 750
    //   941: new 448	com/tencent/mm/plugin/voip/model/g
    //   944: dup
    //   945: invokespecial 449	com/tencent/mm/plugin/voip/model/g:<init>	()V
    //   948: aload 13
    //   950: invokevirtual 453	com/tencent/mm/plugin/voip/model/g:cz	([B)[B
    //   953: putstatic 68	com/tencent/mm/plugin/multitalk/model/j:LmQ	[B
    //   956: goto -189 -> 767
    //   959: new 455	com/tencent/mm/protocal/protobuf/cys
    //   962: dup
    //   963: invokespecial 456	com/tencent/mm/protocal/protobuf/cys:<init>	()V
    //   966: aload_1
    //   967: invokevirtual 457	com/tencent/mm/protocal/protobuf/cys:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   970: checkcast 455	com/tencent/mm/protocal/protobuf/cys
    //   973: astore 13
    //   975: aload 13
    //   977: getfield 461	com/tencent/mm/protocal/protobuf/cys:aaDx	Ljava/util/LinkedList;
    //   980: invokevirtual 467	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   983: checkcast 153	java/lang/Integer
    //   986: invokevirtual 470	java/lang/Integer:intValue	()I
    //   989: istore 7
    //   991: iconst_0
    //   992: istore 5
    //   994: ldc 218
    //   996: ldc_w 472
    //   999: iload 7
    //   1001: invokestatic 434	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1004: invokevirtual 173	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1007: invokestatic 322	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1010: iload_2
    //   1011: iconst_1
    //   1012: if_icmpne +185 -> 1197
    //   1015: aload_0
    //   1016: getfield 89	com/tencent/mm/plugin/multitalk/model/j:configbyte	[B
    //   1019: arraylength
    //   1020: istore 5
    //   1022: iload 7
    //   1024: iload 5
    //   1026: iadd
    //   1027: istore 6
    //   1029: iload 6
    //   1031: newarray byte
    //   1033: astore_1
    //   1034: aload_0
    //   1035: getfield 89	com/tencent/mm/plugin/multitalk/model/j:configbyte	[B
    //   1038: iconst_0
    //   1039: aload_1
    //   1040: iconst_0
    //   1041: iload 5
    //   1043: invokestatic 356	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1046: iload 5
    //   1048: iconst_0
    //   1049: iadd
    //   1050: istore 5
    //   1052: goto +870 -> 1922
    //   1055: iconst_4
    //   1056: invokestatic 264	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1059: astore 14
    //   1061: aload 13
    //   1063: getfield 475	com/tencent/mm/protocal/protobuf/cys:aaDu	Lcom/tencent/mm/bx/b;
    //   1066: aload 14
    //   1068: invokevirtual 294	java/nio/ByteBuffer:array	()[B
    //   1071: iload 7
    //   1073: iconst_0
    //   1074: iconst_4
    //   1075: invokevirtual 479	com/tencent/mm/bx/b:b	([BIII)V
    //   1078: aload 14
    //   1080: getstatic 482	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   1083: invokevirtual 274	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1086: pop
    //   1087: aload 14
    //   1089: iconst_0
    //   1090: invokevirtual 486	java/nio/ByteBuffer:getInt	(I)I
    //   1093: istore 9
    //   1095: aload_0
    //   1096: getfield 105	com/tencent/mm/plugin/multitalk/model/j:Lna	[B
    //   1099: iconst_0
    //   1100: aload_1
    //   1101: iload 7
    //   1103: iload 5
    //   1105: iadd
    //   1106: iconst_4
    //   1107: invokestatic 356	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1110: iload 7
    //   1112: iconst_4
    //   1113: iadd
    //   1114: istore 7
    //   1116: aload 13
    //   1118: getfield 475	com/tencent/mm/protocal/protobuf/cys:aaDu	Lcom/tencent/mm/bx/b;
    //   1121: aload_1
    //   1122: iload 7
    //   1124: iload 7
    //   1126: iload 5
    //   1128: iadd
    //   1129: iload 9
    //   1131: invokevirtual 479	com/tencent/mm/bx/b:b	([BIII)V
    //   1134: iload 8
    //   1136: iload 9
    //   1138: iconst_4
    //   1139: iadd
    //   1140: isub
    //   1141: istore 8
    //   1143: ldc 218
    //   1145: new 175	java/lang/StringBuilder
    //   1148: dup
    //   1149: ldc_w 488
    //   1152: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1155: iload 9
    //   1157: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1160: ldc_w 490
    //   1163: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1166: iload 6
    //   1168: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1171: ldc_w 492
    //   1174: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: iload_2
    //   1178: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1181: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1184: invokestatic 322	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1187: iload 8
    //   1189: ifgt +723 -> 1912
    //   1192: iconst_0
    //   1193: istore_2
    //   1194: goto -820 -> 374
    //   1197: iload 7
    //   1199: newarray byte
    //   1201: astore_1
    //   1202: iload 7
    //   1204: istore 6
    //   1206: goto +716 -> 1922
    //   1209: astore_1
    //   1210: aload_0
    //   1211: aload_0
    //   1212: getfield 111	com/tencent/mm/plugin/multitalk/model/j:Lnd	I
    //   1215: iconst_4
    //   1216: ior
    //   1217: putfield 111	com/tencent/mm/plugin/multitalk/model/j:Lnd	I
    //   1220: ldc 218
    //   1222: new 175	java/lang/StringBuilder
    //   1225: dup
    //   1226: ldc_w 494
    //   1229: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1232: aload_1
    //   1233: invokevirtual 443	java/lang/Exception:toString	()Ljava/lang/String;
    //   1236: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1242: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1245: iconst_0
    //   1246: istore_2
    //   1247: aload 12
    //   1249: astore_1
    //   1250: goto -876 -> 374
    //   1253: astore 12
    //   1255: ldc 218
    //   1257: new 175	java/lang/StringBuilder
    //   1260: dup
    //   1261: ldc_w 496
    //   1264: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1267: aload 12
    //   1269: invokevirtual 497	java/io/IOException:toString	()Ljava/lang/String;
    //   1272: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1275: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1278: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1281: goto -885 -> 396
    //   1284: astore 12
    //   1286: ldc 218
    //   1288: new 175	java/lang/StringBuilder
    //   1291: dup
    //   1292: ldc_w 499
    //   1295: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1298: aload 12
    //   1300: invokevirtual 443	java/lang/Exception:toString	()Ljava/lang/String;
    //   1303: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1309: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1312: goto -863 -> 449
    //   1315: astore 12
    //   1317: aload_0
    //   1318: aload_0
    //   1319: getfield 111	com/tencent/mm/plugin/multitalk/model/j:Lnd	I
    //   1322: bipush 16
    //   1324: ior
    //   1325: putfield 111	com/tencent/mm/plugin/multitalk/model/j:Lnd	I
    //   1328: ldc 218
    //   1330: new 175	java/lang/StringBuilder
    //   1333: dup
    //   1334: ldc_w 496
    //   1337: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1340: aload 12
    //   1342: invokevirtual 443	java/lang/Exception:toString	()Ljava/lang/String;
    //   1345: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1351: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1354: aload_0
    //   1355: getfield 93	com/tencent/mm/plugin/multitalk/model/j:LmV	Z
    //   1358: ifne +106 -> 1464
    //   1361: ldc 218
    //   1363: ldc_w 501
    //   1366: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1369: aload_0
    //   1370: invokespecial 503	com/tencent/mm/plugin/multitalk/model/j:gff	()I
    //   1373: pop
    //   1374: ldc_w 315
    //   1377: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1380: iconst_m1
    //   1381: ireturn
    //   1382: ldc_w 505
    //   1385: getstatic 72	com/tencent/mm/plugin/multitalk/model/j:LmT	I
    //   1388: getstatic 74	com/tencent/mm/plugin/multitalk/model/j:LmU	I
    //   1391: invokestatic 384	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   1394: astore 12
    //   1396: goto -926 -> 470
    //   1399: astore 12
    //   1401: aload_0
    //   1402: aload_0
    //   1403: getfield 111	com/tencent/mm/plugin/multitalk/model/j:Lnd	I
    //   1406: bipush 8
    //   1408: ior
    //   1409: putfield 111	com/tencent/mm/plugin/multitalk/model/j:Lnd	I
    //   1412: ldc 218
    //   1414: new 175	java/lang/StringBuilder
    //   1417: dup
    //   1418: ldc_w 507
    //   1421: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1424: aload 13
    //   1426: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1429: ldc_w 509
    //   1432: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1435: aload 12
    //   1437: invokevirtual 512	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1440: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1443: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1446: aload_0
    //   1447: iconst_0
    //   1448: putfield 95	com/tencent/mm/plugin/multitalk/model/j:LmW	Z
    //   1451: aload_0
    //   1452: invokespecial 503	com/tencent/mm/plugin/multitalk/model/j:gff	()I
    //   1455: pop
    //   1456: ldc_w 315
    //   1459: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1462: iconst_m1
    //   1463: ireturn
    //   1464: aload_1
    //   1465: ifnonnull +19 -> 1484
    //   1468: ldc 218
    //   1470: ldc_w 514
    //   1473: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1476: ldc_w 315
    //   1479: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1482: iconst_m1
    //   1483: ireturn
    //   1484: aload_0
    //   1485: getfield 97	com/tencent/mm/plugin/multitalk/model/j:LmX	Z
    //   1488: ifne +8 -> 1496
    //   1491: aload_0
    //   1492: iconst_1
    //   1493: putfield 97	com/tencent/mm/plugin/multitalk/model/j:LmX	Z
    //   1496: aload_1
    //   1497: arraylength
    //   1498: istore_2
    //   1499: aload_1
    //   1500: iconst_4
    //   1501: baload
    //   1502: bipush 31
    //   1504: iand
    //   1505: istore 5
    //   1507: iload 5
    //   1509: bipush 7
    //   1511: if_icmpeq +10 -> 1521
    //   1514: iload 5
    //   1516: bipush 8
    //   1518: if_icmpne +95 -> 1613
    //   1521: bipush 83
    //   1523: istore 4
    //   1525: ldc 218
    //   1527: new 175	java/lang/StringBuilder
    //   1530: dup
    //   1531: ldc_w 516
    //   1534: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1537: iload_2
    //   1538: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1541: ldc_w 518
    //   1544: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1547: iload 5
    //   1549: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1552: ldc_w 520
    //   1555: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1558: iload 4
    //   1560: invokevirtual 523	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1563: ldc_w 525
    //   1566: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1569: aload_0
    //   1570: getfield 109	com/tencent/mm/plugin/multitalk/model/j:Lnc	I
    //   1573: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1576: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1579: invokestatic 322	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1582: aload_0
    //   1583: getfield 99	com/tencent/mm/plugin/multitalk/model/j:LmY	Z
    //   1586: ifeq +54 -> 1640
    //   1589: iload 4
    //   1591: bipush 80
    //   1593: if_icmpne +47 -> 1640
    //   1596: ldc 218
    //   1598: ldc_w 527
    //   1601: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1604: ldc_w 315
    //   1607: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1610: bipush 254
    //   1612: ireturn
    //   1613: iload 5
    //   1615: iconst_5
    //   1616: if_icmpeq +10 -> 1626
    //   1619: iload 5
    //   1621: bipush 6
    //   1623: if_icmpne +10 -> 1633
    //   1626: bipush 73
    //   1628: istore 4
    //   1630: goto -105 -> 1525
    //   1633: bipush 80
    //   1635: istore 4
    //   1637: goto -112 -> 1525
    //   1640: aload_0
    //   1641: getfield 144	com/tencent/mm/plugin/multitalk/model/j:LmO	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   1644: ldc2_w 528
    //   1647: invokevirtual 533	com/tencent/mm/compatible/deviceinfo/aa:dequeueInputBuffer	(J)I
    //   1650: istore 5
    //   1652: iload 5
    //   1654: iflt +212 -> 1866
    //   1657: aload_1
    //   1658: ifnull +186 -> 1844
    //   1661: iload_2
    //   1662: ifle +182 -> 1844
    //   1665: invokestatic 330	java/lang/System:currentTimeMillis	()J
    //   1668: lstore 10
    //   1670: ldc 218
    //   1672: new 175	java/lang/StringBuilder
    //   1675: dup
    //   1676: ldc_w 535
    //   1679: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1682: iload 5
    //   1684: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1687: ldc_w 537
    //   1690: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1693: iload_2
    //   1694: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1697: ldc_w 520
    //   1700: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1703: iload 4
    //   1705: invokevirtual 523	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1708: ldc_w 539
    //   1711: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1714: lload 10
    //   1716: invokevirtual 542	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1719: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1722: invokestatic 322	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1725: getstatic 547	android/os/Build$VERSION:SDK_INT	I
    //   1728: bipush 21
    //   1730: if_icmpge +122 -> 1852
    //   1733: aload_0
    //   1734: getfield 144	com/tencent/mm/plugin/multitalk/model/j:LmO	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   1737: invokevirtual 551	com/tencent/mm/compatible/deviceinfo/aa:aPD	()[Ljava/nio/ByteBuffer;
    //   1740: iload 5
    //   1742: aaload
    //   1743: astore 12
    //   1745: aload 12
    //   1747: invokevirtual 555	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1750: pop
    //   1751: aload 12
    //   1753: invokevirtual 555	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1756: pop
    //   1757: aload 12
    //   1759: aload_1
    //   1760: iconst_0
    //   1761: iload_2
    //   1762: invokevirtual 558	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1765: pop
    //   1766: aload_0
    //   1767: getfield 144	com/tencent/mm/plugin/multitalk/model/j:LmO	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   1770: iload 5
    //   1772: iload_2
    //   1773: lload 10
    //   1775: iconst_0
    //   1776: invokevirtual 561	com/tencent/mm/compatible/deviceinfo/aa:a	(IIJI)V
    //   1779: aload_0
    //   1780: aload_0
    //   1781: getfield 109	com/tencent/mm/plugin/multitalk/model/j:Lnc	I
    //   1784: iconst_1
    //   1785: iadd
    //   1786: putfield 109	com/tencent/mm/plugin/multitalk/model/j:Lnc	I
    //   1789: aload_0
    //   1790: iconst_0
    //   1791: putfield 101	com/tencent/mm/plugin/multitalk/model/j:LmZ	I
    //   1794: aload_0
    //   1795: getfield 99	com/tencent/mm/plugin/multitalk/model/j:LmY	Z
    //   1798: ifeq +46 -> 1844
    //   1801: iconst_1
    //   1802: invokestatic 264	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1805: astore_1
    //   1806: aload_1
    //   1807: getstatic 270	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   1810: invokevirtual 274	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1813: pop
    //   1814: aload_1
    //   1815: iconst_0
    //   1816: invokevirtual 309	java/nio/ByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   1819: pop
    //   1820: invokestatic 284	com/tencent/mm/plugin/multitalk/model/ac:ggR	()Lcom/tencent/mm/plugin/multitalk/model/n;
    //   1823: getfield 290	com/tencent/mm/plugin/multitalk/model/n:LnJ	Lcom/tencent/pb/talkroom/sdk/d;
    //   1826: bipush 28
    //   1828: aload_1
    //   1829: invokevirtual 294	java/nio/ByteBuffer:array	()[B
    //   1832: iconst_1
    //   1833: invokeinterface 300 4 0
    //   1838: pop
    //   1839: aload_0
    //   1840: iconst_0
    //   1841: putfield 99	com/tencent/mm/plugin/multitalk/model/j:LmY	Z
    //   1844: ldc_w 315
    //   1847: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1850: iconst_0
    //   1851: ireturn
    //   1852: aload_0
    //   1853: getfield 144	com/tencent/mm/plugin/multitalk/model/j:LmO	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   1856: iload 5
    //   1858: invokevirtual 564	com/tencent/mm/compatible/deviceinfo/aa:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   1861: astore 12
    //   1863: goto -112 -> 1751
    //   1866: aload_0
    //   1867: getfield 99	com/tencent/mm/plugin/multitalk/model/j:LmY	Z
    //   1870: ifeq +26 -> 1896
    //   1873: iload 4
    //   1875: bipush 80
    //   1877: if_icmpeq +19 -> 1896
    //   1880: aload_0
    //   1881: iconst_0
    //   1882: putfield 95	com/tencent/mm/plugin/multitalk/model/j:LmW	Z
    //   1885: aload_0
    //   1886: aload_0
    //   1887: getfield 111	com/tencent/mm/plugin/multitalk/model/j:Lnd	I
    //   1890: bipush 32
    //   1892: ior
    //   1893: putfield 111	com/tencent/mm/plugin/multitalk/model/j:Lnd	I
    //   1896: aload_0
    //   1897: invokespecial 503	com/tencent/mm/plugin/multitalk/model/j:gff	()I
    //   1900: pop
    //   1901: ldc 218
    //   1903: ldc_w 566
    //   1906: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1909: goto -65 -> 1844
    //   1912: iload 7
    //   1914: iload 9
    //   1916: iadd
    //   1917: istore 7
    //   1919: goto -864 -> 1055
    //   1922: iconst_0
    //   1923: istore 9
    //   1925: iload 7
    //   1927: istore 8
    //   1929: iload 9
    //   1931: istore 7
    //   1933: goto -878 -> 1055
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1936	0	this	j
    //   0	1936	1	paramArrayOfByte	byte[]
    //   0	1936	2	paramInt	int
    //   0	1936	3	paramBoolean	boolean
    //   1523	355	4	c	char
    //   121	1736	5	i	int
    //   131	1074	6	j	int
    //   989	943	7	k	int
    //   1134	794	8	m	int
    //   1093	837	9	n	int
    //   1668	106	10	l	long
    //   82	1166	12	localObject1	Object
    //   1253	15	12	localIOException	IOException
    //   1284	15	12	localException1	Exception
    //   1315	26	12	localException2	Exception
    //   1394	1	12	localMediaFormat	MediaFormat
    //   1399	37	12	localException3	Exception
    //   1743	119	12	localByteBuffer	ByteBuffer
    //   504	921	13	localObject2	Object
    //   659	429	14	localObject3	Object
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
    //   941	956	892	java/lang/Exception
    //   959	991	1209	java/lang/Exception
    //   994	1010	1209	java/lang/Exception
    //   1015	1022	1209	java/lang/Exception
    //   1029	1046	1209	java/lang/Exception
    //   1055	1110	1209	java/lang/Exception
    //   1116	1134	1209	java/lang/Exception
    //   1143	1187	1209	java/lang/Exception
    //   1197	1202	1209	java/lang/Exception
    //   385	396	1253	java/io/IOException
    //   430	449	1284	java/lang/Exception
    //   400	425	1315	java/lang/Exception
    //   449	470	1315	java/lang/Exception
    //   470	526	1315	java/lang/Exception
    //   556	572	1315	java/lang/Exception
    //   1286	1312	1315	java/lang/Exception
    //   1382	1396	1315	java/lang/Exception
    //   1401	1456	1315	java/lang/Exception
    //   526	556	1399	java/lang/Exception
  }
  
  public final void gfg()
  {
    AppMethodBeat.i(284913);
    this.LmW = false;
    this.LmX = false;
    this.LmZ = 0;
    Log.d("MeidaCodec[HWDec]", "steve: Stop Decode Thread!");
    try
    {
      if (this.outputStream != null)
      {
        this.outputStream.flush();
        this.outputStream.close();
      }
      if (this.LmN != null)
      {
        this.LmN.flush();
        this.LmN.close();
      }
      AppMethodBeat.o(284913);
      return;
    }
    catch (IOException localIOException)
    {
      Log.e("MeidaCodec[HWDec]", " error:" + localIOException.toString());
      AppMethodBeat.o(284913);
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(284904);
    if ((!Thread.interrupted()) && (this.LmW)) {
      if ((this.LmO == null) || (!this.LmV) || (!this.LmX)) {}
    }
    for (;;)
    {
      for (;;)
      {
        int i;
        try
        {
          MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
          i = this.LmO.dequeueOutputBuffer(localBufferInfo, 10000L);
          Log.d("MeidaCodec[HWDec]", "steve:  outIndex=".concat(String.valueOf(i)));
          switch (i)
          {
          case -3: 
            if (localBufferInfo.size <= 0) {
              break label386;
            }
            long l1 = localBufferInfo.presentationTimeUs;
            long l2 = System.currentTimeMillis();
            Log.d("MeidaCodec[HWDec]", "DECODER_THREAD:: decoded SUCCESSFULLY!!! cnt : " + this.Lnb + ", size:" + localBufferInfo.size + ", pts:" + localBufferInfo.presentationTimeUs + ", latency:" + (l2 - l1));
            this.Lnb += 1;
            this.LmO.releaseOutputBuffer(i, true);
            l2 = System.currentTimeMillis();
            Log.d("MeidaCodec[HWDec]", "steve: Avcdecoder frame processTime = " + (l2 - l1) + ", decFrameCnt=" + this.Lnb + ", endTime=" + l2);
          }
        }
        catch (Exception localException1)
        {
          this.LmW = false;
          this.Lnd |= 0x80;
          gff();
          Log.e("MeidaCodec[HWDec]", " dequeueOutputBuffer/releaseOutputBuffer error:" + localException1.toString());
        }
        break;
        Log.d("MeidaCodec[HWDec]", "INFO_OUTPUT_BUFFERS_CHANGED");
        break;
        MediaFormat localMediaFormat = this.LmO.getOutputFormat();
        Log.i("MeidaCodec[HWDec]", "DECODER_THREAD:: New format : ".concat(String.valueOf(localMediaFormat)));
        localMediaFormat.getInteger("width");
        localMediaFormat.getInteger("height");
        break;
        Log.d("MeidaCodec[HWDec]", "DECODER_THREAD:: dequeueOutputBuffer timed out!");
        break;
        label386:
        Log.d("MeidaCodec[HWDec]", "steve: drop frame: " + this.Lnb + ", size:" + localMediaFormat.size + ", pts:" + localMediaFormat.presentationTimeUs);
        this.LmO.releaseOutputBuffer(i, false);
        break;
        try
        {
          Thread.sleep(20L);
        }
        catch (InterruptedException localInterruptedException)
        {
          Log.e("MeidaCodec[HWDec]", " error:" + localInterruptedException.toString());
        }
      }
      break;
      if ((!this.LmW) && (this.LmO != null)) {
        try
        {
          this.LmO.stop();
          this.LmO.release();
          this.LmO = null;
          AppMethodBeat.o(284904);
          return;
        }
        catch (Exception localException2)
        {
          Log.e("MeidaCodec[HWDec]", " decoder stop  error:" + localException2.toString());
        }
      }
      AppMethodBeat.o(284904);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.j
 * JD-Core Version:    0.7.0.1
 */