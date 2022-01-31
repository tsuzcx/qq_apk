package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vfs.e;

public final class a
{
  protected int mScreenHeight;
  protected int mScreenWidth;
  protected a.d rAQ;
  
  public a()
  {
    AppMethodBeat.i(145396);
    this.mScreenWidth = 720;
    this.mScreenHeight = 1280;
    try
    {
      int[] arrayOfInt = ae.eU(ah.getContext());
      if ((arrayOfInt[0] > 0) && (arrayOfInt[1] > 0))
      {
        this.mScreenWidth = Math.min(arrayOfInt[0], arrayOfInt[1]);
        this.mScreenHeight = Math.max(arrayOfInt[0], arrayOfInt[1]);
        ab.i("SphereImageView.SphereImageLoader", "screen.w=" + this.mScreenWidth + ", screen.h=" + this.mScreenHeight);
      }
      AppMethodBeat.o(145396);
      return;
    }
    catch (Exception localException)
    {
      ab.e("SphereImageView.SphereImageLoader", "init exp=" + localException.toString());
      AppMethodBeat.o(145396);
    }
  }
  
  public static void a(TextureView paramTextureView, String paramString1, String paramString2)
  {
    AppMethodBeat.i(145399);
    try
    {
      long l1 = System.currentTimeMillis();
      paramTextureView = paramTextureView.getBitmap();
      if ((paramTextureView == null) || (paramTextureView.getWidth() <= 0) || (paramTextureView.getHeight() <= 0) || (TextUtils.isEmpty(paramString1)))
      {
        ab.e("SphereImageView.SphereImageLoader", "saveSphereImageViewShootAsyn, params err");
        AppMethodBeat.o(145399);
        return;
      }
      new b(paramTextureView, paramString1, paramString2).execute(new Void[0]);
      long l2 = System.currentTimeMillis();
      ab.i("SphereImageView.SphereImageLoader", "saveSphereImageViewShootAsyn, timeCost=" + (l2 - l1));
      AppMethodBeat.o(145399);
      return;
    }
    catch (Throwable paramTextureView)
    {
      ab.e("SphereImageView.SphereImageLoader", "saveSphereImageViewShootAsyn, exp=" + paramTextureView.toString());
      AppMethodBeat.o(145399);
    }
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 149
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +24 -> 33
    //   12: ldc 60
    //   14: ldc 151
    //   16: aload_2
    //   17: invokestatic 157	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   20: invokevirtual 161	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokestatic 94	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: ldc 149
    //   28: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: iconst_0
    //   32: ireturn
    //   33: aload_0
    //   34: ifnull +17 -> 51
    //   37: aload_0
    //   38: invokevirtual 120	android/graphics/Bitmap:getHeight	()I
    //   41: ifle +10 -> 51
    //   44: aload_0
    //   45: invokevirtual 117	android/graphics/Bitmap:getWidth	()I
    //   48: ifgt +24 -> 72
    //   51: ldc 60
    //   53: ldc 163
    //   55: aload_2
    //   56: invokestatic 157	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   59: invokevirtual 161	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   62: invokestatic 94	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: ldc 149
    //   67: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: iconst_0
    //   71: ireturn
    //   72: aconst_null
    //   73: astore 13
    //   75: invokestatic 105	java/lang/System:currentTimeMillis	()J
    //   78: lstore 9
    //   80: aload_0
    //   81: ifnull +693 -> 774
    //   84: aload_0
    //   85: invokevirtual 117	android/graphics/Bitmap:getWidth	()I
    //   88: bipush 20
    //   90: if_icmplt +684 -> 774
    //   93: aload_0
    //   94: invokevirtual 120	android/graphics/Bitmap:getHeight	()I
    //   97: bipush 20
    //   99: if_icmpge +141 -> 240
    //   102: goto +672 -> 774
    //   105: iload_3
    //   106: ifeq +397 -> 503
    //   109: aload_2
    //   110: aload_1
    //   111: invokestatic 167	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a:gx	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   114: astore 14
    //   116: new 169	java/io/FileOutputStream
    //   119: dup
    //   120: new 171	java/io/File
    //   123: dup
    //   124: aload 14
    //   126: invokespecial 172	java/io/File:<init>	(Ljava/lang/String;)V
    //   129: invokespecial 175	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   132: astore_1
    //   133: aload_1
    //   134: astore 13
    //   136: aload_0
    //   137: getstatic 181	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   140: bipush 90
    //   142: aload_1
    //   143: invokevirtual 185	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   146: pop
    //   147: aload_1
    //   148: astore 13
    //   150: aload_1
    //   151: invokevirtual 190	java/io/OutputStream:flush	()V
    //   154: aload_1
    //   155: astore 13
    //   157: invokestatic 105	java/lang/System:currentTimeMillis	()J
    //   160: lstore 11
    //   162: aload_1
    //   163: astore 13
    //   165: ldc 60
    //   167: new 62	java/lang/StringBuilder
    //   170: dup
    //   171: ldc 192
    //   173: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   176: lload 11
    //   178: lload 9
    //   180: lsub
    //   181: invokevirtual 142	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   184: ldc 194
    //   186: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_0
    //   190: invokevirtual 117	android/graphics/Bitmap:getWidth	()I
    //   193: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: ldc 196
    //   198: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_0
    //   202: invokevirtual 120	android/graphics/Bitmap:getHeight	()I
    //   205: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: ldc 198
    //   210: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload 14
    //   215: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc 200
    //   220: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 85	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload_1
    //   230: invokevirtual 203	java/io/OutputStream:close	()V
    //   233: ldc 149
    //   235: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: iconst_1
    //   239: ireturn
    //   240: iconst_0
    //   241: istore_3
    //   242: aload_0
    //   243: invokevirtual 117	android/graphics/Bitmap:getWidth	()I
    //   246: istore 7
    //   248: aload_0
    //   249: invokevirtual 120	android/graphics/Bitmap:getHeight	()I
    //   252: istore 6
    //   254: iconst_0
    //   255: istore 4
    //   257: goto +522 -> 779
    //   260: iload 5
    //   262: bipush 10
    //   264: if_icmpge +528 -> 792
    //   267: iload_3
    //   268: aload_0
    //   269: iload 4
    //   271: iload 5
    //   273: invokevirtual 206	android/graphics/Bitmap:getPixel	(II)I
    //   276: ldc 207
    //   278: iand
    //   279: iadd
    //   280: istore_3
    //   281: iload 5
    //   283: iconst_1
    //   284: iadd
    //   285: istore 5
    //   287: goto -27 -> 260
    //   290: iload 5
    //   292: bipush 10
    //   294: if_icmpge +536 -> 830
    //   297: iload_3
    //   298: aload_0
    //   299: iload 4
    //   301: iload 5
    //   303: invokevirtual 206	android/graphics/Bitmap:getPixel	(II)I
    //   306: ldc 207
    //   308: iand
    //   309: iadd
    //   310: istore_3
    //   311: iload 5
    //   313: iconst_1
    //   314: iadd
    //   315: istore 5
    //   317: goto -27 -> 290
    //   320: iload 5
    //   322: iload 6
    //   324: if_icmpge +544 -> 868
    //   327: iload_3
    //   328: aload_0
    //   329: iload 4
    //   331: iload 5
    //   333: invokevirtual 206	android/graphics/Bitmap:getPixel	(II)I
    //   336: ldc 207
    //   338: iand
    //   339: iadd
    //   340: istore_3
    //   341: iload 5
    //   343: iconst_1
    //   344: iadd
    //   345: istore 5
    //   347: goto -27 -> 320
    //   350: iload 5
    //   352: iload 6
    //   354: if_icmpge +556 -> 910
    //   357: iload_3
    //   358: aload_0
    //   359: iload 4
    //   361: iload 5
    //   363: invokevirtual 206	android/graphics/Bitmap:getPixel	(II)I
    //   366: ldc 207
    //   368: iand
    //   369: iadd
    //   370: istore_3
    //   371: iload 5
    //   373: iconst_1
    //   374: iadd
    //   375: istore 5
    //   377: goto -27 -> 350
    //   380: iload 7
    //   382: iconst_2
    //   383: idiv
    //   384: istore 7
    //   386: iload 6
    //   388: iconst_2
    //   389: idiv
    //   390: istore 6
    //   392: iload 7
    //   394: iconst_5
    //   395: isub
    //   396: istore 4
    //   398: iload_3
    //   399: istore 5
    //   401: iload 4
    //   403: istore_3
    //   404: goto +524 -> 928
    //   407: iload 4
    //   409: iload 6
    //   411: iconst_5
    //   412: iadd
    //   413: if_icmpge +31 -> 444
    //   416: aload_0
    //   417: iload_3
    //   418: iload 4
    //   420: invokevirtual 206	android/graphics/Bitmap:getPixel	(II)I
    //   423: istore 8
    //   425: iload 5
    //   427: iload 8
    //   429: ldc 207
    //   431: iand
    //   432: iadd
    //   433: istore 5
    //   435: iload 4
    //   437: iconst_1
    //   438: iadd
    //   439: istore 4
    //   441: goto -34 -> 407
    //   444: iload_3
    //   445: iconst_1
    //   446: iadd
    //   447: istore_3
    //   448: goto +480 -> 928
    //   451: iload 5
    //   453: ifeq +8 -> 461
    //   456: iconst_1
    //   457: istore_3
    //   458: goto -353 -> 105
    //   461: iconst_0
    //   462: istore_3
    //   463: goto -358 -> 105
    //   466: astore_0
    //   467: ldc 60
    //   469: new 62	java/lang/StringBuilder
    //   472: dup
    //   473: ldc 209
    //   475: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   478: aload_0
    //   479: invokevirtual 91	java/lang/Exception:toString	()Ljava/lang/String;
    //   482: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: ldc 211
    //   487: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload_2
    //   491: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokestatic 94	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: goto -267 -> 233
    //   503: ldc 60
    //   505: ldc 213
    //   507: invokestatic 85	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   510: ldc 149
    //   512: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   515: iconst_0
    //   516: ireturn
    //   517: astore_1
    //   518: aload 13
    //   520: astore_0
    //   521: ldc 60
    //   523: new 62	java/lang/StringBuilder
    //   526: dup
    //   527: ldc 215
    //   529: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   532: aload_1
    //   533: invokevirtual 91	java/lang/Exception:toString	()Ljava/lang/String;
    //   536: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: ldc 211
    //   541: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: aload_2
    //   545: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   551: invokestatic 94	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   554: aload_0
    //   555: ifnull -45 -> 510
    //   558: aload_0
    //   559: invokevirtual 203	java/io/OutputStream:close	()V
    //   562: goto -52 -> 510
    //   565: astore_0
    //   566: ldc 60
    //   568: new 62	java/lang/StringBuilder
    //   571: dup
    //   572: ldc 209
    //   574: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   577: aload_0
    //   578: invokevirtual 91	java/lang/Exception:toString	()Ljava/lang/String;
    //   581: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: ldc 211
    //   586: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: aload_2
    //   590: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: invokestatic 94	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   599: goto -89 -> 510
    //   602: astore_0
    //   603: aconst_null
    //   604: astore_1
    //   605: aload_1
    //   606: astore 13
    //   608: ldc 60
    //   610: new 62	java/lang/StringBuilder
    //   613: dup
    //   614: ldc 217
    //   616: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   619: aload_0
    //   620: invokevirtual 218	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   623: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: ldc 211
    //   628: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: aload_2
    //   632: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: invokestatic 94	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   641: aload_1
    //   642: ifnull -132 -> 510
    //   645: aload_1
    //   646: invokevirtual 203	java/io/OutputStream:close	()V
    //   649: goto -139 -> 510
    //   652: astore_0
    //   653: ldc 60
    //   655: new 62	java/lang/StringBuilder
    //   658: dup
    //   659: ldc 209
    //   661: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   664: aload_0
    //   665: invokevirtual 91	java/lang/Exception:toString	()Ljava/lang/String;
    //   668: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: ldc 211
    //   673: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: aload_2
    //   677: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: invokestatic 94	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   686: goto -176 -> 510
    //   689: astore_0
    //   690: aconst_null
    //   691: astore 13
    //   693: aload 13
    //   695: ifnull +8 -> 703
    //   698: aload 13
    //   700: invokevirtual 203	java/io/OutputStream:close	()V
    //   703: ldc 149
    //   705: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   708: aload_0
    //   709: athrow
    //   710: astore_1
    //   711: ldc 60
    //   713: new 62	java/lang/StringBuilder
    //   716: dup
    //   717: ldc 209
    //   719: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   722: aload_1
    //   723: invokevirtual 91	java/lang/Exception:toString	()Ljava/lang/String;
    //   726: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: ldc 211
    //   731: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: aload_2
    //   735: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokestatic 94	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   744: goto -41 -> 703
    //   747: astore_0
    //   748: goto -55 -> 693
    //   751: astore_1
    //   752: aload_0
    //   753: astore 13
    //   755: aload_1
    //   756: astore_0
    //   757: goto -64 -> 693
    //   760: astore_0
    //   761: goto -156 -> 605
    //   764: astore 13
    //   766: aload_1
    //   767: astore_0
    //   768: aload 13
    //   770: astore_1
    //   771: goto -250 -> 521
    //   774: iconst_0
    //   775: istore_3
    //   776: goto -671 -> 105
    //   779: iload 4
    //   781: bipush 10
    //   783: if_icmpge +18 -> 801
    //   786: iconst_0
    //   787: istore 5
    //   789: goto -529 -> 260
    //   792: iload 4
    //   794: iconst_1
    //   795: iadd
    //   796: istore 4
    //   798: goto -19 -> 779
    //   801: iload_3
    //   802: ifeq +8 -> 810
    //   805: iconst_1
    //   806: istore_3
    //   807: goto -702 -> 105
    //   810: iload 7
    //   812: bipush 10
    //   814: isub
    //   815: istore 4
    //   817: iload 4
    //   819: iload 7
    //   821: if_icmpge +18 -> 839
    //   824: iconst_0
    //   825: istore 5
    //   827: goto -537 -> 290
    //   830: iload 4
    //   832: iconst_1
    //   833: iadd
    //   834: istore 4
    //   836: goto -19 -> 817
    //   839: iload_3
    //   840: ifeq +8 -> 848
    //   843: iconst_1
    //   844: istore_3
    //   845: goto -740 -> 105
    //   848: iconst_0
    //   849: istore 4
    //   851: iload 4
    //   853: bipush 10
    //   855: if_icmpge +22 -> 877
    //   858: iload 6
    //   860: bipush 10
    //   862: isub
    //   863: istore 5
    //   865: goto -545 -> 320
    //   868: iload 4
    //   870: iconst_1
    //   871: iadd
    //   872: istore 4
    //   874: goto -23 -> 851
    //   877: iload_3
    //   878: ifeq +8 -> 886
    //   881: iconst_1
    //   882: istore_3
    //   883: goto -778 -> 105
    //   886: iload 7
    //   888: bipush 10
    //   890: isub
    //   891: istore 4
    //   893: iload 4
    //   895: iload 7
    //   897: if_icmpge +22 -> 919
    //   900: iload 6
    //   902: bipush 10
    //   904: isub
    //   905: istore 5
    //   907: goto -557 -> 350
    //   910: iload 4
    //   912: iconst_1
    //   913: iadd
    //   914: istore 4
    //   916: goto -23 -> 893
    //   919: iload_3
    //   920: ifeq -540 -> 380
    //   923: iconst_1
    //   924: istore_3
    //   925: goto -820 -> 105
    //   928: iload_3
    //   929: iload 7
    //   931: iconst_5
    //   932: iadd
    //   933: if_icmpge -482 -> 451
    //   936: iload 6
    //   938: iconst_5
    //   939: isub
    //   940: istore 4
    //   942: goto -535 -> 407
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	945	0	paramBitmap	Bitmap
    //   0	945	1	paramString1	String
    //   0	945	2	paramString2	String
    //   105	829	3	i	int
    //   255	686	4	j	int
    //   260	646	5	k	int
    //   252	688	6	m	int
    //   246	687	7	n	int
    //   423	9	8	i1	int
    //   78	101	9	l1	long
    //   160	17	11	l2	long
    //   73	681	13	localObject	Object
    //   764	5	13	localException	Exception
    //   114	100	14	str	String
    // Exception table:
    //   from	to	target	type
    //   229	233	466	java/lang/Exception
    //   75	80	517	java/lang/Exception
    //   84	102	517	java/lang/Exception
    //   109	133	517	java/lang/Exception
    //   242	254	517	java/lang/Exception
    //   267	281	517	java/lang/Exception
    //   297	311	517	java/lang/Exception
    //   327	341	517	java/lang/Exception
    //   357	371	517	java/lang/Exception
    //   380	392	517	java/lang/Exception
    //   416	425	517	java/lang/Exception
    //   503	510	517	java/lang/Exception
    //   558	562	565	java/lang/Exception
    //   75	80	602	java/lang/OutOfMemoryError
    //   84	102	602	java/lang/OutOfMemoryError
    //   109	133	602	java/lang/OutOfMemoryError
    //   242	254	602	java/lang/OutOfMemoryError
    //   267	281	602	java/lang/OutOfMemoryError
    //   297	311	602	java/lang/OutOfMemoryError
    //   327	341	602	java/lang/OutOfMemoryError
    //   357	371	602	java/lang/OutOfMemoryError
    //   380	392	602	java/lang/OutOfMemoryError
    //   416	425	602	java/lang/OutOfMemoryError
    //   503	510	602	java/lang/OutOfMemoryError
    //   645	649	652	java/lang/Exception
    //   75	80	689	finally
    //   84	102	689	finally
    //   109	133	689	finally
    //   242	254	689	finally
    //   267	281	689	finally
    //   297	311	689	finally
    //   327	341	689	finally
    //   357	371	689	finally
    //   380	392	689	finally
    //   416	425	689	finally
    //   503	510	689	finally
    //   698	703	710	java/lang/Exception
    //   136	147	747	finally
    //   150	154	747	finally
    //   157	162	747	finally
    //   165	229	747	finally
    //   608	641	747	finally
    //   521	554	751	finally
    //   136	147	760	java/lang/OutOfMemoryError
    //   150	154	760	java/lang/OutOfMemoryError
    //   157	162	760	java/lang/OutOfMemoryError
    //   165	229	760	java/lang/OutOfMemoryError
    //   136	147	764	java/lang/Exception
    //   150	154	764	java/lang/Exception
    //   157	162	764	java/lang/Exception
    //   165	229	764	java/lang/Exception
  }
  
