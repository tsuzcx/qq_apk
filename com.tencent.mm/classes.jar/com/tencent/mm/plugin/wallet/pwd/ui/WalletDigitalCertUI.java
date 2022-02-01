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
import com.tencent.mm.g.b.a.gd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Iterator;
import java.util.Vector;

public class WalletDigitalCertUI
  extends WalletBaseUI
{
  private LinearLayout BlA;
  private TextView BlB;
  private Button Blz;
  private ImageView fBA;
  private Button iPj;
  private TextView wGq;
  
  private void eqk()
  {
    AppMethodBeat.i(69637);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletDigitalCertUI", "updateCrtState");
    this.BlA.removeAllViews();
    if (ad.fAs().fAt())
    {
      this.Blz.setVisibility(8);
      this.iPj.setVisibility(0);
      this.wGq.setText(2131765623);
      this.fBA.setImageResource(2131234646);
    }
    for (;;)
    {
      localObject = ad.fAs().JFJ;
      if (((Vector)localObject).size() != 0) {
        break;
      }
      this.BlA.setVisibility(8);
      this.BlB.setVisibility(8);
      AppMethodBeat.o(69637);
      return;
      this.Blz.setVisibility(0);
      this.iPj.setVisibility(8);
      this.wGq.setText(2131765607);
      this.fBA.setImageResource(2131234647);
    }
    this.BlA.setVisibility(0);
    this.BlB.setVisibility(0);
    Object localObject = ((Vector)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.wallet_core.c.ac localac = (com.tencent.mm.wallet_core.c.ac)((Iterator)localObject).next();
      if (localac.JFD <= 0)
      {
        View localView = View.inflate(this, 2131495932, null);
        TextView localTextView1 = (TextView)localView.findViewById(2131297943);
        TextView localTextView2 = (TextView)localView.findViewById(2131297938);
        TextView localTextView3 = (TextView)localView.findViewById(2131298958);
        localTextView1.setText(localac.GbE);
        localTextView2.setText(localac.JFC);
        localTextView3.setTag(localac);
        localTextView3.setOnClickListener(new com.tencent.mm.wallet_core.ui.d()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(69634);
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.wallet_core.c.ac))
            {
              paramAnonymousView = (com.tencent.mm.wallet_core.c.ac)paramAnonymousView.getTag();
              com.tencent.mm.ui.base.h.a(WalletDigitalCertUI.this, WalletDigitalCertUI.this.getString(2131765606, new Object[] { paramAnonymousView.GbE }), "", WalletDigitalCertUI.this.getString(2131755707), WalletDigitalCertUI.this.getString(2131755691), true, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(69633);
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletDigitalCertUI", "del crt %s", new Object[] { paramAnonymousView.FPZ });
                  paramAnonymous2DialogInterface = new o(paramAnonymousView.FPZ);
                  WalletDigitalCertUI.this.doSceneProgress(paramAnonymous2DialogInterface);
                  paramAnonymous2DialogInterface = new gd();
                  paramAnonymous2DialogInterface.dNx = 2L;
                  paramAnonymous2DialogInterface.ebp = 1L;
                  paramAnonymous2DialogInterface.aHZ();
                  AppMethodBeat.o(69633);
                }
              }, null);
            }
            AppMethodBeat.o(69634);
          }
        });
        this.BlA.addView(localView);
      }
    }
    if (this.BlA.getChildCount() == 0)
    {
      this.BlB.setVisibility(8);
      AppMethodBeat.o(69637);
      return;
    }
    this.BlB.setVisibility(0);
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
    this.fBA = ((ImageView)findViewById(2131297937));
    this.wGq = ((TextView)findViewById(2131297939));
    this.Blz = ((Button)findViewById(2131301038));
    this.iPj = ((Button)findViewById(2131298955));
    this.BlA = ((LinearLayout)findViewById(2131301041));
    this.BlB = ((TextView)findViewById(2131301042));
    this.Blz.setOnClickListener(new com.tencent.mm.wallet_core.ui.d()
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
    this.iPj.setOnClickListener(new com.tencent.mm.wallet_core.ui.d()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69631);
        ad.fAs();
        paramAnonymousView = new o(ad.getCrtNo());
        WalletDigitalCertUI.this.doSceneProgress(paramAnonymousView);
        com.tencent.mm.plugin.report.service.h.wUl.f(13731, new Object[] { Integer.valueOf(10) });
        AppMethodBeat.o(69631);
      }
    });
    setBackBtn(new x()
    {
      public final void WP()
      {
        AppMethodBeat.i(69632);
        WalletDigitalCertUI.this.finish();
        AppMethodBeat.o(69632);
      }
    });
    eqk();
    AppMethodBeat.o(69636);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(69642);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((1 == paramInt1) && (paramInt2 == -1))
    {
      boolean bool = ((a)g.ab(a.class)).cGZ();
      Object localObject = com.tencent.mm.plugin.soter.d.d.dTq();
      paramIntent = ((e)localObject).znE;
      localObject = ((e)localObject).znF;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WalletDigitalCertUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", new Object[] { Boolean.valueOf(bool) });
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
    com.tencent.mm.plugin.report.service.h.wUl.f(13731, new Object[] { Integer.valueOf(1) });
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
      paramString = new gd();
      paramString.dNx = 2L;
      paramString.ebp = 2L;
      paramString.aHZ();
      com.tencent.mm.plugin.report.service.h.wUl.f(13731, new Object[] { Integer.valueOf(11) });
      ad.fAs().aSE(((o)paramn).JFk);
    }
    for (;;)
    {
      eqk();
      label92:
      AppMethodBeat.o(69641);
      return false;
      label100:
      com.tencent.mm.plugin.report.service.h.wUl.f(13731, new Object[] { Integer.valueOf(12) });
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