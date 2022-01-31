package com.tencent.mm.view.a;

import android.content.Context;
import android.widget.BaseAdapter;

public abstract class a
  extends BaseAdapter
  implements e
{
  public int dsr;
  public int lcm;
  public Context mContext;
  public int wvI;
  public int wvK;
  public com.tencent.mm.view.f.a wvS;
  public int wwK;
  public int wwL;
  public String wwM;
  public int wwN;
  
  public a(Context paramContext, com.tencent.mm.view.f.a parama)
  {
    this.mContext = paramContext;
    this.wvS = parama;
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.wvI = paramInt1;
    this.dsr = paramInt2;
    this.wwK = paramInt3;
    this.wvK = paramInt4;
    this.wwL = paramInt5;
    this.wwN = paramInt6;
    this.lcm = paramInt7;
  }
  
  public boolean pY(int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.a.a
 * JD-Core Version:    0.7.0.1
 */