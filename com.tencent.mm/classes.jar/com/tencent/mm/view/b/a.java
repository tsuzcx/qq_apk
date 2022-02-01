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
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ac.a;
import com.tencent.mm.sdk.platformtools.Log;

public class a
  extends View
{
  protected Rect Qv;
  protected float agHA;
  protected Matrix agKB;
  protected Matrix agKC;
  protected Rect agKD;
  protected Rect agKE;
  protected Rect agKF;
  private Rect agKG;
  private Rect agKH;
  private Runnable agKI;
  protected float agKJ;
  private boolean agKK;
  protected boolean agKL;
  protected boolean agKM;
  private com.tencent.mm.bt.b hoR;
  protected Matrix hoS;
  protected Rect hoT;
  private boolean hpW;
  float[] hpa;
  private float mAf;
  private ImageView.ScaleType scaleType;
  private float xUu;
  private float xUv;
  
  public a(Context paramContext, com.tencent.mm.bt.b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(9379);
    this.scaleType = ImageView.ScaleType.CENTER_INSIDE;
    this.mAf = 1.0F;
    this.agKK = true;
    this.agKL = true;
    this.agKM = false;
    this.hpW = false;
    this.hpa = new float[9];
    this.hoR = paramb;
    this.hoS = new Matrix();
    this.agKB = new Matrix();
    this.hoT = new Rect();
    this.agKD = new Rect();
    this.agKE = new Rect();
    this.Qv = new Rect();
    this.agKF = new Rect();
    paramContext = paramb.iPu();
    if (paramContext != null)
    {
      this.Qv.set(0, 0, paramContext.getWidth(), paramContext.getHeight());
      this.hoT.set(this.Qv);
      this.agKF.set(this.Qv);
    }
    if ((!jMO()) && (paramb.getConfig().rect != null))
    {
      paramContext = paramb.getConfig().rect;
      this.hoT.set(0, 0, paramContext.width(), paramContext.height());
      this.hoS.postTranslate(0.0F, paramContext.top);
    }
    AppMethodBeat.o(9379);
  }
  
  private float a(Matrix paramMatrix, int paramInt)
  {
    AppMethodBeat.i(9389);
    paramMatrix.getValues(this.hpa);
    float f = this.hpa[paramInt];
    AppMethodBeat.o(9389);
    return f;
  }
  
  public final void M(Rect paramRect)
  {
    this.agKD = paramRect;
  }
  
  public final void N(Rect paramRect)
  {
    AppMethodBeat.i(9388);
    this.Qv.set(paramRect);
    this.hoT.set(paramRect);
    Log.i("MicroMsg.BaseBoardView", "[resetImageRect] rect %s", new Object[] { paramRect.flattenToString() });
    AppMethodBeat.o(9388);
  }
  
  public final void Oa(boolean paramBoolean)
  {
    this.agKM = paramBoolean;
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
      ((a)localObject).agKR = paramb;
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
  
  protected void aL(MotionEvent paramMotionEvent) {}
  
  protected final void aM(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(234910);
    if (paramMotionEvent.getAction() == 0)
    {
      this.xUu = paramMotionEvent.getX();
      this.xUv = paramMotionEvent.getY();
    }
    if (paramMotionEvent.getAction() == 1)
    {
      removeCallbacks(this.agKI);
      long l = 0L;
      if (this.hpW) {
        l = 700L;
      }
      if (getPresenter().iPp().aEy() != com.tencent.mm.e.a.hoM)
      {
        paramMotionEvent = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(9372);
            if (a.this.getPresenter().iPo().heb)
            {
              a.this.getPresenter().iPo().setFooterVisible(false);
              a.this.getPresenter().iPo().setActionBarVisible(false);
              AppMethodBeat.o(9372);
              return;
            }
            a.this.getPresenter().iPo().setFooterVisible(true);
            a.this.getPresenter().iPo().setActionBarVisible(true);
            AppMethodBeat.o(9372);
          }
        };
        this.agKI = paramMotionEvent;
        postDelayed(paramMotionEvent, l);
        this.hpW = false;
        AppMethodBeat.o(234910);
        return;
      }
      getPresenter().iPo().NY(true);
      if (getPresenter().iPo().heb)
      {
        getPresenter().iPo().setFooterVisible(false);
        getPresenter().iPo().setActionBarVisible(false);
      }
      for (;;)
      {
        getPresenter().iPo().getBaseFooterView().jNa();
        break;
        if (!getPresenter().iPo().jMi())
        {
          getPresenter().iPo().setFooterVisible(true);
          getPresenter().iPo().setActionBarVisible(true);
        }
      }
    }
    if (paramMotionEvent.getAction() == 2)
    {
      if ((Math.abs(paramMotionEvent.getX() - this.xUu) >= 3.0F) || (Math.abs(paramMotionEvent.getY() - this.xUv) >= 3.0F))
      {
        this.hpW = true;
        removeCallbacks(this.agKI);
        if (getPresenter().iPo().heb)
        {
          getPresenter().iPo().setFooterVisible(false);
          getPresenter().iPo().setActionBarVisible(false);
        }
      }
      this.xUu = paramMotionEvent.getX();
      this.xUv = paramMotionEvent.getY();
    }
    AppMethodBeat.o(234910);
  }
  
  public final float d(Matrix paramMatrix)
  {
    AppMethodBeat.i(9392);
    float f = (float)Math.round(Math.atan2(a(paramMatrix, 1), a(paramMatrix, 0)) * 57.295779513082323D);
    AppMethodBeat.o(9392);
    return f;
  }
  
  protected final float g(Matrix paramMatrix)
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
    return this.hoT;
  }
  
  public Rect getBoardRect()
  {
    AppMethodBeat.i(9384);
    if (this.agKD == null) {
      this.agKD = new Rect();
    }
    Rect localRect = this.agKD;
    AppMethodBeat.o(9384);
    return localRect;
  }
  
  public RectF getCurImageRect()
  {
    AppMethodBeat.i(9387);
    RectF localRectF = new RectF(getRawImageRect());
    this.hoS.mapRect(localRectF);
    AppMethodBeat.o(9387);
    return localRectF;
  }
  
  public float getCurScale()
  {
    AppMethodBeat.i(9391);
    float f = g(this.hoS);
    AppMethodBeat.o(9391);
    return f;
  }
  
  public RectF getCurValidImageRect()
  {
    AppMethodBeat.i(234935);
    RectF localRectF = new RectF(getValidImageRect());
    this.hoS.mapRect(localRectF);
    AppMethodBeat.o(234935);
    return localRectF;
  }
  
  public Rect getImageBitmapRect()
  {
    return this.agKF;
  }
  
  public float getInitScale()
  {
    AppMethodBeat.i(9383);
    if (jMO())
    {
      float f = this.mAf;
      AppMethodBeat.o(9383);
      return f;
    }
    AppMethodBeat.o(9383);
    return 1.0F;
  }
  
  public Matrix getMainMatrix()
  {
    return this.hoS;
  }
  
  public float getMaxScale()
  {
    return this.agHA;
  }
  
  public float getMinScale()
  {
    return this.agKJ;
  }
  
  public com.tencent.mm.bt.b getPresenter()
  {
    return this.hoR;
  }
  
  public Rect getRawBoardRect()
  {
    return this.agKE;
  }
  
  public Rect getRawImageRect()
  {
    return this.Qv;
  }
  
  public Rect getRawLayoutRect()
  {
    AppMethodBeat.i(234943);
    if (this.agKH == null) {
      this.agKH = getPresenter().getConfig().hed;
    }
    Rect localRect = this.agKH;
    AppMethodBeat.o(234943);
    return localRect;
  }
  
  public Rect getValidImageRect()
  {
    if (this.agKG != null) {
      return this.agKG;
    }
    return this.Qv;
  }
  
  protected boolean jMN()
  {
    return this.agKK;
  }
  
  public boolean jMO()
  {
    return true;
  }
  
  public final void jMP()
  {
    AppMethodBeat.i(9385);
    Log.i("MicroMsg.BaseBoardView", "adaptImage execute guess only by first time");
    Object localObject = getRawImageRect();
    float f1;
    float f2;
    if (d(this.hoS) % 180.0F == 0.0F)
    {
      f1 = ((Rect)localObject).width() * 1.0F / ((Rect)localObject).height();
      float f3 = getBoardRect().width() * 1.0F / getBoardRect().height();
      if (f1 >= f3) {
        break label343;
      }
      f2 = getBoardRect().width() / f1;
      label89:
      if (this.scaleType != ImageView.ScaleType.CENTER_INSIDE) {
        break label383;
      }
      if (f1 >= f3) {
        break label355;
      }
      f1 = getBoardRect().height();
      label114:
      if (d(this.hoS) % 180.0F != 0.0F) {
        break label369;
      }
      f1 = f1 * 1.0F / ((Rect)localObject).height();
    }
    for (;;)
    {
      label141:
      if (d(this.hoS) % 180.0F == 0.0F) {}
      for (f2 = f2 * 1.0F / ((Rect)localObject).height();; f2 = f2 * 1.0F / ((Rect)localObject).width())
      {
        int i = ((Rect)localObject).centerX();
        int j = ((Rect)localObject).centerY();
        this.hoS.postScale(f1, f1, i, j);
        localObject = getCurImageRect();
        i = (int)((RectF)localObject).centerX();
        j = (int)((RectF)localObject).centerY();
        int k = getBoardRect().centerX();
        int m = getBoardRect().centerY();
        this.hoS.postTranslate(k - i, m - j);
        this.agKB.set(this.hoS);
        this.agHA = (g(this.agKB) * 3.0F);
        this.agKJ = (g(this.agKB) * 1.0F);
        if (this.agHA < f2) {
          this.agHA = (1.2F * f2);
        }
        AppMethodBeat.o(9385);
        return;
        f1 = ((Rect)localObject).height() * 1.0F / ((Rect)localObject).width();
        break;
        label343:
        f2 = getBoardRect().height();
        break label89;
        label355:
        f1 = getBoardRect().width() / f1;
        break label114;
        label369:
        f1 = f1 * 1.0F / ((Rect)localObject).width();
        break label141;
        label383:
        if (this.scaleType != ImageView.ScaleType.CENTER_CROP) {
          break label448;
        }
        f1 = Math.max(getBoardRect().width() * 1.0F / ((Rect)localObject).width(), getBoardRect().height() * 1.0F / ((Rect)localObject).height());
        break label141;
      }
      label448:
      f1 = 1.0F;
    }
  }
  
  public final void jMQ()
  {
    AppMethodBeat.i(234921);
    this.hoS.reset();
    jMP();
    AppMethodBeat.o(234921);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9381);
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    paramCanvas.setMatrix(this.hoS);
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
      this.agKD.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.agKE.set(this.agKD);
    }
    getPresenter().iPt();
    AppMethodBeat.o(9380);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9382);
    if (getPresenter().iPv()) {
      aM(paramMotionEvent);
    }
    if ((!getPresenter().Z(paramMotionEvent)) && (jMO()))
    {
      if (!getPresenter().iPl())
      {
        AppMethodBeat.o(9382);
        return false;
      }
      aL(paramMotionEvent);
    }
    AppMethodBeat.o(9382);
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(234832);
    if (this.hoR != null)
    {
      Bitmap localBitmap = this.hoR.iPu();
      if (localBitmap != null)
      {
        this.Qv.set(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
        this.hoT.set(this.Qv);
        this.agKF.set(this.Qv);
      }
      if (this.hoR.iPs()) {
        jMQ();
      }
    }
    AppMethodBeat.o(234832);
  }
  
  public void setForceMatrix(Matrix paramMatrix)
  {
    this.agKC = paramMatrix;
  }
  
  public void setInitScale(float paramFloat)
  {
    this.mAf = paramFloat;
  }
  
  public void setOneFingerMoveEnable(boolean paramBoolean)
  {
    this.agKK = paramBoolean;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    this.scaleType = paramScaleType;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    this.agKL = paramBoolean;
  }
  
  public void setValidImageRect(Rect paramRect)
  {
    this.agKG = paramRect;
  }
  
  final class a
    extends com.tencent.mm.c.b
  {
    private float agKO;
    private float agKP;
    boolean agKQ;
    a.b agKR;
    float ccT;
    private ValueAnimator hbU;
    float hco;
    float hcp;
    float hcq;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
    {
      this.hco = paramFloat1;
      this.agKO = paramFloat2;
      this.agKP = paramFloat3;
      this.hcp = paramFloat4;
      this.hcq = paramFloat5;
      this.ccT = paramFloat6;
      this.agKQ = paramBoolean;
    }
    
    public final void play()
    {
      AppMethodBeat.i(9377);
      this.hbU = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 0.0F, 166.0F }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, this.agKO }), PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, this.agKP }), PropertyValuesHolder.ofFloat("rotation", new float[] { 0.0F, this.ccT }) });
      this.hbU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        float agKS;
        float hck;
        float hcl;
        float hct;
        int scaleCount;
        
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(9374);
          float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaY")).floatValue();
          float f2 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaX")).floatValue();
          float f3 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("rotation")).floatValue();
          if (this.scaleCount < 10)
          {
            a.this.hoS.postScale(this.hct, this.hct, a.this.getBoardRect().centerX(), a.this.getBoardRect().centerY());
            this.scaleCount += 1;
          }
          paramAnonymousValueAnimator = a.a.this;
          paramAnonymousValueAnimator.hcp = (f2 - this.hcl + paramAnonymousValueAnimator.hcp);
          paramAnonymousValueAnimator = a.a.this;
          paramAnonymousValueAnimator.hcq = (f1 - this.hck + paramAnonymousValueAnimator.hcq);
          a.this.hoS.postTranslate(a.a.this.hcp - a.this.getCurImageRect().centerX(), a.a.this.hcq - a.this.getCurImageRect().centerY());
          if (a.a.this.ccT != 0.0F) {
            a.this.hoS.postRotate(f3 - this.agKS, a.a.this.hcp, a.a.this.hcq);
          }
          a.this.postInvalidate();
          this.hck = f1;
          this.hcl = f2;
          this.agKS = f3;
          AppMethodBeat.o(9374);
        }
      });
      this.hbU.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          a.a.this.hcg = true;
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(9376);
          if (a.a.this.agKR != null) {
            a.a.this.agKR.aEN();
          }
          Log.i("MicroMsg.AdaptImageAnim", "AdaptImageAnim onAnimationEnd");
          a.a.this.hcg = true;
          a.this.agKB.set(a.this.hoS);
          a.this.agKJ = (a.this.g(a.this.agKB) * 1.0F);
          if (a.a.this.agKQ)
          {
            a.this.agHA = (a.this.g(a.this.agKB) * 3.0F);
            a.a.a(a.a.this);
          }
          AppMethodBeat.o(9376);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(9375);
          Log.i("MicroMsg.AdaptImageAnim", "AdaptImageAnim onAnimationStart");
          if (a.a.this.agKR != null) {
            a.a.this.agKR.onStart();
          }
          a.a.this.hcg = false;
          AppMethodBeat.o(9375);
        }
      });
      this.hbU.setInterpolator(new LinearInterpolator());
      this.hbU.setDuration(166L);
      this.hbU.start();
      AppMethodBeat.o(9377);
    }
  }
  
  public static abstract interface b
  {
    public abstract void aEN();
    
    public abstract void onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.b.a
 * JD-Core Version:    0.7.0.1
 */