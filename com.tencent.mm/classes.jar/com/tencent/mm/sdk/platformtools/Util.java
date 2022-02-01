package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.app.Activity;
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
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import junit.framework.Assert;

public final class Util
{
  public static final int BEGIN_TIME = 22;
  public static final int BIT_OF_GB = 30;
  public static final int BIT_OF_KB = 10;
  public static final int BIT_OF_MB = 20;
  public static final int BYTE_OF_GB = 1073741824;
  public static final int BYTE_OF_KB = 1024;
  public static final int BYTE_OF_MB = 1048576;
  public static final int DAY = 0;
  public static final int END_TIME = 8;
  private static final TimeZone GMT;
  private static final char[] INVALID;
  private static final long[] LIGHT_PATTERN;
  private static final char LOWER_RANGE = ' ';
  public static final int MASK_16BIT = 65535;
  public static final int MASK_32BIT = -1;
  public static final int MASK_4BIT = 15;
  public static final int MASK_8BIT = 255;
  public static final long MAX_32BIT_VALUE = 4294967295L;
  public static final int MAX_ACCOUNT_LENGTH = 20;
  public static final int MAX_DECODE_PICTURE_SIZE = 2764800;
  public static final int MAX_PASSWORD_LENGTH = 16;
  public static final long MILLSECONDS_OF_DAY = 86400000L;
  public static final long MILLSECONDS_OF_HOUR = 3600000L;
  public static final long MILLSECONDS_OF_MINUTE = 60000L;
  public static final long MILLSECONDS_OF_SECOND = 1000L;
  public static final long MINUTE_OF_HOUR = 60L;
  public static final int MIN_ACCOUNT_LENGTH = 6;
  public static final int MIN_PASSWORD_LENGTH = 8;
  private static final int MTU = 1462;
  private static final int NEW_QQ_PASSWORD_MAX = 16;
  public static final String PHOTO_DEFAULT_EXT = ".jpg";
  public static final long SECONDS_OF_DAY = 86400L;
  public static final long SECONDS_OF_HOUR = 3600L;
  public static final long SECOND_OF_MINUTE = 60L;
  private static final String TAG = "MicroMsg.Util";
  private static final int TCP_HDR_FIX = 52;
  private static final int TCP_HDR_FIX_TOO = 40;
  private static final int TCP_RX_FIX_BYTES = 156;
  private static final int TCP_TX_FIX_BYTES = 172;
  private static final BigInteger TWO_64;
  private static final String[] VALID;
  public static final long[] VIRBRATOR_PATTERN;
  private byte _hellAccFlag_;
  
  static
  {
    AppMethodBeat.i(158002);
    VIRBRATOR_PATTERN = new long[] { 300L, 200L, 300L, 200L };
    LIGHT_PATTERN = new long[] { 300L, 50L, 300L, 50L };
    GMT = TimeZone.getTimeZone("GMT");
    TWO_64 = BigInteger.ONE.shiftLeft(64);
    INVALID = new char[] { 60, 62, 34, 39, 38, 13, 10, 32, 9 };
    VALID = new String[] { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&#x0D;", "&#x0A;", "&#x20;", "&#x09;" };
    AppMethodBeat.o(158002);
  }
  
  public static int UnZipFolder(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157934);
    int i = s.fW(paramString1, paramString2);
    AppMethodBeat.o(157934);
    return i;
  }
  
