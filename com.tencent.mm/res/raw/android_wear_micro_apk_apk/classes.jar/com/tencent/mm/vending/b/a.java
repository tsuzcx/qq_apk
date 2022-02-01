package com.tencent.mm.vending.b;

import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.f;
import com.tencent.mm.vending.h.h;
import java.util.LinkedList;
import junit.framework.Assert;

public abstract class a<_Callback>
{
  private LinkedList<b> adk = new LinkedList();
  protected d adl;
  protected f adm;
  
  public a()
  {
    this(h.mt());
  }
  
  public a(d paramd)
  {
    Assert.assertNotNull(paramd);
    this.adl = paramd;
    this.adm = new f(paramd);
  }
  
  protected final b a(b paramb)
  {
    try
    {
      this.adk.add(paramb);
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
      this.adk.remove(paramb);
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public final LinkedList<b> mk()
  {
    try
    {
      LinkedList localLinkedList = ml();
      return localLinkedList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final LinkedList<b> ml()
  {
    return new LinkedList(this.adk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.b.a
 * JD-Core Version:    0.7.0.1
 */