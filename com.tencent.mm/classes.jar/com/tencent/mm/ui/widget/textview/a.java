package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.text.Layout;
import android.text.Spannable;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.c;

public final class a
{
  public boolean cbz = true;
  TextView lh;
  Context mContext;
  private int[] pls = new int[2];
  ViewTreeObserver.OnPreDrawListener qS;
  ViewTreeObserver.OnScrollChangedListener wsj;
  public b wsk;
  public b wsl;
  a.d wsm = new a.d(this);
  public a.c wsn;
  Spannable wso;
  com.tencent.mm.ui.widget.b.a wsp;
  int wsq;
  int wsr;
  private int wss;
  int wst;
  int wsu;
  private c wsv;
  boolean wsw;
  final Runnable wsx = new a.1(this);
  
  public a(a.a parama)
  {
    this.lh = parama.lh;
    this.wsp = parama.wsz;
    this.mContext = this.lh.getContext();
    this.wss = parama.wss;
    this.wst = parama.wst;
    this.wsu = ap.fromDPToPix(this.mContext, parama.wsA);
    this.lh.setText(this.lh.getText(), TextView.BufferType.SPANNABLE);
    this.lh.setOnLongClickListener(new a.2(this));
    this.lh.setOnTouchListener(new a.3(this));
    this.lh.setOnClickListener(new a.4(this));
    this.lh.addOnAttachStateChangeListener(new a.5(this));
    this.qS = new a.6(this);
    this.lh.getViewTreeObserver().addOnPreDrawListener(this.qS);
    this.wsj = new ViewTreeObserver.OnScrollChangedListener()
    {
      public final void onScrollChanged()
      {
        if ((!a.this.wsw) && (!a.this.cbz))
        {
          a.this.wsw = true;
          if (a.this.wsp != null) {
            a.this.wsp.cCw();
          }
          if (a.this.wsk != null) {
            a.this.wsk.wsB.dismiss();
          }
          if (a.this.wsl != null) {
            a.this.wsl.wsB.dismiss();
          }
        }
      }
    };
    this.lh.getViewTreeObserver().addOnScrollChangedListener(this.wsj);
  }
  
  public final void a(b paramb)
  {
    Object localObject = this.lh.getLayout();
    int i;
    int j;
    if (b.b(paramb))
    {
      i = this.wsm.aiH;
      if (localObject == null) {
        break label172;
      }
      j = (int)((Layout)localObject).getPaint().getFontMetrics().descent + ((Layout)localObject).getLineBaseline(((Layout)localObject).getLineForOffset(i));
      i = (int)((Layout)localObject).getPrimaryHorizontal(i);
    }
    for (;;)
    {
      paramb.wsy.lh.getLocationInWindow(paramb.wsH);
      if (paramb.wsC) {}
      for (int k = paramb.mWidth;; k = 0)
      {
        int n = i;
        int m = j;
        if (!paramb.wsC)
        {
          localObject = paramb.fQ(i, j);
          n = localObject[0];
          m = localObject[1];
        }
        paramb.wsB.showAtLocation(paramb.wsy.lh, 0, n - k + paramb.getExtraX(), m + paramb.getExtraY());
        return;
        i = this.wsm.Eo;
        break;
      }
      label172:
      i = 0;
      j = 0;
    }
  }
  
  public final void cKI()
  {
    this.cbz = true;
    if (this.wsk != null) {
      this.wsk.wsB.dismiss();
    }
    if (this.wsl != null) {
      this.wsl.wsB.dismiss();
    }
    if (this.wsp != null) {
      this.wsp.cCw();
    }
  }
  
  public final void cKJ()
  {
    this.wsm.wsI = null;
    if ((this.wso != null) && (this.wsv != null))
    {
      this.wso.removeSpan(this.wsv);
      this.wsv = null;
    }
  }
  
  public final void cKK()
  {
    int j = 16;
    int k;
    int i;
    if (this.wsp != null)
    {
      this.lh.getLocationInWindow(this.pls);
      Layout localLayout = this.lh.getLayout();
      int m = (int)localLayout.getPrimaryHorizontal(this.wsm.aiH) + this.pls[0];
      k = localLayout.getLineTop(localLayout.getLineForOffset(this.wsm.aiH)) + this.pls[1] - 16;
      i = m;
      if (m <= 0) {
        i = 16;
      }
      if (k >= 0) {
        break label131;
      }
    }
    for (;;)
    {
      if (i > b.getScreenWidth(this.mContext)) {
        i = b.getScreenWidth(this.mContext) - 16;
      }
      for (;;)
      {
        this.wsp.ch(i, j);
        return;
      }
      label131:
      j = k;
    }
  }
  
