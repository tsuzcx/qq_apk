package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Handler;

abstract class bg$a
  implements Runnable
{
  private bg$a(bg parambg) {}
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!bg.a(this.a).postAtFrontOfQueue(this)) {
        bg.a(this.a).post(this);
      }
      return;
    }
    bg.a(this.a).post(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.bg.a
 * JD-Core Version:    0.7.0.1
 */