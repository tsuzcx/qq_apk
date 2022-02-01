package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.id;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private long EiE;
  Bundle EiF;
  public a EiG;
  long mStartTime;
  long ull;
  long ulm;
  
  public c()
  {
    AppMethodBeat.i(80856);
    this.EiE = 0L;
    this.ull = 0L;
    this.mStartTime = 0L;
    this.ulm = 0L;
    this.EiG = new a();
    AppMethodBeat.o(80856);
  }
  
  private String aJb(String paramString)
  {
    AppMethodBeat.i(80858);
    Matcher localMatcher = Pattern.compile("\\(.*?\\)").matcher(paramString);
    while (localMatcher.find()) {
      try
      {
        String str2 = bt.nullAsNil(localMatcher.group());
        String str1 = str2.replace("(", "").replace(")", "").replace(" ", "");
        String[] arrayOfString;
        if (str1.contains("__ALLSTAYTIME__"))
        {
          str1 = str1.replace("__ALLSTAYTIME__", String.valueOf(this.EiE / 1000L));
          arrayOfString = str1.split("\\+");
          if (arrayOfString.length == 2) {
            str1 = String.valueOf(bt.aRf(arrayOfString[0]) + bt.aRf(arrayOfString[1]));
          }
          paramString = paramString.replace(str2, str1);
        }
        else if (str2.contains("__FOREGROUNDTIME__"))
        {
          str1 = str1.replace("__FOREGROUNDTIME__", String.valueOf(this.ull / 1000L));
          arrayOfString = str1.split("\\+");
          if (arrayOfString.length == 2) {
            str1 = String.valueOf(bt.aRf(arrayOfString[0]) + bt.aRf(arrayOfString[1]));
          }
          paramString = paramString.replace(str2, str1);
        }
      }
      catch (NumberFormatException paramString)
      {
        ad.i("MicroMsg.GamePageTimeReport", "matchTimeMark, err:%s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(80858);
        return null;
      }
    }
    AppMethodBeat.o(80858);
    return paramString;
  }
  
  public static void aY(Bundle paramBundle)
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
      paramBundle = new id();
    }
    catch (JSONException paramBundle)
    {
      AppMethodBeat.o(80857);
      return;
    }
    paramBundle.duG.EN = 4;
    paramBundle.duG.param = localJSONObject.toString();
    a.IbL.l(paramBundle);
    AppMethodBeat.o(80857);
  }
  
  protected void ag(Bundle paramBundle) {}
  
  public final class a
  {
    public a() {}
    
    public final void CA()
    {
      AppMethodBeat.i(80852);
      c.this.mStartTime = System.currentTimeMillis();
      c.this.ulm = System.currentTimeMillis();
      AppMethodBeat.o(80852);
    }
    
    public final void aZ(Bundle paramBundle)
    {
      AppMethodBeat.i(80853);
      c.this.EiF = paramBundle;
      ad.i("MicroMsg.GamePageTimeReport", "setGamePageReportData");
      if ((paramBundle != null) && (paramBundle.getBoolean("game_page_report_time_begin")))
      {
        c.this.ull = 0L;
        c.this.mStartTime = System.currentTimeMillis();
        c.this.ulm = System.currentTimeMillis();
      }
      AppMethodBeat.o(80853);
    }
    
    public final void eUn()
    {
      c.this.EiF = null;
      c.this.mStartTime = 0L;
      c.this.ull = 0L;
      c.this.mStartTime = 0L;
      c.this.ulm = 0L;
    }
    
    public final void onPause()
    {
      AppMethodBeat.i(80855);
      if (c.this.ulm != 0L) {
        c.this.ull += System.currentTimeMillis() - c.this.ulm;
      }
      AppMethodBeat.o(80855);
    }
    
    public final void onResume()
    {
      AppMethodBeat.i(80854);
      if (c.this.ulm != 0L) {
        c.this.ulm = System.currentTimeMillis();
      }
      AppMethodBeat.o(80854);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.c
 * JD-Core Version:    0.7.0.1
 */