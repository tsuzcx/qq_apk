package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class b$1$1
  implements Runnable
{
  b$1$1(b.1 param1, b.f paramf, j paramj, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(5672);
    JSONObject localJSONObject1;
    JSONArray localJSONArray;
    if (this.uOJ.uOY != 0)
    {
      ab.i("MicroMsg.WebSearch.FTSWebViewLogic", "historySearchResultListener callback， id %d", new Object[] { Integer.valueOf(this.uOJ.uOY) });
      g localg = h.KW(this.uOJ.uOY);
      localObject2 = this.uOK;
      try
      {
        ab.i("MicroMsg.MsgHandler", "onGetSearchHistory %s", new Object[] { ((ArrayList)localObject2).toString() });
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("ret", 0);
        localObject1 = new JSONArray();
        localJSONArray = new JSONArray();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("word", str);
          localJSONObject2.put("id", System.currentTimeMillis());
          localJSONObject2.put("timeStamp", System.currentTimeMillis());
          localJSONArray.put(localJSONObject2);
        }
        AppMethodBeat.o(5672);
      }
      catch (JSONException localJSONException)
      {
        ab.printErrStackTrace("MicroMsg.MsgHandler", localJSONException, "", new Object[0]);
      }
    }
    else
    {
      return;
    }
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("items", localJSONArray);
    ((JSONArray)localObject1).put(localObject2);
    localJSONObject1.put("data", localObject1);
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("data", localJSONObject1.toString());
    try
    {
      if (localJSONException.uWu != null)
      {
        localJSONException.uWu.e(143, (Bundle)localObject1);
        AppMethodBeat.o(5672);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      ab.w("MicroMsg.MsgHandler", "onGetSearchHistory exception" + localRemoteException.getMessage());
      AppMethodBeat.o(5672);
      return;
    }
    ab.i("MicroMsg.MsgHandler", "callbacker is null");
    AppMethodBeat.o(5672);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.1.1
 * JD-Core Version:    0.7.0.1
 */