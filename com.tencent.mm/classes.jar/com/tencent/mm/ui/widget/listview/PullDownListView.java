package com.tencent.mm.ui.widget.listview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
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
import com.tencent.mm.ui.bc;
import com.tencent.mm.ui.bf;
import java.util.ArrayList;
import java.util.List;

public class PullDownListView
  extends ListView
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener
{
  private boolean OBR;
  private int SQR;
  private int SQS;
  private AdapterView.OnItemLongClickListener agfp;
  private float agiA;
  private float agiB;
  private float agiC;
  private float agiD;
  public boolean agiE;
  private View agiF;
  private View agiG;
  private int agiH;
  public IPullDownCallback agiI;
  private int agiJ;
  private int agiK;
  private boolean agiL;
  private final int agiM;
  private final int agiN;
  private final int agiO;
  private View agiP;
  private float agiQ;
  private float agiR;
  private boolean agiS;
  private boolean agiT;
  private boolean agiU;
  private float agiV;
  private float agiW;
  private int agiX;
  private int agiY;
  private boolean agiZ;
  private boolean agiy;
  private boolean agiz;
  private float agja;
  private int agjb;
  private int agjc;
  private boolean agjd;
  private long agje;
  private long agjf;
  private int agjg;
  a agjh;
  private int bwk;
  private Vibrator cqQ;
  public boolean isVisible;
  private int mActivePointerId;
  private float mLastMotionY;
  private Rect mRect;
  private int pvg;
  private boolean seH;
  private AdapterView.OnItemClickListener un;
  private AdapterView.OnItemSelectedListener uo;
  private float x_down;
  private float y_down;
  private View yk;
  
  public PullDownListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159440);
    this.agiy = false;
    this.agiz = false;
    this.OBR = true;
    this.agiA = 0.05F;
    this.agiB = 0.05F;
    this.SQR = 0;
    this.SQS = 0;
    this.pvg = 0;
    this.agiC = 0.0F;
    this.agiD = 0.0F;
    this.agiE = true;
    this.mRect = new Rect();
    this.bwk = 0;
    this.agiH = 0;
    this.agiL = false;
    this.agiM = 1;
    this.agiN = 2;
    this.agiO = 200;
    this.agiQ = 0.0F;
    this.agiR = 0.0F;
    this.seH = false;
    this.isVisible = true;
    this.agiS = false;
    this.agiT = false;
    this.agiU = false;
    this.agiW = 0.0F;
    this.agiX = 0;
    this.agiY = 0;
    this.agiZ = false;
    this.agja = 0.0F;
    this.mActivePointerId = -1;
    this.agjb = 0;
    this.agjc = 0;
    this.agjd = false;
    this.agje = 0L;
    this.agjf = 0L;
    this.agjh = null;
    super.setOnItemClickListener(this);
    super.setOnItemLongClickListener(this);
    super.setOnItemSelectedListener(this);
    if (bf.bf(paramContext) != null) {
      this.pvg = bf.bf(paramContext).y;
    }
    this.cqQ = ((Vibrator)getContext().getSystemService("vibrator"));
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(159434);
        bc.d("MicroMsg.PullDownListView", "mThis.getLeft()=%s, mThis.getTop()=%s, mThis.getRight()=%s, mThis.getBottom()=%s", new Object[] { Integer.valueOf(PullDownListView.c(PullDownListView.this).getLeft()), Integer.valueOf(PullDownListView.c(PullDownListView.this).getTop()), Integer.valueOf(PullDownListView.c(PullDownListView.this).getRight()), Integer.valueOf(PullDownListView.c(PullDownListView.this).getBottom()) });
        PullDownListView.d(PullDownListView.this).set(PullDownListView.c(PullDownListView.this).getLeft(), PullDownListView.c(PullDownListView.this).getTop(), PullDownListView.c(PullDownListView.this).getRight(), PullDownListView.c(PullDownListView.this).getBottom());
        AppMethodBeat.o(159434);
      }
    });
    AppMethodBeat.o(159440);
  }
  
  private void aFm(int paramInt)
  {
    AppMethodBeat.i(252719);
    bc.i("MicroMsg.PullDownListView", "story_cat animation: %s %s %s %s %s %s %s %s start:%s, end:%s, openLimitPx():%s, closeLimitPx():%s, isMute:%s", new Object[] { Integer.valueOf(this.mRect.left), Integer.valueOf(this.mRect.top), Integer.valueOf(this.mRect.right), Integer.valueOf(this.mRect.bottom), Integer.valueOf(getLeft()), Integer.valueOf(getTop()), Integer.valueOf(getRight()), Integer.valueOf(getBottom()), Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(hDi()), Integer.valueOf(hDj()), Boolean.FALSE });
    setTranslationY(0.0F);
    if ((this.yk != null) && (paramInt > hDi()) && (paramInt < hDj())) {
      this.yk.setTranslationY(0 - this.agiH);
    }
    bc.i("MicroMsg.PullDownListView", "onImmeStart start:%s, openLimitPx():%s, closeLimitPx():%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hDi()), Integer.valueOf(hDj()) });
    this.agiS = true;
    this.isVisible = true;
    if ((this.agiI != null) && (paramInt > hDi()) && (paramInt < hDj()))
    {
      if (this.isVisible) {
        this.agiI.etM();
      }
    }
    else
    {
      bc.i("MicroMsg.PullDownListView", "onImmeEnd start:%s, openLimitPx():%s, closeLimitPx():%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hDi()), Integer.valueOf(hDj()) });
      this.seH = false;
      this.agiS = false;
      this.agiT = false;
      this.agiU = false;
      if ((this.agiI != null) && (paramInt > hDi()) && (paramInt < hDj()))
      {
        if (!this.isVisible) {
          break label413;
        }
        this.agiI.onPostClose();
        if (this.yk == null) {}
      }
    }
    for (;;)
    {
      enU();
      AppMethodBeat.o(252719);
      return;
      this.agiI.etL();
      break;
      label413:
      this.agiI.onPostOpen(false);
    }
  }
  
  private int aFn(int paramInt)
  {
    AppMethodBeat.i(159451);
    int i = (int)Math.abs(paramInt / this.pvg * this.agiX);
    bc.d("MicroMsg.PullDownListView", "offset:%s,  ((float) offset / screenHeight):%s,  Math.abs(mCoordinationAnimThreshold):%s,  result:%s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramInt / this.pvg), Integer.valueOf(Math.abs(this.agiX)), Integer.valueOf(i) });
    AppMethodBeat.o(159451);
    return i;
  }
  
  private boolean aI(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    AppMethodBeat.i(159452);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    if (this.agiG != null) {
      if ((paramMotionEvent.getActionMasked() != 1) || (this.agjf >= 200L)) {
        if (this.x_down < this.agiG.getRight()) {
          if ((f1 <= this.agiG.getLeft()) || (f1 >= this.agiG.getRight()) || (f2 <= this.agiG.getTop() - this.agiG.getHeight() / 2) || (f2 >= this.agiG.getBottom() + this.agiH)) {}
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(159452);
      return bool;
      bool = false;
      continue;
      if ((f1 <= this.agiG.getLeft()) || (f1 >= this.agiG.getRight()) || (f2 <= this.agiG.getTop()) || (f2 >= this.agiG.getBottom() + this.agiH))
      {
        bool = false;
        continue;
        bool = false;
      }
    }
  }
  
  private void aa(final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    AppMethodBeat.i(159447);
    bc.i("MicroMsg.PullDownListView", "story_cat animation: %s %s %s %s %s %s %s %s start:%s, end:%s, openLimitPx():%s, closeLimitPx():%s, isMute:%s", new Object[] { Integer.valueOf(this.mRect.left), Integer.valueOf(this.mRect.top), Integer.valueOf(this.mRect.right), Integer.valueOf(this.mRect.bottom), Integer.valueOf(getLeft()), Integer.valueOf(getTop()), Integer.valueOf(getRight()), Integer.valueOf(getBottom()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(hDi()), Integer.valueOf(hDj()), Boolean.valueOf(paramBoolean) });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ObjectAnimator.ofFloat(this, "translationY", new float[] { paramInt1, paramInt2 }));
    if ((this.yk != null) && (paramInt1 > hDi()) && (paramInt1 < hDj()))
    {
      if (paramInt2 != 0) {
        localArrayList.add(ObjectAnimator.ofFloat(this.yk, "translationY", new float[] { paramInt1, paramInt2 }));
      }
    }
    else if (this.agiP != null)
    {
      if (paramInt2 < getBottom()) {
        break label381;
      }
      localArrayList.add(oT(((ViewGroup.MarginLayoutParams)this.agiP.getLayoutParams()).topMargin, 0));
    }
    for (;;)
    {
      localAnimatorSet.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(159438);
          bc.i("MicroMsg.PullDownListView", "onAnimationEnd start:%s, openLimitPx():%s, closeLimitPx():%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(PullDownListView.e(PullDownListView.this)), Integer.valueOf(PullDownListView.f(PullDownListView.this)) });
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
          bc.i("MicroMsg.PullDownListView", "onAnimationStart start:%s, openLimitPx():%s, closeLimitPx():%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(PullDownListView.e(PullDownListView.this)), Integer.valueOf(PullDownListView.f(PullDownListView.this)) });
          PullDownListView.a(PullDownListView.this, true);
          if (paramInt2 == 0) {
            PullDownListView.b(PullDownListView.this, true);
          }
          while ((PullDownListView.g(PullDownListView.this) != null) && (paramInt1 > PullDownListView.e(PullDownListView.this)) && (paramInt1 < PullDownListView.f(PullDownListView.this))) {
            if (PullDownListView.h(PullDownListView.this))
            {
              PullDownListView.g(PullDownListView.this).etM();
              AppMethodBeat.o(159437);
              return;
              PullDownListView.b(PullDownListView.this, false);
            }
            else
            {
              PullDownListView.g(PullDownListView.this).etL();
            }
          }
          AppMethodBeat.o(159437);
        }
      });
      localAnimatorSet.playTogether(localArrayList);
      localAnimatorSet.start();
      enU();
      AppMethodBeat.o(159447);
      return;
      localArrayList.add(ObjectAnimator.ofFloat(this.yk, "translationY", new float[] { paramInt1, paramInt2 - this.agiH }));
      break;
      label381:
      localArrayList.add(oT(((ViewGroup.MarginLayoutParams)this.agiP.getLayoutParams()).topMargin, this.agiX));
    }
  }
  
  private void enU()
  {
    AppMethodBeat.i(159449);
    this.bwk = 0;
    bc.d("MicroMsg.PullDownListView", "startAnimation %s %s %s %s", new Object[] { Integer.valueOf(this.agiF.getLeft()), Integer.valueOf(this.agiF.getTop()), Integer.valueOf(this.agiF.getRight()), Integer.valueOf(this.agiF.getBottom()) });
    AppMethodBeat.o(159449);
  }
  
  private int hDi()
  {
    if (this.SQR == 0) {
      this.SQR = ((int)(this.pvg * this.agiA));
    }
    return this.SQR;
  }
  
  private int hDj()
  {
    if (this.SQS == 0) {
      this.SQS = ((int)((this.pvg - this.agiY) * (1.0F - this.agiB)));
    }
    return this.SQS;
  }
  
  private void jIn()
  {
    AppMethodBeat.i(159446);
    if (this.agiG != null)
    {
      float f1 = this.agiG.getTranslationX();
      float f2 = this.agiG.getTranslationY();
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.agiG, "translationX", new float[] { f1, this.agiC });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.agiG, "translationY", new float[] { f2, this.agiD });
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
  
  private boolean jIo()
  {
    AppMethodBeat.i(159450);
    if ((!this.mRect.isEmpty()) && (Math.abs(this.bwk) > 0))
    {
      AppMethodBeat.o(159450);
      return true;
    }
    AppMethodBeat.o(159450);
    return false;
  }
  
  private void jIp()
  {
    AppMethodBeat.i(159453);
    if (this.agiG != null) {
      this.agiG.setVisibility(8);
    }
    AppMethodBeat.o(159453);
  }
  
  private void jIq()
  {
    AppMethodBeat.i(159454);
    if (this.agiG != null)
    {
      this.agiG.setTranslationX(this.agiC);
      this.agiG.setTranslationY(this.agiD);
      this.agiG.setVisibility(8);
    }
    AppMethodBeat.o(159454);
  }
  
  private ValueAnimator oT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159455);
    bc.d("MicroMsg.PullDownListView", "startStoryGalleryOpenAnim start:%s, end:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    localValueAnimator.addUpdateListener(new PullDownListView.5(this));
    AppMethodBeat.o(159455);
    return localValueAnimator;
  }
  
  public final void G(View paramView, int paramInt1, int paramInt2)
  {
    this.agiP = paramView;
    this.agiY = paramInt1;
    this.agiX = paramInt2;
    this.SQS = 0;
    this.SQR = 0;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159444);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(159444);
    return bool;
  }
  
  public final void jIm()
  {
    this.agiz = false;
    this.OBR = true;
  }
  
  public final void jIr()
  {
    AppMethodBeat.i(159460);
    bc.i("MicroMsg.PullDownListView", "switchNormalStatus", new Object[0]);
    if (!this.isVisible)
    {
      if (this.agiz)
      {
        aa((int)(this.agiJ * (1.0F - this.agiB)), 0, false);
        AppMethodBeat.o(159460);
        return;
      }
      aa(hDj() - 1, 0, false);
    }
    AppMethodBeat.o(159460);
  }
  
  public final void jIs()
  {
    AppMethodBeat.i(252862);
    bc.i("MicroMsg.PullDownListView", "switchNormalStatusImme", new Object[0]);
    if (!this.isVisible)
    {
      if (this.agiz)
      {
        aFm((int)(this.agiJ * (1.0F - this.agiB)));
        AppMethodBeat.o(252862);
        return;
      }
      aFm(hDj() - 1);
    }
    AppMethodBeat.o(252862);
  }
  
  public final void jIt()
  {
    AppMethodBeat.i(159461);
    bc.i("MicroMsg.PullDownListView", "switchPullDownStatus", new Object[0]);
    if (this.isVisible)
    {
      if (this.agiz)
      {
        int i = this.agiJ;
        aa(hDi() + 1, i, false);
        AppMethodBeat.o(159461);
        return;
      }
      aa(hDi() + 1, this.agiF.getBottom() + this.agiH, false);
    }
    AppMethodBeat.o(159461);
  }
  
  public final void oS(int paramInt1, int paramInt2)
  {
    this.agiz = true;
    this.agiJ = paramInt1;
    this.OBR = false;
    this.agiK = paramInt2;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(159443);
    this.agiF = this;
    this.agiV = getTranslationY();
    bc.d("MicroMsg.PullDownListView", "onFinishInflate %s %s %s %s", new Object[] { Integer.valueOf(this.agiF.getLeft()), Integer.valueOf(this.agiF.getTop()), Integer.valueOf(this.agiF.getRight()), Integer.valueOf(this.agiF.getBottom()) });
    AppMethodBeat.o(159443);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(252844);
    if ((!this.isVisible) && (this.agiz) && (paramMotionEvent.getRawY() > this.agiK))
    {
      AppMethodBeat.o(252844);
      return true;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(252844);
    return bool;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(159456);
    if ((this.un != null) && (!this.seH) && ((this.isVisible) || (this.agiz)))
    {
      this.agiL = true;
      this.un.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    AppMethodBeat.o(159456);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(159459);
    if ((this.agfp != null) && ((this.isVisible) || (this.agiz)))
    {
      this.agiL = true;
      boolean bool = this.agfp.onItemLongClick(paramAdapterView, paramView, paramInt, paramLong);
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
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    a.c("com/tencent/mm/ui/widget/listview/PullDownListView", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    if ((this.uo != null) && (!this.seH) && ((this.isVisible) || (this.agiz)))
    {
      this.agiL = true;
      this.uo.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
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
    if (this.uo != null) {
      this.uo.onNothingSelected(paramAdapterView);
    }
    AppMethodBeat.o(159458);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159445);
    bc.d("MicroMsg.PullDownListView", "dancy test onTouchEvent, supportOverscroll:%s, scrollY:%s", new Object[] { Boolean.valueOf(this.agiy), Integer.valueOf(getScrollY()) });
    boolean bool1;
    if ((!this.agiy) || (this.agiF == null) || (this.agiS))
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(159445);
      return bool1;
    }
    int j = paramMotionEvent.getActionMasked();
    bc.d("MicroMsg.PullDownListView", "onTouchEvent %s", new Object[] { Integer.valueOf(j) });
    label147:
    boolean bool2;
    float f;
    label420:
    label434:
    int k;
    label489:
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
          bc.d("MicroMsg.PullDownListView", "consumed: %b", new Object[] { Boolean.valueOf(bool1) });
          if (bool1) {
            paramMotionEvent.setAction(3);
          }
          bool2 = bool1;
          if (!this.isVisible)
          {
            bool2 = bool1;
            if (this.agiz) {
              bool2 = true;
            }
          }
          if (!bool2) {
            break label2374;
          }
          AppMethodBeat.o(159445);
          return true;
          if (this.agiZ) {
            break;
          }
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          jIp();
          this.agiL = false;
          f = paramMotionEvent.getY(0);
          this.mLastMotionY = f;
          this.agiQ = f;
          this.agiR = paramMotionEvent.getX(0);
          this.mRect.setEmpty();
          this.y_down = paramMotionEvent.getY(0);
          this.x_down = paramMotionEvent.getX(0);
          this.agiW = 0.0F;
          if ((this.agiz) && (!this.isVisible)) {
            this.agiW = getTranslationY();
          }
          this.agjb = ((int)this.agiW);
          this.agiZ = true;
          this.agjd = false;
          this.agje = System.currentTimeMillis();
          this.agjf = 0L;
          jIq();
        }
        this.seH = true;
        if (!this.agiZ)
        {
          if (this.isVisible) {
            break label1472;
          }
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          this.mLastMotionY = paramMotionEvent.getY(0);
          this.y_down = paramMotionEvent.getY(0);
          if (!this.agiz) {
            break;
          }
          this.agiW = this.agjg;
          this.agjb = ((int)this.agiW);
          this.agiZ = true;
        }
        k = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      } while (k == -1);
      this.agiQ = paramMotionEvent.getY(k);
      this.agiR = paramMotionEvent.getX(k);
      if (this.agiQ - this.y_down >= 0.0F)
      {
        this.agjc = 2;
        i = getChildCount();
        if ((i <= 0) || (!this.isVisible)) {
          break label2522;
        }
        if (this.agjc != 2) {
          break label1579;
        }
        if (getChildAt(0).getTop() >= getPaddingTop() + 0) {
          break label1574;
        }
        i = 1;
      }
      break;
    }
    for (;;)
    {
      label532:
      if (i != 0) {
        this.agjd = true;
      }
      label1080:
      ViewGroup.MarginLayoutParams localMarginLayoutParams;
      if (!this.agjd)
      {
        bc.d("MicroMsg.PullDownListView", "rawY:%s, rawX:%s, indexY:%s, indexX:%s", new Object[] { Float.valueOf(paramMotionEvent.getRawY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getY(k)), Float.valueOf(paramMotionEvent.getX(k)) });
        bc.d("MicroMsg.PullDownListView", "move deltaY:%s, isAnima:%s, mDeltaY:%s, mIsIgnoreCallBack:%s translateBaseY:%s", new Object[] { Integer.valueOf((int)(this.mLastMotionY - this.agiQ)), Boolean.valueOf(this.agiS), Integer.valueOf(this.bwk), Boolean.valueOf(this.agiL), Float.valueOf(this.agiW) });
        if ((!this.agiL) && (!this.agiS))
        {
          if (this.mRect.isEmpty())
          {
            this.agiV = getTranslationY();
            this.mRect.set(this.agiF.getLeft(), this.agiF.getTop(), this.agiF.getRight(), this.agiF.getBottom());
            bc.d("MicroMsg.PullDownListView", "mRect.isEmpty() %s %s %s %s", new Object[] { Integer.valueOf(this.agiF.getLeft()), Integer.valueOf(this.agiF.getTop()), Integer.valueOf(this.agiF.getRight()), Integer.valueOf(this.agiF.getBottom()) });
          }
          bc.d("MicroMsg.PullDownListView", "eventIndex:%s, ev.getY():%s, y_down:%s, ev.getY()-y_down:%s", new Object[] { Integer.valueOf(k), Float.valueOf(paramMotionEvent.getY(k)), Float.valueOf(this.y_down), Float.valueOf(paramMotionEvent.getY(k) - this.y_down) });
          this.agjb += (int)((int)(this.agiQ - this.mLastMotionY) / 2.0F);
          this.bwk = Math.max(0, this.agjb);
          bc.d("MicroMsg.PullDownListView", "top %s, bottom:%s, mDeltaY %s, deltaOverScrollY:%s", new Object[] { Integer.valueOf(this.agiF.getTop()), Integer.valueOf(this.agiF.getBottom()), Integer.valueOf(this.bwk), Integer.valueOf(this.agjb) });
          if (Math.abs(this.agjb) > 50)
          {
            if ((!this.agiT) && (this.bwk >= hDi()) && (this.bwk <= hDj()))
            {
              if (this.OBR) {
                this.cqQ.vibrate(10L);
              }
              this.agiT = true;
              this.agja = this.agjb;
            }
            bc.d("MicroMsg.PullDownListView", "OverScroll top %s, mIsIgnoreCallBack:%s, isVisible:%s", new Object[] { Integer.valueOf(this.mRect.top + this.bwk), Boolean.valueOf(this.agiL), Boolean.valueOf(this.isVisible) });
            bool1 = true;
            this.agiF.setTranslationY(this.bwk);
            if (this.isVisible)
            {
              i = aFn(Math.max(this.bwk - (int)this.agiW, 0));
              if (this.agiP != null)
              {
                localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.agiP.getLayoutParams();
                localMarginLayoutParams.topMargin = Math.max(this.agiX, Math.min(0, i + this.agiX));
                bc.d("MicroMsg.PullDownListView", "openingCoordinationView params.bottomMargin:%s", new Object[] { Integer.valueOf(localMarginLayoutParams.bottomMargin) });
                this.agiP.setLayoutParams(localMarginLayoutParams);
              }
              if (this.agiI != null) {
                this.agiI.afI(aFn(Math.max(this.bwk - hDi() - (int)this.agiW, 0)));
              }
              label1230:
              if (this.agja != 0.0F)
              {
                i = (int)((int)(this.agjb - this.agja) * 3.0F);
                if ((!this.isVisible) || (i <= 0) || (this.agiI == null)) {
                  break label1771;
                }
                f = i;
                if (this.agiG != null)
                {
                  this.agiG.setTranslationX(Math.min(this.agiC + f, 0.0F));
                  this.agiG.setTranslationY(Math.max(this.agiD - f, 0.0F));
                  this.agiG.setVisibility(0);
                }
                if ((this.agiU) || (!aI(paramMotionEvent))) {
                  break label1743;
                }
                if (this.OBR) {
                  this.cqQ.vibrate(20L);
                }
                this.agiU = true;
                label1364:
                if (!this.agiU) {
                  break label1759;
                }
                this.agiI.gBu();
              }
              label1380:
              bc.d("MicroMsg.PullDownListView", "mThis.layout %s %s %s %s", new Object[] { Integer.valueOf(this.agiF.getLeft()), Integer.valueOf(this.agiF.getTop()), Integer.valueOf(this.agiF.getRight()), Integer.valueOf(this.agiF.getBottom()) });
            }
          }
        }
      }
      for (;;)
      {
        this.mLastMotionY = this.agiQ;
        break label147;
        this.agiW = (this.pvg - this.agiY);
        break label420;
        label1472:
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        jIp();
        this.agiL = false;
        f = paramMotionEvent.getY(0);
        this.mLastMotionY = f;
        this.agiQ = f;
        this.agiR = paramMotionEvent.getX(0);
        this.mRect.setEmpty();
        this.y_down = paramMotionEvent.getY(0);
        this.x_down = paramMotionEvent.getX(0);
        this.agiW = 0.0F;
        this.agjb = ((int)this.agiW);
        this.agiZ = true;
        jIq();
        break label434;
        this.agjc = 1;
        break label489;
        label1574:
        i = 0;
        break label532;
        label1579:
        if (this.agjc != 1) {
          break label2522;
        }
        if (getChildAt(i - 1).getBottom() >= getHeight() - getPaddingBottom())
        {
          i = 1;
          break label532;
        }
        i = 0;
        break label532;
        i = aFn(Math.max((int)this.agiW - this.bwk, 0));
        if (this.agiP != null)
        {
          localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.agiP.getLayoutParams();
          localMarginLayoutParams.topMargin = Math.min(0, Math.max(this.agiX, -i));
          bc.d("MicroMsg.PullDownListView", "closingCoordinationView params.bottomMargin:%s", new Object[] { Integer.valueOf(localMarginLayoutParams.bottomMargin) });
          this.agiP.setLayoutParams(localMarginLayoutParams);
        }
        if (this.agiI == null) {
          break label1230;
        }
        this.agiI.afJ(aFn(Math.max(hDj() - this.bwk, 0)));
        break label1230;
        label1743:
        if (aI(paramMotionEvent)) {
          break label1364;
        }
        this.agiU = false;
        break label1364;
        label1759:
        this.agiI.gBv();
        break label1380;
        label1771:
        jIp();
        break label1380;
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        if (i == -1) {
          break;
        }
        this.agiQ = paramMotionEvent.getY(i);
        this.agiR = paramMotionEvent.getX(i);
        jIn();
        this.mLastMotionY = 0.0F;
        this.agja = 0.0F;
        this.agiT = false;
        this.agjf = (System.currentTimeMillis() - this.agje);
        bc.d("MicroMsg.PullDownListView", "dancy test action up, mDeltaY:%s, closeLimitPx:%s, bottom:%s, mPullDownDuration%s", new Object[] { Integer.valueOf(this.bwk), Integer.valueOf(hDj()), Integer.valueOf(this.agiF.getBottom()), Long.valueOf(this.agjf) });
        if ((jIo()) && (this.agiI != null) && (!this.agiS) && (this.agiE) && (!this.agjd))
        {
          bc.d("MicroMsg.PullDownListView", "dancy test action up, deltaOverScrollY:%s, translateBaseY:%s", new Object[] { Integer.valueOf(this.agjb), Float.valueOf(this.agiW) });
          if (this.agjb - this.agiW > 0.0F)
          {
            i = 1;
            label1980:
            if (i == 0) {
              break label2110;
            }
            if (((!this.isVisible) || (this.bwk < hDi())) && ((this.isVisible) || (this.bwk < hDj()))) {
              break label2505;
            }
            i = this.agiF.getBottom() + this.agiH;
            if (this.agiz)
            {
              i = this.agiJ;
              this.agjg = i;
            }
          }
        }
        for (;;)
        {
          aa(this.bwk, i, aI(paramMotionEvent));
          label2064:
          this.agiL = false;
          this.agiZ = false;
          this.agjb = 0;
          this.mActivePointerId = -1;
          this.agjd = false;
          this.agjf = 0L;
          this.agje = 0L;
          bool1 = false;
          break label147;
          i = 0;
          break label1980;
          label2110:
          if (this.agjb - this.agiW < 0.0F)
          {
            i = 1;
            label2127:
            if (i == 0) {
              break label2156;
            }
            if (this.bwk >= 0) {
              break label2158;
            }
            i = 0;
          }
          for (;;)
          {
            aa(this.bwk, i, false);
            break label2064;
            i = 0;
            break label2127;
            label2156:
            break label2064;
            label2158:
            if (this.bwk >= hDj())
            {
              i = this.agiF.getBottom();
              continue;
              if (jIo()) {
                break label2064;
              }
              this.seH = false;
              break label2064;
              jIn();
              this.agiZ = false;
              this.agiL = false;
              this.mLastMotionY = 0.0F;
              this.agja = 0.0F;
              this.agiT = false;
              if (this.agiI != null) {
                enU();
              }
              this.agjb = 0;
              this.mActivePointerId = -1;
              this.agjd = false;
              this.agjf = 0L;
              this.agje = 0L;
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
                  break label2369;
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
                bool1 = super.onTouchEvent(paramMotionEvent);
                bc.d("MicroMsg.PullDownListView", "super.onTouchEvent(): %b", new Object[] { Boolean.valueOf(bool1) });
                if ((this.agiI != null) && (getChildCount() > 0))
                {
                  i = getChildAt(0).getTop();
                  bc.d("MicroMsg.PullDownListView", "scrolled %s", new Object[] { Integer.valueOf(i) });
                  this.agiI.afK(i);
                }
                AppMethodBeat.o(159445);
                return bool1;
              }
              catch (Exception paramMotionEvent)
              {
                bc.printErrStackTrace("MicroMsg.PullDownListView", paramMotionEvent, "%b, %d", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(j) });
                AppMethodBeat.o(159445);
                return true;
              }
            }
            label2369:
            label2374:
            i = 0;
          }
          label2505:
          i = 0;
        }
        bool1 = false;
        break label1080;
        bool1 = false;
      }
      label2522:
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
      this.agiG = paramView;
      AppMethodBeat.o(159441);
      return;
      this.agiC = 0.0F;
      this.agiD = 0.0F;
    }
  }
  
  public void setNavigationBarHeight(int paramInt)
  {
    AppMethodBeat.i(159442);
    bc.i("MicroMsg.PullDownListView", "setNavigationBarHeight=%s", new Object[] { Integer.valueOf(paramInt) });
    this.agiH = paramInt;
    AppMethodBeat.o(159442);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.un = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.agfp = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.uo = paramOnItemSelectedListener;
  }
  
  public void setSupportOverscroll(boolean paramBoolean)
  {
    this.agiy = paramBoolean;
  }
  
  public void setTabView(View paramView)
  {
    this.yk = paramView;
  }
  
  public void setTranslationListener(a parama)
  {
    this.agjh = parama;
  }
  
  public void setTranslationY(float paramFloat)
  {
    AppMethodBeat.i(252832);
    super.setTranslationY(paramFloat);
    if (this.agjh != null) {
      this.agjh.cS(paramFloat);
    }
    AppMethodBeat.o(252832);
  }
  
  public static abstract interface IPullDownCallback
  {
    public abstract void afI(int paramInt);
    
    public abstract void afJ(int paramInt);
    
    public abstract void afK(int paramInt);
    
    public abstract void etL();
    
    public abstract void etM();
    
    public abstract void gBu();
    
    public abstract void gBv();
    
    public abstract void onPostClose();
    
    public abstract void onPostOpen(boolean paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract void cS(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.PullDownListView
 * JD-Core Version:    0.7.0.1
 */