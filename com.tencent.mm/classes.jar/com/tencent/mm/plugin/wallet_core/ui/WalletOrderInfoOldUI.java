package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ax;
import com.tencent.mm.g.a.ay;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.g.a.ko.a;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.ys;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.af;
import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.wallet_core.c.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class WalletOrderInfoOldUI
  extends WalletOrderInfoUI
{
  protected Orders CZT;
  protected boolean Dus;
  private HashMap<String, b> Dux;
  protected String Duy;
  private com.tencent.mm.sdk.b.c DyE;
  protected LinearLayout DyU;
  protected TextView DyV;
  protected TextView DyW;
  protected a DyX;
  protected String DyY;
  protected HashMap<String, TextView> DyZ;
  protected Set<String> Dyc;
  protected List<Orders.Commodity> Dyd;
  protected c Dza;
  protected Map<Long, String> Dzb;
  private d Dzc;
  private boolean Dzd;
  protected au.b.a Dze;
  private View.OnLongClickListener Dzf;
  protected boolean dmS;
  protected boolean dmT;
  protected boolean dmU;
  protected String lJm;
  protected String mAppId;
  protected PayInfo mPayInfo;
  protected String wNH;
  private com.tencent.mm.sdk.b.c wQx;
  protected String wTG;
  private String yuD;
  
  public WalletOrderInfoOldUI()
  {
    AppMethodBeat.i(71067);
    this.DyU = null;
    this.DyV = null;
    this.DyW = null;
    this.Dyd = null;
    this.DyX = null;
    this.lJm = null;
    this.wTG = null;
    this.Dus = false;
    this.Dyc = null;
    this.mAppId = "";
    this.DyY = null;
    this.dmS = true;
    this.dmT = false;
    this.dmU = false;
    this.DyZ = new HashMap();
    this.Dzb = new HashMap();
    this.Dux = new HashMap();
    this.Dzd = false;
    this.wQx = new com.tencent.mm.sdk.b.c() {};
    this.Dze = new WalletOrderInfoOldUI.6(this);
    this.Dzf = new WalletOrderInfoOldUI.11(this);
    this.DyE = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(71067);
  }
  
  private void Zm()
  {
    int j = 1;
    AppMethodBeat.i(71068);
    com.tencent.mm.wallet_core.d locald = com.tencent.mm.wallet_core.a.bs(this);
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.wNH = getInput().getString("key_trans_id");
    getInput().getInt("key_pay_type", -1);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletOrderInfoOldUI", "mTransId %s", new Object[] { this.wNH });
    this.CZT = eLn();
    if (this.CZT != null)
    {
      setContentViewVisibility(0);
      d(this.CZT);
      int i;
      boolean bool1;
      if ((locald != null) && (this.CZT != null) && (this.mPayInfo != null))
      {
        this.mAppId = this.mPayInfo.appId;
        boolean bool2 = locald.fVn();
        com.tencent.mm.plugin.wallet_core.utils.f.a(this, getInput(), 7);
        if (getInput().getInt("key_support_bankcard", 1) == 2)
        {
          i = 2;
          com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
          int k = this.mPayInfo.dDH;
          if (this.mPayInfo.dDH != 3) {
            break label454;
          }
          bool1 = true;
          label189:
          if (!bool2) {
            break label460;
          }
          label194:
          localg.f(10691, new Object[] { Integer.valueOf(k), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(ab.fVX()), Integer.valueOf((int)(this.CZT.dmz * 100.0D)), this.CZT.wSq, Integer.valueOf(i) });
        }
      }
      else
      {
        if (((!com.tencent.mm.plugin.wallet_core.model.t.eJf().eJH()) && (locald != null) && (locald.fVn())) || (!v.aAM())) {
          v.aAN();
        }
        if ((this.CZT == null) || (this.CZT.DpP == null) || (this.CZT.DpP.size() <= 0)) {
          break label465;
        }
        this.Dyd = this.CZT.DpP;
        this.wNH = ((Orders.Commodity)this.Dyd.get(0)).dmx;
        if ((this.mPayInfo != null) && (locald != null) && ((locald.fVm()) || (locald.fVn()))) {
          doSceneProgress(new ad(getPayReqKey(), 21));
        }
      }
      for (;;)
      {
        if (this.wNH != null) {
          break label532;
        }
        if (((com.tencent.mm.plugin.fingerprint.b.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.b.h.class)).i(this)) {
          this.Dzd = false;
        }
        AppMethodBeat.o(71068);
        return;
        i = 1;
        break;
        label454:
        bool1 = false;
        break label189;
        label460:
        j = 2;
        break label194;
        label465:
        com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
        com.tencent.mm.ui.base.h.a(getContext(), 2131765550, 0, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(71044);
            WalletOrderInfoOldUI.this.done();
            AppMethodBeat.o(71044);
          }
        });
      }
    }
    com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
    com.tencent.mm.ui.base.h.a(getContext(), 2131765550, 0, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(71046);
        WalletOrderInfoOldUI.this.finish();
        AppMethodBeat.o(71046);
      }
    });
    label532:
    AppMethodBeat.o(71068);
  }
  
  private void d(Orders paramOrders)
  {
    AppMethodBeat.i(71075);
    this.Dyc.clear();
    if ((paramOrders == null) || (paramOrders.DpP == null))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.WalletOrderInfoOldUI", "hy: orders is null");
      AppMethodBeat.o(71075);
      return;
    }
    paramOrders = paramOrders.DpP.iterator();
    while (paramOrders.hasNext())
    {
      Orders.Commodity localCommodity = (Orders.Commodity)paramOrders.next();
      if ((localCommodity.DpF == 2) && (!bu.isNullOrNil(localCommodity.Dqr)))
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.WalletOrderInfoOldUI", "hy: has username and is force recommend");
        this.Dyc.add(localCommodity.Dqr);
      }
    }
    AppMethodBeat.o(71075);
  }
  
  private void eKZ()
  {
    int i = 0;
    AppMethodBeat.i(71080);
    if (!this.Dus)
    {
      ko localko = new ko();
      localko.dyC.requestCode = 4;
      ko.a locala = localko.dyC;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.bZU = i;
      com.tencent.mm.sdk.b.a.IvT.l(localko);
      this.Dus = true;
    }
    AppMethodBeat.o(71080);
  }
  
  private void eLu()
  {
    AppMethodBeat.i(71077);
    if (this.CZT != null)
    {
      this.Dyd = this.CZT.DpP;
      Iterator localIterator = this.Dyd.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!"1".equals(((Orders.Commodity)localIterator.next()).wSj));
    }
    for (int i = 0;; i = 1)
    {
      this.DyU.setVisibility(0);
      this.DyV.setVisibility(0);
      if (i != 0)
      {
        if ((!bu.isNullOrNil(this.CZT.DpH)) && (!bu.isNullOrNil(this.CZT.DpH.trim())))
        {
          this.DyV.setText(this.CZT.DpH);
          AppMethodBeat.o(71077);
          return;
        }
        if (this.CZT.DgN != 1)
        {
          this.DyV.setText(2131765570);
          AppMethodBeat.o(71077);
          return;
        }
        this.DyV.setText(2131765569);
        AppMethodBeat.o(71077);
        return;
      }
      this.DyV.setText(2131765571);
      AppMethodBeat.o(71077);
      return;
    }
  }
  
  private void eLv()
  {
    AppMethodBeat.i(71089);
    if ((this.CZT != null) && (this.CZT.DpP != null) && (this.CZT.DpP.size() > 0) && (((Orders.Commodity)this.CZT.DpP.get(0)).DqB != null) && (!bu.isNullOrNil(((Orders.Commodity)this.CZT.DpP.get(0)).DqB.text)) && (!bu.isNullOrNil(((Orders.Commodity)this.CZT.DpP.get(0)).DqB.url)))
    {
      this.DyW.setVisibility(0);
      this.DyW.setText(((Orders.Commodity)this.CZT.DpP.get(0)).DqB.text);
      this.DyW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71052);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.wallet_core.ui.f.p(WalletOrderInfoOldUI.this, ((Orders.Commodity)WalletOrderInfoOldUI.this.CZT.DpP.get(0)).DqB.url, false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71052);
        }
      });
      AppMethodBeat.o(71089);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletOrderInfoOldUI", "hy: no commodity or no link act or link act is illegal!");
    this.DyW.setVisibility(8);
    AppMethodBeat.o(71089);
  }
  
  public final String CF(long paramLong)
  {
    AppMethodBeat.i(71091);
    if (this.Dzb.containsKey(Long.valueOf(paramLong)))
    {
      String str = (String)this.Dzb.get(Long.valueOf(paramLong));
      AppMethodBeat.o(71091);
      return str;
    }
    AppMethodBeat.o(71091);
    return "-1";
  }
  
  protected final void XP(String paramString)
  {
    AppMethodBeat.i(71079);
    eKZ();
    com.tencent.mm.wallet_core.ui.f.p(this, paramString, false);
    this.Dzd = false;
    AppMethodBeat.o(71079);
  }
  
  protected final void a(Orders.Promotions paramPromotions)
  {
    AppMethodBeat.i(71074);
    doSceneForceProgress(new s(paramPromotions, getPayReqKey(), this.wNH, paramPromotions.Dpq));
    AppMethodBeat.o(71074);
  }
  
  protected final void a(String paramString, d paramd)
  {
    AppMethodBeat.i(71078);
    eKZ();
    this.Dzc = paramd;
    com.tencent.mm.wallet_core.ui.f.a(this, paramString, false, 1);
    this.Dzd = false;
    AppMethodBeat.o(71078);
  }
  
  protected final void aGp(String paramString)
  {
    AppMethodBeat.i(71072);
    doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ae(paramString));
    AppMethodBeat.o(71072);
  }
  
  protected final void ag(com.tencent.mm.storage.an paraman)
  {
    AppMethodBeat.i(71081);
    if ((paraman != null) && ((int)paraman.ght != 0))
    {
      String str = paraman.adF();
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer nickName " + str + " username: " + paraman.field_username);
      if ((this.Dyd != null) && (this.Dyd.size() > 0))
      {
        Iterator localIterator = this.Dyd.iterator();
        while (localIterator.hasNext()) {
          ((Orders.Commodity)localIterator.next()).wSr = str;
        }
        this.DyX.notifyDataSetChanged();
      }
      this.lJm = paraman.field_username;
    }
    AppMethodBeat.o(71081);
  }
  
  protected final boolean dNn()
  {
    return false;
  }
  
  public void done()
  {
    AppMethodBeat.i(71083);
    if (getInput().containsKey("key_realname_guide_helper"))
    {
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)getInput().getParcelable("key_realname_guide_helper");
      if (localRealnameGuideHelper != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("realname_verify_process_jump_activity", ".ui.WalletOrderInfoOldUI");
        localBundle.putString("realname_verify_process_jump_plugin", "wallet_core");
        boolean bool = localRealnameGuideHelper.b(this, localBundle, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(71050);
            WalletOrderInfoOldUI.this.eLt();
            AppMethodBeat.o(71050);
          }
        });
        getInput().remove("key_realname_guide_helper");
        if (!bool) {
          eLt();
        }
      }
      AppMethodBeat.o(71083);
      return;
    }
    eLt();
    AppMethodBeat.o(71083);
  }
  
  protected Orders eLn()
  {
    AppMethodBeat.i(71070);
    Orders localOrders = (Orders)getInput().getParcelable("key_orders");
    AppMethodBeat.o(71070);
    return localOrders;
  }
  
  public final void eLt()
  {
    AppMethodBeat.i(71084);
    eKZ();
    this.Dzd = false;
    Object localObject1 = new ax();
    ((ax)localObject1).dmN.dmO = true;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("intent_pay_end_errcode", getInput().getInt("intent_pay_end_errcode"));
    ((Bundle)localObject2).putString("intent_pay_app_url", getInput().getString("intent_pay_app_url"));
    ((Bundle)localObject2).putBoolean("intent_pay_end", getInput().getBoolean("intent_pay_end"));
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletOrderInfoOldUI", "pay done...feedbackData errCode:" + getInput().getInt("intent_pay_end_errcode"));
    Iterator localIterator = this.Dyc.iterator();
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (!bu.isNullOrNil(str1))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletOrderInfoOldUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str1 });
        if ((this.CZT == null) || (this.mPayInfo == null)) {
          break label339;
        }
        q localq = com.tencent.mm.kernel.g.ajQ().gDv;
        String str2 = this.CZT.dmw;
        if (this.CZT.DpP.size() <= 0) {
          break label333;
        }
        localObject1 = ((Orders.Commodity)this.CZT.DpP.get(0)).dmx;
        label250:
        localq.a(new com.tencent.mm.wallet_core.c.t(str1, str2, (String)localObject1, this.mPayInfo.dDH, this.mPayInfo.channel, this.CZT.DpF), 0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(13033, new Object[] { Integer.valueOf(2), str1, "", "", "" });
        break;
        label333:
        localObject1 = "";
        break label250;
        label339:
        com.tencent.mm.kernel.g.ajQ().gDv.a(new com.tencent.mm.wallet_core.c.t(str1), 0);
      }
    }
    com.tencent.mm.wallet_core.a.k(this, (Bundle)localObject2);
    if ((this.CZT != null) && (!bu.isNullOrNil(this.CZT.qlv))) {
      if (this.CZT.DpP.size() <= 0) {
        break label535;
      }
    }
    label535:
    for (localObject1 = ((Orders.Commodity)this.CZT.DpP.get(0)).dmx;; localObject1 = "")
    {
      localObject1 = e(this.CZT.qlv, this.CZT.dmw, (String)localObject1, this.mPayInfo.oED, this.mPayInfo.iWF);
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.WalletOrderInfoOldUI", "url = ".concat(String.valueOf(localObject1)));
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
      ((Intent)localObject2).putExtra("showShare", false);
      ((Intent)localObject2).putExtra("geta8key_username", v.aAC());
      ((Intent)localObject2).putExtra("stastic_scene", 8);
      com.tencent.mm.br.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject2);
      AppMethodBeat.o(71084);
      return;
    }
  }
  
  protected final void fx(String paramString, int paramInt)
  {
    AppMethodBeat.i(71073);
    doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ae(paramString, paramInt));
    AppMethodBeat.o(71073);
  }
  
  public int getLayoutId()
  {
    return 2131495996;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71076);
    setMMTitle(2131765584);
    showHomeBtn(false);
    enableBackMenu(false);
    String str = getString(2131755779);
    Object localObject;
    if ((this.mPayInfo != null) && (this.mPayInfo.dDH == 2)) {
      if (!bu.isNullOrNil(this.mPayInfo.DHy)) {
        localObject = getString(2131755281) + this.mPayInfo.DHy;
      }
    }
    for (;;)
    {
      addTextOptionMenu(0, (String)localObject, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(71049);
          WalletOrderInfoOldUI.this.done();
          AppMethodBeat.o(71049);
          return true;
        }
      });
      this.DyU = ((LinearLayout)findViewById(2131306794));
      this.DyV = ((TextView)findViewById(2131306793));
      this.DyW = ((TextView)findViewById(2131306786));
      localObject = (MaxListView)findViewById(2131306770);
      this.DyX = new a();
      ((MaxListView)localObject).setAdapter(this.DyX);
      eLu();
      eLv();
      ((ScrollView)findViewById(2131306834)).pageScroll(33);
      AppMethodBeat.o(71076);
      return;
      localObject = str;
      if (!bu.isNullOrNil(this.mPayInfo.appId))
      {
        localObject = str;
        if (!bu.isNullOrNil(com.tencent.mm.pluginsdk.model.app.h.r(this, this.mPayInfo.appId)))
        {
          localObject = getString(2131755281) + com.tencent.mm.pluginsdk.model.app.h.r(this, this.mPayInfo.appId);
          continue;
          localObject = str;
          if (this.CZT != null)
          {
            localObject = str;
            if (!bu.isNullOrNil(this.CZT.Dqa)) {
              localObject = this.CZT.Dqa;
            }
          }
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71088);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletOrderInfoOldUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1) {
      doSceneProgress(new af(this.Dzc.DgU, this.Dzc.DyP, this.Dzc.DyQ, this.Dzc.DyR, this.Dzc.dwj, this.Dzc.yoZ, this.Dzc.Drb));
    }
    AppMethodBeat.o(71088);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71069);
    super.onCreate(paramBundle);
    setContentViewVisibility(4);
    this.Dyc = new HashSet();
    Zm();
    initView();
    addSceneEndListener(1979);
    com.tencent.mm.sdk.b.a.IvT.c(this.DyE);
    com.tencent.mm.sdk.b.a.IvT.c(this.wQx);
    this.Dzd = false;
    AppMethodBeat.o(71069);
  }
  
  @Deprecated
  public Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(71086);
    Dialog localDialog = com.tencent.mm.ui.base.h.a(getContext(), getString(2131765565), getResources().getStringArray(2130903098), "", new WalletOrderInfoOldUI.9(this));
    AppMethodBeat.o(71086);
    return localDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71082);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.IvT.d(this.DyE);
    com.tencent.mm.sdk.b.a.IvT.d(this.wQx);
    removeSceneEndListener(1979);
    AppMethodBeat.o(71082);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(71085);
    if (paramInt == 4)
    {
      done();
      AppMethodBeat.o(71085);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(71085);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71087);
    super.onResume();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletOrderInfoOldUI", "onResume, isClickActivityTinyApp: %s", new Object[] { Boolean.valueOf(this.Dzd) });
    if (this.Dzd) {
      doSceneProgress(new af(this.Dzc.DgU, this.Dzc.DyP, this.Dzc.DyQ, this.Dzc.DyR, this.Dzc.dwj, this.Dzc.yoZ, this.Dzc.Drb));
    }
    AppMethodBeat.o(71087);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71090);
    int i;
    if (((paramn instanceof af)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      af localaf = (af)paramn;
      b localb = new b(localaf.kuc);
      if ((!bu.isNullOrNil(localb.url)) && (!bu.isNullOrNil(localb.dyI)))
      {
        i = 1;
        if (i != 0) {
          this.Dux.put(localaf.DgU, localb);
        }
        this.DyX.notifyDataSetChanged();
      }
    }
    else
    {
      if (!(paramn instanceof com.tencent.mm.plugin.wallet_core.c.ae)) {
        break label355;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        setContentViewVisibility(0);
        this.CZT = ((com.tencent.mm.plugin.wallet_core.c.ae)paramn).DgZ;
        if (this.CZT != null) {
          this.Dyd = this.CZT.DpP;
        }
        d(this.CZT);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + this.Dyd);
        if ((this.Dyd != null) && (this.Dyd.size() != 0))
        {
          paramString = (Orders.Commodity)this.Dyd.get(0);
          this.wNH = paramString.dmx;
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + paramString.toString());
          paramn = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramString.wSr);
          if ((paramn == null) || ((int)paramn.ght == 0)) {
            break label334;
          }
          ag(paramn);
        }
      }
    }
    for (;;)
    {
      this.DyX.notifyDataSetChanged();
      eLu();
      if (this.DyX != null) {
        this.DyX.notifyDataSetChanged();
      }
      eLv();
      AppMethodBeat.o(71090);
      return true;
      i = 0;
      break;
      label334:
      au.a.hIG.a(paramString.wSr, "", this.Dze);
    }
    label355:
    if ((paramn instanceof s))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (s)paramn;
        paramn = paramString.DgC;
        long l = paramString.DgF.vlr;
        this.Dzb.put(Long.valueOf(l), paramn);
        paramString.DgF.Dpr = paramString.fMT;
        if ((!"-1".equals(paramn)) && (!"0".equals(paramn)) && (!bu.isNullOrNil(paramString.DgD))) {
          com.tencent.mm.ui.base.h.c(this, paramString.DgD, "", true);
        }
        while (!"0".equals(paramn))
        {
          this.DyX.notifyDataSetChanged();
          AppMethodBeat.o(71090);
          return true;
        }
        if (!bu.isNullOrNil(paramString.DgD)) {}
        for (paramString = paramString.DgD;; paramString = getString(2131765658))
        {
          Toast.makeText(this, paramString, 0).show();
          break;
        }
      }
      if ((paramn instanceof s))
      {
        paramn = paramString;
        if (bu.isNullOrNil(paramString)) {
          paramn = getString(2131765901);
        }
        com.tencent.mm.ui.base.h.a(this, paramn, null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(71090);
        return true;
      }
    }
    AppMethodBeat.o(71090);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
    extends BaseAdapter
  {
    public a() {}
    
    private Orders.Commodity Wn(int paramInt)
    {
      AppMethodBeat.i(71057);
      Orders.Commodity localCommodity = (Orders.Commodity)WalletOrderInfoOldUI.this.Dyd.get(paramInt);
      AppMethodBeat.o(71057);
      return localCommodity;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(71056);
      if (WalletOrderInfoOldUI.this.Dyd != null)
      {
        int i = WalletOrderInfoOldUI.this.Dyd.size();
        AppMethodBeat.o(71056);
        return i;
      }
      AppMethodBeat.o(71056);
      return 0;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(71058);
      final Orders.Commodity localCommodity;
      label398:
      Object localObject1;
      Object localObject2;
      label436:
      Orders.DiscountInfo localDiscountInfo;
      TextView localTextView;
      if (paramView == null)
      {
        paramView = View.inflate(WalletOrderInfoOldUI.this, 2131495997, null);
        paramViewGroup = new a();
        paramViewGroup.Dzj = ((TextView)paramView.findViewById(2131306772));
        paramViewGroup.iFO = ((TextView)paramView.findViewById(2131306777));
        paramViewGroup.Dzm = ((TextView)paramView.findViewById(2131306798));
        paramViewGroup.Dzk = ((TextView)paramView.findViewById(2131306804));
        paramViewGroup.Dzl = ((TextView)paramView.findViewById(2131306790));
        paramViewGroup.Dzl.getPaint().setFlags(16);
        paramViewGroup.Dzn = ((TextView)paramView.findViewById(2131306805));
        paramViewGroup.Dzo = ((TextView)paramView.findViewById(2131306775));
        paramViewGroup.Dzp = ((TextView)paramView.findViewById(2131306771));
        paramViewGroup.Dzr = ((MaxListView)paramView.findViewById(2131306792));
        paramViewGroup.Dzs = paramView.findViewById(2131306780);
        paramViewGroup.Dzq = paramView.findViewById(2131306796);
        paramViewGroup.Dzu = ((TextView)paramView.findViewById(2131306807));
        paramViewGroup.Dzt = ((TextView)paramView.findViewById(2131306808));
        paramViewGroup.Dzv = ((TextView)paramView.findViewById(2131306809));
        paramViewGroup.Dzw = ((TextView)paramView.findViewById(2131306810));
        paramViewGroup.Dzy = ((ViewGroup)paramView.findViewById(2131306801));
        paramViewGroup.DuE = ((CdnImageView)paramView.findViewById(2131305857));
        paramViewGroup.DuF = ((TextView)paramView.findViewById(2131305853));
        paramViewGroup.DuG = ((TextView)paramView.findViewById(2131305858));
        paramViewGroup.Dzx = paramView.findViewById(2131306797);
        paramView.setTag(paramViewGroup);
        localCommodity = Wn(paramInt);
        if ((localCommodity == null) || (paramViewGroup == null)) {
          break label1188;
        }
        WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this, localCommodity.dmx);
        paramViewGroup.Dzk.setText(com.tencent.mm.wallet_core.ui.f.d(localCommodity.phz, localCommodity.wSq));
        if ((localCommodity.Dqq < 0.0D) || (localCommodity.phz >= localCommodity.Dqq)) {
          break label632;
        }
        paramViewGroup.Dzl.setText(com.tencent.mm.wallet_core.ui.f.d(localCommodity.Dqq, localCommodity.wSq));
        paramViewGroup.Dzl.setVisibility(0);
        localObject1 = (LinearLayout)paramViewGroup.Dzs;
        localObject2 = localCommodity.Dqt;
        ((LinearLayout)localObject1).removeAllViews();
        if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
          break label657;
        }
        paramInt = 0;
        if (paramInt >= ((List)localObject2).size()) {
          break label657;
        }
        localDiscountInfo = (Orders.DiscountInfo)((List)localObject2).get(paramInt);
        localTextView = new TextView(WalletOrderInfoOldUI.this.getContext());
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = WalletOrderInfoOldUI.this.getContext().getResources().getDimensionPixelOffset(2131165187);
        localTextView.setLayoutParams(localLayoutParams);
        localTextView.setTextAppearance(WalletOrderInfoOldUI.this.getContext(), 2131821165);
        if (localDiscountInfo.DqL <= 0.0D) {
          break label644;
        }
        localTextView.setText(localDiscountInfo.ynr + com.tencent.mm.wallet_core.ui.f.d(localDiscountInfo.DqL / 100.0D, WalletOrderInfoOldUI.this.CZT.wSq));
      }
      for (;;)
      {
        ((LinearLayout)localObject1).addView(localTextView);
        localTextView.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(2131101106));
        paramInt += 1;
        break label436;
        paramViewGroup = (a)paramView.getTag();
        break;
        label632:
        paramViewGroup.Dzl.setVisibility(8);
        break label398;
        label644:
        localTextView.setText(localDiscountInfo.ynr);
      }
      label657:
      if (((LinearLayout)localObject1).getChildCount() > 0)
      {
        ((LinearLayout)localObject1).setVisibility(0);
        localObject2 = paramViewGroup.Dzj;
        localObject1 = WalletOrderInfoOldUI.this;
        if (!v.aAR()) {
          break label1205;
        }
        localObject1 = ((Context)localObject1).getString(2131765564);
        label699:
        ((TextView)localObject2).setText((CharSequence)localObject1);
        paramViewGroup.Dzm.setText(localCommodity.wSf);
        paramViewGroup.iFO.setText(localCommodity.desc);
        paramViewGroup.iFO.setTag(localCommodity.desc);
        paramViewGroup.iFO.setOnLongClickListener(WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this));
        paramViewGroup.iFO.setBackgroundResource(2131234695);
        paramViewGroup.Dzn.setText(localCommodity.dmx);
        paramViewGroup.Dzn.setTag(localCommodity.dmx);
        paramViewGroup.Dzn.setOnLongClickListener(WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this));
        paramViewGroup.Dzn.setBackgroundResource(2131234695);
        paramViewGroup.Dzo.setText(com.tencent.mm.wallet_core.ui.f.oy(localCommodity.wSm));
        paramViewGroup.Dzp.setText(localCommodity.wSo);
        localObject1 = localCommodity.Dqu;
        if (paramViewGroup.Dzv != null)
        {
          if (bu.isNullOrNil((String)localObject1)) {
            break label1218;
          }
          paramViewGroup.Dzv.setText((CharSequence)localObject1);
          paramViewGroup.Dzv.setVisibility(0);
          paramViewGroup.Dzw.setVisibility(0);
        }
        label888:
        localObject1 = localCommodity.Dqw;
        if (paramViewGroup.Dzu != null)
        {
          if (bu.isNullOrNil((String)localObject1)) {
            break label1239;
          }
          paramViewGroup.Dzu.setText((CharSequence)localObject1);
          paramViewGroup.Dzu.setVisibility(0);
          paramViewGroup.Dzt.setVisibility(0);
        }
        label935:
        if (localCommodity.Dqz.size() <= 0) {
          break label1260;
        }
        localObject1 = (Orders.Promotions)localCommodity.Dqz.get(0);
        com.tencent.mm.plugin.report.service.g.yxI.f(13033, new Object[] { Integer.valueOf(1), ((Orders.Promotions)localObject1).wSr, ((Orders.Promotions)localObject1).url, ((Orders.Promotions)localObject1).name, WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this) });
        WalletOrderInfoOldUI.this.Dza = new WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this, localCommodity.Dqz);
        paramViewGroup.Dzr.setAdapter(WalletOrderInfoOldUI.this.Dza);
        paramViewGroup.Dzr.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(71054);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousAdapterView);
            localb.bd(paramAnonymousView);
            localb.mu(paramAnonymousInt);
            localb.rl(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
            paramAnonymousAdapterView = WalletOrderInfoOldUI.this.Dza.Wo(paramAnonymousInt);
            if (!bu.isNullOrNil(paramAnonymousAdapterView.wSr)) {
              if (WalletOrderInfoOldUI.this.Dyc.contains(paramAnonymousAdapterView.wSr))
              {
                WalletOrderInfoOldUI.this.Dyc.remove(paramAnonymousAdapterView.wSr);
                WalletOrderInfoOldUI.this.DyX.notifyDataSetChanged();
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(71054);
              return;
              WalletOrderInfoOldUI.this.Dyc.add(paramAnonymousAdapterView.wSr);
              break;
              paramAnonymousView = WalletOrderInfoOldUI.this.CF(paramAnonymousAdapterView.vlr);
              if (("-1".equals(paramAnonymousView)) || ("3".equals(paramAnonymousView)))
              {
                com.tencent.mm.plugin.report.service.g.yxI.f(13472, new Object[] { WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this), Integer.valueOf(paramAnonymousAdapterView.JhR), Integer.valueOf(1), Long.valueOf(paramAnonymousAdapterView.vlr), Long.valueOf(paramAnonymousAdapterView.Dpq) });
                com.tencent.mm.plugin.report.service.g.yxI.f(13033, new Object[] { Integer.valueOf(2), "", paramAnonymousAdapterView.url, paramAnonymousAdapterView.name, "" });
                if ((!bu.isNullOrNil(paramAnonymousAdapterView.JhU)) && (!bu.isNullOrNil(paramAnonymousAdapterView.JhV)))
                {
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletOrderInfoOldUI", "promotion jump tiny app, username: %s, path: %s", new Object[] { paramAnonymousAdapterView.JhU, paramAnonymousAdapterView.JhV });
                  paramAnonymousView = new vq();
                  paramAnonymousView.dKT.userName = paramAnonymousAdapterView.JhU;
                  paramAnonymousView.dKT.dKV = bu.bI(paramAnonymousAdapterView.JhV, "");
                  paramAnonymousView.dKT.scene = 1060;
                  paramAnonymousView.dKT.dlj = WalletOrderInfoOldUI.this.wNH;
                  paramAnonymousView.dKT.dKW = 0;
                  com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
                  com.tencent.mm.plugin.report.service.g.yxI.f(14118, new Object[] { WalletOrderInfoOldUI.this.wNH, WalletOrderInfoOldUI.this.getPayReqKey(), Integer.valueOf(2) });
                  WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this, new WalletOrderInfoOldUI.d(WalletOrderInfoOldUI.this, paramAnonymousAdapterView.vlr, paramAnonymousAdapterView.JhS, paramAnonymousAdapterView.Dpo, paramAnonymousAdapterView.Dpp, WalletOrderInfoOldUI.this.getPayReqKey(), WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this), paramAnonymousAdapterView.Dpq));
                  WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this, true);
                }
                else if (paramAnonymousAdapterView.JhR == 1)
                {
                  WalletOrderInfoOldUI.this.a(paramAnonymousAdapterView);
                }
                else if ((paramAnonymousAdapterView.JhR == 2) && (!bu.isNullOrNil(paramAnonymousAdapterView.url)))
                {
                  if (WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this).containsKey(paramAnonymousAdapterView.vlr))
                  {
                    paramAnonymousAdapterView = (WalletOrderInfoOldUI.b)WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this).get(paramAnonymousAdapterView.vlr);
                    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletOrderInfoOldUI", "go to new url %s", new Object[] { paramAnonymousAdapterView.url });
                    WalletOrderInfoOldUI.this.XP(paramAnonymousAdapterView.url);
                  }
                  else
                  {
                    WalletOrderInfoOldUI.this.Duy = paramAnonymousAdapterView.url;
                    WalletOrderInfoOldUI.this.a(paramAnonymousAdapterView.url, new WalletOrderInfoOldUI.d(WalletOrderInfoOldUI.this, paramAnonymousAdapterView.vlr, paramAnonymousAdapterView.JhS, paramAnonymousAdapterView.Dpo, paramAnonymousAdapterView.Dpp, WalletOrderInfoOldUI.this.getPayReqKey(), WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this), paramAnonymousAdapterView.Dpq));
                  }
                }
                else
                {
                  com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WalletOrderInfoOldUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
                }
              }
            }
          }
        });
        WalletOrderInfoOldUI.this.Dza.notifyDataSetChanged();
        paramViewGroup.Dzr.setVisibility(0);
        paramViewGroup.Dzq.setVisibility(0);
        label1096:
        if ((localCommodity.Dqx == null) || (bu.isNullOrNil(localCommodity.Dqx.CRv))) {
          break label1290;
        }
        paramViewGroup.DuE.setUrl(localCommodity.Dqx.Dpt);
        paramViewGroup.DuF.setText(localCommodity.Dqx.Dpu);
        paramViewGroup.DuG.setText(localCommodity.Dqx.DfD);
        paramViewGroup.Dzy.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71055);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            paramAnonymousView = new vq();
            paramAnonymousView.dKT.userName = localCommodity.Dqx.CRv;
            paramAnonymousView.dKT.dKV = bu.bI(localCommodity.Dqx.CRw, "");
            paramAnonymousView.dKT.scene = 1034;
            paramAnonymousView.dKT.dKW = 0;
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
            com.tencent.mm.plugin.report.service.g.yxI.f(14118, new Object[] { WalletOrderInfoOldUI.this.wNH, WalletOrderInfoOldUI.this.getPayReqKey(), Integer.valueOf(1) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71055);
          }
        });
        paramViewGroup.Dzx.setVisibility(0);
      }
      for (;;)
      {
        label1188:
        AppMethodBeat.o(71058);
        return paramView;
        ((LinearLayout)localObject1).setVisibility(8);
        break;
        label1205:
        localObject1 = ((Context)localObject1).getString(2131765563);
        break label699;
        label1218:
        paramViewGroup.Dzw.setVisibility(8);
        paramViewGroup.Dzv.setVisibility(8);
        break label888;
        label1239:
        paramViewGroup.Dzt.setVisibility(8);
        paramViewGroup.Dzu.setVisibility(8);
        break label935;
        label1260:
        paramViewGroup.Dzr.setVisibility(8);
        paramViewGroup.Dzy.setVisibility(8);
        paramViewGroup.Dzq.setVisibility(8);
        break label1096;
        label1290:
        paramViewGroup.Dzy.setVisibility(8);
        paramViewGroup.Dzx.setVisibility(8);
      }
    }
    
    final class a
    {
      CdnImageView DuE;
      TextView DuF;
      TextView DuG;
      TextView Dzj;
      TextView Dzk;
      TextView Dzl;
      TextView Dzm;
      TextView Dzn;
      TextView Dzo;
      TextView Dzp;
      View Dzq;
      MaxListView Dzr;
      View Dzs;
      TextView Dzt;
      TextView Dzu;
      TextView Dzv;
      TextView Dzw;
      View Dzx;
      ViewGroup Dzy;
      TextView iFO;
      
      a() {}
    }
  }
  
  final class b
  {
    public String DyN;
    public String dEM;
    public String dyI;
    public String title;
    public String url;
    
    public b(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(71060);
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(71060);
        return;
      }
      this$1 = paramJSONObject.optJSONObject("activity_change_info");
      if (WalletOrderInfoOldUI.this != null)
      {
        this.url = WalletOrderInfoOldUI.this.optString("url");
        this.dyI = WalletOrderInfoOldUI.this.optString("wording");
        this.dEM = WalletOrderInfoOldUI.this.optString("icon");
        this.DyN = WalletOrderInfoOldUI.this.optString("btn_text");
        this.title = WalletOrderInfoOldUI.this.optString("title");
      }
      AppMethodBeat.o(71060);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(71061);
      String str = this.url + " , " + this.dyI + " , " + this.dEM + " , " + this.DyN + " , " + this.title;
      AppMethodBeat.o(71061);
      return str;
    }
  }
  
  final class c
    extends BaseAdapter
  {
    protected List<Orders.Promotions> Dqz;
    
    public c()
    {
      AppMethodBeat.i(71062);
      this.Dqz = null;
      this.Dqz = new ArrayList();
      Object localObject;
      int j = localObject.size();
      int i = 0;
      while (i < j)
      {
        this$1 = (Orders.Promotions)localObject.get(i);
        if ((WalletOrderInfoOldUI.this != null) && ((!bu.isNullOrNil(WalletOrderInfoOldUI.this.wSr)) || (WalletOrderInfoOldUI.this.JhR == 2) || (WalletOrderInfoOldUI.this.JhR == 1))) {
          this.Dqz.add(localObject.get(i));
        }
        i += 1;
      }
      AppMethodBeat.o(71062);
    }
    
    public final Orders.Promotions Wo(int paramInt)
    {
      AppMethodBeat.i(71064);
      Orders.Promotions localPromotions = (Orders.Promotions)this.Dqz.get(paramInt);
      AppMethodBeat.o(71064);
      return localPromotions;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(71063);
      if (this.Dqz != null)
      {
        int i = this.Dqz.size();
        AppMethodBeat.o(71063);
        return i;
      }
      AppMethodBeat.o(71063);
      return 0;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(71065);
      Orders.Promotions localPromotions = Wo(paramInt);
      Object localObject;
      if ((bu.isNullOrNil(localPromotions.wSr)) && (localPromotions.vlr > 0L))
      {
        localObject = WalletOrderInfoOldUI.this.CF(localPromotions.vlr);
        com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
        String str = WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this);
        paramInt = localPromotions.JhR;
        paramViewGroup = (ViewGroup)localObject;
        if ("-1".equals(localObject)) {
          paramViewGroup = Integer.valueOf(5);
        }
        localg.f(13471, new Object[] { str, Integer.valueOf(1), Integer.valueOf(paramInt), paramViewGroup, Long.valueOf(localPromotions.vlr), Long.valueOf(localPromotions.Dpq) });
      }
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramViewGroup.type = localPromotions.type;
        if (localPromotions.type == Orders.Dqp) {
          if (localPromotions.DqM == 1)
          {
            paramView = View.inflate(WalletOrderInfoOldUI.this, 2131495998, null);
            paramViewGroup.oTd = ((CdnImageView)paramView.findViewById(2131306787));
            paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131306802));
            paramViewGroup.Dzz = ((TextView)paramView.findViewById(2131306774));
            paramViewGroup.fSj = ((TextView)paramView.findViewById(2131306789));
            if (!TextUtils.isEmpty(localPromotions.url)) {
              WalletOrderInfoOldUI.this.DyZ.put(localPromotions.url, paramViewGroup.Dzz);
            }
            paramView.setTag(paramViewGroup);
            paramViewGroup.DqM = localPromotions.DqM;
          }
        }
      }
      label293:
      label1586:
      for (;;)
      {
        if (localPromotions != null)
        {
          localObject = (WalletOrderInfoOldUI.b)WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this).get(localPromotions.vlr);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletOrderInfoOldUI", "try get result ".concat(String.valueOf(localObject)));
          if (localObject == null) {
            break label1306;
          }
          paramViewGroup.oTd.setUrl(((WalletOrderInfoOldUI.b)localObject).dEM);
          paramViewGroup.fSj.setText(((WalletOrderInfoOldUI.b)localObject).dyI);
          paramViewGroup.Dzz.setText(((WalletOrderInfoOldUI.b)localObject).DyN);
          if (bu.isNullOrNil(localPromotions.wSr)) {
            break label1356;
          }
          paramViewGroup.Dzz.setVisibility(8);
          if (paramViewGroup.DzA != null)
          {
            paramViewGroup.DzA.setVisibility(0);
            if (!WalletOrderInfoOldUI.this.Dyc.contains(localPromotions.wSr)) {
              break label1345;
            }
            paramViewGroup.DzA.setChecked(true);
          }
          label450:
          if ((paramViewGroup.titleTv == null) || (localObject == null) || (bu.isNullOrNil(((WalletOrderInfoOldUI.b)localObject).title))) {
            break label1383;
          }
          paramViewGroup.titleTv.setText(((WalletOrderInfoOldUI.b)localObject).title);
          label485:
          if ((!bu.isNullOrNil(WalletOrderInfoOldUI.this.Duy)) && (paramViewGroup.Dzz != null))
          {
            paramViewGroup.Dzz.setClickable(WalletOrderInfoOldUI.this.dmS);
            paramViewGroup.Dzz.setEnabled(WalletOrderInfoOldUI.this.dmS);
            paramViewGroup.Dzz.setOnClickListener(null);
            if (WalletOrderInfoOldUI.this.dmT) {
              paramViewGroup.Dzz.setVisibility(8);
            }
          }
          long l = localPromotions.vlr;
          localObject = WalletOrderInfoOldUI.this.CF(l);
          if (!((String)localObject).equals("0")) {
            break label1435;
          }
          paramViewGroup.Dzz.setBackgroundColor(WalletOrderInfoOldUI.this.getResources().getColor(2131101053));
          paramViewGroup.Dzz.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(2131101171));
        }
        for (;;)
        {
          if (paramViewGroup.Dzz != null)
          {
            paramInt = BackwardSupportUtil.b.h(WalletOrderInfoOldUI.this.getContext(), 15.0F);
            i = BackwardSupportUtil.b.h(WalletOrderInfoOldUI.this.getContext(), 5.0F);
            paramViewGroup.Dzz.setPadding(paramInt, i, paramInt, i);
          }
          AppMethodBeat.o(71065);
          return paramView;
          paramView = View.inflate(WalletOrderInfoOldUI.this, 2131495999, null);
          paramViewGroup.oTd = ((CdnImageView)paramView.findViewById(2131306787));
          paramViewGroup.Dzz = ((TextView)paramView.findViewById(2131306774));
          paramViewGroup.fSj = ((TextView)paramView.findViewById(2131306789));
          paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131306802));
          if (!TextUtils.isEmpty(localPromotions.url)) {
            WalletOrderInfoOldUI.this.DyZ.put(localPromotions.url, paramViewGroup.Dzz);
          }
          paramView.setTag(paramViewGroup);
          break;
          paramView = View.inflate(WalletOrderInfoOldUI.this, 2131496000, null);
          paramViewGroup.oTd = ((CdnImageView)paramView.findViewById(2131306787));
          paramViewGroup.Dzz = ((TextView)paramView.findViewById(2131306774));
          paramViewGroup.fSj = ((TextView)paramView.findViewById(2131306789));
          paramViewGroup.DzA = ((CheckBox)paramView.findViewById(2131296518));
          if (!TextUtils.isEmpty(localPromotions.url)) {
            WalletOrderInfoOldUI.this.DyZ.put(localPromotions.url, paramViewGroup.Dzz);
          }
          paramView.setTag(paramViewGroup);
          break label293;
          paramViewGroup = (a)paramView.getTag();
          int i = 0;
          paramInt = i;
          if (localPromotions.type == paramViewGroup.type) {
            if (localPromotions.type == Orders.Dqp)
            {
              paramInt = i;
              if (localPromotions.DqM != paramViewGroup.DqM) {}
            }
            else
            {
              paramInt = 1;
            }
          }
          if (paramInt != 0) {
            break label1586;
          }
          paramViewGroup = new a();
          paramViewGroup.type = localPromotions.type;
          if (localPromotions.type == Orders.Dqp)
          {
            if (localPromotions.DqM == 1)
            {
              paramView = View.inflate(WalletOrderInfoOldUI.this, 2131495998, null);
              paramViewGroup.oTd = ((CdnImageView)paramView.findViewById(2131306787));
              paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131306802));
              paramViewGroup.Dzz = ((TextView)paramView.findViewById(2131306774));
              paramViewGroup.fSj = ((TextView)paramView.findViewById(2131306789));
              if (!TextUtils.isEmpty(localPromotions.url)) {
                WalletOrderInfoOldUI.this.DyZ.put(localPromotions.url, paramViewGroup.Dzz);
              }
              paramView.setTag(paramViewGroup);
            }
            for (;;)
            {
              paramViewGroup.DqM = localPromotions.DqM;
              break;
              paramView = View.inflate(WalletOrderInfoOldUI.this, 2131495999, null);
              paramViewGroup.oTd = ((CdnImageView)paramView.findViewById(2131306787));
              paramViewGroup.Dzz = ((TextView)paramView.findViewById(2131306774));
              paramViewGroup.fSj = ((TextView)paramView.findViewById(2131306789));
              paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131306802));
              if (!TextUtils.isEmpty(localPromotions.url)) {
                WalletOrderInfoOldUI.this.DyZ.put(localPromotions.url, paramViewGroup.Dzz);
              }
              paramView.setTag(paramViewGroup);
            }
          }
          paramView = View.inflate(WalletOrderInfoOldUI.this, 2131496000, null);
          paramViewGroup.oTd = ((CdnImageView)paramView.findViewById(2131306787));
          paramViewGroup.Dzz = ((TextView)paramView.findViewById(2131306774));
          paramViewGroup.fSj = ((TextView)paramView.findViewById(2131306789));
          paramViewGroup.DzA = ((CheckBox)paramView.findViewById(2131296518));
          if (!TextUtils.isEmpty(localPromotions.url)) {
            WalletOrderInfoOldUI.this.DyZ.put(localPromotions.url, paramViewGroup.Dzz);
          }
          paramView.setTag(paramViewGroup);
          break label293;
          paramViewGroup.oTd.setUrl(localPromotions.xcF);
          paramViewGroup.fSj.setText(localPromotions.name);
          paramViewGroup.Dzz.setText(localPromotions.Dpr);
          break label387;
          label1345:
          paramViewGroup.DzA.setChecked(false);
          break label450;
          label1356:
          paramViewGroup.Dzz.setVisibility(0);
          if (paramViewGroup.DzA == null) {
            break label450;
          }
          paramViewGroup.DzA.setVisibility(8);
          break label450;
          label1383:
          if ((paramViewGroup.titleTv != null) && (!bu.isNullOrNil(localPromotions.title)))
          {
            paramViewGroup.titleTv.setText(localPromotions.title);
            break label485;
          }
          if (paramViewGroup.titleTv == null) {
            break label485;
          }
          paramViewGroup.titleTv.setVisibility(8);
          break label485;
          if ((((String)localObject).equals("-1")) || (((String)localObject).equals("3")))
          {
            paramViewGroup.Dzz.setBackgroundDrawable(WalletOrderInfoOldUI.this.getResources().getDrawable(2131231379));
            paramViewGroup.Dzz.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(2131101171));
          }
          else if ((((String)localObject).equals("4")) || (((String)localObject).equals("2")) || (((String)localObject).equals("1")))
          {
            paramViewGroup.Dzz.setBackgroundColor(WalletOrderInfoOldUI.this.getResources().getColor(2131101053));
            paramViewGroup.Dzz.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(2131100490));
          }
          else
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WalletOrderInfoOldUI", "PromotionsAdapter unknow award state");
          }
        }
      }
    }
    
    final class a
    {
      int DqM;
      CheckBox DzA;
      TextView Dzz;
      TextView fSj;
      CdnImageView oTd;
      TextView titleTv;
      int type;
      
      a() {}
    }
  }
  
  final class d
  {
    public String DgU;
    public long Drb;
    public String DyP;
    public String DyQ;
    public String DyR;
    public String dwj;
    public String yoZ;
    
    public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong)
    {
      this.DgU = paramString1;
      this.DyP = paramString2;
      this.DyQ = paramString3;
      this.DyR = paramString4;
      this.dwj = paramString5;
      this.yoZ = paramString6;
      this.Drb = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI
 * JD-Core Version:    0.7.0.1
 */