package com.tencent.mm.plugin.zero.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;

public class LoadProtocolJNITask
  extends a
{
  private void retryOnce(Runnable paramRunnable)
  {
    AppMethodBeat.i(133035);
    try {}finally
    {
      paramRunnable.run();
      AppMethodBeat.o(133035);
    }
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(133034);
    getClass().getClassLoader();
    k.DA("MMProtocalJni");
    retryOnce(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(133031);
        MMProtocalJni.setClientPackVersion(d.Yxh);
        AppMethodBeat.o(133031);
      }
    });
    retryOnce(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(133032);
        MMProtocalJni.setProtocalJniLogLevel(Log.getLogLevel());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask
 * JD-Core Version:    0.7.0.1
 */