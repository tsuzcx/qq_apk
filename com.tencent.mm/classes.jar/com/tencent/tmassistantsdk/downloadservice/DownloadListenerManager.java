package com.tencent.tmassistantsdk.downloadservice;

import java.util.ArrayList;
import java.util.Iterator;

public class DownloadListenerManager
{
  protected static DownloadListenerManager mDownloadListenerManager = null;
  protected final ArrayList<IDownloadManagerListener> mListeners = new ArrayList();
  
  public static DownloadListenerManager getInstance()
  {
    if (mDownloadListenerManager == null) {
      mDownloadListenerManager = new DownloadListenerManager();
    }
    return mDownloadListenerManager;
  }
  
  public void Add(IDownloadManagerListener paramIDownloadManagerListener)
  {
    try
    {
      if (!this.mListeners.contains(paramIDownloadManagerListener)) {
        this.mListeners.add(paramIDownloadManagerListener);
      }
      return;
    }
    finally
    {
      paramIDownloadManagerListener = finally;
      throw paramIDownloadManagerListener;
    }
  }
  
  public void OnDownloadProgressChanged(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((IDownloadManagerListener)localIterator.next()).OnDownloadProgressChanged(paramString, paramLong1, paramLong2);
      }
    }
    finally {}
  }
  
  public void OnDownloadStateChanged(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((IDownloadManagerListener)localIterator.next()).OnDownloadStateChanged(paramString1, paramInt1, paramInt2, paramString2, paramBoolean1, paramBoolean2);
      }
    }
    finally {}
  }
  
  public void Remove(IDownloadManagerListener paramIDownloadManagerListener)
  {
    try
    {
      this.mListeners.remove(paramIDownloadManagerListener);
      return;
    }
    finally
    {
      paramIDownloadManagerListener = finally;
      throw paramIDownloadManagerListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.DownloadListenerManager
 * JD-Core Version:    0.7.0.1
 */