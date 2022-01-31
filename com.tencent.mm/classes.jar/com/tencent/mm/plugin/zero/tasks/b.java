package com.tencent.mm.plugin.zero.tasks;

import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;

public final class b
  extends a
{
  public final void execute(g paramg)
  {
    k.b("commonimgdec", getClass().getClassLoader());
    k.b("wechatcommon", getClass().getClassLoader());
    MMBitmapFactory.init();
  }
  
  public final String name()
  {
    return "boot-load-wechatcommon-library";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.tasks.b
 * JD-Core Version:    0.7.0.1
 */