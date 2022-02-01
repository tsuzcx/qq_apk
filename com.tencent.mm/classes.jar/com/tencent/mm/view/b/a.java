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
import com.tencent.mm.sdk.platformtools.ac;

public class a
  extends View
{
  protected float Jwc;
  protected Matrix Jze;
  protected Matrix Jzf;
  public Rect Jzg;
  private Rect Jzh;
  private Rect Jzi;
  private Runnable Jzj;
  protected float Jzk;
  private boolean Jzl;
  private com.tencent.mm.bt.b cOU;
  protected Matrix cOV;
  private Rect cOW;
  private boolean cPY;
  private Rect geZ;
  private float gff;
  private float phD;
  private float phE;
  float[] values;
  
  public a(Context paramContext, com.tencent.mm.bt.b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(9379);
    this.gff = 1.0F;
    this.Jzl = true;
    this.cPY = false;
    this.values = new float[9];
    this.cOU = paramb;
    this.cOV = new Matrix();
    this.Jze = new Matrix();
    this.cOW = new Rect();
    this.Jzg = new Rect();
    this.Jzh = new Rect();
    this.geZ = new Rect();
    this.Jzi = new Rect();
    paramContext = paramb.eQQ();
    if (paramContext != null)
    {
      this.geZ.set(0, 0, paramContext.getWidth(), paramContext.getHeight());
      this.cOW.set(this.geZ);
      this.Jzi.set(this.geZ);
    }
    if ((!fzb()) && (paramb.getConfig().rect != null))
    {
      paramContext = paramb.getConfig().rect;
      this.cOW.set(0, 0, paramContext.width(), paramContext.height());
      this.cOV.postTranslate(0.0F, paramContext.top);
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
      ((a)localObject).Jzq = paramb;
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
  
  protected boolean fza()
  {
    return this.Jzl;
  }
  
  public boolean fzb()
  {
    return true;
  }
  
  public final void fzc()
  {
    AppMethodBeat.i(9385);
    Object localObject = getRawImageRect();
    float f2;
    if (b(this.cOV) % 180.0F == 0.0F)
    {
      f1 = ((Rect)localObject).width() * 1.0F / ((Rect)localObject).height();
      if (f1 >= getBoardRect().width() * 1.0F / getBoardRect().height()) {
        break label315;
      }
      f1 = getBoardRect().width() / f1;
      f2 = getBoardRect().height();
      label88:
      if (b(this.cOV) % 180.0F != 0.0F) {
        break label340;
      }
      f2 = 1.0F * f2 / ((Rect)localObject).height();
      label115:
      if (b(this.cOV) % 180.0F != 0.0F) {
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
      this.cOV.postScale(f2, f2, i, j);
      localObject = getCurImageRect();
      i = (int)((RectF)localObject).centerX();
      j = (int)((RectF)localObject).centerY();
      int k = getBoardRect().centerX();
      int m = getBoardRect().centerY();
      this.cOV.postTranslate(k - i, m - j);
      this.Jze.set(this.cOV);
      this.Jwc = (e(this.Jze) * 3.0F);
      this.Jzk = (e(this.Jze) * 1.0F);
      if (this.Jwc < f1) {
        this.Jwc = (f1 * 1.2F);
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
    return this.cOW;
  }
  
  public Rect getBoardRect()
  {
    AppMethodBeat.i(9384);
    if (this.Jzg == null) {
      this.Jzg = new Rect();
    }
    Rect localRect = this.Jzg;
    AppMethodBeat.o(9384);
    return localRect;
  }
  
  public RectF getCurImageRect()
  {
    AppMethodBeat.i(9387);
    RectF localRectF = new RectF(getRawImageRect());
    this.cOV.mapRect(localRectF);
    AppMethodBeat.o(9387);
    return localRectF;
  }
  
  public float getCurScale()
  {
    AppMethodBeat.i(9391);
    float f = e(this.cOV);
    AppMethodBeat.o(9391);
    return f;
  }
  
  public Rect getImageBitmapRect()
  {
    return this.Jzi;
  }
  
  public float getInitScale()
  {
    AppMethodBeat.i(9383);
    if (fzb())
    {
      float f = this.gff;
      AppMethodBeat.o(9383);
      return f;
    }
    AppMethodBeat.o(9383);
    return 1.0F;
  }
  
  public Matrix getMainMatrix()
  {
    return this.cOV;
  }
  
  public float getMaxScale()
  {
    return this.Jwc;
  }
  
  public float getMinScale()
  {
    return this.Jzk;
  }
  
  public com.tencent.mm.bt.b getPresenter()
  {
    return this.cOU;
  }
  
  public Rect getRawBoardRect()
  {
    return this.Jzh;
  }
  
  public Rect getRawImageRect()
  {
    return this.geZ;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9381);
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    paramCanvas.setMatrix(this.cOV);
    getPresenter().onDraw(paramCanvas);
    AppMethodBeat.o(9381);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(9380);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ac.i("changelcai", "[onLayout] %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.Jzg.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.Jzh.set(this.Jzg);
    }
    getPresenter().eQP();
    AppMethodBeat.o(9380);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9382);
    Object localObject;
    if (getPresenter().eQR())
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.phD = paramMotionEvent.getX();
        this.phE = paramMotionEvent.getY();
      }
      if (paramMotionEvent.getAction() != 1) {
        break label303;
      }
      removeCallbacks(this.Jzj);
      long l = 0L;
      if (this.cPY) {
        l = 700L;
      }
      if (getPresenter().eQO().LZ() == com.tencent.mm.e.a.cOP) {
        break label158;
      }
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(9372);
          if (a.this.getPresenter().eQN().cGL)
          {
            a.this.getPresenter().eQN().setFooterVisible(false);
            a.this.getPresenter().eQN().setActionBarVisible(false);
            AppMethodBeat.o(9372);
            return;
          }
          a.this.getPresenter().eQN().setFooterVisible(true);
          a.this.getPresenter().eQN().setActionBarVisible(true);
          AppMethodBeat.o(9372);
        }
      };
      this.Jzj = ((Runnable)localObject);
      postDelayed((Runnable)localObject, l);
      this.cPY = false;
    }
    for (;;)
    {
      if ((!getPresenter().R(paramMotionEvent)) && (fzb())) {
        if (!getPresenter().eQK())
        {
          AppMethodBeat.o(9382);
          return false;
          label158:
          getPresenter().eQN().yq(true);
          if (getPresenter().eQN().cGL)
          {
            getPresenter().eQN().setFooterVisible(false);
            getPresenter().eQN().setActionBarVisible(false);
          }
          label301:
          for (;;)
          {
            getPresenter().eQN().getBaseFooterView().fzl();
            break;
            localObject = getPresenter().eQN();
            if ((((com.tencent.mm.view.a)localObject).utS.getVisibility() == 0) || (((com.tencent.mm.view.a)localObject).getTextEditView().getVisibility() == 0)) {}
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                break label301;
              }
              getPresenter().eQN().setFooterVisible(true);
              getPresenter().eQN().setActionBarVisible(true);
              break;
            }
          }
          label303:
          if (paramMotionEvent.getAction() == 2)
          {
            if ((Math.abs(paramMotionEvent.getX() - this.phD) >= 3.0F) || (Math.abs(paramMotionEvent.getY() - this.phE) >= 3.0F))
            {
              this.cPY = true;
              removeCallbacks(this.Jzj);
              if (getPresenter().eQN().cGL)
              {
                getPresenter().eQN().setFooterVisible(false);
                getPresenter().eQN().setActionBarVisible(false);
              }
            }
            this.phD = paramMotionEvent.getX();
            this.phE = paramMotionEvent.getY();
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
  
  public final void r(Rect paramRect)
  {
    AppMethodBeat.i(9388);
    this.geZ.set(paramRect);
    this.cOW.set(paramRect);
    ac.i("MicroMsg.BaseBoardView", "[resetImageRect] rect");
    AppMethodBeat.o(9388);
  }
  
  public void setForceMatrix(Matrix paramMatrix)
  {
    this.Jzf = paramMatrix;
  }
  
  public void setInitScale(float paramFloat)
  {
    this.gff = paramFloat;
  }
  
  public void setOneFingerMoveEnable(boolean paramBoolean)
  {
    this.Jzl = paramBoolean;
  }
  
  final class a
    extends com.tencent.mm.c.b
  {
    private float Jzn;
    private float Jzo;
    boolean Jzp;
    a.b Jzq;
    float QK;
    private ValueAnimator cEE;
    float cEY;
    float cEZ;
    float cFa;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
    {
      this.cEY = paramFloat1;
      this.Jzn = paramFloat2;
      this.Jzo = paramFloat3;
      this.cEZ = paramFloat4;
      this.cFa = paramFloat5;
      this.QK = paramFloat6;
      this.Jzp = paramBoolean;
    }
    
    public final void play()
    {
      AppMethodBeat.i(9377);
      this.cEE = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 0.0F, 166.0F }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, this.Jzn }), PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, this.Jzo }), PropertyValuesHolder.ofFloat("rotation", new float[] { 0.0F, this.QK }) });
      this.cEE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        float Jzr;
        float cEU;
        float cEV;
        float cFd;
        int scaleCount;
        
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(9374);
          float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaY")).floatValue();
          float f2 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaX")).floatValue();
          float f3 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("rotation")).floatValue();
          if (this.scaleCount < 10)
          {
            a.this.cOV.postScale(this.cFd, this.cFd, a.this.getBoardRect().centerX(), a.this.getBoardRect().centerY());
            this.scaleCount += 1;
          }
          a.a.this.cEZ += f2 - this.cEV;
          a.a.this.cFa += f1 - this.cEU;
          a.this.cOV.postTranslate(a.a.this.cEZ - a.this.getCurImageRect().centerX(), a.a.this.cFa - a.this.getCurImageRect().centerY());
          if (a.a.this.QK != 0.0F) {
            a.this.cOV.postRotate(f3 - this.Jzr, a.a.this.cEZ, a.a.this.cFa);
          }
          a.this.postInvalidate();
          this.cEU = f1;
          this.cEV = f2;
          this.Jzr = f3;
          AppMethodBeat.o(9374);
        }
      });
      this.cEE.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          a.a.this.cEQ = true;
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(9376);
          if (a.a.this.Jzq != null) {
            a.a.this.Jzq.Mo();
          }
          a.a.this.cEQ = true;
          a.this.Jze.set(a.this.cOV);
          a.this.Jzk = (a.this.e(a.this.Jze) * 1.0F);
          if (a.a.this.Jzp)
          {
            a.this.Jwc = (a.this.e(a.this.Jze) * 3.0F);
            a.a.a(a.a.this);
          }
          AppMethodBeat.o(9376);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(9375);
          if (a.a.this.Jzq != null) {
            a.a.this.Jzq.onStart();
          }
          a.a.this.cEQ = false;
          AppMethodBeat.o(9375);
        }
      });
      this.cEE.setInterpolator(new LinearInterpolator());
      this.cEE.setDuration(166L);
      this.cEE.start();
      AppMethodBeat.o(9377);
    }
  }
  
  public static abstract interface b
  {
    public abstract void Mo();
    
    public abstract void onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.b.a
 * JD-Core Version:    0.7.0.1
 */