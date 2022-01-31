package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.sdk.platformtools.ai;

public final class b
{
  public volatile ai rff = new ai("WebviewWorkerThread");
  an rfg;
  
  public b(an paraman)
  {
    this.rfg = paraman;
  }
  
  public final ai DS()
  {
    if (this.rff == null) {
      this.rff = new ai("WebviewWorkerThread");
    }
    return this.rff;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.b
 * JD-Core Version:    0.7.0.1
 */