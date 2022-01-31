package com.tencent.mm.vending.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.vending.e.b;

public abstract class PresenterActivity
  extends Activity
  implements b
{
  private c wsY = new c();
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.wsY.B(getIntent(), this);
  }
  
  protected void onDestroy()
  {
    this.wsY.onDestroy();
    super.onDestroy();
  }
  
  protected void onPause()
  {
    this.wsY.a(3);
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.wsY.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.vending.app.PresenterActivity
 * JD-Core Version:    0.7.0.1
 */