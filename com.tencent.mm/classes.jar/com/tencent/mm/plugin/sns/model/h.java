package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.concurrent.ExecutorService;
import junit.framework.Assert;

public abstract class h<Params, Progress, Result>
{
  aq handler = ah.cXK();
  private boolean isStart = false;
  
  public abstract ExecutorService dFv();
  
  public abstract Result es();
  
  public void onPostExecute(Result paramResult) {}
  
  public final boolean x(final Params... paramVarArgs)
  {
    if (this.isStart) {
      Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
    }
    this.isStart = true;
    ExecutorService localExecutorService = dFv();
    if (localExecutorService == null) {
      return false;
    }
    localExecutorService.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95555);
        final Object localObject = h.this.es();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.h
 * JD-Core Version:    0.7.0.1
 */