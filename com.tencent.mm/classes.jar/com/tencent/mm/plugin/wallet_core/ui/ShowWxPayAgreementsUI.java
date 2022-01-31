package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.n;

@a(3)
public class ShowWxPayAgreementsUI
  extends MMActivity
{
  private String content;
  private MMWebView qAh;
  private TextView qAi;
  private TextView qAj;
  private int type;
  
  public void finish()
  {
    y.i("MicroMsg.ShowWxPayAgreementsUI", "onRefreshed");
    super.finish();
    overridePendingTransition(a.a.anim_not_change, a.a.push_down_out);
  }
  
  protected final int getLayoutId()
  {
    return a.g.show_wxpayagreements_ui;
  }
  
  protected final void initView()
  {
    boolean bool = false;
    h.nFQ.f(15236, new Object[] { Integer.valueOf(1) });
    getSupportActionBar().hide();
    overridePendingTransition(a.a.push_up_in, a.a.anim_not_change);
    this.type = getIntent().getIntExtra("agreement_type", 0);
    Object localObject = this.mController.contentView;
    int i = a.f.agreement_webview;
    MMWebView.hi(this);
    localObject = (MMWebView)((View)localObject).findViewById(i);
    ((MMWebView)localObject).dyX = true;
    if (((MMWebView)localObject).getX5WebViewExtension() != null) {
      bool = true;
    }
    MMWebView.e((MMWebView)localObject, bool);
    this.qAh = ((MMWebView)localObject);
    this.qAh.getSettings().setJavaScriptEnabled(true);
    this.qAi = ((TextView)findViewById(a.f.agreement_disagree_btn));
    this.qAj = ((TextView)findViewById(a.f.agreement_agree_btn));
    this.content = getIntent().getStringExtra("agreement_content");
    this.qAj.setOnClickListener(new ShowWxPayAgreementsUI.1(this));
    this.qAi.setOnClickListener(new ShowWxPayAgreementsUI.2(this));
    this.qAh.setWebViewClient(new e(this));
    this.qAh.loadData(this.content, "text/html; charset=UTF-8", null);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.ShowWxPayAgreementsUI
 * JD-Core Version:    0.7.0.1
 */