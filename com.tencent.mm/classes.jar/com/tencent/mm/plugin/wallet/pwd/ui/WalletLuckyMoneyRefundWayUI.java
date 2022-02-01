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
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.g.b.a.ej;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.wallet.pwd.a.f.b;
import com.tencent.mm.protocal.protobuf.bqz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletLuckyMoneyRefundWayUI
  extends MMPreference
{
  private f lxI;
  private long nXu;
  private RadioBelowSummarytAndIconPreference zTX;
  private RadioBelowSummarytAndIconPreference zTY;
  private com.tencent.mm.plugin.wallet.pwd.a.f.a zTZ;
  private Preference zTb;
  
  private boolean Js(int paramInt)
  {
    return (this.nXu & paramInt) != 0L;
  }
  
  private void Rs(int paramInt)
  {
    AppMethodBeat.i(69732);
    ej localej = new ej();
    if (bt.aw(this.nXu & 0x3, 2L)) {}
    for (int i = 2;; i = 1)
    {
      localej.dZl = i;
      localej.dZm = paramInt;
      localej.aBj();
      AppMethodBeat.o(69732);
      return;
    }
  }
  
  private void eaS()
  {
    AppMethodBeat.i(69733);
    this.zTX.setWidgetLayoutResource(2131494878);
    this.zTY.setWidgetLayoutResource(2131494879);
    AppMethodBeat.o(69733);
  }
  
  private void eaT()
  {
    AppMethodBeat.i(69734);
    this.zTX.setWidgetLayoutResource(2131494879);
    this.zTY.setWidgetLayoutResource(2131494878);
    AppMethodBeat.o(69734);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69729);
    this.zTb = this.lxI.aKk("refund_way_detail");
    this.zTX = ((RadioBelowSummarytAndIconPreference)this.lxI.aKk("refund_way_detail_lq"));
    this.zTY = ((RadioBelowSummarytAndIconPreference)this.lxI.aKk("refund_way_detail_origin"));
    if (this.zTb != null) {
      this.zTb.setTitle(this.zTZ.zSb);
    }
    if (this.zTX != null)
    {
      this.zTX.setTitle(this.zTZ.zRX);
      this.zTX.setSummary(this.zTZ.zRY);
    }
    if (this.zTY != null)
    {
      this.zTY.setTitle(this.zTZ.zRZ);
      this.zTY.setSummary(this.zTZ.zSa);
      RadioBelowSummarytAndIconPreference localRadioBelowSummarytAndIconPreference = this.zTY;
      View.OnClickListener local1 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69726);
          ad.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "mOriginWay click!!");
          a locala = new a(WalletLuckyMoneyRefundWayUI.this, WalletLuckyMoneyRefundWayUI.a(WalletLuckyMoneyRefundWayUI.this));
          View localView = View.inflate(locala.mContext, 2131496019, null);
          LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131304241);
          if (locala.zTZ.zSd.size() > 0)
          {
            Iterator localIterator = locala.zTZ.zSd.iterator();
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
                  paramAnonymousView.setMargins(0, com.tencent.mm.cd.a.fromDPToPix(locala.mContext, 24), 0, 0);
                  ((View)localObject).setLayoutParams(paramAnonymousView);
                }
              }
              else
              {
                paramAnonymousView = (ImageView)((View)localObject).findViewById(2131300874);
                localTextView = (TextView)((View)localObject).findViewById(2131305902);
                localObject = (TextView)((View)localObject).findViewById(2131305529);
                if (!bt.isNullOrNil(localb.zSf)) {
                  break label278;
                }
                com.tencent.mm.aw.a.a.ayO().a(localb.gFS, paramAnonymousView, new c.a().azc());
              }
              for (;;)
              {
                localTextView.setText(localb.title);
                ((TextView)localObject).setText(localb.desc);
                break;
                paramAnonymousView = new ViewGroup.MarginLayoutParams(paramAnonymousView);
                break label153;
                label278:
                com.tencent.mm.aw.a.a locala1 = com.tencent.mm.aw.a.a.ayO();
                String str = localb.gFS;
                c.a locala2 = new c.a();
                locala2.md5 = localb.zSf;
                locala1.a(str, paramAnonymousView, locala2.azc());
              }
            }
          }
          paramAnonymousView = new com.tencent.mm.ui.widget.a.f.a(locala.mContext);
          paramAnonymousView.au(locala.zTZ.zSc).gu(localView).aMs(locala.mContext.getString(2131765505)).aaG(locala.mContext.getResources().getColor(2131101134)).HFB = true;
          paramAnonymousView.b(new a.1(locala)).show();
          AppMethodBeat.o(69726);
        }
      };
      localRadioBelowSummarytAndIconPreference.abP = 2131233821;
      localRadioBelowSummarytAndIconPreference.zSE = local1;
    }
    if (bt.aw(this.nXu & 0x3, 2L)) {
      eaT();
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
      eaS();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69728);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getActionbarColor());
    paramBundle = getIntent().getStringExtra("key_hb_refund_config");
    if (!bt.isNullOrNil(paramBundle))
    {
      this.zTZ = com.tencent.mm.plugin.wallet.pwd.a.f.a.atI(paramBundle);
      ad.d("MicroMsg.WalletLuckyMoneyRefundWayUI", "mHbRefundConfig:%s", new Object[] { this.zTZ });
    }
    for (;;)
    {
      this.lxI = getPreferenceScreen();
      this.lxI.addPreferencesFromResource(2131951759);
      setMMTitle(this.zTZ.zRV);
      g.afC();
      this.nXu = ((Long)g.afB().afk().get(ae.a.Fvw, Long.valueOf(0L))).longValue();
      ad.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "origin extStatus: %s", new Object[] { Long.toBinaryString(this.nXu) });
      initView();
      AppMethodBeat.o(69728);
      return;
      ad.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "mHbRefundConfig == null");
      finish();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69730);
    super.onDestroy();
    bqz localbqz = new bqz();
    if (Js(1))
    {
      localbqz.DOY = 1L;
      localbqz.DOZ = 2L;
    }
    for (;;)
    {
      ad.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "doSettingsOplog() extStatus: %s, set_bitmask: %s, clear_bitmask:%s", new Object[] { Long.toBinaryString(this.nXu), Long.toBinaryString(localbqz.DOY), Long.toBinaryString(localbqz.DOZ) });
      ((k)g.ab(k.class)).apL().c(new j.a(218, localbqz));
      AppMethodBeat.o(69730);
      return;
      if (Js(2))
      {
        localbqz.DOY = 2L;
        localbqz.DOZ = 1L;
      }
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69731);
    paramf = paramPreference.mKey;
    ad.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "onPreferenceTreeClick() key:%s", new Object[] { paramf });
    if ("refund_way_detail_lq".equals(paramf))
    {
      eaS();
      Rs(1);
      this.nXu |= 1L;
      this.nXu &= 0xFFFFFFFD;
    }
    for (;;)
    {
      g.afC();
      g.afB().afk().set(ae.a.Fvw, Long.valueOf(this.nXu));
      this.lxI.notifyDataSetChanged();
      finish();
      AppMethodBeat.o(69731);
      return true;
      if ("refund_way_detail_origin".equals(paramf))
      {
        eaT();
        Rs(2);
        this.nXu &= 0xFFFFFFFE;
        this.nXu |= 0x2;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletLuckyMoneyRefundWayUI
 * JD-Core Version:    0.7.0.1
 */