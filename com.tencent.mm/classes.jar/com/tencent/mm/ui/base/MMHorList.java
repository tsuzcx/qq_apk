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
  private boolean AmY;
  protected Scroller Ays;
  private a OQX;
  private int OQY;
  private int OQZ;
  private int ORa;
  private int ORb;
  private Queue<View> ORc;
  private boolean ORd;
  private boolean ORe;
  private GestureDetector ORf;
  private AdapterView.OnItemSelectedListener ORg;
  private AdapterView.OnItemClickListener ORh;
  private ListAdapter ORi;
  private Runnable ORj;
  private boolean ORk;
  private boolean ORl;
  private int ORm;
  private int ORn;
  private boolean ORo;
  private DataSetObserver ORp;
  private GestureDetector.OnGestureListener ORq;
  private int offset;
  private int pKP;
  
  public MMHorList(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142011);
    this.ORb = 536870912;
    this.ORc = new LinkedList();
    this.ORd = false;
    this.ORe = false;
    this.ORj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142002);
        MMHorList.this.requestLayout();
        AppMethodBeat.o(142002);
      }
    };
    this.ORk = false;
    this.ORl = false;
    this.ORm = 0;
    this.ORn = 0;
    this.AmY = false;
    this.ORo = false;
    this.ORp = new DataSetObserver()
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
    this.ORq = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(205236);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(205236);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(205235);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(205235);
        return bool;
      }
      
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(142005);
        boolean bool = MMHorList.this.gKr();
        AppMethodBeat.o(142005);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(142006);
        boolean bool = MMHorList.this.cr(paramAnonymousFloat1);
        AppMethodBeat.o(142006);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(205234);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(205234);
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
        AppMethodBeat.i(205233);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(205233);
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
    this.ORb = 536870912;
    this.ORc = new LinkedList();
    this.ORd = false;
    this.ORe = false;
    this.ORj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142002);
        MMHorList.this.requestLayout();
        AppMethodBeat.o(142002);
      }
    };
    this.ORk = false;
    this.ORl = false;
    this.ORm = 0;
    this.ORn = 0;
    this.AmY = false;
    this.ORo = false;
    this.ORp = new DataSetObserver()
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
    this.ORq = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(205236);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(205236);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(205235);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(205235);
        return bool;
      }
      
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(142005);
        boolean bool = MMHorList.this.gKr();
        AppMethodBeat.o(142005);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(142006);
        boolean bool = MMHorList.this.cr(paramAnonymousFloat1);
        AppMethodBeat.o(142006);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(205234);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(205234);
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
        AppMethodBeat.i(205233);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(205233);
        return bool;
      }
    };
    init();
    AppMethodBeat.o(142010);
  }
  
  private void aG(View paramView, int paramInt)
  {
    AppMethodBeat.i(142015);
    this.ORe = true;
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
    int i = this.ORi.getCount();
    int j = this.ORm;
    AppMethodBeat.o(142013);
    return i * j;
  }
  
  private void init()
  {
    AppMethodBeat.i(142009);
    this.Ays = new Scroller(getContext());
    this.OQY = -1;
    this.OQZ = 0;
    this.offset = 0;
    this.pKP = 0;
    this.ORa = 0;
    this.ORd = false;
    this.ORb = 536870912;
    this.ORf = new GestureDetector(getContext(), this.ORq);
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
  
  public final void alA(int paramInt)
  {
    AppMethodBeat.i(142019);
    this.Ays.forceFinished(true);
    this.Ays.startScroll(this.pKP, 0, paramInt - this.pKP, 0);
    this.ORo = true;
    requestLayout();
    AppMethodBeat.o(142019);
  }
  
  protected final boolean cr(float paramFloat)
  {
    AppMethodBeat.i(142020);
    this.Ays.fling(this.ORa, 0, (int)-paramFloat, 0, 0, this.ORb, 0, 0);
    requestLayout();
    AppMethodBeat.o(142020);
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142017);
    GestureDetector localGestureDetector = this.ORf;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.axQ(), "com/tencent/mm/ui/base/MMHorList", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/ui/base/MMHorList", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if (paramMotionEvent.getAction() == 0)
    {
      this.AmY = true;
      if (this.OQX != null) {
        this.OQX.fuk();
      }
    }
    while ((paramMotionEvent.getAction() != 3) && (paramMotionEvent.getAction() != 1))
    {
      AppMethodBeat.o(142017);
      return bool;
    }
    if (this.ORl)
    {
      if (getChildViewTotalWidth() <= getWidth()) {
        break label253;
      }
      if (this.pKP >= 0) {
        break label205;
      }
      this.Ays.forceFinished(true);
      this.Ays.startScroll(this.pKP, 0, 0 - this.pKP, 0);
      requestLayout();
    }
    for (;;)
    {
      this.AmY = false;
      if (this.OQX == null) {
        break;
      }
      this.OQX.fdM();
      break;
      label205:
      if (this.pKP > this.ORb)
      {
        this.Ays.forceFinished(true);
        this.Ays.startScroll(this.pKP, 0, this.ORb - this.pKP, 0);
        requestLayout();
        continue;
        label253:
        if (this.pKP != this.ORn * -1)
        {
          this.Ays.forceFinished(true);
          this.Ays.startScroll(this.pKP, 0, 0 - this.pKP, 0);
          requestLayout();
        }
      }
    }
  }
  
  protected final boolean gKr()
  {
    AppMethodBeat.i(142018);
    this.Ays.forceFinished(true);
    AppMethodBeat.o(142018);
    return true;
  }
  
  public ListAdapter getAdapter()
  {
    return this.ORi;
  }
  
  public int getCurrentPosition()
  {
    return this.pKP;
  }
  
  public boolean getIsTouching()
  {
    return this.AmY;
  }
  
  public View getSelectedView()
  {
    return null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142014);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.ORi == null)
    {
      AppMethodBeat.o(142014);
      return;
    }
    this.ORe = true;
    if (this.ORd)
    {
      paramInt1 = this.pKP;
      init();
      removeAllViewsInLayout();
      this.ORa = paramInt1;
      if (this.ORk)
      {
        this.ORn = Math.max(0, (getWidth() - getChildViewTotalWidth()) / 2);
        this.offset = this.ORn;
      }
      this.ORd = false;
    }
    if (this.Ays.computeScrollOffset()) {
      this.ORa = this.Ays.getCurrX();
    }
    if (this.ORl) {
      if (getChildViewTotalWidth() > getWidth())
      {
        if (this.ORa < getWidth() * -1)
        {
          this.ORa = (getWidth() * -1 + 1);
          this.Ays.forceFinished(true);
        }
        if (this.ORa > this.ORb + getWidth())
        {
          this.ORa = (this.ORb + getWidth() - 1);
          this.Ays.forceFinished(true);
        }
      }
    }
    for (;;)
    {
      paramInt2 = this.pKP - this.ORa;
      localView = getChildAt(0);
      while ((localView != null) && (localView.getRight() + paramInt2 <= 0))
      {
        this.offset += localView.getMeasuredWidth();
        this.ORc.offer(localView);
        removeViewInLayout(localView);
        this.OQY += 1;
        localView = getChildAt(0);
        this.ORe = true;
      }
      if (this.ORa < getWidth() * -1 + this.ORn)
      {
        this.ORa = (getWidth() * -1 + this.ORn + 1);
        this.Ays.forceFinished(true);
      }
      if (this.ORa > getWidth() - this.ORn)
      {
        this.ORa = (getWidth() - this.ORn - 1);
        this.Ays.forceFinished(true);
        continue;
        if (this.ORa < 0)
        {
          this.ORa = 0;
          this.Ays.forceFinished(true);
        }
        if (this.ORa > this.ORb)
        {
          this.ORa = this.ORb;
          this.Ays.forceFinished(true);
        }
      }
    }
    View localView = getChildAt(getChildCount() - 1);
    while ((localView != null) && (localView.getLeft() + paramInt2 >= getWidth()))
    {
      this.ORc.offer(localView);
      removeViewInLayout(localView);
      this.OQZ -= 1;
      localView = getChildAt(getChildCount() - 1);
      this.ORe = true;
    }
    localView = getChildAt(getChildCount() - 1);
    if (localView != null) {
      paramInt1 = localView.getRight();
    }
    for (;;)
    {
      if ((paramInt1 + paramInt2 < getWidth()) && (this.OQZ < this.ORi.getCount()))
      {
        localView = this.ORi.getView(this.OQZ, (View)this.ORc.poll(), this);
        aG(localView, -1);
        paramInt1 = localView.getMeasuredWidth() + paramInt1;
        if (this.OQZ == this.ORi.getCount() - 1) {
          this.ORb = (this.pKP + paramInt1 - getWidth());
        }
        this.OQZ += 1;
      }
      else
      {
        localView = getChildAt(0);
        if (localView != null) {
          paramInt1 = localView.getLeft();
        }
        for (;;)
        {
          if ((paramInt1 + paramInt2 > 0) && (this.OQY >= 0))
          {
            localView = this.ORi.getView(this.OQY, (View)this.ORc.poll(), this);
            aG(localView, 0);
            paramInt3 = localView.getMeasuredWidth();
            this.OQY -= 1;
            this.offset -= localView.getMeasuredWidth();
            paramInt1 -= paramInt3;
          }
          else
          {
            if ((getChildCount() > 0) && (this.ORe))
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
            this.pKP = this.ORa;
            if (!this.Ays.isFinished())
            {
              post(this.ORj);
              AppMethodBeat.o(142014);
              return;
            }
            if ((this.OQX != null) && (this.ORo))
            {
              this.OQX.efW();
              this.ORo = false;
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
    if ((this.ORi != null) && (this.ORi.getCount() > 0))
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
    if (this.ORi == null) {
      paramListAdapter.registerDataSetObserver(this.ORp);
    }
    this.ORi = paramListAdapter;
    reset();
    AppMethodBeat.o(142012);
  }
  
  public void setCenterInParent(boolean paramBoolean)
  {
    this.ORk = paramBoolean;
  }
  
  public void setHorListLitener(a parama)
  {
    this.OQX = parama;
  }
  
  public void setItemWidth(int paramInt)
  {
    this.ORm = paramInt;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.ORh = paramOnItemClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.ORg = paramOnItemSelectedListener;
  }
  
  public void setOverScrollEnabled(boolean paramBoolean)
  {
    this.ORl = paramBoolean;
  }
  
  public void setSelection(int paramInt) {}
  
  public static abstract interface a
  {
    public abstract void efW();
    
    public abstract void fdM();
    
    public abstract void fuk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMHorList
 * JD-Core Version:    0.7.0.1
 */