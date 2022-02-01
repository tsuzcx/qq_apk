package com.tencent.mm.plugin.wallet.pwd.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.mmdata.rpt.rn;
import com.tencent.mm.plugin.soter.model.b;
import com.tencent.mm.plugin.soter.model.c;
import com.tencent.mm.plugin.wallet.pwd.a.m;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.model.ae;
import com.tencent.mm.wallet_core.model.o;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.d;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

public class WalletDigitalCertUI
  extends WalletBaseUI
{
  private TextView Dip;
  private ScrollView Vqr;
  private Button Vqs;
  private LinearLayout Vqt;
  private TextView Vqu;
  private ImageView Vqv;
  private ImageView Vqw;
  private TextView Vqx;
  private TextView Vqy;
  private ImageView lPb;
  private Button pYm;
  
  private void igN()
  {
    AppMethodBeat.i(69637);
    Log.i("MicroMsg.WalletDigitalCertUI", "updateCrtState");
    this.Vqt.removeAllViews();
    Object localObject1 = ae.jOT().agTK;
    Object localObject2;
    if (ae.jOT().jOU())
    {
      this.Vqs.setVisibility(8);
      this.pYm.setVisibility(0);
      this.Dip.setText(a.i.wallet_password_setting_digitalcert_succ);
      if ((((Vector)localObject1).size() == 0) || (((Vector)localObject1).size() == 1))
      {
        this.Vqr.setFillViewport(true);
        localObject2 = (RelativeLayout.LayoutParams)this.pYm.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 96);
        this.pYm.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    while (((Vector)localObject1).size() == 0)
    {
      this.Vqt.setVisibility(8);
      this.Vqu.setVisibility(8);
      AppMethodBeat.o(69637);
      return;
      this.Vqr.setFillViewport(false);
      localObject2 = (RelativeLayout.LayoutParams)this.pYm.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, a.f.cert_tips_second);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 48);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 64);
      this.pYm.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      continue;
      this.Vqs.setVisibility(0);
      this.pYm.setVisibility(8);
      this.Dip.setText(a.i.wallet_password_setting_digitalcert_fail);
      if (((Vector)localObject1).size() == 0)
      {
        this.Vqr.setFillViewport(true);
        localObject2 = (RelativeLayout.LayoutParams)this.Vqs.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 96);
        this.Vqs.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      else
      {
        this.Vqr.setFillViewport(false);
        localObject2 = (RelativeLayout.LayoutParams)this.Vqs.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
        ((RelativeLayout.LayoutParams)localObject2).addRule(3, a.f.cert_tips_second);
        ((RelativeLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 48);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 64);
        this.Vqs.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    this.Vqt.setVisibility(0);
    this.Vqu.setVisibility(0);
    localObject1 = ((Vector)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.wallet_core.model.ad)((Iterator)localObject1).next();
      if (((com.tencent.mm.wallet_core.model.ad)localObject2).agTE <= 0)
      {
        View localView = View.inflate(this, a.g.wallet_cert_adapter_item, null);
        TextView localTextView1 = (TextView)localView.findViewById(a.f.cert_title);
        TextView localTextView2 = (TextView)localView.findViewById(a.f.cert_summary);
        TextView localTextView3 = (TextView)localView.findViewById(a.f.del_item);
        localTextView1.setText(((com.tencent.mm.wallet_core.model.ad)localObject2).acao);
        localTextView2.setText(((com.tencent.mm.wallet_core.model.ad)localObject2).agTD);
        localTextView3.setTag(localObject2);
        localTextView3.setOnClickListener(new d()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(315650);
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.wallet_core.model.ad))
            {
              paramAnonymousView = (com.tencent.mm.wallet_core.model.ad)paramAnonymousView.getTag();
              f localf = new f(WalletDigitalCertUI.this.getContext(), 1, true);
              TextView localTextView = new TextView(WalletDigitalCertUI.this.getContext());
              localTextView.setGravity(17);
              localTextView.setHeight(com.tencent.mm.cd.a.fromDPToPix(WalletDigitalCertUI.this.getContext(), 56));
              localTextView.setTextSize(12.0F);
              localTextView.setTextColor(WalletDigitalCertUI.this.getResources().getColor(a.c.FG_1));
              localTextView.setText(WalletDigitalCertUI.this.getString(a.i.wallet_password_setting_digitalcert_del_alert, new Object[] { paramAnonymousView.acao }));
              localf.af(localTextView, false);
              localf.ageZ = true;
              localf.Vtg = new u.g()
              {
                public final void onCreateMMMenu(s paramAnonymous2s)
                {
                  AppMethodBeat.i(315671);
                  paramAnonymous2s.a(1, WalletDigitalCertUI.this.getContext().getResources().getColor(a.c.Red), WalletDigitalCertUI.this.getString(a.i.wallet_password_setting_digitalcert_del_item));
                  AppMethodBeat.o(315671);
                }
              };
              localf.GAC = new u.i()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(315670);
                  Log.i("MicroMsg.WalletDigitalCertUI", "del crt %s", new Object[] { paramAnonymousView.abMG });
                  paramAnonymous2MenuItem = new o(paramAnonymousView.abMG);
                  WalletDigitalCertUI.this.doSceneProgress(paramAnonymous2MenuItem);
                  paramAnonymous2MenuItem = new rn();
                  paramAnonymous2MenuItem.iPe = 2L;
                  paramAnonymous2MenuItem.jvX = 1L;
                  paramAnonymous2MenuItem.bMH();
                  AppMethodBeat.o(315670);
                }
              };
              localf.dDn();
            }
            AppMethodBeat.o(315650);
          }
        });
        this.Vqt.addView(localView);
      }
    }
    if (this.Vqt.getChildCount() == 0)
    {
      this.Vqu.setVisibility(8);
      AppMethodBeat.o(69637);
      return;
    }
    this.Vqu.setVisibility(0);
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
    this.lPb = ((ImageView)findViewById(a.f.cert_icon_iv));
    this.Dip = ((TextView)findViewById(a.f.cert_tip_state));
    aw.a(this.Dip.getPaint(), 0.8F);
    this.Vqs = ((Button)findViewById(a.f.install_cert));
    this.pYm = ((Button)findViewById(a.f.del_cert));
    this.Vqt = ((LinearLayout)findViewById(a.f.installed_list));
    this.Vqu = ((TextView)findViewById(a.f.installed_list_tip));
    this.Vqs.setOnClickListener(new d()
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
    this.pYm.setOnClickListener(new d()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69631);
        paramAnonymousView = new f(WalletDigitalCertUI.this.getContext(), 1, true);
        TextView localTextView = new TextView(WalletDigitalCertUI.this.getContext());
        localTextView.setGravity(17);
        localTextView.setHeight(com.tencent.mm.cd.a.fromDPToPix(WalletDigitalCertUI.this.getContext(), 56));
        localTextView.setTextSize(12.0F);
        localTextView.setTextColor(WalletDigitalCertUI.this.getResources().getColor(a.c.FG_1));
        localTextView.setText(WalletDigitalCertUI.this.getString(a.i.wallet_password_setting_digitalcert_del_alert, new Object[] { WalletDigitalCertUI.this.getString(a.i.wallet_password_setting_digitalcert_del_dialog_title_native) }));
        paramAnonymousView.af(localTextView, false);
        paramAnonymousView.ageZ = true;
        paramAnonymousView.Vtg = new u.g()
        {
          public final void onCreateMMMenu(s paramAnonymous2s)
          {
            AppMethodBeat.i(315679);
            paramAnonymous2s.a(1, WalletDigitalCertUI.this.getContext().getResources().getColor(a.c.Red), WalletDigitalCertUI.this.getString(a.i.wallet_password_setting_digitalcert_del_item));
            AppMethodBeat.o(315679);
          }
        };
        paramAnonymousView.GAC = new u.i()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(315674);
            ae.jOT();
            paramAnonymous2MenuItem = new o(ae.getCrtNo());
            WalletDigitalCertUI.this.doSceneProgress(paramAnonymous2MenuItem);
            com.tencent.mm.plugin.report.service.h.OAn.b(13731, new Object[] { Integer.valueOf(10) });
            AppMethodBeat.o(315674);
          }
        };
        paramAnonymousView.dDn();
        AppMethodBeat.o(69631);
      }
    });
    this.Vqr = ((ScrollView)findViewById(a.f.cert_top_scroll));
    setBackBtn(new com.tencent.mm.ui.ad()
    {
      public final void d(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(315654);
        WalletDigitalCertUI.this.finish();
        AppMethodBeat.o(315654);
      }
    });
    igN();
    this.Vqv = ((ImageView)findViewById(a.f.cert_tips_first_dot));
    this.Vqw = ((ImageView)findViewById(a.f.cert_tips_second_dot));
    this.Vqx = ((TextView)findViewById(a.f.cert_tip_title_first));
    this.Vqy = ((TextView)findViewById(a.f.cert_tip_title_second));
    this.Vqx.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(315653);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)WalletDigitalCertUI.a(WalletDigitalCertUI.this).getLayoutParams();
        localLayoutParams.topMargin = (WalletDigitalCertUI.b(WalletDigitalCertUI.this).getLineHeight() / 2);
        WalletDigitalCertUI.a(WalletDigitalCertUI.this).setLayoutParams(localLayoutParams);
        AppMethodBeat.o(315653);
      }
    });
    this.Vqy.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(315651);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)WalletDigitalCertUI.c(WalletDigitalCertUI.this).getLayoutParams();
        localLayoutParams.topMargin = (WalletDigitalCertUI.d(WalletDigitalCertUI.this).getLineHeight() / 2);
        WalletDigitalCertUI.c(WalletDigitalCertUI.this).setLayoutParams(localLayoutParams);
        AppMethodBeat.o(315651);
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
      boolean bool = ((com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class)).ftq();
      Object localObject = b.htz();
      paramIntent = ((c)localObject).RZY;
      localObject = ((c)localObject).mXG;
      Log.i("MicroMsg.WalletDigitalCertUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", new Object[] { Boolean.valueOf(bool) });
      doSceneProgress(new m(bool, paramIntent, (String)localObject), false);
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
    com.tencent.mm.plugin.report.service.h.OAn.b(13731, new Object[] { Integer.valueOf(1) });
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(69641);
    if (!(paramp instanceof m))
    {
      if (!(paramp instanceof o)) {
        break label173;
      }
      if (paramInt2 != 0) {
        break label181;
      }
      paramString = new rn();
      paramString.iPe = 2L;
      paramString.jvX = 2L;
      paramString.bMH();
      com.tencent.mm.plugin.report.service.h.OAn.b(13731, new Object[] { Integer.valueOf(11) });
      ae.jOT().bEG(((o)paramp).agTm);
      paramString = Toast.makeText(getContext(), "", 0);
      paramp = View.inflate(getContext(), a.g.center_toast, null);
      ((WeImageView)paramp.findViewById(a.f.toast_img)).setImageResource(a.h.icons_filled_done);
      ((TextView)paramp.findViewById(a.f.toast_text)).setText(getString(a.i.wallet_password_setting_digitalcert_del_toast));
      paramString.setGravity(17, 0, 0);
      paramString.setView(paramp);
      paramString.show();
    }
    for (;;)
    {
      igN();
      label173:
      AppMethodBeat.o(69641);
      return false;
      label181:
      com.tencent.mm.plugin.report.service.h.OAn.b(13731, new Object[] { Integer.valueOf(12) });
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(315678);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(WalletDigitalCertUI.a.class);
    AppMethodBeat.o(315678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI
 * JD-Core Version:    0.7.0.1
 */