package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.z;

@com.tencent.mm.ui.base.a(3)
public class ShowWxPayAgreementsUI
  extends MMActivity
{
  private TextView DtL;
  private TextView DtM;
  private String content;
  private MMWebView rDi;
  private int type;
  
  public void finish()
  {
    AppMethodBeat.i(70686);
    ae.i("MicroMsg.ShowWxPayAgreementsUI", "onRefreshed");
    super.finish();
    overridePendingTransition(2130771986, 2130772106);
    AppMethodBeat.o(70686);
  }
  
  public int getLayoutId()
  {
    return 2131495444;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70685);
    g.yxI.f(15236, new Object[] { Integer.valueOf(1) });
    getSupportActionBar().hide();
    overridePendingTransition(2130772108, 2130771986);
    this.type = getIntent().getIntExtra("agreement_type", 0);
    this.rDi = MMWebView.a.a(this, getContentView(), 2131296526);
    this.rDi.getSettings().setJavaScriptEnabled(true);
    this.DtL = ((TextView)findViewById(2131296524));
    this.DtM = ((TextView)findViewById(2131296521));
    this.content = getIntent().getStringExtra("agreement_content");
    this.DtM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70682);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/ShowWxPayAgreementsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        g.yxI.f(15236, new Object[] { Integer.valueOf(2) });
        ShowWxPayAgreementsUI.this.setResult(-1);
        ShowWxPayAgreementsUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/ShowWxPayAgreementsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70682);
      }
    });
    this.DtL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70683);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/ShowWxPayAgreementsUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        g.yxI.f(15236, new Object[] { Integer.valueOf(3) });
        ShowWxPayAgreementsUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/ShowWxPayAgreementsUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70683);
      }
    });
    this.rDi.setWebViewClient(new i(this));
    this.rDi.loadData(this.content, "text/html; charset=UTF-8", null);
    AppMethodBeat.o(70685);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70684);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(70684);
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