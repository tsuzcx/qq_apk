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
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.od;
import com.tencent.mm.g.a.od.b;
import com.tencent.mm.g.a.qr;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.a.c;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import org.json.JSONObject;

public final class r
  extends i
  implements f
{
  protected com.tencent.mm.plugin.wallet_core.utils.a CFp;
  public TextView CJJ;
  public Button CQI;
  public ImageView Dfs;
  public View DiA;
  public TextView DiB;
  protected int DiC;
  protected boolean DiD;
  private int DiE;
  private Animation DiF;
  private String DiG;
  private long DiH;
  private int DiI;
  private int DiJ;
  private boolean DiK;
  public TextView Dif;
  public TextView Dig;
  public FavourLayout Dih;
  public CdnImageView Dii;
  public TextView Dij;
  public EditHintPasswdView Dik;
  public b Dil;
  public View Dim;
  public View Din;
  public TextView Dio;
  public ImageView Dip;
  public TextView Diq;
  public TextView Dir;
  public View Dis;
  public TextView Dit;
  protected a Diu;
  protected DialogInterface.OnClickListener Div;
  protected boolean Diw;
  protected boolean Dix;
  protected Bankcard Diy;
  public TextView Diz;
  protected DialogInterface.OnCancelListener XL;
  private String dCb;
  private String dlu;
  public View iCR;
  private boolean isPaused;
  public ImageView jdF;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  protected boolean ov;
  private int thA;
  private Animation thQ;
  public ImageView vxX;
  public TextView yea;
  public TextView yqw;
  
  private r(Context paramContext)
  {
    super(paramContext, 2131821727);
    AppMethodBeat.i(71133);
    this.Diw = false;
    this.Dix = true;
    this.Diy = null;
    this.CFp = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.DiC = 0;
    this.DiD = false;
    this.DiE = 0;
    this.thA = 0;
    this.DiF = null;
    this.DiG = "";
    this.DiH = -1L;
    this.DiI = 0;
    this.dCb = "";
    this.DiJ = 0;
    this.DiK = false;
    this.isPaused = false;
    ad.v("MicroMsg.WalletPwdCustomDialog", "alvinluo WalletPwdDialog initView");
    this.iCR = View.inflate(paramContext, 2131495963, null);
    this.CQI = ((Button)this.iCR.findViewById(2131302314));
    this.vxX = ((ImageView)this.iCR.findViewById(2131306819));
    this.mKeyboard = ((MyKeyboardWindow)this.iCR.findViewById(2131305695));
    this.mKBLayout = this.iCR.findViewById(2131305693);
    this.yqw = ((TextView)this.iCR.findViewById(2131298739));
    this.Dif = ((TextView)this.iCR.findViewById(2131306826));
    this.yea = ((TextView)this.iCR.findViewById(2131299872));
    this.CJJ = ((TextView)this.iCR.findViewById(2131303087));
    this.CJJ.getPaint().setFlags(16);
    this.Dig = ((TextView)this.iCR.findViewById(2131297176));
    this.Dih = ((FavourLayout)this.iCR.findViewById(2131299869));
    this.Dii = ((CdnImageView)this.iCR.findViewById(2131297165));
    this.Dim = this.iCR.findViewById(2131299861);
    this.Dij = ((TextView)this.iCR.findViewById(2131302467));
    this.jdF = ((ImageView)this.iCR.findViewById(2131298184));
    this.Din = this.iCR.findViewById(2131297163);
    this.Dio = ((TextView)this.iCR.findViewById(2131304595));
    a.b.c(this.jdF, com.tencent.mm.wallet_core.ui.e.getUsername());
    this.Dik = ((EditHintPasswdView)this.iCR.findViewById(2131301026));
    this.Dip = ((ImageView)this.iCR.findViewById(2131300682));
    this.Diz = ((TextView)this.iCR.findViewById(2131306814));
    this.DiA = this.iCR.findViewById(2131300088);
    this.DiB = ((TextView)this.iCR.findViewById(2131300091));
    this.Dfs = ((ImageView)this.iCR.findViewById(2131300087));
    this.Diq = ((TextView)this.iCR.findViewById(2131297953));
    this.Dir = ((TextView)this.iCR.findViewById(2131303711));
    this.Dis = this.iCR.findViewById(2131299859);
    this.Dit = ((TextView)this.iCR.findViewById(2131299868));
    this.Dih.setVisibility(8);
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    this.CQI.setEnabled(false);
    this.CQI.setTextColor(paramContext.getResources().getColorStateList(2131101098));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.Dik);
    this.Dik.setOnInputValidListener(new r.1(this));
    this.Dik.requestFocus();
    Object localObject = (TextView)this.iCR.findViewById(2131306826);
    if (localObject != null) {
      ((TextView)localObject).setText(ah.kN(paramContext));
    }
    paramContext = (EditText)this.iCR.findViewById(2131306718);
    com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(paramContext);
    this.mKeyboard.setInputEditText(paramContext);
    if (Build.VERSION.SDK_INT >= 14)
    {
      localObject = new c();
      this.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
      paramContext.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
    }
    paramContext.setOnClickListener(new r.2(this));
    this.iCR.findViewById(2131305696).setOnClickListener(new r.3(this));
    eHP();
    AppMethodBeat.o(71133);
  }
  
  public static r a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, b paramb, final DialogInterface.OnCancelListener paramOnCancelListener, a parama)
  {
    AppMethodBeat.i(71143);
    if (((Activity)paramContext).isFinishing())
    {
      AppMethodBeat.o(71143);
      return null;
    }
    r localr = new r(paramContext);
    if (localr.CQI != null)
    {
      localr.Div = null;
      localr.CQI.setOnClickListener(new r.6(localr));
    }
    if (localr.vxX != null)
    {
      localr.XL = paramOnCancelListener;
      localr.vxX.setVisibility(0);
      localr.vxX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71132);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (paramOnCancelListener != null) {
            paramOnCancelListener.onCancel(null);
          }
          if (r.this.Diu != null) {
            r.this.Diu.dwF();
          }
          r.this.cancel();
          if (r.this.Diz.isShown()) {
            com.tencent.mm.plugin.report.service.g.yhR.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71132);
            return;
            com.tencent.mm.plugin.report.service.g.yhR.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          }
        }
      });
    }
    localr.setOnCancelListener(paramOnCancelListener);
    localr.setCancelable(true);
    localr.yqw.setText(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      localr.yea.setVisibility(0);
      localr.yea.setText(paramString2);
      localr.Din.setVisibility(8);
      localr.Dix = false;
      localr.Diu = parama;
      if (TextUtils.isEmpty(paramString3)) {
        break label261;
      }
      localr.Diq.setVisibility(0);
      localr.Diq.setText(paramString3);
    }
    for (;;)
    {
      localr.Dil = paramb;
      localr.DiD = paramBoolean;
      if (!u.aAB()) {
        localr.eHP();
      }
      localr.show();
      h.a(paramContext, localr);
      AppMethodBeat.o(71143);
      return localr;
      localr.yea.setVisibility(8);
      break;
      label261:
      ad.i("MicroMsg.WalletPwdCustomDialog", "ChargeFee is null");
      localr.Diq.setVisibility(8);
    }
  }
  
  private void eHB()
  {
    AppMethodBeat.i(71136);
    ad.i("MicroMsg.WalletPwdCustomDialog", "reqFingerPrintAuth %s", new Object[] { bt.flS().toString() });
    com.tencent.mm.plugin.soter.d.a.efC();
    final od localod = new od();
    localod.dBW.dve = this.dlu;
    localod.dBW.dBY = 1;
    localod.dBW.dCa = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71130);
        ad.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback");
        Object localObject = localod.dBX;
        if (localObject == null)
        {
          r.a(r.this, 0);
          ad.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, result == null");
          AppMethodBeat.o(71130);
          return;
        }
        int i = ((od.b)localObject).errCode;
        ad.v("MicroMsg.WalletPwdCustomDialog", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), ((od.b)localObject).errMsg });
        if (i == 0)
        {
          ad.i("MicroMsg.WalletPwdCustomDialog", "hy: payInfo soterAuthReq: %s", new Object[] { ((od.b)localObject).dCb });
          r.a(r.this, 1);
          r.a(r.this, ((od.b)localObject).dCb);
          try
          {
            localObject = new JSONObject(r.e(r.this));
            ((JSONObject)localObject).put("soter_type", "1");
            r.a(r.this, ((JSONObject)localObject).toString());
            r.f(r.this);
            r.this.DiB.setText("");
            r.this.eHR();
            com.tencent.mm.plugin.report.service.g.yhR.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
            com.tencent.mm.plugin.soter.d.a.RR(0);
            AppMethodBeat.o(71130);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.WalletPwdCustomDialog", localException, "", new Object[0]);
            }
          }
        }
        ad.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
        r.a(r.this, 0);
        r.a(r.this, "");
        r.this.DiA.setVisibility(0);
        r.this.DiB.setTextColor(r.this.getContext().getResources().getColor(2131100798));
        r.this.DiB.setText(2131765262);
        int j = (int)(System.currentTimeMillis() / 1000L);
        int k = j - r.g(r.this);
        if (k > 1)
        {
          r.b(r.this, j);
          r.h(r.this);
          r.f(r.this);
        }
        com.tencent.mm.plugin.report.service.g.yhR.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
        boolean bool1;
        if ((i == 2) || (i == 10308))
        {
          bool1 = true;
          if (localException.dCc != 2) {
            break label673;
          }
        }
        label673:
        for (boolean bool2 = true;; bool2 = false)
        {
          ad.v("MicroMsg.WalletPwdCustomDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(r.i(r.this)), Integer.valueOf(i), Boolean.valueOf(bool2) });
          if (((!bool2) && ((r.i(r.this) >= 3) || (k <= 1))) || (bool1)) {
            break label679;
          }
          ad.v("MicroMsg.WalletPwdCustomDialog", "alvinluo fingerprint pay");
          if (r.j(r.this) == null) {
            r.a(r.this, com.tencent.mm.ui.c.a.go(r.this.getContext()));
          }
          r.this.Dfs.setVisibility(8);
          r.this.DiB.setVisibility(4);
          r.j(r.this).reset();
          r.j(r.this).setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(71129);
              ad.i("MicroMsg.WalletPwdCustomDialog", "hy: on flash end");
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(71127);
                  r.this.DiB.setVisibility(8);
                  r.this.Dfs.setVisibility(0);
                  AppMethodBeat.o(71127);
                }
              });
              AppMethodBeat.o(71129);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(71128);
              ad.i("MicroMsg.WalletPwdCustomDialog", "hy: on flash start");
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(71126);
                  r.this.DiB.setVisibility(0);
                  AppMethodBeat.o(71126);
                }
              });
              AppMethodBeat.o(71128);
            }
          });
          r.this.DiB.startAnimation(r.j(r.this));
          com.tencent.mm.plugin.soter.d.a.RR(1);
          AppMethodBeat.o(71130);
          return;
          bool1 = false;
          break;
        }
        label679:
        if ((r.i(r.this) >= 3) || (bool1))
        {
          ad.v("MicroMsg.WalletPwdCustomDialog", "alvinluo change to pwd pay");
          r.eHT();
          r.this.DiC = 0;
          r.k(r.this);
          r.this.Diz.setVisibility(8);
          r.this.DiA.setVisibility(8);
          r.this.DiB.setVisibility(0);
          r.this.DiB.setText(2131765263);
          r.this.DiB.setTextColor(r.this.getContext().getResources().getColor(2131101133));
          r.this.Dif.setText(2131765747);
          r.this.Dik.setVisibility(0);
          if (!r.this.mKBLayout.isShown()) {
            r.this.mKBLayout.setVisibility(0);
          }
          com.tencent.mm.plugin.soter.d.a.RR(2);
          r.eHU();
        }
        AppMethodBeat.o(71130);
      }
    };
    com.tencent.mm.sdk.b.a.IbL.a(localod, Looper.getMainLooper());
    AppMethodBeat.o(71136);
  }
  
  private static void eHC()
  {
    AppMethodBeat.i(71137);
    ad.i("MicroMsg.WalletPwdCustomDialog", "hy: send release FPManager");
    qr localqr = new qr();
    com.tencent.mm.sdk.b.a.IbL.l(localqr);
    AppMethodBeat.o(71137);
  }
  
  private void eHP()
  {
    AppMethodBeat.i(71134);
    ad.v("MicroMsg.WalletPwdCustomDialog", "alvinluo updateFingerprintMode");
    this.DiE = 0;
    this.Diz.setVisibility(8);
    this.DiA.setVisibility(8);
    this.DiH = bt.HI();
    an localan = t.eFy();
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    if ((localan != null) && (locala.cPo())) {}
    for (boolean bool1 = locala.cPA();; bool1 = true)
    {
      ad.i("MicroMsg.WalletPwdCustomDialog", "hy: soter key status: %b", new Object[] { Boolean.valueOf(bool1) });
      this.DiI = 0;
      this.dCb = "";
      if ((locala != null) && (locala.cPt()) && (!locala.cPp())) {}
      for (bool1 = true;; bool1 = false)
      {
        ad.v("MicroMsg.WalletPwdCustomDialog", "alvinluo isDeviceSupportFp: %b", new Object[] { Boolean.valueOf(bool1) });
        boolean bool2;
        if ((locala != null) && (locala.cPo()))
        {
          bool2 = true;
          if ((!bool2) || (!bool1) || (!this.DiD) || (eHS())) {
            break label418;
          }
          this.Diz.setVisibility(0);
          this.Diz.setText(getContext().getString(2131765750));
          this.DiC = 1;
          this.DiA.setVisibility(0);
          this.Dfs.setVisibility(0);
          this.Dik.setVisibility(8);
          this.mKBLayout.setVisibility(8);
          this.Dif.setText(2131765741);
          this.DiI = 1;
          eHB();
          com.tencent.mm.plugin.report.service.g.yhR.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        for (;;)
        {
          ad.i("MicroMsg.WalletPwdCustomDialog", "isOpenTouch:" + bool2 + ",  isDeviceSupport:" + bool1 + ", use_pay_touch:" + this.DiD + ", isForcePwdMode:" + eHS());
          this.Diz.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(71125);
              b localb = new b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              if (r.this.DiC == 0) {
                r.a(r.this);
              }
              for (;;)
              {
                if (r.this.DiC == 1)
                {
                  r.eHT();
                  if (r.c(r.this)) {
                    r.d(r.this);
                  }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71125);
                return;
                if (r.this.DiC == 1) {
                  r.b(r.this);
                }
              }
            }
          });
          AppMethodBeat.o(71134);
          return;
          bool2 = false;
          break;
          label418:
          if ((bool2) && (bool1) && (this.DiD) && (eHS()))
          {
            this.Diz.setText(getContext().getString(2131765264));
            this.Diz.setVisibility(0);
            this.DiC = 0;
            this.DiA.setVisibility(8);
            this.Dik.setVisibility(0);
            if (!this.mKBLayout.isShown()) {
              this.mKBLayout.setVisibility(0);
            }
            this.Dif.setText(2131765747);
            this.DiI = 0;
            this.dCb = "";
            com.tencent.mm.plugin.report.service.g.yhR.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
            com.tencent.mm.wallet_core.ui.e.agr(8);
          }
          else
          {
            this.DiI = 0;
            this.dCb = "";
            this.Diz.setVisibility(8);
            com.tencent.mm.plugin.report.service.g.yhR.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          }
        }
      }
    }
  }
  
  private void eHQ()
  {
    AppMethodBeat.i(71135);
    this.Diz.setText(getContext().getString(2131765264));
    this.DiC = 0;
    this.DiH = bt.HI();
    this.DiA.setVisibility(8);
    this.Dik.setVisibility(0);
    if (!this.mKBLayout.isShown()) {
      this.mKBLayout.setVisibility(0);
    }
    this.Dif.setText(2131765747);
    ut(true);
    this.DiI = 0;
    this.dCb = "";
    com.tencent.mm.plugin.report.service.g.yhR.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    com.tencent.mm.wallet_core.ui.e.agr(29);
    eHC();
    AppMethodBeat.o(71135);
  }
  
  private static boolean eHS()
  {
    AppMethodBeat.i(71147);
    com.tencent.mm.kernel.g.ajD();
    Object localObject = com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IrY, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(71147);
      return bool;
    }
  }
  
  private static void ut(boolean paramBoolean)
  {
    AppMethodBeat.i(71146);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IrY, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(71146);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(71141);
    try
    {
      super.dismiss();
      eHC();
      this.CFp.destory();
      if (this.thQ != null) {
        this.thQ.cancel();
      }
      AppMethodBeat.o(71141);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.WalletPwdCustomDialog", "dismiss exception, e = " + localException.getMessage());
      }
    }
  }
  
  protected final void eHR()
  {
    AppMethodBeat.i(71142);
    ut(false);
    if (this.Div != null) {
      this.Div.onClick(this, 0);
    }
    dismiss();
    b localb;
    String str;
    if (this.Dil != null)
    {
      ad.i("MicroMsg.WalletPwdCustomDialog", "doOk use_touch: %s soterAuthReq: %s ", new Object[] { Integer.valueOf(this.DiI), this.dCb });
      localb = this.Dil;
      str = this.Dik.getText();
      if (this.DiI != 1) {
        break label127;
      }
    }
    label127:
    for (boolean bool = true;; bool = false)
    {
      localb.h(str, bool, this.dCb);
      if (this.DiH >= 0L) {
        break;
      }
      ad.e("MicroMsg.WalletPwdCustomDialog", "hy: not set update mode time yet. abandon");
      AppMethodBeat.o(71142);
      return;
    }
    if (this.DiC == 0)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(686L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(686L, 1L, bt.aO(this.DiH), false);
      AppMethodBeat.o(71142);
      return;
    }
    if (this.DiC == 1)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(686L, 2L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(686L, 3L, bt.aO(this.DiH), false);
    }
    AppMethodBeat.o(71142);
  }
  
  public final void eHn()
  {
    AppMethodBeat.i(71144);
    this.isPaused = false;
    if (u.aAB())
    {
      AppMethodBeat.o(71144);
      return;
    }
    AppMethodBeat.o(71144);
  }
  
  public final void onActivityPause()
  {
    AppMethodBeat.i(71145);
    this.isPaused = true;
    if (u.aAB())
    {
      AppMethodBeat.o(71145);
      return;
    }
    if (this.DiC == 1) {
      eHQ();
    }
    AppMethodBeat.o(71145);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71139);
    super.onCreate(paramBundle);
    setContentView(this.iCR);
    com.tencent.soter.a.g.f.fVe().fVf();
    AppMethodBeat.o(71139);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(71138);
    if (paramInt == 4)
    {
      if (this.XL != null) {
        this.XL.onCancel(this);
      }
      if (this.Diu != null) {
        this.Diu.dwF();
      }
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(71138);
    return bool;
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(71140);
    super.setCancelable(paramBoolean);
    this.ov = paramBoolean;
    setCanceledOnTouchOutside(this.ov);
    AppMethodBeat.o(71140);
  }
  
  public static abstract interface a
  {
    public abstract void dwF();
  }
  
  public static abstract interface b
  {
    public abstract void h(String paramString1, boolean paramBoolean, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.r
 * JD-Core Version:    0.7.0.1
 */