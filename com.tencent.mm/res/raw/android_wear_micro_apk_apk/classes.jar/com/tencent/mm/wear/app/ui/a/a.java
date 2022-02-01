package com.tencent.mm.wear.app.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.wear.app.ui.g;

public abstract class a
{
  private boolean akD;
  private int akE;
  private boolean akF;
  public g akG;
  private int position;
  
  public a(int paramInt1, int paramInt2)
  {
    this.akE = paramInt1;
    this.position = paramInt2;
  }
  
  public final void K(boolean paramBoolean)
  {
    this.akF = paramBoolean;
  }
  
  public abstract View a(Context paramContext, ViewGroup paramViewGroup);
  
  public abstract void a(Context paramContext, b paramb);
  
  public abstract boolean a(Context paramContext, a parama);
  
  public final void oh()
  {
    this.akD = true;
  }
  
  public final boolean oi()
  {
    return this.akD;
  }
  
  public final int oj()
  {
    return this.akE;
  }
  
  public final boolean ok()
  {
    return this.akF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.a.a
 * JD-Core Version:    0.7.0.1
 */