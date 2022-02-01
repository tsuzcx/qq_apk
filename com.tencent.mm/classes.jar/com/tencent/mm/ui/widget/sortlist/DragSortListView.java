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
import com.tencent.mm.cl.a.a;
import java.util.ArrayList;

public class DragSortListView
  extends ListView
{
  private Point LdN;
  private Point LdO;
  private int LdP;
  private boolean LdQ;
  private float LdR;
  private float LdS;
  private int LdT;
  private int LdU;
  private int LdV;
  private boolean LdW;
  private int LdX;
  private int LdY;
  private int LdZ;
  private int LeA;
  private float LeB;
  private float LeC;
  private a LeD;
  private boolean LeE;
  private DragSortListView.f LeF;
  private boolean LeG;
  private boolean LeH;
  private j LeI;
  private k LeJ;
  private g LeK;
  private boolean LeL;
  private float LeM;
  boolean LeN;
  private boolean LeO;
  private b Lea;
  private DragSortListView.h Leb;
  private l Lec;
  boolean Led;
  private int Lee;
  private int Lef;
  private int Leg;
  private int Leh;
  private View[] Lei;
  private d Lej;
  private float Lek;
  private float Lel;
  private int Lem;
  private int Len;
  private float Leo;
  private float Lep;
  private float Leq;
  private float Ler;
  private float Les;
  private c Let;
  private int Leu;
  private int Lev;
  private boolean Lew;
  boolean Lex;
  i Ley;
  private MotionEvent Lez;
  private int Wk;
  private DataSetObserver mObserver;
  private int mOffsetX;
  private int mOffsetY;
  private int mX;
  private int mY;
  private View mYs;
  private int mcX;
  private int mcY;
  
  public DragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159791);
    this.LdN = new Point();
    this.LdO = new Point();
    this.LdQ = false;
    this.LdR = 1.0F;
    this.LdS = 1.0F;
    this.LdW = false;
    this.Led = true;
    this.Wk = 0;
    this.Lee = 1;
    this.Leh = 0;
    this.Lei = new View[1];
    this.Lek = 0.3333333F;
    this.Lel = 0.3333333F;
    this.Les = 0.5F;
    this.Let = new c()
    {
      public final float cb(float paramAnonymousFloat)
      {
        AppMethodBeat.i(159754);
        float f = DragSortListView.a(DragSortListView.this);
        AppMethodBeat.o(159754);
        return f * paramAnonymousFloat;
      }
    };
    this.Lev = 0;
    this.Lew = false;
    this.Lex = false;
    this.Ley = null;
    this.LeA = 0;
    this.LeB = 0.25F;
    this.LeC = 0.0F;
    this.LeE = false;
    this.LeG = false;
    this.LeH = false;
    this.LeI = new j((byte)0);
    this.LeM = 0.0F;
    this.LeN = false;
    this.LeO = false;
    int j = 150;
    int i = 150;
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, a.a.DragSortListView, 0, 0);
      this.Lee = Math.max(1, paramContext.getDimensionPixelSize(1, 1));
      this.LeE = paramContext.getBoolean(16, false);
      if (this.LeE) {
        this.LeF = new DragSortListView.f(this);
      }
      this.LdR = paramContext.getFloat(8, this.LdR);
      this.LdS = this.LdR;
      this.Led = paramContext.getBoolean(2, this.Led);
      this.LeB = Math.max(0.0F, Math.min(1.0F, 1.0F - paramContext.getFloat(14, 0.75F)));
      if (this.LeB <= 0.0F) {
        break label603;
      }
    }
    label603:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.LdW = bool1;
      setDragScrollStart(paramContext.getFloat(4, this.Lek));
      this.Les = paramContext.getFloat(10, this.Les);
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
        paramAttributeSet.Ldv = bool1;
        paramAttributeSet.Ldu = bool2;
        paramAttributeSet.Lfv = i3;
        this.Ley = paramAttributeSet;
        setOnTouchListener(paramAttributeSet);
      }
      paramContext.recycle();
      this.Lej = new d();
      if (j > 0) {
        this.LeJ = new k(j, (byte)0);
      }
      if (i > 0) {
        this.LeK = new g(i, (byte)0);
      }
      this.Lez = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
      this.mObserver = new DataSetObserver()
      {
        private void cancel()
        {
          AppMethodBeat.i(159755);
          if (DragSortListView.b(DragSortListView.this) == 4) {
            DragSortListView.this.fNf();
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
    int i = afL(paramInt1);
    int m = paramView.getHeight();
    int n = kn(paramInt1, i);
    int j;
    if (paramInt1 != this.LdX)
    {
      j = m - i;
      i = n - i;
    }
    for (;;)
    {
      int i1 = this.Lef;
      int k = i1;
      if (this.LdX != this.LdU)
      {
        k = i1;
        if (this.LdX != this.LdV) {
          k = i1 - this.Lee;
        }
      }
      if (paramInt1 <= paramInt2)
      {
        if (paramInt1 <= this.LdU) {
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
          if (paramInt1 <= this.LdU) {
            paramInt1 = j - k + 0;
          } else if (paramInt1 == this.LdV) {
            paramInt1 = m - n + 0;
          } else {
            paramInt1 = j + 0;
          }
        }
        else if (paramInt1 <= this.LdU) {
          paramInt1 = 0 - k;
        } else if (paramInt1 == this.LdV) {
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
        if (paramInt <= this.LdX) {
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
    if ((paramInt != this.LdX) && (paramInt != this.LdU) && (paramInt != this.LdV))
    {
      i = -2;
      if (i != localLayoutParams.height)
      {
        localLayoutParams.height = i;
        paramView.setLayoutParams(localLayoutParams);
      }
      if ((paramInt == this.LdU) || (paramInt == this.LdV))
      {
        if (paramInt >= this.LdX) {
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
      if (paramInt == this.LdX)
      {
        i = j;
        if (this.mYs != null) {
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
      if (paramInt > this.LdX) {
        ((b)paramView).setGravity(48);
      }
    }
  }
  
  private int afJ(int paramInt)
  {
    AppMethodBeat.i(159795);
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null)
    {
      paramInt = localView.getHeight();
      AppMethodBeat.o(159795);
      return paramInt;
    }
    paramInt = kn(paramInt, afL(paramInt));
    AppMethodBeat.o(159795);
    return paramInt;
  }
  
  private void afK(int paramInt)
  {
    AppMethodBeat.i(159803);
    this.Wk = 1;
    if (this.Lec != null) {
      this.Lec.remove(paramInt);
    }
    fNp();
    fNi();
    fNg();
    if (this.Lex)
    {
      this.Wk = 3;
      AppMethodBeat.o(159803);
      return;
    }
    this.Wk = 0;
    AppMethodBeat.o(159803);
  }
  
  private int afL(int paramInt)
  {
    AppMethodBeat.i(159816);
    if (paramInt == this.LdX)
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
    int i = this.LeI.get(paramInt);
    if (i != -1)
    {
      AppMethodBeat.o(159816);
      return i;
    }
    localObject = getAdapter();
    i = ((ListAdapter)localObject).getItemViewType(paramInt);
    int j = ((ListAdapter)localObject).getViewTypeCount();
    if (j != this.Lei.length) {
      this.Lei = new View[j];
    }
    if (i >= 0) {
      if (this.Lei[i] == null)
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
        this.Lei[i] = localObject;
      }
    }
    for (;;)
    {
      i = b(paramInt, (View)localObject, true);
      this.LeI.add(paramInt, i);
      AppMethodBeat.o(159816);
      return i;
      localObject = ((ListAdapter)localObject).getView(paramInt, this.Lei[i], this);
      continue;
      localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
    }
  }
  
  private void am(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159809);
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      this.mcX = this.mX;
      this.mcY = this.mY;
    }
    this.mX = ((int)paramMotionEvent.getX());
    this.mY = ((int)paramMotionEvent.getY());
    if (i == 0)
    {
      this.mcX = this.mX;
      this.mcY = this.mY;
    }
    this.mOffsetX = ((int)paramMotionEvent.getRawX() - this.mX);
    this.mOffsetY = ((int)paramMotionEvent.getRawY() - this.mY);
    AppMethodBeat.o(159809);
  }
  
  private int b(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159817);
    if (paramInt == this.LdX)
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
      hf(localView);
      paramInt = localView.getMeasuredHeight();
    }
    AppMethodBeat.o(159817);
    return paramInt;
  }
  
  private int c(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159818);
    paramInt = kn(paramInt, b(paramInt, paramView, paramBoolean));
    AppMethodBeat.o(159818);
    return paramInt;
  }
  
  private void d(int paramInt, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159827);
    this.LeG = true;
    fNo();
    int i = this.LdU;
    int j = this.LdV;
    boolean bool = fNe();
    if (bool)
    {
      fNl();
      setSelectionFromTop(paramInt, a(paramInt, paramView, i, j) + paramView.getTop() - getPaddingTop());
      layoutChildren();
    }
    if ((bool) || (paramBoolean)) {
      invalidate();
    }
    this.LeG = false;
    AppMethodBeat.o(159827);
  }
  
  private boolean d(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(159806);
    if (this.mYs != null)
    {
      this.Lej.fNq();
      if (paramBoolean) {
        y(this.LdX - getHeaderViewsCount(), paramFloat);
      }
      for (;;)
      {
        if (this.LeE) {
          this.LeF.stopTracking();
        }
        AppMethodBeat.o(159806);
        return true;
        if (this.LeK != null) {
          this.LeK.start();
        } else {
          fNh();
        }
      }
    }
    AppMethodBeat.o(159806);
    return false;
  }
  
  private boolean fNe()
  {
    boolean bool2 = true;
    AppMethodBeat.i(159797);
    int j = getFirstVisiblePosition();
    int i = this.LdU;
    View localView2 = getChildAt(i - j);
    View localView1 = localView2;
    if (localView2 == null)
    {
      i = j + getChildCount() / 2;
      localView1 = getChildAt(i - j);
    }
    int i2 = localView1.getTop();
    int i1 = localView1.getHeight();
    j = km(i, i2);
    int i3 = getDividerHeight();
    int k;
    int m;
    int n;
    if (this.LdP < j)
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
      i = afJ(i1);
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
      i1 = this.LdU;
      i2 = this.LdV;
      float f1 = this.LeC;
      int i4;
      label207:
      float f2;
      if (this.LdW)
      {
        i4 = Math.abs(i - j);
        if (this.LdP < i)
        {
          m = (int)(this.LeB * 0.5F * i4);
          f2 = m;
          j += m;
          if (this.LdP >= j) {
            break label552;
          }
          this.LdU = (k - 1);
          this.LdV = k;
          this.LeC = ((j - this.LdP) * 0.5F / f2);
          label272:
          if (this.LdU >= n) {
            break label613;
          }
          this.LdU = n;
          this.LdV = n;
          k = n;
          label297:
          if ((this.LdU == i1) && (this.LdV == i2) && (Math.abs(this.LeC - f1) <= 0.0F)) {
            break label656;
          }
        }
      }
      label656:
      for (boolean bool1 = true;; bool1 = false)
      {
        if (k != this.LdT)
        {
          this.LdT = k;
          bool1 = bool2;
        }
        for (;;)
        {
          AppMethodBeat.o(159797);
          return bool1;
          i2 -= i + i3;
          m = km(i1, i2);
          i = m;
          k = i1;
          if (this.LdP >= m) {
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
            i1 = afJ(m + 1);
            n = km(m + 1, i2);
            i = n;
            k = m;
            if (this.LdP < n) {
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
          if (this.LdP >= i - m)
          {
            this.LdU = k;
            this.LdV = (k + 1);
            this.LeC = ((1.0F + (i - this.LdP) / f2) * 0.5F);
            break label272;
          }
          this.LdU = k;
          this.LdV = k;
          break label272;
          label613:
          if (this.LdV < getCount() - i3) {
            break label297;
          }
          k = getCount() - i3 - 1;
          this.LdU = k;
          this.LdV = k;
          break label297;
        }
      }
      label662:
      j = i;
      i = n;
    }
  }
  
  private void fNg()
  {
    this.LdX = -1;
    this.LdU = -1;
    this.LdV = -1;
    this.LdT = -1;
  }
  
  private void fNh()
  {
    AppMethodBeat.i(159802);
    this.Wk = 2;
    if ((this.Leb != null) && (this.LdT >= 0) && (this.LdT < getCount()))
    {
      int i = getHeaderViewsCount();
      this.Leb.ek(this.LdX - i, this.LdT - i);
    }
    fNp();
    fNi();
    fNg();
    fNl();
    if (this.Lex)
    {
      this.Wk = 3;
      AppMethodBeat.o(159802);
      return;
    }
    this.Wk = 0;
    AppMethodBeat.o(159802);
  }
  
  private void fNi()
  {
    int i = 0;
    AppMethodBeat.i(159804);
    int j = getFirstVisiblePosition();
    if (this.LdX < j)
    {
      View localView = getChildAt(0);
      if (localView != null) {
        i = localView.getTop();
      }
      setSelectionFromTop(j - 1, i - getPaddingTop());
    }
    AppMethodBeat.o(159804);
  }
  
  private void fNj()
  {
    AppMethodBeat.i(159808);
    this.LeA = 0;
    this.Lex = false;
    if (this.Wk == 3) {
      this.Wk = 0;
    }
    this.LdS = this.LdR;
    this.LeN = false;
    this.LeI.clear();
    AppMethodBeat.o(159808);
  }
  
  private void fNk()
  {
    AppMethodBeat.i(159812);
    int i = getPaddingTop();
    int j = getHeight() - i - getPaddingBottom();
    float f1 = j;
    this.Lep = (i + this.Lek * f1);
    float f2 = i;
    this.Leo = (f1 * (1.0F - this.Lel) + f2);
    this.Lem = ((int)this.Lep);
    this.Len = ((int)this.Leo);
    this.Leq = (this.Lep - i);
    this.Ler = (i + j - this.Leo);
    AppMethodBeat.o(159812);
  }
  
  private void fNl()
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
  
  private void fNm()
  {
    AppMethodBeat.i(159822);
    if (this.mYs != null)
    {
      hf(this.mYs);
      this.Lef = this.mYs.getMeasuredHeight();
      this.Leg = (this.Lef / 2);
    }
    AppMethodBeat.o(159822);
  }
  
  private void fNn()
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
  
  private void fNo()
  {
    AppMethodBeat.i(159828);
    if (this.Ley != null)
    {
      this.LdO.set(this.mX, this.mY);
      this.Ley.j(this.LdN);
    }
    int i = this.LdN.x;
    int m = this.LdN.y;
    int j = getPaddingLeft();
    int k;
    if (((this.Lev & 0x1) == 0) && (i > j))
    {
      this.LdN.x = j;
      j = getHeaderViewsCount();
      k = getFooterViewsCount();
      int n = getFirstVisiblePosition();
      int i1 = getLastVisiblePosition();
      i = getPaddingTop();
      if (n < j) {
        i = getChildAt(j - n - 1).getBottom();
      }
      j = i;
      if ((this.Lev & 0x8) == 0)
      {
        j = i;
        if (n <= this.LdX) {
          j = Math.max(getChildAt(this.LdX - n).getTop(), i);
        }
      }
      i = getHeight() - getPaddingBottom();
      if (i1 >= getCount() - k - 1) {
        i = getChildAt(getCount() - k - 1 - n).getBottom();
      }
      k = i;
      if ((this.Lev & 0x4) == 0)
      {
        k = i;
        if (i1 >= this.LdX) {
          k = Math.min(getChildAt(this.LdX - n).getBottom(), i);
        }
      }
      if (m >= j) {
        break label319;
      }
      this.LdN.y = j;
    }
    for (;;)
    {
      this.LdP = (this.LdN.y + this.Leg);
      AppMethodBeat.o(159828);
      return;
      if (((this.Lev & 0x2) != 0) || (i >= j)) {
        break;
      }
      this.LdN.x = j;
      break;
      label319:
      if (this.Lef + m > k) {
        this.LdN.y = (k - this.Lef);
      }
    }
  }
  
  private void fNp()
  {
    AppMethodBeat.i(159829);
    if (this.mYs != null)
    {
      this.mYs.setVisibility(8);
      if (this.Ley != null) {
        this.Ley.hg(this.mYs);
      }
      this.mYs = null;
      invalidate();
    }
    AppMethodBeat.o(159829);
  }
  
  private void hf(View paramView)
  {
    AppMethodBeat.i(159821);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null)
    {
      localObject = new AbsListView.LayoutParams(-1, -2);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int j = ViewGroup.getChildMeasureSpec(this.Leh, getListPaddingLeft() + getListPaddingRight(), ((ViewGroup.LayoutParams)localObject).width);
    if (((ViewGroup.LayoutParams)localObject).height > 0) {}
    for (int i = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(j, i);
      AppMethodBeat.o(159821);
      return;
    }
  }
  
  private int km(int paramInt1, int paramInt2)
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
    int m = this.Lef - this.Lee;
    int k = afL(paramInt1);
    int n = afJ(paramInt1);
    if (this.LdV <= this.LdX) {
      if ((paramInt1 == this.LdV) && (this.LdU != this.LdV)) {
        if (paramInt1 == this.LdX)
        {
          i = paramInt2 + n - this.Lef;
          if (paramInt1 > this.LdX) {
            break label256;
          }
        }
      }
    }
    label256:
    for (paramInt1 = (this.Lef - j - afL(paramInt1 - 1)) / 2 + i;; paramInt1 = (k - j - this.Lef) / 2 + i)
    {
      AppMethodBeat.o(159796);
      return paramInt1;
      i = n - k + paramInt2 - m;
      break;
      i = paramInt2;
      if (paramInt1 <= this.LdV) {
        break;
      }
      i = paramInt2;
      if (paramInt1 > this.LdX) {
        break;
      }
      i = paramInt2 - m;
      break;
      if ((paramInt1 > this.LdX) && (paramInt1 <= this.LdU))
      {
        i = paramInt2 + m;
        break;
      }
      i = paramInt2;
      if (paramInt1 != this.LdV) {
        break;
      }
      i = paramInt2;
      if (this.LdU == this.LdV) {
        break;
      }
      i = paramInt2 + (n - k);
      break;
    }
  }
  
  private int kn(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    int k;
    if ((this.LdW) && (this.LdU != this.LdV))
    {
      i = 1;
      j = this.Lef - this.Lee;
      k = (int)(this.LeC * j);
      if (paramInt1 != this.LdX) {
        break label109;
      }
      if (this.LdX != this.LdU) {
        break label85;
      }
      if (i == 0) {
        break label80;
      }
      i = k + this.Lee;
    }
    label80:
    label85:
    label109:
    do
    {
      return i;
      i = 0;
      break;
      return this.Lef;
      if (this.LdX == this.LdV) {
        return this.Lef - k;
      }
      return this.Lee;
      if (paramInt1 == this.LdU)
      {
        if (i != 0) {
          return paramInt2 + k;
        }
        return paramInt2 + j;
      }
      i = paramInt2;
    } while (paramInt1 != this.LdV);
    return paramInt2 + j - k;
  }
  
  private void y(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(159800);
    if ((this.Wk == 0) || (this.Wk == 4))
    {
      if (this.Wk == 0)
      {
        this.LdX = (getHeaderViewsCount() + paramInt);
        this.LdU = this.LdX;
        this.LdV = this.LdX;
        this.LdT = this.LdX;
        View localView = getChildAt(this.LdX - getFirstVisiblePosition());
        if (localView != null) {
          localView.setVisibility(4);
        }
      }
      this.Wk = 1;
      this.LeM = paramFloat;
      if (this.Lex) {
        switch (this.LeA)
        {
        }
      }
      while (this.LeJ != null)
      {
        this.LeJ.start();
        AppMethodBeat.o(159800);
        return;
        super.onTouchEvent(this.Lez);
        continue;
        super.onInterceptTouchEvent(this.Lez);
      }
      afK(paramInt);
    }
    AppMethodBeat.o(159800);
  }
  
  public final boolean a(int paramInt1, View paramView, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159825);
    if ((this.Wk != 0) || (!this.Lex) || (this.mYs != null) || (paramView == null) || (!this.Led))
    {
      AppMethodBeat.o(159825);
      return false;
    }
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    paramInt1 = getHeaderViewsCount() + paramInt1;
    this.LdU = paramInt1;
    this.LdV = paramInt1;
    this.LdX = paramInt1;
    this.LdT = paramInt1;
    this.Wk = 4;
    this.Lev = 0;
    this.Lev |= paramInt2;
    this.mYs = paramView;
    fNm();
    this.LdY = paramInt3;
    this.LdZ = paramInt4;
    this.Leu = this.mY;
    this.LdN.x = (this.mX - this.LdY);
    this.LdN.y = (this.mY - this.LdZ);
    paramView = getChildAt(this.LdX - getFirstVisiblePosition());
    if (paramView != null) {
      paramView.setVisibility(4);
    }
    if (this.LeE)
    {
      paramView = this.LeF;
      paramView.mBuilder.append("<DSLVStates>\n");
      paramView.Lfb = 0;
      paramView.Lfc = true;
    }
    switch (this.LeA)
    {
    }
    for (;;)
    {
      requestLayout();
      AppMethodBeat.o(159825);
      return true;
      super.onTouchEvent(this.Lez);
      continue;
      super.onInterceptTouchEvent(this.Lez);
    }
  }
  
  public final boolean ca(float paramFloat)
  {
    AppMethodBeat.i(159805);
    this.LeL = true;
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
      if (this.LdU != this.LdX) {
        a(this.LdU, paramCanvas);
      }
      if ((this.LdV != this.LdU) && (this.LdV != this.LdX)) {
        a(this.LdV, paramCanvas);
      }
    }
    int k;
    int m;
    int i;
    float f;
    if (this.mYs != null)
    {
      k = this.mYs.getWidth();
      m = this.mYs.getHeight();
      int j = this.LdN.x;
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
      i = (int)(f * (255.0F * this.LdS));
      paramCanvas.save();
      paramCanvas.translate(this.LdN.x, this.LdN.y);
      paramCanvas.clipRect(0, 0, k, m);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, k, m, i, 31);
      this.mYs.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.restore();
      AppMethodBeat.o(159794);
      return;
    }
  }
  
  public final void fNf()
  {
    AppMethodBeat.i(159801);
    if (this.Wk == 4)
    {
      this.Lej.fNq();
      fNp();
      fNg();
      fNl();
      if (this.Lex)
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
    return this.LdS;
  }
  
  public ListAdapter getInputAdapter()
  {
    if (this.LeD == null) {
      return null;
    }
    return this.LeD.GE;
  }
  
  protected void layoutChildren()
  {
    AppMethodBeat.i(159824);
    super.layoutChildren();
    if (this.mYs != null)
    {
      if ((this.mYs.isLayoutRequested()) && (!this.LdQ)) {
        fNm();
      }
      this.mYs.layout(0, 0, this.mYs.getMeasuredWidth(), this.mYs.getMeasuredHeight());
      this.LdQ = false;
    }
    AppMethodBeat.o(159824);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159798);
    super.onDraw(paramCanvas);
    if (this.LeE)
    {
      paramCanvas = this.LeF;
      if (paramCanvas.Lfc)
      {
        paramCanvas.mBuilder.append("<DSLVState>\n");
        int j = paramCanvas.LeP.getChildCount();
        int k = paramCanvas.LeP.getFirstVisiblePosition();
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
          paramCanvas.mBuilder.append(paramCanvas.LeP.getChildAt(i).getTop()).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</Tops>\n");
        paramCanvas.mBuilder.append("    <Bottoms>");
        i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(paramCanvas.LeP.getChildAt(i).getBottom()).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</Bottoms>\n");
        paramCanvas.mBuilder.append("    <FirstExpPos>").append(paramCanvas.LeP.LdU).append("</FirstExpPos>\n");
        paramCanvas.mBuilder.append("    <FirstExpBlankHeight>").append(paramCanvas.LeP.afJ(paramCanvas.LeP.LdU) - paramCanvas.LeP.afL(paramCanvas.LeP.LdU)).append("</FirstExpBlankHeight>\n");
        paramCanvas.mBuilder.append("    <SecondExpPos>").append(paramCanvas.LeP.LdV).append("</SecondExpPos>\n");
        paramCanvas.mBuilder.append("    <SecondExpBlankHeight>").append(paramCanvas.LeP.afJ(paramCanvas.LeP.LdV) - paramCanvas.LeP.afL(paramCanvas.LeP.LdV)).append("</SecondExpBlankHeight>\n");
        paramCanvas.mBuilder.append("    <SrcPos>").append(paramCanvas.LeP.LdX).append("</SrcPos>\n");
        paramCanvas.mBuilder.append("    <SrcHeight>").append(paramCanvas.LeP.Lef + paramCanvas.LeP.getDividerHeight()).append("</SrcHeight>\n");
        paramCanvas.mBuilder.append("    <ViewHeight>").append(paramCanvas.LeP.getHeight()).append("</ViewHeight>\n");
        paramCanvas.mBuilder.append("    <LastY>").append(paramCanvas.LeP.mcY).append("</LastY>\n");
        paramCanvas.mBuilder.append("    <FloatY>").append(paramCanvas.LeP.LdP).append("</FloatY>\n");
        paramCanvas.mBuilder.append("    <ShuffleEdges>");
        i = 0;
        while (i < j)
        {
          paramCanvas.mBuilder.append(paramCanvas.LeP.km(k + i, paramCanvas.LeP.getChildAt(i).getTop())).append(",");
          i += 1;
        }
        paramCanvas.mBuilder.append("</ShuffleEdges>\n");
        paramCanvas.mBuilder.append("</DSLVState>\n");
        paramCanvas.Lfa += 1;
        if (paramCanvas.Lfa > 1000)
        {
          paramCanvas.flush();
          paramCanvas.Lfa = 0;
        }
      }
    }
    AppMethodBeat.o(159798);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159810);
    if (!this.Led)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(159810);
      return bool;
    }
    am(paramMotionEvent);
    this.Lew = true;
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0)
    {
      if (this.Wk != 0)
      {
        this.LeH = true;
        AppMethodBeat.o(159810);
        return true;
      }
      this.Lex = true;
    }
    if (this.mYs != null)
    {
      bool = true;
      if ((i == 1) || (i == 3)) {
        this.Lex = false;
      }
      AppMethodBeat.o(159810);
      return bool;
    }
    if (super.onInterceptTouchEvent(paramMotionEvent)) {
      this.LeN = true;
    }
    for (boolean bool = true;; bool = false) {
      switch (i)
      {
      case 2: 
      default: 
        if (bool) {
          this.LeA = 1;
        }
        break;
      case 1: 
      case 3: 
        fNj();
        break;
        this.LeA = 2;
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159823);
    super.onMeasure(paramInt1, paramInt2);
    if (this.mYs != null)
    {
      if (this.mYs.isLayoutRequested()) {
        fNm();
      }
      this.LdQ = true;
    }
    this.Leh = paramInt1;
    AppMethodBeat.o(159823);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159813);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    fNk();
    AppMethodBeat.o(159813);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159807);
    if (this.LeH)
    {
      this.LeH = false;
      AppMethodBeat.o(159807);
      return false;
    }
    if (!this.Led)
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(159807);
      return bool1;
    }
    boolean bool1 = this.Lew;
    this.Lew = false;
    if (!bool1) {
      am(paramMotionEvent);
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
          fNf();
        }
        fNj();
        continue;
        if (this.Wk == 4)
        {
          this.LeL = false;
          d(false, 0.0F);
        }
        fNj();
        continue;
        int j = (int)paramMotionEvent.getX();
        int i = (int)paramMotionEvent.getY();
        this.LdN.x = (j - this.LdY);
        this.LdN.y = (i - this.LdZ);
        fNn();
        j = Math.min(i, this.LdP + this.Leg);
        int k = Math.max(i, this.LdP - this.Leg);
        paramMotionEvent = this.Lej;
        if (paramMotionEvent.KTC) {}
        for (i = paramMotionEvent.LeY;; i = -1)
        {
          if ((j <= this.mcY) || (j <= this.Len) || (i == 1)) {
            break label307;
          }
          if (i != -1) {
            this.Lej.fNq();
          }
          this.Lej.afM(1);
          break;
        }
        label307:
        if ((k < this.mcY) && (k < this.Lem) && (i != 0))
        {
          if (i != -1) {
            this.Lej.fNq();
          }
          this.Lej.afM(0);
        }
        else if ((k >= this.Lem) && (j <= this.Len) && (this.Lej.KTC))
        {
          this.Lej.fNq();
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
        this.LeA = 1;
        bool2 = bool1;
        break;
      case 1: 
      case 3: 
        fNj();
        bool2 = bool1;
        break;
      }
    }
  }
  
  public final void removeItem(int paramInt)
  {
    AppMethodBeat.i(159799);
    this.LeL = false;
    y(paramInt, 0.0F);
    AppMethodBeat.o(159799);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(159819);
    if (!this.LeG) {
      super.requestLayout();
    }
    AppMethodBeat.o(159819);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(159792);
    if (paramListAdapter != null)
    {
      this.LeD = new a(paramListAdapter, (byte)0);
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
      super.setAdapter(this.LeD);
      AppMethodBeat.o(159792);
      return;
      this.LeD = null;
    }
  }
  
  public void setDragEnabled(boolean paramBoolean)
  {
    this.Led = paramBoolean;
  }
  
  public void setDragListener(b paramb)
  {
    this.Lea = paramb;
  }
  
  public void setDragScrollProfile(c paramc)
  {
    if (paramc != null) {
      this.Let = paramc;
    }
  }
  
  public void setDragScrollStart(float paramFloat)
  {
    AppMethodBeat.i(159811);
    if (paramFloat > 0.5F)
    {
      this.Lel = 0.5F;
      if (paramFloat <= 0.5F) {
        break label58;
      }
    }
    label58:
    for (this.Lek = 0.5F;; this.Lek = paramFloat)
    {
      if (getHeight() != 0) {
        fNk();
      }
      AppMethodBeat.o(159811);
      return;
      this.Lel = paramFloat;
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
    this.Leb = paramh;
  }
  
  public void setFloatAlpha(float paramFloat)
  {
    this.LdS = paramFloat;
  }
  
  public void setFloatViewManager(i parami)
  {
    this.Ley = parami;
  }
  
  public void setMaxScrollSpeed(float paramFloat)
  {
    this.Les = paramFloat;
  }
  
  public void setRemoveListener(l paraml)
  {
    this.Lec = paraml;
  }
  
  final class a
    extends BaseAdapter
  {
    ListAdapter GE;
    
    private a(ListAdapter paramListAdapter)
    {
      AppMethodBeat.i(159760);
      this.GE = paramListAdapter;
      this.GE.registerDataSetObserver(new DataSetObserver()
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
      boolean bool = this.GE.areAllItemsEnabled();
      AppMethodBeat.o(159764);
      return bool;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(159763);
      int i = this.GE.getCount();
      AppMethodBeat.o(159763);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(159762);
      Object localObject = this.GE.getItem(paramInt);
      AppMethodBeat.o(159762);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(159761);
      long l = this.GE.getItemId(paramInt);
      AppMethodBeat.o(159761);
      return l;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(159766);
      paramInt = this.GE.getItemViewType(paramInt);
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
        View localView2 = this.GE.getView(paramInt, localView1, DragSortListView.this);
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
      paramViewGroup = this.GE.getView(paramInt, null, DragSortListView.this);
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
      int i = this.GE.getViewTypeCount();
      AppMethodBeat.o(159767);
      return i;
    }
    
    public final boolean hasStableIds()
    {
      AppMethodBeat.i(159768);
      boolean bool = this.GE.hasStableIds();
      AppMethodBeat.o(159768);
      return bool;
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(159769);
      boolean bool = this.GE.isEmpty();
      AppMethodBeat.o(159769);
      return bool;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(159765);
      boolean bool = this.GE.isEnabled(paramInt);
      AppMethodBeat.o(159765);
      return bool;
    }
  }
  
  public static abstract interface b {}
  
  public static abstract interface c
  {
    public abstract float cb(float paramFloat);
  }
  
  final class d
    implements Runnable
  {
    boolean KTC = false;
    private boolean LeS;
    private long LeT;
    private long LeU;
    private int LeV;
    private float LeW;
    private long LeX;
    int LeY;
    private float LeZ;
    
    d() {}
    
    public final void afM(int paramInt)
    {
      AppMethodBeat.i(159771);
      if (!this.KTC)
      {
        this.LeS = false;
        this.KTC = true;
        this.LeX = SystemClock.uptimeMillis();
        this.LeT = this.LeX;
        this.LeY = paramInt;
        DragSortListView.this.post(this);
      }
      AppMethodBeat.o(159771);
    }
    
    public final void fNq()
    {
      AppMethodBeat.i(159772);
      DragSortListView.this.removeCallbacks(this);
      this.KTC = false;
      AppMethodBeat.o(159772);
    }
    
    public final void run()
    {
      AppMethodBeat.i(159773);
      if (this.LeS)
      {
        this.KTC = false;
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
      if (this.LeY == 0)
      {
        localView = DragSortListView.this.getChildAt(0);
        if (localView == null)
        {
          this.KTC = false;
          AppMethodBeat.o(159773);
          return;
        }
        if ((j == 0) && (localView.getTop() == k))
        {
          this.KTC = false;
          AppMethodBeat.o(159773);
          return;
        }
        this.LeZ = DragSortListView.u(DragSortListView.this).cb((DragSortListView.s(DragSortListView.this) - i2) / DragSortListView.t(DragSortListView.this));
        this.LeU = SystemClock.uptimeMillis();
        this.LeW = ((float)(this.LeU - this.LeT));
        this.LeV = Math.round(this.LeZ * this.LeW);
        if (this.LeV < 0) {
          break label496;
        }
        this.LeV = Math.min(n, this.LeV);
        i = j;
      }
      for (;;)
      {
        localView = DragSortListView.this.getChildAt(i - j);
        m = localView.getTop() + this.LeV;
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
        this.LeT = this.LeU;
        DragSortListView.this.post(this);
        AppMethodBeat.o(159773);
        return;
        localView = DragSortListView.this.getChildAt(i - j);
        if (localView == null)
        {
          this.KTC = false;
          AppMethodBeat.o(159773);
          return;
        }
        if ((i == m - 1) && (localView.getBottom() <= n + k))
        {
          this.KTC = false;
          AppMethodBeat.o(159773);
          return;
        }
        this.LeZ = (-DragSortListView.u(DragSortListView.this).cb((i1 - DragSortListView.v(DragSortListView.this)) / DragSortListView.w(DragSortListView.this)));
        break;
        label496:
        this.LeV = Math.max(-n, this.LeV);
      }
    }
  }
  
  public static abstract interface e
    extends DragSortListView.b, DragSortListView.h, DragSortListView.l
  {}
  
  final class g
    extends DragSortListView.m
  {
    private int Lfd;
    private int Lfe;
    private float Lff;
    private float Lfg;
    
    private g(int paramInt)
    {
      super(paramInt, (byte)0);
    }
    
    private int fNr()
    {
      AppMethodBeat.i(159778);
      int i = DragSortListView.this.getFirstVisiblePosition();
      int j = (DragSortListView.i(DragSortListView.this) + DragSortListView.this.getDividerHeight()) / 2;
      View localView = DragSortListView.this.getChildAt(this.Lfd - i);
      i = -1;
      if (localView != null) {
        if (this.Lfd == this.Lfe) {
          i = localView.getTop();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(159778);
        return i;
        if (this.Lfd < this.Lfe)
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
    
    public final void cc(float paramFloat)
    {
      AppMethodBeat.i(159779);
      int i = fNr();
      int j = DragSortListView.this.getPaddingLeft();
      float f1 = DragSortListView.d(DragSortListView.this).y - i;
      float f2 = DragSortListView.d(DragSortListView.this).x - j;
      paramFloat = 1.0F - paramFloat;
      if ((paramFloat < Math.abs(f1 / this.Lff)) || (paramFloat < Math.abs(f2 / this.Lfg)))
      {
        DragSortListView.d(DragSortListView.this).y = (i + (int)(this.Lff * paramFloat));
        DragSortListView.d(DragSortListView.this).x = (DragSortListView.this.getPaddingLeft() + (int)(this.Lfg * paramFloat));
        DragSortListView.f(DragSortListView.this);
      }
      AppMethodBeat.o(159779);
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(159777);
      this.Lfd = DragSortListView.g(DragSortListView.this);
      this.Lfe = DragSortListView.h(DragSortListView.this);
      DragSortListView.a(DragSortListView.this, 2);
      this.Lff = (DragSortListView.d(DragSortListView.this).y - fNr());
      this.Lfg = (DragSortListView.d(DragSortListView.this).x - DragSortListView.this.getPaddingLeft());
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
    public abstract View afN(int paramInt);
    
    public abstract void hg(View paramView);
    
    public abstract void j(Point paramPoint);
  }
  
  final class j
  {
    private SparseIntArray Lfh;
    private ArrayList<Integer> Lfi;
    private int zbE;
    
    private j()
    {
      AppMethodBeat.i(159781);
      this.Lfh = new SparseIntArray(3);
      this.Lfi = new ArrayList(3);
      this.zbE = 3;
      AppMethodBeat.o(159781);
    }
    
    public final void add(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(159782);
      int i = this.Lfh.get(paramInt1, -1);
      if (i != paramInt2)
      {
        if (i != -1) {
          break label87;
        }
        if (this.Lfh.size() == this.zbE) {
          this.Lfh.delete(((Integer)this.Lfi.remove(0)).intValue());
        }
      }
      for (;;)
      {
        this.Lfh.put(paramInt1, paramInt2);
        this.Lfi.add(Integer.valueOf(paramInt1));
        AppMethodBeat.o(159782);
        return;
        label87:
        this.Lfi.remove(Integer.valueOf(paramInt1));
      }
    }
    
    public final void clear()
    {
      AppMethodBeat.i(159784);
      this.Lfh.clear();
      this.Lfi.clear();
      AppMethodBeat.o(159784);
    }
    
    public final int get(int paramInt)
    {
      AppMethodBeat.i(159783);
      paramInt = this.Lfh.get(paramInt, -1);
      AppMethodBeat.o(159783);
      return paramInt;
    }
  }
  
  final class k
    extends DragSortListView.m
  {
    private float Lfj;
    private float Lfk;
    private float Lfl;
    private int Lfm = -1;
    private int Lfn = -1;
    private int Lfo;
    private int fSF;
    
    private k(int paramInt)
    {
      super(paramInt, (byte)0);
    }
    
    public final void cc(float paramFloat)
    {
      AppMethodBeat.i(159786);
      paramFloat = 1.0F - paramFloat;
      int j = DragSortListView.this.getFirstVisiblePosition();
      View localView = DragSortListView.this.getChildAt(this.fSF - j);
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
          this.Lfj += f2 * f1;
          DragSortListView.d(DragSortListView.this).x = ((int)this.Lfj);
          if ((this.Lfj >= k) || (this.Lfj <= -k)) {
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
        if (this.Lfm == -1)
        {
          this.Lfm = DragSortListView.b(DragSortListView.this, this.fSF, localView);
          this.Lfk = (localView.getHeight() - this.Lfm);
        }
        i = Math.max((int)(this.Lfk * paramFloat), 1);
        localObject = localView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = (i + this.Lfm);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.Lfo != this.fSF)
      {
        localView = DragSortListView.this.getChildAt(this.Lfo - j);
        if (localView != null)
        {
          if (this.Lfn == -1)
          {
            this.Lfn = DragSortListView.b(DragSortListView.this, this.Lfo, localView);
            this.Lfl = (localView.getHeight() - this.Lfn);
          }
          i = Math.max((int)(this.Lfl * paramFloat), 1);
          localObject = localView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = (i + this.Lfn);
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(159786);
    }
    
    public final void onStart()
    {
      int i = -1;
      AppMethodBeat.i(159785);
      this.Lfm = -1;
      this.Lfn = -1;
      this.fSF = DragSortListView.l(DragSortListView.this);
      this.Lfo = DragSortListView.m(DragSortListView.this);
      DragSortListView.a(DragSortListView.this, 1);
      this.Lfj = DragSortListView.d(DragSortListView.this).x;
      if (DragSortListView.n(DragSortListView.this))
      {
        float f = DragSortListView.this.getWidth() * 2.0F;
        if (DragSortListView.o(DragSortListView.this) == 0.0F)
        {
          DragSortListView localDragSortListView = DragSortListView.this;
          if (this.Lfj < 0.0F) {}
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
    private float Lfp;
    private float Lfq;
    private float Lfr;
    private float Lfs;
    private float Lft;
    private float mAlpha;
    boolean mCanceled;
    protected long mStartTime;
    
    private m(int paramInt)
    {
      AppMethodBeat.i(159788);
      this.mAlpha = 0.5F;
      this.Lfp = paramInt;
      float f = 1.0F / (this.mAlpha * 2.0F * (1.0F - this.mAlpha));
      this.Lft = f;
      this.Lfq = f;
      this.Lfr = (this.mAlpha / ((this.mAlpha - 1.0F) * 2.0F));
      this.Lfs = (1.0F / (1.0F - this.mAlpha));
      AppMethodBeat.o(159788);
    }
    
    public void cc(float paramFloat) {}
    
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
      float f1 = (float)(SystemClock.uptimeMillis() - this.mStartTime) / this.Lfp;
      if (f1 >= 1.0F)
      {
        cc(1.0F);
        onStop();
        AppMethodBeat.o(159790);
        return;
      }
      if (f1 < this.mAlpha) {
        f1 *= this.Lfq * f1;
      }
      for (;;)
      {
        cc(f1);
        DragSortListView.this.post(this);
        AppMethodBeat.o(159790);
        return;
        if (f1 < 1.0F - this.mAlpha)
        {
          float f2 = this.Lfr;
          f1 = f1 * this.Lfs + f2;
        }
        else
        {
          f1 = 1.0F - (f1 - 1.0F) * (this.Lft * (f1 - 1.0F));
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