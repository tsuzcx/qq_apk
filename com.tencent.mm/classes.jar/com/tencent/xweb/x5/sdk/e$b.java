package com.tencent.xweb.x5.sdk;

import com.tencent.smtt.sdk.QbSdk.PreInitCallback;

final class e$b
  implements QbSdk.PreInitCallback
{
  d.a xkU;
  
  public e$b(d.a parama)
  {
    this.xkU = parama;
  }
  
  public final void onCoreInitFinished() {}
  
  public final void onViewInitFinished(boolean paramBoolean)
  {
    if (this.xkU != null) {
      this.xkU.onViewInitFinished(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.e.b
 * JD-Core Version:    0.7.0.1
 */