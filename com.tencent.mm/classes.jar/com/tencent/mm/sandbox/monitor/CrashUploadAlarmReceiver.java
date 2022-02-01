package com.tencent.mm.sandbox.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ae;

public class CrashUploadAlarmReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ae.i("MicroMsg.CrashUploadAlarmReceiver", "dkcrash AlarmReceiver.onReceive");
    if ((a.fmi() == 0) || (a.fmj() == 0)) {
      b.iy(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.CrashUploadAlarmReceiver
 * JD-Core Version:    0.7.0.1
 */