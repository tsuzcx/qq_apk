package com.tencent.ttpic.cache;

import android.os.HandlerThread;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HandlerThreadManager
{
  private static HandlerThreadManager instance = new HandlerThreadManager();
  private Map<String, HandlerThread> map = new ConcurrentHashMap();
  
  public static HandlerThreadManager getInstance()
  {
    return instance;
  }
  
  public void destroy()
  {
    Iterator localIterator = this.map.values().iterator();
    while (localIterator.hasNext()) {
      ((HandlerThread)localIterator.next()).quit();
    }
    this.map.clear();
  }
  
  public HandlerThread getHanderThread(String paramString)
  {
    HandlerThread localHandlerThread2 = (HandlerThread)this.map.get(paramString);
    HandlerThread localHandlerThread1 = localHandlerThread2;
    if (localHandlerThread2 == null)
    {
      localHandlerThread1 = new HandlerThread(paramString);
      localHandlerThread1.start();
      this.map.put(paramString, localHandlerThread1);
    }
    return localHandlerThread1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.cache.HandlerThreadManager
 * JD-Core Version:    0.7.0.1
 */