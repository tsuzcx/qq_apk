package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ac.a.f;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.k;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public abstract class VerticalScrollBar
  extends View
{
  private int aJH;
  private float dOB;
  private Paint gaZ;
  public float lve;
  public int lvf;
  public String[] lvg;
  private float lvh = 0.0F;
  private float lvi;
  private o lvj;
  private TextView lvk;
  private int lvl;
  public VerticalScrollBar.a vbE;
  
  public VerticalScrollBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    xZ();
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.lvl = BackwardSupportUtil.b.b(paramContext, 3.0F);
    paramAttributeSet = inflate(paramContext, getToastLayoutId(), null);
    int i = BackwardSupportUtil.b.b(paramContext, this.lvf);
    this.lvj = new o(paramAttributeSet, i, i);
    this.lvk = ((TextView)paramAttributeSet.findViewById(a.g.show_head_toast_text));
    this.gaZ = new Paint();
    this.gaZ.setAntiAlias(true);
    this.gaZ.setColor(-11119018);
    this.gaZ.setTextAlign(Paint.Align.CENTER);
  }
  
  public abstract int getToastLayoutId();
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getMeasuredHeight();
    int j = getMeasuredWidth();
    this.dOB = (i / (this.lvg.length * this.lve));
    this.gaZ.setTextSize(this.dOB);
    if (this.lvh != this.dOB)
    {
      this.lvh = this.dOB;
      post(new VerticalScrollBar.1(this, j, i));
    }
    i = 0;
    while (i < this.lvg.length)
    {
      paramCanvas.drawText(this.lvg[i], j / 2.0F, this.dOB + i * this.dOB * this.lve, this.gaZ);
      i += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 2))
    {
      this.lvi = paramMotionEvent.getY();
      if (this.lvi < 0.0F) {
        this.lvi = 0.0F;
      }
      if (this.lvi > getMeasuredHeight()) {
        this.lvi = getMeasuredHeight();
      }
      setBackgroundDrawable(a.g(getContext(), a.f.scrollbar_bg));
      int j = (int)(this.lvi / (this.dOB * this.lve));
      int i = j;
      if (j >= this.lvg.length) {
        i = this.lvg.length - 1;
      }
      this.aJH = i;
      if (this.aJH != -1) {
        break label211;
      }
      this.lvk.setText(a.k.scroll_bar_search);
      this.lvj.showAtLocation(this, 17, 0, 0);
      if (this.vbE != null)
      {
        if (this.aJH != -1) {
          break label230;
        }
        this.vbE.eU(a.ac(getContext(), a.k.scroll_bar_search));
      }
    }
    for (;;)
    {
      invalidate();
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        setBackgroundResource(0);
        this.lvj.dismiss();
      }
      return true;
      label211:
      this.lvk.setText(this.lvg[this.aJH]);
      break;
      label230:
      this.vbE.eU(this.lvg[this.aJH]);
    }
  }
  
  public void setOnScrollBarTouchListener(VerticalScrollBar.a parama)
  {
    this.vbE = parama;
  }
  
  public abstract void xZ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.VerticalScrollBar
 * JD-Core Version:    0.7.0.1
 */