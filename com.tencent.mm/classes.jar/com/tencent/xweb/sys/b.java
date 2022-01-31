package com.tencent.xweb.sys;

import android.content.Context;
import android.webkit.CookieSyncManager;
import com.tencent.xweb.c.b.b;

public final class b
  implements b.b
{
  CookieSyncManager xjC;
  
  public final void init(Context paramContext)
  {
    this.xjC = CookieSyncManager.createInstance(paramContext);
  }
  
  public final void sync()
  {
    if (this.xjC != null) {
      this.xjC.sync();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.sys.b
 * JD-Core Version:    0.7.0.1
 */