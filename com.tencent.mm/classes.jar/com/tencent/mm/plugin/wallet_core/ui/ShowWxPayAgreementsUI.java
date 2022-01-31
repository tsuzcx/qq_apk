package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.t;

@a(3)
public class ShowWxPayAgreementsUI
  extends MMActivity
{
  private String content;
  private int type;
  private MMWebView umS;
  private TextView umT;
  private TextView umU;
  
  public void finish()
  {
    AppMethodBeat.i(47136);
    ab.i("MicroMsg.ShowWxPayAgreementsUI", "onRefreshed");
    super.finish();
    overridePendingTransition(2131034130, 2131034228);
    AppMethodBeat.o(47136);
  }
  
  public int getLayoutId()
  {
    return 2130970739;
  }
  
  public void initView()
  {
    boolean bool = false;
    AppMethodBeat.i(47135);
    h.qsU.e(15236, new Object[] { Integer.valueOf(1) });
    getSupportActionBar().hide();
    overridePendingTransition(2131034230, 2131034130);
    this.type = getIntent().getIntExtra("agreement_type", 0);
    Object localObject = getContentView();
    MMWebView.iG(this);
    localObject = (MMWebView)((View)localObject).findViewById(2131827776);
    ((MMWebView)localObject).inited = true;
    if (((MMWebView)localObject).getX5WebViewExtension() != null) {
      bool = true;
    }
    MMWebView.e((MMWebView)localObject, bool);
    this.umS = ((MMWebView)localObject);
    this.umS.getSettings().setJavaScriptEnabled(true);
    this.umT = ((TextView)findViewById(2131827777));
    this.umU = ((TextView)findViewById(2131827778));
    this.content = getIntent().getStringExtra("agreement_content");
    this.umU.setOnClickListener(new ShowWxPayAgreementsUI.1(this));
    this.umT.setOnClickListener(new ShowWxPayAgreementsUI.2(this));
    this.umS.setWebViewClient(new g(this));
    this.umS.loadData(this.content, "text/html; charset=UTF-8", null);
    AppMethodBeat.o(47135);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47134);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(47134);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(47139);
    if (paramInt == 4)
    {
      AppMethodBeat.o(47139);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(47139);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(47138);
    super.onPause();
    AppMethodBeat.o(47138);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(47137);
    super.onResume();
    AppMethodBeat.o(47137);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.ShowWxPayAgreementsUI
 * JD-Core Version:    0.7.0.1
 */