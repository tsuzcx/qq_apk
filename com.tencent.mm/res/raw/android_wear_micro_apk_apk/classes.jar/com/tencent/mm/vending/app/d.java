package com.tencent.mm.vending.app;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.vending.e.b;
import junit.framework.Assert;

public final class d
{
  private c YM = c.lv();
  private a YQ;
  private int YR = 0;
  private b YS = new b();
  
  private void a(Intent paramIntent, Context paramContext)
  {
    try
    {
      Assert.assertNotNull("You must pair this presenter with a interactor!", this.YQ);
      this.YQ.setContext(paramContext);
      this.YQ.a(paramIntent);
      return;
    }
    finally
    {
      paramIntent = finally;
      throw paramIntent;
    }
  }
  
  private void bG(int paramInt)
  {
    this.YR = paramInt;
    this.YM.a(this, paramInt);
  }
  
  public final void b(Intent paramIntent, Context paramContext)
  {
    a(paramIntent, paramContext);
    bG(1);
  }
  
  public final void onDestroy()
  {
    this.YS.lw();
    bG(4);
  }
  
  public final void onPause()
  {
    bG(3);
  }
  
  public final void onResume()
  {
    bG(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.app.d
 * JD-Core Version:    0.7.0.1
 */