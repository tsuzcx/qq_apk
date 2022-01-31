package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.an;
import com.tencent.mm.h.a.is;
import com.tencent.mm.h.a.is.a;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.wallet_core.c.aa;
import com.tencent.mm.plugin.wallet_core.c.n;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.a;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
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
  protected boolean bGL = true;
  protected boolean bGM = false;
  protected boolean bGN = false;
  protected String hcm = null;
  protected String mAppId = "";
  protected String mKL;
  private com.tencent.mm.sdk.b.c mNd = new WalletOrderInfoOldUI.5(this);
  protected String mQr = null;
  private String nDd;
  protected PayInfo nDu;
  protected boolean qAJ = false;
  private HashMap<String, WalletOrderInfoOldUI.b> qAO = new HashMap();
  protected String qAP;
  public Set<String> qDU = null;
  public List<Orders.Commodity> qDV = null;
  protected LinearLayout qEB = null;
  protected TextView qEC = null;
  protected TextView qED = null;
  public WalletOrderInfoOldUI.a qEE = null;
  protected String qEF = null;
  protected HashMap<String, TextView> qEG = new HashMap();
  protected WalletOrderInfoOldUI.c qEH;
  protected Map<Long, String> qEI = new HashMap();
  private WalletOrderInfoOldUI.d qEJ;
  private boolean qEK = false;
  public am.b.a qEL = new WalletOrderInfoOldUI.6(this);
  private View.OnLongClickListener qEM = new WalletOrderInfoOldUI.11(this);
  private com.tencent.mm.sdk.b.c qEq = new WalletOrderInfoOldUI.3(this);
  public Orders qmc;
  
  private void bWN()
  {
    if ((this.qmc != null) && (this.qmc.qwN != null) && (this.qmc.qwN.size() > 0) && (((Orders.Commodity)this.qmc.qwN.get(0)).qxp != null) && (!bk.bl(((Orders.Commodity)this.qmc.qwN.get(0)).qxp.text)) && (!bk.bl(((Orders.Commodity)this.qmc.qwN.get(0)).qxp.url)))
    {
      this.qED.setVisibility(0);
      this.qED.setText(((Orders.Commodity)this.qmc.qwN.get(0)).qxp.text);
      this.qED.setOnClickListener(new WalletOrderInfoOldUI.10(this));
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoOldUI", "hy: no commodity or no link act or link act is illegal!");
    this.qED.setVisibility(8);
  }
  
  private void c(Orders paramOrders)
  {
    this.qDU.clear();
    if ((paramOrders == null) || (paramOrders.qwN == null)) {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.WalletOrderInfoOldUI", "hy: orders is null");
    }
    for (;;)
    {
      return;
      paramOrders = paramOrders.qwN.iterator();
      while (paramOrders.hasNext())
      {
        Orders.Commodity localCommodity = (Orders.Commodity)paramOrders.next();
        if ((localCommodity.qwE == 2) && (!bk.bl(localCommodity.qxf)))
        {
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletOrderInfoOldUI", "hy: has username and is force recommend");
          this.qDU.add(localCommodity.qxf);
        }
      }
    }
  }
  
  private void xK()
  {
    int j = 1;
    com.tencent.mm.wallet_core.c localc = com.tencent.mm.wallet_core.a.aj(this);
    this.nDu = ((PayInfo)this.BX.getParcelable("key_pay_info"));
    this.mKL = this.BX.getString("key_trans_id");
    this.BX.getInt("key_pay_type", -1);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoOldUI", "mTransId %s", new Object[] { this.mKL });
    this.qmc = bWG();
    if (this.qmc != null)
    {
      vN(0);
      c(this.qmc);
      int i;
      boolean bool1;
      if ((localc != null) && (this.qmc != null) && (this.nDu != null))
      {
        this.mAppId = this.nDu.appId;
        boolean bool2 = localc.cMo();
        com.tencent.mm.plugin.wallet_core.e.c.a(this, this.BX, 7);
        if (this.BX.getInt("key_support_bankcard", 1) == 2)
        {
          i = 2;
          com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.nFQ;
          int k = this.nDu.bUV;
          if (this.nDu.bUV != 3) {
            break label436;
          }
          bool1 = true;
          label189:
          if (!bool2) {
            break label442;
          }
          label194:
          localh.f(10691, new Object[] { Integer.valueOf(k), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(w.cMF()), Integer.valueOf((int)(this.qmc.nCq * 100.0D)), this.qmc.mOZ, Integer.valueOf(i) });
        }
      }
      else
      {
        if (((!o.bVs().bVN()) && (localc != null) && (localc.cMo())) || (!q.Gs())) {
          q.Gt();
        }
        if ((this.qmc == null) || (this.qmc.qwN == null) || (this.qmc.qwN.size() <= 0)) {
          break label447;
        }
        this.qDV = this.qmc.qwN;
        this.mKL = ((Orders.Commodity)this.qDV.get(0)).bMY;
        if ((this.nDu != null) && (localc != null) && ((localc.cMn()) || (localc.cMo()))) {
          bWL();
        }
      }
      for (;;)
      {
        if ((this.mKL == null) && (((i)com.tencent.mm.kernel.g.r(i.class)).f(this))) {
          this.qEK = false;
        }
        return;
        i = 1;
        break;
        label436:
        bool1 = false;
        break label189;
        label442:
        j = 2;
        break label194;
        label447:
        com.tencent.mm.sdk.platformtools.y.l("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
        com.tencent.mm.ui.base.h.a(this.mController.uMN, a.i.wallet_order_info_err, 0, new WalletOrderInfoOldUI.1(this));
      }
    }
    com.tencent.mm.sdk.platformtools.y.l("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
    com.tencent.mm.ui.base.h.a(this.mController.uMN, a.i.wallet_order_info_err, 0, new WalletOrderInfoOldUI.4(this));
  }
  
  public final void O(ad paramad)
  {
    if ((paramad != null) && ((int)paramad.dBe != 0))
    {
      String str = paramad.Bp();
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer nickName " + str + " username: " + paramad.field_username);
      if ((this.qDV != null) && (this.qDV.size() > 0))
      {
        Iterator localIterator = this.qDV.iterator();
        while (localIterator.hasNext()) {
          ((Orders.Commodity)localIterator.next()).mPa = str;
        }
        this.qEE.notifyDataSetChanged();
      }
      this.hcm = paramad.field_username;
    }
  }
  
  protected final void QK(String paramString)
  {
    bWx();
    e.l(this, paramString, false);
    this.qEK = false;
  }
  
  public void QM(String paramString)
  {
    a(new z(paramString), true, true);
  }
  
  protected final void a(Orders.Promotions paramPromotions)
  {
    a(new n(paramPromotions, bTO(), this.mKL, paramPromotions.qwo), true, false);
  }
  
  protected final void a(String paramString, WalletOrderInfoOldUI.d paramd)
  {
    bWx();
    this.qEJ = paramd;
    e.q(this, paramString, 1);
    this.qEK = false;
  }
  
  public Orders bWG()
  {
    return (Orders)this.BX.getParcelable("key_orders");
  }
  
  public final void bWK()
  {
    bWx();
    this.qEK = false;
    Object localObject1 = new an();
    ((an)localObject1).bGG.bGH = true;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("intent_pay_end_errcode", this.BX.getInt("intent_pay_end_errcode"));
    ((Bundle)localObject2).putString("intent_pay_app_url", this.BX.getString("intent_pay_app_url"));
    ((Bundle)localObject2).putBoolean("intent_pay_end", this.BX.getBoolean("intent_pay_end"));
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoOldUI", "pay done...feedbackData errCode:" + this.BX.getInt("intent_pay_end_errcode"));
    Iterator localIterator = this.qDU.iterator();
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (!bk.bl(str1))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoOldUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str1 });
        if ((this.qmc == null) || (this.nDu == null)) {
          break label333;
        }
        com.tencent.mm.ah.p localp = com.tencent.mm.kernel.g.DO().dJT;
        String str2 = this.qmc.bMX;
        if (this.qmc.qwN.size() <= 0) {
          break label327;
        }
        localObject1 = ((Orders.Commodity)this.qmc.qwN.get(0)).bMY;
        label244:
        localp.a(new com.tencent.mm.wallet_core.c.p(str1, str2, (String)localObject1, this.nDu.bUV, this.nDu.bUR, this.qmc.qwE), 0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(13033, new Object[] { Integer.valueOf(2), str1, "", "", "" });
        break;
        label327:
        localObject1 = "";
        break label244;
        label333:
        com.tencent.mm.kernel.g.DO().dJT.a(new com.tencent.mm.wallet_core.c.p(str1), 0);
      }
    }
    com.tencent.mm.wallet_core.a.j(this, (Bundle)localObject2);
    if ((this.qmc != null) && (!bk.bl(this.qmc.jxR))) {
      if (this.qmc.qwN.size() <= 0) {
        break label530;
      }
    }
    label530:
    for (localObject1 = ((Orders.Commodity)this.qmc.qwN.get(0)).bMY;; localObject1 = "")
    {
      localObject1 = d(this.qmc.jxR, this.qmc.bMX, (String)localObject1, this.nDu.ilD, this.nDu.fGK);
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletOrderInfoOldUI", "url = " + (String)localObject1);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
      ((Intent)localObject2).putExtra("showShare", false);
      ((Intent)localObject2).putExtra("geta8key_username", q.Gj());
      ((Intent)localObject2).putExtra("stastic_scene", 8);
      d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject2);
      return;
    }
  }
  
  public void bWL()
  {
    a(new com.tencent.mm.plugin.wallet_core.c.y(bTO(), 21), true, true);
  }
  
  public final void bWM()
  {
    if (this.qmc != null)
    {
      this.qDV = this.qmc.qwN;
      Iterator localIterator = this.qDV.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!"1".equals(((Orders.Commodity)localIterator.next()).mOS));
    }
    for (int i = 0;; i = 1)
    {
      this.qEB.setVisibility(0);
      this.qEC.setVisibility(0);
      if (i != 0)
      {
        if ((!bk.bl(this.qmc.qwG)) && (!bk.bl(this.qmc.qwG.trim())))
        {
          this.qEC.setText(this.qmc.qwG);
          return;
        }
        if (this.qmc.qqY != 1)
        {
          this.qEC.setText(a.i.wallet_order_info_result_success_international);
          return;
        }
        this.qEC.setText(a.i.wallet_order_info_result_success);
        return;
      }
      this.qEC.setText(a.i.wallet_order_info_result_wait);
      return;
    }
  }
  
  public final void bWx()
  {
    int i = 0;
    if (!this.qAJ)
    {
      is localis = new is();
      localis.bQT.bQU = 4;
      is.a locala = localis.bQT;
      if (this.BX.getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.aYY = i;
      com.tencent.mm.sdk.b.a.udP.m(localis);
      this.qAJ = true;
    }
  }
  
  protected final boolean bwM()
  {
    return false;
  }
  
  public boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i;
    if (((paramm instanceof aa)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      aa localaa = (aa)paramm;
      WalletOrderInfoOldUI.b localb = new WalletOrderInfoOldUI.b(this, localaa.gff);
      if ((!bk.bl(localb.url)) && (!bk.bl(localb.bQZ)))
      {
        i = 1;
        if (i != 0) {
          this.qAO.put(localaa.qrd, localb);
        }
        this.qEE.notifyDataSetChanged();
      }
    }
    else
    {
      if (!(paramm instanceof z)) {
        break label343;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        vN(0);
        this.qmc = ((z)paramm).qre;
        if (this.qmc != null) {
          this.qDV = this.qmc.qwN;
        }
        c(this.qmc);
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + this.qDV);
        if ((this.qDV != null) && (this.qDV.size() != 0))
        {
          paramString = (Orders.Commodity)this.qDV.get(0);
          this.mKL = paramString.bMY;
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + paramString.toString());
          paramm = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl(paramString.mPa);
          if ((paramm == null) || ((int)paramm.dBe == 0)) {
            break label322;
          }
          O(paramm);
        }
      }
    }
    for (;;)
    {
      this.qEE.notifyDataSetChanged();
      bWM();
      if (this.qEE != null) {
        this.qEE.notifyDataSetChanged();
      }
      bWN();
      return true;
      i = 0;
      break;
      label322:
      am.a.dVy.a(paramString.mPa, "", this.qEL);
    }
    label343:
    if ((paramm instanceof n))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (n)paramm;
        paramm = paramString.qqN;
        long l = paramString.qqQ.qqG;
        this.qEI.put(Long.valueOf(l), paramm);
        paramString.qqQ.qwp = paramString.dmU;
        if ((!"-1".equals(paramm)) && (!"0".equals(paramm)) && (!bk.bl(paramString.qqO))) {
          com.tencent.mm.ui.base.h.b(this, paramString.qqO, "", true);
        }
        while (!"0".equals(paramm))
        {
          this.qEE.notifyDataSetChanged();
          return true;
        }
        if (!bk.bl(paramString.qqO)) {}
        for (paramString = paramString.qqO;; paramString = getString(a.i.wallet_pay_award_got))
        {
          Toast.makeText(this, paramString, 0).show();
          break;
        }
      }
      if ((paramm instanceof n))
      {
        paramm = paramString;
        if (bk.bl(paramString)) {
          paramm = getString(a.i.wallet_unknown_err);
        }
        com.tencent.mm.ui.base.h.a(this, paramm, null, false, new WalletOrderInfoOldUI.2(this));
        return true;
      }
    }
    return false;
  }
  
  protected final void cG(String paramString, int paramInt)
  {
    a(new z(paramString, paramInt), true, true);
  }
  
  public void done()
  {
    if (this.BX.containsKey("key_realname_guide_helper"))
    {
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)this.BX.getParcelable("key_realname_guide_helper");
      if (localRealnameGuideHelper != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("realname_verify_process_jump_activity", ".ui.WalletOrderInfoOldUI");
        localBundle.putString("realname_verify_process_jump_plugin", "wallet_core");
        boolean bool = localRealnameGuideHelper.b(this, localBundle, new WalletOrderInfoOldUI.8(this));
        this.BX.remove("key_realname_guide_helper");
        if (!bool) {
          bWK();
        }
      }
      return;
    }
    bWK();
  }
  
  public final String gL(long paramLong)
  {
    if (this.qEI.containsKey(Long.valueOf(paramLong))) {
      return (String)this.qEI.get(Long.valueOf(paramLong));
    }
    return "-1";
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_order_info;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.wallet_order_info_ui_title);
    showHomeBtn(false);
    enableBackMenu(false);
    String str = getString(a.i.app_finish);
    Object localObject;
    if ((this.nDu != null) && (this.nDu.bUV == 2)) {
      if (!bk.bl(this.nDu.qLi)) {
        localObject = getString(a.i.app_back) + this.nDu.qLi;
      }
    }
    for (;;)
    {
      addTextOptionMenu(0, (String)localObject, new WalletOrderInfoOldUI.7(this));
      this.qEB = ((LinearLayout)findViewById(a.f.wallet_order_info_result_ll));
      this.qEC = ((TextView)findViewById(a.f.wallet_order_info_result));
      this.qED = ((TextView)findViewById(a.f.wallet_order_info_link_act));
      localObject = (MaxListView)findViewById(a.f.wallet_order_info);
      this.qEE = new WalletOrderInfoOldUI.a(this);
      ((MaxListView)localObject).setAdapter(this.qEE);
      bWM();
      bWN();
      ((ScrollView)findViewById(a.f.wallet_sv)).pageScroll(33);
      return;
      localObject = str;
      if (!bk.bl(this.nDu.appId))
      {
        localObject = str;
        if (!bk.bl(com.tencent.mm.pluginsdk.model.app.g.n(this, this.nDu.appId)))
        {
          localObject = getString(a.i.app_back) + com.tencent.mm.pluginsdk.model.app.g.n(this, this.nDu.appId);
          continue;
          localObject = str;
          if (this.qmc != null)
          {
            localObject = str;
            if (!bk.bl(this.qmc.qwY)) {
              localObject = this.qmc.qwY;
            }
          }
        }
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoOldUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1) {
      a(new aa(this.qEJ.qrd, this.qEJ.qEw, this.qEJ.qEx, this.qEJ.qEy, this.qEJ.bOT, this.qEJ.nzq, this.qEJ.qxP), true, true);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    vN(4);
    this.qDU = new HashSet();
    xK();
    initView();
    kh(1979);
    com.tencent.mm.sdk.b.a.udP.c(this.qEq);
    com.tencent.mm.sdk.b.a.udP.c(this.mNd);
    this.qEK = false;
  }
  
  @Deprecated
  protected Dialog onCreateDialog(int paramInt)
  {
    return com.tencent.mm.ui.base.h.a(this.mController.uMN, getString(a.i.wallet_order_info_phone), getResources().getStringArray(a.b.wallet_phone_call), "", new WalletOrderInfoOldUI.9(this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.sdk.b.a.udP.d(this.qEq);
    com.tencent.mm.sdk.b.a.udP.d(this.mNd);
    ki(1979);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      done();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOrderInfoOldUI", "onResume, isClickActivityTinyApp: %s", new Object[] { Boolean.valueOf(this.qEK) });
    if (this.qEK) {
      a(new aa(this.qEJ.qrd, this.qEJ.qEw, this.qEJ.qEx, this.qEJ.qEy, this.qEJ.bOT, this.qEJ.nzq, this.qEJ.qxP), true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI
 * JD-Core Version:    0.7.0.1
 */