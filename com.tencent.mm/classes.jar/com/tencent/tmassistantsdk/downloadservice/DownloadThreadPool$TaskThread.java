package com.tencent.tmassistantsdk.downloadservice;

class DownloadThreadPool$TaskThread
  extends Thread
{
  private int mIndex = 0;
  
  public DownloadThreadPool$TaskThread(DownloadThreadPool paramDownloadThreadPool, int paramInt)
  {
    this.mIndex = paramInt;
    setName("download_thread_" + this.mIndex);
    start();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 47
    //   2: new 22	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 49
    //   8: invokespecial 27	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 20	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:mIndex	I
    //   15: invokevirtual 31	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   18: ldc 51
    //   20: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 60	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 15	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:this$0	Lcom/tencent/tmassistantsdk/downloadservice/DownloadThreadPool;
    //   33: getfield 64	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool:mThreadlock	Ljava/lang/Object;
    //   36: astore_1
    //   37: aload_1
    //   38: monitorenter
    //   39: ldc 47
    //   41: new 22	java/lang/StringBuilder
    //   44: dup
    //   45: ldc 49
    //   47: invokespecial 27	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 20	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:mIndex	I
    //   54: invokevirtual 31	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: ldc 66
    //   59: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 60	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload_0
    //   69: getfield 15	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:this$0	Lcom/tencent/tmassistantsdk/downloadservice/DownloadThreadPool;
    //   72: getfield 64	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool:mThreadlock	Ljava/lang/Object;
    //   75: invokevirtual 71	java/lang/Object:wait	()V
    //   78: aload_1
    //   79: monitorexit
    //   80: invokestatic 75	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   83: invokevirtual 79	java/lang/Thread:isInterrupted	()Z
    //   86: ifeq +171 -> 257
    //   89: ldc 47
    //   91: new 22	java/lang/StringBuilder
    //   94: dup
    //   95: ldc 49
    //   97: invokespecial 27	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: aload_0
    //   101: getfield 20	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:mIndex	I
    //   104: invokevirtual 31	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: ldc 81
    //   109: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 60	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: return
    //   119: astore_2
    //   120: ldc 47
    //   122: new 22	java/lang/StringBuilder
    //   125: dup
    //   126: ldc 49
    //   128: invokespecial 27	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   131: aload_0
    //   132: getfield 20	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:mIndex	I
    //   135: invokevirtual 31	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   138: ldc 81
    //   140: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 60	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: ldc 47
    //   151: aload_2
    //   152: ldc 83
    //   154: iconst_0
    //   155: anewarray 68	java/lang/Object
    //   158: invokestatic 89	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: aload_1
    //   162: monitorexit
    //   163: return
    //   164: astore_2
    //   165: aload_1
    //   166: monitorexit
    //   167: aload_2
    //   168: athrow
    //   169: aload_1
    //   170: ifnull +59 -> 229
    //   173: ldc 47
    //   175: new 22	java/lang/StringBuilder
    //   178: dup
    //   179: ldc 91
    //   181: invokespecial 27	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   184: aload_0
    //   185: invokevirtual 94	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:getName	()Ljava/lang/String;
    //   188: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc 96
    //   193: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_1
    //   197: invokevirtual 101	com/tencent/tmassistantsdk/downloadservice/DownloadTask:getDownloadURI	()Ljava/lang/String;
    //   200: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 60	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: invokestatic 107	com/tencent/tmassistantsdk/downloadservice/DownloadHelper:getWakeLock	()Landroid/os/PowerManager$WakeLock;
    //   212: astore_2
    //   213: aload_1
    //   214: aload_0
    //   215: invokevirtual 94	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:getName	()Ljava/lang/String;
    //   218: invokevirtual 110	com/tencent/tmassistantsdk/downloadservice/DownloadTask:exec	(Ljava/lang/String;)V
    //   221: aload_2
    //   222: ifnull +7 -> 229
    //   225: aload_2
    //   226: invokevirtual 115	android/os/PowerManager$WakeLock:release	()V
    //   229: aload_0
    //   230: getfield 15	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:this$0	Lcom/tencent/tmassistantsdk/downloadservice/DownloadThreadPool;
    //   233: getfield 118	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool:mTaskLock	Ljava/lang/Object;
    //   236: astore_2
    //   237: aload_2
    //   238: monitorenter
    //   239: aload_1
    //   240: ifnull +15 -> 255
    //   243: aload_0
    //   244: getfield 15	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:this$0	Lcom/tencent/tmassistantsdk/downloadservice/DownloadThreadPool;
    //   247: getfield 122	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool:mExecList	Ljava/util/ArrayList;
    //   250: aload_1
    //   251: invokevirtual 128	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   254: pop
    //   255: aload_2
    //   256: monitorexit
    //   257: aload_0
    //   258: getfield 15	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:this$0	Lcom/tencent/tmassistantsdk/downloadservice/DownloadThreadPool;
    //   261: invokevirtual 131	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool:hasWaitingTask	()Z
    //   264: ifeq -235 -> 29
    //   267: aconst_null
    //   268: astore_1
    //   269: aload_0
    //   270: getfield 15	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:this$0	Lcom/tencent/tmassistantsdk/downloadservice/DownloadThreadPool;
    //   273: getfield 118	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool:mTaskLock	Ljava/lang/Object;
    //   276: astore_2
    //   277: aload_2
    //   278: monitorenter
    //   279: aload_0
    //   280: getfield 15	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:this$0	Lcom/tencent/tmassistantsdk/downloadservice/DownloadThreadPool;
    //   283: getfield 135	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool:mWaitingList	Ljava/util/PriorityQueue;
    //   286: invokevirtual 141	java/util/PriorityQueue:size	()I
    //   289: ifle +29 -> 318
    //   292: aload_0
    //   293: getfield 15	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:this$0	Lcom/tencent/tmassistantsdk/downloadservice/DownloadThreadPool;
    //   296: getfield 135	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool:mWaitingList	Ljava/util/PriorityQueue;
    //   299: invokevirtual 144	java/util/PriorityQueue:remove	()Ljava/lang/Object;
    //   302: checkcast 98	com/tencent/tmassistantsdk/downloadservice/DownloadTask
    //   305: astore_1
    //   306: aload_0
    //   307: getfield 15	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:this$0	Lcom/tencent/tmassistantsdk/downloadservice/DownloadThreadPool;
    //   310: getfield 122	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool:mExecList	Ljava/util/ArrayList;
    //   313: aload_1
    //   314: invokevirtual 147	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   317: pop
    //   318: aload_2
    //   319: monitorexit
    //   320: invokestatic 75	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   323: invokevirtual 79	java/lang/Thread:isInterrupted	()Z
    //   326: ifeq -157 -> 169
    //   329: ldc 47
    //   331: new 22	java/lang/StringBuilder
    //   334: dup
    //   335: ldc 49
    //   337: invokespecial 27	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   340: aload_0
    //   341: getfield 20	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:mIndex	I
    //   344: invokevirtual 31	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   347: ldc 81
    //   349: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokestatic 60	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   358: return
    //   359: astore_1
    //   360: aload_2
    //   361: monitorexit
    //   362: aload_1
    //   363: athrow
    //   364: astore_1
    //   365: aload_2
    //   366: monitorexit
    //   367: aload_1
    //   368: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	TaskThread
    //   36	278	1	localObject1	java.lang.Object
    //   359	4	1	localObject2	java.lang.Object
    //   364	4	1	localObject3	java.lang.Object
    //   119	33	2	localInterruptedException	java.lang.InterruptedException
    //   164	4	2	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   39	78	119	java/lang/InterruptedException
    //   39	78	164	finally
    //   78	80	164	finally
    //   120	163	164	finally
    //   165	167	164	finally
    //   279	318	359	finally
    //   318	320	359	finally
    //   360	362	359	finally
    //   243	255	364	finally
    //   255	257	364	finally
    //   365	367	364	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.DownloadThreadPool.TaskThread
 * JD-Core Version:    0.7.0.1
 */