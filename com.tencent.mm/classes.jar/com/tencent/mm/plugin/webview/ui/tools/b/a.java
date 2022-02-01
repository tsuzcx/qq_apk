package com.tencent.mm.plugin.webview.ui.tools.b;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.ball.ui.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.e.m;
import java.util.HashSet;
import java.util.Set;

public final class a
  extends com.tencent.mm.plugin.ball.service.f
{
  private static final Set<String> AUq;
  private static com.tencent.mm.plugin.ball.c.f jpa;
  public WebViewUI BiO;
  private boolean Bkc;
  private boolean Bkd;
  
  static
  {
    AppMethodBeat.i(80523);
    HashSet localHashSet = new HashSet();
    AUq = localHashSet;
    localHashSet.add("title");
    AUq.add("webpageTitle");
    AUq.add("hide_option_menu");
    AUq.add("translate_webview");
    AUq.add("srcUsername");
    AUq.add("srcDisplayname");
    AUq.add("mode");
    AUq.add("KTemplateId");
    AUq.add("KPublisherId");
    AUq.add(e.m.FIp);
    AUq.add(e.m.FIq);
    AUq.add("pay_channel");
    AUq.add("key_download_restrict");
    AUq.add("key_wallet_region");
    AUq.add("key_function_id");
    AUq.add(e.m.FIt);
    AUq.add("geta8key_scene");
    AUq.add("biz_video_msg_id");
    AUq.add("biz_video_msg_index");
    AUq.add("biz_video_msg_svr_id");
    AUq.add("biz_mp_msg_info");
    AUq.add(e.m.FIB);
    jpa = new com.tencent.mm.plugin.ball.c.g()
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
        ad.i("MicroMsg.WebViewFloatBallHelper", "onFloatBallInfoExposed, ballInfo:%s", new Object[] { paramAnonymousBallInfo });
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
    this.Bkd = false;
    this.BiO = paramWebViewUI;
    ad.i("MicroMsg.WebViewFloatBallHelper", "createFloatBallHelper, WebViewUI:%s", new Object[] { Integer.valueOf(paramWebViewUI.hashCode()) });
    AppMethodBeat.o(80499);
  }
  
  public static void aWo()
  {
    AppMethodBeat.i(80511);
    if (com.tencent.mm.kernel.g.ab(c.class) != null) {
      ((c)com.tencent.mm.kernel.g.ab(c.class)).a(2, jpa);
    }
    AppMethodBeat.o(80511);
  }
  
  public static void aWp()
  {
    AppMethodBeat.i(80512);
    if (com.tencent.mm.kernel.g.ab(c.class) != null) {
      ((c)com.tencent.mm.kernel.g.ab(c.class)).b(2, jpa);
    }
    AppMethodBeat.o(80512);
  }
  
  public static boolean isMpUrl(String paramString)
  {
    AppMethodBeat.i(80503);
    if (!bt.isNullOrNil(paramString))
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
  
  public final void OE(String paramString)
  {
    AppMethodBeat.i(80513);
    if ((this.mDH != null) && (!bt.isNullOrNil(this.mDH.name)) && (!this.mDH.name.startsWith("http://")) && (!this.mDH.name.startsWith("https://")) && (!bt.isNullOrNil(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      AppMethodBeat.o(80513);
      return;
    }
    super.OE(paramString);
    AppMethodBeat.o(80513);
  }
  
  public final void Z(int paramInt, String paramString)
  {
    AppMethodBeat.i(80504);
    this.Bkc = true;
    ad.i("MicroMsg.WebViewFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.Z(paramInt, paramString);
    bzz().mDz = 3;
    if (this.BiO.bFk()) {}
    for (bzz().mDy = this.BiO.getIntent().getIntExtra(e.m.FIp, 10000);; bzz().mDy = this.BiO.beH())
    {
      if (isMpUrl(this.BiO.bEx())) {
        bzz().gWU = this.BiO.getIntent().getStringExtra("srcUsername");
      }
      ad.d("MicroMsg.WebViewFloatBallHelper", "initReportInfo generateScene %d", new Object[] { Integer.valueOf(bzz().mDy) });
      bzv();
      if ((this.mEA.getIntent() != null) && (this.mDH.hsl != null))
      {
        com.tencent.mm.plugin.ball.f.a.b(this.mEA.getIntent(), this.mDH.hsl, AUq);
        bzv();
      }
      AppMethodBeat.o(80504);
      return;
    }
  }
  
  public final boolean aVX()
  {
    AppMethodBeat.i(80501);
    if ((this.BiO.ekY()) && (this.mEA.aVX()))
    {
      AppMethodBeat.o(80501);
      return true;
    }
    AppMethodBeat.o(80501);
    return false;
  }
  
  public final boolean aVY()
  {
    AppMethodBeat.i(197146);
    boolean bool = this.BiO.ekY();
    AppMethodBeat.o(197146);
    return bool;
  }
  
  public final void aVZ()
  {
    AppMethodBeat.i(80507);
    ad.i("MicroMsg.WebViewFloatBallHelper", "onEnterPage, WebViewUI:%s, isEntered: %b", new Object[] { Integer.valueOf(this.BiO.hashCode()), Boolean.valueOf(this.Bkd) });
    if (!this.Bkd)
    {
      this.Bkd = true;
      super.aVZ();
    }
    AppMethodBeat.o(80507);
  }
  
  public final void aWa()
  {
    AppMethodBeat.i(80508);
    ad.i("MicroMsg.WebViewFloatBallHelper", "onExitPage, WebViewUI:%s", new Object[] { Integer.valueOf(this.BiO.hashCode()) });
    if (((this.BiO instanceof com.tencent.mm.plugin.webview.g.a.a)) && (bzs()))
    {
      int i = ((com.tencent.mm.plugin.webview.g.a.a)this.BiO).bFN();
      if ((this.mDH != null) && (this.mDH.hsl != null))
      {
        this.mDH.hsl.putInt("BizVideoPlayTime", i);
        bzv();
      }
    }
    super.aWa();
    this.Bkd = false;
    AppMethodBeat.o(80508);
  }
  
  public final void aWb()
  {
    AppMethodBeat.i(80510);
    ad.i("MicroMsg.WebViewFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, WebViewUI:%s", new Object[] { Integer.valueOf(this.BiO.hashCode()) });
    this.mEA.fF(false);
    AppMethodBeat.o(80510);
  }
  
  public final void aWc()
  {
    AppMethodBeat.i(80509);
    ad.i("MicroMsg.WebViewFloatBallHelper", "onReceivedBallInfoRemovedEvent, WebViewUI:%s", new Object[] { Integer.valueOf(this.BiO.hashCode()) });
    super.aWc();
    AppMethodBeat.o(80509);
  }
  
  public final boolean aWg()
  {
    AppMethodBeat.i(188068);
    boolean bool = this.BiO.ekY();
    AppMethodBeat.o(188068);
    return bool;
  }
  
  public final void awh(String paramString)
  {
    AppMethodBeat.i(80518);
    bzz().dnC = paramString;
    bzv();
    AppMethodBeat.o(80518);
  }
  
  public final void ayd(String paramString)
  {
    AppMethodBeat.i(80519);
    bzz().mDz = 9;
    bzz().mDA = paramString;
    bzv();
    AppMethodBeat.o(80519);
  }
  
  public final boolean bzB()
  {
    return true;
  }
  
  public final void bzl()
  {
    AppMethodBeat.i(188067);
    if (!this.Bkd) {
      super.bzl();
    }
    AppMethodBeat.o(188067);
  }
  
  public final BallInfo bzo()
  {
    AppMethodBeat.i(80514);
    BallInfo localBallInfo = super.bzo();
    AppMethodBeat.o(80514);
    return localBallInfo;
  }
  
  public final void bzt()
  {
    AppMethodBeat.i(80515);
    if ((this.Bkc) && (this.mDJ != null)) {
      this.mDJ.k(this.mDH);
    }
    AppMethodBeat.o(80515);
  }
  
  public final void bzu()
  {
    AppMethodBeat.i(80516);
    if ((this.Bkc) && (this.mDJ != null)) {
      this.mDJ.i(this.mDH);
    }
    AppMethodBeat.o(80516);
  }
  
  public final void bzv()
  {
    AppMethodBeat.i(80517);
    if ((this.Bkc) && (this.mDJ != null)) {
      this.mDJ.j(this.mDH);
    }
    AppMethodBeat.o(80517);
  }
  
  public final void epu()
  {
    AppMethodBeat.i(80502);
    if (this.mEC != null) {
      this.mEC.stop();
    }
    AppMethodBeat.o(80502);
  }
  
  public final int epv()
  {
    AppMethodBeat.i(80520);
    if ((this.mDH != null) && (this.mDH.hsl != null))
    {
      int i = this.mDH.hsl.getInt("BizVideoPlayTime", 0);
      AppMethodBeat.o(80520);
      return i;
    }
    AppMethodBeat.o(80520);
    return 0;
  }
  
  public final String getName()
  {
    if (this.mDH != null) {
      return this.mDH.name;
    }
    return null;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(80506);
    ad.i("MicroMsg.WebViewFloatBallHelper", "onDestroy, WebViewUI:%s", new Object[] { Integer.valueOf(this.BiO.hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(80506);
  }
  
  public final boolean rg(int paramInt)
  {
    AppMethodBeat.i(80505);
    ad.i("MicroMsg.WebViewFloatBallHelper", "onClose, WebViewUI:%s", new Object[] { Integer.valueOf(this.BiO.hashCode()) });
    boolean bool = super.rg(paramInt);
    AppMethodBeat.o(80505);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.b.a
 * JD-Core Version:    0.7.0.1
 */