package com.tencent.mm.sandbox.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ad;

public class CrashUploadAlarmReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ad.i("MicroMsg.CrashUploadAlarmReceiver", "dkcrash AlarmReceiver.onReceive");
    if ((a.fiq() == 0) || (a.fir() == 0)) {
      b.it(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.CrashUploadAlarmReceiver
 * JD-Core Version:    0.7.0.1
 */