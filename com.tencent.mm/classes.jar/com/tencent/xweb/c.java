package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.b.b;

public final class c
{
  private static c BCW;
  static b.b BCX;
  
  private c(Context paramContext)
  {
    AppMethodBeat.i(3803);
    if (BCX != null) {
      BCX.init(paramContext);
    }
    AppMethodBeat.o(3803);
  }
  
  public static c dYi()
  {
    try
    {
      AppMethodBeat.i(3802);
      if (BCW == null)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
        AppMethodBeat.o(3802);
        throw localIllegalStateException;
      }
    }
    finally {}
    c localc = BCW;
    AppMethodBeat.o(3802);
    return localc;
  }
  
  public static c jQ(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(3801);
      if (BCW == null) {
        BCW = new c(paramContext.getApplicationContext());
      }
      paramContext = BCW;
      AppMethodBeat.o(3801);
      return paramContext;
    }
    finally {}
  }
  
  public static void sync()
  {
    AppMethodBeat.i(3804);
    if (BCX != null) {
      BCX.sync();
    }
    AppMethodBeat.o(3804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.c
 * JD-Core Version:    0.7.0.1
 */