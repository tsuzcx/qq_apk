package com.tencent.mm.plugin.scanner.c;

import android.graphics.Point;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.ac;
import com.tencent.mm.plugin.scanner.model.v;
import com.tencent.mm.plugin.scanner.model.w;
import com.tencent.mm.plugin.scanner.ui.ScanUIRectView.a;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static a yBG;
  public boolean gff;
  private int tTU;
  private int tTV;
  public final Object yBH;
  public a yBI;
  private Map yBm;
  public final Object yBn;
  public long yBt;
  private boolean yBv;
  
  static
  {
    AppMethodBeat.i(51584);
    yBG = new a();
    AppMethodBeat.o(51584);
  }
  
  public a()
  {
    AppMethodBeat.i(51576);
    this.yBn = new Object();
    this.yBH = new Object();
    this.yBm = new HashMap();
    this.tTU = 0;
    this.tTV = 0;
    AppMethodBeat.o(51576);
  }
  
  public static a dOf()
  {
    return yBG;
  }
  
  private w dOg()
  {
    AppMethodBeat.i(51579);
    c localc = new c(this.yBt);
    AppMethodBeat.o(51579);
    return localc;
  }
  
  public final void a(final byte[] paramArrayOfByte, final Point paramPoint, final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    AppMethodBeat.i(189441);
    ae.v("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo addDecodeTask resolution: %s, previewData length: %d, cameraRotation: %d, previewFormat: %d", new Object[] { paramPoint, Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    v.a(new w()
    {
      public final void run()
      {
        AppMethodBeat.i(51572);
        a.a(a.this, paramArrayOfByte, paramPoint, paramInt1, paramInt2, paramBoolean);
        AppMethodBeat.o(51572);
      }
    });
    AppMethodBeat.o(189441);
  }
  
  public final void zt(long paramLong)
  {
    AppMethodBeat.i(51580);
    synchronized (this.yBn)
    {
      if (this.yBt == paramLong)
      {
        this.yBt = 0L;
        this.yBI = null;
        this.yBm.clear();
      }
      AppMethodBeat.o(51580);
      return;
    }
  }
  
  public static abstract interface a
    extends b.a
  {
    public abstract void a(ac paramac);
  }
  
  final class c
    implements w
  {
    private long dmK;
    private int pixelFormat;
    private int rql;
    private byte[] yBx;
    private Point yBy;
    
    public c(long paramLong)
    {
      this.dmK = paramLong;
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
      //   9: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   12: invokestatic 43	com/tencent/mm/plugin/scanner/c/a:c	(Lcom/tencent/mm/plugin/scanner/c/a;)Ljava/lang/Object;
      //   15: astore 9
      //   17: aload 9
      //   19: monitorenter
      //   20: aload_0
      //   21: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   24: iconst_1
      //   25: invokestatic 47	com/tencent/mm/plugin/scanner/c/a:a	(Lcom/tencent/mm/plugin/scanner/c/a;Z)Z
      //   28: pop
      //   29: aload_0
      //   30: getfield 29	com/tencent/mm/plugin/scanner/c/a$c:dmK	J
      //   33: aload_0
      //   34: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   37: invokestatic 51	com/tencent/mm/plugin/scanner/c/a:d	(Lcom/tencent/mm/plugin/scanner/c/a;)J
      //   40: lcmp
      //   41: ifne +723 -> 764
      //   44: aload_0
      //   45: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   48: invokestatic 55	com/tencent/mm/plugin/scanner/c/a:e	(Lcom/tencent/mm/plugin/scanner/c/a;)Ljava/util/Map;
      //   51: invokeinterface 61 1 0
      //   56: ifne +108 -> 164
      //   59: aload_0
      //   60: aload_0
      //   61: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   64: invokestatic 55	com/tencent/mm/plugin/scanner/c/a:e	(Lcom/tencent/mm/plugin/scanner/c/a;)Ljava/util/Map;
      //   67: ldc 63
      //   69: invokeinterface 67 2 0
      //   74: checkcast 68	[B
      //   77: checkcast 68	[B
      //   80: putfield 70	com/tencent/mm/plugin/scanner/c/a$c:yBx	[B
      //   83: aload_0
      //   84: aload_0
      //   85: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   88: invokestatic 55	com/tencent/mm/plugin/scanner/c/a:e	(Lcom/tencent/mm/plugin/scanner/c/a;)Ljava/util/Map;
      //   91: ldc 72
      //   93: invokeinterface 67 2 0
      //   98: checkcast 74	android/graphics/Point
      //   101: putfield 76	com/tencent/mm/plugin/scanner/c/a$c:yBy	Landroid/graphics/Point;
      //   104: aload_0
      //   105: aload_0
      //   106: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   109: invokestatic 55	com/tencent/mm/plugin/scanner/c/a:e	(Lcom/tencent/mm/plugin/scanner/c/a;)Ljava/util/Map;
      //   112: ldc 78
      //   114: invokeinterface 67 2 0
      //   119: checkcast 80	java/lang/Integer
      //   122: invokevirtual 84	java/lang/Integer:intValue	()I
      //   125: putfield 86	com/tencent/mm/plugin/scanner/c/a$c:rql	I
      //   128: aload_0
      //   129: aload_0
      //   130: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   133: invokestatic 55	com/tencent/mm/plugin/scanner/c/a:e	(Lcom/tencent/mm/plugin/scanner/c/a;)Ljava/util/Map;
      //   136: ldc 88
      //   138: invokeinterface 67 2 0
      //   143: checkcast 80	java/lang/Integer
      //   146: invokevirtual 84	java/lang/Integer:intValue	()I
      //   149: putfield 90	com/tencent/mm/plugin/scanner/c/a$c:pixelFormat	I
      //   152: aload_0
      //   153: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   156: invokestatic 55	com/tencent/mm/plugin/scanner/c/a:e	(Lcom/tencent/mm/plugin/scanner/c/a;)Ljava/util/Map;
      //   159: invokeinterface 93 1 0
      //   164: aload 9
      //   166: monitorexit
      //   167: aconst_null
      //   168: astore 9
      //   170: aload_0
      //   171: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   174: invokestatic 96	com/tencent/mm/plugin/scanner/c/a:g	(Lcom/tencent/mm/plugin/scanner/c/a;)Ljava/lang/Object;
      //   177: astore 10
      //   179: aload 10
      //   181: monitorenter
      //   182: aload_0
      //   183: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   186: invokestatic 99	com/tencent/mm/plugin/scanner/c/a:a	(Lcom/tencent/mm/plugin/scanner/c/a;)Z
      //   189: ifeq +738 -> 927
      //   192: aload_0
      //   193: getfield 70	com/tencent/mm/plugin/scanner/c/a$c:yBx	[B
      //   196: ifnull +731 -> 927
      //   199: ldc 101
      //   201: ldc 103
      //   203: bipush 6
      //   205: anewarray 4	java/lang/Object
      //   208: dup
      //   209: iconst_0
      //   210: aload_0
      //   211: getfield 29	com/tencent/mm/plugin/scanner/c/a$c:dmK	J
      //   214: invokestatic 109	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   217: aastore
      //   218: dup
      //   219: iconst_1
      //   220: aload_0
      //   221: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   224: invokestatic 51	com/tencent/mm/plugin/scanner/c/a:d	(Lcom/tencent/mm/plugin/scanner/c/a;)J
      //   227: invokestatic 109	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   230: aastore
      //   231: dup
      //   232: iconst_2
      //   233: aload_0
      //   234: getfield 76	com/tencent/mm/plugin/scanner/c/a$c:yBy	Landroid/graphics/Point;
      //   237: aastore
      //   238: dup
      //   239: iconst_3
      //   240: aload_0
      //   241: getfield 90	com/tencent/mm/plugin/scanner/c/a$c:pixelFormat	I
      //   244: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   247: aastore
      //   248: dup
      //   249: iconst_4
      //   250: aload_0
      //   251: getfield 86	com/tencent/mm/plugin/scanner/c/a$c:rql	I
      //   254: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   257: aastore
      //   258: dup
      //   259: iconst_5
      //   260: aload_0
      //   261: getfield 70	com/tencent/mm/plugin/scanner/c/a$c:yBx	[B
      //   264: arraylength
      //   265: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   268: aastore
      //   269: invokestatic 117	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   272: aload_0
      //   273: getfield 70	com/tencent/mm/plugin/scanner/c/a$c:yBx	[B
      //   276: aload_0
      //   277: getfield 90	com/tencent/mm/plugin/scanner/c/a$c:pixelFormat	I
      //   280: aload_0
      //   281: getfield 86	com/tencent/mm/plugin/scanner/c/a$c:rql	I
      //   284: invokestatic 123	com/tencent/mm/plugin/scanner/model/v:process	([BII)Lcom/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative;
      //   287: astore 11
      //   289: invokestatic 127	com/tencent/mm/plugin/scanner/model/v:dOr	()Lcom/tencent/mm/plugin/scanner/model/ac;
      //   292: astore 12
      //   294: aload 12
      //   296: ifnull +27 -> 323
      //   299: aload_0
      //   300: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   303: invokestatic 131	com/tencent/mm/plugin/scanner/c/a:h	(Lcom/tencent/mm/plugin/scanner/c/a;)Lcom/tencent/mm/plugin/scanner/c/a$a;
      //   306: ifnull +17 -> 323
      //   309: aload_0
      //   310: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   313: invokestatic 131	com/tencent/mm/plugin/scanner/c/a:h	(Lcom/tencent/mm/plugin/scanner/c/a;)Lcom/tencent/mm/plugin/scanner/c/a$a;
      //   316: aload 12
      //   318: invokeinterface 136 2 0
      //   323: aload 11
      //   325: ifnull +477 -> 802
      //   328: aload 11
      //   330: getfield 141	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:bestImageData	[B
      //   333: ifnull +469 -> 802
      //   336: aload 11
      //   338: getfield 144	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:width	I
      //   341: ifle +461 -> 802
      //   344: aload 11
      //   346: getfield 147	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:height	I
      //   349: ifle +453 -> 802
      //   352: iconst_1
      //   353: istore_1
      //   354: iload_1
      //   355: ifeq +572 -> 927
      //   358: aload 11
      //   360: getfield 150	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:result	I
      //   363: ifle +444 -> 807
      //   366: aload 11
      //   368: getfield 150	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:result	I
      //   371: iconst_2
      //   372: iand
      //   373: ifeq +434 -> 807
      //   376: iconst_1
      //   377: istore 6
      //   379: aload 11
      //   381: getfield 141	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:bestImageData	[B
      //   384: astore 9
      //   386: aload 11
      //   388: getfield 153	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:bestImageId	I
      //   391: istore_2
      //   392: aload 11
      //   394: getfield 144	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:width	I
      //   397: istore_3
      //   398: aload 11
      //   400: getfield 147	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:height	I
      //   403: istore 4
      //   405: aload 11
      //   407: getfield 150	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:result	I
      //   410: istore 5
      //   412: aload 9
      //   414: ifnull +399 -> 813
      //   417: aload 9
      //   419: arraylength
      //   420: istore_1
      //   421: ldc 101
      //   423: ldc 155
      //   425: bipush 6
      //   427: anewarray 4	java/lang/Object
      //   430: dup
      //   431: iconst_0
      //   432: iload 5
      //   434: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   437: aastore
      //   438: dup
      //   439: iconst_1
      //   440: iconst_2
      //   441: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   444: aastore
      //   445: dup
      //   446: iconst_2
      //   447: iload 6
      //   449: invokestatic 160	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   452: aastore
      //   453: dup
      //   454: iconst_3
      //   455: iload_1
      //   456: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   459: aastore
      //   460: dup
      //   461: iconst_4
      //   462: iload_3
      //   463: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   466: aastore
      //   467: dup
      //   468: iconst_5
      //   469: iload 4
      //   471: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   474: aastore
      //   475: invokestatic 117	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   478: new 162	android/graphics/YuvImage
      //   481: dup
      //   482: aload 9
      //   484: bipush 17
      //   486: iload_3
      //   487: iload 4
      //   489: aconst_null
      //   490: invokespecial 165	android/graphics/YuvImage:<init>	([BIII[I)V
      //   493: astore 11
      //   495: new 167	android/graphics/Rect
      //   498: dup
      //   499: iconst_0
      //   500: iconst_0
      //   501: iload_3
      //   502: iload 4
      //   504: invokespecial 170	android/graphics/Rect:<init>	(IIII)V
      //   507: astore 12
      //   509: invokestatic 176	java/lang/System:currentTimeMillis	()J
      //   512: lstore 7
      //   514: new 178	java/io/ByteArrayOutputStream
      //   517: dup
      //   518: invokespecial 179	java/io/ByteArrayOutputStream:<init>	()V
      //   521: astore 9
      //   523: aload 11
      //   525: aload 12
      //   527: bipush 70
      //   529: aload 9
      //   531: invokevirtual 183	android/graphics/YuvImage:compressToJpeg	(Landroid/graphics/Rect;ILjava/io/OutputStream;)Z
      //   534: pop
      //   535: aload 9
      //   537: invokevirtual 186	java/io/ByteArrayOutputStream:flush	()V
      //   540: aload 9
      //   542: invokevirtual 189	java/io/ByteArrayOutputStream:close	()V
      //   545: aload 9
      //   547: invokevirtual 193	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   550: astore 9
      //   552: ldc 101
      //   554: ldc 195
      //   556: iconst_1
      //   557: anewarray 4	java/lang/Object
      //   560: dup
      //   561: iconst_0
      //   562: invokestatic 176	java/lang/System:currentTimeMillis	()J
      //   565: lload 7
      //   567: lsub
      //   568: invokestatic 109	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   571: aastore
      //   572: invokestatic 197	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   575: iload_2
      //   576: istore_1
      //   577: aload 10
      //   579: monitorexit
      //   580: aload_0
      //   581: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   584: invokestatic 43	com/tencent/mm/plugin/scanner/c/a:c	(Lcom/tencent/mm/plugin/scanner/c/a;)Ljava/lang/Object;
      //   587: astore 10
      //   589: aload 10
      //   591: monitorenter
      //   592: new 199	android/os/Bundle
      //   595: dup
      //   596: invokespecial 200	android/os/Bundle:<init>	()V
      //   599: astore 11
      //   601: aload 11
      //   603: ldc 202
      //   605: iload 6
      //   607: invokevirtual 206	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
      //   610: aload 11
      //   612: ldc 208
      //   614: iconst_1
      //   615: invokevirtual 212	android/os/Bundle:putInt	(Ljava/lang/String;I)V
      //   618: aload 11
      //   620: ldc 214
      //   622: iconst_0
      //   623: invokevirtual 212	android/os/Bundle:putInt	(Ljava/lang/String;I)V
      //   626: aload_0
      //   627: getfield 29	com/tencent/mm/plugin/scanner/c/a$c:dmK	J
      //   630: aload_0
      //   631: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   634: invokestatic 51	com/tencent/mm/plugin/scanner/c/a:d	(Lcom/tencent/mm/plugin/scanner/c/a;)J
      //   637: lcmp
      //   638: ifne +270 -> 908
      //   641: iload 6
      //   643: ifeq +246 -> 889
      //   646: aload 9
      //   648: ifnull +241 -> 889
      //   651: aload 11
      //   653: ldc 216
      //   655: aload 9
      //   657: invokevirtual 220	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
      //   660: aload 11
      //   662: ldc 222
      //   664: iload_1
      //   665: invokevirtual 212	android/os/Bundle:putInt	(Ljava/lang/String;I)V
      //   668: aload 11
      //   670: ldc 224
      //   672: aload_0
      //   673: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   676: invokestatic 227	com/tencent/mm/plugin/scanner/c/a:i	(Lcom/tencent/mm/plugin/scanner/c/a;)I
      //   679: invokevirtual 212	android/os/Bundle:putInt	(Ljava/lang/String;I)V
      //   682: aload 11
      //   684: ldc 229
      //   686: aload_0
      //   687: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   690: invokestatic 232	com/tencent/mm/plugin/scanner/c/a:j	(Lcom/tencent/mm/plugin/scanner/c/a;)I
      //   693: invokevirtual 212	android/os/Bundle:putInt	(Ljava/lang/String;I)V
      //   696: invokestatic 236	com/tencent/mm/plugin/scanner/model/v:dOs	()Lcom/tencent/mm/protocal/protobuf/GoodsObject;
      //   699: astore 9
      //   701: aload 9
      //   703: ifnull +15 -> 718
      //   706: aload 11
      //   708: ldc 238
      //   710: aload 9
      //   712: invokevirtual 241	com/tencent/mm/protocal/protobuf/GoodsObject:toByteArray	()[B
      //   715: invokevirtual 220	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
      //   718: aload_0
      //   719: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   722: invokestatic 131	com/tencent/mm/plugin/scanner/c/a:h	(Lcom/tencent/mm/plugin/scanner/c/a;)Lcom/tencent/mm/plugin/scanner/c/a$a;
      //   725: aload_0
      //   726: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   729: invokestatic 51	com/tencent/mm/plugin/scanner/c/a:d	(Lcom/tencent/mm/plugin/scanner/c/a;)J
      //   732: aload 11
      //   734: invokeinterface 244 4 0
      //   739: aload_0
      //   740: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   743: iconst_0
      //   744: invokestatic 47	com/tencent/mm/plugin/scanner/c/a:a	(Lcom/tencent/mm/plugin/scanner/c/a;Z)Z
      //   747: pop
      //   748: aload_0
      //   749: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   752: invokestatic 248	com/tencent/mm/plugin/scanner/c/a:f	(Lcom/tencent/mm/plugin/scanner/c/a;)V
      //   755: aload 10
      //   757: monitorexit
      //   758: ldc 34
      //   760: invokestatic 251	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   763: return
      //   764: aload_0
      //   765: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   768: iconst_0
      //   769: invokestatic 47	com/tencent/mm/plugin/scanner/c/a:a	(Lcom/tencent/mm/plugin/scanner/c/a;Z)Z
      //   772: pop
      //   773: aload_0
      //   774: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   777: invokestatic 248	com/tencent/mm/plugin/scanner/c/a:f	(Lcom/tencent/mm/plugin/scanner/c/a;)V
      //   780: aload 9
      //   782: monitorexit
      //   783: ldc 34
      //   785: invokestatic 251	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   788: return
      //   789: astore 10
      //   791: aload 9
      //   793: monitorexit
      //   794: ldc 34
      //   796: invokestatic 251	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   799: aload 10
      //   801: athrow
      //   802: iconst_0
      //   803: istore_1
      //   804: goto -450 -> 354
      //   807: iconst_0
      //   808: istore 6
      //   810: goto -431 -> 379
      //   813: iconst_m1
      //   814: istore_1
      //   815: goto -394 -> 421
      //   818: astore 11
      //   820: ldc 101
      //   822: aload 11
      //   824: ldc 253
      //   826: iconst_1
      //   827: anewarray 4	java/lang/Object
      //   830: dup
      //   831: iconst_0
      //   832: aload 11
      //   834: invokevirtual 257	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   837: aastore
      //   838: invokestatic 261	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   841: goto -296 -> 545
      //   844: astore 9
      //   846: aload 10
      //   848: monitorexit
      //   849: ldc 34
      //   851: invokestatic 251	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   854: aload 9
      //   856: athrow
      //   857: astore 9
      //   859: ldc 101
      //   861: aload 9
      //   863: ldc_w 263
      //   866: iconst_0
      //   867: anewarray 4	java/lang/Object
      //   870: invokestatic 261	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   873: goto -155 -> 718
      //   876: astore 9
      //   878: aload 10
      //   880: monitorexit
      //   881: ldc 34
      //   883: invokestatic 251	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   886: aload 9
      //   888: athrow
      //   889: aload_0
      //   890: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   893: iconst_0
      //   894: invokestatic 47	com/tencent/mm/plugin/scanner/c/a:a	(Lcom/tencent/mm/plugin/scanner/c/a;Z)Z
      //   897: pop
      //   898: aload_0
      //   899: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   902: invokestatic 248	com/tencent/mm/plugin/scanner/c/a:f	(Lcom/tencent/mm/plugin/scanner/c/a;)V
      //   905: goto -150 -> 755
      //   908: aload_0
      //   909: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   912: iconst_0
      //   913: invokestatic 47	com/tencent/mm/plugin/scanner/c/a:a	(Lcom/tencent/mm/plugin/scanner/c/a;Z)Z
      //   916: pop
      //   917: aload_0
      //   918: getfield 24	com/tencent/mm/plugin/scanner/c/a$c:yBQ	Lcom/tencent/mm/plugin/scanner/c/a;
      //   921: invokestatic 248	com/tencent/mm/plugin/scanner/c/a:f	(Lcom/tencent/mm/plugin/scanner/c/a;)V
      //   924: goto -169 -> 755
      //   927: iconst_0
      //   928: istore_1
      //   929: goto -352 -> 577
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	932	0	this	c
      //   353	576	1	i	int
      //   391	185	2	j	int
      //   397	105	3	k	int
      //   403	100	4	m	int
      //   410	23	5	n	int
      //   1	808	6	bool	boolean
      //   512	54	7	l	long
      //   15	777	9	localObject1	Object
      //   844	11	9	localObject2	Object
      //   857	5	9	localException1	Exception
      //   876	11	9	localObject3	Object
      //   789	90	10	localObject5	Object
      //   287	446	11	localObject6	Object
      //   818	15	11	localException2	Exception
      //   292	234	12	localObject7	Object
      // Exception table:
      //   from	to	target	type
      //   20	164	789	finally
      //   164	167	789	finally
      //   764	783	789	finally
      //   791	794	789	finally
      //   523	545	818	java/lang/Exception
      //   182	294	844	finally
      //   299	323	844	finally
      //   328	352	844	finally
      //   358	376	844	finally
      //   379	412	844	finally
      //   417	421	844	finally
      //   421	523	844	finally
      //   523	545	844	finally
      //   545	575	844	finally
      //   577	580	844	finally
      //   820	841	844	finally
      //   846	849	844	finally
      //   696	701	857	java/lang/Exception
      //   706	718	857	java/lang/Exception
      //   592	641	876	finally
      //   651	696	876	finally
      //   696	701	876	finally
      //   706	718	876	finally
      //   718	755	876	finally
      //   755	758	876	finally
      //   859	873	876	finally
      //   878	881	876	finally
      //   889	905	876	finally
      //   908	924	876	finally
    }
  }
  
  public static abstract interface d
    extends ScanUIRectView.a
  {
    public abstract void B(long paramLong, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.c.a
 * JD-Core Version:    0.7.0.1
 */