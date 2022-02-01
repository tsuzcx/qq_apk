package com.tencent.mm.plugin.topstory.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public class TopStoryTabHomeUI
  extends MMActivity
{
  private c Btp;
  
  public TopStoryTabHomeUI()
  {
    AppMethodBeat.i(126028);
    this.Btp = new c(this);
    AppMethodBeat.o(126028);
  }
  
  public int getLayoutId()
  {
    return 2131495786;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(126029);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.TopStory.TopStoryHomeUI", "use TopStoryHomeUI");
    this.Btp.onCreate(paramBundle);
    AppMethodBeat.o(126029);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126033);
    this.Btp.onDestroy();
    super.onDestroy();
    AppMethodBeat.o(126033);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(126030);
    if (this.Btp.SV(paramInt))
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
    this.Btp.onNewIntent(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(126034);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(126032);
    this.Btp.onPause();
    super.onPause();
    AppMethodBeat.o(126032);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(126031);
    super.onResume();
    this.Btp.onResume();
    AppMethodBeat.o(126031);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(126035);
    super.onSaveInstanceState(paramBundle);
    this.Btp.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(126035);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStoryTabHomeUI
 * JD-Core Version:    0.7.0.1
 */