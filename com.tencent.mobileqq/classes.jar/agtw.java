import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.helper.SpringHbHelper.1;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.helper.SpringHbHelper.2;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.EntryBgView;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbVideoView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class agtw
{
  public static volatile int a;
  private static volatile long jdField_a_of_type_Long;
  private static volatile agtw jdField_a_of_type_Agtw;
  public static volatile SpringHbVideoView a;
  public static volatile boolean a;
  public static volatile boolean b;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Runnable jdField_a_of_type_JavaLangRunnable = new SpringHbHelper.1(this);
  private Runnable b = new SpringHbHelper.2(this);
  
  public static agtw a()
  {
    if (jdField_a_of_type_Agtw == null) {}
    try
    {
      if (jdField_a_of_type_Agtw == null) {
        jdField_a_of_type_Agtw = new agtw();
      }
      return jdField_a_of_type_Agtw;
    }
    finally {}
  }
  
  /* Error */
  public static Bitmap a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 4
    //   12: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +37 -> 52
    //   18: ldc 47
    //   20: iconst_2
    //   21: new 49	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   28: ldc 52
    //   30: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_0
    //   34: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 58
    //   39: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload_1
    //   43: invokevirtual 61	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   46: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifeq +7 -> 63
    //   59: aconst_null
    //   60: astore_0
    //   61: aload_0
    //   62: areturn
    //   63: new 77	android/graphics/BitmapFactory$Options
    //   66: dup
    //   67: invokespecial 78	android/graphics/BitmapFactory$Options:<init>	()V
    //   70: astore 12
    //   72: aload 12
    //   74: iconst_1
    //   75: putfield 81	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   78: aload 12
    //   80: getstatic 87	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   83: putfield 90	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   86: invokestatic 96	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   89: invokevirtual 102	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   92: invokevirtual 108	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   95: getfield 114	android/util/DisplayMetrics:density	F
    //   98: fconst_2
    //   99: fcmpg
    //   100: ifge +9 -> 109
    //   103: aload 12
    //   105: iconst_2
    //   106: putfield 81	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   109: aload 11
    //   111: astore 5
    //   113: getstatic 118	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   116: ifnull +643 -> 759
    //   119: aload 11
    //   121: astore 5
    //   123: getstatic 118	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   126: aload_0
    //   127: invokevirtual 124	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   130: checkcast 126	android/graphics/Bitmap
    //   133: astore_3
    //   134: aload_3
    //   135: ifnull +21 -> 156
    //   138: aload_3
    //   139: astore 6
    //   141: aload 9
    //   143: astore 7
    //   145: aload 11
    //   147: astore 5
    //   149: aload_3
    //   150: invokevirtual 129	android/graphics/Bitmap:isRecycled	()Z
    //   153: ifeq +177 -> 330
    //   156: iload_1
    //   157: ifeq +142 -> 299
    //   160: aload_3
    //   161: astore 6
    //   163: aload 9
    //   165: astore 7
    //   167: aload 11
    //   169: astore 5
    //   171: invokestatic 133	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   174: invokevirtual 137	com/tencent/common/app/BaseApplicationImpl:getAssets	()Landroid/content/res/AssetManager;
    //   177: aload_0
    //   178: invokevirtual 143	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   181: astore 4
    //   183: aload_3
    //   184: astore 6
    //   186: aload 4
    //   188: astore 7
    //   190: aload 4
    //   192: astore 5
    //   194: aload 4
    //   196: aconst_null
    //   197: aload 12
    //   199: invokestatic 149	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   202: astore 9
    //   204: aload 9
    //   206: astore 8
    //   208: aload 4
    //   210: astore 10
    //   212: aload 9
    //   214: ifnull +65 -> 279
    //   217: aload 9
    //   219: astore 8
    //   221: aload 4
    //   223: astore 10
    //   225: aload 9
    //   227: astore 6
    //   229: aload 4
    //   231: astore 7
    //   233: aload 4
    //   235: astore 5
    //   237: aload 9
    //   239: astore_3
    //   240: getstatic 118	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   243: ifnull +36 -> 279
    //   246: aload 9
    //   248: astore 6
    //   250: aload 4
    //   252: astore 7
    //   254: aload 4
    //   256: astore 5
    //   258: aload 9
    //   260: astore_3
    //   261: getstatic 118	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   264: aload_0
    //   265: aload 9
    //   267: invokevirtual 153	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   270: pop
    //   271: aload 4
    //   273: astore 10
    //   275: aload 9
    //   277: astore 8
    //   279: aload 8
    //   281: astore_0
    //   282: aload 10
    //   284: ifnull -223 -> 61
    //   287: aload 10
    //   289: invokevirtual 158	java/io/InputStream:close	()V
    //   292: aload 8
    //   294: areturn
    //   295: astore_0
    //   296: aload 8
    //   298: areturn
    //   299: aload_3
    //   300: astore 6
    //   302: aload 9
    //   304: astore 7
    //   306: aload 11
    //   308: astore 5
    //   310: new 160	java/io/BufferedInputStream
    //   313: dup
    //   314: new 162	java/io/FileInputStream
    //   317: dup
    //   318: aload_0
    //   319: invokespecial 165	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   322: invokespecial 168	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   325: astore 4
    //   327: goto -144 -> 183
    //   330: aload_3
    //   331: astore 8
    //   333: aload 4
    //   335: astore 10
    //   337: aload_3
    //   338: astore 6
    //   340: aload 9
    //   342: astore 7
    //   344: aload 11
    //   346: astore 5
    //   348: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   351: ifeq -72 -> 279
    //   354: aload_3
    //   355: astore 6
    //   357: aload 9
    //   359: astore 7
    //   361: aload 11
    //   363: astore 5
    //   365: ldc 47
    //   367: iconst_2
    //   368: ldc 170
    //   370: iconst_1
    //   371: anewarray 4	java/lang/Object
    //   374: dup
    //   375: iconst_0
    //   376: aload_0
    //   377: aastore
    //   378: invokestatic 176	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   381: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   384: aload_3
    //   385: astore 8
    //   387: aload 4
    //   389: astore 10
    //   391: goto -112 -> 279
    //   394: astore_3
    //   395: aload 6
    //   397: astore 4
    //   399: aload 7
    //   401: astore 5
    //   403: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq +26 -> 432
    //   409: aload 7
    //   411: astore 5
    //   413: ldc 47
    //   415: iconst_2
    //   416: ldc 178
    //   418: iconst_1
    //   419: anewarray 4	java/lang/Object
    //   422: dup
    //   423: iconst_0
    //   424: aload_0
    //   425: aastore
    //   426: invokestatic 176	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   429: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: aload 7
    //   434: astore 5
    //   436: aload 12
    //   438: getfield 90	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   441: getstatic 184	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   444: if_acmpeq +21 -> 465
    //   447: aload 7
    //   449: astore 5
    //   451: aload 12
    //   453: getfield 81	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   456: istore_2
    //   457: aload 4
    //   459: astore_3
    //   460: iload_2
    //   461: iconst_1
    //   462: if_icmpne +117 -> 579
    //   465: aload 4
    //   467: astore 6
    //   469: aload 7
    //   471: astore 5
    //   473: aload 4
    //   475: astore 8
    //   477: aload 12
    //   479: iconst_2
    //   480: putfield 81	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   483: aload 4
    //   485: astore 6
    //   487: aload 7
    //   489: astore 5
    //   491: aload 4
    //   493: astore 8
    //   495: aload 12
    //   497: getstatic 87	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   500: putfield 90	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   503: aload 4
    //   505: astore 6
    //   507: aload 7
    //   509: astore 5
    //   511: aload 4
    //   513: astore 8
    //   515: aload 7
    //   517: aconst_null
    //   518: aload 12
    //   520: invokestatic 149	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   523: astore 4
    //   525: aload 4
    //   527: astore_3
    //   528: aload 4
    //   530: ifnull +49 -> 579
    //   533: aload 4
    //   535: astore_3
    //   536: aload 4
    //   538: astore 6
    //   540: aload 7
    //   542: astore 5
    //   544: aload 4
    //   546: astore 8
    //   548: getstatic 118	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   551: ifnull +28 -> 579
    //   554: aload 4
    //   556: astore 6
    //   558: aload 7
    //   560: astore 5
    //   562: aload 4
    //   564: astore 8
    //   566: getstatic 118	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   569: aload_0
    //   570: aload 4
    //   572: invokevirtual 153	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   575: pop
    //   576: aload 4
    //   578: astore_3
    //   579: aload_3
    //   580: astore_0
    //   581: aload 7
    //   583: ifnull -522 -> 61
    //   586: aload 7
    //   588: invokevirtual 158	java/io/InputStream:close	()V
    //   591: aload_3
    //   592: areturn
    //   593: astore_0
    //   594: aload_3
    //   595: areturn
    //   596: astore_3
    //   597: aload 7
    //   599: astore 5
    //   601: ldc 47
    //   603: iconst_1
    //   604: ldc 186
    //   606: iconst_1
    //   607: anewarray 4	java/lang/Object
    //   610: dup
    //   611: iconst_0
    //   612: aload_0
    //   613: aastore
    //   614: invokestatic 176	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   617: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   620: aload 6
    //   622: astore_3
    //   623: goto -44 -> 579
    //   626: astore_0
    //   627: aload 5
    //   629: ifnull +8 -> 637
    //   632: aload 5
    //   634: invokevirtual 158	java/io/InputStream:close	()V
    //   637: aload_0
    //   638: athrow
    //   639: astore_3
    //   640: aload 7
    //   642: astore 5
    //   644: ldc 47
    //   646: iconst_1
    //   647: ldc 188
    //   649: iconst_2
    //   650: anewarray 4	java/lang/Object
    //   653: dup
    //   654: iconst_0
    //   655: aload_0
    //   656: aastore
    //   657: dup
    //   658: iconst_1
    //   659: aload_3
    //   660: invokevirtual 191	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   663: aastore
    //   664: invokestatic 176	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   667: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   670: aload 8
    //   672: astore_3
    //   673: goto -94 -> 579
    //   676: astore 5
    //   678: aconst_null
    //   679: astore 4
    //   681: aconst_null
    //   682: astore_3
    //   683: ldc 47
    //   685: iconst_1
    //   686: ldc 193
    //   688: iconst_2
    //   689: anewarray 4	java/lang/Object
    //   692: dup
    //   693: iconst_0
    //   694: aload_0
    //   695: aastore
    //   696: dup
    //   697: iconst_1
    //   698: aload 5
    //   700: invokevirtual 191	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   703: aastore
    //   704: invokestatic 176	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   707: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   710: aload_3
    //   711: astore_0
    //   712: aload 4
    //   714: ifnull -653 -> 61
    //   717: aload 4
    //   719: invokevirtual 158	java/io/InputStream:close	()V
    //   722: aload_3
    //   723: areturn
    //   724: astore_0
    //   725: aload_3
    //   726: areturn
    //   727: astore_3
    //   728: goto -91 -> 637
    //   731: astore_0
    //   732: aload 4
    //   734: astore 5
    //   736: goto -109 -> 627
    //   739: astore 5
    //   741: aconst_null
    //   742: astore 4
    //   744: goto -61 -> 683
    //   747: astore 5
    //   749: goto -66 -> 683
    //   752: astore_3
    //   753: aconst_null
    //   754: astore 4
    //   756: goto -357 -> 399
    //   759: aconst_null
    //   760: astore_3
    //   761: goto -627 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	764	0	paramString	String
    //   0	764	1	paramBoolean	boolean
    //   456	7	2	i	int
    //   133	252	3	localBitmap1	Bitmap
    //   394	1	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   459	136	3	localObject1	Object
    //   596	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   622	1	3	localObject2	Object
    //   639	21	3	localException1	Exception
    //   672	54	3	localObject3	Object
    //   727	1	3	localException2	Exception
    //   752	1	3	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   760	1	3	localObject4	Object
    //   10	745	4	localObject5	Object
    //   111	532	5	localObject6	Object
    //   676	23	5	localException3	Exception
    //   734	1	5	localObject7	Object
    //   739	1	5	localException4	Exception
    //   747	1	5	localException5	Exception
    //   139	482	6	localObject8	Object
    //   4	637	7	localObject9	Object
    //   206	465	8	localObject10	Object
    //   1	357	9	localBitmap2	Bitmap
    //   210	180	10	localObject11	Object
    //   7	355	11	localObject12	Object
    //   70	449	12	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   287	292	295	java/lang/Exception
    //   149	156	394	java/lang/OutOfMemoryError
    //   171	183	394	java/lang/OutOfMemoryError
    //   194	204	394	java/lang/OutOfMemoryError
    //   240	246	394	java/lang/OutOfMemoryError
    //   261	271	394	java/lang/OutOfMemoryError
    //   310	327	394	java/lang/OutOfMemoryError
    //   348	354	394	java/lang/OutOfMemoryError
    //   365	384	394	java/lang/OutOfMemoryError
    //   586	591	593	java/lang/Exception
    //   477	483	596	java/lang/OutOfMemoryError
    //   495	503	596	java/lang/OutOfMemoryError
    //   515	525	596	java/lang/OutOfMemoryError
    //   548	554	596	java/lang/OutOfMemoryError
    //   566	576	596	java/lang/OutOfMemoryError
    //   113	119	626	finally
    //   123	134	626	finally
    //   149	156	626	finally
    //   171	183	626	finally
    //   194	204	626	finally
    //   240	246	626	finally
    //   261	271	626	finally
    //   310	327	626	finally
    //   348	354	626	finally
    //   365	384	626	finally
    //   403	409	626	finally
    //   413	432	626	finally
    //   436	447	626	finally
    //   451	457	626	finally
    //   477	483	626	finally
    //   495	503	626	finally
    //   515	525	626	finally
    //   548	554	626	finally
    //   566	576	626	finally
    //   601	620	626	finally
    //   644	670	626	finally
    //   477	483	639	java/lang/Exception
    //   495	503	639	java/lang/Exception
    //   515	525	639	java/lang/Exception
    //   548	554	639	java/lang/Exception
    //   566	576	639	java/lang/Exception
    //   113	119	676	java/lang/Exception
    //   123	134	676	java/lang/Exception
    //   717	722	724	java/lang/Exception
    //   632	637	727	java/lang/Exception
    //   683	710	731	finally
    //   149	156	739	java/lang/Exception
    //   171	183	739	java/lang/Exception
    //   310	327	739	java/lang/Exception
    //   348	354	739	java/lang/Exception
    //   365	384	739	java/lang/Exception
    //   194	204	747	java/lang/Exception
    //   240	246	747	java/lang/Exception
    //   261	271	747	java/lang/Exception
    //   113	119	752	java/lang/OutOfMemoryError
    //   123	134	752	java/lang/OutOfMemoryError
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    QLog.i("springHb_SpringHbHelper", 1, "startSpringWebView");
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("springHb_SpringHbHelper", 1, "webview url is empty");
      return;
    }
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), SpringHbTranslucentBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("injectrecommend", true);
    localIntent.putExtra("finish_animation_out_to_right", true);
    localIntent.putExtra("hide_left_button", paramBoolean);
    localIntent.putExtra("isFromFudaiEntry", "1");
    localIntent.setData(Uri.parse(paramString));
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    if ((paramContext instanceof Activity)) {
      ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
    }
    for (;;)
    {
      awcz.c(false);
      return;
      localIntent.setFlags(268435456);
      BaseApplicationImpl.getContext().startActivity(localIntent);
    }
  }
  
  private void a(ImageView paramImageView)
  {
    QLog.w("springHb_SpringHbHelper", 1, "startDefaultFrameAnimation");
    try
    {
      ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
      localLayoutParams.height = bajq.b(80.0F);
      localLayoutParams.width = bajq.b(85.0F);
      paramImageView.setLayoutParams(localLayoutParams);
      paramImageView.setImageResource(2130846357);
      paramImageView.setVisibility(0);
      paramImageView = (AnimationDrawable)paramImageView.getDrawable();
      paramImageView.setOneShot(false);
      paramImageView.start();
      paramImageView = ThreadManager.getUIHandler();
      paramImageView.removeCallbacks(this.b);
      paramImageView.postDelayed(this.b, 300L);
      return;
    }
    catch (Throwable paramImageView)
    {
      QLog.e("springHb_SpringHbHelper", 1, paramImageView, new Object[0]);
    }
  }
  
  public static void b()
  {
    jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView = null;
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringHbHelper", 1, "notifyWebViewPreAnimEnd");
    }
    Context localContext = null;
    try
    {
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        localContext = this.jdField_a_of_type_AndroidViewViewGroup.getContext();
      }
      Intent localIntent = new Intent("ACTION_LOADING_ANIM_PLAY_FINISH");
      Object localObject = localContext;
      if (localContext == null) {
        localObject = BaseApplicationImpl.getContext();
      }
      ((Context)localObject).sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("springHb_SpringHbHelper", 1, "notifyWebViewPreAnimEnd fail.", localException);
    }
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        QLog.i("springHb_SpringHbHelper", 1, "removeTransferAnimationChildView");
        a(this.jdField_a_of_type_AndroidViewViewGroup);
        this.jdField_a_of_type_AndroidViewViewGroup = null;
        return;
      }
      QLog.w("springHb_SpringHbHelper", 1, "removeTransferAnimationChildView but container is null");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("springHb_SpringHbHelper", 1, "removeTransferAnimationChildView fail.", localException);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {
      QLog.e("springHb_SpringHbHelper", 1, "container is null");
    }
    for (;;)
    {
      return;
      try
      {
        ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131311837);
        if (localViewGroup != null)
        {
          QLog.i("springHb_SpringHbHelper", 1, "removeLoadingView true");
          paramViewGroup.removeView(localViewGroup);
          ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          return;
        }
      }
      catch (Exception paramViewGroup)
      {
        QLog.e("springHb_SpringHbHelper", 1, paramViewGroup, new Object[] { "removeLoadingView error" });
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long > 60000L)
    {
      QLog.e("springHb_SpringHbHelper", 1, "nowCallTime =" + l + "gLastLoadToolsProcessTime =" + jdField_a_of_type_Long);
      jdField_a_of_type_Long = l;
      QLog.i("springHb_SpringHbHelper", 1, "preloadToolsProcessImpl running");
      Object localObject = null;
      if (paramQQAppInterface != null) {
        break label122;
      }
      paramQQAppInterface = localObject;
      if (BaseApplicationImpl.getApplication() != null)
      {
        paramQQAppInterface = localObject;
        if (BaseApplicationImpl.getApplication().getRuntime() == null) {}
      }
    }
    label122:
    for (paramQQAppInterface = (WebProcessManager)BaseApplicationImpl.getApplication().getRuntime().getManager(13);; paramQQAppInterface = (WebProcessManager)paramQQAppInterface.getManager(13))
    {
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(301);
      }
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, String paramString1, String paramString2, String paramString3, String paramString4, Bitmap paramBitmap)
  {
    for (;;)
    {
      try
      {
        QLog.i("springHb_SpringHbHelper", 1, "start webViewUrl=" + paramString1 + ",videoLocalPath=" + paramString3 + ",frameLocalPath=" + paramString4 + ",container:" + paramViewGroup);
        if (TextUtils.isEmpty(paramString1)) {
          return;
        }
        if (paramViewGroup == null) {
          break label467;
        }
        b(paramViewGroup);
        Object localObject = LayoutInflater.from(paramViewGroup.getContext());
        localContext = paramViewGroup.getContext();
        localViewGroup = (ViewGroup)((LayoutInflater)localObject).inflate(2131496066, null);
        if (localViewGroup == null) {
          break label467;
        }
        localViewGroup.setVisibility(0);
        boolean bool = false;
        if (paramQQAppInterface == null) {
          break label430;
        }
        long l1 = System.currentTimeMillis();
        bool = paramQQAppInterface.c();
        long l2 = System.currentTimeMillis();
        QLog.i("springHb_SpringHbHelper", 1, "run isVideoChatting cost=" + (l2 - l1));
        localBundle = new Bundle();
        if (bool) {
          break label442;
        }
        localObject = paramString3;
        if (paramString3 == null) {
          localObject = "";
        }
        localBundle.putString("videoPath", (String)localObject);
        paramString3 = null;
        if (paramQQAppInterface == null) {
          break label468;
        }
        paramString3 = paramQQAppInterface.getCurrentAccountUin();
      }
      catch (Exception paramQQAppInterface)
      {
        Context localContext;
        ViewGroup localViewGroup;
        Bundle localBundle;
        QLog.e("springHb_SpringHbHelper", 1, paramQQAppInterface, new Object[] { "@fudaiEntrance  gotoActiveMainPage error" });
        return;
      }
      localBundle.putString("uin", paramQQAppInterface);
      paramQQAppInterface = paramString2;
      if (paramString2 == null) {
        paramQQAppInterface = "";
      }
      localBundle.putString("entryId", paramQQAppInterface);
      localBundle.putInt("preAnimTimeout", 300);
      localBundle.putLong("startTime", System.currentTimeMillis());
      a(localContext, paramString1, -1, localBundle, false);
      paramViewGroup.addView(localViewGroup);
      paramQQAppInterface = ThreadManagerV2.getUIHandlerV2();
      paramQQAppInterface.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      paramQQAppInterface.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      paramQQAppInterface = (EntryBgView)localViewGroup.findViewById(2131301236);
      if (paramBitmap == null)
      {
        paramQQAppInterface.setBackgroundResource(2130846170);
        QLog.i("springHb_SpringHbHelper", 1, "gotoActiveMainPage ,bitmap is null,userDefault drawable:" + paramBitmap);
        paramQQAppInterface.setVisibility(0);
        paramQQAppInterface = (ImageView)localViewGroup.findViewById(2131301244);
        localViewGroup.setVisibility(0);
        if (TextUtils.isEmpty(paramString4)) {
          a(paramQQAppInterface);
        }
        agvs.a("sq.kcdx", 0, 0, null);
        return;
        label430:
        QLog.e("springHb_SpringHbHelper", 1, "app is null");
        continue;
        label442:
        QLog.i("springHb_SpringHbHelper", 1, "isVideoChatting");
      }
      else
      {
        paramQQAppInterface.setTargetView(this.jdField_a_of_type_AndroidViewViewGroup, paramBitmap);
        continue;
        label467:
        return;
        label468:
        paramQQAppInterface = paramString3;
        if (paramString3 == null) {
          paramQQAppInterface = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agtw
 * JD-Core Version:    0.7.0.1
 */