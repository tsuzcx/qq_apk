package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
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
    AppMethodBeat.i(8423);
    Object localObject = (FTSMainUIHotWordLayout.a)paramView.getTag();
    switch (((FTSMainUIHotWordLayout.a)localObject).cFm)
    {
    }
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("isclick", Integer.valueOf(1));
      localHashMap.put("scene", Integer.valueOf(20));
      localHashMap.put("recommendid", FTSSOSHomeWebViewUI.q(this.vkS).getSearchId());
      localHashMap.put("businesstype", Integer.valueOf(0));
      if (((FTSMainUIHotWordLayout.a)localObject).Aos != null) {}
      for (paramView = Uri.encode(((FTSMainUIHotWordLayout.a)localObject).Aos);; paramView = "")
      {
        for (;;)
        {
          localHashMap.put("docid", paramView);
          localHashMap.put("docpos", Integer.valueOf(((FTSMainUIHotWordLayout.a)localObject).Aot + 1));
          localHashMap.put("ishomepage", Integer.valueOf(1));
          localHashMap.put("typepos", Integer.valueOf(1));
          localHashMap.put("jumpurl", Uri.encode(((FTSMainUIHotWordLayout.a)localObject).jumpUrl));
          paramView = aa.an(localHashMap);
          localObject = new Bundle();
          ((Bundle)localObject).putString("logString", paramView);
          this.vkS.igU.i(131, (Bundle)localObject);
          AppMethodBeat.o(8423);
          return;
          if (!this.vkS.vjF)
          {
            AppMethodBeat.o(8423);
            return;
          }
          FTSSOSHomeWebViewUI.p(this.vkS);
          FTSSOSHomeWebViewUI.e(this.vkS, 0);
          this.vkS.dfA().clearText();
          this.vkS.dfA().o(((FTSMainUIHotWordLayout.a)localObject).Aos, null);
          this.vkS.dfA().bDj();
          FTSSOSHomeWebViewUI.a(this.vkS).sendMessage(13);
          try
          {
            paramView = new Bundle();
            paramView.putInt("type", 0);
            paramView.putBoolean("isHomePage", true);
            paramView.putInt("scene", 20);
            paramView = this.vkS.igU.s(4, paramView);
            localHashMap = new HashMap();
            localHashMap.put("sceneActionType", "2");
            localHashMap.put("recommendId", FTSSOSHomeWebViewUI.q(this.vkS).getSearchId());
            FTSSOSHomeWebViewUI.r(this.vkS).post(new FTSSOSHomeWebViewUI.2.1(this, paramView, localHashMap));
          }
          catch (Exception paramView) {}
        }
        break;
        paramView = new Intent();
        paramView.putExtra("rawUrl", ((FTSMainUIHotWordLayout.a)localObject).jumpUrl);
        paramView.putExtra("convertActivityFromTranslucent", false);
        com.tencent.mm.bq.d.b(ah.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
        break;
      }
      return;
    }
    catch (Exception paramView)
    {
      ab.w("MicroMsg.WebSearch.FTSSOSHomeWebViewUI", "onHotwordCellClickListener cgi report fail for %s", new Object[] { paramView.toString() });
      AppMethodBeat.o(8423);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.2
 * JD-Core Version:    0.7.0.1
 */