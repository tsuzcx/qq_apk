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
import com.tencent.mm.api.y.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ad;

public class a
  extends View
{
  protected float HVr;
  protected Matrix HYq;
  protected Matrix HYr;
  public Rect HYs;
  private Rect HYt;
  private Rect HYu;
  private Runnable HYv;
  protected float HYw;
  private boolean HYx;
  protected Matrix cRA;
  private Rect cRB;
  private com.tencent.mm.bu.b cRz;
  private boolean cSd;
  private Rect gat;
  private float gaz;
  private float oEd;
  private float oEe;
  float[] values;
  
  public a(Context paramContext, com.tencent.mm.bu.b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(9379);
    this.gaz = 1.0F;
    this.HYx = true;
    this.cSd = false;
    this.values = new float[9];
    this.cRz = paramb;
    this.cRA = new Matrix();
    this.HYq = new Matrix();
    this.cRB = new Rect();
    this.HYs = new Rect();
    this.HYt = new Rect();
    this.gat = new Rect();
    this.HYu = new Rect();
    paramContext = paramb.eBw();
    if (paramContext != null)
    {
      this.gat.set(0, 0, paramContext.getWidth(), paramContext.getHeight());
      this.cRB.set(this.gat);
      this.HYu.set(this.gat);
    }
    if ((!fiN()) && (paramb.getConfig().rect != null))
    {
      paramContext = paramb.getConfig().rect;
      this.cRB.set(0, 0, paramContext.width(), paramContext.height());
      this.cRA.postTranslate(0.0F, paramContext.top);
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
  
  public final void a(b paramb, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(9386);
    Object localObject = getCurImageRect();
    int i = (int)((RectF)localObject).centerX();
    int j = (int)((RectF)localObject).centerY();
    int k = getBoardRect().centerX();
    int m = getBoardRect().centerY();
    if (paramFloat % 180.0F == 0.0F)
    {
      f = ((RectF)localObject).width() * 1.0F / ((RectF)localObject).height();
      if (f >= getBoardRect().width() * 1.0F / getBoardRect().height()) {
        break label202;
      }
      getBoardRect().width();
      f = getBoardRect().height();
      label113:
      if (paramFloat % 180.0F != 0.0F) {
        break label226;
      }
    }
    label202:
    label226:
    for (float f = f * 1.0F / ((RectF)localObject).height();; f = f * 1.0F / ((RectF)localObject).width())
    {
      localObject = new a(f, k - i, m - j, i, j, paramFloat, paramBoolean);
      ((a)localObject).HYC = paramb;
      ((a)localObject).play();
      AppMethodBeat.o(9386);
      return;
      f = ((RectF)localObject).height() * 1.0F / ((RectF)localObject).width();
      break;
      getBoardRect().height();
      f = getBoardRect().width() / f;
      break label113;
    }
  }
  
  protected void am(MotionEvent paramMotionEvent) {}
  
  public final float b(Matrix paramMatrix)
  {
    AppMethodBeat.i(9392);
    float f = (float)Math.round(Math.atan2(a(paramMatrix, 1), a(paramMatrix, 0)) * 57.295779513082323D);
    AppMethodBeat.o(9392);
    return f;
  }
  
  protected final float f(Matrix paramMatrix)
  {
    AppMethodBeat.i(9390);
    float f1 = a(paramMatrix, 3);
    float f2 = a(paramMatrix, 0);
    f1 = (float)Math.sqrt(f1 * f1 + f2 * f2);
    AppMethodBeat.o(9390);
    return f1;
  }
  
  protected boolean fiM()
  {
    return this.HYx;
  }
  
  public boolean fiN()
  {
    return true;
  }
  
  public final void fiO()
  {
    AppMethodBeat.i(9385);
    Object localObject = getRawImageRect();
    float f2;
    if (b(this.cRA) % 180.0F == 0.0F)
    {
      f1 = ((Rect)localObject).width() * 1.0F / ((Rect)localObject).height();
      if (f1 >= getBoardRect().width() * 1.0F / getBoardRect().height()) {
        break label315;
      }
      f1 = getBoardRect().width() / f1;
      f2 = getBoardRect().height();
      label88:
      if (b(this.cRA) % 180.0F != 0.0F) {
        break label340;
      }
      f2 = 1.0F * f2 / ((Rect)localObject).height();
      label115:
      if (b(this.cRA) % 180.0F != 0.0F) {
        break label354;
      }
    }
    label315:
    label340:
    label354:
    for (float f1 = f1 * 1.0F / ((Rect)localObject).height();; f1 = f1 * 1.0F / ((Rect)localObject).width())
    {
      int i = ((Rect)localObject).centerX();
      int j = ((Rect)localObject).centerY();
      this.cRA.postScale(f2, f2, i, j);
      localObject = getCurImageRect();
      i = (int)((RectF)localObject).centerX();
      j = (int)((RectF)localObject).centerY();
      int k = getBoardRect().centerX();
      int m = getBoardRect().centerY();
      this.cRA.postTranslate(k - i, m - j);
      this.HYq.set(this.cRA);
      this.HVr = (f(this.HYq) * 3.0F);
      this.HYw = (f(this.HYq) * 1.0F);
      if (this.HVr < f1) {
        this.HVr = (f1 * 1.2F);
      }
      AppMethodBeat.o(9385);
      return;
      f1 = ((Rect)localObject).height() * 1.0F / ((Rect)localObject).width();
      break;
      float f3 = getBoardRect().height();
      f2 = getBoardRect().width() / f1;
      f1 = f3;
      break label88;
      f2 = 1.0F * f2 / ((Rect)localObject).width();
      break label115;
    }
  }
  
  public Rect getAliveRect()
  {
    return this.cRB;
  }
  
  public Rect getBoardRect()
  {
    AppMethodBeat.i(9384);
    if (this.HYs == null) {
      this.HYs = new Rect();
    }
    Rect localRect = this.HYs;
    AppMethodBeat.o(9384);
    return localRect;
  }
  
  public RectF getCurImageRect()
  {
    AppMethodBeat.i(9387);
    RectF localRectF = new RectF(getRawImageRect());
    this.cRA.mapRect(localRectF);
    AppMethodBeat.o(9387);
    return localRectF;
  }
  
  public float getCurScale()
  {
    AppMethodBeat.i(9391);
    float f = f(this.cRA);
    AppMethodBeat.o(9391);
    return f;
  }
  
  public Rect getImageBitmapRect()
  {
    return this.HYu;
  }
  
  public float getInitScale()
  {
    AppMethodBeat.i(9383);
    if (fiN())
    {
      float f = this.gaz;
      AppMethodBeat.o(9383);
      return f;
    }
    AppMethodBeat.o(9383);
    return 1.0F;
  }
  
  public Matrix getMainMatrix()
  {
    return this.cRA;
  }
  
  public float getMaxScale()
  {
    return this.HVr;
  }
  
  public float getMinScale()
  {
    return this.HYw;
  }
  
  public com.tencent.mm.bu.b getPresenter()
  {
    return this.cRz;
  }
  
  public Rect getRawBoardRect()
  {
    return this.HYt;
  }
  
  public Rect getRawImageRect()
  {
    return this.gat;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9381);
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    paramCanvas.setMatrix(this.cRA);
    getPresenter().onDraw(paramCanvas);
    AppMethodBeat.o(9381);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(9380);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ad.i("changelcai", "[onLayout] %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.HYs.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.HYt.set(this.HYs);
    }
    getPresenter().eBv();
    AppMethodBeat.o(9380);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9382);
    Object localObject;
    if (getPresenter().eBx())
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.oEd = paramMotionEvent.getX();
        this.oEe = paramMotionEvent.getY();
      }
      if (paramMotionEvent.getAction() != 1) {
        break label303;
      }
      removeCallbacks(this.HYv);
      long l = 0L;
      if (this.cSd) {
        l = 700L;
      }
      if (getPresenter().eBu().Mb() == com.tencent.mm.e.a.cRu) {
        break label158;
      }
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(9372);
          if (a.this.getPresenter().eBt().cJE)
          {
            a.this.getPresenter().eBt().setFooterVisible(false);
            a.this.getPresenter().eBt().setActionBarVisible(false);
            AppMethodBeat.o(9372);
            return;
          }
          a.this.getPresenter().eBt().setFooterVisible(true);
          a.this.getPresenter().eBt().setActionBarVisible(true);
          AppMethodBeat.o(9372);
        }
      };
      this.HYv = ((Runnable)localObject);
      postDelayed((Runnable)localObject, l);
      this.cSd = false;
    }
    for (;;)
    {
      if ((!getPresenter().T(paramMotionEvent)) && (fiN())) {
        if (!getPresenter().eBq())
        {
          AppMethodBeat.o(9382);
          return false;
          label158:
          getPresenter().eBt().xh(true);
          if (getPresenter().eBt().cJE)
          {
            getPresenter().eBt().setFooterVisible(false);
            getPresenter().eBt().setActionBarVisible(false);
          }
          label301:
          for (;;)
          {
            getPresenter().eBt().getBaseFooterView().fiY();
            break;
            localObject = getPresenter().eBt();
            if ((((com.tencent.mm.view.a)localObject).tlz.getVisibility() == 0) || (((com.tencent.mm.view.a)localObject).getTextEditView().getVisibility() == 0)) {}
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                break label301;
              }
              getPresenter().eBt().setFooterVisible(true);
              getPresenter().eBt().setActionBarVisible(true);
              break;
            }
          }
          label303:
          if (paramMotionEvent.getAction() == 2)
          {
            if ((Math.abs(paramMotionEvent.getX() - this.oEd) >= 3.0F) || (Math.abs(paramMotionEvent.getY() - this.oEe) >= 3.0F))
            {
              this.cSd = true;
              removeCallbacks(this.HYv);
              if (getPresenter().eBt().cJE)
              {
                getPresenter().eBt().setFooterVisible(false);
                getPresenter().eBt().setActionBarVisible(false);
              }
            }
            this.oEd = paramMotionEvent.getX();
            this.oEe = paramMotionEvent.getY();
          }
        }
        else
        {
          am(paramMotionEvent);
        }
      }
    }
    AppMethodBeat.o(9382);
    return true;
  }
  
  public final void s(Rect paramRect)
  {
    AppMethodBeat.i(9388);
    this.gat.set(paramRect);
    this.cRB.set(paramRect);
    ad.i("MicroMsg.BaseBoardView", "[resetImageRect] rect");
    AppMethodBeat.o(9388);
  }
  
  public void setForceMatrix(Matrix paramMatrix)
  {
    this.HYr = paramMatrix;
  }
  
  public void setInitScale(float paramFloat)
  {
    this.gaz = paramFloat;
  }
  
  public void setOneFingerMoveEnable(boolean paramBoolean)
  {
    this.HYx = paramBoolean;
  }
  
  final class a
    extends com.tencent.mm.c.b
  {
    private float HYA;
    boolean HYB;
    a.b HYC;
    private float HYz;
    float PP;
    float cHQ;
    float cHR;
    float cHS;
    private ValueAnimator cHw;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
    {
      this.cHQ = paramFloat1;
      this.HYz = paramFloat2;
      this.HYA = paramFloat3;
      this.cHR = paramFloat4;
      this.cHS = paramFloat5;
      this.PP = paramFloat6;
      this.HYB = paramBoolean;
    }
    
    public final void play()
    {
      AppMethodBeat.i(9377);
      this.cHw = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 0.0F, 166.0F }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, this.HYz }), PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, this.HYA }), PropertyValuesHolder.ofFloat("rotation", new float[] { 0.0F, this.PP }) });
      this.cHw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        float HYD;
        float cHM;
        float cHN;
        float cHW;
        int scaleCount;
        
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(9374);
          float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaY")).floatValue();
          float f2 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaX")).floatValue();
          float f3 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("rotation")).floatValue();
          if (this.scaleCount < 10)
          {
            a.this.cRA.postScale(this.cHW, this.cHW, a.this.getBoardRect().centerX(), a.this.getBoardRect().centerY());
            this.scaleCount += 1;
          }
          a.a.this.cHR += f2 - this.cHN;
          a.a.this.cHS += f1 - this.cHM;
          a.this.cRA.postTranslate(a.a.this.cHR - a.this.getCurImageRect().centerX(), a.a.this.cHS - a.this.getCurImageRect().centerY());
          if (a.a.this.PP != 0.0F) {
            a.this.cRA.postRotate(f3 - this.HYD, a.a.this.cHR, a.a.this.cHS);
          }
          a.this.postInvalidate();
          this.cHM = f1;
          this.cHN = f2;
          this.HYD = f3;
          AppMethodBeat.o(9374);
        }
      });
      this.cHw.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          a.a.this.cHI = true;
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(9376);
          if (a.a.this.HYC != null) {
            a.a.this.HYC.Mq();
          }
          a.a.this.cHI = true;
          a.this.HYq.set(a.this.cRA);
          a.this.HYw = (a.this.f(a.this.HYq) * 1.0F);
          if (a.a.this.HYB)
          {
            a.this.HVr = (a.this.f(a.this.HYq) * 3.0F);
            a.a.a(a.a.this);
          }
          AppMethodBeat.o(9376);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(9375);
          if (a.a.this.HYC != null) {
            a.a.this.HYC.onStart();
          }
          a.a.this.cHI = false;
          AppMethodBeat.o(9375);
        }
      });
      this.cHw.setInterpolator(new LinearInterpolator());
      this.cHw.setDuration(166L);
      this.cHw.start();
      AppMethodBeat.o(9377);
    }
  }
  
  public static abstract interface b
  {
    public abstract void Mq();
    
    public abstract void onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.b.a
 * JD-Core Version:    0.7.0.1
 */