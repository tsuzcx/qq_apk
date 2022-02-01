package com.tencent.smtt.export.external.interfaces;

import java.nio.ByteBuffer;

public abstract class UrlRequest
{
  public abstract void cancel();
  
  public abstract void followRedirect();
  
  public abstract boolean isDone();
  
  public abstract void preconnect();
  
  public abstract void read(ByteBuffer paramByteBuffer);
  
  public abstract void start();
  
  public abstract void startWithPreConnectedRequest(String paramString);
  
  public static abstract class Builder
  {
    public static final int REQUEST_PRIORITY_HIGHEST = 4;
    public static final int REQUEST_PRIORITY_IDLE = 0;
    public static final int REQUEST_PRIORITY_LOW = 2;
    public static final int REQUEST_PRIORITY_LOWEST = 1;
    public static final int REQUEST_PRIORITY_MEDIUM = 3;
    
    public abstract Builder addHeader(String paramString1, String paramString2);
    
    public abstract UrlRequest build();
    
    public abstract Builder disableCache();
    
    public abstract Builder setDns(String paramString1, String paramString2);
    
    public abstract Builder setHttpMethod(String paramString);
    
    public abstract Builder setPriority(int paramInt);
    
    public abstract Builder setRequestBody(String paramString);
    
    public abstract Builder setRequestBodyBytes(byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.UrlRequest
 * JD-Core Version:    0.7.0.1
 */