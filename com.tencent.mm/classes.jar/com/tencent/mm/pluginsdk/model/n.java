package com.tencent.mm.pluginsdk.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.concurrent.ExecutorService;
import junit.framework.Assert;

public abstract class n<Params, Progress, Result>
{
  protected MMHandler handler = new MMHandler(Looper.getMainLooper());
  private boolean isStart = false;
  
  public abstract Result doInBackground(Params... paramVarArgs);
  
  public abstract ExecutorService eGk();
  
  public void onPostExecute(Result paramResult) {}
  
  public void onProgressUpdate(Progress... paramVarArgs) {}
  
  public final boolean y(final Params... paramVarArgs)
  {
    if (this.isStart) {
      Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
    }
    this.isStart = true;
    z(paramVarArgs);
    ExecutorService localExecutorService = eGk();
    if (localExecutorService == null) {
      return false;
    }
    localExecutorService.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151637);
        final Object localObject = n.this.doInBackground(paramVarArgs);
        n.this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(151636);
            n.this.onPostExecute(localObject);
            AppMethodBeat.o(151636);
          }
        });
        AppMethodBeat.o(151637);
      }
    });
    return true;
  }
  
  public void z(Params... paramVarArgs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.n
 * JD-Core Version:    0.7.0.1
 */