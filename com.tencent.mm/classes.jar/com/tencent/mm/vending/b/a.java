package com.tencent.mm.vending.b;

import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.f;
import com.tencent.mm.vending.h.g;
import java.util.LinkedList;
import junit.framework.Assert;

public abstract class a<_Callback>
{
  private LinkedList<b> LhI = new LinkedList();
  protected f LhJ;
  protected d cTQ;
  
  public a()
  {
    this(g.fOh());
  }
  
  public a(d paramd)
  {
    Assert.assertNotNull(paramd);
    this.cTQ = paramd;
    this.LhJ = new f(paramd, null);
  }
  
  protected final b a(b paramb)
  {
    try
    {
      this.LhI.add(paramb);
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
      this.LhI.remove(paramb);
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
      boolean bool = this.LhI.contains(new b(param_Callback, this));
      return bool;
    }
    finally
    {
      param_Callback = finally;
      throw param_Callback;
    }
  }
  
  public final LinkedList<b> fNW()
  {
    try
    {
      LinkedList localLinkedList = fNX();
      return localLinkedList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final LinkedList<b> fNX()
  {
    return new LinkedList(this.LhI);
  }
  
  public final int size()
  {
    try
    {
      int i = this.LhI.size();
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