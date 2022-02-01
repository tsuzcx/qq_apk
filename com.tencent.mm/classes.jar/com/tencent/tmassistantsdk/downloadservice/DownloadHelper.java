package com.tencent.tmassistantsdk.downloadservice;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.os.PowerManager.WakeLock;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.io.File;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class DownloadHelper
{
  public static final int PHONE = 1;
  public static final float SAVE_FATOR = 1.5F;
  public static final long SAVE_LENGTH = 104857600L;
  public static final int SDCARD = 2;
  public static final String TAG;
  public static final int UNKNOWN = 0;
  
  static
  {
    AppMethodBeat.i(101959);
    TAG = DownloadHelper.class.getSimpleName();
    AppMethodBeat.o(101959);
  }
  
  public static String correctFileName(String paramString)
  {
    AppMethodBeat.i(101949);
    paramString = paramString.replace("?", "_").replace("*", "_").replace(" ", "_").replace("$", "_").replace("&", "_").replace("@", "_").replace("#", "_").replace("<", "_").replace(">", "_").replace("|", "_").replace(":", "_").replace("/", "_").replace("\\", "_").replace("\"", "_");
    AppMethodBeat.o(101949);
    return paramString;
  }
  
  public static String correctURL(String paramString)
  {
    AppMethodBeat.i(101946);
    paramString = paramString.replace("\r", "").replace("\n", "").trim();
    str1 = new String(paramString);
    try
    {
      Uri localUri = Uri.parse(paramString);
      String str2 = localUri.getLastPathSegment();
      paramString = str1;
      if (str2 != null)
      {
        paramString = str1;
        if (str2.length() > 0) {
          paramString = str1.replace(str2, URLEncoder.encode(localUri.getLastPathSegment()).replace("+", "%20"));
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, paramString, "", new Object[0]);
        paramString = str1;
      }
    }
    AppMethodBeat.o(101946);
    return paramString;
  }
  
  public static String decodeFileName(String paramString)
  {
    AppMethodBeat.i(101948);
    if (paramString != null)
    {
      paramString = URLDecoder.decode(paramString);
      AppMethodBeat.o(101948);
      return paramString;
    }
    AppMethodBeat.o(101948);
    return null;
  }
  
  public static String genAPKFileName(String paramString)
  {
    AppMethodBeat.i(101947);
    if (paramString.contains(".apk"))
    {
      String str = paramString.trim().substring(paramString.lastIndexOf("/") + 1).trim();
      paramString = str;
      if (str.contains("?")) {
        paramString = str.substring(0, str.lastIndexOf("?"));
      }
      if (!TextUtils.isEmpty(paramString))
      {
        TMLog.i(TAG, "file name = ".concat(String.valueOf(paramString)));
        paramString = renameAPKFileName(paramString);
        AppMethodBeat.o(101947);
        return paramString;
      }
    }
    AppMethodBeat.o(101947);
    return null;
  }
  
  public static String generateFileNameFromURL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101952);
    String str2 = GlobalUtil.calcMD5AsString(paramString1);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = Integer.toString(Math.abs(paramString1.hashCode()));
    }
    str2 = "";
    paramString1 = str2;
    if (!TextUtils.isEmpty(paramString2))
    {
      if (!paramString2.equals("application/vnd.android.package-archive")) {
        break label80;
      }
      paramString1 = ".apk";
    }
    for (;;)
    {
      paramString1 = str1 + paramString1;
      AppMethodBeat.o(101952);
      return paramString1;
      label80:
      if (paramString2.equals("application/tm.android.apkdiff"))
      {
        paramString1 = ".diff";
      }
      else
      {
        paramString1 = str2;
        if (paramString2.equals("resource/tm.android.unknown")) {
          paramString1 = ".other";
        }
      }
    }
  }
  
  public static String getNetStatus()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(101953);
        localObject1 = GlobalUtil.getInstance().getContext();
        if (localObject1 != null) {
          continue;
        }
        localObject1 = "";
        AppMethodBeat.o(101953);
      }
      finally
      {
        try
        {
          if (((Context)localObject1).checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
            break label70;
          }
          Object localObject1 = "";
          AppMethodBeat.o(101953);
        }
        catch (Exception localException)
        {
          localObject3 = "";
          AppMethodBeat.o(101953);
        }
        localObject2 = finally;
      }
      return localObject1;
      continue;
      label70:
      Object localObject3 = ((ConnectivityManager)((Context)localObject3).getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject3 == null)
      {
        localObject3 = "";
        AppMethodBeat.o(101953);
      }
      else if (((NetworkInfo)localObject3).getType() == 1)
      {
        localObject3 = "wifi";
        AppMethodBeat.o(101953);
      }
      else
      {
        localObject3 = ((NetworkInfo)localObject3).getExtraInfo();
        if (localObject3 == null)
        {
          localObject3 = "";
          AppMethodBeat.o(101953);
        }
        else
        {
          localObject3 = ((String)localObject3).toLowerCase();
          TMLog.v(TAG, "netInfo  =  ".concat(String.valueOf(localObject3)));
          AppMethodBeat.o(101953);
        }
      }
    }
  }
  
  public static int getStorePosition(String paramString)
  {
    AppMethodBeat.i(101958);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(101958);
      return 0;
    }
    if ((paramString != null) && (paramString.startsWith("/data")))
    {
      AppMethodBeat.o(101958);
      return 1;
    }
    if (TMAssistantFile.isSDCardExistAndCanWrite())
    {
      AppMethodBeat.o(101958);
      return 2;
    }
    AppMethodBeat.o(101958);
    return 0;
  }
  
  public static PowerManager.WakeLock getWakeLock()
  {
    return null;
  }
  
  public static boolean isDownloadFileExisted(String paramString)
  {
    boolean bool1 = false;
    AppMethodBeat.i(101956);
    if (paramString == null)
    {
      AppMethodBeat.o(101956);
      return false;
    }
    try
    {
      boolean bool2 = new q(TMAssistantFile.getSaveFilePath(paramString)).ifE();
      if (bool2) {
        bool1 = true;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, paramString, "", new Object[0]);
      }
    }
    finally
    {
      AppMethodBeat.o(101956);
    }
    AppMethodBeat.o(101956);
    return bool1;
  }
  
  public static boolean isDownloadFileExisted(String paramString1, String paramString2)
  {
    boolean bool1 = false;
    AppMethodBeat.i(101955);
    try
    {
      boolean bool2 = new q(TMAssistantFile.getSaveFilePath(generateFileNameFromURL(paramString1, paramString2))).ifE();
      if (bool2) {
        bool1 = true;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, paramString1, "", new Object[0]);
      }
    }
    finally
    {
      AppMethodBeat.o(101955);
    }
    AppMethodBeat.o(101955);
    return bool1;
  }
  
  public static boolean isNetworkConncted()
  {
    AppMethodBeat.i(101954);
    Object localObject = GlobalUtil.getInstance().getContext();
    if (localObject == null)
    {
      TMLog.w(TAG, "GlobalUtil.getInstance().getContext() == null.");
      AppMethodBeat.o(101954);
      return false;
    }
    localObject = ((ConnectivityManager)((Context)localObject).getSystemService("connectivity")).getActiveNetworkInfo();
    if (localObject != null) {}
    for (boolean bool = ((NetworkInfo)localObject).isAvailable();; bool = false)
    {
      AppMethodBeat.o(101954);
      return bool;
    }
  }
  
  public static boolean isSpaceEnough(String paramString, long paramLong)
  {
    long l2 = 0L;
    AppMethodBeat.i(101957);
    long l1 = -1L;
    int i = getStorePosition(paramString);
    long l3;
    if (i == 1)
    {
      paramString = new StatFs(Environment.getDataDirectory().getPath());
      l1 = paramString.getBlockSize();
      l3 = (paramString.getAvailableBlocks() - 4L) * l1;
      l1 = l3;
      if (l3 >= 0L) {
        break label185;
      }
      l1 = l2;
    }
    label185:
    for (;;)
    {
      paramLong = ((float)paramLong * 1.5F);
      if (paramLong <= 104857600L) {
        break label196;
      }
      if (l1 < paramLong) {
        break;
      }
      AppMethodBeat.o(101957);
      return true;
      if (i == 2)
      {
        l1 = l2;
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
          paramString = new StatFs(new q(Environment.getExternalStorageDirectory().getPath()).getPath());
          l1 = paramString.getBlockSize();
          l3 = (paramString.getAvailableBlocks() - 4L) * l1;
          l1 = l2;
          if (l3 >= 0L) {
            l1 = l3;
          }
        }
      }
    }
    AppMethodBeat.o(101957);
    return false;
    label196:
    if (l1 >= 104857600L)
    {
      AppMethodBeat.o(101957);
      return true;
    }
    AppMethodBeat.o(101957);
    return false;
  }
  
  public static boolean isValidURL(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(101951);
    try
    {
      new URI(correctURL(paramString));
      bool = true;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, paramString, "", new Object[0]);
      }
    }
    AppMethodBeat.o(101951);
    return bool;
  }
  
  public static String renameAPKFileName(String paramString)
  {
    AppMethodBeat.i(101950);
    if (paramString == null)
    {
      AppMethodBeat.o(101950);
      return null;
    }
    int i = paramString.lastIndexOf('.');
    if ((i <= 0) || (i == paramString.length() - 1))
    {
      AppMethodBeat.o(101950);
      return paramString;
    }
    String[] arrayOfString = new String[2];
    arrayOfString[0] = paramString.substring(0, i);
    arrayOfString[1] = paramString.substring(i, paramString.length());
    i = 0;
    if (i == 0) {}
    for (String str = paramString;; str = arrayOfString[0] + "(" + i + ")" + arrayOfString[1])
    {
      i += 1;
      if (new q(TMAssistantFile.getSavePathRootDir() + "/" + str).ifE()) {
        break;
      }
      AppMethodBeat.o(101950);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.DownloadHelper
 * JD-Core Version:    0.7.0.1
 */