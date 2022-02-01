package com.tencent.mm.plugin.zero.tasks;

import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;

public class LoadProtocolJNITask
  extends a
{
  private void retryOnce(Runnable paramRunnable)
  {
    AppMethodBeat.i(133035);
    try
    {
      paramRunnable.run();
      AppMethodBeat.o(133035);
      return;
    }
    catch (Throwable localThrowable)
    {
      paramRunnable.run();
      AppMethodBeat.o(133035);
    }
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(133034);
    getClass().getClassLoader();
    j.pq("MMProtocalJni");
    retryOnce(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(133031);
        MMProtocalJni.setClientPackVersion(d.CpK);
        AppMethodBeat.o(133031);
      }
    });
    retryOnce(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(133032);
        MMProtocalJni.setProtocalJniLogLevel(new Xlog().getLogLevel());
        AppMethodBeat.o(133032);
      }
    });
    retryOnce(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(133033);
        MMProtocalJni.setIsLite(false);
        AppMethodBeat.o(133033);
      }
    });
    AppMethodBeat.o(133034);
  }
  
  public String name()
  {
    return "boot-load-MMProtocalJni-library";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask
 * JD-Core Version:    0.7.0.1
 */