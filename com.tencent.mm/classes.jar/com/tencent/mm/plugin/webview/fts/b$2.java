package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class b$2
  implements Runnable
{
  b$2(b paramb, String paramString, ArrayList paramArrayList) {}
  
  public final void run()
  {
    g localg = h.Db(this.qZb.qYU.dZR.bVm);
    String str1 = this.qZb.qYU.dZR.bGm;
    String str2 = this.qZf;
    ArrayList localArrayList = this.qZg;
    y.i("MicroMsg.MsgHandler", "onSearchSuggestCallback: %s", new Object[] { localArrayList.toString() });
    Bundle localBundle = new Bundle();
    localBundle.putString("query", str1);
    localBundle.putString("suggestionId", str2);
    localBundle.putStringArrayList("result", localArrayList);
    try
    {
      if (localg.rgh != null) {
        localg.rgh.b(127, localBundle);
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      y.w("MicroMsg.MsgHandler", "onSearchSuggestCallback exception" + localRemoteException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.2
 * JD-Core Version:    0.7.0.1
 */