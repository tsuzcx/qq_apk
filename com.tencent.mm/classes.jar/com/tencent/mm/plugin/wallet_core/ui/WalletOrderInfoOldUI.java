package com.tencent.mm.plugin.wallet_core.ui;

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
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.adb;
import com.tencent.mm.autogen.a.bh;
import com.tencent.mm.autogen.a.na;
import com.tencent.mm.autogen.a.na.a;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
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
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.utils.m;
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
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.model.ac;
import com.tencent.mm.wallet_core.ui.i;
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
  private IListener MCd;
  protected String MFC;
  protected String MyF;
  private String OqR;
  protected boolean VMj;
  private HashMap<String, b> VMm;
  protected String VMn;
  protected Set<String> VPH;
  protected List<Orders.Commodity> VPI;
  private IListener VQu;
  protected LinearLayout VRa;
  protected TextView VRb;
  protected TextView VRc;
  protected a VRd;
  protected String VRe;
  protected HashMap<String, TextView> VRf;
  protected c VRg;
  protected Map<Long, String> VRh;
  private d VRi;
  private boolean VRj;
  protected az.b.a VRk;
  private View.OnLongClickListener VRl;
  protected Orders VmL;
  protected boolean hBs;
  protected boolean hBt;
  protected boolean hBu;
  protected String mAppId;
  protected PayInfo mPayInfo;
  protected String sWX;
  
  public WalletOrderInfoOldUI()
  {
    AppMethodBeat.i(71067);
    this.VRa = null;
    this.VRb = null;
    this.VRc = null;
    this.VPI = null;
    this.VRd = null;
    this.sWX = null;
    this.MFC = null;
    this.VMj = false;
    this.VPH = null;
    this.mAppId = "";
    this.VRe = null;
    this.hBs = true;
    this.hBt = false;
    this.hBu = false;
    this.VRf = new HashMap();
    this.VRh = new HashMap();
    this.VMm = new HashMap();
    this.VRj = false;
    this.MCd = new IListener(f.hfK) {};
    this.VRk = new WalletOrderInfoOldUI.5(this);
    this.VRl = new WalletOrderInfoOldUI.10(this);
    this.VQu = new WalletOrderInfoOldUI.11(this, f.hfK);
    AppMethodBeat.o(71067);
  }
  
  private void aNi()
  {
    int j = 1;
    AppMethodBeat.i(71068);
    com.tencent.mm.wallet_core.e locale = com.tencent.mm.wallet_core.a.cm(this);
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.MyF = getInput().getString("key_trans_id");
    getInput().getInt("key_pay_type", -1);
    Log.i("MicroMsg.WalletOrderInfoOldUI", "mTransId %s", new Object[] { this.MyF });
    this.VmL = ikP();
    if (this.VmL != null)
    {
      setContentViewVisibility(0);
      d(this.VmL);
      int i;
      boolean bool1;
      if ((locale != null) && (this.VmL != null) && (this.mPayInfo != null))
      {
        this.mAppId = this.mPayInfo.appId;
        boolean bool2 = locale.jOh();
        m.a(this, getInput(), 7);
        if (getInput().getInt("key_support_bankcard", 1) == 2)
        {
          i = 2;
          com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
          int k = this.mPayInfo.hUR;
          if (this.mPayInfo.hUR != 3) {
            break label455;
          }
          bool1 = true;
          label190:
          if (!bool2) {
            break label461;
          }
          label195:
          localh.b(10691, new Object[] { Integer.valueOf(k), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(ac.jOS()), Integer.valueOf((int)(this.VmL.hAW * 100.0D)), this.VmL.MEq, Integer.valueOf(i) });
        }
      }
      else
      {
        if (((!u.iiC().ijf()) && (locale != null) && (locale.jOh())) || (!z.bBd())) {
          z.bBe();
        }
        if ((this.VmL == null) || (this.VmL.VGX == null) || (this.VmL.VGX.size() <= 0)) {
          break label466;
        }
        this.VPI = this.VmL.VGX;
        this.MyF = ((Orders.Commodity)this.VPI.get(0)).hAU;
        if ((this.mPayInfo != null) && (locale != null) && ((locale.jOg()) || (locale.jOh()))) {
          doSceneProgress(new ae(getPayReqKey(), 21));
        }
      }
      for (;;)
      {
        if (this.MyF != null) {
          break label533;
        }
        if (((com.tencent.mm.plugin.fingerprint.mgr.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.mgr.e.class)).l(this)) {
          this.VRj = false;
        }
        AppMethodBeat.o(71068);
        return;
        i = 1;
        break;
        label455:
        bool1 = false;
        break label190;
        label461:
        j = 2;
        break label195;
        label466:
        Log.printInfoStack("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
        k.a(getContext(), a.i.wallet_order_info_err, 0, new DialogInterface.OnClickListener()
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
    k.a(getContext(), a.i.wallet_order_info_err, 0, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(71046);
        WalletOrderInfoOldUI.this.finish();
        AppMethodBeat.o(71046);
      }
    });
    label533:
    AppMethodBeat.o(71068);
  }
  
  private void d(Orders paramOrders)
  {
    AppMethodBeat.i(71075);
    this.VPH.clear();
    if ((paramOrders == null) || (paramOrders.VGX == null))
    {
      Log.w("MicroMsg.WalletOrderInfoOldUI", "hy: orders is null");
      AppMethodBeat.o(71075);
      return;
    }
    paramOrders = paramOrders.VGX.iterator();
    while (paramOrders.hasNext())
    {
      Orders.Commodity localCommodity = (Orders.Commodity)paramOrders.next();
      if ((localCommodity.VGN == 2) && (!Util.isNullOrNil(localCommodity.VHz)))
      {
        Log.d("MicroMsg.WalletOrderInfoOldUI", "hy: has username and is force recommend");
        this.VPH.add(localCommodity.VHz);
      }
    }
    AppMethodBeat.o(71075);
  }
  
  private void ikB()
  {
    int i = 0;
    AppMethodBeat.i(71080);
    if (!this.VMj)
    {
      na localna = new na();
      localna.hPl.hPm = 4;
      na.a locala = localna.hPl;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.resultCode = i;
      localna.publish();
      this.VMj = true;
    }
    AppMethodBeat.o(71080);
  }
  
  private void ikW()
  {
    AppMethodBeat.i(71077);
    if (this.VmL != null)
    {
      this.VPI = this.VmL.VGX;
      Iterator localIterator = this.VPI.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!"1".equals(((Orders.Commodity)localIterator.next()).MEj));
    }
    for (int i = 0;; i = 1)
    {
      this.VRa.setVisibility(0);
      this.VRb.setVisibility(0);
      if (i != 0)
      {
        if ((!Util.isNullOrNil(this.VmL.VGP)) && (!Util.isNullOrNil(this.VmL.VGP.trim())))
        {
          this.VRb.setText(this.VmL.VGP);
          AppMethodBeat.o(71077);
          return;
        }
        if (this.VmL.Vyb != 1)
        {
          this.VRb.setText(a.i.wallet_order_info_result_success_international);
          AppMethodBeat.o(71077);
          return;
        }
        this.VRb.setText(a.i.wallet_order_info_result_success);
        AppMethodBeat.o(71077);
        return;
      }
      this.VRb.setText(a.i.wallet_order_info_result_wait);
      AppMethodBeat.o(71077);
      return;
    }
  }
  
  private void ikX()
  {
    AppMethodBeat.i(71089);
    if ((this.VmL != null) && (this.VmL.VGX != null) && (this.VmL.VGX.size() > 0) && (((Orders.Commodity)this.VmL.VGX.get(0)).VHL != null) && (!Util.isNullOrNil(((Orders.Commodity)this.VmL.VGX.get(0)).VHL.text)) && (!Util.isNullOrNil(((Orders.Commodity)this.VmL.VGX.get(0)).VHL.url)))
    {
      this.VRc.setVisibility(0);
      this.VRc.setText(((Orders.Commodity)this.VmL.VGX.get(0)).VHL.text);
      this.VRc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71052);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          i.p(WalletOrderInfoOldUI.this, ((Orders.Commodity)WalletOrderInfoOldUI.this.VmL.VGX.get(0)).VHL.url, false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71052);
        }
      });
      AppMethodBeat.o(71089);
      return;
    }
    Log.i("MicroMsg.WalletOrderInfoOldUI", "hy: no commodity or no link act or link act is illegal!");
    this.VRc.setVisibility(8);
    AppMethodBeat.o(71089);
  }
  
  protected final void a(Orders.Promotions paramPromotions)
  {
    AppMethodBeat.i(71074);
    doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.t(paramPromotions, getPayReqKey(), this.MyF, paramPromotions.VGy));
    AppMethodBeat.o(71074);
  }
  
  protected final void a(String paramString, d paramd)
  {
    AppMethodBeat.i(71078);
    ikB();
    this.VRi = paramd;
    i.a(this, paramString, false, 1);
    this.VRj = false;
    AppMethodBeat.o(71078);
  }
  
  protected final void aiT(String paramString)
  {
    AppMethodBeat.i(71079);
    ikB();
    i.p(this, paramString, false);
    this.VRj = false;
    AppMethodBeat.o(71079);
  }
  
  protected final void au(au paramau)
  {
    AppMethodBeat.i(71081);
    if ((paramau != null) && ((int)paramau.maN != 0))
    {
      String str = paramau.aSU();
      Log.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer nickName " + str + " username: " + paramau.field_username);
      if ((this.VPI != null) && (this.VPI.size() > 0))
      {
        Iterator localIterator = this.VPI.iterator();
        while (localIterator.hasNext()) {
          ((Orders.Commodity)localIterator.next()).hzv = str;
        }
        this.VRd.notifyDataSetChanged();
      }
      this.sWX = paramau.field_username;
    }
    AppMethodBeat.o(71081);
  }
  
  protected final void bhi(String paramString)
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
            WalletOrderInfoOldUI.this.ikV();
            AppMethodBeat.o(71050);
          }
        });
        getInput().remove("key_realname_guide_helper");
        if (!bool) {
          ikV();
        }
      }
      AppMethodBeat.o(71083);
      return;
    }
    ikV();
    AppMethodBeat.o(71083);
  }
  
  protected final boolean gNb()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_order_info;
  }
  
  protected final void hG(String paramString, int paramInt)
  {
    AppMethodBeat.i(71073);
    doSceneProgress(new af(paramString, paramInt));
    AppMethodBeat.o(71073);
  }
  
  protected Orders ikP()
  {
    AppMethodBeat.i(71070);
    Orders localOrders = (Orders)getInput().getParcelable("key_orders");
    AppMethodBeat.o(71070);
    return localOrders;
  }
  
  public final void ikV()
  {
    AppMethodBeat.i(71084);
    ikB();
    this.VRj = false;
    Object localObject1 = new bh();
    ((bh)localObject1).hBn.hBo = true;
    ((bh)localObject1).publish();
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("intent_pay_end_errcode", getInput().getInt("intent_pay_end_errcode"));
    ((Bundle)localObject2).putString("intent_pay_app_url", getInput().getString("intent_pay_app_url"));
    ((Bundle)localObject2).putBoolean("intent_pay_end", getInput().getBoolean("intent_pay_end"));
    Log.i("MicroMsg.WalletOrderInfoOldUI", "pay done...feedbackData errCode:" + getInput().getInt("intent_pay_end_errcode"));
    Iterator localIterator = this.VPH.iterator();
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (!Util.isNullOrNil(str1))
      {
        Log.i("MicroMsg.WalletOrderInfoOldUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str1 });
        if ((this.VmL == null) || (this.mPayInfo == null)) {
          break label336;
        }
        s locals = com.tencent.mm.kernel.h.baD().mCm;
        String str2 = this.VmL.hAT;
        if (this.VmL.VGX.size() <= 0) {
          break label330;
        }
        localObject1 = ((Orders.Commodity)this.VmL.VGX.get(0)).hAU;
        label247:
        locals.a(new com.tencent.mm.wallet_core.model.t(str1, str2, (String)localObject1, this.mPayInfo.hUR, this.mPayInfo.channel, this.VmL.VGN), 0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(13033, new Object[] { Integer.valueOf(2), str1, "", "", "" });
        break;
        label330:
        localObject1 = "";
        break label247;
        label336:
        com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.wallet_core.model.t(str1), 0);
      }
    }
    com.tencent.mm.wallet_core.a.k(this, (Bundle)localObject2);
    if ((this.VmL != null) && (!Util.isNullOrNil(this.VmL.ytZ))) {
      if (this.VmL.VGX.size() <= 0) {
        break label532;
      }
    }
    label532:
    for (localObject1 = ((Orders.Commodity)this.VmL.VGX.get(0)).hAU;; localObject1 = "")
    {
      localObject1 = i(this.VmL.ytZ, this.VmL.hAT, (String)localObject1, this.mPayInfo.wsM, this.mPayInfo.remark);
      Log.d("MicroMsg.WalletOrderInfoOldUI", "url = ".concat(String.valueOf(localObject1)));
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
      ((Intent)localObject2).putExtra("showShare", false);
      ((Intent)localObject2).putExtra("geta8key_username", z.bAM());
      ((Intent)localObject2).putExtra("stastic_scene", 8);
      com.tencent.mm.br.c.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject2);
      AppMethodBeat.o(71084);
      return;
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(71076);
    setMMTitle(a.i.wallet_order_info_ui_title);
    showHomeBtn(false);
    enableBackMenu(false);
    String str = getString(a.i.app_finish);
    Object localObject;
    if ((this.mPayInfo != null) && (this.mPayInfo.hUR == 2)) {
      if (!Util.isNullOrNil(this.mPayInfo.Wan)) {
        localObject = getString(a.i.app_back) + this.mPayInfo.Wan;
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
      this.VRa = ((LinearLayout)findViewById(a.f.wallet_order_info_result_ll));
      this.VRb = ((TextView)findViewById(a.f.wallet_order_info_result));
      this.VRc = ((TextView)findViewById(a.f.wallet_order_info_link_act));
      localObject = (MaxListView)findViewById(a.f.wallet_order_info);
      this.VRd = new a();
      ((MaxListView)localObject).setAdapter(this.VRd);
      ikW();
      ikX();
      ((ScrollView)findViewById(a.f.wallet_sv)).pageScroll(33);
      AppMethodBeat.o(71076);
      return;
      localObject = str;
      if (!Util.isNullOrNil(this.mPayInfo.appId))
      {
        localObject = str;
        if (!Util.isNullOrNil(com.tencent.mm.pluginsdk.model.app.h.x(this, this.mPayInfo.appId)))
        {
          localObject = getString(a.i.app_back) + com.tencent.mm.pluginsdk.model.app.h.x(this, this.mPayInfo.appId);
          continue;
          localObject = str;
          if (this.VmL != null)
          {
            localObject = str;
            if (!Util.isNullOrNil(this.VmL.VHi)) {
              localObject = this.VmL.VHi;
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
      doSceneProgress(new ag(this.VRi.Vyi, this.VRi.VQV, this.VRi.VQW, this.VRi.VQX, this.VRi.hMy, this.VRi.Oks, this.VRi.VIF));
    }
    AppMethodBeat.o(71088);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71069);
    super.onCreate(paramBundle);
    setContentViewVisibility(4);
    this.VPH = new HashSet();
    aNi();
    initView();
    addSceneEndListener(1979);
    this.VQu.alive();
    this.MCd.alive();
    this.VRj = false;
    AppMethodBeat.o(71069);
  }
  
  @Deprecated
  public Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(71086);
    Dialog localDialog = k.a(getContext(), getString(a.i.wallet_order_info_phone), getResources().getStringArray(a.b.wallet_phone_call), "", new WalletOrderInfoOldUI.8(this));
    AppMethodBeat.o(71086);
    return localDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71082);
    super.onDestroy();
    this.VQu.dead();
    this.MCd.dead();
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
    Log.i("MicroMsg.WalletOrderInfoOldUI", "onResume, isClickActivityTinyApp: %s", new Object[] { Boolean.valueOf(this.VRj) });
    if (this.VRj) {
      doSceneProgress(new ag(this.VRi.Vyi, this.VRi.VQV, this.VRi.VQW, this.VRi.VQX, this.VRi.hMy, this.VRi.Oks, this.VRi.VIF));
    }
    AppMethodBeat.o(71087);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(71090);
    int i;
    if (((paramp instanceof ag)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      ag localag = (ag)paramp;
      b localb = new b(localag.rwB);
      if ((!Util.isNullOrNil(localb.url)) && (!Util.isNullOrNil(localb.wording)))
      {
        i = 1;
        if (i != 0) {
          this.VMm.put(localag.Vyi, localb);
        }
        this.VRd.notifyDataSetChanged();
      }
    }
    else
    {
      if (!(paramp instanceof af)) {
        break label355;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        setContentViewVisibility(0);
        this.VmL = ((af)paramp).Vyn;
        if (this.VmL != null) {
          this.VPI = this.VmL.VGX;
        }
        d(this.VmL);
        Log.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + this.VPI);
        if ((this.VPI != null) && (this.VPI.size() != 0))
        {
          paramString = (Orders.Commodity)this.VPI.get(0);
          this.MyF = paramString.hAU;
          Log.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + paramString.toString());
          paramp = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString.hzv);
          if ((paramp == null) || ((int)paramp.maN == 0)) {
            break label334;
          }
          au(paramp);
        }
      }
    }
    for (;;)
    {
      this.VRd.notifyDataSetChanged();
      ikW();
      if (this.VRd != null) {
        this.VRd.notifyDataSetChanged();
      }
      ikX();
      AppMethodBeat.o(71090);
      return true;
      i = 0;
      break;
      label334:
      az.a.okP.a(paramString.hzv, "", this.VRk);
    }
    label355:
    if ((paramp instanceof com.tencent.mm.plugin.wallet_core.c.t))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.wallet_core.c.t)paramp;
        paramp = paramString.VxR;
        long l = paramString.VxU.ehe;
        this.VRh.put(Long.valueOf(l), paramp);
        paramString.VxU.VGz = paramString.resultMsg;
        if ((!"-1".equals(paramp)) && (!"0".equals(paramp)) && (!Util.isNullOrNil(paramString.VxS))) {
          k.c(this, paramString.VxS, "", true);
        }
        while (!"0".equals(paramp))
        {
          this.VRd.notifyDataSetChanged();
          AppMethodBeat.o(71090);
          return true;
        }
        if (!Util.isNullOrNil(paramString.VxS)) {}
        for (paramString = paramString.VxS;; paramString = getString(a.i.wallet_pay_award_got))
        {
          Toast.makeText(this, paramString, 0).show();
          break;
        }
      }
      if ((paramp instanceof com.tencent.mm.plugin.wallet_core.c.t))
      {
        paramp = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramp = getString(a.i.wallet_unknown_err);
        }
        k.a(this, paramp, null, false, new DialogInterface.OnClickListener()
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
  
  public final String xA(long paramLong)
  {
    AppMethodBeat.i(71091);
    if (this.VRh.containsKey(Long.valueOf(paramLong)))
    {
      String str = (String)this.VRh.get(Long.valueOf(paramLong));
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
    
    private Orders.Commodity asw(int paramInt)
    {
      AppMethodBeat.i(71057);
      Orders.Commodity localCommodity = (Orders.Commodity)WalletOrderInfoOldUI.this.VPI.get(paramInt);
      AppMethodBeat.o(71057);
      return localCommodity;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(71056);
      if (WalletOrderInfoOldUI.this.VPI != null)
      {
        int i = WalletOrderInfoOldUI.this.VPI.size();
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
        paramViewGroup.VRp = ((TextView)paramView.findViewById(a.f.wallet_order_info_bankcard_title));
        paramViewGroup.plr = ((TextView)paramView.findViewById(a.f.wallet_order_info_desc));
        paramViewGroup.VRs = ((TextView)paramView.findViewById(a.f.wallet_order_info_spid));
        paramViewGroup.VRq = ((TextView)paramView.findViewById(a.f.wallet_order_info_total_fee));
        paramViewGroup.VRr = ((TextView)paramView.findViewById(a.f.wallet_order_info_org_total_fee));
        paramViewGroup.VRr.getPaint().setFlags(16);
        paramViewGroup.VRt = ((TextView)paramView.findViewById(a.f.wallet_order_info_trans_id));
        paramViewGroup.VRu = ((TextView)paramView.findViewById(a.f.wallet_order_info_cre_time));
        paramViewGroup.VRv = ((TextView)paramView.findViewById(a.f.wallet_order_info_bankcard));
        paramViewGroup.VRx = ((MaxListView)paramView.findViewById(a.f.wallet_order_info_promotions));
        paramViewGroup.VRy = paramView.findViewById(a.f.wallet_order_info_discount_ll);
        paramViewGroup.VRw = paramView.findViewById(a.f.wallet_order_info_septator_3);
        paramViewGroup.VRA = ((TextView)paramView.findViewById(a.f.wallet_order_original_feeinfo_desc));
        paramViewGroup.VRz = ((TextView)paramView.findViewById(a.f.wallet_order_original_feeinfo_title));
        paramViewGroup.VRB = ((TextView)paramView.findViewById(a.f.wallet_order_rate_info_desc));
        paramViewGroup.VRC = ((TextView)paramView.findViewById(a.f.wallet_order_rate_info_title));
        paramViewGroup.VRE = ((ViewGroup)paramView.findViewById(a.f.wallet_order_info_tiny_app_info));
        paramViewGroup.VMt = ((CdnImageView)paramView.findViewById(a.f.tinyapp_logo_iv));
        paramViewGroup.VMu = ((TextView)paramView.findViewById(a.f.tinyapp_desc));
        paramViewGroup.VMv = ((TextView)paramView.findViewById(a.f.tinyapp_name));
        paramViewGroup.VRD = paramView.findViewById(a.f.wallet_order_info_septator_4);
        paramView.setTag(paramViewGroup);
        localCommodity = asw(paramInt);
        if ((localCommodity == null) || (paramViewGroup == null)) {
          break label1210;
        }
        WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this, localCommodity.hAU);
        paramViewGroup.VRq.setText(i.e(localCommodity.wZe, localCommodity.MEq));
        if ((localCommodity.VHy < 0.0D) || (localCommodity.wZe >= localCommodity.VHy)) {
          break label654;
        }
        paramViewGroup.VRr.setText(i.e(localCommodity.VHy, localCommodity.MEq));
        paramViewGroup.VRr.setVisibility(0);
        localObject1 = (LinearLayout)paramViewGroup.VRy;
        localObject2 = localCommodity.VHB;
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
        if (localDiscountInfo.VHU <= 0.0D) {
          break label666;
        }
        localTextView.setText(localDiscountInfo.OhO + i.e(localDiscountInfo.VHU / 100.0D, WalletOrderInfoOldUI.this.VmL.MEq));
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
        paramViewGroup.VRr.setVisibility(8);
        break label419;
        label666:
        localTextView.setText(localDiscountInfo.OhO);
      }
      label679:
      if (((LinearLayout)localObject1).getChildCount() > 0)
      {
        ((LinearLayout)localObject1).setVisibility(0);
        localObject2 = paramViewGroup.VRp;
        localObject1 = WalletOrderInfoOldUI.this;
        if (!z.bBi()) {
          break label1227;
        }
        localObject1 = ((Context)localObject1).getString(a.i.wallet_order_info_pay_method_payu);
        label721:
        ((TextView)localObject2).setText((CharSequence)localObject1);
        paramViewGroup.VRs.setText(localCommodity.MEf);
        paramViewGroup.plr.setText(localCommodity.desc);
        paramViewGroup.plr.setTag(localCommodity.desc);
        paramViewGroup.plr.setOnLongClickListener(WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this));
        paramViewGroup.plr.setBackgroundResource(a.e.wallet_order_info_trans_id_text_bg);
        paramViewGroup.VRt.setText(localCommodity.hAU);
        paramViewGroup.VRt.setTag(localCommodity.hAU);
        paramViewGroup.VRt.setOnLongClickListener(WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this));
        paramViewGroup.VRt.setBackgroundResource(a.e.wallet_order_info_trans_id_text_bg);
        paramViewGroup.VRu.setText(i.vh(localCommodity.MEm));
        paramViewGroup.VRv.setText(localCommodity.MEo);
        localObject1 = localCommodity.VHC;
        if (paramViewGroup.VRB != null)
        {
          if (Util.isNullOrNil((String)localObject1)) {
            break label1240;
          }
          paramViewGroup.VRB.setText((CharSequence)localObject1);
          paramViewGroup.VRB.setVisibility(0);
          paramViewGroup.VRC.setVisibility(0);
        }
        localObject1 = localCommodity.VHE;
        if (paramViewGroup.VRA != null)
        {
          if (Util.isNullOrNil((String)localObject1)) {
            break label1261;
          }
          paramViewGroup.VRA.setText((CharSequence)localObject1);
          paramViewGroup.VRA.setVisibility(0);
          paramViewGroup.VRz.setVisibility(0);
        }
        label957:
        if (localCommodity.VHJ.size() <= 0) {
          break label1282;
        }
        localObject1 = (Orders.Promotions)localCommodity.VHJ.get(0);
        com.tencent.mm.plugin.report.service.h.OAn.b(13033, new Object[] { Integer.valueOf(1), ((Orders.Promotions)localObject1).hzv, ((Orders.Promotions)localObject1).url, ((Orders.Promotions)localObject1).name, WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this) });
        WalletOrderInfoOldUI.this.VRg = new WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this, localCommodity.VHJ);
        paramViewGroup.VRx.setAdapter(WalletOrderInfoOldUI.this.VRg);
        paramViewGroup.VRx.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(71054);
            b localb = new b();
            localb.cH(paramAnonymousAdapterView);
            localb.cH(paramAnonymousView);
            localb.sc(paramAnonymousInt);
            localb.hB(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
            paramAnonymousAdapterView = WalletOrderInfoOldUI.this.VRg.asx(paramAnonymousInt);
            if (!Util.isNullOrNil(paramAnonymousAdapterView.hzv)) {
              if (WalletOrderInfoOldUI.this.VPH.contains(paramAnonymousAdapterView.hzv))
              {
                WalletOrderInfoOldUI.this.VPH.remove(paramAnonymousAdapterView.hzv);
                WalletOrderInfoOldUI.this.VRd.notifyDataSetChanged();
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(71054);
              return;
              WalletOrderInfoOldUI.this.VPH.add(paramAnonymousAdapterView.hzv);
              break;
              paramAnonymousView = WalletOrderInfoOldUI.this.xA(paramAnonymousAdapterView.ehe);
              if (("-1".equals(paramAnonymousView)) || ("3".equals(paramAnonymousView)))
              {
                com.tencent.mm.plugin.report.service.h.OAn.b(13472, new Object[] { WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this), Integer.valueOf(paramAnonymousAdapterView.akjp), Integer.valueOf(1), Long.valueOf(paramAnonymousAdapterView.ehe), Long.valueOf(paramAnonymousAdapterView.VGy) });
                com.tencent.mm.plugin.report.service.h.OAn.b(13033, new Object[] { Integer.valueOf(2), "", paramAnonymousAdapterView.url, paramAnonymousAdapterView.name, "" });
                if ((!Util.isNullOrNil(paramAnonymousAdapterView.akjs)) && (!Util.isNullOrNil(paramAnonymousAdapterView.akjt)))
                {
                  Log.i("MicroMsg.WalletOrderInfoOldUI", "promotion jump tiny app, username: %s, path: %s", new Object[] { paramAnonymousAdapterView.akjs, paramAnonymousAdapterView.akjt });
                  paramAnonymousView = new zp();
                  paramAnonymousView.icM.userName = paramAnonymousAdapterView.akjs;
                  paramAnonymousView.icM.icO = Util.nullAs(paramAnonymousAdapterView.akjt, "");
                  paramAnonymousView.icM.scene = 1060;
                  paramAnonymousView.icM.hzx = WalletOrderInfoOldUI.this.MyF;
                  paramAnonymousView.icM.icP = 0;
                  paramAnonymousView.publish();
                  com.tencent.mm.plugin.report.service.h.OAn.b(14118, new Object[] { WalletOrderInfoOldUI.this.MyF, WalletOrderInfoOldUI.this.getPayReqKey(), Integer.valueOf(2) });
                  WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this, new WalletOrderInfoOldUI.d(WalletOrderInfoOldUI.this, paramAnonymousAdapterView.ehe, paramAnonymousAdapterView.akjq, paramAnonymousAdapterView.VGw, paramAnonymousAdapterView.VGx, WalletOrderInfoOldUI.this.getPayReqKey(), WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this), paramAnonymousAdapterView.VGy));
                  WalletOrderInfoOldUI.a(WalletOrderInfoOldUI.this, true);
                }
                else if (paramAnonymousAdapterView.akjp == 1)
                {
                  WalletOrderInfoOldUI.this.a(paramAnonymousAdapterView);
                }
                else if ((paramAnonymousAdapterView.akjp == 2) && (!Util.isNullOrNil(paramAnonymousAdapterView.url)))
                {
                  if (WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this).containsKey(paramAnonymousAdapterView.ehe))
                  {
                    paramAnonymousAdapterView = (WalletOrderInfoOldUI.b)WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this).get(paramAnonymousAdapterView.ehe);
                    Log.i("MicroMsg.WalletOrderInfoOldUI", "go to new url %s", new Object[] { paramAnonymousAdapterView.url });
                    WalletOrderInfoOldUI.this.aiT(paramAnonymousAdapterView.url);
                  }
                  else
                  {
                    WalletOrderInfoOldUI.this.VMn = paramAnonymousAdapterView.url;
                    WalletOrderInfoOldUI.this.a(paramAnonymousAdapterView.url, new WalletOrderInfoOldUI.d(WalletOrderInfoOldUI.this, paramAnonymousAdapterView.ehe, paramAnonymousAdapterView.akjq, paramAnonymousAdapterView.VGw, paramAnonymousAdapterView.VGx, WalletOrderInfoOldUI.this.getPayReqKey(), WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this), paramAnonymousAdapterView.VGy));
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
        WalletOrderInfoOldUI.this.VRg.notifyDataSetChanged();
        paramViewGroup.VRx.setVisibility(0);
        paramViewGroup.VRw.setVisibility(0);
        label1118:
        if ((localCommodity.VHF == null) || (Util.isNullOrNil(localCommodity.VHF.VcU))) {
          break label1312;
        }
        paramViewGroup.VMt.setUrl(localCommodity.VHF.VGB);
        paramViewGroup.VMu.setText(localCommodity.VHF.VGC);
        paramViewGroup.VMv.setText(localCommodity.VHF.VsI);
        paramViewGroup.VRE.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71055);
            b localb = new b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            paramAnonymousView = new zp();
            paramAnonymousView.icM.userName = localCommodity.VHF.VcU;
            paramAnonymousView.icM.icO = Util.nullAs(localCommodity.VHF.VcV, "");
            paramAnonymousView.icM.scene = 1034;
            paramAnonymousView.icM.icP = 0;
            paramAnonymousView.publish();
            com.tencent.mm.plugin.report.service.h.OAn.b(14118, new Object[] { WalletOrderInfoOldUI.this.MyF, WalletOrderInfoOldUI.this.getPayReqKey(), Integer.valueOf(1) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71055);
          }
        });
        paramViewGroup.VRD.setVisibility(0);
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
        paramViewGroup.VRC.setVisibility(8);
        paramViewGroup.VRB.setVisibility(8);
        break label910;
        label1261:
        paramViewGroup.VRz.setVisibility(8);
        paramViewGroup.VRA.setVisibility(8);
        break label957;
        label1282:
        paramViewGroup.VRx.setVisibility(8);
        paramViewGroup.VRE.setVisibility(8);
        paramViewGroup.VRw.setVisibility(8);
        break label1118;
        label1312:
        paramViewGroup.VRE.setVisibility(8);
        paramViewGroup.VRD.setVisibility(8);
      }
    }
    
    final class a
    {
      CdnImageView VMt;
      TextView VMu;
      TextView VMv;
      TextView VRA;
      TextView VRB;
      TextView VRC;
      View VRD;
      ViewGroup VRE;
      TextView VRp;
      TextView VRq;
      TextView VRr;
      TextView VRs;
      TextView VRt;
      TextView VRu;
      TextView VRv;
      View VRw;
      MaxListView VRx;
      View VRy;
      TextView VRz;
      TextView plr;
      
      a() {}
    }
  }
  
  final class b
  {
    public String VQT;
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
        this.VQT = WalletOrderInfoOldUI.this.optString("btn_text");
        this.title = WalletOrderInfoOldUI.this.optString("title");
      }
      AppMethodBeat.o(71060);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(71061);
      String str = this.url + " , " + this.wording + " , " + this.icon + " , " + this.VQT + " , " + this.title;
      AppMethodBeat.o(71061);
      return str;
    }
  }
  
  final class c
    extends BaseAdapter
  {
    protected List<Orders.Promotions> VHJ;
    
    public c()
    {
      AppMethodBeat.i(71062);
      this.VHJ = null;
      this.VHJ = new ArrayList();
      Object localObject;
      int j = localObject.size();
      int i = 0;
      while (i < j)
      {
        this$1 = (Orders.Promotions)localObject.get(i);
        if ((WalletOrderInfoOldUI.this != null) && ((!Util.isNullOrNil(WalletOrderInfoOldUI.this.hzv)) || (WalletOrderInfoOldUI.this.akjp == 2) || (WalletOrderInfoOldUI.this.akjp == 1))) {
          this.VHJ.add((Orders.Promotions)localObject.get(i));
        }
        i += 1;
      }
      AppMethodBeat.o(71062);
    }
    
    public final Orders.Promotions asx(int paramInt)
    {
      AppMethodBeat.i(71064);
      Orders.Promotions localPromotions = (Orders.Promotions)this.VHJ.get(paramInt);
      AppMethodBeat.o(71064);
      return localPromotions;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(71063);
      if (this.VHJ != null)
      {
        int i = this.VHJ.size();
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
      Orders.Promotions localPromotions = asx(paramInt);
      Object localObject;
      if ((Util.isNullOrNil(localPromotions.hzv)) && (localPromotions.ehe > 0L))
      {
        localObject = WalletOrderInfoOldUI.this.xA(localPromotions.ehe);
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
        String str = WalletOrderInfoOldUI.b(WalletOrderInfoOldUI.this);
        paramInt = localPromotions.akjp;
        paramViewGroup = (ViewGroup)localObject;
        if ("-1".equals(localObject)) {
          paramViewGroup = Integer.valueOf(5);
        }
        localh.b(13471, new Object[] { str, Integer.valueOf(1), Integer.valueOf(paramInt), paramViewGroup, Long.valueOf(localPromotions.ehe), Long.valueOf(localPromotions.VGy) });
      }
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramViewGroup.type = localPromotions.type;
        if (localPromotions.type == Orders.VHx) {
          if (localPromotions.Avy == 1)
          {
            paramView = View.inflate(WalletOrderInfoOldUI.this, a.g.wallet_order_info_promotions_activity_festival_item, null);
            paramViewGroup.wGP = ((CdnImageView)paramView.findViewById(a.f.wallet_order_info_logo));
            paramViewGroup.titleTv = ((TextView)paramView.findViewById(a.f.wallet_order_info_title));
            paramViewGroup.QbG = ((TextView)paramView.findViewById(a.f.wallet_order_info_btn));
            paramViewGroup.lDF = ((TextView)paramView.findViewById(a.f.wallet_order_info_name));
            if (!TextUtils.isEmpty(localPromotions.url)) {
              WalletOrderInfoOldUI.this.VRf.put(localPromotions.url, paramViewGroup.QbG);
            }
            paramView.setTag(paramViewGroup);
            paramViewGroup.Avy = localPromotions.Avy;
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
          localObject = (WalletOrderInfoOldUI.b)WalletOrderInfoOldUI.c(WalletOrderInfoOldUI.this).get(localPromotions.ehe);
          Log.i("MicroMsg.WalletOrderInfoOldUI", "try get result ".concat(String.valueOf(localObject)));
          if (localObject == null) {
            break label1330;
          }
          paramViewGroup.wGP.setUrl(((WalletOrderInfoOldUI.b)localObject).icon);
          paramViewGroup.lDF.setText(((WalletOrderInfoOldUI.b)localObject).wording);
          paramViewGroup.QbG.setText(((WalletOrderInfoOldUI.b)localObject).VQT);
          if (Util.isNullOrNil(localPromotions.hzv)) {
            break label1380;
          }
          paramViewGroup.QbG.setVisibility(8);
          if (paramViewGroup.VRF != null)
          {
            paramViewGroup.VRF.setVisibility(0);
            if (!WalletOrderInfoOldUI.this.VPH.contains(localPromotions.hzv)) {
              break label1369;
            }
            paramViewGroup.VRF.setChecked(true);
          }
          if ((paramViewGroup.titleTv == null) || (localObject == null) || (Util.isNullOrNil(((WalletOrderInfoOldUI.b)localObject).title))) {
            break label1407;
          }
          paramViewGroup.titleTv.setText(((WalletOrderInfoOldUI.b)localObject).title);
          label490:
          if ((!Util.isNullOrNil(WalletOrderInfoOldUI.this.VMn)) && (paramViewGroup.QbG != null))
          {
            paramViewGroup.QbG.setClickable(WalletOrderInfoOldUI.this.hBs);
            paramViewGroup.QbG.setEnabled(WalletOrderInfoOldUI.this.hBs);
            paramViewGroup.QbG.setOnClickListener(null);
            if (WalletOrderInfoOldUI.this.hBt) {
              paramViewGroup.QbG.setVisibility(8);
            }
          }
          long l = localPromotions.ehe;
          localObject = WalletOrderInfoOldUI.this.xA(l);
          if (!((String)localObject).equals("0")) {
            break label1459;
          }
          paramViewGroup.QbG.setBackgroundColor(WalletOrderInfoOldUI.this.getResources().getColor(a.c.transparent));
          paramViewGroup.QbG.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(a.c.wechat_green));
        }
        for (;;)
        {
          if (paramViewGroup.QbG != null)
          {
            paramInt = BackwardSupportUtil.BitmapFactory.fromDPToPix(WalletOrderInfoOldUI.this.getContext(), 15.0F);
            i = BackwardSupportUtil.BitmapFactory.fromDPToPix(WalletOrderInfoOldUI.this.getContext(), 5.0F);
            paramViewGroup.QbG.setPadding(paramInt, i, paramInt, i);
          }
          AppMethodBeat.o(71065);
          return paramView;
          paramView = View.inflate(WalletOrderInfoOldUI.this, a.g.wallet_order_info_promotions_activity_item, null);
          paramViewGroup.wGP = ((CdnImageView)paramView.findViewById(a.f.wallet_order_info_logo));
          paramViewGroup.QbG = ((TextView)paramView.findViewById(a.f.wallet_order_info_btn));
          paramViewGroup.lDF = ((TextView)paramView.findViewById(a.f.wallet_order_info_name));
          paramViewGroup.titleTv = ((TextView)paramView.findViewById(a.f.wallet_order_info_title));
          if (!TextUtils.isEmpty(localPromotions.url)) {
            WalletOrderInfoOldUI.this.VRf.put(localPromotions.url, paramViewGroup.QbG);
          }
          paramView.setTag(paramViewGroup);
          break;
          paramView = View.inflate(WalletOrderInfoOldUI.this, a.g.wallet_order_info_promotions_item, null);
          paramViewGroup.wGP = ((CdnImageView)paramView.findViewById(a.f.wallet_order_info_logo));
          paramViewGroup.QbG = ((TextView)paramView.findViewById(a.f.wallet_order_info_btn));
          paramViewGroup.lDF = ((TextView)paramView.findViewById(a.f.wallet_order_info_name));
          paramViewGroup.VRF = ((CheckBox)paramView.findViewById(a.f.agree_wx_cb));
          if (!TextUtils.isEmpty(localPromotions.url)) {
            WalletOrderInfoOldUI.this.VRf.put(localPromotions.url, paramViewGroup.QbG);
          }
          paramView.setTag(paramViewGroup);
          break label298;
          paramViewGroup = (a)paramView.getTag();
          int i = 0;
          paramInt = i;
          if (localPromotions.type == paramViewGroup.type) {
            if (localPromotions.type == Orders.VHx)
            {
              paramInt = i;
              if (localPromotions.Avy != paramViewGroup.Avy) {}
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
          if (localPromotions.type == Orders.VHx)
          {
            if (localPromotions.Avy == 1)
            {
              paramView = View.inflate(WalletOrderInfoOldUI.this, a.g.wallet_order_info_promotions_activity_festival_item, null);
              paramViewGroup.wGP = ((CdnImageView)paramView.findViewById(a.f.wallet_order_info_logo));
              paramViewGroup.titleTv = ((TextView)paramView.findViewById(a.f.wallet_order_info_title));
              paramViewGroup.QbG = ((TextView)paramView.findViewById(a.f.wallet_order_info_btn));
              paramViewGroup.lDF = ((TextView)paramView.findViewById(a.f.wallet_order_info_name));
              if (!TextUtils.isEmpty(localPromotions.url)) {
                WalletOrderInfoOldUI.this.VRf.put(localPromotions.url, paramViewGroup.QbG);
              }
              paramView.setTag(paramViewGroup);
            }
            for (;;)
            {
              paramViewGroup.Avy = localPromotions.Avy;
              break;
              paramView = View.inflate(WalletOrderInfoOldUI.this, a.g.wallet_order_info_promotions_activity_item, null);
              paramViewGroup.wGP = ((CdnImageView)paramView.findViewById(a.f.wallet_order_info_logo));
              paramViewGroup.QbG = ((TextView)paramView.findViewById(a.f.wallet_order_info_btn));
              paramViewGroup.lDF = ((TextView)paramView.findViewById(a.f.wallet_order_info_name));
              paramViewGroup.titleTv = ((TextView)paramView.findViewById(a.f.wallet_order_info_title));
              if (!TextUtils.isEmpty(localPromotions.url)) {
                WalletOrderInfoOldUI.this.VRf.put(localPromotions.url, paramViewGroup.QbG);
              }
              paramView.setTag(paramViewGroup);
            }
          }
          paramView = View.inflate(WalletOrderInfoOldUI.this, a.g.wallet_order_info_promotions_item, null);
          paramViewGroup.wGP = ((CdnImageView)paramView.findViewById(a.f.wallet_order_info_logo));
          paramViewGroup.QbG = ((TextView)paramView.findViewById(a.f.wallet_order_info_btn));
          paramViewGroup.lDF = ((TextView)paramView.findViewById(a.f.wallet_order_info_name));
          paramViewGroup.VRF = ((CheckBox)paramView.findViewById(a.f.agree_wx_cb));
          if (!TextUtils.isEmpty(localPromotions.url)) {
            WalletOrderInfoOldUI.this.VRf.put(localPromotions.url, paramViewGroup.QbG);
          }
          paramView.setTag(paramViewGroup);
          break label298;
          paramViewGroup.wGP.setUrl(localPromotions.MRI);
          paramViewGroup.lDF.setText(localPromotions.name);
          paramViewGroup.QbG.setText(localPromotions.VGz);
          break label392;
          label1369:
          paramViewGroup.VRF.setChecked(false);
          break label455;
          label1380:
          paramViewGroup.QbG.setVisibility(0);
          if (paramViewGroup.VRF == null) {
            break label455;
          }
          paramViewGroup.VRF.setVisibility(8);
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
            paramViewGroup.QbG.setBackgroundDrawable(WalletOrderInfoOldUI.this.getResources().getDrawable(a.e.btn_style_hollow_green));
            paramViewGroup.QbG.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(a.c.wechat_green));
          }
          else if ((((String)localObject).equals("4")) || (((String)localObject).equals("2")) || (((String)localObject).equals("1")))
          {
            paramViewGroup.QbG.setBackgroundColor(WalletOrderInfoOldUI.this.getResources().getColor(a.c.transparent));
            paramViewGroup.QbG.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(a.c.hint_text_color));
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
      int Avy;
      TextView QbG;
      CheckBox VRF;
      TextView lDF;
      TextView titleTv;
      int type;
      CdnImageView wGP;
      
      a() {}
    }
  }
  
  final class d
  {
    public String Oks;
    public long VIF;
    public String VQV;
    public String VQW;
    public String VQX;
    public String Vyi;
    public String hMy;
    
    public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong)
    {
      this.Vyi = paramString1;
      this.VQV = paramString2;
      this.VQW = paramString3;
      this.VQX = paramString4;
      this.hMy = paramString5;
      this.Oks = paramString6;
      this.VIF = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI
 * JD-Core Version:    0.7.0.1
 */