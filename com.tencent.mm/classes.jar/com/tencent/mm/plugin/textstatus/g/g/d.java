package com.tencent.mm.plugin.textstatus.g.g;

import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/upload/UploadPackHelper;", "", "()V", "TAG", "", "THUMB_DEFAULT_SCALE", "", "commit", "", "postInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "compressBigBitmap", "oriPath", "compressBitmap", "destFile", "Lcom/tencent/mm/vfs/VFSFile;", "quality", "", "copyFile", "getSendThumbnailPath", "thumbnailPath", "tips", "animVisible", "isPostNow", "", "plugin-textstatus_release"})
public final class d
{
  public static final d MEw;
  
  static
  {
    AppMethodBeat.i(236100);
    MEw = new d();
    AppMethodBeat.o(236100);
  }
  
  public static boolean b(al paramal)
  {
    AppMethodBeat.i(236078);
    p.k(paramal, "$this$isPostNow");
    if (paramal.MFP)
    {
      AppMethodBeat.o(236078);
      return true;
    }
    CharSequence localCharSequence = (CharSequence)paramal.MFN.mediaThumbUrl;
    if ((localCharSequence == null) || (n.ba(localCharSequence)))
    {
      i = 1;
      if (i != 0) {
        break label98;
      }
      paramal = (CharSequence)paramal.MFN.mediaUrl;
      if ((paramal != null) && (!n.ba(paramal))) {
        break label93;
      }
    }
    label93:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label98;
      }
      AppMethodBeat.o(236078);
      return true;
      i = 0;
      break;
    }
    label98:
    AppMethodBeat.o(236078);
    return false;
  }
  
  private final String beC(String paramString)
  {
    AppMethodBeat.i(236093);
    paramString = paramString + "_" + hashCode();
    AppMethodBeat.o(236093);
    return paramString;
  }
  
  public static void c(al paramal)
  {
    AppMethodBeat.i(236079);
    p.k(paramal, "postInfo");
    h.ZvG.d((Runnable)new a(paramal), "MicroMsg.TextStatus.UploadPackHelper");
    AppMethodBeat.o(236079);
  }
  
  /* Error */
  public final String a(String paramString, q paramq, int paramInt)
  {
    // Byte code:
    //   0: ldc 201
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 202
    //   8: invokestatic 65	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_2
    //   12: ldc 203
    //   14: invokestatic 65	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: new 205	com/tencent/mm/vfs/q
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 208	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   25: astore 16
    //   27: aconst_null
    //   28: astore 14
    //   30: aconst_null
    //   31: astore 15
    //   33: aconst_null
    //   34: astore 12
    //   36: aconst_null
    //   37: astore 13
    //   39: ldc 131
    //   41: ldc 210
    //   43: iconst_1
    //   44: anewarray 4	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: aload 16
    //   51: invokevirtual 214	com/tencent/mm/vfs/q:length	()J
    //   54: invokestatic 219	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   57: aastore
    //   58: invokestatic 224	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: aload 16
    //   63: invokevirtual 214	com/tencent/mm/vfs/q:length	()J
    //   66: ldc2_w 225
    //   69: lcmp
    //   70: ifle +753 -> 823
    //   73: aload_2
    //   74: invokevirtual 230	com/tencent/mm/vfs/q:ifE	()Z
    //   77: ifeq +124 -> 201
    //   80: ldc 131
    //   82: ldc 232
    //   84: iconst_1
    //   85: anewarray 4	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: aload_2
    //   91: invokevirtual 235	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   94: aastore
    //   95: invokestatic 224	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   98: iconst_1
    //   99: istore 9
    //   101: aload 15
    //   103: astore 11
    //   105: aload 13
    //   107: astore 12
    //   109: aload 11
    //   111: ifnull +8 -> 119
    //   114: aload 11
    //   116: invokevirtual 240	java/io/InputStream:close	()V
    //   119: iload 9
    //   121: istore 10
    //   123: aload 12
    //   125: ifnull +12 -> 137
    //   128: aload 12
    //   130: invokevirtual 243	java/io/OutputStream:close	()V
    //   133: iload 9
    //   135: istore 10
    //   137: iload 10
    //   139: ifeq +559 -> 698
    //   142: ldc 131
    //   144: ldc 245
    //   146: iconst_4
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_0
    //   153: aload_1
    //   154: invokespecial 247	com/tencent/mm/plugin/textstatus/g/g/d:beC	(Ljava/lang/String;)Ljava/lang/String;
    //   157: aastore
    //   158: dup
    //   159: iconst_1
    //   160: aload 16
    //   162: invokevirtual 214	com/tencent/mm/vfs/q:length	()J
    //   165: invokestatic 219	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   168: aastore
    //   169: dup
    //   170: iconst_2
    //   171: aload_2
    //   172: invokevirtual 214	com/tencent/mm/vfs/q:length	()J
    //   175: invokestatic 219	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   178: aastore
    //   179: dup
    //   180: iconst_3
    //   181: aload_2
    //   182: invokevirtual 235	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   185: aastore
    //   186: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: aload_2
    //   190: invokevirtual 235	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   193: astore_1
    //   194: ldc 201
    //   196: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: aload_1
    //   200: areturn
    //   201: invokestatic 255	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   204: invokestatic 261	com/tencent/mm/ci/a:getDensity	(Landroid/content/Context;)F
    //   207: fstore 4
    //   209: aload 16
    //   211: invokevirtual 235	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   214: invokestatic 267	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   217: astore 17
    //   219: ldc_w 268
    //   222: aload 17
    //   224: getfield 273	android/graphics/BitmapFactory$Options:outWidth	I
    //   227: i2f
    //   228: fload 4
    //   230: fmul
    //   231: fmul
    //   232: fstore 5
    //   234: ldc_w 268
    //   237: fload 4
    //   239: aload 17
    //   241: getfield 276	android/graphics/BitmapFactory$Options:outHeight	I
    //   244: i2f
    //   245: fmul
    //   246: fmul
    //   247: fstore 6
    //   249: invokestatic 280	com/tencent/mm/sdk/platformtools/MMApplicationContext:getResources	()Landroid/content/res/Resources;
    //   252: astore 11
    //   254: aload 11
    //   256: ldc_w 282
    //   259: invokestatic 170	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   262: aload 11
    //   264: invokevirtual 288	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   267: astore 11
    //   269: fload 5
    //   271: aload 11
    //   273: getfield 293	android/util/DisplayMetrics:widthPixels	I
    //   276: i2f
    //   277: fcmpl
    //   278: ifge +15 -> 293
    //   281: fload 6
    //   283: aload 11
    //   285: getfield 296	android/util/DisplayMetrics:heightPixels	I
    //   288: i2f
    //   289: fcmpl
    //   290: iflt +526 -> 816
    //   293: fload 6
    //   295: fload 5
    //   297: fcmpl
    //   298: ifle +175 -> 473
    //   301: aload 11
    //   303: getfield 296	android/util/DisplayMetrics:heightPixels	I
    //   306: i2f
    //   307: fload 6
    //   309: fdiv
    //   310: fstore 4
    //   312: goto +525 -> 837
    //   315: aload 17
    //   317: ifnonnull +170 -> 487
    //   320: ldc_w 298
    //   323: astore 11
    //   325: ldc 131
    //   327: ldc_w 300
    //   330: iconst_1
    //   331: anewarray 4	java/lang/Object
    //   334: dup
    //   335: iconst_0
    //   336: aload 11
    //   338: aastore
    //   339: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   342: aload 17
    //   344: ifnull +180 -> 524
    //   347: aload 17
    //   349: getfield 273	android/graphics/BitmapFactory$Options:outWidth	I
    //   352: i2f
    //   353: fload 5
    //   355: fcmpl
    //   356: ifgt +15 -> 371
    //   359: aload 17
    //   361: getfield 276	android/graphics/BitmapFactory$Options:outHeight	I
    //   364: i2f
    //   365: fload 4
    //   367: fcmpl
    //   368: ifle +156 -> 524
    //   371: aload 16
    //   373: invokevirtual 235	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   376: astore 11
    //   378: fload 4
    //   380: f2i
    //   381: istore 7
    //   383: fload 5
    //   385: f2i
    //   386: istore 8
    //   388: getstatic 306	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   391: astore 17
    //   393: new 97	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   400: astore 18
    //   402: aload_2
    //   403: invokevirtual 310	com/tencent/mm/vfs/q:ifB	()Lcom/tencent/mm/vfs/q;
    //   406: astore 19
    //   408: aload 19
    //   410: ifnonnull +6 -> 416
    //   413: invokestatic 313	kotlin/g/b/p:iCn	()V
    //   416: aload 19
    //   418: ldc_w 315
    //   421: invokestatic 170	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   424: aload 11
    //   426: iload 7
    //   428: iload 8
    //   430: aload 17
    //   432: iload_3
    //   433: aload 18
    //   435: aload 19
    //   437: invokevirtual 235	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   440: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: ldc_w 317
    //   446: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: aload_2
    //   453: invokevirtual 320	com/tencent/mm/vfs/q:getName	()Ljava/lang/String;
    //   456: iconst_1
    //   457: invokestatic 324	com/tencent/mm/sdk/platformtools/BitmapUtil:createThumbNail	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   460: istore 9
    //   462: aload 13
    //   464: astore 12
    //   466: aload 15
    //   468: astore 11
    //   470: goto -361 -> 109
    //   473: aload 11
    //   475: getfield 293	android/util/DisplayMetrics:widthPixels	I
    //   478: i2f
    //   479: fload 5
    //   481: fdiv
    //   482: fstore 4
    //   484: goto +353 -> 837
    //   487: new 97	java/lang/StringBuilder
    //   490: dup
    //   491: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   494: aload 17
    //   496: getfield 273	android/graphics/BitmapFactory$Options:outWidth	I
    //   499: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   502: ldc_w 326
    //   505: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: aload 17
    //   510: getfield 276	android/graphics/BitmapFactory$Options:outHeight	I
    //   513: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   516: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: astore 11
    //   521: goto -196 -> 325
    //   524: aload 16
    //   526: invokestatic 330	com/tencent/mm/vfs/u:al	(Lcom/tencent/mm/vfs/q;)Ljava/io/InputStream;
    //   529: astore 11
    //   531: fload 5
    //   533: f2i
    //   534: istore 7
    //   536: fload 4
    //   538: f2i
    //   539: istore 8
    //   541: aload 11
    //   543: fconst_0
    //   544: iload 7
    //   546: iload 8
    //   548: invokestatic 334	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeStream	(Ljava/io/InputStream;FII)Landroid/graphics/Bitmap;
    //   551: astore 15
    //   553: aload 15
    //   555: ifnull +251 -> 806
    //   558: aload_2
    //   559: invokestatic 338	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   562: astore 13
    //   564: aload 13
    //   566: astore 12
    //   568: aload 12
    //   570: astore 14
    //   572: aload 11
    //   574: astore 13
    //   576: aload 15
    //   578: getstatic 306	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   581: iload_3
    //   582: aload 12
    //   584: invokevirtual 344	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   587: istore 9
    //   589: goto -480 -> 109
    //   592: astore 15
    //   594: aconst_null
    //   595: astore 12
    //   597: aconst_null
    //   598: astore 11
    //   600: aload 12
    //   602: astore 14
    //   604: aload 11
    //   606: astore 13
    //   608: ldc 131
    //   610: ldc_w 346
    //   613: iconst_1
    //   614: anewarray 4	java/lang/Object
    //   617: dup
    //   618: iconst_0
    //   619: aload 15
    //   621: checkcast 348	java/lang/Throwable
    //   624: invokestatic 354	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   627: aastore
    //   628: invokestatic 357	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   631: aload 11
    //   633: ifnull +8 -> 641
    //   636: aload 11
    //   638: invokevirtual 240	java/io/InputStream:close	()V
    //   641: aload 12
    //   643: ifnull +16 -> 659
    //   646: aload 12
    //   648: invokevirtual 243	java/io/OutputStream:close	()V
    //   651: iconst_0
    //   652: istore 10
    //   654: goto -517 -> 137
    //   657: astore 11
    //   659: iconst_0
    //   660: istore 10
    //   662: goto -525 -> 137
    //   665: astore_1
    //   666: aload 14
    //   668: astore_2
    //   669: aload 12
    //   671: astore 11
    //   673: aload_2
    //   674: ifnull +7 -> 681
    //   677: aload_2
    //   678: invokevirtual 240	java/io/InputStream:close	()V
    //   681: aload 11
    //   683: ifnull +8 -> 691
    //   686: aload 11
    //   688: invokevirtual 243	java/io/OutputStream:close	()V
    //   691: ldc 201
    //   693: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   696: aload_1
    //   697: athrow
    //   698: ldc 131
    //   700: ldc_w 359
    //   703: iconst_3
    //   704: anewarray 4	java/lang/Object
    //   707: dup
    //   708: iconst_0
    //   709: aload_0
    //   710: aload_1
    //   711: invokespecial 247	com/tencent/mm/plugin/textstatus/g/g/d:beC	(Ljava/lang/String;)Ljava/lang/String;
    //   714: aastore
    //   715: dup
    //   716: iconst_1
    //   717: aload 16
    //   719: invokevirtual 214	com/tencent/mm/vfs/q:length	()J
    //   722: invokestatic 219	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   725: aastore
    //   726: dup
    //   727: iconst_2
    //   728: aload 16
    //   730: invokevirtual 235	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   733: aastore
    //   734: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   737: ldc 201
    //   739: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   742: aload_1
    //   743: areturn
    //   744: astore 11
    //   746: goto -627 -> 119
    //   749: astore 11
    //   751: iload 9
    //   753: istore 10
    //   755: goto -618 -> 137
    //   758: astore 11
    //   760: goto -119 -> 641
    //   763: astore_2
    //   764: goto -83 -> 681
    //   767: astore_2
    //   768: goto -77 -> 691
    //   771: astore_1
    //   772: aload 11
    //   774: astore_2
    //   775: aload 12
    //   777: astore 11
    //   779: goto -106 -> 673
    //   782: astore_1
    //   783: aload 14
    //   785: astore 11
    //   787: aload 13
    //   789: astore_2
    //   790: goto -117 -> 673
    //   793: astore 15
    //   795: aconst_null
    //   796: astore 12
    //   798: goto -198 -> 600
    //   801: astore 15
    //   803: goto -203 -> 600
    //   806: iconst_0
    //   807: istore 9
    //   809: aload 13
    //   811: astore 12
    //   813: goto -704 -> 109
    //   816: fload 6
    //   818: fstore 4
    //   820: goto -505 -> 315
    //   823: iconst_0
    //   824: istore 9
    //   826: aload 13
    //   828: astore 12
    //   830: aload 15
    //   832: astore 11
    //   834: goto -725 -> 109
    //   837: fload 5
    //   839: fload 4
    //   841: fmul
    //   842: f2i
    //   843: i2f
    //   844: fstore 5
    //   846: fload 4
    //   848: fload 6
    //   850: fmul
    //   851: f2i
    //   852: i2f
    //   853: fstore 4
    //   855: goto -540 -> 315
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	858	0	this	d
    //   0	858	1	paramString	String
    //   0	858	2	paramq	q
    //   0	858	3	paramInt	int
    //   207	647	4	f1	float
    //   232	613	5	f2	float
    //   247	602	6	f3	float
    //   381	164	7	i	int
    //   386	161	8	j	int
    //   99	726	9	bool1	boolean
    //   121	633	10	bool2	boolean
    //   103	534	11	localObject1	Object
    //   657	1	11	localIOException1	java.io.IOException
    //   671	16	11	localObject2	Object
    //   744	1	11	localIOException2	java.io.IOException
    //   749	1	11	localIOException3	java.io.IOException
    //   758	15	11	localIOException4	java.io.IOException
    //   777	56	11	localObject3	Object
    //   34	795	12	localObject4	Object
    //   37	790	13	localObject5	Object
    //   28	756	14	localObject6	Object
    //   31	546	15	localBitmap	android.graphics.Bitmap
    //   592	28	15	localException1	java.lang.Exception
    //   793	1	15	localException2	java.lang.Exception
    //   801	30	15	localException3	java.lang.Exception
    //   25	704	16	localq1	q
    //   217	292	17	localObject7	Object
    //   400	34	18	localStringBuilder	StringBuilder
    //   406	30	19	localq2	q
    // Exception table:
    //   from	to	target	type
    //   61	98	592	java/lang/Exception
    //   201	293	592	java/lang/Exception
    //   301	312	592	java/lang/Exception
    //   325	342	592	java/lang/Exception
    //   347	371	592	java/lang/Exception
    //   371	378	592	java/lang/Exception
    //   388	408	592	java/lang/Exception
    //   413	416	592	java/lang/Exception
    //   416	462	592	java/lang/Exception
    //   473	484	592	java/lang/Exception
    //   487	521	592	java/lang/Exception
    //   524	531	592	java/lang/Exception
    //   646	651	657	java/io/IOException
    //   61	98	665	finally
    //   201	293	665	finally
    //   301	312	665	finally
    //   325	342	665	finally
    //   347	371	665	finally
    //   371	378	665	finally
    //   388	408	665	finally
    //   413	416	665	finally
    //   416	462	665	finally
    //   473	484	665	finally
    //   487	521	665	finally
    //   524	531	665	finally
    //   114	119	744	java/io/IOException
    //   128	133	749	java/io/IOException
    //   636	641	758	java/io/IOException
    //   677	681	763	java/io/IOException
    //   686	691	767	java/io/IOException
    //   541	553	771	finally
    //   558	564	771	finally
    //   576	589	782	finally
    //   608	631	782	finally
    //   541	553	793	java/lang/Exception
    //   558	564	793	java/lang/Exception
    //   576	589	801	java/lang/Exception
  }
  
  public final String beB(String paramString)
  {
    AppMethodBeat.i(236082);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.ba((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(236082);
      return paramString;
    }
    localObject = com.tencent.mm.plugin.recordvideo.e.d.IeU;
    localObject = a(paramString, new q(com.tencent.mm.plugin.recordvideo.e.d.fzw()), 100);
    if ((u.agG((String)localObject)) && (u.bBQ((String)localObject) < u.bBQ(paramString)))
    {
      AppMethodBeat.o(236082);
      return localObject;
    }
    AppMethodBeat.o(236082);
    return paramString;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(al paramal) {}
    
    public final void run()
    {
      AppMethodBeat.i(234485);
      Object localObject1 = new StringBuilder("commit postInfo:");
      Object localObject3 = this.MEx;
      p.k(localObject3, "$this$print");
      Object localObject2 = new StringBuilder("TextStatusPostInfo[useDefaultBackground:").append(((al)localObject3).MFP).append(",uploadFilePath:").append(((al)localObject3).MFQ).append(",thumbPath:").append(((al)localObject3).thumbPath).append(",excludeUserNames:").append(((al)localObject3).MFO).append(",textStatusExtInfo:[");
      localObject3 = ((al)localObject3).MFN;
      p.j(localObject3, "textStatusExtInfo");
      Log.i("MicroMsg.TextStatus.UploadPackHelper", ((StringBuilder)localObject2).append(com.tencent.mm.plugin.textstatus.k.e.c((TextStatusExtInfo)localObject3)).append("]]").toString());
      if (this.MEx.MFT <= 0L)
      {
        localObject1 = com.tencent.mm.plugin.textstatus.b.f.MAm;
        localObject1 = com.tencent.mm.plugin.auth.a.a.crN();
        p.j(localObject1, "Account.username()");
        localObject2 = this.MEx.MEN;
        p.j(localObject2, "postInfo.text_status_id");
        localObject3 = this.MEx.MFN;
        p.j(localObject3, "postInfo.textStatusExtInfo");
        long l = com.tencent.mm.plugin.textstatus.b.f.a((String)localObject1, (String)localObject2, (TextStatusExtInfo)localObject3, 3, this.MEx.MFW);
        this.MEx.MFT = l;
        localObject1 = d.MEw;
        if (d.b(this.MEx)) {
          this.MEx.MFU = true;
        }
        localObject1 = c.MEt;
        c.a(this.MEx);
      }
      localObject1 = com.tencent.mm.plugin.textstatus.k.f.MOw;
      localObject1 = com.tencent.mm.plugin.auth.a.a.crN();
      p.j(localObject1, "Account.username()");
      localObject1 = com.tencent.mm.plugin.textstatus.k.f.lD("thumb", (String)localObject1);
      localObject2 = com.tencent.mm.plugin.textstatus.k.f.MOw;
      localObject2 = com.tencent.mm.plugin.auth.a.a.crN();
      p.j(localObject2, "Account.username()");
      localObject2 = com.tencent.mm.plugin.textstatus.k.f.lD("image", (String)localObject2);
      localObject3 = com.tencent.mm.plugin.textstatus.k.f.MOw;
      localObject3 = com.tencent.mm.plugin.auth.a.a.crN();
      p.j(localObject3, "Account.username()");
      localObject3 = com.tencent.mm.plugin.textstatus.k.f.beK((String)localObject3);
      if (!TextUtils.equals((CharSequence)this.MEx.thumbPath, (CharSequence)localObject1)) {
        u.deleteFile((String)localObject1);
      }
      if (!TextUtils.equals((CharSequence)this.MEx.MFQ, (CharSequence)localObject2)) {
        u.deleteFile((String)localObject2);
      }
      if (!TextUtils.equals((CharSequence)this.MEx.MFQ, (CharSequence)localObject3)) {
        u.deleteFile((String)localObject3);
      }
      localObject1 = d.MEw;
      if (d.b(this.MEx))
      {
        if (!this.MEx.MFP)
        {
          localObject1 = d.MEw;
          d.d(this.MEx);
        }
        new a(this.MEx).gmi();
        AppMethodBeat.o(234485);
        return;
      }
      localObject1 = d.MEw;
      d.d(this.MEx);
      localObject1 = new e(this.MEx);
      localObject2 = new e.b((e)localObject1, System.currentTimeMillis());
      localObject3 = b.MEq;
      localObject3 = ((e)localObject1).MDa.MFN;
      if (localObject3 != null) {}
      for (int i = ((TextStatusExtInfo)localObject3).mediaType;; i = 1)
      {
        b.a(i, ((e)localObject1).MDa.MFQ, ((e)localObject1).MDa.thumbPath, (b.a)localObject2);
        AppMethodBeat.o(234485);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.g.d
 * JD-Core Version:    0.7.0.1
 */