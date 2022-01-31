package com.tencent.xweb.xwalk;

import org.xwalk.core.XWalkV8;

final class g$1
  implements Runnable
{
  g$1(g paramg, int paramInt) {}
  
  public final void run()
  {
    if (this.xlZ.xlX != null) {
      return;
    }
    this.xlZ.xlX = new XWalkV8();
    this.xlZ.xlX.init(this.xlY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g.1
 * JD-Core Version:    0.7.0.1
 */