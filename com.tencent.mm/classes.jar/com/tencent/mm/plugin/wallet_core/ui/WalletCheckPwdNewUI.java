package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

@com.tencent.mm.ui.base.a(3)
public class WalletCheckPwdNewUI
  extends WalletBaseUI
{
  private ImageView alt;
  private EditHintPasswdView tZD;
  private WalletCheckPwdNewUI.a upG;
  TextView upH;
  private TextView upI;
  private LinearLayout upJ;
  private ImageView upK;
  private TextView upL;
  private LinearLayout upM;
  private LinearLayout upN;
  private TextView upO;
  private ScrollView upP;
  
  public int getLayoutId()
  {
    return 2130971163;
  }
  
  public void initView()
  {
    AppMethodBeat.i(47326);
    this.alt = ((ImageView)findViewById(2131829085));
    this.upH = ((TextView)findViewById(2131825031));
    this.upI = ((TextView)findViewById(2131829086));
    this.upJ = ((LinearLayout)findViewById(2131829084));
    this.tZD = ((EditHintPasswdView)findViewById(2131825034));
    this.upK = ((ImageView)findViewById(2131829088));
    this.upL = ((TextView)findViewById(2131829089));
    this.upM = ((LinearLayout)findViewById(2131829087));
    this.upN = ((LinearLayout)findViewById(2131829083));
    this.upO = ((TextView)findViewById(2131829090));
    this.upP = ((ScrollView)findViewById(2131829082));
    this.alt.setOnClickListener(new WalletCheckPwdNewUI.2(this));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.tZD);
    this.tZD.setOnInputValidListener(new WalletCheckPwdNewUI.3(this));
    setEditFocusListener(this.tZD, 0, false);
    showTenpayKB();
    AppMethodBeat.o(47326);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47324);
    super.onCreate(paramBundle);
    int i = getIntent().getIntExtra("scene", -1);
    ab.i("MicroMsg.WalletCheckPwdNewUI", "scene: %s", new Object[] { Integer.valueOf(i) });
    if (i == 3) {}
    for (this.upG = new f(this);; this.upG = new a(this))
    {
      setActionbarColor(getResources().getColor(2131690709));
      hideTitleView();
      hideActionbarLine();
      initView();
      this.upG.onCreate();
      setBackBtn(new WalletCheckPwdNewUI.1(this));
      AppMethodBeat.o(47324);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(47329);
    super.onDestroy();
    AppMethodBeat.o(47329);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(47328);
    super.onPause();
    AppMethodBeat.o(47328);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(47327);
    super.onResume();
    AppMethodBeat.o(47327);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(47330);
    ab.i("MicroMsg.WalletCheckPwdNewUI", "controller ret: %s", new Object[] { Boolean.FALSE });
    AppMethodBeat.o(47330);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setContentViewVisibility(int paramInt)
  {
    AppMethodBeat.i(47325);
    getContentView().setVisibility(paramInt);
    AppMethodBeat.o(47325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdNewUI
 * JD-Core Version:    0.7.0.1
 */