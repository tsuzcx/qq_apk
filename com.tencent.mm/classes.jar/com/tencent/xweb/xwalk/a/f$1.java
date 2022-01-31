package com.tencent.xweb.xwalk.a;

import java.util.TimerTask;
import org.xwalk.core.XWalkInitializer;

final class f$1
  extends TimerTask
{
  f$1(f paramf) {}
  
  public final void run()
  {
    XWalkInitializer.addXWalkInitializeLog("task retry execute ! mRetrytimes = " + f.a(this.xnu));
    f.a(f.b(this.xnu), f.c(this.xnu), f.a(this.xnu));
    f.d(this.xnu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.f.1
 * JD-Core Version:    0.7.0.1
 */