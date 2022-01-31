package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

final class b$2
  implements Runnable
{
  b$2(b paramb, String paramString, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(5674);
    g localg = h.KW(this.uOI.uOA.fpY.cCT);
    String str1 = this.uOI.uOA.fpY.cnv;
    String str2 = this.uOM;
    ArrayList localArrayList = this.uON;
    ab.i("MicroMsg.MsgHandler", "onSearchSuggestCallback: %s", new Object[] { localArrayList.toString() });
    Bundle localBundle = new Bundle();
    localBundle.putString("query", str1);
    localBundle.putString("suggestionId", str2);
    localBundle.putStringArrayList("result", localArrayList);
    try
    {
      if (localg.uWu != null) {
        localg.uWu.e(127, localBundle);
      }
      AppMethodBeat.o(5674);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ab.w("MicroMsg.MsgHandler", "onSearchSuggestCallback exception" + localRemoteException.getMessage());
      AppMethodBeat.o(5674);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.2
 * JD-Core Version:    0.7.0.1
 */