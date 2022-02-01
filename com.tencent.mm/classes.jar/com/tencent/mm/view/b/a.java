package com.tencent.mm.view.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab.a;
import com.tencent.mm.sdk.platformtools.Log;

public class a
  extends View
{
  protected float Rkj;
  private Runnable RnA;
  protected float RnB;
  private boolean RnC;
  protected boolean RnD;
  protected boolean RnE;
  protected Matrix Rnu;
  protected Matrix Rnv;
  protected Rect Rnw;
  protected Rect Rnx;
  protected Rect Rny;
  private Rect Rnz;
  private com.tencent.mm.bt.b drS;
  protected Matrix drT;
  protected Rect drU;
  private boolean dsY;
  protected Rect hof;
  private float hol;
  private float riK;
  private float riL;
  float[] values;
  
  public a(Context paramContext, com.tencent.mm.bt.b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(9379);
    this.hol = 1.0F;
    this.RnC = true;
    this.RnD = true;
    this.RnE = false;
    this.dsY = false;
    this.values = new float[9];
    this.drS = paramb;
    this.drT = new Matrix();
    this.Rnu = new Matrix();
    this.drU = new Rect();
    this.Rnw = new Rect();
    this.Rnx = new Rect();
    this.hof = new Rect();
    this.Rny = new Rect();
    paramContext = paramb.gtm();
    if (paramContext != null)
    {
      this.hof.set(0, 0, paramContext.getWidth(), paramContext.getHeight());
      this.drU.set(this.hof);
      this.Rny.set(this.hof);
    }
    if ((!hgb()) && (paramb.getConfig().rect != null))
    {
      paramContext = paramb.getConfig().rect;
      this.drU.set(0, 0, paramContext.width(), paramContext.height());
      this.drT.postTranslate(0.0F, paramContext.top);
    }
    AppMethodBeat.o(9379);
  }
  
  private float a(Matrix paramMatrix, int paramInt)
  {
    AppMethodBeat.i(9389);
    paramMatrix.getValues(this.values);
    float f = this.values[paramInt];
    AppMethodBeat.o(9389);
    return f;
  }
  
  public final void DF(boolean paramBoolean)
  {
    this.RnE = paramBoolean;
  }
  
  public final void a(b paramb, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(9386);
    Log.i("MicroMsg.BaseBoardView", "adaptImageWithAnim");
    Object localObject = getCurImageRect();
    int i = (int)((RectF)localObject).centerX();
    int j = (int)((RectF)localObject).centerY();
    int k = getBoardRect().centerX();
    int m = getBoardRect().centerY();
    if (paramFloat % 180.0F == 0.0F)
    {
      f = ((RectF)localObject).width() * 1.0F / ((RectF)localObject).height();
      if (f >= getBoardRect().width() * 1.0F / getBoardRect().height()) {
        break label209;
      }
      getBoardRect().width();
      f = getBoardRect().height();
      label120:
      if (paramFloat % 180.0F != 0.0F) {
        break label233;
      }
    }
    label209:
    label233:
    for (float f = f * 1.0F / ((RectF)localObject).height();; f = f * 1.0F / ((RectF)localObject).width())
    {
      localObject = new a(f, k - i, m - j, i, j, paramFloat, paramBoolean);
      ((a)localObject).RnJ = paramb;
      ((a)localObject).play();
      AppMethodBeat.o(9386);
      return;
      f = ((RectF)localObject).height() * 1.0F / ((RectF)localObject).width();
      break;
      getBoardRect().height();
      f = getBoardRect().width() / f;
      break label120;
    }
  }
  
  protected void aA(MotionEvent paramMotionEvent) {}
  
  protected final void aB(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204759);
    if (paramMotionEvent.getAction() == 0)
    {
      this.riK = paramMotionEvent.getX();
      this.riL = paramMotionEvent.getY();
    }
    if (paramMotionEvent.getAction() == 1)
    {
      removeCallbacks(this.RnA);
      long l = 0L;
      if (this.dsY) {
        l = 700L;
      }
      if (getPresenter().gti().XS() != com.tencent.mm.e.a.drN)
      {
        paramMotionEvent = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(9372);
            if (a.this.getPresenter().gth().diT)
            {
              a.this.getPresenter().gth().setFooterVisible(false);
              a.this.getPresenter().gth().setActionBarVisible(false);
              AppMethodBeat.o(9372);
              return;
            }
            a.this.getPresenter().gth().setFooterVisible(true);
            a.this.getPresenter().gth().setActionBarVisible(true);
            AppMethodBeat.o(9372);
          }
        };
        this.RnA = paramMotionEvent;
        postDelayed(paramMotionEvent, l);
        this.dsY = false;
        AppMethodBeat.o(204759);
        return;
      }
      getPresenter().gth().DC(true);
      if (getPresenter().gth().diT)
      {
        getPresenter().gth().setFooterVisible(false);
        getPresenter().gth().setActionBarVisible(false);
      }
      for (;;)
      {
        getPresenter().gth().getBaseFooterView().hgm();
        break;
        if (!getPresenter().gth().hfx())
        {
          getPresenter().gth().setFooterVisible(true);
          getPresenter().gth().setActionBarVisible(true);
        }
      }
    }
    if (paramMotionEvent.getAction() == 2)
    {
      if ((Math.abs(paramMotionEvent.getX() - this.riK) >= 3.0F) || (Math.abs(paramMotionEvent.getY() - this.riL) >= 3.0F))
      {
        this.dsY = true;
        removeCallbacks(this.RnA);
        if (getPresenter().gth().diT)
        {
          getPresenter().gth().setFooterVisible(false);
          getPresenter().gth().setActionBarVisible(false);
        }
      }
      this.riK = paramMotionEvent.getX();
      this.riL = paramMotionEvent.getY();
    }
    AppMethodBeat.o(204759);
  }
  
  public final float b(Matrix paramMatrix)
  {
    AppMethodBeat.i(9392);
    float f = (float)Math.round(Math.atan2(a(paramMatrix, 1), a(paramMatrix, 0)) * 57.295779513082323D);
    AppMethodBeat.o(9392);
    return f;
  }
  
  protected final float e(Matrix paramMatrix)
  {
    AppMethodBeat.i(9390);
    float f1 = a(paramMatrix, 3);
    float f2 = a(paramMatrix, 0);
    f1 = (float)Math.sqrt(f1 * f1 + f2 * f2);
    AppMethodBeat.o(9390);
    return f1;
  }
  
  public Rect getAliveRect()
  {
    return this.drU;
  }
  
  public Rect getBoardRect()
  {
    AppMethodBeat.i(9384);
    if (this.Rnw == null) {
      this.Rnw = new Rect();
    }
    Rect localRect = this.Rnw;
    AppMethodBeat.o(9384);
    return localRect;
  }
  
  public RectF getCurImageRect()
  {
    AppMethodBeat.i(9387);
    RectF localRectF = new RectF(getRawImageRect());
    this.drT.mapRect(localRectF);
    AppMethodBeat.o(9387);
    return localRectF;
  }
  
  public float getCurScale()
  {
    AppMethodBeat.i(9391);
    float f = e(this.drT);
    AppMethodBeat.o(9391);
    return f;
  }
  
  public Rect getImageBitmapRect()
  {
    return this.Rny;
  }
  
  public float getInitScale()
  {
    AppMethodBeat.i(9383);
    if (hgb())
    {
      float f = this.hol;
      AppMethodBeat.o(9383);
      return f;
    }
    AppMethodBeat.o(9383);
    return 1.0F;
  }
  
  public Matrix getMainMatrix()
  {
    return this.drT;
  }
  
  public float getMaxScale()
  {
    return this.Rkj;
  }
  
  public float getMinScale()
  {
    return this.RnB;
  }
  
  public com.tencent.mm.bt.b getPresenter()
  {
    return this.drS;
  }
  
  public Rect getRawBoardRect()
  {
    return this.Rnx;
  }
  
  public Rect getRawImageRect()
  {
    return this.hof;
  }
  
  public Rect getRawLayoutRect()
  {
    AppMethodBeat.i(204761);
    if (this.Rnz == null) {
      this.Rnz = getPresenter().getConfig().diV;
    }
    Rect localRect = this.Rnz;
    AppMethodBeat.o(204761);
    return localRect;
  }
  
  protected boolean hga()
  {
    return this.RnC;
  }
  
  public boolean hgb()
  {
    return true;
  }
  
  public final void hgc()
  {
    AppMethodBeat.i(9385);
    Log.i("MicroMsg.BaseBoardView", "adaptImage execute guess only by first time");
    Object localObject = getRawImageRect();
    float f2;
    if (b(this.drT) % 180.0F == 0.0F)
    {
      f1 = ((Rect)localObject).width() * 1.0F / ((Rect)localObject).height();
      if (f1 >= getBoardRect().width() * 1.0F / getBoardRect().height()) {
        break label325;
      }
      f1 = getBoardRect().width() / f1;
      f2 = getBoardRect().height();
      label96:
      if (b(this.drT) % 180.0F != 0.0F) {
        break label350;
      }
      f2 = 1.0F * f2 / ((Rect)localObject).height();
      label123:
      if (b(this.drT) % 180.0F != 0.0F) {
        break label364;
      }
    }
    label325:
    label350:
    label364:
    for (float f1 = f1 * 1.0F / ((Rect)localObject).height();; f1 = f1 * 1.0F / ((Rect)localObject).width())
    {
      int i = ((Rect)localObject).centerX();
      int j = ((Rect)localObject).centerY();
      this.drT.postScale(f2, f2, i, j);
      localObject = getCurImageRect();
      i = (int)((RectF)localObject).centerX();
      j = (int)((RectF)localObject).centerY();
      int k = getBoardRect().centerX();
      int m = getBoardRect().centerY();
      this.drT.postTranslate(k - i, m - j);
      this.Rnu.set(this.drT);
      this.Rkj = (e(this.Rnu) * 3.0F);
      this.RnB = (e(this.Rnu) * 1.0F);
      if (this.Rkj < f1) {
        this.Rkj = (f1 * 1.2F);
      }
      AppMethodBeat.o(9385);
      return;
      f1 = ((Rect)localObject).height() * 1.0F / ((Rect)localObject).width();
      break;
      float f3 = getBoardRect().height();
      f2 = getBoardRect().width() / f1;
      f1 = f3;
      break label96;
      f2 = 1.0F * f2 / ((Rect)localObject).width();
      break label123;
    }
  }
  
  public final void hgd()
  {
    AppMethodBeat.i(204760);
    this.drT.reset();
    hgc();
    AppMethodBeat.o(204760);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9381);
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    paramCanvas.setMatrix(this.drT);
    getPresenter().onDraw(paramCanvas);
    AppMethodBeat.o(9381);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(9380);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Log.i("changelcai", "[onLayout] %s=%s=%s=%s=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (paramBoolean)
    {
      this.Rnw.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.Rnx.set(this.Rnw);
    }
    getPresenter().ate();
    AppMethodBeat.o(9380);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9382);
    if (getPresenter().gtn()) {
      aB(paramMotionEvent);
    }
    if ((!getPresenter().R(paramMotionEvent)) && (hgb()))
    {
      if (!getPresenter().gte())
      {
        AppMethodBeat.o(9382);
        return false;
      }
      aA(paramMotionEvent);
    }
    AppMethodBeat.o(9382);
    return true;
  }
  
  public void setForceMatrix(Matrix paramMatrix)
  {
    this.Rnv = paramMatrix;
  }
  
  public void setInitScale(float paramFloat)
  {
    this.hol = paramFloat;
  }
  
  public void setOneFingerMoveEnable(boolean paramBoolean)
  {
    this.RnC = paramBoolean;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    this.RnD = paramBoolean;
  }
  
  public final void u(Rect paramRect)
  {
    this.Rnw = paramRect;
  }
  
  public final void v(Rect paramRect)
  {
    AppMethodBeat.i(9388);
    this.hof.set(paramRect);
    this.drU.set(paramRect);
    Log.i("MicroMsg.BaseBoardView", "[resetImageRect] rect %s", new Object[] { paramRect.flattenToString() });
    AppMethodBeat.o(9388);
  }
  
  final class a
    extends com.tencent.mm.c.b
  {
    private float RnG;
    private float RnH;
    boolean RnI;
    a.b RnJ;
    float SM;
    private ValueAnimator dgN;
    float dhh;
    float dhi;
    float dhj;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
    {
      this.dhh = paramFloat1;
      this.RnG = paramFloat2;
      this.RnH = paramFloat3;
      this.dhi = paramFloat4;
      this.dhj = paramFloat5;
      this.SM = paramFloat6;
      this.RnI = paramBoolean;
    }
    
    public final void play()
    {
      AppMethodBeat.i(9377);
      this.dgN = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 0.0F, 166.0F }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, this.RnG }), PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, this.RnH }), PropertyValuesHolder.ofFloat("rotation", new float[] { 0.0F, this.SM }) });
      this.dgN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        float RnK;
        float dhd;
        float dhe;
        float dhm;
        int scaleCount;
        
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(9374);
          float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaY")).floatValue();
          float f2 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaX")).floatValue();
          float f3 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("rotation")).floatValue();
          if (this.scaleCount < 10)
          {
            a.this.drT.postScale(this.dhm, this.dhm, a.this.getBoardRect().centerX(), a.this.getBoardRect().centerY());
            this.scaleCount += 1;
          }
          a.a.this.dhi += f2 - this.dhe;
          a.a.this.dhj += f1 - this.dhd;
          a.this.drT.postTranslate(a.a.this.dhi - a.this.getCurImageRect().centerX(), a.a.this.dhj - a.this.getCurImageRect().centerY());
          if (a.a.this.SM != 0.0F) {
            a.this.drT.postRotate(f3 - this.RnK, a.a.this.dhi, a.a.this.dhj);
          }
          a.this.postInvalidate();
          this.dhd = f1;
          this.dhe = f2;
          this.RnK = f3;
          AppMethodBeat.o(9374);
        }
      });
      this.dgN.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          a.a.this.dgZ = true;
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(9376);
          if (a.a.this.RnJ != null) {
            a.a.this.RnJ.Yh();
          }
          Log.i("MicroMsg.AdaptImageAnim", "AdaptImageAnim onAnimationEnd");
          a.a.this.dgZ = true;
          a.this.Rnu.set(a.this.drT);
          a.this.RnB = (a.this.e(a.this.Rnu) * 1.0F);
          if (a.a.this.RnI)
          {
            a.this.Rkj = (a.this.e(a.this.Rnu) * 3.0F);
            a.a.a(a.a.this);
          }
          AppMethodBeat.o(9376);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(9375);
          Log.i("MicroMsg.AdaptImageAnim", "AdaptImageAnim onAnimationStart");
          if (a.a.this.RnJ != null) {
            a.a.this.RnJ.onStart();
          }
          a.a.this.dgZ = false;
          AppMethodBeat.o(9375);
        }
      });
      this.dgN.setInterpolator(new LinearInterpolator());
      this.dgN.setDuration(166L);
      this.dgN.start();
      AppMethodBeat.o(9377);
    }
  }
  
  public static abstract interface b
  {
    public abstract void Yh();
    
    public abstract void onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.b.a
 * JD-Core Version:    0.7.0.1
 */