package com.tencent.mm.vending.a;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class b<_Struct, _Item>
  extends com.tencent.mm.vending.base.b<_Struct, Cursor>
{
  public b.a ANH;
  protected Cursor ANI = null;
  protected _Item Dh;
  protected Map<Integer, _Item> kln = null;
  protected int mCount;
  
  public b(_Item param_Item)
  {
    this.Dh = param_Item;
    this.mCount = -1;
    dQd();
  }
  
  private Cursor getCursor()
  {
    if ((this.ANI == null) || (this.ANI.isClosed())) {
      Assert.assertNotNull(this.ANI);
    }
    return this.ANI;
  }
  
  public abstract _Item a(_Item param_Item, Cursor paramCursor);
  
  public final void bKb()
  {
    if (this.kln != null) {
      this.kln.clear();
    }
    if (this.ANI != null) {
      this.ANI.close();
    }
    this.mCount = -1;
  }
  
  protected abstract Cursor cwQ();
  
  public final void dQd()
  {
    if (this.kln == null) {
      this.kln = new HashMap();
    }
  }
  
  public final int dQe()
  {
    if (this.mCount < 0) {
      this.mCount = getCursor().getCount();
    }
    return this.mCount;
  }
  
  public void destroyAsynchronous()
  {
    bKb();
  }
  
  public final _Item getItem(int paramInt)
  {
    if (this.kln != null)
    {
      localObject = this.kln.get(Integer.valueOf(paramInt));
      if (localObject != null) {
        return localObject;
      }
    }
    if ((paramInt < 0) || (!getCursor().moveToPosition(paramInt))) {
      return null;
    }
    if (this.kln == null) {
      return a(this.Dh, getCursor());
    }
    Object localObject = a(null, getCursor());
    this.kln.put(Integer.valueOf(paramInt), localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.vending.a.b
 * JD-Core Version:    0.7.0.1
 */