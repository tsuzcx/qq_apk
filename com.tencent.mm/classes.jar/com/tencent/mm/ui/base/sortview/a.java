package com.tencent.mm.ui.base.sortview;

import android.content.Context;

public abstract class a
{
  protected Object data;
  public int type;
  protected boolean zsv;
  
  public a(int paramInt, Object paramObject)
  {
    this.type = paramInt;
    this.data = paramObject;
  }
  
  public abstract void a(Context paramContext, a.a parama, Object... paramVarArgs);
  
  public abstract a.b aWu();
  
  public abstract a.a aWv();
  
  public final boolean dER()
  {
    return this.zsv;
  }
  
  public final Object getData()
  {
    return this.data;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.a
 * JD-Core Version:    0.7.0.1
 */