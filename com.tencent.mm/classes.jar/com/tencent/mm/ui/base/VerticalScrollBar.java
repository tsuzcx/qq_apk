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
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;

public abstract class VerticalScrollBar
  extends View
{
  View HAs;
  private boolean HDj = false;
  public a HDk;
  private int HDl;
  private int HDm;
  private int HDn;
  private int HDo = 0;
  private int backgroundColor;
  private int bns;
  private float fTh;
  private int kWB;
  private int kWC;
  private Context mContext;
  private int maxHeight;
  private Paint paint;
  protected float tNW;
  protected int tNX;
  protected String[] tNY;
  private float tNZ = 0.0F;
  private o tOa;
  private TextView tOb;
  private int tOc;
  private int textColor;
  private float textSize;
  
  public VerticalScrollBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    WY();
    this.mContext = paramContext;
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.tOc = BackwardSupportUtil.b.g(paramContext, 3.0F);
    this.HAs = inflate(paramContext, getToastLayoutId(), null);
    this.HDn = BackwardSupportUtil.b.g(paramContext, this.tNX);
    this.kWB = this.mContext.getResources().getDisplayMetrics().widthPixels;
    this.kWC = this.mContext.getResources().getDisplayMetrics().heightPixels;
    this.tOa = new o(this.HAs, this.HDn, this.HDn);
    this.tOb = ((TextView)this.HAs.findViewById(2131304779));
    this.textColor = ao.aJ(this.mContext, 2130968576);
    this.HDl = this.mContext.getResources().getColor(2131101182);
    this.backgroundColor = paramContext.getResources().getColor(2131101171);
    this.HDm = ao.fromDPToPix(getContext(), 7);
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    int i = (int)(a.av(this.mContext, 2131165256) * a.ib(this.mContext));
    this.maxHeight = (Math.max(this.kWC, this.kWB) - ap.dT(this.mContext) - ap.ji(this.mContext) - ap.ej(this.mContext) - i);
    this.HDo = ((int)(this.maxHeight / (this.tNY.length * this.tNW)));
  }
  
  protected abstract void WY();
  
  protected abstract int getToastLayoutId();
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    final int i = getMeasuredHeight();
    final int j = getMeasuredWidth();
    int k = ao.fromDPToPix(getContext(), 9);
    this.textSize = ao.fromDPToPix(getContext(), 11);
    float f;
    if (this.textSize > this.HDo)
    {
      f = this.HDo;
      this.textSize = f;
      if (this.textSize >= k) {
        break label322;
      }
      f = k;
      label80:
      this.textSize = f;
      this.paint.setTextSize(this.textSize);
      if (this.tNZ != this.textSize)
      {
        this.tNZ = this.textSize;
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(142456);
            if (VerticalScrollBar.this.tNY.length <= 0)
            {
              AppMethodBeat.o(142456);
              return;
            }
            int i = (int)VerticalScrollBar.a(VerticalScrollBar.this).measureText(VerticalScrollBar.this.tNY[(VerticalScrollBar.this.tNY.length - 1)]);
            int k = a.fromDPToPix(VerticalScrollBar.this.getContext(), 16) + i;
            int j = (int)(VerticalScrollBar.this.tNY.length * VerticalScrollBar.b(VerticalScrollBar.this) * VerticalScrollBar.this.tNW);
            ac.i("MicroMsg.VerticalScrollBar", "onDraw newHeight:%s, viewHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
            i = j;
            if (j == 0) {
              i = i;
            }
            j = k;
            if (k > j) {
              j = j;
            }
            ViewGroup.LayoutParams localLayoutParams = VerticalScrollBar.this.getLayoutParams();
            localLayoutParams.width = j;
            localLayoutParams.height = i;
            VerticalScrollBar.this.setLayoutParams(localLayoutParams);
            AppMethodBeat.o(142456);
          }
        });
      }
      if ((this.HDj) && (this.bns != 0))
      {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.backgroundColor);
        paramCanvas.drawCircle(j / 2.0F, this.textSize / 2.0F + this.bns * this.textSize * this.tNW + ao.fromDPToPix(this.mContext, 1), this.HDm, this.paint);
      }
      this.paint.setTextAlign(Paint.Align.CENTER);
      i = 0;
      label229:
      if (i >= this.tNY.length) {
        return;
      }
      if ((!this.HDj) || (this.bns == 0) || (this.bns != i)) {
        break label330;
      }
      this.paint.setColor(this.HDl);
    }
    for (;;)
    {
      paramCanvas.drawText(this.tNY[i], j / 2.0F, this.textSize + i * this.textSize * this.tNW, this.paint);
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
      this.HDj = true;
      this.fTh = paramMotionEvent.getY();
      if (this.fTh < 0.0F) {
        this.fTh = 0.0F;
      }
      if (this.fTh > getMeasuredHeight()) {
        this.fTh = getMeasuredHeight();
      }
      int j = (int)(this.fTh / (this.textSize * this.tNW));
      int i = j;
      if (j >= this.tNY.length) {
        i = this.tNY.length - 1;
      }
      this.bns = i;
      if (this.bns != -1) {
        break label294;
      }
      this.tOb.setText(2131762893);
      i = this.kWB - ao.fromDPToPix(getContext(), 120);
      j = (int)(this.textSize / 2.0F + this.bns * this.textSize * this.tNW - this.HDn / 2.0D + (paramMotionEvent.getRawY() - paramMotionEvent.getY()));
      if (paramMotionEvent.getAction() == 0) {
        this.tOa.showAtLocation(this, 0, i, j);
      }
      if (paramMotionEvent.getAction() == 2) {
        this.tOa.update(i, j, this.HDn, this.HDn);
      }
      if (this.HDk != null)
      {
        if (this.bns != -1) {
          break label313;
        }
        this.HDk.sn(a.aw(getContext(), 2131762893));
      }
    }
    for (;;)
    {
      invalidate();
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        this.tOa.dismiss();
        this.HDj = false;
      }
      return true;
      label294:
      this.tOb.setText(this.tNY[this.bns]);
      break;
      label313:
      this.HDk.sn(this.tNY[this.bns]);
    }
  }
  
  public void setOnScrollBarTouchListener(a parama)
  {
    this.HDk = parama;
  }
  
  public static abstract interface a
  {
    public abstract void sn(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.VerticalScrollBar
 * JD-Core Version:    0.7.0.1
 */