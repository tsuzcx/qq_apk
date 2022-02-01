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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.y;

@a(3)
public class ShowWxPayAgreementsUI
  extends MMActivity
{
  private TextView Ajt;
  private TextView Aju;
  private String content;
  private MMWebView qco;
  private int type;
  
  public void finish()
  {
    AppMethodBeat.i(70686);
    ad.i("MicroMsg.ShowWxPayAgreementsUI", "onRefreshed");
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
    h.vKh.f(15236, new Object[] { Integer.valueOf(1) });
    getSupportActionBar().hide();
    overridePendingTransition(2130772108, 2130771986);
    this.type = getIntent().getIntExtra("agreement_type", 0);
    this.qco = MMWebView.a.a(this, getContentView(), 2131296526);
    this.qco.getSettings().setJavaScriptEnabled(true);
    this.Ajt = ((TextView)findViewById(2131296524));
    this.Aju = ((TextView)findViewById(2131296521));
    this.content = getIntent().getStringExtra("agreement_content");
    this.Aju.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70682);
        h.vKh.f(15236, new Object[] { Integer.valueOf(2) });
        ShowWxPayAgreementsUI.this.setResult(-1);
        ShowWxPayAgreementsUI.this.finish();
        AppMethodBeat.o(70682);
      }
    });
    this.Ajt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70683);
        h.vKh.f(15236, new Object[] { Integer.valueOf(3) });
        ShowWxPayAgreementsUI.this.finish();
        AppMethodBeat.o(70683);
      }
    });
    this.qco.setWebViewClient(new i(this));
    this.qco.loadData(this.content, "text/html; charset=UTF-8", null);
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