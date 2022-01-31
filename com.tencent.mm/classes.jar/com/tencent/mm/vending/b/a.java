package com.tencent.mm.vending.b;

import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.f;
import com.tencent.mm.vending.h.g;
import java.util.LinkedList;
import junit.framework.Assert;

public abstract class a<_Callback>
{
  private LinkedList<b> a = new LinkedList();
  protected d bww;
  public f wtn;
  
  public a()
  {
    this(g.cLe());
  }
  
  public a(d paramd)
  {
    Assert.assertNotNull(paramd);
    this.bww = paramd;
    this.wtn = new f(paramd, null);
  }
  
  public final b a(b paramb)
  {
    try
    {
      this.a.add(paramb);
      return paramb;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public final void b(b paramb)
  {
    if (paramb == null) {}
    for (;;)
    {
      return;
      try
      {
        this.a.remove(paramb);
      }
      finally {}
    }
  }
  
  public final LinkedList<b> cKT()
  {
    try
    {
      LinkedList localLinkedList = new LinkedList(this.a);
      return localLinkedList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean contains(_Callback param_Callback)
  {
    try
    {
      boolean bool = this.a.contains(new b(param_Callback, this));
      return bool;
    }
    finally
    {
      param_Callback = finally;
      throw param_Callback;
    }
  }
  
  public final int size()
  {
    try
    {
      int i = this.a.size();
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