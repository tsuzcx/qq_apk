package com.tencent.mm.vending.b;

import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.f;
import com.tencent.mm.vending.h.g;
import java.util.LinkedList;
import junit.framework.Assert;

public abstract class a<_Callback>
{
  private LinkedList<b> Jqd = new LinkedList();
  protected f Jqe;
  protected d cII;
  
  public a()
  {
    this(g.fxu());
  }
  
  public a(d paramd)
  {
    Assert.assertNotNull(paramd);
    this.cII = paramd;
    this.Jqe = new f(paramd, null);
  }
  
  protected final b a(b paramb)
  {
    try
    {
      this.Jqd.add(paramb);
      return paramb;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  protected final void b(b paramb)
  {
    try
    {
      this.Jqd.remove(paramb);
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public final boolean contains(_Callback param_Callback)
  {
    try
    {
      boolean bool = this.Jqd.contains(new b(param_Callback, this));
      return bool;
    }
    finally
    {
      param_Callback = finally;
      throw param_Callback;
    }
  }
  
  public final LinkedList<b> fxj()
  {
    try
    {
      LinkedList localLinkedList = fxk();
      return localLinkedList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final LinkedList<b> fxk()
  {
    return new LinkedList(this.Jqd);
  }
  
  public final int size()
  {
    try
    {
      int i = this.Jqd.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.b.a
 * JD-Core Version:    0.7.0.1
 */