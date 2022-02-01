package com.tencent.mm.vending.a;

import android.database.Cursor;
import com.tencent.mm.vending.base.c;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class b<_Struct, _Item>
  extends c<_Struct, Cursor>
{
  public a Yzc;
  protected _Item dJ;
  private Cursor fB = null;
  protected int mCount;
  protected Map<Integer, _Item> tmX = null;
  
  public b(_Item param_Item)
  {
    this.dJ = param_Item;
    this.mCount = -1;
    iet();
  }
  
  private void eKd()
  {
    if (this.tmX != null) {
      this.tmX.clear();
    }
    if (this.fB != null) {
      this.fB.close();
    }
    this.mCount = -1;
  }
  
  private Cursor hK()
  {
    if ((this.fB == null) || (this.fB.isClosed())) {
      Assert.assertNotNull(this.fB);
    }
    return this.fB;
  }
  
  public abstract _Item a(_Item param_Item, Cursor paramCursor);
  
  public void destroyAsynchronous()
  {
    eKd();
  }
  
  protected abstract Cursor fYr();
  
  public final _Item getItem(int paramInt)
  {
    if (this.tmX != null)
    {
      localObject = this.tmX.get(Integer.valueOf(paramInt));
      if (localObject != null) {
        return localObject;
      }
    }
    if ((paramInt < 0) || (!hK().moveToPosition(paramInt))) {
      return null;
    }
    if (this.tmX == null) {
      return a(this.dJ, hK());
    }
    Object localObject = a(null, hK());
    this.tmX.put(Integer.valueOf(paramInt), localObject);
    return localObject;
  }
  
  public final void iet()
  {
    if (this.tmX == null) {
      this.tmX = new HashMap();
    }
  }
  
  public final int ieu()
  {
    if (this.mCount < 0) {
      this.mCount = hK().getCount();
    }
    return this.mCount;
  }
  
  public final void v(Cursor paramCursor)
  {
    eKd();
    this.fB = paramCursor;
  }
  
  public static abstract interface a
  {
    public abstract void fXC();
    
    public abstract void fXD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.a.b
 * JD-Core Version:    0.7.0.1
 */