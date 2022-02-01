package com.tencent.tav.asset;

import java.net.URL;
import java.util.List;

public final class URLAsset
  extends Asset
{
  public String audiovisualMIMETypes;
  public String audiovisualTypes;
  
  public URLAsset(String paramString)
  {
    super(paramString);
  }
  
  public URLAsset(URL paramURL)
  {
    super(paramURL);
  }
  
  public final String getAudiovisualMIMETypes()
  {
    return this.audiovisualMIMETypes;
  }
  
  public final String getAudiovisualTypes()
  {
    return this.audiovisualTypes;
  }
  
  public final void loadValuesAsynchronouslyForKeys(List<String> paramList, AsynchronousKeyValueLoading.loadCallback paramloadCallback) {}
  
  public final int statusOfValueForKey(String paramString)
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.asset.URLAsset
 * JD-Core Version:    0.7.0.1
 */