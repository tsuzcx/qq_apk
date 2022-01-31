package com.tencent.mm.vending.a;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class b<_Struct, _Item>
  extends com.tencent.mm.vending.base.b<_Struct, Cursor>
{
  protected _Item Cy;
  protected Map<Integer, _Item> ikn = null;
  public int mCount;
  public b.a wsM;
  public Cursor wsN = null;
  
  public b(_Item param_Item)
  {
    this.Cy = param_Item;
    this.mCount = -1;
    cKN();
  }
  
  private Cursor getCursor()
  {
    if ((this.wsN == null) || (this.wsN.isClosed())) {
      Assert.assertNotNull(this.wsN);
    }
    return this.wsN;
  }
  
  public abstract _Item a(_Item param_Item, Cursor paramCursor);
  
  public abstract Cursor bJN();
  
  public final void bcS()
  {
    if (this.ikn != null) {
      this.ikn.clear();
    }
    if (this.wsN != null) {
      this.wsN.close();
    }
    this.mCount = -1;
  }
  
  public final void cKN()
  {
    if (this.ikn == null) {
      this.ikn = new HashMap();
    }
  }
  
  public final int cKO()
  {
    if (this.mCount < 0) {
      this.mCount = getCursor().getCount();
    }
    return this.mCount;
  }
  
  public void destroyAsynchronous()
  {
    bcS();
  }
  
  public final _Item getItem(int paramInt)
  {
    if (this.ikn != null)
    {
      localObject = this.ikn.get(Integer.valueOf(paramInt));
      if (localObject != null) {
        return localObject;
      }
    }
    if ((paramInt < 0) || (!getCursor().moveToPosition(paramInt))) {
      return null;
    }
    if (this.ikn == null) {
      return a(this.Cy, getCursor());
    }
    Object localObject = a(null, getCursor());
    this.ikn.put(Integer.valueOf(paramInt), localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vending.a.b
 * JD-Core Version:    0.7.0.1
 */