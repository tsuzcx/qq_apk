package com.tencent.mm.vending.app;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.SparseIntArray;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static b wsT = new b();
  Map<c, a> b = new ConcurrentHashMap();
  final Handler d = new Handler(com.tencent.mm.vending.i.b.cLg().a.getLooper())
  {
    public final void handleMessage(Message arg1)
    {
      a locala = (a)???.obj;
      switch (???.what)
      {
      case 2: 
      case 3: 
      default: 
        return;
      case 1: 
        locala.onCreate();
        synchronized (locala.d)
        {
          locala.g = true;
          locala.d.notify();
          return;
        }
      }
      localObject.onDestroy();
    }
  };
  final SparseIntArray wsU = new SparseIntArray();
  
  public static b cKP()
  {
    return wsT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vending.app.b
 * JD-Core Version:    0.7.0.1
 */