  public final void fP(int paramInt1, int paramInt2)
  {
    if (paramInt1 != -1) {
      this.wsm.aiH = paramInt1;
    }
    if (paramInt2 != -1) {
      this.wsm.Eo = paramInt2;
    }
    if (this.wsm.aiH > this.wsm.Eo)
    {
      paramInt1 = this.wsm.aiH;
      this.wsm.aiH = this.wsm.Eo;
      this.wsm.Eo = paramInt1;
    }
    if (this.wso != null)
    {
      this.wsm.wsI = this.wso.subSequence(this.wsm.aiH, this.wsm.Eo).toString();
      if (this.wsv == null) {
        this.wsv = new c(this.lh, this.mContext.getResources().getColor(this.wss), this.wsm.aiH, this.wsm.Eo);
      }
      if (this.wsv != null)
      {
        localObject = this.wsv;
        paramInt1 = this.wsm.aiH;
        paramInt2 = this.wsm.Eo;
        ((c)localObject).start = paramInt1;
        ((c)localObject).end = paramInt2;
      }
      Object localObject = this.lh.getLayout();
      paramInt1 = ((Layout)localObject).getLineStart(((Layout)localObject).getLineForOffset(this.wsm.aiH));
      this.wso.setSpan(this.wsv, paramInt1, this.wsm.Eo, 17);
      if (this.wsn != null) {
        this.wsn.P(this.wsm.wsI);
      }
    }
  }
  
