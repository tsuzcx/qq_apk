package com.tencent.smtt.export.external.easel.interfaces;

public abstract interface ILoader
{
  public abstract void cancel();
  
  public abstract void load(String paramString1, String paramString2);
  
  public abstract void setDelegate(Delegate paramDelegate);
  
  public static abstract interface Delegate
  {
    public abstract void didFail();
    
    public abstract void didFinishLoading();
    
    public abstract void didReceiveData(byte[] paramArrayOfByte, int paramInt);
    
    public abstract void didReceiveResponse(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.export.external.easel.interfaces.ILoader
 * JD-Core Version:    0.7.0.1
 */