  public static byte[] bmpToByteArray(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(230410);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    if (paramBoolean)
    {
      Log.i("MicroMsg.Util", "recycle bitmap:%s", new Object[] { paramBitmap });
      paramBitmap.recycle();
    }
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      AppMethodBeat.o(230410);
      return paramBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Util", localException, "", new Object[0]);
      }
    }
  }
  
  public static int byteArrayToInt(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(157989);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(157989);
      return 0;
    }
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte.order(ByteOrder.nativeOrder());
    int i = paramArrayOfByte.getInt();
    AppMethodBeat.o(157989);
    return i;
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
      Log.d("MicroMsg.Util", paramContext + paramString);
      AppMethodBeat.o(157936);
      return bool;
      bool = false;
      break;
    }
  }
  
  public static boolean compare(Object paramObject1, Object paramObject2)
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
          Log.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      Log.printErrStackTrace("MicroMsg.Util", localIOException, "", new Object[0]);
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
            Log.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
          }
        }
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
        }
      }
    }
    finally {}
  }
  
  public static int convertStringToRGB(String paramString, int paramInt)
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
      Log.printErrStackTrace("MicroMsg.Util", localException, "colorString:%s", new Object[] { paramString });
      AppMethodBeat.o(157999);
    }
    return paramInt;
  }
  
  public static Intent createExplicitFromImplicitIntent(Context paramContext, Intent paramIntent)
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
    Log.d("MicroMsg.Util", "createExplicitFromImplicitIntent pa:%s, cl:%s", new Object[] { paramContext, localObject });
    paramContext = new ComponentName(paramContext, (String)localObject);
    paramIntent = new Intent(paramIntent);
    paramIntent.setComponent(paramContext);
    AppMethodBeat.o(157998);
    return paramIntent;
  }
  
  public static long currentDayInMills()
  {
    AppMethodBeat.i(157890);
    long l = nowMilliSecond() / 86400000L;
    AppMethodBeat.o(157890);
    return l * 86400000L;
  }
  
  public static long currentTicks()
  {
    AppMethodBeat.i(157889);
    long l = SystemClock.elapsedRealtime();
    AppMethodBeat.o(157889);
    return l;
  }
  
  public static byte[] decodeHexString(String paramString)
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
      Log.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(157932);
    }
    return new byte[0];
  }
  
  public static boolean deleteFile(String paramString)
  {
    AppMethodBeat.i(157946);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(157946);
      return false;
    }
    paramString = new o(paramString);
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
  
  public static void deleteOutOfDateFile(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(157947);
    if (isNullOrNil(paramString1))
    {
      AppMethodBeat.o(157947);
      return;
    }
    paramString1 = new o(paramString1);
    if ((!paramString1.exists()) || (!paramString1.isDirectory()))
    {
      AppMethodBeat.o(157947);
      return;
    }
    paramString1 = paramString1.het();
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
      if ((localObject.isFile()) && (localObject.getName().startsWith(paramString2)) && (nowMilliSecond() - localObject.lastModified() - paramLong >= 0L)) {
        localObject.delete();
      }
      i += 1;
    }
    AppMethodBeat.o(157947);
  }
  
  public static String dumpHex(byte[] paramArrayOfByte)
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
    char[] tmp57_52 = tmp52_46;
    tmp57_52[5] = 53;
    char[] tmp63_57 = tmp57_52;
    tmp63_57[6] = 54;
    char[] tmp70_63 = tmp63_57;
    tmp70_63[7] = 55;
    char[] tmp77_70 = tmp70_63;
    tmp77_70[8] = 56;
    char[] tmp84_77 = tmp77_70;
    tmp84_77[9] = 57;
    char[] tmp91_84 = tmp84_77;
    tmp91_84[10] = 97;
    char[] tmp98_91 = tmp91_84;
    tmp98_91[11] = 98;
    char[] tmp105_98 = tmp98_91;
    tmp105_98[12] = 99;
    char[] tmp112_105 = tmp105_98;
    tmp112_105[13] = 100;
    char[] tmp119_112 = tmp112_105;
    tmp119_112[14] = 101;
    char[] tmp126_119 = tmp119_112;
    tmp126_119[15] = 102;
    tmp126_119;
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
  
  public static String dumpHexBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(157879);
    paramArrayOfByte = dumpHexBuf(paramArrayOfByte, 0, 0);
    AppMethodBeat.o(157879);
    return paramArrayOfByte;
  }
  
  public static String dumpHexBuf(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = 0;
    AppMethodBeat.i(230413);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(230413);
      return "(null)";
    }
    int i = paramInt2;
    if (paramInt2 <= 0) {
      i = paramArrayOfByte.length;
    }
    paramInt2 = paramInt1;
    if (paramInt1 > i) {
      paramInt2 = 0;
    }
    char[] arrayOfChar1 = new char[16];
    char[] tmp49_47 = arrayOfChar1;
    tmp49_47[0] = 48;
    char[] tmp55_49 = tmp49_47;
    tmp55_49[1] = 49;
    char[] tmp61_55 = tmp55_49;
    tmp61_55[2] = 50;
    char[] tmp67_61 = tmp61_55;
    tmp67_61[3] = 51;
    char[] tmp73_67 = tmp67_61;
    tmp73_67[4] = 52;
    char[] tmp78_73 = tmp73_67;
    tmp78_73[5] = 53;
    char[] tmp84_78 = tmp78_73;
    tmp84_78[6] = 54;
    char[] tmp91_84 = tmp84_78;
    tmp91_84[7] = 55;
    char[] tmp98_91 = tmp91_84;
    tmp98_91[8] = 56;
    char[] tmp105_98 = tmp98_91;
    tmp105_98[9] = 57;
    char[] tmp112_105 = tmp105_98;
    tmp112_105[10] = 97;
    char[] tmp119_112 = tmp112_105;
    tmp119_112[11] = 98;
    char[] tmp126_119 = tmp119_112;
    tmp126_119[12] = 99;
    char[] tmp133_126 = tmp126_119;
    tmp133_126[13] = 100;
    char[] tmp140_133 = tmp133_126;
    tmp140_133[14] = 101;
    char[] tmp147_140 = tmp140_133;
    tmp147_140[15] = 102;
    tmp147_140;
    char[] arrayOfChar2 = new char[i * 3 + i / 16];
    int j = paramInt2;
    paramInt1 = k;
    if (j < i + paramInt2)
    {
      k = paramArrayOfByte[j];
      int m = paramInt1 + 1;
      arrayOfChar2[paramInt1] = ' ';
      int n = m + 1;
      arrayOfChar2[m] = arrayOfChar1[(k >>> 4 & 0xF)];
      paramInt1 = n + 1;
      arrayOfChar2[n] = arrayOfChar1[(k & 0xF)];
      if ((j % 16 != 0) || (j <= 0)) {
        break label291;
      }
      k = paramInt1 + 1;
      arrayOfChar2[paramInt1] = '\n';
      paramInt1 = k;
    }
    label291:
    for (;;)
    {
      j += 1;
      break;
      paramArrayOfByte = new String(arrayOfChar2);
      AppMethodBeat.o(230413);
      return paramArrayOfByte;
    }
  }
  
  public static String encodeHexString(byte[] paramArrayOfByte)
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
  
  public static String escapeDirTraversal(String paramString)
  {
    AppMethodBeat.i(157857);
    String str = paramString;
    if (paramString != null) {
      str = paramString.replace("../", "");
    }
    AppMethodBeat.o(157857);
    return str;
  }
  
  public static String escapeSqlValue(String paramString)
  {
    AppMethodBeat.i(157856);
    String str = paramString;
    if (paramString != null) {
      str = paramString.replace("\\[", "[[]").replace("%", "").replace("\\^", "").replace("'", "").replace("\\{", "").replace("\\}", "").replace("\"", "");
    }
    AppMethodBeat.o(157856);
    return str;
  }
  
  public static String escapeStringForUCC(String paramString)
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
  
  public static String escapeStringForXml(String paramString)
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
      int k = INVALID.length - 1;
      for (;;)
      {
        int i = m;
        if (k >= 0)
        {
          if (INVALID[k] == c)
          {
            localStringBuffer.append(VALID[k]);
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
  
  private static String expandEntities(String paramString)
  {
    AppMethodBeat.i(230419);
    int n = paramString.length();
    char[] arrayOfChar = new char[n];
    int k = 0;
    int m = 0;
    int j = -1;
    char c;
    int i;
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
    for (;;)
    {
      k += 1;
      m = i;
      break;
      if ((j != -1) && (!Character.isLetter(c)) && (!Character.isDigit(c)) && (c != '#'))
      {
        if (c == ';')
        {
          m = lookupEntity(arrayOfChar, j, i - j - 1);
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
            AppMethodBeat.o(230419);
            return paramString;
          }
          j = i;
        }
      }
    }
  }
  
  public static void expandViewTouchArea(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
  
  public static CharSequence filterNumber(CharSequence paramCharSequence)
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
  
  public static String formatMoney2f(double paramDouble)
  {
    AppMethodBeat.i(158001);
    String str = String.format("%.2f", new Object[] { Double.valueOf(paramDouble) });
    AppMethodBeat.o(158001);
    return str;
  }
  
  public static String formatNumber(String paramString)
  {
    AppMethodBeat.i(230422);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(230422);
      return "";
    }
    paramString = paramString.replaceAll(",", "");
    if (paramString.length() <= 3)
    {
      AppMethodBeat.o(230422);
      return paramString;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramString.length() - 1;
    while (i >= 0)
    {
      localStringBuffer.append(paramString.charAt(i));
      if (((paramString.length() - i) % 3 == 0) && (i != 0)) {
        localStringBuffer.append(",");
      }
      i -= 1;
    }
    paramString = localStringBuffer.reverse().toString();
    AppMethodBeat.o(230422);
    return paramString;
  }
  
  public static String formatSecToMin(int paramInt)
  {
    AppMethodBeat.i(157886);
    String str = String.format("%d:%02d", new Object[] { Long.valueOf(paramInt / 60L), Long.valueOf(paramInt % 60L) });
    AppMethodBeat.o(157886);
    return str;
  }
  
  public static String formatUnixTime(long paramLong)
  {
    AppMethodBeat.i(157866);
    String str = new SimpleDateFormat("[yy-MM-dd HH:mm:ss]").format(new java.util.Date(1000L * paramLong));
    AppMethodBeat.o(157866);
    return str;
  }
  
  public static View.OnTouchListener genLinearPressedListener()
  {
    AppMethodBeat.i(157953);
    View.OnTouchListener local1 = new View.OnTouchListener()
    {
      public final boolean onTouch(final View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(157853);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(157853);
          return false;
          paramAnonymousView.post(new Runnable()
          {
            public void run()
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
  
  public static ActivityTaskInfo getActivityTaskInfo(Context paramContext)
  {
    AppMethodBeat.i(157973);
    paramContext = new ActivityTaskInfo(paramContext);
    AppMethodBeat.o(157973);
    return paramContext;
  }
  
  public static long getAvailableMemoryMB(Context paramContext)
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
  
  private static byte[] getBase64Data(String paramString)
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
      Log.e("MicroMsg.Util", "decode base64 url failed : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(157957);
    }
    return null;
  }
  
  public static long getBeginTimeOfToday()
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
      Log.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(157924);
    }
    bool = Boolean.parseBoolean(paramString);
    AppMethodBeat.o(157924);
    return bool;
    return paramBoolean;
  }
  
  public static ActivityManager.RunningTaskInfo getCurrentTaskInfo(Context paramContext, int paramInt)
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
  
  public static String getCutPasswordMD5(String paramString)
  {
    AppMethodBeat.i(157929);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (str.length() <= 16)
    {
      paramString = getFullPasswordMD5(str);
      AppMethodBeat.o(157929);
      return paramString;
    }
    paramString = getFullPasswordMD5(str.substring(0, 16));
    AppMethodBeat.o(157929);
    return paramString;
  }
  
  public static long getDataAvailableSize()
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
      Log.e("MicroMsg.Util", "getDataAvailableSize exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(157893);
    }
    return 0L;
  }
  
  public static long getDataCRC32(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(230431);
    if (isNullOrNil(paramArrayOfByte))
    {
      AppMethodBeat.o(230431);
      return 0L;
    }
    CRC32 localCRC32 = new CRC32();
    localCRC32.update(paramArrayOfByte);
    long l = localCRC32.getValue();
    AppMethodBeat.o(230431);
    return l;
  }
  
  /* Error */
  private static String getDataColumn(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 831
    //   6: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokevirtual 835	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: aload_1
    //   14: iconst_1
    //   15: anewarray 156	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: ldc_w 837
    //   23: aastore
    //   24: aload_2
    //   25: aload_3
    //   26: aconst_null
    //   27: invokevirtual 843	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   30: astore_0
    //   31: aload_0
    //   32: ifnull +88 -> 120
    //   35: aload_0
    //   36: invokeinterface 848 1 0
    //   41: ifeq +79 -> 120
    //   44: aload_0
    //   45: ldc_w 837
    //   48: invokeinterface 851 2 0
    //   53: istore 4
    //   55: iload 4
    //   57: iconst_m1
    //   58: if_icmpne +35 -> 93
    //   61: ldc 91
    //   63: ldc_w 853
    //   66: invokestatic 855	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_0
    //   70: invokeinterface 856 1 0
    //   75: aload_0
    //   76: ifnull +9 -> 85
    //   79: aload_0
    //   80: invokeinterface 856 1 0
    //   85: ldc_w 831
    //   88: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aconst_null
    //   92: areturn
    //   93: aload_0
    //   94: iload 4
    //   96: invokeinterface 859 2 0
    //   101: astore_2
    //   102: aload_0
    //   103: ifnull +9 -> 112
    //   106: aload_0
    //   107: invokeinterface 856 1 0
    //   112: ldc_w 831
    //   115: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_2
    //   119: areturn
    //   120: aload_0
    //   121: ifnull +9 -> 130
    //   124: aload_0
    //   125: invokeinterface 856 1 0
    //   130: ldc_w 831
    //   133: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aconst_null
    //   137: areturn
    //   138: astore_0
    //   139: aload 5
    //   141: astore_0
    //   142: aload_1
    //   143: invokevirtual 862	android/net/Uri:getPath	()Ljava/lang/String;
    //   146: invokestatic 865	com/tencent/mm/sdk/platformtools/Util:getPathFromUri	(Ljava/lang/String;)Ljava/lang/String;
    //   149: astore_1
    //   150: aload_0
    //   151: ifnull +9 -> 160
    //   154: aload_0
    //   155: invokeinterface 856 1 0
    //   160: ldc_w 831
    //   163: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_1
    //   167: areturn
    //   168: astore_1
    //   169: aconst_null
    //   170: astore_0
    //   171: aload_0
    //   172: ifnull +9 -> 181
    //   175: aload_0
    //   176: invokeinterface 856 1 0
    //   181: ldc_w 831
    //   184: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: aload_1
    //   188: athrow
    //   189: astore_1
    //   190: goto -19 -> 171
    //   193: astore_1
    //   194: goto -23 -> 171
    //   197: astore_2
    //   198: goto -56 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	paramContext	Context
    //   0	201	1	paramUri	Uri
    //   0	201	2	paramString	String
    //   0	201	3	paramArrayOfString	String[]
    //   53	42	4	i	int
    //   1	139	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	31	138	java/lang/Exception
    //   9	31	168	finally
    //   35	55	189	finally
    //   61	75	189	finally
    //   93	102	189	finally
    //   142	150	193	finally
    //   35	55	197	java/lang/Exception
    //   61	75	197	java/lang/Exception
    //   93	102	197	java/lang/Exception
  }
  
  public static String getDeviceId(Context paramContext)
  {
    AppMethodBeat.i(230414);
    if (paramContext == null)
    {
      AppMethodBeat.o(230414);
      return null;
    }
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null)
      {
        AppMethodBeat.o(230414);
        return null;
      }
      paramContext = paramContext.getDeviceId();
      if (paramContext == null)
      {
        AppMethodBeat.o(230414);
        return null;
      }
      paramContext = paramContext.trim();
      AppMethodBeat.o(230414);
      return paramContext;
    }
    catch (SecurityException paramContext)
    {
      Log.e("MicroMsg.Util", "summerdeviceid getDeviceId failed, security exception[%s]", new Object[] { paramContext });
      AppMethodBeat.o(230414);
      return null;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Util", paramContext, "summerdeviceid", new Object[0]);
      }
    }
  }
  
  public static final String getDomin(String paramString)
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
      Log.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(157926);
    }
    d = Double.parseDouble(paramString);
    AppMethodBeat.o(157926);
    return d;
    return paramDouble;
  }
  
  private static int getEntity(String paramString)
  {
    return 0;
  }
  
  @TargetApi(19)
  public static String getFilePath(Context paramContext, Uri paramUri)
  {
    Object localObject = null;
    AppMethodBeat.i(157968);
    if ((paramContext == null) || (paramUri == null))
    {
      Log.e("MicroMsg.Util", "getFilePath : context is null or uri is null");
      AppMethodBeat.o(157968);
      return null;
    }
    String str1 = paramUri.getScheme();
    if (isNullOrNil(str1))
    {
      Log.e("MicroMsg.Util", "input uri error. %s", new Object[] { paramUri });
      AppMethodBeat.o(157968);
      return null;
    }
    if (str1.equalsIgnoreCase("file"))
    {
      Log.i("MicroMsg.Util", "getFilePath : scheme is SCHEME_FILE");
      paramContext = paramUri.getPath();
      AppMethodBeat.o(157968);
      return paramContext;
    }
    if (str1.equalsIgnoreCase("content"))
    {
      Log.i("MicroMsg.Util", "getFilePath : scheme is SCHEME_CONTENT: " + paramUri.toString());
      if (isGooglePhotosUri(paramUri))
      {
        paramContext = paramUri.getLastPathSegment();
        AppMethodBeat.o(157968);
        return paramContext;
      }
      String[] arrayOfString;
      try
      {
        paramContext.grantUriPermission(paramUri.getAuthority(), paramUri, 1);
        str1 = getDataColumn(paramContext, paramUri, null, null);
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
          Log.e("MicroMsg.Util", "getFilePath : exception = ".concat(String.valueOf(localSecurityException)));
          arrayOfString = null;
        }
        if (Build.VERSION.SDK_INT < 19) {
          break label445;
        }
      }
      if (DocumentsContract.isDocumentUri(paramContext, paramUri))
      {
        if (isExternalStorageDocument(paramUri))
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
        if (isDownloadsDocument(paramUri))
        {
          paramUri = DocumentsContract.getDocumentId(paramUri);
          paramContext = getDataColumn(paramContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(paramUri).longValue()), null, null);
          AppMethodBeat.o(157968);
          return paramContext;
        }
        if (isMediaDocument(paramUri))
        {
          arrayOfString = DocumentsContract.getDocumentId(paramUri).split(":");
          String str2 = arrayOfString[0];
          if ("image".equals(str2)) {
            paramUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
          }
          for (;;)
          {
            paramContext = getDataColumn(paramContext, paramUri, "_id=?", new String[] { arrayOfString[1] });
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
    label445:
    Log.e("MicroMsg.Util", "unknown scheme");
    AppMethodBeat.o(157968);
    return null;
  }
  
  public static String getFilterString(String paramString)
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
      Log.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(157925);
    }
    f = Float.parseFloat(paramString);
    AppMethodBeat.o(157925);
    return f;
    return paramFloat;
  }
  
  public static String getFullPasswordMD5(String paramString)
  {
    AppMethodBeat.i(186052);
    paramString = g.getMessageDigest(paramString.getBytes());
    AppMethodBeat.o(186052);
    return paramString;
  }
  
  public static int getHex(String paramString, int paramInt)
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
      Log.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(157927);
    }
    return paramInt;
  }
  
  public static final String getHost(String paramString)
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
      Log.printErrStackTrace("MicroMsg.Util", localMalformedURLException, "", new Object[0]);
      Log.w("MicroMsg.Util", "get host error");
      AppMethodBeat.o(157935);
    }
    return paramString;
  }
  
  /* Error */
  static byte[] getHttpData(String paramString)
  {
    // Byte code:
    //   0: ldc_w 1062
    //   3: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 1053	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 1054	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 1066	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 1068	java/net/HttpURLConnection
    //   20: astore_0
    //   21: aload_0
    //   22: ldc_w 1070
    //   25: invokevirtual 1073	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: invokevirtual 1076	java/net/HttpURLConnection:getResponseCode	()I
    //   32: istore_1
    //   33: iload_1
    //   34: sipush 200
    //   37: if_icmpeq +46 -> 83
    //   40: ldc 91
    //   42: ldc_w 1078
    //   45: iconst_1
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: iload_1
    //   52: invokestatic 496	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: invokestatic 724	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aconst_null
    //   60: invokestatic 1082	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   63: aconst_null
    //   64: invokestatic 1082	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   67: aload_0
    //   68: ifnull +7 -> 75
    //   71: aload_0
    //   72: invokevirtual 1085	java/net/HttpURLConnection:disconnect	()V
    //   75: ldc_w 1062
    //   78: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aconst_null
    //   82: areturn
    //   83: new 1087	java/io/BufferedInputStream
    //   86: dup
    //   87: aload_0
    //   88: invokevirtual 1091	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   91: invokespecial 1092	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   94: astore 4
    //   96: new 198	java/io/ByteArrayOutputStream
    //   99: dup
    //   100: invokespecial 199	java/io/ByteArrayOutputStream:<init>	()V
    //   103: astore_2
    //   104: sipush 4096
    //   107: newarray byte
    //   109: astore_3
    //   110: aload 4
    //   112: aload_3
    //   113: invokevirtual 1095	java/io/BufferedInputStream:read	([B)I
    //   116: istore_1
    //   117: iload_1
    //   118: ifle +20 -> 138
    //   121: aload_2
    //   122: aload_3
    //   123: iconst_0
    //   124: iload_1
    //   125: invokevirtual 1099	java/io/ByteArrayOutputStream:write	([BII)V
    //   128: aload 4
    //   130: aload_3
    //   131: invokevirtual 1095	java/io/BufferedInputStream:read	([B)I
    //   134: istore_1
    //   135: goto -18 -> 117
    //   138: aload_2
    //   139: invokevirtual 225	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   142: astore_3
    //   143: aload 4
    //   145: invokestatic 1082	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   148: aload_2
    //   149: invokestatic 1082	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   152: aload_0
    //   153: ifnull +7 -> 160
    //   156: aload_0
    //   157: invokevirtual 1085	java/net/HttpURLConnection:disconnect	()V
    //   160: ldc_w 1062
    //   163: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_3
    //   167: areturn
    //   168: astore_0
    //   169: aconst_null
    //   170: astore_2
    //   171: aconst_null
    //   172: astore 4
    //   174: aconst_null
    //   175: astore_3
    //   176: ldc 91
    //   178: ldc_w 1101
    //   181: iconst_1
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload_0
    //   188: invokevirtual 721	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   191: aastore
    //   192: invokestatic 724	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: aload 4
    //   197: invokestatic 1082	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   200: aload_2
    //   201: invokestatic 1082	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   204: aload_3
    //   205: ifnull +7 -> 212
    //   208: aload_3
    //   209: invokevirtual 1085	java/net/HttpURLConnection:disconnect	()V
    //   212: ldc_w 1062
    //   215: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   230: invokestatic 1082	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   233: aload_2
    //   234: invokestatic 1082	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   237: aload_3
    //   238: ifnull +7 -> 245
    //   241: aload_3
    //   242: invokevirtual 1085	java/net/HttpURLConnection:disconnect	()V
    //   245: ldc_w 1062
    //   248: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  static byte[] getHttpsData(String paramString)
  {
    // Byte code:
    //   0: ldc_w 1103
    //   3: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 1053	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 1054	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 1066	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 1105	javax/net/ssl/HttpsURLConnection
    //   20: astore_0
    //   21: aload_0
    //   22: ldc_w 1070
    //   25: invokevirtual 1073	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: invokevirtual 1076	java/net/HttpURLConnection:getResponseCode	()I
    //   32: istore_1
    //   33: iload_1
    //   34: sipush 200
    //   37: if_icmpeq +46 -> 83
    //   40: ldc 91
    //   42: ldc_w 1107
    //   45: iconst_1
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: iload_1
    //   52: invokestatic 496	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: invokestatic 724	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aconst_null
    //   60: invokestatic 1082	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   63: aconst_null
    //   64: invokestatic 1082	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   67: aload_0
    //   68: ifnull +7 -> 75
    //   71: aload_0
    //   72: invokevirtual 1085	java/net/HttpURLConnection:disconnect	()V
    //   75: ldc_w 1103
    //   78: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aconst_null
    //   82: areturn
    //   83: new 1087	java/io/BufferedInputStream
    //   86: dup
    //   87: aload_0
    //   88: invokevirtual 1091	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   91: invokespecial 1092	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   94: astore 4
    //   96: new 198	java/io/ByteArrayOutputStream
    //   99: dup
    //   100: invokespecial 199	java/io/ByteArrayOutputStream:<init>	()V
    //   103: astore_2
    //   104: sipush 4096
    //   107: newarray byte
    //   109: astore_3
    //   110: aload 4
    //   112: aload_3
    //   113: invokevirtual 1095	java/io/BufferedInputStream:read	([B)I
    //   116: istore_1
    //   117: iload_1
    //   118: ifle +20 -> 138
    //   121: aload_2
    //   122: aload_3
    //   123: iconst_0
    //   124: iload_1
    //   125: invokevirtual 1099	java/io/ByteArrayOutputStream:write	([BII)V
    //   128: aload 4
    //   130: aload_3
    //   131: invokevirtual 1095	java/io/BufferedInputStream:read	([B)I
    //   134: istore_1
    //   135: goto -18 -> 117
    //   138: aload_2
    //   139: invokevirtual 225	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   142: astore_3
    //   143: aload 4
    //   145: invokevirtual 1108	java/io/BufferedInputStream:close	()V
    //   148: aload_2
    //   149: invokevirtual 228	java/io/ByteArrayOutputStream:close	()V
    //   152: aload 4
    //   154: invokestatic 1082	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   157: aload_2
    //   158: invokestatic 1082	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   161: aload_0
    //   162: ifnull +7 -> 169
    //   165: aload_0
    //   166: invokevirtual 1085	java/net/HttpURLConnection:disconnect	()V
    //   169: ldc_w 1103
    //   172: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: aload_3
    //   176: areturn
    //   177: astore_0
    //   178: aconst_null
    //   179: astore_2
    //   180: aconst_null
    //   181: astore 4
    //   183: aconst_null
    //   184: astore_3
    //   185: ldc 91
    //   187: ldc_w 1110
    //   190: iconst_1
    //   191: anewarray 4	java/lang/Object
    //   194: dup
    //   195: iconst_0
    //   196: aload_0
    //   197: invokevirtual 721	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   200: aastore
    //   201: invokestatic 724	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: aload 4
    //   206: invokestatic 1082	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   209: aload_2
    //   210: invokestatic 1082	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   213: aload_3
    //   214: ifnull +7 -> 221
    //   217: aload_3
    //   218: invokevirtual 1085	java/net/HttpURLConnection:disconnect	()V
    //   221: ldc_w 1103
    //   224: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   239: invokestatic 1082	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   242: aload_2
    //   243: invokestatic 1082	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   246: aload_3
    //   247: ifnull +7 -> 254
    //   250: aload_3
    //   251: invokevirtual 1085	java/net/HttpURLConnection:disconnect	()V
    //   254: ldc_w 1103
    //   257: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      Log.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(157921);
    }
    return paramInt;
  }
  
  public static int getIntRandom(int paramInt1, int paramInt2)
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
  
  public static int getLength(String paramString)
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
  
  public static int getLength(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return -1;
    }
    return paramArrayOfByte.length;
  }
  
  public static String getLengthStr(float paramFloat)
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
  
  public static String getLine1Number(Context paramContext)
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
        Log.e("MicroMsg.Util", "getLine1Number failed, null tm");
        AppMethodBeat.o(157895);
        return null;
      }
      paramContext = paramContext.getLine1Number();
      AppMethodBeat.o(157895);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.Util", "getLine1Number failed:%s ", new Object[] { stackTraceToString(paramContext) });
      AppMethodBeat.o(157895);
    }
    return null;
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
      Log.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(157922);
    }
    return paramLong;
  }
  
  public static String getNetworkCountryCode(Context paramContext)
  {
    AppMethodBeat.i(230415);
    if (paramContext == null)
    {
      Log.w("MicroMsg.Util", "getNetworkCountryCode context is null.");
      AppMethodBeat.o(230415);
      return null;
    }
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext != null)
    {
      paramContext = paramContext.getNetworkCountryIso();
      if (isNullOrNil(paramContext))
      {
        AppMethodBeat.o(230415);
        return null;
      }
      paramContext = paramContext.toLowerCase().trim();
      AppMethodBeat.o(230415);
      return paramContext;
    }
    AppMethodBeat.o(230415);
    return null;
  }
  
  public static String getPathFromUri(String paramString)
  {
    AppMethodBeat.i(230428);
    if (d.oD(24))
    {
      paramString = paramString.replace("external_files", "");
      AppMethodBeat.o(230428);
      return paramString;
    }
    AppMethodBeat.o(230428);
    return paramString;
  }
  
  public static String getPrivacyPhoneNum(String paramString)
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
  
  /* Error */
  public static String getProcessNameByPid(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 1203
    //   3: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +7 -> 14
    //   10: iload_1
    //   11: ifgt +12 -> 23
    //   14: ldc_w 1203
    //   17: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: ldc 230
    //   22: areturn
    //   23: aload_0
    //   24: ldc_w 683
    //   27: invokevirtual 687	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   30: checkcast 689	android/app/ActivityManager
    //   33: invokevirtual 1207	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   36: invokeinterface 758 1 0
    //   41: astore_0
    //   42: aload_0
    //   43: invokeinterface 763 1 0
    //   48: ifeq +71 -> 119
    //   51: aload_0
    //   52: invokeinterface 767 1 0
    //   57: checkcast 1209	android/app/ActivityManager$RunningAppProcessInfo
    //   60: astore 4
    //   62: aload 4
    //   64: getfield 1212	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   67: iload_1
    //   68: if_icmpne -26 -> 42
    //   71: aload 4
    //   73: getfield 1215	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   76: ifnull -34 -> 42
    //   79: aload 4
    //   81: getfield 1215	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   84: ldc 230
    //   86: invokevirtual 1003	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   89: ifne -47 -> 42
    //   92: aload 4
    //   94: getfield 1215	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   97: astore_0
    //   98: ldc_w 1203
    //   101: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_0
    //   105: areturn
    //   106: astore_0
    //   107: ldc 91
    //   109: aload_0
    //   110: ldc 230
    //   112: iconst_0
    //   113: anewarray 4	java/lang/Object
    //   116: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: sipush 128
    //   122: newarray byte
    //   124: astore 5
    //   126: aconst_null
    //   127: astore_0
    //   128: new 1087	java/io/BufferedInputStream
    //   131: dup
    //   132: new 1217	java/io/FileInputStream
    //   135: dup
    //   136: new 282	java/lang/StringBuilder
    //   139: dup
    //   140: ldc_w 1219
    //   143: invokespecial 490	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   146: iload_1
    //   147: invokevirtual 1222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: ldc_w 1224
    //   153: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokespecial 1225	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   162: invokespecial 1092	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   165: astore 4
    //   167: aload 4
    //   169: astore_0
    //   170: aload 4
    //   172: aload 5
    //   174: invokevirtual 1226	java/io/InputStream:read	([B)I
    //   177: istore_3
    //   178: iload_3
    //   179: ifle +45 -> 224
    //   182: iconst_0
    //   183: istore_1
    //   184: goto +147 -> 331
    //   187: aload 4
    //   189: astore_0
    //   190: new 156	java/lang/String
    //   193: dup
    //   194: aload 5
    //   196: iconst_0
    //   197: iload_2
    //   198: invokespecial 1228	java/lang/String:<init>	([BII)V
    //   201: astore 5
    //   203: aload 4
    //   205: invokevirtual 330	java/io/InputStream:close	()V
    //   208: ldc_w 1203
    //   211: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: aload 5
    //   216: areturn
    //   217: iload_1
    //   218: iconst_1
    //   219: iadd
    //   220: istore_1
    //   221: goto +110 -> 331
    //   224: aload 4
    //   226: invokevirtual 330	java/io/InputStream:close	()V
    //   229: ldc_w 1203
    //   232: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: ldc 230
    //   237: areturn
    //   238: astore 5
    //   240: aconst_null
    //   241: astore 4
    //   243: aload 4
    //   245: astore_0
    //   246: ldc 91
    //   248: aload 5
    //   250: ldc 230
    //   252: iconst_0
    //   253: anewarray 4	java/lang/Object
    //   256: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   259: aload 4
    //   261: ifnull -32 -> 229
    //   264: aload 4
    //   266: invokevirtual 330	java/io/InputStream:close	()V
    //   269: goto -40 -> 229
    //   272: astore_0
    //   273: goto -44 -> 229
    //   276: astore 5
    //   278: aload_0
    //   279: astore 4
    //   281: aload 5
    //   283: astore_0
    //   284: aload 4
    //   286: ifnull +8 -> 294
    //   289: aload 4
    //   291: invokevirtual 330	java/io/InputStream:close	()V
    //   294: ldc_w 1203
    //   297: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   300: aload_0
    //   301: athrow
    //   302: astore_0
    //   303: goto -95 -> 208
    //   306: astore_0
    //   307: goto -78 -> 229
    //   310: astore 4
    //   312: goto -18 -> 294
    //   315: astore 5
    //   317: aload_0
    //   318: astore 4
    //   320: aload 5
    //   322: astore_0
    //   323: goto -39 -> 284
    //   326: astore 5
    //   328: goto -85 -> 243
    //   331: iload_3
    //   332: istore_2
    //   333: iload_1
    //   334: iload_3
    //   335: if_icmpge -148 -> 187
    //   338: aload 5
    //   340: iload_1
    //   341: baload
    //   342: sipush 128
    //   345: if_icmpgt +10 -> 355
    //   348: aload 5
    //   350: iload_1
    //   351: baload
    //   352: ifgt -135 -> 217
    //   355: iload_1
    //   356: istore_2
    //   357: goto -170 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	paramContext	Context
    //   0	360	1	paramInt	int
    //   197	160	2	i	int
    //   177	159	3	j	int
    //   60	230	4	localObject1	Object
    //   310	1	4	localException1	Exception
    //   318	1	4	localContext	Context
    //   124	91	5	localObject2	Object
    //   238	11	5	localException2	Exception
    //   276	6	5	localObject3	Object
    //   315	6	5	localObject4	Object
    //   326	23	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   23	42	106	java/lang/Exception
    //   42	98	106	java/lang/Exception
    //   128	167	238	java/lang/Exception
    //   264	269	272	java/lang/Exception
    //   128	167	276	finally
    //   203	208	302	java/lang/Exception
    //   224	229	306	java/lang/Exception
    //   289	294	310	java/lang/Exception
    //   170	178	315	finally
    //   190	203	315	finally
    //   246	259	315	finally
    //   170	178	326	java/lang/Exception
    //   190	203	326	java/lang/Exception
  }
  
  public static String getRandomString(int paramInt)
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
  
  /* Error */
  private static List<String> getRunningAppProcessesByPs()
  {
    // Byte code:
    //   0: ldc_w 1235
    //   3: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 1237	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 1238	java/util/ArrayList:<init>	()V
    //   13: astore_3
    //   14: invokestatic 1244	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   17: ldc_w 1246
    //   20: invokevirtual 1250	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   23: astore_2
    //   24: new 1252	java/io/LineNumberReader
    //   27: dup
    //   28: new 316	java/io/InputStreamReader
    //   31: dup
    //   32: aload_2
    //   33: invokevirtual 1255	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   36: invokespecial 319	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   39: invokespecial 1256	java/io/LineNumberReader:<init>	(Ljava/io/Reader;)V
    //   42: astore_1
    //   43: aload_1
    //   44: astore_0
    //   45: aload_1
    //   46: invokevirtual 1257	java/io/LineNumberReader:readLine	()Ljava/lang/String;
    //   49: astore 4
    //   51: aload 4
    //   53: ifnull +89 -> 142
    //   56: aload_1
    //   57: astore_0
    //   58: aload 4
    //   60: invokevirtual 409	java/lang/String:length	()I
    //   63: ifle -20 -> 43
    //   66: aload_1
    //   67: astore_0
    //   68: aload_3
    //   69: aload 4
    //   71: invokeinterface 1260 2 0
    //   76: pop
    //   77: goto -34 -> 43
    //   80: astore_2
    //   81: aload_1
    //   82: astore_0
    //   83: ldc 91
    //   85: ldc_w 1262
    //   88: iconst_1
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: aload_2
    //   95: invokevirtual 721	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   98: aastore
    //   99: invokestatic 724	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: aload_1
    //   103: ifnull +7 -> 110
    //   106: aload_1
    //   107: invokevirtual 1263	java/io/LineNumberReader:close	()V
    //   110: ldc 91
    //   112: ldc_w 1265
    //   115: iconst_1
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: aload_3
    //   122: invokeinterface 353 1 0
    //   127: invokestatic 496	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   130: aastore
    //   131: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   134: ldc_w 1235
    //   137: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_3
    //   141: areturn
    //   142: aload_1
    //   143: astore_0
    //   144: aload_2
    //   145: invokevirtual 1268	java/lang/Process:waitFor	()I
    //   148: pop
    //   149: aload_1
    //   150: astore_0
    //   151: aload_2
    //   152: invokevirtual 1271	java/lang/Process:destroy	()V
    //   155: aload_1
    //   156: invokevirtual 1263	java/io/LineNumberReader:close	()V
    //   159: goto -49 -> 110
    //   162: astore_0
    //   163: ldc 91
    //   165: ldc_w 1273
    //   168: iconst_1
    //   169: anewarray 4	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload_0
    //   175: invokevirtual 721	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   178: aastore
    //   179: invokestatic 724	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: goto -72 -> 110
    //   185: astore_0
    //   186: ldc 91
    //   188: ldc_w 1273
    //   191: iconst_1
    //   192: anewarray 4	java/lang/Object
    //   195: dup
    //   196: iconst_0
    //   197: aload_0
    //   198: invokevirtual 721	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   201: aastore
    //   202: invokestatic 724	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   205: goto -95 -> 110
    //   208: astore_1
    //   209: aconst_null
    //   210: astore_0
    //   211: aload_0
    //   212: ifnull +7 -> 219
    //   215: aload_0
    //   216: invokevirtual 1263	java/io/LineNumberReader:close	()V
    //   219: ldc_w 1235
    //   222: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   225: aload_1
    //   226: athrow
    //   227: astore_0
    //   228: ldc 91
    //   230: ldc_w 1273
    //   233: iconst_1
    //   234: anewarray 4	java/lang/Object
    //   237: dup
    //   238: iconst_0
    //   239: aload_0
    //   240: invokevirtual 721	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   243: aastore
    //   244: invokestatic 724	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public static int getSeconds(String paramString, int paramInt)
  {
    AppMethodBeat.i(230418);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(230418);
      return paramInt;
    }
    try
    {
      long l = new SimpleDateFormat("yyyy-MM-dd").parse(paramString).getTime() / 1000L;
      paramInt = (int)l;
      AppMethodBeat.o(230418);
      return paramInt;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(230418);
    }
    return paramInt;
  }
  
  public static int getSelfMemInMB(Context paramContext)
  {
    AppMethodBeat.i(157996);
    if (paramContext == null)
    {
      Log.i("MicroMsg.Util", "getSelfMemInMB context is null.");
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
  
  public static String getSignaturesMd5(String paramString, Context paramContext)
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
      Log.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(157951);
    }
    return null;
  }
  
  public static String getSimCountryCode(Context paramContext)
  {
    AppMethodBeat.i(157896);
    if (paramContext == null)
    {
      Log.w("MicroMsg.Util", "getSimCountryCode context is null.");
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
  
  public static String getSizeGB(long paramLong)
  {
    AppMethodBeat.i(230412);
    String str = getSizeGB(paramLong, 10.0D);
    AppMethodBeat.o(230412);
    return str;
  }
  
  public static String getSizeGB(long paramLong, double paramDouble)
  {
    AppMethodBeat.i(157878);
    paramDouble = Math.round(paramLong * paramDouble / 1073741824.0D) / paramDouble;
    String str = paramDouble + " GB";
    AppMethodBeat.o(157878);
    return str;
  }
  
  public static String getSizeKB(long paramLong)
  {
    AppMethodBeat.i(157875);
    String str = getSizeKB(paramLong, 10.0D);
    AppMethodBeat.o(157875);
    return str;
  }
  
  public static String getSizeKB(long paramLong, double paramDouble)
  {
    AppMethodBeat.i(230411);
    if (paramLong >> 30 > 0L)
    {
      str = getSizeGB(paramLong, paramDouble);
      AppMethodBeat.o(230411);
      return str;
    }
    if (paramLong >> 20 > 0L)
    {
      str = getSizeMB(paramLong, paramDouble);
      AppMethodBeat.o(230411);
      return str;
    }
    if (paramLong >> 9 > 0L)
    {
      paramDouble = Math.round(paramLong * paramDouble / 1024.0D) / paramDouble;
      str = paramDouble + " KB";
      AppMethodBeat.o(230411);
      return str;
    }
    String str = paramLong + " B";
    AppMethodBeat.o(230411);
    return str;
  }
  
  public static String getSizeMB(long paramLong)
  {
    AppMethodBeat.i(157877);
    String str = getSizeMB(paramLong, 10.0D);
    AppMethodBeat.o(157877);
    return str;
  }
  
  public static String getSizeMB(long paramLong, double paramDouble)
  {
    AppMethodBeat.i(157876);
    paramDouble = Math.round(paramLong * paramDouble / 1048576.0D) / paramDouble;
    String str = paramDouble + " MB";
    AppMethodBeat.o(157876);
    return str;
  }
  
  public static String getSourceeMd5(Context paramContext)
  {
    AppMethodBeat.i(157950);
    if (paramContext == null)
    {
      AppMethodBeat.o(157950);
      return null;
    }
    paramContext = getSignaturesMd5(paramContext.getPackageName(), paramContext);
    AppMethodBeat.o(157950);
    return paramContext;
  }
  
  public static MMStack getStack()
  {
    AppMethodBeat.i(157978);
    MMStack localMMStack = new MMStack();
    AppMethodBeat.o(157978);
    return localMMStack;
  }
  
  public static String getTimeZoneOffset()
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
  
  public static ComponentName getTopActivity(Context paramContext)
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
      Log.e("MicroMsg.Util", "get Top Activity Exception:%s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(157974);
    }
    return null;
  }
  
  public static ComponentName getTopActivityByAppTasks(Context paramContext)
  {
    AppMethodBeat.i(230430);
    try
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramContext = localActivityManager.getAppTasks();
        if (paramContext != null)
        {
          int i = paramContext.size();
          if (i > 0) {}
        }
        else
        {
          AppMethodBeat.o(230430);
          return null;
        }
        paramContext = paramContext.iterator();
        if (paramContext.hasNext())
        {
          paramContext = ((ActivityManager.AppTask)paramContext.next()).getTaskInfo().topActivity;
          if (paramContext == null)
          {
            AppMethodBeat.o(230430);
            return null;
          }
          AppMethodBeat.o(230430);
          return paramContext;
        }
      }
      else
      {
        paramContext = getTopActivity(paramContext);
        AppMethodBeat.o(230430);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.Util", "get Top Activity Exception:%s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(230430);
      return null;
    }
    AppMethodBeat.o(230430);
    return null;
  }
  
  public static String getTopActivityName(Context paramContext)
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
      Log.printErrStackTrace("MicroMsg.Util", paramContext, "", new Object[0]);
      AppMethodBeat.o(157900);
    }
    return "(null)";
  }
  
  public static String getTopActivityName2(Context paramContext)
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
      Log.e("MicroMsg.Util", "getTopActivityName Exception:%s stack:%s", new Object[] { paramContext.getMessage(), stackTraceToString(paramContext) });
      AppMethodBeat.o(157975);
    }
    return "";
  }
  
  public static int getUTF8ByteLength(String paramString)
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
  
  public static String getUnsignedLongString(long paramLong)
  {
    AppMethodBeat.i(157923);
    BigInteger localBigInteger = BigInteger.valueOf(paramLong);
    Object localObject = localBigInteger;
    if (localBigInteger.signum() < 0) {
      localObject = localBigInteger.add(TWO_64);
    }
    localObject = ((BigInteger)localObject).toString();
    AppMethodBeat.o(157923);
    return localObject;
  }
  
  public static byte[] getUuidRandom()
  {
    AppMethodBeat.i(157863);
    try
    {
      InputStream localInputStream = s.openRead("/dev/urandom");
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
      Log.printErrStackTrace("MicroMsg.Util", localException, "", new Object[0]);
      Object localObject = UUID.randomUUID();
      localObject = g.Q((((UUID)localObject).toString() + nowMilliSecond()).getBytes());
      AppMethodBeat.o(157863);
      return localObject;
    }
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
        Log.printErrStackTrace("MicroMsg.Util", paramView, "", new Object[0]);
        Log.e("MicroMsg.Util", "hide VKB exception %s", new Object[] { paramView });
        boolean bool = false;
      }
    }
    Log.v("MicroMsg.Util", "hide VKB result %B", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(157928);
    return bool;
  }
  
  public static byte[] httpGet(String paramString)
  {
    AppMethodBeat.i(157954);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.Util", "httpGet, url is null");
      AppMethodBeat.o(157954);
      return null;
    }
    if (URLUtil.isDataUrl(paramString))
    {
      paramString = getBase64Data(paramString);
      AppMethodBeat.o(157954);
      return paramString;
    }
    if (URLUtil.isHttpsUrl(paramString))
    {
      paramString = getHttpsData(paramString);
      AppMethodBeat.o(157954);
      return paramString;
    }
    paramString = getHttpData(paramString);
    AppMethodBeat.o(157954);
    return paramString;
  }
  
  public static void invoke(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(230421);
    for (;;)
    {
      int i;
      try
      {
        Class localClass = Class.forName(paramString1);
        Method[] arrayOfMethod = localClass.getMethods();
        int j = arrayOfMethod.length;
        i = 0;
        if (i < j)
        {
          Method localMethod = arrayOfMethod[i];
          boolean bool = localMethod.getName().equals(paramString2);
          if (bool) {
            try
            {
              localMethod.invoke(localClass.newInstance(), paramVarArgs);
              AppMethodBeat.o(230421);
              return;
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.Util", "invoke failed, %s::%s", new Object[] { paramString1, paramString2 });
              Log.printErrStackTrace("MicroMsg.Util", localException, "", new Object[0]);
            }
          }
        }
        else
        {
          Log.e("MicroMsg.Util", "invoke failed, no method matched");
          AppMethodBeat.o(230421);
          return;
        }
      }
      catch (Exception paramVarArgs)
      {
        Log.e("MicroMsg.Util", "invoke failed, %s::%s", new Object[] { paramString1, paramString2 });
        Log.printErrStackTrace("MicroMsg.Util", paramVarArgs, "", new Object[0]);
        AppMethodBeat.o(230421);
        return;
      }
      i += 1;
    }
  }
  
  public static boolean isART()
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
  
  public static boolean isAllAlpha(String paramString)
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
  
  public static boolean isAlpha(char paramChar)
  {
    return ((paramChar >= 'a') && (paramChar <= 'z')) || ((paramChar >= 'A') && (paramChar <= 'Z'));
  }
  
  public static boolean isChinese(char paramChar)
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
  
  public static boolean isChinese(String paramString)
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
  
  public static boolean isDayTimeNow()
  {
    AppMethodBeat.i(230409);
    int i = new GregorianCalendar().get(11);
    if ((i >= 6L) && (i < 18L))
    {
      AppMethodBeat.o(230409);
      return true;
    }
    AppMethodBeat.o(230409);
    return false;
  }
  
  public static boolean isDownloadsDocument(Uri paramUri)
  {
    AppMethodBeat.i(230425);
    boolean bool = "com.android.providers.downloads.documents".equals(paramUri.getAuthority());
    AppMethodBeat.o(230425);
    return bool;
  }
  
  public static boolean isEqual(int paramInt1, int paramInt2)
  {
    return paramInt1 == paramInt2;
  }
  
  public static boolean isEqual(long paramLong1, long paramLong2)
  {
    return paramLong1 == paramLong2;
  }
  
  public static boolean isEqual(Object paramObject1, Object paramObject2)
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
  
  public static boolean isEqual(String paramString1, String paramString2)
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
  
  public static boolean isEqual(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(157994);
    boolean bool = Arrays.equals(paramArrayOfByte1, paramArrayOfByte2);
    AppMethodBeat.o(157994);
    return bool;
  }
  
  public static boolean isExternalStorageDocument(Uri paramUri)
  {
    AppMethodBeat.i(230424);
    boolean bool = "com.android.externalstorage.documents".equals(paramUri.getAuthority());
    AppMethodBeat.o(230424);
    return bool;
  }
  
  public static boolean isFilePathSafeToBeCopySrc(String paramString)
  {
    AppMethodBeat.i(157970);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(157970);
      return false;
    }
    try
    {
      String str = new File(s.k(paramString, false)).getCanonicalPath();
      boolean bool = isResolvedPathSafeToBeCopySrc(str);
      AppMethodBeat.o(157970);
      return bool;
    }
    catch (NullPointerException localNullPointerException)
    {
      Log.printErrStackTrace("MicroMsg.Util", localNullPointerException, "[-] Fail to resolve canonical path of %s", new Object[] { paramString });
      AppMethodBeat.o(157970);
      return false;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("MicroMsg.Util", localIOException, "[-] Fail to resolve canonical path of %s", new Object[] { paramString });
      AppMethodBeat.o(157970);
    }
    return false;
  }
  
  public static boolean isGooglePhotosUri(Uri paramUri)
  {
    AppMethodBeat.i(230427);
    boolean bool = "com.google.android.apps.photos.content".equals(paramUri.getAuthority());
    AppMethodBeat.o(230427);
    return bool;
  }
  
  public static boolean isImageExt(String paramString)
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
  
  public static boolean isImageFilename(String paramString)
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
    boolean bool = isImageExt(paramString.substring(i + 1));
    AppMethodBeat.o(157971);
    return bool;
  }
  
  public static boolean isIntentAvailable(Context paramContext, Intent paramIntent)
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
  
  public static boolean isMediaDocument(Uri paramUri)
  {
    AppMethodBeat.i(230426);
    boolean bool = "com.android.providers.media.documents".equals(paramUri.getAuthority());
    AppMethodBeat.o(230426);
    return bool;
  }
  
  public static boolean isMobileNO(String paramString)
  {
    AppMethodBeat.i(230432);
    if (paramString == null)
    {
      AppMethodBeat.o(230432);
      return false;
    }
    boolean bool = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$").matcher(paramString).matches();
    AppMethodBeat.o(230432);
    return bool;
  }
  
  public static boolean isNullOrNil(CharSequence paramCharSequence)
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
  
  public static boolean isNullOrNil(List paramList)
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
  
  public static boolean isNullOrNil(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0);
  }
  
  public static boolean isNullOrNil(String... paramVarArgs)
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
  
  public static boolean isNum(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  public static boolean isOverseasUser(Context paramContext)
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
      Log.w("MicroMsg.Util", "isOverseasUser context is null");
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
  
  public static Boolean isPhoneNumber(String paramString)
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
  
  public static boolean isProcessRunning(Context paramContext, String paramString)
  {
    AppMethodBeat.i(157899);
    try
    {
      if ((paramString.equals(paramContext.getPackageName())) || (paramString.startsWith(paramContext.getPackageName() + ":")) || (Build.VERSION.SDK_INT < 21))
      {
        Log.i("MicroMsg.Util", "isProcessRunning, use ActivityManager. process = %s", new Object[] { paramString });
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
          Log.w("MicroMsg.Util", "process " + paramString + " is running");
          AppMethodBeat.o(157899);
          return true;
          Log.i("MicroMsg.Util", "isProcessRunning, use ps command. process = %s", new Object[] { paramString });
          paramContext = getRunningAppProcessesByPs().iterator();
          while (paramContext.hasNext())
          {
            localObject = (String)paramContext.next();
            Log.d("MicroMsg.Util", "isProcessRunning, process command line = %s", new Object[] { localObject });
            if ((localObject != null) && (((String)localObject).contains(paramString)))
            {
              localObject = ((String)localObject).split("\\s+");
              int i = 0;
              while (i < localObject.length)
              {
                if (paramString.equals(localObject[i]))
                {
                  Log.i("MicroMsg.Util", "process %s is running", new Object[] { paramString });
                  AppMethodBeat.o(157899);
                  return true;
                }
                i += 1;
              }
            }
          }
        }
      }
      Log.w("MicroMsg.Util", "process " + paramString + " is not running");
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Util", paramContext, "", new Object[0]);
      }
    }
    AppMethodBeat.o(157899);
    return false;
  }
  
  public static boolean isResolvedPathSafeToBeCopySrc(String paramString)
  {
    AppMethodBeat.i(230429);
    String str1 = ApplicationGlobal.context().getPackageName();
    if (paramString.contains("/" + str1 + "/cache/"))
    {
      AppMethodBeat.o(230429);
      return true;
    }
    String str2 = "/" + str1 + "-";
    int i = paramString.indexOf(str2);
    if ((i >= 0) && (paramString.startsWith("/cache/", paramString.indexOf("/", str2.length() + i))))
    {
      AppMethodBeat.o(230429);
      return true;
    }
    if ((paramString.contains("/data/data/")) || (paramString.contains("/data/user/")))
    {
      if ((!paramString.contains("/" + str1 + "/")) && (!paramString.contains("/" + str1 + "-")))
      {
        AppMethodBeat.o(230429);
        return true;
      }
      AppMethodBeat.o(230429);
      return false;
    }
    AppMethodBeat.o(230429);
    return true;
  }
  
  public static boolean isSameDay(long paramLong1, long paramLong2)
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
  
  public static boolean isServiceRunning(Context paramContext, String paramString)
  {
    AppMethodBeat.i(157898);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647).iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)paramContext.next();
      if ((localRunningServiceInfo != null) && (localRunningServiceInfo.service != null) && (localRunningServiceInfo.service.getClassName().toString().equals(paramString)))
      {
        Log.w("MicroMsg.Util", "service " + paramString + " is running");
        AppMethodBeat.o(157898);
        return true;
      }
    }
    Log.w("MicroMsg.Util", "service " + paramString + " is not running");
    AppMethodBeat.o(157898);
    return false;
  }
  
  public static boolean isTopActivity(Context paramContext)
  {
    AppMethodBeat.i(157897);
    String str = paramContext.getClass().getName();
    paramContext = getTopActivityName(paramContext);
    Log.d("MicroMsg.Util", "top activity=" + paramContext + ", context=" + str);
    boolean bool = paramContext.equalsIgnoreCase(str);
    AppMethodBeat.o(157897);
    return bool;
  }
  
  public static boolean isTopApplication(Context paramContext)
  {
    AppMethodBeat.i(157901);
    try
    {
      String str = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
      paramContext = paramContext.getPackageName();
      Log.d("MicroMsg.Util", "top activity=" + str + ", context=" + paramContext);
      boolean bool = str.contains(paramContext);
      AppMethodBeat.o(157901);
      return bool;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.Util", paramContext, "", new Object[0]);
      AppMethodBeat.o(157901);
    }
    return false;
  }
  
  public static boolean isUriSafeToBeCopySrc(Uri paramUri)
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
    String str1;
    if (d.oD(30))
    {
      String str2 = paramUri.getPath();
      str1 = str2;
      if (new File(str2).exists()) {}
    }
    else
    {
      str1 = getFilePath(ApplicationGlobal.context(), paramUri);
    }
    boolean bool = isFilePathSafeToBeCopySrc(str1);
    AppMethodBeat.o(157969);
    return bool;
  }
  
  public static boolean isValidAccount(String paramString)
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
    if (!isAlpha(paramString.charAt(0)))
    {
      AppMethodBeat.o(157873);
      return false;
    }
    int i = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if ((!isAlpha(c)) && (!isNum(c)) && (c != '-') && (c != '_'))
      {
        AppMethodBeat.o(157873);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(157873);
    return true;
  }
  
  public static boolean isValidEmail(String paramString)
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
  
  public static boolean isValidPassword(String paramString)
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
  
  public static boolean isValidQQNum(String paramString)
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
      Log.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(157870);
      return false;
    }
    AppMethodBeat.o(157870);
    return false;
  }
  
  public static boolean jump(Context paramContext, String paramString)
  {
    AppMethodBeat.i(157937);
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    if (!isIntentAvailable(paramContext, localIntent))
    {
      Log.e("MicroMsg.Util", "jump to url failed, ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(157937);
      return false;
    }
    paramString = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.axQ(), "com/tencent/mm/sdk/platformtools/Util", "jump", "(Landroid/content/Context;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/sdk/platformtools/Util", "jump", "(Landroid/content/Context;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(157937);
    return true;
  }
  
  public static void lightShake(Context paramContext)
  {
    AppMethodBeat.i(157884);
    paramContext = (Vibrator)paramContext.getSystemService("vibrator");
    if (paramContext == null)
    {
      AppMethodBeat.o(157884);
      return;
    }
    paramContext.vibrate(LIGHT_PATTERN, -1);
    AppMethodBeat.o(157884);
  }
  
  public static String listToString(List<String> paramList, String paramString)
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
  
  public static String[] listToStrings(List<String> paramList)
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
  
  private static int lookupEntity(char[] paramArrayOfChar, int paramInt1, int paramInt2)
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
    paramInt1 = getEntity(new String(paramArrayOfChar, paramInt1, paramInt2));
    AppMethodBeat.o(157940);
    return paramInt1;
  }
  
  public static String mapToXml(String paramString, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    AppMethodBeat.i(230420);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<key>");
    Iterator localIterator = paramLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramString = (Map.Entry)localIterator.next();
      paramLinkedHashMap = paramString.getKey();
      Object localObject = paramString.getValue();
      paramString = paramLinkedHashMap;
      if (paramLinkedHashMap == null) {
        paramString = "unknow";
      }
      paramLinkedHashMap = localObject;
      if (localObject == null) {
        paramLinkedHashMap = "unknow";
      }
      localStringBuilder.append("<" + paramString + ">");
      localStringBuilder.append(paramLinkedHashMap);
      localStringBuilder.append("</" + paramString + ">");
    }
    localStringBuilder.append("</key>");
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(230420);
    return paramString;
  }
  
  public static long milliSecondsToDate(String paramString)
  {
    AppMethodBeat.i(230423);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(230423);
      return 0L;
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try
    {
      long l1 = localSimpleDateFormat.parse(paramString).getTime();
      long l2 = System.currentTimeMillis();
      Log.i("MicroMsg.Util", "todate:[%d], now date:[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
      AppMethodBeat.o(230423);
      return l2 - l1;
    }
    catch (ParseException paramString)
    {
      Log.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(230423);
    }
    return 0L;
  }
  
  public static long milliSecondsToNow(long paramLong)
  {
    AppMethodBeat.i(157980);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(157980);
    return l - paramLong;
  }
  
  public static String notNullToString(Object paramObject)
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
  
  public static long nowMilliSecond()
  {
    AppMethodBeat.i(186054);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(186054);
    return l;
  }
  
  public static long nowSecond()
  {
    AppMethodBeat.i(157885);
    long l = System.currentTimeMillis() / 1000L;
    AppMethodBeat.o(157885);
    return l;
  }
  
  public static int nullAs(Integer paramInteger, int paramInt)
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
  
  public static long nullAs(Long paramLong, long paramLong1)
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
  
  public static String nullAs(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2;
    }
    return paramString1;
  }
  
  public static boolean nullAs(Boolean paramBoolean, boolean paramBoolean1)
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
  
  public static byte[] nullAs(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == null) {
      return paramArrayOfByte2;
    }
    return paramArrayOfByte1;
  }
  
  public static boolean nullAsFalse(Boolean paramBoolean)
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
  
  public static int nullAsInt(Object paramObject, int paramInt)
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
  
  public static long nullAsLong(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(230417);
    if (paramObject == null)
    {
      l = paramInt;
      AppMethodBeat.o(230417);
      return l;
    }
    if ((paramObject instanceof Long))
    {
      l = ((Long)paramObject).longValue();
      AppMethodBeat.o(230417);
      return l;
    }
    long l = paramInt;
    AppMethodBeat.o(230417);
    return l;
  }
  
  public static int nullAsNil(Integer paramInteger)
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
  
  public static long nullAsNil(Long paramLong)
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
  
  public static String nullAsNil(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static boolean nullAsTrue(Boolean paramBoolean)
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
  
  public static String processXml(String paramString)
  {
    AppMethodBeat.i(157939);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(157939);
      return paramString;
    }
    if (Build.VERSION.SDK_INT < 8)
    {
      paramString = expandEntities(paramString);
      AppMethodBeat.o(157939);
      return paramString;
    }
    AppMethodBeat.o(157939);
    return paramString;
  }
  
  public static void qualityClose(Closeable paramCloseable)
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
      Log.printErrStackTrace("MicroMsg.Util", paramCloseable, "qualityClose", new Object[0]);
      AppMethodBeat.o(157985);
    }
  }
  
  public static List<ResolveInfo> queryIntentActivities(Context paramContext, Intent paramIntent)
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
  
  public static int random()
  {
    AppMethodBeat.i(157966);
    int i = new Random().nextInt();
    AppMethodBeat.o(157966);
    return i;
  }
  
  /* Error */
  public static byte[] readFromFile(String paramString)
  {
    // Byte code:
    //   0: ldc_w 2007
    //   3: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 424	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +19 -> 29
    //   13: ldc 91
    //   15: ldc_w 2009
    //   18: invokestatic 1060	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 2007
    //   24: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aconst_null
    //   28: areturn
    //   29: new 426	com/tencent/mm/vfs/o
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 429	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   37: astore_3
    //   38: aload_3
    //   39: invokevirtual 433	com/tencent/mm/vfs/o:exists	()Z
    //   42: ifne +27 -> 69
    //   45: ldc 91
    //   47: ldc_w 2011
    //   50: iconst_1
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload_0
    //   57: aastore
    //   58: invokestatic 2013	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: ldc_w 2007
    //   64: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aconst_null
    //   68: areturn
    //   69: aload_3
    //   70: invokevirtual 2015	com/tencent/mm/vfs/o:length	()J
    //   73: l2i
    //   74: istore_1
    //   75: aload_3
    //   76: invokestatic 2019	com/tencent/mm/vfs/s:ao	(Lcom/tencent/mm/vfs/o;)Ljava/io/InputStream;
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
    //   96: invokevirtual 1226	java/io/InputStream:read	([B)I
    //   99: istore_2
    //   100: iload_2
    //   101: iload_1
    //   102: if_icmpeq +70 -> 172
    //   105: aload 4
    //   107: astore_3
    //   108: ldc 91
    //   110: ldc_w 2021
    //   113: iconst_3
    //   114: anewarray 4	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload_0
    //   120: aastore
    //   121: dup
    //   122: iconst_1
    //   123: iload_1
    //   124: invokestatic 496	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   127: aastore
    //   128: dup
    //   129: iconst_2
    //   130: iload_2
    //   131: invokestatic 496	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   134: aastore
    //   135: invokestatic 2013	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   138: aload 4
    //   140: ifnull +8 -> 148
    //   143: aload 4
    //   145: invokevirtual 330	java/io/InputStream:close	()V
    //   148: ldc_w 2007
    //   151: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: aconst_null
    //   155: areturn
    //   156: astore_0
    //   157: ldc 91
    //   159: aload_0
    //   160: ldc 230
    //   162: iconst_0
    //   163: anewarray 4	java/lang/Object
    //   166: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: goto -21 -> 148
    //   172: aload 4
    //   174: astore_3
    //   175: ldc 91
    //   177: ldc_w 2023
    //   180: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: aload 4
    //   185: ifnull +8 -> 193
    //   188: aload 4
    //   190: invokevirtual 330	java/io/InputStream:close	()V
    //   193: ldc_w 2007
    //   196: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: aload 5
    //   201: areturn
    //   202: astore_0
    //   203: ldc 91
    //   205: aload_0
    //   206: ldc 230
    //   208: iconst_0
    //   209: anewarray 4	java/lang/Object
    //   212: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: goto -22 -> 193
    //   218: astore_0
    //   219: aconst_null
    //   220: astore 4
    //   222: aload 4
    //   224: astore_3
    //   225: ldc 91
    //   227: aload_0
    //   228: ldc 230
    //   230: iconst_0
    //   231: anewarray 4	java/lang/Object
    //   234: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: aload 4
    //   239: ifnull +8 -> 247
    //   242: aload 4
    //   244: invokevirtual 330	java/io/InputStream:close	()V
    //   247: ldc_w 2007
    //   250: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   253: aconst_null
    //   254: areturn
    //   255: astore_0
    //   256: ldc 91
    //   258: aload_0
    //   259: ldc 230
    //   261: iconst_0
    //   262: anewarray 4	java/lang/Object
    //   265: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   268: goto -21 -> 247
    //   271: astore_0
    //   272: aconst_null
    //   273: astore_3
    //   274: aload_3
    //   275: ifnull +7 -> 282
    //   278: aload_3
    //   279: invokevirtual 330	java/io/InputStream:close	()V
    //   282: ldc_w 2007
    //   285: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   288: aload_0
    //   289: athrow
    //   290: astore_3
    //   291: ldc 91
    //   293: aload_3
    //   294: ldc 230
    //   296: iconst_0
    //   297: anewarray 4	java/lang/Object
    //   300: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   303: goto -21 -> 282
    //   306: astore_0
    //   307: goto -33 -> 274
    //   310: astore_0
    //   311: goto -89 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	paramString	String
    //   74	50	1	i	int
    //   99	32	2	j	int
    //   37	242	3	localObject	Object
    //   290	4	3	localIOException	IOException
    //   79	164	4	localInputStream	InputStream
    //   87	113	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   143	148	156	java/io/IOException
    //   188	193	202	java/io/IOException
    //   69	81	218	java/lang/Exception
    //   242	247	255	java/io/IOException
    //   69	81	271	finally
    //   278	282	290	java/io/IOException
    //   84	89	306	finally
    //   92	100	306	finally
    //   108	138	306	finally
    //   175	183	306	finally
    //   225	237	306	finally
    //   84	89	310	java/lang/Exception
    //   92	100	310	java/lang/Exception
    //   108	138	310	java/lang/Exception
    //   175	183	310	java/lang/Exception
  }
  
  public static String safeFormatString(String paramString, Object... paramVarArgs)
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
        Log.i("MicroMsg.Util", "error safeFormatString %s", new Object[] { paramVarArgs.getMessage() });
      }
    }
    AppMethodBeat.o(157997);
    return paramString;
  }
  
  public static double safeParseDouble(String paramString)
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
          Log.e("MicroMsg.Util", "parseDouble error ".concat(String.valueOf(paramString)));
          d1 = d2;
        }
      }
    }
  }
  
  public static float safeParseFloat(String paramString)
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
          Log.e("MicroMsg.Util", "parseFloat error ".concat(String.valueOf(paramString)));
          f1 = f2;
        }
      }
    }
  }
  
  public static int safeParseInt(String paramString)
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
          Log.e("MicroMsg.Util", "parserInt error ".concat(String.valueOf(paramString)));
          i = j;
        }
      }
    }
  }
  
  public static long safeParseLong(String paramString)
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
          Log.e("MicroMsg.Util", "parseLong error ".concat(String.valueOf(paramString)));
          l1 = l2;
        }
      }
    }
  }
  
  public static String secPrint(String paramString)
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
  
  public static long secondsToNow(long paramLong)
  {
    AppMethodBeat.i(157887);
    long l = System.currentTimeMillis() / 1000L;
    AppMethodBeat.o(157887);
    return l - paramLong;
  }
  
  public static void selectPicture(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(230416);
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.setType("image/*");
    localIntent = Intent.createChooser(localIntent, null);
    ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
    AppMethodBeat.o(230416);
  }
  
  public static void shake(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(157883);
    paramContext = (Vibrator)paramContext.getSystemService("vibrator");
    if (paramContext == null)
    {
      Log.w("MicroMsg.Util", "shake:vibrator is null!");
      AppMethodBeat.o(157883);
      return;
    }
    if (paramBoolean)
    {
      paramContext.vibrate(VIRBRATOR_PATTERN, -1);
      AppMethodBeat.o(157883);
      return;
    }
    paramContext.cancel();
    AppMethodBeat.o(157883);
  }
  
  public static int[] splitToIntArray(String paramString)
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
            Log.printErrStackTrace("MicroMsg.Util", localException, "", new Object[0]);
            Log.e("MicroMsg.Util", "invalid port num, ignore");
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
  
  public static String stackTraceToString(Throwable paramThrowable)
  {
    AppMethodBeat.i(186053);
    paramThrowable = MMStack.stackTraceToString(paramThrowable);
    AppMethodBeat.o(186053);
    return paramThrowable;
  }
  
  public static String streamToString(InputStream paramInputStream)
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
          Log.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
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
            Log.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
          }
        }
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Util", paramInputStream, "", new Object[0]);
        }
      }
    }
    finally {}
  }
  
  public static List<String> stringToList(String paramString1, String paramString2)
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
  
  public static ArrayList<String> stringsToList(String[] paramArrayOfString)
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
  
  public static String subStringEmail(String paramString)
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
  
  public static long ticksToNow(long paramLong)
  {
    AppMethodBeat.i(157888);
    long l = SystemClock.elapsedRealtime();
    AppMethodBeat.o(157888);
    return l - paramLong;
  }
  
  public static String trimPhoneNumber(String paramString)
  {
    AppMethodBeat.i(157959);
    paramString = paramString.replaceAll("[\\.\\-]", "").trim();
    AppMethodBeat.o(157959);
    return paramString;
  }
  
  public static String unixTimeMsToTime(long paramLong)
  {
    AppMethodBeat.i(157865);
    String str = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date(paramLong));
    AppMethodBeat.o(157865);
    return str;
  }
  
  public static int videoMsToSec(long paramLong)
  {
    AppMethodBeat.i(158000);
    int i = Math.round((float)paramLong / 1000.0F);
    AppMethodBeat.o(158000);
    return i;
  }
  
  public static boolean writeToFile(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(157949);
    if ((isNullOrNil(paramString)) || (isNullOrNil(paramArrayOfByte)))
    {
      Log.w("MicroMsg.Util", "write to file error, path is null or empty, or data is empty");
      AppMethodBeat.o(157949);
      return false;
    }
    localObject = null;
    String str = null;
    try
    {
      paramString = s.dw(paramString, false);
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
        Log.d("MicroMsg.Util", "writeToFile ok!");
        AppMethodBeat.o(157949);
        return true;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
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
          Log.printErrStackTrace("MicroMsg.Util", paramArrayOfByte, "", new Object[0]);
        }
      }
    }
    catch (Exception paramString)
    {
      localObject = str;
      Log.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      localObject = str;
      Log.w("MicroMsg.Util", "write to file error");
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
          Log.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
        }
      }
    }
    finally
    {
      if (localObject == null) {}
    }
  }
  
  public static class ActivityTaskInfo
  {
    private Context context;
    
    public ActivityTaskInfo(Context paramContext)
    {
      this.context = paramContext;
    }
    
    public static String getTaskInfo(Context paramContext)
    {
      AppMethodBeat.i(157855);
      if (paramContext == null)
      {
        AppMethodBeat.o(157855);
        return null;
      }
      Object localObject1 = (ActivityManager)paramContext.getSystemService("activity");
      paramContext = paramContext.getPackageName();
      if ((localObject1 == null) || (Util.isNullOrNil(paramContext)))
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
        Log.printErrStackTrace("MicroMsg.Util", paramContext, "", new Object[0]);
        AppMethodBeat.o(157855);
        return "";
      }
      AppMethodBeat.o(157855);
      return paramContext;
    }
    
    public String toString()
    {
      AppMethodBeat.i(157854);
      String str = getTaskInfo(this.context);
      AppMethodBeat.o(157854);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.Util
 * JD-Core Version:    0.7.0.1
 */