package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.fts.widget.FTSMainUIHotWordLayout;
import com.tencent.mm.ui.fts.widget.FTSMainUIHotWordLayout.a;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;
import java.util.HashMap;
import java.util.Map;

final class FTSSOSHomeWebViewUI$2
  implements View.OnClickListener
{
  FTSSOSHomeWebViewUI$2(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final void onClick(View paramView)
  {
    Object localObject = (FTSMainUIHotWordLayout.a)paramView.getTag();
    switch (((FTSMainUIHotWordLayout.a)localObject).bXq)
    {
    }
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("isclick", Integer.valueOf(1));
      localHashMap.put("scene", Integer.valueOf(20));
      localHashMap.put("recommendid", FTSSOSHomeWebViewUI.q(this.ruD).getSearchId());
      localHashMap.put("businesstype", Integer.valueOf(0));
      if (((FTSMainUIHotWordLayout.a)localObject).vWk != null) {}
      for (paramView = Uri.encode(((FTSMainUIHotWordLayout.a)localObject).vWk);; paramView = "")
      {
        for (;;)
        {
          localHashMap.put("docid", paramView);
          localHashMap.put("docpos", Integer.valueOf(((FTSMainUIHotWordLayout.a)localObject).vWl + 1));
          localHashMap.put("ishomepage", Integer.valueOf(1));
          localHashMap.put("typepos", Integer.valueOf(1));
          localHashMap.put("jumpurl", Uri.encode(((FTSMainUIHotWordLayout.a)localObject).jumpUrl));
          paramView = aa.T(localHashMap);
          localObject = new Bundle();
          ((Bundle)localObject).putString("logString", paramView);
          FTSSOSHomeWebViewUI.u(this.ruD).f(131, (Bundle)localObject);
          do
          {
            return;
          } while (!this.ruD.rtz);
          FTSSOSHomeWebViewUI.o(this.ruD);
          FTSSOSHomeWebViewUI.e(this.ruD, 0);
          this.ruD.cfr().clearText();
          this.ruD.cfr().n(((FTSMainUIHotWordLayout.a)localObject).vWk, null);
          this.ruD.cfr().aWC();
          FTSSOSHomeWebViewUI.a(this.ruD).Ff(13);
          try
          {
            paramView = new Bundle();
            paramView.putInt("type", 0);
            paramView.putBoolean("isHomePage", true);
            paramView.putInt("scene", 20);
            paramView = FTSSOSHomeWebViewUI.p(this.ruD).o(4, paramView);
            localHashMap = new HashMap();
            localHashMap.put("sceneActionType", "2");
            localHashMap.put("recommendId", FTSSOSHomeWebViewUI.q(this.ruD).getSearchId());
            FTSSOSHomeWebViewUI.t(this.ruD).post(new FTSSOSHomeWebViewUI.2.1(this, paramView, localHashMap));
          }
          catch (Exception paramView) {}
        }
        break;
        paramView = new Intent();
        paramView.putExtra("rawUrl", ((FTSMainUIHotWordLayout.a)localObject).jumpUrl);
        paramView.putExtra("convertActivityFromTranslucent", false);
        com.tencent.mm.br.d.b(ae.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
        break;
      }
      return;
    }
    catch (Exception paramView)
    {
      y.w("MicroMsg.FTS.FTSSOSHomeWebViewUI", "onHotwordCellClickListener cgi report fail for %s", new Object[] { paramView.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.2
 * JD-Core Version:    0.7.0.1
 */