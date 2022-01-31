package com.tencent.mm.view.b;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
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
import com.tencent.mm.api.q.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.y;

public class a
  extends View
{
  private boolean bAz = false;
  private com.tencent.mm.bt.b bzV;
  protected Matrix bzW;
  private Rect bzX;
  private Rect dHI;
  private float dHP = 1.0F;
  private float jeW;
  private float jeX;
  float[] values = new float[9];
  protected Matrix wxk;
  public Rect wxl;
  private Rect wxm;
  private Rect wxn;
  private Runnable wxo;
  protected float wxp;
  protected float wxq;
  private boolean wxr = true;
  
  public a(Context paramContext, com.tencent.mm.bt.b paramb)
  {
    super(paramContext);
    this.bzV = paramb;
    this.bzW = new Matrix();
    this.wxk = new Matrix();
    this.bzX = new Rect();
    this.wxl = new Rect();
    this.wxm = new Rect();
    this.dHI = new Rect();
    this.wxn = new Rect();
    paramContext = paramb.coJ();
    if (paramContext != null)
    {
      this.dHI.set(0, 0, paramContext.getWidth(), paramContext.getHeight());
      this.bzX.set(this.dHI);
      this.wxn.set(this.dHI);
    }
    if ((!cLB()) && (paramb.getConfig().rect != null))
    {
      paramContext = paramb.getConfig().rect;
      this.bzX.set(0, 0, paramContext.width(), paramContext.height());
      this.bzW.postTranslate(0.0F, paramContext.top);
    }
  }
  
  private float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.values);
    return this.values[paramInt];
  }
  
  protected void P(MotionEvent paramMotionEvent) {}
  
  public final void a(a.b paramb, float paramFloat, boolean paramBoolean)
  {
    Object localObject = getCurImageRect();
    int i = (int)((RectF)localObject).centerX();
    int j = (int)((RectF)localObject).centerY();
    int k = getBoardRect().centerX();
    int m = getBoardRect().centerY();
    if (paramFloat % 180.0F == 0.0F)
    {
      f = 1.0F * ((RectF)localObject).width() / ((RectF)localObject).height();
      if (f >= 1.0F * getBoardRect().width() / getBoardRect().height()) {
        break label355;
      }
      getBoardRect().width();
      f = getBoardRect().height();
      label107:
      if (paramFloat % 180.0F != 0.0F) {
        break label379;
      }
    }
    label355:
    label379:
    for (float f = f * 1.0F / ((RectF)localObject).height();; f = f * 1.0F / ((RectF)localObject).width())
    {
      localObject = new a.a(this, f, k - i, m - j, i, j, paramFloat, paramBoolean);
      ((a.a)localObject).wxw = paramb;
      ((a.a)localObject).jQ = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 0.0F, 166.0F }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, ((a.a)localObject).wxt }), PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, ((a.a)localObject).wxu }), PropertyValuesHolder.ofFloat("rotation", new float[] { 0.0F, ((a.a)localObject).gb }) });
      ((a.a)localObject).jQ.addUpdateListener(new a.a.1((a.a)localObject));
      ((a.a)localObject).jQ.addListener(new a.a.2((a.a)localObject));
      ((a.a)localObject).jQ.setInterpolator(new LinearInterpolator());
      ((a.a)localObject).jQ.setDuration(166L);
      ((a.a)localObject).jQ.start();
      return;
      f = 1.0F * ((RectF)localObject).height() / ((RectF)localObject).width();
      break;
      getBoardRect().height();
      f = getBoardRect().width() / f;
      break label107;
    }
  }
  
  public final float b(Matrix paramMatrix)
  {
    return (float)Math.round(Math.atan2(a(paramMatrix, 1), a(paramMatrix, 0)) * 57.295779513082323D);
  }
  
  protected boolean cLA()
  {
    return this.wxr;
  }
  
  public boolean cLB()
  {
    return true;
  }
  
  public final void cLC()
  {
    Object localObject = getRawImageRect();
    float f2;
    if (b(this.bzW) % 180.0F == 0.0F)
    {
      f1 = ((Rect)localObject).width() * 1.0F / ((Rect)localObject).height();
      if (f1 >= getBoardRect().width() * 1.0F / getBoardRect().height()) {
        break label305;
      }
      f1 = getBoardRect().width() / f1;
      f2 = getBoardRect().height();
      label82:
      if (b(this.bzW) % 180.0F != 0.0F) {
        break label330;
      }
      f2 = 1.0F * f2 / ((Rect)localObject).height();
      label109:
      if (b(this.bzW) % 180.0F != 0.0F) {
        break label344;
      }
    }
    label305:
    label330:
    label344:
    for (float f1 = f1 * 1.0F / ((Rect)localObject).height();; f1 = f1 * 1.0F / ((Rect)localObject).width())
    {
      int i = ((Rect)localObject).centerX();
      int j = ((Rect)localObject).centerY();
      this.bzW.postScale(f2, f2, i, j);
      localObject = getCurImageRect();
      i = (int)((RectF)localObject).centerX();
      j = (int)((RectF)localObject).centerY();
      int k = getBoardRect().centerX();
      int m = getBoardRect().centerY();
      this.bzW.postTranslate(k - i, m - j);
      this.wxk.set(this.bzW);
      this.wxp = (d(this.wxk) * 3.0F);
      this.wxq = (d(this.wxk) * 1.0F);
      if (this.wxp < f1) {
        this.wxp = (f1 * 1.2F);
      }
      return;
      f1 = ((Rect)localObject).height() * 1.0F / ((Rect)localObject).width();
      break;
      float f3 = getBoardRect().height();
      f2 = getBoardRect().width() / f1;
      f1 = f3;
      break label82;
      f2 = 1.0F * f2 / ((Rect)localObject).width();
      break label109;
    }
  }
  
  protected final float d(Matrix paramMatrix)
  {
    float f1 = a(paramMatrix, 3);
    float f2 = a(paramMatrix, 0);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public Rect getAliveRect()
  {
    return this.bzX;
  }
  
  public Rect getBoardRect()
  {
    return this.wxl;
  }
  
  public RectF getCurImageRect()
  {
    RectF localRectF = new RectF(getRawImageRect());
    this.bzW.mapRect(localRectF);
    return localRectF;
  }
  
  public float getCurScale()
  {
    return d(this.bzW);
  }
  
  public Rect getImageBitmapRect()
  {
    return this.wxn;
  }
  
  public float getInitScale()
  {
    if (cLB()) {
      return this.dHP;
    }
    return 1.0F;
  }
  
  public Matrix getMainMatrix()
  {
    return this.bzW;
  }
  
  public float getMaxScale()
  {
    return this.wxp;
  }
  
  public float getMinScale()
  {
    return this.wxq;
  }
  
  public com.tencent.mm.bt.b getPresenter()
  {
    return this.bzV;
  }
  
  public Rect getRawBoardRect()
  {
    return this.wxm;
  }
  
  public Rect getRawImageRect()
  {
    return this.dHI;
  }
  
  public final void m(Rect paramRect)
  {
    this.dHI.set(paramRect);
    this.bzX.set(paramRect);
    y.i("MicroMsg.BaseBoardView", "[resetImageRect] rect");
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    paramCanvas.setMatrix(this.bzW);
    getPresenter().onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    y.i("changelcai", "[onLayout] %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.wxl.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.wxm.set(this.wxl);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject;
    if (getPresenter().coK())
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.jeW = paramMotionEvent.getX();
        this.jeX = paramMotionEvent.getY();
      }
      if (paramMotionEvent.getAction() != 1) {
        break label284;
      }
      removeCallbacks(this.wxo);
      long l = 0L;
      if (this.bAz) {
        l = 700L;
      }
      if (getPresenter().coI().tG() == com.tencent.mm.e.a.bzR) {
        break label139;
      }
      localObject = new Runnable()
      {
        public final void run()
        {
          if (a.this.getPresenter().coH().buX)
          {
            a.this.getPresenter().coH().setFooterVisible(false);
            a.this.getPresenter().coH().setActionBarVisible(false);
            return;
          }
          a.this.getPresenter().coH().setFooterVisible(true);
          a.this.getPresenter().coH().setActionBarVisible(true);
        }
      };
      this.wxo = ((Runnable)localObject);
      postDelayed((Runnable)localObject, l);
      this.bAz = false;
    }
    for (;;)
    {
      if ((!getPresenter().A(paramMotionEvent)) && (cLB())) {
        P(paramMotionEvent);
      }
      return true;
      label139:
      getPresenter().coH().od(true);
      if (getPresenter().coH().buX)
      {
        getPresenter().coH().setFooterVisible(false);
        getPresenter().coH().setActionBarVisible(false);
      }
      label282:
      for (;;)
      {
        getPresenter().coH().getBaseFooterView().cLH();
        break;
        localObject = getPresenter().coH();
        if ((((com.tencent.mm.view.a)localObject).wvA.getVisibility() == 0) || (((com.tencent.mm.view.a)localObject).getTextEditView().getVisibility() == 0)) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label282;
          }
          getPresenter().coH().setFooterVisible(true);
          getPresenter().coH().setActionBarVisible(true);
          break;
        }
      }
      label284:
      if (paramMotionEvent.getAction() == 2)
      {
        if ((Math.abs(paramMotionEvent.getX() - this.jeW) >= 3.0F) || (Math.abs(paramMotionEvent.getY() - this.jeX) >= 3.0F))
        {
          this.bAz = true;
          removeCallbacks(this.wxo);
          if (getPresenter().coH().buX)
          {
            getPresenter().coH().setFooterVisible(false);
            getPresenter().coH().setActionBarVisible(false);
          }
        }
        this.jeW = paramMotionEvent.getX();
        this.jeX = paramMotionEvent.getY();
      }
    }
  }
  
  public void setOneFingerMoveEnable(boolean paramBoolean)
  {
    this.wxr = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.b.a
 * JD-Core Version:    0.7.0.1
 */