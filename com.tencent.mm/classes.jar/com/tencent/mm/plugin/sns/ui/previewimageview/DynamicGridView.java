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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DynamicGridView
  extends WrappingGridView
{
  private List<Long> idList;
  private int mActivePointerId;
  private int mScrollState;
  boolean pGX;
  private BitmapDrawable zhR;
  private Rect zhS;
  private Rect zhT;
  private Rect zhU;
  private int zhV;
  private int zhW;
  private int zhX;
  private int zhY;
  private int zhZ;
  float ziA;
  private float ziB;
  private float ziC;
  private AbsListView.OnScrollListener ziD;
  private int zia;
  private int zib;
  private long zic;
  private boolean zid;
  private boolean zie;
  private int zif;
  private boolean zig;
  private List<ObjectAnimator> zih;
  boolean zii;
  boolean zij;
  boolean zik;
  private boolean zil;
  private AbsListView.OnScrollListener zim;
  private f zin;
  private e zio;
  private g zip;
  private AdapterView.OnItemClickListener ziq;
  private AdapterView.OnItemClickListener zir;
  private boolean zis;
  private Stack<DynamicGridView.a> zit;
  private DynamicGridView.a ziu;
  private h ziv;
  private View ziw;
  d zix;
  int ziy;
  float ziz;
  
  public DynamicGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100329);
    this.zhV = 0;
    this.zhW = 0;
    this.zhX = -1;
    this.zhY = -1;
    this.zhZ = -1;
    this.zia = -1;
    this.idList = new ArrayList();
    this.zic = -1L;
    this.zid = false;
    this.mActivePointerId = -1;
    this.zif = 0;
    this.zig = false;
    this.mScrollState = 0;
    this.pGX = false;
    this.zih = new LinkedList();
    this.zik = true;
    this.zil = true;
    this.zir = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100305);
        if ((!DynamicGridView.this.pGX) && (DynamicGridView.this.isEnabled()) && (DynamicGridView.a(DynamicGridView.this) != null)) {
          DynamicGridView.a(DynamicGridView.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        AppMethodBeat.o(100305);
      }
    };
    this.zix = new d((byte)0);
    this.ziy = -1;
    this.ziD = new AbsListView.OnScrollListener()
    {
      private int fuH;
      private int ziF = -1;
      private int ziG = -1;
      private int ziH;
      private int ziI;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(100306);
        this.ziH = paramAnonymousInt1;
        this.ziI = paramAnonymousInt2;
        int i;
        label49:
        label212:
        View localView;
        if (this.ziF == -1)
        {
          i = this.ziH;
          this.ziF = i;
          if (this.ziG != -1) {
            break label305;
          }
          i = this.ziI;
          this.ziG = i;
          if ((this.ziH != this.ziF) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          if ((this.ziH + this.ziI != this.ziF + this.ziG) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          this.ziF = this.ziH;
          this.ziG = this.ziI;
          if ((!DynamicGridView.dSg()) || (!DynamicGridView.i(DynamicGridView.this))) {
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
          i = this.ziF;
          break;
          label305:
          i = this.ziG;
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
        this.fuH = paramAnonymousInt;
        DynamicGridView.c(DynamicGridView.this, paramAnonymousInt);
        if ((this.ziI > 0) && (this.fuH == 0))
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
    this.zhV = 0;
    this.zhW = 0;
    this.zhX = -1;
    this.zhY = -1;
    this.zhZ = -1;
    this.zia = -1;
    this.idList = new ArrayList();
    this.zic = -1L;
    this.zid = false;
    this.mActivePointerId = -1;
    this.zif = 0;
    this.zig = false;
    this.mScrollState = 0;
    this.pGX = false;
    this.zih = new LinkedList();
    this.zik = true;
    this.zil = true;
    this.zir = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100305);
        if ((!DynamicGridView.this.pGX) && (DynamicGridView.this.isEnabled()) && (DynamicGridView.a(DynamicGridView.this) != null)) {
          DynamicGridView.a(DynamicGridView.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        AppMethodBeat.o(100305);
      }
    };
    this.zix = new d((byte)0);
    this.ziy = -1;
    this.ziD = new AbsListView.OnScrollListener()
    {
      private int fuH;
      private int ziF = -1;
      private int ziG = -1;
      private int ziH;
      private int ziI;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(100306);
        this.ziH = paramAnonymousInt1;
        this.ziI = paramAnonymousInt2;
        int i;
        label49:
        label212:
        View localView;
        if (this.ziF == -1)
        {
          i = this.ziH;
          this.ziF = i;
          if (this.ziG != -1) {
            break label305;
          }
          i = this.ziI;
          this.ziG = i;
          if ((this.ziH != this.ziF) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          if ((this.ziH + this.ziI != this.ziF + this.ziG) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          this.ziF = this.ziH;
          this.ziG = this.ziI;
          if ((!DynamicGridView.dSg()) || (!DynamicGridView.i(DynamicGridView.this))) {
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
          i = this.ziF;
          break;
          label305:
          i = this.ziG;
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
        this.fuH = paramAnonymousInt;
        DynamicGridView.c(DynamicGridView.this, paramAnonymousInt);
        if ((this.ziI > 0) && (this.fuH == 0))
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
  
  private boolean PZ(int paramInt)
  {
    AppMethodBeat.i(100350);
    if (!getAdapterInterface().PT(paramInt))
    {
      AppMethodBeat.o(100350);
      return false;
    }
    this.zhV = 0;
    this.zhW = 0;
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null)
    {
      this.zic = getAdapter().getItemId(paramInt);
      this.zhR = ff(localView);
      dSb();
      if (dSc()) {
        localView.setVisibility(4);
      }
      xW(this.zic);
      if (this.zio != null) {
        this.zio.PW(paramInt);
      }
      AppMethodBeat.o(100350);
      return true;
    }
    AppMethodBeat.o(100350);
    return false;
  }
  
  private long Qa(int paramInt)
  {
    AppMethodBeat.i(100361);
    long l = getAdapter().getItemId(paramInt);
    AppMethodBeat.o(100361);
    return l;
  }
  
  @TargetApi(11)
  private void dRX()
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
        fc(localView);
      }
      for (;;)
      {
        localView.setTag(2131299072, Boolean.TRUE);
        i += 1;
        break;
        label67:
        fd(localView);
      }
    }
    AppMethodBeat.o(100334);
  }
  
  private boolean dRY()
  {
    AppMethodBeat.i(100349);
    int i = xX(this.zic);
    if (i != -1)
    {
      this.zio.PX(i);
      if (this.ziw == null)
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
      i = getPositionForView(this.ziw);
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
      hF(i, j);
      if (this.zis) {
        this.ziu.hG(i, j);
      }
      this.zhY = this.zhZ;
      this.zhX = this.zia;
      if (!dSc()) {
        break label216;
      }
    }
    Object localObject;
    if (dSd()) {
      localObject = new b(0, 0);
    }
    for (;;)
    {
      xW(this.zic);
      ((j)localObject).hH(i, j);
      AppMethodBeat.o(100349);
      return true;
      label216:
      if (dSd()) {
        localObject = new i(0, 0);
      } else {
        localObject = new c(0, 0);
      }
    }
  }
  
  private void dRZ()
  {
    AppMethodBeat.i(100351);
    this.zie = q(this.zhS);
    AppMethodBeat.o(100351);
  }
  
  private void dSa()
  {
    AppMethodBeat.i(100354);
    this.zix.removeMessages(1);
    View localView = xY(this.zic);
    Rect localRect;
    if (this.zhS != null)
    {
      localRect = new Rect(this.zhS);
      localRect.offset(0, this.zhS.height() >>> 1);
    }
    for (;;)
    {
      if ((this.zio != null) && (this.zio.p(localRect)) && (dRY()))
      {
        this.zhR = null;
        dSe();
        if (this.zin != null) {
          this.zin.dRW();
        }
      }
      for (;;)
      {
        if (this.zio != null) {
          this.zio.dRV();
        }
        AppMethodBeat.o(100354);
        return;
        if ((localView != null) && ((this.zid) || (this.zig)))
        {
          this.zid = false;
          this.zig = false;
          this.zie = false;
          this.mActivePointerId = -1;
          this.zhS.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          new StringBuilder("animating to  ").append(this.zhS);
          if (Build.VERSION.SDK_INT > 11)
          {
            fg(localView);
          }
          else
          {
            this.zhR.setBounds(this.zhS);
            invalidate();
            fh(localView);
          }
        }
        else
        {
          dSe();
        }
      }
      localRect = null;
    }
  }
  
  @TargetApi(11)
  private void dSb()
  {
    AppMethodBeat.i(100355);
    Object localObject = new TypeEvaluator()
    {
      private static int e(int paramAnonymousInt1, int paramAnonymousInt2, float paramAnonymousFloat)
      {
        return (int)(paramAnonymousInt1 + (paramAnonymousInt2 - paramAnonymousInt1) * paramAnonymousFloat);
      }
    };
    localObject = ObjectAnimator.ofObject(this.zhR, "bounds", (TypeEvaluator)localObject, new Object[] { this.zhS });
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
  
  static boolean dSc()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  private static boolean dSd()
  {
    return Build.VERSION.SDK_INT < 21;
  }
  
  private void dSe()
  {
    AppMethodBeat.i(100358);
    View localView = xY(this.zic);
    if (localView == null)
    {
      AppMethodBeat.o(100358);
      return;
    }
    if (this.zid) {
      fh(localView);
    }
    this.zid = false;
    this.zie = false;
    this.mActivePointerId = -1;
    AppMethodBeat.o(100358);
  }
  
  private void dSf()
  {
    AppMethodBeat.i(100359);
    int j = this.zhZ - this.zhY;
    int k = this.zia - this.zhX;
    int m = this.zhT.centerY() + this.zhV + j;
    int n = this.zhT.centerX() + this.zhW + k;
    this.ziw = xY(this.zic);
    if (this.ziw == null)
    {
      AppMethodBeat.o(100359);
      return;
    }
    Object localObject = null;
    float f2 = 0.0F;
    float f1 = 0.0F;
    Point localPoint1 = fi(this.ziw);
    Iterator localIterator = this.idList.iterator();
    int i;
    if (localIterator.hasNext())
    {
      View localView = xY(((Long)localIterator.next()).longValue());
      if (localView == null) {
        break label913;
      }
      Point localPoint2 = fi(localView);
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
                if ((i == 0) || (m >= localView.getBottom() - this.zib))
                {
                  if ((localPoint2.y <= localPoint1.y) || (localPoint2.x != localPoint1.x)) {
                    break label660;
                  }
                  i = 1;
                  if ((i == 0) || (m <= localView.getTop() + this.zib))
                  {
                    if ((localPoint2.y != localPoint1.y) || (localPoint2.x <= localPoint1.x)) {
                      break label666;
                    }
                    i = 1;
                    label501:
                    if ((i == 0) || (n <= localView.getLeft() + this.zib))
                    {
                      if ((localPoint2.y != localPoint1.y) || (localPoint2.x >= localPoint1.x)) {
                        break label672;
                      }
                      i = 1;
                      if ((i == 0) || (n >= localView.getRight() - this.zib)) {
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
        float f4 = Math.abs(f.fa(localView) - f.fa(this.ziw));
        label403:
        label550:
        float f3 = Math.abs(f.fb(localView) - f.fb(this.ziw));
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
        i = getPositionForView(this.ziw);
        m = getPositionForView((View)localObject);
        new StringBuilder("switch ").append(i).append(",").append(m);
        localObject = getAdapterInterface();
        if ((m == -1) || (!((d)localObject).PU(i)) || (!((d)localObject).PU(m)))
        {
          xW(this.zic);
          AppMethodBeat.o(100359);
          return;
        }
        hF(i, m);
        if (this.zis) {
          this.ziu.hG(i, m);
        }
        this.zhY = this.zhZ;
        this.zhX = this.zia;
        if ((!dSc()) || (!dSd())) {
          break label873;
        }
        localObject = new b(k, j);
      }
      for (;;)
      {
        xW(this.zic);
        ((j)localObject).hH(i, m);
        AppMethodBeat.o(100359);
        return;
        label873:
        if (dSd()) {
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
  private void fc(View paramView)
  {
    AppMethodBeat.i(100337);
    paramView = fe(paramView);
    paramView.setFloatValues(new float[] { -2.0F, 2.0F });
    paramView.start();
    this.zih.add(paramView);
    AppMethodBeat.o(100337);
  }
  
  @TargetApi(11)
  private void fd(View paramView)
  {
    AppMethodBeat.i(100338);
    paramView = fe(paramView);
    paramView.setFloatValues(new float[] { 2.0F, -2.0F });
    paramView.start();
    this.zih.add(paramView);
    AppMethodBeat.o(100338);
  }
  
  @TargetApi(11)
  private ObjectAnimator fe(final View paramView)
  {
    AppMethodBeat.i(100339);
    if (!dSd()) {
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
  
  private BitmapDrawable ff(View paramView)
  {
    AppMethodBeat.i(100343);
    int j = paramView.getWidth();
    int i = paramView.getHeight();
    int k = paramView.getTop();
    int m = paramView.getLeft();
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas(localBitmap));
    paramView = new BitmapDrawable(getResources(), localBitmap);
    this.zhT = new Rect(m, k, m + j, k + i);
    k = this.zhT.left;
    m = (int)(j * 0.05F);
    int n = this.zhT.top;
    int i1 = (int)(i * 0.05F);
    int i2 = this.zhT.right;
    j = (int)(j * 0.05F);
    int i3 = this.zhT.bottom;
    this.zhS = new Rect(k - m, n - i1, j + i2, (int)(i * 0.05F) + i3);
    this.zhU = new Rect(this.zhS);
    paramView.setBounds(this.zhT);
    AppMethodBeat.o(100343);
    return paramView;
  }
  
  @TargetApi(11)
  private void fg(final View paramView)
  {
    AppMethodBeat.i(100356);
    Object localObject = new TypeEvaluator()
    {
      private static int e(int paramAnonymousInt1, int paramAnonymousInt2, float paramAnonymousFloat)
      {
        return (int)(paramAnonymousInt1 + (paramAnonymousInt2 - paramAnonymousInt1) * paramAnonymousFloat);
      }
    };
    localObject = ObjectAnimator.ofObject(this.zhR, "bounds", (TypeEvaluator)localObject, new Object[] { this.zhS });
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
          DynamicGridView.d(DynamicGridView.this).dRW();
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
  
  private void fh(View paramView)
  {
    AppMethodBeat.i(100357);
    this.idList.clear();
    this.zic = -1L;
    paramView.setVisibility(0);
    this.zhR = null;
    if ((dSc()) && (this.zik))
    {
      if (!this.pGX) {
        break label98;
      }
      rv(false);
      dRX();
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
      rv(true);
    }
    invalidate();
    AppMethodBeat.o(100357);
  }
  
  private Point fi(View paramView)
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
  
  private void hF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100340);
    getAdapterInterface().hE(paramInt1, paramInt2);
    AppMethodBeat.o(100340);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(100336);
    super.setOnScrollListener(this.ziD);
    this.zif = ((int)(paramContext.getResources().getDisplayMetrics().density * 8.0F + 0.5F));
    this.zib = getResources().getDimensionPixelSize(2131166136);
    AppMethodBeat.o(100336);
  }
  
  private boolean q(Rect paramRect)
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
      smoothScrollBy(-this.zif, 0);
      AppMethodBeat.o(100352);
      return true;
    }
    if ((n + i1 >= j) && (i + k < m))
    {
      smoothScrollBy(this.zif, 0);
      AppMethodBeat.o(100352);
      return true;
    }
    AppMethodBeat.o(100352);
    return false;
  }
  
  private void xW(long paramLong)
  {
    AppMethodBeat.i(100344);
    this.idList.clear();
    int j = xX(paramLong);
    int i = getFirstVisiblePosition();
    while (i <= getLastVisiblePosition())
    {
      if ((j != i) && (getAdapterInterface().PU(i))) {
        this.idList.add(Long.valueOf(Qa(i)));
      }
      i += 1;
    }
    AppMethodBeat.o(100344);
  }
  
  public final void PY(int paramInt)
  {
    AppMethodBeat.i(100331);
    if (!this.zil)
    {
      AppMethodBeat.o(100331);
      return;
    }
    requestDisallowInterceptTouchEvent(true);
    if ((dSc()) && (this.zik)) {
      dRX();
    }
    if (paramInt != -1)
    {
      this.pGX = PZ(paramInt);
      if (this.pGX) {
        this.zid = true;
      }
    }
    AppMethodBeat.o(100331);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(100363);
    super.dispatchDraw(paramCanvas);
    if (this.zhR != null) {
      this.zhR.draw(paramCanvas);
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
      this.ziz = paramMotionEvent.getX();
      this.ziA = paramMotionEvent.getY();
      this.ziy = f.a(this, paramMotionEvent.getX(), paramMotionEvent.getY());
      new StringBuilder("onTouchEvent ").append(paramMotionEvent.getAction()).append(",downPos ").append(this.ziy);
      Object localObject;
      if ((!this.zii) && (this.ziy >= 0))
      {
        localObject = this.zix;
        ((d)localObject).removeMessages(1);
        ((d)localObject).sendEmptyMessageDelayed(1, 300L);
      }
      this.zhZ = -1;
      this.zia = -1;
      this.zhX = ((int)paramMotionEvent.getX());
      this.zhY = ((int)paramMotionEvent.getY());
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      if ((this.pGX) && (isEnabled()))
      {
        layoutChildren();
        PZ(pointToPosition(this.zhX, this.zhY));
      }
      else if (!isEnabled())
      {
        AppMethodBeat.o(100348);
        return false;
        this.ziz = paramMotionEvent.getX();
        this.ziA = paramMotionEvent.getY();
        if ((this.zid) && (this.mActivePointerId != -1) && (i != -1)) {
          if ((this.zia == -1) && (this.zhZ == -1))
          {
            this.zhZ = ((int)paramMotionEvent.getY(i));
            this.zia = ((int)paramMotionEvent.getX(i));
            this.zhX = this.zia;
            this.zhY = this.zhZ;
          }
          else
          {
            this.ziB = paramMotionEvent.getRawX();
            this.ziC = paramMotionEvent.getRawY();
            this.zhZ = ((int)paramMotionEvent.getY(i));
            this.zia = ((int)paramMotionEvent.getX(i));
            i = this.zhZ;
            int j = this.zhY;
            int k = this.zia;
            int m = this.zhX;
            this.zhS.offsetTo(k - m + this.zhU.left + this.zhW, i - j + this.zhU.top + this.zhV);
            if (this.zhR != null) {
              this.zhR.setBounds(this.zhS);
            }
            invalidate();
            dSf();
            this.zie = false;
            dRZ();
            if (this.zio != null)
            {
              paramMotionEvent = new Rect(this.zhS);
              paramMotionEvent.offset(0, this.zhS.height() >>> 1);
              this.zio.o(paramMotionEvent);
            }
            AppMethodBeat.o(100348);
            return false;
            dSa();
            if ((this.zis) && (this.ziu != null))
            {
              localObject = this.ziu;
              Collections.reverse(((DynamicGridView.a)localObject).ziK);
              if (!((DynamicGridView.a)localObject).ziK.isEmpty())
              {
                this.zit.push(this.ziu);
                this.ziu = new DynamicGridView.a();
                continue;
                dSe();
                dSa();
                continue;
                if (paramMotionEvent.getPointerId((paramMotionEvent.getAction() & 0xFF00) >> 8) == this.mActivePointerId) {
                  dSa();
                }
              }
            }
          }
        }
      }
    }
  }
  
  @TargetApi(11)
  final void rv(boolean paramBoolean)
  {
    AppMethodBeat.i(100335);
    Object localObject = this.zih.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Animator)((Iterator)localObject).next()).cancel();
    }
    this.zih.clear();
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
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(100353);
    super.setAdapter(paramListAdapter);
    AppMethodBeat.o(100353);
  }
  
  public void setEditModeEnabled(boolean paramBoolean)
  {
    this.zil = paramBoolean;
  }
  
  public void setOnDragListener(e parame)
  {
    this.zio = parame;
  }
  
  public void setOnDropListener(f paramf)
  {
    this.zin = paramf;
  }
  
  public void setOnEditModeChangeListener(g paramg)
  {
    this.zip = paramg;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(100332);
    this.ziq = paramOnItemClickListener;
    super.setOnItemClickListener(this.zir);
    AppMethodBeat.o(100332);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.zim = paramOnScrollListener;
  }
  
  public void setOnSelectedItemBitmapCreationListener(h paramh)
  {
    this.ziv = paramh;
  }
  
  public void setUndoSupportEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(100333);
    if (this.zis != paramBoolean) {
      if (!paramBoolean) {
        break label41;
      }
    }
    label41:
    for (this.zit = new Stack();; this.zit = null)
    {
      this.zis = paramBoolean;
      AppMethodBeat.o(100333);
      return;
    }
  }
  
  public void setWobbleInEditMode(boolean paramBoolean)
  {
    this.zik = paramBoolean;
  }
  
  public final int xX(long paramLong)
  {
    AppMethodBeat.i(100345);
    View localView = xY(paramLong);
    if (localView == null)
    {
      AppMethodBeat.o(100345);
      return -1;
    }
    int i = getPositionForView(localView);
    AppMethodBeat.o(100345);
    return i;
  }
  
  public final View xY(long paramLong)
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
    private int zk;
    private int zl;
    
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
      this.zk = paramInt1;
      this.zl = paramInt2;
    }
    
    public final void hH(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100322);
      if ((!$assertionsDisabled) && (DynamicGridView.g(DynamicGridView.this) == null))
      {
        AssertionError localAssertionError = new AssertionError();
        AppMethodBeat.o(100322);
        throw localAssertionError;
      }
      DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(DynamicGridView.g(DynamicGridView.this), paramInt1, paramInt2));
      DynamicGridView.b(DynamicGridView.this, DynamicGridView.this.xY(DynamicGridView.h(DynamicGridView.this)));
      AppMethodBeat.o(100322);
    }
    
    final class a
      implements ViewTreeObserver.OnPreDrawListener
    {
      private final int arZ;
      private final View ziL;
      private final int ziM;
      
      a(View paramView, int paramInt1, int paramInt2)
      {
        this.ziL = paramView;
        this.ziM = paramInt1;
        this.arZ = paramInt2;
      }
      
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(100321);
        DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
        DynamicGridView.a(DynamicGridView.this, DynamicGridView.e(DynamicGridView.this) + DynamicGridView.b.a(DynamicGridView.b.this));
        DynamicGridView.b(DynamicGridView.this, DynamicGridView.f(DynamicGridView.this) + DynamicGridView.b.b(DynamicGridView.b.this));
        DynamicGridView.a(DynamicGridView.this, this.ziM, this.arZ);
        this.ziL.setVisibility(0);
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
    int zk;
    int zl;
    
    public c(int paramInt1, int paramInt2)
    {
      this.zk = paramInt1;
      this.zl = paramInt2;
    }
    
    public final void hH(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100326);
      DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(paramInt1, paramInt2));
      AppMethodBeat.o(100326);
    }
    
    final class a
      implements ViewTreeObserver.OnPreDrawListener
    {
      private final int arZ;
      private final int ziM;
      
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
        this.ziM = paramInt1;
        this.arZ = paramInt2;
      }
      
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(100324);
        DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
        DynamicGridView.a(DynamicGridView.this, DynamicGridView.e(DynamicGridView.this) + DynamicGridView.c.this.zl);
        DynamicGridView.b(DynamicGridView.this, DynamicGridView.f(DynamicGridView.this) + DynamicGridView.c.this.zk);
        DynamicGridView.a(DynamicGridView.this, this.ziM, this.arZ);
        new StringBuilder("id ").append(DynamicGridView.this.xX(DynamicGridView.h(DynamicGridView.this)));
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
        DynamicGridView.b(DynamicGridView.this, DynamicGridView.this.xY(DynamicGridView.h(DynamicGridView.this)));
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
        View localView = paramMessage.getChildAt(paramMessage.ziy);
        new StringBuilder("downView ").append(localView).append(",downPos ").append(paramMessage.ziy).append(",lastTouchX ").append(paramMessage.ziz).append(",lastTouchY ").append(paramMessage.ziA);
        if ((!paramMessage.zii) && (!paramMessage.zij) && (f.e(localView, paramMessage.ziz, paramMessage.ziA))) {
          paramMessage.PY(paramMessage.ziy);
        }
      }
    }
  }
  
  public static abstract interface e
  {
    public abstract void PW(int paramInt);
    
    public abstract void PX(int paramInt);
    
    public abstract void dRV();
    
    public abstract void o(Rect paramRect);
    
    public abstract boolean p(Rect paramRect);
  }
  
  public static abstract interface f
  {
    public abstract void dRW();
  }
  
  public static abstract interface g {}
  
  public static abstract interface h {}
  
  final class i
    implements DynamicGridView.j
  {
    private int zk;
    private int zl;
    
    public i(int paramInt1, int paramInt2)
    {
      this.zk = paramInt1;
      this.zl = paramInt2;
    }
    
    public final void hH(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100328);
      DynamicGridView.a(DynamicGridView.this, DynamicGridView.e(DynamicGridView.this) + this.zl);
      DynamicGridView.b(DynamicGridView.this, DynamicGridView.f(DynamicGridView.this) + this.zk);
      AppMethodBeat.o(100328);
    }
  }
  
  static abstract interface j
  {
    public abstract void hH(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView
 * JD-Core Version:    0.7.0.1
 */