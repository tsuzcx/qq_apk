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
import com.tencent.mm.g.a.jx;
import com.tencent.mm.g.a.jx.a;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.wallet_core.c.ae;
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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
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
  protected boolean Aka;
  private HashMap<String, b> Akf;
  protected String Akg;
  protected Set<String> AnM;
  protected List<Orders.Commodity> AnN;
  protected LinearLayout AoE;
  protected TextView AoF;
  protected TextView AoG;
  protected a AoH;
  protected String AoI;
  protected HashMap<String, TextView> AoJ;
  protected c AoK;
  protected Map<Long, String> AoL;
  private d AoM;
  private boolean AoN;
  protected ar.b.a AoO;
  private View.OnLongClickListener AoP;
  private c Aoo;
  protected boolean dcY;
  protected boolean dcZ;
  protected boolean dda;
  protected String kGt;
  protected String mAppId;
  protected PayInfo mPayInfo;
  protected String ujI;
  private c umw;
  protected String upF;
  private String vGZ;
  protected Orders zPF;
  
  public WalletOrderInfoOldUI()
  {
    AppMethodBeat.i(71067);
    this.AoE = null;
    this.AoF = null;
    this.AoG = null;
    this.AnN = null;
    this.AoH = null;
    this.kGt = null;
    this.upF = null;
    this.Aka = false;
    this.AnM = null;
    this.mAppId = "";
    this.AoI = null;
    this.dcY = true;
    this.dcZ = false;
    this.dda = false;
    this.AoJ = new HashMap();
    this.AoL = new HashMap();
    this.Akf = new HashMap();
    this.AoN = false;
    this.umw = new c() {};
    this.AoO = new WalletOrderInfoOldUI.6(this);
    this.AoP = new WalletOrderInfoOldUI.11(this);
    this.Aoo = new WalletOrderInfoOldUI.3(this);
    AppMethodBeat.o(71067);
  }
  
  private void VL()
  {
    int j = 1;
    AppMethodBeat.i(71068);
    com.tencent.mm.wallet_core.d locald = com.tencent.mm.wallet_core.a.bo(this);
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.ujI = getInput().getString("key_trans_id");
    getInput().getInt("key_pay_type", -1);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoOldUI", "mTransId %s", new Object[] { this.ujI });
    this.zPF = eee();
    if (this.zPF != null)
    {
      setContentViewVisibility(0);
      d(this.zPF);
      int i;
      boolean bool1;
      if ((locald != null) && (this.zPF != null) && (this.mPayInfo != null))
      {
        this.mAppId = this.mPayInfo.appId;
        boolean bool2 = locald.fjs();
        f.a(this, getInput(), 7);
        if (getInput().getInt("key_support_bankcard", 1) == 2)
        {
          i = 2;
          com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
          int k = this.mPayInfo.dtb;
          if (this.mPayInfo.dtb != 3) {
            break label454;
          }
          bool1 = true;
          label189:
          if (!bool2) {
            break label460;
          }
          label194:
          localh.f(10691, new Object[] { Integer.valueOf(k), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(ab.fkb()), Integer.valueOf((int)(this.zPF.dcH * 100.0D)), this.zPF.uop, Integer.valueOf(i) });
        }
      }
      else
      {
        if (((!com.tencent.mm.plugin.wallet_core.model.s.ecc().ecF()) && (locald != null) && (locald.fjs())) || (!u.aqQ())) {
          u.aqR();
        }
        if ((this.zPF == null) || (this.zPF.Afx == null) || (this.zPF.Afx.size() <= 0)) {
          break label465;
        }
        this.AnN = this.zPF.Afx;
        this.ujI = ((Orders.Commodity)this.AnN.get(0)).dcF;
        if ((this.mPayInfo != null) && (locald != null) && ((locald.fjr()) || (locald.fjs()))) {
          doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(getPayReqKey(), 21));
        }
      }
      for (;;)
      {
        if (this.ujI != null) {
          break label532;
        }
        if (((com.tencent.mm.plugin.fingerprint.b.h)g.ab(com.tencent.mm.plugin.fingerprint.b.h.class)).h(this)) {
          this.AoN = false;
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
    this.AnM.clear();
    if ((paramOrders == null) || (paramOrders.Afx == null))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletOrderInfoOldUI", "hy: orders is null");
      AppMethodBeat.o(71075);
      return;
    }
    paramOrders = paramOrders.Afx.iterator();
    while (paramOrders.hasNext())
    {
      Orders.Commodity localCommodity = (Orders.Commodity)paramOrders.next();
      if ((localCommodity.Afn == 2) && (!bt.isNullOrNil(localCommodity.AfZ)))
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletOrderInfoOldUI", "hy: has username and is force recommend");
        this.AnM.add(localCommodity.AfZ);
      }
    }
    AppMethodBeat.o(71075);
  }
  
  private void edQ()
  {
    int i = 0;
    AppMethodBeat.i(71080);
    if (!this.Aka)
    {
      jx localjx = new jx();
      localjx.dob.requestCode = 4;
      jx.a locala = localjx.dob;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.bRZ = i;
      com.tencent.mm.sdk.b.a.ESL.l(localjx);
      this.Aka = true;
    }
    AppMethodBeat.o(71080);
  }
  
  private void eel()
  {
    AppMethodBeat.i(71077);
    if (this.zPF != null)
    {
      this.AnN = this.zPF.Afx;
      Iterator localIterator = this.AnN.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!"1".equals(((Orders.Commodity)localIterator.next()).uoi));
    }
    for (int i = 0;; i = 1)
    {
      this.AoE.setVisibility(0);
      this.AoF.setVisibility(0);
      if (i != 0)
      {
        if ((!bt.isNullOrNil(this.zPF.Afp)) && (!bt.isNullOrNil(this.zPF.Afp.trim())))
        {
          this.AoF.setText(this.zPF.Afp);
          AppMethodBeat.o(71077);
          return;
        }
        if (this.zPF.zWA != 1)
        {
          this.AoF.setText(2131765570);
          AppMethodBeat.o(71077);
          return;
        }
        this.AoF.setText(2131765569);
        AppMethodBeat.o(71077);
        return;
      }
      this.AoF.setText(2131765571);
      AppMethodBeat.o(71077);
      return;
    }
  }
  
  private void eem()
  {
    AppMethodBeat.i(71089);
    if ((this.zPF != null) && (this.zPF.Afx != null) && (this.zPF.Afx.size() > 0) && (((Orders.Commodity)this.zPF.Afx.get(0)).Agj != null) && (!bt.isNullOrNil(((Orders.Commodity)this.zPF.Afx.get(0)).Agj.text)) && (!bt.isNullOrNil(((Orders.Commodity)this.zPF.Afx.get(0)).Agj.url)))
    {
      this.AoG.setVisibility(0);
      this.AoG.setText(((Orders.Commodity)this.zPF.Afx.get(0)).Agj.text);
      this.AoG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71052);
          e.p(WalletOrderInfoOldUI.this, ((Orders.Commodity)WalletOrderInfoOldUI.this.zPF.Afx.get(0)).Agj.url, false);
          AppMethodBeat.o(71052);
        }
      });
      AppMethodBeat.o(71089);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoOldUI", "hy: no commodity or no link act or link act is illegal!");
    this.AoG.setVisibility(8);
    AppMethodBeat.o(71089);
  }
  
  protected final void Y(com.tencent.mm.storage.af paramaf)
  {
    AppMethodBeat.i(71081);
    if ((paramaf != null) && ((int)paramaf.fId != 0))
    {
      String str = paramaf.ZW();
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer nickName " + str + " username: " + paramaf.field_username);
      if ((this.AnN != null) && (this.AnN.size() > 0))
      {
        Iterator localIterator = this.AnN.iterator();
        while (localIterator.hasNext()) {
          ((Orders.Commodity)localIterator.next()).uoq = str;
        }
        this.AoH.notifyDataSetChanged();
      }
      this.kGt = paramaf.field_username;
    }
    AppMethodBeat.o(71081);
  }
  
  protected final void a(Orders.Promotions paramPromotions)
  {
    AppMethodBeat.i(71074);
    doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.s(paramPromotions, getPayReqKey(), this.ujI, paramPromotions.AeY));
    AppMethodBeat.o(71074);
  }
  
  protected final void a(String paramString, d paramd)
  {
    AppMethodBeat.i(71078);
    edQ();
    this.AoM = paramd;
    e.a(this, paramString, false, 1);
    this.AoN = false;
    AppMethodBeat.o(71078);
  }
  
  protected final void aur(String paramString)
  {
    AppMethodBeat.i(71079);
    edQ();
    e.p(this, paramString, false);
    this.AoN = false;
    AppMethodBeat.o(71079);
  }
  
  protected final void auu(String paramString)
  {
    AppMethodBeat.i(71072);
    doSceneProgress(new ae(paramString));
    AppMethodBeat.o(71072);
  }
  
  protected final boolean dkB()
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
            WalletOrderInfoOldUI.this.eek();
            AppMethodBeat.o(71050);
          }
        });
        getInput().remove("key_realname_guide_helper");
        if (!bool) {
          eek();
        }
      }
      AppMethodBeat.o(71083);
      return;
    }
    eek();
    AppMethodBeat.o(71083);
  }
  
  protected final void eN(String paramString, int paramInt)
  {
    AppMethodBeat.i(71073);
    doSceneProgress(new ae(paramString, paramInt));
    AppMethodBeat.o(71073);
  }
  
  protected Orders eee()
  {
    AppMethodBeat.i(71070);
    Orders localOrders = (Orders)getInput().getParcelable("key_orders");
    AppMethodBeat.o(71070);
    return localOrders;
  }
  
  public final void eek()
  {
    AppMethodBeat.i(71084);
    edQ();
    this.AoN = false;
    Object localObject1 = new com.tencent.mm.g.a.au();
    ((com.tencent.mm.g.a.au)localObject1).dcT.dcU = true;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("intent_pay_end_errcode", getInput().getInt("intent_pay_end_errcode"));
    ((Bundle)localObject2).putString("intent_pay_app_url", getInput().getString("intent_pay_app_url"));
    ((Bundle)localObject2).putBoolean("intent_pay_end", getInput().getBoolean("intent_pay_end"));
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoOldUI", "pay done...feedbackData errCode:" + getInput().getInt("intent_pay_end_errcode"));
    Iterator localIterator = this.AnM.iterator();
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (!bt.isNullOrNil(str1))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoOldUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str1 });
        if ((this.zPF == null) || (this.mPayInfo == null)) {
          break label339;
        }
        q localq = g.afA().gcy;
        String str2 = this.zPF.dcE;
        if (this.zPF.Afx.size() <= 0) {
          break label333;
        }
        localObject1 = ((Orders.Commodity)this.zPF.Afx.get(0)).dcF;
        label250:
        localq.a(new t(str1, str2, (String)localObject1, this.mPayInfo.dtb, this.mPayInfo.channel, this.zPF.Afn), 0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.vKh.f(13033, new Object[] { Integer.valueOf(2), str1, "", "", "" });
        break;
        label333:
        localObject1 = "";
        break label250;
        label339:
        g.afA().gcy.a(new t(str1), 0);
      }
    }
    com.tencent.mm.wallet_core.a.k(this, (Bundle)localObject2);
    if ((this.zPF != null) && (!bt.isNullOrNil(this.zPF.oYa))) {
      if (this.zPF.Afx.size() <= 0) {
        break label535;
      }
    }
    label535:
    for (localObject1 = ((Orders.Commodity)this.zPF.Afx.get(0)).dcF;; localObject1 = "")
    {
      localObject1 = e(this.zPF.oYa, this.zPF.dcE, (String)localObject1, this.mPayInfo.nrG, this.mPayInfo.iaz);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletOrderInfoOldUI", "url = ".concat(String.valueOf(localObject1)));
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
      ((Intent)localObject2).putExtra("showShare", false);
      ((Intent)localObject2).putExtra("geta8key_username", u.aqG());
      ((Intent)localObject2).putExtra("stastic_scene", 8);
      com.tencent.mm.bs.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject2);
      AppMethodBeat.o(71084);
      return;
    }
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
    if ((this.mPayInfo != null) && (this.mPayInfo.dtb == 2)) {
      if (!bt.isNullOrNil(this.mPayInfo.Axg)) {
        localObject = getString(2131755281) + this.mPayInfo.Axg;
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
      this.AoE = ((LinearLayout)findViewById(2131306794));
      this.AoF = ((TextView)findViewById(2131306793));
      this.AoG = ((TextView)findViewById(2131306786));
      localObject = (MaxListView)findViewById(2131306770);
      this.AoH = new a();
      ((MaxListView)localObject).setAdapter(this.AoH);
      eel();
      eem();
      ((ScrollView)findViewById(2131306834)).pageScroll(33);
      AppMethodBeat.o(71076);
      return;
      localObject = str;
      if (!bt.isNullOrNil(this.mPayInfo.appId))
      {
        localObject = str;
        if (!bt.isNullOrNil(com.tencent.mm.pluginsdk.model.app.h.s(this, this.mPayInfo.appId)))
        {
          localObject = getString(2131755281) + com.tencent.mm.pluginsdk.model.app.h.s(this, this.mPayInfo.appId);
          continue;
          localObject = str;
          if (this.zPF != null)
          {
            localObject = str;
            if (!bt.isNullOrNil(this.zPF.AfI)) {
              localObject = this.zPF.AfI;
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
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.af(this.AoM.zWH, this.AoM.Aoz, this.AoM.AoA, this.AoM.AoB, this.AoM.dlJ, this.AoM.vBv, this.AoM.AgJ));
    }
    AppMethodBeat.o(71088);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71069);
    super.onCreate(paramBundle);
    setContentViewVisibility(4);
    this.AnM = new HashSet();
    VL();
    initView();
    addSceneEndListener(1979);
    com.tencent.mm.sdk.b.a.ESL.c(this.Aoo);
    com.tencent.mm.sdk.b.a.ESL.c(this.umw);
    this.AoN = false;
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
    com.tencent.mm.sdk.b.a.ESL.d(this.Aoo);
    com.tencent.mm.sdk.b.a.ESL.d(this.umw);
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoOldUI", "onResume, isClickActivityTinyApp: %s", new Object[] { Boolean.valueOf(this.AoN) });
    if (this.AoN) {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.af(this.AoM.zWH, this.AoM.Aoz, this.AoM.AoA, this.AoM.AoB, this.AoM.dlJ, this.AoM.vBv, this.AoM.AgJ));
    }
    AppMethodBeat.o(71087);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71090);
    int i;
    if (((paramn instanceof com.tencent.mm.plugin.wallet_core.c.af)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.wallet_core.c.af localaf = (com.tencent.mm.plugin.wallet_core.c.af)paramn;
      b localb = new b(localaf.jwa);
      if ((!bt.isNullOrNil(localb.url)) && (!bt.isNullOrNil(localb.doh)))
      {
        i = 1;
        if (i != 0) {
          this.Akf.put(localaf.zWH, localb);
        }
        this.AoH.notifyDataSetChanged();
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
        this.zPF = ((ae)paramn).zWL;
        if (this.zPF != null) {
          this.AnN = this.zPF.Afx;
        }
        d(this.zPF);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + this.AnN);
        if ((this.AnN != null) && (this.AnN.size() != 0))
        {
          paramString = (Orders.Commodity)this.AnN.get(0);
          this.ujI = paramString.dcF;
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + paramString.toString());
          paramn = ((k)g.ab(k.class)).apM().aHY(paramString.uoq);
          if ((paramn == null) || ((int)paramn.fId == 0)) {
            break label334;
          }
          Y(paramn);
        }
      }
    }
    for (;;)
    {
      this.AoH.notifyDataSetChanged();
      eel();
      if (this.AoH != null) {
        this.AoH.notifyDataSetChanged();
      }
      eem();
      AppMethodBeat.o(71090);
      return true;
      i = 0;
      break;
      label334:
      ar.a.gMW.a(paramString.uoq, "", this.AoO);
    }
    label355:
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.s))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.wallet_core.c.s)paramn;
        paramn = paramString.zWp;
        long l = paramString.zWs.zWi;
        this.AoL.put(Long.valueOf(l), paramn);
        paramString.zWs.AeZ = paramString.foR;
        if ((!"-1".equals(paramn)) && (!"0".equals(paramn)) && (!bt.isNullOrNil(paramString.zWq))) {
          com.tencent.mm.ui.base.h.c(this, paramString.zWq, "", true);
        }
        while (!"0".equals(paramn))
        {
          this.AoH.notifyDataSetChanged();
          AppMethodBeat.o(71090);
          return true;
        }
        if (!bt.isNullOrNil(paramString.zWq)) {}
        for (paramString = paramString.zWq;; paramString = getString(2131765658))
        {
          Toast.makeText(this, paramString, 0).show();
          break;
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.s))
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
  
  public final String uS(long paramLong)
  {
    AppMethodBeat.i(71091);
    if (this.AoL.containsKey(Long.valueOf(paramLong)))
    {
      String str = (String)this.AoL.get(Long.valueOf(paramLong));
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
    
    private Orders.Commodity RF(int paramInt)
    {
      AppMethodBeat.i(71057);
      Orders.Commodity localCommodity = (Orders.Commodity)WalletOrderInfoOldUI.this.AnN.get(paramInt);
      AppMethodBeat.o(71057);
      return localCommodity;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(71056);
      if (WalletOrderInfoOldUI.this.AnN != null)
      {
        int i = WalletOrderInfoOldUI.this.AnN.size();
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
        paramViewGroup.AoT = ((TextView)paramView.findViewById(2131306772));
        paramViewGroup.hJe = ((TextView)paramView.findViewById(2131306777));
        paramViewGroup.AoW = ((TextView)paramView.findViewById(2131306798));
        paramViewGroup.AoU = ((TextView)paramView.findViewById(2131306804));
        paramViewGroup.AoV = ((TextView)paramView.findViewById(2131306790));
        paramViewGroup.AoV.getPaint().setFlags(16);
        paramViewGroup.AoX = ((TextView)paramView.findViewById(2131306805));
        paramViewGroup.AoY = ((TextView)paramView.findViewById(2131306775));
        paramViewGroup.AoZ = ((TextView)paramView.findViewById(2131306771));
        paramViewGroup.Apb = ((MaxListView)paramView.findViewById(2131306792));
        paramViewGroup.Apc = paramView.findViewById(2131306780);
        paramViewGroup.Apa = paramView.findViewById(2131306796);
        paramViewGroup.Ape = ((TextView)paramView.findViewById(2131306807));
        paramViewGroup.Apd = ((TextView)paramView.findViewById(2131306808));
        paramViewGroup.Apf = ((TextView)paramView.findViewById(2131306809));
        paramViewGroup.Apg = ((TextView)paramView.findViewById(2131306810));
        paramViewGroup.Api = ((ViewGroup)paramView.findViewById(2131306801));
        paramViewGroup.Akm = ((CdnImageView)paramView.findViewById(2131305857));
        paramViewGroup.Akn = ((TextView)paramView.findViewById(2131305853));
        paramViewGroup.Ako = ((TextView)paramView.findViewById(2131305858));
        paramViewGroup.Aph = paramView.findViewById(2131306797);
        paramView.setTag(paramViewGroup);
        localCommodity = RF(paramInt);
        if ((localCommodity == null) || (paramViewGroup == null)) {
          break label1188;
        }
        WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this, localCommodity.dcF);
        paramViewGroup.AoU.setText(e.d(localCommodity.nUf, localCommodity.uop));
        if ((localCommodity.AfY < 0.0D) || (localCommodity.nUf >= localCommodity.AfY)) {
          break label632;
        }
        paramViewGroup.AoV.setText(e.d(localCommodity.AfY, localCommodity.uop));
        paramViewGroup.AoV.setVisibility(0);
        localObject1 = (LinearLayout)paramViewGroup.Apc;
        localObject2 = localCommodity.Agb;
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
        if (localDiscountInfo.Agt <= 0.0D) {
          break label644;
        }
        localTextView.setText(localDiscountInfo.vzN + e.d(localDiscountInfo.Agt / 100.0D, WalletOrderInfoOldUI.this.zPF.uop));
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
        paramViewGroup.AoV.setVisibility(8);
        break label398;
        label644:
        localTextView.setText(localDiscountInfo.vzN);
      }
      label657:
      if (((LinearLayout)localObject1).getChildCount() > 0)
      {
        ((LinearLayout)localObject1).setVisibility(0);
        localObject2 = paramViewGroup.AoT;
        localObject1 = WalletOrderInfoOldUI.this;
        if (!u.aqV()) {
          break label1205;
        }
        localObject1 = ((Context)localObject1).getString(2131765564);
        label699:
        ((TextView)localObject2).setText((CharSequence)localObject1);
        paramViewGroup.AoW.setText(localCommodity.uoe);
        paramViewGroup.hJe.setText(localCommodity.desc);
        paramViewGroup.hJe.setTag(localCommodity.desc);
        paramViewGroup.hJe.setOnLongClickListener(WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this));
        paramViewGroup.hJe.setBackgroundResource(2131234695);
        paramViewGroup.AoX.setText(localCommodity.dcF);
        paramViewGroup.AoX.setTag(localCommodity.dcF);
        paramViewGroup.AoX.setOnLongClickListener(WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this));
        paramViewGroup.AoX.setBackgroundResource(2131234695);
        paramViewGroup.AoY.setText(e.nh(localCommodity.uol));
        paramViewGroup.AoZ.setText(localCommodity.uon);
        localObject1 = localCommodity.Agc;
        if (paramViewGroup.Apf != null)
        {
          if (bt.isNullOrNil((String)localObject1)) {
            break label1218;
          }
          paramViewGroup.Apf.setText((CharSequence)localObject1);
          paramViewGroup.Apf.setVisibility(0);
          paramViewGroup.Apg.setVisibility(0);
        }
        label888:
        localObject1 = localCommodity.Age;
        if (paramViewGroup.Ape != null)
        {
          if (bt.isNullOrNil((String)localObject1)) {
            break label1239;
          }
          paramViewGroup.Ape.setText((CharSequence)localObject1);
          paramViewGroup.Ape.setVisibility(0);
          paramViewGroup.Apd.setVisibility(0);
        }
        label935:
        if (localCommodity.Agh.size() <= 0) {
          break label1260;
        }
        localObject1 = (Orders.Promotions)localCommodity.Agh.get(0);
        com.tencent.mm.plugin.report.service.h.vKh.f(13033, new Object[] { Integer.valueOf(1), ((Orders.Promotions)localObject1).uoq, ((Orders.Promotions)localObject1).url, ((Orders.Promotions)localObject1).name, WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this) });
        WalletOrderInfoOldUI.this.AoK = new WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this, localCommodity.Agh);
        paramViewGroup.Apb.setAdapter(WalletOrderInfoOldUI.this.AoK);
        paramViewGroup.Apb.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(71054);
            paramAnonymousAdapterView = WalletOrderInfoOldUI.this.AoK.RG(paramAnonymousInt);
            if (!bt.isNullOrNil(paramAnonymousAdapterView.uoq))
            {
              if (WalletOrderInfoOldUI.this.AnM.contains(paramAnonymousAdapterView.uoq)) {
                WalletOrderInfoOldUI.this.AnM.remove(paramAnonymousAdapterView.uoq);
              }
              for (;;)
              {
                WalletOrderInfoOldUI.this.AoH.notifyDataSetChanged();
                AppMethodBeat.o(71054);
                return;
                WalletOrderInfoOldUI.this.AnM.add(paramAnonymousAdapterView.uoq);
              }
            }
            paramAnonymousView = WalletOrderInfoOldUI.this.uS(paramAnonymousAdapterView.zWi);
            if (("-1".equals(paramAnonymousView)) || ("3".equals(paramAnonymousView)))
            {
              com.tencent.mm.plugin.report.service.h.vKh.f(13472, new Object[] { WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this), Integer.valueOf(paramAnonymousAdapterView.LvT), Integer.valueOf(1), Long.valueOf(paramAnonymousAdapterView.zWi), Long.valueOf(paramAnonymousAdapterView.AeY) });
              com.tencent.mm.plugin.report.service.h.vKh.f(13033, new Object[] { Integer.valueOf(2), "", paramAnonymousAdapterView.url, paramAnonymousAdapterView.name, "" });
              if ((!bt.isNullOrNil(paramAnonymousAdapterView.LvW)) && (!bt.isNullOrNil(paramAnonymousAdapterView.LvX)))
              {
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoOldUI", "promotion jump tiny app, username: %s, path: %s", new Object[] { paramAnonymousAdapterView.LvW, paramAnonymousAdapterView.LvX });
                paramAnonymousView = new uj();
                paramAnonymousView.dzH.userName = paramAnonymousAdapterView.LvW;
                paramAnonymousView.dzH.dzJ = bt.by(paramAnonymousAdapterView.LvX, "");
                paramAnonymousView.dzH.scene = 1060;
                paramAnonymousView.dzH.dbt = WalletOrderInfoOldUI.this.ujI;
                paramAnonymousView.dzH.dzK = 0;
                com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
                com.tencent.mm.plugin.report.service.h.vKh.f(14118, new Object[] { WalletOrderInfoOldUI.this.ujI, WalletOrderInfoOldUI.this.getPayReqKey(), Integer.valueOf(2) });
                WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this, new WalletOrderInfoOldUI.d(WalletOrderInfoOldUI.this, paramAnonymousAdapterView.zWi, paramAnonymousAdapterView.LvU, paramAnonymousAdapterView.AeW, paramAnonymousAdapterView.AeX, WalletOrderInfoOldUI.this.getPayReqKey(), WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this), paramAnonymousAdapterView.AeY));
                WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this, true);
                AppMethodBeat.o(71054);
                return;
              }
              if (paramAnonymousAdapterView.LvT == 1)
              {
                WalletOrderInfoOldUI.this.a(paramAnonymousAdapterView);
                AppMethodBeat.o(71054);
                return;
              }
              if ((paramAnonymousAdapterView.LvT == 2) && (!bt.isNullOrNil(paramAnonymousAdapterView.url)))
              {
                if (WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this).containsKey(paramAnonymousAdapterView.zWi))
                {
                  paramAnonymousAdapterView = (WalletOrderInfoOldUI.b)WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this).get(paramAnonymousAdapterView.zWi);
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoOldUI", "go to new url %s", new Object[] { paramAnonymousAdapterView.url });
                  WalletOrderInfoOldUI.this.aur(paramAnonymousAdapterView.url);
                  AppMethodBeat.o(71054);
                  return;
                }
                WalletOrderInfoOldUI.this.Akg = paramAnonymousAdapterView.url;
                WalletOrderInfoOldUI.this.a(paramAnonymousAdapterView.url, new WalletOrderInfoOldUI.d(WalletOrderInfoOldUI.this, paramAnonymousAdapterView.zWi, paramAnonymousAdapterView.LvU, paramAnonymousAdapterView.AeW, paramAnonymousAdapterView.AeX, WalletOrderInfoOldUI.this.getPayReqKey(), WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this), paramAnonymousAdapterView.AeY));
                AppMethodBeat.o(71054);
                return;
              }
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOrderInfoOldUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
            }
            AppMethodBeat.o(71054);
          }
        });
        WalletOrderInfoOldUI.this.AoK.notifyDataSetChanged();
        paramViewGroup.Apb.setVisibility(0);
        paramViewGroup.Apa.setVisibility(0);
        label1096:
        if ((localCommodity.Agf == null) || (bt.isNullOrNil(localCommodity.Agf.zHs))) {
          break label1290;
        }
        paramViewGroup.Akm.setUrl(localCommodity.Agf.Afb);
        paramViewGroup.Akn.setText(localCommodity.Agf.Afc);
        paramViewGroup.Ako.setText(localCommodity.Agf.zVm);
        paramViewGroup.Api.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71055);
            paramAnonymousView = new uj();
            paramAnonymousView.dzH.userName = localCommodity.Agf.zHs;
            paramAnonymousView.dzH.dzJ = bt.by(localCommodity.Agf.zHt, "");
            paramAnonymousView.dzH.scene = 1034;
            paramAnonymousView.dzH.dzK = 0;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
            com.tencent.mm.plugin.report.service.h.vKh.f(14118, new Object[] { WalletOrderInfoOldUI.this.ujI, WalletOrderInfoOldUI.this.getPayReqKey(), Integer.valueOf(1) });
            AppMethodBeat.o(71055);
          }
        });
        paramViewGroup.Aph.setVisibility(0);
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
        paramViewGroup.Apg.setVisibility(8);
        paramViewGroup.Apf.setVisibility(8);
        break label888;
        label1239:
        paramViewGroup.Apd.setVisibility(8);
        paramViewGroup.Ape.setVisibility(8);
        break label935;
        label1260:
        paramViewGroup.Apb.setVisibility(8);
        paramViewGroup.Api.setVisibility(8);
        paramViewGroup.Apa.setVisibility(8);
        break label1096;
        label1290:
        paramViewGroup.Api.setVisibility(8);
        paramViewGroup.Aph.setVisibility(8);
      }
    }
    
    final class a
    {
      CdnImageView Akm;
      TextView Akn;
      TextView Ako;
      TextView AoT;
      TextView AoU;
      TextView AoV;
      TextView AoW;
      TextView AoX;
      TextView AoY;
      TextView AoZ;
      View Apa;
      MaxListView Apb;
      View Apc;
      TextView Apd;
      TextView Ape;
      TextView Apf;
      TextView Apg;
      View Aph;
      ViewGroup Api;
      TextView hJe;
      
      a() {}
    }
  }
  
  final class b
  {
    public String Aox;
    public String doh;
    public String dub;
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
        this.doh = WalletOrderInfoOldUI.this.optString("wording");
        this.dub = WalletOrderInfoOldUI.this.optString("icon");
        this.Aox = WalletOrderInfoOldUI.this.optString("btn_text");
        this.title = WalletOrderInfoOldUI.this.optString("title");
      }
      AppMethodBeat.o(71060);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(71061);
      String str = this.url + " , " + this.doh + " , " + this.dub + " , " + this.Aox + " , " + this.title;
      AppMethodBeat.o(71061);
      return str;
    }
  }
  
  final class c
    extends BaseAdapter
  {
    protected List<Orders.Promotions> Agh;
    
    public c()
    {
      AppMethodBeat.i(71062);
      this.Agh = null;
      this.Agh = new ArrayList();
      Object localObject;
      int j = localObject.size();
      int i = 0;
      while (i < j)
      {
        this$1 = (Orders.Promotions)localObject.get(i);
        if ((WalletOrderInfoOldUI.this != null) && ((!bt.isNullOrNil(WalletOrderInfoOldUI.this.uoq)) || (WalletOrderInfoOldUI.this.LvT == 2) || (WalletOrderInfoOldUI.this.LvT == 1))) {
          this.Agh.add(localObject.get(i));
        }
        i += 1;
      }
      AppMethodBeat.o(71062);
    }
    
    public final Orders.Promotions RG(int paramInt)
    {
      AppMethodBeat.i(71064);
      Orders.Promotions localPromotions = (Orders.Promotions)this.Agh.get(paramInt);
      AppMethodBeat.o(71064);
      return localPromotions;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(71063);
      if (this.Agh != null)
      {
        int i = this.Agh.size();
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
      Orders.Promotions localPromotions = RG(paramInt);
      Object localObject;
      if ((bt.isNullOrNil(localPromotions.uoq)) && (localPromotions.zWi > 0L))
      {
        localObject = WalletOrderInfoOldUI.this.uS(localPromotions.zWi);
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
        String str = WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this);
        paramInt = localPromotions.LvT;
        paramViewGroup = (ViewGroup)localObject;
        if ("-1".equals(localObject)) {
          paramViewGroup = Integer.valueOf(5);
        }
        localh.f(13471, new Object[] { str, Integer.valueOf(1), Integer.valueOf(paramInt), paramViewGroup, Long.valueOf(localPromotions.zWi), Long.valueOf(localPromotions.AeY) });
      }
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramViewGroup.type = localPromotions.type;
        if (localPromotions.type == Orders.AfX) {
          if (localPromotions.Agu == 1)
          {
            paramView = View.inflate(WalletOrderInfoOldUI.this, 2131495998, null);
            paramViewGroup.nGe = ((CdnImageView)paramView.findViewById(2131306787));
            paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131306802));
            paramViewGroup.Apj = ((TextView)paramView.findViewById(2131306774));
            paramViewGroup.ftj = ((TextView)paramView.findViewById(2131306789));
            if (!TextUtils.isEmpty(localPromotions.url)) {
              WalletOrderInfoOldUI.this.AoJ.put(localPromotions.url, paramViewGroup.Apj);
            }
            paramView.setTag(paramViewGroup);
            paramViewGroup.Agu = localPromotions.Agu;
          }
        }
      }
      label293:
      label1586:
      for (;;)
      {
        if (localPromotions != null)
        {
          localObject = (WalletOrderInfoOldUI.b)WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this).get(localPromotions.zWi);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOrderInfoOldUI", "try get result ".concat(String.valueOf(localObject)));
          if (localObject == null) {
            break label1306;
          }
          paramViewGroup.nGe.setUrl(((WalletOrderInfoOldUI.b)localObject).dub);
          paramViewGroup.ftj.setText(((WalletOrderInfoOldUI.b)localObject).doh);
          paramViewGroup.Apj.setText(((WalletOrderInfoOldUI.b)localObject).Aox);
          if (bt.isNullOrNil(localPromotions.uoq)) {
            break label1356;
          }
          paramViewGroup.Apj.setVisibility(8);
          if (paramViewGroup.Apk != null)
          {
            paramViewGroup.Apk.setVisibility(0);
            if (!WalletOrderInfoOldUI.this.AnM.contains(localPromotions.uoq)) {
              break label1345;
            }
            paramViewGroup.Apk.setChecked(true);
          }
          label450:
          if ((paramViewGroup.titleTv == null) || (localObject == null) || (bt.isNullOrNil(((WalletOrderInfoOldUI.b)localObject).title))) {
            break label1383;
          }
          paramViewGroup.titleTv.setText(((WalletOrderInfoOldUI.b)localObject).title);
          label485:
          if ((!bt.isNullOrNil(WalletOrderInfoOldUI.this.Akg)) && (paramViewGroup.Apj != null))
          {
            paramViewGroup.Apj.setClickable(WalletOrderInfoOldUI.this.dcY);
            paramViewGroup.Apj.setEnabled(WalletOrderInfoOldUI.this.dcY);
            paramViewGroup.Apj.setOnClickListener(null);
            if (WalletOrderInfoOldUI.this.dcZ) {
              paramViewGroup.Apj.setVisibility(8);
            }
          }
          long l = localPromotions.zWi;
          localObject = WalletOrderInfoOldUI.this.uS(l);
          if (!((String)localObject).equals("0")) {
            break label1435;
          }
          paramViewGroup.Apj.setBackgroundColor(WalletOrderInfoOldUI.this.getResources().getColor(2131101053));
          paramViewGroup.Apj.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(2131101171));
        }
        for (;;)
        {
          if (paramViewGroup.Apj != null)
          {
            paramInt = BackwardSupportUtil.b.g(WalletOrderInfoOldUI.this.getContext(), 15.0F);
            i = BackwardSupportUtil.b.g(WalletOrderInfoOldUI.this.getContext(), 5.0F);
            paramViewGroup.Apj.setPadding(paramInt, i, paramInt, i);
          }
          AppMethodBeat.o(71065);
          return paramView;
          paramView = View.inflate(WalletOrderInfoOldUI.this, 2131495999, null);
          paramViewGroup.nGe = ((CdnImageView)paramView.findViewById(2131306787));
          paramViewGroup.Apj = ((TextView)paramView.findViewById(2131306774));
          paramViewGroup.ftj = ((TextView)paramView.findViewById(2131306789));
          paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131306802));
          if (!TextUtils.isEmpty(localPromotions.url)) {
            WalletOrderInfoOldUI.this.AoJ.put(localPromotions.url, paramViewGroup.Apj);
          }
          paramView.setTag(paramViewGroup);
          break;
          paramView = View.inflate(WalletOrderInfoOldUI.this, 2131496000, null);
          paramViewGroup.nGe = ((CdnImageView)paramView.findViewById(2131306787));
          paramViewGroup.Apj = ((TextView)paramView.findViewById(2131306774));
          paramViewGroup.ftj = ((TextView)paramView.findViewById(2131306789));
          paramViewGroup.Apk = ((CheckBox)paramView.findViewById(2131296518));
          if (!TextUtils.isEmpty(localPromotions.url)) {
            WalletOrderInfoOldUI.this.AoJ.put(localPromotions.url, paramViewGroup.Apj);
          }
          paramView.setTag(paramViewGroup);
          break label293;
          paramViewGroup = (a)paramView.getTag();
          int i = 0;
          paramInt = i;
          if (localPromotions.type == paramViewGroup.type) {
            if (localPromotions.type == Orders.AfX)
            {
              paramInt = i;
              if (localPromotions.Agu != paramViewGroup.Agu) {}
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
          if (localPromotions.type == Orders.AfX)
          {
            if (localPromotions.Agu == 1)
            {
              paramView = View.inflate(WalletOrderInfoOldUI.this, 2131495998, null);
              paramViewGroup.nGe = ((CdnImageView)paramView.findViewById(2131306787));
              paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131306802));
              paramViewGroup.Apj = ((TextView)paramView.findViewById(2131306774));
              paramViewGroup.ftj = ((TextView)paramView.findViewById(2131306789));
              if (!TextUtils.isEmpty(localPromotions.url)) {
                WalletOrderInfoOldUI.this.AoJ.put(localPromotions.url, paramViewGroup.Apj);
              }
              paramView.setTag(paramViewGroup);
            }
            for (;;)
            {
              paramViewGroup.Agu = localPromotions.Agu;
              break;
              paramView = View.inflate(WalletOrderInfoOldUI.this, 2131495999, null);
              paramViewGroup.nGe = ((CdnImageView)paramView.findViewById(2131306787));
              paramViewGroup.Apj = ((TextView)paramView.findViewById(2131306774));
              paramViewGroup.ftj = ((TextView)paramView.findViewById(2131306789));
              paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131306802));
              if (!TextUtils.isEmpty(localPromotions.url)) {
                WalletOrderInfoOldUI.this.AoJ.put(localPromotions.url, paramViewGroup.Apj);
              }
              paramView.setTag(paramViewGroup);
            }
          }
          paramView = View.inflate(WalletOrderInfoOldUI.this, 2131496000, null);
          paramViewGroup.nGe = ((CdnImageView)paramView.findViewById(2131306787));
          paramViewGroup.Apj = ((TextView)paramView.findViewById(2131306774));
          paramViewGroup.ftj = ((TextView)paramView.findViewById(2131306789));
          paramViewGroup.Apk = ((CheckBox)paramView.findViewById(2131296518));
          if (!TextUtils.isEmpty(localPromotions.url)) {
            WalletOrderInfoOldUI.this.AoJ.put(localPromotions.url, paramViewGroup.Apj);
          }
          paramView.setTag(paramViewGroup);
          break label293;
          paramViewGroup.nGe.setUrl(localPromotions.uwS);
          paramViewGroup.ftj.setText(localPromotions.name);
          paramViewGroup.Apj.setText(localPromotions.AeZ);
          break label387;
          label1345:
          paramViewGroup.Apk.setChecked(false);
          break label450;
          label1356:
          paramViewGroup.Apj.setVisibility(0);
          if (paramViewGroup.Apk == null) {
            break label450;
          }
          paramViewGroup.Apk.setVisibility(8);
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
            paramViewGroup.Apj.setBackgroundDrawable(WalletOrderInfoOldUI.this.getResources().getDrawable(2131231379));
            paramViewGroup.Apj.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(2131101171));
          }
          else if ((((String)localObject).equals("4")) || (((String)localObject).equals("2")) || (((String)localObject).equals("1")))
          {
            paramViewGroup.Apj.setBackgroundColor(WalletOrderInfoOldUI.this.getResources().getColor(2131101053));
            paramViewGroup.Apj.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(2131100490));
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
      int Agu;
      TextView Apj;
      CheckBox Apk;
      TextView ftj;
      CdnImageView nGe;
      TextView titleTv;
      int type;
      
      a() {}
    }
  }
  
  final class d
  {
    public long AgJ;
    public String AoA;
    public String AoB;
    public String Aoz;
    public String dlJ;
    public String vBv;
    public String zWH;
    
    public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong)
    {
      this.zWH = paramString1;
      this.Aoz = paramString2;
      this.AoA = paramString3;
      this.AoB = paramString4;
      this.dlJ = paramString5;
      this.vBv = paramString6;
      this.AgJ = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI
 * JD-Core Version:    0.7.0.1
 */