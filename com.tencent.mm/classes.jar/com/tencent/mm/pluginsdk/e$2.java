package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;

final class e$2
  implements f
{
  e$2(Bundle paramBundle, Context paramContext, int paramInt, String paramString, e.a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(11656);
    g.Rc().b(1200, this);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: errType = %s; errCode = %s; errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    boolean bool2 = false;
    boolean bool1 = false;
    String str2;
    Object localObject;
    if ((paramm != null) && ((paramm instanceof com.tencent.mm.modelsimple.ab)))
    {
      str2 = ((com.tencent.mm.modelsimple.ab)paramm).ajX();
      if (e.akV(str2))
      {
        bool1 = bool2;
        localObject = paramString;
      }
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: deepLinkUri = %s", new Object[] { str2 });
        bool1 = bool2;
        localObject = paramString;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink gotoUri extraData: %s", new Object[] { this.vjH });
        bool1 = bool2;
        localObject = paramString;
        bool2 = e.a(this.val$context, str2, this.fwD, this.vjH, this.vJw);
        bool1 = bool2;
        localObject = paramString;
        h.qsU.e(11405, new Object[] { this.vJw, Integer.valueOf(this.fwD), Integer.valueOf(1), str2 });
        String str1 = paramString;
        bool1 = bool2;
        localObject = paramString;
        if (e.access$000())
        {
          bool1 = bool2;
          localObject = paramString;
          str1 = this.val$context.getString(2131302036);
          bool1 = bool2;
          localObject = str1;
          e.Pt();
        }
        paramString = str1;
        bool1 = bool2;
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.DeepLinkHelper", paramString, "", new Object[] { "" });
        h.qsU.e(11405, new Object[] { this.vJw, Integer.valueOf(this.fwD), Integer.valueOf(0), str2 });
        paramString = (String)localObject;
        continue;
      }
      if (this.vJv != null) {
        this.vJv.a(paramInt1, paramInt2, paramString, paramm, bool1);
      }
      AppMethodBeat.o(11656);
      return;
      if ((this.fwD == 1) && (this.vJv != null))
      {
        h.qsU.e(11405, new Object[] { this.vJw, Integer.valueOf(this.fwD), Integer.valueOf(0), str2 });
        this.vJv.a(paramInt1, paramInt2, paramString, paramm, false);
        AppMethodBeat.o(11656);
        return;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: translate failed");
      localObject = new Intent();
      ((Intent)localObject).setFlags(268435456);
      ((Intent)localObject).setClassName(ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
      ((Intent)localObject).putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
      ((Intent)localObject).putExtra("showShare", false);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink goto WebViewUI extraData: %s", new Object[] { this.vjH });
      if (this.vjH != null) {
        ((Intent)localObject).putExtras(this.vjH);
      }
      ah.getContext().startActivity((Intent)localObject);
      h.qsU.e(11405, new Object[] { this.vJw, Integer.valueOf(this.fwD), Integer.valueOf(0), str2 });
      bool1 = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.e.2
 * JD-Core Version:    0.7.0.1
 */