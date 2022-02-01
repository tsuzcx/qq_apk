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
import com.tencent.mm.g.b.a.en;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.c.ac;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Iterator;
import java.util.Vector;

public class WalletDigitalCertUI
  extends WalletBaseUI
{
  private ImageView fxT;
  private Button ipd;
  private TextView vwl;
  private Button zTf;
  private LinearLayout zTg;
  private TextView zTh;
  
  private void eaO()
  {
    AppMethodBeat.i(69637);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletDigitalCertUI", "updateCrtState");
    this.zTg.removeAllViews();
    if (com.tencent.mm.wallet_core.c.ad.fkc().fkd())
    {
      this.zTf.setVisibility(8);
      this.ipd.setVisibility(0);
      this.vwl.setText(2131765623);
      this.fxT.setImageResource(2131234646);
    }
    for (;;)
    {
      localObject = com.tencent.mm.wallet_core.c.ad.fkc().Ieh;
      if (((Vector)localObject).size() != 0) {
        break;
      }
      this.zTg.setVisibility(8);
      this.zTh.setVisibility(8);
      AppMethodBeat.o(69637);
      return;
      this.zTf.setVisibility(0);
      this.ipd.setVisibility(8);
      this.vwl.setText(2131765607);
      this.fxT.setImageResource(2131234647);
    }
    this.zTg.setVisibility(0);
    this.zTh.setVisibility(0);
    Object localObject = ((Vector)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ac localac = (ac)((Iterator)localObject).next();
      if (localac.Ieb <= 0)
      {
        View localView = View.inflate(this, 2131495932, null);
        TextView localTextView1 = (TextView)localView.findViewById(2131297943);
        TextView localTextView2 = (TextView)localView.findViewById(2131297938);
        TextView localTextView3 = (TextView)localView.findViewById(2131298958);
        localTextView1.setText(localac.EEr);
        localTextView2.setText(localac.Iea);
        localTextView3.setTag(localac);
        localTextView3.setOnClickListener(new com.tencent.mm.wallet_core.ui.d()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(69634);
            if ((paramAnonymousView.getTag() instanceof ac))
            {
              paramAnonymousView = (ac)paramAnonymousView.getTag();
              com.tencent.mm.ui.base.h.a(WalletDigitalCertUI.this, WalletDigitalCertUI.this.getString(2131765606, new Object[] { paramAnonymousView.EEr }), "", WalletDigitalCertUI.this.getString(2131755707), WalletDigitalCertUI.this.getString(2131755691), true, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(69633);
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletDigitalCertUI", "del crt %s", new Object[] { paramAnonymousView.EsX });
                  paramAnonymous2DialogInterface = new o(paramAnonymousView.EsX);
                  WalletDigitalCertUI.this.doSceneProgress(paramAnonymous2DialogInterface);
                  paramAnonymous2DialogInterface = new en();
                  paramAnonymous2DialogInterface.dMW = 2L;
                  paramAnonymous2DialogInterface.dZx = 1L;
                  paramAnonymous2DialogInterface.aBj();
                  AppMethodBeat.o(69633);
                }
              }, null);
            }
            AppMethodBeat.o(69634);
          }
        });
        this.zTg.addView(localView);
      }
    }
    if (this.zTg.getChildCount() == 0)
    {
      this.zTh.setVisibility(8);
      AppMethodBeat.o(69637);
      return;
    }
    this.zTh.setVisibility(0);
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
    this.fxT = ((ImageView)findViewById(2131297937));
    this.vwl = ((TextView)findViewById(2131297939));
    this.zTf = ((Button)findViewById(2131301038));
    this.ipd = ((Button)findViewById(2131298955));
    this.zTg = ((LinearLayout)findViewById(2131301041));
    this.zTh = ((TextView)findViewById(2131301042));
    this.zTf.setOnClickListener(new com.tencent.mm.wallet_core.ui.d()
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
    this.ipd.setOnClickListener(new com.tencent.mm.wallet_core.ui.d()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69631);
        com.tencent.mm.wallet_core.c.ad.fkc();
        paramAnonymousView = new o(com.tencent.mm.wallet_core.c.ad.getCrtNo());
        WalletDigitalCertUI.this.doSceneProgress(paramAnonymousView);
        com.tencent.mm.plugin.report.service.h.vKh.f(13731, new Object[] { Integer.valueOf(10) });
        AppMethodBeat.o(69631);
      }
    });
    setBackBtn(new w()
    {
      public final void VR()
      {
        AppMethodBeat.i(69632);
        WalletDigitalCertUI.this.finish();
        AppMethodBeat.o(69632);
      }
    });
    eaO();
    AppMethodBeat.o(69636);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(69642);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((1 == paramInt1) && (paramInt2 == -1))
    {
      boolean bool = ((a)g.ab(a.class)).ctN();
      Object localObject = com.tencent.mm.plugin.soter.d.d.dEQ();
      paramIntent = ((e)localObject).yaF;
      localObject = ((e)localObject).yaG;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletDigitalCertUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", new Object[] { Boolean.valueOf(bool) });
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
    com.tencent.mm.plugin.report.service.h.vKh.f(13731, new Object[] { Integer.valueOf(1) });
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
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
      paramString = new en();
      paramString.dMW = 2L;
      paramString.dZx = 2L;
      paramString.aBj();
      com.tencent.mm.plugin.report.service.h.vKh.f(13731, new Object[] { Integer.valueOf(11) });
      com.tencent.mm.wallet_core.c.ad.fkc().aNb(((o)paramn).IdI);
    }
    for (;;)
    {
      eaO();
      label92:
      AppMethodBeat.o(69641);
      return false;
      label100:
      com.tencent.mm.plugin.report.service.h.vKh.f(13731, new Object[] { Integer.valueOf(12) });
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