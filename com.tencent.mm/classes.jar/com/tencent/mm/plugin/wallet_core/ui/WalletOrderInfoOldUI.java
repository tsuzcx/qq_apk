package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.abe;
import com.tencent.mm.f.a.bb;
import com.tencent.mm.f.a.lv;
import com.tencent.mm.f.a.lv.a;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.c.af;
import com.tencent.mm.plugin.wallet_core.c.ag;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.a;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.utils.j;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.g;
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
  protected String GCu;
  private IListener GFB;
  protected String GIN;
  private String Itj;
  protected boolean OVT;
  private HashMap<String, b> OVY;
  protected String OVZ;
  protected Set<String> OZt;
  protected List<Orders.Commodity> OZu;
  protected Orders OxA;
  protected String PaA;
  protected HashMap<String, TextView> PaB;
  protected c PaC;
  protected Map<Long, String> PaD;
  private d PaE;
  private boolean PaF;
  protected az.b.a PaG;
  private View.OnLongClickListener PaH;
  private IListener Pac;
  protected LinearLayout Paw;
  protected TextView Pax;
  protected TextView Pay;
  protected a Paz;
  protected boolean fwS;
  protected boolean fwT;
  protected boolean fwU;
  protected String mAppId;
  protected PayInfo mPayInfo;
  protected String pRV;
  
  public WalletOrderInfoOldUI()
  {
    AppMethodBeat.i(71067);
    this.Paw = null;
    this.Pax = null;
    this.Pay = null;
    this.OZu = null;
    this.Paz = null;
    this.pRV = null;
    this.GIN = null;
    this.OVT = false;
    this.OZt = null;
    this.mAppId = "";
    this.PaA = null;
    this.fwS = true;
    this.fwT = false;
    this.fwU = false;
    this.PaB = new HashMap();
    this.PaD = new HashMap();
    this.OVY = new HashMap();
    this.PaF = false;
    this.GFB = new IListener() {};
    this.PaG = new WalletOrderInfoOldUI.6(this);
    this.PaH = new WalletOrderInfoOldUI.11(this);
    this.Pac = new WalletOrderInfoOldUI.3(this);
    AppMethodBeat.o(71067);
  }
  
  private void ata()
  {
    int j = 1;
    AppMethodBeat.i(71068);
    com.tencent.mm.wallet_core.d locald = com.tencent.mm.wallet_core.a.bF(this);
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.GCu = getInput().getString("key_trans_id");
    getInput().getInt("key_pay_type", -1);
    Log.i("MicroMsg.WalletOrderInfoOldUI", "mTransId %s", new Object[] { this.GCu });
    this.OxA = gLy();
    if (this.OxA != null)
    {
      setContentViewVisibility(0);
      d(this.OxA);
      int i;
      boolean bool1;
      if ((locald != null) && (this.OxA != null) && (this.mPayInfo != null))
      {
        this.mAppId = this.mPayInfo.appId;
        boolean bool2 = locald.iim();
        j.a(this, getInput(), 7);
        if (getInput().getInt("key_support_bankcard", 1) == 2)
        {
          i = 2;
          com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
          int k = this.mPayInfo.fOY;
          if (this.mPayInfo.fOY != 3) {
            break label454;
          }
          bool1 = true;
          label189:
          if (!bool2) {
            break label460;
          }
          label194:
          localh.a(10691, new Object[] { Integer.valueOf(k), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(ab.iiW()), Integer.valueOf((int)(this.OxA.fwy * 100.0D)), this.OxA.GHz, Integer.valueOf(i) });
        }
      }
      else
      {
        if (((!u.gJo().gJQ()) && (locald != null) && (locald.iim())) || (!z.bdl())) {
          z.bdm();
        }
        if ((this.OxA == null) || (this.OxA.ORd == null) || (this.OxA.ORd.size() <= 0)) {
          break label465;
        }
        this.OZu = this.OxA.ORd;
        this.GCu = ((Orders.Commodity)this.OZu.get(0)).fww;
        if ((this.mPayInfo != null) && (locald != null) && ((locald.iil()) || (locald.iim()))) {
          doSceneProgress(new ae(getPayReqKey(), 21));
        }
      }
      for (;;)
      {
        if (this.GCu != null) {
          break label532;
        }
        if (((com.tencent.mm.plugin.fingerprint.b.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.b.h.class)).j(this)) {
          this.PaF = false;
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
        Log.printInfoStack("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
        com.tencent.mm.ui.base.h.a(getContext(), a.i.wallet_order_info_err, 0, new DialogInterface.OnClickListener()
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
    Log.printInfoStack("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
    com.tencent.mm.ui.base.h.a(getContext(), a.i.wallet_order_info_err, 0, new DialogInterface.OnClickListener()
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
    this.OZt.clear();
    if ((paramOrders == null) || (paramOrders.ORd == null))
    {
      Log.w("MicroMsg.WalletOrderInfoOldUI", "hy: orders is null");
      AppMethodBeat.o(71075);
      return;
    }
    paramOrders = paramOrders.ORd.iterator();
    while (paramOrders.hasNext())
    {
      Orders.Commodity localCommodity = (Orders.Commodity)paramOrders.next();
      if ((localCommodity.OQT == 2) && (!Util.isNullOrNil(localCommodity.ORF)))
      {
        Log.d("MicroMsg.WalletOrderInfoOldUI", "hy: has username and is force recommend");
        this.OZt.add(localCommodity.ORF);
      }
    }
    AppMethodBeat.o(71075);
  }
  
  private void gLF()
  {
    AppMethodBeat.i(71077);
    if (this.OxA != null)
    {
      this.OZu = this.OxA.ORd;
      Iterator localIterator = this.OZu.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!"1".equals(((Orders.Commodity)localIterator.next()).GHs));
    }
    for (int i = 0;; i = 1)
    {
      this.Paw.setVisibility(0);
      this.Pax.setVisibility(0);
      if (i != 0)
      {
        if ((!Util.isNullOrNil(this.OxA.OQV)) && (!Util.isNullOrNil(this.OxA.OQV.trim())))
        {
          this.Pax.setText(this.OxA.OQV);
          AppMethodBeat.o(71077);
          return;
        }
        if (this.OxA.OIp != 1)
        {
          this.Pax.setText(a.i.wallet_order_info_result_success_international);
          AppMethodBeat.o(71077);
          return;
        }
        this.Pax.setText(a.i.wallet_order_info_result_success);
        AppMethodBeat.o(71077);
        return;
      }
      this.Pax.setText(a.i.wallet_order_info_result_wait);
      AppMethodBeat.o(71077);
      return;
    }
  }
  
  private void gLG()
  {
    AppMethodBeat.i(71089);
    if ((this.OxA != null) && (this.OxA.ORd != null) && (this.OxA.ORd.size() > 0) && (((Orders.Commodity)this.OxA.ORd.get(0)).ORQ != null) && (!Util.isNullOrNil(((Orders.Commodity)this.OxA.ORd.get(0)).ORQ.text)) && (!Util.isNullOrNil(((Orders.Commodity)this.OxA.ORd.get(0)).ORQ.url)))
    {
      this.Pay.setVisibility(0);
      this.Pay.setText(((Orders.Commodity)this.OxA.ORd.get(0)).ORQ.text);
      this.Pay.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71052);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          g.p(WalletOrderInfoOldUI.this, ((Orders.Commodity)WalletOrderInfoOldUI.this.OxA.ORd.get(0)).ORQ.url, false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71052);
        }
      });
      AppMethodBeat.o(71089);
      return;
    }
    Log.i("MicroMsg.WalletOrderInfoOldUI", "hy: no commodity or no link act or link act is illegal!");
    this.Pay.setVisibility(8);
    AppMethodBeat.o(71089);
  }
  
  private void gLk()
  {
    int i = 0;
    AppMethodBeat.i(71080);
    if (!this.OVT)
    {
      lv locallv = new lv();
      locallv.fJI.requestCode = 4;
      lv.a locala = locallv.fJI;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.resultCode = i;
      EventCenter.instance.publish(locallv);
      this.OVT = true;
    }
    AppMethodBeat.o(71080);
  }
  
  public final String Tr(long paramLong)
  {
    AppMethodBeat.i(71091);
    if (this.PaD.containsKey(Long.valueOf(paramLong)))
    {
      String str = (String)this.PaD.get(Long.valueOf(paramLong));
      AppMethodBeat.o(71091);
      return str;
    }
    AppMethodBeat.o(71091);
    return "-1";
  }
  
  protected final void a(Orders.Promotions paramPromotions)
  {
    AppMethodBeat.i(71074);
    doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.t(paramPromotions, getPayReqKey(), this.GCu, paramPromotions.OQE));
    AppMethodBeat.o(71074);
  }
  
  protected final void a(String paramString, d paramd)
  {
    AppMethodBeat.i(71078);
    gLk();
    this.PaE = paramd;
    g.a(this, paramString, false, 1);
    this.PaF = false;
    AppMethodBeat.o(71078);
  }
  
  protected final void ao(as paramas)
  {
    AppMethodBeat.i(71081);
    if ((paramas != null) && ((int)paramas.jxt != 0))
    {
      String str = paramas.ayr();
      Log.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer nickName " + str + " username: " + paramas.field_username);
      if ((this.OZu != null) && (this.OZu.size() > 0))
      {
        Iterator localIterator = this.OZu.iterator();
        while (localIterator.hasNext()) {
          ((Orders.Commodity)localIterator.next()).fvb = str;
        }
        this.Paz.notifyDataSetChanged();
      }
      this.pRV = paramas.field_username;
    }
    AppMethodBeat.o(71081);
  }
  
  protected final void apy(String paramString)
  {
    AppMethodBeat.i(71079);
    gLk();
    g.p(this, paramString, false);
    this.PaF = false;
    AppMethodBeat.o(71079);
  }
  
  protected final void bhz(String paramString)
  {
    AppMethodBeat.i(71072);
    doSceneProgress(new af(paramString));
    AppMethodBeat.o(71072);
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
            WalletOrderInfoOldUI.this.gLE();
            AppMethodBeat.o(71050);
          }
        });
        getInput().remove("key_realname_guide_helper");
        if (!bool) {
          gLE();
        }
      }
      AppMethodBeat.o(71083);
      return;
    }
    gLE();
    AppMethodBeat.o(71083);
  }
  
  protected final boolean fBc()
  {
    return false;
  }
  
  protected final void gJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(71073);
    doSceneProgress(new af(paramString, paramInt));
    AppMethodBeat.o(71073);
  }
  
  public final void gLE()
  {
    AppMethodBeat.i(71084);
    gLk();
    this.PaF = false;
    Object localObject1 = new bb();
    ((bb)localObject1).fwN.fwO = true;
    EventCenter.instance.publish((IEvent)localObject1);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("intent_pay_end_errcode", getInput().getInt("intent_pay_end_errcode"));
    ((Bundle)localObject2).putString("intent_pay_app_url", getInput().getString("intent_pay_app_url"));
    ((Bundle)localObject2).putBoolean("intent_pay_end", getInput().getBoolean("intent_pay_end"));
    Log.i("MicroMsg.WalletOrderInfoOldUI", "pay done...feedbackData errCode:" + getInput().getInt("intent_pay_end_errcode"));
    Iterator localIterator = this.OZt.iterator();
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (!Util.isNullOrNil(str1))
      {
        Log.i("MicroMsg.WalletOrderInfoOldUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str1 });
        if ((this.OxA == null) || (this.mPayInfo == null)) {
          break label339;
        }
        com.tencent.mm.an.t localt = com.tencent.mm.kernel.h.aHF().kcd;
        String str2 = this.OxA.fwv;
        if (this.OxA.ORd.size() <= 0) {
          break label333;
        }
        localObject1 = ((Orders.Commodity)this.OxA.ORd.get(0)).fww;
        label250:
        localt.a(new com.tencent.mm.wallet_core.c.t(str1, str2, (String)localObject1, this.mPayInfo.fOY, this.mPayInfo.channel, this.OxA.OQT), 0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(13033, new Object[] { Integer.valueOf(2), str1, "", "", "" });
        break;
        label333:
        localObject1 = "";
        break label250;
        label339:
        com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.wallet_core.c.t(str1), 0);
      }
    }
    com.tencent.mm.wallet_core.a.l(this, (Bundle)localObject2);
    if ((this.OxA != null) && (!Util.isNullOrNil(this.OxA.vhY))) {
      if (this.OxA.ORd.size() <= 0) {
        break label535;
      }
    }
    label535:
    for (localObject1 = ((Orders.Commodity)this.OxA.ORd.get(0)).fww;; localObject1 = "")
    {
      localObject1 = i(this.OxA.vhY, this.OxA.fwv, (String)localObject1, this.mPayInfo.tol, this.mPayInfo.remark);
      Log.d("MicroMsg.WalletOrderInfoOldUI", "url = ".concat(String.valueOf(localObject1)));
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
      ((Intent)localObject2).putExtra("showShare", false);
      ((Intent)localObject2).putExtra("geta8key_username", z.bcZ());
      ((Intent)localObject2).putExtra("stastic_scene", 8);
      com.tencent.mm.by.c.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject2);
      AppMethodBeat.o(71084);
      return;
    }
  }
  
  protected Orders gLy()
  {
    AppMethodBeat.i(71070);
    Orders localOrders = (Orders)getInput().getParcelable("key_orders");
    AppMethodBeat.o(71070);
    return localOrders;
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_order_info;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71076);
    setMMTitle(a.i.wallet_order_info_ui_title);
    showHomeBtn(false);
    enableBackMenu(false);
    String str = getString(a.i.app_finish);
    Object localObject;
    if ((this.mPayInfo != null) && (this.mPayInfo.fOY == 2)) {
      if (!Util.isNullOrNil(this.mPayInfo.Pjv)) {
        localObject = getString(a.i.app_back) + this.mPayInfo.Pjv;
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
      this.Paw = ((LinearLayout)findViewById(a.f.wallet_order_info_result_ll));
      this.Pax = ((TextView)findViewById(a.f.wallet_order_info_result));
      this.Pay = ((TextView)findViewById(a.f.wallet_order_info_link_act));
      localObject = (MaxListView)findViewById(a.f.wallet_order_info);
      this.Paz = new a();
      ((MaxListView)localObject).setAdapter(this.Paz);
      gLF();
      gLG();
      ((ScrollView)findViewById(a.f.wallet_sv)).pageScroll(33);
      AppMethodBeat.o(71076);
      return;
      localObject = str;
      if (!Util.isNullOrNil(this.mPayInfo.appId))
      {
        localObject = str;
        if (!Util.isNullOrNil(com.tencent.mm.pluginsdk.model.app.h.t(this, this.mPayInfo.appId)))
        {
          localObject = getString(a.i.app_back) + com.tencent.mm.pluginsdk.model.app.h.t(this, this.mPayInfo.appId);
          continue;
          localObject = str;
          if (this.OxA != null)
          {
            localObject = str;
            if (!Util.isNullOrNil(this.OxA.ORo)) {
              localObject = this.OxA.ORo;
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
    Log.i("MicroMsg.WalletOrderInfoOldUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1) {
      doSceneProgress(new ag(this.PaE.OIw, this.PaE.Par, this.PaE.Pas, this.PaE.Pat, this.PaE.fHb, this.PaE.Ine, this.PaE.OSy));
    }
    AppMethodBeat.o(71088);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71069);
    super.onCreate(paramBundle);
    setContentViewVisibility(4);
    this.OZt = new HashSet();
    ata();
    initView();
    addSceneEndListener(1979);
    EventCenter.instance.addListener(this.Pac);
    EventCenter.instance.addListener(this.GFB);
    this.PaF = false;
    AppMethodBeat.o(71069);
  }
  
  @Deprecated
  public Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(71086);
    Dialog localDialog = com.tencent.mm.ui.base.h.a(getContext(), getString(a.i.wallet_order_info_phone), getResources().getStringArray(a.b.wallet_phone_call), "", new WalletOrderInfoOldUI.9(this));
    AppMethodBeat.o(71086);
    return localDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71082);
    super.onDestroy();
    EventCenter.instance.removeListener(this.Pac);
    EventCenter.instance.removeListener(this.GFB);
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
    Log.i("MicroMsg.WalletOrderInfoOldUI", "onResume, isClickActivityTinyApp: %s", new Object[] { Boolean.valueOf(this.PaF) });
    if (this.PaF) {
      doSceneProgress(new ag(this.PaE.OIw, this.PaE.Par, this.PaE.Pas, this.PaE.Pat, this.PaE.fHb, this.PaE.Ine, this.PaE.OSy));
    }
    AppMethodBeat.o(71087);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(71090);
    int i;
    if (((paramq instanceof ag)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      ag localag = (ag)paramq;
      b localb = new b(localag.osF);
      if ((!Util.isNullOrNil(localb.url)) && (!Util.isNullOrNil(localb.wording)))
      {
        i = 1;
        if (i != 0) {
          this.OVY.put(localag.OIw, localb);
        }
        this.Paz.notifyDataSetChanged();
      }
    }
    else
    {
      if (!(paramq instanceof af)) {
        break label355;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        setContentViewVisibility(0);
        this.OxA = ((af)paramq).OIB;
        if (this.OxA != null) {
          this.OZu = this.OxA.ORd;
        }
        d(this.OxA);
        Log.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + this.OZu);
        if ((this.OZu != null) && (this.OZu.size() != 0))
        {
          paramString = (Orders.Commodity)this.OZu.get(0);
          this.GCu = paramString.fww;
          Log.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + paramString.toString());
          paramq = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramString.fvb);
          if ((paramq == null) || ((int)paramq.jxt == 0)) {
            break label334;
          }
          ao(paramq);
        }
      }
    }
    for (;;)
    {
      this.Paz.notifyDataSetChanged();
      gLF();
      if (this.Paz != null) {
        this.Paz.notifyDataSetChanged();
      }
      gLG();
      AppMethodBeat.o(71090);
      return true;
      i = 0;
      break;
      label334:
      az.a.ltq.a(paramString.fvb, "", this.PaG);
    }
    label355:
    if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.t))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.wallet_core.c.t)paramq;
        paramq = paramString.OIe;
        long l = paramString.OIh.cpu;
        this.PaD.put(Long.valueOf(l), paramq);
        paramString.OIh.OQF = paramString.resultMsg;
        if ((!"-1".equals(paramq)) && (!"0".equals(paramq)) && (!Util.isNullOrNil(paramString.OIf))) {
          com.tencent.mm.ui.base.h.c(this, paramString.OIf, "", true);
        }
        while (!"0".equals(paramq))
        {
          this.Paz.notifyDataSetChanged();
          AppMethodBeat.o(71090);
          return true;
        }
        if (!Util.isNullOrNil(paramString.OIf)) {}
        for (paramString = paramString.OIf;; paramString = getString(a.i.wallet_pay_award_got))
        {
          Toast.makeText(this, paramString, 0).show();
          break;
        }
      }
      if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.t))
      {
        paramq = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramq = getString(a.i.wallet_unknown_err);
        }
        com.tencent.mm.ui.base.h.a(this, paramq, null, false, new DialogInterface.OnClickListener()
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
    
    private Orders.Commodity amH(int paramInt)
    {
      AppMethodBeat.i(71057);
      Orders.Commodity localCommodity = (Orders.Commodity)WalletOrderInfoOldUI.this.OZu.get(paramInt);
      AppMethodBeat.o(71057);
      return localCommodity;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(71056);
      if (WalletOrderInfoOldUI.this.OZu != null)
      {
        int i = WalletOrderInfoOldUI.this.OZu.size();
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
      label419:
      Object localObject1;
      Object localObject2;
      label457:
      Orders.DiscountInfo localDiscountInfo;
      TextView localTextView;
      if (paramView == null)
      {
        paramView = View.inflate(WalletOrderInfoOldUI.this, a.g.wallet_order_info_item, null);
        paramViewGroup = new a();
        paramViewGroup.PaL = ((TextView)paramView.findViewById(a.f.wallet_order_info_bankcard_title));
        paramViewGroup.mrM = ((TextView)paramView.findViewById(a.f.wallet_order_info_desc));
        paramViewGroup.PaO = ((TextView)paramView.findViewById(a.f.wallet_order_info_spid));
        paramViewGroup.PaM = ((TextView)paramView.findViewById(a.f.wallet_order_info_total_fee));
        paramViewGroup.PaN = ((TextView)paramView.findViewById(a.f.wallet_order_info_org_total_fee));
        paramViewGroup.PaN.getPaint().setFlags(16);
        paramViewGroup.PaP = ((TextView)paramView.findViewById(a.f.wallet_order_info_trans_id));
        paramViewGroup.PaQ = ((TextView)paramView.findViewById(a.f.wallet_order_info_cre_time));
        paramViewGroup.PaR = ((TextView)paramView.findViewById(a.f.wallet_order_info_bankcard));
        paramViewGroup.PaT = ((MaxListView)paramView.findViewById(a.f.wallet_order_info_promotions));
        paramViewGroup.PaU = paramView.findViewById(a.f.wallet_order_info_discount_ll);
        paramViewGroup.PaS = paramView.findViewById(a.f.wallet_order_info_septator_3);
        paramViewGroup.PaW = ((TextView)paramView.findViewById(a.f.wallet_order_original_feeinfo_desc));
        paramViewGroup.PaV = ((TextView)paramView.findViewById(a.f.wallet_order_original_feeinfo_title));
        paramViewGroup.PaX = ((TextView)paramView.findViewById(a.f.wallet_order_rate_info_desc));
        paramViewGroup.PaY = ((TextView)paramView.findViewById(a.f.wallet_order_rate_info_title));
        paramViewGroup.Pba = ((ViewGroup)paramView.findViewById(a.f.wallet_order_info_tiny_app_info));
        paramViewGroup.OWf = ((CdnImageView)paramView.findViewById(a.f.tinyapp_logo_iv));
        paramViewGroup.OWg = ((TextView)paramView.findViewById(a.f.tinyapp_desc));
        paramViewGroup.OWh = ((TextView)paramView.findViewById(a.f.tinyapp_name));
        paramViewGroup.PaZ = paramView.findViewById(a.f.wallet_order_info_septator_4);
        paramView.setTag(paramViewGroup);
        localCommodity = amH(paramInt);
        if ((localCommodity == null) || (paramViewGroup == null)) {
          break label1210;
        }
        WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this, localCommodity.fww);
        paramViewGroup.PaM.setText(g.d(localCommodity.tVK, localCommodity.GHz));
        if ((localCommodity.ORE < 0.0D) || (localCommodity.tVK >= localCommodity.ORE)) {
          break label654;
        }
        paramViewGroup.PaN.setText(g.d(localCommodity.ORE, localCommodity.GHz));
        paramViewGroup.PaN.setVisibility(0);
        localObject1 = (LinearLayout)paramViewGroup.PaU;
        localObject2 = localCommodity.ORH;
        ((LinearLayout)localObject1).removeAllViews();
        if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
          break label679;
        }
        paramInt = 0;
        if (paramInt >= ((List)localObject2).size()) {
          break label679;
        }
        localDiscountInfo = (Orders.DiscountInfo)((List)localObject2).get(paramInt);
        localTextView = new TextView(WalletOrderInfoOldUI.this.getContext());
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = WalletOrderInfoOldUI.this.getContext().getResources().getDimensionPixelOffset(a.d.BasicPaddingSize);
        localTextView.setLayoutParams(localLayoutParams);
        localTextView.setTextAppearance(WalletOrderInfoOldUI.this.getContext(), a.j.MMWalletOrdersInfo);
        if (localDiscountInfo.ORZ <= 0.0D) {
          break label666;
        }
        localTextView.setText(localDiscountInfo.Ila + g.d(localDiscountInfo.ORZ / 100.0D, WalletOrderInfoOldUI.this.OxA.GHz));
      }
      for (;;)
      {
        ((LinearLayout)localObject1).addView(localTextView);
        localTextView.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(a.c.wallet_favor_list_text_color));
        paramInt += 1;
        break label457;
        paramViewGroup = (a)paramView.getTag();
        break;
        label654:
        paramViewGroup.PaN.setVisibility(8);
        break label419;
        label666:
        localTextView.setText(localDiscountInfo.Ila);
      }
      label679:
      if (((LinearLayout)localObject1).getChildCount() > 0)
      {
        ((LinearLayout)localObject1).setVisibility(0);
        localObject2 = paramViewGroup.PaL;
        localObject1 = WalletOrderInfoOldUI.this;
        if (!z.bdq()) {
          break label1227;
        }
        localObject1 = ((Context)localObject1).getString(a.i.wallet_order_info_pay_method_payu);
        label721:
        ((TextView)localObject2).setText((CharSequence)localObject1);
        paramViewGroup.PaO.setText(localCommodity.GHo);
        paramViewGroup.mrM.setText(localCommodity.desc);
        paramViewGroup.mrM.setTag(localCommodity.desc);
        paramViewGroup.mrM.setOnLongClickListener(WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this));
        paramViewGroup.mrM.setBackgroundResource(a.e.wallet_order_info_trans_id_text_bg);
        paramViewGroup.PaP.setText(localCommodity.fww);
        paramViewGroup.PaP.setTag(localCommodity.fww);
        paramViewGroup.PaP.setOnLongClickListener(WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this));
        paramViewGroup.PaP.setBackgroundResource(a.e.wallet_order_info_trans_id_text_bg);
        paramViewGroup.PaQ.setText(g.uW(localCommodity.GHv));
        paramViewGroup.PaR.setText(localCommodity.GHx);
        localObject1 = localCommodity.ORI;
        if (paramViewGroup.PaX != null)
        {
          if (Util.isNullOrNil((String)localObject1)) {
            break label1240;
          }
          paramViewGroup.PaX.setText((CharSequence)localObject1);
          paramViewGroup.PaX.setVisibility(0);
          paramViewGroup.PaY.setVisibility(0);
        }
        localObject1 = localCommodity.ORK;
        if (paramViewGroup.PaW != null)
        {
          if (Util.isNullOrNil((String)localObject1)) {
            break label1261;
          }
          paramViewGroup.PaW.setText((CharSequence)localObject1);
          paramViewGroup.PaW.setVisibility(0);
          paramViewGroup.PaV.setVisibility(0);
        }
        label957:
        if (localCommodity.ORO.size() <= 0) {
          break label1282;
        }
        localObject1 = (Orders.Promotions)localCommodity.ORO.get(0);
        com.tencent.mm.plugin.report.service.h.IzE.a(13033, new Object[] { Integer.valueOf(1), ((Orders.Promotions)localObject1).fvb, ((Orders.Promotions)localObject1).url, ((Orders.Promotions)localObject1).name, WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this) });
        WalletOrderInfoOldUI.this.PaC = new WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this, localCommodity.ORO);
        paramViewGroup.PaT.setAdapter(WalletOrderInfoOldUI.this.PaC);
        paramViewGroup.PaT.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(71054);
            b localb = new b();
            localb.bn(paramAnonymousAdapterView);
            localb.bn(paramAnonymousView);
            localb.sg(paramAnonymousInt);
            localb.Fs(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
            paramAnonymousAdapterView = WalletOrderInfoOldUI.this.PaC.amI(paramAnonymousInt);
            if (!Util.isNullOrNil(paramAnonymousAdapterView.fvb)) {
              if (WalletOrderInfoOldUI.this.OZt.contains(paramAnonymousAdapterView.fvb))
              {
                WalletOrderInfoOldUI.this.OZt.remove(paramAnonymousAdapterView.fvb);
                WalletOrderInfoOldUI.this.Paz.notifyDataSetChanged();
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(71054);
              return;
              WalletOrderInfoOldUI.this.OZt.add(paramAnonymousAdapterView.fvb);
              break;
              paramAnonymousView = WalletOrderInfoOldUI.this.Tr(paramAnonymousAdapterView.cpu);
              if (("-1".equals(paramAnonymousView)) || ("3".equals(paramAnonymousView)))
              {
                com.tencent.mm.plugin.report.service.h.IzE.a(13472, new Object[] { WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this), Integer.valueOf(paramAnonymousAdapterView.SuA), Integer.valueOf(1), Long.valueOf(paramAnonymousAdapterView.cpu), Long.valueOf(paramAnonymousAdapterView.OQE) });
                com.tencent.mm.plugin.report.service.h.IzE.a(13033, new Object[] { Integer.valueOf(2), "", paramAnonymousAdapterView.url, paramAnonymousAdapterView.name, "" });
                if ((!Util.isNullOrNil(paramAnonymousAdapterView.SuD)) && (!Util.isNullOrNil(paramAnonymousAdapterView.SuE)))
                {
                  Log.i("MicroMsg.WalletOrderInfoOldUI", "promotion jump tiny app, username: %s, path: %s", new Object[] { paramAnonymousAdapterView.SuD, paramAnonymousAdapterView.SuE });
                  paramAnonymousView = new xw();
                  paramAnonymousView.fWN.userName = paramAnonymousAdapterView.SuD;
                  paramAnonymousView.fWN.fWP = Util.nullAs(paramAnonymousAdapterView.SuE, "");
                  paramAnonymousView.fWN.scene = 1060;
                  paramAnonymousView.fWN.fvd = WalletOrderInfoOldUI.this.GCu;
                  paramAnonymousView.fWN.fWQ = 0;
                  EventCenter.instance.publish(paramAnonymousView);
                  com.tencent.mm.plugin.report.service.h.IzE.a(14118, new Object[] { WalletOrderInfoOldUI.this.GCu, WalletOrderInfoOldUI.this.getPayReqKey(), Integer.valueOf(2) });
                  WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this, new WalletOrderInfoOldUI.d(WalletOrderInfoOldUI.this, paramAnonymousAdapterView.cpu, paramAnonymousAdapterView.SuB, paramAnonymousAdapterView.OQC, paramAnonymousAdapterView.OQD, WalletOrderInfoOldUI.this.getPayReqKey(), WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this), paramAnonymousAdapterView.OQE));
                  WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this, true);
                }
                else if (paramAnonymousAdapterView.SuA == 1)
                {
                  WalletOrderInfoOldUI.this.a(paramAnonymousAdapterView);
                }
                else if ((paramAnonymousAdapterView.SuA == 2) && (!Util.isNullOrNil(paramAnonymousAdapterView.url)))
                {
                  if (WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this).containsKey(paramAnonymousAdapterView.cpu))
                  {
                    paramAnonymousAdapterView = (WalletOrderInfoOldUI.b)WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this).get(paramAnonymousAdapterView.cpu);
                    Log.i("MicroMsg.WalletOrderInfoOldUI", "go to new url %s", new Object[] { paramAnonymousAdapterView.url });
                    WalletOrderInfoOldUI.this.apy(paramAnonymousAdapterView.url);
                  }
                  else
                  {
                    WalletOrderInfoOldUI.this.OVZ = paramAnonymousAdapterView.url;
                    WalletOrderInfoOldUI.this.a(paramAnonymousAdapterView.url, new WalletOrderInfoOldUI.d(WalletOrderInfoOldUI.this, paramAnonymousAdapterView.cpu, paramAnonymousAdapterView.SuB, paramAnonymousAdapterView.OQC, paramAnonymousAdapterView.OQD, WalletOrderInfoOldUI.this.getPayReqKey(), WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this), paramAnonymousAdapterView.OQE));
                  }
                }
                else
                {
                  Log.e("MicroMsg.WalletOrderInfoOldUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
                }
              }
            }
          }
        });
        WalletOrderInfoOldUI.this.PaC.notifyDataSetChanged();
        paramViewGroup.PaT.setVisibility(0);
        paramViewGroup.PaS.setVisibility(0);
        label1118:
        if ((localCommodity.ORL == null) || (Util.isNullOrNil(localCommodity.ORL.Ooe))) {
          break label1312;
        }
        paramViewGroup.OWf.setUrl(localCommodity.ORL.OQH);
        paramViewGroup.OWg.setText(localCommodity.ORL.OQI);
        paramViewGroup.OWh.setText(localCommodity.ORL.ODu);
        paramViewGroup.Pba.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71055);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            paramAnonymousView = new xw();
            paramAnonymousView.fWN.userName = localCommodity.ORL.Ooe;
            paramAnonymousView.fWN.fWP = Util.nullAs(localCommodity.ORL.Oof, "");
            paramAnonymousView.fWN.scene = 1034;
            paramAnonymousView.fWN.fWQ = 0;
            EventCenter.instance.publish(paramAnonymousView);
            com.tencent.mm.plugin.report.service.h.IzE.a(14118, new Object[] { WalletOrderInfoOldUI.this.GCu, WalletOrderInfoOldUI.this.getPayReqKey(), Integer.valueOf(1) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71055);
          }
        });
        paramViewGroup.PaZ.setVisibility(0);
      }
      for (;;)
      {
        label910:
        label1210:
        AppMethodBeat.o(71058);
        return paramView;
        ((LinearLayout)localObject1).setVisibility(8);
        break;
        label1227:
        localObject1 = ((Context)localObject1).getString(a.i.wallet_order_info_pay_method);
        break label721;
        label1240:
        paramViewGroup.PaY.setVisibility(8);
        paramViewGroup.PaX.setVisibility(8);
        break label910;
        label1261:
        paramViewGroup.PaV.setVisibility(8);
        paramViewGroup.PaW.setVisibility(8);
        break label957;
        label1282:
        paramViewGroup.PaT.setVisibility(8);
        paramViewGroup.Pba.setVisibility(8);
        paramViewGroup.PaS.setVisibility(8);
        break label1118;
        label1312:
        paramViewGroup.Pba.setVisibility(8);
        paramViewGroup.PaZ.setVisibility(8);
      }
    }
    
    final class a
    {
      CdnImageView OWf;
      TextView OWg;
      TextView OWh;
      TextView PaL;
      TextView PaM;
      TextView PaN;
      TextView PaO;
      TextView PaP;
      TextView PaQ;
      TextView PaR;
      View PaS;
      MaxListView PaT;
      View PaU;
      TextView PaV;
      TextView PaW;
      TextView PaX;
      TextView PaY;
      View PaZ;
      ViewGroup Pba;
      TextView mrM;
      
      a() {}
    }
  }
  
  final class b
  {
    public String Pap;
    public String icon;
    public String title;
    public String url;
    public String wording;
    
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
        this.wording = WalletOrderInfoOldUI.this.optString("wording");
        this.icon = WalletOrderInfoOldUI.this.optString("icon");
        this.Pap = WalletOrderInfoOldUI.this.optString("btn_text");
        this.title = WalletOrderInfoOldUI.this.optString("title");
      }
      AppMethodBeat.o(71060);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(71061);
      String str = this.url + " , " + this.wording + " , " + this.icon + " , " + this.Pap + " , " + this.title;
      AppMethodBeat.o(71061);
      return str;
    }
  }
  
  final class c
    extends BaseAdapter
  {
    protected List<Orders.Promotions> ORO;
    
    public c()
    {
      AppMethodBeat.i(71062);
      this.ORO = null;
      this.ORO = new ArrayList();
      Object localObject;
      int j = localObject.size();
      int i = 0;
      while (i < j)
      {
        this$1 = (Orders.Promotions)localObject.get(i);
        if ((WalletOrderInfoOldUI.this != null) && ((!Util.isNullOrNil(WalletOrderInfoOldUI.this.fvb)) || (WalletOrderInfoOldUI.this.SuA == 2) || (WalletOrderInfoOldUI.this.SuA == 1))) {
          this.ORO.add(localObject.get(i));
        }
        i += 1;
      }
      AppMethodBeat.o(71062);
    }
    
    public final Orders.Promotions amI(int paramInt)
    {
      AppMethodBeat.i(71064);
      Orders.Promotions localPromotions = (Orders.Promotions)this.ORO.get(paramInt);
      AppMethodBeat.o(71064);
      return localPromotions;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(71063);
      if (this.ORO != null)
      {
        int i = this.ORO.size();
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
      Orders.Promotions localPromotions = amI(paramInt);
      Object localObject;
      if ((Util.isNullOrNil(localPromotions.fvb)) && (localPromotions.cpu > 0L))
      {
        localObject = WalletOrderInfoOldUI.this.Tr(localPromotions.cpu);
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
        String str = WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this);
        paramInt = localPromotions.SuA;
        paramViewGroup = (ViewGroup)localObject;
        if ("-1".equals(localObject)) {
          paramViewGroup = Integer.valueOf(5);
        }
        localh.a(13471, new Object[] { str, Integer.valueOf(1), Integer.valueOf(paramInt), paramViewGroup, Long.valueOf(localPromotions.cpu), Long.valueOf(localPromotions.OQE) });
      }
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramViewGroup.type = localPromotions.type;
        if (localPromotions.type == Orders.ORD) {
          if (localPromotions.wYj == 1)
          {
            paramView = View.inflate(WalletOrderInfoOldUI.this, a.g.wallet_order_info_promotions_activity_festival_item, null);
            paramViewGroup.tCM = ((CdnImageView)paramView.findViewById(a.f.wallet_order_info_logo));
            paramViewGroup.titleTv = ((TextView)paramView.findViewById(a.f.wallet_order_info_title));
            paramViewGroup.JKc = ((TextView)paramView.findViewById(a.f.wallet_order_info_btn));
            paramViewGroup.jbF = ((TextView)paramView.findViewById(a.f.wallet_order_info_name));
            if (!TextUtils.isEmpty(localPromotions.url)) {
              WalletOrderInfoOldUI.this.PaB.put(localPromotions.url, paramViewGroup.JKc);
            }
            paramView.setTag(paramViewGroup);
            paramViewGroup.wYj = localPromotions.wYj;
          }
        }
      }
      label298:
      label455:
      label1610:
      for (;;)
      {
        if (localPromotions != null)
        {
          localObject = (WalletOrderInfoOldUI.b)WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this).get(localPromotions.cpu);
          Log.i("MicroMsg.WalletOrderInfoOldUI", "try get result ".concat(String.valueOf(localObject)));
          if (localObject == null) {
            break label1330;
          }
          paramViewGroup.tCM.setUrl(((WalletOrderInfoOldUI.b)localObject).icon);
          paramViewGroup.jbF.setText(((WalletOrderInfoOldUI.b)localObject).wording);
          paramViewGroup.JKc.setText(((WalletOrderInfoOldUI.b)localObject).Pap);
          if (Util.isNullOrNil(localPromotions.fvb)) {
            break label1380;
          }
          paramViewGroup.JKc.setVisibility(8);
          if (paramViewGroup.Pbb != null)
          {
            paramViewGroup.Pbb.setVisibility(0);
            if (!WalletOrderInfoOldUI.this.OZt.contains(localPromotions.fvb)) {
              break label1369;
            }
            paramViewGroup.Pbb.setChecked(true);
          }
          if ((paramViewGroup.titleTv == null) || (localObject == null) || (Util.isNullOrNil(((WalletOrderInfoOldUI.b)localObject).title))) {
            break label1407;
          }
          paramViewGroup.titleTv.setText(((WalletOrderInfoOldUI.b)localObject).title);
          label490:
          if ((!Util.isNullOrNil(WalletOrderInfoOldUI.this.OVZ)) && (paramViewGroup.JKc != null))
          {
            paramViewGroup.JKc.setClickable(WalletOrderInfoOldUI.this.fwS);
            paramViewGroup.JKc.setEnabled(WalletOrderInfoOldUI.this.fwS);
            paramViewGroup.JKc.setOnClickListener(null);
            if (WalletOrderInfoOldUI.this.fwT) {
              paramViewGroup.JKc.setVisibility(8);
            }
          }
          long l = localPromotions.cpu;
          localObject = WalletOrderInfoOldUI.this.Tr(l);
          if (!((String)localObject).equals("0")) {
            break label1459;
          }
          paramViewGroup.JKc.setBackgroundColor(WalletOrderInfoOldUI.this.getResources().getColor(a.c.transparent));
          paramViewGroup.JKc.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(a.c.wechat_green));
        }
        for (;;)
        {
          if (paramViewGroup.JKc != null)
          {
            paramInt = BackwardSupportUtil.BitmapFactory.fromDPToPix(WalletOrderInfoOldUI.this.getContext(), 15.0F);
            i = BackwardSupportUtil.BitmapFactory.fromDPToPix(WalletOrderInfoOldUI.this.getContext(), 5.0F);
            paramViewGroup.JKc.setPadding(paramInt, i, paramInt, i);
          }
          AppMethodBeat.o(71065);
          return paramView;
          paramView = View.inflate(WalletOrderInfoOldUI.this, a.g.wallet_order_info_promotions_activity_item, null);
          paramViewGroup.tCM = ((CdnImageView)paramView.findViewById(a.f.wallet_order_info_logo));
          paramViewGroup.JKc = ((TextView)paramView.findViewById(a.f.wallet_order_info_btn));
          paramViewGroup.jbF = ((TextView)paramView.findViewById(a.f.wallet_order_info_name));
          paramViewGroup.titleTv = ((TextView)paramView.findViewById(a.f.wallet_order_info_title));
          if (!TextUtils.isEmpty(localPromotions.url)) {
            WalletOrderInfoOldUI.this.PaB.put(localPromotions.url, paramViewGroup.JKc);
          }
          paramView.setTag(paramViewGroup);
          break;
          paramView = View.inflate(WalletOrderInfoOldUI.this, a.g.wallet_order_info_promotions_item, null);
          paramViewGroup.tCM = ((CdnImageView)paramView.findViewById(a.f.wallet_order_info_logo));
          paramViewGroup.JKc = ((TextView)paramView.findViewById(a.f.wallet_order_info_btn));
          paramViewGroup.jbF = ((TextView)paramView.findViewById(a.f.wallet_order_info_name));
          paramViewGroup.Pbb = ((CheckBox)paramView.findViewById(a.f.agree_wx_cb));
          if (!TextUtils.isEmpty(localPromotions.url)) {
            WalletOrderInfoOldUI.this.PaB.put(localPromotions.url, paramViewGroup.JKc);
          }
          paramView.setTag(paramViewGroup);
          break label298;
          paramViewGroup = (a)paramView.getTag();
          int i = 0;
          paramInt = i;
          if (localPromotions.type == paramViewGroup.type) {
            if (localPromotions.type == Orders.ORD)
            {
              paramInt = i;
              if (localPromotions.wYj != paramViewGroup.wYj) {}
            }
            else
            {
              paramInt = 1;
            }
          }
          if (paramInt != 0) {
            break label1610;
          }
          paramViewGroup = new a();
          paramViewGroup.type = localPromotions.type;
          if (localPromotions.type == Orders.ORD)
          {
            if (localPromotions.wYj == 1)
            {
              paramView = View.inflate(WalletOrderInfoOldUI.this, a.g.wallet_order_info_promotions_activity_festival_item, null);
              paramViewGroup.tCM = ((CdnImageView)paramView.findViewById(a.f.wallet_order_info_logo));
              paramViewGroup.titleTv = ((TextView)paramView.findViewById(a.f.wallet_order_info_title));
              paramViewGroup.JKc = ((TextView)paramView.findViewById(a.f.wallet_order_info_btn));
              paramViewGroup.jbF = ((TextView)paramView.findViewById(a.f.wallet_order_info_name));
              if (!TextUtils.isEmpty(localPromotions.url)) {
                WalletOrderInfoOldUI.this.PaB.put(localPromotions.url, paramViewGroup.JKc);
              }
              paramView.setTag(paramViewGroup);
            }
            for (;;)
            {
              paramViewGroup.wYj = localPromotions.wYj;
              break;
              paramView = View.inflate(WalletOrderInfoOldUI.this, a.g.wallet_order_info_promotions_activity_item, null);
              paramViewGroup.tCM = ((CdnImageView)paramView.findViewById(a.f.wallet_order_info_logo));
              paramViewGroup.JKc = ((TextView)paramView.findViewById(a.f.wallet_order_info_btn));
              paramViewGroup.jbF = ((TextView)paramView.findViewById(a.f.wallet_order_info_name));
              paramViewGroup.titleTv = ((TextView)paramView.findViewById(a.f.wallet_order_info_title));
              if (!TextUtils.isEmpty(localPromotions.url)) {
                WalletOrderInfoOldUI.this.PaB.put(localPromotions.url, paramViewGroup.JKc);
              }
              paramView.setTag(paramViewGroup);
            }
          }
          paramView = View.inflate(WalletOrderInfoOldUI.this, a.g.wallet_order_info_promotions_item, null);
          paramViewGroup.tCM = ((CdnImageView)paramView.findViewById(a.f.wallet_order_info_logo));
          paramViewGroup.JKc = ((TextView)paramView.findViewById(a.f.wallet_order_info_btn));
          paramViewGroup.jbF = ((TextView)paramView.findViewById(a.f.wallet_order_info_name));
          paramViewGroup.Pbb = ((CheckBox)paramView.findViewById(a.f.agree_wx_cb));
          if (!TextUtils.isEmpty(localPromotions.url)) {
            WalletOrderInfoOldUI.this.PaB.put(localPromotions.url, paramViewGroup.JKc);
          }
          paramView.setTag(paramViewGroup);
          break label298;
          paramViewGroup.tCM.setUrl(localPromotions.GUf);
          paramViewGroup.jbF.setText(localPromotions.name);
          paramViewGroup.JKc.setText(localPromotions.OQF);
          break label392;
          label1369:
          paramViewGroup.Pbb.setChecked(false);
          break label455;
          label1380:
          paramViewGroup.JKc.setVisibility(0);
          if (paramViewGroup.Pbb == null) {
            break label455;
          }
          paramViewGroup.Pbb.setVisibility(8);
          break label455;
          label1407:
          if ((paramViewGroup.titleTv != null) && (!Util.isNullOrNil(localPromotions.title)))
          {
            paramViewGroup.titleTv.setText(localPromotions.title);
            break label490;
          }
          if (paramViewGroup.titleTv == null) {
            break label490;
          }
          paramViewGroup.titleTv.setVisibility(8);
          break label490;
          if ((((String)localObject).equals("-1")) || (((String)localObject).equals("3")))
          {
            paramViewGroup.JKc.setBackgroundDrawable(WalletOrderInfoOldUI.this.getResources().getDrawable(a.e.btn_style_hollow_green));
            paramViewGroup.JKc.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(a.c.wechat_green));
          }
          else if ((((String)localObject).equals("4")) || (((String)localObject).equals("2")) || (((String)localObject).equals("1")))
          {
            paramViewGroup.JKc.setBackgroundColor(WalletOrderInfoOldUI.this.getResources().getColor(a.c.transparent));
            paramViewGroup.JKc.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(a.c.hint_text_color));
          }
          else
          {
            Log.e("MicroMsg.WalletOrderInfoOldUI", "PromotionsAdapter unknow award state");
          }
        }
      }
    }
    
    final class a
    {
      TextView JKc;
      CheckBox Pbb;
      TextView jbF;
      CdnImageView tCM;
      TextView titleTv;
      int type;
      int wYj;
      
      a() {}
    }
  }
  
  final class d
  {
    public String Ine;
    public String OIw;
    public long OSy;
    public String Par;
    public String Pas;
    public String Pat;
    public String fHb;
    
    public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong)
    {
      this.OIw = paramString1;
      this.Par = paramString2;
      this.Pas = paramString3;
      this.Pat = paramString4;
      this.fHb = paramString5;
      this.Ine = paramString6;
      this.OSy = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI
 * JD-Core Version:    0.7.0.1
 */