package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.fx;
import com.tencent.mm.g.a.fx.a;
import com.tencent.mm.g.b.a.br;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.i;
import com.tencent.mm.plugin.remittance.model.k;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.adg;
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.protocal.protobuf.ccm;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.protocal.protobuf.cz;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.protocal.protobuf.mm;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.protocal.protobuf.mq;
import com.tencent.mm.protocal.protobuf.mw;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.picker.d.2;
import com.tencent.mm.ui.widget.picker.d.3;
import com.tencent.mm.ui.widget.picker.d.a;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
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
  private int cEU;
  private double cnL;
  private int cun;
  private String czq;
  private int mChannel;
  private int mPayScene;
  private ScrollView nIO;
  private String plc;
  private LinearLayout qlA;
  private String qlP;
  private boolean qlU;
  private br qlW;
  private boolean qlZ;
  private String qll;
  private String qmN;
  private String qmO;
  private String qmS;
  private BusiRemittanceResp qmW;
  private boolean qmc;
  private com.tencent.mm.sdk.b.c qme;
  private LinearLayout qnA;
  private LinearLayout qnB;
  private TextView qnC;
  private View qnD;
  private TextView qnE;
  private Button qnF;
  private RelativeLayout qnG;
  private TextView qnH;
  private RelativeLayout qnI;
  private RelativeLayout qnJ;
  private WcPayKeyboard qnK;
  private String qnL;
  private double qnM;
  private String qnN;
  private String qnO;
  private String qnP;
  private String qnQ;
  private String qnR;
  private int qnS;
  private String qnT;
  private float qnU;
  private int qnV;
  private int qnW;
  private boolean qnX;
  private String qnY;
  private int qnZ;
  private TextView qnq;
  private TextView qnr;
  private TextView qns;
  private TextView qnt;
  private TextView qnu;
  private TextView qnv;
  private TextView qnw;
  private View qnx;
  private CdnImageView qny;
  private WalletFormView qnz;
  private String qoA;
  private String qoB;
  private com.tencent.mm.sdk.b.c qoC;
  private com.tencent.mm.sdk.b.c qoD;
  private com.tencent.mm.sdk.b.c qoE;
  private int qoa;
  private String qob;
  private ckm qoc;
  private String qod;
  private int qoe;
  private int qof;
  private int qog;
  private int qoh;
  private String qoi;
  private String qoj;
  private b qok;
  private String qol;
  private String qom;
  boolean qon;
  private boolean qoo;
  com.tencent.mm.plugin.remittance.model.g qop;
  private RemittanceBusiUI.a qoq;
  private RemittanceBusiUI.a qor;
  private Map<String, cz> qos;
  private RemittanceF2fDynamicCodeUI qot;
  private Runnable qou;
  private com.tencent.mm.wallet_core.d.c<com.tencent.mm.plugin.remittance.model.l> qov;
  private RemittanceBusiUI.b qow;
  private com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.al> qox;
  private boolean qoy;
  private double qoz;
  
  public RemittanceBusiUI()
  {
    AppMethodBeat.i(44933);
    this.qnU = 0.0F;
    this.qnV = 4;
    this.qoe = 0;
    this.qof = 0;
    this.qog = 0;
    this.qoh = 0;
    this.qok = new b();
    this.qol = "";
    this.qom = "";
    this.qon = false;
    this.cnL = -1.0D;
    this.qoo = false;
    this.qop = null;
    this.qlU = false;
    this.cun = 0;
    this.qos = new HashMap();
    this.qot = null;
    this.qou = new RemittanceBusiUI.13(this);
    this.qov = new com.tencent.mm.wallet_core.d.c()
    {
      public final void a(com.tencent.mm.wallet_core.d.d paramAnonymousd)
      {
        AppMethodBeat.i(142187);
        if ((paramAnonymousd instanceof com.tencent.mm.plugin.remittance.model.l)) {
          RemittanceBusiUI.b(RemittanceBusiUI.this, ((com.tencent.mm.plugin.remittance.model.l)paramAnonymousd).cnI);
        }
        AppMethodBeat.o(142187);
      }
    };
    this.qow = new RemittanceBusiUI.b(this);
    this.qox = new RemittanceBusiUI.18(this);
    this.qoy = true;
    this.cEU = 0;
    this.qoz = 0.0D;
    this.qoB = "";
    this.qme = new RemittanceBusiUI.24(this);
    this.qoC = new RemittanceBusiUI.25(this);
    this.qoD = new RemittanceBusiUI.26(this);
    this.qoE = new RemittanceBusiUI.27(this);
    AppMethodBeat.o(44933);
  }
  
  private void Ym(String paramString)
  {
    AppMethodBeat.i(44958);
    ab.i("MicroMsg.RemittanceBusiUI", "do pay check: %s", new Object[] { paramString });
    paramString = (cz)this.qos.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(44958);
      return;
    }
    if (!bo.isNullOrNil(this.plc)) {
      paramString.wpq = this.plc;
    }
    doSceneProgress(new com.tencent.mm.plugin.remittance.model.h(paramString, this.qol), false);
    AppMethodBeat.o(44958);
  }
  
  private void a(int paramInt, mk parammk, boolean paramBoolean, fx paramfx, String paramString1, String paramString2)
  {
    AppMethodBeat.i(44949);
    int i = 0;
    int j = 0;
    if (!this.qoy)
    {
      boolean bool1 = bo.z(Double.valueOf(this.qoz), Double.valueOf(this.qnM));
      boolean bool2 = bo.isEqual(this.qoA, this.qmO);
      if (!bool1) {
        j = 1;
      }
      i = j;
      if (!bool2) {
        i = j | 0x2;
      }
    }
    String str1 = this.qlP;
    String str2 = this.qnL;
    j = this.mPayScene;
    String str3 = this.qnQ;
    String str4 = this.qmO;
    int k = this.mChannel;
    String str5 = this.qnR;
    String str6 = this.qnY;
    int m = this.qoa;
    int n = this.qnZ;
    String str7 = this.qnN;
    adg localadg = this.qok.qkU;
    if (parammk == null)
    {
      parammk = "";
      parammk = new i(str1, str2, j, str3, str4, paramInt, k, str5, str6, m, n, str7, localadg, parammk, this.qmW.qiP, paramString1, this.qll, paramString2, this.qnO, this.qoB, this.cEU, i);
      if (paramBoolean)
      {
        parammk.qjk = paramfx;
        paramString1 = (mp)parammk.goo.fsV.fta;
        if (paramfx.cul.cuo != 1) {
          break label326;
        }
        paramInt = 1;
        label258:
        paramString1.wBi = paramInt;
      }
      if ((!this.mKindaEnable) || (!((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.b.class)).kindaCacheServiceGetBool("NEW_CASHIER_QRCODE_RECEIVE_PAY_SWTICH_KEY"))) {
        break label338;
      }
      if (this.qot == null) {
        break label331;
      }
      this.qot.showSafeProgress();
    }
    for (;;)
    {
      doSceneProgress(parammk, false);
      AppMethodBeat.o(44949);
      return;
      parammk = parammk.wAV;
      break;
      label326:
      paramInt = 0;
      break label258;
      label331:
      showLoading();
    }
    label338:
    doSceneProgress(parammk, true);
    AppMethodBeat.o(44949);
  }
  
  private void a(com.tencent.mm.plugin.remittance.model.c paramc, com.tencent.mm.plugin.remittance.model.d paramd, int paramInt)
  {
    AppMethodBeat.i(44941);
    int j;
    int k;
    int m;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    if (this.qon)
    {
      this.qnE.setText(com.tencent.mm.wallet_core.ui.e.E(cht()));
      com.tencent.mm.sdk.platformtools.al.ae(this.qou);
      this.qnM = cht();
      long l = Math.round(this.qnM * 100.0D);
      if (l <= 0L)
      {
        this.qok.cgZ();
        this.qnw.setTextColor(-7829368);
        this.qnw.setText(this.qmW.qiO);
        if (this.qop != null) {
          this.qop.qjf = true;
        }
        AppMethodBeat.o(44941);
        return;
      }
      j = (int)l;
      k = this.mChannel;
      m = this.qmW.qiP;
      str1 = this.qnQ;
      str2 = this.qll;
      str3 = this.qmW.qiQ;
      str4 = this.qlP;
      str5 = this.qnN;
      str6 = this.qmW.qiR;
      if (paramc != null) {
        break label233;
      }
    }
    label233:
    for (int i = 0;; i = 1)
    {
      this.qop = new com.tencent.mm.plugin.remittance.model.g(j, k, m, str1, str2, str3, str4, str5, str6, i, paramc, paramd);
      com.tencent.mm.sdk.platformtools.al.p(this.qou, paramInt);
      AppMethodBeat.o(44941);
      return;
    }
  }
  
  private void a(mq parammq)
  {
    AppMethodBeat.i(44957);
    ab.i("MicroMsg.RemittanceBusiUI", "resp.payer_need_auth_flag %s", new Object[] { Integer.valueOf(parammq.wBs) });
    if (parammq.wBs == 1)
    {
      parammq = new Bundle();
      com.tencent.mm.sdk.b.a.ymk.c(this.qoE);
      parammq.putString("realname_verify_process_jump_activity", ".ui.RemittanceBusiUI");
      parammq.putString("realname_verify_process_jump_plugin", "remittance");
      parammq.putInt("real_name_verify_mode", 0);
      parammq.putInt("entry_scene", this.mPayScene);
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, parammq);
      AppMethodBeat.o(44957);
      return;
    }
    Intent localIntent = new Intent();
    Object localObject;
    if (!bo.isNullOrNil(this.qoj)) {
      localObject = this.qoj;
    }
    for (;;)
    {
      localIntent.putExtra("INTENT_TITLE", (String)localObject);
      localIntent.putExtra("INTENT_CAN_TOUCH", this.qoe);
      localIntent.putExtra("INTENT_PAYFEE", com.tencent.mm.wallet_core.ui.e.E(0.0D));
      localIntent.putExtra("INTENT_REQKEY", parammq.cwk);
      parammq = parammq.wBt;
      try
      {
        localIntent.putExtra("INTENT_TOKENMESS", parammq.toByteArray());
        com.tencent.mm.bq.d.b(getContext(), "wallet", "com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI", localIntent, 2);
        AppMethodBeat.o(44957);
        return;
      }
      catch (Exception parammq)
      {
        String str;
        StringBuilder localStringBuilder;
        ab.printErrStackTrace("MicroMsg.RemittanceBusiUI", parammq, "", new Object[0]);
        AppMethodBeat.o(44957);
      }
      str = getString(2131305531);
      if (!bo.isNullOrNil(this.qnN))
      {
        com.tencent.mm.kernel.g.RM();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().aru(this.qnN);
        if (localObject != null)
        {
          localObject = ((ad)localObject).Of();
          localStringBuilder = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.awj((String)localObject));
          if (bo.isNullOrNil(this.qnO)) {}
          for (localObject = "";; localObject = "(" + this.qnO + ")")
          {
            localObject = bo.p(str, new Object[] { (String)localObject });
            break;
          }
        }
        ab.e("MicroMsg.RemittanceBusiUI", "can not found contact for user::" + this.qnN);
        localObject = "";
      }
      else
      {
        ab.e("MicroMsg.RemittanceBusiUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        localObject = "";
      }
    }
  }
  
  private void a(boolean paramBoolean, Intent paramIntent)
  {
    AppMethodBeat.i(44945);
    if (paramBoolean)
    {
      String str1 = paramIntent.getStringExtra("key_trans_id");
      double d = paramIntent.getDoubleExtra("key_total_fee", -1.0D);
      String str2 = paramIntent.getStringExtra("key_reqKey");
      ab.i("MicroMsg.RemittanceBusiUI", "onActivityResult _transId: %s _totalFee: %s", new Object[] { str1, Double.valueOf(d) });
      if (bo.isNullOrNil(this.plc)) {
        this.plc = str1;
      }
      if (d >= 0.0D) {
        this.cnL = d;
      }
      if (this.qlU) {
        com.tencent.mm.plugin.report.service.h.qsU.e(15386, new Object[] { Integer.valueOf(3), Integer.valueOf(2) });
      }
      chw();
      Ym(str2);
    }
    for (;;)
    {
      c(paramBoolean, paramIntent);
      AppMethodBeat.o(44945);
      return;
      if (com.tencent.mm.plugin.wallet_core.utils.c.av(paramIntent))
      {
        finish();
        AppMethodBeat.o(44945);
        return;
      }
      if (com.tencent.mm.plugin.wallet_core.utils.c.aw(paramIntent))
      {
        AppMethodBeat.o(44945);
        return;
      }
      ab.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor");
      chv();
    }
  }
  
  private boolean a(i parami)
  {
    AppMethodBeat.i(44951);
    boolean bool1 = false;
    if (!this.qlZ) {
      bool1 = b(parami);
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = c(parami);
    }
    AppMethodBeat.o(44951);
    return bool2;
  }
  
  private void aY(int paramInt, String paramString)
  {
    AppMethodBeat.i(138551);
    this.qlW = new br();
    this.qlW.cRG = 1L;
    this.qlW.cRH = paramInt;
    this.qlW.gQ(paramString);
    this.qlW.ake();
    AppMethodBeat.o(138551);
  }
  
  private boolean b(i parami)
  {
    AppMethodBeat.i(44952);
    if (!bo.isNullOrNil(parami.qji.wBm))
    {
      this.qlZ = true;
      aY(1, parami.qji.wpp);
      e.chr().a(parami.qji.wBm, getString(2131297056), getString(2131302519), getString(2131296888), new RemittanceBusiUI.19(this, parami), new RemittanceBusiUI.20(this, parami));
      AppMethodBeat.o(44952);
      return true;
    }
    AppMethodBeat.o(44952);
    return false;
  }
  
  private void c(boolean paramBoolean, Intent paramIntent)
  {
    AppMethodBeat.i(44946);
    this.qoy = false;
    if (paramBoolean)
    {
      ab.i("MicroMsg.RemittanceBusiUI", "savePayInfo isOk = true");
      this.cEU = 1;
    }
    for (;;)
    {
      ab.i("MicroMsg.RemittanceBusiUI", "savePayInfo() mLastPayResult:%s mLastTotalAmt:%s mLastPayerDesc:%s mLastF2fId:%s", new Object[] { Double.valueOf(this.qoz), Double.valueOf(this.qoz), this.qoA, this.qoB });
      AppMethodBeat.o(44946);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(44946);
        return;
      }
      this.cEU = paramIntent.getIntExtra("key_pay_reslut_type", 3);
      this.qoz = this.qnM;
      this.qoA = this.qmO;
      this.qoB = this.qmN;
    }
  }
  
  private boolean c(i parami)
  {
    AppMethodBeat.i(44955);
    if (parami.qji.wBn != null)
    {
      this.qmc = true;
      e.chr().a(parami.qji.kok, "", parami.qji.wBn.opD, parami.qji.wBn.opC, new RemittanceBusiUI.21(this, parami), new RemittanceBusiUI.22(this));
      AppMethodBeat.o(44955);
      return true;
    }
    AppMethodBeat.o(44955);
    return false;
  }
  
  private void cP(List<adh> paramList)
  {
    AppMethodBeat.i(44940);
    com.tencent.mm.ui.widget.picker.d locald = new com.tencent.mm.ui.widget.picker.d(this);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = this.qok.qkU;
    Object localObject1 = new HashSet();
    HashSet localHashSet = new HashSet();
    if ((this.qok.chd()) && (localObject2 != null))
    {
      localObject2 = ((adg)localObject2).wAS.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((HashSet)localObject1).add(Long.valueOf(((adh)((Iterator)localObject2).next()).wVT));
      }
    }
    localObject2 = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      if (((HashSet)localObject1).contains(Long.valueOf(((adh)((Iterator)localObject2).next()).wVT))) {
        localArrayList.add(Integer.valueOf(i));
      }
      i += 1;
    }
    localObject1 = getString(2131302579);
    if ((localObject1 != null) && (((CharSequence)localObject1).length() > 0))
    {
      locald.AJc.setVisibility(0);
      locald.smo.setText((CharSequence)localObject1);
    }
    locald.AJd = localArrayList;
    locald.sao = new RemittanceBusiUI.9(this, paramList, localHashSet);
    locald.sap = new RemittanceBusiUI.10(this, localHashSet, paramList, locald);
    locald.AJf = new RemittanceBusiUI.11(this);
    if (locald.sao != null) {
      locald.sao.onCreateMMMenu(locald.saq);
    }
    locald.AJe = new d.a(locald, locald.mContext);
    locald.AJe.dPq();
    locald.AJb.setAdapter(locald.AJe);
    locald.gtF.setOnClickListener(new d.2(locald));
    locald.jIG.setOnClickListener(new d.3(locald));
    if (locald.zRa != null)
    {
      if ((locald.saq != null) && (locald.saq.size() > 3))
      {
        paramList = (FrameLayout.LayoutParams)locald.iDS.getLayoutParams();
        paramList.height = locald.zRb;
        locald.iDS.setLayoutParams(paramList);
      }
      locald.zRa.show();
    }
    AppMethodBeat.o(44940);
  }
  
  private void ccF()
  {
    AppMethodBeat.i(44959);
    this.qnM = cht();
    if (this.qnM <= 0.0D)
    {
      findViewById(2131827232).setClickable(false);
      findViewById(2131827232).setEnabled(false);
      findViewById(2131827232).setOnClickListener(null);
      kw(false);
      this.qnw.setTextColor(getResources().getColor(2131690318));
      AppMethodBeat.o(44959);
      return;
    }
    this.qnw.setTextColor(-7829368);
    findViewById(2131827232).setEnabled(true);
    findViewById(2131827232).setClickable(true);
    kw(true);
    findViewById(2131827232).setOnClickListener(new RemittanceBusiUI.28(this));
    AppMethodBeat.o(44959);
  }
  
  private void chm()
  {
    AppMethodBeat.i(44938);
    com.tencent.mm.sdk.platformtools.al.d(new RemittanceBusiUI.4(this));
    AppMethodBeat.o(44938);
  }
  
  private double cht()
  {
    AppMethodBeat.i(44934);
    if ((this.qnX) || (this.mPayScene == 33))
    {
      d = this.qnM;
      AppMethodBeat.o(44934);
      return d;
    }
    this.qnM = bo.getDouble(this.qnz.getText(), 0.0D);
    double d = this.qnM;
    AppMethodBeat.o(44934);
    return d;
  }
  
  private boolean chu()
  {
    AppMethodBeat.i(44939);
    boolean bool;
    if (this.qnx == null) {
      bool = false;
    }
    for (;;)
    {
      o.a(this, this.nIO, findViewById(2131822909), findViewById(2131822909), findViewById(2131827238), 24, this.qnU);
      AppMethodBeat.o(44939);
      return bool;
      if (this.qmW != null)
      {
        ab.i("MicroMsg.RemittanceBusiUI", "tryShowFavor ");
        if ((this.qmW.qiT != null) && (this.qmW.qiT.wAT.size() > 0)) {}
        for (int i = 1;; i = 0)
        {
          if (this.qmW.qiS.size() > 0) {
            i = 1;
          }
          if (this.qok.cha().size() > 0) {
            i = 1;
          }
          if (i == 0)
          {
            this.qnx.setVisibility(8);
            this.qor.update();
            this.qnD.setVisibility(8);
            bool = false;
            break;
          }
          this.qnD.setVisibility(0);
          this.qoq.update();
          this.qnx.setVisibility(0);
          this.qnw.setText(this.qmW.qiO);
          this.qnw.setTextColor(-7829368);
          this.qnE.setText(com.tencent.mm.wallet_core.ui.e.E(cht()));
          Object localObject = this.qok.qkU;
          if (localObject != null)
          {
            this.qnw.setTextColor(-30434);
            this.qnw.setText(((adg)localObject).qiO);
            this.qnE.setText(com.tencent.mm.wallet_core.ui.e.E(((adg)localObject).wVM / 100.0D));
          }
          for (;;)
          {
            findViewById(2131827232).setOnClickListener(new RemittanceBusiUI.5(this));
            bool = true;
            break;
            localObject = this.qok.chb();
            if (!bo.isNullOrNil((String)localObject))
            {
              this.qnw.setTextColor(-7829368);
              this.qnw.setText((CharSequence)localObject);
            }
          }
        }
      }
      bool = false;
    }
  }
  
  private void chv()
  {
    AppMethodBeat.i(44948);
    ab.i("MicroMsg.RemittanceBusiUI", "unLockFavorimp");
    adg localadg = this.qok.qkU;
    if (localadg == null)
    {
      ab.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor FavorComposeInfo is null");
      AppMethodBeat.o(44948);
      return;
    }
    int i = (int)Math.round(this.qnM * 100.0D);
    cz localcz = new cz();
    localcz.cCy = this.mChannel;
    localcz.wpp = this.qmN;
    localcz.wpq = this.plc;
    localcz.qiP = this.qmW.qiP;
    localcz.scene = this.mPayScene;
    localcz.wpr = this.qmS;
    localcz.wps = localadg;
    localcz.wpt = this.qnN;
    localcz.qkn = this.qlP;
    localcz.wpu = i;
    doSceneProgress(new k(localcz, this.qol), false);
    AppMethodBeat.o(44948);
  }
  
  private void chw()
  {
    AppMethodBeat.i(44950);
    ab.i("MicroMsg.RemittanceBusiUI", "goto busi result");
    Intent localIntent = new Intent(this, RemittanceBusiResultUI.class);
    localIntent.putExtra("key_pay_desc", this.qmO);
    localIntent.putExtra("key_rcv_desc", this.qnQ);
    if (this.qmW != null) {
      localIntent.putExtra("BusiRemittanceResp", this.qmW);
    }
    localIntent.putExtra("key_mch_name", this.qll);
    localIntent.putExtra("key_rcver_name", this.qnN);
    localIntent.putExtra("key_rcver_true_name", this.qnO);
    if (this.cnL >= 0.0D) {
      localIntent.putExtra("key_money", this.cnL);
    }
    for (;;)
    {
      localIntent.putExtra("key_f2f_id", this.qmN);
      localIntent.putExtra("key_trans_id", this.plc);
      localIntent.putExtra("key_check_sign", this.qmS);
      localIntent.putExtra("key_rcvr_open_id", this.qlP);
      localIntent.putExtra("key_channel", this.mChannel);
      localIntent.putExtra("key_succ_fault_config", this.qoi);
      if (this.qmW != null)
      {
        localIntent.putExtra("key_succ_show_avatar_type", this.qmW.qiV);
        localIntent.putExtra("key_succ_show_avatar_show", this.qmW.qiM);
        localIntent.putExtra("key_succ_show_avatar_url", this.qmW.qiN);
      }
      if (this.qmW != null) {
        localIntent.putExtra("key_scan_sceen", this.qmW.qiP);
      }
      localIntent.putExtra("key_succ_page_extend", this.qom);
      adg localadg = this.qok.qkU;
      int i = (int)Math.round(this.qnM * 100.0D);
      cz localcz = new cz();
      localcz.cCy = this.mChannel;
      localcz.wpp = this.qmN;
      localcz.wpq = this.plc;
      localcz.qiP = this.qmW.qiP;
      localcz.scene = this.mPayScene;
      localcz.wpr = this.qmS;
      localcz.wps = localadg;
      localcz.wpt = this.qnN;
      localcz.qkn = this.qlP;
      localcz.wpu = i;
      try
      {
        localIntent.putExtra("AfterPlaceOrderCommReq", localcz.toByteArray());
        startActivity(localIntent);
        finish();
        if (e.chr().chs()) {
          ab.w("MicroMsg.RemittanceBusiUI", "finish RemittanceF2fDynamicCodeUI");
        }
        AppMethodBeat.o(44950);
        return;
        localIntent.putExtra("key_money", this.qnM);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.RemittanceBusiUI", localException, "", new Object[0]);
        }
      }
    }
  }
  
  private void d(i parami)
  {
    AppMethodBeat.i(44956);
    ab.i("MicroMsg.RemittanceBusiUI", "do start pay zero_pay_flag: %s", new Object[] { Integer.valueOf(parami.qji.wBr) });
    int i = (int)Math.round(this.qnM * 100.0D);
    Object localObject1 = new cz();
    ((cz)localObject1).cCy = this.mChannel;
    ((cz)localObject1).wpp = this.qmN;
    ((cz)localObject1).wpq = this.plc;
    ((cz)localObject1).qiP = this.qmW.qiP;
    ((cz)localObject1).scene = this.mPayScene;
    ((cz)localObject1).wpr = this.qmS;
    ((cz)localObject1).wps = this.qok.qkU;
    ((cz)localObject1).wpt = this.qnN;
    ((cz)localObject1).qkn = this.qlP;
    ((cz)localObject1).wpu = i;
    this.qos.put(parami.qji.cwk, localObject1);
    if (parami.qji.wBr == 1)
    {
      a(parami.qji);
      AppMethodBeat.o(44956);
      return;
    }
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.cnI = parami.qji.cwk;
    localPayInfo.cCD = this.mPayScene;
    if (this.mChannel > 0) {
      localPayInfo.cCy = this.mChannel;
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("extinfo_key_1", this.qnN);
    ((Bundle)localObject1).putString("extinfo_key_2", this.qnO);
    ((Bundle)localObject1).putString("extinfo_key_3", this.qnQ);
    ((Bundle)localObject1).putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
    ((Bundle)localObject1).putString("extinfo_key_7", this.qmO);
    ((Bundle)localObject1).putString("extinfo_key_19", parami.qji.qjX);
    localPayInfo.wgv = ((Bundle)localObject1);
    localPayInfo.qkj = 1;
    Object localObject2 = new Intent();
    if (parami.qji.qjU == 1)
    {
      ((Bundle)localObject1).putInt("extinfo_key_15", parami.qji.wBA);
      ((Bundle)localObject1).putString("extinfo_key_17", parami.qji.qjV);
      ((Bundle)localObject1).putString("extinfo_key_18", parami.qji.qjW);
      ((Intent)localObject2).putExtra("key_pay_info", localPayInfo);
      ((Intent)localObject2).putExtra("from_patch_ui", true);
      ((Intent)localObject2).putExtra("key_rcvr_open_id", this.qlP);
      ((Intent)localObject2).putExtra("key_mch_info", this.qnT);
      ((Intent)localObject2).putExtra("key_mch_photo", this.qmW.qiN);
      ((Intent)localObject2).putExtra("key_transfer_qrcode_id", this.qnL);
      ((Intent)localObject2).putExtra("get_dynamic_code_sign", parami.qji.qjV);
      ((Intent)localObject2).putExtra("get_dynamic_code_extend", parami.qji.qjW);
      ((Intent)localObject2).putExtra("dynamic_code_spam_wording", parami.qji.qjY);
      ((Intent)localObject2).putExtra("dynamic_code_amount", parami.qji.wBA);
      ((Intent)localObject2).putExtra("show_paying_wording", parami.qji.qjX);
      if (this.qmW.qiV == 1) {}
      for (boolean bool = true;; bool = false)
      {
        ((Intent)localObject2).putExtra("show_avatar_type", bool);
        com.tencent.mm.plugin.report.service.h.qsU.e(15386, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
        this.qme.alive();
        this.qoC.alive();
        this.qoD.alive();
        if ((this.mKindaEnable) && (((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.b.class)).kindaCacheServiceGetBool("NEW_CASHIER_QRCODE_RECEIVE_PAY_SWTICH_KEY"))) {
          hideLoading();
        }
        com.tencent.mm.bq.d.b(this, "remittance", ".ui.RemittanceF2fDynamicCodeUI", (Intent)localObject2, 3);
        AppMethodBeat.o(44956);
        return;
      }
    }
    String str;
    if ((this.mKindaEnable) && (((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.b.class)).kindaCacheServiceGetBool("NEW_CASHIER_QRCODE_RECEIVE_PAY_SWTICH_KEY")))
    {
      this.cun = 1;
      if (this.qot != null) {
        this.cun = 3;
      }
      str = "";
      if (!bo.isNullOrNil(parami.qji.qjX))
      {
        parami = parami.qji.qjX;
        if (localPayInfo.wgv == null) {
          localPayInfo.wgv = new Bundle();
        }
        localPayInfo.wgv.putString("cashier_desc", parami);
        if (bo.isNullOrNil(this.qnN)) {
          break label1302;
        }
        com.tencent.mm.kernel.g.RM();
        parami = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().aru(this.qnN);
        if (parami == null) {
          break label1302;
        }
        parami = parami.Of();
        localObject1 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.awj(parami));
        if (!bo.isNullOrNil(this.qnO)) {
          break label1139;
        }
        parami = "";
      }
    }
    label869:
    for (parami = parami;; parami = "")
    {
      localPayInfo.wgv.putString("prepay_page_payee", parami);
      if (this.qot != null)
      {
        ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.b.class)).startSNSPay(this.qot, localPayInfo);
        AppMethodBeat.o(44956);
        return;
        localObject2 = getIntent().getStringExtra("receiver_tips");
        localObject1 = getString(2131305531);
        parami = str;
        if (!bo.isNullOrNil((String)localObject2))
        {
          localObject1 = localObject2;
          parami = (i)localObject2;
        }
        if (!bo.isNullOrNil(this.qnN))
        {
          com.tencent.mm.kernel.g.RM();
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().aru(this.qnN);
          if (localObject2 != null)
          {
            parami = ((ad)localObject2).Of();
            localObject2 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.awj(parami));
            if (bo.isNullOrNil(this.qnO)) {}
            for (parami = "";; parami = "(" + this.qnO + ")")
            {
              parami = bo.p((String)localObject1, new Object[] { parami });
              break;
            }
          }
          ab.e("MicroMsg.RemittanceBusiUI", "can not found contact for user::" + this.qnN);
          break;
        }
        ab.e("MicroMsg.RemittanceBusiUI", "mRcverName is null ,scene is MMPAY_PAY_SCENE_TRANSFER busi");
        break;
        label1139:
        parami = "(" + this.qnO + ")";
        break label869;
      }
      ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.b.class)).startSNSPay(this, localPayInfo);
      AppMethodBeat.o(44956);
      return;
      if (!bo.isNullOrNil(parami.qjj)) {}
      for (this.qlU = true; (parami.qjk != null) && (parami.qjk.cul.cup != null); this.qlU = false)
      {
        com.tencent.mm.pluginsdk.wallet.h.a(parami.qjk.cul.cup, false, "", localPayInfo, this.qnO, (Intent)localObject2, parami.qjk.cul.cun);
        AppMethodBeat.o(44956);
        return;
      }
      com.tencent.mm.pluginsdk.wallet.h.a(this, false, "", localPayInfo, this.qnO, (Intent)localObject2, 1);
      AppMethodBeat.o(44956);
      return;
    }
  }
  
  private void kw(boolean paramBoolean)
  {
    AppMethodBeat.i(142209);
    if (this.qnK != null) {
      this.qnK.rP(paramBoolean);
    }
    AppMethodBeat.o(142209);
  }
  
  private void r(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(44947);
    ab.i("MicroMsg.RemittanceBusiUI", "doBusiZeroCallback %s", new Object[] { Boolean.valueOf(paramBoolean) });
    cz localcz = (cz)this.qos.get(paramString);
    if (localcz == null)
    {
      AppMethodBeat.o(44947);
      return;
    }
    ckm localckm = this.qoc;
    String str = this.qob;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString = new com.tencent.mm.plugin.remittance.model.l(localckm, localcz, str, i, this.qod, paramString);
      if (!paramBoolean) {
        break;
      }
      paramString.hasRetried = true;
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(paramString, 0);
      AppMethodBeat.o(44947);
      return;
    }
    this.qoh = 0;
    doSceneForceProgress(paramString);
    AppMethodBeat.o(44947);
  }
  
  public final void aV(float paramFloat)
  {
    AppMethodBeat.i(142208);
    if (this.nIO != null)
    {
      this.qnU = paramFloat;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.nIO.getLayoutParams();
      localLayoutParams.bottomMargin = ((int)paramFloat);
      ab.d("MicroMsg.RemittanceBusiUI", "onUpdateWcPayKeyboardHeight() height: %s rootView.height: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(localLayoutParams.height) });
      this.nIO.setLayoutParams(localLayoutParams);
      o.a(this, this.nIO, findViewById(2131822909), findViewById(2131822909), findViewById(2131827238), 24, paramFloat);
    }
    AppMethodBeat.o(142208);
  }
  
  public int getLayoutId()
  {
    return 2130970569;
  }
  
  public void initView()
  {
    AppMethodBeat.i(44937);
    hideActionbarLine();
    this.nIO = ((ScrollView)findViewById(2131820898));
    this.qnq = ((TextView)findViewById(2131827216));
    this.qnr = ((TextView)findViewById(2131827217));
    this.qns = ((TextView)findViewById(2131827227));
    this.qnt = ((TextView)findViewById(2131827229));
    this.qnu = ((TextView)findViewById(2131827240));
    this.qnv = ((TextView)findViewById(2131827241));
    this.qny = ((CdnImageView)findViewById(2131823856));
    this.qnz = ((WalletFormView)findViewById(2131827220));
    this.qnA = ((LinearLayout)findViewById(2131827226));
    this.qlA = ((LinearLayout)findViewById(2131827219));
    this.qnJ = ((RelativeLayout)findViewById(2131827221));
    this.qnB = ((LinearLayout)findViewById(2131827239));
    this.qnw = ((TextView)findViewById(2131827233));
    this.qnx = findViewById(2131827230);
    this.qnC = ((TextView)findViewById(2131827228));
    this.qnD = findViewById(2131827235);
    this.qnE = ((TextView)findViewById(2131827237));
    this.qnF = ((Button)findViewById(2131827242));
    this.qnK = ((WcPayKeyboard)findViewById(2131829492));
    if (this.qnX)
    {
      if (!bo.isNullOrNil(this.qnQ)) {
        this.qns.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this, this.qnQ, this.qns.getTextSize()));
      }
      this.qnt.setText(com.tencent.mm.wallet_core.ui.e.E(this.qnM));
      this.qnA.setVisibility(0);
      this.qlA.setVisibility(8);
      this.qnJ.setVisibility(8);
      this.qnF.setVisibility(0);
      if (com.tencent.mm.kernel.g.RG())
      {
        com.tencent.mm.kernel.g.RM();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.qnN);
        if ((localObject == null) || ((int)((com.tencent.mm.n.a)localObject).euF == 0)) {
          ao.a.flI.a(this.qnN, "", new RemittanceBusiUI.29(this));
        }
      }
      chm();
      this.qnB.setOnClickListener(new RemittanceBusiUI.30(this));
      Object localObject = new RemittanceBusiUI.31(this);
      this.qnz.getContentEt().setOnEditorActionListener(new RemittanceBusiUI.32(this, (View.OnClickListener)localObject));
      this.qnF.setOnClickListener((View.OnClickListener)localObject);
      this.nIO.setOnTouchListener(new RemittanceBusiUI.33(this));
      setTenpayKBStateListener(new RemittanceBusiUI.34(this));
      this.qnI = ((RelativeLayout)findViewById(2131827223));
      if ((!aa.dsG().equals("zh_CN")) && (!aa.dsG().equals("zh_TW")) && (!aa.dsG().equals("zh_HK"))) {
        break label862;
      }
      this.qnG = ((RelativeLayout)findViewById(2131827224));
      this.qnH = ((TextView)findViewById(2131827225));
      this.qnG.post(new RemittanceBusiUI.2(this));
      this.qnz.setmWalletFormViewListener(new RemittanceBusiUI.3(this));
    }
    for (;;)
    {
      if ((this.qmW != null) && (this.qmW.qiT != null))
      {
        this.qok.qkV = this.qmW.qiT;
        this.qok.Yj(this.qmW.qiT.wAU);
      }
      if (chu()) {
        com.tencent.mm.plugin.report.service.h.qsU.e(15235, new Object[] { Integer.valueOf(2) });
      }
      AppMethodBeat.o(44937);
      return;
      if (this.qmW != null)
      {
        this.qmW.qiS.size();
        if (this.qmW.qiT != null) {
          this.qmW.qiT.wAS.size();
        }
      }
      this.qnF.setVisibility(8);
      setWPKeyboard(this.qnz.getContentEt(), false, false);
      this.qnK.setActionText(getString(2131302530));
      setWcKbHeightListener(this);
      ((RelativeLayout.LayoutParams)this.qnK.getLayoutParams()).addRule(12);
      this.qnz.a(new RemittanceBusiUI.23(this));
      this.qnz.dTb();
      this.qnA.setVisibility(8);
      this.qlA.setVisibility(0);
      this.qnJ.setVisibility(0);
      break;
      label862:
      this.qnI.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(44944);
    ab.i("MicroMsg.RemittanceBusiUI", "onActivityResult requestCode %s resultCode %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    if (paramInt1 == 3)
    {
      if (this.qot != null)
      {
        this.qot.hideProgress();
        this.qot = null;
      }
      if (paramInt2 == -1) {
        a(bool1, paramIntent);
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(44944);
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
      if (paramInt1 == 2) {
        if (paramInt2 == -1)
        {
          String str = paramIntent.getStringExtra("INTENT_RESULT_TOKEN");
          this.qod = str;
          this.cnL = 0.0D;
          ab.i("MicroMsg.RemittanceBusiUI", "onActivityResult _result_token: %s", new Object[] { str });
          r(false, paramIntent.getStringExtra("INTENT_REQKEY"));
        }
        else
        {
          chv();
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(44935);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.qsU.e(15235, new Object[] { Integer.valueOf(1) });
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131690316)));
    paramBundle = getSupportActionBar().getCustomView();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.findViewById(16908308);
      if ((paramBundle != null) && ((paramBundle instanceof TextView))) {
        ((TextView)paramBundle).setTextColor(getResources().getColor(2131689763));
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(2131690316));
    }
    boolean bool;
    if (com.tencent.mm.compatible.util.d.fv(21))
    {
      if (com.tencent.mm.compatible.util.d.fv(23)) {
        getWindow().getDecorView().setSystemUiVisibility(8192);
      }
    }
    else
    {
      setBackBtn(new RemittanceBusiUI.12(this), 2131230737);
      addSceneEndListener(1633);
      addSceneEndListener(1241);
      addSceneEndListener(2677);
      addSceneEndListener(2504);
      addSceneEndListener(2702);
      addSceneEndListener(2682);
      regeistQueryOrder(2682, this.qov);
      setMMTitle(2131302530);
      setBackBtn(new RemittanceBusiUI.1(this));
      this.czq = UUID.randomUUID().toString();
      com.tencent.mm.plugin.wallet.pay.a.b.aeZ(this.czq);
      this.mPayScene = getIntent().getIntExtra("pay_scene", 31);
      this.qnL = getIntent().getStringExtra("scan_remittance_id");
      this.qnM = getIntent().getDoubleExtra("fee", 0.0D);
      this.qnN = getIntent().getStringExtra("receiver_name");
      this.qnO = getIntent().getStringExtra("receiver_true_name");
      this.qnP = getIntent().getStringExtra("receiver_true_name_busi");
      this.mChannel = getIntent().getIntExtra("pay_channel", 0);
      this.qnQ = getIntent().getStringExtra("desc");
      this.qnS = getIntent().getIntExtra("busi_type", 0);
      this.qll = getIntent().getStringExtra("mch_name");
      this.qnY = getIntent().getStringExtra("mch_type");
      this.qoa = getIntent().getIntExtra("mch_time", 0);
      this.qnT = getIntent().getStringExtra("mch_info");
      this.qnZ = getIntent().getIntExtra("get_pay_wifi", 0);
      this.qlP = getIntent().getStringExtra("rcvr_open_id");
      this.qnR = getIntent().getStringExtra("rcvr_ticket");
      this.qnV = getIntent().getIntExtra("amount_remind_bit", 4);
      this.qoj = getIntent().getStringExtra("receiver_tips");
      this.qmW = ((BusiRemittanceResp)getIntent().getParcelableExtra("BusiRemittanceResp"));
      if (this.qmW != null)
      {
        if ((this.mPayScene != 32) || ((this.qmW.qiU != 1) && ((this.qmW == null) || (this.qmW.qiS.size() <= 0)))) {
          break label741;
        }
        bool = true;
        label598:
        this.qon = bool;
      }
      if (this.qnM <= 0.0D) {
        break label746;
      }
    }
    label741:
    label746:
    for (this.qnX = true;; this.qnX = false)
    {
      if (this.qnS == 0)
      {
        ab.w("MicroMsg.RemittanceBusiUI", "wrong busi type!");
        finish();
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(15386, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
      this.qoq = new RemittanceBusiUI.a(this, 32, 32, 6.0F);
      this.qor = new RemittanceBusiUI.a(this, 56, 56, 8.0F);
      initView();
      ccF();
      this.qox.alive();
      AppMethodBeat.o(44935);
      return;
      getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
      break;
      bool = false;
      break label598;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(44942);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.ymk.d(this.qme);
    com.tencent.mm.sdk.b.a.ymk.d(this.qoE);
    com.tencent.mm.sdk.b.a.ymk.d(this.qoC);
    this.qoD.dead();
    removeSceneEndListener(1633);
    removeSceneEndListener(1241);
    removeSceneEndListener(2677);
    removeSceneEndListener(2504);
    removeSceneEndListener(2702);
    removeSceneEndListener(2682);
    this.qox.dead();
    com.tencent.mm.plugin.wallet.pay.a.b.afa(this.czq);
    AppMethodBeat.o(44942);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(142207);
    if ((this.qnK != null) && (this.qnK.onKeyUp(paramInt, paramKeyEvent)))
    {
      AppMethodBeat.o(142207);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(142207);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(44954);
    ab.v("MicroMsg.RemittanceBusiUI", "onNewIntent");
    AppMethodBeat.o(44954);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(44936);
    super.onResume();
    e.chr().eN(this);
    AppMethodBeat.o(44936);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44943);
    boolean bool;
    if ((paramm instanceof i))
    {
      paramString = (i)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (paramString.qji.koj == 0)
        {
          this.qmN = paramString.qji.wpp;
          this.plc = paramString.qji.wpq;
          this.qmS = paramString.qji.wpr;
          this.qol = paramString.qji.wBp;
          this.qom = paramString.qji.wBo;
          this.qob = paramString.qji.wBu;
          this.qoc = paramString.qji.wBt;
          this.qoe = paramString.qji.wBx;
          this.qof = paramString.qji.wBv;
          this.qog = paramString.qji.wBw;
          this.qoi = i.a(paramString.qji.wBC).toString();
          ab.i("MicroMsg.RemittanceBusiUI", "touch_challenge: %s need_change_auth_key: %s mBusiF2FFaultConfig: %s", new Object[] { paramString.qji.wBy, Integer.valueOf(paramString.qji.wBz), this.qoi });
          if (paramString.qji.wBy != null) {
            x.uli.mGC = paramString.qji.wBy.dqj();
          }
          paramm = x.uli;
          if (paramString.qji.wBz == 1)
          {
            bool = true;
            paramm.mGD = bool;
            if (a(paramString)) {
              break label287;
            }
            d(paramString);
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(44943);
      return false;
      bool = false;
      break;
      label287:
      hideLoading();
      if (this.qot != null)
      {
        this.qot.hideProgress();
        continue;
        hideLoading();
        if (this.qot != null) {
          this.qot.hideProgress();
        }
        ab.e("MicroMsg.RemittanceBusiUI", "place order response: %s, %s", new Object[] { Integer.valueOf(paramString.qji.koj), paramString.qji.kok });
        if ((paramString.qji.wBn != null) && (!bo.isNullOrNil(paramString.qji.wBn.opC))) {
          a(paramString);
        }
        for (;;)
        {
          if (paramString.qji.wBq != 1) {
            break label513;
          }
          a(null, null, 0);
          break;
          Object localObject = e.chr();
          String str = paramString.qji.kok;
          paramm = new RemittanceBusiUI.14(this, paramm);
          ab.w("MicroMsg.RemittanceBusiDialogMgr", "showAlert3() msg:%s, title:%s", new Object[] { bo.nullAsNil(str), bo.nullAsNil("") });
          localObject = (Context)((e)localObject).bJz.get();
          if (localObject == null) {
            ab.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
          } else {
            com.tencent.mm.ui.base.h.a((Context)localObject, str, "", paramm);
          }
        }
        label513:
        continue;
        ab.e("MicroMsg.RemittanceBusiUI", "net error: %s", new Object[] { paramm });
        continue;
        if ((paramm instanceof com.tencent.mm.plugin.remittance.model.h))
        {
          ab.i("MicroMsg.RemittanceBusiUI", "pay check callback");
          AppMethodBeat.o(44943);
          return true;
        }
        if ((paramm instanceof com.tencent.mm.plugin.remittance.model.g))
        {
          ab.i("MicroMsg.RemittanceBusiUI", "onSceneEnd %s errType %s errCode %s", new Object[] { paramm, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          paramString = (com.tencent.mm.plugin.remittance.model.g)paramm;
          if ((!paramString.qje.equals(this.qop.qje)) || (paramString.qjf))
          {
            paramString.qjd = true;
            ab.e("MicroMsg.RemittanceBusiUI", "ignore this getFavor new coming soon %s", new Object[] { Boolean.valueOf(paramString.qjf) });
            AppMethodBeat.o(44943);
            return true;
          }
          if ((paramInt1 == 0) && (paramInt2 == 0)) {
            if (paramString.qja.koj == 0)
            {
              this.qok.qkV = paramString.qja.qiT;
              this.qok.Yj(paramString.qja.qiT.wAU);
              chu();
              paramm = paramString.qjb;
              ab.i("MicroMsg.RemittanceBusiUI", "GetFavorAfterAction %s", new Object[] { paramm });
              if (paramm != null) {
                paramm.cO(this.qok.cha());
              }
            }
          }
          for (;;)
          {
            paramString.qjd = true;
            AppMethodBeat.o(44943);
            return true;
            this.qok.cgZ();
            this.qnw.setTextColor(-7829368);
            this.qnw.setText(paramString.qja.kok);
            paramm = paramString.qjc;
            if (paramm != null)
            {
              paramm.a(paramInt1, paramInt2, paramString);
              continue;
              this.qok.cgZ();
              if ((this.qmW != null) && (!bo.isNullOrNil(this.qmW.qiO))) {
                this.qnw.setText(this.qmW.qiO);
              }
              this.qnw.setTextColor(-7829368);
              this.qnw.setText(getString(2131302523));
              paramm = paramString.qjc;
              if (paramm != null) {
                paramm.a(paramInt1, paramInt2, paramString);
              }
            }
          }
        }
        if ((paramm instanceof com.tencent.mm.plugin.remittance.model.l))
        {
          paramString = (com.tencent.mm.plugin.remittance.model.l)paramm;
          ab.i("MicroMsg.RemittanceBusiUI", "NetSceneBusiF2fZeroCallback getHasRetried %s", new Object[] { Boolean.valueOf(paramString.hasRetried) });
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            if (paramString.qjn.koj == 0)
            {
              chw();
            }
            else
            {
              chv();
              e.chr().a(paramString.qjn.kok, new RemittanceBusiUI.15(this));
            }
          }
          else {
            e.chr().a(getString(2131305682), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(44907);
                AppMethodBeat.o(44907);
              }
            });
          }
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI
 * JD-Core Version:    0.7.0.1
 */