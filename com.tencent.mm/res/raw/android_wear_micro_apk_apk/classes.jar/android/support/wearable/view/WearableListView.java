package android.support.wearable.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.t;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(20)
public class WearableListView
  extends RecyclerView
{
  private boolean EK;
  private boolean EL = true;
  private boolean EM = true;
  private int EN;
  private int EO;
  private y EP;
  private Animator EQ;
  private int ER;
  private ad ES = new ad(this);
  private final List<Object> ET = new ArrayList();
  private final List<Object> EU = new ArrayList();
  private ac EV;
  private boolean EW;
  private float EX;
  private float EY;
  private float EZ;
  private boolean Fa;
  private int Fb = 0;
  private final float[] Fc = new float[2];
  private boolean Fd;
  private int Fe = 0;
  private final int[] Ff = new int[2];
  private View Fg = null;
  private final Runnable Fh = new Runnable()
  {
    public final void run()
    {
      if (WearableListView.this.getChildCount() > 0)
      {
        WearableListView.a(WearableListView.this, WearableListView.this.getChildAt(WearableListView.a(WearableListView.this)));
        WearableListView.b(WearableListView.this).setPressed(true);
        return;
      }
      Log.w("WearableListView", "mPressedRunnable: the children were removed, skipping.");
    }
  };
  private final Runnable Fi = new Runnable()
  {
    public final void run()
    {
      WearableListView.c(WearableListView.this);
    }
  };
  private Runnable Fj = new Runnable()
  {
    public final void run()
    {
      WearableListView.d(WearableListView.this);
    }
  };
  private final ab Fk = new ab((byte)0);
  private final int kl;
  private Scroller lg;
  private final int tI;
  private final int tJ;
  
  public WearableListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WearableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WearableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    dd();
    setOverScrollMode(2);
    a(new z(this, (byte)0));
    a(new android.support.v7.widget.ad()
    {
      public final void ap(int paramAnonymousInt)
      {
        if ((paramAnonymousInt == 0) && (WearableListView.this.getChildCount() > 0)) {
          WearableListView.a(WearableListView.this, paramAnonymousInt);
        }
        Iterator localIterator = WearableListView.e(WearableListView.this).iterator();
        while (localIterator.hasNext()) {
          localIterator.next();
        }
      }
      
      public final void aq(int paramAnonymousInt)
      {
        WearableListView.b(WearableListView.this, paramAnonymousInt);
      }
    });
    paramContext = ViewConfiguration.get(paramContext);
    this.kl = paramContext.getScaledTouchSlop();
    this.tI = paramContext.getScaledMinimumFlingVelocity();
    this.tJ = paramContext.getScaledMaximumFlingVelocity();
  }
  
  private void W(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      throw new IllegalArgumentException("newCenterIndex must be different from oldCenterIndex");
    }
    ArrayList localArrayList = new ArrayList();
    View localView = getChildAt(paramInt1);
    a(localArrayList, fH() - localView.getTop(), 150L, 0L, null);
  }
  
  private void a(MotionEvent paramMotionEvent, int paramInt)
  {
    int j = 1;
    float f;
    int i;
    if ((this.EL) && (paramMotionEvent != null)) {
      if (isEnabled())
      {
        f = paramMotionEvent.getRawY();
        i = fF();
        paramMotionEvent = aF(getChildAt(i));
        a(this.Fc);
        if ((f > this.Fc[0]) && (f < this.Fc[1]))
        {
          if (this.EP != null) {
            this.EP.a(paramMotionEvent);
          }
          i = 1;
          if (i == 0) {
            break label226;
          }
          paramMotionEvent = getHandler();
          if (paramMotionEvent != null) {
            paramMotionEvent.postDelayed(this.Fi, ViewConfiguration.getTapTimeout());
          }
        }
      }
    }
    for (;;)
    {
      return;
      if ((i > 0) && (f <= this.Fc[0]))
      {
        W(i - 1, i);
        i = 1;
        break;
      }
      if ((i < getChildCount() - 1) && (f >= this.Fc[1]))
      {
        W(i + 1, i);
        i = 1;
        break;
      }
      if ((i == 0) && (f <= this.Fc[0]) && (this.EP != null))
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label226:
      if (paramInt == 0)
      {
        if ((getChildCount() > 0) && (this.EZ <= fH()) && (getChildAt(0).getTop() >= getHeight() / 2) && (this.EV != null)) {}
        for (paramInt = j; paramInt == 0; paramInt = 0)
        {
          fI();
          return;
        }
      }
    }
  }
  
  private void a(List<Animator> paramList, int paramInt, long paramLong1, long paramLong2, Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.EQ != null) {
      this.EQ.cancel();
    }
    this.ER = 0;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this, this.ES, new int[] { 0, -paramInt });
    Object localObject = localObjectAnimator;
    if (paramList != null)
    {
      paramList.add(localObjectAnimator);
      localObject = new AnimatorSet();
      ((AnimatorSet)localObject).playTogether(paramList);
    }
    this.EQ = ((Animator)localObject);
    this.EQ.setDuration(150L);
    if (paramAnimatorListener != null) {
      this.EQ.addListener(paramAnimatorListener);
    }
    if (0L > 0L) {
      this.EQ.setStartDelay(0L);
    }
    this.EQ.start();
  }
  
  private void a(float[] paramArrayOfFloat)
  {
    int[] arrayOfInt = this.Ff;
    this.Ff[1] = 0;
    arrayOfInt[0] = 0;
    getLocationOnScreen(this.Ff);
    int i = this.Ff[1];
    int j = getHeight();
    paramArrayOfFloat[0] = (i + j * 0.33F);
    paramArrayOfFloat[1] = (i + j * 0.67F);
  }
  
  private af aF(View paramView)
  {
    return (af)super.Z(paramView);
  }
  
  private static int aG(View paramView)
  {
    return paramView.getTop() + paramView.getPaddingTop() + aH(paramView) / 2;
  }
  
  private static int aH(View paramView)
  {
    return paramView.getHeight() - paramView.getPaddingBottom() - paramView.getPaddingTop();
  }
  
  private void fE()
  {
    if (this.Fg != null)
    {
      this.Fg.setPressed(false);
      this.Fg = null;
    }
    Handler localHandler = getHandler();
    if (localHandler != null) {
      localHandler.removeCallbacks(this.Fh);
    }
  }
  
  private int fF()
  {
    int n = getChildCount();
    int j = 2147483647;
    int i1 = aG(this);
    int i = 0;
    int k = -1;
    if (i < n)
    {
      View localView = getChildAt(i);
      int m = getTop();
      m = Math.abs(i1 - (aG(localView) + m));
      if (m >= j) {
        break label91;
      }
      k = i;
      j = m;
    }
    label91:
    for (;;)
    {
      i += 1;
      break;
      if (k == -1) {
        throw new IllegalStateException("Can't find central view.");
      }
      return k;
    }
  }
  
  private int fG()
  {
    return aH(this) / 3 + 1;
  }
  
  private boolean h(MotionEvent paramMotionEvent)
  {
    if (this.Fd) {
      return this.Fa;
    }
    float f1 = Math.abs(this.EX - paramMotionEvent.getX());
    float f2 = Math.abs(this.EY - paramMotionEvent.getY());
    if (f1 * f1 + f2 * f2 > this.kl * this.kl)
    {
      if (f1 > f2) {
        this.Fa = false;
      }
      this.Fd = true;
    }
    return this.Fa;
  }
  
  private void t(boolean paramBoolean)
  {
    Object localObject1 = (z)df();
    int k = ((z)localObject1).getChildCount();
    if (k == 0) {}
    int i;
    label57:
    label101:
    do
    {
      return;
      int m = z.a((z)localObject1);
      i = 0;
      if (i < k)
      {
        Object localObject2 = aF(((z)localObject1).getChildAt(i));
        int j;
        if (i == m)
        {
          j = 1;
          if ((((af)localObject2).ve instanceof aa))
          {
            localObject2 = (aa)((af)localObject2).ve;
            if (j == 0) {
              break label101;
            }
            ((aa)localObject2).fK();
          }
        }
        for (;;)
        {
          i += 1;
          break;
          j = 0;
          break label57;
          ((aa)localObject2).fL();
        }
      }
      i = aF(getChildAt(m)).getPosition();
    } while (i == this.Fe);
    localObject1 = this.ET.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((Iterator)localObject1).next();
    }
    localObject1 = this.EU.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((Iterator)localObject1).next();
    }
    this.Fe = i;
  }
  
  public final boolean A(int paramInt1, int paramInt2)
  {
    if (getChildCount() == 0) {}
    int i;
    do
    {
      return false;
      i = aj(getChildAt(fF()));
      if (((i == 0) && (paramInt2 < 0)) || ((i == de().getItemCount() - 1) && (paramInt2 > 0))) {
        return super.A(paramInt1, paramInt2);
      }
    } while (Math.abs(paramInt2) < this.tI);
    int j = Math.max(Math.min(paramInt2, this.tJ), -this.tJ);
    if (this.lg == null) {
      this.lg = new Scroller(getContext(), null, true);
    }
    this.lg.fling(0, 0, 0, j, -2147483648, 2147483647, -2147483648, 2147483647);
    paramInt2 = this.lg.getFinalY() / (getPaddingTop() + aH(this) / 2);
    paramInt1 = paramInt2;
    if (paramInt2 == 0) {
      if (j <= 0) {
        break label188;
      }
    }
    label188:
    for (paramInt1 = 1;; paramInt1 = -1)
    {
      smoothScrollToPosition(Math.max(0, Math.min(de().getItemCount() - 1, paramInt1 + i)));
      return true;
    }
  }
  
  public final void a(t paramt)
  {
    this.Fk.a(paramt);
    super.a(paramt);
  }
  
  public final void a(y paramy)
  {
    this.EP = paramy;
  }
  
  public final int fH()
  {
    return getPaddingTop() + fG();
  }
  
  public final void fI()
  {
    if (getChildCount() == 0) {
      return;
    }
    View localView = getChildAt(fF());
    a(null, fH() - localView.getTop(), 150L, 0L, new u()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (!fs()) {
          WearableListView.f(WearableListView.this);
        }
      }
    });
  }
  
  public int getBaseline()
  {
    if (getChildCount() == 0) {
      return super.getBaseline();
    }
    int i = getChildAt(fF()).getBaseline();
    if (i == -1) {
      return super.getBaseline();
    }
    return i + fH();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.Fk.n(this);
  }
  
  protected void onDetachedFromWindow()
  {
    this.Fk.n(null);
    super.onDetachedFromWindow();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {
      return false;
    }
    int i;
    float f;
    if ((this.EW) && (getChildCount() > 0))
    {
      i = paramMotionEvent.getActionMasked();
      if (i != 0) {
        break label104;
      }
      this.EX = paramMotionEvent.getX();
      this.EY = paramMotionEvent.getY();
      if (getChildCount() <= 0) {
        break label99;
      }
      f = getChildAt(0).getTop();
      this.EZ = f;
      this.Fa = true;
      this.Fd = false;
    }
    for (;;)
    {
      getParent().requestDisallowInterceptTouchEvent(this.Fa);
      return super.onInterceptTouchEvent(paramMotionEvent);
      label99:
      f = 0.0F;
      break;
      label104:
      if ((i == 2) && (this.Fa)) {
        h(paramMotionEvent);
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if (this.EM) {}
    switch (paramInt)
    {
    default: 
      bool = super.onKeyDown(paramInt, paramKeyEvent);
    case 260: 
    case 261: 
    case 262: 
      af localaf;
      do
      {
        return bool;
        A(0, -this.tI);
        return true;
        A(0, this.tI);
        return true;
        if ((!isEnabled()) || (getVisibility() != 0) || (getChildCount() <= 0)) {
          return false;
        }
        paramKeyEvent = getChildAt(fF());
        localaf = aF(paramKeyEvent);
      } while (paramKeyEvent.performClick());
      if (this.EP != null)
      {
        this.EP.a(localaf);
        return true;
      }
      return false;
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1;
    if (!isEnabled()) {
      bool1 = false;
    }
    boolean bool2;
    int j;
    do
    {
      int i;
      do
      {
        do
        {
          float f;
          do
          {
            do
            {
              do
              {
                do
                {
                  return bool1;
                  i = dg();
                  bool2 = super.onTouchEvent(paramMotionEvent);
                  bool1 = bool2;
                } while (getChildCount() <= 0);
                j = paramMotionEvent.getActionMasked();
                if (j != 0) {
                  break;
                }
                bool1 = bool2;
              } while (!this.EL);
              this.EN = ((int)paramMotionEvent.getX());
              this.EO = ((int)paramMotionEvent.getY());
              f = paramMotionEvent.getRawY();
              a(this.Fc);
              bool1 = bool2;
            } while (f <= this.Fc[0]);
            bool1 = bool2;
          } while (f >= this.Fc[1]);
          bool1 = bool2;
        } while (!(getChildAt(fF()) instanceof aa));
        paramMotionEvent = getHandler();
        bool1 = bool2;
      } while (paramMotionEvent == null);
      paramMotionEvent.removeCallbacks(this.Fi);
      paramMotionEvent.postDelayed(this.Fh, ViewConfiguration.getTapTimeout());
      return bool2;
      if (j == 1)
      {
        a(paramMotionEvent, i);
        getParent().requestDisallowInterceptTouchEvent(false);
        return bool2;
      }
      if (j == 2)
      {
        if ((Math.abs(this.EN - (int)paramMotionEvent.getX()) >= this.kl) || (Math.abs(this.EO - (int)paramMotionEvent.getY()) >= this.kl))
        {
          fE();
          this.EL = false;
        }
        bool1 = h(paramMotionEvent);
        getParent().requestDisallowInterceptTouchEvent(this.Fa);
        return bool2 | bool1;
      }
      bool1 = bool2;
    } while (j != 3);
    getParent().requestDisallowInterceptTouchEvent(false);
    this.EL = true;
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.WearableListView
 * JD-Core Version:    0.7.0.1
 */