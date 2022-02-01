package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
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
import com.tencent.mm.f.a.aax;
import com.tencent.mm.f.a.pt;
import com.tencent.mm.f.a.pt.b;
import com.tencent.mm.f.a.sl;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.aab;
import com.tencent.mm.protocal.protobuf.djz;
import com.tencent.mm.protocal.protobuf.etc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

@com.tencent.mm.ui.base.a(1)
public class WalletCheckPwdUI
  extends WalletBaseUI
{
  protected EditHintPasswdView DLa;
  private boolean OYA = false;
  private boolean OYB = false;
  private String OYC;
  private int OYD = 0;
  private int OYE;
  private boolean OYF;
  private String OYG;
  private String OYH;
  private Animation OYI;
  private d.a OYJ;
  private boolean OYu = false;
  private LinearLayout OYv;
  private ImageView OYw;
  private TextView OYx;
  private TextView OYy;
  private TextView OYz;
  private int fHR = 0;
  private String fwv;
  private int lXQ;
  private TextView mMe;
  private ScrollView mPe;
  private String nfX;
  
  private void a(djz paramdjz)
  {
    AppMethodBeat.i(70912);
    if ((paramdjz != null) && (!Util.isNullOrNil(paramdjz.title))) {
      this.OYy.setText(paramdjz.title);
    }
    if ((paramdjz != null) && (!Util.isNullOrNil(paramdjz.TRA))) {
      this.OYz.setText(paramdjz.TRA);
    }
    gLt();
    AppMethodBeat.o(70912);
  }
  
  private void amj(int paramInt)
  {
    AppMethodBeat.i(70921);
    if (getIntent().getBooleanExtra("from_kinda", false))
    {
      aax localaax = new aax();
      localaax.gaa.result = paramInt;
      EventCenter.instance.publish(localaax);
    }
    AppMethodBeat.o(70921);
  }
  
  private void gLs()
  {
    AppMethodBeat.i(70913);
    Log.i("Micromsg.WalletCheckPwdUI", "change mode: %s", new Object[] { Integer.valueOf(this.fHR) });
    if (this.fHR == 1)
    {
      this.OYv.setVisibility(0);
      this.DLa.setVisibility(8);
      this.mMe.setText(a.i.wallet_check_mode_pwd);
      this.OYv.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(267370);
          WalletCheckPwdUI.this.hideTenpayKB();
          AppMethodBeat.o(267370);
        }
      }, 300L);
      if (!Util.isNullOrNil(this.OYH))
      {
        this.OYz.setText(this.OYH);
        AppMethodBeat.o(70913);
        return;
      }
      this.OYz.setText(a.i.wallet_check_pwd_main_content_fp);
      AppMethodBeat.o(70913);
      return;
    }
    this.OYv.setVisibility(8);
    this.DLa.fuo();
    this.DLa.setVisibility(0);
    this.mMe.setText(a.i.wallet_check_mode_fp);
    showTenpayKB();
    if (!Util.isNullOrNil(this.OYG))
    {
      this.OYz.setText(this.OYG);
      AppMethodBeat.o(70913);
      return;
    }
    this.OYz.setText(a.i.wallet_check_pwd_tip);
    AppMethodBeat.o(70913);
  }
  
  private void gLt()
  {
    AppMethodBeat.i(70914);
    Object localObject = getProcess();
    if (localObject != null)
    {
      this.OYG = getString(a.i.wallet_check_pwd_tip);
      if ("UnbindProcess".equals(((com.tencent.mm.wallet_core.d)localObject).epb()))
      {
        localObject = ((com.tencent.mm.wallet_core.d)localObject).fKb.getString("key_check_pwd_title");
        if (!Util.isNullOrNil((String)localObject)) {
          this.OYy.setText((CharSequence)localObject);
        }
        for (;;)
        {
          this.OYz.setText(this.OYG);
          AppMethodBeat.o(70914);
          return;
          this.OYy.setText(a.i.wallet_index_ui_unbind_bankcard_title);
        }
      }
      if ((localObject instanceof com.tencent.mm.plugin.wallet_core.b.b))
      {
        this.OYy.setText(a.i.wallet_index_ui_bind_card_pref);
        this.OYz.setText(this.OYG);
        AppMethodBeat.o(70914);
        return;
      }
      if ("ModifyPwdProcess".equals(((com.tencent.mm.wallet_core.d)localObject).epb()))
      {
        this.OYy.setText(a.i.wallet_modify_password_title);
        this.OYz.setText(this.OYG);
        AppMethodBeat.o(70914);
        return;
      }
      if ("OfflineProcess".equals(((com.tencent.mm.wallet_core.d)localObject).epb()))
      {
        this.OYy.setText(a.i.wallet_check_pwd_open_offline);
        this.OYz.setText(this.OYG);
      }
    }
    AppMethodBeat.o(70914);
  }
  
  private void gLu()
  {
    AppMethodBeat.i(70919);
    this.OYF = true;
    com.tencent.mm.plugin.soter.d.a.gag();
    final pt localpt = new pt();
    localpt.fOs.fHb = this.fwv;
    localpt.fOs.fOu = 1;
    localpt.fOs.fOw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(70902);
        Log.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback");
        pt.b localb = localpt.fOt;
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
          Log.i("Micromsg.WalletCheckPwdUI", "hy: payInfo soterAuthReq: %s", new Object[] { localb.fOx });
          WalletCheckPwdUI.i(WalletCheckPwdUI.this).setVisibility(8);
          WalletCheckPwdUI.b(WalletCheckPwdUI.this, localb.fOx);
          com.tencent.mm.plugin.soter.d.a.ahO(0);
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
          if (localb.fOy != 2) {
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
            WalletCheckPwdUI.a(WalletCheckPwdUI.this, com.tencent.mm.ui.c.a.jdMethod_if(WalletCheckPwdUI.this.getContext()));
          }
          WalletCheckPwdUI.i(WalletCheckPwdUI.this).setVisibility(0);
          WalletCheckPwdUI.i(WalletCheckPwdUI.this).startAnimation(WalletCheckPwdUI.m(WalletCheckPwdUI.this));
          WalletCheckPwdUI.m(WalletCheckPwdUI.this).setFillAfter(true);
          com.tencent.mm.plugin.soter.d.a.ahO(1);
          AppMethodBeat.o(70902);
          return;
          bool1 = false;
          break;
        }
        label372:
        if ((WalletCheckPwdUI.l(WalletCheckPwdUI.this) >= 3) || (bool1))
        {
          Log.v("Micromsg.WalletCheckPwdUI", "alvinluo change to pwd pay");
          WalletCheckPwdUI.gLw();
          WalletCheckPwdUI.a(WalletCheckPwdUI.this, 0);
          WalletCheckPwdUI.g(WalletCheckPwdUI.this);
          WalletCheckPwdUI.n(WalletCheckPwdUI.this).setVisibility(8);
          com.tencent.mm.plugin.soter.d.a.ahO(2);
        }
        AppMethodBeat.o(70902);
      }
    };
    EventCenter.instance.asyncPublish(localpt, Looper.getMainLooper());
    AppMethodBeat.o(70919);
  }
  
  private static void gLv()
  {
    AppMethodBeat.i(70920);
    Log.i("Micromsg.WalletCheckPwdUI", "hy: send release FPManager");
    sl localsl = new sl();
    EventCenter.instance.publish(localsl);
    AppMethodBeat.o(70920);
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(70918);
    if (this.OYu)
    {
      finish();
      AppMethodBeat.o(70918);
      return;
    }
    if (this.DLa != null) {
      this.DLa.fuo();
    }
    AppMethodBeat.o(70918);
  }
  
  public void finish()
  {
    AppMethodBeat.i(214604);
    super.finish();
    if (this.lXQ == 0) {
      overridePendingTransition(0, a.a.sight_slide_bottom_out);
    }
    AppMethodBeat.o(214604);
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
    this.DLa = ((EditHintPasswdView)findViewById(a.f.input_et));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.DLa);
    this.DLa.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(250793);
        if (paramAnonymousBoolean)
        {
          WalletCheckPwdUI.a(WalletCheckPwdUI.this, WalletCheckPwdUI.this.DLa.getText());
          com.tencent.mm.wallet_core.d locald = com.tencent.mm.wallet_core.a.bF(WalletCheckPwdUI.this);
          String str = null;
          if (locald != null) {
            str = locald.epb();
          }
          if ((WalletCheckPwdUI.b(WalletCheckPwdUI.this)) && (!"UnbindProcess".equals(str)))
          {
            WalletCheckPwdUI.this.doSceneProgress(new y(WalletCheckPwdUI.c(WalletCheckPwdUI.this), WalletCheckPwdUI.d(WalletCheckPwdUI.this), (byte)0));
            com.tencent.mm.plugin.report.service.h.IzE.a(15021, new Object[] { Integer.valueOf(1) });
            AppMethodBeat.o(250793);
            return;
          }
          if (!WalletCheckPwdUI.this.getNetController().r(new Object[] { WalletCheckPwdUI.c(WalletCheckPwdUI.this), WalletCheckPwdUI.this.getPayReqKey() })) {
            WalletCheckPwdUI.this.doSceneProgress(new x(WalletCheckPwdUI.c(WalletCheckPwdUI.this), 1, WalletCheckPwdUI.this.getPayReqKey()));
          }
        }
        AppMethodBeat.o(250793);
      }
    });
    this.mPe = ((ScrollView)findViewById(a.f.wcp_root_view));
    this.OYv = ((LinearLayout)findViewById(a.f.finger_print_layout));
    this.OYw = ((ImageView)findViewById(a.f.finger_print_icon));
    this.OYy = ((TextView)findViewById(a.f.wallet_pwd_title));
    this.OYz = ((TextView)findViewById(a.f.wallet_pwd_content));
    this.OYx = ((TextView)findViewById(a.f.finger_print_tips));
    this.mMe = ((TextView)findViewById(a.f.wcp_bottom_link_tv));
    this.mMe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(195545);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCheckPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletCheckPwdUI.gLw();
        if (WalletCheckPwdUI.e(WalletCheckPwdUI.this) == 0)
        {
          WalletCheckPwdUI.a(WalletCheckPwdUI.this, 1);
          WalletCheckPwdUI.f(WalletCheckPwdUI.this);
        }
        for (;;)
        {
          WalletCheckPwdUI.g(WalletCheckPwdUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCheckPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(195545);
          return;
          WalletCheckPwdUI.a(WalletCheckPwdUI.this, 0);
        }
      }
    });
    com.tencent.mm.wallet_core.ui.g.N(this.OYy);
    this.OYy.setTextSize(1, 22.0F);
    this.OYz.setTextSize(1, 17.0F);
    setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
    {
      public final void onVisibleStateChange(final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(242586);
        Log.d("Micromsg.WalletCheckPwdUI", "kb visibility: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        WalletCheckPwdUI.h(WalletCheckPwdUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(271577);
            if (paramAnonymousBoolean)
            {
              WalletCheckPwdUI.h(WalletCheckPwdUI.this).fullScroll(130);
              AppMethodBeat.o(271577);
              return;
            }
            WalletCheckPwdUI.h(WalletCheckPwdUI.this).fullScroll(33);
            AppMethodBeat.o(271577);
          }
        });
        AppMethodBeat.o(242586);
      }
    });
    hideKeyboardPushDownBtn();
    setEditFocusListener(this.DLa, 0, false);
    showTenpayKB();
    AppMethodBeat.o(70911);
  }
  
  public boolean isTransparent()
  {
    return this.OYu;
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
    this.lXQ = paramBundle.getIntExtra("key_anim_type", 0);
    label99:
    Object localObject;
    if (this.lXQ == 0)
    {
      overridePendingTransition(a.a.sight_slide_bottom_in, 0);
      if ((paramBundle == null) || (!getIntent().hasExtra("scene"))) {
        break label234;
      }
      i = paramBundle.getIntExtra("scene", -1);
      if (i != 1) {
        break label503;
      }
      this.OYA = true;
      Log.d("Micromsg.WalletCheckPwdUI", "check pwd jsapi");
      setContentViewVisibility(4);
      paramBundle = null;
      if (!this.OYB) {
        break label288;
      }
      localObject = com.tencent.mm.wallet_core.a.bF(this);
      if (localObject != null) {
        paramBundle = ((com.tencent.mm.wallet_core.d)localObject).fKb;
      }
      localObject = paramBundle;
      if (paramBundle != null) {
        break label329;
      }
      Log.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] process.getContextData null");
      setResult(1);
      amj(1);
      finish();
    }
    for (;;)
    {
      initView();
      gLt();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(70895);
          WalletCheckPwdUI.a(WalletCheckPwdUI.this);
          AppMethodBeat.o(70895);
          return false;
        }
      }, a.h.actionbar_icon_close_black);
      if (com.tencent.mm.wallet_core.ui.g.ijx()) {
        getWindow().addFlags(8192);
      }
      AppMethodBeat.o(70906);
      return;
      overridePendingTransition(a.a.slide_right_in, 0);
      break;
      label234:
      paramBundle = com.tencent.mm.wallet_core.a.bF(this);
      if (paramBundle == null) {
        break label99;
      }
      i = paramBundle.fKb.getInt("scene", -1);
      if ((i == 1) && ("UnbindProcess".equals(paramBundle.epb()))) {}
      for (boolean bool = true;; bool = false)
      {
        this.OYB = bool;
        break;
      }
      label288:
      if (getIntent() == null)
      {
        Log.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] intent null");
        setResult(0);
        amj(0);
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
        if (this.OYB) {
          Log.i("Micromsg.WalletCheckPwdUI", "appId is null? " + Util.isNullOrNil(paramBundle));
        }
        for (paramBundle = new com.tencent.mm.plugin.wallet_core.c.d(paramBundle, str1, str2, str3, str4, str5, str6, 10, "verifyWCPayPassword", i);; paramBundle = new com.tencent.mm.plugin.wallet_core.c.e(paramBundle, str1, str2, str3, str4, str5, str6, "verifyWCPayPassword", i))
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
    if (this.OYF) {
      gLv();
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
    this.fHR = 0;
    gLs();
    gLv();
    removeSceneEndListener(580);
    AppMethodBeat.o(70909);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70908);
    if (this.DLa != null) {
      this.DLa.fuo();
    }
    addSceneEndListener(580);
    super.onResume();
    AppMethodBeat.o(70908);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(70915);
    Log.d("Micromsg.WalletCheckPwdUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof x))
      {
        paramString = getInput();
        paramString.putString("key_pwd1", this.DLa.getText());
        paramString.putString("key_bind_card_user_token", ((x)paramq).token);
        com.tencent.mm.wallet_core.a.l(this, paramString);
        if (this.DLa != null) {
          this.DLa.fuo();
        }
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(70915);
        return true;
        if ((paramq instanceof ae))
        {
          com.tencent.mm.ui.base.h.cO(this, getString(a.i.wallet_check_pwd_unbind_success_tip));
          paramString = com.tencent.mm.wallet_core.a.bF(this);
          if (paramString != null) {
            paramString.fKb.putInt("key_process_result_code", -1);
          }
          com.tencent.mm.wallet_core.a.l(this, paramString.fKb);
          if (this.DLa != null) {
            this.DLa.fuo();
          }
          finish();
        }
        else if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.d))
        {
          com.tencent.mm.pluginsdk.wallet.e.bsi(((com.tencent.mm.plugin.wallet_core.c.d)paramq).gIv());
          this.OYC = ((com.tencent.mm.plugin.wallet_core.c.d)paramq).getToken();
          setResult(-1);
          a(((com.tencent.mm.plugin.wallet_core.c.d)paramq).gIw());
          setContentViewVisibility(0);
        }
        else
        {
          if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.e))
          {
            paramString = (com.tencent.mm.plugin.wallet_core.c.e)paramq;
            this.OYC = paramString.OHL.token;
            this.fwv = paramString.OHL.Rzs;
            com.tencent.mm.pluginsdk.wallet.e.bsi(paramString.OHL.Rzs);
            if (paramString.OHL.SlG != null)
            {
              this.OYG = paramString.OHL.SlG.TRA;
              this.OYH = paramString.OHL.SlG.TRB;
            }
            setResult(-1);
            a(paramString.OHL.SlG);
            paramString = paramString.OHL.Smq;
            if ((paramString != null) && (paramString.RZO != null))
            {
              paramq = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class);
              if ((paramString.Uvs == 1) && (paramString.Uvt == 1) && (paramq.eot()) && (paramq.eos()) && (!paramq.eoo()))
              {
                Log.i("Micromsg.WalletCheckPwdUI", "can use touch pay");
                this.fHR = 1;
                if (paramString.RZO != null) {
                  p.ByH.ByB = paramString.RZO.Ap();
                }
                paramq = p.ByH;
                if (paramString.RZP != 1) {
                  break label499;
                }
              }
            }
            label499:
            for (boolean bool = true;; bool = false)
            {
              paramq.ByJ = bool;
              gLu();
              this.mMe.setVisibility(0);
              gLs();
              setContentViewVisibility(0);
              break;
            }
          }
          if ((paramq instanceof y))
          {
            paramString = (y)paramq;
            if (paramString.gIx())
            {
              Log.i("Micromsg.WalletCheckPwdUI", "need free sms");
              paramq = new Bundle();
              paramq.putString("key_pwd1", this.nfX);
              paramq.putString("key_jsapi_token", this.OYC);
              paramq.putString("key_relation_key", paramString.OIm);
              paramq.putString("key_mobile", paramString.OIl);
              this.OYJ = new d.a()
              {
                public final Intent s(int paramAnonymousInt, Bundle paramAnonymousBundle)
                {
                  AppMethodBeat.i(230854);
                  Log.i("Micromsg.WalletCheckPwdUI", "verify code end: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
                  Intent localIntent = new Intent();
                  localIntent.putExtra("token", paramAnonymousBundle.getString("key_jsapi_token"));
                  localIntent.putExtra("key_process_result_code", paramAnonymousInt);
                  localIntent.setClass(WalletCheckPwdUI.this.getContext(), WalletCheckPwdUI.class);
                  localIntent.addFlags(536870912);
                  localIntent.putExtra("key_process_is_stay", false);
                  AppMethodBeat.o(230854);
                  return localIntent;
                }
              };
              com.tencent.mm.wallet_core.a.a(this, q.class, paramq, this.OYJ);
            }
            else
            {
              paramString = new Intent();
              paramString.putExtra("token", ((y)paramq).OIj);
              setResult(-1, paramString);
              amj(-1);
              finish();
            }
          }
        }
      }
    }
    if (this.DLa != null) {
      this.DLa.fuo();
    }
    if (((paramq instanceof com.tencent.mm.plugin.wallet_core.c.d)) || ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.e)))
    {
      Log.i("Micromsg.WalletCheckPwdUI", "check jsapi fail");
      paramString = com.tencent.mm.wallet_core.a.bF(this);
      if ((paramString != null) && (paramString.epb().equals("UnbindProcess")))
      {
        setResult(1);
        paramString.fKb.putInt("key_process_result_code", 1);
        com.tencent.mm.wallet_core.a.l(this, paramString.fKb);
      }
      for (;;)
      {
        AppMethodBeat.o(70915);
        return true;
        setResult(0);
        amj(0);
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