package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.h.a.ll;
import com.tencent.mm.h.a.nk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;
import com.tencent.soter.a.g.f;
import com.tenpay.android.wechat.MyKeyboardWindow;

public final class n
  extends i
  implements c
{
  protected DialogInterface.OnCancelListener Oi;
  private String bMX;
  private String bUA = "";
  public ImageView ffK;
  protected boolean fsA;
  public View ipf;
  private boolean isPaused = false;
  private Animation klV;
  private int klW = 0;
  protected View lMr;
  protected MyKeyboardWindow mKeyboard;
  public TextView nCX;
  public TextView nJn;
  public View qFA;
  public View qFB;
  public TextView qFC;
  public ImageView qFD;
  public TextView qFE;
  public TextView qFF;
  public View qFG;
  public TextView qFH;
  protected n.a qFI;
  protected DialogInterface.OnClickListener qFJ;
  protected boolean qFK = false;
  protected boolean qFL = true;
  protected Bankcard qFM = null;
  public TextView qFN;
  public View qFO;
  public TextView qFP;
  public ImageView qFQ;
  protected int qFR = 0;
  protected boolean qFS = false;
  private int qFT = 0;
  private Animation qFU = null;
  private String qFV = "";
  private long qFW = -1L;
  private int qFX = 0;
  private int qFY = 0;
  private boolean qFZ = false;
  public Button qFr;
  public ImageView qFs;
  public TextView qFt;
  public TextView qFu;
  public FavourLayout qFv;
  public CdnImageView qFw;
  public TextView qFx;
  public EditHintPasswdView qFy;
  public n.b qFz;
  protected com.tencent.mm.plugin.wallet_core.e.a qjy = new com.tencent.mm.plugin.wallet_core.e.a();
  public TextView qnx;
  
  private n(Context paramContext)
  {
    super(paramContext, a.j.mmpwddialog);
    y.v("MicroMsg.WalletPwdCustomDialog", "alvinluo WalletPwdDialog initView");
    this.ipf = View.inflate(paramContext, a.g.wallet_full_pwd_dialog, null);
    this.qFr = ((Button)this.ipf.findViewById(a.f.mm_alert_ok_btn));
    this.qFs = ((ImageView)this.ipf.findViewById(a.f.wallet_pwd_close_iv));
    this.mKeyboard = ((MyKeyboardWindow)this.ipf.findViewById(a.f.tenpay_num_keyboard));
    this.lMr = this.ipf.findViewById(a.f.tenpay_keyboard_layout);
    this.nJn = ((TextView)this.ipf.findViewById(a.f.content));
    this.qFt = ((TextView)this.ipf.findViewById(a.f.wallet_pwd_title_tv));
    this.nCX = ((TextView)this.ipf.findViewById(a.f.fee));
    this.qnx = ((TextView)this.ipf.findViewById(a.f.origin_fee));
    this.qnx.getPaint().setFlags(16);
    this.qFu = ((TextView)this.ipf.findViewById(a.f.bankcard_tv));
    this.qFv = ((FavourLayout)this.ipf.findViewById(a.f.favour_tip));
    this.qFw = ((CdnImageView)this.ipf.findViewById(a.f.bankcard_logo));
    this.qFA = this.ipf.findViewById(a.f.favor_ll);
    this.qFx = ((TextView)this.ipf.findViewById(a.f.more_favors));
    this.ffK = ((ImageView)this.ipf.findViewById(a.f.chatting_user_iv));
    this.qFB = this.ipf.findViewById(a.f.bankcard_layout);
    this.qFC = ((TextView)this.ipf.findViewById(a.f.seperator));
    a.b.a(this.ffK, com.tencent.mm.wallet_core.ui.e.getUsername());
    this.qFy = ((EditHintPasswdView)this.ipf.findViewById(a.f.input_et));
    this.qFD = ((ImageView)this.ipf.findViewById(a.f.has_larger_favor_reddot));
    this.qFN = ((TextView)this.ipf.findViewById(a.f.wallet_pay_mode_tv));
    this.qFO = this.ipf.findViewById(a.f.finger_print_layout);
    this.qFP = ((TextView)this.ipf.findViewById(a.f.finger_print_tips));
    this.qFQ = ((ImageView)this.ipf.findViewById(a.f.finger_print_icon));
    this.qFE = ((TextView)this.ipf.findViewById(a.f.charge_fee));
    this.qFF = ((TextView)this.ipf.findViewById(a.f.random_offer_title));
    this.qFG = this.ipf.findViewById(a.f.favor_container);
    this.qFH = ((TextView)this.ipf.findViewById(a.f.favors_desc));
    this.qFv.setVisibility(8);
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    this.qFr.setEnabled(false);
    this.qFr.setTextColor(paramContext.getResources().getColorStateList(a.c.wallet_alert_btn_text_color));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.qFy);
    this.qFy.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void gG(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          n.this.bWR();
          com.tencent.mm.plugin.report.service.h.nFQ.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
      }
    });
    this.qFy.requestFocus();
    Object localObject = (TextView)this.ipf.findViewById(a.f.wallet_pwd_title_tv);
    if (localObject != null) {
      ((TextView)localObject).setText(ab.hm(paramContext));
    }
    paramContext = (EditText)this.ipf.findViewById(a.f.wallet_content);
    com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(paramContext);
    this.mKeyboard.setInputEditText(paramContext);
    if (Build.VERSION.SDK_INT >= 14)
    {
      localObject = new com.tencent.mm.ui.a.c();
      this.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
      paramContext.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
    }
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if (!n.this.lMr.isShown()) {
          n.this.lMr.setVisibility(0);
        }
      }
    });
    this.ipf.findViewById(a.f.tenpay_push_down).setOnClickListener(new n.3(this));
    bWP();
  }
  
  public static n a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, n.b paramb, DialogInterface.OnCancelListener paramOnCancelListener, n.a parama)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    n localn = new n(paramContext);
    if (localn.qFr != null)
    {
      localn.qFJ = null;
      localn.qFr.setOnClickListener(new n.6(localn));
    }
    if (localn.qFs != null)
    {
      localn.Oi = paramOnCancelListener;
      localn.qFs.setVisibility(0);
      localn.qFs.setOnClickListener(new n.7(localn, paramOnCancelListener));
    }
    localn.setOnCancelListener(paramOnCancelListener);
    localn.setCancelable(true);
    localn.nJn.setText(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      localn.nCX.setVisibility(0);
      localn.nCX.setText(paramString2);
      localn.qFB.setVisibility(8);
      localn.qFL = false;
      localn.qFI = parama;
      if (TextUtils.isEmpty(paramString3)) {
        break label250;
      }
      localn.qFE.setVisibility(0);
      localn.qFE.setText(paramString3);
    }
    for (;;)
    {
      localn.qFz = paramb;
      localn.qFS = paramBoolean;
      if (!q.Gw()) {
        localn.bWP();
      }
      localn.show();
      com.tencent.mm.ui.base.h.a(paramContext, localn);
      return localn;
      localn.nCX.setVisibility(8);
      break;
      label250:
      y.i("MicroMsg.WalletPwdCustomDialog", "ChargeFee is null");
      localn.qFE.setVisibility(8);
    }
  }
  
  private void bWC()
  {
    y.i("MicroMsg.WalletPwdCustomDialog", "reqFingerPrintAuth %s", new Object[] { bk.csb().toString() });
    com.tencent.mm.plugin.soter.d.a.bKP();
    ll localll = new ll();
    localll.bUv.bOT = this.bMX;
    localll.bUv.bUx = 1;
    localll.bUv.bUz = new n.5(this, localll);
    com.tencent.mm.sdk.b.a.udP.a(localll, Looper.getMainLooper());
  }
  
  private static void bWD()
  {
    y.i("MicroMsg.WalletPwdCustomDialog", "hy: send release FPManager");
    nk localnk = new nk();
    com.tencent.mm.sdk.b.a.udP.m(localnk);
  }
  
  private void bWP()
  {
    y.v("MicroMsg.WalletPwdCustomDialog", "alvinluo updateFingerprintMode");
    this.qFT = 0;
    this.qFN.setVisibility(8);
    this.qFO.setVisibility(8);
    this.qFW = bk.UZ();
    ag localag = o.bVs();
    k localk = (k)g.r(k.class);
    if ((localag != null) && (localk.aSw())) {}
    for (boolean bool1 = localk.aSR();; bool1 = true)
    {
      y.i("MicroMsg.WalletPwdCustomDialog", "hy: soter key status: %b", new Object[] { Boolean.valueOf(bool1) });
      this.qFX = 0;
      this.bUA = "";
      if ((localk != null) && (localk.aSF()) && (!localk.aSx())) {}
      for (bool1 = true;; bool1 = false)
      {
        y.v("MicroMsg.WalletPwdCustomDialog", "alvinluo isDeviceSupportFp: %b", new Object[] { Boolean.valueOf(bool1) });
        boolean bool2;
        if ((localk != null) && (localk.aSw()))
        {
          bool2 = true;
          if ((!bool2) || (!bool1) || (!this.qFS) || (bWS())) {
            break label406;
          }
          this.qFN.setVisibility(0);
          this.qFN.setText(getContext().getString(a.i.wallet_pwd_pay_mode));
          this.qFR = 1;
          this.qFO.setVisibility(0);
          this.qFQ.setVisibility(0);
          this.qFy.setVisibility(8);
          this.lMr.setVisibility(8);
          this.qFt.setText(a.i.wallet_pwd_dialog_finger_print_titile);
          this.qFX = 1;
          bWC();
          com.tencent.mm.plugin.report.service.h.nFQ.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        for (;;)
        {
          y.i("MicroMsg.WalletPwdCustomDialog", "isOpenTouch:" + bool2 + ",  isDeviceSupport:" + bool1 + ", use_pay_touch:" + this.qFS + ", isForcePwdMode:" + bWS());
          this.qFN.setOnClickListener(new n.4(this));
          return;
          bool2 = false;
          break;
          label406:
          if ((bool2) && (bool1) && (this.qFS) && (bWS()))
          {
            this.qFN.setText(getContext().getString(a.i.wallet_finger_print_pay_mode));
            this.qFN.setVisibility(0);
            this.qFR = 0;
            this.qFO.setVisibility(8);
            this.qFy.setVisibility(0);
            if (!this.lMr.isShown()) {
              this.lMr.setVisibility(0);
            }
            this.qFt.setText(a.i.wallet_pwd_dialog_titile);
            this.qFX = 0;
            this.bUA = "";
            com.tencent.mm.plugin.report.service.h.nFQ.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
            com.tencent.mm.wallet_core.ui.e.Jc(8);
          }
          else
          {
            this.qFX = 0;
            this.bUA = "";
            this.qFN.setVisibility(8);
            com.tencent.mm.plugin.report.service.h.nFQ.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          }
        }
      }
    }
  }
  
  private void bWQ()
  {
    this.qFN.setText(getContext().getString(a.i.wallet_finger_print_pay_mode));
    this.qFR = 0;
    this.qFW = bk.UZ();
    this.qFO.setVisibility(8);
    this.qFy.setVisibility(0);
    if (!this.lMr.isShown()) {
      this.lMr.setVisibility(0);
    }
    this.qFt.setText(a.i.wallet_pwd_dialog_titile);
    kG(true);
    this.qFX = 0;
    this.bUA = "";
    com.tencent.mm.plugin.report.service.h.nFQ.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    com.tencent.mm.wallet_core.ui.e.Jc(29);
    bWD();
  }
  
  private static boolean bWS()
  {
    g.DQ();
    Object localObject = g.DP().Dz().get(ac.a.upA, Boolean.valueOf(false));
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  private static void kG(boolean paramBoolean)
  {
    g.DQ();
    g.DP().Dz().c(ac.a.upA, Boolean.valueOf(paramBoolean));
  }
  
  protected final void bWR()
  {
    kG(false);
    if (this.qFJ != null) {
      this.qFJ.onClick(this, 0);
    }
    dismiss();
    boolean bool;
    if (this.qFz != null)
    {
      y.i("MicroMsg.WalletPwdCustomDialog", "doOk use_touch: %s soterAuthReq: %s ", new Object[] { Integer.valueOf(this.qFX), this.bUA });
      n.b localb = this.qFz;
      String str = this.qFy.getText();
      if (this.qFX == 1)
      {
        bool = true;
        localb.d(str, bool, this.bUA);
      }
    }
    else
    {
      if (this.qFW >= 0L) {
        break label120;
      }
      y.e("MicroMsg.WalletPwdCustomDialog", "hy: not set update mode time yet. abandon");
    }
    label120:
    do
    {
      return;
      bool = false;
      break;
      if (this.qFR == 0)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(686L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.nFQ.a(686L, 1L, bk.cp(this.qFW), false);
        return;
      }
    } while (this.qFR != 1);
    com.tencent.mm.plugin.report.service.h.nFQ.a(686L, 2L, 1L, false);
    com.tencent.mm.plugin.report.service.h.nFQ.a(686L, 3L, bk.cp(this.qFW), false);
  }
  
  public final void bWs()
  {
    this.isPaused = false;
    if (q.Gw()) {}
  }
  
  public final void bWt()
  {
    this.isPaused = true;
    if (q.Gw()) {}
    while (this.qFR != 1) {
      return;
    }
    bWQ();
  }
  
  public final void dismiss()
  {
    try
    {
      super.dismiss();
      bWD();
      this.qjy.destory();
      if (this.klV != null) {
        this.klV.cancel();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.WalletPwdCustomDialog", "dismiss exception, e = " + localException.getMessage());
      }
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(this.ipf);
    f.cPH().cPI();
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.Oi != null) {
        this.Oi.onCancel(this);
      }
      if (this.qFI != null) {
        this.qFI.bqo();
      }
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    this.fsA = paramBoolean;
    setCanceledOnTouchOutside(this.fsA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.n
 * JD-Core Version:    0.7.0.1
 */