  private final class b
    extends View
  {
    private int dsI = 25;
    private int mHeight = this.rJp * 2;
    private Paint mPaint;
    int mWidth = this.rJp * 2;
    private int rJp = a.this.wsu / 2;
    public PopupWindow wsB;
    boolean wsC;
    private int wsD;
    private int wsE;
    private int wsF;
    private int wsG;
    int[] wsH = new int[2];
    
    b(boolean paramBoolean)
    {
      super();
      this.wsC = paramBoolean;
      this.mPaint = new Paint(1);
      this.mPaint.setColor(a.this.mContext.getResources().getColor(a.this.wst));
      this.wsB = new PopupWindow(this);
      this.wsB.setClippingEnabled(false);
      this.wsB.setWidth(this.mWidth + this.dsI * 2);
      this.wsB.setHeight(this.mHeight + this.dsI / 2);
      invalidate();
    }
    
    private void cKL()
    {
      if (!this.wsC) {}
      for (boolean bool = true;; bool = false)
      {
        this.wsC = bool;
        invalidate();
        return;
      }
    }
    
    private void cKM()
    {
      a.this.lh.getLocationInWindow(this.wsH);
      Object localObject = a.this.lh.getLayout();
      if (localObject != null)
      {
        i = (int)((Layout)localObject).getPaint().getFontMetrics().descent;
        if (this.wsC) {
          this.wsB.update((int)((Layout)localObject).getPrimaryHorizontal(a.this.wsm.aiH) - this.mWidth + getExtraX(), ((Layout)localObject).getLineBaseline(((Layout)localObject).getLineForOffset(a.this.wsm.aiH)) + i + getExtraY(), -1, -1);
        }
      }
      else
      {
        return;
      }
      localObject = fQ((int)((Layout)localObject).getPrimaryHorizontal(a.this.wsm.Eo), ((Layout)localObject).getLineBaseline(((Layout)localObject).getLineForOffset(a.this.wsm.Eo)) + i);
      int i = localObject[0];
      int j = localObject[1];
      this.wsB.update(i + getExtraX(), j + getExtraY(), -1, -1);
    }
    
    final int[] fQ(int paramInt1, int paramInt2)
    {
      int j = paramInt1;
      int i = paramInt2;
      if (paramInt1 == 0)
      {
        j = paramInt1;
        i = paramInt2;
        if (a.this.wsm.Eo > 1)
        {
          a.this.lh.getLocationInWindow(this.wsH);
          Layout localLayout = a.this.lh.getLayout();
          j = paramInt1;
          i = paramInt2;
          if (localLayout != null)
          {
            paramInt1 = (int)localLayout.getPaint().getFontMetrics().descent;
            j = (int)localLayout.getLineWidth(localLayout.getLineForOffset(a.this.wsm.Eo - 1));
            i = localLayout.getLineBaseline(localLayout.getLineForOffset(a.this.wsm.Eo - 1)) + paramInt1;
          }
        }
      }
      return new int[] { j, i };
    }
    
    public final int getExtraX()
    {
      return this.wsH[0] - this.dsI + a.this.lh.getPaddingLeft();
    }
    
    public final int getExtraY()
    {
      return this.wsH[1] + a.this.lh.getPaddingTop();
    }
    
    protected final void onDraw(Canvas paramCanvas)
    {
      paramCanvas.drawCircle(this.rJp + this.dsI, this.rJp, this.rJp, this.mPaint);
      if (this.wsC)
      {
        paramCanvas.drawRect(this.rJp + this.dsI, 0.0F, this.rJp * 2 + this.dsI, this.rJp, this.mPaint);
        return;
      }
      paramCanvas.drawRect(this.dsI, 0.0F, this.rJp + this.dsI, this.rJp, this.mPaint);
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getAction())
      {
      default: 
        return true;
      case 0: 
        this.wsF = a.this.wsm.aiH;
        this.wsG = a.this.wsm.Eo;
        this.wsD = ((int)paramMotionEvent.getX());
        this.wsE = ((int)paramMotionEvent.getY());
        return true;
      case 1: 
      case 3: 
        a.this.cKK();
        return true;
      }
      a.this.wsp.cCw();
      int i = (int)paramMotionEvent.getRawX();
      int j = (int)paramMotionEvent.getRawY();
      int n = i + this.wsD - this.mWidth;
      int k = this.wsE;
      int m = this.mHeight;
      a.this.lh.getLocationInWindow(this.wsH);
      if (this.wsC) {}
      int i1;
      Layout localLayout;
      for (i = a.this.wsm.aiH;; i = a.this.wsm.Eo)
      {
        i1 = k + j - m - this.wsH[1];
        paramMotionEvent = a.this.lh;
        localLayout = paramMotionEvent.getLayout();
        if (localLayout != null) {
          break;
        }
        j = -1;
        label212:
        if (j == i) {
          break label599;
        }
        a.this.cKJ();
        if (!this.wsC) {
          break label525;
        }
        if (j <= this.wsG) {
          break label513;
        }
        paramMotionEvent = a.a(a.this, false);
        cKL();
        paramMotionEvent.cKL();
        this.wsF = this.wsG;
        a.this.fP(this.wsG, j);
        paramMotionEvent.cKM();
        label280:
        cKM();
        return true;
      }
      k = localLayout.getLineForVertical(i1);
      if (b.a(localLayout, i))
      {
        j = (int)localLayout.getPrimaryHorizontal(i - 1);
        m = (int)localLayout.getLineRight(k);
        if (n <= m - (m - j) / 2) {}
      }
      for (j = i - 1;; j = i)
      {
        m = localLayout.getLineForOffset(j);
        int i2 = localLayout.getLineTop(m);
        int i3 = localLayout.getLineBottom(m);
        int i4 = (i3 - i2) / 2;
        if (k == m + 1)
        {
          j = m;
          if (i1 - i3 < i4) {}
        }
        else
        {
          if ((k != m - 1) || (i2 - i1 >= i4)) {
            break label601;
          }
        }
        label513:
        label525:
        label599:
        label601:
        for (j = m;; j = k)
        {
          k = localLayout.getOffsetForHorizontal(j, n);
          if ((k < paramMotionEvent.getText().length() - 1) && (b.a(localLayout, k + 1)))
          {
            m = (int)localLayout.getPrimaryHorizontal(k);
            j = (int)localLayout.getLineRight(j);
            if (n > j - (j - m) / 2)
            {
              j = k + 1;
              break label212;
              a.this.fP(j, -1);
              break label280;
              if (j < this.wsF)
              {
                paramMotionEvent = a.a(a.this, true);
                paramMotionEvent.cKL();
                cKL();
                this.wsG = this.wsF;
                a.this.fP(j, this.wsF);
                paramMotionEvent.cKM();
              }
              for (;;)
              {
                cKM();
                return true;
                a.this.fP(this.wsF, j);
              }
            }
          }
          j = k;
          break label212;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a
 * JD-Core Version:    0.7.0.1
 */