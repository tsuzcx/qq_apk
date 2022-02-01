package com.tencent.mm.plugin.scanner.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.s;
import com.tencent.mm.plugin.scanner.model.t;
import com.tencent.mm.plugin.scanner.model.w;
import com.tencent.mm.plugin.scanner.ui.ScanUIRectView.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.f;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static a vNB;
  public boolean fFP;
  public final Object vNC;
  public a vND;
  private int vNE;
  private int vNF;
  private int[] vNG;
  private int vNH;
  private Map vNh;
  public final Object vNi;
  public long vNo;
  private boolean vNq;
  
  static
  {
    AppMethodBeat.i(51584);
    vNB = new a();
    AppMethodBeat.o(51584);
  }
  
  public a()
  {
    AppMethodBeat.i(51576);
    this.vNi = new Object();
    this.vNC = new Object();
    this.vNh = new HashMap();
    this.vNE = 0;
    this.vNF = 0;
    this.vNG = new int[] { 480, 448, 320, 240 };
    this.vNH = 2;
    AppMethodBeat.o(51576);
  }
  
  public static a dln()
  {
    return vNB;
  }
  
  private t dlo()
  {
    AppMethodBeat.i(51579);
    b localb = new b(this.vNo);
    AppMethodBeat.o(51579);
    return localb;
  }
  
  private byte[] el(String paramString, int paramInt)
  {
    AppMethodBeat.i(51577);
    try
    {
      Bitmap localBitmap = em(paramString, paramInt);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localBitmap.compress(Bitmap.CompressFormat.JPEG, 70, localByteArrayOutputStream);
        byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
        ad.i("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo compressImage decode bitmap width: %d, height: %d, data: %d", new Object[] { Integer.valueOf(localBitmap.getWidth()), Integer.valueOf(localBitmap.getHeight()), Integer.valueOf(arrayOfByte.length) });
        paramString = arrayOfByte;
        if (arrayOfByte.length > 122880)
        {
          paramString = arrayOfByte;
          if (!localBitmap.isRecycled())
          {
            localByteArrayOutputStream.reset();
            localBitmap.compress(Bitmap.CompressFormat.JPEG, 50, localByteArrayOutputStream);
            paramString = localByteArrayOutputStream.toByteArray();
            ad.i("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo compressImage compressed data: %d", new Object[] { Integer.valueOf(paramString.length) });
          }
        }
        localBitmap.recycle();
        localByteArrayOutputStream.close();
        AppMethodBeat.o(51577);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.AiScanImageDecodeQueueNew", paramString, "alvinluo compressImage exception", new Object[0]);
      AppMethodBeat.o(51577);
    }
    return null;
  }
  
  private Bitmap em(String paramString, int paramInt)
  {
    AppMethodBeat.i(51578);
    try
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      f.decodeFile(paramString, (BitmapFactory.Options)localObject);
      int k = ((BitmapFactory.Options)localObject).outWidth;
      int m = ((BitmapFactory.Options)localObject).outHeight;
      int i;
      int j;
      if (k > m) {
        if (this.vNH == 1)
        {
          i = (int)(m * 1.0F * paramInt / k);
          j = paramInt;
        }
      }
      for (;;)
      {
        Point localPoint = new Point(j, i);
        paramInt = localPoint.x;
        i = localPoint.y;
        ((BitmapFactory.Options)localObject).inSampleSize = f.M(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight, paramInt, i);
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        ad.i("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo resizeImage width: %d, height: %d, targetWidth: %d, targetHeight: %d, sampleSize: %d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(((BitmapFactory.Options)localObject).inSampleSize) });
        localObject = f.decodeFile(paramString, (BitmapFactory.Options)localObject);
        paramString = (String)localObject;
        if (localObject != null)
        {
          paramString = (String)localObject;
          if (!((Bitmap)localObject).isRecycled())
          {
            paramString = (String)localObject;
            if (((Bitmap)localObject).getWidth() != paramInt) {
              paramString = f.a((Bitmap)localObject, i, paramInt, false, true);
            }
          }
        }
        AppMethodBeat.o(51578);
        return paramString;
        i = m;
        j = k;
        if (this.vNH == 2)
        {
          j = (int)(k * 1.0F * paramInt / m);
          i = paramInt;
          continue;
          if (this.vNH == 1)
          {
            j = (int)(k * 1.0F * paramInt / m);
            i = paramInt;
          }
          else
          {
            int n = this.vNH;
            i = m;
            j = k;
            if (n == 2)
            {
              i = (int)(m * 1.0F * paramInt / k);
              j = paramInt;
            }
          }
        }
      }
      return null;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.AiScanImageDecodeQueueNew", paramString, "alvinluo resizeImage exception", new Object[0]);
      AppMethodBeat.o(51578);
    }
  }
  
  public final void a(final byte[] paramArrayOfByte, final Point paramPoint, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(160998);
    ad.v("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo addDecodeTask resolution: %s, previewData length: %d, cameraRotation: %d, previewFormat: %d", new Object[] { paramPoint, Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    s.a(new t()
    {
      public final void run()
      {
        AppMethodBeat.i(51572);
        a.a(a.this, paramArrayOfByte, paramPoint, paramInt1, paramInt2);
        AppMethodBeat.o(51572);
      }
    });
    AppMethodBeat.o(160998);
  }
  
  public final void rW(long paramLong)
  {
    AppMethodBeat.i(51580);
    synchronized (this.vNi)
    {
      if (this.vNo == paramLong)
      {
        this.vNo = 0L;
        this.vND = null;
        this.vNh.clear();
      }
      AppMethodBeat.o(51580);
      return;
    }
  }
  
  public static abstract interface a
    extends b.a
  {
    public abstract void a(w paramw);
  }
  
  final class b
    implements t
  {
    private long dcQ;
    private int pPJ;
    private int pixelFormat;
    private byte[] vNs;
    private Point vNt;
    
    public b(long paramLong)
    {
      this.dcQ = paramLong;
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
      //   9: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   12: invokestatic 44	com/tencent/mm/plugin/scanner/c/a:d	(Lcom/tencent/mm/plugin/scanner/c/a;)Ljava/lang/Object;
      //   15: astore 9
      //   17: aload 9
      //   19: monitorenter
      //   20: aload_0
      //   21: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   24: iconst_1
      //   25: invokestatic 48	com/tencent/mm/plugin/scanner/c/a:a	(Lcom/tencent/mm/plugin/scanner/c/a;Z)Z
      //   28: pop
      //   29: aload_0
      //   30: getfield 29	com/tencent/mm/plugin/scanner/c/a$b:dcQ	J
      //   33: aload_0
      //   34: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   37: invokestatic 52	com/tencent/mm/plugin/scanner/c/a:e	(Lcom/tencent/mm/plugin/scanner/c/a;)J
      //   40: lcmp
      //   41: ifne +715 -> 756
      //   44: aload_0
      //   45: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   48: invokestatic 56	com/tencent/mm/plugin/scanner/c/a:f	(Lcom/tencent/mm/plugin/scanner/c/a;)Ljava/util/Map;
      //   51: invokeinterface 62 1 0
      //   56: ifne +108 -> 164
      //   59: aload_0
      //   60: aload_0
      //   61: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   64: invokestatic 56	com/tencent/mm/plugin/scanner/c/a:f	(Lcom/tencent/mm/plugin/scanner/c/a;)Ljava/util/Map;
      //   67: ldc 64
      //   69: invokeinterface 68 2 0
      //   74: checkcast 69	[B
      //   77: checkcast 69	[B
      //   80: putfield 71	com/tencent/mm/plugin/scanner/c/a$b:vNs	[B
      //   83: aload_0
      //   84: aload_0
      //   85: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   88: invokestatic 56	com/tencent/mm/plugin/scanner/c/a:f	(Lcom/tencent/mm/plugin/scanner/c/a;)Ljava/util/Map;
      //   91: ldc 73
      //   93: invokeinterface 68 2 0
      //   98: checkcast 75	android/graphics/Point
      //   101: putfield 77	com/tencent/mm/plugin/scanner/c/a$b:vNt	Landroid/graphics/Point;
      //   104: aload_0
      //   105: aload_0
      //   106: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   109: invokestatic 56	com/tencent/mm/plugin/scanner/c/a:f	(Lcom/tencent/mm/plugin/scanner/c/a;)Ljava/util/Map;
      //   112: ldc 79
      //   114: invokeinterface 68 2 0
      //   119: checkcast 81	java/lang/Integer
      //   122: invokevirtual 85	java/lang/Integer:intValue	()I
      //   125: putfield 87	com/tencent/mm/plugin/scanner/c/a$b:pPJ	I
      //   128: aload_0
      //   129: aload_0
      //   130: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   133: invokestatic 56	com/tencent/mm/plugin/scanner/c/a:f	(Lcom/tencent/mm/plugin/scanner/c/a;)Ljava/util/Map;
      //   136: ldc 89
      //   138: invokeinterface 68 2 0
      //   143: checkcast 81	java/lang/Integer
      //   146: invokevirtual 85	java/lang/Integer:intValue	()I
      //   149: putfield 91	com/tencent/mm/plugin/scanner/c/a$b:pixelFormat	I
      //   152: aload_0
      //   153: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   156: invokestatic 56	com/tencent/mm/plugin/scanner/c/a:f	(Lcom/tencent/mm/plugin/scanner/c/a;)Ljava/util/Map;
      //   159: invokeinterface 94 1 0
      //   164: aload 9
      //   166: monitorexit
      //   167: aconst_null
      //   168: astore 9
      //   170: aload_0
      //   171: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   174: invokestatic 97	com/tencent/mm/plugin/scanner/c/a:h	(Lcom/tencent/mm/plugin/scanner/c/a;)Ljava/lang/Object;
      //   177: astore 10
      //   179: aload 10
      //   181: monitorenter
      //   182: aload_0
      //   183: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   186: invokestatic 100	com/tencent/mm/plugin/scanner/c/a:b	(Lcom/tencent/mm/plugin/scanner/c/a;)Z
      //   189: ifeq +730 -> 919
      //   192: aload_0
      //   193: getfield 71	com/tencent/mm/plugin/scanner/c/a$b:vNs	[B
      //   196: ifnull +723 -> 919
      //   199: ldc 102
      //   201: ldc 104
      //   203: bipush 6
      //   205: anewarray 4	java/lang/Object
      //   208: dup
      //   209: iconst_0
      //   210: aload_0
      //   211: getfield 29	com/tencent/mm/plugin/scanner/c/a$b:dcQ	J
      //   214: invokestatic 110	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   217: aastore
      //   218: dup
      //   219: iconst_1
      //   220: aload_0
      //   221: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   224: invokestatic 52	com/tencent/mm/plugin/scanner/c/a:e	(Lcom/tencent/mm/plugin/scanner/c/a;)J
      //   227: invokestatic 110	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   230: aastore
      //   231: dup
      //   232: iconst_2
      //   233: aload_0
      //   234: getfield 77	com/tencent/mm/plugin/scanner/c/a$b:vNt	Landroid/graphics/Point;
      //   237: aastore
      //   238: dup
      //   239: iconst_3
      //   240: aload_0
      //   241: getfield 91	com/tencent/mm/plugin/scanner/c/a$b:pixelFormat	I
      //   244: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   247: aastore
      //   248: dup
      //   249: iconst_4
      //   250: aload_0
      //   251: getfield 87	com/tencent/mm/plugin/scanner/c/a$b:pPJ	I
      //   254: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   257: aastore
      //   258: dup
      //   259: iconst_5
      //   260: aload_0
      //   261: getfield 71	com/tencent/mm/plugin/scanner/c/a$b:vNs	[B
      //   264: arraylength
      //   265: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   268: aastore
      //   269: invokestatic 118	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   272: aload_0
      //   273: getfield 71	com/tencent/mm/plugin/scanner/c/a$b:vNs	[B
      //   276: aload_0
      //   277: getfield 91	com/tencent/mm/plugin/scanner/c/a$b:pixelFormat	I
      //   280: aload_0
      //   281: getfield 87	com/tencent/mm/plugin/scanner/c/a$b:pPJ	I
      //   284: invokestatic 124	com/tencent/mm/plugin/scanner/model/s:process	([BII)Lcom/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative;
      //   287: astore 11
      //   289: invokestatic 128	com/tencent/mm/plugin/scanner/model/s:dlx	()Lcom/tencent/mm/plugin/scanner/model/w;
      //   292: astore 12
      //   294: aload 12
      //   296: ifnull +27 -> 323
      //   299: aload_0
      //   300: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   303: invokestatic 131	com/tencent/mm/plugin/scanner/c/a:i	(Lcom/tencent/mm/plugin/scanner/c/a;)Lcom/tencent/mm/plugin/scanner/c/a$a;
      //   306: ifnull +17 -> 323
      //   309: aload_0
      //   310: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   313: invokestatic 131	com/tencent/mm/plugin/scanner/c/a:i	(Lcom/tencent/mm/plugin/scanner/c/a;)Lcom/tencent/mm/plugin/scanner/c/a$a;
      //   316: aload 12
      //   318: invokeinterface 136 2 0
      //   323: aload 11
      //   325: ifnull +469 -> 794
      //   328: aload 11
      //   330: getfield 141	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:bestImageData	[B
      //   333: ifnull +461 -> 794
      //   336: aload 11
      //   338: getfield 144	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:width	I
      //   341: ifle +453 -> 794
      //   344: aload 11
      //   346: getfield 147	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:height	I
      //   349: ifle +445 -> 794
      //   352: iconst_1
      //   353: istore_1
      //   354: iload_1
      //   355: ifeq +564 -> 919
      //   358: aload 11
      //   360: getfield 150	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:result	I
      //   363: ifle +436 -> 799
      //   366: aload 11
      //   368: getfield 150	com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative:result	I
      //   371: iconst_2
      //   372: iand
      //   373: ifeq +426 -> 799
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
      //   414: ifnull +391 -> 805
      //   417: aload 9
      //   419: arraylength
      //   420: istore_1
      //   421: ldc 102
      //   423: ldc 155
      //   425: bipush 6
      //   427: anewarray 4	java/lang/Object
      //   430: dup
      //   431: iconst_0
      //   432: iload 5
      //   434: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   437: aastore
      //   438: dup
      //   439: iconst_1
      //   440: iconst_2
      //   441: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   444: aastore
      //   445: dup
      //   446: iconst_2
      //   447: iload 6
      //   449: invokestatic 160	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   452: aastore
      //   453: dup
      //   454: iconst_3
      //   455: iload_1
      //   456: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   459: aastore
      //   460: dup
      //   461: iconst_4
      //   462: iload_3
      //   463: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   466: aastore
      //   467: dup
      //   468: iconst_5
      //   469: iload 4
      //   471: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   474: aastore
      //   475: invokestatic 118	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   552: ldc 102
      //   554: ldc 195
      //   556: iconst_1
      //   557: anewarray 4	java/lang/Object
      //   560: dup
      //   561: iconst_0
      //   562: invokestatic 176	java/lang/System:currentTimeMillis	()J
      //   565: lload 7
      //   567: lsub
      //   568: invokestatic 110	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   571: aastore
      //   572: invokestatic 197	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   575: iload_2
      //   576: istore_1
      //   577: aload 10
      //   579: monitorexit
      //   580: aload_0
      //   581: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   584: invokestatic 44	com/tencent/mm/plugin/scanner/c/a:d	(Lcom/tencent/mm/plugin/scanner/c/a;)Ljava/lang/Object;
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
      //   618: aload_0
      //   619: getfield 29	com/tencent/mm/plugin/scanner/c/a$b:dcQ	J
      //   622: aload_0
      //   623: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   626: invokestatic 52	com/tencent/mm/plugin/scanner/c/a:e	(Lcom/tencent/mm/plugin/scanner/c/a;)J
      //   629: lcmp
      //   630: ifne +270 -> 900
      //   633: iload 6
      //   635: ifeq +246 -> 881
      //   638: aload 9
      //   640: ifnull +241 -> 881
      //   643: aload 11
      //   645: ldc 214
      //   647: aload 9
      //   649: invokevirtual 218	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
      //   652: aload 11
      //   654: ldc 220
      //   656: iload_1
      //   657: invokevirtual 212	android/os/Bundle:putInt	(Ljava/lang/String;I)V
      //   660: aload 11
      //   662: ldc 222
      //   664: aload_0
      //   665: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   668: invokestatic 226	com/tencent/mm/plugin/scanner/c/a:j	(Lcom/tencent/mm/plugin/scanner/c/a;)I
      //   671: invokevirtual 212	android/os/Bundle:putInt	(Ljava/lang/String;I)V
      //   674: aload 11
      //   676: ldc 228
      //   678: aload_0
      //   679: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   682: invokestatic 231	com/tencent/mm/plugin/scanner/c/a:k	(Lcom/tencent/mm/plugin/scanner/c/a;)I
      //   685: invokevirtual 212	android/os/Bundle:putInt	(Ljava/lang/String;I)V
      //   688: invokestatic 235	com/tencent/mm/plugin/scanner/model/s:dly	()Lcom/tencent/mm/protocal/protobuf/GoodsObject;
      //   691: astore 9
      //   693: aload 9
      //   695: ifnull +15 -> 710
      //   698: aload 11
      //   700: ldc 237
      //   702: aload 9
      //   704: invokevirtual 240	com/tencent/mm/protocal/protobuf/GoodsObject:toByteArray	()[B
      //   707: invokevirtual 218	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
      //   710: aload_0
      //   711: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   714: invokestatic 131	com/tencent/mm/plugin/scanner/c/a:i	(Lcom/tencent/mm/plugin/scanner/c/a;)Lcom/tencent/mm/plugin/scanner/c/a$a;
      //   717: aload_0
      //   718: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   721: invokestatic 52	com/tencent/mm/plugin/scanner/c/a:e	(Lcom/tencent/mm/plugin/scanner/c/a;)J
      //   724: aload 11
      //   726: invokeinterface 243 4 0
      //   731: aload_0
      //   732: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   735: iconst_0
      //   736: invokestatic 48	com/tencent/mm/plugin/scanner/c/a:a	(Lcom/tencent/mm/plugin/scanner/c/a;Z)Z
      //   739: pop
      //   740: aload_0
      //   741: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   744: invokestatic 247	com/tencent/mm/plugin/scanner/c/a:g	(Lcom/tencent/mm/plugin/scanner/c/a;)V
      //   747: aload 10
      //   749: monitorexit
      //   750: ldc 34
      //   752: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   755: return
      //   756: aload_0
      //   757: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   760: iconst_0
      //   761: invokestatic 48	com/tencent/mm/plugin/scanner/c/a:a	(Lcom/tencent/mm/plugin/scanner/c/a;Z)Z
      //   764: pop
      //   765: aload_0
      //   766: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   769: invokestatic 247	com/tencent/mm/plugin/scanner/c/a:g	(Lcom/tencent/mm/plugin/scanner/c/a;)V
      //   772: aload 9
      //   774: monitorexit
      //   775: ldc 34
      //   777: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   780: return
      //   781: astore 10
      //   783: aload 9
      //   785: monitorexit
      //   786: ldc 34
      //   788: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   791: aload 10
      //   793: athrow
      //   794: iconst_0
      //   795: istore_1
      //   796: goto -442 -> 354
      //   799: iconst_0
      //   800: istore 6
      //   802: goto -423 -> 379
      //   805: iconst_m1
      //   806: istore_1
      //   807: goto -386 -> 421
      //   810: astore 11
      //   812: ldc 102
      //   814: aload 11
      //   816: ldc 252
      //   818: iconst_1
      //   819: anewarray 4	java/lang/Object
      //   822: dup
      //   823: iconst_0
      //   824: aload 11
      //   826: invokevirtual 256	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   829: aastore
      //   830: invokestatic 260	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   833: goto -288 -> 545
      //   836: astore 9
      //   838: aload 10
      //   840: monitorexit
      //   841: ldc 34
      //   843: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   846: aload 9
      //   848: athrow
      //   849: astore 9
      //   851: ldc 102
      //   853: aload 9
      //   855: ldc_w 262
      //   858: iconst_0
      //   859: anewarray 4	java/lang/Object
      //   862: invokestatic 260	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   865: goto -155 -> 710
      //   868: astore 9
      //   870: aload 10
      //   872: monitorexit
      //   873: ldc 34
      //   875: invokestatic 250	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   878: aload 9
      //   880: athrow
      //   881: aload_0
      //   882: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   885: iconst_0
      //   886: invokestatic 48	com/tencent/mm/plugin/scanner/c/a:a	(Lcom/tencent/mm/plugin/scanner/c/a;Z)Z
      //   889: pop
      //   890: aload_0
      //   891: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   894: invokestatic 247	com/tencent/mm/plugin/scanner/c/a:g	(Lcom/tencent/mm/plugin/scanner/c/a;)V
      //   897: goto -150 -> 747
      //   900: aload_0
      //   901: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   904: iconst_0
      //   905: invokestatic 48	com/tencent/mm/plugin/scanner/c/a:a	(Lcom/tencent/mm/plugin/scanner/c/a;Z)Z
      //   908: pop
      //   909: aload_0
      //   910: getfield 24	com/tencent/mm/plugin/scanner/c/a$b:vNM	Lcom/tencent/mm/plugin/scanner/c/a;
      //   913: invokestatic 247	com/tencent/mm/plugin/scanner/c/a:g	(Lcom/tencent/mm/plugin/scanner/c/a;)V
      //   916: goto -169 -> 747
      //   919: iconst_0
      //   920: istore_1
      //   921: goto -344 -> 577
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	924	0	this	b
      //   353	568	1	i	int
      //   391	185	2	j	int
      //   397	105	3	k	int
      //   403	100	4	m	int
      //   410	23	5	n	int
      //   1	800	6	bool	boolean
      //   512	54	7	l	long
      //   15	769	9	localObject1	Object
      //   836	11	9	localObject2	Object
      //   849	5	9	localException1	Exception
      //   868	11	9	localObject3	Object
      //   781	90	10	localObject5	Object
      //   287	438	11	localObject6	Object
      //   810	15	11	localException2	Exception
      //   292	234	12	localObject7	Object
      // Exception table:
      //   from	to	target	type
      //   20	164	781	finally
      //   164	167	781	finally
      //   756	775	781	finally
      //   783	786	781	finally
      //   523	545	810	java/lang/Exception
      //   182	294	836	finally
      //   299	323	836	finally
      //   328	352	836	finally
      //   358	376	836	finally
      //   379	412	836	finally
      //   417	421	836	finally
      //   421	523	836	finally
      //   523	545	836	finally
      //   545	575	836	finally
      //   577	580	836	finally
      //   812	833	836	finally
      //   838	841	836	finally
      //   688	693	849	java/lang/Exception
      //   698	710	849	java/lang/Exception
      //   592	633	868	finally
      //   643	688	868	finally
      //   688	693	868	finally
      //   698	710	868	finally
      //   710	747	868	finally
      //   747	750	868	finally
      //   851	865	868	finally
      //   870	873	868	finally
      //   881	897	868	finally
      //   900	916	868	finally
    }
  }
  
  public static abstract interface c
    extends ScanUIRectView.a
  {
    public abstract void z(long paramLong, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.c.a
 * JD-Core Version:    0.7.0.1
 */