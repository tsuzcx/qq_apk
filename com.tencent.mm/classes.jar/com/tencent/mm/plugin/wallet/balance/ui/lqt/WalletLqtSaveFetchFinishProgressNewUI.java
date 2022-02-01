package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.dvn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import java.util.Arrays;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressNewUI;", "Lcom/tencent/mm/wallet_core/ui/WalletBaseUI;", "()V", "contentLayout", "Landroid/widget/LinearLayout;", "finishBtn", "Landroid/view/View;", "redeemFundRes", "Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;", "title", "Landroid/widget/TextView;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "redeemToString", "Companion", "plugin-wxpay_release"})
public final class WalletLqtSaveFetchFinishProgressNewUI
  extends WalletBaseUI
{
  public static final a Oso;
  private dvn Osn;
  private TextView jMg;
  private LinearLayout rXW;
  private View sYa;
  
  static
  {
    AppMethodBeat.i(212968);
    Oso = new a((byte)0);
    AppMethodBeat.o(212968);
  }
  
  public final int getLayoutId()
  {
    return a.g.lqt_plan_fetch_result_new_ui;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(212960);
    Object localObject1 = findViewById(a.f.lqt_fetch_result_finish_title);
    p.j(localObject1, "findViewById(R.id.lqt_fetch_result_finish_title)");
    this.jMg = ((TextView)localObject1);
    localObject1 = this.Osn;
    if (localObject1 == null) {
      p.bGy("redeemFundRes");
    }
    Object localObject2;
    if (!Util.isNullOrNil(((dvn)localObject1).UbC))
    {
      localObject1 = this.Osn;
      if (localObject1 == null) {
        p.bGy("redeemFundRes");
      }
      Log.i("MicroMsg.WalletLqtSaveFetchFinishProgressNewUI", "redeemFundRes.pre_arrival_time_headline: %s", new Object[] { ((dvn)localObject1).UbC });
      localObject1 = this.jMg;
      if (localObject1 == null) {
        p.bGy("title");
      }
      localObject2 = this.Osn;
      if (localObject2 == null) {
        p.bGy("redeemFundRes");
      }
      ((TextView)localObject1).setText((CharSequence)((dvn)localObject2).UbC);
    }
    for (;;)
    {
      localObject1 = findViewById(a.f.lqt_fetch_result_finish_content_layout);
      p.j(localObject1, "findViewById(R.id.lqt_fe…lt_finish_content_layout)");
      this.rXW = ((LinearLayout)localObject1);
      localObject1 = new WalletBalanceFetchResultItemView((Context)this, true);
      int i = a.i.wallet_lqt_result_total_fee_fetch;
      localObject2 = this.Osn;
      if (localObject2 == null) {
        p.bGy("redeemFundRes");
      }
      ((WalletBalanceFetchResultItemView)localObject1).b(i, (CharSequence)g.F(((dvn)localObject2).TUS / 100.0F));
      localObject2 = this.rXW;
      if (localObject2 == null) {
        p.bGy("contentLayout");
      }
      ((LinearLayout)localObject2).addView((View)localObject1);
      localObject1 = this.Osn;
      if (localObject1 == null) {
        p.bGy("redeemFundRes");
      }
      if (!Util.isNullOrNil(((dvn)localObject1).DNV))
      {
        localObject1 = this.Osn;
        if (localObject1 == null) {
          p.bGy("redeemFundRes");
        }
        localObject2 = ((dvn)localObject1).DNV;
        dvn localdvn = this.Osn;
        if (localdvn == null) {
          p.bGy("redeemFundRes");
        }
        localObject1 = localObject2;
        if (!Util.isNullOrNil(localdvn.GHy))
        {
          localObject1 = new StringBuilder().append((String)localObject2).append(" (");
          localObject2 = this.Osn;
          if (localObject2 == null) {
            p.bGy("redeemFundRes");
          }
          localObject1 = ((dvn)localObject2).GHy + ")";
        }
        localObject2 = new WalletBalanceFetchResultItemView((Context)this);
        ((WalletBalanceFetchResultItemView)localObject2).b(a.i.wallet_lqt_fetch_progress_account_new_tips, (CharSequence)localObject1);
        localObject1 = this.rXW;
        if (localObject1 == null) {
          p.bGy("contentLayout");
        }
        ((LinearLayout)localObject1).addView((View)localObject2);
      }
      localObject1 = findViewById(a.f.lqt_fetch_result_finish_btn);
      p.j(localObject1, "findViewById(R.id.lqt_fetch_result_finish_btn)");
      this.sYa = ((View)localObject1);
      localObject1 = this.sYa;
      if (localObject1 == null) {
        p.bGy("finishBtn");
      }
      ((View)localObject1).setOnClickListener((View.OnClickListener)new b(this));
      AppMethodBeat.o(212960);
      return;
      localObject1 = this.jMg;
      if (localObject1 == null) {
        p.bGy("title");
      }
      ((TextView)localObject1).setText((CharSequence)getString(a.i.collect_main_fixed_cancel));
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(212955);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      p.iCn();
    }
    paramBundle.hide();
    showHomeBtn(false);
    enableBackMenu(false);
    setBackBtnVisible(false);
    this.mController.setStatusBarColor(getResources().getColor(a.c.white));
    paramBundle = getIntent().getByteArrayExtra("key_redeem_res");
    this.Osn = new dvn();
    try
    {
      localObject = this.Osn;
      if (localObject == null) {
        p.bGy("redeemFundRes");
      }
      ((dvn)localObject).parseFrom(paramBundle);
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
    paramBundle = this.Osn;
    if (paramBundle == null) {
      p.bGy("redeemFundRes");
    }
    if (paramBundle != null)
    {
      localObject = af.aaBG;
      paramBundle = String.format("status:%s, wording_for_status2:%s, pre_arrive_time_wording:%s, redeem_fee:%s, bank_name:%s, card_tail:%s, failure_wording:%s", Arrays.copyOf(new Object[] { Integer.valueOf(paramBundle.status), paramBundle.Ubz, paramBundle.UbA, Integer.valueOf(paramBundle.TUS), paramBundle.DNV, paramBundle.GHy, paramBundle.UbB }, 7));
      p.j(paramBundle, "java.lang.String.format(format, *args)");
      Log.i("MicroMsg.WalletLqtSaveFetchFinishProgressNewUI", "onCreate, redeemRes: %s", new Object[] { paramBundle });
      initView();
      h.IzE.a(20287, new Object[] { Integer.valueOf(8) });
      AppMethodBeat.o(212955);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressNewUI$Companion;", "", "()V", "TAG", "", "plugin-wxpay_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(WalletLqtSaveFetchFinishProgressNewUI paramWalletLqtSaveFetchFinishProgressNewUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(186596);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressNewUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.Osp.finish();
      a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressNewUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(186596);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishProgressNewUI
 * JD-Core Version:    0.7.0.1
 */