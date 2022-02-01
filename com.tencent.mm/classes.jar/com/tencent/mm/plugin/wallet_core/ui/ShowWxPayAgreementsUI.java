package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.aa;

@com.tencent.mm.ui.base.a(3)
public class ShowWxPayAgreementsUI
  extends MMActivity
{
  private TextView OVo;
  private TextView OVp;
  private String content;
  private int type;
  private MMWebView wIY;
  
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
    h.IzE.a(15236, new Object[] { Integer.valueOf(1) });
    getSupportActionBar().hide();
    overridePendingTransition(a.a.push_up_in, a.a.anim_not_change);
    this.type = getIntent().getIntExtra("agreement_type", 0);
    this.wIY = MMWebView.a.a(this, getContentView(), a.f.agreement_webview);
    this.wIY.getSettings().setJavaScriptEnabled(true);
    this.OVo = ((TextView)findViewById(a.f.agreement_disagree_btn));
    this.OVp = ((TextView)findViewById(a.f.agreement_agree_btn));
    this.content = getIntent().getStringExtra("agreement_content");
    this.OVp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70682);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/ShowWxPayAgreementsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        h.IzE.a(15236, new Object[] { Integer.valueOf(2) });
        ShowWxPayAgreementsUI.this.setResult(-1);
        ShowWxPayAgreementsUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/ShowWxPayAgreementsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70682);
      }
    });
    this.OVo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70683);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/ShowWxPayAgreementsUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        h.IzE.a(15236, new Object[] { Integer.valueOf(3) });
        ShowWxPayAgreementsUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/ShowWxPayAgreementsUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70683);
      }
    });
    this.wIY.setWebViewClient(new j(this));
    if (getContext().getApplicationInfo().targetSdkVersion >= 29)
    {
      String str = Base64.encodeToString(this.content.getBytes(), 0);
      this.wIY.loadData(str, "text/html; charset=UTF-8", "base64");
      AppMethodBeat.o(70685);
      return;
    }
    this.wIY.loadData(this.content, "text/html; charset=UTF-8", null);
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
    AppMethodBeat.i(274233);
    super.onDestroy();
    if (this.wIY != null) {
      this.wIY.destroy();
    }
    AppMethodBeat.o(274233);
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