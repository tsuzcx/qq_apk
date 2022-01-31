package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.pwd.a.a;
import com.tencent.mm.plugin.wallet.pwd.a.r;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.b;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@com.tencent.mm.ui.base.a(3)
public class WalletForgotPwdVerifyIdUI
  extends WalletBaseUI
  implements View.OnLayoutChangeListener
{
  private TextView gui;
  private View iDS;
  private int iiX = 0;
  private int keyHeight = 0;
  private boolean tZe;
  private MMEditText tZj;
  private TextView tZk;
  private WalletFormView tZl;
  private Button tZm;
  private TextView tZn;
  private LinearLayout tZo;
  ViewGroup.MarginLayoutParams tZp;
  ViewGroup.MarginLayoutParams tZq;
  private View tZr;
  private boolean tZs = false;
  private boolean tZt = false;
  private boolean tZu = false;
  private boolean tZv = false;
  
  private void bJ()
  {
    AppMethodBeat.i(46314);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", "updateView");
    int i = t.cTJ().cVl().field_cre_type;
    String str1 = t.cTJ().cVl().field_cre_name;
    String str2 = t.cTJ().cVl().field_true_name;
    this.tZj.setHint(getString(2131304988, new Object[] { e.awc(str2) }));
    if (!bo.isNullOrNil(str1)) {
      this.tZk.setText(str1);
    }
    while (i == 1)
    {
      com.tencent.mm.wallet_core.ui.formview.a.d(this.tZl);
      setEditFocusListener(this.tZl, 1, false);
      AppMethodBeat.o(46314);
      return;
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.WalletForgotPwdVerifyIdUI", "creName is null");
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", "no need tenpay keyboard");
    AppMethodBeat.o(46314);
  }
  
  private void cSF()
  {
    AppMethodBeat.i(46316);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", " setChangParams()");
    new ak().postDelayed(new WalletForgotPwdVerifyIdUI.3(this), 100L);
    AppMethodBeat.o(46316);
  }
  
  public void finish()
  {
    AppMethodBeat.i(142377);
    super.finish();
    getIntent().putExtra("process_id", com.tencent.mm.plugin.wallet.pwd.a.class.hashCode());
    com.tencent.mm.plugin.wallet.pwd.a locala = (com.tencent.mm.plugin.wallet.pwd.a)com.tencent.mm.wallet_core.a.aM(this);
    if ((locala != null) && (locala.tXA != null)) {
      locala.tXA.run(-1);
    }
    AppMethodBeat.o(142377);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130971180;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(46313);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", "onCreate");
    setActionbarColor(Color.parseColor("#FFFFFF"));
    hideActionbarLine();
    setMMTitleVisibility(8);
    this.tZr = findViewById(2131825962);
    this.iiX = getWindowManager().getDefaultDisplay().getHeight();
    this.keyHeight = (this.iiX / 3);
    this.tZr.addOnLayoutChangeListener(this);
    this.tZe = getInput().getBoolean("key_is_force_bind", false);
    if (!this.tZe)
    {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ab(null, 6));
      setContentViewVisibility(4);
    }
    this.tZj = ((MMEditText)findViewById(2131829137));
    this.tZk = ((TextView)findViewById(2131829138));
    this.tZl = ((WalletFormView)findViewById(2131829052));
    this.tZm = ((Button)findViewById(2131822914));
    this.tZn = ((TextView)findViewById(2131829140));
    this.iDS = findViewById(2131821003);
    this.gui = ((TextView)findViewById(2131820680));
    this.tZo = ((LinearLayout)findViewById(2131823847));
    this.tZl.setEnabled(false);
    this.tZl.setFocusable(false);
    this.tZm.setOnClickListener(new WalletForgotPwdVerifyIdUI.1(this));
    this.tZn.setOnClickListener(new WalletForgotPwdVerifyIdUI.2(this));
    bJ();
    setTenpayKBStateListener(new WalletForgotPwdVerifyIdUI.6(this));
    this.tZj.setOnFocusChangeListener(new WalletForgotPwdVerifyIdUI.7(this));
    this.tZj.addTextChangedListener(new WalletForgotPwdVerifyIdUI.4(this));
    this.tZl.a(new WalletForgotPwdVerifyIdUI.5(this));
    AppMethodBeat.o(46313);
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(46317);
    if ((paramInt8 != 0) && (paramInt4 != 0) && (paramInt8 - paramInt4 > this.keyHeight))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", " up");
      cSF();
      AppMethodBeat.o(46317);
      return;
    }
    if ((paramInt8 != 0) && (paramInt4 != 0) && (paramInt4 - paramInt8 > this.keyHeight)) {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", " down");
    }
    AppMethodBeat.o(46317);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(46315);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", " errCode: %s errMsg: %s  scene: %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramm });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab)) {
        break label67;
      }
      bJ();
      setContentViewVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(46315);
      return false;
      label67:
      if ((paramm instanceof r))
      {
        paramString = (r)paramm;
        getInput().putInt("key_is_support_face", paramString.tYf);
        getInput().putInt("key_face_action_scene", paramString.scene);
        getInput().putString("key_face_action_package", paramString.packageName);
        getInput().putString("key_face_action_package_sign", paramString.cFw);
        if (paramString.tYg == 1)
        {
          com.tencent.mm.wallet_core.c.ab.dSv();
          paramm = com.tencent.mm.wallet_core.c.ab.getCrtNo();
          b.dSi();
          if (!b.isCertExist(paramm))
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", "checkInstallCert, crt not installed");
            doSceneForceProgress(new n(paramString.tYd, paramString.tYe, paramString.cLS));
          }
          else
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", "already install cert, go to next process");
            getProcess().a(this, 0, getInput());
          }
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", "verify realname info finish, go to next process");
          getProcess().a(this, 0, getInput());
        }
      }
      else if ((paramm instanceof n))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", "install cert finish, go to next process");
        getProcess().a(this, 0, getInput());
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI
 * JD-Core Version:    0.7.0.1
 */