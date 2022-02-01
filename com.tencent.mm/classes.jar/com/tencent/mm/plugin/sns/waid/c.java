package com.tencent.mm.plugin.sns.waid;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class c
{
  public static void a(WaidProvider.a parama, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(198646);
    if (!b.efn())
    {
      ad.e("ad.waid.WaidReporter", "reportPkg isWxEnvInitDone==false");
      AppMethodBeat.o(198646);
      return;
    }
    if ((parama != null) && (parama.AEw != null) && (parama.AEw.length > 1)) {}
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (i < parama.AEw.length)
        {
          localStringBuilder.append(parama.AEw[i]);
          if (i == parama.AEw.length - 1) {
            break label232;
          }
          localStringBuilder.append("|");
          break label232;
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("rawCallingPkg", parama.AEv);
        localJSONObject.put("callingPkgType", parama.AEx);
        localJSONObject.put("pkgsFromUid", localStringBuilder.toString());
        localJSONObject.put("queryPkg", paramString);
        parama = localJSONObject.toString();
        ad.i("ad.waid.WaidReporter", "reportPkg data=".concat(String.valueOf(parama)));
        g.yhR.f(18666, new Object[] { Integer.valueOf(1002), parama });
        AppMethodBeat.o(198646);
        return;
      }
      catch (Throwable parama)
      {
        ad.e("ad.waid.WaidReporter", "reportPkg exp=" + Log.getStackTraceString(parama));
      }
      AppMethodBeat.o(198646);
      return;
      label232:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.c
 * JD-Core Version:    0.7.0.1
 */