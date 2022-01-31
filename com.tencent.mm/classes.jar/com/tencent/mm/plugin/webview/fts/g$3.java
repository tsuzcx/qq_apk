package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.protocal.c.boh;
import com.tencent.mm.sdk.platformtools.y;

public final class g$3
  implements w.a
{
  public g$3(g paramg, int paramInt, String paramString1, String paramString2) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    if (paramm.getType() != 2608) {}
    for (;;)
    {
      return 0;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        y.e("MicroMsg.FTS.WebSearchLogic", "getPoiInfo onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " will retry");
        return 0;
      }
      if (paramb != null)
      {
        Object localObject = (boh)paramb.ecF.ecN;
        paramString = h.Db(this.qZV);
        paramb = this.fUi;
        paramm = this.qZW;
        localObject = ((boh)localObject).sEb;
        Bundle localBundle = new Bundle();
        localBundle.putString("searchId", paramb);
        localBundle.putString("poiId", paramm);
        localBundle.putString("json", (String)localObject);
        try
        {
          if (paramString.rgh != null)
          {
            paramString.rgh.b(145, localBundle);
            return 0;
          }
        }
        catch (RemoteException paramString)
        {
          y.w("MicroMsg.MsgHandler", "onGetPoiReady exception" + paramString.getMessage());
        }
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.g.3
 * JD-Core Version:    0.7.0.1
 */