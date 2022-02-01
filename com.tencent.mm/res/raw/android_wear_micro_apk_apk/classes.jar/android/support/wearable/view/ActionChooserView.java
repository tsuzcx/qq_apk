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
  private static Property<ActionChooserView, Float> AX = new Property(Float.class, "offset") {};
  private static Property<ActionChooserView, Float> AY = new Property(Float.class, "selected_multiplier") {};
  private final float AA;
  private final int AB;
  private final int AC;
  private final long AD;
  private final float AE;
  private final int AF;
  private final boolean AG;
  private SparseArray<a> AH;
  private float AI;
  private float AJ = 1.0F;
  private float AK;
  private Integer AL;
  private AnimatorSet AM;
  private ObjectAnimator AN;
  private ObjectAnimator AO;
  private ObjectAnimator AP;
  private float AQ;
  private float AR;
  private boolean AS = true;
  private int AT = 0;
  private GestureDetector AU;
  private ArrayList<Object> AV;
  private Runnable AW = new Runnable()
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
  private final float Av;
  private final float Aw;
  private final float Ax;
  private final float Ay;
  private final float Az;
  private float kw;
  private final Paint ps = new Paint();
  
  public ActionChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.ps.setAntiAlias(true);
    this.ps.setStyle(Paint.Style.FILL);
    paramContext = new TypedValue();
    getResources().getValue(e.xV, paramContext, true);
    this.Av = paramContext.getFloat();
    getResources().getValue(e.xU, paramContext, true);
    this.Aw = paramContext.getFloat();
    getResources().getValue(e.xX, paramContext, true);
    this.Ax = paramContext.getFloat();
    getResources().getValue(e.xW, paramContext, true);
    this.Ay = paramContext.getFloat();
    getResources().getValue(e.xY, paramContext, true);
    this.Az = paramContext.getFloat();
    getResources().getValue(e.xZ, paramContext, true);
    this.AA = paramContext.getFloat();
    this.AB = getResources().getInteger(h.ys);
    this.AC = getResources().getInteger(h.yt);
    this.AE = (this.Ax / this.AB);
    this.AF = getResources().getInteger(h.yu);
    this.AG = getResources().getBoolean(c.xS);
    this.AD = getResources().getInteger(h.yr);
    this.AH = new SparseArray();
    paramContext = new ArrayList();
    paramContext.addAll(bg(1));
    paramContext.addAll(bg(2));
    this.AM = new AnimatorSet();
    this.AM.playSequentially(paramContext);
    this.AM.addListener(new Animator.AnimatorListener()
    {
      private boolean Ba;
      
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        this.Ba = true;
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if ((!this.Ba) && (ActionChooserView.c(ActionChooserView.this) == 0)) {
          ActionChooserView.d(ActionChooserView.this).start();
        }
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        this.Ba = false;
      }
    });
    this.AN = ObjectAnimator.ofFloat(this, AX, new float[] { 0.0F });
    this.AN.addListener(new Animator.AnimatorListener()
    {
      private boolean Ba;
      
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        this.Ba = true;
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if ((!this.Ba) && (ActionChooserView.c(ActionChooserView.this) == 0)) {
          ActionChooserView.d(ActionChooserView.this).start();
        }
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        this.Ba = false;
      }
    });
    this.AO = ObjectAnimator.ofFloat(this, AX, new float[] { 0.0F });
    this.AP = ObjectAnimator.ofFloat(this, AY, new float[] { 1.0F, (float)Math.sqrt(2.0D) });
    this.AU = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
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
    float f1 = (paramFloat1 - this.Av) / (0.5F + this.Aw - this.Av);
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
      this.ps.setColor(parama.color);
      paramCanvas.drawCircle(paramInt1, paramInt2, paramFloat, this.ps);
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
    float f = this.Ay * 2.0F * this.Aw * getMeasuredHeight() / i;
    localRect.left = 0;
    localRect.top = 0;
    localRect.right = Math.round(parama.icon.getIntrinsicWidth() * f);
    localRect.bottom = Math.round(f * parama.icon.getIntrinsicHeight());
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.AT = 0;
      if (this.AL != null)
      {
        this.AM.cancel();
        this.AO.cancel();
        this.AN.cancel();
        ObjectAnimator localObjectAnimator = this.AO;
        f1 = this.AI;
        float f2 = this.Aw;
        if (this.AL.intValue() == 2) {}
        for (int i = -1;; i = 1)
        {
          localObjectAnimator.setFloatValues(new float[] { f1, i * (0.5F + f2) });
          this.AO.setDuration(Math.round((Math.abs(this.Aw + 0.5F) - Math.abs(this.AI)) / Math.max(this.AE, this.kw)));
          this.AO.start();
          return;
        }
      }
      if (this.AI == 0.0F)
      {
        this.AM.start();
        return;
      }
      float f1 = this.AI;
      this.AN.setFloatValues(new float[] { f1, 0.0F });
      this.AN.setDuration(Math.round(Math.abs(f1 / this.AE)));
      this.AN.start();
      return;
    }
    if (paramBoolean2)
    {
      this.AT = 2;
      this.AM.cancel();
      this.AO.cancel();
      this.AN.cancel();
      return;
    }
    this.AT = 1;
  }
  
  private ArrayList<Animator> bg(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 1) {}
    for (paramInt = 1;; paramInt = -1)
    {
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this, AX, new float[] { 0.0F, paramInt * this.Av });
      localObjectAnimator1.setDuration(this.AB);
      localObjectAnimator1.setStartDelay(this.AC);
      localArrayList.add(localObjectAnimator1);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this, AX, new float[] { paramInt * this.Av, 0.0F });
      localObjectAnimator1.setDuration(this.AB);
      localObjectAnimator1.setStartDelay(this.AC);
      localArrayList.add(localObjectAnimator2);
      return localArrayList;
    }
  }
  
  private void bh(int paramInt)
  {
    this.AL = Integer.valueOf(paramInt);
    this.AS = false;
  }
  
  private boolean bi(int paramInt)
  {
    return (this.AL != null) && (this.AL.intValue() == paramInt);
  }
  
  private void r(float paramFloat)
  {
    if (paramFloat < 0.0F) {}
    for (int i = -1; (this.AT == 1) && (Math.abs(paramFloat) == 0.0F); i = 1)
    {
      a(false, true);
      s(0.0F);
      invalidate();
      return;
    }
    s(i * Math.min(Math.abs(paramFloat), this.Aw + 0.5F));
    if (Math.abs(this.AI) >= this.Aw + 0.5F)
    {
      if (i >= 0) {
        break label175;
      }
      i = 2;
      this.AL = Integer.valueOf(i);
      if (this.AH.indexOfKey(this.AL.intValue()) >= 0)
      {
        this.AS = false;
        a(false, true);
        if (!this.AG) {
          break label180;
        }
        this.AP.setDuration(this.AD);
        this.AP.addListener(new Animator.AnimatorListener()
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
        this.AP.start();
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
      removeCallbacks(this.AW);
      postDelayed(this.AW, this.AF);
    }
  }
  
  private void s(float paramFloat)
  {
    if (paramFloat != this.AI)
    {
      this.AI = paramFloat;
      paramFloat = Math.max(0.0F, (Math.abs(paramFloat) - this.Av) / (0.5F + this.Aw - this.Av));
      if (this.AK != paramFloat)
      {
        this.AK = paramFloat;
        Iterator localIterator = this.AV.iterator();
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
    this.AM.start();
  }
  
  protected void onDetachedFromWindow()
  {
    this.AM.cancel();
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = paramCanvas.getHeight();
    int j = paramCanvas.getWidth();
    int k = Math.round(j * this.AI);
    int m = Math.round(i * this.Aw);
    float f = i * this.Ax;
    a(paramCanvas, (a)this.AH.get(1), k - m, i / 2, a(m, this.AI, f, bi(1), this.AJ));
    a(paramCanvas, (a)this.AH.get(2), k + j + m, i / 2, a(m, -this.AI, f, bi(2), this.AJ));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    a((a)this.AH.get(1));
    a((a)this.AH.get(2));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (!this.AS) {
      bool = false;
    }
    while (this.AU.onTouchEvent(paramMotionEvent)) {
      return bool;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return true;
    case 0: 
      a(false, true);
      this.AQ = paramMotionEvent.getX();
      this.AR = this.AI;
      return true;
    case 2: 
      float f1 = paramMotionEvent.getX() - this.AQ;
      this.kw = Math.abs((f1 / getWidth() - this.AR) / (float)(paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime()));
      float f2 = this.AR;
      r(f1 / getWidth() + f2);
      return true;
    }
    if (Math.abs(paramMotionEvent.getX() - this.AQ) >= getMeasuredWidth() * this.Az) {
      if (paramMotionEvent.getX() >= this.AQ) {
        break label205;
      }
    }
    label205:
    for (int i = 2;; i = 1)
    {
      bh(i);
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
      this.AS = paramBoolean;
      a(paramBoolean, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.ActionChooserView
 * JD-Core Version:    0.7.0.1
 */