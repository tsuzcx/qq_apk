package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.y;
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
    Object localObject1;
    JSONArray localJSONArray;
    if (this.qZc.qZt != 0)
    {
      y.i("MicroMsg.FTS.FTSWebViewLogic", "historySearchResultListener callback， id %d", new Object[] { Integer.valueOf(this.qZc.qZt) });
      g localg = h.Db(this.qZc.qZt);
      localObject1 = this.ktw.ktu.bVk;
      localObject3 = this.qZd;
      try
      {
        y.i("MicroMsg.MsgHandler", "onGetSearchHistory %s", new Object[] { ((ArrayList)localObject3).toString() });
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("ret", 0);
        localObject2 = new JSONArray();
        localJSONArray = new JSONArray();
        localObject3 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("word", str);
          localJSONObject.put("id", System.currentTimeMillis());
          localJSONObject.put("timeStamp", System.currentTimeMillis());
          localJSONArray.put(localJSONObject);
          continue;
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        y.printErrStackTrace("MicroMsg.MsgHandler", localJSONException, "", new Object[0]);
      }
    }
    Object localObject3 = new JSONObject();
    ((JSONObject)localObject3).put("items", localJSONArray);
    ((JSONArray)localObject2).put(localObject3);
    ((JSONObject)localObject1).put("data", localObject2);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("data", ((JSONObject)localObject1).toString());
    try
    {
      if (localJSONException.rgh != null)
      {
        localJSONException.rgh.b(143, (Bundle)localObject2);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      y.w("MicroMsg.MsgHandler", "onGetSearchHistory exception" + localRemoteException.getMessage());
      return;
    }
    y.i("MicroMsg.MsgHandler", "callbacker is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.1.1
 * JD-Core Version:    0.7.0.1
 */