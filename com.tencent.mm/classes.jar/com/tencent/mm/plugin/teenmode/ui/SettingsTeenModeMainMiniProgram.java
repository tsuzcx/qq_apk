package com.tencent.mm.plugin.teenmode.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.teenmode.a.a;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.plugin.teenmode.a.e;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.plugin.teenmode.b.j;
import com.tencent.mm.protocal.protobuf.fmf;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class SettingsTeenModeMainMiniProgram
  extends MMActivity
{
  private WeImageView TaP;
  private WeImageView TaQ;
  private WeImageView TaR;
  private LinearLayout TaS;
  private int TaT = 0;
  
  private void hFa()
  {
    AppMethodBeat.i(279206);
    Log.d("MicroMsg.SettingsTeenModeMainMiniProgram", "doSaveConfig: %s", new Object[] { Integer.valueOf(this.TaT) });
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acQw, Integer.valueOf(this.TaT));
    AppMethodBeat.o(279206);
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(279201);
    TextView localTextView1 = (TextView)findViewById(a.d.SWc);
    TextView localTextView2 = (TextView)findViewById(a.d.SWg);
    TextView localTextView3 = (TextView)findViewById(a.d.SWe);
    localTextView1.setContentDescription(getString(a.g.SXP));
    localTextView2.setContentDescription(getString(a.g.SXw));
    localTextView3.setContentDescription(getString(a.g.SXx));
    this.TaP.setVisibility(8);
    this.TaQ.setVisibility(8);
    this.TaR.setVisibility(8);
    this.TaS.setVisibility(4);
    switch (this.TaT)
    {
    }
    for (;;)
    {
      hFa();
      AppMethodBeat.o(279201);
      return;
      this.TaP.setVisibility(0);
      localTextView1.setContentDescription(getString(a.g.SXz) + getString(a.g.SXP));
      continue;
      this.TaQ.setVisibility(0);
      this.TaS.setVisibility(0);
      localTextView2.setContentDescription(getString(a.g.SXz) + getString(a.g.SXw));
      continue;
      this.TaR.setVisibility(0);
      localTextView3.setContentDescription(getString(a.g.SXz) + getString(a.g.SXx));
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.e.SWr;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(279244);
    super.onCreate(paramBundle);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.a.white));
    this.TaP = ((WeImageView)findViewById(a.d.SWb));
    this.TaQ = ((WeImageView)findViewById(a.d.SWf));
    this.TaR = ((WeImageView)findViewById(a.d.SWd));
    this.TaS = ((LinearLayout)findViewById(a.d.SVB));
    this.TaT = ((d)com.tencent.mm.kernel.h.ax(d.class)).hEr();
    updateStatus();
    ((View)this.TaP.getParent()).setOnClickListener(new SettingsTeenModeMainMiniProgram.1(this));
    ((View)this.TaQ.getParent()).setOnClickListener(new SettingsTeenModeMainMiniProgram.2(this));
    ((View)this.TaR.getParent()).setOnClickListener(new SettingsTeenModeMainMiniProgram.3(this));
    this.TaS.setOnClickListener(new SettingsTeenModeMainMiniProgram.4(this));
    setBackBtn(new SettingsTeenModeMainMiniProgram.5(this));
    AppMethodBeat.o(279244);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(279261);
    Log.d("MicroMsg.SettingsTeenModeMainMiniProgram", "doOPLog: %s", new Object[] { Integer.valueOf(this.TaT) });
    fmf localfmf = new fmf();
    localfmf.abMB = this.TaT;
    if (j.hEy().hFb != null)
    {
      localfmf.aajK = new gol();
      localfmf.aajK.df(j.hEy().hFb.getBytes());
    }
    localfmf.aajL = j.hEy().qfP;
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaT().b(new k.a(225, localfmf));
    ((d)com.tencent.mm.kernel.h.ax(d.class)).hEs();
    super.onDestroy();
    AppMethodBeat.o(279261);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(279250);
    super.onPause();
    AppMethodBeat.o(279250);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainMiniProgram
 * JD-Core Version:    0.7.0.1
 */