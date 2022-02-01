package com.tencent.mm.plugin.voip.model;

import android.annotation.SuppressLint;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.io.BufferedOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class d
  extends Thread
{
  public static int zLk;
  private static String zLl;
  public static byte[] zLo;
  public static byte[] zLp;
  public static byte[] zLq;
  public static int zLs;
  public static int zLt;
  l GSZ;
  public byte[] configbyte;
  public boolean mIsStart;
  BufferedOutputStream outputStream;
  private Surface surface;
  public int zLA;
  public int zLB;
  public int zLC;
  public byte[] zLG;
  public byte[] zLH;
  public byte[] zLI;
  BufferedOutputStream zLm;
  private z zLn;
  private boolean zLr;
  private boolean zLu;
  public boolean zLv;
  public boolean zLw;
  public boolean zLx;
  public int zLy;
  public byte[] zLz;
  
  static
  {
    AppMethodBeat.i(177014);
    zLk = 64;
    zLl = b.aKJ();
    zLo = null;
    zLp = null;
    zLq = null;
    zLs = 640;
    zLt = 480;
    AppMethodBeat.o(177014);
  }
  
  public d(Surface paramSurface)
  {
    AppMethodBeat.i(114825);
    this.outputStream = null;
    this.zLm = null;
    this.configbyte = null;
    this.zLr = false;
    this.zLu = false;
    this.zLv = true;
    this.zLw = true;
    this.zLx = false;
    this.zLy = 0;
    this.mIsStart = false;
    this.GSZ = null;
    this.zLz = new byte[] { 0, 0, 0, 1 };
    this.zLA = 0;
    this.zLB = 0;
    this.zLC = 0;
    this.zLG = new byte[] { 103, 100, 0, 13, -84, -74, 10, 15, -120 };
    this.zLH = new byte[] { 0, 0, 0, 1, 40, -50, 60, 48 };
    this.zLI = new byte[] { 13, 0, -15, 98, -22 };
    this.zLv = true;
    this.zLw = true;
    this.zLn = null;
    this.zLr = false;
    this.zLC = 0;
    if (paramSurface != null) {
      this.surface = paramSurface;
    }
    AppMethodBeat.o(114825);
  }
  
  private static String bO(byte[] paramArrayOfByte)
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
  
  private int emA()
  {
    AppMethodBeat.i(114827);
    this.zLy += 1;
    Log.i("MeidaCodec[HWDec]", "[HW]:DecFrmError: I Req mIReqFlag = " + this.zLx + ", mIsHWDecEnable = " + this.zLv + ", mHWErrorDecFrmCount = " + this.zLy);
    if ((!this.zLv) || (this.zLy > zLk))
    {
      this.GSZ.aF(true, this.zLr);
      this.zLC |= 0x40;
      Log.i("MeidaCodec[HWDec]", "[HW]: ErrFrm > threshold, end HWDec!!");
      AppMethodBeat.o(114827);
      return 0;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(1);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.put((byte)1);
    this.GSZ.GVV.setAppCmd(28, localByteBuffer.array(), 1);
    this.zLx = true;
    AppMethodBeat.o(114827);
    return 1;
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(114826);
    this.GSZ = paraml;
    Log.i("MeidaCodec[HWDec]", "setStrategyCaller");
    AppMethodBeat.o(114826);
  }
  
  /* Error */
  public final int f(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 249
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iload_3
    //   6: ifeq +22 -> 28
    //   9: aload_0
    //   10: getfield 132	com/tencent/mm/plugin/voip/model/d:zLn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   13: ifnull +8 -> 21
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 87	com/tencent/mm/plugin/voip/model/d:zLu	Z
    //   21: ldc 251
    //   23: ldc 253
    //   25: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield 89	com/tencent/mm/plugin/voip/model/d:zLv	Z
    //   32: ifne +27 -> 59
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 109	com/tencent/mm/plugin/voip/model/d:zLC	I
    //   40: iconst_1
    //   41: ior
    //   42: putfield 109	com/tencent/mm/plugin/voip/model/d:zLC	I
    //   45: ldc 251
    //   47: ldc 255
    //   49: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: ldc 249
    //   54: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: iconst_m1
    //   58: ireturn
    //   59: invokestatic 264	java/lang/System:currentTimeMillis	()J
    //   62: pop2
    //   63: aconst_null
    //   64: astore 12
    //   66: iload_2
    //   67: iconst_2
    //   68: if_icmpne +866 -> 934
    //   71: new 266	com/tencent/mm/protocal/protobuf/cap
    //   74: dup
    //   75: invokespecial 267	com/tencent/mm/protocal/protobuf/cap:<init>	()V
    //   78: aload_1
    //   79: invokevirtual 271	com/tencent/mm/protocal/protobuf/cap:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   82: checkcast 266	com/tencent/mm/protocal/protobuf/cap
    //   85: astore_1
    //   86: aload_1
    //   87: getfield 275	com/tencent/mm/protocal/protobuf/cap:MfN	Lcom/tencent/mm/bw/b;
    //   90: ifnonnull +455 -> 545
    //   93: iconst_0
    //   94: istore 5
    //   96: aload_1
    //   97: getfield 278	com/tencent/mm/protocal/protobuf/cap:MfL	Lcom/tencent/mm/bw/b;
    //   100: getfield 283	com/tencent/mm/bw/b:zy	[B
    //   103: arraylength
    //   104: istore 6
    //   106: aload_1
    //   107: getfield 286	com/tencent/mm/protocal/protobuf/cap:MfM	Lcom/tencent/mm/bw/b;
    //   110: getfield 283	com/tencent/mm/bw/b:zy	[B
    //   113: arraylength
    //   114: istore 7
    //   116: iload 5
    //   118: ifeq +440 -> 558
    //   121: aload_0
    //   122: getfield 85	com/tencent/mm/plugin/voip/model/d:zLr	Z
    //   125: ifne +8 -> 133
    //   128: aload_0
    //   129: iconst_0
    //   130: putfield 87	com/tencent/mm/plugin/voip/model/d:zLu	Z
    //   133: aload_0
    //   134: iconst_1
    //   135: putfield 85	com/tencent/mm/plugin/voip/model/d:zLr	Z
    //   138: iload 5
    //   140: iconst_4
    //   141: iadd
    //   142: newarray byte
    //   144: putstatic 60	com/tencent/mm/plugin/voip/model/d:zLo	[B
    //   147: iload 6
    //   149: iconst_4
    //   150: iadd
    //   151: newarray byte
    //   153: putstatic 62	com/tencent/mm/plugin/voip/model/d:zLp	[B
    //   156: iload 7
    //   158: iconst_4
    //   159: iadd
    //   160: newarray byte
    //   162: putstatic 64	com/tencent/mm/plugin/voip/model/d:zLq	[B
    //   165: aload_0
    //   166: getfield 103	com/tencent/mm/plugin/voip/model/d:zLz	[B
    //   169: iconst_0
    //   170: getstatic 60	com/tencent/mm/plugin/voip/model/d:zLo	[B
    //   173: iconst_0
    //   174: iconst_4
    //   175: invokestatic 290	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   178: aload_0
    //   179: getfield 103	com/tencent/mm/plugin/voip/model/d:zLz	[B
    //   182: iconst_0
    //   183: getstatic 62	com/tencent/mm/plugin/voip/model/d:zLp	[B
    //   186: iconst_0
    //   187: iconst_4
    //   188: invokestatic 290	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   191: aload_0
    //   192: getfield 103	com/tencent/mm/plugin/voip/model/d:zLz	[B
    //   195: iconst_0
    //   196: getstatic 64	com/tencent/mm/plugin/voip/model/d:zLq	[B
    //   199: iconst_0
    //   200: iconst_4
    //   201: invokestatic 290	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   204: aload_1
    //   205: getfield 275	com/tencent/mm/protocal/protobuf/cap:MfN	Lcom/tencent/mm/bw/b;
    //   208: getstatic 60	com/tencent/mm/plugin/voip/model/d:zLo	[B
    //   211: invokevirtual 294	com/tencent/mm/bw/b:cE	([B)V
    //   214: aload_1
    //   215: getfield 278	com/tencent/mm/protocal/protobuf/cap:MfL	Lcom/tencent/mm/bw/b;
    //   218: getstatic 62	com/tencent/mm/plugin/voip/model/d:zLp	[B
    //   221: invokevirtual 294	com/tencent/mm/bw/b:cE	([B)V
    //   224: aload_1
    //   225: getfield 286	com/tencent/mm/protocal/protobuf/cap:MfM	Lcom/tencent/mm/bw/b;
    //   228: getstatic 64	com/tencent/mm/plugin/voip/model/d:zLq	[B
    //   231: invokevirtual 294	com/tencent/mm/bw/b:cE	([B)V
    //   234: aload_0
    //   235: getstatic 60	com/tencent/mm/plugin/voip/model/d:zLo	[B
    //   238: arraylength
    //   239: getstatic 62	com/tencent/mm/plugin/voip/model/d:zLp	[B
    //   242: arraylength
    //   243: iadd
    //   244: getstatic 64	com/tencent/mm/plugin/voip/model/d:zLq	[B
    //   247: arraylength
    //   248: iadd
    //   249: newarray byte
    //   251: putfield 83	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   254: getstatic 60	com/tencent/mm/plugin/voip/model/d:zLo	[B
    //   257: iconst_0
    //   258: aload_0
    //   259: getfield 83	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   262: iconst_0
    //   263: getstatic 60	com/tencent/mm/plugin/voip/model/d:zLo	[B
    //   266: arraylength
    //   267: invokestatic 290	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   270: getstatic 60	com/tencent/mm/plugin/voip/model/d:zLo	[B
    //   273: arraylength
    //   274: iconst_0
    //   275: iadd
    //   276: istore 5
    //   278: getstatic 62	com/tencent/mm/plugin/voip/model/d:zLp	[B
    //   281: iconst_0
    //   282: aload_0
    //   283: getfield 83	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   286: iload 5
    //   288: getstatic 62	com/tencent/mm/plugin/voip/model/d:zLp	[B
    //   291: arraylength
    //   292: invokestatic 290	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   295: getstatic 62	com/tencent/mm/plugin/voip/model/d:zLp	[B
    //   298: arraylength
    //   299: istore 6
    //   301: getstatic 64	com/tencent/mm/plugin/voip/model/d:zLq	[B
    //   304: iconst_0
    //   305: aload_0
    //   306: getfield 83	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   309: iload 5
    //   311: iload 6
    //   313: iadd
    //   314: getstatic 64	com/tencent/mm/plugin/voip/model/d:zLq	[B
    //   317: arraylength
    //   318: invokestatic 290	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   321: iconst_1
    //   322: istore 5
    //   324: aload 12
    //   326: astore_1
    //   327: aload_1
    //   328: ifnull +21 -> 349
    //   331: aload_0
    //   332: getfield 81	com/tencent/mm/plugin/voip/model/d:zLm	Ljava/io/BufferedOutputStream;
    //   335: ifnull +14 -> 349
    //   338: aload_0
    //   339: getfield 81	com/tencent/mm/plugin/voip/model/d:zLm	Ljava/io/BufferedOutputStream;
    //   342: aload_1
    //   343: iconst_0
    //   344: aload_1
    //   345: arraylength
    //   346: invokevirtual 300	java/io/BufferedOutputStream:write	([BII)V
    //   349: iload 5
    //   351: ifeq +980 -> 1331
    //   354: getstatic 62	com/tencent/mm/plugin/voip/model/d:zLp	[B
    //   357: ifnull +974 -> 1331
    //   360: getstatic 64	com/tencent/mm/plugin/voip/model/d:zLq	[B
    //   363: ifnull +968 -> 1331
    //   366: aload_0
    //   367: getfield 87	com/tencent/mm/plugin/voip/model/d:zLu	Z
    //   370: ifne +168 -> 538
    //   373: aload_0
    //   374: getfield 132	com/tencent/mm/plugin/voip/model/d:zLn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   377: astore 12
    //   379: aload 12
    //   381: ifnull +22 -> 403
    //   384: aload_0
    //   385: getfield 132	com/tencent/mm/plugin/voip/model/d:zLn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   388: invokevirtual 305	com/tencent/mm/compatible/deviceinfo/z:stop	()V
    //   391: aload_0
    //   392: getfield 132	com/tencent/mm/plugin/voip/model/d:zLn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   395: invokevirtual 308	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   398: aload_0
    //   399: aconst_null
    //   400: putfield 132	com/tencent/mm/plugin/voip/model/d:zLn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   403: aload_0
    //   404: getfield 85	com/tencent/mm/plugin/voip/model/d:zLr	Z
    //   407: ifeq +946 -> 1353
    //   410: ldc_w 310
    //   413: getstatic 66	com/tencent/mm/plugin/voip/model/d:zLs	I
    //   416: getstatic 68	com/tencent/mm/plugin/voip/model/d:zLt	I
    //   419: invokestatic 316	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   422: astore 12
    //   424: aload 12
    //   426: ldc_w 318
    //   429: bipush 90
    //   431: invokevirtual 322	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   434: ldc 175
    //   436: ldc_w 324
    //   439: aload 12
    //   441: invokestatic 157	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   444: invokevirtual 161	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   447: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   450: aload 12
    //   452: ldc_w 326
    //   455: invokevirtual 329	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   458: astore 13
    //   460: aload 13
    //   462: ldc_w 331
    //   465: invokevirtual 335	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   468: ifeq +70 -> 538
    //   471: aload_0
    //   472: aload 13
    //   474: invokestatic 339	com/tencent/mm/compatible/deviceinfo/z:DZ	(Ljava/lang/String;)Lcom/tencent/mm/compatible/deviceinfo/z;
    //   477: putfield 132	com/tencent/mm/plugin/voip/model/d:zLn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   480: ldc 175
    //   482: ldc_w 341
    //   485: aload 12
    //   487: invokestatic 157	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   490: invokevirtual 161	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   493: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   496: aload_0
    //   497: getfield 132	com/tencent/mm/plugin/voip/model/d:zLn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   500: aload 12
    //   502: aload_0
    //   503: getfield 134	com/tencent/mm/plugin/voip/model/d:surface	Landroid/view/Surface;
    //   506: iconst_0
    //   507: invokevirtual 344	com/tencent/mm/compatible/deviceinfo/z:a	(Landroid/media/MediaFormat;Landroid/view/Surface;I)V
    //   510: aload_0
    //   511: getfield 132	com/tencent/mm/plugin/voip/model/d:zLn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   514: invokevirtual 347	com/tencent/mm/compatible/deviceinfo/z:start	()V
    //   517: aload_0
    //   518: iconst_1
    //   519: putfield 87	com/tencent/mm/plugin/voip/model/d:zLu	Z
    //   522: aload_0
    //   523: getfield 97	com/tencent/mm/plugin/voip/model/d:mIsStart	Z
    //   526: ifne +12 -> 538
    //   529: aload_0
    //   530: invokevirtual 348	com/tencent/mm/plugin/voip/model/d:start	()V
    //   533: aload_0
    //   534: iconst_1
    //   535: putfield 97	com/tencent/mm/plugin/voip/model/d:mIsStart	Z
    //   538: ldc 249
    //   540: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   543: iconst_1
    //   544: ireturn
    //   545: aload_1
    //   546: getfield 275	com/tencent/mm/protocal/protobuf/cap:MfN	Lcom/tencent/mm/bw/b;
    //   549: getfield 283	com/tencent/mm/bw/b:zy	[B
    //   552: arraylength
    //   553: istore 5
    //   555: goto -459 -> 96
    //   558: aload_0
    //   559: getfield 85	com/tencent/mm/plugin/voip/model/d:zLr	Z
    //   562: ifeq +8 -> 570
    //   565: aload_0
    //   566: iconst_0
    //   567: putfield 87	com/tencent/mm/plugin/voip/model/d:zLu	Z
    //   570: aload_0
    //   571: iconst_0
    //   572: putfield 85	com/tencent/mm/plugin/voip/model/d:zLr	Z
    //   575: iload 6
    //   577: iconst_4
    //   578: iadd
    //   579: newarray byte
    //   581: astore 13
    //   583: aload_0
    //   584: getfield 103	com/tencent/mm/plugin/voip/model/d:zLz	[B
    //   587: iconst_0
    //   588: aload 13
    //   590: iconst_0
    //   591: iconst_4
    //   592: invokestatic 290	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   595: aload_1
    //   596: getfield 278	com/tencent/mm/protocal/protobuf/cap:MfL	Lcom/tencent/mm/bw/b;
    //   599: aload 13
    //   601: invokevirtual 294	com/tencent/mm/bw/b:cE	([B)V
    //   604: ldc 175
    //   606: ldc_w 350
    //   609: aload 13
    //   611: invokestatic 157	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   614: invokevirtual 161	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   617: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   620: aload 13
    //   622: invokestatic 352	com/tencent/mm/plugin/voip/model/d:bO	([B)Ljava/lang/String;
    //   625: astore 14
    //   627: iconst_3
    //   628: newarray byte
    //   630: dup
    //   631: iconst_0
    //   632: ldc 100
    //   634: bastore
    //   635: dup
    //   636: iconst_1
    //   637: ldc 100
    //   639: bastore
    //   640: dup
    //   641: iconst_2
    //   642: ldc_w 353
    //   645: bastore
    //   646: invokestatic 352	com/tencent/mm/plugin/voip/model/d:bO	([B)Ljava/lang/String;
    //   649: astore 15
    //   651: ldc 175
    //   653: new 163	java/lang/StringBuilder
    //   656: dup
    //   657: ldc_w 355
    //   660: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   663: aload 14
    //   665: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: ldc_w 357
    //   671: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: aload 15
    //   676: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   685: aload 14
    //   687: aload 15
    //   689: iconst_0
    //   690: invokevirtual 361	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   693: istore 5
    //   695: iload 5
    //   697: iconst_m1
    //   698: if_icmpeq +212 -> 910
    //   701: ldc 175
    //   703: ldc_w 363
    //   706: iload 5
    //   708: invokestatic 365	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   711: invokevirtual 161	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   714: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   717: iconst_1
    //   718: istore 5
    //   720: iload 5
    //   722: ifeq +194 -> 916
    //   725: ldc 175
    //   727: ldc_w 367
    //   730: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   733: aload 13
    //   735: putstatic 62	com/tencent/mm/plugin/voip/model/d:zLp	[B
    //   738: ldc 175
    //   740: new 163	java/lang/StringBuilder
    //   743: dup
    //   744: ldc_w 369
    //   747: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   750: getstatic 62	com/tencent/mm/plugin/voip/model/d:zLp	[B
    //   753: arraylength
    //   754: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   757: ldc_w 371
    //   760: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: iload 6
    //   765: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   768: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   771: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   774: iload 7
    //   776: iconst_4
    //   777: iadd
    //   778: newarray byte
    //   780: putstatic 64	com/tencent/mm/plugin/voip/model/d:zLq	[B
    //   783: aload_0
    //   784: getfield 103	com/tencent/mm/plugin/voip/model/d:zLz	[B
    //   787: iconst_0
    //   788: getstatic 64	com/tencent/mm/plugin/voip/model/d:zLq	[B
    //   791: iconst_0
    //   792: iconst_4
    //   793: invokestatic 290	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   796: aload_1
    //   797: getfield 286	com/tencent/mm/protocal/protobuf/cap:MfM	Lcom/tencent/mm/bw/b;
    //   800: getstatic 64	com/tencent/mm/plugin/voip/model/d:zLq	[B
    //   803: invokevirtual 294	com/tencent/mm/bw/b:cE	([B)V
    //   806: aload_0
    //   807: getstatic 62	com/tencent/mm/plugin/voip/model/d:zLp	[B
    //   810: arraylength
    //   811: getstatic 64	com/tencent/mm/plugin/voip/model/d:zLq	[B
    //   814: arraylength
    //   815: iadd
    //   816: newarray byte
    //   818: putfield 83	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   821: getstatic 62	com/tencent/mm/plugin/voip/model/d:zLp	[B
    //   824: iconst_0
    //   825: aload_0
    //   826: getfield 83	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   829: iconst_0
    //   830: getstatic 62	com/tencent/mm/plugin/voip/model/d:zLp	[B
    //   833: arraylength
    //   834: invokestatic 290	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   837: getstatic 62	com/tencent/mm/plugin/voip/model/d:zLp	[B
    //   840: arraylength
    //   841: istore 5
    //   843: getstatic 64	com/tencent/mm/plugin/voip/model/d:zLq	[B
    //   846: iconst_0
    //   847: aload_0
    //   848: getfield 83	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   851: iload 5
    //   853: iconst_0
    //   854: iadd
    //   855: getstatic 64	com/tencent/mm/plugin/voip/model/d:zLq	[B
    //   858: arraylength
    //   859: invokestatic 290	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   862: goto -541 -> 321
    //   865: astore_1
    //   866: aload_0
    //   867: aload_0
    //   868: getfield 109	com/tencent/mm/plugin/voip/model/d:zLC	I
    //   871: iconst_2
    //   872: ior
    //   873: putfield 109	com/tencent/mm/plugin/voip/model/d:zLC	I
    //   876: ldc 175
    //   878: new 163	java/lang/StringBuilder
    //   881: dup
    //   882: ldc_w 373
    //   885: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   888: aload_1
    //   889: invokevirtual 374	java/lang/Exception:toString	()Ljava/lang/String;
    //   892: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   898: invokestatic 377	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   901: iconst_0
    //   902: istore 5
    //   904: aload 12
    //   906: astore_1
    //   907: goto -580 -> 327
    //   910: iconst_0
    //   911: istore 5
    //   913: goto -193 -> 720
    //   916: new 379	com/tencent/mm/plugin/voip/model/g
    //   919: dup
    //   920: invokespecial 380	com/tencent/mm/plugin/voip/model/g:<init>	()V
    //   923: aload 13
    //   925: invokevirtual 384	com/tencent/mm/plugin/voip/model/g:cf	([B)[B
    //   928: putstatic 62	com/tencent/mm/plugin/voip/model/d:zLp	[B
    //   931: goto -193 -> 738
    //   934: new 386	com/tencent/mm/protocal/protobuf/cao
    //   937: dup
    //   938: invokespecial 387	com/tencent/mm/protocal/protobuf/cao:<init>	()V
    //   941: aload_1
    //   942: invokevirtual 388	com/tencent/mm/protocal/protobuf/cao:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   945: checkcast 386	com/tencent/mm/protocal/protobuf/cao
    //   948: astore 13
    //   950: aload 13
    //   952: getfield 392	com/tencent/mm/protocal/protobuf/cao:MfJ	Ljava/util/LinkedList;
    //   955: invokevirtual 398	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   958: checkcast 141	java/lang/Integer
    //   961: invokevirtual 401	java/lang/Integer:intValue	()I
    //   964: istore 7
    //   966: iconst_0
    //   967: istore 5
    //   969: ldc 175
    //   971: ldc_w 403
    //   974: iload 7
    //   976: invokestatic 365	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   979: invokevirtual 161	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   982: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   985: iload_2
    //   986: iconst_1
    //   987: if_icmpne +186 -> 1173
    //   990: aload_0
    //   991: getfield 83	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   994: arraylength
    //   995: istore 5
    //   997: iload 7
    //   999: iload 5
    //   1001: iadd
    //   1002: istore 6
    //   1004: iload 6
    //   1006: newarray byte
    //   1008: astore_1
    //   1009: aload_0
    //   1010: getfield 83	com/tencent/mm/plugin/voip/model/d:configbyte	[B
    //   1013: iconst_0
    //   1014: aload_1
    //   1015: iconst_0
    //   1016: iload 5
    //   1018: invokestatic 290	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1021: iload 5
    //   1023: iconst_0
    //   1024: iadd
    //   1025: istore 5
    //   1027: goto +976 -> 2003
    //   1030: iconst_4
    //   1031: invokestatic 209	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1034: astore 14
    //   1036: aload 13
    //   1038: getfield 406	com/tencent/mm/protocal/protobuf/cao:MfG	Lcom/tencent/mm/bw/b;
    //   1041: aload 14
    //   1043: invokevirtual 231	java/nio/ByteBuffer:array	()[B
    //   1046: iload 7
    //   1048: iconst_0
    //   1049: iconst_4
    //   1050: invokevirtual 410	com/tencent/mm/bw/b:j	([BIII)V
    //   1053: aload 14
    //   1055: getstatic 413	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   1058: invokevirtual 219	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1061: pop
    //   1062: aload 14
    //   1064: iconst_0
    //   1065: invokevirtual 417	java/nio/ByteBuffer:getInt	(I)I
    //   1068: istore 9
    //   1070: aload_0
    //   1071: getfield 103	com/tencent/mm/plugin/voip/model/d:zLz	[B
    //   1074: iconst_0
    //   1075: aload_1
    //   1076: iload 7
    //   1078: iload 5
    //   1080: iadd
    //   1081: iconst_4
    //   1082: invokestatic 290	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1085: iload 7
    //   1087: iconst_4
    //   1088: iadd
    //   1089: istore 7
    //   1091: aload 13
    //   1093: getfield 406	com/tencent/mm/protocal/protobuf/cao:MfG	Lcom/tencent/mm/bw/b;
    //   1096: aload_1
    //   1097: iload 7
    //   1099: iload 7
    //   1101: iload 5
    //   1103: iadd
    //   1104: iload 9
    //   1106: invokevirtual 410	com/tencent/mm/bw/b:j	([BIII)V
    //   1109: iload 8
    //   1111: iload 9
    //   1113: iconst_4
    //   1114: iadd
    //   1115: isub
    //   1116: istore 8
    //   1118: ldc 175
    //   1120: new 163	java/lang/StringBuilder
    //   1123: dup
    //   1124: ldc_w 419
    //   1127: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1130: iload 9
    //   1132: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1135: ldc_w 421
    //   1138: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: iload 6
    //   1143: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1146: ldc_w 423
    //   1149: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: iload_2
    //   1153: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1156: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1159: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1162: iload 8
    //   1164: ifgt +829 -> 1993
    //   1167: iconst_0
    //   1168: istore 5
    //   1170: goto -843 -> 327
    //   1173: iload 7
    //   1175: newarray byte
    //   1177: astore_1
    //   1178: iload 7
    //   1180: istore 6
    //   1182: goto +821 -> 2003
    //   1185: astore_1
    //   1186: aload_0
    //   1187: aload_0
    //   1188: getfield 109	com/tencent/mm/plugin/voip/model/d:zLC	I
    //   1191: iconst_4
    //   1192: ior
    //   1193: putfield 109	com/tencent/mm/plugin/voip/model/d:zLC	I
    //   1196: ldc 175
    //   1198: new 163	java/lang/StringBuilder
    //   1201: dup
    //   1202: ldc_w 425
    //   1205: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1208: aload_1
    //   1209: invokevirtual 374	java/lang/Exception:toString	()Ljava/lang/String;
    //   1212: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1218: invokestatic 377	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1221: iconst_0
    //   1222: istore 5
    //   1224: aload 12
    //   1226: astore_1
    //   1227: goto -900 -> 327
    //   1230: astore 12
    //   1232: ldc 175
    //   1234: new 163	java/lang/StringBuilder
    //   1237: dup
    //   1238: ldc_w 427
    //   1241: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1244: aload 12
    //   1246: invokevirtual 428	java/io/IOException:toString	()Ljava/lang/String;
    //   1249: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1252: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1255: invokestatic 377	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1258: goto -909 -> 349
    //   1261: astore 12
    //   1263: ldc 175
    //   1265: new 163	java/lang/StringBuilder
    //   1268: dup
    //   1269: ldc_w 430
    //   1272: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1275: aload 12
    //   1277: invokevirtual 374	java/lang/Exception:toString	()Ljava/lang/String;
    //   1280: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1283: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1286: invokestatic 377	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1289: goto -886 -> 403
    //   1292: astore 12
    //   1294: aload_0
    //   1295: aload_0
    //   1296: getfield 109	com/tencent/mm/plugin/voip/model/d:zLC	I
    //   1299: bipush 16
    //   1301: ior
    //   1302: putfield 109	com/tencent/mm/plugin/voip/model/d:zLC	I
    //   1305: ldc 175
    //   1307: new 163	java/lang/StringBuilder
    //   1310: dup
    //   1311: ldc_w 427
    //   1314: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1317: aload 12
    //   1319: invokevirtual 374	java/lang/Exception:toString	()Ljava/lang/String;
    //   1322: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1325: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1328: invokestatic 377	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1331: aload_0
    //   1332: getfield 87	com/tencent/mm/plugin/voip/model/d:zLu	Z
    //   1335: ifne +94 -> 1429
    //   1338: ldc 175
    //   1340: ldc_w 432
    //   1343: invokestatic 377	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1346: ldc 249
    //   1348: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1351: iconst_m1
    //   1352: ireturn
    //   1353: ldc_w 434
    //   1356: getstatic 66	com/tencent/mm/plugin/voip/model/d:zLs	I
    //   1359: getstatic 68	com/tencent/mm/plugin/voip/model/d:zLt	I
    //   1362: invokestatic 316	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   1365: astore 12
    //   1367: goto -943 -> 424
    //   1370: astore 12
    //   1372: aload_0
    //   1373: aload_0
    //   1374: getfield 109	com/tencent/mm/plugin/voip/model/d:zLC	I
    //   1377: bipush 8
    //   1379: ior
    //   1380: putfield 109	com/tencent/mm/plugin/voip/model/d:zLC	I
    //   1383: ldc 175
    //   1385: new 163	java/lang/StringBuilder
    //   1388: dup
    //   1389: ldc_w 436
    //   1392: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1395: aload 13
    //   1397: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1400: ldc_w 438
    //   1403: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1406: aload 12
    //   1408: invokevirtual 441	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1411: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1414: invokestatic 377	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1417: aload_0
    //   1418: invokespecial 443	com/tencent/mm/plugin/voip/model/d:emA	()I
    //   1421: pop
    //   1422: ldc 249
    //   1424: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1427: iconst_m1
    //   1428: ireturn
    //   1429: aload_0
    //   1430: getfield 91	com/tencent/mm/plugin/voip/model/d:zLw	Z
    //   1433: ifne +8 -> 1441
    //   1436: aload_0
    //   1437: iconst_1
    //   1438: putfield 91	com/tencent/mm/plugin/voip/model/d:zLw	Z
    //   1441: aload_1
    //   1442: arraylength
    //   1443: istore 5
    //   1445: aload_0
    //   1446: getfield 85	com/tencent/mm/plugin/voip/model/d:zLr	Z
    //   1449: ifeq +157 -> 1606
    //   1452: aload_1
    //   1453: iconst_4
    //   1454: baload
    //   1455: bipush 126
    //   1457: iand
    //   1458: iconst_1
    //   1459: ishr
    //   1460: istore 6
    //   1462: iload 6
    //   1464: bipush 32
    //   1466: if_icmpeq +10 -> 1476
    //   1469: iload 6
    //   1471: bipush 33
    //   1473: if_icmpne +105 -> 1578
    //   1476: bipush 83
    //   1478: istore 4
    //   1480: ldc 175
    //   1482: new 163	java/lang/StringBuilder
    //   1485: dup
    //   1486: ldc_w 445
    //   1489: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1492: iload 5
    //   1494: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1497: ldc_w 447
    //   1500: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1503: iload_2
    //   1504: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1507: ldc_w 449
    //   1510: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1513: iload 6
    //   1515: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1518: ldc_w 451
    //   1521: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1524: iload 4
    //   1526: invokevirtual 454	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1529: ldc_w 456
    //   1532: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1535: aload_0
    //   1536: getfield 107	com/tencent/mm/plugin/voip/model/d:zLB	I
    //   1539: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1542: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1545: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1548: aload_0
    //   1549: getfield 93	com/tencent/mm/plugin/voip/model/d:zLx	Z
    //   1552: ifeq +178 -> 1730
    //   1555: iload 4
    //   1557: bipush 80
    //   1559: if_icmpne +171 -> 1730
    //   1562: ldc 175
    //   1564: ldc_w 458
    //   1567: invokestatic 377	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1570: ldc 249
    //   1572: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1575: bipush 254
    //   1577: ireturn
    //   1578: iload 6
    //   1580: bipush 19
    //   1582: if_icmpeq +10 -> 1592
    //   1585: iload 6
    //   1587: bipush 39
    //   1589: if_icmpne +10 -> 1599
    //   1592: bipush 73
    //   1594: istore 4
    //   1596: goto -116 -> 1480
    //   1599: bipush 80
    //   1601: istore 4
    //   1603: goto -123 -> 1480
    //   1606: aload_1
    //   1607: iconst_4
    //   1608: baload
    //   1609: bipush 31
    //   1611: iand
    //   1612: istore 6
    //   1614: iload 6
    //   1616: bipush 7
    //   1618: if_icmpeq +10 -> 1628
    //   1621: iload 6
    //   1623: bipush 8
    //   1625: if_icmpne +78 -> 1703
    //   1628: bipush 83
    //   1630: istore 4
    //   1632: ldc 175
    //   1634: new 163	java/lang/StringBuilder
    //   1637: dup
    //   1638: ldc_w 460
    //   1641: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1644: iload 5
    //   1646: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1649: ldc_w 447
    //   1652: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1655: iload_2
    //   1656: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1659: ldc_w 449
    //   1662: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1665: iload 6
    //   1667: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1670: ldc_w 451
    //   1673: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1676: iload 4
    //   1678: invokevirtual 454	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1681: ldc_w 456
    //   1684: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1687: aload_0
    //   1688: getfield 107	com/tencent/mm/plugin/voip/model/d:zLB	I
    //   1691: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1694: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1697: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1700: goto -152 -> 1548
    //   1703: iload 6
    //   1705: iconst_5
    //   1706: if_icmpeq +10 -> 1716
    //   1709: iload 6
    //   1711: bipush 6
    //   1713: if_icmpne +10 -> 1723
    //   1716: bipush 73
    //   1718: istore 4
    //   1720: goto -88 -> 1632
    //   1723: bipush 80
    //   1725: istore 4
    //   1727: goto -95 -> 1632
    //   1730: aload_0
    //   1731: getfield 132	com/tencent/mm/plugin/voip/model/d:zLn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1734: ldc2_w 461
    //   1737: invokevirtual 466	com/tencent/mm/compatible/deviceinfo/z:dequeueInputBuffer	(J)I
    //   1740: istore_2
    //   1741: iload_2
    //   1742: iflt +210 -> 1952
    //   1745: aload_1
    //   1746: ifnull +186 -> 1932
    //   1749: iload 5
    //   1751: ifle +181 -> 1932
    //   1754: invokestatic 264	java/lang/System:currentTimeMillis	()J
    //   1757: lstore 10
    //   1759: ldc 175
    //   1761: new 163	java/lang/StringBuilder
    //   1764: dup
    //   1765: ldc_w 468
    //   1768: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1771: iload_2
    //   1772: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1775: ldc_w 470
    //   1778: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1781: iload 5
    //   1783: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1786: ldc_w 451
    //   1789: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1792: iload 4
    //   1794: invokevirtual 454	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1797: ldc_w 472
    //   1800: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1803: lload 10
    //   1805: invokevirtual 475	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1808: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1811: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1814: getstatic 480	android/os/Build$VERSION:SDK_INT	I
    //   1817: bipush 21
    //   1819: if_icmpge +120 -> 1939
    //   1822: aload_0
    //   1823: getfield 132	com/tencent/mm/plugin/voip/model/d:zLn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1826: invokevirtual 484	com/tencent/mm/compatible/deviceinfo/z:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   1829: iload_2
    //   1830: aaload
    //   1831: astore 12
    //   1833: aload 12
    //   1835: invokevirtual 488	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1838: pop
    //   1839: aload 12
    //   1841: invokevirtual 488	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1844: pop
    //   1845: aload 12
    //   1847: aload_1
    //   1848: iconst_0
    //   1849: iload 5
    //   1851: invokevirtual 491	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1854: pop
    //   1855: aload_0
    //   1856: getfield 132	com/tencent/mm/plugin/voip/model/d:zLn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1859: iload_2
    //   1860: iload 5
    //   1862: lload 10
    //   1864: iconst_0
    //   1865: invokevirtual 494	com/tencent/mm/compatible/deviceinfo/z:a	(IIJI)V
    //   1868: aload_0
    //   1869: aload_0
    //   1870: getfield 107	com/tencent/mm/plugin/voip/model/d:zLB	I
    //   1873: iconst_1
    //   1874: iadd
    //   1875: putfield 107	com/tencent/mm/plugin/voip/model/d:zLB	I
    //   1878: aload_0
    //   1879: iconst_0
    //   1880: putfield 95	com/tencent/mm/plugin/voip/model/d:zLy	I
    //   1883: aload_0
    //   1884: getfield 93	com/tencent/mm/plugin/voip/model/d:zLx	Z
    //   1887: ifeq +45 -> 1932
    //   1890: iconst_1
    //   1891: invokestatic 209	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1894: astore_1
    //   1895: aload_1
    //   1896: getstatic 215	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   1899: invokevirtual 219	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1902: pop
    //   1903: aload_1
    //   1904: iconst_0
    //   1905: invokevirtual 223	java/nio/ByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   1908: pop
    //   1909: aload_0
    //   1910: getfield 99	com/tencent/mm/plugin/voip/model/d:GSZ	Lcom/tencent/mm/plugin/voip/model/l;
    //   1913: getfield 227	com/tencent/mm/plugin/voip/model/l:GVV	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1916: bipush 28
    //   1918: aload_1
    //   1919: invokevirtual 231	java/nio/ByteBuffer:array	()[B
    //   1922: iconst_1
    //   1923: invokevirtual 237	com/tencent/mm/plugin/voip/model/v2protocal:setAppCmd	(I[BI)I
    //   1926: pop
    //   1927: aload_0
    //   1928: iconst_0
    //   1929: putfield 93	com/tencent/mm/plugin/voip/model/d:zLx	Z
    //   1932: ldc 249
    //   1934: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1937: iconst_0
    //   1938: ireturn
    //   1939: aload_0
    //   1940: getfield 132	com/tencent/mm/plugin/voip/model/d:zLn	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1943: iload_2
    //   1944: invokevirtual 497	com/tencent/mm/compatible/deviceinfo/z:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   1947: astore 12
    //   1949: goto -110 -> 1839
    //   1952: aload_0
    //   1953: getfield 93	com/tencent/mm/plugin/voip/model/d:zLx	Z
    //   1956: ifeq +21 -> 1977
    //   1959: iload 4
    //   1961: bipush 80
    //   1963: if_icmpeq +14 -> 1977
    //   1966: aload_0
    //   1967: aload_0
    //   1968: getfield 109	com/tencent/mm/plugin/voip/model/d:zLC	I
    //   1971: bipush 32
    //   1973: ior
    //   1974: putfield 109	com/tencent/mm/plugin/voip/model/d:zLC	I
    //   1977: aload_0
    //   1978: invokespecial 443	com/tencent/mm/plugin/voip/model/d:emA	()I
    //   1981: pop
    //   1982: ldc 175
    //   1984: ldc_w 499
    //   1987: invokestatic 377	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1990: goto -58 -> 1932
    //   1993: iload 7
    //   1995: iload 9
    //   1997: iadd
    //   1998: istore 7
    //   2000: goto -970 -> 1030
    //   2003: iconst_0
    //   2004: istore 9
    //   2006: iload 7
    //   2008: istore 8
    //   2010: iload 9
    //   2012: istore 7
    //   2014: goto -984 -> 1030
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2017	0	this	d
    //   0	2017	1	paramArrayOfByte	byte[]
    //   0	2017	2	paramInt	int
    //   0	2017	3	paramBoolean	boolean
    //   1478	486	4	c	char
    //   94	1767	5	i	int
    //   104	1610	6	j	int
    //   114	1899	7	k	int
    //   1109	900	8	m	int
    //   1068	943	9	n	int
    //   1757	106	10	l	long
    //   64	1161	12	localObject1	Object
    //   1230	15	12	localIOException	java.io.IOException
    //   1261	15	12	localException1	Exception
    //   1292	26	12	localException2	Exception
    //   1365	1	12	localMediaFormat	MediaFormat
    //   1370	37	12	localException3	Exception
    //   1831	117	12	localByteBuffer	ByteBuffer
    //   458	938	13	localObject2	Object
    //   625	438	14	localObject3	Object
    //   649	39	15	str	String
    // Exception table:
    //   from	to	target	type
    //   71	93	865	java/lang/Exception
    //   96	116	865	java/lang/Exception
    //   121	133	865	java/lang/Exception
    //   133	321	865	java/lang/Exception
    //   545	555	865	java/lang/Exception
    //   558	570	865	java/lang/Exception
    //   570	695	865	java/lang/Exception
    //   701	717	865	java/lang/Exception
    //   725	738	865	java/lang/Exception
    //   738	862	865	java/lang/Exception
    //   916	931	865	java/lang/Exception
    //   934	966	1185	java/lang/Exception
    //   969	985	1185	java/lang/Exception
    //   990	997	1185	java/lang/Exception
    //   1004	1021	1185	java/lang/Exception
    //   1030	1085	1185	java/lang/Exception
    //   1091	1109	1185	java/lang/Exception
    //   1118	1162	1185	java/lang/Exception
    //   1173	1178	1185	java/lang/Exception
    //   338	349	1230	java/io/IOException
    //   384	403	1261	java/lang/Exception
    //   354	379	1292	java/lang/Exception
    //   403	424	1292	java/lang/Exception
    //   424	480	1292	java/lang/Exception
    //   510	538	1292	java/lang/Exception
    //   1263	1289	1292	java/lang/Exception
    //   1353	1367	1292	java/lang/Exception
    //   1372	1422	1292	java/lang/Exception
    //   480	510	1370	java/lang/Exception
  }
  
  @SuppressLint({"NewApi"})
  public final void run()
  {
    AppMethodBeat.i(114830);
    if ((!Thread.interrupted()) && (this.zLv)) {
      if ((this.zLn == null) || (!this.zLu) || (!this.zLw)) {}
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
          i = this.zLn.dequeueOutputBuffer(localBufferInfo, 10000L);
          Log.d("MeidaCodec[HWDec]", "steve:  outIndex=".concat(String.valueOf(i)));
          switch (i)
          {
          case -3: 
            if (localBufferInfo.size <= 0) {
              break label414;
            }
            long l1 = localBufferInfo.presentationTimeUs;
            long l2 = System.currentTimeMillis();
            Log.d("MeidaCodec[HWDec]", "DECODER_THREAD:: decoded SUCCESSFULLY!!! cnt : " + this.zLA + ", size:" + localBufferInfo.size + ", pts:" + localBufferInfo.presentationTimeUs + ", latency:" + (l2 - l1));
            this.zLA += 1;
            this.zLn.releaseOutputBuffer(i, true);
            l2 = System.currentTimeMillis();
            Log.d("MeidaCodec[HWDec]", "steve: Avcdecoder frame processTime = " + (l2 - l1) + ", decFrameCnt=" + this.zLA + ", endTime=" + l2);
          }
        }
        catch (Exception localException1)
        {
          this.zLC |= 0x80;
          emA();
          Log.e("MeidaCodec[HWDec]", " dequeueOutputBuffer/releaseOutputBuffer error:" + localException1.toString());
        }
        break;
        Log.d("MeidaCodec[HWDec]", "INFO_OUTPUT_BUFFERS_CHANGED");
        break;
        Object localObject = this.zLn.getOutputFormat();
        Log.i("MeidaCodec[HWDec]", "DECODER_THREAD:: New format : ".concat(String.valueOf(localObject)));
        int i = ((MediaFormat)localObject).getInteger("width");
        int j = ((MediaFormat)localObject).getInteger("height");
        if (this.GSZ == null) {
          break;
        }
        localObject = this.GSZ;
        ((l)localObject).mHandler.post(new l.5((l)localObject, j, i));
        break;
        Log.d("MeidaCodec[HWDec]", "DECODER_THREAD:: dequeueOutputBuffer timed out!");
        break;
        label414:
        Log.d("MeidaCodec[HWDec]", "steve: drop frame: " + this.zLA + ", size:" + ((MediaCodec.BufferInfo)localObject).size + ", pts:" + ((MediaCodec.BufferInfo)localObject).presentationTimeUs);
        this.zLn.releaseOutputBuffer(i, false);
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
      if ((!this.zLv) && (this.zLn != null)) {
        try
        {
          this.zLn.stop();
          this.zLn.release();
          this.zLn = null;
          AppMethodBeat.o(114830);
          return;
        }
        catch (Exception localException2)
        {
          Log.e("MeidaCodec[HWDec]", " decoder stop  error:" + localException2.toString());
        }
      }
      AppMethodBeat.o(114830);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.d
 * JD-Core Version:    0.7.0.1
 */