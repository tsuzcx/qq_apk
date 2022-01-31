package com.tencent.tmassistantsdk.channel;

import java.util.ArrayList;

public class TMAssistantSDKChannel
{
  public long AddDataItem(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, long paramLong1, long paramLong2, int paramInt3, byte[] paramArrayOfByte)
  {
    try
    {
      paramString1 = new TMAssistantSDKChannelDataItem(paramString1, paramInt1, paramString2, paramInt2, paramString3, paramLong1, paramLong2, paramInt3, paramArrayOfByte);
      paramLong1 = new DBOption().insert(paramString1);
      return paramLong1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public boolean delDataItem(long paramLong)
  {
    boolean bool;
    if (paramLong < 0L) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        bool = new DBOption().delete(paramLong);
      }
      finally {}
    }
  }
  
  public ArrayList<TMAssistantSDKChannelDataItem> getChannelDataItemList()
  {
    try
    {
      ArrayList localArrayList = new DBOption().queryAll();
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmassistantsdk.channel.TMAssistantSDKChannel
 * JD-Core Version:    0.7.0.1
 */