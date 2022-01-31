package com.tencent.mm.plugin.webview.ui.tools;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.a;
import com.tencent.mm.plugin.webview.model.ap;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class WebViewUI$25
  implements f.a
{
  WebViewUI$25(WebViewUI paramWebViewUI) {}
  
  public final void aZa()
  {
    int k = 2;
    bool2 = false;
    AppMethodBeat.i(153238);
    for (;;)
    {
      try
      {
        if (!this.vgz.igU.ddb()) {
          continue;
        }
        if ((!this.vgz.dez()) && (!this.vgz.deA())) {
          continue;
        }
        i = WebViewUI.i(this.vgz);
      }
      catch (Exception localException)
      {
        String str1;
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d locald;
        ab.e("MicroMsg.WebViewUI", "onLoadJsApiFinished, ex = " + localException.getMessage());
        int i = 2;
        continue;
        boolean bool1 = false;
        continue;
        bool1 = false;
        continue;
        Object localObject = this.vgz.vfZ;
        if (!bo.isNullOrNil(localException)) {
          continue;
        }
        bool1 = bool2;
        if (!bool1) {
          continue;
        }
        this.vgz.uQS.oE(true);
        AppMethodBeat.o(153238);
        return;
        String str2 = Uri.parse(localException).getHost();
        bool1 = bool2;
        if (bo.isNullOrNil(str2)) {
          continue;
        }
        bool1 = ((ap)localObject).uWr.remove(str2);
        continue;
        int j = i;
        continue;
      }
      j = k;
      if (i > 0)
      {
        if (i <= 4) {
          continue;
        }
        j = k;
      }
      WebViewUI.c(this.vgz, j);
      this.vgz.Y(true, true);
      if ((this.vgz.pOd == null) || (this.vgz.igV == null) || (this.vgz.uQS == null)) {
        continue;
      }
      str1 = this.vgz.pOd.getUrl();
      if ((bo.isNullOrNil(str1)) || (!WebViewUI.j(this.vgz).add(str1))) {
        continue;
      }
      localObject = this.vgz.igV.ddW();
      if ((((GeneralControlWrapper)localObject).whZ & 0x200) <= 0) {
        continue;
      }
      bool1 = true;
      ab.d("MicroMsg.GeneralControlWrapper", "allowUploadHosts, ret = ".concat(String.valueOf(bool1)));
      if (bool1)
      {
        locald = this.vgz.uQS;
        ab.i("MicroMsg.JsApiHandler", "getAllHostsInPage, ready(%s).", new Object[] { Boolean.valueOf(locald.ready) });
        if ((locald.vou != null) && (locald.ready)) {
          locald.vou.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i.a.b("sys:get_all_hosts", new HashMap(), locald.voB, locald.voC) + ")", null);
        }
      }
      if ((((GeneralControlWrapper)localObject).whZ & 0x400) <= 0) {
        continue;
      }
      bool1 = true;
      ab.d("MicroMsg.GeneralControlWrapper", "allowUploadHTML, ret = ".concat(String.valueOf(bool1)));
      if (!bool1) {
        continue;
      }
      this.vgz.uQS.oE(false);
      AppMethodBeat.o(153238);
      return;
      if ((!bo.isNullOrNil(this.vgz.cJr)) && (a.uNB.matcher(this.vgz.cJr).matches())) {
        i = this.vgz.igU.gM(16388, 2);
      } else {
        i = this.vgz.igU.gM(16384, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.25
 * JD-Core Version:    0.7.0.1
 */