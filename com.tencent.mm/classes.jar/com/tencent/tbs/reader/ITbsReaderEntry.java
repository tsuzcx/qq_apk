package com.tencent.tbs.reader;

import android.content.Context;
import java.util.Map;

public abstract interface ITbsReaderEntry
{
  public abstract boolean canAutoUpdate();
  
  public abstract Object createTbsReader(Context paramContext, Integer paramInteger, Object paramObject);
  
  public abstract void initRuntimeEnvironment();
  
  public abstract void initSettings(Map paramMap);
  
  public abstract boolean isSupportCurrentPlatform();
  
  public abstract boolean isSupportExt(int paramInt, String paramString);
  
  public abstract void setSdkVersionCode(int paramInt);
  
  public abstract void setSdkVersionName(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.reader.ITbsReaderEntry
 * JD-Core Version:    0.7.0.1
 */