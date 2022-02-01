package com.tencent.mmkv;

public abstract interface b
{
  public abstract void mmkvLog(c paramc, String paramString1, int paramInt, String paramString2, String paramString3);
  
  public abstract d onMMKVCRCCheckFail(String paramString);
  
  public abstract d onMMKVFileLengthError(String paramString);
  
  public abstract boolean wantLogRedirecting();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mmkv.b
 * JD-Core Version:    0.7.0.1
 */