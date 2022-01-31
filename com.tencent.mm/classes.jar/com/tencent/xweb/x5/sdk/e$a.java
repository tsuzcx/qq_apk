package com.tencent.xweb.x5.sdk;

import com.tencent.smtt.sdk.TbsListener;

final class e$a
  implements TbsListener
{
  h xkT;
  
  public e$a(h paramh)
  {
    this.xkT = paramh;
  }
  
  public final void onDownloadFinish(int paramInt)
  {
    if (this.xkT != null) {
      this.xkT.onDownloadFinish(paramInt);
    }
  }
  
  public final void onDownloadProgress(int paramInt)
  {
    if (this.xkT != null) {
      this.xkT.onDownloadProgress(paramInt);
    }
  }
  
  public final void onInstallFinish(int paramInt)
  {
    if (this.xkT != null) {
      this.xkT.onInstallFinish(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.e.a
 * JD-Core Version:    0.7.0.1
 */