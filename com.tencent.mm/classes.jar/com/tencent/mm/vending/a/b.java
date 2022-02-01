package com.tencent.mm.vending.a;

import android.database.Cursor;
import com.tencent.mm.vending.base.c;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class b<_Struct, _Item>
  extends c<_Struct, Cursor>
{
  public a agtA;
  protected _Item dJ;
  private Cursor gw = null;
  protected int mCount;
  protected Map<Integer, _Item> wrx = null;
  
  public b(_Item param_Item)
  {
    this.dJ = param_Item;
    this.mCount = -1;
    jJA();
  }
  
  private Cursor Fv()
  {
    if ((this.gw == null) || (this.gw.isClosed())) {
      Assert.assertNotNull(this.gw);
    }
    return this.gw;
  }
  
  private void fSd()
  {
    if (this.wrx != null) {
      this.wrx.clear();
    }
    if (this.gw != null) {
      this.gw.close();
    }
    this.mCount = -1;
  }
  
  public abstract _Item a(_Item param_Item, Cursor paramCursor);
  
  public void destroyAsynchronous()
  {
    fSd();
  }
  
  public final _Item getItem(int paramInt)
  {
    if (this.wrx != null)
    {
      localObject = this.wrx.get(Integer.valueOf(paramInt));
      if (localObject != null) {
        return localObject;
      }
    }
    if ((paramInt < 0) || (!Fv().moveToPosition(paramInt))) {
      return null;
    }
    if (this.wrx == null) {
      return a(this.dJ, Fv());
    }
    Object localObject = a(null, Fv());
    this.wrx.put(Integer.valueOf(paramInt), localObject);
    return localObject;
  }
  
  protected abstract Cursor hqP();
  
  public final void jJA()
  {
    if (this.wrx == null) {
      this.wrx = new HashMap();
    }
  }
  
  public final int jJB()
  {
    if (this.mCount < 0) {
      this.mCount = Fv().getCount();
    }
    return this.mCount;
  }
  
  public final void w(Cursor paramCursor)
  {
    fSd();
    this.gw = paramCursor;
  }
  
  public static abstract interface a
  {
    public abstract void hpW();
    
    public abstract void hpX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.vending.a.b
 * JD-Core Version:    0.7.0.1
 */