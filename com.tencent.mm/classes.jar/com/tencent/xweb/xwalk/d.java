package com.tencent.xweb.xwalk;

import android.content.Context;
import com.tencent.xweb.c.b.b;
import org.xwalk.core.XWalkCookieManager;

public final class d
  implements b.b
{
  XWalkCookieManager xlO = new XWalkCookieManager();
  
  public final void init(Context paramContext) {}
  
  public final void sync()
  {
    if (this.xlO != null) {
      this.xlO.flushCookieStore();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d
 * JD-Core Version:    0.7.0.1
 */