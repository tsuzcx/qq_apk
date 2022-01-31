package com.tencent.recovery.service;

import android.app.IntentService;
import android.content.Intent;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryStatusItem;
import com.tencent.recovery.report.RecoveryReporter;
import com.tencent.recovery.util.Util;

public class RecoveryReportService
  extends IntentService
{
  public RecoveryReportService()
  {
    super(RecoveryReportService.class.getName());
  }
  
  private void aY(Intent paramIntent)
  {
    int i = 0;
    for (;;)
    {
      String str2;
      try
      {
        String str1 = paramIntent.getStringExtra("KeyReportType");
        boolean bool = Util.isNullOrNil(str1);
        if (bool) {
          return;
        }
      }
      catch (Exception localException)
      {
        str2 = null;
        continue;
        String str3 = paramIntent.getStringExtra("KeyReportUploadClassName");
        RecoveryLog.i("Recovery.RecoveryReportService", "handle report intent %s %s", new Object[] { str2, str3 });
        switch (str2.hashCode())
        {
        case -1125171110: 
          RecoveryUploadService.startAlarm(this, str3);
          stopSelf();
          continue;
        }
      }
      finally {}
      if (str2.equals("HandleStatus"))
      {
        break label175;
        if (str2.equals("ProcessStatus"))
        {
          i = 1;
          break label175;
          RecoveryReporter.c(this, str2, paramIntent.getParcelableArrayListExtra("KeyReportItem"));
          continue;
          RecoveryReporter.a(this, str2, (RecoveryStatusItem)paramIntent.getParcelableExtra("KeyReportItem"));
          continue;
        }
      }
      i = -1;
      label175:
      switch (i)
      {
      }
    }
  }
  
  public void onDestroy()
  {
    RecoveryLog.dUp();
    super.onDestroy();
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    aY(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.service.RecoveryReportService
 * JD-Core Version:    0.7.0.1
 */