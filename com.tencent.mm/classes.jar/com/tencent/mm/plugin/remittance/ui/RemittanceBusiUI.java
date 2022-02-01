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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.gg;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.g.a.gh.a;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.qs;
import com.tencent.mm.g.a.yw;
import com.tencent.mm.g.b.a.ab;
import com.tencent.mm.g.b.a.he;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.aku;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.protocal.protobuf.def;
import com.tencent.mm.protocal.protobuf.dk;
import com.tencent.mm.protocal.protobuf.dnn;
import com.tencent.mm.protocal.protobuf.dp;
import com.tencent.mm.protocal.protobuf.dq;
import com.tencent.mm.protocal.protobuf.pz;
import com.tencent.mm.protocal.protobuf.qb;
import com.tencent.mm.protocal.protobuf.qf;
import com.tencent.mm.protocal.protobuf.ql;
import com.tencent.mm.protocal.protobuf.xr;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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
  private int dFo;
  private double dlx;
  private String dyV;
  private int mChannel;
  private int mPayScene;
  private int mRequestCode;
  private int state;
  private ScrollView uGT;
  private String wxW;
  private int xWC;
  private int xWJ;
  private WcPayKeyboard xWL;
  private WalletFormView xWS;
  private RelativeLayout xWT;
  private TextView xWU;
  private RelativeLayout xWV;
  private Runnable xXi;
  private com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.aq> xZK;
  private String yaK;
  private boolean yaP;
  private he yaR;
  private boolean yaU;
  private boolean yaX;
  private com.tencent.mm.sdk.b.c yaZ;
  private String yae;
  private LinearLayout yau;
  private String ybI;
  private String ybJ;
  private String ybN;
  private BusiRemittanceResp ybR;
  private Button ycA;
  private RelativeLayout ycB;
  private String ycC;
  private double ycD;
  private String ycE;
  private String ycF;
  private String ycG;
  private String ycH;
  private String ycI;
  private int ycJ;
  private String ycK;
  private float ycL;
  private boolean ycM;
  private String ycN;
  private int ycO;
  private int ycP;
  private String ycQ;
  private dnn ycR;
  private String ycS;
  private int ycT;
  private int ycU;
  private int ycV;
  private int ycW;
  private String ycX;
  private String ycY;
  private b ycZ;
  private TextView ycm;
  private TextView ycn;
  private TextView yco;
  private TextView ycp;
  private TextView ycq;
  private TextView ycr;
  private TextView ycs;
  private View yct;
  private CdnImageView ycu;
  private LinearLayout ycv;
  private LinearLayout ycw;
  private TextView ycx;
  private View ycy;
  private TextView ycz;
  private com.tencent.mm.sdk.b.c ydA;
  private String yda;
  private String ydb;
  boolean ydc;
  private boolean ydd;
  com.tencent.mm.plugin.remittance.model.g yde;
  private b ydf;
  private b ydg;
  protected boolean ydh;
  private Map<String, dk> ydi;
  private RemittanceF2fDynamicCodeUI ydj;
  private boolean ydk;
  private int ydl;
  private boolean ydm;
  private int ydn;
  private int ydo;
  private i ydp;
  private Runnable ydq;
  private com.tencent.mm.wallet_core.d.c<com.tencent.mm.plugin.remittance.model.l> ydr;
  private c yds;
  private boolean ydt;
  private double ydu;
  private String ydv;
  private String ydw;
  private com.tencent.mm.sdk.b.c ydx;
  private com.tencent.mm.sdk.b.c ydy;
  private com.tencent.mm.sdk.b.c ydz;
  
  public RemittanceBusiUI()
  {
    AppMethodBeat.i(68056);
    this.ycL = 0.0F;
    this.xWC = 4;
    this.ycT = 0;
    this.ycU = 0;
    this.ycV = 0;
    this.ycW = 0;
    this.ycZ = new b();
    this.yda = "";
    this.ydb = "";
    this.ydc = false;
    this.dlx = -1.0D;
    this.ydd = false;
    this.yde = null;
    this.yaP = false;
    this.ydh = false;
    this.mRequestCode = 0;
    this.ydi = new HashMap();
    this.ydj = null;
    this.ydk = false;
    this.ydm = false;
    this.state = 0;
    this.xXi = new Runnable()
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
    this.ydq = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68028);
        RemittanceBusiUI.M(RemittanceBusiUI.this);
        AppMethodBeat.o(68028);
      }
    };
    this.ydr = new com.tencent.mm.wallet_core.d.c()
    {
      public final void a(com.tencent.mm.wallet_core.d.d paramAnonymousd)
      {
        AppMethodBeat.i(163820);
        if ((paramAnonymousd instanceof com.tencent.mm.plugin.remittance.model.l)) {
          RemittanceBusiUI.b(RemittanceBusiUI.this, ((com.tencent.mm.plugin.remittance.model.l)paramAnonymousd).dlu);
        }
        AppMethodBeat.o(163820);
      }
    };
    this.yds = new c();
    this.xZK = new com.tencent.mm.sdk.b.c() {};
    this.ydt = true;
    this.dFo = 0;
    this.ydu = 0.0D;
    this.ydw = "";
    this.yaZ = new com.tencent.mm.sdk.b.c() {};
    this.ydx = new com.tencent.mm.sdk.b.c() {};
    this.ydy = new com.tencent.mm.sdk.b.c() {};
    this.ydz = new com.tencent.mm.sdk.b.c() {};
    this.ydA = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(68056);
  }
  
  private void A(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(68075);
    ad.i("MicroMsg.RemittanceBusiUI", "doBusiZeroCallback %s", new Object[] { Boolean.valueOf(paramBoolean) });
    dk localdk = (dk)this.ydi.get(paramString);
    if (localdk == null)
    {
      AppMethodBeat.o(68075);
      return;
    }
    dnn localdnn = this.ycR;
    String str = this.ycQ;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString = new com.tencent.mm.plugin.remittance.model.l(localdnn, localdk, str, i, this.ycS, paramString);
      if (!paramBoolean) {
        break;
      }
      paramString.hasRetried = true;
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(paramString, 0);
      AppMethodBeat.o(68075);
      return;
    }
    this.ycW = 0;
    doSceneForceProgress(paramString);
    AppMethodBeat.o(68075);
  }
  
  private void a(int paramInt, pz parampz, boolean paramBoolean, gh paramgh, String paramString1, String paramString2)
  {
    AppMethodBeat.i(68077);
    a(paramInt, parampz, paramBoolean, paramgh, paramString1, paramString2, "");
    AppMethodBeat.o(68077);
  }
  
  private void a(int paramInt, pz parampz, boolean paramBoolean, gh paramgh, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(163834);
    int i = 0;
    int j = 0;
    if (!this.ydt)
    {
      boolean bool1 = bt.K(Double.valueOf(this.ydu), Double.valueOf(this.ycD));
      boolean bool2 = bt.lQ(this.ydv, this.ybJ);
      if (!bool1) {
        j = 1;
      }
      i = j;
      if (!bool2) {
        i = j | 0x2;
      }
    }
    String str1 = this.yaK;
    String str2 = this.ycC;
    j = this.mPayScene;
    String str3 = this.ycH;
    String str4 = this.ybJ;
    int k = this.mChannel;
    String str5 = this.ycI;
    String str6 = this.ycN;
    int m = this.ycP;
    int n = this.ycO;
    String str7 = this.ycE;
    akt localakt = this.ycZ.xZO;
    if (parampz == null)
    {
      parampz = "";
      paramString1 = new i(str1, str2, j, str3, str4, paramInt, k, str5, str6, m, n, str7, localakt, parampz, this.ybR.xXA, paramString1, this.yae, paramString2, this.ycF, this.ydw, this.dFo, i, paramString3);
      if (paramBoolean) {
        paramString1.a(paramgh);
      }
      if ((!this.mKindaEnable) || (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_QRCODE_RECEIVE_PAY_SWTICH_KEY"))) {
        break label383;
      }
      if (this.ydj == null) {
        break label376;
      }
      this.ydj.showSafeProgress();
    }
    label275:
    label279:
    label411:
    label424:
    for (;;)
    {
      paramBoolean = false;
      parampz = this;
      parampz.doSceneProgress(paramString1, paramBoolean);
      if (this.ydk)
      {
        if (paramInt == this.ydl) {
          a(5, this.ydp);
        }
      }
      else {
        label310:
        if ((e.dJC().getContext() != null) && ((e.dJC().getContext() instanceof RemittanceBusiUI))) {
          if (this.ydm)
          {
            if (paramInt != this.ydo) {
              break label411;
            }
            a(13, this.ydp);
          }
        }
      }
      for (;;)
      {
        this.ydo = paramInt;
        AppMethodBeat.o(163834);
        return;
        parampz = parampz.FLk;
        break;
        label376:
        showLoading();
        break label275;
        label383:
        if (e.dJC().dJF()) {
          break label424;
        }
        paramBoolean = true;
        parampz = this;
        break label279;
        a(4, this.ydp);
        break label310;
        a(12, this.ydp);
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
    if (this.ydc)
    {
      this.ycz.setText(com.tencent.mm.wallet_core.ui.e.C(dJH()));
      com.tencent.mm.sdk.platformtools.aq.aA(this.ydq);
      this.ycD = dJH();
      long l = Math.round(this.ycD * 100.0D);
      if (l <= 0L)
      {
        this.ycZ.dJk();
        this.ycs.setTextColor(getContext().getResources().getColor(2131100212));
        this.ycs.setText(this.ybR.xXz);
        if (this.yde != null) {
          this.yde.cancel = true;
        }
        AppMethodBeat.o(68069);
        return;
      }
      j = (int)l;
      k = this.mChannel;
      m = this.ybR.xXA;
      str1 = this.ycH;
      str2 = this.yae;
      str3 = this.ybR.xXB;
      str4 = this.yaK;
      str5 = this.ycE;
      str6 = this.ybR.xXC;
      if (paramc != null) {
        break label243;
      }
    }
    label243:
    for (int i = 0;; i = 1)
    {
      this.yde = new com.tencent.mm.plugin.remittance.model.g(j, k, m, str1, str2, str3, str4, str5, str6, i, paramc, paramd);
      com.tencent.mm.sdk.platformtools.aq.o(this.ydq, paramInt);
      AppMethodBeat.o(68069);
      return;
    }
  }
  
  private void a(qf paramqf)
  {
    AppMethodBeat.i(68085);
    ad.i("MicroMsg.RemittanceBusiUI", "resp.payer_need_auth_flag %s", new Object[] { Integer.valueOf(paramqf.FLJ) });
    if (paramqf.FLJ == 1)
    {
      paramqf = new Bundle();
      com.tencent.mm.sdk.b.a.IbL.c(this.ydz);
      paramqf.putString("realname_verify_process_jump_activity", ".ui.RemittanceBusiUI");
      paramqf.putString("realname_verify_process_jump_plugin", "remittance");
      paramqf.putInt("real_name_verify_mode", 0);
      paramqf.putInt("entry_scene", this.mPayScene);
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramqf);
      AppMethodBeat.o(68085);
      return;
    }
    Intent localIntent = new Intent();
    Object localObject;
    if (!bt.isNullOrNil(this.ycY)) {
      localObject = this.ycY;
    }
    for (;;)
    {
      localIntent.putExtra("INTENT_TITLE", (String)localObject);
      localIntent.putExtra("INTENT_CAN_TOUCH", this.ycT);
      localIntent.putExtra("INTENT_PAYFEE", com.tencent.mm.wallet_core.ui.e.C(0.0D));
      localIntent.putExtra("INTENT_REQKEY", paramqf.dve);
      paramqf = paramqf.FLK;
      try
      {
        localIntent.putExtra("INTENT_TOKENMESS", paramqf.toByteArray());
        com.tencent.mm.bs.d.b(getContext(), "wallet", "com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI", localIntent, 2);
        AppMethodBeat.o(68085);
        return;
      }
      catch (Exception paramqf)
      {
        String str;
        StringBuilder localStringBuilder;
        ad.printErrStackTrace("MicroMsg.RemittanceBusiUI", paramqf, "", new Object[0]);
        AppMethodBeat.o(68085);
      }
      str = getString(2131765746);
      if (!bt.isNullOrNil(this.ycE))
      {
        com.tencent.mm.kernel.g.ajD();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().aTj(this.ycE);
        if (localObject != null)
        {
          localObject = ((am)localObject).adv();
          localStringBuilder = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.aYO((String)localObject));
          if (bt.isNullOrNil(this.ycF)) {}
          for (localObject = "";; localObject = "(" + this.ycF + ")")
          {
            localObject = bt.x(str, new Object[] { (String)localObject });
            break;
          }
        }
        ad.e("MicroMsg.RemittanceBusiUI", "can not found contact for user::" + this.ycE);
        localObject = "";
      }
      else
      {
        ad.e("MicroMsg.RemittanceBusiUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
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
      ad.i("MicroMsg.RemittanceBusiUI", "onActivityResult _transId: %s _totalFee: %s", new Object[] { str1, Double.valueOf(d) });
      if (bt.isNullOrNil(this.wxW)) {
        this.wxW = str1;
      }
      if (d >= 0.0D) {
        this.dlx = d;
      }
      if (this.yaP) {
        com.tencent.mm.plugin.report.service.g.yhR.f(15386, new Object[] { Integer.valueOf(3), Integer.valueOf(2) });
      }
      dJL();
      aww(str2);
    }
    for (;;)
    {
      c(paramBoolean, paramIntent);
      AppMethodBeat.o(68073);
      return;
      if (ag.bw(paramIntent))
      {
        finish();
        AppMethodBeat.o(68073);
        return;
      }
      if (ag.bx(paramIntent))
      {
        AppMethodBeat.o(68073);
        return;
      }
      ad.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor");
      dJK();
    }
  }
  
  private boolean a(i parami)
  {
    AppMethodBeat.i(68079);
    boolean bool1 = false;
    if (!this.yaU) {
      bool1 = b(parami);
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = c(parami);
    }
    AppMethodBeat.o(68079);
    return bool2;
  }
  
  private void aww(String paramString)
  {
    AppMethodBeat.i(68086);
    ad.i("MicroMsg.RemittanceBusiUI", "do pay check: %s", new Object[] { paramString });
    paramString = (dk)this.ydi.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(68086);
      return;
    }
    if (!bt.isNullOrNil(this.wxW)) {
      paramString.FvI = this.wxW;
    }
    doSceneProgress(new com.tencent.mm.plugin.remittance.model.h(paramString, this.yda), false);
    AppMethodBeat.o(68086);
  }
  
  private boolean b(final i parami)
  {
    AppMethodBeat.i(68080);
    if (!bt.isNullOrNil(parami.xXT.FLD))
    {
      this.yaU = true;
      bJ(1, parami.xXT.FvH);
      e.dJC().a(parami.xXT.FLD, getString(2131755873), getString(2131762423), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68036);
          RemittanceBusiUI.a(RemittanceBusiUI.this, 3, parami.xXT.FvH);
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
          RemittanceBusiUI.a(RemittanceBusiUI.this, 2, parami.xXT.FvH);
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
    this.yaR = new he();
    this.yaR.dVd = 1L;
    this.yaR.dPl = paramInt;
    this.yaR.qa(paramString);
    this.yaR.aLk();
    AppMethodBeat.o(68081);
  }
  
  private void c(boolean paramBoolean, Intent paramIntent)
  {
    AppMethodBeat.i(68074);
    this.ydt = false;
    if (paramBoolean)
    {
      ad.i("MicroMsg.RemittanceBusiUI", "savePayInfo isOk = true");
      this.dFo = 1;
    }
    for (;;)
    {
      ad.i("MicroMsg.RemittanceBusiUI", "savePayInfo() mLastPayResult:%s mLastTotalAmt:%s mLastPayerDesc:%s mLastF2fId:%s", new Object[] { Double.valueOf(this.ydu), Double.valueOf(this.ydu), this.ydv, this.ydw });
      AppMethodBeat.o(68074);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(68074);
        return;
      }
      this.dFo = paramIntent.getIntExtra("key_pay_reslut_type", 3);
      this.ydu = this.ycD;
      this.ydv = this.ybJ;
      this.ydw = this.ybI;
    }
  }
  
  private boolean c(final i parami)
  {
    AppMethodBeat.i(68083);
    if (parami.xXT.FLE != null)
    {
      this.yaX = true;
      e.dJC().a(parami.xXT.ozS, "", parami.xXT.FLE.kzL, parami.xXT.FLE.kzK, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(163825);
          ad.i("MicroMsg.RemittanceBusiUI", "goto h5: %s", new Object[] { parami.xXT.FLE.paG });
          com.tencent.mm.wallet_core.ui.e.o(RemittanceBusiUI.this.getContext(), parami.xXT.FLE.paG, false);
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
    ad.i("MicroMsg.RemittanceBusiUI", "do start pay zero_pay_flag: %s", new Object[] { Integer.valueOf(parami.xXT.FLI) });
    if (e.dJC().dJE()) {
      ad.w("MicroMsg.RemittanceBusiUI", "finish finishRemitLMRemindUI");
    }
    Object localObject1 = new dk();
    ((dk)localObject1).channel = this.mChannel;
    ((dk)localObject1).FvH = this.ybI;
    ((dk)localObject1).FvI = this.wxW;
    ((dk)localObject1).xXA = this.ybR.xXA;
    ((dk)localObject1).scene = this.mPayScene;
    ((dk)localObject1).FvJ = this.ybN;
    ((dk)localObject1).FvK = this.ycZ.xZO;
    ((dk)localObject1).iTJ = this.ycE;
    ((dk)localObject1).xZb = this.yaK;
    ((dk)localObject1).FvL = parami.wNV;
    this.ydi.put(parami.xXT.dve, localObject1);
    if (parami.xXT.FLI == 1)
    {
      a(parami.xXT);
      AppMethodBeat.o(68084);
      return;
    }
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.dlu = parami.xXT.dve;
    localPayInfo.dCC = this.mPayScene;
    if (this.mChannel > 0) {
      localPayInfo.channel = this.mChannel;
    }
    if (parami.xXT.FLP != null) {
      localPayInfo.thf = parami.xXT.FLP.ffY();
    }
    localPayInfo.DiI = parami.xXT.FLO;
    Object localObject2;
    if (parami.xXT.FLQ == 1)
    {
      bool = true;
      localPayInfo.CYi = bool;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("extinfo_key_1", this.ycE);
      ((Bundle)localObject1).putString("extinfo_key_2", this.ycF);
      ((Bundle)localObject1).putString("extinfo_key_3", this.ycH);
      ((Bundle)localObject1).putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
      ((Bundle)localObject1).putString("extinfo_key_7", this.ybJ);
      ((Bundle)localObject1).putString("extinfo_key_19", parami.xXT.xYL);
      localPayInfo.htZ = ((Bundle)localObject1);
      localPayInfo.xYX = 1;
      localObject2 = new Intent();
      if (parami.xXT.xYI != 1) {
        break label738;
      }
      ((Bundle)localObject1).putInt("extinfo_key_15", parami.xXT.FLR);
      ((Bundle)localObject1).putString("extinfo_key_17", parami.xXT.xYJ);
      ((Bundle)localObject1).putString("extinfo_key_18", parami.xXT.xYK);
      ((Intent)localObject2).putExtra("key_pay_info", localPayInfo);
      ((Intent)localObject2).putExtra("from_patch_ui", true);
      ((Intent)localObject2).putExtra("key_rcvr_open_id", this.yaK);
      ((Intent)localObject2).putExtra("key_mch_info", this.ycK);
      ((Intent)localObject2).putExtra("key_mch_photo", this.ybR.xXy);
      ((Intent)localObject2).putExtra("key_transfer_qrcode_id", this.ycC);
      ((Intent)localObject2).putExtra("get_dynamic_code_sign", parami.xXT.xYJ);
      ((Intent)localObject2).putExtra("get_dynamic_code_extend", parami.xXT.xYK);
      ((Intent)localObject2).putExtra("dynamic_code_spam_wording", parami.xXT.xYM);
      ((Intent)localObject2).putExtra("dynamic_code_amount", parami.xXT.FLR);
      ((Intent)localObject2).putExtra("show_paying_wording", parami.xXT.xYL);
      if (this.ybR.xXG != 1) {
        break label733;
      }
    }
    label733:
    for (boolean bool = true;; bool = false)
    {
      ((Intent)localObject2).putExtra("show_avatar_type", bool);
      com.tencent.mm.plugin.report.service.g.yhR.f(15386, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
      this.yaZ.alive();
      this.ydx.alive();
      this.ydy.alive();
      if ((this.mKindaEnable) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_QRCODE_RECEIVE_PAY_SWTICH_KEY"))) {
        hideLoading();
      }
      com.tencent.mm.bs.d.b(this, "remittance", ".ui.RemittanceF2fDynamicCodeUI", (Intent)localObject2, 3);
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
      if (this.ydj != null) {
        this.mRequestCode = 3;
      }
      str = "";
      if (!bt.isNullOrNil(parami.xXT.xYL))
      {
        parami = parami.xXT.xYL;
        if (localPayInfo.htZ == null) {
          localPayInfo.htZ = new Bundle();
        }
        localPayInfo.htZ.putString("cashier_desc", parami);
        if (bt.isNullOrNil(this.ycE)) {
          break label1349;
        }
        com.tencent.mm.kernel.g.ajD();
        parami = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().aTj(this.ycE);
        if (parami == null) {
          break label1349;
        }
        parami = parami.adv();
        localObject1 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.aYO(parami));
        if (!bt.isNullOrNil(this.ycF)) {
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
      localPayInfo.htZ.putString("prepay_page_payee", parami);
      if (this.ydj != null) {
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this.ydj, localPayInfo);
      }
      for (;;)
      {
        this.ydh = true;
        AppMethodBeat.o(68084);
        return;
        localObject2 = getIntent().getStringExtra("receiver_tips");
        localObject1 = getString(2131765746);
        parami = str;
        if (!bt.isNullOrNil((String)localObject2))
        {
          localObject1 = localObject2;
          parami = (i)localObject2;
        }
        if (!bt.isNullOrNil(this.ycE))
        {
          com.tencent.mm.kernel.g.ajD();
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().aTj(this.ycE);
          if (localObject2 != null)
          {
            parami = ((am)localObject2).adv();
            localObject2 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.aYO(parami));
            if (bt.isNullOrNil(this.ycF)) {}
            for (parami = "";; parami = "(" + this.ycF + ")")
            {
              parami = bt.x((String)localObject1, new Object[] { parami });
              break;
            }
          }
          ad.e("MicroMsg.RemittanceBusiUI", "can not found contact for user::" + this.ycE);
          break;
        }
        ad.e("MicroMsg.RemittanceBusiUI", "mRcverName is null ,scene is MMPAY_PAY_SCENE_TRANSFER busi");
        break;
        parami = "(" + this.ycF + ")";
        break label916;
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, localPayInfo);
      }
      if (!bt.isNullOrNil(parami.xXU)) {}
      for (this.yaP = true; (parami.xXV != null) && (parami.xXV.drX.dsa != null); this.yaP = false)
      {
        f.a(parami.xXV.drX.dsa, false, "", localPayInfo, this.ycF, (Intent)localObject2, parami.xXV.drX.mRequestCode);
        AppMethodBeat.o(68084);
        return;
      }
      f.a(this, false, "", localPayInfo, this.ycF, (Intent)localObject2, 1);
      AppMethodBeat.o(68084);
      return;
    }
  }
  
  private void dBh()
  {
    AppMethodBeat.i(68087);
    this.ycD = dJH();
    if (this.ycD <= 0.0D)
    {
      findViewById(2131299860).setClickable(false);
      findViewById(2131299860).setEnabled(false);
      findViewById(2131299860).setOnClickListener(null);
      lG(false);
      this.ycs.setTextColor(getResources().getColor(2131100707));
      AppMethodBeat.o(68087);
      return;
    }
    this.ycs.setTextColor(getContext().getResources().getColor(2131100212));
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.plugin.report.service.g.yhR.f(15235, new Object[] { Integer.valueOf(3) });
        if (RemittanceBusiUI.n(RemittanceBusiUI.this) == 56) {
          com.tencent.mm.plugin.report.service.g.yhR.f(19821, new Object[] { Integer.valueOf(7), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
        }
        RemittanceBusiUI.J(RemittanceBusiUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(163832);
      }
    });
    AppMethodBeat.o(68087);
  }
  
  private double dJH()
  {
    AppMethodBeat.i(68057);
    if ((this.ycM) || (this.mPayScene == 33))
    {
      d = this.ycD;
      AppMethodBeat.o(68057);
      return d;
    }
    this.ycD = bt.getDouble(this.xWS.getText(), 0.0D);
    double d = this.ycD;
    AppMethodBeat.o(68057);
    return d;
  }
  
  private boolean dJI()
  {
    AppMethodBeat.i(68067);
    boolean bool;
    if (this.yct == null) {
      bool = false;
    }
    for (;;)
    {
      com.tencent.mm.ui.tools.p.a(this, this.uGT, findViewById(2131304051), findViewById(2131304051), findViewById(2131304050), this.ycL);
      AppMethodBeat.o(68067);
      return bool;
      if (this.ybR != null)
      {
        ad.i("MicroMsg.RemittanceBusiUI", "tryShowFavor ");
        if ((this.ybR.xXE != null) && (this.ybR.xXE.FLi.size() > 0)) {}
        for (int i = 1;; i = 0)
        {
          if (this.ybR.xXD.size() > 0) {
            i = 1;
          }
          if (this.ycZ.dJl().size() > 0) {
            i = 1;
          }
          if (i == 0)
          {
            this.yct.setVisibility(8);
            this.ydg.update();
            this.ycy.setVisibility(8);
            bool = false;
            break;
          }
          this.ycy.setVisibility(0);
          this.ydf.update();
          this.yct.setVisibility(0);
          this.ycs.setText(this.ybR.xXz);
          this.ycs.setTextColor(getContext().getResources().getColor(2131100212));
          this.ycz.setText(com.tencent.mm.wallet_core.ui.e.C(dJH()));
          Object localObject = this.ycZ.xZO;
          if (localObject != null)
          {
            this.ycs.setTextColor(getContext().getResources().getColor(2131099777));
            this.ycs.setText(((akt)localObject).xXz);
            this.ycz.setText(com.tencent.mm.wallet_core.ui.e.C(((akt)localObject).Gkg / 100.0D));
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
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                com.tencent.mm.plugin.report.service.g.yhR.f(15235, new Object[] { Integer.valueOf(3) });
                if (RemittanceBusiUI.n(RemittanceBusiUI.this) == 56) {
                  com.tencent.mm.plugin.report.service.g.yhR.f(19821, new Object[] { Integer.valueOf(7), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
                }
                RemittanceBusiUI.J(RemittanceBusiUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68020);
              }
            });
            bool = true;
            break;
            localObject = this.ycZ.dJm();
            if (!bt.isNullOrNil((String)localObject))
            {
              this.ycs.setTextColor(getContext().getResources().getColor(2131100212));
              this.ycs.setText((CharSequence)localObject);
            }
          }
        }
      }
      bool = false;
    }
  }
  
  private void dJJ()
  {
    AppMethodBeat.i(163833);
    hideLoading();
    if (this.ydj != null) {
      this.ydj.hideProgress();
    }
    AppMethodBeat.o(163833);
  }
  
  private void dJK()
  {
    AppMethodBeat.i(68076);
    ad.i("MicroMsg.RemittanceBusiUI", "unLockFavorimp");
    akt localakt = this.ycZ.xZO;
    if (localakt == null)
    {
      ad.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor FavorComposeInfo is null");
      AppMethodBeat.o(68076);
      return;
    }
    int i = (int)Math.round(this.ycD * 100.0D);
    dk localdk = new dk();
    localdk.channel = this.mChannel;
    localdk.FvH = this.ybI;
    localdk.FvI = this.wxW;
    localdk.xXA = this.ybR.xXA;
    localdk.scene = this.mPayScene;
    localdk.FvJ = this.ybN;
    localdk.FvK = localakt;
    localdk.iTJ = this.ycE;
    localdk.xZb = this.yaK;
    localdk.FvL = i;
    doSceneProgress(new com.tencent.mm.plugin.remittance.model.k(localdk, this.yda), false);
    AppMethodBeat.o(68076);
  }
  
  private void dJL()
  {
    AppMethodBeat.i(68078);
    ad.i("MicroMsg.RemittanceBusiUI", "goto busi result");
    Object localObject = new Intent(this, RemittanceBusiResultUI.class);
    ((Intent)localObject).putExtra("key_pay_desc", this.ybJ);
    ((Intent)localObject).putExtra("key_rcv_desc", this.ycH);
    if (this.ybR != null) {
      ((Intent)localObject).putExtra("BusiRemittanceResp", this.ybR);
    }
    ((Intent)localObject).putExtra("key_mch_name", this.yae);
    ((Intent)localObject).putExtra("key_rcver_name", this.ycE);
    ((Intent)localObject).putExtra("key_rcver_true_name", this.ycF);
    if (this.dlx >= 0.0D) {
      ((Intent)localObject).putExtra("key_money", this.dlx);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_f2f_id", this.ybI);
      ((Intent)localObject).putExtra("key_trans_id", this.wxW);
      ((Intent)localObject).putExtra("key_check_sign", this.ybN);
      ((Intent)localObject).putExtra("key_rcvr_open_id", this.yaK);
      ((Intent)localObject).putExtra("key_channel", this.mChannel);
      ((Intent)localObject).putExtra("key_succ_fault_config", this.ycX);
      if (this.ybR != null)
      {
        ((Intent)localObject).putExtra("key_succ_show_avatar_type", this.ybR.xXG);
        ((Intent)localObject).putExtra("key_succ_show_avatar_show", this.ybR.xXx);
        ((Intent)localObject).putExtra("key_succ_show_avatar_url", this.ybR.xXy);
      }
      if (this.ybR != null) {
        ((Intent)localObject).putExtra("key_scan_sceen", this.ybR.xXA);
      }
      ((Intent)localObject).putExtra("key_succ_page_extend", this.ydb);
      if (this.mChannel == 56) {
        ((Intent)localObject).putExtra("app_id", this.app_id);
      }
      akt localakt = this.ycZ.xZO;
      int i = (int)Math.round(this.ycD * 100.0D);
      dk localdk = new dk();
      localdk.channel = this.mChannel;
      localdk.FvH = this.ybI;
      localdk.FvI = this.wxW;
      localdk.xXA = this.ybR.xXA;
      localdk.scene = this.mPayScene;
      localdk.FvJ = this.ybN;
      localdk.FvK = localakt;
      localdk.iTJ = this.ycE;
      localdk.xZb = this.yaK;
      localdk.FvL = i;
      try
      {
        ((Intent)localObject).putExtra("AfterPlaceOrderCommReq", localdk.toByteArray());
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI", "gotoBusiResultUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI", "gotoBusiResultUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        if (e.dJC().dJD()) {
          ad.w("MicroMsg.RemittanceBusiUI", "finish finishRemitF2fDCodeAndLMRemindUI");
        }
        AppMethodBeat.o(68078);
        return;
        ((Intent)localObject).putExtra("key_money", this.ycD);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.RemittanceBusiUI", localException, "", new Object[0]);
        }
      }
    }
  }
  
  private void dJx()
  {
    AppMethodBeat.i(68066);
    com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68019);
        RemittanceBusiUI.E(RemittanceBusiUI.this).setText(RemittanceBusiUI.D(RemittanceBusiUI.this));
        Object localObject;
        if ((RemittanceBusiUI.k(RemittanceBusiUI.this) != null) && (!bt.isNullOrNil(RemittanceBusiUI.k(RemittanceBusiUI.this).xXH)))
        {
          localObject = RemittanceBusiUI.k(RemittanceBusiUI.this).xXH;
          RemittanceBusiUI.H(RemittanceBusiUI.this).setText(com.tencent.mm.pluginsdk.ui.span.k.b(RemittanceBusiUI.this, (CharSequence)localObject, RemittanceBusiUI.H(RemittanceBusiUI.this).getTextSize()));
          if (RemittanceBusiUI.k(RemittanceBusiUI.this) == null) {
            break label358;
          }
          if (RemittanceBusiUI.k(RemittanceBusiUI.this).xXx != 1) {
            break label340;
          }
          if (bt.isNullOrNil(RemittanceBusiUI.k(RemittanceBusiUI.this).xXy)) {
            break label267;
          }
          if (RemittanceBusiUI.k(RemittanceBusiUI.this).xXG != 1) {
            break label253;
          }
          RemittanceBusiUI.I(RemittanceBusiUI.this).setRoundCorner(true);
        }
        for (;;)
        {
          int i = BackwardSupportUtil.b.g(RemittanceBusiUI.this, 36.0F);
          RemittanceBusiUI.I(RemittanceBusiUI.this).r(RemittanceBusiUI.k(RemittanceBusiUI.this).xXy, i, i, -1);
          AppMethodBeat.o(68019);
          return;
          String str = com.tencent.mm.wallet_core.ui.e.gO(com.tencent.mm.wallet_core.ui.e.zf(RemittanceBusiUI.F(RemittanceBusiUI.this)), 10);
          localObject = str;
          if (bt.isNullOrNil(RemittanceBusiUI.G(RemittanceBusiUI.this))) {
            break;
          }
          localObject = RemittanceBusiUI.this.getString(2131762438, new Object[] { str, RemittanceBusiUI.G(RemittanceBusiUI.this) });
          break;
          label253:
          RemittanceBusiUI.I(RemittanceBusiUI.this).setRoundCorner(false);
        }
        label267:
        if (!bt.isNullOrNil(RemittanceBusiUI.F(RemittanceBusiUI.this)))
        {
          if (RemittanceBusiUI.k(RemittanceBusiUI.this).xXG == 1)
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
  
  private void fr(final List<aku> paramList)
  {
    AppMethodBeat.i(68068);
    final com.tencent.mm.ui.widget.picker.e locale = new com.tencent.mm.ui.widget.picker.e(this);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = this.ycZ.xZO;
    Object localObject1 = new HashSet();
    final HashSet localHashSet = new HashSet();
    if ((this.ycZ.dJo()) && (localObject2 != null))
    {
      localObject2 = ((akt)localObject2).FLh.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((HashSet)localObject1).add(Long.valueOf(((aku)((Iterator)localObject2).next()).Gkn));
      }
    }
    localObject2 = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      if (((HashSet)localObject1).contains(Long.valueOf(((aku)((Iterator)localObject2).next()).Gkn))) {
        localArrayList.add(Integer.valueOf(i));
      }
      i += 1;
    }
    localObject1 = getString(2131762485);
    if ((localObject1 != null) && (((CharSequence)localObject1).length() > 0))
    {
      locale.LaZ.setVisibility(0);
      locale.ABw.setText((CharSequence)localObject1);
    }
    locale.Lba = localArrayList;
    locale.KJy = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(68024);
        RemittanceBusiUI.a(RemittanceBusiUI.this, RemittanceBusiUI.q(RemittanceBusiUI.this));
        aku localaku;
        if ((!RemittanceBusiUI.K(RemittanceBusiUI.this).dJo()) || (RemittanceBusiUI.r(RemittanceBusiUI.this) <= 0.0D))
        {
          localIterator = paramList.iterator();
          i = 0;
          while (localIterator.hasNext())
          {
            localaku = (aku)localIterator.next();
            paramAnonymousl.a(i, localaku.Gko, localaku.Gkq, null, true);
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
          localaku = (aku)localIterator.next();
          if (localaku.Gkw == 1)
          {
            paramAnonymousl.a(i, localaku.Gko, localaku.Gkq, null, true);
            localHashSet.add(Integer.valueOf(i));
          }
          for (;;)
          {
            i += 1;
            break;
            paramAnonymousl.a(i, localaku.Gko, localaku.Gkq, 0);
          }
        }
        AppMethodBeat.o(68024);
      }
    };
    locale.KJz = new n.e()
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
          com.tencent.mm.plugin.report.service.g.yhR.f(15235, new Object[] { Integer.valueOf(4) });
          Object localObject1 = (aku)paramList.get(paramAnonymousInt);
          paramAnonymousMenuItem = locale;
          boolean bool;
          if (paramAnonymousMenuItem.Lbb != null)
          {
            paramAnonymousMenuItem = paramAnonymousMenuItem.Lbb.fMO();
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
                ((List)localObject2).add((aku)paramList.get(k));
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
            localObject1 = RemittanceBusiUI.K(RemittanceBusiUI.this).xZO;
            paramAnonymousMenuItem = new HashSet();
            if (localObject1 == null) {
              break;
            }
            localObject1 = ((akt)localObject1).FLh.iterator();
            while (((Iterator)localObject1).hasNext()) {
              paramAnonymousMenuItem.add(Long.valueOf(((aku)((Iterator)localObject1).next()).Gkn));
            }
          }
          localObject1 = new HashMap();
          Object localObject2 = paramList.iterator();
          i = j;
          if (((Iterator)localObject2).hasNext())
          {
            if (paramAnonymousMenuItem.contains(Long.valueOf(((aku)((Iterator)localObject2).next()).Gkn))) {
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
          if (paramAnonymousMenuItem.Lbb != null)
          {
            paramAnonymousMenuItem.Lbb.Lbe = ((HashMap)localObject1);
            paramAnonymousMenuItem.Lbb.notifyDataSetChanged();
          }
        }
        AppMethodBeat.o(68026);
      }
    };
    locale.Lbc = new e.b()
    {
      public final void qm(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(68027);
        if (paramAnonymousBoolean)
        {
          localObject = RemittanceBusiUI.K(RemittanceBusiUI.this).xZO;
          if (localObject != null) {
            break label56;
          }
        }
        label56:
        for (Object localObject = "";; localObject = com.tencent.mm.plugin.remittance.model.a.a((akt)localObject))
        {
          ad.i("MicroMsg.RemittanceBusiUI", "onFavorSelected %s ", new Object[] { localObject });
          RemittanceBusiUI.L(RemittanceBusiUI.this);
          AppMethodBeat.o(68027);
          return;
        }
      }
    };
    if (locale.KJy != null) {
      locale.KJy.onCreateMMMenu(locale.Ekt);
    }
    locale.Lbb = new e.a(locale, locale.mContext);
    locale.Lbb.fMN();
    locale.LaY.setAdapter(locale.Lbb);
    locale.gUt.setOnClickListener(new e.2(locale));
    locale.gWI.setOnClickListener(new e.3(locale));
    if (locale.uBI != null)
    {
      if ((locale.Ekt != null) && (locale.Ekt.size() > 3))
      {
        paramList = (FrameLayout.LayoutParams)locale.kBS.getLayoutParams();
        paramList.height = locale.lzC;
        locale.kBS.setLayoutParams(paramList);
      }
      locale.uBI.show();
    }
    AppMethodBeat.o(68068);
  }
  
  private void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(68088);
    if (this.xWL != null) {
      this.xWL.zj(paramBoolean);
    }
    AppMethodBeat.o(68088);
  }
  
  public final void a(int paramInt, i parami)
  {
    AppMethodBeat.i(163835);
    ab localab = new ab();
    localab.dSI = paramInt;
    if (parami != null)
    {
      localab.gX(parami.xXT.FvH);
      localab.gY(this.ycC);
      localab.dUL = parami.wNV;
    }
    localab.aLk();
    AppMethodBeat.o(163835);
  }
  
  public final void bv(float paramFloat)
  {
    AppMethodBeat.i(68065);
    if (this.uGT != null)
    {
      this.ycL = paramFloat;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.uGT.getLayoutParams();
      localLayoutParams.bottomMargin = ((int)paramFloat);
      ad.d("MicroMsg.RemittanceBusiUI", "onUpdateWcPayKeyboardHeight() height: %s rootView.height: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(localLayoutParams.height) });
      this.uGT.setLayoutParams(localLayoutParams);
      com.tencent.mm.ui.tools.p.a(this, this.uGT, findViewById(2131304051), findViewById(2131304051), findViewById(2131304050), paramFloat);
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
    this.uGT = ((ScrollView)findViewById(2131304251));
    this.ycm = ((TextView)findViewById(2131304008));
    this.ycn = ((TextView)findViewById(2131304009));
    this.yco = ((TextView)findViewById(2131304005));
    this.ycp = ((TextView)findViewById(2131304002));
    this.ycq = ((TextView)findViewById(2131303996));
    this.ycr = ((TextView)findViewById(2131303994));
    this.ycu = ((CdnImageView)findViewById(2131304006));
    this.xWS = ((WalletFormView)findViewById(2131304007));
    this.ycv = ((LinearLayout)findViewById(2131304003));
    this.yau = ((LinearLayout)findViewById(2131303998));
    this.ycB = ((RelativeLayout)findViewById(2131306754));
    this.ycw = ((LinearLayout)findViewById(2131303997));
    this.ycs = ((TextView)findViewById(2131299864));
    this.yct = findViewById(2131303999);
    this.ycx = ((TextView)findViewById(2131304001));
    this.ycy = findViewById(2131299968);
    this.ycz = ((TextView)findViewById(2131299967));
    this.ycA = ((Button)findViewById(2131304004));
    this.xWL = ((WcPayKeyboard)findViewById(2131307020));
    ImageView localImageView;
    label536:
    label680:
    boolean bool1;
    if (this.ycM)
    {
      if (!bt.isNullOrNil(this.ycH)) {
        this.yco.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, this.ycH, this.yco.getTextSize()));
      }
      this.ycp.setText(com.tencent.mm.wallet_core.ui.e.C(this.ycD));
      this.ycv.setVisibility(0);
      this.yau.setVisibility(8);
      this.ycB.setVisibility(8);
      this.ycA.setVisibility(0);
      if (com.tencent.mm.kernel.g.ajx())
      {
        com.tencent.mm.kernel.g.ajD();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(this.ycE);
        if ((localObject == null) || ((int)((com.tencent.mm.o.b)localObject).gfj == 0)) {
          as.a.hFO.a(this.ycE, "", new as.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(68044);
              ad.i("MicroMsg.RemittanceBusiUI", "getContact %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              RemittanceBusiUI.l(RemittanceBusiUI.this);
              AppMethodBeat.o(68044);
            }
          });
        }
      }
      dJx();
      this.ycw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68048);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (!RemittanceBusiUI.m(RemittanceBusiUI.this)) {
            RemittanceBusiUI.this.showCircleStWcKb();
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(15235, new Object[] { Integer.valueOf(6) });
          if (RemittanceBusiUI.n(RemittanceBusiUI.this) == 56) {
            com.tencent.mm.plugin.report.service.g.yhR.f(19821, new Object[] { Integer.valueOf(6), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
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
              com.tencent.mm.sdk.platformtools.aq.o(new Runnable()
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          com.tencent.mm.plugin.report.service.g.yhR.f(15235, new Object[] { Integer.valueOf(5) });
          if (RemittanceBusiUI.n(RemittanceBusiUI.this) == 56) {
            com.tencent.mm.plugin.report.service.g.yhR.f(19821, new Object[] { Integer.valueOf(8), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
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
          localObject = RemittanceBusiUI.this.yde;
          if (RemittanceBusiUI.this.yde == null)
          {
            paramAnonymousView = "";
            ad.i("MicroMsg.RemittanceBusiUI", "mPayBtn onClick %s  isFinish:%s getFavorFlag: %s", new Object[] { localObject, paramAnonymousView, Boolean.valueOf(RemittanceBusiUI.this.ydc) });
            if (RemittanceBusiUI.j(RemittanceBusiUI.this) != 32) {
              break label410;
            }
            if (!RemittanceBusiUI.this.ydc) {
              break label400;
            }
            if ((RemittanceBusiUI.this.yde == null) || (RemittanceBusiUI.this.yde.xWq != (int)(RemittanceBusiUI.r(RemittanceBusiUI.this) * 100.0D))) {
              break label381;
            }
            if ((RemittanceBusiUI.this.yde != null) && (RemittanceBusiUI.this.yde.xXQ)) {
              break label410;
            }
            if (RemittanceBusiUI.this.yde != null) {
              RemittanceBusiUI.this.yde.xXO = new com.tencent.mm.plugin.remittance.model.c()
              {
                public final void fq(List<aku> paramAnonymous2List)
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
            paramAnonymousView = RemittanceBusiUI.this.yde.xXQ;
            break;
            label381:
            RemittanceBusiUI.a(RemittanceBusiUI.this, new com.tencent.mm.plugin.remittance.model.c()
            {
              public final void fq(List<aku> paramAnonymous2List)
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
      this.xWS.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(68052);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66))
          {
            ad.i("MicroMsg.RemittanceBusiUI", "click enter");
            this.xXl.onClick(null);
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
        this.ycA.setOnClickListener((View.OnClickListener)localObject);
        this.uGT.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(68015);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
            if ((RemittanceBusiUI.t(RemittanceBusiUI.this) != null) && (RemittanceBusiUI.u(RemittanceBusiUI.this).isShown()) && (RemittanceBusiUI.v(RemittanceBusiUI.this).fQW()))
            {
              RemittanceBusiUI.w(RemittanceBusiUI.this).fQU();
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
        this.xWV = ((RelativeLayout)findViewById(2131306751));
        if ((!ac.fks().equals("zh_CN")) && (!ac.fks().equals("zh_TW")) && (!ac.fks().equals("zh_HK"))) {
          break label993;
        }
        this.xWT = ((RelativeLayout)findViewById(2131306753));
        this.xWU = ((TextView)findViewById(2131306756));
        this.xWT.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68017);
            RemittanceBusiUI.a(RemittanceBusiUI.this, RemittanceBusiUI.y(RemittanceBusiUI.this).getWidth());
            RemittanceBusiUI.z(RemittanceBusiUI.this).setVisibility(8);
            ad.d("MicroMsg.RemittanceBusiUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(RemittanceBusiUI.A(RemittanceBusiUI.this)) });
            AppMethodBeat.o(68017);
          }
        });
        this.xWS.setmWalletFormViewListener(new WalletFormView.c()
        {
          public final void p(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(68018);
            if (bt.jx(RemittanceBusiUI.B(RemittanceBusiUI.this), 0))
            {
              ad.i("MicroMsg.RemittanceBusiUI", "mAmountRemindBit == 0");
              RemittanceBusiUI.z(RemittanceBusiUI.this).setVisibility(8);
              AppMethodBeat.o(68018);
              return;
            }
            long l = Double.valueOf(bt.getDouble(paramAnonymousCharSequence.toString(), 0.0D)).longValue();
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
                paramAnonymousCharSequence = ag.aQ(aj.getContext(), i);
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
        if ((this.ybR != null) && (this.ybR.xXE != null))
        {
          this.ycZ.xZP = this.ybR.xXE;
          this.ycZ.awt(this.ybR.xXE.FLj);
        }
        if (dJI()) {
          com.tencent.mm.plugin.report.service.g.yhR.f(15235, new Object[] { Integer.valueOf(2) });
        }
        AppMethodBeat.o(68063);
      }
    }
    else
    {
      if (this.ybR == null) {
        break label1010;
      }
      if (this.ybR.xXD.size() <= 0) {
        break label1005;
      }
      bool1 = false;
      label786:
      bool2 = bool1;
      if (this.ybR.xXE != null)
      {
        bool2 = bool1;
        if (this.ybR.xXE.FLh.size() <= 0) {}
      }
    }
    label993:
    label1005:
    label1010:
    for (boolean bool2 = false;; bool2 = true)
    {
      this.ycA.setVisibility(8);
      setWPKeyboard(this.xWS.getContentEt(), bool2, true);
      this.xWS.setmContentAbnormalMoneyCheck(true);
      if (com.tencent.mm.compatible.util.d.ly(28)) {
        this.xWS.getContentEt().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68042);
            RemittanceBusiUI.c(RemittanceBusiUI.this).getContentEt().requestFocus();
            AppMethodBeat.o(68042);
          }
        });
      }
      this.xWL.setActionText(getString(2131762434));
      setWcKbHeightListener(this);
      ((RelativeLayout.LayoutParams)this.xWL.getLayoutParams()).addRule(12);
      this.xWS.a(new TextWatcher()
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
          for (int i = 400;; i = RemittanceBusiUI.k(RemittanceBusiUI.this).xXJ)
          {
            RemittanceBusiUI.a(paramAnonymousEditable, null, i);
            AppMethodBeat.o(68043);
            return;
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.xWS.fSh();
      this.ycv.setVisibility(8);
      this.yau.setVisibility(0);
      this.ycB.setVisibility(0);
      break;
      findViewById(2131306755).setVisibility(0);
      findViewById(2131306752).setVisibility(8);
      localImageView.setBackgroundResource(2131234671);
      break label536;
      this.xWV.setVisibility(8);
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
      if ((!this.ydh) && (!this.ycM) && (this.xWL.fQY()))
      {
        AppMethodBeat.o(68062);
        return true;
      }
      AppMethodBeat.o(68062);
      return false;
    }
    if ((!this.ycM) && (this.xWL.fQY()))
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
    ad.i("MicroMsg.RemittanceBusiUI", "onActivityResult requestCode %s resultCode %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    if (paramInt1 == 3)
    {
      if (this.ydj != null)
      {
        this.ydj.hideProgress();
        this.ydj = null;
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
          this.ycS = str;
          this.dlx = 0.0D;
          ad.i("MicroMsg.RemittanceBusiUI", "onActivityResult _result_token: %s", new Object[] { str });
          A(false, paramIntent.getStringExtra("INTENT_REQKEY"));
        }
        else
        {
          dJK();
        }
      }
      else if (paramInt1 == 4) {
        this.ydm = true;
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
      com.tencent.mm.plugin.report.service.g.yhR.f(19821, new Object[] { Integer.valueOf(4), this.app_id, Integer.valueOf(0) });
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(15235, new Object[] { Integer.valueOf(1) });
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
    if ((com.tencent.mm.compatible.util.d.ly(21)) && (!com.tencent.mm.compatible.util.d.ly(23))) {
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
    regeistQueryOrder(2682, this.ydr);
    setMMTitle(2131762434);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(68014);
        RemittanceBusiUI.e(RemittanceBusiUI.this);
        if (RemittanceBusiUI.this.getIntent().getIntExtra("pay_channel", 0) == 56)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(19821, new Object[] { Integer.valueOf(5), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
          RemittanceBusiUI.dJM();
        }
        RemittanceBusiUI.this.finish();
        AppMethodBeat.o(68014);
        return false;
      }
    });
    this.dyV = UUID.randomUUID().toString();
    com.tencent.mm.plugin.wallet.pay.a.b.aEd(this.dyV);
    this.mPayScene = getIntent().getIntExtra("pay_scene", 31);
    this.ycC = getIntent().getStringExtra("scan_remittance_id");
    this.ycD = getIntent().getDoubleExtra("fee", 0.0D);
    this.ycE = getIntent().getStringExtra("receiver_name");
    this.ycF = getIntent().getStringExtra("receiver_true_name");
    this.ycG = getIntent().getStringExtra("receiver_true_name_busi");
    this.mChannel = getIntent().getIntExtra("pay_channel", 0);
    this.ycH = getIntent().getStringExtra("desc");
    this.ycJ = getIntent().getIntExtra("busi_type", 0);
    this.yae = getIntent().getStringExtra("mch_name");
    this.ycN = getIntent().getStringExtra("mch_type");
    this.ycP = getIntent().getIntExtra("mch_time", 0);
    this.ycK = getIntent().getStringExtra("mch_info");
    this.ycO = getIntent().getIntExtra("get_pay_wifi", 0);
    this.yaK = getIntent().getStringExtra("rcvr_open_id");
    this.ycI = getIntent().getStringExtra("rcvr_ticket");
    this.xWC = getIntent().getIntExtra("amount_remind_bit", 4);
    this.ycY = getIntent().getStringExtra("receiver_tips");
    this.ybR = ((BusiRemittanceResp)getIntent().getParcelableExtra("BusiRemittanceResp"));
    boolean bool;
    if (this.ybR != null) {
      if ((this.mPayScene == 32) && ((this.ybR.xXF == 1) || ((this.ybR != null) && (this.ybR.xXD.size() > 0))))
      {
        bool = true;
        this.ydc = bool;
        if (this.ycD <= 0.0D) {
          break label851;
        }
      }
    }
    label851:
    for (this.ycM = true;; this.ycM = false)
    {
      if (this.ycJ == 0)
      {
        ad.w("MicroMsg.RemittanceBusiUI", "wrong busi type!");
        finish();
      }
      com.tencent.mm.plugin.report.service.g.yhR.f(15386, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
      this.ydf = new b(32, 32, 6.0F);
      this.ydg = new b(56, 56, 8.0F);
      initView();
      dBh();
      this.xZK.alive();
      this.ydA.alive();
      if (!this.ycM) {
        this.state = 1;
      }
      AppMethodBeat.o(68058);
      return;
      bool = false;
      break;
      ad.w("MicroMsg.RemittanceBusiUI", "busi resp is null, maybe recreate activity!!");
      finish();
      AppMethodBeat.o(68058);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68070);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.IbL.d(this.yaZ);
    com.tencent.mm.sdk.b.a.IbL.d(this.ydz);
    com.tencent.mm.sdk.b.a.IbL.d(this.ydx);
    this.ydy.dead();
    removeSceneEndListener(1633);
    removeSceneEndListener(1241);
    removeSceneEndListener(2677);
    removeSceneEndListener(2504);
    removeSceneEndListener(2702);
    removeSceneEndListener(2682);
    this.xZK.dead();
    this.ydA.dead();
    com.tencent.mm.plugin.wallet.pay.a.b.aEe(this.dyV);
    com.tencent.mm.sdk.platformtools.aq.aA(this.xXi);
    AppMethodBeat.o(68070);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(68061);
    ad.i("MicroMsg.RemittanceBusiUI", "onDialogDismiss()");
    com.tencent.mm.sdk.platformtools.aq.o(this.xXi, 300L);
    AppMethodBeat.o(68061);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68064);
    if ((this.xWL != null) && (this.xWL.onKeyUp(paramInt, paramKeyEvent)))
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
    ad.v("MicroMsg.RemittanceBusiUI", "onNewIntent");
    AppMethodBeat.o(68082);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68060);
    super.onPause();
    ad.i("MicroMsg.RemittanceBusiUI", "onPause()");
    if ((!this.ycM) && (!this.xWL.fQX())) {
      this.state = 3;
    }
    AppMethodBeat.o(68060);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68059);
    super.onResume();
    ad.i("MicroMsg.RemittanceBusiUI", "onResume()");
    e.dJC().gc(this);
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      showNormalStWcKb();
    }
    if (!this.ycM) {
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
        localObject1 = e.dJC();
        ad.w("MicroMsg.RemittanceBusiDialogMgr", "hideProgress()");
        localObject1 = (Context)((e)localObject1).cya.get();
        if (localObject1 == null) {
          ad.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
        }
      }
      else
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label1626;
        }
        if (paramString.xXT.ozR != 0) {
          break label1431;
        }
        this.ydp = paramString;
        this.ybI = paramString.xXT.FvH;
        this.wxW = paramString.xXT.FvI;
        this.ybN = paramString.xXT.FvJ;
        this.yda = paramString.xXT.FLG;
        this.ydb = paramString.xXT.FLF;
        this.ycQ = paramString.xXT.FLL;
        this.ycR = paramString.xXT.FLK;
        this.ycT = paramString.xXT.FLO;
        this.ycU = paramString.xXT.FLM;
        this.ycV = paramString.xXT.FLN;
        this.ycX = i.a(paramString.xXT.FLT).toString();
        ad.i("MicroMsg.RemittanceBusiUI", "touch_challenge: %s need_change_auth_key: %s mBusiF2FFaultConfig: %s", new Object[] { paramString.xXT.FLP, Integer.valueOf(paramString.xXT.FLQ), this.ycX });
        if (paramString.xXT.FLP != null) {
          com.tencent.mm.plugin.fingerprint.b.p.thl.thf = paramString.xXT.FLP.ffY();
        }
        paramn = com.tencent.mm.plugin.fingerprint.b.p.thl;
        if (paramString.xXT.FLQ != 1) {
          break label594;
        }
        bool = true;
        paramn.thn = bool;
        if (a(paramString)) {
          break label1424;
        }
        ad.i("MicroMsg.RemittanceBusiUI", "showNameVerifyDialog");
        if (paramString.xXT.FLW != null) {
          break label600;
        }
        ad.e("MicroMsg.RemittanceBusiUI", "orderScene.response.check_recv_name_win is null");
        paramInt1 = 0;
        if (paramInt1 == 0)
        {
          if (paramString.xXT.FLU == null) {
            break label1266;
          }
          ad.i("MicroMsg.RemittanceBusiUI", "showMoneyRemind amount_remind_win");
          dJJ();
          if ((e.dJC().getContext() != null) && ((e.dJC().getContext() instanceof RemittanceBusiUI))) {
            this.ydl = paramString.xXT.FLU.FvS;
          }
          paramn = e.dJC();
          localObject2 = paramString.xXT.FLU;
          paramInt1 = this.xWC;
          localObject3 = new a(paramString) {};
          localObject4 = new a(paramString) {};
          ad.w("MicroMsg.RemittanceBusiDialogMgr", "showAmountRemindWin() amountRemindBit:%s", new Object[] { Integer.valueOf(paramInt1) });
          paramn = (Context)paramn.cya.get();
          if (paramn != null) {
            break label925;
          }
          ad.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
          label521:
          if (e.dJC().getContext() != null)
          {
            if (!(e.dJC().getContext() instanceof RemittanceBusiUI)) {
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
      dJJ();
      localObject4 = paramString.xXT.FLW.title;
      Object localObject6 = paramString.xXT.FLW.dxD;
      Object localObject7 = paramString.xXT.FLW.FXo;
      localObject2 = paramString.xXT.FLW.DnV.dxD;
      localObject3 = paramString.xXT.FLW.DnW.dxD;
      paramn = new c(this);
      paramn.xZS = new c.a()
      {
        public final void awm(final String paramAnonymousString)
        {
          AppMethodBeat.i(174427);
          ad.i("MicroMsg.RemittanceBusiUI", "showNameVerifyDialog onINputName() name:%s", new Object[] { paramAnonymousString });
          RemittanceBusiUI.this.hideVKB();
          com.tencent.mm.plugin.report.service.g.yhR.f(19229, new Object[] { Integer.valueOf(0), Integer.valueOf(paramString.xXT.FLW.FXp), Integer.valueOf(0), RemittanceBusiUI.Y(RemittanceBusiUI.this) });
          com.tencent.mm.wallet_core.c.l.a(RemittanceBusiUI.this, paramString.xXT.FLW.DnW, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dF(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(174422);
              ad.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog right button click jumpItem.action:continue");
              RemittanceBusiUI.a(RemittanceBusiUI.this, paramAnonymousString, RemittanceBusiUI.35.this.ydF.xXT.FLW.FLC);
              AppMethodBeat.o(174422);
            }
            
            public final void dIY()
            {
              AppMethodBeat.i(174423);
              ad.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog right button click jumpItem.action:close");
              AppMethodBeat.o(174423);
            }
            
            public final void dJf()
            {
              AppMethodBeat.i(174421);
              ad.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog right button click jumpItem.action:exit");
              RemittanceBusiUI.Z(RemittanceBusiUI.this);
              AppMethodBeat.o(174421);
            }
          });
          AppMethodBeat.o(174427);
        }
        
        public final void onCancel()
        {
          AppMethodBeat.i(174428);
          ad.i("MicroMsg.RemittanceBusiUI", "showNameVerifyDialog onCancel()");
          RemittanceBusiUI.this.hideVKB();
          com.tencent.mm.plugin.report.service.g.yhR.f(19229, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.xXT.FLW.FXp), Integer.valueOf(0), RemittanceBusiUI.Y(RemittanceBusiUI.this) });
          com.tencent.mm.wallet_core.c.l.a(RemittanceBusiUI.this, paramString.xXT.FLW.DnV, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dF(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(174425);
              ad.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog left button click jumpItem.action：continue");
              AppMethodBeat.o(174425);
            }
            
            public final void dIY()
            {
              AppMethodBeat.i(174426);
              ad.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog left button click jumpItem.action：close");
              AppMethodBeat.o(174426);
            }
            
            public final void dJf()
            {
              AppMethodBeat.i(174424);
              ad.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog left button click jumpItem.action:exit");
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
      ((MMNeat7extView)((View)localObject5).findViewById(2131298739)).ar((CharSequence)localObject6);
      ((TextView)localObject8).setText((CharSequence)localObject7);
      localObject6 = new d.a(paramn.mContext);
      ((d.a)localObject6).aXF((String)localObject4).gY((View)localObject5);
      localObject4 = com.tencent.mm.ui.tools.b.c.d((EditText)localObject1);
      ((com.tencent.mm.ui.tools.b.c)localObject4).neC = f.a.KIM;
      localObject4 = ((com.tencent.mm.ui.tools.b.c)localObject4).kc(1, 1);
      ((com.tencent.mm.ui.tools.b.c)localObject4).KMn = false;
      ((com.tencent.mm.ui.tools.b.c)localObject4).a(null);
      com.tencent.mm.sdk.platformtools.aq.o(new c.10(paramn, (EditText)localObject1), 200L);
      ((d.a)localObject6).aXM((String)localObject3).afn(-2141754475).a(false, new c.11(paramn, (EditText)localObject1));
      ((d.a)localObject6).aXN((String)localObject2).d(new c.2(paramn));
      localObject2 = ((d.a)localObject6).fMb();
      ((com.tencent.mm.ui.widget.a.d)localObject2).show();
      ((EditText)localObject1).addTextChangedListener(new c.3(paramn, (EditText)localObject1, (com.tencent.mm.ui.widget.a.d)localObject2));
      paramInt1 = 1;
      break label371;
      label925:
      if (localObject2 == null)
      {
        ad.i("MicroMsg.JumpItemUtil", "showAmountRemindWin() amountRemindWin == null");
        break label521;
      }
      localObject1 = LayoutInflater.from(paramn).inflate(2131494544, null, false);
      localObject5 = ((View)localObject1).findViewById(2131299648);
      localObject6 = (WalletTextView)((View)localObject1).findViewById(2131299647);
      localObject7 = ((View)localObject1).findViewById(2131306753);
      localObject8 = ((View)localObject1).findViewById(2131306751);
      double d = ((dq)localObject2).FvS / 100.0D;
      ((WalletTextView)localObject6).setText(com.tencent.mm.wallet_core.ui.e.C(d));
      if (bt.jx(paramInt1, 0))
      {
        ad.i("MicroMsg.JumpItemUtil", "mAmountRemindBit == 0");
        ((View)localObject8).setVisibility(8);
      }
      for (;;)
      {
        localObject5 = ((dq)localObject2).dxD;
        localObject6 = ((dq)localObject2).DnW.dxD;
        localObject7 = ((dq)localObject2).DnV.dxD;
        localObject4 = new l.8(paramn, (dq)localObject2, d, (l.a)localObject4);
        localObject2 = new l.9(paramn, (dq)localObject2, d, (l.a)localObject3);
        localObject3 = new d.a(paramn);
        ((d.a)localObject3).aXF((String)localObject5);
        ((d.a)localObject3).gY((View)localObject1);
        ((d.a)localObject3).aXM((String)localObject6).c((DialogInterface.OnClickListener)localObject4);
        ((d.a)localObject3).aXN((String)localObject7).d((DialogInterface.OnClickListener)localObject2);
        ((d.a)localObject3).yR(false);
        ((d.a)localObject3).yS(true);
        localObject1 = ((d.a)localObject3).fMb();
        ((com.tencent.mm.ui.widget.a.d)localObject1).show();
        com.tencent.mm.ui.base.h.a(paramn, (Dialog)localObject1);
        break;
        TextView localTextView = (TextView)((View)localObject1).findViewById(2131306756);
        ((View)localObject8).setVisibility(0);
        ((View)localObject8).post(new l.7((View)localObject7, d, paramInt1, (WalletTextView)localObject6, (View)localObject5, (View)localObject8, localTextView));
      }
      label1244:
      if (!(e.dJC().getContext() instanceof RemittanceF2fLargeMoneyUI)) {
        break label548;
      }
      a(9, paramString);
      break label548;
      label1266:
      if (paramString.xXT.FLV != null)
      {
        ad.i("MicroMsg.RemittanceBusiUI", "showMoneyRemind amount_remind_page");
        dJJ();
        paramn = new Intent();
        paramn.putExtra("key_amount_remind_bit", this.xWC);
        paramn.putExtra("key_title", paramString.xXT.FLV.title);
        paramn.putExtra("key_desc", paramString.xXT.FLV.dxD);
        paramn.putExtra("key_amount_remind_sign", paramString.xXT.FLV.FvR);
        com.tencent.mm.bs.d.b(this, "wallet_payu", ".pay.ui.WalletPayUOrderInfoUI", paramn, 4);
        a(6, paramString);
        break label548;
      }
      if ((e.dJC().getContext() != null) && ((e.dJC().getContext() instanceof RemittanceF2fLargeMoneyUI))) {
        a(8, paramString);
      }
      paramInt1 = 0;
      break label550;
      label1424:
      dJJ();
      continue;
      label1431:
      dJJ();
      ad.e("MicroMsg.RemittanceBusiUI", "place order response: %s, %s", new Object[] { Integer.valueOf(paramString.xXT.ozR), paramString.xXT.ozS });
      if ((paramString.xXT.FLE != null) && (!bt.isNullOrNil(paramString.xXT.FLE.kzK))) {
        a(paramString);
      }
      for (;;)
      {
        if (paramString.xXT.FLH != 1) {
          break label1624;
        }
        a(null, null, 0);
        break;
        localObject2 = e.dJC();
        localObject1 = paramString.xXT.ozS;
        paramn = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68029);
            if (bt.jx(((i)paramn).xXT.FLS, 1))
            {
              if (e.dJC().dJD()) {
                ad.w("MicroMsg.RemittanceBusiUI", "finish finishRemitF2fDCodeAndLMRemindUI");
              }
              RemittanceBusiUI.this.finish();
            }
            AppMethodBeat.o(68029);
          }
        };
        ad.w("MicroMsg.RemittanceBusiDialogMgr", "showAlert3() msg:%s, title:%s", new Object[] { bt.nullAsNil((String)localObject1), bt.nullAsNil("") });
        localObject2 = (Context)((e)localObject2).cya.get();
        if (localObject2 == null) {
          ad.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
        } else {
          com.tencent.mm.ui.base.h.d((Context)localObject2, (String)localObject1, "", paramn);
        }
      }
      label1624:
      continue;
      label1626:
      ad.e("MicroMsg.RemittanceBusiUI", "net error: %s", new Object[] { paramn });
      continue;
      if ((paramn instanceof com.tencent.mm.plugin.remittance.model.h))
      {
        ad.i("MicroMsg.RemittanceBusiUI", "pay check callback");
        AppMethodBeat.o(68071);
        return true;
      }
      if ((paramn instanceof com.tencent.mm.plugin.remittance.model.g))
      {
        ad.i("MicroMsg.RemittanceBusiUI", "onSceneEnd %s errType %s errCode %s", new Object[] { paramn, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        paramString = (com.tencent.mm.plugin.remittance.model.g)paramn;
        if ((!paramString.xXR.equals(this.yde.xXR)) || (paramString.cancel))
        {
          paramString.xXQ = true;
          ad.e("MicroMsg.RemittanceBusiUI", "ignore this getFavor new coming soon %s", new Object[] { Boolean.valueOf(paramString.cancel) });
          AppMethodBeat.o(68071);
          return true;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramString.xXN.ozR == 0)
          {
            this.ycZ.xZP = paramString.xXN.xXE;
            this.ycZ.awt(paramString.xXN.xXE.FLj);
            dJI();
            paramn = paramString.xXO;
            ad.i("MicroMsg.RemittanceBusiUI", "GetFavorAfterAction %s", new Object[] { paramn });
            if (paramn != null) {
              paramn.fq(this.ycZ.dJl());
            }
          }
        }
        for (;;)
        {
          paramString.xXQ = true;
          AppMethodBeat.o(68071);
          return true;
          this.ycZ.dJk();
          this.ycs.setTextColor(getContext().getResources().getColor(2131100212));
          this.ycs.setText(paramString.xXN.ozS);
          paramn = paramString.xXP;
          if (paramn != null)
          {
            paramn.a(paramInt1, paramInt2, paramString);
            continue;
            this.ycZ.dJk();
            if ((this.ybR != null) && (!bt.isNullOrNil(this.ybR.xXz))) {
              this.ycs.setText(this.ybR.xXz);
            }
            this.ycs.setTextColor(getContext().getResources().getColor(2131100212));
            this.ycs.setText(getString(2131762427));
            paramn = paramString.xXP;
            if (paramn != null) {
              paramn.a(paramInt1, paramInt2, paramString);
            }
          }
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.remittance.model.l))
      {
        paramString = (com.tencent.mm.plugin.remittance.model.l)paramn;
        ad.i("MicroMsg.RemittanceBusiUI", "NetSceneBusiF2fZeroCallback getHasRetried %s", new Object[] { Boolean.valueOf(paramString.hasRetried) });
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (paramString.xXY.ozR == 0)
          {
            dJL();
          }
          else
          {
            dJK();
            e.dJC().a(paramString.xXY.ozS, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
          }
        }
        else {
          e.dJC().a(getString(2131765901), new DialogInterface.OnClickListener()
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
    
    public void dIY() {}
    
    public final int dIZ()
    {
      return 1072;
    }
    
    public void dJb() {}
    
    public final void dJf()
    {
      Object localObject = new Intent();
      ((Intent)localObject).setComponent(new ComponentName(aj.getPackageName(), "com.tencent.mm.ui.LauncherUI"));
      ((Intent)localObject).addFlags(67108864);
      RemittanceBusiUI localRemittanceBusiUI = RemittanceBusiUI.this;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localRemittanceBusiUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$IRemitBusiJumpItemCallback", "onExit", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localRemittanceBusiUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(localRemittanceBusiUI, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$IRemitBusiJumpItemCallback", "onExit", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  final class b
  {
    private float marginTop;
    private View rY;
    private float ydL;
    private float ydM;
    private TenpaySecureEditText ydN;
    private TextView ydO;
    private RelativeLayout ydP;
    
    b(int paramInt1, int paramInt2, float paramFloat)
    {
      AppMethodBeat.i(68053);
      this.ydL = paramInt1;
      this.ydM = paramInt2;
      this.marginTop = paramFloat;
      AppMethodBeat.o(68053);
    }
    
    final void update()
    {
      AppMethodBeat.i(68054);
      RemittanceBusiUI.a(RemittanceBusiUI.this).setTextSize(1, this.ydM);
      RemittanceBusiUI.b(RemittanceBusiUI.this).setTextSize(1, this.ydL);
      if (this.ydO == null) {
        this.ydO = ((TextView)RemittanceBusiUI.c(RemittanceBusiUI.this).findViewById(2131306836));
      }
      if (this.ydO != null) {
        this.ydO.setTextSize(this.ydL);
      }
      if (this.ydN == null) {
        this.ydN = ((TenpaySecureEditText)RemittanceBusiUI.c(RemittanceBusiUI.this).findViewById(2131306718));
      }
      if (this.ydN != null) {
        this.ydN.setTextSize(this.ydM);
      }
      if (this.rY == null) {
        this.rY = this.ydN.findViewById(2131302445);
      }
      if (this.rY != null) {
        this.rY.setMinimumHeight(BackwardSupportUtil.b.g(RemittanceBusiUI.this, RemittanceBusiUI.d(RemittanceBusiUI.this).ydM));
      }
      if (this.ydP == null) {
        this.ydP = ((RelativeLayout)RemittanceBusiUI.this.findViewById(2131306754));
      }
      if (this.ydP != null) {
        ((LinearLayout.LayoutParams)this.ydP.getLayoutParams()).topMargin = BackwardSupportUtil.b.g(RemittanceBusiUI.this, this.marginTop);
      }
      AppMethodBeat.o(68054);
    }
  }
  
  final class c
    implements Runnable
  {
    public com.tencent.mm.wallet_core.d.d ydQ;
    
    c() {}
    
    public final void run()
    {
      AppMethodBeat.i(68055);
      RemittanceBusiUI.Q(RemittanceBusiUI.this).b(this.ydQ);
      AppMethodBeat.o(68055);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI
 * JD-Core Version:    0.7.0.1
 */