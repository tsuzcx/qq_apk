package com.tencent.mm.plugin.sns.waid;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class c
{
  public static void a(WaidProvider.a parama, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(220197);
    if (!b.eiV())
    {
      ae.e("ad.waid.WaidReporter", "reportPkg isWxEnvInitDone==false");
      AppMethodBeat.o(220197);
      return;
    }
    if ((parama != null) && (parama.AVZ != null) && (parama.AVZ.length > 1)) {}
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (i < parama.AVZ.length)
        {
          localStringBuilder.append(parama.AVZ[i]);
          if (i == parama.AVZ.length - 1) {
            break label235;
          }
          localStringBuilder.append("|");
          break label235;
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("rawCallPkg", parama.AVY);
        localJSONObject.put("callPkgType", parama.AWa);
        localJSONObject.put("pkgsFromUid", localStringBuilder.toString());
        localJSONObject.put("queryPkg", paramString);
        parama = aCF(localJSONObject.toString());
        ae.i("ad.waid.WaidReporter", "reportPkg data=".concat(String.valueOf(parama)));
        g.yxI.f(18666, new Object[] { Integer.valueOf(2002), parama });
        AppMethodBeat.o(220197);
        return;
      }
      catch (Throwable parama)
      {
        ae.e("ad.waid.WaidReporter", "reportPkg exp=" + Log.getStackTraceString(parama));
      }
      AppMethodBeat.o(220197);
      return;
      label235:
      i += 1;
    }
  }
  
  static String aCF(String paramString)
  {
    AppMethodBeat.i(220198);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(220198);
      return "";
    }
    paramString = paramString.replace(",", ";");
    AppMethodBeat.o(220198);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.c
 * JD-Core Version:    0.7.0.1
 */