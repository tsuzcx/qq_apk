package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Iterator;
import java.util.Vector;

public class WalletDigitalCertUI
  extends WalletBaseUI
{
  private Button gBJ;
  private ImageView iQd;
  private TextView qhN;
  private Button tYO;
  private LinearLayout tYP;
  private TextView tYQ;
  
  private void cSC()
  {
    AppMethodBeat.i(46258);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletDigitalCertUI", "updateCrtState");
    this.tYP.removeAllViews();
    if (com.tencent.mm.wallet_core.c.ab.dSv().dSw())
    {
      this.tYO.setVisibility(8);
      this.gBJ.setVisibility(0);
      this.qhN.setText(2131305409);
      this.iQd.setImageResource(2130840825);
    }
    for (;;)
    {
      localObject = com.tencent.mm.wallet_core.c.ab.dSv().AXu;
      if (((Vector)localObject).size() != 0) {
        break;
      }
      this.tYP.setVisibility(8);
      this.tYQ.setVisibility(8);
      AppMethodBeat.o(46258);
      return;
      this.tYO.setVisibility(0);
      this.gBJ.setVisibility(8);
      this.qhN.setText(2131305393);
      this.iQd.setImageResource(2130840826);
    }
    this.tYP.setVisibility(0);
    this.tYQ.setVisibility(0);
    Object localObject = ((Vector)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      aa localaa = (aa)((Iterator)localObject).next();
      if (localaa.AXo <= 0)
      {
        View localView = View.inflate(this, 2130971158, null);
        TextView localTextView1 = (TextView)localView.findViewById(2131829076);
        TextView localTextView2 = (TextView)localView.findViewById(2131829077);
        TextView localTextView3 = (TextView)localView.findViewById(2131829078);
        localTextView1.setText(localaa.ycL);
        localTextView2.setText(localaa.AXn);
        localTextView3.setTag(localaa);
        localTextView3.setOnClickListener(new WalletDigitalCertUI.4(this));
        this.tYP.addView(localView);
      }
    }
    if (this.tYP.getChildCount() == 0)
    {
      this.tYQ.setVisibility(8);
      AppMethodBeat.o(46258);
      return;
    }
    this.tYQ.setVisibility(0);
    AppMethodBeat.o(46258);
  }
  
  public int getLayoutId()
  {
    return 2130971172;
  }
  
  public void initView()
  {
    AppMethodBeat.i(46257);
    setMMTitle(2131305390);
    this.iQd = ((ImageView)findViewById(2131829113));
    this.qhN = ((TextView)findViewById(2131829114));
    this.tYO = ((Button)findViewById(2131829118));
    this.gBJ = ((Button)findViewById(2131829119));
    this.tYP = ((LinearLayout)findViewById(2131829121));
    this.tYQ = ((TextView)findViewById(2131829120));
    this.tYO.setOnClickListener(new WalletDigitalCertUI.1(this));
    this.gBJ.setOnClickListener(new WalletDigitalCertUI.2(this));
    setBackBtn(new WalletDigitalCertUI.3(this));
    cSC();
    AppMethodBeat.o(46257);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(46263);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((1 == paramInt1) && (paramInt2 == -1))
    {
      boolean bool = ((com.tencent.mm.pluginsdk.l)g.E(com.tencent.mm.pluginsdk.l.class)).byS();
      Object localObject = d.cyc();
      paramIntent = ((e)localObject).son;
      localObject = ((e)localObject).kbP;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletDigitalCertUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", new Object[] { Boolean.valueOf(bool) });
      doSceneProgress(new com.tencent.mm.plugin.wallet.pwd.a.l(bool, paramIntent, (String)localObject), false);
    }
    AppMethodBeat.o(46263);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(46256);
    super.onCreate(paramBundle);
    addSceneEndListener(1654);
    addSceneEndListener(1568);
    addSceneEndListener(1669);
    initView();
    h.qsU.e(13731, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(46256);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(46261);
    super.onDestroy();
    removeSceneEndListener(1654);
    removeSceneEndListener(1568);
    removeSceneEndListener(1669);
    AppMethodBeat.o(46261);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(46260);
    super.onPause();
    AppMethodBeat.o(46260);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(46259);
    super.onResume();
    AppMethodBeat.o(46259);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(46262);
    if (!(paramm instanceof com.tencent.mm.plugin.wallet.pwd.a.l))
    {
      if (!(paramm instanceof com.tencent.mm.wallet_core.c.m)) {
        break label92;
      }
      if (paramInt2 != 0) {
        break label100;
      }
      paramString = new bt();
      paramString.cRI = 2L;
      paramString.cYT = 2L;
      paramString.ake();
      h.qsU.e(13731, new Object[] { Integer.valueOf(11) });
      com.tencent.mm.wallet_core.c.ab.dSv().avY(((com.tencent.mm.wallet_core.c.m)paramm).AWV);
    }
    for (;;)
    {
      cSC();
      label92:
      AppMethodBeat.o(46262);
      return false;
      label100:
      h.qsU.e(13731, new Object[] { Integer.valueOf(12) });
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI
 * JD-Core Version:    0.7.0.1
 */