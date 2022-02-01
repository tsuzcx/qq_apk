package com.tencent.mm.ui.widget.sortlist;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.k;

public class DragSortListView
  extends ListView
{
  private int CD;
  private int CE;
  private int CL;
  private int CM;
  private int Rh;
  private Point YuN;
  private Point YuO;
  private int YuP;
  private boolean YuQ;
  private float YuR;
  private float YuS;
  private int YuT;
  private int YuU;
  private int YuV;
  private boolean YuW;
  private int YuX;
  private int YuY;
  private int YuZ;
  private int YvA;
  private float YvB;
  private float YvC;
  private a YvD;
  private boolean YvE;
  private DragSortListView.f YvF;
  private boolean YvG;
  private boolean YvH;
  private DragSortListView.j YvI;
  private k YvJ;
  private g YvK;
  private boolean YvL;
  private float YvM;
  boolean YvN;
  private boolean YvO;
  private DragSortListView.b Yva;
  private DragSortListView.h Yvb;
  private DragSortListView.l Yvc;
  boolean Yvd;
  private int Yve;
  private int Yvf;
  private int Yvg;
  private int Yvh;
  private View[] Yvi;
  private d Yvj;
  private float Yvk;
  private float Yvl;
  private int Yvm;
  private int Yvn;
  private float Yvo;
  private float Yvp;
  private float Yvq;
  private float Yvr;
  private float Yvs;
  private c Yvt;
  private int Yvu;
  private int Yvv;
  private boolean Yvw;
  boolean Yvx;
  i Yvy;
  private MotionEvent Yvz;
  private DataSetObserver mObserver;
  private int qtC;
  private int qtD;
  private View rqz;
  
  public DragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159791);
    this.YuN = new Point();
    this.YuO = new Point();
    this.YuQ = false;
    this.YuR = 1.0F;
    this.YuS = 1.0F;
    this.YuW = false;
    this.Yvd = true;
    this.Rh = 0;
    this.Yve = 1;
    this.Yvh = 0;
    this.Yvi = new View[1];
    this.Yvk = 0.3333333F;
    this.Yvl = 0.3333333F;
    this.Yvs = 0.5F;
    this.Yvt = new c()
    {
      public final float cY(float paramAnonymousFloat)
      {
        AppMethodBeat.i(159754);
        float f = DragSortListView.a(DragSortListView.this);
        AppMethodBeat.o(159754);
        return f * paramAnonymousFloat;
      }
    };
    this.Yvv = 0;
    this.Yvw = false;
    this.Yvx = false;
    this.Yvy = null;
    this.YvA = 0;
    this.YvB = 0.25F;
    this.YvC = 0.0F;
    this.YvE = false;
    this.YvG = false;
    this.YvH = false;
    this.YvI = new DragSortListView.j(this, (byte)0);
    this.YvM = 0.0F;
    this.YvN = false;
    this.YvO = false;
    int j = 150;
    int i = 150;
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, a.k.DragSortListView, 0, 0);
      this.Yve = Math.max(1, paramContext.getDimensionPixelSize(a.k.DragSortListView_collapsed_height, 1));
      this.YvE = paramContext.getBoolean(a.k.DragSortListView_track_drag_sort, false);
      if (this.YvE) {
        this.YvF = new DragSortListView.f(this);
      }
      this.YuR = paramContext.getFloat(a.k.DragSortListView_float_alpha, this.YuR);
      this.YuS = this.YuR;
      this.Yvd = paramContext.getBoolean(a.k.DragSortListView_drag_enabled, this.Yvd);
      this.YvB = Math.max(0.0F, Math.min(1.0F, 1.0F - paramContext.getFloat(a.k.DragSortListView_slide_shuffle_speed, 0.75F)));
      if (this.YvB <= 0.0F) {
        break label628;
      }
    }
    label628:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.YuW = bool1;
      setDragScrollStart(paramContext.getFloat(a.k.DragSortListView_drag_scroll_start, this.Yvk));
      this.Yvs = paramContext.getFloat(a.k.DragSortListView_max_drag_scroll_speed, this.Yvs);
      j = paramContext.getInt(a.k.DragSortListView_remove_animation_duration, 150);
      i = paramContext.getInt(a.k.DragSortListView_drop_animation_duration, 150);
      if (paramContext.getBoolean(a.k.DragSortListView_use_default_controller, true))
      {
        bool1 = paramContext.getBoolean(a.k.DragSortListView_remove_enabled, false);
        int k = paramContext.getInt(a.k.DragSortListView_remove_mode, 1);
        boolean bool2 = paramContext.getBoolean(a.k.DragSortListView_sort_enabled, true);
        int m = paramContext.getInt(a.k.DragSortListView_drag_start_mode, 0);
        int n = paramContext.getResourceId(a.k.DragSortListView_drag_handle_id, 0);
        int i1 = paramContext.getResourceId(a.k.DragSortListView_fling_handle_id, 0);
        int i2 = paramContext.getResourceId(a.k.DragSortListView_click_remove_id, 0);
        int i3 = paramContext.getColor(a.k.DragSortListView_float_background_color, -16777216);
        paramAttributeSet = new a(this, n, m, k, i2, i1);
        paramAttributeSet.Yuw = bool1;
        paramAttributeSet.Yuv = bool2;
        paramAttributeSet.Yws = i3;
        this.Yvy = paramAttributeSet;
        setOnTouchListener(paramAttributeSet);
      }
      paramContext.recycle();
      this.Yvj = new d();
      if (j > 0) {
        this.YvJ = new k(j, (byte)0);
      }
      if (i > 0) {
        this.YvK = new g(i, (byte)0);
      }
      this.Yvz = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
      this.mObserver = new DataSetObserver()
      {
        private void cancel()
        {
          AppMethodBeat.i(159755);
          if (DragSortListView.b(DragSortListView.this) == 4) {
            DragSortListView.this.idS();
          }
          AppMethodBeat.o(159755);
        }
        
        public final void onChanged()
        {
          AppMethodBeat.i(159756);
          cancel();
          AppMethodBeat.o(159756);
        }
        
        public final void onInvalidated()
        {
          AppMethodBeat.i(159757);
          cancel();
          AppMethodBeat.o(159757);
        }
      };
      AppMethodBeat.o(159791);
      return;
    }
  }
  
  private void D(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(159800);
    if ((this.Rh == 0) || (this.Rh == 4))
    {
      if (this.Rh == 0)
      {
        this.YuX = (getHeaderViewsCount() + paramInt);
        this.YuU = this.YuX;
        this.YuV = this.YuX;
        this.YuT = this.YuX;
        View localView = getChildAt(this.YuX - getFirstVisiblePosition());
        if (localView != null) {
          localView.setVisibility(4);
        }
      }
      this.Rh = 1;
      this.YvM = paramFloat;
      if (this.Yvx) {
        switch (this.YvA)
        {
        }
      }
      while (this.YvJ != null)
      {
        this.YvJ.start();
        AppMethodBeat.o(159800);
        return;
        super.onTouchEvent(this.Yvz);
        continue;
        super.onInterceptTouchEvent(this.Yvz);
      }
      ayU(paramInt);
    }
    AppMethodBeat.o(159800);
  }
  
  private int a(int paramInt1, View paramView, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159820);
    int i = ayV(paramInt1);
    int m = paramView.getHeight();
    int n = ne(paramInt1, i);
    int j;
    if (paramInt1 != this.YuX)
    {
      j = m - i;
      i = n - i;
    }
    for (;;)
    {
      int i1 = this.Yvf;
      int k = i1;
      if (this.YuX != this.YuU)
      {
        k = i1;
        if (this.YuX != this.YuV) {
          k = i1 - this.Yve;
        }
      }
      if (paramInt1 <= paramInt2)
      {
        if (paramInt1 <= this.YuU) {
          break label208;
        }
        paramInt1 = k - i + 0;
      }
      for (;;)
      {
        AppMethodBeat.o(159820);
        return paramInt1;
        if (paramInt1 == paramInt3)
        {
          if (paramInt1 <= this.YuU) {
            paramInt1 = j - k + 0;
          } else if (paramInt1 == this.YuV) {
            paramInt1 = m - n + 0;
          } else {
            paramInt1 = j + 0;
          }
        }
        else if (paramInt1 <= this.YuU) {
          paramInt1 = 0 - k;
        } else if (paramInt1 == this.YuV) {
          paramInt1 = 0 - i;
        } else {
          label208:
          paramInt1 = 0;
        }
      }
      i = n;
      j = m;
    }
  }
  
  private void a(int paramInt, Canvas paramCanvas)
  {
    AppMethodBeat.i(159793);
    Drawable localDrawable = getDivider();
    int m = getDividerHeight();
    ViewGroup localViewGroup;
    int j;
    int k;
    int i;
    if ((localDrawable != null) && (m != 0))
    {
      localViewGroup = (ViewGroup)getChildAt(paramInt - getFirstVisiblePosition());
      if (localViewGroup != null)
      {
        j = getPaddingLeft();
        k = getWidth() - getPaddingRight();
        i = localViewGroup.getChildAt(0).getHeight();
        if (paramInt <= this.YuX) {
          break label140;
        }
        i += localViewGroup.getTop();
        paramInt = i + m;
      }
    }
    for (;;)
    {
      paramCanvas.save();
      paramCanvas.clipRect(j, i, k, paramInt);
      localDrawable.setBounds(j, i, k, paramInt);
      localDrawable.draw(paramCanvas);
      paramCanvas.restore();
      AppMethodBeat.o(159793);
      return;
      label140:
      paramInt = localViewGroup.getBottom() - i;
      i = paramInt - m;
    }
  }
  
  private void a(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159815);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    int i;
    if ((paramInt != this.YuX) && (paramInt != this.YuU) && (paramInt != this.YuV))
    {
      i = -2;
      if (i != localLayoutParams.height)
      {
        localLayoutParams.height = i;
        paramView.setLayoutParams(localLayoutParams);
      }
      if ((paramInt == this.YuU) || (paramInt == this.YuV))
      {
        if (paramInt >= this.YuX) {
          break label163;
        }
        ((b)paramView).setGravity(80);
      }
    }
    for (;;)
    {
      int k = paramView.getVisibility();
      int j = 0;
      i = j;
      if (paramInt == this.YuX)
      {
        i = j;
        if (this.rqz != null) {
          i = 4;
        }
      }
      if (i != k) {
        paramView.setVisibility(i);
      }
      AppMethodBeat.o(159815);
      return;
      i = c(paramInt, paramView, paramBoolean);
      break;
      label163:
      if (paramInt > this.YuX) {
        ((b)paramView).setGravity(48);
      }
    }
  }
  
  private void aG(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159809);
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      this.qtC = this.CD;
      this.qtD = this.CE;
    }
    this.CD = ((int)paramMotionEvent.getX());
    this.CE = ((int)paramMotionEvent.getY());
    if (i == 0)
    {
      this.qtC = this.CD;
      this.qtD = this.CE;
    }
    this.CL = ((int)paramMotionEvent.getRawX() - this.CD);
    this.CM = ((int)paramMotionEvent.getRawY() - this.CE);
    AppMethodBeat.o(159809);
  }
  
  private int ayT(int paramInt)
  {
    AppMethodBeat.i(159795);
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null)
    {
      paramInt = localView.getHeight();
      AppMethodBeat.o(159795);
      return paramInt;
    }
    paramInt = ne(paramInt, ayV(paramInt));
    AppMethodBeat.o(159795);
    return paramInt;
  }
  
  private void ayU(int paramInt)
  {
    AppMethodBeat.i(159803);
    this.Rh = 1;
    if (this.Yvc != null) {
      this.Yvc.remove(paramInt);
    }
    iec();
    idV();
    idT();
    if (this.Yvx)
    {
      this.Rh = 3;
      AppMethodBeat.o(159803);
      return;
    }
    this.Rh = 0;
    AppMethodBeat.o(159803);
  }
  
  private int ayV(int paramInt)
  {
    AppMethodBeat.i(159816);
    if (paramInt == this.YuX)
    {
      AppMethodBeat.o(159816);
      return 0;
    }
    Object localObject = getChildAt(paramInt - getFirstVisiblePosition());
    if (localObject != null)
    {
      paramInt = b(paramInt, (View)localObject, false);
      AppMethodBeat.o(159816);
      return paramInt;
    }
    int i = this.YvI.get(paramInt);
    if (i != -1)
    {
      AppMethodBeat.o(159816);
      return i;
    }
    localObject = getAdapter();
    i = ((ListAdapter)localObject).getItemViewType(paramInt);
    int j = ((ListAdapter)localObject).getViewTypeCount();
    if (j != this.Yvi.length) {
      this.Yvi = new View[j];
    }
    if (i >= 0) {
      if (this.Yvi[i] == null)
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
        this.Yvi[i] = localObject;
      }
    }
    for (;;)
    {
      i = b(paramInt, (View)localObject, true);
      this.YvI.nf(paramInt, i);
      AppMethodBeat.o(159816);
      return i;
      localObject = ((ListAdapter)localObject).getView(paramInt, this.Yvi[i], this);
      continue;
      localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
    }
  }
  
  private int b(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159817);
    if (paramInt == this.YuX)
    {
      AppMethodBeat.o(159817);
      return 0;
    }
    View localView = paramView;
    if (paramInt >= getHeaderViewsCount()) {
      if (paramInt < getCount() - getFooterViewsCount()) {
        break label79;
      }
    }
    label79:
    for (localView = paramView;; localView = ((ViewGroup)paramView).getChildAt(0))
    {
      paramView = localView.getLayoutParams();
      if ((paramView == null) || (paramView.height <= 0)) {
        break;
      }
      paramInt = paramView.height;
      AppMethodBeat.o(159817);
      return paramInt;
    }
    paramInt = localView.getHeight();
    if ((paramInt == 0) || (paramBoolean))
    {
      iV(localView);
      paramInt = localView.getMeasuredHeight();
    }
    AppMethodBeat.o(159817);
    return paramInt;
  }
  
  private int c(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159818);
    paramInt = ne(paramInt, b(paramInt, paramView, paramBoolean));
    AppMethodBeat.o(159818);
    return paramInt;
  }
  
  private void d(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159827);
    this.YvG = true;
    ieb();
    int i = this.YuU;
    int j = this.YuV;
    boolean bool = idR();
    if (bool)
    {
      idY();
      setSelectionFromTop(paramInt, a(paramInt, paramView, i, j) + paramView.getTop() - getPaddingTop());
      layoutChildren();
    }
    if ((bool) || (paramBoolean)) {
      invalidate();
    }
    this.YvG = false;
    AppMethodBeat.o(159827);
  }
  
  private boolean f(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(159806);
    if (this.rqz != null)
    {
      this.Yvj.ied();
      if (paramBoolean) {
        D(this.YuX - getHeaderViewsCount(), paramFloat);
      }
      for (;;)
      {
        if (this.YvE) {
          this.YvF.stopTracking();
        }
        AppMethodBeat.o(159806);
        return true;
        if (this.YvK != null) {
          this.YvK.start();
        } else {
          idU();
        }
      }
    }
    AppMethodBeat.o(159806);
    return false;
  }
  
  private void iV(View paramView)
  {
    AppMethodBeat.i(159821);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null)
    {
      localObject = new AbsListView.LayoutParams(-1, -2);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int j = ViewGroup.getChildMeasureSpec(this.Yvh, getListPaddingLeft() + getListPaddingRight(), ((ViewGroup.LayoutParams)localObject).width);
    if (((ViewGroup.LayoutParams)localObject).height > 0) {}
    for (int i = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(j, i);
      AppMethodBeat.o(159821);
      return;
    }
  }
  
  private boolean idR()
  {
    boolean bool2 = true;
    AppMethodBeat.i(159797);
    int j = getFirstVisiblePosition();
    int i = this.YuU;
    View localView2 = getChildAt(i - j);
    View localView1 = localView2;
    if (localView2 == null)
    {
      i = j + getChildCount() / 2;
      localView1 = getChildAt(i - j);
    }
    int i2 = localView1.getTop();
    int i1 = localView1.getHeight();
    j = nd(i, i2);
    int i3 = getDividerHeight();
    int k;
    int m;
    int n;
    if (this.YuP < j)
    {
      k = j;
      m = i;
      n = j;
      j = k;
      i = j;
      k = m;
      if (m < 0) {
        break label662;
      }
      i1 = m - 1;
      i = ayT(i1);
      if (i1 == 0)
      {
        i = i2 - i3 - i;
        k = i1;
      }
    }
    for (;;)
    {
      label154:
      n = getHeaderViewsCount();
      i3 = getFooterViewsCount();
      i1 = this.YuU;
      i2 = this.YuV;
      float f1 = this.YvC;
      int i4;
      label207:
      float f2;
      if (this.YuW)
      {
        i4 = Math.abs(i - j);
        if (this.YuP < i)
        {
          m = (int)(this.YvB * 0.5F * i4);
          f2 = m;
          j += m;
          if (this.YuP >= j) {
            break label552;
          }
          this.YuU = (k - 1);
          this.YuV = k;
          this.YvC = ((j - this.YuP) * 0.5F / f2);
          label272:
          if (this.YuU >= n) {
            break label613;
          }
          this.YuU = n;
          this.YuV = n;
          k = n;
          label297:
          if ((this.YuU == i1) && (this.YuV == i2) && (Math.abs(this.YvC - f1) <= 0.0F)) {
            break label656;
          }
        }
      }
      label656:
      for (boolean bool1 = true;; bool1 = false)
      {
        if (k != this.YuT)
        {
          this.YuT = k;
          bool1 = bool2;
        }
        for (;;)
        {
          AppMethodBeat.o(159797);
          return bool1;
          i2 -= i + i3;
          m = nd(i1, i2);
          i = m;
          k = i1;
          if (this.YuP >= m) {
            break label154;
          }
          j = m;
          n = m;
          m = i1;
          break;
          i4 = getCount();
          n = j;
          m = i;
          k = j;
          j = n;
          for (;;)
          {
            i = j;
            n = k;
            k = m;
            if (m >= i4) {
              break label662;
            }
            if (m == i4 - 1)
            {
              i = i2 + i3 + i1;
              k = m;
              break;
            }
            i2 += i3 + i1;
            i1 = ayT(m + 1);
            n = nd(m + 1, i2);
            i = n;
            k = m;
            if (this.YuP < n) {
              break;
            }
            m += 1;
            j = n;
            k = n;
          }
          m = i;
          i = j;
          j = m;
          break label207;
          label552:
          if (this.YuP >= i - m)
          {
            this.YuU = k;
            this.YuV = (k + 1);
            this.YvC = ((1.0F + (i - this.YuP) / f2) * 0.5F);
            break label272;
          }
          this.YuU = k;
          this.YuV = k;
          break label272;
          label613:
          if (this.YuV < getCount() - i3) {
            break label297;
          }
          k = getCount() - i3 - 1;
          this.YuU = k;
          this.YuV = k;
          break label297;
        }
      }
      label662:
      j = i;
      i = n;
    }
  }
  
  private void idT()
  {
    this.YuX = -1;
    this.YuU = -1;
    this.YuV = -1;
    this.YuT = -1;
  }
  
  private void idU()
  {
    AppMethodBeat.i(159802);
    this.Rh = 2;
    if ((this.Yvb != null) && (this.YuT >= 0) && (this.YuT < getCount()))
    {
      int i = getHeaderViewsCount();
      this.Yvb.eX(this.YuX - i, this.YuT - i);
    }
    iec();
    idV();
    idT();
    idY();
    if (this.Yvx)
    {
      this.Rh = 3;
      AppMethodBeat.o(159802);
      return;
    }
    this.Rh = 0;
    AppMethodBeat.o(159802);
  }
  
  private void idV()
  {
    int i = 0;
    AppMethodBeat.i(159804);
    int j = getFirstVisiblePosition();
    if (this.YuX < j)
    {
      View localView = getChildAt(0);
      if (localView != null) {
        i = localView.getTop();
      }
      setSelectionFromTop(j - 1, i - getPaddingTop());
    }
    AppMethodBeat.o(159804);
  }
  
  private void idW()
  {
    AppMethodBeat.i(159808);
    this.YvA = 0;
    this.Yvx = false;
    if (this.Rh == 3) {
      this.Rh = 0;
    }
    this.YuS = this.YuR;
    this.YvN = false;
    this.YvI.clear();
    AppMethodBeat.o(159808);
  }
  
  private void idX()
  {
    AppMethodBeat.i(159812);
    int i = getPaddingTop();
    int j = getHeight() - i - getPaddingBottom();
    float f1 = j;
    this.Yvp = (i + this.Yvk * f1);
    float f2 = i;
    this.Yvo = (f1 * (1.0F - this.Yvl) + f2);
    this.Yvm = ((int)this.Yvp);
    this.Yvn = ((int)this.Yvo);
    this.Yvq = (this.Yvp - i);
    this.Yvr = (i + j - this.Yvo);
    AppMethodBeat.o(159812);
  }
  
  private void idY()
  {
    AppMethodBeat.i(159814);
    int j = getFirstVisiblePosition();
    int k = getLastVisiblePosition();
    int i = Math.max(0, getHeaderViewsCount() - j);
    k = Math.min(k - j, getCount() - 1 - getFooterViewsCount() - j);
    while (i <= k)
    {
      View localView = getChildAt(i);
      if (localView != null) {
        a(j + i, localView, false);
      }
      i += 1;
    }
    AppMethodBeat.o(159814);
  }
  
  private void idZ()
  {
    AppMethodBeat.i(159822);
    if (this.rqz != null)
    {
      iV(this.rqz);
      this.Yvf = this.rqz.getMeasuredHeight();
      this.Yvg = (this.Yvf / 2);
    }
    AppMethodBeat.o(159822);
  }
  
  private void iea()
  {
    AppMethodBeat.i(159826);
    int i = getFirstVisiblePosition();
    int j = getChildCount() / 2;
    View localView = getChildAt(getChildCount() / 2);
    if (localView == null)
    {
      AppMethodBeat.o(159826);
      return;
    }
    d(i + j, localView, true);
    AppMethodBeat.o(159826);
  }
  
  private void ieb()
  {
    AppMethodBeat.i(159828);
    if (this.Yvy != null)
    {
      this.YuO.set(this.CD, this.CE);
      this.Yvy.m(this.YuN);
    }
    int i = this.YuN.x;
    int m = this.YuN.y;
    int j = getPaddingLeft();
    int k;
    if (((this.Yvv & 0x1) == 0) && (i > j))
    {
      this.YuN.x = j;
      j = getHeaderViewsCount();
      k = getFooterViewsCount();
      int n = getFirstVisiblePosition();
      int i1 = getLastVisiblePosition();
      i = getPaddingTop();
      if (n < j) {
        i = getChildAt(j - n - 1).getBottom();
      }
      j = i;
      if ((this.Yvv & 0x8) == 0)
      {
        j = i;
        if (n <= this.YuX) {
          j = Math.max(getChildAt(this.YuX - n).getTop(), i);
        }
      }
      i = getHeight() - getPaddingBottom();
      if (i1 >= getCount() - k - 1) {
        i = getChildAt(getCount() - k - 1 - n).getBottom();
      }
      k = i;
      if ((this.Yvv & 0x4) == 0)
      {
        k = i;
        if (i1 >= this.YuX) {
          k = Math.min(getChildAt(this.YuX - n).getBottom(), i);
        }
      }
      if (m >= j) {
        break label319;
      }
      this.YuN.y = j;
    }
    for (;;)
    {
      this.YuP = (this.YuN.y + this.Yvg);
      AppMethodBeat.o(159828);
      return;
      if (((this.Yvv & 0x2) != 0) || (i >= j)) {
        break;
      }
      this.YuN.x = j;
      break;
      label319:
      if (this.Yvf + m > k) {
        this.YuN.y = (k - this.Yvf);
      }
    }
  }
  
  private void iec()
  {
    AppMethodBeat.i(159829);
    if (this.rqz != null)
    {
      this.rqz.setVisibility(8);
      if (this.Yvy != null) {
        this.Yvy.iW(this.rqz);
      }
      this.rqz = null;
      invalidate();
    }
    AppMethodBeat.o(159829);
  }
  
  private int nd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159796);
    int i = getHeaderViewsCount();
    int j = getFooterViewsCount();
    if ((paramInt1 <= i) || (paramInt1 >= getCount() - j))
    {
      AppMethodBeat.o(159796);
      return paramInt2;
    }
    j = getDividerHeight();
    int m = this.Yvf - this.Yve;
    int k = ayV(paramInt1);
    int n = ayT(paramInt1);
    if (this.YuV <= this.YuX) {
      if ((paramInt1 == this.YuV) && (this.YuU != this.YuV)) {
        if (paramInt1 == this.YuX)
        {
          i = paramInt2 + n - this.Yvf;
          if (paramInt1 > this.YuX) {
            break label256;
          }
        }
      }
    }
    label256:
    for (paramInt1 = (this.Yvf - j - ayV(paramInt1 - 1)) / 2 + i;; paramInt1 = (k - j - this.Yvf) / 2 + i)
    {
      AppMethodBeat.o(159796);
      return paramInt1;
      i = n - k + paramInt2 - m;
      break;
      i = paramInt2;
      if (paramInt1 <= this.YuV) {
        break;
      }
      i = paramInt2;
      if (paramInt1 > this.YuX) {
        break;
      }
      i = paramInt2 - m;
      break;
      if ((paramInt1 > this.YuX) && (paramInt1 <= this.YuU))
      {
        i = paramInt2 + m;
        break;
      }
      i = paramInt2;
      if (paramInt1 != this.YuV) {
        break;
      }
      i = paramInt2;
      if (this.YuU == this.YuV) {
        break;
      }
      i = paramInt2 + (n - k);
      break;
    }
  }
  
  private int ne(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    int k;
    if ((this.YuW) && (this.YuU != this.YuV))
    {
      i = 1;
      j = this.Yvf - this.Yve;
      k = (int)(this.YvC * j);
      if (paramInt1 != this.YuX) {
        break label109;
      }
      if (this.YuX != this.YuU) {
        break label85;
      }
      if (i == 0) {
        break label80;
      }
      i = k + this.Yve;
    }
    label80:
    label85:
    label109:
    do
    {
      return i;
      i = 0;
      break;
      return this.Yvf;
      if (this.YuX == this.YuV) {
        return this.Yvf - k;
      }
      return this.Yve;
      if (paramInt1 == this.YuU)
      {
        if (i != 0) {
          return paramInt2 + k;
        }
        return paramInt2 + j;
      }
      i = paramInt2;
    } while (paramInt1 != this.YuV);
    return paramInt2 + j - k;
  }
  
  public final boolean a(int paramInt1, View paramView, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159825);
    if ((this.Rh != 0) || (!this.Yvx) || (this.rqz != null) || (paramView == null) || (!this.Yvd))
    {
      AppMethodBeat.o(159825);
      return false;
    }
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    paramInt1 = getHeaderViewsCount() + paramInt1;
    this.YuU = paramInt1;
    this.YuV = paramInt1;
    this.YuX = paramInt1;
    this.YuT = paramInt1;
    this.Rh = 4;
    this.Yvv = 0;
    this.Yvv |= paramInt2;
    this.rqz = paramView;
    idZ();
    this.YuY = paramInt3;
    this.YuZ = paramInt4;
    this.Yvu = this.CE;
    this.YuN.x = (this.CD - this.YuY);
    this.YuN.y = (this.CE - this.YuZ);
    paramView = getChildAt(this.YuX - getFirstVisiblePosition());
    if (paramView != null) {
      paramView.setVisibility(4);
    }
    if (this.YvE)
    {
      paramView = this.YvF;
      paramView.mBuilder.append("<DSLVStates>\n");
      paramView.YvY = 0;
      paramView.YvZ = true;
    }
    switch (this.YvA)
    {
    }
    for (;;)
    {
      requestLayout();
      AppMethodBeat.o(159825);
      return true;
      super.onTouchEvent(this.Yvz);
      continue;
      super.onInterceptTouchEvent(this.Yvz);
    }
  }
  
  public final boolean cX(float paramFloat)
  {
    AppMethodBeat.i(159805);
    this.YvL = true;
    boolean bool = f(true, paramFloat);
    AppMethodBeat.o(159805);
    return bool;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159794);
    super.dispatchDraw(paramCanvas);
    if (this.Rh != 0)
    {
      if (this.YuU != this.YuX) {
        a(this.YuU, paramCanvas);
      }
      if ((this.YuV != this.YuU) && (this.YuV != this.YuX)) {
        a(this.YuV, paramCanvas);
      }
    }
    int k;
    int m;
    int i;
    float f;
    if (this.rqz != null)
    {
      k = this.rqz.getWidth();
      m = this.rqz.getHeight();
      int j = this.YuN.x;
      int n = getWidth();
      i = j;
      if (j < 0) {
        i = -j;
      }
      if (i >= n) {
        break label228;
      }
      f = (n - i) / n;
    }
    label228:
    for (f *= f;; f = 0.0F)
    {
      i = (int)(f * (255.0F * this.YuS));
      paramCanvas.save();
      paramCanvas.translate(this.YuN.x, this.YuN.y);
      paramCanvas.clipRect(0, 0, k, m);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, k, m, i, 31);
      this.rqz.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.restore();
      AppMethodBeat.o(159794);
      return;
    }
  }
  
  public float getFloatAlpha()
  {
    return this.YuS;
  }
  
  public ListAdapter getInputAdapter()
  {
    if (this.YvD == null) {
      return null;
    }
    return this.YvD.eP;
  }
  
  public final void idS()
  {
    AppMethodBeat.i(159801);
    if (this.Rh == 4)
    {
      this.Yvj.ied();
      iec();
      idT();
      idY();
      if (this.Yvx)
      {
        this.Rh = 3;
        AppMethodBeat.o(159801);
        return;
      }
      this.Rh = 0;
    }
    AppMethodBeat.o(159801);
  }
  
  protected void layoutChildren()
  {
    AppMethodBeat.i(159824);
    super.layoutChildren();
    if (this.rqz != null)
    {
      if ((this.rqz.isLayoutRequested()) && (!this.YuQ)) {
        idZ();
      }
      this.rqz.layout(0, 0, this.rqz.getMeasuredWidth(), this.rqz.getMeasuredHeight());
      this.YuQ = false;
    }
    AppMethodBeat.o(159824);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159798);
    super.onDraw(paramCanvas);
    if (this.YvE)
    {
      paramCanvas = this.YvF;
      if (paramCanvas.YvZ)
      {
        paramCanvas.mBuilder.append("<DSLVState>\n");
        int j = paramCanvas.YvP.getChildCount();
        int k = paramCanvas.YvP.getFirstVisiblePosition();
        paramCanvas.mBuilder.append("    <Positions>");
        int i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(k + i).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</Positions>\n");
        paramCanvas.mBuilder.append("    <Tops>");
        i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(paramCanvas.YvP.getChildAt(i).getTop()).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</Tops>\n");
        paramCanvas.mBuilder.append("    <Bottoms>");
        i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(paramCanvas.YvP.getChildAt(i).getBottom()).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</Bottoms>\n");
        paramCanvas.mBuilder.append("    <FirstExpPos>").append(paramCanvas.YvP.YuU).append("</FirstExpPos>\n");
        paramCanvas.mBuilder.append("    <FirstExpBlankHeight>").append(paramCanvas.YvP.ayT(paramCanvas.YvP.YuU) - paramCanvas.YvP.ayV(paramCanvas.YvP.YuU)).append("</FirstExpBlankHeight>\n");
        paramCanvas.mBuilder.append("    <SecondExpPos>").append(paramCanvas.YvP.YuV).append("</SecondExpPos>\n");
        paramCanvas.mBuilder.append("    <SecondExpBlankHeight>").append(paramCanvas.YvP.ayT(paramCanvas.YvP.YuV) - paramCanvas.YvP.ayV(paramCanvas.YvP.YuV)).append("</SecondExpBlankHeight>\n");
        paramCanvas.mBuilder.append("    <SrcPos>").append(paramCanvas.YvP.YuX).append("</SrcPos>\n");
        paramCanvas.mBuilder.append("    <SrcHeight>").append(paramCanvas.YvP.Yvf + paramCanvas.YvP.getDividerHeight()).append("</SrcHeight>\n");
        paramCanvas.mBuilder.append("    <ViewHeight>").append(paramCanvas.YvP.getHeight()).append("</ViewHeight>\n");
        paramCanvas.mBuilder.append("    <LastY>").append(paramCanvas.YvP.qtD).append("</LastY>\n");
        paramCanvas.mBuilder.append("    <FloatY>").append(paramCanvas.YvP.YuP).append("</FloatY>\n");
        paramCanvas.mBuilder.append("    <ShuffleEdges>");
        i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(paramCanvas.YvP.nd(k + i, paramCanvas.YvP.getChildAt(i).getTop())).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</ShuffleEdges>\n");
        paramCanvas.mBuilder.append("</DSLVState>\n");
        paramCanvas.YvX += 1;
        if (paramCanvas.YvX > 1000)
        {
          paramCanvas.flush();
          paramCanvas.YvX = 0;
        }
      }
    }
    AppMethodBeat.o(159798);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159810);
    if (!this.Yvd)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(159810);
      return bool;
    }
    aG(paramMotionEvent);
    this.Yvw = true;
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0)
    {
      if (this.Rh != 0)
      {
        this.YvH = true;
        AppMethodBeat.o(159810);
        return true;
      }
      this.Yvx = true;
    }
    if (this.rqz != null)
    {
      bool = true;
      if ((i == 1) || (i == 3)) {
        this.Yvx = false;
      }
      AppMethodBeat.o(159810);
      return bool;
    }
    if (super.onInterceptTouchEvent(paramMotionEvent)) {
      this.YvN = true;
    }
    for (boolean bool = true;; bool = false) {
      switch (i)
      {
      case 2: 
      default: 
        if (bool) {
          this.YvA = 1;
        }
        break;
      case 1: 
      case 3: 
        idW();
        break;
        this.YvA = 2;
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159823);
    super.onMeasure(paramInt1, paramInt2);
    if (this.rqz != null)
    {
      if (this.rqz.isLayoutRequested()) {
        idZ();
      }
      this.YuQ = true;
    }
    this.Yvh = paramInt1;
    AppMethodBeat.o(159823);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159813);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    idX();
    AppMethodBeat.o(159813);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159807);
    if (this.YvH)
    {
      this.YvH = false;
      AppMethodBeat.o(159807);
      return false;
    }
    if (!this.Yvd)
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(159807);
      return bool1;
    }
    boolean bool1 = this.Yvw;
    this.Yvw = false;
    if (!bool1) {
      aG(paramMotionEvent);
    }
    boolean bool2;
    if (this.Rh == 4)
    {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
      for (;;)
      {
        bool2 = true;
        AppMethodBeat.o(159807);
        return bool2;
        if (this.Rh == 4) {
          idS();
        }
        idW();
        continue;
        if (this.Rh == 4)
        {
          this.YvL = false;
          f(false, 0.0F);
        }
        idW();
        continue;
        int j = (int)paramMotionEvent.getX();
        int i = (int)paramMotionEvent.getY();
        this.YuN.x = (j - this.YuY);
        this.YuN.y = (i - this.YuZ);
        iea();
        j = Math.min(i, this.YuP + this.Yvg);
        int k = Math.max(i, this.YuP - this.Yvg);
        paramMotionEvent = this.Yvj;
        if (paramMotionEvent.jRp) {}
        for (i = paramMotionEvent.YvV;; i = -1)
        {
          if ((j <= this.qtD) || (j <= this.Yvn) || (i == 1)) {
            break label307;
          }
          if (i != -1) {
            this.Yvj.ied();
          }
          this.Yvj.ayW(1);
          break;
        }
        label307:
        if ((k < this.qtD) && (k < this.Yvm) && (i != 0))
        {
          if (i != -1) {
            this.Yvj.ied();
          }
          this.Yvj.ayW(0);
        }
        else if ((k >= this.Yvm) && (j <= this.Yvn) && (this.Yvj.jRp))
        {
          this.Yvj.ied();
        }
      }
    }
    if ((this.Rh == 0) && (super.onTouchEvent(paramMotionEvent))) {}
    for (bool1 = true;; bool1 = false) {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 2: 
      default: 
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        this.YvA = 1;
        bool2 = bool1;
        break;
      case 1: 
      case 3: 
        idW();
        bool2 = bool1;
        break;
      }
    }
  }
  
  public final void removeItem(int paramInt)
  {
    AppMethodBeat.i(159799);
    this.YvL = false;
    D(paramInt, 0.0F);
    AppMethodBeat.o(159799);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(159819);
    if (!this.YvG) {
      super.requestLayout();
    }
    AppMethodBeat.o(159819);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(159792);
    if (paramListAdapter != null)
    {
      this.YvD = new a(paramListAdapter, (byte)0);
      paramListAdapter.registerDataSetObserver(this.mObserver);
      if ((paramListAdapter instanceof DragSortListView.h)) {
        setDropListener((DragSortListView.h)paramListAdapter);
      }
      if ((paramListAdapter instanceof DragSortListView.b)) {
        setDragListener((DragSortListView.b)paramListAdapter);
      }
      if ((paramListAdapter instanceof DragSortListView.l)) {
        setRemoveListener((DragSortListView.l)paramListAdapter);
      }
    }
    for (;;)
    {
      super.setAdapter(this.YvD);
      AppMethodBeat.o(159792);
      return;
      this.YvD = null;
    }
  }
  
  public void setDragEnabled(boolean paramBoolean)
  {
    this.Yvd = paramBoolean;
  }
  
  public void setDragListener(DragSortListView.b paramb)
  {
    this.Yva = paramb;
  }
  
  public void setDragScrollProfile(c paramc)
  {
    if (paramc != null) {
      this.Yvt = paramc;
    }
  }
  
  public void setDragScrollStart(float paramFloat)
  {
    AppMethodBeat.i(159811);
    if (paramFloat > 0.5F)
    {
      this.Yvl = 0.5F;
      if (paramFloat <= 0.5F) {
        break label58;
      }
    }
    label58:
    for (this.Yvk = 0.5F;; this.Yvk = paramFloat)
    {
      if (getHeight() != 0) {
        idX();
      }
      AppMethodBeat.o(159811);
      return;
      this.Yvl = paramFloat;
      break;
    }
  }
  
  public void setDragSortListener(DragSortListView.e parame)
  {
    AppMethodBeat.i(159830);
    setDropListener(parame);
    setDragListener(parame);
    setRemoveListener(parame);
    AppMethodBeat.o(159830);
  }
  
  public void setDropListener(DragSortListView.h paramh)
  {
    this.Yvb = paramh;
  }
  
  public void setFloatAlpha(float paramFloat)
  {
    this.YuS = paramFloat;
  }
  
  public void setFloatViewManager(i parami)
  {
    this.Yvy = parami;
  }
  
  public void setMaxScrollSpeed(float paramFloat)
  {
    this.Yvs = paramFloat;
  }
  
  public void setRemoveListener(DragSortListView.l paraml)
  {
    this.Yvc = paraml;
  }
  
  final class a
    extends BaseAdapter
  {
    ListAdapter eP;
    
    private a(ListAdapter paramListAdapter)
    {
      AppMethodBeat.i(159760);
      this.eP = paramListAdapter;
      this.eP.registerDataSetObserver(new DataSetObserver()
      {
        public final void onChanged()
        {
          AppMethodBeat.i(159758);
          DragSortListView.a.this.notifyDataSetChanged();
          AppMethodBeat.o(159758);
        }
        
        public final void onInvalidated()
        {
          AppMethodBeat.i(159759);
          DragSortListView.a.this.notifyDataSetInvalidated();
          AppMethodBeat.o(159759);
        }
      });
      AppMethodBeat.o(159760);
    }
    
    public final boolean areAllItemsEnabled()
    {
      AppMethodBeat.i(159764);
      boolean bool = this.eP.areAllItemsEnabled();
      AppMethodBeat.o(159764);
      return bool;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(159763);
      int i = this.eP.getCount();
      AppMethodBeat.o(159763);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(159762);
      Object localObject = this.eP.getItem(paramInt);
      AppMethodBeat.o(159762);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(159761);
      long l = this.eP.getItemId(paramInt);
      AppMethodBeat.o(159761);
      return l;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(159766);
      paramInt = this.eP.getItemViewType(paramInt);
      AppMethodBeat.o(159766);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(159770);
      if ((paramView != null) && ((paramView instanceof b)))
      {
        paramViewGroup = (b)paramView;
        View localView1 = paramViewGroup.getChildAt(0);
        View localView2 = this.eP.getView(paramInt, localView1, DragSortListView.this);
        paramView = paramViewGroup;
        if (localView2 != localView1)
        {
          if (localView1 != null) {
            paramViewGroup.removeViewAt(0);
          }
          paramViewGroup.addView(localView2);
          paramView = paramViewGroup;
        }
        paramViewGroup = DragSortListView.this;
        DragSortListView.a(paramViewGroup, paramViewGroup.getHeaderViewsCount() + paramInt, paramView);
        AppMethodBeat.o(159770);
        return paramView;
      }
      paramViewGroup = this.eP.getView(paramInt, null, DragSortListView.this);
      if ((paramViewGroup instanceof Checkable)) {}
      for (paramView = new c(DragSortListView.this.getContext());; paramView = new b(DragSortListView.this.getContext()))
      {
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        paramView.addView(paramViewGroup);
        break;
      }
    }
    
    public final int getViewTypeCount()
    {
      AppMethodBeat.i(159767);
      int i = this.eP.getViewTypeCount();
      AppMethodBeat.o(159767);
      return i;
    }
    
    public final boolean hasStableIds()
    {
      AppMethodBeat.i(159768);
      boolean bool = this.eP.hasStableIds();
      AppMethodBeat.o(159768);
      return bool;
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(159769);
      boolean bool = this.eP.isEmpty();
      AppMethodBeat.o(159769);
      return bool;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(159765);
      boolean bool = this.eP.isEnabled(paramInt);
      AppMethodBeat.o(159765);
      return bool;
    }
  }
  
  public static abstract interface c
  {
    public abstract float cY(float paramFloat);
  }
  
  final class d
    implements Runnable
  {
    private long Gsg;
    private long Gsh;
    private int YvS;
    private float YvT;
    private long YvU;
    int YvV;
    private float YvW;
    boolean jRp = false;
    private boolean mAbort;
    
    d() {}
    
    public final void ayW(int paramInt)
    {
      AppMethodBeat.i(159771);
      if (!this.jRp)
      {
        this.mAbort = false;
        this.jRp = true;
        this.YvU = SystemClock.uptimeMillis();
        this.Gsh = this.YvU;
        this.YvV = paramInt;
        DragSortListView.this.post(this);
      }
      AppMethodBeat.o(159771);
    }
    
    public final void ied()
    {
      AppMethodBeat.i(159772);
      DragSortListView.this.removeCallbacks(this);
      this.jRp = false;
      AppMethodBeat.o(159772);
    }
    
    public final void run()
    {
      AppMethodBeat.i(159773);
      if (this.mAbort)
      {
        this.jRp = false;
        AppMethodBeat.o(159773);
        return;
      }
      int j = DragSortListView.this.getFirstVisiblePosition();
      int i = DragSortListView.this.getLastVisiblePosition();
      int m = DragSortListView.this.getCount();
      int k = DragSortListView.this.getPaddingTop();
      int n = DragSortListView.this.getHeight() - k - DragSortListView.this.getPaddingBottom();
      int i1 = Math.min(DragSortListView.e(DragSortListView.this), DragSortListView.r(DragSortListView.this) + DragSortListView.c(DragSortListView.this));
      int i2 = Math.max(DragSortListView.e(DragSortListView.this), DragSortListView.r(DragSortListView.this) - DragSortListView.c(DragSortListView.this));
      View localView;
      if (this.YvV == 0)
      {
        localView = DragSortListView.this.getChildAt(0);
        if (localView == null)
        {
          this.jRp = false;
          AppMethodBeat.o(159773);
          return;
        }
        if ((j == 0) && (localView.getTop() == k))
        {
          this.jRp = false;
          AppMethodBeat.o(159773);
          return;
        }
        this.YvW = DragSortListView.u(DragSortListView.this).cY((DragSortListView.s(DragSortListView.this) - i2) / DragSortListView.t(DragSortListView.this));
        this.Gsg = SystemClock.uptimeMillis();
        this.YvT = ((float)(this.Gsg - this.Gsh));
        this.YvS = Math.round(this.YvW * this.YvT);
        if (this.YvS < 0) {
          break label496;
        }
        this.YvS = Math.min(n, this.YvS);
        i = j;
      }
      for (;;)
      {
        localView = DragSortListView.this.getChildAt(i - j);
        m = localView.getTop() + this.YvS;
        j = m;
        if (i == 0)
        {
          j = m;
          if (m > k) {
            j = k;
          }
        }
        DragSortListView.a(DragSortListView.this, true);
        DragSortListView.this.setSelectionFromTop(i, j - k);
        DragSortListView.this.layoutChildren();
        DragSortListView.this.invalidate();
        DragSortListView.a(DragSortListView.this, false);
        DragSortListView.c(DragSortListView.this, i, localView);
        this.Gsh = this.Gsg;
        DragSortListView.this.post(this);
        AppMethodBeat.o(159773);
        return;
        localView = DragSortListView.this.getChildAt(i - j);
        if (localView == null)
        {
          this.jRp = false;
          AppMethodBeat.o(159773);
          return;
        }
        if ((i == m - 1) && (localView.getBottom() <= n + k))
        {
          this.jRp = false;
          AppMethodBeat.o(159773);
          return;
        }
        this.YvW = (-DragSortListView.u(DragSortListView.this).cY((i1 - DragSortListView.v(DragSortListView.this)) / DragSortListView.w(DragSortListView.this)));
        break;
        label496:
        this.YvS = Math.max(-n, this.YvS);
      }
    }
  }
  
  final class g
    extends DragSortListView.m
  {
    private int Ywa;
    private int Ywb;
    private float Ywc;
    private float Ywd;
    
    private g(int paramInt)
    {
      super(0.5F, paramInt, (byte)0);
    }
    
    private int iee()
    {
      AppMethodBeat.i(159778);
      int i = DragSortListView.this.getFirstVisiblePosition();
      int j = (DragSortListView.i(DragSortListView.this) + DragSortListView.this.getDividerHeight()) / 2;
      View localView = DragSortListView.this.getChildAt(this.Ywa - i);
      i = -1;
      if (localView != null) {
        if (this.Ywa == this.Ywb) {
          i = localView.getTop();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(159778);
        return i;
        if (this.Ywa < this.Ywb)
        {
          i = localView.getTop() - j;
        }
        else
        {
          i = localView.getBottom() + j - DragSortListView.j(DragSortListView.this);
          continue;
          cancel();
        }
      }
    }
    
    public final void cZ(float paramFloat)
    {
      AppMethodBeat.i(159779);
      int i = iee();
      int j = DragSortListView.this.getPaddingLeft();
      float f1 = DragSortListView.d(DragSortListView.this).y - i;
      float f2 = DragSortListView.d(DragSortListView.this).x - j;
      paramFloat = 1.0F - paramFloat;
      if ((paramFloat < Math.abs(f1 / this.Ywc)) || (paramFloat < Math.abs(f2 / this.Ywd)))
      {
        DragSortListView.d(DragSortListView.this).y = (i + (int)(this.Ywc * paramFloat));
        DragSortListView.d(DragSortListView.this).x = (DragSortListView.this.getPaddingLeft() + (int)(this.Ywd * paramFloat));
        DragSortListView.f(DragSortListView.this);
      }
      AppMethodBeat.o(159779);
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(159777);
      this.Ywa = DragSortListView.g(DragSortListView.this);
      this.Ywb = DragSortListView.h(DragSortListView.this);
      DragSortListView.a(DragSortListView.this, 2);
      this.Ywc = (DragSortListView.d(DragSortListView.this).y - iee());
      this.Ywd = (DragSortListView.d(DragSortListView.this).x - DragSortListView.this.getPaddingLeft());
      AppMethodBeat.o(159777);
    }
    
    public final void onStop()
    {
      AppMethodBeat.i(159780);
      DragSortListView.k(DragSortListView.this);
      AppMethodBeat.o(159780);
    }
  }
  
  public static abstract interface i
  {
    public abstract View ayX(int paramInt);
    
    public abstract void iW(View paramView);
    
    public abstract void m(Point paramPoint);
  }
  
  final class k
    extends DragSortListView.m
  {
    private float Ywg;
    private float Ywh;
    private float Ywi;
    private int Ywj = -1;
    private int Ywk = -1;
    private int Ywl;
    private int jjV;
    
    private k(int paramInt)
    {
      super(0.5F, paramInt, (byte)0);
    }
    
    public final void cZ(float paramFloat)
    {
      AppMethodBeat.i(159786);
      paramFloat = 1.0F - paramFloat;
      int j = DragSortListView.this.getFirstVisiblePosition();
      View localView = DragSortListView.this.getChildAt(this.jjV - j);
      Object localObject;
      int i;
      if (DragSortListView.n(DragSortListView.this))
      {
        float f1 = (float)(SystemClock.uptimeMillis() - this.mStartTime) / 1000.0F;
        if (f1 == 0.0F)
        {
          AppMethodBeat.o(159786);
          return;
        }
        float f2 = DragSortListView.o(DragSortListView.this);
        int k = DragSortListView.this.getWidth();
        localObject = DragSortListView.this;
        float f3 = DragSortListView.o(DragSortListView.this);
        if (DragSortListView.o(DragSortListView.this) > 0.0F) {}
        for (i = 1;; i = -1)
        {
          DragSortListView.a((DragSortListView)localObject, i * f1 * k + f3);
          this.Ywg += f2 * f1;
          DragSortListView.d(DragSortListView.this).x = ((int)this.Ywg);
          if ((this.Ywg >= k) || (this.Ywg <= -k)) {
            break;
          }
          this.mStartTime = SystemClock.uptimeMillis();
          DragSortListView.f(DragSortListView.this);
          AppMethodBeat.o(159786);
          return;
        }
      }
      if (localView != null)
      {
        if (this.Ywj == -1)
        {
          this.Ywj = DragSortListView.b(DragSortListView.this, this.jjV, localView);
          this.Ywh = (localView.getHeight() - this.Ywj);
        }
        i = Math.max((int)(this.Ywh * paramFloat), 1);
        localObject = localView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = (i + this.Ywj);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.Ywl != this.jjV)
      {
        localView = DragSortListView.this.getChildAt(this.Ywl - j);
        if (localView != null)
        {
          if (this.Ywk == -1)
          {
            this.Ywk = DragSortListView.b(DragSortListView.this, this.Ywl, localView);
            this.Ywi = (localView.getHeight() - this.Ywk);
          }
          i = Math.max((int)(this.Ywi * paramFloat), 1);
          localObject = localView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = (i + this.Ywk);
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(159786);
    }
    
    public final void onStart()
    {
      int i = -1;
      AppMethodBeat.i(159785);
      this.Ywj = -1;
      this.Ywk = -1;
      this.jjV = DragSortListView.l(DragSortListView.this);
      this.Ywl = DragSortListView.m(DragSortListView.this);
      DragSortListView.a(DragSortListView.this, 1);
      this.Ywg = DragSortListView.d(DragSortListView.this).x;
      if (DragSortListView.n(DragSortListView.this))
      {
        float f = DragSortListView.this.getWidth() * 2.0F;
        if (DragSortListView.o(DragSortListView.this) == 0.0F)
        {
          DragSortListView localDragSortListView = DragSortListView.this;
          if (this.Ywg < 0.0F) {}
          for (;;)
          {
            DragSortListView.a(localDragSortListView, i * f);
            AppMethodBeat.o(159785);
            return;
            i = 1;
          }
        }
        f *= 2.0F;
        if ((DragSortListView.o(DragSortListView.this) < 0.0F) && (DragSortListView.o(DragSortListView.this) > -f))
        {
          DragSortListView.a(DragSortListView.this, -f);
          AppMethodBeat.o(159785);
          return;
        }
        if ((DragSortListView.o(DragSortListView.this) > 0.0F) && (DragSortListView.o(DragSortListView.this) < f)) {
          DragSortListView.a(DragSortListView.this, f);
        }
        AppMethodBeat.o(159785);
        return;
      }
      DragSortListView.p(DragSortListView.this);
      AppMethodBeat.o(159785);
    }
    
    public final void onStop()
    {
      AppMethodBeat.i(159787);
      DragSortListView.q(DragSortListView.this);
      AppMethodBeat.o(159787);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView
 * JD-Core Version:    0.7.0.1
 */