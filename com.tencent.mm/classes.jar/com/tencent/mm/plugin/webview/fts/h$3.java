package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.protocal.protobuf.coe;
import com.tencent.mm.sdk.platformtools.ad;

public final class h$3
  implements x.a
{
  public h$3(h paramh, int paramInt, String paramString1, String paramString2) {}
  
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
      Object localObject = (coe)paramb.gUT.gUX;
      paramString = g.TO(this.APx);
      paramb = this.jkS;
      paramn = this.APy;
      localObject = ((coe)localObject).DLy;
      localBundle = new Bundle();
      localBundle.putString("searchId", paramb);
      localBundle.putString("poiId", paramn);
      localBundle.putString("json", (String)localObject);
    }
    try
    {
      if (paramString.ASw != null) {
        paramString.ASw.f(145, localBundle);
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
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.h.3
 * JD-Core Version:    0.7.0.1
 */