package com.tencent.mm.ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.LinkedList;
import java.util.Queue;

public class MMHorList
  extends AdapterView<ListAdapter>
{
  private a JGf;
  private int JGg;
  private int JGh;
  private int JGi;
  private int JGj;
  private Queue<View> JGk;
  private boolean JGl;
  private boolean JGm;
  protected Scroller JGn;
  private GestureDetector JGo;
  private AdapterView.OnItemSelectedListener JGp;
  private AdapterView.OnItemClickListener JGq;
  private ListAdapter JGr;
  private Runnable JGs;
  private boolean JGt;
  private boolean JGu;
  private int JGv;
  private int JGw;
  private boolean JGx;
  private DataSetObserver JGy;
  private GestureDetector.OnGestureListener JGz;
  private int offset;
  private int oxl;
  private boolean wCD;
  
  public MMHorList(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142011);
    this.JGj = 536870912;
    this.JGk = new LinkedList();
    this.JGl = false;
    this.JGm = false;
    this.JGs = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142002);
        MMHorList.this.requestLayout();
        AppMethodBeat.o(142002);
      }
    };
    this.JGt = false;
    this.JGu = false;
    this.JGv = 0;
    this.JGw = 0;
    this.wCD = false;
    this.JGx = false;
    this.JGy = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(142003);
        MMHorList.a(MMHorList.this);
        MMHorList.this.invalidate();
        MMHorList.this.requestLayout();
        AppMethodBeat.o(142003);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(142004);
        MMHorList.b(MMHorList.this);
        MMHorList.this.invalidate();
        MMHorList.this.requestLayout();
        AppMethodBeat.o(142004);
      }
    };
    this.JGz = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(193722);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(193722);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(193721);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(193721);
        return bool;
      }
      
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(142005);
        boolean bool = MMHorList.this.fCt();
        AppMethodBeat.o(142005);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(142006);
        boolean bool = MMHorList.this.bP(paramAnonymousFloat1);
        AppMethodBeat.o(142006);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(193720);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(193720);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(142007);
        MMHorList.a(MMHorList.this, MMHorList.c(MMHorList.this) + (int)paramAnonymousFloat1);
        MMHorList.this.requestLayout();
        AppMethodBeat.o(142007);
        return true;
      }
      
      public final boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(142008);
        Rect localRect = new Rect();
        int i = 0;
        for (;;)
        {
          if (i < MMHorList.this.getChildCount())
          {
            View localView = MMHorList.this.getChildAt(i);
            int j = localView.getLeft();
            int k = localView.getRight();
            localRect.set(j, localView.getTop(), k, localView.getBottom());
            if (!localRect.contains((int)paramAnonymousMotionEvent.getX(), (int)paramAnonymousMotionEvent.getY())) {
              break label217;
            }
            if (MMHorList.d(MMHorList.this) != null) {
              MMHorList.d(MMHorList.this).onItemClick(MMHorList.this, localView, MMHorList.e(MMHorList.this) + 1 + i, MMHorList.f(MMHorList.this).getItemId(MMHorList.e(MMHorList.this) + 1 + i));
            }
            if (MMHorList.g(MMHorList.this) != null) {
              MMHorList.g(MMHorList.this).onItemSelected(MMHorList.this, localView, MMHorList.e(MMHorList.this) + 1 + i, MMHorList.f(MMHorList.this).getItemId(MMHorList.e(MMHorList.this) + 1 + i));
            }
          }
          AppMethodBeat.o(142008);
          return true;
          label217:
          i += 1;
        }
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(193719);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(193719);
        return bool;
      }
    };
    init();
    AppMethodBeat.o(142011);
  }
  
  public MMHorList(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142010);
    this.JGj = 536870912;
    this.JGk = new LinkedList();
    this.JGl = false;
    this.JGm = false;
    this.JGs = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142002);
        MMHorList.this.requestLayout();
        AppMethodBeat.o(142002);
      }
    };
    this.JGt = false;
    this.JGu = false;
    this.JGv = 0;
    this.JGw = 0;
    this.wCD = false;
    this.JGx = false;
    this.JGy = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(142003);
        MMHorList.a(MMHorList.this);
        MMHorList.this.invalidate();
        MMHorList.this.requestLayout();
        AppMethodBeat.o(142003);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(142004);
        MMHorList.b(MMHorList.this);
        MMHorList.this.invalidate();
        MMHorList.this.requestLayout();
        AppMethodBeat.o(142004);
      }
    };
    this.JGz = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(193722);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(193722);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(193721);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(193721);
        return bool;
      }
      
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(142005);
        boolean bool = MMHorList.this.fCt();
        AppMethodBeat.o(142005);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(142006);
        boolean bool = MMHorList.this.bP(paramAnonymousFloat1);
        AppMethodBeat.o(142006);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(193720);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(193720);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(142007);
        MMHorList.a(MMHorList.this, MMHorList.c(MMHorList.this) + (int)paramAnonymousFloat1);
        MMHorList.this.requestLayout();
        AppMethodBeat.o(142007);
        return true;
      }
      
      public final boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(142008);
        Rect localRect = new Rect();
        int i = 0;
        for (;;)
        {
          if (i < MMHorList.this.getChildCount())
          {
            View localView = MMHorList.this.getChildAt(i);
            int j = localView.getLeft();
            int k = localView.getRight();
            localRect.set(j, localView.getTop(), k, localView.getBottom());
            if (!localRect.contains((int)paramAnonymousMotionEvent.getX(), (int)paramAnonymousMotionEvent.getY())) {
              break label217;
            }
            if (MMHorList.d(MMHorList.this) != null) {
              MMHorList.d(MMHorList.this).onItemClick(MMHorList.this, localView, MMHorList.e(MMHorList.this) + 1 + i, MMHorList.f(MMHorList.this).getItemId(MMHorList.e(MMHorList.this) + 1 + i));
            }
            if (MMHorList.g(MMHorList.this) != null) {
              MMHorList.g(MMHorList.this).onItemSelected(MMHorList.this, localView, MMHorList.e(MMHorList.this) + 1 + i, MMHorList.f(MMHorList.this).getItemId(MMHorList.e(MMHorList.this) + 1 + i));
            }
          }
          AppMethodBeat.o(142008);
          return true;
          label217:
          i += 1;
        }
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(193719);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(193719);
        return bool;
      }
    };
    init();
    AppMethodBeat.o(142010);
  }
  
  private void aB(View paramView, int paramInt)
  {
    AppMethodBeat.i(142015);
    this.JGm = true;
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -1);
    }
    addViewInLayout(paramView, paramInt, localLayoutParams1, true);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(getHeight(), -2147483648));
    AppMethodBeat.o(142015);
  }
  
  private int getChildViewTotalWidth()
  {
    AppMethodBeat.i(142013);
    int i = this.JGr.getCount();
    int j = this.JGv;
    AppMethodBeat.o(142013);
    return i * j;
  }
  
  private void init()
  {
    AppMethodBeat.i(142009);
    this.JGn = new Scroller(getContext());
    this.JGg = -1;
    this.JGh = 0;
    this.offset = 0;
    this.oxl = 0;
    this.JGi = 0;
    this.JGl = false;
    this.JGj = 536870912;
    this.JGo = new GestureDetector(getContext(), this.JGz);
    AppMethodBeat.o(142009);
  }
  
  private void reset()
  {
    AppMethodBeat.i(142021);
    init();
    removeAllViewsInLayout();
    requestLayout();
    AppMethodBeat.o(142021);
  }
  
  public final void acQ(int paramInt)
  {
    AppMethodBeat.i(142019);
    this.JGn.forceFinished(true);
    this.JGn.startScroll(this.oxl, 0, paramInt - this.oxl, 0);
    this.JGx = true;
    requestLayout();
    AppMethodBeat.o(142019);
  }
  
  protected final boolean bP(float paramFloat)
  {
    AppMethodBeat.i(142020);
    this.JGn.fling(this.JGi, 0, (int)-paramFloat, 0, 0, this.JGj, 0, 0);
    requestLayout();
    AppMethodBeat.o(142020);
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142017);
    GestureDetector localGestureDetector = this.JGo;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahE(), "com/tencent/mm/ui/base/MMHorList", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mt(0)), "com/tencent/mm/ui/base/MMHorList", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if (paramMotionEvent.getAction() == 0)
    {
      this.wCD = true;
      if (this.JGf != null) {
        this.JGf.erH();
      }
    }
    while ((paramMotionEvent.getAction() != 3) && (paramMotionEvent.getAction() != 1))
    {
      AppMethodBeat.o(142017);
      return bool;
    }
    if (this.JGu)
    {
      if (getChildViewTotalWidth() <= getWidth()) {
        break label253;
      }
      if (this.oxl >= 0) {
        break label205;
      }
      this.JGn.forceFinished(true);
      this.JGn.startScroll(this.oxl, 0, 0 - this.oxl, 0);
      requestLayout();
    }
    for (;;)
    {
      this.wCD = false;
      if (this.JGf == null) {
        break;
      }
      this.JGf.eaW();
      break;
      label205:
      if (this.oxl > this.JGj)
      {
        this.JGn.forceFinished(true);
        this.JGn.startScroll(this.oxl, 0, this.JGj - this.oxl, 0);
        requestLayout();
        continue;
        label253:
        if (this.oxl != this.JGw * -1)
        {
          this.JGn.forceFinished(true);
          this.JGn.startScroll(this.oxl, 0, 0 - this.oxl, 0);
          requestLayout();
        }
      }
    }
  }
  
  protected final boolean fCt()
  {
    AppMethodBeat.i(142018);
    this.JGn.forceFinished(true);
    AppMethodBeat.o(142018);
    return true;
  }
  
  public ListAdapter getAdapter()
  {
    return this.JGr;
  }
  
  public int getCurrentPosition()
  {
    return this.oxl;
  }
  
  public boolean getIsTouching()
  {
    return this.wCD;
  }
  
  public View getSelectedView()
  {
    return null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142014);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.JGr == null)
    {
      AppMethodBeat.o(142014);
      return;
    }
    this.JGm = true;
    if (this.JGl)
    {
      paramInt1 = this.oxl;
      init();
      removeAllViewsInLayout();
      this.JGi = paramInt1;
      if (this.JGt)
      {
        this.JGw = Math.max(0, (getWidth() - getChildViewTotalWidth()) / 2);
        this.offset = this.JGw;
      }
      this.JGl = false;
    }
    if (this.JGn.computeScrollOffset()) {
      this.JGi = this.JGn.getCurrX();
    }
    if (this.JGu) {
      if (getChildViewTotalWidth() > getWidth())
      {
        if (this.JGi < getWidth() * -1)
        {
          this.JGi = (getWidth() * -1 + 1);
          this.JGn.forceFinished(true);
        }
        if (this.JGi > this.JGj + getWidth())
        {
          this.JGi = (this.JGj + getWidth() - 1);
          this.JGn.forceFinished(true);
        }
      }
    }
    for (;;)
    {
      paramInt2 = this.oxl - this.JGi;
      localView = getChildAt(0);
      while ((localView != null) && (localView.getRight() + paramInt2 <= 0))
      {
        this.offset += localView.getMeasuredWidth();
        this.JGk.offer(localView);
        removeViewInLayout(localView);
        this.JGg += 1;
        localView = getChildAt(0);
        this.JGm = true;
      }
      if (this.JGi < getWidth() * -1 + this.JGw)
      {
        this.JGi = (getWidth() * -1 + this.JGw + 1);
        this.JGn.forceFinished(true);
      }
      if (this.JGi > getWidth() - this.JGw)
      {
        this.JGi = (getWidth() - this.JGw - 1);
        this.JGn.forceFinished(true);
        continue;
        if (this.JGi < 0)
        {
          this.JGi = 0;
          this.JGn.forceFinished(true);
        }
        if (this.JGi > this.JGj)
        {
          this.JGi = this.JGj;
          this.JGn.forceFinished(true);
        }
      }
    }
    View localView = getChildAt(getChildCount() - 1);
    while ((localView != null) && (localView.getLeft() + paramInt2 >= getWidth()))
    {
      this.JGk.offer(localView);
      removeViewInLayout(localView);
      this.JGh -= 1;
      localView = getChildAt(getChildCount() - 1);
      this.JGm = true;
    }
    localView = getChildAt(getChildCount() - 1);
    if (localView != null) {
      paramInt1 = localView.getRight();
    }
    for (;;)
    {
      if ((paramInt1 + paramInt2 < getWidth()) && (this.JGh < this.JGr.getCount()))
      {
        localView = this.JGr.getView(this.JGh, (View)this.JGk.poll(), this);
        aB(localView, -1);
        paramInt1 = localView.getMeasuredWidth() + paramInt1;
        if (this.JGh == this.JGr.getCount() - 1) {
          this.JGj = (this.oxl + paramInt1 - getWidth());
        }
        this.JGh += 1;
      }
      else
      {
        localView = getChildAt(0);
        if (localView != null) {
          paramInt1 = localView.getLeft();
        }
        for (;;)
        {
          if ((paramInt1 + paramInt2 > 0) && (this.JGg >= 0))
          {
            localView = this.JGr.getView(this.JGg, (View)this.JGk.poll(), this);
            aB(localView, 0);
            paramInt3 = localView.getMeasuredWidth();
            this.JGg -= 1;
            this.offset -= localView.getMeasuredWidth();
            paramInt1 -= paramInt3;
          }
          else
          {
            if ((getChildCount() > 0) && (this.JGm))
            {
              this.offset += paramInt2;
              paramInt2 = this.offset;
              paramInt1 = 0;
              while (paramInt1 < getChildCount())
              {
                localView = getChildAt(paramInt1);
                paramInt3 = localView.getMeasuredWidth();
                localView.layout(paramInt2, 0, paramInt2 + paramInt3, localView.getMeasuredHeight());
                paramInt2 += paramInt3;
                paramInt1 += 1;
              }
            }
            this.oxl = this.JGi;
            if (!this.JGn.isFinished())
            {
              post(this.JGs);
              AppMethodBeat.o(142014);
              return;
            }
            if ((this.JGf != null) && (this.JGx))
            {
              this.JGf.bEo();
              this.JGx = false;
            }
            AppMethodBeat.o(142014);
            return;
            paramInt1 = 0;
          }
        }
        paramInt1 = 0;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142016);
    if ((this.JGr != null) && (this.JGr.getCount() > 0))
    {
      View localView = getChildAt(0);
      if (localView != null)
      {
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), -2147483648));
        AppMethodBeat.o(142016);
        return;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(142016);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(142012);
    if (this.JGr == null) {
      paramListAdapter.registerDataSetObserver(this.JGy);
    }
    this.JGr = paramListAdapter;
    reset();
    AppMethodBeat.o(142012);
  }
  
  public void setCenterInParent(boolean paramBoolean)
  {
    this.JGt = paramBoolean;
  }
  
  public void setHorListLitener(a parama)
  {
    this.JGf = parama;
  }
  
  public void setItemWidth(int paramInt)
  {
    this.JGv = paramInt;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.JGq = paramOnItemClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.JGp = paramOnItemSelectedListener;
  }
  
  public void setOverScrollEnabled(boolean paramBoolean)
  {
    this.JGu = paramBoolean;
  }
  
  public void setSelection(int paramInt) {}
  
  public static abstract interface a
  {
    public abstract void bEo();
    
    public abstract void eaW();
    
    public abstract void erH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMHorList
 * JD-Core Version:    0.7.0.1
 */