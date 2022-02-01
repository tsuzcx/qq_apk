package com.tencent.mmkv;

public abstract interface a
{
  public abstract void mmkvLog(b paramb, String paramString1, int paramInt, String paramString2, String paramString3);
  
  public abstract c onMMKVCRCCheckFail(String paramString);
  
  public abstract c onMMKVFileLengthError(String paramString);
  
  public abstract boolean wantLogRedirecting();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mmkv.a
 * JD-Core Version:    0.7.0.1
 */