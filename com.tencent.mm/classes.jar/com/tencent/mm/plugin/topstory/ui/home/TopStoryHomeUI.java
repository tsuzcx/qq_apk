package com.tencent.mm.plugin.topstory.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.WebView.c;

@com.tencent.mm.ui.widget.pulldown.c(0)
public class TopStoryHomeUI
  extends MMActivity
{
  private b MWZ;
  
  public TopStoryHomeUI()
  {
    AppMethodBeat.i(125906);
    this.MWZ = new b(this, true);
    AppMethodBeat.o(125906);
  }
  
  public void finish()
  {
    AppMethodBeat.i(125915);
    int i = 100;
    if (!getController().hideVKB()) {
      i = 0;
    }
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125905);
        Log.i("MicroMsg.TopStory.TopStoryHomeUI", " finish");
        TopStoryHomeUI.a(TopStoryHomeUI.this);
        AppMethodBeat.o(125905);
      }
    }, i);
    AppMethodBeat.o(125915);
  }
  
  public int getLayoutId()
  {
    return c.e.top_story_home_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(125917);
    this.MWZ.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(125917);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(125914);
    b localb = this.MWZ;
    if (localb.MXl) {
      localb.gql();
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
    Log.i("MicroMsg.TopStory.TopStoryHomeUI", "use TopStoryHomeUI");
    if (!BuildInfo.IS_ARM64)
    {
      WebView.c localc = WebView.c.aabm;
      com.tencent.mm.xwebutil.c.a(localc, new WebView.PreInitCallback()
      {
        public final void bEj()
        {
          AppMethodBeat.i(202976);
          Log.i("MicroMsg.TopStory.TopStoryHomeUI", "onCoreInitFailed");
          AppMethodBeat.o(202976);
        }
        
        public final void onCoreInitFinished()
        {
          AppMethodBeat.i(202973);
          Log.i("MicroMsg.TopStory.TopStoryHomeUI", "onCoreInitFinished");
          AppMethodBeat.o(202973);
        }
      });
      Log.i("MicroMsg.TopStory.TopStoryHomeUI", "Start To Load WebView %s", new Object[] { localc.name() });
    }
    this.MWZ.onCreate(paramBundle);
    AppMethodBeat.o(125907);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125911);
    this.MWZ.onDestroy();
    super.onDestroy();
    AppMethodBeat.o(125911);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125908);
    if (this.MWZ.ajx(paramInt))
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
    this.MWZ.onNewIntent(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(125912);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(125910);
    this.MWZ.onPause();
    super.onPause();
    AppMethodBeat.o(125910);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125909);
    super.onResume();
    this.MWZ.onResume();
    AppMethodBeat.o(125909);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(125913);
    super.onSaveInstanceState(paramBundle);
    this.MWZ.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(125913);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStoryHomeUI
 * JD-Core Version:    0.7.0.1
 */