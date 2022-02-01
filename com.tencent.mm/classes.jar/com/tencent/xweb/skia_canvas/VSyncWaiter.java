package com.tencent.xweb.skia_canvas;

import android.os.Handler;
import android.os.HandlerThread;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VSyncWaiter
{
  private final Handler mWorkingHandler;
  private final HandlerThread mWorkingThread;
  
  private VSyncWaiter()
  {
    AppMethodBeat.i(218255);
    this.mWorkingThread = new HandlerThread("VSyncWaiterWorkingThread");
    this.mWorkingThread.start();
    this.mWorkingHandler = new Handler(this.mWorkingThread.getLooper());
    AppMethodBeat.o(218255);
  }
  
  public static VSyncWaiter getInstance()
  {
    return Holder.INSTANCE;
  }
  
  public void asyncWaitForVSync(final VSyncWaiterCallback paramVSyncWaiterCallback)
  {
    AppMethodBeat.i(218254);
    this.mWorkingHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(218252);
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback()
        {
          public void doFrame(long paramAnonymous2Long)
          {
            AppMethodBeat.i(218251);
            VSyncWaiter.1.this.val$callback.doFrame(paramAnonymous2Long);
            AppMethodBeat.o(218251);
          }
        });
        AppMethodBeat.o(218252);
      }
    });
    AppMethodBeat.o(218254);
  }
  
  static final class Holder
  {
    static final VSyncWaiter INSTANCE;
    
    static
    {
      AppMethodBeat.i(218253);
      INSTANCE = new VSyncWaiter(null);
      AppMethodBeat.o(218253);
    }
  }
  
  static abstract interface VSyncWaiterCallback
  {
    public abstract void doFrame(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.VSyncWaiter
 * JD-Core Version:    0.7.0.1
 */