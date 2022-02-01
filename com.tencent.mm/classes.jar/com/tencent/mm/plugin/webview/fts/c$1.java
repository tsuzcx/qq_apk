package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class c$1
  implements l
{
  c$1(c paramc) {}
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(77886);
    final c.f localf = (c.f)paramk.trv;
    ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "historySearchResultListener ret %d, webViewId %s", new Object[] { Integer.valueOf(paramk.bZU), Integer.valueOf(localf.DKn) });
    final JSONObject localJSONObject1;
    JSONArray localJSONArray1;
    JSONArray localJSONArray2;
    if (paramk.bZU == 0)
    {
      localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("ret", 0);
        localJSONArray1 = new JSONArray();
        localJSONArray2 = new JSONArray();
        paramk = paramk.tvl.iterator();
        while (paramk.hasNext())
        {
          m localm = (m)paramk.next();
          if (localm.content != null)
          {
            JSONObject localJSONObject2 = new JSONObject(localm.content);
            localJSONObject2.put("timeStamp", localm.timestamp);
            localJSONArray2.put(localJSONObject2);
            continue;
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(77885);
                if (localf.DKn != 0)
                {
                  ad.i("MicroMsg.WebSearch.FTSWebViewLogic", "historySearchResultListener callback， id %d", new Object[] { Integer.valueOf(localf.DKn) });
                  com.tencent.mm.plugin.webview.ui.tools.jsapi.f localf = g.XN(localf.DKn);
                  String str = localJSONObject1.toString();
                  Bundle localBundle = new Bundle();
                  localBundle.putString("data", str);
                  try
                  {
                    if (localf.DNO != null)
                    {
                      localf.DNO.g(143, localBundle);
                      AppMethodBeat.o(77885);
                      return;
                    }
                    ad.i("MicroMsg.MsgHandler", "callbacker is null");
                    AppMethodBeat.o(77885);
                    return;
                  }
                  catch (RemoteException localRemoteException)
                  {
                    ad.w("MicroMsg.MsgHandler", "onGetSearchHistory exception" + localRemoteException.getMessage());
                  }
                }
                AppMethodBeat.o(77885);
              }
            });
          }
        }
      }
      catch (Exception paramk) {}
    }
    for (;;)
    {
      AppMethodBeat.o(77886);
      return;
      paramk = new JSONObject();
      paramk.put("items", localJSONArray2);
      localJSONArray1.put(paramk);
      localJSONObject1.put("data", localJSONArray1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.1
 * JD-Core Version:    0.7.0.1
 */