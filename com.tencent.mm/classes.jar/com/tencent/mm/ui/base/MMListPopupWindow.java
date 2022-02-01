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
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.b;
import com.tencent.mm.ui.av;
import com.tencent.mm.ui.ay;

public class MMListPopupWindow
{
  private final f WkF;
  private final e WkG;
  private final d WkH;
  private final b WkI;
  public MMListPopupWindow.a WkJ;
  private ListAdapter eP;
  private Context mContext;
  private Handler mHandler;
  private DataSetObserver mObserver;
  private Rect mTempRect;
  public r nmy;
  private int rj;
  public boolean rzr;
  public int sZ;
  public int ta;
  private int tb;
  private boolean td;
  private boolean tg;
  public boolean th;
  int ti;
  public View tj;
  public int tk;
  public View tl;
  private Drawable tn;
  public AdapterView.OnItemClickListener tp;
  private AdapterView.OnItemSelectedListener tq;
  private Runnable tw;
  private boolean tx;
  
  public MMListPopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.listPopupWindowStyle);
  }
  
  public MMListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(159198);
    this.WkF = new f((byte)0);
    this.WkG = new e((byte)0);
    this.WkH = new d((byte)0);
    this.WkI = new b((byte)0);
    this.ti = 2147483647;
    this.sZ = -2;
    this.rj = -2;
    this.tg = false;
    this.th = false;
    this.tk = 0;
    this.mHandler = new Handler();
    this.mTempRect = new Rect();
    this.rzr = false;
    this.mContext = paramContext;
    this.nmy = new r(paramContext);
    this.nmy.setInputMethodMode(1);
    AppMethodBeat.o(159198);
  }
  
  public final void P(boolean paramBoolean)
  {
    AppMethodBeat.i(159200);
    this.tx = paramBoolean;
    this.nmy.setFocusable(this.tx);
    AppMethodBeat.o(159200);
  }
  
  public final void ah(int paramInt)
  {
    this.tb = paramInt;
    this.td = true;
  }
  
  public final void ax(int paramInt)
  {
    AppMethodBeat.i(159202);
    this.nmy.setAnimationStyle(paramInt);
    AppMethodBeat.o(159202);
  }
  
  public final void dM()
  {
    AppMethodBeat.i(159207);
    if (this.tj != null)
    {
      ViewParent localViewParent = this.tj.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.tj);
      }
    }
    AppMethodBeat.o(159207);
  }
  
  public final void dN()
  {
    AppMethodBeat.i(159208);
    this.nmy.setInputMethodMode(2);
    AppMethodBeat.o(159208);
  }
  
  public final void dO()
  {
    AppMethodBeat.i(159209);
    MMListPopupWindow.a locala = this.WkJ;
    if (locala != null)
    {
      MMListPopupWindow.a.a(locala, true);
      locala.requestLayout();
    }
    AppMethodBeat.o(159209);
  }
  
  public final boolean dP()
  {
    AppMethodBeat.i(159210);
    if (this.nmy.getInputMethodMode() == 2)
    {
      AppMethodBeat.o(159210);
      return true;
    }
    AppMethodBeat.o(159210);
    return false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(159205);
    this.nmy.dismiss();
    dM();
    this.nmy.setContentView(null);
    this.WkJ = null;
    this.mHandler.removeCallbacks(this.WkF);
    AppMethodBeat.o(159205);
  }
  
  public final void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(159199);
    if (this.mObserver == null) {
      this.mObserver = new c((byte)0);
    }
    for (;;)
    {
      this.eP = paramListAdapter;
      if (this.eP != null) {
        paramListAdapter.registerDataSetObserver(this.mObserver);
      }
      if (this.WkJ != null) {
        this.WkJ.setAdapter(this.eP);
      }
      AppMethodBeat.o(159199);
      return;
      if (this.eP != null) {
        this.eP.unregisterDataSetObserver(this.mObserver);
      }
    }
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(159201);
    this.nmy.setBackgroundDrawable(paramDrawable);
    AppMethodBeat.o(159201);
  }
  
  public final void setContentWidth(int paramInt)
  {
    AppMethodBeat.i(159203);
    Drawable localDrawable = this.nmy.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.mTempRect);
      this.rj = (this.mTempRect.left + this.mTempRect.right + paramInt);
      AppMethodBeat.o(159203);
      return;
    }
    this.rj = paramInt;
    AppMethodBeat.o(159203);
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(159206);
    this.nmy.setOnDismissListener(paramOnDismissListener);
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
    if (this.WkJ == null)
    {
      localObject2 = this.mContext;
      this.tw = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(159182);
          View localView = MMListPopupWindow.this.tl;
          if ((localView != null) && (localView.getWindowToken() != null)) {
            MMListPopupWindow.this.show();
          }
          AppMethodBeat.o(159182);
        }
      };
      if (!this.tx)
      {
        bool1 = true;
        this.WkJ = new MMListPopupWindow.a((Context)localObject2, bool1, (byte)0);
        if (this.tn != null) {
          this.WkJ.setSelector(this.tn);
        }
        this.WkJ.setAdapter(this.eP);
        this.WkJ.setOnItemClickListener(this.tp);
        this.WkJ.setFocusable(true);
        this.WkJ.setFocusableInTouchMode(true);
        this.WkJ.setDivider(null);
        this.WkJ.setDividerHeight(0);
        this.WkJ.setOnItemSelectedListener(new MMListPopupWindow.2(this));
        this.WkJ.setOnScrollListener(this.WkH);
        if (this.tq != null) {
          this.WkJ.setOnItemSelectedListener(this.tq);
        }
        localObject1 = this.WkJ;
        localView = this.tj;
        if (localView == null) {
          break label1317;
        }
        dM();
        localObject2 = new FrameLayout((Context)localObject2);
        localLayoutParams1 = new FrameLayout.LayoutParams(-1, -1);
        localLayoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        switch (this.tk)
        {
        default: 
          av.e("ListPopupWindow", "Invalid hint position " + this.tk, new Object[0]);
          label294:
          localView.measure(View.MeasureSpec.makeMeasureSpec(this.rj, -2147483648), 0);
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
      this.nmy.setContentView((View)localObject1);
      int i = 0;
      for (;;)
      {
        label325:
        localObject1 = this.nmy.getBackground();
        int k;
        int i1;
        int m;
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.mTempRect);
          j = this.mTempRect.top + this.mTempRect.bottom;
          k = j;
          if (!this.td)
          {
            this.tb = (-this.mTempRect.top);
            k = j;
          }
          if (this.nmy.getInputMethodMode() != 2) {
            break label772;
          }
          j = 1;
          localObject1 = this.tl;
          i1 = this.tb;
          localObject2 = new Rect();
          ((View)localObject1).getWindowVisibleDisplayFrame((Rect)localObject2);
          ((View)localObject1).getLocationOnScreen(new int[2]);
          m = ((Rect)localObject2).bottom;
          if (j == 0) {
            break label1306;
          }
          ((View)localObject1).getContext().getResources();
        }
        for (int j = ay.au(((View)localObject1).getContext()).y;; j = m)
        {
          j -= i1;
          m = j;
          if (this.nmy.getBackground() != null)
          {
            this.nmy.getBackground().getPadding(this.mTempRect);
            m = j - (this.mTempRect.top + this.mTempRect.bottom);
          }
          if ((this.tg) || (this.sZ == -1))
          {
            i = m + k;
            bool1 = dP();
            if (!this.nmy.isShowing()) {
              break label1046;
            }
            if (this.rj != -1) {
              break label926;
            }
            j = -1;
            label567:
            if (this.sZ != -1) {
              break label995;
            }
            if (!bool1) {
              break label954;
            }
            label580:
            if (!bool1) {
              break label964;
            }
            localObject1 = this.nmy;
            if (this.rj != -1) {
              break label959;
            }
            k = n;
            label602:
            ((r)localObject1).setWindowLayoutMode(k, 0);
            label609:
            this.nmy.update(j, i);
            localObject1 = this.nmy;
            if ((this.th) || (this.tg)) {
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
            ((r)localObject1).setOutsideTouchable(bool1);
            if (!this.rzr) {
              break label1018;
            }
            this.nmy.showAtLocation(this.tl, 17, 0, 0);
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
            localObject1 = this.tj;
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
            switch (this.rj)
            {
            default: 
              j = View.MeasureSpec.makeMeasureSpec(this.rj, 1073741824);
            }
            for (;;)
            {
              m = this.WkJ.fk(j, m - i);
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
            if (this.rj == -2)
            {
              j = this.tl.getWidth();
              break label567;
            }
            j = this.rj;
            break label567;
            i = -1;
            break label580;
            k = 0;
            break label602;
            localObject1 = this.nmy;
            if (this.rj == -1) {}
            for (k = -1;; k = 0)
            {
              ((r)localObject1).setWindowLayoutMode(k, -1);
              break;
            }
            if (this.sZ == -2) {
              break label609;
            }
            i = this.sZ;
            break label609;
          }
          label1018:
          this.nmy.showAtLocation(this.tl, 53, this.ta, this.tb);
          AppMethodBeat.o(159204);
          return;
          if (this.rj == -1)
          {
            j = -1;
            if (this.sZ != -1) {
              break label1238;
            }
            i = -1;
            label1066:
            this.nmy.setWindowLayoutMode(j, i);
            localObject1 = this.nmy;
            if ((this.th) || (this.tg)) {
              break label1276;
            }
            bool1 = bool3;
            label1099:
            ((r)localObject1).setOutsideTouchable(bool1);
            this.nmy.setTouchInterceptor(this.WkG);
            if (!this.rzr) {
              break label1282;
            }
            this.nmy.showAtLocation(this.tl, 17, 0, 0);
          }
          for (;;)
          {
            this.WkJ.setSelection(-1);
            if ((!this.tx) || (this.WkJ.isInTouchMode())) {
              dO();
            }
            if (!this.tx) {
              this.mHandler.post(this.WkI);
            }
            AppMethodBeat.o(159204);
            return;
            if (this.rj == -2)
            {
              this.nmy.setWidth(this.tl.getWidth());
              j = 0;
              break;
            }
            this.nmy.setWidth(this.rj);
            j = 0;
            break;
            label1238:
            if (this.sZ == -2)
            {
              this.nmy.setHeight(i);
              i = 0;
              break label1066;
            }
            this.nmy.setHeight(this.sZ);
            i = 0;
            break label1066;
            label1276:
            bool1 = false;
            break label1099;
            this.nmy.showAtLocation(this.tl, 53, this.ta, this.tb);
          }
        }
        i = 0;
      }
    }
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(159191);
      MMListPopupWindow.this.dO();
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
      if (MMListPopupWindow.this.nmy.isShowing()) {
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
      if ((paramInt == 1) && (!MMListPopupWindow.this.dP()) && (MMListPopupWindow.b(MMListPopupWindow.this).getContentView() != null))
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
      if ((MMListPopupWindow.a(MMListPopupWindow.this) != null) && (MMListPopupWindow.a(MMListPopupWindow.this).getCount() > MMListPopupWindow.a(MMListPopupWindow.this).getChildCount()) && (MMListPopupWindow.a(MMListPopupWindow.this).getChildCount() <= MMListPopupWindow.this.ti))
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