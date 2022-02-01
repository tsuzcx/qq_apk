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
import com.tencent.mm.al.n;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView;
import com.tencent.mm.protocal.protobuf.csl;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import d.g.b.p;
import d.l;
import java.util.Arrays;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressNewUI;", "Lcom/tencent/mm/wallet_core/ui/WalletBaseUI;", "()V", "contentLayout", "Landroid/widget/LinearLayout;", "finishBtn", "Landroid/view/View;", "redeemFundRes", "Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;", "title", "Landroid/widget/TextView;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "redeemToString", "Companion", "plugin-wxpay_release"})
public final class WalletLqtSaveFetchFinishProgressNewUI
  extends WalletBaseUI
{
  public static final a CDI;
  private View CDG;
  private csl CDH;
  private TextView gnM;
  private LinearLayout nFH;
  
  static
  {
    AppMethodBeat.i(199378);
    CDI = new a((byte)0);
    AppMethodBeat.o(199378);
  }
  
  public final int getLayoutId()
  {
    return 2131496359;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(199377);
    Object localObject1 = findViewById(2131307863);
    p.g(localObject1, "findViewById(R.id.lqt_fetch_result_finish_title)");
    this.gnM = ((TextView)localObject1);
    localObject1 = this.CDH;
    if (localObject1 == null) {
      p.bcb("redeemFundRes");
    }
    Object localObject2;
    if (!bt.isNullOrNil(((csl)localObject1).HkQ))
    {
      localObject1 = this.CDH;
      if (localObject1 == null) {
        p.bcb("redeemFundRes");
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchFinishProgressNewUI", "redeemFundRes.pre_arrival_time_headline: %s", new Object[] { ((csl)localObject1).HkQ });
      localObject1 = this.gnM;
      if (localObject1 == null) {
        p.bcb("title");
      }
      localObject2 = this.CDH;
      if (localObject2 == null) {
        p.bcb("redeemFundRes");
      }
      ((TextView)localObject1).setText((CharSequence)((csl)localObject2).HkQ);
    }
    for (;;)
    {
      localObject1 = findViewById(2131307860);
      p.g(localObject1, "findViewById(R.id.lqt_fe…lt_finish_content_layout)");
      this.nFH = ((LinearLayout)localObject1);
      localObject1 = new WalletBalanceFetchResultItemView((Context)this, true);
      localObject2 = this.CDH;
      if (localObject2 == null) {
        p.bcb("redeemFundRes");
      }
      ((WalletBalanceFetchResultItemView)localObject1).b(2131765486, (CharSequence)e.D(((csl)localObject2).HeX / 100.0F));
      localObject2 = this.nFH;
      if (localObject2 == null) {
        p.bcb("contentLayout");
      }
      ((LinearLayout)localObject2).addView((View)localObject1);
      localObject1 = this.CDH;
      if (localObject1 == null) {
        p.bcb("redeemFundRes");
      }
      if (!bt.isNullOrNil(((csl)localObject1).uJF))
      {
        localObject1 = this.CDH;
        if (localObject1 == null) {
          p.bcb("redeemFundRes");
        }
        localObject2 = ((csl)localObject1).uJF;
        csl localcsl = this.CDH;
        if (localcsl == null) {
          p.bcb("redeemFundRes");
        }
        localObject1 = localObject2;
        if (!bt.isNullOrNil(localcsl.wCE))
        {
          localObject1 = new StringBuilder().append((String)localObject2).append(" (");
          localObject2 = this.CDH;
          if (localObject2 == null) {
            p.bcb("redeemFundRes");
          }
          localObject1 = ((csl)localObject2).wCE + ")";
        }
        localObject2 = new WalletBalanceFetchResultItemView((Context)this);
        ((WalletBalanceFetchResultItemView)localObject2).b(2131766845, (CharSequence)localObject1);
        localObject1 = this.nFH;
        if (localObject1 == null) {
          p.bcb("contentLayout");
        }
        ((LinearLayout)localObject1).addView((View)localObject2);
      }
      localObject1 = findViewById(2131307859);
      p.g(localObject1, "findViewById(R.id.lqt_fetch_result_finish_btn)");
      this.CDG = ((View)localObject1);
      localObject1 = this.CDG;
      if (localObject1 == null) {
        p.bcb("finishBtn");
      }
      ((View)localObject1).setOnClickListener((View.OnClickListener)new b(this));
      AppMethodBeat.o(199377);
      return;
      localObject1 = this.gnM;
      if (localObject1 == null) {
        p.bcb("title");
      }
      ((TextView)localObject1).setText((CharSequence)getString(2131757465));
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(199376);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      p.gfZ();
    }
    paramBundle.hide();
    showHomeBtn(false);
    enableBackMenu(false);
    setBackBtnVisible(false);
    this.mController.setStatusBarColor(getResources().getColor(2131101179));
    paramBundle = getIntent().getByteArrayExtra("key_redeem_res");
    this.CDH = new csl();
    try
    {
      localObject = this.CDH;
      if (localObject == null) {
        p.bcb("redeemFundRes");
      }
      ((csl)localObject).parseFrom(paramBundle);
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Object localObject;
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WalletLqtSaveFetchFinishProgressNewUI", (Throwable)paramBundle, "parse redeemFundRes error!", new Object[0]);
        finish();
        continue;
        paramBundle = "";
      }
    }
    paramBundle = this.CDH;
    if (paramBundle == null) {
      p.bcb("redeemFundRes");
    }
    if (paramBundle != null)
    {
      localObject = d.g.b.ad.MLZ;
      paramBundle = String.format("status:%s, wording_for_status2:%s, pre_arrive_time_wording:%s, redeem_fee:%s, bank_name:%s, card_tail:%s, failure_wording:%s", Arrays.copyOf(new Object[] { Integer.valueOf(paramBundle.status), paramBundle.HkN, paramBundle.HkO, Integer.valueOf(paramBundle.HeX), paramBundle.uJF, paramBundle.wCE, paramBundle.HkP }, 7));
      p.g(paramBundle, "java.lang.String.format(format, *args)");
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletLqtSaveFetchFinishProgressNewUI", "onCreate, redeemRes: %s", new Object[] { paramBundle });
      initView();
      g.yhR.f(20287, new Object[] { Integer.valueOf(8) });
      AppMethodBeat.o(199376);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressNewUI$Companion;", "", "()V", "TAG", "", "plugin-wxpay_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(WalletLqtSaveFetchFinishProgressNewUI paramWalletLqtSaveFetchFinishProgressNewUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199375);
      b localb = new b();
      localb.bd(paramView);
      a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressNewUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.CDJ.finish();
      a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressNewUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(199375);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishProgressNewUI
 * JD-Core Version:    0.7.0.1
 */