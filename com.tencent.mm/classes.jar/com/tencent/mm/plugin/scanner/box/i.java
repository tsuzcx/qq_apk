package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.box.c.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebViewJSApi;", "Lcom/tencent/mm/plugin/box/webview/BoxWebViewJSApi;", "uiComponent", "Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;", "(Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;)V", "MPTmplRequest", "", "params", "", "MPTmplResponse", "openWebView", "Companion", "plugin-scan_release"})
public final class i
  extends com.tencent.mm.plugin.box.webview.d
{
  public static final a vNe;
  private final c mRK;
  
  static
  {
    AppMethodBeat.i(52144);
    vNe = new a((byte)0);
    AppMethodBeat.o(52144);
  }
  
  public i(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(52143);
    this.mRK = paramc;
    AppMethodBeat.o(52143);
  }
  
  @JavascriptInterface
  public final void MPTmplRequest(String paramString)
  {
    AppMethodBeat.i(52141);
    k.h(paramString, "params");
    super.request(paramString);
    AppMethodBeat.o(52141);
  }
  
  @JavascriptInterface
  public final void MPTmplResponse()
  {
    AppMethodBeat.i(52142);
    super.webviewUIReady();
    AppMethodBeat.o(52142);
  }
  
  @JavascriptInterface
  public final void openWebView(String paramString)
  {
    AppMethodBeat.i(52140);
    k.h(paramString, "params");
    ad.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openWebView %s", new Object[] { paramString });
    try
    {
      Object localObject = new JSONObject(paramString).optString("url", "");
      paramString = new Intent();
      paramString.putExtra("rawUrl", (String)localObject);
      paramString.putExtra("geta8key_scene", 67);
      localObject = this.mRK.getActivityContext();
      if (localObject != null)
      {
        com.tencent.mm.bs.d.b((Context)localObject, "webview", ".ui.tools.WebViewUI", paramString);
        AppMethodBeat.o(52140);
        return;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(52140);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebViewJSApi$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.i
 * JD-Core Version:    0.7.0.1
 */