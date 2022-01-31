package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_core.c.e;
import com.tencent.mm.plugin.wallet_core.c.u;
import com.tencent.mm.plugin.wallet_core.c.v;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.blm;
import com.tencent.mm.protocal.protobuf.cla;
import com.tencent.mm.protocal.protobuf.sp;
import com.tencent.mm.protocal.protobuf.te;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

@com.tencent.mm.ui.base.a(3)
public class WalletCheckPwdUI
  extends WalletBaseUI
{
  private String cnI;
  private int cwW = 0;
  private String gGl;
  private TextView gpt;
  private ScrollView hLr;
  protected EditHintPasswdView nID;
  private boolean upR = false;
  private LinearLayout upS;
  private ImageView upT;
  private TextView upU;
  private TextView upV;
  private TextView upW;
  private boolean upX = false;
  private boolean upY = false;
  private String upZ;
  private int uqa = 0;
  private int uqb;
  private String uqc;
  private String uqd;
  private Animation uqe;
  private c.a uqf;
  
  private void a(blm paramblm)
  {
    AppMethodBeat.i(47348);
    if ((paramblm != null) && (!bo.isNullOrNil(paramblm.title))) {
      this.upV.setText(paramblm.title);
    }
    if ((paramblm != null) && (!bo.isNullOrNil(paramblm.xAi))) {
      this.upW.setText(paramblm.xAi);
    }
    cVC();
    AppMethodBeat.o(47348);
  }
  
  private void cVB()
  {
    AppMethodBeat.i(47349);
    com.tencent.mm.sdk.platformtools.ab.i("Micromsg.WalletCheckPwdUI", "change mode: %s", new Object[] { Integer.valueOf(this.cwW) });
    if (this.cwW == 1)
    {
      this.upS.setVisibility(0);
      this.nID.setVisibility(8);
      this.gpt.setText(2131305002);
      this.upS.postDelayed(new WalletCheckPwdUI.6(this), 300L);
      if (!bo.isNullOrNil(this.uqd))
      {
        this.upW.setText(this.uqd);
        AppMethodBeat.o(47349);
        return;
      }
      this.upW.setText(2131305006);
      AppMethodBeat.o(47349);
      return;
    }
    this.upS.setVisibility(8);
    this.nID.cfK();
    this.nID.setVisibility(0);
    this.gpt.setText(2131305001);
    showTenpayKB();
    if (!bo.isNullOrNil(this.uqc))
    {
      this.upW.setText(this.uqc);
      AppMethodBeat.o(47349);
      return;
    }
    this.upW.setText(2131305005);
    AppMethodBeat.o(47349);
  }
  
  private void cVC()
  {
    AppMethodBeat.i(47350);
    c localc = getProcess();
    if (localc != null)
    {
      if ("UnbindProcess".equals(localc.bzC()))
      {
        this.upV.setText(2131305128);
        this.upW.setText(2131305011);
        AppMethodBeat.o(47350);
        return;
      }
      if ((localc instanceof com.tencent.mm.plugin.wallet_core.b.b))
      {
        this.upV.setText(2131305109);
        this.upW.setText(2131305011);
        AppMethodBeat.o(47350);
        return;
      }
      if ("ModifyPwdProcess".equals(localc.bzC()))
      {
        this.upV.setText(2131305305);
        this.upW.setText(2131305011);
        AppMethodBeat.o(47350);
        return;
      }
      if ("OfflineProcess".equals(localc.bzC()))
      {
        this.upV.setText(2131305010);
        this.upW.setText(2131305011);
      }
    }
    AppMethodBeat.o(47350);
  }
  
  private void cVD()
  {
    AppMethodBeat.i(47355);
    com.tencent.mm.plugin.soter.d.a.cyb();
    ma localma = new ma();
    localma.cCa.cwk = this.cnI;
    localma.cCa.cCc = 1;
    localma.cCa.cCe = new WalletCheckPwdUI.8(this, localma);
    com.tencent.mm.sdk.b.a.ymk.a(localma, Looper.getMainLooper());
    AppMethodBeat.o(47355);
  }
  
  private static void cVE()
  {
    AppMethodBeat.i(47356);
    com.tencent.mm.sdk.platformtools.ab.i("Micromsg.WalletCheckPwdUI", "hy: send release FPManager");
    oh localoh = new oh();
    com.tencent.mm.sdk.b.a.ymk.l(localoh);
    AppMethodBeat.o(47356);
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(47354);
    if (this.upR)
    {
      finish();
      AppMethodBeat.o(47354);
      return;
    }
    if (this.nID != null) {
      this.nID.cfK();
    }
    AppMethodBeat.o(47354);
  }
  
  public void forceCancel()
  {
    AppMethodBeat.i(47343);
    com.tencent.mm.sdk.platformtools.ab.d("Micromsg.WalletCheckPwdUI", "check pwd ");
    cleanScenes();
    AppMethodBeat.o(47343);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130971163;
  }
  
  public void initView()
  {
    AppMethodBeat.i(47347);
    bo.aa(getTips(0));
    this.nID = ((EditHintPasswdView)findViewById(2131825034));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.nID);
    this.nID.setOnInputValidListener(new WalletCheckPwdUI.3(this));
    this.hLr = ((ScrollView)findViewById(2131829082));
    this.upS = ((LinearLayout)findViewById(2131829087));
    this.upT = ((ImageView)findViewById(2131829088));
    this.upV = ((TextView)findViewById(2131825031));
    this.upW = ((TextView)findViewById(2131829086));
    this.upU = ((TextView)findViewById(2131829089));
    this.gpt = ((TextView)findViewById(2131829090));
    this.gpt.setOnClickListener(new WalletCheckPwdUI.4(this));
    setTenpayKBStateListener(new WalletCheckPwdUI.5(this));
    setEditFocusListener(this.nID, 0, false);
    showTenpayKB();
    AppMethodBeat.o(47347);
  }
  
  public boolean isTransparent()
  {
    return this.upR;
  }
  
  public boolean needConfirmFinish()
  {
    AppMethodBeat.i(47353);
    if (getInput().getInt("key_pay_flag", 0) != 0)
    {
      AppMethodBeat.o(47353);
      return true;
    }
    AppMethodBeat.o(47353);
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = -1;
    AppMethodBeat.i(47342);
    super.onCreate(paramBundle);
    hideTitleView();
    hideActionbarLine();
    paramBundle = getIntent();
    Object localObject;
    if ((paramBundle != null) && (getIntent().hasExtra("scene")))
    {
      i = paramBundle.getIntExtra("scene", -1);
      if (i != 1) {
        break label494;
      }
      this.upX = true;
      com.tencent.mm.sdk.platformtools.ab.d("Micromsg.WalletCheckPwdUI", "check pwd jsapi");
      setContentViewVisibility(4);
      paramBundle = null;
      if (!this.upY) {
        break label284;
      }
      localObject = com.tencent.mm.wallet_core.a.aM(this);
      if (localObject != null) {
        paramBundle = ((c)localObject).mEJ;
      }
      localObject = paramBundle;
      if (paramBundle != null) {
        break label320;
      }
      com.tencent.mm.sdk.platformtools.ab.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] process.getContextData null");
      setResult(1);
      finish();
    }
    for (;;)
    {
      initView();
      cVC();
      setBackBtn(new WalletCheckPwdUI.1(this));
      findViewById(2131829085).setOnClickListener(new WalletCheckPwdUI.2(this));
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramBundle = getWindow();
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(getResources().getColor(2131690316));
        if (Build.VERSION.SDK_INT >= 23) {
          paramBundle.getDecorView().setSystemUiVisibility(8192);
        }
      }
      getContentView().setFitsSystemWindows(true);
      AppMethodBeat.o(47342);
      return;
      paramBundle = com.tencent.mm.wallet_core.a.aM(this);
      if (paramBundle == null) {
        break;
      }
      i = paramBundle.mEJ.getInt("scene", -1);
      if ((i == 1) && ("UnbindProcess".equals(paramBundle.bzC()))) {}
      for (boolean bool = true;; bool = false)
      {
        this.upY = bool;
        break;
      }
      label284:
      if (getIntent() == null)
      {
        com.tencent.mm.sdk.platformtools.ab.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] intent null");
        setResult(0);
        finish();
      }
      else
      {
        localObject = getIntent().getExtras();
        label320:
        paramBundle = ((Bundle)localObject).getString("appId");
        String str1 = ((Bundle)localObject).getString("timeStamp");
        String str2 = ((Bundle)localObject).getString("nonceStr");
        String str3 = ((Bundle)localObject).getString("packageExt");
        String str4 = ((Bundle)localObject).getString("signtype");
        String str5 = ((Bundle)localObject).getString("paySignature");
        String str6 = ((Bundle)localObject).getString("url");
        i = ((Bundle)localObject).getInt("pay_channel", 0);
        if (this.upY) {
          com.tencent.mm.sdk.platformtools.ab.i("Micromsg.WalletCheckPwdUI", "appId is null? " + bo.isNullOrNil(paramBundle));
        }
        for (paramBundle = new d(paramBundle, str1, str2, str3, str4, str5, str6, 10, "verifyWCPayPassword", i);; paramBundle = new e(paramBundle, str1, str2, str3, str4, str5, str6, "verifyWCPayPassword", i))
        {
          doSceneForceProgress(paramBundle);
          break;
        }
        label494:
        setContentViewVisibility(0);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(47346);
    super.onDestroy();
    cVE();
    AppMethodBeat.o(47346);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(47352);
    if ((this.mKBLayout != null) && (this.mKBLayout.isShown()))
    {
      this.mKBLayout.setVisibility(8);
      AppMethodBeat.o(47352);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(47352);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(47345);
    super.onPause();
    this.cwW = 0;
    cVB();
    cVE();
    removeSceneEndListener(580);
    AppMethodBeat.o(47345);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(47344);
    if (this.nID != null) {
      this.nID.cfK();
    }
    addSceneEndListener(580);
    super.onResume();
    AppMethodBeat.o(47344);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(47351);
    com.tencent.mm.sdk.platformtools.ab.d("Micromsg.WalletCheckPwdUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof u))
      {
        paramString = getInput();
        paramString.putString("key_pwd1", this.nID.getText());
        com.tencent.mm.wallet_core.a.j(this, paramString);
        if (this.nID != null) {
          this.nID.cfK();
        }
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(47351);
        return true;
        if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab))
        {
          h.bO(this, getString(2131305018));
          paramString = com.tencent.mm.wallet_core.a.aM(this);
          if (paramString != null) {
            paramString.mEJ.putInt("key_process_result_code", -1);
          }
          com.tencent.mm.wallet_core.a.j(this, paramString.mEJ);
          if (this.nID != null) {
            this.nID.cfK();
          }
          finish();
        }
        else if ((paramm instanceof d))
        {
          com.tencent.mm.pluginsdk.wallet.g.ana(((d)paramm).cSW());
          this.upZ = ((d)paramm).getToken();
          setResult(-1);
          a(((sp)((d)paramm).rr.fsW.fta).wLd);
          setContentViewVisibility(0);
        }
        else
        {
          if ((paramm instanceof e))
          {
            paramString = (e)paramm;
            this.upZ = paramString.ubs.token;
            this.cnI = paramString.ubs.wgF;
            com.tencent.mm.pluginsdk.wallet.g.ana(paramString.ubs.wgF);
            if (paramString.ubs.wLd != null)
            {
              this.uqc = paramString.ubs.wLd.xAi;
              this.uqd = paramString.ubs.wLd.xAj;
            }
            setResult(-1);
            a(paramString.ubs.wLd);
            paramString = paramString.ubs.wLF;
            if ((paramString != null) && (paramString.wBy != null))
            {
              paramm = (l)com.tencent.mm.kernel.g.E(l.class);
              if ((paramString.xVv == 1) && (paramString.xVw == 1) && (paramm.bzb()) && (paramm.bza()) && (!paramm.byT()))
              {
                com.tencent.mm.sdk.platformtools.ab.i("Micromsg.WalletCheckPwdUI", "can use touch pay");
                this.cwW = 1;
                if (paramString.wBy != null) {
                  x.uli.mGC = paramString.wBy.dqj();
                }
                paramm = x.uli;
                if (paramString.wBz != 1) {
                  break label496;
                }
              }
            }
            label496:
            for (boolean bool = true;; bool = false)
            {
              paramm.mGD = bool;
              cVD();
              this.gpt.setVisibility(0);
              cVB();
              setContentViewVisibility(0);
              break;
            }
          }
          if ((paramm instanceof v))
          {
            paramString = (v)paramm;
            if (paramString.cSX())
            {
              com.tencent.mm.sdk.platformtools.ab.i("Micromsg.WalletCheckPwdUI", "need free sms");
              paramm = new Bundle();
              paramm.putString("key_pwd1", this.gGl);
              paramm.putString("key_jsapi_token", this.upZ);
              paramm.putString("key_relation_key", paramString.ubR);
              paramm.putString("key_mobile", paramString.ubQ);
              this.uqf = new WalletCheckPwdUI.7(this);
              com.tencent.mm.wallet_core.a.a(this, n.class, paramm, this.uqf);
            }
            else
            {
              paramString = new Intent();
              paramString.putExtra("token", ((v)paramm).ubO);
              setResult(-1, paramString);
              finish();
            }
          }
        }
      }
    }
    if (this.nID != null) {
      this.nID.cfK();
    }
    if (((paramm instanceof d)) || ((paramm instanceof e)))
    {
      com.tencent.mm.sdk.platformtools.ab.i("Micromsg.WalletCheckPwdUI", "check jsapi fail");
      paramString = com.tencent.mm.wallet_core.a.aM(this);
      if ((paramString != null) && (paramString.bzC().equals("UnbindProcess")))
      {
        setResult(1);
        paramString.mEJ.putInt("key_process_result_code", 1);
        com.tencent.mm.wallet_core.a.j(this, paramString.mEJ);
      }
      for (;;)
      {
        AppMethodBeat.o(47351);
        return true;
        setResult(0);
        finish();
      }
    }
    AppMethodBeat.o(47351);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setContentViewVisibility(int paramInt)
  {
    AppMethodBeat.i(47341);
    getContentView().setVisibility(paramInt);
    AppMethodBeat.o(47341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI
 * JD-Core Version:    0.7.0.1
 */