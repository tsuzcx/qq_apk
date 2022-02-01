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
import com.tencent.mm.g.a.nm;
import com.tencent.mm.g.a.nm.b;
import com.tencent.mm.g.a.px;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.a.c;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;
import com.tenpay.android.wechat.MyKeyboardWindow;
import org.json.JSONObject;

public final class r
  extends i
  implements f
{
  public ImageView AmF;
  public View ApA;
  public View ApB;
  public TextView ApC;
  public ImageView ApD;
  public TextView ApE;
  public TextView ApF;
  public View ApG;
  public TextView ApH;
  protected a ApI;
  protected DialogInterface.OnClickListener ApJ;
  protected boolean ApK;
  protected boolean ApL;
  protected Bankcard ApM;
  public TextView ApN;
  public View ApO;
  public TextView ApP;
  protected int ApQ;
  protected boolean ApR;
  private int ApS;
  private Animation ApT;
  private String ApU;
  private long ApV;
  private int ApW;
  private int ApX;
  private boolean ApY;
  public TextView Apt;
  public TextView Apu;
  public FavourLayout Apv;
  public CdnImageView Apw;
  public TextView Apx;
  public EditHintPasswdView Apy;
  public b Apz;
  protected DialogInterface.OnCancelListener Vb;
  private String dcE;
  private String dsE;
  public View hIZ;
  public ImageView ikp;
  private boolean isPaused;
  protected boolean lA;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private int rcE;
  private Animation rcU;
  public ImageView tnb;
  public TextView vGn;
  public TextView vRJ;
  protected com.tencent.mm.plugin.wallet_core.utils.a zMG;
  public TextView zRb;
  public Button zXZ;
  
  private r(Context paramContext)
  {
    super(paramContext, 2131821727);
    AppMethodBeat.i(71133);
    this.ApK = false;
    this.ApL = true;
    this.ApM = null;
    this.zMG = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.ApQ = 0;
    this.ApR = false;
    this.ApS = 0;
    this.rcE = 0;
    this.ApT = null;
    this.ApU = "";
    this.ApV = -1L;
    this.ApW = 0;
    this.dsE = "";
    this.ApX = 0;
    this.ApY = false;
    this.isPaused = false;
    ad.v("MicroMsg.WalletPwdCustomDialog", "alvinluo WalletPwdDialog initView");
    this.hIZ = View.inflate(paramContext, 2131495963, null);
    this.zXZ = ((Button)this.hIZ.findViewById(2131302314));
    this.tnb = ((ImageView)this.hIZ.findViewById(2131306819));
    this.mKeyboard = ((MyKeyboardWindow)this.hIZ.findViewById(2131305695));
    this.mKBLayout = this.hIZ.findViewById(2131305693);
    this.vRJ = ((TextView)this.hIZ.findViewById(2131298739));
    this.Apt = ((TextView)this.hIZ.findViewById(2131306826));
    this.vGn = ((TextView)this.hIZ.findViewById(2131299872));
    this.zRb = ((TextView)this.hIZ.findViewById(2131303087));
    this.zRb.getPaint().setFlags(16);
    this.Apu = ((TextView)this.hIZ.findViewById(2131297176));
    this.Apv = ((FavourLayout)this.hIZ.findViewById(2131299869));
    this.Apw = ((CdnImageView)this.hIZ.findViewById(2131297165));
    this.ApA = this.hIZ.findViewById(2131299861);
    this.Apx = ((TextView)this.hIZ.findViewById(2131302467));
    this.ikp = ((ImageView)this.hIZ.findViewById(2131298184));
    this.ApB = this.hIZ.findViewById(2131297163);
    this.ApC = ((TextView)this.hIZ.findViewById(2131304595));
    a.b.c(this.ikp, com.tencent.mm.wallet_core.ui.e.getUsername());
    this.Apy = ((EditHintPasswdView)this.hIZ.findViewById(2131301026));
    this.ApD = ((ImageView)this.hIZ.findViewById(2131300682));
    this.ApN = ((TextView)this.hIZ.findViewById(2131306814));
    this.ApO = this.hIZ.findViewById(2131300088);
    this.ApP = ((TextView)this.hIZ.findViewById(2131300091));
    this.AmF = ((ImageView)this.hIZ.findViewById(2131300087));
    this.ApE = ((TextView)this.hIZ.findViewById(2131297953));
    this.ApF = ((TextView)this.hIZ.findViewById(2131303711));
    this.ApG = this.hIZ.findViewById(2131299859);
    this.ApH = ((TextView)this.hIZ.findViewById(2131299868));
    this.Apv.setVisibility(8);
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    this.zXZ.setEnabled(false);
    this.zXZ.setTextColor(paramContext.getResources().getColorStateList(2131101098));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.Apy);
    this.Apy.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(71122);
        if (paramAnonymousBoolean)
        {
          r.this.eeq();
          com.tencent.mm.plugin.report.service.h.vKh.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        AppMethodBeat.o(71122);
      }
    });
    this.Apy.requestFocus();
    Object localObject = (TextView)this.hIZ.findViewById(2131306826);
    if (localObject != null) {
      ((TextView)localObject).setText(ah.kp(paramContext));
    }
    paramContext = (EditText)this.hIZ.findViewById(2131306718);
    com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(paramContext);
    this.mKeyboard.setInputEditText(paramContext);
    if (Build.VERSION.SDK_INT >= 14)
    {
      localObject = new c();
      this.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
      paramContext.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
    }
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71123);
        if (!r.this.mKBLayout.isShown()) {
          r.this.mKBLayout.setVisibility(0);
        }
        AppMethodBeat.o(71123);
      }
    });
    this.hIZ.findViewById(2131305696).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71124);
        if (r.this.mKBLayout.isShown()) {
          r.this.mKBLayout.setVisibility(8);
        }
        AppMethodBeat.o(71124);
      }
    });
    eeo();
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
    if (localr.zXZ != null)
    {
      localr.ApJ = null;
      localr.zXZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71131);
          r.this.eeq();
          AppMethodBeat.o(71131);
        }
      });
    }
    if (localr.tnb != null)
    {
      localr.Vb = paramOnCancelListener;
      localr.tnb.setVisibility(0);
      localr.tnb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71132);
          if (paramOnCancelListener != null) {
            paramOnCancelListener.onCancel(null);
          }
          if (r.this.ApI != null) {
            r.this.ApI.cYG();
          }
          r.this.cancel();
          if (r.this.ApN.isShown())
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
            AppMethodBeat.o(71132);
            return;
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(71132);
        }
      });
    }
    localr.setOnCancelListener(paramOnCancelListener);
    localr.setCancelable(true);
    localr.vRJ.setText(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      localr.vGn.setVisibility(0);
      localr.vGn.setText(paramString2);
      localr.ApB.setVisibility(8);
      localr.ApL = false;
      localr.ApI = parama;
      if (TextUtils.isEmpty(paramString3)) {
        break label261;
      }
      localr.ApE.setVisibility(0);
      localr.ApE.setText(paramString3);
    }
    for (;;)
    {
      localr.Apz = paramb;
      localr.ApR = paramBoolean;
      if (!u.aqV()) {
        localr.eeo();
      }
      localr.show();
      com.tencent.mm.ui.base.h.a(paramContext, localr);
      AppMethodBeat.o(71143);
      return localr;
      localr.vGn.setVisibility(8);
      break;
      label261:
      ad.i("MicroMsg.WalletPwdCustomDialog", "ChargeFee is null");
      localr.ApE.setVisibility(8);
    }
  }
  
  private void eea()
  {
    AppMethodBeat.i(71136);
    ad.i("MicroMsg.WalletPwdCustomDialog", "reqFingerPrintAuth %s", new Object[] { bt.eGN().toString() });
    com.tencent.mm.plugin.soter.d.a.dEP();
    final nm localnm = new nm();
    localnm.dsz.dlJ = this.dcE;
    localnm.dsz.dsB = 1;
    localnm.dsz.dsD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71130);
        ad.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback");
        Object localObject = localnm.dsA;
        if (localObject == null)
        {
          r.a(r.this, 0);
          ad.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, result == null");
          AppMethodBeat.o(71130);
          return;
        }
        int i = ((nm.b)localObject).errCode;
        ad.v("MicroMsg.WalletPwdCustomDialog", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), ((nm.b)localObject).errMsg });
        if (i == 0)
        {
          ad.i("MicroMsg.WalletPwdCustomDialog", "hy: payInfo soterAuthReq: %s", new Object[] { ((nm.b)localObject).dsE });
          r.a(r.this, 1);
          r.a(r.this, ((nm.b)localObject).dsE);
          try
          {
            localObject = new JSONObject(r.e(r.this));
            ((JSONObject)localObject).put("soter_type", "1");
            r.a(r.this, ((JSONObject)localObject).toString());
            r.f(r.this);
            r.this.ApP.setText("");
            r.this.eeq();
            com.tencent.mm.plugin.report.service.h.vKh.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
            com.tencent.mm.plugin.soter.d.a.Oe(0);
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
        r.this.ApO.setVisibility(0);
        r.this.ApP.setTextColor(r.this.getContext().getResources().getColor(2131100798));
        r.this.ApP.setText(2131765262);
        int j = (int)(System.currentTimeMillis() / 1000L);
        int k = j - r.g(r.this);
        if (k > 1)
        {
          r.b(r.this, j);
          r.h(r.this);
          r.f(r.this);
        }
        com.tencent.mm.plugin.report.service.h.vKh.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
        boolean bool1;
        if ((i == 2) || (i == 10308))
        {
          bool1 = true;
          if (localException.dsF != 2) {
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
            r.a(r.this, com.tencent.mm.ui.c.a.fZ(r.this.getContext()));
          }
          r.this.AmF.setVisibility(8);
          r.this.ApP.setVisibility(4);
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
                  r.this.ApP.setVisibility(8);
                  r.this.AmF.setVisibility(0);
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
                  r.this.ApP.setVisibility(0);
                  AppMethodBeat.o(71126);
                }
              });
              AppMethodBeat.o(71128);
            }
          });
          r.this.ApP.startAnimation(r.j(r.this));
          com.tencent.mm.plugin.soter.d.a.Oe(1);
          AppMethodBeat.o(71130);
          return;
          bool1 = false;
          break;
        }
        label679:
        if ((r.i(r.this) >= 3) || (bool1))
        {
          ad.v("MicroMsg.WalletPwdCustomDialog", "alvinluo change to pwd pay");
          r.ees();
          r.this.ApQ = 0;
          r.k(r.this);
          r.this.ApN.setVisibility(8);
          r.this.ApO.setVisibility(8);
          r.this.ApP.setVisibility(0);
          r.this.ApP.setText(2131765263);
          r.this.ApP.setTextColor(r.this.getContext().getResources().getColor(2131101133));
          r.this.Apt.setText(2131765747);
          r.this.Apy.setVisibility(0);
          if (!r.this.mKBLayout.isShown()) {
            r.this.mKBLayout.setVisibility(0);
          }
          com.tencent.mm.plugin.soter.d.a.Oe(2);
          r.eet();
        }
        AppMethodBeat.o(71130);
      }
    };
    com.tencent.mm.sdk.b.a.ESL.a(localnm, Looper.getMainLooper());
    AppMethodBeat.o(71136);
  }
  
  private static void eeb()
  {
    AppMethodBeat.i(71137);
    ad.i("MicroMsg.WalletPwdCustomDialog", "hy: send release FPManager");
    px localpx = new px();
    com.tencent.mm.sdk.b.a.ESL.l(localpx);
    AppMethodBeat.o(71137);
  }
  
  private void eeo()
  {
    AppMethodBeat.i(71134);
    ad.v("MicroMsg.WalletPwdCustomDialog", "alvinluo updateFingerprintMode");
    this.ApS = 0;
    this.ApN.setVisibility(8);
    this.ApO.setVisibility(8);
    this.ApV = bt.GC();
    am localam = s.ecc();
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    if ((localam != null) && (locala.ctN())) {}
    for (boolean bool1 = locala.ctZ();; bool1 = true)
    {
      ad.i("MicroMsg.WalletPwdCustomDialog", "hy: soter key status: %b", new Object[] { Boolean.valueOf(bool1) });
      this.ApW = 0;
      this.dsE = "";
      if ((locala != null) && (locala.ctS()) && (!locala.ctO())) {}
      for (bool1 = true;; bool1 = false)
      {
        ad.v("MicroMsg.WalletPwdCustomDialog", "alvinluo isDeviceSupportFp: %b", new Object[] { Boolean.valueOf(bool1) });
        boolean bool2;
        if ((locala != null) && (locala.ctN()))
        {
          bool2 = true;
          if ((!bool2) || (!bool1) || (!this.ApR) || (eer())) {
            break label418;
          }
          this.ApN.setVisibility(0);
          this.ApN.setText(getContext().getString(2131765750));
          this.ApQ = 1;
          this.ApO.setVisibility(0);
          this.AmF.setVisibility(0);
          this.Apy.setVisibility(8);
          this.mKBLayout.setVisibility(8);
          this.Apt.setText(2131765741);
          this.ApW = 1;
          eea();
          com.tencent.mm.plugin.report.service.h.vKh.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        for (;;)
        {
          ad.i("MicroMsg.WalletPwdCustomDialog", "isOpenTouch:" + bool2 + ",  isDeviceSupport:" + bool1 + ", use_pay_touch:" + this.ApR + ", isForcePwdMode:" + eer());
          this.ApN.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(71125);
              if (r.this.ApQ == 0) {
                r.a(r.this);
              }
              for (;;)
              {
                if (r.this.ApQ == 1)
                {
                  r.ees();
                  if (r.c(r.this)) {
                    r.d(r.this);
                  }
                }
                AppMethodBeat.o(71125);
                return;
                if (r.this.ApQ == 1) {
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
          if ((bool2) && (bool1) && (this.ApR) && (eer()))
          {
            this.ApN.setText(getContext().getString(2131765264));
            this.ApN.setVisibility(0);
            this.ApQ = 0;
            this.ApO.setVisibility(8);
            this.Apy.setVisibility(0);
            if (!this.mKBLayout.isShown()) {
              this.mKBLayout.setVisibility(0);
            }
            this.Apt.setText(2131765747);
            this.ApW = 0;
            this.dsE = "";
            com.tencent.mm.plugin.report.service.h.vKh.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
            com.tencent.mm.wallet_core.ui.e.aby(8);
          }
          else
          {
            this.ApW = 0;
            this.dsE = "";
            this.ApN.setVisibility(8);
            com.tencent.mm.plugin.report.service.h.vKh.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          }
        }
      }
    }
  }
  
  private void eep()
  {
    AppMethodBeat.i(71135);
    this.ApN.setText(getContext().getString(2131765264));
    this.ApQ = 0;
    this.ApV = bt.GC();
    this.ApO.setVisibility(8);
    this.Apy.setVisibility(0);
    if (!this.mKBLayout.isShown()) {
      this.mKBLayout.setVisibility(0);
    }
    this.Apt.setText(2131765747);
    sI(true);
    this.ApW = 0;
    this.dsE = "";
    com.tencent.mm.plugin.report.service.h.vKh.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    com.tencent.mm.wallet_core.ui.e.aby(29);
    eeb();
    AppMethodBeat.o(71135);
  }
  
  private static boolean eer()
  {
    AppMethodBeat.i(71147);
    g.afC();
    Object localObject = g.afB().afk().get(ae.a.FhR, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(71147);
      return bool;
    }
  }
  
  private static void sI(boolean paramBoolean)
  {
    AppMethodBeat.i(71146);
    g.afC();
    g.afB().afk().set(ae.a.FhR, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(71146);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(71141);
    try
    {
      super.dismiss();
      eeb();
      this.zMG.destory();
      if (this.rcU != null) {
        this.rcU.cancel();
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
  
  public final void edM()
  {
    AppMethodBeat.i(71144);
    this.isPaused = false;
    if (u.aqV())
    {
      AppMethodBeat.o(71144);
      return;
    }
    AppMethodBeat.o(71144);
  }
  
  protected final void eeq()
  {
    AppMethodBeat.i(71142);
    sI(false);
    if (this.ApJ != null) {
      this.ApJ.onClick(this, 0);
    }
    dismiss();
    b localb;
    String str;
    if (this.Apz != null)
    {
      ad.i("MicroMsg.WalletPwdCustomDialog", "doOk use_touch: %s soterAuthReq: %s ", new Object[] { Integer.valueOf(this.ApW), this.dsE });
      localb = this.Apz;
      str = this.Apy.getText();
      if (this.ApW != 1) {
        break label127;
      }
    }
    label127:
    for (boolean bool = true;; bool = false)
    {
      localb.h(str, bool, this.dsE);
      if (this.ApV >= 0L) {
        break;
      }
      ad.e("MicroMsg.WalletPwdCustomDialog", "hy: not set update mode time yet. abandon");
      AppMethodBeat.o(71142);
      return;
    }
    if (this.ApQ == 0)
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(686L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(686L, 1L, bt.aS(this.ApV), false);
      AppMethodBeat.o(71142);
      return;
    }
    if (this.ApQ == 1)
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(686L, 2L, 1L, false);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(686L, 3L, bt.aS(this.ApV), false);
    }
    AppMethodBeat.o(71142);
  }
  
  public final void onActivityPause()
  {
    AppMethodBeat.i(71145);
    this.isPaused = true;
    if (u.aqV())
    {
      AppMethodBeat.o(71145);
      return;
    }
    if (this.ApQ == 1) {
      eep();
    }
    AppMethodBeat.o(71145);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71139);
    super.onCreate(paramBundle);
    setContentView(this.hIZ);
    com.tencent.soter.a.g.f.fnw().fnx();
    AppMethodBeat.o(71139);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(71138);
    if (paramInt == 4)
    {
      if (this.Vb != null) {
        this.Vb.onCancel(this);
      }
      if (this.ApI != null) {
        this.ApI.cYG();
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
    this.lA = paramBoolean;
    setCanceledOnTouchOutside(this.lA);
    AppMethodBeat.o(71140);
  }
  
  public static abstract interface a
  {
    public abstract void cYG();
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