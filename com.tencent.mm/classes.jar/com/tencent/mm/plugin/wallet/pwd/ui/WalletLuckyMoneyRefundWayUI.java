package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.f.b.a.nr;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wallet.pwd.a.f.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.protocal.protobuf.cyt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletLuckyMoneyRefundWayUI
  extends MMPreference
{
  private Preference OCc;
  private RadioBelowSummarytAndIconPreference OCd;
  private RadioBelowSummarytAndIconPreference OCe;
  private com.tencent.mm.plugin.wallet.pwd.a.f.a OCf;
  private com.tencent.mm.ui.base.preference.f mrf;
  private long tZb;
  
  private boolean abt(int paramInt)
  {
    return (this.tZb & paramInt) != 0L;
  }
  
  private void amp(int paramInt)
  {
    AppMethodBeat.i(69732);
    nr localnr = new nr();
    if (Util.isEqual(this.tZb & 0x3, 2L)) {}
    for (int i = 2;; i = 1)
    {
      localnr.goH = i;
      localnr.hac = paramInt;
      localnr.bpa();
      AppMethodBeat.o(69732);
      return;
    }
  }
  
  private void gHL()
  {
    AppMethodBeat.i(69733);
    this.OCd.auN(a.g.mm_preference_radio_checked);
    this.OCe.auN(a.g.mm_preference_radio_unchecked);
    AppMethodBeat.o(69733);
  }
  
  private void gHM()
  {
    AppMethodBeat.i(69734);
    this.OCd.auN(a.g.mm_preference_radio_unchecked);
    this.OCe.auN(a.g.mm_preference_radio_checked);
    AppMethodBeat.o(69734);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69729);
    this.OCc = this.mrf.byG("refund_way_detail");
    this.OCd = ((RadioBelowSummarytAndIconPreference)this.mrf.byG("refund_way_detail_lq"));
    this.OCe = ((RadioBelowSummarytAndIconPreference)this.mrf.byG("refund_way_detail_origin"));
    if (this.OCc != null) {
      this.OCc.setTitle(this.OCf.OzW);
    }
    if (this.OCd != null)
    {
      this.OCd.setTitle(this.OCf.OzS);
      this.OCd.aF(this.OCf.OzT);
    }
    if (this.OCe != null)
    {
      this.OCe.setTitle(this.OCf.OzU);
      this.OCe.aF(this.OCf.OzV);
      RadioBelowSummarytAndIconPreference localRadioBelowSummarytAndIconPreference = this.OCe;
      int i = a.e.refund_way_detail_origin;
      View.OnClickListener local1 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69726);
          Object localObject1 = new b();
          ((b)localObject1).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pwd/ui/WalletLuckyMoneyRefundWayUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
          Log.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "mOriginWay click!!");
          localObject1 = new a(WalletLuckyMoneyRefundWayUI.this, WalletLuckyMoneyRefundWayUI.a(WalletLuckyMoneyRefundWayUI.this));
          View localView = View.inflate(((a)localObject1).mContext, a.g.wallet_refund_time_dialog, null);
          LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(a.f.root_container);
          if (((a)localObject1).OCf.OzY.size() > 0)
          {
            Iterator localIterator = ((a)localObject1).OCf.OzY.iterator();
            int i = 0;
            if (localIterator.hasNext())
            {
              f.b localb = (f.b)localIterator.next();
              i += 1;
              Object localObject2 = View.inflate(((a)localObject1).mContext, a.g.wallet_refund_time_sigle_line_dialog, null);
              localLinearLayout.addView((View)localObject2);
              label185:
              TextView localTextView;
              if (i != 1)
              {
                paramAnonymousView = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
                if ((paramAnonymousView instanceof ViewGroup.MarginLayoutParams))
                {
                  paramAnonymousView = (ViewGroup.MarginLayoutParams)paramAnonymousView;
                  paramAnonymousView.setMargins(0, com.tencent.mm.ci.a.fromDPToPix(((a)localObject1).mContext, 24), 0, 0);
                  ((View)localObject2).setLayoutParams(paramAnonymousView);
                }
              }
              else
              {
                paramAnonymousView = (ImageView)((View)localObject2).findViewById(a.f.icon);
                localTextView = (TextView)((View)localObject2).findViewById(a.f.title);
                localObject2 = (TextView)((View)localObject2).findViewById(a.f.subtitle);
                if (!Util.isNullOrNil(localb.OzZ)) {
                  break label313;
                }
                com.tencent.mm.ay.a.a.bms().a(localb.lkF, paramAnonymousView, new c.a().bmL());
              }
              for (;;)
              {
                localTextView.setText(localb.title);
                ((TextView)localObject2).setText(localb.desc);
                break;
                paramAnonymousView = new ViewGroup.MarginLayoutParams(paramAnonymousView);
                break label185;
                label313:
                com.tencent.mm.ay.a.a locala = com.tencent.mm.ay.a.a.bms();
                String str = localb.lkF;
                c.a locala1 = new c.a();
                locala1.md5 = localb.OzZ;
                locala.a(str, paramAnonymousView, locala1.bmL());
              }
            }
          }
          paramAnonymousView = new com.tencent.mm.ui.widget.a.f.a(((a)localObject1).mContext);
          paramAnonymousView.aR(((a)localObject1).OCf.OzX).iK(localView).bBp(((a)localObject1).mContext.getString(a.i.wallet_lucky_money_refund_time_button)).ayq(((a)localObject1).mContext.getResources().getColor(a.c.wallet_refund_time_button_color)).Qlf = true;
          paramAnonymousView.b(new a.1((a)localObject1)).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletLuckyMoneyRefundWayUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69726);
        }
      };
      localRadioBelowSummarytAndIconPreference.kV = i;
      localRadioBelowSummarytAndIconPreference.OAy = local1;
    }
    if (Util.isEqual(this.tZb & 0x3, 2L)) {
      gHM();
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(69727);
          WalletLuckyMoneyRefundWayUI.this.finish();
          AppMethodBeat.o(69727);
          return false;
        }
      });
      AppMethodBeat.o(69729);
      return;
      gHL();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69728);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getActionbarColor());
    paramBundle = getIntent().getStringExtra("key_hb_refund_config");
    if (!Util.isNullOrNil(paramBundle))
    {
      this.OCf = com.tencent.mm.plugin.wallet.pwd.a.f.a.bgI(paramBundle);
      Log.d("MicroMsg.WalletLuckyMoneyRefundWayUI", "mHbRefundConfig:%s", new Object[] { this.OCf });
    }
    for (;;)
    {
      this.mrf = getPreferenceScreen();
      this.mrf.auC(a.m.wallet_lucky_money_refund_way_pref);
      setMMTitle(this.OCf.OzR);
      h.aHH();
      this.tZb = ((Long)h.aHG().aHp().get(ar.a.Vxr, Long.valueOf(0L))).longValue();
      Log.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "origin extStatus: %s", new Object[] { Long.toBinaryString(this.tZb) });
      initView();
      AppMethodBeat.o(69728);
      return;
      Log.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "mHbRefundConfig == null");
      finish();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69730);
    super.onDestroy();
    cyt localcyt = new cyt();
    if (abt(1))
    {
      localcyt.TGS = 1L;
      localcyt.TGT = 2L;
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "doSettingsOplog() extStatus: %s, set_bitmask: %s, clear_bitmask:%s", new Object[] { Long.toBinaryString(this.tZb), Long.toBinaryString(localcyt.TGS), Long.toBinaryString(localcyt.TGT) });
      ((n)h.ae(n.class)).bbK().d(new k.a(218, localcyt));
      AppMethodBeat.o(69730);
      return;
      if (abt(2))
      {
        localcyt.TGS = 2L;
        localcyt.TGT = 1L;
      }
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69731);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "onPreferenceTreeClick() key:%s", new Object[] { paramf });
    if ("refund_way_detail_lq".equals(paramf))
    {
      gHL();
      amp(1);
      this.tZb |= 1L;
      this.tZb &= 0xFFFFFFFD;
    }
    for (;;)
    {
      h.aHH();
      h.aHG().aHp().set(ar.a.Vxr, Long.valueOf(this.tZb));
      this.mrf.notifyDataSetChanged();
      finish();
      AppMethodBeat.o(69731);
      return true;
      if ("refund_way_detail_origin".equals(paramf))
      {
        gHM();
        amp(2);
        this.tZb &= 0xFFFFFFFE;
        this.tZb |= 0x2;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletLuckyMoneyRefundWayUI
 * JD-Core Version:    0.7.0.1
 */