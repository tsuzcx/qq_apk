package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/WebViewActionBarHelper;", "", "webViewUI", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)V", "isCustomizeActionBarColor", "", "urlParams", "Lcom/tencent/mm/plugin/webview/ui/tools/UrlParams;", "getUrlParams", "()Lcom/tencent/mm/plugin/webview/ui/tools/UrlParams;", "setUrlParams", "(Lcom/tencent/mm/plugin/webview/ui/tools/UrlParams;)V", "initImmersivePageBgIsDark", "", "immersivePageBgIsDark", "", "initImmersiveStyle", "initParams", "initParamsFromUrl", "isBgDarkMode", "isImmersiveStyle", "isImmersiveVideoStyle", "setIsCustomizeActionBarColor", "custom", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final a WUo;
  private static final kotlin.j<Boolean> WUr;
  private static final kotlin.j<Boolean> WUs;
  private static final kotlin.j<MultiProcessMMKV> exj;
  final WebViewUI WUm;
  j WUp;
  public boolean WUq;
  
  static
  {
    AppMethodBeat.i(296105);
    WUo = new a((byte)0);
    exj = k.cm((a)c.WUu);
    WUr = k.cm((a)b.WUt);
    WUs = k.cm((a)d.WUv);
    AppMethodBeat.o(296105);
  }
  
  public m(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(296094);
    this.WUm = paramWebViewUI;
    this.WUp = new j((byte)0);
    paramWebViewUI = this.WUm.getIntent();
    int j = paramWebViewUI.getIntExtra("immersiveUIStyle", 0);
    int k = paramWebViewUI.getIntExtra("immersiveVideoStyle", 0);
    boolean bool1;
    if ((j == 1) || (k == 1))
    {
      localObject = this.WUp;
      if (j == 1)
      {
        bool1 = true;
        ((j)localObject).WGL = bool1;
        localObject = this.WUp;
        if (k != 1) {
          break label140;
        }
      }
      label140:
      for (bool1 = bool2;; bool1 = false)
      {
        ((j)localObject).WUk = bool1;
        auo(paramWebViewUI.getIntExtra("immersivePageBgIsDark", -1));
        AppMethodBeat.o(296094);
        return;
        bool1 = false;
        break;
      }
    }
    paramWebViewUI = this.WUm.dgY();
    s.s(paramWebViewUI, "webViewUI.rawUrl");
    for (;;)
    {
      try
      {
        paramWebViewUI = Uri.parse(paramWebViewUI);
        if (!((Boolean)WUr.getValue()).booleanValue())
        {
          localObject = paramWebViewUI.getHost();
          if (localObject != null) {
            break label347;
          }
          bool1 = false;
          break label517;
        }
        this.WUp.WGL = s.p(Util.nullAsNil(paramWebViewUI.getQueryParameter("immersiveUIStyle")), "1");
        if (!Util.isNullOrNil(paramWebViewUI.getQueryParameter("immersiveUIStyle"))) {
          break;
        }
        localObject = paramWebViewUI.getPath();
        if (localObject != null) {
          break label359;
        }
        bool1 = false;
        if (!bool1) {
          break;
        }
        this.WUp.WGL = true;
        auo(-1);
        paramWebViewUI = paramWebViewUI.buildUpon().appendQueryParameter("immersiveUIStyle", "1").appendQueryParameter("immersivePageBgIsDark", "2").build().toString();
        s.s(paramWebViewUI, "uri.buildUpon().appendQu…, \"2\").build().toString()");
        this.WUm.getIntent().putExtra("rawUrl", paramWebViewUI);
        Log.i("MicroMsg.WebViewActionBarHelper", s.X("initParamsFromUrl appendQueryParameter rawUrl = ", paramWebViewUI));
        AppMethodBeat.o(296094);
        return;
      }
      catch (Exception paramWebViewUI)
      {
        Log.e("MicroMsg.WebViewActionBarHelper", s.X("isTranslucentMode ex ", paramWebViewUI.getMessage()));
      }
      label341:
      AppMethodBeat.o(296094);
      return;
      label347:
      bool1 = s.p(localObject, "support.weixin.qq.com");
      break label517;
      label359:
      if (!((Boolean)WUs.getValue()).booleanValue()) {
        bool1 = false;
      } else {
        bool1 = n.U((String)localObject, "/cgi-bin/mmsupport-bin/showredpacket", true);
      }
    }
    Object localObject = paramWebViewUI.getQueryParameter("immersivePageBgIsDark");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence != null) && (!n.bp(localCharSequence))) {}
    for (;;)
    {
      if (i == 0)
      {
        auo(Util.safeParseInt((String)localObject));
        paramWebViewUI = paramWebViewUI.getQueryParameter("hideShareOption");
        if (paramWebViewUI == null) {
          break label341;
        }
        i = paramWebViewUI.hashCode();
        switch (i)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(296094);
        return;
        auo(-1);
        break;
        if (paramWebViewUI.equals("1")) {
          this.WUm.getIntent().putExtra("showShare", false);
        }
      }
      label517:
      if (!bool1) {
        break label341;
      }
      break;
      i = 1;
    }
  }
  
  private final void auo(int paramInt)
  {
    AppMethodBeat.i(296100);
    switch (paramInt)
    {
    default: 
      this.WUp.WGM = aw.isDarkMode();
      AppMethodBeat.o(296100);
      return;
    case 0: 
      this.WUp.WGM = false;
      AppMethodBeat.o(296100);
      return;
    }
    this.WUp.WGM = true;
    AppMethodBeat.o(296100);
  }
  
  public final boolean ixy()
  {
    return (this.WUp.WGL) || (this.WUp.WUk);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/WebViewActionBarHelper$Companion;", "", "()V", "TAG", "", "immersiveStyleFromUrl", "", "getImmersiveStyleFromUrl", "()Z", "immersiveStyleFromUrl$delegate", "Lkotlin/Lazy;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "showRedPacketAlphaTitleBar", "getShowRedPacketAlphaTitleBar", "showRedPacketAlphaTitleBar$delegate", "isImmersiveStyleHost", "host", "isImmersiveStylePath", "path", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<Boolean>
  {
    public static final b WUt;
    
    static
    {
      AppMethodBeat.i(296192);
      WUt = new b();
      AppMethodBeat.o(296192);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<MultiProcessMMKV>
  {
    public static final c WUu;
    
    static
    {
      AppMethodBeat.i(296186);
      WUu = new c();
      AppMethodBeat.o(296186);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<Boolean>
  {
    public static final d WUv;
    
    static
    {
      AppMethodBeat.i(296189);
      WUv = new d();
      AppMethodBeat.o(296189);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.m
 * JD-Core Version:    0.7.0.1
 */