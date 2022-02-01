package com.tencent.mm.vending.a;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class b<_Struct, _Item>
  extends com.tencent.mm.vending.base.b<_Struct, Cursor>
{
  public a HOP;
  protected _Item JW;
  protected Cursor Qs = null;
  protected int mCount;
  protected Map<Integer, _Item> nqs = null;
  
  public b(_Item param_Item)
  {
    this.JW = param_Item;
    this.mCount = -1;
    fgY();
  }
  
  private Cursor getCursor()
  {
    if ((this.Qs == null) || (this.Qs.isClosed())) {
      Assert.assertNotNull(this.Qs);
    }
    return this.Qs;
  }
  
  public abstract _Item a(_Item param_Item, Cursor paramCursor);
  
  public final void cHX()
  {
    if (this.nqs != null) {
      this.nqs.clear();
    }
    if (this.Qs != null) {
      this.Qs.close();
    }
    this.mCount = -1;
  }
  
  protected abstract Cursor dDi();
  
  public void destroyAsynchronous()
  {
    cHX();
  }
  
  public final void fgY()
  {
    if (this.nqs == null) {
      this.nqs = new HashMap();
    }
  }
  
  public final int fgZ()
  {
    if (this.mCount < 0) {
      this.mCount = getCursor().getCount();
    }
    return this.mCount;
  }
  
  public final _Item getItem(int paramInt)
  {
    if (this.nqs != null)
    {
      localObject = this.nqs.get(Integer.valueOf(paramInt));
      if (localObject != null) {
        return localObject;
      }
    }
    if ((paramInt < 0) || (!getCursor().moveToPosition(paramInt))) {
      return null;
    }
    if (this.nqs == null) {
      return a(this.JW, getCursor());
    }
    Object localObject = a(null, getCursor());
    this.nqs.put(Integer.valueOf(paramInt), localObject);
    return localObject;
  }
  
  public static abstract interface a
  {
    public abstract void dCr();
    
    public abstract void dCs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.a.b
 * JD-Core Version:    0.7.0.1
 */