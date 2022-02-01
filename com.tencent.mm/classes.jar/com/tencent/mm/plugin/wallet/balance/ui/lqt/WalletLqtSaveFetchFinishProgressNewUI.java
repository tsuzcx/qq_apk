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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView;
import com.tencent.mm.protocal.protobuf.ctf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import d.g.b.ad;
import d.g.b.p;
import d.l;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressNewUI;", "Lcom/tencent/mm/wallet_core/ui/WalletBaseUI;", "()V", "contentLayout", "Landroid/widget/LinearLayout;", "finishBtn", "Landroid/view/View;", "redeemFundRes", "Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;", "title", "Landroid/widget/TextView;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "redeemToString", "Companion", "plugin-wxpay_release"})
public final class WalletLqtSaveFetchFinishProgressNewUI
  extends WalletBaseUI
{
  public static final WalletLqtSaveFetchFinishProgressNewUI.a CVo;
  private View CVm;
  private ctf CVn;
  private TextView gqi;
  private LinearLayout nLc;
  
  static
  {
    AppMethodBeat.i(190265);
    CVo = new WalletLqtSaveFetchFinishProgressNewUI.a((byte)0);
    AppMethodBeat.o(190265);
  }
  
  public final int getLayoutId()
  {
    return 2131496359;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(190264);
    Object localObject1 = findViewById(2131307863);
    p.g(localObject1, "findViewById(R.id.lqt_fetch_result_finish_title)");
    this.gqi = ((TextView)localObject1);
    localObject1 = this.CVn;
    if (localObject1 == null) {
      p.bdF("redeemFundRes");
    }
    Object localObject2;
    if (!bu.isNullOrNil(((ctf)localObject1).HEq))
    {
      localObject1 = this.CVn;
      if (localObject1 == null) {
        p.bdF("redeemFundRes");
      }
      ae.i("MicroMsg.WalletLqtSaveFetchFinishProgressNewUI", "redeemFundRes.pre_arrival_time_headline: %s", new Object[] { ((ctf)localObject1).HEq });
      localObject1 = this.gqi;
      if (localObject1 == null) {
        p.bdF("title");
      }
      localObject2 = this.CVn;
      if (localObject2 == null) {
        p.bdF("redeemFundRes");
      }
      ((TextView)localObject1).setText((CharSequence)((ctf)localObject2).HEq);
    }
    for (;;)
    {
      localObject1 = findViewById(2131307860);
      p.g(localObject1, "findViewById(R.id.lqt_fe…lt_finish_content_layout)");
      this.nLc = ((LinearLayout)localObject1);
      localObject1 = new WalletBalanceFetchResultItemView((Context)this, true);
      localObject2 = this.CVn;
      if (localObject2 == null) {
        p.bdF("redeemFundRes");
      }
      ((WalletBalanceFetchResultItemView)localObject1).b(2131765486, (CharSequence)f.D(((ctf)localObject2).Hyx / 100.0F));
      localObject2 = this.nLc;
      if (localObject2 == null) {
        p.bdF("contentLayout");
      }
      ((LinearLayout)localObject2).addView((View)localObject1);
      localObject1 = this.CVn;
      if (localObject1 == null) {
        p.bdF("redeemFundRes");
      }
      if (!bu.isNullOrNil(((ctf)localObject1).uVs))
      {
        localObject1 = this.CVn;
        if (localObject1 == null) {
          p.bdF("redeemFundRes");
        }
        localObject2 = ((ctf)localObject1).uVs;
        ctf localctf = this.CVn;
        if (localctf == null) {
          p.bdF("redeemFundRes");
        }
        localObject1 = localObject2;
        if (!bu.isNullOrNil(localctf.wSp))
        {
          localObject1 = new StringBuilder().append((String)localObject2).append(" (");
          localObject2 = this.CVn;
          if (localObject2 == null) {
            p.bdF("redeemFundRes");
          }
          localObject1 = ((ctf)localObject2).wSp + ")";
        }
        localObject2 = new WalletBalanceFetchResultItemView((Context)this);
        ((WalletBalanceFetchResultItemView)localObject2).b(2131766845, (CharSequence)localObject1);
        localObject1 = this.nLc;
        if (localObject1 == null) {
          p.bdF("contentLayout");
        }
        ((LinearLayout)localObject1).addView((View)localObject2);
      }
      localObject1 = findViewById(2131307859);
      p.g(localObject1, "findViewById(R.id.lqt_fetch_result_finish_btn)");
      this.CVm = ((View)localObject1);
      localObject1 = this.CVm;
      if (localObject1 == null) {
        p.bdF("finishBtn");
      }
      ((View)localObject1).setOnClickListener((View.OnClickListener)new b(this));
      AppMethodBeat.o(190264);
      return;
      localObject1 = this.gqi;
      if (localObject1 == null) {
        p.bdF("title");
      }
      ((TextView)localObject1).setText((CharSequence)getString(2131757465));
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(190263);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      p.gkB();
    }
    paramBundle.hide();
    showHomeBtn(false);
    enableBackMenu(false);
    setBackBtnVisible(false);
    this.mController.setStatusBarColor(getResources().getColor(2131101179));
    paramBundle = getIntent().getByteArrayExtra("key_redeem_res");
    this.CVn = new ctf();
    try
    {
      localObject = this.CVn;
      if (localObject == null) {
        p.bdF("redeemFundRes");
      }
      ((ctf)localObject).parseFrom(paramBundle);
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Object localObject;
        ae.printErrStackTrace("MicroMsg.WalletLqtSaveFetchFinishProgressNewUI", (Throwable)paramBundle, "parse redeemFundRes error!", new Object[0]);
        finish();
        continue;
        paramBundle = "";
      }
    }
    paramBundle = this.CVn;
    if (paramBundle == null) {
      p.bdF("redeemFundRes");
    }
    if (paramBundle != null)
    {
      localObject = ad.Njc;
      paramBundle = String.format("status:%s, wording_for_status2:%s, pre_arrive_time_wording:%s, redeem_fee:%s, bank_name:%s, card_tail:%s, failure_wording:%s", Arrays.copyOf(new Object[] { Integer.valueOf(paramBundle.status), paramBundle.HEn, paramBundle.HEo, Integer.valueOf(paramBundle.Hyx), paramBundle.uVs, paramBundle.wSp, paramBundle.HEp }, 7));
      p.g(paramBundle, "java.lang.String.format(format, *args)");
      ae.i("MicroMsg.WalletLqtSaveFetchFinishProgressNewUI", "onCreate, redeemRes: %s", new Object[] { paramBundle });
      initView();
      g.yxI.f(20287, new Object[] { Integer.valueOf(8) });
      AppMethodBeat.o(190263);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(WalletLqtSaveFetchFinishProgressNewUI paramWalletLqtSaveFetchFinishProgressNewUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190262);
      b localb = new b();
      localb.bd(paramView);
      a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressNewUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.CVp.finish();
      a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressNewUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(190262);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishProgressNewUI
 * JD-Core Version:    0.7.0.1
 */