package com.tencent.mm.pluginsdk.permission;

import android.app.Activity;

final class PermissionHelper$1
  implements Runnable
{
  PermissionHelper$1(Activity paramActivity, PermissionHelper.c[] paramArrayOfc) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 29
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 19	com/tencent/mm/pluginsdk/permission/PermissionHelper$1:val$activity	Landroid/app/Activity;
    //   9: instanceof 37
    //   12: ifeq +102 -> 114
    //   15: aload_0
    //   16: getfield 19	com/tencent/mm/pluginsdk/permission/PermissionHelper$1:val$activity	Landroid/app/Activity;
    //   19: checkcast 37	android/support/v4/app/FragmentActivity
    //   22: invokevirtual 41	android/support/v4/app/FragmentActivity:getSupportFragmentManager	()Landroid/support/v4/app/g;
    //   25: astore_3
    //   26: aload_3
    //   27: ldc 43
    //   29: invokevirtual 49	android/support/v4/app/g:findFragmentByTag	(Ljava/lang/String;)Landroid/support/v4/app/Fragment;
    //   32: checkcast 51	com/tencent/mm/pluginsdk/permission/PermissionHelper$AuxSupportFragment
    //   35: astore_2
    //   36: aload_2
    //   37: astore_1
    //   38: aload_2
    //   39: ifnonnull +30 -> 69
    //   42: new 51	com/tencent/mm/pluginsdk/permission/PermissionHelper$AuxSupportFragment
    //   45: dup
    //   46: invokespecial 52	com/tencent/mm/pluginsdk/permission/PermissionHelper$AuxSupportFragment:<init>	()V
    //   49: astore_1
    //   50: aload_3
    //   51: invokevirtual 56	android/support/v4/app/g:beginTransaction	()Landroid/support/v4/app/k;
    //   54: aload_1
    //   55: ldc 43
    //   57: invokevirtual 62	android/support/v4/app/k:a	(Landroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/k;
    //   60: invokevirtual 66	android/support/v4/app/k:commit	()I
    //   63: pop
    //   64: aload_3
    //   65: invokevirtual 70	android/support/v4/app/g:executePendingTransactions	()Z
    //   68: pop
    //   69: aload_0
    //   70: getfield 21	com/tencent/mm/pluginsdk/permission/PermissionHelper$1:BRr	[Lcom/tencent/mm/pluginsdk/permission/PermissionHelper$c;
    //   73: iconst_0
    //   74: aload_1
    //   75: aastore
    //   76: aload_0
    //   77: getfield 21	com/tencent/mm/pluginsdk/permission/PermissionHelper$1:BRr	[Lcom/tencent/mm/pluginsdk/permission/PermissionHelper$c;
    //   80: astore_1
    //   81: aload_1
    //   82: monitorenter
    //   83: aload_0
    //   84: getfield 21	com/tencent/mm/pluginsdk/permission/PermissionHelper$1:BRr	[Lcom/tencent/mm/pluginsdk/permission/PermissionHelper$c;
    //   87: invokevirtual 73	java/lang/Object:notifyAll	()V
    //   90: aload_1
    //   91: monitorexit
    //   92: ldc 29
    //   94: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: return
    //   98: astore_2
    //   99: ldc 78
    //   101: aload_2
    //   102: ldc 80
    //   104: iconst_0
    //   105: anewarray 4	java/lang/Object
    //   108: invokestatic 86	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: goto -42 -> 69
    //   114: aload_0
    //   115: getfield 19	com/tencent/mm/pluginsdk/permission/PermissionHelper$1:val$activity	Landroid/app/Activity;
    //   118: invokevirtual 92	android/app/Activity:getFragmentManager	()Landroid/app/FragmentManager;
    //   121: astore_3
    //   122: aload_3
    //   123: ldc 43
    //   125: invokevirtual 97	android/app/FragmentManager:findFragmentByTag	(Ljava/lang/String;)Landroid/app/Fragment;
    //   128: checkcast 99	com/tencent/mm/pluginsdk/permission/PermissionHelper$a
    //   131: astore_2
    //   132: aload_2
    //   133: astore_1
    //   134: aload_2
    //   135: ifnonnull +45 -> 180
    //   138: new 99	com/tencent/mm/pluginsdk/permission/PermissionHelper$a
    //   141: dup
    //   142: invokespecial 100	com/tencent/mm/pluginsdk/permission/PermissionHelper$a:<init>	()V
    //   145: astore_1
    //   146: aload_1
    //   147: new 102	java/lang/ref/WeakReference
    //   150: dup
    //   151: aload_0
    //   152: getfield 19	com/tencent/mm/pluginsdk/permission/PermissionHelper$1:val$activity	Landroid/app/Activity;
    //   155: invokespecial 105	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   158: putfield 109	com/tencent/mm/pluginsdk/permission/PermissionHelper$a:avO	Ljava/lang/ref/WeakReference;
    //   161: aload_3
    //   162: invokevirtual 112	android/app/FragmentManager:beginTransaction	()Landroid/app/FragmentTransaction;
    //   165: aload_1
    //   166: ldc 43
    //   168: invokevirtual 118	android/app/FragmentTransaction:add	(Landroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;
    //   171: invokevirtual 119	android/app/FragmentTransaction:commit	()I
    //   174: pop
    //   175: aload_3
    //   176: invokevirtual 120	android/app/FragmentManager:executePendingTransactions	()Z
    //   179: pop
    //   180: aload_0
    //   181: getfield 21	com/tencent/mm/pluginsdk/permission/PermissionHelper$1:BRr	[Lcom/tencent/mm/pluginsdk/permission/PermissionHelper$c;
    //   184: iconst_0
    //   185: aload_1
    //   186: aastore
    //   187: goto -111 -> 76
    //   190: astore_2
    //   191: ldc 78
    //   193: aload_2
    //   194: ldc 80
    //   196: iconst_0
    //   197: anewarray 4	java/lang/Object
    //   200: invokestatic 86	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   203: goto -23 -> 180
    //   206: astore_2
    //   207: aload_1
    //   208: monitorexit
    //   209: ldc 29
    //   211: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: aload_2
    //   215: athrow
    //   216: astore_2
    //   217: goto -127 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	1
    //   35	4	2	localAuxSupportFragment	PermissionHelper.AuxSupportFragment
    //   98	4	2	localThrowable1	java.lang.Throwable
    //   131	4	2	locala	PermissionHelper.a
    //   190	4	2	localThrowable2	java.lang.Throwable
    //   206	9	2	localObject2	Object
    //   216	1	2	localThrowable3	java.lang.Throwable
    //   25	151	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   50	69	98	java/lang/Throwable
    //   161	180	190	java/lang/Throwable
    //   83	90	206	finally
    //   90	92	206	finally
    //   207	209	206	finally
    //   83	90	216	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.PermissionHelper.1
 * JD-Core Version:    0.7.0.1
 */