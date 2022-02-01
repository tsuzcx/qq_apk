package com.tencent.mm.plugin.voip.model;

import android.annotation.SuppressLint;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class d
  extends Thread
{
  public static int zgk;
  private static String zgl;
  public static byte[] zgo;
  public static byte[] zgp;
  public static byte[] zgq;
  public static int zgs;
  public static int zgt;
  public byte[] configbyte;
  private BufferedOutputStream outputStream;
  private Surface surface;
  l zfA;
  public int zgA;
  public int zgB;
  public int zgC;
  public byte[] zgD;
  public byte[] zgE;
  public byte[] zgF;
  private BufferedOutputStream zgm;
  private z zgn;
  private boolean zgr;
  private boolean zgu;
  public boolean zgv;
  public boolean zgw;
  public boolean zgx;
  public int zgy;
  public byte[] zgz;
  
  static
  {
    AppMethodBeat.i(177014);
    zgk = 64;
    zgl = b.aih();
    zgo = null;
    zgp = null;
    zgq = null;
    zgs = 640;
    zgt = 480;
    AppMethodBeat.o(177014);
  }
  
  public d(Surface paramSurface)
  {
    AppMethodBeat.i(114825);
    this.outputStream = null;
    this.zgm = null;
    this.configbyte = null;
    this.zgr = false;
    this.zgu = false;
    this.zgv = true;
    this.zgw = true;
    this.zgx = false;
    this.zgy = 0;
    this.zfA = null;
    this.zgz = new byte[] { 0, 0, 0, 1 };
    this.zgA = 0;
    this.zgB = 0;
    this.zgC = 0;
    this.zgD = new byte[] { 103, 100, 0, 13, -84, -74, 10, 15, -120 };
    this.zgE = new byte[] { 0, 0, 0, 1, 40, -50, 60, 48 };
    this.zgF = new byte[] { 13, 0, -15, 98, -22 };
    this.zgv = true;
    this.zgw = true;
    this.zgn = null;
    this.zgr = false;
    this.zgC = 0;
    if (paramSurface != null) {
      this.surface = paramSurface;
    }
    AppMethodBeat.o(114825);
  }
  
  private static String bF(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114828);
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
    AppMethodBeat.o(114828);
    return str1;
  }
  
  private int dRY()
  {
    AppMethodBeat.i(114827);
    this.zgy += 1;
    ad.i("MeidaCodec[HWDec]", "[HW]:DecFrmError: I Req mIReqFlag = " + this.zgx + ", mIsHWDecEnable = " + this.zgv + ", mHWErrorDecFrmCount = " + this.zgy);
    if ((!this.zgv) || (this.zgy > zgk))
    {
      dRZ();
      this.zfA.rz(true);
      this.zgC |= 0x40;
      ad.i("MeidaCodec[HWDec]", "[HW]: ErrFrm > threshold, end HWDec!!");
      AppMethodBeat.o(114827);
      return 0;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(1);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.put((byte)1);
    this.zfA.ziZ.setAppCmd(28, localByteBuffer.array(), 1);
    this.zgx = true;
    AppMethodBeat.o(114827);
    return 1;
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(114826);
    this.zfA = paraml;
    ad.i("MeidaCodec[HWDec]", "setStrategyCaller");
    AppMethodBeat.o(114826);
  }
  
  public final void dRZ()
  {
    AppMethodBeat.i(114831);
    this.zgv = false;
    this.zgw = false;
    this.zgy = 0;
    ad.d("MeidaCodec[HWDec]", "steve: Stop Decode Thread!");
    try
    {
      if (this.outputStream != null)
      {
        this.outputStream.flush();
        this.outputStream.close();
      }
      if (this.zgm != null)
      {
        this.zgm.flush();
        this.zgm.close();
      }
      AppMethodBeat.o(114831);
      return;
    }
    catch (IOException localIOException)
    {
      ad.e("MeidaCodec[HWDec]", " error:" + localIOException.toString());
      AppMethodBeat.o(114831);
    }
  }
  
  /* Error */
  public final int f(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 269
    //   3: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 88	com/tencent/mm/plugin/voip/model/d:zgv	Z
    //   10: ifne +30 -> 40
    //   13: aload_0
    //   14: aload_0
    //   15: getfield 106	com/tencent/mm/plugin/voip/model/d:zgC	I
    //   18: iconst_1
    //   19: ior
    //   20: putfield 106	com/tencent/mm/plugin/voip/model/d:zgC	I
    //   23: ldc_w 271
    //   26: ldc_w 273
    //   29: invokestatic 250	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: ldc_w 269
    //   35: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: iconst_m1
    //   39: ireturn
    //   40: iload_3
    //   41: ifeq +15 -> 56
    //   44: aload_0
    //   45: getfield 129	com/tencent/mm/plugin/voip/model/d:zgn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   48: ifnull +8 -> 56
    //   51: aload_0
    //   52: iconst_0
    //   53: putfield 86	com/tencent/mm/plugin/voip/model/d:zgu	Z
    //   56: invokestatic 279	java/lang/System:currentTimeMillis	()J
    //   59: pop2
    //   60: aconst_null
    //   61: astore 12
    //   63: iload_2
    //   64: iconst_2
    //   65: if_icmpne +845 -> 910
    //   68: new 281	com/tencent/mm/protocal/protobuf/bfg
    //   71: dup
    //   72: invokespecial 282	com/tencent/mm/protocal/protobuf/bfg:<init>	()V
    //   75: aload_1
    //   76: invokevirtual 286	com/tencent/mm/protocal/protobuf/bfg:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   79: checkcast 281	com/tencent/mm/protocal/protobuf/bfg
    //   82: astore_1
    //   83: aload_1
    //   84: getfield 290	com/tencent/mm/protocal/protobuf/bfg:DCt	Lcom/tencent/mm/bx/b;
    //   87: ifnonnull +436 -> 523
    //   90: iconst_0
    //   91: istore_2
    //   92: aload_1
    //   93: getfield 293	com/tencent/mm/protocal/protobuf/bfg:DCr	Lcom/tencent/mm/bx/b;
    //   96: getfield 298	com/tencent/mm/bx/b:wA	[B
    //   99: arraylength
    //   100: istore 5
    //   102: aload_1
    //   103: getfield 301	com/tencent/mm/protocal/protobuf/bfg:DCs	Lcom/tencent/mm/bx/b;
    //   106: getfield 298	com/tencent/mm/bx/b:wA	[B
    //   109: arraylength
    //   110: istore 6
    //   112: iload_2
    //   113: ifeq +422 -> 535
    //   116: aload_0
    //   117: getfield 84	com/tencent/mm/plugin/voip/model/d:zgr	Z
    //   120: ifne +8 -> 128
    //   123: aload_0
    //   124: iconst_0
    //   125: putfield 86	com/tencent/mm/plugin/voip/model/d:zgu	Z
    //   128: aload_0
    //   129: iconst_1
    //   130: putfield 84	com/tencent/mm/plugin/voip/model/d:zgr	Z
    //   133: iload_2
    //   134: iconst_4
    //   135: iadd
    //   136: newarray byte
    //   138: putstatic 59	com/tencent/mm/plugin/voip/model/d:zgo	[B
    //   141: iload 5
    //   143: iconst_4
    //   144: iadd
    //   145: newarray byte
    //   147: putstatic 61	com/tencent/mm/plugin/voip/model/d:zgp	[B
    //   150: iload 6
    //   152: iconst_4
    //   153: iadd
    //   154: newarray byte
    //   156: putstatic 63	com/tencent/mm/plugin/voip/model/d:zgq	[B
    //   159: aload_0
    //   160: getfield 100	com/tencent/mm/plugin/voip/model/d:zgz	[B
    //   163: iconst_0
    //   164: getstatic 59	com/tencent/mm/plugin/voip/model/d:zgo	[B
    //   167: iconst_0
    //   168: iconst_4
    //   169: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   172: aload_0
    //   173: getfield 100	com/tencent/mm/plugin/voip/model/d:zgz	[B
    //   176: iconst_0
    //   177: getstatic 61	com/tencent/mm/plugin/voip/model/d:zgp	[B
    //   180: iconst_0
    //   181: iconst_4
    //   182: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   185: aload_0
    //   186: getfield 100	com/tencent/mm/plugin/voip/model/d:zgz	[B
    //   189: iconst_0
    //   190: getstatic 63	com/tencent/mm/plugin/voip/model/d:zgq	[B
    //   193: iconst_0
    //   194: iconst_4
    //   195: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   198: aload_1
    //   199: getfield 290	com/tencent/mm/protocal/protobuf/bfg:DCt	Lcom/tencent/mm/bx/b;
    //   202: getstatic 59	com/tencent/mm/plugin/voip/model/d:zgo	[B
    //   205: invokevirtual 309	com/tencent/mm/bx/b:ce	([B)V
    //   208: aload_1
    //   209: getfield 293	com/tencent/mm/protocal/protobuf/bfg:DCr	Lcom/tencent/mm/bx/b;
    //   212: getstatic 61	com/tencent/mm/plugin/voip/model/d:zgp	[B
    //   215: invokevirtual 309	com/tencent/mm/bx/b:ce	([B)V
    //   218: aload_1
    //   219: getfield 301	com/tencent/mm/protocal/protobuf/bfg:DCs	Lcom/tencent/mm/bx/b;
    //   222: getstatic 63	com/tencent/mm/plugin/voip/model/d:zgq	[B
    //   225: invokevirtual 309	com/tencent/mm/bx/b:ce	([B)V
    //   228: aload_0
    //   229: getstatic 59	com/tencent/mm/plugin/voip/model/d:zgo	[B
    //   232: arraylength
    //   233: getstatic 61	com/tencent/mm/plugin/voip/model/d:zgp	[B
    //   236: arraylength
    //   237: iadd
    //   238: getstatic 63	com/tencent/mm/plugin/voip/model/d:zgq	[B
    //   241: arraylength
    //   242: iadd
    //   243: newarray byte
    //   245: putfield 82	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   248: getstatic 59	com/tencent/mm/plugin/voip/model/d:zgo	[B
    //   251: iconst_0
    //   252: aload_0
    //   253: getfield 82	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   256: iconst_0
    //   257: getstatic 59	com/tencent/mm/plugin/voip/model/d:zgo	[B
    //   260: arraylength
    //   261: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   264: getstatic 59	com/tencent/mm/plugin/voip/model/d:zgo	[B
    //   267: arraylength
    //   268: iconst_0
    //   269: iadd
    //   270: istore_2
    //   271: getstatic 61	com/tencent/mm/plugin/voip/model/d:zgp	[B
    //   274: iconst_0
    //   275: aload_0
    //   276: getfield 82	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   279: iload_2
    //   280: getstatic 61	com/tencent/mm/plugin/voip/model/d:zgp	[B
    //   283: arraylength
    //   284: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   287: getstatic 61	com/tencent/mm/plugin/voip/model/d:zgp	[B
    //   290: arraylength
    //   291: istore 5
    //   293: getstatic 63	com/tencent/mm/plugin/voip/model/d:zgq	[B
    //   296: iconst_0
    //   297: aload_0
    //   298: getfield 82	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   301: iload_2
    //   302: iload 5
    //   304: iadd
    //   305: getstatic 63	com/tencent/mm/plugin/voip/model/d:zgq	[B
    //   308: arraylength
    //   309: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   312: iconst_1
    //   313: istore_2
    //   314: aload 12
    //   316: astore_1
    //   317: aload_1
    //   318: ifnull +21 -> 339
    //   321: aload_0
    //   322: getfield 80	com/tencent/mm/plugin/voip/model/d:zgm	Ljava/io/BufferedOutputStream;
    //   325: ifnull +14 -> 339
    //   328: aload_0
    //   329: getfield 80	com/tencent/mm/plugin/voip/model/d:zgm	Ljava/io/BufferedOutputStream;
    //   332: aload_1
    //   333: iconst_0
    //   334: aload_1
    //   335: arraylength
    //   336: invokevirtual 313	java/io/BufferedOutputStream:write	([BII)V
    //   339: iload_2
    //   340: ifeq +965 -> 1305
    //   343: getstatic 61	com/tencent/mm/plugin/voip/model/d:zgp	[B
    //   346: ifnull +959 -> 1305
    //   349: getstatic 63	com/tencent/mm/plugin/voip/model/d:zgq	[B
    //   352: ifnull +953 -> 1305
    //   355: aload_0
    //   356: getfield 86	com/tencent/mm/plugin/voip/model/d:zgu	Z
    //   359: ifne +156 -> 515
    //   362: aload_0
    //   363: getfield 129	com/tencent/mm/plugin/voip/model/d:zgn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   366: astore 12
    //   368: aload 12
    //   370: ifnull +22 -> 392
    //   373: aload_0
    //   374: getfield 129	com/tencent/mm/plugin/voip/model/d:zgn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   377: invokevirtual 318	com/tencent/mm/compatible/deviceinfo/z:stop	()V
    //   380: aload_0
    //   381: getfield 129	com/tencent/mm/plugin/voip/model/d:zgn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   384: invokevirtual 321	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   387: aload_0
    //   388: aconst_null
    //   389: putfield 129	com/tencent/mm/plugin/voip/model/d:zgn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   392: aload_0
    //   393: getfield 84	com/tencent/mm/plugin/voip/model/d:zgr	Z
    //   396: ifeq +932 -> 1328
    //   399: ldc_w 323
    //   402: getstatic 65	com/tencent/mm/plugin/voip/model/d:zgs	I
    //   405: getstatic 67	com/tencent/mm/plugin/voip/model/d:zgt	I
    //   408: invokestatic 329	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   411: astore 12
    //   413: aload 12
    //   415: ldc_w 331
    //   418: bipush 90
    //   420: invokevirtual 335	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   423: ldc 172
    //   425: ldc_w 337
    //   428: aload 12
    //   430: invokestatic 154	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   433: invokevirtual 158	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   436: invokestatic 192	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: aload 12
    //   441: ldc_w 339
    //   444: invokevirtual 342	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   447: astore 13
    //   449: aload 13
    //   451: ldc_w 344
    //   454: invokevirtual 348	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   457: ifeq +58 -> 515
    //   460: aload_0
    //   461: aload 13
    //   463: invokestatic 352	com/tencent/mm/compatible/deviceinfo/z:pl	(Ljava/lang/String;)Lcom/tencent/mm/compatible/deviceinfo/z;
    //   466: putfield 129	com/tencent/mm/plugin/voip/model/d:zgn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   469: ldc 172
    //   471: ldc_w 354
    //   474: aload 12
    //   476: invokestatic 154	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   479: invokevirtual 158	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   482: invokestatic 250	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   485: aload_0
    //   486: getfield 129	com/tencent/mm/plugin/voip/model/d:zgn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   489: aload 12
    //   491: aload_0
    //   492: getfield 131	com/tencent/mm/plugin/voip/model/d:surface	Landroid/view/Surface;
    //   495: iconst_0
    //   496: invokevirtual 357	com/tencent/mm/compatible/deviceinfo/z:a	(Landroid/media/MediaFormat;Landroid/view/Surface;I)V
    //   499: aload_0
    //   500: getfield 129	com/tencent/mm/plugin/voip/model/d:zgn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   503: invokevirtual 360	com/tencent/mm/compatible/deviceinfo/z:start	()V
    //   506: aload_0
    //   507: iconst_1
    //   508: putfield 86	com/tencent/mm/plugin/voip/model/d:zgu	Z
    //   511: aload_0
    //   512: invokevirtual 361	com/tencent/mm/plugin/voip/model/d:start	()V
    //   515: ldc_w 269
    //   518: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   521: iconst_1
    //   522: ireturn
    //   523: aload_1
    //   524: getfield 290	com/tencent/mm/protocal/protobuf/bfg:DCt	Lcom/tencent/mm/bx/b;
    //   527: getfield 298	com/tencent/mm/bx/b:wA	[B
    //   530: arraylength
    //   531: istore_2
    //   532: goto -440 -> 92
    //   535: aload_0
    //   536: getfield 84	com/tencent/mm/plugin/voip/model/d:zgr	Z
    //   539: ifeq +8 -> 547
    //   542: aload_0
    //   543: iconst_0
    //   544: putfield 86	com/tencent/mm/plugin/voip/model/d:zgu	Z
    //   547: aload_0
    //   548: iconst_0
    //   549: putfield 84	com/tencent/mm/plugin/voip/model/d:zgr	Z
    //   552: iload 5
    //   554: iconst_4
    //   555: iadd
    //   556: newarray byte
    //   558: astore 13
    //   560: aload_0
    //   561: getfield 100	com/tencent/mm/plugin/voip/model/d:zgz	[B
    //   564: iconst_0
    //   565: aload 13
    //   567: iconst_0
    //   568: iconst_4
    //   569: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   572: aload_1
    //   573: getfield 293	com/tencent/mm/protocal/protobuf/bfg:DCr	Lcom/tencent/mm/bx/b;
    //   576: aload 13
    //   578: invokevirtual 309	com/tencent/mm/bx/b:ce	([B)V
    //   581: ldc 172
    //   583: ldc_w 363
    //   586: aload 13
    //   588: invokestatic 154	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   591: invokevirtual 158	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   594: invokestatic 250	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   597: aload 13
    //   599: invokestatic 365	com/tencent/mm/plugin/voip/model/d:bF	([B)Ljava/lang/String;
    //   602: astore 14
    //   604: iconst_3
    //   605: newarray byte
    //   607: dup
    //   608: iconst_0
    //   609: ldc 97
    //   611: bastore
    //   612: dup
    //   613: iconst_1
    //   614: ldc 97
    //   616: bastore
    //   617: dup
    //   618: iconst_2
    //   619: ldc_w 366
    //   622: bastore
    //   623: invokestatic 365	com/tencent/mm/plugin/voip/model/d:bF	([B)Ljava/lang/String;
    //   626: astore 15
    //   628: ldc 172
    //   630: new 160	java/lang/StringBuilder
    //   633: dup
    //   634: ldc_w 368
    //   637: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   640: aload 14
    //   642: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: ldc_w 370
    //   648: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: aload 15
    //   653: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   659: invokestatic 250	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   662: aload 14
    //   664: aload 15
    //   666: iconst_0
    //   667: invokevirtual 374	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   670: istore_2
    //   671: iload_2
    //   672: iconst_m1
    //   673: if_icmpeq +206 -> 879
    //   676: ldc 172
    //   678: ldc_w 376
    //   681: iload_2
    //   682: invokestatic 378	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   685: invokevirtual 158	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   688: invokestatic 250	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   691: iconst_1
    //   692: istore_2
    //   693: iload_2
    //   694: ifeq +190 -> 884
    //   697: ldc 172
    //   699: ldc_w 380
    //   702: invokestatic 192	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   705: aload 13
    //   707: putstatic 61	com/tencent/mm/plugin/voip/model/d:zgp	[B
    //   710: ldc 172
    //   712: new 160	java/lang/StringBuilder
    //   715: dup
    //   716: ldc_w 382
    //   719: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   722: getstatic 61	com/tencent/mm/plugin/voip/model/d:zgp	[B
    //   725: arraylength
    //   726: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   729: ldc_w 384
    //   732: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: iload 5
    //   737: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   740: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   743: invokestatic 250	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   746: iload 6
    //   748: iconst_4
    //   749: iadd
    //   750: newarray byte
    //   752: putstatic 63	com/tencent/mm/plugin/voip/model/d:zgq	[B
    //   755: aload_0
    //   756: getfield 100	com/tencent/mm/plugin/voip/model/d:zgz	[B
    //   759: iconst_0
    //   760: getstatic 63	com/tencent/mm/plugin/voip/model/d:zgq	[B
    //   763: iconst_0
    //   764: iconst_4
    //   765: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   768: aload_1
    //   769: getfield 301	com/tencent/mm/protocal/protobuf/bfg:DCs	Lcom/tencent/mm/bx/b;
    //   772: getstatic 63	com/tencent/mm/plugin/voip/model/d:zgq	[B
    //   775: invokevirtual 309	com/tencent/mm/bx/b:ce	([B)V
    //   778: aload_0
    //   779: getstatic 61	com/tencent/mm/plugin/voip/model/d:zgp	[B
    //   782: arraylength
    //   783: getstatic 63	com/tencent/mm/plugin/voip/model/d:zgq	[B
    //   786: arraylength
    //   787: iadd
    //   788: newarray byte
    //   790: putfield 82	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   793: getstatic 61	com/tencent/mm/plugin/voip/model/d:zgp	[B
    //   796: iconst_0
    //   797: aload_0
    //   798: getfield 82	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   801: iconst_0
    //   802: getstatic 61	com/tencent/mm/plugin/voip/model/d:zgp	[B
    //   805: arraylength
    //   806: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   809: getstatic 61	com/tencent/mm/plugin/voip/model/d:zgp	[B
    //   812: arraylength
    //   813: istore_2
    //   814: getstatic 63	com/tencent/mm/plugin/voip/model/d:zgq	[B
    //   817: iconst_0
    //   818: aload_0
    //   819: getfield 82	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   822: iload_2
    //   823: iconst_0
    //   824: iadd
    //   825: getstatic 63	com/tencent/mm/plugin/voip/model/d:zgq	[B
    //   828: arraylength
    //   829: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   832: goto -520 -> 312
    //   835: astore_1
    //   836: aload_0
    //   837: aload_0
    //   838: getfield 106	com/tencent/mm/plugin/voip/model/d:zgC	I
    //   841: iconst_2
    //   842: ior
    //   843: putfield 106	com/tencent/mm/plugin/voip/model/d:zgC	I
    //   846: ldc 172
    //   848: new 160	java/lang/StringBuilder
    //   851: dup
    //   852: ldc_w 386
    //   855: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   858: aload_1
    //   859: invokevirtual 387	java/lang/Exception:toString	()Ljava/lang/String;
    //   862: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   865: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   868: invokestatic 264	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   871: iconst_0
    //   872: istore_2
    //   873: aload 12
    //   875: astore_1
    //   876: goto -559 -> 317
    //   879: iconst_0
    //   880: istore_2
    //   881: goto -188 -> 693
    //   884: new 389	com/tencent/mm/plugin/voip/model/g
    //   887: dup
    //   888: invokespecial 390	com/tencent/mm/plugin/voip/model/g:<init>	()V
    //   891: pop
    //   892: new 392	java/io/ByteArrayInputStream
    //   895: dup
    //   896: aload 13
    //   898: invokespecial 394	java/io/ByteArrayInputStream:<init>	([B)V
    //   901: invokestatic 398	com/tencent/mm/plugin/voip/model/g:K	(Ljava/io/InputStream;)[B
    //   904: putstatic 61	com/tencent/mm/plugin/voip/model/d:zgp	[B
    //   907: goto -197 -> 710
    //   910: new 400	com/tencent/mm/protocal/protobuf/bff
    //   913: dup
    //   914: invokespecial 401	com/tencent/mm/protocal/protobuf/bff:<init>	()V
    //   917: aload_1
    //   918: invokevirtual 402	com/tencent/mm/protocal/protobuf/bff:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   921: checkcast 400	com/tencent/mm/protocal/protobuf/bff
    //   924: astore 13
    //   926: aload 13
    //   928: getfield 406	com/tencent/mm/protocal/protobuf/bff:DCp	Ljava/util/LinkedList;
    //   931: invokevirtual 412	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   934: checkcast 138	java/lang/Integer
    //   937: invokevirtual 415	java/lang/Integer:intValue	()I
    //   940: istore 7
    //   942: iconst_0
    //   943: istore 5
    //   945: ldc 172
    //   947: ldc_w 417
    //   950: iload 7
    //   952: invokestatic 378	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   955: invokevirtual 158	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   958: invokestatic 250	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   961: iload_2
    //   962: iconst_1
    //   963: if_icmpne +185 -> 1148
    //   966: aload_0
    //   967: getfield 82	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   970: arraylength
    //   971: istore 5
    //   973: iload 7
    //   975: iload 5
    //   977: iadd
    //   978: istore 6
    //   980: iload 6
    //   982: newarray byte
    //   984: astore_1
    //   985: aload_0
    //   986: getfield 82	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   989: iconst_0
    //   990: aload_1
    //   991: iconst_0
    //   992: iload 5
    //   994: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   997: iload 5
    //   999: iconst_0
    //   1000: iadd
    //   1001: istore 5
    //   1003: goto +844 -> 1847
    //   1006: iconst_4
    //   1007: invokestatic 209	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1010: astore 14
    //   1012: aload 13
    //   1014: getfield 420	com/tencent/mm/protocal/protobuf/bff:DCm	Lcom/tencent/mm/bx/b;
    //   1017: aload 14
    //   1019: invokevirtual 231	java/nio/ByteBuffer:array	()[B
    //   1022: iload 7
    //   1024: iconst_0
    //   1025: iconst_4
    //   1026: invokevirtual 424	com/tencent/mm/bx/b:h	([BIII)V
    //   1029: aload 14
    //   1031: getstatic 427	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   1034: invokevirtual 219	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1037: pop
    //   1038: aload 14
    //   1040: iconst_0
    //   1041: invokevirtual 431	java/nio/ByteBuffer:getInt	(I)I
    //   1044: istore 9
    //   1046: aload_0
    //   1047: getfield 100	com/tencent/mm/plugin/voip/model/d:zgz	[B
    //   1050: iconst_0
    //   1051: aload_1
    //   1052: iload 7
    //   1054: iload 5
    //   1056: iadd
    //   1057: iconst_4
    //   1058: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1061: iload 7
    //   1063: iconst_4
    //   1064: iadd
    //   1065: istore 7
    //   1067: aload 13
    //   1069: getfield 420	com/tencent/mm/protocal/protobuf/bff:DCm	Lcom/tencent/mm/bx/b;
    //   1072: aload_1
    //   1073: iload 7
    //   1075: iload 7
    //   1077: iload 5
    //   1079: iadd
    //   1080: iload 9
    //   1082: invokevirtual 424	com/tencent/mm/bx/b:h	([BIII)V
    //   1085: iload 8
    //   1087: iload 9
    //   1089: iconst_4
    //   1090: iadd
    //   1091: isub
    //   1092: istore 8
    //   1094: ldc 172
    //   1096: new 160	java/lang/StringBuilder
    //   1099: dup
    //   1100: ldc_w 433
    //   1103: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1106: iload 9
    //   1108: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1111: ldc_w 435
    //   1114: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1117: iload 6
    //   1119: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1122: ldc_w 437
    //   1125: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1128: iload_2
    //   1129: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1132: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1135: invokestatic 250	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1138: iload 8
    //   1140: ifgt +697 -> 1837
    //   1143: iconst_0
    //   1144: istore_2
    //   1145: goto -828 -> 317
    //   1148: iload 7
    //   1150: newarray byte
    //   1152: astore_1
    //   1153: iload 7
    //   1155: istore 6
    //   1157: goto +690 -> 1847
    //   1160: astore_1
    //   1161: aload_0
    //   1162: aload_0
    //   1163: getfield 106	com/tencent/mm/plugin/voip/model/d:zgC	I
    //   1166: iconst_4
    //   1167: ior
    //   1168: putfield 106	com/tencent/mm/plugin/voip/model/d:zgC	I
    //   1171: ldc 172
    //   1173: new 160	java/lang/StringBuilder
    //   1176: dup
    //   1177: ldc_w 439
    //   1180: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1183: aload_1
    //   1184: invokevirtual 387	java/lang/Exception:toString	()Ljava/lang/String;
    //   1187: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1190: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1193: invokestatic 264	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1196: iconst_0
    //   1197: istore_2
    //   1198: aload 12
    //   1200: astore_1
    //   1201: goto -884 -> 317
    //   1204: astore 12
    //   1206: ldc 172
    //   1208: new 160	java/lang/StringBuilder
    //   1211: dup
    //   1212: ldc_w 260
    //   1215: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1218: aload 12
    //   1220: invokevirtual 261	java/io/IOException:toString	()Ljava/lang/String;
    //   1223: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1229: invokestatic 264	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1232: goto -893 -> 339
    //   1235: astore 12
    //   1237: ldc 172
    //   1239: new 160	java/lang/StringBuilder
    //   1242: dup
    //   1243: ldc_w 441
    //   1246: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1249: aload 12
    //   1251: invokevirtual 387	java/lang/Exception:toString	()Ljava/lang/String;
    //   1254: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1260: invokestatic 264	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1263: goto -871 -> 392
    //   1266: astore 12
    //   1268: aload_0
    //   1269: aload_0
    //   1270: getfield 106	com/tencent/mm/plugin/voip/model/d:zgC	I
    //   1273: bipush 16
    //   1275: ior
    //   1276: putfield 106	com/tencent/mm/plugin/voip/model/d:zgC	I
    //   1279: ldc 172
    //   1281: new 160	java/lang/StringBuilder
    //   1284: dup
    //   1285: ldc_w 260
    //   1288: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1291: aload 12
    //   1293: invokevirtual 387	java/lang/Exception:toString	()Ljava/lang/String;
    //   1296: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1302: invokestatic 264	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1305: aload_0
    //   1306: getfield 86	com/tencent/mm/plugin/voip/model/d:zgu	Z
    //   1309: ifne +101 -> 1410
    //   1312: ldc 172
    //   1314: ldc_w 443
    //   1317: invokestatic 264	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1320: ldc_w 269
    //   1323: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1326: iconst_m1
    //   1327: ireturn
    //   1328: ldc_w 445
    //   1331: getstatic 65	com/tencent/mm/plugin/voip/model/d:zgs	I
    //   1334: getstatic 67	com/tencent/mm/plugin/voip/model/d:zgt	I
    //   1337: invokestatic 329	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   1340: astore 12
    //   1342: goto -929 -> 413
    //   1345: astore 12
    //   1347: aload_0
    //   1348: aload_0
    //   1349: getfield 106	com/tencent/mm/plugin/voip/model/d:zgC	I
    //   1352: bipush 8
    //   1354: ior
    //   1355: putfield 106	com/tencent/mm/plugin/voip/model/d:zgC	I
    //   1358: ldc 172
    //   1360: new 160	java/lang/StringBuilder
    //   1363: dup
    //   1364: ldc_w 447
    //   1367: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1370: aload 13
    //   1372: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1375: ldc_w 449
    //   1378: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1381: aload 12
    //   1383: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1386: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1389: invokestatic 264	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1392: aload_0
    //   1393: iconst_0
    //   1394: putfield 88	com/tencent/mm/plugin/voip/model/d:zgv	Z
    //   1397: aload_0
    //   1398: invokespecial 454	com/tencent/mm/plugin/voip/model/d:dRY	()I
    //   1401: pop
    //   1402: ldc_w 269
    //   1405: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1408: iconst_m1
    //   1409: ireturn
    //   1410: aload_0
    //   1411: getfield 90	com/tencent/mm/plugin/voip/model/d:zgw	Z
    //   1414: ifne +8 -> 1422
    //   1417: aload_0
    //   1418: iconst_1
    //   1419: putfield 90	com/tencent/mm/plugin/voip/model/d:zgw	Z
    //   1422: aload_1
    //   1423: arraylength
    //   1424: istore_2
    //   1425: aload_1
    //   1426: iconst_4
    //   1427: baload
    //   1428: bipush 31
    //   1430: iand
    //   1431: istore 5
    //   1433: iload 5
    //   1435: bipush 7
    //   1437: if_icmpeq +10 -> 1447
    //   1440: iload 5
    //   1442: bipush 8
    //   1444: if_icmpne +95 -> 1539
    //   1447: bipush 83
    //   1449: istore 4
    //   1451: ldc 172
    //   1453: new 160	java/lang/StringBuilder
    //   1456: dup
    //   1457: ldc_w 456
    //   1460: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1463: iload_2
    //   1464: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1467: ldc_w 458
    //   1470: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1473: iload 5
    //   1475: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1478: ldc_w 460
    //   1481: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1484: iload 4
    //   1486: invokevirtual 463	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1489: ldc_w 465
    //   1492: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: aload_0
    //   1496: getfield 104	com/tencent/mm/plugin/voip/model/d:zgB	I
    //   1499: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1502: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1505: invokestatic 250	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1508: aload_0
    //   1509: getfield 92	com/tencent/mm/plugin/voip/model/d:zgx	Z
    //   1512: ifeq +54 -> 1566
    //   1515: iload 4
    //   1517: bipush 80
    //   1519: if_icmpne +47 -> 1566
    //   1522: ldc 172
    //   1524: ldc_w 467
    //   1527: invokestatic 264	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1530: ldc_w 269
    //   1533: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1536: bipush 254
    //   1538: ireturn
    //   1539: iload 5
    //   1541: iconst_5
    //   1542: if_icmpeq +10 -> 1552
    //   1545: iload 5
    //   1547: bipush 6
    //   1549: if_icmpne +10 -> 1559
    //   1552: bipush 73
    //   1554: istore 4
    //   1556: goto -105 -> 1451
    //   1559: bipush 80
    //   1561: istore 4
    //   1563: goto -112 -> 1451
    //   1566: aload_0
    //   1567: getfield 129	com/tencent/mm/plugin/voip/model/d:zgn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1570: ldc2_w 468
    //   1573: invokevirtual 473	com/tencent/mm/compatible/deviceinfo/z:dequeueInputBuffer	(J)I
    //   1576: istore 5
    //   1578: iload 5
    //   1580: iflt +211 -> 1791
    //   1583: aload_1
    //   1584: ifnull +185 -> 1769
    //   1587: iload_2
    //   1588: ifle +181 -> 1769
    //   1591: invokestatic 279	java/lang/System:currentTimeMillis	()J
    //   1594: lstore 10
    //   1596: ldc 172
    //   1598: new 160	java/lang/StringBuilder
    //   1601: dup
    //   1602: ldc_w 475
    //   1605: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1608: iload 5
    //   1610: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1613: ldc_w 477
    //   1616: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1619: iload_2
    //   1620: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1623: ldc_w 460
    //   1626: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1629: iload 4
    //   1631: invokevirtual 463	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1634: ldc_w 479
    //   1637: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1640: lload 10
    //   1642: invokevirtual 482	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1645: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1648: invokestatic 250	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1651: getstatic 487	android/os/Build$VERSION:SDK_INT	I
    //   1654: bipush 21
    //   1656: if_icmpge +121 -> 1777
    //   1659: aload_0
    //   1660: getfield 129	com/tencent/mm/plugin/voip/model/d:zgn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1663: invokevirtual 491	com/tencent/mm/compatible/deviceinfo/z:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   1666: iload 5
    //   1668: aaload
    //   1669: astore 12
    //   1671: aload 12
    //   1673: invokevirtual 495	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1676: pop
    //   1677: aload 12
    //   1679: invokevirtual 495	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1682: pop
    //   1683: aload 12
    //   1685: aload_1
    //   1686: iconst_0
    //   1687: iload_2
    //   1688: invokevirtual 498	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1691: pop
    //   1692: aload_0
    //   1693: getfield 129	com/tencent/mm/plugin/voip/model/d:zgn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1696: iload 5
    //   1698: iload_2
    //   1699: lload 10
    //   1701: iconst_0
    //   1702: invokevirtual 501	com/tencent/mm/compatible/deviceinfo/z:a	(IIJI)V
    //   1705: aload_0
    //   1706: aload_0
    //   1707: getfield 104	com/tencent/mm/plugin/voip/model/d:zgB	I
    //   1710: iconst_1
    //   1711: iadd
    //   1712: putfield 104	com/tencent/mm/plugin/voip/model/d:zgB	I
    //   1715: aload_0
    //   1716: iconst_0
    //   1717: putfield 94	com/tencent/mm/plugin/voip/model/d:zgy	I
    //   1720: aload_0
    //   1721: getfield 92	com/tencent/mm/plugin/voip/model/d:zgx	Z
    //   1724: ifeq +45 -> 1769
    //   1727: iconst_1
    //   1728: invokestatic 209	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1731: astore_1
    //   1732: aload_1
    //   1733: getstatic 215	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   1736: invokevirtual 219	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1739: pop
    //   1740: aload_1
    //   1741: iconst_0
    //   1742: invokevirtual 223	java/nio/ByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   1745: pop
    //   1746: aload_0
    //   1747: getfield 96	com/tencent/mm/plugin/voip/model/d:zfA	Lcom/tencent/mm/plugin/voip/model/l;
    //   1750: getfield 227	com/tencent/mm/plugin/voip/model/l:ziZ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1753: bipush 28
    //   1755: aload_1
    //   1756: invokevirtual 231	java/nio/ByteBuffer:array	()[B
    //   1759: iconst_1
    //   1760: invokevirtual 237	com/tencent/mm/plugin/voip/model/v2protocal:setAppCmd	(I[BI)I
    //   1763: pop
    //   1764: aload_0
    //   1765: iconst_0
    //   1766: putfield 92	com/tencent/mm/plugin/voip/model/d:zgx	Z
    //   1769: ldc_w 269
    //   1772: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1775: iconst_0
    //   1776: ireturn
    //   1777: aload_0
    //   1778: getfield 129	com/tencent/mm/plugin/voip/model/d:zgn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1781: iload 5
    //   1783: invokevirtual 504	com/tencent/mm/compatible/deviceinfo/z:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   1786: astore 12
    //   1788: goto -111 -> 1677
    //   1791: aload_0
    //   1792: getfield 92	com/tencent/mm/plugin/voip/model/d:zgx	Z
    //   1795: ifeq +26 -> 1821
    //   1798: iload 4
    //   1800: bipush 80
    //   1802: if_icmpeq +19 -> 1821
    //   1805: aload_0
    //   1806: iconst_0
    //   1807: putfield 88	com/tencent/mm/plugin/voip/model/d:zgv	Z
    //   1810: aload_0
    //   1811: aload_0
    //   1812: getfield 106	com/tencent/mm/plugin/voip/model/d:zgC	I
    //   1815: bipush 32
    //   1817: ior
    //   1818: putfield 106	com/tencent/mm/plugin/voip/model/d:zgC	I
    //   1821: aload_0
    //   1822: invokespecial 454	com/tencent/mm/plugin/voip/model/d:dRY	()I
    //   1825: pop
    //   1826: ldc 172
    //   1828: ldc_w 506
    //   1831: invokestatic 264	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1834: goto -65 -> 1769
    //   1837: iload 7
    //   1839: iload 9
    //   1841: iadd
    //   1842: istore 7
    //   1844: goto -838 -> 1006
    //   1847: iconst_0
    //   1848: istore 9
    //   1850: iload 7
    //   1852: istore 8
    //   1854: iload 9
    //   1856: istore 7
    //   1858: goto -852 -> 1006
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1861	0	this	d
    //   0	1861	1	paramArrayOfByte	byte[]
    //   0	1861	2	paramInt	int
    //   0	1861	3	paramBoolean	boolean
    //   1449	354	4	c	char
    //   100	1682	5	i	int
    //   110	1046	6	j	int
    //   940	917	7	k	int
    //   1085	768	8	m	int
    //   1044	811	9	n	int
    //   1594	106	10	l	long
    //   61	1138	12	localObject1	Object
    //   1204	15	12	localIOException	IOException
    //   1235	15	12	localException1	Exception
    //   1266	26	12	localException2	Exception
    //   1340	1	12	localMediaFormat	MediaFormat
    //   1345	37	12	localException3	Exception
    //   1669	118	12	localByteBuffer	ByteBuffer
    //   447	924	13	localObject2	Object
    //   602	437	14	localObject3	Object
    //   626	39	15	str	String
    // Exception table:
    //   from	to	target	type
    //   68	90	835	java/lang/Exception
    //   92	112	835	java/lang/Exception
    //   116	128	835	java/lang/Exception
    //   128	312	835	java/lang/Exception
    //   523	532	835	java/lang/Exception
    //   535	547	835	java/lang/Exception
    //   547	671	835	java/lang/Exception
    //   676	691	835	java/lang/Exception
    //   697	710	835	java/lang/Exception
    //   710	832	835	java/lang/Exception
    //   884	907	835	java/lang/Exception
    //   910	942	1160	java/lang/Exception
    //   945	961	1160	java/lang/Exception
    //   966	973	1160	java/lang/Exception
    //   980	997	1160	java/lang/Exception
    //   1006	1061	1160	java/lang/Exception
    //   1067	1085	1160	java/lang/Exception
    //   1094	1138	1160	java/lang/Exception
    //   1148	1153	1160	java/lang/Exception
    //   328	339	1204	java/io/IOException
    //   373	392	1235	java/lang/Exception
    //   343	368	1266	java/lang/Exception
    //   392	413	1266	java/lang/Exception
    //   413	469	1266	java/lang/Exception
    //   499	515	1266	java/lang/Exception
    //   1237	1263	1266	java/lang/Exception
    //   1328	1342	1266	java/lang/Exception
    //   1347	1402	1266	java/lang/Exception
    //   469	499	1345	java/lang/Exception
  }
  
  @SuppressLint({"NewApi"})
  public final void run()
  {
    AppMethodBeat.i(114830);
    if ((!Thread.interrupted()) && (this.zgv)) {
      if ((this.zgn == null) || (!this.zgu) || (!this.zgw)) {}
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
          i = this.zgn.dequeueOutputBuffer(localBufferInfo, 10000L);
          ad.d("MeidaCodec[HWDec]", "steve:  outIndex=".concat(String.valueOf(i)));
          switch (i)
          {
          case -3: 
            if (localBufferInfo.size <= 0) {
              break label419;
            }
            long l1 = localBufferInfo.presentationTimeUs;
            long l2 = System.currentTimeMillis();
            ad.d("MeidaCodec[HWDec]", "DECODER_THREAD:: decoded SUCCESSFULLY!!! cnt : " + this.zgA + ", size:" + localBufferInfo.size + ", pts:" + localBufferInfo.presentationTimeUs + ", latency:" + (l2 - l1));
            this.zgA += 1;
            this.zgn.releaseOutputBuffer(i, true);
            l2 = System.currentTimeMillis();
            ad.d("MeidaCodec[HWDec]", "steve: Avcdecoder frame processTime = " + (l2 - l1) + ", decFrameCnt=" + this.zgA + ", endTime=" + l2);
          }
        }
        catch (Exception localException1)
        {
          this.zgv = false;
          this.zgC |= 0x80;
          dRY();
          ad.e("MeidaCodec[HWDec]", " dequeueOutputBuffer/releaseOutputBuffer error:" + localException1.toString());
        }
        break;
        ad.d("MeidaCodec[HWDec]", "INFO_OUTPUT_BUFFERS_CHANGED");
        break;
        Object localObject = this.zgn.getOutputFormat();
        ad.i("MeidaCodec[HWDec]", "DECODER_THREAD:: New format : ".concat(String.valueOf(localObject)));
        int i = ((MediaFormat)localObject).getInteger("width");
        int j = ((MediaFormat)localObject).getInteger("height");
        if (this.zfA == null) {
          break;
        }
        localObject = this.zfA;
        ((l)localObject).mHandler.post(new l.5((l)localObject, j, i));
        break;
        ad.d("MeidaCodec[HWDec]", "DECODER_THREAD:: dequeueOutputBuffer timed out!");
        break;
        label419:
        ad.d("MeidaCodec[HWDec]", "steve: drop frame: " + this.zgA + ", size:" + ((MediaCodec.BufferInfo)localObject).size + ", pts:" + ((MediaCodec.BufferInfo)localObject).presentationTimeUs);
        this.zgn.releaseOutputBuffer(i, false);
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
      if ((!this.zgv) && (this.zgn != null)) {
        try
        {
          this.zgn.stop();
          this.zgn.release();
          this.zgn = null;
          AppMethodBeat.o(114830);
          return;
        }
        catch (Exception localException2)
        {
          ad.e("MeidaCodec[HWDec]", " decoder stop  error:" + localException2.toString());
        }
      }
      AppMethodBeat.o(114830);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.d
 * JD-Core Version:    0.7.0.1
 */