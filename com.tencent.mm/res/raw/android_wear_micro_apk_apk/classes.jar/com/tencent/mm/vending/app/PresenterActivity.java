package com.tencent.mm.vending.app;

import android.app.Activity;
import android.os.Bundle;

public abstract class PresenterActivity
  extends Activity
{
  private d act = new d();
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.act.b(getIntent(), this);
  }
  
  protected void onDestroy()
  {
    this.act.onDestroy();
    super.onDestroy();
  }
  
  protected void onPause()
  {
    this.act.onPause();
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.act.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.app.PresenterActivity
 * JD-Core Version:    0.7.0.1
 */