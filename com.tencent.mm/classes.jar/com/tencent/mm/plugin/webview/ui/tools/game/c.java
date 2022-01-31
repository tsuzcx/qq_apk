package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.mm.h.a.gr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  long kXo = 0L;
  long kXp = 0L;
  long mStartTime = 0L;
  private long rwh = 0L;
  Bundle rwi;
  public c.a rwj = new c.a(this);
  
  private String TK(String paramString)
  {
    Matcher localMatcher = Pattern.compile("\\(.*?\\)").matcher(paramString);
    String str1;
    for (;;)
    {
      str1 = paramString;
      if (localMatcher.find()) {
        try
        {
          String str2 = bk.pm(localMatcher.group());
          str1 = str2.replace("(", "").replace(")", "").replace(" ", "");
          String[] arrayOfString;
          if (str1.contains("__ALLSTAYTIME__"))
          {
            str1 = str1.replace("__ALLSTAYTIME__", String.valueOf(this.rwh / 1000L));
            arrayOfString = str1.split("\\+");
            if (arrayOfString.length == 2) {
              str1 = String.valueOf(Long.parseLong(arrayOfString[0]) + Long.parseLong(arrayOfString[1]));
            }
            paramString = paramString.replace(str2, str1);
          }
          else if (str2.contains("__FOREGROUNDTIME__"))
          {
            str1 = str1.replace("__FOREGROUNDTIME__", String.valueOf(this.kXo / 1000L));
            arrayOfString = str1.split("\\+");
            if (arrayOfString.length == 2) {
              str1 = String.valueOf(Long.parseLong(arrayOfString[0]) + Long.parseLong(arrayOfString[1]));
            }
            paramString = paramString.replace(str2, str1);
          }
        }
        catch (NumberFormatException paramString)
        {
          y.i("MicroMsg.GamePageTimeReport", "matchTimeMark, err:%s", new Object[] { paramString.getMessage() });
          str1 = null;
        }
      }
    }
    return str1;
  }
  
  public static void ad(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    Object localObject;
    do
    {
      return;
      localObject = paramBundle.keySet();
    } while (localObject == null);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localJSONObject.put(str, paramBundle.get(str));
      }
      paramBundle = new gr();
    }
    catch (JSONException paramBundle)
    {
      return;
    }
    paramBundle.bOv.uC = 4;
    paramBundle.bOv.bOx = localJSONObject.toString();
    a.udP.m(paramBundle);
  }
  
  public void A(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.c
 * JD-Core Version:    0.7.0.1
 */