package com.tencent.mm.vending.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.vending.e.b;

public abstract class PresenterActivity
  extends HellActivity
  implements b
{
  private c kfE = new c();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.kfE.z(getIntent(), this);
  }
  
  public void onDestroy()
  {
    this.kfE.onDestroy();
    super.onDestroy();
  }
  
  public void onPause()
  {
    this.kfE.ayZ(3);
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.kfE.ayZ(2);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.vending.app.PresenterActivity
 * JD-Core Version:    0.7.0.1
 */