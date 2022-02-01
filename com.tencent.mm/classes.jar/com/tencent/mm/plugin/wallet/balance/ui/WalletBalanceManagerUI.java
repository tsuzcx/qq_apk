package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.app.Dialog;
import android.arch.lifecycle.Lifecycle;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.g.a.zt.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ag;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.biu;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.JSONException;
import org.json.JSONObject;

public class WalletBalanceManagerUI
  extends WalletBaseUI
  implements l, MStorageEx.IOnStorageChange
{
  private static final String yQK;
  private IListener<lj> AJa;
  protected Button HvV;
  protected View HvW;
  protected TextView HvX;
  private ViewGroup HvY;
  private TextView HvZ;
  protected TextView Hvg;
  private ImageView Hwa;
  private WcPayMoneyLoadingView Hwb;
  protected Bankcard Hwc;
  private bj Hwd;
  private com.tencent.mm.plugin.wallet_core.model.h Hwe;
  private com.tencent.mm.plugin.wallet.balance.model.a Hwf;
  private ViewGroup Hwg;
  private CdnImageView Hwh;
  private TextView Hwi;
  private CdnImageView Hwj;
  private View Hwk;
  private TextView Hwl;
  protected int mScene;
  private ProgressBar zmU;
  
  static
  {
    AppMethodBeat.i(213909);
    yQK = "https://" + WeChatHosts.domainString(2131761715) + "/touch/scene_product.html?scene_id=kf4";
    AppMethodBeat.o(213909);
  }
  
  public WalletBalanceManagerUI()
  {
    AppMethodBeat.i(68663);
    this.AJa = new IListener() {};
    AppMethodBeat.o(68663);
  }
  
  private void a(w paramw)
  {
    AppMethodBeat.i(68665);
    if (paramw == null)
    {
      this.Hwg.setVisibility(8);
      AppMethodBeat.o(68665);
      return;
    }
    label82:
    GradientDrawable localGradientDrawable;
    if (!Util.isNullOrNil(paramw.Ibd))
    {
      this.Hwh.setUrl(paramw.Ibd);
      this.Hwh.setVisibility(0);
      if (Util.isNullOrNil(paramw.Ibe)) {
        break label257;
      }
      this.Hwj.setUrl(paramw.Ibe);
      this.Hwj.setVisibility(0);
      this.Hwi.setText(paramw.dQx);
      if (!Util.isNullOrNil(paramw.Iba))
      {
        if (!com.tencent.mm.ui.ao.isDarkMode()) {
          break label269;
        }
        this.Hwi.setTextColor(com.tencent.mm.ui.ao.hT(Util.getHex(paramw.Iba, -16777216)));
      }
      label128:
      this.Hwi.setTextSize(1, paramw.Ibb);
      if (!Util.isNullOrNil(paramw.DWN))
      {
        localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setShape(0);
        if (!com.tencent.mm.ui.ao.isDarkMode()) {
          break label288;
        }
        localGradientDrawable.setColor(com.tencent.mm.ui.ao.hT(Util.getHex(paramw.DWN, -1)));
      }
    }
    for (;;)
    {
      localGradientDrawable.setCornerRadius(com.tencent.mm.cb.a.fromDPToPix(getContext(), 4));
      this.Hwg.setBackground(localGradientDrawable);
      this.Hwg.setVisibility(0);
      this.Hwg.setOnClickListener(new WalletBalanceManagerUI.9(this, paramw));
      this.HvY.setVisibility(8);
      AppMethodBeat.o(68665);
      return;
      this.Hwh.setVisibility(8);
      break;
      label257:
      this.Hwj.setVisibility(8);
      break label82;
      label269:
      this.Hwi.setTextColor(Util.getHex(paramw.Iba, -16777216));
      break label128;
      label288:
      localGradientDrawable.setColor(Util.getHex(paramw.DWN, -1));
    }
  }
  
  private static boolean fNq()
  {
    AppMethodBeat.i(68675);
    s.fOg();
    boolean bool = s.fOh().fRs().fNq();
    AppMethodBeat.o(68675);
    return bool;
  }
  
  private static boolean isOverseasUser()
  {
    AppMethodBeat.i(163863);
    if (!LocaleUtil.getApplicationLanguage().equals("zh_CN"))
    {
      AppMethodBeat.o(163863);
      return true;
    }
    boolean bool = Util.isOverseasUser(MMApplicationContext.getContext());
    AppMethodBeat.o(163863);
    return bool;
  }
  
  private void xL(boolean paramBoolean)
  {
    AppMethodBeat.i(68672);
    long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.OfA, Long.valueOf(0L))).longValue();
    WcPayMoneyLoadingView localWcPayMoneyLoadingView = this.Hwb;
    String str = com.tencent.mm.wallet_core.ui.f.formatMoney2f(com.tencent.mm.wallet_core.ui.f.b(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue());
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localWcPayMoneyLoadingView.cH(str, paramBoolean);
      AppMethodBeat.o(68672);
      return;
    }
  }
  
  protected void fNn()
  {
    AppMethodBeat.i(68666);
    s.fOg();
    if (s.fOh().Hwc == null) {}
    for (boolean bool = true;; bool = false)
    {
      doSceneProgress(new ad(null, 10), bool);
      AppMethodBeat.o(68666);
      return;
    }
  }
  
  protected void fNo()
  {
    AppMethodBeat.i(68668);
    startActivity(WalletBalanceSaveUI.class);
    AppMethodBeat.o(68668);
  }
  
  protected final void fNp()
  {
    AppMethodBeat.i(163864);
    removeAllOptionMenu();
    Log.i("MicroMsg.WalletBalanceManagerUI", "go old menu logic");
    Object localObject1;
    if (this.Hwc != null)
    {
      s.fOg();
      s.fOh();
      if (!Util.isNullOrNil(this.Hwc.HVF))
      {
        localObject1 = getString(2131767448);
        if (!Util.isNullOrNil(this.Hwc.HVH))
        {
          Log.i("MicroMsg.WalletBalanceManagerUI", "entry_word：%s", new Object[] { this.Hwc.HVH });
          localObject1 = this.Hwc.HVH;
        }
        addTextOptionMenu(0, (String)localObject1, new WalletBalanceManagerUI.3(this), t.b.OHd);
      }
    }
    if ((this.Hwl == null) || (this.Hwk == null) || (isFinishing()) || (isDestroyed()))
    {
      Log.i("MicroMsg.WalletBalanceManagerUI", "accountUpdateServiceTv == null || marginLine == null || WalletBalanceManagerUI.this.isFinishing()|| WalletBalanceManagerUI.this.isDestroyed()：%s，%s", new Object[] { Boolean.valueOf(isFinishing()), Boolean.valueOf(isDestroyed()) });
      AppMethodBeat.o(163864);
      return;
    }
    WalletBalanceManagerUI.a locala = new WalletBalanceManagerUI.a((byte)0);
    b localb = new b((byte)0);
    for (;;)
    {
      try
      {
        localObject1 = (String)((com.tencent.mm.plugin.wxpay.a.a)g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.OeQ, null);
        if (Util.isNullOrNil((String)localObject1)) {
          break label648;
        }
        Object localObject2 = new JSONObject((String)localObject1);
        boolean bool1 = ((JSONObject)localObject2).optBoolean("is_exposure", false);
        this.Hwl.setVisibility(8);
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          localObject1 = ((JSONObject)localObject2).optString("jump_info");
          localObject2 = ((JSONObject)localObject2).optString("wording_item");
          if (!Util.isNullOrNil((String)localObject1))
          {
            localObject1 = new JSONObject((String)localObject1);
            locala.uSc = ((JSONObject)localObject1).optInt("type", 0);
            locala.pTL = ((JSONObject)localObject1).optString("url");
            locala.Hwr = ((JSONObject)localObject1).optString("mini_username");
            locala.Hws = ((JSONObject)localObject1).optString("mini_pagepath");
          }
          bool2 = bool1;
          if (!Util.isNullOrNil((String)localObject2))
          {
            localObject1 = new JSONObject((String)localObject2);
            localb.dQx = ((JSONObject)localObject1).optString("wording");
            localb.color = ((JSONObject)localObject1).optInt("color", -1);
            localb.Hwt = ((JSONObject)localObject1).optInt("dark_color", -1);
            bool2 = bool1;
          }
          if (!bool2) {
            break label619;
          }
          Log.i("MicroMsg.WalletBalanceManagerUI", "show Lqt ServceEntrance");
          com.tencent.mm.wallet_core.ui.f.aqm(45);
          if (localb.dQx != null) {
            this.Hwl.setText(localb.dQx);
          }
          if (com.tencent.mm.ui.ao.isDarkMode()) {
            continue;
          }
          if (localb.color != -1) {
            continue;
          }
          this.Hwl.setTextColor(getResources().getColor(2131100685));
          this.Hwl.setOnClickListener(new WalletBalanceManagerUI.8(this, locala));
          this.Hwl.setVisibility(0);
          com.tencent.mm.wallet_core.ui.f.G(this.Hwl);
          if (isOverseasUser()) {
            continue;
          }
          this.Hwk.setVisibility(0);
          AppMethodBeat.o(163864);
          return;
        }
        catch (JSONException localJSONException2)
        {
          continue;
        }
        localJSONException1 = localJSONException1;
        bool1 = false;
        Log.printErrStackTrace("MicroMsg.WalletBalanceManagerUI", localJSONException1, "", new Object[0]);
        bool2 = bool1;
        continue;
        this.Hwl.setTextColor(localb.color);
        continue;
        if (localb.Hwt == -1)
        {
          this.Hwl.setTextColor(getResources().getColor(2131100685));
          continue;
        }
        this.Hwl.setTextColor(localb.Hwt);
        continue;
        this.Hwk.setVisibility(8);
        AppMethodBeat.o(163864);
        return;
      }
      label619:
      this.Hwk.setVisibility(8);
      AppMethodBeat.o(163864);
      return;
      label648:
      boolean bool2 = false;
    }
  }
  
  public int getLayoutId()
  {
    return 2131496881;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68669);
    setMMTitle("");
    this.Hwb = ((WcPayMoneyLoadingView)findViewById(2131310126));
    this.zmU = ((ProgressBar)findViewById(2131310218));
    this.Hvg = ((TextView)findViewById(2131310112));
    this.Hwb.setLoadingPb(this.zmU);
    this.Hwb.setPrefixSymbol(getString(2131768266));
    getLifecycle().addObserver(this.Hwb);
    ((Button)findViewById(2131305423)).setOnClickListener(new WalletBalanceManagerUI.11(this));
    this.HvV = ((Button)findViewById(2131310113));
    this.HvV.setOnClickListener(new WalletBalanceManagerUI.12(this));
    this.Hwk = findViewById(2131310114);
    this.Hwl = ((TextView)findViewById(2131310111));
    Object localObject = (TextView)findViewById(2131310115);
    if (!isOverseasUser())
    {
      ((TextView)localObject).setOnClickListener(new WalletBalanceManagerUI.13(this));
      ((TextView)localObject).setVisibility(0);
      com.tencent.mm.wallet_core.ui.f.G((TextView)localObject);
    }
    for (;;)
    {
      ((TextView)findViewById(2131310295)).setText(com.tencent.mm.wallet_core.c.ah.hhy());
      this.HvY = ((ViewGroup)findViewById(2131297232));
      this.HvZ = ((TextView)findViewById(2131297233));
      this.Hwa = ((ImageView)findViewById(2131297231));
      this.HvW = findViewById(2131303158);
      this.HvX = ((TextView)findViewById(2131303159));
      this.Hwg = ((ViewGroup)findViewById(2131297242));
      this.Hwi = ((TextView)findViewById(2131297240));
      this.Hwh = ((CdnImageView)findViewById(2131297241));
      this.Hwj = ((CdnImageView)findViewById(2131297239));
      localObject = new zt();
      ((zt)localObject).efM.scene = "2";
      ((zt)localObject).callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(68660);
          if (!Util.isNullOrNil(this.qBN.efN.efO)) {
            com.tencent.mm.wallet_core.ui.f.a(WalletBalanceManagerUI.this.Hvg, this.qBN.efN.efO, this.qBN.efN.content, this.qBN.efN.url);
          }
          AppMethodBeat.o(68660);
        }
      };
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(68669);
      return;
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  protected final void is(boolean paramBoolean)
  {
    AppMethodBeat.i(68673);
    xL(paramBoolean);
    s.fOg();
    this.Hwc = s.fOh().Hwc;
    if (this.Hwc != null)
    {
      if (!fNq()) {
        break label227;
      }
      this.HvV.setVisibility(0);
      if (((Long)((com.tencent.mm.plugin.wxpay.a.a)g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.OfA, Long.valueOf(0L))).longValue() <= 0L) {
        this.HvV.setEnabled(false);
      }
    }
    Object localObject = findViewById(2131303991);
    g.aAi();
    if (((Integer)g.aAh().azQ().get(ar.a.OcP, Integer.valueOf(-1))).intValue() == 1) {
      ((View)localObject).setVisibility(0);
    }
    for (;;)
    {
      if (!new al().fRg()) {
        break label248;
      }
      g.aAi();
      localObject = (String)g.aAh().azQ().get(ar.a.NXy, getString(2131764227));
      this.HvW.setVisibility(0);
      this.HvX.setTextColor(getResources().getColor(2131101343));
      this.HvX.setText((CharSequence)localObject);
      this.HvW.setOnClickListener(new WalletBalanceManagerUI.15(this));
      AppMethodBeat.o(68673);
      return;
      label227:
      this.HvV.setVisibility(8);
      break;
      ((View)localObject).setVisibility(8);
    }
    label248:
    s.fOg();
    if (s.fOh().fRT() == 1) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      s.fOg();
      localObject = s.fOh().fRU();
      s.fOg();
      String str = s.fOh().fRV();
      Log.i("MicroMsg.WalletBalanceManagerUI", "isShowLqtCell:%s lqtCellTitle:%s lqtCellWording:%s", new Object[] { Boolean.valueOf(paramBoolean), localObject, str });
      if ((!paramBoolean) || ((Util.isNullOrNil((String)localObject)) && (Util.isNullOrNil(str)))) {
        break;
      }
      this.HvW.setVisibility(8);
      AppMethodBeat.o(68673);
      return;
    }
    s.fOg();
    if (s.fOh().fRz())
    {
      s.fOg();
      if (!Util.isNullOrNil(s.fOh().fRv()))
      {
        this.HvW.setVisibility(0);
        this.HvW.setOnClickListener(new WalletBalanceManagerUI.16(this));
        localObject = this.HvX;
        s.fOg();
        ((TextView)localObject).setText(s.fOh().fRv());
        AppMethodBeat.o(68673);
        return;
      }
    }
    s.fOg();
    localObject = s.fOh();
    if ((localObject != null) && (((an)localObject).fRs().fRb()) && (!TextUtils.isEmpty(((an)localObject).fRv())) && (!TextUtils.isEmpty(((an)localObject).fRw())))
    {
      this.HvW.setVisibility(0);
      this.HvX.setText(((an)localObject).fRv());
      this.HvW.setOnClickListener(new WalletBalanceManagerUI.2(this, (an)localObject));
      AppMethodBeat.o(68673);
      return;
    }
    this.HvW.setVisibility(8);
    AppMethodBeat.o(68673);
  }
  
  public final void j(int paramInt, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(68677);
    if ((paramInt != 12) && (paramInt == 43) && (paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {
      a((w)paramArrayOfObject[0]);
    }
    AppMethodBeat.o(68677);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68664);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    ((com.tencent.mm.plugin.wxpay.a.a)g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().add(this);
    setActionbarColor(getResources().getColor(2131101424));
    hideActionbarLine();
    ((com.tencent.mm.plugin.walletlock.a.b)g.af(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(68645);
        if (WalletBalanceManagerUI.a(WalletBalanceManagerUI.this))
        {
          WalletBalanceManagerUI.this.hideVKB();
          WalletBalanceManagerUI.this.showDialog(1000);
        }
        for (;;)
        {
          AppMethodBeat.o(68645);
          return true;
          WalletBalanceManagerUI.this.finish();
        }
      }
    }, 2131689492);
    this.mScene = getIntent().getIntExtra("key_scene_balance_manager", 0);
    paramBundle = ECardInfo.fQp();
    if (paramBundle != null)
    {
      if (paramBundle.KCl != 1) {
        break label240;
      }
      paramBundle = new Bundle();
      isTransparent();
      com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramBundle, null, 0);
    }
    for (;;)
    {
      addSceneEndListener(621);
      t.fQP();
      com.tencent.mm.plugin.wallet_core.model.ah.a(this);
      initView();
      ab.mg(2, 0);
      com.tencent.mm.plugin.report.service.h.CyF.a(11850, new Object[] { Integer.valueOf(6), Integer.valueOf(0) });
      com.tencent.mm.wallet_core.ui.f.aqm(10);
      a(w.ba(XmlParser.parseXml((String)((com.tencent.mm.plugin.wxpay.a.a)g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.Ofy, ""), "sysmsg", null)));
      AppMethodBeat.o(68664);
      return;
      label240:
      if (paramBundle.KCl == 3)
      {
        paramBundle = ECardInfo.fQq();
        if (paramBundle != null) {
          com.tencent.mm.plugin.wallet_core.ui.o.a(this, paramBundle, 1);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68667);
    removeSceneEndListener(621);
    t.fQP();
    com.tencent.mm.plugin.wallet_core.model.ah.b(this);
    ((com.tencent.mm.plugin.wxpay.a.a)g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().remove(this);
    if (this.Hwf != null) {
      this.Hwf.cancel();
    }
    this.Hwf = null;
    super.onDestroy();
    AppMethodBeat.o(68667);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(68678);
    Log.i("MicroMsg.WalletBalanceManagerUI", "jumpFethProcess from bind ui flag:" + paramIntent.getIntExtra("from_bind_ui", 0));
    if (paramIntent.getIntExtra("from_bind_ui", 0) == com.tencent.mm.plugin.wallet.balance.a.HsP)
    {
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.b.class, null, null);
      com.tencent.mm.wallet_core.ui.f.aqm(15);
    }
    AppMethodBeat.o(68678);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(68679);
    if ((paramMStorageEx == ((com.tencent.mm.plugin.wxpay.a.a)g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg()) && (paramInt == 4))
    {
      Log.i("MicroMsg.WalletBalanceManagerUI", "on cache update: %s", new Object[] { paramObject });
      if (paramObject.equals("USERINFO_NEW_BALANCE_LONG")) {
        xL(false);
      }
    }
    AppMethodBeat.o(68679);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68671);
    super.onPause();
    this.Hwb.reset();
    AppMethodBeat.o(68671);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68670);
    is(true);
    fNn();
    Log.i("MicroMsg.WalletBalanceManagerUI", "do query balance menu");
    if (this.Hwf != null) {
      this.Hwf.cancel();
    }
    this.Hwf = new com.tencent.mm.plugin.wallet.balance.model.a();
    this.Hwf.aYI().b(new com.tencent.mm.vending.c.a() {});
    super.onResume();
    com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)g.af(com.tencent.mm.plugin.walletlock.a.b.class);
    localb.a(this, localb.fUE(), null);
    AppMethodBeat.o(68670);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(68676);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (!(paramq instanceof com.tencent.mm.plugin.wallet.bind.a.b)) && ((paramq instanceof ad)))
    {
      this.Hwe = ((ad)paramq).HQo;
      if ((this.Hwe == null) || (this.Hwg.isShown())) {
        break label191;
      }
      if (Util.isNullOrNil(this.Hwe.dQx)) {
        break label179;
      }
      this.HvZ.setText(this.Hwe.dQx);
      if (!Util.isNullOrNil(this.Hwe.ixw))
      {
        this.HvZ.setTextColor(Color.parseColor(this.Hwe.ixw));
        this.Hwa.getDrawable().setColorFilter(Color.parseColor(this.Hwe.ixw), PorterDuff.Mode.SRC_ATOP);
      }
      this.HvY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(163858);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          Log.i("MicroMsg.WalletBalanceManagerUI", "click action entry");
          if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).type == 1)
          {
            if (Util.isNullOrNil(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).HWM))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(163858);
              return;
            }
            if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).HWM.startsWith("weixin://wcpay/lqt/detail"))
            {
              ag.parseUrl(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).HWM);
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_account_type", 1);
              c.b(WalletBalanceManagerUI.this.getContext(), "wallet", ".balance.ui.lqt.WalletLqtDetailUI", paramAnonymousView);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(163858);
            return;
            if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).HWM.startsWith("weixin://wcpay/lqt/save"))
            {
              ag.parseUrl(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).HWM);
              paramAnonymousView = ag.aUI(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).HWM);
              localObject = com.tencent.mm.wallet_core.ui.h.c(WalletBalanceManagerUI.this.getContext(), false, null);
              new com.tencent.mm.plugin.wallet.balance.model.lqt.o().aYI().b(new com.tencent.mm.vending.c.a() {});
              continue;
              if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).type == 2) {
                com.tencent.mm.wallet_core.ui.f.o(WalletBalanceManagerUI.this.getContext(), WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).qHg, true);
              } else if (WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).type == 3) {
                com.tencent.mm.wallet_core.ui.f.u(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).HWN, WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).HWO, 0, 1061);
              } else {
                Log.w("MicroMsg.WalletBalanceManagerUI", "unknown type: %s", new Object[] { Integer.valueOf(WalletBalanceManagerUI.e(WalletBalanceManagerUI.this).type) });
              }
            }
          }
        }
      });
      this.HvY.setVisibility(0);
    }
    for (;;)
    {
      is(false);
      fNp();
      AppMethodBeat.o(68676);
      return false;
      label179:
      this.HvY.setVisibility(8);
      continue;
      label191:
      this.HvY.setVisibility(8);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class b
  {
    public int Hwt;
    public int color;
    public String dQx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI
 * JD-Core Version:    0.7.0.1
 */