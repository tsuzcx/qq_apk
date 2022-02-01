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
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.aah;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.g.a.gl.a;
import com.tencent.mm.g.a.gm;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.b.a.au;
import com.tencent.mm.g.b.a.kx;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.i;
import com.tencent.mm.plugin.remittance.model.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.protocal.protobuf.ans;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.dyf;
import com.tencent.mm.protocal.protobuf.dz;
import com.tencent.mm.protocal.protobuf.ea;
import com.tencent.mm.protocal.protobuf.eig;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.protocal.protobuf.re;
import com.tencent.mm.protocal.protobuf.ri;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
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
  private String AJn;
  private int Cnv;
  private String CqN;
  private IListener<com.tencent.mm.g.a.as> Cqt;
  private boolean CrC;
  private boolean CrF;
  private IListener CrH;
  private LinearLayout Crd;
  private String Crs;
  private boolean Crx;
  private kx Crz;
  private TextView CsU;
  private TextView CsV;
  private TextView CsW;
  private TextView CsX;
  private TextView CsY;
  private TextView CsZ;
  private String Csq;
  private String Csr;
  private String Csv;
  private BusiRemittanceResp Csz;
  private String CtA;
  private int CtB;
  private int CtC;
  private int CtD;
  private int CtE;
  private String CtF;
  private String CtG;
  private b CtH;
  private String CtI;
  private String CtJ;
  boolean CtK;
  private boolean CtL;
  com.tencent.mm.plugin.remittance.model.g CtM;
  private b CtN;
  private b CtO;
  protected boolean CtP;
  private Map<String, du> CtQ;
  private RemittanceF2fDynamicCodeUI CtR;
  private boolean CtS;
  private int CtT;
  private boolean CtU;
  private int CtV;
  private int CtW;
  private i CtX;
  private Runnable CtY;
  private com.tencent.mm.wallet_core.d.c<com.tencent.mm.plugin.remittance.model.l> CtZ;
  private TextView Cta;
  private View Ctb;
  private CdnImageView Ctc;
  private LinearLayout Ctd;
  private LinearLayout Cte;
  private TextView Ctf;
  private View Ctg;
  private TextView Cth;
  private Button Cti;
  private RelativeLayout Ctj;
  private String Ctk;
  private double Ctl;
  private String Ctm;
  private String Ctn;
  private String Cto;
  private String Ctp;
  private String Ctq;
  private int Ctr;
  private String Cts;
  private float Ctt;
  private boolean Ctu;
  private String Ctv;
  private int Ctw;
  private int Ctx;
  private String Cty;
  private eig Ctz;
  private c Cua;
  private boolean Cub;
  private double Cuc;
  private String Cud;
  private String Cue;
  private IListener Cuf;
  private IListener Cug;
  private IListener Cuh;
  private IListener Cui;
  private String app_id;
  private double dDO;
  private String dRM;
  private int dYe;
  private int jVe;
  private ScrollView jVf;
  private WcPayKeyboard jVg;
  private WalletFormView jVj;
  private RelativeLayout jVk;
  private TextView jVl;
  private RelativeLayout jVm;
  private Runnable jVx;
  private int mChannel;
  private int mPayScene;
  private int mRequestCode;
  private int state;
  
  public RemittanceBusiUI()
  {
    AppMethodBeat.i(68056);
    this.Ctt = 0.0F;
    this.Cnv = 4;
    this.CtB = 0;
    this.CtC = 0;
    this.CtD = 0;
    this.CtE = 0;
    this.CtH = new b();
    this.CtI = "";
    this.CtJ = "";
    this.CtK = false;
    this.dDO = -1.0D;
    this.CtL = false;
    this.CtM = null;
    this.Crx = false;
    this.CtP = false;
    this.mRequestCode = 0;
    this.CtQ = new HashMap();
    this.CtR = null;
    this.CtS = false;
    this.CtU = false;
    this.state = 0;
    this.jVx = new Runnable()
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
    this.CtY = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68028);
        RemittanceBusiUI.M(RemittanceBusiUI.this);
        AppMethodBeat.o(68028);
      }
    };
    this.CtZ = new com.tencent.mm.wallet_core.d.c()
    {
      public final void a(com.tencent.mm.wallet_core.d.d paramAnonymousd)
      {
        AppMethodBeat.i(163820);
        if ((paramAnonymousd instanceof com.tencent.mm.plugin.remittance.model.l)) {
          RemittanceBusiUI.b(RemittanceBusiUI.this, ((com.tencent.mm.plugin.remittance.model.l)paramAnonymousd).dDL);
        }
        AppMethodBeat.o(163820);
      }
    };
    this.Cua = new c();
    this.Cqt = new IListener() {};
    this.Cub = true;
    this.dYe = 0;
    this.Cuc = 0.0D;
    this.Cue = "";
    this.CrH = new IListener() {};
    this.Cuf = new IListener() {};
    this.Cug = new IListener() {};
    this.Cuh = new IListener() {};
    this.Cui = new IListener() {};
    AppMethodBeat.o(68056);
  }
  
  private void C(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(68075);
    Log.i("MicroMsg.RemittanceBusiUI", "doBusiZeroCallback %s", new Object[] { Boolean.valueOf(paramBoolean) });
    du localdu = (du)this.CtQ.get(paramString);
    if (localdu == null)
    {
      AppMethodBeat.o(68075);
      return;
    }
    eig localeig = this.Ctz;
    String str = this.Cty;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString = new com.tencent.mm.plugin.remittance.model.l(localeig, localdu, str, i, this.CtA, paramString);
      if (!paramBoolean) {
        break;
      }
      paramString.hasRetried = true;
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0);
      AppMethodBeat.o(68075);
      return;
    }
    this.CtE = 0;
    doSceneForceProgress(paramString);
    AppMethodBeat.o(68075);
  }
  
  private void a(int paramInt, rc paramrc, boolean paramBoolean, gl paramgl, String paramString1, String paramString2)
  {
    AppMethodBeat.i(68077);
    a(paramInt, paramrc, paramBoolean, paramgl, paramString1, paramString2, "");
    AppMethodBeat.o(68077);
  }
  
  private void a(int paramInt, rc paramrc, boolean paramBoolean, gl paramgl, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(163834);
    int i = 0;
    int j = 0;
    if (!this.Cub)
    {
      boolean bool1 = Util.isEqual(Double.valueOf(this.Cuc), Double.valueOf(this.Ctl));
      boolean bool2 = Util.isEqual(this.Cud, this.Csr);
      if (!bool1) {
        j = 1;
      }
      i = j;
      if (!bool2) {
        i = j | 0x2;
      }
    }
    String str1 = this.Crs;
    String str2 = this.Ctk;
    j = this.mPayScene;
    String str3 = this.Ctp;
    String str4 = this.Csr;
    int k = this.mChannel;
    String str5 = this.Ctq;
    String str6 = this.Ctv;
    int m = this.Ctx;
    int n = this.Ctw;
    String str7 = this.Ctm;
    anr localanr = this.CtH.Cqx;
    if (paramrc == null)
    {
      paramrc = "";
      paramString1 = new i(str1, str2, j, str3, str4, paramInt, k, str5, str6, m, n, str7, localanr, paramrc, this.Csz.Coi, paramString1, this.CqN, paramString2, this.Ctn, this.Cue, this.dYe, i, paramString3);
      if (paramBoolean) {
        paramString1.a(paramgl);
      }
      if (!this.mKindaEnable) {
        break label363;
      }
      if (this.CtR == null) {
        break label356;
      }
      this.CtR.showSafeProgress();
    }
    label259:
    label391:
    label404:
    for (;;)
    {
      label255:
      paramBoolean = false;
      paramrc = this;
      paramrc.doSceneProgress(paramString1, paramBoolean);
      if (this.CtS)
      {
        if (paramInt == this.CtT) {
          a(5, this.CtX);
        }
      }
      else {
        label290:
        if ((e.eNU().getContext() != null) && ((e.eNU().getContext() instanceof RemittanceBusiUI))) {
          if (this.CtU)
          {
            if (paramInt != this.CtW) {
              break label391;
            }
            a(13, this.CtX);
          }
        }
      }
      for (;;)
      {
        this.CtW = paramInt;
        AppMethodBeat.o(163834);
        return;
        paramrc = paramrc.KYa;
        break;
        label356:
        showLoading();
        break label255;
        label363:
        if (e.eNU().eNX()) {
          break label404;
        }
        paramBoolean = true;
        paramrc = this;
        break label259;
        a(4, this.CtX);
        break label290;
        a(12, this.CtX);
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
    if (this.CtK)
    {
      this.Cth.setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(eNZ()));
      MMHandlerThread.removeRunnable(this.CtY);
      this.Ctl = eNZ();
      long l = Math.round(this.Ctl * 100.0D);
      if (l <= 0L)
      {
        this.CtH.eNC();
        this.Cta.setTextColor(getContext().getResources().getColor(2131100245));
        this.Cta.setText(this.Csz.Coh);
        if (this.CtM != null) {
          this.CtM.cancel = true;
        }
        AppMethodBeat.o(68069);
        return;
      }
      j = (int)l;
      k = this.mChannel;
      m = this.Csz.Coi;
      str1 = this.Ctp;
      str2 = this.CqN;
      str3 = this.Csz.Coj;
      str4 = this.Crs;
      str5 = this.Ctm;
      str6 = this.Csz.Cok;
      if (paramc != null) {
        break label243;
      }
    }
    label243:
    for (int i = 0;; i = 1)
    {
      this.CtM = new com.tencent.mm.plugin.remittance.model.g(j, k, m, str1, str2, str3, str4, str5, str6, i, paramc, paramd);
      MMHandlerThread.postToMainThreadDelayed(this.CtY, paramInt);
      AppMethodBeat.o(68069);
      return;
    }
  }
  
  private void a(ri paramri)
  {
    AppMethodBeat.i(68085);
    Log.i("MicroMsg.RemittanceBusiUI", "resp.payer_need_auth_flag %s", new Object[] { Integer.valueOf(paramri.KYz) });
    if (paramri.KYz == 1)
    {
      paramri = new Bundle();
      EventCenter.instance.addListener(this.Cuh);
      paramri.putString("realname_verify_process_jump_activity", ".ui.RemittanceBusiUI");
      paramri.putString("realname_verify_process_jump_plugin", "remittance");
      paramri.putInt("real_name_verify_mode", 0);
      paramri.putInt("entry_scene", this.mPayScene);
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramri);
      AppMethodBeat.o(68085);
      return;
    }
    Intent localIntent = new Intent();
    Object localObject;
    if (!Util.isNullOrNil(this.CtG)) {
      localObject = this.CtG;
    }
    for (;;)
    {
      localIntent.putExtra("INTENT_TITLE", (String)localObject);
      localIntent.putExtra("INTENT_CAN_TOUCH", this.CtB);
      localIntent.putExtra("INTENT_PAYFEE", com.tencent.mm.wallet_core.ui.f.formatMoney2f(0.0D));
      localIntent.putExtra("INTENT_REQKEY", paramri.dNQ);
      paramri = paramri.KYA;
      try
      {
        localIntent.putExtra("INTENT_TOKENMESS", paramri.toByteArray());
        com.tencent.mm.br.c.b(getContext(), "wallet", "com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI", localIntent, 2);
        AppMethodBeat.o(68085);
        return;
      }
      catch (Exception paramri)
      {
        String str;
        StringBuilder localStringBuilder;
        Log.printErrStackTrace("MicroMsg.RemittanceBusiUI", paramri, "", new Object[0]);
        AppMethodBeat.o(68085);
      }
      str = getString(2131768199);
      if (!Util.isNullOrNil(this.Ctm))
      {
        com.tencent.mm.kernel.g.aAi();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ(this.Ctm);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.storage.as)localObject).arJ();
          localStringBuilder = new StringBuilder().append(com.tencent.mm.wallet_core.ui.f.bpz((String)localObject));
          if (Util.isNullOrNil(this.Ctn)) {}
          for (localObject = "";; localObject = "(" + this.Ctn + ")")
          {
            localObject = Util.safeFormatString(str, new Object[] { (String)localObject });
            break;
          }
        }
        Log.e("MicroMsg.RemittanceBusiUI", "can not found contact for user::" + this.Ctm);
        localObject = "";
      }
      else
      {
        Log.e("MicroMsg.RemittanceBusiUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
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
      Log.i("MicroMsg.RemittanceBusiUI", "onActivityResult _transId: %s _totalFee: %s", new Object[] { str1, Double.valueOf(d) });
      if (Util.isNullOrNil(this.AJn)) {
        this.AJn = str1;
      }
      if (d >= 0.0D) {
        this.dDO = d;
      }
      if (this.Crx) {
        com.tencent.mm.plugin.report.service.h.CyF.a(15386, new Object[] { Integer.valueOf(3), Integer.valueOf(2) });
      }
      eOd();
      aMl(str2);
    }
    for (;;)
    {
      c(paramBoolean, paramIntent);
      AppMethodBeat.o(68073);
      return;
      if (ag.bH(paramIntent))
      {
        finish();
        AppMethodBeat.o(68073);
        return;
      }
      if (ag.bI(paramIntent))
      {
        AppMethodBeat.o(68073);
        return;
      }
      Log.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor");
      eOc();
    }
  }
  
  private boolean a(i parami)
  {
    AppMethodBeat.i(68079);
    boolean bool1 = false;
    if (!this.CrC) {
      bool1 = b(parami);
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = c(parami);
    }
    AppMethodBeat.o(68079);
    return bool2;
  }
  
  private void aMl(String paramString)
  {
    AppMethodBeat.i(68086);
    Log.i("MicroMsg.RemittanceBusiUI", "do pay check: %s", new Object[] { paramString });
    paramString = (du)this.CtQ.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(68086);
      return;
    }
    if (!Util.isNullOrNil(this.AJn)) {
      paramString.KHN = this.AJn;
    }
    doSceneProgress(new com.tencent.mm.plugin.remittance.model.h(paramString, this.CtI), false);
    AppMethodBeat.o(68086);
  }
  
  private boolean b(final i parami)
  {
    AppMethodBeat.i(68080);
    if (!Util.isNullOrNil(parami.CoB.KYt))
    {
      this.CrC = true;
      bX(1, parami.CoB.KHM);
      e.eNU().a(parami.CoB.KYt, getString(2131755962), getString(2131764489), getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68036);
          RemittanceBusiUI.a(RemittanceBusiUI.this, 3, parami.CoB.KHM);
          if (!RemittanceBusiUI.b(RemittanceBusiUI.this, parami))
          {
            if (RemittanceBusiUI.T(RemittanceBusiUI.this))
            {
              if (RemittanceBusiUI.P(RemittanceBusiUI.this) == null) {
                break label84;
              }
              RemittanceBusiUI.P(RemittanceBusiUI.this).showSafeProgress();
            }
            for (;;)
            {
              RemittanceBusiUI.a(RemittanceBusiUI.this, parami);
              AppMethodBeat.o(68036);
              return;
              label84:
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
          RemittanceBusiUI.a(RemittanceBusiUI.this, 2, parami.CoB.KHM);
          AppMethodBeat.o(163824);
        }
      });
      AppMethodBeat.o(68080);
      return true;
    }
    AppMethodBeat.o(68080);
    return false;
  }
  
  private void bX(int paramInt, String paramString)
  {
    AppMethodBeat.i(68081);
    this.Crz = new kx();
    this.Crz.erW = 1L;
    this.Crz.ejA = paramInt;
    this.Crz.yp(paramString);
    this.Crz.bfK();
    AppMethodBeat.o(68081);
  }
  
  private void c(boolean paramBoolean, Intent paramIntent)
  {
    AppMethodBeat.i(68074);
    this.Cub = false;
    if (paramBoolean)
    {
      Log.i("MicroMsg.RemittanceBusiUI", "savePayInfo isOk = true");
      this.dYe = 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.RemittanceBusiUI", "savePayInfo() mLastPayResult:%s mLastTotalAmt:%s mLastPayerDesc:%s mLastF2fId:%s", new Object[] { Double.valueOf(this.Cuc), Double.valueOf(this.Cuc), this.Cud, this.Cue });
      AppMethodBeat.o(68074);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(68074);
        return;
      }
      this.dYe = paramIntent.getIntExtra("key_pay_reslut_type", 3);
      this.Cuc = this.Ctl;
      this.Cud = this.Csr;
      this.Cue = this.Csq;
    }
  }
  
  private boolean c(final i parami)
  {
    AppMethodBeat.i(68083);
    if (parami.CoB.KYu != null)
    {
      this.CrF = true;
      e.eNU().a(parami.CoB.pUa, "", parami.CoB.KYu.lHB, parami.CoB.KYu.lHA, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(163825);
          Log.i("MicroMsg.RemittanceBusiUI", "goto h5: %s", new Object[] { parami.CoB.KYu.qwt });
          com.tencent.mm.wallet_core.ui.f.p(RemittanceBusiUI.this.getContext(), parami.CoB.KYu.qwt, false);
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
    Log.i("MicroMsg.RemittanceBusiUI", "do start pay zero_pay_flag: %s", new Object[] { Integer.valueOf(parami.CoB.KYy) });
    if (e.eNU().eNW()) {
      Log.w("MicroMsg.RemittanceBusiUI", "finish finishRemitLMRemindUI");
    }
    Object localObject1 = new du();
    ((du)localObject1).channel = this.mChannel;
    ((du)localObject1).KHM = this.Csq;
    ((du)localObject1).KHN = this.AJn;
    ((du)localObject1).Coi = this.Csz.Coi;
    ((du)localObject1).scene = this.mPayScene;
    ((du)localObject1).KHO = this.Csv;
    ((du)localObject1).KHP = this.CtH.Cqx;
    ((du)localObject1).jTz = this.Ctm;
    ((du)localObject1).CpJ = this.Crs;
    ((du)localObject1).KHQ = parami.Bbl;
    this.CtQ.put(parami.CoB.dNQ, localObject1);
    if (parami.CoB.KYy == 1)
    {
      a(parami.CoB);
      AppMethodBeat.o(68084);
      return;
    }
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.dDL = parami.CoB.dNQ;
    localPayInfo.dVv = this.mPayScene;
    if (this.mChannel > 0) {
      localPayInfo.channel = this.mChannel;
    }
    if (parami.CoB.KYF != null) {
      localPayInfo.wFE = parami.CoB.KYF.yO();
    }
    localPayInfo.Ijy = parami.CoB.KYE;
    Object localObject2;
    if (parami.CoB.KYG == 1)
    {
      bool = true;
      localPayInfo.HZb = bool;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("extinfo_key_1", this.Ctm);
      ((Bundle)localObject1).putString("extinfo_key_2", this.Ctn);
      ((Bundle)localObject1).putString("extinfo_key_3", this.Ctp);
      ((Bundle)localObject1).putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
      ((Bundle)localObject1).putString("extinfo_key_7", this.Csr);
      ((Bundle)localObject1).putString("extinfo_key_19", parami.CoB.Cpt);
      localPayInfo.iqp = ((Bundle)localObject1);
      localPayInfo.CpF = 1;
      localObject2 = new Intent();
      if (parami.CoB.Cpq != 1) {
        break label718;
      }
      ((Bundle)localObject1).putInt("extinfo_key_15", parami.CoB.KYH);
      ((Bundle)localObject1).putString("extinfo_key_17", parami.CoB.Cpr);
      ((Bundle)localObject1).putString("extinfo_key_18", parami.CoB.Cps);
      ((Intent)localObject2).putExtra("key_pay_info", localPayInfo);
      ((Intent)localObject2).putExtra("from_patch_ui", true);
      ((Intent)localObject2).putExtra("key_rcvr_open_id", this.Crs);
      ((Intent)localObject2).putExtra("key_mch_info", this.Cts);
      ((Intent)localObject2).putExtra("key_mch_photo", this.Csz.Cog);
      ((Intent)localObject2).putExtra("key_transfer_qrcode_id", this.Ctk);
      ((Intent)localObject2).putExtra("get_dynamic_code_sign", parami.CoB.Cpr);
      ((Intent)localObject2).putExtra("get_dynamic_code_extend", parami.CoB.Cps);
      ((Intent)localObject2).putExtra("dynamic_code_spam_wording", parami.CoB.Cpu);
      ((Intent)localObject2).putExtra("dynamic_code_amount", parami.CoB.KYH);
      ((Intent)localObject2).putExtra("show_paying_wording", parami.CoB.Cpt);
      if (this.Csz.Coo != 1) {
        break label713;
      }
    }
    label713:
    for (boolean bool = true;; bool = false)
    {
      ((Intent)localObject2).putExtra("show_avatar_type", bool);
      com.tencent.mm.plugin.report.service.h.CyF.a(15386, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
      this.CrH.alive();
      this.Cuf.alive();
      this.Cug.alive();
      if (this.mKindaEnable) {
        hideLoading();
      }
      com.tencent.mm.br.c.b(this, "remittance", ".ui.RemittanceF2fDynamicCodeUI", (Intent)localObject2, 3);
      AppMethodBeat.o(68084);
      return;
      bool = false;
      break;
    }
    label718:
    String str;
    if (this.mKindaEnable)
    {
      this.mRequestCode = 1;
      if (this.CtR != null) {
        this.mRequestCode = 3;
      }
      str = "";
      if (!Util.isNullOrNil(parami.CoB.Cpt))
      {
        parami = parami.CoB.Cpt;
        if (localPayInfo.iqp == null) {
          localPayInfo.iqp = new Bundle();
        }
        localPayInfo.iqp.putString("cashier_desc", parami);
        if (Util.isNullOrNil(this.Ctm)) {
          break label1309;
        }
        com.tencent.mm.kernel.g.aAi();
        parami = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ(this.Ctm);
        if (parami == null) {
          break label1309;
        }
        parami = parami.arJ();
        localObject1 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.f.bpz(parami));
        if (!Util.isNullOrNil(this.Ctn)) {
          break label1148;
        }
        parami = "";
      }
    }
    label876:
    for (parami = parami;; parami = "")
    {
      localPayInfo.iqp.putString("prepay_page_payee", parami);
      if (this.CtR != null) {
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this.CtR, localPayInfo);
      }
      for (;;)
      {
        this.CtP = true;
        AppMethodBeat.o(68084);
        return;
        localObject2 = getIntent().getStringExtra("receiver_tips");
        localObject1 = getString(2131768199);
        parami = str;
        if (!Util.isNullOrNil((String)localObject2))
        {
          localObject1 = localObject2;
          parami = (i)localObject2;
        }
        if (!Util.isNullOrNil(this.Ctm))
        {
          com.tencent.mm.kernel.g.aAi();
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ(this.Ctm);
          if (localObject2 != null)
          {
            parami = ((com.tencent.mm.storage.as)localObject2).arJ();
            localObject2 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.f.bpz(parami));
            if (Util.isNullOrNil(this.Ctn)) {}
            for (parami = "";; parami = "(" + this.Ctn + ")")
            {
              parami = Util.safeFormatString((String)localObject1, new Object[] { parami });
              break;
            }
          }
          Log.e("MicroMsg.RemittanceBusiUI", "can not found contact for user::" + this.Ctm);
          break;
        }
        Log.e("MicroMsg.RemittanceBusiUI", "mRcverName is null ,scene is MMPAY_PAY_SCENE_TRANSFER busi");
        break;
        label1148:
        parami = "(" + this.Ctn + ")";
        break label876;
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, localPayInfo);
      }
      if (!Util.isNullOrNil(parami.CoC)) {}
      for (this.Crx = true; (parami.CoD != null) && (parami.CoD.dKn.dKq != null); this.Crx = false)
      {
        com.tencent.mm.pluginsdk.wallet.f.a(parami.CoD.dKn.dKq, false, "", localPayInfo, this.Ctn, (Intent)localObject2, parami.CoD.dKn.mRequestCode);
        AppMethodBeat.o(68084);
        return;
      }
      com.tencent.mm.pluginsdk.wallet.f.a(this, false, "", localPayInfo, this.Ctn, (Intent)localObject2, 1);
      AppMethodBeat.o(68084);
      return;
    }
  }
  
  private void dmp()
  {
    AppMethodBeat.i(68087);
    this.Ctl = eNZ();
    if (this.Ctl <= 0.0D)
    {
      findViewById(2131300540).setClickable(false);
      findViewById(2131300540).setEnabled(false);
      findViewById(2131300540).setOnClickListener(null);
      gf(false);
      this.Cta.setTextColor(getResources().getColor(2131100900));
      AppMethodBeat.o(68087);
      return;
    }
    this.Cta.setTextColor(getContext().getResources().getColor(2131100245));
    findViewById(2131300540).setEnabled(true);
    findViewById(2131300540).setClickable(true);
    gf(true);
    findViewById(2131300540).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163832);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.plugin.report.service.h.CyF.a(15235, new Object[] { Integer.valueOf(3) });
        if (RemittanceBusiUI.n(RemittanceBusiUI.this) == 56) {
          com.tencent.mm.plugin.report.service.h.CyF.a(19821, new Object[] { Integer.valueOf(7), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
        }
        RemittanceBusiUI.J(RemittanceBusiUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(163832);
      }
    });
    AppMethodBeat.o(68087);
  }
  
  private void eNP()
  {
    AppMethodBeat.i(68066);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68019);
        RemittanceBusiUI.E(RemittanceBusiUI.this).setText(RemittanceBusiUI.D(RemittanceBusiUI.this));
        Object localObject;
        if ((RemittanceBusiUI.k(RemittanceBusiUI.this) != null) && (!Util.isNullOrNil(RemittanceBusiUI.k(RemittanceBusiUI.this).Cop)))
        {
          localObject = RemittanceBusiUI.k(RemittanceBusiUI.this).Cop;
          RemittanceBusiUI.H(RemittanceBusiUI.this).setText(com.tencent.mm.pluginsdk.ui.span.l.b(RemittanceBusiUI.this, (CharSequence)localObject, RemittanceBusiUI.H(RemittanceBusiUI.this).getTextSize()));
          if (RemittanceBusiUI.k(RemittanceBusiUI.this) == null) {
            break label358;
          }
          if (RemittanceBusiUI.k(RemittanceBusiUI.this).Cof != 1) {
            break label340;
          }
          if (Util.isNullOrNil(RemittanceBusiUI.k(RemittanceBusiUI.this).Cog)) {
            break label267;
          }
          if (RemittanceBusiUI.k(RemittanceBusiUI.this).Coo != 1) {
            break label253;
          }
          RemittanceBusiUI.I(RemittanceBusiUI.this).setRoundCorner(true);
        }
        for (;;)
        {
          int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(RemittanceBusiUI.this, 36.0F);
          RemittanceBusiUI.I(RemittanceBusiUI.this).s(RemittanceBusiUI.k(RemittanceBusiUI.this).Cog, i, i, -1);
          AppMethodBeat.o(68019);
          return;
          String str = com.tencent.mm.wallet_core.ui.f.hs(com.tencent.mm.wallet_core.ui.f.getDisplayName(RemittanceBusiUI.F(RemittanceBusiUI.this)), 10);
          localObject = str;
          if (Util.isNullOrNil(RemittanceBusiUI.G(RemittanceBusiUI.this))) {
            break;
          }
          localObject = RemittanceBusiUI.this.getString(2131764504, new Object[] { str, RemittanceBusiUI.G(RemittanceBusiUI.this) });
          break;
          label253:
          RemittanceBusiUI.I(RemittanceBusiUI.this).setRoundCorner(false);
        }
        label267:
        if (!Util.isNullOrNil(RemittanceBusiUI.F(RemittanceBusiUI.this)))
        {
          if (RemittanceBusiUI.k(RemittanceBusiUI.this).Coo == 1)
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
  
  private double eNZ()
  {
    AppMethodBeat.i(68057);
    if ((this.Ctu) || (this.mPayScene == 33))
    {
      d = this.Ctl;
      AppMethodBeat.o(68057);
      return d;
    }
    this.Ctl = Util.getDouble(this.jVj.getText(), 0.0D);
    double d = this.Ctl;
    AppMethodBeat.o(68057);
    return d;
  }
  
  private boolean eOa()
  {
    AppMethodBeat.i(68067);
    boolean bool;
    if (this.Ctb == null) {
      bool = false;
    }
    for (;;)
    {
      com.tencent.mm.ui.tools.p.a(this, this.jVf, findViewById(2131306914), findViewById(2131306914), findViewById(2131306913), this.Ctt);
      AppMethodBeat.o(68067);
      return bool;
      if (this.Csz != null)
      {
        Log.i("MicroMsg.RemittanceBusiUI", "tryShowFavor ");
        if ((this.Csz.Com != null) && (this.Csz.Com.KXY.size() > 0)) {}
        for (int i = 1;; i = 0)
        {
          if (this.Csz.Col.size() > 0) {
            i = 1;
          }
          if (this.CtH.eND().size() > 0) {
            i = 1;
          }
          if (i == 0)
          {
            this.Ctb.setVisibility(8);
            this.CtO.update();
            this.Ctg.setVisibility(8);
            bool = false;
            break;
          }
          this.Ctg.setVisibility(0);
          this.CtN.update();
          this.Ctb.setVisibility(0);
          this.Cta.setText(this.Csz.Coh);
          this.Cta.setTextColor(getContext().getResources().getColor(2131100245));
          this.Cth.setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(eNZ()));
          Object localObject = this.CtH.Cqx;
          if (localObject != null)
          {
            this.Cta.setTextColor(getContext().getResources().getColor(2131099792));
            this.Cta.setText(((anr)localObject).Coh);
            this.Cth.setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(((anr)localObject).LyL / 100.0D));
          }
          for (;;)
          {
            findViewById(2131300540).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68020);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                com.tencent.mm.plugin.report.service.h.CyF.a(15235, new Object[] { Integer.valueOf(3) });
                if (RemittanceBusiUI.n(RemittanceBusiUI.this) == 56) {
                  com.tencent.mm.plugin.report.service.h.CyF.a(19821, new Object[] { Integer.valueOf(7), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
                }
                RemittanceBusiUI.J(RemittanceBusiUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68020);
              }
            });
            bool = true;
            break;
            localObject = this.CtH.eNE();
            if (!Util.isNullOrNil((String)localObject))
            {
              this.Cta.setTextColor(getContext().getResources().getColor(2131100245));
              this.Cta.setText((CharSequence)localObject);
            }
          }
        }
      }
      bool = false;
    }
  }
  
  private void eOb()
  {
    AppMethodBeat.i(163833);
    hideLoading();
    if (this.CtR != null) {
      this.CtR.hideProgress();
    }
    AppMethodBeat.o(163833);
  }
  
  private void eOc()
  {
    AppMethodBeat.i(68076);
    Log.i("MicroMsg.RemittanceBusiUI", "unLockFavorimp");
    anr localanr = this.CtH.Cqx;
    if (localanr == null)
    {
      Log.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor FavorComposeInfo is null");
      AppMethodBeat.o(68076);
      return;
    }
    int i = (int)Math.round(this.Ctl * 100.0D);
    du localdu = new du();
    localdu.channel = this.mChannel;
    localdu.KHM = this.Csq;
    localdu.KHN = this.AJn;
    localdu.Coi = this.Csz.Coi;
    localdu.scene = this.mPayScene;
    localdu.KHO = this.Csv;
    localdu.KHP = localanr;
    localdu.jTz = this.Ctm;
    localdu.CpJ = this.Crs;
    localdu.KHQ = i;
    doSceneProgress(new k(localdu, this.CtI), false);
    AppMethodBeat.o(68076);
  }
  
  private void eOd()
  {
    AppMethodBeat.i(68078);
    Log.i("MicroMsg.RemittanceBusiUI", "goto busi result");
    Object localObject = new Intent(this, RemittanceBusiResultUI.class);
    ((Intent)localObject).putExtra("key_pay_desc", this.Csr);
    ((Intent)localObject).putExtra("key_rcv_desc", this.Ctp);
    if (this.Csz != null) {
      ((Intent)localObject).putExtra("BusiRemittanceResp", this.Csz);
    }
    ((Intent)localObject).putExtra("key_mch_name", this.CqN);
    ((Intent)localObject).putExtra("key_rcver_name", this.Ctm);
    ((Intent)localObject).putExtra("key_rcver_true_name", this.Ctn);
    if (this.dDO >= 0.0D) {
      ((Intent)localObject).putExtra("key_money", this.dDO);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_f2f_id", this.Csq);
      ((Intent)localObject).putExtra("key_trans_id", this.AJn);
      ((Intent)localObject).putExtra("key_check_sign", this.Csv);
      ((Intent)localObject).putExtra("key_rcvr_open_id", this.Crs);
      ((Intent)localObject).putExtra("key_channel", this.mChannel);
      ((Intent)localObject).putExtra("key_succ_fault_config", this.CtF);
      if (this.Csz != null)
      {
        ((Intent)localObject).putExtra("key_succ_show_avatar_type", this.Csz.Coo);
        ((Intent)localObject).putExtra("key_succ_show_avatar_show", this.Csz.Cof);
        ((Intent)localObject).putExtra("key_succ_show_avatar_url", this.Csz.Cog);
      }
      if (this.Csz != null) {
        ((Intent)localObject).putExtra("key_scan_sceen", this.Csz.Coi);
      }
      ((Intent)localObject).putExtra("key_succ_page_extend", this.CtJ);
      if (this.mChannel == 56) {
        ((Intent)localObject).putExtra("app_id", this.app_id);
      }
      anr localanr = this.CtH.Cqx;
      int i = (int)Math.round(this.Ctl * 100.0D);
      du localdu = new du();
      localdu.channel = this.mChannel;
      localdu.KHM = this.Csq;
      localdu.KHN = this.AJn;
      localdu.Coi = this.Csz.Coi;
      localdu.scene = this.mPayScene;
      localdu.KHO = this.Csv;
      localdu.KHP = localanr;
      localdu.jTz = this.Ctm;
      localdu.CpJ = this.Crs;
      localdu.KHQ = i;
      try
      {
        ((Intent)localObject).putExtra("AfterPlaceOrderCommReq", localdu.toByteArray());
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI", "gotoBusiResultUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI", "gotoBusiResultUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        if (e.eNU().eNV()) {
          Log.w("MicroMsg.RemittanceBusiUI", "finish finishRemitF2fDCodeAndLMRemindUI");
        }
        AppMethodBeat.o(68078);
        return;
        ((Intent)localObject).putExtra("key_money", this.Ctl);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.RemittanceBusiUI", localException, "", new Object[0]);
        }
      }
    }
  }
  
  private void gf(boolean paramBoolean)
  {
    AppMethodBeat.i(68088);
    if (this.jVg != null) {
      this.jVg.DH(paramBoolean);
    }
    AppMethodBeat.o(68088);
  }
  
  private void gu(final List<ans> paramList)
  {
    AppMethodBeat.i(68068);
    final com.tencent.mm.ui.widget.picker.e locale = new com.tencent.mm.ui.widget.picker.e(this);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = this.CtH.Cqx;
    Object localObject1 = new HashSet();
    final HashSet localHashSet = new HashSet();
    if ((this.CtH.eNG()) && (localObject2 != null))
    {
      localObject2 = ((anr)localObject2).KXX.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((HashSet)localObject1).add(Long.valueOf(((ans)((Iterator)localObject2).next()).LyS));
      }
    }
    localObject2 = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      if (((HashSet)localObject1).contains(Long.valueOf(((ans)((Iterator)localObject2).next()).LyS))) {
        localArrayList.add(Integer.valueOf(i));
      }
      i += 1;
    }
    localObject1 = getString(2131764552);
    if ((localObject1 != null) && (((CharSequence)localObject1).length() > 0))
    {
      locale.QTp.setVisibility(0);
      locale.FdD.setText((CharSequence)localObject1);
    }
    locale.QTq = localArrayList;
    locale.HLX = new o.f()
    {
      public final void onCreateMMMenu(m paramAnonymousm)
      {
        AppMethodBeat.i(68024);
        RemittanceBusiUI.a(RemittanceBusiUI.this, RemittanceBusiUI.q(RemittanceBusiUI.this));
        ans localans;
        if ((!RemittanceBusiUI.K(RemittanceBusiUI.this).eNG()) || (RemittanceBusiUI.r(RemittanceBusiUI.this) <= 0.0D))
        {
          localIterator = paramList.iterator();
          i = 0;
          while (localIterator.hasNext())
          {
            localans = (ans)localIterator.next();
            paramAnonymousm.a(i, localans.LyT, localans.LyV, null, true);
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
          localans = (ans)localIterator.next();
          if (localans.Lzb == 1)
          {
            paramAnonymousm.a(i, localans.LyT, localans.LyV, null, true);
            localHashSet.add(Integer.valueOf(i));
          }
          for (;;)
          {
            i += 1;
            break;
            paramAnonymousm.a(i, localans.LyT, localans.LyV, 0);
          }
        }
        AppMethodBeat.o(68024);
      }
    };
    locale.HLY = new o.g()
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
          com.tencent.mm.plugin.report.service.h.CyF.a(15235, new Object[] { Integer.valueOf(4) });
          Object localObject1 = (ans)paramList.get(paramAnonymousInt);
          paramAnonymousMenuItem = locale;
          boolean bool;
          if (paramAnonymousMenuItem.QTr != null)
          {
            paramAnonymousMenuItem = paramAnonymousMenuItem.QTr.hcl();
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
                ((List)localObject2).add((ans)paramList.get(k));
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
            localObject1 = RemittanceBusiUI.K(RemittanceBusiUI.this).Cqx;
            paramAnonymousMenuItem = new HashSet();
            if (localObject1 == null) {
              break;
            }
            localObject1 = ((anr)localObject1).KXX.iterator();
            while (((Iterator)localObject1).hasNext()) {
              paramAnonymousMenuItem.add(Long.valueOf(((ans)((Iterator)localObject1).next()).LyS));
            }
          }
          localObject1 = new HashMap();
          Object localObject2 = paramList.iterator();
          i = j;
          if (((Iterator)localObject2).hasNext())
          {
            if (paramAnonymousMenuItem.contains(Long.valueOf(((ans)((Iterator)localObject2).next()).LyS))) {
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
          if (paramAnonymousMenuItem.QTr != null)
          {
            paramAnonymousMenuItem.QTr.QTu = ((HashMap)localObject1);
            paramAnonymousMenuItem.QTr.notifyDataSetChanged();
          }
        }
        AppMethodBeat.o(68026);
      }
    };
    locale.QTs = new e.b()
    {
      public final void tK(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(68027);
        if (paramAnonymousBoolean)
        {
          localObject = RemittanceBusiUI.K(RemittanceBusiUI.this).Cqx;
          if (localObject != null) {
            break label56;
          }
        }
        label56:
        for (Object localObject = "";; localObject = com.tencent.mm.plugin.remittance.model.a.a((anr)localObject))
        {
          Log.i("MicroMsg.RemittanceBusiUI", "onFavorSelected %s ", new Object[] { localObject });
          RemittanceBusiUI.L(RemittanceBusiUI.this);
          AppMethodBeat.o(68027);
          return;
        }
      }
    };
    if (locale.HLX != null) {
      locale.HLX.onCreateMMMenu(locale.HMc);
    }
    locale.QTr = new e.a(locale, locale.mContext);
    locale.QTr.hck();
    locale.QTo.setAdapter(locale.QTr);
    locale.hPX.setOnClickListener(new e.2(locale));
    locale.hSq.setOnClickListener(new e.3(locale));
    if (locale.yfL != null)
    {
      if ((locale.HMc != null) && (locale.HMc.size() > 3))
      {
        paramList = (FrameLayout.LayoutParams)locale.lJI.getLayoutParams();
        paramList.height = locale.mLJ;
        locale.lJI.setLayoutParams(paramList);
      }
      locale.yfL.show();
    }
    AppMethodBeat.o(68068);
  }
  
  public final void a(int paramInt, i parami)
  {
    AppMethodBeat.i(163835);
    au localau = new au();
    localau.enW = paramInt;
    if (parami != null)
    {
      localau.iA(parami.CoB.KHM);
      localau.iB(this.Ctk);
      localau.equ = parami.Bbl;
    }
    localau.bfK();
    AppMethodBeat.o(163835);
  }
  
  public final void bO(float paramFloat)
  {
    AppMethodBeat.i(68065);
    if (this.jVf != null)
    {
      this.Ctt = paramFloat;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jVf.getLayoutParams();
      localLayoutParams.bottomMargin = ((int)paramFloat);
      Log.d("MicroMsg.RemittanceBusiUI", "onUpdateWcPayKeyboardHeight() height: %s rootView.height: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(localLayoutParams.height) });
      this.jVf.setLayoutParams(localLayoutParams);
      com.tencent.mm.ui.tools.p.a(this, this.jVf, findViewById(2131306914), findViewById(2131306914), findViewById(2131306913), paramFloat);
    }
    AppMethodBeat.o(68065);
  }
  
  public int getLayoutId()
  {
    return 2131496098;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68063);
    hideActionbarLine();
    this.jVf = ((ScrollView)findViewById(2131307173));
    this.CsU = ((TextView)findViewById(2131306864));
    this.CsV = ((TextView)findViewById(2131306865));
    this.CsW = ((TextView)findViewById(2131306861));
    this.CsX = ((TextView)findViewById(2131306858));
    this.CsY = ((TextView)findViewById(2131306852));
    this.CsZ = ((TextView)findViewById(2131306850));
    this.Ctc = ((CdnImageView)findViewById(2131306862));
    this.jVj = ((WalletFormView)findViewById(2131306863));
    this.Ctd = ((LinearLayout)findViewById(2131306859));
    this.Crd = ((LinearLayout)findViewById(2131306854));
    this.Ctj = ((RelativeLayout)findViewById(2131310215));
    this.Cte = ((LinearLayout)findViewById(2131306853));
    this.Cta = ((TextView)findViewById(2131300544));
    this.Ctb = findViewById(2131306855);
    this.Ctf = ((TextView)findViewById(2131306857));
    this.Ctg = findViewById(2131300727);
    this.Cth = ((TextView)findViewById(2131300726));
    this.Cti = ((Button)findViewById(2131306860));
    this.jVg = ((WcPayKeyboard)findViewById(2131310544));
    ImageView localImageView;
    label536:
    label680:
    boolean bool1;
    if (this.Ctu)
    {
      if (!Util.isNullOrNil(this.Ctp)) {
        this.CsW.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, this.Ctp, this.CsW.getTextSize()));
      }
      this.CsX.setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(this.Ctl));
      this.Ctd.setVisibility(0);
      this.Crd.setVisibility(8);
      this.Ctj.setVisibility(8);
      this.Cti.setVisibility(0);
      if (com.tencent.mm.kernel.g.aAc())
      {
        com.tencent.mm.kernel.g.aAi();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.Ctm);
        if ((localObject == null) || ((int)((com.tencent.mm.contact.c)localObject).gMZ == 0)) {
          ay.a.iDq.a(this.Ctm, "", new ay.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(68044);
              Log.i("MicroMsg.RemittanceBusiUI", "getContact %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              RemittanceBusiUI.l(RemittanceBusiUI.this);
              AppMethodBeat.o(68044);
            }
          });
        }
      }
      eNP();
      this.Cte.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68048);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (!RemittanceBusiUI.m(RemittanceBusiUI.this)) {
            RemittanceBusiUI.this.showCircleStWcKb();
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(15235, new Object[] { Integer.valueOf(6) });
          if (RemittanceBusiUI.n(RemittanceBusiUI.this) == 56) {
            com.tencent.mm.plugin.report.service.h.CyF.a(19821, new Object[] { Integer.valueOf(6), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
          }
          com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBusiUI.this, RemittanceBusiUI.this.getString(2131764487), RemittanceBusiUI.o(RemittanceBusiUI.this), RemittanceBusiUI.this.getString(2131764490), true, 20, new h.b()new DialogInterface.OnClickListener
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
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          com.tencent.mm.plugin.report.service.h.CyF.a(15235, new Object[] { Integer.valueOf(5) });
          if (RemittanceBusiUI.n(RemittanceBusiUI.this) == 56) {
            com.tencent.mm.plugin.report.service.h.CyF.a(19821, new Object[] { Integer.valueOf(8), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
          }
          if (!RemittanceBusiUI.m(RemittanceBusiUI.this)) {
            RemittanceBusiUI.a(RemittanceBusiUI.this, RemittanceBusiUI.q(RemittanceBusiUI.this));
          }
          if (RemittanceBusiUI.r(RemittanceBusiUI.this) <= 0.0D)
          {
            u.makeText(RemittanceBusiUI.this.getContext(), 2131767474, 0).show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68051);
            return;
          }
          localObject = RemittanceBusiUI.this.CtM;
          if (RemittanceBusiUI.this.CtM == null)
          {
            paramAnonymousView = "";
            Log.i("MicroMsg.RemittanceBusiUI", "mPayBtn onClick %s  isFinish:%s getFavorFlag: %s", new Object[] { localObject, paramAnonymousView, Boolean.valueOf(RemittanceBusiUI.this.CtK) });
            if (RemittanceBusiUI.j(RemittanceBusiUI.this) != 32) {
              break label410;
            }
            if (!RemittanceBusiUI.this.CtK) {
              break label400;
            }
            if ((RemittanceBusiUI.this.CtM == null) || (RemittanceBusiUI.this.CtM.Cnj != (int)(RemittanceBusiUI.r(RemittanceBusiUI.this) * 100.0D))) {
              break label381;
            }
            if ((RemittanceBusiUI.this.CtM != null) && (RemittanceBusiUI.this.CtM.Coy)) {
              break label410;
            }
            if (RemittanceBusiUI.this.CtM != null) {
              RemittanceBusiUI.this.CtM.Cow = new com.tencent.mm.plugin.remittance.model.c()
              {
                public final void gt(List<ans> paramAnonymous2List)
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
            paramAnonymousView = RemittanceBusiUI.this.CtM.Coy;
            break;
            label381:
            RemittanceBusiUI.a(RemittanceBusiUI.this, new com.tencent.mm.plugin.remittance.model.c()
            {
              public final void gt(List<ans> paramAnonymous2List)
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
      this.jVj.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(68052);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66))
          {
            Log.i("MicroMsg.RemittanceBusiUI", "click enter");
            this.jVJ.onClick(null);
            AppMethodBeat.o(68052);
            return true;
          }
          AppMethodBeat.o(68052);
          return true;
        }
      });
      localImageView = (ImageView)findViewById(2131310211);
      if (ao.isDarkMode())
      {
        findViewById(2131310216).setVisibility(8);
        findViewById(2131310213).setVisibility(0);
        localImageView.setBackgroundResource(2131235634);
        this.Cti.setOnClickListener((View.OnClickListener)localObject);
        this.jVf.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(68015);
            if ((RemittanceBusiUI.t(RemittanceBusiUI.this) != null) && (RemittanceBusiUI.u(RemittanceBusiUI.this).isShown()) && (RemittanceBusiUI.v(RemittanceBusiUI.this).hgP()))
            {
              RemittanceBusiUI.w(RemittanceBusiUI.this).hgN();
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
        this.jVm = ((RelativeLayout)findViewById(2131310212));
        if ((!LocaleUtil.getApplicationLanguage().equals("zh_CN")) && (!LocaleUtil.getApplicationLanguage().equals("zh_TW")) && (!LocaleUtil.getApplicationLanguage().equals("zh_HK"))) {
          break label993;
        }
        this.jVk = ((RelativeLayout)findViewById(2131310214));
        this.jVl = ((TextView)findViewById(2131310217));
        this.jVk.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68017);
            RemittanceBusiUI.a(RemittanceBusiUI.this, RemittanceBusiUI.y(RemittanceBusiUI.this).getWidth());
            RemittanceBusiUI.z(RemittanceBusiUI.this).setVisibility(8);
            Log.d("MicroMsg.RemittanceBusiUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(RemittanceBusiUI.A(RemittanceBusiUI.this)) });
            AppMethodBeat.o(68017);
          }
        });
        this.jVj.setmWalletFormViewListener(new WalletFormView.c()
        {
          public final void p(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(68018);
            if (Util.isEqual(RemittanceBusiUI.B(RemittanceBusiUI.this), 0))
            {
              Log.i("MicroMsg.RemittanceBusiUI", "mAmountRemindBit == 0");
              RemittanceBusiUI.z(RemittanceBusiUI.this).setVisibility(8);
              AppMethodBeat.o(68018);
              return;
            }
            long l = Double.valueOf(Util.getDouble(paramAnonymousCharSequence.toString(), 0.0D)).longValue();
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
              j = RemittanceBusiUI.c(RemittanceBusiUI.this).k(paramAnonymousCharSequence, RemittanceBusiUI.A(RemittanceBusiUI.this), j);
              if (j != 0)
              {
                RemittanceBusiUI.z(RemittanceBusiUI.this).setVisibility(0);
                paramAnonymousCharSequence = ag.aR(MMApplicationContext.getContext(), i);
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
        if ((this.Csz != null) && (this.Csz.Com != null))
        {
          this.CtH.Cqy = this.Csz.Com;
          this.CtH.aMi(this.Csz.Com.KXZ);
        }
        if (eOa()) {
          com.tencent.mm.plugin.report.service.h.CyF.a(15235, new Object[] { Integer.valueOf(2) });
        }
        AppMethodBeat.o(68063);
      }
    }
    else
    {
      if (this.Csz == null) {
        break label1010;
      }
      if (this.Csz.Col.size() <= 0) {
        break label1005;
      }
      bool1 = false;
      label786:
      bool2 = bool1;
      if (this.Csz.Com != null)
      {
        bool2 = bool1;
        if (this.Csz.Com.KXX.size() <= 0) {}
      }
    }
    label993:
    label1005:
    label1010:
    for (boolean bool2 = false;; bool2 = true)
    {
      this.Cti.setVisibility(8);
      setWPKeyboard(this.jVj.getContentEt(), bool2, true);
      this.jVj.setmContentAbnormalMoneyCheck(true);
      if (com.tencent.mm.compatible.util.d.oD(28)) {
        this.jVj.getContentEt().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68042);
            RemittanceBusiUI.c(RemittanceBusiUI.this).getContentEt().requestFocus();
            AppMethodBeat.o(68042);
          }
        });
      }
      this.jVg.setActionText(getString(2131764500));
      setWcKbHeightListener(this);
      ((RelativeLayout.LayoutParams)this.jVg.getLayoutParams()).addRule(12);
      this.jVj.a(new TextWatcher()
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
          for (int i = 400;; i = RemittanceBusiUI.k(RemittanceBusiUI.this).Cor)
          {
            RemittanceBusiUI.a(paramAnonymousEditable, null, i);
            AppMethodBeat.o(68043);
            return;
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.jVj.hib();
      this.Ctd.setVisibility(8);
      this.Crd.setVisibility(0);
      this.Ctj.setVisibility(0);
      break;
      findViewById(2131310216).setVisibility(0);
      findViewById(2131310213).setVisibility(8);
      localImageView.setBackgroundResource(2131235633);
      break label536;
      this.jVm.setVisibility(8);
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
      if ((!this.CtP) && (!this.Ctu) && (this.jVg.hgR()))
      {
        AppMethodBeat.o(68062);
        return true;
      }
      AppMethodBeat.o(68062);
      return false;
    }
    if ((!this.Ctu) && (this.jVg.hgR()))
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
    Log.i("MicroMsg.RemittanceBusiUI", "onActivityResult requestCode %s resultCode %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    if (paramInt1 == 3)
    {
      if (this.CtR != null)
      {
        this.CtR.hideProgress();
        this.CtR = null;
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
          this.CtA = str;
          this.dDO = 0.0D;
          Log.i("MicroMsg.RemittanceBusiUI", "onActivityResult _result_token: %s", new Object[] { str });
          C(false, paramIntent.getStringExtra("INTENT_REQKEY"));
        }
        else
        {
          eOc();
        }
      }
      else if (paramInt1 == 4) {
        this.CtU = true;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68058);
    super.onCreate(paramBundle);
    if (getIntent().getIntExtra("pay_channel", 0) == 56)
    {
      overridePendingTransition(2130772169, 2130772166);
      this.app_id = getIntent().getStringExtra("app_id");
      com.tencent.mm.plugin.report.service.h.CyF.a(19821, new Object[] { Integer.valueOf(4), this.app_id, Integer.valueOf(0) });
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(15235, new Object[] { Integer.valueOf(1) });
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131100898)));
    paramBundle = getSupportActionBar().getCustomView();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.findViewById(16908308);
      if ((paramBundle != null) && ((paramBundle instanceof TextView))) {
        ((TextView)paramBundle).setTextColor(getResources().getColor(2131100904));
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(2131100898));
    }
    if ((com.tencent.mm.compatible.util.d.oD(21)) && (!com.tencent.mm.compatible.util.d.oD(23))) {
      getWindow().setStatusBarColor(getContext().getResources().getColor(2131099689));
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
    }, 2131689492);
    addSceneEndListener(1633);
    addSceneEndListener(1241);
    addSceneEndListener(2677);
    addSceneEndListener(2504);
    addSceneEndListener(2702);
    addSceneEndListener(2682);
    regeistQueryOrder(2682, this.CtZ);
    setMMTitle(2131764500);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(68014);
        RemittanceBusiUI.e(RemittanceBusiUI.this);
        if (RemittanceBusiUI.this.getIntent().getIntExtra("pay_channel", 0) == 56)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(19821, new Object[] { Integer.valueOf(5), RemittanceBusiUI.f(RemittanceBusiUI.this), Integer.valueOf(0) });
          RemittanceBusiUI.eOe();
        }
        RemittanceBusiUI.this.finish();
        AppMethodBeat.o(68014);
        return false;
      }
    });
    this.dRM = UUID.randomUUID().toString();
    com.tencent.mm.plugin.wallet.pay.a.b.aUU(this.dRM);
    this.mPayScene = getIntent().getIntExtra("pay_scene", 31);
    this.Ctk = getIntent().getStringExtra("scan_remittance_id");
    this.Ctl = getIntent().getDoubleExtra("fee", 0.0D);
    this.Ctm = getIntent().getStringExtra("receiver_name");
    this.Ctn = getIntent().getStringExtra("receiver_true_name");
    this.Cto = getIntent().getStringExtra("receiver_true_name_busi");
    this.mChannel = getIntent().getIntExtra("pay_channel", 0);
    this.Ctp = getIntent().getStringExtra("desc");
    this.Ctr = getIntent().getIntExtra("busi_type", 0);
    this.CqN = getIntent().getStringExtra("mch_name");
    this.Ctv = getIntent().getStringExtra("mch_type");
    this.Ctx = getIntent().getIntExtra("mch_time", 0);
    this.Cts = getIntent().getStringExtra("mch_info");
    this.Ctw = getIntent().getIntExtra("get_pay_wifi", 0);
    this.Crs = getIntent().getStringExtra("rcvr_open_id");
    this.Ctq = getIntent().getStringExtra("rcvr_ticket");
    this.Cnv = getIntent().getIntExtra("amount_remind_bit", 4);
    this.CtG = getIntent().getStringExtra("receiver_tips");
    this.Csz = ((BusiRemittanceResp)getIntent().getParcelableExtra("BusiRemittanceResp"));
    boolean bool;
    if (this.Csz != null) {
      if ((this.mPayScene == 32) && ((this.Csz.Con == 1) || ((this.Csz != null) && (this.Csz.Col.size() > 0))))
      {
        bool = true;
        this.CtK = bool;
        if (this.Ctl <= 0.0D) {
          break label851;
        }
      }
    }
    label851:
    for (this.Ctu = true;; this.Ctu = false)
    {
      if (this.Ctr == 0)
      {
        Log.w("MicroMsg.RemittanceBusiUI", "wrong busi type!");
        finish();
      }
      com.tencent.mm.plugin.report.service.h.CyF.a(15386, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
      this.CtN = new b(32, 32, 6.0F);
      this.CtO = new b(56, 56, 8.0F);
      initView();
      dmp();
      this.Cqt.alive();
      this.Cui.alive();
      if (!this.Ctu) {
        this.state = 1;
      }
      AppMethodBeat.o(68058);
      return;
      bool = false;
      break;
      Log.w("MicroMsg.RemittanceBusiUI", "busi resp is null, maybe recreate activity!!");
      finish();
      AppMethodBeat.o(68058);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68070);
    super.onDestroy();
    EventCenter.instance.removeListener(this.CrH);
    EventCenter.instance.removeListener(this.Cuh);
    EventCenter.instance.removeListener(this.Cuf);
    this.Cug.dead();
    removeSceneEndListener(1633);
    removeSceneEndListener(1241);
    removeSceneEndListener(2677);
    removeSceneEndListener(2504);
    removeSceneEndListener(2702);
    removeSceneEndListener(2682);
    this.Cqt.dead();
    this.Cui.dead();
    com.tencent.mm.plugin.wallet.pay.a.b.aUV(this.dRM);
    MMHandlerThread.removeRunnable(this.jVx);
    AppMethodBeat.o(68070);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(68061);
    Log.i("MicroMsg.RemittanceBusiUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.jVx, 300L);
    AppMethodBeat.o(68061);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68064);
    if ((this.jVg != null) && (this.jVg.onKeyUp(paramInt, paramKeyEvent)))
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
    Log.v("MicroMsg.RemittanceBusiUI", "onNewIntent");
    AppMethodBeat.o(68082);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68060);
    super.onPause();
    Log.i("MicroMsg.RemittanceBusiUI", "onPause()");
    if ((!this.Ctu) && (!this.jVg.hgQ())) {
      this.state = 3;
    }
    AppMethodBeat.o(68060);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68059);
    super.onResume();
    Log.i("MicroMsg.RemittanceBusiUI", "onResume()");
    e.eNU().gS(this);
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      showNormalStWcKb();
    }
    if (!this.Ctu) {
      this.state = 2;
    }
    AppMethodBeat.o(68059);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, final q paramq)
  {
    AppMethodBeat.i(68071);
    Object localObject1;
    boolean bool;
    label306:
    label351:
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((paramq instanceof i))
    {
      paramString = (i)paramq;
      if (!this.mKindaEnable)
      {
        localObject1 = e.eNU();
        Log.w("MicroMsg.RemittanceBusiDialogMgr", "hideProgress()");
        localObject1 = (Context)((e)localObject1).cMO.get();
        if (localObject1 == null) {
          Log.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
        }
      }
      else
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label1594;
        }
        if (paramString.CoB.pTZ != 0) {
          break label1399;
        }
        this.CtX = paramString;
        this.Csq = paramString.CoB.KHM;
        this.AJn = paramString.CoB.KHN;
        this.Csv = paramString.CoB.KHO;
        this.CtI = paramString.CoB.KYw;
        this.CtJ = paramString.CoB.KYv;
        this.Cty = paramString.CoB.KYB;
        this.Ctz = paramString.CoB.KYA;
        this.CtB = paramString.CoB.KYE;
        this.CtC = paramString.CoB.KYC;
        this.CtD = paramString.CoB.KYD;
        this.CtF = i.a(paramString.CoB.KYJ).toString();
        Log.i("MicroMsg.RemittanceBusiUI", "touch_challenge: %s need_change_auth_key: %s mBusiF2FFaultConfig: %s", new Object[] { paramString.CoB.KYF, Integer.valueOf(paramString.CoB.KYG), this.CtF });
        if (paramString.CoB.KYF != null) {
          com.tencent.mm.plugin.fingerprint.b.p.wFK.wFE = paramString.CoB.KYF.yO();
        }
        paramq = com.tencent.mm.plugin.fingerprint.b.p.wFK;
        if (paramString.CoB.KYG != 1) {
          break label574;
        }
        bool = true;
        paramq.wFM = bool;
        if (a(paramString)) {
          break label1392;
        }
        Log.i("MicroMsg.RemittanceBusiUI", "showNameVerifyDialog");
        if (paramString.CoB.KYM != null) {
          break label580;
        }
        Log.e("MicroMsg.RemittanceBusiUI", "orderScene.response.check_recv_name_win is null");
        paramInt1 = 0;
        if (paramInt1 == 0)
        {
          if (paramString.CoB.KYK == null) {
            break label1234;
          }
          Log.i("MicroMsg.RemittanceBusiUI", "showMoneyRemind amount_remind_win");
          eOb();
          if ((e.eNU().getContext() != null) && ((e.eNU().getContext() instanceof RemittanceBusiUI))) {
            this.CtT = paramString.CoB.KYK.KHX;
          }
          paramq = e.eNU();
          localObject2 = paramString.CoB.KYK;
          paramInt1 = this.Cnv;
          localObject3 = new a(paramString) {};
          localObject4 = new a(paramString) {};
          Log.w("MicroMsg.RemittanceBusiDialogMgr", "showAmountRemindWin() amountRemindBit:%s", new Object[] { Integer.valueOf(paramInt1) });
          paramq = (Context)paramq.cMO.get();
          if (paramq != null) {
            break label893;
          }
          Log.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
          label501:
          if (e.eNU().getContext() != null)
          {
            if (!(e.eNU().getContext() instanceof RemittanceBusiUI)) {
              break label1212;
            }
            a(1, paramString);
          }
          label528:
          paramInt1 = 1;
          label530:
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
      label574:
      bool = false;
      break label306;
      label580:
      showCircleStWcKb();
      eOb();
      localObject2 = paramString.CoB.KYM.title;
      Object localObject6 = paramString.CoB.KYM.dQx;
      Object localObject7 = paramString.CoB.KYM.Lkz;
      localObject3 = paramString.CoB.KYM.IoL.dQx;
      localObject4 = paramString.CoB.KYM.IoM.dQx;
      paramq = new c(this);
      paramq.CqB = new c.a()
      {
        public final void aMb(final String paramAnonymousString)
        {
          AppMethodBeat.i(174427);
          Log.i("MicroMsg.RemittanceBusiUI", "showNameVerifyDialog onINputName() name:%s", new Object[] { paramAnonymousString });
          RemittanceBusiUI.this.hideVKB();
          com.tencent.mm.plugin.report.service.h.CyF.a(19229, new Object[] { Integer.valueOf(0), Integer.valueOf(paramString.CoB.KYM.LkA), Integer.valueOf(0), RemittanceBusiUI.Y(RemittanceBusiUI.this) });
          com.tencent.mm.wallet_core.c.l.a(RemittanceBusiUI.this, paramString.CoB.KYM.IoM, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dP(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(174422);
              Log.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog right button click jumpItem.action:continue");
              RemittanceBusiUI.a(RemittanceBusiUI.this, paramAnonymousString, RemittanceBusiUI.35.this.Cun.CoB.KYM.KYs);
              AppMethodBeat.o(174422);
            }
            
            public final void eNp()
            {
              AppMethodBeat.i(174423);
              Log.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog right button click jumpItem.action:close");
              AppMethodBeat.o(174423);
            }
            
            public final void eNw()
            {
              AppMethodBeat.i(174421);
              Log.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog right button click jumpItem.action:exit");
              RemittanceBusiUI.Z(RemittanceBusiUI.this);
              AppMethodBeat.o(174421);
            }
          });
          AppMethodBeat.o(174427);
        }
        
        public final void onCancel()
        {
          AppMethodBeat.i(174428);
          Log.i("MicroMsg.RemittanceBusiUI", "showNameVerifyDialog onCancel()");
          RemittanceBusiUI.this.hideVKB();
          com.tencent.mm.plugin.report.service.h.CyF.a(19229, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.CoB.KYM.LkA), Integer.valueOf(0), RemittanceBusiUI.Y(RemittanceBusiUI.this) });
          com.tencent.mm.wallet_core.c.l.a(RemittanceBusiUI.this, paramString.CoB.KYM.IoL, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dP(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(174425);
              Log.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog left button click jumpItem.action：continue");
              AppMethodBeat.o(174425);
            }
            
            public final void eNp()
            {
              AppMethodBeat.i(174426);
              Log.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog left button click jumpItem.action：close");
              AppMethodBeat.o(174426);
            }
            
            public final void eNw()
            {
              AppMethodBeat.i(174424);
              Log.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog left button click jumpItem.action:exit");
              RemittanceBusiUI.Z(RemittanceBusiUI.this);
              AppMethodBeat.o(174424);
            }
          });
          AppMethodBeat.o(174428);
        }
      };
      Object localObject5 = View.inflate(paramq.mContext, 2131496041, null);
      Object localObject8 = (TextView)((View)localObject5).findViewById(2131303013);
      localObject1 = (EditText)((View)localObject5).findViewById(2131301551);
      ((MMNeat7extView)((View)localObject5).findViewById(2131299180)).aw((CharSequence)localObject6);
      ((TextView)localObject8).setText((CharSequence)localObject7);
      localObject6 = new d.a(paramq.mContext);
      ((d.a)localObject6).bon((String)localObject2).hs((View)localObject5);
      com.tencent.mm.ui.tools.b.c.f((EditText)localObject1).a(f.a.Quh).lv(1, 1).CN(false).a(null);
      MMHandlerThread.postToMainThreadDelayed(new c.10(paramq, (EditText)localObject1), 200L);
      ((d.a)localObject6).bou((String)localObject4).aoX(-2141754475).a(false, new c.11(paramq, (EditText)localObject1));
      ((d.a)localObject6).bov((String)localObject3).d(new c.2(paramq));
      localObject2 = ((d.a)localObject6).hbn();
      ((com.tencent.mm.ui.widget.a.d)localObject2).show();
      ((EditText)localObject1).addTextChangedListener(new c.3(paramq, (EditText)localObject1, (com.tencent.mm.ui.widget.a.d)localObject2));
      paramInt1 = 1;
      break label351;
      label893:
      if (localObject2 == null)
      {
        Log.i("MicroMsg.JumpItemUtil", "showAmountRemindWin() amountRemindWin == null");
        break label501;
      }
      localObject1 = LayoutInflater.from(paramq).inflate(2131495153, null, false);
      localObject5 = ((View)localObject1).findViewById(2131300289);
      localObject6 = (WalletTextView)((View)localObject1).findViewById(2131300288);
      localObject7 = ((View)localObject1).findViewById(2131310214);
      localObject8 = ((View)localObject1).findViewById(2131310212);
      double d = ((ea)localObject2).KHX / 100.0D;
      ((WalletTextView)localObject6).setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(d));
      if (Util.isEqual(paramInt1, 0))
      {
        Log.i("MicroMsg.JumpItemUtil", "mAmountRemindBit == 0");
        ((View)localObject8).setVisibility(8);
      }
      for (;;)
      {
        localObject5 = ((ea)localObject2).dQx;
        localObject6 = ((ea)localObject2).IoM.dQx;
        localObject7 = ((ea)localObject2).IoL.dQx;
        localObject4 = new l.8(paramq, (ea)localObject2, d, (l.a)localObject4);
        localObject2 = new l.9(paramq, (ea)localObject2, d, (l.a)localObject3);
        localObject3 = new d.a(paramq);
        ((d.a)localObject3).bon((String)localObject5);
        ((d.a)localObject3).hs((View)localObject1);
        ((d.a)localObject3).bou((String)localObject6).c((DialogInterface.OnClickListener)localObject4);
        ((d.a)localObject3).bov((String)localObject7).d((DialogInterface.OnClickListener)localObject2);
        ((d.a)localObject3).Dk(false);
        ((d.a)localObject3).Dl(true);
        localObject1 = ((d.a)localObject3).hbn();
        ((com.tencent.mm.ui.widget.a.d)localObject1).show();
        com.tencent.mm.ui.base.h.a(paramq, (Dialog)localObject1);
        break;
        TextView localTextView = (TextView)((View)localObject1).findViewById(2131310217);
        ((View)localObject8).setVisibility(0);
        ((View)localObject8).post(new l.7((View)localObject7, d, paramInt1, (WalletTextView)localObject6, (View)localObject5, (View)localObject8, localTextView));
      }
      label1212:
      if (!(e.eNU().getContext() instanceof RemittanceF2fLargeMoneyUI)) {
        break label528;
      }
      a(9, paramString);
      break label528;
      label1234:
      if (paramString.CoB.KYL != null)
      {
        Log.i("MicroMsg.RemittanceBusiUI", "showMoneyRemind amount_remind_page");
        eOb();
        paramq = new Intent();
        paramq.putExtra("key_amount_remind_bit", this.Cnv);
        paramq.putExtra("key_title", paramString.CoB.KYL.title);
        paramq.putExtra("key_desc", paramString.CoB.KYL.dQx);
        paramq.putExtra("key_amount_remind_sign", paramString.CoB.KYL.KHW);
        com.tencent.mm.br.c.b(this, "wallet_payu", ".pay.ui.WalletPayUOrderInfoUI", paramq, 4);
        a(6, paramString);
        break label528;
      }
      if ((e.eNU().getContext() != null) && ((e.eNU().getContext() instanceof RemittanceF2fLargeMoneyUI))) {
        a(8, paramString);
      }
      paramInt1 = 0;
      break label530;
      label1392:
      eOb();
      continue;
      label1399:
      eOb();
      Log.e("MicroMsg.RemittanceBusiUI", "place order response: %s, %s", new Object[] { Integer.valueOf(paramString.CoB.pTZ), paramString.CoB.pUa });
      if ((paramString.CoB.KYu != null) && (!Util.isNullOrNil(paramString.CoB.KYu.lHA))) {
        a(paramString);
      }
      for (;;)
      {
        if (paramString.CoB.KYx != 1) {
          break label1592;
        }
        a(null, null, 0);
        break;
        localObject2 = e.eNU();
        localObject1 = paramString.CoB.pUa;
        paramq = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68029);
            if (Util.isEqual(((i)paramq).CoB.KYI, 1))
            {
              if (e.eNU().eNV()) {
                Log.w("MicroMsg.RemittanceBusiUI", "finish finishRemitF2fDCodeAndLMRemindUI");
              }
              RemittanceBusiUI.this.finish();
            }
            AppMethodBeat.o(68029);
          }
        };
        Log.w("MicroMsg.RemittanceBusiDialogMgr", "showAlert3() msg:%s, title:%s", new Object[] { Util.nullAsNil((String)localObject1), Util.nullAsNil("") });
        localObject2 = (Context)((e)localObject2).cMO.get();
        if (localObject2 == null) {
          Log.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
        } else {
          com.tencent.mm.ui.base.h.d((Context)localObject2, (String)localObject1, "", paramq);
        }
      }
      label1592:
      continue;
      label1594:
      Log.e("MicroMsg.RemittanceBusiUI", "net error: %s", new Object[] { paramq });
      continue;
      if ((paramq instanceof com.tencent.mm.plugin.remittance.model.h))
      {
        Log.i("MicroMsg.RemittanceBusiUI", "pay check callback");
        AppMethodBeat.o(68071);
        return true;
      }
      if ((paramq instanceof com.tencent.mm.plugin.remittance.model.g))
      {
        Log.i("MicroMsg.RemittanceBusiUI", "onSceneEnd %s errType %s errCode %s", new Object[] { paramq, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        paramString = (com.tencent.mm.plugin.remittance.model.g)paramq;
        if ((!paramString.Coz.equals(this.CtM.Coz)) || (paramString.cancel))
        {
          paramString.Coy = true;
          Log.e("MicroMsg.RemittanceBusiUI", "ignore this getFavor new coming soon %s", new Object[] { Boolean.valueOf(paramString.cancel) });
          AppMethodBeat.o(68071);
          return true;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramString.Cov.pTZ == 0)
          {
            this.CtH.Cqy = paramString.Cov.Com;
            this.CtH.aMi(paramString.Cov.Com.KXZ);
            eOa();
            paramq = paramString.Cow;
            Log.i("MicroMsg.RemittanceBusiUI", "GetFavorAfterAction %s", new Object[] { paramq });
            if (paramq != null) {
              paramq.gt(this.CtH.eND());
            }
          }
        }
        for (;;)
        {
          paramString.Coy = true;
          AppMethodBeat.o(68071);
          return true;
          this.CtH.eNC();
          this.Cta.setTextColor(getContext().getResources().getColor(2131100245));
          this.Cta.setText(paramString.Cov.pUa);
          paramq = paramString.Cox;
          if (paramq != null)
          {
            paramq.a(paramInt1, paramInt2, paramString);
            continue;
            this.CtH.eNC();
            if ((this.Csz != null) && (!Util.isNullOrNil(this.Csz.Coh))) {
              this.Cta.setText(this.Csz.Coh);
            }
            this.Cta.setTextColor(getContext().getResources().getColor(2131100245));
            this.Cta.setText(getString(2131764493));
            paramq = paramString.Cox;
            if (paramq != null) {
              paramq.a(paramInt1, paramInt2, paramString);
            }
          }
        }
      }
      if ((paramq instanceof com.tencent.mm.plugin.remittance.model.l))
      {
        paramString = (com.tencent.mm.plugin.remittance.model.l)paramq;
        Log.i("MicroMsg.RemittanceBusiUI", "NetSceneBusiF2fZeroCallback getHasRetried %s", new Object[] { Boolean.valueOf(paramString.hasRetried) });
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (paramString.CoG.pTZ == 0)
          {
            eOd();
          }
          else
          {
            eOc();
            e.eNU().a(paramString.CoG.pUa, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
          }
        }
        else {
          e.eNU().a(getString(2131768354), new DialogInterface.OnClickListener()
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
    
    public void eNp() {}
    
    public final int eNq()
    {
      return 1072;
    }
    
    public void eNs() {}
    
    public final void eNw()
    {
      Object localObject = new Intent();
      ((Intent)localObject).setComponent(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.ui.LauncherUI"));
      ((Intent)localObject).addFlags(67108864);
      RemittanceBusiUI localRemittanceBusiUI = RemittanceBusiUI.this;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localRemittanceBusiUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$IRemitBusiJumpItemCallback", "onExit", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localRemittanceBusiUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localRemittanceBusiUI, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$IRemitBusiJumpItemCallback", "onExit", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  final class b
  {
    private float Cut;
    private float Cuu;
    private TenpaySecureEditText Cuv;
    private TextView Cuw;
    private RelativeLayout Cux;
    private float marginTop;
    private View sc;
    
    b(int paramInt1, int paramInt2, float paramFloat)
    {
      AppMethodBeat.i(68053);
      this.Cut = paramInt1;
      this.Cuu = paramInt2;
      this.marginTop = paramFloat;
      AppMethodBeat.o(68053);
    }
    
    final void update()
    {
      AppMethodBeat.i(68054);
      RemittanceBusiUI.a(RemittanceBusiUI.this).setTextSize(1, this.Cuu);
      RemittanceBusiUI.b(RemittanceBusiUI.this).setTextSize(1, this.Cut);
      if (this.Cuw == null) {
        this.Cuw = ((TextView)RemittanceBusiUI.c(RemittanceBusiUI.this).findViewById(2131310298));
      }
      if (this.Cuw != null) {
        this.Cuw.setTextSize(this.Cut);
      }
      if (this.Cuv == null) {
        this.Cuv = ((TenpaySecureEditText)RemittanceBusiUI.c(RemittanceBusiUI.this).findViewById(2131310180));
      }
      if (this.Cuv != null) {
        this.Cuv.setTextSize(this.Cuu);
      }
      if (this.sc == null) {
        this.sc = this.Cuv.findViewById(2131304846);
      }
      if (this.sc != null) {
        this.sc.setMinimumHeight(BackwardSupportUtil.BitmapFactory.fromDPToPix(RemittanceBusiUI.this, RemittanceBusiUI.d(RemittanceBusiUI.this).Cuu));
      }
      if (this.Cux == null) {
        this.Cux = ((RelativeLayout)RemittanceBusiUI.this.findViewById(2131310215));
      }
      if (this.Cux != null) {
        ((LinearLayout.LayoutParams)this.Cux.getLayoutParams()).topMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(RemittanceBusiUI.this, this.marginTop);
      }
      AppMethodBeat.o(68054);
    }
  }
  
  final class c
    implements Runnable
  {
    public com.tencent.mm.wallet_core.d.d Cuy;
    
    c() {}
    
    public final void run()
    {
      AppMethodBeat.i(68055);
      RemittanceBusiUI.Q(RemittanceBusiUI.this).b(this.Cuy);
      AppMethodBeat.o(68055);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI
 * JD-Core Version:    0.7.0.1
 */