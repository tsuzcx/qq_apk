package com.tencent.mm.sdk.event;

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
  
  public boolean getOrder()
  {
    return this.order;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.event.IEvent
 * JD-Core Version:    0.7.0.1
 */