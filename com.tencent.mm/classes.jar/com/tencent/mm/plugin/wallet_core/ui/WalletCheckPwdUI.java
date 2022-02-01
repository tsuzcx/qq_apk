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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.oe;
import com.tencent.mm.g.a.oe.b;
import com.tencent.mm.g.a.qs;
import com.tencent.mm.g.a.yl;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.protocal.protobuf.dpe;
import com.tencent.mm.protocal.protobuf.yj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

@com.tencent.mm.ui.base.a(3)
public class WalletCheckPwdUI
  extends WalletBaseUI
{
  private boolean Dxd = false;
  private LinearLayout Dxe;
  private ImageView Dxf;
  private TextView Dxg;
  private TextView Dxh;
  private TextView Dxi;
  private boolean Dxj = false;
  private boolean Dxk = false;
  private String Dxl;
  private int Dxm = 0;
  private int Dxn;
  private boolean Dxo;
  private String Dxp;
  private String Dxq;
  private Animation Dxr;
  private d.a Dxs;
  private String dmw;
  private int dwZ = 0;
  private TextView iXS;
  private String jpT;
  private ScrollView kOy;
  protected EditHintPasswdView uSv;
  
  private void VU(int paramInt)
  {
    AppMethodBeat.i(70921);
    if (getIntent().getBooleanExtra("from_kinda", false))
    {
      yl localyl = new yl();
      localyl.dNP.result = paramInt;
      com.tencent.mm.sdk.b.a.IvT.l(localyl);
    }
    AppMethodBeat.o(70921);
  }
  
  private void a(ckd paramckd)
  {
    AppMethodBeat.i(70912);
    if ((paramckd != null) && (!bu.isNullOrNil(paramckd.title))) {
      this.Dxh.setText(paramckd.title);
    }
    if ((paramckd != null) && (!bu.isNullOrNil(paramckd.HwO))) {
      this.Dxi.setText(paramckd.HwO);
    }
    eLi();
    AppMethodBeat.o(70912);
  }
  
  private void eLh()
  {
    AppMethodBeat.i(70913);
    ae.i("Micromsg.WalletCheckPwdUI", "change mode: %s", new Object[] { Integer.valueOf(this.dwZ) });
    if (this.dwZ == 1)
    {
      this.Dxe.setVisibility(0);
      this.uSv.setVisibility(8);
      this.iXS.setText(2131765194);
      this.Dxe.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(70902);
          WalletCheckPwdUI.this.hideTenpayKB();
          AppMethodBeat.o(70902);
        }
      }, 300L);
      if (!bu.isNullOrNil(this.Dxq))
      {
        this.Dxi.setText(this.Dxq);
        AppMethodBeat.o(70913);
        return;
      }
      this.Dxi.setText(2131765198);
      AppMethodBeat.o(70913);
      return;
    }
    this.Dxe.setVisibility(8);
    this.uSv.dHv();
    this.uSv.setVisibility(0);
    this.iXS.setText(2131765193);
    showTenpayKB();
    if (!bu.isNullOrNil(this.Dxp))
    {
      this.Dxi.setText(this.Dxp);
      AppMethodBeat.o(70913);
      return;
    }
    this.Dxi.setText(2131765197);
    AppMethodBeat.o(70913);
  }
  
  private void eLi()
  {
    AppMethodBeat.i(70914);
    Object localObject = getProcess();
    if (localObject != null)
    {
      if ("UnbindProcess".equals(((com.tencent.mm.wallet_core.d)localObject).cSH()))
      {
        localObject = ((com.tencent.mm.wallet_core.d)localObject).dyY.getString("key_check_pwd_title");
        if (!bu.isNullOrNil((String)localObject)) {
          this.Dxh.setText((CharSequence)localObject);
        }
        for (;;)
        {
          this.Dxi.setText(2131765203);
          AppMethodBeat.o(70914);
          return;
          this.Dxh.setText(2131765320);
        }
      }
      if ((localObject instanceof com.tencent.mm.plugin.wallet_core.b.b))
      {
        this.Dxh.setText(2131765301);
        this.Dxi.setText(2131765203);
        AppMethodBeat.o(70914);
        return;
      }
      if ("ModifyPwdProcess".equals(((com.tencent.mm.wallet_core.d)localObject).cSH()))
      {
        this.Dxh.setText(2131765519);
        this.Dxi.setText(2131765203);
        AppMethodBeat.o(70914);
        return;
      }
      if ("OfflineProcess".equals(((com.tencent.mm.wallet_core.d)localObject).cSH()))
      {
        this.Dxh.setText(2131765202);
        this.Dxi.setText(2131765203);
      }
    }
    AppMethodBeat.o(70914);
  }
  
  private void eLj()
  {
    AppMethodBeat.i(70919);
    this.Dxo = true;
    com.tencent.mm.plugin.soter.d.a.ejk();
    final oe localoe = new oe();
    localoe.dDb.dwj = this.dmw;
    localoe.dDb.dDd = 1;
    localoe.dDb.dDf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(70904);
        ae.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback");
        oe.b localb = localoe.dDc;
        if (localb == null)
        {
          ae.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, result == null");
          AppMethodBeat.o(70904);
          return;
        }
        int i = localb.errCode;
        ae.v("Micromsg.WalletCheckPwdUI", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), localb.errMsg });
        if (i == 0)
        {
          ae.i("Micromsg.WalletCheckPwdUI", "hy: payInfo soterAuthReq: %s", new Object[] { localb.dDg });
          WalletCheckPwdUI.i(WalletCheckPwdUI.this).setVisibility(8);
          WalletCheckPwdUI.b(WalletCheckPwdUI.this, localb.dDg);
          com.tencent.mm.plugin.soter.d.a.Sy(0);
          AppMethodBeat.o(70904);
          return;
        }
        ae.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
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
          if (localb.dDh != 2) {
            break label366;
          }
        }
        label366:
        for (boolean bool2 = true;; bool2 = false)
        {
          ae.v("Micromsg.WalletCheckPwdUI", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(WalletCheckPwdUI.l(WalletCheckPwdUI.this)), Integer.valueOf(i), Boolean.valueOf(bool2) });
          if (((!bool2) && ((WalletCheckPwdUI.l(WalletCheckPwdUI.this) >= 3) || (k <= 1))) || (bool1)) {
            break label372;
          }
          ae.v("Micromsg.WalletCheckPwdUI", "alvinluo fingerprint pay");
          if (WalletCheckPwdUI.m(WalletCheckPwdUI.this) == null) {
            WalletCheckPwdUI.a(WalletCheckPwdUI.this, com.tencent.mm.ui.c.a.gt(WalletCheckPwdUI.this.getContext()));
          }
          WalletCheckPwdUI.i(WalletCheckPwdUI.this).setVisibility(0);
          WalletCheckPwdUI.i(WalletCheckPwdUI.this).startAnimation(WalletCheckPwdUI.m(WalletCheckPwdUI.this));
          WalletCheckPwdUI.m(WalletCheckPwdUI.this).setFillAfter(true);
          com.tencent.mm.plugin.soter.d.a.Sy(1);
          AppMethodBeat.o(70904);
          return;
          bool1 = false;
          break;
        }
        label372:
        if ((WalletCheckPwdUI.l(WalletCheckPwdUI.this) >= 3) || (bool1))
        {
          ae.v("Micromsg.WalletCheckPwdUI", "alvinluo change to pwd pay");
          WalletCheckPwdUI.eLl();
          WalletCheckPwdUI.a(WalletCheckPwdUI.this, 0);
          WalletCheckPwdUI.g(WalletCheckPwdUI.this);
          WalletCheckPwdUI.n(WalletCheckPwdUI.this).setVisibility(8);
          com.tencent.mm.plugin.soter.d.a.Sy(2);
        }
        AppMethodBeat.o(70904);
      }
    };
    com.tencent.mm.sdk.b.a.IvT.a(localoe, Looper.getMainLooper());
    AppMethodBeat.o(70919);
  }
  
  private static void eLk()
  {
    AppMethodBeat.i(70920);
    ae.i("Micromsg.WalletCheckPwdUI", "hy: send release FPManager");
    qs localqs = new qs();
    com.tencent.mm.sdk.b.a.IvT.l(localqs);
    AppMethodBeat.o(70920);
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(70918);
    if (this.Dxd)
    {
      finish();
      AppMethodBeat.o(70918);
      return;
    }
    if (this.uSv != null) {
      this.uSv.dHv();
    }
    AppMethodBeat.o(70918);
  }
  
  public void forceCancel()
  {
    AppMethodBeat.i(70907);
    ae.d("Micromsg.WalletCheckPwdUI", "check pwd ");
    cleanScenes();
    AppMethodBeat.o(70907);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495937;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70911);
    bu.ah(getTips(0));
    this.uSv = ((EditHintPasswdView)findViewById(2131301026));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.uSv);
    this.uSv.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(70897);
        if (paramAnonymousBoolean)
        {
          WalletCheckPwdUI.a(WalletCheckPwdUI.this, WalletCheckPwdUI.this.uSv.getText());
          com.tencent.mm.wallet_core.d locald = com.tencent.mm.wallet_core.a.bs(WalletCheckPwdUI.this);
          String str = null;
          if (locald != null) {
            str = locald.cSH();
          }
          if ((WalletCheckPwdUI.b(WalletCheckPwdUI.this)) && (!"UnbindProcess".equals(str)))
          {
            WalletCheckPwdUI.this.doSceneProgress(new x(WalletCheckPwdUI.c(WalletCheckPwdUI.this), WalletCheckPwdUI.d(WalletCheckPwdUI.this), (byte)0));
            com.tencent.mm.plugin.report.service.g.yxI.f(15021, new Object[] { Integer.valueOf(1) });
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
    this.kOy = ((ScrollView)findViewById(2131306881));
    this.Dxe = ((LinearLayout)findViewById(2131300088));
    this.Dxf = ((ImageView)findViewById(2131300087));
    this.Dxh = ((TextView)findViewById(2131306825));
    this.Dxi = ((TextView)findViewById(2131306820));
    this.Dxg = ((TextView)findViewById(2131300091));
    this.iXS = ((TextView)findViewById(2131306879));
    this.iXS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70898);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCheckPwdUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletCheckPwdUI.eLl();
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
        ae.d("Micromsg.WalletCheckPwdUI", "kb visibility: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
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
    setEditFocusListener(this.uSv, 0, false);
    this.uSv.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(70901);
        WalletCheckPwdUI.this.uSv.fWA();
        AppMethodBeat.o(70901);
      }
    });
    showTenpayKB();
    AppMethodBeat.o(70911);
  }
  
  public boolean isTransparent()
  {
    return this.Dxd;
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
    getController().q(this, getContext().getResources().getColor(2131101179));
    paramBundle = getIntent();
    Object localObject;
    if ((paramBundle != null) && (getIntent().hasExtra("scene")))
    {
      i = paramBundle.getIntExtra("scene", -1);
      if (i != 1) {
        break label465;
      }
      this.Dxj = true;
      ae.d("Micromsg.WalletCheckPwdUI", "check pwd jsapi");
      setContentViewVisibility(4);
      paramBundle = null;
      if (!this.Dxk) {
        break label250;
      }
      localObject = com.tencent.mm.wallet_core.a.bs(this);
      if (localObject != null) {
        paramBundle = ((com.tencent.mm.wallet_core.d)localObject).dyY;
      }
      localObject = paramBundle;
      if (paramBundle != null) {
        break label291;
      }
      ae.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] process.getContextData null");
      setResult(1);
      VU(1);
      finish();
    }
    label291:
    label465:
    for (;;)
    {
      initView();
      eLi();
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
      findViewById(2131298365).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70896);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCheckPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          WalletCheckPwdUI.a(WalletCheckPwdUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCheckPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70896);
        }
      });
      AppMethodBeat.o(70906);
      return;
      paramBundle = com.tencent.mm.wallet_core.a.bs(this);
      if (paramBundle == null) {
        break;
      }
      i = paramBundle.dyY.getInt("scene", -1);
      if ((i == 1) && ("UnbindProcess".equals(paramBundle.cSH()))) {}
      for (boolean bool = true;; bool = false)
      {
        this.Dxk = bool;
        break;
      }
      label250:
      if (getIntent() == null)
      {
        ae.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] intent null");
        setResult(0);
        VU(0);
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
        if (this.Dxk) {
          ae.i("Micromsg.WalletCheckPwdUI", "appId is null? " + bu.isNullOrNil(paramBundle));
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
    if (this.Dxo) {
      eLk();
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
    this.dwZ = 0;
    eLh();
    eLk();
    removeSceneEndListener(580);
    AppMethodBeat.o(70909);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70908);
    if (this.uSv != null) {
      this.uSv.dHv();
    }
    addSceneEndListener(580);
    super.onResume();
    AppMethodBeat.o(70908);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70915);
    ae.d("Micromsg.WalletCheckPwdUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof w))
      {
        paramString = getInput();
        paramString.putString("key_pwd1", this.uSv.getText());
        paramString.putString("key_bind_card_user_token", ((w)paramn).token);
        com.tencent.mm.wallet_core.a.k(this, paramString);
        if (this.uSv != null) {
          this.uSv.dHv();
        }
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(70915);
        return true;
        if ((paramn instanceof ad))
        {
          h.cm(this, getString(2131765210));
          paramString = com.tencent.mm.wallet_core.a.bs(this);
          if (paramString != null) {
            paramString.dyY.putInt("key_process_result_code", -1);
          }
          com.tencent.mm.wallet_core.a.k(this, paramString.dyY);
          if (this.uSv != null) {
            this.uSv.dHv();
          }
          finish();
        }
        else if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.d))
        {
          com.tencent.mm.pluginsdk.wallet.e.aPm(((com.tencent.mm.plugin.wallet_core.c.d)paramn).eIm());
          this.Dxl = ((com.tencent.mm.plugin.wallet_core.c.d)paramn).getToken();
          setResult(-1);
          a(((com.tencent.mm.plugin.wallet_core.c.d)paramn).eIn());
          setContentViewVisibility(0);
        }
        else
        {
          if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.e))
          {
            paramString = (com.tencent.mm.plugin.wallet_core.c.e)paramn;
            this.Dxl = paramString.Dgk.token;
            this.dmw = paramString.Dgk.FEz;
            com.tencent.mm.pluginsdk.wallet.e.aPm(paramString.Dgk.FEz);
            if (paramString.Dgk.GpL != null)
            {
              this.Dxp = paramString.Dgk.GpL.HwO;
              this.Dxq = paramString.Dgk.GpL.HwP;
            }
            setResult(-1);
            a(paramString.Dgk.GpL);
            paramString = paramString.Dgk.Gqp;
            if ((paramString != null) && (paramString.Geo != null))
            {
              paramn = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
              if ((paramString.HWF == 1) && (paramString.HWG == 1) && (paramn.cRZ()) && (paramn.cRY()) && (!paramn.cRU()))
              {
                ae.i("Micromsg.WalletCheckPwdUI", "can use touch pay");
                this.dwZ = 1;
                if (paramString.Geo != null) {
                  com.tencent.mm.plugin.fingerprint.b.p.tse.trY = paramString.Geo.fjO();
                }
                paramn = com.tencent.mm.plugin.fingerprint.b.p.tse;
                if (paramString.Gep != 1) {
                  break label499;
                }
              }
            }
            label499:
            for (boolean bool = true;; bool = false)
            {
              paramn.tsg = bool;
              eLj();
              this.iXS.setVisibility(0);
              eLh();
              setContentViewVisibility(0);
              break;
            }
          }
          if ((paramn instanceof x))
          {
            paramString = (x)paramn;
            if (paramString.eIo())
            {
              ae.i("Micromsg.WalletCheckPwdUI", "need free sms");
              paramn = new Bundle();
              paramn.putString("key_pwd1", this.jpT);
              paramn.putString("key_jsapi_token", this.Dxl);
              paramn.putString("key_relation_key", paramString.DgK);
              paramn.putString("key_mobile", paramString.DgJ);
              this.Dxs = new d.a()
              {
                public final Intent s(int paramAnonymousInt, Bundle paramAnonymousBundle)
                {
                  AppMethodBeat.i(70903);
                  ae.i("Micromsg.WalletCheckPwdUI", "verify code end: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
              com.tencent.mm.wallet_core.a.a(this, p.class, paramn, this.Dxs);
            }
            else
            {
              paramString = new Intent();
              paramString.putExtra("token", ((x)paramn).DgH);
              setResult(-1, paramString);
              VU(-1);
              finish();
            }
          }
        }
      }
    }
    if (this.uSv != null) {
      this.uSv.dHv();
    }
    if (((paramn instanceof com.tencent.mm.plugin.wallet_core.c.d)) || ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.e)))
    {
      ae.i("Micromsg.WalletCheckPwdUI", "check jsapi fail");
      paramString = com.tencent.mm.wallet_core.a.bs(this);
      if ((paramString != null) && (paramString.cSH().equals("UnbindProcess")))
      {
        setResult(1);
        paramString.dyY.putInt("key_process_result_code", 1);
        com.tencent.mm.wallet_core.a.k(this, paramString.dyY);
      }
      for (;;)
      {
        AppMethodBeat.o(70915);
        return true;
        setResult(0);
        VU(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI
 * JD-Core Version:    0.7.0.1
 */