package com.tencent.mm.plugin.teenmode.ui;

import android.app.Activity;
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
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.protocal.protobuf.eqz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class SettingsTeenModeMainMiniProgram
  extends MMActivity
{
  private WeImageView MtY;
  private WeImageView MtZ;
  private WeImageView Mua;
  private LinearLayout Mub;
  private int Muc = 0;
  
  private void gkx()
  {
    AppMethodBeat.i(259514);
    Log.d("MicroMsg.SettingsTeenModeMainMiniProgram", "doSaveConfig: %s", new Object[] { Integer.valueOf(this.Muc) });
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vpa, Integer.valueOf(this.Muc));
    AppMethodBeat.o(259514);
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(259513);
    TextView localTextView1 = (TextView)findViewById(a.d.Msw);
    TextView localTextView2 = (TextView)findViewById(a.d.MsA);
    TextView localTextView3 = (TextView)findViewById(a.d.Msy);
    localTextView1.setContentDescription(getString(a.g.Mtr));
    localTextView2.setContentDescription(getString(a.g.Mta));
    localTextView3.setContentDescription(getString(a.g.Mtb));
    this.MtY.setVisibility(8);
    this.MtZ.setVisibility(8);
    this.Mua.setVisibility(8);
    this.Mub.setVisibility(4);
    switch (this.Muc)
    {
    }
    for (;;)
    {
      gkx();
      AppMethodBeat.o(259513);
      return;
      this.MtY.setVisibility(0);
      localTextView1.setContentDescription(getString(a.g.Mtd) + getString(a.g.Mtr));
      continue;
      this.MtZ.setVisibility(0);
      this.Mub.setVisibility(0);
      localTextView2.setContentDescription(getString(a.g.Mtd) + getString(a.g.Mta));
      continue;
      this.Mua.setVisibility(0);
      localTextView3.setContentDescription(getString(a.g.Mtd) + getString(a.g.Mtb));
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.e.MsH;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(259509);
    super.onCreate(paramBundle);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.a.white));
    this.MtY = ((WeImageView)findViewById(a.d.Msv));
    this.MtZ = ((WeImageView)findViewById(a.d.Msz));
    this.Mua = ((WeImageView)findViewById(a.d.Msx));
    this.Mub = ((LinearLayout)findViewById(a.d.Msc));
    this.Muc = ((b)com.tencent.mm.kernel.h.ae(b.class)).gks();
    updateStatus();
    ((View)this.MtY.getParent()).setOnClickListener(new SettingsTeenModeMainMiniProgram.1(this));
    ((View)this.MtZ.getParent()).setOnClickListener(new SettingsTeenModeMainMiniProgram.2(this));
    ((View)this.Mua.getParent()).setOnClickListener(new SettingsTeenModeMainMiniProgram.3(this));
    this.Mub.setOnClickListener(new SettingsTeenModeMainMiniProgram.4(this));
    setBackBtn(new SettingsTeenModeMainMiniProgram.5(this));
    AppMethodBeat.o(259509);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(259511);
    Log.d("MicroMsg.SettingsTeenModeMainMiniProgram", "doOPLog: %s", new Object[] { Integer.valueOf(this.Muc) });
    eqz localeqz = new eqz();
    localeqz.Utn = this.Muc;
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eRY().b(new k.a(225, localeqz));
    ((b)com.tencent.mm.kernel.h.ae(b.class)).gkt();
    super.onDestroy();
    AppMethodBeat.o(259511);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(259510);
    super.onPause();
    AppMethodBeat.o(259510);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainMiniProgram
 * JD-Core Version:    0.7.0.1
 */