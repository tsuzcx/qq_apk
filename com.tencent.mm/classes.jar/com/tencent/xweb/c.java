package com.tencent.xweb;

import android.content.Context;
import com.tencent.xweb.c.b.b;

public final class c
{
  private static c xgr;
  static b.b xgs;
  
  private c(Context paramContext)
  {
    if (xgs != null) {
      xgs.init(paramContext);
    }
  }
  
  public static c cSg()
  {
    try
    {
      if (xgr == null) {
        throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
      }
    }
    finally {}
    c localc = xgr;
    return localc;
  }
  
  public static c il(Context paramContext)
  {
    try
    {
      if (xgr == null) {
        xgr = new c(paramContext.getApplicationContext());
      }
      paramContext = xgr;
      return paramContext;
    }
    finally {}
  }
  
  public static void sync()
  {
    if (xgs != null) {
      xgs.sync();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.c
 * JD-Core Version:    0.7.0.1
 */