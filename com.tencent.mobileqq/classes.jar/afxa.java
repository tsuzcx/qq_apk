import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
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
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class afxa
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
    if (aopp.a("QQThemeChatBackgroundMigration", paramString) < 1)
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
                localEditor.putString((String)localEntry.getKey(), str.replace("/custom_background/" + paramString + "/", "/custom_background/" + aopp.a(paramString) + "/"));
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
            localEditor.putString((String)localEntry.getKey(), str.replace("/" + paramString + "/custom_background/", "/custom_background/" + aopp.a(paramString) + "/"));
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
                localEditor.putInt(str.replace("/custom_background/" + paramString + "/", "/custom_background/" + aopp.a(paramString) + "/"), ((Integer)localEntry.getValue()).intValue());
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
              localEditor.putInt(str.replace("/" + paramString + "/custom_background/", "/custom_background/" + aopp.a(paramString) + "/"), ((Integer)localEntry.getValue()).intValue());
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
      aopp.a("QQThemeChatBackgroundMigration", paramString, 1);
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
    //   49: invokestatic 222	bggl:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lbggm;
    //   52: astore 5
    //   54: aload 5
    //   56: getfield 227	bggm:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   59: astore 4
    //   61: aload 4
    //   63: ifnull +11 -> 74
    //   66: aload 5
    //   68: getfield 229	bggm:jdField_a_of_type_Int	I
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
    //   159: getfield 229	bggm:jdField_a_of_type_Int	I
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
    //   185: invokestatic 266	bctj:a	(Landroid/content/Context;)Lbctj;
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
    //   227: invokevirtual 288	bctj:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   230: aload 5
    //   232: getfield 229	bggm:jdField_a_of_type_Int	I
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
    //   288: invokestatic 222	bggl:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lbggm;
    //   291: astore 5
    //   293: aload 5
    //   295: getfield 227	bggm:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
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
    //   326: getfield 229	bggm:jdField_a_of_type_Int	I
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
    //   383: getfield 229	bggm:jdField_a_of_type_Int	I
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
    //   416: getfield 229	bggm:jdField_a_of_type_Int	I
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
    //   441: invokestatic 266	bctj:a	(Landroid/content/Context;)Lbctj;
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
    //   480: invokevirtual 288	bctj:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
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
    //   188	24	8	localbctj	bctj
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
  
  /* Error */
  static void a(Context paramContext, afxa paramafxa, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 321	android/graphics/Shader$TileMode:REPEAT	Landroid/graphics/Shader$TileMode;
    //   3: astore 6
    //   5: aload_0
    //   6: invokevirtual 325	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   9: ldc_w 326
    //   12: invokevirtual 332	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   15: astore 7
    //   17: aload 7
    //   19: ifnonnull +13 -> 32
    //   22: ldc 235
    //   24: iconst_1
    //   25: ldc_w 334
    //   28: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: return
    //   32: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq +40 -> 75
    //   38: ldc 235
    //   40: iconst_2
    //   41: new 44	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   48: ldc_w 336
    //   51: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload 7
    //   56: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   59: ldc_w 338
    //   62: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_2
    //   66: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: iconst_0
    //   76: istore 4
    //   78: iconst_0
    //   79: istore 5
    //   81: invokestatic 341	com/tencent/mobileqq/theme/ThemeUtil:isNowThemeIsAnimate	()Z
    //   84: ifeq +141 -> 225
    //   87: iconst_3
    //   88: invokestatic 345	com/tencent/mobileqq/theme/ThemeUtil:getAnimatePathByTag	(I)Ljava/lang/String;
    //   91: astore_2
    //   92: new 347	android/os/Bundle
    //   95: dup
    //   96: invokespecial 348	android/os/Bundle:<init>	()V
    //   99: astore 8
    //   101: aload 8
    //   103: ldc_w 350
    //   106: iconst_1
    //   107: invokevirtual 354	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   110: aload 8
    //   112: ldc_w 356
    //   115: iload_3
    //   116: invokevirtual 354	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   119: aload_2
    //   120: ldc_w 358
    //   123: ldc_w 326
    //   126: invokestatic 364	com/tencent/mobileqq/theme/diy/ThemeBackground:getDynamicDrawable	(Ljava/lang/String;Ljava/lang/String;I)Landroid/graphics/drawable/Drawable;
    //   129: astore 9
    //   131: aload 9
    //   133: ifnull +26 -> 159
    //   136: invokestatic 369	bhbt:a	()Lbhbt;
    //   139: aload 9
    //   141: iconst_1
    //   142: invokevirtual 372	bhbt:a	(Landroid/graphics/drawable/Drawable;Z)V
    //   145: aload_1
    //   146: aload 9
    //   148: putfield 374	afxa:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   151: aload_1
    //   152: aload_2
    //   153: putfield 376	afxa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   156: iconst_1
    //   157: istore 5
    //   159: iload 5
    //   161: istore 4
    //   163: iload 5
    //   165: ifne +60 -> 225
    //   168: iload 5
    //   170: istore 4
    //   172: new 378	java/io/File
    //   175: dup
    //   176: aload_2
    //   177: invokespecial 381	java/io/File:<init>	(Ljava/lang/String;)V
    //   180: invokevirtual 384	java/io/File:exists	()Z
    //   183: ifeq +42 -> 225
    //   186: aload_1
    //   187: getstatic 272	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   190: invokevirtual 276	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   193: aload_2
    //   194: ldc_w 386
    //   197: aload 7
    //   199: iconst_1
    //   200: newarray int
    //   202: dup
    //   203: iconst_0
    //   204: iconst_0
    //   205: iastore
    //   206: ldc_w 386
    //   209: aload 8
    //   211: invokestatic 392	com/tencent/mobileqq/vas/VasApngUtil:getApngDrawable	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;[ILjava/lang/String;Landroid/os/Bundle;)Lcom/tencent/image/URLDrawable;
    //   214: putfield 374	afxa:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   217: aload_1
    //   218: aload_2
    //   219: putfield 376	afxa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   222: iconst_1
    //   223: istore 4
    //   225: iload 4
    //   227: ifne +196 -> 423
    //   230: aload 7
    //   232: instanceof 394
    //   235: ifeq +201 -> 436
    //   238: aload 7
    //   240: checkcast 394	android/graphics/drawable/BitmapDrawable
    //   243: invokevirtual 398	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   246: astore 6
    //   248: aload 7
    //   250: checkcast 394	android/graphics/drawable/BitmapDrawable
    //   253: invokevirtual 402	android/graphics/drawable/BitmapDrawable:getTileModeX	()Landroid/graphics/Shader$TileMode;
    //   256: astore_2
    //   257: aload 7
    //   259: checkcast 394	android/graphics/drawable/BitmapDrawable
    //   262: invokevirtual 405	android/graphics/drawable/BitmapDrawable:getGravity	()I
    //   265: istore 4
    //   267: aload 6
    //   269: ifnull +17 -> 286
    //   272: aload_2
    //   273: getstatic 321	android/graphics/Shader$TileMode:REPEAT	Landroid/graphics/Shader$TileMode;
    //   276: if_acmpeq +10 -> 286
    //   279: iload 4
    //   281: bipush 48
    //   283: if_icmpeq +193 -> 476
    //   286: aload_1
    //   287: aload 7
    //   289: putfield 374	afxa:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   292: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   295: ifeq +64 -> 359
    //   298: new 44	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   305: ldc_w 407
    //   308: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload 6
    //   313: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   316: ldc_w 409
    //   319: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: astore 7
    //   324: aload_2
    //   325: getstatic 321	android/graphics/Shader$TileMode:REPEAT	Landroid/graphics/Shader$TileMode;
    //   328: if_acmpne +423 -> 751
    //   331: iconst_1
    //   332: istore_3
    //   333: ldc 235
    //   335: iconst_2
    //   336: aload 7
    //   338: iload_3
    //   339: invokevirtual 238	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   342: ldc_w 411
    //   345: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: iload 4
    //   350: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   353: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   359: aload 6
    //   361: ifnonnull +62 -> 423
    //   364: new 245	java/util/HashMap
    //   367: dup
    //   368: invokespecial 246	java/util/HashMap:<init>	()V
    //   371: astore_2
    //   372: aload_2
    //   373: ldc 248
    //   375: ldc_w 413
    //   378: invokevirtual 254	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   381: pop
    //   382: aload_2
    //   383: ldc_w 256
    //   386: invokestatic 261	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   389: invokevirtual 254	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   392: pop
    //   393: aload_0
    //   394: invokestatic 266	bctj:a	(Landroid/content/Context;)Lbctj;
    //   397: getstatic 272	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   400: invokevirtual 276	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   403: checkcast 278	com/tencent/mobileqq/app/QQAppInterface
    //   406: invokevirtual 281	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   409: ldc_w 283
    //   412: iconst_0
    //   413: lconst_1
    //   414: lconst_0
    //   415: aload_2
    //   416: ldc_w 285
    //   419: iconst_0
    //   420: invokevirtual 288	bctj:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   423: aload_1
    //   424: getfield 374	afxa:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   427: ifnull +297 -> 724
    //   430: aload_1
    //   431: iconst_1
    //   432: putfield 415	afxa:jdField_a_of_type_Boolean	Z
    //   435: return
    //   436: aload 7
    //   438: instanceof 417
    //   441: ifeq +297 -> 738
    //   444: aload 7
    //   446: checkcast 417	com/tencent/theme/SkinnableBitmapDrawable
    //   449: invokevirtual 418	com/tencent/theme/SkinnableBitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   452: astore 6
    //   454: aload 7
    //   456: checkcast 417	com/tencent/theme/SkinnableBitmapDrawable
    //   459: invokevirtual 419	com/tencent/theme/SkinnableBitmapDrawable:getTileModeX	()Landroid/graphics/Shader$TileMode;
    //   462: astore_2
    //   463: aload 7
    //   465: checkcast 417	com/tencent/theme/SkinnableBitmapDrawable
    //   468: invokevirtual 420	com/tencent/theme/SkinnableBitmapDrawable:getGravity	()I
    //   471: istore 4
    //   473: goto -206 -> 267
    //   476: new 422	arni
    //   479: dup
    //   480: aload_0
    //   481: invokevirtual 325	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   484: aload 6
    //   486: invokespecial 425	arni:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   489: astore_2
    //   490: aload_2
    //   491: iload 4
    //   493: invokevirtual 429	arni:setGravity	(I)V
    //   496: aload_1
    //   497: aload_2
    //   498: putfield 374	afxa:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   501: goto -142 -> 359
    //   504: astore_2
    //   505: ldc 235
    //   507: iconst_1
    //   508: new 44	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   515: ldc_w 431
    //   518: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: aload_2
    //   522: invokevirtual 434	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   525: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   534: aload_1
    //   535: aload_0
    //   536: invokevirtual 325	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   539: ldc_w 435
    //   542: invokevirtual 332	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   545: putfield 374	afxa:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   548: new 245	java/util/HashMap
    //   551: dup
    //   552: invokespecial 246	java/util/HashMap:<init>	()V
    //   555: astore_2
    //   556: aload_2
    //   557: ldc 248
    //   559: ldc_w 437
    //   562: invokevirtual 254	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   565: pop
    //   566: aload_2
    //   567: ldc_w 256
    //   570: invokestatic 261	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   573: invokevirtual 254	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   576: pop
    //   577: aload_0
    //   578: invokestatic 266	bctj:a	(Landroid/content/Context;)Lbctj;
    //   581: getstatic 272	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   584: invokevirtual 276	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   587: checkcast 278	com/tencent/mobileqq/app/QQAppInterface
    //   590: invokevirtual 281	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   593: ldc_w 283
    //   596: iconst_0
    //   597: lconst_1
    //   598: lconst_0
    //   599: aload_2
    //   600: ldc_w 285
    //   603: iconst_0
    //   604: invokevirtual 288	bctj:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   607: goto -184 -> 423
    //   610: astore_0
    //   611: goto -188 -> 423
    //   614: astore_2
    //   615: ldc 235
    //   617: iconst_1
    //   618: new 44	java/lang/StringBuilder
    //   621: dup
    //   622: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   625: ldc_w 439
    //   628: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: aload_2
    //   632: invokevirtual 440	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   635: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   644: aload_1
    //   645: aload_0
    //   646: invokevirtual 325	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   649: ldc_w 435
    //   652: invokevirtual 332	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   655: putfield 374	afxa:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   658: new 245	java/util/HashMap
    //   661: dup
    //   662: invokespecial 246	java/util/HashMap:<init>	()V
    //   665: astore_2
    //   666: aload_2
    //   667: ldc 248
    //   669: ldc_w 442
    //   672: invokevirtual 254	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   675: pop
    //   676: aload_2
    //   677: ldc_w 256
    //   680: invokestatic 261	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   683: invokevirtual 254	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   686: pop
    //   687: aload_0
    //   688: invokestatic 266	bctj:a	(Landroid/content/Context;)Lbctj;
    //   691: getstatic 272	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   694: invokevirtual 276	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   697: checkcast 278	com/tencent/mobileqq/app/QQAppInterface
    //   700: invokevirtual 281	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   703: ldc_w 283
    //   706: iconst_0
    //   707: lconst_1
    //   708: lconst_0
    //   709: aload_2
    //   710: ldc_w 285
    //   713: iconst_0
    //   714: invokevirtual 288	bctj:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   717: goto -294 -> 423
    //   720: astore_0
    //   721: goto -298 -> 423
    //   724: ldc 235
    //   726: iconst_1
    //   727: ldc_w 444
    //   730: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   733: return
    //   734: astore_0
    //   735: goto -312 -> 423
    //   738: bipush 119
    //   740: istore 4
    //   742: aload 6
    //   744: astore_2
    //   745: aconst_null
    //   746: astore 6
    //   748: goto -481 -> 267
    //   751: iconst_0
    //   752: istore_3
    //   753: goto -420 -> 333
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	756	0	paramContext	Context
    //   0	756	1	paramafxa	afxa
    //   0	756	2	paramString	String
    //   0	756	3	paramBoolean	boolean
    //   76	665	4	i	int
    //   79	90	5	j	int
    //   3	744	6	localObject1	Object
    //   15	449	7	localObject2	Object
    //   99	111	8	localBundle	Bundle
    //   129	18	9	localDrawable	Drawable
    // Exception table:
    //   from	to	target	type
    //   0	17	504	java/lang/OutOfMemoryError
    //   22	31	504	java/lang/OutOfMemoryError
    //   32	75	504	java/lang/OutOfMemoryError
    //   81	131	504	java/lang/OutOfMemoryError
    //   136	156	504	java/lang/OutOfMemoryError
    //   172	222	504	java/lang/OutOfMemoryError
    //   230	267	504	java/lang/OutOfMemoryError
    //   272	279	504	java/lang/OutOfMemoryError
    //   286	331	504	java/lang/OutOfMemoryError
    //   333	359	504	java/lang/OutOfMemoryError
    //   364	423	504	java/lang/OutOfMemoryError
    //   436	473	504	java/lang/OutOfMemoryError
    //   476	501	504	java/lang/OutOfMemoryError
    //   548	607	610	java/lang/Exception
    //   0	17	614	java/lang/Exception
    //   22	31	614	java/lang/Exception
    //   32	75	614	java/lang/Exception
    //   81	131	614	java/lang/Exception
    //   136	156	614	java/lang/Exception
    //   172	222	614	java/lang/Exception
    //   230	267	614	java/lang/Exception
    //   272	279	614	java/lang/Exception
    //   286	331	614	java/lang/Exception
    //   333	359	614	java/lang/Exception
    //   436	473	614	java/lang/Exception
    //   476	501	614	java/lang/Exception
    //   658	717	720	java/lang/Exception
    //   364	423	734	java/lang/Exception
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
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, int paramInt, afxa paramafxa)
  {
    if (paramafxa == null)
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
      QLog.d("ChatBackground_Time", 2, "getChatBackground, out.isDecodeSuccess=" + paramafxa.jdField_a_of_type_Boolean + ", path=" + str1 + ", out.path=" + paramafxa.jdField_a_of_type_JavaLangString);
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
        if ((paramafxa.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (paramafxa.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramafxa.jdField_a_of_type_JavaLangString)) && (paramafxa.jdField_a_of_type_JavaLangString.equals(str1))) {
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
          paramafxa.jdField_a_of_type_JavaLangString = "null";
        }
        catch (OutOfMemoryError paramString1)
        {
          label310:
          QLog.e("ChatBackground", 1, "getChatBackground OOM0 ; path = " + str1);
          paramafxa.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130850026);
          try
          {
            paramString1 = new HashMap();
            paramString1.put("param_FailCode", "OOM0");
            paramString1.put("param_themeid", ThemeUtil.getCurrentThemeId());
            bctj.a(paramContext).a(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ChatBackgroundDecoder", false, 1L, 0L, paramString1, "", false);
          }
          catch (Exception paramContext) {}
          continue;
          if (i == 0) {
            break label704;
          }
        }
        try
        {
          paramafxa.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131167010);
          a(paramContext, paramafxa, str1, bool1);
          if (paramafxa.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
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
        for (paramString2 = new arni(paramContext.getResources(), paramString1);; paramString2 = paramContext.getResources().getDrawable(2130839091))
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putBoolean("key_use_rect", true);
          ((Bundle)localObject1).putBoolean("key_double_bitmap", true);
          paramafxa.jdField_a_of_type_AndroidGraphicsDrawableDrawable = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), str1, "-chatBg-", paramString2, new int[] { 0 }, "-chatBg-", (Bundle)localObject1);
          if ((paramafxa.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (paramString1 != null)) {
            paramafxa.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new arni(paramContext.getResources(), paramString1);
          }
          paramafxa.jdField_a_of_type_JavaLangString = str1;
          paramafxa.jdField_a_of_type_Boolean = true;
          if (paramString1 != null) {
            paramafxa.jdField_a_of_type_AndroidContentResColorStateList = a(localSharedPreferences, str1, paramString1);
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
        paramBoolean = bkdi.a(paramContext);
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
          paramafxa.jdField_a_of_type_JavaLangString = str1;
          paramafxa.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new arni(paramContext.getResources(), (Bitmap)localObject1);
          paramafxa.jdField_a_of_type_AndroidContentResColorStateList = a(localSharedPreferences, str1, (Bitmap)localObject1);
          paramafxa.jdField_a_of_type_Boolean = true;
          break;
          label1060:
          localObject1 = new File(bkdi.a((File)localObject1));
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
            bctj localbctj = bctj.a(paramContext);
            String str2 = ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount();
            if (paramString2 != null) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              localbctj.a(str2, "ChatBackgroundDecoder", paramBoolean, 1L, 0L, (HashMap)localObject2, "", false);
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
            paramafxa.jdField_a_of_type_AndroidGraphicsDrawableDrawable = DIYThemeUtils.getDIYDrawable(paramContext, paramString2, 0, 0, -1, bool2);
            paramafxa.jdField_a_of_type_JavaLangString = str1;
            break;
          }
          QLog.e("ChatBackground", 2, "getChatBackground, bg == null, path=" + str1 + ", fileErr=" + paramBoolean);
          paramafxa.jdField_a_of_type_JavaLangString = "null";
          try
          {
            paramafxa.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131167010);
            a(paramContext, paramafxa, str1, bool1);
            if (paramBoolean) {
              break;
            }
            paramafxa.jdField_a_of_type_Boolean = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afxa
 * JD-Core Version:    0.7.0.1
 */