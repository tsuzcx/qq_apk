package com.tencent.mm.vending.app;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseIntArray;
import com.tencent.mm.vending.i.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  private static c acm = new c();
  private Map<d, a> acn = new ConcurrentHashMap();
  private final SparseIntArray aco = new SparseIntArray();
  private final Handler acp = new Handler(b.mw().getLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      a locala = (a)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      case 2: 
      case 3: 
      default: 
        return;
      case 1: 
        locala.onCreate();
        locala.ma();
        return;
      }
      locala.onDestroy();
    }
  };
  
  public static c mc()
  {
    return acm;
  }
  
  public final void a(d paramd, int paramInt)
  {
    a locala = (a)this.acn.get(paramd);
    if (locala != null) {
      switch (paramInt)
      {
      default: 
        paramd.hashCode();
        Looper.myLooper();
        com.tencent.mm.vending.f.a.mq();
        return;
      case 1: 
        paramd.hashCode();
        Looper.myLooper();
        com.tencent.mm.vending.f.a.mq();
      }
    }
    for (;;)
    {
      this.acp.sendMessage(this.acp.obtainMessage(paramInt, locala));
      this.aco.put(paramd.hashCode(), paramInt);
      return;
      paramd.hashCode();
      Looper.myLooper();
      com.tencent.mm.vending.f.a.mq();
      this.acn.remove(paramd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.app.c
 * JD-Core Version:    0.7.0.1
 */