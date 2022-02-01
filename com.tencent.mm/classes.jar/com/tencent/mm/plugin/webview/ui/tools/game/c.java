package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.it;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private long Jqf;
  Bundle Jqg;
  public a Jqh;
  long mStartTime;
  long xOJ;
  long xyY;
  
  public c()
  {
    AppMethodBeat.i(80856);
    this.Jqf = 0L;
    this.xyY = 0L;
    this.mStartTime = 0L;
    this.xOJ = 0L;
    this.Jqh = new a();
    AppMethodBeat.o(80856);
  }
  
  private String baI(String paramString)
  {
    AppMethodBeat.i(80858);
    Matcher localMatcher = Pattern.compile("\\(.*?\\)").matcher(paramString);
    while (localMatcher.find()) {
      try
      {
        String str2 = Util.nullAsNil(localMatcher.group());
        String str1 = str2.replace("(", "").replace(")", "").replace(" ", "");
        String[] arrayOfString;
        if (str1.contains("__ALLSTAYTIME__"))
        {
          str1 = str1.replace("__ALLSTAYTIME__", String.valueOf(this.Jqf / 1000L));
          arrayOfString = str1.split("\\+");
          if (arrayOfString.length == 2) {
            str1 = String.valueOf(Util.safeParseLong(arrayOfString[0]) + Util.safeParseLong(arrayOfString[1]));
          }
          paramString = paramString.replace(str2, str1);
        }
        else if (str2.contains("__FOREGROUNDTIME__"))
        {
          str1 = str1.replace("__FOREGROUNDTIME__", String.valueOf(this.xyY / 1000L));
          arrayOfString = str1.split("\\+");
          if (arrayOfString.length == 2) {
            str1 = String.valueOf(Util.safeParseLong(arrayOfString[0]) + Util.safeParseLong(arrayOfString[1]));
          }
          paramString = paramString.replace(str2, str1);
        }
      }
      catch (NumberFormatException paramString)
      {
        Log.i("MicroMsg.GamePageTimeReport", "matchTimeMark, err:%s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(80858);
        return null;
      }
    }
    AppMethodBeat.o(80858);
    return paramString;
  }
  
  public static void bl(Bundle paramBundle)
  {
    AppMethodBeat.i(80857);
    if (paramBundle == null)
    {
      AppMethodBeat.o(80857);
      return;
    }
    Object localObject = paramBundle.keySet();
    if (localObject == null)
    {
      AppMethodBeat.o(80857);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localJSONObject.put(str, paramBundle.get(str));
      }
      paramBundle = new it();
    }
    catch (JSONException paramBundle)
    {
      AppMethodBeat.o(80857);
      return;
    }
    paramBundle.dNs.EX = 4;
    paramBundle.dNs.param = localJSONObject.toString();
    EventCenter.instance.publish(paramBundle);
    AppMethodBeat.o(80857);
  }
  
  protected void an(Bundle paramBundle) {}
  
  public final class a
  {
    public a() {}
    
    public final void LZ()
    {
      AppMethodBeat.i(80852);
      c.this.mStartTime = System.currentTimeMillis();
      c.this.xOJ = System.currentTimeMillis();
      AppMethodBeat.o(80852);
    }
    
    public final void bm(Bundle paramBundle)
    {
      AppMethodBeat.i(80853);
      c.this.Jqg = paramBundle;
      Log.i("MicroMsg.GamePageTimeReport", "setGamePageReportData");
      if ((paramBundle != null) && (paramBundle.getBoolean("game_page_report_time_begin")))
      {
        c.this.xyY = 0L;
        c.this.mStartTime = System.currentTimeMillis();
        c.this.xOJ = System.currentTimeMillis();
      }
      AppMethodBeat.o(80853);
    }
    
    public final void ghf()
    {
      c.this.Jqg = null;
      c.this.mStartTime = 0L;
      c.this.xyY = 0L;
      c.this.mStartTime = 0L;
      c.this.xOJ = 0L;
    }
    
    public final void onPause()
    {
      AppMethodBeat.i(80855);
      if (c.this.xOJ != 0L) {
        c.this.xyY += System.currentTimeMillis() - c.this.xOJ;
      }
      AppMethodBeat.o(80855);
    }
    
    public final void onResume()
    {
      AppMethodBeat.i(80854);
      if (c.this.xOJ != 0L) {
        c.this.xOJ = System.currentTimeMillis();
      }
      AppMethodBeat.o(80854);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.c
 * JD-Core Version:    0.7.0.1
 */