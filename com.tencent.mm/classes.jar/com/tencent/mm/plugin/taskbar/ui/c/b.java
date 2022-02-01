package com.tencent.mm.plugin.taskbar.ui.c;

import android.app.Activity;
import android.os.Build.VERSION;
import android.util.Pair;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.aw;

public final class b
{
  public static Pair<Integer, Integer> by(Activity paramActivity)
  {
    AppMethodBeat.i(264196);
    Pair localPair = new Pair(Integer.valueOf(0), Integer.valueOf(0));
    if ((paramActivity == null) || (!MMHandlerThread.isMainThread()))
    {
      AppMethodBeat.o(264196);
      return localPair;
    }
    try
    {
      int i = paramActivity.getWindowManager().getDefaultDisplay().getRotation();
      if ((i == 0) || (i == 2))
      {
        AppMethodBeat.o(264196);
        return localPair;
      }
      if (Build.VERSION.SDK_INT >= 28)
      {
        WindowInsets localWindowInsets = paramActivity.getWindow().getDecorView().getRootWindowInsets();
        if ((localWindowInsets != null) && (localWindowInsets.getDisplayCutout() != null))
        {
          paramActivity = localWindowInsets.getDisplayCutout();
          Log.i("MicroMsg.TaskBarUIUtils", "getLeftRightSafeInsets from insets %d %d", new Object[] { Integer.valueOf(paramActivity.getSafeInsetLeft()), Integer.valueOf(paramActivity.getSafeInsetRight()) });
          paramActivity = new Pair(Integer.valueOf(paramActivity.getSafeInsetLeft()), Integer.valueOf(paramActivity.getSafeInsetRight()));
          AppMethodBeat.o(264196);
          return paramActivity;
        }
      }
      int j = aw.bw(paramActivity);
      Log.i("MicroMsg.TaskBarUIUtils", "getLeftRightSafeInsets from statusbar %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if (i == 1)
      {
        paramActivity = new Pair(Integer.valueOf(j), Integer.valueOf(0));
        AppMethodBeat.o(264196);
        return paramActivity;
      }
      paramActivity = new Pair(Integer.valueOf(0), Integer.valueOf(j));
      AppMethodBeat.o(264196);
      return paramActivity;
    }
    catch (Exception paramActivity)
    {
      Log.e("MicroMsg.TaskBarUIUtils", "getSafeInsetsFailed", new Object[] { paramActivity });
      AppMethodBeat.o(264196);
    }
    return localPair;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.c.b
 * JD-Core Version:    0.7.0.1
 */