package com.tencent.mm.view.footer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.g;
import com.tencent.mm.api.w;
import com.tencent.mm.sdk.platformtools.f;

public abstract class a
  extends View
{
  public static final int[] HZA = { -1, -16777216, -707825, -17592, -16535286, -15172610, -7054596, -449092 };
  protected boolean HZB = false;
  protected int HZC = -1;
  protected int HZD = -1;
  private boolean HZE = true;
  private final float HZj = getResources().getDimension(2131166286);
  private Bitmap HZk;
  private Bitmap HZl;
  private Bitmap HZm;
  private Bitmap HZn;
  private Bitmap HZo;
  private Bitmap HZp;
  protected Bitmap HZq;
  protected Bitmap HZr;
  protected int HZs = -1;
  protected int HZt = -1;
  private Rect[] HZu;
  private Rect[] HZv;
  protected Rect HZw;
  protected boolean HZx;
  protected Paint HZy;
  protected Paint HZz;
  private com.tencent.mm.bu.b cRz;
  private Paint gau;
  protected int mmW = -1;
  
  public a(Context paramContext, com.tencent.mm.bu.b paramb)
  {
    super(paramContext);
    setId(2131297188);
    this.cRz = paramb;
    fiT();
  }
  
  private Bitmap b(g paramg, boolean paramBoolean)
  {
    Bitmap localBitmap1 = null;
    switch (3.Cpr[paramg.ordinal()])
    {
    }
    for (;;)
    {
      Bitmap localBitmap2 = localBitmap1;
      if (localBitmap1 == null) {
        localBitmap2 = a(paramg, paramBoolean);
      }
      return localBitmap2;
      if (paramBoolean)
      {
        localBitmap1 = this.HZn;
      }
      else
      {
        localBitmap1 = this.HZm;
        continue;
        if (paramBoolean)
        {
          localBitmap1 = this.HZp;
        }
        else
        {
          localBitmap1 = this.HZo;
          continue;
          if (paramBoolean) {
            localBitmap1 = this.HZl;
          } else {
            localBitmap1 = this.HZk;
          }
        }
      }
    }
  }
  
  private boolean fiU()
  {
    return getDetailHeight() > 0;
  }
  
  private void fiW()
  {
    if (this.HZv == null) {
      this.HZv = new Rect[HZA.length];
    }
    if (this.HZw == null) {
      this.HZw = new Rect();
    }
    float f1 = getResources().getDimension(2131166164);
    float f2 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.HZq.getWidth() - 2.0F * f1 * HZA.length) / HZA.length;
    int k = (int)(f1 * 2.0F);
    int j = (int)(getPaddingLeftAndRight() / 2 + f1 + 5.0F);
    int m = (int)((getDetailHeight() - f1 * 2.0F) / 2.0F + f1);
    int i = 0;
    while (i < HZA.length)
    {
      this.HZv[i] = new Rect(j - k, m - k, j + k, m + k);
      j = (int)(j + (2.0F * f1 + f2));
      i += 1;
    }
    i = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.HZq.getWidth() / 2;
    this.HZw.set(i - this.HZq.getWidth(), 0, i + this.HZq.getWidth(), getDetailHeight());
  }
  
  public static int getColor(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < HZA.length)) {
      return HZA[paramInt];
    }
    return -65536;
  }
  
  protected final boolean Mg()
  {
    com.tencent.mm.e.b localb = getPresenter().c(getCurFeatureType());
    if (localb == null) {
      return false;
    }
    return localb.Mg();
  }
  
  protected abstract Bitmap a(g paramg, boolean paramBoolean);
  
  protected final g abk(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getFeatureCount())) {
      return getPresenter().getFeatures()[paramInt];
    }
    return g.cJr;
  }
  
  protected boolean abl(int paramInt)
  {
    g localg = abk(paramInt);
    switch (3.Cpr[localg.ordinal()])
    {
    case 2: 
    case 3: 
    default: 
      return false;
    }
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return true;
      if (fiU())
      {
        if ((this.HZw == null) || (!this.HZw.contains(j, k))) {
          break label124;
        }
        this.HZx = true;
        postInvalidate();
      }
    case 0: 
      for (;;)
      {
        label50:
        i += 1;
        if (i >= getFeatureCount()) {
          break;
        }
        if (!this.HZu[i].contains(j, k)) {
          break label50;
        }
        this.HZC = i;
        postInvalidate();
        return true;
        label124:
        jV(j, k);
      }
    }
    i = 0;
    if (i < getFeatureCount())
    {
      if ((!this.HZu[i].contains(j, k)) || (this.HZC != i)) {
        break label360;
      }
      if (abl(i))
      {
        if (this.HZC != this.mmW) {
          this.mmW = this.HZC;
        }
      }
      else
      {
        label194:
        if (this.HZB) {
          break label360;
        }
        this.HZt = this.HZs;
        if (!abl(i)) {
          break label333;
        }
        this.HZs = this.mmW;
        getPresenter().getSelectedFeatureListener().a(abk(this.mmW));
      }
    }
    else
    {
      label247:
      if (fiU())
      {
        if ((this.HZw == null) || (!this.HZw.contains(j, k)) || (!this.HZx)) {
          break label367;
        }
        getPresenter().getSelectedFeatureListener().a(abk(this.mmW), -1, null);
      }
    }
    for (;;)
    {
      this.HZx = false;
      this.HZC = -1;
      requestLayout();
      postInvalidate();
      return true;
      this.mmW = -1;
      break label194;
      label333:
      this.HZs = i;
      getPresenter().getSelectedFeatureListener().a(abk(i));
      break label247;
      label360:
      i += 1;
      break;
      label367:
      jW(j, k);
    }
  }
  
  public final boolean fiS()
  {
    return this.HZB;
  }
  
  protected void fiT()
  {
    this.HZy = new Paint(1);
    this.HZy.setColor(-16711936);
    this.HZz = new Paint(1);
    this.HZz.setColor(getResources().getColor(2131100253));
    this.HZz.setStrokeWidth(0.6F);
    this.gau = new Paint(1);
    this.gau.setStyle(Paint.Style.FILL);
    this.gau.setStrokeCap(Paint.Cap.ROUND);
    this.HZr = f.B(getResources().getDrawable(2131691346));
    this.HZq = f.B(getResources().getDrawable(2131691345));
    this.HZk = f.B(getResources().getDrawable(2131690057));
    this.HZl = f.B(getResources().getDrawable(2131690056));
    this.HZm = f.B(getResources().getDrawable(2131691277));
    this.HZn = f.B(getResources().getDrawable(2131691276));
    this.HZo = BitmapFactory.decodeResource(getResources(), 2131232082);
    this.HZp = BitmapFactory.decodeResource(getResources(), 2131232076);
  }
  
  protected void fiV()
  {
    if (this.HZu == null) {
      this.HZu = new Rect[getFeatureCount()];
    }
    int j = (int)(this.HZj + getIconWidth() / 2.0F);
    int k = (int)getIconWidth();
    int i = 0;
    while (i < getFeatureCount())
    {
      this.HZu[i] = new Rect(j - k, getDetailHeight(), j + k, getDetailHeight() + getMeasuredHeight());
      j = (int)(j + (getWidthSpacing() + getIconWidth()));
      i += 1;
    }
    if (abk(this.mmW) == g.cJs) {
      fiW();
    }
  }
  
  public final void fiX()
  {
    this.HZt = this.HZs;
  }
  
  public final void fiY()
  {
    this.HZs = this.HZt;
    requestLayout();
    invalidate();
  }
  
  public g getCurFeatureType()
  {
    return abk(this.HZs);
  }
  
  protected int getDetailHeight()
  {
    if (abk(this.mmW) == g.cJs) {
      return (int)getResources().getDimension(2131166288);
    }
    return 0;
  }
  
  protected int getFeatureCount()
  {
    return getPresenter().getFeatures().length;
  }
  
  protected float getHeightSpacing()
  {
    return (getMeasuredHeight() - getDetailHeight() - getIconWidth()) / 2.0F;
  }
  
  protected float getIconWidth()
  {
    Bitmap localBitmap = b(g.cJs, false);
    if (localBitmap == null) {
      return 0.0F;
    }
    return localBitmap.getWidth();
  }
  
  public int getPaddingLeftAndRight()
  {
    return (int)(2.0F * this.HZj);
  }
  
  protected com.tencent.mm.bu.b getPresenter()
  {
    return this.cRz;
  }
  
  protected float getWidthSpacing()
  {
    return (getMeasuredWidth() - getFeatureCount() * getIconWidth() - getPaddingLeftAndRight()) / (getFeatureCount() - 1);
  }
  
  protected void jV(int paramInt1, int paramInt2)
  {
    switch (3.Cpr[abk(this.mmW).ordinal()])
    {
    }
    for (;;)
    {
      return;
      if (this.HZv != null)
      {
        int i = 0;
        while (i < this.HZv.length)
        {
          if (this.HZv[i].contains(paramInt1, paramInt2))
          {
            this.HZD = i;
            this.HZE = false;
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  protected void jW(int paramInt1, int paramInt2)
  {
    switch (3.Cpr[abk(this.mmW).ordinal()])
    {
    }
    for (;;)
    {
      return;
      int i = 0;
      while ((this.HZv != null) && (i < this.HZv.length))
      {
        if ((this.HZv[i].contains(paramInt1, paramInt2)) && (i == this.HZD))
        {
          getPresenter().getSelectedFeatureListener().a(g.cJs, i, null);
          return;
        }
        i += 1;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0);
    r(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = getPaddingLeft();
    int k = getPaddingRight();
    paramInt2 = (int)getResources().getDimension(2131166289);
    paramInt1 = paramInt2;
    if (fiU()) {
      paramInt1 = paramInt2 + getDetailHeight();
    }
    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i - j - k, 1073741824), paramInt1);
    fiV();
  }
  
  protected void r(Canvas paramCanvas)
  {
    if (fiU())
    {
      paramCanvas.drawLine(0.0F, getDetailHeight(), getMeasuredWidth(), getDetailHeight(), this.HZz);
      s(paramCanvas);
    }
    float f1 = this.HZj;
    float f2 = getHeightSpacing();
    float f3 = getDetailHeight();
    int i = 0;
    if (i < getFeatureCount())
    {
      Object localObject = getPresenter().getFeatures()[i];
      if ((this.HZC == i) || (i == this.mmW)) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = b((g)localObject, bool);
        if (localObject != null) {
          paramCanvas.drawBitmap((Bitmap)localObject, f1, f2 + f3, null);
        }
        f1 += getWidthSpacing() + getIconWidth();
        i += 1;
        break;
      }
    }
  }
  
  protected void s(Canvas paramCanvas)
  {
    Paint localPaint;
    if (abk(this.mmW) == g.cJs)
    {
      float f4 = getResources().getDimension(2131166164);
      float f5 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.HZq.getWidth() - 2.0F * f4 * HZA.length) / HZA.length;
      float f1 = getPaddingLeftAndRight() / 2;
      float f2 = com.tencent.mm.cn.a.bP(1.5F) + (f1 + f4);
      float f6 = (getDetailHeight() - f4 * 2.0F) / 2.0F + f4;
      int i = 0;
      if (i < HZA.length)
      {
        float f3 = 0.0F;
        if (this.HZD == i)
        {
          f1 = com.tencent.mm.cn.a.bP(2.0F);
          this.HZE = false;
        }
        for (;;)
        {
          this.gau.setColor(-1);
          paramCanvas.drawCircle(f2, f6, com.tencent.mm.cn.a.bP(1.5F) + f4 + f1, this.gau);
          this.gau.setColor(HZA[i]);
          paramCanvas.drawCircle(f2, f6, f1 + f4, this.gau);
          f2 += 2.0F * f4 + f5;
          i += 1;
          break;
          f1 = f3;
          if (this.HZE)
          {
            f1 = f3;
            if (i == 2) {
              f1 = com.tencent.mm.cn.a.bP(2.0F);
            }
          }
        }
      }
      localPaint = new Paint();
      if (!Mg()) {
        break label329;
      }
      localPaint.setAlpha(255);
      if ((!this.HZx) || (!Mg())) {
        break label340;
      }
    }
    label329:
    label340:
    for (Bitmap localBitmap = this.HZr;; localBitmap = this.HZq)
    {
      paramCanvas.drawBitmap(localBitmap, getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.HZq.getWidth(), (getDetailHeight() - this.HZq.getHeight()) / 2, localPaint);
      return;
      localPaint.setAlpha(160);
      break;
    }
  }
  
  public void setCurFeatureType(g paramg)
  {
    int i = 0;
    if (i < getFeatureCount()) {
      if (getPresenter().getFeatures()[i] == paramg) {
        label25:
        if (!abl(i)) {
          break label64;
        }
      }
    }
    label64:
    for (this.mmW = i;; this.mmW = -1)
    {
      this.HZs = i;
      requestLayout();
      invalidate();
      return;
      i += 1;
      break;
      i = -1;
      break label25;
    }
  }
  
  public void setFooterVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localAnimation = AnimationUtils.loadAnimation(getContext(), 2130771981);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(9401);
          a.this.setVisibility(0);
          AppMethodBeat.o(9401);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      startAnimation(localAnimation);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130771982);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(9402);
        a.this.setVisibility(8);
        AppMethodBeat.o(9402);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    startAnimation(localAnimation);
  }
  
  public void setHideFooter(boolean paramBoolean)
  {
    this.HZB = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.footer.a
 * JD-Core Version:    0.7.0.1
 */