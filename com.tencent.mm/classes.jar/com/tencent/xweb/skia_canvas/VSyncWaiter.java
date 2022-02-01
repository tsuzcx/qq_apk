package com.tencent.xweb.skia_canvas;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VSyncWaiter
{
  private static final String TAG = "VSyncWaiter";
  private volatile Handler mWorkingHandler;
  
  public static VSyncWaiter getInstance()
  {
    return Holder.INSTANCE;
  }
  
  private void initWorkingThread()
  {
    AppMethodBeat.i(196793);
    if (this.mWorkingHandler == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("SkiaCanvasVSyncWaiterThread", -2);
      localHandlerThread.start();
      this.mWorkingHandler = new Handler(localHandlerThread.getLooper());
    }
    AppMethodBeat.o(196793);
  }
  
  private void runVSyncCallback(final VSyncWaiterCallback paramVSyncWaiterCallback)
  {
    AppMethodBeat.i(196792);
    Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback()
    {
      public void doFrame(long paramAnonymousLong)
      {
        AppMethodBeat.i(196784);
        paramVSyncWaiterCallback.doFrame(paramAnonymousLong);
        AppMethodBeat.o(196784);
      }
    });
    AppMethodBeat.o(196792);
  }
  
  public void asyncWaitForVSync(final VSyncWaiterCallback paramVSyncWaiterCallback)
  {
    AppMethodBeat.i(196789);
    if (Looper.myLooper() != null)
    {
      runVSyncCallback(paramVSyncWaiterCallback);
      AppMethodBeat.o(196789);
      return;
    }
    initWorkingThread();
    this.mWorkingHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(196782);
        VSyncWaiter.access$000(VSyncWaiter.this, paramVSyncWaiterCallback);
        AppMethodBeat.o(196782);
      }
    });
    AppMethodBeat.o(196789);
  }
  
  static final class Holder
  {
    static final VSyncWaiter INSTANCE;
    
    static
    {
      AppMethodBeat.i(196786);
      INSTANCE = new VSyncWaiter(null);
      AppMethodBeat.o(196786);
    }
  }
  
  static abstract interface VSyncWaiterCallback
  {
    public abstract void doFrame(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.VSyncWaiter
 * JD-Core Version:    0.7.0.1
 */