package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private long CEU;
  Bundle CEV;
  public a CEW;
  long mStartTime;
  long tmN;
  long tmO;
  
  public c()
  {
    AppMethodBeat.i(80856);
    this.CEU = 0L;
    this.tmN = 0L;
    this.mStartTime = 0L;
    this.tmO = 0L;
    this.CEW = new a();
    AppMethodBeat.o(80856);
  }
  
  private String aDA(String paramString)
  {
    AppMethodBeat.i(80858);
    Matcher localMatcher = Pattern.compile("\\(.*?\\)").matcher(paramString);
    while (localMatcher.find()) {
      try
      {
        String str2 = bs.nullAsNil(localMatcher.group());
        String str1 = str2.replace("(", "").replace(")", "").replace(" ", "");
        String[] arrayOfString;
        if (str1.contains("__ALLSTAYTIME__"))
        {
          str1 = str1.replace("__ALLSTAYTIME__", String.valueOf(this.CEU / 1000L));
          arrayOfString = str1.split("\\+");
          if (arrayOfString.length == 2) {
            str1 = String.valueOf(bs.aLz(arrayOfString[0]) + bs.aLz(arrayOfString[1]));
          }
          paramString = paramString.replace(str2, str1);
        }
        else if (str2.contains("__FOREGROUNDTIME__"))
        {
          str1 = str1.replace("__FOREGROUNDTIME__", String.valueOf(this.tmN / 1000L));
          arrayOfString = str1.split("\\+");
          if (arrayOfString.length == 2) {
            str1 = String.valueOf(bs.aLz(arrayOfString[0]) + bs.aLz(arrayOfString[1]));
          }
          paramString = paramString.replace(str2, str1);
        }
      }
      catch (NumberFormatException paramString)
      {
        ac.i("MicroMsg.GamePageTimeReport", "matchTimeMark, err:%s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(80858);
        return null;
      }
    }
    AppMethodBeat.o(80858);
    return paramString;
  }
  
  public static void aT(Bundle paramBundle)
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
      paramBundle = new hw();
    }
    catch (JSONException paramBundle)
    {
      AppMethodBeat.o(80857);
      return;
    }
    paramBundle.diU.CW = 4;
    paramBundle.diU.param = localJSONObject.toString();
    a.GpY.l(paramBundle);
    AppMethodBeat.o(80857);
  }
  
  protected void ad(Bundle paramBundle) {}
  
  public final class a
  {
    public a() {}
    
    public final void Bb()
    {
      AppMethodBeat.i(80852);
      c.this.mStartTime = System.currentTimeMillis();
      c.this.tmO = System.currentTimeMillis();
      AppMethodBeat.o(80852);
    }
    
    public final void aU(Bundle paramBundle)
    {
      AppMethodBeat.i(80853);
      c.this.CEV = paramBundle;
      ac.i("MicroMsg.GamePageTimeReport", "setGamePageReportData");
      if ((paramBundle != null) && (paramBundle.getBoolean("game_page_report_time_begin")))
      {
        c.this.tmN = 0L;
        c.this.mStartTime = System.currentTimeMillis();
        c.this.tmO = System.currentTimeMillis();
      }
      AppMethodBeat.o(80853);
    }
    
    public final void eFr()
    {
      c.this.CEV = null;
      c.this.mStartTime = 0L;
      c.this.tmN = 0L;
      c.this.mStartTime = 0L;
      c.this.tmO = 0L;
    }
    
    public final void onPause()
    {
      AppMethodBeat.i(80855);
      if (c.this.tmO != 0L) {
        c.this.tmN += System.currentTimeMillis() - c.this.tmO;
      }
      AppMethodBeat.o(80855);
    }
    
    public final void onResume()
    {
      AppMethodBeat.i(80854);
      if (c.this.tmO != 0L) {
        c.this.tmO = System.currentTimeMillis();
      }
      AppMethodBeat.o(80854);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.c
 * JD-Core Version:    0.7.0.1
 */