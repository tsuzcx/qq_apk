package com.tencent.mm.plugin.zero.tasks;

import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;

public class LoadProtocolJNITask
  extends a
{
  private void retryOnce(Runnable paramRunnable)
  {
    try
    {
      paramRunnable.run();
      return;
    }
    catch (Throwable localThrowable)
    {
      paramRunnable.run();
    }
  }
  
  public void execute(g paramg)
  {
    k.b("MMProtocalJni", getClass().getClassLoader());
    retryOnce(new LoadProtocolJNITask.1(this));
    retryOnce(new LoadProtocolJNITask.2(this));
    retryOnce(new LoadProtocolJNITask.3(this));
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