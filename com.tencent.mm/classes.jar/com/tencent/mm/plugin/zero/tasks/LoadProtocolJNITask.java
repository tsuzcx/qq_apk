package com.tencent.mm.plugin.zero.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;

public class LoadProtocolJNITask
  extends a
{
  private void retryOnce(Runnable paramRunnable)
  {
    AppMethodBeat.i(58785);
    try
    {
      paramRunnable.run();
      AppMethodBeat.o(58785);
      return;
    }
    catch (Throwable localThrowable)
    {
      paramRunnable.run();
      AppMethodBeat.o(58785);
    }
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(58784);
    k.a("MMProtocalJni", getClass().getClassLoader());
    retryOnce(new LoadProtocolJNITask.1(this));
    retryOnce(new LoadProtocolJNITask.2(this));
    retryOnce(new LoadProtocolJNITask.3(this));
    AppMethodBeat.o(58784);
  }
  
  public String name()
  {
    return "boot-load-MMProtocalJni-library";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask
 * JD-Core Version:    0.7.0.1
 */