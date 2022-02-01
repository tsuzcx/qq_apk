package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.concurrent.ExecutorService;
import junit.framework.Assert;

public abstract class h<Params, Progress, Result>
{
  MMHandler handler = aj.dRd();
  private boolean isStart = false;
  
  public abstract ExecutorService eGk();
  
  public abstract Result ew();
  
  public void onPostExecute(Result paramResult) {}
  
  public final boolean y(final Params... paramVarArgs)
  {
    if (this.isStart) {
      Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
    }
    this.isStart = true;
    ExecutorService localExecutorService = eGk();
    if (localExecutorService == null) {
      return false;
    }
    localExecutorService.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95555);
        final Object localObject = h.this.ew();
        h.this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95554);
            h.this.onPostExecute(localObject);
            AppMethodBeat.o(95554);
          }
        });
        AppMethodBeat.o(95555);
      }
    });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.h
 * JD-Core Version:    0.7.0.1
 */