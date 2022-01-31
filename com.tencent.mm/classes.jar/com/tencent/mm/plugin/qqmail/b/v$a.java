package com.tencent.mm.plugin.qqmail.b;

import java.util.Map;

public abstract class v$a
{
  public void onComplete() {}
  
  public abstract void onError(int paramInt, String paramString);
  
  public void onProgress(int paramInt) {}
  
  public boolean onReady()
  {
    return true;
  }
  
  public abstract void onSuccess(String paramString, Map<String, String> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.v.a
 * JD-Core Version:    0.7.0.1
 */