  private static String abo(String paramString)
  {
    AppMethodBeat.i(145398);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(145398);
      return null;
    }
    try
    {
      paramString = h.gy("adId", paramString);
      if (!TextUtils.isEmpty(paramString))
      {
        boolean bool = e.cN(paramString);
        if (bool)
        {
          AppMethodBeat.o(145398);
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      ab.e("SphereImageView.SphereImageLoader", "getImgCacheFilePath, exp:" + paramString.toString());
      AppMethodBeat.o(145398);
    }
    return "";
  }
  
  public static Bitmap gv(String paramString1, String paramString2)
  {
    boolean bool = false;
    AppMethodBeat.i(145401);
    if (TextUtils.isEmpty(paramString1))
    {
      ab.e("SphereImageView.SphereImageLoader", "getSphereImageViewFrameShot, imageUrl is empty, scene=".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(145401);
      return null;
    }
    for (;;)
    {
      try
      {
        paramString1 = gx(paramString2, paramString1);
        if ((TextUtils.isEmpty(paramString1)) || (!e.cN(paramString1))) {
          continue;
        }
        l1 = System.currentTimeMillis();
        localBitmap = MMBitmapFactory.decodeFile(paramString1);
        l2 = System.currentTimeMillis();
        if (localBitmap != null) {
          continue;
        }
        i = 0;
      }
      catch (Exception paramString1)
      {
        long l1;
        long l2;
        int i;
        StringBuilder localStringBuilder;
        ab.e("SphereImageView.SphereImageLoader", "getSphereImageViewFrameShot, exp:" + paramString1.toString() + ", scene=" + paramString2);
        continue;
      }
      catch (OutOfMemoryError paramString1)
      {
        Bitmap localBitmap;
        ab.e("SphereImageView.SphereImageLoader", "getSphereImageViewFrameShot, OOM:" + paramString1.toString() + ", scene=" + paramString2);
        continue;
        if (localBitmap != null) {
          continue;
        }
        int j = 0;
        continue;
      }
      localStringBuilder = new StringBuilder("getSphereImageViewFrameShot, timeCost=").append(l2 - l1).append(", bmp==null?");
      if (localBitmap == null) {
        bool = true;
      }
      ab.i("SphereImageView.SphereImageLoader", bool + ", w=" + i + ", h=" + j + ", path=" + paramString1);
      AppMethodBeat.o(145401);
      return localBitmap;
      i = localBitmap.getWidth();
      continue;
      j = localBitmap.getHeight();
    }
    ab.e("SphereImageView.SphereImageLoader", "getSphereImageViewFrameShot, file not exists, scene=" + paramString2 + ", path=" + paramString1);
    AppMethodBeat.o(145401);
    return null;
  }
  
  public static boolean gw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145402);
    if (TextUtils.isEmpty(paramString1))
    {
      ab.e("SphereImageView.SphereImageLoader", "hasSphereImageViewFrameShot, imageUrl is empty, scene=".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(145402);
      return false;
    }
    try
    {
      paramString1 = gx(paramString2, paramString1);
      if ((!TextUtils.isEmpty(paramString1)) && (e.cN(paramString1))) {}
      for (boolean bool = true;; bool = false)
      {
        ab.i("SphereImageView.SphereImageLoader", "hasSphereImageViewFrameShot, ret=" + bool + ", scene=" + paramString2);
        AppMethodBeat.o(145402);
        return bool;
      }
      return false;
    }
    catch (Exception paramString1)
    {
      ab.e("SphereImageView.SphereImageLoader", "hasSphereImageViewFrameShot, exp:" + paramString1.toString() + ", scene=" + paramString2);
      AppMethodBeat.o(145402);
    }
  }
  
  private static String gx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(154477);
    paramString1 = h.gy("sphere_shot_".concat(String.valueOf(paramString1)), paramString2);
    AppMethodBeat.o(154477);
    return paramString1;
  }
  
