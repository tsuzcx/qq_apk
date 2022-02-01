package com.tencent.mm.plugin.voip.model;

import android.annotation.SuppressLint;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.io.BufferedOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class d
  extends Thread
{
  public static int FqB;
  private static String FqC;
  public static byte[] FqF;
  public static byte[] FqG;
  public static byte[] FqH;
  public static int FqJ;
  public static int FqK;
  BufferedOutputStream FqD;
  private aa FqE;
  private boolean FqI;
  private boolean FqL;
  public boolean FqM;
  public boolean FqN;
  public boolean FqO;
  public int FqP;
  public byte[] FqQ;
  public int FqR;
  public int FqS;
  public int FqT;
  public byte[] FqX;
  public byte[] FqY;
  public byte[] FqZ;
  l NJk;
  public byte[] configbyte;
  public boolean mIsStart;
  BufferedOutputStream outputStream;
  private Surface surface;
  
  static
  {
    AppMethodBeat.i(177014);
    FqB = 64;
    FqC = b.aSL();
    FqF = null;
    FqG = null;
    FqH = null;
    FqJ = 640;
    FqK = 480;
    AppMethodBeat.o(177014);
  }
  
  public d(Surface paramSurface)
  {
    AppMethodBeat.i(114825);
    this.outputStream = null;
    this.FqD = null;
    this.configbyte = null;
    this.FqI = false;
    this.FqL = false;
    this.FqM = true;
    this.FqN = true;
    this.FqO = false;
    this.FqP = 0;
    this.mIsStart = false;
    this.NJk = null;
    this.FqQ = new byte[] { 0, 0, 0, 1 };
    this.FqR = 0;
    this.FqS = 0;
    this.FqT = 0;
    this.FqX = new byte[] { 103, 100, 0, 13, -84, -74, 10, 15, -120 };
    this.FqY = new byte[] { 0, 0, 0, 1, 40, -50, 60, 48 };
    this.FqZ = new byte[] { 13, 0, -15, 98, -22 };
    this.FqM = true;
    this.FqN = true;
    this.FqE = null;
    this.FqI = false;
    this.FqT = 0;
    if (paramSurface != null) {
      this.surface = paramSurface;
    }
    AppMethodBeat.o(114825);
  }
  
  private static String ce(byte[] paramArrayOfByte)
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
  
  private int eWo()
  {
    AppMethodBeat.i(114827);
    this.FqP += 1;
    Log.i("MicroMsg.AvcDecoder", "[HW]:DecFrmError: I Req mIReqFlag = " + this.FqO + ", mIsHWDecEnable = " + this.FqM + ", mHWErrorDecFrmCount = " + this.FqP);
    if ((!this.FqM) || (this.FqP > FqB))
    {
      this.FqN = false;
      this.NJk.aR(true, this.FqI);
      this.FqT |= 0x40;
      Log.i("MicroMsg.AvcDecoder", "[HW]: ErrFrm > threshold, end HWDec!!");
      AppMethodBeat.o(114827);
      return 0;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(1);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.put((byte)1);
    this.NJk.NMi.setAppCmd(28, localByteBuffer.array(), 1);
    this.FqO = true;
    AppMethodBeat.o(114827);
    return 1;
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(114826);
    this.NJk = paraml;
    Log.i("MicroMsg.AvcDecoder", "setStrategyCaller");
    AppMethodBeat.o(114826);
  }
  
  /* Error */
  public final int f(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 251
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iload_3
    //   6: ifeq +22 -> 28
    //   9: aload_0
    //   10: getfield 132	com/tencent/mm/plugin/voip/model/d:FqE	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   13: ifnull +8 -> 21
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 87	com/tencent/mm/plugin/voip/model/d:FqL	Z
    //   21: ldc 253
    //   23: ldc 255
    //   25: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield 89	com/tencent/mm/plugin/voip/model/d:FqM	Z
    //   32: ifne +28 -> 60
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 109	com/tencent/mm/plugin/voip/model/d:FqT	I
    //   40: iconst_1
    //   41: ior
    //   42: putfield 109	com/tencent/mm/plugin/voip/model/d:FqT	I
    //   45: ldc 253
    //   47: ldc_w 257
    //   50: invokestatic 260	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: ldc 251
    //   55: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: iconst_m1
    //   59: ireturn
    //   60: invokestatic 266	java/lang/System:currentTimeMillis	()J
    //   63: pop2
    //   64: iload_2
    //   65: iconst_2
    //   66: if_icmpne +889 -> 955
    //   69: new 268	com/tencent/mm/protocal/protobuf/ciq
    //   72: dup
    //   73: invokespecial 269	com/tencent/mm/protocal/protobuf/ciq:<init>	()V
    //   76: aload_1
    //   77: invokevirtual 273	com/tencent/mm/protocal/protobuf/ciq:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   80: checkcast 268	com/tencent/mm/protocal/protobuf/ciq
    //   83: astore_1
    //   84: aload_1
    //   85: getfield 277	com/tencent/mm/protocal/protobuf/ciq:Tpz	Lcom/tencent/mm/cd/b;
    //   88: ifnonnull +446 -> 534
    //   91: iconst_0
    //   92: istore_2
    //   93: aload_1
    //   94: getfield 280	com/tencent/mm/protocal/protobuf/ciq:Tpx	Lcom/tencent/mm/cd/b;
    //   97: getfield 285	com/tencent/mm/cd/b:UH	[B
    //   100: arraylength
    //   101: istore 5
    //   103: aload_1
    //   104: getfield 288	com/tencent/mm/protocal/protobuf/ciq:Tpy	Lcom/tencent/mm/cd/b;
    //   107: getfield 285	com/tencent/mm/cd/b:UH	[B
    //   110: arraylength
    //   111: istore 6
    //   113: iload_2
    //   114: ifeq +432 -> 546
    //   117: aload_0
    //   118: getfield 85	com/tencent/mm/plugin/voip/model/d:FqI	Z
    //   121: ifne +8 -> 129
    //   124: aload_0
    //   125: iconst_0
    //   126: putfield 87	com/tencent/mm/plugin/voip/model/d:FqL	Z
    //   129: aload_0
    //   130: iconst_1
    //   131: putfield 85	com/tencent/mm/plugin/voip/model/d:FqI	Z
    //   134: iload_2
    //   135: iconst_4
    //   136: iadd
    //   137: newarray byte
    //   139: putstatic 60	com/tencent/mm/plugin/voip/model/d:FqF	[B
    //   142: iload 5
    //   144: iconst_4
    //   145: iadd
    //   146: newarray byte
    //   148: putstatic 62	com/tencent/mm/plugin/voip/model/d:FqG	[B
    //   151: iload 6
    //   153: iconst_4
    //   154: iadd
    //   155: newarray byte
    //   157: putstatic 64	com/tencent/mm/plugin/voip/model/d:FqH	[B
    //   160: aload_0
    //   161: getfield 103	com/tencent/mm/plugin/voip/model/d:FqQ	[B
    //   164: iconst_0
    //   165: getstatic 60	com/tencent/mm/plugin/voip/model/d:FqF	[B
    //   168: iconst_0
    //   169: iconst_4
    //   170: invokestatic 292	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   173: aload_0
    //   174: getfield 103	com/tencent/mm/plugin/voip/model/d:FqQ	[B
    //   177: iconst_0
    //   178: getstatic 62	com/tencent/mm/plugin/voip/model/d:FqG	[B
    //   181: iconst_0
    //   182: iconst_4
    //   183: invokestatic 292	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   186: aload_0
    //   187: getfield 103	com/tencent/mm/plugin/voip/model/d:FqQ	[B
    //   190: iconst_0
    //   191: getstatic 64	com/tencent/mm/plugin/voip/model/d:FqH	[B
    //   194: iconst_0
    //   195: iconst_4
    //   196: invokestatic 292	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   199: aload_1
    //   200: getfield 277	com/tencent/mm/protocal/protobuf/ciq:Tpz	Lcom/tencent/mm/cd/b;
    //   203: getstatic 60	com/tencent/mm/plugin/voip/model/d:FqF	[B
    //   206: invokevirtual 296	com/tencent/mm/cd/b:cV	([B)V
    //   209: aload_1
    //   210: getfield 280	com/tencent/mm/protocal/protobuf/ciq:Tpx	Lcom/tencent/mm/cd/b;
    //   213: getstatic 62	com/tencent/mm/plugin/voip/model/d:FqG	[B
    //   216: invokevirtual 296	com/tencent/mm/cd/b:cV	([B)V
    //   219: aload_1
    //   220: getfield 288	com/tencent/mm/protocal/protobuf/ciq:Tpy	Lcom/tencent/mm/cd/b;
    //   223: getstatic 64	com/tencent/mm/plugin/voip/model/d:FqH	[B
    //   226: invokevirtual 296	com/tencent/mm/cd/b:cV	([B)V
    //   229: aload_0
    //   230: getstatic 60	com/tencent/mm/plugin/voip/model/d:FqF	[B
    //   233: arraylength
    //   234: getstatic 62	com/tencent/mm/plugin/voip/model/d:FqG	[B
    //   237: arraylength
    //   238: iadd
    //   239: getstatic 64	com/tencent/mm/plugin/voip/model/d:FqH	[B
    //   242: arraylength
    //   243: iadd
    //   244: newarray byte
    //   246: putfield 83	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   249: getstatic 60	com/tencent/mm/plugin/voip/model/d:FqF	[B
    //   252: iconst_0
    //   253: aload_0
    //   254: getfield 83	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   257: iconst_0
    //   258: getstatic 60	com/tencent/mm/plugin/voip/model/d:FqF	[B
    //   261: arraylength
    //   262: invokestatic 292	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   265: getstatic 60	com/tencent/mm/plugin/voip/model/d:FqF	[B
    //   268: arraylength
    //   269: iconst_0
    //   270: iadd
    //   271: istore_2
    //   272: getstatic 62	com/tencent/mm/plugin/voip/model/d:FqG	[B
    //   275: iconst_0
    //   276: aload_0
    //   277: getfield 83	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   280: iload_2
    //   281: getstatic 62	com/tencent/mm/plugin/voip/model/d:FqG	[B
    //   284: arraylength
    //   285: invokestatic 292	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   288: getstatic 62	com/tencent/mm/plugin/voip/model/d:FqG	[B
    //   291: arraylength
    //   292: istore 5
    //   294: getstatic 64	com/tencent/mm/plugin/voip/model/d:FqH	[B
    //   297: iconst_0
    //   298: aload_0
    //   299: getfield 83	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   302: iload_2
    //   303: iload 5
    //   305: iadd
    //   306: getstatic 64	com/tencent/mm/plugin/voip/model/d:FqH	[B
    //   309: arraylength
    //   310: invokestatic 292	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   313: iconst_1
    //   314: istore_2
    //   315: aconst_null
    //   316: astore_1
    //   317: aload_1
    //   318: ifnull +21 -> 339
    //   321: aload_0
    //   322: getfield 81	com/tencent/mm/plugin/voip/model/d:FqD	Ljava/io/BufferedOutputStream;
    //   325: ifnull +14 -> 339
    //   328: aload_0
    //   329: getfield 81	com/tencent/mm/plugin/voip/model/d:FqD	Ljava/io/BufferedOutputStream;
    //   332: aload_1
    //   333: iconst_0
    //   334: aload_1
    //   335: arraylength
    //   336: invokevirtual 302	java/io/BufferedOutputStream:write	([BII)V
    //   339: iload_2
    //   340: ifeq +1052 -> 1392
    //   343: getstatic 62	com/tencent/mm/plugin/voip/model/d:FqG	[B
    //   346: ifnull +1046 -> 1392
    //   349: getstatic 64	com/tencent/mm/plugin/voip/model/d:FqH	[B
    //   352: ifnull +1040 -> 1392
    //   355: aload_0
    //   356: getfield 87	com/tencent/mm/plugin/voip/model/d:FqL	Z
    //   359: ifne +168 -> 527
    //   362: aload_0
    //   363: getfield 132	com/tencent/mm/plugin/voip/model/d:FqE	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   366: astore 12
    //   368: aload 12
    //   370: ifnull +22 -> 392
    //   373: aload_0
    //   374: getfield 132	com/tencent/mm/plugin/voip/model/d:FqE	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   377: invokevirtual 307	com/tencent/mm/compatible/deviceinfo/aa:stop	()V
    //   380: aload_0
    //   381: getfield 132	com/tencent/mm/plugin/voip/model/d:FqE	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   384: invokevirtual 310	com/tencent/mm/compatible/deviceinfo/aa:release	()V
    //   387: aload_0
    //   388: aconst_null
    //   389: putfield 132	com/tencent/mm/plugin/voip/model/d:FqE	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   392: aload_0
    //   393: getfield 85	com/tencent/mm/plugin/voip/model/d:FqI	Z
    //   396: ifeq +1018 -> 1414
    //   399: ldc_w 312
    //   402: getstatic 66	com/tencent/mm/plugin/voip/model/d:FqJ	I
    //   405: getstatic 68	com/tencent/mm/plugin/voip/model/d:FqK	I
    //   408: invokestatic 318	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   411: astore 12
    //   413: aload 12
    //   415: ldc_w 320
    //   418: bipush 90
    //   420: invokevirtual 324	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   423: ldc 175
    //   425: ldc_w 326
    //   428: aload 12
    //   430: invokestatic 157	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   433: invokevirtual 161	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   436: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: aload 12
    //   441: ldc_w 328
    //   444: invokevirtual 331	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   447: astore 13
    //   449: aload 13
    //   451: ldc_w 333
    //   454: invokevirtual 337	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   457: ifeq +70 -> 527
    //   460: aload_0
    //   461: aload 13
    //   463: invokestatic 341	com/tencent/mm/compatible/deviceinfo/aa:KR	(Ljava/lang/String;)Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   466: putfield 132	com/tencent/mm/plugin/voip/model/d:FqE	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   469: ldc 175
    //   471: ldc_w 343
    //   474: aload 12
    //   476: invokestatic 157	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   479: invokevirtual 161	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   482: invokestatic 260	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   485: aload_0
    //   486: getfield 132	com/tencent/mm/plugin/voip/model/d:FqE	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   489: aload 12
    //   491: aload_0
    //   492: getfield 134	com/tencent/mm/plugin/voip/model/d:surface	Landroid/view/Surface;
    //   495: iconst_0
    //   496: invokevirtual 346	com/tencent/mm/compatible/deviceinfo/aa:a	(Landroid/media/MediaFormat;Landroid/view/Surface;I)V
    //   499: aload_0
    //   500: getfield 132	com/tencent/mm/plugin/voip/model/d:FqE	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   503: invokevirtual 349	com/tencent/mm/compatible/deviceinfo/aa:start	()V
    //   506: aload_0
    //   507: iconst_1
    //   508: putfield 87	com/tencent/mm/plugin/voip/model/d:FqL	Z
    //   511: aload_0
    //   512: getfield 97	com/tencent/mm/plugin/voip/model/d:mIsStart	Z
    //   515: ifne +12 -> 527
    //   518: aload_0
    //   519: invokevirtual 350	com/tencent/mm/plugin/voip/model/d:start	()V
    //   522: aload_0
    //   523: iconst_1
    //   524: putfield 97	com/tencent/mm/plugin/voip/model/d:mIsStart	Z
    //   527: ldc 251
    //   529: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   532: iconst_1
    //   533: ireturn
    //   534: aload_1
    //   535: getfield 277	com/tencent/mm/protocal/protobuf/ciq:Tpz	Lcom/tencent/mm/cd/b;
    //   538: getfield 285	com/tencent/mm/cd/b:UH	[B
    //   541: arraylength
    //   542: istore_2
    //   543: goto -450 -> 93
    //   546: aload_0
    //   547: getfield 85	com/tencent/mm/plugin/voip/model/d:FqI	Z
    //   550: ifeq +8 -> 558
    //   553: aload_0
    //   554: iconst_0
    //   555: putfield 87	com/tencent/mm/plugin/voip/model/d:FqL	Z
    //   558: aload_0
    //   559: iconst_0
    //   560: putfield 85	com/tencent/mm/plugin/voip/model/d:FqI	Z
    //   563: iload 5
    //   565: iconst_4
    //   566: iadd
    //   567: newarray byte
    //   569: astore 12
    //   571: aload_0
    //   572: getfield 103	com/tencent/mm/plugin/voip/model/d:FqQ	[B
    //   575: iconst_0
    //   576: aload 12
    //   578: iconst_0
    //   579: iconst_4
    //   580: invokestatic 292	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   583: aload_1
    //   584: getfield 280	com/tencent/mm/protocal/protobuf/ciq:Tpx	Lcom/tencent/mm/cd/b;
    //   587: aload 12
    //   589: invokevirtual 296	com/tencent/mm/cd/b:cV	([B)V
    //   592: ldc 175
    //   594: ldc_w 352
    //   597: aload 12
    //   599: invokestatic 157	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   602: invokevirtual 161	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   605: invokestatic 260	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   608: aload 12
    //   610: invokestatic 354	com/tencent/mm/plugin/voip/model/d:ce	([B)Ljava/lang/String;
    //   613: astore 13
    //   615: iconst_3
    //   616: newarray byte
    //   618: dup
    //   619: iconst_0
    //   620: ldc 100
    //   622: bastore
    //   623: dup
    //   624: iconst_1
    //   625: ldc 100
    //   627: bastore
    //   628: dup
    //   629: iconst_2
    //   630: ldc_w 355
    //   633: bastore
    //   634: invokestatic 354	com/tencent/mm/plugin/voip/model/d:ce	([B)Ljava/lang/String;
    //   637: astore 14
    //   639: ldc 175
    //   641: new 163	java/lang/StringBuilder
    //   644: dup
    //   645: ldc_w 357
    //   648: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   651: aload 13
    //   653: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: ldc_w 359
    //   659: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: aload 14
    //   664: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   670: invokestatic 260	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   673: aload 13
    //   675: aload 14
    //   677: iconst_0
    //   678: invokevirtual 363	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   681: istore_2
    //   682: iload_2
    //   683: iconst_m1
    //   684: if_icmpeq +205 -> 889
    //   687: ldc 175
    //   689: ldc_w 365
    //   692: iload_2
    //   693: invokestatic 367	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   696: invokevirtual 161	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   699: invokestatic 260	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   702: iconst_1
    //   703: istore_2
    //   704: iload_2
    //   705: ifeq +189 -> 894
    //   708: ldc 175
    //   710: ldc_w 369
    //   713: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   716: aload 12
    //   718: putstatic 62	com/tencent/mm/plugin/voip/model/d:FqG	[B
    //   721: ldc 175
    //   723: new 163	java/lang/StringBuilder
    //   726: dup
    //   727: ldc_w 371
    //   730: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   733: getstatic 62	com/tencent/mm/plugin/voip/model/d:FqG	[B
    //   736: arraylength
    //   737: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   740: ldc_w 373
    //   743: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: iload 5
    //   748: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   751: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   754: invokestatic 260	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   757: iload 6
    //   759: iconst_4
    //   760: iadd
    //   761: newarray byte
    //   763: putstatic 64	com/tencent/mm/plugin/voip/model/d:FqH	[B
    //   766: aload_0
    //   767: getfield 103	com/tencent/mm/plugin/voip/model/d:FqQ	[B
    //   770: iconst_0
    //   771: getstatic 64	com/tencent/mm/plugin/voip/model/d:FqH	[B
    //   774: iconst_0
    //   775: iconst_4
    //   776: invokestatic 292	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   779: aload_1
    //   780: getfield 288	com/tencent/mm/protocal/protobuf/ciq:Tpy	Lcom/tencent/mm/cd/b;
    //   783: getstatic 64	com/tencent/mm/plugin/voip/model/d:FqH	[B
    //   786: invokevirtual 296	com/tencent/mm/cd/b:cV	([B)V
    //   789: aload_0
    //   790: getstatic 62	com/tencent/mm/plugin/voip/model/d:FqG	[B
    //   793: arraylength
    //   794: getstatic 64	com/tencent/mm/plugin/voip/model/d:FqH	[B
    //   797: arraylength
    //   798: iadd
    //   799: newarray byte
    //   801: putfield 83	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   804: getstatic 62	com/tencent/mm/plugin/voip/model/d:FqG	[B
    //   807: iconst_0
    //   808: aload_0
    //   809: getfield 83	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   812: iconst_0
    //   813: getstatic 62	com/tencent/mm/plugin/voip/model/d:FqG	[B
    //   816: arraylength
    //   817: invokestatic 292	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   820: getstatic 62	com/tencent/mm/plugin/voip/model/d:FqG	[B
    //   823: arraylength
    //   824: istore_2
    //   825: getstatic 64	com/tencent/mm/plugin/voip/model/d:FqH	[B
    //   828: iconst_0
    //   829: aload_0
    //   830: getfield 83	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   833: iload_2
    //   834: iconst_0
    //   835: iadd
    //   836: getstatic 64	com/tencent/mm/plugin/voip/model/d:FqH	[B
    //   839: arraylength
    //   840: invokestatic 292	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   843: goto -530 -> 313
    //   846: astore_1
    //   847: aload_0
    //   848: aload_0
    //   849: getfield 109	com/tencent/mm/plugin/voip/model/d:FqT	I
    //   852: iconst_2
    //   853: ior
    //   854: putfield 109	com/tencent/mm/plugin/voip/model/d:FqT	I
    //   857: ldc 175
    //   859: new 163	java/lang/StringBuilder
    //   862: dup
    //   863: ldc_w 375
    //   866: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   869: aload_1
    //   870: invokevirtual 376	java/lang/Exception:toString	()Ljava/lang/String;
    //   873: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   879: invokestatic 379	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   882: ldc 251
    //   884: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   887: iconst_m1
    //   888: ireturn
    //   889: iconst_0
    //   890: istore_2
    //   891: goto -187 -> 704
    //   894: new 381	com/tencent/mm/plugin/voip/model/g
    //   897: dup
    //   898: invokespecial 382	com/tencent/mm/plugin/voip/model/g:<init>	()V
    //   901: aload 12
    //   903: invokevirtual 386	com/tencent/mm/plugin/voip/model/g:cv	([B)[B
    //   906: putstatic 62	com/tencent/mm/plugin/voip/model/d:FqG	[B
    //   909: goto -188 -> 721
    //   912: astore_1
    //   913: aload_0
    //   914: aload_0
    //   915: getfield 109	com/tencent/mm/plugin/voip/model/d:FqT	I
    //   918: iconst_2
    //   919: ior
    //   920: putfield 109	com/tencent/mm/plugin/voip/model/d:FqT	I
    //   923: ldc 175
    //   925: new 163	java/lang/StringBuilder
    //   928: dup
    //   929: ldc_w 375
    //   932: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   935: aload_1
    //   936: invokevirtual 387	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   939: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   945: invokestatic 379	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   948: ldc 251
    //   950: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   953: iconst_m1
    //   954: ireturn
    //   955: new 389	com/tencent/mm/protocal/protobuf/cip
    //   958: dup
    //   959: invokespecial 390	com/tencent/mm/protocal/protobuf/cip:<init>	()V
    //   962: aload_1
    //   963: invokevirtual 391	com/tencent/mm/protocal/protobuf/cip:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   966: checkcast 389	com/tencent/mm/protocal/protobuf/cip
    //   969: astore 12
    //   971: aload 12
    //   973: getfield 395	com/tencent/mm/protocal/protobuf/cip:Tpv	Ljava/util/LinkedList;
    //   976: invokevirtual 401	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   979: checkcast 141	java/lang/Integer
    //   982: invokevirtual 404	java/lang/Integer:intValue	()I
    //   985: istore 7
    //   987: iconst_0
    //   988: istore 5
    //   990: ldc 175
    //   992: ldc_w 406
    //   995: iload 7
    //   997: invokestatic 367	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1000: invokevirtual 161	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1003: invokestatic 260	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1006: iload_2
    //   1007: iconst_1
    //   1008: if_icmpne +185 -> 1193
    //   1011: aload_0
    //   1012: getfield 83	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   1015: arraylength
    //   1016: istore 5
    //   1018: iload 7
    //   1020: iload 5
    //   1022: iadd
    //   1023: istore 6
    //   1025: iload 6
    //   1027: newarray byte
    //   1029: astore_1
    //   1030: aload_0
    //   1031: getfield 83	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   1034: iconst_0
    //   1035: aload_1
    //   1036: iconst_0
    //   1037: iload 5
    //   1039: invokestatic 292	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1042: iload 5
    //   1044: iconst_0
    //   1045: iadd
    //   1046: istore 5
    //   1048: goto +881 -> 1929
    //   1051: iconst_4
    //   1052: invokestatic 209	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1055: astore 13
    //   1057: aload 12
    //   1059: getfield 409	com/tencent/mm/protocal/protobuf/cip:Tps	Lcom/tencent/mm/cd/b;
    //   1062: aload 13
    //   1064: invokevirtual 231	java/nio/ByteBuffer:array	()[B
    //   1067: iload 7
    //   1069: iconst_0
    //   1070: iconst_4
    //   1071: invokevirtual 413	com/tencent/mm/cd/b:k	([BIII)V
    //   1074: aload 13
    //   1076: getstatic 416	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   1079: invokevirtual 219	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1082: pop
    //   1083: aload 13
    //   1085: iconst_0
    //   1086: invokevirtual 420	java/nio/ByteBuffer:getInt	(I)I
    //   1089: istore 9
    //   1091: aload_0
    //   1092: getfield 103	com/tencent/mm/plugin/voip/model/d:FqQ	[B
    //   1095: iconst_0
    //   1096: aload_1
    //   1097: iload 7
    //   1099: iload 5
    //   1101: iadd
    //   1102: iconst_4
    //   1103: invokestatic 292	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1106: iload 7
    //   1108: iconst_4
    //   1109: iadd
    //   1110: istore 7
    //   1112: aload 12
    //   1114: getfield 409	com/tencent/mm/protocal/protobuf/cip:Tps	Lcom/tencent/mm/cd/b;
    //   1117: aload_1
    //   1118: iload 7
    //   1120: iload 7
    //   1122: iload 5
    //   1124: iadd
    //   1125: iload 9
    //   1127: invokevirtual 413	com/tencent/mm/cd/b:k	([BIII)V
    //   1130: iload 8
    //   1132: iload 9
    //   1134: iconst_4
    //   1135: iadd
    //   1136: isub
    //   1137: istore 8
    //   1139: ldc 175
    //   1141: new 163	java/lang/StringBuilder
    //   1144: dup
    //   1145: ldc_w 422
    //   1148: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1151: iload 9
    //   1153: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1156: ldc_w 424
    //   1159: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: iload 6
    //   1164: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1167: ldc_w 426
    //   1170: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: iload_2
    //   1174: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1177: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1180: invokestatic 260	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1183: iload 8
    //   1185: ifgt +734 -> 1919
    //   1188: iconst_0
    //   1189: istore_2
    //   1190: goto -873 -> 317
    //   1193: iload 7
    //   1195: newarray byte
    //   1197: astore_1
    //   1198: iload 7
    //   1200: istore 6
    //   1202: goto +727 -> 1929
    //   1205: astore_1
    //   1206: aload_0
    //   1207: aload_0
    //   1208: getfield 109	com/tencent/mm/plugin/voip/model/d:FqT	I
    //   1211: iconst_4
    //   1212: ior
    //   1213: putfield 109	com/tencent/mm/plugin/voip/model/d:FqT	I
    //   1216: ldc 175
    //   1218: new 163	java/lang/StringBuilder
    //   1221: dup
    //   1222: ldc_w 428
    //   1225: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1228: aload_1
    //   1229: invokevirtual 376	java/lang/Exception:toString	()Ljava/lang/String;
    //   1232: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1235: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1238: invokestatic 379	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1241: ldc 251
    //   1243: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1246: iconst_m1
    //   1247: ireturn
    //   1248: astore_1
    //   1249: aload_0
    //   1250: aload_0
    //   1251: getfield 109	com/tencent/mm/plugin/voip/model/d:FqT	I
    //   1254: iconst_4
    //   1255: ior
    //   1256: putfield 109	com/tencent/mm/plugin/voip/model/d:FqT	I
    //   1259: ldc 175
    //   1261: new 163	java/lang/StringBuilder
    //   1264: dup
    //   1265: ldc_w 428
    //   1268: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1271: aload_1
    //   1272: invokevirtual 387	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   1275: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1278: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1281: invokestatic 379	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1284: ldc 251
    //   1286: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1289: iconst_m1
    //   1290: ireturn
    //   1291: astore 12
    //   1293: ldc 175
    //   1295: new 163	java/lang/StringBuilder
    //   1298: dup
    //   1299: ldc_w 430
    //   1302: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1305: aload 12
    //   1307: invokevirtual 431	java/io/IOException:toString	()Ljava/lang/String;
    //   1310: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1316: invokestatic 379	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1319: goto -980 -> 339
    //   1322: astore 12
    //   1324: ldc 175
    //   1326: new 163	java/lang/StringBuilder
    //   1329: dup
    //   1330: ldc_w 433
    //   1333: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1336: aload 12
    //   1338: invokevirtual 376	java/lang/Exception:toString	()Ljava/lang/String;
    //   1341: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1344: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1347: invokestatic 379	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1350: goto -958 -> 392
    //   1353: astore 12
    //   1355: aload_0
    //   1356: aload_0
    //   1357: getfield 109	com/tencent/mm/plugin/voip/model/d:FqT	I
    //   1360: bipush 16
    //   1362: ior
    //   1363: putfield 109	com/tencent/mm/plugin/voip/model/d:FqT	I
    //   1366: ldc 175
    //   1368: new 163	java/lang/StringBuilder
    //   1371: dup
    //   1372: ldc_w 430
    //   1375: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1378: aload 12
    //   1380: invokevirtual 376	java/lang/Exception:toString	()Ljava/lang/String;
    //   1383: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1386: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1389: invokestatic 379	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1392: aload_0
    //   1393: getfield 87	com/tencent/mm/plugin/voip/model/d:FqL	Z
    //   1396: ifne +94 -> 1490
    //   1399: ldc 175
    //   1401: ldc_w 435
    //   1404: invokestatic 379	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1407: ldc 251
    //   1409: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1412: iconst_m1
    //   1413: ireturn
    //   1414: ldc_w 437
    //   1417: getstatic 66	com/tencent/mm/plugin/voip/model/d:FqJ	I
    //   1420: getstatic 68	com/tencent/mm/plugin/voip/model/d:FqK	I
    //   1423: invokestatic 318	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   1426: astore 12
    //   1428: goto -1015 -> 413
    //   1431: astore 12
    //   1433: aload_0
    //   1434: aload_0
    //   1435: getfield 109	com/tencent/mm/plugin/voip/model/d:FqT	I
    //   1438: bipush 8
    //   1440: ior
    //   1441: putfield 109	com/tencent/mm/plugin/voip/model/d:FqT	I
    //   1444: ldc 175
    //   1446: new 163	java/lang/StringBuilder
    //   1449: dup
    //   1450: ldc_w 439
    //   1453: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1456: aload 13
    //   1458: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1461: ldc_w 441
    //   1464: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1467: aload 12
    //   1469: invokevirtual 444	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1472: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1475: invokestatic 379	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1478: aload_0
    //   1479: invokespecial 446	com/tencent/mm/plugin/voip/model/d:eWo	()I
    //   1482: pop
    //   1483: ldc 251
    //   1485: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1488: iconst_m1
    //   1489: ireturn
    //   1490: aload_0
    //   1491: getfield 91	com/tencent/mm/plugin/voip/model/d:FqN	Z
    //   1494: ifne +8 -> 1502
    //   1497: aload_0
    //   1498: iconst_1
    //   1499: putfield 91	com/tencent/mm/plugin/voip/model/d:FqN	Z
    //   1502: aload_1
    //   1503: arraylength
    //   1504: istore_2
    //   1505: aload_0
    //   1506: getfield 85	com/tencent/mm/plugin/voip/model/d:FqI	Z
    //   1509: ifeq +89 -> 1598
    //   1512: aload_1
    //   1513: iconst_4
    //   1514: baload
    //   1515: bipush 126
    //   1517: iand
    //   1518: iconst_1
    //   1519: ishr
    //   1520: istore 5
    //   1522: iload 5
    //   1524: bipush 32
    //   1526: if_icmpeq +10 -> 1536
    //   1529: iload 5
    //   1531: bipush 33
    //   1533: if_icmpne +37 -> 1570
    //   1536: bipush 83
    //   1538: istore 4
    //   1540: aload_0
    //   1541: getfield 93	com/tencent/mm/plugin/voip/model/d:FqO	Z
    //   1544: ifeq +110 -> 1654
    //   1547: iload 4
    //   1549: bipush 80
    //   1551: if_icmpne +103 -> 1654
    //   1554: ldc 175
    //   1556: ldc_w 448
    //   1559: invokestatic 379	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1562: ldc 251
    //   1564: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1567: bipush 254
    //   1569: ireturn
    //   1570: iload 5
    //   1572: bipush 19
    //   1574: if_icmpeq +10 -> 1584
    //   1577: iload 5
    //   1579: bipush 39
    //   1581: if_icmpne +10 -> 1591
    //   1584: bipush 73
    //   1586: istore 4
    //   1588: goto -48 -> 1540
    //   1591: bipush 80
    //   1593: istore 4
    //   1595: goto -55 -> 1540
    //   1598: aload_1
    //   1599: iconst_4
    //   1600: baload
    //   1601: bipush 31
    //   1603: iand
    //   1604: istore 5
    //   1606: iload 5
    //   1608: bipush 7
    //   1610: if_icmpeq +10 -> 1620
    //   1613: iload 5
    //   1615: bipush 8
    //   1617: if_icmpne +10 -> 1627
    //   1620: bipush 83
    //   1622: istore 4
    //   1624: goto -84 -> 1540
    //   1627: iload 5
    //   1629: iconst_5
    //   1630: if_icmpeq +10 -> 1640
    //   1633: iload 5
    //   1635: bipush 6
    //   1637: if_icmpne +10 -> 1647
    //   1640: bipush 73
    //   1642: istore 4
    //   1644: goto -104 -> 1540
    //   1647: bipush 80
    //   1649: istore 4
    //   1651: goto -111 -> 1540
    //   1654: aload_0
    //   1655: getfield 132	com/tencent/mm/plugin/voip/model/d:FqE	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   1658: ldc2_w 449
    //   1661: invokevirtual 454	com/tencent/mm/compatible/deviceinfo/aa:EX	(J)I
    //   1664: istore 5
    //   1666: iload 5
    //   1668: iflt +210 -> 1878
    //   1671: aload_1
    //   1672: ifnull +185 -> 1857
    //   1675: iload_2
    //   1676: ifle +181 -> 1857
    //   1679: invokestatic 266	java/lang/System:currentTimeMillis	()J
    //   1682: lstore 10
    //   1684: ldc 175
    //   1686: new 163	java/lang/StringBuilder
    //   1689: dup
    //   1690: ldc_w 456
    //   1693: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1696: iload 5
    //   1698: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1701: ldc_w 458
    //   1704: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1707: iload_2
    //   1708: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1711: ldc_w 460
    //   1714: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1717: iload 4
    //   1719: invokevirtual 463	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1722: ldc_w 465
    //   1725: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1728: lload 10
    //   1730: invokevirtual 468	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1733: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1736: invokestatic 260	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1739: getstatic 473	android/os/Build$VERSION:SDK_INT	I
    //   1742: bipush 21
    //   1744: if_icmpge +120 -> 1864
    //   1747: aload_0
    //   1748: getfield 132	com/tencent/mm/plugin/voip/model/d:FqE	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   1751: invokevirtual 477	com/tencent/mm/compatible/deviceinfo/aa:avj	()[Ljava/nio/ByteBuffer;
    //   1754: iload 5
    //   1756: aaload
    //   1757: astore 12
    //   1759: aload 12
    //   1761: invokevirtual 481	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1764: pop
    //   1765: aload 12
    //   1767: invokevirtual 481	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1770: pop
    //   1771: aload 12
    //   1773: aload_1
    //   1774: iconst_0
    //   1775: iload_2
    //   1776: invokevirtual 484	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1779: pop
    //   1780: aload_0
    //   1781: getfield 132	com/tencent/mm/plugin/voip/model/d:FqE	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   1784: iload 5
    //   1786: iload_2
    //   1787: lload 10
    //   1789: iconst_0
    //   1790: invokevirtual 487	com/tencent/mm/compatible/deviceinfo/aa:a	(IIJI)V
    //   1793: aload_0
    //   1794: aload_0
    //   1795: getfield 107	com/tencent/mm/plugin/voip/model/d:FqS	I
    //   1798: iconst_1
    //   1799: iadd
    //   1800: putfield 107	com/tencent/mm/plugin/voip/model/d:FqS	I
    //   1803: aload_0
    //   1804: iconst_0
    //   1805: putfield 95	com/tencent/mm/plugin/voip/model/d:FqP	I
    //   1808: aload_0
    //   1809: getfield 93	com/tencent/mm/plugin/voip/model/d:FqO	Z
    //   1812: ifeq +45 -> 1857
    //   1815: iconst_1
    //   1816: invokestatic 209	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1819: astore_1
    //   1820: aload_1
    //   1821: getstatic 215	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   1824: invokevirtual 219	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1827: pop
    //   1828: aload_1
    //   1829: iconst_0
    //   1830: invokevirtual 223	java/nio/ByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   1833: pop
    //   1834: aload_0
    //   1835: getfield 99	com/tencent/mm/plugin/voip/model/d:NJk	Lcom/tencent/mm/plugin/voip/model/l;
    //   1838: getfield 227	com/tencent/mm/plugin/voip/model/l:NMi	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1841: bipush 28
    //   1843: aload_1
    //   1844: invokevirtual 231	java/nio/ByteBuffer:array	()[B
    //   1847: iconst_1
    //   1848: invokevirtual 237	com/tencent/mm/plugin/voip/model/v2protocal:setAppCmd	(I[BI)I
    //   1851: pop
    //   1852: aload_0
    //   1853: iconst_0
    //   1854: putfield 93	com/tencent/mm/plugin/voip/model/d:FqO	Z
    //   1857: ldc 251
    //   1859: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1862: iconst_0
    //   1863: ireturn
    //   1864: aload_0
    //   1865: getfield 132	com/tencent/mm/plugin/voip/model/d:FqE	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   1868: iload 5
    //   1870: invokevirtual 490	com/tencent/mm/compatible/deviceinfo/aa:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   1873: astore 12
    //   1875: goto -110 -> 1765
    //   1878: aload_0
    //   1879: getfield 93	com/tencent/mm/plugin/voip/model/d:FqO	Z
    //   1882: ifeq +21 -> 1903
    //   1885: iload 4
    //   1887: bipush 80
    //   1889: if_icmpeq +14 -> 1903
    //   1892: aload_0
    //   1893: aload_0
    //   1894: getfield 109	com/tencent/mm/plugin/voip/model/d:FqT	I
    //   1897: bipush 32
    //   1899: ior
    //   1900: putfield 109	com/tencent/mm/plugin/voip/model/d:FqT	I
    //   1903: aload_0
    //   1904: invokespecial 446	com/tencent/mm/plugin/voip/model/d:eWo	()I
    //   1907: pop
    //   1908: ldc 175
    //   1910: ldc_w 492
    //   1913: invokestatic 379	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1916: goto -59 -> 1857
    //   1919: iload 7
    //   1921: iload 9
    //   1923: iadd
    //   1924: istore 7
    //   1926: goto -875 -> 1051
    //   1929: iconst_0
    //   1930: istore 9
    //   1932: iload 7
    //   1934: istore 8
    //   1936: iload 9
    //   1938: istore 7
    //   1940: goto -889 -> 1051
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1943	0	this	d
    //   0	1943	1	paramArrayOfByte	byte[]
    //   0	1943	2	paramInt	int
    //   0	1943	3	paramBoolean	boolean
    //   1538	352	4	c	char
    //   101	1768	5	i	int
    //   111	1090	6	j	int
    //   985	954	7	k	int
    //   1130	805	8	m	int
    //   1089	848	9	n	int
    //   1682	106	10	l	long
    //   366	747	12	localObject1	Object
    //   1291	15	12	localIOException	java.io.IOException
    //   1322	15	12	localException1	Exception
    //   1353	26	12	localException2	Exception
    //   1426	1	12	localMediaFormat	MediaFormat
    //   1431	37	12	localException3	Exception
    //   1757	117	12	localByteBuffer	ByteBuffer
    //   447	1010	13	localObject2	Object
    //   637	39	14	str	String
    // Exception table:
    //   from	to	target	type
    //   69	91	846	java/lang/Exception
    //   93	113	846	java/lang/Exception
    //   117	129	846	java/lang/Exception
    //   129	313	846	java/lang/Exception
    //   534	543	846	java/lang/Exception
    //   546	558	846	java/lang/Exception
    //   558	682	846	java/lang/Exception
    //   687	702	846	java/lang/Exception
    //   708	721	846	java/lang/Exception
    //   721	843	846	java/lang/Exception
    //   894	909	846	java/lang/Exception
    //   69	91	912	java/lang/OutOfMemoryError
    //   93	113	912	java/lang/OutOfMemoryError
    //   117	129	912	java/lang/OutOfMemoryError
    //   129	313	912	java/lang/OutOfMemoryError
    //   534	543	912	java/lang/OutOfMemoryError
    //   546	558	912	java/lang/OutOfMemoryError
    //   558	682	912	java/lang/OutOfMemoryError
    //   687	702	912	java/lang/OutOfMemoryError
    //   708	721	912	java/lang/OutOfMemoryError
    //   721	843	912	java/lang/OutOfMemoryError
    //   894	909	912	java/lang/OutOfMemoryError
    //   955	987	1205	java/lang/Exception
    //   990	1006	1205	java/lang/Exception
    //   1011	1018	1205	java/lang/Exception
    //   1025	1042	1205	java/lang/Exception
    //   1051	1106	1205	java/lang/Exception
    //   1112	1130	1205	java/lang/Exception
    //   1139	1183	1205	java/lang/Exception
    //   1193	1198	1205	java/lang/Exception
    //   955	987	1248	java/lang/OutOfMemoryError
    //   990	1006	1248	java/lang/OutOfMemoryError
    //   1011	1018	1248	java/lang/OutOfMemoryError
    //   1025	1042	1248	java/lang/OutOfMemoryError
    //   1051	1106	1248	java/lang/OutOfMemoryError
    //   1112	1130	1248	java/lang/OutOfMemoryError
    //   1139	1183	1248	java/lang/OutOfMemoryError
    //   1193	1198	1248	java/lang/OutOfMemoryError
    //   328	339	1291	java/io/IOException
    //   373	392	1322	java/lang/Exception
    //   343	368	1353	java/lang/Exception
    //   392	413	1353	java/lang/Exception
    //   413	469	1353	java/lang/Exception
    //   499	527	1353	java/lang/Exception
    //   1324	1350	1353	java/lang/Exception
    //   1414	1428	1353	java/lang/Exception
    //   1433	1483	1353	java/lang/Exception
    //   469	499	1431	java/lang/Exception
  }
  
  @SuppressLint({"NewApi"})
  public final void run()
  {
    AppMethodBeat.i(114830);
    if ((!Thread.interrupted()) && (this.FqM)) {
      if ((this.FqE == null) || (!this.FqL) || (!this.FqN)) {}
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
          i = this.FqE.a(localBufferInfo, 10000L);
          Log.d("MicroMsg.AvcDecoder", "steve:  outIndex=".concat(String.valueOf(i)));
          switch (i)
          {
          case -3: 
            if (localBufferInfo.size <= 0) {
              break label414;
            }
            long l1 = localBufferInfo.presentationTimeUs;
            long l2 = System.currentTimeMillis();
            Log.d("MicroMsg.AvcDecoder", "DECODER_THREAD:: decoded SUCCESSFULLY!!! cnt : " + this.FqR + ", size:" + localBufferInfo.size + ", pts:" + localBufferInfo.presentationTimeUs + ", latency:" + (l2 - l1));
            this.FqR += 1;
            this.FqE.releaseOutputBuffer(i, true);
            l2 = System.currentTimeMillis();
            Log.d("MicroMsg.AvcDecoder", "steve: Avcdecoder frame processTime = " + (l2 - l1) + ", decFrameCnt=" + this.FqR + ", endTime=" + l2);
          }
        }
        catch (Exception localException1)
        {
          this.FqT |= 0x80;
          eWo();
          Log.e("MicroMsg.AvcDecoder", " dequeueOutputBuffer/releaseOutputBuffer error:" + localException1.toString());
        }
        break;
        Log.d("MicroMsg.AvcDecoder", "INFO_OUTPUT_BUFFERS_CHANGED");
        break;
        Object localObject = this.FqE.avi();
        Log.i("MicroMsg.AvcDecoder", "DECODER_THREAD:: New format : ".concat(String.valueOf(localObject)));
        int i = ((MediaFormat)localObject).getInteger("width");
        int j = ((MediaFormat)localObject).getInteger("height");
        if (this.NJk == null) {
          break;
        }
        localObject = this.NJk;
        ((l)localObject).mHandler.post(new l.5((l)localObject, j, i));
        break;
        Log.d("MicroMsg.AvcDecoder", "DECODER_THREAD:: dequeueOutputBuffer timed out!");
        break;
        label414:
        Log.d("MicroMsg.AvcDecoder", "steve: drop frame: " + this.FqR + ", size:" + ((MediaCodec.BufferInfo)localObject).size + ", pts:" + ((MediaCodec.BufferInfo)localObject).presentationTimeUs);
        this.FqE.releaseOutputBuffer(i, false);
        break;
        try
        {
          Thread.sleep(20L);
        }
        catch (InterruptedException localInterruptedException)
        {
          Log.e("MicroMsg.AvcDecoder", " error:" + localInterruptedException.toString());
        }
      }
      break;
      if ((!this.FqM) && (this.FqE != null)) {
        try
        {
          this.FqE.stop();
          this.FqE.release();
          this.FqE = null;
          AppMethodBeat.o(114830);
          return;
        }
        catch (Exception localException2)
        {
          Log.e("MicroMsg.AvcDecoder", " decoder stop  error:" + localException2.toString());
        }
      }
      AppMethodBeat.o(114830);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.d
 * JD-Core Version:    0.7.0.1
 */