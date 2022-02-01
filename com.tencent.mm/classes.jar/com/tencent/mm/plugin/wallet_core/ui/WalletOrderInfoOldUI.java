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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ax;
import com.tencent.mm.g.a.kn;
import com.tencent.mm.g.a.kn.a;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.a.ym;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.c.af;
import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.a;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.e;
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
  protected Orders CIn;
  protected boolean DcO;
  private HashMap<String, b> DcT;
  protected String DcU;
  protected Set<String> Dgy;
  protected List<Orders.Commodity> Dgz;
  protected as.b.a DhA;
  private View.OnLongClickListener DhB;
  private c Dha;
  protected LinearLayout Dhq;
  protected TextView Dhr;
  protected TextView Dhs;
  protected a Dht;
  protected String Dhu;
  protected HashMap<String, TextView> Dhv;
  protected c Dhw;
  protected Map<Long, String> Dhx;
  private d Dhy;
  private boolean Dhz;
  protected boolean dlQ;
  protected boolean dlR;
  protected boolean dlS;
  protected String lEN;
  protected String mAppId;
  protected PayInfo mPayInfo;
  private c wAM;
  protected String wDV;
  protected String wxW;
  private String yeM;
  
  public WalletOrderInfoOldUI()
  {
    AppMethodBeat.i(71067);
    this.Dhq = null;
    this.Dhr = null;
    this.Dhs = null;
    this.Dgz = null;
    this.Dht = null;
    this.lEN = null;
    this.wDV = null;
    this.DcO = false;
    this.Dgy = null;
    this.mAppId = "";
    this.Dhu = null;
    this.dlQ = true;
    this.dlR = false;
    this.dlS = false;
    this.Dhv = new HashMap();
    this.Dhx = new HashMap();
    this.DcT = new HashMap();
    this.Dhz = false;
    this.wAM = new c() {};
    this.DhA = new WalletOrderInfoOldUI.6(this);
    this.DhB = new WalletOrderInfoOldUI.11(this);
    this.Dha = new WalletOrderInfoOldUI.3(this);
    AppMethodBeat.o(71067);
  }
  
  private void Zd()
  {
    int j = 1;
    AppMethodBeat.i(71068);
    com.tencent.mm.wallet_core.d locald = com.tencent.mm.wallet_core.a.br(this);
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.wxW = getInput().getString("key_trans_id");
    getInput().getInt("key_pay_type", -1);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoOldUI", "mTransId %s", new Object[] { this.wxW });
    this.CIn = eHF();
    if (this.CIn != null)
    {
      setContentViewVisibility(0);
      d(this.CIn);
      int i;
      boolean bool1;
      if ((locald != null) && (this.CIn != null) && (this.mPayInfo != null))
      {
        this.mAppId = this.mPayInfo.appId;
        boolean bool2 = locald.fQR();
        f.a(this, getInput(), 7);
        if (getInput().getInt("key_support_bankcard", 1) == 2)
        {
          i = 2;
          com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
          int k = this.mPayInfo.dCC;
          if (this.mPayInfo.dCC != 3) {
            break label454;
          }
          bool1 = true;
          label189:
          if (!bool2) {
            break label460;
          }
          label194:
          localg.f(10691, new Object[] { Integer.valueOf(k), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(ab.fRB()), Integer.valueOf((int)(this.CIn.dlx * 100.0D)), this.CIn.wCF, Integer.valueOf(i) });
        }
      }
      else
      {
        if (((!com.tencent.mm.plugin.wallet_core.model.t.eFy().eGa()) && (locald != null) && (locald.fQR())) || (!u.aAw())) {
          u.aAx();
        }
        if ((this.CIn == null) || (this.CIn.CYk == null) || (this.CIn.CYk.size() <= 0)) {
          break label465;
        }
        this.Dgz = this.CIn.CYk;
        this.wxW = ((Orders.Commodity)this.Dgz.get(0)).dlv;
        if ((this.mPayInfo != null) && (locald != null) && ((locald.fQQ()) || (locald.fQR()))) {
          doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(getPayReqKey(), 21));
        }
      }
      for (;;)
      {
        if (this.wxW != null) {
          break label532;
        }
        if (((com.tencent.mm.plugin.fingerprint.b.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.b.h.class)).i(this)) {
          this.Dhz = false;
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
        com.tencent.mm.sdk.platformtools.ad.m("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
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
    com.tencent.mm.sdk.platformtools.ad.m("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
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
    this.Dgy.clear();
    if ((paramOrders == null) || (paramOrders.CYk == null))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletOrderInfoOldUI", "hy: orders is null");
      AppMethodBeat.o(71075);
      return;
    }
    paramOrders = paramOrders.CYk.iterator();
    while (paramOrders.hasNext())
    {
      Orders.Commodity localCommodity = (Orders.Commodity)paramOrders.next();
      if ((localCommodity.CYa == 2) && (!bt.isNullOrNil(localCommodity.CYM)))
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletOrderInfoOldUI", "hy: has username and is force recommend");
        this.Dgy.add(localCommodity.CYM);
      }
    }
    AppMethodBeat.o(71075);
  }
  
  private void eHM()
  {
    AppMethodBeat.i(71077);
    if (this.CIn != null)
    {
      this.Dgz = this.CIn.CYk;
      Iterator localIterator = this.Dgz.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!"1".equals(((Orders.Commodity)localIterator.next()).wCy));
    }
    for (int i = 0;; i = 1)
    {
      this.Dhq.setVisibility(0);
      this.Dhr.setVisibility(0);
      if (i != 0)
      {
        if ((!bt.isNullOrNil(this.CIn.CYc)) && (!bt.isNullOrNil(this.CIn.CYc.trim())))
        {
          this.Dhr.setText(this.CIn.CYc);
          AppMethodBeat.o(71077);
          return;
        }
        if (this.CIn.CPj != 1)
        {
          this.Dhr.setText(2131765570);
          AppMethodBeat.o(71077);
          return;
        }
        this.Dhr.setText(2131765569);
        AppMethodBeat.o(71077);
        return;
      }
      this.Dhr.setText(2131765571);
      AppMethodBeat.o(71077);
      return;
    }
  }
  
  private void eHN()
  {
    AppMethodBeat.i(71089);
    if ((this.CIn != null) && (this.CIn.CYk != null) && (this.CIn.CYk.size() > 0) && (((Orders.Commodity)this.CIn.CYk.get(0)).CYW != null) && (!bt.isNullOrNil(((Orders.Commodity)this.CIn.CYk.get(0)).CYW.text)) && (!bt.isNullOrNil(((Orders.Commodity)this.CIn.CYk.get(0)).CYW.url)))
    {
      this.Dhs.setVisibility(0);
      this.Dhs.setText(((Orders.Commodity)this.CIn.CYk.get(0)).CYW.text);
      this.Dhs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71052);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          e.o(WalletOrderInfoOldUI.this, ((Orders.Commodity)WalletOrderInfoOldUI.this.CIn.CYk.get(0)).CYW.url, false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71052);
        }
      });
      AppMethodBeat.o(71089);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoOldUI", "hy: no commodity or no link act or link act is illegal!");
    this.Dhs.setVisibility(8);
    AppMethodBeat.o(71089);
  }
  
  private void eHr()
  {
    int i = 0;
    AppMethodBeat.i(71080);
    if (!this.DcO)
    {
      kn localkn = new kn();
      localkn.dxx.requestCode = 4;
      kn.a locala = localkn.dxx;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.bZU = i;
      com.tencent.mm.sdk.b.a.IbL.l(localkn);
      this.DcO = true;
    }
    AppMethodBeat.o(71080);
  }
  
  public final String Ch(long paramLong)
  {
    AppMethodBeat.i(71091);
    if (this.Dhx.containsKey(Long.valueOf(paramLong)))
    {
      String str = (String)this.Dhx.get(Long.valueOf(paramLong));
      AppMethodBeat.o(71091);
      return str;
    }
    AppMethodBeat.o(71091);
    return "-1";
  }
  
  protected final void Xd(String paramString)
  {
    AppMethodBeat.i(71079);
    eHr();
    e.o(this, paramString, false);
    this.Dhz = false;
    AppMethodBeat.o(71079);
  }
  
  protected final void Z(am paramam)
  {
    AppMethodBeat.i(71081);
    if ((paramam != null) && ((int)paramam.gfj != 0))
    {
      String str = paramam.adu();
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer nickName " + str + " username: " + paramam.field_username);
      if ((this.Dgz != null) && (this.Dgz.size() > 0))
      {
        Iterator localIterator = this.Dgz.iterator();
        while (localIterator.hasNext()) {
          ((Orders.Commodity)localIterator.next()).wCG = str;
        }
        this.Dht.notifyDataSetChanged();
      }
      this.lEN = paramam.field_username;
    }
    AppMethodBeat.o(71081);
  }
  
  protected final void a(Orders.Promotions paramPromotions)
  {
    AppMethodBeat.i(71074);
    doSceneForceProgress(new s(paramPromotions, getPayReqKey(), this.wxW, paramPromotions.CXL));
    AppMethodBeat.o(71074);
  }
  
  protected final void a(String paramString, d paramd)
  {
    AppMethodBeat.i(71078);
    eHr();
    this.Dhy = paramd;
    e.a(this, paramString, false, 1);
    this.Dhz = false;
    AppMethodBeat.o(71078);
  }
  
  protected final void aEV(String paramString)
  {
    AppMethodBeat.i(71072);
    doSceneProgress(new ae(paramString));
    AppMethodBeat.o(71072);
  }
  
  protected final boolean dJV()
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
            WalletOrderInfoOldUI.this.eHL();
            AppMethodBeat.o(71050);
          }
        });
        getInput().remove("key_realname_guide_helper");
        if (!bool) {
          eHL();
        }
      }
      AppMethodBeat.o(71083);
      return;
    }
    eHL();
    AppMethodBeat.o(71083);
  }
  
  protected Orders eHF()
  {
    AppMethodBeat.i(71070);
    Orders localOrders = (Orders)getInput().getParcelable("key_orders");
    AppMethodBeat.o(71070);
    return localOrders;
  }
  
  public final void eHL()
  {
    AppMethodBeat.i(71084);
    eHr();
    this.Dhz = false;
    Object localObject1 = new ax();
    ((ax)localObject1).dlL.dlM = true;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("intent_pay_end_errcode", getInput().getInt("intent_pay_end_errcode"));
    ((Bundle)localObject2).putString("intent_pay_app_url", getInput().getString("intent_pay_app_url"));
    ((Bundle)localObject2).putBoolean("intent_pay_end", getInput().getBoolean("intent_pay_end"));
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoOldUI", "pay done...feedbackData errCode:" + getInput().getInt("intent_pay_end_errcode"));
    Iterator localIterator = this.Dgy.iterator();
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (!bt.isNullOrNil(str1))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoOldUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str1 });
        if ((this.CIn == null) || (this.mPayInfo == null)) {
          break label339;
        }
        q localq = com.tencent.mm.kernel.g.ajB().gAO;
        String str2 = this.CIn.dlu;
        if (this.CIn.CYk.size() <= 0) {
          break label333;
        }
        localObject1 = ((Orders.Commodity)this.CIn.CYk.get(0)).dlv;
        label250:
        localq.a(new com.tencent.mm.wallet_core.c.t(str1, str2, (String)localObject1, this.mPayInfo.dCC, this.mPayInfo.channel, this.CIn.CYa), 0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(13033, new Object[] { Integer.valueOf(2), str1, "", "", "" });
        break;
        label333:
        localObject1 = "";
        break label250;
        label339:
        com.tencent.mm.kernel.g.ajB().gAO.a(new com.tencent.mm.wallet_core.c.t(str1), 0);
      }
    }
    com.tencent.mm.wallet_core.a.k(this, (Bundle)localObject2);
    if ((this.CIn != null) && (!bt.isNullOrNil(this.CIn.qeQ))) {
      if (this.CIn.CYk.size() <= 0) {
        break label535;
      }
    }
    label535:
    for (localObject1 = ((Orders.Commodity)this.CIn.CYk.get(0)).dlv;; localObject1 = "")
    {
      localObject1 = e(this.CIn.qeQ, this.CIn.dlu, (String)localObject1, this.mPayInfo.oyb, this.mPayInfo.iTM);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletOrderInfoOldUI", "url = ".concat(String.valueOf(localObject1)));
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
      ((Intent)localObject2).putExtra("showShare", false);
      ((Intent)localObject2).putExtra("geta8key_username", u.aAm());
      ((Intent)localObject2).putExtra("stastic_scene", 8);
      com.tencent.mm.bs.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject2);
      AppMethodBeat.o(71084);
      return;
    }
  }
  
  protected final void fo(String paramString, int paramInt)
  {
    AppMethodBeat.i(71073);
    doSceneProgress(new ae(paramString, paramInt));
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
    if ((this.mPayInfo != null) && (this.mPayInfo.dCC == 2)) {
      if (!bt.isNullOrNil(this.mPayInfo.DpS)) {
        localObject = getString(2131755281) + this.mPayInfo.DpS;
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
      this.Dhq = ((LinearLayout)findViewById(2131306794));
      this.Dhr = ((TextView)findViewById(2131306793));
      this.Dhs = ((TextView)findViewById(2131306786));
      localObject = (MaxListView)findViewById(2131306770);
      this.Dht = new a();
      ((MaxListView)localObject).setAdapter(this.Dht);
      eHM();
      eHN();
      ((ScrollView)findViewById(2131306834)).pageScroll(33);
      AppMethodBeat.o(71076);
      return;
      localObject = str;
      if (!bt.isNullOrNil(this.mPayInfo.appId))
      {
        localObject = str;
        if (!bt.isNullOrNil(com.tencent.mm.pluginsdk.model.app.h.r(this, this.mPayInfo.appId)))
        {
          localObject = getString(2131755281) + com.tencent.mm.pluginsdk.model.app.h.r(this, this.mPayInfo.appId);
          continue;
          localObject = str;
          if (this.CIn != null)
          {
            localObject = str;
            if (!bt.isNullOrNil(this.CIn.CYv)) {
              localObject = this.CIn.CYv;
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoOldUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1) {
      doSceneProgress(new af(this.Dhy.CPq, this.Dhy.Dhl, this.Dhy.Dhm, this.Dhy.Dhn, this.Dhy.dve, this.Dhy.xZh, this.Dhy.CZw));
    }
    AppMethodBeat.o(71088);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71069);
    super.onCreate(paramBundle);
    setContentViewVisibility(4);
    this.Dgy = new HashSet();
    Zd();
    initView();
    addSceneEndListener(1979);
    com.tencent.mm.sdk.b.a.IbL.c(this.Dha);
    com.tencent.mm.sdk.b.a.IbL.c(this.wAM);
    this.Dhz = false;
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
    com.tencent.mm.sdk.b.a.IbL.d(this.Dha);
    com.tencent.mm.sdk.b.a.IbL.d(this.wAM);
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoOldUI", "onResume, isClickActivityTinyApp: %s", new Object[] { Boolean.valueOf(this.Dhz) });
    if (this.Dhz) {
      doSceneProgress(new af(this.Dhy.CPq, this.Dhy.Dhl, this.Dhy.Dhm, this.Dhy.Dhn, this.Dhy.dve, this.Dhy.xZh, this.Dhy.CZw));
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
      b localb = new b(localaf.kqN);
      if ((!bt.isNullOrNil(localb.url)) && (!bt.isNullOrNil(localb.dxD)))
      {
        i = 1;
        if (i != 0) {
          this.DcT.put(localaf.CPq, localb);
        }
        this.Dht.notifyDataSetChanged();
      }
    }
    else
    {
      if (!(paramn instanceof ae)) {
        break label355;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        setContentViewVisibility(0);
        this.CIn = ((ae)paramn).CPv;
        if (this.CIn != null) {
          this.Dgz = this.CIn.CYk;
        }
        d(this.CIn);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + this.Dgz);
        if ((this.Dgz != null) && (this.Dgz.size() != 0))
        {
          paramString = (Orders.Commodity)this.Dgz.get(0);
          this.wxW = paramString.dlv;
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + paramString.toString());
          paramn = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramString.wCG);
          if ((paramn == null) || ((int)paramn.gfj == 0)) {
            break label334;
          }
          Z(paramn);
        }
      }
    }
    for (;;)
    {
      this.Dht.notifyDataSetChanged();
      eHM();
      if (this.Dht != null) {
        this.Dht.notifyDataSetChanged();
      }
      eHN();
      AppMethodBeat.o(71090);
      return true;
      i = 0;
      break;
      label334:
      as.a.hFO.a(paramString.wCG, "", this.DhA);
    }
    label355:
    if ((paramn instanceof s))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (s)paramn;
        paramn = paramString.COY;
        long l = paramString.CPb.COR;
        this.Dhx.put(Long.valueOf(l), paramn);
        paramString.CPb.CXM = paramString.fKQ;
        if ((!"-1".equals(paramn)) && (!"0".equals(paramn)) && (!bt.isNullOrNil(paramString.COZ))) {
          com.tencent.mm.ui.base.h.c(this, paramString.COZ, "", true);
        }
        while (!"0".equals(paramn))
        {
          this.Dht.notifyDataSetChanged();
          AppMethodBeat.o(71090);
          return true;
        }
        if (!bt.isNullOrNil(paramString.COZ)) {}
        for (paramString = paramString.COZ;; paramString = getString(2131765658))
        {
          Toast.makeText(this, paramString, 0).show();
          break;
        }
      }
      if ((paramn instanceof s))
      {
        paramn = paramString;
        if (bt.isNullOrNil(paramString)) {
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
    
    private Orders.Commodity VG(int paramInt)
    {
      AppMethodBeat.i(71057);
      Orders.Commodity localCommodity = (Orders.Commodity)WalletOrderInfoOldUI.this.Dgz.get(paramInt);
      AppMethodBeat.o(71057);
      return localCommodity;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(71056);
      if (WalletOrderInfoOldUI.this.Dgz != null)
      {
        int i = WalletOrderInfoOldUI.this.Dgz.size();
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
        paramViewGroup.DhF = ((TextView)paramView.findViewById(2131306772));
        paramViewGroup.iCV = ((TextView)paramView.findViewById(2131306777));
        paramViewGroup.DhI = ((TextView)paramView.findViewById(2131306798));
        paramViewGroup.DhG = ((TextView)paramView.findViewById(2131306804));
        paramViewGroup.DhH = ((TextView)paramView.findViewById(2131306790));
        paramViewGroup.DhH.getPaint().setFlags(16);
        paramViewGroup.DhJ = ((TextView)paramView.findViewById(2131306805));
        paramViewGroup.DhK = ((TextView)paramView.findViewById(2131306775));
        paramViewGroup.DhL = ((TextView)paramView.findViewById(2131306771));
        paramViewGroup.DhN = ((MaxListView)paramView.findViewById(2131306792));
        paramViewGroup.DhO = paramView.findViewById(2131306780);
        paramViewGroup.DhM = paramView.findViewById(2131306796);
        paramViewGroup.DhQ = ((TextView)paramView.findViewById(2131306807));
        paramViewGroup.DhP = ((TextView)paramView.findViewById(2131306808));
        paramViewGroup.DhR = ((TextView)paramView.findViewById(2131306809));
        paramViewGroup.DhS = ((TextView)paramView.findViewById(2131306810));
        paramViewGroup.DhU = ((ViewGroup)paramView.findViewById(2131306801));
        paramViewGroup.Dda = ((CdnImageView)paramView.findViewById(2131305857));
        paramViewGroup.Ddb = ((TextView)paramView.findViewById(2131305853));
        paramViewGroup.Ddc = ((TextView)paramView.findViewById(2131305858));
        paramViewGroup.DhT = paramView.findViewById(2131306797);
        paramView.setTag(paramViewGroup);
        localCommodity = VG(paramInt);
        if ((localCommodity == null) || (paramViewGroup == null)) {
          break label1188;
        }
        WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this, localCommodity.dlv);
        paramViewGroup.DhG.setText(e.d(localCommodity.paV, localCommodity.wCF));
        if ((localCommodity.CYL < 0.0D) || (localCommodity.paV >= localCommodity.CYL)) {
          break label632;
        }
        paramViewGroup.DhH.setText(e.d(localCommodity.CYL, localCommodity.wCF));
        paramViewGroup.DhH.setVisibility(0);
        localObject1 = (LinearLayout)paramViewGroup.DhO;
        localObject2 = localCommodity.CYO;
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
        if (localDiscountInfo.CZg <= 0.0D) {
          break label644;
        }
        localTextView.setText(localDiscountInfo.xXz + e.d(localDiscountInfo.CZg / 100.0D, WalletOrderInfoOldUI.this.CIn.wCF));
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
        paramViewGroup.DhH.setVisibility(8);
        break label398;
        label644:
        localTextView.setText(localDiscountInfo.xXz);
      }
      label657:
      if (((LinearLayout)localObject1).getChildCount() > 0)
      {
        ((LinearLayout)localObject1).setVisibility(0);
        localObject2 = paramViewGroup.DhF;
        localObject1 = WalletOrderInfoOldUI.this;
        if (!u.aAB()) {
          break label1205;
        }
        localObject1 = ((Context)localObject1).getString(2131765564);
        label699:
        ((TextView)localObject2).setText((CharSequence)localObject1);
        paramViewGroup.DhI.setText(localCommodity.wCu);
        paramViewGroup.iCV.setText(localCommodity.desc);
        paramViewGroup.iCV.setTag(localCommodity.desc);
        paramViewGroup.iCV.setOnLongClickListener(WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this));
        paramViewGroup.iCV.setBackgroundResource(2131234695);
        paramViewGroup.DhJ.setText(localCommodity.dlv);
        paramViewGroup.DhJ.setTag(localCommodity.dlv);
        paramViewGroup.DhJ.setOnLongClickListener(WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this));
        paramViewGroup.DhJ.setBackgroundResource(2131234695);
        paramViewGroup.DhK.setText(e.ov(localCommodity.wCB));
        paramViewGroup.DhL.setText(localCommodity.wCD);
        localObject1 = localCommodity.CYP;
        if (paramViewGroup.DhR != null)
        {
          if (bt.isNullOrNil((String)localObject1)) {
            break label1218;
          }
          paramViewGroup.DhR.setText((CharSequence)localObject1);
          paramViewGroup.DhR.setVisibility(0);
          paramViewGroup.DhS.setVisibility(0);
        }
        label888:
        localObject1 = localCommodity.CYR;
        if (paramViewGroup.DhQ != null)
        {
          if (bt.isNullOrNil((String)localObject1)) {
            break label1239;
          }
          paramViewGroup.DhQ.setText((CharSequence)localObject1);
          paramViewGroup.DhQ.setVisibility(0);
          paramViewGroup.DhP.setVisibility(0);
        }
        label935:
        if (localCommodity.CYU.size() <= 0) {
          break label1260;
        }
        localObject1 = (Orders.Promotions)localCommodity.CYU.get(0);
        com.tencent.mm.plugin.report.service.g.yhR.f(13033, new Object[] { Integer.valueOf(1), ((Orders.Promotions)localObject1).wCG, ((Orders.Promotions)localObject1).url, ((Orders.Promotions)localObject1).name, WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this) });
        WalletOrderInfoOldUI.this.Dhw = new WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this, localCommodity.CYU);
        paramViewGroup.DhN.setAdapter(WalletOrderInfoOldUI.this.Dhw);
        paramViewGroup.DhN.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(71054);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousAdapterView);
            localb.bd(paramAnonymousView);
            localb.mr(paramAnonymousInt);
            localb.qY(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
            paramAnonymousAdapterView = WalletOrderInfoOldUI.this.Dhw.VH(paramAnonymousInt);
            if (!bt.isNullOrNil(paramAnonymousAdapterView.wCG)) {
              if (WalletOrderInfoOldUI.this.Dgy.contains(paramAnonymousAdapterView.wCG))
              {
                WalletOrderInfoOldUI.this.Dgy.remove(paramAnonymousAdapterView.wCG);
                WalletOrderInfoOldUI.this.Dht.notifyDataSetChanged();
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(71054);
              return;
              WalletOrderInfoOldUI.this.Dgy.add(paramAnonymousAdapterView.wCG);
              break;
              paramAnonymousView = WalletOrderInfoOldUI.this.Ch(paramAnonymousAdapterView.COR);
              if (("-1".equals(paramAnonymousView)) || ("3".equals(paramAnonymousView)))
              {
                com.tencent.mm.plugin.report.service.g.yhR.f(13472, new Object[] { WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this), Integer.valueOf(paramAnonymousAdapterView.OdM), Integer.valueOf(1), Long.valueOf(paramAnonymousAdapterView.COR), Long.valueOf(paramAnonymousAdapterView.CXL) });
                com.tencent.mm.plugin.report.service.g.yhR.f(13033, new Object[] { Integer.valueOf(2), "", paramAnonymousAdapterView.url, paramAnonymousAdapterView.name, "" });
                if ((!bt.isNullOrNil(paramAnonymousAdapterView.OdP)) && (!bt.isNullOrNil(paramAnonymousAdapterView.OdQ)))
                {
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoOldUI", "promotion jump tiny app, username: %s, path: %s", new Object[] { paramAnonymousAdapterView.OdP, paramAnonymousAdapterView.OdQ });
                  paramAnonymousView = new vm();
                  paramAnonymousView.dJF.userName = paramAnonymousAdapterView.OdP;
                  paramAnonymousView.dJF.dJH = bt.bI(paramAnonymousAdapterView.OdQ, "");
                  paramAnonymousView.dJF.scene = 1060;
                  paramAnonymousView.dJF.dkh = WalletOrderInfoOldUI.this.wxW;
                  paramAnonymousView.dJF.dJI = 0;
                  com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
                  com.tencent.mm.plugin.report.service.g.yhR.f(14118, new Object[] { WalletOrderInfoOldUI.this.wxW, WalletOrderInfoOldUI.this.getPayReqKey(), Integer.valueOf(2) });
                  WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this, new WalletOrderInfoOldUI.d(WalletOrderInfoOldUI.this, paramAnonymousAdapterView.COR, paramAnonymousAdapterView.OdN, paramAnonymousAdapterView.CXJ, paramAnonymousAdapterView.CXK, WalletOrderInfoOldUI.this.getPayReqKey(), WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this), paramAnonymousAdapterView.CXL));
                  WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this, true);
                }
                else if (paramAnonymousAdapterView.OdM == 1)
                {
                  WalletOrderInfoOldUI.this.a(paramAnonymousAdapterView);
                }
                else if ((paramAnonymousAdapterView.OdM == 2) && (!bt.isNullOrNil(paramAnonymousAdapterView.url)))
                {
                  if (WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this).containsKey(paramAnonymousAdapterView.COR))
                  {
                    paramAnonymousAdapterView = (WalletOrderInfoOldUI.b)WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this).get(paramAnonymousAdapterView.COR);
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoOldUI", "go to new url %s", new Object[] { paramAnonymousAdapterView.url });
                    WalletOrderInfoOldUI.this.Xd(paramAnonymousAdapterView.url);
                  }
                  else
                  {
                    WalletOrderInfoOldUI.this.DcU = paramAnonymousAdapterView.url;
                    WalletOrderInfoOldUI.this.a(paramAnonymousAdapterView.url, new WalletOrderInfoOldUI.d(WalletOrderInfoOldUI.this, paramAnonymousAdapterView.COR, paramAnonymousAdapterView.OdN, paramAnonymousAdapterView.CXJ, paramAnonymousAdapterView.CXK, WalletOrderInfoOldUI.this.getPayReqKey(), WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this), paramAnonymousAdapterView.CXL));
                  }
                }
                else
                {
                  com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOrderInfoOldUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
                }
              }
            }
          }
        });
        WalletOrderInfoOldUI.this.Dhw.notifyDataSetChanged();
        paramViewGroup.DhN.setVisibility(0);
        paramViewGroup.DhM.setVisibility(0);
        label1096:
        if ((localCommodity.CYS == null) || (bt.isNullOrNil(localCommodity.CYS.CzQ))) {
          break label1290;
        }
        paramViewGroup.Dda.setUrl(localCommodity.CYS.CXO);
        paramViewGroup.Ddb.setText(localCommodity.CYS.CXP);
        paramViewGroup.Ddc.setText(localCommodity.CYS.CNV);
        paramViewGroup.DhU.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71055);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            paramAnonymousView = new vm();
            paramAnonymousView.dJF.userName = localCommodity.CYS.CzQ;
            paramAnonymousView.dJF.dJH = bt.bI(localCommodity.CYS.CzR, "");
            paramAnonymousView.dJF.scene = 1034;
            paramAnonymousView.dJF.dJI = 0;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
            com.tencent.mm.plugin.report.service.g.yhR.f(14118, new Object[] { WalletOrderInfoOldUI.this.wxW, WalletOrderInfoOldUI.this.getPayReqKey(), Integer.valueOf(1) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71055);
          }
        });
        paramViewGroup.DhT.setVisibility(0);
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
        paramViewGroup.DhS.setVisibility(8);
        paramViewGroup.DhR.setVisibility(8);
        break label888;
        label1239:
        paramViewGroup.DhP.setVisibility(8);
        paramViewGroup.DhQ.setVisibility(8);
        break label935;
        label1260:
        paramViewGroup.DhN.setVisibility(8);
        paramViewGroup.DhU.setVisibility(8);
        paramViewGroup.DhM.setVisibility(8);
        break label1096;
        label1290:
        paramViewGroup.DhU.setVisibility(8);
        paramViewGroup.DhT.setVisibility(8);
      }
    }
    
    final class a
    {
      CdnImageView Dda;
      TextView Ddb;
      TextView Ddc;
      TextView DhF;
      TextView DhG;
      TextView DhH;
      TextView DhI;
      TextView DhJ;
      TextView DhK;
      TextView DhL;
      View DhM;
      MaxListView DhN;
      View DhO;
      TextView DhP;
      TextView DhQ;
      TextView DhR;
      TextView DhS;
      View DhT;
      ViewGroup DhU;
      TextView iCV;
      
      a() {}
    }
  }
  
  final class b
  {
    public String Dhj;
    public String dDH;
    public String dxD;
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
        this.dxD = WalletOrderInfoOldUI.this.optString("wording");
        this.dDH = WalletOrderInfoOldUI.this.optString("icon");
        this.Dhj = WalletOrderInfoOldUI.this.optString("btn_text");
        this.title = WalletOrderInfoOldUI.this.optString("title");
      }
      AppMethodBeat.o(71060);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(71061);
      String str = this.url + " , " + this.dxD + " , " + this.dDH + " , " + this.Dhj + " , " + this.title;
      AppMethodBeat.o(71061);
      return str;
    }
  }
  
  final class c
    extends BaseAdapter
  {
    protected List<Orders.Promotions> CYU;
    
    public c()
    {
      AppMethodBeat.i(71062);
      this.CYU = null;
      this.CYU = new ArrayList();
      Object localObject;
      int j = localObject.size();
      int i = 0;
      while (i < j)
      {
        this$1 = (Orders.Promotions)localObject.get(i);
        if ((WalletOrderInfoOldUI.this != null) && ((!bt.isNullOrNil(WalletOrderInfoOldUI.this.wCG)) || (WalletOrderInfoOldUI.this.OdM == 2) || (WalletOrderInfoOldUI.this.OdM == 1))) {
          this.CYU.add(localObject.get(i));
        }
        i += 1;
      }
      AppMethodBeat.o(71062);
    }
    
    public final Orders.Promotions VH(int paramInt)
    {
      AppMethodBeat.i(71064);
      Orders.Promotions localPromotions = (Orders.Promotions)this.CYU.get(paramInt);
      AppMethodBeat.o(71064);
      return localPromotions;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(71063);
      if (this.CYU != null)
      {
        int i = this.CYU.size();
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
      Orders.Promotions localPromotions = VH(paramInt);
      Object localObject;
      if ((bt.isNullOrNil(localPromotions.wCG)) && (localPromotions.COR > 0L))
      {
        localObject = WalletOrderInfoOldUI.this.Ch(localPromotions.COR);
        com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
        String str = WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this);
        paramInt = localPromotions.OdM;
        paramViewGroup = (ViewGroup)localObject;
        if ("-1".equals(localObject)) {
          paramViewGroup = Integer.valueOf(5);
        }
        localg.f(13471, new Object[] { str, Integer.valueOf(1), Integer.valueOf(paramInt), paramViewGroup, Long.valueOf(localPromotions.COR), Long.valueOf(localPromotions.CXL) });
      }
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramViewGroup.type = localPromotions.type;
        if (localPromotions.type == Orders.CYK) {
          if (localPromotions.CZh == 1)
          {
            paramView = View.inflate(WalletOrderInfoOldUI.this, 2131495998, null);
            paramViewGroup.oMB = ((CdnImageView)paramView.findViewById(2131306787));
            paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131306802));
            paramViewGroup.DhV = ((TextView)paramView.findViewById(2131306774));
            paramViewGroup.fQd = ((TextView)paramView.findViewById(2131306789));
            if (!TextUtils.isEmpty(localPromotions.url)) {
              WalletOrderInfoOldUI.this.Dhv.put(localPromotions.url, paramViewGroup.DhV);
            }
            paramView.setTag(paramViewGroup);
            paramViewGroup.CZh = localPromotions.CZh;
          }
        }
      }
      label293:
      label1586:
      for (;;)
      {
        if (localPromotions != null)
        {
          localObject = (WalletOrderInfoOldUI.b)WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this).get(localPromotions.COR);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoOldUI", "try get result ".concat(String.valueOf(localObject)));
          if (localObject == null) {
            break label1306;
          }
          paramViewGroup.oMB.setUrl(((WalletOrderInfoOldUI.b)localObject).dDH);
          paramViewGroup.fQd.setText(((WalletOrderInfoOldUI.b)localObject).dxD);
          paramViewGroup.DhV.setText(((WalletOrderInfoOldUI.b)localObject).Dhj);
          if (bt.isNullOrNil(localPromotions.wCG)) {
            break label1356;
          }
          paramViewGroup.DhV.setVisibility(8);
          if (paramViewGroup.DhW != null)
          {
            paramViewGroup.DhW.setVisibility(0);
            if (!WalletOrderInfoOldUI.this.Dgy.contains(localPromotions.wCG)) {
              break label1345;
            }
            paramViewGroup.DhW.setChecked(true);
          }
          label450:
          if ((paramViewGroup.titleTv == null) || (localObject == null) || (bt.isNullOrNil(((WalletOrderInfoOldUI.b)localObject).title))) {
            break label1383;
          }
          paramViewGroup.titleTv.setText(((WalletOrderInfoOldUI.b)localObject).title);
          label485:
          if ((!bt.isNullOrNil(WalletOrderInfoOldUI.this.DcU)) && (paramViewGroup.DhV != null))
          {
            paramViewGroup.DhV.setClickable(WalletOrderInfoOldUI.this.dlQ);
            paramViewGroup.DhV.setEnabled(WalletOrderInfoOldUI.this.dlQ);
            paramViewGroup.DhV.setOnClickListener(null);
            if (WalletOrderInfoOldUI.this.dlR) {
              paramViewGroup.DhV.setVisibility(8);
            }
          }
          long l = localPromotions.COR;
          localObject = WalletOrderInfoOldUI.this.Ch(l);
          if (!((String)localObject).equals("0")) {
            break label1435;
          }
          paramViewGroup.DhV.setBackgroundColor(WalletOrderInfoOldUI.this.getResources().getColor(2131101053));
          paramViewGroup.DhV.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(2131101171));
        }
        for (;;)
        {
          if (paramViewGroup.DhV != null)
          {
            paramInt = BackwardSupportUtil.b.g(WalletOrderInfoOldUI.this.getContext(), 15.0F);
            i = BackwardSupportUtil.b.g(WalletOrderInfoOldUI.this.getContext(), 5.0F);
            paramViewGroup.DhV.setPadding(paramInt, i, paramInt, i);
          }
          AppMethodBeat.o(71065);
          return paramView;
          paramView = View.inflate(WalletOrderInfoOldUI.this, 2131495999, null);
          paramViewGroup.oMB = ((CdnImageView)paramView.findViewById(2131306787));
          paramViewGroup.DhV = ((TextView)paramView.findViewById(2131306774));
          paramViewGroup.fQd = ((TextView)paramView.findViewById(2131306789));
          paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131306802));
          if (!TextUtils.isEmpty(localPromotions.url)) {
            WalletOrderInfoOldUI.this.Dhv.put(localPromotions.url, paramViewGroup.DhV);
          }
          paramView.setTag(paramViewGroup);
          break;
          paramView = View.inflate(WalletOrderInfoOldUI.this, 2131496000, null);
          paramViewGroup.oMB = ((CdnImageView)paramView.findViewById(2131306787));
          paramViewGroup.DhV = ((TextView)paramView.findViewById(2131306774));
          paramViewGroup.fQd = ((TextView)paramView.findViewById(2131306789));
          paramViewGroup.DhW = ((CheckBox)paramView.findViewById(2131296518));
          if (!TextUtils.isEmpty(localPromotions.url)) {
            WalletOrderInfoOldUI.this.Dhv.put(localPromotions.url, paramViewGroup.DhV);
          }
          paramView.setTag(paramViewGroup);
          break label293;
          paramViewGroup = (a)paramView.getTag();
          int i = 0;
          paramInt = i;
          if (localPromotions.type == paramViewGroup.type) {
            if (localPromotions.type == Orders.CYK)
            {
              paramInt = i;
              if (localPromotions.CZh != paramViewGroup.CZh) {}
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
          if (localPromotions.type == Orders.CYK)
          {
            if (localPromotions.CZh == 1)
            {
              paramView = View.inflate(WalletOrderInfoOldUI.this, 2131495998, null);
              paramViewGroup.oMB = ((CdnImageView)paramView.findViewById(2131306787));
              paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131306802));
              paramViewGroup.DhV = ((TextView)paramView.findViewById(2131306774));
              paramViewGroup.fQd = ((TextView)paramView.findViewById(2131306789));
              if (!TextUtils.isEmpty(localPromotions.url)) {
                WalletOrderInfoOldUI.this.Dhv.put(localPromotions.url, paramViewGroup.DhV);
              }
              paramView.setTag(paramViewGroup);
            }
            for (;;)
            {
              paramViewGroup.CZh = localPromotions.CZh;
              break;
              paramView = View.inflate(WalletOrderInfoOldUI.this, 2131495999, null);
              paramViewGroup.oMB = ((CdnImageView)paramView.findViewById(2131306787));
              paramViewGroup.DhV = ((TextView)paramView.findViewById(2131306774));
              paramViewGroup.fQd = ((TextView)paramView.findViewById(2131306789));
              paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131306802));
              if (!TextUtils.isEmpty(localPromotions.url)) {
                WalletOrderInfoOldUI.this.Dhv.put(localPromotions.url, paramViewGroup.DhV);
              }
              paramView.setTag(paramViewGroup);
            }
          }
          paramView = View.inflate(WalletOrderInfoOldUI.this, 2131496000, null);
          paramViewGroup.oMB = ((CdnImageView)paramView.findViewById(2131306787));
          paramViewGroup.DhV = ((TextView)paramView.findViewById(2131306774));
          paramViewGroup.fQd = ((TextView)paramView.findViewById(2131306789));
          paramViewGroup.DhW = ((CheckBox)paramView.findViewById(2131296518));
          if (!TextUtils.isEmpty(localPromotions.url)) {
            WalletOrderInfoOldUI.this.Dhv.put(localPromotions.url, paramViewGroup.DhV);
          }
          paramView.setTag(paramViewGroup);
          break label293;
          paramViewGroup.oMB.setUrl(localPromotions.wMR);
          paramViewGroup.fQd.setText(localPromotions.name);
          paramViewGroup.DhV.setText(localPromotions.CXM);
          break label387;
          label1345:
          paramViewGroup.DhW.setChecked(false);
          break label450;
          label1356:
          paramViewGroup.DhV.setVisibility(0);
          if (paramViewGroup.DhW == null) {
            break label450;
          }
          paramViewGroup.DhW.setVisibility(8);
          break label450;
          label1383:
          if ((paramViewGroup.titleTv != null) && (!bt.isNullOrNil(localPromotions.title)))
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
            paramViewGroup.DhV.setBackgroundDrawable(WalletOrderInfoOldUI.this.getResources().getDrawable(2131231379));
            paramViewGroup.DhV.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(2131101171));
          }
          else if ((((String)localObject).equals("4")) || (((String)localObject).equals("2")) || (((String)localObject).equals("1")))
          {
            paramViewGroup.DhV.setBackgroundColor(WalletOrderInfoOldUI.this.getResources().getColor(2131101053));
            paramViewGroup.DhV.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(2131100490));
          }
          else
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOrderInfoOldUI", "PromotionsAdapter unknow award state");
          }
        }
      }
    }
    
    final class a
    {
      int CZh;
      TextView DhV;
      CheckBox DhW;
      TextView fQd;
      CdnImageView oMB;
      TextView titleTv;
      int type;
      
      a() {}
    }
  }
  
  final class d
  {
    public String CPq;
    public long CZw;
    public String Dhl;
    public String Dhm;
    public String Dhn;
    public String dve;
    public String xZh;
    
    public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong)
    {
      this.CPq = paramString1;
      this.Dhl = paramString2;
      this.Dhm = paramString3;
      this.Dhn = paramString4;
      this.dve = paramString5;
      this.xZh = paramString6;
      this.CZw = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI
 * JD-Core Version:    0.7.0.1
 */