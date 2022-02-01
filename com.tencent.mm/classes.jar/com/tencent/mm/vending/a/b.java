package com.tencent.mm.vending.a;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class b<_Struct, _Item>
  extends com.tencent.mm.vending.base.b<_Struct, Cursor>
{
  public a LDr;
  protected _Item MJ;
  protected Cursor Tc = null;
  protected int mCount;
  protected Map<Integer, _Item> oDp = null;
  
  public b(_Item param_Item)
  {
    this.MJ = param_Item;
    this.mCount = -1;
    fSi();
  }
  
  private Cursor getCursor()
  {
    if ((this.Tc == null) || (this.Tc.isClosed())) {
      Assert.assertNotNull(this.Tc);
    }
    return this.Tc;
  }
  
  public abstract _Item a(_Item param_Item, Cursor paramCursor);
  
  public void destroyAsynchronous()
  {
    dhl();
  }
  
  public final void dhl()
  {
    if (this.oDp != null) {
      this.oDp.clear();
    }
    if (this.Tc != null) {
      this.Tc.close();
    }
    this.mCount = -1;
  }
  
  protected abstract Cursor ehG();
  
  public final void fSi()
  {
    if (this.oDp == null) {
      this.oDp = new HashMap();
    }
  }
  
  public final int fSj()
  {
    if (this.mCount < 0) {
      this.mCount = getCursor().getCount();
    }
    return this.mCount;
  }
  
  public final _Item getItem(int paramInt)
  {
    if (this.oDp != null)
    {
      localObject = this.oDp.get(Integer.valueOf(paramInt));
      if (localObject != null) {
        return localObject;
      }
    }
    if ((paramInt < 0) || (!getCursor().moveToPosition(paramInt))) {
      return null;
    }
    if (this.oDp == null) {
      return a(this.MJ, getCursor());
    }
    Object localObject = a(null, getCursor());
    this.oDp.put(Integer.valueOf(paramInt), localObject);
    return localObject;
  }
  
  public static abstract interface a
  {
    public abstract void egN();
    
    public abstract void egO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.a.b
 * JD-Core Version:    0.7.0.1
 */