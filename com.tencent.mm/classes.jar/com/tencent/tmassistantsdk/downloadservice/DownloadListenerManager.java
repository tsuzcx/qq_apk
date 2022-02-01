package com.tencent.tmassistantsdk.downloadservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public class DownloadListenerManager
{
  protected static DownloadListenerManager mDownloadListenerManager = null;
  protected final ArrayList<IDownloadManagerListener> mListeners;
  
  protected DownloadListenerManager()
  {
    AppMethodBeat.i(101975);
    this.mListeners = new ArrayList();
    AppMethodBeat.o(101975);
  }
  
  public static DownloadListenerManager getInstance()
  {
    AppMethodBeat.i(101974);
    if (mDownloadListenerManager == null) {
      mDownloadListenerManager = new DownloadListenerManager();
    }
    DownloadListenerManager localDownloadListenerManager = mDownloadListenerManager;
    AppMethodBeat.o(101974);
    return localDownloadListenerManager;
  }
  
  public void Add(IDownloadManagerListener paramIDownloadManagerListener)
  {
    try
    {
      AppMethodBeat.i(101976);
      if (!this.mListeners.contains(paramIDownloadManagerListener)) {
        this.mListeners.add(paramIDownloadManagerListener);
      }
      AppMethodBeat.o(101976);
      return;
    }
    finally {}
  }
  
  public void OnDownloadProgressChanged(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      AppMethodBeat.i(101979);
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((IDownloadManagerListener)localIterator.next()).OnDownloadProgressChanged(paramString, paramLong1, paramLong2);
      }
      AppMethodBeat.o(101979);
    }
    finally {}
  }
  
  public void OnDownloadStateChanged(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      AppMethodBeat.i(101978);
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((IDownloadManagerListener)localIterator.next()).OnDownloadStateChanged(paramString1, paramInt1, paramInt2, paramString2, paramBoolean1, paramBoolean2);
      }
      AppMethodBeat.o(101978);
    }
    finally {}
  }
  
  public void Remove(IDownloadManagerListener paramIDownloadManagerListener)
  {
    try
    {
      AppMethodBeat.i(101977);
      this.mListeners.remove(paramIDownloadManagerListener);
      AppMethodBeat.o(101977);
      return;
    }
    finally
    {
      paramIDownloadManagerListener = finally;
      throw paramIDownloadManagerListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.DownloadListenerManager
 * JD-Core Version:    0.7.0.1
 */