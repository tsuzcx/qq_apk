package com.tencent.mm.plugin.voip.model;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Environment;
import android.view.Surface;
import com.tencent.mm.sdk.platformtools.y;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class c
  extends Thread
{
  public static int pNY = 64;
  private static String pNZ = Environment.getExternalStorageDirectory().getAbsolutePath() + "/AVLog/dec264.h264";
  public static byte[] pOc = null;
  public static byte[] pOd = null;
  public static byte[] pOe = null;
  public static int pOh = 640;
  public static int pOi = 480;
  private Surface avf;
  private MediaCodec mDecoder = null;
  j pNq = null;
  private BufferedOutputStream pOa = null;
  private BufferedOutputStream pOb = null;
  public byte[] pOf = null;
  private boolean pOg = false;
  private boolean pOj = false;
  public boolean pOk = true;
  public boolean pOl = true;
  public boolean pOm = false;
  public int pOn = 0;
  public byte[] pOo = { 0, 0, 0, 1 };
  public int pOp = 0;
  public int pOq = 0;
  public int pOr = 0;
  public byte[] pOs = { 103, 100, 0, 13, -84, -74, 10, 15, -120 };
  public byte[] pOt = { 0, 0, 0, 1, 40, -50, 60, 48 };
  public byte[] pOu = { 13, 0, -15, 98, -22 };
  
  public c(Surface paramSurface)
  {
    if (paramSurface != null) {
      this.avf = paramSurface;
    }
  }
  
  private static String aO(byte[] paramArrayOfByte)
  {
    String str1 = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str3 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      String str2 = str3;
      if (str3.length() == 1) {
        str2 = "0" + str3;
      }
      str1 = str1 + str2;
      i += 1;
    }
    return str1;
  }
  
  private static boolean aP(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    paramArrayOfByte = aO(paramArrayOfByte);
    String str = aO(new byte[] { 0, 0, 3 });
    y.d("MeidaCodec[HWDec]", "parent: " + paramArrayOfByte + ", child:" + str);
    int i = paramArrayOfByte.indexOf(str, 0);
    if (i != -1)
    {
      y.d("MeidaCodec[HWDec]", "hack code detected!!pos: " + i);
      bool = true;
    }
    return bool;
  }
  
  private int bPI()
  {
    this.pOn += 1;
    y.d("MeidaCodec[HWDec]", "[HW]:DecFrmError: I Req mIReqFlag = " + this.pOm + ", mIsHWDecEnable = " + this.pOk + ", mHWErrorDecFrmCount = " + this.pOn);
    if ((!this.pOk) || (this.pOn > pNY))
    {
      bPJ();
      this.pNq.bQb();
      this.pOr |= 0x40;
      y.d("MeidaCodec[HWDec]", "[HW]:VTDecompressionSessionDecodeFrame: ErrFrm > threshold, end HWDec!!");
      return 0;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(1);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.put((byte)1);
    this.pNq.pQe.setAppCmd(28, localByteBuffer.array(), 1);
    this.pOm = true;
    return 1;
  }
  
  /* Error */
  public final int R(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 95	com/tencent/mm/plugin/voip/model/c:pOk	Z
    //   4: ifne +22 -> 26
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 113	com/tencent/mm/plugin/voip/model/c:pOr	I
    //   12: iconst_1
    //   13: ior
    //   14: putfield 113	com/tencent/mm/plugin/voip/model/c:pOr	I
    //   17: ldc 247
    //   19: ldc 249
    //   21: invokestatic 176	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: iconst_m1
    //   25: ireturn
    //   26: invokestatic 255	java/lang/System:currentTimeMillis	()J
    //   29: pop2
    //   30: iload_2
    //   31: iconst_2
    //   32: if_icmpne +762 -> 794
    //   35: new 257	com/tencent/mm/protocal/c/aon
    //   38: dup
    //   39: invokespecial 258	com/tencent/mm/protocal/c/aon:<init>	()V
    //   42: aload_1
    //   43: invokevirtual 262	com/tencent/mm/protocal/c/aon:aH	([B)Lcom/tencent/mm/bv/a;
    //   46: checkcast 257	com/tencent/mm/protocal/c/aon
    //   49: astore_1
    //   50: aload_1
    //   51: getfield 266	com/tencent/mm/protocal/c/aon:tkk	Lcom/tencent/mm/bv/b;
    //   54: ifnonnull +444 -> 498
    //   57: iconst_0
    //   58: istore_2
    //   59: aload_1
    //   60: getfield 269	com/tencent/mm/protocal/c/aon:tki	Lcom/tencent/mm/bv/b;
    //   63: getfield 274	com/tencent/mm/bv/b:oY	[B
    //   66: arraylength
    //   67: istore 4
    //   69: aload_1
    //   70: getfield 277	com/tencent/mm/protocal/c/aon:tkj	Lcom/tencent/mm/bv/b;
    //   73: getfield 274	com/tencent/mm/bv/b:oY	[B
    //   76: arraylength
    //   77: istore 5
    //   79: iload_2
    //   80: ifeq +430 -> 510
    //   83: aload_0
    //   84: getfield 91	com/tencent/mm/plugin/voip/model/c:pOg	Z
    //   87: ifne +8 -> 95
    //   90: aload_0
    //   91: iconst_0
    //   92: putfield 93	com/tencent/mm/plugin/voip/model/c:pOj	Z
    //   95: aload_0
    //   96: iconst_1
    //   97: putfield 91	com/tencent/mm/plugin/voip/model/c:pOg	Z
    //   100: iload_2
    //   101: iconst_4
    //   102: iadd
    //   103: newarray byte
    //   105: putstatic 72	com/tencent/mm/plugin/voip/model/c:pOc	[B
    //   108: iload 4
    //   110: iconst_4
    //   111: iadd
    //   112: newarray byte
    //   114: putstatic 74	com/tencent/mm/plugin/voip/model/c:pOd	[B
    //   117: iload 5
    //   119: iconst_4
    //   120: iadd
    //   121: newarray byte
    //   123: putstatic 76	com/tencent/mm/plugin/voip/model/c:pOe	[B
    //   126: aload_0
    //   127: getfield 107	com/tencent/mm/plugin/voip/model/c:pOo	[B
    //   130: iconst_0
    //   131: getstatic 72	com/tencent/mm/plugin/voip/model/c:pOc	[B
    //   134: iconst_0
    //   135: iconst_4
    //   136: invokestatic 281	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   139: aload_0
    //   140: getfield 107	com/tencent/mm/plugin/voip/model/c:pOo	[B
    //   143: iconst_0
    //   144: getstatic 74	com/tencent/mm/plugin/voip/model/c:pOd	[B
    //   147: iconst_0
    //   148: iconst_4
    //   149: invokestatic 281	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   152: aload_0
    //   153: getfield 107	com/tencent/mm/plugin/voip/model/c:pOo	[B
    //   156: iconst_0
    //   157: getstatic 76	com/tencent/mm/plugin/voip/model/c:pOe	[B
    //   160: iconst_0
    //   161: iconst_4
    //   162: invokestatic 281	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   165: aload_1
    //   166: getfield 266	com/tencent/mm/protocal/c/aon:tkk	Lcom/tencent/mm/bv/b;
    //   169: getstatic 72	com/tencent/mm/plugin/voip/model/c:pOc	[B
    //   172: invokevirtual 285	com/tencent/mm/bv/b:bl	([B)V
    //   175: aload_1
    //   176: getfield 269	com/tencent/mm/protocal/c/aon:tki	Lcom/tencent/mm/bv/b;
    //   179: getstatic 74	com/tencent/mm/plugin/voip/model/c:pOd	[B
    //   182: invokevirtual 285	com/tencent/mm/bv/b:bl	([B)V
    //   185: aload_1
    //   186: getfield 277	com/tencent/mm/protocal/c/aon:tkj	Lcom/tencent/mm/bv/b;
    //   189: getstatic 76	com/tencent/mm/plugin/voip/model/c:pOe	[B
    //   192: invokevirtual 285	com/tencent/mm/bv/b:bl	([B)V
    //   195: aload_0
    //   196: getstatic 72	com/tencent/mm/plugin/voip/model/c:pOc	[B
    //   199: arraylength
    //   200: getstatic 74	com/tencent/mm/plugin/voip/model/c:pOd	[B
    //   203: arraylength
    //   204: iadd
    //   205: getstatic 76	com/tencent/mm/plugin/voip/model/c:pOe	[B
    //   208: arraylength
    //   209: iadd
    //   210: newarray byte
    //   212: putfield 89	com/tencent/mm/plugin/voip/model/c:pOf	[B
    //   215: getstatic 72	com/tencent/mm/plugin/voip/model/c:pOc	[B
    //   218: iconst_0
    //   219: aload_0
    //   220: getfield 89	com/tencent/mm/plugin/voip/model/c:pOf	[B
    //   223: iconst_0
    //   224: getstatic 72	com/tencent/mm/plugin/voip/model/c:pOc	[B
    //   227: arraylength
    //   228: invokestatic 281	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   231: getstatic 72	com/tencent/mm/plugin/voip/model/c:pOc	[B
    //   234: arraylength
    //   235: iconst_0
    //   236: iadd
    //   237: istore_2
    //   238: getstatic 74	com/tencent/mm/plugin/voip/model/c:pOd	[B
    //   241: iconst_0
    //   242: aload_0
    //   243: getfield 89	com/tencent/mm/plugin/voip/model/c:pOf	[B
    //   246: iload_2
    //   247: getstatic 74	com/tencent/mm/plugin/voip/model/c:pOd	[B
    //   250: arraylength
    //   251: invokestatic 281	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   254: getstatic 74	com/tencent/mm/plugin/voip/model/c:pOd	[B
    //   257: arraylength
    //   258: istore 4
    //   260: getstatic 76	com/tencent/mm/plugin/voip/model/c:pOe	[B
    //   263: iconst_0
    //   264: aload_0
    //   265: getfield 89	com/tencent/mm/plugin/voip/model/c:pOf	[B
    //   268: iload_2
    //   269: iload 4
    //   271: iadd
    //   272: getstatic 76	com/tencent/mm/plugin/voip/model/c:pOe	[B
    //   275: arraylength
    //   276: invokestatic 281	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   279: aconst_null
    //   280: astore_1
    //   281: iconst_1
    //   282: istore_2
    //   283: aload_1
    //   284: ifnull +21 -> 305
    //   287: aload_0
    //   288: getfield 87	com/tencent/mm/plugin/voip/model/c:pOb	Ljava/io/BufferedOutputStream;
    //   291: ifnull +14 -> 305
    //   294: aload_0
    //   295: getfield 87	com/tencent/mm/plugin/voip/model/c:pOb	Ljava/io/BufferedOutputStream;
    //   298: aload_1
    //   299: iconst_0
    //   300: aload_1
    //   301: arraylength
    //   302: invokevirtual 291	java/io/BufferedOutputStream:write	([BII)V
    //   305: iload_2
    //   306: ifeq +889 -> 1195
    //   309: getstatic 74	com/tencent/mm/plugin/voip/model/c:pOd	[B
    //   312: ifnull +883 -> 1195
    //   315: getstatic 76	com/tencent/mm/plugin/voip/model/c:pOe	[B
    //   318: ifnull +877 -> 1195
    //   321: aload_0
    //   322: getfield 93	com/tencent/mm/plugin/voip/model/c:pOj	Z
    //   325: ifne +171 -> 496
    //   328: aload_0
    //   329: getfield 136	com/tencent/mm/plugin/voip/model/c:mDecoder	Landroid/media/MediaCodec;
    //   332: astore 11
    //   334: aload 11
    //   336: ifnull +22 -> 358
    //   339: aload_0
    //   340: getfield 136	com/tencent/mm/plugin/voip/model/c:mDecoder	Landroid/media/MediaCodec;
    //   343: invokevirtual 296	android/media/MediaCodec:stop	()V
    //   346: aload_0
    //   347: getfield 136	com/tencent/mm/plugin/voip/model/c:mDecoder	Landroid/media/MediaCodec;
    //   350: invokevirtual 299	android/media/MediaCodec:release	()V
    //   353: aload_0
    //   354: aconst_null
    //   355: putfield 136	com/tencent/mm/plugin/voip/model/c:mDecoder	Landroid/media/MediaCodec;
    //   358: aload_0
    //   359: getfield 91	com/tencent/mm/plugin/voip/model/c:pOg	Z
    //   362: ifeq +850 -> 1212
    //   365: ldc_w 301
    //   368: getstatic 78	com/tencent/mm/plugin/voip/model/c:pOh	I
    //   371: getstatic 80	com/tencent/mm/plugin/voip/model/c:pOi	I
    //   374: invokestatic 307	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   377: astore 11
    //   379: aload 11
    //   381: ldc_w 309
    //   384: bipush 90
    //   386: invokevirtual 313	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   389: ldc 166
    //   391: new 44	java/lang/StringBuilder
    //   394: dup
    //   395: ldc_w 315
    //   398: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   401: aload 11
    //   403: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   406: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokestatic 321	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   412: aload 11
    //   414: ldc_w 323
    //   417: invokevirtual 327	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   420: astore 12
    //   422: aload 12
    //   424: ldc_w 329
    //   427: invokevirtual 333	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   430: ifeq +66 -> 496
    //   433: aload_0
    //   434: aload 12
    //   436: invokestatic 337	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   439: putfield 136	com/tencent/mm/plugin/voip/model/c:mDecoder	Landroid/media/MediaCodec;
    //   442: ldc 166
    //   444: new 44	java/lang/StringBuilder
    //   447: dup
    //   448: ldc_w 339
    //   451: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   454: aload 11
    //   456: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   459: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: invokestatic 176	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   465: aload_0
    //   466: getfield 136	com/tencent/mm/plugin/voip/model/c:mDecoder	Landroid/media/MediaCodec;
    //   469: aload 11
    //   471: aload_0
    //   472: getfield 138	com/tencent/mm/plugin/voip/model/c:avf	Landroid/view/Surface;
    //   475: aconst_null
    //   476: iconst_0
    //   477: invokevirtual 343	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   480: aload_0
    //   481: getfield 136	com/tencent/mm/plugin/voip/model/c:mDecoder	Landroid/media/MediaCodec;
    //   484: invokevirtual 346	android/media/MediaCodec:start	()V
    //   487: aload_0
    //   488: iconst_1
    //   489: putfield 93	com/tencent/mm/plugin/voip/model/c:pOj	Z
    //   492: aload_0
    //   493: invokevirtual 347	com/tencent/mm/plugin/voip/model/c:start	()V
    //   496: iconst_1
    //   497: ireturn
    //   498: aload_1
    //   499: getfield 266	com/tencent/mm/protocal/c/aon:tkk	Lcom/tencent/mm/bv/b;
    //   502: getfield 274	com/tencent/mm/bv/b:oY	[B
    //   505: arraylength
    //   506: istore_2
    //   507: goto -448 -> 59
    //   510: aload_0
    //   511: getfield 91	com/tencent/mm/plugin/voip/model/c:pOg	Z
    //   514: ifeq +8 -> 522
    //   517: aload_0
    //   518: iconst_0
    //   519: putfield 93	com/tencent/mm/plugin/voip/model/c:pOj	Z
    //   522: aload_0
    //   523: iconst_0
    //   524: putfield 91	com/tencent/mm/plugin/voip/model/c:pOg	Z
    //   527: iload 4
    //   529: iconst_4
    //   530: iadd
    //   531: newarray byte
    //   533: astore 11
    //   535: aload_0
    //   536: getfield 107	com/tencent/mm/plugin/voip/model/c:pOo	[B
    //   539: iconst_0
    //   540: aload 11
    //   542: iconst_0
    //   543: iconst_4
    //   544: invokestatic 281	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   547: aload_1
    //   548: getfield 269	com/tencent/mm/protocal/c/aon:tki	Lcom/tencent/mm/bv/b;
    //   551: aload 11
    //   553: invokevirtual 285	com/tencent/mm/bv/b:bl	([B)V
    //   556: ldc 166
    //   558: new 44	java/lang/StringBuilder
    //   561: dup
    //   562: ldc_w 349
    //   565: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   568: aload 11
    //   570: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   573: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 176	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   579: aload 11
    //   581: invokestatic 351	com/tencent/mm/plugin/voip/model/c:aP	([B)Z
    //   584: ifeq +184 -> 768
    //   587: ldc 166
    //   589: ldc_w 353
    //   592: invokestatic 321	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   595: aload 11
    //   597: putstatic 74	com/tencent/mm/plugin/voip/model/c:pOd	[B
    //   600: ldc 166
    //   602: new 44	java/lang/StringBuilder
    //   605: dup
    //   606: ldc_w 355
    //   609: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   612: getstatic 74	com/tencent/mm/plugin/voip/model/c:pOd	[B
    //   615: arraylength
    //   616: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   619: ldc_w 357
    //   622: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: iload 4
    //   627: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   630: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: invokestatic 176	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: iload 5
    //   638: iconst_4
    //   639: iadd
    //   640: newarray byte
    //   642: putstatic 76	com/tencent/mm/plugin/voip/model/c:pOe	[B
    //   645: aload_0
    //   646: getfield 107	com/tencent/mm/plugin/voip/model/c:pOo	[B
    //   649: iconst_0
    //   650: getstatic 76	com/tencent/mm/plugin/voip/model/c:pOe	[B
    //   653: iconst_0
    //   654: iconst_4
    //   655: invokestatic 281	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   658: aload_1
    //   659: getfield 277	com/tencent/mm/protocal/c/aon:tkj	Lcom/tencent/mm/bv/b;
    //   662: getstatic 76	com/tencent/mm/plugin/voip/model/c:pOe	[B
    //   665: invokevirtual 285	com/tencent/mm/bv/b:bl	([B)V
    //   668: aload_0
    //   669: getstatic 74	com/tencent/mm/plugin/voip/model/c:pOd	[B
    //   672: arraylength
    //   673: getstatic 76	com/tencent/mm/plugin/voip/model/c:pOe	[B
    //   676: arraylength
    //   677: iadd
    //   678: newarray byte
    //   680: putfield 89	com/tencent/mm/plugin/voip/model/c:pOf	[B
    //   683: getstatic 74	com/tencent/mm/plugin/voip/model/c:pOd	[B
    //   686: iconst_0
    //   687: aload_0
    //   688: getfield 89	com/tencent/mm/plugin/voip/model/c:pOf	[B
    //   691: iconst_0
    //   692: getstatic 74	com/tencent/mm/plugin/voip/model/c:pOd	[B
    //   695: arraylength
    //   696: invokestatic 281	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   699: getstatic 74	com/tencent/mm/plugin/voip/model/c:pOd	[B
    //   702: arraylength
    //   703: istore_2
    //   704: getstatic 76	com/tencent/mm/plugin/voip/model/c:pOe	[B
    //   707: iconst_0
    //   708: aload_0
    //   709: getfield 89	com/tencent/mm/plugin/voip/model/c:pOf	[B
    //   712: iload_2
    //   713: iconst_0
    //   714: iadd
    //   715: getstatic 76	com/tencent/mm/plugin/voip/model/c:pOe	[B
    //   718: arraylength
    //   719: invokestatic 281	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   722: goto -443 -> 279
    //   725: astore_1
    //   726: aload_0
    //   727: aload_0
    //   728: getfield 113	com/tencent/mm/plugin/voip/model/c:pOr	I
    //   731: iconst_2
    //   732: ior
    //   733: putfield 113	com/tencent/mm/plugin/voip/model/c:pOr	I
    //   736: ldc 166
    //   738: new 44	java/lang/StringBuilder
    //   741: dup
    //   742: ldc_w 359
    //   745: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   748: aload_1
    //   749: invokevirtual 360	java/lang/Exception:toString	()Ljava/lang/String;
    //   752: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   758: invokestatic 363	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   761: aconst_null
    //   762: astore_1
    //   763: iconst_0
    //   764: istore_2
    //   765: goto -482 -> 283
    //   768: new 365	com/tencent/mm/plugin/voip/model/f
    //   771: dup
    //   772: invokespecial 366	com/tencent/mm/plugin/voip/model/f:<init>	()V
    //   775: pop
    //   776: new 368	java/io/ByteArrayInputStream
    //   779: dup
    //   780: aload 11
    //   782: invokespecial 370	java/io/ByteArrayInputStream:<init>	([B)V
    //   785: invokestatic 374	com/tencent/mm/plugin/voip/model/f:B	(Ljava/io/InputStream;)[B
    //   788: putstatic 74	com/tencent/mm/plugin/voip/model/c:pOd	[B
    //   791: goto -191 -> 600
    //   794: new 376	com/tencent/mm/protocal/c/aom
    //   797: dup
    //   798: invokespecial 377	com/tencent/mm/protocal/c/aom:<init>	()V
    //   801: aload_1
    //   802: invokevirtual 378	com/tencent/mm/protocal/c/aom:aH	([B)Lcom/tencent/mm/bv/a;
    //   805: checkcast 376	com/tencent/mm/protocal/c/aom
    //   808: astore 11
    //   810: aload 11
    //   812: getfield 382	com/tencent/mm/protocal/c/aom:tkg	Ljava/util/LinkedList;
    //   815: invokevirtual 388	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   818: checkcast 144	java/lang/Integer
    //   821: invokevirtual 391	java/lang/Integer:intValue	()I
    //   824: istore 6
    //   826: iconst_0
    //   827: istore 4
    //   829: ldc 166
    //   831: new 44	java/lang/StringBuilder
    //   834: dup
    //   835: ldc_w 393
    //   838: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   841: iload 6
    //   843: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   846: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   849: invokestatic 176	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   852: iload_2
    //   853: iconst_1
    //   854: if_icmpne +185 -> 1039
    //   857: aload_0
    //   858: getfield 89	com/tencent/mm/plugin/voip/model/c:pOf	[B
    //   861: arraylength
    //   862: istore 4
    //   864: iload 6
    //   866: iload 4
    //   868: iadd
    //   869: istore 5
    //   871: iload 5
    //   873: newarray byte
    //   875: astore_1
    //   876: aload_0
    //   877: getfield 89	com/tencent/mm/plugin/voip/model/c:pOf	[B
    //   880: iconst_0
    //   881: aload_1
    //   882: iconst_0
    //   883: iload 4
    //   885: invokestatic 281	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   888: iload 4
    //   890: iconst_0
    //   891: iadd
    //   892: istore 4
    //   894: goto +813 -> 1707
    //   897: iconst_4
    //   898: invokestatic 211	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   901: astore 12
    //   903: aload 11
    //   905: getfield 396	com/tencent/mm/protocal/c/aom:tkd	Lcom/tencent/mm/bv/b;
    //   908: aload 12
    //   910: invokevirtual 233	java/nio/ByteBuffer:array	()[B
    //   913: iload 6
    //   915: iconst_0
    //   916: iconst_4
    //   917: invokevirtual 400	com/tencent/mm/bv/b:f	([BIII)V
    //   920: aload 12
    //   922: getstatic 403	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   925: invokevirtual 221	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   928: pop
    //   929: aload 12
    //   931: iconst_0
    //   932: invokevirtual 407	java/nio/ByteBuffer:getInt	(I)I
    //   935: istore 8
    //   937: aload_0
    //   938: getfield 107	com/tencent/mm/plugin/voip/model/c:pOo	[B
    //   941: iconst_0
    //   942: aload_1
    //   943: iload 6
    //   945: iload 4
    //   947: iadd
    //   948: iconst_4
    //   949: invokestatic 281	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   952: iload 6
    //   954: iconst_4
    //   955: iadd
    //   956: istore 6
    //   958: aload 11
    //   960: getfield 396	com/tencent/mm/protocal/c/aom:tkd	Lcom/tencent/mm/bv/b;
    //   963: aload_1
    //   964: iload 6
    //   966: iload 6
    //   968: iload 4
    //   970: iadd
    //   971: iload 8
    //   973: invokevirtual 400	com/tencent/mm/bv/b:f	([BIII)V
    //   976: iload 7
    //   978: iload 8
    //   980: iconst_4
    //   981: iadd
    //   982: isub
    //   983: istore 7
    //   985: ldc 166
    //   987: new 44	java/lang/StringBuilder
    //   990: dup
    //   991: ldc_w 409
    //   994: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   997: iload 8
    //   999: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1002: ldc_w 411
    //   1005: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1008: iload 5
    //   1010: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1013: ldc_w 413
    //   1016: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: iload_2
    //   1020: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1023: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1026: invokestatic 176	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1029: iload 7
    //   1031: ifgt +666 -> 1697
    //   1034: iconst_0
    //   1035: istore_2
    //   1036: goto -753 -> 283
    //   1039: iload 6
    //   1041: newarray byte
    //   1043: astore_1
    //   1044: iload 6
    //   1046: istore 5
    //   1048: goto +659 -> 1707
    //   1051: astore_1
    //   1052: aload_0
    //   1053: aload_0
    //   1054: getfield 113	com/tencent/mm/plugin/voip/model/c:pOr	I
    //   1057: iconst_4
    //   1058: ior
    //   1059: putfield 113	com/tencent/mm/plugin/voip/model/c:pOr	I
    //   1062: ldc 166
    //   1064: new 44	java/lang/StringBuilder
    //   1067: dup
    //   1068: ldc_w 415
    //   1071: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1074: aload_1
    //   1075: invokevirtual 360	java/lang/Exception:toString	()Ljava/lang/String;
    //   1078: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1084: invokestatic 363	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1087: aconst_null
    //   1088: astore_1
    //   1089: iconst_0
    //   1090: istore_2
    //   1091: goto -808 -> 283
    //   1094: astore 11
    //   1096: ldc 166
    //   1098: new 44	java/lang/StringBuilder
    //   1101: dup
    //   1102: ldc_w 417
    //   1105: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1108: aload 11
    //   1110: invokevirtual 418	java/io/IOException:toString	()Ljava/lang/String;
    //   1113: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1119: invokestatic 363	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1122: goto -817 -> 305
    //   1125: astore 11
    //   1127: ldc 166
    //   1129: new 44	java/lang/StringBuilder
    //   1132: dup
    //   1133: ldc_w 420
    //   1136: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1139: aload 11
    //   1141: invokevirtual 360	java/lang/Exception:toString	()Ljava/lang/String;
    //   1144: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1147: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1150: invokestatic 363	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1153: goto -795 -> 358
    //   1156: astore 11
    //   1158: aload_0
    //   1159: aload_0
    //   1160: getfield 113	com/tencent/mm/plugin/voip/model/c:pOr	I
    //   1163: bipush 16
    //   1165: ior
    //   1166: putfield 113	com/tencent/mm/plugin/voip/model/c:pOr	I
    //   1169: ldc 166
    //   1171: new 44	java/lang/StringBuilder
    //   1174: dup
    //   1175: ldc_w 417
    //   1178: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1181: aload 11
    //   1183: invokevirtual 360	java/lang/Exception:toString	()Ljava/lang/String;
    //   1186: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1189: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1192: invokestatic 363	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1195: aload_0
    //   1196: getfield 93	com/tencent/mm/plugin/voip/model/c:pOj	Z
    //   1199: ifne +89 -> 1288
    //   1202: ldc 166
    //   1204: ldc_w 422
    //   1207: invokestatic 363	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1210: iconst_m1
    //   1211: ireturn
    //   1212: ldc_w 424
    //   1215: getstatic 78	com/tencent/mm/plugin/voip/model/c:pOh	I
    //   1218: getstatic 80	com/tencent/mm/plugin/voip/model/c:pOi	I
    //   1221: invokestatic 307	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   1224: astore 11
    //   1226: goto -847 -> 379
    //   1229: astore 11
    //   1231: aload_0
    //   1232: aload_0
    //   1233: getfield 113	com/tencent/mm/plugin/voip/model/c:pOr	I
    //   1236: bipush 8
    //   1238: ior
    //   1239: putfield 113	com/tencent/mm/plugin/voip/model/c:pOr	I
    //   1242: ldc 166
    //   1244: new 44	java/lang/StringBuilder
    //   1247: dup
    //   1248: ldc_w 426
    //   1251: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1254: aload 12
    //   1256: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: ldc_w 428
    //   1262: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1265: aload 11
    //   1267: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1270: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1273: invokestatic 363	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1276: aload_0
    //   1277: iconst_0
    //   1278: putfield 95	com/tencent/mm/plugin/voip/model/c:pOk	Z
    //   1281: aload_0
    //   1282: invokespecial 430	com/tencent/mm/plugin/voip/model/c:bPI	()I
    //   1285: pop
    //   1286: iconst_m1
    //   1287: ireturn
    //   1288: aload_0
    //   1289: getfield 97	com/tencent/mm/plugin/voip/model/c:pOl	Z
    //   1292: ifne +8 -> 1300
    //   1295: aload_0
    //   1296: iconst_1
    //   1297: putfield 97	com/tencent/mm/plugin/voip/model/c:pOl	Z
    //   1300: aload_1
    //   1301: arraylength
    //   1302: istore_2
    //   1303: aload_1
    //   1304: iconst_4
    //   1305: baload
    //   1306: bipush 31
    //   1308: iand
    //   1309: istore 4
    //   1311: iload 4
    //   1313: bipush 7
    //   1315: if_icmpeq +10 -> 1325
    //   1318: iload 4
    //   1320: bipush 8
    //   1322: if_icmpne +86 -> 1408
    //   1325: bipush 83
    //   1327: istore_3
    //   1328: ldc 166
    //   1330: new 44	java/lang/StringBuilder
    //   1333: dup
    //   1334: ldc_w 432
    //   1337: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1340: iload_2
    //   1341: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1344: ldc_w 434
    //   1347: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1350: iload 4
    //   1352: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1355: ldc_w 436
    //   1358: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: iload_3
    //   1362: invokevirtual 439	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1365: ldc_w 441
    //   1368: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1371: aload_0
    //   1372: getfield 111	com/tencent/mm/plugin/voip/model/c:pOq	I
    //   1375: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1378: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1381: invokestatic 176	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1384: aload_0
    //   1385: getfield 99	com/tencent/mm/plugin/voip/model/c:pOm	Z
    //   1388: ifeq +45 -> 1433
    //   1391: iload_3
    //   1392: bipush 80
    //   1394: if_icmpne +39 -> 1433
    //   1397: ldc 166
    //   1399: ldc_w 443
    //   1402: invokestatic 363	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1405: bipush 254
    //   1407: ireturn
    //   1408: iload 4
    //   1410: iconst_5
    //   1411: if_icmpeq +10 -> 1421
    //   1414: iload 4
    //   1416: bipush 6
    //   1418: if_icmpne +9 -> 1427
    //   1421: bipush 73
    //   1423: istore_3
    //   1424: goto -96 -> 1328
    //   1427: bipush 80
    //   1429: istore_3
    //   1430: goto -102 -> 1328
    //   1433: aload_0
    //   1434: getfield 136	com/tencent/mm/plugin/voip/model/c:mDecoder	Landroid/media/MediaCodec;
    //   1437: ldc2_w 444
    //   1440: invokevirtual 449	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   1443: istore 4
    //   1445: iload 4
    //   1447: iflt +205 -> 1652
    //   1450: aload_1
    //   1451: ifnull +185 -> 1636
    //   1454: iload_2
    //   1455: ifle +181 -> 1636
    //   1458: invokestatic 255	java/lang/System:currentTimeMillis	()J
    //   1461: lstore 9
    //   1463: ldc 166
    //   1465: new 44	java/lang/StringBuilder
    //   1468: dup
    //   1469: ldc_w 451
    //   1472: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1475: iload 4
    //   1477: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1480: ldc_w 453
    //   1483: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1486: iload_2
    //   1487: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1490: ldc_w 436
    //   1493: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1496: iload_3
    //   1497: invokevirtual 439	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1500: ldc_w 455
    //   1503: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1506: lload 9
    //   1508: invokevirtual 458	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1511: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1514: invokestatic 176	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1517: getstatic 463	android/os/Build$VERSION:SDK_INT	I
    //   1520: bipush 21
    //   1522: if_icmpge +116 -> 1638
    //   1525: aload_0
    //   1526: getfield 136	com/tencent/mm/plugin/voip/model/c:mDecoder	Landroid/media/MediaCodec;
    //   1529: invokevirtual 467	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   1532: iload 4
    //   1534: aaload
    //   1535: astore 11
    //   1537: aload 11
    //   1539: invokevirtual 471	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1542: pop
    //   1543: aload 11
    //   1545: invokevirtual 471	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1548: pop
    //   1549: aload 11
    //   1551: aload_1
    //   1552: iconst_0
    //   1553: iload_2
    //   1554: invokevirtual 474	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1557: pop
    //   1558: aload_0
    //   1559: getfield 136	com/tencent/mm/plugin/voip/model/c:mDecoder	Landroid/media/MediaCodec;
    //   1562: iload 4
    //   1564: iconst_0
    //   1565: iload_2
    //   1566: lload 9
    //   1568: iconst_0
    //   1569: invokevirtual 478	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   1572: aload_0
    //   1573: aload_0
    //   1574: getfield 111	com/tencent/mm/plugin/voip/model/c:pOq	I
    //   1577: iconst_1
    //   1578: iadd
    //   1579: putfield 111	com/tencent/mm/plugin/voip/model/c:pOq	I
    //   1582: aload_0
    //   1583: iconst_0
    //   1584: putfield 101	com/tencent/mm/plugin/voip/model/c:pOn	I
    //   1587: aload_0
    //   1588: getfield 99	com/tencent/mm/plugin/voip/model/c:pOm	Z
    //   1591: ifeq +45 -> 1636
    //   1594: iconst_1
    //   1595: invokestatic 211	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1598: astore_1
    //   1599: aload_1
    //   1600: getstatic 217	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   1603: invokevirtual 221	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1606: pop
    //   1607: aload_1
    //   1608: iconst_0
    //   1609: invokevirtual 225	java/nio/ByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   1612: pop
    //   1613: aload_0
    //   1614: getfield 103	com/tencent/mm/plugin/voip/model/c:pNq	Lcom/tencent/mm/plugin/voip/model/j;
    //   1617: getfield 229	com/tencent/mm/plugin/voip/model/j:pQe	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1620: bipush 28
    //   1622: aload_1
    //   1623: invokevirtual 233	java/nio/ByteBuffer:array	()[B
    //   1626: iconst_1
    //   1627: invokevirtual 239	com/tencent/mm/plugin/voip/model/v2protocal:setAppCmd	(I[BI)I
    //   1630: pop
    //   1631: aload_0
    //   1632: iconst_0
    //   1633: putfield 99	com/tencent/mm/plugin/voip/model/c:pOm	Z
    //   1636: iconst_0
    //   1637: ireturn
    //   1638: aload_0
    //   1639: getfield 136	com/tencent/mm/plugin/voip/model/c:mDecoder	Landroid/media/MediaCodec;
    //   1642: iload 4
    //   1644: invokevirtual 481	android/media/MediaCodec:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   1647: astore 11
    //   1649: goto -106 -> 1543
    //   1652: aload_0
    //   1653: getfield 99	com/tencent/mm/plugin/voip/model/c:pOm	Z
    //   1656: ifeq +25 -> 1681
    //   1659: iload_3
    //   1660: bipush 80
    //   1662: if_icmpeq +19 -> 1681
    //   1665: aload_0
    //   1666: iconst_0
    //   1667: putfield 95	com/tencent/mm/plugin/voip/model/c:pOk	Z
    //   1670: aload_0
    //   1671: aload_0
    //   1672: getfield 113	com/tencent/mm/plugin/voip/model/c:pOr	I
    //   1675: bipush 32
    //   1677: ior
    //   1678: putfield 113	com/tencent/mm/plugin/voip/model/c:pOr	I
    //   1681: aload_0
    //   1682: invokespecial 430	com/tencent/mm/plugin/voip/model/c:bPI	()I
    //   1685: pop
    //   1686: ldc 166
    //   1688: ldc_w 483
    //   1691: invokestatic 363	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1694: goto -58 -> 1636
    //   1697: iload 6
    //   1699: iload 8
    //   1701: iadd
    //   1702: istore 6
    //   1704: goto -807 -> 897
    //   1707: iconst_0
    //   1708: istore 8
    //   1710: iload 6
    //   1712: istore 7
    //   1714: iload 8
    //   1716: istore 6
    //   1718: goto -821 -> 897
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1721	0	this	c
    //   0	1721	1	paramArrayOfByte	byte[]
    //   0	1721	2	paramInt	int
    //   1327	336	3	c	char
    //   67	1576	4	i	int
    //   77	970	5	j	int
    //   824	893	6	k	int
    //   976	737	7	m	int
    //   935	780	8	n	int
    //   1461	106	9	l	long
    //   332	627	11	localObject1	java.lang.Object
    //   1094	15	11	localIOException	IOException
    //   1125	15	11	localException1	Exception
    //   1156	26	11	localException2	Exception
    //   1224	1	11	localMediaFormat	MediaFormat
    //   1229	37	11	localException3	Exception
    //   1535	113	11	localByteBuffer	ByteBuffer
    //   420	835	12	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   35	57	725	java/lang/Exception
    //   59	79	725	java/lang/Exception
    //   83	95	725	java/lang/Exception
    //   95	279	725	java/lang/Exception
    //   498	507	725	java/lang/Exception
    //   510	522	725	java/lang/Exception
    //   522	600	725	java/lang/Exception
    //   600	722	725	java/lang/Exception
    //   768	791	725	java/lang/Exception
    //   794	826	1051	java/lang/Exception
    //   829	852	1051	java/lang/Exception
    //   857	864	1051	java/lang/Exception
    //   871	888	1051	java/lang/Exception
    //   897	952	1051	java/lang/Exception
    //   958	976	1051	java/lang/Exception
    //   985	1029	1051	java/lang/Exception
    //   1039	1044	1051	java/lang/Exception
    //   294	305	1094	java/io/IOException
    //   339	358	1125	java/lang/Exception
    //   309	334	1156	java/lang/Exception
    //   358	379	1156	java/lang/Exception
    //   379	442	1156	java/lang/Exception
    //   480	496	1156	java/lang/Exception
    //   1127	1153	1156	java/lang/Exception
    //   1212	1226	1156	java/lang/Exception
    //   1231	1286	1156	java/lang/Exception
    //   442	480	1229	java/lang/Exception
  }
  
  public final void a(j paramj)
  {
    this.pNq = paramj;
    y.i("MeidaCodec[HWDec]", "setCallBack");
  }
  
  public final void bPJ()
  {
    this.pOk = false;
    this.pOl = false;
    this.pOn = 0;
    y.d("MeidaCodec[HWDec]", "steve: Stop Decode Thread!");
    try
    {
      if (this.pOa != null)
      {
        this.pOa.flush();
        this.pOa.close();
      }
      if (this.pOb != null)
      {
        this.pOb.flush();
        this.pOb.close();
      }
      return;
    }
    catch (IOException localIOException)
    {
      y.e("MeidaCodec[HWDec]", " error:" + localIOException.toString());
    }
  }
  
  @SuppressLint({"NewApi"})
  public final void run()
  {
    if ((!Thread.interrupted()) && (this.pOk)) {
      if ((this.mDecoder == null) || (!this.pOj) || (!this.pOl)) {}
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
          i = this.mDecoder.dequeueOutputBuffer(localBufferInfo, 10000L);
          y.d("MeidaCodec[HWDec]", "steve:  outIndex=" + i);
          switch (i)
          {
          case -3: 
            if (localBufferInfo.size <= 0) {
              break label415;
            }
            long l1 = localBufferInfo.presentationTimeUs;
            long l2 = System.currentTimeMillis();
            y.d("MeidaCodec[HWDec]", "DECODER_THREAD:: decoded SUCCESSFULLY!!! cnt : " + this.pOp + ", size:" + localBufferInfo.size + ", pts:" + localBufferInfo.presentationTimeUs + ", latency:" + (l2 - l1));
            this.pOp += 1;
            this.mDecoder.releaseOutputBuffer(i, true);
            l2 = System.currentTimeMillis();
            y.d("MeidaCodec[HWDec]", "steve: Avcdecoder frame processTime = " + (l2 - l1) + ", decFrameCnt=" + this.pOp + ", endTime=" + l2);
          }
        }
        catch (Exception localException1)
        {
          this.pOk = false;
          this.pOr |= 0x80;
          bPI();
          y.e("MeidaCodec[HWDec]", " dequeueOutputBuffer/releaseOutputBuffer error:" + localException1.toString());
        }
        break;
        y.d("MeidaCodec[HWDec]", "INFO_OUTPUT_BUFFERS_CHANGED");
        break;
        MediaFormat localMediaFormat = this.mDecoder.getOutputFormat();
        y.i("MeidaCodec[HWDec]", "DECODER_THREAD:: New format : " + localMediaFormat);
        int i = localMediaFormat.getInteger("width");
        int j = localMediaFormat.getInteger("height");
        if ((this.pNq == null) || (this.pNq.pQe == null)) {
          break;
        }
        v2protocal.gF(j, i);
        break;
        y.d("MeidaCodec[HWDec]", "DECODER_THREAD:: dequeueOutputBuffer timed out!");
        break;
        label415:
        y.d("MeidaCodec[HWDec]", "steve: drop frame: " + this.pOp + ", size:" + localMediaFormat.size + ", pts:" + localMediaFormat.presentationTimeUs);
        this.mDecoder.releaseOutputBuffer(i, false);
        break;
        try
        {
          Thread.sleep(20L);
        }
        catch (InterruptedException localInterruptedException)
        {
          y.e("MeidaCodec[HWDec]", " error:" + localInterruptedException.toString());
        }
      }
      break;
      if ((!this.pOk) && (this.mDecoder != null)) {}
      try
      {
        this.mDecoder.stop();
        this.mDecoder.release();
        this.mDecoder = null;
        return;
      }
      catch (Exception localException2)
      {
        y.e("MeidaCodec[HWDec]", " decoder stop  error:" + localException2.toString());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.c
 * JD-Core Version:    0.7.0.1
 */