package com.tencent.mm.plugin.sns.ui.widget.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;

public abstract class a
{
  protected String TAG = "SnsAd.BaseScene";
  protected Context mContext;
  protected final int xYR = 20;
  protected int xYS;
  protected int xYT;
  protected int xYU;
  private long xYV = 0L;
  protected ArrayList<g> xYW = new ArrayList();
  
  public static Paint dEq()
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    return localPaint;
  }
  
  public final void clear()
  {
    this.xYW.clear();
    this.xYV = 0L;
  }
  
  protected abstract int dEr();
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.xYW.isEmpty()) {}
    for (;;)
    {
      return;
      if (this.xYV == 0L) {
        this.xYV = System.currentTimeMillis();
      }
      System.currentTimeMillis();
      int j = dEr();
      int k = this.xYW.size();
      int i = j;
      if (j > k) {
        i = k;
      }
      j = 0;
      while (j < i)
      {
        ((g)this.xYW.get(j)).draw(paramCanvas);
        j += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.a.a
 * JD-Core Version:    0.7.0.1
 */