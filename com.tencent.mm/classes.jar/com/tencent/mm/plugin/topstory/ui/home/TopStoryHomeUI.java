package com.tencent.mm.plugin.topstory.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class TopStoryHomeUI
  extends MMActivity
{
  private b Aav;
  
  public TopStoryHomeUI()
  {
    AppMethodBeat.i(125906);
    this.Aav = new b(this, true);
    AppMethodBeat.o(125906);
  }
  
  public void finish()
  {
    AppMethodBeat.i(125915);
    int i = 100;
    if (!getController().hideVKB()) {
      i = 0;
    }
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125905);
        ac.i("MicroMsg.TopStory.TopStoryHomeUI", " finish");
        TopStoryHomeUI.a(TopStoryHomeUI.this);
        AppMethodBeat.o(125905);
      }
    }, i);
    AppMethodBeat.o(125915);
  }
  
  public int getLayoutId()
  {
    return 2131495786;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(125917);
    this.Aav.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(125917);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(125914);
    b localb = this.Aav;
    if (localb.AaI) {
      localb.ecT();
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        super.onBackPressed();
      }
      AppMethodBeat.o(125914);
      return;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(125916);
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(125916);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125907);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    ac.i("MicroMsg.TopStory.TopStoryHomeUI", "use TopStoryHomeUI");
    this.Aav.onCreate(paramBundle);
    AppMethodBeat.o(125907);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125911);
    this.Aav.onDestroy();
    super.onDestroy();
    AppMethodBeat.o(125911);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125908);
    if (this.Aav.Rl(paramInt))
    {
      AppMethodBeat.o(125908);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(125908);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(125912);
    this.Aav.onNewIntent(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(125912);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(125910);
    this.Aav.onPause();
    super.onPause();
    AppMethodBeat.o(125910);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125909);
    super.onResume();
    this.Aav.onResume();
    AppMethodBeat.o(125909);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(125913);
    super.onSaveInstanceState(paramBundle);
    this.Aav.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(125913);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStoryHomeUI
 * JD-Core Version:    0.7.0.1
 */