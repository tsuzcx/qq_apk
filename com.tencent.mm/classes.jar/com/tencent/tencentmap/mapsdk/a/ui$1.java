package com.tencent.tencentmap.mapsdk.a;

import java.util.concurrent.ThreadFactory;

final class ui$1
  implements ThreadFactory
{
  private int a = 0;
  
  ui$1(ui paramui) {}
  
  public final Thread newThread(Runnable paramRunnable)
  {
    StringBuilder localStringBuilder = new StringBuilder("TileFetchThread#");
    int i = this.a;
    this.a = (i + 1);
    paramRunnable = new Thread(paramRunnable, i);
    paramRunnable.setPriority(10);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ui.1
 * JD-Core Version:    0.7.0.1
 */