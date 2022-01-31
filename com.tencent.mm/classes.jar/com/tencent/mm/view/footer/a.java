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
import android.view.animation.AnimationUtils;
import com.tencent.mm.api.d;
import com.tencent.mm.api.p;
import com.tencent.mm.bo.a.a;
import com.tencent.mm.bo.a.b;
import com.tencent.mm.bo.a.c;
import com.tencent.mm.bo.a.d;
import com.tencent.mm.bo.a.e;
import com.tencent.mm.bo.a.g;
import com.tencent.mm.sdk.platformtools.c;

public abstract class a
  extends View
{
  public static final int[] wxV = { -1, -16777216, -707825, -17592, -16535286, -15172610, -7054596, -449092 };
  private com.tencent.mm.bt.b bzV;
  private Paint dHJ;
  protected int hnL = -1;
  protected Paint wwa;
  private final float wxF = getResources().getDimension(a.c.feature_padding);
  private Bitmap wxG;
  private Bitmap wxH;
  private Bitmap wxI;
  private Bitmap wxJ;
  private Bitmap wxK;
  private Bitmap wxL;
  protected Bitmap wxM;
  protected Bitmap wxN;
  protected int wxO = -1;
  protected int wxP = -1;
  private Rect[] wxQ;
  private Rect[] wxR;
  protected Rect wxS;
  protected boolean wxT;
  protected Paint wxU;
  protected int wxW = -1;
  protected int wxX = -1;
  private boolean wxY = true;
  
  public a(Context paramContext, com.tencent.mm.bt.b paramb)
  {
    super(paramContext);
    setId(a.e.base_footer_view_id);
    this.bzV = paramb;
    cLD();
  }
  
  private Bitmap b(d paramd, boolean paramBoolean)
  {
    Bitmap localBitmap1 = null;
    switch (a.3.soJ[paramd.ordinal()])
    {
    }
    for (;;)
    {
      Bitmap localBitmap2 = localBitmap1;
      if (localBitmap1 == null) {
        localBitmap2 = a(paramd, paramBoolean);
      }
      return localBitmap2;
      if (paramBoolean)
      {
        localBitmap1 = this.wxJ;
      }
      else
      {
        localBitmap1 = this.wxI;
        continue;
        if (paramBoolean)
        {
          localBitmap1 = this.wxL;
        }
        else
        {
          localBitmap1 = this.wxK;
          continue;
          if (paramBoolean) {
            localBitmap1 = this.wxH;
          } else {
            localBitmap1 = this.wxG;
          }
        }
      }
    }
  }
  
  private boolean cLE()
  {
    return getDetailHeight() > 0;
  }
  
  private void cLG()
  {
    if (this.wxR == null) {
      this.wxR = new Rect[wxV.length];
    }
    if (this.wxS == null) {
      this.wxS = new Rect();
    }
    float f1 = getResources().getDimension(a.c.doodle_radio);
    float f2 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.wxM.getWidth() - 2.0F * f1 * wxV.length) / wxV.length;
    int k = (int)(f1 * 2.0F);
    int j = (int)(getPaddingLeftAndRight() / 2 + f1 + 5.0F);
    int m = (int)((getDetailHeight() - f1 * 2.0F) / 2.0F + f1);
    int i = 0;
    while (i < wxV.length)
    {
      this.wxR[i] = new Rect(j - k, m - k, j + k, m + k);
      j = (int)(j + (2.0F * f1 + f2));
      i += 1;
    }
    i = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.wxM.getWidth() / 2;
    this.wxS.set(i - this.wxM.getWidth(), 0, i + this.wxM.getWidth(), getDetailHeight());
  }
  
  public static int getColor(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < wxV.length)) {
      return wxV[paramInt];
    }
    return -65536;
  }
  
  protected final d IR(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getFeatureCount())) {
      return getPresenter().getFeatures()[paramInt];
    }
    return d.buK;
  }
  
  protected boolean IS(int paramInt)
  {
    d locald = IR(paramInt);
    switch (a.3.soJ[locald.ordinal()])
    {
    case 2: 
    case 3: 
    default: 
      return false;
    }
    return true;
  }
  
  protected abstract Bitmap a(d paramd, boolean paramBoolean);
  
  protected void cLD()
  {
    this.wwa = new Paint(1);
    this.wwa.setColor(-16711936);
    this.wxU = new Paint(1);
    this.wxU.setColor(getResources().getColor(a.b.divider_line_color));
    this.wxU.setStrokeWidth(0.6F);
    this.dHJ = new Paint(1);
    this.dHJ.setStyle(Paint.Style.FILL);
    this.dHJ.setStrokeCap(Paint.Cap.ROUND);
    this.wxN = c.q(getResources().getDrawable(a.g.undo_press));
    this.wxM = c.q(getResources().getDrawable(a.g.undo_normal));
    this.wxG = c.q(getResources().getDrawable(a.g.doodle_unselected));
    this.wxH = c.q(getResources().getDrawable(a.g.doodle_selected));
    this.wxI = c.q(getResources().getDrawable(a.g.text_unselected));
    this.wxJ = c.q(getResources().getDrawable(a.g.text_selected));
    this.wxK = BitmapFactory.decodeResource(getResources(), a.d.emoji_unselected);
    this.wxL = BitmapFactory.decodeResource(getResources(), a.d.emoji_selected);
  }
  
  protected void cLF()
  {
    if (this.wxQ == null) {
      this.wxQ = new Rect[getFeatureCount()];
    }
    int j = (int)(this.wxF + getIconWidth() / 2.0F);
    int k = (int)getIconWidth();
    int i = 0;
    while (i < getFeatureCount())
    {
      this.wxQ[i] = new Rect(j - k, getDetailHeight(), j + k, getDetailHeight() + getMeasuredHeight());
      j = (int)(j + (getWidthSpacing() + getIconWidth()));
      i += 1;
    }
    if (IR(this.hnL) == d.buL) {
      cLG();
    }
  }
  
  public final void cLH()
  {
    this.wxO = this.wxP;
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
      if (cLE())
      {
        if ((this.wxS == null) || (!this.wxS.contains(j, k))) {
          break label124;
        }
        this.wxT = true;
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
        if (!this.wxQ[i].contains(j, k)) {
          break label50;
        }
        this.wxW = i;
        postInvalidate();
        return true;
        label124:
        fR(j, k);
      }
    }
    i = 0;
    if (i < getFeatureCount())
    {
      if ((!this.wxQ[i].contains(j, k)) || (this.wxW != i)) {
        break label352;
      }
      if (IS(i))
      {
        if (this.wxW != this.hnL) {
          this.hnL = this.wxW;
        }
      }
      else
      {
        label194:
        this.wxP = this.wxO;
        if (!IS(i)) {
          break label325;
        }
        this.wxO = this.hnL;
        getPresenter().getSelectedFeatureListener().a(IR(this.hnL));
      }
    }
    else
    {
      label240:
      if (cLE())
      {
        if ((this.wxS == null) || (!this.wxS.contains(j, k)) || (!this.wxT)) {
          break label359;
        }
        getPresenter().getSelectedFeatureListener().a(IR(this.hnL), -1);
      }
    }
    for (;;)
    {
      this.wxT = false;
      this.wxW = -1;
      requestLayout();
      postInvalidate();
      return true;
      this.hnL = -1;
      break label194;
      label325:
      this.wxO = i;
      getPresenter().getSelectedFeatureListener().a(IR(i));
      break label240;
      label352:
      i += 1;
      break;
      label359:
      fS(j, k);
    }
  }
  
  protected void fR(int paramInt1, int paramInt2)
  {
    switch (a.3.soJ[IR(this.hnL).ordinal()])
    {
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.wxR.length)
      {
        if (this.wxR[i].contains(paramInt1, paramInt2))
        {
          this.wxX = i;
          this.wxY = false;
          return;
        }
        i += 1;
      }
    }
  }
  
  protected void fS(int paramInt1, int paramInt2)
  {
    switch (a.3.soJ[IR(this.hnL).ordinal()])
    {
    }
    for (;;)
    {
      return;
      int i = 0;
      while ((this.wxR != null) && (i < this.wxR.length))
      {
        if ((this.wxR[i].contains(paramInt1, paramInt2)) && (i == this.wxX))
        {
          getPresenter().getSelectedFeatureListener().a(d.buL, i);
          return;
        }
        i += 1;
      }
    }
  }
  
  public d getCurFeatureType()
  {
    return IR(this.wxO);
  }
  
  protected int getDetailHeight()
  {
    if (IR(this.hnL) == d.buL) {
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
    Bitmap localBitmap = b(d.buL, false);
    if (localBitmap == null) {
      return 0.0F;
    }
    return localBitmap.getWidth();
  }
  
  public int getPaddingLeftAndRight()
  {
    return (int)(2.0F * this.wxF);
  }
  
  protected com.tencent.mm.bt.b getPresenter()
  {
    return this.bzV;
  }
  
  protected float getWidthSpacing()
  {
    return (getMeasuredWidth() - getFeatureCount() * getIconWidth() - getPaddingLeftAndRight()) / (getFeatureCount() - 1);
  }
  
  protected void n(Canvas paramCanvas)
  {
    if (cLE())
    {
      paramCanvas.drawLine(0.0F, getDetailHeight(), getMeasuredWidth(), getDetailHeight(), this.wxU);
      o(paramCanvas);
    }
    float f1 = this.wxF;
    float f2 = getHeightSpacing();
    float f3 = getDetailHeight();
    int i = 0;
    if (i < getFeatureCount())
    {
      Object localObject = getPresenter().getFeatures()[i];
      if ((this.wxW == i) || (i == this.hnL)) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = b((d)localObject, bool);
        if (localObject != null) {
          paramCanvas.drawBitmap((Bitmap)localObject, f1, f2 + f3, null);
        }
        f1 += getWidthSpacing() + getIconWidth();
        i += 1;
        break;
      }
    }
  }
  
  protected void o(Canvas paramCanvas)
  {
    Paint localPaint;
    if (IR(this.hnL) == d.buL)
    {
      float f4 = getResources().getDimension(a.c.doodle_radio);
      float f5 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.wxM.getWidth() - 2.0F * f4 * wxV.length) / wxV.length;
      float f1 = getPaddingLeftAndRight() / 2;
      float f2 = com.tencent.mm.cj.a.aR(1.5F) + (f1 + f4);
      float f6 = (getDetailHeight() - f4 * 2.0F) / 2.0F + f4;
      int i = 0;
      if (i < wxV.length)
      {
        float f3 = 0.0F;
        if (this.wxX == i)
        {
          f1 = com.tencent.mm.cj.a.aR(2.0F);
          this.wxY = false;
        }
        for (;;)
        {
          this.dHJ.setColor(-1);
          paramCanvas.drawCircle(f2, f6, com.tencent.mm.cj.a.aR(1.5F) + f4 + f1, this.dHJ);
          this.dHJ.setColor(wxV[i]);
          paramCanvas.drawCircle(f2, f6, f1 + f4, this.dHJ);
          f2 += 2.0F * f4 + f5;
          i += 1;
          break;
          f1 = f3;
          if (this.wxY)
          {
            f1 = f3;
            if (i == 2) {
              f1 = com.tencent.mm.cj.a.aR(2.0F);
            }
          }
        }
      }
      localPaint = new Paint();
      if (!tM()) {
        break label330;
      }
      localPaint.setAlpha(255);
      if ((!this.wxT) || (!tM())) {
        break label341;
      }
    }
    label330:
    label341:
    for (Bitmap localBitmap = this.wxN;; localBitmap = this.wxM)
    {
      paramCanvas.drawBitmap(localBitmap, getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.wxM.getWidth(), (getDetailHeight() - this.wxM.getHeight()) / 2, localPaint);
      return;
      localPaint.setAlpha(160);
      break;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0);
    n(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = getPaddingLeft();
    int k = getPaddingRight();
    paramInt2 = (int)getResources().getDimension(a.c.feature_select_layout_height);
    paramInt1 = paramInt2;
    if (cLE()) {
      paramInt1 = paramInt2 + getDetailHeight();
    }
    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i - j - k, 1073741824), paramInt1);
    cLF();
  }
  
  public void setCurFeatureType(d paramd)
  {
    int i = 0;
    if (i < getFeatureCount()) {
      if (getPresenter().getFeatures()[i] == paramd) {
        label25:
        if (!IS(i)) {
          break label64;
        }
      }
    }
    label64:
    for (this.hnL = i;; this.hnL = -1)
    {
      this.wxO = i;
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
      localAnimation.setAnimationListener(new a.1(this));
      startAnimation(localAnimation);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.alpha_out);
    localAnimation.setAnimationListener(new a.2(this));
    startAnimation(localAnimation);
  }
  
  protected final boolean tM()
  {
    com.tencent.mm.e.b localb = getPresenter().b(getCurFeatureType());
    if (localb == null) {
      return false;
    }
    return localb.tM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.footer.a
 * JD-Core Version:    0.7.0.1
 */