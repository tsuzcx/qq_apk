package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;

final class us$a
  implements Runnable
{
  private boolean a = true;
  private int b = 60000;
  
  public us$a(us paramus, int paramInt) {}
  
  public final void a(boolean paramBoolean)
  {
    this.a = false;
  }
  
  public final void run()
  {
    us.a(this.c).a(false, false);
    if (this.a) {
      us.b(this.c).postDelayed(this, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.us.a
 * JD-Core Version:    0.7.0.1
 */