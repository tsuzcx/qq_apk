package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hp;
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
  private long BmN;
  Bundle BmO;
  public a BmP;
  long mStartTime;
  long seU;
  long seV;
  
  public c()
  {
    AppMethodBeat.i(80856);
    this.BmN = 0L;
    this.seU = 0L;
    this.mStartTime = 0L;
    this.seV = 0L;
    this.BmP = new a();
    AppMethodBeat.o(80856);
  }
  
  public static void aP(Bundle paramBundle)
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
      paramBundle = new hp();
    }
    catch (JSONException paramBundle)
    {
      AppMethodBeat.o(80857);
      return;
    }
    paramBundle.dll.BX = 4;
    paramBundle.dll.dln = localJSONObject.toString();
    a.ESL.l(paramBundle);
    AppMethodBeat.o(80857);
  }
  
  private String ayj(String paramString)
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
          str1 = str1.replace("__ALLSTAYTIME__", String.valueOf(this.BmN / 1000L));
          arrayOfString = str1.split("\\+");
          if (arrayOfString.length == 2) {
            str1 = String.valueOf(bt.aGi(arrayOfString[0]) + bt.aGi(arrayOfString[1]));
          }
          paramString = paramString.replace(str2, str1);
        }
        else if (str2.contains("__FOREGROUNDTIME__"))
        {
          str1 = str1.replace("__FOREGROUNDTIME__", String.valueOf(this.seU / 1000L));
          arrayOfString = str1.split("\\+");
          if (arrayOfString.length == 2) {
            str1 = String.valueOf(bt.aGi(arrayOfString[0]) + bt.aGi(arrayOfString[1]));
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
  
  protected void aa(Bundle paramBundle) {}
  
  public final class a
  {
    public a() {}
    
    public final void Bx()
    {
      AppMethodBeat.i(80852);
      c.this.mStartTime = System.currentTimeMillis();
      c.this.seV = System.currentTimeMillis();
      AppMethodBeat.o(80852);
    }
    
    public final void aQ(Bundle paramBundle)
    {
      AppMethodBeat.i(80853);
      c.this.BmO = paramBundle;
      ad.i("MicroMsg.GamePageTimeReport", "setGamePageReportData");
      if ((paramBundle != null) && (paramBundle.getBoolean("game_page_report_time_begin")))
      {
        c.this.seU = 0L;
        c.this.mStartTime = System.currentTimeMillis();
        c.this.seV = System.currentTimeMillis();
      }
      AppMethodBeat.o(80853);
    }
    
    public final void epX()
    {
      c.this.BmO = null;
      c.this.mStartTime = 0L;
      c.this.seU = 0L;
      c.this.mStartTime = 0L;
      c.this.seV = 0L;
    }
    
    public final void onPause()
    {
      AppMethodBeat.i(80855);
      if (c.this.seV != 0L) {
        c.this.seU += System.currentTimeMillis() - c.this.seV;
      }
      AppMethodBeat.o(80855);
    }
    
    public final void onResume()
    {
      AppMethodBeat.i(80854);
      if (c.this.seV != 0L) {
        c.this.seV = System.currentTimeMillis();
      }
      AppMethodBeat.o(80854);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.c
 * JD-Core Version:    0.7.0.1
 */