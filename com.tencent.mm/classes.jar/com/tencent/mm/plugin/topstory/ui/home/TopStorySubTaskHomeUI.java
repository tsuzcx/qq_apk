package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.plugin.topstory.ui.b.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(1)
public class TopStorySubTaskHomeUI
  extends MMActivity
{
  private b pDQ = new b(this, false);
  
  protected final int getLayoutId()
  {
    return b.e.top_story_home_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
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
    return this.pDQ.zv(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStorySubTaskHomeUI
 * JD-Core Version:    0.7.0.1
 */