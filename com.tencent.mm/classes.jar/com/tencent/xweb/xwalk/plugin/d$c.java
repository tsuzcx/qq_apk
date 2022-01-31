package com.tencent.xweb.xwalk.plugin;

import com.tencent.xweb.util.e;
import org.xwalk.core.XWalkLibraryLoader.DownloadInfo;
import org.xwalk.core.XWalkLibraryLoader.DownloadListener;

public final class d$c
  implements XWalkLibraryLoader.DownloadListener
{
  private b xmK;
  private c.a xmL;
  private d xmv;
  
  d$c(d paramd, b paramb, c.a parama)
  {
    this.xmv = paramd;
    this.xmK = paramb;
    this.xmL = parama;
  }
  
  public final void onDownloadCancelled()
  {
    this.xmv.ec(this.xmK.cTE(), -3);
    if (this.xmK.cTE().equals("FullScreenVideo")) {
      e.cTr();
    }
  }
  
  public final void onDownloadCompleted(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
  {
    if (this.xmK.cTE().equals("FullScreenVideo")) {
      e.cTq();
    }
    new d.c.1(this).execute(new Void[0]);
  }
  
  public final void onDownloadFailed(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
  {
    this.xmv.ec(this.xmK.cTE(), -1);
    if (this.xmK.cTE().equals("FullScreenVideo")) {
      e.cTr();
    }
  }
  
  public final void onDownloadStarted(int paramInt)
  {
    if (this.xmK.cTE().equals("FullScreenVideo")) {
      e.cTp();
    }
  }
  
  public final void onDownloadUpdated(int paramInt)
  {
    d locald = this.xmv;
    String str = this.xmK.cTE();
    if ((locald.xmz.xmI == 3) && (locald.cTJ()) && (locald.xmt.equals(str))) {
      locald.xmu.KG(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.plugin.d.c
 * JD-Core Version:    0.7.0.1
 */