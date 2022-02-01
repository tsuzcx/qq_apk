package com.tencent.mm.plugin.topstory.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class TopStoryHomeUI
  extends MMActivity
{
  private b BJG;
  
  public TopStoryHomeUI()
  {
    AppMethodBeat.i(125906);
    this.BJG = new b(this, true);
    AppMethodBeat.o(125906);
  }
  
  public void finish()
  {
    AppMethodBeat.i(125915);
    int i = 100;
    if (!getController().hideVKB()) {
      i = 0;
    }
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125905);
        ae.i("MicroMsg.TopStory.TopStoryHomeUI", " finish");
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
    this.BJG.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(125917);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(125914);
    b localb = this.BJG;
    if (localb.BJT) {
      localb.esR();
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
    ae.i("MicroMsg.TopStory.TopStoryHomeUI", "use TopStoryHomeUI");
    this.BJG.onCreate(paramBundle);
    AppMethodBeat.o(125907);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125911);
    this.BJG.onDestroy();
    super.onDestroy();
    AppMethodBeat.o(125911);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125908);
    if (this.BJG.TC(paramInt))
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
    this.BJG.onNewIntent(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(125912);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(125910);
    this.BJG.onPause();
    super.onPause();
    AppMethodBeat.o(125910);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125909);
    super.onResume();
    this.BJG.onResume();
    AppMethodBeat.o(125909);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(125913);
    super.onSaveInstanceState(paramBundle);
    this.BJG.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(125913);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStoryHomeUI
 * JD-Core Version:    0.7.0.1
 */