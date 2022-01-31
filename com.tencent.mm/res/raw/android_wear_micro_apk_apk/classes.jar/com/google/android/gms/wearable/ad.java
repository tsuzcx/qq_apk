package com.google.android.gms.wearable;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class ad
  extends Handler
{
  private final ac SO = new ac((byte)0);
  private boolean started;
  
  ad(WearableListenerService paramWearableListenerService, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  /* Error */
  @android.annotation.SuppressLint({"UntrackedBindService"})
  private void kH()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/google/android/gms/wearable/ad:started	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: ldc 34
    //   16: iconst_2
    //   17: invokestatic 40	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   20: ifeq +49 -> 69
    //   23: aload_0
    //   24: getfield 14	com/google/android/gms/wearable/ad:SP	Lcom/google/android/gms/wearable/WearableListenerService;
    //   27: invokestatic 46	com/google/android/gms/wearable/WearableListenerService:a	(Lcom/google/android/gms/wearable/WearableListenerService;)Landroid/content/ComponentName;
    //   30: invokestatic 52	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   33: astore_2
    //   34: ldc 34
    //   36: new 54	java/lang/StringBuilder
    //   39: dup
    //   40: aload_2
    //   41: invokestatic 52	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   44: invokevirtual 58	java/lang/String:length	()I
    //   47: bipush 13
    //   49: iadd
    //   50: invokespecial 61	java/lang/StringBuilder:<init>	(I)V
    //   53: ldc 63
    //   55: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_2
    //   59: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 75	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   68: pop
    //   69: aload_0
    //   70: getfield 14	com/google/android/gms/wearable/ad:SP	Lcom/google/android/gms/wearable/WearableListenerService;
    //   73: aload_0
    //   74: getfield 14	com/google/android/gms/wearable/ad:SP	Lcom/google/android/gms/wearable/WearableListenerService;
    //   77: invokestatic 79	com/google/android/gms/wearable/WearableListenerService:b	(Lcom/google/android/gms/wearable/WearableListenerService;)Landroid/content/Intent;
    //   80: aload_0
    //   81: getfield 24	com/google/android/gms/wearable/ad:SO	Lcom/google/android/gms/wearable/ac;
    //   84: iconst_1
    //   85: invokevirtual 83	com/google/android/gms/wearable/WearableListenerService:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   88: pop
    //   89: aload_0
    //   90: iconst_1
    //   91: putfield 32	com/google/android/gms/wearable/ad:started	Z
    //   94: goto -83 -> 11
    //   97: astore_2
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_2
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	ad
    //   6	2	1	bool	boolean
    //   33	26	2	str	java.lang.String
    //   97	4	2	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	7	97	finally
    //   14	69	97	finally
    //   69	94	97	finally
  }
  
  /* Error */
  @android.annotation.SuppressLint({"UntrackedBindService"})
  private void x(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/google/android/gms/wearable/ad:started	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: ldc 34
    //   16: iconst_2
    //   17: invokestatic 40	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   20: ifeq +66 -> 86
    //   23: aload_0
    //   24: getfield 14	com/google/android/gms/wearable/ad:SP	Lcom/google/android/gms/wearable/WearableListenerService;
    //   27: invokestatic 46	com/google/android/gms/wearable/WearableListenerService:a	(Lcom/google/android/gms/wearable/WearableListenerService;)Landroid/content/ComponentName;
    //   30: invokestatic 52	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   33: astore_3
    //   34: ldc 34
    //   36: new 54	java/lang/StringBuilder
    //   39: dup
    //   40: aload_1
    //   41: invokestatic 52	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   44: invokevirtual 58	java/lang/String:length	()I
    //   47: bipush 17
    //   49: iadd
    //   50: aload_3
    //   51: invokestatic 52	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   54: invokevirtual 58	java/lang/String:length	()I
    //   57: iadd
    //   58: invokespecial 61	java/lang/StringBuilder:<init>	(I)V
    //   61: ldc 90
    //   63: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 92
    //   72: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_3
    //   76: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 75	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   85: pop
    //   86: aload_0
    //   87: getfield 14	com/google/android/gms/wearable/ad:SP	Lcom/google/android/gms/wearable/WearableListenerService;
    //   90: aload_0
    //   91: getfield 24	com/google/android/gms/wearable/ad:SO	Lcom/google/android/gms/wearable/ac;
    //   94: invokevirtual 96	com/google/android/gms/wearable/WearableListenerService:unbindService	(Landroid/content/ServiceConnection;)V
    //   97: aload_0
    //   98: iconst_0
    //   99: putfield 32	com/google/android/gms/wearable/ad:started	Z
    //   102: goto -91 -> 11
    //   105: astore_1
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: astore_1
    //   111: ldc 34
    //   113: ldc 98
    //   115: aload_1
    //   116: invokestatic 102	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   119: pop
    //   120: goto -23 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	ad
    //   0	123	1	paramString	java.lang.String
    //   6	2	2	bool	boolean
    //   33	43	3	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   2	7	105	finally
    //   14	86	105	finally
    //   86	97	105	finally
    //   97	102	105	finally
    //   111	120	105	finally
    //   86	97	110	java/lang/RuntimeException
  }
  
  public final void dispatchMessage(Message paramMessage)
  {
    kH();
    try
    {
      super.dispatchMessage(paramMessage);
      return;
    }
    finally
    {
      if (!hasMessages(0)) {
        x("dispatch");
      }
    }
  }
  
  final void quit()
  {
    getLooper().quit();
    x("quit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.ad
 * JD-Core Version:    0.7.0.1
 */