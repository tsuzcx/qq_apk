package com.tencent.mm.plugin.zero.tasks;

import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.b.g;
import com.tencent.wcdb.support.Log;

public final class a
  extends com.tencent.mm.kernel.a.c.a
{
  public final void execute(g paramg)
  {
    if (!k.fd("wcdb")) {
      k.b("wcdb", getClass().getClassLoader());
    }
    Log.setLogger(new a.1(this));
  }
  
  public final String name()
  {
    return "boot-db-prepare";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.tasks.a
 * JD-Core Version:    0.7.0.1
 */