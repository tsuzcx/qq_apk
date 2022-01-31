package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.g.a.iz.a;
import com.tencent.mm.g.a.so;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.wallet_core.c.ac;
import com.tencent.mm.plugin.wallet_core.c.q;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.a;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.ui.e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class WalletOrderInfoOldUI
  extends WalletOrderInfoUI
{
  protected boolean coa;
  protected boolean cob;
  protected boolean coc;
  protected String ikj;
  protected String mAppId;
  protected PayInfo mPayInfo;
  protected String plc;
  private com.tencent.mm.sdk.b.c pns;
  protected String pqF;
  private String qpN;
  protected Orders tVr;
  protected String unA;
  protected boolean unu;
  private HashMap<String, WalletOrderInfoOldUI.b> unz;
  protected Set<String> uqP;
  protected List<Orders.Commodity> uqQ;
  protected LinearLayout urJ;
  protected TextView urK;
  protected TextView urL;
  protected WalletOrderInfoOldUI.a urM;
  protected String urN;
  protected HashMap<String, TextView> urO;
  protected WalletOrderInfoOldUI.c urP;
  protected Map<Long, String> urQ;
  private WalletOrderInfoOldUI.d urR;
  private boolean urS;
  protected ao.b.a urT;
  private View.OnLongClickListener urU;
  private com.tencent.mm.sdk.b.c urt;
  
  public WalletOrderInfoOldUI()
  {
    AppMethodBeat.i(47498);
    this.urJ = null;
    this.urK = null;
    this.urL = null;
    this.uqQ = null;
    this.urM = null;
    this.ikj = null;
    this.pqF = null;
    this.unu = false;
    this.uqP = null;
    this.mAppId = "";
    this.urN = null;
    this.coa = true;
    this.cob = false;
    this.coc = false;
    this.urO = new HashMap();
    this.urQ = new HashMap();
    this.unz = new HashMap();
    this.urS = false;
    this.pns = new WalletOrderInfoOldUI.5(this);
    this.urT = new WalletOrderInfoOldUI.6(this);
    this.urU = new WalletOrderInfoOldUI.11(this);
    this.urt = new WalletOrderInfoOldUI.3(this);
    AppMethodBeat.o(47498);
  }
  
  private void Kc()
  {
    int j = 1;
    AppMethodBeat.i(47499);
    com.tencent.mm.wallet_core.c localc = com.tencent.mm.wallet_core.a.aM(this);
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.plc = getInput().getString("key_trans_id");
    getInput().getInt("key_pay_type", -1);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoOldUI", "mTransId %s", new Object[] { this.plc });
    this.tVr = cVH();
    if (this.tVr != null)
    {
      setContentViewVisibility(0);
      d(this.tVr);
      int i;
      boolean bool1;
      if ((localc != null) && (this.tVr != null) && (this.mPayInfo != null))
      {
        this.mAppId = this.mPayInfo.appId;
        boolean bool2 = localc.dRQ();
        com.tencent.mm.plugin.wallet_core.utils.d.a(this, getInput(), 7);
        if (getInput().getInt("key_support_bankcard", 1) == 2)
        {
          i = 2;
          com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.qsU;
          int k = this.mPayInfo.cCD;
          if (this.mPayInfo.cCD != 3) {
            break label441;
          }
          bool1 = true;
          label189:
          if (!bool2) {
            break label447;
          }
          label194:
          localh.e(10691, new Object[] { Integer.valueOf(k), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(z.dSu()), Integer.valueOf((int)(this.tVr.cnL * 100.0D)), this.tVr.ppp, Integer.valueOf(i) });
        }
      }
      else
      {
        if (((!t.cTN().cUl()) && (localc != null) && (localc.dRQ())) || (!com.tencent.mm.model.r.Zw())) {
          com.tencent.mm.model.r.Zx();
        }
        if ((this.tVr == null) || (this.tVr.ujl == null) || (this.tVr.ujl.size() <= 0)) {
          break label452;
        }
        this.uqQ = this.tVr.ujl;
        this.plc = ((Orders.Commodity)this.uqQ.get(0)).cnJ;
        if ((this.mPayInfo != null) && (localc != null) && ((localc.dRP()) || (localc.dRQ()))) {
          cVO();
        }
      }
      for (;;)
      {
        if (this.plc != null) {
          break label519;
        }
        if (((i)com.tencent.mm.kernel.g.E(i.class)).g(this)) {
          this.urS = false;
        }
        AppMethodBeat.o(47499);
        return;
        i = 1;
        break;
        label441:
        bool1 = false;
        break label189;
        label447:
        j = 2;
        break label194;
        label452:
        com.tencent.mm.sdk.platformtools.ab.b("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
        com.tencent.mm.ui.base.h.a(getContext(), 2131305336, 0, new WalletOrderInfoOldUI.1(this));
      }
    }
    com.tencent.mm.sdk.platformtools.ab.b("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
    com.tencent.mm.ui.base.h.a(getContext(), 2131305336, 0, new WalletOrderInfoOldUI.4(this));
    label519:
    AppMethodBeat.o(47499);
  }
  
  private void cVQ()
  {
    AppMethodBeat.i(47520);
    if ((this.tVr != null) && (this.tVr.ujl != null) && (this.tVr.ujl.size() > 0) && (((Orders.Commodity)this.tVr.ujl.get(0)).ujX != null) && (!bo.isNullOrNil(((Orders.Commodity)this.tVr.ujl.get(0)).ujX.text)) && (!bo.isNullOrNil(((Orders.Commodity)this.tVr.ujl.get(0)).ujX.url)))
    {
      this.urL.setVisibility(0);
      this.urL.setText(((Orders.Commodity)this.tVr.ujl.get(0)).ujX.text);
      this.urL.setOnClickListener(new WalletOrderInfoOldUI.10(this));
      AppMethodBeat.o(47520);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoOldUI", "hy: no commodity or no link act or link act is illegal!");
    this.urL.setVisibility(8);
    AppMethodBeat.o(47520);
  }
  
  private void d(Orders paramOrders)
  {
    AppMethodBeat.i(47506);
    this.uqP.clear();
    if ((paramOrders == null) || (paramOrders.ujl == null))
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.WalletOrderInfoOldUI", "hy: orders is null");
      AppMethodBeat.o(47506);
      return;
    }
    paramOrders = paramOrders.ujl.iterator();
    while (paramOrders.hasNext())
    {
      Orders.Commodity localCommodity = (Orders.Commodity)paramOrders.next();
      if ((localCommodity.ujc == 2) && (!bo.isNullOrNil(localCommodity.ujN)))
      {
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOrderInfoOldUI", "hy: has username and is force recommend");
        this.uqP.add(localCommodity.ujN);
      }
    }
    AppMethodBeat.o(47506);
  }
  
  protected final void R(com.tencent.mm.storage.ad paramad)
  {
    AppMethodBeat.i(47512);
    if ((paramad != null) && ((int)paramad.euF != 0))
    {
      String str = paramad.Oe();
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer nickName " + str + " username: " + paramad.field_username);
      if ((this.uqQ != null) && (this.uqQ.size() > 0))
      {
        Iterator localIterator = this.uqQ.iterator();
        while (localIterator.hasNext()) {
          ((Orders.Commodity)localIterator.next()).ppq = str;
        }
        this.urM.notifyDataSetChanged();
      }
      this.ikj = paramad.field_username;
    }
    AppMethodBeat.o(47512);
  }
  
  protected final void a(Orders.Promotions paramPromotions)
  {
    AppMethodBeat.i(47505);
    doSceneForceProgress(new q(paramPromotions, getPayReqKey(), this.plc, paramPromotions.uiN));
    AppMethodBeat.o(47505);
  }
  
  protected final void a(String paramString, WalletOrderInfoOldUI.d paramd)
  {
    AppMethodBeat.i(47509);
    cVu();
    this.urR = paramd;
    e.a(this, paramString, false, 1);
    this.urS = false;
    AppMethodBeat.o(47509);
  }
  
  protected final void afI(String paramString)
  {
    AppMethodBeat.i(47510);
    cVu();
    e.m(this, paramString, false);
    this.urS = false;
    AppMethodBeat.o(47510);
  }
  
  protected void afK(String paramString)
  {
    AppMethodBeat.i(47503);
    doSceneProgress(new ac(paramString));
    AppMethodBeat.o(47503);
  }
  
  protected Orders cVH()
  {
    AppMethodBeat.i(47501);
    Orders localOrders = (Orders)getInput().getParcelable("key_orders");
    AppMethodBeat.o(47501);
    return localOrders;
  }
  
  public final void cVN()
  {
    AppMethodBeat.i(47515);
    cVu();
    this.urS = false;
    Object localObject1 = new com.tencent.mm.g.a.aq();
    ((com.tencent.mm.g.a.aq)localObject1).cnV.cnW = true;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("intent_pay_end_errcode", getInput().getInt("intent_pay_end_errcode"));
    ((Bundle)localObject2).putString("intent_pay_app_url", getInput().getString("intent_pay_app_url"));
    ((Bundle)localObject2).putBoolean("intent_pay_end", getInput().getBoolean("intent_pay_end"));
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoOldUI", "pay done...feedbackData errCode:" + getInput().getInt("intent_pay_end_errcode"));
    Iterator localIterator = this.uqP.iterator();
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (!bo.isNullOrNil(str1))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoOldUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str1 });
        if ((this.tVr == null) || (this.mPayInfo == null)) {
          break label339;
        }
        p localp = com.tencent.mm.kernel.g.RK().eHt;
        String str2 = this.tVr.cnI;
        if (this.tVr.ujl.size() <= 0) {
          break label333;
        }
        localObject1 = ((Orders.Commodity)this.tVr.ujl.get(0)).cnJ;
        label250:
        localp.a(new com.tencent.mm.wallet_core.c.r(str1, str2, (String)localObject1, this.mPayInfo.cCD, this.mPayInfo.cCy, this.tVr.ujc), 0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(13033, new Object[] { Integer.valueOf(2), str1, "", "", "" });
        break;
        label333:
        localObject1 = "";
        break label250;
        label339:
        com.tencent.mm.kernel.g.RK().eHt.a(new com.tencent.mm.wallet_core.c.r(str1), 0);
      }
    }
    com.tencent.mm.wallet_core.a.j(this, (Bundle)localObject2);
    if ((this.tVr != null) && (!bo.isNullOrNil(this.tVr.lHq))) {
      if (this.tVr.ujl.size() <= 0) {
        break label535;
      }
    }
    label535:
    for (localObject1 = ((Orders.Commodity)this.tVr.ujl.get(0)).cnJ;; localObject1 = "")
    {
      localObject1 = e(this.tVr.lHq, this.tVr.cnI, (String)localObject1, this.mPayInfo.kmA, this.mPayInfo.hKa);
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOrderInfoOldUI", "url = ".concat(String.valueOf(localObject1)));
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
      ((Intent)localObject2).putExtra("showShare", false);
      ((Intent)localObject2).putExtra("geta8key_username", com.tencent.mm.model.r.Zn());
      ((Intent)localObject2).putExtra("stastic_scene", 8);
      com.tencent.mm.bq.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject2);
      AppMethodBeat.o(47515);
      return;
    }
  }
  
  protected void cVO()
  {
    AppMethodBeat.i(47502);
    doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ab(getPayReqKey(), 21));
    AppMethodBeat.o(47502);
  }
  
  protected final void cVP()
  {
    AppMethodBeat.i(47508);
    if (this.tVr != null)
    {
      this.uqQ = this.tVr.ujl;
      Iterator localIterator = this.uqQ.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!"1".equals(((Orders.Commodity)localIterator.next()).ppi));
    }
    for (int i = 0;; i = 1)
    {
      this.urJ.setVisibility(0);
      this.urK.setVisibility(0);
      if (i != 0)
      {
        if ((!bo.isNullOrNil(this.tVr.uje)) && (!bo.isNullOrNil(this.tVr.uje.trim())))
        {
          this.urK.setText(this.tVr.uje);
          AppMethodBeat.o(47508);
          return;
        }
        if (this.tVr.ubU != 1)
        {
          this.urK.setText(2131305356);
          AppMethodBeat.o(47508);
          return;
        }
        this.urK.setText(2131305355);
        AppMethodBeat.o(47508);
        return;
      }
      this.urK.setText(2131305357);
      AppMethodBeat.o(47508);
      return;
    }
  }
  
  protected final void cVu()
  {
    int i = 0;
    AppMethodBeat.i(47511);
    if (!this.unu)
    {
      iz localiz = new iz();
      localiz.cyt.requestCode = 4;
      iz.a locala = localiz.cyt;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.bpE = i;
      com.tencent.mm.sdk.b.a.ymk.l(localiz);
      this.unu = true;
    }
    AppMethodBeat.o(47511);
  }
  
  protected final boolean chF()
  {
    return false;
  }
  
  protected final void dF(String paramString, int paramInt)
  {
    AppMethodBeat.i(47504);
    doSceneProgress(new ac(paramString, paramInt));
    AppMethodBeat.o(47504);
  }
  
  public void done()
  {
    AppMethodBeat.i(47514);
    if (getInput().containsKey("key_realname_guide_helper"))
    {
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)getInput().getParcelable("key_realname_guide_helper");
      if (localRealnameGuideHelper != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("realname_verify_process_jump_activity", ".ui.WalletOrderInfoOldUI");
        localBundle.putString("realname_verify_process_jump_plugin", "wallet_core");
        boolean bool = localRealnameGuideHelper.b(this, localBundle, new WalletOrderInfoOldUI.8(this));
        getInput().remove("key_realname_guide_helper");
        if (!bool) {
          cVN();
        }
      }
      AppMethodBeat.o(47514);
      return;
    }
    cVN();
    AppMethodBeat.o(47514);
  }
  
  public int getLayoutId()
  {
    return 2130971219;
  }
  
  public void initView()
  {
    AppMethodBeat.i(47507);
    setMMTitle(2131305370);
    showHomeBtn(false);
    enableBackMenu(false);
    String str = getString(2131296964);
    Object localObject;
    if ((this.mPayInfo != null) && (this.mPayInfo.cCD == 2)) {
      if (!bo.isNullOrNil(this.mPayInfo.uAe)) {
        localObject = getString(2131296546) + this.mPayInfo.uAe;
      }
    }
    for (;;)
    {
      addTextOptionMenu(0, (String)localObject, new WalletOrderInfoOldUI.7(this));
      this.urJ = ((LinearLayout)findViewById(2131829254));
      this.urK = ((TextView)findViewById(2131829255));
      this.urL = ((TextView)findViewById(2131829257));
      localObject = (MaxListView)findViewById(2131829256);
      this.urM = new WalletOrderInfoOldUI.a(this);
      ((MaxListView)localObject).setAdapter(this.urM);
      cVP();
      cVQ();
      ((ScrollView)findViewById(2131823477)).pageScroll(33);
      AppMethodBeat.o(47507);
      return;
      localObject = str;
      if (!bo.isNullOrNil(this.mPayInfo.appId))
      {
        localObject = str;
        if (!bo.isNullOrNil(com.tencent.mm.pluginsdk.model.app.g.t(this, this.mPayInfo.appId)))
        {
          localObject = getString(2131296546) + com.tencent.mm.pluginsdk.model.app.g.t(this, this.mPayInfo.appId);
          continue;
          localObject = str;
          if (this.tVr != null)
          {
            localObject = str;
            if (!bo.isNullOrNil(this.tVr.ujw)) {
              localObject = this.tVr.ujw;
            }
          }
        }
      }
    }
  }
  
  public final String nh(long paramLong)
  {
    AppMethodBeat.i(47522);
    if (this.urQ.containsKey(Long.valueOf(paramLong)))
    {
      String str = (String)this.urQ.get(Long.valueOf(paramLong));
      AppMethodBeat.o(47522);
      return str;
    }
    AppMethodBeat.o(47522);
    return "-1";
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(47519);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoOldUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1) {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(this.urR.uca, this.urR.urE, this.urR.urF, this.urR.urG, this.urR.cwk, this.urR.qkt, this.urR.ukx));
    }
    AppMethodBeat.o(47519);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47500);
    super.onCreate(paramBundle);
    setContentViewVisibility(4);
    this.uqP = new HashSet();
    Kc();
    initView();
    addSceneEndListener(1979);
    com.tencent.mm.sdk.b.a.ymk.c(this.urt);
    com.tencent.mm.sdk.b.a.ymk.c(this.pns);
    this.urS = false;
    AppMethodBeat.o(47500);
  }
  
  @Deprecated
  public Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(47517);
    Dialog localDialog = com.tencent.mm.ui.base.h.a(getContext(), getString(2131305351), getResources().getStringArray(2131755065), "", new WalletOrderInfoOldUI.9(this));
    AppMethodBeat.o(47517);
    return localDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(47513);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.ymk.d(this.urt);
    com.tencent.mm.sdk.b.a.ymk.d(this.pns);
    removeSceneEndListener(1979);
    AppMethodBeat.o(47513);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(47516);
    if (paramInt == 4)
    {
      done();
      AppMethodBeat.o(47516);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(47516);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(47518);
    super.onResume();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOrderInfoOldUI", "onResume, isClickActivityTinyApp: %s", new Object[] { Boolean.valueOf(this.urS) });
    if (this.urS) {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(this.urR.uca, this.urR.urE, this.urR.urF, this.urR.urG, this.urR.cwk, this.urR.qkt, this.urR.ukx));
    }
    AppMethodBeat.o(47518);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(47521);
    int i;
    if (((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ad)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.wallet_core.c.ad localad = (com.tencent.mm.plugin.wallet_core.c.ad)paramm;
      WalletOrderInfoOldUI.b localb = new WalletOrderInfoOldUI.b(this, localad.hxd);
      if ((!bo.isNullOrNil(localb.url)) && (!bo.isNullOrNil(localb.cyA)))
      {
        i = 1;
        if (i != 0) {
          this.unz.put(localad.uca, localb);
        }
        this.urM.notifyDataSetChanged();
      }
    }
    else
    {
      if (!(paramm instanceof ac)) {
        break label355;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        setContentViewVisibility(0);
        this.tVr = ((ac)paramm).ucc;
        if (this.tVr != null) {
          this.uqQ = this.tVr.ujl;
        }
        d(this.tVr);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + this.uqQ);
        if ((this.uqQ != null) && (this.uqQ.size() != 0))
        {
          paramString = (Orders.Commodity)this.uqQ.get(0);
          this.plc = paramString.cnJ;
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + paramString.toString());
          paramm = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(paramString.ppq);
          if ((paramm == null) || ((int)paramm.euF == 0)) {
            break label334;
          }
          R(paramm);
        }
      }
    }
    for (;;)
    {
      this.urM.notifyDataSetChanged();
      cVP();
      if (this.urM != null) {
        this.urM.notifyDataSetChanged();
      }
      cVQ();
      AppMethodBeat.o(47521);
      return true;
      i = 0;
      break;
      label334:
      ao.a.flI.a(paramString.ppq, "", this.urT);
    }
    label355:
    if ((paramm instanceof q))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (q)paramm;
        paramm = paramString.ubJ;
        long l = paramString.ubM.ubC;
        this.urQ.put(Long.valueOf(l), paramm);
        paramString.ubM.uiO = paramString.eev;
        if ((!"-1".equals(paramm)) && (!"0".equals(paramm)) && (!bo.isNullOrNil(paramString.ubK))) {
          com.tencent.mm.ui.base.h.b(this, paramString.ubK, "", true);
        }
        while (!"0".equals(paramm))
        {
          this.urM.notifyDataSetChanged();
          AppMethodBeat.o(47521);
          return true;
        }
        if (!bo.isNullOrNil(paramString.ubK)) {}
        for (paramString = paramString.ubK;; paramString = getString(2131305444))
        {
          Toast.makeText(this, paramString, 0).show();
          break;
        }
      }
      if ((paramm instanceof q))
      {
        paramm = paramString;
        if (bo.isNullOrNil(paramString)) {
          paramm = getString(2131305682);
        }
        com.tencent.mm.ui.base.h.a(this, paramm, null, false, new WalletOrderInfoOldUI.2(this));
        AppMethodBeat.o(47521);
        return true;
      }
    }
    AppMethodBeat.o(47521);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class c$a
  {
    TextView gve;
    CdnImageView kAK;
    TextView titleTv;
    int type;
    int uki;
    TextView uso;
    CheckBox usp;
    
    c$a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI
 * JD-Core Version:    0.7.0.1
 */