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
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.aq;

public class MMListPopupWindow
{
  private ListAdapter DP;
  private final f FYi;
  private final e FYj;
  private final d FYk;
  private final b FYl;
  public a FYm;
  private int aib;
  public int aoe;
  public int aof;
  private int aog;
  private boolean aoi;
  private boolean aol;
  public boolean aom;
  int aon;
  public View aoo;
  public int aop;
  public View aoq;
  private Drawable aor;
  public AdapterView.OnItemClickListener aos;
  private AdapterView.OnItemSelectedListener aot;
  private Runnable aoy;
  private boolean aoz;
  public o iAs;
  private Context mContext;
  private Handler mHandler;
  private DataSetObserver mObserver;
  private Rect mTempRect;
  public boolean mfl;
  
  public MMListPopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969239);
  }
  
  public MMListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(159198);
    this.FYi = new f((byte)0);
    this.FYj = new e((byte)0);
    this.FYk = new d((byte)0);
    this.FYl = new b((byte)0);
    this.aon = 2147483647;
    this.aoe = -2;
    this.aib = -2;
    this.aol = false;
    this.aom = false;
    this.aop = 0;
    this.mHandler = new Handler();
    this.mTempRect = new Rect();
    this.mfl = false;
    this.mContext = paramContext;
    this.iAs = new o(paramContext);
    this.iAs.setInputMethodMode(1);
    AppMethodBeat.o(159198);
  }
  
  public final void clearListSelection()
  {
    AppMethodBeat.i(159209);
    a locala = this.FYm;
    if (locala != null)
    {
      a.a(locala, true);
      locala.requestLayout();
    }
    AppMethodBeat.o(159209);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(159205);
    this.iAs.dismiss();
    jX();
    this.iAs.setContentView(null);
    this.FYm = null;
    this.mHandler.removeCallbacks(this.FYi);
    AppMethodBeat.o(159205);
  }
  
  public final boolean isInputMethodNotNeeded()
  {
    AppMethodBeat.i(159210);
    if (this.iAs.getInputMethodMode() == 2)
    {
      AppMethodBeat.o(159210);
      return true;
    }
    AppMethodBeat.o(159210);
    return false;
  }
  
  public final void jX()
  {
    AppMethodBeat.i(159207);
    if (this.aoo != null)
    {
      ViewParent localViewParent = this.aoo.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.aoo);
      }
    }
    AppMethodBeat.o(159207);
  }
  
  public final void jY()
  {
    AppMethodBeat.i(159208);
    this.iAs.setInputMethodMode(2);
    AppMethodBeat.o(159208);
  }
  
  public final void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(159199);
    if (this.mObserver == null) {
      this.mObserver = new c((byte)0);
    }
    for (;;)
    {
      this.DP = paramListAdapter;
      if (this.DP != null) {
        paramListAdapter.registerDataSetObserver(this.mObserver);
      }
      if (this.FYm != null) {
        this.FYm.setAdapter(this.DP);
      }
      AppMethodBeat.o(159199);
      return;
      if (this.DP != null) {
        this.DP.unregisterDataSetObserver(this.mObserver);
      }
    }
  }
  
  public final void setAnimationStyle(int paramInt)
  {
    AppMethodBeat.i(159202);
    this.iAs.setAnimationStyle(paramInt);
    AppMethodBeat.o(159202);
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(159201);
    this.iAs.setBackgroundDrawable(paramDrawable);
    AppMethodBeat.o(159201);
  }
  
  public final void setContentWidth(int paramInt)
  {
    AppMethodBeat.i(159203);
    Drawable localDrawable = this.iAs.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.mTempRect);
      this.aib = (this.mTempRect.left + this.mTempRect.right + paramInt);
      AppMethodBeat.o(159203);
      return;
    }
    this.aib = paramInt;
    AppMethodBeat.o(159203);
  }
  
  public final void setModal(boolean paramBoolean)
  {
    AppMethodBeat.i(159200);
    this.aoz = paramBoolean;
    this.iAs.setFocusable(this.aoz);
    AppMethodBeat.o(159200);
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(159206);
    this.iAs.setOnDismissListener(paramOnDismissListener);
    AppMethodBeat.o(159206);
  }
  
  public final void setVerticalOffset(int paramInt)
  {
    this.aog = paramInt;
    this.aoi = true;
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
    if (this.FYm == null)
    {
      localObject2 = this.mContext;
      this.aoy = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(159182);
          View localView = MMListPopupWindow.this.aoq;
          if ((localView != null) && (localView.getWindowToken() != null)) {
            MMListPopupWindow.this.show();
          }
          AppMethodBeat.o(159182);
        }
      };
      if (!this.aoz)
      {
        bool1 = true;
        this.FYm = new a((Context)localObject2, bool1, (byte)0);
        if (this.aor != null) {
          this.FYm.setSelector(this.aor);
        }
        this.FYm.setAdapter(this.DP);
        this.FYm.setOnItemClickListener(this.aos);
        this.FYm.setFocusable(true);
        this.FYm.setFocusableInTouchMode(true);
        this.FYm.setDivider(null);
        this.FYm.setDividerHeight(0);
        this.FYm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(159183);
            if (paramAnonymousInt != -1)
            {
              paramAnonymousAdapterView = MMListPopupWindow.a(MMListPopupWindow.this);
              if (paramAnonymousAdapterView != null) {
                MMListPopupWindow.a.a(paramAnonymousAdapterView, false);
              }
            }
            AppMethodBeat.o(159183);
          }
          
          public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
        });
        this.FYm.setOnScrollListener(this.FYk);
        if (this.aot != null) {
          this.FYm.setOnItemSelectedListener(this.aot);
        }
        localObject1 = this.FYm;
        localView = this.aoo;
        if (localView == null) {
          break label1317;
        }
        jX();
        localObject2 = new FrameLayout((Context)localObject2);
        localLayoutParams1 = new FrameLayout.LayoutParams(-1, -1);
        localLayoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        switch (this.aop)
        {
        default: 
          an.e("ListPopupWindow", "Invalid hint position " + this.aop, new Object[0]);
          label294:
          localView.measure(View.MeasureSpec.makeMeasureSpec(this.aib, -2147483648), 0);
          localObject1 = localObject2;
        }
      }
    }
    label388:
    label401:
    label926:
    label1312:
    label1317:
    for (;;)
    {
      this.iAs.setContentView((View)localObject1);
      int i = 0;
      for (;;)
      {
        label325:
        localObject1 = this.iAs.getBackground();
        int k;
        int i1;
        int m;
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.mTempRect);
          j = this.mTempRect.top + this.mTempRect.bottom;
          k = j;
          if (!this.aoi)
          {
            this.aog = (-this.mTempRect.top);
            k = j;
          }
          if (this.iAs.getInputMethodMode() != 2) {
            break label772;
          }
          j = 1;
          localObject1 = this.aoq;
          i1 = this.aog;
          localObject2 = new Rect();
          ((View)localObject1).getWindowVisibleDisplayFrame((Rect)localObject2);
          ((View)localObject1).getLocationOnScreen(new int[2]);
          m = ((Rect)localObject2).bottom;
          if (j == 0) {
            break label1306;
          }
          ((View)localObject1).getContext().getResources();
        }
        for (int j = aq.cf(((View)localObject1).getContext()).y;; j = m)
        {
          j -= i1;
          m = j;
          if (this.iAs.getBackground() != null)
          {
            this.iAs.getBackground().getPadding(this.mTempRect);
            m = j - (this.mTempRect.top + this.mTempRect.bottom);
          }
          if ((this.aol) || (this.aoe == -1))
          {
            i = m + k;
            bool1 = isInputMethodNotNeeded();
            if (!this.iAs.isShowing()) {
              break label1046;
            }
            if (this.aib != -1) {
              break label926;
            }
            j = -1;
            label567:
            if (this.aoe != -1) {
              break label995;
            }
            if (!bool1) {
              break label954;
            }
            label580:
            if (!bool1) {
              break label964;
            }
            localObject1 = this.iAs;
            if (this.aib != -1) {
              break label959;
            }
            k = n;
            label602:
            ((o)localObject1).setWindowLayoutMode(k, 0);
            label609:
            this.iAs.update(j, i);
            localObject1 = this.iAs;
            if ((this.aom) || (this.aol)) {
              break label1012;
            }
          }
          label954:
          label959:
          label964:
          label995:
          label1012:
          for (bool1 = bool2;; bool1 = false)
          {
            ((o)localObject1).setOutsideTouchable(bool1);
            if (!this.mfl) {
              break label1018;
            }
            this.iAs.showAtLocation(this.aoq, 17, 0, 0);
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
            localObject1 = this.aoo;
            if (localObject1 == null) {
              break label1312;
            }
            i = ((View)localObject1).getMeasuredHeight();
            break label325;
            this.mTempRect.setEmpty();
            k = 0;
            break label388;
            j = 0;
            break label401;
            switch (this.aib)
            {
            default: 
              j = View.MeasureSpec.makeMeasureSpec(this.aib, 1073741824);
            }
            for (;;)
            {
              m = this.FYm.et(j, m - i);
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
            if (this.aib == -2)
            {
              j = this.aoq.getWidth();
              break label567;
            }
            j = this.aib;
            break label567;
            i = -1;
            break label580;
            k = 0;
            break label602;
            localObject1 = this.iAs;
            if (this.aib == -1) {}
            for (k = -1;; k = 0)
            {
              ((o)localObject1).setWindowLayoutMode(k, -1);
              break;
            }
            if (this.aoe == -2) {
              break label609;
            }
            i = this.aoe;
            break label609;
          }
          label1018:
          this.iAs.showAtLocation(this.aoq, 53, this.aof, this.aog);
          AppMethodBeat.o(159204);
          return;
          if (this.aib == -1)
          {
            j = -1;
            if (this.aoe != -1) {
              break label1238;
            }
            i = -1;
            label1066:
            this.iAs.setWindowLayoutMode(j, i);
            localObject1 = this.iAs;
            if ((this.aom) || (this.aol)) {
              break label1276;
            }
            bool1 = bool3;
            label1099:
            ((o)localObject1).setOutsideTouchable(bool1);
            this.iAs.setTouchInterceptor(this.FYj);
            if (!this.mfl) {
              break label1282;
            }
            this.iAs.showAtLocation(this.aoq, 17, 0, 0);
          }
          for (;;)
          {
            this.FYm.setSelection(-1);
            if ((!this.aoz) || (this.FYm.isInTouchMode())) {
              clearListSelection();
            }
            if (!this.aoz) {
              this.mHandler.post(this.FYl);
            }
            AppMethodBeat.o(159204);
            return;
            if (this.aib == -2)
            {
              this.iAs.setWidth(this.aoq.getWidth());
              j = 0;
              break;
            }
            this.iAs.setWidth(this.aib);
            j = 0;
            break;
            label1238:
            if (this.aoe == -2)
            {
              this.iAs.setHeight(i);
              i = 0;
              break label1066;
            }
            this.iAs.setHeight(this.aoe);
            i = 0;
            break label1066;
            label1276:
            bool1 = false;
            break label1099;
            this.iAs.showAtLocation(this.aoq, 53, this.aof, this.aog);
          }
        }
        i = 0;
      }
    }
  }
  
  static final class a
    extends ListView
  {
    private boolean akc;
    private boolean akd;
    
    private a(Context paramContext, boolean paramBoolean)
    {
      super(null, 2130968938);
      AppMethodBeat.i(159184);
      this.akd = paramBoolean;
      setCacheColorHint(0);
      AppMethodBeat.o(159184);
    }
    
    final int et(int paramInt1, int paramInt2)
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
      if ((this.akd) || (super.hasFocus()))
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
      if ((this.akd) || (super.hasWindowFocus()))
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
      if ((this.akd) || (super.isFocused()))
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
      if (((this.akd) && (this.akc)) || (super.isInTouchMode()))
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
      MMListPopupWindow.this.clearListSelection();
      AppMethodBeat.o(159191);
    }
  }
  
  final class c
    extends DataSetObserver
  {
    private c() {}
    
    public final void onChanged()
    {
      AppMethodBeat.i(159192);
      if (MMListPopupWindow.this.iAs.isShowing()) {
        MMListPopupWindow.this.show();
      }
      AppMethodBeat.o(159192);
    }
    
    public final void onInvalidated()
    {
      AppMethodBeat.i(159193);
      MMListPopupWindow.this.dismiss();
      AppMethodBeat.o(159193);
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
      if ((paramInt == 1) && (!MMListPopupWindow.this.isInputMethodNotNeeded()) && (MMListPopupWindow.b(MMListPopupWindow.this).getContentView() != null))
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
      if ((MMListPopupWindow.a(MMListPopupWindow.this) != null) && (MMListPopupWindow.a(MMListPopupWindow.this).getCount() > MMListPopupWindow.a(MMListPopupWindow.this).getChildCount()) && (MMListPopupWindow.a(MMListPopupWindow.this).getChildCount() <= MMListPopupWindow.this.aon))
      {
        MMListPopupWindow.b(MMListPopupWindow.this).setInputMethodMode(2);
        MMListPopupWindow.this.show();
      }
      AppMethodBeat.o(159197);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMListPopupWindow
 * JD-Core Version:    0.7.0.1
 */