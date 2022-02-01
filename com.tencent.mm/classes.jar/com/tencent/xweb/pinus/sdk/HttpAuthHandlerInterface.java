package com.tencent.xweb.pinus.sdk;

public abstract interface HttpAuthHandlerInterface
{
  public abstract void cancel();
  
  public abstract void proceed(String paramString1, String paramString2);
  
  public abstract boolean useHttpAuthUsernamePassword();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.sdk.HttpAuthHandlerInterface
 * JD-Core Version:    0.7.0.1
 */