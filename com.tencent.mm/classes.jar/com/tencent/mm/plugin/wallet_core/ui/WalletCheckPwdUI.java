package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.g.a.ow.b;
import com.tencent.mm.g.a.rm;
import com.tencent.mm.g.a.zq;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.protocal.protobuf.eja;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.t;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

@com.tencent.mm.ui.base.a(3)
public class WalletCheckPwdUI
  extends WalletBaseUI
{
  private String IgA;
  private String IgB;
  private Animation IgC;
  private d.a IgD;
  private boolean Igo = false;
  private LinearLayout Igp;
  private ImageView Igq;
  private TextView Igr;
  private TextView Igs;
  private TextView Igt;
  private boolean Igu = false;
  private boolean Igv = false;
  private String Igw;
  private int Igx = 0;
  private int Igy;
  private boolean Igz;
  private String dDL;
  private int dOG = 0;
  private TextView jUR;
  private String kof;
  private ScrollView lTw;
  protected EditHintPasswdView ykY;
  
  private void a(dal paramdal)
  {
    AppMethodBeat.i(70912);
    if ((paramdal != null) && (!Util.isNullOrNil(paramdal.title))) {
      this.Igs.setText(paramdal.title);
    }
    if ((paramdal != null) && (!Util.isNullOrNil(paramdal.MFO))) {
      this.Igt.setText(paramdal.MFO);
    }
    fSN();
    AppMethodBeat.o(70912);
  }
  
  private void aew(int paramInt)
  {
    AppMethodBeat.i(70921);
    if (getIntent().getBooleanExtra("from_kinda", false))
    {
      zq localzq = new zq();
      localzq.efK.result = paramInt;
      EventCenter.instance.publish(localzq);
    }
    AppMethodBeat.o(70921);
  }
  
  private void fSM()
  {
    AppMethodBeat.i(70913);
    Log.i("Micromsg.WalletCheckPwdUI", "change mode: %s", new Object[] { Integer.valueOf(this.dOG) });
    if (this.dOG == 1)
    {
      this.Igp.setVisibility(0);
      this.ykY.setVisibility(8);
      this.jUR.setText(2131767637);
      this.Igp.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(70902);
          WalletCheckPwdUI.this.hideTenpayKB();
          AppMethodBeat.o(70902);
        }
      }, 300L);
      if (!Util.isNullOrNil(this.IgB))
      {
        this.Igt.setText(this.IgB);
        AppMethodBeat.o(70913);
        return;
      }
      this.Igt.setText(2131767641);
      AppMethodBeat.o(70913);
      return;
    }
    this.Igp.setVisibility(8);
    this.ykY.eIj();
    this.ykY.setVisibility(0);
    this.jUR.setText(2131767636);
    showTenpayKB();
    if (!Util.isNullOrNil(this.IgA))
    {
      this.Igt.setText(this.IgA);
      AppMethodBeat.o(70913);
      return;
    }
    this.Igt.setText(2131767640);
    AppMethodBeat.o(70913);
  }
  
  private void fSN()
  {
    AppMethodBeat.i(70914);
    Object localObject = getProcess();
    if (localObject != null)
    {
      if ("UnbindProcess".equals(((com.tencent.mm.wallet_core.d)localObject).dKC()))
      {
        localObject = ((com.tencent.mm.wallet_core.d)localObject).dQL.getString("key_check_pwd_title");
        if (!Util.isNullOrNil((String)localObject)) {
          this.Igs.setText((CharSequence)localObject);
        }
        for (;;)
        {
          this.Igt.setText(2131767646);
          AppMethodBeat.o(70914);
          return;
          this.Igs.setText(2131767763);
        }
      }
      if ((localObject instanceof com.tencent.mm.plugin.wallet_core.b.b))
      {
        this.Igs.setText(2131767744);
        this.Igt.setText(2131767646);
        AppMethodBeat.o(70914);
        return;
      }
      if ("ModifyPwdProcess".equals(((com.tencent.mm.wallet_core.d)localObject).dKC()))
      {
        this.Igs.setText(2131767968);
        this.Igt.setText(2131767646);
        AppMethodBeat.o(70914);
        return;
      }
      if ("OfflineProcess".equals(((com.tencent.mm.wallet_core.d)localObject).dKC()))
      {
        this.Igs.setText(2131767645);
        this.Igt.setText(2131767646);
      }
    }
    AppMethodBeat.o(70914);
  }
  
  private void fSO()
  {
    AppMethodBeat.i(70919);
    this.Igz = true;
    com.tencent.mm.plugin.soter.d.a.flK();
    final ow localow = new ow();
    localow.dUQ.dNQ = this.dDL;
    localow.dUQ.dUS = 1;
    localow.dUQ.dUU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(70904);
        Log.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback");
        ow.b localb = localow.dUR;
        if (localb == null)
        {
          Log.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, result == null");
          AppMethodBeat.o(70904);
          return;
        }
        int i = localb.errCode;
        Log.v("Micromsg.WalletCheckPwdUI", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), localb.errMsg });
        if (i == 0)
        {
          Log.i("Micromsg.WalletCheckPwdUI", "hy: payInfo soterAuthReq: %s", new Object[] { localb.dUV });
          WalletCheckPwdUI.i(WalletCheckPwdUI.this).setVisibility(8);
          WalletCheckPwdUI.b(WalletCheckPwdUI.this, localb.dUV);
          com.tencent.mm.plugin.soter.d.a.aau(0);
          AppMethodBeat.o(70904);
          return;
        }
        Log.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
        int j = (int)(System.currentTimeMillis() / 1000L);
        int k = j - WalletCheckPwdUI.j(WalletCheckPwdUI.this);
        if (k > 1)
        {
          WalletCheckPwdUI.b(WalletCheckPwdUI.this, j);
          WalletCheckPwdUI.k(WalletCheckPwdUI.this);
        }
        boolean bool1;
        if ((i == 2) || (i == 10308))
        {
          bool1 = true;
          if (localb.dUW != 2) {
            break label366;
          }
        }
        label366:
        for (boolean bool2 = true;; bool2 = false)
        {
          Log.v("Micromsg.WalletCheckPwdUI", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(WalletCheckPwdUI.l(WalletCheckPwdUI.this)), Integer.valueOf(i), Boolean.valueOf(bool2) });
          if (((!bool2) && ((WalletCheckPwdUI.l(WalletCheckPwdUI.this) >= 3) || (k <= 1))) || (bool1)) {
            break label372;
          }
          Log.v("Micromsg.WalletCheckPwdUI", "alvinluo fingerprint pay");
          if (WalletCheckPwdUI.m(WalletCheckPwdUI.this) == null) {
            WalletCheckPwdUI.a(WalletCheckPwdUI.this, com.tencent.mm.ui.c.a.he(WalletCheckPwdUI.this.getContext()));
          }
          WalletCheckPwdUI.i(WalletCheckPwdUI.this).setVisibility(0);
          WalletCheckPwdUI.i(WalletCheckPwdUI.this).startAnimation(WalletCheckPwdUI.m(WalletCheckPwdUI.this));
          WalletCheckPwdUI.m(WalletCheckPwdUI.this).setFillAfter(true);
          com.tencent.mm.plugin.soter.d.a.aau(1);
          AppMethodBeat.o(70904);
          return;
          bool1 = false;
          break;
        }
        label372:
        if ((WalletCheckPwdUI.l(WalletCheckPwdUI.this) >= 3) || (bool1))
        {
          Log.v("Micromsg.WalletCheckPwdUI", "alvinluo change to pwd pay");
          WalletCheckPwdUI.fSQ();
          WalletCheckPwdUI.a(WalletCheckPwdUI.this, 0);
          WalletCheckPwdUI.g(WalletCheckPwdUI.this);
          WalletCheckPwdUI.n(WalletCheckPwdUI.this).setVisibility(8);
          com.tencent.mm.plugin.soter.d.a.aau(2);
        }
        AppMethodBeat.o(70904);
      }
    };
    EventCenter.instance.asyncPublish(localow, Looper.getMainLooper());
    AppMethodBeat.o(70919);
  }
  
  private static void fSP()
  {
    AppMethodBeat.i(70920);
    Log.i("Micromsg.WalletCheckPwdUI", "hy: send release FPManager");
    rm localrm = new rm();
    EventCenter.instance.publish(localrm);
    AppMethodBeat.o(70920);
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(70918);
    if (this.Igo)
    {
      finish();
      AppMethodBeat.o(70918);
      return;
    }
    if (this.ykY != null) {
      this.ykY.eIj();
    }
    AppMethodBeat.o(70918);
  }
  
  public void forceCancel()
  {
    AppMethodBeat.i(70907);
    Log.d("Micromsg.WalletCheckPwdUI", "check pwd ");
    cleanScenes();
    AppMethodBeat.o(70907);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496917;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70911);
    Util.isNullOrNil(getTips(0));
    this.ykY = ((EditHintPasswdView)findViewById(2131302674));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.ykY);
    this.ykY.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(70897);
        if (paramAnonymousBoolean)
        {
          WalletCheckPwdUI.a(WalletCheckPwdUI.this, WalletCheckPwdUI.this.ykY.getText());
          com.tencent.mm.wallet_core.d locald = com.tencent.mm.wallet_core.a.by(WalletCheckPwdUI.this);
          String str = null;
          if (locald != null) {
            str = locald.dKC();
          }
          if ((WalletCheckPwdUI.b(WalletCheckPwdUI.this)) && (!"UnbindProcess".equals(str)))
          {
            WalletCheckPwdUI.this.doSceneProgress(new x(WalletCheckPwdUI.c(WalletCheckPwdUI.this), WalletCheckPwdUI.d(WalletCheckPwdUI.this), (byte)0));
            com.tencent.mm.plugin.report.service.h.CyF.a(15021, new Object[] { Integer.valueOf(1) });
            AppMethodBeat.o(70897);
            return;
          }
          if (!WalletCheckPwdUI.this.getNetController().r(new Object[] { WalletCheckPwdUI.c(WalletCheckPwdUI.this), WalletCheckPwdUI.this.getPayReqKey() })) {
            WalletCheckPwdUI.this.doSceneProgress(new w(WalletCheckPwdUI.c(WalletCheckPwdUI.this), 1, WalletCheckPwdUI.this.getPayReqKey()));
          }
        }
        AppMethodBeat.o(70897);
      }
    });
    this.lTw = ((ScrollView)findViewById(2131310349));
    this.Igp = ((LinearLayout)findViewById(2131301523));
    this.Igq = ((ImageView)findViewById(2131301522));
    this.Igs = ((TextView)findViewById(2131310286));
    this.Igt = ((TextView)findViewById(2131310281));
    this.Igr = ((TextView)findViewById(2131301526));
    this.jUR = ((TextView)findViewById(2131310347));
    this.jUR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70898);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCheckPwdUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        WalletCheckPwdUI.fSQ();
        if (WalletCheckPwdUI.e(WalletCheckPwdUI.this) == 0)
        {
          WalletCheckPwdUI.a(WalletCheckPwdUI.this, 1);
          WalletCheckPwdUI.f(WalletCheckPwdUI.this);
        }
        for (;;)
        {
          WalletCheckPwdUI.g(WalletCheckPwdUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCheckPwdUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70898);
          return;
          WalletCheckPwdUI.a(WalletCheckPwdUI.this, 0);
        }
      }
    });
    setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
    {
      public final void onVisibleStateChange(final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(70900);
        Log.d("Micromsg.WalletCheckPwdUI", "kb visibility: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        WalletCheckPwdUI.h(WalletCheckPwdUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(70899);
            if (paramAnonymousBoolean)
            {
              WalletCheckPwdUI.h(WalletCheckPwdUI.this).fullScroll(130);
              AppMethodBeat.o(70899);
              return;
            }
            WalletCheckPwdUI.h(WalletCheckPwdUI.this).fullScroll(33);
            AppMethodBeat.o(70899);
          }
        });
        AppMethodBeat.o(70900);
      }
    });
    setEditFocusListener(this.ykY, 0, false);
    this.ykY.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(70901);
        WalletCheckPwdUI.this.ykY.hhY();
        AppMethodBeat.o(70901);
      }
    });
    showTenpayKB();
    AppMethodBeat.o(70911);
  }
  
  public boolean isTransparent()
  {
    return this.Igo;
  }
  
  public boolean needConfirmFinish()
  {
    AppMethodBeat.i(70917);
    if (getInput().getInt("key_pay_flag", 0) != 0)
    {
      AppMethodBeat.o(70917);
      return true;
    }
    AppMethodBeat.o(70917);
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = -1;
    AppMethodBeat.i(70906);
    super.onCreate(paramBundle);
    hideTitleView();
    hideActionbarLine();
    getController().p(this, getContext().getResources().getColor(2131101424));
    paramBundle = getIntent();
    Object localObject;
    if ((paramBundle != null) && (getIntent().hasExtra("scene")))
    {
      i = paramBundle.getIntExtra("scene", -1);
      if (i != 1) {
        break label465;
      }
      this.Igu = true;
      Log.d("Micromsg.WalletCheckPwdUI", "check pwd jsapi");
      setContentViewVisibility(4);
      paramBundle = null;
      if (!this.Igv) {
        break label250;
      }
      localObject = com.tencent.mm.wallet_core.a.by(this);
      if (localObject != null) {
        paramBundle = ((com.tencent.mm.wallet_core.d)localObject).dQL;
      }
      localObject = paramBundle;
      if (paramBundle != null) {
        break label291;
      }
      Log.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] process.getContextData null");
      setResult(1);
      aew(1);
      finish();
    }
    label291:
    label465:
    for (;;)
    {
      initView();
      fSN();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(70895);
          WalletCheckPwdUI.a(WalletCheckPwdUI.this);
          AppMethodBeat.o(70895);
          return false;
        }
      });
      findViewById(2131298771).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70896);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCheckPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          WalletCheckPwdUI.a(WalletCheckPwdUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCheckPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70896);
        }
      });
      AppMethodBeat.o(70906);
      return;
      paramBundle = com.tencent.mm.wallet_core.a.by(this);
      if (paramBundle == null) {
        break;
      }
      i = paramBundle.dQL.getInt("scene", -1);
      if ((i == 1) && ("UnbindProcess".equals(paramBundle.dKC()))) {}
      for (boolean bool = true;; bool = false)
      {
        this.Igv = bool;
        break;
      }
      label250:
      if (getIntent() == null)
      {
        Log.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] intent null");
        setResult(0);
        aew(0);
        finish();
      }
      else
      {
        localObject = getIntent().getExtras();
        paramBundle = ((Bundle)localObject).getString("appId");
        String str1 = ((Bundle)localObject).getString("timeStamp");
        String str2 = ((Bundle)localObject).getString("nonceStr");
        String str3 = ((Bundle)localObject).getString("packageExt");
        String str4 = ((Bundle)localObject).getString("signtype");
        String str5 = ((Bundle)localObject).getString("paySignature");
        String str6 = ((Bundle)localObject).getString("url");
        i = ((Bundle)localObject).getInt("pay_channel", 0);
        if (this.Igv) {
          Log.i("Micromsg.WalletCheckPwdUI", "appId is null? " + Util.isNullOrNil(paramBundle));
        }
        for (paramBundle = new com.tencent.mm.plugin.wallet_core.c.d(paramBundle, str1, str2, str3, str4, str5, str6, 10, "verifyWCPayPassword", i);; paramBundle = new com.tencent.mm.plugin.wallet_core.c.e(paramBundle, str1, str2, str3, str4, str5, str6, "verifyWCPayPassword", i))
        {
          doSceneForceProgress(paramBundle);
          break;
        }
        setContentViewVisibility(0);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(70910);
    super.onDestroy();
    if (this.Igz) {
      fSP();
    }
    AppMethodBeat.o(70910);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(70916);
    if ((this.mKBLayout != null) && (this.mKBLayout.isShown()))
    {
      this.mKBLayout.setVisibility(8);
      AppMethodBeat.o(70916);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(70916);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(70909);
    super.onPause();
    this.dOG = 0;
    fSM();
    fSP();
    removeSceneEndListener(580);
    AppMethodBeat.o(70909);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70908);
    if (this.ykY != null) {
      this.ykY.eIj();
    }
    addSceneEndListener(580);
    super.onResume();
    AppMethodBeat.o(70908);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(70915);
    Log.d("Micromsg.WalletCheckPwdUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof w))
      {
        paramString = getInput();
        paramString.putString("key_pwd1", this.ykY.getText());
        paramString.putString("key_bind_card_user_token", ((w)paramq).token);
        com.tencent.mm.wallet_core.a.l(this, paramString);
        if (this.ykY != null) {
          this.ykY.eIj();
        }
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(70915);
        return true;
        if ((paramq instanceof ad))
        {
          com.tencent.mm.ui.base.h.cD(this, getString(2131767653));
          paramString = com.tencent.mm.wallet_core.a.by(this);
          if (paramString != null) {
            paramString.dQL.putInt("key_process_result_code", -1);
          }
          com.tencent.mm.wallet_core.a.l(this, paramString.dQL);
          if (this.ykY != null) {
            this.ykY.eIj();
          }
          finish();
        }
        else if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.d))
        {
          com.tencent.mm.pluginsdk.wallet.e.bfP(((com.tencent.mm.plugin.wallet_core.c.d)paramq).fPP());
          this.Igw = ((com.tencent.mm.plugin.wallet_core.c.d)paramq).getToken();
          setResult(-1);
          a(((com.tencent.mm.plugin.wallet_core.c.d)paramq).fPQ());
          setContentViewVisibility(0);
        }
        else
        {
          if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.e))
          {
            paramString = (com.tencent.mm.plugin.wallet_core.c.e)paramq;
            this.Igw = paramString.HPD.token;
            this.dDL = paramString.HPD.KxE;
            com.tencent.mm.pluginsdk.wallet.e.bfP(paramString.HPD.KxE);
            if (paramString.HPD.Lkx != null)
            {
              this.IgA = paramString.HPD.Lkx.MFO;
              this.IgB = paramString.HPD.Lkx.MFP;
            }
            setResult(-1);
            a(paramString.HPD.Lkx);
            paramString = paramString.HPD.Llh;
            if ((paramString != null) && (paramString.KYF != null))
            {
              paramq = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
              if ((paramString.NiN == 1) && (paramString.NiO == 1) && (paramq.dJU()) && (paramq.dJT()) && (!paramq.dJP()))
              {
                Log.i("Micromsg.WalletCheckPwdUI", "can use touch pay");
                this.dOG = 1;
                if (paramString.KYF != null) {
                  com.tencent.mm.plugin.fingerprint.b.p.wFK.wFE = paramString.KYF.yO();
                }
                paramq = com.tencent.mm.plugin.fingerprint.b.p.wFK;
                if (paramString.KYG != 1) {
                  break label499;
                }
              }
            }
            label499:
            for (boolean bool = true;; bool = false)
            {
              paramq.wFM = bool;
              fSO();
              this.jUR.setVisibility(0);
              fSM();
              setContentViewVisibility(0);
              break;
            }
          }
          if ((paramq instanceof x))
          {
            paramString = (x)paramq;
            if (paramString.fPR())
            {
              Log.i("Micromsg.WalletCheckPwdUI", "need free sms");
              paramq = new Bundle();
              paramq.putString("key_pwd1", this.kof);
              paramq.putString("key_jsapi_token", this.Igw);
              paramq.putString("key_relation_key", paramString.HQd);
              paramq.putString("key_mobile", paramString.HQc);
              this.IgD = new d.a()
              {
                public final Intent q(int paramAnonymousInt, Bundle paramAnonymousBundle)
                {
                  AppMethodBeat.i(70903);
                  Log.i("Micromsg.WalletCheckPwdUI", "verify code end: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
                  Intent localIntent = new Intent();
                  localIntent.putExtra("token", paramAnonymousBundle.getString("key_jsapi_token"));
                  localIntent.putExtra("key_process_result_code", paramAnonymousInt);
                  localIntent.setClass(WalletCheckPwdUI.this.getContext(), WalletCheckPwdUI.class);
                  localIntent.addFlags(536870912);
                  localIntent.putExtra("key_process_is_stay", false);
                  AppMethodBeat.o(70903);
                  return localIntent;
                }
              };
              com.tencent.mm.wallet_core.a.a(this, p.class, paramq, this.IgD);
            }
            else
            {
              paramString = new Intent();
              paramString.putExtra("token", ((x)paramq).HQa);
              setResult(-1, paramString);
              aew(-1);
              finish();
            }
          }
        }
      }
    }
    if (this.ykY != null) {
      this.ykY.eIj();
    }
    if (((paramq instanceof com.tencent.mm.plugin.wallet_core.c.d)) || ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.e)))
    {
      Log.i("Micromsg.WalletCheckPwdUI", "check jsapi fail");
      paramString = com.tencent.mm.wallet_core.a.by(this);
      if ((paramString != null) && (paramString.dKC().equals("UnbindProcess")))
      {
        setResult(1);
        paramString.dQL.putInt("key_process_result_code", 1);
        com.tencent.mm.wallet_core.a.l(this, paramString.dQL);
      }
      for (;;)
      {
        AppMethodBeat.o(70915);
        return true;
        setResult(0);
        aew(0);
        finish();
      }
    }
    AppMethodBeat.o(70915);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setContentViewVisibility(int paramInt)
  {
    AppMethodBeat.i(70905);
    getContentView().setVisibility(paramInt);
    AppMethodBeat.o(70905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI
 * JD-Core Version:    0.7.0.1
 */