package com.tencent.smtt.export.external.interfaces;

import android.util.Pair;
import java.util.ArrayList;
import java.util.concurrent.Executor;

public abstract interface IX5CoreNetwork
{
  public abstract String getCanonicalUrl(String paramString);
  
  public abstract String getCoreExtraMessage();
  
  public abstract UrlRequest getX5UrlRequestProvider(String paramString1, int paramInt, UrlRequest.Callback paramCallback, Executor paramExecutor, boolean paramBoolean, String paramString2, ArrayList<Pair<String, String>> paramArrayList, String paramString3, byte[] paramArrayOfByte, String paramString4, String paramString5);
  
  public abstract void resetSpdySession();
  
  public abstract void setPreConnect(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.IX5CoreNetwork
 * JD-Core Version:    0.7.0.1
 */