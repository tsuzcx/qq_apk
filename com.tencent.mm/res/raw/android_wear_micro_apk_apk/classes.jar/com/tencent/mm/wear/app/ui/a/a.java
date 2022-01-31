package com.tencent.mm.wear.app.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.wear.app.ui.g;

public abstract class a
{
  private boolean ahb;
  private int ahc;
  private boolean ahd;
  public g ahe;
  private int position;
  
  public a(int paramInt1, int paramInt2)
  {
    this.ahc = paramInt1;
    this.position = paramInt2;
  }
  
  public final void H(boolean paramBoolean)
  {
    this.ahd = paramBoolean;
  }
  
  public abstract View a(Context paramContext, ViewGroup paramViewGroup);
  
  public abstract void a(Context paramContext, b paramb);
  
  public abstract boolean a(Context paramContext, a parama);
  
  public final void nu()
  {
    this.ahb = true;
  }
  
  public final boolean nv()
  {
    return this.ahb;
  }
  
  public final int nw()
  {
    return this.ahc;
  }
  
  public final boolean nx()
  {
    return this.ahd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.a.a
 * JD-Core Version:    0.7.0.1
 */