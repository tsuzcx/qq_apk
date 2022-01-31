package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class d$2
  implements f
{
  d$2(Bundle paramBundle, Context paramContext, int paramInt, String paramString, d.a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    au.Dk().b(1200, this);
    y.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: errType = %s; errCode = %s; errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool3;
    String str;
    if (paramm != null)
    {
      bool1 = bool3;
      if ((paramm instanceof aa))
      {
        str = ((aa)paramm).QQ();
        if (!d.Vz(str)) {
          break label292;
        }
      }
    }
    for (bool1 = bool2;; bool1 = true)
    {
      try
      {
        y.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: deepLinkUri = %s", new Object[] { str });
        bool1 = bool2;
        y.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink gotoUri extraData: %s", new Object[] { this.rtB });
        bool1 = bool2;
        bool2 = d.a(this.val$context, str, this.egz, this.rtB, this.rSA);
        bool1 = bool2;
        h.nFQ.f(11405, new Object[] { this.rSA, Integer.valueOf(this.egz), Integer.valueOf(1), str });
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.DeepLinkHelper", localException, "", new Object[] { "" });
          h.nFQ.f(11405, new Object[] { this.rSA, Integer.valueOf(this.egz), Integer.valueOf(0), str });
        }
      }
      if (this.rSz != null) {
        this.rSz.a(paramInt1, paramInt2, paramString, paramm, bool1);
      }
      return;
      label292:
      if ((this.egz == 1) && (this.rSz != null))
      {
        h.nFQ.f(11405, new Object[] { this.rSA, Integer.valueOf(this.egz), Integer.valueOf(0), str });
        this.rSz.a(paramInt1, paramInt2, paramString, paramm, false);
        return;
      }
      y.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: translate failed");
      Intent localIntent = new Intent();
      localIntent.setFlags(268435456);
      localIntent.setClassName(ae.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
      localIntent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
      localIntent.putExtra("showShare", false);
      y.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink goto WebViewUI extraData: %s", new Object[] { this.rtB });
      if (this.rtB != null) {
        localIntent.putExtras(this.rtB);
      }
      ae.getContext().startActivity(localIntent);
      h.nFQ.f(11405, new Object[] { this.rSA, Integer.valueOf(this.egz), Integer.valueOf(0), str });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d.2
 * JD-Core Version:    0.7.0.1
 */