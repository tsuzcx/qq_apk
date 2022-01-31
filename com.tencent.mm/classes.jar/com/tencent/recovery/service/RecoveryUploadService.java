package com.tencent.recovery.service;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.recovery.log.RecoveryFileLog;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.OptionFactory;
import com.tencent.recovery.util.Util;

public class RecoveryUploadService
  extends IntentService
{
  private static final String TAG = "Recovery.RecoveryUploadService";
  
  public RecoveryUploadService()
  {
    super(RecoveryUploadService.class.getName());
  }
  
  public static void cancelAlarm(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, paramString);
    localIntent.putExtra("KeyReportUploadClassName", paramString);
    paramContext = PendingIntent.getService(paramContext, 1000001, localIntent, 536870912);
    if (paramContext != null) {
      paramContext.cancel();
    }
  }
  
  /* Error */
  public static void startAlarm(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic 56	com/tencent/recovery/util/Util:bl	(Ljava/lang/String;)Z
    //   7: istore_2
    //   8: iload_2
    //   9: ifeq +7 -> 16
    //   12: ldc 2
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: invokestatic 62	com/tencent/recovery/option/OptionFactory:hq	(Landroid/content/Context;)Lcom/tencent/recovery/option/CommonOptions;
    //   20: astore 7
    //   22: aload_0
    //   23: ldc 64
    //   25: iconst_0
    //   26: invokevirtual 70	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   29: astore 8
    //   31: aload 8
    //   33: ldc 72
    //   35: lconst_0
    //   36: invokeinterface 78 4 0
    //   41: lstore_3
    //   42: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   45: lstore 5
    //   47: ldc 8
    //   49: ldc 86
    //   51: iconst_2
    //   52: anewarray 88	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload_1
    //   58: aastore
    //   59: dup
    //   60: iconst_1
    //   61: lload_3
    //   62: invokestatic 92	com/tencent/recovery/util/Util:ik	(J)Ljava/lang/String;
    //   65: aastore
    //   66: invokestatic 98	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: new 24	android/content/Intent
    //   72: dup
    //   73: invokespecial 26	android/content/Intent:<init>	()V
    //   76: astore 9
    //   78: aload 9
    //   80: aload_0
    //   81: aload_1
    //   82: invokevirtual 30	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    //   85: pop
    //   86: aload 9
    //   88: ldc 32
    //   90: aload_1
    //   91: invokevirtual 36	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   94: pop
    //   95: aload_0
    //   96: ldc 37
    //   98: aload 9
    //   100: ldc 38
    //   102: invokestatic 44	android/app/PendingIntent:getService	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   105: astore_1
    //   106: aload_1
    //   107: ifnull +16 -> 123
    //   110: lload 5
    //   112: lload_3
    //   113: lsub
    //   114: aload 7
    //   116: getfield 104	com/tencent/recovery/option/CommonOptions:wLb	J
    //   119: lcmp
    //   120: ifle +122 -> 242
    //   123: aload_1
    //   124: ifnull +18 -> 142
    //   127: aload_1
    //   128: invokevirtual 47	android/app/PendingIntent:cancel	()V
    //   131: ldc 8
    //   133: ldc 106
    //   135: iconst_0
    //   136: anewarray 88	java/lang/Object
    //   139: invokestatic 98	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aload 8
    //   144: invokeinterface 110 1 0
    //   149: ldc 72
    //   151: lload 5
    //   153: invokeinterface 116 4 0
    //   158: invokeinterface 120 1 0
    //   163: pop
    //   164: aload_0
    //   165: ldc 37
    //   167: aload 9
    //   169: ldc 121
    //   171: invokestatic 44	android/app/PendingIntent:getService	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   174: astore_1
    //   175: aload 7
    //   177: getfield 104	com/tencent/recovery/option/CommonOptions:wLb	J
    //   180: lload 5
    //   182: ladd
    //   183: ldc2_w 122
    //   186: lsub
    //   187: lstore_3
    //   188: aload_0
    //   189: ldc 125
    //   191: invokevirtual 129	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   194: checkcast 131	android/app/AlarmManager
    //   197: astore_0
    //   198: aload_0
    //   199: iconst_0
    //   200: lload_3
    //   201: aload_1
    //   202: invokevirtual 135	android/app/AlarmManager:set	(IJLandroid/app/PendingIntent;)V
    //   205: ldc 8
    //   207: ldc 137
    //   209: iconst_2
    //   210: anewarray 88	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: aload_1
    //   216: invokevirtual 141	android/app/PendingIntent:hashCode	()I
    //   219: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   222: aastore
    //   223: dup
    //   224: iconst_1
    //   225: lload_3
    //   226: invokestatic 92	com/tencent/recovery/util/Util:ik	(J)Ljava/lang/String;
    //   229: aastore
    //   230: invokestatic 98	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   233: goto -221 -> 12
    //   236: astore_0
    //   237: ldc 2
    //   239: monitorexit
    //   240: aload_0
    //   241: athrow
    //   242: ldc 8
    //   244: ldc 149
    //   246: iconst_0
    //   247: anewarray 88	java/lang/Object
    //   250: invokestatic 98	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   253: goto -241 -> 12
    //   256: astore_0
    //   257: ldc 8
    //   259: aload_0
    //   260: ldc 151
    //   262: iconst_0
    //   263: anewarray 88	java/lang/Object
    //   266: invokestatic 155	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   269: goto -64 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	paramContext	Context
    //   0	272	1	paramString	String
    //   7	2	2	bool	boolean
    //   41	185	3	l1	long
    //   45	136	5	l2	long
    //   20	156	7	localCommonOptions	CommonOptions
    //   29	114	8	localSharedPreferences	android.content.SharedPreferences
    //   76	92	9	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   3	8	236	finally
    //   16	106	236	finally
    //   110	123	236	finally
    //   127	142	236	finally
    //   142	198	236	finally
    //   198	205	236	finally
    //   205	233	236	finally
    //   242	253	236	finally
    //   257	269	236	finally
    //   198	205	256	java/lang/Exception
  }
  
  public static void startAlarmAfter(Context paramContext, String paramString, long paramLong)
  {
    if (Util.bl(paramString)) {
      return;
    }
    RecoveryLog.i("Recovery.RecoveryUploadService", "startAlarmAfter %s %d", new Object[] { paramString, Long.valueOf(paramLong) });
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, paramString);
    localIntent.putExtra("KeyReportUploadClassName", paramString);
    paramString = PendingIntent.getService(paramContext, 1000001, localIntent, 536870912);
    if (paramString != null) {
      paramString.cancel();
    }
    paramLong = System.currentTimeMillis() + paramLong - 2000L;
    paramString = PendingIntent.getService(paramContext, 1000001, localIntent, 134217728);
    paramContext = (AlarmManager)paramContext.getSystemService("alarm");
    try
    {
      paramContext.set(0, paramLong, paramString);
      RecoveryLog.i("Recovery.RecoveryUploadService", "startAlarmAfter pendingIntent:%d %s", new Object[] { Integer.valueOf(paramString.hashCode()), Util.ik(paramLong) });
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        RecoveryLog.printErrStackTrace("Recovery.RecoveryUploadService", paramContext, "alarmManager.setAlarm", new Object[0]);
      }
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    RecoveryLog.i("Recovery.RecoveryUploadService", "RecoveryUploadReceiver.onHandleIntent", new Object[0]);
    boolean bool = tryToUploadData();
    String str = paramIntent.getStringExtra("KeyReportUploadClassName");
    paramIntent = str;
    if (Util.bl(str)) {
      paramIntent = getClass().getName();
    }
    cancelAlarm(this, paramIntent);
    if (!bool) {
      startAlarmAfter(this, paramIntent, OptionFactory.hq(this).wLb);
    }
    RecoveryLog.i("Recovery.RecoveryUploadService", "RecoveryUploadReceiver.uploadDataResult %b", new Object[] { Boolean.valueOf(bool) });
    if ((RecoveryLog.cOB() instanceof RecoveryFileLog))
    {
      RecoveryLog.i("Recovery.RecoveryUploadService", "send broadcast action", new Object[0]);
      RecoveryLog.cOA();
      paramIntent = new Intent();
      paramIntent.setPackage(getPackageName());
      paramIntent.setAction("com.tecent.recovery.intent.action.LOG");
      sendBroadcast(paramIntent);
    }
    stopSelf();
  }
  
  public boolean tryToUploadData()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.service.RecoveryUploadService
 * JD-Core Version:    0.7.0.1
 */