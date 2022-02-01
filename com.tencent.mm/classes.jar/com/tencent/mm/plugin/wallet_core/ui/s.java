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
import com.tencent.mm.f.a.pt;
import com.tencent.mm.f.a.pt.b;
import com.tencent.mm.f.a.sl;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.a.d;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import org.json.JSONObject;

public final class s
  extends i
  implements g
{
  private int ByW;
  private Animation Bzl;
  public ImageView EKk;
  public TextView IPM;
  public TextView Isv;
  protected com.tencent.mm.plugin.wallet_core.utils.a OuA;
  public TextView OyX;
  protected a PbA;
  protected DialogInterface.OnClickListener PbB;
  protected boolean PbC;
  protected boolean PbD;
  protected Bankcard PbE;
  public TextView PbF;
  public View PbG;
  public TextView PbH;
  public ImageView PbI;
  protected int PbJ;
  protected boolean PbK;
  private int PbL;
  private Animation PbM;
  private String PbN;
  private long PbO;
  private int PbP;
  private int PbQ;
  private boolean PbR;
  public TextView Pbl;
  public TextView Pbm;
  public FavourLayout Pbn;
  public CdnImageView Pbo;
  public TextView Pbp;
  public EditHintPasswdView Pbq;
  public b Pbr;
  public View Pbs;
  public View Pbt;
  public TextView Pbu;
  public ImageView Pbv;
  public TextView Pbw;
  public TextView Pbx;
  public View Pby;
  public TextView Pbz;
  protected boolean bxO;
  private String fOx;
  protected DialogInterface.OnCancelListener fs;
  private String fwv;
  private boolean isPaused;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  public ImageView mWb;
  public View mrI;
  public Button xPd;
  
  private s(Context paramContext)
  {
    super(paramContext, a.j.mmpwddialog);
    AppMethodBeat.i(71133);
    this.PbC = false;
    this.PbD = true;
    this.PbE = null;
    this.OuA = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.PbJ = 0;
    this.PbK = false;
    this.PbL = 0;
    this.ByW = 0;
    this.PbM = null;
    this.PbN = "";
    this.PbO = -1L;
    this.PbP = 0;
    this.fOx = "";
    this.PbQ = 0;
    this.PbR = false;
    this.isPaused = false;
    Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo WalletPwdDialog initView");
    this.mrI = View.inflate(paramContext, a.g.wallet_full_pwd_dialog, null);
    this.xPd = ((Button)this.mrI.findViewById(a.f.mm_alert_ok_btn));
    this.EKk = ((ImageView)this.mrI.findViewById(a.f.wallet_pwd_close_iv));
    this.mKeyboard = ((MyKeyboardWindow)this.mrI.findViewById(a.f.tenpay_num_keyboard));
    this.mKBLayout = this.mrI.findViewById(a.f.tenpay_keyboard_layout);
    this.IPM = ((TextView)this.mrI.findViewById(a.f.content));
    this.Pbl = ((TextView)this.mrI.findViewById(a.f.wallet_pwd_title_tv));
    this.Isv = ((TextView)this.mrI.findViewById(a.f.fee));
    this.OyX = ((TextView)this.mrI.findViewById(a.f.origin_fee));
    this.OyX.getPaint().setFlags(16);
    this.Pbm = ((TextView)this.mrI.findViewById(a.f.bankcard_tv));
    this.Pbn = ((FavourLayout)this.mrI.findViewById(a.f.favour_tip));
    this.Pbo = ((CdnImageView)this.mrI.findViewById(a.f.bankcard_logo));
    this.Pbs = this.mrI.findViewById(a.f.favor_ll);
    this.Pbp = ((TextView)this.mrI.findViewById(a.f.more_favors));
    this.mWb = ((ImageView)this.mrI.findViewById(a.f.chatting_user_iv));
    this.Pbt = this.mrI.findViewById(a.f.bankcard_layout);
    this.Pbu = ((TextView)this.mrI.findViewById(a.f.seperator));
    a.b.c(this.mWb, com.tencent.mm.wallet_core.ui.g.getUsername());
    this.Pbq = ((EditHintPasswdView)this.mrI.findViewById(a.f.input_et));
    this.Pbv = ((ImageView)this.mrI.findViewById(a.f.has_larger_favor_reddot));
    this.PbF = ((TextView)this.mrI.findViewById(a.f.wallet_pay_mode_tv));
    this.PbG = this.mrI.findViewById(a.f.finger_print_layout);
    this.PbH = ((TextView)this.mrI.findViewById(a.f.finger_print_tips));
    this.PbI = ((ImageView)this.mrI.findViewById(a.f.finger_print_icon));
    this.Pbw = ((TextView)this.mrI.findViewById(a.f.charge_fee));
    this.Pbx = ((TextView)this.mrI.findViewById(a.f.random_offer_title));
    this.Pby = this.mrI.findViewById(a.f.favor_container);
    this.Pbz = ((TextView)this.mrI.findViewById(a.f.favors_desc));
    this.Pbn.setVisibility(8);
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    if (com.tencent.mm.wallet_core.ui.g.ijx()) {
      getWindow().addFlags(8192);
    }
    this.xPd.setEnabled(false);
    this.xPd.setTextColor(paramContext.getResources().getColorStateList(a.c.wallet_alert_btn_text_color));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.Pbq);
    this.Pbq.setOnInputValidListener(new s.1(this));
    this.Pbq.requestFocus();
    Object localObject = (TextView)this.mrI.findViewById(a.f.wallet_pwd_title_tv);
    if (localObject != null) {
      ((TextView)localObject).setText(ah.lM(paramContext));
    }
    paramContext = (EditText)this.mrI.findViewById(a.f.wallet_content);
    com.tencent.mm.wallet_core.ui.g.setNoSystemInputOnEditText(paramContext);
    this.mKeyboard.setInputEditText(paramContext);
    if (Build.VERSION.SDK_INT >= 14)
    {
      localObject = d.hJh();
      this.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
      paramContext.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
    }
    paramContext.setOnClickListener(new s.2(this));
    this.mrI.findViewById(a.f.tenpay_push_down).setOnClickListener(new s.3(this));
    gLI();
    AppMethodBeat.o(71133);
  }
  
  private static void Ck(boolean paramBoolean)
  {
    AppMethodBeat.i(71146);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Viw, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(71146);
  }
  
  public static s a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, b paramb, final DialogInterface.OnCancelListener paramOnCancelListener, a parama)
  {
    AppMethodBeat.i(71143);
    if (((Activity)paramContext).isFinishing())
    {
      AppMethodBeat.o(71143);
      return null;
    }
    s locals = new s(paramContext);
    if (locals.xPd != null)
    {
      locals.PbB = null;
      locals.xPd.setOnClickListener(new s.6(locals));
    }
    if (locals.EKk != null)
    {
      locals.fs = paramOnCancelListener;
      locals.EKk.setVisibility(0);
      locals.EKk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71132);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (paramOnCancelListener != null) {
            paramOnCancelListener.onCancel(null);
          }
          if (s.this.PbA != null) {
            s.this.PbA.fli();
          }
          s.this.cancel();
          if (s.this.PbF.isShown()) {
            com.tencent.mm.plugin.report.service.h.IzE.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71132);
            return;
            com.tencent.mm.plugin.report.service.h.IzE.a(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          }
        }
      });
    }
    locals.setOnCancelListener(paramOnCancelListener);
    locals.setCancelable(true);
    locals.IPM.setText(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      locals.Isv.setVisibility(0);
      locals.Isv.setText(paramString2);
      locals.Pbt.setVisibility(8);
      locals.PbD = false;
      locals.PbA = parama;
      if (TextUtils.isEmpty(paramString3)) {
        break label261;
      }
      locals.Pbw.setVisibility(0);
      locals.Pbw.setText(paramString3);
    }
    for (;;)
    {
      locals.Pbr = paramb;
      locals.PbK = paramBoolean;
      if (!z.bdq()) {
        locals.gLI();
      }
      locals.show();
      com.tencent.mm.ui.base.h.a(paramContext, locals);
      AppMethodBeat.o(71143);
      return locals;
      locals.Isv.setVisibility(8);
      break;
      label261:
      Log.i("MicroMsg.WalletPwdCustomDialog", "ChargeFee is null");
      locals.Pbw.setVisibility(8);
    }
  }
  
  private void gLI()
  {
    AppMethodBeat.i(71134);
    Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo updateFingerprintMode");
    this.PbL = 0;
    this.PbF.setVisibility(8);
    this.PbG.setVisibility(8);
    this.PbO = Util.currentTicks();
    com.tencent.mm.plugin.wallet_core.model.ao localao = u.gJo();
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class);
    if ((localao != null) && (locala.eon())) {}
    for (boolean bool1 = locala.eoz();; bool1 = true)
    {
      Log.i("MicroMsg.WalletPwdCustomDialog", "hy: soter key status: %b", new Object[] { Boolean.valueOf(bool1) });
      this.PbP = 0;
      this.fOx = "";
      if ((locala != null) && (locala.eos()) && (!locala.eoo())) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo isDeviceSupportFp: %b", new Object[] { Boolean.valueOf(bool1) });
        boolean bool2;
        if ((locala != null) && (locala.eon()))
        {
          bool2 = true;
          if ((!bool2) || (!bool1) || (!this.PbK) || (gLL())) {
            break label418;
          }
          this.PbF.setVisibility(0);
          this.PbF.setText(getContext().getString(a.i.wallet_pwd_pay_mode));
          this.PbJ = 1;
          this.PbG.setVisibility(0);
          this.PbI.setVisibility(0);
          this.Pbq.setVisibility(8);
          this.mKBLayout.setVisibility(8);
          this.Pbl.setText(a.i.wallet_pwd_dialog_finger_print_titile);
          this.PbP = 1;
          gLu();
          com.tencent.mm.plugin.report.service.h.IzE.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        for (;;)
        {
          Log.i("MicroMsg.WalletPwdCustomDialog", "isOpenTouch:" + bool2 + ",  isDeviceSupport:" + bool1 + ", use_pay_touch:" + this.PbK + ", isForcePwdMode:" + gLL());
          this.PbF.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(71125);
              b localb = new b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              if (s.this.PbJ == 0) {
                s.a(s.this);
              }
              for (;;)
              {
                if (s.this.PbJ == 1)
                {
                  s.gLM();
                  if (s.c(s.this)) {
                    s.d(s.this);
                  }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71125);
                return;
                if (s.this.PbJ == 1) {
                  s.b(s.this);
                }
              }
            }
          });
          AppMethodBeat.o(71134);
          return;
          bool2 = false;
          break;
          label418:
          if ((bool2) && (bool1) && (this.PbK) && (gLL()))
          {
            this.PbF.setText(getContext().getString(a.i.wallet_finger_print_pay_mode));
            this.PbF.setVisibility(0);
            this.PbJ = 0;
            this.PbG.setVisibility(8);
            this.Pbq.setVisibility(0);
            if (!this.mKBLayout.isShown()) {
              this.mKBLayout.setVisibility(0);
            }
            this.Pbl.setText(a.i.wallet_pwd_dialog_titile);
            this.PbP = 0;
            this.fOx = "";
            com.tencent.mm.plugin.report.service.h.IzE.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
            com.tencent.mm.wallet_core.ui.g.azK(8);
          }
          else
          {
            this.PbP = 0;
            this.fOx = "";
            this.PbF.setVisibility(8);
            com.tencent.mm.plugin.report.service.h.IzE.a(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          }
        }
      }
    }
  }
  
  private void gLJ()
  {
    AppMethodBeat.i(71135);
    this.PbF.setText(getContext().getString(a.i.wallet_finger_print_pay_mode));
    this.PbJ = 0;
    this.PbO = Util.currentTicks();
    this.PbG.setVisibility(8);
    this.Pbq.setVisibility(0);
    if (!this.mKBLayout.isShown()) {
      this.mKBLayout.setVisibility(0);
    }
    this.Pbl.setText(a.i.wallet_pwd_dialog_titile);
    Ck(true);
    this.PbP = 0;
    this.fOx = "";
    com.tencent.mm.plugin.report.service.h.IzE.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    com.tencent.mm.wallet_core.ui.g.azK(29);
    gLv();
    AppMethodBeat.o(71135);
  }
  
  private static boolean gLL()
  {
    AppMethodBeat.i(71147);
    com.tencent.mm.kernel.h.aHH();
    Object localObject = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Viw, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(71147);
      return bool;
    }
  }
  
  private void gLu()
  {
    AppMethodBeat.i(71136);
    Log.i("MicroMsg.WalletPwdCustomDialog", "reqFingerPrintAuth %s", new Object[] { Util.getStack().toString() });
    com.tencent.mm.plugin.soter.d.a.gag();
    final pt localpt = new pt();
    localpt.fOs.fHb = this.fwv;
    localpt.fOs.fOu = 1;
    localpt.fOs.fOw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71130);
        Log.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback");
        Object localObject = localpt.fOt;
        if (localObject == null)
        {
          s.a(s.this, 0);
          Log.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, result == null");
          AppMethodBeat.o(71130);
          return;
        }
        int i = ((pt.b)localObject).errCode;
        Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), ((pt.b)localObject).errMsg });
        if (i == 0)
        {
          Log.i("MicroMsg.WalletPwdCustomDialog", "hy: payInfo soterAuthReq: %s", new Object[] { ((pt.b)localObject).fOx });
          s.a(s.this, 1);
          s.a(s.this, ((pt.b)localObject).fOx);
          try
          {
            localObject = new JSONObject(s.e(s.this));
            ((JSONObject)localObject).put("soter_type", "1");
            s.a(s.this, ((JSONObject)localObject).toString());
            s.f(s.this);
            s.this.PbH.setText("");
            s.this.gLK();
            com.tencent.mm.plugin.report.service.h.IzE.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
            com.tencent.mm.plugin.soter.d.a.ahO(0);
            AppMethodBeat.o(71130);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.WalletPwdCustomDialog", localException, "", new Object[0]);
            }
          }
        }
        Log.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
        s.a(s.this, 0);
        s.a(s.this, "");
        s.this.PbG.setVisibility(0);
        s.this.PbH.setTextColor(s.this.getContext().getResources().getColor(a.c.red));
        s.this.PbH.setText(a.i.wallet_finger_print_fail);
        int j = (int)(System.currentTimeMillis() / 1000L);
        int k = j - s.g(s.this);
        if (k > 1)
        {
          s.b(s.this, j);
          s.h(s.this);
          s.f(s.this);
        }
        com.tencent.mm.plugin.report.service.h.IzE.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
        boolean bool1;
        if ((i == 2) || (i == 10308))
        {
          bool1 = true;
          if (localException.fOy != 2) {
            break label675;
          }
        }
        label675:
        for (boolean bool2 = true;; bool2 = false)
        {
          Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(s.i(s.this)), Integer.valueOf(i), Boolean.valueOf(bool2) });
          if (((!bool2) && ((s.i(s.this) >= 3) || (k <= 1))) || (bool1)) {
            break label681;
          }
          Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo fingerprint pay");
          if (s.j(s.this) == null) {
            s.a(s.this, com.tencent.mm.ui.c.a.jdMethod_if(s.this.getContext()));
          }
          s.this.PbI.setVisibility(8);
          s.this.PbH.setVisibility(4);
          s.j(s.this).reset();
          s.j(s.this).setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(71129);
              Log.i("MicroMsg.WalletPwdCustomDialog", "hy: on flash end");
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(71127);
                  s.this.PbH.setVisibility(8);
                  s.this.PbI.setVisibility(0);
                  AppMethodBeat.o(71127);
                }
              });
              AppMethodBeat.o(71129);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(71128);
              Log.i("MicroMsg.WalletPwdCustomDialog", "hy: on flash start");
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(71126);
                  s.this.PbH.setVisibility(0);
                  AppMethodBeat.o(71126);
                }
              });
              AppMethodBeat.o(71128);
            }
          });
          s.this.PbH.startAnimation(s.j(s.this));
          com.tencent.mm.plugin.soter.d.a.ahO(1);
          AppMethodBeat.o(71130);
          return;
          bool1 = false;
          break;
        }
        label681:
        if ((s.i(s.this) >= 3) || (bool1))
        {
          Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo change to pwd pay");
          s.gLM();
          s.this.PbJ = 0;
          s.k(s.this);
          s.this.PbF.setVisibility(8);
          s.this.PbG.setVisibility(8);
          s.this.PbH.setVisibility(0);
          s.this.PbH.setText(a.i.wallet_finger_print_not_recorded);
          s.this.PbH.setTextColor(s.this.getContext().getResources().getColor(a.c.wallet_pwd_bank_card_text_color));
          s.this.Pbl.setText(a.i.wallet_pwd_dialog_titile);
          s.this.Pbq.setVisibility(0);
          if (!s.this.mKBLayout.isShown()) {
            s.this.mKBLayout.setVisibility(0);
          }
          com.tencent.mm.plugin.soter.d.a.ahO(2);
          s.gLN();
        }
        AppMethodBeat.o(71130);
      }
    };
    EventCenter.instance.asyncPublish(localpt, Looper.getMainLooper());
    AppMethodBeat.o(71136);
  }
  
  private static void gLv()
  {
    AppMethodBeat.i(71137);
    Log.i("MicroMsg.WalletPwdCustomDialog", "hy: send release FPManager");
    sl localsl = new sl();
    EventCenter.instance.publish(localsl);
    AppMethodBeat.o(71137);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(71141);
    try
    {
      super.dismiss();
      gLv();
      this.OuA.destory();
      if (this.Bzl != null) {
        this.Bzl.cancel();
      }
      AppMethodBeat.o(71141);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.WalletPwdCustomDialog", "dismiss exception, e = " + localException.getMessage());
      }
    }
  }
  
  protected final void gLK()
  {
    AppMethodBeat.i(71142);
    Ck(false);
    if (this.PbB != null) {
      this.PbB.onClick(this, 0);
    }
    dismiss();
    b localb;
    String str;
    if (this.Pbr != null)
    {
      Log.i("MicroMsg.WalletPwdCustomDialog", "doOk use_touch: %s soterAuthReq: %s ", new Object[] { Integer.valueOf(this.PbP), this.fOx });
      localb = this.Pbr;
      str = this.Pbq.getText();
      if (this.PbP != 1) {
        break label127;
      }
    }
    label127:
    for (boolean bool = true;; bool = false)
    {
      localb.g(str, bool, this.fOx);
      if (this.PbO >= 0L) {
        break;
      }
      Log.e("MicroMsg.WalletPwdCustomDialog", "hy: not set update mode time yet. abandon");
      AppMethodBeat.o(71142);
      return;
    }
    if (this.PbJ == 0)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(686L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(686L, 1L, Util.ticksToNow(this.PbO), false);
      AppMethodBeat.o(71142);
      return;
    }
    if (this.PbJ == 1)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(686L, 2L, 1L, false);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(686L, 3L, Util.ticksToNow(this.PbO), false);
    }
    AppMethodBeat.o(71142);
  }
  
  public final void onActivityPause()
  {
    AppMethodBeat.i(71145);
    this.isPaused = true;
    if (z.bdq())
    {
      AppMethodBeat.o(71145);
      return;
    }
    if (this.PbJ == 1) {
      gLJ();
    }
    AppMethodBeat.o(71145);
  }
  
  public final void onActivityResume()
  {
    AppMethodBeat.i(71144);
    this.isPaused = false;
    if (z.bdq())
    {
      AppMethodBeat.o(71144);
      return;
    }
    AppMethodBeat.o(71144);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71139);
    super.onCreate(paramBundle);
    setContentView(this.mrI);
    com.tencent.soter.a.g.f.ipn().ipo();
    AppMethodBeat.o(71139);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(71138);
    if (paramInt == 4)
    {
      if (this.fs != null) {
        this.fs.onCancel(this);
      }
      if (this.PbA != null) {
        this.PbA.fli();
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
    this.bxO = paramBoolean;
    setCanceledOnTouchOutside(this.bxO);
    AppMethodBeat.o(71140);
  }
  
  public static abstract interface a
  {
    public abstract void fli();
  }
  
  public static abstract interface b
  {
    public abstract void g(String paramString1, boolean paramBoolean, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.s
 * JD-Core Version:    0.7.0.1
 */