package com.tencent.xweb.x5;

import android.content.Context;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.xweb.c.b.b;

public final class e
  implements b.b
{
  CookieSyncManager xkp;
  
  public final void init(Context paramContext)
  {
    this.xkp = CookieSyncManager.createInstance(paramContext);
  }
  
  public final void sync()
  {
    if (this.xkp != null) {
      this.xkp.sync();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.x5.e
 * JD-Core Version:    0.7.0.1
 */