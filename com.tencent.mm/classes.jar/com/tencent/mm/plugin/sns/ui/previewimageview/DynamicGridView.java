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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DynamicGridView
  extends WrappingGridView
{
  private int Ekh;
  private int Eki;
  private BitmapDrawable FbV;
  private Rect FbW;
  private Rect FbX;
  private Rect FbY;
  private int FbZ;
  int FcA;
  float FcB;
  float FcC;
  private float FcD;
  private float FcE;
  private AbsListView.OnScrollListener FcF;
  private int Fca;
  private int Fcb;
  private int Fcc;
  private int Fcd;
  private long Fce;
  private boolean Fcf;
  private boolean Fcg;
  private int Fch;
  private boolean Fci;
  private List<ObjectAnimator> Fcj;
  boolean Fck;
  boolean Fcl;
  boolean Fcm;
  private boolean Fcn;
  private AbsListView.OnScrollListener Fco;
  private f Fcp;
  private e Fcq;
  private g Fcr;
  private AdapterView.OnItemClickListener Fcs;
  private AdapterView.OnItemClickListener Fct;
  private boolean Fcu;
  private Stack<DynamicGridView.a> Fcv;
  private DynamicGridView.a Fcw;
  private h Fcx;
  private View Fcy;
  d Fcz;
  private List<Long> idList;
  private int mActivePointerId;
  private int mScrollState;
  boolean rIC;
  
  public DynamicGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100329);
    this.FbZ = 0;
    this.Fca = 0;
    this.Ekh = -1;
    this.Eki = -1;
    this.Fcb = -1;
    this.Fcc = -1;
    this.idList = new ArrayList();
    this.Fce = -1L;
    this.Fcf = false;
    this.mActivePointerId = -1;
    this.Fch = 0;
    this.Fci = false;
    this.mScrollState = 0;
    this.rIC = false;
    this.Fcj = new LinkedList();
    this.Fcm = true;
    this.Fcn = true;
    this.Fct = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100305);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        if ((!DynamicGridView.this.rIC) && (DynamicGridView.this.isEnabled()) && (DynamicGridView.a(DynamicGridView.this) != null)) {
          DynamicGridView.a(DynamicGridView.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(100305);
      }
    };
    this.Fcz = new d((byte)0);
    this.FcA = -1;
    this.FcF = new AbsListView.OnScrollListener()
    {
      private int FcH = -1;
      private int FcI = -1;
      private int FcJ;
      private int FcK;
      private int guU;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(100306);
        this.FcJ = paramAnonymousInt1;
        this.FcK = paramAnonymousInt2;
        int i;
        label49:
        label212:
        View localView;
        if (this.FcH == -1)
        {
          i = this.FcJ;
          this.FcH = i;
          if (this.FcI != -1) {
            break label305;
          }
          i = this.FcK;
          this.FcI = i;
          if ((this.FcJ != this.FcH) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          if ((this.FcJ + this.FcK != this.FcH + this.FcI) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          this.FcH = this.FcJ;
          this.FcI = this.FcK;
          if ((!DynamicGridView.fkJ()) || (!DynamicGridView.i(DynamicGridView.this))) {
            break label369;
          }
          i = 0;
          if (i >= paramAnonymousInt2) {
            break label369;
          }
          localView = DynamicGridView.this.getChildAt(i);
          if (localView != null)
          {
            if ((DynamicGridView.h(DynamicGridView.this) == -1L) || (Boolean.TRUE == localView.getTag(2131299578))) {
              break label326;
            }
            if (i % 2 != 0) {
              break label314;
            }
            DynamicGridView.c(DynamicGridView.this, localView);
            label277:
            localView.setTag(2131299578, Boolean.TRUE);
          }
        }
        for (;;)
        {
          i += 1;
          break label212;
          i = this.FcH;
          break;
          label305:
          i = this.FcI;
          break label49;
          label314:
          DynamicGridView.d(DynamicGridView.this, localView);
          break label277;
          label326:
          if ((DynamicGridView.h(DynamicGridView.this) == -1L) && (localView.getRotation() != 0.0F))
          {
            localView.setRotation(0.0F);
            localView.setTag(2131299578, Boolean.FALSE);
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
        this.guU = paramAnonymousInt;
        DynamicGridView.c(DynamicGridView.this, paramAnonymousInt);
        if ((this.FcK > 0) && (this.guU == 0))
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
    this.FbZ = 0;
    this.Fca = 0;
    this.Ekh = -1;
    this.Eki = -1;
    this.Fcb = -1;
    this.Fcc = -1;
    this.idList = new ArrayList();
    this.Fce = -1L;
    this.Fcf = false;
    this.mActivePointerId = -1;
    this.Fch = 0;
    this.Fci = false;
    this.mScrollState = 0;
    this.rIC = false;
    this.Fcj = new LinkedList();
    this.Fcm = true;
    this.Fcn = true;
    this.Fct = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100305);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        if ((!DynamicGridView.this.rIC) && (DynamicGridView.this.isEnabled()) && (DynamicGridView.a(DynamicGridView.this) != null)) {
          DynamicGridView.a(DynamicGridView.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(100305);
      }
    };
    this.Fcz = new d((byte)0);
    this.FcA = -1;
    this.FcF = new AbsListView.OnScrollListener()
    {
      private int FcH = -1;
      private int FcI = -1;
      private int FcJ;
      private int FcK;
      private int guU;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(100306);
        this.FcJ = paramAnonymousInt1;
        this.FcK = paramAnonymousInt2;
        int i;
        label49:
        label212:
        View localView;
        if (this.FcH == -1)
        {
          i = this.FcJ;
          this.FcH = i;
          if (this.FcI != -1) {
            break label305;
          }
          i = this.FcK;
          this.FcI = i;
          if ((this.FcJ != this.FcH) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          if ((this.FcJ + this.FcK != this.FcH + this.FcI) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          this.FcH = this.FcJ;
          this.FcI = this.FcK;
          if ((!DynamicGridView.fkJ()) || (!DynamicGridView.i(DynamicGridView.this))) {
            break label369;
          }
          i = 0;
          if (i >= paramAnonymousInt2) {
            break label369;
          }
          localView = DynamicGridView.this.getChildAt(i);
          if (localView != null)
          {
            if ((DynamicGridView.h(DynamicGridView.this) == -1L) || (Boolean.TRUE == localView.getTag(2131299578))) {
              break label326;
            }
            if (i % 2 != 0) {
              break label314;
            }
            DynamicGridView.c(DynamicGridView.this, localView);
            label277:
            localView.setTag(2131299578, Boolean.TRUE);
          }
        }
        for (;;)
        {
          i += 1;
          break label212;
          i = this.FcH;
          break;
          label305:
          i = this.FcI;
          break label49;
          label314:
          DynamicGridView.d(DynamicGridView.this, localView);
          break label277;
          label326:
          if ((DynamicGridView.h(DynamicGridView.this) == -1L) && (localView.getRotation() != 0.0F))
          {
            localView.setRotation(0.0F);
            localView.setTag(2131299578, Boolean.FALSE);
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
        this.guU = paramAnonymousInt;
        DynamicGridView.c(DynamicGridView.this, paramAnonymousInt);
        if ((this.FcK > 0) && (this.guU == 0))
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
  
  private void JX(long paramLong)
  {
    AppMethodBeat.i(100344);
    this.idList.clear();
    int j = JY(paramLong);
    int i = getFirstVisiblePosition();
    while (i <= getLastVisiblePosition())
    {
      if ((j != i) && (getAdapterInterface().aag(i))) {
        this.idList.add(Long.valueOf(aam(i)));
      }
      i += 1;
    }
    AppMethodBeat.o(100344);
  }
  
  private boolean aal(int paramInt)
  {
    AppMethodBeat.i(100350);
    if (!getAdapterInterface().aaf(paramInt))
    {
      AppMethodBeat.o(100350);
      return false;
    }
    this.FbZ = 0;
    this.Fca = 0;
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null)
    {
      this.Fce = getAdapter().getItemId(paramInt);
      this.FbV = fJ(localView);
      fkE();
      if (fkF()) {
        localView.setVisibility(4);
      }
      JX(this.Fce);
      if (this.Fcq != null) {
        this.Fcq.aai(paramInt);
      }
      AppMethodBeat.o(100350);
      return true;
    }
    AppMethodBeat.o(100350);
    return false;
  }
  
  private long aam(int paramInt)
  {
    AppMethodBeat.i(100361);
    long l = getAdapter().getItemId(paramInt);
    AppMethodBeat.o(100361);
    return l;
  }
  
  @TargetApi(11)
  private void fG(View paramView)
  {
    AppMethodBeat.i(100337);
    paramView = fI(paramView);
    paramView.setFloatValues(new float[] { -2.0F, 2.0F });
    paramView.start();
    this.Fcj.add(paramView);
    AppMethodBeat.o(100337);
  }
  
  @TargetApi(11)
  private void fH(View paramView)
  {
    AppMethodBeat.i(100338);
    paramView = fI(paramView);
    paramView.setFloatValues(new float[] { 2.0F, -2.0F });
    paramView.start();
    this.Fcj.add(paramView);
    AppMethodBeat.o(100338);
  }
  
  @TargetApi(11)
  private ObjectAnimator fI(final View paramView)
  {
    AppMethodBeat.i(100339);
    if (!fkG()) {
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
  
  private BitmapDrawable fJ(View paramView)
  {
    AppMethodBeat.i(100343);
    int j = paramView.getWidth();
    int i = paramView.getHeight();
    int k = paramView.getTop();
    int m = paramView.getLeft();
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas(localBitmap));
    paramView = new BitmapDrawable(getResources(), localBitmap);
    this.FbX = new Rect(m, k, m + j, k + i);
    k = this.FbX.left;
    m = (int)(j * 0.05F);
    int n = this.FbX.top;
    int i1 = (int)(i * 0.05F);
    int i2 = this.FbX.right;
    j = (int)(j * 0.05F);
    int i3 = this.FbX.bottom;
    this.FbW = new Rect(k - m, n - i1, j + i2, (int)(i * 0.05F) + i3);
    this.FbY = new Rect(this.FbW);
    paramView.setBounds(this.FbX);
    AppMethodBeat.o(100343);
    return paramView;
  }
  
  @TargetApi(11)
  private void fK(final View paramView)
  {
    AppMethodBeat.i(100356);
    Object localObject = new TypeEvaluator()
    {
      private static int f(int paramAnonymousInt1, int paramAnonymousInt2, float paramAnonymousFloat)
      {
        return (int)(paramAnonymousInt1 + (paramAnonymousInt2 - paramAnonymousInt1) * paramAnonymousFloat);
      }
    };
    localObject = ObjectAnimator.ofObject(this.FbV, "bounds", (TypeEvaluator)localObject, new Object[] { this.FbW });
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
          DynamicGridView.d(DynamicGridView.this).fkz();
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
  
  private void fL(View paramView)
  {
    AppMethodBeat.i(100357);
    this.idList.clear();
    this.Fce = -1L;
    paramView.setVisibility(0);
    this.FbV = null;
    if ((fkF()) && (this.Fcm))
    {
      if (!this.rIC) {
        break label98;
      }
      vE(false);
      fkA();
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
      vE(true);
    }
    invalidate();
    AppMethodBeat.o(100357);
  }
  
  private Point fM(View paramView)
  {
    AppMethodBeat.i(100360);
    int i = getPositionForView(paramView);
    int j = getColumnCount();
    paramView = new Point(i % j, i / j);
    AppMethodBeat.o(100360);
    return paramView;
  }
  
  @TargetApi(11)
  private void fkA()
  {
    AppMethodBeat.i(100334);
    int i = 0;
    if (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView != null) && (Boolean.TRUE != localView.getTag(2131299578)))
      {
        if (i % 2 != 0) {
          break label67;
        }
        fG(localView);
      }
      for (;;)
      {
        localView.setTag(2131299578, Boolean.TRUE);
        i += 1;
        break;
        label67:
        fH(localView);
      }
    }
    AppMethodBeat.o(100334);
  }
  
  private boolean fkB()
  {
    AppMethodBeat.i(100349);
    int i = JY(this.Fce);
    if (i != -1)
    {
      this.Fcq.aaj(i);
      if (this.Fcy == null)
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
      i = getPositionForView(this.Fcy);
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
      iU(i, j);
      if (this.Fcu) {
        this.Fcw.iV(i, j);
      }
      this.Eki = this.Fcb;
      this.Ekh = this.Fcc;
      if (!fkF()) {
        break label216;
      }
    }
    Object localObject;
    if (fkG()) {
      localObject = new b(0, 0);
    }
    for (;;)
    {
      JX(this.Fce);
      ((j)localObject).iW(i, j);
      AppMethodBeat.o(100349);
      return true;
      label216:
      if (fkG()) {
        localObject = new i(0, 0);
      } else {
        localObject = new c(0, 0);
      }
    }
  }
  
  private void fkC()
  {
    AppMethodBeat.i(100351);
    this.Fcg = p(this.FbW);
    AppMethodBeat.o(100351);
  }
  
  private void fkD()
  {
    AppMethodBeat.i(100354);
    this.Fcz.removeMessages(1);
    View localView = JZ(this.Fce);
    Rect localRect;
    if (this.FbW != null)
    {
      localRect = new Rect(this.FbW);
      localRect.offset(0, this.FbW.height() >>> 1);
    }
    for (;;)
    {
      if ((this.Fcq != null) && (this.Fcq.o(localRect)) && (fkB()))
      {
        this.FbV = null;
        fkH();
        if (this.Fcp != null) {
          this.Fcp.fkz();
        }
      }
      for (;;)
      {
        if (this.Fcq != null) {
          this.Fcq.fky();
        }
        AppMethodBeat.o(100354);
        return;
        if ((localView != null) && ((this.Fcf) || (this.Fci)))
        {
          this.Fcf = false;
          this.Fci = false;
          this.Fcg = false;
          this.mActivePointerId = -1;
          this.FbW.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          new StringBuilder("animating to  ").append(this.FbW);
          if (Build.VERSION.SDK_INT > 11)
          {
            fK(localView);
          }
          else
          {
            this.FbV.setBounds(this.FbW);
            invalidate();
            fL(localView);
          }
        }
        else
        {
          fkH();
        }
      }
      localRect = null;
    }
  }
  
  @TargetApi(11)
  private void fkE()
  {
    AppMethodBeat.i(100355);
    Object localObject = new TypeEvaluator()
    {
      private static int f(int paramAnonymousInt1, int paramAnonymousInt2, float paramAnonymousFloat)
      {
        return (int)(paramAnonymousInt1 + (paramAnonymousInt2 - paramAnonymousInt1) * paramAnonymousFloat);
      }
    };
    localObject = ObjectAnimator.ofObject(this.FbV, "bounds", (TypeEvaluator)localObject, new Object[] { this.FbW });
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
  
  static boolean fkF()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  private static boolean fkG()
  {
    return Build.VERSION.SDK_INT < 21;
  }
  
  private void fkH()
  {
    AppMethodBeat.i(100358);
    View localView = JZ(this.Fce);
    if (localView == null)
    {
      AppMethodBeat.o(100358);
      return;
    }
    if (this.Fcf) {
      fL(localView);
    }
    this.Fcf = false;
    this.Fcg = false;
    this.mActivePointerId = -1;
    AppMethodBeat.o(100358);
  }
  
  private void fkI()
  {
    AppMethodBeat.i(100359);
    int j = this.Fcb - this.Eki;
    int k = this.Fcc - this.Ekh;
    int m = this.FbX.centerY() + this.FbZ + j;
    int n = this.FbX.centerX() + this.Fca + k;
    this.Fcy = JZ(this.Fce);
    if (this.Fcy == null)
    {
      AppMethodBeat.o(100359);
      return;
    }
    Object localObject = null;
    float f2 = 0.0F;
    float f1 = 0.0F;
    Point localPoint1 = fM(this.Fcy);
    Iterator localIterator = this.idList.iterator();
    int i;
    if (localIterator.hasNext())
    {
      View localView = JZ(((Long)localIterator.next()).longValue());
      if (localView == null) {
        break label913;
      }
      Point localPoint2 = fM(localView);
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
                if ((i == 0) || (m >= localView.getBottom() - this.Fcd))
                {
                  if ((localPoint2.y <= localPoint1.y) || (localPoint2.x != localPoint1.x)) {
                    break label660;
                  }
                  i = 1;
                  if ((i == 0) || (m <= localView.getTop() + this.Fcd))
                  {
                    if ((localPoint2.y != localPoint1.y) || (localPoint2.x <= localPoint1.x)) {
                      break label666;
                    }
                    i = 1;
                    label501:
                    if ((i == 0) || (n <= localView.getLeft() + this.Fcd))
                    {
                      if ((localPoint2.y != localPoint1.y) || (localPoint2.x >= localPoint1.x)) {
                        break label672;
                      }
                      i = 1;
                      if ((i == 0) || (n >= localView.getRight() - this.Fcd)) {
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
        float f4 = Math.abs(f.fE(localView) - f.fE(this.Fcy));
        label403:
        label550:
        float f3 = Math.abs(f.fF(localView) - f.fF(this.Fcy));
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
        i = getPositionForView(this.Fcy);
        m = getPositionForView((View)localObject);
        new StringBuilder("switch ").append(i).append(",").append(m);
        localObject = getAdapterInterface();
        if ((m == -1) || (!((d)localObject).aag(i)) || (!((d)localObject).aag(m)))
        {
          JX(this.Fce);
          AppMethodBeat.o(100359);
          return;
        }
        iU(i, m);
        if (this.Fcu) {
          this.Fcw.iV(i, m);
        }
        this.Eki = this.Fcb;
        this.Ekh = this.Fcc;
        if ((!fkF()) || (!fkG())) {
          break label873;
        }
        localObject = new b(k, j);
      }
      for (;;)
      {
        JX(this.Fce);
        ((j)localObject).iW(i, m);
        AppMethodBeat.o(100359);
        return;
        label873:
        if (fkG()) {
          localObject = new i(k, j);
        } else {
          localObject = new c(k, j);
        }
      }
    }
  }
  
  @TargetApi(11)
  private static AnimatorSet g(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(100362);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { paramFloat1, 0.0F });
    paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramFloat2, 0.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, paramView });
    AppMethodBeat.o(100362);
    return localAnimatorSet;
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
  
  private void iU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100340);
    getAdapterInterface().iT(paramInt1, paramInt2);
    AppMethodBeat.o(100340);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(100336);
    super.setOnScrollListener(this.FcF);
    this.Fch = ((int)(paramContext.getResources().getDisplayMetrics().density * 8.0F + 0.5F));
    this.Fcd = getResources().getDimensionPixelSize(2131166177);
    AppMethodBeat.o(100336);
  }
  
  private boolean p(Rect paramRect)
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
      smoothScrollBy(-this.Fch, 0);
      AppMethodBeat.o(100352);
      return true;
    }
    if ((n + i1 >= j) && (i + k < m))
    {
      smoothScrollBy(this.Fch, 0);
      AppMethodBeat.o(100352);
      return true;
    }
    AppMethodBeat.o(100352);
    return false;
  }
  
  public final int JY(long paramLong)
  {
    AppMethodBeat.i(100345);
    View localView = JZ(paramLong);
    if (localView == null)
    {
      AppMethodBeat.o(100345);
      return -1;
    }
    int i = getPositionForView(localView);
    AppMethodBeat.o(100345);
    return i;
  }
  
  public final View JZ(long paramLong)
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
  
  public final void aak(int paramInt)
  {
    AppMethodBeat.i(100331);
    if (!this.Fcn)
    {
      AppMethodBeat.o(100331);
      return;
    }
    requestDisallowInterceptTouchEvent(true);
    if ((fkF()) && (this.Fcm)) {
      fkA();
    }
    if (paramInt != -1)
    {
      this.rIC = aal(paramInt);
      if (this.rIC) {
        this.Fcf = true;
      }
    }
    AppMethodBeat.o(100331);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(100363);
    super.dispatchDraw(paramCanvas);
    if (this.FbV != null) {
      this.FbV.draw(paramCanvas);
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
      this.FcB = paramMotionEvent.getX();
      this.FcC = paramMotionEvent.getY();
      this.FcA = f.a(this, paramMotionEvent.getX(), paramMotionEvent.getY());
      new StringBuilder("onTouchEvent ").append(paramMotionEvent.getAction()).append(",downPos ").append(this.FcA);
      Object localObject;
      if ((!this.Fck) && (this.FcA >= 0))
      {
        localObject = this.Fcz;
        ((d)localObject).removeMessages(1);
        ((d)localObject).sendEmptyMessageDelayed(1, 300L);
      }
      this.Fcb = -1;
      this.Fcc = -1;
      this.Ekh = ((int)paramMotionEvent.getX());
      this.Eki = ((int)paramMotionEvent.getY());
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      if ((this.rIC) && (isEnabled()))
      {
        layoutChildren();
        aal(pointToPosition(this.Ekh, this.Eki));
      }
      else if (!isEnabled())
      {
        AppMethodBeat.o(100348);
        return false;
        this.FcB = paramMotionEvent.getX();
        this.FcC = paramMotionEvent.getY();
        if ((this.Fcf) && (this.mActivePointerId != -1) && (i != -1)) {
          if ((this.Fcc == -1) && (this.Fcb == -1))
          {
            this.Fcb = ((int)paramMotionEvent.getY(i));
            this.Fcc = ((int)paramMotionEvent.getX(i));
            this.Ekh = this.Fcc;
            this.Eki = this.Fcb;
          }
          else
          {
            this.FcD = paramMotionEvent.getRawX();
            this.FcE = paramMotionEvent.getRawY();
            this.Fcb = ((int)paramMotionEvent.getY(i));
            this.Fcc = ((int)paramMotionEvent.getX(i));
            i = this.Fcb;
            int j = this.Eki;
            int k = this.Fcc;
            int m = this.Ekh;
            this.FbW.offsetTo(k - m + this.FbY.left + this.Fca, i - j + this.FbY.top + this.FbZ);
            if (this.FbV != null) {
              this.FbV.setBounds(this.FbW);
            }
            invalidate();
            fkI();
            this.Fcg = false;
            fkC();
            if (this.Fcq != null)
            {
              paramMotionEvent = new Rect(this.FbW);
              paramMotionEvent.offset(0, this.FbW.height() >>> 1);
              this.Fcq.n(paramMotionEvent);
            }
            AppMethodBeat.o(100348);
            return false;
            fkD();
            if ((this.Fcu) && (this.Fcw != null))
            {
              localObject = this.Fcw;
              Collections.reverse(((DynamicGridView.a)localObject).FcM);
              if (!((DynamicGridView.a)localObject).FcM.isEmpty())
              {
                this.Fcv.push(this.Fcw);
                this.Fcw = new DynamicGridView.a();
                continue;
                fkH();
                fkD();
                continue;
                if (paramMotionEvent.getPointerId((paramMotionEvent.getAction() & 0xFF00) >> 8) == this.mActivePointerId) {
                  fkD();
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
    this.Fcn = paramBoolean;
  }
  
  public void setOnDragListener(e parame)
  {
    this.Fcq = parame;
  }
  
  public void setOnDropListener(f paramf)
  {
    this.Fcp = paramf;
  }
  
  public void setOnEditModeChangeListener(g paramg)
  {
    this.Fcr = paramg;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(100332);
    this.Fcs = paramOnItemClickListener;
    super.setOnItemClickListener(this.Fct);
    AppMethodBeat.o(100332);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.Fco = paramOnScrollListener;
  }
  
  public void setOnSelectedItemBitmapCreationListener(h paramh)
  {
    this.Fcx = paramh;
  }
  
  public void setUndoSupportEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(100333);
    if (this.Fcu != paramBoolean) {
      if (!paramBoolean) {
        break label41;
      }
    }
    label41:
    for (this.Fcv = new Stack();; this.Fcv = null)
    {
      this.Fcu = paramBoolean;
      AppMethodBeat.o(100333);
      return;
    }
  }
  
  public void setWobbleInEditMode(boolean paramBoolean)
  {
    this.Fcm = paramBoolean;
  }
  
  @TargetApi(11)
  final void vE(boolean paramBoolean)
  {
    AppMethodBeat.i(100335);
    Object localObject = this.Fcj.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Animator)((Iterator)localObject).next()).cancel();
    }
    this.Fcj.clear();
    int i = 0;
    while (i < getChildCount())
    {
      localObject = getChildAt(i);
      if (localObject != null)
      {
        if (paramBoolean) {
          ((View)localObject).setRotation(0.0F);
        }
        ((View)localObject).setTag(2131299578, Boolean.FALSE);
      }
      i += 1;
    }
    AppMethodBeat.o(100335);
  }
  
  final class b
    implements DynamicGridView.j
  {
    private int Bi;
    private int Bj;
    
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
      this.Bi = paramInt1;
      this.Bj = paramInt2;
    }
    
    public final void iW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100322);
      if ((!$assertionsDisabled) && (DynamicGridView.g(DynamicGridView.this) == null))
      {
        AssertionError localAssertionError = new AssertionError();
        AppMethodBeat.o(100322);
        throw localAssertionError;
      }
      DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(DynamicGridView.g(DynamicGridView.this), paramInt1, paramInt2));
      DynamicGridView.b(DynamicGridView.this, DynamicGridView.this.JZ(DynamicGridView.h(DynamicGridView.this)));
      AppMethodBeat.o(100322);
    }
    
    final class a
      implements ViewTreeObserver.OnPreDrawListener
    {
      private final View FcN;
      private final int FcO;
      private final int atO;
      
      a(View paramView, int paramInt1, int paramInt2)
      {
        this.FcN = paramView;
        this.FcO = paramInt1;
        this.atO = paramInt2;
      }
      
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(100321);
        DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
        DynamicGridView.a(DynamicGridView.this, DynamicGridView.e(DynamicGridView.this) + DynamicGridView.b.a(DynamicGridView.b.this));
        DynamicGridView.b(DynamicGridView.this, DynamicGridView.f(DynamicGridView.this) + DynamicGridView.b.b(DynamicGridView.b.this));
        DynamicGridView.a(DynamicGridView.this, this.FcO, this.atO);
        this.FcN.setVisibility(0);
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
    int Bi;
    int Bj;
    
    public c(int paramInt1, int paramInt2)
    {
      this.Bi = paramInt1;
      this.Bj = paramInt2;
    }
    
    public final void iW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100326);
      DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(paramInt1, paramInt2));
      AppMethodBeat.o(100326);
    }
    
    final class a
      implements ViewTreeObserver.OnPreDrawListener
    {
      private final int FcO;
      private final int atO;
      
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
        this.FcO = paramInt1;
        this.atO = paramInt2;
      }
      
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(100324);
        DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
        DynamicGridView.a(DynamicGridView.this, DynamicGridView.e(DynamicGridView.this) + DynamicGridView.c.this.Bj);
        DynamicGridView.b(DynamicGridView.this, DynamicGridView.f(DynamicGridView.this) + DynamicGridView.c.this.Bi);
        DynamicGridView.a(DynamicGridView.this, this.FcO, this.atO);
        new StringBuilder("id ").append(DynamicGridView.this.JY(DynamicGridView.h(DynamicGridView.this)));
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
        DynamicGridView.b(DynamicGridView.this, DynamicGridView.this.JZ(DynamicGridView.h(DynamicGridView.this)));
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
        View localView = paramMessage.getChildAt(paramMessage.FcA);
        new StringBuilder("downView ").append(localView).append(",downPos ").append(paramMessage.FcA).append(",lastTouchX ").append(paramMessage.FcB).append(",lastTouchY ").append(paramMessage.FcC);
        if ((!paramMessage.Fck) && (!paramMessage.Fcl) && (f.f(localView, paramMessage.FcB, paramMessage.FcC))) {
          paramMessage.aak(paramMessage.FcA);
        }
      }
    }
  }
  
  public static abstract interface e
  {
    public abstract void aai(int paramInt);
    
    public abstract void aaj(int paramInt);
    
    public abstract void fky();
    
    public abstract void n(Rect paramRect);
    
    public abstract boolean o(Rect paramRect);
  }
  
  public static abstract interface f
  {
    public abstract void fkz();
  }
  
  public static abstract interface g {}
  
  public static abstract interface h {}
  
  final class i
    implements DynamicGridView.j
  {
    private int Bi;
    private int Bj;
    
    public i(int paramInt1, int paramInt2)
    {
      this.Bi = paramInt1;
      this.Bj = paramInt2;
    }
    
    public final void iW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100328);
      DynamicGridView.a(DynamicGridView.this, DynamicGridView.e(DynamicGridView.this) + this.Bj);
      DynamicGridView.b(DynamicGridView.this, DynamicGridView.f(DynamicGridView.this) + this.Bi);
      AppMethodBeat.o(100328);
    }
  }
  
  static abstract interface j
  {
    public abstract void iW(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView
 * JD-Core Version:    0.7.0.1
 */