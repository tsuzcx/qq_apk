package com.tencent.mm.plugin.music.h;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class e
{
  private static final Pattern hpo;
  private static final String[] pcj;
  private static String pck;
  private static String pcl;
  
  static
  {
    AppMethodBeat.i(137709);
    pcj = new String[] { "#", "?", "&" };
    pck = null;
    pcl = null;
    hpo = Pattern.compile("songid=([0-9]+)");
    AppMethodBeat.o(137709);
  }
  
  private static String O(com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(137707);
    if (parame != null) {
      if (!bo.isNullOrNil(parame.fKp)) {
        str = parame.fKp;
      }
    }
    while (str == null)
    {
      AppMethodBeat.o(137707);
      return null;
      if (!bo.isNullOrNil(parame.fKr)) {
        str = parame.fKr;
      } else if (!bo.isNullOrNil(parame.fKq)) {
        str = parame.fKq;
      } else {
        str = null;
      }
    }
    String str = VK(parame.fKp);
    if (str != null)
    {
      AppMethodBeat.o(137707);
      return str;
    }
    str = VK(parame.fKr);
    if (str != null)
    {
      AppMethodBeat.o(137707);
      return str;
    }
    parame = VK(parame.fKq);
    AppMethodBeat.o(137707);
    return parame;
  }
  
  public static com.tencent.mm.aw.e P(com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(137708);
    if (parame != null)
    {
      parame.fKy = VM(parame.fKp);
      if (parame.fKy <= 0)
      {
        parame.fKy = VM(parame.fKr);
        if (parame.fKy <= 0) {
          parame.fKy = VM(parame.fKq);
        }
      }
    }
    if ((parame == null) || (O(parame) == null))
    {
      AppMethodBeat.o(137708);
      return parame;
    }
    long l = System.currentTimeMillis();
    Object localObject = O(parame);
    if (localObject == null)
    {
      AppMethodBeat.o(137708);
      return parame;
    }
    ab.d("MicroMsg.Music.MusicUrlUtil", "bcdUrl: %s", new Object[] { localObject });
    String str = new String(VL((String)localObject));
    int i = str.indexOf("{");
    localObject = str;
    if (i != -1) {
      localObject = str.substring(i);
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      parame.fKy = ((JSONObject)localObject).optInt("song_ID");
      if (bo.isNullOrNil(parame.fKl)) {
        parame.fKl = ((JSONObject)localObject).optString("song_Name");
      }
      if (bo.isNullOrNil(parame.fKq)) {
        parame.fKq = ((JSONObject)localObject).optString("song_WapLiveURL");
      }
      if (bo.isNullOrNil(parame.fKp)) {
        parame.fKp = ((JSONObject)localObject).optString("song_WifiURL");
      }
      if (bo.isNullOrNil(parame.fKn)) {
        parame.fKn = ((JSONObject)localObject).optString("song_Album");
      }
      if (bo.isNullOrNil(parame.fKm)) {
        parame.fKm = ((JSONObject)localObject).optString("song_Singer");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", localException, "", new Object[0]);
      }
    }
    if (parame.fKy == 0) {
      parame.fKy = VM(pck);
    }
    ab.i("MicroMsg.Music.MusicUrlUtil", "parseBCDForMusicWrapper %s: expend: %d %d", new Object[] { parame.fKj, Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(parame.fKy) });
    AppMethodBeat.o(137708);
    return parame;
  }
  
  public static boolean VJ(String paramString)
  {
    AppMethodBeat.i(137700);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(137700);
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
      ab.w("MicroMsg.Music.MusicUrlUtil", "url %s match ? %B", new Object[] { paramString, Boolean.valueOf(bool) });
    }
    for (;;)
    {
      AppMethodBeat.o(137700);
      return bool;
      ab.i("MicroMsg.Music.MusicUrlUtil", "host is null, url is not match .qq.com");
      bool = false;
    }
  }
  
  private static String VK(String paramString)
  {
    AppMethodBeat.i(137703);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(137703);
      return null;
    }
    if ((pck != null) && (paramString.equals(pck)))
    {
      paramString = pcl;
      AppMethodBeat.o(137703);
      return paramString;
    }
    Object localObject2 = "";
    String[] arrayOfString = pcj;
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
      AppMethodBeat.o(137703);
      return null;
    }
    i = localObject4.indexOf((String)localObject3);
    if (i < 0)
    {
      ab.w("MicroMsg.Music.MusicUrlUtil", "pIndex is %d, return", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(137703);
      return null;
    }
    localObject1 = localObject4.substring(((String)localObject3).length() + i);
    Object localObject3 = pcj;
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
      pck = paramString;
      pcl = (String)localObject1;
    }
    AppMethodBeat.o(137703);
    return localObject1;
  }
  
  private static byte[] VL(String paramString)
  {
    AppMethodBeat.i(137705);
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
          int n = z(paramString.charAt(i));
          if (k >= paramString.length()) {
            break label103;
          }
          i = k + 1;
          k = z(paramString.charAt(k));
          arrayOfByte[j] = ((byte)(k | n << 4));
          j += 1;
          continue;
        }
        AppMethodBeat.o(137705);
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(137705);
        return null;
      }
      return arrayOfByte;
      label103:
      int m = 0;
      i = k;
      int k = m;
    }
  }
  
  private static int VM(String paramString)
  {
    AppMethodBeat.i(137706);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(137706);
      return 0;
    }
    paramString = hpo.matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group(1);
      try
      {
        int i = Integer.valueOf(paramString).intValue();
        AppMethodBeat.o(137706);
        return i;
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", paramString, "getSongId", new Object[0]);
        AppMethodBeat.o(137706);
        return 0;
      }
    }
    AppMethodBeat.o(137706);
    return 0;
  }
  
  public static String a(String paramString1, String paramString2, boolean paramBoolean, PBool paramPBool)
  {
    AppMethodBeat.i(137702);
    if ((paramBoolean) || (bo.isNullOrNil(paramString2))) {}
    for (String str = paramString1; bo.isNullOrNil(str); str = paramString2)
    {
      AppMethodBeat.o(137702);
      return str;
    }
    PString localPString = new PString();
    ab.i("MicroMsg.Music.MusicUrlUtil", "url[%s], lowBandUrl[%s], isWifi[%B]", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    paramString1 = VK(str);
    if (paramString1 != null) {
      if (a(paramString1, paramBoolean, localPString)) {
        paramPBool.value = paramBoolean;
      }
    }
    for (;;)
    {
      paramString1 = localPString.value;
      AppMethodBeat.o(137702);
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
    AppMethodBeat.i(137704);
    Object localObject2 = new String(VL(paramString));
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
      ab.d("MicroMsg.Music.MusicUrlUtil", "waplive: " + (String)localObject1 + "  wifi:" + (String)localObject2);
      if (paramBoolean) {
        localObject1 = localObject2;
      }
      for (;;)
      {
        paramPString.value = ((String)localObject1);
        AppMethodBeat.o(137704);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      paramPString.value = paramString;
      ab.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", localException, "decodeJson", new Object[0]);
      AppMethodBeat.o(137704);
    }
  }
  
  public static String eH(Context paramContext)
  {
    AppMethodBeat.i(137701);
    String str = "";
    Object localObject2 = ah.getPackageName();
    if (localObject2 == null)
    {
      AppMethodBeat.o(137701);
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
        ab.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", paramContext, "", new Object[0]);
      }
    }
    AppMethodBeat.o(137701);
    return localObject1;
  }
  
  private static int z(char paramChar)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.e
 * JD-Core Version:    0.7.0.1
 */