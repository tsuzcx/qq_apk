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
  protected float Lpj;
  protected Matrix Lsl;
  protected Matrix Lsm;
  public Rect Lsn;
  private Rect Lso;
  private Rect Lsp;
  private Runnable Lsq;
  protected float Lsr;
  private boolean Lss;
  private com.tencent.mm.bu.b dak;
  protected Matrix dal;
  private Rect dam;
  private boolean dbo;
  private Rect gyJ;
  private float gyP;
  private float pLf;
  private float pLg;
  float[] values;
  
  public a(Context paramContext, com.tencent.mm.bu.b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(9379);
    this.gyP = 1.0F;
    this.Lss = true;
    this.dbo = false;
    this.values = new float[9];
    this.dak = paramb;
    this.dal = new Matrix();
    this.Lsl = new Matrix();
    this.dam = new Rect();
    this.Lsn = new Rect();
    this.Lso = new Rect();
    this.gyJ = new Rect();
    this.Lsp = new Rect();
    paramContext = paramb.ffU();
    if (paramContext != null)
    {
      this.gyJ.set(0, 0, paramContext.getWidth(), paramContext.getHeight());
      this.dam.set(this.gyJ);
      this.Lsp.set(this.gyJ);
    }
    if ((!fQk()) && (paramb.getConfig().rect != null))
    {
      paramContext = paramb.getConfig().rect;
      this.dam.set(0, 0, paramContext.width(), paramContext.height());
      this.dal.postTranslate(0.0F, paramContext.top);
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
      ((a)localObject).Lsx = paramb;
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
  
  protected void ao(MotionEvent paramMotionEvent) {}
  
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
  
  protected boolean fQj()
  {
    return this.Lss;
  }
  
  public boolean fQk()
  {
    return true;
  }
  
  public final void fQl()
  {
    AppMethodBeat.i(9385);
    Object localObject = getRawImageRect();
    float f2;
    if (b(this.dal) % 180.0F == 0.0F)
    {
      f1 = ((Rect)localObject).width() * 1.0F / ((Rect)localObject).height();
      if (f1 >= getBoardRect().width() * 1.0F / getBoardRect().height()) {
        break label315;
      }
      f1 = getBoardRect().width() / f1;
      f2 = getBoardRect().height();
      label88:
      if (b(this.dal) % 180.0F != 0.0F) {
        break label340;
      }
      f2 = 1.0F * f2 / ((Rect)localObject).height();
      label115:
      if (b(this.dal) % 180.0F != 0.0F) {
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
      this.dal.postScale(f2, f2, i, j);
      localObject = getCurImageRect();
      i = (int)((RectF)localObject).centerX();
      j = (int)((RectF)localObject).centerY();
      int k = getBoardRect().centerX();
      int m = getBoardRect().centerY();
      this.dal.postTranslate(k - i, m - j);
      this.Lsl.set(this.dal);
      this.Lpj = (e(this.Lsl) * 3.0F);
      this.Lsr = (e(this.Lsl) * 1.0F);
      if (this.Lpj < f1) {
        this.Lpj = (f1 * 1.2F);
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
    return this.dam;
  }
  
  public Rect getBoardRect()
  {
    AppMethodBeat.i(9384);
    if (this.Lsn == null) {
      this.Lsn = new Rect();
    }
    Rect localRect = this.Lsn;
    AppMethodBeat.o(9384);
    return localRect;
  }
  
  public RectF getCurImageRect()
  {
    AppMethodBeat.i(9387);
    RectF localRectF = new RectF(getRawImageRect());
    this.dal.mapRect(localRectF);
    AppMethodBeat.o(9387);
    return localRectF;
  }
  
  public float getCurScale()
  {
    AppMethodBeat.i(9391);
    float f = e(this.dal);
    AppMethodBeat.o(9391);
    return f;
  }
  
  public Rect getImageBitmapRect()
  {
    return this.Lsp;
  }
  
  public float getInitScale()
  {
    AppMethodBeat.i(9383);
    if (fQk())
    {
      float f = this.gyP;
      AppMethodBeat.o(9383);
      return f;
    }
    AppMethodBeat.o(9383);
    return 1.0F;
  }
  
  public Matrix getMainMatrix()
  {
    return this.dal;
  }
  
  public float getMaxScale()
  {
    return this.Lpj;
  }
  
  public float getMinScale()
  {
    return this.Lsr;
  }
  
  public com.tencent.mm.bu.b getPresenter()
  {
    return this.dak;
  }
  
  public Rect getRawBoardRect()
  {
    return this.Lso;
  }
  
  public Rect getRawImageRect()
  {
    return this.gyJ;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9381);
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    paramCanvas.setMatrix(this.dal);
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
      this.Lsn.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.Lso.set(this.Lsn);
    }
    getPresenter().ffT();
    AppMethodBeat.o(9380);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9382);
    Object localObject;
    if (getPresenter().ffV())
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.pLf = paramMotionEvent.getX();
        this.pLg = paramMotionEvent.getY();
      }
      if (paramMotionEvent.getAction() != 1) {
        break label303;
      }
      removeCallbacks(this.Lsq);
      long l = 0L;
      if (this.dbo) {
        l = 700L;
      }
      if (getPresenter().ffS().NI() == com.tencent.mm.e.a.daf) {
        break label158;
      }
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(9372);
          if (a.this.getPresenter().ffR().cRP)
          {
            a.this.getPresenter().ffR().setFooterVisible(false);
            a.this.getPresenter().ffR().setActionBarVisible(false);
            AppMethodBeat.o(9372);
            return;
          }
          a.this.getPresenter().ffR().setFooterVisible(true);
          a.this.getPresenter().ffR().setActionBarVisible(true);
          AppMethodBeat.o(9372);
        }
      };
      this.Lsq = ((Runnable)localObject);
      postDelayed((Runnable)localObject, l);
      this.dbo = false;
    }
    for (;;)
    {
      if ((!getPresenter().P(paramMotionEvent)) && (fQk())) {
        if (!getPresenter().ffO())
        {
          AppMethodBeat.o(9382);
          return false;
          label158:
          getPresenter().ffR().zd(true);
          if (getPresenter().ffR().cRP)
          {
            getPresenter().ffR().setFooterVisible(false);
            getPresenter().ffR().setActionBarVisible(false);
          }
          label301:
          for (;;)
          {
            getPresenter().ffR().getBaseFooterView().fQu();
            break;
            localObject = getPresenter().ffR();
            if ((((com.tencent.mm.view.a)localObject).vwv.getVisibility() == 0) || (((com.tencent.mm.view.a)localObject).getTextEditView().getVisibility() == 0)) {}
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                break label301;
              }
              getPresenter().ffR().setFooterVisible(true);
              getPresenter().ffR().setActionBarVisible(true);
              break;
            }
          }
          label303:
          if (paramMotionEvent.getAction() == 2)
          {
            if ((Math.abs(paramMotionEvent.getX() - this.pLf) >= 3.0F) || (Math.abs(paramMotionEvent.getY() - this.pLg) >= 3.0F))
            {
              this.dbo = true;
              removeCallbacks(this.Lsq);
              if (getPresenter().ffR().cRP)
              {
                getPresenter().ffR().setFooterVisible(false);
                getPresenter().ffR().setActionBarVisible(false);
              }
            }
            this.pLf = paramMotionEvent.getX();
            this.pLg = paramMotionEvent.getY();
          }
        }
        else
        {
          ao(paramMotionEvent);
        }
      }
    }
    AppMethodBeat.o(9382);
    return true;
  }
  
  public final void q(Rect paramRect)
  {
    AppMethodBeat.i(9388);
    this.gyJ.set(paramRect);
    this.dam.set(paramRect);
    ad.i("MicroMsg.BaseBoardView", "[resetImageRect] rect");
    AppMethodBeat.o(9388);
  }
  
  public void setForceMatrix(Matrix paramMatrix)
  {
    this.Lsm = paramMatrix;
  }
  
  public void setInitScale(float paramFloat)
  {
    this.gyP = paramFloat;
  }
  
  public void setOneFingerMoveEnable(boolean paramBoolean)
  {
    this.Lss = paramBoolean;
  }
  
  final class a
    extends com.tencent.mm.c.b
  {
    private float Lsu;
    private float Lsv;
    boolean Lsw;
    a.b Lsx;
    float Sz;
    private ValueAnimator cPJ;
    float cQd;
    float cQe;
    float cQf;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
    {
      this.cQd = paramFloat1;
      this.Lsu = paramFloat2;
      this.Lsv = paramFloat3;
      this.cQe = paramFloat4;
      this.cQf = paramFloat5;
      this.Sz = paramFloat6;
      this.Lsw = paramBoolean;
    }
    
    public final void play()
    {
      AppMethodBeat.i(9377);
      this.cPJ = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 0.0F, 166.0F }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, this.Lsu }), PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, this.Lsv }), PropertyValuesHolder.ofFloat("rotation", new float[] { 0.0F, this.Sz }) });
      this.cPJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        float Lsy;
        float cPZ;
        float cQa;
        float cQi;
        int scaleCount;
        
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(9374);
          float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaY")).floatValue();
          float f2 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaX")).floatValue();
          float f3 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("rotation")).floatValue();
          if (this.scaleCount < 10)
          {
            a.this.dal.postScale(this.cQi, this.cQi, a.this.getBoardRect().centerX(), a.this.getBoardRect().centerY());
            this.scaleCount += 1;
          }
          a.a.this.cQe += f2 - this.cQa;
          a.a.this.cQf += f1 - this.cPZ;
          a.this.dal.postTranslate(a.a.this.cQe - a.this.getCurImageRect().centerX(), a.a.this.cQf - a.this.getCurImageRect().centerY());
          if (a.a.this.Sz != 0.0F) {
            a.this.dal.postRotate(f3 - this.Lsy, a.a.this.cQe, a.a.this.cQf);
          }
          a.this.postInvalidate();
          this.cPZ = f1;
          this.cQa = f2;
          this.Lsy = f3;
          AppMethodBeat.o(9374);
        }
      });
      this.cPJ.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          a.a.this.cPV = true;
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(9376);
          if (a.a.this.Lsx != null) {
            a.a.this.Lsx.NX();
          }
          a.a.this.cPV = true;
          a.this.Lsl.set(a.this.dal);
          a.this.Lsr = (a.this.e(a.this.Lsl) * 1.0F);
          if (a.a.this.Lsw)
          {
            a.this.Lpj = (a.this.e(a.this.Lsl) * 3.0F);
            a.a.a(a.a.this);
          }
          AppMethodBeat.o(9376);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(9375);
          if (a.a.this.Lsx != null) {
            a.a.this.Lsx.onStart();
          }
          a.a.this.cPV = false;
          AppMethodBeat.o(9375);
        }
      });
      this.cPJ.setInterpolator(new LinearInterpolator());
      this.cPJ.setDuration(166L);
      this.cPJ.start();
      AppMethodBeat.o(9377);
    }
  }
  
  public static abstract interface b
  {
    public abstract void NX();
    
    public abstract void onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.b.a
 * JD-Core Version:    0.7.0.1
 */