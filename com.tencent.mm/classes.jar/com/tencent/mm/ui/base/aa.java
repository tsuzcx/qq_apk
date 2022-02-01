package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;

public final class aa
{
  public static int OWJ = -1;
  
  private static boolean BA(boolean paramBoolean)
  {
    boolean bool = true;
    int i;
    if (paramBoolean)
    {
      i = 1;
      if (OWJ == i) {
        break label28;
      }
    }
    label28:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      OWJ = i;
      return paramBoolean;
      i = 0;
      break;
    }
  }
  
  public static void activateBroadcast(boolean paramBoolean)
  {
    AppMethodBeat.i(142454);
    d(paramBoolean, null);
    AppMethodBeat.o(142454);
  }
  
  public static void d(boolean paramBoolean, Intent paramIntent)
  {
    AppMethodBeat.i(142455);
    if (!BA(paramBoolean))
    {
      Log.w("MicroMsg.UIStatusUtil", "isRealSend = false,just return!");
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
      localIntent.putExtra("_application_context_process_", MMApplicationContext.getProcessName());
      localIntent.putExtra("process_id", Process.myPid());
      localIntent.putExtra("process_is_mm", MMApplicationContext.isMMProcess());
      MMApplicationContext.getContext().sendBroadcast(localIntent, WeChatPermissions.PERMISSION_MM_MESSAGE());
      AppMethodBeat.o(142455);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.aa
 * JD-Core Version:    0.7.0.1
 */