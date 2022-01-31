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
import android.view.Window;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.a.c;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.soter.a.g.f;
import com.tenpay.android.wechat.MyKeyboardWindow;

public final class p
  extends i
  implements d
{
  protected DialogInterface.OnCancelListener NW;
  private String cCf;
  private String cnI;
  protected boolean gKc;
  public ImageView gxs;
  public View iCk;
  private boolean isPaused;
  private Animation mGL;
  private int mGM;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  public ImageView our;
  public TextView qpc;
  public TextView qwP;
  protected com.tencent.mm.plugin.wallet_core.utils.a tSy;
  public TextView tWO;
  public ImageView upK;
  public TextView usA;
  public FavourLayout usB;
  public CdnImageView usC;
  public TextView usD;
  public EditHintPasswdView usE;
  public p.b usF;
  public View usG;
  public View usH;
  public TextView usI;
  public ImageView usJ;
  public TextView usK;
  public TextView usL;
  public View usM;
  public TextView usN;
  protected p.a usO;
  protected DialogInterface.OnClickListener usP;
  protected boolean usQ;
  protected boolean usR;
  protected Bankcard usS;
  public TextView usT;
  public View usU;
  public TextView usV;
  protected int usW;
  protected boolean usX;
  private int usY;
  private Animation usZ;
  public Button usy;
  public TextView usz;
  private String uta;
  private long utb;
  private int utc;
  private int utd;
  private boolean ute;
  
  private p(Context paramContext)
  {
    super(paramContext, 2131493885);
    AppMethodBeat.i(47565);
    this.usQ = false;
    this.usR = true;
    this.usS = null;
    this.tSy = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.usW = 0;
    this.usX = false;
    this.usY = 0;
    this.mGM = 0;
    this.usZ = null;
    this.uta = "";
    this.utb = -1L;
    this.utc = 0;
    this.cCf = "";
    this.utd = 0;
    this.ute = false;
    this.isPaused = false;
    ab.v("MicroMsg.WalletPwdCustomDialog", "alvinluo WalletPwdDialog initView");
    this.iCk = View.inflate(paramContext, 2130971187, null);
    this.usy = ((Button)this.iCk.findViewById(2131822981));
    this.our = ((ImageView)this.iCk.findViewById(2131826673));
    this.mKeyboard = ((MyKeyboardWindow)this.iCk.findViewById(2131822419));
    this.mKBLayout = this.iCk.findViewById(2131822418);
    this.qwP = ((TextView)this.iCk.findViewById(2131820946));
    this.usz = ((TextView)this.iCk.findViewById(2131829358));
    this.qpc = ((TextView)this.iCk.findViewById(2131826674));
    this.tWO = ((TextView)this.iCk.findViewById(2131826675));
    this.tWO.getPaint().setFlags(16);
    this.usA = ((TextView)this.iCk.findViewById(2131825959));
    this.usB = ((FavourLayout)this.iCk.findViewById(2131829080));
    this.usC = ((CdnImageView)this.iCk.findViewById(2131829365));
    this.usG = this.iCk.findViewById(2131829361);
    this.usD = ((TextView)this.iCk.findViewById(2131826678));
    this.gxs = ((ImageView)this.iCk.findViewById(2131826671));
    this.usH = this.iCk.findViewById(2131826676);
    this.usI = ((TextView)this.iCk.findViewById(2131829364));
    a.b.c(this.gxs, com.tencent.mm.wallet_core.ui.e.getUsername());
    this.usE = ((EditHintPasswdView)this.iCk.findViewById(2131825034));
    this.usJ = ((ImageView)this.iCk.findViewById(2131826677));
    this.usT = ((TextView)this.iCk.findViewById(2131829359));
    this.usU = this.iCk.findViewById(2131829087);
    this.usV = ((TextView)this.iCk.findViewById(2131829089));
    this.upK = ((ImageView)this.iCk.findViewById(2131829088));
    this.usK = ((TextView)this.iCk.findViewById(2131827343));
    this.usL = ((TextView)this.iCk.findViewById(2131829363));
    this.usM = this.iCk.findViewById(2131829360);
    this.usN = ((TextView)this.iCk.findViewById(2131829362));
    this.usB.setVisibility(8);
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    this.usy.setEnabled(false);
    this.usy.setTextColor(paramContext.getResources().getColorStateList(2131690795));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.usE);
    this.usE.setOnInputValidListener(new p.1(this));
    this.usE.requestFocus();
    Object localObject = (TextView)this.iCk.findViewById(2131829358);
    if (localObject != null) {
      ((TextView)localObject).setText(ae.iL(paramContext));
    }
    paramContext = (EditText)this.iCk.findViewById(2131820689);
    com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(paramContext);
    this.mKeyboard.setInputEditText(paramContext);
    if (Build.VERSION.SDK_INT >= 14)
    {
      localObject = new c();
      this.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
      paramContext.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
    }
    paramContext.setOnClickListener(new p.2(this));
    this.iCk.findViewById(2131822420).setOnClickListener(new p.3(this));
    cVS();
    AppMethodBeat.o(47565);
  }
  
  public static p a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, p.b paramb, DialogInterface.OnCancelListener paramOnCancelListener, p.a parama)
  {
    AppMethodBeat.i(47575);
    if (((Activity)paramContext).isFinishing())
    {
      AppMethodBeat.o(47575);
      return null;
    }
    p localp = new p(paramContext);
    if (localp.usy != null)
    {
      localp.usP = null;
      localp.usy.setOnClickListener(new p.6(localp));
    }
    if (localp.our != null)
    {
      localp.NW = paramOnCancelListener;
      localp.our.setVisibility(0);
      localp.our.setOnClickListener(new p.7(localp, paramOnCancelListener));
    }
    localp.setOnCancelListener(paramOnCancelListener);
    localp.setCancelable(true);
    localp.qwP.setText(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      localp.qpc.setVisibility(0);
      localp.qpc.setText(paramString2);
      localp.usH.setVisibility(8);
      localp.usR = false;
      localp.usO = parama;
      if (TextUtils.isEmpty(paramString3)) {
        break label261;
      }
      localp.usK.setVisibility(0);
      localp.usK.setText(paramString3);
    }
    for (;;)
    {
      localp.usF = paramb;
      localp.usX = paramBoolean;
      if (!r.ZB()) {
        localp.cVS();
      }
      localp.show();
      com.tencent.mm.ui.base.h.a(paramContext, localp);
      AppMethodBeat.o(47575);
      return localp;
      localp.qpc.setVisibility(8);
      break;
      label261:
      ab.i("MicroMsg.WalletPwdCustomDialog", "ChargeFee is null");
      localp.usK.setVisibility(8);
    }
  }
  
  private void cVD()
  {
    AppMethodBeat.i(47568);
    ab.i("MicroMsg.WalletPwdCustomDialog", "reqFingerPrintAuth %s", new Object[] { bo.dtY().toString() });
    com.tencent.mm.plugin.soter.d.a.cyb();
    ma localma = new ma();
    localma.cCa.cwk = this.cnI;
    localma.cCa.cCc = 1;
    localma.cCa.cCe = new p.5(this, localma);
    com.tencent.mm.sdk.b.a.ymk.a(localma, Looper.getMainLooper());
    AppMethodBeat.o(47568);
  }
  
  private static void cVE()
  {
    AppMethodBeat.i(47569);
    ab.i("MicroMsg.WalletPwdCustomDialog", "hy: send release FPManager");
    oh localoh = new oh();
    com.tencent.mm.sdk.b.a.ymk.l(localoh);
    AppMethodBeat.o(47569);
  }
  
  private void cVS()
  {
    AppMethodBeat.i(47566);
    ab.v("MicroMsg.WalletPwdCustomDialog", "alvinluo updateFingerprintMode");
    this.usY = 0;
    this.usT.setVisibility(8);
    this.usU.setVisibility(8);
    this.utb = bo.yB();
    am localam = t.cTN();
    l locall = (l)g.E(l.class);
    if ((localam != null) && (locall.byS())) {}
    for (boolean bool1 = locall.bzm();; bool1 = true)
    {
      ab.i("MicroMsg.WalletPwdCustomDialog", "hy: soter key status: %b", new Object[] { Boolean.valueOf(bool1) });
      this.utc = 0;
      this.cCf = "";
      if ((locall != null) && (locall.bza()) && (!locall.byT())) {}
      for (bool1 = true;; bool1 = false)
      {
        ab.v("MicroMsg.WalletPwdCustomDialog", "alvinluo isDeviceSupportFp: %b", new Object[] { Boolean.valueOf(bool1) });
        boolean bool2;
        if ((locall != null) && (locall.byS()))
        {
          bool2 = true;
          if ((!bool2) || (!bool1) || (!this.usX) || (cVV())) {
            break label418;
          }
          this.usT.setVisibility(0);
          this.usT.setText(getContext().getString(2131305535));
          this.usW = 1;
          this.usU.setVisibility(0);
          this.upK.setVisibility(0);
          this.usE.setVisibility(8);
          this.mKBLayout.setVisibility(8);
          this.usz.setText(2131305526);
          this.utc = 1;
          cVD();
          com.tencent.mm.plugin.report.service.h.qsU.e(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        for (;;)
        {
          ab.i("MicroMsg.WalletPwdCustomDialog", "isOpenTouch:" + bool2 + ",  isDeviceSupport:" + bool1 + ", use_pay_touch:" + this.usX + ", isForcePwdMode:" + cVV());
          this.usT.setOnClickListener(new p.4(this));
          AppMethodBeat.o(47566);
          return;
          bool2 = false;
          break;
          label418:
          if ((bool2) && (bool1) && (this.usX) && (cVV()))
          {
            this.usT.setText(getContext().getString(2131305072));
            this.usT.setVisibility(0);
            this.usW = 0;
            this.usU.setVisibility(8);
            this.usE.setVisibility(0);
            if (!this.mKBLayout.isShown()) {
              this.mKBLayout.setVisibility(0);
            }
            this.usz.setText(2131305532);
            this.utc = 0;
            this.cCf = "";
            com.tencent.mm.plugin.report.service.h.qsU.e(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
            com.tencent.mm.wallet_core.ui.e.RX(8);
          }
          else
          {
            this.utc = 0;
            this.cCf = "";
            this.usT.setVisibility(8);
            com.tencent.mm.plugin.report.service.h.qsU.e(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          }
        }
      }
    }
  }
  
  private void cVT()
  {
    AppMethodBeat.i(47567);
    this.usT.setText(getContext().getString(2131305072));
    this.usW = 0;
    this.utb = bo.yB();
    this.usU.setVisibility(8);
    this.usE.setVisibility(0);
    if (!this.mKBLayout.isShown()) {
      this.mKBLayout.setVisibility(0);
    }
    this.usz.setText(2131305532);
    nN(true);
    this.utc = 0;
    this.cCf = "";
    com.tencent.mm.plugin.report.service.h.qsU.e(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    com.tencent.mm.wallet_core.ui.e.RX(29);
    cVE();
    AppMethodBeat.o(47567);
  }
  
  private static boolean cVV()
  {
    AppMethodBeat.i(47579);
    g.RM();
    Object localObject = g.RL().Ru().get(ac.a.yzw, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(47579);
      return bool;
    }
  }
  
  private static void nN(boolean paramBoolean)
  {
    AppMethodBeat.i(47578);
    g.RM();
    g.RL().Ru().set(ac.a.yzw, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(47578);
  }
  
  protected final void cVU()
  {
    AppMethodBeat.i(47574);
    nN(false);
    if (this.usP != null) {
      this.usP.onClick(this, 0);
    }
    dismiss();
    p.b localb;
    String str;
    if (this.usF != null)
    {
      ab.i("MicroMsg.WalletPwdCustomDialog", "doOk use_touch: %s soterAuthReq: %s ", new Object[] { Integer.valueOf(this.utc), this.cCf });
      localb = this.usF;
      str = this.usE.getText();
      if (this.utc != 1) {
        break label127;
      }
    }
    label127:
    for (boolean bool = true;; bool = false)
    {
      localb.f(str, bool, this.cCf);
      if (this.utb >= 0L) {
        break;
      }
      ab.e("MicroMsg.WalletPwdCustomDialog", "hy: not set update mode time yet. abandon");
      AppMethodBeat.o(47574);
      return;
    }
    if (this.usW == 0)
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(686L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(686L, 1L, bo.av(this.utb), false);
      AppMethodBeat.o(47574);
      return;
    }
    if (this.usW == 1)
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(686L, 2L, 1L, false);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(686L, 3L, bo.av(this.utb), false);
    }
    AppMethodBeat.o(47574);
  }
  
  public final void cVq()
  {
    AppMethodBeat.i(47576);
    this.isPaused = false;
    if (r.ZB())
    {
      AppMethodBeat.o(47576);
      return;
    }
    AppMethodBeat.o(47576);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(47573);
    try
    {
      super.dismiss();
      cVE();
      this.tSy.destory();
      if (this.mGL != null) {
        this.mGL.cancel();
      }
      AppMethodBeat.o(47573);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.WalletPwdCustomDialog", "dismiss exception, e = " + localException.getMessage());
      }
    }
  }
  
  public final void onActivityPause()
  {
    AppMethodBeat.i(47577);
    this.isPaused = true;
    if (r.ZB())
    {
      AppMethodBeat.o(47577);
      return;
    }
    if (this.usW == 1) {
      cVT();
    }
    AppMethodBeat.o(47577);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47571);
    super.onCreate(paramBundle);
    setContentView(this.iCk);
    f.dVD().dVE();
    AppMethodBeat.o(47571);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(47570);
    if (paramInt == 4)
    {
      if (this.NW != null) {
        this.NW.onCancel(this);
      }
      if (this.usO != null) {
        this.usO.bYU();
      }
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(47570);
    return bool;
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(47572);
    super.setCancelable(paramBoolean);
    this.gKc = paramBoolean;
    setCanceledOnTouchOutside(this.gKc);
    AppMethodBeat.o(47572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.p
 * JD-Core Version:    0.7.0.1
 */