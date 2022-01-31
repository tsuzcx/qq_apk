package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.fx;
import com.tencent.mm.g.a.fx.a;
import com.tencent.mm.g.a.fy;
import com.tencent.mm.g.b.a.bv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.remittance.model.ac;
import com.tencent.mm.plugin.remittance.model.t;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.plugin.remittance.model.v.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.sn;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.b.c.a;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@com.tencent.mm.ui.base.a(2)
public abstract class RemittanceNewBaseUI
  extends WalletBaseUI
  implements d.a, WcPayKeyboard.a
{
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cb.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ah.getContext(), 270);
  protected int cEU = 0;
  private String czq;
  protected String eaX;
  protected String kEW;
  protected WalletFormView kRl;
  private int mChannel;
  protected String mDesc;
  protected String mName;
  protected int mPayScene;
  protected int mScene;
  protected ScrollView nIO;
  protected String pqF;
  private double qjH;
  private LinearLayout qlA;
  private LinearLayout qlB;
  private TextView qlC;
  private TextView qlD;
  private LinearLayout qlE;
  protected String qlF;
  protected boolean qlG = true;
  protected String qlH;
  private String qlJ;
  protected String qlK;
  protected String qlL = null;
  protected String qlM = null;
  protected int qlN;
  private int qlO;
  protected String qlP;
  protected String qlQ;
  protected String qlR;
  private Map<String, RemittanceNewBaseUI.a> qlS = new HashMap();
  private String qlT;
  protected boolean qlU = false;
  private v qlV;
  private com.tencent.mm.g.b.a.br qlW;
  private boolean qlX = false;
  private com.tencent.mm.sdk.b.c qlY = new RemittanceNewBaseUI.8(this);
  private boolean qlZ = false;
  protected com.tencent.mm.plugin.wallet.a qlj = null;
  protected double qlk;
  protected String qll;
  protected String qlm;
  private int qln = -1;
  protected boolean qlo = false;
  protected String qlp;
  protected ImageView qlq;
  protected TextView qlr;
  protected TextView qls;
  protected TextView qlu;
  protected TextView qlv;
  private TextView qlw;
  private TextView qlx;
  protected TextView qly;
  private LinearLayout qlz;
  private boolean qma = false;
  private boolean qmb = false;
  private boolean qmc = false;
  private sn qmd = null;
  private com.tencent.mm.sdk.b.c qme = new RemittanceNewBaseUI.26(this);
  protected double qmf = 0.0D;
  protected String qmg = "";
  protected String qmh = "";
  protected String qmi = "";
  private com.tencent.mm.sdk.b.c<fy> qmj = new com.tencent.mm.sdk.b.c() {};
  private RelativeLayout qnG;
  private TextView qnH;
  private RelativeLayout qnI;
  private WcPayKeyboard qnK;
  protected int qnV = 4;
  private int qnW;
  
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    c.a locala = new c.a(paramContext);
    locala.avm(paramString2);
    locala.avn(paramString1);
    locala.avs(paramString3).a(paramOnClickListener1);
    locala.avt(paramString4).b(paramOnClickListener2);
    locala.rG(false);
    locala.rH(true);
    paramString1 = locala.aLZ();
    paramString1.show();
    com.tencent.mm.ui.base.h.a(paramContext, paramString1);
  }
  
  private void a(v paramv, sn paramsn)
  {
    this.qlX = true;
    new c(this).a(paramv, paramsn, new RemittanceNewBaseUI.21(this));
  }
  
  private void a(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean)
    {
      if (this.qlU) {
        com.tencent.mm.plugin.report.service.h.qsU.e(15386, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
      }
      String str = paramIntent.getStringExtra("key_trans_id");
      if (bo.isNullOrNil(this.qlT)) {
        this.qlT = str;
      }
      if ((this.mPayScene != 33) && (this.mPayScene != 32)) {
        ac.Yi(this.eaX);
      }
      if (this.qjH == 0.0D)
      {
        if (this.mScene == 1) {
          com.tencent.mm.plugin.report.service.h.qsU.e(12689, new Object[] { Integer.valueOf(17), Integer.valueOf(1) });
        }
      }
      else {
        finish();
      }
    }
    for (;;)
    {
      if (bo.hl(this.qln, 0)) {
        b(paramBoolean, paramIntent);
      }
      do
      {
        return;
        com.tencent.mm.plugin.report.service.h.qsU.e(12689, new Object[] { Integer.valueOf(8), Integer.valueOf(1) });
        break;
        if (com.tencent.mm.plugin.wallet_core.utils.c.av(paramIntent))
        {
          finish();
          return;
        }
      } while (com.tencent.mm.plugin.wallet_core.utils.c.aw(paramIntent));
      if (this.mScene == 1) {
        com.tencent.mm.plugin.report.service.h.qsU.e(12689, new Object[] { Integer.valueOf(16), Integer.valueOf(1) });
      } else {
        com.tencent.mm.plugin.report.service.h.qsU.e(12689, new Object[] { Integer.valueOf(7), Integer.valueOf(1) });
      }
    }
  }
  
  private boolean a(v paramv)
  {
    if (!this.qlZ) {}
    for (boolean bool2 = d(paramv);; bool2 = false)
    {
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.qma) {
          bool1 = e(paramv);
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!this.qmb) {
          bool2 = f(paramv);
        }
      }
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.qmc) {
          bool1 = c(paramv);
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!bo.isNullOrNil(paramv.qjO))
        {
          bool2 = bool1;
          if (!bo.isNullOrNil(paramv.qjP))
          {
            String str2 = com.tencent.mm.wallet_core.ui.e.eZ(com.tencent.mm.wallet_core.ui.e.nE(this.eaX), 10);
            String str1 = str2;
            if (!bo.isNullOrNil(this.qlK)) {
              str1 = getString(2131302534, new Object[] { str2, this.qlK });
            }
            bool2 = a(paramv.cwk, paramv.qjP, str1, paramv.qjO, paramv);
          }
        }
      }
      return bool2;
    }
  }
  
  private boolean a(final String paramString1, String paramString2, String paramString3, String paramString4, final v paramv)
  {
    View localView = LayoutInflater.from(this).inflate(2130970579, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131827352);
    TextView localTextView2 = (TextView)localView.findViewById(2131827353);
    TextView localTextView3 = (TextView)localView.findViewById(2131827354);
    localTextView1.setText(paramString2);
    localTextView2.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this, paramString3, localTextView2.getTextSize()));
    double d = bo.getDouble(paramString4, 0.0D);
    localTextView3.setText(String.format("%s%.2f", new Object[] { ae.dSz(), Double.valueOf(Double.valueOf(d).doubleValue() / 100.0D) }));
    paramString2 = new c.a(this);
    paramString2.rG(false);
    paramString2.Rb(2131302624);
    paramString2.fu(localView);
    paramString2.Ri(2131302540);
    paramString2.Rj(2131297827);
    paramString2.a(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(142252);
        RemittanceNewBaseUI.t(RemittanceNewBaseUI.this);
        RemittanceNewBaseUI.this.a(paramString1, RemittanceNewBaseUI.this.eaX, RemittanceNewBaseUI.this.qlK, paramv);
        AppMethodBeat.o(142252);
      }
    });
    paramString2.aLZ().show();
    return true;
  }
  
  private void aY(int paramInt, String paramString)
  {
    this.qlW = new com.tencent.mm.g.b.a.br();
    this.qlW.cRG = 2L;
    this.qlW.cRH = paramInt;
    this.qlW.gQ(paramString);
    this.qlW.ake();
  }
  
  private void b(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean) {
      this.cEU = 1;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RemittanceNewBaseUI", "savePayInfoInReRemittanceUI() mLastPayResult:%s mlastTotalFee:%s mLastDesc:%s mLastAddress:%s mLastTransferId:%s", new Object[] { Integer.valueOf(this.cEU), Double.valueOf(this.qmf), this.qmg, this.qmh, this.qmi });
      do
      {
        return;
      } while (paramIntent == null);
      this.cEU = paramIntent.getIntExtra("key_pay_reslut_type", 3);
      this.qmf = this.qlk;
      this.qmg = this.mDesc;
      this.qmh = this.qlF;
      this.qmi = this.qlT;
    }
  }
  
  private static boolean b(v paramv)
  {
    return ((paramv.qjZ == 1) && (paramv.qka != null)) || ((paramv.qka != null) && (paramv.qka.wKU > 0));
  }
  
  private boolean c(final v paramv)
  {
    if ((paramv.cHz != null) && (paramv.cHz.cTd()))
    {
      this.qmc = true;
      com.tencent.mm.ui.base.h.d(this, paramv.cHz.cyA, "", paramv.cHz.opD, paramv.cHz.opC, new DialogInterface.OnClickListener()new RemittanceNewBaseUI.10
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(142234);
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RemittanceNewBaseUI", "goto h5: %s", new Object[] { paramv.cHz.kNB });
          com.tencent.mm.wallet_core.ui.e.m(RemittanceNewBaseUI.this.getContext(), paramv.cHz.kNB, false);
          AppMethodBeat.o(142234);
        }
      }, new RemittanceNewBaseUI.10(this));
      return true;
    }
    return false;
  }
  
  private void chi()
  {
    if ((chn()) && (!bo.isNullOrNil(this.qlM)) && (this.qlO != 0) && (this.qlN == 1))
    {
      addIconOptionMenu(0, 2130840873, new RemittanceNewBaseUI.34(this));
      return;
    }
    removeAllOptionMenu();
  }
  
  private void chj()
  {
    int i;
    if ((!bo.isNullOrNil(this.qlL)) && (this.qlO != 0))
    {
      if (this.qlO == 1) {}
      for (i = 2;; i = 24) {
        try
        {
          this.qnK.setTipText(String.format(this.qlL, new Object[] { Integer.valueOf(i) }));
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RemittanceNewBaseUI", "updatePlaceHolderTv() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          this.qnK.setTipText(getString(2131302590, new Object[] { Integer.valueOf(i) }));
          return;
        }
      }
    }
    this.qnK.cLy();
  }
  
  private void chm()
  {
    RemittanceNewBaseUI.3 local3 = new RemittanceNewBaseUI.3(this);
    if (al.isMainThread())
    {
      local3.run();
      return;
    }
    al.d(new RemittanceNewBaseUI.4(this, local3));
  }
  
  private boolean d(v paramv)
  {
    if (!bo.isNullOrNil(paramv.qjB))
    {
      this.qlZ = true;
      aY(1, paramv.cyr);
      com.tencent.mm.ui.base.h.d(this, paramv.qjB, getString(2131297056), getString(2131302540), getString(2131296888), new RemittanceNewBaseUI.11(this, paramv), new RemittanceNewBaseUI.13(this, paramv));
      return true;
    }
    return false;
  }
  
  private boolean e(v paramv)
  {
    boolean bool = false;
    String str1;
    String str2;
    if (paramv.qjz > 0)
    {
      this.qma = true;
      if (paramv.qjA == null) {
        break label143;
      }
      if (!bo.isNullOrNil(paramv.qjA.cyA)) {
        break label120;
      }
      str1 = getString(2131302611, new Object[] { Integer.valueOf(paramv.qjz) });
      String str3 = getString(2131302540);
      if (!bo.isNullOrNil(paramv.qjA.qkb)) {
        break label131;
      }
      str2 = getString(2131302599);
      label87:
      a(this, str1, "", str3, str2, new RemittanceNewBaseUI.14(this, paramv), new RemittanceNewBaseUI.15(this, paramv));
    }
    for (;;)
    {
      bool = true;
      return bool;
      label120:
      str1 = paramv.qjA.cyA;
      break;
      label131:
      str2 = paramv.qjA.qkb;
      break label87;
      label143:
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RemittanceNewBaseUI", "scene.zaituMessage == null");
      a(this, getString(2131302611, new Object[] { Integer.valueOf(paramv.qjz) }), getString(2131297056), getString(2131302540), getString(2131302599), new RemittanceNewBaseUI.16(this, paramv), new RemittanceNewBaseUI.17(this));
    }
  }
  
  private boolean f(v paramv)
  {
    if (paramv.qjG)
    {
      this.qmb = true;
      f.a(this, this.mScene, paramv.qjJ / 100.0D, paramv.qjI / 100.0D, paramv.qjD / 100.0D, paramv.qjF, new RemittanceNewBaseUI.18(this, paramv));
      return true;
    }
    return false;
  }
  
  private void kw(boolean paramBoolean)
  {
    this.qnK.rP(paramBoolean);
  }
  
  private static void saveRemittanceMsg(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.RemittanceNewBaseUI", "msgxml is null");
      return;
    }
    paramString = URLDecoder.decode(paramString);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RemittanceNewBaseUI", "helios:".concat(String.valueOf(paramString)));
    String str = (String)com.tencent.mm.sdk.platformtools.br.F(paramString, "msg").get(".msg.appmsg.wcpayinfo.transferid");
    if (TextUtils.isEmpty(str))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.RemittanceNewBaseUI", "paymsgid count't be null in appmsg");
      return;
    }
    com.tencent.mm.plugin.remittance.a.c.cgH().cgK().fX(str, paramString);
  }
  
  public abstract void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, fx paramfx);
  
  protected final void a(String paramString1, String paramString2, String paramString3, v paramv)
  {
    if (b(paramv))
    {
      if (paramv.qka.wKU == 0)
      {
        this.qmd = paramv.qka;
        a(paramv, paramv.qka);
      }
      do
      {
        return;
        if (paramv.qka.wKU == 1)
        {
          localObject1 = new bv();
          ((bv)localObject1).cYX = ((int)paramv.qjN);
          localObject1 = ((bv)localObject1).gR(paramv.username);
          ((bv)localObject1).cYR = 4L;
          ((bv)localObject1).ake();
          com.tencent.mm.ui.base.h.a(this, paramv.qka.cyA, paramv.qka.title, getResources().getString(2131302634), getResources().getString(2131302633), new RemittanceNewBaseUI.22(this, paramv, paramString1, paramString2, paramString3), new RemittanceNewBaseUI.24(this, paramv), 2131690370);
          return;
        }
      } while (paramv.qka.wKU != 2);
      com.tencent.mm.ui.base.h.a(this, paramv.qka.cyA, paramv.qka.title, getResources().getString(2131305958), new RemittanceNewBaseUI.25(this));
      return;
    }
    if (this.qlX)
    {
      localObject1 = new bv();
      ((bv)localObject1).cYX = paramv.okH;
      localObject1 = ((bv)localObject1).gR(paramv.username);
      ((bv)localObject1).cYR = 5L;
      ((bv)localObject1).ake();
    }
    this.qlX = false;
    if (this.mPayScene == 31) {
      saveRemittanceMsg(this.qlJ);
    }
    Object localObject1 = new PayInfo();
    ((PayInfo)localObject1).cnI = paramString1;
    ((PayInfo)localObject1).cCD = this.mPayScene;
    if (this.mChannel > 0) {
      ((PayInfo)localObject1).cCy = this.mChannel;
    }
    boolean bool = false;
    if ((this.mScene == 2) || (this.mScene == 5)) {
      bool = true;
    }
    paramString1 = new Bundle();
    paramString1.putString("extinfo_key_1", paramString2);
    paramString1.putString("extinfo_key_2", getIntent().getStringExtra("receiver_true_name"));
    paramString1.putString("extinfo_key_3", this.qlH);
    paramString1.putBoolean("extinfo_key_4", bool);
    paramString1.putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
    paramString1.putString("extinfo_key_6", getIntent().getStringExtra("payer_desc"));
    paramString1.putString("extinfo_key_7", this.mDesc);
    paramString1.putString("extinfo_key_8", getIntent().getStringExtra("rcvr_new_desc"));
    paramString1.putString("extinfo_key_16", this.qlT);
    if (paramv != null) {
      paramString1.putString("extinfo_key_19", paramv.qjX);
    }
    int j = 0;
    int i = j;
    if (this.mScene == 1)
    {
      i = j;
      if (paramv != null)
      {
        paramString1.putString("extinfo_key_11", paramv.qjL);
        paramString1.putInt("extinfo_key_12", paramv.qjR);
        paramString1.putString("extinfo_key_13", paramv.qjS);
        paramString1.putString("extinfo_key_14", paramv.qjT);
        paramString1.putString("extinfo_key_17", paramv.qjV);
        paramString1.putString("extinfo_key_18", paramv.qjW);
        i = paramv.qjU;
      }
    }
    if (paramv != null) {
      paramString1.putInt("extinfo_key_15", paramv.okH);
    }
    if (this.qlo)
    {
      paramString1.putBoolean("extinfo_key_23", this.qlo);
      paramString1.putString("extinfo_key_24", this.mName);
      paramString1.putString("extinfo_key_25", this.pqF);
      paramString1.putString("extinfo_key_26", this.qlF);
    }
    ((PayInfo)localObject1).wgv = paramString1;
    paramString1 = new Intent();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RemittanceNewBaseUI", "dynamic code flag: %s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      paramString1.setClass(this, RemittanceF2fDynamicCodeUI.class);
      paramString1.putExtra("key_pay_info", (Parcelable)localObject1);
      paramString1.putExtra("key_rcvr_open_id", this.qlP);
      paramString1.putExtra("key_mch_info", this.qlm);
      paramString1.putExtra("from_patch_ui", true);
      paramString1.putExtra("get_dynamic_code_sign", paramv.qjV);
      paramString1.putExtra("get_dynamic_code_extend", paramv.qjW);
      paramString1.putExtra("dynamic_code_spam_wording", paramv.qjY);
      paramString1.putExtra("show_paying_wording", paramv.qjX);
      paramString1.putExtra("key_transfer_qrcode_id", this.qlp);
      com.tencent.mm.plugin.report.service.h.qsU.e(15386, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      this.qme.alive();
      startActivityForResult(paramString1, 5);
      return;
    }
    if (this.mKindaEnable)
    {
      paramv = "";
      paramString3 = "";
      Object localObject2 = getString(2131305531);
      if (!bo.isNullOrNil(paramString2))
      {
        g.RM();
        paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().aru(paramString2);
        if (paramString1 != null)
        {
          paramString3 = paramString1.Of();
          paramv = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.awj(paramString3));
          if (bo.isNullOrNil(this.qlK))
          {
            paramString1 = "";
            paramString1 = paramString1;
            paramv = bo.p((String)localObject2, new Object[] { paramString1 });
            paramString3 = getString(2131302619, new Object[] { com.tencent.mm.wallet_core.ui.e.awj(paramString3) });
          }
        }
      }
      for (;;)
      {
        if (((PayInfo)localObject1).wgv == null) {
          ((PayInfo)localObject1).wgv = new Bundle();
        }
        localObject2 = ((PayInfo)localObject1).wgv;
        ((Bundle)localObject2).putString("extinfo_key_1", paramString2);
        ((Bundle)localObject2).putString("extinfo_key_2", this.qlK);
        ((Bundle)localObject2).putString("cashier_desc", paramv);
        ((Bundle)localObject2).putString("prepay_page_payee", paramString1);
        ((Bundle)localObject2).putString("succ_tip", paramString3);
        ((com.tencent.mm.pluginsdk.wallet.b)g.E(com.tencent.mm.pluginsdk.wallet.b.class)).startSNSPay(this, (PayInfo)localObject1);
        return;
        paramString1 = "(" + this.qlK + ")";
        break;
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.RemittanceNewBaseUI", "can not found contact for user::".concat(String.valueOf(paramString2)));
        paramString1 = "";
        continue;
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.RemittanceNewBaseUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        paramString1 = "";
      }
    }
    hideLoading();
    com.tencent.mm.plugin.wallet.a.a(this.qlj, paramString1);
    ((PayInfo)localObject1).wgD = this.czq;
    ((PayInfo)localObject1).axV = this.qlU;
    if ((paramv.qjk != null) && (paramv.qjk.cul.cup != null))
    {
      com.tencent.mm.pluginsdk.wallet.h.a(paramv.qjk.cul.cup, false, "", (PayInfo)localObject1, paramString3, paramString1, paramv.qjk.cul.cun);
      return;
    }
    com.tencent.mm.pluginsdk.wallet.h.a(this, false, "", (PayInfo)localObject1, paramString3, paramString1, 1);
  }
  
  public final void aV(float paramFloat) {}
  
  public abstract void chA();
  
  public final void chf()
  {
    t localt = new t(this.eaX, this.qlp);
    localt.setProcessName("RemittanceProcess");
    doSceneProgress(localt);
  }
  
  public abstract void chh();
  
  public abstract void chk();
  
  protected final void chl()
  {
    Object localObject1 = com.tencent.mm.wallet_core.ui.e.eZ(com.tencent.mm.wallet_core.ui.e.nE(this.eaX), 10);
    Object localObject2 = localObject1;
    if (!bo.isNullOrNil(this.qlK)) {
      localObject2 = getString(2131302534, new Object[] { localObject1, this.qlK });
    }
    if (this.mScene == 1)
    {
      localObject2 = getIntent().getStringExtra("receiver_tips");
      this.qlr.setTextColor(getResources().getColor(2131689763));
      this.qls.setVisibility(0);
      if (bo.isNullOrNil(this.eaX))
      {
        localObject1 = getString(2131302537, new Object[] { this.qlK });
        this.qls.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject1, this.qls.getTextSize()));
        localObject1 = localObject2;
        label152:
        this.qlr.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject1, this.qlr.getTextSize()));
        if (!g.RG()) {
          break label374;
        }
        localObject1 = o.adg();
        if ((localObject1 == null) || (bo.isNullOrNil(this.eaX))) {
          break label374;
        }
        localObject1 = ((i)localObject1).rj(this.eaX);
        if ((localObject1 != null) && (!bo.isNullOrNil(((com.tencent.mm.ah.h)localObject1).acY()))) {
          break label374;
        }
        long l = bo.aoy();
        ao.a.flI.a(this.eaX, "", new RemittanceNewBaseUI.2(this, l));
      }
    }
    label374:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        chm();
      }
      return;
      localObject1 = getString(2131302536, new Object[] { com.tencent.mm.wallet_core.ui.e.eZ(com.tencent.mm.wallet_core.ui.e.nE(this.eaX), 10), this.qlK });
      break;
      localObject1 = localObject2;
      if (this.mScene != 6) {
        break label152;
      }
      localObject1 = getIntent().getStringExtra("receiver_tips");
      if (bo.isNullOrNil((String)localObject1))
      {
        localObject1 = getString(2131302535, new Object[] { localObject2 });
        break label152;
      }
      localObject1 = bo.p((String)localObject1, new Object[] { localObject2 });
      break label152;
    }
  }
  
  protected final boolean chn()
  {
    return (this.mScene == 0) || (this.mScene == 2);
  }
  
  protected final void cho()
  {
    if (this.mPayScene == 33)
    {
      a(this.mDesc, this.qln, this.mName, this.pqF, this.qlF, this.qlH, "", null);
      return;
    }
    a(this.mDesc, this.qln, this.mName, this.pqF, this.qlF, null, "", null);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130970576;
  }
  
  public void initView()
  {
    hideActionbarLine();
    if ((this.mPayScene == 33) || (this.mPayScene == 32))
    {
      setMMTitle(2131302530);
      setBackBtn(new RemittanceNewBaseUI.1(this));
      this.mKeyboard = ((MyKeyboardWindow)findViewById(2131822419));
      this.mKBLayout = findViewById(2131822418);
      this.nIO = ((ScrollView)findViewById(2131820898));
      this.qlq = ((ImageView)findViewById(2131827308));
      this.qlr = ((TextView)findViewById(2131827309));
      this.qls = ((TextView)findViewById(2131827310));
      this.qls.setVisibility(8);
      this.qlA = ((LinearLayout)findViewById(2131827311));
      this.qlz = ((LinearLayout)findViewById(2131827312));
      this.qlx = ((TextView)findViewById(2131827315));
      this.qly = ((TextView)findViewById(2131827314));
      this.qlw = ((TextView)findViewById(2131827313));
      this.qlB = ((LinearLayout)findViewById(2131827255));
      this.qlC = ((TextView)findViewById(2131827258));
      this.qlD = ((TextView)findViewById(2131827259));
      chl();
      this.kRl = ((WalletFormView)findViewById(2131822910));
      if (this.mPayScene != 33) {
        break label755;
      }
      this.qlx.setText(com.tencent.mm.wallet_core.ui.e.E(this.qlk));
      this.qly.setText(ae.dSz());
      this.qlH = getIntent().getStringExtra("desc");
      if (bo.isNullOrNil(this.qlH)) {
        break label743;
      }
      this.qlw.setText(com.tencent.mm.pluginsdk.ui.d.j.b(getContext(), this.qlH, this.qlw.getTextSize()));
      this.qlw.setVisibility(0);
      label351:
      this.qlz.setVisibility(0);
      this.qlA.setVisibility(8);
      label368:
      RemittanceNewBaseUI.12 local12 = new RemittanceNewBaseUI.12(this);
      this.kRl.getContentEt().setOnEditorActionListener(new RemittanceNewBaseUI.23(this, local12));
      this.qlu = ((TextView)findViewById(2131822912));
      this.qlv = ((TextView)findViewById(2131827316));
      if ((this.mScene != 1) && (this.mScene != 6)) {
        break label939;
      }
      this.qlv.setText(2131302515);
      label451:
      if (!r.ZB())
      {
        findViewById(2131822911).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(142261);
            RemittanceNewBaseUI.this.showCircleStWcKb();
            RemittanceNewBaseUI.chB();
            com.tencent.mm.plugin.report.service.h.qsU.e(12689, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
            Object localObject;
            if ((RemittanceNewBaseUI.this.mScene == 1) || (RemittanceNewBaseUI.this.mScene == 6))
            {
              localObject = RemittanceNewBaseUI.this.getString(2131302515);
              paramAnonymousView = RemittanceNewBaseUI.this.getString(2131302541);
              com.tencent.mm.plugin.report.service.h.qsU.e(14074, new Object[] { Integer.valueOf(1) });
            }
            String str1;
            String str2;
            do
            {
              do
              {
                com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceNewBaseUI.this, (String)localObject, RemittanceNewBaseUI.this.mDesc, paramAnonymousView, 20, new RemittanceNewBaseUI.29.3(this), new RemittanceNewBaseUI.29.4(this));
                AppMethodBeat.o(142261);
                return;
                str1 = RemittanceNewBaseUI.this.getString(2131302514);
                str2 = RemittanceNewBaseUI.this.getString(2131302520);
                localObject = str1;
                paramAnonymousView = str2;
              } while (!bo.hl(RemittanceNewBaseUI.a(RemittanceNewBaseUI.this), 0));
              localObject = str1;
              paramAnonymousView = str2;
            } while (!RemittanceNewBaseUI.this.qlo);
            com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceNewBaseUI.this, str1, RemittanceNewBaseUI.this.mDesc, str2, RemittanceNewBaseUI.this.qlG, RemittanceNewBaseUI.this.mName, RemittanceNewBaseUI.this.pqF, RemittanceNewBaseUI.this.qlF, new RemittanceNewBaseUI.29.1(this), new RemittanceNewBaseUI.29.2(this));
            AppMethodBeat.o(142261);
          }
        });
        if (bo.hl(this.qln, 0))
        {
          this.qnI = ((RelativeLayout)findViewById(2131827223));
          if ((!aa.dsG().equals("zh_CN")) && (!aa.dsG().equals("zh_TW")) && (!aa.dsG().equals("zh_HK"))) {
            break label952;
          }
          this.qnG = ((RelativeLayout)findViewById(2131827224));
          this.qnH = ((TextView)findViewById(2131827225));
          this.qnG.post(new RemittanceNewBaseUI.30(this));
          this.kRl.setmWalletFormViewListener(new RemittanceNewBaseUI.31(this));
        }
      }
    }
    for (;;)
    {
      if (this.mScene == 1)
      {
        g.RM();
        if (((String)g.RL().Ru().get(327732, "0")).equals("0"))
        {
          com.tencent.mm.ui.base.h.a(getContext(), 2131302584, 2131302585, new RemittanceNewBaseUI.32(this));
          g.RM();
          g.RL().Ru().set(327732, "1");
          g.RM();
          g.RL().Ru().dww();
        }
      }
      this.qlE = ((LinearLayout)findViewById(2131822909));
      chj();
      chk();
      chi();
      if ((this.mPayScene != 33) && (this.mPayScene != 32)) {
        break label964;
      }
      return;
      setMMTitle(2131302629);
      break;
      label743:
      this.qlw.setVisibility(8);
      break label351;
      label755:
      this.kRl.setOnClickListener(new RemittanceNewBaseUI.5(this));
      this.kRl.getTitleTv().setText(String.format(getString(2131302580), new Object[] { "¥" }));
      this.kRl.a(new RemittanceNewBaseUI.6(this));
      this.kRl.dTb();
      this.qnK = ((WcPayKeyboard)findViewById(2131829492));
      kw(false);
      setWPKeyboard(this.kRl.getContentEt(), true, false);
      setWcKbHeightListener(this);
      this.qnK.setActionText(getString(2131302598));
      ((RelativeLayout.LayoutParams)this.qnK.getLayoutParams()).addRule(12);
      findViewById(2131827317);
      findViewById(2131822909).setVisibility(0);
      this.qlz.setVisibility(8);
      this.qlA.setVisibility(0);
      setTenpayKBStateListener(new RemittanceNewBaseUI.7(this));
      break label368;
      label939:
      this.qlv.setText(2131302514);
      break label451;
      label952:
      this.qnI.setVisibility(8);
    }
    label964:
    this.nIO.setOnTouchListener(new RemittanceNewBaseUI.33(this));
  }
  
  public boolean needLockPage()
  {
    return (this.mPayScene == 33) || (this.mPayScene == 32);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RemittanceNewBaseUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + this.eaX);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      bool1 = bool2;
      if (paramInt2 == -1) {
        bool1 = true;
      }
      a(bool1, paramIntent);
      continue;
      if (paramInt2 == -1) {}
      for (;;)
      {
        a(bool1, paramIntent);
        break;
        bool1 = false;
      }
      String str1;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        str1 = paramIntent.getStringExtra("Select_Conv_User");
        if (!bo.isNullOrNil(str1))
        {
          this.eaX = str1;
          chl();
        }
        else
        {
          finish();
        }
      }
      else
      {
        finish();
        continue;
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          hideWcKb();
          str1 = getString(2131297508);
          String str2 = getString(2131302541);
          String str3 = paramIntent.getStringExtra("userName");
          String str4 = paramIntent.getStringExtra("telNumber");
          String str5 = paramIntent.getStringExtra("proviceFirstStageName") + paramIntent.getStringExtra("addressCitySecondStageName") + paramIntent.getStringExtra("addressCountiesThirdStageName") + paramIntent.getStringExtra("addressDetailInfo");
          com.tencent.mm.plugin.wallet_core.ui.view.a.a(this, str1, this.mDesc, str2, false, str3, str4, str5, new RemittanceNewBaseUI.19(this), new RemittanceNewBaseUI.20(this));
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mScene = getIntent().getIntExtra("scene", 0);
    this.mPayScene = getIntent().getIntExtra("pay_scene", 31);
    if (!chn())
    {
      this.czq = UUID.randomUUID().toString();
      com.tencent.mm.plugin.wallet.pay.a.b.aeZ(this.czq);
    }
    if ((this instanceof RemittanceUI)) {
      this.qln = 0;
    }
    super.onCreate(paramBundle);
    this.qlj = com.tencent.mm.plugin.wallet.a.as(getIntent());
    this.qlp = getIntent().getStringExtra("scan_remittance_id");
    this.qlk = getIntent().getDoubleExtra("fee", 0.0D);
    this.eaX = getIntent().getStringExtra("receiver_name");
    this.kEW = getIntent().getStringExtra("receiver_nick_name");
    this.qlK = getIntent().getStringExtra("receiver_true_name");
    this.qll = getIntent().getStringExtra("mch_name");
    this.qlm = getIntent().getStringExtra("mch_info");
    this.mChannel = getIntent().getIntExtra("pay_channel", 0);
    this.qlP = bo.bf(getIntent().getStringExtra("rcvr_open_id"), "");
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RemittanceNewBaseUI", "mUserName %s", new Object[] { this.eaX });
    g.RM();
    long l = ((Long)g.RL().Ru().get(147457, Long.valueOf(0L))).longValue();
    if ((0x10 & l) != 0L)
    {
      this.qlO = 1;
      chA();
      o.acQ().a(this);
      initView();
      this.qmj.alive();
      com.tencent.mm.wallet_core.b.dRI();
      if ((!com.tencent.mm.wallet_core.b.dpQ()) || (!((com.tencent.mm.pluginsdk.wallet.b)g.E(com.tencent.mm.pluginsdk.wallet.b.class)).kindaCacheServiceGetBool("NEW_CASHIER_TRANSFER_PAY_SWTICH_KEY"))) {
        break label367;
      }
    }
    label367:
    for (boolean bool = true;; bool = false)
    {
      this.mKindaEnable = bool;
      return;
      if ((l & 0x20) != 0L)
      {
        this.qlO = 2;
        break;
      }
      this.qlO = 0;
      break;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.sdk.b.a.ymk.d(this.qlY);
    o.acQ().b(this);
    this.qmj.dead();
    this.qme.dead();
    com.tencent.mm.plugin.wallet.pay.a.b.afa(this.czq);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.qnK != null) && (this.qnK.onKeyUp(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    this.qlR = "";
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof v))
      {
        paramm = (v)paramm;
        com.tencent.mm.wallet_core.c.ad.q(this.mPayScene, paramm.cwk, paramInt2);
        this.qlJ = paramm.qjC;
        if (!bo.isNullOrNil(paramm.qjK)) {
          this.qlK = paramm.qjK;
        }
        if ((this.mPayScene == 32) || (this.mPayScene == 33))
        {
          this.qlT = paramm.kMN;
          if (this.qlj != null) {
            this.qlj.j(10000, new Object[] { Integer.valueOf(this.mPayScene), this.eaX, Double.valueOf(paramm.qjN) });
          }
          if (paramm.qka != null) {
            break label278;
          }
          paramString = "";
          label158:
          this.qlQ = paramString;
          if (a(paramm)) {
            break label312;
          }
          a(paramm.cwk, this.eaX, this.qlK, paramm);
          label191:
          paramString = new RemittanceNewBaseUI.a(paramm.qjL, paramm.kMN, paramm.kPg, paramm.qjM, paramm.okH, paramm.cyr, paramm.cnJ, paramm.qjQ, bo.getLong(paramm.qjO, 0L));
          this.qlS.put(paramm.cwk, paramString);
        }
      }
      for (;;)
      {
        return true;
        this.qlT = paramm.cyr;
        break;
        label278:
        if (bo.isNullOrNil(paramm.qka.qlQ))
        {
          paramString = this.qlQ;
          break label158;
        }
        paramString = paramm.qka.qlQ;
        break label158;
        label312:
        if (!this.mKindaEnable) {
          break label191;
        }
        hideLoading();
        break label191;
        if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ah))
        {
          this.qlL = ((com.tencent.mm.plugin.wallet_core.c.ah)paramm).ucf;
          this.qlM = ((com.tencent.mm.plugin.wallet_core.c.ah)paramm).ucj;
          this.qlN = ((com.tencent.mm.plugin.wallet_core.c.ah)paramm).uck;
          chj();
          chi();
        }
      }
    }
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ah))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RemittanceNewBaseUI", "net error, use hardcode wording");
      this.mWcKeyboard.cLy();
    }
    do
    {
      do
      {
        return false;
      } while (!(paramm instanceof v));
      if (this.mKindaEnable) {
        hideLoading();
      }
      this.qlV = ((v)paramm);
      com.tencent.mm.sdk.b.a.ymk.b(this.qlY);
      com.tencent.mm.wallet_core.c.ad.q(this.mPayScene, "", paramInt2);
    } while (!c((v)paramm));
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void re(String paramString)
  {
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RemittanceNewBaseUI", "onGet");
    if (bo.nullAsNil(paramString).length() <= 0) {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.RemittanceNewBaseUI", "notifyChanged: user = ".concat(String.valueOf(paramString)));
    }
    while (!paramString.equals(this.eaX)) {
      return;
    }
    chm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI
 * JD-Core Version:    0.7.0.1
 */