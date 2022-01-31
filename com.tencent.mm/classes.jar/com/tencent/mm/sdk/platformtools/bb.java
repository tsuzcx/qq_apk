package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.hardware.SensorManager;
import java.util.List;

public final class bb
{
  private SensorManager rYo;
  private bb.a uir;
  
  public bb(Context paramContext)
  {
    this.rYo = ((SensorManager)paramContext.getSystemService("sensor"));
  }
  
  public final boolean W(Runnable paramRunnable)
  {
    if (this.rYo == null) {}
    List localList;
    do
    {
      return false;
      localList = this.rYo.getSensorList(1);
    } while ((localList == null) || (localList.size() <= 0));
    this.uir = new bb.a(paramRunnable);
    this.rYo.registerListener(this.uir, 2, 3);
    return true;
  }
  
  public final void crK()
  {
    if ((this.rYo != null) && (this.uir != null)) {
      this.rYo.unregisterListener(this.uir, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bb
 * JD-Core Version:    0.7.0.1
 */