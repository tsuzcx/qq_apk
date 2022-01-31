package com.tencent.mm.plugin.topstory.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public class TopStoryTabHomeUI
  extends MMActivity
{
  private c thi;
  
  public TopStoryTabHomeUI()
  {
    AppMethodBeat.i(1671);
    this.thi = new c(this);
    AppMethodBeat.o(1671);
  }
  
  public int getLayoutId()
  {
    return 2130971022;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(1672);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.TopStory.TopStoryHomeUI", "use TopStoryHomeUI");
    this.thi.onCreate(paramBundle);
    AppMethodBeat.o(1672);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(1676);
    this.thi.onDestroy();
    super.onDestroy();
    AppMethodBeat.o(1676);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(1673);
    if (this.thi.Gx(paramInt))
    {
      AppMethodBeat.o(1673);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(1673);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(1677);
    this.thi.onNewIntent(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(1677);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(1675);
    this.thi.onPause();
    super.onPause();
    AppMethodBeat.o(1675);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(1674);
    super.onResume();
    this.thi.onResume();
    AppMethodBeat.o(1674);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(1678);
    super.onSaveInstanceState(paramBundle);
    this.thi.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(1678);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStoryTabHomeUI
 * JD-Core Version:    0.7.0.1
 */