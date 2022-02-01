package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.protocal.protobuf.czp;
import com.tencent.mm.sdk.platformtools.ae;

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
      ae.e("MicroMsg.WebSearch.WebSearchLogic", "getPoiInfo onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " will retry");
      AppMethodBeat.o(77953);
      return 0;
    }
    Bundle localBundle;
    if (paramb != null)
    {
      Object localObject = (czp)paramb.hQE.hQJ;
      paramString = g.Yt(this.EcS);
      paramb = this.kiG;
      paramn = this.EcT;
      localObject = ((czp)localObject).GWB;
      localBundle = new Bundle();
      localBundle.putString("searchId", paramb);
      localBundle.putString("poiId", paramn);
      localBundle.putString("json", (String)localObject);
    }
    try
    {
      if (paramString.EfN != null) {
        paramString.EfN.g(145, localBundle);
      }
      AppMethodBeat.o(77953);
      return 0;
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        ae.w("MicroMsg.MsgHandler", "onGetPoiReady exception" + paramString.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.i.3
 * JD-Core Version:    0.7.0.1
 */