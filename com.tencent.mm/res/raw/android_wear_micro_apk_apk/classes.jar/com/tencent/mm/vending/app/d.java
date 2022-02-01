package com.tencent.mm.vending.app;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.vending.e.b;
import junit.framework.Assert;

public final class d
{
  private c acm = c.mc();
  private a acq;
  private int acr = 0;
  private b acs = new b();
  
  private void a(Intent paramIntent, Context paramContext)
  {
    try
    {
      Assert.assertNotNull("You must pair this presenter with a interactor!", this.acq);
      this.acq.setContext(paramContext);
      this.acq.c(paramIntent);
      return;
    }
    finally
    {
      paramIntent = finally;
      throw paramIntent;
    }
  }
  
  private void cc(int paramInt)
  {
    this.acr = paramInt;
    this.acm.a(this, paramInt);
  }
  
  public final void b(Intent paramIntent, Context paramContext)
  {
    a(paramIntent, paramContext);
    cc(1);
  }
  
  public final void onDestroy()
  {
    this.acs.md();
    cc(4);
  }
  
  public final void onPause()
  {
    cc(3);
  }
  
  public final void onResume()
  {
    cc(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.app.d
 * JD-Core Version:    0.7.0.1
 */