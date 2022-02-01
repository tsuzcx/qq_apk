package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
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
import com.tencent.mm.b.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
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

public final class bt
{
  private static final TimeZone GMT;
  private static final long[] IgF;
  public static final long[] iQc;
  private static final char[] mOA;
  private static final String[] mOB;
  private static final BigInteger soL;
  
  static
  {
    AppMethodBeat.i(158002);
    iQc = new long[] { 300L, 200L, 300L, 200L };
    IgF = new long[] { 300L, 50L, 300L, 50L };
    GMT = TimeZone.getTimeZone("GMT");
    soL = BigInteger.ONE.shiftLeft(64);
    mOA = new char[] { 60, 62, 34, 39, 38, 13, 10, 32, 9 };
    mOB = new String[] { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&#x0D;", "&#x0A;", "&#x20;", "&#x09;" };
    AppMethodBeat.o(158002);
  }
  
  public static String C(double paramDouble)
  {
    AppMethodBeat.i(158001);
    String str = String.format("%.2f", new Object[] { Double.valueOf(paramDouble) });
    AppMethodBeat.o(158001);
    return str;
  }
  
  public static String Db(long paramLong)
  {
    AppMethodBeat.i(157865);
    String str = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date(paramLong));
    AppMethodBeat.o(157865);
    return str;
  }
  
  public static String Dc(long paramLong)
  {
    AppMethodBeat.i(157866);
    String str = new SimpleDateFormat("[yy-MM-dd HH:mm:ss]").format(new java.util.Date(1000L * paramLong));
    AppMethodBeat.o(157866);
    return str;
  }
  
  public static String Dd(long paramLong)
  {
    AppMethodBeat.i(157877);
    String str = a(paramLong, 10.0D);
    AppMethodBeat.o(157877);
    return str;
  }
  
  public static String De(long paramLong)
  {
    AppMethodBeat.i(157923);
    BigInteger localBigInteger = BigInteger.valueOf(paramLong);
    Object localObject = localBigInteger;
    if (localBigInteger.signum() < 0) {
      localObject = localBigInteger.add(soL);
    }
    localObject = ((BigInteger)localObject).toString();
    AppMethodBeat.o(157923);
    return localObject;
  }
  
  public static long Df(long paramLong)
  {
    AppMethodBeat.i(157980);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(157980);
    return l - paramLong;
  }
  
  public static int Dg(long paramLong)
  {
    AppMethodBeat.i(158000);
    int i = Math.round((float)paramLong / 1000.0F);
    AppMethodBeat.o(158000);
    return i;
  }
  
  public static boolean E(char paramChar)
  {
    AppMethodBeat.i(157867);
    Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
    if ((localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (localUnicodeBlock == Character.UnicodeBlock.GENERAL_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS))
    {
      AppMethodBeat.o(157867);
      return true;
    }
    AppMethodBeat.o(157867);
    return false;
  }
  
  public static void F(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(157883);
    paramContext = (Vibrator)paramContext.getSystemService("vibrator");
    if (paramContext == null)
    {
      ad.w("MicroMsg.Util", "shake:vibrator is null!");
      AppMethodBeat.o(157883);
      return;
    }
    if (paramBoolean)
    {
      paramContext.vibrate(iQc, -1);
      AppMethodBeat.o(157883);
      return;
    }
    paramContext.cancel();
    AppMethodBeat.o(157883);
  }
  
  public static boolean F(char paramChar)
  {
    return ((paramChar >= 'a') && (paramChar <= 'z')) || ((paramChar >= 'A') && (paramChar <= 'Z'));
  }
  
  public static boolean G(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  public static long HI()
  {
    AppMethodBeat.i(157889);
    long l = SystemClock.elapsedRealtime();
    AppMethodBeat.o(157889);
    return l;
  }
  
  public static boolean J(Object paramObject1, Object paramObject2)
  {
    boolean bool = true;
    AppMethodBeat.i(157984);
    if (paramObject1 == paramObject2) {}
    for (;;)
    {
      AppMethodBeat.o(157984);
      return bool;
      if ((paramObject1 == null) || (paramObject2 == null) || (!paramObject1.equals(paramObject2))) {
        bool = false;
      }
    }
  }
  
  public static boolean K(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(157995);
    if ((paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2))))
    {
      AppMethodBeat.o(157995);
      return true;
    }
    AppMethodBeat.o(157995);
    return false;
  }
  
