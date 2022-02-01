package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.concurrent.ExecutorService;
import junit.framework.Assert;

public abstract class g<Params, Progress, Result>
{
  ap handler = ag.cVf();
  private boolean isStart = false;
  
  public abstract ExecutorService dCe();
  
  public abstract Result es();
  
  public void onPostExecute(Result paramResult) {}
  
  public final boolean x(final Params... paramVarArgs)
  {
    if (this.isStart) {
      Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
    }
    this.isStart = true;
    ExecutorService localExecutorService = dCe();
    if (localExecutorService == null) {
      return false;
    }
    localExecutorService.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95555);
        final Object localObject = g.this.es();
        g.this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95554);
            g.this.onPostExecute(localObject);
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
 * Qualified Name:     com.tencent.mm.plugin.sns.model.g
 * JD-Core Version:    0.7.0.1
 */