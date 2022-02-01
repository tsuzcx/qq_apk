package com.tencent.mm.plugin.sns.waid;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import org.json.JSONObject;

public final class c
{
  public static void a(WaidProvider.a parama, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(204056);
    if (!b.flv())
    {
      com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidReporter", "reportPkg isWxEnvInitDone==false");
      AppMethodBeat.o(204056);
      return;
    }
    if ((parama != null) && (parama.FgS != null) && (parama.FgS.length > 1)) {}
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (i < parama.FgS.length)
        {
          localStringBuilder.append(parama.FgS[i]);
          if (i == parama.FgS.length - 1) {
            break label235;
          }
          localStringBuilder.append("|");
          break label235;
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("rawCallPkg", parama.FgR);
        localJSONObject.put("callPkgType", parama.FgT);
        localJSONObject.put("pkgsFromUid", localStringBuilder.toString());
        localJSONObject.put("queryPkg", paramString);
        parama = aRB(localJSONObject.toString());
        com.tencent.mm.sdk.platformtools.Log.i("ad.waid.WaidReporter", "reportPkg data=".concat(String.valueOf(parama)));
        h.CyF.a(18666, new Object[] { Integer.valueOf(2002), parama });
        AppMethodBeat.o(204056);
        return;
      }
      catch (Throwable parama)
      {
        com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidReporter", "reportPkg exp=" + android.util.Log.getStackTraceString(parama));
      }
      AppMethodBeat.o(204056);
      return;
      label235:
      i += 1;
    }
  }
  
  static String aRB(String paramString)
  {
    AppMethodBeat.i(204057);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(204057);
      return "";
    }
    paramString = paramString.replace(",", ";");
    AppMethodBeat.o(204057);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.c
 * JD-Core Version:    0.7.0.1
 */