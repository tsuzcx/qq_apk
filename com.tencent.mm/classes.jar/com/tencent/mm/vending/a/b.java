package com.tencent.mm.vending.a;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class b<_Struct, _Item>
  extends com.tencent.mm.vending.base.b<_Struct, Cursor>
{
  public a LgP;
  protected _Item MJ;
  protected Cursor Tc = null;
  protected int mCount;
  protected Map<Integer, _Item> owN = null;
  
  public b(_Item param_Item)
  {
    this.MJ = param_Item;
    this.mCount = -1;
    fNN();
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
    det();
  }
  
  public final void det()
  {
    if (this.owN != null) {
      this.owN.clear();
    }
    if (this.Tc != null) {
      this.Tc.close();
    }
    this.mCount = -1;
  }
  
  protected abstract Cursor edZ();
  
  public final void fNN()
  {
    if (this.owN == null) {
      this.owN = new HashMap();
    }
  }
  
  public final int fNO()
  {
    if (this.mCount < 0) {
      this.mCount = getCursor().getCount();
    }
    return this.mCount;
  }
  
  public final _Item getItem(int paramInt)
  {
    if (this.owN != null)
    {
      localObject = this.owN.get(Integer.valueOf(paramInt));
      if (localObject != null) {
        return localObject;
      }
    }
    if ((paramInt < 0) || (!getCursor().moveToPosition(paramInt))) {
      return null;
    }
    if (this.owN == null) {
      return a(this.MJ, getCursor());
    }
    Object localObject = a(null, getCursor());
    this.owN.put(Integer.valueOf(paramInt), localObject);
    return localObject;
  }
  
  public static abstract interface a
  {
    public abstract void edg();
    
    public abstract void edh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.a.b
 * JD-Core Version:    0.7.0.1
 */