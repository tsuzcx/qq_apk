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
  private GestureDetector JlA;
  private AdapterView.OnItemSelectedListener JlB;
  private AdapterView.OnItemClickListener JlC;
  private ListAdapter JlD;
  private Runnable JlE;
  private boolean JlF;
  private boolean JlG;
  private int JlH;
  private int JlI;
  private boolean JlJ;
  private DataSetObserver JlK;
  private GestureDetector.OnGestureListener JlL;
  private a Jlr;
  private int Jls;
  private int Jlt;
  private int Jlu;
  private int Jlv;
  private Queue<View> Jlw;
  private boolean Jlx;
  private boolean Jly;
  protected Scroller Jlz;
  private int offset;
  private int oqP;
  private boolean wmU;
  
  public MMHorList(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142011);
    this.Jlv = 536870912;
    this.Jlw = new LinkedList();
    this.Jlx = false;
    this.Jly = false;
    this.JlE = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142002);
        MMHorList.this.requestLayout();
        AppMethodBeat.o(142002);
      }
    };
    this.JlF = false;
    this.JlG = false;
    this.JlH = 0;
    this.JlI = 0;
    this.wmU = false;
    this.JlJ = false;
    this.JlK = new DataSetObserver()
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
    this.JlL = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186469);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(186469);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186468);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(186468);
        return bool;
      }
      
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(142005);
        boolean bool = MMHorList.this.fyr();
        AppMethodBeat.o(142005);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(142006);
        boolean bool = MMHorList.this.bR(paramAnonymousFloat1);
        AppMethodBeat.o(142006);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186467);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(186467);
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
        AppMethodBeat.i(186466);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(186466);
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
    this.Jlv = 536870912;
    this.Jlw = new LinkedList();
    this.Jlx = false;
    this.Jly = false;
    this.JlE = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142002);
        MMHorList.this.requestLayout();
        AppMethodBeat.o(142002);
      }
    };
    this.JlF = false;
    this.JlG = false;
    this.JlH = 0;
    this.JlI = 0;
    this.wmU = false;
    this.JlJ = false;
    this.JlK = new DataSetObserver()
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
    this.JlL = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186469);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(186469);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186468);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(186468);
        return bool;
      }
      
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(142005);
        boolean bool = MMHorList.this.fyr();
        AppMethodBeat.o(142005);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(142006);
        boolean bool = MMHorList.this.bR(paramAnonymousFloat1);
        AppMethodBeat.o(142006);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186467);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(186467);
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
        AppMethodBeat.i(186466);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(186466);
        return bool;
      }
    };
    init();
    AppMethodBeat.o(142010);
  }
  
  private void aB(View paramView, int paramInt)
  {
    AppMethodBeat.i(142015);
    this.Jly = true;
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
    int i = this.JlD.getCount();
    int j = this.JlH;
    AppMethodBeat.o(142013);
    return i * j;
  }
  
  private void init()
  {
    AppMethodBeat.i(142009);
    this.Jlz = new Scroller(getContext());
    this.Jls = -1;
    this.Jlt = 0;
    this.offset = 0;
    this.oqP = 0;
    this.Jlu = 0;
    this.Jlx = false;
    this.Jlv = 536870912;
    this.JlA = new GestureDetector(getContext(), this.JlL);
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
  
  public final void acj(int paramInt)
  {
    AppMethodBeat.i(142019);
    this.Jlz.forceFinished(true);
    this.Jlz.startScroll(this.oqP, 0, paramInt - this.oqP, 0);
    this.JlJ = true;
    requestLayout();
    AppMethodBeat.o(142019);
  }
  
  protected final boolean bR(float paramFloat)
  {
    AppMethodBeat.i(142020);
    this.Jlz.fling(this.Jlu, 0, (int)-paramFloat, 0, 0, this.Jlv, 0, 0);
    requestLayout();
    AppMethodBeat.o(142020);
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142017);
    GestureDetector localGestureDetector = this.JlA;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahp(), "com/tencent/mm/ui/base/MMHorList", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mq(0)), "com/tencent/mm/ui/base/MMHorList", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if (paramMotionEvent.getAction() == 0)
    {
      this.wmU = true;
      if (this.Jlr != null) {
        this.Jlr.eoa();
      }
    }
    while ((paramMotionEvent.getAction() != 3) && (paramMotionEvent.getAction() != 1))
    {
      AppMethodBeat.o(142017);
      return bool;
    }
    if (this.JlG)
    {
      if (getChildViewTotalWidth() <= getWidth()) {
        break label253;
      }
      if (this.oqP >= 0) {
        break label205;
      }
      this.Jlz.forceFinished(true);
      this.Jlz.startScroll(this.oqP, 0, 0 - this.oqP, 0);
      requestLayout();
    }
    for (;;)
    {
      this.wmU = false;
      if (this.Jlr == null) {
        break;
      }
      this.Jlr.dXt();
      break;
      label205:
      if (this.oqP > this.Jlv)
      {
        this.Jlz.forceFinished(true);
        this.Jlz.startScroll(this.oqP, 0, this.Jlv - this.oqP, 0);
        requestLayout();
        continue;
        label253:
        if (this.oqP != this.JlI * -1)
        {
          this.Jlz.forceFinished(true);
          this.Jlz.startScroll(this.oqP, 0, 0 - this.oqP, 0);
          requestLayout();
        }
      }
    }
  }
  
  protected final boolean fyr()
  {
    AppMethodBeat.i(142018);
    this.Jlz.forceFinished(true);
    AppMethodBeat.o(142018);
    return true;
  }
  
  public ListAdapter getAdapter()
  {
    return this.JlD;
  }
  
  public int getCurrentPosition()
  {
    return this.oqP;
  }
  
  public boolean getIsTouching()
  {
    return this.wmU;
  }
  
  public View getSelectedView()
  {
    return null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142014);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.JlD == null)
    {
      AppMethodBeat.o(142014);
      return;
    }
    this.Jly = true;
    if (this.Jlx)
    {
      paramInt1 = this.oqP;
      init();
      removeAllViewsInLayout();
      this.Jlu = paramInt1;
      if (this.JlF)
      {
        this.JlI = Math.max(0, (getWidth() - getChildViewTotalWidth()) / 2);
        this.offset = this.JlI;
      }
      this.Jlx = false;
    }
    if (this.Jlz.computeScrollOffset()) {
      this.Jlu = this.Jlz.getCurrX();
    }
    if (this.JlG) {
      if (getChildViewTotalWidth() > getWidth())
      {
        if (this.Jlu < getWidth() * -1)
        {
          this.Jlu = (getWidth() * -1 + 1);
          this.Jlz.forceFinished(true);
        }
        if (this.Jlu > this.Jlv + getWidth())
        {
          this.Jlu = (this.Jlv + getWidth() - 1);
          this.Jlz.forceFinished(true);
        }
      }
    }
    for (;;)
    {
      paramInt2 = this.oqP - this.Jlu;
      localView = getChildAt(0);
      while ((localView != null) && (localView.getRight() + paramInt2 <= 0))
      {
        this.offset += localView.getMeasuredWidth();
        this.Jlw.offer(localView);
        removeViewInLayout(localView);
        this.Jls += 1;
        localView = getChildAt(0);
        this.Jly = true;
      }
      if (this.Jlu < getWidth() * -1 + this.JlI)
      {
        this.Jlu = (getWidth() * -1 + this.JlI + 1);
        this.Jlz.forceFinished(true);
      }
      if (this.Jlu > getWidth() - this.JlI)
      {
        this.Jlu = (getWidth() - this.JlI - 1);
        this.Jlz.forceFinished(true);
        continue;
        if (this.Jlu < 0)
        {
          this.Jlu = 0;
          this.Jlz.forceFinished(true);
        }
        if (this.Jlu > this.Jlv)
        {
          this.Jlu = this.Jlv;
          this.Jlz.forceFinished(true);
        }
      }
    }
    View localView = getChildAt(getChildCount() - 1);
    while ((localView != null) && (localView.getLeft() + paramInt2 >= getWidth()))
    {
      this.Jlw.offer(localView);
      removeViewInLayout(localView);
      this.Jlt -= 1;
      localView = getChildAt(getChildCount() - 1);
      this.Jly = true;
    }
    localView = getChildAt(getChildCount() - 1);
    if (localView != null) {
      paramInt1 = localView.getRight();
    }
    for (;;)
    {
      if ((paramInt1 + paramInt2 < getWidth()) && (this.Jlt < this.JlD.getCount()))
      {
        localView = this.JlD.getView(this.Jlt, (View)this.Jlw.poll(), this);
        aB(localView, -1);
        paramInt1 = localView.getMeasuredWidth() + paramInt1;
        if (this.Jlt == this.JlD.getCount() - 1) {
          this.Jlv = (this.oqP + paramInt1 - getWidth());
        }
        this.Jlt += 1;
      }
      else
      {
        localView = getChildAt(0);
        if (localView != null) {
          paramInt1 = localView.getLeft();
        }
        for (;;)
        {
          if ((paramInt1 + paramInt2 > 0) && (this.Jls >= 0))
          {
            localView = this.JlD.getView(this.Jls, (View)this.Jlw.poll(), this);
            aB(localView, 0);
            paramInt3 = localView.getMeasuredWidth();
            this.Jls -= 1;
            this.offset -= localView.getMeasuredWidth();
            paramInt1 -= paramInt3;
          }
          else
          {
            if ((getChildCount() > 0) && (this.Jly))
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
            this.oqP = this.Jlu;
            if (!this.Jlz.isFinished())
            {
              post(this.JlE);
              AppMethodBeat.o(142014);
              return;
            }
            if ((this.Jlr != null) && (this.JlJ))
            {
              this.Jlr.bDw();
              this.JlJ = false;
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
    if ((this.JlD != null) && (this.JlD.getCount() > 0))
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
    if (this.JlD == null) {
      paramListAdapter.registerDataSetObserver(this.JlK);
    }
    this.JlD = paramListAdapter;
    reset();
    AppMethodBeat.o(142012);
  }
  
  public void setCenterInParent(boolean paramBoolean)
  {
    this.JlF = paramBoolean;
  }
  
  public void setHorListLitener(a parama)
  {
    this.Jlr = parama;
  }
  
  public void setItemWidth(int paramInt)
  {
    this.JlH = paramInt;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.JlC = paramOnItemClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.JlB = paramOnItemSelectedListener;
  }
  
  public void setOverScrollEnabled(boolean paramBoolean)
  {
    this.JlG = paramBoolean;
  }
  
  public void setSelection(int paramInt) {}
  
  public static abstract interface a
  {
    public abstract void bDw();
    
    public abstract void dXt();
    
    public abstract void eoa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMHorList
 * JD-Core Version:    0.7.0.1
 */