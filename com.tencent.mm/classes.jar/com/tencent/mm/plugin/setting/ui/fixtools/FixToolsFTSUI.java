package com.tencent.mm.plugin.setting.ui.fixtools;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class FixToolsFTSUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return 2130969600;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(155886);
    super.onCreate(paramBundle);
    setMMTitle(2131299984);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(155883);
        FixToolsFTSUI.this.finish();
        AppMethodBeat.o(155883);
        return false;
      }
    });
    findViewById(2131824180).setOnClickListener(new FixToolsFTSUI.2(this));
    findViewById(2131824181).setOnClickListener(new FixToolsFTSUI.3(this));
    AppMethodBeat.o(155886);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixToolsFTSUI
 * JD-Core Version:    0.7.0.1
 */