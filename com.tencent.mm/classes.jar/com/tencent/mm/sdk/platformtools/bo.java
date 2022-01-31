package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashMap<Ljava.lang.String;Ljava.lang.String;>;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class bo
{
  private static final TimeZone GMT;
  public static final long[] glS;
  private static final char[] iXA;
  private static final String[] iXB;
  private static final long[] yqQ;
  private static final BigInteger yqR;
  
  static
  {
    AppMethodBeat.i(52439);
    glS = new long[] { 300L, 200L, 300L, 200L };
    yqQ = new long[] { 300L, 50L, 300L, 50L };
    GMT = TimeZone.getTimeZone("GMT");
    yqR = BigInteger.ONE.shiftLeft(64);
    iXA = new char[] { 60, 62, 34, 39, 38, 13, 10, 32, 9 };
    iXB = new String[] { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&#x0D;", "&#x0A;", "&#x20;", "&#x09;" };
    AppMethodBeat.o(52439);
  }
  
  public static boolean B(char paramChar)
  {
    AppMethodBeat.i(52304);
    Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
    if ((localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (localUnicodeBlock == Character.UnicodeBlock.GENERAL_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS))
    {
      AppMethodBeat.o(52304);
      return true;
    }
    AppMethodBeat.o(52304);
    return false;
  }
  
  public static boolean C(char paramChar)
  {
    return ((paramChar >= 'a') && (paramChar <= 'z')) || ((paramChar >= 'A') && (paramChar <= 'Z'));
  }
  
  public static boolean D(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  public static String E(double paramDouble)
  {
    AppMethodBeat.i(52438);
    String str = String.format("%.2f", new Object[] { Double.valueOf(paramDouble) });
    AppMethodBeat.o(52438);
    return str;
  }
  
  public static String F(InputStream paramInputStream)
  {
    AppMethodBeat.i(52399);
    if (paramInputStream == null)
    {
      AppMethodBeat.o(52399);
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      byte[] arrayOfByte = new byte[4096];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localStringBuffer.append(new String(arrayOfByte, 0, i));
      }
      try
      {
        paramInputStream.close();
        AppMethodBeat.o(52399);
        throw localObject;
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      try
      {
        paramInputStream.close();
        for (;;)
        {
          paramInputStream = localStringBuffer.toString();
          AppMethodBeat.o(52399);
          return paramInputStream;
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            ab.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
          }
        }
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
        }
      }
    }
    finally {}
  }
  
  public static List<ResolveInfo> H(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(52341);
    if ((paramContext == null) || (paramIntent == null))
    {
      AppMethodBeat.o(52341);
      return null;
    }
    paramContext = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536);
    AppMethodBeat.o(52341);
    return paramContext;
  }
  
  public static Intent I(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(52435);
    paramContext = paramContext.getPackageManager().queryIntentServices(paramIntent, 0);
    if ((paramContext == null) || (paramContext.size() != 1))
    {
      AppMethodBeat.o(52435);
      return null;
    }
    Object localObject = (ResolveInfo)paramContext.get(0);
    paramContext = ((ResolveInfo)localObject).serviceInfo.packageName;
    localObject = ((ResolveInfo)localObject).serviceInfo.name;
    ab.d("MicroMsg.Util", "createExplicitFromImplicitIntent pa:%s, cl:%s", new Object[] { paramContext, localObject });
    paramContext = new ComponentName(paramContext, (String)localObject);
    paramIntent = new Intent(paramIntent);
    paramIntent.setComponent(paramContext);
    AppMethodBeat.o(52435);
    return paramIntent;
  }
  
  public static boolean M(Context paramContext, String paramString)
  {
    AppMethodBeat.i(52374);
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    if (!k(paramContext, localIntent))
    {
      ab.e("MicroMsg.Util", "jump to url failed, ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(52374);
      return false;
    }
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(52374);
    return true;
  }
  
  public static boolean N(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(52329);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(5) == localCalendar2.get(5)) && (localCalendar1.get(2) == localCalendar2.get(2)))
    {
      AppMethodBeat.o(52329);
      return true;
    }
    AppMethodBeat.o(52329);
    return false;
  }
  
  public static String Ng(int paramInt)
  {
    AppMethodBeat.i(52423);
    Object localObject = new Random();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramInt)
    {
      localStringBuffer.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(((Random)localObject).nextInt(62)));
      i += 1;
    }
    localObject = localStringBuffer.toString();
    AppMethodBeat.o(52423);
    return localObject;
  }
  
  public static ArrayList<String> P(String[] paramArrayOfString)
  {
    AppMethodBeat.i(52297);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(52297);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      localArrayList.add(paramArrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(52297);
    return localArrayList;
  }
  
  public static boolean Q(String... paramVarArgs)
  {
    boolean bool2 = false;
    AppMethodBeat.i(52355);
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (isNullOrNil(paramVarArgs[i])) {
          bool1 = true;
        }
      }
      else
      {
        AppMethodBeat.o(52355);
        return bool1;
      }
      i += 1;
    }
  }
  
  public static String RK(String paramString)
  {
    AppMethodBeat.i(52396);
    paramString = paramString.replaceAll("[\\.\\-]", "").trim();
    AppMethodBeat.o(52396);
    return paramString;
  }
  
  public static String V(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(52317);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(52317);
      return "(null)";
    }
    int i = paramInt;
    if (paramInt <= 0) {
      i = paramArrayOfByte.length;
    }
    char[] arrayOfChar1 = new char[16];
    char[] tmp37_35 = arrayOfChar1;
    tmp37_35[0] = 48;
    char[] tmp43_37 = tmp37_35;
    tmp43_37[1] = 49;
    char[] tmp49_43 = tmp43_37;
    tmp49_43[2] = 50;
    char[] tmp55_49 = tmp49_43;
    tmp55_49[3] = 51;
    char[] tmp61_55 = tmp55_49;
    tmp61_55[4] = 52;
    char[] tmp67_61 = tmp61_55;
    tmp67_61[5] = 53;
    char[] tmp73_67 = tmp67_61;
    tmp73_67[6] = 54;
    char[] tmp80_73 = tmp73_67;
    tmp80_73[7] = 55;
    char[] tmp87_80 = tmp80_73;
    tmp87_80[8] = 56;
    char[] tmp94_87 = tmp87_80;
    tmp94_87[9] = 57;
    char[] tmp101_94 = tmp94_87;
    tmp101_94[10] = 97;
    char[] tmp108_101 = tmp101_94;
    tmp108_101[11] = 98;
    char[] tmp115_108 = tmp108_101;
    tmp115_108[12] = 99;
    char[] tmp122_115 = tmp115_108;
    tmp122_115[13] = 100;
    char[] tmp129_122 = tmp122_115;
    tmp129_122[14] = 101;
    char[] tmp136_129 = tmp129_122;
    tmp136_129[15] = 102;
    tmp136_129;
    char[] arrayOfChar2 = new char[i * 3 + i / 16];
    int j = 0;
    paramInt = 0;
    if (j < i + 0)
    {
      int k = paramArrayOfByte[j];
      int m = paramInt + 1;
      arrayOfChar2[paramInt] = ' ';
      int n = m + 1;
      arrayOfChar2[m] = arrayOfChar1[(k >>> 4 & 0xF)];
      paramInt = n + 1;
      arrayOfChar2[n] = arrayOfChar1[(k & 0xF)];
      if ((j % 16 != 0) || (j <= 0)) {
        break label272;
      }
      k = paramInt + 1;
      arrayOfChar2[paramInt] = '\n';
      paramInt = k;
    }
    label272:
    for (;;)
    {
      j += 1;
      break;
      paramArrayOfByte = new String(arrayOfChar2);
      AppMethodBeat.o(52317);
      return paramArrayOfByte;
    }
  }
  
  public static int a(Integer paramInteger, int paramInt)
  {
    AppMethodBeat.i(52347);
    if (paramInteger == null)
    {
      AppMethodBeat.o(52347);
      return paramInt;
    }
    paramInt = paramInteger.intValue();
    AppMethodBeat.o(52347);
    return paramInt;
  }
  
  private static int a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52377);
    if (paramInt2 <= 0)
    {
      AppMethodBeat.o(52377);
      return 0;
    }
    if (paramArrayOfChar[paramInt1] == '#')
    {
      if ((paramInt2 > 1) && ((paramArrayOfChar[(paramInt1 + 1)] == 'x') || (paramArrayOfChar[(paramInt1 + 1)] == 'X'))) {
        try
        {
          paramInt1 = Integer.parseInt(new String(paramArrayOfChar, paramInt1 + 2, paramInt2 - 2), 16);
          AppMethodBeat.o(52377);
          return paramInt1;
        }
        catch (NumberFormatException paramArrayOfChar)
        {
          AppMethodBeat.o(52377);
          return 0;
        }
      }
      try
      {
        paramInt1 = Integer.parseInt(new String(paramArrayOfChar, paramInt1 + 1, paramInt2 - 1), 10);
        AppMethodBeat.o(52377);
        return paramInt1;
      }
      catch (NumberFormatException paramArrayOfChar)
      {
        AppMethodBeat.o(52377);
        return 0;
      }
    }
    new String(paramArrayOfChar, paramInt1, paramInt2);
    AppMethodBeat.o(52377);
    return 0;
  }
  
  public static long a(Long paramLong, long paramLong1)
  {
    AppMethodBeat.i(52348);
    if (paramLong == null)
    {
      AppMethodBeat.o(52348);
      return paramLong1;
    }
    paramLong1 = paramLong.longValue();
    AppMethodBeat.o(52348);
    return paramLong1;
  }
  
  /* Error */
  private static String a(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 402
    //   6: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokevirtual 406	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: aload_1
    //   14: iconst_1
    //   15: anewarray 74	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: ldc_w 408
    //   23: aastore
    //   24: aload_2
    //   25: aload_3
    //   26: aconst_null
    //   27: invokevirtual 414	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   30: astore_0
    //   31: aload_0
    //   32: ifnull +88 -> 120
    //   35: aload_0
    //   36: invokeinterface 420 1 0
    //   41: ifeq +79 -> 120
    //   44: aload_0
    //   45: ldc_w 408
    //   48: invokeinterface 424 2 0
    //   53: istore 4
    //   55: iload 4
    //   57: iconst_m1
    //   58: if_icmpne +35 -> 93
    //   61: ldc 177
    //   63: ldc_w 426
    //   66: invokestatic 284	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_0
    //   70: invokeinterface 427 1 0
    //   75: aload_0
    //   76: ifnull +9 -> 85
    //   79: aload_0
    //   80: invokeinterface 427 1 0
    //   85: ldc_w 402
    //   88: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aconst_null
    //   92: areturn
    //   93: aload_0
    //   94: iload 4
    //   96: invokeinterface 430 2 0
    //   101: astore_2
    //   102: aload_0
    //   103: ifnull +9 -> 112
    //   106: aload_0
    //   107: invokeinterface 427 1 0
    //   112: ldc_w 402
    //   115: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_2
    //   119: areturn
    //   120: aload_0
    //   121: ifnull +9 -> 130
    //   124: aload_0
    //   125: invokeinterface 427 1 0
    //   130: ldc_w 402
    //   133: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aconst_null
    //   137: areturn
    //   138: astore_0
    //   139: aload 5
    //   141: astore_0
    //   142: aload_1
    //   143: invokevirtual 433	android/net/Uri:getPath	()Ljava/lang/String;
    //   146: astore_2
    //   147: aload_2
    //   148: astore_1
    //   149: bipush 24
    //   151: invokestatic 439	com/tencent/mm/compatible/util/d:fv	(I)Z
    //   154: ifeq +13 -> 167
    //   157: aload_2
    //   158: ldc_w 441
    //   161: ldc 179
    //   163: invokevirtual 445	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   166: astore_1
    //   167: aload_0
    //   168: ifnull +9 -> 177
    //   171: aload_0
    //   172: invokeinterface 427 1 0
    //   177: ldc_w 402
    //   180: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aload_1
    //   184: areturn
    //   185: astore_1
    //   186: aconst_null
    //   187: astore_0
    //   188: aload_0
    //   189: ifnull +9 -> 198
    //   192: aload_0
    //   193: invokeinterface 427 1 0
    //   198: ldc_w 402
    //   201: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: aload_1
    //   205: athrow
    //   206: astore_1
    //   207: goto -19 -> 188
    //   210: astore_1
    //   211: goto -23 -> 188
    //   214: astore_2
    //   215: goto -73 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	paramContext	Context
    //   0	218	1	paramUri	Uri
    //   0	218	2	paramString	String
    //   0	218	3	paramArrayOfString	String[]
    //   53	42	4	i	int
    //   1	139	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	31	138	java/lang/Exception
    //   9	31	185	finally
    //   35	55	206	finally
    //   61	75	206	finally
    //   93	102	206	finally
    //   142	147	210	finally
    //   149	167	210	finally
    //   35	55	214	java/lang/Exception
    //   61	75	214	java/lang/Exception
    //   93	102	214	java/lang/Exception
  }
  
  public static String a(LinkedHashMap<String, String> paramLinkedHashMap)
  {
    AppMethodBeat.i(52378);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<key>");
    Iterator localIterator = paramLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramLinkedHashMap = (Map.Entry)localIterator.next();
      Object localObject1 = paramLinkedHashMap.getKey();
      Object localObject2 = paramLinkedHashMap.getValue();
      paramLinkedHashMap = (LinkedHashMap<String, String>)localObject1;
      if (localObject1 == null) {
        paramLinkedHashMap = "unknow";
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "unknow";
      }
      localStringBuilder.append("<" + paramLinkedHashMap + ">");
      localStringBuilder.append(localObject1);
      localStringBuilder.append("</" + paramLinkedHashMap + ">");
    }
    localStringBuilder.append("</key>");
    paramLinkedHashMap = localStringBuilder.toString();
    AppMethodBeat.o(52378);
    return paramLinkedHashMap;
  }
  
  public static boolean a(Boolean paramBoolean, boolean paramBoolean1)
  {
    AppMethodBeat.i(52349);
    if (paramBoolean == null)
    {
      AppMethodBeat.o(52349);
      return paramBoolean1;
    }
    paramBoolean1 = paramBoolean.booleanValue();
    AppMethodBeat.o(52349);
    return paramBoolean1;
  }
  
  public static String aJ(float paramFloat)
  {
    AppMethodBeat.i(52419);
    if (paramFloat < 1024.0F)
    {
      str = String.format("%.1fB", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(52419);
      return str;
    }
    if (paramFloat < 1048576.0F)
    {
      str = String.format("%.1fKB", new Object[] { Float.valueOf(paramFloat / 1024.0F) });
      AppMethodBeat.o(52419);
      return str;
    }
    if (paramFloat < 1.073742E+009F)
    {
      str = String.format("%.1fMB", new Object[] { Float.valueOf(paramFloat / 1024.0F / 1024.0F) });
      AppMethodBeat.o(52419);
      return str;
    }
    String str = String.format("%.1fGB", new Object[] { Float.valueOf(paramFloat / 1024.0F / 1024.0F / 1024.0F) });
    AppMethodBeat.o(52419);
    return str;
  }
  
  public static boolean aa(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(52354);
    if ((paramCharSequence == null) || (paramCharSequence.length() <= 0))
    {
      AppMethodBeat.o(52354);
      return true;
    }
    AppMethodBeat.o(52354);
    return false;
  }
  
  public static CharSequence ab(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(52395);
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      if ((c >= '0') && (c <= '9')) {
        localStringBuffer.append(c);
      }
      i += 1;
    }
    paramCharSequence = localStringBuffer.toString();
    AppMethodBeat.o(52395);
    return paramCharSequence;
  }
  
  public static boolean ah(long paramLong1, long paramLong2)
  {
    return paramLong1 == paramLong2;
  }
  
  public static byte[] an(Bitmap paramBitmap)
  {
    AppMethodBeat.i(52309);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    ab.i("MicroMsg.Util", "recycle bitmap:%s", new Object[] { paramBitmap });
    paramBitmap.recycle();
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      AppMethodBeat.o(52309);
      return paramBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Util", localException, "", new Object[0]);
      }
    }
  }
  
  public static long aox()
  {
    AppMethodBeat.i(52322);
    long l = System.currentTimeMillis() / 1000L;
    AppMethodBeat.o(52322);
    return l;
  }
  
  public static long aoy()
  {
    AppMethodBeat.i(156814);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(156814);
    return l;
  }
  
  public static String apD(String paramString)
  {
    AppMethodBeat.i(52294);
    String str = paramString;
    if (paramString != null) {
      str = paramString.replace("../", "");
    }
    AppMethodBeat.o(52294);
    return str;
  }
  
  public static boolean apE(String paramString)
  {
    AppMethodBeat.i(52305);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(52305);
      return false;
    }
    boolean bool = Pattern.compile("[\\u4e00-\\u9fa5]+").matcher(paramString).find();
    AppMethodBeat.o(52305);
    return bool;
  }
  
  public static boolean apF(String paramString)
  {
    AppMethodBeat.i(52306);
    paramString = paramString.toCharArray();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      int k = paramString[i];
      if (((k < 97) || (k > 122)) && ((k < 65) || (k > 90)))
      {
        AppMethodBeat.o(52306);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(52306);
    return true;
  }
  
  public static boolean apG(String paramString)
  {
    AppMethodBeat.i(52307);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(52307);
      return false;
    }
    paramString = paramString.trim();
    try
    {
      long l = Long.valueOf(paramString).longValue();
      if ((l > 0L) && (l <= 4294967295L))
      {
        AppMethodBeat.o(52307);
        return true;
      }
    }
    catch (NumberFormatException paramString)
    {
      ab.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(52307);
      return false;
    }
    AppMethodBeat.o(52307);
    return false;
  }
  
  public static boolean apH(String paramString)
  {
    AppMethodBeat.i(52308);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(52308);
      return false;
    }
    boolean bool = paramString.trim().matches("^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$");
    AppMethodBeat.o(52308);
    return bool;
  }
  
  public static boolean apI(String paramString)
  {
    AppMethodBeat.i(52310);
    if (paramString == null)
    {
      AppMethodBeat.o(52310);
      return false;
    }
    paramString = paramString.trim();
    if ((paramString.length() < 6) || (paramString.length() > 20))
    {
      AppMethodBeat.o(52310);
      return false;
    }
    if (!C(paramString.charAt(0)))
    {
      AppMethodBeat.o(52310);
      return false;
    }
    int i = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if ((!C(c)) && (!D(c)) && (c != '-') && (c != '_'))
      {
        AppMethodBeat.o(52310);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(52310);
    return true;
  }
  
  public static boolean apJ(String paramString)
  {
    AppMethodBeat.i(52311);
    if (paramString == null)
    {
      AppMethodBeat.o(52311);
      return false;
    }
    if (paramString.length() < 8)
    {
      AppMethodBeat.o(52311);
      return false;
    }
    try
    {
      Long.parseLong(paramString);
      AppMethodBeat.o(52311);
      return false;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(52311);
    }
    return true;
  }
  
  public static int apK(String paramString)
  {
    AppMethodBeat.i(52356);
    if (paramString == null)
    {
      AppMethodBeat.o(52356);
      return -1;
    }
    int i = paramString.length();
    AppMethodBeat.o(52356);
    return i;
  }
  
  public static int apL(String paramString)
  {
    AppMethodBeat.i(52357);
    if (paramString == null)
    {
      AppMethodBeat.o(52357);
      return -1;
    }
    int i = paramString.getBytes(Charset.forName("UTF-8")).length;
    AppMethodBeat.o(52357);
    return i;
  }
  
  public static int apM(String paramString)
  {
    AppMethodBeat.i(52358);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(52358);
      return 0;
    }
    try
    {
      long l = new SimpleDateFormat("yyyy-MM-dd").parse(paramString).getTime() / 1000L;
      int i = (int)l;
      AppMethodBeat.o(52358);
      return i;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(52358);
    }
    return 0;
  }
  
  public static int apN(String paramString)
  {
    AppMethodBeat.i(52365);
    if (paramString == null)
    {
      AppMethodBeat.o(52365);
      return 0;
    }
    try
    {
      long l = Long.decode(paramString).longValue();
      int i = (int)(l & 0xFFFFFFFF);
      AppMethodBeat.o(52365);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      ab.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(52365);
    }
    return 0;
  }
  
  public static String apO(String paramString)
  {
    AppMethodBeat.i(52367);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (str.length() <= 16)
    {
      paramString = g.w(str.getBytes());
      AppMethodBeat.o(52367);
      return paramString;
    }
    paramString = g.w(str.substring(0, 16).getBytes());
    AppMethodBeat.o(52367);
    return paramString;
  }
  
  public static String apP(String paramString)
  {
    AppMethodBeat.i(156812);
    paramString = g.w(paramString.getBytes());
    AppMethodBeat.o(156812);
    return paramString;
  }
  
  public static byte[] apQ(String paramString)
  {
    AppMethodBeat.i(52370);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(52370);
      return new byte[0];
    }
    try
    {
      byte[] arrayOfByte = new byte[paramString.length() / 2];
      int i = 0;
      while (i < arrayOfByte.length)
      {
        arrayOfByte[i] = ((byte)(Integer.parseInt(paramString.substring(i * 2, i * 2 + 2), 16) & 0xFF));
        i += 1;
      }
      AppMethodBeat.o(52370);
      return arrayOfByte;
    }
    catch (NumberFormatException paramString)
    {
      ab.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(52370);
    }
    return new byte[0];
  }
  
  public static int[] apR(String paramString)
  {
    AppMethodBeat.i(52371);
    if (paramString == null)
    {
      AppMethodBeat.o(52371);
      return null;
    }
    Object localObject = paramString.split(":");
    paramString = new ArrayList();
    int j = localObject.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = localObject[i];
        if ((str != null) && (str.length() > 0)) {}
        try
        {
          paramString.add(Integer.valueOf(Integer.valueOf(str).intValue()));
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.Util", localException, "", new Object[0]);
            ab.e("MicroMsg.Util", "invalid port num, ignore");
          }
        }
      }
    }
    localObject = new int[paramString.size()];
    i = 0;
    while (i < localObject.length)
    {
      localObject[i] = ((Integer)paramString.get(i)).intValue();
      i += 1;
    }
    AppMethodBeat.o(52371);
    return localObject;
  }
  
  public static final String apS(String paramString)
  {
    AppMethodBeat.i(52373);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(52373);
      return "";
    }
    try
    {
      String str = new URL(paramString).getHost();
      AppMethodBeat.o(52373);
      return str;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      ab.printErrStackTrace("MicroMsg.Util", localMalformedURLException, "", new Object[0]);
      ab.w("MicroMsg.Util", "get host error");
      AppMethodBeat.o(52373);
    }
    return paramString;
  }
  
  public static String apT(String paramString)
  {
    AppMethodBeat.i(52375);
    if (paramString == null)
    {
      AppMethodBeat.o(52375);
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int n = paramString.length();
    int j = 0;
    if (j < n)
    {
      char c = paramString.charAt(j);
      int m = 1;
      int k = iXA.length - 1;
      for (;;)
      {
        int i = m;
        if (k >= 0)
        {
          if (iXA[k] == c)
          {
            localStringBuffer.append(iXB[k]);
            i = 0;
          }
        }
        else
        {
          k = i;
          if (j == n - 1)
          {
            k = i;
            if (Character.isHighSurrogate(c)) {
              k = 0;
            }
          }
          if (k != 0) {
            localStringBuffer.append(c);
          }
          j += 1;
          break;
        }
        k -= 1;
      }
    }
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(52375);
    return paramString;
  }
  
  public static String apU(String paramString)
  {
    AppMethodBeat.i(52376);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(52376);
      return paramString;
    }
    char[] arrayOfChar;
    int k;
    int m;
    int j;
    char c;
    int i;
    if (Build.VERSION.SDK_INT < 8)
    {
      int n = paramString.length();
      arrayOfChar = new char[n];
      k = 0;
      m = 0;
      j = -1;
      if (k < n)
      {
        c = paramString.charAt(k);
        i = m + 1;
        arrayOfChar[m] = c;
        if ((c == '&') && (j == -1))
        {
          m = i;
          j = i;
          i = m;
        }
      }
    }
    for (;;)
    {
      k += 1;
      m = i;
      break;
      if ((j != -1) && (!Character.isLetter(c)) && (!Character.isDigit(c)) && (c != '#'))
      {
        if (c == ';')
        {
          m = a(arrayOfChar, j, i - j - 1);
          if (m > 65535)
          {
            i = m - 65536;
            arrayOfChar[(j - 1)] = ((char)((i >> 10) + 55296));
            arrayOfChar[j] = ((char)((i & 0x3FF) + 56320));
            j += 1;
          }
        }
        for (;;)
        {
          i = j;
          j = -1;
          break;
          if (m != 0)
          {
            arrayOfChar[(j - 1)] = ((char)m);
            continue;
            j = -1;
            break;
            paramString = new String(arrayOfChar, 0, m);
            AppMethodBeat.o(52376);
            return paramString;
            AppMethodBeat.o(52376);
            return paramString;
          }
          j = i;
        }
      }
    }
  }
  
  public static int apV(String paramString)
  {
    AppMethodBeat.i(52379);
    int j = 0;
    try
    {
      i = Integer.parseInt(paramString);
      AppMethodBeat.o(52379);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = j;
        if (paramString != null)
        {
          ab.e("MicroMsg.Util", "parserInt error ".concat(String.valueOf(paramString)));
          i = j;
        }
      }
    }
  }
  
  public static long apW(String paramString)
  {
    AppMethodBeat.i(52380);
    long l2 = 0L;
    try
    {
      l1 = Long.parseLong(paramString);
      AppMethodBeat.o(52380);
      return l1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = l2;
        if (paramString != null)
        {
          ab.e("MicroMsg.Util", "parseLong error ".concat(String.valueOf(paramString)));
          l1 = l2;
        }
      }
    }
  }
  
  public static double apX(String paramString)
  {
    AppMethodBeat.i(52381);
    double d2 = 0.0D;
    try
    {
      d1 = Double.parseDouble(paramString);
      AppMethodBeat.o(52381);
      return d1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        double d1 = d2;
        if (paramString != null)
        {
          ab.e("MicroMsg.Util", "parseDouble error ".concat(String.valueOf(paramString)));
          d1 = d2;
        }
      }
    }
  }
  
  public static float apY(String paramString)
  {
    AppMethodBeat.i(52382);
    float f2 = 0.0F;
    try
    {
      f1 = Float.parseFloat(paramString);
      AppMethodBeat.o(52382);
      return f1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        float f1 = f2;
        if (paramString != null)
        {
          ab.e("MicroMsg.Util", "parseFloat error ".concat(String.valueOf(paramString)));
          f1 = f2;
        }
      }
    }
  }
  
  public static byte[] apZ(String paramString)
  {
    AppMethodBeat.i(52391);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.Util", "httpGet, url is null");
      AppMethodBeat.o(52391);
      return null;
    }
    if (URLUtil.isDataUrl(paramString))
    {
      paramString = aqc(paramString);
      AppMethodBeat.o(52391);
      return paramString;
    }
    if (URLUtil.isHttpsUrl(paramString))
    {
      paramString = aqb(paramString);
      AppMethodBeat.o(52391);
      return paramString;
    }
    paramString = aqa(paramString);
    AppMethodBeat.o(52391);
    return paramString;
  }
  
  /* Error */
  private static byte[] aqa(String paramString)
  {
    // Byte code:
    //   0: ldc_w 798
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 717	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 718	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 802	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 804	java/net/HttpURLConnection
    //   20: astore_0
    //   21: aload_0
    //   22: ldc_w 806
    //   25: invokevirtual 809	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: invokevirtual 812	java/net/HttpURLConnection:getResponseCode	()I
    //   32: istore_1
    //   33: iload_1
    //   34: sipush 200
    //   37: if_icmpeq +46 -> 83
    //   40: ldc 177
    //   42: ldc_w 814
    //   45: iconst_1
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: iload_1
    //   52: invokestatic 708	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: invokestatic 816	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aconst_null
    //   60: invokestatic 820	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   63: aconst_null
    //   64: invokestatic 820	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   67: aload_0
    //   68: ifnull +7 -> 75
    //   71: aload_0
    //   72: invokevirtual 823	java/net/HttpURLConnection:disconnect	()V
    //   75: ldc_w 798
    //   78: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aconst_null
    //   82: areturn
    //   83: new 825	java/io/BufferedInputStream
    //   86: dup
    //   87: aload_0
    //   88: invokevirtual 829	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   91: invokespecial 832	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   94: astore 4
    //   96: new 546	java/io/ByteArrayOutputStream
    //   99: dup
    //   100: invokespecial 547	java/io/ByteArrayOutputStream:<init>	()V
    //   103: astore_2
    //   104: sipush 4096
    //   107: newarray byte
    //   109: astore_3
    //   110: aload 4
    //   112: aload_3
    //   113: invokevirtual 833	java/io/BufferedInputStream:read	([B)I
    //   116: istore_1
    //   117: iload_1
    //   118: ifle +20 -> 138
    //   121: aload_2
    //   122: aload_3
    //   123: iconst_0
    //   124: iload_1
    //   125: invokevirtual 836	java/io/ByteArrayOutputStream:write	([BII)V
    //   128: aload 4
    //   130: aload_3
    //   131: invokevirtual 833	java/io/BufferedInputStream:read	([B)I
    //   134: istore_1
    //   135: goto -18 -> 117
    //   138: aload_2
    //   139: invokevirtual 570	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   142: astore_3
    //   143: aload 4
    //   145: invokestatic 820	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   148: aload_2
    //   149: invokestatic 820	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   152: aload_0
    //   153: ifnull +7 -> 160
    //   156: aload_0
    //   157: invokevirtual 823	java/net/HttpURLConnection:disconnect	()V
    //   160: ldc_w 798
    //   163: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_3
    //   167: areturn
    //   168: astore_0
    //   169: aconst_null
    //   170: astore_2
    //   171: aconst_null
    //   172: astore 4
    //   174: aconst_null
    //   175: astore_3
    //   176: ldc 177
    //   178: ldc_w 838
    //   181: iconst_1
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload_0
    //   188: invokevirtual 841	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   191: aastore
    //   192: invokestatic 816	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: aload 4
    //   197: invokestatic 820	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   200: aload_2
    //   201: invokestatic 820	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   204: aload_3
    //   205: ifnull +7 -> 212
    //   208: aload_3
    //   209: invokevirtual 823	java/net/HttpURLConnection:disconnect	()V
    //   212: ldc_w 798
    //   215: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: aconst_null
    //   219: areturn
    //   220: astore_0
    //   221: aconst_null
    //   222: astore_2
    //   223: aconst_null
    //   224: astore 4
    //   226: aconst_null
    //   227: astore_3
    //   228: aload 4
    //   230: invokestatic 820	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   233: aload_2
    //   234: invokestatic 820	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   237: aload_3
    //   238: ifnull +7 -> 245
    //   241: aload_3
    //   242: invokevirtual 823	java/net/HttpURLConnection:disconnect	()V
    //   245: ldc_w 798
    //   248: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: aload_0
    //   252: athrow
    //   253: astore 5
    //   255: aconst_null
    //   256: astore_2
    //   257: aconst_null
    //   258: astore 4
    //   260: aload_0
    //   261: astore_3
    //   262: aload 5
    //   264: astore_0
    //   265: goto -37 -> 228
    //   268: astore 5
    //   270: aconst_null
    //   271: astore_2
    //   272: aload_0
    //   273: astore_3
    //   274: aload 5
    //   276: astore_0
    //   277: goto -49 -> 228
    //   280: astore 5
    //   282: aload_0
    //   283: astore_3
    //   284: aload 5
    //   286: astore_0
    //   287: goto -59 -> 228
    //   290: astore_0
    //   291: goto -63 -> 228
    //   294: astore 5
    //   296: aconst_null
    //   297: astore_2
    //   298: aconst_null
    //   299: astore 4
    //   301: aload_0
    //   302: astore_3
    //   303: aload 5
    //   305: astore_0
    //   306: goto -130 -> 176
    //   309: astore 5
    //   311: aconst_null
    //   312: astore_2
    //   313: aload_0
    //   314: astore_3
    //   315: aload 5
    //   317: astore_0
    //   318: goto -142 -> 176
    //   321: astore 5
    //   323: aload_0
    //   324: astore_3
    //   325: aload 5
    //   327: astore_0
    //   328: goto -152 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	paramString	String
    //   32	103	1	i	int
    //   103	210	2	localByteArrayOutputStream	ByteArrayOutputStream
    //   109	216	3	localObject1	Object
    //   94	206	4	localBufferedInputStream	java.io.BufferedInputStream
    //   253	10	5	localObject2	Object
    //   268	7	5	localObject3	Object
    //   280	5	5	localObject4	Object
    //   294	10	5	localException1	Exception
    //   309	7	5	localException2	Exception
    //   321	5	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   6	21	168	java/lang/Exception
    //   6	21	220	finally
    //   21	33	253	finally
    //   40	59	253	finally
    //   83	96	253	finally
    //   96	104	268	finally
    //   104	117	280	finally
    //   121	135	280	finally
    //   138	143	280	finally
    //   176	195	290	finally
    //   21	33	294	java/lang/Exception
    //   40	59	294	java/lang/Exception
    //   83	96	294	java/lang/Exception
    //   96	104	309	java/lang/Exception
    //   104	117	321	java/lang/Exception
    //   121	135	321	java/lang/Exception
    //   138	143	321	java/lang/Exception
  }
  
  /* Error */
  private static byte[] aqb(String paramString)
  {
    // Byte code:
    //   0: ldc_w 842
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 717	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 718	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 802	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 844	javax/net/ssl/HttpsURLConnection
    //   20: astore_0
    //   21: aload_0
    //   22: ldc_w 806
    //   25: invokevirtual 809	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: invokevirtual 812	java/net/HttpURLConnection:getResponseCode	()I
    //   32: istore_1
    //   33: iload_1
    //   34: sipush 200
    //   37: if_icmpeq +46 -> 83
    //   40: ldc 177
    //   42: ldc_w 846
    //   45: iconst_1
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: iload_1
    //   52: invokestatic 708	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: invokestatic 816	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aconst_null
    //   60: invokestatic 820	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   63: aconst_null
    //   64: invokestatic 820	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   67: aload_0
    //   68: ifnull +7 -> 75
    //   71: aload_0
    //   72: invokevirtual 823	java/net/HttpURLConnection:disconnect	()V
    //   75: ldc_w 842
    //   78: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aconst_null
    //   82: areturn
    //   83: new 825	java/io/BufferedInputStream
    //   86: dup
    //   87: aload_0
    //   88: invokevirtual 829	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   91: invokespecial 832	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   94: astore 4
    //   96: new 546	java/io/ByteArrayOutputStream
    //   99: dup
    //   100: invokespecial 547	java/io/ByteArrayOutputStream:<init>	()V
    //   103: astore_2
    //   104: sipush 4096
    //   107: newarray byte
    //   109: astore_3
    //   110: aload 4
    //   112: aload_3
    //   113: invokevirtual 833	java/io/BufferedInputStream:read	([B)I
    //   116: istore_1
    //   117: iload_1
    //   118: ifle +20 -> 138
    //   121: aload_2
    //   122: aload_3
    //   123: iconst_0
    //   124: iload_1
    //   125: invokevirtual 836	java/io/ByteArrayOutputStream:write	([BII)V
    //   128: aload 4
    //   130: aload_3
    //   131: invokevirtual 833	java/io/BufferedInputStream:read	([B)I
    //   134: istore_1
    //   135: goto -18 -> 117
    //   138: aload_2
    //   139: invokevirtual 570	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   142: astore_3
    //   143: aload 4
    //   145: invokevirtual 847	java/io/BufferedInputStream:close	()V
    //   148: aload_2
    //   149: invokevirtual 571	java/io/ByteArrayOutputStream:close	()V
    //   152: aload 4
    //   154: invokestatic 820	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   157: aload_2
    //   158: invokestatic 820	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   161: aload_0
    //   162: ifnull +7 -> 169
    //   165: aload_0
    //   166: invokevirtual 823	java/net/HttpURLConnection:disconnect	()V
    //   169: ldc_w 842
    //   172: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: aload_3
    //   176: areturn
    //   177: astore_0
    //   178: aconst_null
    //   179: astore_2
    //   180: aconst_null
    //   181: astore 4
    //   183: aconst_null
    //   184: astore_3
    //   185: ldc 177
    //   187: ldc_w 849
    //   190: iconst_1
    //   191: anewarray 4	java/lang/Object
    //   194: dup
    //   195: iconst_0
    //   196: aload_0
    //   197: invokevirtual 841	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   200: aastore
    //   201: invokestatic 816	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: aload 4
    //   206: invokestatic 820	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   209: aload_2
    //   210: invokestatic 820	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   213: aload_3
    //   214: ifnull +7 -> 221
    //   217: aload_3
    //   218: invokevirtual 823	java/net/HttpURLConnection:disconnect	()V
    //   221: ldc_w 842
    //   224: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: aconst_null
    //   228: areturn
    //   229: astore_0
    //   230: aconst_null
    //   231: astore_2
    //   232: aconst_null
    //   233: astore 4
    //   235: aconst_null
    //   236: astore_3
    //   237: aload 4
    //   239: invokestatic 820	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   242: aload_2
    //   243: invokestatic 820	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   246: aload_3
    //   247: ifnull +7 -> 254
    //   250: aload_3
    //   251: invokevirtual 823	java/net/HttpURLConnection:disconnect	()V
    //   254: ldc_w 842
    //   257: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: aload_0
    //   261: athrow
    //   262: astore 5
    //   264: aconst_null
    //   265: astore_2
    //   266: aconst_null
    //   267: astore 4
    //   269: aload_0
    //   270: astore_3
    //   271: aload 5
    //   273: astore_0
    //   274: goto -37 -> 237
    //   277: astore 5
    //   279: aconst_null
    //   280: astore_2
    //   281: aload_0
    //   282: astore_3
    //   283: aload 5
    //   285: astore_0
    //   286: goto -49 -> 237
    //   289: astore 5
    //   291: aload_0
    //   292: astore_3
    //   293: aload 5
    //   295: astore_0
    //   296: goto -59 -> 237
    //   299: astore_0
    //   300: goto -63 -> 237
    //   303: astore 5
    //   305: aconst_null
    //   306: astore_2
    //   307: aconst_null
    //   308: astore 4
    //   310: aload_0
    //   311: astore_3
    //   312: aload 5
    //   314: astore_0
    //   315: goto -130 -> 185
    //   318: astore 5
    //   320: aconst_null
    //   321: astore_2
    //   322: aload_0
    //   323: astore_3
    //   324: aload 5
    //   326: astore_0
    //   327: goto -142 -> 185
    //   330: astore 5
    //   332: aload_0
    //   333: astore_3
    //   334: aload 5
    //   336: astore_0
    //   337: goto -152 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	paramString	String
    //   32	103	1	i	int
    //   103	219	2	localByteArrayOutputStream	ByteArrayOutputStream
    //   109	225	3	localObject1	Object
    //   94	215	4	localBufferedInputStream	java.io.BufferedInputStream
    //   262	10	5	localObject2	Object
    //   277	7	5	localObject3	Object
    //   289	5	5	localObject4	Object
    //   303	10	5	localException1	Exception
    //   318	7	5	localException2	Exception
    //   330	5	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   6	21	177	java/lang/Exception
    //   6	21	229	finally
    //   21	33	262	finally
    //   40	59	262	finally
    //   83	96	262	finally
    //   96	104	277	finally
    //   104	117	289	finally
    //   121	135	289	finally
    //   138	152	289	finally
    //   185	204	299	finally
    //   21	33	303	java/lang/Exception
    //   40	59	303	java/lang/Exception
    //   83	96	303	java/lang/Exception
    //   96	104	318	java/lang/Exception
    //   104	117	330	java/lang/Exception
    //   121	135	330	java/lang/Exception
    //   138	152	330	java/lang/Exception
  }
  
  private static byte[] aqc(String paramString)
  {
    AppMethodBeat.i(52394);
    try
    {
      int i = paramString.indexOf("base64");
      String str = paramString;
      if (i > 0) {
        str = paramString.substring(i + 7);
      }
      paramString = Base64.decode(str, 0);
      AppMethodBeat.o(52394);
      return paramString;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.Util", "decode base64 url failed : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(52394);
    }
    return null;
  }
  
  public static String aqd(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(52397);
    if ((isNullOrNil(paramString)) || (paramString.startsWith("+")))
    {
      AppMethodBeat.o(52397);
      return "";
    }
    if (paramString.length() > 5)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramString.subSequence(0, 3));
      if (i < paramString.length() - 5)
      {
        char c = paramString.charAt(i + 3);
        if ((c >= '0') && (c <= '9')) {
          localStringBuffer.append('*');
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuffer.append(c);
        }
      }
      localStringBuffer.append(paramString.charAt(paramString.length() - 2));
      localStringBuffer.append(paramString.charAt(paramString.length() - 1));
      paramString = localStringBuffer.toString();
      AppMethodBeat.o(52397);
      return paramString;
    }
    AppMethodBeat.o(52397);
    return paramString;
  }
  
  public static Boolean aqe(String paramString)
  {
    AppMethodBeat.i(52398);
    Matcher localMatcher = Pattern.compile("^[+][0-9]{10,13}$").matcher(paramString);
    paramString = Pattern.compile("^1[0-9]{10}$").matcher(paramString);
    if ((localMatcher.matches()) || (paramString.matches())) {}
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(52398);
      return Boolean.valueOf(bool);
    }
  }
  
  public static String aqf(String paramString)
  {
    AppMethodBeat.i(52400);
    if ((paramString != null) && (paramString.length() > 0))
    {
      int i = paramString.lastIndexOf("@");
      if (i != -1)
      {
        paramString = paramString.substring(0, i);
        AppMethodBeat.o(52400);
        return paramString;
      }
    }
    AppMethodBeat.o(52400);
    return paramString;
  }
  
  public static String aqg(String paramString)
  {
    AppMethodBeat.i(52401);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(52401);
      return "";
    }
    int i = paramString.length();
    if (i < 4)
    {
      paramString = "*~".concat(String.valueOf(i));
      AppMethodBeat.o(52401);
      return paramString;
    }
    if (i < 8)
    {
      paramString = paramString.substring(0, 1) + "*" + paramString.substring(i - 2, i - 1) + "~" + i;
      AppMethodBeat.o(52401);
      return paramString;
    }
    paramString = paramString.substring(0, 2) + "*" + paramString.substring(i - 3, i - 1) + "~" + i;
    AppMethodBeat.o(52401);
    return paramString;
  }
  
  public static boolean aqh(String paramString)
  {
    AppMethodBeat.i(52407);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(52407);
      return false;
    }
    try
    {
      paramString = new File(paramString).getCanonicalPath();
      if (paramString.contains("/com.tencent.mm/cache/"))
      {
        AppMethodBeat.o(52407);
        return true;
      }
    }
    catch (IOException paramString)
    {
      AppMethodBeat.o(52407);
      return false;
    }
    if (!paramString.contains("/com.tencent.mm/"))
    {
      AppMethodBeat.o(52407);
      return true;
    }
    AppMethodBeat.o(52407);
    return false;
  }
  
  public static boolean aqi(String paramString)
  {
    AppMethodBeat.i(52408);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(52408);
      return false;
    }
    int i = paramString.lastIndexOf(".");
    if (i == -1)
    {
      AppMethodBeat.o(52408);
      return false;
    }
    boolean bool = aqj(paramString.substring(i + 1));
    AppMethodBeat.o(52408);
    return bool;
  }
  
  public static boolean aqj(String paramString)
  {
    AppMethodBeat.i(52409);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(52409);
      return false;
    }
    paramString = paramString.toLowerCase();
    if ((paramString.equals("webp")) && (Build.VERSION.SDK_INT >= 14))
    {
      AppMethodBeat.o(52409);
      return true;
    }
    if ((paramString.equals("heic")) && (Build.VERSION.SDK_INT >= 28))
    {
      AppMethodBeat.o(52409);
      return true;
    }
    if ((paramString.equals("jpg")) || (paramString.equals("gif")) || (paramString.equals("bmp")) || (paramString.equals("jpeg")) || (paramString.equals("png")))
    {
      AppMethodBeat.o(52409);
      return true;
    }
    AppMethodBeat.o(52409);
    return false;
  }
  
  public static String aqk(String paramString)
  {
    AppMethodBeat.i(52420);
    if (paramString == null)
    {
      AppMethodBeat.o(52420);
      return null;
    }
    int i = paramString.length();
    while (i > 0)
    {
      if ((paramString.charAt(i - 1) != '\n') && (paramString.charAt(i - 1) != '\r'))
      {
        paramString = paramString.substring(0, i);
        AppMethodBeat.o(52420);
        return paramString;
      }
      i -= 1;
    }
    AppMethodBeat.o(52420);
    return paramString;
  }
  
  public static String aql(String paramString)
  {
    AppMethodBeat.i(52425);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(52425);
      return paramString;
    }
    paramString = paramString.replaceAll("‮", "");
    AppMethodBeat.o(52425);
    return paramString;
  }
  
  public static final String aqm(String paramString)
  {
    AppMethodBeat.i(52427);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(52427);
      return null;
    }
    paramString = Uri.parse(paramString).getHost();
    AppMethodBeat.o(52427);
    return paramString;
  }
  
  public static long av(long paramLong)
  {
    AppMethodBeat.i(52325);
    long l = SystemClock.elapsedRealtime();
    AppMethodBeat.o(52325);
    return l - paramLong;
  }
  
  public static ActivityManager.RunningTaskInfo ay(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(52413);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1000).iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningTaskInfo localRunningTaskInfo = (ActivityManager.RunningTaskInfo)paramContext.next();
      if (localRunningTaskInfo.id == paramInt)
      {
        AppMethodBeat.o(52413);
        return localRunningTaskInfo;
      }
    }
    AppMethodBeat.o(52413);
    return null;
  }
  
  /* Error */
  public static String az(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 994
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +7 -> 14
    //   10: iload_1
    //   11: ifgt +12 -> 23
    //   14: ldc_w 994
    //   17: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: ldc 179
    //   22: areturn
    //   23: aload_0
    //   24: ldc_w 975
    //   27: invokevirtual 979	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   30: checkcast 981	android/app/ActivityManager
    //   33: invokevirtual 998	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   36: invokeinterface 986 1 0
    //   41: astore_0
    //   42: aload_0
    //   43: invokeinterface 472 1 0
    //   48: ifeq +71 -> 119
    //   51: aload_0
    //   52: invokeinterface 476 1 0
    //   57: checkcast 1000	android/app/ActivityManager$RunningAppProcessInfo
    //   60: astore 4
    //   62: aload 4
    //   64: getfield 1003	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   67: iload_1
    //   68: if_icmpne -26 -> 42
    //   71: aload 4
    //   73: getfield 1006	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   76: ifnull -34 -> 42
    //   79: aload 4
    //   81: getfield 1006	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   84: ldc 179
    //   86: invokevirtual 941	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   89: ifne -47 -> 42
    //   92: aload 4
    //   94: getfield 1006	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   97: astore_0
    //   98: ldc_w 994
    //   101: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_0
    //   105: areturn
    //   106: astore_0
    //   107: ldc 177
    //   109: aload_0
    //   110: ldc 179
    //   112: iconst_0
    //   113: anewarray 4	java/lang/Object
    //   116: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: sipush 128
    //   122: newarray byte
    //   124: astore 5
    //   126: new 1008	java/io/FileInputStream
    //   129: dup
    //   130: new 449	java/lang/StringBuilder
    //   133: dup
    //   134: ldc_w 1010
    //   137: invokespecial 491	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   140: iload_1
    //   141: invokevirtual 910	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: ldc_w 1012
    //   147: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 497	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokespecial 1013	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   156: astore 4
    //   158: aload 4
    //   160: astore_0
    //   161: aload 4
    //   163: aload 5
    //   165: invokevirtual 1014	java/io/FileInputStream:read	([B)I
    //   168: istore_3
    //   169: iload_3
    //   170: ifle +45 -> 215
    //   173: iconst_0
    //   174: istore_1
    //   175: goto +135 -> 310
    //   178: aload 4
    //   180: astore_0
    //   181: new 74	java/lang/String
    //   184: dup
    //   185: aload 5
    //   187: iconst_0
    //   188: iload_2
    //   189: invokespecial 164	java/lang/String:<init>	([BII)V
    //   192: astore 5
    //   194: aload 4
    //   196: invokevirtual 1015	java/io/FileInputStream:close	()V
    //   199: ldc_w 994
    //   202: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: aload 5
    //   207: areturn
    //   208: iload_1
    //   209: iconst_1
    //   210: iadd
    //   211: istore_1
    //   212: goto +98 -> 310
    //   215: aload 4
    //   217: invokevirtual 1015	java/io/FileInputStream:close	()V
    //   220: ldc_w 994
    //   223: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: ldc 179
    //   228: areturn
    //   229: astore 5
    //   231: aconst_null
    //   232: astore 4
    //   234: aload 4
    //   236: astore_0
    //   237: ldc 177
    //   239: aload 5
    //   241: ldc 179
    //   243: iconst_0
    //   244: anewarray 4	java/lang/Object
    //   247: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   250: aload 4
    //   252: ifnull -32 -> 220
    //   255: aload 4
    //   257: invokevirtual 1015	java/io/FileInputStream:close	()V
    //   260: goto -40 -> 220
    //   263: astore_0
    //   264: goto -44 -> 220
    //   267: astore 4
    //   269: aconst_null
    //   270: astore_0
    //   271: aload_0
    //   272: ifnull +7 -> 279
    //   275: aload_0
    //   276: invokevirtual 1015	java/io/FileInputStream:close	()V
    //   279: ldc_w 994
    //   282: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: aload 4
    //   287: athrow
    //   288: astore_0
    //   289: goto -90 -> 199
    //   292: astore_0
    //   293: goto -73 -> 220
    //   296: astore_0
    //   297: goto -18 -> 279
    //   300: astore 4
    //   302: goto -31 -> 271
    //   305: astore 5
    //   307: goto -73 -> 234
    //   310: iload_3
    //   311: istore_2
    //   312: iload_1
    //   313: iload_3
    //   314: if_icmpge -136 -> 178
    //   317: aload 5
    //   319: iload_1
    //   320: baload
    //   321: sipush 128
    //   324: if_icmpgt +10 -> 334
    //   327: aload 5
    //   329: iload_1
    //   330: baload
    //   331: ifgt -123 -> 208
    //   334: iload_1
    //   335: istore_2
    //   336: goto -158 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	paramContext	Context
    //   0	339	1	paramInt	int
    //   188	148	2	i	int
    //   168	147	3	j	int
    //   60	196	4	localObject1	Object
    //   267	19	4	localObject2	Object
    //   300	1	4	localObject3	Object
    //   124	82	5	localObject4	Object
    //   229	11	5	localException1	Exception
    //   305	23	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   23	42	106	java/lang/Exception
    //   42	98	106	java/lang/Exception
    //   126	158	229	java/lang/Exception
    //   255	260	263	java/lang/Exception
    //   126	158	267	finally
    //   194	199	288	java/lang/Exception
    //   215	220	292	java/lang/Exception
    //   275	279	296	java/lang/Exception
    //   161	169	300	finally
    //   181	194	300	finally
    //   237	250	300	finally
    //   161	169	305	java/lang/Exception
    //   181	194	305	java/lang/Exception
  }
  
  public static String b(long paramLong, double paramDouble)
  {
    AppMethodBeat.i(52313);
    paramDouble = Math.round(paramLong * paramDouble / 1048576.0D) / paramDouble;
    String str = paramDouble + " MB";
    AppMethodBeat.o(52313);
    return str;
  }
  
  public static void b(Closeable paramCloseable)
  {
    AppMethodBeat.i(52422);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(52422);
      return;
    }
    catch (IOException paramCloseable)
    {
      ab.printErrStackTrace("MicroMsg.Util", paramCloseable, "qualityClose", new Object[0]);
      AppMethodBeat.o(52422);
    }
  }
  
  public static boolean bG(Context paramContext, String paramString)
  {
    AppMethodBeat.i(52336);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647).iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)paramContext.next();
      if ((localRunningServiceInfo != null) && (localRunningServiceInfo.service != null) && (localRunningServiceInfo.service.getClassName().toString().equals(paramString)))
      {
        ab.w("MicroMsg.Util", "service " + paramString + " is running");
        AppMethodBeat.o(52336);
        return true;
      }
    }
    ab.w("MicroMsg.Util", "service " + paramString + " is not running");
    AppMethodBeat.o(52336);
    return false;
  }
  
  public static boolean bH(Context paramContext, String paramString)
  {
    AppMethodBeat.i(52337);
    try
    {
      if ((paramString.equals("com.tencent.mm")) || (paramString.startsWith("com.tencent.mm:")) || (Build.VERSION.SDK_INT < 21))
      {
        ab.i("MicroMsg.Util", "isProcessRunning, use ActivityManager. process = %s", new Object[] { paramString });
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        if (paramContext == null)
        {
          AppMethodBeat.o(52337);
          return false;
        }
        paramContext = paramContext.iterator();
      }
      while (paramContext.hasNext())
      {
        Object localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if ((localObject != null) && (((ActivityManager.RunningAppProcessInfo)localObject).processName != null) && (((ActivityManager.RunningAppProcessInfo)localObject).processName.equals(paramString)))
        {
          ab.w("MicroMsg.Util", "process " + paramString + " is running");
          AppMethodBeat.o(52337);
          return true;
          ab.i("MicroMsg.Util", "isProcessRunning, use ps command. process = %s", new Object[] { paramString });
          paramContext = dua().iterator();
          while (paramContext.hasNext())
          {
            localObject = (String)paramContext.next();
            ab.d("MicroMsg.Util", "isProcessRunning, process command line = %s", new Object[] { localObject });
            if ((localObject != null) && (((String)localObject).contains(paramString)))
            {
              localObject = ((String)localObject).split("\\s+");
              int i = 0;
              while (i < localObject.length)
              {
                if (paramString.equals(localObject[i]))
                {
                  ab.i("MicroMsg.Util", "process %s is running", new Object[] { paramString });
                  AppMethodBeat.o(52337);
                  return true;
                }
                i += 1;
              }
            }
          }
        }
      }
      ab.w("MicroMsg.Util", "process " + paramString + " is not running");
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Util", paramContext, "", new Object[0]);
      }
    }
    AppMethodBeat.o(52337);
    return false;
  }
  
  public static int bS(String paramString, int paramInt)
  {
    AppMethodBeat.i(52436);
    try
    {
      int i = Color.parseColor(paramString);
      AppMethodBeat.o(52436);
      return i;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.Util", localException, "colorString:%s", new Object[] { paramString });
      AppMethodBeat.o(52436);
    }
    return paramInt;
  }
  
  public static String bf(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2;
    }
    return paramString1;
  }
  
  public static int bg(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(52426);
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte.order(ByteOrder.nativeOrder());
    int i = paramArrayOfByte.getInt();
    AppMethodBeat.o(52426);
    return i;
  }
  
  public static long c(Long paramLong)
  {
    AppMethodBeat.i(52344);
    if (paramLong == null)
    {
      AppMethodBeat.o(52344);
      return 0L;
    }
    long l = paramLong.longValue();
    AppMethodBeat.o(52344);
    return l;
  }
  
  public static String c(long paramLong, double paramDouble)
  {
    AppMethodBeat.i(52315);
    paramDouble = Math.round(paramLong * paramDouble / 1073741824.0D) / paramDouble;
    String str = paramDouble + " GB";
    AppMethodBeat.o(52315);
    return str;
  }
  
  public static boolean cB(Context paramContext)
  {
    AppMethodBeat.i(52335);
    String str = paramContext.getClass().getName();
    paramContext = ch(paramContext);
    ab.d("MicroMsg.Util", "top activity=" + paramContext + ", context=" + str);
    boolean bool = paramContext.equalsIgnoreCase(str);
    AppMethodBeat.o(52335);
    return bool;
  }
  
  public static String cc(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(52316);
    paramArrayOfByte = V(paramArrayOfByte, 0);
    AppMethodBeat.o(52316);
    return paramArrayOfByte;
  }
  
  public static String cd(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(52318);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(52318);
      return "(null)";
    }
    char[] arrayOfChar1 = new char[16];
    char[] tmp28_26 = arrayOfChar1;
    tmp28_26[0] = 48;
    char[] tmp34_28 = tmp28_26;
    tmp34_28[1] = 49;
    char[] tmp40_34 = tmp34_28;
    tmp40_34[2] = 50;
    char[] tmp46_40 = tmp40_34;
    tmp46_40[3] = 51;
    char[] tmp52_46 = tmp46_40;
    tmp52_46[4] = 52;
    char[] tmp58_52 = tmp52_46;
    tmp58_52[5] = 53;
    char[] tmp64_58 = tmp58_52;
    tmp64_58[6] = 54;
    char[] tmp71_64 = tmp64_58;
    tmp71_64[7] = 55;
    char[] tmp78_71 = tmp71_64;
    tmp78_71[8] = 56;
    char[] tmp85_78 = tmp78_71;
    tmp85_78[9] = 57;
    char[] tmp92_85 = tmp85_78;
    tmp92_85[10] = 97;
    char[] tmp99_92 = tmp92_85;
    tmp99_92[11] = 98;
    char[] tmp106_99 = tmp99_92;
    tmp106_99[12] = 99;
    char[] tmp113_106 = tmp106_99;
    tmp113_106[13] = 100;
    char[] tmp120_113 = tmp113_106;
    tmp120_113[14] = 101;
    char[] tmp127_120 = tmp120_113;
    tmp127_120[15] = 102;
    tmp127_120;
    int k = paramArrayOfByte.length;
    char[] arrayOfChar2 = new char[k * 3];
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i];
      int n = j + 1;
      arrayOfChar2[j] = ' ';
      j = n + 1;
      arrayOfChar2[n] = arrayOfChar1[(m >>> 4 & 0xF)];
      arrayOfChar2[j] = arrayOfChar1[(m & 0xF)];
      i += 1;
      j += 1;
    }
    paramArrayOfByte = new String(arrayOfChar2);
    AppMethodBeat.o(52318);
    return paramArrayOfByte;
  }
  
  public static boolean ce(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0);
  }
  
  public static int cf(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return -1;
    }
    return paramArrayOfByte.length;
  }
  
  public static String cg(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(52369);
    StringBuilder localStringBuilder = new StringBuilder("");
    if (paramArrayOfByte != null)
    {
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        localStringBuilder.append(String.format("%02x", new Object[] { Integer.valueOf(paramArrayOfByte[i] & 0xFF) }));
        i += 1;
      }
    }
    paramArrayOfByte = localStringBuilder.toString();
    AppMethodBeat.o(52369);
    return paramArrayOfByte;
  }
  
  public static String ch(Context paramContext)
  {
    AppMethodBeat.i(52338);
    try
    {
      paramContext = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
      AppMethodBeat.o(52338);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.Util", paramContext, "", new Object[0]);
      AppMethodBeat.o(52338);
    }
    return "(null)";
  }
  
  public static String convertStreamToString(InputStream paramInputStream)
  {
    AppMethodBeat.i(52418);
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str + "\n");
      }
      try
      {
        paramInputStream.close();
        AppMethodBeat.o(52418);
        throw localObject;
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      ab.printErrStackTrace("MicroMsg.Util", localIOException, "", new Object[0]);
      try
      {
        paramInputStream.close();
        for (;;)
        {
          paramInputStream = localStringBuilder.toString();
          AppMethodBeat.o(52418);
          return paramInputStream;
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            ab.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
          }
        }
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
        }
      }
    }
    finally {}
  }
  
  public static String cw(Object paramObject)
  {
    AppMethodBeat.i(52342);
    if (paramObject != null)
    {
      paramObject = paramObject.toString();
      AppMethodBeat.o(52342);
      return paramObject;
    }
    AppMethodBeat.o(52342);
    return "null";
  }
  
  public static long cx(Object paramObject)
  {
    AppMethodBeat.i(52351);
    if (paramObject == null)
    {
      AppMethodBeat.o(52351);
      return 0L;
    }
    if ((paramObject instanceof Long))
    {
      long l = ((Long)paramObject).longValue();
      AppMethodBeat.o(52351);
      return l;
    }
    AppMethodBeat.o(52351);
    return 0L;
  }
  
  public static String d(List<String> paramList, String paramString)
  {
    AppMethodBeat.i(52295);
    if (paramList == null)
    {
      AppMethodBeat.o(52295);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = 0;
    if (i < paramList.size())
    {
      if (i == paramList.size() - 1) {
        localStringBuilder.append(((String)paramList.get(i)).trim());
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(((String)paramList.get(i)).trim() + paramString);
      }
    }
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(52295);
    return paramList;
  }
  
  public static boolean d(Boolean paramBoolean)
  {
    AppMethodBeat.i(52345);
    if (paramBoolean == null)
    {
      AppMethodBeat.o(52345);
      return true;
    }
    boolean bool = paramBoolean.booleanValue();
    AppMethodBeat.o(52345);
    return bool;
  }
  
  public static boolean deleteFile(String paramString)
  {
    AppMethodBeat.i(52383);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(52383);
      return false;
    }
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      AppMethodBeat.o(52383);
      return true;
    }
    if (paramString.isDirectory())
    {
      AppMethodBeat.o(52383);
      return false;
    }
    boolean bool = paramString.delete();
    AppMethodBeat.o(52383);
    return bool;
  }
  
  public static byte[] dtR()
  {
    AppMethodBeat.i(52300);
    try
    {
      FileInputStream localFileInputStream = new FileInputStream("/dev/urandom");
      byte[] arrayOfByte = new byte[16];
      int i = localFileInputStream.read(arrayOfByte);
      localFileInputStream.close();
      if (i == 16)
      {
        AppMethodBeat.o(52300);
        return arrayOfByte;
      }
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.Util", localException, "", new Object[0]);
      Object localObject = UUID.randomUUID();
      localObject = g.x((((UUID)localObject).toString() + System.currentTimeMillis()).getBytes());
      AppMethodBeat.o(52300);
      return localObject;
    }
  }
  
  public static String dtS()
  {
    AppMethodBeat.i(52301);
    Object localObject = TimeZone.getDefault();
    int j = ((TimeZone)localObject).getRawOffset() / 1000;
    if ((((TimeZone)localObject).useDaylightTime()) && (((TimeZone)localObject).inDaylightTime(new java.sql.Date(System.currentTimeMillis())))) {}
    for (int i = 1;; i = 0)
    {
      localObject = String.format("%.2f", new Object[] { Double.valueOf(j / 3600.0D + i) });
      AppMethodBeat.o(52301);
      return localObject;
    }
  }
  
  public static long dtT()
  {
    AppMethodBeat.i(52327);
    long l = System.currentTimeMillis() / 86400000L;
    AppMethodBeat.o(52327);
    return l * 86400000L;
  }
  
  public static long dtU()
  {
    AppMethodBeat.i(52328);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    long l = localCalendar.getTimeInMillis();
    AppMethodBeat.o(52328);
    return l;
  }
  
  public static long dtV()
  {
    AppMethodBeat.i(52331);
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      if (Build.VERSION.SDK_INT < 18)
      {
        l1 = localStatFs.getBlockSize();
        int i = localStatFs.getAvailableBlocks();
        l2 = i;
        AppMethodBeat.o(52331);
        return l2 * l1;
      }
      long l1 = localStatFs.getBlockSizeLong();
      long l2 = localStatFs.getAvailableBlocksLong();
      AppMethodBeat.o(52331);
      return l2 * l1;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.Util", "getDataAvailableSize exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(52331);
    }
    return 0L;
  }
  
  public static View.OnTouchListener dtW()
  {
    AppMethodBeat.i(52390);
    View.OnTouchListener local1 = new View.OnTouchListener()
    {
      public final boolean onTouch(final View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(52290);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(52290);
          return false;
          paramAnonymousView.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(52289);
              paramAnonymousView.setPressed(false);
              AppMethodBeat.o(52289);
            }
          });
          continue;
          paramAnonymousView.setPressed(true);
        }
      }
    };
    AppMethodBeat.o(52390);
    return local1;
  }
  
  public static int dtX()
  {
    AppMethodBeat.i(52403);
    int i = new Random().nextInt();
    AppMethodBeat.o(52403);
    return i;
  }
  
  public static an dtY()
  {
    AppMethodBeat.i(52415);
    an localan = new an();
    AppMethodBeat.o(52415);
    return localan;
  }
  
  public static boolean dtZ()
  {
    AppMethodBeat.i(52428);
    String str = System.getProperty("java.vm.version");
    if ((!isNullOrNil(str)) && (str.startsWith("2")))
    {
      AppMethodBeat.o(52428);
      return true;
    }
    AppMethodBeat.o(52428);
    return false;
  }
  
  /* Error */
  private static List<String> dua()
  {
    // Byte code:
    //   0: ldc_w 1302
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 326	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 327	java/util/ArrayList:<init>	()V
    //   13: astore_3
    //   14: invokestatic 1308	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   17: ldc_w 1310
    //   20: invokevirtual 1314	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   23: astore_2
    //   24: new 1316	java/io/LineNumberReader
    //   27: dup
    //   28: new 1166	java/io/InputStreamReader
    //   31: dup
    //   32: aload_2
    //   33: invokevirtual 1319	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   36: invokespecial 1167	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   39: invokespecial 1320	java/io/LineNumberReader:<init>	(Ljava/io/Reader;)V
    //   42: astore_1
    //   43: aload_1
    //   44: astore_0
    //   45: aload_1
    //   46: invokevirtual 1321	java/io/LineNumberReader:readLine	()Ljava/lang/String;
    //   49: astore 4
    //   51: aload 4
    //   53: ifnull +89 -> 142
    //   56: aload_1
    //   57: astore_0
    //   58: aload 4
    //   60: invokevirtual 614	java/lang/String:length	()I
    //   63: ifle -20 -> 43
    //   66: aload_1
    //   67: astore_0
    //   68: aload_3
    //   69: aload 4
    //   71: invokeinterface 709 2 0
    //   76: pop
    //   77: goto -34 -> 43
    //   80: astore_2
    //   81: aload_1
    //   82: astore_0
    //   83: ldc 177
    //   85: ldc_w 1323
    //   88: iconst_1
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: aload_2
    //   95: invokevirtual 841	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   98: aastore
    //   99: invokestatic 816	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: aload_1
    //   103: ifnull +7 -> 110
    //   106: aload_1
    //   107: invokevirtual 1324	java/io/LineNumberReader:close	()V
    //   110: ldc 177
    //   112: ldc_w 1326
    //   115: iconst_1
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: aload_3
    //   122: invokeinterface 215 1 0
    //   127: invokestatic 708	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   130: aastore
    //   131: invokestatic 563	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   134: ldc_w 1302
    //   137: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_3
    //   141: areturn
    //   142: aload_1
    //   143: astore_0
    //   144: aload_2
    //   145: invokevirtual 1329	java/lang/Process:waitFor	()I
    //   148: pop
    //   149: aload_1
    //   150: astore_0
    //   151: aload_2
    //   152: invokevirtual 1332	java/lang/Process:destroy	()V
    //   155: aload_1
    //   156: invokevirtual 1324	java/io/LineNumberReader:close	()V
    //   159: goto -49 -> 110
    //   162: astore_0
    //   163: ldc 177
    //   165: ldc_w 1334
    //   168: iconst_1
    //   169: anewarray 4	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload_0
    //   175: invokevirtual 841	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   178: aastore
    //   179: invokestatic 816	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: goto -72 -> 110
    //   185: astore_0
    //   186: ldc 177
    //   188: ldc_w 1334
    //   191: iconst_1
    //   192: anewarray 4	java/lang/Object
    //   195: dup
    //   196: iconst_0
    //   197: aload_0
    //   198: invokevirtual 841	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   201: aastore
    //   202: invokestatic 816	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   205: goto -95 -> 110
    //   208: astore_1
    //   209: aconst_null
    //   210: astore_0
    //   211: aload_0
    //   212: ifnull +7 -> 219
    //   215: aload_0
    //   216: invokevirtual 1324	java/io/LineNumberReader:close	()V
    //   219: ldc_w 1302
    //   222: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   225: aload_1
    //   226: athrow
    //   227: astore_0
    //   228: ldc 177
    //   230: ldc_w 1334
    //   233: iconst_1
    //   234: anewarray 4	java/lang/Object
    //   237: dup
    //   238: iconst_0
    //   239: aload_0
    //   240: invokevirtual 841	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   243: aastore
    //   244: invokestatic 816	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: goto -28 -> 219
    //   250: astore_1
    //   251: goto -40 -> 211
    //   254: astore_2
    //   255: aconst_null
    //   256: astore_1
    //   257: goto -176 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   44	107	0	localLineNumberReader1	java.io.LineNumberReader
    //   162	13	0	localException1	Exception
    //   185	13	0	localException2	Exception
    //   210	6	0	localObject1	Object
    //   227	13	0	localException3	Exception
    //   42	114	1	localLineNumberReader2	java.io.LineNumberReader
    //   208	18	1	localObject2	Object
    //   250	1	1	localObject3	Object
    //   256	1	1	localObject4	Object
    //   23	10	2	localProcess	java.lang.Process
    //   80	72	2	localException4	Exception
    //   254	1	2	localException5	Exception
    //   13	128	3	localArrayList	ArrayList
    //   49	21	4	str	String
    // Exception table:
    //   from	to	target	type
    //   45	51	80	java/lang/Exception
    //   58	66	80	java/lang/Exception
    //   68	77	80	java/lang/Exception
    //   144	149	80	java/lang/Exception
    //   151	155	80	java/lang/Exception
    //   155	159	162	java/lang/Exception
    //   106	110	185	java/lang/Exception
    //   14	43	208	finally
    //   215	219	227	java/lang/Exception
    //   45	51	250	finally
    //   58	66	250	finally
    //   68	77	250	finally
    //   83	102	250	finally
    //   144	149	250	finally
    //   151	155	250	finally
    //   14	43	254	java/lang/Exception
  }
  
  public static boolean e(Boolean paramBoolean)
  {
    AppMethodBeat.i(52346);
    if (paramBoolean == null)
    {
      AppMethodBeat.o(52346);
      return false;
    }
    boolean bool = paramBoolean.booleanValue();
    AppMethodBeat.o(52346);
    return bool;
  }
  
  public static String[] er(List<String> paramList)
  {
    AppMethodBeat.i(52298);
    String[] arrayOfString = new String[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfString[i] = ((String)paramList.get(i));
      i += 1;
    }
    AppMethodBeat.o(52298);
    return arrayOfString;
  }
  
  public static boolean es(List paramList)
  {
    AppMethodBeat.i(52352);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(52352);
      return true;
    }
    AppMethodBeat.o(52352);
    return false;
  }
  
  public static int f(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(52350);
    if (paramObject == null)
    {
      AppMethodBeat.o(52350);
      return paramInt;
    }
    if ((paramObject instanceof Integer))
    {
      paramInt = ((Integer)paramObject).intValue();
      AppMethodBeat.o(52350);
      return paramInt;
    }
    if ((paramObject instanceof Long))
    {
      paramInt = ((Long)paramObject).intValue();
      AppMethodBeat.o(52350);
      return paramInt;
    }
    AppMethodBeat.o(52350);
    return paramInt;
  }
  
  public static int g(Integer paramInteger)
  {
    AppMethodBeat.i(52343);
    if (paramInteger == null)
    {
      AppMethodBeat.o(52343);
      return 0;
    }
    int i = paramInteger.intValue();
    AppMethodBeat.o(52343);
    return i;
  }
  
  public static boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(52362);
    if (paramString == null) {}
    try
    {
      AppMethodBeat.o(52362);
      return paramBoolean;
    }
    catch (NumberFormatException paramString)
    {
      boolean bool;
      ab.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(52362);
    }
    bool = Boolean.parseBoolean(paramString);
    AppMethodBeat.o(52362);
    return bool;
    return paramBoolean;
  }
  
  public static double getDouble(String paramString, double paramDouble)
  {
    AppMethodBeat.i(52364);
    if (paramString == null) {}
    try
    {
      AppMethodBeat.o(52364);
      return paramDouble;
    }
    catch (NumberFormatException paramString)
    {
      double d;
      ab.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(52364);
    }
    d = Double.parseDouble(paramString);
    AppMethodBeat.o(52364);
    return d;
    return paramDouble;
  }
  
  public static float getFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(52363);
    if (paramString == null) {}
    try
    {
      AppMethodBeat.o(52363);
      return paramFloat;
    }
    catch (NumberFormatException paramString)
    {
      float f;
      ab.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(52363);
    }
    f = Float.parseFloat(paramString);
    AppMethodBeat.o(52363);
    return f;
    return paramFloat;
  }
  
  public static int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(52359);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(52359);
        return paramInt;
      }
      int i = Integer.decode(paramString).intValue();
      AppMethodBeat.o(52359);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      ab.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(52359);
    }
    return paramInt;
  }
  
  public static long getLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(52360);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(52360);
        return paramLong;
      }
      long l = Long.decode(paramString).longValue();
      AppMethodBeat.o(52360);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      ab.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(52360);
    }
    return paramLong;
  }
  
  public static long gz(long paramLong)
  {
    AppMethodBeat.i(52324);
    long l = System.currentTimeMillis() / 1000L;
    AppMethodBeat.o(52324);
    return l - paramLong;
  }
  
  @TargetApi(19)
  public static String h(Context paramContext, Uri paramUri)
  {
    Object localObject = null;
    AppMethodBeat.i(52405);
    if ((paramContext == null) || (paramUri == null))
    {
      ab.e("MicroMsg.Util", "getFilePath : context is null or uri is null");
      AppMethodBeat.o(52405);
      return null;
    }
    String str1 = paramUri.getScheme();
    if (isNullOrNil(str1))
    {
      ab.e("MicroMsg.Util", "input uri error. %s", new Object[] { paramUri });
      AppMethodBeat.o(52405);
      return null;
    }
    if (str1.equalsIgnoreCase("file"))
    {
      ab.i("MicroMsg.Util", "getFilePath : scheme is SCHEME_FILE");
      paramContext = paramUri.getPath();
      AppMethodBeat.o(52405);
      return paramContext;
    }
    if (str1.equalsIgnoreCase("content"))
    {
      ab.i("MicroMsg.Util", "getFilePath : scheme is SCHEME_CONTENT: " + paramUri.toString());
      if ("com.google.android.apps.photos.content".equals(paramUri.getAuthority()))
      {
        paramContext = paramUri.getLastPathSegment();
        AppMethodBeat.o(52405);
        return paramContext;
      }
      String[] arrayOfString;
      try
      {
        paramContext.grantUriPermission(paramUri.getAuthority(), paramUri, 1);
        str1 = a(paramContext, paramUri, null, null);
        if (!isNullOrNil(str1))
        {
          AppMethodBeat.o(52405);
          return str1;
        }
      }
      catch (SecurityException localSecurityException)
      {
        for (;;)
        {
          ab.e("MicroMsg.Util", "getFilePath : exception = ".concat(String.valueOf(localSecurityException)));
          arrayOfString = null;
        }
        if (Build.VERSION.SDK_INT < 19) {
          break label469;
        }
      }
      if (DocumentsContract.isDocumentUri(paramContext, paramUri))
      {
        if ("com.android.externalstorage.documents".equals(paramUri.getAuthority()))
        {
          paramContext = DocumentsContract.getDocumentId(paramUri).split(":");
          if ("primary".equalsIgnoreCase(paramContext[0]))
          {
            paramContext = Environment.getExternalStorageDirectory() + "/" + paramContext[1];
            AppMethodBeat.o(52405);
            return paramContext;
          }
          AppMethodBeat.o(52405);
          return null;
        }
        if ("com.android.providers.downloads.documents".equals(paramUri.getAuthority()))
        {
          paramUri = DocumentsContract.getDocumentId(paramUri);
          paramContext = a(paramContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(paramUri).longValue()), null, null);
          AppMethodBeat.o(52405);
          return paramContext;
        }
        if ("com.android.providers.media.documents".equals(paramUri.getAuthority()))
        {
          arrayOfString = DocumentsContract.getDocumentId(paramUri).split(":");
          String str2 = arrayOfString[0];
          if ("image".equals(str2)) {
            paramUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
          }
          for (;;)
          {
            paramContext = a(paramContext, paramUri, "_id=?", new String[] { arrayOfString[1] });
            AppMethodBeat.o(52405);
            return paramContext;
            if ("video".equals(str2))
            {
              paramUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            }
            else
            {
              paramUri = localObject;
              if ("audio".equals(str2)) {
                paramUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
              }
            }
          }
        }
      }
    }
    label469:
    ab.e("MicroMsg.Util", "unknown scheme");
    AppMethodBeat.o(52405);
    return null;
  }
  
  public static void hf(Context paramContext)
  {
    AppMethodBeat.i(52321);
    paramContext = (Vibrator)paramContext.getSystemService("vibrator");
    if (paramContext == null)
    {
      AppMethodBeat.o(52321);
      return;
    }
    paramContext.vibrate(yqQ, -1);
    AppMethodBeat.o(52321);
  }
  
  public static long hg(Context paramContext)
  {
    AppMethodBeat.i(52332);
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null)
    {
      AppMethodBeat.o(52332);
      return 0L;
    }
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    paramContext.getMemoryInfo(localMemoryInfo);
    long l = localMemoryInfo.availMem / 1024L / 1024L;
    AppMethodBeat.o(52332);
    return l;
  }
  
  public static String hh(Context paramContext)
  {
    AppMethodBeat.i(52333);
    if (paramContext == null)
    {
      AppMethodBeat.o(52333);
      return null;
    }
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null)
      {
        ab.e("MicroMsg.Util", "getLine1Number failed, null tm");
        AppMethodBeat.o(52333);
        return null;
      }
      paramContext = paramContext.getLine1Number();
      AppMethodBeat.o(52333);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.Util", "getLine1Number failed:%s ", new Object[] { an.l(paramContext) });
      AppMethodBeat.o(52333);
    }
    return null;
  }
  
  public static String hi(Context paramContext)
  {
    AppMethodBeat.i(52334);
    if (paramContext == null)
    {
      ab.w("MicroMsg.Util", "getSimCountryCode context is null.");
      AppMethodBeat.o(52334);
      return "";
    }
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext != null)
    {
      paramContext = paramContext.getSimCountryIso();
      if (isNullOrNil(paramContext))
      {
        AppMethodBeat.o(52334);
        return "";
      }
      paramContext = paramContext.toUpperCase().trim();
      AppMethodBeat.o(52334);
      return paramContext;
    }
    AppMethodBeat.o(52334);
    return "";
  }
  
  public static boolean hideVKB(View paramView)
  {
    AppMethodBeat.i(52366);
    try
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)paramView.getContext().getSystemService("input_method");
      if (localInputMethodManager == null)
      {
        AppMethodBeat.o(52366);
        return false;
      }
      bool = localInputMethodManager.hideSoftInputFromWindow(paramView.getApplicationWindowToken(), 0);
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Util", paramView, "", new Object[0]);
        ab.e("MicroMsg.Util", "hide VKB exception %s", new Object[] { paramView });
        boolean bool = false;
      }
    }
    ab.v("MicroMsg.Util", "hide VKB result %B", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(52366);
    return bool;
  }
  
  public static boolean hj(Context paramContext)
  {
    AppMethodBeat.i(52339);
    try
    {
      String str = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
      paramContext = paramContext.getPackageName();
      ab.d("MicroMsg.Util", "top activity=" + str + ", context=" + paramContext);
      boolean bool = str.contains(paramContext);
      AppMethodBeat.o(52339);
      return bool;
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.Util", paramContext, "", new Object[0]);
      AppMethodBeat.o(52339);
    }
    return false;
  }
  
  public static int hk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52299);
    if (paramInt1 > paramInt2) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramInt1 = new Random(System.currentTimeMillis()).nextInt(paramInt1 - paramInt2 + 1);
      AppMethodBeat.o(52299);
      return paramInt1 + paramInt2;
    }
  }
  
  public static String hk(long paramLong)
  {
    AppMethodBeat.i(52312);
    if (paramLong >> 30 > 0L)
    {
      str = c(paramLong, 10.0D);
      AppMethodBeat.o(52312);
      return str;
    }
    if (paramLong >> 20 > 0L)
    {
      str = b(paramLong, 10.0D);
      AppMethodBeat.o(52312);
      return str;
    }
    if (paramLong >> 9 > 0L)
    {
      double d = Math.round(paramLong * 10.0D / 1024.0D) / 10.0D;
      str = d + " KB";
      AppMethodBeat.o(52312);
      return str;
    }
    String str = paramLong + " B";
    AppMethodBeat.o(52312);
    return str;
  }
  
  public static String hk(Context paramContext)
  {
    AppMethodBeat.i(52387);
    if (paramContext == null)
    {
      AppMethodBeat.o(52387);
      return null;
    }
    paramContext = m(paramContext.getPackageName(), paramContext);
    AppMethodBeat.o(52387);
    return paramContext;
  }
  
  public static long hl(long paramLong)
  {
    AppMethodBeat.i(52417);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(52417);
    return l - paramLong;
  }
  
  public static boolean hl(int paramInt1, int paramInt2)
  {
    return paramInt1 == paramInt2;
  }
  
  public static boolean hl(Context paramContext)
  {
    AppMethodBeat.i(52389);
    if (!Locale.getDefault().getCountry().equalsIgnoreCase("CN"))
    {
      AppMethodBeat.o(52389);
      return true;
    }
    TimeZone localTimeZone1 = TimeZone.getDefault();
    TimeZone localTimeZone2 = TimeZone.getTimeZone("GMT+08:00");
    if (localTimeZone1.getRawOffset() != localTimeZone2.getRawOffset())
    {
      AppMethodBeat.o(52389);
      return true;
    }
    if (paramContext == null)
    {
      ab.w("MicroMsg.Util", "isOverseasUser context is null");
      AppMethodBeat.o(52389);
      return false;
    }
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext != null)
    {
      paramContext = paramContext.getNetworkCountryIso();
      if ((!isNullOrNil(paramContext)) && (!paramContext.contains("cn")) && (!paramContext.contains("CN")))
      {
        AppMethodBeat.o(52389);
        return true;
      }
    }
    AppMethodBeat.o(52389);
    return false;
  }
  
  public static a hm(Context paramContext)
  {
    AppMethodBeat.i(52410);
    paramContext = new a(paramContext);
    AppMethodBeat.o(52410);
    return paramContext;
  }
  
  public static ComponentName hn(Context paramContext)
  {
    AppMethodBeat.i(52411);
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        paramContext = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity;
        AppMethodBeat.o(52411);
        return paramContext;
      }
      AppMethodBeat.o(52411);
      return null;
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.Util", "get Top Activity Exception:%s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(52411);
    }
    return null;
  }
  
  public static String ho(Context paramContext)
  {
    AppMethodBeat.i(52412);
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      String str;
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramContext = paramContext.getAppTasks();
        if ((paramContext == null) || (paramContext.size() <= 0))
        {
          AppMethodBeat.o(52412);
          return "";
        }
        paramContext = paramContext.iterator();
        if (paramContext.hasNext())
        {
          paramContext = ((ActivityManager.AppTask)paramContext.next()).getTaskInfo().topActivity;
          if (paramContext == null)
          {
            AppMethodBeat.o(52412);
            return null;
          }
          str = paramContext.getClassName();
          paramContext = str;
          if (str.contains(".")) {
            paramContext = str.substring(str.lastIndexOf(".") + 1);
          }
          AppMethodBeat.o(52412);
          return paramContext;
        }
      }
      else
      {
        str = ((ActivityManager.RunningTaskInfo)paramContext.getRunningTasks(1).get(0)).topActivity.getClassName();
        paramContext = str;
        if (str.contains(".")) {
          paramContext = str.substring(str.lastIndexOf(".") + 1);
        }
        AppMethodBeat.o(52412);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.Util", "getTopActivityName Exception:%s stack:%s", new Object[] { paramContext.getMessage(), an.l(paramContext) });
      AppMethodBeat.o(52412);
    }
    return "";
  }
  
  public static int hp(Context paramContext)
  {
    AppMethodBeat.i(52433);
    if (paramContext == null)
    {
      ab.i("MicroMsg.Util", "getSelfMemInMB context is null.");
      AppMethodBeat.o(52433);
      return -1;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getProcessMemoryInfo(new int[] { Process.myPid() });
    if ((paramContext != null) && (paramContext.length > 0))
    {
      int i = paramContext[0].getTotalPss() / 1024;
      AppMethodBeat.o(52433);
      return i;
    }
    AppMethodBeat.o(52433);
    return 0;
  }
  
  public static List<String> ih(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52296);
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = Collections.EMPTY_LIST;
      AppMethodBeat.o(52296);
      return paramString1;
    }
    paramString1 = paramString1.split(paramString2);
    if (paramString1 == null)
    {
      paramString1 = Collections.EMPTY_LIST;
      AppMethodBeat.o(52296);
      return paramString1;
    }
    paramString1 = Arrays.asList(paramString1);
    AppMethodBeat.o(52296);
    return paramString1;
  }
  
  /* Error */
  public static int ii(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 1676
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 1678	java/util/zip/ZipInputStream
    //   9: dup
    //   10: new 1008	java/io/FileInputStream
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 1013	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 1679	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   21: astore_3
    //   22: aload_3
    //   23: astore_0
    //   24: aload_3
    //   25: invokevirtual 1683	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   28: astore 4
    //   30: aload 4
    //   32: ifnull +301 -> 333
    //   35: aload_3
    //   36: astore_0
    //   37: aload 4
    //   39: invokevirtual 1686	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   42: astore 5
    //   44: aload_3
    //   45: astore_0
    //   46: aload 5
    //   48: ldc_w 586
    //   51: invokevirtual 923	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   54: ifne -32 -> 22
    //   57: aload_3
    //   58: astore_0
    //   59: aload 5
    //   61: ldc_w 1688
    //   64: invokevirtual 923	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   67: ifne -45 -> 22
    //   70: aload_3
    //   71: astore_0
    //   72: aload 4
    //   74: invokevirtual 1689	java/util/zip/ZipEntry:isDirectory	()Z
    //   77: ifeq +92 -> 169
    //   80: aload_3
    //   81: astore_0
    //   82: aload 5
    //   84: iconst_0
    //   85: aload 5
    //   87: invokevirtual 614	java/lang/String:length	()I
    //   90: iconst_1
    //   91: isub
    //   92: invokevirtual 688	java/lang/String:substring	(II)Ljava/lang/String;
    //   95: astore 4
    //   97: aload_3
    //   98: astore_0
    //   99: new 914	java/io/File
    //   102: dup
    //   103: new 449	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 450	java/lang/StringBuilder:<init>	()V
    //   110: aload_1
    //   111: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: getstatic 1692	java/io/File:separator	Ljava/lang/String;
    //   117: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload 4
    //   122: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 497	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokespecial 915	java/io/File:<init>	(Ljava/lang/String;)V
    //   131: invokevirtual 1695	java/io/File:mkdirs	()Z
    //   134: pop
    //   135: goto -113 -> 22
    //   138: astore_1
    //   139: aload_3
    //   140: astore_0
    //   141: ldc 177
    //   143: aload_1
    //   144: ldc 179
    //   146: iconst_0
    //   147: anewarray 4	java/lang/Object
    //   150: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aload_3
    //   154: ifnull +7 -> 161
    //   157: aload_3
    //   158: invokevirtual 1696	java/util/zip/ZipInputStream:close	()V
    //   161: ldc_w 1676
    //   164: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: iconst_m1
    //   168: ireturn
    //   169: aload_3
    //   170: astore_0
    //   171: new 914	java/io/File
    //   174: dup
    //   175: new 449	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 450	java/lang/StringBuilder:<init>	()V
    //   182: aload_1
    //   183: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: getstatic 1692	java/io/File:separator	Ljava/lang/String;
    //   189: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 5
    //   194: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 497	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokespecial 915	java/io/File:<init>	(Ljava/lang/String;)V
    //   203: astore 4
    //   205: aload_3
    //   206: astore_0
    //   207: aload 4
    //   209: invokevirtual 1699	java/io/File:createNewFile	()Z
    //   212: pop
    //   213: aload_3
    //   214: astore_0
    //   215: new 1701	java/io/FileOutputStream
    //   218: dup
    //   219: aload 4
    //   221: invokespecial 1704	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   224: astore 4
    //   226: aload_3
    //   227: astore_0
    //   228: sipush 1024
    //   231: newarray byte
    //   233: astore 5
    //   235: aload_3
    //   236: astore_0
    //   237: aload_3
    //   238: aload 5
    //   240: invokevirtual 1705	java/util/zip/ZipInputStream:read	([B)I
    //   243: istore_2
    //   244: iload_2
    //   245: iconst_m1
    //   246: if_icmpeq +56 -> 302
    //   249: aload_3
    //   250: astore_0
    //   251: aload 4
    //   253: aload 5
    //   255: iconst_0
    //   256: iload_2
    //   257: invokevirtual 1706	java/io/FileOutputStream:write	([BII)V
    //   260: aload_3
    //   261: astore_0
    //   262: aload 4
    //   264: invokevirtual 1709	java/io/FileOutputStream:flush	()V
    //   267: goto -32 -> 235
    //   270: astore_1
    //   271: aload_3
    //   272: astore_0
    //   273: ldc 177
    //   275: aload_1
    //   276: ldc 179
    //   278: iconst_0
    //   279: anewarray 4	java/lang/Object
    //   282: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   285: aload_3
    //   286: ifnull +7 -> 293
    //   289: aload_3
    //   290: invokevirtual 1696	java/util/zip/ZipInputStream:close	()V
    //   293: ldc_w 1676
    //   296: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   299: bipush 254
    //   301: ireturn
    //   302: aload_3
    //   303: astore_0
    //   304: aload 4
    //   306: invokevirtual 1710	java/io/FileOutputStream:close	()V
    //   309: goto -287 -> 22
    //   312: astore_3
    //   313: aload_0
    //   314: astore_1
    //   315: aload_3
    //   316: astore_0
    //   317: aload_1
    //   318: ifnull +7 -> 325
    //   321: aload_1
    //   322: invokevirtual 1696	java/util/zip/ZipInputStream:close	()V
    //   325: ldc_w 1676
    //   328: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   331: aload_0
    //   332: athrow
    //   333: aload_3
    //   334: invokevirtual 1696	java/util/zip/ZipInputStream:close	()V
    //   337: ldc_w 1676
    //   340: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   343: iconst_0
    //   344: ireturn
    //   345: astore_0
    //   346: ldc 177
    //   348: ldc_w 1712
    //   351: invokestatic 284	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   354: goto -17 -> 337
    //   357: astore_0
    //   358: ldc 177
    //   360: ldc_w 1712
    //   363: invokestatic 284	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: goto -205 -> 161
    //   369: astore_0
    //   370: ldc 177
    //   372: ldc_w 1712
    //   375: invokestatic 284	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   378: goto -85 -> 293
    //   381: astore_1
    //   382: ldc 177
    //   384: ldc_w 1712
    //   387: invokestatic 284	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   390: goto -65 -> 325
    //   393: astore_0
    //   394: aconst_null
    //   395: astore_1
    //   396: goto -79 -> 317
    //   399: astore_1
    //   400: aconst_null
    //   401: astore_3
    //   402: goto -131 -> 271
    //   405: astore_1
    //   406: aconst_null
    //   407: astore_3
    //   408: goto -269 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	paramString1	String
    //   0	411	1	paramString2	String
    //   243	14	2	i	int
    //   21	282	3	localZipInputStream	java.util.zip.ZipInputStream
    //   312	22	3	localObject1	Object
    //   401	7	3	localObject2	Object
    //   28	277	4	localObject3	Object
    //   42	212	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   24	30	138	java/io/FileNotFoundException
    //   37	44	138	java/io/FileNotFoundException
    //   46	57	138	java/io/FileNotFoundException
    //   59	70	138	java/io/FileNotFoundException
    //   72	80	138	java/io/FileNotFoundException
    //   82	97	138	java/io/FileNotFoundException
    //   99	135	138	java/io/FileNotFoundException
    //   171	205	138	java/io/FileNotFoundException
    //   207	213	138	java/io/FileNotFoundException
    //   215	226	138	java/io/FileNotFoundException
    //   228	235	138	java/io/FileNotFoundException
    //   237	244	138	java/io/FileNotFoundException
    //   251	260	138	java/io/FileNotFoundException
    //   262	267	138	java/io/FileNotFoundException
    //   304	309	138	java/io/FileNotFoundException
    //   24	30	270	java/io/IOException
    //   37	44	270	java/io/IOException
    //   46	57	270	java/io/IOException
    //   59	70	270	java/io/IOException
    //   72	80	270	java/io/IOException
    //   82	97	270	java/io/IOException
    //   99	135	270	java/io/IOException
    //   171	205	270	java/io/IOException
    //   207	213	270	java/io/IOException
    //   215	226	270	java/io/IOException
    //   228	235	270	java/io/IOException
    //   237	244	270	java/io/IOException
    //   251	260	270	java/io/IOException
    //   262	267	270	java/io/IOException
    //   304	309	270	java/io/IOException
    //   24	30	312	finally
    //   37	44	312	finally
    //   46	57	312	finally
    //   59	70	312	finally
    //   72	80	312	finally
    //   82	97	312	finally
    //   99	135	312	finally
    //   141	153	312	finally
    //   171	205	312	finally
    //   207	213	312	finally
    //   215	226	312	finally
    //   228	235	312	finally
    //   237	244	312	finally
    //   251	260	312	finally
    //   262	267	312	finally
    //   273	285	312	finally
    //   304	309	312	finally
    //   333	337	345	java/io/IOException
    //   157	161	357	java/io/IOException
    //   289	293	369	java/io/IOException
    //   321	325	381	java/io/IOException
    //   6	22	393	finally
    //   6	22	399	java/io/IOException
    //   6	22	405	java/io/FileNotFoundException
  }
  
  public static boolean isEqual(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52430);
    if ((isNullOrNil(paramString1)) && (isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(52430);
      return true;
    }
    if ((isNullOrNil(paramString1)) && (!isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(52430);
      return false;
    }
    if ((!isNullOrNil(paramString1)) && (isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(52430);
      return false;
    }
    boolean bool = paramString1.equals(paramString2);
    AppMethodBeat.o(52430);
    return bool;
  }
  
  public static boolean isEqual(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(52431);
    boolean bool = Arrays.equals(paramArrayOfByte1, paramArrayOfByte2);
    AppMethodBeat.o(52431);
    return bool;
  }
  
  public static boolean isNullOrNil(String paramString)
  {
    AppMethodBeat.i(52353);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(52353);
      return true;
    }
    AppMethodBeat.o(52353);
    return false;
  }
  
  public static boolean k(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(52340);
    paramContext = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536);
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      AppMethodBeat.o(52340);
      return true;
    }
    AppMethodBeat.o(52340);
    return false;
  }
  
  public static String l(Throwable paramThrowable)
  {
    AppMethodBeat.i(156813);
    paramThrowable = an.l(paramThrowable);
    AppMethodBeat.o(156813);
    return paramThrowable;
  }
  
  public static void l(String paramString, Context paramContext)
  {
    AppMethodBeat.i(52319);
    if ((paramString != null) && (!paramString.equals(""))) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addFlags(268435456);
      localIntent.setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
      paramContext.startActivity(localIntent);
      AppMethodBeat.o(52319);
      return;
    }
  }
  
  public static byte[] l(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == null) {
      return paramArrayOfByte2;
    }
    return paramArrayOfByte1;
  }
  
  public static String m(String paramString, Context paramContext)
  {
    AppMethodBeat.i(52388);
    if ((paramContext == null) || (isNullOrNil(paramString)))
    {
      AppMethodBeat.o(52388);
      return null;
    }
    paramContext = paramContext.getPackageManager();
    try
    {
      paramString = paramContext.getPackageInfo(paramString, 64).signatures[0].toByteArray();
      paramString = g.w(paramString);
      AppMethodBeat.o(52388);
      return paramString;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(52388);
    }
    return null;
  }
  
  public static String mH(int paramInt)
  {
    AppMethodBeat.i(52323);
    String str = String.format("%d:%02d", new Object[] { Long.valueOf(paramInt / 60L), Long.valueOf(paramInt % 60L) });
    AppMethodBeat.o(52323);
    return str;
  }
  
  public static void n(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(52424);
    Object localObject = new Rect();
    paramView.getHitRect((Rect)localObject);
    ((Rect)localObject).top -= paramInt2;
    ((Rect)localObject).bottom += paramInt4;
    ((Rect)localObject).left -= paramInt1;
    ((Rect)localObject).right += paramInt3;
    localObject = new TouchDelegate((Rect)localObject, paramView);
    if (View.class.isInstance(paramView.getParent())) {
      ((View)paramView.getParent()).setTouchDelegate((TouchDelegate)localObject);
    }
    AppMethodBeat.o(52424);
  }
  
  public static String nT(long paramLong)
  {
    AppMethodBeat.i(52302);
    String str = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date(paramLong));
    AppMethodBeat.o(52302);
    return str;
  }
  
  public static String nU(long paramLong)
  {
    AppMethodBeat.i(52303);
    String str = new SimpleDateFormat("[yy-MM-dd HH:mm:ss]").format(new java.util.Date(1000L * paramLong));
    AppMethodBeat.o(52303);
    return str;
  }
  
  public static String nV(long paramLong)
  {
    AppMethodBeat.i(52314);
    String str = b(paramLong, 10.0D);
    AppMethodBeat.o(52314);
    return str;
  }
  
  public static String nW(long paramLong)
  {
    AppMethodBeat.i(52361);
    BigInteger localBigInteger = BigInteger.valueOf(paramLong);
    Object localObject = localBigInteger;
    if (localBigInteger.signum() < 0) {
      localObject = localBigInteger.add(yqR);
    }
    localObject = ((BigInteger)localObject).toString();
    AppMethodBeat.o(52361);
    return localObject;
  }
  
  public static int nX(long paramLong)
  {
    AppMethodBeat.i(52437);
    int i = Math.round((float)paramLong / 1000.0F);
    AppMethodBeat.o(52437);
    return i;
  }
  
  public static String nullAsNil(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static boolean o(Uri paramUri)
  {
    AppMethodBeat.i(52406);
    if (paramUri == null)
    {
      AppMethodBeat.o(52406);
      return false;
    }
    if (!"file".equalsIgnoreCase(paramUri.getScheme()))
    {
      AppMethodBeat.o(52406);
      return true;
    }
    boolean bool = aqh(paramUri.getPath());
    AppMethodBeat.o(52406);
    return bool;
  }
  
  public static String p(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(52434);
    try
    {
      paramVarArgs = String.format(paramString, paramVarArgs);
      paramString = paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        ab.i("MicroMsg.Util", "error safeFormatString %s", new Object[] { paramVarArgs.getMessage() });
      }
    }
    AppMethodBeat.o(52434);
    return paramString;
  }
  
  public static void q(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(52384);
    if (isNullOrNil(paramString1))
    {
      AppMethodBeat.o(52384);
      return;
    }
    paramString1 = new File(paramString1);
    if ((!paramString1.exists()) || (!paramString1.isDirectory()))
    {
      AppMethodBeat.o(52384);
      return;
    }
    paramString1 = paramString1.listFiles();
    if ((paramString1 == null) || (paramString1.length == 0))
    {
      AppMethodBeat.o(52384);
      return;
    }
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString1[i];
      if ((localObject.isFile()) && (localObject.getName().startsWith(paramString2)) && (System.currentTimeMillis() - localObject.lastModified() - paramLong >= 0L)) {
        localObject.delete();
      }
      i += 1;
    }
    AppMethodBeat.o(52384);
  }
  
  /* Error */
  public static byte[] readFromFile(String paramString)
  {
    // Byte code:
    //   0: ldc_w 1860
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 339	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +19 -> 29
    //   13: ldc 177
    //   15: ldc_w 1862
    //   18: invokestatic 725	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 1860
    //   24: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aconst_null
    //   28: areturn
    //   29: new 914	java/io/File
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 915	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore_3
    //   38: aload_3
    //   39: invokevirtual 1193	java/io/File:exists	()Z
    //   42: ifne +27 -> 69
    //   45: ldc 177
    //   47: ldc_w 1864
    //   50: iconst_1
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload_0
    //   57: aastore
    //   58: invokestatic 1866	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: ldc_w 1860
    //   64: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aconst_null
    //   68: areturn
    //   69: aload_3
    //   70: invokevirtual 1868	java/io/File:length	()J
    //   73: l2i
    //   74: istore_1
    //   75: new 1008	java/io/FileInputStream
    //   78: dup
    //   79: aload_3
    //   80: invokespecial 1869	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   83: astore 4
    //   85: aload 4
    //   87: astore_3
    //   88: iload_1
    //   89: newarray byte
    //   91: astore 5
    //   93: aload 4
    //   95: astore_3
    //   96: aload 4
    //   98: aload 5
    //   100: invokevirtual 1014	java/io/FileInputStream:read	([B)I
    //   103: istore_2
    //   104: iload_2
    //   105: iload_1
    //   106: if_icmpeq +65 -> 171
    //   109: aload 4
    //   111: astore_3
    //   112: ldc 177
    //   114: ldc_w 1871
    //   117: iconst_3
    //   118: anewarray 4	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: aload_0
    //   124: aastore
    //   125: dup
    //   126: iconst_1
    //   127: iload_1
    //   128: invokestatic 708	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   131: aastore
    //   132: dup
    //   133: iconst_2
    //   134: iload_2
    //   135: invokestatic 708	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   138: aastore
    //   139: invokestatic 1866	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aload 4
    //   144: invokevirtual 1015	java/io/FileInputStream:close	()V
    //   147: ldc_w 1860
    //   150: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: aconst_null
    //   154: areturn
    //   155: astore_0
    //   156: ldc 177
    //   158: aload_0
    //   159: ldc 179
    //   161: iconst_0
    //   162: anewarray 4	java/lang/Object
    //   165: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: goto -21 -> 147
    //   171: aload 4
    //   173: astore_3
    //   174: ldc 177
    //   176: ldc_w 1873
    //   179: invokestatic 1140	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload 4
    //   184: invokevirtual 1015	java/io/FileInputStream:close	()V
    //   187: ldc_w 1860
    //   190: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aload 5
    //   195: areturn
    //   196: astore_0
    //   197: ldc 177
    //   199: aload_0
    //   200: ldc 179
    //   202: iconst_0
    //   203: anewarray 4	java/lang/Object
    //   206: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: goto -22 -> 187
    //   212: astore 5
    //   214: aconst_null
    //   215: astore_0
    //   216: aload_0
    //   217: astore_3
    //   218: ldc 177
    //   220: aload 5
    //   222: ldc 179
    //   224: iconst_0
    //   225: anewarray 4	java/lang/Object
    //   228: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   231: aload_0
    //   232: ifnull +7 -> 239
    //   235: aload_0
    //   236: invokevirtual 1015	java/io/FileInputStream:close	()V
    //   239: ldc_w 1860
    //   242: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: aconst_null
    //   246: areturn
    //   247: astore_0
    //   248: ldc 177
    //   250: aload_0
    //   251: ldc 179
    //   253: iconst_0
    //   254: anewarray 4	java/lang/Object
    //   257: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: goto -21 -> 239
    //   263: astore_0
    //   264: aconst_null
    //   265: astore_3
    //   266: aload_3
    //   267: ifnull +7 -> 274
    //   270: aload_3
    //   271: invokevirtual 1015	java/io/FileInputStream:close	()V
    //   274: ldc_w 1860
    //   277: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: aload_0
    //   281: athrow
    //   282: astore_3
    //   283: ldc 177
    //   285: aload_3
    //   286: ldc 179
    //   288: iconst_0
    //   289: anewarray 4	java/lang/Object
    //   292: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   295: goto -21 -> 274
    //   298: astore_0
    //   299: goto -33 -> 266
    //   302: astore 5
    //   304: aload 4
    //   306: astore_0
    //   307: goto -91 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	paramString	String
    //   74	54	1	i	int
    //   103	32	2	j	int
    //   37	234	3	localObject	Object
    //   282	4	3	localIOException	IOException
    //   83	222	4	localFileInputStream	FileInputStream
    //   91	103	5	arrayOfByte	byte[]
    //   212	9	5	localException1	Exception
    //   302	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   142	147	155	java/io/IOException
    //   182	187	196	java/io/IOException
    //   69	85	212	java/lang/Exception
    //   235	239	247	java/io/IOException
    //   69	85	263	finally
    //   270	274	282	java/io/IOException
    //   88	93	298	finally
    //   96	104	298	finally
    //   112	142	298	finally
    //   174	182	298	finally
    //   218	231	298	finally
    //   88	93	302	java/lang/Exception
    //   96	104	302	java/lang/Exception
    //   112	142	302	java/lang/Exception
    //   174	182	302	java/lang/Exception
  }
  
  public static String wC(String paramString)
  {
    AppMethodBeat.i(52293);
    String str = paramString;
    if (paramString != null) {
      str = paramString.replace("\\[", "[[]").replace("%", "").replace("\\^", "").replace("'", "").replace("\\{", "").replace("\\}", "").replace("\"", "");
    }
    AppMethodBeat.o(52293);
    return str;
  }
  
  public static boolean y(Object paramObject1, Object paramObject2)
  {
    boolean bool = true;
    AppMethodBeat.i(52421);
    if (paramObject1 == paramObject2) {}
    for (;;)
    {
      AppMethodBeat.o(52421);
      return bool;
      if ((paramObject1 == null) || (paramObject2 == null) || (!paramObject1.equals(paramObject2))) {
        bool = false;
      }
    }
  }
  
  public static long yB()
  {
    AppMethodBeat.i(52326);
    long l = SystemClock.elapsedRealtime();
    AppMethodBeat.o(52326);
    return l;
  }
  
  public static void z(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(52320);
    paramContext = (Vibrator)paramContext.getSystemService("vibrator");
    if (paramContext == null)
    {
      ab.w("MicroMsg.Util", "shake:vibrator is null!");
      AppMethodBeat.o(52320);
      return;
    }
    if (paramBoolean)
    {
      paramContext.vibrate(glS, -1);
      AppMethodBeat.o(52320);
      return;
    }
    paramContext.cancel();
    AppMethodBeat.o(52320);
  }
  
  public static boolean z(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(52432);
    if ((paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2))))
    {
      AppMethodBeat.o(52432);
      return true;
    }
    AppMethodBeat.o(52432);
    return false;
  }
  
  /* Error */
  public static boolean z(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 1908
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 339	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifne +10 -> 20
    //   13: aload_1
    //   14: invokestatic 1910	com/tencent/mm/sdk/platformtools/bo:ce	([B)Z
    //   17: ifeq +19 -> 36
    //   20: ldc 177
    //   22: ldc_w 1912
    //   25: invokestatic 725	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: ldc_w 1908
    //   31: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: iconst_0
    //   35: ireturn
    //   36: new 1701	java/io/FileOutputStream
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 1913	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   44: astore_2
    //   45: aload_2
    //   46: astore_0
    //   47: aload_2
    //   48: aload_1
    //   49: invokevirtual 1916	java/io/FileOutputStream:write	([B)V
    //   52: aload_2
    //   53: astore_0
    //   54: aload_2
    //   55: invokevirtual 1709	java/io/FileOutputStream:flush	()V
    //   58: aload_2
    //   59: invokevirtual 1710	java/io/FileOutputStream:close	()V
    //   62: ldc 177
    //   64: ldc_w 1918
    //   67: invokestatic 1140	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: ldc_w 1908
    //   73: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: iconst_1
    //   77: ireturn
    //   78: astore_0
    //   79: ldc 177
    //   81: aload_0
    //   82: ldc 179
    //   84: iconst_0
    //   85: anewarray 4	java/lang/Object
    //   88: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: goto -29 -> 62
    //   94: astore_3
    //   95: aconst_null
    //   96: astore_1
    //   97: aload_1
    //   98: astore_0
    //   99: ldc 177
    //   101: aload_3
    //   102: ldc 179
    //   104: iconst_0
    //   105: anewarray 4	java/lang/Object
    //   108: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload_1
    //   112: astore_0
    //   113: ldc 177
    //   115: ldc_w 1920
    //   118: invokestatic 725	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: aload_1
    //   122: ifnull +7 -> 129
    //   125: aload_1
    //   126: invokevirtual 1710	java/io/FileOutputStream:close	()V
    //   129: ldc_w 1908
    //   132: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: iconst_0
    //   136: ireturn
    //   137: astore_0
    //   138: ldc 177
    //   140: aload_0
    //   141: ldc 179
    //   143: iconst_0
    //   144: anewarray 4	java/lang/Object
    //   147: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: goto -21 -> 129
    //   153: astore_1
    //   154: aconst_null
    //   155: astore_0
    //   156: aload_0
    //   157: ifnull +7 -> 164
    //   160: aload_0
    //   161: invokevirtual 1710	java/io/FileOutputStream:close	()V
    //   164: ldc_w 1908
    //   167: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: aload_1
    //   171: athrow
    //   172: astore_0
    //   173: ldc 177
    //   175: aload_0
    //   176: ldc 179
    //   178: iconst_0
    //   179: anewarray 4	java/lang/Object
    //   182: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   185: goto -21 -> 164
    //   188: astore_1
    //   189: goto -33 -> 156
    //   192: astore_3
    //   193: aload_2
    //   194: astore_1
    //   195: goto -98 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramString	String
    //   0	198	1	paramArrayOfByte	byte[]
    //   44	150	2	localFileOutputStream	java.io.FileOutputStream
    //   94	8	3	localException1	Exception
    //   192	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   58	62	78	java/io/IOException
    //   36	45	94	java/lang/Exception
    //   125	129	137	java/io/IOException
    //   36	45	153	finally
    //   160	164	172	java/io/IOException
    //   47	52	188	finally
    //   54	58	188	finally
    //   99	111	188	finally
    //   113	121	188	finally
    //   47	52	192	java/lang/Exception
    //   54	58	192	java/lang/Exception
  }
  
  public static final class a
  {
    private Context context;
    
    public a(Context paramContext)
    {
      this.context = paramContext;
    }
    
    private static String hq(Context paramContext)
    {
      AppMethodBeat.i(52292);
      if (paramContext == null)
      {
        AppMethodBeat.o(52292);
        return null;
      }
      Object localObject1 = (ActivityManager)paramContext.getSystemService("activity");
      paramContext = paramContext.getPackageName();
      if ((localObject1 == null) || (bo.isNullOrNil(paramContext)))
      {
        AppMethodBeat.o(52292);
        return null;
      }
      try
      {
        Object localObject2 = ((ActivityManager)localObject1).getRunningTasks(100);
        localObject1 = new StringBuffer();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ActivityManager.RunningTaskInfo localRunningTaskInfo = (ActivityManager.RunningTaskInfo)((Iterator)localObject2).next();
          if ((localRunningTaskInfo.baseActivity.getClassName().startsWith(paramContext)) || (localRunningTaskInfo.topActivity.getClassName().startsWith(paramContext))) {
            ((StringBuffer)localObject1).append(String.format("{id:%d num:%d/%d top:%s base:%s}", new Object[] { Integer.valueOf(localRunningTaskInfo.id), Integer.valueOf(localRunningTaskInfo.numRunning), Integer.valueOf(localRunningTaskInfo.numActivities), localRunningTaskInfo.topActivity.getShortClassName(), localRunningTaskInfo.baseActivity.getShortClassName() }));
          }
        }
        paramContext = ((StringBuffer)localObject1).toString();
      }
      catch (Exception paramContext)
      {
        ab.printErrStackTrace("MicroMsg.Util", paramContext, "", new Object[0]);
        AppMethodBeat.o(52292);
        return "";
      }
      AppMethodBeat.o(52292);
      return paramContext;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(52291);
      String str = hq(this.context);
      AppMethodBeat.o(52291);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bo
 * JD-Core Version:    0.7.0.1
 */