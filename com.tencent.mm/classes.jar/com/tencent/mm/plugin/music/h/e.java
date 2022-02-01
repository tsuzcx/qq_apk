package com.tencent.mm.plugin.music.h;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class e
{
  private static final Pattern kgU;
  private static final String[] woa;
  private static String wob;
  private static String woc;
  
  static
  {
    AppMethodBeat.i(137462);
    woa = new String[] { "#", "?", "&" };
    wob = null;
    woc = null;
    kgU = Pattern.compile("songid=([0-9]+)");
    AppMethodBeat.o(137462);
  }
  
  private static int D(char paramChar)
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
  
  public static String S(f paramf)
  {
    AppMethodBeat.i(194996);
    if (paramf == null)
    {
      AppMethodBeat.o(194996);
      return null;
    }
    if (!bt.isNullOrNil(paramf.ihm))
    {
      paramf = paramf.ihm;
      AppMethodBeat.o(194996);
      return paramf;
    }
    if (!bt.isNullOrNil(paramf.iho))
    {
      paramf = paramf.iho;
      AppMethodBeat.o(194996);
      return paramf;
    }
    if (!bt.isNullOrNil(paramf.ihn))
    {
      paramf = paramf.ihn;
      AppMethodBeat.o(194996);
      return paramf;
    }
    AppMethodBeat.o(194996);
    return null;
  }
  
  private static String T(f paramf)
  {
    AppMethodBeat.i(137460);
    if (S(paramf) == null)
    {
      AppMethodBeat.o(137460);
      return null;
    }
    String str = asS(paramf.ihm);
    if (str != null)
    {
      AppMethodBeat.o(137460);
      return str;
    }
    str = asS(paramf.iho);
    if (str != null)
    {
      AppMethodBeat.o(137460);
      return str;
    }
    paramf = asS(paramf.ihn);
    AppMethodBeat.o(137460);
    return paramf;
  }
  
  public static f U(f paramf)
  {
    AppMethodBeat.i(137461);
    if (paramf != null)
    {
      paramf.ihv = asU(paramf.ihm);
      if (paramf.ihv <= 0)
      {
        paramf.ihv = asU(paramf.iho);
        if (paramf.ihv <= 0) {
          paramf.ihv = asU(paramf.ihn);
        }
      }
    }
    if ((paramf == null) || (T(paramf) == null))
    {
      AppMethodBeat.o(137461);
      return paramf;
    }
    long l = System.currentTimeMillis();
    Object localObject = T(paramf);
    if (localObject == null)
    {
      AppMethodBeat.o(137461);
      return paramf;
    }
    ad.d("MicroMsg.Music.MusicUrlUtil", "bcdUrl: %s", new Object[] { localObject });
    String str = new String(asT((String)localObject));
    int i = str.indexOf("{");
    localObject = str;
    if (i != -1) {
      localObject = str.substring(i);
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      paramf.ihv = ((JSONObject)localObject).optInt("song_ID");
      if (bt.isNullOrNil(paramf.ihi)) {
        paramf.ihi = ((JSONObject)localObject).optString("song_Name");
      }
      if (bt.isNullOrNil(paramf.ihn)) {
        paramf.ihn = ((JSONObject)localObject).optString("song_WapLiveURL");
      }
      if (bt.isNullOrNil(paramf.ihm)) {
        paramf.ihm = ((JSONObject)localObject).optString("song_WifiURL");
      }
      if (bt.isNullOrNil(paramf.ihk)) {
        paramf.ihk = ((JSONObject)localObject).optString("song_Album");
      }
      if (bt.isNullOrNil(paramf.ihj)) {
        paramf.ihj = ((JSONObject)localObject).optString("song_Singer");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", localException, "", new Object[0]);
      }
    }
    if (paramf.ihv == 0) {
      paramf.ihv = asU(wob);
    }
    ad.i("MicroMsg.Music.MusicUrlUtil", "parseBCDForMusicWrapper %s: expend: %d %d", new Object[] { paramf.ihg, Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(paramf.ihv) });
    AppMethodBeat.o(137461);
    return paramf;
  }
  
  public static String a(String paramString1, String paramString2, boolean paramBoolean, PBool paramPBool)
  {
    AppMethodBeat.i(137455);
    if ((paramBoolean) || (bt.isNullOrNil(paramString2))) {}
    for (String str = paramString1; bt.isNullOrNil(str); str = paramString2)
    {
      AppMethodBeat.o(137455);
      return str;
    }
    PString localPString = new PString();
    ad.i("MicroMsg.Music.MusicUrlUtil", "url[%s], lowBandUrl[%s], isWifi[%B]", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    paramString1 = asS(str);
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
    Object localObject2 = new String(asT(paramString));
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
      ad.d("MicroMsg.Music.MusicUrlUtil", "waplive: " + (String)localObject1 + "  wifi:" + (String)localObject2);
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
      ad.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", localException, "decodeJson", new Object[0]);
      AppMethodBeat.o(137457);
    }
  }
  
  public static boolean asR(String paramString)
  {
    AppMethodBeat.i(137453);
    if (bt.isNullOrNil(paramString))
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
      ad.w("MicroMsg.Music.MusicUrlUtil", "url %s match ? %B", new Object[] { paramString, Boolean.valueOf(bool) });
    }
    for (;;)
    {
      AppMethodBeat.o(137453);
      return bool;
      ad.i("MicroMsg.Music.MusicUrlUtil", "host is null, url is not match .qq.com");
      bool = false;
    }
  }
  
  private static String asS(String paramString)
  {
    AppMethodBeat.i(137456);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(137456);
      return null;
    }
    if ((wob != null) && (paramString.equals(wob)))
    {
      paramString = woc;
      AppMethodBeat.o(137456);
      return paramString;
    }
    Object localObject2 = "";
    String[] arrayOfString = woa;
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
      ad.w("MicroMsg.Music.MusicUrlUtil", "pIndex is %d, return", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(137456);
      return null;
    }
    localObject1 = localObject4.substring(((String)localObject3).length() + i);
    Object localObject3 = woa;
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
      wob = paramString;
      woc = (String)localObject1;
    }
    AppMethodBeat.o(137456);
    return localObject1;
  }
  
  private static byte[] asT(String paramString)
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
          int n = D(paramString.charAt(i));
          if (k >= paramString.length()) {
            break label106;
          }
          i = k + 1;
          k = D(paramString.charAt(k));
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
  
  private static int asU(String paramString)
  {
    AppMethodBeat.i(137459);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(137459);
      return 0;
    }
    paramString = kgU.matcher(paramString);
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
        ad.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", paramString, "getSongId", new Object[0]);
        AppMethodBeat.o(137459);
        return 0;
      }
    }
    AppMethodBeat.o(137459);
    return 0;
  }
  
  public static String asV(String paramString)
  {
    AppMethodBeat.i(194997);
    if (paramString == null) {}
    for (int i = -1; i < 0; i = paramString.indexOf("songmid="))
    {
      AppMethodBeat.o(194997);
      return null;
    }
    paramString = paramString.substring(i + 8);
    if ((paramString != null) && (paramString.contains("&")))
    {
      paramString = paramString.substring(0, paramString.indexOf("&"));
      AppMethodBeat.o(194997);
      return paramString;
    }
    AppMethodBeat.o(194997);
    return paramString;
  }
  
  public static String asW(String paramString)
  {
    AppMethodBeat.i(194998);
    if (paramString == null) {}
    for (int i = -1; i < 0; i = paramString.indexOf("songid="))
    {
      AppMethodBeat.o(194998);
      return null;
    }
    paramString = paramString.substring(i + 7);
    if ((paramString != null) && (paramString.contains("&")))
    {
      paramString = paramString.substring(0, paramString.indexOf("&"));
      AppMethodBeat.o(194998);
      return paramString;
    }
    AppMethodBeat.o(194998);
    return paramString;
  }
  
  public static String fT(Context paramContext)
  {
    AppMethodBeat.i(137454);
    String str = "";
    Object localObject2 = aj.getPackageName();
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
        ad.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", paramContext, "", new Object[0]);
      }
    }
    AppMethodBeat.o(137454);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.e
 * JD-Core Version:    0.7.0.1
 */