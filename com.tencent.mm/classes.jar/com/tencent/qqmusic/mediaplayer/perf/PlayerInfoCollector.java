package com.tencent.qqmusic.mediaplayer.perf;

import android.net.Uri;

public abstract interface PlayerInfoCollector
{
  public abstract void putBoolean(String paramString, boolean paramBoolean);
  
  public abstract void putInt(String paramString, int paramInt);
  
  public abstract void putLong(String paramString, long paramLong);
  
  public abstract void putString(String paramString1, String paramString2);
  
  public abstract void putUri(String paramString, Uri paramUri);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.PlayerInfoCollector
 * JD-Core Version:    0.7.0.1
 */