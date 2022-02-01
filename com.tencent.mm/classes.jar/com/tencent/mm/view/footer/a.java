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
import com.tencent.mm.api.h;
import com.tencent.mm.api.z;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public abstract class a
  extends View
{
  public static final int[] RoQ = { -1, -16777216, -707825, -17592, -16535286, -15172610, -7054596, -449092 };
  private Bitmap RoA;
  private Bitmap RoB;
  private Bitmap RoC;
  private Bitmap RoD;
  private Bitmap RoE;
  private Bitmap RoF;
  protected Bitmap RoG;
  protected Bitmap RoH;
  protected int RoI = -1;
  protected int RoJ = -1;
  private Rect[] RoK;
  private Rect[] RoL;
  protected Rect RoM;
  protected boolean RoN;
  protected Paint RoO;
  protected Paint RoP;
  protected boolean RoR = false;
  protected int RoS = -1;
  protected int RoT = -1;
  private boolean RoU = true;
  private final float Roz = getResources().getDimension(2131166333);
  private com.tencent.mm.bt.b drS;
  private Paint hog;
  protected int oEI = -1;
  
  public a(Context paramContext, com.tencent.mm.bt.b paramb)
  {
    super(paramContext);
    setId(2131297333);
    this.drS = paramb;
    hgh();
  }
  
  private Bitmap b(h paramh, boolean paramBoolean)
  {
    Bitmap localBitmap1 = null;
    switch (3.Kyu[paramh.ordinal()])
    {
    }
    for (;;)
    {
      Bitmap localBitmap2 = localBitmap1;
      if (localBitmap1 == null) {
        localBitmap2 = a(paramh, paramBoolean);
      }
      return localBitmap2;
      if (paramBoolean)
      {
        localBitmap1 = this.RoD;
      }
      else
      {
        localBitmap1 = this.RoC;
        continue;
        if (paramBoolean)
        {
          localBitmap1 = this.RoF;
        }
        else
        {
          localBitmap1 = this.RoE;
          continue;
          if (paramBoolean) {
            localBitmap1 = this.RoB;
          } else {
            localBitmap1 = this.RoA;
          }
        }
      }
    }
  }
  
  private boolean hgi()
  {
    return getDetailHeight() > 0;
  }
  
  private void hgk()
  {
    if (this.RoL == null) {
      this.RoL = new Rect[RoQ.length];
    }
    if (this.RoM == null) {
      this.RoM = new Rect();
    }
    float f1 = getResources().getDimension(2131166205);
    float f2 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.RoG.getWidth() - 2.0F * f1 * RoQ.length) / RoQ.length;
    int k = (int)(f1 * 2.0F);
    int j = (int)(getPaddingLeftAndRight() / 2 + f1 + 5.0F);
    int m = (int)((getDetailHeight() - f1 * 2.0F) / 2.0F + f1);
    int i = 0;
    while (i < RoQ.length)
    {
      this.RoL[i] = new Rect(j - k, m - k, j + k, m + k);
      j = (int)(j + (2.0F * f1 + f2));
      i += 1;
    }
    i = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.RoG.getWidth() / 2;
    this.RoM.set(i - this.RoG.getWidth(), 0, i + this.RoG.getWidth(), getDetailHeight());
  }
  
  protected void A(Canvas paramCanvas)
  {
    if (hgi())
    {
      paramCanvas.drawLine(0.0F, getDetailHeight(), getMeasuredWidth(), getDetailHeight(), this.RoP);
      B(paramCanvas);
    }
    float f1 = this.Roz;
    float f2 = getHeightSpacing();
    float f3 = getDetailHeight();
    int i = 0;
    if (i < getFeatureCount())
    {
      Object localObject = getPresenter().getFeatures()[i];
      if ((this.RoS == i) || (i == this.oEI)) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = b((h)localObject, bool);
        if (localObject != null) {
          paramCanvas.drawBitmap((Bitmap)localObject, f1, f2 + f3, null);
        }
        f1 += getWidthSpacing() + getIconWidth();
        i += 1;
        break;
      }
    }
  }
  
  protected void B(Canvas paramCanvas)
  {
    Paint localPaint;
    if (apW(this.oEI) == h.diH)
    {
      float f4 = getResources().getDimension(2131166205);
      float f5 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.RoG.getWidth() - 2.0F * f4 * RoQ.length) / RoQ.length;
      float f1 = getPaddingLeftAndRight() / 2;
      float f2 = com.tencent.mm.cl.a.ao(1.5F) + (f1 + f4);
      float f6 = (getDetailHeight() - f4 * 2.0F) / 2.0F + f4;
      int i = 0;
      if (i < RoQ.length)
      {
        float f3 = 0.0F;
        if (this.RoT == i)
        {
          f1 = com.tencent.mm.cl.a.ao(2.0F);
          this.RoU = false;
        }
        for (;;)
        {
          this.hog.setColor(-1);
          paramCanvas.drawCircle(f2, f6, com.tencent.mm.cl.a.ao(1.5F) + f4 + f1, this.hog);
          this.hog.setColor(RoQ[i]);
          paramCanvas.drawCircle(f2, f6, f1 + f4, this.hog);
          f2 += 2.0F * f4 + f5;
          i += 1;
          break;
          f1 = f3;
          if (this.RoU)
          {
            f1 = f3;
            if (i == 2) {
              f1 = com.tencent.mm.cl.a.ao(2.0F);
            }
          }
        }
      }
      localPaint = new Paint();
      if (!XX()) {
        break label327;
      }
      localPaint.setAlpha(255);
      if ((!this.RoN) || (!XX())) {
        break label338;
      }
    }
    label327:
    label338:
    for (Bitmap localBitmap = this.RoH;; localBitmap = this.RoG)
    {
      paramCanvas.drawBitmap(localBitmap, getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.RoG.getWidth(), (getDetailHeight() - this.RoG.getHeight()) / 2, localPaint);
      return;
      localPaint.setAlpha(160);
      break;
    }
  }
  
  protected final boolean XX()
  {
    com.tencent.mm.e.b localb = getPresenter().c(getCurFeatureType());
    if (localb == null) {
      return false;
    }
    return localb.XX();
  }
  
  protected abstract Bitmap a(h paramh, boolean paramBoolean);
  
  protected final h apW(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getFeatureCount())) {
      return getPresenter().getFeatures()[paramInt];
    }
    return h.diG;
  }
  
  protected boolean apX(int paramInt)
  {
    h localh = apW(paramInt);
    switch (3.Kyu[localh.ordinal()])
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
      if (hgi())
      {
        if ((this.RoM == null) || (!this.RoM.contains(j, k))) {
          break label124;
        }
        this.RoN = true;
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
        if (!this.RoK[i].contains(j, k)) {
          break label50;
        }
        this.RoS = i;
        postInvalidate();
        return true;
        label124:
        mc(j, k);
      }
    }
    i = 0;
    if (i < getFeatureCount())
    {
      if ((!this.RoK[i].contains(j, k)) || (this.RoS != i)) {
        break label360;
      }
      if (apX(i))
      {
        if (this.RoS != this.oEI) {
          this.oEI = this.RoS;
        }
      }
      else
      {
        label194:
        if (this.RoR) {
          break label360;
        }
        this.RoJ = this.RoI;
        if (!apX(i)) {
          break label333;
        }
        this.RoI = this.oEI;
        getPresenter().getSelectedFeatureListener().a(apW(this.oEI));
      }
    }
    else
    {
      label247:
      if (hgi())
      {
        if ((this.RoM == null) || (!this.RoM.contains(j, k)) || (!this.RoN)) {
          break label367;
        }
        getPresenter().getSelectedFeatureListener().a(apW(this.oEI), -1, null);
      }
    }
    for (;;)
    {
      this.RoN = false;
      this.RoS = -1;
      requestLayout();
      postInvalidate();
      return true;
      this.oEI = -1;
      break label194;
      label333:
      this.RoI = i;
      getPresenter().getSelectedFeatureListener().a(apW(i));
      break label247;
      label360:
      i += 1;
      break;
      label367:
      md(j, k);
    }
  }
  
  public int getColor(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < RoQ.length)) {
      return RoQ[paramInt];
    }
    return -65536;
  }
  
  public h getCurFeatureType()
  {
    return apW(this.RoI);
  }
  
  protected int getDetailHeight()
  {
    if (apW(this.oEI) == h.diH) {
      return (int)getResources().getDimension(2131166335);
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
    Bitmap localBitmap = b(h.diH, false);
    if (localBitmap == null) {
      return 0.0F;
    }
    return localBitmap.getWidth();
  }
  
  public int getPaddingLeftAndRight()
  {
    return (int)(2.0F * this.Roz);
  }
  
  protected com.tencent.mm.bt.b getPresenter()
  {
    return this.drS;
  }
  
  protected float getWidthSpacing()
  {
    return (getMeasuredWidth() - getFeatureCount() * getIconWidth() - getPaddingLeftAndRight()) / (getFeatureCount() - 1);
  }
  
  public final boolean hgg()
  {
    return this.RoR;
  }
  
  protected void hgh()
  {
    this.RoO = new Paint(1);
    this.RoO.setColor(-16711936);
    this.RoP = new Paint(1);
    this.RoP.setColor(getResources().getColor(2131100287));
    this.RoP.setStrokeWidth(0.6F);
    this.hog = new Paint(1);
    this.hog.setStyle(Paint.Style.FILL);
    this.hog.setStrokeCap(Paint.Cap.ROUND);
    this.RoH = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(2131691678));
    this.RoG = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(2131691677));
    this.RoA = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(2131690089));
    this.RoB = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(2131690088));
    this.RoC = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(2131691609));
    this.RoD = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(2131691608));
    this.RoE = BitmapFactory.decodeResource(getResources(), 2131232174);
    this.RoF = BitmapFactory.decodeResource(getResources(), 2131232168);
  }
  
  protected void hgj()
  {
    if (this.RoK == null) {
      this.RoK = new Rect[getFeatureCount()];
    }
    int j = (int)(this.Roz + getIconWidth() / 2.0F);
    int k = (int)getIconWidth();
    int i = 0;
    while (i < getFeatureCount())
    {
      this.RoK[i] = new Rect(j - k, getDetailHeight(), j + k, getDetailHeight() + getMeasuredHeight());
      j = (int)(j + (getWidthSpacing() + getIconWidth()));
      i += 1;
    }
    if (apW(this.oEI) == h.diH) {
      hgk();
    }
  }
  
  public final void hgl()
  {
    this.RoJ = this.RoI;
  }
  
  public final void hgm()
  {
    this.RoI = this.RoJ;
    requestLayout();
    invalidate();
  }
  
  protected void mc(int paramInt1, int paramInt2)
  {
    switch (3.Kyu[apW(this.oEI).ordinal()])
    {
    }
    for (;;)
    {
      return;
      if (this.RoL != null)
      {
        int i = 0;
        while (i < this.RoL.length)
        {
          if (this.RoL[i].contains(paramInt1, paramInt2))
          {
            this.RoT = i;
            this.RoU = false;
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  protected void md(int paramInt1, int paramInt2)
  {
    switch (3.Kyu[apW(this.oEI).ordinal()])
    {
    }
    for (;;)
    {
      return;
      int i = 0;
      while ((this.RoL != null) && (i < this.RoL.length))
      {
        if ((this.RoL[i].contains(paramInt1, paramInt2)) && (i == this.RoT))
        {
          getPresenter().getSelectedFeatureListener().a(h.diH, i, null);
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
    A(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = getPaddingLeft();
    int k = getPaddingRight();
    paramInt2 = (int)getResources().getDimension(2131166336);
    paramInt1 = paramInt2;
    if (hgi()) {
      paramInt1 = paramInt2 + getDetailHeight();
    }
    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i - j - k, 1073741824), paramInt1);
    hgj();
  }
  
  public void setCurFeatureType(h paramh)
  {
    int i = 0;
    if (i < getFeatureCount()) {
      if (getPresenter().getFeatures()[i] == paramh) {
        label25:
        if (!apX(i)) {
          break label64;
        }
      }
    }
    label64:
    for (this.oEI = i;; this.oEI = -1)
    {
      this.RoI = i;
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
    this.RoR = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.footer.a
 * JD-Core Version:    0.7.0.1
 */