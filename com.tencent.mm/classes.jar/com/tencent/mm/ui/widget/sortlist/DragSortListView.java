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
import com.tencent.mm.cm.a.a;
import com.tencent.mm.ui.an;
import java.io.File;
import java.io.IOException;

public class DragSortListView
  extends ListView
{
  private Point HLU;
  private Point HLV;
  private int HLW;
  private boolean HLX;
  private float HLY;
  private float HLZ;
  private c HMA;
  private int HMB;
  private int HMC;
  private boolean HMD;
  boolean HME;
  i HMF;
  private MotionEvent HMG;
  private int HMH;
  private float HMI;
  private float HMJ;
  private a HMK;
  private boolean HML;
  private f HMM;
  private boolean HMN;
  private boolean HMO;
  private DragSortListView.j HMP;
  private k HMQ;
  private g HMR;
  private boolean HMS;
  private float HMT;
  boolean HMU;
  private boolean HMV;
  private int HMa;
  private int HMb;
  private int HMc;
  private boolean HMd;
  private int HMe;
  private int HMf;
  private int HMg;
  private b HMh;
  private DragSortListView.h HMi;
  private l HMj;
  boolean HMk;
  private int HMl;
  private int HMm;
  private int HMn;
  private int HMo;
  private View[] HMp;
  private d HMq;
  private float HMr;
  private float HMs;
  private int HMt;
  private int HMu;
  private float HMv;
  private float HMw;
  private float HMx;
  private float HMy;
  private float HMz;
  private int Tz;
  private View lVI;
  private int ldD;
  private int ldE;
  private DataSetObserver mObserver;
  private int mOffsetX;
  private int mOffsetY;
  private int mX;
  private int mY;
  
  public DragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159791);
    this.HLU = new Point();
    this.HLV = new Point();
    this.HLX = false;
    this.HLY = 1.0F;
    this.HLZ = 1.0F;
    this.HMd = false;
    this.HMk = true;
    this.Tz = 0;
    this.HMl = 1;
    this.HMo = 0;
    this.HMp = new View[1];
    this.HMr = 0.3333333F;
    this.HMs = 0.3333333F;
    this.HMz = 0.5F;
    this.HMA = new c()
    {
      public final float bN(float paramAnonymousFloat)
      {
        AppMethodBeat.i(159754);
        float f = DragSortListView.a(DragSortListView.this);
        AppMethodBeat.o(159754);
        return f * paramAnonymousFloat;
      }
    };
    this.HMC = 0;
    this.HMD = false;
    this.HME = false;
    this.HMF = null;
    this.HMH = 0;
    this.HMI = 0.25F;
    this.HMJ = 0.0F;
    this.HML = false;
    this.HMN = false;
    this.HMO = false;
    this.HMP = new DragSortListView.j(this, (byte)0);
    this.HMT = 0.0F;
    this.HMU = false;
    this.HMV = false;
    int j = 150;
    int i = 150;
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, a.a.DragSortListView, 0, 0);
      this.HMl = Math.max(1, paramContext.getDimensionPixelSize(1, 1));
      this.HML = paramContext.getBoolean(16, false);
      if (this.HML) {
        this.HMM = new f();
      }
      this.HLY = paramContext.getFloat(8, this.HLY);
      this.HLZ = this.HLY;
      this.HMk = paramContext.getBoolean(2, this.HMk);
      this.HMI = Math.max(0.0F, Math.min(1.0F, 1.0F - paramContext.getFloat(14, 0.75F)));
      if (this.HMI <= 0.0F) {
        break label603;
      }
    }
    label603:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.HMd = bool1;
      setDragScrollStart(paramContext.getFloat(4, this.HMr));
      this.HMz = paramContext.getFloat(10, this.HMz);
      j = paramContext.getInt(11, 150);
      i = paramContext.getInt(6, 150);
      if (paramContext.getBoolean(17, true))
      {
        bool1 = paramContext.getBoolean(12, false);
        int k = paramContext.getInt(13, 1);
        boolean bool2 = paramContext.getBoolean(15, true);
        int m = paramContext.getInt(5, 0);
        int n = paramContext.getResourceId(3, 0);
        int i1 = paramContext.getResourceId(7, 0);
        int i2 = paramContext.getResourceId(0, 0);
        int i3 = paramContext.getColor(9, -16777216);
        paramAttributeSet = new a(this, n, m, k, i2, i1);
        paramAttributeSet.HLB = bool1;
        paramAttributeSet.HLA = bool2;
        paramAttributeSet.HNC = i3;
        this.HMF = paramAttributeSet;
        setOnTouchListener(paramAttributeSet);
      }
      paramContext.recycle();
      this.HMq = new d();
      if (j > 0) {
        this.HMQ = new k(j, (byte)0);
      }
      if (i > 0) {
        this.HMR = new g(i, (byte)0);
      }
      this.HMG = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
      this.mObserver = new DataSetObserver()
      {
        private void cancel()
        {
          AppMethodBeat.i(159755);
          if (DragSortListView.b(DragSortListView.this) == 4) {
            DragSortListView.this.fgr();
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
  
  private int a(int paramInt1, View paramView, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159820);
    int i = aaZ(paramInt1);
    int m = paramView.getHeight();
    int n = jO(paramInt1, i);
    int j;
    if (paramInt1 != this.HMe)
    {
      j = m - i;
      i = n - i;
    }
    for (;;)
    {
      int i1 = this.HMm;
      int k = i1;
      if (this.HMe != this.HMb)
      {
        k = i1;
        if (this.HMe != this.HMc) {
          k = i1 - this.HMl;
        }
      }
      if (paramInt1 <= paramInt2)
      {
        if (paramInt1 <= this.HMb) {
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
          if (paramInt1 <= this.HMb) {
            paramInt1 = j - k + 0;
          } else if (paramInt1 == this.HMc) {
            paramInt1 = m - n + 0;
          } else {
            paramInt1 = j + 0;
          }
        }
        else if (paramInt1 <= this.HMb) {
          paramInt1 = 0 - k;
        } else if (paramInt1 == this.HMc) {
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
        if (paramInt <= this.HMe) {
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
    if ((paramInt != this.HMe) && (paramInt != this.HMb) && (paramInt != this.HMc))
    {
      i = -2;
      if (i != localLayoutParams.height)
      {
        localLayoutParams.height = i;
        paramView.setLayoutParams(localLayoutParams);
      }
      if ((paramInt == this.HMb) || (paramInt == this.HMc))
      {
        if (paramInt >= this.HMe) {
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
      if (paramInt == this.HMe)
      {
        i = j;
        if (this.lVI != null) {
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
      if (paramInt > this.HMe) {
        ((b)paramView).setGravity(48);
      }
    }
  }
  
  private int aaX(int paramInt)
  {
    AppMethodBeat.i(159795);
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null)
    {
      paramInt = localView.getHeight();
      AppMethodBeat.o(159795);
      return paramInt;
    }
    paramInt = jO(paramInt, aaZ(paramInt));
    AppMethodBeat.o(159795);
    return paramInt;
  }
  
  private void aaY(int paramInt)
  {
    AppMethodBeat.i(159803);
    this.Tz = 1;
    if (this.HMj != null) {
      this.HMj.remove(paramInt);
    }
    fgB();
    fgu();
    fgs();
    if (this.HME)
    {
      this.Tz = 3;
      AppMethodBeat.o(159803);
      return;
    }
    this.Tz = 0;
    AppMethodBeat.o(159803);
  }
  
  private int aaZ(int paramInt)
  {
    AppMethodBeat.i(159816);
    if (paramInt == this.HMe)
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
    int i = this.HMP.get(paramInt);
    if (i != -1)
    {
      AppMethodBeat.o(159816);
      return i;
    }
    localObject = getAdapter();
    i = ((ListAdapter)localObject).getItemViewType(paramInt);
    int j = ((ListAdapter)localObject).getViewTypeCount();
    if (j != this.HMp.length) {
      this.HMp = new View[j];
    }
    if (i >= 0) {
      if (this.HMp[i] == null)
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
        this.HMp[i] = localObject;
      }
    }
    for (;;)
    {
      i = b(paramInt, (View)localObject, true);
      this.HMP.add(paramInt, i);
      AppMethodBeat.o(159816);
      return i;
      localObject = ((ListAdapter)localObject).getView(paramInt, this.HMp[i], this);
      continue;
      localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
    }
  }
  
  private void ak(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159809);
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      this.ldD = this.mX;
      this.ldE = this.mY;
    }
    this.mX = ((int)paramMotionEvent.getX());
    this.mY = ((int)paramMotionEvent.getY());
    if (i == 0)
    {
      this.ldD = this.mX;
      this.ldE = this.mY;
    }
    this.mOffsetX = ((int)paramMotionEvent.getRawX() - this.mX);
    this.mOffsetY = ((int)paramMotionEvent.getRawY() - this.mY);
    AppMethodBeat.o(159809);
  }
  
  private int b(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159817);
    if (paramInt == this.HMe)
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
      gy(localView);
      paramInt = localView.getMeasuredHeight();
    }
    AppMethodBeat.o(159817);
    return paramInt;
  }
  
  private int c(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159818);
    paramInt = jO(paramInt, b(paramInt, paramView, paramBoolean));
    AppMethodBeat.o(159818);
    return paramInt;
  }
  
  private boolean c(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(159806);
    if (this.lVI != null)
    {
      this.HMq.fgC();
      if (paramBoolean) {
        w(this.HMe - getHeaderViewsCount(), paramFloat);
      }
      for (;;)
      {
        if (this.HML) {
          this.HMM.stopTracking();
        }
        AppMethodBeat.o(159806);
        return true;
        if (this.HMR != null) {
          this.HMR.start();
        } else {
          fgt();
        }
      }
    }
    AppMethodBeat.o(159806);
    return false;
  }
  
  private void d(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159827);
    this.HMN = true;
    fgA();
    int i = this.HMb;
    int j = this.HMc;
    boolean bool = fgq();
    if (bool)
    {
      fgx();
      setSelectionFromTop(paramInt, a(paramInt, paramView, i, j) + paramView.getTop() - getPaddingTop());
      layoutChildren();
    }
    if ((bool) || (paramBoolean)) {
      invalidate();
    }
    this.HMN = false;
    AppMethodBeat.o(159827);
  }
  
  private void fgA()
  {
    AppMethodBeat.i(159828);
    if (this.HMF != null)
    {
      this.HLV.set(this.mX, this.mY);
      this.HMF.h(this.HLU);
    }
    int i = this.HLU.x;
    int m = this.HLU.y;
    int j = getPaddingLeft();
    int k;
    if (((this.HMC & 0x1) == 0) && (i > j))
    {
      this.HLU.x = j;
      j = getHeaderViewsCount();
      k = getFooterViewsCount();
      int n = getFirstVisiblePosition();
      int i1 = getLastVisiblePosition();
      i = getPaddingTop();
      if (n < j) {
        i = getChildAt(j - n - 1).getBottom();
      }
      j = i;
      if ((this.HMC & 0x8) == 0)
      {
        j = i;
        if (n <= this.HMe) {
          j = Math.max(getChildAt(this.HMe - n).getTop(), i);
        }
      }
      i = getHeight() - getPaddingBottom();
      if (i1 >= getCount() - k - 1) {
        i = getChildAt(getCount() - k - 1 - n).getBottom();
      }
      k = i;
      if ((this.HMC & 0x4) == 0)
      {
        k = i;
        if (i1 >= this.HMe) {
          k = Math.min(getChildAt(this.HMe - n).getBottom(), i);
        }
      }
      if (m >= j) {
        break label319;
      }
      this.HLU.y = j;
    }
    for (;;)
    {
      this.HLW = (this.HLU.y + this.HMn);
      AppMethodBeat.o(159828);
      return;
      if (((this.HMC & 0x2) != 0) || (i >= j)) {
        break;
      }
      this.HLU.x = j;
      break;
      label319:
      if (this.HMm + m > k) {
        this.HLU.y = (k - this.HMm);
      }
    }
  }
  
  private void fgB()
  {
    AppMethodBeat.i(159829);
    if (this.lVI != null)
    {
      this.lVI.setVisibility(8);
      if (this.HMF != null) {
        this.HMF.gz(this.lVI);
      }
      this.lVI = null;
      invalidate();
    }
    AppMethodBeat.o(159829);
  }
  
  private boolean fgq()
  {
    boolean bool2 = true;
    AppMethodBeat.i(159797);
    int j = getFirstVisiblePosition();
    int i = this.HMb;
    View localView2 = getChildAt(i - j);
    View localView1 = localView2;
    if (localView2 == null)
    {
      i = j + getChildCount() / 2;
      localView1 = getChildAt(i - j);
    }
    int i2 = localView1.getTop();
    int i1 = localView1.getHeight();
    j = jN(i, i2);
    int i3 = getDividerHeight();
    int k;
    int m;
    int n;
    if (this.HLW < j)
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
      i = aaX(i1);
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
      i1 = this.HMb;
      i2 = this.HMc;
      float f1 = this.HMJ;
      int i4;
      label207:
      float f2;
      if (this.HMd)
      {
        i4 = Math.abs(i - j);
        if (this.HLW < i)
        {
          m = (int)(this.HMI * 0.5F * i4);
          f2 = m;
          j += m;
          if (this.HLW >= j) {
            break label552;
          }
          this.HMb = (k - 1);
          this.HMc = k;
          this.HMJ = ((j - this.HLW) * 0.5F / f2);
          label272:
          if (this.HMb >= n) {
            break label613;
          }
          this.HMb = n;
          this.HMc = n;
          k = n;
          label297:
          if ((this.HMb == i1) && (this.HMc == i2) && (Math.abs(this.HMJ - f1) <= 0.0F)) {
            break label656;
          }
        }
      }
      label656:
      for (boolean bool1 = true;; bool1 = false)
      {
        if (k != this.HMa)
        {
          this.HMa = k;
          bool1 = bool2;
        }
        for (;;)
        {
          AppMethodBeat.o(159797);
          return bool1;
          i2 -= i + i3;
          m = jN(i1, i2);
          i = m;
          k = i1;
          if (this.HLW >= m) {
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
            i1 = aaX(m + 1);
            n = jN(m + 1, i2);
            i = n;
            k = m;
            if (this.HLW < n) {
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
          if (this.HLW >= i - m)
          {
            this.HMb = k;
            this.HMc = (k + 1);
            this.HMJ = ((1.0F + (i - this.HLW) / f2) * 0.5F);
            break label272;
          }
          this.HMb = k;
          this.HMc = k;
          break label272;
          label613:
          if (this.HMc < getCount() - i3) {
            break label297;
          }
          k = getCount() - i3 - 1;
          this.HMb = k;
          this.HMc = k;
          break label297;
        }
      }
      label662:
      j = i;
      i = n;
    }
  }
  
  private void fgs()
  {
    this.HMe = -1;
    this.HMb = -1;
    this.HMc = -1;
    this.HMa = -1;
  }
  
  private void fgt()
  {
    AppMethodBeat.i(159802);
    this.Tz = 2;
    if ((this.HMi != null) && (this.HMa >= 0) && (this.HMa < getCount()))
    {
      int i = getHeaderViewsCount();
      this.HMi.eg(this.HMe - i, this.HMa - i);
    }
    fgB();
    fgu();
    fgs();
    fgx();
    if (this.HME)
    {
      this.Tz = 3;
      AppMethodBeat.o(159802);
      return;
    }
    this.Tz = 0;
    AppMethodBeat.o(159802);
  }
  
  private void fgu()
  {
    int i = 0;
    AppMethodBeat.i(159804);
    int j = getFirstVisiblePosition();
    if (this.HMe < j)
    {
      View localView = getChildAt(0);
      if (localView != null) {
        i = localView.getTop();
      }
      setSelectionFromTop(j - 1, i - getPaddingTop());
    }
    AppMethodBeat.o(159804);
  }
  
  private void fgv()
  {
    AppMethodBeat.i(159808);
    this.HMH = 0;
    this.HME = false;
    if (this.Tz == 3) {
      this.Tz = 0;
    }
    this.HLZ = this.HLY;
    this.HMU = false;
    this.HMP.clear();
    AppMethodBeat.o(159808);
  }
  
  private void fgw()
  {
    AppMethodBeat.i(159812);
    int i = getPaddingTop();
    int j = getHeight() - i - getPaddingBottom();
    float f1 = j;
    this.HMw = (i + this.HMr * f1);
    float f2 = i;
    this.HMv = (f1 * (1.0F - this.HMs) + f2);
    this.HMt = ((int)this.HMw);
    this.HMu = ((int)this.HMv);
    this.HMx = (this.HMw - i);
    this.HMy = (i + j - this.HMv);
    AppMethodBeat.o(159812);
  }
  
  private void fgx()
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
  
  private void fgy()
  {
    AppMethodBeat.i(159822);
    if (this.lVI != null)
    {
      gy(this.lVI);
      this.HMm = this.lVI.getMeasuredHeight();
      this.HMn = (this.HMm / 2);
    }
    AppMethodBeat.o(159822);
  }
  
  private void fgz()
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
  
  private void gy(View paramView)
  {
    AppMethodBeat.i(159821);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null)
    {
      localObject = new AbsListView.LayoutParams(-1, -2);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int j = ViewGroup.getChildMeasureSpec(this.HMo, getListPaddingLeft() + getListPaddingRight(), ((ViewGroup.LayoutParams)localObject).width);
    if (((ViewGroup.LayoutParams)localObject).height > 0) {}
    for (int i = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(j, i);
      AppMethodBeat.o(159821);
      return;
    }
  }
  
  private int jN(int paramInt1, int paramInt2)
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
    int m = this.HMm - this.HMl;
    int k = aaZ(paramInt1);
    int n = aaX(paramInt1);
    if (this.HMc <= this.HMe) {
      if ((paramInt1 == this.HMc) && (this.HMb != this.HMc)) {
        if (paramInt1 == this.HMe)
        {
          i = paramInt2 + n - this.HMm;
          if (paramInt1 > this.HMe) {
            break label256;
          }
        }
      }
    }
    label256:
    for (paramInt1 = (this.HMm - j - aaZ(paramInt1 - 1)) / 2 + i;; paramInt1 = (k - j - this.HMm) / 2 + i)
    {
      AppMethodBeat.o(159796);
      return paramInt1;
      i = n - k + paramInt2 - m;
      break;
      i = paramInt2;
      if (paramInt1 <= this.HMc) {
        break;
      }
      i = paramInt2;
      if (paramInt1 > this.HMe) {
        break;
      }
      i = paramInt2 - m;
      break;
      if ((paramInt1 > this.HMe) && (paramInt1 <= this.HMb))
      {
        i = paramInt2 + m;
        break;
      }
      i = paramInt2;
      if (paramInt1 != this.HMc) {
        break;
      }
      i = paramInt2;
      if (this.HMb == this.HMc) {
        break;
      }
      i = paramInt2 + (n - k);
      break;
    }
  }
  
  private int jO(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    int k;
    if ((this.HMd) && (this.HMb != this.HMc))
    {
      i = 1;
      j = this.HMm - this.HMl;
      k = (int)(this.HMJ * j);
      if (paramInt1 != this.HMe) {
        break label109;
      }
      if (this.HMe != this.HMb) {
        break label85;
      }
      if (i == 0) {
        break label80;
      }
      i = k + this.HMl;
    }
    label80:
    label85:
    label109:
    do
    {
      return i;
      i = 0;
      break;
      return this.HMm;
      if (this.HMe == this.HMc) {
        return this.HMm - k;
      }
      return this.HMl;
      if (paramInt1 == this.HMb)
      {
        if (i != 0) {
          return paramInt2 + k;
        }
        return paramInt2 + j;
      }
      i = paramInt2;
    } while (paramInt1 != this.HMc);
    return paramInt2 + j - k;
  }
  
  private void w(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(159800);
    if ((this.Tz == 0) || (this.Tz == 4))
    {
      if (this.Tz == 0)
      {
        this.HMe = (getHeaderViewsCount() + paramInt);
        this.HMb = this.HMe;
        this.HMc = this.HMe;
        this.HMa = this.HMe;
        View localView = getChildAt(this.HMe - getFirstVisiblePosition());
        if (localView != null) {
          localView.setVisibility(4);
        }
      }
      this.Tz = 1;
      this.HMT = paramFloat;
      if (this.HME) {
        switch (this.HMH)
        {
        }
      }
      while (this.HMQ != null)
      {
        this.HMQ.start();
        AppMethodBeat.o(159800);
        return;
        super.onTouchEvent(this.HMG);
        continue;
        super.onInterceptTouchEvent(this.HMG);
      }
      aaY(paramInt);
    }
    AppMethodBeat.o(159800);
  }
  
  public final boolean a(int paramInt1, View paramView, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159825);
    if ((this.Tz != 0) || (!this.HME) || (this.lVI != null) || (paramView == null) || (!this.HMk))
    {
      AppMethodBeat.o(159825);
      return false;
    }
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    paramInt1 = getHeaderViewsCount() + paramInt1;
    this.HMb = paramInt1;
    this.HMc = paramInt1;
    this.HMe = paramInt1;
    this.HMa = paramInt1;
    this.Tz = 4;
    this.HMC = 0;
    this.HMC |= paramInt2;
    this.lVI = paramView;
    fgy();
    this.HMf = paramInt3;
    this.HMg = paramInt4;
    this.HMB = this.mY;
    this.HLU.x = (this.mX - this.HMf);
    this.HLU.y = (this.mY - this.HMg);
    paramView = getChildAt(this.HMe - getFirstVisiblePosition());
    if (paramView != null) {
      paramView.setVisibility(4);
    }
    if (this.HML)
    {
      paramView = this.HMM;
      paramView.mBuilder.append("<DSLVStates>\n");
      paramView.HNi = 0;
      paramView.HNj = true;
    }
    switch (this.HMH)
    {
    }
    for (;;)
    {
      requestLayout();
      AppMethodBeat.o(159825);
      return true;
      super.onTouchEvent(this.HMG);
      continue;
      super.onInterceptTouchEvent(this.HMG);
    }
  }
  
  public final boolean bM(float paramFloat)
  {
    AppMethodBeat.i(159805);
    this.HMS = true;
    boolean bool = c(true, paramFloat);
    AppMethodBeat.o(159805);
    return bool;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159794);
    super.dispatchDraw(paramCanvas);
    if (this.Tz != 0)
    {
      if (this.HMb != this.HMe) {
        a(this.HMb, paramCanvas);
      }
      if ((this.HMc != this.HMb) && (this.HMc != this.HMe)) {
        a(this.HMc, paramCanvas);
      }
    }
    int k;
    int m;
    int i;
    float f;
    if (this.lVI != null)
    {
      k = this.lVI.getWidth();
      m = this.lVI.getHeight();
      int j = this.HLU.x;
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
      i = (int)(f * (255.0F * this.HLZ));
      paramCanvas.save();
      paramCanvas.translate(this.HLU.x, this.HLU.y);
      paramCanvas.clipRect(0, 0, k, m);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, k, m, i, 31);
      this.lVI.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.restore();
      AppMethodBeat.o(159794);
      return;
    }
  }
  
  public final void fgr()
  {
    AppMethodBeat.i(159801);
    if (this.Tz == 4)
    {
      this.HMq.fgC();
      fgB();
      fgs();
      fgx();
      if (this.HME)
      {
        this.Tz = 3;
        AppMethodBeat.o(159801);
        return;
      }
      this.Tz = 0;
    }
    AppMethodBeat.o(159801);
  }
  
  public float getFloatAlpha()
  {
    return this.HLZ;
  }
  
  public ListAdapter getInputAdapter()
  {
    if (this.HMK == null) {
      return null;
    }
    return this.HMK.DP;
  }
  
  protected void layoutChildren()
  {
    AppMethodBeat.i(159824);
    super.layoutChildren();
    if (this.lVI != null)
    {
      if ((this.lVI.isLayoutRequested()) && (!this.HLX)) {
        fgy();
      }
      this.lVI.layout(0, 0, this.lVI.getMeasuredWidth(), this.lVI.getMeasuredHeight());
      this.HLX = false;
    }
    AppMethodBeat.o(159824);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159798);
    super.onDraw(paramCanvas);
    if (this.HML)
    {
      paramCanvas = this.HMM;
      if (paramCanvas.HNj)
      {
        paramCanvas.mBuilder.append("<DSLVState>\n");
        int j = paramCanvas.HMW.getChildCount();
        int k = paramCanvas.HMW.getFirstVisiblePosition();
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
          paramCanvas.mBuilder.append(paramCanvas.HMW.getChildAt(i).getTop()).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</Tops>\n");
        paramCanvas.mBuilder.append("    <Bottoms>");
        i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(paramCanvas.HMW.getChildAt(i).getBottom()).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</Bottoms>\n");
        paramCanvas.mBuilder.append("    <FirstExpPos>").append(paramCanvas.HMW.HMb).append("</FirstExpPos>\n");
        paramCanvas.mBuilder.append("    <FirstExpBlankHeight>").append(paramCanvas.HMW.aaX(paramCanvas.HMW.HMb) - paramCanvas.HMW.aaZ(paramCanvas.HMW.HMb)).append("</FirstExpBlankHeight>\n");
        paramCanvas.mBuilder.append("    <SecondExpPos>").append(paramCanvas.HMW.HMc).append("</SecondExpPos>\n");
        paramCanvas.mBuilder.append("    <SecondExpBlankHeight>").append(paramCanvas.HMW.aaX(paramCanvas.HMW.HMc) - paramCanvas.HMW.aaZ(paramCanvas.HMW.HMc)).append("</SecondExpBlankHeight>\n");
        paramCanvas.mBuilder.append("    <SrcPos>").append(paramCanvas.HMW.HMe).append("</SrcPos>\n");
        paramCanvas.mBuilder.append("    <SrcHeight>").append(paramCanvas.HMW.HMm + paramCanvas.HMW.getDividerHeight()).append("</SrcHeight>\n");
        paramCanvas.mBuilder.append("    <ViewHeight>").append(paramCanvas.HMW.getHeight()).append("</ViewHeight>\n");
        paramCanvas.mBuilder.append("    <LastY>").append(paramCanvas.HMW.ldE).append("</LastY>\n");
        paramCanvas.mBuilder.append("    <FloatY>").append(paramCanvas.HMW.HLW).append("</FloatY>\n");
        paramCanvas.mBuilder.append("    <ShuffleEdges>");
        i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(paramCanvas.HMW.jN(k + i, paramCanvas.HMW.getChildAt(i).getTop())).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</ShuffleEdges>\n");
        paramCanvas.mBuilder.append("</DSLVState>\n");
        paramCanvas.HNh += 1;
        if (paramCanvas.HNh > 1000)
        {
          paramCanvas.flush();
          paramCanvas.HNh = 0;
        }
      }
    }
    AppMethodBeat.o(159798);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159810);
    if (!this.HMk)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(159810);
      return bool;
    }
    ak(paramMotionEvent);
    this.HMD = true;
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0)
    {
      if (this.Tz != 0)
      {
        this.HMO = true;
        AppMethodBeat.o(159810);
        return true;
      }
      this.HME = true;
    }
    if (this.lVI != null)
    {
      bool = true;
      if ((i == 1) || (i == 3)) {
        this.HME = false;
      }
      AppMethodBeat.o(159810);
      return bool;
    }
    if (super.onInterceptTouchEvent(paramMotionEvent)) {
      this.HMU = true;
    }
    for (boolean bool = true;; bool = false) {
      switch (i)
      {
      case 2: 
      default: 
        if (bool) {
          this.HMH = 1;
        }
        break;
      case 1: 
      case 3: 
        fgv();
        break;
        this.HMH = 2;
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159823);
    super.onMeasure(paramInt1, paramInt2);
    if (this.lVI != null)
    {
      if (this.lVI.isLayoutRequested()) {
        fgy();
      }
      this.HLX = true;
    }
    this.HMo = paramInt1;
    AppMethodBeat.o(159823);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159813);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    fgw();
    AppMethodBeat.o(159813);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159807);
    if (this.HMO)
    {
      this.HMO = false;
      AppMethodBeat.o(159807);
      return false;
    }
    if (!this.HMk)
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(159807);
      return bool1;
    }
    boolean bool1 = this.HMD;
    this.HMD = false;
    if (!bool1) {
      ak(paramMotionEvent);
    }
    boolean bool2;
    if (this.Tz == 4)
    {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
      for (;;)
      {
        bool2 = true;
        AppMethodBeat.o(159807);
        return bool2;
        if (this.Tz == 4) {
          fgr();
        }
        fgv();
        continue;
        if (this.Tz == 4)
        {
          this.HMS = false;
          c(false, 0.0F);
        }
        fgv();
        continue;
        int j = (int)paramMotionEvent.getX();
        int i = (int)paramMotionEvent.getY();
        this.HLU.x = (j - this.HMf);
        this.HLU.y = (i - this.HMg);
        fgz();
        j = Math.min(i, this.HLW + this.HMn);
        int k = Math.max(i, this.HLW - this.HMn);
        paramMotionEvent = this.HMq;
        if (paramMotionEvent.HBY) {}
        for (i = paramMotionEvent.HNf;; i = -1)
        {
          if ((j <= this.ldE) || (j <= this.HMu) || (i == 1)) {
            break label307;
          }
          if (i != -1) {
            this.HMq.fgC();
          }
          this.HMq.aba(1);
          break;
        }
        label307:
        if ((k < this.ldE) && (k < this.HMt) && (i != 0))
        {
          if (i != -1) {
            this.HMq.fgC();
          }
          this.HMq.aba(0);
        }
        else if ((k >= this.HMt) && (j <= this.HMu) && (this.HMq.HBY))
        {
          this.HMq.fgC();
        }
      }
    }
    if ((this.Tz == 0) && (super.onTouchEvent(paramMotionEvent))) {}
    for (bool1 = true;; bool1 = false) {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 2: 
      default: 
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        this.HMH = 1;
        bool2 = bool1;
        break;
      case 1: 
      case 3: 
        fgv();
        bool2 = bool1;
        break;
      }
    }
  }
  
  public final void removeItem(int paramInt)
  {
    AppMethodBeat.i(159799);
    this.HMS = false;
    w(paramInt, 0.0F);
    AppMethodBeat.o(159799);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(159819);
    if (!this.HMN) {
      super.requestLayout();
    }
    AppMethodBeat.o(159819);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(159792);
    if (paramListAdapter != null)
    {
      this.HMK = new a(paramListAdapter, (byte)0);
      paramListAdapter.registerDataSetObserver(this.mObserver);
      if ((paramListAdapter instanceof DragSortListView.h)) {
        setDropListener((DragSortListView.h)paramListAdapter);
      }
      if ((paramListAdapter instanceof b)) {
        setDragListener((b)paramListAdapter);
      }
      if ((paramListAdapter instanceof l)) {
        setRemoveListener((l)paramListAdapter);
      }
    }
    for (;;)
    {
      super.setAdapter(this.HMK);
      AppMethodBeat.o(159792);
      return;
      this.HMK = null;
    }
  }
  
  public void setDragEnabled(boolean paramBoolean)
  {
    this.HMk = paramBoolean;
  }
  
  public void setDragListener(b paramb)
  {
    this.HMh = paramb;
  }
  
  public void setDragScrollProfile(c paramc)
  {
    if (paramc != null) {
      this.HMA = paramc;
    }
  }
  
  public void setDragScrollStart(float paramFloat)
  {
    AppMethodBeat.i(159811);
    if (paramFloat > 0.5F)
    {
      this.HMs = 0.5F;
      if (paramFloat <= 0.5F) {
        break label58;
      }
    }
    label58:
    for (this.HMr = 0.5F;; this.HMr = paramFloat)
    {
      if (getHeight() != 0) {
        fgw();
      }
      AppMethodBeat.o(159811);
      return;
      this.HMs = paramFloat;
      break;
    }
  }
  
  public void setDragSortListener(e parame)
  {
    AppMethodBeat.i(159830);
    setDropListener(parame);
    setDragListener(parame);
    setRemoveListener(parame);
    AppMethodBeat.o(159830);
  }
  
  public void setDropListener(DragSortListView.h paramh)
  {
    this.HMi = paramh;
  }
  
  public void setFloatAlpha(float paramFloat)
  {
    this.HLZ = paramFloat;
  }
  
  public void setFloatViewManager(i parami)
  {
    this.HMF = parami;
  }
  
  public void setMaxScrollSpeed(float paramFloat)
  {
    this.HMz = paramFloat;
  }
  
  public void setRemoveListener(l paraml)
  {
    this.HMj = paraml;
  }
  
  final class a
    extends BaseAdapter
  {
    ListAdapter DP;
    
    private a(ListAdapter paramListAdapter)
    {
      AppMethodBeat.i(159760);
      this.DP = paramListAdapter;
      this.DP.registerDataSetObserver(new DataSetObserver()
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
      boolean bool = this.DP.areAllItemsEnabled();
      AppMethodBeat.o(159764);
      return bool;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(159763);
      int i = this.DP.getCount();
      AppMethodBeat.o(159763);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(159762);
      Object localObject = this.DP.getItem(paramInt);
      AppMethodBeat.o(159762);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(159761);
      long l = this.DP.getItemId(paramInt);
      AppMethodBeat.o(159761);
      return l;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(159766);
      paramInt = this.DP.getItemViewType(paramInt);
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
        View localView2 = this.DP.getView(paramInt, localView1, DragSortListView.this);
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
      paramViewGroup = this.DP.getView(paramInt, null, DragSortListView.this);
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
      int i = this.DP.getViewTypeCount();
      AppMethodBeat.o(159767);
      return i;
    }
    
    public final boolean hasStableIds()
    {
      AppMethodBeat.i(159768);
      boolean bool = this.DP.hasStableIds();
      AppMethodBeat.o(159768);
      return bool;
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(159769);
      boolean bool = this.DP.isEmpty();
      AppMethodBeat.o(159769);
      return bool;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(159765);
      boolean bool = this.DP.isEnabled(paramInt);
      AppMethodBeat.o(159765);
      return bool;
    }
  }
  
  public static abstract interface b {}
  
  public static abstract interface c
  {
    public abstract float bN(float paramFloat);
  }
  
  final class d
    implements Runnable
  {
    boolean HBY = false;
    private boolean HMZ;
    private long HNa;
    private long HNb;
    private int HNc;
    private float HNd;
    private long HNe;
    int HNf;
    private float HNg;
    
    d() {}
    
    public final void aba(int paramInt)
    {
      AppMethodBeat.i(159771);
      if (!this.HBY)
      {
        this.HMZ = false;
        this.HBY = true;
        this.HNe = SystemClock.uptimeMillis();
        this.HNa = this.HNe;
        this.HNf = paramInt;
        DragSortListView.this.post(this);
      }
      AppMethodBeat.o(159771);
    }
    
    public final void fgC()
    {
      AppMethodBeat.i(159772);
      DragSortListView.this.removeCallbacks(this);
      this.HBY = false;
      AppMethodBeat.o(159772);
    }
    
    public final void run()
    {
      AppMethodBeat.i(159773);
      if (this.HMZ)
      {
        this.HBY = false;
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
      if (this.HNf == 0)
      {
        localView = DragSortListView.this.getChildAt(0);
        if (localView == null)
        {
          this.HBY = false;
          AppMethodBeat.o(159773);
          return;
        }
        if ((j == 0) && (localView.getTop() == k))
        {
          this.HBY = false;
          AppMethodBeat.o(159773);
          return;
        }
        this.HNg = DragSortListView.u(DragSortListView.this).bN((DragSortListView.s(DragSortListView.this) - i2) / DragSortListView.t(DragSortListView.this));
        this.HNb = SystemClock.uptimeMillis();
        this.HNd = ((float)(this.HNb - this.HNa));
        this.HNc = Math.round(this.HNg * this.HNd);
        if (this.HNc < 0) {
          break label496;
        }
        this.HNc = Math.min(n, this.HNc);
        i = j;
      }
      for (;;)
      {
        localView = DragSortListView.this.getChildAt(i - j);
        m = localView.getTop() + this.HNc;
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
        this.HNa = this.HNb;
        DragSortListView.this.post(this);
        AppMethodBeat.o(159773);
        return;
        localView = DragSortListView.this.getChildAt(i - j);
        if (localView == null)
        {
          this.HBY = false;
          AppMethodBeat.o(159773);
          return;
        }
        if ((i == m - 1) && (localView.getBottom() <= n + k))
        {
          this.HBY = false;
          AppMethodBeat.o(159773);
          return;
        }
        this.HNg = (-DragSortListView.u(DragSortListView.this).bN((i1 - DragSortListView.v(DragSortListView.this)) / DragSortListView.w(DragSortListView.this)));
        break;
        label496:
        this.HNc = Math.max(-n, this.HNc);
      }
    }
  }
  
  public static abstract interface e
    extends DragSortListView.b, DragSortListView.h, DragSortListView.l
  {}
  
  final class f
  {
    File EVi;
    int HNh;
    int HNi;
    boolean HNj;
    StringBuilder mBuilder;
    
    f()
    {
      AppMethodBeat.i(159774);
      this.mBuilder = new StringBuilder();
      this.HNh = 0;
      this.HNi = 0;
      this.HNj = false;
      this.EVi = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
      if (!this.EVi.exists()) {
        try
        {
          if (!this.EVi.createNewFile()) {
            an.e("mobeta", "creat file fail!! file already exist", new Object[0]);
          }
          an.d("mobeta", "file created", new Object[0]);
          AppMethodBeat.o(159774);
          return;
        }
        catch (IOException this$1)
        {
          an.w("mobeta", "Could not create dslv_state.txt", new Object[0]);
          an.d("mobeta", DragSortListView.this.getMessage(), new Object[0]);
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
      //   6: getfield 45	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:HNj	Z
      //   9: ifne +9 -> 18
      //   12: ldc 97
      //   14: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   17: return
      //   18: aload_0
      //   19: getfield 43	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:HNi	I
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
      //   40: getfield 60	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:EVi	Ljava/io/File;
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
      //   89: getfield 43	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:HNi	I
      //   92: iconst_1
      //   93: iadd
      //   94: putfield 43	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:HNi	I
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
      //   117: invokestatic 144	com/tencent/mm/ui/an:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   153: invokestatic 144	com/tencent/mm/ui/an:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   190: invokestatic 144	com/tencent/mm/ui/an:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    
    public final void stopTracking()
    {
      AppMethodBeat.i(159776);
      if (this.HNj)
      {
        this.mBuilder.append("</DSLVStates>\n");
        flush();
        this.HNj = false;
      }
      AppMethodBeat.o(159776);
    }
  }
  
  final class g
    extends DragSortListView.m
  {
    private int HNk;
    private int HNl;
    private float HNm;
    private float HNn;
    
    private g(int paramInt)
    {
      super(paramInt, (byte)0);
    }
    
    private int fgD()
    {
      AppMethodBeat.i(159778);
      int i = DragSortListView.this.getFirstVisiblePosition();
      int j = (DragSortListView.i(DragSortListView.this) + DragSortListView.this.getDividerHeight()) / 2;
      View localView = DragSortListView.this.getChildAt(this.HNk - i);
      i = -1;
      if (localView != null) {
        if (this.HNk == this.HNl) {
          i = localView.getTop();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(159778);
        return i;
        if (this.HNk < this.HNl)
        {
          i = localView.getTop() - j;
        }
        else
        {
          i = localView.getBottom() + j - DragSortListView.j(DragSortListView.this);
          continue;
          this.mCanceled = true;
        }
      }
    }
    
    public final void bO(float paramFloat)
    {
      AppMethodBeat.i(159779);
      int i = fgD();
      int j = DragSortListView.this.getPaddingLeft();
      float f1 = DragSortListView.d(DragSortListView.this).y - i;
      float f2 = DragSortListView.d(DragSortListView.this).x - j;
      paramFloat = 1.0F - paramFloat;
      if ((paramFloat < Math.abs(f1 / this.HNm)) || (paramFloat < Math.abs(f2 / this.HNn)))
      {
        DragSortListView.d(DragSortListView.this).y = (i + (int)(this.HNm * paramFloat));
        DragSortListView.d(DragSortListView.this).x = (DragSortListView.this.getPaddingLeft() + (int)(this.HNn * paramFloat));
        DragSortListView.f(DragSortListView.this);
      }
      AppMethodBeat.o(159779);
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(159777);
      this.HNk = DragSortListView.g(DragSortListView.this);
      this.HNl = DragSortListView.h(DragSortListView.this);
      DragSortListView.a(DragSortListView.this, 2);
      this.HNm = (DragSortListView.d(DragSortListView.this).y - fgD());
      this.HNn = (DragSortListView.d(DragSortListView.this).x - DragSortListView.this.getPaddingLeft());
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
    public abstract View abb(int paramInt);
    
    public abstract void gz(View paramView);
    
    public abstract void h(Point paramPoint);
  }
  
  final class k
    extends DragSortListView.m
  {
    private float HNq;
    private float HNr;
    private float HNs;
    private int HNt = -1;
    private int HNu = -1;
    private int HNv;
    private int fvL;
    
    private k(int paramInt)
    {
      super(paramInt, (byte)0);
    }
    
    public final void bO(float paramFloat)
    {
      AppMethodBeat.i(159786);
      paramFloat = 1.0F - paramFloat;
      int j = DragSortListView.this.getFirstVisiblePosition();
      View localView = DragSortListView.this.getChildAt(this.fvL - j);
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
          this.HNq += f2 * f1;
          DragSortListView.d(DragSortListView.this).x = ((int)this.HNq);
          if ((this.HNq >= k) || (this.HNq <= -k)) {
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
        if (this.HNt == -1)
        {
          this.HNt = DragSortListView.b(DragSortListView.this, this.fvL, localView);
          this.HNr = (localView.getHeight() - this.HNt);
        }
        i = Math.max((int)(this.HNr * paramFloat), 1);
        localObject = localView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = (i + this.HNt);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.HNv != this.fvL)
      {
        localView = DragSortListView.this.getChildAt(this.HNv - j);
        if (localView != null)
        {
          if (this.HNu == -1)
          {
            this.HNu = DragSortListView.b(DragSortListView.this, this.HNv, localView);
            this.HNs = (localView.getHeight() - this.HNu);
          }
          i = Math.max((int)(this.HNs * paramFloat), 1);
          localObject = localView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = (i + this.HNu);
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(159786);
    }
    
    public final void onStart()
    {
      int i = -1;
      AppMethodBeat.i(159785);
      this.HNt = -1;
      this.HNu = -1;
      this.fvL = DragSortListView.l(DragSortListView.this);
      this.HNv = DragSortListView.m(DragSortListView.this);
      DragSortListView.a(DragSortListView.this, 1);
      this.HNq = DragSortListView.d(DragSortListView.this).x;
      if (DragSortListView.n(DragSortListView.this))
      {
        float f = DragSortListView.this.getWidth() * 2.0F;
        if (DragSortListView.o(DragSortListView.this) == 0.0F)
        {
          DragSortListView localDragSortListView = DragSortListView.this;
          if (this.HNq < 0.0F) {}
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
  
  public static abstract interface l
  {
    public abstract void remove(int paramInt);
  }
  
  class m
    implements Runnable
  {
    private float HNA;
    private float HNw;
    private float HNx;
    private float HNy;
    private float HNz;
    private float mAlpha;
    boolean mCanceled;
    protected long mStartTime;
    
    private m(int paramInt)
    {
      AppMethodBeat.i(159788);
      this.mAlpha = 0.5F;
      this.HNw = paramInt;
      float f = 1.0F / (this.mAlpha * 2.0F * (1.0F - this.mAlpha));
      this.HNA = f;
      this.HNx = f;
      this.HNy = (this.mAlpha / ((this.mAlpha - 1.0F) * 2.0F));
      this.HNz = (1.0F / (1.0F - this.mAlpha));
      AppMethodBeat.o(159788);
    }
    
    public void bO(float paramFloat) {}
    
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
      float f1 = (float)(SystemClock.uptimeMillis() - this.mStartTime) / this.HNw;
      if (f1 >= 1.0F)
      {
        bO(1.0F);
        onStop();
        AppMethodBeat.o(159790);
        return;
      }
      if (f1 < this.mAlpha) {
        f1 *= this.HNx * f1;
      }
      for (;;)
      {
        bO(f1);
        DragSortListView.this.post(this);
        AppMethodBeat.o(159790);
        return;
        if (f1 < 1.0F - this.mAlpha)
        {
          float f2 = this.HNy;
          f1 = f1 * this.HNz + f2;
        }
        else
        {
          f1 = 1.0F - (f1 - 1.0F) * (this.HNA * (f1 - 1.0F));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView
 * JD-Core Version:    0.7.0.1
 */