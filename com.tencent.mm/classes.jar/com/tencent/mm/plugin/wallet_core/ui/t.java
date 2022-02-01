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
import com.tencent.mm.autogen.a.rg;
import com.tencent.mm.autogen.a.rg.b;
import com.tencent.mm.autogen.a.ua;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.model.ai;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import org.json.JSONObject;

public final class t
  extends com.tencent.mm.ui.widget.a.i
  implements h
{
  public Button BoW;
  private int HgB;
  private Animation HgQ;
  public ImageView KDS;
  public TextView OYJ;
  public TextView Oqd;
  public TextView VRR;
  public TextView VRS;
  public FavourLayout VRT;
  public CdnImageView VRU;
  public TextView VRV;
  public EditHintPasswdView VRW;
  public b VRX;
  public View VRY;
  public View VRZ;
  public TextView VSa;
  public ImageView VSb;
  public TextView VSc;
  public TextView VSd;
  public View VSe;
  public TextView VSf;
  protected a VSg;
  protected DialogInterface.OnClickListener VSh;
  protected boolean VSi;
  protected boolean VSj;
  protected Bankcard VSk;
  public TextView VSl;
  public View VSm;
  public TextView VSn;
  public ImageView VSo;
  protected int VSp;
  protected boolean VSq;
  private int VSr;
  private Animation VSs;
  private String VSt;
  private long VSu;
  private int VSv;
  private int VSw;
  private boolean VSx;
  protected com.tencent.mm.plugin.wallet_core.utils.b VjO;
  public TextView Voi;
  public ImageView avatar;
  protected boolean dqR;
  private String hAT;
  private String hUq;
  private boolean isPaused;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  protected DialogInterface.OnCancelListener mOnCancelListener;
  public View plc;
  
  private t(Context paramContext)
  {
    super(paramContext, a.j.mmpwddialog);
    AppMethodBeat.i(71133);
    this.VSi = false;
    this.VSj = true;
    this.VSk = null;
    this.VjO = new com.tencent.mm.plugin.wallet_core.utils.b();
    this.VSp = 0;
    this.VSq = false;
    this.VSr = 0;
    this.HgB = 0;
    this.VSs = null;
    this.VSt = "";
    this.VSu = -1L;
    this.VSv = 0;
    this.hUq = "";
    this.VSw = 0;
    this.VSx = false;
    this.isPaused = false;
    Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo WalletPwdDialog initView");
    this.plc = View.inflate(paramContext, a.g.wallet_full_pwd_dialog, null);
    this.BoW = ((Button)this.plc.findViewById(a.f.mm_alert_ok_btn));
    this.KDS = ((ImageView)this.plc.findViewById(a.f.wallet_pwd_close_iv));
    this.mKeyboard = ((MyKeyboardWindow)this.plc.findViewById(a.f.tenpay_num_keyboard));
    this.mKBLayout = this.plc.findViewById(a.f.tenpay_keyboard_layout);
    this.OYJ = ((TextView)this.plc.findViewById(a.f.content));
    this.VRR = ((TextView)this.plc.findViewById(a.f.wallet_pwd_title_tv));
    this.Oqd = ((TextView)this.plc.findViewById(a.f.fee));
    this.Voi = ((TextView)this.plc.findViewById(a.f.origin_fee));
    this.Voi.getPaint().setFlags(16);
    this.VRS = ((TextView)this.plc.findViewById(a.f.bankcard_tv));
    this.VRT = ((FavourLayout)this.plc.findViewById(a.f.favour_tip));
    this.VRU = ((CdnImageView)this.plc.findViewById(a.f.bankcard_logo));
    this.VRY = this.plc.findViewById(a.f.favor_ll);
    this.VRV = ((TextView)this.plc.findViewById(a.f.more_favors));
    this.avatar = ((ImageView)this.plc.findViewById(a.f.chatting_user_iv));
    this.VRZ = this.plc.findViewById(a.f.bankcard_layout);
    this.VSa = ((TextView)this.plc.findViewById(a.f.seperator));
    a.b.g(this.avatar, com.tencent.mm.wallet_core.ui.i.getUsername());
    this.VRW = ((EditHintPasswdView)this.plc.findViewById(a.f.input_et));
    this.VSb = ((ImageView)this.plc.findViewById(a.f.has_larger_favor_reddot));
    this.VSl = ((TextView)this.plc.findViewById(a.f.wallet_pay_mode_tv));
    this.VSm = this.plc.findViewById(a.f.finger_print_layout);
    this.VSn = ((TextView)this.plc.findViewById(a.f.finger_print_tips));
    this.VSo = ((ImageView)this.plc.findViewById(a.f.finger_print_icon));
    this.VSc = ((TextView)this.plc.findViewById(a.f.charge_fee));
    this.VSd = ((TextView)this.plc.findViewById(a.f.random_offer_title));
    this.VSe = this.plc.findViewById(a.f.favor_container);
    this.VSf = ((TextView)this.plc.findViewById(a.f.favors_desc));
    this.VRT.setVisibility(8);
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    if (com.tencent.mm.wallet_core.ui.i.jPv()) {
      getWindow().addFlags(8192);
    }
    this.BoW.setEnabled(false);
    this.BoW.setTextColor(paramContext.getResources().getColorStateList(a.c.wallet_alert_btn_text_color));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.VRW);
    this.VRW.setOnInputValidListener(new t.1(this));
    this.VRW.requestFocus();
    Object localObject = (TextView)this.plc.findViewById(a.f.wallet_pwd_title_tv);
    if (localObject != null) {
      ((TextView)localObject).setText(ai.nR(paramContext));
    }
    paramContext = (EditText)this.plc.findViewById(a.f.wallet_content);
    com.tencent.mm.wallet_core.ui.i.setNoSystemInputOnEditText(paramContext);
    this.mKeyboard.setInputEditText(paramContext);
    if (Build.VERSION.SDK_INT >= 14)
    {
      localObject = new c();
      this.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
      paramContext.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
    }
    paramContext.setOnClickListener(new t.2(this));
    this.plc.findViewById(a.f.tenpay_push_down).setOnClickListener(new t.3(this));
    ikZ();
    AppMethodBeat.o(71133);
  }
  
  private static void HP(boolean paramBoolean)
  {
    AppMethodBeat.i(71146);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acJQ, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(71146);
  }
  
  public static t a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, b paramb, final DialogInterface.OnCancelListener paramOnCancelListener, a parama)
  {
    AppMethodBeat.i(71143);
    if (((Activity)paramContext).isFinishing())
    {
      AppMethodBeat.o(71143);
      return null;
    }
    t localt = new t(paramContext);
    if (localt.BoW != null)
    {
      localt.VSh = null;
      localt.BoW.setOnClickListener(new t.6(localt));
    }
    if (localt.KDS != null)
    {
      localt.mOnCancelListener = paramOnCancelListener;
      localt.KDS.setVisibility(0);
      localt.KDS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71132);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (paramOnCancelListener != null) {
            paramOnCancelListener.onCancel(null);
          }
          if (t.this.VSg != null) {
            t.this.VSg.gvz();
          }
          t.this.cancel();
          if (t.this.VSl.isShown()) {
            com.tencent.mm.plugin.report.service.h.OAn.b(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71132);
            return;
            com.tencent.mm.plugin.report.service.h.OAn.b(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          }
        }
      });
    }
    localt.setOnCancelListener(paramOnCancelListener);
    localt.setCancelable(true);
    localt.OYJ.setText(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      localt.Oqd.setVisibility(0);
      localt.Oqd.setText(paramString2);
      localt.VRZ.setVisibility(8);
      localt.VSj = false;
      localt.VSg = parama;
      if (TextUtils.isEmpty(paramString3)) {
        break label261;
      }
      localt.VSc.setVisibility(0);
      localt.VSc.setText(paramString3);
    }
    for (;;)
    {
      localt.VRX = paramb;
      localt.VSq = paramBoolean;
      if (!z.bBi()) {
        localt.ikZ();
      }
      localt.show();
      k.a(paramContext, localt);
      AppMethodBeat.o(71143);
      return localt;
      localt.Oqd.setVisibility(8);
      break;
      label261:
      Log.i("MicroMsg.WalletPwdCustomDialog", "ChargeFee is null");
      localt.VSc.setVisibility(8);
    }
  }
  
  private void ikL()
  {
    AppMethodBeat.i(71136);
    Log.i("MicroMsg.WalletPwdCustomDialog", "reqFingerPrintAuth %s", new Object[] { Util.getStack().toString() });
    com.tencent.mm.plugin.soter.model.a.htx();
    final rg localrg = new rg();
    localrg.hUl.hMy = this.hAT;
    localrg.hUl.hUn = 1;
    localrg.hUl.hUp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71130);
        Log.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback");
        Object localObject = localrg.hUm;
        if (localObject == null)
        {
          t.a(t.this, 0);
          Log.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, result == null");
          AppMethodBeat.o(71130);
          return;
        }
        int i = ((rg.b)localObject).errCode;
        Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), ((rg.b)localObject).errMsg });
        if (i == 0)
        {
          Log.i("MicroMsg.WalletPwdCustomDialog", "hy: payInfo soterAuthReq: %s", new Object[] { ((rg.b)localObject).hUq });
          t.a(t.this, 1);
          t.a(t.this, ((rg.b)localObject).hUq);
          try
          {
            localObject = new JSONObject(t.e(t.this));
            ((JSONObject)localObject).put("soter_type", "1");
            t.a(t.this, ((JSONObject)localObject).toString());
            t.f(t.this);
            t.this.VSn.setText("");
            t.this.ilb();
            com.tencent.mm.plugin.report.service.h.OAn.b(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
            com.tencent.mm.plugin.soter.model.a.amP(0);
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
        t.a(t.this, 0);
        t.a(t.this, "");
        t.this.VSm.setVisibility(0);
        t.this.VSn.setTextColor(t.this.getContext().getResources().getColor(a.c.red));
        t.this.VSn.setText(a.i.wallet_finger_print_fail);
        int j = (int)(System.currentTimeMillis() / 1000L);
        int k = j - t.g(t.this);
        if (k > 1)
        {
          t.b(t.this, j);
          t.h(t.this);
          t.f(t.this);
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
        boolean bool1;
        if ((i == 2) || (i == 10308))
        {
          bool1 = true;
          if (localException.hUr != 2) {
            break label675;
          }
        }
        label675:
        for (boolean bool2 = true;; bool2 = false)
        {
          Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(t.i(t.this)), Integer.valueOf(i), Boolean.valueOf(bool2) });
          if (((!bool2) && ((t.i(t.this) >= 3) || (k <= 1))) || (bool1)) {
            break label681;
          }
          Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo fingerprint pay");
          if (t.j(t.this) == null) {
            t.a(t.this, com.tencent.mm.ui.anim.a.jV(t.this.getContext()));
          }
          t.this.VSo.setVisibility(8);
          t.this.VSn.setVisibility(4);
          t.j(t.this).reset();
          t.j(t.this).setAnimationListener(new Animation.AnimationListener()
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
                  t.this.VSn.setVisibility(8);
                  t.this.VSo.setVisibility(0);
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
                  t.this.VSn.setVisibility(0);
                  AppMethodBeat.o(71126);
                }
              });
              AppMethodBeat.o(71128);
            }
          });
          t.this.VSn.startAnimation(t.j(t.this));
          com.tencent.mm.plugin.soter.model.a.amP(1);
          AppMethodBeat.o(71130);
          return;
          bool1 = false;
          break;
        }
        label681:
        if ((t.i(t.this) >= 3) || (bool1))
        {
          Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo change to pwd pay");
          t.ild();
          t.this.VSp = 0;
          t.k(t.this);
          t.this.VSl.setVisibility(8);
          t.this.VSm.setVisibility(8);
          t.this.VSn.setVisibility(0);
          t.this.VSn.setText(a.i.wallet_finger_print_not_recorded);
          t.this.VSn.setTextColor(t.this.getContext().getResources().getColor(a.c.wallet_pwd_bank_card_text_color));
          t.this.VRR.setText(a.i.wallet_pwd_dialog_titile);
          t.this.VRW.setVisibility(0);
          if (!t.this.mKBLayout.isShown()) {
            t.this.mKBLayout.setVisibility(0);
          }
          com.tencent.mm.plugin.soter.model.a.amP(2);
          t.ile();
        }
        AppMethodBeat.o(71130);
      }
    };
    localrg.asyncPublish(Looper.getMainLooper());
    AppMethodBeat.o(71136);
  }
  
  private static void ikM()
  {
    AppMethodBeat.i(71137);
    Log.i("MicroMsg.WalletPwdCustomDialog", "hy: send release FPManager");
    new ua().publish();
    AppMethodBeat.o(71137);
  }
  
  private void ikZ()
  {
    AppMethodBeat.i(71134);
    Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo updateFingerprintMode");
    this.VSr = 0;
    this.VSl.setVisibility(8);
    this.VSm.setVisibility(8);
    this.VSu = Util.currentTicks();
    am localam = u.iiC();
    com.tencent.mm.plugin.fingerprint.c.a locala = (com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class);
    if ((localam != null) && (locala.ftq())) {}
    for (boolean bool1 = locala.ftC();; bool1 = true)
    {
      Log.i("MicroMsg.WalletPwdCustomDialog", "hy: soter key status: %b", new Object[] { Boolean.valueOf(bool1) });
      this.VSv = 0;
      this.hUq = "";
      if ((locala != null) && (locala.ftv()) && (!locala.ftr())) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo isDeviceSupportFp: %b", new Object[] { Boolean.valueOf(bool1) });
        boolean bool2;
        if ((locala != null) && (locala.ftq()))
        {
          bool2 = true;
          if ((!bool2) || (!bool1) || (!this.VSq) || (ilc())) {
            break label418;
          }
          this.VSl.setVisibility(0);
          this.VSl.setText(getContext().getString(a.i.wallet_pwd_pay_mode));
          this.VSp = 1;
          this.VSm.setVisibility(0);
          this.VSo.setVisibility(0);
          this.VRW.setVisibility(8);
          this.mKBLayout.setVisibility(8);
          this.VRR.setText(a.i.wallet_pwd_dialog_finger_print_titile);
          this.VSv = 1;
          ikL();
          com.tencent.mm.plugin.report.service.h.OAn.b(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        for (;;)
        {
          Log.i("MicroMsg.WalletPwdCustomDialog", "isOpenTouch:" + bool2 + ",  isDeviceSupport:" + bool1 + ", use_pay_touch:" + this.VSq + ", isForcePwdMode:" + ilc());
          this.VSl.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(71125);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              if (t.this.VSp == 0) {
                t.a(t.this);
              }
              for (;;)
              {
                if (t.this.VSp == 1)
                {
                  t.ild();
                  if (t.c(t.this)) {
                    t.d(t.this);
                  }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71125);
                return;
                if (t.this.VSp == 1) {
                  t.b(t.this);
                }
              }
            }
          });
          AppMethodBeat.o(71134);
          return;
          bool2 = false;
          break;
          label418:
          if ((bool2) && (bool1) && (this.VSq) && (ilc()))
          {
            this.VSl.setText(getContext().getString(a.i.wallet_finger_print_pay_mode));
            this.VSl.setVisibility(0);
            this.VSp = 0;
            this.VSm.setVisibility(8);
            this.VRW.setVisibility(0);
            if (!this.mKBLayout.isShown()) {
              this.mKBLayout.setVisibility(0);
            }
            this.VRR.setText(a.i.wallet_pwd_dialog_titile);
            this.VSv = 0;
            this.hUq = "";
            com.tencent.mm.plugin.report.service.h.OAn.b(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
            com.tencent.mm.wallet_core.ui.i.aGA(8);
          }
          else
          {
            this.VSv = 0;
            this.hUq = "";
            this.VSl.setVisibility(8);
            com.tencent.mm.plugin.report.service.h.OAn.b(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          }
        }
      }
    }
  }
  
  private void ila()
  {
    AppMethodBeat.i(71135);
    this.VSl.setText(getContext().getString(a.i.wallet_finger_print_pay_mode));
    this.VSp = 0;
    this.VSu = Util.currentTicks();
    this.VSm.setVisibility(8);
    this.VRW.setVisibility(0);
    if (!this.mKBLayout.isShown()) {
      this.mKBLayout.setVisibility(0);
    }
    this.VRR.setText(a.i.wallet_pwd_dialog_titile);
    HP(true);
    this.VSv = 0;
    this.hUq = "";
    com.tencent.mm.plugin.report.service.h.OAn.b(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    com.tencent.mm.wallet_core.ui.i.aGA(29);
    ikM();
    AppMethodBeat.o(71135);
  }
  
  private static boolean ilc()
  {
    AppMethodBeat.i(71147);
    com.tencent.mm.kernel.h.baF();
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acJQ, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(71147);
      return bool;
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(71141);
    try
    {
      super.dismiss();
      ikM();
      this.VjO.destory();
      if (this.HgQ != null) {
        this.HgQ.cancel();
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
  
  protected final void ilb()
  {
    AppMethodBeat.i(71142);
    HP(false);
    if (this.VSh != null) {
      this.VSh.onClick(this, 0);
    }
    dismiss();
    b localb;
    String str;
    if (this.VRX != null)
    {
      Log.i("MicroMsg.WalletPwdCustomDialog", "doOk use_touch: %s soterAuthReq: %s ", new Object[] { Integer.valueOf(this.VSv), this.hUq });
      localb = this.VRX;
      str = this.VRW.getText();
      if (this.VSv != 1) {
        break label127;
      }
    }
    label127:
    for (boolean bool = true;; bool = false)
    {
      localb.k(str, bool, this.hUq);
      if (this.VSu >= 0L) {
        break;
      }
      Log.e("MicroMsg.WalletPwdCustomDialog", "hy: not set update mode time yet. abandon");
      AppMethodBeat.o(71142);
      return;
    }
    if (this.VSp == 0)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(686L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(686L, 1L, Util.ticksToNow(this.VSu), false);
      AppMethodBeat.o(71142);
      return;
    }
    if (this.VSp == 1)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(686L, 2L, 1L, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(686L, 3L, Util.ticksToNow(this.VSu), false);
    }
    AppMethodBeat.o(71142);
  }
  
  public final void onActivityPause()
  {
    AppMethodBeat.i(71145);
    this.isPaused = true;
    if (z.bBi())
    {
      AppMethodBeat.o(71145);
      return;
    }
    if (this.VSp == 1) {
      ila();
    }
    AppMethodBeat.o(71145);
  }
  
  public final void onActivityResume()
  {
    AppMethodBeat.i(71144);
    this.isPaused = false;
    if (z.bBi())
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
    setContentView(this.plc);
    com.tencent.soter.a.g.f.jYD().jYE();
    AppMethodBeat.o(71139);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(71138);
    if (paramInt == 4)
    {
      if (this.mOnCancelListener != null) {
        this.mOnCancelListener.onCancel(this);
      }
      if (this.VSg != null) {
        this.VSg.gvz();
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
    this.dqR = paramBoolean;
    setCanceledOnTouchOutside(this.dqR);
    AppMethodBeat.o(71140);
  }
  
  public static abstract interface a
  {
    public abstract void gvz();
  }
  
  public static abstract interface b
  {
    public abstract void k(String paramString1, boolean paramBoolean, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.t
 * JD-Core Version:    0.7.0.1
 */