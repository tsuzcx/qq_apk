package com.tencent.mm.ui.widget.sortlist;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
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
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.ci.a.k;
import java.util.ArrayList;

public class DragSortListView
  extends ListView
{
  private int MI = 0;
  private int gMN;
  private int gMO;
  private int gUJ;
  private int gUK;
  private View hqL;
  private DataSetObserver mObserver;
  private int mOffsetX;
  private int mOffsetY;
  private Point wqB = new Point();
  private Point wqC = new Point();
  private int wqD;
  private boolean wqE = false;
  private float wqF = 1.0F;
  private float wqG = 1.0F;
  private int wqH;
  private int wqI;
  private int wqJ;
  private boolean wqK = false;
  private int wqL;
  private int wqM;
  private int wqN;
  private DragSortListView.b wqO;
  private DragSortListView.h wqP;
  private DragSortListView.l wqQ;
  boolean wqR = true;
  private int wqS = 1;
  private int wqT;
  private int wqU;
  private int wqV = 0;
  private View[] wqW = new View[1];
  private d wqX;
  private float wqY = 0.3333333F;
  private float wqZ = 0.3333333F;
  private float wrA = 0.0F;
  boolean wrB = false;
  private boolean wrC = false;
  private int wra;
  private int wrb;
  private float wrc;
  private float wrd;
  private float wre;
  private float wrf;
  private float wrg = 0.5F;
  private c wrh = new DragSortListView.1(this);
  private int wri;
  private int wrj = 0;
  private boolean wrk = false;
  boolean wrl = false;
  DragSortListView.i wrm = null;
  private MotionEvent wrn;
  private int wro = 0;
  private float wrp = 0.25F;
  private float wrq = 0.0F;
  private DragSortListView.a wrr;
  private boolean wrs = false;
  private DragSortListView.f wrt;
  private boolean wru = false;
  private boolean wrv = false;
  private DragSortListView.j wrw = new DragSortListView.j(this, (byte)0);
  private DragSortListView.k wrx;
  private DragSortListView.g wry;
  private boolean wrz;
  
  public DragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int j = 150;
    int i = 150;
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, a.k.DragSortListView, 0, 0);
      this.wqS = Math.max(1, paramContext.getDimensionPixelSize(a.k.DragSortListView_collapsed_height, 1));
      this.wrs = paramContext.getBoolean(a.k.DragSortListView_track_drag_sort, false);
      if (this.wrs) {
        this.wrt = new DragSortListView.f(this);
      }
      this.wqF = paramContext.getFloat(a.k.DragSortListView_float_alpha, this.wqF);
      this.wqG = this.wqF;
      this.wqR = paramContext.getBoolean(a.k.DragSortListView_drag_enabled, this.wqR);
      this.wrp = Math.max(0.0F, Math.min(1.0F, 1.0F - paramContext.getFloat(a.k.DragSortListView_slide_shuffle_speed, 0.75F)));
      if (this.wrp <= 0.0F) {
        break label617;
      }
    }
    label617:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.wqK = bool1;
      setDragScrollStart(paramContext.getFloat(a.k.DragSortListView_drag_scroll_start, this.wqY));
      this.wrg = paramContext.getFloat(a.k.DragSortListView_max_drag_scroll_speed, this.wrg);
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
        paramAttributeSet.wqj = bool1;
        paramAttributeSet.wqi = bool2;
        paramAttributeSet.wsi = i3;
        this.wrm = paramAttributeSet;
        setOnTouchListener(paramAttributeSet);
      }
      paramContext.recycle();
      this.wqX = new d();
      if (j > 0) {
        this.wrx = new DragSortListView.k(this, j, (byte)0);
      }
      if (i > 0) {
        this.wry = new DragSortListView.g(this, i, (byte)0);
      }
      this.wrn = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
      this.mObserver = new DragSortListView.2(this);
      return;
    }
  }
  
  private int IE(int paramInt)
  {
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null) {
      return localView.getHeight();
    }
    return fO(paramInt, IG(paramInt));
  }
  
  private void IF(int paramInt)
  {
    this.MI = 1;
    if (this.wqQ != null) {
      this.wqQ.remove(paramInt);
    }
    cKF();
    cKz();
    cKx();
    if (this.wrl)
    {
      this.MI = 3;
      return;
    }
    this.MI = 0;
  }
  
  private int IG(int paramInt)
  {
    if (paramInt == this.wqL) {
      i = 0;
    }
    do
    {
      return i;
      localObject = getChildAt(paramInt - getFirstVisiblePosition());
      if (localObject != null) {
        return b(paramInt, (View)localObject, false);
      }
      j = this.wrw.wrU.get(paramInt, -1);
      i = j;
    } while (j != -1);
    Object localObject = getAdapter();
    int i = ((ListAdapter)localObject).getItemViewType(paramInt);
    int j = ((ListAdapter)localObject).getViewTypeCount();
    if (j != this.wqW.length) {
      this.wqW = new View[j];
    }
    if (i >= 0) {
      if (this.wqW[i] == null)
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
        this.wqW[i] = localObject;
        i = b(paramInt, (View)localObject, true);
        localObject = this.wrw;
        j = ((DragSortListView.j)localObject).wrU.get(paramInt, -1);
        if (j != i)
        {
          if (j != -1) {
            break label266;
          }
          if (((DragSortListView.j)localObject).wrU.size() == ((DragSortListView.j)localObject).ujn) {
            ((DragSortListView.j)localObject).wrU.delete(((Integer)((DragSortListView.j)localObject).wrV.remove(0)).intValue());
          }
        }
      }
    }
    for (;;)
    {
      ((DragSortListView.j)localObject).wrU.put(paramInt, i);
      ((DragSortListView.j)localObject).wrV.add(Integer.valueOf(paramInt));
      return i;
      localObject = ((ListAdapter)localObject).getView(paramInt, this.wqW[i], this);
      break;
      localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
      break;
      label266:
      ((DragSortListView.j)localObject).wrV.remove(Integer.valueOf(paramInt));
    }
  }
  
  private void O(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      this.gUJ = this.gMN;
      this.gUK = this.gMO;
    }
    this.gMN = ((int)paramMotionEvent.getX());
    this.gMO = ((int)paramMotionEvent.getY());
    if (i == 0)
    {
      this.gUJ = this.gMN;
      this.gUK = this.gMO;
    }
    this.mOffsetX = ((int)paramMotionEvent.getRawX() - this.gMN);
    this.mOffsetY = ((int)paramMotionEvent.getRawY() - this.gMO);
  }
  
  private void a(int paramInt, Canvas paramCanvas)
  {
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
        if (paramInt <= this.wqL) {
          break label128;
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
      return;
      label128:
      paramInt = localViewGroup.getBottom() - i;
      i = paramInt - m;
    }
  }
  
  private void a(int paramInt, View paramView, boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    int i;
    if ((paramInt != this.wqL) && (paramInt != this.wqI) && (paramInt != this.wqJ))
    {
      i = -2;
      if (i != localLayoutParams.height)
      {
        localLayoutParams.height = i;
        paramView.setLayoutParams(localLayoutParams);
      }
      if ((paramInt == this.wqI) || (paramInt == this.wqJ))
      {
        if (paramInt >= this.wqL) {
          break label156;
        }
        ((b)paramView).setGravity(80);
      }
    }
    for (;;)
    {
      int k = paramView.getVisibility();
      int j = 0;
      i = j;
      if (paramInt == this.wqL)
      {
        i = j;
        if (this.hqL != null) {
          i = 4;
        }
      }
      if (i != k) {
        paramView.setVisibility(i);
      }
      return;
      i = fO(paramInt, b(paramInt, paramView, paramBoolean));
      break;
      label156:
      if (paramInt > this.wqL) {
        ((b)paramView).setGravity(48);
      }
    }
  }
  
  private int b(int paramInt, View paramView, boolean paramBoolean)
  {
    int i = 0;
    if (paramInt == this.wqL) {
      paramInt = i;
    }
    View localView;
    label65:
    do
    {
      return paramInt;
      localView = paramView;
      if (paramInt >= getHeaderViewsCount()) {
        if (paramInt < getCount() - getFooterViewsCount()) {
          break label65;
        }
      }
      for (localView = paramView;; localView = ((ViewGroup)paramView).getChildAt(0))
      {
        paramView = localView.getLayoutParams();
        if ((paramView == null) || (paramView.height <= 0)) {
          break;
        }
        return paramView.height;
      }
      paramInt = localView.getHeight();
    } while ((paramInt != 0) && (!paramBoolean));
    em(localView);
    return localView.getMeasuredHeight();
  }
  
  private boolean b(boolean paramBoolean, float paramFloat)
  {
    boolean bool = false;
    if (this.hqL != null)
    {
      this.wqX.cKG();
      if (!paramBoolean) {
        break label82;
      }
      l(this.wqL - getHeaderViewsCount(), paramFloat);
    }
    for (;;)
    {
      if (this.wrs)
      {
        DragSortListView.f localf = this.wrt;
        if (localf.wrP)
        {
          localf.mBuilder.append("</DSLVStates>\n");
          localf.flush();
          localf.wrP = false;
        }
      }
      bool = true;
      return bool;
      label82:
      if (this.wry != null) {
        this.wry.start();
      } else {
        cKy();
      }
    }
  }
  
  private void c(int paramInt, View paramView, boolean paramBoolean)
  {
    this.wru = true;
    if (this.wrm != null)
    {
      this.wqC.set(this.gMN, this.gMO);
      this.wrm.i(this.wqB);
    }
    int i = this.wqB.x;
    int m = this.wqB.y;
    int j = getPaddingLeft();
    int k;
    int n;
    int i1;
    label299:
    int i3;
    int i4;
    int i5;
    if (((this.wrj & 0x1) == 0) && (i > j))
    {
      this.wqB.x = j;
      j = getHeaderViewsCount();
      k = getFooterViewsCount();
      n = getFirstVisiblePosition();
      i1 = getLastVisiblePosition();
      i = getPaddingTop();
      if (n < j) {
        i = getChildAt(j - n - 1).getBottom();
      }
      j = i;
      if ((this.wrj & 0x8) == 0)
      {
        j = i;
        if (n <= this.wqL) {
          j = Math.max(getChildAt(this.wqL - n).getTop(), i);
        }
      }
      i = getHeight() - getPaddingBottom();
      if (i1 >= getCount() - k - 1) {
        i = getChildAt(getCount() - k - 1 - n).getBottom();
      }
      k = i;
      if ((this.wrj & 0x4) == 0)
      {
        k = i;
        if (i1 >= this.wqL) {
          k = Math.min(getChildAt(this.wqL - n).getBottom(), i);
        }
      }
      if (m >= j) {
        break label877;
      }
      this.wqB.y = j;
      this.wqD = (this.wqB.y + this.wqU);
      i3 = this.wqI;
      i4 = this.wqJ;
      i = getFirstVisiblePosition();
      j = this.wqI;
      View localView2 = getChildAt(j - i);
      View localView1 = localView2;
      if (localView2 == null)
      {
        j = i + getChildCount() / 2;
        localView1 = getChildAt(j - i);
      }
      i1 = localView1.getTop();
      m = localView1.getHeight();
      i = fN(j, i1);
      i5 = getDividerHeight();
      if (this.wqD >= i) {
        break label950;
      }
      k = i;
      n = i;
      i = k;
      k = j;
      label436:
      j = k;
      m = i;
      if (k < 0) {
        break label1320;
      }
      k -= 1;
      j = IE(k);
      if (k != 0) {
        break label906;
      }
      j = i1 - i5 - j;
    }
    for (;;)
    {
      n = getHeaderViewsCount();
      i5 = getFooterViewsCount();
      i1 = this.wqI;
      int i2 = this.wqJ;
      float f1 = this.wrq;
      int i6;
      label542:
      float f2;
      if (this.wqK)
      {
        i6 = Math.abs(j - i);
        if (this.wqD < j)
        {
          m = i;
          i = j;
          j = (int)(0.5F * this.wrp * i6);
          f2 = j;
          m += j;
          if (this.wqD >= m) {
            break label1086;
          }
          this.wqI = (k - 1);
          this.wqJ = k;
          this.wrq = (0.5F * (m - this.wqD) / f2);
          label609:
          if (this.wqI >= n) {
            break label1150;
          }
          this.wqI = n;
          this.wqJ = n;
          k = n;
          label634:
          if ((this.wqI == i1) && (this.wqJ == i2) && (Math.abs(this.wrq - f1) <= 0.0F)) {
            break label1303;
          }
        }
      }
      label906:
      label1303:
      for (i = 1;; i = 0)
      {
        if (k != this.wqH) {
          this.wqH = k;
        }
        for (j = 1;; j = i)
        {
          if (j != 0)
          {
            cKC();
            k = IG(paramInt);
            n = paramView.getHeight();
            i1 = fO(paramInt, k);
            if (paramInt == this.wqL) {
              break label1285;
            }
            i = n - k;
          }
          for (k = i1 - k;; k = i1)
          {
            i2 = this.wqT;
            m = i2;
            if (this.wqL != this.wqI)
            {
              m = i2;
              if (this.wqL != this.wqJ) {
                m = i2 - this.wqS;
              }
            }
            if (paramInt <= i3)
            {
              if (paramInt <= this.wqI) {
                break label1279;
              }
              i = m - k + 0;
            }
            for (;;)
            {
              setSelectionFromTop(paramInt, i + paramView.getTop() - getPaddingTop());
              layoutChildren();
              if ((j != 0) || (paramBoolean)) {
                invalidate();
              }
              this.wru = false;
              return;
              if (((this.wrj & 0x2) != 0) || (i >= j)) {
                break;
              }
              this.wqB.x = j;
              break;
              label877:
              if (this.wqT + m <= k) {
                break label299;
              }
              this.wqB.y = (k - this.wqT);
              break label299;
              i1 -= j + i5;
              n = fN(k, i1);
              j = k;
              m = n;
              if (this.wqD >= n) {
                break label1309;
              }
              i = n;
              break label436;
              label950:
              i6 = getCount();
              k = i;
              i2 = i1;
              i1 = m;
              n = i;
              i = k;
              k = j;
              for (;;)
              {
                j = k;
                m = i;
                if (k >= i6) {
                  break label1320;
                }
                if (k == i6 - 1)
                {
                  j = i2 + i5 + i1;
                  break;
                }
                i2 += i5 + i1;
                i1 = IE(k + 1);
                n = fN(k + 1, i2);
                j = k;
                m = n;
                if (this.wqD < n) {
                  break label1309;
                }
                k += 1;
                i = n;
              }
              m = j;
              break label542;
              label1086:
              if (this.wqD >= i - j)
              {
                this.wqI = k;
                this.wqJ = (k + 1);
                this.wrq = (0.5F * ((i - this.wqD) / f2 + 1.0F));
                break label609;
              }
              this.wqI = k;
              this.wqJ = k;
              break label609;
              label1150:
              if (this.wqJ < getCount() - i5) {
                break label634;
              }
              k = getCount() - i5 - 1;
              this.wqI = k;
              this.wqJ = k;
              break label634;
              if (paramInt == i4)
              {
                if (paramInt <= this.wqI) {
                  i = i - m + 0;
                } else if (paramInt == this.wqJ) {
                  i = n - i1 + 0;
                } else {
                  i += 0;
                }
              }
              else if (paramInt <= this.wqI) {
                i = 0 - m;
              } else if (paramInt == this.wqJ) {
                i = 0 - k;
              } else {
                label1279:
                i = 0;
              }
            }
            i = n;
          }
        }
      }
      label1285:
      label1309:
      k = j;
      j = m;
      continue;
      label1320:
      i = m;
      k = j;
      j = n;
    }
  }
  
  private void cKA()
  {
    this.wro = 0;
    this.wrl = false;
    if (this.MI == 3) {
      this.MI = 0;
    }
    this.wqG = this.wqF;
    this.wrB = false;
    DragSortListView.j localj = this.wrw;
    localj.wrU.clear();
    localj.wrV.clear();
  }
  
  private void cKB()
  {
    int i = getPaddingTop();
    int j = getHeight() - i - getPaddingBottom();
    float f1 = j;
    this.wrd = (i + this.wqY * f1);
    float f2 = i;
    this.wrc = (f1 * (1.0F - this.wqZ) + f2);
    this.wra = ((int)this.wrd);
    this.wrb = ((int)this.wrc);
    this.wre = (this.wrd - i);
    this.wrf = (i + j - this.wrc);
  }
  
  private void cKC()
  {
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
  }
  
  private void cKD()
  {
    if (this.hqL != null)
    {
      em(this.hqL);
      this.wqT = this.hqL.getMeasuredHeight();
      this.wqU = (this.wqT / 2);
    }
  }
  
  private void cKE()
  {
    int i = getFirstVisiblePosition();
    int j = getChildCount() / 2;
    View localView = getChildAt(getChildCount() / 2);
    if (localView == null) {
      return;
    }
    c(i + j, localView, true);
  }
  
  private void cKF()
  {
    if (this.hqL != null)
    {
      this.hqL.setVisibility(8);
      if (this.wrm != null) {
        this.wrm.en(this.hqL);
      }
      this.hqL = null;
      invalidate();
    }
  }
  
  private void cKx()
  {
    this.wqL = -1;
    this.wqI = -1;
    this.wqJ = -1;
    this.wqH = -1;
  }
  
  private void cKy()
  {
    this.MI = 2;
    if ((this.wqP != null) && (this.wqH >= 0) && (this.wqH < getCount()))
    {
      int i = getHeaderViewsCount();
      this.wqP.cg(this.wqL - i, this.wqH - i);
    }
    cKF();
    cKz();
    cKx();
    cKC();
    if (this.wrl)
    {
      this.MI = 3;
      return;
    }
    this.MI = 0;
  }
  
  private void cKz()
  {
    int i = 0;
    int j = getFirstVisiblePosition();
    if (this.wqL < j)
    {
      View localView = getChildAt(0);
      if (localView != null) {
        i = localView.getTop();
      }
      setSelectionFromTop(j - 1, i - getPaddingTop());
    }
  }
  
  private void em(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null)
    {
      localObject = new AbsListView.LayoutParams(-1, -2);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int j = ViewGroup.getChildMeasureSpec(this.wqV, getListPaddingLeft() + getListPaddingRight(), ((ViewGroup.LayoutParams)localObject).width);
    if (((ViewGroup.LayoutParams)localObject).height > 0) {}
    for (int i = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(j, i);
      return;
    }
  }
  
  private int fN(int paramInt1, int paramInt2)
  {
    int i = getHeaderViewsCount();
    int j = getFooterViewsCount();
    if ((paramInt1 <= i) || (paramInt1 >= getCount() - j)) {
      return paramInt2;
    }
    j = getDividerHeight();
    int m = this.wqT - this.wqS;
    int k = IG(paramInt1);
    int n = IE(paramInt1);
    if (this.wqJ <= this.wqL) {
      if ((paramInt1 == this.wqJ) && (this.wqI != this.wqJ)) {
        if (paramInt1 == this.wqL) {
          i = paramInt2 + n - this.wqT;
        }
      }
    }
    while (paramInt1 <= this.wqL)
    {
      return (this.wqT - j - IG(paramInt1 - 1)) / 2 + i;
      i = n - k + paramInt2 - m;
      continue;
      i = paramInt2;
      if (paramInt1 > this.wqJ)
      {
        i = paramInt2;
        if (paramInt1 <= this.wqL)
        {
          i = paramInt2 - m;
          continue;
          if ((paramInt1 > this.wqL) && (paramInt1 <= this.wqI))
          {
            i = paramInt2 + m;
          }
          else
          {
            i = paramInt2;
            if (paramInt1 == this.wqJ)
            {
              i = paramInt2;
              if (this.wqI != this.wqJ) {
                i = paramInt2 + (n - k);
              }
            }
          }
        }
      }
    }
    return (k - j - this.wqT) / 2 + i;
  }
  
  private int fO(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    int k;
    if ((this.wqK) && (this.wqI != this.wqJ))
    {
      i = 1;
      j = this.wqT - this.wqS;
      k = (int)(this.wrq * j);
      if (paramInt1 != this.wqL) {
        break label109;
      }
      if (this.wqL != this.wqI) {
        break label85;
      }
      if (i == 0) {
        break label80;
      }
      i = k + this.wqS;
    }
    label80:
    label85:
    label109:
    do
    {
      return i;
      i = 0;
      break;
      return this.wqT;
      if (this.wqL == this.wqJ) {
        return this.wqT - k;
      }
      return this.wqS;
      if (paramInt1 == this.wqI)
      {
        if (i != 0) {
          return paramInt2 + k;
        }
        return paramInt2 + j;
      }
      i = paramInt2;
    } while (paramInt1 != this.wqJ);
    return paramInt2 + j - k;
  }
  
  private void l(int paramInt, float paramFloat)
  {
    if ((this.MI == 0) || (this.MI == 4))
    {
      if (this.MI == 0)
      {
        this.wqL = (getHeaderViewsCount() + paramInt);
        this.wqI = this.wqL;
        this.wqJ = this.wqL;
        this.wqH = this.wqL;
        View localView = getChildAt(this.wqL - getFirstVisiblePosition());
        if (localView != null) {
          localView.setVisibility(4);
        }
      }
      this.MI = 1;
      this.wrA = paramFloat;
      if (this.wrl) {
        switch (this.wro)
        {
        }
      }
    }
    while (this.wrx != null)
    {
      this.wrx.start();
      return;
      super.onTouchEvent(this.wrn);
      continue;
      super.onInterceptTouchEvent(this.wrn);
    }
    IF(paramInt);
  }
  
  public final boolean a(int paramInt1, View paramView, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.MI != 0) || (!this.wrl) || (this.hqL != null) || (paramView == null) || (!this.wqR)) {
      return false;
    }
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    paramInt1 = getHeaderViewsCount() + paramInt1;
    this.wqI = paramInt1;
    this.wqJ = paramInt1;
    this.wqL = paramInt1;
    this.wqH = paramInt1;
    this.MI = 4;
    this.wrj = 0;
    this.wrj |= paramInt2;
    this.hqL = paramView;
    cKD();
    this.wqM = paramInt3;
    this.wqN = paramInt4;
    this.wri = this.gMO;
    this.wqB.x = (this.gMN - this.wqM);
    this.wqB.y = (this.gMO - this.wqN);
    paramView = getChildAt(this.wqL - getFirstVisiblePosition());
    if (paramView != null) {
      paramView.setVisibility(4);
    }
    if (this.wrs)
    {
      paramView = this.wrt;
      paramView.mBuilder.append("<DSLVStates>\n");
      paramView.wrO = 0;
      paramView.wrP = true;
    }
    switch (this.wro)
    {
    }
    for (;;)
    {
      requestLayout();
      return true;
      super.onTouchEvent(this.wrn);
      continue;
      super.onInterceptTouchEvent(this.wrn);
    }
  }
  
  public final boolean aO(float paramFloat)
  {
    this.wrz = true;
    return b(true, paramFloat);
  }
  
  public final void cKw()
  {
    if (this.MI == 4)
    {
      this.wqX.cKG();
      cKF();
      cKx();
      cKC();
      if (this.wrl) {
        this.MI = 3;
      }
    }
    else
    {
      return;
    }
    this.MI = 0;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.MI != 0)
    {
      if (this.wqI != this.wqL) {
        a(this.wqI, paramCanvas);
      }
      if ((this.wqJ != this.wqI) && (this.wqJ != this.wqL)) {
        a(this.wqJ, paramCanvas);
      }
    }
    int k;
    int m;
    int i;
    float f;
    if (this.hqL != null)
    {
      k = this.hqL.getWidth();
      m = this.hqL.getHeight();
      int j = this.wqB.x;
      int n = getWidth();
      i = j;
      if (j < 0) {
        i = -j;
      }
      if (i >= n) {
        break label216;
      }
      f = (n - i) / n;
    }
    label216:
    for (f *= f;; f = 0.0F)
    {
      i = (int)(f * (255.0F * this.wqG));
      paramCanvas.save();
      paramCanvas.translate(this.wqB.x, this.wqB.y);
      paramCanvas.clipRect(0, 0, k, m);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, k, m, i, 31);
      this.hqL.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.restore();
      return;
    }
  }
  
  public float getFloatAlpha()
  {
    return this.wqG;
  }
  
  public ListAdapter getInputAdapter()
  {
    if (this.wrr == null) {
      return null;
    }
    return this.wrr.NK;
  }
  
  protected void layoutChildren()
  {
    super.layoutChildren();
    if (this.hqL != null)
    {
      if ((this.hqL.isLayoutRequested()) && (!this.wqE)) {
        cKD();
      }
      this.hqL.layout(0, 0, this.hqL.getMeasuredWidth(), this.hqL.getMeasuredHeight());
      this.wqE = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.wrs)
    {
      paramCanvas = this.wrt;
      if (paramCanvas.wrP)
      {
        paramCanvas.mBuilder.append("<DSLVState>\n");
        int j = paramCanvas.wrD.getChildCount();
        int k = paramCanvas.wrD.getFirstVisiblePosition();
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
          paramCanvas.mBuilder.append(paramCanvas.wrD.getChildAt(i).getTop()).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</Tops>\n");
        paramCanvas.mBuilder.append("    <Bottoms>");
        i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(paramCanvas.wrD.getChildAt(i).getBottom()).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</Bottoms>\n");
        paramCanvas.mBuilder.append("    <FirstExpPos>").append(paramCanvas.wrD.wqI).append("</FirstExpPos>\n");
        paramCanvas.mBuilder.append("    <FirstExpBlankHeight>").append(paramCanvas.wrD.IE(paramCanvas.wrD.wqI) - paramCanvas.wrD.IG(paramCanvas.wrD.wqI)).append("</FirstExpBlankHeight>\n");
        paramCanvas.mBuilder.append("    <SecondExpPos>").append(paramCanvas.wrD.wqJ).append("</SecondExpPos>\n");
        paramCanvas.mBuilder.append("    <SecondExpBlankHeight>").append(paramCanvas.wrD.IE(paramCanvas.wrD.wqJ) - paramCanvas.wrD.IG(paramCanvas.wrD.wqJ)).append("</SecondExpBlankHeight>\n");
        paramCanvas.mBuilder.append("    <SrcPos>").append(paramCanvas.wrD.wqL).append("</SrcPos>\n");
        paramCanvas.mBuilder.append("    <SrcHeight>").append(paramCanvas.wrD.wqT + paramCanvas.wrD.getDividerHeight()).append("</SrcHeight>\n");
        paramCanvas.mBuilder.append("    <ViewHeight>").append(paramCanvas.wrD.getHeight()).append("</ViewHeight>\n");
        paramCanvas.mBuilder.append("    <LastY>").append(paramCanvas.wrD.gUK).append("</LastY>\n");
        paramCanvas.mBuilder.append("    <FloatY>").append(paramCanvas.wrD.wqD).append("</FloatY>\n");
        paramCanvas.mBuilder.append("    <ShuffleEdges>");
        i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(paramCanvas.wrD.fN(k + i, paramCanvas.wrD.getChildAt(i).getTop())).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</ShuffleEdges>\n");
        paramCanvas.mBuilder.append("</DSLVState>\n");
        paramCanvas.wrN += 1;
        if (paramCanvas.wrN > 1000)
        {
          paramCanvas.flush();
          paramCanvas.wrN = 0;
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.wqR) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    O(paramMotionEvent);
    this.wrk = true;
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0)
    {
      if (this.MI != 0)
      {
        this.wrv = true;
        return true;
      }
      this.wrl = true;
    }
    if (this.hqL != null)
    {
      bool = true;
      if ((i == 1) || (i == 3)) {
        this.wrl = false;
      }
      return bool;
    }
    if (super.onInterceptTouchEvent(paramMotionEvent)) {
      this.wrB = true;
    }
    for (boolean bool = true;; bool = false) {
      switch (i)
      {
      case 2: 
      default: 
        if (bool) {
          this.wro = 1;
        }
        break;
      case 1: 
      case 3: 
        cKA();
        break;
        this.wro = 2;
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.hqL != null)
    {
      if (this.hqL.isLayoutRequested()) {
        cKD();
      }
      this.wqE = true;
    }
    this.wqV = paramInt1;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    cKB();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.wrv)
    {
      this.wrv = false;
      return false;
    }
    if (!this.wqR) {
      return super.onTouchEvent(paramMotionEvent);
    }
    boolean bool1 = this.wrk;
    this.wrk = false;
    if (!bool1) {
      O(paramMotionEvent);
    }
    boolean bool2;
    if (this.MI == 4)
    {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
      for (;;)
      {
        bool2 = true;
        return bool2;
        if (this.MI == 4) {
          cKw();
        }
        cKA();
        continue;
        if (this.MI == 4)
        {
          this.wrz = false;
          b(false, 0.0F);
        }
        cKA();
        continue;
        int j = (int)paramMotionEvent.getX();
        int i = (int)paramMotionEvent.getY();
        this.wqB.x = (j - this.wqM);
        this.wqB.y = (i - this.wqN);
        cKE();
        j = Math.min(i, this.wqD + this.wqU);
        int k = Math.max(i, this.wqD - this.wqU);
        paramMotionEvent = this.wqX;
        if (paramMotionEvent.wlh) {}
        for (i = paramMotionEvent.wrL;; i = -1)
        {
          if ((j <= this.gUK) || (j <= this.wrb) || (i == 1)) {
            break label281;
          }
          if (i != -1) {
            this.wqX.cKG();
          }
          this.wqX.IH(1);
          break;
        }
        label281:
        if ((k < this.gUK) && (k < this.wra) && (i != 0))
        {
          if (i != -1) {
            this.wqX.cKG();
          }
          this.wqX.IH(0);
        }
        else if ((k >= this.wra) && (j <= this.wrb) && (this.wqX.wlh))
        {
          this.wqX.cKG();
        }
      }
    }
    if ((this.MI == 0) && (super.onTouchEvent(paramMotionEvent))) {}
    for (bool1 = true;; bool1 = false) {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 2: 
      default: 
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        this.wro = 1;
        bool2 = bool1;
        break;
      case 1: 
      case 3: 
        cKA();
        bool2 = bool1;
        break;
      }
    }
  }
  
  public final void removeItem(int paramInt)
  {
    this.wrz = false;
    l(paramInt, 0.0F);
  }
  
  public void requestLayout()
  {
    if (!this.wru) {
      super.requestLayout();
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (paramListAdapter != null)
    {
      this.wrr = new DragSortListView.a(this, paramListAdapter, (byte)0);
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
      super.setAdapter(this.wrr);
      return;
      this.wrr = null;
    }
  }
  
  public void setDragEnabled(boolean paramBoolean)
  {
    this.wqR = paramBoolean;
  }
  
  public void setDragListener(DragSortListView.b paramb)
  {
    this.wqO = paramb;
  }
  
  public void setDragScrollProfile(c paramc)
  {
    if (paramc != null) {
      this.wrh = paramc;
    }
  }
  
  public void setDragScrollStart(float paramFloat)
  {
    if (paramFloat > 0.5F)
    {
      this.wqZ = 0.5F;
      if (paramFloat <= 0.5F) {
        break label46;
      }
    }
    label46:
    for (this.wqY = 0.5F;; this.wqY = paramFloat)
    {
      if (getHeight() != 0) {
        cKB();
      }
      return;
      this.wqZ = paramFloat;
      break;
    }
  }
  
  public void setDragSortListener(e parame)
  {
    setDropListener(parame);
    setDragListener(parame);
    setRemoveListener(parame);
  }
  
  public void setDropListener(DragSortListView.h paramh)
  {
    this.wqP = paramh;
  }
  
  public void setFloatAlpha(float paramFloat)
  {
    this.wqG = paramFloat;
  }
  
  public void setFloatViewManager(DragSortListView.i parami)
  {
    this.wrm = parami;
  }
  
  public void setMaxScrollSpeed(float paramFloat)
  {
    this.wrg = paramFloat;
  }
  
  public void setRemoveListener(DragSortListView.l paraml)
  {
    this.wqQ = paraml;
  }
  
  public static abstract interface c
  {
    public abstract float aP(float paramFloat);
  }
  
  private final class d
    implements Runnable
  {
    private int dy;
    boolean wlh = false;
    private boolean wrG;
    private long wrH;
    private long wrI;
    private float wrJ;
    private long wrK;
    int wrL;
    private float wrM;
    
    d() {}
    
    public final void IH(int paramInt)
    {
      if (!this.wlh)
      {
        this.wrG = false;
        this.wlh = true;
        this.wrK = SystemClock.uptimeMillis();
        this.wrH = this.wrK;
        this.wrL = paramInt;
        DragSortListView.this.post(this);
      }
    }
    
    public final void cKG()
    {
      DragSortListView.this.removeCallbacks(this);
      this.wlh = false;
    }
    
    public final void run()
    {
      if (this.wrG)
      {
        this.wlh = false;
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
      if (this.wrL == 0)
      {
        localView = DragSortListView.this.getChildAt(0);
        if (localView == null)
        {
          this.wlh = false;
          return;
        }
        if ((j == 0) && (localView.getTop() == k))
        {
          this.wlh = false;
          return;
        }
        this.wrM = DragSortListView.u(DragSortListView.this).aP((DragSortListView.s(DragSortListView.this) - i2) / DragSortListView.t(DragSortListView.this));
        this.wrI = SystemClock.uptimeMillis();
        this.wrJ = ((float)(this.wrI - this.wrH));
        this.dy = Math.round(this.wrM * this.wrJ);
        if (this.dy < 0) {
          break label461;
        }
        this.dy = Math.min(n, this.dy);
        i = j;
      }
      for (;;)
      {
        localView = DragSortListView.this.getChildAt(i - j);
        m = localView.getTop() + this.dy;
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
        this.wrH = this.wrI;
        DragSortListView.this.post(this);
        return;
        localView = DragSortListView.this.getChildAt(i - j);
        if (localView == null)
        {
          this.wlh = false;
          return;
        }
        if ((i == m - 1) && (localView.getBottom() <= n + k))
        {
          this.wlh = false;
          return;
        }
        this.wrM = (-DragSortListView.u(DragSortListView.this).aP((i1 - DragSortListView.v(DragSortListView.this)) / DragSortListView.w(DragSortListView.this)));
        break;
        label461:
        this.dy = Math.max(-n, this.dy);
      }
    }
  }
  
  public static abstract interface e
    extends DragSortListView.b, DragSortListView.h, DragSortListView.l
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView
 * JD-Core Version:    0.7.0.1
 */