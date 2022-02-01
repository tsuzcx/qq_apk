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
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import d.g.b.k;
import d.g.b.z;
import d.l;
import java.util.Arrays;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressNewUI;", "Lcom/tencent/mm/wallet_core/ui/WalletBaseUI;", "()V", "contentLayout", "Landroid/widget/LinearLayout;", "finishBtn", "Landroid/view/View;", "redeemFundRes", "Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;", "title", "Landroid/widget/TextView;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "redeemToString", "Companion", "plugin-wxpay_release"})
public final class WalletLqtSaveFetchFinishProgressNewUI
  extends WalletBaseUI
{
  public static final WalletLqtSaveFetchFinishProgressNewUI.a Bdu;
  private View Bds;
  private cni Bdt;
  private TextView fUk;
  private LinearLayout nfl;
  
  static
  {
    AppMethodBeat.i(207334);
    Bdu = new WalletLqtSaveFetchFinishProgressNewUI.a((byte)0);
    AppMethodBeat.o(207334);
  }
  
  public final int getLayoutId()
  {
    return 2131496359;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(207333);
    Object localObject1 = findViewById(2131307863);
    k.g(localObject1, "findViewById(R.id.lqt_fetch_result_finish_title)");
    this.fUk = ((TextView)localObject1);
    localObject1 = this.Bdt;
    if (localObject1 == null) {
      k.aVY("redeemFundRes");
    }
    Object localObject2;
    if (!bs.isNullOrNil(((cni)localObject1).FAC))
    {
      localObject1 = this.Bdt;
      if (localObject1 == null) {
        k.aVY("redeemFundRes");
      }
      ac.i("MicroMsg.WalletLqtSaveFetchFinishProgressNewUI", "redeemFundRes.pre_arrival_time_headline: %s", new Object[] { ((cni)localObject1).FAC });
      localObject1 = this.fUk;
      if (localObject1 == null) {
        k.aVY("title");
      }
      localObject2 = this.Bdt;
      if (localObject2 == null) {
        k.aVY("redeemFundRes");
      }
      ((TextView)localObject1).setText((CharSequence)((cni)localObject2).FAC);
    }
    for (;;)
    {
      localObject1 = findViewById(2131307860);
      k.g(localObject1, "findViewById(R.id.lqt_fe…lt_finish_content_layout)");
      this.nfl = ((LinearLayout)localObject1);
      localObject1 = new WalletBalanceFetchResultItemView((Context)this, true);
      localObject2 = this.Bdt;
      if (localObject2 == null) {
        k.aVY("redeemFundRes");
      }
      ((WalletBalanceFetchResultItemView)localObject1).b(2131765486, (CharSequence)e.D(((cni)localObject2).FuS / 100.0F));
      localObject2 = this.nfl;
      if (localObject2 == null) {
        k.aVY("contentLayout");
      }
      ((LinearLayout)localObject2).addView((View)localObject1);
      localObject1 = this.Bdt;
      if (localObject1 == null) {
        k.aVY("redeemFundRes");
      }
      if (!bs.isNullOrNil(((cni)localObject1).tGS))
      {
        localObject1 = this.Bdt;
        if (localObject1 == null) {
          k.aVY("redeemFundRes");
        }
        localObject2 = ((cni)localObject1).tGS;
        cni localcni = this.Bdt;
        if (localcni == null) {
          k.aVY("redeemFundRes");
        }
        localObject1 = localObject2;
        if (!bs.isNullOrNil(localcni.vxk))
        {
          localObject1 = new StringBuilder().append((String)localObject2).append(" (");
          localObject2 = this.Bdt;
          if (localObject2 == null) {
            k.aVY("redeemFundRes");
          }
          localObject1 = ((cni)localObject2).vxk + ")";
        }
        localObject2 = new WalletBalanceFetchResultItemView((Context)this);
        ((WalletBalanceFetchResultItemView)localObject2).b(2131766845, (CharSequence)localObject1);
        localObject1 = this.nfl;
        if (localObject1 == null) {
          k.aVY("contentLayout");
        }
        ((LinearLayout)localObject1).addView((View)localObject2);
      }
      localObject1 = findViewById(2131307859);
      k.g(localObject1, "findViewById(R.id.lqt_fetch_result_finish_btn)");
      this.Bds = ((View)localObject1);
      localObject1 = this.Bds;
      if (localObject1 == null) {
        k.aVY("finishBtn");
      }
      ((View)localObject1).setOnClickListener((View.OnClickListener)new b(this));
      AppMethodBeat.o(207333);
      return;
      localObject1 = this.fUk;
      if (localObject1 == null) {
        k.aVY("title");
      }
      ((TextView)localObject1).setText((CharSequence)getString(2131757465));
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(207332);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      k.fOy();
    }
    paramBundle.hide();
    showHomeBtn(false);
    enableBackMenu(false);
    setBackBtnVisible(false);
    this.mController.setStatusBarColor(getResources().getColor(2131101179));
    paramBundle = getIntent().getByteArrayExtra("key_redeem_res");
    this.Bdt = new cni();
    try
    {
      localObject = this.Bdt;
      if (localObject == null) {
        k.aVY("redeemFundRes");
      }
      ((cni)localObject).parseFrom(paramBundle);
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Object localObject;
        ac.printErrStackTrace("MicroMsg.WalletLqtSaveFetchFinishProgressNewUI", (Throwable)paramBundle, "parse redeemFundRes error!", new Object[0]);
        finish();
        continue;
        paramBundle = "";
      }
    }
    paramBundle = this.Bdt;
    if (paramBundle == null) {
      k.aVY("redeemFundRes");
    }
    if (paramBundle != null)
    {
      localObject = z.KUT;
      paramBundle = String.format("status:%s, wording_for_status2:%s, pre_arrive_time_wording:%s, redeem_fee:%s, bank_name:%s, card_tail:%s, failure_wording:%s", Arrays.copyOf(new Object[] { Integer.valueOf(paramBundle.status), paramBundle.FAz, paramBundle.FAA, Integer.valueOf(paramBundle.FuS), paramBundle.tGS, paramBundle.vxk, paramBundle.FAB }, 7));
      k.g(paramBundle, "java.lang.String.format(format, *args)");
      ac.i("MicroMsg.WalletLqtSaveFetchFinishProgressNewUI", "onCreate, redeemRes: %s", new Object[] { paramBundle });
      initView();
      h.wUl.f(20287, new Object[] { Integer.valueOf(8) });
      AppMethodBeat.o(207332);
      return;
    }
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(WalletLqtSaveFetchFinishProgressNewUI paramWalletLqtSaveFetchFinishProgressNewUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(207331);
      this.Bdv.finish();
      AppMethodBeat.o(207331);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishProgressNewUI
 * JD-Core Version:    0.7.0.1
 */