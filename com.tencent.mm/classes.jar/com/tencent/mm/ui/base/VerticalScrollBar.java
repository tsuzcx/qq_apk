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
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;

public abstract class VerticalScrollBar
  extends View
{
  View JIY;
  private boolean JLO = false;
  public a JLP;
  private int JLQ;
  private int JLR;
  private int JLS;
  private int JLT = 0;
  private int backgroundColor;
  private int bxN;
  private float gph;
  private int lxZ;
  private int lya;
  private Context mContext;
  private int maxHeight;
  private Paint paint;
  private int textColor;
  private float textSize;
  private TextView vcA;
  private int vcB;
  protected float vcv;
  protected int vcw;
  protected String[] vcx;
  private float vcy = 0.0F;
  private o vcz;
  
  public VerticalScrollBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ZA();
    this.mContext = paramContext;
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.vcB = BackwardSupportUtil.b.h(paramContext, 3.0F);
    this.JIY = inflate(paramContext, getToastLayoutId(), null);
    this.JLS = BackwardSupportUtil.b.h(paramContext, this.vcw);
    this.lxZ = this.mContext.getResources().getDisplayMetrics().widthPixels;
    this.lya = this.mContext.getResources().getDisplayMetrics().heightPixels;
    this.vcz = new o(this.JIY, this.JLS, this.JLS);
    this.vcA = ((TextView)this.JIY.findViewById(2131304779));
    this.textColor = aq.aN(this.mContext, 2130968576);
    this.JLQ = this.mContext.getResources().getColor(2131101182);
    this.backgroundColor = paramContext.getResources().getColor(2131101171);
    this.JLR = aq.fromDPToPix(getContext(), 7);
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    int i = (int)(a.ay(this.mContext, 2131165256) * a.ip(this.mContext));
    this.maxHeight = (Math.max(this.lya, this.lxZ) - ar.dX(this.mContext) - ar.jN(this.mContext) - ar.en(this.mContext) - i);
    this.JLT = ((int)(this.maxHeight / (this.vcx.length * this.vcv)));
  }
  
  protected abstract void ZA();
  
  protected abstract int getToastLayoutId();
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    final int i = getMeasuredHeight();
    final int j = getMeasuredWidth();
    int k = aq.fromDPToPix(getContext(), 9);
    this.textSize = aq.fromDPToPix(getContext(), 11);
    float f;
    if (this.textSize > this.JLT)
    {
      f = this.JLT;
      this.textSize = f;
      if (this.textSize >= k) {
        break label322;
      }
      f = k;
      label80:
      this.textSize = f;
      this.paint.setTextSize(this.textSize);
      if (this.vcy != this.textSize)
      {
        this.vcy = this.textSize;
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(142456);
            if (VerticalScrollBar.this.vcx.length <= 0)
            {
              AppMethodBeat.o(142456);
              return;
            }
            int i = (int)VerticalScrollBar.a(VerticalScrollBar.this).measureText(VerticalScrollBar.this.vcx[(VerticalScrollBar.this.vcx.length - 1)]);
            int k = a.fromDPToPix(VerticalScrollBar.this.getContext(), 16) + i;
            int j = (int)(VerticalScrollBar.this.vcx.length * VerticalScrollBar.b(VerticalScrollBar.this) * VerticalScrollBar.this.vcv);
            ae.i("MicroMsg.VerticalScrollBar", "onDraw newHeight:%s, viewHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
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
      if ((this.JLO) && (this.bxN != 0))
      {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.backgroundColor);
        paramCanvas.drawCircle(j / 2.0F, this.textSize / 2.0F + this.bxN * this.textSize * this.vcv + aq.fromDPToPix(this.mContext, 1), this.JLR, this.paint);
      }
      this.paint.setTextAlign(Paint.Align.CENTER);
      i = 0;
      label229:
      if (i >= this.vcx.length) {
        return;
      }
      if ((!this.JLO) || (this.bxN == 0) || (this.bxN != i)) {
        break label330;
      }
      this.paint.setColor(this.JLQ);
    }
    for (;;)
    {
      paramCanvas.drawText(this.vcx[i], j / 2.0F, this.textSize + i * this.textSize * this.vcv, this.paint);
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
      this.JLO = true;
      this.gph = paramMotionEvent.getY();
      if (this.gph < 0.0F) {
        this.gph = 0.0F;
      }
      if (this.gph > getMeasuredHeight()) {
        this.gph = getMeasuredHeight();
      }
      int j = (int)(this.gph / (this.textSize * this.vcv));
      int i = j;
      if (j >= this.vcx.length) {
        i = this.vcx.length - 1;
      }
      this.bxN = i;
      if (this.bxN != -1) {
        break label294;
      }
      this.vcA.setText(2131762893);
      i = this.lxZ - aq.fromDPToPix(getContext(), 120);
      j = (int)(this.textSize / 2.0F + this.bxN * this.textSize * this.vcv - this.JLS / 2.0D + (paramMotionEvent.getRawY() - paramMotionEvent.getY()));
      if (paramMotionEvent.getAction() == 0) {
        this.vcz.showAtLocation(this, 0, i, j);
      }
      if (paramMotionEvent.getAction() == 2) {
        this.vcz.update(i, j, this.JLS, this.JLS);
      }
      if (this.JLP != null)
      {
        if (this.bxN != -1) {
          break label313;
        }
        this.JLP.vy(a.az(getContext(), 2131762893));
      }
    }
    for (;;)
    {
      invalidate();
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        this.vcz.dismiss();
        this.JLO = false;
      }
      return true;
      label294:
      this.vcA.setText(this.vcx[this.bxN]);
      break;
      label313:
      this.JLP.vy(this.vcx[this.bxN]);
    }
  }
  
  public void setOnScrollBarTouchListener(a parama)
  {
    this.JLP = parama;
  }
  
  public static abstract interface a
  {
    public abstract void vy(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.VerticalScrollBar
 * JD-Core Version:    0.7.0.1
 */