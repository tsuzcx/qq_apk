package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.plugin.topstory.ui.b.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public class TopStoryHomeUI
  extends MMActivity
{
  private b pDQ = new b(this, true);
  
  protected final int getLayoutId()
  {
    return b.e.top_story_home_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.uMp = true;
    super.onCreate(paramBundle);
    y.i("MicroMsg.TopStory.TopStoryHomeUI", "use TopStoryHomeUI");
    this.pDQ.onCreate(paramBundle);
  }
  
  protected void onDestroy()
  {
    this.pDQ.onDestroy();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.pDQ.zv(paramInt)) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    this.pDQ.onNewIntent(paramIntent);
    super.onNewIntent(paramIntent);
  }
  
  protected void onPause()
  {
    this.pDQ.onPause();
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.pDQ.onResume();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.pDQ.onSaveInstanceState(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStoryHomeUI
 * JD-Core Version:    0.7.0.1
 */