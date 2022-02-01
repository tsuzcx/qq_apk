package com.tencent.mm.sdk.event;

import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.b.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class IListener<T extends IEvent>
  implements p
{
  protected int __eventId = 0;
  private final q lifecycleOwner;
  private b<IListener> mCallbackProperty;
  private final int priority;
  
  public IListener(q paramq)
  {
    this(paramq, 0);
  }
  
  public IListener(q paramq, int paramInt)
  {
    this.lifecycleOwner = paramq;
    this.priority = paramInt;
  }
  
  private void internalDead()
  {
    if (this.mCallbackProperty != null)
    {
      ListenerInstanceMonitor.markInstanceUnregistered((IListener)this.mCallbackProperty.aguu);
      this.mCallbackProperty.dead();
      this.mCallbackProperty = null;
    }
  }
  
  int __getEventID()
  {
    if (this.__eventId == 0)
    {
      long l = System.currentTimeMillis();
      Type localType2 = getClass().getGenericSuperclass();
      Type localType1 = localType2;
      if (!(localType2 instanceof ParameterizedType)) {
        localType1 = getClass().getSuperclass().getGenericSuperclass();
      }
      localType1 = ((ParameterizedType)localType1).getActualTypeArguments()[0];
      this.__eventId = ((Class)localType1).getName().hashCode();
      Log.v("IListener", "genEventID, %s<%s>, useTime:%d", new Object[] { getClass().getName(), localType1, Long.valueOf(System.currentTimeMillis() - l) });
    }
    return this.__eventId;
  }
  
  /* Error */
  public void alive()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 33	com/tencent/mm/sdk/event/IListener:mCallbackProperty	Lcom/tencent/mm/vending/b/b;
    //   6: ifnonnull +18 -> 24
    //   9: aload_0
    //   10: invokestatic 104	com/tencent/mm/sdk/platformtools/ListenerInstanceMonitor:markInstanceRegistered	(Ljava/lang/Object;)V
    //   13: aload_0
    //   14: getstatic 110	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   17: aload_0
    //   18: invokevirtual 114	com/tencent/mm/sdk/event/EventCenter:add	(Lcom/tencent/mm/sdk/event/IListener;)Lcom/tencent/mm/vending/b/b;
    //   21: putfield 33	com/tencent/mm/sdk/event/IListener:mCallbackProperty	Lcom/tencent/mm/vending/b/b;
    //   24: aload_0
    //   25: getfield 28	com/tencent/mm/sdk/event/IListener:lifecycleOwner	Landroidx/lifecycle/q;
    //   28: invokeinterface 120 1 0
    //   33: instanceof 122
    //   36: ifeq +19 -> 55
    //   39: aload_0
    //   40: getfield 28	com/tencent/mm/sdk/event/IListener:lifecycleOwner	Landroidx/lifecycle/q;
    //   43: invokeinterface 120 1 0
    //   48: aload_0
    //   49: invokevirtual 128	androidx/lifecycle/j:addObserver	(Landroidx/lifecycle/p;)V
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: getstatic 134	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   58: new 136	com/tencent/mm/sdk/event/IListener$$ExternalSyntheticLambda0
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 139	com/tencent/mm/sdk/event/IListener$$ExternalSyntheticLambda0:<init>	(Lcom/tencent/mm/sdk/event/IListener;)V
    //   66: invokeinterface 145 2 0
    //   71: pop
    //   72: goto -20 -> 52
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	IListener
    //   75	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	75	finally
    //   24	52	75	finally
    //   55	72	75	finally
  }
  
  public abstract boolean callback(T paramT);
  
  /* Error */
  public void dead()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 149	com/tencent/mm/sdk/event/IListener:internalDead	()V
    //   6: aload_0
    //   7: getfield 28	com/tencent/mm/sdk/event/IListener:lifecycleOwner	Landroidx/lifecycle/q;
    //   10: invokeinterface 120 1 0
    //   15: instanceof 122
    //   18: ifeq +37 -> 55
    //   21: aload_0
    //   22: getfield 28	com/tencent/mm/sdk/event/IListener:lifecycleOwner	Landroidx/lifecycle/q;
    //   25: invokeinterface 120 1 0
    //   30: invokevirtual 153	androidx/lifecycle/j:getCurrentState	()Landroidx/lifecycle/j$b;
    //   33: getstatic 159	androidx/lifecycle/j$b:bHg	Landroidx/lifecycle/j$b;
    //   36: if_acmpeq +16 -> 52
    //   39: aload_0
    //   40: getfield 28	com/tencent/mm/sdk/event/IListener:lifecycleOwner	Landroidx/lifecycle/q;
    //   43: invokeinterface 120 1 0
    //   48: aload_0
    //   49: invokevirtual 162	androidx/lifecycle/j:removeObserver	(Landroidx/lifecycle/p;)V
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: getstatic 134	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   58: new 164	com/tencent/mm/sdk/event/IListener$$ExternalSyntheticLambda1
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 165	com/tencent/mm/sdk/event/IListener$$ExternalSyntheticLambda1:<init>	(Lcom/tencent/mm/sdk/event/IListener;)V
    //   66: invokeinterface 145 2 0
    //   71: pop
    //   72: goto -20 -> 52
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	IListener
    //   75	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	52	75	finally
    //   55	72	75	finally
  }
  
  int getPriority()
  {
    return this.priority;
  }
  
  @z(Ho=j.a.ON_DESTROY)
  public void onLifecycleDestroy()
  {
    internalDead();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.event.IListener
 * JD-Core Version:    0.7.0.1
 */