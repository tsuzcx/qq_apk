package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.jj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  long CvJ;
  long CvK;
  private long QnC;
  Bundle QnD;
  public a QnE;
  long mStartTime;
  
  public d()
  {
    AppMethodBeat.i(80856);
    this.QnC = 0L;
    this.CvJ = 0L;
    this.mStartTime = 0L;
    this.CvK = 0L;
    this.QnE = new a();
    AppMethodBeat.o(80856);
  }
  
  public static void bj(Bundle paramBundle)
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
      paramBundle = new jj();
    }
    catch (JSONException paramBundle)
    {
      AppMethodBeat.o(80857);
      return;
    }
    paramBundle.fGE.Vh = 4;
    paramBundle.fGE.param = localJSONObject.toString();
    EventCenter.instance.publish(paramBundle);
    AppMethodBeat.o(80857);
  }
  
  private String bmG(String paramString)
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
          str1 = str1.replace("__ALLSTAYTIME__", String.valueOf(this.QnC / 1000L));
          arrayOfString = str1.split("\\+");
          if (arrayOfString.length == 2) {
            str1 = String.valueOf(Util.safeParseLong(arrayOfString[0]) + Util.safeParseLong(arrayOfString[1]));
          }
          paramString = paramString.replace(str2, str1);
        }
        else if (str2.contains("__FOREGROUNDTIME__"))
        {
          str1 = str1.replace("__FOREGROUNDTIME__", String.valueOf(this.CvJ / 1000L));
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
  
  protected void ah(Bundle paramBundle) {}
  
  public final class a
  {
    public a() {}
    
    public final void OR()
    {
      AppMethodBeat.i(80852);
      d.this.mStartTime = System.currentTimeMillis();
      d.this.CvK = System.currentTimeMillis();
      AppMethodBeat.o(80852);
    }
    
    public final void bk(Bundle paramBundle)
    {
      AppMethodBeat.i(80853);
      d.this.QnD = paramBundle;
      Log.i("MicroMsg.GamePageTimeReport", "setGamePageReportData");
      if ((paramBundle != null) && (paramBundle.getBoolean("game_page_report_time_begin")))
      {
        d.this.CvJ = 0L;
        d.this.mStartTime = System.currentTimeMillis();
        d.this.CvK = System.currentTimeMillis();
      }
      AppMethodBeat.o(80853);
    }
    
    public final void hay()
    {
      d.this.QnD = null;
      d.this.mStartTime = 0L;
      d.this.CvJ = 0L;
      d.this.mStartTime = 0L;
      d.this.CvK = 0L;
    }
    
    public final void onPause()
    {
      AppMethodBeat.i(80855);
      if (d.this.CvK != 0L) {
        d.this.CvJ += System.currentTimeMillis() - d.this.CvK;
      }
      AppMethodBeat.o(80855);
    }
    
    public final void onResume()
    {
      AppMethodBeat.i(80854);
      if (d.this.CvK != 0L) {
        d.this.CvK = System.currentTimeMillis();
      }
      AppMethodBeat.o(80854);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.d
 * JD-Core Version:    0.7.0.1
 */