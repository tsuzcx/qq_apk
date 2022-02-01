package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.sdk.platformtools.Log;

public class TopStoryTabHomeUI
  extends MMSecDataActivity
{
  private c TKO;
  
  public TopStoryTabHomeUI()
  {
    AppMethodBeat.i(126028);
    this.TKO = new c(this);
    AppMethodBeat.o(126028);
  }
  
  public int getLayoutId()
  {
    AppMethodBeat.i(271781);
    int i = c.getLayoutId();
    AppMethodBeat.o(271781);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(126029);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.TopStory.TopStoryHomeUI", "use TopStoryHomeUI");
    this.TKO.onCreate(paramBundle);
    AppMethodBeat.o(126029);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126033);
    this.TKO.onDestroy();
    super.onDestroy();
    AppMethodBeat.o(126033);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(126030);
    if (this.TKO.aoP(paramInt))
    {
      AppMethodBeat.o(126030);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(126030);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(126034);
    this.TKO.onNewIntent(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(126034);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(126032);
    this.TKO.onPause();
    super.onPause();
    AppMethodBeat.o(126032);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(126031);
    super.onResume();
    this.TKO.onResume();
    AppMethodBeat.o(126031);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(126035);
    super.onSaveInstanceState(paramBundle);
    this.TKO.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(126035);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStoryTabHomeUI
 * JD-Core Version:    0.7.0.1
 */