package com.tencent.mm.ui.base.sortview;

import android.content.Context;
import android.view.View;

public abstract class a
{
  protected boolean aeau;
  protected Object cpt;
  public int type;
  
  public a(int paramInt, Object paramObject)
  {
    this.type = paramInt;
    this.cpt = paramObject;
  }
  
  public abstract void a(Context paramContext, a parama, Object... paramVarArgs);
  
  public abstract b dco();
  
  public abstract a dcp();
  
  public final Object getData()
  {
    return this.cpt;
  }
  
  public final boolean jnF()
  {
    return this.aeau;
  }
  
  public static abstract interface a {}
  
  public static abstract class b
  {
    public abstract void a(Context paramContext, a.a parama, a paramVarArgs);
    
    public abstract void a(View paramView, a.a parama);
    
    public abstract boolean a(Context paramContext, a parama, Object... paramVarArgs);
    
    public abstract View c(Context paramContext, View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.a
 * JD-Core Version:    0.7.0.1
 */