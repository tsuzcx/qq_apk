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
import com.tencent.mm.ah.a.c;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;

public abstract class VerticalScrollBar
  extends View
{
  protected float JMi;
  protected int JMj;
  protected String[] JMk;
  protected float JMl = 0.0F;
  private v JMm;
  protected TextView JMn;
  private int JMo;
  private boolean RAE = false;
  private int adTS = 0;
  protected View adUp;
  public VerticalScrollBar.a adXj;
  protected int adXk;
  protected int adXl;
  private int adXm;
  protected int backgroundColor;
  private int dbk;
  private Context mContext;
  private int maxHeight;
  private float mkn;
  private Paint paint;
  private int pvg;
  private int sJv;
  protected int textColor;
  protected float textSize;
  
  public VerticalScrollBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    aNw();
    this.mContext = paramContext;
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.JMo = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 3.0F);
    this.adUp = inflate(paramContext, getToastLayoutId(), null);
    this.adXm = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, this.JMj);
    this.sJv = this.mContext.getResources().getDisplayMetrics().widthPixels;
    this.pvg = this.mContext.getResources().getDisplayMetrics().heightPixels;
    this.JMm = new v(this.adUp, this.adXm, this.adXm);
    this.JMn = ((TextView)this.adUp.findViewById(a.g.show_head_toast_text));
    this.textColor = bd.bz(this.mContext, a.c.Alphabet_text_color);
    this.adXk = this.mContext.getResources().getColor(a.d.white_text_color);
    this.backgroundColor = paramContext.getResources().getColor(a.d.wechat_green);
    this.adXl = bd.fromDPToPix(getContext(), 7);
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    int i = (int)(a.bs(this.mContext, a.e.DefaultTabbarHeight) * a.jO(this.mContext));
    this.maxHeight = (Math.max(this.pvg, this.sJv) - bf.fs(this.mContext) - bf.getStatusBarHeight(this.mContext) - bf.bk(this.mContext) - i);
    this.adTS = ((int)(this.maxHeight / (this.JMk.length * this.JMi)));
  }
  
  protected void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, Paint paramPaint, int paramInt)
  {
    paramCanvas.drawCircle(paramFloat1, paramFloat2, paramFloat3, paramPaint);
  }
  
  protected void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, Paint paramPaint, int paramInt, boolean paramBoolean)
  {
    paramCanvas.drawText(this.JMk[paramInt], paramFloat1, paramFloat2, paramPaint);
  }
  
  protected abstract void aNw();
  
  protected void bzZ(String paramString)
  {
    this.JMn.setText(paramString);
  }
  
  protected abstract int getToastLayoutId();
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    final int i = getMeasuredHeight();
    final int j = getMeasuredWidth();
    int k = bd.fromDPToPix(getContext(), 9);
    this.textSize = bd.fromDPToPix(getContext(), 11);
    float f;
    label80:
    label234:
    boolean bool;
    if (this.textSize > this.adTS)
    {
      f = this.adTS;
      this.textSize = f;
      if (this.textSize >= k) {
        break label343;
      }
      f = k;
      this.textSize = f;
      this.paint.setTextSize(this.textSize);
      if (this.JMl != this.textSize)
      {
        this.JMl = this.textSize;
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(142456);
            if (VerticalScrollBar.this.JMk.length <= 0)
            {
              AppMethodBeat.o(142456);
              return;
            }
            int i = (int)VerticalScrollBar.a(VerticalScrollBar.this).measureText(VerticalScrollBar.this.JMk[(VerticalScrollBar.this.JMk.length - 1)]);
            int k = a.fromDPToPix(VerticalScrollBar.this.getContext(), 16) + i;
            int j = (int)(VerticalScrollBar.this.JMk.length * VerticalScrollBar.this.textSize * VerticalScrollBar.this.JMi);
            Log.i("MicroMsg.VerticalScrollBar", "onDraw newHeight:%s, viewHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
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
      if ((this.RAE) && (this.dbk != 0))
      {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.backgroundColor);
        a(paramCanvas, j / 2.0F, this.textSize / 2.0F + this.dbk * this.textSize * this.JMi + bd.fromDPToPix(this.mContext, 1), this.adXl, this.paint, this.dbk);
      }
      this.paint.setTextAlign(Paint.Align.CENTER);
      i = 0;
      if (i >= this.JMk.length) {
        return;
      }
      if ((!this.RAE) || (this.dbk != i)) {
        break label351;
      }
      bool = true;
      label261:
      if ((!this.RAE) || (this.dbk == 0) || (this.dbk != i)) {
        break label357;
      }
      this.paint.setColor(this.adXk);
    }
    for (;;)
    {
      a(paramCanvas, j / 2, this.textSize + i * this.textSize * this.JMi, this.paint, i, bool);
      i += 1;
      break label234;
      f = this.textSize;
      break;
      label343:
      f = this.textSize;
      break label80;
      label351:
      bool = false;
      break label261;
      label357:
      this.paint.setColor(this.textColor);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 2))
    {
      this.RAE = true;
      this.mkn = paramMotionEvent.getY();
      if (this.mkn < 0.0F) {
        this.mkn = 0.0F;
      }
      if (this.mkn > getMeasuredHeight()) {
        this.mkn = getMeasuredHeight();
      }
      int j = (int)(this.mkn / (this.textSize * this.JMi));
      int i = j;
      if (j >= this.JMk.length) {
        i = this.JMk.length - 1;
      }
      this.dbk = i;
      if (this.dbk != -1) {
        break label304;
      }
      bzZ(getResources().getString(a.k.scroll_bar_search));
      i = this.sJv - bd.fromDPToPix(getContext(), 120);
      int[] arrayOfInt = new int[2];
      getLocationInWindow(arrayOfInt);
      j = (int)(this.textSize / 2.0F + this.dbk * this.textSize * this.JMi - this.adXm / 2.0D + arrayOfInt[1]);
      if (paramMotionEvent.getAction() == 0) {
        this.JMm.showAtLocation(this, 0, i, j);
      }
      if (paramMotionEvent.getAction() == 2) {
        this.JMm.update(i, j, this.adXm, this.adXm);
      }
      if (this.adXj != null)
      {
        if (this.dbk != -1) {
          break label320;
        }
        this.adXj.onScollBarTouch(a.bt(getContext(), a.k.scroll_bar_search));
      }
    }
    for (;;)
    {
      invalidate();
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        this.JMm.dismiss();
        this.RAE = false;
      }
      return true;
      label304:
      bzZ(this.JMk[this.dbk]);
      break;
      label320:
      this.adXj.onScollBarTouch(this.JMk[this.dbk]);
    }
  }
  
  public void setOnScrollBarTouchListener(VerticalScrollBar.a parama)
  {
    this.adXj = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.VerticalScrollBar
 * JD-Core Version:    0.7.0.1
 */