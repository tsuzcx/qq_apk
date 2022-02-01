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
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aq;
import com.tencent.mm.g.a.ge;
import com.tencent.mm.g.a.ge.a;
import com.tencent.mm.g.a.gf;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.yc;
import com.tencent.mm.g.b.a.gb;
import com.tencent.mm.g.b.a.x;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.aid;
import com.tencent.mm.protocal.protobuf.aie;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.cys;
import com.tencent.mm.protocal.protobuf.dhy;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.protocal.protobuf.do;
import com.tencent.mm.protocal.protobuf.dp;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.protocal.protobuf.ow;
import com.tencent.mm.protocal.protobuf.pa;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.vs;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
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
  private double daf;
  private String dnh;
  private int dtm;
  private int mChannel;
  private int mPayScene;
  private int mRequestCode;
  private int state;
  private ScrollView tEk;
  private String vsE;
  private int wIV;
  private Runnable wJB;
  private int wJc;
  private WcPayKeyboard wJe;
  private WalletFormView wJl;
  private RelativeLayout wJm;
  private TextView wJn;
  private RelativeLayout wJo;
  private LinearLayout wMN;
  private com.tencent.mm.sdk.b.c<aq> wMd;
  private String wMx;
  private String wNc;
  private boolean wNh;
  private gb wNj;
  private boolean wNm;
  private boolean wNp;
  private com.tencent.mm.sdk.b.c wNr;
  private TextView wOE;
  private TextView wOF;
  private TextView wOG;
  private TextView wOH;
  private TextView wOI;
  private TextView wOJ;
  private TextView wOK;
  private View wOL;
  private CdnImageView wOM;
  private LinearLayout wON;
  private LinearLayout wOO;
  private TextView wOP;
  private View wOQ;
  private TextView wOR;
  private Button wOS;
  private RelativeLayout wOT;
  private String wOU;
  private double wOV;
  private String wOW;
  private String wOX;
  private String wOY;
  private String wOZ;
  private String wOa;
  private String wOb;
  private String wOf;
  private BusiRemittanceResp wOj;
  private Map<String, dj> wPA;
  private RemittanceF2fDynamicCodeUI wPB;
  private boolean wPC;
  private int wPD;
  private boolean wPE;
  private int wPF;
  private int wPG;
  private i wPH;
  private Runnable wPI;
  private com.tencent.mm.wallet_core.d.c<com.tencent.mm.plugin.remittance.model.l> wPJ;
  private c wPK;
  private boolean wPL;
  private double wPM;
  private String wPN;
  private String wPO;
  private com.tencent.mm.sdk.b.c wPP;
  private com.tencent.mm.sdk.b.c wPQ;
  private com.tencent.mm.sdk.b.c wPR;
  private com.tencent.mm.sdk.b.c wPS;
  private String wPa;
  private int wPb;
  private String wPc;
  private float wPd;
  private boolean wPe;
  private String wPf;
  private int wPg;
  private int wPh;
  private String wPi;
  private dhy wPj;
  private String wPk;
  private int wPl;
  private int wPm;
  private int wPn;
  private int wPo;
  private String wPp;
  private String wPq;
  private b wPr;
  private String wPs;
  private String wPt;
  boolean wPu;
  private boolean wPv;
  com.tencent.mm.plugin.remittance.model.g wPw;
  private b wPx;
  private b wPy;
  protected boolean wPz;
  
  public RemittanceBusiUI()
  {
    AppMethodBeat.i(68056);
    this.wPd = 0.0F;
    this.wIV = 4;
    this.wPl = 0;
    this.wPm = 0;
    this.wPn = 0;
    this.wPo = 0;
    this.wPr = new b();
    this.wPs = "";
    this.wPt = "";
    this.wPu = false;
    this.daf = -1.0D;
    this.wPv = false;
    this.wPw = null;
    this.wNh = false;
    this.wPz = false;
    this.mRequestCode = 0;
    this.wPA = new HashMap();
    this.wPB = null;
    this.wPC = false;
    this.wPE = false;
    this.state = 0;
    this.wJB = new Runnable()
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
    this.wPI = new RemittanceBusiUI.15(this);
    this.wPJ = new com.tencent.mm.wallet_core.d.c()
    {
      public final void a(com.tencent.mm.wallet_core.d.d paramAnonymousd)
      {
        AppMethodBeat.i(163820);
        if ((paramAnonymousd instanceof com.tencent.mm.plugin.remittance.model.l)) {
          RemittanceBusiUI.b(RemittanceBusiUI.this, ((com.tencent.mm.plugin.remittance.model.l)paramAnonymousd).dac);
        }
        AppMethodBeat.o(163820);
      }
    };
    this.wPK = new c();
    this.wMd = new com.tencent.mm.sdk.b.c() {};
    this.wPL = true;
    this.dtm = 0;
    this.wPM = 0.0D;
    this.wPO = "";
    this.wNr = new com.tencent.mm.sdk.b.c() {};
    this.wPP = new com.tencent.mm.sdk.b.c() {};
    this.wPQ = new RemittanceBusiUI.30(this);
    this.wPR = new com.tencent.mm.sdk.b.c() {};
    this.wPS = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(68056);
  }
  
  private void a(int paramInt, ou paramou, boolean paramBoolean, ge paramge, String paramString1, String paramString2)
  {
    AppMethodBeat.i(68077);
    a(paramInt, paramou, paramBoolean, paramge, paramString1, paramString2, "");
    AppMethodBeat.o(68077);
  }
  
  private void a(int paramInt, ou paramou, boolean paramBoolean, ge paramge, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(163834);
    int i = 0;
    int j = 0;
    if (!this.wPL)
    {
      boolean bool1 = bs.I(Double.valueOf(this.wPM), Double.valueOf(this.wOV));
      boolean bool2 = bs.lr(this.wPN, this.wOb);
      if (!bool1) {
        j = 1;
      }
      i = j;
      if (!bool2) {
        i = j | 0x2;
      }
    }
    String str1 = this.wNc;
    String str2 = this.wOU;
    j = this.mPayScene;
    String str3 = this.wOZ;
    String str4 = this.wOb;
    int k = this.mChannel;
    String str5 = this.wPa;
    String str6 = this.wPf;
    int m = this.wPh;
    int n = this.wPg;
    String str7 = this.wOW;
    aid localaid = this.wPr.wMh;
    if (paramou == null)
    {
      paramou = "";
      paramString1 = new i(str1, str2, j, str3, str4, paramInt, k, str5, str6, m, n, str7, localaid, paramou, this.wOj.wJT, paramString1, this.wMx, paramString2, this.wOX, this.wPO, this.dtm, i, paramString3);
      if (paramBoolean) {
        paramString1.a(paramge);
      }
      if ((!this.mKindaEnable) || (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_QRCODE_RECEIVE_PAY_SWTICH_KEY"))) {
        break label383;
      }
      if (this.wPB == null) {
        break label376;
      }
      this.wPB.showSafeProgress();
    }
    label275:
    label279:
    label411:
    label424:
    for (;;)
    {
      paramBoolean = false;
      paramou = this;
      paramou.doSceneProgress(paramString1, paramBoolean);
      if (this.wPC)
      {
        if (paramInt == this.wPD) {
          a(5, this.wPH);
        }
      }
      else {
        label310:
        if ((e.dyk().getContext() != null) && ((e.dyk().getContext() instanceof RemittanceBusiUI))) {
          if (this.wPE)
          {
            if (paramInt != this.wPG) {
              break label411;
            }
            a(13, this.wPH);
          }
        }
      }
      for (;;)
      {
        this.wPG = paramInt;
        AppMethodBeat.o(163834);
        return;
        paramou = paramou.EeL;
        break;
        label376:
        showLoading();
        break label275;
        label383:
        if (e.dyk().dyn()) {
          break label424;
        }
        paramBoolean = true;
        paramou = this;
        break label279;
        a(4, this.wPH);
        break label310;
        a(12, this.wPH);
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
    if (this.wPu)
    {
      this.wOR.setText(com.tencent.mm.wallet_core.ui.e.C(dyp()));
      ap.aB(this.wPI);
      this.wOV = dyp();
      long l = Math.round(this.wOV * 100.0D);
      if (l <= 0L)
      {
        this.wPr.dxS();
        this.wOK.setTextColor(getContext().getResources().getColor(2131100212));
        this.wOK.setText(this.wOj.wJS);
        if (this.wPw != null) {
          this.wPw.cancel = true;
        }
        AppMethodBeat.o(68069);
        return;
      }
      j = (int)l;
      k = this.mChannel;
      m = this.wOj.wJT;
      str1 = this.wOZ;
      str2 = this.wMx;
      str3 = this.wOj.wJU;
      str4 = this.wNc;
      str5 = this.wOW;
      str6 = this.wOj.wJV;
      if (paramc != null) {
        break label243;
      }
    }
    label243:
    for (int i = 0;; i = 1)
    {
      this.wPw = new com.tencent.mm.plugin.remittance.model.g(j, k, m, str1, str2, str3, str4, str5, str6, i, paramc, paramd);
      ap.n(this.wPI, paramInt);
      AppMethodBeat.o(68069);
      return;
    }
  }
  
  private void a(pa parampa)
  {
    AppMethodBeat.i(68085);
    ac.i("MicroMsg.RemittanceBusiUI", "resp.payer_need_auth_flag %s", new Object[] { Integer.valueOf(parampa.Efk) });
    if (parampa.Efk == 1)
    {
      parampa = new Bundle();
      com.tencent.mm.sdk.b.a.GpY.c(this.wPR);
      parampa.putString("realname_verify_process_jump_activity", ".ui.RemittanceBusiUI");
      parampa.putString("realname_verify_process_jump_plugin", "remittance");
      parampa.putInt("real_name_verify_mode", 0);
      parampa.putInt("entry_scene", this.mPayScene);
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, parampa);
      AppMethodBeat.o(68085);
      return;
    }
    Intent localIntent = new Intent();
    Object localObject;
    if (!bs.isNullOrNil(this.wPq)) {
      localObject = this.wPq;
    }
    for (;;)
    {
      localIntent.putExtra("INTENT_TITLE", (String)localObject);
      localIntent.putExtra("INTENT_CAN_TOUCH", this.wPl);
      localIntent.putExtra("INTENT_PAYFEE", com.tencent.mm.wallet_core.ui.e.C(0.0D));
      localIntent.putExtra("INTENT_REQKEY", parampa.djr);
      parampa = parampa.Efl;
      try
      {
        localIntent.putExtra("INTENT_TOKENMESS", parampa.toByteArray());
        com.tencent.mm.br.d.b(getContext(), "wallet", "com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI", localIntent, 2);
        AppMethodBeat.o(68085);
        return;
      }
      catch (Exception parampa)
      {
        String str;
        StringBuilder localStringBuilder;
        ac.printErrStackTrace("MicroMsg.RemittanceBusiUI", parampa, "", new Object[0]);
        AppMethodBeat.o(68085);
      }
      str = getString(2131765746);
      if (!bs.isNullOrNil(this.wOW))
      {
        com.tencent.mm.kernel.g.agS();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNr(this.wOW);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.storage.ai)localObject).aaS();
          localStringBuilder = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.aSP((String)localObject));
          if (bs.isNullOrNil(this.wOX)) {}
          for (localObject = "";; localObject = "(" + this.wOX + ")")
          {
            localObject = bs.u(str, new Object[] { (String)localObject });
            break;
          }
        }
        ac.e("MicroMsg.RemittanceBusiUI", "can not found contact for user::" + this.wOW);
        localObject = "";
      }
      else
      {
        ac.e("MicroMsg.RemittanceBusiUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
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
      ac.i("MicroMsg.RemittanceBusiUI", "onActivityResult _transId: %s _totalFee: %s", new Object[] { str1, Double.valueOf(d) });
      if (bs.isNullOrNil(this.vsE)) {
        this.vsE = str1;
      }
      if (d >= 0.0D) {
        this.daf = d;
      }
      if (this.wNh) {
        com.tencent.mm.plugin.report.service.h.wUl.f(15386, new Object[] { Integer.valueOf(3), Integer.valueOf(2) });
      }
      dyt();
      arw(str2);
    }
    for (;;)
    {
      c(paramBoolean, paramIntent);
      AppMethodBeat.o(68073);
      return;
      if (ag.br(paramIntent))
      {
        finish();
        AppMethodBeat.o(68073);
        return;
      }
      if (ag.bs(paramIntent))
      {
        AppMethodBeat.o(68073);
        return;
      }
      ac.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor");
      dys();
    }
  }
  
  private boolean a(i parami)
  {
    AppMethodBeat.i(68079);
    boolean bool1 = false;
    if (!this.wNm) {
      bool1 = b(parami);
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = c(parami);
    }
    AppMethodBeat.o(68079);
    return bool2;
  }
  
  private void arw(String paramString)
  {
    AppMethodBeat.i(68086);
    ac.i("MicroMsg.RemittanceBusiUI", "do pay check: %s", new Object[] { paramString });
    paramString = (dj)this.wPA.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(68086);
      return;
    }
    if (!bs.isNullOrNil(this.vsE)) {
      paramString.DQt = this.vsE;
    }
    doSceneProgress(new com.tencent.mm.plugin.remittance.model.h(paramString, this.wPs), false);
    AppMethodBeat.o(68086);
  }
  
  private boolean b(final i parami)
  {
    AppMethodBeat.i(68080);
    if (!bs.isNullOrNil(parami.wKm.Efe))
    {
      this.wNm = true;
      bD(1, parami.wKm.DQs);
      e.dyk().a(parami.wKm.Efe, getString(2131755873), getString(2131762423), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68036);
          RemittanceBusiUI.a(RemittanceBusiUI.this, 3, parami.wKm.DQs);
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
          RemittanceBusiUI.a(RemittanceBusiUI.this, 2, parami.wKm.DQs);
          AppMethodBeat.o(163824);
        }
      });
      AppMethodBeat.o(68080);
      return true;
    }
    AppMethodBeat.o(68080);
    return false;
  }
  
  private void bD(int paramInt, String paramString)
  {
    AppMethodBeat.i(68081);
    this.wNj = new gb();
    this.wNj.dHY = 1L;
    this.wNj.dCQ = paramInt;
    this.wNj.nB(paramString);
    this.wNj.aHZ();
    AppMethodBeat.o(68081);
  }
  
  private void c(boolean paramBoolean, Intent paramIntent)
  {
    AppMethodBeat.i(68074);
    this.wPL = false;
    if (paramBoolean)
    {
      ac.i("MicroMsg.RemittanceBusiUI", "savePayInfo isOk = true");
      this.dtm = 1;
    }
    for (;;)
    {
      ac.i("MicroMsg.RemittanceBusiUI", "savePayInfo() mLastPayResult:%s mLastTotalAmt:%s mLastPayerDesc:%s mLastF2fId:%s", new Object[] { Double.valueOf(this.wPM), Double.valueOf(this.wPM), this.wPN, this.wPO });
      AppMethodBeat.o(68074);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(68074);
        return;
      }
      this.dtm = paramIntent.getIntExtra("key_pay_reslut_type", 3);
      this.wPM = this.wOV;
      this.wPN = this.wOb;
      this.wPO = this.wOa;
    }
  }
  
  private boolean c(final i parami)
  {
    AppMethodBeat.i(68083);
    if (parami.wKm.Eff != null)
    {
      this.wNp = true;
      e.dyk().a(parami.wKm.nWy, "", parami.wKm.Eff.unX, parami.wKm.Eff.unW, new DialogInterface.OnClickListener()new RemittanceBusiUI.27
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(163825);
          ac.i("MicroMsg.RemittanceBusiUI", "goto h5: %s", new Object[] { parami.wKm.Eff.oxl });
          com.tencent.mm.wallet_core.ui.e.o(RemittanceBusiUI.this.getContext(), parami.wKm.Eff.oxl, false);
          AppMethodBeat.o(163825);
        }
      }, new RemittanceBusiUI.27(this));
      AppMethodBeat.o(68083);
      return true;
    }
    AppMethodBeat.o(68083);
    return false;
  }
  
  private void d(i parami)
  {
    AppMethodBeat.i(68084);
    ac.i("MicroMsg.RemittanceBusiUI", "do start pay zero_pay_flag: %s", new Object[] { Integer.valueOf(parami.wKm.Efj) });
    if (e.dyk().dym()) {
      ac.w("MicroMsg.RemittanceBusiUI", "finish finishRemitLMRemindUI");
    }
    Object localObject1 = new dj();
    ((dj)localObject1).channel = this.mChannel;
    ((dj)localObject1).DQs = this.wOa;
    ((dj)localObject1).DQt = this.vsE;
    ((dj)localObject1).wJT = this.wOj.wJT;
    ((dj)localObject1).scene = this.mPayScene;
    ((dj)localObject1).DQu = this.wOf;
    ((dj)localObject1).DQv = this.wPr.wMh;
    ((dj)localObject1).iAz = this.wOW;
    ((dj)localObject1).wLu = this.wNc;
    ((dj)localObject1).DQw = parami.vGO;
    this.wPA.put(parami.wKm.djr, localObject1);
    if (parami.wKm.Efj == 1)
    {
      a(parami.wKm);
      AppMethodBeat.o(68084);
      return;
    }
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.dac = parami.wKm.djr;
    localPayInfo.dqL = this.mPayScene;
    if (this.mChannel > 0) {
      localPayInfo.channel = this.mChannel;
    }
    if (parami.wKm.Efq != null) {
      localPayInfo.skD = parami.wKm.Efq.eQU();
    }
    localPayInfo.BIq = parami.wKm.Efp;
    Object localObject2;
    if (parami.wKm.Efr == 1)
    {
      bool = true;
      localPayInfo.BxP = bool;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("extinfo_key_1", this.wOW);
      ((Bundle)localObject1).putString("extinfo_key_2", this.wOX);
      ((Bundle)localObject1).putString("extinfo_key_3", this.wOZ);
      ((Bundle)localObject1).putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
      ((Bundle)localObject1).putString("extinfo_key_7", this.wOb);
      ((Bundle)localObject1).putString("extinfo_key_19", parami.wKm.wLe);
      localPayInfo.hbR = ((Bundle)localObject1);
      localPayInfo.wLq = 1;
      localObject2 = new Intent();
      if (parami.wKm.wLb != 1) {
        break label738;
      }
      ((Bundle)localObject1).putInt("extinfo_key_15", parami.wKm.Efs);
      ((Bundle)localObject1).putString("extinfo_key_17", parami.wKm.wLc);
      ((Bundle)localObject1).putString("extinfo_key_18", parami.wKm.wLd);
      ((Intent)localObject2).putExtra("key_pay_info", localPayInfo);
      ((Intent)localObject2).putExtra("from_patch_ui", true);
      ((Intent)localObject2).putExtra("key_rcvr_open_id", this.wNc);
      ((Intent)localObject2).putExtra("key_mch_info", this.wPc);
      ((Intent)localObject2).putExtra("key_mch_photo", this.wOj.wJR);
      ((Intent)localObject2).putExtra("key_transfer_qrcode_id", this.wOU);
      ((Intent)localObject2).putExtra("get_dynamic_code_sign", parami.wKm.wLc);
      ((Intent)localObject2).putExtra("get_dynamic_code_extend", parami.wKm.wLd);
      ((Intent)localObject2).putExtra("dynamic_code_spam_wording", parami.wKm.wLf);
      ((Intent)localObject2).putExtra("dynamic_code_amount", parami.wKm.Efs);
      ((Intent)localObject2).putExtra("show_paying_wording", parami.wKm.wLe);
      if (this.wOj.wJZ != 1) {
        break label733;
      }
    }
    label733:
    for (boolean bool = true;; bool = false)
    {
      ((Intent)localObject2).putExtra("show_avatar_type", bool);
      com.tencent.mm.plugin.report.service.h.wUl.f(15386, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
      this.wNr.alive();
      this.wPP.alive();
      this.wPQ.alive();
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
      if (this.wPB != null) {
        this.mRequestCode = 3;
      }
      str = "";
      if (!bs.isNullOrNil(parami.wKm.wLe))
      {
        parami = parami.wKm.wLe;
        if (localPayInfo.hbR == null) {
          localPayInfo.hbR = new Bundle();
        }
        localPayInfo.hbR.putString("cashier_desc", parami);
        if (bs.isNullOrNil(this.wOW)) {
          break label1349;
        }
        com.tencent.mm.kernel.g.agS();
        parami = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNr(this.wOW);
        if (parami == null) {
          break label1349;
        }
        parami = parami.aaS();
        localObject1 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.aSP(parami));
        if (!bs.isNullOrNil(this.wOX)) {
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
      localPayInfo.hbR.putString("prepay_page_payee", parami);
      if (this.wPB != null) {
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this.wPB, localPayInfo);
      }
      for (;;)
      {
        this.wPz = true;
        AppMethodBeat.o(68084);
        return;
        localObject2 = getIntent().getStringExtra("receiver_tips");
        localObject1 = getString(2131765746);
        parami = str;
        if (!bs.isNullOrNil((String)localObject2))
        {
          localObject1 = localObject2;
          parami = (i)localObject2;
        }
        if (!bs.isNullOrNil(this.wOW))
        {
          com.tencent.mm.kernel.g.agS();
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNr(this.wOW);
          if (localObject2 != null)
          {
            parami = ((com.tencent.mm.storage.ai)localObject2).aaS();
            localObject2 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.aSP(parami));
            if (bs.isNullOrNil(this.wOX)) {}
            for (parami = "";; parami = "(" + this.wOX + ")")
            {
              parami = bs.u((String)localObject1, new Object[] { parami });
              break;
            }
          }
          ac.e("MicroMsg.RemittanceBusiUI", "can not found contact for user::" + this.wOW);
          break;
        }
        ac.e("MicroMsg.RemittanceBusiUI", "mRcverName is null ,scene is MMPAY_PAY_SCENE_TRANSFER busi");
        break;
        parami = "(" + this.wOX + ")";
        break label916;
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, localPayInfo);
      }
      if (!bs.isNullOrNil(parami.wKn)) {}
      for (this.wNh = true; (parami.wKo != null) && (parami.wKo.dgB.dgE != null); this.wNh = false)
      {
        f.a(parami.wKo.dgB.dgE, false, "", localPayInfo, this.wOX, (Intent)localObject2, parami.wKo.dgB.mRequestCode);
        AppMethodBeat.o(68084);
        return;
      }
      f.a(this, false, "", localPayInfo, this.wOX, (Intent)localObject2, 1);
      AppMethodBeat.o(68084);
      return;
    }
  }
  
  private void dqE()
  {
    AppMethodBeat.i(68087);
    this.wOV = dyp();
    if (this.wOV <= 0.0D)
    {
      findViewById(2131299860).setClickable(false);
      findViewById(2131299860).setEnabled(false);
      findViewById(2131299860).setOnClickListener(null);
      ln(false);
      this.wOK.setTextColor(getResources().getColor(2131100707));
      AppMethodBeat.o(68087);
      return;
    }
    this.wOK.setTextColor(getContext().getResources().getColor(2131100212));
    findViewById(2131299860).setEnabled(true);
    findViewById(2131299860).setClickable(true);
    ln(true);
    findViewById(2131299860).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163832);
        com.tencent.mm.plugin.report.service.h.wUl.f(15235, new Object[] { Integer.valueOf(3) });
        if (RemittanceBusiUI.n(RemittanceBusiUI.this) == 56) {
          com.tencent.mm.plugin.report.service.h.wUl.f(19821, new Object[] { Integer.valueOf(7), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
        }
        RemittanceBusiUI.J(RemittanceBusiUI.this);
        AppMethodBeat.o(163832);
      }
    });
    AppMethodBeat.o(68087);
  }
  
  private void dyf()
  {
    AppMethodBeat.i(68066);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68019);
        RemittanceBusiUI.E(RemittanceBusiUI.this).setText(RemittanceBusiUI.D(RemittanceBusiUI.this));
        Object localObject;
        if ((RemittanceBusiUI.k(RemittanceBusiUI.this) != null) && (!bs.isNullOrNil(RemittanceBusiUI.k(RemittanceBusiUI.this).wKa)))
        {
          localObject = RemittanceBusiUI.k(RemittanceBusiUI.this).wKa;
          RemittanceBusiUI.H(RemittanceBusiUI.this).setText(com.tencent.mm.pluginsdk.ui.span.k.b(RemittanceBusiUI.this, (CharSequence)localObject, RemittanceBusiUI.H(RemittanceBusiUI.this).getTextSize()));
          if (RemittanceBusiUI.k(RemittanceBusiUI.this) == null) {
            break label358;
          }
          if (RemittanceBusiUI.k(RemittanceBusiUI.this).wJQ != 1) {
            break label340;
          }
          if (bs.isNullOrNil(RemittanceBusiUI.k(RemittanceBusiUI.this).wJR)) {
            break label267;
          }
          if (RemittanceBusiUI.k(RemittanceBusiUI.this).wJZ != 1) {
            break label253;
          }
          RemittanceBusiUI.I(RemittanceBusiUI.this).setRoundCorner(true);
        }
        for (;;)
        {
          int i = BackwardSupportUtil.b.g(RemittanceBusiUI.this, 36.0F);
          RemittanceBusiUI.I(RemittanceBusiUI.this).r(RemittanceBusiUI.k(RemittanceBusiUI.this).wJR, i, i, -1);
          AppMethodBeat.o(68019);
          return;
          String str = com.tencent.mm.wallet_core.ui.e.gr(com.tencent.mm.wallet_core.ui.e.wk(RemittanceBusiUI.F(RemittanceBusiUI.this)), 10);
          localObject = str;
          if (bs.isNullOrNil(RemittanceBusiUI.G(RemittanceBusiUI.this))) {
            break;
          }
          localObject = RemittanceBusiUI.this.getString(2131762438, new Object[] { str, RemittanceBusiUI.G(RemittanceBusiUI.this) });
          break;
          label253:
          RemittanceBusiUI.I(RemittanceBusiUI.this).setRoundCorner(false);
        }
        label267:
        if (!bs.isNullOrNil(RemittanceBusiUI.F(RemittanceBusiUI.this)))
        {
          if (RemittanceBusiUI.k(RemittanceBusiUI.this).wJZ == 1)
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
  
  private double dyp()
  {
    AppMethodBeat.i(68057);
    if ((this.wPe) || (this.mPayScene == 33))
    {
      d = this.wOV;
      AppMethodBeat.o(68057);
      return d;
    }
    this.wOV = bs.getDouble(this.wJl.getText(), 0.0D);
    double d = this.wOV;
    AppMethodBeat.o(68057);
    return d;
  }
  
  private boolean dyq()
  {
    AppMethodBeat.i(68067);
    boolean bool;
    if (this.wOL == null) {
      bool = false;
    }
    for (;;)
    {
      com.tencent.mm.ui.tools.p.a(this, this.tEk, findViewById(2131304051), findViewById(2131304051), findViewById(2131304050), this.wPd);
      AppMethodBeat.o(68067);
      return bool;
      if (this.wOj != null)
      {
        ac.i("MicroMsg.RemittanceBusiUI", "tryShowFavor ");
        if ((this.wOj.wJX != null) && (this.wOj.wJX.EeJ.size() > 0)) {}
        for (int i = 1;; i = 0)
        {
          if (this.wOj.wJW.size() > 0) {
            i = 1;
          }
          if (this.wPr.dxT().size() > 0) {
            i = 1;
          }
          if (i == 0)
          {
            this.wOL.setVisibility(8);
            this.wPy.update();
            this.wOQ.setVisibility(8);
            bool = false;
            break;
          }
          this.wOQ.setVisibility(0);
          this.wPx.update();
          this.wOL.setVisibility(0);
          this.wOK.setText(this.wOj.wJS);
          this.wOK.setTextColor(getContext().getResources().getColor(2131100212));
          this.wOR.setText(com.tencent.mm.wallet_core.ui.e.C(dyp()));
          Object localObject = this.wPr.wMh;
          if (localObject != null)
          {
            this.wOK.setTextColor(getContext().getResources().getColor(2131099777));
            this.wOK.setText(((aid)localObject).wJS);
            this.wOR.setText(com.tencent.mm.wallet_core.ui.e.C(((aid)localObject).ECu / 100.0D));
          }
          for (;;)
          {
            findViewById(2131299860).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68020);
                com.tencent.mm.plugin.report.service.h.wUl.f(15235, new Object[] { Integer.valueOf(3) });
                if (RemittanceBusiUI.n(RemittanceBusiUI.this) == 56) {
                  com.tencent.mm.plugin.report.service.h.wUl.f(19821, new Object[] { Integer.valueOf(7), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
                }
                RemittanceBusiUI.J(RemittanceBusiUI.this);
                AppMethodBeat.o(68020);
              }
            });
            bool = true;
            break;
            localObject = this.wPr.dxU();
            if (!bs.isNullOrNil((String)localObject))
            {
              this.wOK.setTextColor(getContext().getResources().getColor(2131100212));
              this.wOK.setText((CharSequence)localObject);
            }
          }
        }
      }
      bool = false;
    }
  }
  
  private void dyr()
  {
    AppMethodBeat.i(163833);
    hideLoading();
    if (this.wPB != null) {
      this.wPB.hideProgress();
    }
    AppMethodBeat.o(163833);
  }
  
  private void dys()
  {
    AppMethodBeat.i(68076);
    ac.i("MicroMsg.RemittanceBusiUI", "unLockFavorimp");
    aid localaid = this.wPr.wMh;
    if (localaid == null)
    {
      ac.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor FavorComposeInfo is null");
      AppMethodBeat.o(68076);
      return;
    }
    int i = (int)Math.round(this.wOV * 100.0D);
    dj localdj = new dj();
    localdj.channel = this.mChannel;
    localdj.DQs = this.wOa;
    localdj.DQt = this.vsE;
    localdj.wJT = this.wOj.wJT;
    localdj.scene = this.mPayScene;
    localdj.DQu = this.wOf;
    localdj.DQv = localaid;
    localdj.iAz = this.wOW;
    localdj.wLu = this.wNc;
    localdj.DQw = i;
    doSceneProgress(new com.tencent.mm.plugin.remittance.model.k(localdj, this.wPs), false);
    AppMethodBeat.o(68076);
  }
  
  private void dyt()
  {
    AppMethodBeat.i(68078);
    ac.i("MicroMsg.RemittanceBusiUI", "goto busi result");
    Object localObject = new Intent(this, RemittanceBusiResultUI.class);
    ((Intent)localObject).putExtra("key_pay_desc", this.wOb);
    ((Intent)localObject).putExtra("key_rcv_desc", this.wOZ);
    if (this.wOj != null) {
      ((Intent)localObject).putExtra("BusiRemittanceResp", this.wOj);
    }
    ((Intent)localObject).putExtra("key_mch_name", this.wMx);
    ((Intent)localObject).putExtra("key_rcver_name", this.wOW);
    ((Intent)localObject).putExtra("key_rcver_true_name", this.wOX);
    if (this.daf >= 0.0D) {
      ((Intent)localObject).putExtra("key_money", this.daf);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_f2f_id", this.wOa);
      ((Intent)localObject).putExtra("key_trans_id", this.vsE);
      ((Intent)localObject).putExtra("key_check_sign", this.wOf);
      ((Intent)localObject).putExtra("key_rcvr_open_id", this.wNc);
      ((Intent)localObject).putExtra("key_channel", this.mChannel);
      ((Intent)localObject).putExtra("key_succ_fault_config", this.wPp);
      if (this.wOj != null)
      {
        ((Intent)localObject).putExtra("key_succ_show_avatar_type", this.wOj.wJZ);
        ((Intent)localObject).putExtra("key_succ_show_avatar_show", this.wOj.wJQ);
        ((Intent)localObject).putExtra("key_succ_show_avatar_url", this.wOj.wJR);
      }
      if (this.wOj != null) {
        ((Intent)localObject).putExtra("key_scan_sceen", this.wOj.wJT);
      }
      ((Intent)localObject).putExtra("key_succ_page_extend", this.wPt);
      if (this.mChannel == 56) {
        ((Intent)localObject).putExtra("app_id", this.app_id);
      }
      aid localaid = this.wPr.wMh;
      int i = (int)Math.round(this.wOV * 100.0D);
      dj localdj = new dj();
      localdj.channel = this.mChannel;
      localdj.DQs = this.wOa;
      localdj.DQt = this.vsE;
      localdj.wJT = this.wOj.wJT;
      localdj.scene = this.mPayScene;
      localdj.DQu = this.wOf;
      localdj.DQv = localaid;
      localdj.iAz = this.wOW;
      localdj.wLu = this.wNc;
      localdj.DQw = i;
      try
      {
        ((Intent)localObject).putExtra("AfterPlaceOrderCommReq", localdj.toByteArray());
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI", "gotoBusiResultUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI", "gotoBusiResultUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        if (e.dyk().dyl()) {
          ac.w("MicroMsg.RemittanceBusiUI", "finish finishRemitF2fDCodeAndLMRemindUI");
        }
        AppMethodBeat.o(68078);
        return;
        ((Intent)localObject).putExtra("key_money", this.wOV);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.RemittanceBusiUI", localException, "", new Object[0]);
        }
      }
    }
  }
  
  private void fe(final List<aie> paramList)
  {
    AppMethodBeat.i(68068);
    final com.tencent.mm.ui.widget.picker.e locale = new com.tencent.mm.ui.widget.picker.e(this);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = this.wPr.wMh;
    Object localObject1 = new HashSet();
    final HashSet localHashSet = new HashSet();
    if ((this.wPr.dxW()) && (localObject2 != null))
    {
      localObject2 = ((aid)localObject2).EeI.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((HashSet)localObject1).add(Long.valueOf(((aie)((Iterator)localObject2).next()).ECB));
      }
    }
    localObject2 = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      if (((HashSet)localObject1).contains(Long.valueOf(((aie)((Iterator)localObject2).next()).ECB))) {
        localArrayList.add(Integer.valueOf(i));
      }
      i += 1;
    }
    localObject1 = getString(2131762485);
    if ((localObject1 != null) && (((CharSequence)localObject1).length() > 0))
    {
      locale.JjC.setVisibility(0);
      locale.zjv.setText((CharSequence)localObject1);
    }
    locale.JjD = localArrayList;
    locale.ISu = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(68024);
        RemittanceBusiUI.a(RemittanceBusiUI.this, RemittanceBusiUI.q(RemittanceBusiUI.this));
        aie localaie;
        if ((!RemittanceBusiUI.K(RemittanceBusiUI.this).dxW()) || (RemittanceBusiUI.r(RemittanceBusiUI.this) <= 0.0D))
        {
          localIterator = paramList.iterator();
          i = 0;
          while (localIterator.hasNext())
          {
            localaie = (aie)localIterator.next();
            paramAnonymousl.a(i, localaie.ECC, localaie.ECE, null, true);
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
          localaie = (aie)localIterator.next();
          if (localaie.ECK == 1)
          {
            paramAnonymousl.a(i, localaie.ECC, localaie.ECE, null, true);
            localHashSet.add(Integer.valueOf(i));
          }
          for (;;)
          {
            i += 1;
            break;
            paramAnonymousl.a(i, localaie.ECC, localaie.ECE, 0);
          }
        }
        AppMethodBeat.o(68024);
      }
    };
    locale.ISv = new n.d()
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
          com.tencent.mm.plugin.report.service.h.wUl.f(15235, new Object[] { Integer.valueOf(4) });
          Object localObject1 = (aie)paramList.get(paramAnonymousInt);
          paramAnonymousMenuItem = locale;
          boolean bool;
          if (paramAnonymousMenuItem.JjE != null)
          {
            paramAnonymousMenuItem = paramAnonymousMenuItem.JjE.fwa();
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
                ((List)localObject2).add((aie)paramList.get(k));
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
            localObject1 = RemittanceBusiUI.K(RemittanceBusiUI.this).wMh;
            paramAnonymousMenuItem = new HashSet();
            if (localObject1 == null) {
              break;
            }
            localObject1 = ((aid)localObject1).EeI.iterator();
            while (((Iterator)localObject1).hasNext()) {
              paramAnonymousMenuItem.add(Long.valueOf(((aie)((Iterator)localObject1).next()).ECB));
            }
          }
          localObject1 = new HashMap();
          Object localObject2 = paramList.iterator();
          i = j;
          if (((Iterator)localObject2).hasNext())
          {
            if (paramAnonymousMenuItem.contains(Long.valueOf(((aie)((Iterator)localObject2).next()).ECB))) {
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
          if (paramAnonymousMenuItem.JjE != null)
          {
            paramAnonymousMenuItem.JjE.JjH = ((HashMap)localObject1);
            paramAnonymousMenuItem.JjE.notifyDataSetChanged();
          }
        }
        AppMethodBeat.o(68026);
      }
    };
    locale.JjF = new e.b()
    {
      public final void pN(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(68027);
        if (paramAnonymousBoolean)
        {
          localObject = RemittanceBusiUI.K(RemittanceBusiUI.this).wMh;
          if (localObject != null) {
            break label56;
          }
        }
        label56:
        for (Object localObject = "";; localObject = com.tencent.mm.plugin.remittance.model.a.a((aid)localObject))
        {
          ac.i("MicroMsg.RemittanceBusiUI", "onFavorSelected %s ", new Object[] { localObject });
          RemittanceBusiUI.L(RemittanceBusiUI.this);
          AppMethodBeat.o(68027);
          return;
        }
      }
    };
    if (locale.ISu != null) {
      locale.ISu.onCreateMMMenu(locale.CGH);
    }
    locale.JjE = new e.a(locale, locale.mContext);
    locale.JjE.fvZ();
    locale.JjB.setAdapter(locale.JjE);
    locale.gAJ.setOnClickListener(new e.2(locale));
    locale.gCY.setOnClickListener(new e.3(locale));
    if (locale.tyZ != null)
    {
      if ((locale.CGH != null) && (locale.CGH.size() > 3))
      {
        paramList = (FrameLayout.LayoutParams)locale.khe.getLayoutParams();
        paramList.height = locale.lcC;
        locale.khe.setLayoutParams(paramList);
      }
      locale.tyZ.show();
    }
    AppMethodBeat.o(68068);
  }
  
  private void ln(boolean paramBoolean)
  {
    AppMethodBeat.i(68088);
    if (this.wJe != null) {
      this.wJe.yw(paramBoolean);
    }
    AppMethodBeat.o(68088);
  }
  
  private void v(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(68075);
    ac.i("MicroMsg.RemittanceBusiUI", "doBusiZeroCallback %s", new Object[] { Boolean.valueOf(paramBoolean) });
    dj localdj = (dj)this.wPA.get(paramString);
    if (localdj == null)
    {
      AppMethodBeat.o(68075);
      return;
    }
    dhy localdhy = this.wPj;
    String str = this.wPi;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString = new com.tencent.mm.plugin.remittance.model.l(localdhy, localdj, str, i, this.wPk, paramString);
      if (!paramBoolean) {
        break;
      }
      paramString.hasRetried = true;
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(paramString, 0);
      AppMethodBeat.o(68075);
      return;
    }
    this.wPo = 0;
    doSceneForceProgress(paramString);
    AppMethodBeat.o(68075);
  }
  
  public final void a(int paramInt, i parami)
  {
    AppMethodBeat.i(163835);
    x localx = new x();
    localx.dFD = paramInt;
    if (parami != null)
    {
      localx.fV(parami.wKm.DQs);
      localx.fW(this.wOU);
      localx.dHG = parami.vGO;
    }
    localx.aHZ();
    AppMethodBeat.o(163835);
  }
  
  public final void bs(float paramFloat)
  {
    AppMethodBeat.i(68065);
    if (this.tEk != null)
    {
      this.wPd = paramFloat;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.tEk.getLayoutParams();
      localLayoutParams.bottomMargin = ((int)paramFloat);
      ac.d("MicroMsg.RemittanceBusiUI", "onUpdateWcPayKeyboardHeight() height: %s rootView.height: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(localLayoutParams.height) });
      this.tEk.setLayoutParams(localLayoutParams);
      com.tencent.mm.ui.tools.p.a(this, this.tEk, findViewById(2131304051), findViewById(2131304051), findViewById(2131304050), paramFloat);
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
    this.tEk = ((ScrollView)findViewById(2131304251));
    this.wOE = ((TextView)findViewById(2131304008));
    this.wOF = ((TextView)findViewById(2131304009));
    this.wOG = ((TextView)findViewById(2131304005));
    this.wOH = ((TextView)findViewById(2131304002));
    this.wOI = ((TextView)findViewById(2131303996));
    this.wOJ = ((TextView)findViewById(2131303994));
    this.wOM = ((CdnImageView)findViewById(2131304006));
    this.wJl = ((WalletFormView)findViewById(2131304007));
    this.wON = ((LinearLayout)findViewById(2131304003));
    this.wMN = ((LinearLayout)findViewById(2131303998));
    this.wOT = ((RelativeLayout)findViewById(2131306754));
    this.wOO = ((LinearLayout)findViewById(2131303997));
    this.wOK = ((TextView)findViewById(2131299864));
    this.wOL = findViewById(2131303999);
    this.wOP = ((TextView)findViewById(2131304001));
    this.wOQ = findViewById(2131299968);
    this.wOR = ((TextView)findViewById(2131299967));
    this.wOS = ((Button)findViewById(2131304004));
    this.wJe = ((WcPayKeyboard)findViewById(2131307020));
    ImageView localImageView;
    label536:
    label680:
    boolean bool1;
    if (this.wPe)
    {
      if (!bs.isNullOrNil(this.wOZ)) {
        this.wOG.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, this.wOZ, this.wOG.getTextSize()));
      }
      this.wOH.setText(com.tencent.mm.wallet_core.ui.e.C(this.wOV));
      this.wON.setVisibility(0);
      this.wMN.setVisibility(8);
      this.wOT.setVisibility(8);
      this.wOS.setVisibility(0);
      if (com.tencent.mm.kernel.g.agM())
      {
        com.tencent.mm.kernel.g.agS();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.wOW);
        if ((localObject == null) || ((int)((com.tencent.mm.n.b)localObject).fLJ == 0)) {
          ar.a.hnw.a(this.wOW, "", new RemittanceBusiUI.37(this));
        }
      }
      dyf();
      this.wOO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68048);
          if (!RemittanceBusiUI.m(RemittanceBusiUI.this)) {
            RemittanceBusiUI.this.showCircleStWcKb();
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(15235, new Object[] { Integer.valueOf(6) });
          if (RemittanceBusiUI.n(RemittanceBusiUI.this) == 56) {
            com.tencent.mm.plugin.report.service.h.wUl.f(19821, new Object[] { Integer.valueOf(6), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
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
              ap.n(new Runnable()
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
          AppMethodBeat.o(68048);
        }
      });
      Object localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68051);
          com.tencent.mm.plugin.report.service.h.wUl.f(15235, new Object[] { Integer.valueOf(5) });
          if (RemittanceBusiUI.n(RemittanceBusiUI.this) == 56) {
            com.tencent.mm.plugin.report.service.h.wUl.f(19821, new Object[] { Integer.valueOf(8), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
          }
          if (!RemittanceBusiUI.m(RemittanceBusiUI.this)) {
            RemittanceBusiUI.a(RemittanceBusiUI.this, RemittanceBusiUI.q(RemittanceBusiUI.this));
          }
          if (RemittanceBusiUI.r(RemittanceBusiUI.this) <= 0.0D)
          {
            t.makeText(RemittanceBusiUI.this.getContext(), 2131765031, 0).show();
            AppMethodBeat.o(68051);
            return;
          }
          com.tencent.mm.plugin.remittance.model.g localg = RemittanceBusiUI.this.wPw;
          if (RemittanceBusiUI.this.wPw == null) {}
          for (paramAnonymousView = "";; paramAnonymousView = RemittanceBusiUI.this.wPw.wKj)
          {
            ac.i("MicroMsg.RemittanceBusiUI", "mPayBtn onClick %s  isFinish:%s getFavorFlag: %s", new Object[] { localg, paramAnonymousView, Boolean.valueOf(RemittanceBusiUI.this.wPu) });
            if (RemittanceBusiUI.j(RemittanceBusiUI.this) != 32) {
              break label363;
            }
            if (!RemittanceBusiUI.this.wPu) {
              break label350;
            }
            if ((RemittanceBusiUI.this.wPw == null) || (RemittanceBusiUI.this.wPw.wIJ != (int)(RemittanceBusiUI.r(RemittanceBusiUI.this) * 100.0D))) {
              break;
            }
            if ((RemittanceBusiUI.this.wPw != null) && (RemittanceBusiUI.this.wPw.wKj)) {
              break label363;
            }
            if (RemittanceBusiUI.this.wPw == null) {
              break label370;
            }
            RemittanceBusiUI.this.wPw.wKh = new com.tencent.mm.plugin.remittance.model.c()
            {
              public final void fd(List<aie> paramAnonymous2List)
              {
                AppMethodBeat.i(68049);
                RemittanceBusiUI.s(RemittanceBusiUI.this);
                AppMethodBeat.o(68049);
              }
            };
            AppMethodBeat.o(68051);
            return;
          }
          RemittanceBusiUI.a(RemittanceBusiUI.this, new com.tencent.mm.plugin.remittance.model.c()
          {
            public final void fd(List<aie> paramAnonymous2List)
            {
              AppMethodBeat.i(68050);
              RemittanceBusiUI.s(RemittanceBusiUI.this);
              AppMethodBeat.o(68050);
            }
          }, 0);
          AppMethodBeat.o(68051);
          return;
          label350:
          RemittanceBusiUI.s(RemittanceBusiUI.this);
          AppMethodBeat.o(68051);
          return;
          label363:
          RemittanceBusiUI.s(RemittanceBusiUI.this);
          label370:
          AppMethodBeat.o(68051);
        }
      };
      this.wJl.getContentEt().setOnEditorActionListener(new RemittanceBusiUI.40(this, (View.OnClickListener)localObject));
      localImageView = (ImageView)findViewById(2131306750);
      if (aj.DT())
      {
        findViewById(2131306755).setVisibility(8);
        findViewById(2131306752).setVisibility(0);
        localImageView.setBackgroundResource(2131234672);
        this.wOS.setOnClickListener((View.OnClickListener)localObject);
        this.tEk.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(68015);
            if ((RemittanceBusiUI.t(RemittanceBusiUI.this) != null) && (RemittanceBusiUI.u(RemittanceBusiUI.this).isShown()) && (RemittanceBusiUI.v(RemittanceBusiUI.this).fzM()))
            {
              RemittanceBusiUI.w(RemittanceBusiUI.this).fzK();
              AppMethodBeat.o(68015);
              return true;
            }
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
        this.wJo = ((RelativeLayout)findViewById(2131306751));
        if ((!ab.eUO().equals("zh_CN")) && (!ab.eUO().equals("zh_TW")) && (!ab.eUO().equals("zh_HK"))) {
          break label993;
        }
        this.wJm = ((RelativeLayout)findViewById(2131306753));
        this.wJn = ((TextView)findViewById(2131306756));
        this.wJm.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68017);
            RemittanceBusiUI.a(RemittanceBusiUI.this, RemittanceBusiUI.y(RemittanceBusiUI.this).getWidth());
            RemittanceBusiUI.z(RemittanceBusiUI.this).setVisibility(8);
            ac.d("MicroMsg.RemittanceBusiUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(RemittanceBusiUI.A(RemittanceBusiUI.this)) });
            AppMethodBeat.o(68017);
          }
        });
        this.wJl.setmWalletFormViewListener(new WalletFormView.c()
        {
          public final void p(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(68018);
            if (bs.jl(RemittanceBusiUI.B(RemittanceBusiUI.this), 0))
            {
              ac.i("MicroMsg.RemittanceBusiUI", "mAmountRemindBit == 0");
              RemittanceBusiUI.z(RemittanceBusiUI.this).setVisibility(8);
              AppMethodBeat.o(68018);
              return;
            }
            long l = Double.valueOf(bs.getDouble(paramAnonymousCharSequence.toString(), 0.0D)).longValue();
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
              j = RemittanceBusiUI.c(RemittanceBusiUI.this).n(paramAnonymousCharSequence, RemittanceBusiUI.A(RemittanceBusiUI.this), j);
              if (j != 0)
              {
                RemittanceBusiUI.z(RemittanceBusiUI.this).setVisibility(0);
                paramAnonymousCharSequence = ag.aN(com.tencent.mm.sdk.platformtools.ai.getContext(), i);
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
        if ((this.wOj != null) && (this.wOj.wJX != null))
        {
          this.wPr.wMi = this.wOj.wJX;
          this.wPr.art(this.wOj.wJX.EeK);
        }
        if (dyq()) {
          com.tencent.mm.plugin.report.service.h.wUl.f(15235, new Object[] { Integer.valueOf(2) });
        }
        AppMethodBeat.o(68063);
      }
    }
    else
    {
      if (this.wOj == null) {
        break label1010;
      }
      if (this.wOj.wJW.size() <= 0) {
        break label1005;
      }
      bool1 = false;
      label786:
      bool2 = bool1;
      if (this.wOj.wJX != null)
      {
        bool2 = bool1;
        if (this.wOj.wJX.EeI.size() <= 0) {}
      }
    }
    label993:
    label1005:
    label1010:
    for (boolean bool2 = false;; bool2 = true)
    {
      this.wOS.setVisibility(8);
      setWPKeyboard(this.wJl.getContentEt(), bool2, true);
      this.wJl.setmContentAbnormalMoneyCheck(true);
      if (com.tencent.mm.compatible.util.d.kZ(28)) {
        this.wJl.getContentEt().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68042);
            RemittanceBusiUI.c(RemittanceBusiUI.this).getContentEt().requestFocus();
            AppMethodBeat.o(68042);
          }
        });
      }
      this.wJe.setActionText(getString(2131762434));
      setWcKbHeightListener(this);
      ((RelativeLayout.LayoutParams)this.wJe.getLayoutParams()).addRule(12);
      this.wJl.a(new TextWatcher()
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
          for (int i = 400;; i = RemittanceBusiUI.k(RemittanceBusiUI.this).wKc)
          {
            RemittanceBusiUI.a(paramAnonymousEditable, null, i);
            AppMethodBeat.o(68043);
            return;
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.wJl.fAX();
      this.wON.setVisibility(8);
      this.wMN.setVisibility(0);
      this.wOT.setVisibility(0);
      break;
      findViewById(2131306755).setVisibility(0);
      findViewById(2131306752).setVisibility(8);
      localImageView.setBackgroundResource(2131234671);
      break label536;
      this.wJo.setVisibility(8);
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
      if ((!this.wPz) && (!this.wPe) && (this.wJe.fzO()))
      {
        AppMethodBeat.o(68062);
        return true;
      }
      AppMethodBeat.o(68062);
      return false;
    }
    if ((!this.wPe) && (this.wJe.fzO()))
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
    ac.i("MicroMsg.RemittanceBusiUI", "onActivityResult requestCode %s resultCode %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    if (paramInt1 == 3)
    {
      if (this.wPB != null)
      {
        this.wPB.hideProgress();
        this.wPB = null;
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
          this.wPk = str;
          this.daf = 0.0D;
          ac.i("MicroMsg.RemittanceBusiUI", "onActivityResult _result_token: %s", new Object[] { str });
          v(false, paramIntent.getStringExtra("INTENT_REQKEY"));
        }
        else
        {
          dys();
        }
      }
      else if (paramInt1 == 4) {
        this.wPE = true;
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
      com.tencent.mm.plugin.report.service.h.wUl.f(19821, new Object[] { Integer.valueOf(4), this.app_id, Integer.valueOf(0) });
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(15235, new Object[] { Integer.valueOf(1) });
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
    if ((com.tencent.mm.compatible.util.d.kZ(21)) && (!com.tencent.mm.compatible.util.d.kZ(23))) {
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
    regeistQueryOrder(2682, this.wPJ);
    setMMTitle(2131762434);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(68014);
        RemittanceBusiUI.e(RemittanceBusiUI.this);
        if (RemittanceBusiUI.this.getIntent().getIntExtra("pay_channel", 0) == 56)
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(19821, new Object[] { Integer.valueOf(5), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
          RemittanceBusiUI.dyu();
        }
        RemittanceBusiUI.this.finish();
        AppMethodBeat.o(68014);
        return false;
      }
    });
    this.dnh = UUID.randomUUID().toString();
    com.tencent.mm.plugin.wallet.pay.a.b.ayV(this.dnh);
    this.mPayScene = getIntent().getIntExtra("pay_scene", 31);
    this.wOU = getIntent().getStringExtra("scan_remittance_id");
    this.wOV = getIntent().getDoubleExtra("fee", 0.0D);
    this.wOW = getIntent().getStringExtra("receiver_name");
    this.wOX = getIntent().getStringExtra("receiver_true_name");
    this.wOY = getIntent().getStringExtra("receiver_true_name_busi");
    this.mChannel = getIntent().getIntExtra("pay_channel", 0);
    this.wOZ = getIntent().getStringExtra("desc");
    this.wPb = getIntent().getIntExtra("busi_type", 0);
    this.wMx = getIntent().getStringExtra("mch_name");
    this.wPf = getIntent().getStringExtra("mch_type");
    this.wPh = getIntent().getIntExtra("mch_time", 0);
    this.wPc = getIntent().getStringExtra("mch_info");
    this.wPg = getIntent().getIntExtra("get_pay_wifi", 0);
    this.wNc = getIntent().getStringExtra("rcvr_open_id");
    this.wPa = getIntent().getStringExtra("rcvr_ticket");
    this.wIV = getIntent().getIntExtra("amount_remind_bit", 4);
    this.wPq = getIntent().getStringExtra("receiver_tips");
    this.wOj = ((BusiRemittanceResp)getIntent().getParcelableExtra("BusiRemittanceResp"));
    boolean bool;
    if (this.wOj != null) {
      if ((this.mPayScene == 32) && ((this.wOj.wJY == 1) || ((this.wOj != null) && (this.wOj.wJW.size() > 0))))
      {
        bool = true;
        this.wPu = bool;
        if (this.wOV <= 0.0D) {
          break label851;
        }
      }
    }
    label851:
    for (this.wPe = true;; this.wPe = false)
    {
      if (this.wPb == 0)
      {
        ac.w("MicroMsg.RemittanceBusiUI", "wrong busi type!");
        finish();
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(15386, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
      this.wPx = new b(32, 32, 6.0F);
      this.wPy = new b(56, 56, 8.0F);
      initView();
      dqE();
      this.wMd.alive();
      this.wPS.alive();
      if (!this.wPe) {
        this.state = 1;
      }
      AppMethodBeat.o(68058);
      return;
      bool = false;
      break;
      ac.w("MicroMsg.RemittanceBusiUI", "busi resp is null, maybe recreate activity!!");
      finish();
      AppMethodBeat.o(68058);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68070);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.GpY.d(this.wNr);
    com.tencent.mm.sdk.b.a.GpY.d(this.wPR);
    com.tencent.mm.sdk.b.a.GpY.d(this.wPP);
    this.wPQ.dead();
    removeSceneEndListener(1633);
    removeSceneEndListener(1241);
    removeSceneEndListener(2677);
    removeSceneEndListener(2504);
    removeSceneEndListener(2702);
    removeSceneEndListener(2682);
    this.wMd.dead();
    this.wPS.dead();
    com.tencent.mm.plugin.wallet.pay.a.b.ayW(this.dnh);
    ap.aB(this.wJB);
    AppMethodBeat.o(68070);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(68061);
    ac.i("MicroMsg.RemittanceBusiUI", "onDialogDismiss()");
    ap.n(this.wJB, 300L);
    AppMethodBeat.o(68061);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68064);
    if ((this.wJe != null) && (this.wJe.onKeyUp(paramInt, paramKeyEvent)))
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
    ac.v("MicroMsg.RemittanceBusiUI", "onNewIntent");
    AppMethodBeat.o(68082);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68060);
    super.onPause();
    ac.i("MicroMsg.RemittanceBusiUI", "onPause()");
    if ((!this.wPe) && (!this.wJe.fzN())) {
      this.state = 3;
    }
    AppMethodBeat.o(68060);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68059);
    super.onResume();
    ac.i("MicroMsg.RemittanceBusiUI", "onResume()");
    e.dyk().fX(this);
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      showNormalStWcKb();
    }
    if (!this.wPe) {
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
        localObject1 = e.dyk();
        ac.w("MicroMsg.RemittanceBusiDialogMgr", "hideProgress()");
        localObject1 = (Context)((e)localObject1).cnv.get();
        if (localObject1 == null) {
          ac.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
        }
      }
      else
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label1626;
        }
        if (paramString.wKm.nWx != 0) {
          break label1431;
        }
        this.wPH = paramString;
        this.wOa = paramString.wKm.DQs;
        this.vsE = paramString.wKm.DQt;
        this.wOf = paramString.wKm.DQu;
        this.wPs = paramString.wKm.Efh;
        this.wPt = paramString.wKm.Efg;
        this.wPi = paramString.wKm.Efm;
        this.wPj = paramString.wKm.Efl;
        this.wPl = paramString.wKm.Efp;
        this.wPm = paramString.wKm.Efn;
        this.wPn = paramString.wKm.Efo;
        this.wPp = i.a(paramString.wKm.Efu).toString();
        ac.i("MicroMsg.RemittanceBusiUI", "touch_challenge: %s need_change_auth_key: %s mBusiF2FFaultConfig: %s", new Object[] { paramString.wKm.Efq, Integer.valueOf(paramString.wKm.Efr), this.wPp });
        if (paramString.wKm.Efq != null) {
          com.tencent.mm.plugin.fingerprint.b.p.skJ.skD = paramString.wKm.Efq.eQU();
        }
        paramn = com.tencent.mm.plugin.fingerprint.b.p.skJ;
        if (paramString.wKm.Efr != 1) {
          break label594;
        }
        bool = true;
        paramn.skL = bool;
        if (a(paramString)) {
          break label1424;
        }
        ac.i("MicroMsg.RemittanceBusiUI", "showNameVerifyDialog");
        if (paramString.wKm.Efx != null) {
          break label600;
        }
        ac.e("MicroMsg.RemittanceBusiUI", "orderScene.response.check_recv_name_win is null");
        paramInt1 = 0;
        if (paramInt1 == 0)
        {
          if (paramString.wKm.Efv == null) {
            break label1266;
          }
          ac.i("MicroMsg.RemittanceBusiUI", "showMoneyRemind amount_remind_win");
          dyr();
          if ((e.dyk().getContext() != null) && ((e.dyk().getContext() instanceof RemittanceBusiUI))) {
            this.wPD = paramString.wKm.Efv.DQD;
          }
          paramn = e.dyk();
          localObject2 = paramString.wKm.Efv;
          paramInt1 = this.wIV;
          localObject3 = new a(paramString) {};
          localObject4 = new a(paramString) {};
          ac.w("MicroMsg.RemittanceBusiDialogMgr", "showAmountRemindWin() amountRemindBit:%s", new Object[] { Integer.valueOf(paramInt1) });
          paramn = (Context)paramn.cnv.get();
          if (paramn != null) {
            break label925;
          }
          ac.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
          label521:
          if (e.dyk().getContext() != null)
          {
            if (!(e.dyk().getContext() instanceof RemittanceBusiUI)) {
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
      dyr();
      localObject4 = paramString.wKm.Efx.title;
      Object localObject6 = paramString.wKm.Efx.dlQ;
      Object localObject7 = paramString.wKm.Efx.Eqd;
      localObject2 = paramString.wKm.Efx.BND.dlQ;
      localObject3 = paramString.wKm.Efx.BNE.dlQ;
      paramn = new c(this);
      paramn.wMl = new c.a()
      {
        public final void arm(final String paramAnonymousString)
        {
          AppMethodBeat.i(174427);
          ac.i("MicroMsg.RemittanceBusiUI", "showNameVerifyDialog onINputName() name:%s", new Object[] { paramAnonymousString });
          RemittanceBusiUI.this.hideVKB();
          com.tencent.mm.plugin.report.service.h.wUl.f(19229, new Object[] { Integer.valueOf(0), Integer.valueOf(paramString.wKm.Efx.Eqe), Integer.valueOf(0), RemittanceBusiUI.Y(RemittanceBusiUI.this) });
          com.tencent.mm.wallet_core.c.l.a(RemittanceBusiUI.this, paramString.wKm.Efx.BNE, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dC(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(174422);
              ac.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog right button click jumpItem.action:continue");
              RemittanceBusiUI.a(RemittanceBusiUI.this, paramAnonymousString, RemittanceBusiUI.35.this.wPX.wKm.Efx.Efd);
              AppMethodBeat.o(174422);
            }
            
            public final void dxG()
            {
              AppMethodBeat.i(174423);
              ac.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog right button click jumpItem.action:close");
              AppMethodBeat.o(174423);
            }
            
            public final void dxN()
            {
              AppMethodBeat.i(174421);
              ac.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog right button click jumpItem.action:exit");
              RemittanceBusiUI.Z(RemittanceBusiUI.this);
              AppMethodBeat.o(174421);
            }
          });
          AppMethodBeat.o(174427);
        }
        
        public final void onCancel()
        {
          AppMethodBeat.i(174428);
          ac.i("MicroMsg.RemittanceBusiUI", "showNameVerifyDialog onCancel()");
          RemittanceBusiUI.this.hideVKB();
          com.tencent.mm.plugin.report.service.h.wUl.f(19229, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.wKm.Efx.Eqe), Integer.valueOf(0), RemittanceBusiUI.Y(RemittanceBusiUI.this) });
          com.tencent.mm.wallet_core.c.l.a(RemittanceBusiUI.this, paramString.wKm.Efx.BND, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dC(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(174425);
              ac.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog left button click jumpItem.action：continue");
              AppMethodBeat.o(174425);
            }
            
            public final void dxG()
            {
              AppMethodBeat.i(174426);
              ac.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog left button click jumpItem.action：close");
              AppMethodBeat.o(174426);
            }
            
            public final void dxN()
            {
              AppMethodBeat.i(174424);
              ac.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog left button click jumpItem.action:exit");
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
      ((d.a)localObject6).aRH((String)localObject4).gH((View)localObject5);
      localObject4 = com.tencent.mm.ui.tools.b.c.d((EditText)localObject1);
      ((com.tencent.mm.ui.tools.b.c)localObject4).mEd = f.a.IRI;
      localObject4 = ((com.tencent.mm.ui.tools.b.c)localObject4).jQ(1, 1);
      ((com.tencent.mm.ui.tools.b.c)localObject4).IVj = false;
      ((com.tencent.mm.ui.tools.b.c)localObject4).a(null);
      ap.n(new c.10(paramn, (EditText)localObject1), 200L);
      ((d.a)localObject6).aRO((String)localObject3).acO(-2141754475).a(false, new c.11(paramn, (EditText)localObject1));
      ((d.a)localObject6).aRP((String)localObject2).c(new c.2(paramn));
      localObject2 = ((d.a)localObject6).fvp();
      ((com.tencent.mm.ui.widget.a.d)localObject2).show();
      ((EditText)localObject1).addTextChangedListener(new c.3(paramn, (EditText)localObject1, (com.tencent.mm.ui.widget.a.d)localObject2));
      paramInt1 = 1;
      break label371;
      label925:
      if (localObject2 == null)
      {
        ac.i("MicroMsg.JumpItemUtil", "showAmountRemindWin() amountRemindWin == null");
        break label521;
      }
      localObject1 = LayoutInflater.from(paramn).inflate(2131494544, null, false);
      localObject5 = ((View)localObject1).findViewById(2131299648);
      localObject6 = (WalletTextView)((View)localObject1).findViewById(2131299647);
      localObject7 = ((View)localObject1).findViewById(2131306753);
      localObject8 = ((View)localObject1).findViewById(2131306751);
      double d = ((dp)localObject2).DQD / 100.0D;
      ((WalletTextView)localObject6).setText(com.tencent.mm.wallet_core.ui.e.C(d));
      if (bs.jl(paramInt1, 0))
      {
        ac.i("MicroMsg.JumpItemUtil", "mAmountRemindBit == 0");
        ((View)localObject8).setVisibility(8);
      }
      for (;;)
      {
        localObject5 = ((dp)localObject2).dlQ;
        localObject6 = ((dp)localObject2).BNE.dlQ;
        localObject7 = ((dp)localObject2).BND.dlQ;
        localObject4 = new l.8(paramn, (dp)localObject2, d, (l.a)localObject4);
        localObject2 = new l.9(paramn, (dp)localObject2, d, (l.a)localObject3);
        localObject3 = new d.a(paramn);
        ((d.a)localObject3).aRH((String)localObject5);
        ((d.a)localObject3).gH((View)localObject1);
        ((d.a)localObject3).aRO((String)localObject6).b((DialogInterface.OnClickListener)localObject4);
        ((d.a)localObject3).aRP((String)localObject7).c((DialogInterface.OnClickListener)localObject2);
        ((d.a)localObject3).yf(false);
        ((d.a)localObject3).yg(true);
        localObject1 = ((d.a)localObject3).fvp();
        ((com.tencent.mm.ui.widget.a.d)localObject1).show();
        com.tencent.mm.ui.base.h.a(paramn, (Dialog)localObject1);
        break;
        TextView localTextView = (TextView)((View)localObject1).findViewById(2131306756);
        ((View)localObject8).setVisibility(0);
        ((View)localObject8).post(new l.7((View)localObject7, d, paramInt1, (WalletTextView)localObject6, (View)localObject5, (View)localObject8, localTextView));
      }
      label1244:
      if (!(e.dyk().getContext() instanceof RemittanceF2fLargeMoneyUI)) {
        break label548;
      }
      a(9, paramString);
      break label548;
      label1266:
      if (paramString.wKm.Efw != null)
      {
        ac.i("MicroMsg.RemittanceBusiUI", "showMoneyRemind amount_remind_page");
        dyr();
        paramn = new Intent();
        paramn.putExtra("key_amount_remind_bit", this.wIV);
        paramn.putExtra("key_title", paramString.wKm.Efw.title);
        paramn.putExtra("key_desc", paramString.wKm.Efw.dlQ);
        paramn.putExtra("key_amount_remind_sign", paramString.wKm.Efw.DQC);
        com.tencent.mm.br.d.b(this, "wallet_payu", ".pay.ui.WalletPayUOrderInfoUI", paramn, 4);
        a(6, paramString);
        break label548;
      }
      if ((e.dyk().getContext() != null) && ((e.dyk().getContext() instanceof RemittanceF2fLargeMoneyUI))) {
        a(8, paramString);
      }
      paramInt1 = 0;
      break label550;
      label1424:
      dyr();
      continue;
      label1431:
      dyr();
      ac.e("MicroMsg.RemittanceBusiUI", "place order response: %s, %s", new Object[] { Integer.valueOf(paramString.wKm.nWx), paramString.wKm.nWy });
      if ((paramString.wKm.Eff != null) && (!bs.isNullOrNil(paramString.wKm.Eff.unW))) {
        a(paramString);
      }
      for (;;)
      {
        if (paramString.wKm.Efi != 1) {
          break label1624;
        }
        a(null, null, 0);
        break;
        localObject2 = e.dyk();
        localObject1 = paramString.wKm.nWy;
        paramn = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68029);
            if (bs.jl(((i)paramn).wKm.Eft, 1))
            {
              if (e.dyk().dyl()) {
                ac.w("MicroMsg.RemittanceBusiUI", "finish finishRemitF2fDCodeAndLMRemindUI");
              }
              RemittanceBusiUI.this.finish();
            }
            AppMethodBeat.o(68029);
          }
        };
        ac.w("MicroMsg.RemittanceBusiDialogMgr", "showAlert3() msg:%s, title:%s", new Object[] { bs.nullAsNil((String)localObject1), bs.nullAsNil("") });
        localObject2 = (Context)((e)localObject2).cnv.get();
        if (localObject2 == null) {
          ac.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
        } else {
          com.tencent.mm.ui.base.h.d((Context)localObject2, (String)localObject1, "", paramn);
        }
      }
      label1624:
      continue;
      label1626:
      ac.e("MicroMsg.RemittanceBusiUI", "net error: %s", new Object[] { paramn });
      continue;
      if ((paramn instanceof com.tencent.mm.plugin.remittance.model.h))
      {
        ac.i("MicroMsg.RemittanceBusiUI", "pay check callback");
        AppMethodBeat.o(68071);
        return true;
      }
      if ((paramn instanceof com.tencent.mm.plugin.remittance.model.g))
      {
        ac.i("MicroMsg.RemittanceBusiUI", "onSceneEnd %s errType %s errCode %s", new Object[] { paramn, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        paramString = (com.tencent.mm.plugin.remittance.model.g)paramn;
        if ((!paramString.wKk.equals(this.wPw.wKk)) || (paramString.cancel))
        {
          paramString.wKj = true;
          ac.e("MicroMsg.RemittanceBusiUI", "ignore this getFavor new coming soon %s", new Object[] { Boolean.valueOf(paramString.cancel) });
          AppMethodBeat.o(68071);
          return true;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramString.wKg.nWx == 0)
          {
            this.wPr.wMi = paramString.wKg.wJX;
            this.wPr.art(paramString.wKg.wJX.EeK);
            dyq();
            paramn = paramString.wKh;
            ac.i("MicroMsg.RemittanceBusiUI", "GetFavorAfterAction %s", new Object[] { paramn });
            if (paramn != null) {
              paramn.fd(this.wPr.dxT());
            }
          }
        }
        for (;;)
        {
          paramString.wKj = true;
          AppMethodBeat.o(68071);
          return true;
          this.wPr.dxS();
          this.wOK.setTextColor(getContext().getResources().getColor(2131100212));
          this.wOK.setText(paramString.wKg.nWy);
          paramn = paramString.wKi;
          if (paramn != null)
          {
            paramn.a(paramInt1, paramInt2, paramString);
            continue;
            this.wPr.dxS();
            if ((this.wOj != null) && (!bs.isNullOrNil(this.wOj.wJS))) {
              this.wOK.setText(this.wOj.wJS);
            }
            this.wOK.setTextColor(getContext().getResources().getColor(2131100212));
            this.wOK.setText(getString(2131762427));
            paramn = paramString.wKi;
            if (paramn != null) {
              paramn.a(paramInt1, paramInt2, paramString);
            }
          }
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.remittance.model.l))
      {
        paramString = (com.tencent.mm.plugin.remittance.model.l)paramn;
        ac.i("MicroMsg.RemittanceBusiUI", "NetSceneBusiF2fZeroCallback getHasRetried %s", new Object[] { Boolean.valueOf(paramString.hasRetried) });
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (paramString.wKr.nWx == 0)
          {
            dyt();
          }
          else
          {
            dys();
            e.dyk().a(paramString.wKr.nWy, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
          }
        }
        else {
          e.dyk().a(getString(2131765901), new DialogInterface.OnClickListener()
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
    
    public void dxG() {}
    
    public final int dxH()
    {
      return 1072;
    }
    
    public void dxJ() {}
    
    public final void dxN()
    {
      Object localObject = new Intent();
      ((Intent)localObject).setComponent(new ComponentName(com.tencent.mm.sdk.platformtools.ai.getPackageName(), "com.tencent.mm.ui.LauncherUI"));
      ((Intent)localObject).addFlags(67108864);
      RemittanceBusiUI localRemittanceBusiUI = RemittanceBusiUI.this;
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localRemittanceBusiUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$IRemitBusiJumpItemCallback", "onExit", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localRemittanceBusiUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(localRemittanceBusiUI, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$IRemitBusiJumpItemCallback", "onExit", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  final class b
  {
    private float marginTop;
    private View qe;
    private float wQd;
    private float wQe;
    private TenpaySecureEditText wQf;
    private TextView wQg;
    private RelativeLayout wQh;
    
    b(int paramInt1, int paramInt2, float paramFloat)
    {
      AppMethodBeat.i(68053);
      this.wQd = paramInt1;
      this.wQe = paramInt2;
      this.marginTop = paramFloat;
      AppMethodBeat.o(68053);
    }
    
    final void update()
    {
      AppMethodBeat.i(68054);
      RemittanceBusiUI.a(RemittanceBusiUI.this).setTextSize(1, this.wQe);
      RemittanceBusiUI.b(RemittanceBusiUI.this).setTextSize(1, this.wQd);
      if (this.wQg == null) {
        this.wQg = ((TextView)RemittanceBusiUI.c(RemittanceBusiUI.this).findViewById(2131306836));
      }
      if (this.wQg != null) {
        this.wQg.setTextSize(this.wQd);
      }
      if (this.wQf == null) {
        this.wQf = ((TenpaySecureEditText)RemittanceBusiUI.c(RemittanceBusiUI.this).findViewById(2131306718));
      }
      if (this.wQf != null) {
        this.wQf.setTextSize(this.wQe);
      }
      if (this.qe == null) {
        this.qe = this.wQf.findViewById(2131302445);
      }
      if (this.qe != null) {
        this.qe.setMinimumHeight(BackwardSupportUtil.b.g(RemittanceBusiUI.this, RemittanceBusiUI.d(RemittanceBusiUI.this).wQe));
      }
      if (this.wQh == null) {
        this.wQh = ((RelativeLayout)RemittanceBusiUI.this.findViewById(2131306754));
      }
      if (this.wQh != null) {
        ((LinearLayout.LayoutParams)this.wQh.getLayoutParams()).topMargin = BackwardSupportUtil.b.g(RemittanceBusiUI.this, this.marginTop);
      }
      AppMethodBeat.o(68054);
    }
  }
  
  final class c
    implements Runnable
  {
    public com.tencent.mm.wallet_core.d.d wQi;
    
    c() {}
    
    public final void run()
    {
      AppMethodBeat.i(68055);
      RemittanceBusiUI.Q(RemittanceBusiUI.this).b(this.wQi);
      AppMethodBeat.o(68055);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI
 * JD-Core Version:    0.7.0.1
 */