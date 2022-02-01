package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.b;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.bc;
import com.tencent.mm.ui.bg;

public class MMListPopupWindow
{
  private final f adRM;
  private final e adRN;
  private final d adRO;
  private final b adRP;
  public a adRQ;
  private ListAdapter fR;
  private Context mContext;
  private Handler mHandler;
  private DataSetObserver mObserver;
  private Rect mTempRect;
  public v qjH;
  private int sh;
  public int tY;
  public int tZ;
  public boolean uKu;
  private int ua;
  private boolean uc;
  private boolean uf;
  public boolean ug;
  int uh;
  public View uj;
  public int uk;
  public View ul;
  private Drawable um;
  public AdapterView.OnItemClickListener un;
  private AdapterView.OnItemSelectedListener uo;
  private Runnable uv;
  private boolean uw;
  
  public MMListPopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.listPopupWindowStyle);
  }
  
  public MMListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(159198);
    this.adRM = new f((byte)0);
    this.adRN = new e((byte)0);
    this.adRO = new d((byte)0);
    this.adRP = new b((byte)0);
    this.uh = 2147483647;
    this.tY = -2;
    this.sh = -2;
    this.uf = false;
    this.ug = false;
    this.uk = 0;
    this.mHandler = new Handler();
    this.mTempRect = new Rect();
    this.uKu = false;
    this.mContext = paramContext;
    this.qjH = new v(paramContext);
    this.qjH.setInputMethodMode(1);
    AppMethodBeat.o(159198);
  }
  
  public final void LA(boolean paramBoolean)
  {
    AppMethodBeat.i(159200);
    this.uw = paramBoolean;
    this.qjH.setFocusable(this.uw);
    AppMethodBeat.o(159200);
  }
  
  public final void aAU(int paramInt)
  {
    AppMethodBeat.i(159202);
    this.qjH.setAnimationStyle(paramInt);
    AppMethodBeat.o(159202);
  }
  
  public final void ad(int paramInt)
  {
    this.ua = paramInt;
    this.uc = true;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(159205);
    this.qjH.dismiss();
    eM();
    this.qjH.setContentView(null);
    this.adRQ = null;
    this.mHandler.removeCallbacks(this.adRM);
    AppMethodBeat.o(159205);
  }
  
  public final void eM()
  {
    AppMethodBeat.i(159207);
    if (this.uj != null)
    {
      ViewParent localViewParent = this.uj.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.uj);
      }
    }
    AppMethodBeat.o(159207);
  }
  
  public final void eN()
  {
    AppMethodBeat.i(159208);
    this.qjH.setInputMethodMode(2);
    AppMethodBeat.o(159208);
  }
  
  public final void eO()
  {
    AppMethodBeat.i(159209);
    a locala = this.adRQ;
    if (locala != null)
    {
      a.a(locala, true);
      locala.requestLayout();
    }
    AppMethodBeat.o(159209);
  }
  
  public final boolean eP()
  {
    AppMethodBeat.i(159210);
    if (this.qjH.getInputMethodMode() == 2)
    {
      AppMethodBeat.o(159210);
      return true;
    }
    AppMethodBeat.o(159210);
    return false;
  }
  
  public final void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(159199);
    if (this.mObserver == null) {
      this.mObserver = new MMListPopupWindow.c(this, (byte)0);
    }
    for (;;)
    {
      this.fR = paramListAdapter;
      if (this.fR != null) {
        paramListAdapter.registerDataSetObserver(this.mObserver);
      }
      if (this.adRQ != null) {
        this.adRQ.setAdapter(this.fR);
      }
      AppMethodBeat.o(159199);
      return;
      if (this.fR != null) {
        this.fR.unregisterDataSetObserver(this.mObserver);
      }
    }
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(159201);
    this.qjH.setBackgroundDrawable(paramDrawable);
    AppMethodBeat.o(159201);
  }
  
  public final void setContentWidth(int paramInt)
  {
    AppMethodBeat.i(159203);
    Drawable localDrawable = this.qjH.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.mTempRect);
      this.sh = (this.mTempRect.left + this.mTempRect.right + paramInt);
      AppMethodBeat.o(159203);
      return;
    }
    this.sh = paramInt;
    AppMethodBeat.o(159203);
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(159206);
    this.qjH.setOnDismissListener(paramOnDismissListener);
    AppMethodBeat.o(159206);
  }
  
  public final void show()
  {
    boolean bool3 = true;
    boolean bool2 = true;
    int n = -1;
    AppMethodBeat.i(159204);
    Object localObject2;
    boolean bool1;
    Object localObject1;
    View localView;
    FrameLayout.LayoutParams localLayoutParams1;
    FrameLayout.LayoutParams localLayoutParams2;
    if (this.adRQ == null)
    {
      localObject2 = this.mContext;
      this.uv = new MMListPopupWindow.1(this);
      if (!this.uw)
      {
        bool1 = true;
        this.adRQ = new a((Context)localObject2, bool1, (byte)0);
        if (this.um != null) {
          this.adRQ.setSelector(this.um);
        }
        this.adRQ.setAdapter(this.fR);
        this.adRQ.setOnItemClickListener(this.un);
        this.adRQ.setFocusable(true);
        this.adRQ.setFocusableInTouchMode(true);
        this.adRQ.setDivider(null);
        this.adRQ.setDividerHeight(0);
        this.adRQ.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(159183);
            b localb = new b();
            localb.cH(paramAnonymousAdapterView);
            localb.cH(paramAnonymousView);
            localb.sc(paramAnonymousInt);
            localb.hB(paramAnonymousLong);
            a.c("com/tencent/mm/ui/base/MMListPopupWindow$2", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
            if (paramAnonymousInt != -1)
            {
              paramAnonymousAdapterView = MMListPopupWindow.a(MMListPopupWindow.this);
              if (paramAnonymousAdapterView != null) {
                MMListPopupWindow.a.a(paramAnonymousAdapterView, false);
              }
            }
            a.a(this, "com/tencent/mm/ui/base/MMListPopupWindow$2", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(159183);
          }
          
          public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
        });
        this.adRQ.setOnScrollListener(this.adRO);
        if (this.uo != null) {
          this.adRQ.setOnItemSelectedListener(this.uo);
        }
        localObject1 = this.adRQ;
        localView = this.uj;
        if (localView == null) {
          break label1325;
        }
        eM();
        localObject2 = new FrameLayout((Context)localObject2);
        localLayoutParams1 = new FrameLayout.LayoutParams(-1, -1);
        localLayoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        switch (this.uk)
        {
        default: 
          bc.e("ListPopupWindow", "Invalid hint position " + this.uk, new Object[0]);
          label294:
          localView.measure(View.MeasureSpec.makeMeasureSpec(this.sh, -2147483648), 0);
          localObject1 = localObject2;
        }
      }
    }
    label388:
    label401:
    label934:
    label1320:
    label1325:
    for (;;)
    {
      this.qjH.setContentView((View)localObject1);
      int i = 0;
      for (;;)
      {
        label325:
        localObject1 = this.qjH.getBackground();
        int k;
        int i1;
        int m;
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.mTempRect);
          j = this.mTempRect.top + this.mTempRect.bottom;
          k = j;
          if (!this.uc)
          {
            this.ua = (-this.mTempRect.top);
            k = j;
          }
          if (this.qjH.getInputMethodMode() != 2) {
            break label781;
          }
          j = 1;
          localObject1 = this.ul;
          i1 = this.ua;
          localObject2 = new Rect();
          ((View)localObject1).getWindowVisibleDisplayFrame((Rect)localObject2);
          ((View)localObject1).getLocationOnScreen(new int[2]);
          m = ((Rect)localObject2).bottom;
          if (j == 0) {
            break label1314;
          }
          ((View)localObject1).getContext().getResources();
          localObject1 = bg.bf(((View)localObject1).getContext());
          if (localObject1 == null) {
            break label1314;
          }
        }
        for (int j = ((Point)localObject1).y;; j = m)
        {
          j -= i1;
          m = j;
          if (this.qjH.getBackground() != null)
          {
            this.qjH.getBackground().getPadding(this.mTempRect);
            m = j - (this.mTempRect.top + this.mTempRect.bottom);
          }
          if ((this.uf) || (this.tY == -1))
          {
            i = m + k;
            bool1 = eP();
            if (!this.qjH.isShowing()) {
              break label1054;
            }
            if (this.sh != -1) {
              break label934;
            }
            j = -1;
            label576:
            if (this.tY != -1) {
              break label1003;
            }
            if (!bool1) {
              break label962;
            }
            label589:
            if (!bool1) {
              break label972;
            }
            localObject1 = this.qjH;
            if (this.sh != -1) {
              break label967;
            }
            k = n;
            label611:
            ((v)localObject1).setWindowLayoutMode(k, 0);
            label618:
            this.qjH.update(j, i);
            localObject1 = this.qjH;
            if ((this.ug) || (this.uf)) {
              break label1020;
            }
          }
          label962:
          label967:
          label972:
          label1003:
          label1020:
          for (bool1 = bool2;; bool1 = false)
          {
            ((v)localObject1).setOutsideTouchable(bool1);
            if (!this.uKu) {
              break label1026;
            }
            this.qjH.showAtLocation(this.ul, 17, 0, 0);
            AppMethodBeat.o(159204);
            return;
            bool1 = false;
            break;
            localLayoutParams2.gravity = 80;
            ((FrameLayout)localObject2).addView((View)localObject1, localLayoutParams1);
            ((FrameLayout)localObject2).addView(localView, localLayoutParams2);
            break label294;
            localLayoutParams2.gravity = 48;
            ((FrameLayout)localObject2).addView((View)localObject1, localLayoutParams1);
            ((FrameLayout)localObject2).addView(localView, localLayoutParams2);
            break label294;
            localObject1 = this.uj;
            if (localObject1 == null) {
              break label1320;
            }
            i = ((View)localObject1).getMeasuredHeight();
            break label325;
            this.mTempRect.setEmpty();
            k = 0;
            break label388;
            j = 0;
            break label401;
            switch (this.sh)
            {
            default: 
              j = View.MeasureSpec.makeMeasureSpec(this.sh, 1073741824);
            }
            for (;;)
            {
              m = this.adRQ.gd(j, m - i);
              j = i;
              if (m > 0) {
                j = i + k;
              }
              i = j + m;
              break;
              j = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), -2147483648);
              continue;
              j = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), 1073741824);
            }
            if (this.sh == -2)
            {
              j = this.ul.getWidth();
              break label576;
            }
            j = this.sh;
            break label576;
            i = -1;
            break label589;
            k = 0;
            break label611;
            localObject1 = this.qjH;
            if (this.sh == -1) {}
            for (k = -1;; k = 0)
            {
              ((v)localObject1).setWindowLayoutMode(k, -1);
              break;
            }
            if (this.tY == -2) {
              break label618;
            }
            i = this.tY;
            break label618;
          }
          this.qjH.showAtLocation(this.ul, 53, this.tZ, this.ua);
          AppMethodBeat.o(159204);
          return;
          if (this.sh == -1)
          {
            j = -1;
            if (this.tY != -1) {
              break label1246;
            }
            i = -1;
            label1074:
            this.qjH.setWindowLayoutMode(j, i);
            localObject1 = this.qjH;
            if ((this.ug) || (this.uf)) {
              break label1284;
            }
            bool1 = bool3;
            label1107:
            ((v)localObject1).setOutsideTouchable(bool1);
            this.qjH.setTouchInterceptor(this.adRN);
            if (!this.uKu) {
              break label1290;
            }
            this.qjH.showAtLocation(this.ul, 17, 0, 0);
          }
          for (;;)
          {
            this.adRQ.setSelection(-1);
            if ((!this.uw) || (this.adRQ.isInTouchMode())) {
              eO();
            }
            if (!this.uw) {
              this.mHandler.post(this.adRP);
            }
            AppMethodBeat.o(159204);
            return;
            if (this.sh == -2)
            {
              this.qjH.setWidth(this.ul.getWidth());
              j = 0;
              break;
            }
            this.qjH.setWidth(this.sh);
            j = 0;
            break;
            label1246:
            if (this.tY == -2)
            {
              this.qjH.setHeight(i);
              i = 0;
              break label1074;
            }
            this.qjH.setHeight(this.tY);
            i = 0;
            break label1074;
            bool1 = false;
            break label1107;
            this.qjH.showAtLocation(this.ul, 53, this.tZ, this.ua);
          }
        }
        i = 0;
      }
    }
  }
  
  static final class a
    extends ListView
  {
    private boolean tn;
    private boolean tp;
    
    private a(Context paramContext, boolean paramBoolean)
    {
      super(null, a.b.dropDownListViewStyle);
      AppMethodBeat.i(159184);
      this.tp = paramBoolean;
      setCacheColorHint(0);
      AppMethodBeat.o(159184);
    }
    
    final int gd(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(159189);
      int i = getListPaddingTop();
      int j = getListPaddingBottom();
      int m = getDividerHeight();
      Object localObject = getDivider();
      ListAdapter localListAdapter = getAdapter();
      if (localListAdapter == null)
      {
        AppMethodBeat.o(159189);
        return i + j;
      }
      i += j;
      int n;
      label82:
      int k;
      if ((m > 0) && (localObject != null))
      {
        int i1 = localListAdapter.getCount();
        n = 0;
        j = 0;
        localObject = null;
        if (n >= i1) {
          break label244;
        }
        k = localListAdapter.getItemViewType(n);
        if (k == j) {
          break label251;
        }
        localObject = null;
        j = k;
      }
      label136:
      label225:
      label235:
      label244:
      label251:
      for (;;)
      {
        localObject = localListAdapter.getView(n, (View)localObject, this);
        if (localObject == null)
        {
          k = 0;
          if (k <= 0) {
            break label225;
          }
        }
        for (k = View.MeasureSpec.makeMeasureSpec(k, 1073741824);; k = View.MeasureSpec.makeMeasureSpec(0, 0))
        {
          if (localObject != null) {
            ((View)localObject).measure(paramInt1, k);
          }
          k = i;
          if (n > 0) {
            k = i + m;
          }
          i = k;
          if (localObject != null) {
            i = k + ((View)localObject).getMeasuredHeight();
          }
          if (i < paramInt2) {
            break label235;
          }
          AppMethodBeat.o(159189);
          return paramInt2;
          m = 0;
          break;
          k = ((View)localObject).getLayoutParams().height;
          break label136;
        }
        n += 1;
        break label82;
        AppMethodBeat.o(159189);
        return i;
      }
    }
    
    public final boolean hasFocus()
    {
      AppMethodBeat.i(159188);
      if ((this.tp) || (super.hasFocus()))
      {
        AppMethodBeat.o(159188);
        return true;
      }
      AppMethodBeat.o(159188);
      return false;
    }
    
    public final boolean hasWindowFocus()
    {
      AppMethodBeat.i(159186);
      if ((this.tp) || (super.hasWindowFocus()))
      {
        AppMethodBeat.o(159186);
        return true;
      }
      AppMethodBeat.o(159186);
      return false;
    }
    
    public final boolean isFocused()
    {
      AppMethodBeat.i(159187);
      if ((this.tp) || (super.isFocused()))
      {
        AppMethodBeat.o(159187);
        return true;
      }
      AppMethodBeat.o(159187);
      return false;
    }
    
    public final boolean isInTouchMode()
    {
      AppMethodBeat.i(159185);
      if (((this.tp) && (this.tn)) || (super.isInTouchMode()))
      {
        AppMethodBeat.o(159185);
        return true;
      }
      AppMethodBeat.o(159185);
      return false;
    }
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(159191);
      MMListPopupWindow.this.eO();
      AppMethodBeat.o(159191);
    }
  }
  
  final class d
    implements AbsListView.OnScrollListener
  {
    private d() {}
    
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(159194);
      if ((MMListPopupWindow.a(MMListPopupWindow.this) != null) && (MMListPopupWindow.e(MMListPopupWindow.this) != null) && (MMListPopupWindow.f(MMListPopupWindow.this) != null) && (MMListPopupWindow.a(MMListPopupWindow.this) != null))
      {
        if ((MMListPopupWindow.a(MMListPopupWindow.this).getLastVisiblePosition() == MMListPopupWindow.f(MMListPopupWindow.this).getCount() - 1) && (MMListPopupWindow.a(MMListPopupWindow.this).getChildAt(MMListPopupWindow.a(MMListPopupWindow.this).getChildCount() - 1) != null) && (MMListPopupWindow.a(MMListPopupWindow.this).getChildAt(MMListPopupWindow.a(MMListPopupWindow.this).getChildCount() - 1).getBottom() <= MMListPopupWindow.a(MMListPopupWindow.this).getHeight()))
        {
          MMListPopupWindow.e(MMListPopupWindow.this).setVisibility(8);
          AppMethodBeat.o(159194);
          return;
        }
        MMListPopupWindow.e(MMListPopupWindow.this).setVisibility(0);
      }
      AppMethodBeat.o(159194);
    }
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(159195);
      if ((paramInt == 1) && (!MMListPopupWindow.this.eP()) && (MMListPopupWindow.b(MMListPopupWindow.this).getContentView() != null))
      {
        MMListPopupWindow.d(MMListPopupWindow.this).removeCallbacks(MMListPopupWindow.c(MMListPopupWindow.this));
        MMListPopupWindow.c(MMListPopupWindow.this).run();
      }
      AppMethodBeat.o(159195);
    }
  }
  
  final class e
    implements View.OnTouchListener
  {
    private e() {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(159196);
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if ((i == 0) && (MMListPopupWindow.b(MMListPopupWindow.this) != null) && (MMListPopupWindow.b(MMListPopupWindow.this).isShowing()) && (j >= 0) && (j < MMListPopupWindow.b(MMListPopupWindow.this).getWidth()) && (k >= 0) && (k < MMListPopupWindow.b(MMListPopupWindow.this).getHeight())) {
        MMListPopupWindow.d(MMListPopupWindow.this).postDelayed(MMListPopupWindow.c(MMListPopupWindow.this), 250L);
      }
      for (;;)
      {
        AppMethodBeat.o(159196);
        return false;
        if (i == 1) {
          MMListPopupWindow.d(MMListPopupWindow.this).removeCallbacks(MMListPopupWindow.c(MMListPopupWindow.this));
        }
      }
    }
  }
  
  final class f
    implements Runnable
  {
    private f() {}
    
    public final void run()
    {
      AppMethodBeat.i(159197);
      if ((MMListPopupWindow.a(MMListPopupWindow.this) != null) && (MMListPopupWindow.a(MMListPopupWindow.this).getCount() > MMListPopupWindow.a(MMListPopupWindow.this).getChildCount()) && (MMListPopupWindow.a(MMListPopupWindow.this).getChildCount() <= MMListPopupWindow.this.uh))
      {
        MMListPopupWindow.b(MMListPopupWindow.this).setInputMethodMode(2);
        MMListPopupWindow.this.show();
      }
      AppMethodBeat.o(159197);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMListPopupWindow
 * JD-Core Version:    0.7.0.1
 */