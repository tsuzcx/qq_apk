package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;

abstract class fs$a
  implements Runnable
{
  private fs$a(fs paramfs) {}
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!fs.a(this.a).postAtFrontOfQueue(this)) {
        fs.a(this.a).post(this);
      }
      return;
    }
    fs.a(this.a).post(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.fs.a
 * JD-Core Version:    0.7.0.1
 */