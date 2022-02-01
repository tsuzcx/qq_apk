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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.b.a.kv;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet.pwd.a.f.b;
import com.tencent.mm.protocal.protobuf.cqc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletLuckyMoneyRefundWayUI
  extends MMPreference
{
  private Preference HJg;
  private RadioBelowSummarytAndIconPreference HKi;
  private RadioBelowSummarytAndIconPreference HKj;
  private com.tencent.mm.plugin.wallet.pwd.a.f.a HKk;
  private f nRm;
  private long qAb;
  
  private boolean UM(int paramInt)
  {
    return (this.qAb & paramInt) != 0L;
  }
  
  private void aeD(int paramInt)
  {
    AppMethodBeat.i(69732);
    kv localkv = new kv();
    if (Util.isEqual(this.qAb & 0x3, 2L)) {}
    for (int i = 2;; i = 1)
    {
      localkv.esA = i;
      localkv.eXx = paramInt;
      localkv.bfK();
      AppMethodBeat.o(69732);
      return;
    }
  }
  
  private void fPh()
  {
    AppMethodBeat.i(69733);
    this.HKi.setWidgetLayoutResource(2131495615);
    this.HKj.setWidgetLayoutResource(2131495616);
    AppMethodBeat.o(69733);
  }
  
  private void fPi()
  {
    AppMethodBeat.i(69734);
    this.HKi.setWidgetLayoutResource(2131495616);
    this.HKj.setWidgetLayoutResource(2131495615);
    AppMethodBeat.o(69734);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69729);
    this.HJg = this.nRm.bmg("refund_way_detail");
    this.HKi = ((RadioBelowSummarytAndIconPreference)this.nRm.bmg("refund_way_detail_lq"));
    this.HKj = ((RadioBelowSummarytAndIconPreference)this.nRm.bmg("refund_way_detail_origin"));
    if (this.HJg != null) {
      this.HJg.setTitle(this.HKk.HId);
    }
    if (this.HKi != null)
    {
      this.HKi.setTitle(this.HKk.HHZ);
      this.HKi.setSummary(this.HKk.HIa);
    }
    if (this.HKj != null)
    {
      this.HKj.setTitle(this.HKk.HIb);
      this.HKj.setSummary(this.HKk.HIc);
      RadioBelowSummarytAndIconPreference localRadioBelowSummarytAndIconPreference = this.HKj;
      View.OnClickListener local1 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69726);
          Object localObject1 = new b();
          ((b)localObject1).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletLuckyMoneyRefundWayUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
          Log.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "mOriginWay click!!");
          localObject1 = new a(WalletLuckyMoneyRefundWayUI.this, WalletLuckyMoneyRefundWayUI.a(WalletLuckyMoneyRefundWayUI.this));
          View localView = View.inflate(((a)localObject1).mContext, 2131496999, null);
          LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131307160);
          if (((a)localObject1).HKk.HIf.size() > 0)
          {
            Iterator localIterator = ((a)localObject1).HKk.HIf.iterator();
            int i = 0;
            if (localIterator.hasNext())
            {
              f.b localb = (f.b)localIterator.next();
              i += 1;
              Object localObject2 = View.inflate(((a)localObject1).mContext, 2131497000, null);
              localLinearLayout.addView((View)localObject2);
              label182:
              TextView localTextView;
              if (i != 1)
              {
                paramAnonymousView = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
                if ((paramAnonymousView instanceof ViewGroup.MarginLayoutParams))
                {
                  paramAnonymousView = (ViewGroup.MarginLayoutParams)paramAnonymousView;
                  paramAnonymousView.setMargins(0, com.tencent.mm.cb.a.fromDPToPix(((a)localObject1).mContext, 24), 0, 0);
                  ((View)localObject2).setLayoutParams(paramAnonymousView);
                }
              }
              else
              {
                paramAnonymousView = (ImageView)((View)localObject2).findViewById(2131302468);
                localTextView = (TextView)((View)localObject2).findViewById(2131309195);
                localObject2 = (TextView)((View)localObject2).findViewById(2131308746);
                if (!Util.isNullOrNil(localb.HIh)) {
                  break label307;
                }
                com.tencent.mm.av.a.a.bdb().a(localb.ivw, paramAnonymousView, new c.a().bdv());
              }
              for (;;)
              {
                localTextView.setText(localb.title);
                ((TextView)localObject2).setText(localb.desc);
                break;
                paramAnonymousView = new ViewGroup.MarginLayoutParams(paramAnonymousView);
                break label182;
                label307:
                com.tencent.mm.av.a.a locala = com.tencent.mm.av.a.a.bdb();
                String str = localb.ivw;
                c.a locala1 = new c.a();
                locala1.md5 = localb.HIh;
                locala.a(str, paramAnonymousView, locala1.bdv());
              }
            }
          }
          paramAnonymousView = new com.tencent.mm.ui.widget.a.f.a(((a)localObject1).mContext);
          paramAnonymousView.aC(((a)localObject1).HKk.HIe).hu(localView).boA(((a)localObject1).mContext.getString(2131767954)).apb(((a)localObject1).mContext.getResources().getColor(2131101377)).JnN = true;
          paramAnonymousView.b(new a.1((a)localObject1)).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletLuckyMoneyRefundWayUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69726);
        }
      };
      localRadioBelowSummarytAndIconPreference.aeN = 2131234644;
      localRadioBelowSummarytAndIconPreference.HIG = local1;
    }
    if (Util.isEqual(this.qAb & 0x3, 2L)) {
      fPi();
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
      fPh();
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
      this.HKk = com.tencent.mm.plugin.wallet.pwd.a.f.a.aUZ(paramBundle);
      Log.d("MicroMsg.WalletLuckyMoneyRefundWayUI", "mHbRefundConfig:%s", new Object[] { this.HKk });
    }
    for (;;)
    {
      this.nRm = getPreferenceScreen();
      this.nRm.addPreferencesFromResource(2132017304);
      setMMTitle(this.HKk.HHX);
      g.aAi();
      this.qAb = ((Long)g.aAh().azQ().get(ar.a.Ojb, Long.valueOf(0L))).longValue();
      Log.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "origin extStatus: %s", new Object[] { Long.toBinaryString(this.qAb) });
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
    cqc localcqc = new cqc();
    if (UM(1))
    {
      localcqc.MvU = 1L;
      localcqc.MvV = 2L;
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "doSettingsOplog() extStatus: %s, set_bitmask: %s, clear_bitmask:%s", new Object[] { Long.toBinaryString(this.qAb), Long.toBinaryString(localcqc.MvU), Long.toBinaryString(localcqc.MvV) });
      ((l)g.af(l.class)).aSM().d(new k.a(218, localcqc));
      AppMethodBeat.o(69730);
      return;
      if (UM(2))
      {
        localcqc.MvU = 2L;
        localcqc.MvV = 1L;
      }
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69731);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "onPreferenceTreeClick() key:%s", new Object[] { paramf });
    if ("refund_way_detail_lq".equals(paramf))
    {
      fPh();
      aeD(1);
      this.qAb |= 1L;
      this.qAb &= 0xFFFFFFFD;
    }
    for (;;)
    {
      g.aAi();
      g.aAh().azQ().set(ar.a.Ojb, Long.valueOf(this.qAb));
      this.nRm.notifyDataSetChanged();
      finish();
      AppMethodBeat.o(69731);
      return true;
      if ("refund_way_detail_origin".equals(paramf))
      {
        fPi();
        aeD(2);
        this.qAb &= 0xFFFFFFFE;
        this.qAb |= 0x2;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletLuckyMoneyRefundWayUI
 * JD-Core Version:    0.7.0.1
 */