  public static String S(InputStream paramInputStream)
  {
    AppMethodBeat.i(157962);
    if (paramInputStream == null)
    {
      AppMethodBeat.o(157962);
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
        AppMethodBeat.o(157962);
        throw localObject;
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
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
          AppMethodBeat.o(157962);
          return paramInputStream;
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            ad.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
          }
        }
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
        }
      }
    }
    finally {}
  }
  
  public static boolean T(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(157892);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(5) == localCalendar2.get(5)) && (localCalendar1.get(2) == localCalendar2.get(2)))
    {
      AppMethodBeat.o(157892);
      return true;
    }
    AppMethodBeat.o(157892);
    return false;
  }
  
  public static ArrayList<String> U(String[] paramArrayOfString)
  {
    AppMethodBeat.i(157860);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(157860);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      localArrayList.add(paramArrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(157860);
    return localArrayList;
  }
  
  public static boolean V(String... paramVarArgs)
  {
    boolean bool2 = false;
    AppMethodBeat.i(157917);
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
        AppMethodBeat.o(157917);
        return bool1;
      }
      i += 1;
    }
  }
  
  public static final String Xm(String paramString)
  {
    AppMethodBeat.i(157935);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(157935);
      return "";
    }
    try
    {
      String str = new URL(paramString).getHost();
      AppMethodBeat.o(157935);
      return str;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      ad.printErrStackTrace("MicroMsg.Util", localMalformedURLException, "", new Object[0]);
      ad.w("MicroMsg.Util", "get host error");
      AppMethodBeat.o(157935);
    }
    return paramString;
  }
  
  public static String Z(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(157880);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(157880);
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
      AppMethodBeat.o(157880);
      return paramArrayOfByte;
    }
  }
  
  public static int a(Integer paramInteger, int paramInt)
  {
    AppMethodBeat.i(157909);
    if (paramInteger == null)
    {
      AppMethodBeat.o(157909);
      return paramInt;
    }
    paramInt = paramInteger.intValue();
    AppMethodBeat.o(157909);
    return paramInt;
  }
  
  private static int a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(157940);
    if (paramInt2 <= 0)
    {
      AppMethodBeat.o(157940);
      return 0;
    }
    if (paramArrayOfChar[paramInt1] == '#')
    {
      if ((paramInt2 > 1) && ((paramArrayOfChar[(paramInt1 + 1)] == 'x') || (paramArrayOfChar[(paramInt1 + 1)] == 'X'))) {
        try
        {
          paramInt1 = Integer.parseInt(new String(paramArrayOfChar, paramInt1 + 2, paramInt2 - 2), 16);
          AppMethodBeat.o(157940);
          return paramInt1;
        }
        catch (NumberFormatException paramArrayOfChar)
        {
          AppMethodBeat.o(157940);
          return 0;
        }
      }
      try
      {
        paramInt1 = Integer.parseInt(new String(paramArrayOfChar, paramInt1 + 1, paramInt2 - 1), 10);
        AppMethodBeat.o(157940);
        return paramInt1;
      }
      catch (NumberFormatException paramArrayOfChar)
      {
        AppMethodBeat.o(157940);
        return 0;
      }
    }
    new String(paramArrayOfChar, paramInt1, paramInt2);
    AppMethodBeat.o(157940);
    return 0;
  }
  
  public static long a(Long paramLong, long paramLong1)
  {
    AppMethodBeat.i(157910);
    if (paramLong == null)
    {
      AppMethodBeat.o(157910);
      return paramLong1;
    }
    paramLong1 = paramLong.longValue();
    AppMethodBeat.o(157910);
    return paramLong1;
  }
  
  public static String a(long paramLong, double paramDouble)
  {
    AppMethodBeat.i(157876);
    paramDouble = Math.round(paramLong * paramDouble / 1048576.0D) / paramDouble;
    String str = paramDouble + " MB";
    AppMethodBeat.o(157876);
    return str;
  }
  
  /* Error */
  private static String a(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 405
    //   6: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokevirtual 409	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: aload_1
    //   14: iconst_1
    //   15: anewarray 74	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: ldc_w 411
    //   23: aastore
    //   24: aload_2
    //   25: aload_3
    //   26: aconst_null
    //   27: invokevirtual 417	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   30: astore_0
    //   31: aload_0
    //   32: ifnull +88 -> 120
    //   35: aload_0
    //   36: invokeinterface 423 1 0
    //   41: ifeq +79 -> 120
    //   44: aload_0
    //   45: ldc_w 411
    //   48: invokeinterface 427 2 0
    //   53: istore 4
    //   55: iload 4
    //   57: iconst_m1
    //   58: if_icmpne +35 -> 93
    //   61: ldc 224
    //   63: ldc_w 429
    //   66: invokestatic 432	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_0
    //   70: invokeinterface 433 1 0
    //   75: aload_0
    //   76: ifnull +9 -> 85
    //   79: aload_0
    //   80: invokeinterface 433 1 0
    //   85: ldc_w 405
    //   88: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aconst_null
    //   92: areturn
    //   93: aload_0
    //   94: iload 4
    //   96: invokeinterface 437 2 0
    //   101: astore_2
    //   102: aload_0
    //   103: ifnull +9 -> 112
    //   106: aload_0
    //   107: invokeinterface 433 1 0
    //   112: ldc_w 405
    //   115: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_2
    //   119: areturn
    //   120: aload_0
    //   121: ifnull +9 -> 130
    //   124: aload_0
    //   125: invokeinterface 433 1 0
    //   130: ldc_w 405
    //   133: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aconst_null
    //   137: areturn
    //   138: astore_0
    //   139: aload 5
    //   141: astore_0
    //   142: aload_1
    //   143: invokevirtual 442	android/net/Uri:getPath	()Ljava/lang/String;
    //   146: astore_2
    //   147: aload_2
    //   148: astore_1
    //   149: bipush 24
    //   151: invokestatic 448	com/tencent/mm/compatible/util/d:ly	(I)Z
    //   154: ifeq +14 -> 168
    //   157: aload_2
    //   158: ldc_w 450
    //   161: ldc_w 286
    //   164: invokevirtual 454	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   167: astore_1
    //   168: aload_0
    //   169: ifnull +9 -> 178
    //   172: aload_0
    //   173: invokeinterface 433 1 0
    //   178: ldc_w 405
    //   181: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: aload_1
    //   185: areturn
    //   186: astore_1
    //   187: aconst_null
    //   188: astore_0
    //   189: aload_0
    //   190: ifnull +9 -> 199
    //   193: aload_0
    //   194: invokeinterface 433 1 0
    //   199: ldc_w 405
    //   202: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: aload_1
    //   206: athrow
    //   207: astore_1
    //   208: goto -19 -> 189
    //   211: astore_1
    //   212: goto -23 -> 189
    //   215: astore_2
    //   216: goto -74 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	paramContext	Context
    //   0	219	1	paramUri	Uri
    //   0	219	2	paramString	String
    //   0	219	3	paramArrayOfString	String[]
    //   53	42	4	i	int
    //   1	139	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	31	138	java/lang/Exception
    //   9	31	186	finally
    //   35	55	207	finally
    //   61	75	207	finally
    //   93	102	207	finally
    //   142	147	211	finally
    //   149	168	211	finally
    //   35	55	215	java/lang/Exception
    //   61	75	215	java/lang/Exception
    //   93	102	215	java/lang/Exception
  }
  
  public static String a(LinkedHashMap<String, String> paramLinkedHashMap)
  {
    AppMethodBeat.i(157941);
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
    AppMethodBeat.o(157941);
    return paramLinkedHashMap;
  }
  
  public static boolean a(Boolean paramBoolean, boolean paramBoolean1)
  {
    AppMethodBeat.i(157911);
    if (paramBoolean == null)
    {
      AppMethodBeat.o(157911);
      return paramBoolean1;
    }
    paramBoolean1 = paramBoolean.booleanValue();
    AppMethodBeat.o(157911);
    return paramBoolean1;
  }
  
  public static boolean aA(long paramLong1, long paramLong2)
  {
    return paramLong1 == paramLong2;
  }
  
  public static byte[] aF(Bitmap paramBitmap)
  {
    AppMethodBeat.i(157872);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    ad.i("MicroMsg.Util", "recycle bitmap:%s", new Object[] { paramBitmap });
    paramBitmap.recycle();
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      AppMethodBeat.o(157872);
      return paramBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Util", localException, "", new Object[0]);
      }
    }
  }
  
  public static ActivityManager.RunningTaskInfo aJ(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(157976);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1000).iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningTaskInfo localRunningTaskInfo = (ActivityManager.RunningTaskInfo)paramContext.next();
      if (localRunningTaskInfo.id == paramInt)
      {
        AppMethodBeat.o(157976);
        return localRunningTaskInfo;
      }
    }
    AppMethodBeat.o(157976);
    return null;
  }
  
  public static long aO(long paramLong)
  {
    AppMethodBeat.i(157888);
    long l = SystemClock.elapsedRealtime();
    AppMethodBeat.o(157888);
    return l - paramLong;
  }
  
  public static long aQJ()
  {
    AppMethodBeat.i(157885);
    long l = System.currentTimeMillis() / 1000L;
    AppMethodBeat.o(157885);
    return l;
  }
  
  public static String aQN(String paramString)
  {
    AppMethodBeat.i(157856);
    String str = paramString;
    if (paramString != null) {
      str = paramString.replace("\\[", "[[]").replace("%", "").replace("\\^", "").replace("'", "").replace("\\{", "").replace("\\}", "").replace("\"", "");
    }
    AppMethodBeat.o(157856);
    return str;
  }
  
  public static String aQO(String paramString)
  {
    AppMethodBeat.i(157857);
    String str = paramString;
    if (paramString != null) {
      str = paramString.replace("../", "");
    }
    AppMethodBeat.o(157857);
    return str;
  }
  
  public static boolean aQP(String paramString)
  {
    AppMethodBeat.i(157868);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(157868);
      return false;
    }
    boolean bool = Pattern.compile("[\\u4e00-\\u9fa5]+").matcher(paramString).find();
    AppMethodBeat.o(157868);
    return bool;
  }
  
  public static boolean aQQ(String paramString)
  {
    AppMethodBeat.i(157869);
    paramString = paramString.toCharArray();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      int k = paramString[i];
      if (((k < 97) || (k > 122)) && ((k < 65) || (k > 90)))
      {
        AppMethodBeat.o(157869);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(157869);
    return true;
  }
  
  public static boolean aQR(String paramString)
  {
    AppMethodBeat.i(157870);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(157870);
      return false;
    }
    paramString = paramString.trim();
    try
    {
      long l = Long.valueOf(paramString).longValue();
      if ((l > 0L) && (l <= 4294967295L))
      {
        AppMethodBeat.o(157870);
        return true;
      }
    }
    catch (NumberFormatException paramString)
    {
      ad.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(157870);
      return false;
    }
    AppMethodBeat.o(157870);
    return false;
  }
  
  public static boolean aQS(String paramString)
  {
    AppMethodBeat.i(157871);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(157871);
      return false;
    }
    boolean bool = paramString.trim().matches("^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$");
    AppMethodBeat.o(157871);
    return bool;
  }
  
  public static boolean aQT(String paramString)
  {
    AppMethodBeat.i(157873);
    if (paramString == null)
    {
      AppMethodBeat.o(157873);
      return false;
    }
    paramString = paramString.trim();
    if ((paramString.length() < 6) || (paramString.length() > 20))
    {
      AppMethodBeat.o(157873);
      return false;
    }
    if (!F(paramString.charAt(0)))
    {
      AppMethodBeat.o(157873);
      return false;
    }
    int i = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if ((!F(c)) && (!G(c)) && (c != '-') && (c != '_'))
      {
        AppMethodBeat.o(157873);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(157873);
    return true;
  }
  
  public static boolean aQU(String paramString)
  {
    AppMethodBeat.i(157874);
    if (paramString == null)
    {
      AppMethodBeat.o(157874);
      return false;
    }
    if (paramString.length() < 8)
    {
      AppMethodBeat.o(157874);
      return false;
    }
    try
    {
      Long.parseLong(paramString);
      AppMethodBeat.o(157874);
      return false;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(157874);
    }
    return true;
  }
  
  public static int aQV(String paramString)
  {
    AppMethodBeat.i(157918);
    if (paramString == null)
    {
      AppMethodBeat.o(157918);
      return -1;
    }
    int i = paramString.length();
    AppMethodBeat.o(157918);
    return i;
  }
  
  public static int aQW(String paramString)
  {
    AppMethodBeat.i(157919);
    if (paramString == null)
    {
      AppMethodBeat.o(157919);
      return -1;
    }
    int i = paramString.getBytes(Charset.forName("UTF-8")).length;
    AppMethodBeat.o(157919);
    return i;
  }
  
  public static int aQX(String paramString)
  {
    AppMethodBeat.i(157920);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(157920);
      return 0;
    }
    try
    {
      long l = new SimpleDateFormat("yyyy-MM-dd").parse(paramString).getTime() / 1000L;
      int i = (int)l;
      AppMethodBeat.o(157920);
      return i;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(157920);
    }
    return 0;
  }
  
  public static String aQY(String paramString)
  {
    AppMethodBeat.i(194958);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (str.length() <= 16)
    {
      paramString = g.getMessageDigest(str.getBytes());
      AppMethodBeat.o(194958);
      return paramString;
    }
    paramString = g.getMessageDigest(str.substring(0, 16).getBytes());
    AppMethodBeat.o(194958);
    return paramString;
  }
  
  public static String aQZ(String paramString)
  {
    AppMethodBeat.i(221724);
    paramString = g.getMessageDigest(paramString.getBytes());
    AppMethodBeat.o(221724);
    return paramString;
  }
  
  public static byte[] aRa(String paramString)
  {
    AppMethodBeat.i(157932);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(157932);
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
      AppMethodBeat.o(157932);
      return arrayOfByte;
    }
    catch (NumberFormatException paramString)
    {
      ad.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(157932);
    }
    return new byte[0];
  }
  
  public static int[] aRb(String paramString)
  {
    AppMethodBeat.i(157933);
    if (paramString == null)
    {
      AppMethodBeat.o(157933);
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
            ad.printErrStackTrace("MicroMsg.Util", localException, "", new Object[0]);
            ad.e("MicroMsg.Util", "invalid port num, ignore");
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
    AppMethodBeat.o(157933);
    return localObject;
  }
  
  public static String aRc(String paramString)
  {
    AppMethodBeat.i(157938);
    if (paramString == null)
    {
      AppMethodBeat.o(157938);
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int n = paramString.length();
    int j = 0;
    if (j < n)
    {
      char c = paramString.charAt(j);
      int m = 1;
      int k = mOA.length - 1;
      for (;;)
      {
        int i = m;
        if (k >= 0)
        {
          if (mOA[k] == c)
          {
            localStringBuffer.append(mOB[k]);
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
    AppMethodBeat.o(157938);
    return paramString;
  }
  
  public static String aRd(String paramString)
  {
    AppMethodBeat.i(157939);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(157939);
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
            AppMethodBeat.o(157939);
            return paramString;
            AppMethodBeat.o(157939);
            return paramString;
          }
          j = i;
        }
      }
    }
  }
  
  public static int aRe(String paramString)
  {
    AppMethodBeat.i(157942);
    int j = 0;
    try
    {
      i = Integer.parseInt(paramString);
      AppMethodBeat.o(157942);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = j;
        if (paramString != null)
        {
          ad.e("MicroMsg.Util", "parserInt error ".concat(String.valueOf(paramString)));
          i = j;
        }
      }
    }
  }
  
  public static long aRf(String paramString)
  {
    AppMethodBeat.i(157943);
    long l2 = 0L;
    try
    {
      l1 = Long.parseLong(paramString);
      AppMethodBeat.o(157943);
      return l1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = l2;
        if (paramString != null)
        {
          ad.e("MicroMsg.Util", "parseLong error ".concat(String.valueOf(paramString)));
          l1 = l2;
        }
      }
    }
  }
  
  public static double aRg(String paramString)
  {
    AppMethodBeat.i(157944);
    double d2 = 0.0D;
    try
    {
      d1 = Double.parseDouble(paramString);
      AppMethodBeat.o(157944);
      return d1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        double d1 = d2;
        if (paramString != null)
        {
          ad.e("MicroMsg.Util", "parseDouble error ".concat(String.valueOf(paramString)));
          d1 = d2;
        }
      }
    }
  }
  
  public static float aRh(String paramString)
  {
    AppMethodBeat.i(157945);
    float f2 = 0.0F;
    try
    {
      f1 = Float.parseFloat(paramString);
      AppMethodBeat.o(157945);
      return f1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        float f1 = f2;
        if (paramString != null)
        {
          ad.e("MicroMsg.Util", "parseFloat error ".concat(String.valueOf(paramString)));
          f1 = f2;
        }
      }
    }
  }
  
  public static byte[] aRi(String paramString)
  {
    AppMethodBeat.i(157954);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.Util", "httpGet, url is null");
      AppMethodBeat.o(157954);
      return null;
    }
    if (URLUtil.isDataUrl(paramString))
    {
      paramString = aRl(paramString);
      AppMethodBeat.o(157954);
      return paramString;
    }
    if (URLUtil.isHttpsUrl(paramString))
    {
      paramString = aRk(paramString);
      AppMethodBeat.o(157954);
      return paramString;
    }
    paramString = aRj(paramString);
    AppMethodBeat.o(157954);
    return paramString;
  }
  
  /* Error */
  private static byte[] aRj(String paramString)
  {
    // Byte code:
    //   0: ldc_w 803
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 330	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 331	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 807	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 809	java/net/HttpURLConnection
    //   20: astore_0
    //   21: aload_0
    //   22: ldc_w 811
    //   25: invokevirtual 814	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: invokevirtual 817	java/net/HttpURLConnection:getResponseCode	()I
    //   32: istore_1
    //   33: iload_1
    //   34: sipush 200
    //   37: if_icmpeq +46 -> 83
    //   40: ldc 224
    //   42: ldc_w 819
    //   45: iconst_1
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: iload_1
    //   52: invokestatic 709	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: invokestatic 821	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aconst_null
    //   60: invokestatic 825	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   63: aconst_null
    //   64: invokestatic 825	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   67: aload_0
    //   68: ifnull +7 -> 75
    //   71: aload_0
    //   72: invokevirtual 828	java/net/HttpURLConnection:disconnect	()V
    //   75: ldc_w 803
    //   78: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aconst_null
    //   82: areturn
    //   83: new 830	java/io/BufferedInputStream
    //   86: dup
    //   87: aload_0
    //   88: invokevirtual 834	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   91: invokespecial 837	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   94: astore 4
    //   96: new 515	java/io/ByteArrayOutputStream
    //   99: dup
    //   100: invokespecial 516	java/io/ByteArrayOutputStream:<init>	()V
    //   103: astore_2
    //   104: sipush 4096
    //   107: newarray byte
    //   109: astore_3
    //   110: aload 4
    //   112: aload_3
    //   113: invokevirtual 838	java/io/BufferedInputStream:read	([B)I
    //   116: istore_1
    //   117: iload_1
    //   118: ifle +20 -> 138
    //   121: aload_2
    //   122: aload_3
    //   123: iconst_0
    //   124: iload_1
    //   125: invokevirtual 841	java/io/ByteArrayOutputStream:write	([BII)V
    //   128: aload 4
    //   130: aload_3
    //   131: invokevirtual 838	java/io/BufferedInputStream:read	([B)I
    //   134: istore_1
    //   135: goto -18 -> 117
    //   138: aload_2
    //   139: invokevirtual 540	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   142: astore_3
    //   143: aload 4
    //   145: invokestatic 825	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   148: aload_2
    //   149: invokestatic 825	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   152: aload_0
    //   153: ifnull +7 -> 160
    //   156: aload_0
    //   157: invokevirtual 828	java/net/HttpURLConnection:disconnect	()V
    //   160: ldc_w 803
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
    //   176: ldc 224
    //   178: ldc_w 843
    //   181: iconst_1
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload_0
    //   188: invokevirtual 846	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   191: aastore
    //   192: invokestatic 821	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: aload 4
    //   197: invokestatic 825	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   200: aload_2
    //   201: invokestatic 825	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   204: aload_3
    //   205: ifnull +7 -> 212
    //   208: aload_3
    //   209: invokevirtual 828	java/net/HttpURLConnection:disconnect	()V
    //   212: ldc_w 803
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
    //   230: invokestatic 825	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   233: aload_2
    //   234: invokestatic 825	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   237: aload_3
    //   238: ifnull +7 -> 245
    //   241: aload_3
    //   242: invokevirtual 828	java/net/HttpURLConnection:disconnect	()V
    //   245: ldc_w 803
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
  private static byte[] aRk(String paramString)
  {
    // Byte code:
    //   0: ldc_w 847
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 330	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 331	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 807	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 849	javax/net/ssl/HttpsURLConnection
    //   20: astore_0
    //   21: aload_0
    //   22: ldc_w 811
    //   25: invokevirtual 814	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: invokevirtual 817	java/net/HttpURLConnection:getResponseCode	()I
    //   32: istore_1
    //   33: iload_1
    //   34: sipush 200
    //   37: if_icmpeq +46 -> 83
    //   40: ldc 224
    //   42: ldc_w 851
    //   45: iconst_1
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: iload_1
    //   52: invokestatic 709	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: invokestatic 821	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aconst_null
    //   60: invokestatic 825	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   63: aconst_null
    //   64: invokestatic 825	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   67: aload_0
    //   68: ifnull +7 -> 75
    //   71: aload_0
    //   72: invokevirtual 828	java/net/HttpURLConnection:disconnect	()V
    //   75: ldc_w 847
    //   78: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aconst_null
    //   82: areturn
    //   83: new 830	java/io/BufferedInputStream
    //   86: dup
    //   87: aload_0
    //   88: invokevirtual 834	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   91: invokespecial 837	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   94: astore 4
    //   96: new 515	java/io/ByteArrayOutputStream
    //   99: dup
    //   100: invokespecial 516	java/io/ByteArrayOutputStream:<init>	()V
    //   103: astore_2
    //   104: sipush 4096
    //   107: newarray byte
    //   109: astore_3
    //   110: aload 4
    //   112: aload_3
    //   113: invokevirtual 838	java/io/BufferedInputStream:read	([B)I
    //   116: istore_1
    //   117: iload_1
    //   118: ifle +20 -> 138
    //   121: aload_2
    //   122: aload_3
    //   123: iconst_0
    //   124: iload_1
    //   125: invokevirtual 841	java/io/ByteArrayOutputStream:write	([BII)V
    //   128: aload 4
    //   130: aload_3
    //   131: invokevirtual 838	java/io/BufferedInputStream:read	([B)I
    //   134: istore_1
    //   135: goto -18 -> 117
    //   138: aload_2
    //   139: invokevirtual 540	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   142: astore_3
    //   143: aload 4
    //   145: invokevirtual 852	java/io/BufferedInputStream:close	()V
    //   148: aload_2
    //   149: invokevirtual 541	java/io/ByteArrayOutputStream:close	()V
    //   152: aload 4
    //   154: invokestatic 825	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   157: aload_2
    //   158: invokestatic 825	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   161: aload_0
    //   162: ifnull +7 -> 169
    //   165: aload_0
    //   166: invokevirtual 828	java/net/HttpURLConnection:disconnect	()V
    //   169: ldc_w 847
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
    //   185: ldc 224
    //   187: ldc_w 854
    //   190: iconst_1
    //   191: anewarray 4	java/lang/Object
    //   194: dup
    //   195: iconst_0
    //   196: aload_0
    //   197: invokevirtual 846	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   200: aastore
    //   201: invokestatic 821	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: aload 4
    //   206: invokestatic 825	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   209: aload_2
    //   210: invokestatic 825	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   213: aload_3
    //   214: ifnull +7 -> 221
    //   217: aload_3
    //   218: invokevirtual 828	java/net/HttpURLConnection:disconnect	()V
    //   221: ldc_w 847
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
    //   239: invokestatic 825	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   242: aload_2
    //   243: invokestatic 825	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   246: aload_3
    //   247: ifnull +7 -> 254
    //   250: aload_3
    //   251: invokevirtual 828	java/net/HttpURLConnection:disconnect	()V
    //   254: ldc_w 847
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
  
  private static byte[] aRl(String paramString)
  {
    AppMethodBeat.i(157957);
    try
    {
      int i = paramString.indexOf("base64");
      String str = paramString;
      if (i > 0) {
        str = paramString.substring(i + 7);
      }
      paramString = Base64.decode(str, 0);
      AppMethodBeat.o(157957);
      return paramString;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.Util", "decode base64 url failed : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(157957);
    }
    return null;
  }
  
  public static String aRm(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(157960);
    if ((isNullOrNil(paramString)) || (paramString.startsWith("+")))
    {
      AppMethodBeat.o(157960);
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
      AppMethodBeat.o(157960);
      return paramString;
    }
    AppMethodBeat.o(157960);
    return paramString;
  }
  
  public static Boolean aRn(String paramString)
  {
    AppMethodBeat.i(157961);
    Matcher localMatcher = Pattern.compile("^[+][0-9]{10,13}$").matcher(paramString);
    paramString = Pattern.compile("^1[0-9]{10}$").matcher(paramString);
    if ((localMatcher.matches()) || (paramString.matches())) {}
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(157961);
      return Boolean.valueOf(bool);
    }
  }
  
  public static String aRo(String paramString)
  {
    AppMethodBeat.i(157963);
    if ((paramString != null) && (paramString.length() > 0))
    {
      int i = paramString.lastIndexOf("@");
      if (i != -1)
      {
        paramString = paramString.substring(0, i);
        AppMethodBeat.o(157963);
        return paramString;
      }
    }
    AppMethodBeat.o(157963);
    return paramString;
  }
  
  public static String aRp(String paramString)
  {
    AppMethodBeat.i(157964);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(157964);
      return "";
    }
    int i = paramString.length();
    if (i < 4)
    {
      paramString = "*~".concat(String.valueOf(i));
      AppMethodBeat.o(157964);
      return paramString;
    }
    if (i < 8)
    {
      paramString = paramString.substring(0, 1) + "*" + paramString.substring(i - 2, i - 1) + "~" + i;
      AppMethodBeat.o(157964);
      return paramString;
    }
    paramString = paramString.substring(0, 2) + "*" + paramString.substring(i - 3, i - 1) + "~" + i;
    AppMethodBeat.o(157964);
    return paramString;
  }
  
  public static boolean aRq(String paramString)
  {
    AppMethodBeat.i(157970);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(157970);
      return false;
    }
    try
    {
      String str = new File(i.k(paramString, false)).getCanonicalPath();
      boolean bool = aRr(str);
      AppMethodBeat.o(157970);
      return bool;
    }
    catch (NullPointerException localNullPointerException)
    {
      ad.printErrStackTrace("MicroMsg.Util", localNullPointerException, "[-] Fail to resolve canonical path of %s", new Object[] { paramString });
      AppMethodBeat.o(157970);
      return false;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("MicroMsg.Util", localIOException, "[-] Fail to resolve canonical path of %s", new Object[] { paramString });
      AppMethodBeat.o(157970);
    }
    return false;
  }
  
  public static boolean aRr(String paramString)
  {
    AppMethodBeat.i(194960);
    String str1 = d.fjS().getPackageName();
    if (paramString.contains("/" + str1 + "/cache/"))
    {
      AppMethodBeat.o(194960);
      return true;
    }
    String str2 = "/" + str1 + "-";
    int i = paramString.indexOf(str2);
    if ((i >= 0) && (paramString.startsWith("/cache/", paramString.indexOf("/", str2.length() + i))))
    {
      AppMethodBeat.o(194960);
      return true;
    }
    if ((paramString.contains("/data/data/")) || (paramString.contains("/data/user/")))
    {
      if ((!paramString.contains("/" + str1 + "/")) && (!paramString.contains("/" + str1 + "-")))
      {
        AppMethodBeat.o(194960);
        return true;
      }
      AppMethodBeat.o(194960);
      return false;
    }
    AppMethodBeat.o(194960);
    return true;
  }
  
  public static boolean aRs(String paramString)
  {
    AppMethodBeat.i(157971);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(157971);
      return false;
    }
    int i = paramString.lastIndexOf(".");
    if (i == -1)
    {
      AppMethodBeat.o(157971);
      return false;
    }
    boolean bool = aRt(paramString.substring(i + 1));
    AppMethodBeat.o(157971);
    return bool;
  }
  
  public static boolean aRt(String paramString)
  {
    AppMethodBeat.i(157972);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(157972);
      return false;
    }
    paramString = paramString.toLowerCase();
    if ((paramString.equals("webp")) && (Build.VERSION.SDK_INT >= 14))
    {
      AppMethodBeat.o(157972);
      return true;
    }
    if ((paramString.equals("heic")) && (Build.VERSION.SDK_INT >= 28))
    {
      AppMethodBeat.o(157972);
      return true;
    }
    if ((paramString.equals("jpg")) || (paramString.equals("gif")) || (paramString.equals("bmp")) || (paramString.equals("jpeg")) || (paramString.equals("png")))
    {
      AppMethodBeat.o(157972);
      return true;
    }
    AppMethodBeat.o(157972);
    return false;
  }
  
  public static String aRu(String paramString)
  {
    AppMethodBeat.i(157983);
    if (paramString == null)
    {
      AppMethodBeat.o(157983);
      return null;
    }
    int i = paramString.length();
    while (i > 0)
    {
      if ((paramString.charAt(i - 1) != '\n') && (paramString.charAt(i - 1) != '\r'))
      {
        paramString = paramString.substring(0, i);
        AppMethodBeat.o(157983);
        return paramString;
      }
      i -= 1;
    }
    AppMethodBeat.o(157983);
    return paramString;
  }
  
  public static String aRv(String paramString)
  {
    AppMethodBeat.i(157988);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(157988);
      return paramString;
    }
    paramString = paramString.replaceAll("‮", "");
    AppMethodBeat.o(157988);
    return paramString;
  }
  
  public static final String aRw(String paramString)
  {
    AppMethodBeat.i(157990);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(157990);
      return null;
    }
    paramString = Uri.parse(paramString).getHost();
    AppMethodBeat.o(157990);
    return paramString;
  }
  
  public static String aaz(int paramInt)
  {
    AppMethodBeat.i(157986);
    Object localObject = new Random();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramInt)
    {
      localStringBuffer.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(((Random)localObject).nextInt(62)));
      i += 1;
    }
    localObject = localStringBuffer.toString();
    AppMethodBeat.o(157986);
    return localObject;
  }
  
  public static List<ResolveInfo> ac(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(157903);
    if ((paramContext == null) || (paramIntent == null))
    {
      AppMethodBeat.o(157903);
      return null;
    }
    paramContext = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536);
    AppMethodBeat.o(157903);
    return paramContext;
  }
  
  public static boolean ai(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(157916);
    if ((paramCharSequence == null) || (paramCharSequence.length() <= 0))
    {
      AppMethodBeat.o(157916);
      return true;
    }
    AppMethodBeat.o(157916);
    return false;
  }
  
  public static CharSequence aj(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(157958);
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
    AppMethodBeat.o(157958);
    return paramCharSequence;
  }
  
  public static boolean aj(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(157902);
    paramContext = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536);
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      AppMethodBeat.o(157902);
      return true;
    }
    AppMethodBeat.o(157902);
    return false;
  }
  
  public static Intent ak(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(157998);
    paramContext = paramContext.getPackageManager().queryIntentServices(paramIntent, 0);
    if ((paramContext == null) || (paramContext.size() != 1))
    {
      AppMethodBeat.o(157998);
      return null;
    }
    Object localObject = (ResolveInfo)paramContext.get(0);
    paramContext = ((ResolveInfo)localObject).serviceInfo.packageName;
    localObject = ((ResolveInfo)localObject).serviceInfo.name;
    ad.d("MicroMsg.Util", "createExplicitFromImplicitIntent pa:%s, cl:%s", new Object[] { paramContext, localObject });
    paramContext = new ComponentName(paramContext, (String)localObject);
    paramIntent = new Intent(paramIntent);
    paramIntent.setComponent(paramContext);
    AppMethodBeat.o(157998);
    return paramIntent;
  }
  
  public static String aoj(String paramString)
  {
    AppMethodBeat.i(157959);
    paramString = paramString.replaceAll("[\\.\\-]", "").trim();
    AppMethodBeat.o(157959);
    return paramString;
  }
  
  public static String b(long paramLong, double paramDouble)
  {
    AppMethodBeat.i(157878);
    paramDouble = Math.round(paramLong * paramDouble / 1073741824.0D) / paramDouble;
    String str = paramDouble + " GB";
    AppMethodBeat.o(157878);
    return str;
  }
  
  public static int bC(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(157989);
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte.order(ByteOrder.nativeOrder());
    int i = paramArrayOfByte.getInt();
    AppMethodBeat.o(157989);
    return i;
  }
  
  public static String bI(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2;
    }
    return paramString1;
  }
  
  public static String ba(float paramFloat)
  {
    AppMethodBeat.i(157982);
    if (paramFloat < 1024.0F)
    {
      str = String.format("%.1fB", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(157982);
      return str;
    }
    if (paramFloat < 1048576.0F)
    {
      str = String.format("%.1fKB", new Object[] { Float.valueOf(paramFloat / 1024.0F) });
      AppMethodBeat.o(157982);
      return str;
    }
    if (paramFloat < 1.073742E+009F)
    {
      str = String.format("%.1fMB", new Object[] { Float.valueOf(paramFloat / 1024.0F / 1024.0F) });
      AppMethodBeat.o(157982);
      return str;
    }
    String str = String.format("%.1fGB", new Object[] { Float.valueOf(paramFloat / 1024.0F / 1024.0F / 1024.0F) });
    AppMethodBeat.o(157982);
    return str;
  }
  
  public static String cA(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(157879);
    paramArrayOfByte = Z(paramArrayOfByte, 0);
    AppMethodBeat.o(157879);
    return paramArrayOfByte;
  }
  
  public static String cB(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(157881);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(157881);
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
    AppMethodBeat.o(157881);
    return paramArrayOfByte;
  }
  
  public static boolean cC(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0);
  }
  
  public static int cD(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return -1;
    }
    return paramArrayOfByte.length;
  }
  
  public static String cE(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(157931);
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
    AppMethodBeat.o(157931);
    return paramArrayOfByte;
  }
  
  public static String cI(Context paramContext)
  {
    AppMethodBeat.i(157900);
    try
    {
      paramContext = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
      AppMethodBeat.o(157900);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ad.printErrStackTrace("MicroMsg.Util", paramContext, "", new Object[0]);
      AppMethodBeat.o(157900);
    }
    return "(null)";
  }
  
  public static int cJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(157999);
    try
    {
      int i = Color.parseColor(paramString);
      AppMethodBeat.o(157999);
      return i;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.Util", localException, "colorString:%s", new Object[] { paramString });
      AppMethodBeat.o(157999);
    }
    return paramInt;
  }
  
  public static boolean cc(Context paramContext, String paramString)
  {
    AppMethodBeat.i(157898);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647).iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)paramContext.next();
      if ((localRunningServiceInfo != null) && (localRunningServiceInfo.service != null) && (localRunningServiceInfo.service.getClassName().toString().equals(paramString)))
      {
        ad.w("MicroMsg.Util", "service " + paramString + " is running");
        AppMethodBeat.o(157898);
        return true;
      }
    }
    ad.w("MicroMsg.Util", "service " + paramString + " is not running");
    AppMethodBeat.o(157898);
    return false;
  }
  
  public static boolean cd(Context paramContext, String paramString)
  {
    AppMethodBeat.i(157937);
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    if (!aj(paramContext, localIntent))
    {
      ad.e("MicroMsg.Util", "jump to url failed, ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(157937);
      return false;
    }
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.ahp(), "com/tencent/mm/sdk/platformtools/Util", "jump", "(Landroid/content/Context;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/sdk/platformtools/Util", "jump", "(Landroid/content/Context;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(157937);
    return true;
  }
  
  public static boolean checkPermission(Context paramContext, String paramString)
  {
    AppMethodBeat.i(157936);
    Assert.assertNotNull(paramContext);
    Object localObject = paramContext.getPackageName();
    boolean bool;
    if (paramContext.getPackageManager().checkPermission(paramString, (String)localObject) == 0)
    {
      bool = true;
      localObject = new StringBuilder().append((String)localObject).append(" has ");
      if (!bool) {
        break label85;
      }
    }
    label85:
    for (paramContext = "permission ";; paramContext = "no permission ")
    {
      ad.d("MicroMsg.Util", paramContext + paramString);
      AppMethodBeat.o(157936);
      return bool;
      bool = false;
      break;
    }
  }
  
  public static String convertStreamToString(InputStream paramInputStream)
  {
    AppMethodBeat.i(157981);
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
        AppMethodBeat.o(157981);
        throw localObject;
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      ad.printErrStackTrace("MicroMsg.Util", localIOException, "", new Object[0]);
      try
      {
        paramInputStream.close();
        for (;;)
        {
          paramInputStream = localStringBuilder.toString();
          AppMethodBeat.o(157981);
          return paramInputStream;
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            ad.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
          }
        }
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
        }
      }
    }
    finally {}
  }
  
  public static void d(Closeable paramCloseable)
  {
    AppMethodBeat.i(157985);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(157985);
      return;
    }
    catch (IOException paramCloseable)
    {
      ad.printErrStackTrace("MicroMsg.Util", paramCloseable, "qualityClose", new Object[0]);
      AppMethodBeat.o(157985);
    }
  }
  
  public static String dT(Object paramObject)
  {
    AppMethodBeat.i(157904);
    if (paramObject != null)
    {
      paramObject = paramObject.toString();
      AppMethodBeat.o(157904);
      return paramObject;
    }
    AppMethodBeat.o(157904);
    return "null";
  }
  
  public static long dU(Object paramObject)
  {
    AppMethodBeat.i(157913);
    if (paramObject == null)
    {
      AppMethodBeat.o(157913);
      return 0L;
    }
    if ((paramObject instanceof Long))
    {
      long l = ((Long)paramObject).longValue();
      AppMethodBeat.o(157913);
      return l;
    }
    AppMethodBeat.o(157913);
    return 0L;
  }
  
  public static boolean deleteFile(String paramString)
  {
    AppMethodBeat.i(157946);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(157946);
      return false;
    }
    paramString = new e(paramString);
    if (!paramString.exists())
    {
      AppMethodBeat.o(157946);
      return true;
    }
    if (paramString.isDirectory())
    {
      AppMethodBeat.o(157946);
      return false;
    }
    boolean bool = paramString.delete();
    AppMethodBeat.o(157946);
    return bool;
  }
  
  public static byte[] flL()
  {
    AppMethodBeat.i(157863);
    try
    {
      InputStream localInputStream = i.openRead("/dev/urandom");
      byte[] arrayOfByte = new byte[16];
      int i = localInputStream.read(arrayOfByte);
      localInputStream.close();
      if (i == 16)
      {
        AppMethodBeat.o(157863);
        return arrayOfByte;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.Util", localException, "", new Object[0]);
      Object localObject = UUID.randomUUID();
      localObject = g.C((((UUID)localObject).toString() + System.currentTimeMillis()).getBytes());
      AppMethodBeat.o(157863);
      return localObject;
    }
  }
  
  public static String flM()
  {
    AppMethodBeat.i(157864);
    Object localObject = TimeZone.getDefault();
    int j = ((TimeZone)localObject).getRawOffset() / 1000;
    if ((((TimeZone)localObject).useDaylightTime()) && (((TimeZone)localObject).inDaylightTime(new java.sql.Date(System.currentTimeMillis())))) {}
    for (int i = 1;; i = 0)
    {
      localObject = String.format("%.2f", new Object[] { Double.valueOf(j / 3600.0D + i) });
      AppMethodBeat.o(157864);
      return localObject;
    }
  }
  
  public static long flN()
  {
    AppMethodBeat.i(157890);
    long l = System.currentTimeMillis() / 86400000L;
    AppMethodBeat.o(157890);
    return l * 86400000L;
  }
  
  public static long flO()
  {
    AppMethodBeat.i(157891);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    long l = localCalendar.getTimeInMillis();
    AppMethodBeat.o(157891);
    return l;
  }
  
  public static long flP()
  {
    AppMethodBeat.i(157893);
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      if (Build.VERSION.SDK_INT < 18)
      {
        l1 = localStatFs.getBlockSize();
        int i = localStatFs.getAvailableBlocks();
        l2 = i;
        AppMethodBeat.o(157893);
        return l2 * l1;
      }
      long l1 = localStatFs.getBlockSizeLong();
      long l2 = localStatFs.getAvailableBlocksLong();
      AppMethodBeat.o(157893);
      return l2 * l1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.Util", "getDataAvailableSize exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(157893);
    }
    return 0L;
  }
  
  public static View.OnTouchListener flQ()
  {
    AppMethodBeat.i(157953);
    View.OnTouchListener local1 = new View.OnTouchListener()
    {
      public final boolean onTouch(final View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(157853);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdk/platformtools/Util$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/sdk/platformtools/Util$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(157853);
          return false;
          paramAnonymousView.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(157852);
              paramAnonymousView.setPressed(false);
              AppMethodBeat.o(157852);
            }
          });
          continue;
          paramAnonymousView.setPressed(true);
        }
      }
    };
    AppMethodBeat.o(157953);
    return local1;
  }
  
  public static int flR()
  {
    AppMethodBeat.i(157966);
    int i = new Random().nextInt();
    AppMethodBeat.o(157966);
    return i;
  }
  
  public static at flS()
  {
    AppMethodBeat.i(157978);
    at localat = new at();
    AppMethodBeat.o(157978);
    return localat;
  }
  
  public static long flT()
  {
    AppMethodBeat.i(221726);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(221726);
    return l;
  }
  
  public static boolean flU()
  {
    AppMethodBeat.i(157991);
    String str = System.getProperty("java.vm.version");
    if ((!isNullOrNil(str)) && (str.startsWith("2")))
    {
      AppMethodBeat.o(157991);
      return true;
    }
    AppMethodBeat.o(157991);
    return false;
  }
  
  /* Error */
  private static List<String> flV()
  {
    // Byte code:
    //   0: ldc_w 1400
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 311	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 312	java/util/ArrayList:<init>	()V
    //   13: astore_3
    //   14: invokestatic 1406	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   17: ldc_w 1408
    //   20: invokevirtual 1412	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   23: astore_2
    //   24: new 1414	java/io/LineNumberReader
    //   27: dup
    //   28: new 1254	java/io/InputStreamReader
    //   31: dup
    //   32: aload_2
    //   33: invokevirtual 1417	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   36: invokespecial 1255	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   39: invokespecial 1418	java/io/LineNumberReader:<init>	(Ljava/io/Reader;)V
    //   42: astore_1
    //   43: aload_1
    //   44: astore_0
    //   45: aload_1
    //   46: invokevirtual 1419	java/io/LineNumberReader:readLine	()Ljava/lang/String;
    //   49: astore 4
    //   51: aload 4
    //   53: ifnull +89 -> 142
    //   56: aload_1
    //   57: astore_0
    //   58: aload 4
    //   60: invokevirtual 617	java/lang/String:length	()I
    //   63: ifle -20 -> 43
    //   66: aload_1
    //   67: astore_0
    //   68: aload_3
    //   69: aload 4
    //   71: invokeinterface 710 2 0
    //   76: pop
    //   77: goto -34 -> 43
    //   80: astore_2
    //   81: aload_1
    //   82: astore_0
    //   83: ldc 224
    //   85: ldc_w 1421
    //   88: iconst_1
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: aload_2
    //   95: invokevirtual 846	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   98: aastore
    //   99: invokestatic 821	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: aload_1
    //   103: ifnull +7 -> 110
    //   106: aload_1
    //   107: invokevirtual 1422	java/io/LineNumberReader:close	()V
    //   110: ldc 224
    //   112: ldc_w 1424
    //   115: iconst_1
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: aload_3
    //   122: invokeinterface 715 1 0
    //   127: invokestatic 709	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   130: aastore
    //   131: invokestatic 533	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   134: ldc_w 1400
    //   137: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_3
    //   141: areturn
    //   142: aload_1
    //   143: astore_0
    //   144: aload_2
    //   145: invokevirtual 1427	java/lang/Process:waitFor	()I
    //   148: pop
    //   149: aload_1
    //   150: astore_0
    //   151: aload_2
    //   152: invokevirtual 1430	java/lang/Process:destroy	()V
    //   155: aload_1
    //   156: invokevirtual 1422	java/io/LineNumberReader:close	()V
    //   159: goto -49 -> 110
    //   162: astore_0
    //   163: ldc 224
    //   165: ldc_w 1432
    //   168: iconst_1
    //   169: anewarray 4	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload_0
    //   175: invokevirtual 846	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   178: aastore
    //   179: invokestatic 821	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: goto -72 -> 110
    //   185: astore_0
    //   186: ldc 224
    //   188: ldc_w 1432
    //   191: iconst_1
    //   192: anewarray 4	java/lang/Object
    //   195: dup
    //   196: iconst_0
    //   197: aload_0
    //   198: invokevirtual 846	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   201: aastore
    //   202: invokestatic 821	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   205: goto -95 -> 110
    //   208: astore_1
    //   209: aconst_null
    //   210: astore_0
    //   211: aload_0
    //   212: ifnull +7 -> 219
    //   215: aload_0
    //   216: invokevirtual 1422	java/io/LineNumberReader:close	()V
    //   219: ldc_w 1400
    //   222: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   225: aload_1
    //   226: athrow
    //   227: astore_0
    //   228: ldc 224
    //   230: ldc_w 1432
    //   233: iconst_1
    //   234: anewarray 4	java/lang/Object
    //   237: dup
    //   238: iconst_0
    //   239: aload_0
    //   240: invokevirtual 846	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   243: aastore
    //   244: invokestatic 821	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public static long g(Long paramLong)
  {
    AppMethodBeat.i(157906);
    if (paramLong == null)
    {
      AppMethodBeat.o(157906);
      return 0L;
    }
    long l = paramLong.longValue();
    AppMethodBeat.o(157906);
    return l;
  }
  
  public static boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(157924);
    if (paramString == null) {}
    try
    {
      AppMethodBeat.o(157924);
      return paramBoolean;
    }
    catch (NumberFormatException paramString)
    {
      boolean bool;
      ad.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(157924);
    }
    bool = Boolean.parseBoolean(paramString);
    AppMethodBeat.o(157924);
    return bool;
    return paramBoolean;
  }
  
  public static double getDouble(String paramString, double paramDouble)
  {
    AppMethodBeat.i(157926);
    if (paramString == null) {}
    try
    {
      AppMethodBeat.o(157926);
      return paramDouble;
    }
    catch (NumberFormatException paramString)
    {
      double d;
      ad.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(157926);
    }
    d = Double.parseDouble(paramString);
    AppMethodBeat.o(157926);
    return d;
    return paramDouble;
  }
  
  public static float getFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(157925);
    if (paramString == null) {}
    try
    {
      AppMethodBeat.o(157925);
      return paramFloat;
    }
    catch (NumberFormatException paramString)
    {
      float f;
      ad.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(157925);
    }
    f = Float.parseFloat(paramString);
    AppMethodBeat.o(157925);
    return f;
    return paramFloat;
  }
  
  public static int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(157921);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(157921);
        return paramInt;
      }
      int i = Integer.decode(paramString).intValue();
      AppMethodBeat.o(157921);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      ad.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(157921);
    }
    return paramInt;
  }
  
  public static long getLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(157922);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(157922);
        return paramLong;
      }
      long l = Long.decode(paramString).longValue();
      AppMethodBeat.o(157922);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      ad.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(157922);
    }
    return paramLong;
  }
  
  /* Error */
  public static String getProcessNameByPid(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 1459
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +7 -> 14
    //   10: iload_1
    //   11: ifgt +13 -> 24
    //   14: ldc_w 1459
    //   17: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: ldc_w 286
    //   23: areturn
    //   24: aload_0
    //   25: ldc_w 546
    //   28: invokevirtual 220	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   31: checkcast 548	android/app/ActivityManager
    //   34: invokevirtual 1462	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   37: invokeinterface 555 1 0
    //   42: astore_0
    //   43: aload_0
    //   44: invokeinterface 475 1 0
    //   49: ifeq +73 -> 122
    //   52: aload_0
    //   53: invokeinterface 479 1 0
    //   58: checkcast 1464	android/app/ActivityManager$RunningAppProcessInfo
    //   61: astore 4
    //   63: aload 4
    //   65: getfield 1467	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   68: iload_1
    //   69: if_icmpne -26 -> 43
    //   72: aload 4
    //   74: getfield 1470	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   77: ifnull -34 -> 43
    //   80: aload 4
    //   82: getfield 1470	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   85: ldc_w 286
    //   88: invokevirtual 982	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   91: ifne -48 -> 43
    //   94: aload 4
    //   96: getfield 1470	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   99: astore_0
    //   100: ldc_w 1459
    //   103: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_0
    //   107: areturn
    //   108: astore_0
    //   109: ldc 224
    //   111: aload_0
    //   112: ldc_w 286
    //   115: iconst_0
    //   116: anewarray 4	java/lang/Object
    //   119: invokestatic 290	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: sipush 128
    //   125: newarray byte
    //   127: astore 5
    //   129: aconst_null
    //   130: astore_0
    //   131: new 830	java/io/BufferedInputStream
    //   134: dup
    //   135: new 1472	java/io/FileInputStream
    //   138: dup
    //   139: new 393	java/lang/StringBuilder
    //   142: dup
    //   143: ldc_w 1474
    //   146: invokespecial 492	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   149: iload_1
    //   150: invokevirtual 916	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: ldc_w 1476
    //   156: invokevirtual 402	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 403	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokespecial 1477	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   165: invokespecial 837	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   168: astore 4
    //   170: aload 4
    //   172: astore_0
    //   173: aload 4
    //   175: aload 5
    //   177: invokevirtual 273	java/io/InputStream:read	([B)I
    //   180: istore_3
    //   181: iload_3
    //   182: ifle +45 -> 227
    //   185: iconst_0
    //   186: istore_1
    //   187: goto +149 -> 336
    //   190: aload 4
    //   192: astore_0
    //   193: new 74	java/lang/String
    //   196: dup
    //   197: aload 5
    //   199: iconst_0
    //   200: iload_2
    //   201: invokespecial 276	java/lang/String:<init>	([BII)V
    //   204: astore 5
    //   206: aload 4
    //   208: invokevirtual 283	java/io/InputStream:close	()V
    //   211: ldc_w 1459
    //   214: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: aload 5
    //   219: areturn
    //   220: iload_1
    //   221: iconst_1
    //   222: iadd
    //   223: istore_1
    //   224: goto +112 -> 336
    //   227: aload 4
    //   229: invokevirtual 283	java/io/InputStream:close	()V
    //   232: ldc_w 1459
    //   235: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: ldc_w 286
    //   241: areturn
    //   242: astore 5
    //   244: aconst_null
    //   245: astore 4
    //   247: aload 4
    //   249: astore_0
    //   250: ldc 224
    //   252: aload 5
    //   254: ldc_w 286
    //   257: iconst_0
    //   258: anewarray 4	java/lang/Object
    //   261: invokestatic 290	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: aload 4
    //   266: ifnull -34 -> 232
    //   269: aload 4
    //   271: invokevirtual 283	java/io/InputStream:close	()V
    //   274: goto -42 -> 232
    //   277: astore_0
    //   278: goto -46 -> 232
    //   281: astore 5
    //   283: aload_0
    //   284: astore 4
    //   286: aload 5
    //   288: astore_0
    //   289: aload 4
    //   291: ifnull +8 -> 299
    //   294: aload 4
    //   296: invokevirtual 283	java/io/InputStream:close	()V
    //   299: ldc_w 1459
    //   302: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: aload_0
    //   306: athrow
    //   307: astore_0
    //   308: goto -97 -> 211
    //   311: astore_0
    //   312: goto -80 -> 232
    //   315: astore 4
    //   317: goto -18 -> 299
    //   320: astore 5
    //   322: aload_0
    //   323: astore 4
    //   325: aload 5
    //   327: astore_0
    //   328: goto -39 -> 289
    //   331: astore 5
    //   333: goto -86 -> 247
    //   336: iload_3
    //   337: istore_2
    //   338: iload_1
    //   339: iload_3
    //   340: if_icmpge -150 -> 190
    //   343: aload 5
    //   345: iload_1
    //   346: baload
    //   347: sipush 128
    //   350: if_icmpgt +10 -> 360
    //   353: aload 5
    //   355: iload_1
    //   356: baload
    //   357: ifgt -137 -> 220
    //   360: iload_1
    //   361: istore_2
    //   362: goto -172 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	paramContext	Context
    //   0	365	1	paramInt	int
    //   200	162	2	i	int
    //   180	161	3	j	int
    //   61	234	4	localObject1	Object
    //   315	1	4	localException1	Exception
    //   323	1	4	localContext	Context
    //   127	91	5	localObject2	Object
    //   242	11	5	localException2	Exception
    //   281	6	5	localObject3	Object
    //   320	6	5	localObject4	Object
    //   331	23	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   24	43	108	java/lang/Exception
    //   43	100	108	java/lang/Exception
    //   131	170	242	java/lang/Exception
    //   269	274	277	java/lang/Exception
    //   131	170	281	finally
    //   206	211	307	java/lang/Exception
    //   227	232	311	java/lang/Exception
    //   294	299	315	java/lang/Exception
    //   173	181	320	finally
    //   193	206	320	finally
    //   250	264	320	finally
    //   173	181	331	java/lang/Exception
    //   193	206	331	java/lang/Exception
  }
  
  public static int gj(String paramString, int paramInt)
  {
    AppMethodBeat.i(157927);
    if (paramString == null)
    {
      AppMethodBeat.o(157927);
      return paramInt;
    }
    try
    {
      long l = Long.decode(paramString).longValue();
      paramInt = (int)(l & 0xFFFFFFFF);
      AppMethodBeat.o(157927);
      return paramInt;
    }
    catch (NumberFormatException paramString)
    {
      ad.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(157927);
    }
    return paramInt;
  }
  
  public static String[] hi(List<String> paramList)
  {
    AppMethodBeat.i(157861);
    String[] arrayOfString = new String[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfString[i] = ((String)paramList.get(i));
      i += 1;
    }
    AppMethodBeat.o(157861);
    return arrayOfString;
  }
  
  public static boolean hideVKB(View paramView)
  {
    AppMethodBeat.i(157928);
    try
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)paramView.getContext().getSystemService("input_method");
      if (localInputMethodManager == null)
      {
        AppMethodBeat.o(157928);
        return false;
      }
      bool = localInputMethodManager.hideSoftInputFromWindow(paramView.getApplicationWindowToken(), 0);
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Util", paramView, "", new Object[0]);
        ad.e("MicroMsg.Util", "hide VKB exception %s", new Object[] { paramView });
        boolean bool = false;
      }
    }
    ad.v("MicroMsg.Util", "hide VKB result %B", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(157928);
    return bool;
  }
  
  public static boolean hj(List paramList)
  {
    AppMethodBeat.i(157914);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(157914);
      return true;
    }
    AppMethodBeat.o(157914);
    return false;
  }
  
  public static boolean isEqual(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(157994);
    boolean bool = Arrays.equals(paramArrayOfByte1, paramArrayOfByte2);
    AppMethodBeat.o(157994);
    return bool;
  }
  
  public static boolean isNullOrNil(String paramString)
  {
    AppMethodBeat.i(157915);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(157915);
      return true;
    }
    AppMethodBeat.o(157915);
    return false;
  }
  
  public static boolean isProcessRunning(Context paramContext, String paramString)
  {
    AppMethodBeat.i(157899);
    try
    {
      if ((paramString.equals(paramContext.getPackageName())) || (paramString.startsWith(paramContext.getPackageName() + ":")) || (Build.VERSION.SDK_INT < 21))
      {
        ad.i("MicroMsg.Util", "isProcessRunning, use ActivityManager. process = %s", new Object[] { paramString });
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        if (paramContext == null)
        {
          AppMethodBeat.o(157899);
          return false;
        }
        paramContext = paramContext.iterator();
      }
      while (paramContext.hasNext())
      {
        Object localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if ((localObject != null) && (((ActivityManager.RunningAppProcessInfo)localObject).processName != null) && (((ActivityManager.RunningAppProcessInfo)localObject).processName.equals(paramString)))
        {
          ad.w("MicroMsg.Util", "process " + paramString + " is running");
          AppMethodBeat.o(157899);
          return true;
          ad.i("MicroMsg.Util", "isProcessRunning, use ps command. process = %s", new Object[] { paramString });
          paramContext = flV().iterator();
          while (paramContext.hasNext())
          {
            localObject = (String)paramContext.next();
            ad.d("MicroMsg.Util", "isProcessRunning, process command line = %s", new Object[] { localObject });
            if ((localObject != null) && (((String)localObject).contains(paramString)))
            {
              localObject = ((String)localObject).split("\\s+");
              int i = 0;
              while (i < localObject.length)
              {
                if (paramString.equals(localObject[i]))
                {
                  ad.i("MicroMsg.Util", "process %s is running", new Object[] { paramString });
                  AppMethodBeat.o(157899);
                  return true;
                }
                i += 1;
              }
            }
          }
        }
      }
      ad.w("MicroMsg.Util", "process " + paramString + " is not running");
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Util", paramContext, "", new Object[0]);
      }
    }
    AppMethodBeat.o(157899);
    return false;
  }
  
  public static void jd(Context paramContext)
  {
    AppMethodBeat.i(157884);
    paramContext = (Vibrator)paramContext.getSystemService("vibrator");
    if (paramContext == null)
    {
      AppMethodBeat.o(157884);
      return;
    }
    paramContext.vibrate(IgF, -1);
    AppMethodBeat.o(157884);
  }
  
  public static long je(Context paramContext)
  {
    AppMethodBeat.i(157894);
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null)
    {
      AppMethodBeat.o(157894);
      return 0L;
    }
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    paramContext.getMemoryInfo(localMemoryInfo);
    long l = localMemoryInfo.availMem / 1024L / 1024L;
    AppMethodBeat.o(157894);
    return l;
  }
  
  public static String jf(Context paramContext)
  {
    AppMethodBeat.i(157895);
    if (paramContext == null)
    {
      AppMethodBeat.o(157895);
      return null;
    }
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null)
      {
        ad.e("MicroMsg.Util", "getLine1Number failed, null tm");
        AppMethodBeat.o(157895);
        return null;
      }
      paramContext = paramContext.getLine1Number();
      AppMethodBeat.o(157895);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ad.e("MicroMsg.Util", "getLine1Number failed:%s ", new Object[] { at.n(paramContext) });
      AppMethodBeat.o(157895);
    }
    return null;
  }
  
  public static String jg(Context paramContext)
  {
    AppMethodBeat.i(157896);
    if (paramContext == null)
    {
      ad.w("MicroMsg.Util", "getSimCountryCode context is null.");
      AppMethodBeat.o(157896);
      return "";
    }
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext != null)
    {
      paramContext = paramContext.getSimCountryIso();
      if (isNullOrNil(paramContext))
      {
        AppMethodBeat.o(157896);
        return "";
      }
      paramContext = paramContext.toUpperCase().trim();
      AppMethodBeat.o(157896);
      return paramContext;
    }
    AppMethodBeat.o(157896);
    return "";
  }
  
  public static boolean jh(Context paramContext)
  {
    AppMethodBeat.i(157897);
    String str = paramContext.getClass().getName();
    paramContext = cI(paramContext);
    ad.d("MicroMsg.Util", "top activity=" + paramContext + ", context=" + str);
    boolean bool = paramContext.equalsIgnoreCase(str);
    AppMethodBeat.o(157897);
    return bool;
  }
  
  public static boolean ji(Context paramContext)
  {
    AppMethodBeat.i(157901);
    try
    {
      String str = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
      paramContext = paramContext.getPackageName();
      ad.d("MicroMsg.Util", "top activity=" + str + ", context=" + paramContext);
      boolean bool = str.contains(paramContext);
      AppMethodBeat.o(157901);
      return bool;
    }
    catch (Exception paramContext)
    {
      ad.printErrStackTrace("MicroMsg.Util", paramContext, "", new Object[0]);
      AppMethodBeat.o(157901);
    }
    return false;
  }
  
  public static String jj(Context paramContext)
  {
    AppMethodBeat.i(157950);
    if (paramContext == null)
    {
      AppMethodBeat.o(157950);
      return null;
    }
    paramContext = n(paramContext.getPackageName(), paramContext);
    AppMethodBeat.o(157950);
    return paramContext;
  }
  
  public static boolean jk(Context paramContext)
  {
    AppMethodBeat.i(157952);
    if (!Locale.getDefault().getCountry().equalsIgnoreCase("CN"))
    {
      AppMethodBeat.o(157952);
      return true;
    }
    TimeZone localTimeZone1 = TimeZone.getDefault();
    TimeZone localTimeZone2 = TimeZone.getTimeZone("GMT+08:00");
    if (localTimeZone1.getRawOffset() != localTimeZone2.getRawOffset())
    {
      AppMethodBeat.o(157952);
      return true;
    }
    if (paramContext == null)
    {
      ad.w("MicroMsg.Util", "isOverseasUser context is null");
      AppMethodBeat.o(157952);
      return false;
    }
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext != null)
    {
      paramContext = paramContext.getNetworkCountryIso();
      if ((!isNullOrNil(paramContext)) && (!paramContext.contains("cn")) && (!paramContext.contains("CN")))
      {
        AppMethodBeat.o(157952);
        return true;
      }
    }
    AppMethodBeat.o(157952);
    return false;
  }
  
  public static a jl(Context paramContext)
  {
    AppMethodBeat.i(157973);
    paramContext = new a(paramContext);
    AppMethodBeat.o(157973);
    return paramContext;
  }
  
  public static ComponentName jm(Context paramContext)
  {
    AppMethodBeat.i(157974);
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        paramContext = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity;
        AppMethodBeat.o(157974);
        return paramContext;
      }
      AppMethodBeat.o(157974);
      return null;
    }
    catch (Exception paramContext)
    {
      ad.e("MicroMsg.Util", "get Top Activity Exception:%s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(157974);
    }
    return null;
  }
  
  public static String jn(Context paramContext)
  {
    AppMethodBeat.i(157975);
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      String str;
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramContext = paramContext.getAppTasks();
        if ((paramContext == null) || (paramContext.size() <= 0))
        {
          AppMethodBeat.o(157975);
          return "";
        }
        paramContext = paramContext.iterator();
        if (paramContext.hasNext())
        {
          paramContext = ((ActivityManager.AppTask)paramContext.next()).getTaskInfo().topActivity;
          if (paramContext == null)
          {
            AppMethodBeat.o(157975);
            return null;
          }
          str = paramContext.getClassName();
          paramContext = str;
          if (str.contains(".")) {
            paramContext = str.substring(str.lastIndexOf(".") + 1);
          }
          AppMethodBeat.o(157975);
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
        AppMethodBeat.o(157975);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      ad.e("MicroMsg.Util", "getTopActivityName Exception:%s stack:%s", new Object[] { paramContext.getMessage(), at.n(paramContext) });
      AppMethodBeat.o(157975);
    }
    return "";
  }
  
  public static int jo(Context paramContext)
  {
    AppMethodBeat.i(157996);
    if (paramContext == null)
    {
      ad.i("MicroMsg.Util", "getSelfMemInMB context is null.");
      AppMethodBeat.o(157996);
      return -1;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getProcessMemoryInfo(new int[] { Process.myPid() });
    if ((paramContext != null) && (paramContext.length > 0))
    {
      int i = paramContext[0].getTotalPss() / 1024;
      AppMethodBeat.o(157996);
      return i;
    }
    AppMethodBeat.o(157996);
    return 0;
  }
  
  public static int jw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(157862);
    if (paramInt1 > paramInt2) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramInt1 = new Random(System.currentTimeMillis()).nextInt(paramInt1 - paramInt2 + 1);
      AppMethodBeat.o(157862);
      return paramInt1 + paramInt2;
    }
  }
  
  public static boolean jx(int paramInt1, int paramInt2)
  {
    return paramInt1 == paramInt2;
  }
  
  @TargetApi(19)
  public static String k(Context paramContext, Uri paramUri)
  {
    Object localObject = null;
    AppMethodBeat.i(157968);
    if ((paramContext == null) || (paramUri == null))
    {
      ad.e("MicroMsg.Util", "getFilePath : context is null or uri is null");
      AppMethodBeat.o(157968);
      return null;
    }
    String str1 = paramUri.getScheme();
    if (isNullOrNil(str1))
    {
      ad.e("MicroMsg.Util", "input uri error. %s", new Object[] { paramUri });
      AppMethodBeat.o(157968);
      return null;
    }
    if (str1.equalsIgnoreCase("file"))
    {
      ad.i("MicroMsg.Util", "getFilePath : scheme is SCHEME_FILE");
      paramContext = paramUri.getPath();
      AppMethodBeat.o(157968);
      return paramContext;
    }
    if (str1.equalsIgnoreCase("content"))
    {
      ad.i("MicroMsg.Util", "getFilePath : scheme is SCHEME_CONTENT: " + paramUri.toString());
      if ("com.google.android.apps.photos.content".equals(paramUri.getAuthority()))
      {
        paramContext = paramUri.getLastPathSegment();
        AppMethodBeat.o(157968);
        return paramContext;
      }
      String[] arrayOfString;
      try
      {
        paramContext.grantUriPermission(paramUri.getAuthority(), paramUri, 1);
        str1 = a(paramContext, paramUri, null, null);
        if (!isNullOrNil(str1))
        {
          AppMethodBeat.o(157968);
          return str1;
        }
      }
      catch (SecurityException localSecurityException)
      {
        for (;;)
        {
          ad.e("MicroMsg.Util", "getFilePath : exception = ".concat(String.valueOf(localSecurityException)));
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
            AppMethodBeat.o(157968);
            return paramContext;
          }
          AppMethodBeat.o(157968);
          return null;
        }
        if ("com.android.providers.downloads.documents".equals(paramUri.getAuthority()))
        {
          paramUri = DocumentsContract.getDocumentId(paramUri);
          paramContext = a(paramContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(paramUri).longValue()), null, null);
          AppMethodBeat.o(157968);
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
            AppMethodBeat.o(157968);
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
    ad.e("MicroMsg.Util", "unknown scheme");
    AppMethodBeat.o(157968);
    return null;
  }
  
  public static List<String> lO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157859);
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = Collections.EMPTY_LIST;
      AppMethodBeat.o(157859);
      return paramString1;
    }
    paramString1 = paramString1.split(paramString2);
    if (paramString1 == null)
    {
      paramString1 = Collections.EMPTY_LIST;
      AppMethodBeat.o(157859);
      return paramString1;
    }
    paramString1 = Arrays.asList(paramString1);
    AppMethodBeat.o(157859);
    return paramString1;
  }
  
  public static int lP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157934);
    int i = i.fz(paramString1, paramString2);
    AppMethodBeat.o(157934);
    return i;
  }
  
  public static boolean lQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157993);
    if ((isNullOrNil(paramString1)) && (isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(157993);
      return true;
    }
    if ((isNullOrNil(paramString1)) && (!isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(157993);
      return false;
    }
    if ((!isNullOrNil(paramString1)) && (isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(157993);
      return false;
    }
    boolean bool = paramString1.equals(paramString2);
    AppMethodBeat.o(157993);
    return bool;
  }
  
  public static int m(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(157912);
    if (paramObject == null)
    {
      AppMethodBeat.o(157912);
      return paramInt;
    }
    if ((paramObject instanceof Integer))
    {
      paramInt = ((Integer)paramObject).intValue();
      AppMethodBeat.o(157912);
      return paramInt;
    }
    if ((paramObject instanceof Long))
    {
      paramInt = ((Long)paramObject).intValue();
      AppMethodBeat.o(157912);
      return paramInt;
    }
    AppMethodBeat.o(157912);
    return paramInt;
  }
  
  public static String m(List<String> paramList, String paramString)
  {
    AppMethodBeat.i(157858);
    if (paramList == null)
    {
      AppMethodBeat.o(157858);
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
    AppMethodBeat.o(157858);
    return paramList;
  }
  
  public static byte[] m(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == null) {
      return paramArrayOfByte2;
    }
    return paramArrayOfByte1;
  }
  
  public static int n(Integer paramInteger)
  {
    AppMethodBeat.i(157905);
    if (paramInteger == null)
    {
      AppMethodBeat.o(157905);
      return 0;
    }
    int i = paramInteger.intValue();
    AppMethodBeat.o(157905);
    return i;
  }
  
  public static String n(String paramString, Context paramContext)
  {
    AppMethodBeat.i(157951);
    if ((paramContext == null) || (isNullOrNil(paramString)))
    {
      AppMethodBeat.o(157951);
      return null;
    }
    paramContext = paramContext.getPackageManager();
    try
    {
      paramString = paramContext.getPackageInfo(paramString, 64).signatures[0].toByteArray();
      paramString = g.getMessageDigest(paramString);
      AppMethodBeat.o(157951);
      return paramString;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(157951);
    }
    return null;
  }
  
  public static String n(Throwable paramThrowable)
  {
    AppMethodBeat.i(221725);
    paramThrowable = at.n(paramThrowable);
    AppMethodBeat.o(221725);
    return paramThrowable;
  }
  
  public static void n(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(157987);
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
    AppMethodBeat.o(157987);
  }
  
  public static void n(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(157947);
    if (isNullOrNil(paramString1))
    {
      AppMethodBeat.o(157947);
      return;
    }
    paramString1 = new e(paramString1);
    if ((!paramString1.exists()) || (!paramString1.isDirectory()))
    {
      AppMethodBeat.o(157947);
      return;
    }
    paramString1 = paramString1.fOM();
    if ((paramString1 == null) || (paramString1.length == 0))
    {
      AppMethodBeat.o(157947);
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
    AppMethodBeat.o(157947);
  }
  
  public static boolean n(Boolean paramBoolean)
  {
    AppMethodBeat.i(157907);
    if (paramBoolean == null)
    {
      AppMethodBeat.o(157907);
      return true;
    }
    boolean bool = paramBoolean.booleanValue();
    AppMethodBeat.o(157907);
    return bool;
  }
  
  public static String nullAsNil(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static boolean o(Boolean paramBoolean)
  {
    AppMethodBeat.i(157908);
    if (paramBoolean == null)
    {
      AppMethodBeat.o(157908);
      return false;
    }
    boolean bool = paramBoolean.booleanValue();
    AppMethodBeat.o(157908);
    return bool;
  }
  
  public static String qY(int paramInt)
  {
    AppMethodBeat.i(157886);
    String str = String.format("%d:%02d", new Object[] { Long.valueOf(paramInt / 60L), Long.valueOf(paramInt % 60L) });
    AppMethodBeat.o(157886);
    return str;
  }
  
  public static long rM(long paramLong)
  {
    AppMethodBeat.i(157887);
    long l = System.currentTimeMillis() / 1000L;
    AppMethodBeat.o(157887);
    return l - paramLong;
  }
  
  /* Error */
  public static byte[] readFromFile(String paramString)
  {
    // Byte code:
    //   0: ldc_w 1899
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 323	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +19 -> 29
    //   13: ldc 224
    //   15: ldc_w 1901
    //   18: invokestatic 232	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 1899
    //   24: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aconst_null
    //   28: areturn
    //   29: new 1281	com/tencent/mm/vfs/e
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 1282	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   37: astore_3
    //   38: aload_3
    //   39: invokevirtual 1285	com/tencent/mm/vfs/e:exists	()Z
    //   42: ifne +27 -> 69
    //   45: ldc 224
    //   47: ldc_w 1903
    //   50: iconst_1
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload_0
    //   57: aastore
    //   58: invokestatic 1905	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: ldc_w 1899
    //   64: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aconst_null
    //   68: areturn
    //   69: aload_3
    //   70: invokevirtual 1907	com/tencent/mm/vfs/e:length	()J
    //   73: l2i
    //   74: istore_1
    //   75: aload_3
    //   76: invokestatic 1910	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   79: astore 4
    //   81: aload 4
    //   83: astore_3
    //   84: iload_1
    //   85: newarray byte
    //   87: astore 5
    //   89: aload 4
    //   91: astore_3
    //   92: aload 4
    //   94: aload 5
    //   96: invokevirtual 273	java/io/InputStream:read	([B)I
    //   99: istore_2
    //   100: iload_2
    //   101: iload_1
    //   102: if_icmpeq +71 -> 173
    //   105: aload 4
    //   107: astore_3
    //   108: ldc 224
    //   110: ldc_w 1912
    //   113: iconst_3
    //   114: anewarray 4	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload_0
    //   120: aastore
    //   121: dup
    //   122: iconst_1
    //   123: iload_1
    //   124: invokestatic 709	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   127: aastore
    //   128: dup
    //   129: iconst_2
    //   130: iload_2
    //   131: invokestatic 709	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   134: aastore
    //   135: invokestatic 1905	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   138: aload 4
    //   140: ifnull +8 -> 148
    //   143: aload 4
    //   145: invokevirtual 283	java/io/InputStream:close	()V
    //   148: ldc_w 1899
    //   151: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: aconst_null
    //   155: areturn
    //   156: astore_0
    //   157: ldc 224
    //   159: aload_0
    //   160: ldc_w 286
    //   163: iconst_0
    //   164: anewarray 4	java/lang/Object
    //   167: invokestatic 290	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: goto -22 -> 148
    //   173: aload 4
    //   175: astore_3
    //   176: ldc 224
    //   178: ldc_w 1914
    //   181: invokestatic 1246	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload 4
    //   186: ifnull +8 -> 194
    //   189: aload 4
    //   191: invokevirtual 283	java/io/InputStream:close	()V
    //   194: ldc_w 1899
    //   197: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: aload 5
    //   202: areturn
    //   203: astore_0
    //   204: ldc 224
    //   206: aload_0
    //   207: ldc_w 286
    //   210: iconst_0
    //   211: anewarray 4	java/lang/Object
    //   214: invokestatic 290	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: goto -23 -> 194
    //   220: astore_0
    //   221: aconst_null
    //   222: astore 4
    //   224: aload 4
    //   226: astore_3
    //   227: ldc 224
    //   229: aload_0
    //   230: ldc_w 286
    //   233: iconst_0
    //   234: anewarray 4	java/lang/Object
    //   237: invokestatic 290	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   240: aload 4
    //   242: ifnull +8 -> 250
    //   245: aload 4
    //   247: invokevirtual 283	java/io/InputStream:close	()V
    //   250: ldc_w 1899
    //   253: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: aconst_null
    //   257: areturn
    //   258: astore_0
    //   259: ldc 224
    //   261: aload_0
    //   262: ldc_w 286
    //   265: iconst_0
    //   266: anewarray 4	java/lang/Object
    //   269: invokestatic 290	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   272: goto -22 -> 250
    //   275: astore_0
    //   276: aconst_null
    //   277: astore_3
    //   278: aload_3
    //   279: ifnull +7 -> 286
    //   282: aload_3
    //   283: invokevirtual 283	java/io/InputStream:close	()V
    //   286: ldc_w 1899
    //   289: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: aload_0
    //   293: athrow
    //   294: astore_3
    //   295: ldc 224
    //   297: aload_3
    //   298: ldc_w 286
    //   301: iconst_0
    //   302: anewarray 4	java/lang/Object
    //   305: invokestatic 290	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   308: goto -22 -> 286
    //   311: astore_0
    //   312: goto -34 -> 278
    //   315: astore_0
    //   316: goto -92 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	paramString	String
    //   74	50	1	i	int
    //   99	32	2	j	int
    //   37	246	3	localObject	Object
    //   294	4	3	localIOException	IOException
    //   79	167	4	localInputStream	InputStream
    //   87	114	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   143	148	156	java/io/IOException
    //   189	194	203	java/io/IOException
    //   69	81	220	java/lang/Exception
    //   245	250	258	java/io/IOException
    //   69	81	275	finally
    //   282	286	294	java/io/IOException
    //   84	89	311	finally
    //   92	100	311	finally
    //   108	138	311	finally
    //   176	184	311	finally
    //   227	240	311	finally
    //   84	89	315	java/lang/Exception
    //   92	100	315	java/lang/Exception
    //   108	138	315	java/lang/Exception
    //   176	184	315	java/lang/Exception
  }
  
  public static String sy(long paramLong)
  {
    AppMethodBeat.i(157875);
    if (paramLong >> 30 > 0L)
    {
      str = b(paramLong, 10.0D);
      AppMethodBeat.o(157875);
      return str;
    }
    if (paramLong >> 20 > 0L)
    {
      str = a(paramLong, 10.0D);
      AppMethodBeat.o(157875);
      return str;
    }
    if (paramLong >> 9 > 0L)
    {
      double d = Math.round(paramLong * 10.0D / 1024.0D) / 10.0D;
      str = d + " KB";
      AppMethodBeat.o(157875);
      return str;
    }
    String str = paramLong + " B";
    AppMethodBeat.o(157875);
    return str;
  }
  
  public static boolean u(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(157949);
    if ((isNullOrNil(paramString)) || (cC(paramArrayOfByte)))
    {
      ad.w("MicroMsg.Util", "write to file error, path is null or empty, or data is empty");
      AppMethodBeat.o(157949);
      return false;
    }
    localObject = null;
    String str = null;
    try
    {
      paramString = i.cX(paramString, false);
      str = paramString;
      localObject = paramString;
      paramString.write(paramArrayOfByte);
      str = paramString;
      localObject = paramString;
      paramString.flush();
      if (paramString != null) {}
      try
      {
        paramString.close();
        ad.d("MicroMsg.Util", "writeToFile ok!");
        AppMethodBeat.o(157949);
        return true;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
        }
      }
      try
      {
        ((OutputStream)localObject).close();
        AppMethodBeat.o(157949);
        throw paramString;
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.Util", paramArrayOfByte, "", new Object[0]);
        }
      }
    }
    catch (Exception paramString)
    {
      localObject = str;
      ad.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      localObject = str;
      ad.w("MicroMsg.Util", "write to file error");
      if (str != null) {}
      try
      {
        str.close();
        AppMethodBeat.o(157949);
        return false;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
        }
      }
    }
    finally
    {
      if (localObject == null) {}
    }
  }
  
  public static String x(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(157997);
    try
    {
      paramVarArgs = String.format(paramString, paramVarArgs);
      paramString = paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        ad.i("MicroMsg.Util", "error safeFormatString %s", new Object[] { paramVarArgs.getMessage() });
      }
    }
    AppMethodBeat.o(157997);
    return paramString;
  }
  
  public static boolean z(Uri paramUri)
  {
    AppMethodBeat.i(157969);
    if (paramUri == null)
    {
      AppMethodBeat.o(157969);
      return false;
    }
    if ((!"file".equalsIgnoreCase(paramUri.getScheme())) && (!"content".equalsIgnoreCase(paramUri.getScheme())))
    {
      AppMethodBeat.o(157969);
      return true;
    }
    boolean bool = aRq(paramUri.getPath());
    AppMethodBeat.o(157969);
    return bool;
  }
  
  public static final class a
  {
    private Context context;
    
    public a(Context paramContext)
    {
      this.context = paramContext;
    }
    
    private static String jp(Context paramContext)
    {
      AppMethodBeat.i(157855);
      if (paramContext == null)
      {
        AppMethodBeat.o(157855);
        return null;
      }
      Object localObject1 = (ActivityManager)paramContext.getSystemService("activity");
      paramContext = paramContext.getPackageName();
      if ((localObject1 == null) || (bt.isNullOrNil(paramContext)))
      {
        AppMethodBeat.o(157855);
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
        ad.printErrStackTrace("MicroMsg.Util", paramContext, "", new Object[0]);
        AppMethodBeat.o(157855);
        return "";
      }
      AppMethodBeat.o(157855);
      return paramContext;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(157854);
      String str = jp(this.context);
      AppMethodBeat.o(157854);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bt
 * JD-Core Version:    0.7.0.1
 */