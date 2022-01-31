package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class b$4$1
  implements Runnable
{
  b$4$1(b.4 param4, j paramj, ArrayList paramArrayList) {}
  
  public final void run()
  {
    g localg;
    Bundle localBundle;
    if ((this.qZh.qZb.kxg != null) && (this.qZh.qZb.kxg.kwb != null))
    {
      localg = h.Db(((Integer)this.qZh.qZb.kxg.kwb).intValue());
      String str = this.ktw.ktu.bVk;
      ArrayList localArrayList = this.qZd;
      y.i("MicroMsg.MsgHandler", "onSearchHistoryCallback: %s", new Object[] { localArrayList.toString() });
      localBundle = new Bundle();
      localBundle.putString("query", str);
      localBundle.putStringArrayList("result", localArrayList);
    }
    try
    {
      if (localg.rgh != null) {
        localg.rgh.b(126, localBundle);
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      y.w("MicroMsg.MsgHandler", "onSearchHistoryCallback exception" + localRemoteException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.4.1
 * JD-Core Version:    0.7.0.1
 */