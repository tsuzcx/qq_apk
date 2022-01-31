package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

final class BaseSOSWebViewUI$16
  implements Runnable
{
  BaseSOSWebViewUI$16(BaseSOSWebViewUI paramBaseSOSWebViewUI, BaseSOSWebViewUI.c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(8345);
    if (this.vjG.getJsapi() != null)
    {
      this.vjG.dfu();
      this.vjG.vjX = this.vjM.type;
      this.vjG.dfv();
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("type", this.vjG.vjX);
      ((Bundle)localObject).putBoolean("isHomePage", true);
      ((Bundle)localObject).putInt("scene", this.vjG.scene);
      try
      {
        this.vjG.igU.s(4, (Bundle)localObject);
        localObject = new HashMap();
        ((Map)localObject).put("isBackButtonClick", "1");
        ((Map)localObject).put("custom", this.vjG.getInEditTextQuery());
        this.vjG.getJsapi().a(this.vjG.getTotalQuery(), this.vjG.getInEditTextQuery(), this.vjG.dfD(), 1, this.vjM.vjQ);
        if (!TextUtils.isEmpty(this.vjG.getInEditTextQuery())) {
          z.a(this.vjG.scene, this.vjG.cpW, this.vjG.cCW, true, this.vjG.getInEditTextQuery(), this.vjG.type);
        }
        AppMethodBeat.o(8345);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        ab.e("MicroMsg.WebSearch.BaseSOSWebViewUI", "ex %s", new Object[] { localRemoteException.getMessage() });
      }
    }
    AppMethodBeat.o(8345);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.16
 * JD-Core Version:    0.7.0.1
 */