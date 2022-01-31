package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.widget.ListView;

public class mr
  extends ListView
{
  private mr.a a;
  
  public mr(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void handleDataChanged()
  {
    super.handleDataChanged();
    if (this.a != null) {
      this.a.c();
    }
  }
  
  public void setOnDataChangedListener(mr.a parama)
  {
    this.a = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.mr
 * JD-Core Version:    0.7.0.1
 */