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
    AppMethodBeat.i(217458);
    this.mWorkingThread = new HandlerThread("VSyncWaiterWorkingThread");
    this.mWorkingThread.start();
    this.mWorkingHandler = new Handler(this.mWorkingThread.getLooper());
    AppMethodBeat.o(217458);
  }
  
  public static VSyncWaiter getInstance()
  {
    return Holder.INSTANCE;
  }
  
  public void asyncWaitForVSync(final VSyncWaiterCallback paramVSyncWaiterCallback)
  {
    AppMethodBeat.i(217457);
    this.mWorkingHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(217455);
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback()
        {
          public void doFrame(long paramAnonymous2Long)
          {
            AppMethodBeat.i(217454);
            VSyncWaiter.1.this.val$callback.doFrame(paramAnonymous2Long);
            AppMethodBeat.o(217454);
          }
        });
        AppMethodBeat.o(217455);
      }
    });
    AppMethodBeat.o(217457);
  }
  
  static final class Holder
  {
    static final VSyncWaiter INSTANCE;
    
    static
    {
      AppMethodBeat.i(217456);
      INSTANCE = new VSyncWaiter(null);
      AppMethodBeat.o(217456);
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