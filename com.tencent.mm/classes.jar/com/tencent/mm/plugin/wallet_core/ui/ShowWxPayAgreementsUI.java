package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.z;

@com.tencent.mm.ui.base.a(3)
public class ShowWxPayAgreementsUI
  extends MMActivity
{
  private TextView IcX;
  private TextView IcY;
  private String content;
  private MMWebView tcN;
  private int type;
  
  public void finish()
  {
    AppMethodBeat.i(70686);
    Log.i("MicroMsg.ShowWxPayAgreementsUI", "onRefreshed");
    super.finish();
    overridePendingTransition(2130771986, 2130772130);
    AppMethodBeat.o(70686);
  }
  
  public int getLayoutId()
  {
    return 2131496317;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70685);
    h.CyF.a(15236, new Object[] { Integer.valueOf(1) });
    getSupportActionBar().hide();
    overridePendingTransition(2130772132, 2130771986);
    this.type = getIntent().getIntExtra("agreement_type", 0);
    this.tcN = MMWebView.a.a(this, getContentView(), 2131296600);
    this.tcN.getSettings().setJavaScriptEnabled(true);
    this.IcX = ((TextView)findViewById(2131296598));
    this.IcY = ((TextView)findViewById(2131296595));
    this.content = getIntent().getStringExtra("agreement_content");
    this.IcY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70682);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/ShowWxPayAgreementsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        h.CyF.a(15236, new Object[] { Integer.valueOf(2) });
        ShowWxPayAgreementsUI.this.setResult(-1);
        ShowWxPayAgreementsUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/ShowWxPayAgreementsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70682);
      }
    });
    this.IcX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70683);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/ShowWxPayAgreementsUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        h.CyF.a(15236, new Object[] { Integer.valueOf(3) });
        ShowWxPayAgreementsUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/ShowWxPayAgreementsUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70683);
      }
    });
    this.tcN.setWebViewClient(new i(this));
    if (getContext().getApplicationInfo().targetSdkVersion >= 29)
    {
      String str = Base64.encodeToString(this.content.getBytes(), 0);
      this.tcN.loadData(str, "text/html; charset=UTF-8", "base64");
      AppMethodBeat.o(70685);
      return;
    }
    this.tcN.loadData(this.content, "text/html; charset=UTF-8", null);
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