package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.kz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.pwd.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.c.ac;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Iterator;
import java.util.Vector;

public class WalletDigitalCertUI
  extends WalletBaseUI
{
  private ScrollView HJk;
  private Button HJl;
  private LinearLayout HJm;
  private TextView HJn;
  private ImageView HJo;
  private ImageView HJp;
  private TextView HJq;
  private TextView HJr;
  private ImageView gBZ;
  private Button kjo;
  private TextView uzB;
  
  private void fPd()
  {
    AppMethodBeat.i(69637);
    Log.i("MicroMsg.WalletDigitalCertUI", "updateCrtState");
    this.HJm.removeAllViews();
    Object localObject1 = ad.hhv().Rus;
    Object localObject2;
    if (ad.hhv().hhw())
    {
      this.HJl.setVisibility(8);
      this.kjo.setVisibility(0);
      this.uzB.setText(2131768076);
      if ((((Vector)localObject1).size() == 0) || (((Vector)localObject1).size() == 1))
      {
        this.HJk.setFillViewport(true);
        localObject2 = (RelativeLayout.LayoutParams)this.kjo.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 96);
        this.kjo.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    while (((Vector)localObject1).size() == 0)
    {
      this.HJm.setVisibility(8);
      this.HJn.setVisibility(8);
      AppMethodBeat.o(69637);
      return;
      this.HJk.setFillViewport(false);
      localObject2 = (RelativeLayout.LayoutParams)this.kjo.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131298269);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 48);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 64);
      this.kjo.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      continue;
      this.HJl.setVisibility(0);
      this.kjo.setVisibility(8);
      this.uzB.setText(2131768059);
      if (((Vector)localObject1).size() == 0)
      {
        this.HJk.setFillViewport(true);
        localObject2 = (RelativeLayout.LayoutParams)this.HJl.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 96);
        this.HJl.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      else
      {
        this.HJk.setFillViewport(false);
        localObject2 = (RelativeLayout.LayoutParams)this.HJl.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
        ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131298269);
        ((RelativeLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 48);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 64);
        this.HJl.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    this.HJm.setVisibility(0);
    this.HJn.setVisibility(0);
    localObject1 = ((Vector)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ac)((Iterator)localObject1).next();
      if (((ac)localObject2).Rum <= 0)
      {
        View localView = View.inflate(this, 2131496912, null);
        TextView localTextView1 = (TextView)localView.findViewById(2131298271);
        TextView localTextView2 = (TextView)localView.findViewById(2131298262);
        TextView localTextView3 = (TextView)localView.findViewById(2131299452);
        localTextView1.setText(((ac)localObject2).Ntg);
        localTextView2.setText(((ac)localObject2).Rul);
        localTextView3.setTag(localObject2);
        localTextView3.setOnClickListener(new com.tencent.mm.wallet_core.ui.d()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(214082);
            if ((paramAnonymousView.getTag() instanceof ac))
            {
              paramAnonymousView = (ac)paramAnonymousView.getTag();
              com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(WalletDigitalCertUI.this.getContext(), 1, true);
              TextView localTextView = new TextView(WalletDigitalCertUI.this.getContext());
              localTextView.setGravity(17);
              localTextView.setHeight(com.tencent.mm.cb.a.fromDPToPix(WalletDigitalCertUI.this.getContext(), 56));
              localTextView.setTextSize(12.0F);
              localTextView.setTextColor(WalletDigitalCertUI.this.getResources().getColor(2131099748));
              localTextView.setText(WalletDigitalCertUI.this.getString(2131768055, new Object[] { paramAnonymousView.Ntg }));
              locale.V(localTextView, false);
              locale.QOp = true;
              locale.HLX = new o.f()
              {
                public final void onCreateMMMenu(m paramAnonymous2m)
                {
                  AppMethodBeat.i(214080);
                  paramAnonymous2m.a(1, WalletDigitalCertUI.this.getContext().getResources().getColor(2131099818), WalletDigitalCertUI.this.getString(2131768057));
                  AppMethodBeat.o(214080);
                }
              };
              locale.HLY = new o.g()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(214081);
                  Log.i("MicroMsg.WalletDigitalCertUI", "del crt %s", new Object[] { paramAnonymousView.NgK });
                  paramAnonymous2MenuItem = new o(paramAnonymousView.NgK);
                  WalletDigitalCertUI.this.doSceneProgress(paramAnonymous2MenuItem);
                  paramAnonymous2MenuItem = new kz();
                  paramAnonymous2MenuItem.eEH = 2L;
                  paramAnonymous2MenuItem.eXI = 1L;
                  paramAnonymous2MenuItem.bfK();
                  AppMethodBeat.o(214081);
                }
              };
              locale.dGm();
            }
            AppMethodBeat.o(214082);
          }
        });
        this.HJm.addView(localView);
      }
    }
    if (this.HJm.getChildCount() == 0)
    {
      this.HJn.setVisibility(8);
      AppMethodBeat.o(69637);
      return;
    }
    this.HJn.setVisibility(0);
    AppMethodBeat.o(69637);
  }
  
  public int getLayoutId()
  {
    return 2131496926;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69636);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131099653));
    this.gBZ = ((ImageView)findViewById(2131298261));
    this.uzB = ((TextView)findViewById(2131298263));
    ao.a(this.uzB.getPaint(), 0.8F);
    this.HJl = ((Button)findViewById(2131302689));
    this.kjo = ((Button)findViewById(2131299449));
    this.HJm = ((LinearLayout)findViewById(2131302692));
    this.HJn = ((TextView)findViewById(2131302693));
    this.HJl.setOnClickListener(new com.tencent.mm.wallet_core.ui.d()
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
    this.kjo.setOnClickListener(new com.tencent.mm.wallet_core.ui.d()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69631);
        paramAnonymousView = new com.tencent.mm.ui.widget.a.e(WalletDigitalCertUI.this.getContext(), 1, true);
        TextView localTextView = new TextView(WalletDigitalCertUI.this.getContext());
        localTextView.setGravity(17);
        localTextView.setHeight(com.tencent.mm.cb.a.fromDPToPix(WalletDigitalCertUI.this.getContext(), 56));
        localTextView.setTextSize(12.0F);
        localTextView.setTextColor(WalletDigitalCertUI.this.getResources().getColor(2131099748));
        localTextView.setText(WalletDigitalCertUI.this.getString(2131768055, new Object[] { WalletDigitalCertUI.this.getString(2131768056) }));
        paramAnonymousView.V(localTextView, false);
        paramAnonymousView.QOp = true;
        paramAnonymousView.HLX = new o.f()
        {
          public final void onCreateMMMenu(m paramAnonymous2m)
          {
            AppMethodBeat.i(214076);
            paramAnonymous2m.a(1, WalletDigitalCertUI.this.getContext().getResources().getColor(2131099818), WalletDigitalCertUI.this.getString(2131768057));
            AppMethodBeat.o(214076);
          }
        };
        paramAnonymousView.HLY = new o.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(214077);
            ad.hhv();
            paramAnonymous2MenuItem = new o(ad.getCrtNo());
            WalletDigitalCertUI.this.doSceneProgress(paramAnonymous2MenuItem);
            h.CyF.a(13731, new Object[] { Integer.valueOf(10) });
            AppMethodBeat.o(214077);
          }
        };
        paramAnonymousView.dGm();
        AppMethodBeat.o(69631);
      }
    });
    this.HJk = ((ScrollView)findViewById(2131298273));
    setBackBtn(new y()
    {
      public final void ane()
      {
        AppMethodBeat.i(69632);
        WalletDigitalCertUI.this.finish();
        AppMethodBeat.o(69632);
      }
    });
    fPd();
    this.HJo = ((ImageView)findViewById(2131298268));
    this.HJp = ((ImageView)findViewById(2131298270));
    this.HJq = ((TextView)findViewById(2131298265));
    this.HJr = ((TextView)findViewById(2131298266));
    this.HJq.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(214078);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)WalletDigitalCertUI.a(WalletDigitalCertUI.this).getLayoutParams();
        localLayoutParams.topMargin = (WalletDigitalCertUI.b(WalletDigitalCertUI.this).getLineHeight() / 2);
        WalletDigitalCertUI.a(WalletDigitalCertUI.this).setLayoutParams(localLayoutParams);
        AppMethodBeat.o(214078);
      }
    });
    this.HJr.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(214079);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)WalletDigitalCertUI.c(WalletDigitalCertUI.this).getLayoutParams();
        localLayoutParams.topMargin = (WalletDigitalCertUI.d(WalletDigitalCertUI.this).getLineHeight() / 2);
        WalletDigitalCertUI.c(WalletDigitalCertUI.this).setLayoutParams(localLayoutParams);
        AppMethodBeat.o(214079);
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
      boolean bool = ((com.tencent.mm.plugin.fingerprint.d.a)g.af(com.tencent.mm.plugin.fingerprint.d.a.class)).dJO();
      Object localObject = com.tencent.mm.plugin.soter.d.d.flM();
      paramIntent = ((com.tencent.mm.plugin.soter.d.e)localObject).FhU;
      localObject = ((com.tencent.mm.plugin.soter.d.e)localObject).hFF;
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
    h.CyF.a(13731, new Object[] { Integer.valueOf(1) });
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
      if (!(paramq instanceof o)) {
        break label172;
      }
      if (paramInt2 != 0) {
        break label180;
      }
      paramString = new kz();
      paramString.eEH = 2L;
      paramString.eXI = 2L;
      paramString.bfK();
      h.CyF.a(13731, new Object[] { Integer.valueOf(11) });
      ad.hhv().bpo(((o)paramq).RtT);
      paramString = Toast.makeText(getContext(), "", 0);
      paramq = View.inflate(getContext(), 2131493459, null);
      ((WeImageView)paramq.findViewById(2131309259)).setImageResource(2131690537);
      ((TextView)paramq.findViewById(2131309260)).setText(getString(2131768058));
      paramString.setGravity(17, 0, 0);
      paramString.setView(paramq);
      paramString.show();
    }
    for (;;)
    {
      fPd();
      label172:
      AppMethodBeat.o(69641);
      return false;
      label180:
      h.CyF.a(13731, new Object[] { Integer.valueOf(12) });
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