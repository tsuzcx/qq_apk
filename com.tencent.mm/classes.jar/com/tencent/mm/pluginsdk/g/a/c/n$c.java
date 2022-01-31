package com.tencent.mm.pluginsdk.g.a.c;

import java.util.concurrent.PriorityBlockingQueue;

final class n$c
  extends PriorityBlockingQueue<Runnable>
{
  public n$c()
  {
    super(11, new n.c.1());
  }
  
  private static String Q(Runnable paramRunnable)
  {
    if ((paramRunnable instanceof f.c))
    {
      if ((((f.c)paramRunnable).rXr instanceof l)) {
        return String.format("priority = %d, urlKey = %s", new Object[] { Integer.valueOf(((l)((f.c)paramRunnable).rXr).priority), ((f.c)paramRunnable).rXr.cls() });
      }
      return String.format("unknown request = %s", new Object[] { ((f.c)paramRunnable).rXr });
    }
    return String.format("unknown runnable = %s", new Object[] { paramRunnable });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.n.c
 * JD-Core Version:    0.7.0.1
 */