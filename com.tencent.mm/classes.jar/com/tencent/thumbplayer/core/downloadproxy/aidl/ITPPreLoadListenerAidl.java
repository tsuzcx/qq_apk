package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.IInterface;

public abstract interface ITPPreLoadListenerAidl
  extends IInterface
{
  public abstract void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString);
  
  public abstract void onPrepareError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onPrepareOK();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl
 * JD-Core Version:    0.7.0.1
 */