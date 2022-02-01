package com.tencent.mm.sdk.event;

import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.b.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class IListener<T extends IEvent>
{
  protected int __eventId = 0;
  private b<IListener> mCallbackProperty;
  private final int priority;
  
  public IListener()
  {
    this(0);
  }
  
  public IListener(int paramInt)
  {
    this.priority = paramInt;
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
  
  public b<IListener> alive()
  {
    try
    {
      if (this.mCallbackProperty == null)
      {
        ListenerInstanceMonitor.markInstanceRegistered(this);
        this.mCallbackProperty = EventCenter.instance.add(this);
      }
      b localb = this.mCallbackProperty;
      return localb;
    }
    finally {}
  }
  
  public abstract boolean callback(T paramT);
  
  public void dead()
  {
    try
    {
      if (this.mCallbackProperty != null)
      {
        ListenerInstanceMonitor.markInstanceUnregistered((IListener)this.mCallbackProperty.YzW);
        this.mCallbackProperty.dead();
        this.mCallbackProperty = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  int getPriority()
  {
    return this.priority;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.event.IListener
 * JD-Core Version:    0.7.0.1
 */