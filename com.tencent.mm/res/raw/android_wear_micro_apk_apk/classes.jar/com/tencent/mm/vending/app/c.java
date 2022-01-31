package com.tencent.mm.vending.app;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseIntArray;
import com.tencent.mm.vending.h.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  private static c YM = new c();
  private Map<d, a> YN = new ConcurrentHashMap();
  private final SparseIntArray YO = new SparseIntArray();
  private final Handler YP = new Handler(b.lJ().getLooper())
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
        locala.lt();
        return;
      }
      locala.onDestroy();
    }
  };
  
  public static c lv()
  {
    return YM;
  }
  
  public final void a(d paramd, int paramInt)
  {
    a locala = (a)this.YN.get(paramd);
    if (locala != null) {
      switch (paramInt)
      {
      default: 
        paramd.hashCode();
        Looper.myLooper();
        return;
      case 1: 
        paramd.hashCode();
        Looper.myLooper();
      }
    }
    for (;;)
    {
      this.YP.sendMessage(this.YP.obtainMessage(paramInt, locala));
      this.YO.put(paramd.hashCode(), paramInt);
      return;
      paramd.hashCode();
      Looper.myLooper();
      this.YN.remove(paramd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.app.c
 * JD-Core Version:    0.7.0.1
 */