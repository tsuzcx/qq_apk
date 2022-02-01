package com.tencent.mm.plugin.websearch.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.e.a;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.protocal.protobuf.mc;
import com.tencent.mm.protocal.protobuf.ml;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/websearch/ui/WebSearchImageLoadingUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "downloadImageCallback", "com/tencent/mm/plugin/websearch/ui/WebSearchImageLoadingUI$downloadImageCallback$1", "Lcom/tencent/mm/plugin/websearch/ui/WebSearchImageLoadingUI$downloadImageCallback$1;", "imgLocalId", "", "isDownloading", "", "lastRequestSession", "getLastRequestSession", "()J", "setLastRequestSession", "(J)V", "msgId", "cancelDownloadImage", "", "checkCanDownloadImage", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "getLayoutId", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onError", "reportAction", "action", "imagePath", "sessionId", "showLoading", "startImageSearch", "tryDownloadImage", "ui-websearch_release"})
public final class WebSearchImageLoadingUI
  extends MMActivity
{
  long DVk;
  private final WebSearchImageLoadingUI.b Jik;
  private final String TAG;
  private long gzw;
  private long msgId;
  private boolean zjl;
  
  public WebSearchImageLoadingUI()
  {
    AppMethodBeat.i(224541);
    this.TAG = "MicroMsg.WebSearch.WebSearchImageLoadingUI";
    this.Jik = new WebSearchImageLoadingUI.b(this);
    AppMethodBeat.o(224541);
  }
  
  private final void Gu(long paramLong)
  {
    AppMethodBeat.i(224539);
    h.MqF.aQ((Runnable)new WebSearchImageLoadingUI.g(this, paramLong));
    AppMethodBeat.o(224539);
  }
  
  private final void N(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(212510);
    com.tencent.mm.ac.c.b(null, (d.g.a.a)new WebSearchImageLoadingUI.d(this, paramString1, paramInt, paramString2));
    AppMethodBeat.o(212510);
  }
  
  private final void eUb()
  {
    AppMethodBeat.i(224540);
    ae.i(this.TAG, "cancelDownloadImage isDownloading: %b, imgLocalId: %d, msgId: %d", new Object[] { Boolean.valueOf(this.zjl), Long.valueOf(this.gzw), Long.valueOf(this.msgId) });
    if ((this.zjl) || (this.gzw != 0L)) {
      q.aIY().a(this.gzw, this.msgId, 0, (e.a)this.Jik);
    }
    AppMethodBeat.o(224540);
  }
  
  private final void ih(boolean paramBoolean)
  {
    AppMethodBeat.i(224535);
    if (this.msgId == 0L)
    {
      onError();
      AppMethodBeat.o(224535);
      return;
    }
    final String str = ((com.tencent.mm.plugin.scanner.api.b)g.ab(com.tencent.mm.plugin.scanner.api.b.class)).Gt(this.msgId);
    if (o.fB(str))
    {
      showLoading();
      long l = this.msgId;
      p.g(str, "imagePath");
      H(l, str);
      ((Button)findViewById(2131308299)).setOnClickListener((View.OnClickListener)new e(this, str));
      AppMethodBeat.o(224535);
      return;
    }
    if (paramBoolean)
    {
      Gu(this.msgId);
      AppMethodBeat.o(224535);
      return;
    }
    onError();
    AppMethodBeat.o(224535);
  }
  
  private final void onError()
  {
    AppMethodBeat.i(224537);
    View localView = findViewById(2131301502);
    p.g(localView, "findViewById<MMAnimateView>(R.id.loading_iv)");
    ((MMAnimateView)localView).setVisibility(8);
    localView = findViewById(2131308347);
    p.g(localView, "findViewById<TextView>(R.id.loading_tv)");
    ((TextView)localView).setVisibility(8);
    localView = findViewById(2131308300);
    p.g(localView, "findViewById<TextView>(R.id.error_tv)");
    ((TextView)localView).setVisibility(8);
    localView = findViewById(2131308299);
    p.g(localView, "findViewById<Button>(R.id.error_btn)");
    ((Button)localView).setVisibility(8);
    localView = findViewById(2131308302);
    p.g(localView, "findViewById<TextView>(R.id.expire_tv)");
    ((TextView)localView).setVisibility(0);
    localView = findViewById(2131308301);
    p.g(localView, "findViewById<Button>(R.id.expire_btn)");
    ((Button)localView).setVisibility(0);
    ((Button)findViewById(2131308301)).setOnClickListener((View.OnClickListener)new WebSearchImageLoadingUI.c(this));
    AppMethodBeat.o(224537);
  }
  
  private final void showLoading()
  {
    AppMethodBeat.i(224536);
    if (al.isDarkMode())
    {
      ((MMAnimateView)findViewById(2131301502)).setImageResource(2131691614);
      AppMethodBeat.o(224536);
      return;
    }
    ((MMAnimateView)findViewById(2131301502)).setImageResource(2131691615);
    AppMethodBeat.o(224536);
  }
  
  public final void H(long paramLong, String paramString)
  {
    AppMethodBeat.i(212509);
    p.h(paramString, "imagePath");
    String str = "67_" + ch.aDc();
    com.tencent.mm.plugin.scanner.api.c localc = new com.tencent.mm.plugin.scanner.api.c();
    localc.msgId = paramLong;
    localc.mode = 4;
    localc.yzO = new ml();
    localc.yzO.FXW = ad.WL(0);
    buh localbuh = ad.bOD();
    if (localbuh != null)
    {
      localc.yzP = new mc();
      localc.yzP.dBu = localbuh.GgZ;
      localc.yzP.dzE = localbuh.Gha;
      localc.yzP.FXo = localbuh.Gzf;
      localc.sessionId = System.currentTimeMillis();
    }
    this.DVk = ((com.tencent.mm.plugin.scanner.api.b)g.ab(com.tencent.mm.plugin.scanner.api.b.class)).a(localc, (com.tencent.mm.plugin.scanner.api.e)new WebSearchImageLoadingUI.f(this, str));
    N(2, paramString, str);
    AppMethodBeat.o(212509);
  }
  
  public final int getLayoutId()
  {
    return 2131496503;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(224538);
    super.onBackPressed();
    eUb();
    AppMethodBeat.o(224538);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(212508);
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new WebSearchImageLoadingUI.a(this), 2131690535);
    setMMTitle("");
    this.msgId = getIntent().getLongExtra("key_msg_id", 0L);
    ih(true);
    AppMethodBeat.o(212508);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(212511);
    if (this.DVk != 0L) {
      ((com.tencent.mm.plugin.scanner.api.b)g.ab(com.tencent.mm.plugin.scanner.api.b.class)).zr(this.DVk);
    }
    super.onDestroy();
    AppMethodBeat.o(212511);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(WebSearchImageLoadingUI paramWebSearchImageLoadingUI, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(224528);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/ui/WebSearchImageLoadingUI$startImageSearch$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = this.DVl.findViewById(2131301502);
      p.g(paramView, "findViewById<MMAnimateView>(R.id.loading_iv)");
      ((MMAnimateView)paramView).setVisibility(0);
      paramView = this.DVl.findViewById(2131308347);
      p.g(paramView, "findViewById<TextView>(R.id.loading_tv)");
      ((TextView)paramView).setVisibility(0);
      paramView = this.DVl.findViewById(2131308300);
      p.g(paramView, "findViewById<TextView>(R.id.error_tv)");
      ((TextView)paramView).setVisibility(8);
      paramView = this.DVl.findViewById(2131308299);
      p.g(paramView, "findViewById<Button>(R.id.error_btn)");
      ((Button)paramView).setVisibility(8);
      paramView = this.DVl;
      long l = WebSearchImageLoadingUI.c(this.DVl);
      localObject = str;
      p.g(localObject, "imagePath");
      paramView.H(l, (String)localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/ui/WebSearchImageLoadingUI$startImageSearch$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(224528);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchImageLoadingUI
 * JD-Core Version:    0.7.0.1
 */