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
import com.tencent.mm.g.a.kf;
import com.tencent.mm.g.a.kf.a;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.a.xs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.c.af;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.a;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.t;
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
  private HashMap<String, b> BCB;
  protected String BCC;
  protected boolean BCw;
  private c BGI;
  protected LinearLayout BGY;
  protected TextView BGZ;
  protected Set<String> BGg;
  protected List<Orders.Commodity> BGh;
  protected TextView BHa;
  protected a BHb;
  protected String BHc;
  protected HashMap<String, TextView> BHd;
  protected c BHe;
  protected Map<Long, String> BHf;
  private d BHg;
  private boolean BHh;
  protected ar.b.a BHi;
  private View.OnLongClickListener BHj;
  protected Orders BhZ;
  protected boolean daw;
  protected boolean dax;
  protected boolean day;
  protected String lhM;
  protected String mAppId;
  protected PayInfo mPayInfo;
  protected String vsE;
  private c vvs;
  protected String vyB;
  private String wRe;
  
  public WalletOrderInfoOldUI()
  {
    AppMethodBeat.i(71067);
    this.BGY = null;
    this.BGZ = null;
    this.BHa = null;
    this.BGh = null;
    this.BHb = null;
    this.lhM = null;
    this.vyB = null;
    this.BCw = false;
    this.BGg = null;
    this.mAppId = "";
    this.BHc = null;
    this.daw = true;
    this.dax = false;
    this.day = false;
    this.BHd = new HashMap();
    this.BHf = new HashMap();
    this.BCB = new HashMap();
    this.BHh = false;
    this.vvs = new c() {};
    this.BHi = new WalletOrderInfoOldUI.6(this);
    this.BHj = new WalletOrderInfoOldUI.11(this);
    this.BGI = new WalletOrderInfoOldUI.3(this);
    AppMethodBeat.o(71067);
  }
  
  private void WJ()
  {
    int j = 1;
    AppMethodBeat.i(71068);
    com.tencent.mm.wallet_core.d locald = com.tencent.mm.wallet_core.a.br(this);
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.vsE = getInput().getString("key_trans_id");
    getInput().getInt("key_pay_type", -1);
    ac.i("MicroMsg.WalletOrderInfoOldUI", "mTransId %s", new Object[] { this.vsE });
    this.BhZ = etz();
    if (this.BhZ != null)
    {
      setContentViewVisibility(0);
      d(this.BhZ);
      int i;
      boolean bool1;
      if ((locald != null) && (this.BhZ != null) && (this.mPayInfo != null))
      {
        this.mAppId = this.mPayInfo.appId;
        boolean bool2 = locald.fzH();
        f.a(this, getInput(), 7);
        if (getInput().getInt("key_support_bankcard", 1) == 2)
        {
          i = 2;
          com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
          int k = this.mPayInfo.dqL;
          if (this.mPayInfo.dqL != 3) {
            break label454;
          }
          bool1 = true;
          label189:
          if (!bool2) {
            break label460;
          }
          label194:
          localh.f(10691, new Object[] { Integer.valueOf(k), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(ab.fAr()), Integer.valueOf((int)(this.BhZ.daf * 100.0D)), this.BhZ.vxl, Integer.valueOf(i) });
        }
      }
      else
      {
        if (((!com.tencent.mm.plugin.wallet_core.model.s.ery().esa()) && (locald != null) && (locald.fzH())) || (!u.axG())) {
          u.axH();
        }
        if ((this.BhZ == null) || (this.BhZ.BxR == null) || (this.BhZ.BxR.size() <= 0)) {
          break label465;
        }
        this.BGh = this.BhZ.BxR;
        this.vsE = ((Orders.Commodity)this.BGh.get(0)).dad;
        if ((this.mPayInfo != null) && (locald != null) && ((locald.fzG()) || (locald.fzH()))) {
          doSceneProgress(new ad(getPayReqKey(), 21));
        }
      }
      for (;;)
      {
        if (this.vsE != null) {
          break label532;
        }
        if (((com.tencent.mm.plugin.fingerprint.b.h)g.ab(com.tencent.mm.plugin.fingerprint.b.h.class)).h(this)) {
          this.BHh = false;
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
        ac.m("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
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
    ac.m("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
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
    this.BGg.clear();
    if ((paramOrders == null) || (paramOrders.BxR == null))
    {
      ac.w("MicroMsg.WalletOrderInfoOldUI", "hy: orders is null");
      AppMethodBeat.o(71075);
      return;
    }
    paramOrders = paramOrders.BxR.iterator();
    while (paramOrders.hasNext())
    {
      Orders.Commodity localCommodity = (Orders.Commodity)paramOrders.next();
      if ((localCommodity.BxH == 2) && (!bs.isNullOrNil(localCommodity.Byt)))
      {
        ac.d("MicroMsg.WalletOrderInfoOldUI", "hy: has username and is force recommend");
        this.BGg.add(localCommodity.Byt);
      }
    }
    AppMethodBeat.o(71075);
  }
  
  private void etG()
  {
    AppMethodBeat.i(71077);
    if (this.BhZ != null)
    {
      this.BGh = this.BhZ.BxR;
      Iterator localIterator = this.BGh.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!"1".equals(((Orders.Commodity)localIterator.next()).vxe));
    }
    for (int i = 0;; i = 1)
    {
      this.BGY.setVisibility(0);
      this.BGZ.setVisibility(0);
      if (i != 0)
      {
        if ((!bs.isNullOrNil(this.BhZ.BxJ)) && (!bs.isNullOrNil(this.BhZ.BxJ.trim())))
        {
          this.BGZ.setText(this.BhZ.BxJ);
          AppMethodBeat.o(71077);
          return;
        }
        if (this.BhZ.BoU != 1)
        {
          this.BGZ.setText(2131765570);
          AppMethodBeat.o(71077);
          return;
        }
        this.BGZ.setText(2131765569);
        AppMethodBeat.o(71077);
        return;
      }
      this.BGZ.setText(2131765571);
      AppMethodBeat.o(71077);
      return;
    }
  }
  
  private void etH()
  {
    AppMethodBeat.i(71089);
    if ((this.BhZ != null) && (this.BhZ.BxR != null) && (this.BhZ.BxR.size() > 0) && (((Orders.Commodity)this.BhZ.BxR.get(0)).ByD != null) && (!bs.isNullOrNil(((Orders.Commodity)this.BhZ.BxR.get(0)).ByD.text)) && (!bs.isNullOrNil(((Orders.Commodity)this.BhZ.BxR.get(0)).ByD.url)))
    {
      this.BHa.setVisibility(0);
      this.BHa.setText(((Orders.Commodity)this.BhZ.BxR.get(0)).ByD.text);
      this.BHa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71052);
          e.o(WalletOrderInfoOldUI.this, ((Orders.Commodity)WalletOrderInfoOldUI.this.BhZ.BxR.get(0)).ByD.url, false);
          AppMethodBeat.o(71052);
        }
      });
      AppMethodBeat.o(71089);
      return;
    }
    ac.i("MicroMsg.WalletOrderInfoOldUI", "hy: no commodity or no link act or link act is illegal!");
    this.BHa.setVisibility(8);
    AppMethodBeat.o(71089);
  }
  
  private void etl()
  {
    int i = 0;
    AppMethodBeat.i(71080);
    if (!this.BCw)
    {
      kf localkf = new kf();
      localkf.dlK.requestCode = 4;
      kf.a locala = localkf.dlK;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.bPH = i;
      com.tencent.mm.sdk.b.a.GpY.l(localkf);
      this.BCw = true;
    }
    AppMethodBeat.o(71080);
  }
  
  protected final void Tw(String paramString)
  {
    AppMethodBeat.i(71079);
    etl();
    e.o(this, paramString, false);
    this.BHh = false;
    AppMethodBeat.o(71079);
  }
  
  protected final void Z(ai paramai)
  {
    AppMethodBeat.i(71081);
    if ((paramai != null) && ((int)paramai.fLJ != 0))
    {
      String str = paramai.aaR();
      ac.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer nickName " + str + " username: " + paramai.field_username);
      if ((this.BGh != null) && (this.BGh.size() > 0))
      {
        Iterator localIterator = this.BGh.iterator();
        while (localIterator.hasNext()) {
          ((Orders.Commodity)localIterator.next()).vxm = str;
        }
        this.BHb.notifyDataSetChanged();
      }
      this.lhM = paramai.field_username;
    }
    AppMethodBeat.o(71081);
  }
  
  protected final void a(Orders.Promotions paramPromotions)
  {
    AppMethodBeat.i(71074);
    doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.s(paramPromotions, getPayReqKey(), this.vsE, paramPromotions.Bxs));
    AppMethodBeat.o(71074);
  }
  
  protected final void a(String paramString, d paramd)
  {
    AppMethodBeat.i(71078);
    etl();
    this.BHg = paramd;
    e.a(this, paramString, false, 1);
    this.BHh = false;
    AppMethodBeat.o(71078);
  }
  
  protected final void azL(String paramString)
  {
    AppMethodBeat.i(71072);
    doSceneProgress(new ae(paramString));
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
            WalletOrderInfoOldUI.this.etF();
            AppMethodBeat.o(71050);
          }
        });
        getInput().remove("key_realname_guide_helper");
        if (!bool) {
          etF();
        }
      }
      AppMethodBeat.o(71083);
      return;
    }
    etF();
    AppMethodBeat.o(71083);
  }
  
  protected final boolean dyD()
  {
    return false;
  }
  
  protected final void eV(String paramString, int paramInt)
  {
    AppMethodBeat.i(71073);
    doSceneProgress(new ae(paramString, paramInt));
    AppMethodBeat.o(71073);
  }
  
  public final void etF()
  {
    AppMethodBeat.i(71084);
    etl();
    this.BHh = false;
    Object localObject1 = new com.tencent.mm.g.a.av();
    ((com.tencent.mm.g.a.av)localObject1).dar.das = true;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("intent_pay_end_errcode", getInput().getInt("intent_pay_end_errcode"));
    ((Bundle)localObject2).putString("intent_pay_app_url", getInput().getString("intent_pay_app_url"));
    ((Bundle)localObject2).putBoolean("intent_pay_end", getInput().getBoolean("intent_pay_end"));
    ac.i("MicroMsg.WalletOrderInfoOldUI", "pay done...feedbackData errCode:" + getInput().getInt("intent_pay_end_errcode"));
    Iterator localIterator = this.BGg.iterator();
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (!bs.isNullOrNil(str1))
      {
        ac.i("MicroMsg.WalletOrderInfoOldUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str1 });
        if ((this.BhZ == null) || (this.mPayInfo == null)) {
          break label339;
        }
        q localq = g.agQ().ghe;
        String str2 = this.BhZ.dac;
        if (this.BhZ.BxR.size() <= 0) {
          break label333;
        }
        localObject1 = ((Orders.Commodity)this.BhZ.BxR.get(0)).dad;
        label250:
        localq.a(new t(str1, str2, (String)localObject1, this.mPayInfo.dqL, this.mPayInfo.channel, this.BhZ.BxH), 0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(13033, new Object[] { Integer.valueOf(2), str1, "", "", "" });
        break;
        label333:
        localObject1 = "";
        break label250;
        label339:
        g.agQ().ghe.a(new t(str1), 0);
      }
    }
    com.tencent.mm.wallet_core.a.k(this, (Bundle)localObject2);
    if ((this.BhZ != null) && (!bs.isNullOrNil(this.BhZ.pBl))) {
      if (this.BhZ.BxR.size() <= 0) {
        break label535;
      }
    }
    label535:
    for (localObject1 = ((Orders.Commodity)this.BhZ.BxR.get(0)).dad;; localObject1 = "")
    {
      localObject1 = e(this.BhZ.pBl, this.BhZ.dac, (String)localObject1, this.mPayInfo.nUG, this.mPayInfo.iAC);
      ac.d("MicroMsg.WalletOrderInfoOldUI", "url = ".concat(String.valueOf(localObject1)));
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
      ((Intent)localObject2).putExtra("showShare", false);
      ((Intent)localObject2).putExtra("geta8key_username", u.axw());
      ((Intent)localObject2).putExtra("stastic_scene", 8);
      com.tencent.mm.br.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject2);
      AppMethodBeat.o(71084);
      return;
    }
  }
  
  protected Orders etz()
  {
    AppMethodBeat.i(71070);
    Orders localOrders = (Orders)getInput().getParcelable("key_orders");
    AppMethodBeat.o(71070);
    return localOrders;
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
    if ((this.mPayInfo != null) && (this.mPayInfo.dqL == 2)) {
      if (!bs.isNullOrNil(this.mPayInfo.BPA)) {
        localObject = getString(2131755281) + this.mPayInfo.BPA;
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
      this.BGY = ((LinearLayout)findViewById(2131306794));
      this.BGZ = ((TextView)findViewById(2131306793));
      this.BHa = ((TextView)findViewById(2131306786));
      localObject = (MaxListView)findViewById(2131306770);
      this.BHb = new a();
      ((MaxListView)localObject).setAdapter(this.BHb);
      etG();
      etH();
      ((ScrollView)findViewById(2131306834)).pageScroll(33);
      AppMethodBeat.o(71076);
      return;
      localObject = str;
      if (!bs.isNullOrNil(this.mPayInfo.appId))
      {
        localObject = str;
        if (!bs.isNullOrNil(com.tencent.mm.pluginsdk.model.app.h.s(this, this.mPayInfo.appId)))
        {
          localObject = getString(2131755281) + com.tencent.mm.pluginsdk.model.app.h.s(this, this.mPayInfo.appId);
          continue;
          localObject = str;
          if (this.BhZ != null)
          {
            localObject = str;
            if (!bs.isNullOrNil(this.BhZ.Byc)) {
              localObject = this.BhZ.Byc;
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
    ac.i("MicroMsg.WalletOrderInfoOldUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1) {
      doSceneProgress(new af(this.BHg.Bpb, this.BHg.BGT, this.BHg.BGU, this.BHg.BGV, this.BHg.djr, this.BHg.wLA, this.BHg.Bzd));
    }
    AppMethodBeat.o(71088);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71069);
    super.onCreate(paramBundle);
    setContentViewVisibility(4);
    this.BGg = new HashSet();
    WJ();
    initView();
    addSceneEndListener(1979);
    com.tencent.mm.sdk.b.a.GpY.c(this.BGI);
    com.tencent.mm.sdk.b.a.GpY.c(this.vvs);
    this.BHh = false;
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
    com.tencent.mm.sdk.b.a.GpY.d(this.BGI);
    com.tencent.mm.sdk.b.a.GpY.d(this.vvs);
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
    ac.i("MicroMsg.WalletOrderInfoOldUI", "onResume, isClickActivityTinyApp: %s", new Object[] { Boolean.valueOf(this.BHh) });
    if (this.BHh) {
      doSceneProgress(new af(this.BHg.Bpb, this.BHg.BGT, this.BHg.BGU, this.BHg.BGV, this.BHg.djr, this.BHg.wLA, this.BHg.Bzd));
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
      b localb = new b(localaf.jWw);
      if ((!bs.isNullOrNil(localb.url)) && (!bs.isNullOrNil(localb.dlQ)))
      {
        i = 1;
        if (i != 0) {
          this.BCB.put(localaf.Bpb, localb);
        }
        this.BHb.notifyDataSetChanged();
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
        this.BhZ = ((ae)paramn).Bpf;
        if (this.BhZ != null) {
          this.BGh = this.BhZ.BxR;
        }
        d(this.BhZ);
        ac.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + this.BGh);
        if ((this.BGh != null) && (this.BGh.size() != 0))
        {
          paramString = (Orders.Commodity)this.BGh.get(0);
          this.vsE = paramString.dad;
          ac.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + paramString.toString());
          paramn = ((k)g.ab(k.class)).awB().aNt(paramString.vxm);
          if ((paramn == null) || ((int)paramn.fLJ == 0)) {
            break label334;
          }
          Z(paramn);
        }
      }
    }
    for (;;)
    {
      this.BHb.notifyDataSetChanged();
      etG();
      if (this.BHb != null) {
        this.BHb.notifyDataSetChanged();
      }
      etH();
      AppMethodBeat.o(71090);
      return true;
      i = 0;
      break;
      label334:
      ar.a.hnw.a(paramString.vxm, "", this.BHi);
    }
    label355:
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.s))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.wallet_core.c.s)paramn;
        paramn = paramString.BoJ;
        long l = paramString.BoM.BoC;
        this.BHf.put(Long.valueOf(l), paramn);
        paramString.BoM.Bxt = paramString.fsq;
        if ((!"-1".equals(paramn)) && (!"0".equals(paramn)) && (!bs.isNullOrNil(paramString.BoK))) {
          com.tencent.mm.ui.base.h.c(this, paramString.BoK, "", true);
        }
        while (!"0".equals(paramn))
        {
          this.BHb.notifyDataSetChanged();
          AppMethodBeat.o(71090);
          return true;
        }
        if (!bs.isNullOrNil(paramString.BoK)) {}
        for (paramString = paramString.BoK;; paramString = getString(2131765658))
        {
          Toast.makeText(this, paramString, 0).show();
          break;
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.s))
      {
        paramn = paramString;
        if (bs.isNullOrNil(paramString)) {
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
  
  public final String zv(long paramLong)
  {
    AppMethodBeat.i(71091);
    if (this.BHf.containsKey(Long.valueOf(paramLong)))
    {
      String str = (String)this.BHf.get(Long.valueOf(paramLong));
      AppMethodBeat.o(71091);
      return str;
    }
    AppMethodBeat.o(71091);
    return "-1";
  }
  
  public final class a
    extends BaseAdapter
  {
    public a() {}
    
    private Orders.Commodity TO(int paramInt)
    {
      AppMethodBeat.i(71057);
      Orders.Commodity localCommodity = (Orders.Commodity)WalletOrderInfoOldUI.this.BGh.get(paramInt);
      AppMethodBeat.o(71057);
      return localCommodity;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(71056);
      if (WalletOrderInfoOldUI.this.BGh != null)
      {
        int i = WalletOrderInfoOldUI.this.BGh.size();
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
        paramViewGroup.BHn = ((TextView)paramView.findViewById(2131306772));
        paramViewGroup.ijE = ((TextView)paramView.findViewById(2131306777));
        paramViewGroup.BHq = ((TextView)paramView.findViewById(2131306798));
        paramViewGroup.BHo = ((TextView)paramView.findViewById(2131306804));
        paramViewGroup.BHp = ((TextView)paramView.findViewById(2131306790));
        paramViewGroup.BHp.getPaint().setFlags(16);
        paramViewGroup.BHr = ((TextView)paramView.findViewById(2131306805));
        paramViewGroup.BHs = ((TextView)paramView.findViewById(2131306775));
        paramViewGroup.BHt = ((TextView)paramView.findViewById(2131306771));
        paramViewGroup.BHv = ((MaxListView)paramView.findViewById(2131306792));
        paramViewGroup.BHw = paramView.findViewById(2131306780);
        paramViewGroup.BHu = paramView.findViewById(2131306796);
        paramViewGroup.BHy = ((TextView)paramView.findViewById(2131306807));
        paramViewGroup.BHx = ((TextView)paramView.findViewById(2131306808));
        paramViewGroup.BHz = ((TextView)paramView.findViewById(2131306809));
        paramViewGroup.BHA = ((TextView)paramView.findViewById(2131306810));
        paramViewGroup.BHC = ((ViewGroup)paramView.findViewById(2131306801));
        paramViewGroup.BCI = ((CdnImageView)paramView.findViewById(2131305857));
        paramViewGroup.BCJ = ((TextView)paramView.findViewById(2131305853));
        paramViewGroup.BCK = ((TextView)paramView.findViewById(2131305858));
        paramViewGroup.BHB = paramView.findViewById(2131306797);
        paramView.setTag(paramViewGroup);
        localCommodity = TO(paramInt);
        if ((localCommodity == null) || (paramViewGroup == null)) {
          break label1188;
        }
        WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this, localCommodity.dad);
        paramViewGroup.BHo.setText(e.d(localCommodity.oxA, localCommodity.vxl));
        if ((localCommodity.Bys < 0.0D) || (localCommodity.oxA >= localCommodity.Bys)) {
          break label632;
        }
        paramViewGroup.BHp.setText(e.d(localCommodity.Bys, localCommodity.vxl));
        paramViewGroup.BHp.setVisibility(0);
        localObject1 = (LinearLayout)paramViewGroup.BHw;
        localObject2 = localCommodity.Byv;
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
        if (localDiscountInfo.ByN <= 0.0D) {
          break label644;
        }
        localTextView.setText(localDiscountInfo.wJS + e.d(localDiscountInfo.ByN / 100.0D, WalletOrderInfoOldUI.this.BhZ.vxl));
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
        paramViewGroup.BHp.setVisibility(8);
        break label398;
        label644:
        localTextView.setText(localDiscountInfo.wJS);
      }
      label657:
      if (((LinearLayout)localObject1).getChildCount() > 0)
      {
        ((LinearLayout)localObject1).setVisibility(0);
        localObject2 = paramViewGroup.BHn;
        localObject1 = WalletOrderInfoOldUI.this;
        if (!u.axL()) {
          break label1205;
        }
        localObject1 = ((Context)localObject1).getString(2131765564);
        label699:
        ((TextView)localObject2).setText((CharSequence)localObject1);
        paramViewGroup.BHq.setText(localCommodity.vxa);
        paramViewGroup.ijE.setText(localCommodity.desc);
        paramViewGroup.ijE.setTag(localCommodity.desc);
        paramViewGroup.ijE.setOnLongClickListener(WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this));
        paramViewGroup.ijE.setBackgroundResource(2131234695);
        paramViewGroup.BHr.setText(localCommodity.dad);
        paramViewGroup.BHr.setTag(localCommodity.dad);
        paramViewGroup.BHr.setOnLongClickListener(WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this));
        paramViewGroup.BHr.setBackgroundResource(2131234695);
        paramViewGroup.BHs.setText(e.nV(localCommodity.vxh));
        paramViewGroup.BHt.setText(localCommodity.vxj);
        localObject1 = localCommodity.Byw;
        if (paramViewGroup.BHz != null)
        {
          if (bs.isNullOrNil((String)localObject1)) {
            break label1218;
          }
          paramViewGroup.BHz.setText((CharSequence)localObject1);
          paramViewGroup.BHz.setVisibility(0);
          paramViewGroup.BHA.setVisibility(0);
        }
        label888:
        localObject1 = localCommodity.Byy;
        if (paramViewGroup.BHy != null)
        {
          if (bs.isNullOrNil((String)localObject1)) {
            break label1239;
          }
          paramViewGroup.BHy.setText((CharSequence)localObject1);
          paramViewGroup.BHy.setVisibility(0);
          paramViewGroup.BHx.setVisibility(0);
        }
        label935:
        if (localCommodity.ByB.size() <= 0) {
          break label1260;
        }
        localObject1 = (Orders.Promotions)localCommodity.ByB.get(0);
        com.tencent.mm.plugin.report.service.h.wUl.f(13033, new Object[] { Integer.valueOf(1), ((Orders.Promotions)localObject1).vxm, ((Orders.Promotions)localObject1).url, ((Orders.Promotions)localObject1).name, WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this) });
        WalletOrderInfoOldUI.this.BHe = new WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this, localCommodity.ByB);
        paramViewGroup.BHv.setAdapter(WalletOrderInfoOldUI.this.BHe);
        paramViewGroup.BHv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(71054);
            paramAnonymousAdapterView = WalletOrderInfoOldUI.this.BHe.TP(paramAnonymousInt);
            if (!bs.isNullOrNil(paramAnonymousAdapterView.vxm))
            {
              if (WalletOrderInfoOldUI.this.BGg.contains(paramAnonymousAdapterView.vxm)) {
                WalletOrderInfoOldUI.this.BGg.remove(paramAnonymousAdapterView.vxm);
              }
              for (;;)
              {
                WalletOrderInfoOldUI.this.BHb.notifyDataSetChanged();
                AppMethodBeat.o(71054);
                return;
                WalletOrderInfoOldUI.this.BGg.add(paramAnonymousAdapterView.vxm);
              }
            }
            paramAnonymousView = WalletOrderInfoOldUI.this.zv(paramAnonymousAdapterView.BoC);
            if (("-1".equals(paramAnonymousView)) || ("3".equals(paramAnonymousView)))
            {
              com.tencent.mm.plugin.report.service.h.wUl.f(13472, new Object[] { WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this), Integer.valueOf(paramAnonymousAdapterView.DeE), Integer.valueOf(1), Long.valueOf(paramAnonymousAdapterView.BoC), Long.valueOf(paramAnonymousAdapterView.Bxs) });
              com.tencent.mm.plugin.report.service.h.wUl.f(13033, new Object[] { Integer.valueOf(2), "", paramAnonymousAdapterView.url, paramAnonymousAdapterView.name, "" });
              if ((!bs.isNullOrNil(paramAnonymousAdapterView.DeH)) && (!bs.isNullOrNil(paramAnonymousAdapterView.DeI)))
              {
                ac.i("MicroMsg.WalletOrderInfoOldUI", "promotion jump tiny app, username: %s, path: %s", new Object[] { paramAnonymousAdapterView.DeH, paramAnonymousAdapterView.DeI });
                paramAnonymousView = new ut();
                paramAnonymousView.dxt.userName = paramAnonymousAdapterView.DeH;
                paramAnonymousView.dxt.dxv = bs.bG(paramAnonymousAdapterView.DeI, "");
                paramAnonymousView.dxt.scene = 1060;
                paramAnonymousView.dxt.cYP = WalletOrderInfoOldUI.this.vsE;
                paramAnonymousView.dxt.dxw = 0;
                com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
                com.tencent.mm.plugin.report.service.h.wUl.f(14118, new Object[] { WalletOrderInfoOldUI.this.vsE, WalletOrderInfoOldUI.this.getPayReqKey(), Integer.valueOf(2) });
                WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this, new WalletOrderInfoOldUI.d(WalletOrderInfoOldUI.this, paramAnonymousAdapterView.BoC, paramAnonymousAdapterView.DeF, paramAnonymousAdapterView.Bxq, paramAnonymousAdapterView.Bxr, WalletOrderInfoOldUI.this.getPayReqKey(), WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this), paramAnonymousAdapterView.Bxs));
                WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this, true);
                AppMethodBeat.o(71054);
                return;
              }
              if (paramAnonymousAdapterView.DeE == 1)
              {
                WalletOrderInfoOldUI.this.a(paramAnonymousAdapterView);
                AppMethodBeat.o(71054);
                return;
              }
              if ((paramAnonymousAdapterView.DeE == 2) && (!bs.isNullOrNil(paramAnonymousAdapterView.url)))
              {
                if (WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this).containsKey(paramAnonymousAdapterView.BoC))
                {
                  paramAnonymousAdapterView = (WalletOrderInfoOldUI.b)WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this).get(paramAnonymousAdapterView.BoC);
                  ac.i("MicroMsg.WalletOrderInfoOldUI", "go to new url %s", new Object[] { paramAnonymousAdapterView.url });
                  WalletOrderInfoOldUI.this.Tw(paramAnonymousAdapterView.url);
                  AppMethodBeat.o(71054);
                  return;
                }
                WalletOrderInfoOldUI.this.BCC = paramAnonymousAdapterView.url;
                WalletOrderInfoOldUI.this.a(paramAnonymousAdapterView.url, new WalletOrderInfoOldUI.d(WalletOrderInfoOldUI.this, paramAnonymousAdapterView.BoC, paramAnonymousAdapterView.DeF, paramAnonymousAdapterView.Bxq, paramAnonymousAdapterView.Bxr, WalletOrderInfoOldUI.this.getPayReqKey(), WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this), paramAnonymousAdapterView.Bxs));
                AppMethodBeat.o(71054);
                return;
              }
              ac.e("MicroMsg.WalletOrderInfoOldUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
            }
            AppMethodBeat.o(71054);
          }
        });
        WalletOrderInfoOldUI.this.BHe.notifyDataSetChanged();
        paramViewGroup.BHv.setVisibility(0);
        paramViewGroup.BHu.setVisibility(0);
        label1096:
        if ((localCommodity.Byz == null) || (bs.isNullOrNil(localCommodity.Byz.AZE))) {
          break label1290;
        }
        paramViewGroup.BCI.setUrl(localCommodity.Byz.Bxv);
        paramViewGroup.BCJ.setText(localCommodity.Byz.Bxw);
        paramViewGroup.BCK.setText(localCommodity.Byz.BnG);
        paramViewGroup.BHC.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71055);
            paramAnonymousView = new ut();
            paramAnonymousView.dxt.userName = localCommodity.Byz.AZE;
            paramAnonymousView.dxt.dxv = bs.bG(localCommodity.Byz.AZF, "");
            paramAnonymousView.dxt.scene = 1034;
            paramAnonymousView.dxt.dxw = 0;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
            com.tencent.mm.plugin.report.service.h.wUl.f(14118, new Object[] { WalletOrderInfoOldUI.this.vsE, WalletOrderInfoOldUI.this.getPayReqKey(), Integer.valueOf(1) });
            AppMethodBeat.o(71055);
          }
        });
        paramViewGroup.BHB.setVisibility(0);
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
        paramViewGroup.BHA.setVisibility(8);
        paramViewGroup.BHz.setVisibility(8);
        break label888;
        label1239:
        paramViewGroup.BHx.setVisibility(8);
        paramViewGroup.BHy.setVisibility(8);
        break label935;
        label1260:
        paramViewGroup.BHv.setVisibility(8);
        paramViewGroup.BHC.setVisibility(8);
        paramViewGroup.BHu.setVisibility(8);
        break label1096;
        label1290:
        paramViewGroup.BHC.setVisibility(8);
        paramViewGroup.BHB.setVisibility(8);
      }
    }
    
    final class a
    {
      CdnImageView BCI;
      TextView BCJ;
      TextView BCK;
      TextView BHA;
      View BHB;
      ViewGroup BHC;
      TextView BHn;
      TextView BHo;
      TextView BHp;
      TextView BHq;
      TextView BHr;
      TextView BHs;
      TextView BHt;
      View BHu;
      MaxListView BHv;
      View BHw;
      TextView BHx;
      TextView BHy;
      TextView BHz;
      TextView ijE;
      
      a() {}
    }
  }
  
  final class b
  {
    public String BGR;
    public String dlQ;
    public String drM;
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
        this.dlQ = WalletOrderInfoOldUI.this.optString("wording");
        this.drM = WalletOrderInfoOldUI.this.optString("icon");
        this.BGR = WalletOrderInfoOldUI.this.optString("btn_text");
        this.title = WalletOrderInfoOldUI.this.optString("title");
      }
      AppMethodBeat.o(71060);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(71061);
      String str = this.url + " , " + this.dlQ + " , " + this.drM + " , " + this.BGR + " , " + this.title;
      AppMethodBeat.o(71061);
      return str;
    }
  }
  
  final class c
    extends BaseAdapter
  {
    protected List<Orders.Promotions> ByB;
    
    public c()
    {
      AppMethodBeat.i(71062);
      this.ByB = null;
      this.ByB = new ArrayList();
      Object localObject;
      int j = localObject.size();
      int i = 0;
      while (i < j)
      {
        this$1 = (Orders.Promotions)localObject.get(i);
        if ((WalletOrderInfoOldUI.this != null) && ((!bs.isNullOrNil(WalletOrderInfoOldUI.this.vxm)) || (WalletOrderInfoOldUI.this.DeE == 2) || (WalletOrderInfoOldUI.this.DeE == 1))) {
          this.ByB.add(localObject.get(i));
        }
        i += 1;
      }
      AppMethodBeat.o(71062);
    }
    
    public final Orders.Promotions TP(int paramInt)
    {
      AppMethodBeat.i(71064);
      Orders.Promotions localPromotions = (Orders.Promotions)this.ByB.get(paramInt);
      AppMethodBeat.o(71064);
      return localPromotions;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(71063);
      if (this.ByB != null)
      {
        int i = this.ByB.size();
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
      Orders.Promotions localPromotions = TP(paramInt);
      Object localObject;
      if ((bs.isNullOrNil(localPromotions.vxm)) && (localPromotions.BoC > 0L))
      {
        localObject = WalletOrderInfoOldUI.this.zv(localPromotions.BoC);
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
        String str = WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this);
        paramInt = localPromotions.DeE;
        paramViewGroup = (ViewGroup)localObject;
        if ("-1".equals(localObject)) {
          paramViewGroup = Integer.valueOf(5);
        }
        localh.f(13471, new Object[] { str, Integer.valueOf(1), Integer.valueOf(paramInt), paramViewGroup, Long.valueOf(localPromotions.BoC), Long.valueOf(localPromotions.Bxs) });
      }
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramViewGroup.type = localPromotions.type;
        if (localPromotions.type == Orders.Byr) {
          if (localPromotions.ByO == 1)
          {
            paramView = View.inflate(WalletOrderInfoOldUI.this, 2131495998, null);
            paramViewGroup.ojf = ((CdnImageView)paramView.findViewById(2131306787));
            paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131306802));
            paramViewGroup.BHD = ((TextView)paramView.findViewById(2131306774));
            paramViewGroup.fwQ = ((TextView)paramView.findViewById(2131306789));
            if (!TextUtils.isEmpty(localPromotions.url)) {
              WalletOrderInfoOldUI.this.BHd.put(localPromotions.url, paramViewGroup.BHD);
            }
            paramView.setTag(paramViewGroup);
            paramViewGroup.ByO = localPromotions.ByO;
          }
        }
      }
      label293:
      label1586:
      for (;;)
      {
        if (localPromotions != null)
        {
          localObject = (WalletOrderInfoOldUI.b)WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this).get(localPromotions.BoC);
          ac.i("MicroMsg.WalletOrderInfoOldUI", "try get result ".concat(String.valueOf(localObject)));
          if (localObject == null) {
            break label1306;
          }
          paramViewGroup.ojf.setUrl(((WalletOrderInfoOldUI.b)localObject).drM);
          paramViewGroup.fwQ.setText(((WalletOrderInfoOldUI.b)localObject).dlQ);
          paramViewGroup.BHD.setText(((WalletOrderInfoOldUI.b)localObject).BGR);
          if (bs.isNullOrNil(localPromotions.vxm)) {
            break label1356;
          }
          paramViewGroup.BHD.setVisibility(8);
          if (paramViewGroup.BHE != null)
          {
            paramViewGroup.BHE.setVisibility(0);
            if (!WalletOrderInfoOldUI.this.BGg.contains(localPromotions.vxm)) {
              break label1345;
            }
            paramViewGroup.BHE.setChecked(true);
          }
          label450:
          if ((paramViewGroup.titleTv == null) || (localObject == null) || (bs.isNullOrNil(((WalletOrderInfoOldUI.b)localObject).title))) {
            break label1383;
          }
          paramViewGroup.titleTv.setText(((WalletOrderInfoOldUI.b)localObject).title);
          label485:
          if ((!bs.isNullOrNil(WalletOrderInfoOldUI.this.BCC)) && (paramViewGroup.BHD != null))
          {
            paramViewGroup.BHD.setClickable(WalletOrderInfoOldUI.this.daw);
            paramViewGroup.BHD.setEnabled(WalletOrderInfoOldUI.this.daw);
            paramViewGroup.BHD.setOnClickListener(null);
            if (WalletOrderInfoOldUI.this.dax) {
              paramViewGroup.BHD.setVisibility(8);
            }
          }
          long l = localPromotions.BoC;
          localObject = WalletOrderInfoOldUI.this.zv(l);
          if (!((String)localObject).equals("0")) {
            break label1435;
          }
          paramViewGroup.BHD.setBackgroundColor(WalletOrderInfoOldUI.this.getResources().getColor(2131101053));
          paramViewGroup.BHD.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(2131101171));
        }
        for (;;)
        {
          if (paramViewGroup.BHD != null)
          {
            paramInt = BackwardSupportUtil.b.g(WalletOrderInfoOldUI.this.getContext(), 15.0F);
            i = BackwardSupportUtil.b.g(WalletOrderInfoOldUI.this.getContext(), 5.0F);
            paramViewGroup.BHD.setPadding(paramInt, i, paramInt, i);
          }
          AppMethodBeat.o(71065);
          return paramView;
          paramView = View.inflate(WalletOrderInfoOldUI.this, 2131495999, null);
          paramViewGroup.ojf = ((CdnImageView)paramView.findViewById(2131306787));
          paramViewGroup.BHD = ((TextView)paramView.findViewById(2131306774));
          paramViewGroup.fwQ = ((TextView)paramView.findViewById(2131306789));
          paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131306802));
          if (!TextUtils.isEmpty(localPromotions.url)) {
            WalletOrderInfoOldUI.this.BHd.put(localPromotions.url, paramViewGroup.BHD);
          }
          paramView.setTag(paramViewGroup);
          break;
          paramView = View.inflate(WalletOrderInfoOldUI.this, 2131496000, null);
          paramViewGroup.ojf = ((CdnImageView)paramView.findViewById(2131306787));
          paramViewGroup.BHD = ((TextView)paramView.findViewById(2131306774));
          paramViewGroup.fwQ = ((TextView)paramView.findViewById(2131306789));
          paramViewGroup.BHE = ((CheckBox)paramView.findViewById(2131296518));
          if (!TextUtils.isEmpty(localPromotions.url)) {
            WalletOrderInfoOldUI.this.BHd.put(localPromotions.url, paramViewGroup.BHD);
          }
          paramView.setTag(paramViewGroup);
          break label293;
          paramViewGroup = (a)paramView.getTag();
          int i = 0;
          paramInt = i;
          if (localPromotions.type == paramViewGroup.type) {
            if (localPromotions.type == Orders.Byr)
            {
              paramInt = i;
              if (localPromotions.ByO != paramViewGroup.ByO) {}
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
          if (localPromotions.type == Orders.Byr)
          {
            if (localPromotions.ByO == 1)
            {
              paramView = View.inflate(WalletOrderInfoOldUI.this, 2131495998, null);
              paramViewGroup.ojf = ((CdnImageView)paramView.findViewById(2131306787));
              paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131306802));
              paramViewGroup.BHD = ((TextView)paramView.findViewById(2131306774));
              paramViewGroup.fwQ = ((TextView)paramView.findViewById(2131306789));
              if (!TextUtils.isEmpty(localPromotions.url)) {
                WalletOrderInfoOldUI.this.BHd.put(localPromotions.url, paramViewGroup.BHD);
              }
              paramView.setTag(paramViewGroup);
            }
            for (;;)
            {
              paramViewGroup.ByO = localPromotions.ByO;
              break;
              paramView = View.inflate(WalletOrderInfoOldUI.this, 2131495999, null);
              paramViewGroup.ojf = ((CdnImageView)paramView.findViewById(2131306787));
              paramViewGroup.BHD = ((TextView)paramView.findViewById(2131306774));
              paramViewGroup.fwQ = ((TextView)paramView.findViewById(2131306789));
              paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131306802));
              if (!TextUtils.isEmpty(localPromotions.url)) {
                WalletOrderInfoOldUI.this.BHd.put(localPromotions.url, paramViewGroup.BHD);
              }
              paramView.setTag(paramViewGroup);
            }
          }
          paramView = View.inflate(WalletOrderInfoOldUI.this, 2131496000, null);
          paramViewGroup.ojf = ((CdnImageView)paramView.findViewById(2131306787));
          paramViewGroup.BHD = ((TextView)paramView.findViewById(2131306774));
          paramViewGroup.fwQ = ((TextView)paramView.findViewById(2131306789));
          paramViewGroup.BHE = ((CheckBox)paramView.findViewById(2131296518));
          if (!TextUtils.isEmpty(localPromotions.url)) {
            WalletOrderInfoOldUI.this.BHd.put(localPromotions.url, paramViewGroup.BHD);
          }
          paramView.setTag(paramViewGroup);
          break label293;
          paramViewGroup.ojf.setUrl(localPromotions.vFL);
          paramViewGroup.fwQ.setText(localPromotions.name);
          paramViewGroup.BHD.setText(localPromotions.Bxt);
          break label387;
          label1345:
          paramViewGroup.BHE.setChecked(false);
          break label450;
          label1356:
          paramViewGroup.BHD.setVisibility(0);
          if (paramViewGroup.BHE == null) {
            break label450;
          }
          paramViewGroup.BHE.setVisibility(8);
          break label450;
          label1383:
          if ((paramViewGroup.titleTv != null) && (!bs.isNullOrNil(localPromotions.title)))
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
            paramViewGroup.BHD.setBackgroundDrawable(WalletOrderInfoOldUI.this.getResources().getDrawable(2131231379));
            paramViewGroup.BHD.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(2131101171));
          }
          else if ((((String)localObject).equals("4")) || (((String)localObject).equals("2")) || (((String)localObject).equals("1")))
          {
            paramViewGroup.BHD.setBackgroundColor(WalletOrderInfoOldUI.this.getResources().getColor(2131101053));
            paramViewGroup.BHD.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(2131100490));
          }
          else
          {
            ac.e("MicroMsg.WalletOrderInfoOldUI", "PromotionsAdapter unknow award state");
          }
        }
      }
    }
    
    final class a
    {
      TextView BHD;
      CheckBox BHE;
      int ByO;
      TextView fwQ;
      CdnImageView ojf;
      TextView titleTv;
      int type;
      
      a() {}
    }
  }
  
  final class d
  {
    public String BGT;
    public String BGU;
    public String BGV;
    public String Bpb;
    public long Bzd;
    public String djr;
    public String wLA;
    
    public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong)
    {
      this.Bpb = paramString1;
      this.BGT = paramString2;
      this.BGU = paramString3;
      this.BGV = paramString4;
      this.djr = paramString5;
      this.wLA = paramString6;
      this.Bzd = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI
 * JD-Core Version:    0.7.0.1
 */