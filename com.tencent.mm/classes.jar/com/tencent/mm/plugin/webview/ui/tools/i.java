package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import kotlin.f;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/WebViewActionBarHelper;", "", "webViewUI", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)V", "urlParams", "Lcom/tencent/mm/plugin/webview/ui/tools/UrlParams;", "getUrlParams", "()Lcom/tencent/mm/plugin/webview/ui/tools/UrlParams;", "setUrlParams", "(Lcom/tencent/mm/plugin/webview/ui/tools/UrlParams;)V", "initImmersivePageBgIsDark", "", "immersivePageBgIsDark", "", "initImmersiveStyle", "initParams", "initParamsFromUrl", "isBgDarkMode", "", "isImmersiveStyle", "Companion", "plugin-webview_release"})
public final class i
{
  private static final f QcE;
  private static final f QcF;
  public static final a QcG;
  private static final f lrB;
  g QcC;
  final WebViewUI QcD;
  
  static
  {
    AppMethodBeat.i(245640);
    QcG = new a((byte)0);
    lrB = kotlin.g.ar((a)c.QcI);
    QcE = kotlin.g.ar((a)b.QcH);
    QcF = kotlin.g.ar((a)d.QcJ);
    AppMethodBeat.o(245640);
  }
  
  public i(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(245638);
    this.QcD = paramWebViewUI;
    this.QcC = new g((byte)0);
    paramWebViewUI = this.QcD.getIntent();
    if (paramWebViewUI.getIntExtra("immersiveUIStyle", 0) == 1)
    {
      this.QcC.PQp = true;
      aov(paramWebViewUI.getIntExtra("immersivePageBgIsDark", -1));
      AppMethodBeat.o(245638);
      return;
    }
    paramWebViewUI = this.QcD.cDu();
    p.j(paramWebViewUI, "webViewUI.rawUrl");
    boolean bool;
    for (;;)
    {
      try
      {
        paramWebViewUI = Uri.parse(paramWebViewUI);
        if (!((Boolean)QcE.getValue()).booleanValue())
        {
          p.j(paramWebViewUI, "uri");
          str = paramWebViewUI.getHost();
          if (str != null) {
            break label299;
          }
          bool = false;
          break label445;
        }
        this.QcC.PQp = p.h(Util.nullAsNil(paramWebViewUI.getQueryParameter("immersiveUIStyle")), "1");
        if (!Util.isNullOrNil(paramWebViewUI.getQueryParameter("immersiveUIStyle"))) {
          break;
        }
        p.j(paramWebViewUI, "uri");
        str = paramWebViewUI.getPath();
        if (str != null) {
          break label310;
        }
        bool = false;
        if (!bool) {
          break;
        }
        this.QcC.PQp = true;
        aov(-1);
        paramWebViewUI = paramWebViewUI.buildUpon().appendQueryParameter("immersiveUIStyle", "1").appendQueryParameter("immersivePageBgIsDark", "2").build().toString();
        p.j(paramWebViewUI, "uri.buildUpon().appendQu…, \"2\").build().toString()");
        this.QcD.getIntent().putExtra("rawUrl", paramWebViewUI);
        Log.i("MicroMsg.WebViewActionBarHelper", "initParamsFromUrl appendQueryParameter rawUrl = ".concat(String.valueOf(paramWebViewUI)));
        AppMethodBeat.o(245638);
        return;
      }
      catch (Exception paramWebViewUI)
      {
        Log.e("MicroMsg.WebViewActionBarHelper", "isTranslucentMode ex " + paramWebViewUI.getMessage());
      }
      label293:
      AppMethodBeat.o(245638);
      return;
      label299:
      bool = p.h(str, "support.weixin.qq.com");
      break label445;
      label310:
      if (!((Boolean)QcF.getValue()).booleanValue()) {
        bool = false;
      } else {
        bool = n.M(str, "/cgi-bin/mmsupport-bin/showredpacket", true);
      }
    }
    String str = paramWebViewUI.getQueryParameter("immersivePageBgIsDark");
    CharSequence localCharSequence = (CharSequence)str;
    if (localCharSequence != null) {
      if (!n.ba(localCharSequence)) {
        break label457;
      }
    }
    for (;;)
    {
      if (i == 0) {
        aov(Util.safeParseInt(str));
      }
      for (;;)
      {
        paramWebViewUI = paramWebViewUI.getQueryParameter("hideShareOption");
        if (paramWebViewUI == null) {
          break;
        }
        if (p.h(paramWebViewUI, "1")) {
          this.QcD.getIntent().putExtra("showShare", false);
        }
        AppMethodBeat.o(245638);
        return;
        aov(-1);
      }
      AppMethodBeat.o(245638);
      return;
      label445:
      if (!bool) {
        break label293;
      }
      break;
      int i = 1;
      continue;
      label457:
      i = 0;
    }
  }
  
  private final void aov(int paramInt)
  {
    AppMethodBeat.i(245636);
    switch (paramInt)
    {
    default: 
      this.QcC.PQq = ar.isDarkMode();
      AppMethodBeat.o(245636);
      return;
    case 0: 
      this.QcC.PQq = false;
      AppMethodBeat.o(245636);
      return;
    }
    this.QcC.PQq = true;
    AppMethodBeat.o(245636);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/WebViewActionBarHelper$Companion;", "", "()V", "TAG", "", "immersiveStyleFromUrl", "", "getImmersiveStyleFromUrl", "()Z", "immersiveStyleFromUrl$delegate", "Lkotlin/Lazy;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "showRedPacketAlphaTitleBar", "getShowRedPacketAlphaTitleBar", "showRedPacketAlphaTitleBar$delegate", "isImmersiveStyleHost", "host", "isImmersiveStylePath", "path", "plugin-webview_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Boolean>
  {
    public static final b QcH;
    
    static
    {
      AppMethodBeat.i(221617);
      QcH = new b();
      AppMethodBeat.o(221617);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements a<MultiProcessMMKV>
  {
    public static final c QcI;
    
    static
    {
      AppMethodBeat.i(267926);
      QcI = new c();
      AppMethodBeat.o(267926);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<Boolean>
  {
    public static final d QcJ;
    
    static
    {
      AppMethodBeat.i(262151);
      QcJ = new d();
      AppMethodBeat.o(262151);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.i
 * JD-Core Version:    0.7.0.1
 */