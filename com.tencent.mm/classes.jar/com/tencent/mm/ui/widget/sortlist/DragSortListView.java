package com.tencent.mm.ui.widget.sortlist;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
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
  private DragSortListView.d ALA;
  private float ALB;
  private float ALC;
  private int ALD;
  private int ALE;
  private float ALF;
  private float ALG;
  private float ALH;
  private float ALI;
  private float ALJ;
  private DragSortListView.c ALK;
  private int ALM;
  private int ALN;
  private boolean ALO;
  boolean ALP;
  DragSortListView.i ALQ;
  private MotionEvent ALR;
  private int ALS;
  private float ALT;
  private float ALU;
  private DragSortListView.a ALV;
  private boolean ALW;
  private DragSortListView.f ALX;
  private boolean ALY;
  private boolean ALZ;
  private Point ALe;
  private Point ALf;
  private int ALg;
  private boolean ALh;
  private float ALi;
  private float ALj;
  private int ALk;
  private int ALl;
  private int ALm;
  private boolean ALn;
  private int ALo;
  private int ALp;
  private int ALq;
  private DragSortListView.b ALr;
  private DragSortListView.h ALs;
  private DragSortListView.l ALt;
  boolean ALu;
  private int ALv;
  private int ALw;
  private int ALx;
  private int ALy;
  private View[] ALz;
  private DragSortListView.j AMa;
  private DragSortListView.k AMb;
  private DragSortListView.g AMc;
  private boolean AMd;
  private float AMe;
  boolean AMf;
  private boolean AMg;
  private int Mw;
  private int ixS;
  private int ixT;
  private View jfC;
  private DataSetObserver mObserver;
  private int mOffsetX;
  private int mOffsetY;
  private int mX;
  private int mY;
  
  public DragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113061);
    this.ALe = new Point();
    this.ALf = new Point();
    this.ALh = false;
    this.ALi = 1.0F;
    this.ALj = 1.0F;
    this.ALn = false;
    this.ALu = true;
    this.Mw = 0;
    this.ALv = 1;
    this.ALy = 0;
    this.ALz = new View[1];
    this.ALB = 0.3333333F;
    this.ALC = 0.3333333F;
    this.ALJ = 0.5F;
    this.ALK = new DragSortListView.1(this);
    this.ALN = 0;
    this.ALO = false;
    this.ALP = false;
    this.ALQ = null;
    this.ALS = 0;
    this.ALT = 0.25F;
    this.ALU = 0.0F;
    this.ALW = false;
    this.ALY = false;
    this.ALZ = false;
    this.AMa = new DragSortListView.j(this, (byte)0);
    this.AMe = 0.0F;
    this.AMf = false;
    this.AMg = false;
    int j = 150;
    int i = 150;
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, a.a.DragSortListView, 0, 0);
      this.ALv = Math.max(1, paramContext.getDimensionPixelSize(0, 1));
      this.ALW = paramContext.getBoolean(5, false);
      if (this.ALW) {
        this.ALX = new DragSortListView.f(this);
      }
      this.ALi = paramContext.getFloat(6, this.ALi);
      this.ALj = this.ALi;
      this.ALu = paramContext.getBoolean(10, this.ALu);
      this.ALT = Math.max(0.0F, Math.min(1.0F, 1.0F - paramContext.getFloat(7, 0.75F)));
      if (this.ALT <= 0.0F) {
        break label602;
      }
    }
    label602:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.ALn = bool1;
      setDragScrollStart(paramContext.getFloat(1, this.ALB));
      this.ALJ = paramContext.getFloat(2, this.ALJ);
      j = paramContext.getInt(8, 150);
      i = paramContext.getInt(9, 150);
      if (paramContext.getBoolean(17, true))
      {
        bool1 = paramContext.getBoolean(12, false);
        int k = paramContext.getInt(4, 1);
        boolean bool2 = paramContext.getBoolean(11, true);
        int m = paramContext.getInt(13, 0);
        int n = paramContext.getResourceId(14, 0);
        int i1 = paramContext.getResourceId(15, 0);
        int i2 = paramContext.getResourceId(16, 0);
        int i3 = paramContext.getColor(3, -16777216);
        paramAttributeSet = new a(this, n, m, k, i2, i1);
        paramAttributeSet.AKM = bool1;
        paramAttributeSet.AKL = bool2;
        paramAttributeSet.AMM = i3;
        this.ALQ = paramAttributeSet;
        setOnTouchListener(paramAttributeSet);
      }
      paramContext.recycle();
      this.ALA = new DragSortListView.d(this);
      if (j > 0) {
        this.AMb = new DragSortListView.k(this, j, (byte)0);
      }
      if (i > 0) {
        this.AMc = new DragSortListView.g(this, i, (byte)0);
      }
      this.ALR = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
      this.mObserver = new DragSortListView.2(this);
      AppMethodBeat.o(113061);
      return;
    }
  }
  
  private int RA(int paramInt)
  {
    AppMethodBeat.i(113086);
    if (paramInt == this.ALo)
    {
      AppMethodBeat.o(113086);
      return 0;
    }
    Object localObject = getChildAt(paramInt - getFirstVisiblePosition());
    if (localObject != null)
    {
      paramInt = b(paramInt, (View)localObject, false);
      AppMethodBeat.o(113086);
      return paramInt;
    }
    int i = this.AMa.get(paramInt);
    if (i != -1)
    {
      AppMethodBeat.o(113086);
      return i;
    }
    localObject = getAdapter();
    i = ((ListAdapter)localObject).getItemViewType(paramInt);
    int j = ((ListAdapter)localObject).getViewTypeCount();
    if (j != this.ALz.length) {
      this.ALz = new View[j];
    }
    if (i >= 0) {
      if (this.ALz[i] == null)
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
        this.ALz[i] = localObject;
      }
    }
    for (;;)
    {
      i = b(paramInt, (View)localObject, true);
      this.AMa.add(paramInt, i);
      AppMethodBeat.o(113086);
      return i;
      localObject = ((ListAdapter)localObject).getView(paramInt, this.ALz[i], this);
      continue;
      localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
    }
  }
  
  private int Ry(int paramInt)
  {
    AppMethodBeat.i(113065);
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null)
    {
      paramInt = localView.getHeight();
      AppMethodBeat.o(113065);
      return paramInt;
    }
    paramInt = hX(paramInt, RA(paramInt));
    AppMethodBeat.o(113065);
    return paramInt;
  }
  
  private void Rz(int paramInt)
  {
    AppMethodBeat.i(113073);
    this.Mw = 1;
    if (this.ALt != null) {
      this.ALt.remove(paramInt);
    }
    dPM();
    dPF();
    dPD();
    if (this.ALP)
    {
      this.Mw = 3;
      AppMethodBeat.o(113073);
      return;
    }
    this.Mw = 0;
    AppMethodBeat.o(113073);
  }
  
  private void Z(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(113079);
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      this.ixS = this.mX;
      this.ixT = this.mY;
    }
    this.mX = ((int)paramMotionEvent.getX());
    this.mY = ((int)paramMotionEvent.getY());
    if (i == 0)
    {
      this.ixS = this.mX;
      this.ixT = this.mY;
    }
    this.mOffsetX = ((int)paramMotionEvent.getRawX() - this.mX);
    this.mOffsetY = ((int)paramMotionEvent.getRawY() - this.mY);
    AppMethodBeat.o(113079);
  }
  
  private int a(int paramInt1, View paramView, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(113090);
    int i = RA(paramInt1);
    int m = paramView.getHeight();
    int n = hX(paramInt1, i);
    int j;
    if (paramInt1 != this.ALo)
    {
      j = m - i;
      i = n - i;
    }
    for (;;)
    {
      int i1 = this.ALw;
      int k = i1;
      if (this.ALo != this.ALl)
      {
        k = i1;
        if (this.ALo != this.ALm) {
          k = i1 - this.ALv;
        }
      }
      if (paramInt1 <= paramInt2)
      {
        if (paramInt1 <= this.ALl) {
          break label208;
        }
        paramInt1 = k - i + 0;
      }
      for (;;)
      {
        AppMethodBeat.o(113090);
        return paramInt1;
        if (paramInt1 == paramInt3)
        {
          if (paramInt1 <= this.ALl) {
            paramInt1 = j - k + 0;
          } else if (paramInt1 == this.ALm) {
            paramInt1 = m - n + 0;
          } else {
            paramInt1 = j + 0;
          }
        }
        else if (paramInt1 <= this.ALl) {
          paramInt1 = 0 - k;
        } else if (paramInt1 == this.ALm) {
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
    AppMethodBeat.i(113063);
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
        if (paramInt <= this.ALo) {
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
      AppMethodBeat.o(113063);
      return;
      label140:
      paramInt = localViewGroup.getBottom() - i;
      i = paramInt - m;
    }
  }
  
  private void a(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(113085);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    int i;
    if ((paramInt != this.ALo) && (paramInt != this.ALl) && (paramInt != this.ALm))
    {
      i = -2;
      if (i != localLayoutParams.height)
      {
        localLayoutParams.height = i;
        paramView.setLayoutParams(localLayoutParams);
      }
      if ((paramInt == this.ALl) || (paramInt == this.ALm))
      {
        if (paramInt >= this.ALo) {
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
      if (paramInt == this.ALo)
      {
        i = j;
        if (this.jfC != null) {
          i = 4;
        }
      }
      if (i != k) {
        paramView.setVisibility(i);
      }
      AppMethodBeat.o(113085);
      return;
      i = c(paramInt, paramView, paramBoolean);
      break;
      label163:
      if (paramInt > this.ALo) {
        ((b)paramView).setGravity(48);
      }
    }
  }
  
  private int b(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(113087);
    if (paramInt == this.ALo)
    {
      AppMethodBeat.o(113087);
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
      AppMethodBeat.o(113087);
      return paramInt;
    }
    paramInt = localView.getHeight();
    if ((paramInt == 0) || (paramBoolean))
    {
      fx(localView);
      paramInt = localView.getMeasuredHeight();
    }
    AppMethodBeat.o(113087);
    return paramInt;
  }
  
  private boolean b(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(113076);
    if (this.jfC != null)
    {
      this.ALA.dPN();
      if (paramBoolean) {
        p(this.ALo - getHeaderViewsCount(), paramFloat);
      }
      for (;;)
      {
        if (this.ALW) {
          this.ALX.stopTracking();
        }
        AppMethodBeat.o(113076);
        return true;
        if (this.AMc != null) {
          this.AMc.start();
        } else {
          dPE();
        }
      }
    }
    AppMethodBeat.o(113076);
    return false;
  }
  
  private int c(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(113088);
    paramInt = hX(paramInt, b(paramInt, paramView, paramBoolean));
    AppMethodBeat.o(113088);
    return paramInt;
  }
  
  private void d(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(113097);
    this.ALY = true;
    dPL();
    int i = this.ALl;
    int j = this.ALm;
    boolean bool = dPB();
    if (bool)
    {
      dPI();
      setSelectionFromTop(paramInt, a(paramInt, paramView, i, j) + paramView.getTop() - getPaddingTop());
      layoutChildren();
    }
    if ((bool) || (paramBoolean)) {
      invalidate();
    }
    this.ALY = false;
    AppMethodBeat.o(113097);
  }
  
  private boolean dPB()
  {
    boolean bool2 = true;
    AppMethodBeat.i(113067);
    int j = getFirstVisiblePosition();
    int i = this.ALl;
    View localView2 = getChildAt(i - j);
    View localView1 = localView2;
    if (localView2 == null)
    {
      i = j + getChildCount() / 2;
      localView1 = getChildAt(i - j);
    }
    int i2 = localView1.getTop();
    int i1 = localView1.getHeight();
    j = hW(i, i2);
    int i3 = getDividerHeight();
    int k;
    int m;
    int n;
    if (this.ALg < j)
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
      i = Ry(i1);
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
      i1 = this.ALl;
      i2 = this.ALm;
      float f1 = this.ALU;
      int i4;
      label207:
      float f2;
      if (this.ALn)
      {
        i4 = Math.abs(i - j);
        if (this.ALg < i)
        {
          m = (int)(this.ALT * 0.5F * i4);
          f2 = m;
          j += m;
          if (this.ALg >= j) {
            break label552;
          }
          this.ALl = (k - 1);
          this.ALm = k;
          this.ALU = ((j - this.ALg) * 0.5F / f2);
          label272:
          if (this.ALl >= n) {
            break label613;
          }
          this.ALl = n;
          this.ALm = n;
          k = n;
          label297:
          if ((this.ALl == i1) && (this.ALm == i2) && (Math.abs(this.ALU - f1) <= 0.0F)) {
            break label656;
          }
        }
      }
      label656:
      for (boolean bool1 = true;; bool1 = false)
      {
        if (k != this.ALk)
        {
          this.ALk = k;
          bool1 = bool2;
        }
        for (;;)
        {
          AppMethodBeat.o(113067);
          return bool1;
          i2 -= i + i3;
          m = hW(i1, i2);
          i = m;
          k = i1;
          if (this.ALg >= m) {
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
            i1 = Ry(m + 1);
            n = hW(m + 1, i2);
            i = n;
            k = m;
            if (this.ALg < n) {
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
          if (this.ALg >= i - m)
          {
            this.ALl = k;
            this.ALm = (k + 1);
            this.ALU = ((1.0F + (i - this.ALg) / f2) * 0.5F);
            break label272;
          }
          this.ALl = k;
          this.ALm = k;
          break label272;
          label613:
          if (this.ALm < getCount() - i3) {
            break label297;
          }
          k = getCount() - i3 - 1;
          this.ALl = k;
          this.ALm = k;
          break label297;
        }
      }
      label662:
      j = i;
      i = n;
    }
  }
  
  private void dPD()
  {
    this.ALo = -1;
    this.ALl = -1;
    this.ALm = -1;
    this.ALk = -1;
  }
  
  private void dPE()
  {
    AppMethodBeat.i(113072);
    this.Mw = 2;
    if ((this.ALs != null) && (this.ALk >= 0) && (this.ALk < getCount()))
    {
      int i = getHeaderViewsCount();
      this.ALs.dp(this.ALo - i, this.ALk - i);
    }
    dPM();
    dPF();
    dPD();
    dPI();
    if (this.ALP)
    {
      this.Mw = 3;
      AppMethodBeat.o(113072);
      return;
    }
    this.Mw = 0;
    AppMethodBeat.o(113072);
  }
  
  private void dPF()
  {
    int i = 0;
    AppMethodBeat.i(113074);
    int j = getFirstVisiblePosition();
    if (this.ALo < j)
    {
      View localView = getChildAt(0);
      if (localView != null) {
        i = localView.getTop();
      }
      setSelectionFromTop(j - 1, i - getPaddingTop());
    }
    AppMethodBeat.o(113074);
  }
  
  private void dPG()
  {
    AppMethodBeat.i(113078);
    this.ALS = 0;
    this.ALP = false;
    if (this.Mw == 3) {
      this.Mw = 0;
    }
    this.ALj = this.ALi;
    this.AMf = false;
    this.AMa.clear();
    AppMethodBeat.o(113078);
  }
  
  private void dPH()
  {
    AppMethodBeat.i(113082);
    int i = getPaddingTop();
    int j = getHeight() - i - getPaddingBottom();
    float f1 = j;
    this.ALG = (i + this.ALB * f1);
    float f2 = i;
    this.ALF = (f1 * (1.0F - this.ALC) + f2);
    this.ALD = ((int)this.ALG);
    this.ALE = ((int)this.ALF);
    this.ALH = (this.ALG - i);
    this.ALI = (i + j - this.ALF);
    AppMethodBeat.o(113082);
  }
  
  private void dPI()
  {
    AppMethodBeat.i(113084);
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
    AppMethodBeat.o(113084);
  }
  
  private void dPJ()
  {
    AppMethodBeat.i(113092);
    if (this.jfC != null)
    {
      fx(this.jfC);
      this.ALw = this.jfC.getMeasuredHeight();
      this.ALx = (this.ALw / 2);
    }
    AppMethodBeat.o(113092);
  }
  
  private void dPK()
  {
    AppMethodBeat.i(113096);
    int i = getFirstVisiblePosition();
    int j = getChildCount() / 2;
    View localView = getChildAt(getChildCount() / 2);
    if (localView == null)
    {
      AppMethodBeat.o(113096);
      return;
    }
    d(i + j, localView, true);
    AppMethodBeat.o(113096);
  }
  
  private void dPL()
  {
    AppMethodBeat.i(113098);
    if (this.ALQ != null)
    {
      this.ALf.set(this.mX, this.mY);
      this.ALQ.i(this.ALe);
    }
    int i = this.ALe.x;
    int m = this.ALe.y;
    int j = getPaddingLeft();
    int k;
    if (((this.ALN & 0x1) == 0) && (i > j))
    {
      this.ALe.x = j;
      j = getHeaderViewsCount();
      k = getFooterViewsCount();
      int n = getFirstVisiblePosition();
      int i1 = getLastVisiblePosition();
      i = getPaddingTop();
      if (n < j) {
        i = getChildAt(j - n - 1).getBottom();
      }
      j = i;
      if ((this.ALN & 0x8) == 0)
      {
        j = i;
        if (n <= this.ALo) {
          j = Math.max(getChildAt(this.ALo - n).getTop(), i);
        }
      }
      i = getHeight() - getPaddingBottom();
      if (i1 >= getCount() - k - 1) {
        i = getChildAt(getCount() - k - 1 - n).getBottom();
      }
      k = i;
      if ((this.ALN & 0x4) == 0)
      {
        k = i;
        if (i1 >= this.ALo) {
          k = Math.min(getChildAt(this.ALo - n).getBottom(), i);
        }
      }
      if (m >= j) {
        break label319;
      }
      this.ALe.y = j;
    }
    for (;;)
    {
      this.ALg = (this.ALe.y + this.ALx);
      AppMethodBeat.o(113098);
      return;
      if (((this.ALN & 0x2) != 0) || (i >= j)) {
        break;
      }
      this.ALe.x = j;
      break;
      label319:
      if (this.ALw + m > k) {
        this.ALe.y = (k - this.ALw);
      }
    }
  }
  
  private void dPM()
  {
    AppMethodBeat.i(113099);
    if (this.jfC != null)
    {
      this.jfC.setVisibility(8);
      if (this.ALQ != null) {
        this.ALQ.fy(this.jfC);
      }
      this.jfC = null;
      invalidate();
    }
    AppMethodBeat.o(113099);
  }
  
  private void fx(View paramView)
  {
    AppMethodBeat.i(113091);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null)
    {
      localObject = new AbsListView.LayoutParams(-1, -2);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int j = ViewGroup.getChildMeasureSpec(this.ALy, getListPaddingLeft() + getListPaddingRight(), ((ViewGroup.LayoutParams)localObject).width);
    if (((ViewGroup.LayoutParams)localObject).height > 0) {}
    for (int i = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(j, i);
      AppMethodBeat.o(113091);
      return;
    }
  }
  
  private int hW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113066);
    int i = getHeaderViewsCount();
    int j = getFooterViewsCount();
    if ((paramInt1 <= i) || (paramInt1 >= getCount() - j))
    {
      AppMethodBeat.o(113066);
      return paramInt2;
    }
    j = getDividerHeight();
    int m = this.ALw - this.ALv;
    int k = RA(paramInt1);
    int n = Ry(paramInt1);
    if (this.ALm <= this.ALo) {
      if ((paramInt1 == this.ALm) && (this.ALl != this.ALm)) {
        if (paramInt1 == this.ALo)
        {
          i = paramInt2 + n - this.ALw;
          if (paramInt1 > this.ALo) {
            break label256;
          }
        }
      }
    }
    label256:
    for (paramInt1 = (this.ALw - j - RA(paramInt1 - 1)) / 2 + i;; paramInt1 = (k - j - this.ALw) / 2 + i)
    {
      AppMethodBeat.o(113066);
      return paramInt1;
      i = n - k + paramInt2 - m;
      break;
      i = paramInt2;
      if (paramInt1 <= this.ALm) {
        break;
      }
      i = paramInt2;
      if (paramInt1 > this.ALo) {
        break;
      }
      i = paramInt2 - m;
      break;
      if ((paramInt1 > this.ALo) && (paramInt1 <= this.ALl))
      {
        i = paramInt2 + m;
        break;
      }
      i = paramInt2;
      if (paramInt1 != this.ALm) {
        break;
      }
      i = paramInt2;
      if (this.ALl == this.ALm) {
        break;
      }
      i = paramInt2 + (n - k);
      break;
    }
  }
  
  private int hX(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    int k;
    if ((this.ALn) && (this.ALl != this.ALm))
    {
      i = 1;
      j = this.ALw - this.ALv;
      k = (int)(this.ALU * j);
      if (paramInt1 != this.ALo) {
        break label109;
      }
      if (this.ALo != this.ALl) {
        break label85;
      }
      if (i == 0) {
        break label80;
      }
      i = k + this.ALv;
    }
    label80:
    label85:
    label109:
    do
    {
      return i;
      i = 0;
      break;
      return this.ALw;
      if (this.ALo == this.ALm) {
        return this.ALw - k;
      }
      return this.ALv;
      if (paramInt1 == this.ALl)
      {
        if (i != 0) {
          return paramInt2 + k;
        }
        return paramInt2 + j;
      }
      i = paramInt2;
    } while (paramInt1 != this.ALm);
    return paramInt2 + j - k;
  }
  
  private void p(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(113070);
    if ((this.Mw == 0) || (this.Mw == 4))
    {
      if (this.Mw == 0)
      {
        this.ALo = (getHeaderViewsCount() + paramInt);
        this.ALl = this.ALo;
        this.ALm = this.ALo;
        this.ALk = this.ALo;
        View localView = getChildAt(this.ALo - getFirstVisiblePosition());
        if (localView != null) {
          localView.setVisibility(4);
        }
      }
      this.Mw = 1;
      this.AMe = paramFloat;
      if (this.ALP) {
        switch (this.ALS)
        {
        }
      }
      while (this.AMb != null)
      {
        this.AMb.start();
        AppMethodBeat.o(113070);
        return;
        super.onTouchEvent(this.ALR);
        continue;
        super.onInterceptTouchEvent(this.ALR);
      }
      Rz(paramInt);
    }
    AppMethodBeat.o(113070);
  }
  
  public final boolean a(int paramInt1, View paramView, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(113095);
    if ((this.Mw != 0) || (!this.ALP) || (this.jfC != null) || (paramView == null) || (!this.ALu))
    {
      AppMethodBeat.o(113095);
      return false;
    }
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    paramInt1 = getHeaderViewsCount() + paramInt1;
    this.ALl = paramInt1;
    this.ALm = paramInt1;
    this.ALo = paramInt1;
    this.ALk = paramInt1;
    this.Mw = 4;
    this.ALN = 0;
    this.ALN |= paramInt2;
    this.jfC = paramView;
    dPJ();
    this.ALp = paramInt3;
    this.ALq = paramInt4;
    this.ALM = this.mY;
    this.ALe.x = (this.mX - this.ALp);
    this.ALe.y = (this.mY - this.ALq);
    paramView = getChildAt(this.ALo - getFirstVisiblePosition());
    if (paramView != null) {
      paramView.setVisibility(4);
    }
    if (this.ALW)
    {
      paramView = this.ALX;
      paramView.mBuilder.append("<DSLVStates>\n");
      paramView.AMs = 0;
      paramView.AMt = true;
    }
    switch (this.ALS)
    {
    }
    for (;;)
    {
      requestLayout();
      AppMethodBeat.o(113095);
      return true;
      super.onTouchEvent(this.ALR);
      continue;
      super.onInterceptTouchEvent(this.ALR);
    }
  }
  
  public final boolean bz(float paramFloat)
  {
    AppMethodBeat.i(113075);
    this.AMd = true;
    boolean bool = b(true, paramFloat);
    AppMethodBeat.o(113075);
    return bool;
  }
  
  public final void dPC()
  {
    AppMethodBeat.i(113071);
    if (this.Mw == 4)
    {
      this.ALA.dPN();
      dPM();
      dPD();
      dPI();
      if (this.ALP)
      {
        this.Mw = 3;
        AppMethodBeat.o(113071);
        return;
      }
      this.Mw = 0;
    }
    AppMethodBeat.o(113071);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(113064);
    super.dispatchDraw(paramCanvas);
    if (this.Mw != 0)
    {
      if (this.ALl != this.ALo) {
        a(this.ALl, paramCanvas);
      }
      if ((this.ALm != this.ALl) && (this.ALm != this.ALo)) {
        a(this.ALm, paramCanvas);
      }
    }
    int k;
    int m;
    int i;
    float f;
    if (this.jfC != null)
    {
      k = this.jfC.getWidth();
      m = this.jfC.getHeight();
      int j = this.ALe.x;
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
      i = (int)(f * (255.0F * this.ALj));
      paramCanvas.save();
      paramCanvas.translate(this.ALe.x, this.ALe.y);
      paramCanvas.clipRect(0, 0, k, m);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, k, m, i, 31);
      this.jfC.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.restore();
      AppMethodBeat.o(113064);
      return;
    }
  }
  
  public float getFloatAlpha()
  {
    return this.ALj;
  }
  
  public ListAdapter getInputAdapter()
  {
    if (this.ALV == null) {
      return null;
    }
    return this.ALV.xw;
  }
  
  protected void layoutChildren()
  {
    AppMethodBeat.i(113094);
    super.layoutChildren();
    if (this.jfC != null)
    {
      if ((this.jfC.isLayoutRequested()) && (!this.ALh)) {
        dPJ();
      }
      this.jfC.layout(0, 0, this.jfC.getMeasuredWidth(), this.jfC.getMeasuredHeight());
      this.ALh = false;
    }
    AppMethodBeat.o(113094);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(113068);
    super.onDraw(paramCanvas);
    if (this.ALW)
    {
      paramCanvas = this.ALX;
      if (paramCanvas.AMt)
      {
        paramCanvas.mBuilder.append("<DSLVState>\n");
        int j = paramCanvas.AMh.getChildCount();
        int k = paramCanvas.AMh.getFirstVisiblePosition();
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
          paramCanvas.mBuilder.append(paramCanvas.AMh.getChildAt(i).getTop()).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</Tops>\n");
        paramCanvas.mBuilder.append("    <Bottoms>");
        i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(paramCanvas.AMh.getChildAt(i).getBottom()).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</Bottoms>\n");
        paramCanvas.mBuilder.append("    <FirstExpPos>").append(paramCanvas.AMh.ALl).append("</FirstExpPos>\n");
        paramCanvas.mBuilder.append("    <FirstExpBlankHeight>").append(paramCanvas.AMh.Ry(paramCanvas.AMh.ALl) - paramCanvas.AMh.RA(paramCanvas.AMh.ALl)).append("</FirstExpBlankHeight>\n");
        paramCanvas.mBuilder.append("    <SecondExpPos>").append(paramCanvas.AMh.ALm).append("</SecondExpPos>\n");
        paramCanvas.mBuilder.append("    <SecondExpBlankHeight>").append(paramCanvas.AMh.Ry(paramCanvas.AMh.ALm) - paramCanvas.AMh.RA(paramCanvas.AMh.ALm)).append("</SecondExpBlankHeight>\n");
        paramCanvas.mBuilder.append("    <SrcPos>").append(paramCanvas.AMh.ALo).append("</SrcPos>\n");
        paramCanvas.mBuilder.append("    <SrcHeight>").append(paramCanvas.AMh.ALw + paramCanvas.AMh.getDividerHeight()).append("</SrcHeight>\n");
        paramCanvas.mBuilder.append("    <ViewHeight>").append(paramCanvas.AMh.getHeight()).append("</ViewHeight>\n");
        paramCanvas.mBuilder.append("    <LastY>").append(paramCanvas.AMh.ixT).append("</LastY>\n");
        paramCanvas.mBuilder.append("    <FloatY>").append(paramCanvas.AMh.ALg).append("</FloatY>\n");
        paramCanvas.mBuilder.append("    <ShuffleEdges>");
        i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(paramCanvas.AMh.hW(k + i, paramCanvas.AMh.getChildAt(i).getTop())).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</ShuffleEdges>\n");
        paramCanvas.mBuilder.append("</DSLVState>\n");
        paramCanvas.AMr += 1;
        if (paramCanvas.AMr > 1000)
        {
          paramCanvas.flush();
          paramCanvas.AMr = 0;
        }
      }
    }
    AppMethodBeat.o(113068);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(113080);
    if (!this.ALu)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(113080);
      return bool;
    }
    Z(paramMotionEvent);
    this.ALO = true;
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0)
    {
      if (this.Mw != 0)
      {
        this.ALZ = true;
        AppMethodBeat.o(113080);
        return true;
      }
      this.ALP = true;
    }
    if (this.jfC != null)
    {
      bool = true;
      if ((i == 1) || (i == 3)) {
        this.ALP = false;
      }
      AppMethodBeat.o(113080);
      return bool;
    }
    if (super.onInterceptTouchEvent(paramMotionEvent)) {
      this.AMf = true;
    }
    for (boolean bool = true;; bool = false) {
      switch (i)
      {
      case 2: 
      default: 
        if (bool) {
          this.ALS = 1;
        }
        break;
      case 1: 
      case 3: 
        dPG();
        break;
        this.ALS = 2;
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113093);
    super.onMeasure(paramInt1, paramInt2);
    if (this.jfC != null)
    {
      if (this.jfC.isLayoutRequested()) {
        dPJ();
      }
      this.ALh = true;
    }
    this.ALy = paramInt1;
    AppMethodBeat.o(113093);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(113083);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    dPH();
    AppMethodBeat.o(113083);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(113077);
    if (this.ALZ)
    {
      this.ALZ = false;
      AppMethodBeat.o(113077);
      return false;
    }
    if (!this.ALu)
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(113077);
      return bool1;
    }
    boolean bool1 = this.ALO;
    this.ALO = false;
    if (!bool1) {
      Z(paramMotionEvent);
    }
    boolean bool2;
    if (this.Mw == 4)
    {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
      for (;;)
      {
        bool2 = true;
        AppMethodBeat.o(113077);
        return bool2;
        if (this.Mw == 4) {
          dPC();
        }
        dPG();
        continue;
        if (this.Mw == 4)
        {
          this.AMd = false;
          b(false, 0.0F);
        }
        dPG();
        continue;
        int j = (int)paramMotionEvent.getX();
        int i = (int)paramMotionEvent.getY();
        this.ALe.x = (j - this.ALp);
        this.ALe.y = (i - this.ALq);
        dPK();
        j = Math.min(i, this.ALg + this.ALx);
        int k = Math.max(i, this.ALg - this.ALx);
        paramMotionEvent = this.ALA;
        if (paramMotionEvent.AEZ) {}
        for (i = paramMotionEvent.AMp;; i = -1)
        {
          if ((j <= this.ixT) || (j <= this.ALE) || (i == 1)) {
            break label307;
          }
          if (i != -1) {
            this.ALA.dPN();
          }
          this.ALA.RB(1);
          break;
        }
        label307:
        if ((k < this.ixT) && (k < this.ALD) && (i != 0))
        {
          if (i != -1) {
            this.ALA.dPN();
          }
          this.ALA.RB(0);
        }
        else if ((k >= this.ALD) && (j <= this.ALE) && (this.ALA.AEZ))
        {
          this.ALA.dPN();
        }
      }
    }
    if ((this.Mw == 0) && (super.onTouchEvent(paramMotionEvent))) {}
    for (bool1 = true;; bool1 = false) {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 2: 
      default: 
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        this.ALS = 1;
        bool2 = bool1;
        break;
      case 1: 
      case 3: 
        dPG();
        bool2 = bool1;
        break;
      }
    }
  }
  
  public final void removeItem(int paramInt)
  {
    AppMethodBeat.i(113069);
    this.AMd = false;
    p(paramInt, 0.0F);
    AppMethodBeat.o(113069);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(113089);
    if (!this.ALY) {
      super.requestLayout();
    }
    AppMethodBeat.o(113089);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(113062);
    if (paramListAdapter != null)
    {
      this.ALV = new DragSortListView.a(this, paramListAdapter, (byte)0);
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
      super.setAdapter(this.ALV);
      AppMethodBeat.o(113062);
      return;
      this.ALV = null;
    }
  }
  
  public void setDragEnabled(boolean paramBoolean)
  {
    this.ALu = paramBoolean;
  }
  
  public void setDragListener(DragSortListView.b paramb)
  {
    this.ALr = paramb;
  }
  
  public void setDragScrollProfile(DragSortListView.c paramc)
  {
    if (paramc != null) {
      this.ALK = paramc;
    }
  }
  
  public void setDragScrollStart(float paramFloat)
  {
    AppMethodBeat.i(113081);
    if (paramFloat > 0.5F)
    {
      this.ALC = 0.5F;
      if (paramFloat <= 0.5F) {
        break label58;
      }
    }
    label58:
    for (this.ALB = 0.5F;; this.ALB = paramFloat)
    {
      if (getHeight() != 0) {
        dPH();
      }
      AppMethodBeat.o(113081);
      return;
      this.ALC = paramFloat;
      break;
    }
  }
  
  public void setDragSortListener(DragSortListView.e parame)
  {
    AppMethodBeat.i(113100);
    setDropListener(parame);
    setDragListener(parame);
    setRemoveListener(parame);
    AppMethodBeat.o(113100);
  }
  
  public void setDropListener(DragSortListView.h paramh)
  {
    this.ALs = paramh;
  }
  
  public void setFloatAlpha(float paramFloat)
  {
    this.ALj = paramFloat;
  }
  
  public void setFloatViewManager(DragSortListView.i parami)
  {
    this.ALQ = parami;
  }
  
  public void setMaxScrollSpeed(float paramFloat)
  {
    this.ALJ = paramFloat;
  }
  
  public void setRemoveListener(DragSortListView.l paraml)
  {
    this.ALt = paraml;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView
 * JD-Core Version:    0.7.0.1
 */