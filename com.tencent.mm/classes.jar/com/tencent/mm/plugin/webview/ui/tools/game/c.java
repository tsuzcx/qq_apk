package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  long mStartTime;
  long nvq;
  long nvr;
  Bundle vmA;
  public c.a vmB;
  private long vmz;
  
  public c()
  {
    AppMethodBeat.i(8685);
    this.vmz = 0L;
    this.nvq = 0L;
    this.mStartTime = 0L;
    this.nvr = 0L;
    this.vmB = new c.a(this);
    AppMethodBeat.o(8685);
  }
  
  private String aiL(String paramString)
  {
    AppMethodBeat.i(8687);
    Matcher localMatcher = Pattern.compile("\\(.*?\\)").matcher(paramString);
    while (localMatcher.find()) {
      try
      {
        String str2 = bo.nullAsNil(localMatcher.group());
        String str1 = str2.replace("(", "").replace(")", "").replace(" ", "");
        String[] arrayOfString;
        if (str1.contains("__ALLSTAYTIME__"))
        {
          str1 = str1.replace("__ALLSTAYTIME__", String.valueOf(this.vmz / 1000L));
          arrayOfString = str1.split("\\+");
          if (arrayOfString.length == 2) {
            str1 = String.valueOf(bo.apW(arrayOfString[0]) + bo.apW(arrayOfString[1]));
          }
          paramString = paramString.replace(str2, str1);
        }
        else if (str2.contains("__FOREGROUNDTIME__"))
        {
          str1 = str1.replace("__FOREGROUNDTIME__", String.valueOf(this.nvq / 1000L));
          arrayOfString = str1.split("\\+");
          if (arrayOfString.length == 2) {
            str1 = String.valueOf(bo.apW(arrayOfString[0]) + bo.apW(arrayOfString[1]));
          }
          paramString = paramString.replace(str2, str1);
        }
      }
      catch (NumberFormatException paramString)
      {
        ab.i("MicroMsg.GamePageTimeReport", "matchTimeMark, err:%s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(8687);
        return null;
      }
    }
    AppMethodBeat.o(8687);
    return paramString;
  }
  
  public static void aw(Bundle paramBundle)
  {
    AppMethodBeat.i(8686);
    if (paramBundle == null)
    {
      AppMethodBeat.o(8686);
      return;
    }
    Object localObject = paramBundle.keySet();
    if (localObject == null)
    {
      AppMethodBeat.o(8686);
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
      paramBundle = new gv();
    }
    catch (JSONException paramBundle)
    {
      AppMethodBeat.o(8686);
      return;
    }
    paramBundle.cvM.vA = 4;
    paramBundle.cvM.cvO = localJSONObject.toString();
    a.ymk.l(paramBundle);
    AppMethodBeat.o(8686);
  }
  
  protected void R(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.c
 * JD-Core Version:    0.7.0.1
 */