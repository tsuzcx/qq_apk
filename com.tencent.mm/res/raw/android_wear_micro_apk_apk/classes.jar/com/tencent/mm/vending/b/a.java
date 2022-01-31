package com.tencent.mm.vending.b;

import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.vending.g.h;
import java.util.LinkedList;
import junit.framework.Assert;

public abstract class a<_Callback>
{
  private LinkedList<b> ZK = new LinkedList();
  protected d ZL;
  protected f ZM;
  
  public a()
  {
    this(h.lG());
  }
  
  public a(d paramd)
  {
    Assert.assertNotNull(paramd);
    this.ZL = paramd;
    this.ZM = new f(paramd);
  }
  
  protected final b a(b paramb)
  {
    try
    {
      this.ZK.add(paramb);
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
    if (paramb == null) {}
    for (;;)
    {
      return;
      try
      {
        this.ZK.remove(paramb);
      }
      finally {}
    }
  }
  
  public final LinkedList<b> lD()
  {
    try
    {
      LinkedList localLinkedList = new LinkedList(this.ZK);
      return localLinkedList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.b.a
 * JD-Core Version:    0.7.0.1
 */