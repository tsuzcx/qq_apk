package com.tencent.mm.ui.widget.sortlist;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseIntArray;
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
import com.tencent.mm.ck.a.k;
import com.tencent.mm.ui.bc;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DragSortListView
  extends ListView
{
  private View[] agnA;
  private d agnB;
  private float agnC;
  private float agnD;
  private int agnE;
  private int agnF;
  private float agnG;
  private float agnH;
  private float agnI;
  private float agnJ;
  private float agnK;
  private c agnL;
  private int agnM;
  private int agnN;
  private boolean agnO;
  boolean agnP;
  i agnQ;
  private MotionEvent agnR;
  private int agnS;
  private float agnT;
  private float agnU;
  private a agnV;
  private boolean agnW;
  private f agnX;
  private boolean agnY;
  private boolean agnZ;
  private Point agng;
  private Point agnh;
  private int agni;
  private boolean agnj;
  private float agnk;
  private float agnl;
  private int agnm;
  private int agnn;
  private int agno;
  private int agnp;
  private int agnq;
  private int agnr;
  private DragSortListView.b agns;
  private DragSortListView.h agnt;
  private DragSortListView.l agnu;
  boolean agnv;
  private int agnw;
  private int agnx;
  private int agny;
  private int agnz;
  private j agoa;
  private k agob;
  private g agoc;
  private boolean agod;
  private float agoe;
  boolean agof;
  private boolean agog;
  private int biL;
  private int biM;
  private int biT;
  private int biU;
  private int bxy;
  private boolean mAnimate;
  private DataSetObserver mObserver;
  private int tyh;
  private int tyi;
  private View uAI;
  
  public DragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159791);
    this.agng = new Point();
    this.agnh = new Point();
    this.agnj = false;
    this.agnk = 1.0F;
    this.agnl = 1.0F;
    this.mAnimate = false;
    this.agnv = true;
    this.bxy = 0;
    this.agnw = 1;
    this.agnz = 0;
    this.agnA = new View[1];
    this.agnC = 0.3333333F;
    this.agnD = 0.3333333F;
    this.agnK = 0.5F;
    this.agnL = new c()
    {
      public final float em(float paramAnonymousFloat)
      {
        AppMethodBeat.i(159754);
        float f = DragSortListView.a(DragSortListView.this);
        AppMethodBeat.o(159754);
        return f * paramAnonymousFloat;
      }
    };
    this.agnN = 0;
    this.agnO = false;
    this.agnP = false;
    this.agnQ = null;
    this.agnS = 0;
    this.agnT = 0.25F;
    this.agnU = 0.0F;
    this.agnW = false;
    this.agnY = false;
    this.agnZ = false;
    this.agoa = new j((byte)0);
    this.agoe = 0.0F;
    this.agof = false;
    this.agog = false;
    int j = 150;
    int i = 150;
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, a.k.DragSortListView, 0, 0);
      this.agnw = Math.max(1, paramContext.getDimensionPixelSize(a.k.DragSortListView_collapsed_height, 1));
      this.agnW = paramContext.getBoolean(a.k.DragSortListView_track_drag_sort, false);
      if (this.agnW) {
        this.agnX = new f();
      }
      this.agnk = paramContext.getFloat(a.k.DragSortListView_float_alpha, this.agnk);
      this.agnl = this.agnk;
      this.agnv = paramContext.getBoolean(a.k.DragSortListView_drag_enabled, this.agnv);
      this.agnT = Math.max(0.0F, Math.min(1.0F, 1.0F - paramContext.getFloat(a.k.DragSortListView_slide_shuffle_speed, 0.75F)));
      if (this.agnT <= 0.0F) {
        break label628;
      }
    }
    label628:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.mAnimate = bool1;
      setDragScrollStart(paramContext.getFloat(a.k.DragSortListView_drag_scroll_start, this.agnC));
      this.agnK = paramContext.getFloat(a.k.DragSortListView_max_drag_scroll_speed, this.agnK);
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
        paramAttributeSet.agmP = bool1;
        paramAttributeSet.agmO = bool2;
        paramAttributeSet.agoK = i3;
        this.agnQ = paramAttributeSet;
        setOnTouchListener(paramAttributeSet);
      }
      paramContext.recycle();
      this.agnB = new d();
      if (j > 0) {
        this.agob = new k(j, (byte)0);
      }
      if (i > 0) {
        this.agoc = new g(i, (byte)0);
      }
      this.agnR = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
      this.mObserver = new DataSetObserver()
      {
        private void cancel()
        {
          AppMethodBeat.i(159755);
          if (DragSortListView.b(DragSortListView.this) == 4) {
            DragSortListView.this.jJa();
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
  
  private void G(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(159800);
    if ((this.bxy == 0) || (this.bxy == 4))
    {
      if (this.bxy == 0)
      {
        this.agnp = (getHeaderViewsCount() + paramInt);
        this.agnn = this.agnp;
        this.agno = this.agnp;
        this.agnm = this.agnp;
        View localView = getChildAt(this.agnp - getFirstVisiblePosition());
        if (localView != null) {
          localView.setVisibility(4);
        }
      }
      this.bxy = 1;
      this.agoe = paramFloat;
      if (this.agnP) {
        switch (this.agnS)
        {
        }
      }
      while (this.agob != null)
      {
        this.agob.start();
        AppMethodBeat.o(159800);
        return;
        super.onTouchEvent(this.agnR);
        continue;
        super.onInterceptTouchEvent(this.agnR);
      }
      aFz(paramInt);
    }
    AppMethodBeat.o(159800);
  }
  
  private int a(int paramInt1, View paramView, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159820);
    int i = aFA(paramInt1);
    int m = paramView.getHeight();
    int n = pa(paramInt1, i);
    int j;
    if (paramInt1 != this.agnp)
    {
      j = m - i;
      i = n - i;
    }
    for (;;)
    {
      int i1 = this.agnx;
      int k = i1;
      if (this.agnp != this.agnn)
      {
        k = i1;
        if (this.agnp != this.agno) {
          k = i1 - this.agnw;
        }
      }
      if (paramInt1 <= paramInt2)
      {
        if (paramInt1 <= this.agnn) {
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
          if (paramInt1 <= this.agnn) {
            paramInt1 = j - k + 0;
          } else if (paramInt1 == this.agno) {
            paramInt1 = m - n + 0;
          } else {
            paramInt1 = j + 0;
          }
        }
        else if (paramInt1 <= this.agnn) {
          paramInt1 = 0 - k;
        } else if (paramInt1 == this.agno) {
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
        if (paramInt <= this.agnp) {
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
    if ((paramInt != this.agnp) && (paramInt != this.agnn) && (paramInt != this.agno))
    {
      i = -2;
      if (i != localLayoutParams.height)
      {
        localLayoutParams.height = i;
        paramView.setLayoutParams(localLayoutParams);
      }
      if ((paramInt == this.agnn) || (paramInt == this.agno))
      {
        if (paramInt >= this.agnp) {
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
      if (paramInt == this.agnp)
      {
        i = j;
        if (this.uAI != null) {
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
      if (paramInt > this.agnp) {
        ((b)paramView).setGravity(48);
      }
    }
  }
  
  private int aFA(int paramInt)
  {
    AppMethodBeat.i(159816);
    if (paramInt == this.agnp)
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
    int i = this.agoa.get(paramInt);
    if (i != -1)
    {
      AppMethodBeat.o(159816);
      return i;
    }
    localObject = getAdapter();
    i = ((ListAdapter)localObject).getItemViewType(paramInt);
    int j = ((ListAdapter)localObject).getViewTypeCount();
    if (j != this.agnA.length) {
      this.agnA = new View[j];
    }
    if (i >= 0) {
      if (this.agnA[i] == null)
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
        this.agnA[i] = localObject;
      }
    }
    for (;;)
    {
      i = b(paramInt, (View)localObject, true);
      this.agoa.pb(paramInt, i);
      AppMethodBeat.o(159816);
      return i;
      localObject = ((ListAdapter)localObject).getView(paramInt, this.agnA[i], this);
      continue;
      localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
    }
  }
  
  private int aFy(int paramInt)
  {
    AppMethodBeat.i(159795);
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null)
    {
      paramInt = localView.getHeight();
      AppMethodBeat.o(159795);
      return paramInt;
    }
    paramInt = pa(paramInt, aFA(paramInt));
    AppMethodBeat.o(159795);
    return paramInt;
  }
  
  private void aFz(int paramInt)
  {
    AppMethodBeat.i(159803);
    this.bxy = 1;
    if (this.agnu != null) {
      this.agnu.remove(paramInt);
    }
    jJk();
    jJd();
    jJb();
    if (this.agnP)
    {
      this.bxy = 3;
      AppMethodBeat.o(159803);
      return;
    }
    this.bxy = 0;
    AppMethodBeat.o(159803);
  }
  
  private void aJ(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159809);
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      this.tyh = this.biL;
      this.tyi = this.biM;
    }
    this.biL = ((int)paramMotionEvent.getX());
    this.biM = ((int)paramMotionEvent.getY());
    if (i == 0)
    {
      this.tyh = this.biL;
      this.tyi = this.biM;
    }
    this.biT = ((int)paramMotionEvent.getRawX() - this.biL);
    this.biU = ((int)paramMotionEvent.getRawY() - this.biM);
    AppMethodBeat.o(159809);
  }
  
  private int b(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159817);
    if (paramInt == this.agnp)
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
      ms(localView);
      paramInt = localView.getMeasuredHeight();
    }
    AppMethodBeat.o(159817);
    return paramInt;
  }
  
  private int c(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159818);
    paramInt = pa(paramInt, b(paramInt, paramView, paramBoolean));
    AppMethodBeat.o(159818);
    return paramInt;
  }
  
  private void d(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159827);
    this.agnY = true;
    jJj();
    int i = this.agnn;
    int j = this.agno;
    boolean bool = jIZ();
    if (bool)
    {
      jJg();
      setSelectionFromTop(paramInt, a(paramInt, paramView, i, j) + paramView.getTop() - getPaddingTop());
      layoutChildren();
    }
    if ((bool) || (paramBoolean)) {
      invalidate();
    }
    this.agnY = false;
    AppMethodBeat.o(159827);
  }
  
  private boolean f(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(159806);
    if (this.uAI != null)
    {
      this.agnB.jJl();
      if (paramBoolean) {
        G(this.agnp - getHeaderViewsCount(), paramFloat);
      }
      for (;;)
      {
        if (this.agnW) {
          this.agnX.jJm();
        }
        AppMethodBeat.o(159806);
        return true;
        if (this.agoc != null) {
          this.agoc.start();
        } else {
          jJc();
        }
      }
    }
    AppMethodBeat.o(159806);
    return false;
  }
  
  private boolean jIZ()
  {
    boolean bool2 = true;
    AppMethodBeat.i(159797);
    int j = getFirstVisiblePosition();
    int i = this.agnn;
    View localView2 = getChildAt(i - j);
    View localView1 = localView2;
    if (localView2 == null)
    {
      i = j + getChildCount() / 2;
      localView1 = getChildAt(i - j);
    }
    int i2 = localView1.getTop();
    int i1 = localView1.getHeight();
    j = oZ(i, i2);
    int i3 = getDividerHeight();
    int k;
    int m;
    int n;
    if (this.agni < j)
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
      i = aFy(i1);
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
      i1 = this.agnn;
      i2 = this.agno;
      float f1 = this.agnU;
      int i4;
      label207:
      float f2;
      if (this.mAnimate)
      {
        i4 = Math.abs(i - j);
        if (this.agni < i)
        {
          m = (int)(this.agnT * 0.5F * i4);
          f2 = m;
          j += m;
          if (this.agni >= j) {
            break label552;
          }
          this.agnn = (k - 1);
          this.agno = k;
          this.agnU = ((j - this.agni) * 0.5F / f2);
          label272:
          if (this.agnn >= n) {
            break label613;
          }
          this.agnn = n;
          this.agno = n;
          k = n;
          label297:
          if ((this.agnn == i1) && (this.agno == i2) && (Math.abs(this.agnU - f1) <= 0.0F)) {
            break label656;
          }
        }
      }
      label656:
      for (boolean bool1 = true;; bool1 = false)
      {
        if (k != this.agnm)
        {
          this.agnm = k;
          bool1 = bool2;
        }
        for (;;)
        {
          AppMethodBeat.o(159797);
          return bool1;
          i2 -= i + i3;
          m = oZ(i1, i2);
          i = m;
          k = i1;
          if (this.agni >= m) {
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
            i1 = aFy(m + 1);
            n = oZ(m + 1, i2);
            i = n;
            k = m;
            if (this.agni < n) {
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
          if (this.agni >= i - m)
          {
            this.agnn = k;
            this.agno = (k + 1);
            this.agnU = ((1.0F + (i - this.agni) / f2) * 0.5F);
            break label272;
          }
          this.agnn = k;
          this.agno = k;
          break label272;
          label613:
          if (this.agno < getCount() - i3) {
            break label297;
          }
          k = getCount() - i3 - 1;
          this.agnn = k;
          this.agno = k;
          break label297;
        }
      }
      label662:
      j = i;
      i = n;
    }
  }
  
  private void jJb()
  {
    this.agnp = -1;
    this.agnn = -1;
    this.agno = -1;
    this.agnm = -1;
  }
  
  private void jJc()
  {
    AppMethodBeat.i(159802);
    this.bxy = 2;
    if ((this.agnt != null) && (this.agnm >= 0) && (this.agnm < getCount()))
    {
      int i = getHeaderViewsCount();
      this.agnt.drop(this.agnp - i, this.agnm - i);
    }
    jJk();
    jJd();
    jJb();
    jJg();
    if (this.agnP)
    {
      this.bxy = 3;
      AppMethodBeat.o(159802);
      return;
    }
    this.bxy = 0;
    AppMethodBeat.o(159802);
  }
  
  private void jJd()
  {
    int i = 0;
    AppMethodBeat.i(159804);
    int j = getFirstVisiblePosition();
    if (this.agnp < j)
    {
      View localView = getChildAt(0);
      if (localView != null) {
        i = localView.getTop();
      }
      setSelectionFromTop(j - 1, i - getPaddingTop());
    }
    AppMethodBeat.o(159804);
  }
  
  private void jJe()
  {
    AppMethodBeat.i(159808);
    this.agnS = 0;
    this.agnP = false;
    if (this.bxy == 3) {
      this.bxy = 0;
    }
    this.agnl = this.agnk;
    this.agof = false;
    this.agoa.clear();
    AppMethodBeat.o(159808);
  }
  
  private void jJf()
  {
    AppMethodBeat.i(159812);
    int i = getPaddingTop();
    int j = getHeight() - i - getPaddingBottom();
    float f1 = j;
    this.agnH = (i + this.agnC * f1);
    float f2 = i;
    this.agnG = (f1 * (1.0F - this.agnD) + f2);
    this.agnE = ((int)this.agnH);
    this.agnF = ((int)this.agnG);
    this.agnI = (this.agnH - i);
    this.agnJ = (i + j - this.agnG);
    AppMethodBeat.o(159812);
  }
  
  private void jJg()
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
  
  private void jJh()
  {
    AppMethodBeat.i(159822);
    if (this.uAI != null)
    {
      ms(this.uAI);
      this.agnx = this.uAI.getMeasuredHeight();
      this.agny = (this.agnx / 2);
    }
    AppMethodBeat.o(159822);
  }
  
  private void jJi()
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
  
  private void jJj()
  {
    AppMethodBeat.i(159828);
    if (this.agnQ != null)
    {
      this.agnh.set(this.biL, this.biM);
      this.agnQ.o(this.agng);
    }
    int i = this.agng.x;
    int m = this.agng.y;
    int j = getPaddingLeft();
    int k;
    if (((this.agnN & 0x1) == 0) && (i > j))
    {
      this.agng.x = j;
      j = getHeaderViewsCount();
      k = getFooterViewsCount();
      int n = getFirstVisiblePosition();
      int i1 = getLastVisiblePosition();
      i = getPaddingTop();
      if (n < j) {
        i = getChildAt(j - n - 1).getBottom();
      }
      j = i;
      if ((this.agnN & 0x8) == 0)
      {
        j = i;
        if (n <= this.agnp) {
          j = Math.max(getChildAt(this.agnp - n).getTop(), i);
        }
      }
      i = getHeight() - getPaddingBottom();
      if (i1 >= getCount() - k - 1) {
        i = getChildAt(getCount() - k - 1 - n).getBottom();
      }
      k = i;
      if ((this.agnN & 0x4) == 0)
      {
        k = i;
        if (i1 >= this.agnp) {
          k = Math.min(getChildAt(this.agnp - n).getBottom(), i);
        }
      }
      if (m >= j) {
        break label319;
      }
      this.agng.y = j;
    }
    for (;;)
    {
      this.agni = (this.agng.y + this.agny);
      AppMethodBeat.o(159828);
      return;
      if (((this.agnN & 0x2) != 0) || (i >= j)) {
        break;
      }
      this.agng.x = j;
      break;
      label319:
      if (this.agnx + m > k) {
        this.agng.y = (k - this.agnx);
      }
    }
  }
  
  private void jJk()
  {
    AppMethodBeat.i(159829);
    if (this.uAI != null)
    {
      this.uAI.setVisibility(8);
      if (this.agnQ != null) {
        this.agnQ.mt(this.uAI);
      }
      this.uAI = null;
      invalidate();
    }
    AppMethodBeat.o(159829);
  }
  
  private void ms(View paramView)
  {
    AppMethodBeat.i(159821);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null)
    {
      localObject = new AbsListView.LayoutParams(-1, -2);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int j = ViewGroup.getChildMeasureSpec(this.agnz, getListPaddingLeft() + getListPaddingRight(), ((ViewGroup.LayoutParams)localObject).width);
    if (((ViewGroup.LayoutParams)localObject).height > 0) {}
    for (int i = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(j, i);
      AppMethodBeat.o(159821);
      return;
    }
  }
  
  private int oZ(int paramInt1, int paramInt2)
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
    int m = this.agnx - this.agnw;
    int k = aFA(paramInt1);
    int n = aFy(paramInt1);
    if (this.agno <= this.agnp) {
      if ((paramInt1 == this.agno) && (this.agnn != this.agno)) {
        if (paramInt1 == this.agnp)
        {
          i = paramInt2 + n - this.agnx;
          if (paramInt1 > this.agnp) {
            break label256;
          }
        }
      }
    }
    label256:
    for (paramInt1 = (this.agnx - j - aFA(paramInt1 - 1)) / 2 + i;; paramInt1 = (k - j - this.agnx) / 2 + i)
    {
      AppMethodBeat.o(159796);
      return paramInt1;
      i = n - k + paramInt2 - m;
      break;
      i = paramInt2;
      if (paramInt1 <= this.agno) {
        break;
      }
      i = paramInt2;
      if (paramInt1 > this.agnp) {
        break;
      }
      i = paramInt2 - m;
      break;
      if ((paramInt1 > this.agnp) && (paramInt1 <= this.agnn))
      {
        i = paramInt2 + m;
        break;
      }
      i = paramInt2;
      if (paramInt1 != this.agno) {
        break;
      }
      i = paramInt2;
      if (this.agnn == this.agno) {
        break;
      }
      i = paramInt2 + (n - k);
      break;
    }
  }
  
  private int pa(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    int k;
    if ((this.mAnimate) && (this.agnn != this.agno))
    {
      i = 1;
      j = this.agnx - this.agnw;
      k = (int)(this.agnU * j);
      if (paramInt1 != this.agnp) {
        break label109;
      }
      if (this.agnp != this.agnn) {
        break label85;
      }
      if (i == 0) {
        break label80;
      }
      i = k + this.agnw;
    }
    label80:
    label85:
    label109:
    do
    {
      return i;
      i = 0;
      break;
      return this.agnx;
      if (this.agnp == this.agno) {
        return this.agnx - k;
      }
      return this.agnw;
      if (paramInt1 == this.agnn)
      {
        if (i != 0) {
          return paramInt2 + k;
        }
        return paramInt2 + j;
      }
      i = paramInt2;
    } while (paramInt1 != this.agno);
    return paramInt2 + j - k;
  }
  
  public final boolean a(int paramInt1, View paramView, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159825);
    if ((this.bxy != 0) || (!this.agnP) || (this.uAI != null) || (paramView == null) || (!this.agnv))
    {
      AppMethodBeat.o(159825);
      return false;
    }
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    paramInt1 = getHeaderViewsCount() + paramInt1;
    this.agnn = paramInt1;
    this.agno = paramInt1;
    this.agnp = paramInt1;
    this.agnm = paramInt1;
    this.bxy = 4;
    this.agnN = 0;
    this.agnN |= paramInt2;
    this.uAI = paramView;
    jJh();
    this.agnq = paramInt3;
    this.agnr = paramInt4;
    this.agnM = this.biM;
    this.agng.x = (this.biL - this.agnq);
    this.agng.y = (this.biM - this.agnr);
    paramView = getChildAt(this.agnp - getFirstVisiblePosition());
    if (paramView != null) {
      paramView.setVisibility(4);
    }
    if (this.agnW)
    {
      paramView = this.agnX;
      paramView.mBuilder.append("<DSLVStates>\n");
      paramView.agoq = 0;
      paramView.agor = true;
    }
    switch (this.agnS)
    {
    }
    for (;;)
    {
      requestLayout();
      AppMethodBeat.o(159825);
      return true;
      super.onTouchEvent(this.agnR);
      continue;
      super.onInterceptTouchEvent(this.agnR);
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159794);
    super.dispatchDraw(paramCanvas);
    if (this.bxy != 0)
    {
      if (this.agnn != this.agnp) {
        a(this.agnn, paramCanvas);
      }
      if ((this.agno != this.agnn) && (this.agno != this.agnp)) {
        a(this.agno, paramCanvas);
      }
    }
    int k;
    int m;
    int i;
    float f;
    if (this.uAI != null)
    {
      k = this.uAI.getWidth();
      m = this.uAI.getHeight();
      int j = this.agng.x;
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
      i = (int)(f * (255.0F * this.agnl));
      paramCanvas.save();
      paramCanvas.translate(this.agng.x, this.agng.y);
      paramCanvas.clipRect(0, 0, k, m);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, k, m, i, 31);
      this.uAI.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.restore();
      AppMethodBeat.o(159794);
      return;
    }
  }
  
  public final boolean el(float paramFloat)
  {
    AppMethodBeat.i(159805);
    this.agod = true;
    boolean bool = f(true, paramFloat);
    AppMethodBeat.o(159805);
    return bool;
  }
  
  public float getFloatAlpha()
  {
    return this.agnl;
  }
  
  public ListAdapter getInputAdapter()
  {
    if (this.agnV == null) {
      return null;
    }
    return this.agnV.fR;
  }
  
  public final void jJa()
  {
    AppMethodBeat.i(159801);
    if (this.bxy == 4)
    {
      this.agnB.jJl();
      jJk();
      jJb();
      jJg();
      if (this.agnP)
      {
        this.bxy = 3;
        AppMethodBeat.o(159801);
        return;
      }
      this.bxy = 0;
    }
    AppMethodBeat.o(159801);
  }
  
  protected void layoutChildren()
  {
    AppMethodBeat.i(159824);
    super.layoutChildren();
    if (this.uAI != null)
    {
      if ((this.uAI.isLayoutRequested()) && (!this.agnj)) {
        jJh();
      }
      this.uAI.layout(0, 0, this.uAI.getMeasuredWidth(), this.uAI.getMeasuredHeight());
      this.agnj = false;
    }
    AppMethodBeat.o(159824);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159798);
    super.onDraw(paramCanvas);
    if (this.agnW)
    {
      paramCanvas = this.agnX;
      if (paramCanvas.agor)
      {
        paramCanvas.mBuilder.append("<DSLVState>\n");
        int j = paramCanvas.agoh.getChildCount();
        int k = paramCanvas.agoh.getFirstVisiblePosition();
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
          paramCanvas.mBuilder.append(paramCanvas.agoh.getChildAt(i).getTop()).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</Tops>\n");
        paramCanvas.mBuilder.append("    <Bottoms>");
        i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(paramCanvas.agoh.getChildAt(i).getBottom()).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</Bottoms>\n");
        paramCanvas.mBuilder.append("    <FirstExpPos>").append(paramCanvas.agoh.agnn).append("</FirstExpPos>\n");
        paramCanvas.mBuilder.append("    <FirstExpBlankHeight>").append(paramCanvas.agoh.aFy(paramCanvas.agoh.agnn) - paramCanvas.agoh.aFA(paramCanvas.agoh.agnn)).append("</FirstExpBlankHeight>\n");
        paramCanvas.mBuilder.append("    <SecondExpPos>").append(paramCanvas.agoh.agno).append("</SecondExpPos>\n");
        paramCanvas.mBuilder.append("    <SecondExpBlankHeight>").append(paramCanvas.agoh.aFy(paramCanvas.agoh.agno) - paramCanvas.agoh.aFA(paramCanvas.agoh.agno)).append("</SecondExpBlankHeight>\n");
        paramCanvas.mBuilder.append("    <SrcPos>").append(paramCanvas.agoh.agnp).append("</SrcPos>\n");
        paramCanvas.mBuilder.append("    <SrcHeight>").append(paramCanvas.agoh.agnx + paramCanvas.agoh.getDividerHeight()).append("</SrcHeight>\n");
        paramCanvas.mBuilder.append("    <ViewHeight>").append(paramCanvas.agoh.getHeight()).append("</ViewHeight>\n");
        paramCanvas.mBuilder.append("    <LastY>").append(paramCanvas.agoh.tyi).append("</LastY>\n");
        paramCanvas.mBuilder.append("    <FloatY>").append(paramCanvas.agoh.agni).append("</FloatY>\n");
        paramCanvas.mBuilder.append("    <ShuffleEdges>");
        i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(paramCanvas.agoh.oZ(k + i, paramCanvas.agoh.getChildAt(i).getTop())).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</ShuffleEdges>\n");
        paramCanvas.mBuilder.append("</DSLVState>\n");
        paramCanvas.agop += 1;
        if (paramCanvas.agop > 1000)
        {
          paramCanvas.flush();
          paramCanvas.agop = 0;
        }
      }
    }
    AppMethodBeat.o(159798);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159810);
    if (!this.agnv)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(159810);
      return bool;
    }
    aJ(paramMotionEvent);
    this.agnO = true;
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0)
    {
      if (this.bxy != 0)
      {
        this.agnZ = true;
        AppMethodBeat.o(159810);
        return true;
      }
      this.agnP = true;
    }
    if (this.uAI != null)
    {
      bool = true;
      if ((i == 1) || (i == 3)) {
        this.agnP = false;
      }
      AppMethodBeat.o(159810);
      return bool;
    }
    if (super.onInterceptTouchEvent(paramMotionEvent)) {
      this.agof = true;
    }
    for (boolean bool = true;; bool = false) {
      switch (i)
      {
      case 2: 
      default: 
        if (bool) {
          this.agnS = 1;
        }
        break;
      case 1: 
      case 3: 
        jJe();
        break;
        this.agnS = 2;
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159823);
    super.onMeasure(paramInt1, paramInt2);
    if (this.uAI != null)
    {
      if (this.uAI.isLayoutRequested()) {
        jJh();
      }
      this.agnj = true;
    }
    this.agnz = paramInt1;
    AppMethodBeat.o(159823);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159813);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    jJf();
    AppMethodBeat.o(159813);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159807);
    if (this.agnZ)
    {
      this.agnZ = false;
      AppMethodBeat.o(159807);
      return false;
    }
    if (!this.agnv)
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(159807);
      return bool1;
    }
    boolean bool1 = this.agnO;
    this.agnO = false;
    if (!bool1) {
      aJ(paramMotionEvent);
    }
    boolean bool2;
    if (this.bxy == 4)
    {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
      for (;;)
      {
        bool2 = true;
        AppMethodBeat.o(159807);
        return bool2;
        if (this.bxy == 4) {
          jJa();
        }
        jJe();
        continue;
        if (this.bxy == 4)
        {
          this.agod = false;
          f(false, 0.0F);
        }
        jJe();
        continue;
        int j = (int)paramMotionEvent.getX();
        int i = (int)paramMotionEvent.getY();
        this.agng.x = (j - this.agnq);
        this.agng.y = (i - this.agnr);
        jJi();
        j = Math.min(i, this.agni + this.agny);
        int k = Math.max(i, this.agni - this.agny);
        paramMotionEvent = this.agnB;
        if (paramMotionEvent.mqz) {}
        for (i = paramMotionEvent.agon;; i = -1)
        {
          if ((j <= this.tyi) || (j <= this.agnF) || (i == 1)) {
            break label307;
          }
          if (i != -1) {
            this.agnB.jJl();
          }
          this.agnB.aFB(1);
          break;
        }
        label307:
        if ((k < this.tyi) && (k < this.agnE) && (i != 0))
        {
          if (i != -1) {
            this.agnB.jJl();
          }
          this.agnB.aFB(0);
        }
        else if ((k >= this.agnE) && (j <= this.agnF) && (this.agnB.mqz))
        {
          this.agnB.jJl();
        }
      }
    }
    if ((this.bxy == 0) && (super.onTouchEvent(paramMotionEvent))) {}
    for (bool1 = true;; bool1 = false) {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 2: 
      default: 
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        this.agnS = 1;
        bool2 = bool1;
        break;
      case 1: 
      case 3: 
        jJe();
        bool2 = bool1;
        break;
      }
    }
  }
  
  public final void removeItem(int paramInt)
  {
    AppMethodBeat.i(159799);
    this.agod = false;
    G(paramInt, 0.0F);
    AppMethodBeat.o(159799);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(159819);
    if (!this.agnY) {
      super.requestLayout();
    }
    AppMethodBeat.o(159819);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(159792);
    if (paramListAdapter != null)
    {
      this.agnV = new a(paramListAdapter, (byte)0);
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
      super.setAdapter(this.agnV);
      AppMethodBeat.o(159792);
      return;
      this.agnV = null;
    }
  }
  
  public void setDragEnabled(boolean paramBoolean)
  {
    this.agnv = paramBoolean;
  }
  
  public void setDragListener(DragSortListView.b paramb)
  {
    this.agns = paramb;
  }
  
  public void setDragScrollProfile(c paramc)
  {
    if (paramc != null) {
      this.agnL = paramc;
    }
  }
  
  public void setDragScrollStart(float paramFloat)
  {
    AppMethodBeat.i(159811);
    if (paramFloat > 0.5F)
    {
      this.agnD = 0.5F;
      if (paramFloat <= 0.5F) {
        break label58;
      }
    }
    label58:
    for (this.agnC = 0.5F;; this.agnC = paramFloat)
    {
      if (getHeight() != 0) {
        jJf();
      }
      AppMethodBeat.o(159811);
      return;
      this.agnD = paramFloat;
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
    this.agnt = paramh;
  }
  
  public void setFloatAlpha(float paramFloat)
  {
    this.agnl = paramFloat;
  }
  
  public void setFloatViewManager(i parami)
  {
    this.agnQ = parami;
  }
  
  public void setMaxScrollSpeed(float paramFloat)
  {
    this.agnK = paramFloat;
  }
  
  public void setRemoveListener(DragSortListView.l paraml)
  {
    this.agnu = paraml;
  }
  
  final class a
    extends BaseAdapter
  {
    ListAdapter fR;
    
    private a(ListAdapter paramListAdapter)
    {
      AppMethodBeat.i(159760);
      this.fR = paramListAdapter;
      this.fR.registerDataSetObserver(new DataSetObserver()
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
      boolean bool = this.fR.areAllItemsEnabled();
      AppMethodBeat.o(159764);
      return bool;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(159763);
      int i = this.fR.getCount();
      AppMethodBeat.o(159763);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(159762);
      Object localObject = this.fR.getItem(paramInt);
      AppMethodBeat.o(159762);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(159761);
      long l = this.fR.getItemId(paramInt);
      AppMethodBeat.o(159761);
      return l;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(159766);
      paramInt = this.fR.getItemViewType(paramInt);
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
        View localView2 = this.fR.getView(paramInt, localView1, DragSortListView.this);
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
      paramViewGroup = this.fR.getView(paramInt, null, DragSortListView.this);
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
      int i = this.fR.getViewTypeCount();
      AppMethodBeat.o(159767);
      return i;
    }
    
    public final boolean hasStableIds()
    {
      AppMethodBeat.i(159768);
      boolean bool = this.fR.hasStableIds();
      AppMethodBeat.o(159768);
      return bool;
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(159769);
      boolean bool = this.fR.isEmpty();
      AppMethodBeat.o(159769);
      return bool;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(159765);
      boolean bool = this.fR.isEnabled(paramInt);
      AppMethodBeat.o(159765);
      return bool;
    }
  }
  
  public static abstract interface c
  {
    public abstract float em(float paramFloat);
  }
  
  final class d
    implements Runnable
  {
    private long Mmi;
    private long Mmj;
    private int agok;
    private float agol;
    private long agom;
    int agon;
    private float agoo;
    private boolean mAbort;
    boolean mqz = false;
    
    d() {}
    
    public final void aFB(int paramInt)
    {
      AppMethodBeat.i(159771);
      if (!this.mqz)
      {
        this.mAbort = false;
        this.mqz = true;
        this.agom = SystemClock.uptimeMillis();
        this.Mmj = this.agom;
        this.agon = paramInt;
        DragSortListView.this.post(this);
      }
      AppMethodBeat.o(159771);
    }
    
    public final void jJl()
    {
      AppMethodBeat.i(159772);
      DragSortListView.this.removeCallbacks(this);
      this.mqz = false;
      AppMethodBeat.o(159772);
    }
    
    public final void run()
    {
      AppMethodBeat.i(159773);
      if (this.mAbort)
      {
        this.mqz = false;
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
      if (this.agon == 0)
      {
        localView = DragSortListView.this.getChildAt(0);
        if (localView == null)
        {
          this.mqz = false;
          AppMethodBeat.o(159773);
          return;
        }
        if ((j == 0) && (localView.getTop() == k))
        {
          this.mqz = false;
          AppMethodBeat.o(159773);
          return;
        }
        this.agoo = DragSortListView.u(DragSortListView.this).em((DragSortListView.s(DragSortListView.this) - i2) / DragSortListView.t(DragSortListView.this));
        this.Mmi = SystemClock.uptimeMillis();
        this.agol = ((float)(this.Mmi - this.Mmj));
        this.agok = Math.round(this.agoo * this.agol);
        if (this.agok < 0) {
          break label496;
        }
        this.agok = Math.min(n, this.agok);
        i = j;
      }
      for (;;)
      {
        localView = DragSortListView.this.getChildAt(i - j);
        m = localView.getTop() + this.agok;
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
        this.Mmj = this.Mmi;
        DragSortListView.this.post(this);
        AppMethodBeat.o(159773);
        return;
        localView = DragSortListView.this.getChildAt(i - j);
        if (localView == null)
        {
          this.mqz = false;
          AppMethodBeat.o(159773);
          return;
        }
        if ((i == m - 1) && (localView.getBottom() <= n + k))
        {
          this.mqz = false;
          AppMethodBeat.o(159773);
          return;
        }
        this.agoo = (-DragSortListView.u(DragSortListView.this).em((i1 - DragSortListView.v(DragSortListView.this)) / DragSortListView.w(DragSortListView.this)));
        break;
        label496:
        this.agok = Math.max(-n, this.agok);
      }
    }
  }
  
  final class f
  {
    int agop;
    int agoq;
    boolean agor;
    StringBuilder mBuilder;
    File mFile;
    
    f()
    {
      AppMethodBeat.i(159774);
      this.mBuilder = new StringBuilder();
      this.agop = 0;
      this.agoq = 0;
      this.agor = false;
      this.mFile = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
      if (!this.mFile.exists()) {
        try
        {
          if (!this.mFile.createNewFile()) {
            bc.e("mobeta", "creat file fail!! file already exist", new Object[0]);
          }
          bc.d("mobeta", "file created", new Object[0]);
          AppMethodBeat.o(159774);
          return;
        }
        catch (IOException this$1)
        {
          bc.w("mobeta", "Could not create dslv_state.txt", new Object[0]);
          bc.d("mobeta", DragSortListView.this.getMessage(), new Object[0]);
        }
      }
      AppMethodBeat.o(159774);
    }
    
    /* Error */
    public final void flush()
    {
      // Byte code:
      //   0: ldc 97
      //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 45	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:agor	Z
      //   9: ifne +9 -> 18
      //   12: ldc 97
      //   14: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   17: return
      //   18: aload_0
      //   19: getfield 43	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:agoq	I
      //   22: ifne +190 -> 212
      //   25: iconst_0
      //   26: istore_1
      //   27: new 99	java/io/BufferedWriter
      //   30: dup
      //   31: new 101	java/io/OutputStreamWriter
      //   34: dup
      //   35: new 103	java/io/FileOutputStream
      //   38: dup
      //   39: aload_0
      //   40: getfield 60	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:mFile	Ljava/io/File;
      //   43: iload_1
      //   44: invokespecial 106	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
      //   47: ldc 108
      //   49: invokespecial 111	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
      //   52: invokespecial 114	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
      //   55: astore_2
      //   56: aload_2
      //   57: aload_0
      //   58: getfield 39	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:mBuilder	Ljava/lang/StringBuilder;
      //   61: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   64: invokevirtual 123	java/io/Writer:write	(Ljava/lang/String;)V
      //   67: aload_0
      //   68: getfield 39	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:mBuilder	Ljava/lang/StringBuilder;
      //   71: iconst_0
      //   72: aload_0
      //   73: getfield 39	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:mBuilder	Ljava/lang/StringBuilder;
      //   76: invokevirtual 127	java/lang/StringBuilder:length	()I
      //   79: invokevirtual 131	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
      //   82: pop
      //   83: aload_2
      //   84: invokevirtual 133	java/io/Writer:flush	()V
      //   87: aload_0
      //   88: aload_0
      //   89: getfield 43	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:agoq	I
      //   92: iconst_1
      //   93: iadd
      //   94: putfield 43	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:agoq	I
      //   97: aload_2
      //   98: invokevirtual 136	java/io/Writer:close	()V
      //   101: ldc 97
      //   103: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   106: return
      //   107: astore_2
      //   108: ldc 138
      //   110: aload_2
      //   111: ldc 140
      //   113: iconst_0
      //   114: anewarray 4	java/lang/Object
      //   117: invokestatic 144	com/tencent/mm/ui/bc:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   120: ldc 97
      //   122: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   125: return
      //   126: astore_2
      //   127: aconst_null
      //   128: astore_2
      //   129: aload_2
      //   130: ifnull +7 -> 137
      //   133: aload_2
      //   134: invokevirtual 136	java/io/Writer:close	()V
      //   137: ldc 97
      //   139: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   142: return
      //   143: astore_2
      //   144: ldc 138
      //   146: aload_2
      //   147: ldc 140
      //   149: iconst_0
      //   150: anewarray 4	java/lang/Object
      //   153: invokestatic 144	com/tencent/mm/ui/bc:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   156: ldc 97
      //   158: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   161: return
      //   162: astore_2
      //   163: aconst_null
      //   164: astore_3
      //   165: aload_3
      //   166: ifnull +7 -> 173
      //   169: aload_3
      //   170: invokevirtual 136	java/io/Writer:close	()V
      //   173: ldc 97
      //   175: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   178: aload_2
      //   179: athrow
      //   180: astore_3
      //   181: ldc 138
      //   183: aload_3
      //   184: ldc 140
      //   186: iconst_0
      //   187: anewarray 4	java/lang/Object
      //   190: invokestatic 144	com/tencent/mm/ui/bc:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   193: goto -20 -> 173
      //   196: astore_3
      //   197: aload_2
      //   198: astore 4
      //   200: aload_3
      //   201: astore_2
      //   202: aload 4
      //   204: astore_3
      //   205: goto -40 -> 165
      //   208: astore_3
      //   209: goto -80 -> 129
      //   212: iconst_1
      //   213: istore_1
      //   214: goto -187 -> 27
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	217	0	this	f
      //   26	188	1	bool	boolean
      //   55	43	2	localBufferedWriter	java.io.BufferedWriter
      //   107	4	2	localIOException1	IOException
      //   126	1	2	localIOException2	IOException
      //   128	6	2	localObject1	Object
      //   143	4	2	localIOException3	IOException
      //   162	36	2	localObject2	Object
      //   201	1	2	localObject3	Object
      //   164	6	3	localObject4	Object
      //   180	4	3	localIOException4	IOException
      //   196	5	3	localObject5	Object
      //   204	1	3	localObject6	Object
      //   208	1	3	localIOException5	IOException
      //   198	5	4	localObject7	Object
      // Exception table:
      //   from	to	target	type
      //   97	101	107	java/io/IOException
      //   18	25	126	java/io/IOException
      //   27	56	126	java/io/IOException
      //   133	137	143	java/io/IOException
      //   18	25	162	finally
      //   27	56	162	finally
      //   169	173	180	java/io/IOException
      //   56	97	196	finally
      //   56	97	208	java/io/IOException
    }
    
    public final void jJm()
    {
      AppMethodBeat.i(159776);
      if (this.agor)
      {
        this.mBuilder.append("</DSLVStates>\n");
        flush();
        this.agor = false;
      }
      AppMethodBeat.o(159776);
    }
  }
  
  final class g
    extends DragSortListView.m
  {
    private int agos;
    private int agot;
    private float agou;
    private float agov;
    
    private g(int paramInt)
    {
      super(0.5F, paramInt, (byte)0);
    }
    
    private int jJn()
    {
      AppMethodBeat.i(159778);
      int i = DragSortListView.this.getFirstVisiblePosition();
      int j = (DragSortListView.i(DragSortListView.this) + DragSortListView.this.getDividerHeight()) / 2;
      View localView = DragSortListView.this.getChildAt(this.agos - i);
      i = -1;
      if (localView != null) {
        if (this.agos == this.agot) {
          i = localView.getTop();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(159778);
        return i;
        if (this.agos < this.agot)
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
    
    public final void en(float paramFloat)
    {
      AppMethodBeat.i(159779);
      int i = jJn();
      int j = DragSortListView.this.getPaddingLeft();
      float f1 = DragSortListView.d(DragSortListView.this).y - i;
      float f2 = DragSortListView.d(DragSortListView.this).x - j;
      paramFloat = 1.0F - paramFloat;
      if ((paramFloat < Math.abs(f1 / this.agou)) || (paramFloat < Math.abs(f2 / this.agov)))
      {
        DragSortListView.d(DragSortListView.this).y = (i + (int)(this.agou * paramFloat));
        DragSortListView.d(DragSortListView.this).x = (DragSortListView.this.getPaddingLeft() + (int)(this.agov * paramFloat));
        DragSortListView.f(DragSortListView.this);
      }
      AppMethodBeat.o(159779);
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(159777);
      this.agos = DragSortListView.g(DragSortListView.this);
      this.agot = DragSortListView.h(DragSortListView.this);
      DragSortListView.a(DragSortListView.this, 2);
      this.agou = (DragSortListView.d(DragSortListView.this).y - jJn());
      this.agov = (DragSortListView.d(DragSortListView.this).x - DragSortListView.this.getPaddingLeft());
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
    public abstract View aFC(int paramInt);
    
    public abstract void mt(View paramView);
    
    public abstract void o(Point paramPoint);
  }
  
  final class j
  {
    private SparseIntArray agow;
    private ArrayList<Integer> agox;
    private int mMaxSize;
    
    private j()
    {
      AppMethodBeat.i(159781);
      this.agow = new SparseIntArray(3);
      this.agox = new ArrayList(3);
      this.mMaxSize = 3;
      AppMethodBeat.o(159781);
    }
    
    public final void clear()
    {
      AppMethodBeat.i(159784);
      this.agow.clear();
      this.agox.clear();
      AppMethodBeat.o(159784);
    }
    
    public final int get(int paramInt)
    {
      AppMethodBeat.i(159783);
      paramInt = this.agow.get(paramInt, -1);
      AppMethodBeat.o(159783);
      return paramInt;
    }
    
    public final void pb(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(159782);
      int i = this.agow.get(paramInt1, -1);
      if (i != paramInt2)
      {
        if (i != -1) {
          break label87;
        }
        if (this.agow.size() == this.mMaxSize) {
          this.agow.delete(((Integer)this.agox.remove(0)).intValue());
        }
      }
      for (;;)
      {
        this.agow.put(paramInt1, paramInt2);
        this.agox.add(Integer.valueOf(paramInt1));
        AppMethodBeat.o(159782);
        return;
        label87:
        this.agox.remove(Integer.valueOf(paramInt1));
      }
    }
  }
  
  final class k
    extends DragSortListView.m
  {
    private float agoA;
    private int agoB = -1;
    private int agoC = -1;
    private int agoD;
    private float agoy;
    private float agoz;
    private int lMz;
    
    private k(int paramInt)
    {
      super(0.5F, paramInt, (byte)0);
    }
    
    public final void en(float paramFloat)
    {
      AppMethodBeat.i(159786);
      paramFloat = 1.0F - paramFloat;
      int j = DragSortListView.this.getFirstVisiblePosition();
      View localView = DragSortListView.this.getChildAt(this.lMz - j);
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
        if (DragSortListView.o(DragSortListView.this) > 0.0F) {}
        for (i = 1;; i = -1)
        {
          DragSortListView.b((DragSortListView)localObject, i * f1 * k);
          this.agoy += f2 * f1;
          DragSortListView.d(DragSortListView.this).x = ((int)this.agoy);
          if ((this.agoy >= k) || (this.agoy <= -k)) {
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
        if (this.agoB == -1)
        {
          this.agoB = DragSortListView.b(DragSortListView.this, this.lMz, localView);
          this.agoz = (localView.getHeight() - this.agoB);
        }
        i = Math.max((int)(this.agoz * paramFloat), 1);
        localObject = localView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = (i + this.agoB);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.agoD != this.lMz)
      {
        localView = DragSortListView.this.getChildAt(this.agoD - j);
        if (localView != null)
        {
          if (this.agoC == -1)
          {
            this.agoC = DragSortListView.b(DragSortListView.this, this.agoD, localView);
            this.agoA = (localView.getHeight() - this.agoC);
          }
          i = Math.max((int)(this.agoA * paramFloat), 1);
          localObject = localView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = (i + this.agoC);
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(159786);
    }
    
    public final void onStart()
    {
      int i = -1;
      AppMethodBeat.i(159785);
      this.agoB = -1;
      this.agoC = -1;
      this.lMz = DragSortListView.l(DragSortListView.this);
      this.agoD = DragSortListView.m(DragSortListView.this);
      DragSortListView.a(DragSortListView.this, 1);
      this.agoy = DragSortListView.d(DragSortListView.this).x;
      if (DragSortListView.n(DragSortListView.this))
      {
        float f = DragSortListView.this.getWidth() * 2.0F;
        if (DragSortListView.o(DragSortListView.this) == 0.0F)
        {
          DragSortListView localDragSortListView = DragSortListView.this;
          if (this.agoy < 0.0F) {}
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
  
  class m
    implements Runnable
  {
    private float agoE;
    private float agoF;
    private float agoG;
    private float agoH;
    private float agoI;
    private float mAlpha;
    private boolean mCanceled;
    protected long mStartTime;
    
    private m(float paramFloat, int paramInt)
    {
      AppMethodBeat.i(252708);
      this.mAlpha = paramFloat;
      this.agoE = paramInt;
      paramFloat = 1.0F / (this.mAlpha * 2.0F * (1.0F - this.mAlpha));
      this.agoI = paramFloat;
      this.agoF = paramFloat;
      this.agoG = (this.mAlpha / ((this.mAlpha - 1.0F) * 2.0F));
      this.agoH = (1.0F / (1.0F - this.mAlpha));
      AppMethodBeat.o(252708);
    }
    
    public final void cancel()
    {
      this.mCanceled = true;
    }
    
    public void en(float paramFloat) {}
    
    public void onStart() {}
    
    public void onStop() {}
    
    public void run()
    {
      AppMethodBeat.i(159790);
      if (this.mCanceled)
      {
        AppMethodBeat.o(159790);
        return;
      }
      float f1 = (float)(SystemClock.uptimeMillis() - this.mStartTime) / this.agoE;
      if (f1 >= 1.0F)
      {
        en(1.0F);
        onStop();
        AppMethodBeat.o(159790);
        return;
      }
      if (f1 < this.mAlpha) {
        f1 *= this.agoF * f1;
      }
      for (;;)
      {
        en(f1);
        DragSortListView.this.post(this);
        AppMethodBeat.o(159790);
        return;
        if (f1 < 1.0F - this.mAlpha)
        {
          float f2 = this.agoG;
          f1 = f1 * this.agoH + f2;
        }
        else
        {
          f1 = 1.0F - (f1 - 1.0F) * (this.agoI * (f1 - 1.0F));
        }
      }
    }
    
    public final void start()
    {
      AppMethodBeat.i(159789);
      this.mStartTime = SystemClock.uptimeMillis();
      this.mCanceled = false;
      onStart();
      DragSortListView.this.post(this);
      AppMethodBeat.o(159789);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView
 * JD-Core Version:    0.7.0.1
 */