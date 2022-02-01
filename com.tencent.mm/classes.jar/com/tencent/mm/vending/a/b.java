package com.tencent.mm.vending.a;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class b<_Struct, _Item>
  extends com.tencent.mm.vending.base.b<_Struct, Cursor>
{
  protected _Item MT;
  public a QYM;
  protected Cursor To = null;
  protected int mCount;
  protected Map<Integer, _Item> pQY = null;
  
  public b(_Item param_Item)
  {
    this.MT = param_Item;
    this.mCount = -1;
    hdm();
  }
  
  private Cursor getCursor()
  {
    if ((this.To == null) || (this.To.isClosed())) {
      Assert.assertNotNull(this.To);
    }
    return this.To;
  }
  
  public abstract _Item a(_Item param_Item, Cursor paramCursor);
  
  public void destroyAsynchronous()
  {
    ebf();
  }
  
  public final void ebf()
  {
    if (this.pQY != null) {
      this.pQY.clear();
    }
    if (this.To != null) {
      this.To.close();
    }
    this.mCount = -1;
  }
  
  protected abstract Cursor fki();
  
  public final _Item getItem(int paramInt)
  {
    if (this.pQY != null)
    {
      localObject = this.pQY.get(Integer.valueOf(paramInt));
      if (localObject != null) {
        return localObject;
      }
    }
    if ((paramInt < 0) || (!getCursor().moveToPosition(paramInt))) {
      return null;
    }
    if (this.pQY == null) {
      return a(this.MT, getCursor());
    }
    Object localObject = a(null, getCursor());
    this.pQY.put(Integer.valueOf(paramInt), localObject);
    return localObject;
  }
  
  public final void hdm()
  {
    if (this.pQY == null) {
      this.pQY = new HashMap();
    }
  }
  
  public final int hdn()
  {
    if (this.mCount < 0) {
      this.mCount = getCursor().getCount();
    }
    return this.mCount;
  }
  
  public static abstract interface a
  {
    public abstract void fjp();
    
    public abstract void fjq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.vending.a.b
 * JD-Core Version:    0.7.0.1
 */