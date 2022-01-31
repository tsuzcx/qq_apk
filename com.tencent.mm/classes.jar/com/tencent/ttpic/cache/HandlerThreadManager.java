package com.tencent.ttpic.cache;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HandlerThreadManager
{
  private static HandlerThreadManager instance;
  private Map<String, HandlerThread> map;
  
  static
  {
    AppMethodBeat.i(81767);
    instance = new HandlerThreadManager();
    AppMethodBeat.o(81767);
  }
  
  private HandlerThreadManager()
  {
    AppMethodBeat.i(81764);
    this.map = new ConcurrentHashMap();
    AppMethodBeat.o(81764);
  }
  
  public static HandlerThreadManager getInstance()
  {
    return instance;
  }
  
  public void destroy()
  {
    AppMethodBeat.i(81766);
    Iterator localIterator = this.map.values().iterator();
    while (localIterator.hasNext()) {
      ((HandlerThread)localIterator.next()).quit();
    }
    this.map.clear();
    AppMethodBeat.o(81766);
  }
  
  public HandlerThread getHanderThread(String paramString)
  {
    AppMethodBeat.i(81765);
    HandlerThread localHandlerThread2 = (HandlerThread)this.map.get(paramString);
    HandlerThread localHandlerThread1 = localHandlerThread2;
    if (localHandlerThread2 == null)
    {
      localHandlerThread1 = new HandlerThread(paramString);
      localHandlerThread1.start();
      this.map.put(paramString, localHandlerThread1);
    }
    AppMethodBeat.o(81765);
    return localHandlerThread1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.cache.HandlerThreadManager
 * JD-Core Version:    0.7.0.1
 */