  public final void a(a.d paramd)
  {
    this.rAQ = paramd;
  }
  
  public final void j(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(145397);
    ab.i("SphereImageView.SphereImageLoader", "loadImage, view.w=" + paramInt1 + ", view.h=" + paramInt2 + ", scene=" + paramString2);
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(145397);
      return;
    }
    if (this.rAQ != null) {
      this.rAQ.onStart(paramString1);
    }
    String str = abo(paramString1);
    if (!TextUtils.isEmpty(str))
    {
      ab.i("SphereImageView.SphereImageLoader", "hit disk cache, path=".concat(String.valueOf(str)));
      new a(paramString1, paramInt1, paramInt2, paramString2).execute(new String[] { str });
      AppMethodBeat.o(145397);
      return;
    }
    ab.i("SphereImageView.SphereImageLoader", "no cache, download");
    h.a(paramString1, 133, new a.1(this, paramString1, paramInt1, paramInt2, paramString2));
    AppMethodBeat.o(145397);
  }
  
  protected final class a
    extends AsyncTask<String, Void, Bitmap>
  {
    String bFT = "";
    String bSd;
    int rAU;
    int rAV;
    String url;
    
    public a(String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      this.url = paramString1;
      this.rAU = paramInt1;
      this.rAV = paramInt2;
      this.bSd = paramString2;
    }
    
    private Bitmap E(String... paramVarArgs)
    {
      int n = 1;
      int m = 1;
      int k = 0;
      AppMethodBeat.i(145389);
      if ((paramVarArgs == null) || (paramVarArgs.length == 0) || (TextUtils.isEmpty(paramVarArgs[0])))
      {
        ab.e("SphereImageView.SphereImageLoader", "ImageDecodeTask run, path is empty");
        this.bFT = "path is empty";
        AppMethodBeat.o(145389);
        return null;
      }
      localStringBuilder = null;
      long l1 = System.currentTimeMillis();
      str = paramVarArgs[0];
      j = n;
      for (;;)
      {
        try
        {
          paramVarArgs = new BitmapFactory.Options();
          j = n;
          paramVarArgs.inJustDecodeBounds = true;
          j = n;
          MMBitmapFactory.decodeFile(str, paramVarArgs);
          j = n;
          i1 = paramVarArgs.outWidth;
          j = n;
          i2 = paramVarArgs.outHeight;
          j = n;
          if ("scene_ad_landing" != this.bSd) {
            continue;
          }
          i = m;
          if (i1 >= 4000)
          {
            i = m;
            j = n;
            if (a.this.mScreenWidth < 1080) {
              i = 2;
            }
          }
        }
        catch (Exception paramVarArgs)
        {
          int i1;
          int i2;
          long l2;
          this.bFT = paramVarArgs.toString();
          ab.e("SphereImageView.SphereImageLoader", "ImageDecodeTask, exp:" + this.bFT);
          paramVarArgs = localStringBuilder;
          continue;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          this.bFT = localOutOfMemoryError.toString();
          ab.e("SphereImageView.SphereImageLoader", "ImageDecodeTask, oom:" + this.bFT);
          try
          {
            ab.i("SphereImageView.SphereImageLoader", "ImageDecodeTask, try again after oom");
            System.gc();
            paramVarArgs = new BitmapFactory.Options();
            paramVarArgs.inSampleSize = (j + 1);
            paramVarArgs = MMBitmapFactory.decodeFile(str, paramVarArgs);
          }
          catch (Throwable paramVarArgs)
          {
            this.bFT = localOutOfMemoryError.toString();
            ab.e("SphereImageView.SphereImageLoader", "ImageDecodeTask, try again exp:" + this.bFT);
            paramVarArgs = localStringBuilder;
          }
          continue;
          int i = paramVarArgs.getWidth();
          continue;
          i = paramVarArgs.getHeight();
          continue;
          i = 4;
          continue;
        }
        j = i;
        ab.i("SphereImageView.SphereImageLoader", "decode, bmp.w=" + i1 + ", bmp.h=" + i2 + ", screen.w=" + a.this.mScreenWidth + ", screen.h=" + a.this.mScreenHeight + ", view.w=" + this.rAU + ", view.h=" + this.rAV + ", inSampleSize=" + i);
        j = i;
        paramVarArgs.inJustDecodeBounds = false;
        j = i;
        paramVarArgs.inSampleSize = i;
        j = i;
        paramVarArgs = MMBitmapFactory.decodeFile(str, paramVarArgs);
        l2 = System.currentTimeMillis();
        localStringBuilder = new StringBuilder("ImageDecodeTask end, totalTime=").append(l2 - l1).append(", bmp.w=");
        if (paramVarArgs != null) {
          continue;
        }
        i = 0;
        localStringBuilder = localStringBuilder.append(i).append(", bmp.h=");
        if (paramVarArgs != null) {
          continue;
        }
        i = k;
        ab.i("SphereImageView.SphereImageLoader", i + ", path=" + str);
        AppMethodBeat.o(145389);
        return paramVarArgs;
        i = m;
        j = n;
        if ("scene_timeline" == this.bSd) {
          if (i1 >= 4000)
          {
            j = n;
            if (a.this.mScreenWidth < 1080) {
              continue;
            }
            i = 2;
          }
          else
          {
            i = m;
            if (i1 >= 2000)
            {
              j = n;
              n = a.this.mScreenWidth;
              i = m;
              if (n < 1080) {
                i = 2;
              }
            }
          }
        }
      }
    }
  }
  
  protected static final class b
    extends AsyncTask<Void, Void, Void>
  {
    String bSd;
    Bitmap bitmap;
    String ffp;
    
    public b(Bitmap paramBitmap, String paramString1, String paramString2)
    {
      this.bitmap = paramBitmap;
      this.ffp = paramString1;
      this.bSd = paramString2;
    }
  }
  
  public static final class c
    extends AsyncTask<Void, Void, Bitmap>
  {
    String bSd;
    String ffp;
    a.d rAW;
    String thumbUrl;
    
    public c(String paramString1, String paramString2, String paramString3, a.d paramd)
    {
      this.ffp = paramString1;
      this.thumbUrl = paramString2;
      this.bSd = paramString3;
      this.rAW = paramd;
    }
    
    private Bitmap lq()
    {
      AppMethodBeat.i(145393);
      Bitmap localBitmap = a.gv(this.ffp, this.bSd);
      Object localObject;
      if (localBitmap != null)
      {
        ab.i("SphereImageView.SphereImageLoader", "has shot");
        localObject = localBitmap;
      }
      for (;;)
      {
        AppMethodBeat.o(145393);
        return localObject;
        localObject = localBitmap;
        try
        {
          if (TextUtils.isEmpty(this.thumbUrl)) {
            break label109;
          }
          localObject = localBitmap;
          localBitmap = h.gB("adId", this.thumbUrl);
          localObject = localBitmap;
          if (localBitmap == null) {
            continue;
          }
          localObject = localBitmap;
          ab.i("SphereImageView.SphereImageLoader", "has cache thumb");
          localObject = localBitmap;
        }
        catch (Throwable localThrowable)
        {
          ab.e("SphereImageView.SphereImageLoader", "getCachedImg exp:" + localThrowable.toString());
        }
        continue;
        label109:
        localObject = localThrowable;
        ab.e("SphereImageView.SphereImageLoader", "thumbUrl is empty");
        localObject = localThrowable;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a
 * JD-Core Version:    0.7.0.1
 */