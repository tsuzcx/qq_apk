package com.tencent.mm.sandbox.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ac;

public class CrashUploadAlarmReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ac.i("MicroMsg.CrashUploadAlarmReceiver", "dkcrash AlarmReceiver.onReceive");
    if ((a.eSO() == 0) || (a.eSP() == 0)) {
      b.ij(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.CrashUploadAlarmReceiver
 * JD-Core Version:    0.7.0.1
 */