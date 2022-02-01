package com.tencent.mm.plugin.wallet.pwd.ui;

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
import com.tencent.mm.autogen.mmdata.rpt.rj;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wallet.pwd.a.f.a;
import com.tencent.mm.plugin.wallet.pwd.a.f.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.protocal.protobuf.dpz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.a.g.a;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletLuckyMoneyRefundWayUI
  extends MMPreference
{
  private Preference Vro;
  private RadioBelowSummarytAndIconPreference Vrp;
  private RadioBelowSummarytAndIconPreference Vrq;
  private f.a Vrr;
  private com.tencent.mm.ui.base.preference.f pkD;
  private long xct;
  
  private boolean afN(int paramInt)
  {
    return (this.xct & paramInt) != 0L;
  }
  
  private void arZ(int paramInt)
  {
    AppMethodBeat.i(69732);
    rj localrj = new rj();
    if (Util.isEqual(this.xct & 0x3, 2L)) {}
    for (int i = 2;; i = 1)
    {
      localrj.iyh = i;
      localrj.jvM = paramInt;
      localrj.bMH();
      AppMethodBeat.o(69732);
      return;
    }
  }
  
  private void igQ()
  {
    AppMethodBeat.i(69733);
    this.Vrp.aBp(a.g.mm_preference_radio_checked);
    this.Vrq.aBp(a.g.mm_preference_radio_unchecked);
    AppMethodBeat.o(69733);
  }
  
  private void igR()
  {
    AppMethodBeat.i(69734);
    this.Vrp.aBp(a.g.mm_preference_radio_unchecked);
    this.Vrq.aBp(a.g.mm_preference_radio_checked);
    AppMethodBeat.o(69734);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69729);
    this.Vro = this.pkD.bAi("refund_way_detail");
    this.Vrp = ((RadioBelowSummarytAndIconPreference)this.pkD.bAi("refund_way_detail_lq"));
    this.Vrq = ((RadioBelowSummarytAndIconPreference)this.pkD.bAi("refund_way_detail_origin"));
    if (this.Vro != null) {
      this.Vro.setTitle(this.Vrr.Vpf);
    }
    if (this.Vrp != null)
    {
      this.Vrp.setTitle(this.Vrr.Vpb);
      this.Vrp.aS(this.Vrr.Vpc);
    }
    if (this.Vrq != null)
    {
      this.Vrq.setTitle(this.Vrr.Vpd);
      this.Vrq.aS(this.Vrr.Vpe);
      RadioBelowSummarytAndIconPreference localRadioBelowSummarytAndIconPreference = this.Vrq;
      int i = a.e.refund_way_detail_origin;
      View.OnClickListener local1 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69726);
          Object localObject1 = new b();
          ((b)localObject1).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pwd/ui/WalletLuckyMoneyRefundWayUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aYj());
          Log.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "mOriginWay click!!");
          localObject1 = new a(WalletLuckyMoneyRefundWayUI.this, WalletLuckyMoneyRefundWayUI.a(WalletLuckyMoneyRefundWayUI.this));
          View localView = View.inflate(((a)localObject1).mContext, a.g.wallet_refund_time_dialog, null);
          LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(a.f.root_container);
          if (((a)localObject1).Vrr.Vph.size() > 0)
          {
            Iterator localIterator = ((a)localObject1).Vrr.Vph.iterator();
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
                  paramAnonymousView.setMargins(0, com.tencent.mm.cd.a.fromDPToPix(((a)localObject1).mContext, 24), 0, 0);
                  ((View)localObject2).setLayoutParams(paramAnonymousView);
                }
              }
              else
              {
                paramAnonymousView = (ImageView)((View)localObject2).findViewById(a.f.icon);
                localTextView = (TextView)((View)localObject2).findViewById(a.f.title);
                localObject2 = (TextView)((View)localObject2).findViewById(a.f.subtitle);
                if (!Util.isNullOrNil(localb.Vpi)) {
                  break label313;
                }
                com.tencent.mm.modelimage.loader.a.bKl().a(localb.nPr, paramAnonymousView, new c.a().bKx());
              }
              for (;;)
              {
                localTextView.setText(localb.title);
                ((TextView)localObject2).setText(localb.desc);
                break;
                paramAnonymousView = new ViewGroup.MarginLayoutParams(paramAnonymousView);
                break label185;
                label313:
                com.tencent.mm.modelimage.loader.a locala = com.tencent.mm.modelimage.loader.a.bKl();
                String str = localb.nPr;
                c.a locala1 = new c.a();
                locala1.md5 = localb.Vpi;
                locala.a(str, paramAnonymousView, locala1.bKx());
              }
            }
          }
          paramAnonymousView = new g.a(((a)localObject1).mContext);
          paramAnonymousView.bf(((a)localObject1).Vrr.Vpg).mg(localView).bDI(((a)localObject1).mContext.getString(a.i.wallet_lucky_money_refund_time_button)).aEY(((a)localObject1).mContext.getResources().getColor(a.c.wallet_refund_time_button_color)).Xdm = true;
          paramAnonymousView.b(new a.1((a)localObject1)).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletLuckyMoneyRefundWayUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69726);
        }
      };
      localRadioBelowSummarytAndIconPreference.lR = i;
      localRadioBelowSummarytAndIconPreference.VpL = local1;
    }
    if (Util.isEqual(this.xct & 0x3, 2L)) {
      igR();
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
      igQ();
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
      this.Vrr = f.a.bgo(paramBundle);
      Log.d("MicroMsg.WalletLuckyMoneyRefundWayUI", "mHbRefundConfig:%s", new Object[] { this.Vrr });
    }
    for (;;)
    {
      this.pkD = getPreferenceScreen();
      this.pkD.aBe(a.m.wallet_lucky_money_refund_way_pref);
      setMMTitle(this.Vrr.Vpa);
      h.baF();
      this.xct = ((Long)h.baE().ban().get(at.a.acZd, Long.valueOf(0L))).longValue();
      Log.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "origin extStatus: %s", new Object[] { Long.toBinaryString(this.xct) });
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
    dpz localdpz = new dpz();
    if (afN(1))
    {
      localdpz.aaWz = 1L;
      localdpz.aaWA = 2L;
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "doSettingsOplog() extStatus: %s, set_bitmask: %s, clear_bitmask:%s", new Object[] { Long.toBinaryString(this.xct), Long.toBinaryString(localdpz.aaWz), Long.toBinaryString(localdpz.aaWA) });
      ((n)h.ax(n.class)).bzz().d(new k.a(218, localdpz));
      AppMethodBeat.o(69730);
      return;
      if (afN(2))
      {
        localdpz.aaWz = 2L;
        localdpz.aaWA = 1L;
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
      igQ();
      arZ(1);
      this.xct |= 1L;
      this.xct &= 0xFFFFFFFD;
    }
    for (;;)
    {
      h.baF();
      h.baE().ban().set(at.a.acZd, Long.valueOf(this.xct));
      this.pkD.notifyDataSetChanged();
      finish();
      AppMethodBeat.o(69731);
      return true;
      if ("refund_way_detail_origin".equals(paramf))
      {
        igR();
        arZ(2);
        this.xct &= 0xFFFFFFFE;
        this.xct |= 0x2;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletLuckyMoneyRefundWayUI
 * JD-Core Version:    0.7.0.1
 */