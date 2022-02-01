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
import com.tencent.mm.g.a.ow;
import com.tencent.mm.g.a.ow.b;
import com.tencent.mm.g.a.rm;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.a.d;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import org.json.JSONObject;

public final class r
  extends i
  implements f
{
  public TextView CKk;
  public TextView CuI;
  protected com.tencent.mm.plugin.wallet_core.utils.a HCH;
  public TextView HHd;
  public Button HRF;
  public ImageView Igh;
  public TextView IiV;
  public TextView IiW;
  public FavourLayout IiX;
  public CdnImageView IiY;
  public TextView IiZ;
  private boolean IjA;
  public EditHintPasswdView Ija;
  public b Ijb;
  public View Ijc;
  public View Ijd;
  public TextView Ije;
  public ImageView Ijf;
  public TextView Ijg;
  public TextView Ijh;
  public View Iji;
  public TextView Ijj;
  protected a Ijk;
  protected DialogInterface.OnClickListener Ijl;
  protected boolean Ijm;
  protected boolean Ijn;
  protected Bankcard Ijo;
  public TextView Ijp;
  public View Ijq;
  public TextView Ijr;
  protected int Ijs;
  protected boolean Ijt;
  private int Iju;
  private Animation Ijv;
  private String Ijw;
  private long Ijx;
  private int Ijy;
  private int Ijz;
  protected DialogInterface.OnCancelListener XY;
  private String dDL;
  private String dUV;
  private boolean isPaused;
  public View jBN;
  public ImageView keC;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  protected boolean ox;
  private int wFZ;
  private Animation wGp;
  public ImageView zfh;
  
  private r(Context paramContext)
  {
    super(paramContext, 2131821776);
    AppMethodBeat.i(71133);
    this.Ijm = false;
    this.Ijn = true;
    this.Ijo = null;
    this.HCH = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.Ijs = 0;
    this.Ijt = false;
    this.Iju = 0;
    this.wFZ = 0;
    this.Ijv = null;
    this.Ijw = "";
    this.Ijx = -1L;
    this.Ijy = 0;
    this.dUV = "";
    this.Ijz = 0;
    this.IjA = false;
    this.isPaused = false;
    Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo WalletPwdDialog initView");
    this.jBN = View.inflate(paramContext, 2131496943, null);
    this.HRF = ((Button)this.jBN.findViewById(2131304709));
    this.zfh = ((ImageView)this.jBN.findViewById(2131310280));
    this.mKeyboard = ((MyKeyboardWindow)this.jBN.findViewById(2131308962));
    this.mKBLayout = this.jBN.findViewById(2131308960);
    this.CKk = ((TextView)this.jBN.findViewById(2131299180));
    this.IiV = ((TextView)this.jBN.findViewById(2131310287));
    this.CuI = ((TextView)this.jBN.findViewById(2131300552));
    this.HHd = ((TextView)this.jBN.findViewById(2131305695));
    this.HHd.getPaint().setFlags(16);
    this.IiW = ((TextView)this.jBN.findViewById(2131297320));
    this.IiX = ((FavourLayout)this.jBN.findViewById(2131300549));
    this.IiY = ((CdnImageView)this.jBN.findViewById(2131297309));
    this.Ijc = this.jBN.findViewById(2131300541);
    this.IiZ = ((TextView)this.jBN.findViewById(2131304877));
    this.keC = ((ImageView)this.jBN.findViewById(2131298564));
    this.Ijd = this.jBN.findViewById(2131297307);
    this.Ije = ((TextView)this.jBN.findViewById(2131307642));
    a.b.c(this.keC, com.tencent.mm.wallet_core.ui.f.getUsername());
    this.Ija = ((EditHintPasswdView)this.jBN.findViewById(2131302674));
    this.Ijf = ((ImageView)this.jBN.findViewById(2131302250));
    this.Ijp = ((TextView)this.jBN.findViewById(2131310275));
    this.Ijq = this.jBN.findViewById(2131301523);
    this.Ijr = ((TextView)this.jBN.findViewById(2131301526));
    this.Igh = ((ImageView)this.jBN.findViewById(2131301522));
    this.Ijg = ((TextView)this.jBN.findViewById(2131298288));
    this.Ijh = ((TextView)this.jBN.findViewById(2131306497));
    this.Iji = this.jBN.findViewById(2131300539);
    this.Ijj = ((TextView)this.jBN.findViewById(2131300548));
    this.IiX.setVisibility(8);
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    this.HRF.setEnabled(false);
    this.HRF.setTextColor(paramContext.getResources().getColorStateList(2131101341));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.Ija);
    this.Ija.setOnInputValidListener(new r.1(this));
    this.Ija.requestFocus();
    Object localObject = (TextView)this.jBN.findViewById(2131310287);
    if (localObject != null) {
      ((TextView)localObject).setText(ah.kQ(paramContext));
    }
    paramContext = (EditText)this.jBN.findViewById(2131310180);
    com.tencent.mm.wallet_core.ui.f.setNoSystemInputOnEditText(paramContext);
    this.mKeyboard.setInputEditText(paramContext);
    if (Build.VERSION.SDK_INT >= 14)
    {
      localObject = new d();
      this.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
      paramContext.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
    }
    paramContext.setOnClickListener(new r.2(this));
    this.jBN.findViewById(2131308963).setOnClickListener(new r.3(this));
    fTc();
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
    if (localr.HRF != null)
    {
      localr.Ijl = null;
      localr.HRF.setOnClickListener(new r.6(localr));
    }
    if (localr.zfh != null)
    {
      localr.XY = paramOnCancelListener;
      localr.zfh.setVisibility(0);
      localr.zfh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71132);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (paramOnCancelListener != null) {
            paramOnCancelListener.onCancel(null);
          }
          if (r.this.Ijk != null) {
            r.this.Ijk.ezC();
          }
          r.this.cancel();
          if (r.this.Ijp.isShown()) {
            com.tencent.mm.plugin.report.service.h.CyF.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71132);
            return;
            com.tencent.mm.plugin.report.service.h.CyF.a(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          }
        }
      });
    }
    localr.setOnCancelListener(paramOnCancelListener);
    localr.setCancelable(true);
    localr.CKk.setText(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      localr.CuI.setVisibility(0);
      localr.CuI.setText(paramString2);
      localr.Ijd.setVisibility(8);
      localr.Ijn = false;
      localr.Ijk = parama;
      if (TextUtils.isEmpty(paramString3)) {
        break label261;
      }
      localr.Ijg.setVisibility(0);
      localr.Ijg.setText(paramString3);
    }
    for (;;)
    {
      localr.Ijb = paramb;
      localr.Ijt = paramBoolean;
      if (!z.aUo()) {
        localr.fTc();
      }
      localr.show();
      com.tencent.mm.ui.base.h.a(paramContext, localr);
      AppMethodBeat.o(71143);
      return localr;
      localr.CuI.setVisibility(8);
      break;
      label261:
      Log.i("MicroMsg.WalletPwdCustomDialog", "ChargeFee is null");
      localr.Ijg.setVisibility(8);
    }
  }
  
  private void fSO()
  {
    AppMethodBeat.i(71136);
    Log.i("MicroMsg.WalletPwdCustomDialog", "reqFingerPrintAuth %s", new Object[] { Util.getStack().toString() });
    com.tencent.mm.plugin.soter.d.a.flK();
    final ow localow = new ow();
    localow.dUQ.dNQ = this.dDL;
    localow.dUQ.dUS = 1;
    localow.dUQ.dUU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71130);
        Log.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback");
        Object localObject = localow.dUR;
        if (localObject == null)
        {
          r.a(r.this, 0);
          Log.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, result == null");
          AppMethodBeat.o(71130);
          return;
        }
        int i = ((ow.b)localObject).errCode;
        Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), ((ow.b)localObject).errMsg });
        if (i == 0)
        {
          Log.i("MicroMsg.WalletPwdCustomDialog", "hy: payInfo soterAuthReq: %s", new Object[] { ((ow.b)localObject).dUV });
          r.a(r.this, 1);
          r.a(r.this, ((ow.b)localObject).dUV);
          try
          {
            localObject = new JSONObject(r.e(r.this));
            ((JSONObject)localObject).put("soter_type", "1");
            r.a(r.this, ((JSONObject)localObject).toString());
            r.f(r.this);
            r.this.Ijr.setText("");
            r.this.fTe();
            com.tencent.mm.plugin.report.service.h.CyF.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
            com.tencent.mm.plugin.soter.d.a.aau(0);
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
        r.a(r.this, 0);
        r.a(r.this, "");
        r.this.Ijq.setVisibility(0);
        r.this.Ijr.setTextColor(r.this.getContext().getResources().getColor(2131100994));
        r.this.Ijr.setText(2131767705);
        int j = (int)(System.currentTimeMillis() / 1000L);
        int k = j - r.g(r.this);
        if (k > 1)
        {
          r.b(r.this, j);
          r.h(r.this);
          r.f(r.this);
        }
        com.tencent.mm.plugin.report.service.h.CyF.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
        boolean bool1;
        if ((i == 2) || (i == 10308))
        {
          bool1 = true;
          if (localException.dUW != 2) {
            break label673;
          }
        }
        label673:
        for (boolean bool2 = true;; bool2 = false)
        {
          Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(r.i(r.this)), Integer.valueOf(i), Boolean.valueOf(bool2) });
          if (((!bool2) && ((r.i(r.this) >= 3) || (k <= 1))) || (bool1)) {
            break label679;
          }
          Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo fingerprint pay");
          if (r.j(r.this) == null) {
            r.a(r.this, com.tencent.mm.ui.c.a.he(r.this.getContext()));
          }
          r.this.Igh.setVisibility(8);
          r.this.Ijr.setVisibility(4);
          r.j(r.this).reset();
          r.j(r.this).setAnimationListener(new Animation.AnimationListener()
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
                  r.this.Ijr.setVisibility(8);
                  r.this.Igh.setVisibility(0);
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
                  r.this.Ijr.setVisibility(0);
                  AppMethodBeat.o(71126);
                }
              });
              AppMethodBeat.o(71128);
            }
          });
          r.this.Ijr.startAnimation(r.j(r.this));
          com.tencent.mm.plugin.soter.d.a.aau(1);
          AppMethodBeat.o(71130);
          return;
          bool1 = false;
          break;
        }
        label679:
        if ((r.i(r.this) >= 3) || (bool1))
        {
          Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo change to pwd pay");
          r.fTg();
          r.this.Ijs = 0;
          r.k(r.this);
          r.this.Ijp.setVisibility(8);
          r.this.Ijq.setVisibility(8);
          r.this.Ijr.setVisibility(0);
          r.this.Ijr.setText(2131767706);
          r.this.Ijr.setTextColor(r.this.getContext().getResources().getColor(2131101376));
          r.this.IiV.setText(2131768200);
          r.this.Ija.setVisibility(0);
          if (!r.this.mKBLayout.isShown()) {
            r.this.mKBLayout.setVisibility(0);
          }
          com.tencent.mm.plugin.soter.d.a.aau(2);
          r.fTh();
        }
        AppMethodBeat.o(71130);
      }
    };
    EventCenter.instance.asyncPublish(localow, Looper.getMainLooper());
    AppMethodBeat.o(71136);
  }
  
  private static void fSP()
  {
    AppMethodBeat.i(71137);
    Log.i("MicroMsg.WalletPwdCustomDialog", "hy: send release FPManager");
    rm localrm = new rm();
    EventCenter.instance.publish(localrm);
    AppMethodBeat.o(71137);
  }
  
  private void fTc()
  {
    AppMethodBeat.i(71134);
    Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo updateFingerprintMode");
    this.Iju = 0;
    this.Ijp.setVisibility(8);
    this.Ijq.setVisibility(8);
    this.Ijx = Util.currentTicks();
    an localan = t.fQI();
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
    if ((localan != null) && (locala.dJO())) {}
    for (boolean bool1 = locala.dKa();; bool1 = true)
    {
      Log.i("MicroMsg.WalletPwdCustomDialog", "hy: soter key status: %b", new Object[] { Boolean.valueOf(bool1) });
      this.Ijy = 0;
      this.dUV = "";
      if ((locala != null) && (locala.dJT()) && (!locala.dJP())) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo isDeviceSupportFp: %b", new Object[] { Boolean.valueOf(bool1) });
        boolean bool2;
        if ((locala != null) && (locala.dJO()))
        {
          bool2 = true;
          if ((!bool2) || (!bool1) || (!this.Ijt) || (fTf())) {
            break label418;
          }
          this.Ijp.setVisibility(0);
          this.Ijp.setText(getContext().getString(2131768203));
          this.Ijs = 1;
          this.Ijq.setVisibility(0);
          this.Igh.setVisibility(0);
          this.Ija.setVisibility(8);
          this.mKBLayout.setVisibility(8);
          this.IiV.setText(2131768194);
          this.Ijy = 1;
          fSO();
          com.tencent.mm.plugin.report.service.h.CyF.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        for (;;)
        {
          Log.i("MicroMsg.WalletPwdCustomDialog", "isOpenTouch:" + bool2 + ",  isDeviceSupport:" + bool1 + ", use_pay_touch:" + this.Ijt + ", isForcePwdMode:" + fTf());
          this.Ijp.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(71125);
              b localb = new b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              if (r.this.Ijs == 0) {
                r.a(r.this);
              }
              for (;;)
              {
                if (r.this.Ijs == 1)
                {
                  r.fTg();
                  if (r.c(r.this)) {
                    r.d(r.this);
                  }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71125);
                return;
                if (r.this.Ijs == 1) {
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
          if ((bool2) && (bool1) && (this.Ijt) && (fTf()))
          {
            this.Ijp.setText(getContext().getString(2131767707));
            this.Ijp.setVisibility(0);
            this.Ijs = 0;
            this.Ijq.setVisibility(8);
            this.Ija.setVisibility(0);
            if (!this.mKBLayout.isShown()) {
              this.mKBLayout.setVisibility(0);
            }
            this.IiV.setText(2131768200);
            this.Ijy = 0;
            this.dUV = "";
            com.tencent.mm.plugin.report.service.h.CyF.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
            com.tencent.mm.wallet_core.ui.f.aqm(8);
          }
          else
          {
            this.Ijy = 0;
            this.dUV = "";
            this.Ijp.setVisibility(8);
            com.tencent.mm.plugin.report.service.h.CyF.a(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          }
        }
      }
    }
  }
  
  private void fTd()
  {
    AppMethodBeat.i(71135);
    this.Ijp.setText(getContext().getString(2131767707));
    this.Ijs = 0;
    this.Ijx = Util.currentTicks();
    this.Ijq.setVisibility(8);
    this.Ija.setVisibility(0);
    if (!this.mKBLayout.isShown()) {
      this.mKBLayout.setVisibility(0);
    }
    this.IiV.setText(2131768200);
    yp(true);
    this.Ijy = 0;
    this.dUV = "";
    com.tencent.mm.plugin.report.service.h.CyF.a(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    com.tencent.mm.wallet_core.ui.f.aqm(29);
    fSP();
    AppMethodBeat.o(71135);
  }
  
  private static boolean fTf()
  {
    AppMethodBeat.i(71147);
    g.aAi();
    Object localObject = g.aAh().azQ().get(ar.a.NUw, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(71147);
      return bool;
    }
  }
  
  private static void yp(boolean paramBoolean)
  {
    AppMethodBeat.i(71146);
    g.aAi();
    g.aAh().azQ().set(ar.a.NUw, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(71146);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(71141);
    try
    {
      super.dismiss();
      fSP();
      this.HCH.destory();
      if (this.wGp != null) {
        this.wGp.cancel();
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
  
  public final void fSA()
  {
    AppMethodBeat.i(71144);
    this.isPaused = false;
    if (z.aUo())
    {
      AppMethodBeat.o(71144);
      return;
    }
    AppMethodBeat.o(71144);
  }
  
  protected final void fTe()
  {
    AppMethodBeat.i(71142);
    yp(false);
    if (this.Ijl != null) {
      this.Ijl.onClick(this, 0);
    }
    dismiss();
    b localb;
    String str;
    if (this.Ijb != null)
    {
      Log.i("MicroMsg.WalletPwdCustomDialog", "doOk use_touch: %s soterAuthReq: %s ", new Object[] { Integer.valueOf(this.Ijy), this.dUV });
      localb = this.Ijb;
      str = this.Ija.getText();
      if (this.Ijy != 1) {
        break label127;
      }
    }
    label127:
    for (boolean bool = true;; bool = false)
    {
      localb.h(str, bool, this.dUV);
      if (this.Ijx >= 0L) {
        break;
      }
      Log.e("MicroMsg.WalletPwdCustomDialog", "hy: not set update mode time yet. abandon");
      AppMethodBeat.o(71142);
      return;
    }
    if (this.Ijs == 0)
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(686L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(686L, 1L, Util.ticksToNow(this.Ijx), false);
      AppMethodBeat.o(71142);
      return;
    }
    if (this.Ijs == 1)
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(686L, 2L, 1L, false);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(686L, 3L, Util.ticksToNow(this.Ijx), false);
    }
    AppMethodBeat.o(71142);
  }
  
  public final void onActivityPause()
  {
    AppMethodBeat.i(71145);
    this.isPaused = true;
    if (z.aUo())
    {
      AppMethodBeat.o(71145);
      return;
    }
    if (this.Ijs == 1) {
      fTd();
    }
    AppMethodBeat.o(71145);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71139);
    super.onCreate(paramBundle);
    setContentView(this.jBN);
    com.tencent.soter.a.g.f.hlO().hlP();
    AppMethodBeat.o(71139);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(71138);
    if (paramInt == 4)
    {
      if (this.XY != null) {
        this.XY.onCancel(this);
      }
      if (this.Ijk != null) {
        this.Ijk.ezC();
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
    this.ox = paramBoolean;
    setCanceledOnTouchOutside(this.ox);
    AppMethodBeat.o(71140);
  }
  
  public static abstract interface a
  {
    public abstract void ezC();
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