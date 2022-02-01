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
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;

public abstract class VerticalScrollBar
  extends View
{
  protected float DUZ;
  protected int DVa;
  protected String[] DVb;
  protected float DVc = 0.0F;
  private r DVd;
  protected TextView DVe;
  private int DVf;
  private int WmF = 0;
  protected View Wnb;
  private boolean WpW = false;
  public a WpX;
  protected int WpY;
  protected int WpZ;
  private int Wqa;
  protected int backgroundColor;
  private int bhr;
  private float jLb;
  private Context mContext;
  private int maxHeight;
  private int pEj;
  private int pEk;
  private Paint paint;
  protected int textColor;
  protected float textSize;
  
  public VerticalScrollBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    atp();
    this.mContext = paramContext;
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.DVf = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 3.0F);
    this.Wnb = inflate(paramContext, getToastLayoutId(), null);
    this.Wqa = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, this.DVa);
    this.pEj = this.mContext.getResources().getDisplayMetrics().widthPixels;
    this.pEk = this.mContext.getResources().getDisplayMetrics().heightPixels;
    this.DVd = new r(this.Wnb, this.Wqa, this.Wqa);
    this.DVe = ((TextView)this.Wnb.findViewById(a.g.show_head_toast_text));
    this.textColor = aw.bg(this.mContext, a.c.Alphabet_text_color);
    this.WpY = this.mContext.getResources().getColor(a.d.white_text_color);
    this.backgroundColor = paramContext.getResources().getColor(a.d.wechat_green);
    this.WpZ = aw.fromDPToPix(getContext(), 7);
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    int i = (int)(a.aZ(this.mContext, a.e.DefaultTabbarHeight) * a.km(this.mContext));
    this.maxHeight = (Math.max(this.pEk, this.pEj) - ax.ew(this.mContext) - ax.getStatusBarHeight(this.mContext) - ax.aB(this.mContext) - i);
    this.WmF = ((int)(this.maxHeight / (this.DVb.length * this.DUZ)));
  }
  
  protected void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, Paint paramPaint, int paramInt)
  {
    paramCanvas.drawCircle(paramFloat1, paramFloat2, paramFloat3, paramPaint);
  }
  
  protected void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, Paint paramPaint, int paramInt, boolean paramBoolean)
  {
    paramCanvas.drawText(this.DVb[paramInt], paramFloat1, paramFloat2, paramPaint);
  }
  
  protected abstract void atp();
  
  protected void byB(String paramString)
  {
    this.DVe.setText(paramString);
  }
  
  protected abstract int getToastLayoutId();
  
  public final void hKy()
  {
    this.WpX = null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    final int i = getMeasuredHeight();
    final int j = getMeasuredWidth();
    int k = aw.fromDPToPix(getContext(), 9);
    this.textSize = aw.fromDPToPix(getContext(), 11);
    float f;
    label80:
    label234:
    boolean bool;
    if (this.textSize > this.WmF)
    {
      f = this.WmF;
      this.textSize = f;
      if (this.textSize >= k) {
        break label343;
      }
      f = k;
      this.textSize = f;
      this.paint.setTextSize(this.textSize);
      if (this.DVc != this.textSize)
      {
        this.DVc = this.textSize;
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(142456);
            if (VerticalScrollBar.this.DVb.length <= 0)
            {
              AppMethodBeat.o(142456);
              return;
            }
            int i = (int)VerticalScrollBar.a(VerticalScrollBar.this).measureText(VerticalScrollBar.this.DVb[(VerticalScrollBar.this.DVb.length - 1)]);
            int k = a.fromDPToPix(VerticalScrollBar.this.getContext(), 16) + i;
            int j = (int)(VerticalScrollBar.this.DVb.length * VerticalScrollBar.this.textSize * VerticalScrollBar.this.DUZ);
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
      if ((this.WpW) && (this.bhr != 0))
      {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.backgroundColor);
        a(paramCanvas, j / 2.0F, this.textSize / 2.0F + this.bhr * this.textSize * this.DUZ + aw.fromDPToPix(this.mContext, 1), this.WpZ, this.paint, this.bhr);
      }
      this.paint.setTextAlign(Paint.Align.CENTER);
      i = 0;
      if (i >= this.DVb.length) {
        return;
      }
      if ((!this.WpW) || (this.bhr != i)) {
        break label351;
      }
      bool = true;
      label261:
      if ((!this.WpW) || (this.bhr == 0) || (this.bhr != i)) {
        break label357;
      }
      this.paint.setColor(this.WpY);
    }
    for (;;)
    {
      a(paramCanvas, j / 2, this.textSize + i * this.textSize * this.DUZ, this.paint, i, bool);
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
      this.WpW = true;
      this.jLb = paramMotionEvent.getY();
      if (this.jLb < 0.0F) {
        this.jLb = 0.0F;
      }
      if (this.jLb > getMeasuredHeight()) {
        this.jLb = getMeasuredHeight();
      }
      int j = (int)(this.jLb / (this.textSize * this.DUZ));
      int i = j;
      if (j >= this.DVb.length) {
        i = this.DVb.length - 1;
      }
      this.bhr = i;
      if (this.bhr != -1) {
        break label304;
      }
      byB(getResources().getString(a.k.scroll_bar_search));
      i = this.pEj - aw.fromDPToPix(getContext(), 120);
      int[] arrayOfInt = new int[2];
      getLocationInWindow(arrayOfInt);
      j = (int)(this.textSize / 2.0F + this.bhr * this.textSize * this.DUZ - this.Wqa / 2.0D + arrayOfInt[1]);
      if (paramMotionEvent.getAction() == 0) {
        this.DVd.showAtLocation(this, 0, i, j);
      }
      if (paramMotionEvent.getAction() == 2) {
        this.DVd.update(i, j, this.Wqa, this.Wqa);
      }
      if (this.WpX != null)
      {
        if (this.bhr != -1) {
          break label320;
        }
        this.WpX.KH(a.ba(getContext(), a.k.scroll_bar_search));
      }
    }
    for (;;)
    {
      invalidate();
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        this.DVd.dismiss();
        this.WpW = false;
      }
      return true;
      label304:
      byB(this.DVb[this.bhr]);
      break;
      label320:
      this.WpX.KH(this.DVb[this.bhr]);
    }
  }
  
  public void setOnScrollBarTouchListener(a parama)
  {
    this.WpX = parama;
  }
  
  public static abstract interface a
  {
    public abstract void KH(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.VerticalScrollBar
 * JD-Core Version:    0.7.0.1
 */