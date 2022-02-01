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
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.a;

public class DragSortListView
  extends ListView
{
  private int LAA;
  private b LAB;
  private h LAC;
  private l LAD;
  boolean LAE;
  private int LAF;
  private int LAG;
  private int LAH;
  private int LAI;
  private View[] LAJ;
  private d LAK;
  private float LAL;
  private float LAM;
  private int LAN;
  private int LAO;
  private float LAP;
  private float LAQ;
  private float LAR;
  private float LAS;
  private float LAT;
  private c LAU;
  private int LAV;
  private int LAW;
  private boolean LAY;
  boolean LAZ;
  private Point LAo;
  private Point LAp;
  private int LAq;
  private boolean LAr;
  private float LAs;
  private float LAt;
  private int LAu;
  private int LAv;
  private int LAw;
  private boolean LAx;
  private int LAy;
  private int LAz;
  i LBa;
  private MotionEvent LBb;
  private int LBc;
  private float LBd;
  private float LBe;
  private DragSortListView.a LBf;
  private boolean LBg;
  private DragSortListView.f LBh;
  private boolean LBi;
  private boolean LBj;
  private DragSortListView.j LBk;
  private k LBl;
  private g LBm;
  private boolean LBn;
  private float LBo;
  boolean LBp;
  private boolean LBq;
  private int Wk;
  private DataSetObserver mObserver;
  private int mOffsetX;
  private int mOffsetY;
  private int mX;
  private int mY;
  private int mhp;
  private int mhq;
  private View ndz;
  
  public DragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159791);
    this.LAo = new Point();
    this.LAp = new Point();
    this.LAr = false;
    this.LAs = 1.0F;
    this.LAt = 1.0F;
    this.LAx = false;
    this.LAE = true;
    this.Wk = 0;
    this.LAF = 1;
    this.LAI = 0;
    this.LAJ = new View[1];
    this.LAL = 0.3333333F;
    this.LAM = 0.3333333F;
    this.LAT = 0.5F;
    this.LAU = new c()
    {
      public final float bZ(float paramAnonymousFloat)
      {
        AppMethodBeat.i(159754);
        float f = DragSortListView.a(DragSortListView.this);
        AppMethodBeat.o(159754);
        return f * paramAnonymousFloat;
      }
    };
    this.LAW = 0;
    this.LAY = false;
    this.LAZ = false;
    this.LBa = null;
    this.LBc = 0;
    this.LBd = 0.25F;
    this.LBe = 0.0F;
    this.LBg = false;
    this.LBi = false;
    this.LBj = false;
    this.LBk = new DragSortListView.j(this, (byte)0);
    this.LBo = 0.0F;
    this.LBp = false;
    this.LBq = false;
    int j = 150;
    int i = 150;
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, a.a.DragSortListView, 0, 0);
      this.LAF = Math.max(1, paramContext.getDimensionPixelSize(1, 1));
      this.LBg = paramContext.getBoolean(16, false);
      if (this.LBg) {
        this.LBh = new DragSortListView.f(this);
      }
      this.LAs = paramContext.getFloat(8, this.LAs);
      this.LAt = this.LAs;
      this.LAE = paramContext.getBoolean(2, this.LAE);
      this.LBd = Math.max(0.0F, Math.min(1.0F, 1.0F - paramContext.getFloat(14, 0.75F)));
      if (this.LBd <= 0.0F) {
        break label603;
      }
    }
    label603:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.LAx = bool1;
      setDragScrollStart(paramContext.getFloat(4, this.LAL));
      this.LAT = paramContext.getFloat(10, this.LAT);
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
        paramAttributeSet.LzW = bool1;
        paramAttributeSet.LzV = bool2;
        paramAttributeSet.LBX = i3;
        this.LBa = paramAttributeSet;
        setOnTouchListener(paramAttributeSet);
      }
      paramContext.recycle();
      this.LAK = new d();
      if (j > 0) {
        this.LBl = new k(j, (byte)0);
      }
      if (i > 0) {
        this.LBm = new g(i, (byte)0);
      }
      this.LBb = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
      this.mObserver = new DataSetObserver()
      {
        private void cancel()
        {
          AppMethodBeat.i(159755);
          if (DragSortListView.b(DragSortListView.this) == 4) {
            DragSortListView.this.fRA();
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
    int i = agu(paramInt1);
    int m = paramView.getHeight();
    int n = ku(paramInt1, i);
    int j;
    if (paramInt1 != this.LAy)
    {
      j = m - i;
      i = n - i;
    }
    for (;;)
    {
      int i1 = this.LAG;
      int k = i1;
      if (this.LAy != this.LAv)
      {
        k = i1;
        if (this.LAy != this.LAw) {
          k = i1 - this.LAF;
        }
      }
      if (paramInt1 <= paramInt2)
      {
        if (paramInt1 <= this.LAv) {
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
          if (paramInt1 <= this.LAv) {
            paramInt1 = j - k + 0;
          } else if (paramInt1 == this.LAw) {
            paramInt1 = m - n + 0;
          } else {
            paramInt1 = j + 0;
          }
        }
        else if (paramInt1 <= this.LAv) {
          paramInt1 = 0 - k;
        } else if (paramInt1 == this.LAw) {
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
        if (paramInt <= this.LAy) {
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
    if ((paramInt != this.LAy) && (paramInt != this.LAv) && (paramInt != this.LAw))
    {
      i = -2;
      if (i != localLayoutParams.height)
      {
        localLayoutParams.height = i;
        paramView.setLayoutParams(localLayoutParams);
      }
      if ((paramInt == this.LAv) || (paramInt == this.LAw))
      {
        if (paramInt >= this.LAy) {
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
      if (paramInt == this.LAy)
      {
        i = j;
        if (this.ndz != null) {
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
      if (paramInt > this.LAy) {
        ((b)paramView).setGravity(48);
      }
    }
  }
  
  private int ags(int paramInt)
  {
    AppMethodBeat.i(159795);
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null)
    {
      paramInt = localView.getHeight();
      AppMethodBeat.o(159795);
      return paramInt;
    }
    paramInt = ku(paramInt, agu(paramInt));
    AppMethodBeat.o(159795);
    return paramInt;
  }
  
  private void agt(int paramInt)
  {
    AppMethodBeat.i(159803);
    this.Wk = 1;
    if (this.LAD != null) {
      this.LAD.remove(paramInt);
    }
    fRK();
    fRD();
    fRB();
    if (this.LAZ)
    {
      this.Wk = 3;
      AppMethodBeat.o(159803);
      return;
    }
    this.Wk = 0;
    AppMethodBeat.o(159803);
  }
  
  private int agu(int paramInt)
  {
    AppMethodBeat.i(159816);
    if (paramInt == this.LAy)
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
    int i = this.LBk.get(paramInt);
    if (i != -1)
    {
      AppMethodBeat.o(159816);
      return i;
    }
    localObject = getAdapter();
    i = ((ListAdapter)localObject).getItemViewType(paramInt);
    int j = ((ListAdapter)localObject).getViewTypeCount();
    if (j != this.LAJ.length) {
      this.LAJ = new View[j];
    }
    if (i >= 0) {
      if (this.LAJ[i] == null)
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
        this.LAJ[i] = localObject;
      }
    }
    for (;;)
    {
      i = b(paramInt, (View)localObject, true);
      this.LBk.add(paramInt, i);
      AppMethodBeat.o(159816);
      return i;
      localObject = ((ListAdapter)localObject).getView(paramInt, this.LAJ[i], this);
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
      this.mhp = this.mX;
      this.mhq = this.mY;
    }
    this.mX = ((int)paramMotionEvent.getX());
    this.mY = ((int)paramMotionEvent.getY());
    if (i == 0)
    {
      this.mhp = this.mX;
      this.mhq = this.mY;
    }
    this.mOffsetX = ((int)paramMotionEvent.getRawX() - this.mX);
    this.mOffsetY = ((int)paramMotionEvent.getRawY() - this.mY);
    AppMethodBeat.o(159809);
  }
  
  private int b(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159817);
    if (paramInt == this.LAy)
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
      hk(localView);
      paramInt = localView.getMeasuredHeight();
    }
    AppMethodBeat.o(159817);
    return paramInt;
  }
  
  private int c(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159818);
    paramInt = ku(paramInt, b(paramInt, paramView, paramBoolean));
    AppMethodBeat.o(159818);
    return paramInt;
  }
  
  private void d(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159827);
    this.LBi = true;
    fRJ();
    int i = this.LAv;
    int j = this.LAw;
    boolean bool = fRz();
    if (bool)
    {
      fRG();
      setSelectionFromTop(paramInt, a(paramInt, paramView, i, j) + paramView.getTop() - getPaddingTop());
      layoutChildren();
    }
    if ((bool) || (paramBoolean)) {
      invalidate();
    }
    this.LBi = false;
    AppMethodBeat.o(159827);
  }
  
  private boolean d(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(159806);
    if (this.ndz != null)
    {
      this.LAK.fRL();
      if (paramBoolean) {
        x(this.LAy - getHeaderViewsCount(), paramFloat);
      }
      for (;;)
      {
        if (this.LBg) {
          this.LBh.stopTracking();
        }
        AppMethodBeat.o(159806);
        return true;
        if (this.LBm != null) {
          this.LBm.start();
        } else {
          fRC();
        }
      }
    }
    AppMethodBeat.o(159806);
    return false;
  }
  
  private void fRB()
  {
    this.LAy = -1;
    this.LAv = -1;
    this.LAw = -1;
    this.LAu = -1;
  }
  
  private void fRC()
  {
    AppMethodBeat.i(159802);
    this.Wk = 2;
    if ((this.LAC != null) && (this.LAu >= 0) && (this.LAu < getCount()))
    {
      int i = getHeaderViewsCount();
      this.LAC.ek(this.LAy - i, this.LAu - i);
    }
    fRK();
    fRD();
    fRB();
    fRG();
    if (this.LAZ)
    {
      this.Wk = 3;
      AppMethodBeat.o(159802);
      return;
    }
    this.Wk = 0;
    AppMethodBeat.o(159802);
  }
  
  private void fRD()
  {
    int i = 0;
    AppMethodBeat.i(159804);
    int j = getFirstVisiblePosition();
    if (this.LAy < j)
    {
      View localView = getChildAt(0);
      if (localView != null) {
        i = localView.getTop();
      }
      setSelectionFromTop(j - 1, i - getPaddingTop());
    }
    AppMethodBeat.o(159804);
  }
  
  private void fRE()
  {
    AppMethodBeat.i(159808);
    this.LBc = 0;
    this.LAZ = false;
    if (this.Wk == 3) {
      this.Wk = 0;
    }
    this.LAt = this.LAs;
    this.LBp = false;
    this.LBk.clear();
    AppMethodBeat.o(159808);
  }
  
  private void fRF()
  {
    AppMethodBeat.i(159812);
    int i = getPaddingTop();
    int j = getHeight() - i - getPaddingBottom();
    float f1 = j;
    this.LAQ = (i + this.LAL * f1);
    float f2 = i;
    this.LAP = (f1 * (1.0F - this.LAM) + f2);
    this.LAN = ((int)this.LAQ);
    this.LAO = ((int)this.LAP);
    this.LAR = (this.LAQ - i);
    this.LAS = (i + j - this.LAP);
    AppMethodBeat.o(159812);
  }
  
  private void fRG()
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
  
  private void fRH()
  {
    AppMethodBeat.i(159822);
    if (this.ndz != null)
    {
      hk(this.ndz);
      this.LAG = this.ndz.getMeasuredHeight();
      this.LAH = (this.LAG / 2);
    }
    AppMethodBeat.o(159822);
  }
  
  private void fRI()
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
  
  private void fRJ()
  {
    AppMethodBeat.i(159828);
    if (this.LBa != null)
    {
      this.LAp.set(this.mX, this.mY);
      this.LBa.k(this.LAo);
    }
    int i = this.LAo.x;
    int m = this.LAo.y;
    int j = getPaddingLeft();
    int k;
    if (((this.LAW & 0x1) == 0) && (i > j))
    {
      this.LAo.x = j;
      j = getHeaderViewsCount();
      k = getFooterViewsCount();
      int n = getFirstVisiblePosition();
      int i1 = getLastVisiblePosition();
      i = getPaddingTop();
      if (n < j) {
        i = getChildAt(j - n - 1).getBottom();
      }
      j = i;
      if ((this.LAW & 0x8) == 0)
      {
        j = i;
        if (n <= this.LAy) {
          j = Math.max(getChildAt(this.LAy - n).getTop(), i);
        }
      }
      i = getHeight() - getPaddingBottom();
      if (i1 >= getCount() - k - 1) {
        i = getChildAt(getCount() - k - 1 - n).getBottom();
      }
      k = i;
      if ((this.LAW & 0x4) == 0)
      {
        k = i;
        if (i1 >= this.LAy) {
          k = Math.min(getChildAt(this.LAy - n).getBottom(), i);
        }
      }
      if (m >= j) {
        break label319;
      }
      this.LAo.y = j;
    }
    for (;;)
    {
      this.LAq = (this.LAo.y + this.LAH);
      AppMethodBeat.o(159828);
      return;
      if (((this.LAW & 0x2) != 0) || (i >= j)) {
        break;
      }
      this.LAo.x = j;
      break;
      label319:
      if (this.LAG + m > k) {
        this.LAo.y = (k - this.LAG);
      }
    }
  }
  
  private void fRK()
  {
    AppMethodBeat.i(159829);
    if (this.ndz != null)
    {
      this.ndz.setVisibility(8);
      if (this.LBa != null) {
        this.LBa.hl(this.ndz);
      }
      this.ndz = null;
      invalidate();
    }
    AppMethodBeat.o(159829);
  }
  
  private boolean fRz()
  {
    boolean bool2 = true;
    AppMethodBeat.i(159797);
    int j = getFirstVisiblePosition();
    int i = this.LAv;
    View localView2 = getChildAt(i - j);
    View localView1 = localView2;
    if (localView2 == null)
    {
      i = j + getChildCount() / 2;
      localView1 = getChildAt(i - j);
    }
    int i2 = localView1.getTop();
    int i1 = localView1.getHeight();
    j = kt(i, i2);
    int i3 = getDividerHeight();
    int k;
    int m;
    int n;
    if (this.LAq < j)
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
      i = ags(i1);
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
      i1 = this.LAv;
      i2 = this.LAw;
      float f1 = this.LBe;
      int i4;
      label207:
      float f2;
      if (this.LAx)
      {
        i4 = Math.abs(i - j);
        if (this.LAq < i)
        {
          m = (int)(this.LBd * 0.5F * i4);
          f2 = m;
          j += m;
          if (this.LAq >= j) {
            break label552;
          }
          this.LAv = (k - 1);
          this.LAw = k;
          this.LBe = ((j - this.LAq) * 0.5F / f2);
          label272:
          if (this.LAv >= n) {
            break label613;
          }
          this.LAv = n;
          this.LAw = n;
          k = n;
          label297:
          if ((this.LAv == i1) && (this.LAw == i2) && (Math.abs(this.LBe - f1) <= 0.0F)) {
            break label656;
          }
        }
      }
      label656:
      for (boolean bool1 = true;; bool1 = false)
      {
        if (k != this.LAu)
        {
          this.LAu = k;
          bool1 = bool2;
        }
        for (;;)
        {
          AppMethodBeat.o(159797);
          return bool1;
          i2 -= i + i3;
          m = kt(i1, i2);
          i = m;
          k = i1;
          if (this.LAq >= m) {
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
            i1 = ags(m + 1);
            n = kt(m + 1, i2);
            i = n;
            k = m;
            if (this.LAq < n) {
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
          if (this.LAq >= i - m)
          {
            this.LAv = k;
            this.LAw = (k + 1);
            this.LBe = ((1.0F + (i - this.LAq) / f2) * 0.5F);
            break label272;
          }
          this.LAv = k;
          this.LAw = k;
          break label272;
          label613:
          if (this.LAw < getCount() - i3) {
            break label297;
          }
          k = getCount() - i3 - 1;
          this.LAv = k;
          this.LAw = k;
          break label297;
        }
      }
      label662:
      j = i;
      i = n;
    }
  }
  
  private void hk(View paramView)
  {
    AppMethodBeat.i(159821);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null)
    {
      localObject = new AbsListView.LayoutParams(-1, -2);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int j = ViewGroup.getChildMeasureSpec(this.LAI, getListPaddingLeft() + getListPaddingRight(), ((ViewGroup.LayoutParams)localObject).width);
    if (((ViewGroup.LayoutParams)localObject).height > 0) {}
    for (int i = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(j, i);
      AppMethodBeat.o(159821);
      return;
    }
  }
  
  private int kt(int paramInt1, int paramInt2)
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
    int m = this.LAG - this.LAF;
    int k = agu(paramInt1);
    int n = ags(paramInt1);
    if (this.LAw <= this.LAy) {
      if ((paramInt1 == this.LAw) && (this.LAv != this.LAw)) {
        if (paramInt1 == this.LAy)
        {
          i = paramInt2 + n - this.LAG;
          if (paramInt1 > this.LAy) {
            break label256;
          }
        }
      }
    }
    label256:
    for (paramInt1 = (this.LAG - j - agu(paramInt1 - 1)) / 2 + i;; paramInt1 = (k - j - this.LAG) / 2 + i)
    {
      AppMethodBeat.o(159796);
      return paramInt1;
      i = n - k + paramInt2 - m;
      break;
      i = paramInt2;
      if (paramInt1 <= this.LAw) {
        break;
      }
      i = paramInt2;
      if (paramInt1 > this.LAy) {
        break;
      }
      i = paramInt2 - m;
      break;
      if ((paramInt1 > this.LAy) && (paramInt1 <= this.LAv))
      {
        i = paramInt2 + m;
        break;
      }
      i = paramInt2;
      if (paramInt1 != this.LAw) {
        break;
      }
      i = paramInt2;
      if (this.LAv == this.LAw) {
        break;
      }
      i = paramInt2 + (n - k);
      break;
    }
  }
  
  private int ku(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    int k;
    if ((this.LAx) && (this.LAv != this.LAw))
    {
      i = 1;
      j = this.LAG - this.LAF;
      k = (int)(this.LBe * j);
      if (paramInt1 != this.LAy) {
        break label109;
      }
      if (this.LAy != this.LAv) {
        break label85;
      }
      if (i == 0) {
        break label80;
      }
      i = k + this.LAF;
    }
    label80:
    label85:
    label109:
    do
    {
      return i;
      i = 0;
      break;
      return this.LAG;
      if (this.LAy == this.LAw) {
        return this.LAG - k;
      }
      return this.LAF;
      if (paramInt1 == this.LAv)
      {
        if (i != 0) {
          return paramInt2 + k;
        }
        return paramInt2 + j;
      }
      i = paramInt2;
    } while (paramInt1 != this.LAw);
    return paramInt2 + j - k;
  }
  
  private void x(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(159800);
    if ((this.Wk == 0) || (this.Wk == 4))
    {
      if (this.Wk == 0)
      {
        this.LAy = (getHeaderViewsCount() + paramInt);
        this.LAv = this.LAy;
        this.LAw = this.LAy;
        this.LAu = this.LAy;
        View localView = getChildAt(this.LAy - getFirstVisiblePosition());
        if (localView != null) {
          localView.setVisibility(4);
        }
      }
      this.Wk = 1;
      this.LBo = paramFloat;
      if (this.LAZ) {
        switch (this.LBc)
        {
        }
      }
      while (this.LBl != null)
      {
        this.LBl.start();
        AppMethodBeat.o(159800);
        return;
        super.onTouchEvent(this.LBb);
        continue;
        super.onInterceptTouchEvent(this.LBb);
      }
      agt(paramInt);
    }
    AppMethodBeat.o(159800);
  }
  
  public final boolean a(int paramInt1, View paramView, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159825);
    if ((this.Wk != 0) || (!this.LAZ) || (this.ndz != null) || (paramView == null) || (!this.LAE))
    {
      AppMethodBeat.o(159825);
      return false;
    }
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    paramInt1 = getHeaderViewsCount() + paramInt1;
    this.LAv = paramInt1;
    this.LAw = paramInt1;
    this.LAy = paramInt1;
    this.LAu = paramInt1;
    this.Wk = 4;
    this.LAW = 0;
    this.LAW |= paramInt2;
    this.ndz = paramView;
    fRH();
    this.LAz = paramInt3;
    this.LAA = paramInt4;
    this.LAV = this.mY;
    this.LAo.x = (this.mX - this.LAz);
    this.LAo.y = (this.mY - this.LAA);
    paramView = getChildAt(this.LAy - getFirstVisiblePosition());
    if (paramView != null) {
      paramView.setVisibility(4);
    }
    if (this.LBg)
    {
      paramView = this.LBh;
      paramView.mBuilder.append("<DSLVStates>\n");
      paramView.LBD = 0;
      paramView.LBE = true;
    }
    switch (this.LBc)
    {
    }
    for (;;)
    {
      requestLayout();
      AppMethodBeat.o(159825);
      return true;
      super.onTouchEvent(this.LBb);
      continue;
      super.onInterceptTouchEvent(this.LBb);
    }
  }
  
  public final boolean bY(float paramFloat)
  {
    AppMethodBeat.i(159805);
    this.LBn = true;
    boolean bool = d(true, paramFloat);
    AppMethodBeat.o(159805);
    return bool;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159794);
    super.dispatchDraw(paramCanvas);
    if (this.Wk != 0)
    {
      if (this.LAv != this.LAy) {
        a(this.LAv, paramCanvas);
      }
      if ((this.LAw != this.LAv) && (this.LAw != this.LAy)) {
        a(this.LAw, paramCanvas);
      }
    }
    int k;
    int m;
    int i;
    float f;
    if (this.ndz != null)
    {
      k = this.ndz.getWidth();
      m = this.ndz.getHeight();
      int j = this.LAo.x;
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
      i = (int)(f * (255.0F * this.LAt));
      paramCanvas.save();
      paramCanvas.translate(this.LAo.x, this.LAo.y);
      paramCanvas.clipRect(0, 0, k, m);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, k, m, i, 31);
      this.ndz.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.restore();
      AppMethodBeat.o(159794);
      return;
    }
  }
  
  public final void fRA()
  {
    AppMethodBeat.i(159801);
    if (this.Wk == 4)
    {
      this.LAK.fRL();
      fRK();
      fRB();
      fRG();
      if (this.LAZ)
      {
        this.Wk = 3;
        AppMethodBeat.o(159801);
        return;
      }
      this.Wk = 0;
    }
    AppMethodBeat.o(159801);
  }
  
  public float getFloatAlpha()
  {
    return this.LAt;
  }
  
  public ListAdapter getInputAdapter()
  {
    if (this.LBf == null) {
      return null;
    }
    return this.LBf.GE;
  }
  
  protected void layoutChildren()
  {
    AppMethodBeat.i(159824);
    super.layoutChildren();
    if (this.ndz != null)
    {
      if ((this.ndz.isLayoutRequested()) && (!this.LAr)) {
        fRH();
      }
      this.ndz.layout(0, 0, this.ndz.getMeasuredWidth(), this.ndz.getMeasuredHeight());
      this.LAr = false;
    }
    AppMethodBeat.o(159824);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159798);
    super.onDraw(paramCanvas);
    if (this.LBg)
    {
      paramCanvas = this.LBh;
      if (paramCanvas.LBE)
      {
        paramCanvas.mBuilder.append("<DSLVState>\n");
        int j = paramCanvas.LBr.getChildCount();
        int k = paramCanvas.LBr.getFirstVisiblePosition();
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
          paramCanvas.mBuilder.append(paramCanvas.LBr.getChildAt(i).getTop()).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</Tops>\n");
        paramCanvas.mBuilder.append("    <Bottoms>");
        i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(paramCanvas.LBr.getChildAt(i).getBottom()).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</Bottoms>\n");
        paramCanvas.mBuilder.append("    <FirstExpPos>").append(paramCanvas.LBr.LAv).append("</FirstExpPos>\n");
        paramCanvas.mBuilder.append("    <FirstExpBlankHeight>").append(paramCanvas.LBr.ags(paramCanvas.LBr.LAv) - paramCanvas.LBr.agu(paramCanvas.LBr.LAv)).append("</FirstExpBlankHeight>\n");
        paramCanvas.mBuilder.append("    <SecondExpPos>").append(paramCanvas.LBr.LAw).append("</SecondExpPos>\n");
        paramCanvas.mBuilder.append("    <SecondExpBlankHeight>").append(paramCanvas.LBr.ags(paramCanvas.LBr.LAw) - paramCanvas.LBr.agu(paramCanvas.LBr.LAw)).append("</SecondExpBlankHeight>\n");
        paramCanvas.mBuilder.append("    <SrcPos>").append(paramCanvas.LBr.LAy).append("</SrcPos>\n");
        paramCanvas.mBuilder.append("    <SrcHeight>").append(paramCanvas.LBr.LAG + paramCanvas.LBr.getDividerHeight()).append("</SrcHeight>\n");
        paramCanvas.mBuilder.append("    <ViewHeight>").append(paramCanvas.LBr.getHeight()).append("</ViewHeight>\n");
        paramCanvas.mBuilder.append("    <LastY>").append(paramCanvas.LBr.mhq).append("</LastY>\n");
        paramCanvas.mBuilder.append("    <FloatY>").append(paramCanvas.LBr.LAq).append("</FloatY>\n");
        paramCanvas.mBuilder.append("    <ShuffleEdges>");
        i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(paramCanvas.LBr.kt(k + i, paramCanvas.LBr.getChildAt(i).getTop())).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</ShuffleEdges>\n");
        paramCanvas.mBuilder.append("</DSLVState>\n");
        paramCanvas.LBC += 1;
        if (paramCanvas.LBC > 1000)
        {
          paramCanvas.flush();
          paramCanvas.LBC = 0;
        }
      }
    }
    AppMethodBeat.o(159798);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159810);
    if (!this.LAE)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(159810);
      return bool;
    }
    ak(paramMotionEvent);
    this.LAY = true;
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0)
    {
      if (this.Wk != 0)
      {
        this.LBj = true;
        AppMethodBeat.o(159810);
        return true;
      }
      this.LAZ = true;
    }
    if (this.ndz != null)
    {
      bool = true;
      if ((i == 1) || (i == 3)) {
        this.LAZ = false;
      }
      AppMethodBeat.o(159810);
      return bool;
    }
    if (super.onInterceptTouchEvent(paramMotionEvent)) {
      this.LBp = true;
    }
    for (boolean bool = true;; bool = false) {
      switch (i)
      {
      case 2: 
      default: 
        if (bool) {
          this.LBc = 1;
        }
        break;
      case 1: 
      case 3: 
        fRE();
        break;
        this.LBc = 2;
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159823);
    super.onMeasure(paramInt1, paramInt2);
    if (this.ndz != null)
    {
      if (this.ndz.isLayoutRequested()) {
        fRH();
      }
      this.LAr = true;
    }
    this.LAI = paramInt1;
    AppMethodBeat.o(159823);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159813);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    fRF();
    AppMethodBeat.o(159813);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159807);
    if (this.LBj)
    {
      this.LBj = false;
      AppMethodBeat.o(159807);
      return false;
    }
    if (!this.LAE)
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(159807);
      return bool1;
    }
    boolean bool1 = this.LAY;
    this.LAY = false;
    if (!bool1) {
      ak(paramMotionEvent);
    }
    boolean bool2;
    if (this.Wk == 4)
    {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
      for (;;)
      {
        bool2 = true;
        AppMethodBeat.o(159807);
        return bool2;
        if (this.Wk == 4) {
          fRA();
        }
        fRE();
        continue;
        if (this.Wk == 4)
        {
          this.LBn = false;
          d(false, 0.0F);
        }
        fRE();
        continue;
        int j = (int)paramMotionEvent.getX();
        int i = (int)paramMotionEvent.getY();
        this.LAo.x = (j - this.LAz);
        this.LAo.y = (i - this.LAA);
        fRI();
        j = Math.min(i, this.LAq + this.LAH);
        int k = Math.max(i, this.LAq - this.LAH);
        paramMotionEvent = this.LAK;
        if (paramMotionEvent.Lqa) {}
        for (i = paramMotionEvent.LBA;; i = -1)
        {
          if ((j <= this.mhq) || (j <= this.LAO) || (i == 1)) {
            break label307;
          }
          if (i != -1) {
            this.LAK.fRL();
          }
          this.LAK.agv(1);
          break;
        }
        label307:
        if ((k < this.mhq) && (k < this.LAN) && (i != 0))
        {
          if (i != -1) {
            this.LAK.fRL();
          }
          this.LAK.agv(0);
        }
        else if ((k >= this.LAN) && (j <= this.LAO) && (this.LAK.Lqa))
        {
          this.LAK.fRL();
        }
      }
    }
    if ((this.Wk == 0) && (super.onTouchEvent(paramMotionEvent))) {}
    for (bool1 = true;; bool1 = false) {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 2: 
      default: 
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        this.LBc = 1;
        bool2 = bool1;
        break;
      case 1: 
      case 3: 
        fRE();
        bool2 = bool1;
        break;
      }
    }
  }
  
  public final void removeItem(int paramInt)
  {
    AppMethodBeat.i(159799);
    this.LBn = false;
    x(paramInt, 0.0F);
    AppMethodBeat.o(159799);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(159819);
    if (!this.LBi) {
      super.requestLayout();
    }
    AppMethodBeat.o(159819);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(159792);
    if (paramListAdapter != null)
    {
      this.LBf = new DragSortListView.a(this, paramListAdapter, (byte)0);
      paramListAdapter.registerDataSetObserver(this.mObserver);
      if ((paramListAdapter instanceof h)) {
        setDropListener((h)paramListAdapter);
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
      super.setAdapter(this.LBf);
      AppMethodBeat.o(159792);
      return;
      this.LBf = null;
    }
  }
  
  public void setDragEnabled(boolean paramBoolean)
  {
    this.LAE = paramBoolean;
  }
  
  public void setDragListener(b paramb)
  {
    this.LAB = paramb;
  }
  
  public void setDragScrollProfile(c paramc)
  {
    if (paramc != null) {
      this.LAU = paramc;
    }
  }
  
  public void setDragScrollStart(float paramFloat)
  {
    AppMethodBeat.i(159811);
    if (paramFloat > 0.5F)
    {
      this.LAM = 0.5F;
      if (paramFloat <= 0.5F) {
        break label58;
      }
    }
    label58:
    for (this.LAL = 0.5F;; this.LAL = paramFloat)
    {
      if (getHeight() != 0) {
        fRF();
      }
      AppMethodBeat.o(159811);
      return;
      this.LAM = paramFloat;
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
  
  public void setDropListener(h paramh)
  {
    this.LAC = paramh;
  }
  
  public void setFloatAlpha(float paramFloat)
  {
    this.LAt = paramFloat;
  }
  
  public void setFloatViewManager(i parami)
  {
    this.LBa = parami;
  }
  
  public void setMaxScrollSpeed(float paramFloat)
  {
    this.LAT = paramFloat;
  }
  
  public void setRemoveListener(l paraml)
  {
    this.LAD = paraml;
  }
  
  public static abstract interface b {}
  
  public static abstract interface c
  {
    public abstract float bZ(float paramFloat);
  }
  
  final class d
    implements Runnable
  {
    int LBA;
    private float LBB;
    private boolean LBu;
    private long LBv;
    private long LBw;
    private int LBx;
    private float LBy;
    private long LBz;
    boolean Lqa = false;
    
    d() {}
    
    public final void agv(int paramInt)
    {
      AppMethodBeat.i(159771);
      if (!this.Lqa)
      {
        this.LBu = false;
        this.Lqa = true;
        this.LBz = SystemClock.uptimeMillis();
        this.LBv = this.LBz;
        this.LBA = paramInt;
        DragSortListView.this.post(this);
      }
      AppMethodBeat.o(159771);
    }
    
    public final void fRL()
    {
      AppMethodBeat.i(159772);
      DragSortListView.this.removeCallbacks(this);
      this.Lqa = false;
      AppMethodBeat.o(159772);
    }
    
    public final void run()
    {
      AppMethodBeat.i(159773);
      if (this.LBu)
      {
        this.Lqa = false;
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
      if (this.LBA == 0)
      {
        localView = DragSortListView.this.getChildAt(0);
        if (localView == null)
        {
          this.Lqa = false;
          AppMethodBeat.o(159773);
          return;
        }
        if ((j == 0) && (localView.getTop() == k))
        {
          this.Lqa = false;
          AppMethodBeat.o(159773);
          return;
        }
        this.LBB = DragSortListView.u(DragSortListView.this).bZ((DragSortListView.s(DragSortListView.this) - i2) / DragSortListView.t(DragSortListView.this));
        this.LBw = SystemClock.uptimeMillis();
        this.LBy = ((float)(this.LBw - this.LBv));
        this.LBx = Math.round(this.LBB * this.LBy);
        if (this.LBx < 0) {
          break label496;
        }
        this.LBx = Math.min(n, this.LBx);
        i = j;
      }
      for (;;)
      {
        localView = DragSortListView.this.getChildAt(i - j);
        m = localView.getTop() + this.LBx;
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
        this.LBv = this.LBw;
        DragSortListView.this.post(this);
        AppMethodBeat.o(159773);
        return;
        localView = DragSortListView.this.getChildAt(i - j);
        if (localView == null)
        {
          this.Lqa = false;
          AppMethodBeat.o(159773);
          return;
        }
        if ((i == m - 1) && (localView.getBottom() <= n + k))
        {
          this.Lqa = false;
          AppMethodBeat.o(159773);
          return;
        }
        this.LBB = (-DragSortListView.u(DragSortListView.this).bZ((i1 - DragSortListView.v(DragSortListView.this)) / DragSortListView.w(DragSortListView.this)));
        break;
        label496:
        this.LBx = Math.max(-n, this.LBx);
      }
    }
  }
  
  public static abstract interface e
    extends DragSortListView.b, DragSortListView.h, DragSortListView.l
  {}
  
  final class g
    extends DragSortListView.m
  {
    private int LBF;
    private int LBG;
    private float LBH;
    private float LBI;
    
    private g(int paramInt)
    {
      super(paramInt, (byte)0);
    }
    
    private int fRM()
    {
      AppMethodBeat.i(159778);
      int i = DragSortListView.this.getFirstVisiblePosition();
      int j = (DragSortListView.i(DragSortListView.this) + DragSortListView.this.getDividerHeight()) / 2;
      View localView = DragSortListView.this.getChildAt(this.LBF - i);
      i = -1;
      if (localView != null) {
        if (this.LBF == this.LBG) {
          i = localView.getTop();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(159778);
        return i;
        if (this.LBF < this.LBG)
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
    
    public final void ca(float paramFloat)
    {
      AppMethodBeat.i(159779);
      int i = fRM();
      int j = DragSortListView.this.getPaddingLeft();
      float f1 = DragSortListView.d(DragSortListView.this).y - i;
      float f2 = DragSortListView.d(DragSortListView.this).x - j;
      paramFloat = 1.0F - paramFloat;
      if ((paramFloat < Math.abs(f1 / this.LBH)) || (paramFloat < Math.abs(f2 / this.LBI)))
      {
        DragSortListView.d(DragSortListView.this).y = (i + (int)(this.LBH * paramFloat));
        DragSortListView.d(DragSortListView.this).x = (DragSortListView.this.getPaddingLeft() + (int)(this.LBI * paramFloat));
        DragSortListView.f(DragSortListView.this);
      }
      AppMethodBeat.o(159779);
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(159777);
      this.LBF = DragSortListView.g(DragSortListView.this);
      this.LBG = DragSortListView.h(DragSortListView.this);
      DragSortListView.a(DragSortListView.this, 2);
      this.LBH = (DragSortListView.d(DragSortListView.this).y - fRM());
      this.LBI = (DragSortListView.d(DragSortListView.this).x - DragSortListView.this.getPaddingLeft());
      AppMethodBeat.o(159777);
    }
    
    public final void onStop()
    {
      AppMethodBeat.i(159780);
      DragSortListView.k(DragSortListView.this);
      AppMethodBeat.o(159780);
    }
  }
  
  public static abstract interface h
  {
    public abstract void ek(int paramInt1, int paramInt2);
  }
  
  public static abstract interface i
  {
    public abstract View agw(int paramInt);
    
    public abstract void hl(View paramView);
    
    public abstract void k(Point paramPoint);
  }
  
  final class k
    extends DragSortListView.m
  {
    private float LBL;
    private float LBM;
    private float LBN;
    private int LBO = -1;
    private int LBP = -1;
    private int LBQ;
    private int fUL;
    
    private k(int paramInt)
    {
      super(paramInt, (byte)0);
    }
    
    public final void ca(float paramFloat)
    {
      AppMethodBeat.i(159786);
      paramFloat = 1.0F - paramFloat;
      int j = DragSortListView.this.getFirstVisiblePosition();
      View localView = DragSortListView.this.getChildAt(this.fUL - j);
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
          this.LBL += f2 * f1;
          DragSortListView.d(DragSortListView.this).x = ((int)this.LBL);
          if ((this.LBL >= k) || (this.LBL <= -k)) {
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
        if (this.LBO == -1)
        {
          this.LBO = DragSortListView.b(DragSortListView.this, this.fUL, localView);
          this.LBM = (localView.getHeight() - this.LBO);
        }
        i = Math.max((int)(this.LBM * paramFloat), 1);
        localObject = localView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = (i + this.LBO);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.LBQ != this.fUL)
      {
        localView = DragSortListView.this.getChildAt(this.LBQ - j);
        if (localView != null)
        {
          if (this.LBP == -1)
          {
            this.LBP = DragSortListView.b(DragSortListView.this, this.LBQ, localView);
            this.LBN = (localView.getHeight() - this.LBP);
          }
          i = Math.max((int)(this.LBN * paramFloat), 1);
          localObject = localView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = (i + this.LBP);
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(159786);
    }
    
    public final void onStart()
    {
      int i = -1;
      AppMethodBeat.i(159785);
      this.LBO = -1;
      this.LBP = -1;
      this.fUL = DragSortListView.l(DragSortListView.this);
      this.LBQ = DragSortListView.m(DragSortListView.this);
      DragSortListView.a(DragSortListView.this, 1);
      this.LBL = DragSortListView.d(DragSortListView.this).x;
      if (DragSortListView.n(DragSortListView.this))
      {
        float f = DragSortListView.this.getWidth() * 2.0F;
        if (DragSortListView.o(DragSortListView.this) == 0.0F)
        {
          DragSortListView localDragSortListView = DragSortListView.this;
          if (this.LBL < 0.0F) {}
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
    private float LBR;
    private float LBS;
    private float LBT;
    private float LBU;
    private float LBV;
    private float mAlpha;
    boolean mCanceled;
    protected long mStartTime;
    
    private m(int paramInt)
    {
      AppMethodBeat.i(159788);
      this.mAlpha = 0.5F;
      this.LBR = paramInt;
      float f = 1.0F / (this.mAlpha * 2.0F * (1.0F - this.mAlpha));
      this.LBV = f;
      this.LBS = f;
      this.LBT = (this.mAlpha / ((this.mAlpha - 1.0F) * 2.0F));
      this.LBU = (1.0F / (1.0F - this.mAlpha));
      AppMethodBeat.o(159788);
    }
    
    public void ca(float paramFloat) {}
    
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
      float f1 = (float)(SystemClock.uptimeMillis() - this.mStartTime) / this.LBR;
      if (f1 >= 1.0F)
      {
        ca(1.0F);
        onStop();
        AppMethodBeat.o(159790);
        return;
      }
      if (f1 < this.mAlpha) {
        f1 *= this.LBS * f1;
      }
      for (;;)
      {
        ca(f1);
        DragSortListView.this.post(this);
        AppMethodBeat.o(159790);
        return;
        if (f1 < 1.0F - this.mAlpha)
        {
          float f2 = this.LBT;
          f1 = f1 * this.LBU + f2;
        }
        else
        {
          f1 = 1.0F - (f1 - 1.0F) * (this.LBV * (f1 - 1.0F));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView
 * JD-Core Version:    0.7.0.1
 */