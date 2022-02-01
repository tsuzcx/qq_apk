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
import com.tencent.mm.g.b.a.he;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet.pwd.a.f.b;
import com.tencent.mm.protocal.protobuf.cba;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletLuckyMoneyRefundWayUI
  extends MMPreference
{
  private Preference Dds;
  private RadioBelowSummarytAndIconPreference Deo;
  private RadioBelowSummarytAndIconPreference Dep;
  private com.tencent.mm.plugin.wallet.pwd.a.f.a Deq;
  private f mEx;
  private long pkQ;
  
  private boolean Nz(int paramInt)
  {
    return (this.pkQ & paramInt) != 0L;
  }
  
  private void Wb(int paramInt)
  {
    AppMethodBeat.i(69732);
    he localhe = new he();
    if (bu.az(this.pkQ & 0x3, 2L)) {}
    for (int i = 2;; i = 1)
    {
      localhe.dWW = i;
      localhe.etr = paramInt;
      localhe.aLH();
      AppMethodBeat.o(69732);
      return;
    }
  }
  
  private void eHV()
  {
    AppMethodBeat.i(69733);
    this.Deo.setWidgetLayoutResource(2131494878);
    this.Dep.setWidgetLayoutResource(2131494879);
    AppMethodBeat.o(69733);
  }
  
  private void eHW()
  {
    AppMethodBeat.i(69734);
    this.Deo.setWidgetLayoutResource(2131494879);
    this.Dep.setWidgetLayoutResource(2131494878);
    AppMethodBeat.o(69734);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69729);
    this.Dds = this.mEx.aXe("refund_way_detail");
    this.Deo = ((RadioBelowSummarytAndIconPreference)this.mEx.aXe("refund_way_detail_lq"));
    this.Dep = ((RadioBelowSummarytAndIconPreference)this.mEx.aXe("refund_way_detail_origin"));
    if (this.Dds != null) {
      this.Dds.setTitle(this.Deq.Dcp);
    }
    if (this.Deo != null)
    {
      this.Deo.setTitle(this.Deq.Dcl);
      this.Deo.setSummary(this.Deq.Dcm);
    }
    if (this.Dep != null)
    {
      this.Dep.setTitle(this.Deq.Dcn);
      this.Dep.setSummary(this.Deq.Dco);
      RadioBelowSummarytAndIconPreference localRadioBelowSummarytAndIconPreference = this.Dep;
      View.OnClickListener local1 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69726);
          Object localObject1 = new b();
          ((b)localObject1).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletLuckyMoneyRefundWayUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).ahF());
          ae.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "mOriginWay click!!");
          localObject1 = new a(WalletLuckyMoneyRefundWayUI.this, WalletLuckyMoneyRefundWayUI.a(WalletLuckyMoneyRefundWayUI.this));
          View localView = View.inflate(((a)localObject1).mContext, 2131496019, null);
          LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131304241);
          if (((a)localObject1).Deq.Dcr.size() > 0)
          {
            Iterator localIterator = ((a)localObject1).Deq.Dcr.iterator();
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
                  paramAnonymousView.setMargins(0, com.tencent.mm.cb.a.fromDPToPix(((a)localObject1).mContext, 24), 0, 0);
                  ((View)localObject2).setLayoutParams(paramAnonymousView);
                }
              }
              else
              {
                paramAnonymousView = (ImageView)((View)localObject2).findViewById(2131300874);
                localTextView = (TextView)((View)localObject2).findViewById(2131305902);
                localObject2 = (TextView)((View)localObject2).findViewById(2131305529);
                if (!bu.isNullOrNil(localb.Dct)) {
                  break label307;
                }
                com.tencent.mm.av.a.a.aJh().a(localb.hBq, paramAnonymousView, new c.a().aJu());
              }
              for (;;)
              {
                localTextView.setText(localb.title);
                ((TextView)localObject2).setText(localb.desc);
                break;
                paramAnonymousView = new ViewGroup.MarginLayoutParams(paramAnonymousView);
                break label182;
                label307:
                com.tencent.mm.av.a.a locala = com.tencent.mm.av.a.a.aJh();
                String str = localb.hBq;
                c.a locala1 = new c.a();
                locala1.md5 = localb.Dct;
                locala.a(str, paramAnonymousView, locala1.aJu());
              }
            }
          }
          paramAnonymousView = new com.tencent.mm.ui.widget.a.f.a(((a)localObject1).mContext);
          paramAnonymousView.au(((a)localObject1).Deq.Dcq).hg(localView).aZu(((a)localObject1).mContext.getString(2131765505)).afZ(((a)localObject1).mContext.getResources().getColor(2131101134)).EyN = true;
          paramAnonymousView.b(new a.1((a)localObject1)).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletLuckyMoneyRefundWayUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69726);
        }
      };
      localRadioBelowSummarytAndIconPreference.aeA = 2131233821;
      localRadioBelowSummarytAndIconPreference.DcS = local1;
    }
    if (bu.az(this.pkQ & 0x3, 2L)) {
      eHW();
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
      eHV();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69728);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getActionbarColor());
    paramBundle = getIntent().getStringExtra("key_hb_refund_config");
    if (!bu.isNullOrNil(paramBundle))
    {
      this.Deq = com.tencent.mm.plugin.wallet.pwd.a.f.a.aFB(paramBundle);
      ae.d("MicroMsg.WalletLuckyMoneyRefundWayUI", "mHbRefundConfig:%s", new Object[] { this.Deq });
    }
    for (;;)
    {
      this.mEx = getPreferenceScreen();
      this.mEx.addPreferencesFromResource(2131951759);
      setMMTitle(this.Deq.Dcj);
      g.ajS();
      this.pkQ = ((Long)g.ajR().ajA().get(am.a.Jav, Long.valueOf(0L))).longValue();
      ae.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "origin extStatus: %s", new Object[] { Long.toBinaryString(this.pkQ) });
      initView();
      AppMethodBeat.o(69728);
      return;
      ae.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "mHbRefundConfig == null");
      finish();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69730);
    super.onDestroy();
    cba localcba = new cba();
    if (Nz(1))
    {
      localcba.Hoz = 1L;
      localcba.HoA = 2L;
    }
    for (;;)
    {
      ae.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "doSettingsOplog() extStatus: %s, set_bitmask: %s, clear_bitmask:%s", new Object[] { Long.toBinaryString(this.pkQ), Long.toBinaryString(localcba.Hoz), Long.toBinaryString(localcba.HoA) });
      ((l)g.ab(l.class)).azE().d(new k.a(218, localcba));
      AppMethodBeat.o(69730);
      return;
      if (Nz(2))
      {
        localcba.Hoz = 2L;
        localcba.HoA = 1L;
      }
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69731);
    paramf = paramPreference.mKey;
    ae.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "onPreferenceTreeClick() key:%s", new Object[] { paramf });
    if ("refund_way_detail_lq".equals(paramf))
    {
      eHV();
      Wb(1);
      this.pkQ |= 1L;
      this.pkQ &= 0xFFFFFFFD;
    }
    for (;;)
    {
      g.ajS();
      g.ajR().ajA().set(am.a.Jav, Long.valueOf(this.pkQ));
      this.mEx.notifyDataSetChanged();
      finish();
      AppMethodBeat.o(69731);
      return true;
      if ("refund_way_detail_origin".equals(paramf))
      {
        eHW();
        Wb(2);
        this.pkQ &= 0xFFFFFFFE;
        this.pkQ |= 0x2;
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