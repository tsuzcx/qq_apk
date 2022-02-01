package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hi;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.c.ac;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Iterator;
import java.util.Vector;

public class WalletDigitalCertUI
  extends WalletBaseUI
{
  private Button Ddw;
  private LinearLayout Ddx;
  private TextView Ddy;
  private ImageView fWT;
  private Button jll;
  private TextView yjQ;
  
  private void eHR()
  {
    AppMethodBeat.i(69637);
    ae.i("MicroMsg.WalletDigitalCertUI", "updateCrtState");
    this.Ddx.removeAllViews();
    if (ad.fVY().fVZ())
    {
      this.Ddw.setVisibility(8);
      this.jll.setVisibility(0);
      this.yjQ.setText(2131765623);
      this.fWT.setImageResource(2131234646);
    }
    for (;;)
    {
      localObject = ad.fVY().LVC;
      if (((Vector)localObject).size() != 0) {
        break;
      }
      this.Ddx.setVisibility(8);
      this.Ddy.setVisibility(8);
      AppMethodBeat.o(69637);
      return;
      this.Ddw.setVisibility(0);
      this.jll.setVisibility(8);
      this.yjQ.setText(2131765607);
      this.fWT.setImageResource(2131234647);
    }
    this.Ddx.setVisibility(0);
    this.Ddy.setVisibility(0);
    Object localObject = ((Vector)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ac localac = (ac)((Iterator)localObject).next();
      if (localac.LVw <= 0)
      {
        View localView = View.inflate(this, 2131495932, null);
        TextView localTextView1 = (TextView)localView.findViewById(2131297943);
        TextView localTextView2 = (TextView)localView.findViewById(2131297938);
        TextView localTextView3 = (TextView)localView.findViewById(2131298958);
        localTextView1.setText(localac.IgI);
        localTextView2.setText(localac.LVv);
        localTextView3.setTag(localac);
        localTextView3.setOnClickListener(new com.tencent.mm.wallet_core.ui.d()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(69634);
            if ((paramAnonymousView.getTag() instanceof ac))
            {
              paramAnonymousView = (ac)paramAnonymousView.getTag();
              h.a(WalletDigitalCertUI.this, WalletDigitalCertUI.this.getString(2131765606, new Object[] { paramAnonymousView.IgI }), "", WalletDigitalCertUI.this.getString(2131755707), WalletDigitalCertUI.this.getString(2131755691), true, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(69633);
                  ae.i("MicroMsg.WalletDigitalCertUI", "del crt %s", new Object[] { paramAnonymousView.HUr });
                  paramAnonymous2DialogInterface = new o(paramAnonymousView.HUr);
                  WalletDigitalCertUI.this.doSceneProgress(paramAnonymous2DialogInterface);
                  paramAnonymous2DialogInterface = new hi();
                  paramAnonymous2DialogInterface.eeh = 2L;
                  paramAnonymous2DialogInterface.etC = 1L;
                  paramAnonymous2DialogInterface.aLH();
                  AppMethodBeat.o(69633);
                }
              }, null);
            }
            AppMethodBeat.o(69634);
          }
        });
        this.Ddx.addView(localView);
      }
    }
    if (this.Ddx.getChildCount() == 0)
    {
      this.Ddy.setVisibility(8);
      AppMethodBeat.o(69637);
      return;
    }
    this.Ddy.setVisibility(0);
    AppMethodBeat.o(69637);
  }
  
  public int getLayoutId()
  {
    return 2131495946;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69636);
    setMMTitle(2131765604);
    this.fWT = ((ImageView)findViewById(2131297937));
    this.yjQ = ((TextView)findViewById(2131297939));
    this.Ddw = ((Button)findViewById(2131301038));
    this.jll = ((Button)findViewById(2131298955));
    this.Ddx = ((LinearLayout)findViewById(2131301041));
    this.Ddy = ((TextView)findViewById(2131301042));
    this.Ddw.setOnClickListener(new com.tencent.mm.wallet_core.ui.d()
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
    this.jll.setOnClickListener(new com.tencent.mm.wallet_core.ui.d()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69631);
        ad.fVY();
        paramAnonymousView = new o(ad.getCrtNo());
        WalletDigitalCertUI.this.doSceneProgress(paramAnonymousView);
        com.tencent.mm.plugin.report.service.g.yxI.f(13731, new Object[] { Integer.valueOf(10) });
        AppMethodBeat.o(69631);
      }
    });
    setBackBtn(new x()
    {
      public final void Zr()
      {
        AppMethodBeat.i(69632);
        WalletDigitalCertUI.this.finish();
        AppMethodBeat.o(69632);
      }
    });
    eHR();
    AppMethodBeat.o(69636);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(69642);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((1 == paramInt1) && (paramInt2 == -1))
    {
      boolean bool = ((a)com.tencent.mm.kernel.g.ab(a.class)).cRT();
      Object localObject = com.tencent.mm.plugin.soter.d.d.ejm();
      paramIntent = ((e)localObject).AXb;
      localObject = ((e)localObject).AXc;
      ae.i("MicroMsg.WalletDigitalCertUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", new Object[] { Boolean.valueOf(bool) });
      doSceneProgress(new com.tencent.mm.plugin.wallet.pwd.a.n(bool, paramIntent, (String)localObject), false);
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
    com.tencent.mm.plugin.report.service.g.yxI.f(13731, new Object[] { Integer.valueOf(1) });
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(69641);
    if (!(paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.n))
    {
      if (!(paramn instanceof o)) {
        break label92;
      }
      if (paramInt2 != 0) {
        break label100;
      }
      paramString = new hi();
      paramString.eeh = 2L;
      paramString.etC = 2L;
      paramString.aLH();
      com.tencent.mm.plugin.report.service.g.yxI.f(13731, new Object[] { Integer.valueOf(11) });
      ad.fVY().bag(((o)paramn).LVd);
    }
    for (;;)
    {
      eHR();
      label92:
      AppMethodBeat.o(69641);
      return false;
      label100:
      com.tencent.mm.plugin.report.service.g.yxI.f(13731, new Object[] { Integer.valueOf(12) });
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI
 * JD-Core Version:    0.7.0.1
 */