package com.tencent.tmediacodec.a;

public abstract interface a
{
  public abstract void onCreate(Boolean paramBoolean);
  
  public abstract void onRealRelease();
  
  public abstract void onReuseCodecAPIException(String paramString, Throwable paramThrowable);
  
  public abstract void onStarted(Boolean paramBoolean, String paramString);
  
  public abstract void onTransToKeepPool();
  
  public abstract void onTransToRunningPool();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmediacodec.a.a
 * JD-Core Version:    0.7.0.1
 */