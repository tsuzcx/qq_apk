package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.sdk.platformtools.y;

public abstract class d
  implements Runnable
{
  public d()
  {
    y.i("MicroMsg.WearBaseWorkerTask", "Create %s", new Object[] { getName() });
  }
  
  public abstract void execute();
  
  public abstract String getName();
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      execute();
      long l2 = System.currentTimeMillis();
      y.i("MicroMsg.WearBaseWorkerTask", "execute %s | use time %d", new Object[] { getName(), Long.valueOf(l2 - l1) });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.WearBaseWorkerTask", localException, "run task %s occur exception: %s", new Object[] { getName(), localException.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.d
 * JD-Core Version:    0.7.0.1
 */