package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

final class b$4$1
  implements Runnable
{
  b$4$1(b.4 param4, j paramj, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(5678);
    if ((this.uOO.uOI.mSV != null) && (this.uOO.uOI.mSV.mRQ != null))
    {
      g localg = h.KW(((Integer)this.uOO.uOI.mSV.mRQ).intValue());
      String str = this.mPk.mPi.query;
      ArrayList localArrayList = this.uOK;
      ab.i("MicroMsg.MsgHandler", "onSearchHistoryCallback: %s", new Object[] { localArrayList.toString() });
      Bundle localBundle = new Bundle();
      localBundle.putString("query", str);
      localBundle.putStringArrayList("result", localArrayList);
      try
      {
        if (localg.uWu != null) {
          localg.uWu.e(126, localBundle);
        }
        AppMethodBeat.o(5678);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        ab.w("MicroMsg.MsgHandler", "onSearchHistoryCallback exception" + localRemoteException.getMessage());
      }
    }
    AppMethodBeat.o(5678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.4.1
 * JD-Core Version:    0.7.0.1
 */