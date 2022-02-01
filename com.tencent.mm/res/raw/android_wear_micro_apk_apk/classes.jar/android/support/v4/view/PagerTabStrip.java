package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.TextView;

public class PagerTabStrip
  extends PagerTitleStrip
{
  private int lT = this.my;
  private int lU;
  private int lV;
  private int lW;
  private int lX;
  private int lY;
  private final Paint lZ = new Paint();
  private final Rect ma = new Rect();
  private int mb = 255;
  private boolean mc = false;
  private boolean md = false;
  private int me;
  private boolean mf;
  private float mg;
  private float mh;
  private int mi;
  
  public PagerTabStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.lZ.setColor(this.lT);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.lU = ((int)(3.0F * f + 0.5F));
    this.lV = ((int)(6.0F * f + 0.5F));
    this.lW = ((int)(64.0F * f));
    this.lY = ((int)(16.0F * f + 0.5F));
    this.me = ((int)(1.0F * f + 0.5F));
    this.lX = ((int)(f * 32.0F + 0.5F));
    this.mi = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    I(bI());
    setWillNotDraw(false);
    this.ml.setFocusable(true);
    this.ml.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        PagerTabStrip.this.mk.L(PagerTabStrip.this.mk.mY - 1);
      }
    });
    this.mn.setFocusable(true);
    this.mn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        PagerTabStrip.this.mk.L(PagerTabStrip.this.mk.mY + 1);
      }
    });
    if (getBackground() == null) {
      this.mc = true;
    }
  }
  
  public final void I(int paramInt)
  {
    int i = paramInt;
    if (paramInt < this.lW) {
      i = this.lW;
    }
    super.I(i);
  }
  
  final void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    Rect localRect = this.ma;
    int i = getHeight();
    int j = this.mm.getLeft();
    int k = this.lY;
    int m = this.mm.getRight();
    int n = this.lY;
    int i1 = i - this.lU;
    localRect.set(j - k, i1, m + n, i);
    super.a(paramInt, paramFloat, paramBoolean);
    this.mb = ((int)(Math.abs(paramFloat - 0.5F) * 2.0F * 255.0F));
    localRect.union(this.mm.getLeft() - this.lY, i1, this.mm.getRight() + this.lY, i);
    invalidate(localRect);
  }
  
  final int getMinHeight()
  {
    return Math.max(super.getMinHeight(), this.lX);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = this.mm.getLeft();
    int k = this.lY;
    int m = this.mm.getRight();
    int n = this.lY;
    int i1 = this.lU;
    this.lZ.setColor(this.mb << 24 | this.lT & 0xFFFFFF);
    paramCanvas.drawRect(j - k, i - i1, m + n, i, this.lZ);
    if (this.mc)
    {
      this.lZ.setColor(0xFF000000 | this.lT & 0xFFFFFF);
      paramCanvas.drawRect(getPaddingLeft(), i - this.me, getWidth() - getPaddingRight(), i, this.lZ);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 0) && (this.mf)) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    for (;;)
    {
      return true;
      this.mg = f1;
      this.mh = f2;
      this.mf = false;
      continue;
      if ((Math.abs(f1 - this.mg) > this.mi) || (Math.abs(f2 - this.mh) > this.mi))
      {
        this.mf = true;
        continue;
        if (f1 < this.mm.getLeft() - this.lY) {
          this.mk.L(this.mk.mY - 1);
        } else if (f1 > this.mm.getRight() + this.lY) {
          this.mk.L(this.mk.mY + 1);
        }
      }
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(paramInt);
    if (!this.md) {
      if ((0xFF000000 & paramInt) != 0) {
        break label27;
      }
    }
    label27:
    for (boolean bool = true;; bool = false)
    {
      this.mc = bool;
      return;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (!this.md) {
      if (paramDrawable != null) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      this.mc = bool;
      return;
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (!this.md) {
      if (paramInt != 0) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      this.mc = bool;
      return;
    }
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt4;
    if (paramInt4 < this.lV) {
      i = this.lV;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.PagerTabStrip
 * JD-Core Version:    0.7.0.1
 */