package com.tencent.mm.plugin.zero.tasks;

import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;

public final class LoadNormsgJNITask
  extends a
{
  public final void execute(g paramg)
  {
    k.b("stlport_shared", getClass().getClassLoader());
    k.b("wechatxlog", getClass().getClassLoader());
    k.b("wechatnormsg", getClass().getClassLoader());
  }
  
  public final String name()
  {
    return "boot-load-wechatnormsg-library";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.tasks.LoadNormsgJNITask
 * JD-Core Version:    0.7.0.1
 */