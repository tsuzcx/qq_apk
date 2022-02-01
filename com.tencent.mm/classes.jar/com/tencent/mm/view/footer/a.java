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
import com.tencent.mm.sdk.platformtools.h;

public abstract class a
  extends View
{
  public static final int[] LQk = { -1, -16777216, -707825, -17592, -16535286, -15172610, -7054596, -449092 };
  private final float LPT = getResources().getDimension(2131166286);
  private Bitmap LPU;
  private Bitmap LPV;
  private Bitmap LPW;
  private Bitmap LPX;
  private Bitmap LPY;
  private Bitmap LPZ;
  protected Bitmap LQa;
  protected Bitmap LQb;
  protected int LQc = -1;
  protected int LQd = -1;
  private Rect[] LQe;
  private Rect[] LQf;
  protected Rect LQg;
  protected boolean LQh;
  protected Paint LQi;
  protected Paint LQj;
  protected boolean LQl = false;
  protected int LQm = -1;
  protected int LQn = -1;
  private boolean LQo = true;
  private com.tencent.mm.bt.b dbm;
  private Paint gBr;
  protected int nuE = -1;
  
  public a(Context paramContext, com.tencent.mm.bt.b paramb)
  {
    super(paramContext);
    setId(2131297188);
    this.dbm = paramb;
    fUL();
  }
  
  private Bitmap b(g paramg, boolean paramBoolean)
  {
    Bitmap localBitmap1 = null;
    switch (a.3.FFo[paramg.ordinal()])
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
        localBitmap1 = this.LPX;
      }
      else
      {
        localBitmap1 = this.LPW;
        continue;
        if (paramBoolean)
        {
          localBitmap1 = this.LPZ;
        }
        else
        {
          localBitmap1 = this.LPY;
          continue;
          if (paramBoolean) {
            localBitmap1 = this.LPV;
          } else {
            localBitmap1 = this.LPU;
          }
        }
      }
    }
  }
  
  private boolean fUM()
  {
    return getDetailHeight() > 0;
  }
  
  private void fUO()
  {
    if (this.LQf == null) {
      this.LQf = new Rect[LQk.length];
    }
    if (this.LQg == null) {
      this.LQg = new Rect();
    }
    float f1 = getResources().getDimension(2131166164);
    float f2 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.LQa.getWidth() - 2.0F * f1 * LQk.length) / LQk.length;
    int k = (int)(f1 * 2.0F);
    int j = (int)(getPaddingLeftAndRight() / 2 + f1 + 5.0F);
    int m = (int)((getDetailHeight() - f1 * 2.0F) / 2.0F + f1);
    int i = 0;
    while (i < LQk.length)
    {
      this.LQf[i] = new Rect(j - k, m - k, j + k, m + k);
      j = (int)(j + (2.0F * f1 + f2));
      i += 1;
    }
    i = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.LQa.getWidth() / 2;
    this.LQg.set(i - this.LQa.getWidth(), 0, i + this.LQa.getWidth(), getDetailHeight());
  }
  
  public static int getColor(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < LQk.length)) {
      return LQk[paramInt];
    }
    return -65536;
  }
  
  protected final boolean NL()
  {
    com.tencent.mm.e.b localb = getPresenter().c(getCurFeatureType());
    if (localb == null) {
      return false;
    }
    return localb.NL();
  }
  
  protected abstract Bitmap a(g paramg, boolean paramBoolean);
  
  protected final g agL(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getFeatureCount())) {
      return getPresenter().getFeatures()[paramInt];
    }
    return g.cSm;
  }
  
  protected boolean agM(int paramInt)
  {
    g localg = agL(paramInt);
    switch (a.3.FFo[localg.ordinal()])
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
      if (fUM())
      {
        if ((this.LQg == null) || (!this.LQg.contains(j, k))) {
          break label124;
        }
        this.LQh = true;
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
        if (!this.LQe[i].contains(j, k)) {
          break label50;
        }
        this.LQm = i;
        postInvalidate();
        return true;
        label124:
        kE(j, k);
      }
    }
    i = 0;
    if (i < getFeatureCount())
    {
      if ((!this.LQe[i].contains(j, k)) || (this.LQm != i)) {
        break label360;
      }
      if (agM(i))
      {
        if (this.LQm != this.nuE) {
          this.nuE = this.LQm;
        }
      }
      else
      {
        label194:
        if (this.LQl) {
          break label360;
        }
        this.LQd = this.LQc;
        if (!agM(i)) {
          break label333;
        }
        this.LQc = this.nuE;
        getPresenter().getSelectedFeatureListener().a(agL(this.nuE));
      }
    }
    else
    {
      label247:
      if (fUM())
      {
        if ((this.LQg == null) || (!this.LQg.contains(j, k)) || (!this.LQh)) {
          break label367;
        }
        getPresenter().getSelectedFeatureListener().a(agL(this.nuE), -1, null);
      }
    }
    for (;;)
    {
      this.LQh = false;
      this.LQm = -1;
      requestLayout();
      postInvalidate();
      return true;
      this.nuE = -1;
      break label194;
      label333:
      this.LQc = i;
      getPresenter().getSelectedFeatureListener().a(agL(i));
      break label247;
      label360:
      i += 1;
      break;
      label367:
      kF(j, k);
    }
  }
  
  public final boolean fUK()
  {
    return this.LQl;
  }
  
  protected void fUL()
  {
    this.LQi = new Paint(1);
    this.LQi.setColor(-16711936);
    this.LQj = new Paint(1);
    this.LQj.setColor(getResources().getColor(2131100253));
    this.LQj.setStrokeWidth(0.6F);
    this.gBr = new Paint(1);
    this.gBr.setStyle(Paint.Style.FILL);
    this.gBr.setStrokeCap(Paint.Cap.ROUND);
    this.LQb = h.B(getResources().getDrawable(2131691346));
    this.LQa = h.B(getResources().getDrawable(2131691345));
    this.LPU = h.B(getResources().getDrawable(2131690057));
    this.LPV = h.B(getResources().getDrawable(2131690056));
    this.LPW = h.B(getResources().getDrawable(2131691277));
    this.LPX = h.B(getResources().getDrawable(2131691276));
    this.LPY = BitmapFactory.decodeResource(getResources(), 2131232082);
    this.LPZ = BitmapFactory.decodeResource(getResources(), 2131232076);
  }
  
  protected void fUN()
  {
    if (this.LQe == null) {
      this.LQe = new Rect[getFeatureCount()];
    }
    int j = (int)(this.LPT + getIconWidth() / 2.0F);
    int k = (int)getIconWidth();
    int i = 0;
    while (i < getFeatureCount())
    {
      this.LQe[i] = new Rect(j - k, getDetailHeight(), j + k, getDetailHeight() + getMeasuredHeight());
      j = (int)(j + (getWidthSpacing() + getIconWidth()));
      i += 1;
    }
    if (agL(this.nuE) == g.cSn) {
      fUO();
    }
  }
  
  public final void fUP()
  {
    this.LQd = this.LQc;
  }
  
  public final void fUQ()
  {
    this.LQc = this.LQd;
    requestLayout();
    invalidate();
  }
  
  public g getCurFeatureType()
  {
    return agL(this.LQc);
  }
  
  protected int getDetailHeight()
  {
    if (agL(this.nuE) == g.cSn) {
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
    Bitmap localBitmap = b(g.cSn, false);
    if (localBitmap == null) {
      return 0.0F;
    }
    return localBitmap.getWidth();
  }
  
  public int getPaddingLeftAndRight()
  {
    return (int)(2.0F * this.LPT);
  }
  
  protected com.tencent.mm.bt.b getPresenter()
  {
    return this.dbm;
  }
  
  protected float getWidthSpacing()
  {
    return (getMeasuredWidth() - getFeatureCount() * getIconWidth() - getPaddingLeftAndRight()) / (getFeatureCount() - 1);
  }
  
  protected void kE(int paramInt1, int paramInt2)
  {
    switch (a.3.FFo[agL(this.nuE).ordinal()])
    {
    }
    for (;;)
    {
      return;
      if (this.LQf != null)
      {
        int i = 0;
        while (i < this.LQf.length)
        {
          if (this.LQf[i].contains(paramInt1, paramInt2))
          {
            this.LQn = i;
            this.LQo = false;
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  protected void kF(int paramInt1, int paramInt2)
  {
    switch (a.3.FFo[agL(this.nuE).ordinal()])
    {
    }
    for (;;)
    {
      return;
      int i = 0;
      while ((this.LQf != null) && (i < this.LQf.length))
      {
        if ((this.LQf[i].contains(paramInt1, paramInt2)) && (i == this.LQn))
        {
          getPresenter().getSelectedFeatureListener().a(g.cSn, i, null);
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
    if (fUM()) {
      paramInt1 = paramInt2 + getDetailHeight();
    }
    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i - j - k, 1073741824), paramInt1);
    fUN();
  }
  
  protected void q(Canvas paramCanvas)
  {
    if (fUM())
    {
      paramCanvas.drawLine(0.0F, getDetailHeight(), getMeasuredWidth(), getDetailHeight(), this.LQj);
      r(paramCanvas);
    }
    float f1 = this.LPT;
    float f2 = getHeightSpacing();
    float f3 = getDetailHeight();
    int i = 0;
    if (i < getFeatureCount())
    {
      Object localObject = getPresenter().getFeatures()[i];
      if ((this.LQm == i) || (i == this.nuE)) {}
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
  
  protected void r(Canvas paramCanvas)
  {
    Paint localPaint;
    if (agL(this.nuE) == g.cSn)
    {
      float f4 = getResources().getDimension(2131166164);
      float f5 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.LQa.getWidth() - 2.0F * f4 * LQk.length) / LQk.length;
      float f1 = getPaddingLeftAndRight() / 2;
      float f2 = com.tencent.mm.cl.a.cb(1.5F) + (f1 + f4);
      float f6 = (getDetailHeight() - f4 * 2.0F) / 2.0F + f4;
      int i = 0;
      if (i < LQk.length)
      {
        float f3 = 0.0F;
        if (this.LQn == i)
        {
          f1 = com.tencent.mm.cl.a.cb(2.0F);
          this.LQo = false;
        }
        for (;;)
        {
          this.gBr.setColor(-1);
          paramCanvas.drawCircle(f2, f6, com.tencent.mm.cl.a.cb(1.5F) + f4 + f1, this.gBr);
          this.gBr.setColor(LQk[i]);
          paramCanvas.drawCircle(f2, f6, f1 + f4, this.gBr);
          f2 += 2.0F * f4 + f5;
          i += 1;
          break;
          f1 = f3;
          if (this.LQo)
          {
            f1 = f3;
            if (i == 2) {
              f1 = com.tencent.mm.cl.a.cb(2.0F);
            }
          }
        }
      }
      localPaint = new Paint();
      if (!NL()) {
        break label329;
      }
      localPaint.setAlpha(255);
      if ((!this.LQh) || (!NL())) {
        break label340;
      }
    }
    label329:
    label340:
    for (Bitmap localBitmap = this.LQb;; localBitmap = this.LQa)
    {
      paramCanvas.drawBitmap(localBitmap, getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.LQa.getWidth(), (getDetailHeight() - this.LQa.getHeight()) / 2, localPaint);
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
        if (!agM(i)) {
          break label64;
        }
      }
    }
    label64:
    for (this.nuE = i;; this.nuE = -1)
    {
      this.LQc = i;
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
    this.LQl = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.footer.a
 * JD-Core Version:    0.7.0.1
 */