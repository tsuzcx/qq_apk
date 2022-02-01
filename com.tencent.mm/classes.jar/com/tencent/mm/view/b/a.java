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
import com.tencent.mm.sdk.platformtools.ae;

public class a
  extends View
{
  protected float LLU;
  protected Matrix LOY;
  protected Matrix LOZ;
  public Rect LPa;
  private Rect LPb;
  private Rect LPc;
  private Runnable LPd;
  protected float LPe;
  private boolean LPf;
  private com.tencent.mm.bt.b dbm;
  protected Matrix dbn;
  private Rect dbo;
  private boolean dcq;
  private Rect gBq;
  private float gBw;
  private float pRK;
  private float pRL;
  float[] values;
  
  public a(Context paramContext, com.tencent.mm.bt.b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(9379);
    this.gBw = 1.0F;
    this.LPf = true;
    this.dcq = false;
    this.values = new float[9];
    this.dbm = paramb;
    this.dbn = new Matrix();
    this.LOY = new Matrix();
    this.dbo = new Rect();
    this.LPa = new Rect();
    this.LPb = new Rect();
    this.gBq = new Rect();
    this.LPc = new Rect();
    paramContext = paramb.fjK();
    if (paramContext != null)
    {
      this.gBq.set(0, 0, paramContext.getWidth(), paramContext.getHeight());
      this.dbo.set(this.gBq);
      this.LPc.set(this.gBq);
    }
    if ((!fUG()) && (paramb.getConfig().rect != null))
    {
      paramContext = paramb.getConfig().rect;
      this.dbo.set(0, 0, paramContext.width(), paramContext.height());
      this.dbn.postTranslate(0.0F, paramContext.top);
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
      ((a)localObject).LPk = paramb;
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
  
  protected final float e(Matrix paramMatrix)
  {
    AppMethodBeat.i(9390);
    float f1 = a(paramMatrix, 3);
    float f2 = a(paramMatrix, 0);
    f1 = (float)Math.sqrt(f1 * f1 + f2 * f2);
    AppMethodBeat.o(9390);
    return f1;
  }
  
  protected boolean fUF()
  {
    return this.LPf;
  }
  
  public boolean fUG()
  {
    return true;
  }
  
  public final void fUH()
  {
    AppMethodBeat.i(9385);
    Object localObject = getRawImageRect();
    float f2;
    if (b(this.dbn) % 180.0F == 0.0F)
    {
      f1 = ((Rect)localObject).width() * 1.0F / ((Rect)localObject).height();
      if (f1 >= getBoardRect().width() * 1.0F / getBoardRect().height()) {
        break label315;
      }
      f1 = getBoardRect().width() / f1;
      f2 = getBoardRect().height();
      label88:
      if (b(this.dbn) % 180.0F != 0.0F) {
        break label340;
      }
      f2 = 1.0F * f2 / ((Rect)localObject).height();
      label115:
      if (b(this.dbn) % 180.0F != 0.0F) {
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
      this.dbn.postScale(f2, f2, i, j);
      localObject = getCurImageRect();
      i = (int)((RectF)localObject).centerX();
      j = (int)((RectF)localObject).centerY();
      int k = getBoardRect().centerX();
      int m = getBoardRect().centerY();
      this.dbn.postTranslate(k - i, m - j);
      this.LOY.set(this.dbn);
      this.LLU = (e(this.LOY) * 3.0F);
      this.LPe = (e(this.LOY) * 1.0F);
      if (this.LLU < f1) {
        this.LLU = (f1 * 1.2F);
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
    return this.dbo;
  }
  
  public Rect getBoardRect()
  {
    AppMethodBeat.i(9384);
    if (this.LPa == null) {
      this.LPa = new Rect();
    }
    Rect localRect = this.LPa;
    AppMethodBeat.o(9384);
    return localRect;
  }
  
  public RectF getCurImageRect()
  {
    AppMethodBeat.i(9387);
    RectF localRectF = new RectF(getRawImageRect());
    this.dbn.mapRect(localRectF);
    AppMethodBeat.o(9387);
    return localRectF;
  }
  
  public float getCurScale()
  {
    AppMethodBeat.i(9391);
    float f = e(this.dbn);
    AppMethodBeat.o(9391);
    return f;
  }
  
  public Rect getImageBitmapRect()
  {
    return this.LPc;
  }
  
  public float getInitScale()
  {
    AppMethodBeat.i(9383);
    if (fUG())
    {
      float f = this.gBw;
      AppMethodBeat.o(9383);
      return f;
    }
    AppMethodBeat.o(9383);
    return 1.0F;
  }
  
  public Matrix getMainMatrix()
  {
    return this.dbn;
  }
  
  public float getMaxScale()
  {
    return this.LLU;
  }
  
  public float getMinScale()
  {
    return this.LPe;
  }
  
  public com.tencent.mm.bt.b getPresenter()
  {
    return this.dbm;
  }
  
  public Rect getRawBoardRect()
  {
    return this.LPb;
  }
  
  public Rect getRawImageRect()
  {
    return this.gBq;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9381);
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    paramCanvas.setMatrix(this.dbn);
    getPresenter().onDraw(paramCanvas);
    AppMethodBeat.o(9381);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(9380);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ae.i("changelcai", "[onLayout] %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.LPa.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.LPb.set(this.LPa);
    }
    getPresenter().fjJ();
    AppMethodBeat.o(9380);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9382);
    Object localObject;
    if (getPresenter().fjL())
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.pRK = paramMotionEvent.getX();
        this.pRL = paramMotionEvent.getY();
      }
      if (paramMotionEvent.getAction() != 1) {
        break label303;
      }
      removeCallbacks(this.LPd);
      long l = 0L;
      if (this.dcq) {
        l = 700L;
      }
      if (getPresenter().fjI().NG() == com.tencent.mm.e.a.dbh) {
        break label158;
      }
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(9372);
          if (a.this.getPresenter().fjH().cSz)
          {
            a.this.getPresenter().fjH().setFooterVisible(false);
            a.this.getPresenter().fjH().setActionBarVisible(false);
            AppMethodBeat.o(9372);
            return;
          }
          a.this.getPresenter().fjH().setFooterVisible(true);
          a.this.getPresenter().fjH().setActionBarVisible(true);
          AppMethodBeat.o(9372);
        }
      };
      this.LPd = ((Runnable)localObject);
      postDelayed((Runnable)localObject, l);
      this.dcq = false;
    }
    for (;;)
    {
      if ((!getPresenter().N(paramMotionEvent)) && (fUG())) {
        if (!getPresenter().fjE())
        {
          AppMethodBeat.o(9382);
          return false;
          label158:
          getPresenter().fjH().zr(true);
          if (getPresenter().fjH().cSz)
          {
            getPresenter().fjH().setFooterVisible(false);
            getPresenter().fjH().setActionBarVisible(false);
          }
          label301:
          for (;;)
          {
            getPresenter().fjH().getBaseFooterView().fUQ();
            break;
            localObject = getPresenter().fjH();
            if ((((com.tencent.mm.view.a)localObject).vIz.getVisibility() == 0) || (((com.tencent.mm.view.a)localObject).getTextEditView().getVisibility() == 0)) {}
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                break label301;
              }
              getPresenter().fjH().setFooterVisible(true);
              getPresenter().fjH().setActionBarVisible(true);
              break;
            }
          }
          label303:
          if (paramMotionEvent.getAction() == 2)
          {
            if ((Math.abs(paramMotionEvent.getX() - this.pRK) >= 3.0F) || (Math.abs(paramMotionEvent.getY() - this.pRL) >= 3.0F))
            {
              this.dcq = true;
              removeCallbacks(this.LPd);
              if (getPresenter().fjH().cSz)
              {
                getPresenter().fjH().setFooterVisible(false);
                getPresenter().fjH().setActionBarVisible(false);
              }
            }
            this.pRK = paramMotionEvent.getX();
            this.pRL = paramMotionEvent.getY();
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
  
  public final void q(Rect paramRect)
  {
    AppMethodBeat.i(9388);
    this.gBq.set(paramRect);
    this.dbo.set(paramRect);
    ae.i("MicroMsg.BaseBoardView", "[resetImageRect] rect");
    AppMethodBeat.o(9388);
  }
  
  public void setForceMatrix(Matrix paramMatrix)
  {
    this.LOZ = paramMatrix;
  }
  
  public void setInitScale(float paramFloat)
  {
    this.gBw = paramFloat;
  }
  
  public void setOneFingerMoveEnable(boolean paramBoolean)
  {
    this.LPf = paramBoolean;
  }
  
  final class a
    extends com.tencent.mm.c.b
  {
    private float LPh;
    private float LPi;
    boolean LPj;
    a.b LPk;
    float Sz;
    float cQN;
    float cQO;
    float cQP;
    private ValueAnimator cQt;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
    {
      this.cQN = paramFloat1;
      this.LPh = paramFloat2;
      this.LPi = paramFloat3;
      this.cQO = paramFloat4;
      this.cQP = paramFloat5;
      this.Sz = paramFloat6;
      this.LPj = paramBoolean;
    }
    
    public final void play()
    {
      AppMethodBeat.i(9377);
      this.cQt = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 0.0F, 166.0F }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, this.LPh }), PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, this.LPi }), PropertyValuesHolder.ofFloat("rotation", new float[] { 0.0F, this.Sz }) });
      this.cQt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        float LPl;
        float cQJ;
        float cQK;
        float cQS;
        int scaleCount;
        
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(9374);
          float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaY")).floatValue();
          float f2 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaX")).floatValue();
          float f3 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("rotation")).floatValue();
          if (this.scaleCount < 10)
          {
            a.this.dbn.postScale(this.cQS, this.cQS, a.this.getBoardRect().centerX(), a.this.getBoardRect().centerY());
            this.scaleCount += 1;
          }
          a.a.this.cQO += f2 - this.cQK;
          a.a.this.cQP += f1 - this.cQJ;
          a.this.dbn.postTranslate(a.a.this.cQO - a.this.getCurImageRect().centerX(), a.a.this.cQP - a.this.getCurImageRect().centerY());
          if (a.a.this.Sz != 0.0F) {
            a.this.dbn.postRotate(f3 - this.LPl, a.a.this.cQO, a.a.this.cQP);
          }
          a.this.postInvalidate();
          this.cQJ = f1;
          this.cQK = f2;
          this.LPl = f3;
          AppMethodBeat.o(9374);
        }
      });
      this.cQt.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          a.a.this.cQF = true;
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(9376);
          if (a.a.this.LPk != null) {
            a.a.this.LPk.NV();
          }
          a.a.this.cQF = true;
          a.this.LOY.set(a.this.dbn);
          a.this.LPe = (a.this.e(a.this.LOY) * 1.0F);
          if (a.a.this.LPj)
          {
            a.this.LLU = (a.this.e(a.this.LOY) * 3.0F);
            a.a.a(a.a.this);
          }
          AppMethodBeat.o(9376);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(9375);
          if (a.a.this.LPk != null) {
            a.a.this.LPk.onStart();
          }
          a.a.this.cQF = false;
          AppMethodBeat.o(9375);
        }
      });
      this.cQt.setInterpolator(new LinearInterpolator());
      this.cQt.setDuration(166L);
      this.cQt.start();
      AppMethodBeat.o(9377);
    }
  }
  
  public static abstract interface b
  {
    public abstract void NV();
    
    public abstract void onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.b.a
 * JD-Core Version:    0.7.0.1
 */