package com.tencent.mm.view.b;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.s.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ab;

public class a
  extends View
{
  protected Matrix ASB;
  public Rect ASC;
  private Rect ASD;
  private Rect ASE;
  private Runnable ASF;
  protected float ASG;
  protected float ASH;
  private boolean ASI;
  private com.tencent.mm.bs.b ccS;
  protected Matrix ccT;
  private Rect ccU;
  private boolean cdw;
  private Rect eFn;
  private float eFt;
  private float lnM;
  private float lnN;
  float[] values;
  
  public a(Context paramContext, com.tencent.mm.bs.b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(116402);
    this.eFt = 1.0F;
    this.ASI = true;
    this.cdw = false;
    this.values = new float[9];
    this.ccS = paramb;
    this.ccT = new Matrix();
    this.ASB = new Matrix();
    this.ccU = new Rect();
    this.ASC = new Rect();
    this.ASD = new Rect();
    this.eFn = new Rect();
    this.ASE = new Rect();
    paramContext = paramb.dqf();
    if (paramContext != null)
    {
      this.eFn.set(0, 0, paramContext.getWidth(), paramContext.getHeight());
      this.ccU.set(this.eFn);
      this.ASE.set(this.eFn);
    }
    if ((!dQS()) && (paramb.getConfig().rect != null))
    {
      paramContext = paramb.getConfig().rect;
      this.ccU.set(0, 0, paramContext.width(), paramContext.height());
      this.ccT.postTranslate(0.0F, paramContext.top);
    }
    AppMethodBeat.o(116402);
  }
  
  private float a(Matrix paramMatrix, int paramInt)
  {
    AppMethodBeat.i(116412);
    paramMatrix.getValues(this.values);
    float f = this.values[paramInt];
    AppMethodBeat.o(116412);
    return f;
  }
  
  public final void a(a.b paramb, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(116409);
    Object localObject = getCurImageRect();
    int i = (int)((RectF)localObject).centerX();
    int j = (int)((RectF)localObject).centerY();
    int k = getBoardRect().centerX();
    int m = getBoardRect().centerY();
    if (paramFloat % 180.0F == 0.0F)
    {
      f = ((RectF)localObject).width() * 1.0F / ((RectF)localObject).height();
      if (f >= getBoardRect().width() * 1.0F / getBoardRect().height()) {
        break label200;
      }
      getBoardRect().width();
      f = getBoardRect().height();
      label112:
      if (paramFloat % 180.0F != 0.0F) {
        break label224;
      }
    }
    label200:
    label224:
    for (float f = f * 1.0F / ((RectF)localObject).height();; f = f * 1.0F / ((RectF)localObject).width())
    {
      localObject = new a.a(this, f, k - i, m - j, i, j, paramFloat, paramBoolean);
      ((a.a)localObject).ASN = paramb;
      ((a.a)localObject).play();
      AppMethodBeat.o(116409);
      return;
      f = ((RectF)localObject).height() * 1.0F / ((RectF)localObject).width();
      break;
      getBoardRect().height();
      f = getBoardRect().width() / f;
      break label112;
    }
  }
  
  protected void aa(MotionEvent paramMotionEvent) {}
  
  public final float b(Matrix paramMatrix)
  {
    AppMethodBeat.i(116415);
    float f = (float)Math.round(Math.atan2(a(paramMatrix, 1), a(paramMatrix, 0)) * 57.295779513082323D);
    AppMethodBeat.o(116415);
    return f;
  }
  
  protected final float d(Matrix paramMatrix)
  {
    AppMethodBeat.i(116413);
    float f1 = a(paramMatrix, 3);
    float f2 = a(paramMatrix, 0);
    f1 = (float)Math.sqrt(f1 * f1 + f2 * f2);
    AppMethodBeat.o(116413);
    return f1;
  }
  
  protected boolean dQR()
  {
    return this.ASI;
  }
  
  public boolean dQS()
  {
    return true;
  }
  
  public final void dQT()
  {
    AppMethodBeat.i(116408);
    Object localObject = getRawImageRect();
    float f2;
    if (b(this.ccT) % 180.0F == 0.0F)
    {
      f1 = ((Rect)localObject).width() * 1.0F / ((Rect)localObject).height();
      if (f1 >= getBoardRect().width() * 1.0F / getBoardRect().height()) {
        break label313;
      }
      f1 = getBoardRect().width() / f1;
      f2 = getBoardRect().height();
      label87:
      if (b(this.ccT) % 180.0F != 0.0F) {
        break label338;
      }
      f2 = 1.0F * f2 / ((Rect)localObject).height();
      label114:
      if (b(this.ccT) % 180.0F != 0.0F) {
        break label352;
      }
    }
    label313:
    label338:
    label352:
    for (float f1 = f1 * 1.0F / ((Rect)localObject).height();; f1 = f1 * 1.0F / ((Rect)localObject).width())
    {
      int i = ((Rect)localObject).centerX();
      int j = ((Rect)localObject).centerY();
      this.ccT.postScale(f2, f2, i, j);
      localObject = getCurImageRect();
      i = (int)((RectF)localObject).centerX();
      j = (int)((RectF)localObject).centerY();
      int k = getBoardRect().centerX();
      int m = getBoardRect().centerY();
      this.ccT.postTranslate(k - i, m - j);
      this.ASB.set(this.ccT);
      this.ASG = (d(this.ASB) * 3.0F);
      this.ASH = (d(this.ASB) * 1.0F);
      if (this.ASG < f1) {
        this.ASG = (f1 * 1.2F);
      }
      AppMethodBeat.o(116408);
      return;
      f1 = ((Rect)localObject).height() * 1.0F / ((Rect)localObject).width();
      break;
      float f3 = getBoardRect().height();
      f2 = getBoardRect().width() / f1;
      f1 = f3;
      break label87;
      f2 = 1.0F * f2 / ((Rect)localObject).width();
      break label114;
    }
  }
  
  public Rect getAliveRect()
  {
    return this.ccU;
  }
  
  public Rect getBoardRect()
  {
    AppMethodBeat.i(116407);
    if (this.ASC == null) {
      this.ASC = new Rect();
    }
    Rect localRect = this.ASC;
    AppMethodBeat.o(116407);
    return localRect;
  }
  
  public RectF getCurImageRect()
  {
    AppMethodBeat.i(116410);
    RectF localRectF = new RectF(getRawImageRect());
    this.ccT.mapRect(localRectF);
    AppMethodBeat.o(116410);
    return localRectF;
  }
  
  public float getCurScale()
  {
    AppMethodBeat.i(116414);
    float f = d(this.ccT);
    AppMethodBeat.o(116414);
    return f;
  }
  
  public Rect getImageBitmapRect()
  {
    return this.ASE;
  }
  
  public float getInitScale()
  {
    AppMethodBeat.i(116406);
    if (dQS())
    {
      float f = this.eFt;
      AppMethodBeat.o(116406);
      return f;
    }
    AppMethodBeat.o(116406);
    return 1.0F;
  }
  
  public Matrix getMainMatrix()
  {
    return this.ccT;
  }
  
  public float getMaxScale()
  {
    return this.ASG;
  }
  
  public float getMinScale()
  {
    return this.ASH;
  }
  
  public com.tencent.mm.bs.b getPresenter()
  {
    return this.ccS;
  }
  
  public Rect getRawBoardRect()
  {
    return this.ASD;
  }
  
  public Rect getRawImageRect()
  {
    return this.eFn;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(116404);
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    paramCanvas.setMatrix(this.ccT);
    getPresenter().onDraw(paramCanvas);
    AppMethodBeat.o(116404);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(116403);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ab.i("changelcai", "[onLayout] %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.ASC.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.ASD.set(this.ASC);
    }
    getPresenter().dqe();
    AppMethodBeat.o(116403);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(116405);
    Object localObject;
    if (getPresenter().dqg())
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.lnM = paramMotionEvent.getX();
        this.lnN = paramMotionEvent.getY();
      }
      if (paramMotionEvent.getAction() != 1) {
        break label296;
      }
      removeCallbacks(this.ASF);
      long l = 0L;
      if (this.cdw) {
        l = 700L;
      }
      if (getPresenter().dqd().Cz() == com.tencent.mm.e.a.ccO) {
        break label151;
      }
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(116395);
          if (a.this.getPresenter().dqc().bWh)
          {
            a.this.getPresenter().dqc().setFooterVisible(false);
            a.this.getPresenter().dqc().setActionBarVisible(false);
            AppMethodBeat.o(116395);
            return;
          }
          a.this.getPresenter().dqc().setFooterVisible(true);
          a.this.getPresenter().dqc().setActionBarVisible(true);
          AppMethodBeat.o(116395);
        }
      };
      this.ASF = ((Runnable)localObject);
      postDelayed((Runnable)localObject, l);
      this.cdw = false;
    }
    for (;;)
    {
      if ((!getPresenter().K(paramMotionEvent)) && (dQS())) {
        aa(paramMotionEvent);
      }
      AppMethodBeat.o(116405);
      return true;
      label151:
      getPresenter().dqc().rN(true);
      if (getPresenter().dqc().bWh)
      {
        getPresenter().dqc().setFooterVisible(false);
        getPresenter().dqc().setActionBarVisible(false);
      }
      label294:
      for (;;)
      {
        getPresenter().dqc().getBaseFooterView().dRa();
        break;
        localObject = getPresenter().dqc();
        if ((((com.tencent.mm.view.a)localObject).osX.getVisibility() == 0) || (((com.tencent.mm.view.a)localObject).getTextEditView().getVisibility() == 0)) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label294;
          }
          getPresenter().dqc().setFooterVisible(true);
          getPresenter().dqc().setActionBarVisible(true);
          break;
        }
      }
      label296:
      if (paramMotionEvent.getAction() == 2)
      {
        if ((Math.abs(paramMotionEvent.getX() - this.lnM) >= 3.0F) || (Math.abs(paramMotionEvent.getY() - this.lnN) >= 3.0F))
        {
          this.cdw = true;
          removeCallbacks(this.ASF);
          if (getPresenter().dqc().bWh)
          {
            getPresenter().dqc().setFooterVisible(false);
            getPresenter().dqc().setActionBarVisible(false);
          }
        }
        this.lnM = paramMotionEvent.getX();
        this.lnN = paramMotionEvent.getY();
      }
    }
  }
  
  public final void p(Rect paramRect)
  {
    AppMethodBeat.i(116411);
    this.eFn.set(paramRect);
    this.ccU.set(paramRect);
    ab.i("MicroMsg.BaseBoardView", "[resetImageRect] rect");
    AppMethodBeat.o(116411);
  }
  
  public void setOneFingerMoveEnable(boolean paramBoolean)
  {
    this.ASI = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.b.a
 * JD-Core Version:    0.7.0.1
 */