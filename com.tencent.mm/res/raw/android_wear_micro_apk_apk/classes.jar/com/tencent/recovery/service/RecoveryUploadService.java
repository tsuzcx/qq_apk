package com.tencent.recovery.service;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import com.tencent.recovery.a.c;
import com.tencent.recovery.a.d;
import com.tencent.recovery.e.a;

public class RecoveryUploadService
  extends IntentService
{
  public RecoveryUploadService()
  {
    super(RecoveryUploadService.class.getName());
  }
  
  /* Error */
  public static void j(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic 26	com/tencent/recovery/e/a:D	(Ljava/lang/String;)Z
    //   7: istore_2
    //   8: iload_2
    //   9: ifeq +7 -> 16
    //   12: ldc 2
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: invokestatic 32	com/tencent/recovery/b/d:B	(Landroid/content/Context;)Lcom/tencent/recovery/b/a;
    //   20: astore 7
    //   22: aload_0
    //   23: ldc 34
    //   25: iconst_0
    //   26: invokevirtual 40	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   29: astore 8
    //   31: aload 8
    //   33: ldc 42
    //   35: lconst_0
    //   36: invokeinterface 48 4 0
    //   41: lstore_3
    //   42: invokestatic 54	java/lang/System:currentTimeMillis	()J
    //   45: lstore 5
    //   47: ldc 56
    //   49: ldc 58
    //   51: iconst_2
    //   52: anewarray 60	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload_1
    //   58: aastore
    //   59: dup
    //   60: iconst_1
    //   61: lload_3
    //   62: invokestatic 64	com/tencent/recovery/e/a:n	(J)Ljava/lang/String;
    //   65: aastore
    //   66: invokestatic 70	com/tencent/recovery/a/d:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: new 72	android/content/Intent
    //   72: dup
    //   73: invokespecial 74	android/content/Intent:<init>	()V
    //   76: astore 9
    //   78: aload 9
    //   80: aload_0
    //   81: aload_1
    //   82: invokevirtual 78	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    //   85: pop
    //   86: aload 9
    //   88: ldc 80
    //   90: aload_1
    //   91: invokevirtual 84	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   94: pop
    //   95: aload_0
    //   96: ldc 85
    //   98: aload 9
    //   100: ldc 86
    //   102: invokestatic 92	android/app/PendingIntent:getService	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   105: astore_1
    //   106: aload_1
    //   107: ifnull +16 -> 123
    //   110: lload 5
    //   112: lload_3
    //   113: lsub
    //   114: aload 7
    //   116: invokevirtual 97	com/tencent/recovery/b/a:oE	()J
    //   119: lcmp
    //   120: ifle +122 -> 242
    //   123: aload_1
    //   124: ifnull +18 -> 142
    //   127: aload_1
    //   128: invokevirtual 100	android/app/PendingIntent:cancel	()V
    //   131: ldc 56
    //   133: ldc 102
    //   135: iconst_0
    //   136: anewarray 60	java/lang/Object
    //   139: invokestatic 70	com/tencent/recovery/a/d:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aload 8
    //   144: invokeinterface 106 1 0
    //   149: ldc 42
    //   151: lload 5
    //   153: invokeinterface 112 4 0
    //   158: invokeinterface 116 1 0
    //   163: pop
    //   164: aload_0
    //   165: ldc 85
    //   167: aload 9
    //   169: ldc 117
    //   171: invokestatic 92	android/app/PendingIntent:getService	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   174: astore_1
    //   175: aload 7
    //   177: invokevirtual 97	com/tencent/recovery/b/a:oE	()J
    //   180: lload 5
    //   182: ladd
    //   183: ldc2_w 118
    //   186: lsub
    //   187: lstore_3
    //   188: aload_0
    //   189: ldc 121
    //   191: invokevirtual 125	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   194: checkcast 127	android/app/AlarmManager
    //   197: astore_0
    //   198: aload_0
    //   199: iconst_0
    //   200: lload_3
    //   201: aload_1
    //   202: invokevirtual 131	android/app/AlarmManager:set	(IJLandroid/app/PendingIntent;)V
    //   205: ldc 56
    //   207: ldc 133
    //   209: iconst_2
    //   210: anewarray 60	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: aload_1
    //   216: invokevirtual 137	android/app/PendingIntent:hashCode	()I
    //   219: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   222: aastore
    //   223: dup
    //   224: iconst_1
    //   225: lload_3
    //   226: invokestatic 64	com/tencent/recovery/e/a:n	(J)Ljava/lang/String;
    //   229: aastore
    //   230: invokestatic 70	com/tencent/recovery/a/d:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   233: goto -221 -> 12
    //   236: astore_0
    //   237: ldc 2
    //   239: monitorexit
    //   240: aload_0
    //   241: athrow
    //   242: ldc 56
    //   244: ldc 145
    //   246: iconst_0
    //   247: anewarray 60	java/lang/Object
    //   250: invokestatic 70	com/tencent/recovery/a/d:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   253: goto -241 -> 12
    //   256: astore_0
    //   257: ldc 56
    //   259: aload_0
    //   260: ldc 147
    //   262: iconst_0
    //   263: anewarray 60	java/lang/Object
    //   266: invokestatic 151	com/tencent/recovery/a/d:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   269: goto -64 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	paramContext	android.content.Context
    //   0	272	1	paramString	String
    //   7	2	2	bool	boolean
    //   41	185	3	l1	long
    //   45	136	5	l2	long
    //   20	156	7	locala	com.tencent.recovery.b.a
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
  
  protected void onHandleIntent(Intent paramIntent)
  {
    d.c("Recovery.RecoveryUploadService", "RecoveryUploadReceiver.onHandleIntent", new Object[0]);
    Object localObject = paramIntent.getStringExtra("KeyReportUploadClassName");
    paramIntent = (Intent)localObject;
    if (a.D((String)localObject)) {
      paramIntent = getClass().getName();
    }
    localObject = new Intent();
    ((Intent)localObject).setClassName(this, paramIntent);
    ((Intent)localObject).putExtra("KeyReportUploadClassName", paramIntent);
    paramIntent = PendingIntent.getService(this, 1000001, (Intent)localObject, 536870912);
    if (paramIntent != null) {
      paramIntent.cancel();
    }
    d.c("Recovery.RecoveryUploadService", "RecoveryUploadReceiver.uploadDataResult %b", new Object[] { Boolean.TRUE });
    if ((d.oB() instanceof c))
    {
      d.c("Recovery.RecoveryUploadService", "send broadcast action", new Object[0]);
      d.oy();
      paramIntent = new Intent();
      paramIntent.setPackage(getPackageName());
      paramIntent.setAction("com.tecent.recovery.intent.action.LOG");
      sendBroadcast(paramIntent);
    }
    stopSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.recovery.service.RecoveryUploadService
 * JD-Core Version:    0.7.0.1
 */