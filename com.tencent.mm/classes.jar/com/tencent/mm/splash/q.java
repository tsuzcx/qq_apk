package com.tencent.mm.splash;

import android.app.PendingIntent;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

final class q
{
  static PendingIntent shouldBlock(Context paramContext)
  {
    AppMethodBeat.i(233912);
    try
    {
      Class localClass = Class.forName("com.tencent.mm.app.StartBlocker");
      paramContext = (PendingIntent)localClass.getMethod("shouldBlock", new Class[] { Context.class }).invoke(localClass, new Object[] { paramContext });
      AppMethodBeat.o(233912);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(233912);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.q
 * JD-Core Version:    0.7.0.1
 */