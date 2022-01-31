package com.tencent.mm.sdk.b;

import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class c<T extends b>
{
  final int priority;
  public int udX = 0;
  private com.tencent.mm.vending.b.b<c> udY;
  
  public c()
  {
    this(0);
  }
  
  public c(int paramInt)
  {
    this.priority = paramInt;
  }
  
  public abstract boolean a(T paramT);
  
  final int cqn()
  {
    if (this.udX == 0)
    {
      long l = System.currentTimeMillis();
      Type localType2 = getClass().getGenericSuperclass();
      Type localType1 = localType2;
      if (!(localType2 instanceof ParameterizedType)) {
        localType1 = getClass().getSuperclass().getGenericSuperclass();
      }
      localType1 = ((ParameterizedType)localType1).getActualTypeArguments()[0];
      this.udX = ((Class)localType1).getName().hashCode();
      y.v("IListener", "genEventID, %s<%s>, useTime:%d", new Object[] { getClass().getName(), localType1, Long.valueOf(System.currentTimeMillis() - l) });
    }
    return this.udX;
  }
  
  public final com.tencent.mm.vending.b.b<c> cqo()
  {
    try
    {
      if (this.udY == null)
      {
        ListenerInstanceMonitor.bP(this);
        this.udY = a.udP.b(this);
      }
      com.tencent.mm.vending.b.b localb = this.udY;
      return localb;
    }
    finally {}
  }
  
  public final void dead()
  {
    try
    {
      if (this.udY != null)
      {
        ListenerInstanceMonitor.bQ((c)this.udY.d);
        this.udY.dead();
        this.udY = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.c
 * JD-Core Version:    0.7.0.1
 */