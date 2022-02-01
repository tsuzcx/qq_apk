package com.tencent.mm.plugin.webview.ui.tools.floatball;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.f.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.f.s;
import java.util.HashSet;
import java.util.Set;

public final class b
  extends com.tencent.mm.plugin.ball.service.e
{
  private static final Set<String> WHA;
  private static com.tencent.mm.plugin.ball.c.e roL;
  private WebViewUI WUm;
  private boolean XbS;
  private boolean XbT;
  private boolean XbU;
  
  static
  {
    AppMethodBeat.i(80523);
    HashSet localHashSet = new HashSet();
    WHA = localHashSet;
    localHashSet.add("title");
    WHA.add("webpageTitle");
    WHA.add("hide_option_menu");
    WHA.add("translate_webview");
    WHA.add("srcUsername");
    WHA.add("srcDisplayname");
    WHA.add("mode");
    WHA.add("KTemplateId");
    WHA.add("KPublisherId");
    WHA.add("KOpenArticleSceneFromScene");
    WHA.add(f.s.adwT);
    WHA.add("pay_channel");
    WHA.add("key_download_restrict");
    WHA.add("key_wallet_region");
    WHA.add("key_function_id");
    WHA.add(f.s.adwW);
    WHA.add("geta8key_scene");
    WHA.add(f.s.adxe);
    WHA.add("key_menu_hide_expose");
    WHA.add("webviewCurrentProcess");
    roL = new com.tencent.mm.plugin.ball.c.f()
    {
      public final void b(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(80497);
        b.a(paramAnonymousBallInfo);
        AppMethodBeat.o(80497);
      }
      
      public final void c(BallInfo paramAnonymousBallInfo) {}
      
      public final void d(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(80498);
        Log.i("MicroMsg.WebViewFloatBallHelper", "onFloatBallInfoExposed, ballInfo:%s", new Object[] { paramAnonymousBallInfo });
        b.V(paramAnonymousBallInfo);
        AppMethodBeat.o(80498);
      }
    };
    AppMethodBeat.o(80523);
  }
  
  public b(com.tencent.mm.plugin.ball.a.f paramf, WebViewUI paramWebViewUI)
  {
    super(paramf);
    AppMethodBeat.i(80499);
    this.XbT = false;
    this.XbU = false;
    this.WUm = paramWebViewUI;
    Log.i("MicroMsg.WebViewFloatBallHelper", "createFloatBallHelper, WebViewUI:%s", new Object[] { Integer.valueOf(paramWebViewUI.hashCode()) });
    AppMethodBeat.o(80499);
  }
  
  public static void cou()
  {
    AppMethodBeat.i(80511);
    if (h.ax(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).a(2, roL);
    }
    AppMethodBeat.o(80511);
  }
  
  public static void cov()
  {
    AppMethodBeat.i(80512);
    if (h.ax(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).b(2, roL);
    }
    AppMethodBeat.o(80512);
  }
  
  public static boolean isMpUrl(String paramString)
  {
    AppMethodBeat.i(80503);
    if (!Util.isNullOrNil(paramString))
    {
      if ((paramString.startsWith("https://" + WeChatHosts.domainString(c.i.host_mp_weixin_qq_com) + "/")) || (paramString.startsWith("http://" + WeChatHosts.domainString(c.i.host_mp_weixin_qq_com) + "/")))
      {
        AppMethodBeat.o(80503);
        return true;
      }
      AppMethodBeat.o(80503);
      return false;
    }
    AppMethodBeat.o(80503);
    return false;
  }
  
  public final void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(80504);
    this.XbS = true;
    Log.i("MicroMsg.WebViewFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.J(paramInt, paramString);
    cYv().mUU = 3;
    if (WebViewUI.izg()) {}
    for (cYv().vjN = this.WUm.getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);; cYv().vjN = this.WUm.Wzl.cxN())
    {
      if (isMpUrl(this.WUm.dgY())) {
        cYv().ovT = this.WUm.getIntent().getStringExtra("srcUsername");
      }
      Log.d("MicroMsg.WebViewFloatBallHelper", "initReportInfo generateScene %d", new Object[] { Integer.valueOf(cYv().vjN) });
      cYr();
      if ((this.vkT.getIntent() != null) && (this.vjV.oSS != null))
      {
        a.b(this.vkT.getIntent(), this.vjV.oSS, WHA);
        cYr();
      }
      AppMethodBeat.o(80504);
      return;
    }
  }
  
  public final void ahU(String paramString)
  {
    AppMethodBeat.i(80513);
    if ((this.vjV != null) && (!Util.isNullOrNil(this.vjV.name)) && (!this.vjV.name.startsWith("http://")) && (!this.vjV.name.startsWith("https://")) && (!Util.isNullOrNil(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      AppMethodBeat.o(80513);
      return;
    }
    super.ahU(paramString);
    AppMethodBeat.o(80513);
  }
  
  public final void bhT()
  {
    AppMethodBeat.i(296324);
    if (!this.XbT) {
      super.bhT();
    }
    AppMethodBeat.o(296324);
  }
  
  public final boolean bhU()
  {
    AppMethodBeat.i(80501);
    if ((this.WUm.iul()) && (this.vkT.bhU()))
    {
      AppMethodBeat.o(80501);
      return true;
    }
    AppMethodBeat.o(80501);
    return false;
  }
  
  public final void bhV()
  {
    AppMethodBeat.i(80510);
    Log.i("MicroMsg.WebViewFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, WebViewUI:%s", new Object[] { Integer.valueOf(this.WUm.hashCode()) });
    this.vkT.iR(false);
    AppMethodBeat.o(80510);
  }
  
  public final void bhW()
  {
    AppMethodBeat.i(80508);
    Log.i("MicroMsg.WebViewFloatBallHelper", "onExitPage, WebViewUI:%s", new Object[] { Integer.valueOf(this.WUm.hashCode()) });
    super.bhW();
    this.XbT = false;
    AppMethodBeat.o(80508);
  }
  
  public final void bjY(String paramString)
  {
    AppMethodBeat.i(80518);
    cYv().hOH = paramString;
    cYr();
    AppMethodBeat.o(80518);
  }
  
  public final BallInfo cYj()
  {
    AppMethodBeat.i(80514);
    BallInfo localBallInfo = super.cYj();
    AppMethodBeat.o(80514);
    return localBallInfo;
  }
  
  public final void cYp()
  {
    AppMethodBeat.i(80515);
    if ((this.XbS) && (this.vjX != null)) {
      this.vjX.l(this.vjV);
    }
    AppMethodBeat.o(80515);
  }
  
  public final void cYq()
  {
    AppMethodBeat.i(80516);
    if ((this.XbS) && (this.vjX != null)) {
      this.vjX.j(this.vjV);
    }
    AppMethodBeat.o(80516);
  }
  
  public final void cYr()
  {
    AppMethodBeat.i(80517);
    if ((this.XbS) && (this.vjX != null)) {
      this.vjX.k(this.vjV);
    }
    AppMethodBeat.o(80517);
  }
  
  public final boolean cYw()
  {
    return true;
  }
  
  public final void coi()
  {
    AppMethodBeat.i(80507);
    Log.i("MicroMsg.WebViewFloatBallHelper", "onEnterPage, WebViewUI:%s, isEntered: %b", new Object[] { Integer.valueOf(this.WUm.hashCode()), Boolean.valueOf(this.XbT) });
    if (!this.XbT)
    {
      this.XbT = true;
      super.coi();
    }
    AppMethodBeat.o(80507);
  }
  
  public final void coj()
  {
    AppMethodBeat.i(80509);
    Log.i("MicroMsg.WebViewFloatBallHelper", "onReceivedBallInfoRemovedEvent, WebViewUI:%s", new Object[] { Integer.valueOf(this.WUm.hashCode()) });
    super.coj();
    AppMethodBeat.o(80509);
  }
  
  public final boolean cop()
  {
    AppMethodBeat.i(185939);
    if ((!this.XbU) && (this.WUm.iul()))
    {
      AppMethodBeat.o(185939);
      return true;
    }
    AppMethodBeat.o(185939);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(80506);
    Log.i("MicroMsg.WebViewFloatBallHelper", "onDestroy, WebViewUI:%s", new Object[] { Integer.valueOf(this.WUm.hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(80506);
  }
  
  public final boolean zX(int paramInt)
  {
    AppMethodBeat.i(80505);
    Log.i("MicroMsg.WebViewFloatBallHelper", "onClose, WebViewUI:%s", new Object[] { Integer.valueOf(this.WUm.hashCode()) });
    boolean bool = super.zX(paramInt);
    AppMethodBeat.o(80505);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.floatball.b
 * JD-Core Version:    0.7.0.1
 */