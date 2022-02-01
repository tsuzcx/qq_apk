package com.tencent.mm.pluginsdk.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.concurrent.ExecutorService;
import junit.framework.Assert;

public abstract class m<Params, Progress, Result>
{
  protected aq handler = new aq(Looper.getMainLooper());
  private boolean isStart = false;
  
  public abstract ExecutorService dFv();
  
  public abstract Result doInBackground(Params... paramVarArgs);
  
  public void onPostExecute(Result paramResult) {}
  
  public void onProgressUpdate(Progress... paramVarArgs) {}
  
  public final boolean x(final Params... paramVarArgs)
  {
    if (this.isStart) {
      Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
    }
    this.isStart = true;
    y(paramVarArgs);
    ExecutorService localExecutorService = dFv();
    if (localExecutorService == null) {
      return false;
    }
    localExecutorService.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151637);
        final Object localObject = m.this.doInBackground(paramVarArgs);
        m.this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(151636);
            m.this.onPostExecute(localObject);
            AppMethodBeat.o(151636);
          }
        });
        AppMethodBeat.o(151637);
      }
    });
    return true;
  }
  
  public void y(Params... paramVarArgs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.m
 * JD-Core Version:    0.7.0.1
 */