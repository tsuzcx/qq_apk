package okhttp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.c;

public final class m
{
  private int ajMF;
  private int ajMG;
  private Runnable ajMH;
  final Deque<w.a> ajMI;
  private final Deque<w.a> ajMJ;
  private final Deque<w> ajMK;
  private ExecutorService executorService;
  
  static
  {
    AppMethodBeat.i(186704);
    if (!m.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(186704);
      return;
    }
  }
  
  public m()
  {
    AppMethodBeat.i(186663);
    this.ajMF = 64;
    this.ajMG = 5;
    this.ajMI = new ArrayDeque();
    this.ajMJ = new ArrayDeque();
    this.ajMK = new ArrayDeque();
    AppMethodBeat.o(186663);
  }
  
  private int a(w.a parama)
  {
    AppMethodBeat.i(186676);
    Iterator localIterator = this.ajMJ.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      w.a locala = (w.a)localIterator.next();
      if (!locala.ajNI.ajNG)
      {
        if (!locala.kHe().equals(parama.kHe())) {
          break label77;
        }
        i += 1;
      }
    }
    label77:
    for (;;)
    {
      break;
      AppMethodBeat.o(186676);
      return i;
    }
  }
  
  private <T> void a(Deque<T> paramDeque, T paramT)
  {
    AppMethodBeat.i(186687);
    try
    {
      if (!paramDeque.remove(paramT))
      {
        paramDeque = new AssertionError("Call wasn't in-flight!");
        AppMethodBeat.o(186687);
        throw paramDeque;
      }
    }
    finally
    {
      AppMethodBeat.o(186687);
    }
    paramDeque = this.ajMH;
    if ((!kGI()) && (paramDeque != null)) {
      paramDeque.run();
    }
    AppMethodBeat.o(186687);
  }
  
  private ExecutorService kGH()
  {
    try
    {
      AppMethodBeat.i(186667);
      if (this.executorService == null) {
        this.executorService = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), c.threadFactory("OkHttp Dispatcher", false));
      }
      ExecutorService localExecutorService = this.executorService;
      AppMethodBeat.o(186667);
      return localExecutorService;
    }
    finally {}
  }
  
  private int kGJ()
  {
    try
    {
      AppMethodBeat.i(186697);
      int i = this.ajMJ.size();
      int j = this.ajMK.size();
      AppMethodBeat.o(186697);
      return i + j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void a(w paramw)
  {
    try
    {
      AppMethodBeat.i(186722);
      this.ajMK.add(paramw);
      AppMethodBeat.o(186722);
      return;
    }
    finally
    {
      paramw = finally;
      throw paramw;
    }
  }
  
  final void b(w.a parama)
  {
    AppMethodBeat.i(186728);
    a(this.ajMJ, parama);
    AppMethodBeat.o(186728);
  }
  
  final void b(w paramw)
  {
    AppMethodBeat.i(186736);
    a(this.ajMK, paramw);
    AppMethodBeat.o(186736);
  }
  
  final boolean kGI()
  {
    int i = 0;
    AppMethodBeat.i(186716);
    if ((!$assertionsDisabled) && (Thread.holdsLock(this)))
    {
      localObject1 = new AssertionError();
      AppMethodBeat.o(186716);
      throw ((Throwable)localObject1);
    }
    Object localObject1 = new ArrayList();
    Object localObject4;
    Object localObject5;
    try
    {
      localObject4 = this.ajMI.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (w.a)((Iterator)localObject4).next();
        if (this.ajMJ.size() >= this.ajMF) {
          break;
        }
        if (a((w.a)localObject5) < this.ajMG)
        {
          ((Iterator)localObject4).remove();
          ((List)localObject1).add(localObject5);
          this.ajMJ.add(localObject5);
        }
      }
      if (kGJ() <= 0) {
        break label237;
      }
    }
    finally
    {
      AppMethodBeat.o(186716);
    }
    boolean bool = true;
    int j = localObject2.size();
    for (;;)
    {
      if (i < j)
      {
        localObject4 = (w.a)localObject2.get(i);
        localObject5 = kGH();
        if ((!w.a.$assertionsDisabled) && (Thread.holdsLock(((w.a)localObject4).ajNI.ajNB.ajNh)))
        {
          AssertionError localAssertionError = new AssertionError();
          AppMethodBeat.o(186716);
          throw localAssertionError;
          label237:
          bool = false;
          break;
        }
        try
        {
          ((ExecutorService)localObject5).execute((Runnable)localObject4);
          i += 1;
        }
        catch (RejectedExecutionException localRejectedExecutionException)
        {
          for (;;)
          {
            InterruptedIOException localInterruptedIOException = new InterruptedIOException("executor rejected");
            localInterruptedIOException.initCause(localRejectedExecutionException);
            w.c(((w.a)localObject4).ajNI);
            ((w.a)localObject4).ajNJ.a(((w.a)localObject4).ajNI, localInterruptedIOException);
            ((w.a)localObject4).ajNI.ajNB.ajNh.b((w.a)localObject4);
          }
        }
        finally
        {
          ((w.a)localObject4).ajNI.ajNB.ajNh.b((w.a)localObject4);
          AppMethodBeat.o(186716);
        }
      }
    }
    AppMethodBeat.o(186716);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.m
 * JD-Core Version:    0.7.0.1
 */