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
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.a;
import java.util.ArrayList;

public class DragSortListView
  extends ListView
{
  private float QWA;
  private float QWB;
  private int QWC;
  private int QWD;
  private float QWE;
  private float QWF;
  private float QWG;
  private float QWH;
  private float QWI;
  private c QWJ;
  private int QWK;
  private int QWL;
  private boolean QWM;
  boolean QWN;
  i QWO;
  private MotionEvent QWP;
  private int QWQ;
  private float QWR;
  private float QWS;
  private a QWT;
  private boolean QWU;
  private DragSortListView.f QWV;
  private boolean QWW;
  private boolean QWX;
  private j QWY;
  private k QWZ;
  private Point QWd;
  private Point QWe;
  private int QWf;
  private boolean QWg;
  private float QWh;
  private float QWi;
  private int QWj;
  private int QWk;
  private int QWl;
  private boolean QWm;
  private int QWn;
  private int QWo;
  private int QWp;
  private b QWq;
  private h QWr;
  private l QWs;
  boolean QWt;
  private int QWu;
  private int QWv;
  private int QWw;
  private int QWx;
  private View[] QWy;
  private d QWz;
  private g QXa;
  private boolean QXb;
  private float QXc;
  boolean QXd;
  private boolean QXe;
  private int Wx;
  private DataSetObserver mObserver;
  private int mOffsetX;
  private int mOffsetY;
  private int mX;
  private int mY;
  private int nrK;
  private int nrL;
  private View ooN;
  
  public DragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159791);
    this.QWd = new Point();
    this.QWe = new Point();
    this.QWg = false;
    this.QWh = 1.0F;
    this.QWi = 1.0F;
    this.QWm = false;
    this.QWt = true;
    this.Wx = 0;
    this.QWu = 1;
    this.QWx = 0;
    this.QWy = new View[1];
    this.QWA = 0.3333333F;
    this.QWB = 0.3333333F;
    this.QWI = 0.5F;
    this.QWJ = new c()
    {
      public final float cD(float paramAnonymousFloat)
      {
        AppMethodBeat.i(159754);
        float f = DragSortListView.a(DragSortListView.this);
        AppMethodBeat.o(159754);
        return f * paramAnonymousFloat;
      }
    };
    this.QWL = 0;
    this.QWM = false;
    this.QWN = false;
    this.QWO = null;
    this.QWQ = 0;
    this.QWR = 0.25F;
    this.QWS = 0.0F;
    this.QWU = false;
    this.QWW = false;
    this.QWX = false;
    this.QWY = new j((byte)0);
    this.QXc = 0.0F;
    this.QXd = false;
    this.QXe = false;
    int j = 150;
    int i = 150;
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, a.a.DragSortListView, 0, 0);
      this.QWu = Math.max(1, paramContext.getDimensionPixelSize(1, 1));
      this.QWU = paramContext.getBoolean(16, false);
      if (this.QWU) {
        this.QWV = new DragSortListView.f(this);
      }
      this.QWh = paramContext.getFloat(8, this.QWh);
      this.QWi = this.QWh;
      this.QWt = paramContext.getBoolean(2, this.QWt);
      this.QWR = Math.max(0.0F, Math.min(1.0F, 1.0F - paramContext.getFloat(14, 0.75F)));
      if (this.QWR <= 0.0F) {
        break label603;
      }
    }
    label603:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.QWm = bool1;
      setDragScrollStart(paramContext.getFloat(4, this.QWA));
      this.QWI = paramContext.getFloat(10, this.QWI);
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
        paramAttributeSet.QVM = bool1;
        paramAttributeSet.QVL = bool2;
        paramAttributeSet.QXK = i3;
        this.QWO = paramAttributeSet;
        setOnTouchListener(paramAttributeSet);
      }
      paramContext.recycle();
      this.QWz = new d();
      if (j > 0) {
        this.QWZ = new k(j, (byte)0);
      }
      if (i > 0) {
        this.QXa = new g(i, (byte)0);
      }
      this.QWP = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
      this.mObserver = new DataSetObserver()
      {
        private void cancel()
        {
          AppMethodBeat.i(159755);
          if (DragSortListView.b(DragSortListView.this) == 4) {
            DragSortListView.this.hcC();
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
    if ((this.Wx == 0) || (this.Wx == 4))
    {
      if (this.Wx == 0)
      {
        this.QWn = (getHeaderViewsCount() + paramInt);
        this.QWk = this.QWn;
        this.QWl = this.QWn;
        this.QWj = this.QWn;
        View localView = getChildAt(this.QWn - getFirstVisiblePosition());
        if (localView != null) {
          localView.setVisibility(4);
        }
      }
      this.Wx = 1;
      this.QXc = paramFloat;
      if (this.QWN) {
        switch (this.QWQ)
        {
        }
      }
      while (this.QWZ != null)
      {
        this.QWZ.start();
        AppMethodBeat.o(159800);
        return;
        super.onTouchEvent(this.QWP);
        continue;
        super.onInterceptTouchEvent(this.QWP);
      }
      apw(paramInt);
    }
    AppMethodBeat.o(159800);
  }
  
  private int a(int paramInt1, View paramView, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159820);
    int i = apx(paramInt1);
    int m = paramView.getHeight();
    int n = lO(paramInt1, i);
    int j;
    if (paramInt1 != this.QWn)
    {
      j = m - i;
      i = n - i;
    }
    for (;;)
    {
      int i1 = this.QWv;
      int k = i1;
      if (this.QWn != this.QWk)
      {
        k = i1;
        if (this.QWn != this.QWl) {
          k = i1 - this.QWu;
        }
      }
      if (paramInt1 <= paramInt2)
      {
        if (paramInt1 <= this.QWk) {
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
          if (paramInt1 <= this.QWk) {
            paramInt1 = j - k + 0;
          } else if (paramInt1 == this.QWl) {
            paramInt1 = m - n + 0;
          } else {
            paramInt1 = j + 0;
          }
        }
        else if (paramInt1 <= this.QWk) {
          paramInt1 = 0 - k;
        } else if (paramInt1 == this.QWl) {
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
        if (paramInt <= this.QWn) {
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
    if ((paramInt != this.QWn) && (paramInt != this.QWk) && (paramInt != this.QWl))
    {
      i = -2;
      if (i != localLayoutParams.height)
      {
        localLayoutParams.height = i;
        paramView.setLayoutParams(localLayoutParams);
      }
      if ((paramInt == this.QWk) || (paramInt == this.QWl))
      {
        if (paramInt >= this.QWn) {
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
      if (paramInt == this.QWn)
      {
        i = j;
        if (this.ooN != null) {
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
      if (paramInt > this.QWn) {
        ((b)paramView).setGravity(48);
      }
    }
  }
  
  private int apv(int paramInt)
  {
    AppMethodBeat.i(159795);
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null)
    {
      paramInt = localView.getHeight();
      AppMethodBeat.o(159795);
      return paramInt;
    }
    paramInt = lO(paramInt, apx(paramInt));
    AppMethodBeat.o(159795);
    return paramInt;
  }
  
  private void apw(int paramInt)
  {
    AppMethodBeat.i(159803);
    this.Wx = 1;
    if (this.QWs != null) {
      this.QWs.remove(paramInt);
    }
    hcM();
    hcF();
    hcD();
    if (this.QWN)
    {
      this.Wx = 3;
      AppMethodBeat.o(159803);
      return;
    }
    this.Wx = 0;
    AppMethodBeat.o(159803);
  }
  
  private int apx(int paramInt)
  {
    AppMethodBeat.i(159816);
    if (paramInt == this.QWn)
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
    int i = this.QWY.get(paramInt);
    if (i != -1)
    {
      AppMethodBeat.o(159816);
      return i;
    }
    localObject = getAdapter();
    i = ((ListAdapter)localObject).getItemViewType(paramInt);
    int j = ((ListAdapter)localObject).getViewTypeCount();
    if (j != this.QWy.length) {
      this.QWy = new View[j];
    }
    if (i >= 0) {
      if (this.QWy[i] == null)
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
        this.QWy[i] = localObject;
      }
    }
    for (;;)
    {
      i = b(paramInt, (View)localObject, true);
      this.QWY.add(paramInt, i);
      AppMethodBeat.o(159816);
      return i;
      localObject = ((ListAdapter)localObject).getView(paramInt, this.QWy[i], this);
      continue;
      localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
    }
  }
  
  private void ay(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159809);
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      this.nrK = this.mX;
      this.nrL = this.mY;
    }
    this.mX = ((int)paramMotionEvent.getX());
    this.mY = ((int)paramMotionEvent.getY());
    if (i == 0)
    {
      this.nrK = this.mX;
      this.nrL = this.mY;
    }
    this.mOffsetX = ((int)paramMotionEvent.getRawX() - this.mX);
    this.mOffsetY = ((int)paramMotionEvent.getRawY() - this.mY);
    AppMethodBeat.o(159809);
  }
  
  private int b(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159817);
    if (paramInt == this.QWn)
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
      hz(localView);
      paramInt = localView.getMeasuredHeight();
    }
    AppMethodBeat.o(159817);
    return paramInt;
  }
  
  private int c(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159818);
    paramInt = lO(paramInt, b(paramInt, paramView, paramBoolean));
    AppMethodBeat.o(159818);
    return paramInt;
  }
  
  private void d(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159827);
    this.QWW = true;
    hcL();
    int i = this.QWk;
    int j = this.QWl;
    boolean bool = hcB();
    if (bool)
    {
      hcI();
      setSelectionFromTop(paramInt, a(paramInt, paramView, i, j) + paramView.getTop() - getPaddingTop());
      layoutChildren();
    }
    if ((bool) || (paramBoolean)) {
      invalidate();
    }
    this.QWW = false;
    AppMethodBeat.o(159827);
  }
  
  private boolean e(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(159806);
    if (this.ooN != null)
    {
      this.QWz.hcN();
      if (paramBoolean) {
        D(this.QWn - getHeaderViewsCount(), paramFloat);
      }
      for (;;)
      {
        if (this.QWU) {
          this.QWV.stopTracking();
        }
        AppMethodBeat.o(159806);
        return true;
        if (this.QXa != null) {
          this.QXa.start();
        } else {
          hcE();
        }
      }
    }
    AppMethodBeat.o(159806);
    return false;
  }
  
  private boolean hcB()
  {
    boolean bool2 = true;
    AppMethodBeat.i(159797);
    int j = getFirstVisiblePosition();
    int i = this.QWk;
    View localView2 = getChildAt(i - j);
    View localView1 = localView2;
    if (localView2 == null)
    {
      i = j + getChildCount() / 2;
      localView1 = getChildAt(i - j);
    }
    int i2 = localView1.getTop();
    int i1 = localView1.getHeight();
    j = lN(i, i2);
    int i3 = getDividerHeight();
    int k;
    int m;
    int n;
    if (this.QWf < j)
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
      i = apv(i1);
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
      i1 = this.QWk;
      i2 = this.QWl;
      float f1 = this.QWS;
      int i4;
      label207:
      float f2;
      if (this.QWm)
      {
        i4 = Math.abs(i - j);
        if (this.QWf < i)
        {
          m = (int)(this.QWR * 0.5F * i4);
          f2 = m;
          j += m;
          if (this.QWf >= j) {
            break label552;
          }
          this.QWk = (k - 1);
          this.QWl = k;
          this.QWS = ((j - this.QWf) * 0.5F / f2);
          label272:
          if (this.QWk >= n) {
            break label613;
          }
          this.QWk = n;
          this.QWl = n;
          k = n;
          label297:
          if ((this.QWk == i1) && (this.QWl == i2) && (Math.abs(this.QWS - f1) <= 0.0F)) {
            break label656;
          }
        }
      }
      label656:
      for (boolean bool1 = true;; bool1 = false)
      {
        if (k != this.QWj)
        {
          this.QWj = k;
          bool1 = bool2;
        }
        for (;;)
        {
          AppMethodBeat.o(159797);
          return bool1;
          i2 -= i + i3;
          m = lN(i1, i2);
          i = m;
          k = i1;
          if (this.QWf >= m) {
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
            i1 = apv(m + 1);
            n = lN(m + 1, i2);
            i = n;
            k = m;
            if (this.QWf < n) {
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
          if (this.QWf >= i - m)
          {
            this.QWk = k;
            this.QWl = (k + 1);
            this.QWS = ((1.0F + (i - this.QWf) / f2) * 0.5F);
            break label272;
          }
          this.QWk = k;
          this.QWl = k;
          break label272;
          label613:
          if (this.QWl < getCount() - i3) {
            break label297;
          }
          k = getCount() - i3 - 1;
          this.QWk = k;
          this.QWl = k;
          break label297;
        }
      }
      label662:
      j = i;
      i = n;
    }
  }
  
  private void hcD()
  {
    this.QWn = -1;
    this.QWk = -1;
    this.QWl = -1;
    this.QWj = -1;
  }
  
  private void hcE()
  {
    AppMethodBeat.i(159802);
    this.Wx = 2;
    if ((this.QWr != null) && (this.QWj >= 0) && (this.QWj < getCount()))
    {
      int i = getHeaderViewsCount();
      this.QWr.ey(this.QWn - i, this.QWj - i);
    }
    hcM();
    hcF();
    hcD();
    hcI();
    if (this.QWN)
    {
      this.Wx = 3;
      AppMethodBeat.o(159802);
      return;
    }
    this.Wx = 0;
    AppMethodBeat.o(159802);
  }
  
  private void hcF()
  {
    int i = 0;
    AppMethodBeat.i(159804);
    int j = getFirstVisiblePosition();
    if (this.QWn < j)
    {
      View localView = getChildAt(0);
      if (localView != null) {
        i = localView.getTop();
      }
      setSelectionFromTop(j - 1, i - getPaddingTop());
    }
    AppMethodBeat.o(159804);
  }
  
  private void hcG()
  {
    AppMethodBeat.i(159808);
    this.QWQ = 0;
    this.QWN = false;
    if (this.Wx == 3) {
      this.Wx = 0;
    }
    this.QWi = this.QWh;
    this.QXd = false;
    this.QWY.clear();
    AppMethodBeat.o(159808);
  }
  
  private void hcH()
  {
    AppMethodBeat.i(159812);
    int i = getPaddingTop();
    int j = getHeight() - i - getPaddingBottom();
    float f1 = j;
    this.QWF = (i + this.QWA * f1);
    float f2 = i;
    this.QWE = (f1 * (1.0F - this.QWB) + f2);
    this.QWC = ((int)this.QWF);
    this.QWD = ((int)this.QWE);
    this.QWG = (this.QWF - i);
    this.QWH = (i + j - this.QWE);
    AppMethodBeat.o(159812);
  }
  
  private void hcI()
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
  
  private void hcJ()
  {
    AppMethodBeat.i(159822);
    if (this.ooN != null)
    {
      hz(this.ooN);
      this.QWv = this.ooN.getMeasuredHeight();
      this.QWw = (this.QWv / 2);
    }
    AppMethodBeat.o(159822);
  }
  
  private void hcK()
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
  
  private void hcL()
  {
    AppMethodBeat.i(159828);
    if (this.QWO != null)
    {
      this.QWe.set(this.mX, this.mY);
      this.QWO.n(this.QWd);
    }
    int i = this.QWd.x;
    int m = this.QWd.y;
    int j = getPaddingLeft();
    int k;
    if (((this.QWL & 0x1) == 0) && (i > j))
    {
      this.QWd.x = j;
      j = getHeaderViewsCount();
      k = getFooterViewsCount();
      int n = getFirstVisiblePosition();
      int i1 = getLastVisiblePosition();
      i = getPaddingTop();
      if (n < j) {
        i = getChildAt(j - n - 1).getBottom();
      }
      j = i;
      if ((this.QWL & 0x8) == 0)
      {
        j = i;
        if (n <= this.QWn) {
          j = Math.max(getChildAt(this.QWn - n).getTop(), i);
        }
      }
      i = getHeight() - getPaddingBottom();
      if (i1 >= getCount() - k - 1) {
        i = getChildAt(getCount() - k - 1 - n).getBottom();
      }
      k = i;
      if ((this.QWL & 0x4) == 0)
      {
        k = i;
        if (i1 >= this.QWn) {
          k = Math.min(getChildAt(this.QWn - n).getBottom(), i);
        }
      }
      if (m >= j) {
        break label319;
      }
      this.QWd.y = j;
    }
    for (;;)
    {
      this.QWf = (this.QWd.y + this.QWw);
      AppMethodBeat.o(159828);
      return;
      if (((this.QWL & 0x2) != 0) || (i >= j)) {
        break;
      }
      this.QWd.x = j;
      break;
      label319:
      if (this.QWv + m > k) {
        this.QWd.y = (k - this.QWv);
      }
    }
  }
  
  private void hcM()
  {
    AppMethodBeat.i(159829);
    if (this.ooN != null)
    {
      this.ooN.setVisibility(8);
      if (this.QWO != null) {
        this.QWO.hA(this.ooN);
      }
      this.ooN = null;
      invalidate();
    }
    AppMethodBeat.o(159829);
  }
  
  private void hz(View paramView)
  {
    AppMethodBeat.i(159821);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null)
    {
      localObject = new AbsListView.LayoutParams(-1, -2);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int j = ViewGroup.getChildMeasureSpec(this.QWx, getListPaddingLeft() + getListPaddingRight(), ((ViewGroup.LayoutParams)localObject).width);
    if (((ViewGroup.LayoutParams)localObject).height > 0) {}
    for (int i = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(j, i);
      AppMethodBeat.o(159821);
      return;
    }
  }
  
  private int lN(int paramInt1, int paramInt2)
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
    int m = this.QWv - this.QWu;
    int k = apx(paramInt1);
    int n = apv(paramInt1);
    if (this.QWl <= this.QWn) {
      if ((paramInt1 == this.QWl) && (this.QWk != this.QWl)) {
        if (paramInt1 == this.QWn)
        {
          i = paramInt2 + n - this.QWv;
          if (paramInt1 > this.QWn) {
            break label256;
          }
        }
      }
    }
    label256:
    for (paramInt1 = (this.QWv - j - apx(paramInt1 - 1)) / 2 + i;; paramInt1 = (k - j - this.QWv) / 2 + i)
    {
      AppMethodBeat.o(159796);
      return paramInt1;
      i = n - k + paramInt2 - m;
      break;
      i = paramInt2;
      if (paramInt1 <= this.QWl) {
        break;
      }
      i = paramInt2;
      if (paramInt1 > this.QWn) {
        break;
      }
      i = paramInt2 - m;
      break;
      if ((paramInt1 > this.QWn) && (paramInt1 <= this.QWk))
      {
        i = paramInt2 + m;
        break;
      }
      i = paramInt2;
      if (paramInt1 != this.QWl) {
        break;
      }
      i = paramInt2;
      if (this.QWk == this.QWl) {
        break;
      }
      i = paramInt2 + (n - k);
      break;
    }
  }
  
  private int lO(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    int k;
    if ((this.QWm) && (this.QWk != this.QWl))
    {
      i = 1;
      j = this.QWv - this.QWu;
      k = (int)(this.QWS * j);
      if (paramInt1 != this.QWn) {
        break label109;
      }
      if (this.QWn != this.QWk) {
        break label85;
      }
      if (i == 0) {
        break label80;
      }
      i = k + this.QWu;
    }
    label80:
    label85:
    label109:
    do
    {
      return i;
      i = 0;
      break;
      return this.QWv;
      if (this.QWn == this.QWl) {
        return this.QWv - k;
      }
      return this.QWu;
      if (paramInt1 == this.QWk)
      {
        if (i != 0) {
          return paramInt2 + k;
        }
        return paramInt2 + j;
      }
      i = paramInt2;
    } while (paramInt1 != this.QWl);
    return paramInt2 + j - k;
  }
  
  public final boolean a(int paramInt1, View paramView, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159825);
    if ((this.Wx != 0) || (!this.QWN) || (this.ooN != null) || (paramView == null) || (!this.QWt))
    {
      AppMethodBeat.o(159825);
      return false;
    }
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    paramInt1 = getHeaderViewsCount() + paramInt1;
    this.QWk = paramInt1;
    this.QWl = paramInt1;
    this.QWn = paramInt1;
    this.QWj = paramInt1;
    this.Wx = 4;
    this.QWL = 0;
    this.QWL |= paramInt2;
    this.ooN = paramView;
    hcJ();
    this.QWo = paramInt3;
    this.QWp = paramInt4;
    this.QWK = this.mY;
    this.QWd.x = (this.mX - this.QWo);
    this.QWd.y = (this.mY - this.QWp);
    paramView = getChildAt(this.QWn - getFirstVisiblePosition());
    if (paramView != null) {
      paramView.setVisibility(4);
    }
    if (this.QWU)
    {
      paramView = this.QWV;
      paramView.mBuilder.append("<DSLVStates>\n");
      paramView.QXq = 0;
      paramView.QXr = true;
    }
    switch (this.QWQ)
    {
    }
    for (;;)
    {
      requestLayout();
      AppMethodBeat.o(159825);
      return true;
      super.onTouchEvent(this.QWP);
      continue;
      super.onInterceptTouchEvent(this.QWP);
    }
  }
  
  public final boolean cC(float paramFloat)
  {
    AppMethodBeat.i(159805);
    this.QXb = true;
    boolean bool = e(true, paramFloat);
    AppMethodBeat.o(159805);
    return bool;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159794);
    super.dispatchDraw(paramCanvas);
    if (this.Wx != 0)
    {
      if (this.QWk != this.QWn) {
        a(this.QWk, paramCanvas);
      }
      if ((this.QWl != this.QWk) && (this.QWl != this.QWn)) {
        a(this.QWl, paramCanvas);
      }
    }
    int k;
    int m;
    int i;
    float f;
    if (this.ooN != null)
    {
      k = this.ooN.getWidth();
      m = this.ooN.getHeight();
      int j = this.QWd.x;
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
      i = (int)(f * (255.0F * this.QWi));
      paramCanvas.save();
      paramCanvas.translate(this.QWd.x, this.QWd.y);
      paramCanvas.clipRect(0, 0, k, m);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, k, m, i, 31);
      this.ooN.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.restore();
      AppMethodBeat.o(159794);
      return;
    }
  }
  
  public float getFloatAlpha()
  {
    return this.QWi;
  }
  
  public ListAdapter getInputAdapter()
  {
    if (this.QWT == null) {
      return null;
    }
    return this.QWT.GO;
  }
  
  public final void hcC()
  {
    AppMethodBeat.i(159801);
    if (this.Wx == 4)
    {
      this.QWz.hcN();
      hcM();
      hcD();
      hcI();
      if (this.QWN)
      {
        this.Wx = 3;
        AppMethodBeat.o(159801);
        return;
      }
      this.Wx = 0;
    }
    AppMethodBeat.o(159801);
  }
  
  protected void layoutChildren()
  {
    AppMethodBeat.i(159824);
    super.layoutChildren();
    if (this.ooN != null)
    {
      if ((this.ooN.isLayoutRequested()) && (!this.QWg)) {
        hcJ();
      }
      this.ooN.layout(0, 0, this.ooN.getMeasuredWidth(), this.ooN.getMeasuredHeight());
      this.QWg = false;
    }
    AppMethodBeat.o(159824);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159798);
    super.onDraw(paramCanvas);
    if (this.QWU)
    {
      paramCanvas = this.QWV;
      if (paramCanvas.QXr)
      {
        paramCanvas.mBuilder.append("<DSLVState>\n");
        int j = paramCanvas.QXf.getChildCount();
        int k = paramCanvas.QXf.getFirstVisiblePosition();
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
          paramCanvas.mBuilder.append(paramCanvas.QXf.getChildAt(i).getTop()).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</Tops>\n");
        paramCanvas.mBuilder.append("    <Bottoms>");
        i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(paramCanvas.QXf.getChildAt(i).getBottom()).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</Bottoms>\n");
        paramCanvas.mBuilder.append("    <FirstExpPos>").append(paramCanvas.QXf.QWk).append("</FirstExpPos>\n");
        paramCanvas.mBuilder.append("    <FirstExpBlankHeight>").append(paramCanvas.QXf.apv(paramCanvas.QXf.QWk) - paramCanvas.QXf.apx(paramCanvas.QXf.QWk)).append("</FirstExpBlankHeight>\n");
        paramCanvas.mBuilder.append("    <SecondExpPos>").append(paramCanvas.QXf.QWl).append("</SecondExpPos>\n");
        paramCanvas.mBuilder.append("    <SecondExpBlankHeight>").append(paramCanvas.QXf.apv(paramCanvas.QXf.QWl) - paramCanvas.QXf.apx(paramCanvas.QXf.QWl)).append("</SecondExpBlankHeight>\n");
        paramCanvas.mBuilder.append("    <SrcPos>").append(paramCanvas.QXf.QWn).append("</SrcPos>\n");
        paramCanvas.mBuilder.append("    <SrcHeight>").append(paramCanvas.QXf.QWv + paramCanvas.QXf.getDividerHeight()).append("</SrcHeight>\n");
        paramCanvas.mBuilder.append("    <ViewHeight>").append(paramCanvas.QXf.getHeight()).append("</ViewHeight>\n");
        paramCanvas.mBuilder.append("    <LastY>").append(paramCanvas.QXf.nrL).append("</LastY>\n");
        paramCanvas.mBuilder.append("    <FloatY>").append(paramCanvas.QXf.QWf).append("</FloatY>\n");
        paramCanvas.mBuilder.append("    <ShuffleEdges>");
        i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(paramCanvas.QXf.lN(k + i, paramCanvas.QXf.getChildAt(i).getTop())).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</ShuffleEdges>\n");
        paramCanvas.mBuilder.append("</DSLVState>\n");
        paramCanvas.QXp += 1;
        if (paramCanvas.QXp > 1000)
        {
          paramCanvas.flush();
          paramCanvas.QXp = 0;
        }
      }
    }
    AppMethodBeat.o(159798);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159810);
    if (!this.QWt)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(159810);
      return bool;
    }
    ay(paramMotionEvent);
    this.QWM = true;
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0)
    {
      if (this.Wx != 0)
      {
        this.QWX = true;
        AppMethodBeat.o(159810);
        return true;
      }
      this.QWN = true;
    }
    if (this.ooN != null)
    {
      bool = true;
      if ((i == 1) || (i == 3)) {
        this.QWN = false;
      }
      AppMethodBeat.o(159810);
      return bool;
    }
    if (super.onInterceptTouchEvent(paramMotionEvent)) {
      this.QXd = true;
    }
    for (boolean bool = true;; bool = false) {
      switch (i)
      {
      case 2: 
      default: 
        if (bool) {
          this.QWQ = 1;
        }
        break;
      case 1: 
      case 3: 
        hcG();
        break;
        this.QWQ = 2;
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159823);
    super.onMeasure(paramInt1, paramInt2);
    if (this.ooN != null)
    {
      if (this.ooN.isLayoutRequested()) {
        hcJ();
      }
      this.QWg = true;
    }
    this.QWx = paramInt1;
    AppMethodBeat.o(159823);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159813);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    hcH();
    AppMethodBeat.o(159813);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159807);
    if (this.QWX)
    {
      this.QWX = false;
      AppMethodBeat.o(159807);
      return false;
    }
    if (!this.QWt)
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(159807);
      return bool1;
    }
    boolean bool1 = this.QWM;
    this.QWM = false;
    if (!bool1) {
      ay(paramMotionEvent);
    }
    boolean bool2;
    if (this.Wx == 4)
    {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
      for (;;)
      {
        bool2 = true;
        AppMethodBeat.o(159807);
        return bool2;
        if (this.Wx == 4) {
          hcC();
        }
        hcG();
        continue;
        if (this.Wx == 4)
        {
          this.QXb = false;
          e(false, 0.0F);
        }
        hcG();
        continue;
        int j = (int)paramMotionEvent.getX();
        int i = (int)paramMotionEvent.getY();
        this.QWd.x = (j - this.QWo);
        this.QWd.y = (i - this.QWp);
        hcK();
        j = Math.min(i, this.QWf + this.QWw);
        int k = Math.max(i, this.QWf - this.QWw);
        paramMotionEvent = this.QWz;
        if (paramMotionEvent.hfx) {}
        for (i = paramMotionEvent.QXn;; i = -1)
        {
          if ((j <= this.nrL) || (j <= this.QWD) || (i == 1)) {
            break label307;
          }
          if (i != -1) {
            this.QWz.hcN();
          }
          this.QWz.apy(1);
          break;
        }
        label307:
        if ((k < this.nrL) && (k < this.QWC) && (i != 0))
        {
          if (i != -1) {
            this.QWz.hcN();
          }
          this.QWz.apy(0);
        }
        else if ((k >= this.QWC) && (j <= this.QWD) && (this.QWz.hfx))
        {
          this.QWz.hcN();
        }
      }
    }
    if ((this.Wx == 0) && (super.onTouchEvent(paramMotionEvent))) {}
    for (bool1 = true;; bool1 = false) {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 2: 
      default: 
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        this.QWQ = 1;
        bool2 = bool1;
        break;
      case 1: 
      case 3: 
        hcG();
        bool2 = bool1;
        break;
      }
    }
  }
  
  public final void removeItem(int paramInt)
  {
    AppMethodBeat.i(159799);
    this.QXb = false;
    D(paramInt, 0.0F);
    AppMethodBeat.o(159799);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(159819);
    if (!this.QWW) {
      super.requestLayout();
    }
    AppMethodBeat.o(159819);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(159792);
    if (paramListAdapter != null)
    {
      this.QWT = new a(paramListAdapter, (byte)0);
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
      super.setAdapter(this.QWT);
      AppMethodBeat.o(159792);
      return;
      this.QWT = null;
    }
  }
  
  public void setDragEnabled(boolean paramBoolean)
  {
    this.QWt = paramBoolean;
  }
  
  public void setDragListener(b paramb)
  {
    this.QWq = paramb;
  }
  
  public void setDragScrollProfile(c paramc)
  {
    if (paramc != null) {
      this.QWJ = paramc;
    }
  }
  
  public void setDragScrollStart(float paramFloat)
  {
    AppMethodBeat.i(159811);
    if (paramFloat > 0.5F)
    {
      this.QWB = 0.5F;
      if (paramFloat <= 0.5F) {
        break label58;
      }
    }
    label58:
    for (this.QWA = 0.5F;; this.QWA = paramFloat)
    {
      if (getHeight() != 0) {
        hcH();
      }
      AppMethodBeat.o(159811);
      return;
      this.QWB = paramFloat;
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
    this.QWr = paramh;
  }
  
  public void setFloatAlpha(float paramFloat)
  {
    this.QWi = paramFloat;
  }
  
  public void setFloatViewManager(i parami)
  {
    this.QWO = parami;
  }
  
  public void setMaxScrollSpeed(float paramFloat)
  {
    this.QWI = paramFloat;
  }
  
  public void setRemoveListener(l paraml)
  {
    this.QWs = paraml;
  }
  
  final class a
    extends BaseAdapter
  {
    ListAdapter GO;
    
    private a(ListAdapter paramListAdapter)
    {
      AppMethodBeat.i(159760);
      this.GO = paramListAdapter;
      this.GO.registerDataSetObserver(new DataSetObserver()
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
      boolean bool = this.GO.areAllItemsEnabled();
      AppMethodBeat.o(159764);
      return bool;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(159763);
      int i = this.GO.getCount();
      AppMethodBeat.o(159763);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(159762);
      Object localObject = this.GO.getItem(paramInt);
      AppMethodBeat.o(159762);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(159761);
      long l = this.GO.getItemId(paramInt);
      AppMethodBeat.o(159761);
      return l;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(159766);
      paramInt = this.GO.getItemViewType(paramInt);
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
        View localView2 = this.GO.getView(paramInt, localView1, DragSortListView.this);
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
      paramViewGroup = this.GO.getView(paramInt, null, DragSortListView.this);
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
      int i = this.GO.getViewTypeCount();
      AppMethodBeat.o(159767);
      return i;
    }
    
    public final boolean hasStableIds()
    {
      AppMethodBeat.i(159768);
      boolean bool = this.GO.hasStableIds();
      AppMethodBeat.o(159768);
      return bool;
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(159769);
      boolean bool = this.GO.isEmpty();
      AppMethodBeat.o(159769);
      return bool;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(159765);
      boolean bool = this.GO.isEnabled(paramInt);
      AppMethodBeat.o(159765);
      return bool;
    }
  }
  
  public static abstract interface b {}
  
  public static abstract interface c
  {
    public abstract float cD(float paramFloat);
  }
  
  final class d
    implements Runnable
  {
    private long QXi;
    private long QXj;
    private int QXk;
    private float QXl;
    private long QXm;
    int QXn;
    private float QXo;
    boolean hfx = false;
    private boolean mAbort;
    
    d() {}
    
    public final void apy(int paramInt)
    {
      AppMethodBeat.i(159771);
      if (!this.hfx)
      {
        this.mAbort = false;
        this.hfx = true;
        this.QXm = SystemClock.uptimeMillis();
        this.QXi = this.QXm;
        this.QXn = paramInt;
        DragSortListView.this.post(this);
      }
      AppMethodBeat.o(159771);
    }
    
    public final void hcN()
    {
      AppMethodBeat.i(159772);
      DragSortListView.this.removeCallbacks(this);
      this.hfx = false;
      AppMethodBeat.o(159772);
    }
    
    public final void run()
    {
      AppMethodBeat.i(159773);
      if (this.mAbort)
      {
        this.hfx = false;
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
      if (this.QXn == 0)
      {
        localView = DragSortListView.this.getChildAt(0);
        if (localView == null)
        {
          this.hfx = false;
          AppMethodBeat.o(159773);
          return;
        }
        if ((j == 0) && (localView.getTop() == k))
        {
          this.hfx = false;
          AppMethodBeat.o(159773);
          return;
        }
        this.QXo = DragSortListView.u(DragSortListView.this).cD((DragSortListView.s(DragSortListView.this) - i2) / DragSortListView.t(DragSortListView.this));
        this.QXj = SystemClock.uptimeMillis();
        this.QXl = ((float)(this.QXj - this.QXi));
        this.QXk = Math.round(this.QXo * this.QXl);
        if (this.QXk < 0) {
          break label496;
        }
        this.QXk = Math.min(n, this.QXk);
        i = j;
      }
      for (;;)
      {
        localView = DragSortListView.this.getChildAt(i - j);
        m = localView.getTop() + this.QXk;
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
        this.QXi = this.QXj;
        DragSortListView.this.post(this);
        AppMethodBeat.o(159773);
        return;
        localView = DragSortListView.this.getChildAt(i - j);
        if (localView == null)
        {
          this.hfx = false;
          AppMethodBeat.o(159773);
          return;
        }
        if ((i == m - 1) && (localView.getBottom() <= n + k))
        {
          this.hfx = false;
          AppMethodBeat.o(159773);
          return;
        }
        this.QXo = (-DragSortListView.u(DragSortListView.this).cD((i1 - DragSortListView.v(DragSortListView.this)) / DragSortListView.w(DragSortListView.this)));
        break;
        label496:
        this.QXk = Math.max(-n, this.QXk);
      }
    }
  }
  
  public static abstract interface e
    extends DragSortListView.b, DragSortListView.h, DragSortListView.l
  {}
  
  final class g
    extends DragSortListView.m
  {
    private int QXs;
    private int QXt;
    private float QXu;
    private float QXv;
    
    private g(int paramInt)
    {
      super(0.5F, paramInt, (byte)0);
    }
    
    private int hcO()
    {
      AppMethodBeat.i(159778);
      int i = DragSortListView.this.getFirstVisiblePosition();
      int j = (DragSortListView.i(DragSortListView.this) + DragSortListView.this.getDividerHeight()) / 2;
      View localView = DragSortListView.this.getChildAt(this.QXs - i);
      i = -1;
      if (localView != null) {
        if (this.QXs == this.QXt) {
          i = localView.getTop();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(159778);
        return i;
        if (this.QXs < this.QXt)
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
    
    public final void cE(float paramFloat)
    {
      AppMethodBeat.i(159779);
      int i = hcO();
      int j = DragSortListView.this.getPaddingLeft();
      float f1 = DragSortListView.d(DragSortListView.this).y - i;
      float f2 = DragSortListView.d(DragSortListView.this).x - j;
      paramFloat = 1.0F - paramFloat;
      if ((paramFloat < Math.abs(f1 / this.QXu)) || (paramFloat < Math.abs(f2 / this.QXv)))
      {
        DragSortListView.d(DragSortListView.this).y = (i + (int)(this.QXu * paramFloat));
        DragSortListView.d(DragSortListView.this).x = (DragSortListView.this.getPaddingLeft() + (int)(this.QXv * paramFloat));
        DragSortListView.f(DragSortListView.this);
      }
      AppMethodBeat.o(159779);
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(159777);
      this.QXs = DragSortListView.g(DragSortListView.this);
      this.QXt = DragSortListView.h(DragSortListView.this);
      DragSortListView.a(DragSortListView.this, 2);
      this.QXu = (DragSortListView.d(DragSortListView.this).y - hcO());
      this.QXv = (DragSortListView.d(DragSortListView.this).x - DragSortListView.this.getPaddingLeft());
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
    public abstract void ey(int paramInt1, int paramInt2);
  }
  
  public static abstract interface i
  {
    public abstract View apz(int paramInt);
    
    public abstract void hA(View paramView);
    
    public abstract void n(Point paramPoint);
  }
  
  final class j
  {
    private SparseIntArray QXw;
    private ArrayList<Integer> QXx;
    private int mMaxSize;
    
    private j()
    {
      AppMethodBeat.i(159781);
      this.QXw = new SparseIntArray(3);
      this.QXx = new ArrayList(3);
      this.mMaxSize = 3;
      AppMethodBeat.o(159781);
    }
    
    public final void add(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(159782);
      int i = this.QXw.get(paramInt1, -1);
      if (i != paramInt2)
      {
        if (i != -1) {
          break label87;
        }
        if (this.QXw.size() == this.mMaxSize) {
          this.QXw.delete(((Integer)this.QXx.remove(0)).intValue());
        }
      }
      for (;;)
      {
        this.QXw.put(paramInt1, paramInt2);
        this.QXx.add(Integer.valueOf(paramInt1));
        AppMethodBeat.o(159782);
        return;
        label87:
        this.QXx.remove(Integer.valueOf(paramInt1));
      }
    }
    
    public final void clear()
    {
      AppMethodBeat.i(159784);
      this.QXw.clear();
      this.QXx.clear();
      AppMethodBeat.o(159784);
    }
    
    public final int get(int paramInt)
    {
      AppMethodBeat.i(159783);
      paramInt = this.QXw.get(paramInt, -1);
      AppMethodBeat.o(159783);
      return paramInt;
    }
  }
  
  final class k
    extends DragSortListView.m
  {
    private float QXA;
    private int QXB = -1;
    private int QXC = -1;
    private int QXD;
    private float QXy;
    private float QXz;
    private int gzS;
    
    private k(int paramInt)
    {
      super(0.5F, paramInt, (byte)0);
    }
    
    public final void cE(float paramFloat)
    {
      AppMethodBeat.i(159786);
      paramFloat = 1.0F - paramFloat;
      int j = DragSortListView.this.getFirstVisiblePosition();
      View localView = DragSortListView.this.getChildAt(this.gzS - j);
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
          this.QXy += f2 * f1;
          DragSortListView.d(DragSortListView.this).x = ((int)this.QXy);
          if ((this.QXy >= k) || (this.QXy <= -k)) {
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
        if (this.QXB == -1)
        {
          this.QXB = DragSortListView.b(DragSortListView.this, this.gzS, localView);
          this.QXz = (localView.getHeight() - this.QXB);
        }
        i = Math.max((int)(this.QXz * paramFloat), 1);
        localObject = localView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = (i + this.QXB);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.QXD != this.gzS)
      {
        localView = DragSortListView.this.getChildAt(this.QXD - j);
        if (localView != null)
        {
          if (this.QXC == -1)
          {
            this.QXC = DragSortListView.b(DragSortListView.this, this.QXD, localView);
            this.QXA = (localView.getHeight() - this.QXC);
          }
          i = Math.max((int)(this.QXA * paramFloat), 1);
          localObject = localView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = (i + this.QXC);
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(159786);
    }
    
    public final void onStart()
    {
      int i = -1;
      AppMethodBeat.i(159785);
      this.QXB = -1;
      this.QXC = -1;
      this.gzS = DragSortListView.l(DragSortListView.this);
      this.QXD = DragSortListView.m(DragSortListView.this);
      DragSortListView.a(DragSortListView.this, 1);
      this.QXy = DragSortListView.d(DragSortListView.this).x;
      if (DragSortListView.n(DragSortListView.this))
      {
        float f = DragSortListView.this.getWidth() * 2.0F;
        if (DragSortListView.o(DragSortListView.this) == 0.0F)
        {
          DragSortListView localDragSortListView = DragSortListView.this;
          if (this.QXy < 0.0F) {}
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
    private float QXE;
    private float QXF;
    private float QXG;
    private float QXH;
    private float QXI;
    private float mAlpha;
    boolean mCanceled;
    protected long mStartTime;
    
    private m(float paramFloat, int paramInt)
    {
      AppMethodBeat.i(198542);
      this.mAlpha = paramFloat;
      this.QXE = paramInt;
      paramFloat = 1.0F / (this.mAlpha * 2.0F * (1.0F - this.mAlpha));
      this.QXI = paramFloat;
      this.QXF = paramFloat;
      this.QXG = (this.mAlpha / ((this.mAlpha - 1.0F) * 2.0F));
      this.QXH = (1.0F / (1.0F - this.mAlpha));
      AppMethodBeat.o(198542);
    }
    
    public void cE(float paramFloat) {}
    
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
      float f1 = (float)(SystemClock.uptimeMillis() - this.mStartTime) / this.QXE;
      if (f1 >= 1.0F)
      {
        cE(1.0F);
        onStop();
        AppMethodBeat.o(159790);
        return;
      }
      if (f1 < this.mAlpha) {
        f1 *= this.QXF * f1;
      }
      for (;;)
      {
        cE(f1);
        DragSortListView.this.post(this);
        AppMethodBeat.o(159790);
        return;
        if (f1 < 1.0F - this.mAlpha)
        {
          float f2 = this.QXG;
          f1 = f1 * this.QXH + f2;
        }
        else
        {
          f1 = 1.0F - (f1 - 1.0F) * (this.QXI * (f1 - 1.0F));
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