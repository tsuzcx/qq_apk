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
import com.tencent.mm.g.a.nv;
import com.tencent.mm.g.a.nv.b;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  public ImageView BFa;
  public TextView BHN;
  public TextView BHO;
  public FavourLayout BHP;
  public CdnImageView BHQ;
  public TextView BHR;
  public EditHintPasswdView BHS;
  public b BHT;
  public View BHU;
  public View BHV;
  public TextView BHW;
  public ImageView BHX;
  public TextView BHY;
  public TextView BHZ;
  public View BIa;
  public TextView BIb;
  protected a BIc;
  protected DialogInterface.OnClickListener BId;
  protected boolean BIe;
  protected boolean BIf;
  protected Bankcard BIg;
  public TextView BIh;
  public View BIi;
  public TextView BIj;
  protected int BIk;
  protected boolean BIl;
  private int BIm;
  private Animation BIn;
  private String BIo;
  private long BIp;
  private int BIq;
  private int BIr;
  private boolean BIs;
  protected com.tencent.mm.plugin.wallet_core.utils.a Bfa;
  public TextView Bjv;
  public Button Bqt;
  protected DialogInterface.OnCancelListener VW;
  private String dac;
  private String dqo;
  public ImageView iKw;
  public View ijA;
  private boolean isPaused;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  protected boolean mz;
  private int skY;
  private Animation slo;
  public ImageView uvu;
  public TextView wQs;
  public TextView xcu;
  
  private r(Context paramContext)
  {
    super(paramContext, 2131821727);
    AppMethodBeat.i(71133);
    this.BIe = false;
    this.BIf = true;
    this.BIg = null;
    this.Bfa = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.BIk = 0;
    this.BIl = false;
    this.BIm = 0;
    this.skY = 0;
    this.BIn = null;
    this.BIo = "";
    this.BIp = -1L;
    this.BIq = 0;
    this.dqo = "";
    this.BIr = 0;
    this.BIs = false;
    this.isPaused = false;
    ac.v("MicroMsg.WalletPwdCustomDialog", "alvinluo WalletPwdDialog initView");
    this.ijA = View.inflate(paramContext, 2131495963, null);
    this.Bqt = ((Button)this.ijA.findViewById(2131302314));
    this.uvu = ((ImageView)this.ijA.findViewById(2131306819));
    this.mKeyboard = ((MyKeyboardWindow)this.ijA.findViewById(2131305695));
    this.mKBLayout = this.ijA.findViewById(2131305693);
    this.xcu = ((TextView)this.ijA.findViewById(2131298739));
    this.BHN = ((TextView)this.ijA.findViewById(2131306826));
    this.wQs = ((TextView)this.ijA.findViewById(2131299872));
    this.Bjv = ((TextView)this.ijA.findViewById(2131303087));
    this.Bjv.getPaint().setFlags(16);
    this.BHO = ((TextView)this.ijA.findViewById(2131297176));
    this.BHP = ((FavourLayout)this.ijA.findViewById(2131299869));
    this.BHQ = ((CdnImageView)this.ijA.findViewById(2131297165));
    this.BHU = this.ijA.findViewById(2131299861);
    this.BHR = ((TextView)this.ijA.findViewById(2131302467));
    this.iKw = ((ImageView)this.ijA.findViewById(2131298184));
    this.BHV = this.ijA.findViewById(2131297163);
    this.BHW = ((TextView)this.ijA.findViewById(2131304595));
    a.b.c(this.iKw, com.tencent.mm.wallet_core.ui.e.getUsername());
    this.BHS = ((EditHintPasswdView)this.ijA.findViewById(2131301026));
    this.BHX = ((ImageView)this.ijA.findViewById(2131300682));
    this.BIh = ((TextView)this.ijA.findViewById(2131306814));
    this.BIi = this.ijA.findViewById(2131300088);
    this.BIj = ((TextView)this.ijA.findViewById(2131300091));
    this.BFa = ((ImageView)this.ijA.findViewById(2131300087));
    this.BHY = ((TextView)this.ijA.findViewById(2131297953));
    this.BHZ = ((TextView)this.ijA.findViewById(2131303711));
    this.BIa = this.ijA.findViewById(2131299859);
    this.BIb = ((TextView)this.ijA.findViewById(2131299868));
    this.BHP.setVisibility(8);
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    this.Bqt.setEnabled(false);
    this.Bqt.setTextColor(paramContext.getResources().getColorStateList(2131101098));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.BHS);
    this.BHS.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(71122);
        if (paramAnonymousBoolean)
        {
          r.this.etL();
          com.tencent.mm.plugin.report.service.h.wUl.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        AppMethodBeat.o(71122);
      }
    });
    this.BHS.requestFocus();
    Object localObject = (TextView)this.ijA.findViewById(2131306826);
    if (localObject != null) {
      ((TextView)localObject).setText(ah.kB(paramContext));
    }
    paramContext = (EditText)this.ijA.findViewById(2131306718);
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
    this.ijA.findViewById(2131305696).setOnClickListener(new View.OnClickListener()
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
    etJ();
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
    if (localr.Bqt != null)
    {
      localr.BId = null;
      localr.Bqt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71131);
          r.this.etL();
          AppMethodBeat.o(71131);
        }
      });
    }
    if (localr.uvu != null)
    {
      localr.VW = paramOnCancelListener;
      localr.uvu.setVisibility(0);
      localr.uvu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71132);
          if (paramOnCancelListener != null) {
            paramOnCancelListener.onCancel(null);
          }
          if (r.this.BIc != null) {
            r.this.BIc.dmo();
          }
          r.this.cancel();
          if (r.this.BIh.isShown())
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
            AppMethodBeat.o(71132);
            return;
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(71132);
        }
      });
    }
    localr.setOnCancelListener(paramOnCancelListener);
    localr.setCancelable(true);
    localr.xcu.setText(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      localr.wQs.setVisibility(0);
      localr.wQs.setText(paramString2);
      localr.BHV.setVisibility(8);
      localr.BIf = false;
      localr.BIc = parama;
      if (TextUtils.isEmpty(paramString3)) {
        break label261;
      }
      localr.BHY.setVisibility(0);
      localr.BHY.setText(paramString3);
    }
    for (;;)
    {
      localr.BHT = paramb;
      localr.BIl = paramBoolean;
      if (!u.axL()) {
        localr.etJ();
      }
      localr.show();
      com.tencent.mm.ui.base.h.a(paramContext, localr);
      AppMethodBeat.o(71143);
      return localr;
      localr.wQs.setVisibility(8);
      break;
      label261:
      ac.i("MicroMsg.WalletPwdCustomDialog", "ChargeFee is null");
      localr.BHY.setVisibility(8);
    }
  }
  
  private void etJ()
  {
    AppMethodBeat.i(71134);
    ac.v("MicroMsg.WalletPwdCustomDialog", "alvinluo updateFingerprintMode");
    this.BIm = 0;
    this.BIh.setVisibility(8);
    this.BIi.setVisibility(8);
    this.BIp = bs.Gn();
    am localam = s.ery();
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    if ((localam != null) && (locala.cGZ())) {}
    for (boolean bool1 = locala.cHl();; bool1 = true)
    {
      ac.i("MicroMsg.WalletPwdCustomDialog", "hy: soter key status: %b", new Object[] { Boolean.valueOf(bool1) });
      this.BIq = 0;
      this.dqo = "";
      if ((locala != null) && (locala.cHe()) && (!locala.cHa())) {}
      for (bool1 = true;; bool1 = false)
      {
        ac.v("MicroMsg.WalletPwdCustomDialog", "alvinluo isDeviceSupportFp: %b", new Object[] { Boolean.valueOf(bool1) });
        boolean bool2;
        if ((locala != null) && (locala.cGZ()))
        {
          bool2 = true;
          if ((!bool2) || (!bool1) || (!this.BIl) || (etM())) {
            break label418;
          }
          this.BIh.setVisibility(0);
          this.BIh.setText(getContext().getString(2131765750));
          this.BIk = 1;
          this.BIi.setVisibility(0);
          this.BFa.setVisibility(0);
          this.BHS.setVisibility(8);
          this.mKBLayout.setVisibility(8);
          this.BHN.setText(2131765741);
          this.BIq = 1;
          etv();
          com.tencent.mm.plugin.report.service.h.wUl.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        for (;;)
        {
          ac.i("MicroMsg.WalletPwdCustomDialog", "isOpenTouch:" + bool2 + ",  isDeviceSupport:" + bool1 + ", use_pay_touch:" + this.BIl + ", isForcePwdMode:" + etM());
          this.BIh.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(71125);
              if (r.this.BIk == 0) {
                r.a(r.this);
              }
              for (;;)
              {
                if (r.this.BIk == 1)
                {
                  r.etN();
                  if (r.c(r.this)) {
                    r.d(r.this);
                  }
                }
                AppMethodBeat.o(71125);
                return;
                if (r.this.BIk == 1) {
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
          if ((bool2) && (bool1) && (this.BIl) && (etM()))
          {
            this.BIh.setText(getContext().getString(2131765264));
            this.BIh.setVisibility(0);
            this.BIk = 0;
            this.BIi.setVisibility(8);
            this.BHS.setVisibility(0);
            if (!this.mKBLayout.isShown()) {
              this.mKBLayout.setVisibility(0);
            }
            this.BHN.setText(2131765747);
            this.BIq = 0;
            this.dqo = "";
            com.tencent.mm.plugin.report.service.h.wUl.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
            com.tencent.mm.wallet_core.ui.e.adR(8);
          }
          else
          {
            this.BIq = 0;
            this.dqo = "";
            this.BIh.setVisibility(8);
            com.tencent.mm.plugin.report.service.h.wUl.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          }
        }
      }
    }
  }
  
  private void etK()
  {
    AppMethodBeat.i(71135);
    this.BIh.setText(getContext().getString(2131765264));
    this.BIk = 0;
    this.BIp = bs.Gn();
    this.BIi.setVisibility(8);
    this.BHS.setVisibility(0);
    if (!this.mKBLayout.isShown()) {
      this.mKBLayout.setVisibility(0);
    }
    this.BHN.setText(2131765747);
    tJ(true);
    this.BIq = 0;
    this.dqo = "";
    com.tencent.mm.plugin.report.service.h.wUl.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    com.tencent.mm.wallet_core.ui.e.adR(29);
    etw();
    AppMethodBeat.o(71135);
  }
  
  private static boolean etM()
  {
    AppMethodBeat.i(71147);
    g.agS();
    Object localObject = g.agR().agA().get(ah.a.GFG, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(71147);
      return bool;
    }
  }
  
  private void etv()
  {
    AppMethodBeat.i(71136);
    ac.i("MicroMsg.WalletPwdCustomDialog", "reqFingerPrintAuth %s", new Object[] { bs.eWi().toString() });
    com.tencent.mm.plugin.soter.d.a.dTo();
    final nv localnv = new nv();
    localnv.dqj.djr = this.dac;
    localnv.dqj.dql = 1;
    localnv.dqj.dqn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71130);
        ac.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback");
        Object localObject = localnv.dqk;
        if (localObject == null)
        {
          r.a(r.this, 0);
          ac.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, result == null");
          AppMethodBeat.o(71130);
          return;
        }
        int i = ((nv.b)localObject).errCode;
        ac.v("MicroMsg.WalletPwdCustomDialog", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), ((nv.b)localObject).errMsg });
        if (i == 0)
        {
          ac.i("MicroMsg.WalletPwdCustomDialog", "hy: payInfo soterAuthReq: %s", new Object[] { ((nv.b)localObject).dqo });
          r.a(r.this, 1);
          r.a(r.this, ((nv.b)localObject).dqo);
          try
          {
            localObject = new JSONObject(r.e(r.this));
            ((JSONObject)localObject).put("soter_type", "1");
            r.a(r.this, ((JSONObject)localObject).toString());
            r.f(r.this);
            r.this.BIj.setText("");
            r.this.etL();
            com.tencent.mm.plugin.report.service.h.wUl.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
            com.tencent.mm.plugin.soter.d.a.Qj(0);
            AppMethodBeat.o(71130);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ac.printErrStackTrace("MicroMsg.WalletPwdCustomDialog", localException, "", new Object[0]);
            }
          }
        }
        ac.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
        r.a(r.this, 0);
        r.a(r.this, "");
        r.this.BIi.setVisibility(0);
        r.this.BIj.setTextColor(r.this.getContext().getResources().getColor(2131100798));
        r.this.BIj.setText(2131765262);
        int j = (int)(System.currentTimeMillis() / 1000L);
        int k = j - r.g(r.this);
        if (k > 1)
        {
          r.b(r.this, j);
          r.h(r.this);
          r.f(r.this);
        }
        com.tencent.mm.plugin.report.service.h.wUl.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
        boolean bool1;
        if ((i == 2) || (i == 10308))
        {
          bool1 = true;
          if (localException.dqp != 2) {
            break label673;
          }
        }
        label673:
        for (boolean bool2 = true;; bool2 = false)
        {
          ac.v("MicroMsg.WalletPwdCustomDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(r.i(r.this)), Integer.valueOf(i), Boolean.valueOf(bool2) });
          if (((!bool2) && ((r.i(r.this) >= 3) || (k <= 1))) || (bool1)) {
            break label679;
          }
          ac.v("MicroMsg.WalletPwdCustomDialog", "alvinluo fingerprint pay");
          if (r.j(r.this) == null) {
            r.a(r.this, com.tencent.mm.ui.c.a.gl(r.this.getContext()));
          }
          r.this.BFa.setVisibility(8);
          r.this.BIj.setVisibility(4);
          r.j(r.this).reset();
          r.j(r.this).setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(71129);
              ac.i("MicroMsg.WalletPwdCustomDialog", "hy: on flash end");
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(71127);
                  r.this.BIj.setVisibility(8);
                  r.this.BFa.setVisibility(0);
                  AppMethodBeat.o(71127);
                }
              });
              AppMethodBeat.o(71129);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(71128);
              ac.i("MicroMsg.WalletPwdCustomDialog", "hy: on flash start");
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(71126);
                  r.this.BIj.setVisibility(0);
                  AppMethodBeat.o(71126);
                }
              });
              AppMethodBeat.o(71128);
            }
          });
          r.this.BIj.startAnimation(r.j(r.this));
          com.tencent.mm.plugin.soter.d.a.Qj(1);
          AppMethodBeat.o(71130);
          return;
          bool1 = false;
          break;
        }
        label679:
        if ((r.i(r.this) >= 3) || (bool1))
        {
          ac.v("MicroMsg.WalletPwdCustomDialog", "alvinluo change to pwd pay");
          r.etN();
          r.this.BIk = 0;
          r.k(r.this);
          r.this.BIh.setVisibility(8);
          r.this.BIi.setVisibility(8);
          r.this.BIj.setVisibility(0);
          r.this.BIj.setText(2131765263);
          r.this.BIj.setTextColor(r.this.getContext().getResources().getColor(2131101133));
          r.this.BHN.setText(2131765747);
          r.this.BHS.setVisibility(0);
          if (!r.this.mKBLayout.isShown()) {
            r.this.mKBLayout.setVisibility(0);
          }
          com.tencent.mm.plugin.soter.d.a.Qj(2);
          r.etO();
        }
        AppMethodBeat.o(71130);
      }
    };
    com.tencent.mm.sdk.b.a.GpY.a(localnv, Looper.getMainLooper());
    AppMethodBeat.o(71136);
  }
  
  private static void etw()
  {
    AppMethodBeat.i(71137);
    ac.i("MicroMsg.WalletPwdCustomDialog", "hy: send release FPManager");
    qg localqg = new qg();
    com.tencent.mm.sdk.b.a.GpY.l(localqg);
    AppMethodBeat.o(71137);
  }
  
  private static void tJ(boolean paramBoolean)
  {
    AppMethodBeat.i(71146);
    g.agS();
    g.agR().agA().set(ah.a.GFG, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(71146);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(71141);
    try
    {
      super.dismiss();
      etw();
      this.Bfa.destory();
      if (this.slo != null) {
        this.slo.cancel();
      }
      AppMethodBeat.o(71141);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.WalletPwdCustomDialog", "dismiss exception, e = " + localException.getMessage());
      }
    }
  }
  
  protected final void etL()
  {
    AppMethodBeat.i(71142);
    tJ(false);
    if (this.BId != null) {
      this.BId.onClick(this, 0);
    }
    dismiss();
    b localb;
    String str;
    if (this.BHT != null)
    {
      ac.i("MicroMsg.WalletPwdCustomDialog", "doOk use_touch: %s soterAuthReq: %s ", new Object[] { Integer.valueOf(this.BIq), this.dqo });
      localb = this.BHT;
      str = this.BHS.getText();
      if (this.BIq != 1) {
        break label127;
      }
    }
    label127:
    for (boolean bool = true;; bool = false)
    {
      localb.h(str, bool, this.dqo);
      if (this.BIp >= 0L) {
        break;
      }
      ac.e("MicroMsg.WalletPwdCustomDialog", "hy: not set update mode time yet. abandon");
      AppMethodBeat.o(71142);
      return;
    }
    if (this.BIk == 0)
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(686L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(686L, 1L, bs.aO(this.BIp), false);
      AppMethodBeat.o(71142);
      return;
    }
    if (this.BIk == 1)
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(686L, 2L, 1L, false);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(686L, 3L, bs.aO(this.BIp), false);
    }
    AppMethodBeat.o(71142);
  }
  
  public final void eth()
  {
    AppMethodBeat.i(71144);
    this.isPaused = false;
    if (u.axL())
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
    if (u.axL())
    {
      AppMethodBeat.o(71145);
      return;
    }
    if (this.BIk == 1) {
      etK();
    }
    AppMethodBeat.o(71145);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71139);
    super.onCreate(paramBundle);
    setContentView(this.ijA);
    com.tencent.soter.a.g.f.fDM().fDN();
    AppMethodBeat.o(71139);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(71138);
    if (paramInt == 4)
    {
      if (this.VW != null) {
        this.VW.onCancel(this);
      }
      if (this.BIc != null) {
        this.BIc.dmo();
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
    this.mz = paramBoolean;
    setCanceledOnTouchOutside(this.mz);
    AppMethodBeat.o(71140);
  }
  
  public static abstract interface a
  {
    public abstract void dmo();
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