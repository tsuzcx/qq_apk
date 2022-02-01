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
  private static String waA;
  public static byte[] waD;
  public static byte[] waE;
  public static byte[] waF;
  public static int waH;
  public static int waI;
  public static int waz;
  l BXC;
  public byte[] configbyte;
  private BufferedOutputStream outputStream;
  private Surface surface;
  private BufferedOutputStream waB;
  private z waC;
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
  public byte[] waV;
  public byte[] waW;
  public byte[] waX;
  
  static
  {
    AppMethodBeat.i(177014);
    waz = 64;
    waA = b.arU();
    waD = null;
    waE = null;
    waF = null;
    waH = 640;
    waI = 480;
    AppMethodBeat.o(177014);
  }
  
  public d(Surface paramSurface)
  {
    AppMethodBeat.i(114825);
    this.outputStream = null;
    this.waB = null;
    this.configbyte = null;
    this.waG = false;
    this.waJ = false;
    this.waK = true;
    this.waL = true;
    this.waM = false;
    this.waN = 0;
    this.BXC = null;
    this.waO = new byte[] { 0, 0, 0, 1 };
    this.waP = 0;
    this.waQ = 0;
    this.waR = 0;
    this.waV = new byte[] { 103, 100, 0, 13, -84, -74, 10, 15, -120 };
    this.waW = new byte[] { 0, 0, 0, 1, 40, -50, 60, 48 };
    this.waX = new byte[] { 13, 0, -15, 98, -22 };
    this.waK = true;
    this.waL = true;
    this.waC = null;
    this.waG = false;
    this.waR = 0;
    if (paramSurface != null) {
      this.surface = paramSurface;
    }
    AppMethodBeat.o(114825);
  }
  
  private static String bu(byte[] paramArrayOfByte)
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
  
  private int dpe()
  {
    AppMethodBeat.i(114827);
    this.waN += 1;
    ad.i("MeidaCodec[HWDec]", "[HW]:DecFrmError: I Req mIReqFlag = " + this.waM + ", mIsHWDecEnable = " + this.waK + ", mHWErrorDecFrmCount = " + this.waN);
    if ((!this.waK) || (this.waN > waz))
    {
      dpf();
      this.BXC.tj(true);
      this.waR |= 0x40;
      ad.i("MeidaCodec[HWDec]", "[HW]: ErrFrm > threshold, end HWDec!!");
      AppMethodBeat.o(114827);
      return 0;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(1);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.put((byte)1);
    this.BXC.CaI.setAppCmd(28, localByteBuffer.array(), 1);
    this.waM = true;
    AppMethodBeat.o(114827);
    return 1;
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(114826);
    this.BXC = paraml;
    ad.i("MeidaCodec[HWDec]", "setStrategyCaller");
    AppMethodBeat.o(114826);
  }
  
  public final void dpf()
  {
    AppMethodBeat.i(114831);
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
    //   7: getfield 88	com/tencent/mm/plugin/voip/model/d:waK	Z
    //   10: ifne +30 -> 40
    //   13: aload_0
    //   14: aload_0
    //   15: getfield 106	com/tencent/mm/plugin/voip/model/d:waR	I
    //   18: iconst_1
    //   19: ior
    //   20: putfield 106	com/tencent/mm/plugin/voip/model/d:waR	I
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
    //   45: getfield 129	com/tencent/mm/plugin/voip/model/d:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   48: ifnull +8 -> 56
    //   51: aload_0
    //   52: iconst_0
    //   53: putfield 86	com/tencent/mm/plugin/voip/model/d:waJ	Z
    //   56: invokestatic 279	java/lang/System:currentTimeMillis	()J
    //   59: pop2
    //   60: aconst_null
    //   61: astore 12
    //   63: iload_2
    //   64: iconst_2
    //   65: if_icmpne +838 -> 903
    //   68: new 281	com/tencent/mm/protocal/protobuf/bng
    //   71: dup
    //   72: invokespecial 282	com/tencent/mm/protocal/protobuf/bng:<init>	()V
    //   75: aload_1
    //   76: invokevirtual 286	com/tencent/mm/protocal/protobuf/bng:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   79: checkcast 281	com/tencent/mm/protocal/protobuf/bng
    //   82: astore_1
    //   83: aload_1
    //   84: getfield 290	com/tencent/mm/protocal/protobuf/bng:GHl	Lcom/tencent/mm/bx/b;
    //   87: ifnonnull +436 -> 523
    //   90: iconst_0
    //   91: istore_2
    //   92: aload_1
    //   93: getfield 293	com/tencent/mm/protocal/protobuf/bng:GHj	Lcom/tencent/mm/bx/b;
    //   96: getfield 298	com/tencent/mm/bx/b:zr	[B
    //   99: arraylength
    //   100: istore 5
    //   102: aload_1
    //   103: getfield 301	com/tencent/mm/protocal/protobuf/bng:GHk	Lcom/tencent/mm/bx/b;
    //   106: getfield 298	com/tencent/mm/bx/b:zr	[B
    //   109: arraylength
    //   110: istore 6
    //   112: iload_2
    //   113: ifeq +422 -> 535
    //   116: aload_0
    //   117: getfield 84	com/tencent/mm/plugin/voip/model/d:waG	Z
    //   120: ifne +8 -> 128
    //   123: aload_0
    //   124: iconst_0
    //   125: putfield 86	com/tencent/mm/plugin/voip/model/d:waJ	Z
    //   128: aload_0
    //   129: iconst_1
    //   130: putfield 84	com/tencent/mm/plugin/voip/model/d:waG	Z
    //   133: iload_2
    //   134: iconst_4
    //   135: iadd
    //   136: newarray byte
    //   138: putstatic 59	com/tencent/mm/plugin/voip/model/d:waD	[B
    //   141: iload 5
    //   143: iconst_4
    //   144: iadd
    //   145: newarray byte
    //   147: putstatic 61	com/tencent/mm/plugin/voip/model/d:waE	[B
    //   150: iload 6
    //   152: iconst_4
    //   153: iadd
    //   154: newarray byte
    //   156: putstatic 63	com/tencent/mm/plugin/voip/model/d:waF	[B
    //   159: aload_0
    //   160: getfield 100	com/tencent/mm/plugin/voip/model/d:waO	[B
    //   163: iconst_0
    //   164: getstatic 59	com/tencent/mm/plugin/voip/model/d:waD	[B
    //   167: iconst_0
    //   168: iconst_4
    //   169: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   172: aload_0
    //   173: getfield 100	com/tencent/mm/plugin/voip/model/d:waO	[B
    //   176: iconst_0
    //   177: getstatic 61	com/tencent/mm/plugin/voip/model/d:waE	[B
    //   180: iconst_0
    //   181: iconst_4
    //   182: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   185: aload_0
    //   186: getfield 100	com/tencent/mm/plugin/voip/model/d:waO	[B
    //   189: iconst_0
    //   190: getstatic 63	com/tencent/mm/plugin/voip/model/d:waF	[B
    //   193: iconst_0
    //   194: iconst_4
    //   195: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   198: aload_1
    //   199: getfield 290	com/tencent/mm/protocal/protobuf/bng:GHl	Lcom/tencent/mm/bx/b;
    //   202: getstatic 59	com/tencent/mm/plugin/voip/model/d:waD	[B
    //   205: invokevirtual 309	com/tencent/mm/bx/b:ck	([B)V
    //   208: aload_1
    //   209: getfield 293	com/tencent/mm/protocal/protobuf/bng:GHj	Lcom/tencent/mm/bx/b;
    //   212: getstatic 61	com/tencent/mm/plugin/voip/model/d:waE	[B
    //   215: invokevirtual 309	com/tencent/mm/bx/b:ck	([B)V
    //   218: aload_1
    //   219: getfield 301	com/tencent/mm/protocal/protobuf/bng:GHk	Lcom/tencent/mm/bx/b;
    //   222: getstatic 63	com/tencent/mm/plugin/voip/model/d:waF	[B
    //   225: invokevirtual 309	com/tencent/mm/bx/b:ck	([B)V
    //   228: aload_0
    //   229: getstatic 59	com/tencent/mm/plugin/voip/model/d:waD	[B
    //   232: arraylength
    //   233: getstatic 61	com/tencent/mm/plugin/voip/model/d:waE	[B
    //   236: arraylength
    //   237: iadd
    //   238: getstatic 63	com/tencent/mm/plugin/voip/model/d:waF	[B
    //   241: arraylength
    //   242: iadd
    //   243: newarray byte
    //   245: putfield 82	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   248: getstatic 59	com/tencent/mm/plugin/voip/model/d:waD	[B
    //   251: iconst_0
    //   252: aload_0
    //   253: getfield 82	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   256: iconst_0
    //   257: getstatic 59	com/tencent/mm/plugin/voip/model/d:waD	[B
    //   260: arraylength
    //   261: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   264: getstatic 59	com/tencent/mm/plugin/voip/model/d:waD	[B
    //   267: arraylength
    //   268: iconst_0
    //   269: iadd
    //   270: istore_2
    //   271: getstatic 61	com/tencent/mm/plugin/voip/model/d:waE	[B
    //   274: iconst_0
    //   275: aload_0
    //   276: getfield 82	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   279: iload_2
    //   280: getstatic 61	com/tencent/mm/plugin/voip/model/d:waE	[B
    //   283: arraylength
    //   284: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   287: getstatic 61	com/tencent/mm/plugin/voip/model/d:waE	[B
    //   290: arraylength
    //   291: istore 5
    //   293: getstatic 63	com/tencent/mm/plugin/voip/model/d:waF	[B
    //   296: iconst_0
    //   297: aload_0
    //   298: getfield 82	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   301: iload_2
    //   302: iload 5
    //   304: iadd
    //   305: getstatic 63	com/tencent/mm/plugin/voip/model/d:waF	[B
    //   308: arraylength
    //   309: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   312: iconst_1
    //   313: istore_2
    //   314: aload 12
    //   316: astore_1
    //   317: aload_1
    //   318: ifnull +21 -> 339
    //   321: aload_0
    //   322: getfield 80	com/tencent/mm/plugin/voip/model/d:waB	Ljava/io/BufferedOutputStream;
    //   325: ifnull +14 -> 339
    //   328: aload_0
    //   329: getfield 80	com/tencent/mm/plugin/voip/model/d:waB	Ljava/io/BufferedOutputStream;
    //   332: aload_1
    //   333: iconst_0
    //   334: aload_1
    //   335: arraylength
    //   336: invokevirtual 313	java/io/BufferedOutputStream:write	([BII)V
    //   339: iload_2
    //   340: ifeq +958 -> 1298
    //   343: getstatic 61	com/tencent/mm/plugin/voip/model/d:waE	[B
    //   346: ifnull +952 -> 1298
    //   349: getstatic 63	com/tencent/mm/plugin/voip/model/d:waF	[B
    //   352: ifnull +946 -> 1298
    //   355: aload_0
    //   356: getfield 86	com/tencent/mm/plugin/voip/model/d:waJ	Z
    //   359: ifne +156 -> 515
    //   362: aload_0
    //   363: getfield 129	com/tencent/mm/plugin/voip/model/d:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   366: astore 12
    //   368: aload 12
    //   370: ifnull +22 -> 392
    //   373: aload_0
    //   374: getfield 129	com/tencent/mm/plugin/voip/model/d:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   377: invokevirtual 318	com/tencent/mm/compatible/deviceinfo/z:stop	()V
    //   380: aload_0
    //   381: getfield 129	com/tencent/mm/plugin/voip/model/d:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   384: invokevirtual 321	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   387: aload_0
    //   388: aconst_null
    //   389: putfield 129	com/tencent/mm/plugin/voip/model/d:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   392: aload_0
    //   393: getfield 84	com/tencent/mm/plugin/voip/model/d:waG	Z
    //   396: ifeq +925 -> 1321
    //   399: ldc_w 323
    //   402: getstatic 65	com/tencent/mm/plugin/voip/model/d:waH	I
    //   405: getstatic 67	com/tencent/mm/plugin/voip/model/d:waI	I
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
    //   463: invokestatic 352	com/tencent/mm/compatible/deviceinfo/z:vm	(Ljava/lang/String;)Lcom/tencent/mm/compatible/deviceinfo/z;
    //   466: putfield 129	com/tencent/mm/plugin/voip/model/d:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   469: ldc 172
    //   471: ldc_w 354
    //   474: aload 12
    //   476: invokestatic 154	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   479: invokevirtual 158	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   482: invokestatic 250	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   485: aload_0
    //   486: getfield 129	com/tencent/mm/plugin/voip/model/d:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   489: aload 12
    //   491: aload_0
    //   492: getfield 131	com/tencent/mm/plugin/voip/model/d:surface	Landroid/view/Surface;
    //   495: iconst_0
    //   496: invokevirtual 357	com/tencent/mm/compatible/deviceinfo/z:a	(Landroid/media/MediaFormat;Landroid/view/Surface;I)V
    //   499: aload_0
    //   500: getfield 129	com/tencent/mm/plugin/voip/model/d:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   503: invokevirtual 360	com/tencent/mm/compatible/deviceinfo/z:start	()V
    //   506: aload_0
    //   507: iconst_1
    //   508: putfield 86	com/tencent/mm/plugin/voip/model/d:waJ	Z
    //   511: aload_0
    //   512: invokevirtual 361	com/tencent/mm/plugin/voip/model/d:start	()V
    //   515: ldc_w 269
    //   518: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   521: iconst_1
    //   522: ireturn
    //   523: aload_1
    //   524: getfield 290	com/tencent/mm/protocal/protobuf/bng:GHl	Lcom/tencent/mm/bx/b;
    //   527: getfield 298	com/tencent/mm/bx/b:zr	[B
    //   530: arraylength
    //   531: istore_2
    //   532: goto -440 -> 92
    //   535: aload_0
    //   536: getfield 84	com/tencent/mm/plugin/voip/model/d:waG	Z
    //   539: ifeq +8 -> 547
    //   542: aload_0
    //   543: iconst_0
    //   544: putfield 86	com/tencent/mm/plugin/voip/model/d:waJ	Z
    //   547: aload_0
    //   548: iconst_0
    //   549: putfield 84	com/tencent/mm/plugin/voip/model/d:waG	Z
    //   552: iload 5
    //   554: iconst_4
    //   555: iadd
    //   556: newarray byte
    //   558: astore 13
    //   560: aload_0
    //   561: getfield 100	com/tencent/mm/plugin/voip/model/d:waO	[B
    //   564: iconst_0
    //   565: aload 13
    //   567: iconst_0
    //   568: iconst_4
    //   569: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   572: aload_1
    //   573: getfield 293	com/tencent/mm/protocal/protobuf/bng:GHj	Lcom/tencent/mm/bx/b;
    //   576: aload 13
    //   578: invokevirtual 309	com/tencent/mm/bx/b:ck	([B)V
    //   581: ldc 172
    //   583: ldc_w 363
    //   586: aload 13
    //   588: invokestatic 154	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   591: invokevirtual 158	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   594: invokestatic 250	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   597: aload 13
    //   599: invokestatic 365	com/tencent/mm/plugin/voip/model/d:bu	([B)Ljava/lang/String;
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
    //   623: invokestatic 365	com/tencent/mm/plugin/voip/model/d:bu	([B)Ljava/lang/String;
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
    //   707: putstatic 61	com/tencent/mm/plugin/voip/model/d:waE	[B
    //   710: ldc 172
    //   712: new 160	java/lang/StringBuilder
    //   715: dup
    //   716: ldc_w 382
    //   719: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   722: getstatic 61	com/tencent/mm/plugin/voip/model/d:waE	[B
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
    //   752: putstatic 63	com/tencent/mm/plugin/voip/model/d:waF	[B
    //   755: aload_0
    //   756: getfield 100	com/tencent/mm/plugin/voip/model/d:waO	[B
    //   759: iconst_0
    //   760: getstatic 63	com/tencent/mm/plugin/voip/model/d:waF	[B
    //   763: iconst_0
    //   764: iconst_4
    //   765: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   768: aload_1
    //   769: getfield 301	com/tencent/mm/protocal/protobuf/bng:GHk	Lcom/tencent/mm/bx/b;
    //   772: getstatic 63	com/tencent/mm/plugin/voip/model/d:waF	[B
    //   775: invokevirtual 309	com/tencent/mm/bx/b:ck	([B)V
    //   778: aload_0
    //   779: getstatic 61	com/tencent/mm/plugin/voip/model/d:waE	[B
    //   782: arraylength
    //   783: getstatic 63	com/tencent/mm/plugin/voip/model/d:waF	[B
    //   786: arraylength
    //   787: iadd
    //   788: newarray byte
    //   790: putfield 82	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   793: getstatic 61	com/tencent/mm/plugin/voip/model/d:waE	[B
    //   796: iconst_0
    //   797: aload_0
    //   798: getfield 82	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   801: iconst_0
    //   802: getstatic 61	com/tencent/mm/plugin/voip/model/d:waE	[B
    //   805: arraylength
    //   806: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   809: getstatic 61	com/tencent/mm/plugin/voip/model/d:waE	[B
    //   812: arraylength
    //   813: istore_2
    //   814: getstatic 63	com/tencent/mm/plugin/voip/model/d:waF	[B
    //   817: iconst_0
    //   818: aload_0
    //   819: getfield 82	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   822: iload_2
    //   823: iconst_0
    //   824: iadd
    //   825: getstatic 63	com/tencent/mm/plugin/voip/model/d:waF	[B
    //   828: arraylength
    //   829: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   832: goto -520 -> 312
    //   835: astore_1
    //   836: aload_0
    //   837: aload_0
    //   838: getfield 106	com/tencent/mm/plugin/voip/model/d:waR	I
    //   841: iconst_2
    //   842: ior
    //   843: putfield 106	com/tencent/mm/plugin/voip/model/d:waR	I
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
    //   892: aload 13
    //   894: invokestatic 394	com/tencent/mm/plugin/voip/model/g:bM	([B)[B
    //   897: putstatic 61	com/tencent/mm/plugin/voip/model/d:waE	[B
    //   900: goto -190 -> 710
    //   903: new 396	com/tencent/mm/protocal/protobuf/bnf
    //   906: dup
    //   907: invokespecial 397	com/tencent/mm/protocal/protobuf/bnf:<init>	()V
    //   910: aload_1
    //   911: invokevirtual 398	com/tencent/mm/protocal/protobuf/bnf:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   914: checkcast 396	com/tencent/mm/protocal/protobuf/bnf
    //   917: astore 13
    //   919: aload 13
    //   921: getfield 402	com/tencent/mm/protocal/protobuf/bnf:GHh	Ljava/util/LinkedList;
    //   924: invokevirtual 408	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   927: checkcast 138	java/lang/Integer
    //   930: invokevirtual 411	java/lang/Integer:intValue	()I
    //   933: istore 7
    //   935: iconst_0
    //   936: istore 5
    //   938: ldc 172
    //   940: ldc_w 413
    //   943: iload 7
    //   945: invokestatic 378	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   948: invokevirtual 158	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   951: invokestatic 250	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   954: iload_2
    //   955: iconst_1
    //   956: if_icmpne +185 -> 1141
    //   959: aload_0
    //   960: getfield 82	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   963: arraylength
    //   964: istore 5
    //   966: iload 7
    //   968: iload 5
    //   970: iadd
    //   971: istore 6
    //   973: iload 6
    //   975: newarray byte
    //   977: astore_1
    //   978: aload_0
    //   979: getfield 82	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   982: iconst_0
    //   983: aload_1
    //   984: iconst_0
    //   985: iload 5
    //   987: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   990: iload 5
    //   992: iconst_0
    //   993: iadd
    //   994: istore 5
    //   996: goto +844 -> 1840
    //   999: iconst_4
    //   1000: invokestatic 209	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1003: astore 14
    //   1005: aload 13
    //   1007: getfield 416	com/tencent/mm/protocal/protobuf/bnf:GHe	Lcom/tencent/mm/bx/b;
    //   1010: aload 14
    //   1012: invokevirtual 231	java/nio/ByteBuffer:array	()[B
    //   1015: iload 7
    //   1017: iconst_0
    //   1018: iconst_4
    //   1019: invokevirtual 419	com/tencent/mm/bx/b:i	([BIII)V
    //   1022: aload 14
    //   1024: getstatic 422	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   1027: invokevirtual 219	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1030: pop
    //   1031: aload 14
    //   1033: iconst_0
    //   1034: invokevirtual 426	java/nio/ByteBuffer:getInt	(I)I
    //   1037: istore 9
    //   1039: aload_0
    //   1040: getfield 100	com/tencent/mm/plugin/voip/model/d:waO	[B
    //   1043: iconst_0
    //   1044: aload_1
    //   1045: iload 7
    //   1047: iload 5
    //   1049: iadd
    //   1050: iconst_4
    //   1051: invokestatic 305	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1054: iload 7
    //   1056: iconst_4
    //   1057: iadd
    //   1058: istore 7
    //   1060: aload 13
    //   1062: getfield 416	com/tencent/mm/protocal/protobuf/bnf:GHe	Lcom/tencent/mm/bx/b;
    //   1065: aload_1
    //   1066: iload 7
    //   1068: iload 7
    //   1070: iload 5
    //   1072: iadd
    //   1073: iload 9
    //   1075: invokevirtual 419	com/tencent/mm/bx/b:i	([BIII)V
    //   1078: iload 8
    //   1080: iload 9
    //   1082: iconst_4
    //   1083: iadd
    //   1084: isub
    //   1085: istore 8
    //   1087: ldc 172
    //   1089: new 160	java/lang/StringBuilder
    //   1092: dup
    //   1093: ldc_w 428
    //   1096: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1099: iload 9
    //   1101: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1104: ldc_w 430
    //   1107: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: iload 6
    //   1112: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1115: ldc_w 432
    //   1118: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: iload_2
    //   1122: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1125: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1128: invokestatic 250	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1131: iload 8
    //   1133: ifgt +697 -> 1830
    //   1136: iconst_0
    //   1137: istore_2
    //   1138: goto -821 -> 317
    //   1141: iload 7
    //   1143: newarray byte
    //   1145: astore_1
    //   1146: iload 7
    //   1148: istore 6
    //   1150: goto +690 -> 1840
    //   1153: astore_1
    //   1154: aload_0
    //   1155: aload_0
    //   1156: getfield 106	com/tencent/mm/plugin/voip/model/d:waR	I
    //   1159: iconst_4
    //   1160: ior
    //   1161: putfield 106	com/tencent/mm/plugin/voip/model/d:waR	I
    //   1164: ldc 172
    //   1166: new 160	java/lang/StringBuilder
    //   1169: dup
    //   1170: ldc_w 434
    //   1173: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1176: aload_1
    //   1177: invokevirtual 387	java/lang/Exception:toString	()Ljava/lang/String;
    //   1180: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1186: invokestatic 264	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1189: iconst_0
    //   1190: istore_2
    //   1191: aload 12
    //   1193: astore_1
    //   1194: goto -877 -> 317
    //   1197: astore 12
    //   1199: ldc 172
    //   1201: new 160	java/lang/StringBuilder
    //   1204: dup
    //   1205: ldc_w 260
    //   1208: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1211: aload 12
    //   1213: invokevirtual 261	java/io/IOException:toString	()Ljava/lang/String;
    //   1216: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1219: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1222: invokestatic 264	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1225: goto -886 -> 339
    //   1228: astore 12
    //   1230: ldc 172
    //   1232: new 160	java/lang/StringBuilder
    //   1235: dup
    //   1236: ldc_w 436
    //   1239: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1242: aload 12
    //   1244: invokevirtual 387	java/lang/Exception:toString	()Ljava/lang/String;
    //   1247: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1250: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1253: invokestatic 264	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1256: goto -864 -> 392
    //   1259: astore 12
    //   1261: aload_0
    //   1262: aload_0
    //   1263: getfield 106	com/tencent/mm/plugin/voip/model/d:waR	I
    //   1266: bipush 16
    //   1268: ior
    //   1269: putfield 106	com/tencent/mm/plugin/voip/model/d:waR	I
    //   1272: ldc 172
    //   1274: new 160	java/lang/StringBuilder
    //   1277: dup
    //   1278: ldc_w 260
    //   1281: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1284: aload 12
    //   1286: invokevirtual 387	java/lang/Exception:toString	()Ljava/lang/String;
    //   1289: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1292: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1295: invokestatic 264	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1298: aload_0
    //   1299: getfield 86	com/tencent/mm/plugin/voip/model/d:waJ	Z
    //   1302: ifne +101 -> 1403
    //   1305: ldc 172
    //   1307: ldc_w 438
    //   1310: invokestatic 264	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1313: ldc_w 269
    //   1316: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1319: iconst_m1
    //   1320: ireturn
    //   1321: ldc_w 440
    //   1324: getstatic 65	com/tencent/mm/plugin/voip/model/d:waH	I
    //   1327: getstatic 67	com/tencent/mm/plugin/voip/model/d:waI	I
    //   1330: invokestatic 329	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   1333: astore 12
    //   1335: goto -922 -> 413
    //   1338: astore 12
    //   1340: aload_0
    //   1341: aload_0
    //   1342: getfield 106	com/tencent/mm/plugin/voip/model/d:waR	I
    //   1345: bipush 8
    //   1347: ior
    //   1348: putfield 106	com/tencent/mm/plugin/voip/model/d:waR	I
    //   1351: ldc 172
    //   1353: new 160	java/lang/StringBuilder
    //   1356: dup
    //   1357: ldc_w 442
    //   1360: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1363: aload 13
    //   1365: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: ldc_w 444
    //   1371: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1374: aload 12
    //   1376: invokevirtual 447	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1379: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1382: invokestatic 264	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1385: aload_0
    //   1386: iconst_0
    //   1387: putfield 88	com/tencent/mm/plugin/voip/model/d:waK	Z
    //   1390: aload_0
    //   1391: invokespecial 449	com/tencent/mm/plugin/voip/model/d:dpe	()I
    //   1394: pop
    //   1395: ldc_w 269
    //   1398: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1401: iconst_m1
    //   1402: ireturn
    //   1403: aload_0
    //   1404: getfield 90	com/tencent/mm/plugin/voip/model/d:waL	Z
    //   1407: ifne +8 -> 1415
    //   1410: aload_0
    //   1411: iconst_1
    //   1412: putfield 90	com/tencent/mm/plugin/voip/model/d:waL	Z
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
    //   1444: ldc 172
    //   1446: new 160	java/lang/StringBuilder
    //   1449: dup
    //   1450: ldc_w 451
    //   1453: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1456: iload_2
    //   1457: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1460: ldc_w 453
    //   1463: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: iload 5
    //   1468: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1471: ldc_w 455
    //   1474: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1477: iload 4
    //   1479: invokevirtual 458	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1482: ldc_w 460
    //   1485: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1488: aload_0
    //   1489: getfield 104	com/tencent/mm/plugin/voip/model/d:waQ	I
    //   1492: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1495: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1498: invokestatic 250	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1501: aload_0
    //   1502: getfield 92	com/tencent/mm/plugin/voip/model/d:waM	Z
    //   1505: ifeq +54 -> 1559
    //   1508: iload 4
    //   1510: bipush 80
    //   1512: if_icmpne +47 -> 1559
    //   1515: ldc 172
    //   1517: ldc_w 462
    //   1520: invokestatic 264	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1523: ldc_w 269
    //   1526: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   1560: getfield 129	com/tencent/mm/plugin/voip/model/d:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1563: ldc2_w 463
    //   1566: invokevirtual 468	com/tencent/mm/compatible/deviceinfo/z:dequeueInputBuffer	(J)I
    //   1569: istore 5
    //   1571: iload 5
    //   1573: iflt +211 -> 1784
    //   1576: aload_1
    //   1577: ifnull +185 -> 1762
    //   1580: iload_2
    //   1581: ifle +181 -> 1762
    //   1584: invokestatic 279	java/lang/System:currentTimeMillis	()J
    //   1587: lstore 10
    //   1589: ldc 172
    //   1591: new 160	java/lang/StringBuilder
    //   1594: dup
    //   1595: ldc_w 470
    //   1598: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1601: iload 5
    //   1603: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1606: ldc_w 472
    //   1609: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1612: iload_2
    //   1613: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1616: ldc_w 455
    //   1619: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1622: iload 4
    //   1624: invokevirtual 458	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1627: ldc_w 474
    //   1630: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1633: lload 10
    //   1635: invokevirtual 477	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1638: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1641: invokestatic 250	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1644: getstatic 482	android/os/Build$VERSION:SDK_INT	I
    //   1647: bipush 21
    //   1649: if_icmpge +121 -> 1770
    //   1652: aload_0
    //   1653: getfield 129	com/tencent/mm/plugin/voip/model/d:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1656: invokevirtual 486	com/tencent/mm/compatible/deviceinfo/z:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   1659: iload 5
    //   1661: aaload
    //   1662: astore 12
    //   1664: aload 12
    //   1666: invokevirtual 490	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1669: pop
    //   1670: aload 12
    //   1672: invokevirtual 490	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1675: pop
    //   1676: aload 12
    //   1678: aload_1
    //   1679: iconst_0
    //   1680: iload_2
    //   1681: invokevirtual 493	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1684: pop
    //   1685: aload_0
    //   1686: getfield 129	com/tencent/mm/plugin/voip/model/d:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1689: iload 5
    //   1691: iload_2
    //   1692: lload 10
    //   1694: iconst_0
    //   1695: invokevirtual 496	com/tencent/mm/compatible/deviceinfo/z:a	(IIJI)V
    //   1698: aload_0
    //   1699: aload_0
    //   1700: getfield 104	com/tencent/mm/plugin/voip/model/d:waQ	I
    //   1703: iconst_1
    //   1704: iadd
    //   1705: putfield 104	com/tencent/mm/plugin/voip/model/d:waQ	I
    //   1708: aload_0
    //   1709: iconst_0
    //   1710: putfield 94	com/tencent/mm/plugin/voip/model/d:waN	I
    //   1713: aload_0
    //   1714: getfield 92	com/tencent/mm/plugin/voip/model/d:waM	Z
    //   1717: ifeq +45 -> 1762
    //   1720: iconst_1
    //   1721: invokestatic 209	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1724: astore_1
    //   1725: aload_1
    //   1726: getstatic 215	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   1729: invokevirtual 219	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1732: pop
    //   1733: aload_1
    //   1734: iconst_0
    //   1735: invokevirtual 223	java/nio/ByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   1738: pop
    //   1739: aload_0
    //   1740: getfield 96	com/tencent/mm/plugin/voip/model/d:BXC	Lcom/tencent/mm/plugin/voip/model/l;
    //   1743: getfield 227	com/tencent/mm/plugin/voip/model/l:CaI	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1746: bipush 28
    //   1748: aload_1
    //   1749: invokevirtual 231	java/nio/ByteBuffer:array	()[B
    //   1752: iconst_1
    //   1753: invokevirtual 237	com/tencent/mm/plugin/voip/model/v2protocal:setAppCmd	(I[BI)I
    //   1756: pop
    //   1757: aload_0
    //   1758: iconst_0
    //   1759: putfield 92	com/tencent/mm/plugin/voip/model/d:waM	Z
    //   1762: ldc_w 269
    //   1765: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1768: iconst_0
    //   1769: ireturn
    //   1770: aload_0
    //   1771: getfield 129	com/tencent/mm/plugin/voip/model/d:waC	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1774: iload 5
    //   1776: invokevirtual 499	com/tencent/mm/compatible/deviceinfo/z:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   1779: astore 12
    //   1781: goto -111 -> 1670
    //   1784: aload_0
    //   1785: getfield 92	com/tencent/mm/plugin/voip/model/d:waM	Z
    //   1788: ifeq +26 -> 1814
    //   1791: iload 4
    //   1793: bipush 80
    //   1795: if_icmpeq +19 -> 1814
    //   1798: aload_0
    //   1799: iconst_0
    //   1800: putfield 88	com/tencent/mm/plugin/voip/model/d:waK	Z
    //   1803: aload_0
    //   1804: aload_0
    //   1805: getfield 106	com/tencent/mm/plugin/voip/model/d:waR	I
    //   1808: bipush 32
    //   1810: ior
    //   1811: putfield 106	com/tencent/mm/plugin/voip/model/d:waR	I
    //   1814: aload_0
    //   1815: invokespecial 449	com/tencent/mm/plugin/voip/model/d:dpe	()I
    //   1818: pop
    //   1819: ldc 172
    //   1821: ldc_w 501
    //   1824: invokestatic 264	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1827: goto -65 -> 1762
    //   1830: iload 7
    //   1832: iload 9
    //   1834: iadd
    //   1835: istore 7
    //   1837: goto -838 -> 999
    //   1840: iconst_0
    //   1841: istore 9
    //   1843: iload 7
    //   1845: istore 8
    //   1847: iload 9
    //   1849: istore 7
    //   1851: goto -852 -> 999
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1854	0	this	d
    //   0	1854	1	paramArrayOfByte	byte[]
    //   0	1854	2	paramInt	int
    //   0	1854	3	paramBoolean	boolean
    //   1442	354	4	c	char
    //   100	1675	5	i	int
    //   110	1039	6	j	int
    //   933	917	7	k	int
    //   1078	768	8	m	int
    //   1037	811	9	n	int
    //   1587	106	10	l	long
    //   61	1131	12	localObject1	Object
    //   1197	15	12	localIOException	IOException
    //   1228	15	12	localException1	Exception
    //   1259	26	12	localException2	Exception
    //   1333	1	12	localMediaFormat	MediaFormat
    //   1338	37	12	localException3	Exception
    //   1662	118	12	localByteBuffer	ByteBuffer
    //   447	917	13	localObject2	Object
    //   602	430	14	localObject3	Object
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
    //   884	900	835	java/lang/Exception
    //   903	935	1153	java/lang/Exception
    //   938	954	1153	java/lang/Exception
    //   959	966	1153	java/lang/Exception
    //   973	990	1153	java/lang/Exception
    //   999	1054	1153	java/lang/Exception
    //   1060	1078	1153	java/lang/Exception
    //   1087	1131	1153	java/lang/Exception
    //   1141	1146	1153	java/lang/Exception
    //   328	339	1197	java/io/IOException
    //   373	392	1228	java/lang/Exception
    //   343	368	1259	java/lang/Exception
    //   392	413	1259	java/lang/Exception
    //   413	469	1259	java/lang/Exception
    //   499	515	1259	java/lang/Exception
    //   1230	1256	1259	java/lang/Exception
    //   1321	1335	1259	java/lang/Exception
    //   1340	1395	1259	java/lang/Exception
    //   469	499	1338	java/lang/Exception
  }
  
  @SuppressLint({"NewApi"})
  public final void run()
  {
    AppMethodBeat.i(114830);
    if ((!Thread.interrupted()) && (this.waK)) {
      if ((this.waC == null) || (!this.waJ) || (!this.waL)) {}
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
          i = this.waC.dequeueOutputBuffer(localBufferInfo, 10000L);
          ad.d("MeidaCodec[HWDec]", "steve:  outIndex=".concat(String.valueOf(i)));
          switch (i)
          {
          case -3: 
            if (localBufferInfo.size <= 0) {
              break label419;
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
        Object localObject = this.waC.getOutputFormat();
        ad.i("MeidaCodec[HWDec]", "DECODER_THREAD:: New format : ".concat(String.valueOf(localObject)));
        int i = ((MediaFormat)localObject).getInteger("width");
        int j = ((MediaFormat)localObject).getInteger("height");
        if (this.BXC == null) {
          break;
        }
        localObject = this.BXC;
        ((l)localObject).mHandler.post(new l.5((l)localObject, j, i));
        break;
        ad.d("MeidaCodec[HWDec]", "DECODER_THREAD:: dequeueOutputBuffer timed out!");
        break;
        label419:
        ad.d("MeidaCodec[HWDec]", "steve: drop frame: " + this.waP + ", size:" + ((MediaCodec.BufferInfo)localObject).size + ", pts:" + ((MediaCodec.BufferInfo)localObject).presentationTimeUs);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.d
 * JD-Core Version:    0.7.0.1
 */