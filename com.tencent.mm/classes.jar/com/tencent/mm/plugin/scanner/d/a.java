package com.tencent.mm.plugin.scanner.d;

import android.graphics.Point;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.ac;
import com.tencent.mm.plugin.scanner.model.ad;
import com.tencent.mm.plugin.scanner.ui.ScanUIRectView.a;
import com.tencent.mm.plugin.scanner.util.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static a OOQ;
  public final Object GXz;
  private int HJN;
  private int HJO;
  public final Object OOR;
  public a.a OOS;
  private Map OOo;
  public long OOu;
  private boolean OOw;
  public boolean lYs;
  
  static
  {
    AppMethodBeat.i(51584);
    OOQ = new a();
    AppMethodBeat.o(51584);
  }
  
  public a()
  {
    AppMethodBeat.i(51576);
    this.GXz = new Object();
    this.OOR = new Object();
    this.OOo = new HashMap();
    this.HJN = 0;
    this.HJO = 0;
    AppMethodBeat.o(51576);
  }
  
  public static int ahI(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 17: 
      return 3;
    }
    return 4;
  }
  
  public static a gQu()
  {
    return OOQ;
  }
  
  private ad gQv()
  {
    AppMethodBeat.i(51579);
    b localb = new b(this.OOu);
    AppMethodBeat.o(51579);
    return localb;
  }
  
  public final void a(final byte[] paramArrayOfByte, final Point paramPoint, final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    AppMethodBeat.i(313431);
    Log.v("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo addDecodeTask resolution: %s, previewData length: %d, cameraRotation: %d, previewFormat: %d", new Object[] { paramPoint, Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    ac.a(new ad()
    {
      public final void run()
      {
        AppMethodBeat.i(51572);
        a.a(a.this, paramArrayOfByte, paramPoint, paramInt1, paramInt2, paramBoolean);
        AppMethodBeat.o(51572);
      }
    });
    AppMethodBeat.o(313431);
  }
  
  public final void tR(long paramLong)
  {
    AppMethodBeat.i(51580);
    synchronized (this.GXz)
    {
      if (this.OOu == paramLong)
      {
        this.OOu = 0L;
        this.OOS = null;
        this.OOo.clear();
      }
      AppMethodBeat.o(51580);
      return;
    }
  }
  
  final class b
    implements ad
  {
    private byte[] OOy;
    private Point OOz;
    private long hBk;
    private int pixelFormat;
    private int zTK;
    
    public b(long paramLong)
    {
      this.hBk = paramLong;
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 6
      //   3: ldc 34
      //   5: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_0
      //   9: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   12: invokestatic 44	com/tencent/mm/plugin/scanner/d/a:c	(Lcom/tencent/mm/plugin/scanner/d/a;)Ljava/lang/Object;
      //   15: astore 9
      //   17: aload 9
      //   19: monitorenter
      //   20: aload_0
      //   21: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   24: iconst_1
      //   25: invokestatic 48	com/tencent/mm/plugin/scanner/d/a:a	(Lcom/tencent/mm/plugin/scanner/d/a;Z)Z
      //   28: pop
      //   29: aload_0
      //   30: getfield 29	com/tencent/mm/plugin/scanner/d/a$b:hBk	J
      //   33: aload_0
      //   34: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   37: invokestatic 52	com/tencent/mm/plugin/scanner/d/a:d	(Lcom/tencent/mm/plugin/scanner/d/a;)J
      //   40: lcmp
      //   41: ifne +720 -> 761
      //   44: aload_0
      //   45: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   48: invokestatic 56	com/tencent/mm/plugin/scanner/d/a:e	(Lcom/tencent/mm/plugin/scanner/d/a;)Ljava/util/Map;
      //   51: invokeinterface 62 1 0
      //   56: ifne +105 -> 161
      //   59: aload_0
      //   60: aload_0
      //   61: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   64: invokestatic 56	com/tencent/mm/plugin/scanner/d/a:e	(Lcom/tencent/mm/plugin/scanner/d/a;)Ljava/util/Map;
      //   67: ldc 64
      //   69: invokeinterface 68 2 0
      //   74: checkcast 69	[B
      //   77: putfield 71	com/tencent/mm/plugin/scanner/d/a$b:OOy	[B
      //   80: aload_0
      //   81: aload_0
      //   82: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   85: invokestatic 56	com/tencent/mm/plugin/scanner/d/a:e	(Lcom/tencent/mm/plugin/scanner/d/a;)Ljava/util/Map;
      //   88: ldc 73
      //   90: invokeinterface 68 2 0
      //   95: checkcast 75	android/graphics/Point
      //   98: putfield 77	com/tencent/mm/plugin/scanner/d/a$b:OOz	Landroid/graphics/Point;
      //   101: aload_0
      //   102: aload_0
      //   103: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   106: invokestatic 56	com/tencent/mm/plugin/scanner/d/a:e	(Lcom/tencent/mm/plugin/scanner/d/a;)Ljava/util/Map;
      //   109: ldc 79
      //   111: invokeinterface 68 2 0
      //   116: checkcast 81	java/lang/Integer
      //   119: invokevirtual 85	java/lang/Integer:intValue	()I
      //   122: putfield 87	com/tencent/mm/plugin/scanner/d/a$b:zTK	I
      //   125: aload_0
      //   126: aload_0
      //   127: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   130: invokestatic 56	com/tencent/mm/plugin/scanner/d/a:e	(Lcom/tencent/mm/plugin/scanner/d/a;)Ljava/util/Map;
      //   133: ldc 89
      //   135: invokeinterface 68 2 0
      //   140: checkcast 81	java/lang/Integer
      //   143: invokevirtual 85	java/lang/Integer:intValue	()I
      //   146: putfield 91	com/tencent/mm/plugin/scanner/d/a$b:pixelFormat	I
      //   149: aload_0
      //   150: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   153: invokestatic 56	com/tencent/mm/plugin/scanner/d/a:e	(Lcom/tencent/mm/plugin/scanner/d/a;)Ljava/util/Map;
      //   156: invokeinterface 94 1 0
      //   161: aload 9
      //   163: monitorexit
      //   164: aconst_null
      //   165: astore 9
      //   167: aload_0
      //   168: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   171: invokestatic 97	com/tencent/mm/plugin/scanner/d/a:g	(Lcom/tencent/mm/plugin/scanner/d/a;)Ljava/lang/Object;
      //   174: astore 10
      //   176: aload 10
      //   178: monitorenter
      //   179: aload_0
      //   180: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   183: invokestatic 100	com/tencent/mm/plugin/scanner/d/a:a	(Lcom/tencent/mm/plugin/scanner/d/a;)Z
      //   186: ifeq +738 -> 924
      //   189: aload_0
      //   190: getfield 71	com/tencent/mm/plugin/scanner/d/a$b:OOy	[B
      //   193: ifnull +731 -> 924
      //   196: ldc 102
      //   198: ldc 104
      //   200: bipush 6
      //   202: anewarray 4	java/lang/Object
      //   205: dup
      //   206: iconst_0
      //   207: aload_0
      //   208: getfield 29	com/tencent/mm/plugin/scanner/d/a$b:hBk	J
      //   211: invokestatic 110	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   214: aastore
      //   215: dup
      //   216: iconst_1
      //   217: aload_0
      //   218: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   221: invokestatic 52	com/tencent/mm/plugin/scanner/d/a:d	(Lcom/tencent/mm/plugin/scanner/d/a;)J
      //   224: invokestatic 110	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   227: aastore
      //   228: dup
      //   229: iconst_2
      //   230: aload_0
      //   231: getfield 77	com/tencent/mm/plugin/scanner/d/a$b:OOz	Landroid/graphics/Point;
      //   234: aastore
      //   235: dup
      //   236: iconst_3
      //   237: aload_0
      //   238: getfield 91	com/tencent/mm/plugin/scanner/d/a$b:pixelFormat	I
      //   241: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   244: aastore
      //   245: dup
      //   246: iconst_4
      //   247: aload_0
      //   248: getfield 87	com/tencent/mm/plugin/scanner/d/a$b:zTK	I
      //   251: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   254: aastore
      //   255: dup
      //   256: iconst_5
      //   257: aload_0
      //   258: getfield 71	com/tencent/mm/plugin/scanner/d/a$b:OOy	[B
      //   261: arraylength
      //   262: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   265: aastore
      //   266: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   269: aload_0
      //   270: getfield 71	com/tencent/mm/plugin/scanner/d/a$b:OOy	[B
      //   273: aload_0
      //   274: getfield 91	com/tencent/mm/plugin/scanner/d/a$b:pixelFormat	I
      //   277: aload_0
      //   278: getfield 87	com/tencent/mm/plugin/scanner/d/a$b:zTK	I
      //   281: invokestatic 124	com/tencent/mm/plugin/scanner/model/ac:process	([BII)Lcom/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative;
      //   284: astore 11
      //   286: invokestatic 128	com/tencent/mm/plugin/scanner/model/ac:gQX	()Lcom/tencent/mm/plugin/scanner/model/aj;
      //   289: astore 12
      //   291: aload 12
      //   293: ifnull +27 -> 320
      //   296: aload_0
      //   297: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   300: invokestatic 132	com/tencent/mm/plugin/scanner/d/a:h	(Lcom/tencent/mm/plugin/scanner/d/a;)Lcom/tencent/mm/plugin/scanner/d/a$a;
      //   303: ifnull +17 -> 320
      //   306: aload_0
      //   307: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   310: invokestatic 132	com/tencent/mm/plugin/scanner/d/a:h	(Lcom/tencent/mm/plugin/scanner/d/a;)Lcom/tencent/mm/plugin/scanner/d/a$a;
      //   313: aload 12
      //   315: invokeinterface 137 2 0
      //   320: aload 11
      //   322: ifnull +477 -> 799
      //   325: aload 11
      //   327: getfield 142	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:bestImageData	[B
      //   330: ifnull +469 -> 799
      //   333: aload 11
      //   335: getfield 145	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:width	I
      //   338: ifle +461 -> 799
      //   341: aload 11
      //   343: getfield 148	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:height	I
      //   346: ifle +453 -> 799
      //   349: iconst_1
      //   350: istore_1
      //   351: iload_1
      //   352: ifeq +572 -> 924
      //   355: aload 11
      //   357: getfield 151	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:result	I
      //   360: ifle +444 -> 804
      //   363: aload 11
      //   365: getfield 151	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:result	I
      //   368: iconst_2
      //   369: iand
      //   370: ifeq +434 -> 804
      //   373: iconst_1
      //   374: istore 6
      //   376: aload 11
      //   378: getfield 142	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:bestImageData	[B
      //   381: astore 9
      //   383: aload 11
      //   385: getfield 154	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:bestImageId	I
      //   388: istore_2
      //   389: aload 11
      //   391: getfield 145	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:width	I
      //   394: istore_3
      //   395: aload 11
      //   397: getfield 148	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:height	I
      //   400: istore 4
      //   402: aload 11
      //   404: getfield 151	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:result	I
      //   407: istore 5
      //   409: aload 9
      //   411: ifnull +399 -> 810
      //   414: aload 9
      //   416: arraylength
      //   417: istore_1
      //   418: ldc 102
      //   420: ldc 156
      //   422: bipush 6
      //   424: anewarray 4	java/lang/Object
      //   427: dup
      //   428: iconst_0
      //   429: iload 5
      //   431: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   434: aastore
      //   435: dup
      //   436: iconst_1
      //   437: iconst_2
      //   438: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   441: aastore
      //   442: dup
      //   443: iconst_2
      //   444: iload 6
      //   446: invokestatic 161	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   449: aastore
      //   450: dup
      //   451: iconst_3
      //   452: iload_1
      //   453: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   456: aastore
      //   457: dup
      //   458: iconst_4
      //   459: iload_3
      //   460: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   463: aastore
      //   464: dup
      //   465: iconst_5
      //   466: iload 4
      //   468: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   471: aastore
      //   472: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   475: new 163	android/graphics/YuvImage
      //   478: dup
      //   479: aload 9
      //   481: bipush 17
      //   483: iload_3
      //   484: iload 4
      //   486: aconst_null
      //   487: invokespecial 166	android/graphics/YuvImage:<init>	([BIII[I)V
      //   490: astore 11
      //   492: new 168	android/graphics/Rect
      //   495: dup
      //   496: iconst_0
      //   497: iconst_0
      //   498: iload_3
      //   499: iload 4
      //   501: invokespecial 171	android/graphics/Rect:<init>	(IIII)V
      //   504: astore 12
      //   506: invokestatic 177	java/lang/System:currentTimeMillis	()J
      //   509: lstore 7
      //   511: new 179	java/io/ByteArrayOutputStream
      //   514: dup
      //   515: invokespecial 180	java/io/ByteArrayOutputStream:<init>	()V
      //   518: astore 9
      //   520: aload 11
      //   522: aload 12
      //   524: bipush 70
      //   526: aload 9
      //   528: invokevirtual 184	android/graphics/YuvImage:compressToJpeg	(Landroid/graphics/Rect;ILjava/io/OutputStream;)Z
      //   531: pop
      //   532: aload 9
      //   534: invokevirtual 187	java/io/ByteArrayOutputStream:flush	()V
      //   537: aload 9
      //   539: invokevirtual 190	java/io/ByteArrayOutputStream:close	()V
      //   542: aload 9
      //   544: invokevirtual 194	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   547: astore 9
      //   549: ldc 102
      //   551: ldc 196
      //   553: iconst_1
      //   554: anewarray 4	java/lang/Object
      //   557: dup
      //   558: iconst_0
      //   559: invokestatic 177	java/lang/System:currentTimeMillis	()J
      //   562: lload 7
      //   564: lsub
      //   565: invokestatic 110	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   568: aastore
      //   569: invokestatic 198	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   572: iload_2
      //   573: istore_1
      //   574: aload 10
      //   576: monitorexit
      //   577: aload_0
      //   578: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   581: invokestatic 44	com/tencent/mm/plugin/scanner/d/a:c	(Lcom/tencent/mm/plugin/scanner/d/a;)Ljava/lang/Object;
      //   584: astore 10
      //   586: aload 10
      //   588: monitorenter
      //   589: new 200	android/os/Bundle
      //   592: dup
      //   593: invokespecial 201	android/os/Bundle:<init>	()V
      //   596: astore 11
      //   598: aload 11
      //   600: ldc 203
      //   602: iload 6
      //   604: invokevirtual 207	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
      //   607: aload 11
      //   609: ldc 209
      //   611: iconst_1
      //   612: invokevirtual 213	android/os/Bundle:putInt	(Ljava/lang/String;I)V
      //   615: aload 11
      //   617: ldc 215
      //   619: iconst_0
      //   620: invokevirtual 213	android/os/Bundle:putInt	(Ljava/lang/String;I)V
      //   623: aload_0
      //   624: getfield 29	com/tencent/mm/plugin/scanner/d/a$b:hBk	J
      //   627: aload_0
      //   628: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   631: invokestatic 52	com/tencent/mm/plugin/scanner/d/a:d	(Lcom/tencent/mm/plugin/scanner/d/a;)J
      //   634: lcmp
      //   635: ifne +270 -> 905
      //   638: iload 6
      //   640: ifeq +246 -> 886
      //   643: aload 9
      //   645: ifnull +241 -> 886
      //   648: aload 11
      //   650: ldc 217
      //   652: aload 9
      //   654: invokevirtual 221	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
      //   657: aload 11
      //   659: ldc 223
      //   661: iload_1
      //   662: invokevirtual 213	android/os/Bundle:putInt	(Ljava/lang/String;I)V
      //   665: aload 11
      //   667: ldc 225
      //   669: aload_0
      //   670: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   673: invokestatic 228	com/tencent/mm/plugin/scanner/d/a:i	(Lcom/tencent/mm/plugin/scanner/d/a;)I
      //   676: invokevirtual 213	android/os/Bundle:putInt	(Ljava/lang/String;I)V
      //   679: aload 11
      //   681: ldc 230
      //   683: aload_0
      //   684: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   687: invokestatic 233	com/tencent/mm/plugin/scanner/d/a:j	(Lcom/tencent/mm/plugin/scanner/d/a;)I
      //   690: invokevirtual 213	android/os/Bundle:putInt	(Ljava/lang/String;I)V
      //   693: invokestatic 237	com/tencent/mm/plugin/scanner/model/ac:gQY	()Lcom/tencent/mm/protocal/protobuf/GoodsObject;
      //   696: astore 9
      //   698: aload 9
      //   700: ifnull +15 -> 715
      //   703: aload 11
      //   705: ldc 239
      //   707: aload 9
      //   709: invokevirtual 242	com/tencent/mm/protocal/protobuf/GoodsObject:toByteArray	()[B
      //   712: invokevirtual 221	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
      //   715: aload_0
      //   716: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   719: invokestatic 132	com/tencent/mm/plugin/scanner/d/a:h	(Lcom/tencent/mm/plugin/scanner/d/a;)Lcom/tencent/mm/plugin/scanner/d/a$a;
      //   722: aload_0
      //   723: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   726: invokestatic 52	com/tencent/mm/plugin/scanner/d/a:d	(Lcom/tencent/mm/plugin/scanner/d/a;)J
      //   729: aload 11
      //   731: invokeinterface 245 4 0
      //   736: aload_0
      //   737: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   740: iconst_0
      //   741: invokestatic 48	com/tencent/mm/plugin/scanner/d/a:a	(Lcom/tencent/mm/plugin/scanner/d/a;Z)Z
      //   744: pop
      //   745: aload_0
      //   746: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   749: invokestatic 249	com/tencent/mm/plugin/scanner/d/a:f	(Lcom/tencent/mm/plugin/scanner/d/a;)V
      //   752: aload 10
      //   754: monitorexit
      //   755: ldc 34
      //   757: invokestatic 252	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   760: return
      //   761: aload_0
      //   762: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   765: iconst_0
      //   766: invokestatic 48	com/tencent/mm/plugin/scanner/d/a:a	(Lcom/tencent/mm/plugin/scanner/d/a;Z)Z
      //   769: pop
      //   770: aload_0
      //   771: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   774: invokestatic 249	com/tencent/mm/plugin/scanner/d/a:f	(Lcom/tencent/mm/plugin/scanner/d/a;)V
      //   777: aload 9
      //   779: monitorexit
      //   780: ldc 34
      //   782: invokestatic 252	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   785: return
      //   786: astore 10
      //   788: aload 9
      //   790: monitorexit
      //   791: ldc 34
      //   793: invokestatic 252	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   796: aload 10
      //   798: athrow
      //   799: iconst_0
      //   800: istore_1
      //   801: goto -450 -> 351
      //   804: iconst_0
      //   805: istore 6
      //   807: goto -431 -> 376
      //   810: iconst_m1
      //   811: istore_1
      //   812: goto -394 -> 418
      //   815: astore 11
      //   817: ldc 102
      //   819: aload 11
      //   821: ldc 254
      //   823: iconst_1
      //   824: anewarray 4	java/lang/Object
      //   827: dup
      //   828: iconst_0
      //   829: aload 11
      //   831: invokevirtual 258	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   834: aastore
      //   835: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   838: goto -296 -> 542
      //   841: astore 9
      //   843: aload 10
      //   845: monitorexit
      //   846: ldc 34
      //   848: invokestatic 252	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   851: aload 9
      //   853: athrow
      //   854: astore 9
      //   856: ldc 102
      //   858: aload 9
      //   860: ldc_w 264
      //   863: iconst_0
      //   864: anewarray 4	java/lang/Object
      //   867: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   870: goto -155 -> 715
      //   873: astore 9
      //   875: aload 10
      //   877: monitorexit
      //   878: ldc 34
      //   880: invokestatic 252	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   883: aload 9
      //   885: athrow
      //   886: aload_0
      //   887: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   890: iconst_0
      //   891: invokestatic 48	com/tencent/mm/plugin/scanner/d/a:a	(Lcom/tencent/mm/plugin/scanner/d/a;Z)Z
      //   894: pop
      //   895: aload_0
      //   896: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   899: invokestatic 249	com/tencent/mm/plugin/scanner/d/a:f	(Lcom/tencent/mm/plugin/scanner/d/a;)V
      //   902: goto -150 -> 752
      //   905: aload_0
      //   906: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   909: iconst_0
      //   910: invokestatic 48	com/tencent/mm/plugin/scanner/d/a:a	(Lcom/tencent/mm/plugin/scanner/d/a;Z)Z
      //   913: pop
      //   914: aload_0
      //   915: getfield 24	com/tencent/mm/plugin/scanner/d/a$b:OOY	Lcom/tencent/mm/plugin/scanner/d/a;
      //   918: invokestatic 249	com/tencent/mm/plugin/scanner/d/a:f	(Lcom/tencent/mm/plugin/scanner/d/a;)V
      //   921: goto -169 -> 752
      //   924: iconst_0
      //   925: istore_1
      //   926: goto -352 -> 574
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	929	0	this	b
      //   350	576	1	i	int
      //   388	185	2	j	int
      //   394	105	3	k	int
      //   400	100	4	m	int
      //   407	23	5	n	int
      //   1	805	6	bool	boolean
      //   509	54	7	l	long
      //   15	774	9	localObject1	Object
      //   841	11	9	localObject2	Object
      //   854	5	9	localException1	Exception
      //   873	11	9	localObject3	Object
      //   786	90	10	localObject5	Object
      //   284	446	11	localObject6	Object
      //   815	15	11	localException2	Exception
      //   289	234	12	localObject7	Object
      // Exception table:
      //   from	to	target	type
      //   20	161	786	finally
      //   761	780	786	finally
      //   520	542	815	java/lang/Exception
      //   179	291	841	finally
      //   296	320	841	finally
      //   325	349	841	finally
      //   355	373	841	finally
      //   376	409	841	finally
      //   414	418	841	finally
      //   418	520	841	finally
      //   520	542	841	finally
      //   542	572	841	finally
      //   574	577	841	finally
      //   817	838	841	finally
      //   693	698	854	java/lang/Exception
      //   703	715	854	java/lang/Exception
      //   589	638	873	finally
      //   648	693	873	finally
      //   693	698	873	finally
      //   703	715	873	finally
      //   715	752	873	finally
      //   752	755	873	finally
      //   856	870	873	finally
      //   886	902	873	finally
      //   905	921	873	finally
    }
  }
  
  public static abstract interface c
    extends ScanUIRectView.a
  {
    public abstract void f(long paramLong, int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.d.a
 * JD-Core Version:    0.7.0.1
 */