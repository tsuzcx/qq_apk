package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView;
import com.tencent.mm.protocal.protobuf.dlv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.t;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressNewUI;", "Lcom/tencent/mm/wallet_core/ui/WalletBaseUI;", "()V", "contentLayout", "Landroid/widget/LinearLayout;", "finishBtn", "Landroid/view/View;", "redeemFundRes", "Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;", "title", "Landroid/widget/TextView;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "redeemToString", "Companion", "plugin-wxpay_release"})
public final class WalletLqtSaveFetchFinishProgressNewUI
  extends WalletBaseUI
{
  public static final WalletLqtSaveFetchFinishProgressNewUI.a HAy;
  private View HAw;
  private dlv HAx;
  private TextView hbb;
  private LinearLayout oVX;
  
  static
  {
    AppMethodBeat.i(212686);
    HAy = new WalletLqtSaveFetchFinishProgressNewUI.a((byte)0);
    AppMethodBeat.o(212686);
  }
  
  public final int getLayoutId()
  {
    return 2131495340;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(212685);
    Object localObject1 = findViewById(2131303964);
    p.g(localObject1, "findViewById(R.id.lqt_fetch_result_finish_title)");
    this.hbb = ((TextView)localObject1);
    localObject1 = this.HAx;
    if (localObject1 == null) {
      p.btv("redeemFundRes");
    }
    Object localObject2;
    if (!Util.isNullOrNil(((dlv)localObject1).MPy))
    {
      localObject1 = this.HAx;
      if (localObject1 == null) {
        p.btv("redeemFundRes");
      }
      Log.i("MicroMsg.WalletLqtSaveFetchFinishProgressNewUI", "redeemFundRes.pre_arrival_time_headline: %s", new Object[] { ((dlv)localObject1).MPy });
      localObject1 = this.hbb;
      if (localObject1 == null) {
        p.btv("title");
      }
      localObject2 = this.HAx;
      if (localObject2 == null) {
        p.btv("redeemFundRes");
      }
      ((TextView)localObject1).setText((CharSequence)((dlv)localObject2).MPy);
    }
    for (;;)
    {
      localObject1 = findViewById(2131303961);
      p.g(localObject1, "findViewById(R.id.lqt_fe…lt_finish_content_layout)");
      this.oVX = ((LinearLayout)localObject1);
      localObject1 = new WalletBalanceFetchResultItemView((Context)this, true);
      localObject2 = this.HAx;
      if (localObject2 == null) {
        p.btv("redeemFundRes");
      }
      ((WalletBalanceFetchResultItemView)localObject1).b(2131767935, (CharSequence)f.D(((dlv)localObject2).MJd / 100.0F));
      localObject2 = this.oVX;
      if (localObject2 == null) {
        p.btv("contentLayout");
      }
      ((LinearLayout)localObject2).addView((View)localObject1);
      localObject1 = this.HAx;
      if (localObject1 == null) {
        p.btv("redeemFundRes");
      }
      if (!Util.isNullOrNil(((dlv)localObject1).ynT))
      {
        localObject1 = this.HAx;
        if (localObject1 == null) {
          p.btv("redeemFundRes");
        }
        localObject2 = ((dlv)localObject1).ynT;
        dlv localdlv = this.HAx;
        if (localdlv == null) {
          p.btv("redeemFundRes");
        }
        localObject1 = localObject2;
        if (!Util.isNullOrNil(localdlv.AOk))
        {
          localObject1 = new StringBuilder().append((String)localObject2).append(" (");
          localObject2 = this.HAx;
          if (localObject2 == null) {
            p.btv("redeemFundRes");
          }
          localObject1 = ((dlv)localObject2).AOk + ")";
        }
        localObject2 = new WalletBalanceFetchResultItemView((Context)this);
        ((WalletBalanceFetchResultItemView)localObject2).b(2131767853, (CharSequence)localObject1);
        localObject1 = this.oVX;
        if (localObject1 == null) {
          p.btv("contentLayout");
        }
        ((LinearLayout)localObject1).addView((View)localObject2);
      }
      localObject1 = findViewById(2131303960);
      p.g(localObject1, "findViewById(R.id.lqt_fetch_result_finish_btn)");
      this.HAw = ((View)localObject1);
      localObject1 = this.HAw;
      if (localObject1 == null) {
        p.btv("finishBtn");
      }
      ((View)localObject1).setOnClickListener((View.OnClickListener)new WalletLqtSaveFetchFinishProgressNewUI.b(this));
      AppMethodBeat.o(212685);
      return;
      localObject1 = this.hbb;
      if (localObject1 == null) {
        p.btv("title");
      }
      ((TextView)localObject1).setText((CharSequence)getString(2131757684));
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(212684);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      p.hyc();
    }
    paramBundle.hide();
    showHomeBtn(false);
    enableBackMenu(false);
    setBackBtnVisible(false);
    this.mController.setStatusBarColor(getResources().getColor(2131101424));
    paramBundle = getIntent().getByteArrayExtra("key_redeem_res");
    this.HAx = new dlv();
    try
    {
      localObject = this.HAx;
      if (localObject == null) {
        p.btv("redeemFundRes");
      }
      ((dlv)localObject).parseFrom(paramBundle);
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Object localObject;
        Log.printErrStackTrace("MicroMsg.WalletLqtSaveFetchFinishProgressNewUI", (Throwable)paramBundle, "parse redeemFundRes error!", new Object[0]);
        finish();
        continue;
        paramBundle = "";
      }
    }
    paramBundle = this.HAx;
    if (paramBundle == null) {
      p.btv("redeemFundRes");
    }
    if (paramBundle != null)
    {
      localObject = ae.SYK;
      paramBundle = String.format("status:%s, wording_for_status2:%s, pre_arrive_time_wording:%s, redeem_fee:%s, bank_name:%s, card_tail:%s, failure_wording:%s", Arrays.copyOf(new Object[] { Integer.valueOf(paramBundle.status), paramBundle.MPv, paramBundle.MPw, Integer.valueOf(paramBundle.MJd), paramBundle.ynT, paramBundle.AOk, paramBundle.MPx }, 7));
      p.g(paramBundle, "java.lang.String.format(format, *args)");
      Log.i("MicroMsg.WalletLqtSaveFetchFinishProgressNewUI", "onCreate, redeemRes: %s", new Object[] { paramBundle });
      initView();
      h.CyF.a(20287, new Object[] { Integer.valueOf(8) });
      AppMethodBeat.o(212684);
      return;
    }
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishProgressNewUI
 * JD-Core Version:    0.7.0.1
 */