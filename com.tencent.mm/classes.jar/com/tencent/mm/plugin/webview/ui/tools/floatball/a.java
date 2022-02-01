package com.tencent.mm.plugin.webview.ui.tools.floatball;

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
  private static final Set<String> DPY;
  private static com.tencent.mm.plugin.ball.c.f kjw;
  public WebViewUI EeJ;
  private boolean EfX;
  private boolean EfY;
  private boolean EfZ;
  
  static
  {
    AppMethodBeat.i(80523);
    HashSet localHashSet = new HashSet();
    DPY = localHashSet;
    localHashSet.add("title");
    DPY.add("webpageTitle");
    DPY.add("hide_option_menu");
    DPY.add("translate_webview");
    DPY.add("srcUsername");
    DPY.add("srcDisplayname");
    DPY.add("mode");
    DPY.add("KTemplateId");
    DPY.add("KPublisherId");
    DPY.add(e.m.IUN);
    DPY.add(e.m.IUO);
    DPY.add("pay_channel");
    DPY.add("key_download_restrict");
    DPY.add("key_wallet_region");
    DPY.add("key_function_id");
    DPY.add(e.m.IUR);
    DPY.add("geta8key_scene");
    DPY.add("biz_video_msg_id");
    DPY.add("biz_video_msg_index");
    DPY.add("biz_video_msg_svr_id");
    DPY.add("biz_mp_msg_info");
    DPY.add(e.m.IUZ);
    DPY.add("key_menu_hide_expose");
    kjw = new com.tencent.mm.plugin.ball.c.g()
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
        a.O(paramAnonymousBallInfo);
        AppMethodBeat.o(80498);
      }
    };
    AppMethodBeat.o(80523);
  }
  
  public a(com.tencent.mm.plugin.ball.a.f paramf, WebViewUI paramWebViewUI)
  {
    super(paramf);
    AppMethodBeat.i(80499);
    this.EfY = false;
    this.EfZ = false;
    this.EeJ = paramWebViewUI;
    ad.i("MicroMsg.WebViewFloatBallHelper", "createFloatBallHelper, WebViewUI:%s", new Object[] { Integer.valueOf(paramWebViewUI.hashCode()) });
    AppMethodBeat.o(80499);
  }
  
  public static void bgQ()
  {
    AppMethodBeat.i(80511);
    if (com.tencent.mm.kernel.g.ab(c.class) != null) {
      ((c)com.tencent.mm.kernel.g.ab(c.class)).a(2, kjw);
    }
    AppMethodBeat.o(80511);
  }
  
  public static void bgR()
  {
    AppMethodBeat.i(80512);
    if (com.tencent.mm.kernel.g.ab(c.class) != null) {
      ((c)com.tencent.mm.kernel.g.ab(c.class)).b(2, kjw);
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
  
  public final void Wm(String paramString)
  {
    AppMethodBeat.i(80513);
    if ((this.nGj != null) && (!bt.isNullOrNil(this.nGj.name)) && (!this.nGj.name.startsWith("http://")) && (!this.nGj.name.startsWith("https://")) && (!bt.isNullOrNil(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      AppMethodBeat.o(80513);
      return;
    }
    super.Wm(paramString);
    AppMethodBeat.o(80513);
  }
  
  public final void aGX(String paramString)
  {
    AppMethodBeat.i(80518);
    bKG().dwX = paramString;
    bKC();
    AppMethodBeat.o(80518);
  }
  
  public final void aIV(String paramString)
  {
    AppMethodBeat.i(80519);
    bKG().nGc = 9;
    bKG().nGd = paramString;
    bKC();
    AppMethodBeat.o(80519);
  }
  
  public final void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(80504);
    this.EfX = true;
    ad.i("MicroMsg.WebViewFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.ac(paramInt, paramString);
    bKG().nGc = 3;
    if (this.EeJ.bQX()) {}
    for (bKG().nGb = this.EeJ.getIntent().getIntExtra(e.m.IUN, 10000);; bKG().nGb = this.EeJ.bpm())
    {
      if (isMpUrl(this.EeJ.bQm())) {
        bKG().hPO = this.EeJ.getIntent().getStringExtra("srcUsername");
      }
      ad.d("MicroMsg.WebViewFloatBallHelper", "initReportInfo generateScene %d", new Object[] { Integer.valueOf(bKG().nGb) });
      bKC();
      if ((this.nHb.getIntent() != null) && (this.nGj.ime != null))
      {
        com.tencent.mm.plugin.ball.f.a.b(this.nHb.getIntent(), this.nGj.ime, DPY);
        bKC();
      }
      AppMethodBeat.o(80504);
      return;
    }
  }
  
  public final void bKA()
  {
    AppMethodBeat.i(80515);
    if ((this.EfX) && (this.nGl != null)) {
      this.nGl.m(this.nGj);
    }
    AppMethodBeat.o(80515);
  }
  
  public final void bKB()
  {
    AppMethodBeat.i(80516);
    if ((this.EfX) && (this.nGl != null)) {
      this.nGl.k(this.nGj);
    }
    AppMethodBeat.o(80516);
  }
  
  public final void bKC()
  {
    AppMethodBeat.i(80517);
    if ((this.EfX) && (this.nGl != null)) {
      this.nGl.l(this.nGj);
    }
    AppMethodBeat.o(80517);
  }
  
  public final boolean bKI()
  {
    return true;
  }
  
  public final void bKs()
  {
    AppMethodBeat.i(208150);
    if (!this.EfY) {
      super.bKs();
    }
    AppMethodBeat.o(208150);
  }
  
  public final BallInfo bKv()
  {
    AppMethodBeat.i(80514);
    BallInfo localBallInfo = super.bKv();
    AppMethodBeat.o(80514);
    return localBallInfo;
  }
  
  public final boolean bgA()
  {
    AppMethodBeat.i(221647);
    boolean bool = this.EeJ.ePk();
    AppMethodBeat.o(221647);
    return bool;
  }
  
  public final void bgB()
  {
    AppMethodBeat.i(80507);
    ad.i("MicroMsg.WebViewFloatBallHelper", "onEnterPage, WebViewUI:%s, isEntered: %b", new Object[] { Integer.valueOf(this.EeJ.hashCode()), Boolean.valueOf(this.EfY) });
    if (!this.EfY)
    {
      this.EfY = true;
      super.bgB();
    }
    AppMethodBeat.o(80507);
  }
  
  public final void bgC()
  {
    AppMethodBeat.i(80508);
    ad.i("MicroMsg.WebViewFloatBallHelper", "onExitPage, WebViewUI:%s", new Object[] { Integer.valueOf(this.EeJ.hashCode()) });
    if (((this.EeJ instanceof com.tencent.mm.plugin.webview.g.a.a)) && (bKz()))
    {
      int i = ((com.tencent.mm.plugin.webview.g.a.a)this.EeJ).bRA();
      if ((this.nGj != null) && (this.nGj.ime != null))
      {
        this.nGj.ime.putInt("BizVideoPlayTime", i);
        bKC();
      }
    }
    super.bgC();
    this.EfY = false;
    AppMethodBeat.o(80508);
  }
  
  public final void bgD()
  {
    AppMethodBeat.i(80510);
    ad.i("MicroMsg.WebViewFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, WebViewUI:%s", new Object[] { Integer.valueOf(this.EeJ.hashCode()) });
    this.nHb.gg(false);
    AppMethodBeat.o(80510);
  }
  
  public final void bgE()
  {
    AppMethodBeat.i(80509);
    ad.i("MicroMsg.WebViewFloatBallHelper", "onReceivedBallInfoRemovedEvent, WebViewUI:%s", new Object[] { Integer.valueOf(this.EeJ.hashCode()) });
    super.bgE();
    AppMethodBeat.o(80509);
  }
  
  public final boolean bgI()
  {
    AppMethodBeat.i(208151);
    if ((!this.EfZ) && (this.EeJ.ePk()))
    {
      AppMethodBeat.o(208151);
      return true;
    }
    AppMethodBeat.o(208151);
    return false;
  }
  
  public final boolean bgz()
  {
    AppMethodBeat.i(80501);
    if ((this.EeJ.ePk()) && (this.nHb.bgz()))
    {
      AppMethodBeat.o(80501);
      return true;
    }
    AppMethodBeat.o(80501);
    return false;
  }
  
  public final void eTH()
  {
    AppMethodBeat.i(80502);
    if (this.nHd != null) {
      this.nHd.stop();
    }
    this.EfZ = true;
    AppMethodBeat.o(80502);
  }
  
  public final int eTI()
  {
    AppMethodBeat.i(80520);
    if ((this.nGj != null) && (this.nGj.ime != null))
    {
      int i = this.nGj.ime.getInt("BizVideoPlayTime", 0);
      AppMethodBeat.o(80520);
      return i;
    }
    AppMethodBeat.o(80520);
    return 0;
  }
  
  public final String getName()
  {
    if (this.nGj != null) {
      return this.nGj.name;
    }
    return null;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(80506);
    ad.i("MicroMsg.WebViewFloatBallHelper", "onDestroy, WebViewUI:%s", new Object[] { Integer.valueOf(this.EeJ.hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(80506);
  }
  
  public final boolean sv(int paramInt)
  {
    AppMethodBeat.i(80505);
    ad.i("MicroMsg.WebViewFloatBallHelper", "onClose, WebViewUI:%s", new Object[] { Integer.valueOf(this.EeJ.hashCode()) });
    boolean bool = super.sv(paramInt);
    AppMethodBeat.o(80505);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.floatball.a
 * JD-Core Version:    0.7.0.1
 */