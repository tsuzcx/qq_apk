package com.tencent.mm.vending.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.e.b;

public abstract class PresenterActivity
  extends Activity
  implements b
{
  private c ANT = new c();
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.ANT.A(getIntent(), this);
  }
  
  protected void onDestroy()
  {
    this.ANT.onDestroy();
    super.onDestroy();
  }
  
  protected void onPause()
  {
    this.ANT.a(3);
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.ANT.a(2);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.vending.app.PresenterActivity
 * JD-Core Version:    0.7.0.1
 */