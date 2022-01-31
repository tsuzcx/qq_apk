package com.tencent.mm.pluginsdk.i;

import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public final class c
{
  private SensorManager rYo;
  private c.a rYp;
  
  public c(Context paramContext)
  {
    this.rYo = ((SensorManager)paramContext.getSystemService("sensor"));
  }
  
  private boolean clX()
  {
    if (this.rYo == null) {
      y.e("MicroMsg.ShakeSensorService", "cannot init sensor manager");
    }
    List localList;
    do
    {
      return false;
      localList = this.rYo.getSensorList(1);
    } while ((localList == null) || (localList.size() <= 0));
    return true;
  }
  
  public final void a(c.a parama)
  {
    aFJ();
    if (clX())
    {
      this.rYp = parama;
      this.rYo.registerListener(this.rYp, this.rYo.getDefaultSensor(1), 1);
      return;
    }
    y.e("MicroMsg.ShakeSensorService", "no sensor found for shake detection");
  }
  
  public final void aFJ()
  {
    if (this.rYp != null)
    {
      this.rYp.onRelease();
      this.rYo.unregisterListener(this.rYp, this.rYo.getDefaultSensor(1));
      this.rYp = null;
    }
  }
  
  public final boolean clU()
  {
    return this.rYp != null;
  }
  
  public final void clV()
  {
    if (this.rYp != null) {
      c.a.reset();
    }
  }
  
  public final boolean clW()
  {
    return clX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.c
 * JD-Core Version:    0.7.0.1
 */