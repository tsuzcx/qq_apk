package com.tencent.tmassistantsdk.downloadservice;

import com.tencent.matrix.trace.core.AppMethodBeat;

class DownloadThreadPool$TaskThread
  extends Thread
{
  private int mIndex;
  
  public DownloadThreadPool$TaskThread(DownloadThreadPool paramDownloadThreadPool, int paramInt)
  {
    AppMethodBeat.i(75760);
    this.mIndex = 0;
    this.mIndex = paramInt;
    setName("download_thread_" + this.mIndex);
    start();
    AppMethodBeat.o(75760);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 56
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 58
    //   7: new 29	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 60
    //   13: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: getfield 27	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:mIndex	I
    //   20: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   23: ldc 62
    //   25: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 70	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload_0
    //   35: getfield 15	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:this$0	Lcom/tencent/tmassistantsdk/downloadservice/DownloadThreadPool;
    //   38: getfield 74	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool:mThreadlock	Ljava/lang/Object;
    //   41: astore_1
    //   42: aload_1
    //   43: monitorenter
    //   44: ldc 58
    //   46: new 29	java/lang/StringBuilder
    //   49: dup
    //   50: ldc 60
    //   52: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   55: aload_0
    //   56: getfield 27	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:mIndex	I
    //   59: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc 76
    //   64: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 70	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: getfield 15	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:this$0	Lcom/tencent/tmassistantsdk/downloadservice/DownloadThreadPool;
    //   77: getfield 74	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool:mThreadlock	Ljava/lang/Object;
    //   80: invokevirtual 81	java/lang/Object:wait	()V
    //   83: aload_1
    //   84: monitorexit
    //   85: invokestatic 85	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   88: invokevirtual 89	java/lang/Thread:isInterrupted	()Z
    //   91: ifeq +186 -> 277
    //   94: ldc 58
    //   96: new 29	java/lang/StringBuilder
    //   99: dup
    //   100: ldc 60
    //   102: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: aload_0
    //   106: getfield 27	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:mIndex	I
    //   109: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: ldc 91
    //   114: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 70	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: ldc 56
    //   125: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: return
    //   129: astore_2
    //   130: ldc 58
    //   132: new 29	java/lang/StringBuilder
    //   135: dup
    //   136: ldc 60
    //   138: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   141: aload_0
    //   142: getfield 27	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:mIndex	I
    //   145: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: ldc 91
    //   150: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 70	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: ldc 58
    //   161: aload_2
    //   162: ldc 93
    //   164: iconst_0
    //   165: anewarray 78	java/lang/Object
    //   168: invokestatic 99	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: aload_1
    //   172: monitorexit
    //   173: ldc 56
    //   175: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: return
    //   179: astore_2
    //   180: aload_1
    //   181: monitorexit
    //   182: ldc 56
    //   184: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: aload_2
    //   188: athrow
    //   189: aload_1
    //   190: ifnull +59 -> 249
    //   193: ldc 58
    //   195: new 29	java/lang/StringBuilder
    //   198: dup
    //   199: ldc 101
    //   201: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   204: aload_0
    //   205: invokevirtual 104	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:getName	()Ljava/lang/String;
    //   208: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc 106
    //   213: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_1
    //   217: invokevirtual 111	com/tencent/tmassistantsdk/downloadservice/DownloadTask:getDownloadURI	()Ljava/lang/String;
    //   220: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 70	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: invokestatic 117	com/tencent/tmassistantsdk/downloadservice/DownloadHelper:getWakeLock	()Landroid/os/PowerManager$WakeLock;
    //   232: astore_2
    //   233: aload_1
    //   234: aload_0
    //   235: invokevirtual 104	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:getName	()Ljava/lang/String;
    //   238: invokevirtual 120	com/tencent/tmassistantsdk/downloadservice/DownloadTask:exec	(Ljava/lang/String;)V
    //   241: aload_2
    //   242: ifnull +7 -> 249
    //   245: aload_2
    //   246: invokevirtual 125	android/os/PowerManager$WakeLock:release	()V
    //   249: aload_0
    //   250: getfield 15	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:this$0	Lcom/tencent/tmassistantsdk/downloadservice/DownloadThreadPool;
    //   253: getfield 128	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool:mTaskLock	Ljava/lang/Object;
    //   256: astore_2
    //   257: aload_2
    //   258: monitorenter
    //   259: aload_1
    //   260: ifnull +15 -> 275
    //   263: aload_0
    //   264: getfield 15	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:this$0	Lcom/tencent/tmassistantsdk/downloadservice/DownloadThreadPool;
    //   267: getfield 132	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool:mExecList	Ljava/util/ArrayList;
    //   270: aload_1
    //   271: invokevirtual 138	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   274: pop
    //   275: aload_2
    //   276: monitorexit
    //   277: aload_0
    //   278: getfield 15	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:this$0	Lcom/tencent/tmassistantsdk/downloadservice/DownloadThreadPool;
    //   281: invokevirtual 141	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool:hasWaitingTask	()Z
    //   284: ifeq -250 -> 34
    //   287: aconst_null
    //   288: astore_1
    //   289: aload_0
    //   290: getfield 15	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:this$0	Lcom/tencent/tmassistantsdk/downloadservice/DownloadThreadPool;
    //   293: getfield 128	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool:mTaskLock	Ljava/lang/Object;
    //   296: astore_2
    //   297: aload_2
    //   298: monitorenter
    //   299: aload_0
    //   300: getfield 15	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:this$0	Lcom/tencent/tmassistantsdk/downloadservice/DownloadThreadPool;
    //   303: getfield 145	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool:mWaitingList	Ljava/util/PriorityQueue;
    //   306: invokevirtual 151	java/util/PriorityQueue:size	()I
    //   309: ifle +29 -> 338
    //   312: aload_0
    //   313: getfield 15	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:this$0	Lcom/tencent/tmassistantsdk/downloadservice/DownloadThreadPool;
    //   316: getfield 145	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool:mWaitingList	Ljava/util/PriorityQueue;
    //   319: invokevirtual 154	java/util/PriorityQueue:remove	()Ljava/lang/Object;
    //   322: checkcast 108	com/tencent/tmassistantsdk/downloadservice/DownloadTask
    //   325: astore_1
    //   326: aload_0
    //   327: getfield 15	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:this$0	Lcom/tencent/tmassistantsdk/downloadservice/DownloadThreadPool;
    //   330: getfield 132	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool:mExecList	Ljava/util/ArrayList;
    //   333: aload_1
    //   334: invokevirtual 157	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   337: pop
    //   338: aload_2
    //   339: monitorexit
    //   340: invokestatic 85	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   343: invokevirtual 89	java/lang/Thread:isInterrupted	()Z
    //   346: ifeq -157 -> 189
    //   349: ldc 58
    //   351: new 29	java/lang/StringBuilder
    //   354: dup
    //   355: ldc 60
    //   357: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   360: aload_0
    //   361: getfield 27	com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread:mIndex	I
    //   364: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   367: ldc 91
    //   369: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 70	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   378: ldc 56
    //   380: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   383: return
    //   384: astore_1
    //   385: aload_2
    //   386: monitorexit
    //   387: ldc 56
    //   389: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   392: aload_1
    //   393: athrow
    //   394: astore_1
    //   395: aload_2
    //   396: monitorexit
    //   397: ldc 56
    //   399: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   402: aload_1
    //   403: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	this	TaskThread
    //   41	293	1	localObject1	java.lang.Object
    //   384	9	1	localObject2	java.lang.Object
    //   394	9	1	localObject3	java.lang.Object
    //   129	33	2	localInterruptedException	java.lang.InterruptedException
    //   179	9	2	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   44	83	129	java/lang/InterruptedException
    //   44	83	179	finally
    //   83	85	179	finally
    //   130	173	179	finally
    //   180	182	179	finally
    //   299	338	384	finally
    //   338	340	384	finally
    //   385	387	384	finally
    //   263	275	394	finally
    //   275	277	394	finally
    //   395	397	394	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.DownloadThreadPool.TaskThread
 * JD-Core Version:    0.7.0.1
 */