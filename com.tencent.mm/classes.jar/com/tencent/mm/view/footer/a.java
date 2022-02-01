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
  public static final int[] JAq = { -1, -16777216, -707825, -17592, -16535286, -15172610, -7054596, -449092 };
  private Bitmap JAa;
  private Bitmap JAb;
  private Bitmap JAc;
  private Bitmap JAd;
  private Bitmap JAe;
  private Bitmap JAf;
  protected Bitmap JAg;
  protected Bitmap JAh;
  protected int JAi = -1;
  protected int JAj = -1;
  private Rect[] JAk;
  private Rect[] JAl;
  protected Rect JAm;
  protected boolean JAn;
  protected Paint JAo;
  protected Paint JAp;
  protected boolean JAr = false;
  protected int JAs = -1;
  protected int JAt = -1;
  private boolean JAu = true;
  private final float JzZ = getResources().getDimension(2131166286);
  private com.tencent.mm.bt.b cOU;
  private Paint gfa;
  protected int mOX = -1;
  
  public a(Context paramContext, com.tencent.mm.bt.b paramb)
  {
    super(paramContext);
    setId(2131297188);
    this.cOU = paramb;
    fzg();
  }
  
  private Bitmap b(g paramg, boolean paramBoolean)
  {
    Bitmap localBitmap1 = null;
    switch (3.DHJ[paramg.ordinal()])
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
        localBitmap1 = this.JAd;
      }
      else
      {
        localBitmap1 = this.JAc;
        continue;
        if (paramBoolean)
        {
          localBitmap1 = this.JAf;
        }
        else
        {
          localBitmap1 = this.JAe;
          continue;
          if (paramBoolean) {
            localBitmap1 = this.JAb;
          } else {
            localBitmap1 = this.JAa;
          }
        }
      }
    }
  }
  
  private boolean fzh()
  {
    return getDetailHeight() > 0;
  }
  
  private void fzj()
  {
    if (this.JAl == null) {
      this.JAl = new Rect[JAq.length];
    }
    if (this.JAm == null) {
      this.JAm = new Rect();
    }
    float f1 = getResources().getDimension(2131166164);
    float f2 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.JAg.getWidth() - 2.0F * f1 * JAq.length) / JAq.length;
    int k = (int)(f1 * 2.0F);
    int j = (int)(getPaddingLeftAndRight() / 2 + f1 + 5.0F);
    int m = (int)((getDetailHeight() - f1 * 2.0F) / 2.0F + f1);
    int i = 0;
    while (i < JAq.length)
    {
      this.JAl[i] = new Rect(j - k, m - k, j + k, m + k);
      j = (int)(j + (2.0F * f1 + f2));
      i += 1;
    }
    i = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.JAg.getWidth() / 2;
    this.JAm.set(i - this.JAg.getWidth(), 0, i + this.JAg.getWidth(), getDetailHeight());
  }
  
  public static int getColor(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < JAq.length)) {
      return JAq[paramInt];
    }
    return -65536;
  }
  
  protected final boolean Me()
  {
    com.tencent.mm.e.b localb = getPresenter().c(getCurFeatureType());
    if (localb == null) {
      return false;
    }
    return localb.Me();
  }
  
  protected abstract Bitmap a(g paramg, boolean paramBoolean);
  
  protected final g adC(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getFeatureCount())) {
      return getPresenter().getFeatures()[paramInt];
    }
    return g.cGy;
  }
  
  protected boolean adD(int paramInt)
  {
    g localg = adC(paramInt);
    switch (3.DHJ[localg.ordinal()])
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
      if (fzh())
      {
        if ((this.JAm == null) || (!this.JAm.contains(j, k))) {
          break label124;
        }
        this.JAn = true;
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
        if (!this.JAk[i].contains(j, k)) {
          break label50;
        }
        this.JAs = i;
        postInvalidate();
        return true;
        label124:
        kh(j, k);
      }
    }
    i = 0;
    if (i < getFeatureCount())
    {
      if ((!this.JAk[i].contains(j, k)) || (this.JAs != i)) {
        break label360;
      }
      if (adD(i))
      {
        if (this.JAs != this.mOX) {
          this.mOX = this.JAs;
        }
      }
      else
      {
        label194:
        if (this.JAr) {
          break label360;
        }
        this.JAj = this.JAi;
        if (!adD(i)) {
          break label333;
        }
        this.JAi = this.mOX;
        getPresenter().getSelectedFeatureListener().a(adC(this.mOX));
      }
    }
    else
    {
      label247:
      if (fzh())
      {
        if ((this.JAm == null) || (!this.JAm.contains(j, k)) || (!this.JAn)) {
          break label367;
        }
        getPresenter().getSelectedFeatureListener().a(adC(this.mOX), -1, null);
      }
    }
    for (;;)
    {
      this.JAn = false;
      this.JAs = -1;
      requestLayout();
      postInvalidate();
      return true;
      this.mOX = -1;
      break label194;
      label333:
      this.JAi = i;
      getPresenter().getSelectedFeatureListener().a(adC(i));
      break label247;
      label360:
      i += 1;
      break;
      label367:
      ki(j, k);
    }
  }
  
  public final boolean fzf()
  {
    return this.JAr;
  }
  
  protected void fzg()
  {
    this.JAo = new Paint(1);
    this.JAo.setColor(-16711936);
    this.JAp = new Paint(1);
    this.JAp.setColor(getResources().getColor(2131100253));
    this.JAp.setStrokeWidth(0.6F);
    this.gfa = new Paint(1);
    this.gfa.setStyle(Paint.Style.FILL);
    this.gfa.setStrokeCap(Paint.Cap.ROUND);
    this.JAh = f.A(getResources().getDrawable(2131691346));
    this.JAg = f.A(getResources().getDrawable(2131691345));
    this.JAa = f.A(getResources().getDrawable(2131690057));
    this.JAb = f.A(getResources().getDrawable(2131690056));
    this.JAc = f.A(getResources().getDrawable(2131691277));
    this.JAd = f.A(getResources().getDrawable(2131691276));
    this.JAe = BitmapFactory.decodeResource(getResources(), 2131232082);
    this.JAf = BitmapFactory.decodeResource(getResources(), 2131232076);
  }
  
  protected void fzi()
  {
    if (this.JAk == null) {
      this.JAk = new Rect[getFeatureCount()];
    }
    int j = (int)(this.JzZ + getIconWidth() / 2.0F);
    int k = (int)getIconWidth();
    int i = 0;
    while (i < getFeatureCount())
    {
      this.JAk[i] = new Rect(j - k, getDetailHeight(), j + k, getDetailHeight() + getMeasuredHeight());
      j = (int)(j + (getWidthSpacing() + getIconWidth()));
      i += 1;
    }
    if (adC(this.mOX) == g.cGz) {
      fzj();
    }
  }
  
  public final void fzk()
  {
    this.JAj = this.JAi;
  }
  
  public final void fzl()
  {
    this.JAi = this.JAj;
    requestLayout();
    invalidate();
  }
  
  public g getCurFeatureType()
  {
    return adC(this.JAi);
  }
  
  protected int getDetailHeight()
  {
    if (adC(this.mOX) == g.cGz) {
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
    Bitmap localBitmap = b(g.cGz, false);
    if (localBitmap == null) {
      return 0.0F;
    }
    return localBitmap.getWidth();
  }
  
  public int getPaddingLeftAndRight()
  {
    return (int)(2.0F * this.JzZ);
  }
  
  protected com.tencent.mm.bt.b getPresenter()
  {
    return this.cOU;
  }
  
  protected float getWidthSpacing()
  {
    return (getMeasuredWidth() - getFeatureCount() * getIconWidth() - getPaddingLeftAndRight()) / (getFeatureCount() - 1);
  }
  
  protected void kh(int paramInt1, int paramInt2)
  {
    switch (3.DHJ[adC(this.mOX).ordinal()])
    {
    }
    for (;;)
    {
      return;
      if (this.JAl != null)
      {
        int i = 0;
        while (i < this.JAl.length)
        {
          if (this.JAl[i].contains(paramInt1, paramInt2))
          {
            this.JAt = i;
            this.JAu = false;
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  protected void ki(int paramInt1, int paramInt2)
  {
    switch (3.DHJ[adC(this.mOX).ordinal()])
    {
    }
    for (;;)
    {
      return;
      int i = 0;
      while ((this.JAl != null) && (i < this.JAl.length))
      {
        if ((this.JAl[i].contains(paramInt1, paramInt2)) && (i == this.JAt))
        {
          getPresenter().getSelectedFeatureListener().a(g.cGz, i, null);
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
    if (fzh()) {
      paramInt1 = paramInt2 + getDetailHeight();
    }
    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i - j - k, 1073741824), paramInt1);
    fzi();
  }
  
  protected void r(Canvas paramCanvas)
  {
    if (fzh())
    {
      paramCanvas.drawLine(0.0F, getDetailHeight(), getMeasuredWidth(), getDetailHeight(), this.JAp);
      s(paramCanvas);
    }
    float f1 = this.JzZ;
    float f2 = getHeightSpacing();
    float f3 = getDetailHeight();
    int i = 0;
    if (i < getFeatureCount())
    {
      Object localObject = getPresenter().getFeatures()[i];
      if ((this.JAs == i) || (i == this.mOX)) {}
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
    if (adC(this.mOX) == g.cGz)
    {
      float f4 = getResources().getDimension(2131166164);
      float f5 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.JAg.getWidth() - 2.0F * f4 * JAq.length) / JAq.length;
      float f1 = getPaddingLeftAndRight() / 2;
      float f2 = com.tencent.mm.cm.a.bY(1.5F) + (f1 + f4);
      float f6 = (getDetailHeight() - f4 * 2.0F) / 2.0F + f4;
      int i = 0;
      if (i < JAq.length)
      {
        float f3 = 0.0F;
        if (this.JAt == i)
        {
          f1 = com.tencent.mm.cm.a.bY(2.0F);
          this.JAu = false;
        }
        for (;;)
        {
          this.gfa.setColor(-1);
          paramCanvas.drawCircle(f2, f6, com.tencent.mm.cm.a.bY(1.5F) + f4 + f1, this.gfa);
          this.gfa.setColor(JAq[i]);
          paramCanvas.drawCircle(f2, f6, f1 + f4, this.gfa);
          f2 += 2.0F * f4 + f5;
          i += 1;
          break;
          f1 = f3;
          if (this.JAu)
          {
            f1 = f3;
            if (i == 2) {
              f1 = com.tencent.mm.cm.a.bY(2.0F);
            }
          }
        }
      }
      localPaint = new Paint();
      if (!Me()) {
        break label329;
      }
      localPaint.setAlpha(255);
      if ((!this.JAn) || (!Me())) {
        break label340;
      }
    }
    label329:
    label340:
    for (Bitmap localBitmap = this.JAh;; localBitmap = this.JAg)
    {
      paramCanvas.drawBitmap(localBitmap, getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.JAg.getWidth(), (getDetailHeight() - this.JAg.getHeight()) / 2, localPaint);
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
        if (!adD(i)) {
          break label64;
        }
      }
    }
    label64:
    for (this.mOX = i;; this.mOX = -1)
    {
      this.JAi = i;
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
    this.JAr = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.footer.a
 * JD-Core Version:    0.7.0.1
 */