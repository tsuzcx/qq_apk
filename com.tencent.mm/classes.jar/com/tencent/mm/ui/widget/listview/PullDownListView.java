package com.tencent.mm.ui.widget.listview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.av;
import com.tencent.mm.ui.ax;
import java.util.ArrayList;
import java.util.List;

public class PullDownListView
  extends ListView
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener
{
  private int Mny;
  private int Mnz;
  private int PS;
  private final int YqA;
  private View YqB;
  private float YqC;
  private float YqD;
  private boolean YqE;
  private boolean YqF;
  private boolean YqG;
  private float YqH;
  private float YqI;
  private int YqJ;
  private int YqK;
  private boolean YqL;
  private float YqM;
  private int YqN;
  private int YqO;
  private boolean YqP;
  private long YqQ;
  private long YqR;
  private int YqS;
  a YqT;
  private AdapterView.OnItemLongClickListener YqU;
  private boolean Yqk;
  private boolean Yql;
  private boolean Yqm;
  private float Yqn;
  private float Yqo;
  private float Yqp;
  private float Yqq;
  public boolean Yqr;
  private View Yqs;
  private View Yqt;
  private int Yqu;
  public IPullDownCallback Yqv;
  private int Yqw;
  private boolean Yqx;
  private final int Yqy;
  private final int Yqz;
  private float aIC;
  private float aID;
  public boolean isVisible;
  private int mActivePointerId;
  private float mLastMotionY;
  private Rect mRect;
  private boolean oZf;
  private int pEk;
  private Vibrator rqy;
  private AdapterView.OnItemClickListener tp;
  private AdapterView.OnItemSelectedListener tq;
  private View xp;
  
  public PullDownListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159440);
    this.Yqk = false;
    this.Yql = false;
    this.Yqm = true;
    this.Yqn = 0.05F;
    this.Yqo = 0.05F;
    this.Mny = 0;
    this.Mnz = 0;
    this.pEk = 0;
    this.Yqp = 0.0F;
    this.Yqq = 0.0F;
    this.Yqr = true;
    this.mRect = new Rect();
    this.PS = 0;
    this.Yqu = 0;
    this.Yqx = false;
    this.Yqy = 1;
    this.Yqz = 2;
    this.YqA = 200;
    this.YqC = 0.0F;
    this.YqD = 0.0F;
    this.oZf = false;
    this.isVisible = true;
    this.YqE = false;
    this.YqF = false;
    this.YqG = false;
    this.YqI = 0.0F;
    this.YqJ = 0;
    this.YqK = 0;
    this.YqL = false;
    this.YqM = 0.0F;
    this.mActivePointerId = -1;
    this.YqN = 0;
    this.YqO = 0;
    this.YqP = false;
    this.YqQ = 0L;
    this.YqR = 0L;
    this.YqT = null;
    super.setOnItemClickListener(this);
    super.setOnItemLongClickListener(this);
    super.setOnItemSelectedListener(this);
    ax.au(paramContext);
    this.pEk = ax.au(paramContext).y;
    this.rqy = ((Vibrator)getContext().getSystemService("vibrator"));
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(159434);
        av.d("MicroMsg.PullDownListView", "mThis.getLeft()=%s, mThis.getTop()=%s, mThis.getRight()=%s, mThis.getBottom()=%s", new Object[] { Integer.valueOf(PullDownListView.c(PullDownListView.this).getLeft()), Integer.valueOf(PullDownListView.c(PullDownListView.this).getTop()), Integer.valueOf(PullDownListView.c(PullDownListView.this).getRight()), Integer.valueOf(PullDownListView.c(PullDownListView.this).getBottom()) });
        PullDownListView.d(PullDownListView.this).set(PullDownListView.c(PullDownListView.this).getLeft(), PullDownListView.c(PullDownListView.this).getTop(), PullDownListView.c(PullDownListView.this).getRight(), PullDownListView.c(PullDownListView.this).getBottom());
        AppMethodBeat.o(159434);
      }
    });
    AppMethodBeat.o(159440);
  }
  
  private void V(final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    AppMethodBeat.i(159447);
    av.i("MicroMsg.PullDownListView", "story_cat animation: %s %s %s %s %s %s %s %s start:%s, end:%s, openLimitPx():%s, closeLimitPx():%s, isMute:%s", new Object[] { Integer.valueOf(this.mRect.left), Integer.valueOf(this.mRect.top), Integer.valueOf(this.mRect.right), Integer.valueOf(this.mRect.bottom), Integer.valueOf(getLeft()), Integer.valueOf(getTop()), Integer.valueOf(getRight()), Integer.valueOf(getBottom()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(gji()), Integer.valueOf(gjj()), Boolean.valueOf(paramBoolean) });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ObjectAnimator.ofFloat(this, "translationY", new float[] { paramInt1, paramInt2 }));
    if ((this.xp != null) && (paramInt1 > gji()) && (paramInt1 < gjj()))
    {
      if (paramInt2 != 0) {
        localArrayList.add(ObjectAnimator.ofFloat(this.xp, "translationY", new float[] { paramInt1, paramInt2 }));
      }
    }
    else if (this.YqB != null)
    {
      if (paramInt2 < getBottom()) {
        break label379;
      }
      localArrayList.add(mY(((ViewGroup.MarginLayoutParams)this.YqB.getLayoutParams()).topMargin, 0));
    }
    for (;;)
    {
      localAnimatorSet.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(159438);
          av.i("MicroMsg.PullDownListView", "onAnimationEnd start:%s, openLimitPx():%s, closeLimitPx():%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(PullDownListView.e(PullDownListView.this)), Integer.valueOf(PullDownListView.f(PullDownListView.this)) });
          PullDownListView.i(PullDownListView.this);
          PullDownListView.a(PullDownListView.this, false);
          PullDownListView.j(PullDownListView.this);
          PullDownListView.k(PullDownListView.this);
          if ((PullDownListView.g(PullDownListView.this) != null) && (paramInt1 > PullDownListView.e(PullDownListView.this)) && (paramInt1 < PullDownListView.f(PullDownListView.this))) {
            if (PullDownListView.h(PullDownListView.this))
            {
              PullDownListView.g(PullDownListView.this).onPostClose();
              if (PullDownListView.l(PullDownListView.this) != null) {
                AppMethodBeat.o(159438);
              }
            }
            else
            {
              PullDownListView.g(PullDownListView.this).onPostOpen(paramBoolean);
            }
          }
          AppMethodBeat.o(159438);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(159437);
          av.i("MicroMsg.PullDownListView", "onAnimationStart start:%s, openLimitPx():%s, closeLimitPx():%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(PullDownListView.e(PullDownListView.this)), Integer.valueOf(PullDownListView.f(PullDownListView.this)) });
          PullDownListView.a(PullDownListView.this, true);
          if (paramInt2 == 0) {
            PullDownListView.b(PullDownListView.this, true);
          }
          while ((PullDownListView.g(PullDownListView.this) != null) && (paramInt1 > PullDownListView.e(PullDownListView.this)) && (paramInt1 < PullDownListView.f(PullDownListView.this))) {
            if (PullDownListView.h(PullDownListView.this))
            {
              PullDownListView.g(PullDownListView.this).dDC();
              AppMethodBeat.o(159437);
              return;
              PullDownListView.b(PullDownListView.this, false);
            }
            else
            {
              PullDownListView.g(PullDownListView.this).dDB();
            }
          }
          AppMethodBeat.o(159437);
        }
      });
      localAnimatorSet.playTogether(localArrayList);
      localAnimatorSet.start();
      idb();
      AppMethodBeat.o(159447);
      return;
      localArrayList.add(ObjectAnimator.ofFloat(this.xp, "translationY", new float[] { paramInt1, paramInt2 - this.Yqu }));
      break;
      label379:
      localArrayList.add(mY(((ViewGroup.MarginLayoutParams)this.YqB.getLayoutParams()).topMargin, this.YqJ));
    }
  }
  
  private boolean aF(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    AppMethodBeat.i(159452);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    if (this.Yqt != null) {
      if ((paramMotionEvent.getActionMasked() != 1) || (this.YqR >= 200L)) {
        if (this.aIC < this.Yqt.getRight()) {
          if ((f1 <= this.Yqt.getLeft()) || (f1 >= this.Yqt.getRight()) || (f2 <= this.Yqt.getTop() - this.Yqt.getHeight() / 2) || (f2 >= this.Yqt.getBottom() + this.Yqu)) {}
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(159452);
      return bool;
      bool = false;
      continue;
      if ((f1 <= this.Yqt.getLeft()) || (f1 >= this.Yqt.getRight()) || (f2 <= this.Yqt.getTop()) || (f2 >= this.Yqt.getBottom() + this.Yqu))
      {
        bool = false;
        continue;
        bool = false;
      }
    }
  }
  
  private void ayD(int paramInt)
  {
    AppMethodBeat.i(252286);
    av.i("MicroMsg.PullDownListView", "story_cat animation: %s %s %s %s %s %s %s %s start:%s, end:%s, openLimitPx():%s, closeLimitPx():%s, isMute:%s", new Object[] { Integer.valueOf(this.mRect.left), Integer.valueOf(this.mRect.top), Integer.valueOf(this.mRect.right), Integer.valueOf(this.mRect.bottom), Integer.valueOf(getLeft()), Integer.valueOf(getTop()), Integer.valueOf(getRight()), Integer.valueOf(getBottom()), Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(gji()), Integer.valueOf(gjj()), Boolean.FALSE });
    setTranslationY(0.0F);
    if ((this.xp != null) && (paramInt > gji()) && (paramInt < gjj())) {
      this.xp.setTranslationY(0 - this.Yqu);
    }
    av.i("MicroMsg.PullDownListView", "onImmeStart start:%s, openLimitPx():%s, closeLimitPx():%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(gji()), Integer.valueOf(gjj()) });
    this.YqE = true;
    this.isVisible = true;
    if ((this.Yqv != null) && (paramInt > gji()) && (paramInt < gjj()))
    {
      if (this.isVisible) {
        this.Yqv.dDC();
      }
    }
    else
    {
      av.i("MicroMsg.PullDownListView", "onImmeEnd start:%s, openLimitPx():%s, closeLimitPx():%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(gji()), Integer.valueOf(gjj()) });
      this.oZf = false;
      this.YqE = false;
      this.YqF = false;
      this.YqG = false;
      if ((this.Yqv != null) && (paramInt > gji()) && (paramInt < gjj()))
      {
        if (!this.isVisible) {
          break label415;
        }
        this.Yqv.onPostClose();
        if (this.xp == null) {}
      }
    }
    for (;;)
    {
      idb();
      AppMethodBeat.o(252286);
      return;
      this.Yqv.dDB();
      break;
      label415:
      this.Yqv.onPostOpen(false);
    }
  }
  
  private int ayE(int paramInt)
  {
    AppMethodBeat.i(159451);
    int i = (int)Math.abs(paramInt / this.pEk * this.YqJ);
    av.d("MicroMsg.PullDownListView", "offset:%s,  ((float) offset / screenHeight):%s,  Math.abs(mCoordinationAnimThreshold):%s,  result:%s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramInt / this.pEk), Integer.valueOf(Math.abs(this.YqJ)), Integer.valueOf(i) });
    AppMethodBeat.o(159451);
    return i;
  }
  
  private int gji()
  {
    if (this.Mny == 0) {
      this.Mny = ((int)(this.pEk * this.Yqn));
    }
    return this.Mny;
  }
  
  private int gjj()
  {
    if (this.Mnz == 0) {
      this.Mnz = ((int)((this.pEk - this.YqK) * (1.0F - this.Yqo)));
    }
    return this.Mnz;
  }
  
  private void ida()
  {
    AppMethodBeat.i(159446);
    if (this.Yqt != null)
    {
      float f1 = this.Yqt.getTranslationX();
      float f2 = this.Yqt.getTranslationY();
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.Yqt, "translationX", new float[] { f1, this.Yqp });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.Yqt, "translationY", new float[] { f2, this.Yqq });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
      localAnimatorSet.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(159436);
          if (PullDownListView.b(PullDownListView.this) != null) {
            PullDownListView.b(PullDownListView.this).setVisibility(8);
          }
          AppMethodBeat.o(159436);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(159435);
          if (PullDownListView.b(PullDownListView.this) != null) {
            PullDownListView.b(PullDownListView.this).setVisibility(8);
          }
          AppMethodBeat.o(159435);
        }
      });
      localAnimatorSet.start();
    }
    AppMethodBeat.o(159446);
  }
  
  @TargetApi(11)
  private void idb()
  {
    AppMethodBeat.i(159449);
    this.PS = 0;
    av.d("MicroMsg.PullDownListView", "startAnimation %s %s %s %s", new Object[] { Integer.valueOf(this.Yqs.getLeft()), Integer.valueOf(this.Yqs.getTop()), Integer.valueOf(this.Yqs.getRight()), Integer.valueOf(this.Yqs.getBottom()) });
    AppMethodBeat.o(159449);
  }
  
  private boolean idc()
  {
    AppMethodBeat.i(159450);
    if ((!this.mRect.isEmpty()) && (Math.abs(this.PS) > 0))
    {
      AppMethodBeat.o(159450);
      return true;
    }
    AppMethodBeat.o(159450);
    return false;
  }
  
  private void idd()
  {
    AppMethodBeat.i(159453);
    if (this.Yqt != null) {
      this.Yqt.setVisibility(8);
    }
    AppMethodBeat.o(159453);
  }
  
  private void ide()
  {
    AppMethodBeat.i(159454);
    if (this.Yqt != null)
    {
      this.Yqt.setTranslationX(this.Yqp);
      this.Yqt.setTranslationY(this.Yqq);
      this.Yqt.setVisibility(8);
    }
    AppMethodBeat.o(159454);
  }
  
  private ValueAnimator mY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159455);
    av.d("MicroMsg.PullDownListView", "startStoryGalleryOpenAnim start:%s, end:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(159439);
        paramAnonymousValueAnimator = (Integer)paramAnonymousValueAnimator.getAnimatedValue();
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)PullDownListView.m(PullDownListView.this).getLayoutParams();
        localMarginLayoutParams.topMargin = paramAnonymousValueAnimator.intValue();
        PullDownListView.m(PullDownListView.this).setLayoutParams(localMarginLayoutParams);
        AppMethodBeat.o(159439);
      }
    });
    AppMethodBeat.o(159455);
    return localValueAnimator;
  }
  
  public final void A(View paramView, int paramInt1, int paramInt2)
  {
    this.YqB = paramView;
    this.YqK = paramInt1;
    this.YqJ = paramInt2;
    this.Mnz = 0;
    this.Mny = 0;
  }
  
  public final void ayC(int paramInt)
  {
    this.Yql = true;
    this.Yqw = paramInt;
    this.Yqm = false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159444);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(159444);
    return bool;
  }
  
  public final void icZ()
  {
    this.Yql = false;
    this.Yqm = true;
  }
  
  public final void idf()
  {
    AppMethodBeat.i(159460);
    av.i("MicroMsg.PullDownListView", "switchNormalStatus", new Object[0]);
    if (!this.isVisible)
    {
      if (this.Yql)
      {
        V((int)(this.Yqw * (1.0F - this.Yqo)), 0, false);
        AppMethodBeat.o(159460);
        return;
      }
      V(gjj() - 1, 0, false);
    }
    AppMethodBeat.o(159460);
  }
  
  public final void idg()
  {
    AppMethodBeat.i(252295);
    av.i("MicroMsg.PullDownListView", "switchNormalStatusImme", new Object[0]);
    if (!this.isVisible)
    {
      if (this.Yql)
      {
        ayD((int)(this.Yqw * (1.0F - this.Yqo)));
        AppMethodBeat.o(252295);
        return;
      }
      ayD(gjj() - 1);
    }
    AppMethodBeat.o(252295);
  }
  
  public final void idh()
  {
    AppMethodBeat.i(159461);
    av.i("MicroMsg.PullDownListView", "switchPullDownStatus", new Object[0]);
    if (this.isVisible)
    {
      if (this.Yql)
      {
        int i = this.Yqw;
        V(gji() + 1, i, false);
        AppMethodBeat.o(159461);
        return;
      }
      V(gji() + 1, this.Yqs.getBottom() + this.Yqu, false);
    }
    AppMethodBeat.o(159461);
  }
  
  @TargetApi(11)
  protected void onFinishInflate()
  {
    AppMethodBeat.i(159443);
    this.Yqs = this;
    this.YqH = getTranslationY();
    av.d("MicroMsg.PullDownListView", "onFinishInflate %s %s %s %s", new Object[] { Integer.valueOf(this.Yqs.getLeft()), Integer.valueOf(this.Yqs.getTop()), Integer.valueOf(this.Yqs.getRight()), Integer.valueOf(this.Yqs.getBottom()) });
    AppMethodBeat.o(159443);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(159456);
    if ((this.tp != null) && (!this.oZf) && ((this.isVisible) || (this.Yql)))
    {
      this.Yqx = true;
      this.tp.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    AppMethodBeat.o(159456);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(159459);
    if ((this.YqU != null) && ((this.isVisible) || (this.Yql)))
    {
      this.Yqx = true;
      boolean bool = this.YqU.onItemLongClick(paramAdapterView, paramView, paramInt, paramLong);
      AppMethodBeat.o(159459);
      return bool;
    }
    AppMethodBeat.o(159459);
    return false;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(159457);
    b localb = new b();
    localb.bn(paramAdapterView);
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.Fs(paramLong);
    a.c("com/tencent/mm/ui/widget/listview/PullDownListView", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
    if ((this.tq != null) && (!this.oZf) && ((this.isVisible) || (this.Yql)))
    {
      this.Yqx = true;
      this.tq.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    }
    a.a(this, "com/tencent/mm/ui/widget/listview/PullDownListView", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(159457);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159448);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(159448);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    AppMethodBeat.i(159458);
    if (this.tq != null) {
      this.tq.onNothingSelected(paramAdapterView);
    }
    AppMethodBeat.o(159458);
  }
  
  @TargetApi(11)
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159445);
    av.d("MicroMsg.PullDownListView", "dancy test onTouchEvent, supportOverscroll:%s, scrollY:%s", new Object[] { Boolean.valueOf(this.Yqk), Integer.valueOf(getScrollY()) });
    boolean bool1;
    if ((!this.Yqk) || (this.Yqs == null) || (this.YqE))
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(159445);
      return bool1;
    }
    int j = paramMotionEvent.getActionMasked();
    av.d("MicroMsg.PullDownListView", "onTouchEvent %s", new Object[] { Integer.valueOf(j) });
    label147:
    float f;
    label395:
    label409:
    int k;
    label464:
    int i;
    switch (j)
    {
    case 4: 
    default: 
    case 0: 
    case 2: 
      do
      {
        for (bool1 = false;; bool1 = false)
        {
          av.d("MicroMsg.PullDownListView", "consumed: %b", new Object[] { Boolean.valueOf(bool1) });
          if (bool1) {
            paramMotionEvent.setAction(3);
          }
          if (!bool1) {
            break label2349;
          }
          AppMethodBeat.o(159445);
          return true;
          if (this.YqL) {
            break;
          }
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          idd();
          this.Yqx = false;
          f = paramMotionEvent.getY(0);
          this.mLastMotionY = f;
          this.YqC = f;
          this.YqD = paramMotionEvent.getX(0);
          this.mRect.setEmpty();
          this.aID = paramMotionEvent.getY(0);
          this.aIC = paramMotionEvent.getX(0);
          this.YqI = 0.0F;
          if ((this.Yql) && (!this.isVisible)) {
            this.YqI = getTranslationY();
          }
          this.YqN = ((int)this.YqI);
          this.YqL = true;
          this.YqP = false;
          this.YqQ = System.currentTimeMillis();
          this.YqR = 0L;
          ide();
        }
        this.oZf = true;
        if (!this.YqL)
        {
          if (this.isVisible) {
            break label1447;
          }
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          this.mLastMotionY = paramMotionEvent.getY(0);
          this.aID = paramMotionEvent.getY(0);
          if (!this.Yql) {
            break;
          }
          this.YqI = this.YqS;
          this.YqN = ((int)this.YqI);
          this.YqL = true;
        }
        k = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      } while (k == -1);
      this.YqC = paramMotionEvent.getY(k);
      this.YqD = paramMotionEvent.getX(k);
      if (this.YqC - this.aID >= 0.0F)
      {
        this.YqO = 2;
        i = getChildCount();
        if ((i <= 0) || (!this.isVisible)) {
          break label2497;
        }
        if (this.YqO != 2) {
          break label1554;
        }
        if (getChildAt(0).getTop() >= getPaddingTop() + 0) {
          break label1549;
        }
        i = 1;
      }
      break;
    }
    for (;;)
    {
      label507:
      if (i != 0) {
        this.YqP = true;
      }
      label1055:
      ViewGroup.MarginLayoutParams localMarginLayoutParams;
      if (!this.YqP)
      {
        av.d("MicroMsg.PullDownListView", "rawY:%s, rawX:%s, indexY:%s, indexX:%s", new Object[] { Float.valueOf(paramMotionEvent.getRawY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getY(k)), Float.valueOf(paramMotionEvent.getX(k)) });
        av.d("MicroMsg.PullDownListView", "move deltaY:%s, isAnima:%s, mDeltaY:%s, mIsIgnoreCallBack:%s translateBaseY:%s", new Object[] { Integer.valueOf((int)(this.mLastMotionY - this.YqC)), Boolean.valueOf(this.YqE), Integer.valueOf(this.PS), Boolean.valueOf(this.Yqx), Float.valueOf(this.YqI) });
        if ((!this.Yqx) && (!this.YqE))
        {
          if (this.mRect.isEmpty())
          {
            this.YqH = getTranslationY();
            this.mRect.set(this.Yqs.getLeft(), this.Yqs.getTop(), this.Yqs.getRight(), this.Yqs.getBottom());
            av.d("MicroMsg.PullDownListView", "mRect.isEmpty() %s %s %s %s", new Object[] { Integer.valueOf(this.Yqs.getLeft()), Integer.valueOf(this.Yqs.getTop()), Integer.valueOf(this.Yqs.getRight()), Integer.valueOf(this.Yqs.getBottom()) });
          }
          av.d("MicroMsg.PullDownListView", "eventIndex:%s, ev.getY():%s, y_down:%s, ev.getY()-y_down:%s", new Object[] { Integer.valueOf(k), Float.valueOf(paramMotionEvent.getY(k)), Float.valueOf(this.aID), Float.valueOf(paramMotionEvent.getY(k) - this.aID) });
          this.YqN += (int)((int)(this.YqC - this.mLastMotionY) / 2.0F);
          this.PS = Math.max(0, this.YqN);
          av.d("MicroMsg.PullDownListView", "top %s, bottom:%s, mDeltaY %s, deltaOverScrollY:%s", new Object[] { Integer.valueOf(this.Yqs.getTop()), Integer.valueOf(this.Yqs.getBottom()), Integer.valueOf(this.PS), Integer.valueOf(this.YqN) });
          if (Math.abs(this.YqN) > 50)
          {
            if ((!this.YqF) && (this.PS >= gji()) && (this.PS <= gjj()))
            {
              if (this.Yqm) {
                this.rqy.vibrate(10L);
              }
              this.YqF = true;
              this.YqM = this.YqN;
            }
            av.d("MicroMsg.PullDownListView", "OverScroll top %s, mIsIgnoreCallBack:%s, isVisible:%s", new Object[] { Integer.valueOf(this.mRect.top + this.PS), Boolean.valueOf(this.Yqx), Boolean.valueOf(this.isVisible) });
            bool1 = true;
            this.Yqs.setTranslationY(this.PS);
            if (this.isVisible)
            {
              i = ayE(Math.max(this.PS - (int)this.YqI, 0));
              if (this.YqB != null)
              {
                localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.YqB.getLayoutParams();
                localMarginLayoutParams.topMargin = Math.max(this.YqJ, Math.min(0, i + this.YqJ));
                av.d("MicroMsg.PullDownListView", "openingCoordinationView params.bottomMargin:%s", new Object[] { Integer.valueOf(localMarginLayoutParams.bottomMargin) });
                this.YqB.setLayoutParams(localMarginLayoutParams);
              }
              if (this.Yqv != null) {
                this.Yqv.abo(ayE(Math.max(this.PS - gji() - (int)this.YqI, 0)));
              }
              label1205:
              if (this.YqM != 0.0F)
              {
                i = (int)((int)(this.YqN - this.YqM) * 3.0F);
                if ((!this.isVisible) || (i <= 0) || (this.Yqv == null)) {
                  break label1746;
                }
                f = i;
                if (this.Yqt != null)
                {
                  this.Yqt.setTranslationX(Math.min(this.Yqp + f, 0.0F));
                  this.Yqt.setTranslationY(Math.max(this.Yqq - f, 0.0F));
                  this.Yqt.setVisibility(0);
                }
                if ((this.YqG) || (!aF(paramMotionEvent))) {
                  break label1718;
                }
                if (this.Yqm) {
                  this.rqy.vibrate(20L);
                }
                this.YqG = true;
                label1339:
                if (!this.YqG) {
                  break label1734;
                }
                this.Yqv.fqe();
              }
              label1355:
              av.d("MicroMsg.PullDownListView", "mThis.layout %s %s %s %s", new Object[] { Integer.valueOf(this.Yqs.getLeft()), Integer.valueOf(this.Yqs.getTop()), Integer.valueOf(this.Yqs.getRight()), Integer.valueOf(this.Yqs.getBottom()) });
            }
          }
        }
      }
      for (;;)
      {
        this.mLastMotionY = this.YqC;
        break label147;
        this.YqI = (this.pEk - this.YqK);
        break label395;
        label1447:
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        idd();
        this.Yqx = false;
        f = paramMotionEvent.getY(0);
        this.mLastMotionY = f;
        this.YqC = f;
        this.YqD = paramMotionEvent.getX(0);
        this.mRect.setEmpty();
        this.aID = paramMotionEvent.getY(0);
        this.aIC = paramMotionEvent.getX(0);
        this.YqI = 0.0F;
        this.YqN = ((int)this.YqI);
        this.YqL = true;
        ide();
        break label409;
        this.YqO = 1;
        break label464;
        label1549:
        i = 0;
        break label507;
        label1554:
        if (this.YqO != 1) {
          break label2497;
        }
        if (getChildAt(i - 1).getBottom() >= getHeight() - getPaddingBottom())
        {
          i = 1;
          break label507;
        }
        i = 0;
        break label507;
        i = ayE(Math.max((int)this.YqI - this.PS, 0));
        if (this.YqB != null)
        {
          localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.YqB.getLayoutParams();
          localMarginLayoutParams.topMargin = Math.min(0, Math.max(this.YqJ, -i));
          av.d("MicroMsg.PullDownListView", "closingCoordinationView params.bottomMargin:%s", new Object[] { Integer.valueOf(localMarginLayoutParams.bottomMargin) });
          this.YqB.setLayoutParams(localMarginLayoutParams);
        }
        if (this.Yqv == null) {
          break label1205;
        }
        this.Yqv.abp(ayE(Math.max(gjj() - this.PS, 0)));
        break label1205;
        label1718:
        if (aF(paramMotionEvent)) {
          break label1339;
        }
        this.YqG = false;
        break label1339;
        label1734:
        this.Yqv.fqf();
        break label1355;
        label1746:
        idd();
        break label1355;
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        if (i == -1) {
          break;
        }
        this.YqC = paramMotionEvent.getY(i);
        this.YqD = paramMotionEvent.getX(i);
        ida();
        this.mLastMotionY = 0.0F;
        this.YqM = 0.0F;
        this.YqF = false;
        this.YqR = (System.currentTimeMillis() - this.YqQ);
        av.d("MicroMsg.PullDownListView", "dancy test action up, mDeltaY:%s, closeLimitPx:%s, bottom:%s, mPullDownDuration%s", new Object[] { Integer.valueOf(this.PS), Integer.valueOf(gjj()), Integer.valueOf(this.Yqs.getBottom()), Long.valueOf(this.YqR) });
        if ((idc()) && (this.Yqv != null) && (!this.YqE) && (this.Yqr) && (!this.YqP))
        {
          av.d("MicroMsg.PullDownListView", "dancy test action up, deltaOverScrollY:%s, translateBaseY:%s", new Object[] { Integer.valueOf(this.YqN), Float.valueOf(this.YqI) });
          if (this.YqN - this.YqI > 0.0F)
          {
            i = 1;
            label1955:
            if (i == 0) {
              break label2085;
            }
            if (((!this.isVisible) || (this.PS < gji())) && ((this.isVisible) || (this.PS < gjj()))) {
              break label2480;
            }
            i = this.Yqs.getBottom() + this.Yqu;
            if (this.Yql)
            {
              i = this.Yqw;
              this.YqS = i;
            }
          }
        }
        for (;;)
        {
          V(this.PS, i, aF(paramMotionEvent));
          label2039:
          this.Yqx = false;
          this.YqL = false;
          this.YqN = 0;
          this.mActivePointerId = -1;
          this.YqP = false;
          this.YqR = 0L;
          this.YqQ = 0L;
          bool1 = false;
          break label147;
          i = 0;
          break label1955;
          label2085:
          if (this.YqN - this.YqI < 0.0F)
          {
            i = 1;
            label2102:
            if (i == 0) {
              break label2131;
            }
            if (this.PS >= 0) {
              break label2133;
            }
            i = 0;
          }
          for (;;)
          {
            V(this.PS, i, false);
            break label2039;
            i = 0;
            break label2102;
            label2131:
            break label2039;
            label2133:
            if (this.PS >= gjj())
            {
              i = this.Yqs.getBottom();
              continue;
              if (idc()) {
                break label2039;
              }
              this.oZf = false;
              break label2039;
              ida();
              this.YqL = false;
              this.Yqx = false;
              this.mLastMotionY = 0.0F;
              this.YqM = 0.0F;
              this.YqF = false;
              if (this.Yqv != null) {
                idb();
              }
              this.YqN = 0;
              this.mActivePointerId = -1;
              this.YqP = false;
              this.YqR = 0L;
              this.YqQ = 0L;
              bool1 = false;
              break label147;
              i = paramMotionEvent.getActionIndex();
              if (i == -1) {
                break;
              }
              this.mLastMotionY = ((int)paramMotionEvent.getY(i));
              this.mActivePointerId = paramMotionEvent.getPointerId(i);
              bool1 = false;
              break label147;
              i = paramMotionEvent.getActionIndex();
              if (paramMotionEvent.getPointerId(i) == this.mActivePointerId) {
                if (i != 0) {
                  break label2344;
                }
              }
              for (i = 1;; i = 0)
              {
                this.mLastMotionY = ((int)paramMotionEvent.getY(i));
                this.mActivePointerId = paramMotionEvent.getPointerId(i);
                i = paramMotionEvent.getActionIndex();
                if (i == -1) {
                  break;
                }
                this.mLastMotionY = ((int)paramMotionEvent.getY(i));
                break;
              }
              try
              {
                boolean bool2 = super.onTouchEvent(paramMotionEvent);
                av.d("MicroMsg.PullDownListView", "super.onTouchEvent(): %b", new Object[] { Boolean.valueOf(bool2) });
                if ((this.Yqv != null) && (getChildCount() > 0))
                {
                  i = getChildAt(0).getTop();
                  av.d("MicroMsg.PullDownListView", "scrolled %s", new Object[] { Integer.valueOf(i) });
                  this.Yqv.abq(i);
                }
                AppMethodBeat.o(159445);
                return bool2;
              }
              catch (Exception paramMotionEvent)
              {
                av.printErrStackTrace("MicroMsg.PullDownListView", paramMotionEvent, "%b, %d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(j) });
                AppMethodBeat.o(159445);
                return true;
              }
            }
            label2344:
            label2349:
            i = 0;
          }
          label2480:
          i = 0;
        }
        bool1 = false;
        break label1055;
        bool1 = false;
      }
      label2497:
      i = 0;
    }
  }
  
  public void setMuteView(final View paramView)
  {
    AppMethodBeat.i(159441);
    if (paramView != null) {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(159433);
          if (PullDownListView.b(PullDownListView.this) != null)
          {
            PullDownListView.a(PullDownListView.this, -PullDownListView.b(PullDownListView.this).getWidth());
            PullDownListView.b(PullDownListView.this, PullDownListView.b(PullDownListView.this).getHeight());
            PullDownListView.b(PullDownListView.this).setVisibility(8);
          }
          paramView.bringToFront();
          AppMethodBeat.o(159433);
        }
      });
    }
    for (;;)
    {
      this.Yqt = paramView;
      AppMethodBeat.o(159441);
      return;
      this.Yqp = 0.0F;
      this.Yqq = 0.0F;
    }
  }
  
  public void setNavigationBarHeight(int paramInt)
  {
    AppMethodBeat.i(159442);
    av.i("MicroMsg.PullDownListView", "setNavigationBarHeight=%s", new Object[] { Integer.valueOf(paramInt) });
    this.Yqu = paramInt;
    AppMethodBeat.o(159442);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.tp = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.YqU = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.tq = paramOnItemSelectedListener;
  }
  
  public void setSupportOverscroll(boolean paramBoolean)
  {
    this.Yqk = paramBoolean;
  }
  
  public void setTabView(View paramView)
  {
    this.xp = paramView;
  }
  
  public void setTranslationListener(a parama)
  {
    this.YqT = parama;
  }
  
  public void setTranslationY(float paramFloat)
  {
    AppMethodBeat.i(252281);
    super.setTranslationY(paramFloat);
    if (this.YqT != null) {
      this.YqT.bO(paramFloat);
    }
    AppMethodBeat.o(252281);
  }
  
  public static abstract interface IPullDownCallback
  {
    public abstract void abo(int paramInt);
    
    public abstract void abp(int paramInt);
    
    public abstract void abq(int paramInt);
    
    public abstract void dDB();
    
    public abstract void dDC();
    
    public abstract void fqe();
    
    public abstract void fqf();
    
    public abstract void onPostClose();
    
    public abstract void onPostOpen(boolean paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract void bO(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.PullDownListView
 * JD-Core Version:    0.7.0.1
 */