package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ah
  implements aj.a
{
  private static final String TAG = "MicroMsg.MMHandler";
  private static b sLogCallback;
  private aj handler;
  private int latestSize;
  private LinkedList<WeakReference<ao>> latestTasks = new LinkedList();
  private ConcurrentHashMap<Runnable, WeakReference<ao>> map = new ConcurrentHashMap();
  private String toStringResult = null;
  
  public ah()
  {
    this.handler = new aj(this);
    if (getLooper().getThread().getName().equals("initThread")) {
      y.e("MicroMsg.MMHandler", "MMHandler can not init handler with initThread looper, stack %s", new Object[] { bk.csb() });
    }
  }
  
  public ah(Looper paramLooper)
  {
    this.handler = new aj(paramLooper, this);
    if (paramLooper.getThread().getName().equals("initThread")) {
      y.e("MicroMsg.MMHandler", "MMHandler can not init handler with initThread looper, stack %s", new Object[] { bk.csb() });
    }
  }
  
  public ah(Looper paramLooper, a parama)
  {
    this.handler = new aj(paramLooper, parama, this);
    if (paramLooper.getThread().getName().equals("initThread")) {
      y.e("MicroMsg.MMHandler", "MMHandler can not init handler with initThread looper, stack %s", new Object[] { bk.csb() });
    }
  }
  
  public ah(a parama)
  {
    this.handler = new aj(parama, this);
    if (getLooper().getThread().getName().equals("initThread")) {
      y.e("MicroMsg.MMHandler", "MMHandler can not init handler with initThread looper, stack %s", new Object[] { bk.csb() });
    }
  }
  
  public static String dump(Runnable paramRunnable, boolean paramBoolean)
  {
    if (paramRunnable == null) {
      return "";
    }
    if ((paramRunnable instanceof ao)) {
      return ((ao)paramRunnable).dump(paramBoolean);
    }
    return paramRunnable.toString();
  }
  
  public static Handler fetchFreeHandler()
  {
    return new Handler();
  }
  
  public static Handler fetchFreeHandler(Looper paramLooper)
  {
    return new Handler(paramLooper);
  }
  
  public static Handler fetchFreeHandler(Looper paramLooper, a parama)
  {
    return new Handler(paramLooper, parama);
  }
  
  public static Handler fetchFreeHandler(a parama)
  {
    return new Handler(parama);
  }
  
  public static void setLogCallback(b paramb)
  {
    sLogCallback = paramb;
  }
  
  public String dump(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap(this.map);
    localStringBuilder.append("tasks info size = " + localConcurrentHashMap.size() + '\n');
    Iterator localIterator = localConcurrentHashMap.values().iterator();
    if (localIterator != null)
    {
      int i = 0;
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        if ((localObject != null) && (((WeakReference)localObject).get() != null))
        {
          localObject = (ao)((WeakReference)localObject).get();
          localStringBuilder.append("[index = " + i + " | taskinfo:" + ((ao)localObject).dump(paramBoolean) + "]\n");
        }
        i += 1;
      }
    }
    localConcurrentHashMap.clear();
    return localStringBuilder.toString();
  }
  
  public final void dump(Printer paramPrinter, String paramString)
  {
    this.handler.dump(paramPrinter, paramString);
  }
  
  public String dumpLatestTasks(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    LinkedList localLinkedList = new LinkedList(this.latestTasks);
    localStringBuilder.append("|MMHandler latest(" + localLinkedList.size() + ") tasks done info");
    Iterator localIterator = localLinkedList.iterator();
    if (localIterator != null)
    {
      int i = 0;
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        if ((localObject != null) && (((WeakReference)localObject).get() != null))
        {
          localObject = (ao)((WeakReference)localObject).get();
          localStringBuilder.append("[index = " + i + "|task=" + ((ao)localObject).dump(paramBoolean) + "]");
        }
        i += 1;
      }
    }
    localLinkedList.clear();
    return localStringBuilder.toString();
  }
  
  public Runnable findTaskByName(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    Iterator localIterator = new ConcurrentHashMap(this.map).values().iterator();
    if (localIterator != null) {
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        if ((localObject != null) && (((WeakReference)localObject).get() != null))
        {
          localObject = (ao)((WeakReference)localObject).get();
          if (((ao)localObject).ugn.equals(paramString))
          {
            y.i("MicroMsg.MMHandler", "findTaskByName: %s, found task info: %s", new Object[] { paramString, ((ao)localObject).dump(true) });
            return localObject;
          }
        }
      }
    }
    y.i("MicroMsg.MMHandler", "findTaskByName: %s, not found!", new Object[] { paramString });
    return null;
  }
  
  public Runnable findTaskByRunTime(long paramLong)
  {
    Iterator localIterator = new ConcurrentHashMap(this.map).values().iterator();
    long l = System.currentTimeMillis();
    while ((localIterator != null) && (localIterator.hasNext()))
    {
      Object localObject = (WeakReference)localIterator.next();
      if ((localObject != null) && (((WeakReference)localObject).get() != null))
      {
        localObject = (ao)((WeakReference)localObject).get();
        if ((((ao)localObject).started) && (((ao)localObject).dZr >= ((ao)localObject).ugr) && (l - ((ao)localObject).dZr > paramLong))
        {
          y.i("MicroMsg.MMHandler", "findTaskByRunTime limit: %d, found task info: %s", new Object[] { Long.valueOf(paramLong), ((ao)localObject).dump(true) });
          return localObject;
        }
      }
    }
    y.i("MicroMsg.MMHandler", "findTaskByRunTime limit: %d, not found!", new Object[] { Long.valueOf(paramLong) });
    return null;
  }
  
  public final Looper getLooper()
  {
    return this.handler.getLooper();
  }
  
  @TargetApi(14)
  public String getMessageName(Message paramMessage)
  {
    if (Build.VERSION.SDK_INT < 14)
    {
      if (paramMessage.getCallback() != null) {
        return paramMessage.getCallback().getClass().getName();
      }
      return "0x" + Integer.toHexString(paramMessage.what);
    }
    return this.handler.getMessageName(paramMessage);
  }
  
  public void handleMessage(Message paramMessage) {}
  
  public final boolean hasMessages(int paramInt)
  {
    return this.handler.hasMessages(paramInt);
  }
  
  public final boolean hasMessages(int paramInt, Object paramObject)
  {
    return this.handler.hasMessages(paramInt, paramObject);
  }
  
  public final Message obtainMessage()
  {
    return this.handler.obtainMessage();
  }
  
  public final Message obtainMessage(int paramInt)
  {
    return this.handler.obtainMessage(paramInt);
  }
  
  public final Message obtainMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.handler.obtainMessage(paramInt1, paramInt2, paramInt3);
  }
  
  public final Message obtainMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    return this.handler.obtainMessage(paramInt1, paramInt2, paramInt3, paramObject);
  }
  
  public final Message obtainMessage(int paramInt, Object paramObject)
  {
    return this.handler.obtainMessage(paramInt, paramObject);
  }
  
  public void onLog(Message paramMessage, Runnable paramRunnable, Thread paramThread, long paramLong1, long paramLong2, float paramFloat)
  {
    if (sLogCallback != null) {
      sLogCallback.onLog(paramMessage, paramRunnable, paramThread, paramLong1, paramLong2, paramFloat);
    }
  }
  
  public final void onTaskAdded(Runnable paramRunnable, ao paramao)
  {
    this.map.put(paramRunnable, new WeakReference(paramao));
  }
  
  public final void onTaskRunEnd(Runnable paramRunnable, ao paramao)
  {
    WeakReference localWeakReference = (WeakReference)this.map.get(paramRunnable);
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() == paramao))
    {
      this.map.remove(paramRunnable);
      if (this.latestSize > 0)
      {
        if (this.latestTasks.size() == this.latestSize) {
          this.latestTasks.pop();
        }
        this.latestTasks.add(localWeakReference);
      }
    }
  }
  
  public final boolean post(Runnable paramRunnable)
  {
    return this.handler.post(paramRunnable);
  }
  
  public final boolean postAtFrontOfQueue(Runnable paramRunnable)
  {
    return this.handler.postAtFrontOfQueue(paramRunnable);
  }
  
  public final boolean postAtFrontOfQueueV2(Runnable paramRunnable)
  {
    paramRunnable = Message.obtain(this.handler, paramRunnable);
    return this.handler.sendMessageAtTime(paramRunnable, 0L);
  }
  
  public final boolean postAtTime(Runnable paramRunnable, long paramLong)
  {
    return this.handler.postAtTime(paramRunnable, paramLong);
  }
  
  public final boolean postAtTime(Runnable paramRunnable, Object paramObject, long paramLong)
  {
    return this.handler.postAtTime(paramRunnable, paramObject, paramLong);
  }
  
  public final boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    return this.handler.postDelayed(paramRunnable, paramLong);
  }
  
  public final void removeCallbacks(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    WeakReference localWeakReference = (WeakReference)this.map.get(paramRunnable);
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      this.handler.removeCallbacks((Runnable)localWeakReference.get());
    }
    this.map.remove(paramRunnable);
  }
  
  public final void removeCallbacks(Runnable paramRunnable, Object paramObject)
  {
    if (paramRunnable == null) {
      return;
    }
    WeakReference localWeakReference = (WeakReference)this.map.get(paramRunnable);
    if ((localWeakReference != null) && (localWeakReference.get() != null) && ((paramObject == null) || (((ao)localWeakReference.get()).ugo == paramObject))) {
      this.handler.removeCallbacks((Runnable)localWeakReference.get(), paramObject);
    }
    this.map.remove(paramRunnable);
  }
  
  public final void removeCallbacksAndMessages(Object paramObject)
  {
    this.handler.removeCallbacksAndMessages(paramObject);
    if (paramObject == null) {
      this.map.clear();
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.map.entrySet().iterator();
      if (localIterator != null) {
        while (localIterator.hasNext())
        {
          Object localObject = (Map.Entry)localIterator.next();
          if (localObject != null)
          {
            localObject = (WeakReference)((Map.Entry)localObject).getValue();
            if ((localObject != null) && (((WeakReference)localObject).get() != null) && (((ao)((WeakReference)localObject).get()).ugo == paramObject)) {
              localIterator.remove();
            }
          }
        }
      }
    }
  }
  
  public final void removeMessages(int paramInt)
  {
    this.handler.removeMessages(paramInt);
  }
  
  public final void removeMessages(int paramInt, Object paramObject)
  {
    this.handler.removeMessages(paramInt, paramObject);
  }
  
  public final boolean sendEmptyMessage(int paramInt)
  {
    return this.handler.sendEmptyMessage(paramInt);
  }
  
  public final boolean sendEmptyMessageAtTime(int paramInt, long paramLong)
  {
    return this.handler.sendEmptyMessageAtTime(paramInt, paramLong);
  }
  
  public final boolean sendEmptyMessageDelayed(int paramInt, long paramLong)
  {
    return this.handler.sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  public final boolean sendMessage(Message paramMessage)
  {
    return this.handler.sendMessage(paramMessage);
  }
  
  public final boolean sendMessageAtFrontOfQueue(Message paramMessage)
  {
    return this.handler.sendMessageAtFrontOfQueue(paramMessage);
  }
  
  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    return this.handler.sendMessageAtTime(paramMessage, paramLong);
  }
  
  public final boolean sendMessageDelayed(Message paramMessage, long paramLong)
  {
    return this.handler.sendMessageDelayed(paramMessage, paramLong);
  }
  
  public void setLatestSize(int paramInt)
  {
    this.latestSize = paramInt;
  }
  
  public String toString()
  {
    if (this.toStringResult == null) {
      this.toStringResult = ("MMHandler(" + getClass().getName() + ")");
    }
    return this.toStringResult;
  }
  
  public static abstract interface a
    extends Handler.Callback
  {}
  
  public static abstract interface b
  {
    public abstract void onLog(Message paramMessage, Runnable paramRunnable, Thread paramThread, long paramLong1, long paramLong2, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ah
 * JD-Core Version:    0.7.0.1
 */