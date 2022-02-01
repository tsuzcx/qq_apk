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
import com.tencent.mm.g.a.nv;
import com.tencent.mm.g.a.nv.b;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.g.a.xl;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.protocal.protobuf.dis;
import com.tencent.mm.protocal.protobuf.wh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

@com.tencent.mm.ui.base.a(3)
public class WalletCheckPwdUI
  extends WalletBaseUI
{
  private boolean BFh = false;
  private LinearLayout BFi;
  private ImageView BFj;
  private TextView BFk;
  private TextView BFl;
  private TextView BFm;
  private boolean BFn = false;
  private boolean BFo = false;
  private String BFp;
  private int BFq = 0;
  private int BFr;
  private boolean BFs;
  private String BFt;
  private String BFu;
  private Animation BFv;
  private d.a BFw;
  private String dac;
  private int dkh = 0;
  private TextView iBP;
  private String iTR;
  private ScrollView kqh;
  protected EditHintPasswdView tDZ;
  
  private void Tv(int paramInt)
  {
    AppMethodBeat.i(70921);
    if (getIntent().getBooleanExtra("from_kinda", false))
    {
      xl localxl = new xl();
      localxl.dAm.result = paramInt;
      com.tencent.mm.sdk.b.a.GpY.l(localxl);
    }
    AppMethodBeat.o(70921);
  }
  
  private void a(cek paramcek)
  {
    AppMethodBeat.i(70912);
    if ((paramcek != null) && (!bs.isNullOrNil(paramcek.title))) {
      this.BFl.setText(paramcek.title);
    }
    if ((paramcek != null) && (!bs.isNullOrNil(paramcek.Fth))) {
      this.BFm.setText(paramcek.Fth);
    }
    etu();
    AppMethodBeat.o(70912);
  }
  
  private void ett()
  {
    AppMethodBeat.i(70913);
    ac.i("Micromsg.WalletCheckPwdUI", "change mode: %s", new Object[] { Integer.valueOf(this.dkh) });
    if (this.dkh == 1)
    {
      this.BFi.setVisibility(0);
      this.tDZ.setVisibility(8);
      this.iBP.setText(2131765194);
      this.BFi.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(70902);
          WalletCheckPwdUI.this.hideTenpayKB();
          AppMethodBeat.o(70902);
        }
      }, 300L);
      if (!bs.isNullOrNil(this.BFu))
      {
        this.BFm.setText(this.BFu);
        AppMethodBeat.o(70913);
        return;
      }
      this.BFm.setText(2131765198);
      AppMethodBeat.o(70913);
      return;
    }
    this.BFi.setVisibility(8);
    this.tDZ.dtH();
    this.tDZ.setVisibility(0);
    this.iBP.setText(2131765193);
    showTenpayKB();
    if (!bs.isNullOrNil(this.BFt))
    {
      this.BFm.setText(this.BFt);
      AppMethodBeat.o(70913);
      return;
    }
    this.BFm.setText(2131765197);
    AppMethodBeat.o(70913);
  }
  
  private void etu()
  {
    AppMethodBeat.i(70914);
    Object localObject = getProcess();
    if (localObject != null)
    {
      if ("UnbindProcess".equals(((com.tencent.mm.wallet_core.d)localObject).cHN()))
      {
        localObject = ((com.tencent.mm.wallet_core.d)localObject).dmf.getString("key_check_pwd_title");
        if (!bs.isNullOrNil((String)localObject)) {
          this.BFl.setText((CharSequence)localObject);
        }
        for (;;)
        {
          this.BFm.setText(2131765203);
          AppMethodBeat.o(70914);
          return;
          this.BFl.setText(2131765320);
        }
      }
      if ((localObject instanceof com.tencent.mm.plugin.wallet_core.b.b))
      {
        this.BFl.setText(2131765301);
        this.BFm.setText(2131765203);
        AppMethodBeat.o(70914);
        return;
      }
      if ("ModifyPwdProcess".equals(((com.tencent.mm.wallet_core.d)localObject).cHN()))
      {
        this.BFl.setText(2131765519);
        this.BFm.setText(2131765203);
        AppMethodBeat.o(70914);
        return;
      }
      if ("OfflineProcess".equals(((com.tencent.mm.wallet_core.d)localObject).cHN()))
      {
        this.BFl.setText(2131765202);
        this.BFm.setText(2131765203);
      }
    }
    AppMethodBeat.o(70914);
  }
  
  private void etv()
  {
    AppMethodBeat.i(70919);
    this.BFs = true;
    com.tencent.mm.plugin.soter.d.a.dTo();
    final nv localnv = new nv();
    localnv.dqj.djr = this.dac;
    localnv.dqj.dql = 1;
    localnv.dqj.dqn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(70904);
        ac.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback");
        nv.b localb = localnv.dqk;
        if (localb == null)
        {
          ac.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, result == null");
          AppMethodBeat.o(70904);
          return;
        }
        int i = localb.errCode;
        ac.v("Micromsg.WalletCheckPwdUI", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), localb.errMsg });
        if (i == 0)
        {
          ac.i("Micromsg.WalletCheckPwdUI", "hy: payInfo soterAuthReq: %s", new Object[] { localb.dqo });
          WalletCheckPwdUI.i(WalletCheckPwdUI.this).setVisibility(8);
          WalletCheckPwdUI.b(WalletCheckPwdUI.this, localb.dqo);
          com.tencent.mm.plugin.soter.d.a.Qj(0);
          AppMethodBeat.o(70904);
          return;
        }
        ac.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
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
          if (localb.dqp != 2) {
            break label366;
          }
        }
        label366:
        for (boolean bool2 = true;; bool2 = false)
        {
          ac.v("Micromsg.WalletCheckPwdUI", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(WalletCheckPwdUI.l(WalletCheckPwdUI.this)), Integer.valueOf(i), Boolean.valueOf(bool2) });
          if (((!bool2) && ((WalletCheckPwdUI.l(WalletCheckPwdUI.this) >= 3) || (k <= 1))) || (bool1)) {
            break label372;
          }
          ac.v("Micromsg.WalletCheckPwdUI", "alvinluo fingerprint pay");
          if (WalletCheckPwdUI.m(WalletCheckPwdUI.this) == null) {
            WalletCheckPwdUI.a(WalletCheckPwdUI.this, com.tencent.mm.ui.c.a.gl(WalletCheckPwdUI.this.getContext()));
          }
          WalletCheckPwdUI.i(WalletCheckPwdUI.this).setVisibility(0);
          WalletCheckPwdUI.i(WalletCheckPwdUI.this).startAnimation(WalletCheckPwdUI.m(WalletCheckPwdUI.this));
          WalletCheckPwdUI.m(WalletCheckPwdUI.this).setFillAfter(true);
          com.tencent.mm.plugin.soter.d.a.Qj(1);
          AppMethodBeat.o(70904);
          return;
          bool1 = false;
          break;
        }
        label372:
        if ((WalletCheckPwdUI.l(WalletCheckPwdUI.this) >= 3) || (bool1))
        {
          ac.v("Micromsg.WalletCheckPwdUI", "alvinluo change to pwd pay");
          WalletCheckPwdUI.etx();
          WalletCheckPwdUI.a(WalletCheckPwdUI.this, 0);
          WalletCheckPwdUI.g(WalletCheckPwdUI.this);
          WalletCheckPwdUI.n(WalletCheckPwdUI.this).setVisibility(8);
          com.tencent.mm.plugin.soter.d.a.Qj(2);
        }
        AppMethodBeat.o(70904);
      }
    };
    com.tencent.mm.sdk.b.a.GpY.a(localnv, Looper.getMainLooper());
    AppMethodBeat.o(70919);
  }
  
  private static void etw()
  {
    AppMethodBeat.i(70920);
    ac.i("Micromsg.WalletCheckPwdUI", "hy: send release FPManager");
    qg localqg = new qg();
    com.tencent.mm.sdk.b.a.GpY.l(localqg);
    AppMethodBeat.o(70920);
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(70918);
    if (this.BFh)
    {
      finish();
      AppMethodBeat.o(70918);
      return;
    }
    if (this.tDZ != null) {
      this.tDZ.dtH();
    }
    AppMethodBeat.o(70918);
  }
  
  public void forceCancel()
  {
    AppMethodBeat.i(70907);
    ac.d("Micromsg.WalletCheckPwdUI", "check pwd ");
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
    bs.aj(getTips(0));
    this.tDZ = ((EditHintPasswdView)findViewById(2131301026));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.tDZ);
    this.tDZ.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(70897);
        if (paramAnonymousBoolean)
        {
          WalletCheckPwdUI.a(WalletCheckPwdUI.this, WalletCheckPwdUI.this.tDZ.getText());
          com.tencent.mm.wallet_core.d locald = com.tencent.mm.wallet_core.a.br(WalletCheckPwdUI.this);
          String str = null;
          if (locald != null) {
            str = locald.cHN();
          }
          if ((WalletCheckPwdUI.b(WalletCheckPwdUI.this)) && (!"UnbindProcess".equals(str)))
          {
            WalletCheckPwdUI.this.doSceneProgress(new x(WalletCheckPwdUI.c(WalletCheckPwdUI.this), WalletCheckPwdUI.d(WalletCheckPwdUI.this), (byte)0));
            com.tencent.mm.plugin.report.service.h.wUl.f(15021, new Object[] { Integer.valueOf(1) });
            AppMethodBeat.o(70897);
            return;
          }
          if (!WalletCheckPwdUI.this.getNetController().s(new Object[] { WalletCheckPwdUI.c(WalletCheckPwdUI.this), WalletCheckPwdUI.this.getPayReqKey() })) {
            WalletCheckPwdUI.this.doSceneProgress(new w(WalletCheckPwdUI.c(WalletCheckPwdUI.this), 1, WalletCheckPwdUI.this.getPayReqKey()));
          }
        }
        AppMethodBeat.o(70897);
      }
    });
    this.kqh = ((ScrollView)findViewById(2131306881));
    this.BFi = ((LinearLayout)findViewById(2131300088));
    this.BFj = ((ImageView)findViewById(2131300087));
    this.BFl = ((TextView)findViewById(2131306825));
    this.BFm = ((TextView)findViewById(2131306820));
    this.BFk = ((TextView)findViewById(2131300091));
    this.iBP = ((TextView)findViewById(2131306879));
    this.iBP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70898);
        WalletCheckPwdUI.etx();
        if (WalletCheckPwdUI.e(WalletCheckPwdUI.this) == 0)
        {
          WalletCheckPwdUI.a(WalletCheckPwdUI.this, 1);
          WalletCheckPwdUI.f(WalletCheckPwdUI.this);
        }
        for (;;)
        {
          WalletCheckPwdUI.g(WalletCheckPwdUI.this);
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
        ac.d("Micromsg.WalletCheckPwdUI", "kb visibility: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
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
    setEditFocusListener(this.tDZ, 0, false);
    this.tDZ.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(70901);
        WalletCheckPwdUI.this.tDZ.fAU();
        AppMethodBeat.o(70901);
      }
    });
    showTenpayKB();
    AppMethodBeat.o(70911);
  }
  
  public boolean isTransparent()
  {
    return this.BFh;
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
      this.BFn = true;
      ac.d("Micromsg.WalletCheckPwdUI", "check pwd jsapi");
      setContentViewVisibility(4);
      paramBundle = null;
      if (!this.BFo) {
        break label250;
      }
      localObject = com.tencent.mm.wallet_core.a.br(this);
      if (localObject != null) {
        paramBundle = ((com.tencent.mm.wallet_core.d)localObject).dmf;
      }
      localObject = paramBundle;
      if (paramBundle != null) {
        break label291;
      }
      ac.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] process.getContextData null");
      setResult(1);
      Tv(1);
      finish();
    }
    label291:
    label465:
    for (;;)
    {
      initView();
      etu();
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
          WalletCheckPwdUI.a(WalletCheckPwdUI.this);
          AppMethodBeat.o(70896);
        }
      });
      AppMethodBeat.o(70906);
      return;
      paramBundle = com.tencent.mm.wallet_core.a.br(this);
      if (paramBundle == null) {
        break;
      }
      i = paramBundle.dmf.getInt("scene", -1);
      if ((i == 1) && ("UnbindProcess".equals(paramBundle.cHN()))) {}
      for (boolean bool = true;; bool = false)
      {
        this.BFo = bool;
        break;
      }
      label250:
      if (getIntent() == null)
      {
        ac.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] intent null");
        setResult(0);
        Tv(0);
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
        if (this.BFo) {
          ac.i("Micromsg.WalletCheckPwdUI", "appId is null? " + bs.isNullOrNil(paramBundle));
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
    if (this.BFs) {
      etw();
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
    this.dkh = 0;
    ett();
    etw();
    removeSceneEndListener(580);
    AppMethodBeat.o(70909);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70908);
    if (this.tDZ != null) {
      this.tDZ.dtH();
    }
    addSceneEndListener(580);
    super.onResume();
    AppMethodBeat.o(70908);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70915);
    ac.d("Micromsg.WalletCheckPwdUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof w))
      {
        paramString = getInput();
        paramString.putString("key_pwd1", this.tDZ.getText());
        paramString.putString("key_bind_card_user_token", ((w)paramn).token);
        com.tencent.mm.wallet_core.a.k(this, paramString);
        if (this.tDZ != null) {
          this.tDZ.dtH();
        }
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(70915);
        return true;
        if ((paramn instanceof ad))
        {
          com.tencent.mm.ui.base.h.cg(this, getString(2131765210));
          paramString = com.tencent.mm.wallet_core.a.br(this);
          if (paramString != null) {
            paramString.dmf.putInt("key_process_result_code", -1);
          }
          com.tencent.mm.wallet_core.a.k(this, paramString.dmf);
          if (this.tDZ != null) {
            this.tDZ.dtH();
          }
          finish();
        }
        else if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.d))
        {
          com.tencent.mm.pluginsdk.wallet.e.aIm(((com.tencent.mm.plugin.wallet_core.c.d)paramn).eqF());
          this.BFp = ((com.tencent.mm.plugin.wallet_core.c.d)paramn).getToken();
          setResult(-1);
          a(((com.tencent.mm.plugin.wallet_core.c.d)paramn).eqG());
          setContentViewVisibility(0);
        }
        else
        {
          if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.e))
          {
            paramString = (com.tencent.mm.plugin.wallet_core.c.e)paramn;
            this.BFp = paramString.Boq.token;
            this.dac = paramString.Boq.DGU;
            com.tencent.mm.pluginsdk.wallet.e.aIm(paramString.Boq.DGU);
            if (paramString.Boq.Eqb != null)
            {
              this.BFt = paramString.Boq.Eqb.Fth;
              this.BFu = paramString.Boq.Eqb.Fti;
            }
            setResult(-1);
            a(paramString.Boq.Eqb);
            paramString = paramString.Boq.EqG;
            if ((paramString != null) && (paramString.Efq != null))
            {
              paramn = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
              if ((paramString.FSm == 1) && (paramString.FSn == 1) && (paramn.cHf()) && (paramn.cHe()) && (!paramn.cHa()))
              {
                ac.i("Micromsg.WalletCheckPwdUI", "can use touch pay");
                this.dkh = 1;
                if (paramString.Efq != null) {
                  com.tencent.mm.plugin.fingerprint.b.p.skJ.skD = paramString.Efq.eQU();
                }
                paramn = com.tencent.mm.plugin.fingerprint.b.p.skJ;
                if (paramString.Efr != 1) {
                  break label499;
                }
              }
            }
            label499:
            for (boolean bool = true;; bool = false)
            {
              paramn.skL = bool;
              etv();
              this.iBP.setVisibility(0);
              ett();
              setContentViewVisibility(0);
              break;
            }
          }
          if ((paramn instanceof x))
          {
            paramString = (x)paramn;
            if (paramString.eqH())
            {
              ac.i("Micromsg.WalletCheckPwdUI", "need free sms");
              paramn = new Bundle();
              paramn.putString("key_pwd1", this.iTR);
              paramn.putString("key_jsapi_token", this.BFp);
              paramn.putString("key_relation_key", paramString.BoR);
              paramn.putString("key_mobile", paramString.BoQ);
              this.BFw = new d.a()
              {
                public final Intent r(int paramAnonymousInt, Bundle paramAnonymousBundle)
                {
                  AppMethodBeat.i(70903);
                  ac.i("Micromsg.WalletCheckPwdUI", "verify code end: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
              com.tencent.mm.wallet_core.a.a(this, p.class, paramn, this.BFw);
            }
            else
            {
              paramString = new Intent();
              paramString.putExtra("token", ((x)paramn).BoO);
              setResult(-1, paramString);
              Tv(-1);
              finish();
            }
          }
        }
      }
    }
    if (this.tDZ != null) {
      this.tDZ.dtH();
    }
    if (((paramn instanceof com.tencent.mm.plugin.wallet_core.c.d)) || ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.e)))
    {
      ac.i("Micromsg.WalletCheckPwdUI", "check jsapi fail");
      paramString = com.tencent.mm.wallet_core.a.br(this);
      if ((paramString != null) && (paramString.cHN().equals("UnbindProcess")))
      {
        setResult(1);
        paramString.dmf.putInt("key_process_result_code", 1);
        com.tencent.mm.wallet_core.a.k(this, paramString.dmf);
      }
      for (;;)
      {
        AppMethodBeat.o(70915);
        return true;
        setResult(0);
        Tv(0);
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