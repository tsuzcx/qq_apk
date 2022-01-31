package android.support.wearable.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.wearable.c;
import android.support.wearable.e;
import android.support.wearable.h;
import android.util.AttributeSet;
import android.util.Property;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

@TargetApi(20)
public class ActionChooserView
  extends View
{
  private static Property<ActionChooserView, Float> zi = new Property(Float.class, "offset") {};
  private static Property<ActionChooserView, Float> zj = new Property(Float.class, "selected_multiplier") {};
  private float iy;
  private final Paint nE = new Paint();
  private final float yG;
  private final float yH;
  private final float yI;
  private final float yJ;
  private final float yK;
  private final float yL;
  private final int yM;
  private final int yN;
  private final long yO;
  private final float yP;
  private final int yQ;
  private final boolean yR;
  private SparseArray<a> yS;
  private float yT;
  private float yU = 1.0F;
  private float yV;
  private Integer yW;
  private AnimatorSet yX;
  private ObjectAnimator yY;
  private ObjectAnimator yZ;
  private ObjectAnimator za;
  private float zb;
  private float zc;
  private boolean zd = true;
  private int ze = 0;
  private GestureDetector zf;
  private ArrayList<Object> zg;
  private Runnable zh = new Runnable()
  {
    public final void run()
    {
      if (ActionChooserView.a(ActionChooserView.this) != null)
      {
        Iterator localIterator = ActionChooserView.a(ActionChooserView.this).iterator();
        while (localIterator.hasNext())
        {
          localIterator.next();
          ActionChooserView.b(ActionChooserView.this).intValue();
        }
      }
    }
  };
  
  public ActionChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.nE.setAntiAlias(true);
    this.nE.setStyle(Paint.Style.FILL);
    paramContext = new TypedValue();
    getResources().getValue(e.wg, paramContext, true);
    this.yG = paramContext.getFloat();
    getResources().getValue(e.wf, paramContext, true);
    this.yH = paramContext.getFloat();
    getResources().getValue(e.wi, paramContext, true);
    this.yI = paramContext.getFloat();
    getResources().getValue(e.wh, paramContext, true);
    this.yJ = paramContext.getFloat();
    getResources().getValue(e.wj, paramContext, true);
    this.yK = paramContext.getFloat();
    getResources().getValue(e.wk, paramContext, true);
    this.yL = paramContext.getFloat();
    this.yM = getResources().getInteger(h.wD);
    this.yN = getResources().getInteger(h.wE);
    this.yP = (this.yI / this.yM);
    this.yQ = getResources().getInteger(h.wF);
    this.yR = getResources().getBoolean(c.wd);
    this.yO = getResources().getInteger(h.wC);
    this.yS = new SparseArray();
    paramContext = new ArrayList();
    paramContext.addAll(aM(1));
    paramContext.addAll(aM(2));
    this.yX = new AnimatorSet();
    this.yX.playSequentially(paramContext);
    this.yX.addListener(new Animator.AnimatorListener()
    {
      private boolean zl;
      
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        this.zl = true;
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if ((!this.zl) && (ActionChooserView.c(ActionChooserView.this) == 0)) {
          ActionChooserView.d(ActionChooserView.this).start();
        }
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        this.zl = false;
      }
    });
    this.yY = ObjectAnimator.ofFloat(this, zi, new float[] { 0.0F });
    this.yY.addListener(new Animator.AnimatorListener()
    {
      private boolean zl;
      
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        this.zl = true;
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if ((!this.zl) && (ActionChooserView.c(ActionChooserView.this) == 0)) {
          ActionChooserView.d(ActionChooserView.this).start();
        }
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        this.zl = false;
      }
    });
    this.yZ = ObjectAnimator.ofFloat(this, zi, new float[] { 0.0F });
    this.za = ObjectAnimator.ofFloat(this, zj, new float[] { 1.0F, (float)Math.sqrt(2.0D) });
    this.zf = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        if (Math.abs(paramAnonymousMotionEvent2.getX() - paramAnonymousMotionEvent1.getX()) >= ActionChooserView.this.getMeasuredWidth() * ActionChooserView.e(ActionChooserView.this))
        {
          if (paramAnonymousFloat1 < 0.0F) {}
          for (int i = 2;; i = 1)
          {
            ActionChooserView.a(ActionChooserView.this, i);
            ActionChooserView.f(ActionChooserView.this);
            return true;
          }
        }
        return false;
      }
    });
  }
  
  private float a(int paramInt, float paramFloat1, float paramFloat2, boolean paramBoolean, float paramFloat3)
  {
    float f1 = (paramFloat1 - this.yG) / (0.5F + this.yH - this.yG);
    float f2 = paramInt;
    paramFloat1 = paramInt;
    paramFloat2 = Math.max(0.0F, f1 * (paramFloat2 - f2));
    if (paramBoolean) {}
    for (;;)
    {
      return (paramFloat2 + paramFloat1) * paramFloat3;
      paramFloat3 = 1.0F;
    }
  }
  
  private void a(Canvas paramCanvas, a parama, int paramInt1, int paramInt2, float paramFloat)
  {
    if (parama == null) {}
    do
    {
      return;
      this.nE.setColor(parama.color);
      paramCanvas.drawCircle(paramInt1, paramInt2, paramFloat, this.nE);
    } while (parama.icon == null);
    Rect localRect = parama.icon.getBounds();
    localRect.offsetTo(paramInt1 - localRect.width() / 2, paramInt2 - localRect.height() / 2);
    parama.icon.setBounds(localRect);
    parama.icon.draw(paramCanvas);
  }
  
  private void a(a parama)
  {
    if (parama == null) {
      return;
    }
    Rect localRect = parama.icon.getBounds();
    int i = Math.max(parama.icon.getIntrinsicHeight(), parama.icon.getIntrinsicHeight());
    float f = this.yJ * 2.0F * this.yH * getMeasuredHeight() / i;
    localRect.left = 0;
    localRect.top = 0;
    localRect.right = Math.round(parama.icon.getIntrinsicWidth() * f);
    localRect.bottom = Math.round(f * parama.icon.getIntrinsicHeight());
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.ze = 0;
      if (this.yW != null)
      {
        this.yX.cancel();
        this.yZ.cancel();
        this.yY.cancel();
        ObjectAnimator localObjectAnimator = this.yZ;
        f1 = this.yT;
        float f2 = this.yH;
        if (this.yW.intValue() == 2) {}
        for (int i = -1;; i = 1)
        {
          localObjectAnimator.setFloatValues(new float[] { f1, i * (0.5F + f2) });
          this.yZ.setDuration(Math.round((Math.abs(this.yH + 0.5F) - Math.abs(this.yT)) / Math.max(this.yP, this.iy)));
          this.yZ.start();
          return;
        }
      }
      if (this.yT == 0.0F)
      {
        this.yX.start();
        return;
      }
      float f1 = this.yT;
      this.yY.setFloatValues(new float[] { f1, 0.0F });
      this.yY.setDuration(Math.round(Math.abs(f1 / this.yP)));
      this.yY.start();
      return;
    }
    if (paramBoolean2)
    {
      this.ze = 2;
      this.yX.cancel();
      this.yZ.cancel();
      this.yY.cancel();
      return;
    }
    this.ze = 1;
  }
  
  private ArrayList<Animator> aM(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 1) {}
    for (paramInt = 1;; paramInt = -1)
    {
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this, zi, new float[] { 0.0F, paramInt * this.yG });
      localObjectAnimator1.setDuration(this.yM);
      localObjectAnimator1.setStartDelay(this.yN);
      localArrayList.add(localObjectAnimator1);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this, zi, new float[] { paramInt * this.yG, 0.0F });
      localObjectAnimator1.setDuration(this.yM);
      localObjectAnimator1.setStartDelay(this.yN);
      localArrayList.add(localObjectAnimator2);
      return localArrayList;
    }
  }
  
  private void aN(int paramInt)
  {
    this.yW = Integer.valueOf(paramInt);
    this.zd = false;
  }
  
  private boolean aO(int paramInt)
  {
    return (this.yW != null) && (this.yW.intValue() == paramInt);
  }
  
  private void q(float paramFloat)
  {
    if (paramFloat < 0.0F) {}
    for (int i = -1; (this.ze == 1) && (Math.abs(paramFloat) == 0.0F); i = 1)
    {
      a(false, true);
      r(0.0F);
      invalidate();
      return;
    }
    r(i * Math.min(Math.abs(paramFloat), this.yH + 0.5F));
    if (Math.abs(this.yT) >= this.yH + 0.5F)
    {
      if (i >= 0) {
        break label175;
      }
      i = 2;
      this.yW = Integer.valueOf(i);
      if (this.yS.indexOfKey(this.yW.intValue()) >= 0)
      {
        this.zd = false;
        a(false, true);
        if (!this.yR) {
          break label180;
        }
        this.za.setDuration(this.yO);
        this.za.addListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            ActionChooserView.this.removeCallbacks(ActionChooserView.g(ActionChooserView.this));
            ActionChooserView.this.postDelayed(ActionChooserView.g(ActionChooserView.this), ActionChooserView.h(ActionChooserView.this));
          }
          
          public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator) {}
        });
        this.za.start();
      }
    }
    for (;;)
    {
      invalidate();
      return;
      label175:
      i = 1;
      break;
      label180:
      removeCallbacks(this.zh);
      postDelayed(this.zh, this.yQ);
    }
  }
  
  private void r(float paramFloat)
  {
    if (paramFloat != this.yT)
    {
      this.yT = paramFloat;
      paramFloat = Math.max(0.0F, (Math.abs(paramFloat) - this.yG) / (0.5F + this.yH - this.yG));
      if (this.yV != paramFloat)
      {
        this.yV = paramFloat;
        Iterator localIterator = this.zg.iterator();
        while (localIterator.hasNext()) {
          localIterator.next();
        }
      }
    }
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return true;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.yX.start();
  }
  
  protected void onDetachedFromWindow()
  {
    this.yX.cancel();
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = paramCanvas.getHeight();
    int j = paramCanvas.getWidth();
    int k = Math.round(j * this.yT);
    int m = Math.round(i * this.yH);
    float f = i * this.yI;
    a(paramCanvas, (a)this.yS.get(1), k - m, i / 2, a(m, this.yT, f, aO(1), this.yU));
    a(paramCanvas, (a)this.yS.get(2), k + j + m, i / 2, a(m, -this.yT, f, aO(2), this.yU));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    a((a)this.yS.get(1));
    a((a)this.yS.get(2));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (!this.zd) {
      bool = false;
    }
    while (this.zf.onTouchEvent(paramMotionEvent)) {
      return bool;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return true;
    case 0: 
      a(false, true);
      this.zb = paramMotionEvent.getX();
      this.zc = this.yT;
      return true;
    case 2: 
      float f1 = paramMotionEvent.getX() - this.zb;
      this.iy = Math.abs((f1 / getWidth() - this.zc) / (float)(paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime()));
      float f2 = this.zc;
      q(f1 / getWidth() + f2);
      return true;
    }
    if (Math.abs(paramMotionEvent.getX() - this.zb) >= getMeasuredWidth() * this.yK) {
      if (paramMotionEvent.getX() >= this.zb) {
        break label205;
      }
    }
    label205:
    for (int i = 2;; i = 1)
    {
      aN(i);
      a(true, true);
      return true;
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    boolean bool = isEnabled();
    super.setEnabled(paramBoolean);
    if (bool != paramBoolean)
    {
      this.zd = paramBoolean;
      a(paramBoolean, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.ActionChooserView
 * JD-Core Version:    0.7.0.1
 */