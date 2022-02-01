package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.content.res.Resources;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.acu;
import com.tencent.mm.autogen.a.rg;
import com.tencent.mm.autogen.a.rg.b;
import com.tencent.mm.autogen.a.ua;
import com.tencent.mm.plugin.fingerprint.mgr.j;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.ecj;
import com.tencent.mm.protocal.protobuf.fon;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.e.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;
import java.util.HashSet;

@com.tencent.mm.ui.base.a(1)
public class WalletCheckPwdUI
  extends WalletBaseUI
{
  protected EditHintPasswdView JCc;
  private boolean VOI = false;
  private LinearLayout VOJ;
  private ImageView VOK;
  private TextView VOL;
  private TextView VOM;
  private TextView VON;
  private boolean VOO = false;
  private boolean VOP = false;
  private String VOQ;
  private int VOR = 0;
  private int VOS;
  private boolean VOT;
  private String VOU;
  private String VOV;
  private Animation VOW;
  private e.a VOX;
  private String hAT;
  private int hNr = 0;
  private int oQU;
  private TextView pIM;
  private ScrollView pLK;
  private String qdg;
  
  private void a(ecj paramecj)
  {
    AppMethodBeat.i(70912);
    if ((paramecj != null) && (!Util.isNullOrNil(paramecj.title))) {
      this.VOM.setText(paramecj.title);
    }
    if ((paramecj != null) && (!Util.isNullOrNil(paramecj.abhZ))) {
      this.VON.setText(paramecj.abhZ);
    }
    ikK();
    AppMethodBeat.o(70912);
  }
  
  private void arT(int paramInt)
  {
    AppMethodBeat.i(70921);
    if (getIntent().getBooleanExtra("from_kinda", false))
    {
      acu localacu = new acu();
      localacu.igi.result = paramInt;
      localacu.publish();
    }
    AppMethodBeat.o(70921);
  }
  
  private void ikJ()
  {
    AppMethodBeat.i(70913);
    Log.i("Micromsg.WalletCheckPwdUI", "change mode: %s", new Object[] { Integer.valueOf(this.hNr) });
    if (this.hNr == 1)
    {
      this.VOJ.setVisibility(0);
      this.JCc.setVisibility(8);
      this.pIM.setText(a.i.wallet_check_mode_pwd);
      this.VOJ.postDelayed(new WalletCheckPwdUI.5(this), 300L);
      if (!Util.isNullOrNil(this.VOV))
      {
        this.VON.setText(this.VOV);
        AppMethodBeat.o(70913);
        return;
      }
      this.VON.setText(a.i.wallet_check_pwd_main_content_fp);
      AppMethodBeat.o(70913);
      return;
    }
    this.VOJ.setVisibility(8);
    this.JCc.gGd();
    this.JCc.setVisibility(0);
    this.pIM.setText(a.i.wallet_check_mode_fp);
    showTenpayKB();
    if (!Util.isNullOrNil(this.VOU))
    {
      this.VON.setText(this.VOU);
      AppMethodBeat.o(70913);
      return;
    }
    this.VON.setText(a.i.wallet_check_pwd_tip);
    AppMethodBeat.o(70913);
  }
  
  private void ikK()
  {
    AppMethodBeat.i(70914);
    Object localObject = getProcess();
    if (localObject != null)
    {
      this.VOU = getString(a.i.wallet_check_pwd_tip);
      if ("UnbindProcess".equals(((com.tencent.mm.wallet_core.e)localObject).fud()))
      {
        localObject = ((com.tencent.mm.wallet_core.e)localObject).hPH.getString("key_check_pwd_title");
        if (!Util.isNullOrNil((String)localObject)) {
          this.VOM.setText((CharSequence)localObject);
        }
        for (;;)
        {
          this.VON.setText(this.VOU);
          AppMethodBeat.o(70914);
          return;
          this.VOM.setText(a.i.wallet_index_ui_unbind_bankcard_title);
        }
      }
      if ((localObject instanceof com.tencent.mm.plugin.wallet_core.b.b))
      {
        this.VOM.setText(a.i.wallet_index_ui_bind_card_pref);
        this.VON.setText(this.VOU);
        AppMethodBeat.o(70914);
        return;
      }
      if ("ModifyPwdProcess".equals(((com.tencent.mm.wallet_core.e)localObject).fud()))
      {
        this.VOM.setText(a.i.wallet_modify_password_title);
        this.VON.setText(this.VOU);
        AppMethodBeat.o(70914);
        return;
      }
      if ("OfflineProcess".equals(((com.tencent.mm.wallet_core.e)localObject).fud()))
      {
        this.VOM.setText(a.i.wallet_check_pwd_open_offline);
        this.VON.setText(this.VOU);
      }
    }
    AppMethodBeat.o(70914);
  }
  
  private void ikL()
  {
    AppMethodBeat.i(70919);
    this.VOT = true;
    com.tencent.mm.plugin.soter.model.a.htx();
    final rg localrg = new rg();
    localrg.hUl.hMy = this.hAT;
    localrg.hUl.hUn = 1;
    localrg.hUl.hUp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(70902);
        Log.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback");
        rg.b localb = localrg.hUm;
        if (localb == null)
        {
          Log.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, result == null");
          AppMethodBeat.o(70902);
          return;
        }
        int i = localb.errCode;
        Log.v("Micromsg.WalletCheckPwdUI", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), localb.errMsg });
        if (i == 0)
        {
          Log.i("Micromsg.WalletCheckPwdUI", "hy: payInfo soterAuthReq: %s", new Object[] { localb.hUq });
          WalletCheckPwdUI.i(WalletCheckPwdUI.this).setVisibility(8);
          WalletCheckPwdUI.b(WalletCheckPwdUI.this, localb.hUq);
          com.tencent.mm.plugin.soter.model.a.amP(0);
          AppMethodBeat.o(70902);
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
          if (localb.hUr != 2) {
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
            WalletCheckPwdUI.a(WalletCheckPwdUI.this, com.tencent.mm.ui.anim.a.jV(WalletCheckPwdUI.this.getContext()));
          }
          WalletCheckPwdUI.i(WalletCheckPwdUI.this).setVisibility(0);
          WalletCheckPwdUI.i(WalletCheckPwdUI.this).startAnimation(WalletCheckPwdUI.m(WalletCheckPwdUI.this));
          WalletCheckPwdUI.m(WalletCheckPwdUI.this).setFillAfter(true);
          com.tencent.mm.plugin.soter.model.a.amP(1);
          AppMethodBeat.o(70902);
          return;
          bool1 = false;
          break;
        }
        label372:
        if ((WalletCheckPwdUI.l(WalletCheckPwdUI.this) >= 3) || (bool1))
        {
          Log.v("Micromsg.WalletCheckPwdUI", "alvinluo change to pwd pay");
          WalletCheckPwdUI.ikN();
          WalletCheckPwdUI.a(WalletCheckPwdUI.this, 0);
          WalletCheckPwdUI.g(WalletCheckPwdUI.this);
          WalletCheckPwdUI.n(WalletCheckPwdUI.this).setVisibility(8);
          com.tencent.mm.plugin.soter.model.a.amP(2);
        }
        AppMethodBeat.o(70902);
      }
    };
    localrg.asyncPublish(Looper.getMainLooper());
    AppMethodBeat.o(70919);
  }
  
  private static void ikM()
  {
    AppMethodBeat.i(70920);
    Log.i("Micromsg.WalletCheckPwdUI", "hy: send release FPManager");
    new ua().publish();
    AppMethodBeat.o(70920);
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(70918);
    if (this.VOI)
    {
      finish();
      AppMethodBeat.o(70918);
      return;
    }
    if (this.JCc != null) {
      this.JCc.gGd();
    }
    AppMethodBeat.o(70918);
  }
  
  public void finish()
  {
    AppMethodBeat.i(301277);
    super.finish();
    if (this.oQU == 0) {
      overridePendingTransition(0, a.a.sight_slide_bottom_out);
    }
    AppMethodBeat.o(301277);
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
    return a.g.wallet_check_pwd;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70911);
    this.JCc = ((EditHintPasswdView)findViewById(a.f.input_et));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.JCc);
    this.JCc.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(301286);
        if (paramAnonymousBoolean)
        {
          WalletCheckPwdUI.a(WalletCheckPwdUI.this, WalletCheckPwdUI.this.JCc.getText());
          com.tencent.mm.wallet_core.e locale = com.tencent.mm.wallet_core.a.cm(WalletCheckPwdUI.this);
          String str = null;
          if (locale != null) {
            str = locale.fud();
          }
          if ((WalletCheckPwdUI.b(WalletCheckPwdUI.this)) && (!"UnbindProcess".equals(str)))
          {
            WalletCheckPwdUI.this.doSceneProgress(new y(WalletCheckPwdUI.c(WalletCheckPwdUI.this), WalletCheckPwdUI.d(WalletCheckPwdUI.this), (byte)0));
            com.tencent.mm.plugin.report.service.h.OAn.b(15021, new Object[] { Integer.valueOf(1) });
            AppMethodBeat.o(301286);
            return;
          }
          if (!WalletCheckPwdUI.this.getNetController().t(new Object[] { WalletCheckPwdUI.c(WalletCheckPwdUI.this), WalletCheckPwdUI.this.getPayReqKey() })) {
            WalletCheckPwdUI.this.doSceneProgress(new x(WalletCheckPwdUI.c(WalletCheckPwdUI.this), 1, WalletCheckPwdUI.this.getPayReqKey()));
          }
        }
        AppMethodBeat.o(301286);
      }
    });
    this.pLK = ((ScrollView)findViewById(a.f.wcp_root_view));
    this.VOJ = ((LinearLayout)findViewById(a.f.finger_print_layout));
    this.VOK = ((ImageView)findViewById(a.f.finger_print_icon));
    this.VOM = ((TextView)findViewById(a.f.wallet_pwd_title));
    this.VON = ((TextView)findViewById(a.f.wallet_pwd_content));
    this.VOL = ((TextView)findViewById(a.f.finger_print_tips));
    this.pIM = ((TextView)findViewById(a.f.wcp_bottom_link_tv));
    this.pIM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(301287);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCheckPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        WalletCheckPwdUI.ikN();
        if (WalletCheckPwdUI.e(WalletCheckPwdUI.this) == 0)
        {
          WalletCheckPwdUI.a(WalletCheckPwdUI.this, 1);
          WalletCheckPwdUI.f(WalletCheckPwdUI.this);
        }
        for (;;)
        {
          WalletCheckPwdUI.g(WalletCheckPwdUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCheckPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(301287);
          return;
          WalletCheckPwdUI.a(WalletCheckPwdUI.this, 0);
        }
      }
    });
    com.tencent.mm.wallet_core.ui.i.Q(this.VOM);
    setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
    {
      public final void onVisibleStateChange(final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(301285);
        Log.d("Micromsg.WalletCheckPwdUI", "kb visibility: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        WalletCheckPwdUI.h(WalletCheckPwdUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(301325);
            if (paramAnonymousBoolean)
            {
              WalletCheckPwdUI.h(WalletCheckPwdUI.this).fullScroll(130);
              AppMethodBeat.o(301325);
              return;
            }
            WalletCheckPwdUI.h(WalletCheckPwdUI.this).fullScroll(33);
            AppMethodBeat.o(301325);
          }
        });
        AppMethodBeat.o(301285);
      }
    });
    hideKeyboardPushDownBtn();
    setEditFocusListener(this.JCc, 0, false);
    showTenpayKB();
    AppMethodBeat.o(70911);
  }
  
  public boolean isTransparent()
  {
    return this.VOI;
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
    setActionbarColor(getContext().getResources().getColor(a.c.white));
    hideActionbarLine();
    setMMTitle("");
    paramBundle = getIntent();
    this.oQU = paramBundle.getIntExtra("key_anim_type", 0);
    label99:
    Object localObject;
    if (this.oQU == 0)
    {
      overridePendingTransition(a.a.sight_slide_bottom_in, 0);
      if ((paramBundle == null) || (!getIntent().hasExtra("scene"))) {
        break label234;
      }
      i = paramBundle.getIntExtra("scene", -1);
      if (i != 1) {
        break label503;
      }
      this.VOO = true;
      Log.d("Micromsg.WalletCheckPwdUI", "check pwd jsapi");
      setContentViewVisibility(4);
      paramBundle = null;
      if (!this.VOP) {
        break label288;
      }
      localObject = com.tencent.mm.wallet_core.a.cm(this);
      if (localObject != null) {
        paramBundle = ((com.tencent.mm.wallet_core.e)localObject).hPH;
      }
      localObject = paramBundle;
      if (paramBundle != null) {
        break label329;
      }
      Log.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] process.getContextData null");
      setResult(1);
      arT(1);
      finish();
    }
    for (;;)
    {
      initView();
      ikK();
      setBackBtn(new WalletCheckPwdUI.1(this), a.h.actionbar_icon_close_black);
      if (com.tencent.mm.wallet_core.ui.i.jPv()) {
        getWindow().addFlags(8192);
      }
      AppMethodBeat.o(70906);
      return;
      overridePendingTransition(a.a.slide_right_in, 0);
      break;
      label234:
      paramBundle = com.tencent.mm.wallet_core.a.cm(this);
      if (paramBundle == null) {
        break label99;
      }
      i = paramBundle.hPH.getInt("scene", -1);
      if ((i == 1) && ("UnbindProcess".equals(paramBundle.fud()))) {}
      for (boolean bool = true;; bool = false)
      {
        this.VOP = bool;
        break;
      }
      label288:
      if (getIntent() == null)
      {
        Log.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] intent null");
        setResult(0);
        arT(0);
        finish();
      }
      else
      {
        localObject = getIntent().getExtras();
        label329:
        paramBundle = ((Bundle)localObject).getString("appId");
        String str1 = ((Bundle)localObject).getString("timeStamp");
        String str2 = ((Bundle)localObject).getString("nonceStr");
        String str3 = ((Bundle)localObject).getString("packageExt");
        String str4 = ((Bundle)localObject).getString("signtype");
        String str5 = ((Bundle)localObject).getString("paySignature");
        String str6 = ((Bundle)localObject).getString("url");
        i = ((Bundle)localObject).getInt("pay_channel", 0);
        if (this.VOP) {
          Log.i("Micromsg.WalletCheckPwdUI", "appId is null? " + Util.isNullOrNil(paramBundle));
        }
        for (paramBundle = new d(paramBundle, str1, str2, str3, str4, str5, str6, 10, "verifyWCPayPassword", i);; paramBundle = new com.tencent.mm.plugin.wallet_core.c.e(paramBundle, str1, str2, str3, str4, str5, str6, "verifyWCPayPassword", i))
        {
          doSceneForceProgress(paramBundle);
          break;
        }
        label503:
        setContentViewVisibility(0);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(70910);
    super.onDestroy();
    if (this.VOT) {
      ikM();
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
    this.hNr = 0;
    ikJ();
    ikM();
    removeSceneEndListener(580);
    AppMethodBeat.o(70909);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70908);
    if (this.JCc != null) {
      this.JCc.gGd();
    }
    addSceneEndListener(580);
    super.onResume();
    AppMethodBeat.o(70908);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(70915);
    Log.d("Micromsg.WalletCheckPwdUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof x))
      {
        paramString = getInput();
        paramString.putString("key_pwd1", this.JCc.getText());
        paramString.putString("key_bind_card_user_token", ((x)paramp).token);
        com.tencent.mm.wallet_core.a.k(this, paramString);
        if (this.JCc != null) {
          this.JCc.gGd();
        }
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(70915);
        return true;
        if ((paramp instanceof ae))
        {
          k.cZ(this, getString(a.i.wallet_check_pwd_unbind_success_tip));
          paramString = com.tencent.mm.wallet_core.a.cm(this);
          if (paramString != null) {
            paramString.hPH.putInt("key_process_result_code", -1);
          }
          com.tencent.mm.wallet_core.a.k(this, paramString.hPH);
          if (this.JCc != null) {
            this.JCc.gGd();
          }
          finish();
        }
        else if ((paramp instanceof d))
        {
          com.tencent.mm.pluginsdk.wallet.e.brZ(((d)paramp).ihJ());
          this.VOQ = ((d)paramp).getToken();
          setResult(-1);
          a(((d)paramp).ihK());
          setContentViewVisibility(0);
        }
        else
        {
          if ((paramp instanceof com.tencent.mm.plugin.wallet_core.c.e))
          {
            paramString = (com.tencent.mm.plugin.wallet_core.c.e)paramp;
            this.VOQ = paramString.Vxx.token;
            this.hAT = paramString.Vxx.YvQ;
            com.tencent.mm.pluginsdk.wallet.e.brZ(paramString.Vxx.YvQ);
            if (paramString.Vxx.ZjQ != null)
            {
              this.VOU = paramString.Vxx.ZjQ.abhZ;
              this.VOV = paramString.Vxx.ZjQ.abia;
            }
            setResult(-1);
            a(paramString.Vxx.ZjQ);
            paramString = paramString.Vxx.ZkC;
            if ((paramString != null) && (paramString.YXN != null))
            {
              paramp = (com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class);
              if ((paramString.abOX == 1) && (paramString.abOY == 1) && (paramp.ftw()) && (paramp.ftv()) && (!paramp.ftr()))
              {
                Log.i("Micromsg.WalletCheckPwdUI", "can use touch pay");
                this.hNr = 1;
                if (paramString.YXN != null) {
                  j.Hgj.Hgd = paramString.YXN.ZV();
                }
                paramp = j.Hgj;
                if (paramString.YXO != 1) {
                  break label512;
                }
              }
            }
            label512:
            for (boolean bool = true;; bool = false)
            {
              paramp.Hgl = bool;
              ikL();
              this.pIM.setVisibility(0);
              ikJ();
              setContentViewVisibility(0);
              ((com.tencent.mm.plugin.wallet_core.utils.i)component(com.tencent.mm.plugin.wallet_core.utils.i.class)).imc();
              break;
            }
          }
          if ((paramp instanceof y))
          {
            paramString = (y)paramp;
            if (paramString.ihL())
            {
              Log.i("Micromsg.WalletCheckPwdUI", "need free sms");
              paramp = new Bundle();
              paramp.putString("key_pwd1", this.qdg);
              paramp.putString("key_jsapi_token", this.VOQ);
              paramp.putString("key_relation_key", paramString.VxY);
              paramp.putString("key_mobile", paramString.VxX);
              this.VOX = new WalletCheckPwdUI.6(this);
              com.tencent.mm.wallet_core.a.a(this, r.class, paramp, this.VOX);
            }
            else
            {
              paramString = new Intent();
              paramString.putExtra("token", ((y)paramp).Vww);
              setResult(-1, paramString);
              arT(-1);
              finish();
            }
          }
        }
      }
    }
    if (this.JCc != null) {
      this.JCc.gGd();
    }
    if (((paramp instanceof d)) || ((paramp instanceof com.tencent.mm.plugin.wallet_core.c.e)))
    {
      Log.i("Micromsg.WalletCheckPwdUI", "check jsapi fail");
      paramString = com.tencent.mm.wallet_core.a.cm(this);
      if ((paramString != null) && (paramString.fud().equals("UnbindProcess")))
      {
        setResult(1);
        paramString.hPH.putInt("key_process_result_code", 1);
        com.tencent.mm.wallet_core.a.k(this, paramString.hPH);
      }
      for (;;)
      {
        AppMethodBeat.o(70915);
        return true;
        setResult(0);
        arT(0);
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(301280);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.wallet_core.utils.i.class);
    AppMethodBeat.o(301280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI
 * JD-Core Version:    0.7.0.1
 */