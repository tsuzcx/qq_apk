package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ae;

public final class x
{
  public static void b(boolean paramBoolean, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (paramBoolean) {}
    for (paramIntent = "com.tencent.mm.ui.ACTION_ACTIVE";; paramIntent = "com.tencent.mm.ui.ACTION_DEACTIVE")
    {
      localIntent.setAction(paramIntent);
      localIntent.putExtra("_application_context_process_", ae.getProcessName());
      localIntent.putExtra("process_id", Process.myPid());
      localIntent.putExtra("process_is_mm", ae.cqV());
      ae.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.x
 * JD-Core Version:    0.7.0.1
 */