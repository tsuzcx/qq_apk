package com.tencent.thumbplayer.core.drm.httpclient;

import android.net.Uri;
import java.util.List;
import java.util.Map;

public abstract interface DataSource
{
  public abstract void addTransferListener(TransferListener paramTransferListener);
  
  public abstract void close();
  
  public abstract Map<String, List<String>> getResponseHeaders();
  
  public abstract Uri getUri();
  
  public abstract long open(DataSpec paramDataSpec);
  
  public abstract int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static abstract interface Factory
  {
    public abstract DataSource createDataSource();
    
    public abstract DataSource createDataSource(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.DataSource
 * JD-Core Version:    0.7.0.1
 */