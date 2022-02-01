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
import com.tencent.mm.g.b.a.hc;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet.pwd.a.f.b;
import com.tencent.mm.protocal.protobuf.cag;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletLuckyMoneyRefundWayUI
  extends MMPreference
{
  private Preference CLJ;
  private RadioBelowSummarytAndIconPreference CMG;
  private RadioBelowSummarytAndIconPreference CMH;
  private com.tencent.mm.plugin.wallet.pwd.a.f.a CMI;
  private f mzx;
  private long pek;
  
  private boolean MT(int paramInt)
  {
    return (this.pek & paramInt) != 0L;
  }
  
  private void Vt(int paramInt)
  {
    AppMethodBeat.i(69732);
    hc localhc = new hc();
    if (bt.aA(this.pek & 0x3, 2L)) {}
    for (int i = 2;; i = 1)
    {
      localhc.dVG = i;
      localhc.erK = paramInt;
      localhc.aLk();
      AppMethodBeat.o(69732);
      return;
    }
  }
  
  private void eEo()
  {
    AppMethodBeat.i(69733);
    this.CMG.setWidgetLayoutResource(2131494878);
    this.CMH.setWidgetLayoutResource(2131494879);
    AppMethodBeat.o(69733);
  }
  
  private void eEp()
  {
    AppMethodBeat.i(69734);
    this.CMG.setWidgetLayoutResource(2131494879);
    this.CMH.setWidgetLayoutResource(2131494878);
    AppMethodBeat.o(69734);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69729);
    this.CLJ = this.mzx.aVD("refund_way_detail");
    this.CMG = ((RadioBelowSummarytAndIconPreference)this.mzx.aVD("refund_way_detail_lq"));
    this.CMH = ((RadioBelowSummarytAndIconPreference)this.mzx.aVD("refund_way_detail_origin"));
    if (this.CLJ != null) {
      this.CLJ.setTitle(this.CMI.CKJ);
    }
    if (this.CMG != null)
    {
      this.CMG.setTitle(this.CMI.CKF);
      this.CMG.setSummary(this.CMI.CKG);
    }
    if (this.CMH != null)
    {
      this.CMH.setTitle(this.CMI.CKH);
      this.CMH.setSummary(this.CMI.CKI);
      RadioBelowSummarytAndIconPreference localRadioBelowSummarytAndIconPreference = this.CMH;
      View.OnClickListener local1 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69726);
          Object localObject1 = new b();
          ((b)localObject1).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletLuckyMoneyRefundWayUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).ahq());
          ad.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "mOriginWay click!!");
          localObject1 = new a(WalletLuckyMoneyRefundWayUI.this, WalletLuckyMoneyRefundWayUI.a(WalletLuckyMoneyRefundWayUI.this));
          View localView = View.inflate(((a)localObject1).mContext, 2131496019, null);
          LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131304241);
          if (((a)localObject1).CMI.CKL.size() > 0)
          {
            Iterator localIterator = ((a)localObject1).CMI.CKL.iterator();
            int i = 0;
            if (localIterator.hasNext())
            {
              f.b localb = (f.b)localIterator.next();
              i += 1;
              Object localObject2 = View.inflate(((a)localObject1).mContext, 2131496020, null);
              localLinearLayout.addView((View)localObject2);
              label182:
              TextView localTextView;
              if (i != 1)
              {
                paramAnonymousView = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
                if ((paramAnonymousView instanceof ViewGroup.MarginLayoutParams))
                {
                  paramAnonymousView = (ViewGroup.MarginLayoutParams)paramAnonymousView;
                  paramAnonymousView.setMargins(0, com.tencent.mm.cc.a.fromDPToPix(((a)localObject1).mContext, 24), 0, 0);
                  ((View)localObject2).setLayoutParams(paramAnonymousView);
                }
              }
              else
              {
                paramAnonymousView = (ImageView)((View)localObject2).findViewById(2131300874);
                localTextView = (TextView)((View)localObject2).findViewById(2131305902);
                localObject2 = (TextView)((View)localObject2).findViewById(2131305529);
                if (!bt.isNullOrNil(localb.CKN)) {
                  break label307;
                }
                com.tencent.mm.aw.a.a.aIP().a(localb.hyC, paramAnonymousView, new c.a().aJc());
              }
              for (;;)
              {
                localTextView.setText(localb.title);
                ((TextView)localObject2).setText(localb.desc);
                break;
                paramAnonymousView = new ViewGroup.MarginLayoutParams(paramAnonymousView);
                break label182;
                label307:
                com.tencent.mm.aw.a.a locala = com.tencent.mm.aw.a.a.aIP();
                String str = localb.hyC;
                c.a locala1 = new c.a();
                locala1.md5 = localb.CKN;
                locala.a(str, paramAnonymousView, locala1.aJc());
              }
            }
          }
          paramAnonymousView = new com.tencent.mm.ui.widget.a.f.a(((a)localObject1).mContext);
          paramAnonymousView.av(((a)localObject1).CMI.CKK).hb(localView).aXS(((a)localObject1).mContext.getString(2131765505)).afq(((a)localObject1).mContext.getResources().getColor(2131101134)).EgK = true;
          paramAnonymousView.b(new a.1((a)localObject1)).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletLuckyMoneyRefundWayUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69726);
        }
      };
      localRadioBelowSummarytAndIconPreference.aeA = 2131233821;
      localRadioBelowSummarytAndIconPreference.CLm = local1;
    }
    if (bt.aA(this.pek & 0x3, 2L)) {
      eEp();
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
      eEo();
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
      this.CMI = com.tencent.mm.plugin.wallet.pwd.a.f.a.aEi(paramBundle);
      ad.d("MicroMsg.WalletLuckyMoneyRefundWayUI", "mHbRefundConfig:%s", new Object[] { this.CMI });
    }
    for (;;)
    {
      this.mzx = getPreferenceScreen();
      this.mzx.addPreferencesFromResource(2131951759);
      setMMTitle(this.CMI.CKD);
      g.ajD();
      this.pek = ((Long)g.ajC().ajl().get(al.a.IFV, Long.valueOf(0L))).longValue();
      ad.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "origin extStatus: %s", new Object[] { Long.toBinaryString(this.pek) });
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
    cag localcag = new cag();
    if (MT(1))
    {
      localcag.GUY = 1L;
      localcag.GUZ = 2L;
    }
    for (;;)
    {
      ad.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "doSettingsOplog() extStatus: %s, set_bitmask: %s, clear_bitmask:%s", new Object[] { Long.toBinaryString(this.pek), Long.toBinaryString(localcag.GUY), Long.toBinaryString(localcag.GUZ) });
      ((l)g.ab(l.class)).azo().c(new k.a(218, localcag));
      AppMethodBeat.o(69730);
      return;
      if (MT(2))
      {
        localcag.GUY = 2L;
        localcag.GUZ = 1L;
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
      eEo();
      Vt(1);
      this.pek |= 1L;
      this.pek &= 0xFFFFFFFD;
    }
    for (;;)
    {
      g.ajD();
      g.ajC().ajl().set(al.a.IFV, Long.valueOf(this.pek));
      this.mzx.notifyDataSetChanged();
      finish();
      AppMethodBeat.o(69731);
      return true;
      if ("refund_way_detail_origin".equals(paramf))
      {
        eEp();
        Vt(2);
        this.pek &= 0xFFFFFFFE;
        this.pek |= 0x2;
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