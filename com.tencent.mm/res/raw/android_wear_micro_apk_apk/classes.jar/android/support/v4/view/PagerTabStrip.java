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
  private int jW = this.kC;
  private int jX;
  private int jY;
  private int jZ;
  private int ka;
  private int kb;
  private final Paint kc = new Paint();
  private final Rect kd = new Rect();
  private int ke = 255;
  private boolean kf = false;
  private boolean kg = false;
  private int kh;
  private boolean ki;
  private float kj;
  private float kk;
  private int kl;
  
  public PagerTabStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.kc.setColor(this.jW);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.jX = ((int)(3.0F * f + 0.5F));
    this.jY = ((int)(6.0F * f + 0.5F));
    this.jZ = ((int)(64.0F * f));
    this.kb = ((int)(16.0F * f + 0.5F));
    this.kh = ((int)(1.0F * f + 0.5F));
    this.ka = ((int)(f * 32.0F + 0.5F));
    this.kl = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    x(br());
    setWillNotDraw(false);
    this.ko.setFocusable(true);
    this.ko.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        PagerTabStrip.this.kn.A(PagerTabStrip.this.kn.lc - 1);
      }
    });
    this.kq.setFocusable(true);
    this.kq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        PagerTabStrip.this.kn.A(PagerTabStrip.this.kn.lc + 1);
      }
    });
    if (getBackground() == null) {
      this.kf = true;
    }
  }
  
  final void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    Rect localRect = this.kd;
    int i = getHeight();
    int j = this.kp.getLeft();
    int k = this.kb;
    int m = this.kp.getRight();
    int n = this.kb;
    int i1 = i - this.jX;
    localRect.set(j - k, i1, m + n, i);
    super.a(paramInt, paramFloat, paramBoolean);
    this.ke = ((int)(Math.abs(paramFloat - 0.5F) * 2.0F * 255.0F));
    localRect.union(this.kp.getLeft() - this.kb, i1, this.kp.getRight() + this.kb, i);
    invalidate(localRect);
  }
  
  final int getMinHeight()
  {
    return Math.max(super.getMinHeight(), this.ka);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = this.kp.getLeft();
    int k = this.kb;
    int m = this.kp.getRight();
    int n = this.kb;
    int i1 = this.jX;
    this.kc.setColor(this.ke << 24 | this.jW & 0xFFFFFF);
    paramCanvas.drawRect(j - k, i - i1, m + n, i, this.kc);
    if (this.kf)
    {
      this.kc.setColor(0xFF000000 | this.jW & 0xFFFFFF);
      paramCanvas.drawRect(getPaddingLeft(), i - this.kh, getWidth() - getPaddingRight(), i, this.kc);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 0) && (this.ki)) {
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
      this.kj = f1;
      this.kk = f2;
      this.ki = false;
      continue;
      if ((Math.abs(f1 - this.kj) > this.kl) || (Math.abs(f2 - this.kk) > this.kl))
      {
        this.ki = true;
        continue;
        if (f1 < this.kp.getLeft() - this.kb) {
          this.kn.A(this.kn.lc - 1);
        } else if (f1 > this.kp.getRight() + this.kb) {
          this.kn.A(this.kn.lc + 1);
        }
      }
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(paramInt);
    if (!this.kg) {
      if ((0xFF000000 & paramInt) != 0) {
        break label27;
      }
    }
    label27:
    for (boolean bool = true;; bool = false)
    {
      this.kf = bool;
      return;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (!this.kg) {
      if (paramDrawable != null) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      this.kf = bool;
      return;
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (!this.kg) {
      if (paramInt != 0) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      this.kf = bool;
      return;
    }
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt4;
    if (paramInt4 < this.jY) {
      i = this.jY;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, i);
  }
  
  public final void x(int paramInt)
  {
    int i = paramInt;
    if (paramInt < this.jZ) {
      i = this.jZ;
    }
    super.x(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.PagerTabStrip
 * JD-Core Version:    0.7.0.1
 */