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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;

public abstract class VerticalScrollBar
  extends View
{
  View Joj;
  private boolean JqZ = false;
  public a Jra;
  private int Jrb;
  private int Jrc;
  private int Jrd;
  private int Jre = 0;
  private int backgroundColor;
  private int bxN;
  private float gmL;
  private int ltA;
  private int ltB;
  private Context mContext;
  private int maxHeight;
  private Paint paint;
  private int textColor;
  private float textSize;
  protected float uQJ;
  protected int uQK;
  protected String[] uQL;
  private float uQM = 0.0F;
  private o uQN;
  private TextView uQO;
  private int uQP;
  
  public VerticalScrollBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Zr();
    this.mContext = paramContext;
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.uQP = BackwardSupportUtil.b.g(paramContext, 3.0F);
    this.Joj = inflate(paramContext, getToastLayoutId(), null);
    this.Jrd = BackwardSupportUtil.b.g(paramContext, this.uQK);
    this.ltA = this.mContext.getResources().getDisplayMetrics().widthPixels;
    this.ltB = this.mContext.getResources().getDisplayMetrics().heightPixels;
    this.uQN = new o(this.Joj, this.Jrd, this.Jrd);
    this.uQO = ((TextView)this.Joj.findViewById(2131304779));
    this.textColor = aq.aN(this.mContext, 2130968576);
    this.Jrb = this.mContext.getResources().getColor(2131101182);
    this.backgroundColor = paramContext.getResources().getColor(2131101171);
    this.Jrc = aq.fromDPToPix(getContext(), 7);
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    int i = (int)(a.ay(this.mContext, 2131165256) * a.ik(this.mContext));
    this.maxHeight = (Math.max(this.ltB, this.ltA) - ar.dT(this.mContext) - ar.jG(this.mContext) - ar.ej(this.mContext) - i);
    this.Jre = ((int)(this.maxHeight / (this.uQL.length * this.uQJ)));
  }
  
  protected abstract void Zr();
  
  protected abstract int getToastLayoutId();
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    final int i = getMeasuredHeight();
    final int j = getMeasuredWidth();
    int k = aq.fromDPToPix(getContext(), 9);
    this.textSize = aq.fromDPToPix(getContext(), 11);
    float f;
    if (this.textSize > this.Jre)
    {
      f = this.Jre;
      this.textSize = f;
      if (this.textSize >= k) {
        break label322;
      }
      f = k;
      label80:
      this.textSize = f;
      this.paint.setTextSize(this.textSize);
      if (this.uQM != this.textSize)
      {
        this.uQM = this.textSize;
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(142456);
            if (VerticalScrollBar.this.uQL.length <= 0)
            {
              AppMethodBeat.o(142456);
              return;
            }
            int i = (int)VerticalScrollBar.a(VerticalScrollBar.this).measureText(VerticalScrollBar.this.uQL[(VerticalScrollBar.this.uQL.length - 1)]);
            int k = a.fromDPToPix(VerticalScrollBar.this.getContext(), 16) + i;
            int j = (int)(VerticalScrollBar.this.uQL.length * VerticalScrollBar.b(VerticalScrollBar.this) * VerticalScrollBar.this.uQJ);
            ad.i("MicroMsg.VerticalScrollBar", "onDraw newHeight:%s, viewHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
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
      if ((this.JqZ) && (this.bxN != 0))
      {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.backgroundColor);
        paramCanvas.drawCircle(j / 2.0F, this.textSize / 2.0F + this.bxN * this.textSize * this.uQJ + aq.fromDPToPix(this.mContext, 1), this.Jrc, this.paint);
      }
      this.paint.setTextAlign(Paint.Align.CENTER);
      i = 0;
      label229:
      if (i >= this.uQL.length) {
        return;
      }
      if ((!this.JqZ) || (this.bxN == 0) || (this.bxN != i)) {
        break label330;
      }
      this.paint.setColor(this.Jrb);
    }
    for (;;)
    {
      paramCanvas.drawText(this.uQL[i], j / 2.0F, this.textSize + i * this.textSize * this.uQJ, this.paint);
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
      this.JqZ = true;
      this.gmL = paramMotionEvent.getY();
      if (this.gmL < 0.0F) {
        this.gmL = 0.0F;
      }
      if (this.gmL > getMeasuredHeight()) {
        this.gmL = getMeasuredHeight();
      }
      int j = (int)(this.gmL / (this.textSize * this.uQJ));
      int i = j;
      if (j >= this.uQL.length) {
        i = this.uQL.length - 1;
      }
      this.bxN = i;
      if (this.bxN != -1) {
        break label294;
      }
      this.uQO.setText(2131762893);
      i = this.ltA - aq.fromDPToPix(getContext(), 120);
      j = (int)(this.textSize / 2.0F + this.bxN * this.textSize * this.uQJ - this.Jrd / 2.0D + (paramMotionEvent.getRawY() - paramMotionEvent.getY()));
      if (paramMotionEvent.getAction() == 0) {
        this.uQN.showAtLocation(this, 0, i, j);
      }
      if (paramMotionEvent.getAction() == 2) {
        this.uQN.update(i, j, this.Jrd, this.Jrd);
      }
      if (this.Jra != null)
      {
        if (this.bxN != -1) {
          break label313;
        }
        this.Jra.vc(a.az(getContext(), 2131762893));
      }
    }
    for (;;)
    {
      invalidate();
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        this.uQN.dismiss();
        this.JqZ = false;
      }
      return true;
      label294:
      this.uQO.setText(this.uQL[this.bxN]);
      break;
      label313:
      this.Jra.vc(this.uQL[this.bxN]);
    }
  }
  
  public void setOnScrollBarTouchListener(a parama)
  {
    this.Jra = parama;
  }
  
  public static abstract interface a
  {
    public abstract void vc(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.VerticalScrollBar
 * JD-Core Version:    0.7.0.1
 */