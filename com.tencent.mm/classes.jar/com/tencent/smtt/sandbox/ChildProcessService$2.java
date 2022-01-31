package com.tencent.smtt.sandbox;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.q;
import java.util.concurrent.Semaphore;

class ChildProcessService$2
  implements Runnable
{
  static
  {
    AppMethodBeat.i(138988);
    if (!ChildProcessService.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(138988);
      return;
    }
  }
  
  ChildProcessService$2(ChildProcessService paramChildProcessService, Context paramContext) {}
  
  public void run()
  {
    AppMethodBeat.i(138987);
    try
    {
      if (ChildProcessService.use_isolated_process)
      {
        q.d();
        q.a(this.this$0);
      }
      synchronized (ChildProcessService.access$500(this.this$0))
      {
        if (ChildProcessService.access$600(this.this$0) == null) {
          ChildProcessService.access$500(this.this$0).wait();
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      Log.e("ChildProcessService", "%s startup failed: %s", new Object[] { "ChildProcessMain", localInterruptedException });
      AppMethodBeat.o(138987);
      return;
    }
    if ((!$assertionsDisabled) && (!ChildProcessService.access$100(this.this$0)))
    {
      ??? = new AssertionError();
      AppMethodBeat.o(138987);
      throw ((Throwable)???);
    }
    boolean bool;
    if (ChildProcessService.use_isolated_process) {
      bool = q.a(this.val$mAppContext, ChildProcessService.access$700(this.this$0));
    }
    for (;;)
    {
      if (!bool)
      {
        Log.e("ChildProcessService", "@mMainThread loadNativeLibrary failed!", new Object[0]);
        System.exit(-1);
        ChildProcessService.access$800(this.this$0).initCommandLine(ChildProcessService.access$600(this.this$0));
      }
      synchronized (ChildProcessService.access$900(this.this$0))
      {
        ChildProcessService.access$1002(this.this$0, true);
        ChildProcessService.access$900(this.this$0).notifyAll();
        synchronized (ChildProcessService.access$500(this.this$0))
        {
          ChildProcessService.access$500(this.this$0).notifyAll();
          if (ChildProcessService.access$1100(this.this$0) != null) {
            break;
          }
          ChildProcessService.access$500(this.this$0).wait();
        }
        bool = q.a(this.val$mAppContext);
        continue;
        q.e();
      }
    }
    SparseArray localSparseArray = ChildProcessService.access$800(this.this$0).getFileDescriptorsIdsToKeys();
    int[] arrayOfInt1 = new int[ChildProcessService.access$1100(this.this$0).length];
    String[] arrayOfString = new String[ChildProcessService.access$1100(this.this$0).length];
    int[] arrayOfInt2 = new int[ChildProcessService.access$1100(this.this$0).length];
    long[] arrayOfLong1 = new long[ChildProcessService.access$1100(this.this$0).length];
    long[] arrayOfLong2 = new long[ChildProcessService.access$1100(this.this$0).length];
    int i = 0;
    FileDescriptorInfo localFileDescriptorInfo;
    while (i < ChildProcessService.access$1100(this.this$0).length)
    {
      localFileDescriptorInfo = ChildProcessService.access$1100(this.this$0)[i];
      if (localSparseArray == null) {
        break label570;
      }
      ??? = (String)localSparseArray.get(localFileDescriptorInfo.id);
      break label558;
      if (localFileDescriptorInfo.fd != null) {
        arrayOfInt2[i] = localFileDescriptorInfo.fd.detachFd();
      }
      arrayOfLong1[i] = localFileDescriptorInfo.offset;
      arrayOfLong2[i] = localFileDescriptorInfo.size;
      i += 1;
    }
    label558:
    label570:
    label573:
    for (;;)
    {
      arrayOfInt1[i] = localFileDescriptorInfo.id;
      break;
      ChildProcessService.access$800(this.this$0).RegisterFileDescriptors(arrayOfString, arrayOfInt1, arrayOfInt2, arrayOfLong1, arrayOfLong2);
      ChildProcessService.access$800(this.this$0).onBeforeMain();
      if (ChildProcessService.access$1200(this.this$0).tryAcquire())
      {
        ChildProcessService.access$800(this.this$0).startContentMainRunner();
        ChildProcessService.access$800(this.this$0).ExitChildProcess();
      }
      AppMethodBeat.o(138987);
      return;
      for (;;)
      {
        if (??? == null) {
          break label573;
        }
        arrayOfString[i] = ???;
        break;
        ??? = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sandbox.ChildProcessService.2
 * JD-Core Version:    0.7.0.1
 */