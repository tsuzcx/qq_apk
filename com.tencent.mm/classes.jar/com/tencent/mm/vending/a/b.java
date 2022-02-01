package com.tencent.mm.vending.a;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class b<_Struct, _Item>
  extends com.tencent.mm.vending.base.b<_Struct, Cursor>
{
  public a Jpk;
  protected _Item KR;
  protected Cursor Rn = null;
  protected int mCount;
  protected Map<Integer, _Item> nTs = null;
  
  public b(_Item param_Item)
  {
    this.KR = param_Item;
    this.mCount = -1;
    fxa();
  }
  
  private Cursor getCursor()
  {
    if ((this.Rn == null) || (this.Rn.isClosed())) {
      Assert.assertNotNull(this.Rn);
    }
    return this.Rn;
  }
  
  public abstract _Item a(_Item param_Item, Cursor paramCursor);
  
  public final void cVi()
  {
    if (this.nTs != null) {
      this.nTs.clear();
    }
    if (this.Rn != null) {
      this.Rn.close();
    }
    this.mCount = -1;
  }
  
  protected abstract Cursor dRF();
  
  public void destroyAsynchronous()
  {
    cVi();
  }
  
  public final void fxa()
  {
    if (this.nTs == null) {
      this.nTs = new HashMap();
    }
  }
  
  public final int fxb()
  {
    if (this.mCount < 0) {
      this.mCount = getCursor().getCount();
    }
    return this.mCount;
  }
  
  public final _Item getItem(int paramInt)
  {
    if (this.nTs != null)
    {
      localObject = this.nTs.get(Integer.valueOf(paramInt));
      if (localObject != null) {
        return localObject;
      }
    }
    if ((paramInt < 0) || (!getCursor().moveToPosition(paramInt))) {
      return null;
    }
    if (this.nTs == null) {
      return a(this.KR, getCursor());
    }
    Object localObject = a(null, getCursor());
    this.nTs.put(Integer.valueOf(paramInt), localObject);
    return localObject;
  }
  
  public static abstract interface a
  {
    public abstract void dQO();
    
    public abstract void dQP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.a.b
 * JD-Core Version:    0.7.0.1
 */