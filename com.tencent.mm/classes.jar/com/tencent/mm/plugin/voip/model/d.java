package com.tencent.mm.plugin.voip.model;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class d
  extends Thread
{
  public static int ttU = 64;
  private static String ttV = e.eQz;
  public static byte[] ttX = null;
  public static byte[] ttY = null;
  public static byte[] ttZ = null;
  public static int tub = 640;
  public static int tuc = 480;
  private Surface axw;
  public byte[] configbyte;
  private MediaCodec mDecoder;
  private BufferedOutputStream outputStream;
  private BufferedOutputStream ttW;
  k ttm;
  private boolean tua;
  private boolean tud;
  public boolean tue;
  public boolean tuf;
  public boolean tug;
  public int tuh;
  public byte[] tui;
  public int tuj;
  public int tuk;
  public int tul;
  public byte[] tum;
  public byte[] tun;
  public byte[] tuo;
  
  public d(Surface paramSurface)
  {
    AppMethodBeat.i(4333);
    this.outputStream = null;
    this.ttW = null;
    this.configbyte = null;
    this.tua = false;
    this.tud = false;
    this.tue = true;
    this.tuf = true;
    this.tug = false;
    this.tuh = 0;
    this.ttm = null;
    this.tui = new byte[] { 0, 0, 0, 1 };
    this.tuj = 0;
    this.tuk = 0;
    this.tul = 0;
    this.tum = new byte[] { 103, 100, 0, 13, -84, -74, 10, 15, -120 };
    this.tun = new byte[] { 0, 0, 0, 1, 40, -50, 60, 48 };
    this.tuo = new byte[] { 13, 0, -15, 98, -22 };
    this.tue = true;
    this.tuf = true;
    this.mDecoder = null;
    this.tua = false;
    this.tul = 0;
    if (paramSurface != null) {
      this.axw = paramSurface;
    }
    AppMethodBeat.o(4333);
  }
  
  private static String bn(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(4336);
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
    AppMethodBeat.o(4336);
    return str1;
  }
  
  private int cLM()
  {
    AppMethodBeat.i(4335);
    this.tuh += 1;
    ab.i("MeidaCodec[HWDec]", "[HW]:DecFrmError: I Req mIReqFlag = " + this.tug + ", mIsHWDecEnable = " + this.tue + ", mHWErrorDecFrmCount = " + this.tuh);
    if ((!this.tue) || (this.tuh > ttU))
    {
      cLN();
      this.ttm.mQ(true);
      this.tul |= 0x40;
      ab.i("MeidaCodec[HWDec]", "[HW]: ErrFrm > threshold, end HWDec!!");
      AppMethodBeat.o(4335);
      return 0;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(1);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.put((byte)1);
    this.ttm.tvj.setAppCmd(28, localByteBuffer.array(), 1);
    this.tug = true;
    AppMethodBeat.o(4335);
    return 1;
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(4334);
    this.ttm = paramk;
    ab.i("MeidaCodec[HWDec]", "setCallBack");
    AppMethodBeat.o(4334);
  }
  
  public final void cLN()
  {
    AppMethodBeat.i(4339);
    this.tue = false;
    this.tuf = false;
    this.tuh = 0;
    ab.d("MeidaCodec[HWDec]", "steve: Stop Decode Thread!");
    try
    {
      if (this.outputStream != null)
      {
        this.outputStream.flush();
        this.outputStream.close();
      }
      if (this.ttW != null)
      {
        this.ttW.flush();
        this.ttW.close();
      }
      AppMethodBeat.o(4339);
      return;
    }
    catch (IOException localIOException)
    {
      ab.e("MeidaCodec[HWDec]", " error:" + localIOException.toString());
      AppMethodBeat.o(4339);
    }
  }
  
  /* Error */
  public final int h(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 263
    //   3: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 82	com/tencent/mm/plugin/voip/model/d:tue	Z
    //   10: ifne +30 -> 40
    //   13: aload_0
    //   14: aload_0
    //   15: getfield 100	com/tencent/mm/plugin/voip/model/d:tul	I
    //   18: iconst_1
    //   19: ior
    //   20: putfield 100	com/tencent/mm/plugin/voip/model/d:tul	I
    //   23: ldc_w 265
    //   26: ldc_w 267
    //   29: invokestatic 244	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: ldc_w 263
    //   35: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: iconst_m1
    //   39: ireturn
    //   40: iload_3
    //   41: ifeq +15 -> 56
    //   44: aload_0
    //   45: getfield 123	com/tencent/mm/plugin/voip/model/d:mDecoder	Landroid/media/MediaCodec;
    //   48: ifnull +8 -> 56
    //   51: aload_0
    //   52: iconst_0
    //   53: putfield 80	com/tencent/mm/plugin/voip/model/d:tud	Z
    //   56: invokestatic 273	java/lang/System:currentTimeMillis	()J
    //   59: pop2
    //   60: iload_2
    //   61: iconst_2
    //   62: if_icmpne +844 -> 906
    //   65: new 275	com/tencent/mm/protocal/protobuf/auf
    //   68: dup
    //   69: invokespecial 276	com/tencent/mm/protocal/protobuf/auf:<init>	()V
    //   72: aload_1
    //   73: invokevirtual 280	com/tencent/mm/protocal/protobuf/auf:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   76: checkcast 275	com/tencent/mm/protocal/protobuf/auf
    //   79: astore_1
    //   80: aload_1
    //   81: getfield 284	com/tencent/mm/protocal/protobuf/auf:xjb	Lcom/tencent/mm/bv/b;
    //   84: ifnonnull +436 -> 520
    //   87: iconst_0
    //   88: istore_2
    //   89: aload_1
    //   90: getfield 287	com/tencent/mm/protocal/protobuf/auf:xiZ	Lcom/tencent/mm/bv/b;
    //   93: getfield 292	com/tencent/mm/bv/b:pW	[B
    //   96: arraylength
    //   97: istore 5
    //   99: aload_1
    //   100: getfield 295	com/tencent/mm/protocal/protobuf/auf:xja	Lcom/tencent/mm/bv/b;
    //   103: getfield 292	com/tencent/mm/bv/b:pW	[B
    //   106: arraylength
    //   107: istore 6
    //   109: iload_2
    //   110: ifeq +422 -> 532
    //   113: aload_0
    //   114: getfield 78	com/tencent/mm/plugin/voip/model/d:tua	Z
    //   117: ifne +8 -> 125
    //   120: aload_0
    //   121: iconst_0
    //   122: putfield 80	com/tencent/mm/plugin/voip/model/d:tud	Z
    //   125: aload_0
    //   126: iconst_1
    //   127: putfield 78	com/tencent/mm/plugin/voip/model/d:tua	Z
    //   130: iload_2
    //   131: iconst_4
    //   132: iadd
    //   133: newarray byte
    //   135: putstatic 51	com/tencent/mm/plugin/voip/model/d:ttX	[B
    //   138: iload 5
    //   140: iconst_4
    //   141: iadd
    //   142: newarray byte
    //   144: putstatic 53	com/tencent/mm/plugin/voip/model/d:ttY	[B
    //   147: iload 6
    //   149: iconst_4
    //   150: iadd
    //   151: newarray byte
    //   153: putstatic 55	com/tencent/mm/plugin/voip/model/d:ttZ	[B
    //   156: aload_0
    //   157: getfield 94	com/tencent/mm/plugin/voip/model/d:tui	[B
    //   160: iconst_0
    //   161: getstatic 51	com/tencent/mm/plugin/voip/model/d:ttX	[B
    //   164: iconst_0
    //   165: iconst_4
    //   166: invokestatic 299	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   169: aload_0
    //   170: getfield 94	com/tencent/mm/plugin/voip/model/d:tui	[B
    //   173: iconst_0
    //   174: getstatic 53	com/tencent/mm/plugin/voip/model/d:ttY	[B
    //   177: iconst_0
    //   178: iconst_4
    //   179: invokestatic 299	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   182: aload_0
    //   183: getfield 94	com/tencent/mm/plugin/voip/model/d:tui	[B
    //   186: iconst_0
    //   187: getstatic 55	com/tencent/mm/plugin/voip/model/d:ttZ	[B
    //   190: iconst_0
    //   191: iconst_4
    //   192: invokestatic 299	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   195: aload_1
    //   196: getfield 284	com/tencent/mm/protocal/protobuf/auf:xjb	Lcom/tencent/mm/bv/b;
    //   199: getstatic 51	com/tencent/mm/plugin/voip/model/d:ttX	[B
    //   202: invokevirtual 303	com/tencent/mm/bv/b:bM	([B)V
    //   205: aload_1
    //   206: getfield 287	com/tencent/mm/protocal/protobuf/auf:xiZ	Lcom/tencent/mm/bv/b;
    //   209: getstatic 53	com/tencent/mm/plugin/voip/model/d:ttY	[B
    //   212: invokevirtual 303	com/tencent/mm/bv/b:bM	([B)V
    //   215: aload_1
    //   216: getfield 295	com/tencent/mm/protocal/protobuf/auf:xja	Lcom/tencent/mm/bv/b;
    //   219: getstatic 55	com/tencent/mm/plugin/voip/model/d:ttZ	[B
    //   222: invokevirtual 303	com/tencent/mm/bv/b:bM	([B)V
    //   225: aload_0
    //   226: getstatic 51	com/tencent/mm/plugin/voip/model/d:ttX	[B
    //   229: arraylength
    //   230: getstatic 53	com/tencent/mm/plugin/voip/model/d:ttY	[B
    //   233: arraylength
    //   234: iadd
    //   235: getstatic 55	com/tencent/mm/plugin/voip/model/d:ttZ	[B
    //   238: arraylength
    //   239: iadd
    //   240: newarray byte
    //   242: putfield 76	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   245: getstatic 51	com/tencent/mm/plugin/voip/model/d:ttX	[B
    //   248: iconst_0
    //   249: aload_0
    //   250: getfield 76	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   253: iconst_0
    //   254: getstatic 51	com/tencent/mm/plugin/voip/model/d:ttX	[B
    //   257: arraylength
    //   258: invokestatic 299	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   261: getstatic 51	com/tencent/mm/plugin/voip/model/d:ttX	[B
    //   264: arraylength
    //   265: iconst_0
    //   266: iadd
    //   267: istore_2
    //   268: getstatic 53	com/tencent/mm/plugin/voip/model/d:ttY	[B
    //   271: iconst_0
    //   272: aload_0
    //   273: getfield 76	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   276: iload_2
    //   277: getstatic 53	com/tencent/mm/plugin/voip/model/d:ttY	[B
    //   280: arraylength
    //   281: invokestatic 299	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   284: getstatic 53	com/tencent/mm/plugin/voip/model/d:ttY	[B
    //   287: arraylength
    //   288: istore 5
    //   290: getstatic 55	com/tencent/mm/plugin/voip/model/d:ttZ	[B
    //   293: iconst_0
    //   294: aload_0
    //   295: getfield 76	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   298: iload_2
    //   299: iload 5
    //   301: iadd
    //   302: getstatic 55	com/tencent/mm/plugin/voip/model/d:ttZ	[B
    //   305: arraylength
    //   306: invokestatic 299	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   309: iconst_1
    //   310: istore_2
    //   311: aconst_null
    //   312: astore_1
    //   313: aload_1
    //   314: ifnull +21 -> 335
    //   317: aload_0
    //   318: getfield 74	com/tencent/mm/plugin/voip/model/d:ttW	Ljava/io/BufferedOutputStream;
    //   321: ifnull +14 -> 335
    //   324: aload_0
    //   325: getfield 74	com/tencent/mm/plugin/voip/model/d:ttW	Ljava/io/BufferedOutputStream;
    //   328: aload_1
    //   329: iconst_0
    //   330: aload_1
    //   331: arraylength
    //   332: invokevirtual 307	java/io/BufferedOutputStream:write	([BII)V
    //   335: iload_2
    //   336: ifeq +962 -> 1298
    //   339: getstatic 53	com/tencent/mm/plugin/voip/model/d:ttY	[B
    //   342: ifnull +956 -> 1298
    //   345: getstatic 55	com/tencent/mm/plugin/voip/model/d:ttZ	[B
    //   348: ifnull +950 -> 1298
    //   351: aload_0
    //   352: getfield 80	com/tencent/mm/plugin/voip/model/d:tud	Z
    //   355: ifne +157 -> 512
    //   358: aload_0
    //   359: getfield 123	com/tencent/mm/plugin/voip/model/d:mDecoder	Landroid/media/MediaCodec;
    //   362: astore 12
    //   364: aload 12
    //   366: ifnull +22 -> 388
    //   369: aload_0
    //   370: getfield 123	com/tencent/mm/plugin/voip/model/d:mDecoder	Landroid/media/MediaCodec;
    //   373: invokevirtual 312	android/media/MediaCodec:stop	()V
    //   376: aload_0
    //   377: getfield 123	com/tencent/mm/plugin/voip/model/d:mDecoder	Landroid/media/MediaCodec;
    //   380: invokevirtual 315	android/media/MediaCodec:release	()V
    //   383: aload_0
    //   384: aconst_null
    //   385: putfield 123	com/tencent/mm/plugin/voip/model/d:mDecoder	Landroid/media/MediaCodec;
    //   388: aload_0
    //   389: getfield 78	com/tencent/mm/plugin/voip/model/d:tua	Z
    //   392: ifeq +929 -> 1321
    //   395: ldc_w 317
    //   398: getstatic 57	com/tencent/mm/plugin/voip/model/d:tub	I
    //   401: getstatic 59	com/tencent/mm/plugin/voip/model/d:tuc	I
    //   404: invokestatic 323	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   407: astore 12
    //   409: aload 12
    //   411: ldc_w 325
    //   414: bipush 90
    //   416: invokevirtual 329	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   419: ldc 168
    //   421: ldc_w 331
    //   424: aload 12
    //   426: invokestatic 150	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   429: invokevirtual 154	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   432: invokestatic 188	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   435: aload 12
    //   437: ldc_w 333
    //   440: invokevirtual 336	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   443: astore 13
    //   445: aload 13
    //   447: ldc_w 338
    //   450: invokevirtual 342	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   453: ifeq +59 -> 512
    //   456: aload_0
    //   457: aload 13
    //   459: invokestatic 346	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   462: putfield 123	com/tencent/mm/plugin/voip/model/d:mDecoder	Landroid/media/MediaCodec;
    //   465: ldc 168
    //   467: ldc_w 348
    //   470: aload 12
    //   472: invokestatic 150	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   475: invokevirtual 154	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   478: invokestatic 244	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   481: aload_0
    //   482: getfield 123	com/tencent/mm/plugin/voip/model/d:mDecoder	Landroid/media/MediaCodec;
    //   485: aload 12
    //   487: aload_0
    //   488: getfield 125	com/tencent/mm/plugin/voip/model/d:axw	Landroid/view/Surface;
    //   491: aconst_null
    //   492: iconst_0
    //   493: invokevirtual 352	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   496: aload_0
    //   497: getfield 123	com/tencent/mm/plugin/voip/model/d:mDecoder	Landroid/media/MediaCodec;
    //   500: invokevirtual 355	android/media/MediaCodec:start	()V
    //   503: aload_0
    //   504: iconst_1
    //   505: putfield 80	com/tencent/mm/plugin/voip/model/d:tud	Z
    //   508: aload_0
    //   509: invokevirtual 356	com/tencent/mm/plugin/voip/model/d:start	()V
    //   512: ldc_w 263
    //   515: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   518: iconst_1
    //   519: ireturn
    //   520: aload_1
    //   521: getfield 284	com/tencent/mm/protocal/protobuf/auf:xjb	Lcom/tencent/mm/bv/b;
    //   524: getfield 292	com/tencent/mm/bv/b:pW	[B
    //   527: arraylength
    //   528: istore_2
    //   529: goto -440 -> 89
    //   532: aload_0
    //   533: getfield 78	com/tencent/mm/plugin/voip/model/d:tua	Z
    //   536: ifeq +8 -> 544
    //   539: aload_0
    //   540: iconst_0
    //   541: putfield 80	com/tencent/mm/plugin/voip/model/d:tud	Z
    //   544: aload_0
    //   545: iconst_0
    //   546: putfield 78	com/tencent/mm/plugin/voip/model/d:tua	Z
    //   549: iload 5
    //   551: iconst_4
    //   552: iadd
    //   553: newarray byte
    //   555: astore 12
    //   557: aload_0
    //   558: getfield 94	com/tencent/mm/plugin/voip/model/d:tui	[B
    //   561: iconst_0
    //   562: aload 12
    //   564: iconst_0
    //   565: iconst_4
    //   566: invokestatic 299	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   569: aload_1
    //   570: getfield 287	com/tencent/mm/protocal/protobuf/auf:xiZ	Lcom/tencent/mm/bv/b;
    //   573: aload 12
    //   575: invokevirtual 303	com/tencent/mm/bv/b:bM	([B)V
    //   578: ldc 168
    //   580: ldc_w 358
    //   583: aload 12
    //   585: invokestatic 150	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   588: invokevirtual 154	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   591: invokestatic 244	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   594: aload 12
    //   596: invokestatic 360	com/tencent/mm/plugin/voip/model/d:bn	([B)Ljava/lang/String;
    //   599: astore 13
    //   601: iconst_3
    //   602: newarray byte
    //   604: dup
    //   605: iconst_0
    //   606: ldc 91
    //   608: bastore
    //   609: dup
    //   610: iconst_1
    //   611: ldc 91
    //   613: bastore
    //   614: dup
    //   615: iconst_2
    //   616: ldc_w 361
    //   619: bastore
    //   620: invokestatic 360	com/tencent/mm/plugin/voip/model/d:bn	([B)Ljava/lang/String;
    //   623: astore 14
    //   625: ldc 168
    //   627: new 156	java/lang/StringBuilder
    //   630: dup
    //   631: ldc_w 363
    //   634: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   637: aload 13
    //   639: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: ldc_w 365
    //   645: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: aload 14
    //   650: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   656: invokestatic 244	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   659: aload 13
    //   661: aload 14
    //   663: iconst_0
    //   664: invokevirtual 369	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   667: istore_2
    //   668: iload_2
    //   669: iconst_m1
    //   670: if_icmpeq +205 -> 875
    //   673: ldc 168
    //   675: ldc_w 371
    //   678: iload_2
    //   679: invokestatic 373	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   682: invokevirtual 154	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   685: invokestatic 244	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   688: iconst_1
    //   689: istore_2
    //   690: iload_2
    //   691: ifeq +189 -> 880
    //   694: ldc 168
    //   696: ldc_w 375
    //   699: invokestatic 188	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   702: aload 12
    //   704: putstatic 53	com/tencent/mm/plugin/voip/model/d:ttY	[B
    //   707: ldc 168
    //   709: new 156	java/lang/StringBuilder
    //   712: dup
    //   713: ldc_w 377
    //   716: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   719: getstatic 53	com/tencent/mm/plugin/voip/model/d:ttY	[B
    //   722: arraylength
    //   723: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   726: ldc_w 379
    //   729: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: iload 5
    //   734: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   737: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   740: invokestatic 244	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   743: iload 6
    //   745: iconst_4
    //   746: iadd
    //   747: newarray byte
    //   749: putstatic 55	com/tencent/mm/plugin/voip/model/d:ttZ	[B
    //   752: aload_0
    //   753: getfield 94	com/tencent/mm/plugin/voip/model/d:tui	[B
    //   756: iconst_0
    //   757: getstatic 55	com/tencent/mm/plugin/voip/model/d:ttZ	[B
    //   760: iconst_0
    //   761: iconst_4
    //   762: invokestatic 299	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   765: aload_1
    //   766: getfield 295	com/tencent/mm/protocal/protobuf/auf:xja	Lcom/tencent/mm/bv/b;
    //   769: getstatic 55	com/tencent/mm/plugin/voip/model/d:ttZ	[B
    //   772: invokevirtual 303	com/tencent/mm/bv/b:bM	([B)V
    //   775: aload_0
    //   776: getstatic 53	com/tencent/mm/plugin/voip/model/d:ttY	[B
    //   779: arraylength
    //   780: getstatic 55	com/tencent/mm/plugin/voip/model/d:ttZ	[B
    //   783: arraylength
    //   784: iadd
    //   785: newarray byte
    //   787: putfield 76	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   790: getstatic 53	com/tencent/mm/plugin/voip/model/d:ttY	[B
    //   793: iconst_0
    //   794: aload_0
    //   795: getfield 76	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   798: iconst_0
    //   799: getstatic 53	com/tencent/mm/plugin/voip/model/d:ttY	[B
    //   802: arraylength
    //   803: invokestatic 299	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   806: getstatic 53	com/tencent/mm/plugin/voip/model/d:ttY	[B
    //   809: arraylength
    //   810: istore_2
    //   811: getstatic 55	com/tencent/mm/plugin/voip/model/d:ttZ	[B
    //   814: iconst_0
    //   815: aload_0
    //   816: getfield 76	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   819: iload_2
    //   820: iconst_0
    //   821: iadd
    //   822: getstatic 55	com/tencent/mm/plugin/voip/model/d:ttZ	[B
    //   825: arraylength
    //   826: invokestatic 299	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   829: goto -520 -> 309
    //   832: astore_1
    //   833: aload_0
    //   834: aload_0
    //   835: getfield 100	com/tencent/mm/plugin/voip/model/d:tul	I
    //   838: iconst_2
    //   839: ior
    //   840: putfield 100	com/tencent/mm/plugin/voip/model/d:tul	I
    //   843: ldc 168
    //   845: new 156	java/lang/StringBuilder
    //   848: dup
    //   849: ldc_w 381
    //   852: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   855: aload_1
    //   856: invokevirtual 382	java/lang/Exception:toString	()Ljava/lang/String;
    //   859: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   865: invokestatic 258	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   868: iconst_0
    //   869: istore_2
    //   870: aconst_null
    //   871: astore_1
    //   872: goto -559 -> 313
    //   875: iconst_0
    //   876: istore_2
    //   877: goto -187 -> 690
    //   880: new 384	com/tencent/mm/plugin/voip/model/g
    //   883: dup
    //   884: invokespecial 385	com/tencent/mm/plugin/voip/model/g:<init>	()V
    //   887: pop
    //   888: new 387	java/io/ByteArrayInputStream
    //   891: dup
    //   892: aload 12
    //   894: invokespecial 389	java/io/ByteArrayInputStream:<init>	([B)V
    //   897: invokestatic 393	com/tencent/mm/plugin/voip/model/g:B	(Ljava/io/InputStream;)[B
    //   900: putstatic 53	com/tencent/mm/plugin/voip/model/d:ttY	[B
    //   903: goto -196 -> 707
    //   906: new 395	com/tencent/mm/protocal/protobuf/aue
    //   909: dup
    //   910: invokespecial 396	com/tencent/mm/protocal/protobuf/aue:<init>	()V
    //   913: aload_1
    //   914: invokevirtual 397	com/tencent/mm/protocal/protobuf/aue:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   917: checkcast 395	com/tencent/mm/protocal/protobuf/aue
    //   920: astore 12
    //   922: aload 12
    //   924: getfield 401	com/tencent/mm/protocal/protobuf/aue:xiX	Ljava/util/LinkedList;
    //   927: invokevirtual 407	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   930: checkcast 134	java/lang/Integer
    //   933: invokevirtual 410	java/lang/Integer:intValue	()I
    //   936: istore 7
    //   938: iconst_0
    //   939: istore 5
    //   941: ldc 168
    //   943: ldc_w 412
    //   946: iload 7
    //   948: invokestatic 373	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   951: invokevirtual 154	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   954: invokestatic 244	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   957: iload_2
    //   958: iconst_1
    //   959: if_icmpne +185 -> 1144
    //   962: aload_0
    //   963: getfield 76	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   966: arraylength
    //   967: istore 5
    //   969: iload 7
    //   971: iload 5
    //   973: iadd
    //   974: istore 6
    //   976: iload 6
    //   978: newarray byte
    //   980: astore_1
    //   981: aload_0
    //   982: getfield 76	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   985: iconst_0
    //   986: aload_1
    //   987: iconst_0
    //   988: iload 5
    //   990: invokestatic 299	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   993: iload 5
    //   995: iconst_0
    //   996: iadd
    //   997: istore 5
    //   999: goto +842 -> 1841
    //   1002: iconst_4
    //   1003: invokestatic 205	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1006: astore 13
    //   1008: aload 12
    //   1010: getfield 415	com/tencent/mm/protocal/protobuf/aue:xiU	Lcom/tencent/mm/bv/b;
    //   1013: aload 13
    //   1015: invokevirtual 227	java/nio/ByteBuffer:array	()[B
    //   1018: iload 7
    //   1020: iconst_0
    //   1021: iconst_4
    //   1022: invokevirtual 418	com/tencent/mm/bv/b:h	([BIII)V
    //   1025: aload 13
    //   1027: getstatic 421	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   1030: invokevirtual 215	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1033: pop
    //   1034: aload 13
    //   1036: iconst_0
    //   1037: invokevirtual 425	java/nio/ByteBuffer:getInt	(I)I
    //   1040: istore 9
    //   1042: aload_0
    //   1043: getfield 94	com/tencent/mm/plugin/voip/model/d:tui	[B
    //   1046: iconst_0
    //   1047: aload_1
    //   1048: iload 7
    //   1050: iload 5
    //   1052: iadd
    //   1053: iconst_4
    //   1054: invokestatic 299	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1057: iload 7
    //   1059: iconst_4
    //   1060: iadd
    //   1061: istore 7
    //   1063: aload 12
    //   1065: getfield 415	com/tencent/mm/protocal/protobuf/aue:xiU	Lcom/tencent/mm/bv/b;
    //   1068: aload_1
    //   1069: iload 7
    //   1071: iload 7
    //   1073: iload 5
    //   1075: iadd
    //   1076: iload 9
    //   1078: invokevirtual 418	com/tencent/mm/bv/b:h	([BIII)V
    //   1081: iload 8
    //   1083: iload 9
    //   1085: iconst_4
    //   1086: iadd
    //   1087: isub
    //   1088: istore 8
    //   1090: ldc 168
    //   1092: new 156	java/lang/StringBuilder
    //   1095: dup
    //   1096: ldc_w 427
    //   1099: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1102: iload 9
    //   1104: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1107: ldc_w 429
    //   1110: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: iload 6
    //   1115: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1118: ldc_w 431
    //   1121: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1124: iload_2
    //   1125: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1128: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1131: invokestatic 244	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1134: iload 8
    //   1136: ifgt +695 -> 1831
    //   1139: iconst_0
    //   1140: istore_2
    //   1141: goto -828 -> 313
    //   1144: iload 7
    //   1146: newarray byte
    //   1148: astore_1
    //   1149: iload 7
    //   1151: istore 6
    //   1153: goto +688 -> 1841
    //   1156: astore_1
    //   1157: aload_0
    //   1158: aload_0
    //   1159: getfield 100	com/tencent/mm/plugin/voip/model/d:tul	I
    //   1162: iconst_4
    //   1163: ior
    //   1164: putfield 100	com/tencent/mm/plugin/voip/model/d:tul	I
    //   1167: ldc 168
    //   1169: new 156	java/lang/StringBuilder
    //   1172: dup
    //   1173: ldc_w 433
    //   1176: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1179: aload_1
    //   1180: invokevirtual 382	java/lang/Exception:toString	()Ljava/lang/String;
    //   1183: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1189: invokestatic 258	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1192: iconst_0
    //   1193: istore_2
    //   1194: aconst_null
    //   1195: astore_1
    //   1196: goto -883 -> 313
    //   1199: astore 12
    //   1201: ldc 168
    //   1203: new 156	java/lang/StringBuilder
    //   1206: dup
    //   1207: ldc 254
    //   1209: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1212: aload 12
    //   1214: invokevirtual 255	java/io/IOException:toString	()Ljava/lang/String;
    //   1217: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1220: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1223: invokestatic 258	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1226: goto -891 -> 335
    //   1229: astore 12
    //   1231: ldc 168
    //   1233: new 156	java/lang/StringBuilder
    //   1236: dup
    //   1237: ldc_w 435
    //   1240: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1243: aload 12
    //   1245: invokevirtual 382	java/lang/Exception:toString	()Ljava/lang/String;
    //   1248: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1251: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1254: invokestatic 258	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1257: goto -869 -> 388
    //   1260: astore 12
    //   1262: aload_0
    //   1263: aload_0
    //   1264: getfield 100	com/tencent/mm/plugin/voip/model/d:tul	I
    //   1267: bipush 16
    //   1269: ior
    //   1270: putfield 100	com/tencent/mm/plugin/voip/model/d:tul	I
    //   1273: ldc 168
    //   1275: new 156	java/lang/StringBuilder
    //   1278: dup
    //   1279: ldc 254
    //   1281: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1284: aload 12
    //   1286: invokevirtual 382	java/lang/Exception:toString	()Ljava/lang/String;
    //   1289: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1292: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1295: invokestatic 258	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1298: aload_0
    //   1299: getfield 80	com/tencent/mm/plugin/voip/model/d:tud	Z
    //   1302: ifne +101 -> 1403
    //   1305: ldc 168
    //   1307: ldc_w 437
    //   1310: invokestatic 258	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1313: ldc_w 263
    //   1316: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1319: iconst_m1
    //   1320: ireturn
    //   1321: ldc_w 439
    //   1324: getstatic 57	com/tencent/mm/plugin/voip/model/d:tub	I
    //   1327: getstatic 59	com/tencent/mm/plugin/voip/model/d:tuc	I
    //   1330: invokestatic 323	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   1333: astore 12
    //   1335: goto -926 -> 409
    //   1338: astore 12
    //   1340: aload_0
    //   1341: aload_0
    //   1342: getfield 100	com/tencent/mm/plugin/voip/model/d:tul	I
    //   1345: bipush 8
    //   1347: ior
    //   1348: putfield 100	com/tencent/mm/plugin/voip/model/d:tul	I
    //   1351: ldc 168
    //   1353: new 156	java/lang/StringBuilder
    //   1356: dup
    //   1357: ldc_w 441
    //   1360: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1363: aload 13
    //   1365: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: ldc_w 443
    //   1371: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1374: aload 12
    //   1376: invokevirtual 446	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1379: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1382: invokestatic 258	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1385: aload_0
    //   1386: iconst_0
    //   1387: putfield 82	com/tencent/mm/plugin/voip/model/d:tue	Z
    //   1390: aload_0
    //   1391: invokespecial 448	com/tencent/mm/plugin/voip/model/d:cLM	()I
    //   1394: pop
    //   1395: ldc_w 263
    //   1398: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1401: iconst_m1
    //   1402: ireturn
    //   1403: aload_0
    //   1404: getfield 84	com/tencent/mm/plugin/voip/model/d:tuf	Z
    //   1407: ifne +8 -> 1415
    //   1410: aload_0
    //   1411: iconst_1
    //   1412: putfield 84	com/tencent/mm/plugin/voip/model/d:tuf	Z
    //   1415: aload_1
    //   1416: arraylength
    //   1417: istore_2
    //   1418: aload_1
    //   1419: iconst_4
    //   1420: baload
    //   1421: bipush 31
    //   1423: iand
    //   1424: istore 5
    //   1426: iload 5
    //   1428: bipush 7
    //   1430: if_icmpeq +10 -> 1440
    //   1433: iload 5
    //   1435: bipush 8
    //   1437: if_icmpne +95 -> 1532
    //   1440: bipush 83
    //   1442: istore 4
    //   1444: ldc 168
    //   1446: new 156	java/lang/StringBuilder
    //   1449: dup
    //   1450: ldc_w 450
    //   1453: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1456: iload_2
    //   1457: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1460: ldc_w 452
    //   1463: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: iload 5
    //   1468: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1471: ldc_w 454
    //   1474: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1477: iload 4
    //   1479: invokevirtual 457	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1482: ldc_w 459
    //   1485: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1488: aload_0
    //   1489: getfield 98	com/tencent/mm/plugin/voip/model/d:tuk	I
    //   1492: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1495: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1498: invokestatic 244	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1501: aload_0
    //   1502: getfield 86	com/tencent/mm/plugin/voip/model/d:tug	Z
    //   1505: ifeq +54 -> 1559
    //   1508: iload 4
    //   1510: bipush 80
    //   1512: if_icmpne +47 -> 1559
    //   1515: ldc 168
    //   1517: ldc_w 461
    //   1520: invokestatic 258	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1523: ldc_w 263
    //   1526: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1529: bipush 254
    //   1531: ireturn
    //   1532: iload 5
    //   1534: iconst_5
    //   1535: if_icmpeq +10 -> 1545
    //   1538: iload 5
    //   1540: bipush 6
    //   1542: if_icmpne +10 -> 1552
    //   1545: bipush 73
    //   1547: istore 4
    //   1549: goto -105 -> 1444
    //   1552: bipush 80
    //   1554: istore 4
    //   1556: goto -112 -> 1444
    //   1559: aload_0
    //   1560: getfield 123	com/tencent/mm/plugin/voip/model/d:mDecoder	Landroid/media/MediaCodec;
    //   1563: ldc2_w 462
    //   1566: invokevirtual 467	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   1569: istore 5
    //   1571: iload 5
    //   1573: iflt +212 -> 1785
    //   1576: aload_1
    //   1577: ifnull +186 -> 1763
    //   1580: iload_2
    //   1581: ifle +182 -> 1763
    //   1584: invokestatic 273	java/lang/System:currentTimeMillis	()J
    //   1587: lstore 10
    //   1589: ldc 168
    //   1591: new 156	java/lang/StringBuilder
    //   1594: dup
    //   1595: ldc_w 469
    //   1598: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1601: iload 5
    //   1603: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1606: ldc_w 471
    //   1609: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1612: iload_2
    //   1613: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1616: ldc_w 454
    //   1619: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1622: iload 4
    //   1624: invokevirtual 457	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1627: ldc_w 473
    //   1630: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1633: lload 10
    //   1635: invokevirtual 476	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1638: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1641: invokestatic 244	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1644: getstatic 481	android/os/Build$VERSION:SDK_INT	I
    //   1647: bipush 21
    //   1649: if_icmpge +122 -> 1771
    //   1652: aload_0
    //   1653: getfield 123	com/tencent/mm/plugin/voip/model/d:mDecoder	Landroid/media/MediaCodec;
    //   1656: invokevirtual 485	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   1659: iload 5
    //   1661: aaload
    //   1662: astore 12
    //   1664: aload 12
    //   1666: invokevirtual 489	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1669: pop
    //   1670: aload 12
    //   1672: invokevirtual 489	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1675: pop
    //   1676: aload 12
    //   1678: aload_1
    //   1679: iconst_0
    //   1680: iload_2
    //   1681: invokevirtual 492	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1684: pop
    //   1685: aload_0
    //   1686: getfield 123	com/tencent/mm/plugin/voip/model/d:mDecoder	Landroid/media/MediaCodec;
    //   1689: iload 5
    //   1691: iconst_0
    //   1692: iload_2
    //   1693: lload 10
    //   1695: iconst_0
    //   1696: invokevirtual 496	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   1699: aload_0
    //   1700: aload_0
    //   1701: getfield 98	com/tencent/mm/plugin/voip/model/d:tuk	I
    //   1704: iconst_1
    //   1705: iadd
    //   1706: putfield 98	com/tencent/mm/plugin/voip/model/d:tuk	I
    //   1709: aload_0
    //   1710: iconst_0
    //   1711: putfield 88	com/tencent/mm/plugin/voip/model/d:tuh	I
    //   1714: aload_0
    //   1715: getfield 86	com/tencent/mm/plugin/voip/model/d:tug	Z
    //   1718: ifeq +45 -> 1763
    //   1721: iconst_1
    //   1722: invokestatic 205	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1725: astore_1
    //   1726: aload_1
    //   1727: getstatic 211	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   1730: invokevirtual 215	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1733: pop
    //   1734: aload_1
    //   1735: iconst_0
    //   1736: invokevirtual 219	java/nio/ByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   1739: pop
    //   1740: aload_0
    //   1741: getfield 90	com/tencent/mm/plugin/voip/model/d:ttm	Lcom/tencent/mm/plugin/voip/model/k;
    //   1744: getfield 223	com/tencent/mm/plugin/voip/model/k:tvj	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1747: bipush 28
    //   1749: aload_1
    //   1750: invokevirtual 227	java/nio/ByteBuffer:array	()[B
    //   1753: iconst_1
    //   1754: invokevirtual 233	com/tencent/mm/plugin/voip/model/v2protocal:setAppCmd	(I[BI)I
    //   1757: pop
    //   1758: aload_0
    //   1759: iconst_0
    //   1760: putfield 86	com/tencent/mm/plugin/voip/model/d:tug	Z
    //   1763: ldc_w 263
    //   1766: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1769: iconst_0
    //   1770: ireturn
    //   1771: aload_0
    //   1772: getfield 123	com/tencent/mm/plugin/voip/model/d:mDecoder	Landroid/media/MediaCodec;
    //   1775: iload 5
    //   1777: invokevirtual 499	android/media/MediaCodec:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   1780: astore 12
    //   1782: goto -112 -> 1670
    //   1785: aload_0
    //   1786: getfield 86	com/tencent/mm/plugin/voip/model/d:tug	Z
    //   1789: ifeq +26 -> 1815
    //   1792: iload 4
    //   1794: bipush 80
    //   1796: if_icmpeq +19 -> 1815
    //   1799: aload_0
    //   1800: iconst_0
    //   1801: putfield 82	com/tencent/mm/plugin/voip/model/d:tue	Z
    //   1804: aload_0
    //   1805: aload_0
    //   1806: getfield 100	com/tencent/mm/plugin/voip/model/d:tul	I
    //   1809: bipush 32
    //   1811: ior
    //   1812: putfield 100	com/tencent/mm/plugin/voip/model/d:tul	I
    //   1815: aload_0
    //   1816: invokespecial 448	com/tencent/mm/plugin/voip/model/d:cLM	()I
    //   1819: pop
    //   1820: ldc 168
    //   1822: ldc_w 501
    //   1825: invokestatic 258	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1828: goto -65 -> 1763
    //   1831: iload 7
    //   1833: iload 9
    //   1835: iadd
    //   1836: istore 7
    //   1838: goto -836 -> 1002
    //   1841: iconst_0
    //   1842: istore 9
    //   1844: iload 7
    //   1846: istore 8
    //   1848: iload 9
    //   1850: istore 7
    //   1852: goto -850 -> 1002
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1855	0	this	d
    //   0	1855	1	paramArrayOfByte	byte[]
    //   0	1855	2	paramInt	int
    //   0	1855	3	paramBoolean	boolean
    //   1442	355	4	c	char
    //   97	1679	5	i	int
    //   107	1045	6	j	int
    //   936	915	7	k	int
    //   1081	766	8	m	int
    //   1040	809	9	n	int
    //   1587	107	10	l	long
    //   362	702	12	localObject1	Object
    //   1199	14	12	localIOException	IOException
    //   1229	15	12	localException1	Exception
    //   1260	25	12	localException2	Exception
    //   1333	1	12	localMediaFormat	MediaFormat
    //   1338	37	12	localException3	Exception
    //   1662	119	12	localByteBuffer	ByteBuffer
    //   443	921	13	localObject2	Object
    //   623	39	14	str	String
    // Exception table:
    //   from	to	target	type
    //   65	87	832	java/lang/Exception
    //   89	109	832	java/lang/Exception
    //   113	125	832	java/lang/Exception
    //   125	309	832	java/lang/Exception
    //   520	529	832	java/lang/Exception
    //   532	544	832	java/lang/Exception
    //   544	668	832	java/lang/Exception
    //   673	688	832	java/lang/Exception
    //   694	707	832	java/lang/Exception
    //   707	829	832	java/lang/Exception
    //   880	903	832	java/lang/Exception
    //   906	938	1156	java/lang/Exception
    //   941	957	1156	java/lang/Exception
    //   962	969	1156	java/lang/Exception
    //   976	993	1156	java/lang/Exception
    //   1002	1057	1156	java/lang/Exception
    //   1063	1081	1156	java/lang/Exception
    //   1090	1134	1156	java/lang/Exception
    //   1144	1149	1156	java/lang/Exception
    //   324	335	1199	java/io/IOException
    //   369	388	1229	java/lang/Exception
    //   339	364	1260	java/lang/Exception
    //   388	409	1260	java/lang/Exception
    //   409	465	1260	java/lang/Exception
    //   496	512	1260	java/lang/Exception
    //   1231	1257	1260	java/lang/Exception
    //   1321	1335	1260	java/lang/Exception
    //   1340	1395	1260	java/lang/Exception
    //   465	496	1338	java/lang/Exception
  }
  
  @SuppressLint({"NewApi"})
  public final void run()
  {
    AppMethodBeat.i(4338);
    if ((!Thread.interrupted()) && (this.tue)) {
      if ((this.mDecoder == null) || (!this.tud) || (!this.tuf)) {}
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
          i = this.mDecoder.dequeueOutputBuffer(localBufferInfo, 10000L);
          ab.d("MeidaCodec[HWDec]", "steve:  outIndex=".concat(String.valueOf(i)));
          switch (i)
          {
          case -3: 
            if (localBufferInfo.size <= 0) {
              break label419;
            }
            long l1 = localBufferInfo.presentationTimeUs;
            long l2 = System.currentTimeMillis();
            ab.d("MeidaCodec[HWDec]", "DECODER_THREAD:: decoded SUCCESSFULLY!!! cnt : " + this.tuj + ", size:" + localBufferInfo.size + ", pts:" + localBufferInfo.presentationTimeUs + ", latency:" + (l2 - l1));
            this.tuj += 1;
            this.mDecoder.releaseOutputBuffer(i, true);
            l2 = System.currentTimeMillis();
            ab.d("MeidaCodec[HWDec]", "steve: Avcdecoder frame processTime = " + (l2 - l1) + ", decFrameCnt=" + this.tuj + ", endTime=" + l2);
          }
        }
        catch (Exception localException1)
        {
          this.tue = false;
          this.tul |= 0x80;
          cLM();
          ab.e("MeidaCodec[HWDec]", " dequeueOutputBuffer/releaseOutputBuffer error:" + localException1.toString());
        }
        break;
        ab.d("MeidaCodec[HWDec]", "INFO_OUTPUT_BUFFERS_CHANGED");
        break;
        Object localObject = this.mDecoder.getOutputFormat();
        ab.i("MeidaCodec[HWDec]", "DECODER_THREAD:: New format : ".concat(String.valueOf(localObject)));
        int i = ((MediaFormat)localObject).getInteger("width");
        int j = ((MediaFormat)localObject).getInteger("height");
        if (this.ttm == null) {
          break;
        }
        localObject = this.ttm;
        ((k)localObject).mHandler.post(new k.9((k)localObject, j, i));
        break;
        ab.d("MeidaCodec[HWDec]", "DECODER_THREAD:: dequeueOutputBuffer timed out!");
        break;
        label419:
        ab.d("MeidaCodec[HWDec]", "steve: drop frame: " + this.tuj + ", size:" + ((MediaCodec.BufferInfo)localObject).size + ", pts:" + ((MediaCodec.BufferInfo)localObject).presentationTimeUs);
        this.mDecoder.releaseOutputBuffer(i, false);
        break;
        try
        {
          Thread.sleep(20L);
        }
        catch (InterruptedException localInterruptedException)
        {
          ab.e("MeidaCodec[HWDec]", " error:" + localInterruptedException.toString());
        }
      }
      break;
      if ((!this.tue) && (this.mDecoder != null)) {
        try
        {
          this.mDecoder.stop();
          this.mDecoder.release();
          this.mDecoder = null;
          AppMethodBeat.o(4338);
          return;
        }
        catch (Exception localException2)
        {
          ab.e("MeidaCodec[HWDec]", " decoder stop  error:" + localException2.toString());
        }
      }
      AppMethodBeat.o(4338);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.d
 * JD-Core Version:    0.7.0.1
 */