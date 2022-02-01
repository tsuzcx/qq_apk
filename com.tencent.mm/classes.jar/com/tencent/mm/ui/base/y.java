package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class y
{
  public static int JqY = -1;
  
  public static void activateBroadcast(boolean paramBoolean)
  {
    AppMethodBeat.i(142454);
    d(paramBoolean, null);
    AppMethodBeat.o(142454);
  }
  
  public static void d(boolean paramBoolean, Intent paramIntent)
  {
    AppMethodBeat.i(142455);
    if (!xD(paramBoolean))
    {
      ad.w("MicroMsg.UIStatusUtil", "isRealSend = false,just return!");
      AppMethodBeat.o(142455);
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (paramBoolean) {}
    for (paramIntent = "com.tencent.mm.ui.ACTION_ACTIVE";; paramIntent = "com.tencent.mm.ui.ACTION_DEACTIVE")
    {
      localIntent.setAction(paramIntent);
      localIntent.putExtra("_application_context_process_", aj.getProcessName());
      localIntent.putExtra("process_id", Process.myPid());
      localIntent.putExtra("process_is_mm", aj.cnC());
      aj.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      AppMethodBeat.o(142455);
      return;
    }
  }
  
  private static boolean xD(boolean paramBoolean)
  {
    boolean bool = true;
    int i;
    if (paramBoolean)
    {
      i = 1;
      if (JqY == i) {
        break label28;
      }
    }
    label28:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      JqY = i;
      return paramBoolean;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.y
 * JD-Core Version:    0.7.0.1
 */