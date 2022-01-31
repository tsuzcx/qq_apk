package com.tencent.mm.view.a;

import android.content.Context;
import android.widget.BaseAdapter;

public abstract class a
  extends BaseAdapter
  implements g
{
  public int AQI;
  public int AQK;
  public com.tencent.mm.view.f.a AQU;
  public int ARM;
  public int ARN;
  public String ARO;
  public int ARP;
  public int ejZ;
  public Context mContext;
  public int nAh;
  
  public a(Context paramContext, com.tencent.mm.view.f.a parama)
  {
    this.mContext = paramContext;
    this.AQU = parama;
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.AQI = paramInt1;
    this.ejZ = paramInt2;
    this.ARM = paramInt3;
    this.AQK = paramInt4;
    this.ARN = paramInt5;
    this.ARP = paramInt6;
    this.nAh = paramInt7;
  }
  
  public boolean uu(int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.a.a
 * JD-Core Version:    0.7.0.1
 */