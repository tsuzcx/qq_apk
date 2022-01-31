package com.tencent.mm.vending.app;

import android.app.Activity;
import android.os.Bundle;

public abstract class PresenterActivity
  extends Activity
{
  private d YT = new d();
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.YT.b(getIntent(), this);
  }
  
  protected void onDestroy()
  {
    this.YT.onDestroy();
    super.onDestroy();
  }
  
  protected void onPause()
  {
    this.YT.onPause();
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.YT.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.app.PresenterActivity
 * JD-Core Version:    0.7.0.1
 */