package com.tencent.mm.plugin.webview.ui.tools.floatball;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.e.p;
import java.util.HashSet;
import java.util.Set;

public final class b
  extends com.tencent.mm.plugin.ball.service.f
{
  private static final Set<String> IUM;
  private static com.tencent.mm.plugin.ball.c.e lqt;
  private WebViewUI Jkg;
  private boolean JmJ;
  private boolean JmK;
  private boolean JmL;
  
  static
  {
    AppMethodBeat.i(80523);
    HashSet localHashSet = new HashSet();
    IUM = localHashSet;
    localHashSet.add("title");
    IUM.add("webpageTitle");
    IUM.add("hide_option_menu");
    IUM.add("translate_webview");
    IUM.add("srcUsername");
    IUM.add("srcDisplayname");
    IUM.add("mode");
    IUM.add("KTemplateId");
    IUM.add("KPublisherId");
    IUM.add(e.p.Ozw);
    IUM.add(e.p.Ozx);
    IUM.add("pay_channel");
    IUM.add("key_download_restrict");
    IUM.add("key_wallet_region");
    IUM.add("key_function_id");
    IUM.add(e.p.OzA);
    IUM.add("geta8key_scene");
    IUM.add("biz_video_msg_id");
    IUM.add("biz_video_msg_index");
    IUM.add("biz_video_msg_svr_id");
    IUM.add("biz_mp_msg_info");
    IUM.add(e.p.OzI);
    IUM.add("key_menu_hide_expose");
    IUM.add("webviewCurrentProcess");
    lqt = new com.tencent.mm.plugin.ball.c.f()
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
        b.S(paramAnonymousBallInfo);
        AppMethodBeat.o(80498);
      }
    };
    AppMethodBeat.o(80523);
  }
  
  public b(com.tencent.mm.plugin.ball.a.f paramf, WebViewUI paramWebViewUI)
  {
    super(paramf);
    AppMethodBeat.i(80499);
    this.JmK = false;
    this.JmL = false;
    this.Jkg = paramWebViewUI;
    Log.i("MicroMsg.WebViewFloatBallHelper", "createFloatBallHelper, WebViewUI:%s", new Object[] { Integer.valueOf(paramWebViewUI.hashCode()) });
    AppMethodBeat.o(80499);
  }
  
  public static void bCM()
  {
    AppMethodBeat.i(80511);
    if (g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)g.af(com.tencent.mm.plugin.ball.c.b.class)).a(2, lqt);
    }
    AppMethodBeat.o(80511);
  }
  
  public static void bCN()
  {
    AppMethodBeat.i(80512);
    if (g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)g.af(com.tencent.mm.plugin.ball.c.b.class)).b(2, lqt);
    }
    AppMethodBeat.o(80512);
  }
  
  public static boolean isMpUrl(String paramString)
  {
    AppMethodBeat.i(80503);
    if (!Util.isNullOrNil(paramString))
    {
      if ((paramString.startsWith("https://" + WeChatHosts.domainString(2131761726) + "/")) || (paramString.startsWith("http://" + WeChatHosts.domainString(2131761726) + "/")))
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
  
  public final void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(80504);
    this.JmJ = true;
    Log.i("MicroMsg.WebViewFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.G(paramInt, paramString);
    ciw().hDa = 3;
    if (this.Jkg.cpI()) {}
    for (ciw().oWx = this.Jkg.getIntent().getIntExtra(e.p.Ozw, 10000);; ciw().oWx = this.Jkg.bLC())
    {
      if (isMpUrl(this.Jkg.coX())) {
        ciw().iNV = this.Jkg.getIntent().getStringExtra("srcUsername");
      }
      Log.d("MicroMsg.WebViewFloatBallHelper", "initReportInfo generateScene %d", new Object[] { Integer.valueOf(ciw().oWx) });
      cit();
      if ((this.oXA.getIntent() != null) && (this.oWE.jkf != null))
      {
        com.tencent.mm.plugin.ball.f.a.b(this.oXA.getIntent(), this.oWE.jkf, IUM);
        cit();
      }
      AppMethodBeat.o(80504);
      return;
    }
  }
  
  public final void aGf()
  {
    AppMethodBeat.i(211205);
    if (!this.JmK) {
      super.aGf();
    }
    AppMethodBeat.o(211205);
  }
  
  public final boolean aGg()
  {
    AppMethodBeat.i(80501);
    if ((this.Jkg.gbH()) && (this.oXA.aGg()))
    {
      AppMethodBeat.o(80501);
      return true;
    }
    AppMethodBeat.o(80501);
    return false;
  }
  
  public final boolean aGh()
  {
    AppMethodBeat.i(185939);
    boolean bool = this.Jkg.gbH();
    AppMethodBeat.o(185939);
    return bool;
  }
  
  public final void aGi()
  {
    AppMethodBeat.i(80510);
    Log.i("MicroMsg.WebViewFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, WebViewUI:%s", new Object[] { Integer.valueOf(this.Jkg.hashCode()) });
    this.oXA.hb(false);
    AppMethodBeat.o(80510);
  }
  
  public final void aGj()
  {
    AppMethodBeat.i(80508);
    Log.i("MicroMsg.WebViewFloatBallHelper", "onExitPage, WebViewUI:%s", new Object[] { Integer.valueOf(this.Jkg.hashCode()) });
    if (((this.Jkg instanceof com.tencent.mm.plugin.webview.h.a.a)) && (ciq()))
    {
      int i = ((com.tencent.mm.plugin.webview.h.a.a)this.Jkg).cql();
      if ((this.oWE != null) && (this.oWE.jkf != null))
      {
        this.oWE.jkf.putInt("BizVideoPlayTime", i);
        cit();
      }
    }
    super.aGj();
    this.JmK = false;
    AppMethodBeat.o(80508);
  }
  
  public final void aYt(String paramString)
  {
    AppMethodBeat.i(80518);
    ciw().dPJ = paramString;
    cit();
    AppMethodBeat.o(80518);
  }
  
  public final void agT(String paramString)
  {
    AppMethodBeat.i(80513);
    if ((this.oWE != null) && (!Util.isNullOrNil(this.oWE.name)) && (!this.oWE.name.startsWith("http://")) && (!this.oWE.name.startsWith("https://")) && (!Util.isNullOrNil(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      AppMethodBeat.o(80513);
      return;
    }
    super.agT(paramString);
    AppMethodBeat.o(80513);
  }
  
  public final void bCA()
  {
    AppMethodBeat.i(80507);
    Log.i("MicroMsg.WebViewFloatBallHelper", "onEnterPage, WebViewUI:%s, isEntered: %b", new Object[] { Integer.valueOf(this.Jkg.hashCode()), Boolean.valueOf(this.JmK) });
    if (!this.JmK)
    {
      this.JmK = true;
      super.bCA();
    }
    AppMethodBeat.o(80507);
  }
  
  public final void bCB()
  {
    AppMethodBeat.i(80509);
    Log.i("MicroMsg.WebViewFloatBallHelper", "onReceivedBallInfoRemovedEvent, WebViewUI:%s", new Object[] { Integer.valueOf(this.Jkg.hashCode()) });
    super.bCB();
    AppMethodBeat.o(80509);
  }
  
  public final boolean bCG()
  {
    AppMethodBeat.i(211206);
    if ((!this.JmL) && (this.Jkg.gbH()))
    {
      AppMethodBeat.o(211206);
      return true;
    }
    AppMethodBeat.o(211206);
    return false;
  }
  
  public final BallInfo cim()
  {
    AppMethodBeat.i(80514);
    BallInfo localBallInfo = super.cim();
    AppMethodBeat.o(80514);
    return localBallInfo;
  }
  
  public final void cir()
  {
    AppMethodBeat.i(80515);
    if ((this.JmJ) && (this.oWG != null)) {
      this.oWG.l(this.oWE);
    }
    AppMethodBeat.o(80515);
  }
  
  public final void cis()
  {
    AppMethodBeat.i(80516);
    if ((this.JmJ) && (this.oWG != null)) {
      this.oWG.j(this.oWE);
    }
    AppMethodBeat.o(80516);
  }
  
  public final void cit()
  {
    AppMethodBeat.i(80517);
    if ((this.JmJ) && (this.oWG != null)) {
      this.oWG.k(this.oWE);
    }
    AppMethodBeat.o(80517);
  }
  
  public final boolean ciy()
  {
    return true;
  }
  
  public final void ghZ()
  {
    AppMethodBeat.i(80502);
    if (this.oXC != null) {
      this.oXC.stop();
    }
    this.JmL = true;
    AppMethodBeat.o(80502);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(80506);
    Log.i("MicroMsg.WebViewFloatBallHelper", "onDestroy, WebViewUI:%s", new Object[] { Integer.valueOf(this.Jkg.hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(80506);
  }
  
  public final boolean wu(int paramInt)
  {
    AppMethodBeat.i(80505);
    Log.i("MicroMsg.WebViewFloatBallHelper", "onClose, WebViewUI:%s", new Object[] { Integer.valueOf(this.Jkg.hashCode()) });
    boolean bool = super.wu(paramInt);
    AppMethodBeat.o(80505);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.floatball.b
 * JD-Core Version:    0.7.0.1
 */