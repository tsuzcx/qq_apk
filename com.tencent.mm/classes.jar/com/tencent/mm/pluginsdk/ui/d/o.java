package com.tencent.mm.pluginsdk.ui.d;

import android.view.View;

public class o
  extends n
{
  private o.a skh;
  private Object tag;
  
  public o() {}
  
  public o(Object paramObject, o.a parama)
  {
    super(2, null);
    this.skh = parama;
    this.tag = paramObject;
  }
  
  public o(Object paramObject, o.a parama, int paramInt)
  {
    super(2, null);
    this.skh = parama;
    this.tag = paramObject;
    AX(paramInt);
  }
  
  public void onClick(View paramView)
  {
    if (this.skh != null) {
      this.skh.bC(this.tag);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.o
 * JD-Core Version:    0.7.0.1
 */