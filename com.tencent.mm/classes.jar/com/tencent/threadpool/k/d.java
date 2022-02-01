package com.tencent.threadpool.k;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/threadpool/stub/ThreadPoolStubDummyImpl;", "Lcom/tencent/threadpool/stub/IThreadPoolStub;", "()V", "STUB_HT_COUNT", "", "TAG", "", "mainHandler", "Landroid/os/Handler;", "stubExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "stubHandler", "", "stubHandlerThreads", "", "Landroid/os/HandlerThread;", "compute", "Ljava/util/concurrent/Future;", "runnable", "Ljava/lang/Runnable;", "serialTag", "T", "callable", "Ljava/util/concurrent/Callable;", "computeDelay", "delayMs", "", "cycle", "initialDelayMs", "periodMs", "cycleRate", "execute", "executeAtFront", "executeDelay", "forkExecutorService", "Ljava/util/concurrent/ExecutorService;", "name", "corePoolSize", "maximumPoolSize", "workQueue", "Ljava/util/concurrent/BlockingQueue;", "handler", "Lcom/tencent/threadpool/stub/StubRejectedExecutionHandler;", "forkSingleExecutorService", "io", "ioDelay", "persist", "persistDelay", "provideSerial", "removeBy", "", "serial", "Ljava/util/concurrent/FutureTask;", "future", "serialAtFront", "ui", "uiAtFront", "uiDelay", "of", "", "threadpool-stub_release"}, k=1, mv={1, 1, 16})
public final class d
  implements a
{
  private static final ScheduledExecutorService ahCP;
  private static final List<HandlerThread> ahCQ;
  private static final Map<String, Handler> ahCR;
  public static final d ahCS;
  private static final Handler mainHandler;
  
  static
  {
    AppMethodBeat.i(226860);
    ahCS = new d();
    mainHandler = new Handler(Looper.getMainLooper());
    ahCP = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors() * 2);
    ahCR = (Map)new LinkedHashMap();
    ahCQ = (List)new ArrayList();
    int i = 1;
    while (i <= 50)
    {
      ahCQ.add(new HandlerThread("#StubHT-".concat(String.valueOf(i))));
      i += 1;
    }
    AppMethodBeat.o(226860);
  }
  
  public final Future<?> bq(Runnable paramRunnable)
  {
    AppMethodBeat.i(226862);
    s.t(paramRunnable, "runnable");
    s.t(paramRunnable, "$this$toFutureTask");
    paramRunnable = new FutureTask(paramRunnable, null);
    ahCP.execute((Runnable)paramRunnable);
    paramRunnable = (Future)paramRunnable;
    AppMethodBeat.o(226862);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.k.d
 * JD-Core Version:    0.7.0.1
 */