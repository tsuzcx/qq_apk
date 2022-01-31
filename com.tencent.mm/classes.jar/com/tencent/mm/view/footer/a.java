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
import com.tencent.mm.api.e;
import com.tencent.mm.api.r;
import com.tencent.mm.sdk.platformtools.d;

public abstract class a
  extends View
{
  public static final int[] ATm = { -1, -16777216, -707825, -17592, -16535286, -15172610, -7054596, -449092 };
  protected Paint ARc;
  private final float ASW = getResources().getDimension(2131428420);
  private Bitmap ASX;
  private Bitmap ASY;
  private Bitmap ASZ;
  private Bitmap ATa;
  private Bitmap ATb;
  private Bitmap ATc;
  protected Bitmap ATd;
  protected Bitmap ATe;
  protected int ATf = -1;
  protected int ATg = -1;
  private Rect[] ATh;
  private Rect[] ATi;
  protected Rect ATj;
  protected boolean ATk;
  protected Paint ATl;
  protected boolean ATn = false;
  protected int ATo = -1;
  protected int ATp = -1;
  private boolean ATq = true;
  private com.tencent.mm.bs.b ccS;
  private Paint eFo;
  protected int jwK = -1;
  
  public a(Context paramContext, com.tencent.mm.bs.b paramb)
  {
    super(paramContext);
    setId(2131820577);
    this.ccS = paramb;
    dQV();
  }
  
  private Bitmap b(e parame, boolean paramBoolean)
  {
    Bitmap localBitmap1 = null;
    switch (a.3.whp[parame.ordinal()])
    {
    }
    for (;;)
    {
      Bitmap localBitmap2 = localBitmap1;
      if (localBitmap1 == null) {
        localBitmap2 = a(parame, paramBoolean);
      }
      return localBitmap2;
      if (paramBoolean)
      {
        localBitmap1 = this.ATa;
      }
      else
      {
        localBitmap1 = this.ASZ;
        continue;
        if (paramBoolean)
        {
          localBitmap1 = this.ATc;
        }
        else
        {
          localBitmap1 = this.ATb;
          continue;
          if (paramBoolean) {
            localBitmap1 = this.ASY;
          } else {
            localBitmap1 = this.ASX;
          }
        }
      }
    }
  }
  
  private boolean dQW()
  {
    return getDetailHeight() > 0;
  }
  
  private void dQY()
  {
    if (this.ATi == null) {
      this.ATi = new Rect[ATm.length];
    }
    if (this.ATj == null) {
      this.ATj = new Rect();
    }
    float f1 = getResources().getDimension(2131428313);
    float f2 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.ATd.getWidth() - 2.0F * f1 * ATm.length) / ATm.length;
    int k = (int)(f1 * 2.0F);
    int j = (int)(getPaddingLeftAndRight() / 2 + f1 + 5.0F);
    int m = (int)((getDetailHeight() - f1 * 2.0F) / 2.0F + f1);
    int i = 0;
    while (i < ATm.length)
    {
      this.ATi[i] = new Rect(j - k, m - k, j + k, m + k);
      j = (int)(j + (2.0F * f1 + f2));
      i += 1;
    }
    i = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.ATd.getWidth() / 2;
    this.ATj.set(i - this.ATd.getWidth(), 0, i + this.ATd.getWidth(), getDetailHeight());
  }
  
  public static int getColor(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < ATm.length)) {
      return ATm[paramInt];
    }
    return -65536;
  }
  
  protected final boolean CE()
  {
    com.tencent.mm.e.b localb = getPresenter().c(getCurFeatureType());
    if (localb == null) {
      return false;
    }
    return localb.CE();
  }
  
  protected final e RL(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getFeatureCount())) {
      return getPresenter().getFeatures()[paramInt];
    }
    return e.bVV;
  }
  
  protected boolean RM(int paramInt)
  {
    e locale = RL(paramInt);
    switch (a.3.whp[locale.ordinal()])
    {
    case 2: 
    case 3: 
    default: 
      return false;
    }
    return true;
  }
  
  protected abstract Bitmap a(e parame, boolean paramBoolean);
  
  public final boolean dQU()
  {
    return this.ATn;
  }
  
  protected void dQV()
  {
    this.ARc = new Paint(1);
    this.ARc.setColor(-16711936);
    this.ATl = new Paint(1);
    this.ATl.setColor(getResources().getColor(2131689967));
    this.ATl.setStrokeWidth(0.6F);
    this.eFo = new Paint(1);
    this.eFo.setStyle(Paint.Style.FILL);
    this.eFo.setStrokeCap(Paint.Cap.ROUND);
    this.ATe = d.u(getResources().getDrawable(2131232144));
    this.ATd = d.u(getResources().getDrawable(2131232143));
    this.ASX = d.u(getResources().getDrawable(2131231252));
    this.ASY = d.u(getResources().getDrawable(2131231251));
    this.ASZ = d.u(getResources().getDrawable(2131232077));
    this.ATa = d.u(getResources().getDrawable(2131232076));
    this.ATb = BitmapFactory.decodeResource(getResources(), 2130838644);
    this.ATc = BitmapFactory.decodeResource(getResources(), 2130838640);
  }
  
  protected void dQX()
  {
    if (this.ATh == null) {
      this.ATh = new Rect[getFeatureCount()];
    }
    int j = (int)(this.ASW + getIconWidth() / 2.0F);
    int k = (int)getIconWidth();
    int i = 0;
    while (i < getFeatureCount())
    {
      this.ATh[i] = new Rect(j - k, getDetailHeight(), j + k, getDetailHeight() + getMeasuredHeight());
      j = (int)(j + (getWidthSpacing() + getIconWidth()));
      i += 1;
    }
    if (RL(this.jwK) == e.bVW) {
      dQY();
    }
  }
  
  public final void dQZ()
  {
    this.ATg = this.ATf;
  }
  
  public final void dRa()
  {
    this.ATf = this.ATg;
    requestLayout();
    invalidate();
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
      if (dQW())
      {
        if ((this.ATj == null) || (!this.ATj.contains(j, k))) {
          break label124;
        }
        this.ATk = true;
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
        if (!this.ATh[i].contains(j, k)) {
          break label50;
        }
        this.ATo = i;
        postInvalidate();
        return true;
        label124:
        ib(j, k);
      }
    }
    i = 0;
    if (i < getFeatureCount())
    {
      if ((!this.ATh[i].contains(j, k)) || (this.ATo != i)) {
        break label359;
      }
      if (RM(i))
      {
        if (this.ATo != this.jwK) {
          this.jwK = this.ATo;
        }
      }
      else
      {
        label194:
        if (this.ATn) {
          break label359;
        }
        this.ATg = this.ATf;
        if (!RM(i)) {
          break label332;
        }
        this.ATf = this.jwK;
        getPresenter().getSelectedFeatureListener().a(RL(this.jwK));
      }
    }
    else
    {
      label247:
      if (dQW())
      {
        if ((this.ATj == null) || (!this.ATj.contains(j, k)) || (!this.ATk)) {
          break label366;
        }
        getPresenter().getSelectedFeatureListener().a(RL(this.jwK), -1);
      }
    }
    for (;;)
    {
      this.ATk = false;
      this.ATo = -1;
      requestLayout();
      postInvalidate();
      return true;
      this.jwK = -1;
      break label194;
      label332:
      this.ATf = i;
      getPresenter().getSelectedFeatureListener().a(RL(i));
      break label247;
      label359:
      i += 1;
      break;
      label366:
      ic(j, k);
    }
  }
  
  public e getCurFeatureType()
  {
    return RL(this.ATf);
  }
  
  protected int getDetailHeight()
  {
    if (RL(this.jwK) == e.bVW) {
      return (int)getResources().getDimension(2131428422);
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
    Bitmap localBitmap = b(e.bVW, false);
    if (localBitmap == null) {
      return 0.0F;
    }
    return localBitmap.getWidth();
  }
  
  public int getPaddingLeftAndRight()
  {
    return (int)(2.0F * this.ASW);
  }
  
  protected com.tencent.mm.bs.b getPresenter()
  {
    return this.ccS;
  }
  
  protected float getWidthSpacing()
  {
    return (getMeasuredWidth() - getFeatureCount() * getIconWidth() - getPaddingLeftAndRight()) / (getFeatureCount() - 1);
  }
  
  protected void ib(int paramInt1, int paramInt2)
  {
    switch (a.3.whp[RL(this.jwK).ordinal()])
    {
    }
    for (;;)
    {
      return;
      if (this.ATi != null)
      {
        int i = 0;
        while (i < this.ATi.length)
        {
          if (this.ATi[i].contains(paramInt1, paramInt2))
          {
            this.ATp = i;
            this.ATq = false;
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  protected void ic(int paramInt1, int paramInt2)
  {
    switch (a.3.whp[RL(this.jwK).ordinal()])
    {
    }
    for (;;)
    {
      return;
      int i = 0;
      while ((this.ATi != null) && (i < this.ATi.length))
      {
        if ((this.ATi[i].contains(paramInt1, paramInt2)) && (i == this.ATp))
        {
          getPresenter().getSelectedFeatureListener().a(e.bVW, i);
          return;
        }
        i += 1;
      }
    }
  }
  
  protected void o(Canvas paramCanvas)
  {
    if (dQW())
    {
      paramCanvas.drawLine(0.0F, getDetailHeight(), getMeasuredWidth(), getDetailHeight(), this.ATl);
      p(paramCanvas);
    }
    float f1 = this.ASW;
    float f2 = getHeightSpacing();
    float f3 = getDetailHeight();
    int i = 0;
    if (i < getFeatureCount())
    {
      Object localObject = getPresenter().getFeatures()[i];
      if ((this.ATo == i) || (i == this.jwK)) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = b((e)localObject, bool);
        if (localObject != null) {
          paramCanvas.drawBitmap((Bitmap)localObject, f1, f2 + f3, null);
        }
        f1 += getWidthSpacing() + getIconWidth();
        i += 1;
        break;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0);
    o(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = getPaddingLeft();
    int k = getPaddingRight();
    paramInt2 = (int)getResources().getDimension(2131428423);
    paramInt1 = paramInt2;
    if (dQW()) {
      paramInt1 = paramInt2 + getDetailHeight();
    }
    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i - j - k, 1073741824), paramInt1);
    dQX();
  }
  
  protected void p(Canvas paramCanvas)
  {
    Paint localPaint;
    if (RL(this.jwK) == e.bVW)
    {
      float f4 = getResources().getDimension(2131428313);
      float f5 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.ATd.getWidth() - 2.0F * f4 * ATm.length) / ATm.length;
      float f1 = getPaddingLeftAndRight() / 2;
      float f2 = com.tencent.mm.cl.a.bC(1.5F) + (f1 + f4);
      float f6 = (getDetailHeight() - f4 * 2.0F) / 2.0F + f4;
      int i = 0;
      if (i < ATm.length)
      {
        float f3 = 0.0F;
        if (this.ATp == i)
        {
          f1 = com.tencent.mm.cl.a.bC(2.0F);
          this.ATq = false;
        }
        for (;;)
        {
          this.eFo.setColor(-1);
          paramCanvas.drawCircle(f2, f6, com.tencent.mm.cl.a.bC(1.5F) + f4 + f1, this.eFo);
          this.eFo.setColor(ATm[i]);
          paramCanvas.drawCircle(f2, f6, f1 + f4, this.eFo);
          f2 += 2.0F * f4 + f5;
          i += 1;
          break;
          f1 = f3;
          if (this.ATq)
          {
            f1 = f3;
            if (i == 2) {
              f1 = com.tencent.mm.cl.a.bC(2.0F);
            }
          }
        }
      }
      localPaint = new Paint();
      if (!CE()) {
        break label329;
      }
      localPaint.setAlpha(255);
      if ((!this.ATk) || (!CE())) {
        break label340;
      }
    }
    label329:
    label340:
    for (Bitmap localBitmap = this.ATe;; localBitmap = this.ATd)
    {
      paramCanvas.drawBitmap(localBitmap, getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.ATd.getWidth(), (getDetailHeight() - this.ATd.getHeight()) / 2, localPaint);
      return;
      localPaint.setAlpha(160);
      break;
    }
  }
  
  public void setCurFeatureType(e parame)
  {
    int i = 0;
    if (i < getFeatureCount()) {
      if (getPresenter().getFeatures()[i] == parame) {
        label25:
        if (!RM(i)) {
          break label64;
        }
      }
    }
    label64:
    for (this.jwK = i;; this.jwK = -1)
    {
      this.ATf = i;
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
      localAnimation = AnimationUtils.loadAnimation(getContext(), 2131034125);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(116423);
          a.this.setVisibility(0);
          AppMethodBeat.o(116423);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      startAnimation(localAnimation);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2131034126);
    localAnimation.setAnimationListener(new a.2(this));
    startAnimation(localAnimation);
  }
  
  public void setHideFooter(boolean paramBoolean)
  {
    this.ATn = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.footer.a
 * JD-Core Version:    0.7.0.1
 */