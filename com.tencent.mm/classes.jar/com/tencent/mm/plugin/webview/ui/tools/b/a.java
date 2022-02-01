package com.tencent.mm.plugin.webview.ui.tools.b;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.ball.ui.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.e.m;
import java.util.HashSet;
import java.util.Set;

public final class a
  extends com.tencent.mm.plugin.ball.service.f
{
  private static final Set<String> CmD;
  private static com.tencent.mm.plugin.ball.c.f jPm;
  public WebViewUI CBb;
  private boolean CCq;
  private boolean CCr;
  private boolean CCs;
  
  static
  {
    AppMethodBeat.i(80523);
    HashSet localHashSet = new HashSet();
    CmD = localHashSet;
    localHashSet.add("title");
    CmD.add("webpageTitle");
    CmD.add("hide_option_menu");
    CmD.add("translate_webview");
    CmD.add("srcUsername");
    CmD.add("srcDisplayname");
    CmD.add("mode");
    CmD.add("KTemplateId");
    CmD.add("KPublisherId");
    CmD.add(e.m.Hhx);
    CmD.add(e.m.Hhy);
    CmD.add("pay_channel");
    CmD.add("key_download_restrict");
    CmD.add("key_wallet_region");
    CmD.add("key_function_id");
    CmD.add(e.m.HhB);
    CmD.add("geta8key_scene");
    CmD.add("biz_video_msg_id");
    CmD.add("biz_video_msg_index");
    CmD.add("biz_video_msg_svr_id");
    CmD.add("biz_mp_msg_info");
    CmD.add(e.m.HhJ);
    CmD.add("key_menu_hide_expose");
    jPm = new com.tencent.mm.plugin.ball.c.g()
    {
      public final void c(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(80497);
        a.b(paramAnonymousBallInfo);
        AppMethodBeat.o(80497);
      }
      
      public final void d(BallInfo paramAnonymousBallInfo) {}
      
      public final void e(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(80498);
        ac.i("MicroMsg.WebViewFloatBallHelper", "onFloatBallInfoExposed, ballInfo:%s", new Object[] { paramAnonymousBallInfo });
        a.N(paramAnonymousBallInfo);
        AppMethodBeat.o(80498);
      }
    };
    AppMethodBeat.o(80523);
  }
  
  public a(com.tencent.mm.plugin.ball.a.f paramf, WebViewUI paramWebViewUI)
  {
    super(paramf);
    AppMethodBeat.i(80499);
    this.CCr = false;
    this.CCs = false;
    this.CBb = paramWebViewUI;
    ac.i("MicroMsg.WebViewFloatBallHelper", "createFloatBallHelper, WebViewUI:%s", new Object[] { Integer.valueOf(paramWebViewUI.hashCode()) });
    AppMethodBeat.o(80499);
  }
  
  public static void bdm()
  {
    AppMethodBeat.i(80511);
    if (com.tencent.mm.kernel.g.ab(c.class) != null) {
      ((c)com.tencent.mm.kernel.g.ab(c.class)).a(2, jPm);
    }
    AppMethodBeat.o(80511);
  }
  
  public static void bdn()
  {
    AppMethodBeat.i(80512);
    if (com.tencent.mm.kernel.g.ab(c.class) != null) {
      ((c)com.tencent.mm.kernel.g.ab(c.class)).b(2, jPm);
    }
    AppMethodBeat.o(80512);
  }
  
  public static boolean isMpUrl(String paramString)
  {
    AppMethodBeat.i(80503);
    if (!bs.isNullOrNil(paramString))
    {
      if ((paramString.startsWith("https://mp.weixin.qq.com/")) || (paramString.startsWith("http://mp.weixin.qq.com/")))
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
  
  public final void SO(String paramString)
  {
    AppMethodBeat.i(80513);
    if ((this.nfN != null) && (!bs.isNullOrNil(this.nfN.name)) && (!this.nfN.name.startsWith("http://")) && (!this.nfN.name.startsWith("https://")) && (!bs.isNullOrNil(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      AppMethodBeat.o(80513);
      return;
    }
    super.SO(paramString);
    AppMethodBeat.o(80513);
  }
  
  public final void aBz(String paramString)
  {
    AppMethodBeat.i(80518);
    bGv().dlk = paramString;
    bGr();
    AppMethodBeat.o(80518);
  }
  
  public final void aDu(String paramString)
  {
    AppMethodBeat.i(80519);
    bGv().nfG = 9;
    bGv().nfH = paramString;
    bGr();
    AppMethodBeat.o(80519);
  }
  
  public final void aa(int paramInt, String paramString)
  {
    AppMethodBeat.i(80504);
    this.CCq = true;
    ac.i("MicroMsg.WebViewFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.aa(paramInt, paramString);
    bGv().nfG = 3;
    if (this.CBb.bMx()) {}
    for (bGv().nfF = this.CBb.getIntent().getIntExtra(e.m.Hhx, 10000);; bGv().nfF = this.CBb.blB())
    {
      if (isMpUrl(this.CBb.bLL())) {
        bGv().hxt = this.CBb.getIntent().getStringExtra("srcUsername");
      }
      ac.d("MicroMsg.WebViewFloatBallHelper", "initReportInfo generateScene %d", new Object[] { Integer.valueOf(bGv().nfF) });
      bGr();
      if ((this.ngF.getIntent() != null) && (this.nfN.hSN != null))
      {
        com.tencent.mm.plugin.ball.f.a.b(this.ngF.getIntent(), this.nfN.hSN, CmD);
        bGr();
      }
      AppMethodBeat.o(80504);
      return;
    }
  }
  
  public final void bGh()
  {
    AppMethodBeat.i(188502);
    if (!this.CCr) {
      super.bGh();
    }
    AppMethodBeat.o(188502);
  }
  
  public final BallInfo bGk()
  {
    AppMethodBeat.i(80514);
    BallInfo localBallInfo = super.bGk();
    AppMethodBeat.o(80514);
    return localBallInfo;
  }
  
  public final void bGp()
  {
    AppMethodBeat.i(80515);
    if ((this.CCq) && (this.nfP != null)) {
      this.nfP.l(this.nfN);
    }
    AppMethodBeat.o(80515);
  }
  
  public final void bGq()
  {
    AppMethodBeat.i(80516);
    if ((this.CCq) && (this.nfP != null)) {
      this.nfP.j(this.nfN);
    }
    AppMethodBeat.o(80516);
  }
  
  public final void bGr()
  {
    AppMethodBeat.i(80517);
    if ((this.CCq) && (this.nfP != null)) {
      this.nfP.k(this.nfN);
    }
    AppMethodBeat.o(80517);
  }
  
  public final boolean bGx()
  {
    return true;
  }
  
  public final boolean bcV()
  {
    AppMethodBeat.i(80501);
    if ((this.CBb.eAu()) && (this.ngF.bcV()))
    {
      AppMethodBeat.o(80501);
      return true;
    }
    AppMethodBeat.o(80501);
    return false;
  }
  
  public final boolean bcW()
  {
    AppMethodBeat.i(210072);
    boolean bool = this.CBb.eAu();
    AppMethodBeat.o(210072);
    return bool;
  }
  
  public final void bcX()
  {
    AppMethodBeat.i(80507);
    ac.i("MicroMsg.WebViewFloatBallHelper", "onEnterPage, WebViewUI:%s, isEntered: %b", new Object[] { Integer.valueOf(this.CBb.hashCode()), Boolean.valueOf(this.CCr) });
    if (!this.CCr)
    {
      this.CCr = true;
      super.bcX();
    }
    AppMethodBeat.o(80507);
  }
  
  public final void bcY()
  {
    AppMethodBeat.i(80508);
    ac.i("MicroMsg.WebViewFloatBallHelper", "onExitPage, WebViewUI:%s", new Object[] { Integer.valueOf(this.CBb.hashCode()) });
    if (((this.CBb instanceof com.tencent.mm.plugin.webview.g.a.a)) && (bGo()))
    {
      int i = ((com.tencent.mm.plugin.webview.g.a.a)this.CBb).bNa();
      if ((this.nfN != null) && (this.nfN.hSN != null))
      {
        this.nfN.hSN.putInt("BizVideoPlayTime", i);
        bGr();
      }
    }
    super.bcY();
    this.CCr = false;
    AppMethodBeat.o(80508);
  }
  
  public final void bcZ()
  {
    AppMethodBeat.i(80510);
    ac.i("MicroMsg.WebViewFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, WebViewUI:%s", new Object[] { Integer.valueOf(this.CBb.hashCode()) });
    this.ngF.gb(false);
    AppMethodBeat.o(80510);
  }
  
  public final void bda()
  {
    AppMethodBeat.i(80509);
    ac.i("MicroMsg.WebViewFloatBallHelper", "onReceivedBallInfoRemovedEvent, WebViewUI:%s", new Object[] { Integer.valueOf(this.CBb.hashCode()) });
    super.bda();
    AppMethodBeat.o(80509);
  }
  
  public final boolean bde()
  {
    AppMethodBeat.i(188503);
    if ((!this.CCs) && (this.CBb.eAu()))
    {
      AppMethodBeat.o(188503);
      return true;
    }
    AppMethodBeat.o(188503);
    return false;
  }
  
  public final void eEP()
  {
    AppMethodBeat.i(80502);
    if (this.ngH != null) {
      this.ngH.stop();
    }
    this.CCs = true;
    AppMethodBeat.o(80502);
  }
  
  public final int eEQ()
  {
    AppMethodBeat.i(80520);
    if ((this.nfN != null) && (this.nfN.hSN != null))
    {
      int i = this.nfN.hSN.getInt("BizVideoPlayTime", 0);
      AppMethodBeat.o(80520);
      return i;
    }
    AppMethodBeat.o(80520);
    return 0;
  }
  
  public final String getName()
  {
    if (this.nfN != null) {
      return this.nfN.name;
    }
    return null;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(80506);
    ac.i("MicroMsg.WebViewFloatBallHelper", "onDestroy, WebViewUI:%s", new Object[] { Integer.valueOf(this.CBb.hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(80506);
  }
  
  public final boolean rT(int paramInt)
  {
    AppMethodBeat.i(80505);
    ac.i("MicroMsg.WebViewFloatBallHelper", "onClose, WebViewUI:%s", new Object[] { Integer.valueOf(this.CBb.hashCode()) });
    boolean bool = super.rT(paramInt);
    AppMethodBeat.o(80505);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.b.a
 * JD-Core Version:    0.7.0.1
 */