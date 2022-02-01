package com.tencent.mm.plugin.sns.ui.widget.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;

public abstract class a
{
  protected String TAG = "SnsAd.BaseScene";
  protected Context mContext;
  protected final int zlO = 20;
  protected int zlP;
  protected int zlQ;
  protected int zlR;
  private long zlS = 0L;
  protected ArrayList<h> zlT = new ArrayList();
  
  public static Paint dSO()
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    return localPaint;
  }
  
  public final void clear()
  {
    this.zlT.clear();
    this.zlS = 0L;
  }
  
  protected abstract int dSP();
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.zlT.isEmpty()) {}
    for (;;)
    {
      return;
      if (this.zlS == 0L) {
        this.zlS = System.currentTimeMillis();
      }
      System.currentTimeMillis();
      int j = dSP();
      int k = this.zlT.size();
      int i = j;
      if (j > k) {
        i = k;
      }
      j = 0;
      while (j < i)
      {
        ((h)this.zlT.get(j)).draw(paramCanvas);
        j += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.a.a
 * JD-Core Version:    0.7.0.1
 */