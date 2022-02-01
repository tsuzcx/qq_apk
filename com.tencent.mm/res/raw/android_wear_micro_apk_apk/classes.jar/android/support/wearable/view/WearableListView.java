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
  private boolean GA = true;
  private boolean GB = true;
  private int GC;
  private int GD;
  private y GE;
  private Animator GF;
  private int GG;
  private ad GH = new ad(this);
  private final List<Object> GI = new ArrayList();
  private final List<Object> GJ = new ArrayList();
  private ac GK;
  private boolean GL;
  private float GM;
  private float GN;
  private float GO;
  private boolean GP;
  private int GQ = 0;
  private final float[] GR = new float[2];
  private boolean GS;
  private int GT = 0;
  private final int[] GU = new int[2];
  private View GV = null;
  private final Runnable GW = new Runnable()
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
  private final Runnable GX = new Runnable()
  {
    public final void run()
    {
      WearableListView.c(WearableListView.this);
    }
  };
  private Runnable GY = new Runnable()
  {
    public final void run()
    {
      WearableListView.d(WearableListView.this);
    }
  };
  private final ab GZ = new ab((byte)0);
  private boolean Gz;
  private final int mi;
  private Scroller nc;
  private final int vy;
  private final int vz;
  
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
    dm();
    setOverScrollMode(2);
    a(new z(this, (byte)0));
    a(new android.support.v7.widget.ad()
    {
      public final void aB(int paramAnonymousInt)
      {
        if ((paramAnonymousInt == 0) && (WearableListView.this.getChildCount() > 0)) {
          WearableListView.a(WearableListView.this, paramAnonymousInt);
        }
        Iterator localIterator = WearableListView.e(WearableListView.this).iterator();
        while (localIterator.hasNext()) {
          localIterator.next();
        }
      }
      
      public final void aC(int paramAnonymousInt)
      {
        WearableListView.b(WearableListView.this, paramAnonymousInt);
      }
    });
    paramContext = ViewConfiguration.get(paramContext);
    this.mi = paramContext.getScaledTouchSlop();
    this.vy = paramContext.getScaledMinimumFlingVelocity();
    this.vz = paramContext.getScaledMaximumFlingVelocity();
  }
  
  private void Y(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      throw new IllegalArgumentException("newCenterIndex must be different from oldCenterIndex");
    }
    ArrayList localArrayList = new ArrayList();
    View localView = getChildAt(paramInt1);
    a(localArrayList, fR() - localView.getTop());
  }
  
  private void a(int paramInt, Animator.AnimatorListener paramAnimatorListener)
  {
    a(null, paramInt, 150L, 0L, paramAnimatorListener);
  }
  
  private void a(MotionEvent paramMotionEvent, int paramInt)
  {
    if ((this.GA) && (paramMotionEvent != null) && (j(paramMotionEvent)))
    {
      paramMotionEvent = getHandler();
      if (paramMotionEvent != null) {
        paramMotionEvent.postDelayed(this.GX, ViewConfiguration.getTapTimeout());
      }
    }
    while ((paramInt != 0) || (fP())) {
      return;
    }
    fS();
  }
  
  private void a(List<Animator> paramList, int paramInt)
  {
    a(paramList, paramInt, 150L);
  }
  
  private void a(List<Animator> paramList, int paramInt, long paramLong)
  {
    a(paramList, paramInt, 150L, 0L, null);
  }
  
  private void a(List<Animator> paramList, int paramInt, long paramLong1, long paramLong2, Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.GF != null) {
      this.GF.cancel();
    }
    this.GG = 0;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this, this.GH, new int[] { 0, -paramInt });
    Object localObject = localObjectAnimator;
    if (paramList != null)
    {
      paramList.add(localObjectAnimator);
      localObject = new AnimatorSet();
      ((AnimatorSet)localObject).playTogether(paramList);
    }
    this.GF = ((Animator)localObject);
    this.GF.setDuration(paramLong1);
    if (paramAnimatorListener != null) {
      this.GF.addListener(paramAnimatorListener);
    }
    if (0L > 0L) {
      this.GF.setStartDelay(0L);
    }
    this.GF.start();
  }
  
  private void a(float[] paramArrayOfFloat)
  {
    int[] arrayOfInt = this.GU;
    this.GU[1] = 0;
    arrayOfInt[0] = 0;
    getLocationOnScreen(this.GU);
    int i = this.GU[1];
    int j = getHeight();
    paramArrayOfFloat[0] = (i + j * 0.33F);
    paramArrayOfFloat[1] = (i + j * 0.67F);
  }
  
  private af aO(View paramView)
  {
    return (af)super.af(paramView);
  }
  
  private static int aP(View paramView)
  {
    return paramView.getTop() + paramView.getPaddingTop() + aQ(paramView) / 2;
  }
  
  private static int aQ(View paramView)
  {
    return paramView.getHeight() - paramView.getPaddingBottom() - paramView.getPaddingTop();
  }
  
  private void fN()
  {
    if (this.GV != null)
    {
      this.GV.setPressed(false);
      this.GV = null;
    }
    Handler localHandler = getHandler();
    if (localHandler != null) {
      localHandler.removeCallbacks(this.GW);
    }
  }
  
  private int fO()
  {
    int n = getChildCount();
    int j = 2147483647;
    int i1 = aP(this);
    int i = 0;
    int k = -1;
    if (i < n)
    {
      View localView = getChildAt(i);
      int m = getTop();
      m = Math.abs(i1 - (aP(localView) + m));
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
  
  private boolean fP()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (getChildCount() > 0)
    {
      bool1 = bool2;
      if (this.GO <= fR())
      {
        bool1 = bool2;
        if (getChildAt(0).getTop() >= getHeight() / 2)
        {
          bool1 = bool2;
          if (this.GK != null) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private int fQ()
  {
    return aQ(this) / 3 + 1;
  }
  
  private boolean i(MotionEvent paramMotionEvent)
  {
    if (this.GS) {
      return this.GP;
    }
    float f1 = Math.abs(this.GM - paramMotionEvent.getX());
    float f2 = Math.abs(this.GN - paramMotionEvent.getY());
    if (f1 * f1 + f2 * f2 > this.mi * this.mi)
    {
      if (f1 > f2) {
        this.GP = false;
      }
      this.GS = true;
    }
    return this.GP;
  }
  
  private boolean j(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {}
    float f;
    int i;
    do
    {
      return false;
      f = paramMotionEvent.getRawY();
      i = fO();
      paramMotionEvent = aO(getChildAt(i));
      a(this.GR);
      if ((f > this.GR[0]) && (f < this.GR[1]))
      {
        if (this.GE != null) {
          this.GE.a(paramMotionEvent);
        }
        return true;
      }
      if ((i > 0) && (f <= this.GR[0]))
      {
        Y(i - 1, i);
        return true;
      }
      if ((i < getChildCount() - 1) && (f >= this.GR[1]))
      {
        Y(i + 1, i);
        return true;
      }
    } while ((i != 0) || (f > this.GR[0]) || (this.GE == null));
    return true;
  }
  
  private void w(boolean paramBoolean)
  {
    Object localObject1 = (z)jdMethod_do();
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
        Object localObject2 = aO(((z)localObject1).getChildAt(i));
        int j;
        if (i == m)
        {
          j = 1;
          if ((((af)localObject2).wT instanceof aa))
          {
            localObject2 = (aa)((af)localObject2).wT;
            if (j == 0) {
              break label101;
            }
            ((aa)localObject2).fU();
          }
        }
        for (;;)
        {
          i += 1;
          break;
          j = 0;
          break label57;
          ((aa)localObject2).fV();
        }
      }
      i = aO(getChildAt(m)).getPosition();
    } while (i == this.GT);
    localObject1 = this.GI.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((Iterator)localObject1).next();
    }
    localObject1 = this.GJ.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((Iterator)localObject1).next();
    }
    this.GT = i;
  }
  
  public final boolean B(int paramInt1, int paramInt2)
  {
    if (getChildCount() == 0) {}
    int i;
    do
    {
      return false;
      i = aq(getChildAt(fO()));
      if (((i == 0) && (paramInt2 < 0)) || ((i == dn().getItemCount() - 1) && (paramInt2 > 0))) {
        return super.B(paramInt1, paramInt2);
      }
    } while (Math.abs(paramInt2) < this.vy);
    int j = Math.max(Math.min(paramInt2, this.vz), -this.vz);
    if (this.nc == null) {
      this.nc = new Scroller(getContext(), null, true);
    }
    this.nc.fling(0, 0, 0, j, -2147483648, 2147483647, -2147483648, 2147483647);
    paramInt2 = this.nc.getFinalY() / (getPaddingTop() + aQ(this) / 2);
    paramInt1 = paramInt2;
    if (paramInt2 == 0) {
      if (j <= 0) {
        break label188;
      }
    }
    label188:
    for (paramInt1 = 1;; paramInt1 = -1)
    {
      smoothScrollToPosition(Math.max(0, Math.min(dn().getItemCount() - 1, paramInt1 + i)));
      return true;
    }
  }
  
  public final void a(t paramt)
  {
    this.GZ.a(paramt);
    super.a(paramt);
  }
  
  public final void a(y paramy)
  {
    this.GE = paramy;
  }
  
  public final int fR()
  {
    return getPaddingTop() + fQ();
  }
  
  public final void fS()
  {
    if (getChildCount() == 0) {
      return;
    }
    View localView = getChildAt(fO());
    a(fR() - localView.getTop(), new u()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (!fB()) {
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
    int i = getChildAt(fO()).getBaseline();
    if (i == -1) {
      return super.getBaseline();
    }
    return i + fR();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.GZ.n(this);
  }
  
  protected void onDetachedFromWindow()
  {
    this.GZ.n(null);
    super.onDetachedFromWindow();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {
      return false;
    }
    int i;
    float f;
    if ((this.GL) && (getChildCount() > 0))
    {
      i = paramMotionEvent.getActionMasked();
      if (i != 0) {
        break label104;
      }
      this.GM = paramMotionEvent.getX();
      this.GN = paramMotionEvent.getY();
      if (getChildCount() <= 0) {
        break label99;
      }
      f = getChildAt(0).getTop();
      this.GO = f;
      this.GP = true;
      this.GS = false;
    }
    for (;;)
    {
      getParent().requestDisallowInterceptTouchEvent(this.GP);
      return super.onInterceptTouchEvent(paramMotionEvent);
      label99:
      f = 0.0F;
      break;
      label104:
      if ((i == 2) && (this.GP)) {
        i(paramMotionEvent);
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if (this.GB) {}
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
        B(0, -this.vy);
        return true;
        B(0, this.vy);
        return true;
        if ((!isEnabled()) || (getVisibility() != 0) || (getChildCount() <= 0)) {
          return false;
        }
        paramKeyEvent = getChildAt(fO());
        localaf = aO(paramKeyEvent);
      } while (paramKeyEvent.performClick());
      if (this.GE != null)
      {
        this.GE.a(localaf);
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
                  i = dp();
                  bool2 = super.onTouchEvent(paramMotionEvent);
                  bool1 = bool2;
                } while (getChildCount() <= 0);
                j = paramMotionEvent.getActionMasked();
                if (j != 0) {
                  break;
                }
                bool1 = bool2;
              } while (!this.GA);
              this.GC = ((int)paramMotionEvent.getX());
              this.GD = ((int)paramMotionEvent.getY());
              f = paramMotionEvent.getRawY();
              a(this.GR);
              bool1 = bool2;
            } while (f <= this.GR[0]);
            bool1 = bool2;
          } while (f >= this.GR[1]);
          bool1 = bool2;
        } while (!(getChildAt(fO()) instanceof aa));
        paramMotionEvent = getHandler();
        bool1 = bool2;
      } while (paramMotionEvent == null);
      paramMotionEvent.removeCallbacks(this.GX);
      paramMotionEvent.postDelayed(this.GW, ViewConfiguration.getTapTimeout());
      return bool2;
      if (j == 1)
      {
        a(paramMotionEvent, i);
        getParent().requestDisallowInterceptTouchEvent(false);
        return bool2;
      }
      if (j == 2)
      {
        if ((Math.abs(this.GC - (int)paramMotionEvent.getX()) >= this.mi) || (Math.abs(this.GD - (int)paramMotionEvent.getY()) >= this.mi))
        {
          fN();
          this.GA = false;
        }
        bool1 = i(paramMotionEvent);
        getParent().requestDisallowInterceptTouchEvent(this.GP);
        return bool2 | bool1;
      }
      bool1 = bool2;
    } while (j != 3);
    getParent().requestDisallowInterceptTouchEvent(false);
    this.GA = true;
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.WearableListView
 * JD-Core Version:    0.7.0.1
 */