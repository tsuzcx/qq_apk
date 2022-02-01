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
import com.tencent.mm.bv.a.a;
import com.tencent.mm.bv.a.b;
import com.tencent.mm.bv.a.c;
import com.tencent.mm.bv.a.d;
import com.tencent.mm.bv.a.e;
import com.tencent.mm.bv.a.g;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public abstract class a
  extends View
{
  public static final int[] YQk = { -1, -16777216, -707825, -17592, -16535286, -15172610, -7054596, -449092 };
  private final float YPT = getResources().getDimension(a.c.feature_padding);
  private Bitmap YPU;
  private Bitmap YPV;
  private Bitmap YPW;
  private Bitmap YPX;
  private Bitmap YPY;
  private Bitmap YPZ;
  protected Bitmap YQa;
  protected Bitmap YQb;
  protected int YQc = -1;
  protected int YQd = -1;
  private Rect[] YQe;
  private Rect[] YQf;
  protected Rect YQg;
  protected boolean YQh;
  protected Paint YQi;
  protected Paint YQj;
  protected boolean YQl = false;
  protected int YQm = -1;
  protected int YQn = -1;
  private boolean YQo = true;
  private com.tencent.mm.ca.b fkE;
  private Paint jZX;
  protected int rGs = -1;
  
  public a(Context paramContext, com.tencent.mm.ca.b paramb)
  {
    super(paramContext);
    setId(a.e.base_footer_view_id);
    this.fkE = paramb;
    ihI();
  }
  
  private Bitmap b(h paramh, boolean paramBoolean)
  {
    Bitmap localBitmap1 = null;
    switch (3.RAi[paramh.ordinal()])
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
        localBitmap1 = this.YPX;
      }
      else
      {
        localBitmap1 = this.YPW;
        continue;
        if (paramBoolean)
        {
          localBitmap1 = this.YPZ;
        }
        else
        {
          localBitmap1 = this.YPY;
          continue;
          if (paramBoolean) {
            localBitmap1 = this.YPV;
          } else {
            localBitmap1 = this.YPU;
          }
        }
      }
    }
  }
  
  private boolean ihJ()
  {
    return getDetailHeight() > 0;
  }
  
  private void ihL()
  {
    if (this.YQf == null) {
      this.YQf = new Rect[YQk.length];
    }
    if (this.YQg == null) {
      this.YQg = new Rect();
    }
    float f1 = getResources().getDimension(a.c.doodle_radio);
    float f2 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.YQa.getWidth() - 2.0F * f1 * YQk.length) / YQk.length;
    int k = (int)(f1 * 2.0F);
    int j = (int)(getPaddingLeftAndRight() / 2 + f1 + 5.0F);
    int m = (int)((getDetailHeight() - f1 * 2.0F) / 2.0F + f1);
    int i = 0;
    while (i < YQk.length)
    {
      this.YQf[i] = new Rect(j - k, m - k, j + k, m + k);
      j = (int)(j + (2.0F * f1 + f2));
      i += 1;
    }
    i = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.YQa.getWidth() / 2;
    this.YQg.set(i - this.YQa.getWidth(), 0, i + this.YQa.getWidth(), getDetailHeight());
  }
  
  protected void D(Canvas paramCanvas)
  {
    if (ihJ())
    {
      paramCanvas.drawLine(0.0F, getDetailHeight(), getMeasuredWidth(), getDetailHeight(), this.YQj);
      E(paramCanvas);
    }
    float f1 = this.YPT;
    float f2 = getHeightSpacing();
    float f3 = getDetailHeight();
    int i = 0;
    if (i < getFeatureCount())
    {
      Object localObject = getPresenter().getFeatures()[i];
      if ((this.YQm == i) || (i == this.rGs)) {}
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
  
  protected void E(Canvas paramCanvas)
  {
    Paint localPaint;
    if (azv(this.rGs) == h.fan)
    {
      float f4 = getResources().getDimension(a.c.doodle_radio);
      float f5 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.YQa.getWidth() - 2.0F * f4 * YQk.length) / YQk.length;
      float f1 = getPaddingLeftAndRight() / 2;
      float f2 = com.tencent.mm.cs.a.an(1.5F) + (f1 + f4);
      float f6 = (getDetailHeight() - f4 * 2.0F) / 2.0F + f4;
      int i = 0;
      if (i < YQk.length)
      {
        float f3 = 0.0F;
        if (this.YQn == i)
        {
          f1 = com.tencent.mm.cs.a.an(2.0F);
          this.YQo = false;
        }
        for (;;)
        {
          this.jZX.setColor(-1);
          paramCanvas.drawCircle(f2, f6, com.tencent.mm.cs.a.an(1.5F) + f4 + f1, this.jZX);
          this.jZX.setColor(YQk[i]);
          paramCanvas.drawCircle(f2, f6, f1 + f4, this.jZX);
          f2 += 2.0F * f4 + f5;
          i += 1;
          break;
          f1 = f3;
          if (this.YQo)
          {
            f1 = f3;
            if (i == 2) {
              f1 = com.tencent.mm.cs.a.an(2.0F);
            }
          }
        }
      }
      localPaint = new Paint();
      if (!acD()) {
        break label328;
      }
      localPaint.setAlpha(255);
      if ((!this.YQh) || (!acD())) {
        break label339;
      }
    }
    label328:
    label339:
    for (Bitmap localBitmap = this.YQb;; localBitmap = this.YQa)
    {
      paramCanvas.drawBitmap(localBitmap, getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.YQa.getWidth(), (getDetailHeight() - this.YQa.getHeight()) / 2, localPaint);
      return;
      localPaint.setAlpha(160);
      break;
    }
  }
  
  protected abstract Bitmap a(h paramh, boolean paramBoolean);
  
  protected final boolean acD()
  {
    com.tencent.mm.e.b localb = getPresenter().c(getCurFeatureType());
    if (localb == null) {
      return false;
    }
    return localb.acD();
  }
  
  protected final h azv(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getFeatureCount())) {
      return getPresenter().getFeatures()[paramInt];
    }
    return h.fam;
  }
  
  protected boolean azw(int paramInt)
  {
    h localh = azv(paramInt);
    switch (3.RAi[localh.ordinal()])
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
      if (ihJ())
      {
        if ((this.YQg == null) || (!this.YQg.contains(j, k))) {
          break label124;
        }
        this.YQh = true;
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
        if (!this.YQe[i].contains(j, k)) {
          break label50;
        }
        this.YQm = i;
        postInvalidate();
        return true;
        label124:
        nt(j, k);
      }
    }
    i = 0;
    if (i < getFeatureCount())
    {
      if ((!this.YQe[i].contains(j, k)) || (this.YQm != i)) {
        break label360;
      }
      if (azw(i))
      {
        if (this.YQm != this.rGs) {
          this.rGs = this.YQm;
        }
      }
      else
      {
        label194:
        if (this.YQl) {
          break label360;
        }
        this.YQd = this.YQc;
        if (!azw(i)) {
          break label333;
        }
        this.YQc = this.rGs;
        getPresenter().getSelectedFeatureListener().a(azv(this.rGs));
      }
    }
    else
    {
      label247:
      if (ihJ())
      {
        if ((this.YQg == null) || (!this.YQg.contains(j, k)) || (!this.YQh)) {
          break label367;
        }
        getPresenter().getSelectedFeatureListener().a(azv(this.rGs), -1, null);
      }
    }
    for (;;)
    {
      this.YQh = false;
      this.YQm = -1;
      requestLayout();
      postInvalidate();
      return true;
      this.rGs = -1;
      break label194;
      label333:
      this.YQc = i;
      getPresenter().getSelectedFeatureListener().a(azv(i));
      break label247;
      label360:
      i += 1;
      break;
      label367:
      nu(j, k);
    }
  }
  
  public int getColor(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < YQk.length)) {
      return YQk[paramInt];
    }
    return -65536;
  }
  
  public h getCurFeatureType()
  {
    return azv(this.YQc);
  }
  
  protected int getDetailHeight()
  {
    if (azv(this.rGs) == h.fan) {
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
    Bitmap localBitmap = b(h.fan, false);
    if (localBitmap == null) {
      return 0.0F;
    }
    return localBitmap.getWidth();
  }
  
  public int getPaddingLeftAndRight()
  {
    return (int)(2.0F * this.YPT);
  }
  
  protected com.tencent.mm.ca.b getPresenter()
  {
    return this.fkE;
  }
  
  protected float getWidthSpacing()
  {
    return (getMeasuredWidth() - getFeatureCount() * getIconWidth() - getPaddingLeftAndRight()) / (getFeatureCount() - 1);
  }
  
  public final boolean ihH()
  {
    return this.YQl;
  }
  
  protected void ihI()
  {
    this.YQi = new Paint(1);
    this.YQi.setColor(-16711936);
    this.YQj = new Paint(1);
    this.YQj.setColor(getResources().getColor(a.b.divider_line_color));
    this.YQj.setStrokeWidth(0.6F);
    this.jZX = new Paint(1);
    this.jZX.setStyle(Paint.Style.FILL);
    this.jZX.setStrokeCap(Paint.Cap.ROUND);
    this.YQb = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.undo_press));
    this.YQa = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.undo_normal));
    this.YPU = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.doodle_unselected));
    this.YPV = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.doodle_selected));
    this.YPW = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.text_unselected));
    this.YPX = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.text_selected));
    this.YPY = BitmapFactory.decodeResource(getResources(), a.d.emoji_unselected);
    this.YPZ = BitmapFactory.decodeResource(getResources(), a.d.emoji_selected);
  }
  
  protected void ihK()
  {
    if (this.YQe == null) {
      this.YQe = new Rect[getFeatureCount()];
    }
    int j = (int)(this.YPT + getIconWidth() / 2.0F);
    int k = (int)getIconWidth();
    int i = 0;
    while (i < getFeatureCount())
    {
      this.YQe[i] = new Rect(j - k, getDetailHeight(), j + k, getDetailHeight() + getMeasuredHeight());
      j = (int)(j + (getWidthSpacing() + getIconWidth()));
      i += 1;
    }
    if (azv(this.rGs) == h.fan) {
      ihL();
    }
  }
  
  public final void ihM()
  {
    this.YQd = this.YQc;
  }
  
  public final void ihN()
  {
    this.YQc = this.YQd;
    requestLayout();
    invalidate();
  }
  
  protected void nt(int paramInt1, int paramInt2)
  {
    switch (3.RAi[azv(this.rGs).ordinal()])
    {
    }
    for (;;)
    {
      return;
      if (this.YQf != null)
      {
        int i = 0;
        while (i < this.YQf.length)
        {
          if (this.YQf[i].contains(paramInt1, paramInt2))
          {
            this.YQn = i;
            this.YQo = false;
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  protected void nu(int paramInt1, int paramInt2)
  {
    switch (3.RAi[azv(this.rGs).ordinal()])
    {
    }
    for (;;)
    {
      return;
      int i = 0;
      while ((this.YQf != null) && (i < this.YQf.length))
      {
        if ((this.YQf[i].contains(paramInt1, paramInt2)) && (i == this.YQn))
        {
          getPresenter().getSelectedFeatureListener().a(h.fan, i, null);
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
    D(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = getPaddingLeft();
    int k = getPaddingRight();
    paramInt2 = (int)getResources().getDimension(a.c.feature_select_layout_height);
    paramInt1 = paramInt2;
    if (ihJ()) {
      paramInt1 = paramInt2 + getDetailHeight();
    }
    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i - j - k, 1073741824), paramInt1);
    ihK();
  }
  
  public void setCurFeatureType(h paramh)
  {
    int i = 0;
    if (i < getFeatureCount()) {
      if (getPresenter().getFeatures()[i] == paramh) {
        label25:
        if (!azw(i)) {
          break label64;
        }
      }
    }
    label64:
    for (this.rGs = i;; this.rGs = -1)
    {
      this.YQc = i;
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
    this.YQl = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.footer.a
 * JD-Core Version:    0.7.0.1
 */