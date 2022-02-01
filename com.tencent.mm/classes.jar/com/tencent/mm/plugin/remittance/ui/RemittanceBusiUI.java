package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.app.Dialog;
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
import com.tencent.mm.g.a.ap;
import com.tencent.mm.g.a.gc;
import com.tencent.mm.g.a.gd;
import com.tencent.mm.g.a.gd.a;
import com.tencent.mm.g.a.ge;
import com.tencent.mm.g.a.py;
import com.tencent.mm.g.a.xr;
import com.tencent.mm.g.b.a.el;
import com.tencent.mm.g.b.a.v;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.protocal.protobuf.cth;
import com.tencent.mm.protocal.protobuf.dcl;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.protocal.protobuf.dm;
import com.tencent.mm.protocal.protobuf.dn;
import com.tencent.mm.protocal.protobuf.on;
import com.tencent.mm.protocal.protobuf.op;
import com.tencent.mm.protocal.protobuf.ot;
import com.tencent.mm.protocal.protobuf.oz;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.ai;
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
  private double dcH;
  private String dpw;
  private int dvA;
  private int mChannel;
  private int mPayScene;
  private int mRequestCode;
  private int state;
  private ScrollView swv;
  private String ujI;
  private com.tencent.mm.sdk.b.c<ap> vBY;
  private LinearLayout vCI;
  private String vCX;
  private String vCs;
  private String vDV;
  private String vDW;
  private boolean vDc;
  private el vDe;
  private boolean vDh;
  private boolean vDk;
  private com.tencent.mm.sdk.b.c vDm;
  private TextView vEA;
  private TextView vEB;
  private TextView vEC;
  private TextView vED;
  private TextView vEE;
  private TextView vEF;
  private View vEG;
  private CdnImageView vEH;
  private LinearLayout vEI;
  private LinearLayout vEJ;
  private TextView vEK;
  private View vEL;
  private TextView vEM;
  private Button vEN;
  private RelativeLayout vEO;
  private String vEP;
  private double vEQ;
  private String vER;
  private String vES;
  private String vET;
  private String vEU;
  private String vEV;
  private int vEW;
  private String vEX;
  private float vEY;
  private boolean vEZ;
  private String vEa;
  private BusiRemittanceResp vEe;
  private TextView vEz;
  private int vFA;
  private int vFB;
  private i vFC;
  private Runnable vFD;
  private com.tencent.mm.wallet_core.d.c<com.tencent.mm.plugin.remittance.model.l> vFE;
  private c vFF;
  private boolean vFG;
  private double vFH;
  private String vFI;
  private String vFJ;
  private com.tencent.mm.sdk.b.c vFK;
  private com.tencent.mm.sdk.b.c vFL;
  private com.tencent.mm.sdk.b.c vFM;
  private com.tencent.mm.sdk.b.c vFN;
  private String vFa;
  private int vFb;
  private int vFc;
  private String vFd;
  private dcl vFe;
  private String vFf;
  private int vFg;
  private int vFh;
  private int vFi;
  private int vFj;
  private String vFk;
  private String vFl;
  private b vFm;
  private String vFn;
  private String vFo;
  boolean vFp;
  private boolean vFq;
  com.tencent.mm.plugin.remittance.model.g vFr;
  private b vFs;
  private b vFt;
  protected boolean vFu;
  private Map<String, dh> vFv;
  private RemittanceF2fDynamicCodeUI vFw;
  private boolean vFx;
  private int vFy;
  private boolean vFz;
  private int vyQ;
  private int vyX;
  private WcPayKeyboard vyZ;
  private WalletFormView vzg;
  private RelativeLayout vzh;
  private TextView vzi;
  private RelativeLayout vzj;
  private Runnable vzw;
  
  public RemittanceBusiUI()
  {
    AppMethodBeat.i(68056);
    this.vEY = 0.0F;
    this.vyQ = 4;
    this.vFg = 0;
    this.vFh = 0;
    this.vFi = 0;
    this.vFj = 0;
    this.vFm = new b();
    this.vFn = "";
    this.vFo = "";
    this.vFp = false;
    this.dcH = -1.0D;
    this.vFq = false;
    this.vFr = null;
    this.vDc = false;
    this.vFu = false;
    this.mRequestCode = 0;
    this.vFv = new HashMap();
    this.vFw = null;
    this.vFx = false;
    this.vFz = false;
    this.state = 0;
    this.vzw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68025);
        if ((RemittanceBusiUI.f(RemittanceBusiUI.this) == 2) && (RemittanceBusiUI.this.isHandleAutoShowNormalStWcKb())) {
          RemittanceBusiUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(68025);
      }
    };
    this.vFD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68028);
        RemittanceBusiUI.L(RemittanceBusiUI.this);
        AppMethodBeat.o(68028);
      }
    };
    this.vFE = new com.tencent.mm.wallet_core.d.c()
    {
      public final void a(com.tencent.mm.wallet_core.d.d paramAnonymousd)
      {
        AppMethodBeat.i(163820);
        if ((paramAnonymousd instanceof com.tencent.mm.plugin.remittance.model.l)) {
          RemittanceBusiUI.b(RemittanceBusiUI.this, ((com.tencent.mm.plugin.remittance.model.l)paramAnonymousd).dcE);
        }
        AppMethodBeat.o(163820);
      }
    };
    this.vFF = new c();
    this.vBY = new RemittanceBusiUI.22(this);
    this.vFG = true;
    this.dvA = 0;
    this.vFH = 0.0D;
    this.vFJ = "";
    this.vDm = new com.tencent.mm.sdk.b.c() {};
    this.vFK = new com.tencent.mm.sdk.b.c() {};
    this.vFL = new com.tencent.mm.sdk.b.c() {};
    this.vFM = new com.tencent.mm.sdk.b.c() {};
    this.vFN = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(68056);
  }
  
  private void a(int paramInt, on paramon, boolean paramBoolean, gd paramgd, String paramString1, String paramString2)
  {
    AppMethodBeat.i(68077);
    a(paramInt, paramon, paramBoolean, paramgd, paramString1, paramString2, "");
    AppMethodBeat.o(68077);
  }
  
  private void a(int paramInt, on paramon, boolean paramBoolean, gd paramgd, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(163834);
    int i = 0;
    int j = 0;
    if (!this.vFG)
    {
      boolean bool1 = bt.I(Double.valueOf(this.vFH), Double.valueOf(this.vEQ));
      boolean bool2 = bt.kU(this.vFI, this.vDW);
      if (!bool1) {
        j = 1;
      }
      i = j;
      if (!bool2) {
        i = j | 0x2;
      }
    }
    String str1 = this.vCX;
    String str2 = this.vEP;
    j = this.mPayScene;
    String str3 = this.vEU;
    String str4 = this.vDW;
    int k = this.mChannel;
    String str5 = this.vEV;
    String str6 = this.vFa;
    int m = this.vFc;
    int n = this.vFb;
    String str7 = this.vER;
    ahe localahe = this.vFm.vCc;
    if (paramon == null)
    {
      paramon = "";
      paramString1 = new i(str1, str2, j, str3, str4, paramInt, k, str5, str6, m, n, str7, localahe, paramon, this.vEe.vzO, paramString1, this.vCs, paramString2, this.vES, this.vFJ, this.dvA, i, paramString3);
      if (paramBoolean) {
        paramString1.a(paramgd);
      }
      if ((!this.mKindaEnable) || (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_QRCODE_RECEIVE_PAY_SWTICH_KEY"))) {
        break label383;
      }
      if (this.vFw == null) {
        break label376;
      }
      this.vFw.showSafeProgress();
    }
    label275:
    label279:
    label411:
    label424:
    for (;;)
    {
      paramBoolean = false;
      paramon = this;
      paramon.doSceneProgress(paramString1, paramBoolean);
      if (this.vFx)
      {
        if (paramInt == this.vFy) {
          a(5, this.vFC);
        }
      }
      else {
        label310:
        if ((e.dki().getContext() != null) && ((e.dki().getContext() instanceof RemittanceBusiUI))) {
          if (this.vFz)
          {
            if (paramInt != this.vFB) {
              break label411;
            }
            a(13, this.vFC);
          }
        }
      }
      for (;;)
      {
        this.vFB = paramInt;
        AppMethodBeat.o(163834);
        return;
        paramon = paramon.CMj;
        break;
        label376:
        showLoading();
        break label275;
        label383:
        if (e.dki().dkl()) {
          break label424;
        }
        paramBoolean = true;
        paramon = this;
        break label279;
        a(4, this.vFC);
        break label310;
        a(12, this.vFC);
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
    if (this.vFp)
    {
      this.vEM.setText(com.tencent.mm.wallet_core.ui.e.D(dkn()));
      aq.az(this.vFD);
      this.vEQ = dkn();
      long l = Math.round(this.vEQ * 100.0D);
      if (l <= 0L)
      {
        this.vFm.djQ();
        this.vEF.setTextColor(getContext().getResources().getColor(2131100212));
        this.vEF.setText(this.vEe.vzN);
        if (this.vFr != null) {
          this.vFr.cancel = true;
        }
        AppMethodBeat.o(68069);
        return;
      }
      j = (int)l;
      k = this.mChannel;
      m = this.vEe.vzO;
      str1 = this.vEU;
      str2 = this.vCs;
      str3 = this.vEe.vzP;
      str4 = this.vCX;
      str5 = this.vER;
      str6 = this.vEe.vzQ;
      if (paramc != null) {
        break label243;
      }
    }
    label243:
    for (int i = 0;; i = 1)
    {
      this.vFr = new com.tencent.mm.plugin.remittance.model.g(j, k, m, str1, str2, str3, str4, str5, str6, i, paramc, paramd);
      aq.n(this.vFD, paramInt);
      AppMethodBeat.o(68069);
      return;
    }
  }
  
  private void a(ot paramot)
  {
    AppMethodBeat.i(68085);
    ad.i("MicroMsg.RemittanceBusiUI", "resp.payer_need_auth_flag %s", new Object[] { Integer.valueOf(paramot.CMI) });
    if (paramot.CMI == 1)
    {
      paramot = new Bundle();
      com.tencent.mm.sdk.b.a.ESL.c(this.vFM);
      paramot.putString("realname_verify_process_jump_activity", ".ui.RemittanceBusiUI");
      paramot.putString("realname_verify_process_jump_plugin", "remittance");
      paramot.putInt("real_name_verify_mode", 0);
      paramot.putInt("entry_scene", this.mPayScene);
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramot);
      AppMethodBeat.o(68085);
      return;
    }
    Intent localIntent = new Intent();
    Object localObject;
    if (!bt.isNullOrNil(this.vFl)) {
      localObject = this.vFl;
    }
    for (;;)
    {
      localIntent.putExtra("INTENT_TITLE", (String)localObject);
      localIntent.putExtra("INTENT_CAN_TOUCH", this.vFg);
      localIntent.putExtra("INTENT_PAYFEE", com.tencent.mm.wallet_core.ui.e.D(0.0D));
      localIntent.putExtra("INTENT_REQKEY", paramot.dlJ);
      paramot = paramot.CMJ;
      try
      {
        localIntent.putExtra("INTENT_TOKENMESS", paramot.toByteArray());
        com.tencent.mm.bs.d.b(getContext(), "wallet", "com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI", localIntent, 2);
        AppMethodBeat.o(68085);
        return;
      }
      catch (Exception paramot)
      {
        String str;
        StringBuilder localStringBuilder;
        ad.printErrStackTrace("MicroMsg.RemittanceBusiUI", paramot, "", new Object[0]);
        AppMethodBeat.o(68085);
      }
      str = getString(2131765746);
      if (!bt.isNullOrNil(this.vER))
      {
        com.tencent.mm.kernel.g.afC();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHW(this.vER);
        if (localObject != null)
        {
          localObject = ((af)localObject).ZX();
          localStringBuilder = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.aNm((String)localObject));
          if (bt.isNullOrNil(this.vES)) {}
          for (localObject = "";; localObject = "(" + this.vES + ")")
          {
            localObject = bt.u(str, new Object[] { (String)localObject });
            break;
          }
        }
        ad.e("MicroMsg.RemittanceBusiUI", "can not found contact for user::" + this.vER);
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
      if (bt.isNullOrNil(this.ujI)) {
        this.ujI = str1;
      }
      if (d >= 0.0D) {
        this.dcH = d;
      }
      if (this.vDc) {
        com.tencent.mm.plugin.report.service.h.vKh.f(15386, new Object[] { Integer.valueOf(3), Integer.valueOf(2) });
      }
      dkr();
      amp(str2);
    }
    for (;;)
    {
      c(paramBoolean, paramIntent);
      AppMethodBeat.o(68073);
      return;
      if (ag.bq(paramIntent))
      {
        finish();
        AppMethodBeat.o(68073);
        return;
      }
      if (ag.br(paramIntent))
      {
        AppMethodBeat.o(68073);
        return;
      }
      ad.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor");
      dkq();
    }
  }
  
  private boolean a(i parami)
  {
    AppMethodBeat.i(68079);
    boolean bool1 = false;
    if (!this.vDh) {
      bool1 = b(parami);
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = c(parami);
    }
    AppMethodBeat.o(68079);
    return bool2;
  }
  
  private void amp(String paramString)
  {
    AppMethodBeat.i(68086);
    ad.i("MicroMsg.RemittanceBusiUI", "do pay check: %s", new Object[] { paramString });
    paramString = (dh)this.vFv.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(68086);
      return;
    }
    if (!bt.isNullOrNil(this.ujI)) {
      paramString.CxX = this.ujI;
    }
    doSceneProgress(new com.tencent.mm.plugin.remittance.model.h(paramString, this.vFn), false);
    AppMethodBeat.o(68086);
  }
  
  private boolean b(final i parami)
  {
    AppMethodBeat.i(68080);
    if (!bt.isNullOrNil(parami.vAh.CMC))
    {
      this.vDh = true;
      bA(1, parami.vAh.CxW);
      e.dki().a(parami.vAh.CMC, getString(2131755873), getString(2131762423), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68036);
          RemittanceBusiUI.a(RemittanceBusiUI.this, 3, parami.vAh.CxW);
          if (!RemittanceBusiUI.b(RemittanceBusiUI.this, parami))
          {
            if ((RemittanceBusiUI.S(RemittanceBusiUI.this)) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_QRCODE_RECEIVE_PAY_SWTICH_KEY")))
            {
              if (RemittanceBusiUI.O(RemittanceBusiUI.this) == null) {
                break label102;
              }
              RemittanceBusiUI.O(RemittanceBusiUI.this).showSafeProgress();
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
          RemittanceBusiUI.T(RemittanceBusiUI.this);
          AppMethodBeat.o(68036);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(163824);
          RemittanceBusiUI.T(RemittanceBusiUI.this);
          RemittanceBusiUI.a(RemittanceBusiUI.this, 2, parami.vAh.CxW);
          AppMethodBeat.o(163824);
        }
      });
      AppMethodBeat.o(68080);
      return true;
    }
    AppMethodBeat.o(68080);
    return false;
  }
  
  private void bA(int paramInt, String paramString)
  {
    AppMethodBeat.i(68081);
    this.vDe = new el();
    this.vDe.dKe = 1L;
    this.vDe.dFd = paramInt;
    this.vDe.kJ(paramString);
    this.vDe.aBj();
    AppMethodBeat.o(68081);
  }
  
  private void c(boolean paramBoolean, Intent paramIntent)
  {
    AppMethodBeat.i(68074);
    this.vFG = false;
    if (paramBoolean)
    {
      ad.i("MicroMsg.RemittanceBusiUI", "savePayInfo isOk = true");
      this.dvA = 1;
    }
    for (;;)
    {
      ad.i("MicroMsg.RemittanceBusiUI", "savePayInfo() mLastPayResult:%s mLastTotalAmt:%s mLastPayerDesc:%s mLastF2fId:%s", new Object[] { Double.valueOf(this.vFH), Double.valueOf(this.vFH), this.vFI, this.vFJ });
      AppMethodBeat.o(68074);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(68074);
        return;
      }
      this.dvA = paramIntent.getIntExtra("key_pay_reslut_type", 3);
      this.vFH = this.vEQ;
      this.vFI = this.vDW;
      this.vFJ = this.vDV;
    }
  }
  
  private boolean c(final i parami)
  {
    AppMethodBeat.i(68083);
    if (parami.vAh.CMD != null)
    {
      this.vDk = true;
      e.dki().a(parami.vAh.nty, "", parami.vAh.CMD.tfI, parami.vAh.CMD.tfH, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(163825);
          ad.i("MicroMsg.RemittanceBusiUI", "goto h5: %s", new Object[] { parami.vAh.CMD.nTQ });
          com.tencent.mm.wallet_core.ui.e.p(RemittanceBusiUI.this.getContext(), parami.vAh.CMD.nTQ, false);
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
    ad.i("MicroMsg.RemittanceBusiUI", "do start pay zero_pay_flag: %s", new Object[] { Integer.valueOf(parami.vAh.CMH) });
    if (e.dki().dkk()) {
      ad.w("MicroMsg.RemittanceBusiUI", "finish finishRemitLMRemindUI");
    }
    Object localObject1 = new dh();
    ((dh)localObject1).channel = this.mChannel;
    ((dh)localObject1).CxW = this.vDV;
    ((dh)localObject1).CxX = this.ujI;
    ((dh)localObject1).vzO = this.vEe.vzO;
    ((dh)localObject1).scene = this.mPayScene;
    ((dh)localObject1).CxY = this.vEa;
    ((dh)localObject1).CxZ = this.vFm.vCc;
    ((dh)localObject1).iaw = this.vER;
    ((dh)localObject1).vBp = this.vCX;
    ((dh)localObject1).Cya = parami.uxV;
    this.vFv.put(parami.vAh.dlJ, localObject1);
    if (parami.vAh.CMH == 1)
    {
      a(parami.vAh);
      AppMethodBeat.o(68084);
      return;
    }
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.dcE = parami.vAh.dlJ;
    localPayInfo.dtb = this.mPayScene;
    if (this.mChannel > 0) {
      localPayInfo.channel = this.mChannel;
    }
    if (parami.vAh.CMO != null) {
      localPayInfo.rcj = parami.vAh.CMO.eBA();
    }
    localPayInfo.ApW = parami.vAh.CMN;
    Object localObject2;
    if (parami.vAh.CMP == 1)
    {
      bool = true;
      localPayInfo.Afv = bool;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("extinfo_key_1", this.vER);
      ((Bundle)localObject1).putString("extinfo_key_2", this.vES);
      ((Bundle)localObject1).putString("extinfo_key_3", this.vEU);
      ((Bundle)localObject1).putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
      ((Bundle)localObject1).putString("extinfo_key_7", this.vDW);
      ((Bundle)localObject1).putString("extinfo_key_19", parami.vAh.vAZ);
      localPayInfo.Cos = ((Bundle)localObject1);
      localPayInfo.vBl = 1;
      localObject2 = new Intent();
      if (parami.vAh.vAW != 1) {
        break label738;
      }
      ((Bundle)localObject1).putInt("extinfo_key_15", parami.vAh.CMQ);
      ((Bundle)localObject1).putString("extinfo_key_17", parami.vAh.vAX);
      ((Bundle)localObject1).putString("extinfo_key_18", parami.vAh.vAY);
      ((Intent)localObject2).putExtra("key_pay_info", localPayInfo);
      ((Intent)localObject2).putExtra("from_patch_ui", true);
      ((Intent)localObject2).putExtra("key_rcvr_open_id", this.vCX);
      ((Intent)localObject2).putExtra("key_mch_info", this.vEX);
      ((Intent)localObject2).putExtra("key_mch_photo", this.vEe.vzM);
      ((Intent)localObject2).putExtra("key_transfer_qrcode_id", this.vEP);
      ((Intent)localObject2).putExtra("get_dynamic_code_sign", parami.vAh.vAX);
      ((Intent)localObject2).putExtra("get_dynamic_code_extend", parami.vAh.vAY);
      ((Intent)localObject2).putExtra("dynamic_code_spam_wording", parami.vAh.vBa);
      ((Intent)localObject2).putExtra("dynamic_code_amount", parami.vAh.CMQ);
      ((Intent)localObject2).putExtra("show_paying_wording", parami.vAh.vAZ);
      if (this.vEe.vzU != 1) {
        break label733;
      }
    }
    label733:
    for (boolean bool = true;; bool = false)
    {
      ((Intent)localObject2).putExtra("show_avatar_type", bool);
      com.tencent.mm.plugin.report.service.h.vKh.f(15386, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
      this.vDm.alive();
      this.vFK.alive();
      this.vFL.alive();
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
      if (this.vFw != null) {
        this.mRequestCode = 3;
      }
      str = "";
      if (!bt.isNullOrNil(parami.vAh.vAZ))
      {
        parami = parami.vAh.vAZ;
        if (localPayInfo.Cos == null) {
          localPayInfo.Cos = new Bundle();
        }
        localPayInfo.Cos.putString("cashier_desc", parami);
        if (bt.isNullOrNil(this.vER)) {
          break label1349;
        }
        com.tencent.mm.kernel.g.afC();
        parami = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHW(this.vER);
        if (parami == null) {
          break label1349;
        }
        parami = parami.ZX();
        localObject1 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.aNm(parami));
        if (!bt.isNullOrNil(this.vES)) {
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
      localPayInfo.Cos.putString("prepay_page_payee", parami);
      if (this.vFw != null) {
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this.vFw, localPayInfo);
      }
      for (;;)
      {
        this.vFu = true;
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
        if (!bt.isNullOrNil(this.vER))
        {
          com.tencent.mm.kernel.g.afC();
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHW(this.vER);
          if (localObject2 != null)
          {
            parami = ((af)localObject2).ZX();
            localObject2 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.aNm(parami));
            if (bt.isNullOrNil(this.vES)) {}
            for (parami = "";; parami = "(" + this.vES + ")")
            {
              parami = bt.u((String)localObject1, new Object[] { parami });
              break;
            }
          }
          ad.e("MicroMsg.RemittanceBusiUI", "can not found contact for user::" + this.vER);
          break;
        }
        ad.e("MicroMsg.RemittanceBusiUI", "mRcverName is null ,scene is MMPAY_PAY_SCENE_TRANSFER busi");
        break;
        parami = "(" + this.vES + ")";
        break label916;
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, localPayInfo);
      }
      if (!bt.isNullOrNil(parami.vAi)) {}
      for (this.vDc = true; (parami.vAj != null) && (parami.vAj.djg.djj != null); this.vDc = false)
      {
        f.a(parami.vAj.djg.djj, false, "", localPayInfo, this.vES, (Intent)localObject2, parami.vAj.djg.mRequestCode);
        AppMethodBeat.o(68084);
        return;
      }
      f.a(this, false, "", localPayInfo, this.vES, (Intent)localObject2, 1);
      AppMethodBeat.o(68084);
      return;
    }
  }
  
  private void dcW()
  {
    AppMethodBeat.i(68087);
    this.vEQ = dkn();
    if (this.vEQ <= 0.0D)
    {
      findViewById(2131299860).setClickable(false);
      findViewById(2131299860).setEnabled(false);
      findViewById(2131299860).setOnClickListener(null);
      kJ(false);
      this.vEF.setTextColor(getResources().getColor(2131100707));
      AppMethodBeat.o(68087);
      return;
    }
    this.vEF.setTextColor(getContext().getResources().getColor(2131100212));
    findViewById(2131299860).setEnabled(true);
    findViewById(2131299860).setClickable(true);
    kJ(true);
    findViewById(2131299860).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163832);
        com.tencent.mm.plugin.report.service.h.vKh.f(15235, new Object[] { Integer.valueOf(3) });
        if (RemittanceBusiUI.m(RemittanceBusiUI.this) == 56) {
          com.tencent.mm.plugin.report.service.h.vKh.f(19821, new Object[] { Integer.valueOf(7) });
        }
        RemittanceBusiUI.I(RemittanceBusiUI.this);
        AppMethodBeat.o(163832);
      }
    });
    AppMethodBeat.o(68087);
  }
  
  private void dkd()
  {
    AppMethodBeat.i(68066);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68019);
        RemittanceBusiUI.D(RemittanceBusiUI.this).setText(RemittanceBusiUI.C(RemittanceBusiUI.this));
        Object localObject;
        if ((RemittanceBusiUI.j(RemittanceBusiUI.this) != null) && (!bt.isNullOrNil(RemittanceBusiUI.j(RemittanceBusiUI.this).vzV)))
        {
          localObject = RemittanceBusiUI.j(RemittanceBusiUI.this).vzV;
          RemittanceBusiUI.G(RemittanceBusiUI.this).setText(com.tencent.mm.pluginsdk.ui.span.k.b(RemittanceBusiUI.this, (CharSequence)localObject, RemittanceBusiUI.G(RemittanceBusiUI.this).getTextSize()));
          if (RemittanceBusiUI.j(RemittanceBusiUI.this) == null) {
            break label358;
          }
          if (RemittanceBusiUI.j(RemittanceBusiUI.this).vzL != 1) {
            break label340;
          }
          if (bt.isNullOrNil(RemittanceBusiUI.j(RemittanceBusiUI.this).vzM)) {
            break label267;
          }
          if (RemittanceBusiUI.j(RemittanceBusiUI.this).vzU != 1) {
            break label253;
          }
          RemittanceBusiUI.H(RemittanceBusiUI.this).setRoundCorner(true);
        }
        for (;;)
        {
          int i = BackwardSupportUtil.b.g(RemittanceBusiUI.this, 36.0F);
          RemittanceBusiUI.H(RemittanceBusiUI.this).r(RemittanceBusiUI.j(RemittanceBusiUI.this).vzM, i, i, -1);
          AppMethodBeat.o(68019);
          return;
          String str = com.tencent.mm.wallet_core.ui.e.gn(com.tencent.mm.wallet_core.ui.e.sh(RemittanceBusiUI.E(RemittanceBusiUI.this)), 10);
          localObject = str;
          if (bt.isNullOrNil(RemittanceBusiUI.F(RemittanceBusiUI.this))) {
            break;
          }
          localObject = RemittanceBusiUI.this.getString(2131762438, new Object[] { str, RemittanceBusiUI.F(RemittanceBusiUI.this) });
          break;
          label253:
          RemittanceBusiUI.H(RemittanceBusiUI.this).setRoundCorner(false);
        }
        label267:
        if (!bt.isNullOrNil(RemittanceBusiUI.E(RemittanceBusiUI.this)))
        {
          if (RemittanceBusiUI.j(RemittanceBusiUI.this).vzU == 1)
          {
            a.b.d(RemittanceBusiUI.H(RemittanceBusiUI.this), RemittanceBusiUI.E(RemittanceBusiUI.this));
            AppMethodBeat.o(68019);
            return;
          }
          a.b.c(RemittanceBusiUI.H(RemittanceBusiUI.this), RemittanceBusiUI.E(RemittanceBusiUI.this));
          AppMethodBeat.o(68019);
          return;
          label340:
          RemittanceBusiUI.H(RemittanceBusiUI.this).setVisibility(8);
          AppMethodBeat.o(68019);
          return;
        }
        label358:
        RemittanceBusiUI.H(RemittanceBusiUI.this).setVisibility(8);
        AppMethodBeat.o(68019);
      }
    });
    AppMethodBeat.o(68066);
  }
  
  private double dkn()
  {
    AppMethodBeat.i(68057);
    if ((this.vEZ) || (this.mPayScene == 33))
    {
      d = this.vEQ;
      AppMethodBeat.o(68057);
      return d;
    }
    this.vEQ = bt.getDouble(this.vzg.getText(), 0.0D);
    double d = this.vEQ;
    AppMethodBeat.o(68057);
    return d;
  }
  
  private boolean dko()
  {
    AppMethodBeat.i(68067);
    boolean bool;
    if (this.vEG == null) {
      bool = false;
    }
    for (;;)
    {
      com.tencent.mm.ui.tools.p.a(this, this.swv, findViewById(2131304051), findViewById(2131304051), findViewById(2131304050), this.vEY);
      AppMethodBeat.o(68067);
      return bool;
      if (this.vEe != null)
      {
        ad.i("MicroMsg.RemittanceBusiUI", "tryShowFavor ");
        if ((this.vEe.vzS != null) && (this.vEe.vzS.CMh.size() > 0)) {}
        for (int i = 1;; i = 0)
        {
          if (this.vEe.vzR.size() > 0) {
            i = 1;
          }
          if (this.vFm.djR().size() > 0) {
            i = 1;
          }
          if (i == 0)
          {
            this.vEG.setVisibility(8);
            this.vFt.update();
            this.vEL.setVisibility(8);
            bool = false;
            break;
          }
          this.vEL.setVisibility(0);
          this.vFs.update();
          this.vEG.setVisibility(0);
          this.vEF.setText(this.vEe.vzN);
          this.vEF.setTextColor(getContext().getResources().getColor(2131100212));
          this.vEM.setText(com.tencent.mm.wallet_core.ui.e.D(dkn()));
          Object localObject = this.vFm.vCc;
          if (localObject != null)
          {
            this.vEF.setTextColor(getContext().getResources().getColor(2131099777));
            this.vEF.setText(((ahe)localObject).vzN);
            this.vEM.setText(com.tencent.mm.wallet_core.ui.e.D(((ahe)localObject).Djo / 100.0D));
          }
          for (;;)
          {
            findViewById(2131299860).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(68020);
                com.tencent.mm.plugin.report.service.h.vKh.f(15235, new Object[] { Integer.valueOf(3) });
                if (RemittanceBusiUI.m(RemittanceBusiUI.this) == 56) {
                  com.tencent.mm.plugin.report.service.h.vKh.f(19821, new Object[] { Integer.valueOf(7) });
                }
                RemittanceBusiUI.I(RemittanceBusiUI.this);
                AppMethodBeat.o(68020);
              }
            });
            bool = true;
            break;
            localObject = this.vFm.djS();
            if (!bt.isNullOrNil((String)localObject))
            {
              this.vEF.setTextColor(getContext().getResources().getColor(2131100212));
              this.vEF.setText((CharSequence)localObject);
            }
          }
        }
      }
      bool = false;
    }
  }
  
  private void dkp()
  {
    AppMethodBeat.i(163833);
    hideLoading();
    if (this.vFw != null) {
      this.vFw.hideProgress();
    }
    AppMethodBeat.o(163833);
  }
  
  private void dkq()
  {
    AppMethodBeat.i(68076);
    ad.i("MicroMsg.RemittanceBusiUI", "unLockFavorimp");
    ahe localahe = this.vFm.vCc;
    if (localahe == null)
    {
      ad.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor FavorComposeInfo is null");
      AppMethodBeat.o(68076);
      return;
    }
    int i = (int)Math.round(this.vEQ * 100.0D);
    dh localdh = new dh();
    localdh.channel = this.mChannel;
    localdh.CxW = this.vDV;
    localdh.CxX = this.ujI;
    localdh.vzO = this.vEe.vzO;
    localdh.scene = this.mPayScene;
    localdh.CxY = this.vEa;
    localdh.CxZ = localahe;
    localdh.iaw = this.vER;
    localdh.vBp = this.vCX;
    localdh.Cya = i;
    doSceneProgress(new com.tencent.mm.plugin.remittance.model.k(localdh, this.vFn), false);
    AppMethodBeat.o(68076);
  }
  
  private void dkr()
  {
    AppMethodBeat.i(68078);
    ad.i("MicroMsg.RemittanceBusiUI", "goto busi result");
    Object localObject = new Intent(this, RemittanceBusiResultUI.class);
    ((Intent)localObject).putExtra("key_pay_desc", this.vDW);
    ((Intent)localObject).putExtra("key_rcv_desc", this.vEU);
    if (this.vEe != null) {
      ((Intent)localObject).putExtra("BusiRemittanceResp", this.vEe);
    }
    ((Intent)localObject).putExtra("key_mch_name", this.vCs);
    ((Intent)localObject).putExtra("key_rcver_name", this.vER);
    ((Intent)localObject).putExtra("key_rcver_true_name", this.vES);
    if (this.dcH >= 0.0D) {
      ((Intent)localObject).putExtra("key_money", this.dcH);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_f2f_id", this.vDV);
      ((Intent)localObject).putExtra("key_trans_id", this.ujI);
      ((Intent)localObject).putExtra("key_check_sign", this.vEa);
      ((Intent)localObject).putExtra("key_rcvr_open_id", this.vCX);
      ((Intent)localObject).putExtra("key_channel", this.mChannel);
      ((Intent)localObject).putExtra("key_succ_fault_config", this.vFk);
      if (this.vEe != null)
      {
        ((Intent)localObject).putExtra("key_succ_show_avatar_type", this.vEe.vzU);
        ((Intent)localObject).putExtra("key_succ_show_avatar_show", this.vEe.vzL);
        ((Intent)localObject).putExtra("key_succ_show_avatar_url", this.vEe.vzM);
      }
      if (this.vEe != null) {
        ((Intent)localObject).putExtra("key_scan_sceen", this.vEe.vzO);
      }
      ((Intent)localObject).putExtra("key_succ_page_extend", this.vFo);
      ahe localahe = this.vFm.vCc;
      int i = (int)Math.round(this.vEQ * 100.0D);
      dh localdh = new dh();
      localdh.channel = this.mChannel;
      localdh.CxW = this.vDV;
      localdh.CxX = this.ujI;
      localdh.vzO = this.vEe.vzO;
      localdh.scene = this.mPayScene;
      localdh.CxY = this.vEa;
      localdh.CxZ = localahe;
      localdh.iaw = this.vER;
      localdh.vBp = this.vCX;
      localdh.Cya = i;
      try
      {
        ((Intent)localObject).putExtra("AfterPlaceOrderCommReq", localdh.toByteArray());
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI", "gotoBusiResultUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI", "gotoBusiResultUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        if (e.dki().dkj()) {
          ad.w("MicroMsg.RemittanceBusiUI", "finish finishRemitF2fDCodeAndLMRemindUI");
        }
        AppMethodBeat.o(68078);
        return;
        ((Intent)localObject).putExtra("key_money", this.vEQ);
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
  
  private void eY(final List<ahf> paramList)
  {
    AppMethodBeat.i(68068);
    final com.tencent.mm.ui.widget.picker.e locale = new com.tencent.mm.ui.widget.picker.e(this);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = this.vFm.vCc;
    Object localObject1 = new HashSet();
    final HashSet localHashSet = new HashSet();
    if ((this.vFm.djU()) && (localObject2 != null))
    {
      localObject2 = ((ahe)localObject2).CMg.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((HashSet)localObject1).add(Long.valueOf(((ahf)((Iterator)localObject2).next()).Djv));
      }
    }
    localObject2 = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      if (((HashSet)localObject1).contains(Long.valueOf(((ahf)((Iterator)localObject2).next()).Djv))) {
        localArrayList.add(Integer.valueOf(i));
      }
      i += 1;
    }
    localObject1 = getString(2131762485);
    if ((localObject1 != null) && (((CharSequence)localObject1).length() > 0))
    {
      locale.HJf.setVisibility(0);
      locale.xWz.setText((CharSequence)localObject1);
    }
    locale.HJg = localArrayList;
    locale.HrX = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(68024);
        RemittanceBusiUI.a(RemittanceBusiUI.this, RemittanceBusiUI.p(RemittanceBusiUI.this));
        ahf localahf;
        if ((!RemittanceBusiUI.J(RemittanceBusiUI.this).djU()) || (RemittanceBusiUI.q(RemittanceBusiUI.this) <= 0.0D))
        {
          localIterator = paramList.iterator();
          i = 0;
          while (localIterator.hasNext())
          {
            localahf = (ahf)localIterator.next();
            paramAnonymousl.a(i, localahf.Djw, localahf.Djy, null, true);
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
          localahf = (ahf)localIterator.next();
          if (localahf.DjE == 1)
          {
            paramAnonymousl.a(i, localahf.Djw, localahf.Djy, null, true);
            localHashSet.add(Integer.valueOf(i));
          }
          for (;;)
          {
            i += 1;
            break;
            paramAnonymousl.a(i, localahf.Djw, localahf.Djy, 0);
          }
        }
        AppMethodBeat.o(68024);
      }
    };
    locale.HrY = new n.d()
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
          com.tencent.mm.plugin.report.service.h.vKh.f(15235, new Object[] { Integer.valueOf(4) });
          Object localObject1 = (ahf)paramList.get(paramAnonymousInt);
          paramAnonymousMenuItem = locale;
          boolean bool;
          if (paramAnonymousMenuItem.HJh != null)
          {
            paramAnonymousMenuItem = paramAnonymousMenuItem.HJh.fgb();
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
                ((List)localObject2).add((ahf)paramList.get(k));
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
          b localb = RemittanceBusiUI.J(RemittanceBusiUI.this);
          if (i != 0) {}
          for (paramAnonymousMenuItem = (MenuItem)localObject1;; paramAnonymousMenuItem = null)
          {
            localb.a((List)localObject2, paramAnonymousMenuItem);
            localObject1 = RemittanceBusiUI.J(RemittanceBusiUI.this).vCc;
            paramAnonymousMenuItem = new HashSet();
            if (localObject1 == null) {
              break;
            }
            localObject1 = ((ahe)localObject1).CMg.iterator();
            while (((Iterator)localObject1).hasNext()) {
              paramAnonymousMenuItem.add(Long.valueOf(((ahf)((Iterator)localObject1).next()).Djv));
            }
          }
          localObject1 = new HashMap();
          Object localObject2 = paramList.iterator();
          i = j;
          if (((Iterator)localObject2).hasNext())
          {
            if (paramAnonymousMenuItem.contains(Long.valueOf(((ahf)((Iterator)localObject2).next()).Djv))) {
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
          if (paramAnonymousMenuItem.HJh != null)
          {
            paramAnonymousMenuItem.HJh.HJk = ((HashMap)localObject1);
            paramAnonymousMenuItem.HJh.notifyDataSetChanged();
          }
        }
        AppMethodBeat.o(68026);
      }
    };
    locale.HJi = new e.b()
    {
      public final void oP(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(68027);
        if (paramAnonymousBoolean)
        {
          localObject = RemittanceBusiUI.J(RemittanceBusiUI.this).vCc;
          if (localObject != null) {
            break label56;
          }
        }
        label56:
        for (Object localObject = "";; localObject = com.tencent.mm.plugin.remittance.model.a.a((ahe)localObject))
        {
          ad.i("MicroMsg.RemittanceBusiUI", "onFavorSelected %s ", new Object[] { localObject });
          RemittanceBusiUI.K(RemittanceBusiUI.this);
          AppMethodBeat.o(68027);
          return;
        }
      }
    };
    if (locale.HrX != null) {
      locale.HrX.onCreateMMMenu(locale.BoA);
    }
    locale.HJh = new e.a(locale, locale.mContext);
    locale.HJh.fga();
    locale.HJe.setAdapter(locale.HJh);
    locale.hJh.setOnClickListener(new e.2(locale));
    locale.hJg.setOnClickListener(new e.3(locale));
    if (locale.sri != null)
    {
      if ((locale.BoA != null) && (locale.BoA.size() > 3))
      {
        paramList = (FrameLayout.LayoutParams)locale.jGG.getLayoutParams();
        paramList.height = locale.kBk;
        locale.jGG.setLayoutParams(paramList);
      }
      locale.sri.show();
    }
    AppMethodBeat.o(68068);
  }
  
  private void kJ(boolean paramBoolean)
  {
    AppMethodBeat.i(68088);
    if (this.vyZ != null) {
      this.vyZ.xm(paramBoolean);
    }
    AppMethodBeat.o(68088);
  }
  
  private void u(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(68075);
    ad.i("MicroMsg.RemittanceBusiUI", "doBusiZeroCallback %s", new Object[] { Boolean.valueOf(paramBoolean) });
    dh localdh = (dh)this.vFv.get(paramString);
    if (localdh == null)
    {
      AppMethodBeat.o(68075);
      return;
    }
    dcl localdcl = this.vFe;
    String str = this.vFd;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString = new com.tencent.mm.plugin.remittance.model.l(localdcl, localdh, str, i, this.vFf, paramString);
      if (!paramBoolean) {
        break;
      }
      paramString.hasRetried = true;
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
      AppMethodBeat.o(68075);
      return;
    }
    this.vFj = 0;
    doSceneForceProgress(paramString);
    AppMethodBeat.o(68075);
  }
  
  public final void a(int paramInt, i parami)
  {
    AppMethodBeat.i(163835);
    v localv = new v();
    localv.dHQ = paramInt;
    if (parami != null)
    {
      localv.ge(parami.vAh.CxW);
      localv.gf(this.vEP);
      localv.dJE = parami.uxV;
    }
    localv.aBj();
    AppMethodBeat.o(163835);
  }
  
  public final void bk(float paramFloat)
  {
    AppMethodBeat.i(68065);
    if (this.swv != null)
    {
      this.vEY = paramFloat;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.swv.getLayoutParams();
      localLayoutParams.bottomMargin = ((int)paramFloat);
      ad.d("MicroMsg.RemittanceBusiUI", "onUpdateWcPayKeyboardHeight() height: %s rootView.height: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(localLayoutParams.height) });
      this.swv.setLayoutParams(localLayoutParams);
      com.tencent.mm.ui.tools.p.a(this, this.swv, findViewById(2131304051), findViewById(2131304051), findViewById(2131304050), paramFloat);
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
    this.swv = ((ScrollView)findViewById(2131304251));
    this.vEz = ((TextView)findViewById(2131304008));
    this.vEA = ((TextView)findViewById(2131304009));
    this.vEB = ((TextView)findViewById(2131304005));
    this.vEC = ((TextView)findViewById(2131304002));
    this.vED = ((TextView)findViewById(2131303996));
    this.vEE = ((TextView)findViewById(2131303994));
    this.vEH = ((CdnImageView)findViewById(2131304006));
    this.vzg = ((WalletFormView)findViewById(2131304007));
    this.vEI = ((LinearLayout)findViewById(2131304003));
    this.vCI = ((LinearLayout)findViewById(2131303998));
    this.vEO = ((RelativeLayout)findViewById(2131306754));
    this.vEJ = ((LinearLayout)findViewById(2131303997));
    this.vEF = ((TextView)findViewById(2131299864));
    this.vEG = findViewById(2131303999);
    this.vEK = ((TextView)findViewById(2131304001));
    this.vEL = findViewById(2131299968);
    this.vEM = ((TextView)findViewById(2131299967));
    this.vEN = ((Button)findViewById(2131304004));
    this.vyZ = ((WcPayKeyboard)findViewById(2131307020));
    ImageView localImageView;
    label536:
    label680:
    boolean bool1;
    if (this.vEZ)
    {
      if (!bt.isNullOrNil(this.vEU)) {
        this.vEB.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, this.vEU, this.vEB.getTextSize()));
      }
      this.vEC.setText(com.tencent.mm.wallet_core.ui.e.D(this.vEQ));
      this.vEI.setVisibility(0);
      this.vCI.setVisibility(8);
      this.vEO.setVisibility(8);
      this.vEN.setVisibility(0);
      if (com.tencent.mm.kernel.g.afw())
      {
        com.tencent.mm.kernel.g.afC();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.vER);
        if ((localObject == null) || ((int)((com.tencent.mm.n.b)localObject).fId == 0)) {
          ar.a.gMW.a(this.vER, "", new ar.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(68044);
              ad.i("MicroMsg.RemittanceBusiUI", "getContact %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              RemittanceBusiUI.k(RemittanceBusiUI.this);
              AppMethodBeat.o(68044);
            }
          });
        }
      }
      dkd();
      this.vEJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68048);
          if (!RemittanceBusiUI.l(RemittanceBusiUI.this)) {
            RemittanceBusiUI.this.showCircleStWcKb();
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(15235, new Object[] { Integer.valueOf(6) });
          if (RemittanceBusiUI.m(RemittanceBusiUI.this) == 56) {
            com.tencent.mm.plugin.report.service.h.vKh.f(19821, new Object[] { Integer.valueOf(6) });
          }
          com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBusiUI.this, RemittanceBusiUI.this.getString(2131762421), RemittanceBusiUI.n(RemittanceBusiUI.this), RemittanceBusiUI.this.getString(2131762424), true, 20, new h.b()new DialogInterface.OnClickListener
          {
            public final boolean onFinish(CharSequence paramAnonymous2CharSequence)
            {
              AppMethodBeat.i(68045);
              RemittanceBusiUI.a(RemittanceBusiUI.this, paramAnonymous2CharSequence.toString());
              RemittanceBusiUI.o(RemittanceBusiUI.this);
              AppMethodBeat.o(68045);
              return true;
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(68047);
              aq.n(new Runnable()
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
          com.tencent.mm.plugin.report.service.h.vKh.f(15235, new Object[] { Integer.valueOf(5) });
          if (RemittanceBusiUI.m(RemittanceBusiUI.this) == 56) {
            com.tencent.mm.plugin.report.service.h.vKh.f(19821, new Object[] { Integer.valueOf(8) });
          }
          if (!RemittanceBusiUI.l(RemittanceBusiUI.this)) {
            RemittanceBusiUI.a(RemittanceBusiUI.this, RemittanceBusiUI.p(RemittanceBusiUI.this));
          }
          if (RemittanceBusiUI.q(RemittanceBusiUI.this) <= 0.0D)
          {
            t.makeText(RemittanceBusiUI.this.getContext(), 2131765031, 0).show();
            AppMethodBeat.o(68051);
            return;
          }
          com.tencent.mm.plugin.remittance.model.g localg = RemittanceBusiUI.this.vFr;
          if (RemittanceBusiUI.this.vFr == null) {}
          for (paramAnonymousView = "";; paramAnonymousView = RemittanceBusiUI.this.vFr.vAe)
          {
            ad.i("MicroMsg.RemittanceBusiUI", "mPayBtn onClick %s  isFinish:%s getFavorFlag: %s", new Object[] { localg, paramAnonymousView, Boolean.valueOf(RemittanceBusiUI.this.vFp) });
            if (RemittanceBusiUI.i(RemittanceBusiUI.this) != 32) {
              break label346;
            }
            if (!RemittanceBusiUI.this.vFp) {
              break label333;
            }
            if ((RemittanceBusiUI.this.vFr == null) || (RemittanceBusiUI.this.vFr.vyE != (int)(RemittanceBusiUI.q(RemittanceBusiUI.this) * 100.0D))) {
              break;
            }
            if ((RemittanceBusiUI.this.vFr != null) && (RemittanceBusiUI.this.vFr.vAe)) {
              break label346;
            }
            if (RemittanceBusiUI.this.vFr == null) {
              break label353;
            }
            RemittanceBusiUI.this.vFr.vAc = new com.tencent.mm.plugin.remittance.model.c()
            {
              public final void eX(List<ahf> paramAnonymous2List)
              {
                AppMethodBeat.i(68049);
                RemittanceBusiUI.r(RemittanceBusiUI.this);
                AppMethodBeat.o(68049);
              }
            };
            AppMethodBeat.o(68051);
            return;
          }
          RemittanceBusiUI.a(RemittanceBusiUI.this, new com.tencent.mm.plugin.remittance.model.c()
          {
            public final void eX(List<ahf> paramAnonymous2List)
            {
              AppMethodBeat.i(68050);
              RemittanceBusiUI.r(RemittanceBusiUI.this);
              AppMethodBeat.o(68050);
            }
          }, 0);
          AppMethodBeat.o(68051);
          return;
          label333:
          RemittanceBusiUI.r(RemittanceBusiUI.this);
          AppMethodBeat.o(68051);
          return;
          label346:
          RemittanceBusiUI.r(RemittanceBusiUI.this);
          label353:
          AppMethodBeat.o(68051);
        }
      };
      this.vzg.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(68052);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66))
          {
            ad.i("MicroMsg.RemittanceBusiUI", "click enter");
            this.vzz.onClick(null);
            AppMethodBeat.o(68052);
            return true;
          }
          AppMethodBeat.o(68052);
          return true;
        }
      });
      localImageView = (ImageView)findViewById(2131306750);
      if (ai.Eq())
      {
        findViewById(2131306755).setVisibility(8);
        findViewById(2131306752).setVisibility(0);
        localImageView.setBackgroundResource(2131234672);
        this.vEN.setOnClickListener((View.OnClickListener)localObject);
        this.swv.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(68015);
            if ((RemittanceBusiUI.s(RemittanceBusiUI.this) != null) && (RemittanceBusiUI.t(RemittanceBusiUI.this).isShown()) && (RemittanceBusiUI.u(RemittanceBusiUI.this).fjx()))
            {
              RemittanceBusiUI.v(RemittanceBusiUI.this).fjv();
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
              RemittanceBusiUI.w(RemittanceBusiUI.this).scrollTo(0, 0);
              if ((RemittanceBusiUI.c(RemittanceBusiUI.this) != null) && (RemittanceBusiUI.c(RemittanceBusiUI.this).getVisibility() == 0))
              {
                RemittanceBusiUI.c(RemittanceBusiUI.this).setFocusable(false);
                RemittanceBusiUI.c(RemittanceBusiUI.this).setFocusable(true);
              }
            }
            AppMethodBeat.o(68016);
          }
        });
        this.vzj = ((RelativeLayout)findViewById(2131306751));
        if ((!ac.eFu().equals("zh_CN")) && (!ac.eFu().equals("zh_TW")) && (!ac.eFu().equals("zh_HK"))) {
          break label993;
        }
        this.vzh = ((RelativeLayout)findViewById(2131306753));
        this.vzi = ((TextView)findViewById(2131306756));
        this.vzh.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68017);
            RemittanceBusiUI.a(RemittanceBusiUI.this, RemittanceBusiUI.x(RemittanceBusiUI.this).getWidth());
            RemittanceBusiUI.y(RemittanceBusiUI.this).setVisibility(8);
            ad.d("MicroMsg.RemittanceBusiUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(RemittanceBusiUI.z(RemittanceBusiUI.this)) });
            AppMethodBeat.o(68017);
          }
        });
        this.vzg.setmWalletFormViewListener(new WalletFormView.c()
        {
          public final void p(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(68018);
            if (bt.iY(RemittanceBusiUI.A(RemittanceBusiUI.this), 0))
            {
              ad.i("MicroMsg.RemittanceBusiUI", "mAmountRemindBit == 0");
              RemittanceBusiUI.y(RemittanceBusiUI.this).setVisibility(8);
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
            if (i >= RemittanceBusiUI.A(RemittanceBusiUI.this))
            {
              j = RemittanceBusiUI.c(RemittanceBusiUI.this).m(paramAnonymousCharSequence, RemittanceBusiUI.z(RemittanceBusiUI.this), j);
              if (j != 0)
              {
                RemittanceBusiUI.y(RemittanceBusiUI.this).setVisibility(0);
                paramAnonymousCharSequence = ag.aH(aj.getContext(), i);
                RemittanceBusiUI.B(RemittanceBusiUI.this).setText(paramAnonymousCharSequence);
                paramAnonymousCharSequence = (RelativeLayout.LayoutParams)RemittanceBusiUI.x(RemittanceBusiUI.this).getLayoutParams();
                paramAnonymousCharSequence.leftMargin = j;
                RemittanceBusiUI.x(RemittanceBusiUI.this).setLayoutParams(paramAnonymousCharSequence);
                AppMethodBeat.o(68018);
                return;
              }
              RemittanceBusiUI.y(RemittanceBusiUI.this).setVisibility(8);
              AppMethodBeat.o(68018);
              return;
            }
            RemittanceBusiUI.y(RemittanceBusiUI.this).setVisibility(8);
            AppMethodBeat.o(68018);
          }
        });
        if ((this.vEe != null) && (this.vEe.vzS != null))
        {
          this.vFm.vCd = this.vEe.vzS;
          this.vFm.amm(this.vEe.vzS.CMi);
        }
        if (dko()) {
          com.tencent.mm.plugin.report.service.h.vKh.f(15235, new Object[] { Integer.valueOf(2) });
        }
        AppMethodBeat.o(68063);
      }
    }
    else
    {
      if (this.vEe == null) {
        break label1010;
      }
      if (this.vEe.vzR.size() <= 0) {
        break label1005;
      }
      bool1 = false;
      label786:
      bool2 = bool1;
      if (this.vEe.vzS != null)
      {
        bool2 = bool1;
        if (this.vEe.vzS.CMg.size() <= 0) {}
      }
    }
    label993:
    label1005:
    label1010:
    for (boolean bool2 = false;; bool2 = true)
    {
      this.vEN.setVisibility(8);
      setWPKeyboard(this.vzg.getContentEt(), bool2, true);
      this.vzg.setmContentAbnormalMoneyCheck(true);
      if (com.tencent.mm.compatible.util.d.lf(28)) {
        this.vzg.getContentEt().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68042);
            RemittanceBusiUI.c(RemittanceBusiUI.this).getContentEt().requestFocus();
            AppMethodBeat.o(68042);
          }
        });
      }
      this.vyZ.setActionText(getString(2131762434));
      setWcKbHeightListener(this);
      ((RelativeLayout.LayoutParams)this.vyZ.getLayoutParams()).addRule(12);
      this.vzg.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(68043);
          RemittanceBusiUI.h(RemittanceBusiUI.this);
          if (RemittanceBusiUI.i(RemittanceBusiUI.this) == 32)
          {
            paramAnonymousEditable = RemittanceBusiUI.this;
            if (RemittanceBusiUI.j(RemittanceBusiUI.this) != null) {
              break label55;
            }
          }
          label55:
          for (int i = 400;; i = RemittanceBusiUI.j(RemittanceBusiUI.this).vzX)
          {
            RemittanceBusiUI.a(paramAnonymousEditable, null, i);
            AppMethodBeat.o(68043);
            return;
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.vzg.fkH();
      this.vEI.setVisibility(8);
      this.vCI.setVisibility(0);
      this.vEO.setVisibility(0);
      break;
      findViewById(2131306755).setVisibility(0);
      findViewById(2131306752).setVisibility(8);
      localImageView.setBackgroundResource(2131234671);
      break label536;
      this.vzj.setVisibility(8);
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
      if ((!this.vFu) && (!this.vEZ) && (this.vyZ.fjz()))
      {
        AppMethodBeat.o(68062);
        return true;
      }
      AppMethodBeat.o(68062);
      return false;
    }
    if ((!this.vEZ) && (this.vyZ.fjz()))
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
      if (this.vFw != null)
      {
        this.vFw.hideProgress();
        this.vFw = null;
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
          this.vFf = str;
          this.dcH = 0.0D;
          ad.i("MicroMsg.RemittanceBusiUI", "onActivityResult _result_token: %s", new Object[] { str });
          u(false, paramIntent.getStringExtra("INTENT_REQKEY"));
        }
        else
        {
          dkq();
        }
      }
      else if (paramInt1 == 4) {
        this.vFz = true;
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
      com.tencent.mm.plugin.report.service.h.vKh.f(19821, new Object[] { Integer.valueOf(4) });
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(15235, new Object[] { Integer.valueOf(1) });
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
    if ((com.tencent.mm.compatible.util.d.lf(21)) && (!com.tencent.mm.compatible.util.d.lf(23))) {
      getWindow().setStatusBarColor(getContext().getResources().getColor(2131099679));
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(68035);
        if (RemittanceBusiUI.g(RemittanceBusiUI.this))
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
    regeistQueryOrder(2682, this.vFE);
    setMMTitle(2131762434);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(68014);
        RemittanceBusiUI.e(RemittanceBusiUI.this);
        if (RemittanceBusiUI.this.getIntent().getIntExtra("pay_channel", 0) == 56)
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(19821, new Object[] { Integer.valueOf(5) });
          RemittanceBusiUI.dks();
        }
        RemittanceBusiUI.this.finish();
        AppMethodBeat.o(68014);
        return false;
      }
    });
    this.dpw = UUID.randomUUID().toString();
    com.tencent.mm.plugin.wallet.pay.a.b.atD(this.dpw);
    this.mPayScene = getIntent().getIntExtra("pay_scene", 31);
    this.vEP = getIntent().getStringExtra("scan_remittance_id");
    this.vEQ = getIntent().getDoubleExtra("fee", 0.0D);
    this.vER = getIntent().getStringExtra("receiver_name");
    this.vES = getIntent().getStringExtra("receiver_true_name");
    this.vET = getIntent().getStringExtra("receiver_true_name_busi");
    this.mChannel = getIntent().getIntExtra("pay_channel", 0);
    this.vEU = getIntent().getStringExtra("desc");
    this.vEW = getIntent().getIntExtra("busi_type", 0);
    this.vCs = getIntent().getStringExtra("mch_name");
    this.vFa = getIntent().getStringExtra("mch_type");
    this.vFc = getIntent().getIntExtra("mch_time", 0);
    this.vEX = getIntent().getStringExtra("mch_info");
    this.vFb = getIntent().getIntExtra("get_pay_wifi", 0);
    this.vCX = getIntent().getStringExtra("rcvr_open_id");
    this.vEV = getIntent().getStringExtra("rcvr_ticket");
    this.vyQ = getIntent().getIntExtra("amount_remind_bit", 4);
    this.vFl = getIntent().getStringExtra("receiver_tips");
    this.vEe = ((BusiRemittanceResp)getIntent().getParcelableExtra("BusiRemittanceResp"));
    boolean bool;
    if (this.vEe != null)
    {
      if ((this.mPayScene == 32) && ((this.vEe.vzT == 1) || ((this.vEe != null) && (this.vEe.vzR.size() > 0))))
      {
        bool = true;
        this.vFp = bool;
      }
    }
    else {
      if (this.vEQ <= 0.0D) {
        break label803;
      }
    }
    label803:
    for (this.vEZ = true;; this.vEZ = false)
    {
      if (this.vEW == 0)
      {
        ad.w("MicroMsg.RemittanceBusiUI", "wrong busi type!");
        finish();
      }
      com.tencent.mm.plugin.report.service.h.vKh.f(15386, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
      this.vFs = new b(32, 32, 6.0F);
      this.vFt = new b(56, 56, 8.0F);
      initView();
      dcW();
      this.vBY.alive();
      this.vFN.alive();
      if (!this.vEZ) {
        this.state = 1;
      }
      AppMethodBeat.o(68058);
      return;
      bool = false;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68070);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.ESL.d(this.vDm);
    com.tencent.mm.sdk.b.a.ESL.d(this.vFM);
    com.tencent.mm.sdk.b.a.ESL.d(this.vFK);
    this.vFL.dead();
    removeSceneEndListener(1633);
    removeSceneEndListener(1241);
    removeSceneEndListener(2677);
    removeSceneEndListener(2504);
    removeSceneEndListener(2702);
    removeSceneEndListener(2682);
    this.vBY.dead();
    this.vFN.dead();
    com.tencent.mm.plugin.wallet.pay.a.b.atE(this.dpw);
    aq.az(this.vzw);
    AppMethodBeat.o(68070);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(68061);
    ad.i("MicroMsg.RemittanceBusiUI", "onDialogDismiss()");
    aq.n(this.vzw, 300L);
    AppMethodBeat.o(68061);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68064);
    if ((this.vyZ != null) && (this.vyZ.onKeyUp(paramInt, paramKeyEvent)))
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
    if ((!this.vEZ) && (!this.vyZ.fjy())) {
      this.state = 3;
    }
    AppMethodBeat.o(68060);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68059);
    super.onResume();
    ad.i("MicroMsg.RemittanceBusiUI", "onResume()");
    e.dki().fM(this);
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      showNormalStWcKb();
    }
    if (!this.vEZ) {
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
        localObject1 = e.dki();
        ad.w("MicroMsg.RemittanceBusiDialogMgr", "hideProgress()");
        localObject1 = (Context)((e)localObject1).cqo.get();
        if (localObject1 == null) {
          ad.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
        }
      }
      else
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label1626;
        }
        if (paramString.vAh.ntx != 0) {
          break label1431;
        }
        this.vFC = paramString;
        this.vDV = paramString.vAh.CxW;
        this.ujI = paramString.vAh.CxX;
        this.vEa = paramString.vAh.CxY;
        this.vFn = paramString.vAh.CMF;
        this.vFo = paramString.vAh.CME;
        this.vFd = paramString.vAh.CMK;
        this.vFe = paramString.vAh.CMJ;
        this.vFg = paramString.vAh.CMN;
        this.vFh = paramString.vAh.CML;
        this.vFi = paramString.vAh.CMM;
        this.vFk = i.a(paramString.vAh.CMS).toString();
        ad.i("MicroMsg.RemittanceBusiUI", "touch_challenge: %s need_change_auth_key: %s mBusiF2FFaultConfig: %s", new Object[] { paramString.vAh.CMO, Integer.valueOf(paramString.vAh.CMP), this.vFk });
        if (paramString.vAh.CMO != null) {
          com.tencent.mm.plugin.fingerprint.b.p.rcp.rcj = paramString.vAh.CMO.eBA();
        }
        paramn = com.tencent.mm.plugin.fingerprint.b.p.rcp;
        if (paramString.vAh.CMP != 1) {
          break label594;
        }
        bool = true;
        paramn.rcr = bool;
        if (a(paramString)) {
          break label1424;
        }
        ad.i("MicroMsg.RemittanceBusiUI", "showNameVerifyDialog");
        if (paramString.vAh.CMV != null) {
          break label600;
        }
        ad.e("MicroMsg.RemittanceBusiUI", "orderScene.response.check_recv_name_win is null");
        paramInt1 = 0;
        if (paramInt1 == 0)
        {
          if (paramString.vAh.CMT == null) {
            break label1266;
          }
          ad.i("MicroMsg.RemittanceBusiUI", "showMoneyRemind amount_remind_win");
          dkp();
          if ((e.dki().getContext() != null) && ((e.dki().getContext() instanceof RemittanceBusiUI))) {
            this.vFy = paramString.vAh.CMT.Cyh;
          }
          paramn = e.dki();
          localObject2 = paramString.vAh.CMT;
          paramInt1 = this.vyQ;
          localObject3 = new RemittanceBusiUI.a(paramString) {};
          localObject4 = new RemittanceBusiUI.a(paramString) {};
          ad.w("MicroMsg.RemittanceBusiDialogMgr", "showAmountRemindWin() amountRemindBit:%s", new Object[] { Integer.valueOf(paramInt1) });
          paramn = (Context)paramn.cqo.get();
          if (paramn != null) {
            break label925;
          }
          ad.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
          label521:
          if (e.dki().getContext() != null)
          {
            if (!(e.dki().getContext() instanceof RemittanceBusiUI)) {
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
      dkp();
      localObject4 = paramString.vAh.CMV.title;
      Object localObject6 = paramString.vAh.CMV.doh;
      Object localObject7 = paramString.vAh.CMV.CXu;
      localObject2 = paramString.vAh.CMV.Avj.doh;
      localObject3 = paramString.vAh.CMV.Avk.doh;
      paramn = new c(this);
      paramn.vCg = new c.a()
      {
        public final void amf(final String paramAnonymousString)
        {
          AppMethodBeat.i(174427);
          ad.i("MicroMsg.RemittanceBusiUI", "showNameVerifyDialog onINputName() name:%s", new Object[] { paramAnonymousString });
          RemittanceBusiUI.this.hideVKB();
          com.tencent.mm.plugin.report.service.h.vKh.f(19229, new Object[] { Integer.valueOf(0), Integer.valueOf(paramString.vAh.CMV.CXv), Integer.valueOf(0), RemittanceBusiUI.X(RemittanceBusiUI.this) });
          com.tencent.mm.wallet_core.c.l.a(RemittanceBusiUI.this, paramString.vAh.CMV.Avk, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dB(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(174422);
              ad.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog right button click jumpItem.action:continue");
              RemittanceBusiUI.a(RemittanceBusiUI.this, paramAnonymousString, RemittanceBusiUI.35.this.vFS.vAh.CMV.CMB);
              AppMethodBeat.o(174422);
            }
            
            public final void djE()
            {
              AppMethodBeat.i(174423);
              ad.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog right button click jumpItem.action:close");
              AppMethodBeat.o(174423);
            }
            
            public final void djL()
            {
              AppMethodBeat.i(174421);
              ad.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog right button click jumpItem.action:exit");
              RemittanceBusiUI.Y(RemittanceBusiUI.this);
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
          com.tencent.mm.plugin.report.service.h.vKh.f(19229, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.vAh.CMV.CXv), Integer.valueOf(0), RemittanceBusiUI.X(RemittanceBusiUI.this) });
          com.tencent.mm.wallet_core.c.l.a(RemittanceBusiUI.this, paramString.vAh.CMV.Avj, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dB(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(174425);
              ad.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog left button click jumpItem.action：continue");
              AppMethodBeat.o(174425);
            }
            
            public final void djE()
            {
              AppMethodBeat.i(174426);
              ad.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog left button click jumpItem.action：close");
              AppMethodBeat.o(174426);
            }
            
            public final void djL()
            {
              AppMethodBeat.i(174424);
              ad.i("MicroMsg.RemittanceBusiUI", " showNameVerifyDialog left button click jumpItem.action:exit");
              RemittanceBusiUI.Y(RemittanceBusiUI.this);
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
      ((d.a)localObject6).aMf((String)localObject4).gs((View)localObject5);
      localObject4 = com.tencent.mm.ui.tools.b.c.d((EditText)localObject1);
      ((com.tencent.mm.ui.tools.b.c)localObject4).mcf = f.a.Hrl;
      localObject4 = ((com.tencent.mm.ui.tools.b.c)localObject4).jE(1, 1);
      ((com.tencent.mm.ui.tools.b.c)localObject4).HuM = false;
      ((com.tencent.mm.ui.tools.b.c)localObject4).a(null);
      aq.n(new c.10(paramn, (EditText)localObject1), 200L);
      ((d.a)localObject6).aMm((String)localObject3).aaD(-2141754475).a(false, new c.11(paramn, (EditText)localObject1));
      ((d.a)localObject6).aMn((String)localObject2).c(new c.2(paramn));
      localObject2 = ((d.a)localObject6).fft();
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
      double d = ((dn)localObject2).Cyh / 100.0D;
      ((WalletTextView)localObject6).setText(com.tencent.mm.wallet_core.ui.e.D(d));
      if (bt.iY(paramInt1, 0))
      {
        ad.i("MicroMsg.JumpItemUtil", "mAmountRemindBit == 0");
        ((View)localObject8).setVisibility(8);
      }
      for (;;)
      {
        localObject5 = ((dn)localObject2).doh;
        localObject6 = ((dn)localObject2).Avk.doh;
        localObject7 = ((dn)localObject2).Avj.doh;
        localObject4 = new l.8(paramn, (dn)localObject2, d, (l.a)localObject4);
        localObject2 = new l.9(paramn, (dn)localObject2, d, (l.a)localObject3);
        localObject3 = new d.a(paramn);
        ((d.a)localObject3).aMf((String)localObject5);
        ((d.a)localObject3).gs((View)localObject1);
        ((d.a)localObject3).aMm((String)localObject6).b((DialogInterface.OnClickListener)localObject4);
        ((d.a)localObject3).aMn((String)localObject7).c((DialogInterface.OnClickListener)localObject2);
        ((d.a)localObject3).wX(false);
        ((d.a)localObject3).wY(true);
        localObject1 = ((d.a)localObject3).fft();
        ((com.tencent.mm.ui.widget.a.d)localObject1).show();
        com.tencent.mm.ui.base.h.a(paramn, (Dialog)localObject1);
        break;
        TextView localTextView = (TextView)((View)localObject1).findViewById(2131306756);
        ((View)localObject8).setVisibility(0);
        ((View)localObject8).post(new l.7((View)localObject7, d, paramInt1, (WalletTextView)localObject6, (View)localObject5, (View)localObject8, localTextView));
      }
      label1244:
      if (!(e.dki().getContext() instanceof RemittanceF2fLargeMoneyUI)) {
        break label548;
      }
      a(9, paramString);
      break label548;
      label1266:
      if (paramString.vAh.CMU != null)
      {
        ad.i("MicroMsg.RemittanceBusiUI", "showMoneyRemind amount_remind_page");
        dkp();
        paramn = new Intent();
        paramn.putExtra("key_amount_remind_bit", this.vyQ);
        paramn.putExtra("key_title", paramString.vAh.CMU.title);
        paramn.putExtra("key_desc", paramString.vAh.CMU.doh);
        paramn.putExtra("key_amount_remind_sign", paramString.vAh.CMU.Cyg);
        com.tencent.mm.bs.d.b(this, "wallet_payu", ".pay.ui.WalletPayUOrderInfoUI", paramn, 4);
        a(6, paramString);
        break label548;
      }
      if ((e.dki().getContext() != null) && ((e.dki().getContext() instanceof RemittanceF2fLargeMoneyUI))) {
        a(8, paramString);
      }
      paramInt1 = 0;
      break label550;
      label1424:
      dkp();
      continue;
      label1431:
      dkp();
      ad.e("MicroMsg.RemittanceBusiUI", "place order response: %s, %s", new Object[] { Integer.valueOf(paramString.vAh.ntx), paramString.vAh.nty });
      if ((paramString.vAh.CMD != null) && (!bt.isNullOrNil(paramString.vAh.CMD.tfH))) {
        a(paramString);
      }
      for (;;)
      {
        if (paramString.vAh.CMG != 1) {
          break label1624;
        }
        a(null, null, 0);
        break;
        localObject2 = e.dki();
        localObject1 = paramString.vAh.nty;
        paramn = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68029);
            if (bt.iY(((i)paramn).vAh.CMR, 1))
            {
              if (e.dki().dkj()) {
                ad.w("MicroMsg.RemittanceBusiUI", "finish finishRemitF2fDCodeAndLMRemindUI");
              }
              RemittanceBusiUI.this.finish();
            }
            AppMethodBeat.o(68029);
          }
        };
        ad.w("MicroMsg.RemittanceBusiDialogMgr", "showAlert3() msg:%s, title:%s", new Object[] { bt.nullAsNil((String)localObject1), bt.nullAsNil("") });
        localObject2 = (Context)((e)localObject2).cqo.get();
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
        if ((!paramString.vAf.equals(this.vFr.vAf)) || (paramString.cancel))
        {
          paramString.vAe = true;
          ad.e("MicroMsg.RemittanceBusiUI", "ignore this getFavor new coming soon %s", new Object[] { Boolean.valueOf(paramString.cancel) });
          AppMethodBeat.o(68071);
          return true;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramString.vAb.ntx == 0)
          {
            this.vFm.vCd = paramString.vAb.vzS;
            this.vFm.amm(paramString.vAb.vzS.CMi);
            dko();
            paramn = paramString.vAc;
            ad.i("MicroMsg.RemittanceBusiUI", "GetFavorAfterAction %s", new Object[] { paramn });
            if (paramn != null) {
              paramn.eX(this.vFm.djR());
            }
          }
        }
        for (;;)
        {
          paramString.vAe = true;
          AppMethodBeat.o(68071);
          return true;
          this.vFm.djQ();
          this.vEF.setTextColor(getContext().getResources().getColor(2131100212));
          this.vEF.setText(paramString.vAb.nty);
          paramn = paramString.vAd;
          if (paramn != null)
          {
            paramn.a(paramInt1, paramInt2, paramString);
            continue;
            this.vFm.djQ();
            if ((this.vEe != null) && (!bt.isNullOrNil(this.vEe.vzN))) {
              this.vEF.setText(this.vEe.vzN);
            }
            this.vEF.setTextColor(getContext().getResources().getColor(2131100212));
            this.vEF.setText(getString(2131762427));
            paramn = paramString.vAd;
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
          if (paramString.vAm.ntx == 0)
          {
            dkr();
          }
          else
          {
            dkq();
            e.dki().a(paramString.vAm.nty, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
          }
        }
        else {
          e.dki().a(getString(2131765901), new DialogInterface.OnClickListener()
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
  
  final class b
  {
    private float marginTop;
    private View pf;
    private float vFY;
    private float vFZ;
    private TenpaySecureEditText vGa;
    private TextView vGb;
    private RelativeLayout vGc;
    
    b(int paramInt1, int paramInt2, float paramFloat)
    {
      AppMethodBeat.i(68053);
      this.vFY = paramInt1;
      this.vFZ = paramInt2;
      this.marginTop = paramFloat;
      AppMethodBeat.o(68053);
    }
    
    final void update()
    {
      AppMethodBeat.i(68054);
      RemittanceBusiUI.a(RemittanceBusiUI.this).setTextSize(1, this.vFZ);
      RemittanceBusiUI.b(RemittanceBusiUI.this).setTextSize(1, this.vFY);
      if (this.vGb == null) {
        this.vGb = ((TextView)RemittanceBusiUI.c(RemittanceBusiUI.this).findViewById(2131306836));
      }
      if (this.vGb != null) {
        this.vGb.setTextSize(this.vFY);
      }
      if (this.vGa == null) {
        this.vGa = ((TenpaySecureEditText)RemittanceBusiUI.c(RemittanceBusiUI.this).findViewById(2131306718));
      }
      if (this.vGa != null) {
        this.vGa.setTextSize(this.vFZ);
      }
      if (this.pf == null) {
        this.pf = this.vGa.findViewById(2131302445);
      }
      if (this.pf != null) {
        this.pf.setMinimumHeight(BackwardSupportUtil.b.g(RemittanceBusiUI.this, RemittanceBusiUI.d(RemittanceBusiUI.this).vFZ));
      }
      if (this.vGc == null) {
        this.vGc = ((RelativeLayout)RemittanceBusiUI.this.findViewById(2131306754));
      }
      if (this.vGc != null) {
        ((LinearLayout.LayoutParams)this.vGc.getLayoutParams()).topMargin = BackwardSupportUtil.b.g(RemittanceBusiUI.this, this.marginTop);
      }
      AppMethodBeat.o(68054);
    }
  }
  
  final class c
    implements Runnable
  {
    public com.tencent.mm.wallet_core.d.d vGd;
    
    c() {}
    
    public final void run()
    {
      AppMethodBeat.i(68055);
      RemittanceBusiUI.P(RemittanceBusiUI.this).b(this.vGd);
      AppMethodBeat.o(68055);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI
 * JD-Core Version:    0.7.0.1
 */