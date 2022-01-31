package com.tencent.mm.ui.base.sortview;

import android.content.Context;

public abstract class a
{
  public Object data;
  public int type;
  public boolean vdV;
  
  public a(int paramInt, Object paramObject)
  {
    this.type = paramInt;
    this.data = paramObject;
  }
  
  public abstract void a(Context paramContext, a.a parama, Object... paramVarArgs);
  
  public abstract a.b axw();
  
  public abstract a.a axx();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.a
 * JD-Core Version:    0.7.0.1
 */