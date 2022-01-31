package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

final class WebViewUI$f
  implements b
{
  private WebViewUI$f(WebViewUI paramWebViewUI) {}
  
  public final boolean Tq(String paramString)
  {
    int i = WebViewUI.b(this.rpH, bk.pm(WebViewUI.aU(this.rpH)));
    if (com.tencent.mm.pluginsdk.d.ao(paramString, WebViewUI.aV(this.rpH))) {
      for (;;)
      {
        try
        {
          Object localObject;
          if ("weixin://dl/shopping".equals(paramString))
          {
            localObject = this.rpH.gGn.cdk();
            if (!bk.bl((String)localObject)) {
              this.rpH.b((String)localObject, null, false);
            }
            localObject = new ArrayList();
            ((List)localObject).add(paramString);
            ((List)localObject).add("1");
            ((List)localObject).add(String.valueOf(i));
            ((List)localObject).add(bk.pm(WebViewUI.aU(this.rpH)));
            ((List)localObject).add(bk.pm(this.rpH.caS));
            this.rpH.gGn.h(11405, (List)localObject);
            return true;
          }
          if ("weixin://dl/faq".equals(paramString))
          {
            int j = this.rpH.gGn.cdm();
            int k = this.rpH.gGn.cdn();
            localObject = ae.getContext().getString(R.l.settings_system_notice_url, new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
            this.rpH.b((String)localObject, null, false);
            continue;
          }
          if (!"weixin://dl/posts".equals(paramString)) {
            break label294;
          }
        }
        catch (Exception paramString)
        {
          y.e("MicroMsg.WebViewUI", "kv report fail, ex = %s", new Object[] { paramString.getMessage() });
          return true;
        }
        this.rpH.gGn.cdo();
        continue;
        label294:
        if ("weixin://dl/moments".equals(paramString)) {
          this.rpH.gGn.cdp();
        } else if (paramString.startsWith("weixin://dl/feedback")) {
          this.rpH.gGn.SV(paramString);
        } else if ("weixin://dl/scan".equals(paramString)) {
          com.tencent.mm.br.d.c(this.rpH, "scanner", ".ui.SingleTopScanUI", new Intent());
        } else {
          com.tencent.mm.pluginsdk.d.VD(paramString);
        }
      }
    }
    return false;
  }
  
  public final boolean Ty(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    return s.n(paramString, "weixin://");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.f
 * JD-Core Version:    0.7.0.1
 */