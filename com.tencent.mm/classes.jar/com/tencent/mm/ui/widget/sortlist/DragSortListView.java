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
import com.tencent.mm.cl.a.a;

public class DragSortListView
  extends ListView
{
  private int JmA;
  private int JmB;
  private int JmC;
  private b JmD;
  private DragSortListView.h JmE;
  private l JmF;
  boolean JmG;
  private int JmH;
  private int JmI;
  private int JmJ;
  private int JmK;
  private View[] JmL;
  private d JmM;
  private float JmN;
  private float JmO;
  private int JmP;
  private int JmQ;
  private float JmR;
  private float JmS;
  private float JmT;
  private float JmU;
  private float JmV;
  private c JmW;
  private int JmX;
  private int JmY;
  private boolean JmZ;
  private Point Jmq;
  private Point Jmr;
  private int Jms;
  private boolean Jmt;
  private float Jmu;
  private float Jmv;
  private int Jmw;
  private int Jmx;
  private int Jmy;
  private boolean Jmz;
  boolean Jna;
  i Jnb;
  private MotionEvent Jnc;
  private int Jnd;
  private float Jne;
  private float Jnf;
  private a Jng;
  private boolean Jnh;
  private DragSortListView.f Jni;
  private boolean Jnj;
  private boolean Jnk;
  private DragSortListView.j Jnl;
  private k Jnm;
  private g Jnn;
  private boolean Jno;
  private float Jnp;
  boolean Jnq;
  private boolean Jnr;
  private int Uu;
  private int lDu;
  private int lDv;
  private DataSetObserver mObserver;
  private int mOffsetX;
  private int mOffsetY;
  private int mX;
  private int mY;
  private View mxK;
  
  public DragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159791);
    this.Jmq = new Point();
    this.Jmr = new Point();
    this.Jmt = false;
    this.Jmu = 1.0F;
    this.Jmv = 1.0F;
    this.Jmz = false;
    this.JmG = true;
    this.Uu = 0;
    this.JmH = 1;
    this.JmK = 0;
    this.JmL = new View[1];
    this.JmN = 0.3333333F;
    this.JmO = 0.3333333F;
    this.JmV = 0.5F;
    this.JmW = new c()
    {
      public final float bW(float paramAnonymousFloat)
      {
        AppMethodBeat.i(159754);
        float f = DragSortListView.a(DragSortListView.this);
        AppMethodBeat.o(159754);
        return f * paramAnonymousFloat;
      }
    };
    this.JmY = 0;
    this.JmZ = false;
    this.Jna = false;
    this.Jnb = null;
    this.Jnd = 0;
    this.Jne = 0.25F;
    this.Jnf = 0.0F;
    this.Jnh = false;
    this.Jnj = false;
    this.Jnk = false;
    this.Jnl = new DragSortListView.j(this, (byte)0);
    this.Jnp = 0.0F;
    this.Jnq = false;
    this.Jnr = false;
    int j = 150;
    int i = 150;
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, a.a.DragSortListView, 0, 0);
      this.JmH = Math.max(1, paramContext.getDimensionPixelSize(1, 1));
      this.Jnh = paramContext.getBoolean(16, false);
      if (this.Jnh) {
        this.Jni = new DragSortListView.f(this);
      }
      this.Jmu = paramContext.getFloat(8, this.Jmu);
      this.Jmv = this.Jmu;
      this.JmG = paramContext.getBoolean(2, this.JmG);
      this.Jne = Math.max(0.0F, Math.min(1.0F, 1.0F - paramContext.getFloat(14, 0.75F)));
      if (this.Jne <= 0.0F) {
        break label603;
      }
    }
    label603:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.Jmz = bool1;
      setDragScrollStart(paramContext.getFloat(4, this.JmN));
      this.JmV = paramContext.getFloat(10, this.JmV);
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
        paramAttributeSet.JlY = bool1;
        paramAttributeSet.JlX = bool2;
        paramAttributeSet.JnY = i3;
        this.Jnb = paramAttributeSet;
        setOnTouchListener(paramAttributeSet);
      }
      paramContext.recycle();
      this.JmM = new d();
      if (j > 0) {
        this.Jnm = new k(j, (byte)0);
      }
      if (i > 0) {
        this.Jnn = new g(i, (byte)0);
      }
      this.Jnc = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
      this.mObserver = new DataSetObserver()
      {
        private void cancel()
        {
          AppMethodBeat.i(159755);
          if (DragSortListView.b(DragSortListView.this) == 4) {
            DragSortListView.this.fwr();
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
    int i = adl(paramInt1);
    int m = paramView.getHeight();
    int n = ka(paramInt1, i);
    int j;
    if (paramInt1 != this.JmA)
    {
      j = m - i;
      i = n - i;
    }
    for (;;)
    {
      int i1 = this.JmI;
      int k = i1;
      if (this.JmA != this.Jmx)
      {
        k = i1;
        if (this.JmA != this.Jmy) {
          k = i1 - this.JmH;
        }
      }
      if (paramInt1 <= paramInt2)
      {
        if (paramInt1 <= this.Jmx) {
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
          if (paramInt1 <= this.Jmx) {
            paramInt1 = j - k + 0;
          } else if (paramInt1 == this.Jmy) {
            paramInt1 = m - n + 0;
          } else {
            paramInt1 = j + 0;
          }
        }
        else if (paramInt1 <= this.Jmx) {
          paramInt1 = 0 - k;
        } else if (paramInt1 == this.Jmy) {
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
        if (paramInt <= this.JmA) {
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
    if ((paramInt != this.JmA) && (paramInt != this.Jmx) && (paramInt != this.Jmy))
    {
      i = -2;
      if (i != localLayoutParams.height)
      {
        localLayoutParams.height = i;
        paramView.setLayoutParams(localLayoutParams);
      }
      if ((paramInt == this.Jmx) || (paramInt == this.Jmy))
      {
        if (paramInt >= this.JmA) {
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
      if (paramInt == this.JmA)
      {
        i = j;
        if (this.mxK != null) {
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
      if (paramInt > this.JmA) {
        ((b)paramView).setGravity(48);
      }
    }
  }
  
  private int adj(int paramInt)
  {
    AppMethodBeat.i(159795);
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null)
    {
      paramInt = localView.getHeight();
      AppMethodBeat.o(159795);
      return paramInt;
    }
    paramInt = ka(paramInt, adl(paramInt));
    AppMethodBeat.o(159795);
    return paramInt;
  }
  
  private void adk(int paramInt)
  {
    AppMethodBeat.i(159803);
    this.Uu = 1;
    if (this.JmF != null) {
      this.JmF.remove(paramInt);
    }
    fwB();
    fwu();
    fws();
    if (this.Jna)
    {
      this.Uu = 3;
      AppMethodBeat.o(159803);
      return;
    }
    this.Uu = 0;
    AppMethodBeat.o(159803);
  }
  
  private int adl(int paramInt)
  {
    AppMethodBeat.i(159816);
    if (paramInt == this.JmA)
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
    int i = this.Jnl.get(paramInt);
    if (i != -1)
    {
      AppMethodBeat.o(159816);
      return i;
    }
    localObject = getAdapter();
    i = ((ListAdapter)localObject).getItemViewType(paramInt);
    int j = ((ListAdapter)localObject).getViewTypeCount();
    if (j != this.JmL.length) {
      this.JmL = new View[j];
    }
    if (i >= 0) {
      if (this.JmL[i] == null)
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
        this.JmL[i] = localObject;
      }
    }
    for (;;)
    {
      i = b(paramInt, (View)localObject, true);
      this.Jnl.add(paramInt, i);
      AppMethodBeat.o(159816);
      return i;
      localObject = ((ListAdapter)localObject).getView(paramInt, this.JmL[i], this);
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
      this.lDu = this.mX;
      this.lDv = this.mY;
    }
    this.mX = ((int)paramMotionEvent.getX());
    this.mY = ((int)paramMotionEvent.getY());
    if (i == 0)
    {
      this.lDu = this.mX;
      this.lDv = this.mY;
    }
    this.mOffsetX = ((int)paramMotionEvent.getRawX() - this.mX);
    this.mOffsetY = ((int)paramMotionEvent.getRawY() - this.mY);
    AppMethodBeat.o(159809);
  }
  
  private int b(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159817);
    if (paramInt == this.JmA)
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
      gO(localView);
      paramInt = localView.getMeasuredHeight();
    }
    AppMethodBeat.o(159817);
    return paramInt;
  }
  
  private int c(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159818);
    paramInt = ka(paramInt, b(paramInt, paramView, paramBoolean));
    AppMethodBeat.o(159818);
    return paramInt;
  }
  
  private void d(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159827);
    this.Jnj = true;
    fwA();
    int i = this.Jmx;
    int j = this.Jmy;
    boolean bool = fwq();
    if (bool)
    {
      fwx();
      setSelectionFromTop(paramInt, a(paramInt, paramView, i, j) + paramView.getTop() - getPaddingTop());
      layoutChildren();
    }
    if ((bool) || (paramBoolean)) {
      invalidate();
    }
    this.Jnj = false;
    AppMethodBeat.o(159827);
  }
  
  private boolean d(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(159806);
    if (this.mxK != null)
    {
      this.JmM.fwC();
      if (paramBoolean) {
        w(this.JmA - getHeaderViewsCount(), paramFloat);
      }
      for (;;)
      {
        if (this.Jnh) {
          this.Jni.stopTracking();
        }
        AppMethodBeat.o(159806);
        return true;
        if (this.Jnn != null) {
          this.Jnn.start();
        } else {
          fwt();
        }
      }
    }
    AppMethodBeat.o(159806);
    return false;
  }
  
  private void fwA()
  {
    AppMethodBeat.i(159828);
    if (this.Jnb != null)
    {
      this.Jmr.set(this.mX, this.mY);
      this.Jnb.j(this.Jmq);
    }
    int i = this.Jmq.x;
    int m = this.Jmq.y;
    int j = getPaddingLeft();
    int k;
    if (((this.JmY & 0x1) == 0) && (i > j))
    {
      this.Jmq.x = j;
      j = getHeaderViewsCount();
      k = getFooterViewsCount();
      int n = getFirstVisiblePosition();
      int i1 = getLastVisiblePosition();
      i = getPaddingTop();
      if (n < j) {
        i = getChildAt(j - n - 1).getBottom();
      }
      j = i;
      if ((this.JmY & 0x8) == 0)
      {
        j = i;
        if (n <= this.JmA) {
          j = Math.max(getChildAt(this.JmA - n).getTop(), i);
        }
      }
      i = getHeight() - getPaddingBottom();
      if (i1 >= getCount() - k - 1) {
        i = getChildAt(getCount() - k - 1 - n).getBottom();
      }
      k = i;
      if ((this.JmY & 0x4) == 0)
      {
        k = i;
        if (i1 >= this.JmA) {
          k = Math.min(getChildAt(this.JmA - n).getBottom(), i);
        }
      }
      if (m >= j) {
        break label319;
      }
      this.Jmq.y = j;
    }
    for (;;)
    {
      this.Jms = (this.Jmq.y + this.JmJ);
      AppMethodBeat.o(159828);
      return;
      if (((this.JmY & 0x2) != 0) || (i >= j)) {
        break;
      }
      this.Jmq.x = j;
      break;
      label319:
      if (this.JmI + m > k) {
        this.Jmq.y = (k - this.JmI);
      }
    }
  }
  
  private void fwB()
  {
    AppMethodBeat.i(159829);
    if (this.mxK != null)
    {
      this.mxK.setVisibility(8);
      if (this.Jnb != null) {
        this.Jnb.gP(this.mxK);
      }
      this.mxK = null;
      invalidate();
    }
    AppMethodBeat.o(159829);
  }
  
  private boolean fwq()
  {
    boolean bool2 = true;
    AppMethodBeat.i(159797);
    int j = getFirstVisiblePosition();
    int i = this.Jmx;
    View localView2 = getChildAt(i - j);
    View localView1 = localView2;
    if (localView2 == null)
    {
      i = j + getChildCount() / 2;
      localView1 = getChildAt(i - j);
    }
    int i2 = localView1.getTop();
    int i1 = localView1.getHeight();
    j = jZ(i, i2);
    int i3 = getDividerHeight();
    int k;
    int m;
    int n;
    if (this.Jms < j)
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
      i = adj(i1);
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
      i1 = this.Jmx;
      i2 = this.Jmy;
      float f1 = this.Jnf;
      int i4;
      label207:
      float f2;
      if (this.Jmz)
      {
        i4 = Math.abs(i - j);
        if (this.Jms < i)
        {
          m = (int)(this.Jne * 0.5F * i4);
          f2 = m;
          j += m;
          if (this.Jms >= j) {
            break label552;
          }
          this.Jmx = (k - 1);
          this.Jmy = k;
          this.Jnf = ((j - this.Jms) * 0.5F / f2);
          label272:
          if (this.Jmx >= n) {
            break label613;
          }
          this.Jmx = n;
          this.Jmy = n;
          k = n;
          label297:
          if ((this.Jmx == i1) && (this.Jmy == i2) && (Math.abs(this.Jnf - f1) <= 0.0F)) {
            break label656;
          }
        }
      }
      label656:
      for (boolean bool1 = true;; bool1 = false)
      {
        if (k != this.Jmw)
        {
          this.Jmw = k;
          bool1 = bool2;
        }
        for (;;)
        {
          AppMethodBeat.o(159797);
          return bool1;
          i2 -= i + i3;
          m = jZ(i1, i2);
          i = m;
          k = i1;
          if (this.Jms >= m) {
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
            i1 = adj(m + 1);
            n = jZ(m + 1, i2);
            i = n;
            k = m;
            if (this.Jms < n) {
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
          if (this.Jms >= i - m)
          {
            this.Jmx = k;
            this.Jmy = (k + 1);
            this.Jnf = ((1.0F + (i - this.Jms) / f2) * 0.5F);
            break label272;
          }
          this.Jmx = k;
          this.Jmy = k;
          break label272;
          label613:
          if (this.Jmy < getCount() - i3) {
            break label297;
          }
          k = getCount() - i3 - 1;
          this.Jmx = k;
          this.Jmy = k;
          break label297;
        }
      }
      label662:
      j = i;
      i = n;
    }
  }
  
  private void fws()
  {
    this.JmA = -1;
    this.Jmx = -1;
    this.Jmy = -1;
    this.Jmw = -1;
  }
  
  private void fwt()
  {
    AppMethodBeat.i(159802);
    this.Uu = 2;
    if ((this.JmE != null) && (this.Jmw >= 0) && (this.Jmw < getCount()))
    {
      int i = getHeaderViewsCount();
      this.JmE.ei(this.JmA - i, this.Jmw - i);
    }
    fwB();
    fwu();
    fws();
    fwx();
    if (this.Jna)
    {
      this.Uu = 3;
      AppMethodBeat.o(159802);
      return;
    }
    this.Uu = 0;
    AppMethodBeat.o(159802);
  }
  
  private void fwu()
  {
    int i = 0;
    AppMethodBeat.i(159804);
    int j = getFirstVisiblePosition();
    if (this.JmA < j)
    {
      View localView = getChildAt(0);
      if (localView != null) {
        i = localView.getTop();
      }
      setSelectionFromTop(j - 1, i - getPaddingTop());
    }
    AppMethodBeat.o(159804);
  }
  
  private void fwv()
  {
    AppMethodBeat.i(159808);
    this.Jnd = 0;
    this.Jna = false;
    if (this.Uu == 3) {
      this.Uu = 0;
    }
    this.Jmv = this.Jmu;
    this.Jnq = false;
    this.Jnl.clear();
    AppMethodBeat.o(159808);
  }
  
  private void fww()
  {
    AppMethodBeat.i(159812);
    int i = getPaddingTop();
    int j = getHeight() - i - getPaddingBottom();
    float f1 = j;
    this.JmS = (i + this.JmN * f1);
    float f2 = i;
    this.JmR = (f1 * (1.0F - this.JmO) + f2);
    this.JmP = ((int)this.JmS);
    this.JmQ = ((int)this.JmR);
    this.JmT = (this.JmS - i);
    this.JmU = (i + j - this.JmR);
    AppMethodBeat.o(159812);
  }
  
  private void fwx()
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
  
  private void fwy()
  {
    AppMethodBeat.i(159822);
    if (this.mxK != null)
    {
      gO(this.mxK);
      this.JmI = this.mxK.getMeasuredHeight();
      this.JmJ = (this.JmI / 2);
    }
    AppMethodBeat.o(159822);
  }
  
  private void fwz()
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
  
  private void gO(View paramView)
  {
    AppMethodBeat.i(159821);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null)
    {
      localObject = new AbsListView.LayoutParams(-1, -2);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int j = ViewGroup.getChildMeasureSpec(this.JmK, getListPaddingLeft() + getListPaddingRight(), ((ViewGroup.LayoutParams)localObject).width);
    if (((ViewGroup.LayoutParams)localObject).height > 0) {}
    for (int i = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(j, i);
      AppMethodBeat.o(159821);
      return;
    }
  }
  
  private int jZ(int paramInt1, int paramInt2)
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
    int m = this.JmI - this.JmH;
    int k = adl(paramInt1);
    int n = adj(paramInt1);
    if (this.Jmy <= this.JmA) {
      if ((paramInt1 == this.Jmy) && (this.Jmx != this.Jmy)) {
        if (paramInt1 == this.JmA)
        {
          i = paramInt2 + n - this.JmI;
          if (paramInt1 > this.JmA) {
            break label256;
          }
        }
      }
    }
    label256:
    for (paramInt1 = (this.JmI - j - adl(paramInt1 - 1)) / 2 + i;; paramInt1 = (k - j - this.JmI) / 2 + i)
    {
      AppMethodBeat.o(159796);
      return paramInt1;
      i = n - k + paramInt2 - m;
      break;
      i = paramInt2;
      if (paramInt1 <= this.Jmy) {
        break;
      }
      i = paramInt2;
      if (paramInt1 > this.JmA) {
        break;
      }
      i = paramInt2 - m;
      break;
      if ((paramInt1 > this.JmA) && (paramInt1 <= this.Jmx))
      {
        i = paramInt2 + m;
        break;
      }
      i = paramInt2;
      if (paramInt1 != this.Jmy) {
        break;
      }
      i = paramInt2;
      if (this.Jmx == this.Jmy) {
        break;
      }
      i = paramInt2 + (n - k);
      break;
    }
  }
  
  private int ka(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    int k;
    if ((this.Jmz) && (this.Jmx != this.Jmy))
    {
      i = 1;
      j = this.JmI - this.JmH;
      k = (int)(this.Jnf * j);
      if (paramInt1 != this.JmA) {
        break label109;
      }
      if (this.JmA != this.Jmx) {
        break label85;
      }
      if (i == 0) {
        break label80;
      }
      i = k + this.JmH;
    }
    label80:
    label85:
    label109:
    do
    {
      return i;
      i = 0;
      break;
      return this.JmI;
      if (this.JmA == this.Jmy) {
        return this.JmI - k;
      }
      return this.JmH;
      if (paramInt1 == this.Jmx)
      {
        if (i != 0) {
          return paramInt2 + k;
        }
        return paramInt2 + j;
      }
      i = paramInt2;
    } while (paramInt1 != this.Jmy);
    return paramInt2 + j - k;
  }
  
  private void w(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(159800);
    if ((this.Uu == 0) || (this.Uu == 4))
    {
      if (this.Uu == 0)
      {
        this.JmA = (getHeaderViewsCount() + paramInt);
        this.Jmx = this.JmA;
        this.Jmy = this.JmA;
        this.Jmw = this.JmA;
        View localView = getChildAt(this.JmA - getFirstVisiblePosition());
        if (localView != null) {
          localView.setVisibility(4);
        }
      }
      this.Uu = 1;
      this.Jnp = paramFloat;
      if (this.Jna) {
        switch (this.Jnd)
        {
        }
      }
      while (this.Jnm != null)
      {
        this.Jnm.start();
        AppMethodBeat.o(159800);
        return;
        super.onTouchEvent(this.Jnc);
        continue;
        super.onInterceptTouchEvent(this.Jnc);
      }
      adk(paramInt);
    }
    AppMethodBeat.o(159800);
  }
  
  public final boolean a(int paramInt1, View paramView, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159825);
    if ((this.Uu != 0) || (!this.Jna) || (this.mxK != null) || (paramView == null) || (!this.JmG))
    {
      AppMethodBeat.o(159825);
      return false;
    }
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    paramInt1 = getHeaderViewsCount() + paramInt1;
    this.Jmx = paramInt1;
    this.Jmy = paramInt1;
    this.JmA = paramInt1;
    this.Jmw = paramInt1;
    this.Uu = 4;
    this.JmY = 0;
    this.JmY |= paramInt2;
    this.mxK = paramView;
    fwy();
    this.JmB = paramInt3;
    this.JmC = paramInt4;
    this.JmX = this.mY;
    this.Jmq.x = (this.mX - this.JmB);
    this.Jmq.y = (this.mY - this.JmC);
    paramView = getChildAt(this.JmA - getFirstVisiblePosition());
    if (paramView != null) {
      paramView.setVisibility(4);
    }
    if (this.Jnh)
    {
      paramView = this.Jni;
      paramView.mBuilder.append("<DSLVStates>\n");
      paramView.JnE = 0;
      paramView.JnF = true;
    }
    switch (this.Jnd)
    {
    }
    for (;;)
    {
      requestLayout();
      AppMethodBeat.o(159825);
      return true;
      super.onTouchEvent(this.Jnc);
      continue;
      super.onInterceptTouchEvent(this.Jnc);
    }
  }
  
  public final boolean bV(float paramFloat)
  {
    AppMethodBeat.i(159805);
    this.Jno = true;
    boolean bool = d(true, paramFloat);
    AppMethodBeat.o(159805);
    return bool;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159794);
    super.dispatchDraw(paramCanvas);
    if (this.Uu != 0)
    {
      if (this.Jmx != this.JmA) {
        a(this.Jmx, paramCanvas);
      }
      if ((this.Jmy != this.Jmx) && (this.Jmy != this.JmA)) {
        a(this.Jmy, paramCanvas);
      }
    }
    int k;
    int m;
    int i;
    float f;
    if (this.mxK != null)
    {
      k = this.mxK.getWidth();
      m = this.mxK.getHeight();
      int j = this.Jmq.x;
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
      i = (int)(f * (255.0F * this.Jmv));
      paramCanvas.save();
      paramCanvas.translate(this.Jmq.x, this.Jmq.y);
      paramCanvas.clipRect(0, 0, k, m);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, k, m, i, 31);
      this.mxK.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.restore();
      AppMethodBeat.o(159794);
      return;
    }
  }
  
  public final void fwr()
  {
    AppMethodBeat.i(159801);
    if (this.Uu == 4)
    {
      this.JmM.fwC();
      fwB();
      fws();
      fwx();
      if (this.Jna)
      {
        this.Uu = 3;
        AppMethodBeat.o(159801);
        return;
      }
      this.Uu = 0;
    }
    AppMethodBeat.o(159801);
  }
  
  public float getFloatAlpha()
  {
    return this.Jmv;
  }
  
  public ListAdapter getInputAdapter()
  {
    if (this.Jng == null) {
      return null;
    }
    return this.Jng.EN;
  }
  
  protected void layoutChildren()
  {
    AppMethodBeat.i(159824);
    super.layoutChildren();
    if (this.mxK != null)
    {
      if ((this.mxK.isLayoutRequested()) && (!this.Jmt)) {
        fwy();
      }
      this.mxK.layout(0, 0, this.mxK.getMeasuredWidth(), this.mxK.getMeasuredHeight());
      this.Jmt = false;
    }
    AppMethodBeat.o(159824);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159798);
    super.onDraw(paramCanvas);
    if (this.Jnh)
    {
      paramCanvas = this.Jni;
      if (paramCanvas.JnF)
      {
        paramCanvas.mBuilder.append("<DSLVState>\n");
        int j = paramCanvas.Jns.getChildCount();
        int k = paramCanvas.Jns.getFirstVisiblePosition();
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
          paramCanvas.mBuilder.append(paramCanvas.Jns.getChildAt(i).getTop()).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</Tops>\n");
        paramCanvas.mBuilder.append("    <Bottoms>");
        i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(paramCanvas.Jns.getChildAt(i).getBottom()).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</Bottoms>\n");
        paramCanvas.mBuilder.append("    <FirstExpPos>").append(paramCanvas.Jns.Jmx).append("</FirstExpPos>\n");
        paramCanvas.mBuilder.append("    <FirstExpBlankHeight>").append(paramCanvas.Jns.adj(paramCanvas.Jns.Jmx) - paramCanvas.Jns.adl(paramCanvas.Jns.Jmx)).append("</FirstExpBlankHeight>\n");
        paramCanvas.mBuilder.append("    <SecondExpPos>").append(paramCanvas.Jns.Jmy).append("</SecondExpPos>\n");
        paramCanvas.mBuilder.append("    <SecondExpBlankHeight>").append(paramCanvas.Jns.adj(paramCanvas.Jns.Jmy) - paramCanvas.Jns.adl(paramCanvas.Jns.Jmy)).append("</SecondExpBlankHeight>\n");
        paramCanvas.mBuilder.append("    <SrcPos>").append(paramCanvas.Jns.JmA).append("</SrcPos>\n");
        paramCanvas.mBuilder.append("    <SrcHeight>").append(paramCanvas.Jns.JmI + paramCanvas.Jns.getDividerHeight()).append("</SrcHeight>\n");
        paramCanvas.mBuilder.append("    <ViewHeight>").append(paramCanvas.Jns.getHeight()).append("</ViewHeight>\n");
        paramCanvas.mBuilder.append("    <LastY>").append(paramCanvas.Jns.lDv).append("</LastY>\n");
        paramCanvas.mBuilder.append("    <FloatY>").append(paramCanvas.Jns.Jms).append("</FloatY>\n");
        paramCanvas.mBuilder.append("    <ShuffleEdges>");
        i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(paramCanvas.Jns.jZ(k + i, paramCanvas.Jns.getChildAt(i).getTop())).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</ShuffleEdges>\n");
        paramCanvas.mBuilder.append("</DSLVState>\n");
        paramCanvas.JnD += 1;
        if (paramCanvas.JnD > 1000)
        {
          paramCanvas.flush();
          paramCanvas.JnD = 0;
        }
      }
    }
    AppMethodBeat.o(159798);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159810);
    if (!this.JmG)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(159810);
      return bool;
    }
    ak(paramMotionEvent);
    this.JmZ = true;
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0)
    {
      if (this.Uu != 0)
      {
        this.Jnk = true;
        AppMethodBeat.o(159810);
        return true;
      }
      this.Jna = true;
    }
    if (this.mxK != null)
    {
      bool = true;
      if ((i == 1) || (i == 3)) {
        this.Jna = false;
      }
      AppMethodBeat.o(159810);
      return bool;
    }
    if (super.onInterceptTouchEvent(paramMotionEvent)) {
      this.Jnq = true;
    }
    for (boolean bool = true;; bool = false) {
      switch (i)
      {
      case 2: 
      default: 
        if (bool) {
          this.Jnd = 1;
        }
        break;
      case 1: 
      case 3: 
        fwv();
        break;
        this.Jnd = 2;
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159823);
    super.onMeasure(paramInt1, paramInt2);
    if (this.mxK != null)
    {
      if (this.mxK.isLayoutRequested()) {
        fwy();
      }
      this.Jmt = true;
    }
    this.JmK = paramInt1;
    AppMethodBeat.o(159823);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159813);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    fww();
    AppMethodBeat.o(159813);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159807);
    if (this.Jnk)
    {
      this.Jnk = false;
      AppMethodBeat.o(159807);
      return false;
    }
    if (!this.JmG)
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(159807);
      return bool1;
    }
    boolean bool1 = this.JmZ;
    this.JmZ = false;
    if (!bool1) {
      ak(paramMotionEvent);
    }
    boolean bool2;
    if (this.Uu == 4)
    {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
      for (;;)
      {
        bool2 = true;
        AppMethodBeat.o(159807);
        return bool2;
        if (this.Uu == 4) {
          fwr();
        }
        fwv();
        continue;
        if (this.Uu == 4)
        {
          this.Jno = false;
          d(false, 0.0F);
        }
        fwv();
        continue;
        int j = (int)paramMotionEvent.getX();
        int i = (int)paramMotionEvent.getY();
        this.Jmq.x = (j - this.JmB);
        this.Jmq.y = (i - this.JmC);
        fwz();
        j = Math.min(i, this.Jms + this.JmJ);
        int k = Math.max(i, this.Jms - this.JmJ);
        paramMotionEvent = this.JmM;
        if (paramMotionEvent.Jcu) {}
        for (i = paramMotionEvent.JnB;; i = -1)
        {
          if ((j <= this.lDv) || (j <= this.JmQ) || (i == 1)) {
            break label307;
          }
          if (i != -1) {
            this.JmM.fwC();
          }
          this.JmM.adm(1);
          break;
        }
        label307:
        if ((k < this.lDv) && (k < this.JmP) && (i != 0))
        {
          if (i != -1) {
            this.JmM.fwC();
          }
          this.JmM.adm(0);
        }
        else if ((k >= this.JmP) && (j <= this.JmQ) && (this.JmM.Jcu))
        {
          this.JmM.fwC();
        }
      }
    }
    if ((this.Uu == 0) && (super.onTouchEvent(paramMotionEvent))) {}
    for (bool1 = true;; bool1 = false) {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 2: 
      default: 
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        this.Jnd = 1;
        bool2 = bool1;
        break;
      case 1: 
      case 3: 
        fwv();
        bool2 = bool1;
        break;
      }
    }
  }
  
  public final void removeItem(int paramInt)
  {
    AppMethodBeat.i(159799);
    this.Jno = false;
    w(paramInt, 0.0F);
    AppMethodBeat.o(159799);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(159819);
    if (!this.Jnj) {
      super.requestLayout();
    }
    AppMethodBeat.o(159819);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(159792);
    if (paramListAdapter != null)
    {
      this.Jng = new a(paramListAdapter, (byte)0);
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
      super.setAdapter(this.Jng);
      AppMethodBeat.o(159792);
      return;
      this.Jng = null;
    }
  }
  
  public void setDragEnabled(boolean paramBoolean)
  {
    this.JmG = paramBoolean;
  }
  
  public void setDragListener(b paramb)
  {
    this.JmD = paramb;
  }
  
  public void setDragScrollProfile(c paramc)
  {
    if (paramc != null) {
      this.JmW = paramc;
    }
  }
  
  public void setDragScrollStart(float paramFloat)
  {
    AppMethodBeat.i(159811);
    if (paramFloat > 0.5F)
    {
      this.JmO = 0.5F;
      if (paramFloat <= 0.5F) {
        break label58;
      }
    }
    label58:
    for (this.JmN = 0.5F;; this.JmN = paramFloat)
    {
      if (getHeight() != 0) {
        fww();
      }
      AppMethodBeat.o(159811);
      return;
      this.JmO = paramFloat;
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
    this.JmE = paramh;
  }
  
  public void setFloatAlpha(float paramFloat)
  {
    this.Jmv = paramFloat;
  }
  
  public void setFloatViewManager(i parami)
  {
    this.Jnb = parami;
  }
  
  public void setMaxScrollSpeed(float paramFloat)
  {
    this.JmV = paramFloat;
  }
  
  public void setRemoveListener(l paraml)
  {
    this.JmF = paraml;
  }
  
  final class a
    extends BaseAdapter
  {
    ListAdapter EN;
    
    private a(ListAdapter paramListAdapter)
    {
      AppMethodBeat.i(159760);
      this.EN = paramListAdapter;
      this.EN.registerDataSetObserver(new DataSetObserver()
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
      boolean bool = this.EN.areAllItemsEnabled();
      AppMethodBeat.o(159764);
      return bool;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(159763);
      int i = this.EN.getCount();
      AppMethodBeat.o(159763);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(159762);
      Object localObject = this.EN.getItem(paramInt);
      AppMethodBeat.o(159762);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(159761);
      long l = this.EN.getItemId(paramInt);
      AppMethodBeat.o(159761);
      return l;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(159766);
      paramInt = this.EN.getItemViewType(paramInt);
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
        View localView2 = this.EN.getView(paramInt, localView1, DragSortListView.this);
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
      paramViewGroup = this.EN.getView(paramInt, null, DragSortListView.this);
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
      int i = this.EN.getViewTypeCount();
      AppMethodBeat.o(159767);
      return i;
    }
    
    public final boolean hasStableIds()
    {
      AppMethodBeat.i(159768);
      boolean bool = this.EN.hasStableIds();
      AppMethodBeat.o(159768);
      return bool;
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(159769);
      boolean bool = this.EN.isEmpty();
      AppMethodBeat.o(159769);
      return bool;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(159765);
      boolean bool = this.EN.isEnabled(paramInt);
      AppMethodBeat.o(159765);
      return bool;
    }
  }
  
  public static abstract interface b {}
  
  public static abstract interface c
  {
    public abstract float bW(float paramFloat);
  }
  
  final class d
    implements Runnable
  {
    boolean Jcu = false;
    private long JnA;
    int JnB;
    private float JnC;
    private boolean Jnv;
    private long Jnw;
    private long Jnx;
    private int Jny;
    private float Jnz;
    
    d() {}
    
    public final void adm(int paramInt)
    {
      AppMethodBeat.i(159771);
      if (!this.Jcu)
      {
        this.Jnv = false;
        this.Jcu = true;
        this.JnA = SystemClock.uptimeMillis();
        this.Jnw = this.JnA;
        this.JnB = paramInt;
        DragSortListView.this.post(this);
      }
      AppMethodBeat.o(159771);
    }
    
    public final void fwC()
    {
      AppMethodBeat.i(159772);
      DragSortListView.this.removeCallbacks(this);
      this.Jcu = false;
      AppMethodBeat.o(159772);
    }
    
    public final void run()
    {
      AppMethodBeat.i(159773);
      if (this.Jnv)
      {
        this.Jcu = false;
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
      if (this.JnB == 0)
      {
        localView = DragSortListView.this.getChildAt(0);
        if (localView == null)
        {
          this.Jcu = false;
          AppMethodBeat.o(159773);
          return;
        }
        if ((j == 0) && (localView.getTop() == k))
        {
          this.Jcu = false;
          AppMethodBeat.o(159773);
          return;
        }
        this.JnC = DragSortListView.u(DragSortListView.this).bW((DragSortListView.s(DragSortListView.this) - i2) / DragSortListView.t(DragSortListView.this));
        this.Jnx = SystemClock.uptimeMillis();
        this.Jnz = ((float)(this.Jnx - this.Jnw));
        this.Jny = Math.round(this.JnC * this.Jnz);
        if (this.Jny < 0) {
          break label496;
        }
        this.Jny = Math.min(n, this.Jny);
        i = j;
      }
      for (;;)
      {
        localView = DragSortListView.this.getChildAt(i - j);
        m = localView.getTop() + this.Jny;
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
        this.Jnw = this.Jnx;
        DragSortListView.this.post(this);
        AppMethodBeat.o(159773);
        return;
        localView = DragSortListView.this.getChildAt(i - j);
        if (localView == null)
        {
          this.Jcu = false;
          AppMethodBeat.o(159773);
          return;
        }
        if ((i == m - 1) && (localView.getBottom() <= n + k))
        {
          this.Jcu = false;
          AppMethodBeat.o(159773);
          return;
        }
        this.JnC = (-DragSortListView.u(DragSortListView.this).bW((i1 - DragSortListView.v(DragSortListView.this)) / DragSortListView.w(DragSortListView.this)));
        break;
        label496:
        this.Jny = Math.max(-n, this.Jny);
      }
    }
  }
  
  public static abstract interface e
    extends DragSortListView.b, DragSortListView.h, DragSortListView.l
  {}
  
  final class g
    extends DragSortListView.m
  {
    private int JnG;
    private int JnH;
    private float JnI;
    private float JnJ;
    
    private g(int paramInt)
    {
      super(paramInt, (byte)0);
    }
    
    private int fwD()
    {
      AppMethodBeat.i(159778);
      int i = DragSortListView.this.getFirstVisiblePosition();
      int j = (DragSortListView.i(DragSortListView.this) + DragSortListView.this.getDividerHeight()) / 2;
      View localView = DragSortListView.this.getChildAt(this.JnG - i);
      i = -1;
      if (localView != null) {
        if (this.JnG == this.JnH) {
          i = localView.getTop();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(159778);
        return i;
        if (this.JnG < this.JnH)
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
    
    public final void bX(float paramFloat)
    {
      AppMethodBeat.i(159779);
      int i = fwD();
      int j = DragSortListView.this.getPaddingLeft();
      float f1 = DragSortListView.d(DragSortListView.this).y - i;
      float f2 = DragSortListView.d(DragSortListView.this).x - j;
      paramFloat = 1.0F - paramFloat;
      if ((paramFloat < Math.abs(f1 / this.JnI)) || (paramFloat < Math.abs(f2 / this.JnJ)))
      {
        DragSortListView.d(DragSortListView.this).y = (i + (int)(this.JnI * paramFloat));
        DragSortListView.d(DragSortListView.this).x = (DragSortListView.this.getPaddingLeft() + (int)(this.JnJ * paramFloat));
        DragSortListView.f(DragSortListView.this);
      }
      AppMethodBeat.o(159779);
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(159777);
      this.JnG = DragSortListView.g(DragSortListView.this);
      this.JnH = DragSortListView.h(DragSortListView.this);
      DragSortListView.a(DragSortListView.this, 2);
      this.JnI = (DragSortListView.d(DragSortListView.this).y - fwD());
      this.JnJ = (DragSortListView.d(DragSortListView.this).x - DragSortListView.this.getPaddingLeft());
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
    public abstract View adn(int paramInt);
    
    public abstract void gP(View paramView);
    
    public abstract void j(Point paramPoint);
  }
  
  final class k
    extends DragSortListView.m
  {
    private float JnM;
    private float JnN;
    private float JnO;
    private int JnP = -1;
    private int JnQ = -1;
    private int JnR;
    private int fzs;
    
    private k(int paramInt)
    {
      super(paramInt, (byte)0);
    }
    
    public final void bX(float paramFloat)
    {
      AppMethodBeat.i(159786);
      paramFloat = 1.0F - paramFloat;
      int j = DragSortListView.this.getFirstVisiblePosition();
      View localView = DragSortListView.this.getChildAt(this.fzs - j);
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
          this.JnM += f2 * f1;
          DragSortListView.d(DragSortListView.this).x = ((int)this.JnM);
          if ((this.JnM >= k) || (this.JnM <= -k)) {
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
        if (this.JnP == -1)
        {
          this.JnP = DragSortListView.b(DragSortListView.this, this.fzs, localView);
          this.JnN = (localView.getHeight() - this.JnP);
        }
        i = Math.max((int)(this.JnN * paramFloat), 1);
        localObject = localView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = (i + this.JnP);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.JnR != this.fzs)
      {
        localView = DragSortListView.this.getChildAt(this.JnR - j);
        if (localView != null)
        {
          if (this.JnQ == -1)
          {
            this.JnQ = DragSortListView.b(DragSortListView.this, this.JnR, localView);
            this.JnO = (localView.getHeight() - this.JnQ);
          }
          i = Math.max((int)(this.JnO * paramFloat), 1);
          localObject = localView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = (i + this.JnQ);
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(159786);
    }
    
    public final void onStart()
    {
      int i = -1;
      AppMethodBeat.i(159785);
      this.JnP = -1;
      this.JnQ = -1;
      this.fzs = DragSortListView.l(DragSortListView.this);
      this.JnR = DragSortListView.m(DragSortListView.this);
      DragSortListView.a(DragSortListView.this, 1);
      this.JnM = DragSortListView.d(DragSortListView.this).x;
      if (DragSortListView.n(DragSortListView.this))
      {
        float f = DragSortListView.this.getWidth() * 2.0F;
        if (DragSortListView.o(DragSortListView.this) == 0.0F)
        {
          DragSortListView localDragSortListView = DragSortListView.this;
          if (this.JnM < 0.0F) {}
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
    private float JnS;
    private float JnT;
    private float JnU;
    private float JnV;
    private float JnW;
    private float mAlpha;
    boolean mCanceled;
    protected long mStartTime;
    
    private m(int paramInt)
    {
      AppMethodBeat.i(159788);
      this.mAlpha = 0.5F;
      this.JnS = paramInt;
      float f = 1.0F / (this.mAlpha * 2.0F * (1.0F - this.mAlpha));
      this.JnW = f;
      this.JnT = f;
      this.JnU = (this.mAlpha / ((this.mAlpha - 1.0F) * 2.0F));
      this.JnV = (1.0F / (1.0F - this.mAlpha));
      AppMethodBeat.o(159788);
    }
    
    public void bX(float paramFloat) {}
    
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
      float f1 = (float)(SystemClock.uptimeMillis() - this.mStartTime) / this.JnS;
      if (f1 >= 1.0F)
      {
        bX(1.0F);
        onStop();
        AppMethodBeat.o(159790);
        return;
      }
      if (f1 < this.mAlpha) {
        f1 *= this.JnT * f1;
      }
      for (;;)
      {
        bX(f1);
        DragSortListView.this.post(this);
        AppMethodBeat.o(159790);
        return;
        if (f1 < 1.0F - this.mAlpha)
        {
          float f2 = this.JnU;
          f1 = f1 * this.JnV + f2;
        }
        else
        {
          f1 = 1.0F - (f1 - 1.0F) * (this.JnW * (f1 - 1.0F));
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