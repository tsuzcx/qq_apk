package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ServiceHelper
{
  public static void startService(Intent paramIntent)
  {
    AppMethodBeat.i(243845);
    if (Build.VERSION.SDK_INT >= 26)
    {
      MMApplicationContext.getContext().startForegroundService(paramIntent);
      AppMethodBeat.o(243845);
      return;
    }
    MMApplicationContext.getContext().startService(paramIntent);
    AppMethodBeat.o(243845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ServiceHelper
 * JD-Core Version:    0.7.0.1
 */