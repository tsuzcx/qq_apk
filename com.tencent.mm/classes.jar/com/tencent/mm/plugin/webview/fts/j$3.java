package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.protocal.protobuf.dsq;
import com.tencent.mm.sdk.platformtools.Log;

public final class j$3
  implements aa.a
{
  public j$3(j paramj, int paramInt, String paramString1, String paramString2) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
  {
    AppMethodBeat.i(77953);
    if (paramq.getType() != 2608)
    {
      AppMethodBeat.o(77953);
      return 0;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.WebSearch.WebSearchLogic", "getPoiInfo onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " will retry");
      AppMethodBeat.o(77953);
      return 0;
    }
    Bundle localBundle;
    if (paramd != null)
    {
      Object localObject = (dsq)paramd.iLL.iLR;
      paramString = g.ahd(this.IOm);
      paramd = this.lmo;
      paramq = this.IPr;
      localObject = ((dsq)localObject).MaZ;
      localBundle = new Bundle();
      localBundle.putString("searchId", paramd);
      localBundle.putString("poiId", paramq);
      localBundle.putString("json", (String)localObject);
    }
    try
    {
      if (paramString.ISw != null) {
        paramString.ISw.f(145, localBundle);
      }
      AppMethodBeat.o(77953);
      return 0;
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        Log.w("MicroMsg.MsgHandler", "onGetPoiReady exception" + paramString.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.j.3
 * JD-Core Version:    0.7.0.1
 */