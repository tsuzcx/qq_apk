package com.tencent.tav.decoder.thread;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.logger.Logger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tav/decoder/thread/ReActionHandlerThread;", "Landroid/os/HandlerThread;", "name", "", "(Ljava/lang/String;)V", "TAG", "handler", "Landroid/os/Handler;", "action", "", "doAction", "release", "start", "avfoundation_release"}, k=1, mv={1, 1, 15})
public abstract class ReActionHandlerThread
  extends HandlerThread
{
  private final String TAG;
  private Handler handler;
  
  public ReActionHandlerThread(String paramString)
  {
    super(paramString);
    this.TAG = "ReHandlerThread-".concat(String.valueOf(paramString));
  }
  
  public final void action()
  {
    Logger.v(this.TAG, "action: " + this + " " + hashCode());
    Handler localHandler = this.handler;
    if (localHandler != null) {
      localHandler.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(216339);
          this.this$0.doAction();
          AppMethodBeat.o(216339);
        }
      });
    }
  }
  
  protected abstract void doAction();
  
  /* Error */
  public final void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 90	com/tencent/tav/decoder/thread/ReActionHandlerThread:handler	Landroid/os/Handler;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +8 -> 16
    //   11: aload_1
    //   12: aconst_null
    //   13: invokevirtual 105	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   16: getstatic 111	android/os/Build$VERSION:SDK_INT	I
    //   19: bipush 18
    //   21: if_icmplt +11 -> 32
    //   24: aload_0
    //   25: invokevirtual 115	com/tencent/tav/decoder/thread/ReActionHandlerThread:quitSafely	()Z
    //   28: pop
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: invokevirtual 118	com/tencent/tav/decoder/thread/ReActionHandlerThread:quit	()Z
    //   36: pop
    //   37: goto -8 -> 29
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	ReActionHandlerThread
    //   6	6	1	localHandler	Handler
    //   40	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	40	finally
    //   11	16	40	finally
    //   16	29	40	finally
    //   32	37	40	finally
  }
  
  public void start()
  {
    super.start();
    this.handler = new Handler(getLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.decoder.thread.ReActionHandlerThread
 * JD-Core Version:    0.7.0.1
 */