package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aq;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.a;
import com.tencent.mm.g.a.gj;
import com.tencent.mm.g.a.qt;
import com.tencent.mm.g.a.zc;
import com.tencent.mm.g.b.a.ab;
import com.tencent.mm.g.b.a.hg;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.bss;
import com.tencent.mm.protocal.protobuf.dez;
import com.tencent.mm.protocal.protobuf.dk;
import com.tencent.mm.protocal.protobuf.dok;
import com.tencent.mm.protocal.protobuf.dp;
import com.tencent.mm.protocal.protobuf.dq;
import com.tencent.mm.protocal.protobuf.qb;
import com.tencent.mm.protocal.protobuf.qd;
import com.tencent.mm.protocal.protobuf.qh;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.protocal.protobuf.xu;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.picker.e.2;
import com.tencent.mm.ui.widget.picker.e.3;
import com.tencent.mm.ui.widget.picker.e.a;
import com.tencent.mm.ui.widget.picker.e.b;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.l.7;
import com.tencent.mm.wallet_core.c.l.8;
import com.tencent.mm.wallet_core.c.l.9;
import com.tencent.mm.wallet_core.c.l.a;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.c;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public class RemittanceBusiUI
  extends WalletBaseUI
  implements WcPayKeyboard.a
{
  private String app_id;
  private String dAa;
  private int dGt;
  private double dmz;
  private int mChannel;
  private int mPayScene;
  private int mRequestCode;
  private int state;
  private ScrollView uSG;
  private String wNH;
  private int ymC;
  private WcPayKeyboard ymE;
  private WalletFormView ymL;
  private RelativeLayout ymM;
  private TextView ymN;
  private RelativeLayout ymO;
  private int ymv;
  private Runnable ync;
  private com.tencent.mm.sdk.b.c<aq> ypC;
  private String ypW;
  private String yqB;
  private boolean yqG;
  private hg yqI;
  private boolean yqL;
  private boolean yqO;
  private com.tencent.mm.sdk.b.c yqQ;
  private LinearLayout yqm;
  private String yrA;
  private String yrE;
  private BusiRemittanceResp yrI;
  private String yrz;
  private int ysA;
  private String ysB;
  private float ysC;
  private boolean ysD;
  private String ysE;
  private int ysF;
  private int ysG;
  private String ysH;
  private dok ysI;
  private String ysJ;
  private int ysK;
  private int ysL;
  private int ysM;
  private int ysN;
  private String ysO;
  private String ysP;
  private b ysQ;
  private String ysR;
  private String ysS;
  boolean ysT;
  private boolean ysU;
  com.tencent.mm.plugin.remittance.model.g ysV;
  private b ysW;
  private b ysX;
  protected boolean ysY;
  private Map<String, dk> ysZ;
  private TextView ysd;
  private TextView yse;
  private TextView ysf;
  private TextView ysg;
  private TextView ysh;
  private TextView ysi;
  private TextView ysj;
  private View ysk;
  private CdnImageView ysl;
  private LinearLayout ysm;
  private LinearLayout ysn;
  private TextView yso;
  private View ysp;
  private TextView ysq;
  private Button ysr;
  private RelativeLayout yss;
  private String yst;
  private double ysu;
  private String ysv;
  private String ysw;
  private String ysx;
  private String ysy;
  private String ysz;
  private RemittanceF2fDynamicCodeUI yta;
  private boolean ytb;
  private int ytc;
  private boolean ytd;
  private int yte;
  private int ytf;
  private i ytg;
  private Runnable yth;
  private com.tencent.mm.wallet_core.d.c<com.tencent.mm.plugin.remittance.model.l> yti;
  private c ytj;
  private boolean ytk;
  private double ytl;
  private String ytm;
  private String ytn;
  private com.tencent.mm.sdk.b.c yto;
  private com.tencent.mm.sdk.b.c ytp;
  private com.tencent.mm.sdk.b.c ytq;
  private com.tencent.mm.sdk.b.c ytr;
  
  public RemittanceBusiUI()
  {
    AppMethodBeat.i(68056);
    this.ysC = 0.0F;
    this.ymv = 4;
    this.ysK = 0;
    this.ysL = 0;
    this.ysM = 0;
    this.ysN = 0;
    this.ysQ = new b();
    this.ysR = "";
    this.ysS = "";
    this.ysT = false;
    this.dmz = -1.0D;
    this.ysU = false;
    this.ysV = null;
    this.yqG = false;
    this.ysY = false;
    this.mRequestCode = 0;
    this.ysZ = new HashMap();
    this.yta = null;
    this.ytb = false;
    this.ytd = false;
    this.state = 0;
    this.ync = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68025);
        if ((RemittanceBusiUI.g(RemittanceBusiUI.this) == 2) && (RemittanceBusiUI.this.isHandleAutoShowNormalStWcKb())) {
          RemittanceBusiUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(68025);
      }
    };
    this.yth = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68028);
        RemittanceBusiUI.M(RemittanceBusiUI.this);
        AppMethodBeat.o(68028);
      }
    };
    this.yti = new com.tencent.mm.wallet_core.d.c()
    {
      public final void a(com.tencent.mm.wallet_core.d.d paramAnonymousd)
      {
        AppMethodBeat.i(163820);
        if ((paramAnonymousd instanceof com.tencent.mm.plugin.remittance.model.l)) {
          RemittanceBusiUI.b(RemittanceBusiUI.this, ((com.tencent.mm.plugin.remittance.model.l)paramAnonymousd).dmw);
        }
        AppMethodBeat.o(163820);
      }
    };
    this.ytj = new c();
    this.ypC = new com.tencent.mm.sdk.b.c() {};
    this.ytk = true;
    this.dGt = 0;
    this.ytl = 0.0D;
    this.ytn = "";
    this.yqQ = new com.tencent.mm.sdk.b.c() {};
    this.yto = new com.tencent.mm.sdk.b.c() {};
    this.ytp = new com.tencent.mm.sdk.b.c() {};
    this.ytq = new com.tencent.mm.sdk.b.c() {};
    this.ytr = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(68056);
  }
  
  private void B(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(68075);
    ae.i("MicroMsg.RemittanceBusiUI", "doBusiZeroCallback %s", new Object[] { Boolean.valueOf(paramBoolean) });
    dk localdk = (dk)this.ysZ.get(paramString);
    if (localdk == null)
    {
      AppMethodBeat.o(68075);
      return;
    }
    dok localdok = this.ysI;
    String str = this.ysH;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString = new com.tencent.mm.plugin.remittance.model.l(localdok, localdk, str, i, this.ysJ, paramString);
      if (!paramBoolean) {
        break;
      }
      paramString.hasRetried = true;
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(paramString, 0);
      AppMethodBeat.o(68075);
      return;
    }
    this.ysN = 0;
    doSceneForceProgress(paramString);
    AppMethodBeat.o(68075);
  }
  
  private void a(int paramInt, qb paramqb, boolean paramBoolean, gi paramgi, String paramString1, String paramString2)
  {
    AppMethodBeat.i(68077);
    a(paramInt, paramqb, paramBoolean, paramgi, paramString1, paramString2, "");
    AppMethodBeat.o(68077);
  }
  
  private void a(int paramInt, qb paramqb, boolean paramBoolean, gi paramgi, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(163834);
    int i = 0;
    int j = 0;
    if (!this.ytk)
    {
      boolean bool1 = bu.K(Double.valueOf(this.ytl), Double.valueOf(this.ysu));
      boolean bool2 = bu.lX(this.ytm, this.yrA);
      if (!bool1) {
        j = 1;
      }
      i = j;
      if (!bool2) {
        i = j | 0x2;
      }
    }
    String str1 = this.yqB;
    String str2 = this.yst;
    j = this.mPayScene;
    String str3 = this.ysy;
    String str4 = this.yrA;
    int k = this.mChannel;
    String str5 = this.ysz;
    String str6 = this.ysE;
    int m = this.ysG;
    int n = this.ysF;
    String str7 = this.ysv;
    ald localald = this.ysQ.ypG;
    if (paramqb == null)
    {
      paramqb = "";
      paramString1 = new i(str1, str2, j, str3, str4, paramInt, k, str5, str6, m, n, str7, localald, paramqb, this.yrI.yns, paramString1, this.ypW, paramString2, this.ysw, this.ytn, this.dGt, i, paramString3);
      if (paramBoolean) {
        paramString1.a(paramgi);
      }
      if ((!this.mKindaEnable) || (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_QRCODE_RECEIVE_PAY_SWTICH_KEY"))) {
        break label383;
      }
      if (this.yta == null) {
        break label376;
      }
      this.yta.showSafeProgress();
    }
    label275:
    label279:
    label411:
    label424:
    for (;;)
    {
      paramBoolean = false;
      paramqb = this;
      paramqb.doSceneProgress(paramString1, paramBoolean);
      if (this.ytb)
      {
        if (paramInt == this.ytc) {
          a(5, this.ytg);
        }
      }
      else {
        label310:
        if ((e.dMU().getContext() != null) && ((e.dMU().getContext() instanceof RemittanceBusiUI))) {
          if (this.ytd)
          {
            if (paramInt != this.ytf) {
              break label411;
            }
            a(13, this.ytg);
          }
        }
      }
      for (;;)
      {
        this.ytf = paramInt;
        AppMethodBeat.o(163834);
        return;
        paramqb = paramqb.GdJ;
        break;
        label376:
        showLoading();
        break label275;
        label383:
        if (e.dMU().dMX()) {
          break label424;
        }
        paramBoolean = true;
        paramqb = this;
        break label279;
        a(4, this.ytg);
        break label310;
        a(12, this.ytg);
      }
    }
  }
  
  private void a(com.tencent.mm.plugin.remittance.model.c paramc, com.tencent.mm.plugin.remittance.model.d paramd, int paramInt)
  {
    AppMethodBeat.i(68069);
    int j;
    int k;
    int m;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    if (this.ysT)
    {
      this.ysq.setText(com.tencent.mm.wallet_core.ui.f.C(dMZ()));
      ar.ay(this.yth);
      this.ysu = dMZ();
      long l = Math.round(this.ysu * 100.0D);
      if (l <= 0L)
      {
        this.ysQ.dMC();
        this.ysj.setTextColor(getContext().getResources().getColor(2131100212));
        this.ysj.setText(this.yrI.ynr);
        if (this.ysV != null) {
          this.ysV.cancel = true;
        }
        AppMethodBeat.o(68069);
        return;
      }
      j = (int)l;
      k = this.mChannel;
      m = this.yrI.yns;
      str1 = this.ysy;
      str2 = this.ypW;
      str3 = this.yrI.ynt;
      str4 = this.yqB;
      str5 = this.ysv;
      str6 = this.yrI.ynu;
      if (paramc != null) {
        break label243;
      }
    }
    label243:
    for (int i = 0;; i = 1)
    {
      this.ysV = new com.tencent.mm.plugin.remittance.model.g(j, k, m, str1, str2, str3, str4, str5, str6, i, paramc, paramd);
      ar.o(this.yth, paramInt);
      AppMethodBeat.o(68069);
      return;
    }
  }
  
  private void a(qh paramqh)
  {
    AppMethodBeat.i(68085);
    ae.i("MicroMsg.RemittanceBusiUI", "resp.payer_need_auth_flag %s", new Object[] { Integer.valueOf(paramqh.Gei) });
    if (paramqh.Gei == 1)
    {
      paramqh = new Bundle();
      com.tencent.mm.sdk.b.a.IvT.c(this.ytq);
      paramqh.putString("realname_verify_process_jump_activity", ".ui.RemittanceBusiUI");
      paramqh.putString("realname_verify_process_jump_plugin", "remittance");
      paramqh.putInt("real_name_verify_mode", 0);
      paramqh.putInt("entry_scene", this.mPayScene);
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramqh);
      AppMethodBeat.o(68085);
      return;
    }
    Intent localIntent = new Intent();
    Object localObject;
    if (!bu.isNullOrNil(this.ysP)) {
      localObject = this.ysP;
    }
    for (;;)
    {
      localIntent.putExtra("INTENT_TITLE", (String)localObject);
      localIntent.putExtra("INTENT_CAN_TOUCH", this.ysK);
      localIntent.putExtra("INTENT_PAYFEE", com.tencent.mm.wallet_core.ui.f.C(0.0D));
      localIntent.putExtra("INTENT_REQKEY", paramqh.dwj);
      paramqh = paramqh.Gej;
      try
      {
        localIntent.putExtra("INTENT_TOKENMESS", paramqh.toByteArray());
        com.tencent.mm.br.d.b(getContext(), "wallet", "com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI", localIntent, 2);
        AppMethodBeat.o(68085);
        return;
      }
      catch (Exception paramqh)
      {
        String str;
        StringBuilder localStringBuilder;
        ae.printErrStackTrace("MicroMsg.RemittanceBusiUI", paramqh, "", new Object[0]);
        AppMethodBeat.o(68085);
      }
      str = getString(2131765746);
      if (!bu.isNullOrNil(this.ysv))
      {
        com.tencent.mm.kernel.g.ajS();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().aUK(this.ysv);
        if (localObject != null)
        {
          localObject = ((an)localObject).adG();
          localStringBuilder = new StringBuilder().append(com.tencent.mm.wallet_core.ui.f.bar((String)localObject));
          if (bu.isNullOrNil(this.ysw)) {}
          for (localObject = "";; localObject = "(" + this.ysw + ")")
          {
            localObject = bu.x(str, new Object[] { (String)localObject });
            break;
          }
        }
        ae.e("MicroMsg.RemittanceBusiUI", "can not found contact for user::" + this.ysv);
        localObject = "";
      }
      else
      {
        ae.e("MicroMsg.RemittanceBusiUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        localObject = "";
      }
    }
  }
  
  private void a(boolean paramBoolean, Intent paramIntent)
  {
    AppMethodBeat.i(68073);
    if (paramBoolean)
    {
      String str1 = paramIntent.getStringExtra("key_trans_id");
      double d = paramIntent.getDoubleExtra("key_total_fee", -1.0D);
      String str2 = paramIntent.getStringExtra("key_reqKey");
      ae.i("MicroMsg.RemittanceBusiUI", "onActivityResult _transId: %s _totalFee: %s", new Object[] { str1, Double.valueOf(d) });
      if (bu.isNullOrNil(this.wNH)) {
        this.wNH = str1;
      }
      if (d >= 0.0D) {
        this.dmz = d;
      }
      if (this.yqG) {
        com.tencent.mm.plugin.report.service.g.yxI.f(15386, new Object[] { Integer.valueOf(3), Integer.valueOf(2) });
      }
      dNd();
      axL(str2);
    }
    for (;;)
    {
      c(paramBoolean, paramIntent);
      AppMethodBeat.o(68073);
      return;
      if (ag.bx(paramIntent))
      {
        finish();
        AppMethodBeat.o(68073);
        return;
      }
      if (ag.by(paramIntent))
      {
        AppMethodBeat.o(68073);
        return;
      }
      ae.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor");
      dNc();
    }
  }
  
  private boolean a(i parami)
  {
    AppMethodBeat.i(68079);
    boolean bool1 = false;
    if (!this.yqL) {
      bool1 = b(parami);
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = c(parami);
    }
    AppMethodBeat.o(68079);
    return bool2;
  }
  
  private void axL(String paramString)
  {
    AppMethodBeat.i(68086);
    ae.i("MicroMsg.RemittanceBusiUI", "do pay check: %s", new Object[] { paramString });
    paramString = (dk)this.ysZ.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(68086);
      return;
    }
    if (!bu.isNullOrNil(this.wNH)) {
      paramString.FOg = this.wNH;
    }
    doSceneProgress(new com.tencent.mm.plugin.remittance.model.h(paramString, this.ysR), false);
    AppMethodBeat.o(68086);
  }
  
  private boolean b(final i parami)
  {
    AppMethodBeat.i(68080);
    if (!bu.isNullOrNil(parami.ynL.Gec))
    {
      this.yqL = true;
      bJ(1, parami.ynL.FOf);
      e.dMU().a(parami.ynL.Gec, getString(2131755873), getString(2131762423), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68036);
          RemittanceBusiUI.a(RemittanceBusiUI.this, 3, parami.ynL.FOf);
          if (!RemittanceBusiUI.b(RemittanceBusiUI.this, parami))
          {
            if ((RemittanceBusiUI.T(RemittanceBusiUI.this)) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_QRCODE_RECEIVE_PAY_SWTICH_KEY")))
            {
              if (RemittanceBusiUI.P(RemittanceBusiUI.this) == null) {
                break label102;
              }
              RemittanceBusiUI.P(RemittanceBusiUI.this).showSafeProgress();
            }
            for (;;)
            {
              RemittanceBusiUI.a(RemittanceBusiUI.this, parami);
              AppMethodBeat.o(68036);
              return;
              label102:
              RemittanceBusiUI.this.showLoading();
            }
          }
          RemittanceBusiUI.U(RemittanceBusiUI.this);
          AppMethodBeat.o(68036);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(163824);
          RemittanceBusiUI.U(RemittanceBusiUI.this);
          RemittanceBusiUI.a(RemittanceBusiUI.this, 2, parami.ynL.FOf);
          AppMethodBeat.o(163824);
        }
      });
      AppMethodBeat.o(68080);
      return true;
    }
    AppMethodBeat.o(68080);
    return false;
  }
  
  private void bJ(int paramInt, String paramString)
  {
    AppMethodBeat.i(68081);
    this.yqI = new hg();
    this.yqI.dWt = 1L;
    this.yqI.dQB = paramInt;
    this.yqI.qv(paramString);
    this.yqI.aLH();
    AppMethodBeat.o(68081);
  }
  
  private void c(boolean paramBoolean, Intent paramIntent)
  {
    AppMethodBeat.i(68074);
    this.ytk = false;
    if (paramBoolean)
    {
      ae.i("MicroMsg.RemittanceBusiUI", "savePayInfo isOk = true");
      this.dGt = 1;
    }
    for (;;)
    {
      ae.i("MicroMsg.RemittanceBusiUI", "savePayInfo() mLastPayResult:%s mLastTotalAmt:%s mLastPayerDesc:%s mLastF2fId:%s", new Object[] { Double.valueOf(this.ytl), Double.valueOf(this.ytl), this.ytm, this.ytn });
      AppMethodBeat.o(68074);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(68074);
        return;
      }
      this.dGt = paramIntent.getIntExtra("key_pay_reslut_type", 3);
      this.ytl = this.ysu;
      this.ytm = this.yrA;
      this.ytn = this.yrz;
    }
  }
  
  private boolean c(final i parami)
  {
    AppMethodBeat.i(68083);
    if (parami.ynL.Ged != null)
    {
      this.yqO = true;
      e.dMU().a(parami.ynL.oGu, "", parami.ynL.Ged.kDa, parami.ynL.Ged.kCZ, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(163825);
          ae.i("MicroMsg.RemittanceBusiUI", "goto h5: %s", new Object[] { parami.ynL.Ged.phk });
          com.tencent.mm.wallet_core.ui.f.p(RemittanceBusiUI.this.getContext(), parami.ynL.Ged.phk, false);
          AppMethodBeat.o(163825);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(68083);
      return true;
    }
    AppMethodBeat.o(68083);
    return false;
  }
  
  private void d(i parami)
  {
    AppMethodBeat.i(68084);
    ae.i("MicroMsg.RemittanceBusiUI", "do start pay zero_pay_flag: %s", new Object[] { Integer.valueOf(parami.ynL.Geh) });
    if (e.dMU().dMW()) {
      ae.w("MicroMsg.RemittanceBusiUI", "finish finishRemitLMRemindUI");
    }
    Object localObject1 = new dk();
    ((dk)localObject1).channel = this.mChannel;
    ((dk)localObject1).FOf = this.yrz;
    ((dk)localObject1).FOg = this.wNH;
    ((dk)localObject1).yns = this.yrI.yns;
    ((dk)localObject1).scene = this.mPayScene;
    ((dk)localObject1).FOh = this.yrE;
    ((dk)localObject1).FOi = this.ysQ.ypG;
    ((dk)localObject1).iWC = this.ysv;
    ((dk)localObject1).yoT = this.yqB;
    ((dk)localObject1).FOj = parami.xdJ;
    this.ysZ.put(parami.ynL.dwj, localObject1);
    if (parami.ynL.Geh == 1)
    {
      a(parami.ynL);
      AppMethodBeat.o(68084);
      return;
    }
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.dmw = parami.ynL.dwj;
    localPayInfo.dDH = this.mPayScene;
    if (this.mChannel > 0) {
      localPayInfo.channel = this.mChannel;
    }
    if (parami.ynL.Geo != null) {
      localPayInfo.trY = parami.ynL.Geo.fjO();
    }
    localPayInfo.DAm = parami.ynL.Gen;
    Object localObject2;
    if (parami.ynL.Gep == 1)
    {
      bool = true;
      localPayInfo.DpN = bool;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("extinfo_key_1", this.ysv);
      ((Bundle)localObject1).putString("extinfo_key_2", this.ysw);
      ((Bundle)localObject1).putString("extinfo_key_3", this.ysy);
      ((Bundle)localObject1).putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
      ((Bundle)localObject1).putString("extinfo_key_7", this.yrA);
      ((Bundle)localObject1).putString("extinfo_key_19", parami.ynL.yoD);
      localPayInfo.hwN = ((Bundle)localObject1);
      localPayInfo.yoP = 1;
      localObject2 = new Intent();
      if (parami.ynL.yoA != 1) {
        break label738;
      }
      ((Bundle)localObject1).putInt("extinfo_key_15", parami.ynL.Geq);
      ((Bundle)localObject1).putString("extinfo_key_17", parami.ynL.yoB);
      ((Bundle)localObject1).putString("extinfo_key_18", parami.ynL.yoC);
      ((Intent)localObject2).putExtra("key_pay_info", localPayInfo);
      ((Intent)localObject2).putExtra("from_patch_ui", true);
      ((Intent)localObject2).putExtra("key_rcvr_open_id", this.yqB);
      ((Intent)localObject2).putExtra("key_mch_info", this.ysB);
      ((Intent)localObject2).putExtra("key_mch_photo", this.yrI.ynq);
      ((Intent)localObject2).putExtra("key_transfer_qrcode_id", this.yst);
      ((Intent)localObject2).putExtra("get_dynamic_code_sign", parami.ynL.yoB);
      ((Intent)localObject2).putExtra("get_dynamic_code_extend", parami.ynL.yoC);
      ((Intent)localObject2).putExtra("dynamic_code_spam_wording", parami.ynL.yoE);
      ((Intent)localObject2).putExtra("dynamic_code_amount", parami.ynL.Geq);
      ((Intent)localObject2).putExtra("show_paying_wording", parami.ynL.yoD);
      if (this.yrI.yny != 1) {
        break label733;
      }
    }
    label733:
    for (boolean bool = true;; bool = false)
    {
      ((Intent)localObject2).putExtra("show_avatar_type", bool);
      com.tencent.mm.plugin.report.service.g.yxI.f(15386, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
      this.yqQ.alive();
      this.yto.alive();
      this.ytp.alive();
      if ((this.mKindaEnable) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_QRCODE_RECEIVE_PAY_SWTICH_KEY"))) {
        hideLoading();
      }
      com.tencent.mm.br.d.b(this, "remittance", ".ui.RemittanceF2fDynamicCodeUI", (Intent)localObject2, 3);
      AppMethodBeat.o(68084);
      return;
      bool = false;
      break;
    }
    label738:
    String str;
    if ((this.mKindaEnable) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_QRCODE_RECEIVE_PAY_SWTICH_KEY")))
    {
      this.mRequestCode = 1;
      if (this.yta != null) {
        this.mRequestCode = 3;
      }
      str = "";
      if (!bu.isNullOrNil(parami.ynL.yoD))
      {
        parami = parami.ynL.yoD;
        if (localPayInfo.hwN == null) {
          localPayInfo.hwN = new Bundle();
        }
        localPayInfo.hwN.putString("cashier_desc", parami);
        if (bu.isNullOrNil(this.ysv)) {
          break label1349;
        }
        com.tencent.mm.kernel.g.ajS();
        parami = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().aUK(this.ysv);
        if (parami == null) {
          break label1349;
        }
        parami = parami.adG();
        localObject1 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.f.bar(parami));
        if (!bu.isNullOrNil(this.ysw)) {
          break label1188;
        }
        parami = "";
      }
    }
    label916:
    label1188:
    label1349:
    for (parami = parami;; parami = "")
    {
      localPayInfo.hwN.putString("prepay_page_payee", parami);
      if (this.yta != null) {
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this.yta, localPayInfo);
      }
      for (;;)
      {
        this.ysY = true;
        AppMethodBeat.o(68084);
        return;
        localObject2 = getIntent().getStringExtra("receiver_tips");
        localObject1 = getString(2131765746);
        parami = str;
        if (!bu.isNullOrNil((String)localObject2))
        {
          localObject1 = localObject2;
          parami = (i)localObject2;
        }
        if (!bu.isNullOrNil(this.ysv))
        {
          com.tencent.mm.kernel.g.ajS();
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().aUK(this.ysv);
          if (localObject2 != null)
          {
            parami = ((an)localObject2).adG();
            localObject2 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.f.bar(parami));
            if (bu.isNullOrNil(this.ysw)) {}
            for (parami = "";; parami = "(" + this.ysw + ")")
            {
              parami = bu.x((String)localObject1, new Object[] { parami });
              break;
            }
          }
          ae.e("MicroMsg.RemittanceBusiUI", "can not found contact for user::" + this.ysv);
          break;
        }
        ae.e("MicroMsg.RemittanceBusiUI", "mRcverName is null ,scene is MMPAY_PAY_SCENE_TRANSFER busi");
        break;
        parami = "(" + this.ysw + ")";
        break label916;
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, localPayInfo);
      }
      if (!bu.isNullOrNil(parami.ynM)) {}
      for (this.yqG = true; (parami.ynN != null) && (parami.ynN.dtd.dtg != null); this.yqG = false)
      {
        com.tencent.mm.pluginsdk.wallet.f.a(parami.ynN.dtd.dtg, false, "", localPayInfo, this.ysw, (Intent)localObject2, parami.ynN.dtd.mRequestCode);
        AppMethodBeat.o(68084);
        return;
      }
      com.tencent.mm.pluginsdk.wallet.f.a(this, false, "", localPayInfo, this.ysw, (Intent)localObject2, 1);
      AppMethodBeat.o(68084);
      return;
    }
  }
  
  private void dEy()
  {
    AppMethodBeat.i(68087);
    this.ysu = dMZ();
    if (this.ysu <= 0.0D)
    {
      findViewById(2131299860).setClickable(false);
      findViewById(2131299860).setEnabled(false);
      findViewById(2131299860).setOnClickListener(null);
      lG(false);
      this.ysj.setTextColor(getResources().getColor(2131100707));
      AppMethodBeat.o(68087);
      return;
    }
    this.ysj.setTextColor(getContext().getResources().getColor(2131100212));
    findViewById(2131299860).setEnabled(true);
    findViewById(2131299860).setClickable(true);
    lG(true);
    findViewById(2131299860).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163832);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.plugin.report.service.g.yxI.f(15235, new Object[] { Integer.valueOf(3) });
        if (RemittanceBusiUI.n(RemittanceBusiUI.this) == 56) {
          com.tencent.mm.plugin.report.service.g.yxI.f(19821, new Object[] { Integer.valueOf(7), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
        }
        RemittanceBusiUI.J(RemittanceBusiUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(163832);
      }
    });
    AppMethodBeat.o(68087);
  }
  
  private void dMP()
  {
    AppMethodBeat.i(68066);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68019);
        RemittanceBusiUI.E(RemittanceBusiUI.this).setText(RemittanceBusiUI.D(RemittanceBusiUI.this));
        Object localObject;
        if ((RemittanceBusiUI.k(RemittanceBusiUI.this) != null) && (!bu.isNullOrNil(RemittanceBusiUI.k(RemittanceBusiUI.this).ynz)))
        {
          localObject = RemittanceBusiUI.k(RemittanceBusiUI.this).ynz;
          RemittanceBusiUI.H(RemittanceBusiUI.this).setText(com.tencent.mm.pluginsdk.ui.span.k.b(RemittanceBusiUI.this, (CharSequence)localObject, RemittanceBusiUI.H(RemittanceBusiUI.this).getTextSize()));
          if (RemittanceBusiUI.k(RemittanceBusiUI.this) == null) {
            break label358;
          }
          if (RemittanceBusiUI.k(RemittanceBusiUI.this).ynp != 1) {
            break label340;
          }
          if (bu.isNullOrNil(RemittanceBusiUI.k(RemittanceBusiUI.this).ynq)) {
            break label267;
          }
          if (RemittanceBusiUI.k(RemittanceBusiUI.this).yny != 1) {
            break label253;
          }
          RemittanceBusiUI.I(RemittanceBusiUI.this).setRoundCorner(true);
        }
        for (;;)
        {
          int i = BackwardSupportUtil.b.h(RemittanceBusiUI.this, 36.0F);
          RemittanceBusiUI.I(RemittanceBusiUI.this).r(RemittanceBusiUI.k(RemittanceBusiUI.this).ynq, i, i, -1);
          AppMethodBeat.o(68019);
          return;
          String str = com.tencent.mm.wallet_core.ui.f.gX(com.tencent.mm.wallet_core.ui.f.zP(RemittanceBusiUI.F(RemittanceBusiUI.this)), 10);
          localObject = str;
          if (bu.isNullOrNil(RemittanceBusiUI.G(RemittanceBusiUI.this))) {
            break;
          }
          localObject = RemittanceBusiUI.this.getString(2131762438, new Object[] { str, RemittanceBusiUI.G(RemittanceBusiUI.this) });
          break;
          label253:
          RemittanceBusiUI.I(RemittanceBusiUI.this).setRoundCorner(false);
        }
        label267:
        if (!bu.isNullOrNil(RemittanceBusiUI.F(RemittanceBusiUI.this)))
        {
          if (RemittanceBusiUI.k(RemittanceBusiUI.this).yny == 1)
          {
            a.b.d(RemittanceBusiUI.I(RemittanceBusiUI.this), RemittanceBusiUI.F(RemittanceBusiUI.this));
            AppMethodBeat.o(68019);
            return;
          }
          a.b.c(RemittanceBusiUI.I(RemittanceBusiUI.this), RemittanceBusiUI.F(RemittanceBusiUI.this));
          AppMethodBeat.o(68019);
          return;
          label340:
          RemittanceBusiUI.I(RemittanceBusiUI.this).setVisibility(8);
          AppMethodBeat.o(68019);
          return;
        }
        label358:
        RemittanceBusiUI.I(RemittanceBusiUI.this).setVisibility(8);
        AppMethodBeat.o(68019);
      }
    });
    AppMethodBeat.o(68066);
  }
  
  private double dMZ()
  {
    AppMethodBeat.i(68057);
    if ((this.ysD) || (this.mPayScene == 33))
    {
      d = this.ysu;
      AppMethodBeat.o(68057);
      return d;
    }
    this.ysu = bu.getDouble(this.ymL.getText(), 0.0D);
    double d = this.ysu;
    AppMethodBeat.o(68057);
    return d;
  }
  
  private boolean dNa()
  {
    AppMethodBeat.i(68067);
    boolean bool;
    if (this.ysk == null) {
      bool = false;
    }
    for (;;)
    {
      com.tencent.mm.ui.tools.p.a(this, this.uSG, findViewById(2131304051), findViewById(2131304051), findViewById(2131304050), this.ysC);
      AppMethodBeat.o(68067);
      return bool;
      if (this.yrI != null)
      {
        ae.i("MicroMsg.RemittanceBusiUI", "tryShowFavor ");
        if ((this.yrI.ynw != null) && (this.yrI.ynw.GdH.size() > 0)) {}
        for (int i = 1;; i = 0)
        {
          if (this.yrI.ynv.size() > 0) {
            i = 1;
          }
          if (this.ysQ.dMD().size() > 0) {
            i = 1;
          }
          if (i == 0)
          {
            this.ysk.setVisibility(8);
            this.ysX.update();
            this.ysp.setVisibility(8);
            bool = false;
            break;
          }
          this.ysp.setVisibility(0);
          this.ysW.update();
          this.ysk.setVisibility(0);
          this.ysj.setText(this.yrI.ynr);
          this.ysj.setTextColor(getContext().getResources().getColor(2131100212));
          this.ysq.setText(com.tencent.mm.wallet_core.ui.f.C(dMZ()));
          Object localObject = this.ysQ.ypG;
          if (localObject != null)
          {
            this.ysj.setTextColor(getContext().getResources().getColor(2131099777));
            this.ysj.setText(((ald)localObject).ynr);
            this.ysq.setText(com.tencent.mm.wallet_core.ui.f.C(((ald)localObject).GCQ / 100.0D));
          }
          for (;;)
          {
            findViewById(2131299860).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68020);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                com.tencent.mm.plugin.report.service.g.yxI.f(15235, new Object[] { Integer.valueOf(3) });
                if (RemittanceBusiUI.n(RemittanceBusiUI.this) == 56) {
                  com.tencent.mm.plugin.report.service.g.yxI.f(19821, new Object[] { Integer.valueOf(7), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
                }
                RemittanceBusiUI.J(RemittanceBusiUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68020);
              }
            });
            bool = true;
            break;
            localObject = this.ysQ.dME();
            if (!bu.isNullOrNil((String)localObject))
            {
              this.ysj.setTextColor(getContext().getResources().getColor(2131100212));
              this.ysj.setText((CharSequence)localObject);
            }
          }
        }
      }
      bool = false;
    }
  }
  
  private void dNb()
  {
    AppMethodBeat.i(163833);
    hideLoading();
    if (this.yta != null) {
      this.yta.hideProgress();
    }
    AppMethodBeat.o(163833);
  }
  
  private void dNc()
  {
    AppMethodBeat.i(68076);
    ae.i("MicroMsg.RemittanceBusiUI", "unLockFavorimp");
    ald localald = this.ysQ.ypG;
    if (localald == null)
    {
      ae.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor FavorComposeInfo is null");
      AppMethodBeat.o(68076);
      return;
    }
    int i = (int)Math.round(this.ysu * 100.0D);
    dk localdk = new dk();
    localdk.channel = this.mChannel;
    localdk.FOf = this.yrz;
    localdk.FOg = this.wNH;
    localdk.yns = this.yrI.yns;
    localdk.scene = this.mPayScene;
    localdk.FOh = this.yrE;
    localdk.FOi = localald;
    localdk.iWC = this.ysv;
    localdk.yoT = this.yqB;
    localdk.FOj = i;
    doSceneProgress(new com.tencent.mm.plugin.remittance.model.k(localdk, this.ysR), false);
    AppMethodBeat.o(68076);
  }
  
  private void dNd()
  {
    AppMethodBeat.i(68078);
    ae.i("MicroMsg.RemittanceBusiUI", "goto busi result");
    Object localObject = new Intent(this, RemittanceBusiResultUI.class);
    ((Intent)localObject).putExtra("key_pay_desc", this.yrA);
    ((Intent)localObject).putExtra("key_rcv_desc", this.ysy);
    if (this.yrI != null) {
      ((Intent)localObject).putExtra("BusiRemittanceResp", this.yrI);
    }
    ((Intent)localObject).putExtra("key_mch_name", this.ypW);
    ((Intent)localObject).putExtra("key_rcver_name", this.ysv);
    ((Intent)localObject).putExtra("key_rcver_true_name", this.ysw);
    if (this.dmz >= 0.0D) {
      ((Intent)localObject).putExtra("key_money", this.dmz);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_f2f_id", this.yrz);
      ((Intent)localObject).putExtra("key_trans_id", this.wNH);
      ((Intent)localObject).putExtra("key_check_sign", this.yrE);
      ((Intent)localObject).putExtra("key_rcvr_open_id", this.yqB);
      ((Intent)localObject).putExtra("key_channel", this.mChannel);
      ((Intent)localObject).putExtra("key_succ_fault_config", this.ysO);
      if (this.yrI != null)
      {
        ((Intent)localObject).putExtra("key_succ_show_avatar_type", this.yrI.yny);
        ((Intent)localObject).putExtra("key_succ_show_avatar_show", this.yrI.ynp);
        ((Intent)localObject).putExtra("key_succ_show_avatar_url", this.yrI.ynq);
      }
      if (this.yrI != null) {
        ((Intent)localObject).putExtra("key_scan_sceen", this.yrI.yns);
      }
      ((Intent)localObject).putExtra("key_succ_page_extend", this.ysS);
      if (this.mChannel == 56) {
        ((Intent)localObject).putExtra("app_id", this.app_id);
      }
      ald localald = this.ysQ.ypG;
      int i = (int)Math.round(this.ysu * 100.0D);
      dk localdk = new dk();
      localdk.channel = this.mChannel;
      localdk.FOf = this.yrz;
      localdk.FOg = this.wNH;
      localdk.yns = this.yrI.yns;
      localdk.scene = this.mPayScene;
      localdk.FOh = this.yrE;
      localdk.FOi = localald;
      localdk.iWC = this.ysv;
      localdk.yoT = this.yqB;
      localdk.FOj = i;
      try
      {
        ((Intent)localObject).putExtra("AfterPlaceOrderCommReq", localdk.toByteArray());
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI", "gotoBusiResultUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI", "gotoBusiResultUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        if (e.dMU().dMV()) {
          ae.w("MicroMsg.RemittanceBusiUI", "finish finishRemitF2fDCodeAndLMRemindUI");
        }
        AppMethodBeat.o(68078);
        return;
        ((Intent)localObject).putExtra("key_money", this.ysu);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.RemittanceBusiUI", localException, "", new Object[0]);
        }
      }
    }
  }
  
  private void fz(final List<ale> paramList)
  {
    AppMethodBeat.i(68068);
    final com.tencent.mm.ui.widget.picker.e locale = new com.tencent.mm.ui.widget.picker.e(this);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = this.ysQ.ypG;
    Object localObject1 = new HashSet();
    final HashSet localHashSet = new HashSet();
    if ((this.ysQ.dMG()) && (localObject2 != null))
    {
      localObject2 = ((ald)localObject2).GdG.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((HashSet)localObject1).add(Long.valueOf(((ale)((Iterator)localObject2).next()).GCX));
      }
    }
    localObject2 = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      if (((HashSet)localObject1).contains(Long.valueOf(((ale)((Iterator)localObject2).next()).GCX))) {
        localArrayList.add(Integer.valueOf(i));
      }
      i += 1;
    }
    localObject1 = getString(2131762485);
    if ((localObject1 != null) && (((CharSequence)localObject1).length() > 0))
    {
      locale.LxA.setVisibility(0);
      locale.ASX.setText((CharSequence)localObject1);
    }
    locale.LxB = localArrayList;
    locale.LfS = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(68024);
        RemittanceBusiUI.a(RemittanceBusiUI.this, RemittanceBusiUI.q(RemittanceBusiUI.this));
        ale localale;
        if ((!RemittanceBusiUI.K(RemittanceBusiUI.this).dMG()) || (RemittanceBusiUI.r(RemittanceBusiUI.this) <= 0.0D))
        {
          localIterator = paramList.iterator();
          i = 0;
          while (localIterator.hasNext())
          {
            localale = (ale)localIterator.next();
            paramAnonymousl.a(i, localale.GCY, localale.GDa, null, true);
            localHashSet.add(Integer.valueOf(i));
            i += 1;
          }
          AppMethodBeat.o(68024);
          return;
        }
        Iterator localIterator = paramList.iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          localale = (ale)localIterator.next();
          if (localale.GDg == 1)
          {
            paramAnonymousl.a(i, localale.GCY, localale.GDa, null, true);
            localHashSet.add(Integer.valueOf(i));
          }
          for (;;)
          {
            i += 1;
            break;
            paramAnonymousl.a(i, localale.GCY, localale.GDa, 0);
          }
        }
        AppMethodBeat.o(68024);
      }
    };
    locale.LfT = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        int i = 1;
        int j = 0;
        AppMethodBeat.i(68026);
        if (localHashSet.contains(Integer.valueOf(paramAnonymousInt)))
        {
          AppMethodBeat.o(68026);
          return;
        }
        if (paramAnonymousInt < paramList.size())
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(15235, new Object[] { Integer.valueOf(4) });
          Object localObject1 = (ale)paramList.get(paramAnonymousInt);
          paramAnonymousMenuItem = locale;
          boolean bool;
          if (paramAnonymousMenuItem.LxC != null)
          {
            paramAnonymousMenuItem = paramAnonymousMenuItem.LxC.fRj();
            bool = paramAnonymousMenuItem.contains(Integer.valueOf(paramAnonymousInt));
            if (bool) {
              break label214;
            }
          }
          for (;;)
          {
            localObject2 = new LinkedList();
            paramAnonymousMenuItem = paramAnonymousMenuItem.iterator();
            while (paramAnonymousMenuItem.hasNext())
            {
              int k = ((Integer)paramAnonymousMenuItem.next()).intValue();
              if ((k < paramList.size()) && ((i != 0) || (paramAnonymousInt != k))) {
                ((List)localObject2).add((ale)paramList.get(k));
              }
            }
            paramAnonymousMenuItem = new ArrayList();
            break;
            label214:
            i = 0;
          }
          if (i != 0) {
            ((List)localObject2).add(localObject1);
          }
          b localb = RemittanceBusiUI.K(RemittanceBusiUI.this);
          if (i != 0) {}
          for (paramAnonymousMenuItem = (MenuItem)localObject1;; paramAnonymousMenuItem = null)
          {
            localb.a((List)localObject2, paramAnonymousMenuItem);
            localObject1 = RemittanceBusiUI.K(RemittanceBusiUI.this).ypG;
            paramAnonymousMenuItem = new HashSet();
            if (localObject1 == null) {
              break;
            }
            localObject1 = ((ald)localObject1).GdG.iterator();
            while (((Iterator)localObject1).hasNext()) {
              paramAnonymousMenuItem.add(Long.valueOf(((ale)((Iterator)localObject1).next()).GCX));
            }
          }
          localObject1 = new HashMap();
          Object localObject2 = paramList.iterator();
          i = j;
          if (((Iterator)localObject2).hasNext())
          {
            if (paramAnonymousMenuItem.contains(Long.valueOf(((ale)((Iterator)localObject2).next()).GCX))) {
              ((HashMap)localObject1).put(Integer.valueOf(i), Boolean.TRUE);
            }
            for (;;)
            {
              if (i == paramAnonymousInt) {
                ((HashMap)localObject1).put(Integer.valueOf(i), Boolean.valueOf(bool));
              }
              i += 1;
              break;
              ((HashMap)localObject1).put(Integer.valueOf(i), Boolean.FALSE);
            }
          }
          paramAnonymousMenuItem = locale;
          if (paramAnonymousMenuItem.LxC != null)
          {
            paramAnonymousMenuItem.LxC.LxF = ((HashMap)localObject1);
            paramAnonymousMenuItem.LxC.notifyDataSetChanged();
          }
        }
        AppMethodBeat.o(68026);
      }
    };
    locale.LxD = new e.b()
    {
      public final void qt(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(68027);
        if (paramAnonymousBoolean)
        {
          localObject = RemittanceBusiUI.K(RemittanceBusiUI.this).ypG;
          if (localObject != null) {
            break label56;
          }
        }
        label56:
        for (Object localObject = "";; localObject = com.tencent.mm.plugin.remittance.model.a.a((ald)localObject))
        {
          ae.i("MicroMsg.RemittanceBusiUI", "onFavorSelected %s ", new Object[] { localObject });
          RemittanceBusiUI.L(RemittanceBusiUI.this);
          AppMethodBeat.o(68027);
          return;
        }
      }
    };
    if (locale.LfS != null) {
      locale.LfS.onCreateMMMenu(locale.ECx);
    }
    locale.LxC = new e.a(locale, locale.mContext);
    locale.LxC.fRi();
    locale.Lxz.setAdapter(locale.LxC);
    locale.gXc.setOnClickListener(new e.2(locale));
    locale.gZv.setOnClickListener(new e.3(locale));
    if (locale.uNn != null)
    {
      if ((locale.ECx != null) && (locale.ECx.size() > 3))
      {
        paramList = (FrameLayout.LayoutParams)locale.kFh.getLayoutParams();
        paramList.height = locale.lEa;
        locale.kFh.setLayoutParams(paramList);
      }
      locale.uNn.show();
    }
    AppMethodBeat.o(68068);
  }
  
  private void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(68088);
    if (this.ymE != null) {
      this.ymE.zx(paramBoolean);
    }
    AppMethodBeat.o(68088);
  }
  
  public final void a(int paramInt, i parami)
  {
    AppMethodBeat.i(163835);
    ab localab = new ab();
    localab.dTY = paramInt;
    if (parami != null)
    {
      localab.hd(parami.ynL.FOf);
      localab.he(this.yst);
      localab.dWb = parami.xdJ;
    }
    localab.aLH();
    AppMethodBeat.o(163835);
  }
  
  public final void bv(float paramFloat)
  {
    AppMethodBeat.i(68065);
    if (this.uSG != null)
    {
      this.ysC = paramFloat;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.uSG.getLayoutParams();
      localLayoutParams.bottomMargin = ((int)paramFloat);
      ae.d("MicroMsg.RemittanceBusiUI", "onUpdateWcPayKeyboardHeight() height: %s rootView.height: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(localLayoutParams.height) });
      this.uSG.setLayoutParams(localLayoutParams);
      com.tencent.mm.ui.tools.p.a(this, this.uSG, findViewById(2131304051), findViewById(2131304051), findViewById(2131304050), paramFloat);
    }
    AppMethodBeat.o(68065);
  }
  
  public int getLayoutId()
  {
    return 2131495252;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68063);
    hideActionbarLine();
    this.uSG = ((ScrollView)findViewById(2131304251));
    this.ysd = ((TextView)findViewById(2131304008));
    this.yse = ((TextView)findViewById(2131304009));
    this.ysf = ((TextView)findViewById(2131304005));
    this.ysg = ((TextView)findViewById(2131304002));
    this.ysh = ((TextView)findViewById(2131303996));
    this.ysi = ((TextView)findViewById(2131303994));
    this.ysl = ((CdnImageView)findViewById(2131304006));
    this.ymL = ((WalletFormView)findViewById(2131304007));
    this.ysm = ((LinearLayout)findViewById(2131304003));
    this.yqm = ((LinearLayout)findViewById(2131303998));
    this.yss = ((RelativeLayout)findViewById(2131306754));
    this.ysn = ((LinearLayout)findViewById(2131303997));
    this.ysj = ((TextView)findViewById(2131299864));
    this.ysk = findViewById(2131303999);
    this.yso = ((TextView)findViewById(2131304001));
    this.ysp = findViewById(2131299968);
    this.ysq = ((TextView)findViewById(2131299967));
    this.ysr = ((Button)findViewById(2131304004));
    this.ymE = ((WcPayKeyboard)findViewById(2131307020));
    ImageView localImageView;
    label536:
    label680:
    boolean bool1;
    if (this.ysD)
    {
      if (!bu.isNullOrNil(this.ysy)) {
        this.ysf.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, this.ysy, this.ysf.getTextSize()));
      }
      this.ysg.setText(com.tencent.mm.wallet_core.ui.f.C(this.ysu));
      this.ysm.setVisibility(0);
      this.yqm.setVisibility(8);
      this.yss.setVisibility(8);
      this.ysr.setVisibility(0);
      if (com.tencent.mm.kernel.g.ajM())
      {
        com.tencent.mm.kernel.g.ajS();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(this.ysv);
        if ((localObject == null) || ((int)((com.tencent.mm.contact.c)localObject).ght == 0)) {
          au.a.hIG.a(this.ysv, "", new au.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(68044);
              ae.i("MicroMsg.RemittanceBusiUI", "getContact %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              RemittanceBusiUI.l(RemittanceBusiUI.this);
              AppMethodBeat.o(68044);
            }
          });
        }
      }
      dMP();
      this.ysn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68048);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (!RemittanceBusiUI.m(RemittanceBusiUI.this)) {
            RemittanceBusiUI.this.showCircleStWcKb();
          }
          com.tencent.mm.plugin.report.service.g.yxI.f(15235, new Object[] { Integer.valueOf(6) });
          if (RemittanceBusiUI.n(RemittanceBusiUI.this) == 56) {
            com.tencent.mm.plugin.report.service.g.yxI.f(19821, new Object[] { Integer.valueOf(6), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
          }
          com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBusiUI.this, RemittanceBusiUI.this.getString(2131762421), RemittanceBusiUI.o(RemittanceBusiUI.this), RemittanceBusiUI.this.getString(2131762424), true, 20, new h.b()new DialogInterface.OnClickListener
          {
            public final boolean onFinish(CharSequence paramAnonymous2CharSequence)
            {
              AppMethodBeat.i(68045);
              RemittanceBusiUI.a(RemittanceBusiUI.this, paramAnonymous2CharSequence.toString());
              RemittanceBusiUI.p(RemittanceBusiUI.this);
              AppMethodBeat.o(68045);
              return true;
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(68047);
              ar.o(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(68046);
                  RemittanceBusiUI.this.hideVKB();
                  AppMethodBeat.o(68046);
                }
              }, 500L);
              AppMethodBeat.o(68047);
            }
          });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68048);
        }
      });
      Object localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68051);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          com.tencent.mm.plugin.report.service.g.yxI.f(15235, new Object[] { Integer.valueOf(5) });
          if (RemittanceBusiUI.n(RemittanceBusiUI.this) == 56) {
            com.tencent.mm.plugin.report.service.g.yxI.f(19821, new Object[] { Integer.valueOf(8), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
          }
          if (!RemittanceBusiUI.m(RemittanceBusiUI.this)) {
            RemittanceBusiUI.a(RemittanceBusiUI.this, RemittanceBusiUI.q(RemittanceBusiUI.this));
          }
          if (RemittanceBusiUI.r(RemittanceBusiUI.this) <= 0.0D)
          {
            t.makeText(RemittanceBusiUI.this.getContext(), 2131765031, 0).show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68051);
            return;
          }
          localObject = RemittanceBusiUI.this.ysV;
          if (RemittanceBusiUI.this.ysV == null)
          {
            paramAnonymousView = "";
            ae.i("MicroMsg.RemittanceBusiUI", "mPayBtn onClick %s  isFinish:%s getFavorFlag: %s", new Object[] { localObject, paramAnonymousView, Boolean.valueOf(RemittanceBusiUI.this.ysT) });
            if (RemittanceBusiUI.j(RemittanceBusiUI.this) != 32) {
              break label410;
            }
            if (!RemittanceBusiUI.this.ysT) {
              break label400;
            }
            if ((RemittanceBusiUI.this.ysV == null) || (RemittanceBusiUI.this.ysV.ymj != (int)(RemittanceBusiUI.r(RemittanceBusiUI.this) * 100.0D))) {
              break label381;
            }
            if ((RemittanceBusiUI.this.ysV != null) && (RemittanceBusiUI.this.ysV.ynI)) {
              break label410;
            }
            if (RemittanceBusiUI.this.ysV != null) {
              RemittanceBusiUI.this.ysV.ynG = new com.tencent.mm.plugin.remittance.model.c()
              {
                public final void fy(List<ale> paramAnonymous2List)
                {
                  AppMethodBeat.i(68049);
                  RemittanceBusiUI.s(RemittanceBusiUI.this);
                  AppMethodBeat.o(68049);
                }
              };
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68051);
            return;
            paramAnonymousView = RemittanceBusiUI.this.ysV.ynI;
            break;
            label381:
            RemittanceBusiUI.a(RemittanceBusiUI.this, new com.tencent.mm.plugin.remittance.model.c()
            {
              public final void fy(List<ale> paramAnonymous2List)
              {
                AppMethodBeat.i(68050);
                RemittanceBusiUI.s(RemittanceBusiUI.this);
                AppMethodBeat.o(68050);
              }
            }, 0);
            continue;
            label400:
            RemittanceBusiUI.s(RemittanceBusiUI.this);
            continue;
            label410:
            RemittanceBusiUI.s(RemittanceBusiUI.this);
          }
        }
      };
      this.ymL.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(68052);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66))
          {
            ae.i("MicroMsg.RemittanceBusiUI", "click enter");
            this.ynf.onClick(null);
            AppMethodBeat.o(68052);
            return true;
          }
          AppMethodBeat.o(68052);
          return true;
        }
      });
      localImageView = (ImageView)findViewById(2131306750);
      if (al.isDarkMode())
      {
        findViewById(2131306755).setVisibility(8);
        findViewById(2131306752).setVisibility(0);
        localImageView.setBackgroundResource(2131234672);
        this.ysr.setOnClickListener((View.OnClickListener)localObject);
        this.uSG.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(68015);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
            if ((RemittanceBusiUI.t(RemittanceBusiUI.this) != null) && (RemittanceBusiUI.u(RemittanceBusiUI.this).isShown()) && (RemittanceBusiUI.v(RemittanceBusiUI.this).fVs()))
            {
              RemittanceBusiUI.w(RemittanceBusiUI.this).fVq();
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(68015);
              return true;
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(68015);
            return false;
          }
        });
        setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
        {
          public final void onVisibleStateChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(68016);
            RemittanceBusiUI.a(RemittanceBusiUI.this, paramAnonymousBoolean);
            if (!paramAnonymousBoolean)
            {
              RemittanceBusiUI.x(RemittanceBusiUI.this).scrollTo(0, 0);
              if ((RemittanceBusiUI.c(RemittanceBusiUI.this) != null) && (RemittanceBusiUI.c(RemittanceBusiUI.this).getVisibility() == 0))
              {
                RemittanceBusiUI.c(RemittanceBusiUI.this).setFocusable(false);
                RemittanceBusiUI.c(RemittanceBusiUI.this).setFocusable(true);
              }
            }
            AppMethodBeat.o(68016);
          }
        });
        this.ymO = ((RelativeLayout)findViewById(2131306751));
        if ((!ad.fom().equals("zh_CN")) && (!ad.fom().equals("zh_TW")) && (!ad.fom().equals("zh_HK"))) {
          break label993;
        }
        this.ymM = ((RelativeLayout)findViewById(2131306753));
        this.ymN = ((TextView)findViewById(2131306756));
        this.ymM.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68017);
            RemittanceBusiUI.a(RemittanceBusiUI.this, RemittanceBusiUI.y(RemittanceBusiUI.this).getWidth());
            RemittanceBusiUI.z(RemittanceBusiUI.this).setVisibility(8);
            ae.d("MicroMsg.RemittanceBusiUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(RemittanceBusiUI.A(RemittanceBusiUI.this)) });
            AppMethodBeat.o(68017);
          }
        });
        this.ymL.setmWalletFormViewListener(new WalletFormView.c()
        {
          public final void p(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(68018);
            if (bu.jB(RemittanceBusiUI.B(RemittanceBusiUI.this), 0))
            {
              ae.i("MicroMsg.RemittanceBusiUI", "mAmountRemindBit == 0");
              RemittanceBusiUI.z(RemittanceBusiUI.this).setVisibility(8);
              AppMethodBeat.o(68018);
              return;
            }
            long l = Double.valueOf(bu.getDouble(paramAnonymousCharSequence.toString(), 0.0D)).longValue();
            int j = 0;
            int i = 0;
            while (l != 0L)
            {
              j = (int)(l % 10L);
              l /= 10L;
              i += 1;
            }
            if (i >= RemittanceBusiUI.B(RemittanceBusiUI.this))
            {
              j = RemittanceBusiUI.c(RemittanceBusiUI.this).j(paramAnonymousCharSequence, RemittanceBusiUI.A(RemittanceBusiUI.this), j);
              if (j != 0)
              {
                RemittanceBusiUI.z(RemittanceBusiUI.this).setVisibility(0);
                paramAnonymousCharSequence = ag.aQ(ak.getContext(), i);
                RemittanceBusiUI.C(RemittanceBusiUI.this).setText(paramAnonymousCharSequence);
                paramAnonymousCharSequence = (RelativeLayout.LayoutParams)RemittanceBusiUI.y(RemittanceBusiUI.this).getLayoutParams();
                paramAnonymousCharSequence.leftMargin = j;
                RemittanceBusiUI.y(RemittanceBusiUI.this).setLayoutParams(paramAnonymousCharSequence);
                AppMethodBeat.o(68018);
                return;
              }
              RemittanceBusiUI.z(RemittanceBusiUI.this).setVisibility(8);
              AppMethodBeat.o(68018);
              return;
            }
            RemittanceBusiUI.z(RemittanceBusiUI.this).setVisibility(8);
            AppMethodBeat.o(68018);
          }
        });
        if ((this.yrI != null) && (this.yrI.ynw != null))
        {
          this.ysQ.ypH = this.yrI.ynw;
          this.ysQ.axI(this.yrI.ynw.GdI);
        }
        if (dNa()) {
          com.tencent.mm.plugin.report.service.g.yxI.f(15235, new Object[] { Integer.valueOf(2) });
        }
        AppMethodBeat.o(68063);
      }
    }
    else
    {
      if (this.yrI == null) {
        break label1010;
      }
      if (this.yrI.ynv.size() <= 0) {
        break label1005;
      }
      bool1 = false;
      label786:
      bool2 = bool1;
      if (this.yrI.ynw != null)
      {
        bool2 = bool1;
        if (this.yrI.ynw.GdG.size() <= 0) {}
      }
    }
    label993:
    label1005:
    label1010:
    for (boolean bool2 = false;; bool2 = true)
    {
      this.ysr.setVisibility(8);
      setWPKeyboard(this.ymL.getContentEt(), bool2, true);
      this.ymL.setmContentAbnormalMoneyCheck(true);
      if (com.tencent.mm.compatible.util.d.lA(28)) {
        this.ymL.getContentEt().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68042);
            RemittanceBusiUI.c(RemittanceBusiUI.this).getContentEt().requestFocus();
            AppMethodBeat.o(68042);
          }
        });
      }
      this.ymE.setActionText(getString(2131762434));
      setWcKbHeightListener(this);
      ((RelativeLayout.LayoutParams)this.ymE.getLayoutParams()).addRule(12);
      this.ymL.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(68043);
          RemittanceBusiUI.i(RemittanceBusiUI.this);
          if (RemittanceBusiUI.j(RemittanceBusiUI.this) == 32)
          {
            paramAnonymousEditable = RemittanceBusiUI.this;
            if (RemittanceBusiUI.k(RemittanceBusiUI.this) != null) {
              break label55;
            }
          }
          label55:
          for (int i = 400;; i = RemittanceBusiUI.k(RemittanceBusiUI.this).ynB)
          {
            RemittanceBusiUI.a(paramAnonymousEditable, null, i);
            AppMethodBeat.o(68043);
            return;
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.ymL.fWD();
      this.ysm.setVisibility(8);
      this.yqm.setVisibility(0);
      this.yss.setVisibility(0);
      break;
      findViewById(2131306755).setVisibility(0);
      findViewById(2131306752).setVisibility(8);
      localImageView.setBackgroundResource(2131234671);
      break label536;
      this.ymO.setVisibility(8);
      break label680;
      bool1 = true;
      break label786;
    }
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(68062);
    if (this.mKindaEnable)
    {
      if ((!this.ysY) && (!this.ysD) && (this.ymE.fVu()))
      {
        AppMethodBeat.o(68062);
        return true;
      }
      AppMethodBeat.o(68062);
      return false;
    }
    if ((!this.ysD) && (this.ymE.fVu()))
    {
      AppMethodBeat.o(68062);
      return true;
    }
    AppMethodBeat.o(68062);
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(68072);
    ae.i("MicroMsg.RemittanceBusiUI", "onActivityResult requestCode %s resultCode %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    if (paramInt1 == 3)
    {
      if (this.yta != null)
      {
        this.yta.hideProgress();
        this.yta = null;
      }
      if (paramInt2 == -1) {
        a(bool1, paramIntent);
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(68072);
      return;
      bool1 = false;
      break;
      if (paramInt1 == 1)
      {
        if (paramInt2 == -1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          a(bool1, paramIntent);
          break;
        }
      }
      if (paramInt1 == 2)
      {
        if (paramInt2 == -1)
        {
          String str = paramIntent.getStringExtra("INTENT_RESULT_TOKEN");
          this.ysJ = str;
          this.dmz = 0.0D;
          ae.i("MicroMsg.RemittanceBusiUI", "onActivityResult _result_token: %s", new Object[] { str });
          B(false, paramIntent.getStringExtra("INTENT_REQKEY"));
        }
        else
        {
          dNc();
        }
      }
      else if (paramInt1 == 4) {
        this.ytd = true;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68058);
    super.onCreate(paramBundle);
    if (getIntent().getIntExtra("pay_channel", 0) == 56)
    {
      overridePendingTransition(2130772144, 2130772141);
      this.app_id = getIntent().getStringExtra("app_id");
      com.tencent.mm.plugin.report.service.g.yxI.f(19821, new Object[] { Integer.valueOf(4), this.app_id, Integer.valueOf(0) });
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(15235, new Object[] { Integer.valueOf(1) });
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131100705)));
    paramBundle = getSupportActionBar().getCustomView();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.findViewById(16908308);
      if ((paramBundle != null) && ((paramBundle instanceof TextView))) {
        ((TextView)paramBundle).setTextColor(getResources().getColor(2131100711));
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(2131100705));
    }
    if ((com.tencent.mm.compatible.util.d.lA(21)) && (!com.tencent.mm.compatible.util.d.lA(23))) {
      getWindow().setStatusBarColor(getContext().getResources().getColor(2131099679));
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(68035);
        if (RemittanceBusiUI.h(RemittanceBusiUI.this))
        {
          RemittanceBusiUI.this.hideVKB();
          RemittanceBusiUI.this.showDialog(1000);
        }
        for (;;)
        {
          AppMethodBeat.o(68035);
          return true;
          RemittanceBusiUI.this.finish();
        }
      }
    }, 2131689490);
    addSceneEndListener(1633);
    addSceneEndListener(1241);
    addSceneEndListener(2677);
    addSceneEndListener(2504);
    addSceneEndListener(2702);
    addSceneEndListener(2682);
    regeistQueryOrder(2682, this.yti);
    setMMTitle(2131762434);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(68014);
        RemittanceBusiUI.e(RemittanceBusiUI.this);
        if (RemittanceBusiUI.this.getIntent().getIntExtra("pay_channel", 0) == 56)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(19821, new Object[] { Integer.valueOf(5), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
          RemittanceBusiUI.dNe();
        }
        RemittanceBusiUI.this.finish();
        AppMethodBeat.o(68014);
        return false;
      }
    });
    this.dAa = UUID.randomUUID().toString();
    com.tencent.mm.plugin.wallet.pay.a.b.aFw(this.dAa);
    this.mPayScene = getIntent().getIntExtra("pay_scene", 31);
    this.yst = getIntent().getStringExtra("scan_remittance_id");
    this.ysu = getIntent().getDoubleExtra("fee", 0.0D);
    this.ysv = getIntent().getStringExtra("receiver_name");
    this.ysw = getIntent().getStringExtra("receiver_true_name");
    this.ysx = getIntent().getStringExtra("receiver_true_name_busi");
    this.mChannel = getIntent().getIntExtra("pay_channel", 0);
    this.ysy = getIntent().getStringExtra("desc");
    this.ysA = getIntent().getIntExtra("busi_type", 0);
    this.ypW = getIntent().getStringExtra("mch_name");
    this.ysE = getIntent().getStringExtra("mch_type");
    this.ysG = getIntent().getIntExtra("mch_time", 0);
    this.ysB = getIntent().getStringExtra("mch_info");
    this.ysF = getIntent().getIntExtra("get_pay_wifi", 0);
    this.yqB = getIntent().getStringExtra("rcvr_open_id");
    this.ysz = getIntent().getStringExtra("rcvr_ticket");
    this.ymv = getIntent().getIntExtra("amount_remind_bit", 4);
    this.ysP = getIntent().getStringExtra("receiver_tips");
    this.yrI = ((BusiRemittanceResp)getIntent().getParcelableExtra("BusiRemittanceResp"));
    boolean bool;
    if (this.yrI != null) {
      if ((this.mPayScene == 32) && ((this.yrI.ynx == 1) || ((this.yrI != null) && (this.yrI.ynv.size() > 0))))
      {
        bool = true;
        this.ysT = bool;
        if (this.ysu <= 0.0D) {
          break label851;
        }
      }
    }
    label851:
    for (this.ysD = true;; this.ysD = false)
    {
      if (this.ysA == 0)
      {
        ae.w("MicroMsg.RemittanceBusiUI", "wrong busi type!");
        finish();
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(15386, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
      this.ysW = new b(32, 32, 6.0F);
      this.ysX = new b(56, 56, 8.0F);
      initView();
      dEy();
      this.ypC.alive();
      this.ytr.alive();
      if (!this.ysD) {
        this.state = 1;
      }
      AppMethodBeat.o(68058);
      return;
      bool = false;
      break;
      ae.w("MicroMsg.RemittanceBusiUI", "busi resp is null, maybe recreate activity!!");
      finish();
      AppMethodBeat.o(68058);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68070);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.IvT.d(this.yqQ);
    com.tencent.mm.sdk.b.a.IvT.d(this.ytq);
    com.tencent.mm.sdk.b.a.IvT.d(this.yto);
    this.ytp.dead();
    removeSceneEndListener(1633);
    removeSceneEndListener(1241);
    removeSceneEndListener(2677);
    removeSceneEndListener(2504);
    removeSceneEndListener(2702);
    removeSceneEndListener(2682);
    this.ypC.dead();
    this.ytr.dead();
    com.tencent.mm.plugin.wallet.pay.a.b.aFx(this.dAa);
    ar.ay(this.ync);
    AppMethodBeat.o(68070);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(68061);
    ae.i("MicroMsg.RemittanceBusiUI", "onDialogDismiss()");
    ar.o(this.ync, 300L);
    AppMethodBeat.o(68061);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68064);
    if ((this.ymE != null) && (this.ymE.onKeyUp(paramInt, paramKeyEvent)))
    {
      AppMethodBeat.o(68064);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(68064);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(68082);
    ae.v("MicroMsg.RemittanceBusiUI", "onNewIntent");
    AppMethodBeat.o(68082);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68060);
    super.onPause();
    ae.i("MicroMsg.RemittanceBusiUI", "onPause()");
    if ((!this.ysD) && (!this.ymE.fVt())) {
      this.state = 3;
    }
    AppMethodBeat.o(68060);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68059);
    super.onResume();
    ae.i("MicroMsg.RemittanceBusiUI", "onResume()");
    e.dMU().gi(this);
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      showNormalStWcKb();
    }
    if (!this.ysD) {
      this.state = 2;
    }
    AppMethodBeat.o(68059);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, final n paramn)
  {
    AppMethodBeat.i(68071);
    Object localObject1;
    boolean bool;
    label326:
    label371:
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((paramn instanceof i))
    {
      paramString = (i)paramn;
      if ((!this.mKindaEnable) || (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_QRCODE_RECEIVE_PAY_SWTICH_KEY")))
      {
        localObject1 = e.dMU();
        ae.w("MicroMsg.RemittanceBusiDialogMgr", "hideProgress()");
        localObject1 = (Context)((e)localObject1).cyH.get();
        if (localObject1 == null) {
          ae.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
        }
      }
      else
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label1626;
        }
        if (paramString.ynL.oGt != 0) {
          break label1431;
        }
        this.ytg = paramString;
        this.yrz = paramString.ynL.FOf;
        this.wNH = paramString.ynL.FOg;
        this.yrE = paramString.ynL.FOh;
        this.ysR = paramString.ynL.Gef;
        this.ysS = paramString.ynL.Gee;
        this.ysH = paramString.ynL.Gek;
        this.ysI = paramString.ynL.Gej;
        this.ysK = paramString.ynL.Gen;
        this.ysL = paramString.ynL.Gel;
        this.ysM = paramString.ynL.Gem;
        this.ysO = i.a(paramString.ynL.Ges).toString();
        ae.i("MicroMsg.RemittanceBusiUI", "touch_challenge: %s need_change_auth_key: %s mBusiF2FFaultConfig: %s", new Object[] { paramString.ynL.Geo, Integer.valueOf(paramString.ynL.Gep), this.ysO });
        if (paramString.ynL.Geo != null) {
          com.tencent.mm.plugin.fingerprint.b.p.tse.trY = paramString.ynL.Geo.fjO();
        }
        paramn = com.tencent.mm.plugin.fingerprint.b.p.tse;
        if (paramString.ynL.Gep != 1) {
          break label594;
        }
        bool = true;
        paramn.tsg = bool;
        if (a(paramString)) {
          break label1424;
        }
        ae.i("MicroMsg.RemittanceBusiUI", "showNameVerifyDialog");
        if (paramString.ynL.Gev != null) {
          break label600;
        }
        ae.e("MicroMsg.RemittanceBusiUI", "orderScene.response.check_recv_name_win is null");
        paramInt1 = 0;
        if (paramInt1 == 0)
        {
          if (paramString.ynL.Get == null) {
            break label1266;
          }
          ae.i("MicroMsg.RemittanceBusiUI", "showMoneyRemind amount_remind_win");
          dNb();
          if ((e.dMU().getContext() != null) && ((e.dMU().getContext() instanceof RemittanceBusiUI))) {
            this.ytc = paramString.ynL.Get.FOq;
          }
          paramn = e.dMU();
          localObject2 = paramString.ynL.Get;
          paramInt1 = this.ymv;
          localObject3 = new a(paramString) {};
          localObject4 = new a(paramString) {};
          ae.w("MicroMsg.RemittanceBusiDialogMgr", "showAmountRemindWin() amountRemindBit:%s", new Object[] { Integer.valueOf(paramInt1) });
          paramn = (Context)paramn.cyH.get();
          if (paramn != null) {
            break label925;
          }
          ae.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
          label521:
          if (e.dMU().getContext() != null)
          {
            if (!(e.dMU().getContext() instanceof RemittanceBusiUI)) {
              break label1244;
            }
            a(1, paramString);
          }
          label548:
          paramInt1 = 1;
          label550:
          if (paramInt1 == 0) {
            d(paramString);
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(68071);
      return false;
      if (((localObject1 instanceof RemittanceBusiUI)) || (!(localObject1 instanceof WalletBaseUI))) {
        break;
      }
      ((WalletBaseUI)localObject1).hideProgress();
      break;
      label594:
      bool = false;
      break label326;
      label600:
      showCircleStWcKb();
      dNb();
      localObject4 = paramString.ynL.Gev.title;
      Object localObject6 = paramString.ynL.Gev.dyI;
      Object localObject7 = paramString.ynL.Gev.GpN;
      localObject2 = paramString.ynL.Gev.DFA.dyI;
      localObject3 = paramString.ynL.Gev.DFB.dyI;
      paramn = new c(this);
      paramn.ypK = new c.a()
      {
        public final void axB(final String paramAnonymousString)
        {
          AppMethodBeat.i(174427);
          ae.i("MicroMsg.RemittanceBusiUI", "showNameVerifyDialog onINputName() name:%s", new Object[] { paramAnonymousString });
          RemittanceBusiUI.this.hideVKB();
          com.tencent.mm.plugin.report.service.g.yxI.f(19229, new Object[] { Integer.valueOf(0), Integer.valueOf(paramString.ynL.Gev.GpO), Integer.valueOf(0), RemittanceBusiUI.Y(RemittanceBusiUI.this) });
          com.tencent.mm.wallet_core.c.l.a(RemittanceBusiUI.this, paramString.ynL.Gev.DFB, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dG(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(174422);
              ae.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog right button click jumpItem.action:continue");
              RemittanceBusiUI.a(RemittanceBusiUI.this, paramAnonymousString, RemittanceBusiUI.35.this.ytw.ynL.Gev.Geb);
              AppMethodBeat.o(174422);
            }
            
            public final void dMp()
            {
              AppMethodBeat.i(174423);
              ae.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog right button click jumpItem.action:close");
              AppMethodBeat.o(174423);
            }
            
            public final void dMw()
            {
              AppMethodBeat.i(174421);
              ae.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog right button click jumpItem.action:exit");
              RemittanceBusiUI.Z(RemittanceBusiUI.this);
              AppMethodBeat.o(174421);
            }
          });
          AppMethodBeat.o(174427);
        }
        
        public final void onCancel()
        {
          AppMethodBeat.i(174428);
          ae.i("MicroMsg.RemittanceBusiUI", "showNameVerifyDialog onCancel()");
          RemittanceBusiUI.this.hideVKB();
          com.tencent.mm.plugin.report.service.g.yxI.f(19229, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.ynL.Gev.GpO), Integer.valueOf(0), RemittanceBusiUI.Y(RemittanceBusiUI.this) });
          com.tencent.mm.wallet_core.c.l.a(RemittanceBusiUI.this, paramString.ynL.Gev.DFA, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dG(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(174425);
              ae.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog left button click jumpItem.action：continue");
              AppMethodBeat.o(174425);
            }
            
            public final void dMp()
            {
              AppMethodBeat.i(174426);
              ae.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog left button click jumpItem.action：close");
              AppMethodBeat.o(174426);
            }
            
            public final void dMw()
            {
              AppMethodBeat.i(174424);
              ae.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog left button click jumpItem.action:exit");
              RemittanceBusiUI.Z(RemittanceBusiUI.this);
              AppMethodBeat.o(174424);
            }
          });
          AppMethodBeat.o(174428);
        }
      };
      Object localObject5 = View.inflate(paramn.mContext, 2131495198, null);
      Object localObject8 = (TextView)((View)localObject5).findViewById(2131301313);
      localObject1 = (EditText)((View)localObject5).findViewById(2131300111);
      ((MMNeat7extView)((View)localObject5).findViewById(2131298739)).aq((CharSequence)localObject6);
      ((TextView)localObject8).setText((CharSequence)localObject7);
      localObject6 = new d.a(paramn.mContext);
      ((d.a)localObject6).aZh((String)localObject4).hd((View)localObject5);
      localObject4 = com.tencent.mm.ui.tools.b.c.d((EditText)localObject1);
      ((com.tencent.mm.ui.tools.b.c)localObject4).njK = f.a.Lfg;
      localObject4 = ((com.tencent.mm.ui.tools.b.c)localObject4).kj(1, 1);
      ((com.tencent.mm.ui.tools.b.c)localObject4).LiL = false;
      ((com.tencent.mm.ui.tools.b.c)localObject4).a(null);
      ar.o(new c.10(paramn, (EditText)localObject1), 200L);
      ((d.a)localObject6).aZo((String)localObject3).afW(-2141754475).a(false, new c.11(paramn, (EditText)localObject1));
      ((d.a)localObject6).aZp((String)localObject2).d(new c.2(paramn));
      localObject2 = ((d.a)localObject6).fQv();
      ((com.tencent.mm.ui.widget.a.d)localObject2).show();
      ((EditText)localObject1).addTextChangedListener(new c.3(paramn, (EditText)localObject1, (com.tencent.mm.ui.widget.a.d)localObject2));
      paramInt1 = 1;
      break label371;
      label925:
      if (localObject2 == null)
      {
        ae.i("MicroMsg.JumpItemUtil", "showAmountRemindWin() amountRemindWin == null");
        break label521;
      }
      localObject1 = LayoutInflater.from(paramn).inflate(2131494544, null, false);
      localObject5 = ((View)localObject1).findViewById(2131299648);
      localObject6 = (WalletTextView)((View)localObject1).findViewById(2131299647);
      localObject7 = ((View)localObject1).findViewById(2131306753);
      localObject8 = ((View)localObject1).findViewById(2131306751);
      double d = ((dq)localObject2).FOq / 100.0D;
      ((WalletTextView)localObject6).setText(com.tencent.mm.wallet_core.ui.f.C(d));
      if (bu.jB(paramInt1, 0))
      {
        ae.i("MicroMsg.JumpItemUtil", "mAmountRemindBit == 0");
        ((View)localObject8).setVisibility(8);
      }
      for (;;)
      {
        localObject5 = ((dq)localObject2).dyI;
        localObject6 = ((dq)localObject2).DFB.dyI;
        localObject7 = ((dq)localObject2).DFA.dyI;
        localObject4 = new l.8(paramn, (dq)localObject2, d, (l.a)localObject4);
        localObject2 = new l.9(paramn, (dq)localObject2, d, (l.a)localObject3);
        localObject3 = new d.a(paramn);
        ((d.a)localObject3).aZh((String)localObject5);
        ((d.a)localObject3).hd((View)localObject1);
        ((d.a)localObject3).aZo((String)localObject6).c((DialogInterface.OnClickListener)localObject4);
        ((d.a)localObject3).aZp((String)localObject7).d((DialogInterface.OnClickListener)localObject2);
        ((d.a)localObject3).zf(false);
        ((d.a)localObject3).zg(true);
        localObject1 = ((d.a)localObject3).fQv();
        ((com.tencent.mm.ui.widget.a.d)localObject1).show();
        com.tencent.mm.ui.base.h.a(paramn, (Dialog)localObject1);
        break;
        TextView localTextView = (TextView)((View)localObject1).findViewById(2131306756);
        ((View)localObject8).setVisibility(0);
        ((View)localObject8).post(new l.7((View)localObject7, d, paramInt1, (WalletTextView)localObject6, (View)localObject5, (View)localObject8, localTextView));
      }
      label1244:
      if (!(e.dMU().getContext() instanceof RemittanceF2fLargeMoneyUI)) {
        break label548;
      }
      a(9, paramString);
      break label548;
      label1266:
      if (paramString.ynL.Geu != null)
      {
        ae.i("MicroMsg.RemittanceBusiUI", "showMoneyRemind amount_remind_page");
        dNb();
        paramn = new Intent();
        paramn.putExtra("key_amount_remind_bit", this.ymv);
        paramn.putExtra("key_title", paramString.ynL.Geu.title);
        paramn.putExtra("key_desc", paramString.ynL.Geu.dyI);
        paramn.putExtra("key_amount_remind_sign", paramString.ynL.Geu.FOp);
        com.tencent.mm.br.d.b(this, "wallet_payu", ".pay.ui.WalletPayUOrderInfoUI", paramn, 4);
        a(6, paramString);
        break label548;
      }
      if ((e.dMU().getContext() != null) && ((e.dMU().getContext() instanceof RemittanceF2fLargeMoneyUI))) {
        a(8, paramString);
      }
      paramInt1 = 0;
      break label550;
      label1424:
      dNb();
      continue;
      label1431:
      dNb();
      ae.e("MicroMsg.RemittanceBusiUI", "place order response: %s, %s", new Object[] { Integer.valueOf(paramString.ynL.oGt), paramString.ynL.oGu });
      if ((paramString.ynL.Ged != null) && (!bu.isNullOrNil(paramString.ynL.Ged.kCZ))) {
        a(paramString);
      }
      for (;;)
      {
        if (paramString.ynL.Geg != 1) {
          break label1624;
        }
        a(null, null, 0);
        break;
        localObject2 = e.dMU();
        localObject1 = paramString.ynL.oGu;
        paramn = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68029);
            if (bu.jB(((i)paramn).ynL.Ger, 1))
            {
              if (e.dMU().dMV()) {
                ae.w("MicroMsg.RemittanceBusiUI", "finish finishRemitF2fDCodeAndLMRemindUI");
              }
              RemittanceBusiUI.this.finish();
            }
            AppMethodBeat.o(68029);
          }
        };
        ae.w("MicroMsg.RemittanceBusiDialogMgr", "showAlert3() msg:%s, title:%s", new Object[] { bu.nullAsNil((String)localObject1), bu.nullAsNil("") });
        localObject2 = (Context)((e)localObject2).cyH.get();
        if (localObject2 == null) {
          ae.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
        } else {
          com.tencent.mm.ui.base.h.d((Context)localObject2, (String)localObject1, "", paramn);
        }
      }
      label1624:
      continue;
      label1626:
      ae.e("MicroMsg.RemittanceBusiUI", "net error: %s", new Object[] { paramn });
      continue;
      if ((paramn instanceof com.tencent.mm.plugin.remittance.model.h))
      {
        ae.i("MicroMsg.RemittanceBusiUI", "pay check callback");
        AppMethodBeat.o(68071);
        return true;
      }
      if ((paramn instanceof com.tencent.mm.plugin.remittance.model.g))
      {
        ae.i("MicroMsg.RemittanceBusiUI", "onSceneEnd %s errType %s errCode %s", new Object[] { paramn, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        paramString = (com.tencent.mm.plugin.remittance.model.g)paramn;
        if ((!paramString.ynJ.equals(this.ysV.ynJ)) || (paramString.cancel))
        {
          paramString.ynI = true;
          ae.e("MicroMsg.RemittanceBusiUI", "ignore this getFavor new coming soon %s", new Object[] { Boolean.valueOf(paramString.cancel) });
          AppMethodBeat.o(68071);
          return true;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramString.ynF.oGt == 0)
          {
            this.ysQ.ypH = paramString.ynF.ynw;
            this.ysQ.axI(paramString.ynF.ynw.GdI);
            dNa();
            paramn = paramString.ynG;
            ae.i("MicroMsg.RemittanceBusiUI", "GetFavorAfterAction %s", new Object[] { paramn });
            if (paramn != null) {
              paramn.fy(this.ysQ.dMD());
            }
          }
        }
        for (;;)
        {
          paramString.ynI = true;
          AppMethodBeat.o(68071);
          return true;
          this.ysQ.dMC();
          this.ysj.setTextColor(getContext().getResources().getColor(2131100212));
          this.ysj.setText(paramString.ynF.oGu);
          paramn = paramString.ynH;
          if (paramn != null)
          {
            paramn.a(paramInt1, paramInt2, paramString);
            continue;
            this.ysQ.dMC();
            if ((this.yrI != null) && (!bu.isNullOrNil(this.yrI.ynr))) {
              this.ysj.setText(this.yrI.ynr);
            }
            this.ysj.setTextColor(getContext().getResources().getColor(2131100212));
            this.ysj.setText(getString(2131762427));
            paramn = paramString.ynH;
            if (paramn != null) {
              paramn.a(paramInt1, paramInt2, paramString);
            }
          }
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.remittance.model.l))
      {
        paramString = (com.tencent.mm.plugin.remittance.model.l)paramn;
        ae.i("MicroMsg.RemittanceBusiUI", "NetSceneBusiF2fZeroCallback getHasRetried %s", new Object[] { Boolean.valueOf(paramString.hasRetried) });
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (paramString.ynQ.oGt == 0)
          {
            dNd();
          }
          else
          {
            dNc();
            e.dMU().a(paramString.ynQ.oGu, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
          }
        }
        else {
          e.dMU().a(getString(2131765901), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public boolean shouldEnsureSoterConnection()
  {
    return true;
  }
  
  public abstract class a<InputType>
    implements l.a<InputType>
  {
    public a() {}
    
    public void dMp() {}
    
    public final int dMq()
    {
      return 1072;
    }
    
    public void dMs() {}
    
    public final void dMw()
    {
      Object localObject = new Intent();
      ((Intent)localObject).setComponent(new ComponentName(ak.getPackageName(), "com.tencent.mm.ui.LauncherUI"));
      ((Intent)localObject).addFlags(67108864);
      RemittanceBusiUI localRemittanceBusiUI = RemittanceBusiUI.this;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localRemittanceBusiUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$IRemitBusiJumpItemCallback", "onExit", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localRemittanceBusiUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(localRemittanceBusiUI, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$IRemitBusiJumpItemCallback", "onExit", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  final class b
  {
    private float marginTop;
    private View rY;
    private float ytC;
    private float ytD;
    private TenpaySecureEditText ytE;
    private TextView ytF;
    private RelativeLayout ytG;
    
    b(int paramInt1, int paramInt2, float paramFloat)
    {
      AppMethodBeat.i(68053);
      this.ytC = paramInt1;
      this.ytD = paramInt2;
      this.marginTop = paramFloat;
      AppMethodBeat.o(68053);
    }
    
    final void update()
    {
      AppMethodBeat.i(68054);
      RemittanceBusiUI.a(RemittanceBusiUI.this).setTextSize(1, this.ytD);
      RemittanceBusiUI.b(RemittanceBusiUI.this).setTextSize(1, this.ytC);
      if (this.ytF == null) {
        this.ytF = ((TextView)RemittanceBusiUI.c(RemittanceBusiUI.this).findViewById(2131306836));
      }
      if (this.ytF != null) {
        this.ytF.setTextSize(this.ytC);
      }
      if (this.ytE == null) {
        this.ytE = ((TenpaySecureEditText)RemittanceBusiUI.c(RemittanceBusiUI.this).findViewById(2131306718));
      }
      if (this.ytE != null) {
        this.ytE.setTextSize(this.ytD);
      }
      if (this.rY == null) {
        this.rY = this.ytE.findViewById(2131302445);
      }
      if (this.rY != null) {
        this.rY.setMinimumHeight(BackwardSupportUtil.b.h(RemittanceBusiUI.this, RemittanceBusiUI.d(RemittanceBusiUI.this).ytD));
      }
      if (this.ytG == null) {
        this.ytG = ((RelativeLayout)RemittanceBusiUI.this.findViewById(2131306754));
      }
      if (this.ytG != null) {
        ((LinearLayout.LayoutParams)this.ytG.getLayoutParams()).topMargin = BackwardSupportUtil.b.h(RemittanceBusiUI.this, this.marginTop);
      }
      AppMethodBeat.o(68054);
    }
  }
  
  final class c
    implements Runnable
  {
    public com.tencent.mm.wallet_core.d.d ytH;
    
    c() {}
    
    public final void run()
    {
      AppMethodBeat.i(68055);
      RemittanceBusiUI.Q(RemittanceBusiUI.this).b(this.ytH);
      AppMethodBeat.o(68055);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI
 * JD-Core Version:    0.7.0.1
 */