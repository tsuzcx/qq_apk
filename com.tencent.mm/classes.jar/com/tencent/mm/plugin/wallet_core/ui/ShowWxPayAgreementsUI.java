package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aeh;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.k.m;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.pulldown.c;
import com.tencent.xweb.ad;

@com.tencent.mm.ui.base.a(3)
@c(0)
public class ShowWxPayAgreementsUI
  extends MMActivity
{
  private MMWebView Aft;
  private Button VLB;
  private Button VLC;
  private View VLD;
  private String VLE;
  private String content;
  private int type;
  
  public void finish()
  {
    AppMethodBeat.i(70686);
    Log.i("MicroMsg.ShowWxPayAgreementsUI", "onRefreshed");
    super.finish();
    overridePendingTransition(a.a.anim_not_change, a.a.push_down_out);
    AppMethodBeat.o(70686);
  }
  
  public int getLayoutId()
  {
    return a.g.show_wxpayagreements_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70685);
    h.OAn.b(15236, new Object[] { Integer.valueOf(1) });
    getSupportActionBar().hide();
    overridePendingTransition(a.a.push_up_in, a.a.anim_not_change);
    this.type = getIntent().getIntExtra("agreement_type", 0);
    this.Aft = MMWebView.a.b(this, getContentView(), a.f.agreement_webview);
    this.Aft.getSettings().setJavaScriptEnabled(true);
    this.VLB = ((Button)findViewById(a.f.agreement_disagree_btn));
    this.VLC = ((Button)findViewById(a.f.agreement_agree_btn));
    this.content = getIntent().getStringExtra("agreement_content");
    this.VLE = getIntent().getStringExtra("agreement_content_darkmode");
    this.VLD = findViewById(a.f.agree_guide_mask);
    label173:
    String str;
    if (aw.isDarkMode())
    {
      this.VLD.setBackground(getContext().getResources().getDrawable(a.h.wxpay_agreement_bg_dark));
      this.VLC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70682);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/ShowWxPayAgreementsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new aeh();
          paramAnonymousView.iiT.hCQ = true;
          paramAnonymousView.publish();
          h.OAn.b(15236, new Object[] { Integer.valueOf(2) });
          ShowWxPayAgreementsUI.this.setResult(-1);
          ShowWxPayAgreementsUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/ShowWxPayAgreementsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70682);
        }
      });
      this.VLB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70683);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/ShowWxPayAgreementsUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new aeh();
          paramAnonymousView.iiT.hCQ = false;
          paramAnonymousView.publish();
          h.OAn.b(15236, new Object[] { Integer.valueOf(3) });
          ShowWxPayAgreementsUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/ShowWxPayAgreementsUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70683);
        }
      });
      this.Aft.setWebViewClient(new k(this));
      if ((!aw.isDarkMode()) || (Util.isNullOrNil(this.VLE))) {
        break label401;
      }
      str = this.VLE;
      label239:
      if (getContext().getApplicationInfo().targetSdkVersion < 29) {
        break label409;
      }
      str = Base64.encodeToString(str.getBytes(), 0);
      this.Aft.loadData(str, "text/html; charset=UTF-8", "base64");
    }
    for (;;)
    {
      int j = m.lg(getContext());
      int i;
      if (j > 0)
      {
        i = j;
        if (j <= 8) {}
      }
      else
      {
        i = 2;
      }
      Log.i("MicroMsg.ShowWxPayAgreementsUI", "localSetFontSize, fontSize = ".concat(String.valueOf(i)));
      switch (i)
      {
      default: 
        this.Aft.getSettings().setTextZoom(100);
        AppMethodBeat.o(70685);
        return;
        this.VLD.setBackground(getContext().getResources().getDrawable(a.h.wxpay_agreement_bg_normal));
        break label173;
        label401:
        str = this.content;
        break label239;
        label409:
        this.Aft.loadData(str, "text/html; charset=UTF-8", null);
      }
    }
    this.Aft.getSettings().setTextZoom(80);
    AppMethodBeat.o(70685);
    return;
    this.Aft.getSettings().setTextZoom(100);
    AppMethodBeat.o(70685);
    return;
    this.Aft.getSettings().setTextZoom(110);
    AppMethodBeat.o(70685);
    return;
    this.Aft.getSettings().setTextZoom(112);
    AppMethodBeat.o(70685);
    return;
    this.Aft.getSettings().setTextZoom(112);
    AppMethodBeat.o(70685);
    return;
    this.Aft.getSettings().setTextZoom(140);
    AppMethodBeat.o(70685);
    return;
    this.Aft.getSettings().setTextZoom(155);
    AppMethodBeat.o(70685);
    return;
    this.Aft.getSettings().setTextZoom(165);
    AppMethodBeat.o(70685);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70684);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(70684);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(301245);
    super.onDestroy();
    if (this.Aft != null) {
      this.Aft.destroy();
    }
    AppMethodBeat.o(301245);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(70689);
    if (paramInt == 4)
    {
      AppMethodBeat.o(70689);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(70689);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(70688);
    super.onPause();
    AppMethodBeat.o(70688);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70687);
    super.onResume();
    AppMethodBeat.o(70687);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.ShowWxPayAgreementsUI
 * JD-Core Version:    0.7.0.1
 */