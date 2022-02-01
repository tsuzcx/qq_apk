package com.tencent.mm.pluginsdk.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.concurrent.ExecutorService;
import junit.framework.Assert;

public abstract class m<Params, Progress, Result>
{
  ap handler = new ap(Looper.getMainLooper());
  private boolean isStart = false;
  
  public abstract Result dQ();
  
  public abstract ExecutorService dnm();
  
  public void onPostExecute(Result paramResult) {}
  
  public final boolean v(final Params... paramVarArgs)
  {
    if (this.isStart) {
      Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
    }
    this.isStart = true;
    w(paramVarArgs);
    ExecutorService localExecutorService = dnm();
    if (localExecutorService == null) {
      return false;
    }
    localExecutorService.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151637);
        final Object localObject = m.this.dQ();
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
  
  public void w(Params... paramVarArgs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.m
 * JD-Core Version:    0.7.0.1
 */