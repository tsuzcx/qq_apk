package com.tencent.mm.vending.b;

import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.f;
import com.tencent.mm.vending.h.g;
import java.util.LinkedList;
import junit.framework.Assert;

public abstract class a<_Callback>
{
  private LinkedList<b> mQueue = new LinkedList();
  protected d mScheduler;
  protected f mSchedulerInvoker;
  
  public a()
  {
    this(g.current());
  }
  
  public a(d paramd)
  {
    Assert.assertNotNull(paramd);
    this.mScheduler = paramd;
    this.mSchedulerInvoker = new f(paramd, null);
  }
  
  public a(String paramString)
  {
    this(g.bDR(paramString));
  }
  
  protected b add(b paramb)
  {
    if (paramb == null) {
      paramb = null;
    }
    for (;;)
    {
      return paramb;
      try
      {
        this.mQueue.add(paramb);
      }
      finally {}
    }
  }
  
  public boolean contains(_Callback param_Callback)
  {
    try
    {
      boolean bool = this.mQueue.contains(new b(param_Callback, this));
      return bool;
    }
    finally
    {
      param_Callback = finally;
      throw param_Callback;
    }
  }
  
  public LinkedList<b> getQueue()
  {
    try
    {
      LinkedList localLinkedList = getQueueImpl();
      return localLinkedList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected LinkedList<b> getQueueImpl()
  {
    return new LinkedList(this.mQueue);
  }
  
  protected void remove(b paramb)
  {
    if (paramb == null) {}
    for (;;)
    {
      return;
      try
      {
        this.mQueue.remove(paramb);
      }
      finally {}
    }
  }
  
  public int size()
  {
    try
    {
      int i = this.mQueue.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vending.b.a
 * JD-Core Version:    0.7.0.1
 */