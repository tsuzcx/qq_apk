package com.tencent.mm.plugin.topstory.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(1)
public class TopStorySubTaskHomeUI
  extends MMActivity
{
  private b tfX;
  
  public TopStorySubTaskHomeUI()
  {
    AppMethodBeat.i(1663);
    this.tfX = new b(this, false);
    AppMethodBeat.o(1663);
  }
  
  public int getLayoutId()
  {
    return 2130971022;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(1664);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.TopStory.TopStoryHomeUI", "use TopStoryHomeUI");
    this.tfX.onCreate(paramBundle);
    AppMethodBeat.o(1664);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(1668);
    this.tfX.onDestroy();
    super.onDestroy();
    AppMethodBeat.o(1668);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(1665);
    boolean bool = this.tfX.Gx(paramInt);
    AppMethodBeat.o(1665);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(1669);
    this.tfX.onNewIntent(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(1669);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(1667);
    this.tfX.onPause();
    super.onPause();
    AppMethodBeat.o(1667);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(1666);
    super.onResume();
    this.tfX.onResume();
    AppMethodBeat.o(1666);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(1670);
    super.onSaveInstanceState(paramBundle);
    this.tfX.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(1670);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStorySubTaskHomeUI
 * JD-Core Version:    0.7.0.1
 */