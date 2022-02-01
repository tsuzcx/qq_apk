package com.tencent.mm.sdk.event;

import android.os.Looper;
import java.util.concurrent.Executor;

public abstract class IEvent
{
  private int __eventID = 0;
  public Runnable callback = null;
  protected boolean order;
  
  int __getEventID()
  {
    if (this.__eventID == 0) {
      this.__eventID = getClass().getName().hashCode();
    }
    return this.__eventID;
  }
  
  public final void asyncPublish(Looper paramLooper)
  {
    EventCenter.instance.asyncPublish(this, paramLooper);
  }
  
  public final void asyncPublish(String paramString)
  {
    EventCenter.instance.asyncPublish(this, paramString);
  }
  
  public final void asyncPublish(Executor paramExecutor)
  {
    EventCenter.instance.asyncPublish(this, paramExecutor);
  }
  
  public boolean getOrder()
  {
    return this.order;
  }
  
  public final boolean publish()
  {
    return EventCenter.instance.publish(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.event.IEvent
 * JD-Core Version:    0.7.0.1
 */