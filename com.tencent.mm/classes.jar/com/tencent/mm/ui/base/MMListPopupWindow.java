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
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.an;

public class MMListPopupWindow
{
  private int aaV;
  public int agX;
  public int agY;
  private int agZ;
  private boolean ahb;
  private boolean ahe;
  public boolean ahf;
  int ahg;
  public View ahh;
  public int ahi;
  public View ahj;
  private Drawable ahk;
  public AdapterView.OnItemClickListener ahl;
  private AdapterView.OnItemSelectedListener ahm;
  private Runnable ahr;
  private boolean ahs;
  public o gMK;
  public boolean jpt;
  private Context mContext;
  private Handler mHandler;
  private DataSetObserver mObserver;
  private Rect mTempRect;
  private ListAdapter xw;
  private final MMListPopupWindow.f zkL;
  private final MMListPopupWindow.e zkM;
  private final MMListPopupWindow.d zkN;
  private final b zkO;
  public MMListPopupWindow.a zkP;
  
  public MMListPopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772198);
  }
  
  public MMListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(112520);
    this.zkL = new MMListPopupWindow.f(this, (byte)0);
    this.zkM = new MMListPopupWindow.e(this, (byte)0);
    this.zkN = new MMListPopupWindow.d(this, (byte)0);
    this.zkO = new b((byte)0);
    this.ahg = 2147483647;
    this.agX = -2;
    this.aaV = -2;
    this.ahe = false;
    this.ahf = false;
    this.ahi = 0;
    this.mHandler = new Handler();
    this.mTempRect = new Rect();
    this.jpt = false;
    this.mContext = paramContext;
    this.gMK = new o(paramContext);
    this.gMK.setInputMethodMode(1);
    AppMethodBeat.o(112520);
  }
  
  public final void clearListSelection()
  {
    AppMethodBeat.i(112531);
    MMListPopupWindow.a locala = this.zkP;
    if (locala != null)
    {
      MMListPopupWindow.a.a(locala, true);
      locala.requestLayout();
    }
    AppMethodBeat.o(112531);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(112527);
    this.gMK.dismiss();
    iC();
    this.gMK.setContentView(null);
    this.zkP = null;
    this.mHandler.removeCallbacks(this.zkL);
    AppMethodBeat.o(112527);
  }
  
  public final void iC()
  {
    AppMethodBeat.i(112529);
    if (this.ahh != null)
    {
      ViewParent localViewParent = this.ahh.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.ahh);
      }
    }
    AppMethodBeat.o(112529);
  }
  
  public final void iD()
  {
    AppMethodBeat.i(112530);
    this.gMK.setInputMethodMode(2);
    AppMethodBeat.o(112530);
  }
  
  public final boolean isInputMethodNotNeeded()
  {
    AppMethodBeat.i(112532);
    if (this.gMK.getInputMethodMode() == 2)
    {
      AppMethodBeat.o(112532);
      return true;
    }
    AppMethodBeat.o(112532);
    return false;
  }
  
  public final void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(112521);
    if (this.mObserver == null) {
      this.mObserver = new MMListPopupWindow.c(this, (byte)0);
    }
    for (;;)
    {
      this.xw = paramListAdapter;
      if (this.xw != null) {
        paramListAdapter.registerDataSetObserver(this.mObserver);
      }
      if (this.zkP != null) {
        this.zkP.setAdapter(this.xw);
      }
      AppMethodBeat.o(112521);
      return;
      if (this.xw != null) {
        this.xw.unregisterDataSetObserver(this.mObserver);
      }
    }
  }
  
  public final void setAnimationStyle(int paramInt)
  {
    AppMethodBeat.i(112524);
    this.gMK.setAnimationStyle(paramInt);
    AppMethodBeat.o(112524);
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(112523);
    this.gMK.setBackgroundDrawable(paramDrawable);
    AppMethodBeat.o(112523);
  }
  
  public final void setContentWidth(int paramInt)
  {
    AppMethodBeat.i(112525);
    Drawable localDrawable = this.gMK.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.mTempRect);
      this.aaV = (this.mTempRect.left + this.mTempRect.right + paramInt);
      AppMethodBeat.o(112525);
      return;
    }
    this.aaV = paramInt;
    AppMethodBeat.o(112525);
  }
  
  public final void setModal(boolean paramBoolean)
  {
    AppMethodBeat.i(112522);
    this.ahs = paramBoolean;
    this.gMK.setFocusable(this.ahs);
    AppMethodBeat.o(112522);
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(112528);
    this.gMK.setOnDismissListener(paramOnDismissListener);
    AppMethodBeat.o(112528);
  }
  
  public final void setVerticalOffset(int paramInt)
  {
    this.agZ = paramInt;
    this.ahb = true;
  }
  
  public final void show()
  {
    boolean bool3 = true;
    boolean bool2 = true;
    int n = -1;
    AppMethodBeat.i(112526);
    Object localObject2;
    boolean bool1;
    Object localObject1;
    View localView;
    FrameLayout.LayoutParams localLayoutParams1;
    FrameLayout.LayoutParams localLayoutParams2;
    if (this.zkP == null)
    {
      localObject2 = this.mContext;
      this.ahr = new MMListPopupWindow.1(this);
      if (!this.ahs)
      {
        bool1 = true;
        this.zkP = new MMListPopupWindow.a((Context)localObject2, bool1, (byte)0);
        if (this.ahk != null) {
          this.zkP.setSelector(this.ahk);
        }
        this.zkP.setAdapter(this.xw);
        this.zkP.setOnItemClickListener(this.ahl);
        this.zkP.setFocusable(true);
        this.zkP.setFocusableInTouchMode(true);
        this.zkP.setDivider(null);
        this.zkP.setDividerHeight(0);
        this.zkP.setOnItemSelectedListener(new MMListPopupWindow.2(this));
        this.zkP.setOnScrollListener(this.zkN);
        if (this.ahm != null) {
          this.zkP.setOnItemSelectedListener(this.ahm);
        }
        localObject1 = this.zkP;
        localView = this.ahh;
        if (localView == null) {
          break label1317;
        }
        iC();
        localObject2 = new FrameLayout((Context)localObject2);
        localLayoutParams1 = new FrameLayout.LayoutParams(-1, -1);
        localLayoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        switch (this.ahi)
        {
        default: 
          ak.e("ListPopupWindow", "Invalid hint position " + this.ahi, new Object[0]);
          label294:
          localView.measure(View.MeasureSpec.makeMeasureSpec(this.aaV, -2147483648), 0);
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
      this.gMK.setContentView((View)localObject1);
      int i = 0;
      for (;;)
      {
        label325:
        localObject1 = this.gMK.getBackground();
        int k;
        int i1;
        int m;
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.mTempRect);
          j = this.mTempRect.top + this.mTempRect.bottom;
          k = j;
          if (!this.ahb)
          {
            this.agZ = (-this.mTempRect.top);
            k = j;
          }
          if (this.gMK.getInputMethodMode() != 2) {
            break label772;
          }
          j = 1;
          localObject1 = this.ahj;
          i1 = this.agZ;
          localObject2 = new Rect();
          ((View)localObject1).getWindowVisibleDisplayFrame((Rect)localObject2);
          ((View)localObject1).getLocationOnScreen(new int[2]);
          m = ((Rect)localObject2).bottom;
          if (j == 0) {
            break label1306;
          }
          ((View)localObject1).getContext().getResources();
        }
        for (int j = an.hQ(((View)localObject1).getContext()).y;; j = m)
        {
          j -= i1;
          m = j;
          if (this.gMK.getBackground() != null)
          {
            this.gMK.getBackground().getPadding(this.mTempRect);
            m = j - (this.mTempRect.top + this.mTempRect.bottom);
          }
          if ((this.ahe) || (this.agX == -1))
          {
            i = m + k;
            bool1 = isInputMethodNotNeeded();
            if (!this.gMK.isShowing()) {
              break label1046;
            }
            if (this.aaV != -1) {
              break label926;
            }
            j = -1;
            label567:
            if (this.agX != -1) {
              break label995;
            }
            if (!bool1) {
              break label954;
            }
            label580:
            if (!bool1) {
              break label964;
            }
            localObject1 = this.gMK;
            if (this.aaV != -1) {
              break label959;
            }
            k = n;
            label602:
            ((o)localObject1).setWindowLayoutMode(k, 0);
            label609:
            this.gMK.update(j, i);
            localObject1 = this.gMK;
            if ((this.ahf) || (this.ahe)) {
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
            if (!this.jpt) {
              break label1018;
            }
            this.gMK.showAtLocation(this.ahj, 17, 0, 0);
            AppMethodBeat.o(112526);
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
            localObject1 = this.ahh;
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
            switch (this.aaV)
            {
            default: 
              j = View.MeasureSpec.makeMeasureSpec(this.aaV, 1073741824);
            }
            for (;;)
            {
              m = this.zkP.dy(j, m - i);
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
            if (this.aaV == -2)
            {
              j = this.ahj.getWidth();
              break label567;
            }
            j = this.aaV;
            break label567;
            i = -1;
            break label580;
            k = 0;
            break label602;
            localObject1 = this.gMK;
            if (this.aaV == -1) {}
            for (k = -1;; k = 0)
            {
              ((o)localObject1).setWindowLayoutMode(k, -1);
              break;
            }
            if (this.agX == -2) {
              break label609;
            }
            i = this.agX;
            break label609;
          }
          label1018:
          this.gMK.showAtLocation(this.ahj, 53, this.agY, this.agZ);
          AppMethodBeat.o(112526);
          return;
          if (this.aaV == -1)
          {
            j = -1;
            if (this.agX != -1) {
              break label1238;
            }
            i = -1;
            label1066:
            this.gMK.setWindowLayoutMode(j, i);
            localObject1 = this.gMK;
            if ((this.ahf) || (this.ahe)) {
              break label1276;
            }
            bool1 = bool3;
            label1099:
            ((o)localObject1).setOutsideTouchable(bool1);
            this.gMK.setTouchInterceptor(this.zkM);
            if (!this.jpt) {
              break label1282;
            }
            this.gMK.showAtLocation(this.ahj, 17, 0, 0);
          }
          for (;;)
          {
            this.zkP.setSelection(-1);
            if ((!this.ahs) || (this.zkP.isInTouchMode())) {
              clearListSelection();
            }
            if (!this.ahs) {
              this.mHandler.post(this.zkO);
            }
            AppMethodBeat.o(112526);
            return;
            if (this.aaV == -2)
            {
              this.gMK.setWidth(this.ahj.getWidth());
              j = 0;
              break;
            }
            this.gMK.setWidth(this.aaV);
            j = 0;
            break;
            label1238:
            if (this.agX == -2)
            {
              this.gMK.setHeight(i);
              i = 0;
              break label1066;
            }
            this.gMK.setHeight(this.agX);
            i = 0;
            break label1066;
            label1276:
            bool1 = false;
            break label1099;
            this.gMK.showAtLocation(this.ahj, 53, this.agY, this.agZ);
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
      AppMethodBeat.i(112513);
      MMListPopupWindow.this.clearListSelection();
      AppMethodBeat.o(112513);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMListPopupWindow
 * JD-Core Version:    0.7.0.1
 */