package com.tencent.mm.plugin.qqmail;

import java.util.Map;

public abstract class c$a
{
  public void onComplete() {}
  
  public abstract void onError(int paramInt, String paramString);
  
  public boolean onReady()
  {
    return true;
  }
  
  public abstract void onSuccess(String paramString, Map<String, String> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.c.a
 * JD-Core Version:    0.7.0.1
 */