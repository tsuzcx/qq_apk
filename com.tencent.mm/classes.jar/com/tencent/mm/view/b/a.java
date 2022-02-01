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
  protected float YLO;
  protected Matrix YOP;
  protected Matrix YOQ;
  protected Rect YOR;
  protected Rect YOS;
  protected Rect YOT;
  private Rect YOU;
  private Runnable YOV;
  protected float YOW;
  private boolean YOX;
  protected boolean YOY;
  protected boolean YOZ;
  private com.tencent.mm.ca.b fkE;
  protected Matrix fkF;
  protected Rect fkG;
  float[] fkN;
  private boolean flJ;
  protected Rect jZW;
  private float kac;
  private float uLT;
  private float uLU;
  
  public a(Context paramContext, com.tencent.mm.ca.b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(9379);
    this.kac = 1.0F;
    this.YOX = true;
    this.YOY = true;
    this.YOZ = false;
    this.flJ = false;
    this.fkN = new float[9];
    this.fkE = paramb;
    this.fkF = new Matrix();
    this.YOP = new Matrix();
    this.fkG = new Rect();
    this.YOR = new Rect();
    this.YOS = new Rect();
    this.jZW = new Rect();
    this.YOT = new Rect();
    paramContext = paramb.hoy();
    if (paramContext != null)
    {
      this.jZW.set(0, 0, paramContext.getWidth(), paramContext.getHeight());
      this.fkG.set(this.jZW);
      this.YOT.set(this.jZW);
    }
    if ((!ihB()) && (paramb.getConfig().byG != null))
    {
      paramContext = paramb.getConfig().byG;
      this.fkG.set(0, 0, paramContext.width(), paramContext.height());
      this.fkF.postTranslate(0.0F, paramContext.top);
    }
    AppMethodBeat.o(9379);
  }
  
  private float a(Matrix paramMatrix, int paramInt)
  {
    AppMethodBeat.i(9389);
    paramMatrix.getValues(this.fkN);
    float f = this.fkN[paramInt];
    AppMethodBeat.o(9389);
    return f;
  }
  
  public final void E(Rect paramRect)
  {
    this.YOR = paramRect;
  }
  
  public final void F(Rect paramRect)
  {
    AppMethodBeat.i(9388);
    this.jZW.set(paramRect);
    this.fkG.set(paramRect);
    Log.i("MicroMsg.BaseBoardView", "[resetImageRect] rect %s", new Object[] { paramRect.flattenToString() });
    AppMethodBeat.o(9388);
  }
  
  public final void If(boolean paramBoolean)
  {
    this.YOZ = paramBoolean;
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
      ((a)localObject).YPe = paramb;
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
  
  protected void aI(MotionEvent paramMotionEvent) {}
  
  protected final void aJ(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(260226);
    if (paramMotionEvent.getAction() == 0)
    {
      this.uLT = paramMotionEvent.getX();
      this.uLU = paramMotionEvent.getY();
    }
    if (paramMotionEvent.getAction() == 1)
    {
      removeCallbacks(this.YOV);
      long l = 0L;
      if (this.flJ) {
        l = 700L;
      }
      if (getPresenter().hov().acy() != com.tencent.mm.e.a.fkz)
      {
        paramMotionEvent = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(9372);
            if (a.this.getPresenter().hou().faA)
            {
              a.this.getPresenter().hou().setFooterVisible(false);
              a.this.getPresenter().hou().setActionBarVisible(false);
              AppMethodBeat.o(9372);
              return;
            }
            a.this.getPresenter().hou().setFooterVisible(true);
            a.this.getPresenter().hou().setActionBarVisible(true);
            AppMethodBeat.o(9372);
          }
        };
        this.YOV = paramMotionEvent;
        postDelayed(paramMotionEvent, l);
        this.flJ = false;
        AppMethodBeat.o(260226);
        return;
      }
      getPresenter().hou().Ic(true);
      if (getPresenter().hou().faA)
      {
        getPresenter().hou().setFooterVisible(false);
        getPresenter().hou().setActionBarVisible(false);
      }
      for (;;)
      {
        getPresenter().hou().getBaseFooterView().ihN();
        break;
        if (!getPresenter().hou().igT())
        {
          getPresenter().hou().setFooterVisible(true);
          getPresenter().hou().setActionBarVisible(true);
        }
      }
    }
    if (paramMotionEvent.getAction() == 2)
    {
      if ((Math.abs(paramMotionEvent.getX() - this.uLT) >= 3.0F) || (Math.abs(paramMotionEvent.getY() - this.uLU) >= 3.0F))
      {
        this.flJ = true;
        removeCallbacks(this.YOV);
        if (getPresenter().hou().faA)
        {
          getPresenter().hou().setFooterVisible(false);
          getPresenter().hou().setActionBarVisible(false);
        }
      }
      this.uLT = paramMotionEvent.getX();
      this.uLU = paramMotionEvent.getY();
    }
    AppMethodBeat.o(260226);
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
    return this.fkG;
  }
  
  public Rect getBoardRect()
  {
    AppMethodBeat.i(9384);
    if (this.YOR == null) {
      this.YOR = new Rect();
    }
    Rect localRect = this.YOR;
    AppMethodBeat.o(9384);
    return localRect;
  }
  
  public RectF getCurImageRect()
  {
    AppMethodBeat.i(9387);
    RectF localRectF = new RectF(getRawImageRect());
    this.fkF.mapRect(localRectF);
    AppMethodBeat.o(9387);
    return localRectF;
  }
  
  public float getCurScale()
  {
    AppMethodBeat.i(9391);
    float f = e(this.fkF);
    AppMethodBeat.o(9391);
    return f;
  }
  
  public Rect getImageBitmapRect()
  {
    return this.YOT;
  }
  
  public float getInitScale()
  {
    AppMethodBeat.i(9383);
    if (ihB())
    {
      float f = this.kac;
      AppMethodBeat.o(9383);
      return f;
    }
    AppMethodBeat.o(9383);
    return 1.0F;
  }
  
  public Matrix getMainMatrix()
  {
    return this.fkF;
  }
  
  public float getMaxScale()
  {
    return this.YLO;
  }
  
  public float getMinScale()
  {
    return this.YOW;
  }
  
  public com.tencent.mm.ca.b getPresenter()
  {
    return this.fkE;
  }
  
  public Rect getRawBoardRect()
  {
    return this.YOS;
  }
  
  public Rect getRawImageRect()
  {
    return this.jZW;
  }
  
  public Rect getRawLayoutRect()
  {
    AppMethodBeat.i(260235);
    if (this.YOU == null) {
      this.YOU = getPresenter().getConfig().faC;
    }
    Rect localRect = this.YOU;
    AppMethodBeat.o(260235);
    return localRect;
  }
  
  protected boolean ihA()
  {
    return this.YOX;
  }
  
  public boolean ihB()
  {
    return true;
  }
  
  public final void ihC()
  {
    AppMethodBeat.i(9385);
    Log.i("MicroMsg.BaseBoardView", "adaptImage execute guess only by first time");
    Object localObject = getRawImageRect();
    float f2;
    if (b(this.fkF) % 180.0F == 0.0F)
    {
      f1 = ((Rect)localObject).width() * 1.0F / ((Rect)localObject).height();
      if (f1 >= getBoardRect().width() * 1.0F / getBoardRect().height()) {
        break label325;
      }
      f1 = getBoardRect().width() / f1;
      f2 = getBoardRect().height();
      label96:
      if (b(this.fkF) % 180.0F != 0.0F) {
        break label350;
      }
      f2 = 1.0F * f2 / ((Rect)localObject).height();
      label123:
      if (b(this.fkF) % 180.0F != 0.0F) {
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
      this.fkF.postScale(f2, f2, i, j);
      localObject = getCurImageRect();
      i = (int)((RectF)localObject).centerX();
      j = (int)((RectF)localObject).centerY();
      int k = getBoardRect().centerX();
      int m = getBoardRect().centerY();
      this.fkF.postTranslate(k - i, m - j);
      this.YOP.set(this.fkF);
      this.YLO = (e(this.YOP) * 3.0F);
      this.YOW = (e(this.YOP) * 1.0F);
      if (this.YLO < f1) {
        this.YLO = (f1 * 1.2F);
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
  
  public final void ihD()
  {
    AppMethodBeat.i(260230);
    this.fkF.reset();
    ihC();
    AppMethodBeat.o(260230);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9381);
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    paramCanvas.setMatrix(this.fkF);
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
      this.YOR.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.YOS.set(this.YOR);
    }
    getPresenter().azS();
    AppMethodBeat.o(9380);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9382);
    if (getPresenter().hoz()) {
      aJ(paramMotionEvent);
    }
    if ((!getPresenter().X(paramMotionEvent)) && (ihB()))
    {
      if (!getPresenter().hor())
      {
        AppMethodBeat.o(9382);
        return false;
      }
      aI(paramMotionEvent);
    }
    AppMethodBeat.o(9382);
    return true;
  }
  
  public void setForceMatrix(Matrix paramMatrix)
  {
    this.YOQ = paramMatrix;
  }
  
  public void setInitScale(float paramFloat)
  {
    this.kac = paramFloat;
  }
  
  public void setOneFingerMoveEnable(boolean paramBoolean)
  {
    this.YOX = paramBoolean;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    this.YOY = paramBoolean;
  }
  
  final class a
    extends com.tencent.mm.c.b
  {
    private float YPb;
    private float YPc;
    boolean YPd;
    a.b YPe;
    float aoj;
    float eYO;
    float eYP;
    float eYQ;
    private ValueAnimator eYu;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
    {
      this.eYO = paramFloat1;
      this.YPb = paramFloat2;
      this.YPc = paramFloat3;
      this.eYP = paramFloat4;
      this.eYQ = paramFloat5;
      this.aoj = paramFloat6;
      this.YPd = paramBoolean;
    }
    
    public final void play()
    {
      AppMethodBeat.i(9377);
      this.eYu = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 0.0F, 166.0F }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, this.YPb }), PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, this.YPc }), PropertyValuesHolder.ofFloat("rotation", new float[] { 0.0F, this.aoj }) });
      this.eYu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        float YPf;
        float eYK;
        float eYL;
        float eYT;
        int scaleCount;
        
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(9374);
          float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaY")).floatValue();
          float f2 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaX")).floatValue();
          float f3 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("rotation")).floatValue();
          if (this.scaleCount < 10)
          {
            a.this.fkF.postScale(this.eYT, this.eYT, a.this.getBoardRect().centerX(), a.this.getBoardRect().centerY());
            this.scaleCount += 1;
          }
          a.a.this.eYP += f2 - this.eYL;
          a.a.this.eYQ += f1 - this.eYK;
          a.this.fkF.postTranslate(a.a.this.eYP - a.this.getCurImageRect().centerX(), a.a.this.eYQ - a.this.getCurImageRect().centerY());
          if (a.a.this.aoj != 0.0F) {
            a.this.fkF.postRotate(f3 - this.YPf, a.a.this.eYP, a.a.this.eYQ);
          }
          a.this.postInvalidate();
          this.eYK = f1;
          this.eYL = f2;
          this.YPf = f3;
          AppMethodBeat.o(9374);
        }
      });
      this.eYu.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          a.a.this.eYG = true;
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(9376);
          if (a.a.this.YPe != null) {
            a.a.this.YPe.acN();
          }
          Log.i("MicroMsg.AdaptImageAnim", "AdaptImageAnim onAnimationEnd");
          a.a.this.eYG = true;
          a.this.YOP.set(a.this.fkF);
          a.this.YOW = (a.this.e(a.this.YOP) * 1.0F);
          if (a.a.this.YPd)
          {
            a.this.YLO = (a.this.e(a.this.YOP) * 3.0F);
            a.a.a(a.a.this);
          }
          AppMethodBeat.o(9376);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(9375);
          Log.i("MicroMsg.AdaptImageAnim", "AdaptImageAnim onAnimationStart");
          if (a.a.this.YPe != null) {
            a.a.this.YPe.onStart();
          }
          a.a.this.eYG = false;
          AppMethodBeat.o(9375);
        }
      });
      this.eYu.setInterpolator(new LinearInterpolator());
      this.eYu.setDuration(166L);
      this.eYu.start();
      AppMethodBeat.o(9377);
    }
  }
  
  public static abstract interface b
  {
    public abstract void acN();
    
    public abstract void onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.b.a
 * JD-Core Version:    0.7.0.1
 */