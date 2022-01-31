package com.tencent.xweb.x5;

import com.tencent.smtt.sdk.QbSdk.PreInitCallback;
import com.tencent.xweb.WebView.c;

final class X5WebFactory$b$1
  implements QbSdk.PreInitCallback
{
  private boolean xkH = false;
  private boolean xkI = false;
  
  X5WebFactory$b$1(WebView.c paramc) {}
  
  public final void onCoreInitFinished()
  {
    this.xkH = true;
    if ((this.xkH) && (this.xkI) && (this.xkJ != null))
    {
      this.xkJ.onCoreInitFinished();
      X5WebFactory.b.BF();
    }
  }
  
  public final void onViewInitFinished(boolean paramBoolean)
  {
    this.xkI = true;
    if ((this.xkH) && (this.xkI) && (this.xkJ != null))
    {
      this.xkJ.onCoreInitFinished();
      X5WebFactory.b.BF();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.x5.X5WebFactory.b.1
 * JD-Core Version:    0.7.0.1
 */