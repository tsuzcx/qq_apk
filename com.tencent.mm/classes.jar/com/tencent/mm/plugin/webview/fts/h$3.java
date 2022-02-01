package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.protocal.protobuf.ctl;
import com.tencent.mm.sdk.platformtools.ac;

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
      ac.e("MicroMsg.WebSearch.WebSearchLogic", "getPoiInfo onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " will retry");
      AppMethodBeat.o(77953);
      return 0;
    }
    Bundle localBundle;
    if (paramb != null)
    {
      Object localObject = (ctl)paramb.hvs.hvw;
      paramString = g.VW(this.ChN);
      paramb = this.jLf;
      paramn = this.ChO;
      localObject = ((ctl)localObject).FhN;
      localBundle = new Bundle();
      localBundle.putString("searchId", paramb);
      localBundle.putString("poiId", paramn);
      localBundle.putString("json", (String)localObject);
    }
    try
    {
      if (paramString.CkJ != null) {
        paramString.CkJ.g(145, localBundle);
      }
      AppMethodBeat.o(77953);
      return 0;
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        ac.w("MicroMsg.MsgHandler", "onGetPoiReady exception" + paramString.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.h.3
 * JD-Core Version:    0.7.0.1
 */