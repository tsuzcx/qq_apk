package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b;
import com.tencent.mm.sdk.g.a;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ak
  implements am.a
{
  private static final String TAG = "MicroMsg.MMHandler";
  private static b sLogCallback;
  private b handler;
  private int latestSize;
  private LinkedList<WeakReference<aq>> latestTasks;
  private ConcurrentHashMap<Runnable, WeakReference<aq>> map;
  private String toStringResult;
  
  public ak()
  {
    AppMethodBeat.i(52066);
    this.map = new ConcurrentHashMap();
    this.latestTasks = new LinkedList();
    this.toStringResult = null;
    if (Looper.myLooper() == null)
    {
      ab.w("MicroMsg.MMHandler", "[MMHandler] myLooper() == null loopTag:%s", new Object[] { a.getTag() });
      this.handler = new b(bo.bf(a.getTag(), "MicroMsg.MMHandler"), null, this);
      AppMethodBeat.o(52066);
      return;
    }
    this.handler = new b(this);
    if (getLooper().getThread().getName().equals("initThread")) {
      ab.e("MicroMsg.MMHandler", "MMHandler can not init handler with initThread looper, stack %s", new Object[] { bo.dtY() });
    }
    AppMethodBeat.o(52066);
  }
  
  public ak(Looper paramLooper)
  {
    AppMethodBeat.i(52067);
    this.map = new ConcurrentHashMap();
    this.latestTasks = new LinkedList();
    this.toStringResult = null;
    this.handler = new b(paramLooper, this);
    if (paramLooper.getThread().getName().equals("initThread")) {
      ab.e("MicroMsg.MMHandler", "MMHandler can not init handler with initThread looper, stack %s", new Object[] { bo.dtY() });
    }
    AppMethodBeat.o(52067);
  }
  
  public ak(Looper paramLooper, a parama)
  {
    AppMethodBeat.i(52069);
    this.map = new ConcurrentHashMap();
    this.latestTasks = new LinkedList();
    this.toStringResult = null;
    this.handler = new b(paramLooper, parama, this);
    if (paramLooper.getThread().getName().equals("initThread")) {
      ab.e("MicroMsg.MMHandler", "MMHandler can not init handler with initThread looper, stack %s", new Object[] { bo.dtY() });
    }
    AppMethodBeat.o(52069);
  }
  
  public ak(a parama)
  {
    AppMethodBeat.i(52068);
    this.map = new ConcurrentHashMap();
    this.latestTasks = new LinkedList();
    this.toStringResult = null;
    if (Looper.myLooper() == null)
    {
      ab.w("MicroMsg.MMHandler", "[MMHandler] myLooper() == null loopTag:%s", new Object[] { a.getTag() });
      this.handler = new b(bo.bf(a.getTag(), "MicroMsg.MMHandler"), parama, this);
      AppMethodBeat.o(52068);
      return;
    }
    this.handler = new b(parama, this);
    if (getLooper().getThread().getName().equals("initThread")) {
      ab.e("MicroMsg.MMHandler", "MMHandler can not init handler with initThread looper, stack %s", new Object[] { bo.dtY() });
    }
    AppMethodBeat.o(52068);
  }
  
  public ak(String paramString)
  {
    AppMethodBeat.i(52071);
    this.map = new ConcurrentHashMap();
    this.latestTasks = new LinkedList();
    this.toStringResult = null;
    this.handler = new b(paramString, null, this);
    AppMethodBeat.o(52071);
  }
  
  public ak(String paramString, a parama)
  {
    AppMethodBeat.i(52070);
    this.map = new ConcurrentHashMap();
    this.latestTasks = new LinkedList();
    this.toStringResult = null;
    this.handler = new b(paramString, parama, this);
    AppMethodBeat.o(52070);
  }
  
  public static String dump(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(52110);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(52110);
      return "";
    }
    if ((paramRunnable instanceof aq))
    {
      paramRunnable = ((aq)paramRunnable).dump(paramBoolean);
      AppMethodBeat.o(52110);
      return paramRunnable;
    }
    paramRunnable = paramRunnable.toString();
    AppMethodBeat.o(52110);
    return paramRunnable;
  }
  
  public static Handler fetchFreeHandler()
  {
    AppMethodBeat.i(52103);
    Handler localHandler = new Handler();
    AppMethodBeat.o(52103);
    return localHandler;
  }
  
  public static Handler fetchFreeHandler(Looper paramLooper)
  {
    AppMethodBeat.i(52104);
    paramLooper = new Handler(paramLooper);
    AppMethodBeat.o(52104);
    return paramLooper;
  }
  
  public static Handler fetchFreeHandler(Looper paramLooper, a parama)
  {
    AppMethodBeat.i(52106);
    paramLooper = new Handler(paramLooper, parama);
    AppMethodBeat.o(52106);
    return paramLooper;
  }
  
  public static Handler fetchFreeHandler(a parama)
  {
    AppMethodBeat.i(52105);
    parama = new Handler(parama);
    AppMethodBeat.o(52105);
    return parama;
  }
  
  public static void setLogCallback(b paramb)
  {
    sLogCallback = paramb;
  }
  
  public String dump(boolean paramBoolean)
  {
    AppMethodBeat.i(52109);
    Object localObject1 = new StringBuilder();
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap(this.map);
    ((StringBuilder)localObject1).append("tasks info size = " + localConcurrentHashMap.size() + '\n');
    Iterator localIterator = localConcurrentHashMap.values().iterator();
    if (localIterator != null)
    {
      int i = 0;
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if ((localObject2 != null) && (((WeakReference)localObject2).get() != null))
        {
          localObject2 = (aq)((WeakReference)localObject2).get();
          ((StringBuilder)localObject1).append("[index = " + i + " | taskinfo:" + ((aq)localObject2).dump(paramBoolean) + "]\n");
        }
        i += 1;
      }
    }
    localConcurrentHashMap.clear();
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(52109);
    return localObject1;
  }
  
  public final void dump(Printer paramPrinter, String paramString)
  {
    AppMethodBeat.i(52099);
    this.handler.a(paramPrinter, paramString);
    AppMethodBeat.o(52099);
  }
  
  public String dumpLatestTasks(boolean paramBoolean)
  {
    AppMethodBeat.i(52108);
    Object localObject1 = new StringBuilder();
    LinkedList localLinkedList = new LinkedList(this.latestTasks);
    ((StringBuilder)localObject1).append("|MMHandler latest(" + localLinkedList.size() + ") tasks done info");
    Iterator localIterator = localLinkedList.iterator();
    if (localIterator != null)
    {
      int i = 0;
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if ((localObject2 != null) && (((WeakReference)localObject2).get() != null))
        {
          localObject2 = (aq)((WeakReference)localObject2).get();
          ((StringBuilder)localObject1).append("[index = " + i + "|task=" + ((aq)localObject2).dump(paramBoolean) + "]");
        }
        i += 1;
      }
    }
    localLinkedList.clear();
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(52108);
    return localObject1;
  }
  
  public Runnable findTaskByName(String paramString)
  {
    AppMethodBeat.i(52112);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(52112);
      return null;
    }
    Iterator localIterator = new ConcurrentHashMap(this.map).values().iterator();
    if (localIterator != null) {
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        if ((localObject != null) && (((WeakReference)localObject).get() != null))
        {
          localObject = (aq)((WeakReference)localObject).get();
          if (((aq)localObject).eMp.equals(paramString))
          {
            ab.i("MicroMsg.MMHandler", "findTaskByName: %s, found task info: %s", new Object[] { paramString, ((aq)localObject).dump(true) });
            AppMethodBeat.o(52112);
            return localObject;
          }
        }
      }
    }
    ab.i("MicroMsg.MMHandler", "findTaskByName: %s, not found!", new Object[] { paramString });
    AppMethodBeat.o(52112);
    return null;
  }
  
  public Runnable findTaskByRunTime(long paramLong)
  {
    AppMethodBeat.i(52111);
    Iterator localIterator = new ConcurrentHashMap(this.map).values().iterator();
    long l = System.currentTimeMillis();
    while ((localIterator != null) && (localIterator.hasNext()))
    {
      Object localObject = (WeakReference)localIterator.next();
      if ((localObject != null) && (((WeakReference)localObject).get() != null))
      {
        localObject = (aq)((WeakReference)localObject).get();
        if ((((aq)localObject).started) && (((aq)localObject).fpw >= ((aq)localObject).cgd) && (l - ((aq)localObject).fpw > paramLong))
        {
          ab.i("MicroMsg.MMHandler", "findTaskByRunTime limit: %d, found task info: %s", new Object[] { Long.valueOf(paramLong), ((aq)localObject).dump(true) });
          AppMethodBeat.o(52111);
          return localObject;
        }
      }
    }
    ab.i("MicroMsg.MMHandler", "findTaskByRunTime limit: %d, not found!", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(52111);
    return null;
  }
  
  public String getLoopTag()
  {
    return this.handler.yma;
  }
  
  public final Looper getLooper()
  {
    AppMethodBeat.i(52098);
    Looper localLooper = this.handler.dsa();
    AppMethodBeat.o(52098);
    return localLooper;
  }
  
  @TargetApi(14)
  public String getMessageName(Message paramMessage)
  {
    AppMethodBeat.i(52072);
    if (Build.VERSION.SDK_INT < 14)
    {
      if (paramMessage.getCallback() != null)
      {
        paramMessage = paramMessage.getCallback().getClass().getName();
        AppMethodBeat.o(52072);
        return paramMessage;
      }
      paramMessage = "0x" + Integer.toHexString(paramMessage.what);
      AppMethodBeat.o(52072);
      return paramMessage;
    }
    paramMessage = this.handler.getMessageName(paramMessage);
    AppMethodBeat.o(52072);
    return paramMessage;
  }
  
  public void handleMessage(Message paramMessage) {}
  
  public final boolean hasMessages(int paramInt)
  {
    AppMethodBeat.i(52096);
    boolean bool = this.handler.MZ(paramInt);
    AppMethodBeat.o(52096);
    return bool;
  }
  
  public final boolean hasMessages(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(52097);
    boolean bool = this.handler.r(paramInt, paramObject);
    AppMethodBeat.o(52097);
    return bool;
  }
  
  public final Message obtainMessage()
  {
    AppMethodBeat.i(52073);
    Message localMessage = this.handler.obtainMessage();
    AppMethodBeat.o(52073);
    return localMessage;
  }
  
  public final Message obtainMessage(int paramInt)
  {
    AppMethodBeat.i(52074);
    Message localMessage = this.handler.obtainMessage(paramInt);
    AppMethodBeat.o(52074);
    return localMessage;
  }
  
  public final Message obtainMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(52076);
    Message localMessage = this.handler.obtainMessage(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(52076);
    return localMessage;
  }
  
  public final Message obtainMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(52077);
    paramObject = this.handler.obtainMessage(paramInt1, paramInt2, paramInt3, paramObject);
    AppMethodBeat.o(52077);
    return paramObject;
  }
  
  public final Message obtainMessage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(52075);
    paramObject = this.handler.obtainMessage(paramInt, paramObject);
    AppMethodBeat.o(52075);
    return paramObject;
  }
  
  public void onLog(Message paramMessage, Runnable paramRunnable, Thread paramThread, long paramLong1, long paramLong2, long paramLong3, float paramFloat)
  {
    AppMethodBeat.i(52107);
    if (sLogCallback != null) {
      sLogCallback.a(paramMessage, paramRunnable, paramThread, paramLong1, paramLong2, paramFloat);
    }
    AppMethodBeat.o(52107);
  }
  
  public void onTaskAdded(Runnable paramRunnable, aq paramaq)
  {
    AppMethodBeat.i(52101);
    this.map.put(paramRunnable, new WeakReference(paramaq));
    AppMethodBeat.o(52101);
  }
  
  public void onTaskRunEnd(Runnable paramRunnable, aq paramaq)
  {
    AppMethodBeat.i(52102);
    WeakReference localWeakReference = (WeakReference)this.map.get(paramRunnable);
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() == paramaq))
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
    AppMethodBeat.o(52102);
  }
  
  public final boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(52078);
    boolean bool = this.handler.post(paramRunnable);
    AppMethodBeat.o(52078);
    return bool;
  }
  
  public final boolean postAtFrontOfQueue(Runnable paramRunnable)
  {
    AppMethodBeat.i(52082);
    boolean bool = this.handler.postAtFrontOfQueue(paramRunnable);
    AppMethodBeat.o(52082);
    return bool;
  }
  
  public final boolean postAtFrontOfQueueV2(Runnable paramRunnable)
  {
    AppMethodBeat.i(52083);
    paramRunnable = Message.obtain(this.handler, paramRunnable);
    boolean bool = this.handler.sendMessageAtTime(paramRunnable, 0L);
    AppMethodBeat.o(52083);
    return bool;
  }
  
  public final boolean postAtTime(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(52079);
    boolean bool = this.handler.postAtTime(paramRunnable, paramLong);
    AppMethodBeat.o(52079);
    return bool;
  }
  
  public final boolean postAtTime(Runnable paramRunnable, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(52080);
    boolean bool = this.handler.postAtTime(paramRunnable, paramObject, paramLong);
    AppMethodBeat.o(52080);
    return bool;
  }
  
  public final boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(52081);
    boolean bool = this.handler.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(52081);
    return bool;
  }
  
  public final void removeCallbacks(Runnable paramRunnable)
  {
    AppMethodBeat.i(52084);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(52084);
      return;
    }
    if (this.handler.drZ())
    {
      this.handler.ab(paramRunnable);
      AppMethodBeat.o(52084);
      return;
    }
    WeakReference localWeakReference = (WeakReference)this.map.get(paramRunnable);
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      this.handler.ab((Runnable)localWeakReference.get());
    }
    this.map.remove(paramRunnable);
    AppMethodBeat.o(52084);
  }
  
  public final void removeCallbacks(Runnable paramRunnable, Object paramObject)
  {
    AppMethodBeat.i(52085);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(52085);
      return;
    }
    if (this.handler.drZ())
    {
      this.handler.ab(paramRunnable);
      AppMethodBeat.o(52085);
      return;
    }
    WeakReference localWeakReference = (WeakReference)this.map.get(paramRunnable);
    if ((localWeakReference != null) && (localWeakReference.get() != null) && ((paramObject == null) || (((aq)localWeakReference.get()).yme == paramObject))) {
      this.handler.b((Runnable)localWeakReference.get(), paramObject);
    }
    this.map.remove(paramRunnable);
    AppMethodBeat.o(52085);
  }
  
  public final void removeCallbacksAndMessages(Object paramObject)
  {
    AppMethodBeat.i(52095);
    this.handler.cs(paramObject);
    if (paramObject == null)
    {
      this.map.clear();
      AppMethodBeat.o(52095);
      return;
    }
    Iterator localIterator = this.map.entrySet().iterator();
    if (localIterator != null) {
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        if (localObject != null)
        {
          localObject = (WeakReference)((Map.Entry)localObject).getValue();
          if ((localObject != null) && (((WeakReference)localObject).get() != null) && (((aq)((WeakReference)localObject).get()).yme == paramObject)) {
            localIterator.remove();
          }
        }
      }
    }
    AppMethodBeat.o(52095);
  }
  
  public final void removeMessages(int paramInt)
  {
    AppMethodBeat.i(52093);
    this.handler.MY(paramInt);
    AppMethodBeat.o(52093);
  }
  
  public final void removeMessages(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(52094);
    this.handler.q(paramInt, paramObject);
    AppMethodBeat.o(52094);
  }
  
  public final boolean sendEmptyMessage(int paramInt)
  {
    AppMethodBeat.i(52087);
    boolean bool = this.handler.sendEmptyMessage(paramInt);
    AppMethodBeat.o(52087);
    return bool;
  }
  
  public final boolean sendEmptyMessageAtTime(int paramInt, long paramLong)
  {
    AppMethodBeat.i(52089);
    boolean bool = this.handler.sendEmptyMessageAtTime(paramInt, paramLong);
    AppMethodBeat.o(52089);
    return bool;
  }
  
  public final boolean sendEmptyMessageDelayed(int paramInt, long paramLong)
  {
    AppMethodBeat.i(52088);
    boolean bool = this.handler.sendEmptyMessageDelayed(paramInt, paramLong);
    AppMethodBeat.o(52088);
    return bool;
  }
  
  public final boolean sendMessage(Message paramMessage)
  {
    AppMethodBeat.i(52086);
    boolean bool = this.handler.sendMessage(paramMessage);
    AppMethodBeat.o(52086);
    return bool;
  }
  
  public final boolean sendMessageAtFrontOfQueue(Message paramMessage)
  {
    AppMethodBeat.i(52092);
    boolean bool = this.handler.sendMessageAtFrontOfQueue(paramMessage);
    AppMethodBeat.o(52092);
    return bool;
  }
  
  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    AppMethodBeat.i(52091);
    boolean bool = this.handler.sendMessageAtTime(paramMessage, paramLong);
    AppMethodBeat.o(52091);
    return bool;
  }
  
  public final boolean sendMessageDelayed(Message paramMessage, long paramLong)
  {
    AppMethodBeat.i(52090);
    boolean bool = this.handler.sendMessageDelayed(paramMessage, paramLong);
    AppMethodBeat.o(52090);
    return bool;
  }
  
  public void setLatestSize(int paramInt)
  {
    this.latestSize = paramInt;
  }
  
  public String toString()
  {
    AppMethodBeat.i(52100);
    if (this.toStringResult == null) {
      this.toStringResult = ("MMHandler(" + getClass().getName() + ")");
    }
    String str = this.toStringResult;
    AppMethodBeat.o(52100);
    return str;
  }
  
  public static abstract interface a
    extends Handler.Callback
  {}
  
  public static abstract interface b
  {
    public abstract void a(Message paramMessage, Runnable paramRunnable, Thread paramThread, long paramLong1, long paramLong2, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ak
 * JD-Core Version:    0.7.0.1
 */