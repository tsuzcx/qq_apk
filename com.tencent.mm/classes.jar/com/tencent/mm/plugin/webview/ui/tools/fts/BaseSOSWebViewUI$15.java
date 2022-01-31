package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mm.plugin.websearch.api.z;
import java.util.HashMap;
import java.util.Map;

final class BaseSOSWebViewUI$15
  implements Runnable
{
  BaseSOSWebViewUI$15(BaseSOSWebViewUI paramBaseSOSWebViewUI, BaseSOSWebViewUI.c paramc) {}
  
  public final void run()
  {
    Object localObject;
    if (BaseSOSWebViewUI.a(this.rtA) != null)
    {
      this.rtA.cfl();
      int i = this.rtA.rtQ;
      this.rtA.rtQ = this.rtF.type;
      this.rtA.cfm();
      localObject = new Bundle();
      ((Bundle)localObject).putInt("type", this.rtA.rtQ);
      ((Bundle)localObject).putBoolean("isHomePage", true);
      ((Bundle)localObject).putInt("scene", this.rtA.aZY());
    }
    try
    {
      BaseSOSWebViewUI.b(this.rtA).o(4, (Bundle)localObject);
      localObject = new HashMap();
      ((Map)localObject).put("isBackButtonClick", "1");
      ((Map)localObject).put("custom", this.rtA.getInEditTextQuery());
      BaseSOSWebViewUI.c(this.rtA).a(this.rtA.getTotalQuery(), this.rtA.getInEditTextQuery(), this.rtA.cfw(), 1, this.rtF.rtL);
      if (!TextUtils.isEmpty(this.rtA.getInEditTextQuery())) {
        z.a(this.rtA.scene, this.rtA.bIB, this.rtA.bVp, true, this.rtA.getInEditTextQuery(), this.rtA.type);
      }
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.15
 * JD-Core Version:    0.7.0.1
 */