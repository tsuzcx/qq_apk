package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(1)
public class TopStorySubTaskHomeUI
  extends MMActivity
{
  private b TJB;
  
  public TopStorySubTaskHomeUI()
  {
    AppMethodBeat.i(126020);
    this.TJB = new b(this, false);
    AppMethodBeat.o(126020);
  }
  
  public int getLayoutId()
  {
    AppMethodBeat.i(271735);
    int i = b.getLayoutId();
    AppMethodBeat.o(271735);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(126021);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.TopStory.TopStoryHomeUI", "use TopStoryHomeUI");
    this.TJB.onCreate(paramBundle);
    AppMethodBeat.o(126021);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126025);
    this.TJB.onDestroy();
    super.onDestroy();
    AppMethodBeat.o(126025);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(126022);
    boolean bool = this.TJB.aoP(paramInt);
    AppMethodBeat.o(126022);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(126026);
    this.TJB.onNewIntent(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(126026);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(126024);
    this.TJB.onPause();
    super.onPause();
    AppMethodBeat.o(126024);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(126023);
    super.onResume();
    this.TJB.onResume();
    AppMethodBeat.o(126023);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(126027);
    super.onSaveInstanceState(paramBundle);
    this.TJB.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(126027);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStorySubTaskHomeUI
 * JD-Core Version:    0.7.0.1
 */