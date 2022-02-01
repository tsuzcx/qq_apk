package com.tencent.mm.plugin.topstory.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(1)
public class TopStorySubTaskHomeUI
  extends MMActivity
{
  private b Aav;
  
  public TopStorySubTaskHomeUI()
  {
    AppMethodBeat.i(126020);
    this.Aav = new b(this, false);
    AppMethodBeat.o(126020);
  }
  
  public int getLayoutId()
  {
    return 2131495786;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(126021);
    super.onCreate(paramBundle);
    ac.i("MicroMsg.TopStory.TopStoryHomeUI", "use TopStoryHomeUI");
    this.Aav.onCreate(paramBundle);
    AppMethodBeat.o(126021);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126025);
    this.Aav.onDestroy();
    super.onDestroy();
    AppMethodBeat.o(126025);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(126022);
    boolean bool = this.Aav.Rl(paramInt);
    AppMethodBeat.o(126022);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(126026);
    this.Aav.onNewIntent(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(126026);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(126024);
    this.Aav.onPause();
    super.onPause();
    AppMethodBeat.o(126024);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(126023);
    super.onResume();
    this.Aav.onResume();
    AppMethodBeat.o(126023);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(126027);
    super.onSaveInstanceState(paramBundle);
    this.Aav.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(126027);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStorySubTaskHomeUI
 * JD-Core Version:    0.7.0.1
 */