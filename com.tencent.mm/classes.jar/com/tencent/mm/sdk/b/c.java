package com.tencent.mm.sdk.b;

import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class c<T extends b>
{
  protected int __eventId = 0;
  private com.tencent.mm.vending.b.b<c> mCallbackProperty;
  private final int priority;
  
  public c()
  {
    this(0);
  }
  
  public c(int paramInt)
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
      ab.v("IListener", "genEventID, %s<%s>, useTime:%d", new Object[] { getClass().getName(), localType1, Long.valueOf(System.currentTimeMillis() - l) });
    }
    return this.__eventId;
  }
  
  public com.tencent.mm.vending.b.b<c> alive()
  {
    try
    {
      if (this.mCallbackProperty == null)
      {
        ListenerInstanceMonitor.ct(this);
        this.mCallbackProperty = a.ymk.b(this);
      }
      com.tencent.mm.vending.b.b localb = this.mCallbackProperty;
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
        ListenerInstanceMonitor.cu((c)this.mCallbackProperty.d);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.c
 * JD-Core Version:    0.7.0.1
 */