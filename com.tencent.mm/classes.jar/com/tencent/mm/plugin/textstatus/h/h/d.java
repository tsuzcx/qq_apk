package com.tencent.mm.plugin.textstatus.h.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/upload/UploadPackHelper;", "", "()V", "TAG", "", "THUMB_DEFAULT_SCALE", "", "commit", "", "postInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "compressBigBitmap", "oriPath", "compressBitmap", "destFile", "Lcom/tencent/mm/vfs/VFSFile;", "quality", "", "copyFile", "getSendThumbnailPath", "thumbnailPath", "tips", "animVisible", "isPostNow", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d Tod;
  
  static
  {
    AppMethodBeat.i(290684);
    Tod = new d();
    AppMethodBeat.o(290684);
  }
  
  private static boolean b(bg parambg)
  {
    AppMethodBeat.i(290648);
    s.u(parambg, "<this>");
    if (parambg.Tqk)
    {
      AppMethodBeat.o(290648);
      return true;
    }
    CharSequence localCharSequence = (CharSequence)parambg.Tqi.mediaThumbUrl;
    if ((localCharSequence == null) || (n.bp(localCharSequence)))
    {
      i = 1;
      if (i != 0) {
        break label98;
      }
      parambg = (CharSequence)parambg.Tqi.mediaUrl;
      if ((parambg != null) && (!n.bp(parambg))) {
        break label93;
      }
    }
    label93:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label98;
      }
      AppMethodBeat.o(290648);
      return true;
      i = 0;
      break;
    }
    label98:
    AppMethodBeat.o(290648);
    return false;
  }
  
  private final String beb(String paramString)
  {
    AppMethodBeat.i(290670);
    paramString = paramString + '_' + hashCode();
    AppMethodBeat.o(290670);
    return paramString;
  }
  
  public static void c(bg parambg)
  {
    AppMethodBeat.i(290656);
    s.u(parambg, "postInfo");
    h.ahAA.g(new d..ExternalSyntheticLambda0(parambg), "MicroMsg.TextStatus.UploadPackHelper");
    AppMethodBeat.o(290656);
  }
  
  private static void d(bg parambg)
  {
    AppMethodBeat.i(290665);
    Object localObject1 = parambg.Tqi;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label41;
      }
    }
    label41:
    Object localObject2;
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(290665);
        return;
        localObject1 = Integer.valueOf(((TextStatusExtInfo)localObject1).mediaType);
        break;
        if (((Integer)localObject1).intValue() == 1)
        {
          localObject1 = parambg.thumbPath;
          localObject2 = com.tencent.mm.plugin.textstatus.util.e.TAU;
          localObject2 = com.tencent.mm.plugin.auth.a.a.cUx();
          s.s(localObject2, "username()");
          y.O((String)localObject1, com.tencent.mm.plugin.textstatus.util.e.nl("thumb", (String)localObject2), false);
          parambg = parambg.Tql;
          localObject1 = com.tencent.mm.plugin.textstatus.util.e.TAU;
          localObject1 = com.tencent.mm.plugin.auth.a.a.cUx();
          s.s(localObject1, "username()");
          y.O(parambg, com.tencent.mm.plugin.textstatus.util.e.nl("image", (String)localObject1), false);
          AppMethodBeat.o(290665);
          return;
        }
      }
    }
    if (((Integer)localObject1).intValue() == 2)
    {
      localObject1 = parambg.thumbPath;
      localObject2 = com.tencent.mm.plugin.textstatus.util.e.TAU;
      localObject2 = com.tencent.mm.plugin.auth.a.a.cUx();
      s.s(localObject2, "username()");
      y.O((String)localObject1, com.tencent.mm.plugin.textstatus.util.e.nl("thumb", (String)localObject2), false);
      if (y.ZC(parambg.Tql))
      {
        parambg = parambg.Tql;
        localObject1 = com.tencent.mm.plugin.textstatus.util.e.TAU;
        localObject1 = com.tencent.mm.plugin.auth.a.a.cUx();
        s.s(localObject1, "username()");
        y.O(parambg, com.tencent.mm.plugin.textstatus.util.e.bek((String)localObject1), false);
      }
    }
    AppMethodBeat.o(290665);
  }
  
  private static final void e(bg parambg)
  {
    AppMethodBeat.i(290680);
    s.u(parambg, "$postInfo");
    s.u(parambg, "<this>");
    Object localObject1 = new StringBuilder("TextStatusPostInfo[useDefaultBackground:").append(parambg.Tqk).append(",uploadFilePath:").append(parambg.Tql).append(",thumbPath:").append(parambg.thumbPath).append(",excludeUserNames:").append(parambg.Tqj).append(",textStatusExtInfo:[");
    Object localObject2 = parambg.Tqi;
    s.s(localObject2, "textStatusExtInfo");
    Log.i("MicroMsg.TextStatus.UploadPackHelper", s.X("commit postInfo:", com.tencent.mm.plugin.textstatus.util.d.e((TextStatusExtInfo)localObject2) + "]]"));
    if (parambg.Tqo <= 0L)
    {
      localObject1 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      localObject1 = com.tencent.mm.plugin.auth.a.a.cUx();
      s.s(localObject1, "username()");
      localObject2 = parambg.ToK;
      s.s(localObject2, "postInfo.text_status_id");
      localObject3 = parambg.Tqi;
      s.s(localObject3, "postInfo.textStatusExtInfo");
      parambg.Tqo = com.tencent.mm.plugin.textstatus.b.f.a((String)localObject1, (String)localObject2, (TextStatusExtInfo)localObject3, 3, parambg.Tqr);
      if (b(parambg)) {
        parambg.Tqp = true;
      }
      localObject1 = c.Tob;
      c.a(parambg);
    }
    localObject1 = com.tencent.mm.plugin.textstatus.util.e.TAU;
    localObject1 = com.tencent.mm.plugin.auth.a.a.cUx();
    s.s(localObject1, "username()");
    localObject1 = com.tencent.mm.plugin.textstatus.util.e.nl("thumb", (String)localObject1);
    localObject2 = com.tencent.mm.plugin.textstatus.util.e.TAU;
    localObject2 = com.tencent.mm.plugin.auth.a.a.cUx();
    s.s(localObject2, "username()");
    localObject2 = com.tencent.mm.plugin.textstatus.util.e.nl("image", (String)localObject2);
    Object localObject3 = com.tencent.mm.plugin.textstatus.util.e.TAU;
    localObject3 = com.tencent.mm.plugin.auth.a.a.cUx();
    s.s(localObject3, "username()");
    localObject3 = com.tencent.mm.plugin.textstatus.util.e.bek((String)localObject3);
    if (!TextUtils.equals((CharSequence)parambg.thumbPath, (CharSequence)localObject1)) {
      y.deleteFile((String)localObject1);
    }
    if (!TextUtils.equals((CharSequence)parambg.Tql, (CharSequence)localObject2)) {
      y.deleteFile((String)localObject2);
    }
    if (!TextUtils.equals((CharSequence)parambg.Tql, (CharSequence)localObject3)) {
      y.deleteFile((String)localObject3);
    }
    if (b(parambg))
    {
      if (!parambg.Tqk) {
        d(parambg);
      }
      new a(parambg).hHS();
      AppMethodBeat.o(290680);
      return;
    }
    d(parambg);
    parambg = new e(parambg);
    localObject1 = new e.b(System.currentTimeMillis(), parambg);
    localObject2 = b.TnZ;
    localObject2 = parambg.TmA.Tqi;
    if (localObject2 == null) {}
    for (int i = 1;; i = ((TextStatusExtInfo)localObject2).mediaType)
    {
      b.a(i, parambg.TmA.Tql, parambg.TmA.thumbPath, (b.a)localObject1);
      AppMethodBeat.o(290680);
      return;
    }
  }
  
  /* Error */
  public final String a(String paramString, u paramu, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 337
    //   3: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 338
    //   10: invokestatic 72	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_2
    //   14: ldc_w 339
    //   17: invokestatic 72	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   20: new 341	com/tencent/mm/vfs/u
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 342	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   28: astore 16
    //   30: aconst_null
    //   31: astore 14
    //   33: aconst_null
    //   34: astore 15
    //   36: aconst_null
    //   37: astore 12
    //   39: aconst_null
    //   40: astore 13
    //   42: ldc 138
    //   44: ldc_w 344
    //   47: iconst_1
    //   48: anewarray 4	java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: aload 16
    //   55: invokevirtual 347	com/tencent/mm/vfs/u:length	()J
    //   58: invokestatic 352	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   61: aastore
    //   62: invokestatic 355	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: aload 16
    //   67: invokevirtual 347	com/tencent/mm/vfs/u:length	()J
    //   70: ldc2_w 356
    //   73: lcmp
    //   74: ifle +738 -> 812
    //   77: aload_2
    //   78: invokevirtual 361	com/tencent/mm/vfs/u:jKS	()Z
    //   81: ifeq +136 -> 217
    //   84: ldc 138
    //   86: ldc_w 363
    //   89: iconst_1
    //   90: anewarray 4	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: aload_2
    //   96: invokevirtual 367	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   99: invokestatic 373	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   102: aastore
    //   103: invokestatic 355	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: iconst_1
    //   107: istore 9
    //   109: aload 15
    //   111: astore 11
    //   113: aload 13
    //   115: astore 12
    //   117: aload 11
    //   119: ifnull +8 -> 127
    //   122: aload 11
    //   124: invokevirtual 378	java/io/InputStream:close	()V
    //   127: iload 9
    //   129: istore 10
    //   131: aload 12
    //   133: ifnull +12 -> 145
    //   136: aload 12
    //   138: invokevirtual 381	java/io/OutputStream:close	()V
    //   141: iload 9
    //   143: istore 10
    //   145: iload 10
    //   147: ifeq +536 -> 683
    //   150: ldc 138
    //   152: ldc_w 383
    //   155: iconst_4
    //   156: anewarray 4	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload_0
    //   162: aload_1
    //   163: invokespecial 385	com/tencent/mm/plugin/textstatus/h/h/d:beb	(Ljava/lang/String;)Ljava/lang/String;
    //   166: aastore
    //   167: dup
    //   168: iconst_1
    //   169: aload 16
    //   171: invokevirtual 347	com/tencent/mm/vfs/u:length	()J
    //   174: invokestatic 352	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   177: aastore
    //   178: dup
    //   179: iconst_2
    //   180: aload_2
    //   181: invokevirtual 347	com/tencent/mm/vfs/u:length	()J
    //   184: invokestatic 352	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   187: aastore
    //   188: dup
    //   189: iconst_3
    //   190: aload_2
    //   191: invokevirtual 367	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   194: invokestatic 373	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   197: aastore
    //   198: invokestatic 387	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   201: aload_2
    //   202: invokevirtual 367	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   205: invokestatic 373	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   208: astore_1
    //   209: ldc_w 337
    //   212: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: aload_1
    //   216: areturn
    //   217: invokestatic 393	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   220: invokestatic 399	com/tencent/mm/cd/a:getDensity	(Landroid/content/Context;)F
    //   223: fstore 4
    //   225: aload 16
    //   227: invokevirtual 367	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   230: invokestatic 373	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   233: invokestatic 405	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   236: astore 17
    //   238: ldc_w 406
    //   241: aload 17
    //   243: getfield 411	android/graphics/BitmapFactory$Options:outWidth	I
    //   246: i2f
    //   247: fload 4
    //   249: fmul
    //   250: fmul
    //   251: fstore 5
    //   253: ldc_w 406
    //   256: fload 4
    //   258: aload 17
    //   260: getfield 414	android/graphics/BitmapFactory$Options:outHeight	I
    //   263: i2f
    //   264: fmul
    //   265: fmul
    //   266: fstore 6
    //   268: invokestatic 418	com/tencent/mm/sdk/platformtools/MMApplicationContext:getResources	()Landroid/content/res/Resources;
    //   271: invokevirtual 424	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   274: astore 11
    //   276: fload 5
    //   278: aload 11
    //   280: getfield 429	android/util/DisplayMetrics:widthPixels	I
    //   283: i2f
    //   284: fcmpl
    //   285: ifge +15 -> 300
    //   288: fload 6
    //   290: aload 11
    //   292: getfield 432	android/util/DisplayMetrics:heightPixels	I
    //   295: i2f
    //   296: fcmpl
    //   297: iflt +508 -> 805
    //   300: fload 6
    //   302: fload 5
    //   304: fcmpl
    //   305: ifle +153 -> 458
    //   308: aload 11
    //   310: getfield 432	android/util/DisplayMetrics:heightPixels	I
    //   313: i2f
    //   314: fload 6
    //   316: fdiv
    //   317: fstore 4
    //   319: goto +507 -> 826
    //   322: aload 17
    //   324: ifnonnull +148 -> 472
    //   327: ldc_w 434
    //   330: astore 11
    //   332: ldc 138
    //   334: ldc_w 436
    //   337: iconst_1
    //   338: anewarray 4	java/lang/Object
    //   341: dup
    //   342: iconst_0
    //   343: aload 11
    //   345: aastore
    //   346: invokestatic 387	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   349: aload 17
    //   351: ifnull +157 -> 508
    //   354: aload 17
    //   356: getfield 411	android/graphics/BitmapFactory$Options:outWidth	I
    //   359: i2f
    //   360: fload 5
    //   362: fcmpl
    //   363: ifgt +15 -> 378
    //   366: aload 17
    //   368: getfield 414	android/graphics/BitmapFactory$Options:outHeight	I
    //   371: i2f
    //   372: fload 4
    //   374: fcmpl
    //   375: ifle +133 -> 508
    //   378: aload 16
    //   380: invokevirtual 367	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   383: invokestatic 373	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   386: astore 11
    //   388: fload 4
    //   390: f2i
    //   391: istore 7
    //   393: fload 5
    //   395: f2i
    //   396: istore 8
    //   398: getstatic 442	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   401: astore 17
    //   403: aload_2
    //   404: invokevirtual 446	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   407: astore 18
    //   409: aload 18
    //   411: invokestatic 450	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   414: aload 11
    //   416: iload 7
    //   418: iload 8
    //   420: aload 17
    //   422: iload_3
    //   423: aload 18
    //   425: invokevirtual 367	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   428: invokestatic 373	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   431: ldc_w 452
    //   434: invokestatic 243	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   437: aload_2
    //   438: invokevirtual 455	com/tencent/mm/vfs/u:getName	()Ljava/lang/String;
    //   441: iconst_1
    //   442: invokestatic 459	com/tencent/mm/sdk/platformtools/BitmapUtil:createThumbNail	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   445: istore 9
    //   447: aload 13
    //   449: astore 12
    //   451: aload 15
    //   453: astore 11
    //   455: goto -338 -> 117
    //   458: aload 11
    //   460: getfield 429	android/util/DisplayMetrics:widthPixels	I
    //   463: i2f
    //   464: fload 5
    //   466: fdiv
    //   467: fstore 4
    //   469: goto +357 -> 826
    //   472: new 104	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   479: aload 17
    //   481: getfield 411	android/graphics/BitmapFactory$Options:outWidth	I
    //   484: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   487: bipush 45
    //   489: invokevirtual 112	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   492: aload 17
    //   494: getfield 414	android/graphics/BitmapFactory$Options:outHeight	I
    //   497: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   500: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: astore 11
    //   505: goto -173 -> 332
    //   508: aload 16
    //   510: invokestatic 463	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   513: astore 11
    //   515: fload 5
    //   517: f2i
    //   518: istore 7
    //   520: fload 4
    //   522: f2i
    //   523: istore 8
    //   525: aload 11
    //   527: fconst_0
    //   528: iload 7
    //   530: iload 8
    //   532: invokestatic 467	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeStream	(Ljava/io/InputStream;FII)Landroid/graphics/Bitmap;
    //   535: astore 15
    //   537: aload 15
    //   539: ifnull +256 -> 795
    //   542: aload_2
    //   543: invokestatic 471	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   546: astore 13
    //   548: aload 13
    //   550: astore 12
    //   552: aload 12
    //   554: astore 14
    //   556: aload 11
    //   558: astore 13
    //   560: aload 15
    //   562: getstatic 442	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   565: iload_3
    //   566: aload 12
    //   568: invokevirtual 477	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   571: istore 9
    //   573: goto -456 -> 117
    //   576: astore 15
    //   578: aconst_null
    //   579: astore 12
    //   581: aconst_null
    //   582: astore 11
    //   584: aload 12
    //   586: astore 14
    //   588: aload 11
    //   590: astore 13
    //   592: ldc 138
    //   594: ldc_w 479
    //   597: iconst_1
    //   598: anewarray 4	java/lang/Object
    //   601: dup
    //   602: iconst_0
    //   603: aload 15
    //   605: checkcast 481	java/lang/Throwable
    //   608: invokestatic 487	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   611: aastore
    //   612: invokestatic 489	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   615: aload 11
    //   617: ifnull +8 -> 625
    //   620: aload 11
    //   622: invokevirtual 378	java/io/InputStream:close	()V
    //   625: aload 12
    //   627: ifnull +16 -> 643
    //   630: aload 12
    //   632: invokevirtual 381	java/io/OutputStream:close	()V
    //   635: iconst_0
    //   636: istore 10
    //   638: goto -493 -> 145
    //   641: astore 11
    //   643: iconst_0
    //   644: istore 10
    //   646: goto -501 -> 145
    //   649: astore_1
    //   650: aload 14
    //   652: astore_2
    //   653: aload 12
    //   655: astore 11
    //   657: aload_2
    //   658: ifnull +7 -> 665
    //   661: aload_2
    //   662: invokevirtual 378	java/io/InputStream:close	()V
    //   665: aload 11
    //   667: ifnull +8 -> 675
    //   670: aload 11
    //   672: invokevirtual 381	java/io/OutputStream:close	()V
    //   675: ldc_w 337
    //   678: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   681: aload_1
    //   682: athrow
    //   683: ldc 138
    //   685: ldc_w 491
    //   688: iconst_3
    //   689: anewarray 4	java/lang/Object
    //   692: dup
    //   693: iconst_0
    //   694: aload_0
    //   695: aload_1
    //   696: invokespecial 385	com/tencent/mm/plugin/textstatus/h/h/d:beb	(Ljava/lang/String;)Ljava/lang/String;
    //   699: aastore
    //   700: dup
    //   701: iconst_1
    //   702: aload 16
    //   704: invokevirtual 347	com/tencent/mm/vfs/u:length	()J
    //   707: invokestatic 352	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   710: aastore
    //   711: dup
    //   712: iconst_2
    //   713: aload 16
    //   715: invokevirtual 367	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   718: invokestatic 373	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   721: aastore
    //   722: invokestatic 387	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   725: ldc_w 337
    //   728: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   731: aload_1
    //   732: areturn
    //   733: astore 11
    //   735: goto -608 -> 127
    //   738: astore 11
    //   740: iload 9
    //   742: istore 10
    //   744: goto -599 -> 145
    //   747: astore 11
    //   749: goto -124 -> 625
    //   752: astore_2
    //   753: goto -88 -> 665
    //   756: astore_2
    //   757: goto -82 -> 675
    //   760: astore_1
    //   761: aload 11
    //   763: astore_2
    //   764: aload 12
    //   766: astore 11
    //   768: goto -111 -> 657
    //   771: astore_1
    //   772: aload 14
    //   774: astore 11
    //   776: aload 13
    //   778: astore_2
    //   779: goto -122 -> 657
    //   782: astore 15
    //   784: aconst_null
    //   785: astore 12
    //   787: goto -203 -> 584
    //   790: astore 15
    //   792: goto -208 -> 584
    //   795: iconst_0
    //   796: istore 9
    //   798: aload 13
    //   800: astore 12
    //   802: goto -685 -> 117
    //   805: fload 6
    //   807: fstore 4
    //   809: goto -487 -> 322
    //   812: iconst_0
    //   813: istore 9
    //   815: aload 13
    //   817: astore 12
    //   819: aload 15
    //   821: astore 11
    //   823: goto -706 -> 117
    //   826: fload 5
    //   828: fload 4
    //   830: fmul
    //   831: f2i
    //   832: i2f
    //   833: fstore 5
    //   835: fload 4
    //   837: fload 6
    //   839: fmul
    //   840: f2i
    //   841: i2f
    //   842: fstore 4
    //   844: goto -522 -> 322
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	847	0	this	d
    //   0	847	1	paramString	String
    //   0	847	2	paramu	u
    //   0	847	3	paramInt	int
    //   223	620	4	f1	float
    //   251	583	5	f2	float
    //   266	572	6	f3	float
    //   391	138	7	i	int
    //   396	135	8	j	int
    //   107	707	9	bool1	boolean
    //   129	614	10	bool2	boolean
    //   111	510	11	localObject1	Object
    //   641	1	11	localIOException1	java.io.IOException
    //   655	16	11	localObject2	Object
    //   733	1	11	localIOException2	java.io.IOException
    //   738	1	11	localIOException3	java.io.IOException
    //   747	15	11	localIOException4	java.io.IOException
    //   766	56	11	localObject3	Object
    //   37	781	12	localObject4	Object
    //   40	776	13	localObject5	Object
    //   31	742	14	localObject6	Object
    //   34	527	15	localBitmap	android.graphics.Bitmap
    //   576	28	15	localException1	java.lang.Exception
    //   782	1	15	localException2	java.lang.Exception
    //   790	30	15	localException3	java.lang.Exception
    //   28	686	16	localu1	u
    //   236	257	17	localObject7	Object
    //   407	17	18	localu2	u
    // Exception table:
    //   from	to	target	type
    //   65	106	576	java/lang/Exception
    //   217	300	576	java/lang/Exception
    //   308	319	576	java/lang/Exception
    //   332	349	576	java/lang/Exception
    //   354	378	576	java/lang/Exception
    //   378	388	576	java/lang/Exception
    //   398	447	576	java/lang/Exception
    //   458	469	576	java/lang/Exception
    //   472	505	576	java/lang/Exception
    //   508	515	576	java/lang/Exception
    //   630	635	641	java/io/IOException
    //   65	106	649	finally
    //   217	300	649	finally
    //   308	319	649	finally
    //   332	349	649	finally
    //   354	378	649	finally
    //   378	388	649	finally
    //   398	447	649	finally
    //   458	469	649	finally
    //   472	505	649	finally
    //   508	515	649	finally
    //   122	127	733	java/io/IOException
    //   136	141	738	java/io/IOException
    //   620	625	747	java/io/IOException
    //   661	665	752	java/io/IOException
    //   670	675	756	java/io/IOException
    //   525	537	760	finally
    //   542	548	760	finally
    //   560	573	771	finally
    //   592	615	771	finally
    //   525	537	782	java/lang/Exception
    //   542	548	782	java/lang/Exception
    //   560	573	790	java/lang/Exception
  }
  
  public final String bea(String paramString)
  {
    AppMethodBeat.i(290696);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(290696);
      return paramString;
    }
    localObject = com.tencent.mm.plugin.recordvideo.util.f.Obq;
    localObject = a(paramString, new u(com.tencent.mm.plugin.recordvideo.util.f.gLi()), 100);
    if ((y.ZC((String)localObject)) && (y.bEl((String)localObject) < y.bEl(paramString)))
    {
      AppMethodBeat.o(290696);
      return localObject;
    }
    AppMethodBeat.o(290696);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.h.d
 * JD-Core Version:    0.7.0.1
 */