import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.DIYThemeUtils;
import com.tencent.mobileqq.theme.diy.ResData;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.theme.diy.ThemeDiyStyleLogic;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class acur
{
  public ColorStateList a;
  public Drawable a;
  public String a;
  public boolean a;
  
  public static int a(Bitmap paramBitmap)
  {
    int i = 0;
    if (paramBitmap != null)
    {
      int j = paramBitmap.getWidth();
      int n = paramBitmap.getHeight();
      int[] arrayOfInt = new int[n];
      paramBitmap.getPixels(arrayOfInt, 0, 1, j / 2, 0, 1, n);
      j = 0;
      int k = 0;
      int m = 0;
      while (i < n)
      {
        int i1 = arrayOfInt[i];
        m += Color.red(i1);
        k += Color.green(i1);
        j += Color.blue(i1);
        i += 1;
      }
      if ((j + (m + k)) / n / 3 > 220) {
        return -10395552;
      }
      return -1;
    }
    return -10395552;
  }
  
  public static SharedPreferences a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("chat_background_path_" + paramString, paramInt);
    if (akvt.a("QQThemeChatBackgroundMigration", paramString) < 1)
    {
      SharedPreferences.Editor localEditor = paramContext.edit();
      QLog.d("DiySecureFileHelper", 1, "Move Chatbackground SharedPreferences");
      int i;
      if (paramContext.getAll() != null)
      {
        Iterator localIterator = paramContext.getAll().entrySet().iterator();
        paramInt = 0;
        i = paramInt;
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          String str;
          if ((localEntry.getValue() instanceof String))
          {
            str = (String)localEntry.getValue();
            i = paramInt;
            if (str != null)
            {
              i = paramInt;
              if (str.contains("/custom_background/" + paramString + "/"))
              {
                localEditor.putString((String)localEntry.getKey(), str.replace("/custom_background/" + paramString + "/", "/custom_background/" + akvt.a(paramString) + "/"));
                i = 1;
              }
            }
            paramInt = i;
            if (str == null) {
              break label716;
            }
            paramInt = i;
            if (!str.contains("/" + paramString + "/custom_background/")) {
              break label716;
            }
            localEditor.putString((String)localEntry.getKey(), str.replace("/" + paramString + "/custom_background/", "/custom_background/" + akvt.a(paramString) + "/"));
            paramInt = 1;
          }
          label647:
          label683:
          label716:
          for (;;)
          {
            break;
            str = (String)localEntry.getKey();
            i = paramInt;
            if (str != null)
            {
              i = paramInt;
              if (str.contains("/custom_background/" + paramString + "/"))
              {
                if (!(localEntry.getValue() instanceof Integer)) {
                  break label647;
                }
                localEditor.putInt(str.replace("/custom_background/" + paramString + "/", "/custom_background/" + akvt.a(paramString) + "/"), ((Integer)localEntry.getValue()).intValue());
              }
            }
            for (i = 1;; i = paramInt)
            {
              paramInt = i;
              if (str == null) {
                break label716;
              }
              paramInt = i;
              if (!str.contains("/" + paramString + "/custom_background/")) {
                break label716;
              }
              if (!(localEntry.getValue() instanceof Integer)) {
                break label683;
              }
              localEditor.putInt(str.replace("/" + paramString + "/custom_background/", "/custom_background/" + akvt.a(paramString) + "/"), ((Integer)localEntry.getValue()).intValue());
              paramInt = 1;
              break;
              QLog.e("DiySecureFileHelper", 1, "value not int : " + localEntry.getValue());
            }
            QLog.e("DiySecureFileHelper", 1, "value not int : " + localEntry.getValue());
            paramInt = i;
          }
        }
      }
      else
      {
        QLog.e("DiySecureFileHelper", 1, "sf.getAll is null");
        i = 0;
      }
      if (i != 0) {
        localEditor.commit();
      }
      akvt.a("QQThemeChatBackgroundMigration", paramString, 1);
    }
    return paramContext;
  }
  
  private static ColorStateList a(SharedPreferences paramSharedPreferences, String paramString, Bitmap paramBitmap)
  {
    paramString = "chat_backgournd_nickname_color." + paramString;
    if (paramSharedPreferences.contains(paramString)) {
      return ColorStateList.valueOf(paramSharedPreferences.getInt(paramString, -10395552));
    }
    int i = a(paramBitmap);
    paramSharedPreferences.edit().putInt(paramString, i).commit();
    return ColorStateList.valueOf(i);
  }
  
  /* Error */
  @android.support.annotation.Nullable
  private static Bitmap a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 190	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 191	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore 6
    //   9: ldc 193
    //   11: getstatic 198	android/os/Build:BRAND	Ljava/lang/String;
    //   14: invokevirtual 201	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   17: ifeq +469 -> 486
    //   20: aload 6
    //   22: getstatic 207	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   25: putfield 210	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   28: aload 6
    //   30: iconst_1
    //   31: putfield 213	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   34: aload 6
    //   36: iconst_1
    //   37: putfield 217	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   40: aload 6
    //   42: iconst_0
    //   43: putfield 213	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   46: aload_1
    //   47: aload 6
    //   49: invokestatic 222	baxi:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lbaxj;
    //   52: astore 5
    //   54: aload 5
    //   56: getfield 227	baxj:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   59: astore 4
    //   61: aload 4
    //   63: ifnull +11 -> 74
    //   66: aload 5
    //   68: getfield 229	baxj:jdField_a_of_type_Int	I
    //   71: ifeq +431 -> 502
    //   74: new 44	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   81: ldc 231
    //   83: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_1
    //   87: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc 233
    //   92: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: astore 7
    //   97: aload 4
    //   99: ifnonnull +398 -> 497
    //   102: iconst_1
    //   103: istore_3
    //   104: ldc 235
    //   106: iconst_1
    //   107: aload 7
    //   109: iload_3
    //   110: invokevirtual 238	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   113: ldc 240
    //   115: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload 6
    //   120: getfield 217	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   123: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: new 245	java/util/HashMap
    //   135: dup
    //   136: invokespecial 246	java/util/HashMap:<init>	()V
    //   139: astore 7
    //   141: aload 7
    //   143: ldc 248
    //   145: new 44	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   152: ldc 250
    //   154: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload 5
    //   159: getfield 229	baxj:jdField_a_of_type_Int	I
    //   162: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokevirtual 254	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   171: pop
    //   172: aload 7
    //   174: ldc_w 256
    //   177: invokestatic 261	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   180: invokevirtual 254	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   183: pop
    //   184: aload_0
    //   185: invokestatic 266	axrn:a	(Landroid/content/Context;)Laxrn;
    //   188: astore 8
    //   190: getstatic 272	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   193: invokevirtual 276	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   196: checkcast 278	com/tencent/mobileqq/app/QQAppInterface
    //   199: invokevirtual 281	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   202: astore 9
    //   204: aload 4
    //   206: ifnull +354 -> 560
    //   209: iconst_1
    //   210: istore_3
    //   211: aload 8
    //   213: aload 9
    //   215: ldc_w 283
    //   218: iload_3
    //   219: lconst_1
    //   220: lconst_0
    //   221: aload 7
    //   223: ldc_w 285
    //   226: iconst_0
    //   227: invokevirtual 288	axrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   230: aload 5
    //   232: getfield 229	baxj:jdField_a_of_type_Int	I
    //   235: iconst_1
    //   236: if_icmpne +355 -> 591
    //   239: ldc 235
    //   241: iconst_1
    //   242: new 44	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   249: ldc_w 290
    //   252: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_1
    //   256: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: aload 6
    //   267: getfield 217	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   270: iconst_2
    //   271: imul
    //   272: istore_2
    //   273: iload_2
    //   274: bipush 32
    //   276: if_icmpgt +114 -> 390
    //   279: aload 6
    //   281: iload_2
    //   282: putfield 217	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   285: aload_1
    //   286: aload 6
    //   288: invokestatic 222	baxi:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lbaxj;
    //   291: astore 5
    //   293: aload 5
    //   295: getfield 227	baxj:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   298: astore 4
    //   300: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifne +8 -> 311
    //   306: aload 4
    //   308: ifnonnull +73 -> 381
    //   311: new 44	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   318: ldc_w 295
    //   321: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: aload 5
    //   326: getfield 229	baxj:jdField_a_of_type_Int	I
    //   329: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: ldc_w 297
    //   335: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload_1
    //   339: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: ldc_w 299
    //   345: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: iload_2
    //   349: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   352: ldc 233
    //   354: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: astore 7
    //   359: aload 4
    //   361: ifnull +204 -> 565
    //   364: iconst_1
    //   365: istore_3
    //   366: ldc 235
    //   368: iconst_2
    //   369: aload 7
    //   371: iload_3
    //   372: invokevirtual 238	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   375: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: aload 5
    //   383: getfield 229	baxj:jdField_a_of_type_Int	I
    //   386: iconst_1
    //   387: if_icmpeq +183 -> 570
    //   390: new 245	java/util/HashMap
    //   393: dup
    //   394: invokespecial 246	java/util/HashMap:<init>	()V
    //   397: astore_1
    //   398: aload_1
    //   399: ldc 248
    //   401: new 44	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   408: ldc_w 301
    //   411: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload 5
    //   416: getfield 229	baxj:jdField_a_of_type_Int	I
    //   419: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   422: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokevirtual 254	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   428: pop
    //   429: aload_1
    //   430: ldc_w 256
    //   433: invokestatic 261	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   436: invokevirtual 254	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   439: pop
    //   440: aload_0
    //   441: invokestatic 266	axrn:a	(Landroid/content/Context;)Laxrn;
    //   444: astore_0
    //   445: getstatic 272	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   448: invokevirtual 276	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   451: checkcast 278	com/tencent/mobileqq/app/QQAppInterface
    //   454: invokevirtual 281	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   457: astore 5
    //   459: aload 4
    //   461: ifnull +116 -> 577
    //   464: iconst_1
    //   465: istore_3
    //   466: aload_0
    //   467: aload 5
    //   469: ldc_w 283
    //   472: iload_3
    //   473: lconst_1
    //   474: lconst_0
    //   475: aload_1
    //   476: ldc_w 285
    //   479: iconst_0
    //   480: invokevirtual 288	axrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   483: aload 4
    //   485: areturn
    //   486: aload 6
    //   488: getstatic 304	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   491: putfield 210	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   494: goto -466 -> 28
    //   497: iconst_0
    //   498: istore_3
    //   499: goto -395 -> 104
    //   502: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   505: ifeq -373 -> 132
    //   508: ldc 235
    //   510: iconst_2
    //   511: new 44	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   518: ldc_w 306
    //   521: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: aload_1
    //   525: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: ldc_w 297
    //   531: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload_1
    //   535: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: ldc 240
    //   540: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload 6
    //   545: getfield 217	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   548: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   551: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   557: goto -425 -> 132
    //   560: iconst_0
    //   561: istore_3
    //   562: goto -351 -> 211
    //   565: iconst_0
    //   566: istore_3
    //   567: goto -201 -> 366
    //   570: iload_2
    //   571: iconst_2
    //   572: imul
    //   573: istore_2
    //   574: goto -301 -> 273
    //   577: iconst_0
    //   578: istore_3
    //   579: goto -113 -> 466
    //   582: astore_0
    //   583: aload 4
    //   585: areturn
    //   586: astore 7
    //   588: goto -358 -> 230
    //   591: aload 4
    //   593: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	594	0	paramContext	Context
    //   0	594	1	paramString	String
    //   272	302	2	i	int
    //   103	476	3	bool	boolean
    //   59	533	4	localBitmap	Bitmap
    //   52	416	5	localObject1	Object
    //   7	537	6	localOptions	android.graphics.BitmapFactory.Options
    //   95	275	7	localObject2	Object
    //   586	1	7	localException	Exception
    //   188	24	8	localaxrn	axrn
    //   202	12	9	str	String
    // Exception table:
    //   from	to	target	type
    //   390	459	582	java/lang/Exception
    //   466	483	582	java/lang/Exception
    //   132	204	586	java/lang/Exception
    //   211	230	586	java/lang/Exception
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    return ChatBackgroundManager.a(paramContext, paramString1, paramString2);
  }
  
  static void a(Context paramContext, acur paramacur, String paramString, boolean paramBoolean)
  {
    Object localObject1 = null;
    Object localObject2;
    label165:
    int i;
    try
    {
      localObject2 = Shader.TileMode.REPEAT;
      localDrawable = paramContext.getResources().getDrawable(2130838762);
      if (localDrawable == null)
      {
        QLog.e("ChatBackground", 1, "setAIOBackgroundBmp Drawable d == null.");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatBackground", 2, "setAIOBackgroundBmp, Drawable d=" + localDrawable + ",path=" + paramString);
      }
      if (!ThemeUtil.isNowThemeIsAnimate()) {
        break label165;
      }
      paramString = ThemeUtil.getAnimatePathByTag(3);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("key_use_rect", true);
      ((Bundle)localObject1).putBoolean("key_play_apng", paramBoolean);
      paramacur.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bbqz.a(BaseApplicationImpl.sApplication.getRuntime(), paramString, "-chatBg-", localDrawable, new int[] { 0 }, "-chatBg-", (Bundle)localObject1);
      paramacur.jdField_a_of_type_JavaLangString = paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        Drawable localDrawable;
        QLog.e("ChatBackground", 1, "setAIOBackgroundBmp OOM1:" + paramString.getMessage());
        paramacur.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130848971);
        try
        {
          paramString = new HashMap();
          paramString.put("param_FailCode", "OOM1");
          paramString.put("param_themeid", ThemeUtil.getCurrentThemeId());
          axrn.a(paramContext).a(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ChatBackgroundDecoder", false, 1L, 0L, paramString, "", false);
        }
        catch (Exception paramContext) {}
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        label202:
        QLog.e("ChatBackground", 1, "setAIOBackgroundBmp OOM2 or Err:" + paramString.getMessage());
        paramacur.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130848971);
        try
        {
          paramString = new HashMap();
          paramString.put("param_FailCode", "EE");
          paramString.put("param_themeid", ThemeUtil.getCurrentThemeId());
          axrn.a(paramContext).a(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ChatBackgroundDecoder", false, 1L, 0L, paramString, "", false);
        }
        catch (Exception paramContext) {}
      }
      QLog.e("ChatBackground", 1, "setAIOBackgroundBmp out.img == null");
      return;
    }
    if (paramacur.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      paramacur.jdField_a_of_type_Boolean = true;
      return;
      if ((localDrawable instanceof BitmapDrawable))
      {
        localObject1 = ((BitmapDrawable)localDrawable).getBitmap();
        paramString = ((BitmapDrawable)localDrawable).getTileModeX();
        i = ((BitmapDrawable)localDrawable).getGravity();
        if ((localObject1 != null) && (paramString != Shader.TileMode.REPEAT) && (i == 48)) {
          break label405;
        }
        paramacur.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localDrawable;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("setAIOBackgroundBmp, bgBitmap=").append(localObject1).append(", type=");
          if (paramString != Shader.TileMode.REPEAT) {
            break label673;
          }
        }
      }
    }
    label405:
    label663:
    label673:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("ChatBackground", 2, paramBoolean + ", gravity=" + i);
      for (;;)
      {
        for (;;)
        {
          if (localObject1 != null) {
            break label431;
          }
          try
          {
            paramString = new HashMap();
            paramString.put("param_FailCode", "dNull");
            paramString.put("param_themeid", ThemeUtil.getCurrentThemeId());
            axrn.a(paramContext).a(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ChatBackgroundDecoder", false, 1L, 0L, paramString, "", false);
          }
          catch (Exception paramContext) {}
        }
        break;
        if (!(localDrawable instanceof SkinnableBitmapDrawable)) {
          break label663;
        }
        localObject1 = ((SkinnableBitmapDrawable)localDrawable).getBitmap();
        paramString = ((SkinnableBitmapDrawable)localDrawable).getTileModeX();
        i = ((SkinnableBitmapDrawable)localDrawable).getGravity();
        break label202;
        paramString = new anoy(paramContext.getResources(), (Bitmap)localObject1);
        paramString.setGravity(i);
        paramacur.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramString;
      }
      label431:
      break;
      paramString = (String)localObject2;
      i = 119;
      break label202;
    }
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    a(paramContext, paramString1, paramString2, paramString3, -1);
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    a(paramContext, paramString1, paramString2, paramString3, 0, paramInt);
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackground", 1, new Throwable(), new Object[0]);
    }
    Object localObject = new StringBuilder().append("setChatBackground, friendUin=");
    if (!TextUtils.isEmpty(paramString2)) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ChatBackground", 1, bool + ", path=" + paramString3);
      paramContext = a(paramContext, paramString1, 4);
      paramString1 = paramContext.edit();
      if (paramString2 != null) {
        break;
      }
      paramString1.putString("chat_uniform_bg", paramString3);
      paramString1.putInt("_chat_bg_effect", paramInt1);
      paramString2 = paramContext.getAll();
      if (paramString2 == null) {
        break label413;
      }
      paramString2 = paramString2.keySet().iterator();
      while (paramString2.hasNext())
      {
        localObject = (String)paramString2.next();
        if (Pattern.compile("[0-9]*").matcher((CharSequence)localObject).matches())
        {
          String str = paramContext.getString((String)localObject, "null");
          bool = paramContext.getBoolean((String)localObject + "_is_c2c_set", false);
          if ((str == null) || (str.trim().length() == 0) || (str.equals("null")) || (str.equals("none")) || (!bool))
          {
            paramString1.putString((String)localObject, paramString3);
            paramString1.putInt((String)localObject + "_chat_bg_effect", paramInt1);
          }
        }
      }
    }
    paramString1.putString(paramString2, paramString3);
    paramString1.putInt(paramString2 + "_uinType", paramInt2);
    if (paramString3.equals("null"))
    {
      paramString1.putBoolean(paramString2 + "_is_c2c_set", false);
      paramString1.remove(paramString2 + "_chat_bg_effect");
    }
    for (;;)
    {
      label413:
      paramString1.commit();
      return;
      paramString1.putBoolean(paramString2 + "_is_c2c_set", true);
      paramString1.putInt(paramString2 + "_chat_bg_effect", paramInt1);
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, int paramInt, acur paramacur)
  {
    if (paramacur == null)
    {
      QLog.e("ChatBackground", 1, "getChatBackground out=null");
      return false;
    }
    SharedPreferences localSharedPreferences = a(paramContext, paramString1, 0);
    Object localObject1 = null;
    if (!TextUtils.isEmpty(paramString2)) {
      localObject1 = localSharedPreferences.getString(paramString2, null);
    }
    paramString2 = (String)localObject1;
    if (localObject1 == null)
    {
      localObject1 = localSharedPreferences.getString("chat_uniform_bg", null);
      paramString2 = (String)localObject1;
      if (localObject1 == null) {
        paramString2 = "null";
      }
    }
    String str1 = ThemeDiyStyleLogic.getDiyVFSPath(paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackground_Time", 2, "getChatBackground, out.isDecodeSuccess=" + paramacur.jdField_a_of_type_Boolean + ", path=" + str1 + ", out.path=" + paramacur.jdField_a_of_type_JavaLangString);
    }
    boolean bool1;
    if ((paramInt & 0x1) != 0) {
      bool1 = true;
    }
    int i;
    label166:
    boolean bool2;
    for (;;)
    {
      if ((paramInt & 0x4) != 0)
      {
        i = 1;
        if ((paramInt & 0x2) == 0) {
          break label310;
        }
        bool2 = true;
        if ((paramacur.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (paramacur.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramacur.jdField_a_of_type_JavaLangString)) && (paramacur.jdField_a_of_type_JavaLangString.equals(str1))) {
          break label1622;
        }
      }
      for (;;)
      {
        try
        {
          if ((!TextUtils.isEmpty(str1)) && (!"null".equals(str1)) && (!"none".equals(str1))) {
            continue;
          }
          paramacur.jdField_a_of_type_JavaLangString = "null";
        }
        catch (OutOfMemoryError paramString1)
        {
          label310:
          QLog.e("ChatBackground", 1, "getChatBackground OOM0 ; path = " + str1);
          paramacur.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130848971);
          try
          {
            paramString1 = new HashMap();
            paramString1.put("param_FailCode", "OOM0");
            paramString1.put("param_themeid", ThemeUtil.getCurrentThemeId());
            axrn.a(paramContext).a(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ChatBackgroundDecoder", false, 1L, 0L, paramString1, "", false);
          }
          catch (Exception paramContext) {}
          continue;
          if (i == 0) {
            break label704;
          }
        }
        try
        {
          paramacur.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131166878);
          a(paramContext, paramacur, str1, bool1);
          if (paramacur.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
            QLog.e("ChatBackground", 1, "getChatBackground error out.img == null");
          }
          return true;
          bool1 = false;
          break;
          i = 0;
          break label166;
          bool2 = false;
        }
        catch (RuntimeException paramString1)
        {
          QLog.d("ChatBackground_Time", 2, "getChatBackground error");
        }
      }
    }
    long l1;
    label487:
    long l2;
    label704:
    label728:
    boolean bool3;
    if (ChatBackgroundManager.a(new File(str1)))
    {
      l1 = SystemClock.uptimeMillis();
      paramString1 = (Bitmap)BaseApplicationImpl.sImageCache.get(str1);
      if (paramString1 == null)
      {
        paramString1 = a(paramContext, str1);
        l2 = SystemClock.uptimeMillis();
        if (paramString1 != null) {
          BaseApplicationImpl.sImageCache.put(str1, paramString1);
        }
        for (paramString2 = new anoy(paramContext.getResources(), paramString1);; paramString2 = paramContext.getResources().getDrawable(2130838762))
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putBoolean("key_use_rect", true);
          ((Bundle)localObject1).putBoolean("key_double_bitmap", true);
          paramacur.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bbqz.a(BaseApplicationImpl.sApplication.getRuntime(), str1, "-chatBg-", paramString2, new int[] { 0 }, "-chatBg-", (Bundle)localObject1);
          if ((paramacur.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (paramString1 != null)) {
            paramacur.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new anoy(paramContext.getResources(), paramString1);
          }
          paramacur.jdField_a_of_type_JavaLangString = str1;
          paramacur.jdField_a_of_type_Boolean = true;
          if (paramString1 != null) {
            paramacur.jdField_a_of_type_AndroidContentResColorStateList = a(localSharedPreferences, str1, paramString1);
          }
          long l3 = SystemClock.uptimeMillis();
          QLog.d("ChatBackground_Time", 1, "APNG_getBitmap " + (l2 - l1) + " APNG_init " + (l3 - l2));
          break;
        }
      }
    }
    else
    {
      if (BaseApplicationImpl.sImageCache.get(str1) == null) {
        break label1682;
      }
      localObject1 = (Bitmap)BaseApplicationImpl.sImageCache.get(str1);
      paramString2 = (String)localObject1;
      if (localObject1 != null)
      {
        paramString2 = (String)localObject1;
        if (((Bitmap)localObject1).isRecycled()) {
          paramString2 = null;
        }
      }
      bool3 = false;
      paramBoolean = bool3;
      localObject1 = paramString2;
      if (paramString2 == null)
      {
        localObject1 = new File(str1);
        if ((localObject1 == null) || (!((File)localObject1).exists())) {
          break label1663;
        }
        if (((File)localObject1).isFile()) {
          break label1355;
        }
        break label1663;
        label797:
        if ((localObject1 == null) || (!((File)localObject1).exists())) {
          break label1234;
        }
        paramBoolean = bfkz.a(paramContext);
        if ((QLog.isColorLevel()) || (!paramBoolean)) {
          QLog.d("ChatBackground", 2, "getChatBackground, sharpP exists, path=" + str1 + ", sharpPAv=" + paramBoolean);
        }
        if (!paramBoolean) {
          break label1657;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = SharpPUtil.decodeSharpPByFilePath(((File)localObject1).getAbsolutePath());
        if (!QLog.isColorLevel())
        {
          paramString2 = (String)localObject1;
          if (localObject1 != null) {
            break label1674;
          }
        }
        paramString2 = new StringBuilder().append("getChatBackground, sharpP decode result=");
        if (localObject1 != null)
        {
          paramBoolean = true;
          QLog.d("ChatBackground", 2, paramBoolean + ", path=" + str1);
          paramString2 = (String)localObject1;
          break label1674;
          label942:
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder().append("getChatBackground, check bg=");
            if (localObject1 == null) {
              break label1698;
            }
            bool3 = true;
            QLog.d("ChatBackground", 2, bool3 + ", path=" + str1);
          }
          if (localObject1 == null) {
            break label1410;
          }
          BaseApplicationImpl.sImageCache.put(str1, localObject1);
          paramacur.jdField_a_of_type_JavaLangString = str1;
          paramacur.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new anoy(paramContext.getResources(), (Bitmap)localObject1);
          paramacur.jdField_a_of_type_AndroidContentResColorStateList = a(localSharedPreferences, str1, (Bitmap)localObject1);
          paramacur.jdField_a_of_type_Boolean = true;
          break;
          label1060:
          localObject1 = new File(bfkz.a((File)localObject1));
          break label797;
        }
        paramBoolean = false;
        continue;
        label1145:
        if (paramString2 != null) {
          break label1232;
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        QLog.e("ChatBackground", 1, "sharpP decodeSharpPByFilePath UnsatisfiedLinkError, msg:" + localUnsatisfiedLinkError.getMessage());
        if ((!QLog.isColorLevel()) && (paramString2 != null)) {
          break label1657;
        }
        localObject2 = new StringBuilder().append("getChatBackground, sharpP decode result=");
        if (paramString2 == null) {
          break label1688;
        }
        paramBoolean = true;
        QLog.d("ChatBackground", 2, paramBoolean + ", path=" + str1);
      }
      finally
      {
        if (QLog.isColorLevel()) {}
      }
      Object localObject2 = new StringBuilder().append("getChatBackground, sharpP decode result=");
      if (paramString2 != null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        for (;;)
        {
          QLog.d("ChatBackground", 2, paramBoolean + ", path=" + str1);
          label1232:
          throw paramString1;
          label1234:
          QLog.e("ChatBackground", 1, "getChatBackground Error, file == null ; path = " + str1);
          try
          {
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("param_FailCode", "dd_5");
            ((HashMap)localObject2).put("param_themeid", ThemeUtil.getCurrentThemeId());
            axrn localaxrn = axrn.a(paramContext);
            String str2 = ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount();
            if (paramString2 != null) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              localaxrn.a(str2, "ChatBackgroundDecoder", paramBoolean, 1L, 0L, (HashMap)localObject2, "", false);
              paramBoolean = true;
              break;
            }
            l1 = SystemClock.uptimeMillis();
          }
          catch (Exception localException)
          {
            paramBoolean = true;
          }
          label1355:
          localObject3 = a(paramContext, str1);
          l2 = SystemClock.uptimeMillis();
          QLog.e("ChatBackground_Time", 1, "Normal_getBitmap " + (l2 - l1));
          paramBoolean = bool3;
          break label942;
          label1410:
          paramString1 = ThemeBackground.getSharedPreferences(paramContext, paramString1, 0).getString("theme_bg_aio_path_url", null);
          if (!TextUtils.isEmpty(paramString1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ChatBackground", 2, "getChatBackground, downloading, url=" + paramString1 + ", path=" + str1);
            }
            paramString2 = new ResData();
            paramString2.path = str1;
            paramString2.url = paramString1;
            paramString2.loadingType = 3;
            paramacur.jdField_a_of_type_AndroidGraphicsDrawableDrawable = DIYThemeUtils.getDIYDrawable(paramContext, paramString2, 0, 0, -1, bool2);
            paramacur.jdField_a_of_type_JavaLangString = str1;
            break;
          }
          QLog.e("ChatBackground", 2, "getChatBackground, bg == null, path=" + str1 + ", fileErr=" + paramBoolean);
          paramacur.jdField_a_of_type_JavaLangString = "null";
          try
          {
            paramacur.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131166878);
            a(paramContext, paramacur, str1, bool1);
            if (paramBoolean) {
              break;
            }
            paramacur.jdField_a_of_type_Boolean = false;
          }
          catch (RuntimeException paramString1)
          {
            for (;;)
            {
              QLog.d("ChatBackground_Time", 2, "getChatBackground error");
            }
          }
        }
        label1622:
        if (QLog.isColorLevel()) {
          QLog.d("ChatBackground", 2, "getChatBackground, bg not change, path=" + str1);
        }
        return false;
        label1657:
        break label1674;
        break label487;
        label1663:
        if (localObject3 != null) {
          break label1060;
        }
        Object localObject3 = null;
        break label797;
        label1674:
        paramBoolean = false;
        localObject3 = paramString2;
        break label942;
        label1682:
        localObject3 = null;
        break label728;
        label1688:
        paramBoolean = false;
        break label1145;
      }
      label1698:
      bool3 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acur
 * JD-Core Version:    0.7.0.1
 */