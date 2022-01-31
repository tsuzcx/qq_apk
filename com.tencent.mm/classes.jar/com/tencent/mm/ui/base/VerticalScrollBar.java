package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.am;

public abstract class VerticalScrollBar
  extends View
{
  private int aRn;
  private int backgroundColor;
  private float fad;
  View hXE;
  private int iiW;
  private int iiX;
  private Context mContext;
  private int maxHeight;
  private TextView nSA;
  private int nSB;
  protected float nSv;
  protected int nSw;
  protected String[] nSx;
  private float nSy = 0.0F;
  private o nSz;
  private Paint paint;
  private int textColor;
  private float textSize;
  private boolean zpV = false;
  public VerticalScrollBar.a zpW;
  private int zpX;
  private int zpY;
  private int zpZ;
  private int zqa = 0;
  
  public VerticalScrollBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Kr();
    this.mContext = paramContext;
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.nSB = BackwardSupportUtil.b.b(paramContext, 3.0F);
    this.hXE = inflate(paramContext, getToastLayoutId(), null);
    this.zpZ = BackwardSupportUtil.b.b(paramContext, this.nSw);
    this.iiW = this.mContext.getResources().getDisplayMetrics().widthPixels;
    this.iiX = this.mContext.getResources().getDisplayMetrics().heightPixels;
    this.nSz = new o(this.hXE, this.zpZ, this.zpZ);
    this.nSA = ((TextView)this.hXE.findViewById(2131827784));
    this.textColor = paramContext.getResources().getColor(2131690322);
    this.zpX = this.mContext.getResources().getColor(2131690711);
    this.backgroundColor = paramContext.getResources().getColor(2131690701);
    this.zpY = al.fromDPToPix(getContext(), 7);
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    int i = (int)(a.ap(this.mContext, 2131427563) * a.gr(this.mContext));
    this.maxHeight = (Math.max(this.iiX, this.iiW) - am.di(this.mContext) - am.getStatusBarHeight(this.mContext) - am.fx(this.mContext) - i);
    this.zqa = ((int)(this.maxHeight / (this.nSx.length * this.nSv)));
  }
  
  protected abstract void Kr();
  
  protected abstract int getToastLayoutId();
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getMeasuredHeight();
    int j = getMeasuredWidth();
    int k = al.fromDPToPix(getContext(), 9);
    this.textSize = al.fromDPToPix(getContext(), 11);
    float f;
    if (this.textSize > this.zqa)
    {
      f = this.zqa;
      this.textSize = f;
      if (this.textSize >= k) {
        break label322;
      }
      f = k;
      label80:
      this.textSize = f;
      this.paint.setTextSize(this.textSize);
      if (this.nSy != this.textSize)
      {
        this.nSy = this.textSize;
        post(new VerticalScrollBar.1(this, i, j));
      }
      if ((this.zpV) && (this.aRn != 0))
      {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.backgroundColor);
        paramCanvas.drawCircle(j / 2.0F, this.textSize / 2.0F + this.aRn * this.textSize * this.nSv + al.fromDPToPix(this.mContext, 1), this.zpY, this.paint);
      }
      this.paint.setTextAlign(Paint.Align.CENTER);
      i = 0;
      label229:
      if (i >= this.nSx.length) {
        return;
      }
      if ((!this.zpV) || (this.aRn == 0) || (this.aRn != i)) {
        break label330;
      }
      this.paint.setColor(this.zpX);
    }
    for (;;)
    {
      paramCanvas.drawText(this.nSx[i], j / 2.0F, this.textSize + i * this.textSize * this.nSv, this.paint);
      i += 1;
      break label229;
      f = this.textSize;
      break;
      label322:
      f = this.textSize;
      break label80;
      label330:
      this.paint.setColor(this.textColor);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 2))
    {
      this.zpV = true;
      this.fad = paramMotionEvent.getY();
      if (this.fad < 0.0F) {
        this.fad = 0.0F;
      }
      if (this.fad > getMeasuredHeight()) {
        this.fad = getMeasuredHeight();
      }
      int j = (int)(this.fad / (this.textSize * this.nSv));
      int i = j;
      if (j >= this.nSx.length) {
        i = this.nSx.length - 1;
      }
      this.aRn = i;
      if (this.aRn != -1) {
        break label294;
      }
      this.nSA.setText(2131302955);
      i = this.iiW - al.fromDPToPix(getContext(), 120);
      j = (int)(this.textSize / 2.0F + this.aRn * this.textSize * this.nSv - this.zpZ / 2.0D + (paramMotionEvent.getRawY() - paramMotionEvent.getY()));
      if (paramMotionEvent.getAction() == 0) {
        this.nSz.showAtLocation(this, 0, i, j);
      }
      if (paramMotionEvent.getAction() == 2) {
        this.nSz.update(i, j, this.zpZ, this.zpZ);
      }
      if (this.zpW != null)
      {
        if (this.aRn != -1) {
          break label313;
        }
        this.zpW.lf(a.aq(getContext(), 2131302955));
      }
    }
    for (;;)
    {
      invalidate();
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        this.nSz.dismiss();
        this.zpV = false;
      }
      return true;
      label294:
      this.nSA.setText(this.nSx[this.aRn]);
      break;
      label313:
      this.zpW.lf(this.nSx[this.aRn]);
    }
  }
  
  public void setOnScrollBarTouchListener(VerticalScrollBar.a parama)
  {
    this.zpW = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.VerticalScrollBar
 * JD-Core Version:    0.7.0.1
 */