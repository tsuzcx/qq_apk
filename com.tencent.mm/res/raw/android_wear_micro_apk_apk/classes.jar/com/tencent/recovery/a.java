package com.tencent.recovery;

import android.content.Context;
import android.content.Intent;
import com.tencent.recovery.a.d;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.service.RecoveryReportService;
import java.lang.reflect.Field;
import java.util.ArrayList;

public final class a
{
  public static Field ajm = null;
  public static int ajn = 17;
  
  public static void a(Context paramContext, ArrayList<RecoveryHandleItem> paramArrayList, String paramString)
  {
    d.c("Recovery.RecoveryLogic", "startReportService %s", new Object[] { "HandleStatus" });
    Intent localIntent = new Intent(paramContext, RecoveryReportService.class);
    localIntent.putExtra("KeyReportType", "HandleStatus");
    localIntent.putExtra("KeyReportUploadClassName", paramString);
    localIntent.putParcelableArrayListExtra("KeyReportItem", paramArrayList);
    paramContext.startService(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.recovery.a
 * JD-Core Version:    0.7.0.1
 */