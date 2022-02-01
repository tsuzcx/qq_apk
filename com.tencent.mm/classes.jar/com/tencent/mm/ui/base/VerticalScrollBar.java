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
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;

public abstract class VerticalScrollBar
  extends View
{
  View GaE;
  private boolean Gdu = false;
  public VerticalScrollBar.a Gdv;
  private int Gdw;
  private int Gdx;
  private int Gdy;
  private int Gdz = 0;
  private int backgroundColor;
  private int boX;
  private float fPm;
  private int kvn;
  private int kvo;
  private Context mContext;
  private int maxHeight;
  private Paint paint;
  protected float sGp;
  protected int sGq;
  protected String[] sGr;
  private float sGs = 0.0F;
  private o sGt;
  private TextView sGu;
  private int sGv;
  private int textColor;
  private float textSize;
  
  public VerticalScrollBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Wa();
    this.mContext = paramContext;
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.sGv = BackwardSupportUtil.b.g(paramContext, 3.0F);
    this.GaE = inflate(paramContext, getToastLayoutId(), null);
    this.Gdy = BackwardSupportUtil.b.g(paramContext, this.sGq);
    this.kvn = this.mContext.getResources().getDisplayMetrics().widthPixels;
    this.kvo = this.mContext.getResources().getDisplayMetrics().heightPixels;
    this.sGt = new o(this.GaE, this.Gdy, this.Gdy);
    this.sGu = ((TextView)this.GaE.findViewById(2131304779));
    this.textColor = ao.aD(this.mContext, 2130968576);
    this.Gdw = this.mContext.getResources().getColor(2131101182);
    this.backgroundColor = paramContext.getResources().getColor(2131101171);
    this.Gdx = ao.fromDPToPix(getContext(), 7);
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    int i = (int)(a.ap(this.mContext, 2131165256) * a.hQ(this.mContext));
    this.maxHeight = (Math.max(this.kvo, this.kvn) - ap.dL(this.mContext) - ap.iX(this.mContext) - ap.eb(this.mContext) - i);
    this.Gdz = ((int)(this.maxHeight / (this.sGr.length * this.sGp)));
  }
  
  protected abstract void Wa();
  
  protected abstract int getToastLayoutId();
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    final int i = getMeasuredHeight();
    final int j = getMeasuredWidth();
    int k = ao.fromDPToPix(getContext(), 9);
    this.textSize = ao.fromDPToPix(getContext(), 11);
    float f;
    if (this.textSize > this.Gdz)
    {
      f = this.Gdz;
      this.textSize = f;
      if (this.textSize >= k) {
        break label322;
      }
      f = k;
      label80:
      this.textSize = f;
      this.paint.setTextSize(this.textSize);
      if (this.sGs != this.textSize)
      {
        this.sGs = this.textSize;
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(142456);
            if (VerticalScrollBar.this.sGr.length <= 0)
            {
              AppMethodBeat.o(142456);
              return;
            }
            int i = (int)VerticalScrollBar.a(VerticalScrollBar.this).measureText(VerticalScrollBar.this.sGr[(VerticalScrollBar.this.sGr.length - 1)]);
            int k = a.fromDPToPix(VerticalScrollBar.this.getContext(), 16) + i;
            int j = (int)(VerticalScrollBar.this.sGr.length * VerticalScrollBar.b(VerticalScrollBar.this) * VerticalScrollBar.this.sGp);
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
      if ((this.Gdu) && (this.boX != 0))
      {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.backgroundColor);
        paramCanvas.drawCircle(j / 2.0F, this.textSize / 2.0F + this.boX * this.textSize * this.sGp + ao.fromDPToPix(this.mContext, 1), this.Gdx, this.paint);
      }
      this.paint.setTextAlign(Paint.Align.CENTER);
      i = 0;
      label229:
      if (i >= this.sGr.length) {
        return;
      }
      if ((!this.Gdu) || (this.boX == 0) || (this.boX != i)) {
        break label330;
      }
      this.paint.setColor(this.Gdw);
    }
    for (;;)
    {
      paramCanvas.drawText(this.sGr[i], j / 2.0F, this.textSize + i * this.textSize * this.sGp, this.paint);
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
      this.Gdu = true;
      this.fPm = paramMotionEvent.getY();
      if (this.fPm < 0.0F) {
        this.fPm = 0.0F;
      }
      if (this.fPm > getMeasuredHeight()) {
        this.fPm = getMeasuredHeight();
      }
      int j = (int)(this.fPm / (this.textSize * this.sGp));
      int i = j;
      if (j >= this.sGr.length) {
        i = this.sGr.length - 1;
      }
      this.boX = i;
      if (this.boX != -1) {
        break label294;
      }
      this.sGu.setText(2131762893);
      i = this.kvn - ao.fromDPToPix(getContext(), 120);
      j = (int)(this.textSize / 2.0F + this.boX * this.textSize * this.sGp - this.Gdy / 2.0D + (paramMotionEvent.getRawY() - paramMotionEvent.getY()));
      if (paramMotionEvent.getAction() == 0) {
        this.sGt.showAtLocation(this, 0, i, j);
      }
      if (paramMotionEvent.getAction() == 2) {
        this.sGt.update(i, j, this.Gdy, this.Gdy);
      }
      if (this.Gdv != null)
      {
        if (this.boX != -1) {
          break label313;
        }
        this.Gdv.pb(a.aq(getContext(), 2131762893));
      }
    }
    for (;;)
    {
      invalidate();
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        this.sGt.dismiss();
        this.Gdu = false;
      }
      return true;
      label294:
      this.sGu.setText(this.sGr[this.boX]);
      break;
      label313:
      this.Gdv.pb(this.sGr[this.boX]);
    }
  }
  
  public void setOnScrollBarTouchListener(VerticalScrollBar.a parama)
  {
    this.Gdv = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.VerticalScrollBar
 * JD-Core Version:    0.7.0.1
 */