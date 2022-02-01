package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DynamicGridView
  extends WrappingGridView
{
  float Mlj;
  float Mlk;
  private int QVY;
  private int QVZ;
  private boolean RTA;
  private List<ObjectAnimator> RTB;
  boolean RTC;
  boolean RTD;
  boolean RTE;
  private boolean RTF;
  private AbsListView.OnScrollListener RTG;
  private f RTH;
  private e RTI;
  private g RTJ;
  private AdapterView.OnItemClickListener RTK;
  private AdapterView.OnItemClickListener RTM;
  private boolean RTN;
  private Stack<DynamicGridView.a> RTO;
  private DynamicGridView.a RTP;
  private h RTQ;
  private View RTR;
  d RTS;
  int RTT;
  private float RTU;
  private float RTV;
  private AbsListView.OnScrollListener RTW;
  private BitmapDrawable RTn;
  private Rect RTo;
  private Rect RTp;
  private Rect RTq;
  private int RTr;
  private int RTs;
  private int RTt;
  private int RTu;
  private int RTv;
  private long RTw;
  private boolean RTx;
  private boolean RTy;
  private int RTz;
  private List<Long> idList;
  private int mActivePointerId;
  private int mScrollState;
  boolean yAG;
  
  public DynamicGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100329);
    this.RTr = 0;
    this.RTs = 0;
    this.QVY = -1;
    this.QVZ = -1;
    this.RTt = -1;
    this.RTu = -1;
    this.idList = new ArrayList();
    this.RTw = -1L;
    this.RTx = false;
    this.mActivePointerId = -1;
    this.RTz = 0;
    this.RTA = false;
    this.mScrollState = 0;
    this.yAG = false;
    this.RTB = new LinkedList();
    this.RTE = true;
    this.RTF = true;
    this.RTM = new DynamicGridView.1(this);
    this.RTS = new d((byte)0);
    this.RTT = -1;
    this.RTW = new AbsListView.OnScrollListener()
    {
      private int RTY = -1;
      private int RTZ = -1;
      private int RUa;
      private int RUb;
      private int lBb;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(100306);
        this.RUa = paramAnonymousInt1;
        this.RUb = paramAnonymousInt2;
        int i;
        label49:
        label212:
        View localView;
        if (this.RTY == -1)
        {
          i = this.RUa;
          this.RTY = i;
          if (this.RTZ != -1) {
            break label307;
          }
          i = this.RUb;
          this.RTZ = i;
          if ((this.RUa != this.RTY) && (DynamicGridView.i(DynamicGridView.this)) && (DynamicGridView.f(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.f(DynamicGridView.this));
            DynamicGridView.n(DynamicGridView.this);
          }
          if ((this.RUa + this.RUb != this.RTY + this.RTZ) && (DynamicGridView.i(DynamicGridView.this)) && (DynamicGridView.f(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.f(DynamicGridView.this));
            DynamicGridView.n(DynamicGridView.this);
          }
          this.RTY = this.RUa;
          this.RTZ = this.RUb;
          if ((!DynamicGridView.hsd()) || (!DynamicGridView.g(DynamicGridView.this))) {
            break label372;
          }
          i = 0;
          if (i >= paramAnonymousInt2) {
            break label372;
          }
          localView = DynamicGridView.this.getChildAt(i);
          if (localView != null)
          {
            if ((DynamicGridView.f(DynamicGridView.this) == -1L) || (Boolean.TRUE == localView.getTag(b.f.dgv_wobble_tag))) {
              break label328;
            }
            if (i % 2 != 0) {
              break label316;
            }
            DynamicGridView.c(DynamicGridView.this, localView);
            label278:
            localView.setTag(b.f.dgv_wobble_tag, Boolean.TRUE);
          }
        }
        for (;;)
        {
          i += 1;
          break label212;
          i = this.RTY;
          break;
          label307:
          i = this.RTZ;
          break label49;
          label316:
          DynamicGridView.d(DynamicGridView.this, localView);
          break label278;
          label328:
          if ((DynamicGridView.f(DynamicGridView.this) == -1L) && (localView.getRotation() != 0.0F))
          {
            localView.setRotation(0.0F);
            localView.setTag(b.f.dgv_wobble_tag, Boolean.FALSE);
          }
        }
        label372:
        if (DynamicGridView.h(DynamicGridView.this) != null) {
          DynamicGridView.h(DynamicGridView.this).onScroll(paramAnonymousAbsListView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(100306);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(100307);
        this.lBb = paramAnonymousInt;
        DynamicGridView.c(DynamicGridView.this, paramAnonymousInt);
        if ((this.RUb > 0) && (this.lBb == 0))
        {
          if ((!DynamicGridView.i(DynamicGridView.this)) || (!DynamicGridView.j(DynamicGridView.this))) {
            break label90;
          }
          DynamicGridView.k(DynamicGridView.this);
        }
        for (;;)
        {
          if (DynamicGridView.h(DynamicGridView.this) != null) {
            DynamicGridView.h(DynamicGridView.this).onScrollStateChanged(paramAnonymousAbsListView, paramAnonymousInt);
          }
          AppMethodBeat.o(100307);
          return;
          label90:
          if (DynamicGridView.l(DynamicGridView.this)) {
            DynamicGridView.m(DynamicGridView.this);
          }
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(100329);
  }
  
  public DynamicGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100330);
    this.RTr = 0;
    this.RTs = 0;
    this.QVY = -1;
    this.QVZ = -1;
    this.RTt = -1;
    this.RTu = -1;
    this.idList = new ArrayList();
    this.RTw = -1L;
    this.RTx = false;
    this.mActivePointerId = -1;
    this.RTz = 0;
    this.RTA = false;
    this.mScrollState = 0;
    this.yAG = false;
    this.RTB = new LinkedList();
    this.RTE = true;
    this.RTF = true;
    this.RTM = new DynamicGridView.1(this);
    this.RTS = new d((byte)0);
    this.RTT = -1;
    this.RTW = new AbsListView.OnScrollListener()
    {
      private int RTY = -1;
      private int RTZ = -1;
      private int RUa;
      private int RUb;
      private int lBb;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(100306);
        this.RUa = paramAnonymousInt1;
        this.RUb = paramAnonymousInt2;
        int i;
        label49:
        label212:
        View localView;
        if (this.RTY == -1)
        {
          i = this.RUa;
          this.RTY = i;
          if (this.RTZ != -1) {
            break label307;
          }
          i = this.RUb;
          this.RTZ = i;
          if ((this.RUa != this.RTY) && (DynamicGridView.i(DynamicGridView.this)) && (DynamicGridView.f(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.f(DynamicGridView.this));
            DynamicGridView.n(DynamicGridView.this);
          }
          if ((this.RUa + this.RUb != this.RTY + this.RTZ) && (DynamicGridView.i(DynamicGridView.this)) && (DynamicGridView.f(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.f(DynamicGridView.this));
            DynamicGridView.n(DynamicGridView.this);
          }
          this.RTY = this.RUa;
          this.RTZ = this.RUb;
          if ((!DynamicGridView.hsd()) || (!DynamicGridView.g(DynamicGridView.this))) {
            break label372;
          }
          i = 0;
          if (i >= paramAnonymousInt2) {
            break label372;
          }
          localView = DynamicGridView.this.getChildAt(i);
          if (localView != null)
          {
            if ((DynamicGridView.f(DynamicGridView.this) == -1L) || (Boolean.TRUE == localView.getTag(b.f.dgv_wobble_tag))) {
              break label328;
            }
            if (i % 2 != 0) {
              break label316;
            }
            DynamicGridView.c(DynamicGridView.this, localView);
            label278:
            localView.setTag(b.f.dgv_wobble_tag, Boolean.TRUE);
          }
        }
        for (;;)
        {
          i += 1;
          break label212;
          i = this.RTY;
          break;
          label307:
          i = this.RTZ;
          break label49;
          label316:
          DynamicGridView.d(DynamicGridView.this, localView);
          break label278;
          label328:
          if ((DynamicGridView.f(DynamicGridView.this) == -1L) && (localView.getRotation() != 0.0F))
          {
            localView.setRotation(0.0F);
            localView.setTag(b.f.dgv_wobble_tag, Boolean.FALSE);
          }
        }
        label372:
        if (DynamicGridView.h(DynamicGridView.this) != null) {
          DynamicGridView.h(DynamicGridView.this).onScroll(paramAnonymousAbsListView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(100306);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(100307);
        this.lBb = paramAnonymousInt;
        DynamicGridView.c(DynamicGridView.this, paramAnonymousInt);
        if ((this.RUb > 0) && (this.lBb == 0))
        {
          if ((!DynamicGridView.i(DynamicGridView.this)) || (!DynamicGridView.j(DynamicGridView.this))) {
            break label90;
          }
          DynamicGridView.k(DynamicGridView.this);
        }
        for (;;)
        {
          if (DynamicGridView.h(DynamicGridView.this) != null) {
            DynamicGridView.h(DynamicGridView.this).onScrollStateChanged(paramAnonymousAbsListView, paramAnonymousInt);
          }
          AppMethodBeat.o(100307);
          return;
          label90:
          if (DynamicGridView.l(DynamicGridView.this)) {
            DynamicGridView.m(DynamicGridView.this);
          }
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(100330);
  }
  
  private boolean E(Rect paramRect)
  {
    AppMethodBeat.i(100352);
    int i = computeVerticalScrollOffset();
    int j = getHeight();
    int k = computeVerticalScrollExtent();
    int m = computeVerticalScrollRange();
    int n = paramRect.top;
    int i1 = paramRect.height();
    if ((n <= 0) && (i > 0))
    {
      smoothScrollBy(-this.RTz, 0);
      AppMethodBeat.o(100352);
      return true;
    }
    if ((n + i1 >= j) && (i + k < m))
    {
      smoothScrollBy(this.RTz, 0);
      AppMethodBeat.o(100352);
      return true;
    }
    AppMethodBeat.o(100352);
    return false;
  }
  
  private boolean amH(int paramInt)
  {
    AppMethodBeat.i(100350);
    if (!getAdapterInterface().amC(paramInt))
    {
      AppMethodBeat.o(100350);
      return false;
    }
    this.RTr = 0;
    this.RTs = 0;
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null)
    {
      this.RTw = getAdapter().getItemId(paramInt);
      this.RTn = jW(localView);
      hrY();
      if (hrZ()) {
        localView.setVisibility(4);
      }
      vB(this.RTw);
      if (this.RTI != null) {
        this.RTI.adZ(paramInt);
      }
      AppMethodBeat.o(100350);
      return true;
    }
    AppMethodBeat.o(100350);
    return false;
  }
  
  private long amI(int paramInt)
  {
    AppMethodBeat.i(100361);
    long l = getAdapter().getItemId(paramInt);
    AppMethodBeat.o(100361);
    return l;
  }
  
  private d getAdapterInterface()
  {
    AppMethodBeat.i(100342);
    d locald = (d)getAdapter();
    AppMethodBeat.o(100342);
    return locald;
  }
  
  private int getColumnCount()
  {
    AppMethodBeat.i(100341);
    int i = getAdapterInterface().getColumnCount();
    AppMethodBeat.o(100341);
    return i;
  }
  
  private static AnimatorSet h(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(100362);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { paramFloat1, 0.0F });
    paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramFloat2, 0.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, paramView });
    AppMethodBeat.o(100362);
    return localAnimatorSet;
  }
  
  private void hrU()
  {
    AppMethodBeat.i(100334);
    int i = 0;
    if (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView != null) && (Boolean.TRUE != localView.getTag(b.f.dgv_wobble_tag)))
      {
        if (i % 2 != 0) {
          break label67;
        }
        jT(localView);
      }
      for (;;)
      {
        localView.setTag(b.f.dgv_wobble_tag, Boolean.TRUE);
        i += 1;
        break;
        label67:
        jU(localView);
      }
    }
    AppMethodBeat.o(100334);
  }
  
  private boolean hrV()
  {
    AppMethodBeat.i(100349);
    int i = vC(this.RTw);
    if (i != -1)
    {
      this.RTI.amF(i);
      if (this.RTR == null)
      {
        AppMethodBeat.o(100349);
        return false;
      }
    }
    else
    {
      AppMethodBeat.o(100349);
      return false;
    }
    int j;
    try
    {
      i = getPositionForView(this.RTR);
      j = getChildCount() - 1;
      new StringBuilder("switch ").append(i).append(",").append(j);
      if (i == -1)
      {
        AppMethodBeat.o(100349);
        return false;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        new StringBuilder("NullPointerException: ").append(localNullPointerException.getMessage());
        i = -1;
      }
      lQ(i, j);
      if (this.RTN) {
        this.RTP.lR(i, j);
      }
      this.QVZ = this.RTt;
      this.QVY = this.RTu;
      if (!hrZ()) {
        break label216;
      }
    }
    Object localObject;
    if (hsa()) {
      localObject = new b(0, 0);
    }
    for (;;)
    {
      vB(this.RTw);
      ((j)localObject).lS(i, j);
      AppMethodBeat.o(100349);
      return true;
      label216:
      if (hsa()) {
        localObject = new i(0, 0);
      } else {
        localObject = new c(0, 0);
      }
    }
  }
  
  private void hrW()
  {
    AppMethodBeat.i(100351);
    this.RTy = E(this.RTo);
    AppMethodBeat.o(100351);
  }
  
  private void hrX()
  {
    AppMethodBeat.i(100354);
    this.RTS.removeMessages(1);
    View localView = vD(this.RTw);
    Rect localRect;
    if (this.RTo != null)
    {
      localRect = new Rect(this.RTo);
      localRect.offset(0, this.RTo.height() >>> 1);
    }
    for (;;)
    {
      if ((this.RTI != null) && (this.RTI.D(localRect)) && (hrV()))
      {
        this.RTn = null;
        hsb();
        if (this.RTH != null) {
          this.RTH.hrT();
        }
      }
      for (;;)
      {
        if (this.RTI != null) {
          this.RTI.hrS();
        }
        AppMethodBeat.o(100354);
        return;
        if ((localView != null) && ((this.RTx) || (this.RTA)))
        {
          this.RTx = false;
          this.RTA = false;
          this.RTy = false;
          this.mActivePointerId = -1;
          this.RTo.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          new StringBuilder("animating to  ").append(this.RTo);
          if (Build.VERSION.SDK_INT > 11)
          {
            jX(localView);
          }
          else
          {
            this.RTn.setBounds(this.RTo);
            invalidate();
            jY(localView);
          }
        }
        else
        {
          hsb();
        }
      }
      localRect = null;
    }
  }
  
  private void hrY()
  {
    AppMethodBeat.i(100355);
    Object localObject = new TypeEvaluator()
    {
      private static int h(int paramAnonymousInt1, int paramAnonymousInt2, float paramAnonymousFloat)
      {
        return (int)(paramAnonymousInt1 + (paramAnonymousInt2 - paramAnonymousInt1) * paramAnonymousFloat);
      }
    };
    localObject = ObjectAnimator.ofObject(this.RTn, "bounds", (TypeEvaluator)localObject, new Object[] { this.RTo });
    ((ObjectAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(100310);
        DynamicGridView.this.invalidate();
        AppMethodBeat.o(100310);
      }
    });
    ((ObjectAnimator)localObject).addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(100312);
        DynamicGridView.a(DynamicGridView.this, false);
        DynamicGridView.b(DynamicGridView.this);
        AppMethodBeat.o(100312);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(100311);
        DynamicGridView.a(DynamicGridView.this, true);
        DynamicGridView.b(DynamicGridView.this);
        AppMethodBeat.o(100311);
      }
    });
    ((ObjectAnimator)localObject).setDuration(10L);
    ((ObjectAnimator)localObject).start();
    AppMethodBeat.o(100355);
  }
  
  static boolean hrZ()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  private static boolean hsa()
  {
    return Build.VERSION.SDK_INT < 21;
  }
  
  private void hsb()
  {
    AppMethodBeat.i(100358);
    View localView = vD(this.RTw);
    if (localView == null)
    {
      AppMethodBeat.o(100358);
      return;
    }
    if (this.RTx) {
      jY(localView);
    }
    this.RTx = false;
    this.RTy = false;
    this.mActivePointerId = -1;
    AppMethodBeat.o(100358);
  }
  
  private void hsc()
  {
    AppMethodBeat.i(100359);
    int j = this.RTt - this.QVZ;
    int k = this.RTu - this.QVY;
    int m = this.RTp.centerY() + this.RTr + j;
    int n = this.RTp.centerX() + this.RTs + k;
    this.RTR = vD(this.RTw);
    if (this.RTR == null)
    {
      AppMethodBeat.o(100359);
      return;
    }
    Object localObject = null;
    float f2 = 0.0F;
    float f1 = 0.0F;
    Point localPoint1 = jZ(this.RTR);
    Iterator localIterator = this.idList.iterator();
    int i;
    if (localIterator.hasNext())
    {
      View localView = vD(((Long)localIterator.next()).longValue());
      if (localView == null) {
        break label913;
      }
      Point localPoint2 = jZ(localView);
      if ((localPoint2.y < localPoint1.y) && (localPoint2.x > localPoint1.x))
      {
        i = 1;
        label187:
        label349:
        if ((i == 0) || (m >= localView.getBottom()) || (n <= localView.getLeft()))
        {
          if ((localPoint2.y >= localPoint1.y) || (localPoint2.x >= localPoint1.x)) {
            break label636;
          }
          i = 1;
          label241:
          if ((i == 0) || (m >= localView.getBottom()) || (n >= localView.getRight()))
          {
            if ((localPoint2.y <= localPoint1.y) || (localPoint2.x <= localPoint1.x)) {
              break label642;
            }
            i = 1;
            if ((i == 0) || (m <= localView.getTop()) || (n <= localView.getLeft()))
            {
              if ((localPoint2.y <= localPoint1.y) || (localPoint2.x >= localPoint1.x)) {
                break label648;
              }
              i = 1;
              if ((i == 0) || (m <= localView.getTop()) || (n >= localView.getRight()))
              {
                if ((localPoint2.y >= localPoint1.y) || (localPoint2.x != localPoint1.x)) {
                  break label654;
                }
                i = 1;
                if ((i == 0) || (m >= localView.getBottom() - this.RTv))
                {
                  if ((localPoint2.y <= localPoint1.y) || (localPoint2.x != localPoint1.x)) {
                    break label660;
                  }
                  i = 1;
                  if ((i == 0) || (m <= localView.getTop() + this.RTv))
                  {
                    if ((localPoint2.y != localPoint1.y) || (localPoint2.x <= localPoint1.x)) {
                      break label666;
                    }
                    i = 1;
                    label501:
                    if ((i == 0) || (n <= localView.getLeft() + this.RTv))
                    {
                      if ((localPoint2.y != localPoint1.y) || (localPoint2.x >= localPoint1.x)) {
                        break label672;
                      }
                      i = 1;
                      if ((i == 0) || (n >= localView.getRight() - this.RTv)) {
                        break label913;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        label295:
        label452:
        float f4 = Math.abs(f.jR(localView) - f.jR(this.RTR));
        label403:
        label550:
        float f3 = Math.abs(f.jS(localView) - f.jS(this.RTR));
        if ((f4 < f2) || (f3 < f1)) {
          break label913;
        }
        f2 = f4;
        localObject = localView;
        f1 = f3;
      }
    }
    label642:
    label648:
    label654:
    label913:
    for (;;)
    {
      break;
      i = 0;
      break label187;
      label636:
      i = 0;
      break label241;
      i = 0;
      break label295;
      i = 0;
      break label349;
      i = 0;
      break label403;
      label660:
      i = 0;
      break label452;
      label666:
      i = 0;
      break label501;
      label672:
      i = 0;
      break label550;
      if (localObject != null)
      {
        i = getPositionForView(this.RTR);
        m = getPositionForView((View)localObject);
        new StringBuilder("switch ").append(i).append(",").append(m);
        localObject = getAdapterInterface();
        if ((m == -1) || (!((d)localObject).amD(i)) || (!((d)localObject).amD(m)))
        {
          vB(this.RTw);
          AppMethodBeat.o(100359);
          return;
        }
        lQ(i, m);
        if (this.RTN) {
          this.RTP.lR(i, m);
        }
        this.QVZ = this.RTt;
        this.QVY = this.RTu;
        if ((!hrZ()) || (!hsa())) {
          break label873;
        }
        localObject = new b(k, j);
      }
      for (;;)
      {
        vB(this.RTw);
        ((j)localObject).lS(i, m);
        AppMethodBeat.o(100359);
        return;
        label873:
        if (hsa()) {
          localObject = new i(k, j);
        } else {
          localObject = new c(k, j);
        }
      }
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(100336);
    super.setOnScrollListener(this.RTW);
    this.RTz = ((int)(paramContext.getResources().getDisplayMetrics().density * 8.0F + 0.5F));
    this.RTv = getResources().getDimensionPixelSize(b.d.dgv_overlap_if_switch_straight_line);
    AppMethodBeat.o(100336);
  }
  
  private void jT(View paramView)
  {
    AppMethodBeat.i(100337);
    paramView = jV(paramView);
    paramView.setFloatValues(new float[] { -2.0F, 2.0F });
    paramView.start();
    this.RTB.add(paramView);
    AppMethodBeat.o(100337);
  }
  
  private void jU(View paramView)
  {
    AppMethodBeat.i(100338);
    paramView = jV(paramView);
    paramView.setFloatValues(new float[] { 2.0F, -2.0F });
    paramView.start();
    this.RTB.add(paramView);
    AppMethodBeat.o(100338);
  }
  
  private ObjectAnimator jV(final View paramView)
  {
    AppMethodBeat.i(100339);
    if (!hsa()) {
      paramView.setLayerType(1, null);
    }
    ObjectAnimator localObjectAnimator = new ObjectAnimator();
    localObjectAnimator.setDuration(180L);
    localObjectAnimator.setRepeatMode(2);
    localObjectAnimator.setRepeatCount(-1);
    localObjectAnimator.setPropertyName("rotation");
    localObjectAnimator.setTarget(paramView);
    localObjectAnimator.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(100308);
        paramView.setLayerType(0, null);
        AppMethodBeat.o(100308);
      }
    });
    AppMethodBeat.o(100339);
    return localObjectAnimator;
  }
  
  private BitmapDrawable jW(View paramView)
  {
    AppMethodBeat.i(100343);
    int j = paramView.getWidth();
    int i = paramView.getHeight();
    int k = paramView.getTop();
    int m = paramView.getLeft();
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas(localBitmap));
    paramView = new BitmapDrawable(getResources(), localBitmap);
    this.RTp = new Rect(m, k, m + j, k + i);
    k = this.RTp.left;
    m = (int)(j * 0.05F);
    int n = this.RTp.top;
    int i1 = (int)(i * 0.05F);
    int i2 = this.RTp.right;
    j = (int)(j * 0.05F);
    int i3 = this.RTp.bottom;
    this.RTo = new Rect(k - m, n - i1, j + i2, (int)(i * 0.05F) + i3);
    this.RTq = new Rect(this.RTo);
    paramView.setBounds(this.RTp);
    AppMethodBeat.o(100343);
    return paramView;
  }
  
  private void jX(final View paramView)
  {
    AppMethodBeat.i(100356);
    Object localObject = new TypeEvaluator()
    {
      private static int h(int paramAnonymousInt1, int paramAnonymousInt2, float paramAnonymousFloat)
      {
        return (int)(paramAnonymousInt1 + (paramAnonymousInt2 - paramAnonymousInt1) * paramAnonymousFloat);
      }
    };
    localObject = ObjectAnimator.ofObject(this.RTn, "bounds", (TypeEvaluator)localObject, new Object[] { this.RTo });
    ((ObjectAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(100314);
        DynamicGridView.this.invalidate();
        AppMethodBeat.o(100314);
      }
    });
    ((ObjectAnimator)localObject).addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(100316);
        DynamicGridView.a(DynamicGridView.this, false);
        DynamicGridView.b(DynamicGridView.this);
        if ((DynamicGridView.c(DynamicGridView.this) != null) && (DynamicGridView.d(DynamicGridView.this) != null)) {
          DynamicGridView.d(DynamicGridView.this).hrT();
        }
        DynamicGridView.a(DynamicGridView.this, paramView);
        AppMethodBeat.o(100316);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(100315);
        DynamicGridView.a(DynamicGridView.this, true);
        DynamicGridView.b(DynamicGridView.this);
        AppMethodBeat.o(100315);
      }
    });
    ((ObjectAnimator)localObject).setDuration(200L);
    ((ObjectAnimator)localObject).start();
    AppMethodBeat.o(100356);
  }
  
  private void jY(View paramView)
  {
    AppMethodBeat.i(100357);
    this.idList.clear();
    this.RTw = -1L;
    paramView.setVisibility(0);
    this.RTn = null;
    if ((hrZ()) && (this.RTE))
    {
      if (!this.yAG) {
        break label98;
      }
      Ey(false);
      hrU();
    }
    for (;;)
    {
      int i = 0;
      while (i < getLastVisiblePosition() - getFirstVisiblePosition())
      {
        paramView = getChildAt(i);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        i += 1;
      }
      label98:
      Ey(true);
    }
    invalidate();
    AppMethodBeat.o(100357);
  }
  
  private Point jZ(View paramView)
  {
    AppMethodBeat.i(100360);
    int i = getPositionForView(paramView);
    int j = getColumnCount();
    paramView = new Point(i % j, i / j);
    AppMethodBeat.o(100360);
    return paramView;
  }
  
  private void lQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100340);
    getAdapterInterface().lP(paramInt1, paramInt2);
    AppMethodBeat.o(100340);
  }
  
  private void vB(long paramLong)
  {
    AppMethodBeat.i(100344);
    this.idList.clear();
    int j = vC(paramLong);
    int i = getFirstVisiblePosition();
    while (i <= getLastVisiblePosition())
    {
      if ((j != i) && (getAdapterInterface().amD(i))) {
        this.idList.add(Long.valueOf(amI(i)));
      }
      i += 1;
    }
    AppMethodBeat.o(100344);
  }
  
  final void Ey(boolean paramBoolean)
  {
    AppMethodBeat.i(100335);
    Object localObject = this.RTB.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Animator)((Iterator)localObject).next()).cancel();
    }
    this.RTB.clear();
    int i = 0;
    while (i < getChildCount())
    {
      localObject = getChildAt(i);
      if (localObject != null)
      {
        if (paramBoolean) {
          ((View)localObject).setRotation(0.0F);
        }
        ((View)localObject).setTag(b.f.dgv_wobble_tag, Boolean.FALSE);
      }
      i += 1;
    }
    AppMethodBeat.o(100335);
  }
  
  public final void amG(int paramInt)
  {
    AppMethodBeat.i(100331);
    if (!this.RTF)
    {
      AppMethodBeat.o(100331);
      return;
    }
    requestDisallowInterceptTouchEvent(true);
    if ((hrZ()) && (this.RTE)) {
      hrU();
    }
    if (paramInt != -1)
    {
      this.yAG = amH(paramInt);
      if (this.yAG) {
        this.RTx = true;
      }
    }
    AppMethodBeat.o(100331);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(100363);
    super.dispatchDraw(paramCanvas);
    if (this.RTn != null) {
      this.RTn.draw(paramCanvas);
    }
    AppMethodBeat.o(100363);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(100347);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    new StringBuilder("onInterceptTouchEvent ").append(paramMotionEvent.getAction()).append(" ").append(bool);
    AppMethodBeat.o(100347);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(100348);
    int i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
    new StringBuilder("onTouchEvent ").append(paramMotionEvent.getAction());
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(100348);
      return bool;
      this.Mlj = paramMotionEvent.getX();
      this.Mlk = paramMotionEvent.getY();
      this.RTT = f.a(this, paramMotionEvent.getX(), paramMotionEvent.getY());
      new StringBuilder("onTouchEvent ").append(paramMotionEvent.getAction()).append(",downPos ").append(this.RTT);
      Object localObject;
      if ((!this.RTC) && (this.RTT >= 0))
      {
        localObject = this.RTS;
        ((d)localObject).removeMessages(1);
        ((d)localObject).sendEmptyMessageDelayed(1, 300L);
      }
      this.RTt = -1;
      this.RTu = -1;
      this.QVY = ((int)paramMotionEvent.getX());
      this.QVZ = ((int)paramMotionEvent.getY());
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      if ((this.yAG) && (isEnabled()))
      {
        layoutChildren();
        amH(pointToPosition(this.QVY, this.QVZ));
      }
      else if (!isEnabled())
      {
        AppMethodBeat.o(100348);
        return false;
        this.Mlj = paramMotionEvent.getX();
        this.Mlk = paramMotionEvent.getY();
        if ((this.RTx) && (this.mActivePointerId != -1) && (i != -1)) {
          if ((this.RTu == -1) && (this.RTt == -1))
          {
            this.RTt = ((int)paramMotionEvent.getY(i));
            this.RTu = ((int)paramMotionEvent.getX(i));
            this.QVY = this.RTu;
            this.QVZ = this.RTt;
          }
          else
          {
            this.RTU = paramMotionEvent.getRawX();
            this.RTV = paramMotionEvent.getRawY();
            this.RTt = ((int)paramMotionEvent.getY(i));
            this.RTu = ((int)paramMotionEvent.getX(i));
            i = this.RTt;
            int j = this.QVZ;
            int k = this.RTu;
            int m = this.QVY;
            this.RTo.offsetTo(k - m + this.RTq.left + this.RTs, i - j + this.RTq.top + this.RTr);
            if (this.RTn != null) {
              this.RTn.setBounds(this.RTo);
            }
            invalidate();
            hsc();
            this.RTy = false;
            hrW();
            if (this.RTI != null)
            {
              paramMotionEvent = new Rect(this.RTo);
              paramMotionEvent.offset(0, this.RTo.height() >>> 1);
              this.RTI.C(paramMotionEvent);
            }
            AppMethodBeat.o(100348);
            return false;
            hrX();
            if ((this.RTN) && (this.RTP != null))
            {
              localObject = this.RTP;
              Collections.reverse(((DynamicGridView.a)localObject).RUd);
              if (!((DynamicGridView.a)localObject).RUd.isEmpty())
              {
                this.RTO.push(this.RTP);
                this.RTP = new DynamicGridView.a();
                continue;
                hsb();
                hrX();
                continue;
                if (paramMotionEvent.getPointerId((paramMotionEvent.getAction() & 0xFF00) >> 8) == this.mActivePointerId) {
                  hrX();
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(100353);
    super.setAdapter(paramListAdapter);
    AppMethodBeat.o(100353);
  }
  
  public void setEditModeEnabled(boolean paramBoolean)
  {
    this.RTF = paramBoolean;
  }
  
  public void setOnDragListener(e parame)
  {
    this.RTI = parame;
  }
  
  public void setOnDropListener(f paramf)
  {
    this.RTH = paramf;
  }
  
  public void setOnEditModeChangeListener(g paramg)
  {
    this.RTJ = paramg;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(100332);
    this.RTK = paramOnItemClickListener;
    super.setOnItemClickListener(this.RTM);
    AppMethodBeat.o(100332);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.RTG = paramOnScrollListener;
  }
  
  public void setOnSelectedItemBitmapCreationListener(h paramh)
  {
    this.RTQ = paramh;
  }
  
  public void setUndoSupportEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(100333);
    if (this.RTN != paramBoolean) {
      if (!paramBoolean) {
        break label41;
      }
    }
    label41:
    for (this.RTO = new Stack();; this.RTO = null)
    {
      this.RTN = paramBoolean;
      AppMethodBeat.o(100333);
      return;
    }
  }
  
  public void setWobbleInEditMode(boolean paramBoolean)
  {
    this.RTE = paramBoolean;
  }
  
  public final int vC(long paramLong)
  {
    AppMethodBeat.i(100345);
    View localView = vD(paramLong);
    if (localView == null)
    {
      AppMethodBeat.o(100345);
      return -1;
    }
    int i = getPositionForView(localView);
    AppMethodBeat.o(100345);
    return i;
  }
  
  public final View vD(long paramLong)
  {
    AppMethodBeat.i(100346);
    int j = getFirstVisiblePosition();
    ListAdapter localListAdapter = getAdapter();
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localListAdapter.getItemId(j + i) == paramLong)
      {
        AppMethodBeat.o(100346);
        return localView;
      }
      i += 1;
    }
    AppMethodBeat.o(100346);
    return null;
  }
  
  final class b
    implements DynamicGridView.j
  {
    private int bwj;
    private int bwk;
    
    static
    {
      AppMethodBeat.i(100323);
      if (!DynamicGridView.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(100323);
        return;
      }
    }
    
    public b(int paramInt1, int paramInt2)
    {
      this.bwj = paramInt1;
      this.bwk = paramInt2;
    }
    
    public final void lS(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100322);
      if ((!$assertionsDisabled) && (DynamicGridView.e(DynamicGridView.this) == null))
      {
        AssertionError localAssertionError = new AssertionError();
        AppMethodBeat.o(100322);
        throw localAssertionError;
      }
      DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(DynamicGridView.e(DynamicGridView.this), paramInt1, paramInt2));
      DynamicGridView.b(DynamicGridView.this, DynamicGridView.this.vD(DynamicGridView.f(DynamicGridView.this)));
      AppMethodBeat.o(100322);
    }
    
    final class a
      implements ViewTreeObserver.OnPreDrawListener
    {
      private final View RUe;
      private final int RUf;
      private final int cag;
      
      a(View paramView, int paramInt1, int paramInt2)
      {
        this.RUe = paramView;
        this.RUf = paramInt1;
        this.cag = paramInt2;
      }
      
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(100321);
        DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
        DynamicGridView.a(DynamicGridView.this, DynamicGridView.b.a(DynamicGridView.b.this));
        DynamicGridView.b(DynamicGridView.this, DynamicGridView.b.b(DynamicGridView.b.this));
        DynamicGridView.a(DynamicGridView.this, this.RUf, this.cag);
        this.RUe.setVisibility(0);
        if (DynamicGridView.e(DynamicGridView.this) != null) {
          DynamicGridView.e(DynamicGridView.this).setVisibility(4);
        }
        AppMethodBeat.o(100321);
        return true;
      }
    }
  }
  
  final class c
    implements DynamicGridView.j
  {
    int bwj;
    int bwk;
    
    public c(int paramInt1, int paramInt2)
    {
      this.bwj = paramInt1;
      this.bwk = paramInt2;
    }
    
    public final void lS(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100326);
      DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(paramInt1, paramInt2));
      AppMethodBeat.o(100326);
    }
    
    final class a
      implements ViewTreeObserver.OnPreDrawListener
    {
      private final int RUf;
      private final int cag;
      
      static
      {
        AppMethodBeat.i(100325);
        if (!DynamicGridView.class.desiredAssertionStatus()) {}
        for (boolean bool = true;; bool = false)
        {
          $assertionsDisabled = bool;
          AppMethodBeat.o(100325);
          return;
        }
      }
      
      a(int paramInt1, int paramInt2)
      {
        this.RUf = paramInt1;
        this.cag = paramInt2;
      }
      
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(100324);
        DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
        DynamicGridView.a(DynamicGridView.this, DynamicGridView.c.this.bwk);
        DynamicGridView.b(DynamicGridView.this, DynamicGridView.c.this.bwj);
        DynamicGridView.a(DynamicGridView.this, this.RUf, this.cag);
        new StringBuilder("id ").append(DynamicGridView.this.vC(DynamicGridView.f(DynamicGridView.this)));
        if (DynamicGridView.e(DynamicGridView.this) == null)
        {
          AppMethodBeat.o(100324);
          return true;
        }
        if (DynamicGridView.e(DynamicGridView.this) == null)
        {
          AppMethodBeat.o(100324);
          return true;
        }
        AssertionError localAssertionError;
        if ((!$assertionsDisabled) && (DynamicGridView.e(DynamicGridView.this) == null))
        {
          localAssertionError = new AssertionError();
          AppMethodBeat.o(100324);
          throw localAssertionError;
        }
        DynamicGridView.e(DynamicGridView.this).setVisibility(0);
        DynamicGridView.b(DynamicGridView.this, DynamicGridView.this.vD(DynamicGridView.f(DynamicGridView.this)));
        if (DynamicGridView.e(DynamicGridView.this) == null)
        {
          AppMethodBeat.o(100324);
          return true;
        }
        if ((!$assertionsDisabled) && (DynamicGridView.e(DynamicGridView.this) == null))
        {
          localAssertionError = new AssertionError();
          AppMethodBeat.o(100324);
          throw localAssertionError;
        }
        DynamicGridView.e(DynamicGridView.this).setVisibility(4);
        AppMethodBeat.o(100324);
        return true;
      }
    }
  }
  
  final class d
    extends Handler
  {
    private d() {}
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(100327);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(100327);
        return;
        paramMessage = DynamicGridView.this;
        View localView = paramMessage.getChildAt(paramMessage.RTT);
        new StringBuilder("downView ").append(localView).append(",downPos ").append(paramMessage.RTT).append(",lastTouchX ").append(paramMessage.Mlj).append(",lastTouchY ").append(paramMessage.Mlk);
        if ((!paramMessage.RTC) && (!paramMessage.RTD) && (f.g(localView, paramMessage.Mlj, paramMessage.Mlk))) {
          paramMessage.amG(paramMessage.RTT);
        }
      }
    }
  }
  
  public static abstract interface e
  {
    public abstract void C(Rect paramRect);
    
    public abstract boolean D(Rect paramRect);
    
    public abstract void adZ(int paramInt);
    
    public abstract void amF(int paramInt);
    
    public abstract void hrS();
  }
  
  public static abstract interface f
  {
    public abstract void hrT();
  }
  
  public static abstract interface g {}
  
  public static abstract interface h {}
  
  final class i
    implements DynamicGridView.j
  {
    private int bwj;
    private int bwk;
    
    public i(int paramInt1, int paramInt2)
    {
      this.bwj = paramInt1;
      this.bwk = paramInt2;
    }
    
    public final void lS(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100328);
      DynamicGridView.a(DynamicGridView.this, this.bwk);
      DynamicGridView.b(DynamicGridView.this, this.bwj);
      AppMethodBeat.o(100328);
    }
  }
  
  static abstract interface j
  {
    public abstract void lS(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView
 * JD-Core Version:    0.7.0.1
 */