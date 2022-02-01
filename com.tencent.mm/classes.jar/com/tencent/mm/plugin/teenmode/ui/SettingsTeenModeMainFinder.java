package com.tencent.mm.plugin.teenmode.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.egz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class SettingsTeenModeMainFinder
  extends MMActivity
{
  private WeImageView FWJ;
  private WeImageView FWK;
  private WeImageView FWL;
  private LinearLayout FWM;
  private int FWN = 0;
  
  private void fvu()
  {
    AppMethodBeat.i(187436);
    Log.d("MicroMsg.SettingsTeenModeMainFinder", "doSaveConfig: %s", new Object[] { Integer.valueOf(this.FWN) });
    g.aAh().azQ().set(ar.a.OaW, Integer.valueOf(this.FWN));
    AppMethodBeat.o(187436);
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(187435);
    this.FWJ.setVisibility(8);
    this.FWK.setVisibility(8);
    this.FWL.setVisibility(8);
    this.FWM.setVisibility(4);
    switch (this.FWN)
    {
    }
    for (;;)
    {
      fvu();
      AppMethodBeat.o(187435);
      return;
      this.FWJ.setVisibility(0);
      continue;
      this.FWK.setVisibility(0);
      this.FWM.setVisibility(0);
      continue;
      this.FWL.setVisibility(0);
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496273;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(187434);
    super.onBackPressed();
    AppMethodBeat.o(187434);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(187431);
    super.onCreate(paramBundle);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101424));
    this.FWJ = ((WeImageView)findViewById(2131308933));
    this.FWK = ((WeImageView)findViewById(2131308935));
    this.FWL = ((WeImageView)findViewById(2131308934));
    this.FWM = ((LinearLayout)findViewById(2131300136));
    this.FWN = ((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).dxW();
    updateStatus();
    ((View)this.FWJ.getParent()).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187426);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainFinder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        SettingsTeenModeMainFinder.a(SettingsTeenModeMainFinder.this, 1);
        SettingsTeenModeMainFinder.a(SettingsTeenModeMainFinder.this);
        a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainFinder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187426);
      }
    });
    ((View)this.FWK.getParent()).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187427);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainFinder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        SettingsTeenModeMainFinder.a(SettingsTeenModeMainFinder.this, 0);
        SettingsTeenModeMainFinder.a(SettingsTeenModeMainFinder.this);
        a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainFinder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187427);
      }
    });
    ((View)this.FWL.getParent()).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187428);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainFinder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        SettingsTeenModeMainFinder.a(SettingsTeenModeMainFinder.this, 2);
        SettingsTeenModeMainFinder.a(SettingsTeenModeMainFinder.this);
        a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainFinder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187428);
      }
    });
    this.FWM.setOnClickListener(new SettingsTeenModeMainFinder.4(this));
    setBackBtn(new SettingsTeenModeMainFinder.5(this));
    AppMethodBeat.o(187431);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(187433);
    Log.d("MicroMsg.SettingsTeenModeMainFinder", "doLog: %s", new Object[] { Integer.valueOf(this.FWN) });
    egz localegz = new egz();
    localegz.NgJ = this.FWN;
    ((l)g.af(l.class)).eis().b(new k.a(223, localegz));
    ((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvq();
    super.onDestroy();
    AppMethodBeat.o(187433);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(187432);
    super.onPause();
    AppMethodBeat.o(187432);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainFinder
 * JD-Core Version:    0.7.0.1
 */