package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.protocal.protobuf.byc;
import com.tencent.mm.sdk.platformtools.ab;

public final class h$3
  implements w.a
{
  public h$3(h paramh, int paramInt, String paramString1, String paramString2) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(5740);
    if (paramm.getType() != 2608)
    {
      AppMethodBeat.o(5740);
      return 0;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.WebSearch.WebSearchLogic", "getPoiInfo onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " will retry");
      AppMethodBeat.o(5740);
      return 0;
    }
    Bundle localBundle;
    if (paramb != null)
    {
      Object localObject = (byc)paramb.fsW.fta;
      paramString = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(this.uPE);
      paramb = this.hnK;
      paramm = this.uPF;
      localObject = ((byc)localObject).wAa;
      localBundle = new Bundle();
      localBundle.putString("searchId", paramb);
      localBundle.putString("poiId", paramm);
      localBundle.putString("json", (String)localObject);
    }
    try
    {
      if (paramString.uWu != null) {
        paramString.uWu.e(145, localBundle);
      }
      AppMethodBeat.o(5740);
      return 0;
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        ab.w("MicroMsg.MsgHandler", "onGetPoiReady exception" + paramString.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.h.3
 * JD-Core Version:    0.7.0.1
 */