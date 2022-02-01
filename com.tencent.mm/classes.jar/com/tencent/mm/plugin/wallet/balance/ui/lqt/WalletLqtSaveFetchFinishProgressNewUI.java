package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.eoj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.i;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressNewUI;", "Lcom/tencent/mm/wallet_core/ui/WalletBaseUI;", "()V", "contentLayout", "Landroid/widget/LinearLayout;", "finishBtn", "Landroid/view/View;", "redeemFundRes", "Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;", "title", "Landroid/widget/TextView;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "redeemToString", "Companion", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WalletLqtSaveFetchFinishProgressNewUI
  extends WalletBaseUI
{
  public static final WalletLqtSaveFetchFinishProgressNewUI.a Vht;
  private eoj Vhu;
  private TextView mll;
  private LinearLayout vjm;
  private View wcv;
  
  static
  {
    AppMethodBeat.i(316460);
    Vht = new WalletLqtSaveFetchFinishProgressNewUI.a((byte)0);
    AppMethodBeat.o(316460);
  }
  
  private static final void a(WalletLqtSaveFetchFinishProgressNewUI paramWalletLqtSaveFetchFinishProgressNewUI, View paramView)
  {
    AppMethodBeat.i(316452);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramWalletLqtSaveFetchFinishProgressNewUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressNewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramWalletLqtSaveFetchFinishProgressNewUI, "this$0");
    paramWalletLqtSaveFetchFinishProgressNewUI.finish();
    a.a(new Object(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressNewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(316452);
  }
  
  public final int getLayoutId()
  {
    return a.g.lqt_plan_fetch_result_new_ui;
  }
  
  public final void initView()
  {
    Object localObject3 = null;
    AppMethodBeat.i(316479);
    this.mll = ((TextView)findViewById(a.f.lqt_fetch_result_finish_title));
    Object localObject2 = this.Vhu;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("redeemFundRes");
      localObject1 = null;
    }
    if (!Util.isNullOrNil(((eoj)localObject1).absK))
    {
      localObject2 = this.Vhu;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("redeemFundRes");
        localObject1 = null;
      }
      Log.i("MicroMsg.WalletLqtSaveFetchFinishProgressNewUI", "redeemFundRes.pre_arrival_time_headline: %s", new Object[] { ((eoj)localObject1).absK });
      localObject1 = this.mll;
      if (localObject1 == null)
      {
        s.bIx("title");
        localObject1 = null;
        Object localObject4 = this.Vhu;
        localObject2 = localObject4;
        if (localObject4 == null)
        {
          s.bIx("redeemFundRes");
          localObject2 = null;
        }
        ((TextView)localObject1).setText((CharSequence)((eoj)localObject2).absK);
        this.vjm = ((LinearLayout)findViewById(a.f.lqt_fetch_result_finish_content_layout));
        localObject4 = new WalletBalanceFetchResultItemView((Context)this, true);
        int i = a.i.wallet_lqt_result_total_fee_fetch;
        localObject2 = this.Vhu;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("redeemFundRes");
          localObject1 = null;
        }
        ((WalletBalanceFetchResultItemView)localObject4).b(i, (CharSequence)i.X(((eoj)localObject1).ablD / 100.0F));
        localObject1 = this.vjm;
        if (localObject1 != null) {
          break label503;
        }
        s.bIx("contentLayout");
        localObject1 = null;
        label221:
        ((LinearLayout)localObject1).addView((View)localObject4);
        localObject2 = this.Vhu;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("redeemFundRes");
          localObject1 = null;
        }
        if (!Util.isNullOrNil(((eoj)localObject1).JFk))
        {
          localObject2 = this.Vhu;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("redeemFundRes");
            localObject1 = null;
          }
          localObject4 = ((eoj)localObject1).JFk;
          localObject2 = this.Vhu;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("redeemFundRes");
            localObject1 = null;
          }
          localObject2 = localObject4;
          if (!Util.isNullOrNil(((eoj)localObject1).MEp))
          {
            localObject4 = new StringBuilder().append((String)localObject4).append(" (");
            localObject2 = this.Vhu;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("redeemFundRes");
              localObject1 = null;
            }
            localObject2 = ((eoj)localObject1).MEp + ')';
          }
          localObject4 = new WalletBalanceFetchResultItemView((Context)this);
          ((WalletBalanceFetchResultItemView)localObject4).b(a.i.wallet_lqt_fetch_progress_account_new_tips, (CharSequence)localObject2);
          localObject1 = this.vjm;
          if (localObject1 != null) {
            break label506;
          }
          s.bIx("contentLayout");
          localObject1 = null;
          label409:
          ((LinearLayout)localObject1).addView((View)localObject4);
        }
        this.wcv = findViewById(a.f.lqt_fetch_result_finish_btn);
        localObject1 = this.wcv;
        if (localObject1 != null) {
          break label509;
        }
        s.bIx("finishBtn");
        localObject1 = localObject3;
      }
    }
    label503:
    label506:
    label509:
    for (;;)
    {
      ((View)localObject1).setOnClickListener(new WalletLqtSaveFetchFinishProgressNewUI..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(316479);
      return;
      break;
      localObject1 = this.mll;
      if (localObject1 == null)
      {
        s.bIx("title");
        localObject1 = null;
      }
      for (;;)
      {
        ((TextView)localObject1).setText((CharSequence)getString(a.i.collect_main_fixed_cancel));
        break;
      }
      break label221;
      break label409;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(316470);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    paramBundle = getSupportActionBar();
    s.checkNotNull(paramBundle);
    paramBundle.hide();
    showHomeBtn(false);
    enableBackMenu(false);
    setBackBtnVisible(false);
    this.mController.setStatusBarColor(getResources().getColor(a.c.white));
    byte[] arrayOfByte = getIntent().getByteArrayExtra("key_redeem_res");
    this.Vhu = new eoj();
    try
    {
      localObject = this.Vhu;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        s.bIx("redeemFundRes");
        paramBundle = null;
      }
      paramBundle.parseFrom(arrayOfByte);
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
    localObject = this.Vhu;
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      s.bIx("redeemFundRes");
      paramBundle = null;
    }
    if (paramBundle != null)
    {
      localObject = am.aixg;
      paramBundle = String.format("status:%s, wording_for_status2:%s, pre_arrive_time_wording:%s, redeem_fee:%s, bank_name:%s, card_tail:%s, failure_wording:%s", Arrays.copyOf(new Object[] { Integer.valueOf(paramBundle.status), paramBundle.absH, paramBundle.absI, Integer.valueOf(paramBundle.ablD), paramBundle.JFk, paramBundle.MEp, paramBundle.absJ }, 7));
      s.s(paramBundle, "java.lang.String.format(format, *args)");
      Log.i("MicroMsg.WalletLqtSaveFetchFinishProgressNewUI", "onCreate, redeemRes: %s", new Object[] { paramBundle });
      initView();
      h.OAn.b(20287, new Object[] { Integer.valueOf(8) });
      AppMethodBeat.o(316470);
      return;
    }
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
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