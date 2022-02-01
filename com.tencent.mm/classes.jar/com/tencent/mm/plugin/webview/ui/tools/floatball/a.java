package com.tencent.mm.plugin.webview.ui.tools.floatball;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.ball.ui.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.e.m;
import java.util.HashSet;
import java.util.Set;

public final class a
  extends com.tencent.mm.plugin.ball.service.f
{
  private static final Set<String> EhY;
  private static com.tencent.mm.plugin.ball.c.f kmM;
  public WebViewUI EwL;
  private boolean Eya;
  private boolean Eyb;
  private boolean Eyc;
  
  static
  {
    AppMethodBeat.i(80523);
    HashSet localHashSet = new HashSet();
    EhY = localHashSet;
    localHashSet.add("title");
    EhY.add("webpageTitle");
    EhY.add("hide_option_menu");
    EhY.add("translate_webview");
    EhY.add("srcUsername");
    EhY.add("srcDisplayname");
    EhY.add("mode");
    EhY.add("KTemplateId");
    EhY.add("KPublisherId");
    EhY.add(e.m.Jpv);
    EhY.add(e.m.Jpw);
    EhY.add("pay_channel");
    EhY.add("key_download_restrict");
    EhY.add("key_wallet_region");
    EhY.add("key_function_id");
    EhY.add(e.m.Jpz);
    EhY.add("geta8key_scene");
    EhY.add("biz_video_msg_id");
    EhY.add("biz_video_msg_index");
    EhY.add("biz_video_msg_svr_id");
    EhY.add("biz_mp_msg_info");
    EhY.add(e.m.JpH);
    EhY.add("key_menu_hide_expose");
    kmM = new com.tencent.mm.plugin.ball.c.g()
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
        ae.i("MicroMsg.WebViewFloatBallHelper", "onFloatBallInfoExposed, ballInfo:%s", new Object[] { paramAnonymousBallInfo });
        a.Q(paramAnonymousBallInfo);
        AppMethodBeat.o(80498);
      }
    };
    AppMethodBeat.o(80523);
  }
  
  public a(com.tencent.mm.plugin.ball.a.f paramf, WebViewUI paramWebViewUI)
  {
    super(paramf);
    AppMethodBeat.i(80499);
    this.Eyb = false;
    this.Eyc = false;
    this.EwL = paramWebViewUI;
    ae.i("MicroMsg.WebViewFloatBallHelper", "createFloatBallHelper, WebViewUI:%s", new Object[] { Integer.valueOf(paramWebViewUI.hashCode()) });
    AppMethodBeat.o(80499);
  }
  
  public static void bhy()
  {
    AppMethodBeat.i(80511);
    if (com.tencent.mm.kernel.g.ab(c.class) != null) {
      ((c)com.tencent.mm.kernel.g.ab(c.class)).a(2, kmM);
    }
    AppMethodBeat.o(80511);
  }
  
  public static void bhz()
  {
    AppMethodBeat.i(80512);
    if (com.tencent.mm.kernel.g.ab(c.class) != null) {
      ((c)com.tencent.mm.kernel.g.ab(c.class)).b(2, kmM);
    }
    AppMethodBeat.o(80512);
  }
  
  public static boolean isMpUrl(String paramString)
  {
    AppMethodBeat.i(80503);
    if (!bu.isNullOrNil(paramString))
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
  
  public final void WY(String paramString)
  {
    AppMethodBeat.i(80513);
    if ((this.nLK != null) && (!bu.isNullOrNil(this.nLK.name)) && (!this.nLK.name.startsWith("http://")) && (!this.nLK.name.startsWith("https://")) && (!bu.isNullOrNil(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      AppMethodBeat.o(80513);
      return;
    }
    super.WY(paramString);
    AppMethodBeat.o(80513);
  }
  
  public final void aIr(String paramString)
  {
    AppMethodBeat.i(80518);
    bLD().dyc = paramString;
    bLz();
    AppMethodBeat.o(80518);
  }
  
  public final void aKo(String paramString)
  {
    AppMethodBeat.i(80519);
    bLD().nLC = 9;
    bLD().nLD = paramString;
    bLz();
    AppMethodBeat.o(80519);
  }
  
  public final void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(80504);
    this.Eya = true;
    ae.i("MicroMsg.WebViewFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.ac(paramInt, paramString);
    bLD().nLC = 3;
    if (this.EwL.bRY()) {}
    for (bLD().nLB = this.EwL.getIntent().getIntExtra(e.m.Jpv, 10000);; bLD().nLB = this.EwL.bpW())
    {
      if (isMpUrl(this.EwL.bRn())) {
        bLD().hSG = this.EwL.getIntent().getStringExtra("srcUsername");
      }
      ae.d("MicroMsg.WebViewFloatBallHelper", "initReportInfo generateScene %d", new Object[] { Integer.valueOf(bLD().nLB) });
      bLz();
      if ((this.nME.getIntent() != null) && (this.nLK.ioY != null))
      {
        com.tencent.mm.plugin.ball.f.a.b(this.nME.getIntent(), this.nLK.ioY, EhY);
        bLz();
      }
      AppMethodBeat.o(80504);
      return;
    }
  }
  
  public final boolean bLF()
  {
    return true;
  }
  
  public final void bLp()
  {
    AppMethodBeat.i(198329);
    if (!this.Eyb) {
      super.bLp();
    }
    AppMethodBeat.o(198329);
  }
  
  public final BallInfo bLs()
  {
    AppMethodBeat.i(80514);
    BallInfo localBallInfo = super.bLs();
    AppMethodBeat.o(80514);
    return localBallInfo;
  }
  
  public final void bLx()
  {
    AppMethodBeat.i(80515);
    if ((this.Eya) && (this.nLM != null)) {
      this.nLM.m(this.nLK);
    }
    AppMethodBeat.o(80515);
  }
  
  public final void bLy()
  {
    AppMethodBeat.i(80516);
    if ((this.Eya) && (this.nLM != null)) {
      this.nLM.k(this.nLK);
    }
    AppMethodBeat.o(80516);
  }
  
  public final void bLz()
  {
    AppMethodBeat.i(80517);
    if ((this.Eya) && (this.nLM != null)) {
      this.nLM.l(this.nLK);
    }
    AppMethodBeat.o(80517);
  }
  
  public final boolean bhh()
  {
    AppMethodBeat.i(80501);
    if ((this.EwL.eSW()) && (this.nME.bhh()))
    {
      AppMethodBeat.o(80501);
      return true;
    }
    AppMethodBeat.o(80501);
    return false;
  }
  
  public final boolean bhi()
  {
    AppMethodBeat.i(224330);
    boolean bool = this.EwL.eSW();
    AppMethodBeat.o(224330);
    return bool;
  }
  
  public final void bhj()
  {
    AppMethodBeat.i(80507);
    ae.i("MicroMsg.WebViewFloatBallHelper", "onEnterPage, WebViewUI:%s, isEntered: %b", new Object[] { Integer.valueOf(this.EwL.hashCode()), Boolean.valueOf(this.Eyb) });
    if (!this.Eyb)
    {
      this.Eyb = true;
      super.bhj();
    }
    AppMethodBeat.o(80507);
  }
  
  public final void bhk()
  {
    AppMethodBeat.i(80508);
    ae.i("MicroMsg.WebViewFloatBallHelper", "onExitPage, WebViewUI:%s", new Object[] { Integer.valueOf(this.EwL.hashCode()) });
    if (((this.EwL instanceof com.tencent.mm.plugin.webview.g.a.a)) && (bLw()))
    {
      int i = ((com.tencent.mm.plugin.webview.g.a.a)this.EwL).bSB();
      if ((this.nLK != null) && (this.nLK.ioY != null))
      {
        this.nLK.ioY.putInt("BizVideoPlayTime", i);
        bLz();
      }
    }
    super.bhk();
    this.Eyb = false;
    AppMethodBeat.o(80508);
  }
  
  public final void bhl()
  {
    AppMethodBeat.i(80510);
    ae.i("MicroMsg.WebViewFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, WebViewUI:%s", new Object[] { Integer.valueOf(this.EwL.hashCode()) });
    this.nME.ge(false);
    AppMethodBeat.o(80510);
  }
  
  public final void bhm()
  {
    AppMethodBeat.i(80509);
    ae.i("MicroMsg.WebViewFloatBallHelper", "onReceivedBallInfoRemovedEvent, WebViewUI:%s", new Object[] { Integer.valueOf(this.EwL.hashCode()) });
    super.bhm();
    AppMethodBeat.o(80509);
  }
  
  public final boolean bhq()
  {
    AppMethodBeat.i(198330);
    if ((!this.Eyc) && (this.EwL.eSW()))
    {
      AppMethodBeat.o(198330);
      return true;
    }
    AppMethodBeat.o(198330);
    return false;
  }
  
  public final void eXu()
  {
    AppMethodBeat.i(80502);
    if (this.nMG != null) {
      this.nMG.stop();
    }
    this.Eyc = true;
    AppMethodBeat.o(80502);
  }
  
  public final int eXv()
  {
    AppMethodBeat.i(80520);
    if ((this.nLK != null) && (this.nLK.ioY != null))
    {
      int i = this.nLK.ioY.getInt("BizVideoPlayTime", 0);
      AppMethodBeat.o(80520);
      return i;
    }
    AppMethodBeat.o(80520);
    return 0;
  }
  
  public final String getName()
  {
    if (this.nLK != null) {
      return this.nLK.name;
    }
    return null;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(80506);
    ae.i("MicroMsg.WebViewFloatBallHelper", "onDestroy, WebViewUI:%s", new Object[] { Integer.valueOf(this.EwL.hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(80506);
  }
  
  public final boolean sy(int paramInt)
  {
    AppMethodBeat.i(80505);
    ae.i("MicroMsg.WebViewFloatBallHelper", "onClose, WebViewUI:%s", new Object[] { Integer.valueOf(this.EwL.hashCode()) });
    boolean bool = super.sy(paramInt);
    AppMethodBeat.o(80505);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.floatball.a
 * JD-Core Version:    0.7.0.1
 */