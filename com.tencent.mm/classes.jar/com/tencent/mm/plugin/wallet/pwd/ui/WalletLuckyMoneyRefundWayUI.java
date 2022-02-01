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
import com.tencent.mm.g.b.a.fz;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.wallet.pwd.a.f.b;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletLuckyMoneyRefundWayUI
  extends MMPreference
{
  private Preference Blv;
  private RadioBelowSummarytAndIconPreference Bmr;
  private RadioBelowSummarytAndIconPreference Bms;
  private com.tencent.mm.plugin.wallet.pwd.a.f.a Bmt;
  private f lZC;
  private long oAP;
  
  private boolean Lr(int paramInt)
  {
    return (this.oAP & paramInt) != 0L;
  }
  
  private void TB(int paramInt)
  {
    AppMethodBeat.i(69732);
    fz localfz = new fz();
    if (bs.av(this.oAP & 0x3, 2L)) {}
    for (int i = 2;; i = 1)
    {
      localfz.ebd = i;
      localfz.ebe = paramInt;
      localfz.aHZ();
      AppMethodBeat.o(69732);
      return;
    }
  }
  
  private void eqo()
  {
    AppMethodBeat.i(69733);
    this.Bmr.setWidgetLayoutResource(2131494878);
    this.Bms.setWidgetLayoutResource(2131494879);
    AppMethodBeat.o(69733);
  }
  
  private void eqp()
  {
    AppMethodBeat.i(69734);
    this.Bmr.setWidgetLayoutResource(2131494879);
    this.Bms.setWidgetLayoutResource(2131494878);
    AppMethodBeat.o(69734);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69729);
    this.Blv = this.lZC.aPN("refund_way_detail");
    this.Bmr = ((RadioBelowSummarytAndIconPreference)this.lZC.aPN("refund_way_detail_lq"));
    this.Bms = ((RadioBelowSummarytAndIconPreference)this.lZC.aPN("refund_way_detail_origin"));
    if (this.Blv != null) {
      this.Blv.setTitle(this.Bmt.Bkv);
    }
    if (this.Bmr != null)
    {
      this.Bmr.setTitle(this.Bmt.Bkr);
      this.Bmr.setSummary(this.Bmt.Bks);
    }
    if (this.Bms != null)
    {
      this.Bms.setTitle(this.Bmt.Bkt);
      this.Bms.setSummary(this.Bmt.Bku);
      RadioBelowSummarytAndIconPreference localRadioBelowSummarytAndIconPreference = this.Bms;
      View.OnClickListener local1 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69726);
          ac.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "mOriginWay click!!");
          a locala = new a(WalletLuckyMoneyRefundWayUI.this, WalletLuckyMoneyRefundWayUI.a(WalletLuckyMoneyRefundWayUI.this));
          View localView = View.inflate(locala.mContext, 2131496019, null);
          LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131304241);
          if (locala.Bmt.Bkx.size() > 0)
          {
            Iterator localIterator = locala.Bmt.Bkx.iterator();
            int i = 0;
            if (localIterator.hasNext())
            {
              f.b localb = (f.b)localIterator.next();
              i += 1;
              Object localObject = View.inflate(locala.mContext, 2131496020, null);
              localLinearLayout.addView((View)localObject);
              label153:
              TextView localTextView;
              if (i != 1)
              {
                paramAnonymousView = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
                if ((paramAnonymousView instanceof ViewGroup.MarginLayoutParams))
                {
                  paramAnonymousView = (ViewGroup.MarginLayoutParams)paramAnonymousView;
                  paramAnonymousView.setMargins(0, com.tencent.mm.cc.a.fromDPToPix(locala.mContext, 24), 0, 0);
                  ((View)localObject).setLayoutParams(paramAnonymousView);
                }
              }
              else
              {
                paramAnonymousView = (ImageView)((View)localObject).findViewById(2131300874);
                localTextView = (TextView)((View)localObject).findViewById(2131305902);
                localObject = (TextView)((View)localObject).findViewById(2131305529);
                if (!bs.isNullOrNil(localb.Bkz)) {
                  break label278;
                }
                com.tencent.mm.av.a.a.aFG().a(localb.hgt, paramAnonymousView, new c.a().aFT());
              }
              for (;;)
              {
                localTextView.setText(localb.title);
                ((TextView)localObject).setText(localb.desc);
                break;
                paramAnonymousView = new ViewGroup.MarginLayoutParams(paramAnonymousView);
                break label153;
                label278:
                com.tencent.mm.av.a.a locala1 = com.tencent.mm.av.a.a.aFG();
                String str = localb.hgt;
                c.a locala2 = new c.a();
                locala2.md5 = localb.Bkz;
                locala1.a(str, paramAnonymousView, locala2.aFT());
              }
            }
          }
          paramAnonymousView = new com.tencent.mm.ui.widget.a.f.a(locala.mContext);
          paramAnonymousView.av(locala.Bmt.Bkw).gK(localView).aRU(locala.mContext.getString(2131765505)).acR(locala.mContext.getResources().getColor(2131101134)).JfY = true;
          paramAnonymousView.b(new a.1(locala)).show();
          AppMethodBeat.o(69726);
        }
      };
      localRadioBelowSummarytAndIconPreference.acJ = 2131233821;
      localRadioBelowSummarytAndIconPreference.BkY = local1;
    }
    if (bs.av(this.oAP & 0x3, 2L)) {
      eqp();
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
      eqo();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69728);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getActionbarColor());
    paramBundle = getIntent().getStringExtra("key_hb_refund_config");
    if (!bs.isNullOrNil(paramBundle))
    {
      this.Bmt = com.tencent.mm.plugin.wallet.pwd.a.f.a.aza(paramBundle);
      ac.d("MicroMsg.WalletLuckyMoneyRefundWayUI", "mHbRefundConfig:%s", new Object[] { this.Bmt });
    }
    for (;;)
    {
      this.lZC = getPreferenceScreen();
      this.lZC.addPreferencesFromResource(2131951759);
      setMMTitle(this.Bmt.Bkp);
      g.agS();
      this.oAP = ((Long)g.agR().agA().get(ah.a.GTq, Long.valueOf(0L))).longValue();
      ac.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "origin extStatus: %s", new Object[] { Long.toBinaryString(this.oAP) });
      initView();
      AppMethodBeat.o(69728);
      return;
      ac.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "mHbRefundConfig == null");
      finish();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69730);
    super.onDestroy();
    bvq localbvq = new bvq();
    if (Lr(1))
    {
      localbvq.Flp = 1L;
      localbvq.Flq = 2L;
    }
    for (;;)
    {
      ac.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "doSettingsOplog() extStatus: %s, set_bitmask: %s, clear_bitmask:%s", new Object[] { Long.toBinaryString(this.oAP), Long.toBinaryString(localbvq.Flp), Long.toBinaryString(localbvq.Flq) });
      ((k)g.ab(k.class)).awA().c(new j.a(218, localbvq));
      AppMethodBeat.o(69730);
      return;
      if (Lr(2))
      {
        localbvq.Flp = 2L;
        localbvq.Flq = 1L;
      }
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69731);
    paramf = paramPreference.mKey;
    ac.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "onPreferenceTreeClick() key:%s", new Object[] { paramf });
    if ("refund_way_detail_lq".equals(paramf))
    {
      eqo();
      TB(1);
      this.oAP |= 1L;
      this.oAP &= 0xFFFFFFFD;
    }
    for (;;)
    {
      g.agS();
      g.agR().agA().set(ah.a.GTq, Long.valueOf(this.oAP));
      this.lZC.notifyDataSetChanged();
      finish();
      AppMethodBeat.o(69731);
      return true;
      if ("refund_way_detail_origin".equals(paramf))
      {
        eqp();
        TB(2);
        this.oAP &= 0xFFFFFFFE;
        this.oAP |= 0x2;
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