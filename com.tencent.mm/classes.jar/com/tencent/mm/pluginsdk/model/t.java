package com.tencent.mm.pluginsdk.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.concurrent.ExecutorService;
import junit.framework.Assert;

public abstract class t<Params, Progress, Result>
{
  protected MMHandler handler = new MMHandler(Looper.getMainLooper());
  private boolean isStart = false;
  
  public final boolean A(final Params... paramVarArgs)
  {
    if (this.isStart) {
      Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
    }
    this.isStart = true;
    B(paramVarArgs);
    ExecutorService localExecutorService = gDT();
    if (localExecutorService == null) {
      return false;
    }
    localExecutorService.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151637);
        final Object localObject = t.this.doInBackground(paramVarArgs);
        t.this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(151636);
            t.this.onPostExecute(localObject);
            AppMethodBeat.o(151636);
          }
        });
        AppMethodBeat.o(151637);
      }
    });
    return true;
  }
  
  public void B(Params... paramVarArgs) {}
  
  public abstract Result doInBackground(Params... paramVarArgs);
  
  public abstract ExecutorService gDT();
  
  public void onPostExecute(Result paramResult) {}
  
  public void onProgressUpdate(Progress... paramVarArgs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.t
 * JD-Core Version:    0.7.0.1
 */