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
import com.tencent.mm.g.a.oe;
import com.tencent.mm.g.a.oe.b;
import com.tencent.mm.g.a.qs;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.a.c;
import com.tencent.mm.ui.base.h;
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
  protected com.tencent.mm.plugin.wallet_core.utils.a CWV;
  protected boolean DAa;
  protected boolean DAb;
  protected Bankcard DAc;
  public TextView DAd;
  public View DAe;
  public TextView DAf;
  protected int DAg;
  protected boolean DAh;
  private int DAi;
  private Animation DAj;
  private String DAk;
  private long DAl;
  private int DAm;
  private int DAn;
  private boolean DAo;
  public TextView Dbp;
  public Button Dim;
  public ImageView DwW;
  public TextView DzJ;
  public TextView DzK;
  public FavourLayout DzL;
  public CdnImageView DzM;
  public TextView DzN;
  public EditHintPasswdView DzO;
  public b DzP;
  public View DzQ;
  public View DzR;
  public TextView DzS;
  public ImageView DzT;
  public TextView DzU;
  public TextView DzV;
  public View DzW;
  public TextView DzX;
  protected a DzY;
  protected DialogInterface.OnClickListener DzZ;
  protected DialogInterface.OnCancelListener XL;
  private String dDg;
  private String dmw;
  public View iFK;
  private boolean isPaused;
  public ImageView jgy;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  protected boolean ov;
  private Animation tsJ;
  private int tst;
  public ImageView vKb;
  public TextView yGw;
  public TextView ytR;
  
  private r(Context paramContext)
  {
    super(paramContext, 2131821727);
    AppMethodBeat.i(71133);
    this.DAa = false;
    this.DAb = true;
    this.DAc = null;
    this.CWV = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.DAg = 0;
    this.DAh = false;
    this.DAi = 0;
    this.tst = 0;
    this.DAj = null;
    this.DAk = "";
    this.DAl = -1L;
    this.DAm = 0;
    this.dDg = "";
    this.DAn = 0;
    this.DAo = false;
    this.isPaused = false;
    ae.v("MicroMsg.WalletPwdCustomDialog", "alvinluo WalletPwdDialog initView");
    this.iFK = View.inflate(paramContext, 2131495963, null);
    this.Dim = ((Button)this.iFK.findViewById(2131302314));
    this.vKb = ((ImageView)this.iFK.findViewById(2131306819));
    this.mKeyboard = ((MyKeyboardWindow)this.iFK.findViewById(2131305695));
    this.mKBLayout = this.iFK.findViewById(2131305693);
    this.yGw = ((TextView)this.iFK.findViewById(2131298739));
    this.DzJ = ((TextView)this.iFK.findViewById(2131306826));
    this.ytR = ((TextView)this.iFK.findViewById(2131299872));
    this.Dbp = ((TextView)this.iFK.findViewById(2131303087));
    this.Dbp.getPaint().setFlags(16);
    this.DzK = ((TextView)this.iFK.findViewById(2131297176));
    this.DzL = ((FavourLayout)this.iFK.findViewById(2131299869));
    this.DzM = ((CdnImageView)this.iFK.findViewById(2131297165));
    this.DzQ = this.iFK.findViewById(2131299861);
    this.DzN = ((TextView)this.iFK.findViewById(2131302467));
    this.jgy = ((ImageView)this.iFK.findViewById(2131298184));
    this.DzR = this.iFK.findViewById(2131297163);
    this.DzS = ((TextView)this.iFK.findViewById(2131304595));
    a.b.c(this.jgy, com.tencent.mm.wallet_core.ui.f.getUsername());
    this.DzO = ((EditHintPasswdView)this.iFK.findViewById(2131301026));
    this.DzT = ((ImageView)this.iFK.findViewById(2131300682));
    this.DAd = ((TextView)this.iFK.findViewById(2131306814));
    this.DAe = this.iFK.findViewById(2131300088);
    this.DAf = ((TextView)this.iFK.findViewById(2131300091));
    this.DwW = ((ImageView)this.iFK.findViewById(2131300087));
    this.DzU = ((TextView)this.iFK.findViewById(2131297953));
    this.DzV = ((TextView)this.iFK.findViewById(2131303711));
    this.DzW = this.iFK.findViewById(2131299859);
    this.DzX = ((TextView)this.iFK.findViewById(2131299868));
    this.DzL.setVisibility(8);
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    this.Dim.setEnabled(false);
    this.Dim.setTextColor(paramContext.getResources().getColorStateList(2131101098));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.DzO);
    this.DzO.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(71122);
        if (paramAnonymousBoolean)
        {
          r.this.eLz();
          com.tencent.mm.plugin.report.service.g.yxI.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        AppMethodBeat.o(71122);
      }
    });
    this.DzO.requestFocus();
    Object localObject = (TextView)this.iFK.findViewById(2131306826);
    if (localObject != null) {
      ((TextView)localObject).setText(ah.kU(paramContext));
    }
    paramContext = (EditText)this.iFK.findViewById(2131306718);
    com.tencent.mm.wallet_core.ui.f.setNoSystemInputOnEditText(paramContext);
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
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (!r.this.mKBLayout.isShown()) {
          r.this.mKBLayout.setVisibility(0);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71123);
      }
    });
    this.iFK.findViewById(2131305696).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71124);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (r.this.mKBLayout.isShown()) {
          r.this.mKBLayout.setVisibility(8);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71124);
      }
    });
    eLx();
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
    if (localr.Dim != null)
    {
      localr.DzZ = null;
      localr.Dim.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71131);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          r.this.eLz();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71131);
        }
      });
    }
    if (localr.vKb != null)
    {
      localr.XL = paramOnCancelListener;
      localr.vKb.setVisibility(0);
      localr.vKb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71132);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (paramOnCancelListener != null) {
            paramOnCancelListener.onCancel(null);
          }
          if (r.this.DzY != null) {
            r.this.DzY.dzV();
          }
          r.this.cancel();
          if (r.this.DAd.isShown()) {
            com.tencent.mm.plugin.report.service.g.yxI.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71132);
            return;
            com.tencent.mm.plugin.report.service.g.yxI.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          }
        }
      });
    }
    localr.setOnCancelListener(paramOnCancelListener);
    localr.setCancelable(true);
    localr.yGw.setText(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      localr.ytR.setVisibility(0);
      localr.ytR.setText(paramString2);
      localr.DzR.setVisibility(8);
      localr.DAb = false;
      localr.DzY = parama;
      if (TextUtils.isEmpty(paramString3)) {
        break label261;
      }
      localr.DzU.setVisibility(0);
      localr.DzU.setText(paramString3);
    }
    for (;;)
    {
      localr.DzP = paramb;
      localr.DAh = paramBoolean;
      if (!v.aAR()) {
        localr.eLx();
      }
      localr.show();
      h.a(paramContext, localr);
      AppMethodBeat.o(71143);
      return localr;
      localr.ytR.setVisibility(8);
      break;
      label261:
      ae.i("MicroMsg.WalletPwdCustomDialog", "ChargeFee is null");
      localr.DzU.setVisibility(8);
    }
  }
  
  private static boolean eLA()
  {
    AppMethodBeat.i(71147);
    com.tencent.mm.kernel.g.ajS();
    Object localObject = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IMu, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(71147);
      return bool;
    }
  }
  
  private void eLj()
  {
    AppMethodBeat.i(71136);
    ae.i("MicroMsg.WalletPwdCustomDialog", "reqFingerPrintAuth %s", new Object[] { bu.fpN().toString() });
    com.tencent.mm.plugin.soter.d.a.ejk();
    final oe localoe = new oe();
    localoe.dDb.dwj = this.dmw;
    localoe.dDb.dDd = 1;
    localoe.dDb.dDf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71130);
        ae.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback");
        Object localObject = localoe.dDc;
        if (localObject == null)
        {
          r.a(r.this, 0);
          ae.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, result == null");
          AppMethodBeat.o(71130);
          return;
        }
        int i = ((oe.b)localObject).errCode;
        ae.v("MicroMsg.WalletPwdCustomDialog", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), ((oe.b)localObject).errMsg });
        if (i == 0)
        {
          ae.i("MicroMsg.WalletPwdCustomDialog", "hy: payInfo soterAuthReq: %s", new Object[] { ((oe.b)localObject).dDg });
          r.a(r.this, 1);
          r.a(r.this, ((oe.b)localObject).dDg);
          try
          {
            localObject = new JSONObject(r.e(r.this));
            ((JSONObject)localObject).put("soter_type", "1");
            r.a(r.this, ((JSONObject)localObject).toString());
            r.f(r.this);
            r.this.DAf.setText("");
            r.this.eLz();
            com.tencent.mm.plugin.report.service.g.yxI.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
            com.tencent.mm.plugin.soter.d.a.Sy(0);
            AppMethodBeat.o(71130);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.WalletPwdCustomDialog", localException, "", new Object[0]);
            }
          }
        }
        ae.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
        r.a(r.this, 0);
        r.a(r.this, "");
        r.this.DAe.setVisibility(0);
        r.this.DAf.setTextColor(r.this.getContext().getResources().getColor(2131100798));
        r.this.DAf.setText(2131765262);
        int j = (int)(System.currentTimeMillis() / 1000L);
        int k = j - r.g(r.this);
        if (k > 1)
        {
          r.b(r.this, j);
          r.h(r.this);
          r.f(r.this);
        }
        com.tencent.mm.plugin.report.service.g.yxI.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
        boolean bool1;
        if ((i == 2) || (i == 10308))
        {
          bool1 = true;
          if (localException.dDh != 2) {
            break label673;
          }
        }
        label673:
        for (boolean bool2 = true;; bool2 = false)
        {
          ae.v("MicroMsg.WalletPwdCustomDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(r.i(r.this)), Integer.valueOf(i), Boolean.valueOf(bool2) });
          if (((!bool2) && ((r.i(r.this) >= 3) || (k <= 1))) || (bool1)) {
            break label679;
          }
          ae.v("MicroMsg.WalletPwdCustomDialog", "alvinluo fingerprint pay");
          if (r.j(r.this) == null) {
            r.a(r.this, com.tencent.mm.ui.c.a.gt(r.this.getContext()));
          }
          r.this.DwW.setVisibility(8);
          r.this.DAf.setVisibility(4);
          r.j(r.this).reset();
          r.j(r.this).setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(71129);
              ae.i("MicroMsg.WalletPwdCustomDialog", "hy: on flash end");
              ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(71127);
                  r.this.DAf.setVisibility(8);
                  r.this.DwW.setVisibility(0);
                  AppMethodBeat.o(71127);
                }
              });
              AppMethodBeat.o(71129);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(71128);
              ae.i("MicroMsg.WalletPwdCustomDialog", "hy: on flash start");
              ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(71126);
                  r.this.DAf.setVisibility(0);
                  AppMethodBeat.o(71126);
                }
              });
              AppMethodBeat.o(71128);
            }
          });
          r.this.DAf.startAnimation(r.j(r.this));
          com.tencent.mm.plugin.soter.d.a.Sy(1);
          AppMethodBeat.o(71130);
          return;
          bool1 = false;
          break;
        }
        label679:
        if ((r.i(r.this) >= 3) || (bool1))
        {
          ae.v("MicroMsg.WalletPwdCustomDialog", "alvinluo change to pwd pay");
          r.eLB();
          r.this.DAg = 0;
          r.k(r.this);
          r.this.DAd.setVisibility(8);
          r.this.DAe.setVisibility(8);
          r.this.DAf.setVisibility(0);
          r.this.DAf.setText(2131765263);
          r.this.DAf.setTextColor(r.this.getContext().getResources().getColor(2131101133));
          r.this.DzJ.setText(2131765747);
          r.this.DzO.setVisibility(0);
          if (!r.this.mKBLayout.isShown()) {
            r.this.mKBLayout.setVisibility(0);
          }
          com.tencent.mm.plugin.soter.d.a.Sy(2);
          r.eLC();
        }
        AppMethodBeat.o(71130);
      }
    };
    com.tencent.mm.sdk.b.a.IvT.a(localoe, Looper.getMainLooper());
    AppMethodBeat.o(71136);
  }
  
  private static void eLk()
  {
    AppMethodBeat.i(71137);
    ae.i("MicroMsg.WalletPwdCustomDialog", "hy: send release FPManager");
    qs localqs = new qs();
    com.tencent.mm.sdk.b.a.IvT.l(localqs);
    AppMethodBeat.o(71137);
  }
  
  private void eLx()
  {
    AppMethodBeat.i(71134);
    ae.v("MicroMsg.WalletPwdCustomDialog", "alvinluo updateFingerprintMode");
    this.DAi = 0;
    this.DAd.setVisibility(8);
    this.DAe.setVisibility(8);
    this.DAl = bu.HQ();
    an localan = t.eJf();
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    if ((localan != null) && (locala.cRT())) {}
    for (boolean bool1 = locala.cSf();; bool1 = true)
    {
      ae.i("MicroMsg.WalletPwdCustomDialog", "hy: soter key status: %b", new Object[] { Boolean.valueOf(bool1) });
      this.DAm = 0;
      this.dDg = "";
      if ((locala != null) && (locala.cRY()) && (!locala.cRU())) {}
      for (bool1 = true;; bool1 = false)
      {
        ae.v("MicroMsg.WalletPwdCustomDialog", "alvinluo isDeviceSupportFp: %b", new Object[] { Boolean.valueOf(bool1) });
        boolean bool2;
        if ((locala != null) && (locala.cRT()))
        {
          bool2 = true;
          if ((!bool2) || (!bool1) || (!this.DAh) || (eLA())) {
            break label418;
          }
          this.DAd.setVisibility(0);
          this.DAd.setText(getContext().getString(2131765750));
          this.DAg = 1;
          this.DAe.setVisibility(0);
          this.DwW.setVisibility(0);
          this.DzO.setVisibility(8);
          this.mKBLayout.setVisibility(8);
          this.DzJ.setText(2131765741);
          this.DAm = 1;
          eLj();
          com.tencent.mm.plugin.report.service.g.yxI.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        for (;;)
        {
          ae.i("MicroMsg.WalletPwdCustomDialog", "isOpenTouch:" + bool2 + ",  isDeviceSupport:" + bool1 + ", use_pay_touch:" + this.DAh + ", isForcePwdMode:" + eLA());
          this.DAd.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(71125);
              b localb = new b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              if (r.this.DAg == 0) {
                r.a(r.this);
              }
              for (;;)
              {
                if (r.this.DAg == 1)
                {
                  r.eLB();
                  if (r.c(r.this)) {
                    r.d(r.this);
                  }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71125);
                return;
                if (r.this.DAg == 1) {
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
          if ((bool2) && (bool1) && (this.DAh) && (eLA()))
          {
            this.DAd.setText(getContext().getString(2131765264));
            this.DAd.setVisibility(0);
            this.DAg = 0;
            this.DAe.setVisibility(8);
            this.DzO.setVisibility(0);
            if (!this.mKBLayout.isShown()) {
              this.mKBLayout.setVisibility(0);
            }
            this.DzJ.setText(2131765747);
            this.DAm = 0;
            this.dDg = "";
            com.tencent.mm.plugin.report.service.g.yxI.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
            com.tencent.mm.wallet_core.ui.f.aha(8);
          }
          else
          {
            this.DAm = 0;
            this.dDg = "";
            this.DAd.setVisibility(8);
            com.tencent.mm.plugin.report.service.g.yxI.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          }
        }
      }
    }
  }
  
  private void eLy()
  {
    AppMethodBeat.i(71135);
    this.DAd.setText(getContext().getString(2131765264));
    this.DAg = 0;
    this.DAl = bu.HQ();
    this.DAe.setVisibility(8);
    this.DzO.setVisibility(0);
    if (!this.mKBLayout.isShown()) {
      this.mKBLayout.setVisibility(0);
    }
    this.DzJ.setText(2131765747);
    uB(true);
    this.DAm = 0;
    this.dDg = "";
    com.tencent.mm.plugin.report.service.g.yxI.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    com.tencent.mm.wallet_core.ui.f.aha(29);
    eLk();
    AppMethodBeat.o(71135);
  }
  
  private static void uB(boolean paramBoolean)
  {
    AppMethodBeat.i(71146);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IMu, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(71146);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(71141);
    try
    {
      super.dismiss();
      eLk();
      this.CWV.destory();
      if (this.tsJ != null) {
        this.tsJ.cancel();
      }
      AppMethodBeat.o(71141);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.WalletPwdCustomDialog", "dismiss exception, e = " + localException.getMessage());
      }
    }
  }
  
  public final void eKV()
  {
    AppMethodBeat.i(71144);
    this.isPaused = false;
    if (v.aAR())
    {
      AppMethodBeat.o(71144);
      return;
    }
    AppMethodBeat.o(71144);
  }
  
  protected final void eLz()
  {
    AppMethodBeat.i(71142);
    uB(false);
    if (this.DzZ != null) {
      this.DzZ.onClick(this, 0);
    }
    dismiss();
    b localb;
    String str;
    if (this.DzP != null)
    {
      ae.i("MicroMsg.WalletPwdCustomDialog", "doOk use_touch: %s soterAuthReq: %s ", new Object[] { Integer.valueOf(this.DAm), this.dDg });
      localb = this.DzP;
      str = this.DzO.getText();
      if (this.DAm != 1) {
        break label127;
      }
    }
    label127:
    for (boolean bool = true;; bool = false)
    {
      localb.h(str, bool, this.dDg);
      if (this.DAl >= 0L) {
        break;
      }
      ae.e("MicroMsg.WalletPwdCustomDialog", "hy: not set update mode time yet. abandon");
      AppMethodBeat.o(71142);
      return;
    }
    if (this.DAg == 0)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(686L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(686L, 1L, bu.aO(this.DAl), false);
      AppMethodBeat.o(71142);
      return;
    }
    if (this.DAg == 1)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(686L, 2L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(686L, 3L, bu.aO(this.DAl), false);
    }
    AppMethodBeat.o(71142);
  }
  
  public final void onActivityPause()
  {
    AppMethodBeat.i(71145);
    this.isPaused = true;
    if (v.aAR())
    {
      AppMethodBeat.o(71145);
      return;
    }
    if (this.DAg == 1) {
      eLy();
    }
    AppMethodBeat.o(71145);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71139);
    super.onCreate(paramBundle);
    setContentView(this.iFK);
    com.tencent.soter.a.g.f.fZD().fZE();
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
      if (this.DzY != null) {
        this.DzY.dzV();
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
    public abstract void dzV();
  }
  
  public static abstract interface b
  {
    public abstract void h(String paramString1, boolean paramBoolean, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.r
 * JD-Core Version:    0.7.0.1
 */