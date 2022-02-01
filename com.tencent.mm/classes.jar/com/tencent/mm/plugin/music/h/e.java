package com.tencent.mm.plugin.music.h;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class e
{
  private static final String[] Apb;
  private static String Apc;
  private static String Apd;
  private static final Pattern lnT;
  
  static
  {
    AppMethodBeat.i(137462);
    Apb = new String[] { "#", "?", "&" };
    Apc = null;
    Apd = null;
    lnT = Pattern.compile("songid=([0-9]+)");
    AppMethodBeat.o(137462);
  }
  
  private static int E(char paramChar)
  {
    int j = 0;
    int i;
    if ((paramChar >= '1') && (paramChar <= '9')) {
      i = paramChar - '0';
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramChar < 'A');
      i = j;
    } while (paramChar > 'F');
    return paramChar - 'A' + 10;
  }
  
  public static String W(f paramf)
  {
    AppMethodBeat.i(198194);
    if (paramf == null)
    {
      AppMethodBeat.o(198194);
      return null;
    }
    if (!Util.isNullOrNil(paramf.jfb))
    {
      paramf = paramf.jfb;
      AppMethodBeat.o(198194);
      return paramf;
    }
    if (!Util.isNullOrNil(paramf.jfd))
    {
      paramf = paramf.jfd;
      AppMethodBeat.o(198194);
      return paramf;
    }
    if (!Util.isNullOrNil(paramf.jfc))
    {
      paramf = paramf.jfc;
      AppMethodBeat.o(198194);
      return paramf;
    }
    AppMethodBeat.o(198194);
    return null;
  }
  
  private static String X(f paramf)
  {
    AppMethodBeat.i(137460);
    if (W(paramf) == null)
    {
      AppMethodBeat.o(137460);
      return null;
    }
    String str = aIh(paramf.jfb);
    if (str != null)
    {
      AppMethodBeat.o(137460);
      return str;
    }
    str = aIh(paramf.jfd);
    if (str != null)
    {
      AppMethodBeat.o(137460);
      return str;
    }
    paramf = aIh(paramf.jfc);
    AppMethodBeat.o(137460);
    return paramf;
  }
  
  public static f Y(f paramf)
  {
    AppMethodBeat.i(137461);
    if (paramf != null)
    {
      paramf.jfk = aIj(paramf.jfb);
      if (paramf.jfk <= 0)
      {
        paramf.jfk = aIj(paramf.jfd);
        if (paramf.jfk <= 0) {
          paramf.jfk = aIj(paramf.jfc);
        }
      }
    }
    if ((paramf == null) || (X(paramf) == null))
    {
      AppMethodBeat.o(137461);
      return paramf;
    }
    long l = System.currentTimeMillis();
    Object localObject = X(paramf);
    if (localObject == null)
    {
      AppMethodBeat.o(137461);
      return paramf;
    }
    Log.d("MicroMsg.Music.MusicUrlUtil", "bcdUrl: %s", new Object[] { localObject });
    String str = new String(aIi((String)localObject));
    int i = str.indexOf("{");
    localObject = str;
    if (i != -1) {
      localObject = str.substring(i);
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      paramf.jfk = ((JSONObject)localObject).optInt("song_ID");
      if (Util.isNullOrNil(paramf.jeX)) {
        paramf.jeX = ((JSONObject)localObject).optString("song_Name");
      }
      if (Util.isNullOrNil(paramf.jfc)) {
        paramf.jfc = ((JSONObject)localObject).optString("song_WapLiveURL");
      }
      if (Util.isNullOrNil(paramf.jfb)) {
        paramf.jfb = ((JSONObject)localObject).optString("song_WifiURL");
      }
      if (Util.isNullOrNil(paramf.jeZ)) {
        paramf.jeZ = ((JSONObject)localObject).optString("song_Album");
      }
      if (Util.isNullOrNil(paramf.jeY)) {
        paramf.jeY = ((JSONObject)localObject).optString("song_Singer");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", localException, "", new Object[0]);
      }
    }
    if (paramf.jfk == 0) {
      paramf.jfk = aIj(Apc);
    }
    Log.i("MicroMsg.Music.MusicUrlUtil", "parseBCDForMusicWrapper %s: expend: %d %d", new Object[] { paramf.jeV, Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(paramf.jfk) });
    AppMethodBeat.o(137461);
    return paramf;
  }
  
  public static String a(String paramString1, String paramString2, boolean paramBoolean, PBool paramPBool)
  {
    AppMethodBeat.i(137455);
    if ((paramBoolean) || (Util.isNullOrNil(paramString2))) {}
    for (String str = paramString1; Util.isNullOrNil(str); str = paramString2)
    {
      AppMethodBeat.o(137455);
      return str;
    }
    PString localPString = new PString();
    Log.i("MicroMsg.Music.MusicUrlUtil", "url[%s], lowBandUrl[%s], isWifi[%B]", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    paramString1 = aIh(str);
    if (paramString1 != null) {
      if (a(paramString1, paramBoolean, localPString)) {
        paramPBool.value = paramBoolean;
      }
    }
    for (;;)
    {
      paramString1 = localPString.value;
      AppMethodBeat.o(137455);
      return paramString1;
      if (str.contains("wechat_music_url=")) {
        a(str.substring(str.indexOf("wechat_music_url=") + 17), paramBoolean, localPString);
      } else {
        localPString.value = str;
      }
    }
  }
  
  private static boolean a(String paramString, boolean paramBoolean, PString paramPString)
  {
    AppMethodBeat.i(137457);
    Object localObject2 = new String(aIi(paramString));
    int i = ((String)localObject2).indexOf("{");
    Object localObject1 = localObject2;
    if (i != -1) {
      localObject1 = ((String)localObject2).substring(i);
    }
    try
    {
      localObject2 = new JSONObject((String)localObject1);
      localObject1 = ((JSONObject)localObject2).getString("song_WapLiveURL");
      localObject2 = ((JSONObject)localObject2).getString("song_WifiURL");
      Log.d("MicroMsg.Music.MusicUrlUtil", "waplive: " + (String)localObject1 + "  wifi:" + (String)localObject2);
      if (paramBoolean) {
        localObject1 = localObject2;
      }
      for (;;)
      {
        paramPString.value = ((String)localObject1);
        AppMethodBeat.o(137457);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      paramPString.value = paramString;
      Log.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", localException, "decodeJson", new Object[0]);
      AppMethodBeat.o(137457);
    }
  }
  
  public static boolean aIg(String paramString)
  {
    AppMethodBeat.i(137453);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(137453);
      return false;
    }
    Uri localUri = Uri.parse(paramString);
    String str = "";
    if (localUri != null) {
      str = localUri.getHost();
    }
    boolean bool;
    if (str != null)
    {
      bool = localUri.getHost().contains(".qq.com");
      Log.w("MicroMsg.Music.MusicUrlUtil", "url %s match ? %B", new Object[] { paramString, Boolean.valueOf(bool) });
    }
    for (;;)
    {
      AppMethodBeat.o(137453);
      return bool;
      Log.i("MicroMsg.Music.MusicUrlUtil", "host is null, url is not match .qq.com");
      bool = false;
    }
  }
  
  private static String aIh(String paramString)
  {
    AppMethodBeat.i(137456);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(137456);
      return null;
    }
    if ((Apc != null) && (paramString.equals(Apc)))
    {
      paramString = Apd;
      AppMethodBeat.o(137456);
      return paramString;
    }
    Object localObject2 = "";
    String[] arrayOfString = Apb;
    int j = arrayOfString.length;
    int i = 0;
    Object localObject1 = null;
    Object localObject4;
    for (;;)
    {
      localObject3 = localObject2;
      localObject4 = localObject1;
      if (i >= j) {
        break;
      }
      localObject2 = arrayOfString[i];
      localObject2 = (String)localObject2 + "p=";
      if (paramString.contains((CharSequence)localObject2)) {
        localObject1 = paramString;
      }
      localObject3 = localObject2;
      localObject4 = localObject1;
      if (localObject1 != null) {
        break;
      }
      i += 1;
    }
    if (localObject4 == null)
    {
      AppMethodBeat.o(137456);
      return null;
    }
    i = localObject4.indexOf((String)localObject3);
    if (i < 0)
    {
      Log.w("MicroMsg.Music.MusicUrlUtil", "pIndex is %d, return", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(137456);
      return null;
    }
    localObject1 = localObject4.substring(((String)localObject3).length() + i);
    Object localObject3 = Apb;
    j = localObject3.length;
    i = 0;
    while (i < j)
    {
      int k = ((String)localObject1).indexOf(localObject3[i]);
      localObject2 = localObject1;
      if (k > 0) {
        localObject2 = ((String)localObject1).substring(0, k);
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (localObject1 != null)
    {
      Apc = paramString;
      Apd = (String)localObject1;
    }
    AppMethodBeat.o(137456);
    return localObject1;
  }
  
  private static byte[] aIi(String paramString)
  {
    AppMethodBeat.i(137458);
    byte[] arrayOfByte = new byte[paramString.length() / 2 + paramString.length() % 2];
    int i = 0;
    int j = 0;
    for (;;)
    {
      try
      {
        if (i < paramString.length())
        {
          k = i + 1;
          int n = E(paramString.charAt(i));
          if (k >= paramString.length()) {
            break label106;
          }
          i = k + 1;
          k = E(paramString.charAt(k));
          arrayOfByte[j] = ((byte)(k | n << 4));
          j += 1;
          continue;
        }
        AppMethodBeat.o(137458);
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(137458);
        return null;
      }
      return arrayOfByte;
      label106:
      int m = 0;
      i = k;
      int k = m;
    }
  }
  
  private static int aIj(String paramString)
  {
    AppMethodBeat.i(137459);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(137459);
      return 0;
    }
    paramString = lnT.matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group(1);
      try
      {
        int i = Integer.valueOf(paramString).intValue();
        AppMethodBeat.o(137459);
        return i;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", paramString, "getSongId", new Object[0]);
        AppMethodBeat.o(137459);
        return 0;
      }
    }
    AppMethodBeat.o(137459);
    return 0;
  }
  
  public static String aIk(String paramString)
  {
    AppMethodBeat.i(198195);
    if (paramString == null) {}
    for (int i = -1; i < 0; i = paramString.indexOf("songmid="))
    {
      AppMethodBeat.o(198195);
      return null;
    }
    paramString = paramString.substring(i + 8);
    if ((paramString != null) && (paramString.contains("&")))
    {
      paramString = paramString.substring(0, paramString.indexOf("&"));
      AppMethodBeat.o(198195);
      return paramString;
    }
    AppMethodBeat.o(198195);
    return paramString;
  }
  
  public static String aIl(String paramString)
  {
    AppMethodBeat.i(198196);
    if (paramString == null) {}
    for (int i = -1; i < 0; i = paramString.indexOf("songid="))
    {
      AppMethodBeat.o(198196);
      return null;
    }
    paramString = paramString.substring(i + 7);
    if ((paramString != null) && (paramString.contains("&")))
    {
      paramString = paramString.substring(0, paramString.indexOf("&"));
      AppMethodBeat.o(198196);
      return paramString;
    }
    AppMethodBeat.o(198196);
    return paramString;
  }
  
  public static String gH(Context paramContext)
  {
    AppMethodBeat.i(137454);
    String str = "";
    Object localObject2 = MMApplicationContext.getPackageName();
    if (localObject2 == null)
    {
      AppMethodBeat.o(137454);
      return "";
    }
    Object localObject1 = str;
    try
    {
      localObject2 = paramContext.getPackageManager().getPackageInfo((String)localObject2, 0);
      localObject1 = str;
      if (localObject2 != null)
      {
        localObject1 = str;
        paramContext = "" + ((PackageInfo)localObject2).versionName;
        localObject1 = paramContext;
        paramContext = paramContext + ((PackageInfo)localObject2).versionCode;
        localObject1 = paramContext;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", paramContext, "", new Object[0]);
      }
    }
    AppMethodBeat.o(137454);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.e
 * JD-Core Version:    0.7.0.1
 */