package com.tencent.mm.plugin.teenmode.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.egx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class SettingsTeenModeMainMiniProgram
  extends MMActivity
{
  private WeImageView FWJ;
  private WeImageView FWK;
  private WeImageView FWL;
  private LinearLayout FWM;
  private int FWN = 0;
  
  private void fvu()
  {
    AppMethodBeat.i(187447);
    Log.d("MicroMsg.SettingsTeenModeMainMiniProgram", "doSaveConfig: %s", new Object[] { Integer.valueOf(this.FWN) });
    g.aAh().azQ().set(ar.a.OaY, Integer.valueOf(this.FWN));
    AppMethodBeat.o(187447);
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(187446);
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
      AppMethodBeat.o(187446);
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
    return 2131496274;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(187443);
    super.onCreate(paramBundle);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101424));
    this.FWJ = ((WeImageView)findViewById(2131308933));
    this.FWK = ((WeImageView)findViewById(2131308935));
    this.FWL = ((WeImageView)findViewById(2131308934));
    this.FWM = ((LinearLayout)findViewById(2131300136));
    this.FWN = ((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvp();
    updateStatus();
    ((View)this.FWJ.getParent()).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187438);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainMiniProgram$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        SettingsTeenModeMainMiniProgram.a(SettingsTeenModeMainMiniProgram.this, 1);
        SettingsTeenModeMainMiniProgram.a(SettingsTeenModeMainMiniProgram.this);
        a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainMiniProgram$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187438);
      }
    });
    ((View)this.FWK.getParent()).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187439);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainMiniProgram$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        SettingsTeenModeMainMiniProgram.a(SettingsTeenModeMainMiniProgram.this, 0);
        SettingsTeenModeMainMiniProgram.a(SettingsTeenModeMainMiniProgram.this);
        a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainMiniProgram$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187439);
      }
    });
    ((View)this.FWL.getParent()).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187440);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainMiniProgram$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        SettingsTeenModeMainMiniProgram.a(SettingsTeenModeMainMiniProgram.this, 2);
        SettingsTeenModeMainMiniProgram.a(SettingsTeenModeMainMiniProgram.this);
        a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainMiniProgram$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187440);
      }
    });
    this.FWM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187441);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainMiniProgram$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ((t)g.af(t.class)).dF(SettingsTeenModeMainMiniProgram.this.getContext());
        a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainMiniProgram$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187441);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(187442);
        SettingsTeenModeMainMiniProgram.this.onBackPressed();
        AppMethodBeat.o(187442);
        return true;
      }
    });
    AppMethodBeat.o(187443);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(187445);
    Log.d("MicroMsg.SettingsTeenModeMainMiniProgram", "doOPLog: %s", new Object[] { Integer.valueOf(this.FWN) });
    egx localegx = new egx();
    localegx.NgJ = this.FWN;
    ((l)g.af(l.class)).eis().b(new k.a(225, localegx));
    ((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvq();
    super.onDestroy();
    AppMethodBeat.o(187445);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(187444);
    super.onPause();
    AppMethodBeat.o(187444);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainMiniProgram
 * JD-Core Version:    0.7.0.1
 */