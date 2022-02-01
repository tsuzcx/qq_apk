package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.protocal.protobuf.cyv;
import com.tencent.mm.sdk.platformtools.ad;

public final class i$3
  implements x.a
{
  public i$3(i parami, int paramInt, String paramString1, String paramString2) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(77953);
    if (paramn.getType() != 2608)
    {
      AppMethodBeat.o(77953);
      return 0;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e("MicroMsg.WebSearch.WebSearchLogic", "getPoiInfo onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " will retry");
      AppMethodBeat.o(77953);
      return 0;
    }
    Bundle localBundle;
    if (paramb != null)
    {
      Object localObject = (cyv)paramb.hNL.hNQ;
      paramString = g.XN(this.DKU);
      paramb = this.kfq;
      paramn = this.DKV;
      localObject = ((cyv)localObject).GDb;
      localBundle = new Bundle();
      localBundle.putString("searchId", paramb);
      localBundle.putString("poiId", paramn);
      localBundle.putString("json", (String)localObject);
    }
    try
    {
      if (paramString.DNO != null) {
        paramString.DNO.g(145, localBundle);
      }
      AppMethodBeat.o(77953);
      return 0;
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        ad.w("MicroMsg.MsgHandler", "onGetPoiReady exception" + paramString.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.i.3
 * JD-Core Version:    0.7.0.1
 */