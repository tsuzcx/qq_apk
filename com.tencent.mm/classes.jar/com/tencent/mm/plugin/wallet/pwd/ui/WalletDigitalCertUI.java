package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.b.a.nv;
import com.tencent.mm.plugin.wallet.pwd.a.n;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ab;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.c.ac;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Iterator;
import java.util.Vector;

public class WalletDigitalCertUI
  extends WalletBaseUI
{
  private ScrollView OBe;
  private Button OBf;
  private LinearLayout OBg;
  private TextView OBh;
  private ImageView OBi;
  private ImageView OBj;
  private TextView OBk;
  private TextView OBl;
  private ImageView jmf;
  private Button nbe;
  private TextView yVc;
  
  private void gHI()
  {
    AppMethodBeat.i(69637);
    Log.i("MicroMsg.WalletDigitalCertUI", "updateCrtState");
    this.OBg.removeAllViews();
    Object localObject1 = ad.iiX().YVQ;
    Object localObject2;
    if (ad.iiX().iiY())
    {
      this.OBf.setVisibility(8);
      this.nbe.setVisibility(0);
      this.yVc.setText(a.i.wallet_password_setting_digitalcert_succ);
      if ((((Vector)localObject1).size() == 0) || (((Vector)localObject1).size() == 1))
      {
        this.OBe.setFillViewport(true);
        localObject2 = (RelativeLayout.LayoutParams)this.nbe.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 96);
        this.nbe.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    while (((Vector)localObject1).size() == 0)
    {
      this.OBg.setVisibility(8);
      this.OBh.setVisibility(8);
      AppMethodBeat.o(69637);
      return;
      this.OBe.setFillViewport(false);
      localObject2 = (RelativeLayout.LayoutParams)this.nbe.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, a.f.cert_tips_second);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 48);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 64);
      this.nbe.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      continue;
      this.OBf.setVisibility(0);
      this.nbe.setVisibility(8);
      this.yVc.setText(a.i.wallet_password_setting_digitalcert_fail);
      if (((Vector)localObject1).size() == 0)
      {
        this.OBe.setFillViewport(true);
        localObject2 = (RelativeLayout.LayoutParams)this.OBf.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 96);
        this.OBf.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      else
      {
        this.OBe.setFillViewport(false);
        localObject2 = (RelativeLayout.LayoutParams)this.OBf.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
        ((RelativeLayout.LayoutParams)localObject2).addRule(3, a.f.cert_tips_second);
        ((RelativeLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 48);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 64);
        this.OBf.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    this.OBg.setVisibility(0);
    this.OBh.setVisibility(0);
    localObject1 = ((Vector)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ac)((Iterator)localObject1).next();
      if (((ac)localObject2).YVK <= 0)
      {
        View localView = View.inflate(this, a.g.wallet_cert_adapter_item, null);
        TextView localTextView1 = (TextView)localView.findViewById(a.f.cert_title);
        TextView localTextView2 = (TextView)localView.findViewById(a.f.cert_summary);
        TextView localTextView3 = (TextView)localView.findViewById(a.f.del_item);
        localTextView1.setText(((ac)localObject2).UGe);
        localTextView2.setText(((ac)localObject2).YVJ);
        localTextView3.setTag(localObject2);
        localTextView3.setOnClickListener(new com.tencent.mm.wallet_core.ui.d()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(193931);
            if ((paramAnonymousView.getTag() instanceof ac))
            {
              paramAnonymousView = (ac)paramAnonymousView.getTag();
              com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(WalletDigitalCertUI.this.getContext(), 1, true);
              TextView localTextView = new TextView(WalletDigitalCertUI.this.getContext());
              localTextView.setGravity(17);
              localTextView.setHeight(com.tencent.mm.ci.a.fromDPToPix(WalletDigitalCertUI.this.getContext(), 56));
              localTextView.setTextSize(12.0F);
              localTextView.setTextColor(WalletDigitalCertUI.this.getResources().getColor(a.c.FG_1));
              localTextView.setText(WalletDigitalCertUI.this.getString(a.i.wallet_password_setting_digitalcert_del_alert, new Object[] { paramAnonymousView.UGe }));
              locale.Z(localTextView, false);
              locale.Ynb = true;
              locale.ODT = new q.f()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
                {
                  AppMethodBeat.i(254243);
                  paramAnonymous2o.a(1, WalletDigitalCertUI.this.getContext().getResources().getColor(a.c.Red), WalletDigitalCertUI.this.getString(a.i.wallet_password_setting_digitalcert_del_item));
                  AppMethodBeat.o(254243);
                }
              };
              locale.ODU = new q.g()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(276835);
                  Log.i("MicroMsg.WalletDigitalCertUI", "del crt %s", new Object[] { paramAnonymousView.Uto });
                  paramAnonymous2MenuItem = new com.tencent.mm.wallet_core.c.o(paramAnonymousView.Uto);
                  WalletDigitalCertUI.this.doSceneProgress(paramAnonymous2MenuItem);
                  paramAnonymous2MenuItem = new nv();
                  paramAnonymous2MenuItem.gCd = 2L;
                  paramAnonymous2MenuItem.han = 1L;
                  paramAnonymous2MenuItem.bpa();
                  AppMethodBeat.o(276835);
                }
              };
              locale.eik();
            }
            AppMethodBeat.o(193931);
          }
        });
        this.OBg.addView(localView);
      }
    }
    if (this.OBg.getChildCount() == 0)
    {
      this.OBh.setVisibility(8);
      AppMethodBeat.o(69637);
      return;
    }
    this.OBh.setVisibility(0);
    AppMethodBeat.o(69637);
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_digital_certui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69636);
    setMMTitle("");
    setActionbarColor(getResources().getColor(a.c.BG_5));
    this.jmf = ((ImageView)findViewById(a.f.cert_icon_iv));
    this.yVc = ((TextView)findViewById(a.f.cert_tip_state));
    ar.a(this.yVc.getPaint(), 0.8F);
    this.OBf = ((Button)findViewById(a.f.install_cert));
    this.nbe = ((Button)findViewById(a.f.del_cert));
    this.OBg = ((LinearLayout)findViewById(a.f.installed_list));
    this.OBh = ((TextView)findViewById(a.f.installed_list_tip));
    this.OBf.setOnClickListener(new com.tencent.mm.wallet_core.ui.d()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69630);
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(WalletDigitalCertUI.this, WalletIdCardCheckUI.class);
        WalletDigitalCertUI.this.startActivityForResult(paramAnonymousView, 1);
        AppMethodBeat.o(69630);
      }
    });
    this.nbe.setOnClickListener(new com.tencent.mm.wallet_core.ui.d()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69631);
        paramAnonymousView = new com.tencent.mm.ui.widget.a.e(WalletDigitalCertUI.this.getContext(), 1, true);
        TextView localTextView = new TextView(WalletDigitalCertUI.this.getContext());
        localTextView.setGravity(17);
        localTextView.setHeight(com.tencent.mm.ci.a.fromDPToPix(WalletDigitalCertUI.this.getContext(), 56));
        localTextView.setTextSize(12.0F);
        localTextView.setTextColor(WalletDigitalCertUI.this.getResources().getColor(a.c.FG_1));
        localTextView.setText(WalletDigitalCertUI.this.getString(a.i.wallet_password_setting_digitalcert_del_alert, new Object[] { WalletDigitalCertUI.this.getString(a.i.wallet_password_setting_digitalcert_del_dialog_title_native) }));
        paramAnonymousView.Z(localTextView, false);
        paramAnonymousView.Ynb = true;
        paramAnonymousView.ODT = new q.f()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
          {
            AppMethodBeat.i(275277);
            paramAnonymous2o.a(1, WalletDigitalCertUI.this.getContext().getResources().getColor(a.c.Red), WalletDigitalCertUI.this.getString(a.i.wallet_password_setting_digitalcert_del_item));
            AppMethodBeat.o(275277);
          }
        };
        paramAnonymousView.ODU = new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(199040);
            ad.iiX();
            paramAnonymous2MenuItem = new com.tencent.mm.wallet_core.c.o(ad.getCrtNo());
            WalletDigitalCertUI.this.doSceneProgress(paramAnonymous2MenuItem);
            com.tencent.mm.plugin.report.service.h.IzE.a(13731, new Object[] { Integer.valueOf(10) });
            AppMethodBeat.o(199040);
          }
        };
        paramAnonymousView.eik();
        AppMethodBeat.o(69631);
      }
    });
    this.OBe = ((ScrollView)findViewById(a.f.cert_top_scroll));
    setBackBtn(new ab()
    {
      public final void atf()
      {
        AppMethodBeat.i(69632);
        WalletDigitalCertUI.this.finish();
        AppMethodBeat.o(69632);
      }
    });
    gHI();
    this.OBi = ((ImageView)findViewById(a.f.cert_tips_first_dot));
    this.OBj = ((ImageView)findViewById(a.f.cert_tips_second_dot));
    this.OBk = ((TextView)findViewById(a.f.cert_tip_title_first));
    this.OBl = ((TextView)findViewById(a.f.cert_tip_title_second));
    this.OBk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(271208);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)WalletDigitalCertUI.a(WalletDigitalCertUI.this).getLayoutParams();
        localLayoutParams.topMargin = (WalletDigitalCertUI.b(WalletDigitalCertUI.this).getLineHeight() / 2);
        WalletDigitalCertUI.a(WalletDigitalCertUI.this).setLayoutParams(localLayoutParams);
        AppMethodBeat.o(271208);
      }
    });
    this.OBl.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(201811);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)WalletDigitalCertUI.c(WalletDigitalCertUI.this).getLayoutParams();
        localLayoutParams.topMargin = (WalletDigitalCertUI.d(WalletDigitalCertUI.this).getLineHeight() / 2);
        WalletDigitalCertUI.c(WalletDigitalCertUI.this).setLayoutParams(localLayoutParams);
        AppMethodBeat.o(201811);
      }
    });
    AppMethodBeat.o(69636);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(69642);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((1 == paramInt1) && (paramInt2 == -1))
    {
      boolean bool = ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class)).eon();
      Object localObject = com.tencent.mm.plugin.soter.d.d.gai();
      paramIntent = ((com.tencent.mm.plugin.soter.d.e)localObject).Lwz;
      localObject = ((com.tencent.mm.plugin.soter.d.e)localObject).ktM;
      Log.i("MicroMsg.WalletDigitalCertUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", new Object[] { Boolean.valueOf(bool) });
      doSceneProgress(new n(bool, paramIntent, (String)localObject), false);
    }
    AppMethodBeat.o(69642);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69635);
    super.onCreate(paramBundle);
    addSceneEndListener(1654);
    addSceneEndListener(1568);
    addSceneEndListener(1669);
    initView();
    com.tencent.mm.plugin.report.service.h.IzE.a(13731, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(69635);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69640);
    super.onDestroy();
    removeSceneEndListener(1654);
    removeSceneEndListener(1568);
    removeSceneEndListener(1669);
    AppMethodBeat.o(69640);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69639);
    super.onPause();
    AppMethodBeat.o(69639);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69638);
    super.onResume();
    AppMethodBeat.o(69638);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(69641);
    if (!(paramq instanceof n))
    {
      if (!(paramq instanceof com.tencent.mm.wallet_core.c.o)) {
        break label173;
      }
      if (paramInt2 != 0) {
        break label181;
      }
      paramString = new nv();
      paramString.gCd = 2L;
      paramString.han = 2L;
      paramString.bpa();
      com.tencent.mm.plugin.report.service.h.IzE.a(13731, new Object[] { Integer.valueOf(11) });
      ad.iiX().bCl(((com.tencent.mm.wallet_core.c.o)paramq).YVs);
      paramString = Toast.makeText(getContext(), "", 0);
      paramq = View.inflate(getContext(), a.g.center_toast, null);
      ((WeImageView)paramq.findViewById(a.f.toast_img)).setImageResource(a.h.icons_filled_done);
      ((TextView)paramq.findViewById(a.f.toast_text)).setText(getString(a.i.wallet_password_setting_digitalcert_del_toast));
      paramString.setGravity(17, 0, 0);
      paramString.setView(paramq);
      paramString.show();
    }
    for (;;)
    {
      gHI();
      label173:
      AppMethodBeat.o(69641);
      return false;
      label181:
      com.tencent.mm.plugin.report.service.h.IzE.a(13731, new Object[] { Integer.valueOf(12) });
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI
 * JD-Core Version:    0.7.0.1
 */