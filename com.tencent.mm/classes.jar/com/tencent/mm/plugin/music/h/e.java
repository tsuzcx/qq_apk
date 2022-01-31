package com.tencent.mm.plugin.music.h;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class e
{
  private static final Pattern fsW = Pattern.compile("songid=([0-9]+)");
  private static final String[] mCs = { "#", "?", "&" };
  private static String mCt = null;
  private static String mCu = null;
  
  public static boolean JK(String paramString)
  {
    if (bk.bl(paramString)) {
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
      y.w("MicroMsg.Music.MusicUrlUtil", "url %s match ? %B", new Object[] { paramString, Boolean.valueOf(bool) });
    }
    for (;;)
    {
      return bool;
      y.i("MicroMsg.Music.MusicUrlUtil", "host is null, url is not match .qq.com");
      bool = false;
    }
  }
  
  private static String JL(String paramString)
  {
    Object localObject5 = null;
    Object localObject2;
    if (bk.bl(paramString)) {
      localObject2 = localObject5;
    }
    Object localObject1;
    do
    {
      Object localObject4;
      do
      {
        return localObject2;
        if ((mCt != null) && (paramString.equals(mCt))) {
          return mCu;
        }
        localObject2 = "";
        String[] arrayOfString = mCs;
        j = arrayOfString.length;
        i = 0;
        localObject1 = null;
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
        localObject2 = localObject5;
      } while (localObject4 == null);
      int i = localObject4.indexOf((String)localObject3);
      if (i < 0)
      {
        y.w("MicroMsg.Music.MusicUrlUtil", "pIndex is %d, return", new Object[] { Integer.valueOf(i) });
        return null;
      }
      localObject1 = localObject4.substring(((String)localObject3).length() + i);
      Object localObject3 = mCs;
      int j = localObject3.length;
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
      localObject2 = localObject1;
    } while (localObject1 == null);
    mCt = paramString;
    mCu = (String)localObject1;
    return localObject1;
  }
  
  private static byte[] JM(String paramString)
  {
    byte[] arrayOfByte2 = new byte[paramString.length() / 2 + paramString.length() % 2];
    int i = 0;
    int j = 0;
    byte[] arrayOfByte1 = arrayOfByte2;
    for (;;)
    {
      try
      {
        if (i < paramString.length())
        {
          k = i + 1;
          int n = k(paramString.charAt(i));
          if (k >= paramString.length()) {
            break label93;
          }
          i = k + 1;
          k = k(paramString.charAt(k));
          arrayOfByte2[j] = ((byte)(k | n << 4));
          j += 1;
        }
      }
      catch (Exception paramString)
      {
        arrayOfByte1 = null;
      }
      return arrayOfByte1;
      label93:
      int m = 0;
      i = k;
      int k = m;
    }
  }
  
  private static int JN(String paramString)
  {
    if (bk.bl(paramString)) {}
    do
    {
      return 0;
      paramString = fsW.matcher(paramString);
    } while (!paramString.find());
    paramString = paramString.group(1);
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", paramString, "getSongId", new Object[0]);
    }
    return 0;
  }
  
  private static String M(com.tencent.mm.av.e parame)
  {
    String str2 = null;
    String str1;
    if (parame != null) {
      if (!bk.bl(parame.euD))
      {
        str1 = parame.euD;
        if (str1 != null) {
          break label70;
        }
        str1 = str2;
      }
    }
    label70:
    do
    {
      do
      {
        return str1;
        if (!bk.bl(parame.euF))
        {
          str1 = parame.euF;
          break;
        }
        if (!bk.bl(parame.euE))
        {
          str1 = parame.euE;
          break;
        }
        str1 = null;
        break;
        str2 = JL(parame.euD);
        str1 = str2;
      } while (str2 != null);
      str2 = JL(parame.euF);
      str1 = str2;
    } while (str2 != null);
    return JL(parame.euE);
  }
  
  public static com.tencent.mm.av.e N(com.tencent.mm.av.e parame)
  {
    if (parame != null)
    {
      parame.euM = JN(parame.euD);
      if (parame.euM <= 0)
      {
        parame.euM = JN(parame.euF);
        if (parame.euM <= 0) {
          parame.euM = JN(parame.euE);
        }
      }
    }
    if ((parame == null) || (M(parame) == null)) {}
    long l;
    do
    {
      return parame;
      l = System.currentTimeMillis();
      localObject = M(parame);
    } while (localObject == null);
    y.d("MicroMsg.Music.MusicUrlUtil", "bcdUrl: %s", new Object[] { localObject });
    String str = new String(JM((String)localObject));
    int i = str.indexOf("{");
    Object localObject = str;
    if (i != -1) {
      localObject = str.substring(i);
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      parame.euM = ((JSONObject)localObject).optInt("song_ID");
      if (bk.bl(parame.euz)) {
        parame.euz = ((JSONObject)localObject).optString("song_Name");
      }
      if (bk.bl(parame.euE)) {
        parame.euE = ((JSONObject)localObject).optString("song_WapLiveURL");
      }
      if (bk.bl(parame.euD)) {
        parame.euD = ((JSONObject)localObject).optString("song_WifiURL");
      }
      if (bk.bl(parame.euB)) {
        parame.euB = ((JSONObject)localObject).optString("song_Album");
      }
      if (bk.bl(parame.euA)) {
        parame.euA = ((JSONObject)localObject).optString("song_Singer");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", localException, "", new Object[0]);
      }
    }
    if (parame.euM == 0) {
      parame.euM = JN(mCt);
    }
    y.i("MicroMsg.Music.MusicUrlUtil", "parseBCDForMusicWrapper %s: expend: %d %d", new Object[] { parame.eux, Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(parame.euM) });
    return parame;
  }
  
  public static String a(String paramString1, String paramString2, boolean paramBoolean, PBool paramPBool)
  {
    if ((paramBoolean) || (bk.bl(paramString2))) {}
    for (String str = paramString1; bk.bl(str); str = paramString2) {
      return str;
    }
    PString localPString = new PString();
    y.i("MicroMsg.Music.MusicUrlUtil", "url[%s], lowBandUrl[%s], isWifi[%B]", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    paramString1 = JL(str);
    if (paramString1 != null) {
      if (a(paramString1, paramBoolean, localPString)) {
        paramPBool.value = paramBoolean;
      }
    }
    for (;;)
    {
      return localPString.value;
      if (str.contains("wechat_music_url=")) {
        a(str.substring(str.indexOf("wechat_music_url=") + 17), paramBoolean, localPString);
      } else {
        localPString.value = str;
      }
    }
  }
  
  private static boolean a(String paramString, boolean paramBoolean, PString paramPString)
  {
    Object localObject2 = new String(JM(paramString));
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
      y.d("MicroMsg.Music.MusicUrlUtil", "waplive: " + (String)localObject1 + "  wifi:" + (String)localObject2);
      if (paramBoolean) {
        localObject1 = localObject2;
      }
      for (;;)
      {
        paramPString.value = ((String)localObject1);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      paramPString.value = paramString;
      y.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", localException, "decodeJson", new Object[0]);
    }
  }
  
  public static String dT(Context paramContext)
  {
    String str = "";
    Object localObject2 = ae.getPackageName();
    if (localObject2 == null) {}
    Object localObject1;
    for (;;)
    {
      return "";
      localObject1 = str;
      try
      {
        localObject2 = paramContext.getPackageManager().getPackageInfo((String)localObject2, 0);
        if (localObject2 != null)
        {
          localObject1 = str;
          paramContext = "" + ((PackageInfo)localObject2).versionName;
          localObject1 = paramContext;
          paramContext = paramContext + ((PackageInfo)localObject2).versionCode;
          return paramContext;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        y.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", paramContext, "", new Object[0]);
      }
    }
    return localObject1;
  }
  
  private static int k(char paramChar)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.e
 * JD-Core Version:    0.7.0.1
 */