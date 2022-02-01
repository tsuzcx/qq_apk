package com.tencent.tav.asset;

import java.util.List;

public abstract interface AsynchronousKeyValueLoading
{
  public abstract void loadValuesAsynchronouslyForKeys(List<String> paramList, loadCallback paramloadCallback);
  
  public abstract int statusOfValueForKey(String paramString);
  
  public static abstract interface loadCallback
  {
    public abstract void loadSucceeds();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.asset.AsynchronousKeyValueLoading
 * JD-Core Version:    0.7.0.1
 */