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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.az;
import com.tencent.mm.g.a.ba;
import com.tencent.mm.g.a.le;
import com.tencent.mm.g.a.le.a;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.zx;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet_core.c.ad;
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
import com.tencent.mm.wallet_core.d;
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
  protected String AJn;
  private IListener AMo;
  protected String APz;
  private String Cvu;
  protected Orders HFH;
  protected boolean IdD;
  private HashMap<String, b> IdI;
  protected String IdJ;
  private IListener IhP;
  protected Set<String> Ihn;
  protected List<Orders.Commodity> Iho;
  protected LinearLayout Iif;
  protected TextView Iig;
  protected TextView Iih;
  protected a Iii;
  protected String Iij;
  protected HashMap<String, TextView> Iik;
  protected c Iil;
  protected Map<Long, String> Iim;
  private d Iin;
  private boolean Iio;
  protected ay.b.a Iip;
  private View.OnLongClickListener Iiq;
  protected boolean dEh;
  protected boolean dEi;
  protected boolean dEj;
  protected String mAppId;
  protected PayInfo mPayInfo;
  protected String mRa;
  
  public WalletOrderInfoOldUI()
  {
    AppMethodBeat.i(71067);
    this.Iif = null;
    this.Iig = null;
    this.Iih = null;
    this.Iho = null;
    this.Iii = null;
    this.mRa = null;
    this.APz = null;
    this.IdD = false;
    this.Ihn = null;
    this.mAppId = "";
    this.Iij = null;
    this.dEh = true;
    this.dEi = false;
    this.dEj = false;
    this.Iik = new HashMap();
    this.Iim = new HashMap();
    this.IdI = new HashMap();
    this.Iio = false;
    this.AMo = new IListener() {};
    this.Iip = new WalletOrderInfoOldUI.6(this);
    this.Iiq = new WalletOrderInfoOldUI.11(this);
    this.IhP = new IListener() {};
    AppMethodBeat.o(71067);
  }
  
  private void amZ()
  {
    int j = 1;
    AppMethodBeat.i(71068);
    d locald = com.tencent.mm.wallet_core.a.by(this);
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.AJn = getInput().getString("key_trans_id");
    getInput().getInt("key_pay_type", -1);
    Log.i("MicroMsg.WalletOrderInfoOldUI", "mTransId %s", new Object[] { this.AJn });
    this.HFH = fSS();
    if (this.HFH != null)
    {
      setContentViewVisibility(0);
      d(this.HFH);
      int i;
      boolean bool1;
      if ((locald != null) && (this.HFH != null) && (this.mPayInfo != null))
      {
        this.mAppId = this.mPayInfo.appId;
        boolean bool2 = locald.hgK();
        com.tencent.mm.plugin.wallet_core.utils.f.b(this, getInput(), 7);
        if (getInput().getInt("key_support_bankcard", 1) == 2)
        {
          i = 2;
          com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
          int k = this.mPayInfo.dVv;
          if (this.mPayInfo.dVv != 3) {
            break label454;
          }
          bool1 = true;
          label189:
          if (!bool2) {
            break label460;
          }
          label194:
          localh.a(10691, new Object[] { Integer.valueOf(k), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(ab.hhu()), Integer.valueOf((int)(this.HFH.dDO * 100.0D)), this.HFH.AOl, Integer.valueOf(i) });
        }
      }
      else
      {
        if (((!com.tencent.mm.plugin.wallet_core.model.t.fQI().fRk()) && (locald != null) && (locald.hgK())) || (!z.aUj())) {
          z.aUk();
        }
        if ((this.HFH == null) || (this.HFH.HZd == null) || (this.HFH.HZd.size() <= 0)) {
          break label465;
        }
        this.Iho = this.HFH.HZd;
        this.AJn = ((Orders.Commodity)this.Iho.get(0)).dDM;
        if ((this.mPayInfo != null) && (locald != null) && ((locald.hgJ()) || (locald.hgK()))) {
          doSceneProgress(new ad(getPayReqKey(), 21));
        }
      }
      for (;;)
      {
        if (this.AJn != null) {
          break label532;
        }
        if (((com.tencent.mm.plugin.fingerprint.b.h)g.af(com.tencent.mm.plugin.fingerprint.b.h.class)).i(this)) {
          this.Iio = false;
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
        com.tencent.mm.ui.base.h.a(getContext(), 2131767999, 0, new DialogInterface.OnClickListener()
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
    com.tencent.mm.ui.base.h.a(getContext(), 2131767999, 0, new DialogInterface.OnClickListener()
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
    this.Ihn.clear();
    if ((paramOrders == null) || (paramOrders.HZd == null))
    {
      Log.w("MicroMsg.WalletOrderInfoOldUI", "hy: orders is null");
      AppMethodBeat.o(71075);
      return;
    }
    paramOrders = paramOrders.HZd.iterator();
    while (paramOrders.hasNext())
    {
      Orders.Commodity localCommodity = (Orders.Commodity)paramOrders.next();
      if ((localCommodity.HYT == 2) && (!Util.isNullOrNil(localCommodity.HZF)))
      {
        Log.d("MicroMsg.WalletOrderInfoOldUI", "hy: has username and is force recommend");
        this.Ihn.add(localCommodity.HZF);
      }
    }
    AppMethodBeat.o(71075);
  }
  
  private void fSE()
  {
    int i = 0;
    AppMethodBeat.i(71080);
    if (!this.IdD)
    {
      le localle = new le();
      localle.dQr.requestCode = 4;
      le.a locala = localle.dQr;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.resultCode = i;
      EventCenter.instance.publish(localle);
      this.IdD = true;
    }
    AppMethodBeat.o(71080);
  }
  
  private void fSZ()
  {
    AppMethodBeat.i(71077);
    if (this.HFH != null)
    {
      this.Iho = this.HFH.HZd;
      Iterator localIterator = this.Iho.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!"1".equals(((Orders.Commodity)localIterator.next()).AOe));
    }
    for (int i = 0;; i = 1)
    {
      this.Iif.setVisibility(0);
      this.Iig.setVisibility(0);
      if (i != 0)
      {
        if ((!Util.isNullOrNil(this.HFH.HYV)) && (!Util.isNullOrNil(this.HFH.HYV.trim())))
        {
          this.Iig.setText(this.HFH.HYV);
          AppMethodBeat.o(71077);
          return;
        }
        if (this.HFH.HQg != 1)
        {
          this.Iig.setText(2131768019);
          AppMethodBeat.o(71077);
          return;
        }
        this.Iig.setText(2131768018);
        AppMethodBeat.o(71077);
        return;
      }
      this.Iig.setText(2131768020);
      AppMethodBeat.o(71077);
      return;
    }
  }
  
  private void fTa()
  {
    AppMethodBeat.i(71089);
    if ((this.HFH != null) && (this.HFH.HZd != null) && (this.HFH.HZd.size() > 0) && (((Orders.Commodity)this.HFH.HZd.get(0)).HZP != null) && (!Util.isNullOrNil(((Orders.Commodity)this.HFH.HZd.get(0)).HZP.text)) && (!Util.isNullOrNil(((Orders.Commodity)this.HFH.HZd.get(0)).HZP.url)))
    {
      this.Iih.setVisibility(0);
      this.Iih.setText(((Orders.Commodity)this.HFH.HZd.get(0)).HZP.text);
      this.Iih.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71052);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          com.tencent.mm.wallet_core.ui.f.p(WalletOrderInfoOldUI.this, ((Orders.Commodity)WalletOrderInfoOldUI.this.HFH.HZd.get(0)).HZP.url, false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71052);
        }
      });
      AppMethodBeat.o(71089);
      return;
    }
    Log.i("MicroMsg.WalletOrderInfoOldUI", "hy: no commodity or no link act or link act is illegal!");
    this.Iih.setVisibility(8);
    AppMethodBeat.o(71089);
  }
  
  public final String LT(long paramLong)
  {
    AppMethodBeat.i(71091);
    if (this.Iim.containsKey(Long.valueOf(paramLong)))
    {
      String str = (String)this.Iim.get(Long.valueOf(paramLong));
      AppMethodBeat.o(71091);
      return str;
    }
    AppMethodBeat.o(71091);
    return "-1";
  }
  
  protected final void a(Orders.Promotions paramPromotions)
  {
    AppMethodBeat.i(71074);
    doSceneForceProgress(new s(paramPromotions, getPayReqKey(), this.AJn, paramPromotions.HYE));
    AppMethodBeat.o(71074);
  }
  
  protected final void a(String paramString, d paramd)
  {
    AppMethodBeat.i(71078);
    fSE();
    this.Iin = paramd;
    com.tencent.mm.wallet_core.ui.f.a(this, paramString, false, 1);
    this.Iio = false;
    AppMethodBeat.o(71078);
  }
  
  protected final void aVQ(String paramString)
  {
    AppMethodBeat.i(71072);
    doSceneProgress(new ae(paramString));
    AppMethodBeat.o(71072);
  }
  
  protected final void ahM(String paramString)
  {
    AppMethodBeat.i(71079);
    fSE();
    com.tencent.mm.wallet_core.ui.f.p(this, paramString, false);
    this.Iio = false;
    AppMethodBeat.o(71079);
  }
  
  protected final void ai(as paramas)
  {
    AppMethodBeat.i(71081);
    if ((paramas != null) && ((int)paramas.gMZ != 0))
    {
      String str = paramas.arI();
      Log.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer nickName " + str + " username: " + paramas.field_username);
      if ((this.Iho != null) && (this.Iho.size() > 0))
      {
        Iterator localIterator = this.Iho.iterator();
        while (localIterator.hasNext()) {
          ((Orders.Commodity)localIterator.next()).dCu = str;
        }
        this.Iii.notifyDataSetChanged();
      }
      this.mRa = paramas.field_username;
    }
    AppMethodBeat.o(71081);
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
            WalletOrderInfoOldUI.this.fSY();
            AppMethodBeat.o(71050);
          }
        });
        getInput().remove("key_realname_guide_helper");
        if (!bool) {
          fSY();
        }
      }
      AppMethodBeat.o(71083);
      return;
    }
    fSY();
    AppMethodBeat.o(71083);
  }
  
  protected final boolean eOn()
  {
    return false;
  }
  
  protected Orders fSS()
  {
    AppMethodBeat.i(71070);
    Orders localOrders = (Orders)getInput().getParcelable("key_orders");
    AppMethodBeat.o(71070);
    return localOrders;
  }
  
  public final void fSY()
  {
    AppMethodBeat.i(71084);
    fSE();
    this.Iio = false;
    Object localObject1 = new az();
    ((az)localObject1).dEc.dEd = true;
    EventCenter.instance.publish((IEvent)localObject1);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("intent_pay_end_errcode", getInput().getInt("intent_pay_end_errcode"));
    ((Bundle)localObject2).putString("intent_pay_app_url", getInput().getString("intent_pay_app_url"));
    ((Bundle)localObject2).putBoolean("intent_pay_end", getInput().getBoolean("intent_pay_end"));
    Log.i("MicroMsg.WalletOrderInfoOldUI", "pay done...feedbackData errCode:" + getInput().getInt("intent_pay_end_errcode"));
    Iterator localIterator = this.Ihn.iterator();
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (!Util.isNullOrNil(str1))
      {
        Log.i("MicroMsg.WalletOrderInfoOldUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str1 });
        if ((this.HFH == null) || (this.mPayInfo == null)) {
          break label339;
        }
        com.tencent.mm.ak.t localt = g.aAg().hqi;
        String str2 = this.HFH.dDL;
        if (this.HFH.HZd.size() <= 0) {
          break label333;
        }
        localObject1 = ((Orders.Commodity)this.HFH.HZd.get(0)).dDM;
        label250:
        localt.a(new com.tencent.mm.wallet_core.c.t(str1, str2, (String)localObject1, this.mPayInfo.dVv, this.mPayInfo.channel, this.HFH.HYT), 0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(13033, new Object[] { Integer.valueOf(2), str1, "", "", "" });
        break;
        label333:
        localObject1 = "";
        break label250;
        label339:
        g.aAg().hqi.a(new com.tencent.mm.wallet_core.c.t(str1), 0);
      }
    }
    com.tencent.mm.wallet_core.a.l(this, (Bundle)localObject2);
    if ((this.HFH != null) && (!Util.isNullOrNil(this.HFH.rCq))) {
      if (this.HFH.HZd.size() <= 0) {
        break label535;
      }
    }
    label535:
    for (localObject1 = ((Orders.Commodity)this.HFH.HZd.get(0)).dDM;; localObject1 = "")
    {
      localObject1 = i(this.HFH.rCq, this.HFH.dDL, (String)localObject1, this.mPayInfo.pSm, this.mPayInfo.remark);
      Log.d("MicroMsg.WalletOrderInfoOldUI", "url = ".concat(String.valueOf(localObject1)));
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
      ((Intent)localObject2).putExtra("showShare", false);
      ((Intent)localObject2).putExtra("geta8key_username", z.aTY());
      ((Intent)localObject2).putExtra("stastic_scene", 8);
      com.tencent.mm.br.c.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject2);
      AppMethodBeat.o(71084);
      return;
    }
  }
  
  protected final void ga(String paramString, int paramInt)
  {
    AppMethodBeat.i(71073);
    doSceneProgress(new ae(paramString, paramInt));
    AppMethodBeat.o(71073);
  }
  
  public int getLayoutId()
  {
    return 2131496976;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71076);
    setMMTitle(2131768033);
    showHomeBtn(false);
    enableBackMenu(false);
    String str = getString(2131755858);
    Object localObject;
    if ((this.mPayInfo != null) && (this.mPayInfo.dVv == 2)) {
      if (!Util.isNullOrNil(this.mPayInfo.IqM)) {
        localObject = getString(2131755316) + this.mPayInfo.IqM;
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
      this.Iif = ((LinearLayout)findViewById(2131310255));
      this.Iig = ((TextView)findViewById(2131310254));
      this.Iih = ((TextView)findViewById(2131310247));
      localObject = (MaxListView)findViewById(2131310231);
      this.Iii = new a();
      ((MaxListView)localObject).setAdapter(this.Iii);
      fSZ();
      fTa();
      ((ScrollView)findViewById(2131310296)).pageScroll(33);
      AppMethodBeat.o(71076);
      return;
      localObject = str;
      if (!Util.isNullOrNil(this.mPayInfo.appId))
      {
        localObject = str;
        if (!Util.isNullOrNil(com.tencent.mm.pluginsdk.model.app.h.r(this, this.mPayInfo.appId)))
        {
          localObject = getString(2131755316) + com.tencent.mm.pluginsdk.model.app.h.r(this, this.mPayInfo.appId);
          continue;
          localObject = str;
          if (this.HFH != null)
          {
            localObject = str;
            if (!Util.isNullOrNil(this.HFH.HZo)) {
              localObject = this.HFH.HZo;
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
      doSceneProgress(new af(this.Iin.HQn, this.Iin.Iia, this.Iin.Iib, this.Iin.Iic, this.Iin.dNQ, this.Iin.CpP, this.Iin.Ian));
    }
    AppMethodBeat.o(71088);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71069);
    super.onCreate(paramBundle);
    setContentViewVisibility(4);
    this.Ihn = new HashSet();
    amZ();
    initView();
    addSceneEndListener(1979);
    EventCenter.instance.addListener(this.IhP);
    EventCenter.instance.addListener(this.AMo);
    this.Iio = false;
    AppMethodBeat.o(71069);
  }
  
  @Deprecated
  public Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(71086);
    Dialog localDialog = com.tencent.mm.ui.base.h.a(getContext(), getString(2131768014), getResources().getStringArray(2130903100), "", new WalletOrderInfoOldUI.9(this));
    AppMethodBeat.o(71086);
    return localDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71082);
    super.onDestroy();
    EventCenter.instance.removeListener(this.IhP);
    EventCenter.instance.removeListener(this.AMo);
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
    Log.i("MicroMsg.WalletOrderInfoOldUI", "onResume, isClickActivityTinyApp: %s", new Object[] { Boolean.valueOf(this.Iio) });
    if (this.Iio) {
      doSceneProgress(new af(this.Iin.HQn, this.Iin.Iia, this.Iin.Iib, this.Iin.Iic, this.Iin.dNQ, this.Iin.CpP, this.Iin.Ian));
    }
    AppMethodBeat.o(71087);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(71090);
    int i;
    if (((paramq instanceof af)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      af localaf = (af)paramq;
      b localb = new b(localaf.lxS);
      if ((!Util.isNullOrNil(localb.url)) && (!Util.isNullOrNil(localb.dQx)))
      {
        i = 1;
        if (i != 0) {
          this.IdI.put(localaf.HQn, localb);
        }
        this.Iii.notifyDataSetChanged();
      }
    }
    else
    {
      if (!(paramq instanceof ae)) {
        break label355;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        setContentViewVisibility(0);
        this.HFH = ((ae)paramq).HQs;
        if (this.HFH != null) {
          this.Iho = this.HFH.HZd;
        }
        d(this.HFH);
        Log.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + this.Iho);
        if ((this.Iho != null) && (this.Iho.size() != 0))
        {
          paramString = (Orders.Commodity)this.Iho.get(0);
          this.AJn = paramString.dDM;
          Log.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + paramString.toString());
          paramq = ((l)g.af(l.class)).aSN().Kn(paramString.dCu);
          if ((paramq == null) || ((int)paramq.gMZ == 0)) {
            break label334;
          }
          ai(paramq);
        }
      }
    }
    for (;;)
    {
      this.Iii.notifyDataSetChanged();
      fSZ();
      if (this.Iii != null) {
        this.Iii.notifyDataSetChanged();
      }
      fTa();
      AppMethodBeat.o(71090);
      return true;
      i = 0;
      break;
      label334:
      ay.a.iDq.a(paramString.dCu, "", this.Iip);
    }
    label355:
    if ((paramq instanceof s))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (s)paramq;
        paramq = paramString.HPV;
        long l = paramString.HPY.crw;
        this.Iim.put(Long.valueOf(l), paramq);
        paramString.HPY.HYF = paramString.resultMsg;
        if ((!"-1".equals(paramq)) && (!"0".equals(paramq)) && (!Util.isNullOrNil(paramString.HPW))) {
          com.tencent.mm.ui.base.h.c(this, paramString.HPW, "", true);
        }
        while (!"0".equals(paramq))
        {
          this.Iii.notifyDataSetChanged();
          AppMethodBeat.o(71090);
          return true;
        }
        if (!Util.isNullOrNil(paramString.HPW)) {}
        for (paramString = paramString.HPW;; paramString = getString(2131768111))
        {
          Toast.makeText(this, paramString, 0).show();
          break;
        }
      }
      if ((paramq instanceof s))
      {
        paramq = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramq = getString(2131768354);
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
    
    private Orders.Commodity aeT(int paramInt)
    {
      AppMethodBeat.i(71057);
      Orders.Commodity localCommodity = (Orders.Commodity)WalletOrderInfoOldUI.this.Iho.get(paramInt);
      AppMethodBeat.o(71057);
      return localCommodity;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(71056);
      if (WalletOrderInfoOldUI.this.Iho != null)
      {
        int i = WalletOrderInfoOldUI.this.Iho.size();
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
        paramView = View.inflate(WalletOrderInfoOldUI.this, 2131496977, null);
        paramViewGroup = new a();
        paramViewGroup.Iiu = ((TextView)paramView.findViewById(2131310233));
        paramViewGroup.jBR = ((TextView)paramView.findViewById(2131310238));
        paramViewGroup.Iix = ((TextView)paramView.findViewById(2131310259));
        paramViewGroup.Iiv = ((TextView)paramView.findViewById(2131310265));
        paramViewGroup.Iiw = ((TextView)paramView.findViewById(2131310251));
        paramViewGroup.Iiw.getPaint().setFlags(16);
        paramViewGroup.Iiy = ((TextView)paramView.findViewById(2131310266));
        paramViewGroup.Iiz = ((TextView)paramView.findViewById(2131310236));
        paramViewGroup.IiA = ((TextView)paramView.findViewById(2131310232));
        paramViewGroup.IiC = ((MaxListView)paramView.findViewById(2131310253));
        paramViewGroup.IiD = paramView.findViewById(2131310241);
        paramViewGroup.IiB = paramView.findViewById(2131310257);
        paramViewGroup.IiF = ((TextView)paramView.findViewById(2131310268));
        paramViewGroup.IiE = ((TextView)paramView.findViewById(2131310269));
        paramViewGroup.IiG = ((TextView)paramView.findViewById(2131310270));
        paramViewGroup.IiH = ((TextView)paramView.findViewById(2131310271));
        paramViewGroup.IiJ = ((ViewGroup)paramView.findViewById(2131310262));
        paramViewGroup.IdP = ((CdnImageView)paramView.findViewById(2131309136));
        paramViewGroup.IdQ = ((TextView)paramView.findViewById(2131309132));
        paramViewGroup.IdR = ((TextView)paramView.findViewById(2131309137));
        paramViewGroup.IiI = paramView.findViewById(2131310258);
        paramView.setTag(paramViewGroup);
        localCommodity = aeT(paramInt);
        if ((localCommodity == null) || (paramViewGroup == null)) {
          break label1188;
        }
        WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this, localCommodity.dDM);
        paramViewGroup.Iiv.setText(com.tencent.mm.wallet_core.ui.f.d(localCommodity.qwJ, localCommodity.AOl));
        if ((localCommodity.HZE < 0.0D) || (localCommodity.qwJ >= localCommodity.HZE)) {
          break label632;
        }
        paramViewGroup.Iiw.setText(com.tencent.mm.wallet_core.ui.f.d(localCommodity.HZE, localCommodity.AOl));
        paramViewGroup.Iiw.setVisibility(0);
        localObject1 = (LinearLayout)paramViewGroup.IiD;
        localObject2 = localCommodity.HZH;
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
        localLayoutParams.bottomMargin = WalletOrderInfoOldUI.this.getContext().getResources().getDimensionPixelOffset(2131165190);
        localTextView.setLayoutParams(localLayoutParams);
        localTextView.setTextAppearance(WalletOrderInfoOldUI.this.getContext(), 2131821194);
        if (localDiscountInfo.HZY <= 0.0D) {
          break label644;
        }
        localTextView.setText(localDiscountInfo.Coh + com.tencent.mm.wallet_core.ui.f.d(localDiscountInfo.HZY / 100.0D, WalletOrderInfoOldUI.this.HFH.AOl));
      }
      for (;;)
      {
        ((LinearLayout)localObject1).addView(localTextView);
        localTextView.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(2131101349));
        paramInt += 1;
        break label436;
        paramViewGroup = (a)paramView.getTag();
        break;
        label632:
        paramViewGroup.Iiw.setVisibility(8);
        break label398;
        label644:
        localTextView.setText(localDiscountInfo.Coh);
      }
      label657:
      if (((LinearLayout)localObject1).getChildCount() > 0)
      {
        ((LinearLayout)localObject1).setVisibility(0);
        localObject2 = paramViewGroup.Iiu;
        localObject1 = WalletOrderInfoOldUI.this;
        if (!z.aUo()) {
          break label1205;
        }
        localObject1 = ((Context)localObject1).getString(2131768013);
        label699:
        ((TextView)localObject2).setText((CharSequence)localObject1);
        paramViewGroup.Iix.setText(localCommodity.AOa);
        paramViewGroup.jBR.setText(localCommodity.desc);
        paramViewGroup.jBR.setTag(localCommodity.desc);
        paramViewGroup.jBR.setOnLongClickListener(WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this));
        paramViewGroup.jBR.setBackgroundResource(2131235657);
        paramViewGroup.Iiy.setText(localCommodity.dDM);
        paramViewGroup.Iiy.setTag(localCommodity.dDM);
        paramViewGroup.Iiy.setOnLongClickListener(WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this));
        paramViewGroup.Iiy.setBackgroundResource(2131235657);
        paramViewGroup.Iiz.setText(com.tencent.mm.wallet_core.ui.f.rZ(localCommodity.AOh));
        paramViewGroup.IiA.setText(localCommodity.AOj);
        localObject1 = localCommodity.HZI;
        if (paramViewGroup.IiG != null)
        {
          if (Util.isNullOrNil((String)localObject1)) {
            break label1218;
          }
          paramViewGroup.IiG.setText((CharSequence)localObject1);
          paramViewGroup.IiG.setVisibility(0);
          paramViewGroup.IiH.setVisibility(0);
        }
        label888:
        localObject1 = localCommodity.HZK;
        if (paramViewGroup.IiF != null)
        {
          if (Util.isNullOrNil((String)localObject1)) {
            break label1239;
          }
          paramViewGroup.IiF.setText((CharSequence)localObject1);
          paramViewGroup.IiF.setVisibility(0);
          paramViewGroup.IiE.setVisibility(0);
        }
        label935:
        if (localCommodity.HZN.size() <= 0) {
          break label1260;
        }
        localObject1 = (Orders.Promotions)localCommodity.HZN.get(0);
        com.tencent.mm.plugin.report.service.h.CyF.a(13033, new Object[] { Integer.valueOf(1), ((Orders.Promotions)localObject1).dCu, ((Orders.Promotions)localObject1).url, ((Orders.Promotions)localObject1).name, WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this) });
        WalletOrderInfoOldUI.this.Iil = new WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this, localCommodity.HZN);
        paramViewGroup.IiC.setAdapter(WalletOrderInfoOldUI.this.Iil);
        paramViewGroup.IiC.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(71054);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousAdapterView);
            localb.bm(paramAnonymousView);
            localb.pH(paramAnonymousInt);
            localb.zo(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
            paramAnonymousAdapterView = WalletOrderInfoOldUI.this.Iil.aeU(paramAnonymousInt);
            if (!Util.isNullOrNil(paramAnonymousAdapterView.dCu)) {
              if (WalletOrderInfoOldUI.this.Ihn.contains(paramAnonymousAdapterView.dCu))
              {
                WalletOrderInfoOldUI.this.Ihn.remove(paramAnonymousAdapterView.dCu);
                WalletOrderInfoOldUI.this.Iii.notifyDataSetChanged();
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(71054);
              return;
              WalletOrderInfoOldUI.this.Ihn.add(paramAnonymousAdapterView.dCu);
              break;
              paramAnonymousView = WalletOrderInfoOldUI.this.LT(paramAnonymousAdapterView.crw);
              if (("-1".equals(paramAnonymousView)) || ("3".equals(paramAnonymousView)))
              {
                com.tencent.mm.plugin.report.service.h.CyF.a(13472, new Object[] { WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this), Integer.valueOf(paramAnonymousAdapterView.Utv), Integer.valueOf(1), Long.valueOf(paramAnonymousAdapterView.crw), Long.valueOf(paramAnonymousAdapterView.HYE) });
                com.tencent.mm.plugin.report.service.h.CyF.a(13033, new Object[] { Integer.valueOf(2), "", paramAnonymousAdapterView.url, paramAnonymousAdapterView.name, "" });
                if ((!Util.isNullOrNil(paramAnonymousAdapterView.Uty)) && (!Util.isNullOrNil(paramAnonymousAdapterView.Utz)))
                {
                  Log.i("MicroMsg.WalletOrderInfoOldUI", "promotion jump tiny app, username: %s, path: %s", new Object[] { paramAnonymousAdapterView.Uty, paramAnonymousAdapterView.Utz });
                  paramAnonymousView = new wq();
                  paramAnonymousView.ecI.userName = paramAnonymousAdapterView.Uty;
                  paramAnonymousView.ecI.ecK = Util.nullAs(paramAnonymousAdapterView.Utz, "");
                  paramAnonymousView.ecI.scene = 1060;
                  paramAnonymousView.ecI.dCw = WalletOrderInfoOldUI.this.AJn;
                  paramAnonymousView.ecI.ecL = 0;
                  EventCenter.instance.publish(paramAnonymousView);
                  com.tencent.mm.plugin.report.service.h.CyF.a(14118, new Object[] { WalletOrderInfoOldUI.this.AJn, WalletOrderInfoOldUI.this.getPayReqKey(), Integer.valueOf(2) });
                  WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this, new WalletOrderInfoOldUI.d(WalletOrderInfoOldUI.this, paramAnonymousAdapterView.crw, paramAnonymousAdapterView.Utw, paramAnonymousAdapterView.HYC, paramAnonymousAdapterView.HYD, WalletOrderInfoOldUI.this.getPayReqKey(), WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this), paramAnonymousAdapterView.HYE));
                  WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this, true);
                }
                else if (paramAnonymousAdapterView.Utv == 1)
                {
                  WalletOrderInfoOldUI.this.a(paramAnonymousAdapterView);
                }
                else if ((paramAnonymousAdapterView.Utv == 2) && (!Util.isNullOrNil(paramAnonymousAdapterView.url)))
                {
                  if (WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this).containsKey(paramAnonymousAdapterView.crw))
                  {
                    paramAnonymousAdapterView = (WalletOrderInfoOldUI.b)WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this).get(paramAnonymousAdapterView.crw);
                    Log.i("MicroMsg.WalletOrderInfoOldUI", "go to new url %s", new Object[] { paramAnonymousAdapterView.url });
                    WalletOrderInfoOldUI.this.ahM(paramAnonymousAdapterView.url);
                  }
                  else
                  {
                    WalletOrderInfoOldUI.this.IdJ = paramAnonymousAdapterView.url;
                    WalletOrderInfoOldUI.this.a(paramAnonymousAdapterView.url, new WalletOrderInfoOldUI.d(WalletOrderInfoOldUI.this, paramAnonymousAdapterView.crw, paramAnonymousAdapterView.Utw, paramAnonymousAdapterView.HYC, paramAnonymousAdapterView.HYD, WalletOrderInfoOldUI.this.getPayReqKey(), WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this), paramAnonymousAdapterView.HYE));
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
        WalletOrderInfoOldUI.this.Iil.notifyDataSetChanged();
        paramViewGroup.IiC.setVisibility(0);
        paramViewGroup.IiB.setVisibility(0);
        label1096:
        if ((localCommodity.HZL == null) || (Util.isNullOrNil(localCommodity.HZL.Hwr))) {
          break label1290;
        }
        paramViewGroup.IdP.setUrl(localCommodity.HZL.HYH);
        paramViewGroup.IdQ.setText(localCommodity.HZL.HYI);
        paramViewGroup.IdR.setText(localCommodity.HZL.HLz);
        paramViewGroup.IiJ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71055);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            paramAnonymousView = new wq();
            paramAnonymousView.ecI.userName = localCommodity.HZL.Hwr;
            paramAnonymousView.ecI.ecK = Util.nullAs(localCommodity.HZL.Hws, "");
            paramAnonymousView.ecI.scene = 1034;
            paramAnonymousView.ecI.ecL = 0;
            EventCenter.instance.publish(paramAnonymousView);
            com.tencent.mm.plugin.report.service.h.CyF.a(14118, new Object[] { WalletOrderInfoOldUI.this.AJn, WalletOrderInfoOldUI.this.getPayReqKey(), Integer.valueOf(1) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71055);
          }
        });
        paramViewGroup.IiI.setVisibility(0);
      }
      for (;;)
      {
        label1188:
        AppMethodBeat.o(71058);
        return paramView;
        ((LinearLayout)localObject1).setVisibility(8);
        break;
        label1205:
        localObject1 = ((Context)localObject1).getString(2131768012);
        break label699;
        label1218:
        paramViewGroup.IiH.setVisibility(8);
        paramViewGroup.IiG.setVisibility(8);
        break label888;
        label1239:
        paramViewGroup.IiE.setVisibility(8);
        paramViewGroup.IiF.setVisibility(8);
        break label935;
        label1260:
        paramViewGroup.IiC.setVisibility(8);
        paramViewGroup.IiJ.setVisibility(8);
        paramViewGroup.IiB.setVisibility(8);
        break label1096;
        label1290:
        paramViewGroup.IiJ.setVisibility(8);
        paramViewGroup.IiI.setVisibility(8);
      }
    }
    
    final class a
    {
      CdnImageView IdP;
      TextView IdQ;
      TextView IdR;
      TextView IiA;
      View IiB;
      MaxListView IiC;
      View IiD;
      TextView IiE;
      TextView IiF;
      TextView IiG;
      TextView IiH;
      View IiI;
      ViewGroup IiJ;
      TextView Iiu;
      TextView Iiv;
      TextView Iiw;
      TextView Iix;
      TextView Iiy;
      TextView Iiz;
      TextView jBR;
      
      a() {}
    }
  }
  
  final class b
  {
    public String IhY;
    public String dQx;
    public String icon;
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
        this.dQx = WalletOrderInfoOldUI.this.optString("wording");
        this.icon = WalletOrderInfoOldUI.this.optString("icon");
        this.IhY = WalletOrderInfoOldUI.this.optString("btn_text");
        this.title = WalletOrderInfoOldUI.this.optString("title");
      }
      AppMethodBeat.o(71060);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(71061);
      String str = this.url + " , " + this.dQx + " , " + this.icon + " , " + this.IhY + " , " + this.title;
      AppMethodBeat.o(71061);
      return str;
    }
  }
  
  final class c
    extends BaseAdapter
  {
    protected List<Orders.Promotions> HZN;
    
    public c()
    {
      AppMethodBeat.i(71062);
      this.HZN = null;
      this.HZN = new ArrayList();
      Object localObject;
      int j = localObject.size();
      int i = 0;
      while (i < j)
      {
        this$1 = (Orders.Promotions)localObject.get(i);
        if ((WalletOrderInfoOldUI.this != null) && ((!Util.isNullOrNil(WalletOrderInfoOldUI.this.dCu)) || (WalletOrderInfoOldUI.this.Utv == 2) || (WalletOrderInfoOldUI.this.Utv == 1))) {
          this.HZN.add(localObject.get(i));
        }
        i += 1;
      }
      AppMethodBeat.o(71062);
    }
    
    public final Orders.Promotions aeU(int paramInt)
    {
      AppMethodBeat.i(71064);
      Orders.Promotions localPromotions = (Orders.Promotions)this.HZN.get(paramInt);
      AppMethodBeat.o(71064);
      return localPromotions;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(71063);
      if (this.HZN != null)
      {
        int i = this.HZN.size();
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
      Orders.Promotions localPromotions = aeU(paramInt);
      Object localObject;
      if ((Util.isNullOrNil(localPromotions.dCu)) && (localPromotions.crw > 0L))
      {
        localObject = WalletOrderInfoOldUI.this.LT(localPromotions.crw);
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
        String str = WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this);
        paramInt = localPromotions.Utv;
        paramViewGroup = (ViewGroup)localObject;
        if ("-1".equals(localObject)) {
          paramViewGroup = Integer.valueOf(5);
        }
        localh.a(13471, new Object[] { str, Integer.valueOf(1), Integer.valueOf(paramInt), paramViewGroup, Long.valueOf(localPromotions.crw), Long.valueOf(localPromotions.HYE) });
      }
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramViewGroup.type = localPromotions.type;
        if (localPromotions.type == Orders.HZD) {
          if (localPromotions.trD == 1)
          {
            paramView = View.inflate(WalletOrderInfoOldUI.this, 2131496978, null);
            paramViewGroup.qgQ = ((CdnImageView)paramView.findViewById(2131310248));
            paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131310263));
            paramViewGroup.IiK = ((TextView)paramView.findViewById(2131310235));
            paramViewGroup.gxs = ((TextView)paramView.findViewById(2131310250));
            if (!TextUtils.isEmpty(localPromotions.url)) {
              WalletOrderInfoOldUI.this.Iik.put(localPromotions.url, paramViewGroup.IiK);
            }
            paramView.setTag(paramViewGroup);
            paramViewGroup.trD = localPromotions.trD;
          }
        }
      }
      label293:
      label1586:
      for (;;)
      {
        if (localPromotions != null)
        {
          localObject = (WalletOrderInfoOldUI.b)WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this).get(localPromotions.crw);
          Log.i("MicroMsg.WalletOrderInfoOldUI", "try get result ".concat(String.valueOf(localObject)));
          if (localObject == null) {
            break label1306;
          }
          paramViewGroup.qgQ.setUrl(((WalletOrderInfoOldUI.b)localObject).icon);
          paramViewGroup.gxs.setText(((WalletOrderInfoOldUI.b)localObject).dQx);
          paramViewGroup.IiK.setText(((WalletOrderInfoOldUI.b)localObject).IhY);
          if (Util.isNullOrNil(localPromotions.dCu)) {
            break label1356;
          }
          paramViewGroup.IiK.setVisibility(8);
          if (paramViewGroup.IiL != null)
          {
            paramViewGroup.IiL.setVisibility(0);
            if (!WalletOrderInfoOldUI.this.Ihn.contains(localPromotions.dCu)) {
              break label1345;
            }
            paramViewGroup.IiL.setChecked(true);
          }
          label450:
          if ((paramViewGroup.titleTv == null) || (localObject == null) || (Util.isNullOrNil(((WalletOrderInfoOldUI.b)localObject).title))) {
            break label1383;
          }
          paramViewGroup.titleTv.setText(((WalletOrderInfoOldUI.b)localObject).title);
          label485:
          if ((!Util.isNullOrNil(WalletOrderInfoOldUI.this.IdJ)) && (paramViewGroup.IiK != null))
          {
            paramViewGroup.IiK.setClickable(WalletOrderInfoOldUI.this.dEh);
            paramViewGroup.IiK.setEnabled(WalletOrderInfoOldUI.this.dEh);
            paramViewGroup.IiK.setOnClickListener(null);
            if (WalletOrderInfoOldUI.this.dEi) {
              paramViewGroup.IiK.setVisibility(8);
            }
          }
          long l = localPromotions.crw;
          localObject = WalletOrderInfoOldUI.this.LT(l);
          if (!((String)localObject).equals("0")) {
            break label1435;
          }
          paramViewGroup.IiK.setBackgroundColor(WalletOrderInfoOldUI.this.getResources().getColor(2131101287));
          paramViewGroup.IiK.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(2131101414));
        }
        for (;;)
        {
          if (paramViewGroup.IiK != null)
          {
            paramInt = BackwardSupportUtil.BitmapFactory.fromDPToPix(WalletOrderInfoOldUI.this.getContext(), 15.0F);
            i = BackwardSupportUtil.BitmapFactory.fromDPToPix(WalletOrderInfoOldUI.this.getContext(), 5.0F);
            paramViewGroup.IiK.setPadding(paramInt, i, paramInt, i);
          }
          AppMethodBeat.o(71065);
          return paramView;
          paramView = View.inflate(WalletOrderInfoOldUI.this, 2131496979, null);
          paramViewGroup.qgQ = ((CdnImageView)paramView.findViewById(2131310248));
          paramViewGroup.IiK = ((TextView)paramView.findViewById(2131310235));
          paramViewGroup.gxs = ((TextView)paramView.findViewById(2131310250));
          paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131310263));
          if (!TextUtils.isEmpty(localPromotions.url)) {
            WalletOrderInfoOldUI.this.Iik.put(localPromotions.url, paramViewGroup.IiK);
          }
          paramView.setTag(paramViewGroup);
          break;
          paramView = View.inflate(WalletOrderInfoOldUI.this, 2131496980, null);
          paramViewGroup.qgQ = ((CdnImageView)paramView.findViewById(2131310248));
          paramViewGroup.IiK = ((TextView)paramView.findViewById(2131310235));
          paramViewGroup.gxs = ((TextView)paramView.findViewById(2131310250));
          paramViewGroup.IiL = ((CheckBox)paramView.findViewById(2131296592));
          if (!TextUtils.isEmpty(localPromotions.url)) {
            WalletOrderInfoOldUI.this.Iik.put(localPromotions.url, paramViewGroup.IiK);
          }
          paramView.setTag(paramViewGroup);
          break label293;
          paramViewGroup = (a)paramView.getTag();
          int i = 0;
          paramInt = i;
          if (localPromotions.type == paramViewGroup.type) {
            if (localPromotions.type == Orders.HZD)
            {
              paramInt = i;
              if (localPromotions.trD != paramViewGroup.trD) {}
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
          if (localPromotions.type == Orders.HZD)
          {
            if (localPromotions.trD == 1)
            {
              paramView = View.inflate(WalletOrderInfoOldUI.this, 2131496978, null);
              paramViewGroup.qgQ = ((CdnImageView)paramView.findViewById(2131310248));
              paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131310263));
              paramViewGroup.IiK = ((TextView)paramView.findViewById(2131310235));
              paramViewGroup.gxs = ((TextView)paramView.findViewById(2131310250));
              if (!TextUtils.isEmpty(localPromotions.url)) {
                WalletOrderInfoOldUI.this.Iik.put(localPromotions.url, paramViewGroup.IiK);
              }
              paramView.setTag(paramViewGroup);
            }
            for (;;)
            {
              paramViewGroup.trD = localPromotions.trD;
              break;
              paramView = View.inflate(WalletOrderInfoOldUI.this, 2131496979, null);
              paramViewGroup.qgQ = ((CdnImageView)paramView.findViewById(2131310248));
              paramViewGroup.IiK = ((TextView)paramView.findViewById(2131310235));
              paramViewGroup.gxs = ((TextView)paramView.findViewById(2131310250));
              paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131310263));
              if (!TextUtils.isEmpty(localPromotions.url)) {
                WalletOrderInfoOldUI.this.Iik.put(localPromotions.url, paramViewGroup.IiK);
              }
              paramView.setTag(paramViewGroup);
            }
          }
          paramView = View.inflate(WalletOrderInfoOldUI.this, 2131496980, null);
          paramViewGroup.qgQ = ((CdnImageView)paramView.findViewById(2131310248));
          paramViewGroup.IiK = ((TextView)paramView.findViewById(2131310235));
          paramViewGroup.gxs = ((TextView)paramView.findViewById(2131310250));
          paramViewGroup.IiL = ((CheckBox)paramView.findViewById(2131296592));
          if (!TextUtils.isEmpty(localPromotions.url)) {
            WalletOrderInfoOldUI.this.Iik.put(localPromotions.url, paramViewGroup.IiK);
          }
          paramView.setTag(paramViewGroup);
          break label293;
          paramViewGroup.qgQ.setUrl(localPromotions.Bah);
          paramViewGroup.gxs.setText(localPromotions.name);
          paramViewGroup.IiK.setText(localPromotions.HYF);
          break label387;
          label1345:
          paramViewGroup.IiL.setChecked(false);
          break label450;
          label1356:
          paramViewGroup.IiK.setVisibility(0);
          if (paramViewGroup.IiL == null) {
            break label450;
          }
          paramViewGroup.IiL.setVisibility(8);
          break label450;
          label1383:
          if ((paramViewGroup.titleTv != null) && (!Util.isNullOrNil(localPromotions.title)))
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
            paramViewGroup.IiK.setBackgroundDrawable(WalletOrderInfoOldUI.this.getResources().getDrawable(2131231443));
            paramViewGroup.IiK.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(2131101414));
          }
          else if ((((String)localObject).equals("4")) || (((String)localObject).equals("2")) || (((String)localObject).equals("1")))
          {
            paramViewGroup.IiK.setBackgroundColor(WalletOrderInfoOldUI.this.getResources().getColor(2131101287));
            paramViewGroup.IiK.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(2131100594));
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
      TextView IiK;
      CheckBox IiL;
      TextView gxs;
      CdnImageView qgQ;
      TextView titleTv;
      int trD;
      int type;
      
      a() {}
    }
  }
  
  final class d
  {
    public String CpP;
    public String HQn;
    public long Ian;
    public String Iia;
    public String Iib;
    public String Iic;
    public String dNQ;
    
    public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong)
    {
      this.HQn = paramString1;
      this.Iia = paramString2;
      this.Iib = paramString3;
      this.Iic = paramString4;
      this.dNQ = paramString5;
      this.CpP = paramString6;
      this.Ian = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI
 * JD-Core Version:    0.7.0.1
 */