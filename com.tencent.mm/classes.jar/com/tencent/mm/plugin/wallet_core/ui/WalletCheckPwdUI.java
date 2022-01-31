package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.ll;
import com.tencent.mm.h.a.nk;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.c.bds;
import com.tencent.mm.protocal.c.byi;
import com.tencent.mm.protocal.c.pl;
import com.tencent.mm.protocal.c.pz;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

@com.tencent.mm.ui.base.a(3)
public class WalletCheckPwdUI
  extends WalletBaseUI
{
  private String bMX;
  private int bPD = 0;
  private TextView eXw;
  private String foR;
  private ScrollView gqx;
  public EditHintPasswdView llh;
  private boolean qCW = false;
  private LinearLayout qCX;
  private ImageView qCY;
  private TextView qCZ;
  private TextView qDa;
  private TextView qDb;
  private boolean qDc = false;
  private boolean qDd = false;
  private String qDe;
  private int qDf = 0;
  private int qDg;
  private String qDh;
  private String qDi;
  private Animation qDj;
  
  private void a(bds parambds)
  {
    if ((parambds != null) && (!bk.bl(parambds.title))) {
      this.qDa.setText(parambds.title);
    }
    if ((parambds != null) && (!bk.bl(parambds.tza))) {
      this.qDb.setText(parambds.tza);
    }
    bWB();
  }
  
  private void bWA()
  {
    com.tencent.mm.sdk.platformtools.y.i("Micromsg.WalletCheckPwdUI", "change mode: %s", new Object[] { Integer.valueOf(this.bPD) });
    if (this.bPD == 1)
    {
      this.qCX.setVisibility(0);
      this.llh.setVisibility(8);
      this.eXw.setText(a.i.wallet_check_mode_pwd);
      VH();
      if (!bk.bl(this.qDi))
      {
        this.qDb.setText(this.qDi);
        return;
      }
      this.qDb.setText(a.i.wallet_check_pwd_main_content_fp);
      return;
    }
    this.qCX.setVisibility(8);
    this.llh.bvr();
    this.llh.setVisibility(0);
    this.eXw.setText(a.i.wallet_check_mode_fp);
    cNi();
    if (!bk.bl(this.qDh))
    {
      this.qDb.setText(this.qDh);
      return;
    }
    this.qDb.setText(a.i.wallet_check_pwd_main_content);
  }
  
  private void bWB()
  {
    c localc = cNj();
    if (localc != null)
    {
      if (!"UnbindProcess".equals(localc.aTh())) {
        break label42;
      }
      this.qDa.setText(a.i.wallet_index_ui_unbind_bankcard_title);
      this.qDb.setText(a.i.wallet_check_pwd_tip);
    }
    label42:
    do
    {
      return;
      if ((localc instanceof com.tencent.mm.plugin.wallet_core.b.b))
      {
        this.qDa.setText(a.i.wallet_index_ui_bind_card_pref);
        this.qDb.setText(a.i.wallet_check_pwd_tip);
        return;
      }
      if ("ModifyPwdProcess".equals(localc.aTh()))
      {
        this.qDa.setText(a.i.wallet_modify_password_title);
        this.qDb.setText(a.i.wallet_check_pwd_tip);
        return;
      }
    } while (!"OfflineProcess".equals(localc.aTh()));
    this.qDa.setText(a.i.wallet_check_pwd_open_offline);
    this.qDb.setText(a.i.wallet_check_pwd_tip);
  }
  
  private void bWC()
  {
    com.tencent.mm.plugin.soter.d.a.bKP();
    ll localll = new ll();
    localll.bUv.bOT = this.bMX;
    localll.bUv.bUx = 1;
    localll.bUv.bUz = new WalletCheckPwdUI.7(this, localll);
    com.tencent.mm.sdk.b.a.udP.a(localll, Looper.getMainLooper());
  }
  
  private static void bWD()
  {
    com.tencent.mm.sdk.platformtools.y.i("Micromsg.WalletCheckPwdUI", "hy: send release FPManager");
    nk localnk = new nk();
    com.tencent.mm.sdk.b.a.udP.m(localnk);
  }
  
  public final boolean aSk()
  {
    return this.qCW;
  }
  
  public boolean bTZ()
  {
    boolean bool = false;
    if (this.BX.getInt("key_pay_flag", 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  protected final void bfH()
  {
    com.tencent.mm.sdk.platformtools.y.d("Micromsg.WalletCheckPwdUI", "check pwd ");
    this.wCh.bfH();
  }
  
  public boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.d("Micromsg.WalletCheckPwdUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof r))
      {
        paramString = this.BX;
        paramString.putString("key_pwd1", this.llh.getText());
        com.tencent.mm.wallet_core.a.j(this, paramString);
        if (this.llh != null) {
          this.llh.bvr();
        }
        finish();
      }
      label473:
      do
      {
        return true;
        if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.y))
        {
          com.tencent.mm.ui.base.h.bC(this, getString(a.i.wallet_check_pwd_unbind_success_tip));
          paramString = com.tencent.mm.wallet_core.a.aj(this);
          if (paramString != null) {
            paramString.kke.putInt("key_process_result_code", -1);
          }
          com.tencent.mm.wallet_core.a.j(this, paramString.kke);
          if (this.llh != null) {
            this.llh.bvr();
          }
          finish();
          return true;
        }
        if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.a))
        {
          f.Xf(((com.tencent.mm.plugin.wallet_core.c.a)paramm).bUH());
          this.qDe = ((com.tencent.mm.plugin.wallet_core.c.a)paramm).getToken();
          setResult(-1);
          a(((pl)((com.tencent.mm.plugin.wallet_core.c.a)paramm).dmK.ecF.ecN).sNn);
          vN(0);
          return true;
        }
        if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.b))
        {
          paramString = (com.tencent.mm.plugin.wallet_core.c.b)paramm;
          this.qDe = paramString.qqw.token;
          this.bMX = paramString.qqw.sog;
          f.Xf(paramString.qqw.sog);
          if (paramString.qqw.sNn != null)
          {
            this.qDh = paramString.qqw.sNn.tza;
            this.qDi = paramString.qqw.sNn.tzb;
          }
          setResult(-1);
          a(paramString.qqw.sNn);
          paramString = paramString.qqw.sNL;
          if ((paramString != null) && (paramString.sFm != null))
          {
            paramm = (k)com.tencent.mm.kernel.g.r(k.class);
            if ((paramString.tON == 1) && (paramm.aSG()) && (paramm.aSF()) && (!paramm.aSx()))
            {
              com.tencent.mm.sdk.platformtools.y.i("Micromsg.WalletCheckPwdUI", "can use touch pay");
              this.bPD = 1;
              if (paramString.sFm != null) {
                com.tencent.mm.plugin.wallet_core.model.s.qyz.klM = paramString.sFm.coM();
              }
              paramm = com.tencent.mm.plugin.wallet_core.model.s.qyz;
              if (paramString.sFn != 1) {
                break label473;
              }
            }
          }
          for (boolean bool = true;; bool = false)
          {
            paramm.klN = bool;
            bWC();
            this.eXw.setVisibility(0);
            bWA();
            vN(0);
            return true;
          }
        }
      } while (!(paramm instanceof com.tencent.mm.plugin.wallet_core.c.s));
      paramString = (com.tencent.mm.plugin.wallet_core.c.s)paramm;
      if (paramString.bUI())
      {
        com.tencent.mm.sdk.platformtools.y.i("Micromsg.WalletCheckPwdUI", "need free sms");
        paramm = new Bundle();
        paramm.putString("key_pwd1", this.foR);
        paramm.putString("key_jsapi_token", this.qDe);
        paramm.putString("key_relation_key", paramString.qqV);
        paramm.putString("key_mobile", paramString.qqU);
        com.tencent.mm.wallet_core.a.a(this, l.class, paramm, new WalletCheckPwdUI.6(this));
        return true;
      }
      paramString = new Intent();
      paramString.putExtra("token", ((com.tencent.mm.plugin.wallet_core.c.s)paramm).qqS);
      setResult(-1, paramString);
      finish();
      return true;
    }
    if (this.llh != null) {
      this.llh.bvr();
    }
    if (((paramm instanceof com.tencent.mm.plugin.wallet_core.c.a)) || ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.b)))
    {
      com.tencent.mm.sdk.platformtools.y.i("Micromsg.WalletCheckPwdUI", "check jsapi fail");
      paramString = com.tencent.mm.wallet_core.a.aj(this);
      if ((paramString != null) && (paramString.aTh().equals("UnbindProcess")))
      {
        setResult(1);
        paramString.kke.putInt("key_process_result_code", 1);
        com.tencent.mm.wallet_core.a.j(this, paramString.kke);
        return true;
      }
      setResult(0);
      finish();
      return true;
    }
    return false;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_check_pwd;
  }
  
  protected final void initView()
  {
    bk.L(cNl());
    this.llh = ((EditHintPasswdView)findViewById(a.f.input_et));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.llh);
    this.llh.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void gG(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          WalletCheckPwdUI.a(WalletCheckPwdUI.this, WalletCheckPwdUI.this.llh.getText());
          c localc = com.tencent.mm.wallet_core.a.aj(WalletCheckPwdUI.this);
          String str = null;
          if (localc != null) {
            str = localc.aTh();
          }
          if ((!WalletCheckPwdUI.b(WalletCheckPwdUI.this)) || ("UnbindProcess".equals(str))) {
            break label112;
          }
          WalletCheckPwdUI.this.a(new com.tencent.mm.plugin.wallet_core.c.s(WalletCheckPwdUI.c(WalletCheckPwdUI.this), WalletCheckPwdUI.d(WalletCheckPwdUI.this), (byte)0), true, true);
          com.tencent.mm.plugin.report.service.h.nFQ.f(15021, new Object[] { Integer.valueOf(1) });
        }
        label112:
        while (WalletCheckPwdUI.this.cNk().m(new Object[] { WalletCheckPwdUI.c(WalletCheckPwdUI.this), WalletCheckPwdUI.this.bTO() })) {
          return;
        }
        WalletCheckPwdUI.this.a(new r(WalletCheckPwdUI.c(WalletCheckPwdUI.this), 1, WalletCheckPwdUI.this.bTO()), true, true);
      }
    });
    this.gqx = ((ScrollView)findViewById(a.f.wcp_root_view));
    this.qCX = ((LinearLayout)findViewById(a.f.finger_print_layout));
    this.qCY = ((ImageView)findViewById(a.f.finger_print_icon));
    this.qDa = ((TextView)findViewById(a.f.wallet_pwd_title));
    this.qDb = ((TextView)findViewById(a.f.wallet_pwd_content));
    this.qCZ = ((TextView)findViewById(a.f.finger_print_tips));
    this.eXw = ((TextView)findViewById(a.f.wcp_bottom_link_tv));
    this.eXw.setOnClickListener(new WalletCheckPwdUI.4(this));
    this.lTH = new WalletCheckPwdUI.5(this);
    e(this.llh, 0, false);
    cNi();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = -1;
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    czo();
    paramBundle = getIntent();
    Object localObject;
    if ((paramBundle != null) && (getIntent().hasExtra("scene")))
    {
      i = paramBundle.getIntExtra("scene", -1);
      if (i != 1) {
        break label489;
      }
      this.qDc = true;
      com.tencent.mm.sdk.platformtools.y.d("Micromsg.WalletCheckPwdUI", "check pwd jsapi");
      vN(4);
      paramBundle = null;
      if (!this.qDd) {
        break label277;
      }
      localObject = com.tencent.mm.wallet_core.a.aj(this);
      if (localObject != null) {
        paramBundle = ((c)localObject).kke;
      }
      localObject = paramBundle;
      if (paramBundle != null) {
        break label313;
      }
      com.tencent.mm.sdk.platformtools.y.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] process.getContextData null");
      setResult(1);
      finish();
    }
    for (;;)
    {
      initView();
      bWB();
      setBackBtn(new WalletCheckPwdUI.1(this));
      findViewById(a.f.close_button).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          WalletCheckPwdUI.a(WalletCheckPwdUI.this);
        }
      });
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramBundle = getWindow();
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(getResources().getColor(a.c.white));
        if (Build.VERSION.SDK_INT >= 23) {
          paramBundle.getDecorView().setSystemUiVisibility(8192);
        }
      }
      this.mController.contentView.setFitsSystemWindows(true);
      return;
      paramBundle = com.tencent.mm.wallet_core.a.aj(this);
      if (paramBundle == null) {
        break;
      }
      i = paramBundle.kke.getInt("scene", -1);
      if ((i == 1) && ("UnbindProcess".equals(paramBundle.aTh()))) {}
      for (boolean bool = true;; bool = false)
      {
        this.qDd = bool;
        break;
      }
      label277:
      if (getIntent() == null)
      {
        com.tencent.mm.sdk.platformtools.y.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] intent null");
        setResult(0);
        finish();
      }
      else
      {
        localObject = getIntent().getExtras();
        label313:
        paramBundle = ((Bundle)localObject).getString("appId");
        String str1 = ((Bundle)localObject).getString("timeStamp");
        String str2 = ((Bundle)localObject).getString("nonceStr");
        String str3 = ((Bundle)localObject).getString("packageExt");
        String str4 = ((Bundle)localObject).getString("signtype");
        String str5 = ((Bundle)localObject).getString("paySignature");
        String str6 = ((Bundle)localObject).getString("url");
        i = ((Bundle)localObject).getInt("pay_channel", 0);
        if (this.qDd) {
          com.tencent.mm.sdk.platformtools.y.i("Micromsg.WalletCheckPwdUI", "appId is null? " + bk.bl(paramBundle));
        }
        for (paramBundle = new com.tencent.mm.plugin.wallet_core.c.a(paramBundle, str1, str2, str3, str4, str5, str6, 10, "verifyWCPayPassword", i);; paramBundle = new com.tencent.mm.plugin.wallet_core.c.b(paramBundle, str1, str2, str3, str4, str5, str6, "verifyWCPayPassword", i))
        {
          a(paramBundle, true, false);
          break;
        }
        label489:
        vN(0);
        this.BX.getBoolean("key_is_expired_bankcard", false);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bWD();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.lMr != null) && (this.lMr.isShown()))
    {
      this.lMr.setVisibility(8);
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    ki(580);
  }
  
  public void onResume()
  {
    if (this.llh != null) {
      this.llh.bvr();
    }
    kh(580);
    super.onResume();
  }
  
  public final void st(int paramInt)
  {
    if (this.qCW) {
      finish();
    }
    while (this.llh == null) {
      return;
    }
    this.llh.bvr();
  }
  
  public final void vN(int paramInt)
  {
    this.mController.contentView.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI
 * JD-Core Version:    0.7.0.1
 */