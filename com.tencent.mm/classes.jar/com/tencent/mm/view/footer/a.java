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
import com.tencent.mm.api.aa;
import com.tencent.mm.api.i;
import com.tencent.mm.bo.a.a;
import com.tencent.mm.bo.a.b;
import com.tencent.mm.bo.a.c;
import com.tencent.mm.bo.a.d;
import com.tencent.mm.bo.a.e;
import com.tencent.mm.bo.a.g;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public abstract class a
  extends View
{
  public static final int[] agLQ = { -1, -16777216, -707825, -17592, -16535286, -15172610, -7054596, -449092 };
  protected Paint afny;
  private final float agLA = getResources().getDimension(a.c.feature_padding);
  private Bitmap agLB;
  private Bitmap agLC;
  private Bitmap agLD;
  private Bitmap agLE;
  private Bitmap agLF;
  private Bitmap agLG;
  protected Bitmap agLH;
  protected Bitmap agLI;
  protected int agLJ = -1;
  protected int agLK = -1;
  private Rect[] agLL;
  private Rect[] agLM;
  protected Rect agLN;
  protected boolean agLO;
  protected Paint agLP;
  protected boolean agLR = false;
  protected int agLS = -1;
  protected int agLT = -1;
  private boolean agLU = true;
  private com.tencent.mm.bt.b hoR;
  private Paint mAa;
  protected int uRE = -1;
  
  public a(Context paramContext, com.tencent.mm.bt.b paramb)
  {
    super(paramContext);
    setId(a.e.base_footer_view_id);
    this.hoR = paramb;
    jMV();
  }
  
  private Bitmap b(i parami, boolean paramBoolean)
  {
    Bitmap localBitmap1 = null;
    switch (3.YwI[parami.ordinal()])
    {
    }
    for (;;)
    {
      Bitmap localBitmap2 = localBitmap1;
      if (localBitmap1 == null) {
        localBitmap2 = a(parami, paramBoolean);
      }
      return localBitmap2;
      if (paramBoolean)
      {
        localBitmap1 = this.agLE;
      }
      else
      {
        localBitmap1 = this.agLD;
        continue;
        if (paramBoolean)
        {
          localBitmap1 = this.agLG;
        }
        else
        {
          localBitmap1 = this.agLF;
          continue;
          if (paramBoolean) {
            localBitmap1 = this.agLC;
          } else {
            localBitmap1 = this.agLB;
          }
        }
      }
    }
  }
  
  private boolean jMW()
  {
    return getDetailHeight() > 0;
  }
  
  private void jMY()
  {
    if (this.agLM == null) {
      this.agLM = new Rect[agLQ.length];
    }
    if (this.agLN == null) {
      this.agLN = new Rect();
    }
    float f1 = getResources().getDimension(a.c.doodle_radio);
    float f2 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.agLH.getWidth() - 2.0F * f1 * agLQ.length) / agLQ.length;
    int k = (int)(f1 * 2.0F);
    int j = (int)(getPaddingLeftAndRight() / 2 + f1 + 5.0F);
    int m = (int)((getDetailHeight() - f1 * 2.0F) / 2.0F + f1);
    int i = 0;
    while (i < agLQ.length)
    {
      this.agLM[i] = new Rect(j - k, m - k, j + k, m + k);
      j = (int)(j + (2.0F * f1 + f2));
      i += 1;
    }
    i = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.agLH.getWidth() / 2;
    this.agLN.set(i - this.agLH.getWidth(), 0, i + this.agLH.getWidth(), getDetailHeight());
  }
  
  protected abstract Bitmap a(i parami, boolean paramBoolean);
  
  protected final boolean aED()
  {
    com.tencent.mm.e.b localb = getPresenter().c(getCurFeatureType());
    if (localb == null) {
      return false;
    }
    return localb.aED();
  }
  
  protected final i aFZ(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getFeatureCount())) {
      return getPresenter().getFeatures()[paramInt];
    }
    return i.hdN;
  }
  
  protected boolean aGa(int paramInt)
  {
    i locali = aFZ(paramInt);
    switch (3.YwI[locali.ordinal()])
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
      if (jMW())
      {
        if ((this.agLN == null) || (!this.agLN.contains(j, k))) {
          break label124;
        }
        this.agLO = true;
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
        if (!this.agLL[i].contains(j, k)) {
          break label50;
        }
        this.agLS = i;
        postInvalidate();
        return true;
        label124:
        pp(j, k);
      }
    }
    i = 0;
    if (i < getFeatureCount())
    {
      if ((!this.agLL[i].contains(j, k)) || (this.agLS != i)) {
        break label360;
      }
      if (aGa(i))
      {
        if (this.agLS != this.uRE) {
          this.uRE = this.agLS;
        }
      }
      else
      {
        label194:
        if (this.agLR) {
          break label360;
        }
        this.agLK = this.agLJ;
        if (!aGa(i)) {
          break label333;
        }
        this.agLJ = this.uRE;
        getPresenter().getSelectedFeatureListener().a(aFZ(this.uRE));
      }
    }
    else
    {
      label247:
      if (jMW())
      {
        if ((this.agLN == null) || (!this.agLN.contains(j, k)) || (!this.agLO)) {
          break label367;
        }
        getPresenter().getSelectedFeatureListener().a(aFZ(this.uRE), -1, null);
      }
    }
    for (;;)
    {
      this.agLO = false;
      this.agLS = -1;
      requestLayout();
      postInvalidate();
      return true;
      this.uRE = -1;
      break label194;
      label333:
      this.agLJ = i;
      getPresenter().getSelectedFeatureListener().a(aFZ(i));
      break label247;
      label360:
      i += 1;
      break;
      label367:
      pq(j, k);
    }
  }
  
  public int getColor(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < agLQ.length)) {
      return agLQ[paramInt];
    }
    return -65536;
  }
  
  public i getCurFeatureType()
  {
    return aFZ(this.agLJ);
  }
  
  protected int getDetailHeight()
  {
    if (aFZ(this.uRE) == i.hdO) {
      return (int)getResources().getDimension(a.c.feature_select_detail_layout_height);
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
    Bitmap localBitmap = b(i.hdO, false);
    if (localBitmap == null) {
      return 0.0F;
    }
    return localBitmap.getWidth();
  }
  
  public int getPaddingLeftAndRight()
  {
    return (int)(2.0F * this.agLA);
  }
  
  protected com.tencent.mm.bt.b getPresenter()
  {
    return this.hoR;
  }
  
  protected float getWidthSpacing()
  {
    return (getMeasuredWidth() - getFeatureCount() * getIconWidth() - getPaddingLeftAndRight()) / (getFeatureCount() - 1);
  }
  
  public final boolean jMU()
  {
    return this.agLR;
  }
  
  protected void jMV()
  {
    this.agLP = new Paint(1);
    this.agLP.setColor(-16711936);
    this.afny = new Paint(1);
    this.afny.setColor(getResources().getColor(a.b.divider_line_color));
    this.afny.setStrokeWidth(0.6F);
    this.mAa = new Paint(1);
    this.mAa.setStyle(Paint.Style.FILL);
    this.mAa.setStrokeCap(Paint.Cap.ROUND);
    this.agLI = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.undo_press));
    this.agLH = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.undo_normal));
    this.agLB = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.doodle_unselected));
    this.agLC = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.doodle_selected));
    this.agLD = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.text_unselected));
    this.agLE = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.text_selected));
    this.agLF = BitmapFactory.decodeResource(getResources(), a.d.emoji_unselected);
    this.agLG = BitmapFactory.decodeResource(getResources(), a.d.emoji_selected);
  }
  
  protected void jMX()
  {
    if (this.agLL == null) {
      this.agLL = new Rect[getFeatureCount()];
    }
    int j = (int)(this.agLA + getIconWidth() / 2.0F);
    int k = (int)getIconWidth();
    int i = 0;
    while (i < getFeatureCount())
    {
      this.agLL[i] = new Rect(j - k, getDetailHeight(), j + k, getDetailHeight() + getMeasuredHeight());
      j = (int)(j + (getWidthSpacing() + getIconWidth()));
      i += 1;
    }
    if (aFZ(this.uRE) == i.hdO) {
      jMY();
    }
  }
  
  public final void jMZ()
  {
    this.agLK = this.agLJ;
  }
  
  public final void jNa()
  {
    this.agLJ = this.agLK;
    requestLayout();
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0);
    y(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = getPaddingLeft();
    int k = getPaddingRight();
    paramInt2 = (int)getResources().getDimension(a.c.feature_select_layout_height);
    paramInt1 = paramInt2;
    if (jMW()) {
      paramInt1 = paramInt2 + getDetailHeight();
    }
    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i - j - k, 1073741824), paramInt1);
    jMX();
  }
  
  protected void pp(int paramInt1, int paramInt2)
  {
    switch (3.YwI[aFZ(this.uRE).ordinal()])
    {
    }
    for (;;)
    {
      return;
      if (this.agLM != null)
      {
        int i = 0;
        while (i < this.agLM.length)
        {
          if (this.agLM[i].contains(paramInt1, paramInt2))
          {
            this.agLT = i;
            this.agLU = false;
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  protected void pq(int paramInt1, int paramInt2)
  {
    switch (3.YwI[aFZ(this.uRE).ordinal()])
    {
    }
    for (;;)
    {
      return;
      int i = 0;
      while ((this.agLM != null) && (i < this.agLM.length))
      {
        if ((this.agLM[i].contains(paramInt1, paramInt2)) && (i == this.agLT))
        {
          getPresenter().getSelectedFeatureListener().a(i.hdO, i, null);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void setCurFeatureType(i parami)
  {
    int i = 0;
    if (i < getFeatureCount()) {
      if (getPresenter().getFeatures()[i] == parami) {
        label25:
        if (!aGa(i)) {
          break label64;
        }
      }
    }
    label64:
    for (this.uRE = i;; this.uRE = -1)
    {
      this.agLJ = i;
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
      localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.alpha_in);
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
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.alpha_out);
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
    this.agLR = paramBoolean;
  }
  
  protected void y(Canvas paramCanvas)
  {
    if (jMW())
    {
      paramCanvas.drawLine(0.0F, getDetailHeight(), getMeasuredWidth(), getDetailHeight(), this.afny);
      z(paramCanvas);
    }
    float f1 = this.agLA;
    float f2 = getHeightSpacing();
    float f3 = getDetailHeight();
    int i = 0;
    if (i < getFeatureCount())
    {
      Object localObject = getPresenter().getFeatures()[i];
      if ((this.agLS == i) || (i == this.uRE)) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = b((i)localObject, bool);
        if (localObject != null) {
          paramCanvas.drawBitmap((Bitmap)localObject, f1, f2 + f3, null);
        }
        f1 += getWidthSpacing() + getIconWidth();
        i += 1;
        break;
      }
    }
  }
  
  protected void z(Canvas paramCanvas)
  {
    Paint localPaint;
    if (aFZ(this.uRE) == i.hdO)
    {
      float f4 = getResources().getDimension(a.c.doodle_radio);
      float f5 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.agLH.getWidth() - 2.0F * f4 * agLQ.length) / agLQ.length;
      float f1 = getPaddingLeftAndRight() / 2;
      float f2 = com.tencent.mm.cl.a.eo(1.5F) + (f1 + f4);
      float f6 = (getDetailHeight() - f4 * 2.0F) / 2.0F + f4;
      int i = 0;
      if (i < agLQ.length)
      {
        float f3 = 0.0F;
        if (this.agLT == i)
        {
          f1 = com.tencent.mm.cl.a.eo(2.0F);
          this.agLU = false;
        }
        for (;;)
        {
          this.mAa.setColor(-1);
          paramCanvas.drawCircle(f2, f6, com.tencent.mm.cl.a.eo(1.5F) + f4 + f1, this.mAa);
          this.mAa.setColor(agLQ[i]);
          paramCanvas.drawCircle(f2, f6, f1 + f4, this.mAa);
          f2 += 2.0F * f4 + f5;
          i += 1;
          break;
          f1 = f3;
          if (this.agLU)
          {
            f1 = f3;
            if (i == 2) {
              f1 = com.tencent.mm.cl.a.eo(2.0F);
            }
          }
        }
      }
      localPaint = new Paint();
      if (!aED()) {
        break label330;
      }
      localPaint.setAlpha(255);
      if ((!this.agLO) || (!aED())) {
        break label341;
      }
    }
    label330:
    label341:
    for (Bitmap localBitmap = this.agLI;; localBitmap = this.agLH)
    {
      paramCanvas.drawBitmap(localBitmap, getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.agLH.getWidth(), (getDetailHeight() - this.agLH.getHeight()) / 2, localPaint);
      return;
      localPaint.setAlpha(160);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.footer.a
 * JD-Core Version:    0.7.0.1
 */