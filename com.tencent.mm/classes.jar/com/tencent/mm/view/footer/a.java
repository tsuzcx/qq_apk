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
import com.tencent.mm.api.w;

public abstract class a
  extends View
{
  public static final int[] Ltx = { -1, -16777216, -707825, -17592, -16535286, -15172610, -7054596, -449092 };
  protected int LtA = -1;
  private boolean LtB = true;
  private final float Ltg = getResources().getDimension(2131166286);
  private Bitmap Lth;
  private Bitmap Lti;
  private Bitmap Ltj;
  private Bitmap Ltk;
  private Bitmap Ltl;
  private Bitmap Ltm;
  protected Bitmap Ltn;
  protected Bitmap Lto;
  protected int Ltp = -1;
  protected int Ltq = -1;
  private Rect[] Ltr;
  private Rect[] Lts;
  protected Rect Ltt;
  protected boolean Ltu;
  protected Paint Ltv;
  protected Paint Ltw;
  protected boolean Lty = false;
  protected int Ltz = -1;
  private com.tencent.mm.bu.b dak;
  private Paint gyK;
  protected int npu = -1;
  
  public a(Context paramContext, com.tencent.mm.bu.b paramb)
  {
    super(paramContext);
    setId(2131297188);
    this.dak = paramb;
    fQp();
  }
  
  private Bitmap b(com.tencent.mm.api.g paramg, boolean paramBoolean)
  {
    Bitmap localBitmap1 = null;
    switch (3.FmQ[paramg.ordinal()])
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
        localBitmap1 = this.Ltk;
      }
      else
      {
        localBitmap1 = this.Ltj;
        continue;
        if (paramBoolean)
        {
          localBitmap1 = this.Ltm;
        }
        else
        {
          localBitmap1 = this.Ltl;
          continue;
          if (paramBoolean) {
            localBitmap1 = this.Lti;
          } else {
            localBitmap1 = this.Lth;
          }
        }
      }
    }
  }
  
  private boolean fQq()
  {
    return getDetailHeight() > 0;
  }
  
  private void fQs()
  {
    if (this.Lts == null) {
      this.Lts = new Rect[Ltx.length];
    }
    if (this.Ltt == null) {
      this.Ltt = new Rect();
    }
    float f1 = getResources().getDimension(2131166164);
    float f2 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.Ltn.getWidth() - 2.0F * f1 * Ltx.length) / Ltx.length;
    int k = (int)(f1 * 2.0F);
    int j = (int)(getPaddingLeftAndRight() / 2 + f1 + 5.0F);
    int m = (int)((getDetailHeight() - f1 * 2.0F) / 2.0F + f1);
    int i = 0;
    while (i < Ltx.length)
    {
      this.Lts[i] = new Rect(j - k, m - k, j + k, m + k);
      j = (int)(j + (2.0F * f1 + f2));
      i += 1;
    }
    i = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.Ltn.getWidth() / 2;
    this.Ltt.set(i - this.Ltn.getWidth(), 0, i + this.Ltn.getWidth(), getDetailHeight());
  }
  
  public static int getColor(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < Ltx.length)) {
      return Ltx[paramInt];
    }
    return -65536;
  }
  
  protected final boolean NN()
  {
    com.tencent.mm.e.b localb = getPresenter().c(getCurFeatureType());
    if (localb == null) {
      return false;
    }
    return localb.NN();
  }
  
  protected abstract Bitmap a(com.tencent.mm.api.g paramg, boolean paramBoolean);
  
  protected final com.tencent.mm.api.g agc(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getFeatureCount())) {
      return getPresenter().getFeatures()[paramInt];
    }
    return com.tencent.mm.api.g.cRC;
  }
  
  protected boolean agd(int paramInt)
  {
    com.tencent.mm.api.g localg = agc(paramInt);
    switch (3.FmQ[localg.ordinal()])
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
      if (fQq())
      {
        if ((this.Ltt == null) || (!this.Ltt.contains(j, k))) {
          break label124;
        }
        this.Ltu = true;
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
        if (!this.Ltr[i].contains(j, k)) {
          break label50;
        }
        this.Ltz = i;
        postInvalidate();
        return true;
        label124:
        kx(j, k);
      }
    }
    i = 0;
    if (i < getFeatureCount())
    {
      if ((!this.Ltr[i].contains(j, k)) || (this.Ltz != i)) {
        break label360;
      }
      if (agd(i))
      {
        if (this.Ltz != this.npu) {
          this.npu = this.Ltz;
        }
      }
      else
      {
        label194:
        if (this.Lty) {
          break label360;
        }
        this.Ltq = this.Ltp;
        if (!agd(i)) {
          break label333;
        }
        this.Ltp = this.npu;
        getPresenter().getSelectedFeatureListener().a(agc(this.npu));
      }
    }
    else
    {
      label247:
      if (fQq())
      {
        if ((this.Ltt == null) || (!this.Ltt.contains(j, k)) || (!this.Ltu)) {
          break label367;
        }
        getPresenter().getSelectedFeatureListener().a(agc(this.npu), -1, null);
      }
    }
    for (;;)
    {
      this.Ltu = false;
      this.Ltz = -1;
      requestLayout();
      postInvalidate();
      return true;
      this.npu = -1;
      break label194;
      label333:
      this.Ltp = i;
      getPresenter().getSelectedFeatureListener().a(agc(i));
      break label247;
      label360:
      i += 1;
      break;
      label367:
      ky(j, k);
    }
  }
  
  public final boolean fQo()
  {
    return this.Lty;
  }
  
  protected void fQp()
  {
    this.Ltv = new Paint(1);
    this.Ltv.setColor(-16711936);
    this.Ltw = new Paint(1);
    this.Ltw.setColor(getResources().getColor(2131100253));
    this.Ltw.setStrokeWidth(0.6F);
    this.gyK = new Paint(1);
    this.gyK.setStyle(Paint.Style.FILL);
    this.gyK.setStrokeCap(Paint.Cap.ROUND);
    this.Lto = com.tencent.mm.sdk.platformtools.g.A(getResources().getDrawable(2131691346));
    this.Ltn = com.tencent.mm.sdk.platformtools.g.A(getResources().getDrawable(2131691345));
    this.Lth = com.tencent.mm.sdk.platformtools.g.A(getResources().getDrawable(2131690057));
    this.Lti = com.tencent.mm.sdk.platformtools.g.A(getResources().getDrawable(2131690056));
    this.Ltj = com.tencent.mm.sdk.platformtools.g.A(getResources().getDrawable(2131691277));
    this.Ltk = com.tencent.mm.sdk.platformtools.g.A(getResources().getDrawable(2131691276));
    this.Ltl = BitmapFactory.decodeResource(getResources(), 2131232082);
    this.Ltm = BitmapFactory.decodeResource(getResources(), 2131232076);
  }
  
  protected void fQr()
  {
    if (this.Ltr == null) {
      this.Ltr = new Rect[getFeatureCount()];
    }
    int j = (int)(this.Ltg + getIconWidth() / 2.0F);
    int k = (int)getIconWidth();
    int i = 0;
    while (i < getFeatureCount())
    {
      this.Ltr[i] = new Rect(j - k, getDetailHeight(), j + k, getDetailHeight() + getMeasuredHeight());
      j = (int)(j + (getWidthSpacing() + getIconWidth()));
      i += 1;
    }
    if (agc(this.npu) == com.tencent.mm.api.g.cRD) {
      fQs();
    }
  }
  
  public final void fQt()
  {
    this.Ltq = this.Ltp;
  }
  
  public final void fQu()
  {
    this.Ltp = this.Ltq;
    requestLayout();
    invalidate();
  }
  
  public com.tencent.mm.api.g getCurFeatureType()
  {
    return agc(this.Ltp);
  }
  
  protected int getDetailHeight()
  {
    if (agc(this.npu) == com.tencent.mm.api.g.cRD) {
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
    Bitmap localBitmap = b(com.tencent.mm.api.g.cRD, false);
    if (localBitmap == null) {
      return 0.0F;
    }
    return localBitmap.getWidth();
  }
  
  public int getPaddingLeftAndRight()
  {
    return (int)(2.0F * this.Ltg);
  }
  
  protected com.tencent.mm.bu.b getPresenter()
  {
    return this.dak;
  }
  
  protected float getWidthSpacing()
  {
    return (getMeasuredWidth() - getFeatureCount() * getIconWidth() - getPaddingLeftAndRight()) / (getFeatureCount() - 1);
  }
  
  protected void kx(int paramInt1, int paramInt2)
  {
    switch (3.FmQ[agc(this.npu).ordinal()])
    {
    }
    for (;;)
    {
      return;
      if (this.Lts != null)
      {
        int i = 0;
        while (i < this.Lts.length)
        {
          if (this.Lts[i].contains(paramInt1, paramInt2))
          {
            this.LtA = i;
            this.LtB = false;
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  protected void ky(int paramInt1, int paramInt2)
  {
    switch (3.FmQ[agc(this.npu).ordinal()])
    {
    }
    for (;;)
    {
      return;
      int i = 0;
      while ((this.Lts != null) && (i < this.Lts.length))
      {
        if ((this.Lts[i].contains(paramInt1, paramInt2)) && (i == this.LtA))
        {
          getPresenter().getSelectedFeatureListener().a(com.tencent.mm.api.g.cRD, i, null);
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
    q(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = getPaddingLeft();
    int k = getPaddingRight();
    paramInt2 = (int)getResources().getDimension(2131166289);
    paramInt1 = paramInt2;
    if (fQq()) {
      paramInt1 = paramInt2 + getDetailHeight();
    }
    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i - j - k, 1073741824), paramInt1);
    fQr();
  }
  
  protected void q(Canvas paramCanvas)
  {
    if (fQq())
    {
      paramCanvas.drawLine(0.0F, getDetailHeight(), getMeasuredWidth(), getDetailHeight(), this.Ltw);
      r(paramCanvas);
    }
    float f1 = this.Ltg;
    float f2 = getHeightSpacing();
    float f3 = getDetailHeight();
    int i = 0;
    if (i < getFeatureCount())
    {
      Object localObject = getPresenter().getFeatures()[i];
      if ((this.Ltz == i) || (i == this.npu)) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = b((com.tencent.mm.api.g)localObject, bool);
        if (localObject != null) {
          paramCanvas.drawBitmap((Bitmap)localObject, f1, f2 + f3, null);
        }
        f1 += getWidthSpacing() + getIconWidth();
        i += 1;
        break;
      }
    }
  }
  
  protected void r(Canvas paramCanvas)
  {
    Paint localPaint;
    if (agc(this.npu) == com.tencent.mm.api.g.cRD)
    {
      float f4 = getResources().getDimension(2131166164);
      float f5 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.Ltn.getWidth() - 2.0F * f4 * Ltx.length) / Ltx.length;
      float f1 = getPaddingLeftAndRight() / 2;
      float f2 = com.tencent.mm.cm.a.cd(1.5F) + (f1 + f4);
      float f6 = (getDetailHeight() - f4 * 2.0F) / 2.0F + f4;
      int i = 0;
      if (i < Ltx.length)
      {
        float f3 = 0.0F;
        if (this.LtA == i)
        {
          f1 = com.tencent.mm.cm.a.cd(2.0F);
          this.LtB = false;
        }
        for (;;)
        {
          this.gyK.setColor(-1);
          paramCanvas.drawCircle(f2, f6, com.tencent.mm.cm.a.cd(1.5F) + f4 + f1, this.gyK);
          this.gyK.setColor(Ltx[i]);
          paramCanvas.drawCircle(f2, f6, f1 + f4, this.gyK);
          f2 += 2.0F * f4 + f5;
          i += 1;
          break;
          f1 = f3;
          if (this.LtB)
          {
            f1 = f3;
            if (i == 2) {
              f1 = com.tencent.mm.cm.a.cd(2.0F);
            }
          }
        }
      }
      localPaint = new Paint();
      if (!NN()) {
        break label329;
      }
      localPaint.setAlpha(255);
      if ((!this.Ltu) || (!NN())) {
        break label340;
      }
    }
    label329:
    label340:
    for (Bitmap localBitmap = this.Lto;; localBitmap = this.Ltn)
    {
      paramCanvas.drawBitmap(localBitmap, getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.Ltn.getWidth(), (getDetailHeight() - this.Ltn.getHeight()) / 2, localPaint);
      return;
      localPaint.setAlpha(160);
      break;
    }
  }
  
  public void setCurFeatureType(com.tencent.mm.api.g paramg)
  {
    int i = 0;
    if (i < getFeatureCount()) {
      if (getPresenter().getFeatures()[i] == paramg) {
        label25:
        if (!agd(i)) {
          break label64;
        }
      }
    }
    label64:
    for (this.npu = i;; this.npu = -1)
    {
      this.Ltp = i;
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
    this.Lty = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.footer.a
 * JD-Core Version:    0.7.0.1
 */