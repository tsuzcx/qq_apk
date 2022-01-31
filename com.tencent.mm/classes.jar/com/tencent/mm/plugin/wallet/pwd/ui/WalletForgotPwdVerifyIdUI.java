package com.tencent.mm.plugin.wallet.pwd.ui;

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
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet.pwd.a.k;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@com.tencent.mm.ui.base.a(3)
public class WalletForgotPwdVerifyIdUI
  extends WalletBaseUI
  implements View.OnLayoutChangeListener
{
  private TextView fcy;
  private int gHS = 0;
  private View jdj;
  private int keyHeight = 0;
  private boolean qoR;
  private MMEditText qoW;
  private TextView qoX;
  private WalletFormView qoY;
  private Button qoZ;
  private TextView qpa;
  private LinearLayout qpb;
  ViewGroup.MarginLayoutParams qpc;
  ViewGroup.MarginLayoutParams qpd;
  private View qpe;
  private boolean qpf = false;
  private boolean qpg = false;
  private boolean qph = false;
  private boolean qpi = false;
  
  private void aZ()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletForgotPwdVerifyIdUI", "updateView");
    int i = o.bVo().bWq().field_cre_type;
    String str1 = o.bVo().bWq().field_cre_name;
    String str2 = o.bVo().bWq().field_true_name;
    this.qoW.setHint(getString(a.i.wallet_card_username_hint_forget, new Object[] { e.afj(str2) }));
    if (!bk.bl(str1)) {
      this.qoX.setText(str1);
    }
    while (i == 1)
    {
      com.tencent.mm.wallet_core.ui.formview.a.d(this.qoY);
      e(this.qoY, 1, false);
      return;
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.WalletForgotPwdVerifyIdUI", "creName is null");
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletForgotPwdVerifyIdUI", "no need tenpay keyboard");
  }
  
  private void bUy()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletForgotPwdVerifyIdUI", " setChangParams()");
    new ah().postDelayed(new WalletForgotPwdVerifyIdUI.3(this), 100L);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletForgotPwdVerifyIdUI", " errCode: %s errMsg: %s  scene: %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramm });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramm instanceof com.tencent.mm.plugin.wallet_core.c.y)) {
        break label54;
      }
      aZ();
      vN(0);
    }
    label54:
    do
    {
      return false;
      if ((paramm instanceof k))
      {
        paramString = (k)paramm;
        this.BX.putInt("key_is_support_face", paramString.qos);
        this.BX.putInt("key_face_action_scene", paramString.scene);
        this.BX.putString("key_face_action_package", paramString.packageName);
        this.BX.putString("key_face_action_package_sign", paramString.bXA);
        if (paramString.qot == 1)
        {
          com.tencent.mm.wallet_core.c.y.cMH();
          paramm = com.tencent.mm.wallet_core.c.y.cMG();
          com.tencent.mm.wallet_core.c.a.cMr();
          if (!com.tencent.mm.wallet_core.c.a.isCertExist(paramm))
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletForgotPwdVerifyIdUI", "checkInstallCert, crt not installed");
            a(new l(paramString.qoq, paramString.qor, paramString.cdi), true, false);
            return false;
          }
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletForgotPwdVerifyIdUI", "already install cert, go to next process");
          cNj().a(this, 0, this.BX);
          return false;
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletForgotPwdVerifyIdUI", "verify realname info finish, go to next process");
        cNj().a(this, 0, this.BX);
        return false;
      }
    } while (!(paramm instanceof l));
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletForgotPwdVerifyIdUI", "install cert finish, go to next process");
    cNj().a(this, 0, this.BX);
    return false;
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_forgot_pwd_verify_id_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletForgotPwdVerifyIdUI", "onCreate");
    ta(Color.parseColor("#FFFFFF"));
    czo();
    FP(8);
    this.qpe = findViewById(a.f.root_layout);
    this.gHS = getWindowManager().getDefaultDisplay().getHeight();
    this.keyHeight = (this.gHS / 3);
    this.qpe.addOnLayoutChangeListener(this);
    this.qoR = this.BX.getBoolean("key_is_force_bind", false);
    if (!this.qoR)
    {
      a(new com.tencent.mm.plugin.wallet_core.c.y(null, 6), true, true);
      vN(4);
    }
    this.qoW = ((MMEditText)findViewById(a.f.name_edit));
    this.qoX = ((TextView)findViewById(a.f.identity_type_tv));
    this.qoY = ((WalletFormView)findViewById(a.f.identity_et));
    this.qoZ = ((Button)findViewById(a.f.next_btn));
    this.qpa = ((TextView)findViewById(a.f.qa_tv));
    this.jdj = findViewById(a.f.root);
    this.fcy = ((TextView)findViewById(a.f.title));
    this.qpb = ((LinearLayout)findViewById(a.f.name_layout));
    this.qoY.setEnabled(false);
    this.qoY.setFocusable(false);
    this.qoZ.setOnClickListener(new WalletForgotPwdVerifyIdUI.1(this));
    this.qpa.setOnClickListener(new WalletForgotPwdVerifyIdUI.2(this));
    aZ();
    this.lTH = new WalletForgotPwdVerifyIdUI.6(this);
    this.qoW.setOnFocusChangeListener(new WalletForgotPwdVerifyIdUI.7(this));
    this.qoW.addTextChangedListener(new WalletForgotPwdVerifyIdUI.4(this));
    this.qoY.a(new WalletForgotPwdVerifyIdUI.5(this));
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt8 != 0) && (paramInt4 != 0) && (paramInt8 - paramInt4 > this.keyHeight))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletForgotPwdVerifyIdUI", " up");
      bUy();
    }
    while ((paramInt8 == 0) || (paramInt4 == 0) || (paramInt4 - paramInt8 <= this.keyHeight)) {
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletForgotPwdVerifyIdUI", " down");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI
 * JD-Core Version:    0.7.0.1
 */