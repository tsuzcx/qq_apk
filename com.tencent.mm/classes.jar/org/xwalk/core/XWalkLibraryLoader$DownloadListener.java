package org.xwalk.core;

public abstract interface XWalkLibraryLoader$DownloadListener
{
  public abstract void onDownloadCancelled();
  
  public abstract void onDownloadCompleted(XWalkLibraryLoader.DownloadInfo paramDownloadInfo);
  
  public abstract void onDownloadFailed(XWalkLibraryLoader.DownloadInfo paramDownloadInfo);
  
  public abstract void onDownloadStarted(int paramInt);
  
  public abstract void onDownloadUpdated(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkLibraryLoader.DownloadListener
 * JD-Core Version:    0.7.0.1
 */