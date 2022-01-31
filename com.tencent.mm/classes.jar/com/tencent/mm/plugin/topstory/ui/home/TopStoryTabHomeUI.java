package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.plugin.topstory.ui.b.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public class TopStoryTabHomeUI
  extends MMActivity
{
  private c pEc = new c(this);
  
  protected final int getLayoutId()
  {
    return b.e.top_story_home_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.TopStory.TopStoryHomeUI", "use TopStoryHomeUI");
    this.pEc.onCreate(paramBundle);
  }
  
  protected void onDestroy()
  {
    this.pEc.onDestroy();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.pEc.zv(paramInt)) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    this.pEc.onNewIntent(paramIntent);
    super.onNewIntent(paramIntent);
  }
  
  protected void onPause()
  {
    this.pEc.onPause();
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.pEc.onResume();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.pEc.onSaveInstanceState(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStoryTabHomeUI
 * JD-Core Version:    0.7.0.1
 */