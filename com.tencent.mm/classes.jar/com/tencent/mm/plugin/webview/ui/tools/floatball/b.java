package com.tencent.mm.plugin.webview.ui.tools.floatball;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.f.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.f.r;
import java.util.HashSet;
import java.util.Set;

public final class b
  extends com.tencent.mm.plugin.ball.service.e
{
  private static final Set<String> PRd;
  private static com.tencent.mm.plugin.ball.c.e old;
  private WebViewUI QcD;
  private boolean Qka;
  private boolean Qkb;
  private boolean Qkc;
  
  static
  {
    AppMethodBeat.i(80523);
    HashSet localHashSet = new HashSet();
    PRd = localHashSet;
    localHashSet.add("title");
    PRd.add("webpageTitle");
    PRd.add("hide_option_menu");
    PRd.add("translate_webview");
    PRd.add("srcUsername");
    PRd.add("srcDisplayname");
    PRd.add("mode");
    PRd.add("KTemplateId");
    PRd.add("KPublisherId");
    PRd.add(f.r.VSK);
    PRd.add(f.r.VSL);
    PRd.add("pay_channel");
    PRd.add("key_download_restrict");
    PRd.add("key_wallet_region");
    PRd.add("key_function_id");
    PRd.add(f.r.VSO);
    PRd.add("geta8key_scene");
    PRd.add(f.r.VSW);
    PRd.add("key_menu_hide_expose");
    PRd.add("webviewCurrentProcess");
    old = new com.tencent.mm.plugin.ball.c.f()
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
        b.T(paramAnonymousBallInfo);
        AppMethodBeat.o(80498);
      }
    };
    AppMethodBeat.o(80523);
  }
  
  public b(com.tencent.mm.plugin.ball.a.f paramf, WebViewUI paramWebViewUI)
  {
    super(paramf);
    AppMethodBeat.i(80499);
    this.Qkb = false;
    this.Qkc = false;
    this.QcD = paramWebViewUI;
    Log.i("MicroMsg.WebViewFloatBallHelper", "createFloatBallHelper, WebViewUI:%s", new Object[] { Integer.valueOf(paramWebViewUI.hashCode()) });
    AppMethodBeat.o(80499);
  }
  
  public static void bOh()
  {
    AppMethodBeat.i(80511);
    if (h.ae(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).a(2, old);
    }
    AppMethodBeat.o(80511);
  }
  
  public static void bOi()
  {
    AppMethodBeat.i(80512);
    if (h.ae(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).b(2, old);
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
  
  public final void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(80504);
    this.Qka = true;
    Log.i("MicroMsg.WebViewFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.I(paramInt, paramString);
    cvL().kqZ = 3;
    cvL().rYx = this.QcD.PIQ.bXC();
    if (isMpUrl(this.QcD.cDu())) {
      cvL().lEm = this.QcD.getIntent().getStringExtra("srcUsername");
    }
    Log.d("MicroMsg.WebViewFloatBallHelper", "initReportInfo generateScene %d", new Object[] { Integer.valueOf(cvL().rYx) });
    cvG();
    if ((this.rZC.getIntent() != null) && (this.rYE.mab != null))
    {
      a.b(this.rZC.getIntent(), this.rYE.mab, PRd);
      cvG();
    }
    AppMethodBeat.o(80504);
  }
  
  public final void aOf()
  {
    AppMethodBeat.i(221533);
    if (!this.Qkb) {
      super.aOf();
    }
    AppMethodBeat.o(221533);
  }
  
  public final boolean aOg()
  {
    AppMethodBeat.i(80501);
    if ((this.QcD.gUC()) && (this.rZC.aOg()))
    {
      AppMethodBeat.o(80501);
      return true;
    }
    AppMethodBeat.o(80501);
    return false;
  }
  
  public final boolean aOh()
  {
    AppMethodBeat.i(185939);
    boolean bool = this.QcD.gUC();
    AppMethodBeat.o(185939);
    return bool;
  }
  
  public final void aOi()
  {
    AppMethodBeat.i(80510);
    Log.i("MicroMsg.WebViewFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, WebViewUI:%s", new Object[] { Integer.valueOf(this.QcD.hashCode()) });
    this.rZC.hS(false);
    AppMethodBeat.o(80510);
  }
  
  public final void aOj()
  {
    AppMethodBeat.i(80508);
    Log.i("MicroMsg.WebViewFloatBallHelper", "onExitPage, WebViewUI:%s", new Object[] { Integer.valueOf(this.QcD.hashCode()) });
    super.aOj();
    this.Qkb = false;
    AppMethodBeat.o(80508);
  }
  
  public final void aoy(String paramString)
  {
    AppMethodBeat.i(80513);
    if ((this.rYE != null) && (!Util.isNullOrNil(this.rYE.name)) && (!this.rYE.name.startsWith("http://")) && (!this.rYE.name.startsWith("https://")) && (!Util.isNullOrNil(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      AppMethodBeat.o(80513);
      return;
    }
    super.aoy(paramString);
    AppMethodBeat.o(80513);
  }
  
  public final void bNV()
  {
    AppMethodBeat.i(80507);
    Log.i("MicroMsg.WebViewFloatBallHelper", "onEnterPage, WebViewUI:%s, isEntered: %b", new Object[] { Integer.valueOf(this.QcD.hashCode()), Boolean.valueOf(this.Qkb) });
    if (!this.Qkb)
    {
      this.Qkb = true;
      super.bNV();
    }
    AppMethodBeat.o(80507);
  }
  
  public final void bNW()
  {
    AppMethodBeat.i(80509);
    Log.i("MicroMsg.WebViewFloatBallHelper", "onReceivedBallInfoRemovedEvent, WebViewUI:%s", new Object[] { Integer.valueOf(this.QcD.hashCode()) });
    super.bNW();
    AppMethodBeat.o(80509);
  }
  
  public final boolean bOb()
  {
    AppMethodBeat.i(221553);
    if ((!this.Qkc) && (this.QcD.gUC()))
    {
      AppMethodBeat.o(221553);
      return true;
    }
    AppMethodBeat.o(221553);
    return false;
  }
  
  public final void bko(String paramString)
  {
    AppMethodBeat.i(80518);
    cvL().fIZ = paramString;
    cvG();
    AppMethodBeat.o(80518);
  }
  
  public final void cvE()
  {
    AppMethodBeat.i(80515);
    if ((this.Qka) && (this.rYG != null)) {
      this.rYG.l(this.rYE);
    }
    AppMethodBeat.o(80515);
  }
  
  public final void cvF()
  {
    AppMethodBeat.i(80516);
    if ((this.Qka) && (this.rYG != null)) {
      this.rYG.j(this.rYE);
    }
    AppMethodBeat.o(80516);
  }
  
  public final void cvG()
  {
    AppMethodBeat.i(80517);
    if ((this.Qka) && (this.rYG != null)) {
      this.rYG.k(this.rYE);
    }
    AppMethodBeat.o(80517);
  }
  
  public final boolean cvN()
  {
    return true;
  }
  
  public final BallInfo cvy()
  {
    AppMethodBeat.i(80514);
    BallInfo localBallInfo = super.cvy();
    AppMethodBeat.o(80514);
    return localBallInfo;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(80506);
    Log.i("MicroMsg.WebViewFloatBallHelper", "onDestroy, WebViewUI:%s", new Object[] { Integer.valueOf(this.QcD.hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(80506);
  }
  
  public final boolean zH(int paramInt)
  {
    AppMethodBeat.i(80505);
    Log.i("MicroMsg.WebViewFloatBallHelper", "onClose, WebViewUI:%s", new Object[] { Integer.valueOf(this.QcD.hashCode()) });
    boolean bool = super.zH(paramInt);
    AppMethodBeat.o(80505);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.floatball.b
 * JD-Core Version:    0.7.0.1
 */