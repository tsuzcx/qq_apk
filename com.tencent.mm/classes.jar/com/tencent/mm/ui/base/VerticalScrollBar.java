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
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;

public abstract class VerticalScrollBar
  extends View
{
  View OTO;
  private boolean OWK = false;
  public a OWL;
  private int OWM;
  private int OWN;
  private int OWO;
  private int OWP = 0;
  private int backgroundColor;
  private int bxP;
  private float haa;
  private Context mContext;
  private int mEX;
  private int mEY;
  private int maxHeight;
  private Paint paint;
  private int textColor;
  private float textSize;
  protected float yuV;
  protected int yuW;
  protected String[] yuX;
  private float yuY = 0.0F;
  private p yuZ;
  private TextView yva;
  private int yvb;
  
  public VerticalScrollBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ann();
    this.mContext = paramContext;
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.yvb = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 3.0F);
    this.OTO = inflate(paramContext, getToastLayoutId(), null);
    this.OWO = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, this.yuW);
    this.mEX = this.mContext.getResources().getDisplayMetrics().widthPixels;
    this.mEY = this.mContext.getResources().getDisplayMetrics().heightPixels;
    this.yuZ = new p(this.OTO, this.OWO, this.OWO);
    this.yva = ((TextView)this.OTO.findViewById(2131307861));
    this.textColor = at.aO(this.mContext, 2130968576);
    this.OWM = this.mContext.getResources().getColor(2131101427);
    this.backgroundColor = paramContext.getResources().getColor(2131101414);
    this.OWN = at.fromDPToPix(getContext(), 7);
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    int i = (int)(a.aH(this.mContext, 2131165260) * a.ji(this.mContext));
    this.maxHeight = (Math.max(this.mEY, this.mEX) - au.eu(this.mContext) - au.getStatusBarHeight(this.mContext) - au.aD(this.mContext) - i);
    this.OWP = ((int)(this.maxHeight / (this.yuX.length * this.yuV)));
  }
  
  protected abstract void ann();
  
  protected abstract int getToastLayoutId();
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    final int i = getMeasuredHeight();
    final int j = getMeasuredWidth();
    int k = at.fromDPToPix(getContext(), 9);
    this.textSize = at.fromDPToPix(getContext(), 11);
    float f;
    if (this.textSize > this.OWP)
    {
      f = this.OWP;
      this.textSize = f;
      if (this.textSize >= k) {
        break label322;
      }
      f = k;
      label80:
      this.textSize = f;
      this.paint.setTextSize(this.textSize);
      if (this.yuY != this.textSize)
      {
        this.yuY = this.textSize;
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(142456);
            if (VerticalScrollBar.this.yuX.length <= 0)
            {
              AppMethodBeat.o(142456);
              return;
            }
            int i = (int)VerticalScrollBar.a(VerticalScrollBar.this).measureText(VerticalScrollBar.this.yuX[(VerticalScrollBar.this.yuX.length - 1)]);
            int k = a.fromDPToPix(VerticalScrollBar.this.getContext(), 16) + i;
            int j = (int)(VerticalScrollBar.this.yuX.length * VerticalScrollBar.b(VerticalScrollBar.this) * VerticalScrollBar.this.yuV);
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
      if ((this.OWK) && (this.bxP != 0))
      {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.backgroundColor);
        paramCanvas.drawCircle(j / 2.0F, this.textSize / 2.0F + this.bxP * this.textSize * this.yuV + at.fromDPToPix(this.mContext, 1), this.OWN, this.paint);
      }
      this.paint.setTextAlign(Paint.Align.CENTER);
      i = 0;
      label229:
      if (i >= this.yuX.length) {
        return;
      }
      if ((!this.OWK) || (this.bxP == 0) || (this.bxP != i)) {
        break label330;
      }
      this.paint.setColor(this.OWM);
    }
    for (;;)
    {
      paramCanvas.drawText(this.yuX[i], j / 2.0F, this.textSize + i * this.textSize * this.yuV, this.paint);
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
      this.OWK = true;
      this.haa = paramMotionEvent.getY();
      if (this.haa < 0.0F) {
        this.haa = 0.0F;
      }
      if (this.haa > getMeasuredHeight()) {
        this.haa = getMeasuredHeight();
      }
      int j = (int)(this.haa / (this.textSize * this.yuV));
      int i = j;
      if (j >= this.yuX.length) {
        i = this.yuX.length - 1;
      }
      this.bxP = i;
      if (this.bxP != -1) {
        break label294;
      }
      this.yva.setText(2131765029);
      i = this.mEX - at.fromDPToPix(getContext(), 120);
      j = (int)(this.textSize / 2.0F + this.bxP * this.textSize * this.yuV - this.OWO / 2.0D + (paramMotionEvent.getRawY() - paramMotionEvent.getY()));
      if (paramMotionEvent.getAction() == 0) {
        this.yuZ.showAtLocation(this, 0, i, j);
      }
      if (paramMotionEvent.getAction() == 2) {
        this.yuZ.update(i, j, this.OWO, this.OWO);
      }
      if (this.OWL != null)
      {
        if (this.bxP != -1) {
          break label313;
        }
        this.OWL.DP(a.aI(getContext(), 2131765029));
      }
    }
    for (;;)
    {
      invalidate();
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        this.yuZ.dismiss();
        this.OWK = false;
      }
      return true;
      label294:
      this.yva.setText(this.yuX[this.bxP]);
      break;
      label313:
      this.OWL.DP(this.yuX[this.bxP]);
    }
  }
  
  public void setOnScrollBarTouchListener(a parama)
  {
    this.OWL = parama;
  }
  
  public static abstract interface a
  {
    public abstract void DP(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.VerticalScrollBar
 * JD-Core Version:    0.7.0.1
 */