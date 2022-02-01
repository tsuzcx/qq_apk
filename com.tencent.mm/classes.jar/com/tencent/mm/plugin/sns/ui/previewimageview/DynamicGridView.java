package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DynamicGridView
  extends WrappingGridView
{
  private int ARA;
  private boolean ARB;
  private List<ObjectAnimator> ARC;
  boolean ARD;
  boolean ARE;
  boolean ARF;
  private boolean ARG;
  private AbsListView.OnScrollListener ARH;
  private f ARI;
  private e ARJ;
  private g ARK;
  private AdapterView.OnItemClickListener ARL;
  private AdapterView.OnItemClickListener ARM;
  private boolean ARN;
  private Stack<DynamicGridView.a> ARO;
  private DynamicGridView.a ARP;
  private h ARQ;
  private View ARR;
  d ARS;
  int ART;
  float ARU;
  float ARV;
  private float ARW;
  private float ARX;
  private AbsListView.OnScrollListener ARY;
  private BitmapDrawable ARo;
  private Rect ARp;
  private Rect ARq;
  private Rect ARr;
  private int ARs;
  private int ARt;
  private int ARu;
  private int ARv;
  private int ARw;
  private long ARx;
  private boolean ARy;
  private boolean ARz;
  private int AbR;
  private int AbS;
  private List<Long> idList;
  private int mActivePointerId;
  private int mScrollState;
  boolean qrh;
  
  public DynamicGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100329);
    this.ARs = 0;
    this.ARt = 0;
    this.AbR = -1;
    this.AbS = -1;
    this.ARu = -1;
    this.ARv = -1;
    this.idList = new ArrayList();
    this.ARx = -1L;
    this.ARy = false;
    this.mActivePointerId = -1;
    this.ARA = 0;
    this.ARB = false;
    this.mScrollState = 0;
    this.qrh = false;
    this.ARC = new LinkedList();
    this.ARF = true;
    this.ARG = true;
    this.ARM = new DynamicGridView.1(this);
    this.ARS = new d((byte)0);
    this.ART = -1;
    this.ARY = new AbsListView.OnScrollListener()
    {
      private int ASa = -1;
      private int ASb = -1;
      private int ASc;
      private int ASd;
      private int fPK;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(100306);
        this.ASc = paramAnonymousInt1;
        this.ASd = paramAnonymousInt2;
        int i;
        label49:
        label212:
        View localView;
        if (this.ASa == -1)
        {
          i = this.ASc;
          this.ASa = i;
          if (this.ASb != -1) {
            break label305;
          }
          i = this.ASd;
          this.ASb = i;
          if ((this.ASc != this.ASa) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          if ((this.ASc + this.ASd != this.ASa + this.ASb) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          this.ASa = this.ASc;
          this.ASb = this.ASd;
          if ((!DynamicGridView.eii()) || (!DynamicGridView.i(DynamicGridView.this))) {
            break label369;
          }
          i = 0;
          if (i >= paramAnonymousInt2) {
            break label369;
          }
          localView = DynamicGridView.this.getChildAt(i);
          if (localView != null)
          {
            if ((DynamicGridView.h(DynamicGridView.this) == -1L) || (Boolean.TRUE == localView.getTag(2131299072))) {
              break label326;
            }
            if (i % 2 != 0) {
              break label314;
            }
            DynamicGridView.c(DynamicGridView.this, localView);
            label277:
            localView.setTag(2131299072, Boolean.TRUE);
          }
        }
        for (;;)
        {
          i += 1;
          break label212;
          i = this.ASa;
          break;
          label305:
          i = this.ASb;
          break label49;
          label314:
          DynamicGridView.d(DynamicGridView.this, localView);
          break label277;
          label326:
          if ((DynamicGridView.h(DynamicGridView.this) == -1L) && (localView.getRotation() != 0.0F))
          {
            localView.setRotation(0.0F);
            localView.setTag(2131299072, Boolean.FALSE);
          }
        }
        label369:
        if (DynamicGridView.j(DynamicGridView.this) != null) {
          DynamicGridView.j(DynamicGridView.this).onScroll(paramAnonymousAbsListView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(100306);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(100307);
        this.fPK = paramAnonymousInt;
        DynamicGridView.c(DynamicGridView.this, paramAnonymousInt);
        if ((this.ASd > 0) && (this.fPK == 0))
        {
          if ((!DynamicGridView.k(DynamicGridView.this)) || (!DynamicGridView.l(DynamicGridView.this))) {
            break label90;
          }
          DynamicGridView.m(DynamicGridView.this);
        }
        for (;;)
        {
          if (DynamicGridView.j(DynamicGridView.this) != null) {
            DynamicGridView.j(DynamicGridView.this).onScrollStateChanged(paramAnonymousAbsListView, paramAnonymousInt);
          }
          AppMethodBeat.o(100307);
          return;
          label90:
          if (DynamicGridView.n(DynamicGridView.this)) {
            DynamicGridView.o(DynamicGridView.this);
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
    this.ARs = 0;
    this.ARt = 0;
    this.AbR = -1;
    this.AbS = -1;
    this.ARu = -1;
    this.ARv = -1;
    this.idList = new ArrayList();
    this.ARx = -1L;
    this.ARy = false;
    this.mActivePointerId = -1;
    this.ARA = 0;
    this.ARB = false;
    this.mScrollState = 0;
    this.qrh = false;
    this.ARC = new LinkedList();
    this.ARF = true;
    this.ARG = true;
    this.ARM = new DynamicGridView.1(this);
    this.ARS = new d((byte)0);
    this.ART = -1;
    this.ARY = new AbsListView.OnScrollListener()
    {
      private int ASa = -1;
      private int ASb = -1;
      private int ASc;
      private int ASd;
      private int fPK;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(100306);
        this.ASc = paramAnonymousInt1;
        this.ASd = paramAnonymousInt2;
        int i;
        label49:
        label212:
        View localView;
        if (this.ASa == -1)
        {
          i = this.ASc;
          this.ASa = i;
          if (this.ASb != -1) {
            break label305;
          }
          i = this.ASd;
          this.ASb = i;
          if ((this.ASc != this.ASa) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          if ((this.ASc + this.ASd != this.ASa + this.ASb) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          this.ASa = this.ASc;
          this.ASb = this.ASd;
          if ((!DynamicGridView.eii()) || (!DynamicGridView.i(DynamicGridView.this))) {
            break label369;
          }
          i = 0;
          if (i >= paramAnonymousInt2) {
            break label369;
          }
          localView = DynamicGridView.this.getChildAt(i);
          if (localView != null)
          {
            if ((DynamicGridView.h(DynamicGridView.this) == -1L) || (Boolean.TRUE == localView.getTag(2131299072))) {
              break label326;
            }
            if (i % 2 != 0) {
              break label314;
            }
            DynamicGridView.c(DynamicGridView.this, localView);
            label277:
            localView.setTag(2131299072, Boolean.TRUE);
          }
        }
        for (;;)
        {
          i += 1;
          break label212;
          i = this.ASa;
          break;
          label305:
          i = this.ASb;
          break label49;
          label314:
          DynamicGridView.d(DynamicGridView.this, localView);
          break label277;
          label326:
          if ((DynamicGridView.h(DynamicGridView.this) == -1L) && (localView.getRotation() != 0.0F))
          {
            localView.setRotation(0.0F);
            localView.setTag(2131299072, Boolean.FALSE);
          }
        }
        label369:
        if (DynamicGridView.j(DynamicGridView.this) != null) {
          DynamicGridView.j(DynamicGridView.this).onScroll(paramAnonymousAbsListView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(100306);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(100307);
        this.fPK = paramAnonymousInt;
        DynamicGridView.c(DynamicGridView.this, paramAnonymousInt);
        if ((this.ASd > 0) && (this.fPK == 0))
        {
          if ((!DynamicGridView.k(DynamicGridView.this)) || (!DynamicGridView.l(DynamicGridView.this))) {
            break label90;
          }
          DynamicGridView.m(DynamicGridView.this);
        }
        for (;;)
        {
          if (DynamicGridView.j(DynamicGridView.this) != null) {
            DynamicGridView.j(DynamicGridView.this).onScrollStateChanged(paramAnonymousAbsListView, paramAnonymousInt);
          }
          AppMethodBeat.o(100307);
          return;
          label90:
          if (DynamicGridView.n(DynamicGridView.this)) {
            DynamicGridView.o(DynamicGridView.this);
          }
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(100330);
  }
  
  private void AS(long paramLong)
  {
    AppMethodBeat.i(100344);
    this.idList.clear();
    int j = AT(paramLong);
    int i = getFirstVisiblePosition();
    while (i <= getLastVisiblePosition())
    {
      if ((j != i) && (getAdapterInterface().Sk(i))) {
        this.idList.add(Long.valueOf(Sq(i)));
      }
      i += 1;
    }
    AppMethodBeat.o(100344);
  }
  
  private boolean Sp(int paramInt)
  {
    AppMethodBeat.i(100350);
    if (!getAdapterInterface().Sj(paramInt))
    {
      AppMethodBeat.o(100350);
      return false;
    }
    this.ARs = 0;
    this.ARt = 0;
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null)
    {
      this.ARx = getAdapter().getItemId(paramInt);
      this.ARo = ft(localView);
      eid();
      if (eie()) {
        localView.setVisibility(4);
      }
      AS(this.ARx);
      if (this.ARJ != null) {
        this.ARJ.Sm(paramInt);
      }
      AppMethodBeat.o(100350);
      return true;
    }
    AppMethodBeat.o(100350);
    return false;
  }
  
  private long Sq(int paramInt)
  {
    AppMethodBeat.i(100361);
    long l = getAdapter().getItemId(paramInt);
    AppMethodBeat.o(100361);
    return l;
  }
  
  @TargetApi(11)
  private void ehZ()
  {
    AppMethodBeat.i(100334);
    int i = 0;
    if (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView != null) && (Boolean.TRUE != localView.getTag(2131299072)))
      {
        if (i % 2 != 0) {
          break label67;
        }
        fq(localView);
      }
      for (;;)
      {
        localView.setTag(2131299072, Boolean.TRUE);
        i += 1;
        break;
        label67:
        fr(localView);
      }
    }
    AppMethodBeat.o(100334);
  }
  
  private void ei(View paramView)
  {
    AppMethodBeat.i(100357);
    this.idList.clear();
    this.ARx = -1L;
    paramView.setVisibility(0);
    this.ARo = null;
    if ((eie()) && (this.ARF))
    {
      if (!this.qrh) {
        break label98;
      }
      si(false);
      ehZ();
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
      si(true);
    }
    invalidate();
    AppMethodBeat.o(100357);
  }
  
  private boolean eia()
  {
    AppMethodBeat.i(100349);
    int i = AT(this.ARx);
    if (i != -1)
    {
      this.ARJ.Sn(i);
      if (this.ARR == null)
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
      i = getPositionForView(this.ARR);
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
      hZ(i, j);
      if (this.ARN) {
        this.ARP.ia(i, j);
      }
      this.AbS = this.ARu;
      this.AbR = this.ARv;
      if (!eie()) {
        break label216;
      }
    }
    Object localObject;
    if (eif()) {
      localObject = new b(0, 0);
    }
    for (;;)
    {
      AS(this.ARx);
      ((j)localObject).ib(i, j);
      AppMethodBeat.o(100349);
      return true;
      label216:
      if (eif()) {
        localObject = new i(0, 0);
      } else {
        localObject = new c(0, 0);
      }
    }
  }
  
  private void eib()
  {
    AppMethodBeat.i(100351);
    this.ARz = n(this.ARp);
    AppMethodBeat.o(100351);
  }
  
  private void eic()
  {
    AppMethodBeat.i(100354);
    this.ARS.removeMessages(1);
    View localView = AU(this.ARx);
    Rect localRect;
    if (this.ARp != null)
    {
      localRect = new Rect(this.ARp);
      localRect.offset(0, this.ARp.height() >>> 1);
    }
    for (;;)
    {
      if ((this.ARJ != null) && (this.ARJ.m(localRect)) && (eia()))
      {
        this.ARo = null;
        eig();
        if (this.ARI != null) {
          this.ARI.ehY();
        }
      }
      for (;;)
      {
        if (this.ARJ != null) {
          this.ARJ.ehX();
        }
        AppMethodBeat.o(100354);
        return;
        if ((localView != null) && ((this.ARy) || (this.ARB)))
        {
          this.ARy = false;
          this.ARB = false;
          this.ARz = false;
          this.mActivePointerId = -1;
          this.ARp.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          new StringBuilder("animating to  ").append(this.ARp);
          if (Build.VERSION.SDK_INT > 11)
          {
            fu(localView);
          }
          else
          {
            this.ARo.setBounds(this.ARp);
            invalidate();
            ei(localView);
          }
        }
        else
        {
          eig();
        }
      }
      localRect = null;
    }
  }
  
  @TargetApi(11)
  private void eid()
  {
    AppMethodBeat.i(100355);
    Object localObject = new TypeEvaluator()
    {
      private static int e(int paramAnonymousInt1, int paramAnonymousInt2, float paramAnonymousFloat)
      {
        return (int)(paramAnonymousInt1 + (paramAnonymousInt2 - paramAnonymousInt1) * paramAnonymousFloat);
      }
    };
    localObject = ObjectAnimator.ofObject(this.ARo, "bounds", (TypeEvaluator)localObject, new Object[] { this.ARp });
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
  
  static boolean eie()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  private static boolean eif()
  {
    return Build.VERSION.SDK_INT < 21;
  }
  
  private void eig()
  {
    AppMethodBeat.i(100358);
    View localView = AU(this.ARx);
    if (localView == null)
    {
      AppMethodBeat.o(100358);
      return;
    }
    if (this.ARy) {
      ei(localView);
    }
    this.ARy = false;
    this.ARz = false;
    this.mActivePointerId = -1;
    AppMethodBeat.o(100358);
  }
  
  private void eih()
  {
    AppMethodBeat.i(100359);
    int j = this.ARu - this.AbS;
    int k = this.ARv - this.AbR;
    int m = this.ARq.centerY() + this.ARs + j;
    int n = this.ARq.centerX() + this.ARt + k;
    this.ARR = AU(this.ARx);
    if (this.ARR == null)
    {
      AppMethodBeat.o(100359);
      return;
    }
    Object localObject = null;
    float f2 = 0.0F;
    float f1 = 0.0F;
    Point localPoint1 = fv(this.ARR);
    Iterator localIterator = this.idList.iterator();
    int i;
    if (localIterator.hasNext())
    {
      View localView = AU(((Long)localIterator.next()).longValue());
      if (localView == null) {
        break label913;
      }
      Point localPoint2 = fv(localView);
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
                if ((i == 0) || (m >= localView.getBottom() - this.ARw))
                {
                  if ((localPoint2.y <= localPoint1.y) || (localPoint2.x != localPoint1.x)) {
                    break label660;
                  }
                  i = 1;
                  if ((i == 0) || (m <= localView.getTop() + this.ARw))
                  {
                    if ((localPoint2.y != localPoint1.y) || (localPoint2.x <= localPoint1.x)) {
                      break label666;
                    }
                    i = 1;
                    label501:
                    if ((i == 0) || (n <= localView.getLeft() + this.ARw))
                    {
                      if ((localPoint2.y != localPoint1.y) || (localPoint2.x >= localPoint1.x)) {
                        break label672;
                      }
                      i = 1;
                      if ((i == 0) || (n >= localView.getRight() - this.ARw)) {
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
        float f4 = Math.abs(f.fo(localView) - f.fo(this.ARR));
        label403:
        label550:
        float f3 = Math.abs(f.fp(localView) - f.fp(this.ARR));
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
        i = getPositionForView(this.ARR);
        m = getPositionForView((View)localObject);
        new StringBuilder("switch ").append(i).append(",").append(m);
        localObject = getAdapterInterface();
        if ((m == -1) || (!((d)localObject).Sk(i)) || (!((d)localObject).Sk(m)))
        {
          AS(this.ARx);
          AppMethodBeat.o(100359);
          return;
        }
        hZ(i, m);
        if (this.ARN) {
          this.ARP.ia(i, m);
        }
        this.AbS = this.ARu;
        this.AbR = this.ARv;
        if ((!eie()) || (!eif())) {
          break label873;
        }
        localObject = new b(k, j);
      }
      for (;;)
      {
        AS(this.ARx);
        ((j)localObject).ib(i, m);
        AppMethodBeat.o(100359);
        return;
        label873:
        if (eif()) {
          localObject = new i(k, j);
        } else {
          localObject = new c(k, j);
        }
      }
    }
  }
  
  @TargetApi(11)
  private static AnimatorSet f(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(100362);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { paramFloat1, 0.0F });
    paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramFloat2, 0.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, paramView });
    AppMethodBeat.o(100362);
    return localAnimatorSet;
  }
  
  @TargetApi(11)
  private void fq(View paramView)
  {
    AppMethodBeat.i(100337);
    paramView = fs(paramView);
    paramView.setFloatValues(new float[] { -2.0F, 2.0F });
    paramView.start();
    this.ARC.add(paramView);
    AppMethodBeat.o(100337);
  }
  
  @TargetApi(11)
  private void fr(View paramView)
  {
    AppMethodBeat.i(100338);
    paramView = fs(paramView);
    paramView.setFloatValues(new float[] { 2.0F, -2.0F });
    paramView.start();
    this.ARC.add(paramView);
    AppMethodBeat.o(100338);
  }
  
  @TargetApi(11)
  private ObjectAnimator fs(final View paramView)
  {
    AppMethodBeat.i(100339);
    if (!eif()) {
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
  
  private BitmapDrawable ft(View paramView)
  {
    AppMethodBeat.i(100343);
    int j = paramView.getWidth();
    int i = paramView.getHeight();
    int k = paramView.getTop();
    int m = paramView.getLeft();
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas(localBitmap));
    paramView = new BitmapDrawable(getResources(), localBitmap);
    this.ARq = new Rect(m, k, m + j, k + i);
    k = this.ARq.left;
    m = (int)(j * 0.05F);
    int n = this.ARq.top;
    int i1 = (int)(i * 0.05F);
    int i2 = this.ARq.right;
    j = (int)(j * 0.05F);
    int i3 = this.ARq.bottom;
    this.ARp = new Rect(k - m, n - i1, j + i2, (int)(i * 0.05F) + i3);
    this.ARr = new Rect(this.ARp);
    paramView.setBounds(this.ARq);
    AppMethodBeat.o(100343);
    return paramView;
  }
  
  @TargetApi(11)
  private void fu(final View paramView)
  {
    AppMethodBeat.i(100356);
    Object localObject = new TypeEvaluator()
    {
      private static int e(int paramAnonymousInt1, int paramAnonymousInt2, float paramAnonymousFloat)
      {
        return (int)(paramAnonymousInt1 + (paramAnonymousInt2 - paramAnonymousInt1) * paramAnonymousFloat);
      }
    };
    localObject = ObjectAnimator.ofObject(this.ARo, "bounds", (TypeEvaluator)localObject, new Object[] { this.ARp });
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
          DynamicGridView.d(DynamicGridView.this).ehY();
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
  
  private Point fv(View paramView)
  {
    AppMethodBeat.i(100360);
    int i = getPositionForView(paramView);
    int j = getColumnCount();
    paramView = new Point(i % j, i / j);
    AppMethodBeat.o(100360);
    return paramView;
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
  
  private void hZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100340);
    getAdapterInterface().hY(paramInt1, paramInt2);
    AppMethodBeat.o(100340);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(100336);
    super.setOnScrollListener(this.ARY);
    this.ARA = ((int)(paramContext.getResources().getDisplayMetrics().density * 8.0F + 0.5F));
    this.ARw = getResources().getDimensionPixelSize(2131166136);
    AppMethodBeat.o(100336);
  }
  
  private boolean n(Rect paramRect)
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
      smoothScrollBy(-this.ARA, 0);
      AppMethodBeat.o(100352);
      return true;
    }
    if ((n + i1 >= j) && (i + k < m))
    {
      smoothScrollBy(this.ARA, 0);
      AppMethodBeat.o(100352);
      return true;
    }
    AppMethodBeat.o(100352);
    return false;
  }
  
  public final int AT(long paramLong)
  {
    AppMethodBeat.i(100345);
    View localView = AU(paramLong);
    if (localView == null)
    {
      AppMethodBeat.o(100345);
      return -1;
    }
    int i = getPositionForView(localView);
    AppMethodBeat.o(100345);
    return i;
  }
  
  public final View AU(long paramLong)
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
  
  public final void So(int paramInt)
  {
    AppMethodBeat.i(100331);
    if (!this.ARG)
    {
      AppMethodBeat.o(100331);
      return;
    }
    requestDisallowInterceptTouchEvent(true);
    if ((eie()) && (this.ARF)) {
      ehZ();
    }
    if (paramInt != -1)
    {
      this.qrh = Sp(paramInt);
      if (this.qrh) {
        this.ARy = true;
      }
    }
    AppMethodBeat.o(100331);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(100363);
    super.dispatchDraw(paramCanvas);
    if (this.ARo != null) {
      this.ARo.draw(paramCanvas);
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
      this.ARU = paramMotionEvent.getX();
      this.ARV = paramMotionEvent.getY();
      this.ART = f.a(this, paramMotionEvent.getX(), paramMotionEvent.getY());
      new StringBuilder("onTouchEvent ").append(paramMotionEvent.getAction()).append(",downPos ").append(this.ART);
      Object localObject;
      if ((!this.ARD) && (this.ART >= 0))
      {
        localObject = this.ARS;
        ((d)localObject).removeMessages(1);
        ((d)localObject).sendEmptyMessageDelayed(1, 300L);
      }
      this.ARu = -1;
      this.ARv = -1;
      this.AbR = ((int)paramMotionEvent.getX());
      this.AbS = ((int)paramMotionEvent.getY());
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      if ((this.qrh) && (isEnabled()))
      {
        layoutChildren();
        Sp(pointToPosition(this.AbR, this.AbS));
      }
      else if (!isEnabled())
      {
        AppMethodBeat.o(100348);
        return false;
        this.ARU = paramMotionEvent.getX();
        this.ARV = paramMotionEvent.getY();
        if ((this.ARy) && (this.mActivePointerId != -1) && (i != -1)) {
          if ((this.ARv == -1) && (this.ARu == -1))
          {
            this.ARu = ((int)paramMotionEvent.getY(i));
            this.ARv = ((int)paramMotionEvent.getX(i));
            this.AbR = this.ARv;
            this.AbS = this.ARu;
          }
          else
          {
            this.ARW = paramMotionEvent.getRawX();
            this.ARX = paramMotionEvent.getRawY();
            this.ARu = ((int)paramMotionEvent.getY(i));
            this.ARv = ((int)paramMotionEvent.getX(i));
            i = this.ARu;
            int j = this.AbS;
            int k = this.ARv;
            int m = this.AbR;
            this.ARp.offsetTo(k - m + this.ARr.left + this.ARt, i - j + this.ARr.top + this.ARs);
            if (this.ARo != null) {
              this.ARo.setBounds(this.ARp);
            }
            invalidate();
            eih();
            this.ARz = false;
            eib();
            if (this.ARJ != null)
            {
              paramMotionEvent = new Rect(this.ARp);
              paramMotionEvent.offset(0, this.ARp.height() >>> 1);
              this.ARJ.l(paramMotionEvent);
            }
            AppMethodBeat.o(100348);
            return false;
            eic();
            if ((this.ARN) && (this.ARP != null))
            {
              localObject = this.ARP;
              Collections.reverse(((DynamicGridView.a)localObject).ASf);
              if (!((DynamicGridView.a)localObject).ASf.isEmpty())
              {
                this.ARO.push(this.ARP);
                this.ARP = new DynamicGridView.a();
                continue;
                eig();
                eic();
                continue;
                if (paramMotionEvent.getPointerId((paramMotionEvent.getAction() & 0xFF00) >> 8) == this.mActivePointerId) {
                  eic();
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
    this.ARG = paramBoolean;
  }
  
  public void setOnDragListener(e parame)
  {
    this.ARJ = parame;
  }
  
  public void setOnDropListener(f paramf)
  {
    this.ARI = paramf;
  }
  
  public void setOnEditModeChangeListener(g paramg)
  {
    this.ARK = paramg;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(100332);
    this.ARL = paramOnItemClickListener;
    super.setOnItemClickListener(this.ARM);
    AppMethodBeat.o(100332);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.ARH = paramOnScrollListener;
  }
  
  public void setOnSelectedItemBitmapCreationListener(h paramh)
  {
    this.ARQ = paramh;
  }
  
  public void setUndoSupportEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(100333);
    if (this.ARN != paramBoolean) {
      if (!paramBoolean) {
        break label41;
      }
    }
    label41:
    for (this.ARO = new Stack();; this.ARO = null)
    {
      this.ARN = paramBoolean;
      AppMethodBeat.o(100333);
      return;
    }
  }
  
  public void setWobbleInEditMode(boolean paramBoolean)
  {
    this.ARF = paramBoolean;
  }
  
  @TargetApi(11)
  final void si(boolean paramBoolean)
  {
    AppMethodBeat.i(100335);
    Object localObject = this.ARC.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Animator)((Iterator)localObject).next()).cancel();
    }
    this.ARC.clear();
    int i = 0;
    while (i < getChildCount())
    {
      localObject = getChildAt(i);
      if (localObject != null)
      {
        if (paramBoolean) {
          ((View)localObject).setRotation(0.0F);
        }
        ((View)localObject).setTag(2131299072, Boolean.FALSE);
      }
      i += 1;
    }
    AppMethodBeat.o(100335);
  }
  
  final class b
    implements DynamicGridView.j
  {
    private int Bc;
    private int Bd;
    
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
      this.Bc = paramInt1;
      this.Bd = paramInt2;
    }
    
    public final void ib(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100322);
      if ((!$assertionsDisabled) && (DynamicGridView.g(DynamicGridView.this) == null))
      {
        AssertionError localAssertionError = new AssertionError();
        AppMethodBeat.o(100322);
        throw localAssertionError;
      }
      DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(DynamicGridView.g(DynamicGridView.this), paramInt1, paramInt2));
      DynamicGridView.b(DynamicGridView.this, DynamicGridView.this.AU(DynamicGridView.h(DynamicGridView.this)));
      AppMethodBeat.o(100322);
    }
    
    final class a
      implements ViewTreeObserver.OnPreDrawListener
    {
      private final View ASg;
      private final int ASh;
      private final int atQ;
      
      a(View paramView, int paramInt1, int paramInt2)
      {
        this.ASg = paramView;
        this.ASh = paramInt1;
        this.atQ = paramInt2;
      }
      
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(100321);
        DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
        DynamicGridView.a(DynamicGridView.this, DynamicGridView.e(DynamicGridView.this) + DynamicGridView.b.a(DynamicGridView.b.this));
        DynamicGridView.b(DynamicGridView.this, DynamicGridView.f(DynamicGridView.this) + DynamicGridView.b.b(DynamicGridView.b.this));
        DynamicGridView.a(DynamicGridView.this, this.ASh, this.atQ);
        this.ASg.setVisibility(0);
        if (DynamicGridView.g(DynamicGridView.this) != null) {
          DynamicGridView.g(DynamicGridView.this).setVisibility(4);
        }
        AppMethodBeat.o(100321);
        return true;
      }
    }
  }
  
  final class c
    implements DynamicGridView.j
  {
    int Bc;
    int Bd;
    
    public c(int paramInt1, int paramInt2)
    {
      this.Bc = paramInt1;
      this.Bd = paramInt2;
    }
    
    public final void ib(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100326);
      DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(paramInt1, paramInt2));
      AppMethodBeat.o(100326);
    }
    
    final class a
      implements ViewTreeObserver.OnPreDrawListener
    {
      private final int ASh;
      private final int atQ;
      
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
        this.ASh = paramInt1;
        this.atQ = paramInt2;
      }
      
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(100324);
        DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
        DynamicGridView.a(DynamicGridView.this, DynamicGridView.e(DynamicGridView.this) + DynamicGridView.c.this.Bd);
        DynamicGridView.b(DynamicGridView.this, DynamicGridView.f(DynamicGridView.this) + DynamicGridView.c.this.Bc);
        DynamicGridView.a(DynamicGridView.this, this.ASh, this.atQ);
        new StringBuilder("id ").append(DynamicGridView.this.AT(DynamicGridView.h(DynamicGridView.this)));
        if (DynamicGridView.g(DynamicGridView.this) == null)
        {
          AppMethodBeat.o(100324);
          return true;
        }
        if (DynamicGridView.g(DynamicGridView.this) == null)
        {
          AppMethodBeat.o(100324);
          return true;
        }
        AssertionError localAssertionError;
        if ((!$assertionsDisabled) && (DynamicGridView.g(DynamicGridView.this) == null))
        {
          localAssertionError = new AssertionError();
          AppMethodBeat.o(100324);
          throw localAssertionError;
        }
        DynamicGridView.g(DynamicGridView.this).setVisibility(0);
        DynamicGridView.b(DynamicGridView.this, DynamicGridView.this.AU(DynamicGridView.h(DynamicGridView.this)));
        if (DynamicGridView.g(DynamicGridView.this) == null)
        {
          AppMethodBeat.o(100324);
          return true;
        }
        if ((!$assertionsDisabled) && (DynamicGridView.g(DynamicGridView.this) == null))
        {
          localAssertionError = new AssertionError();
          AppMethodBeat.o(100324);
          throw localAssertionError;
        }
        DynamicGridView.g(DynamicGridView.this).setVisibility(4);
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
        View localView = paramMessage.getChildAt(paramMessage.ART);
        new StringBuilder("downView ").append(localView).append(",downPos ").append(paramMessage.ART).append(",lastTouchX ").append(paramMessage.ARU).append(",lastTouchY ").append(paramMessage.ARV);
        if ((!paramMessage.ARD) && (!paramMessage.ARE) && (f.e(localView, paramMessage.ARU, paramMessage.ARV))) {
          paramMessage.So(paramMessage.ART);
        }
      }
    }
  }
  
  public static abstract interface e
  {
    public abstract void Sm(int paramInt);
    
    public abstract void Sn(int paramInt);
    
    public abstract void ehX();
    
    public abstract void l(Rect paramRect);
    
    public abstract boolean m(Rect paramRect);
  }
  
  public static abstract interface f
  {
    public abstract void ehY();
  }
  
  public static abstract interface g {}
  
  public static abstract interface h {}
  
  final class i
    implements DynamicGridView.j
  {
    private int Bc;
    private int Bd;
    
    public i(int paramInt1, int paramInt2)
    {
      this.Bc = paramInt1;
      this.Bd = paramInt2;
    }
    
    public final void ib(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100328);
      DynamicGridView.a(DynamicGridView.this, DynamicGridView.e(DynamicGridView.this) + this.Bd);
      DynamicGridView.b(DynamicGridView.this, DynamicGridView.f(DynamicGridView.this) + this.Bc);
      AppMethodBeat.o(100328);
    }
  }
  
  static abstract interface j
  {
    public abstract void ib(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView
 * JD-Core Version:    0.7.0.1
 */