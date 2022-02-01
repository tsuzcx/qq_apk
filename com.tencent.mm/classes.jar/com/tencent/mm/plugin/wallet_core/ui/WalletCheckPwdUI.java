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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.nm;
import com.tencent.mm.g.a.nm.b;
import com.tencent.mm.g.a.px;
import com.tencent.mm.g.a.xa;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.protocal.protobuf.bzm;
import com.tencent.mm.protocal.protobuf.dde;
import com.tencent.mm.protocal.protobuf.vx;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.r;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

@com.tencent.mm.ui.base.a(3)
public class WalletCheckPwdUI
  extends WalletBaseUI
{
  private boolean AmM = false;
  private LinearLayout AmN;
  private ImageView AmO;
  private TextView AmP;
  private TextView AmQ;
  private TextView AmR;
  private boolean AmS = false;
  private boolean AmT = false;
  private String AmU;
  private int AmV = 0;
  private int AmW;
  private boolean AmX;
  private String AmY;
  private String AmZ;
  private Animation Ana;
  private d.a Anb;
  private String dcE;
  private int dmz = 0;
  private TextView ibI;
  private String itM;
  private ScrollView jPx;
  protected EditHintPasswdView swk;
  
  private void Rm(int paramInt)
  {
    AppMethodBeat.i(70921);
    if (getIntent().getBooleanExtra("from_kinda", false))
    {
      xa localxa = new xa();
      localxa.dCA.result = paramInt;
      com.tencent.mm.sdk.b.a.ESL.l(localxa);
    }
    AppMethodBeat.o(70921);
  }
  
  private void a(bzm parambzm)
  {
    AppMethodBeat.i(70912);
    if ((parambzm != null) && (!bt.isNullOrNil(parambzm.title))) {
      this.AmQ.setText(parambzm.title);
    }
    if ((parambzm != null) && (!bt.isNullOrNil(parambzm.DWp))) {
      this.AmR.setText(parambzm.DWp);
    }
    edZ();
    AppMethodBeat.o(70912);
  }
  
  private void edY()
  {
    AppMethodBeat.i(70913);
    com.tencent.mm.sdk.platformtools.ad.i("Micromsg.WalletCheckPwdUI", "change mode: %s", new Object[] { Integer.valueOf(this.dmz) });
    if (this.dmz == 1)
    {
      this.AmN.setVisibility(0);
      this.swk.setVisibility(8);
      this.ibI.setText(2131765194);
      this.AmN.postDelayed(new WalletCheckPwdUI.7(this), 300L);
      if (!bt.isNullOrNil(this.AmZ))
      {
        this.AmR.setText(this.AmZ);
        AppMethodBeat.o(70913);
        return;
      }
      this.AmR.setText(2131765198);
      AppMethodBeat.o(70913);
      return;
    }
    this.AmN.setVisibility(8);
    this.swk.dga();
    this.swk.setVisibility(0);
    this.ibI.setText(2131765193);
    showTenpayKB();
    if (!bt.isNullOrNil(this.AmY))
    {
      this.AmR.setText(this.AmY);
      AppMethodBeat.o(70913);
      return;
    }
    this.AmR.setText(2131765197);
    AppMethodBeat.o(70913);
  }
  
  private void edZ()
  {
    AppMethodBeat.i(70914);
    Object localObject = getProcess();
    if (localObject != null)
    {
      if ("UnbindProcess".equals(((com.tencent.mm.wallet_core.d)localObject).cuB()))
      {
        localObject = ((com.tencent.mm.wallet_core.d)localObject).dow.getString("key_check_pwd_title");
        if (!bt.isNullOrNil((String)localObject)) {
          this.AmQ.setText((CharSequence)localObject);
        }
        for (;;)
        {
          this.AmR.setText(2131765203);
          AppMethodBeat.o(70914);
          return;
          this.AmQ.setText(2131765320);
        }
      }
      if ((localObject instanceof com.tencent.mm.plugin.wallet_core.b.b))
      {
        this.AmQ.setText(2131765301);
        this.AmR.setText(2131765203);
        AppMethodBeat.o(70914);
        return;
      }
      if ("ModifyPwdProcess".equals(((com.tencent.mm.wallet_core.d)localObject).cuB()))
      {
        this.AmQ.setText(2131765519);
        this.AmR.setText(2131765203);
        AppMethodBeat.o(70914);
        return;
      }
      if ("OfflineProcess".equals(((com.tencent.mm.wallet_core.d)localObject).cuB()))
      {
        this.AmQ.setText(2131765202);
        this.AmR.setText(2131765203);
      }
    }
    AppMethodBeat.o(70914);
  }
  
  private void eea()
  {
    AppMethodBeat.i(70919);
    this.AmX = true;
    com.tencent.mm.plugin.soter.d.a.dEP();
    final nm localnm = new nm();
    localnm.dsz.dlJ = this.dcE;
    localnm.dsz.dsB = 1;
    localnm.dsz.dsD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(70904);
        com.tencent.mm.sdk.platformtools.ad.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback");
        nm.b localb = localnm.dsA;
        if (localb == null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, result == null");
          AppMethodBeat.o(70904);
          return;
        }
        int i = localb.errCode;
        com.tencent.mm.sdk.platformtools.ad.v("Micromsg.WalletCheckPwdUI", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), localb.errMsg });
        if (i == 0)
        {
          com.tencent.mm.sdk.platformtools.ad.i("Micromsg.WalletCheckPwdUI", "hy: payInfo soterAuthReq: %s", new Object[] { localb.dsE });
          WalletCheckPwdUI.i(WalletCheckPwdUI.this).setVisibility(8);
          WalletCheckPwdUI.b(WalletCheckPwdUI.this, localb.dsE);
          com.tencent.mm.plugin.soter.d.a.Oe(0);
          AppMethodBeat.o(70904);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
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
          if (localb.dsF != 2) {
            break label366;
          }
        }
        label366:
        for (boolean bool2 = true;; bool2 = false)
        {
          com.tencent.mm.sdk.platformtools.ad.v("Micromsg.WalletCheckPwdUI", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(WalletCheckPwdUI.l(WalletCheckPwdUI.this)), Integer.valueOf(i), Boolean.valueOf(bool2) });
          if (((!bool2) && ((WalletCheckPwdUI.l(WalletCheckPwdUI.this) >= 3) || (k <= 1))) || (bool1)) {
            break label372;
          }
          com.tencent.mm.sdk.platformtools.ad.v("Micromsg.WalletCheckPwdUI", "alvinluo fingerprint pay");
          if (WalletCheckPwdUI.m(WalletCheckPwdUI.this) == null) {
            WalletCheckPwdUI.a(WalletCheckPwdUI.this, com.tencent.mm.ui.c.a.fZ(WalletCheckPwdUI.this.getContext()));
          }
          WalletCheckPwdUI.i(WalletCheckPwdUI.this).setVisibility(0);
          WalletCheckPwdUI.i(WalletCheckPwdUI.this).startAnimation(WalletCheckPwdUI.m(WalletCheckPwdUI.this));
          WalletCheckPwdUI.m(WalletCheckPwdUI.this).setFillAfter(true);
          com.tencent.mm.plugin.soter.d.a.Oe(1);
          AppMethodBeat.o(70904);
          return;
          bool1 = false;
          break;
        }
        label372:
        if ((WalletCheckPwdUI.l(WalletCheckPwdUI.this) >= 3) || (bool1))
        {
          com.tencent.mm.sdk.platformtools.ad.v("Micromsg.WalletCheckPwdUI", "alvinluo change to pwd pay");
          WalletCheckPwdUI.eec();
          WalletCheckPwdUI.a(WalletCheckPwdUI.this, 0);
          WalletCheckPwdUI.g(WalletCheckPwdUI.this);
          WalletCheckPwdUI.n(WalletCheckPwdUI.this).setVisibility(8);
          com.tencent.mm.plugin.soter.d.a.Oe(2);
        }
        AppMethodBeat.o(70904);
      }
    };
    com.tencent.mm.sdk.b.a.ESL.a(localnm, Looper.getMainLooper());
    AppMethodBeat.o(70919);
  }
  
  private static void eeb()
  {
    AppMethodBeat.i(70920);
    com.tencent.mm.sdk.platformtools.ad.i("Micromsg.WalletCheckPwdUI", "hy: send release FPManager");
    px localpx = new px();
    com.tencent.mm.sdk.b.a.ESL.l(localpx);
    AppMethodBeat.o(70920);
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(70918);
    if (this.AmM)
    {
      finish();
      AppMethodBeat.o(70918);
      return;
    }
    if (this.swk != null) {
      this.swk.dga();
    }
    AppMethodBeat.o(70918);
  }
  
  public void forceCancel()
  {
    AppMethodBeat.i(70907);
    com.tencent.mm.sdk.platformtools.ad.d("Micromsg.WalletCheckPwdUI", "check pwd ");
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
    bt.ai(getTips(0));
    this.swk = ((EditHintPasswdView)findViewById(2131301026));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.swk);
    this.swk.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(70897);
        if (paramAnonymousBoolean)
        {
          WalletCheckPwdUI.a(WalletCheckPwdUI.this, WalletCheckPwdUI.this.swk.getText());
          com.tencent.mm.wallet_core.d locald = com.tencent.mm.wallet_core.a.bo(WalletCheckPwdUI.this);
          String str = null;
          if (locald != null) {
            str = locald.cuB();
          }
          if ((WalletCheckPwdUI.b(WalletCheckPwdUI.this)) && (!"UnbindProcess".equals(str)))
          {
            WalletCheckPwdUI.this.doSceneProgress(new x(WalletCheckPwdUI.c(WalletCheckPwdUI.this), WalletCheckPwdUI.d(WalletCheckPwdUI.this), (byte)0));
            com.tencent.mm.plugin.report.service.h.vKh.f(15021, new Object[] { Integer.valueOf(1) });
            AppMethodBeat.o(70897);
            return;
          }
          if (!WalletCheckPwdUI.this.getNetController().q(new Object[] { WalletCheckPwdUI.c(WalletCheckPwdUI.this), WalletCheckPwdUI.this.getPayReqKey() })) {
            WalletCheckPwdUI.this.doSceneProgress(new w(WalletCheckPwdUI.c(WalletCheckPwdUI.this), 1, WalletCheckPwdUI.this.getPayReqKey()));
          }
        }
        AppMethodBeat.o(70897);
      }
    });
    this.jPx = ((ScrollView)findViewById(2131306881));
    this.AmN = ((LinearLayout)findViewById(2131300088));
    this.AmO = ((ImageView)findViewById(2131300087));
    this.AmQ = ((TextView)findViewById(2131306825));
    this.AmR = ((TextView)findViewById(2131306820));
    this.AmP = ((TextView)findViewById(2131300091));
    this.ibI = ((TextView)findViewById(2131306879));
    this.ibI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70898);
        WalletCheckPwdUI.eec();
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
        com.tencent.mm.sdk.platformtools.ad.d("Micromsg.WalletCheckPwdUI", "kb visibility: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
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
    setEditFocusListener(this.swk, 0, false);
    this.swk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(70901);
        WalletCheckPwdUI.this.swk.fkE();
        AppMethodBeat.o(70901);
      }
    });
    showTenpayKB();
    AppMethodBeat.o(70911);
  }
  
  public boolean isTransparent()
  {
    return this.AmM;
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
      this.AmS = true;
      com.tencent.mm.sdk.platformtools.ad.d("Micromsg.WalletCheckPwdUI", "check pwd jsapi");
      setContentViewVisibility(4);
      paramBundle = null;
      if (!this.AmT) {
        break label250;
      }
      localObject = com.tencent.mm.wallet_core.a.bo(this);
      if (localObject != null) {
        paramBundle = ((com.tencent.mm.wallet_core.d)localObject).dow;
      }
      localObject = paramBundle;
      if (paramBundle != null) {
        break label291;
      }
      com.tencent.mm.sdk.platformtools.ad.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] process.getContextData null");
      setResult(1);
      Rm(1);
      finish();
    }
    label291:
    label465:
    for (;;)
    {
      initView();
      edZ();
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
      paramBundle = com.tencent.mm.wallet_core.a.bo(this);
      if (paramBundle == null) {
        break;
      }
      i = paramBundle.dow.getInt("scene", -1);
      if ((i == 1) && ("UnbindProcess".equals(paramBundle.cuB()))) {}
      for (boolean bool = true;; bool = false)
      {
        this.AmT = bool;
        break;
      }
      label250:
      if (getIntent() == null)
      {
        com.tencent.mm.sdk.platformtools.ad.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] intent null");
        setResult(0);
        Rm(0);
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
        if (this.AmT) {
          com.tencent.mm.sdk.platformtools.ad.i("Micromsg.WalletCheckPwdUI", "appId is null? " + bt.isNullOrNil(paramBundle));
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
    if (this.AmX) {
      eeb();
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
    this.dmz = 0;
    edY();
    eeb();
    removeSceneEndListener(580);
    AppMethodBeat.o(70909);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70908);
    if (this.swk != null) {
      this.swk.dga();
    }
    addSceneEndListener(580);
    super.onResume();
    AppMethodBeat.o(70908);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70915);
    com.tencent.mm.sdk.platformtools.ad.d("Micromsg.WalletCheckPwdUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof w))
      {
        paramString = getInput();
        paramString.putString("key_pwd1", this.swk.getText());
        paramString.putString("key_bind_card_user_token", ((w)paramn).token);
        com.tencent.mm.wallet_core.a.k(this, paramString);
        if (this.swk != null) {
          this.swk.dga();
        }
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(70915);
        return true;
        if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad))
        {
          com.tencent.mm.ui.base.h.cf(this, getString(2131765210));
          paramString = com.tencent.mm.wallet_core.a.bo(this);
          if (paramString != null) {
            paramString.dow.putInt("key_process_result_code", -1);
          }
          com.tencent.mm.wallet_core.a.k(this, paramString.dow);
          if (this.swk != null) {
            this.swk.dga();
          }
          finish();
        }
        else if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.d))
        {
          com.tencent.mm.pluginsdk.wallet.e.aCV(((com.tencent.mm.plugin.wallet_core.c.d)paramn).ebj());
          this.AmU = ((com.tencent.mm.plugin.wallet_core.c.d)paramn).getToken();
          setResult(-1);
          a(((com.tencent.mm.plugin.wallet_core.c.d)paramn).ebk());
          setContentViewVisibility(0);
        }
        else
        {
          if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.e))
          {
            paramString = (com.tencent.mm.plugin.wallet_core.c.e)paramn;
            this.AmU = paramString.zVW.token;
            this.dcE = paramString.zVW.CoC;
            com.tencent.mm.pluginsdk.wallet.e.aCV(paramString.zVW.CoC);
            if (paramString.zVW.CXs != null)
            {
              this.AmY = paramString.zVW.CXs.DWp;
              this.AmZ = paramString.zVW.CXs.DWq;
            }
            setResult(-1);
            a(paramString.zVW.CXs);
            paramString = paramString.zVW.CXX;
            if ((paramString != null) && (paramString.CMO != null))
            {
              paramn = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
              if ((paramString.Evk == 1) && (paramString.Evl == 1) && (paramn.ctT()) && (paramn.ctS()) && (!paramn.ctO()))
              {
                com.tencent.mm.sdk.platformtools.ad.i("Micromsg.WalletCheckPwdUI", "can use touch pay");
                this.dmz = 1;
                if (paramString.CMO != null) {
                  com.tencent.mm.plugin.fingerprint.b.p.rcp.rcj = paramString.CMO.eBA();
                }
                paramn = com.tencent.mm.plugin.fingerprint.b.p.rcp;
                if (paramString.CMP != 1) {
                  break label499;
                }
              }
            }
            label499:
            for (boolean bool = true;; bool = false)
            {
              paramn.rcr = bool;
              eea();
              this.ibI.setVisibility(0);
              edY();
              setContentViewVisibility(0);
              break;
            }
          }
          if ((paramn instanceof x))
          {
            paramString = (x)paramn;
            if (paramString.ebl())
            {
              com.tencent.mm.sdk.platformtools.ad.i("Micromsg.WalletCheckPwdUI", "need free sms");
              paramn = new Bundle();
              paramn.putString("key_pwd1", this.itM);
              paramn.putString("key_jsapi_token", this.AmU);
              paramn.putString("key_relation_key", paramString.zWx);
              paramn.putString("key_mobile", paramString.zWw);
              this.Anb = new WalletCheckPwdUI.8(this);
              com.tencent.mm.wallet_core.a.a(this, p.class, paramn, this.Anb);
            }
            else
            {
              paramString = new Intent();
              paramString.putExtra("token", ((x)paramn).zWu);
              setResult(-1, paramString);
              Rm(-1);
              finish();
            }
          }
        }
      }
    }
    if (this.swk != null) {
      this.swk.dga();
    }
    if (((paramn instanceof com.tencent.mm.plugin.wallet_core.c.d)) || ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.e)))
    {
      com.tencent.mm.sdk.platformtools.ad.i("Micromsg.WalletCheckPwdUI", "check jsapi fail");
      paramString = com.tencent.mm.wallet_core.a.bo(this);
      if ((paramString != null) && (paramString.cuB().equals("UnbindProcess")))
      {
        setResult(1);
        paramString.dow.putInt("key_process_result_code", 1);
        com.tencent.mm.wallet_core.a.k(this, paramString.dow);
      }
      for (;;)
      {
        AppMethodBeat.o(70915);
        return true;
        setResult(0);
        Rm(0);
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