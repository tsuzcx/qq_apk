package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
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
import com.tencent.mm.ci.a.b;
import com.tencent.mm.ui.ao;

public class MMListPopupWindow
{
  private ListAdapter NK;
  private int aal = -2;
  public int aeI = -2;
  public int aeJ;
  private int aeK;
  private boolean aeM;
  private boolean aeP = false;
  private boolean aeQ = false;
  int aeR = 2147483647;
  public View aeS;
  public int aeT = 0;
  public View aeU;
  private Drawable aeV;
  public AdapterView.OnItemClickListener aeW;
  private AdapterView.OnItemSelectedListener aeX;
  private Runnable afc;
  private boolean afd;
  private Rect ec = new Rect();
  public o fvf;
  public boolean hxj = false;
  private Context mContext;
  private Handler mHandler = new Handler();
  private DataSetObserver mObserver;
  private final MMListPopupWindow.f uWs = new MMListPopupWindow.f(this, (byte)0);
  private final MMListPopupWindow.e uWt = new MMListPopupWindow.e(this, (byte)0);
  private final MMListPopupWindow.d uWu = new MMListPopupWindow.d(this, (byte)0);
  private final b uWv = new b((byte)0);
  public MMListPopupWindow.a uWw;
  
  public MMListPopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.listPopupWindowStyle);
  }
  
  public MMListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.mContext = paramContext;
    this.fvf = new o(paramContext);
    this.fvf.setInputMethodMode(1);
  }
  
  public final void asA()
  {
    if (this.aeS != null)
    {
      ViewParent localViewParent = this.aeS.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.aeS);
      }
    }
  }
  
  public final void cAM()
  {
    this.afd = true;
    this.fvf.setFocusable(true);
  }
  
  public final void clearListSelection()
  {
    MMListPopupWindow.a locala = this.uWw;
    if (locala != null)
    {
      MMListPopupWindow.a.a(locala, true);
      locala.requestLayout();
    }
  }
  
  public final void dismiss()
  {
    this.fvf.dismiss();
    asA();
    this.fvf.setContentView(null);
    this.uWw = null;
    this.mHandler.removeCallbacks(this.uWs);
  }
  
  public final void hf()
  {
    this.fvf.setInputMethodMode(2);
  }
  
  public final boolean isInputMethodNotNeeded()
  {
    return this.fvf.getInputMethodMode() == 2;
  }
  
  public final void setAdapter(ListAdapter paramListAdapter)
  {
    if (this.mObserver == null) {
      this.mObserver = new MMListPopupWindow.c(this, (byte)0);
    }
    for (;;)
    {
      this.NK = paramListAdapter;
      if (this.NK != null) {
        paramListAdapter.registerDataSetObserver(this.mObserver);
      }
      if (this.uWw != null) {
        this.uWw.setAdapter(this.NK);
      }
      return;
      if (this.NK != null) {
        this.NK.unregisterDataSetObserver(this.mObserver);
      }
    }
  }
  
  public final void setAnimationStyle(int paramInt)
  {
    this.fvf.setAnimationStyle(paramInt);
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.fvf.setBackgroundDrawable(paramDrawable);
  }
  
  public final void setContentWidth(int paramInt)
  {
    Drawable localDrawable = this.fvf.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.ec);
      this.aal = (this.ec.left + this.ec.right + paramInt);
      return;
    }
    this.aal = paramInt;
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.fvf.setOnDismissListener(paramOnDismissListener);
  }
  
  public final void setVerticalOffset(int paramInt)
  {
    this.aeK = paramInt;
    this.aeM = true;
  }
  
  public final void show()
  {
    boolean bool3 = true;
    boolean bool2 = true;
    int n = -1;
    Object localObject2;
    boolean bool1;
    Object localObject1;
    View localView;
    FrameLayout.LayoutParams localLayoutParams1;
    FrameLayout.LayoutParams localLayoutParams2;
    if (this.uWw == null)
    {
      localObject2 = this.mContext;
      this.afc = new MMListPopupWindow.1(this);
      if (!this.afd)
      {
        bool1 = true;
        this.uWw = new MMListPopupWindow.a((Context)localObject2, bool1, (byte)0);
        if (this.aeV != null) {
          this.uWw.setSelector(this.aeV);
        }
        this.uWw.setAdapter(this.NK);
        this.uWw.setOnItemClickListener(this.aeW);
        this.uWw.setFocusable(true);
        this.uWw.setFocusableInTouchMode(true);
        this.uWw.setDivider(null);
        this.uWw.setDividerHeight(0);
        this.uWw.setOnItemSelectedListener(new MMListPopupWindow.2(this));
        this.uWw.setOnScrollListener(this.uWu);
        if (this.aeX != null) {
          this.uWw.setOnItemSelectedListener(this.aeX);
        }
        localObject1 = this.uWw;
        localView = this.aeS;
        if (localView == null) {
          break label1281;
        }
        asA();
        localObject2 = new FrameLayout((Context)localObject2);
        localLayoutParams1 = new FrameLayout.LayoutParams(-1, -1);
        localLayoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        switch (this.aeT)
        {
        default: 
          ao.v("Invalid hint position " + this.aeT, new Object[0]);
          label283:
          localView.measure(View.MeasureSpec.makeMeasureSpec(this.aal, -2147483648), 0);
          localObject1 = localObject2;
        }
      }
    }
    label314:
    label585:
    label592:
    label1240:
    for (;;)
    {
      this.fvf.setContentView((View)localObject1);
      int i = 0;
      label988:
      label1246:
      for (;;)
      {
        localObject1 = this.fvf.getBackground();
        int k;
        label377:
        int i1;
        int m;
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.ec);
          j = this.ec.top + this.ec.bottom;
          k = j;
          if (!this.aeM)
          {
            this.aeK = (-this.ec.top);
            k = j;
          }
          if (this.fvf.getInputMethodMode() != 2) {
            break label749;
          }
          j = 1;
          localObject1 = this.aeU;
          i1 = this.aeK;
          localObject2 = new Rect();
          ((View)localObject1).getWindowVisibleDisplayFrame((Rect)localObject2);
          ((View)localObject1).getLocationOnScreen(new int[2]);
          m = ((Rect)localObject2).bottom;
          if (j == 0) {
            break label1270;
          }
        }
        label749:
        label1270:
        for (int j = ((View)localObject1).getContext().getResources().getDisplayMetrics().heightPixels;; j = m)
        {
          j -= i1;
          m = j;
          if (this.fvf.getBackground() != null)
          {
            this.fvf.getBackground().getPadding(this.ec);
            m = j - (this.ec.top + this.ec.bottom);
          }
          if ((this.aeP) || (this.aeI == -1))
          {
            i = m + k;
            bool1 = isInputMethodNotNeeded();
            if (!this.fvf.isShowing()) {
              break label1016;
            }
            if (this.aal != -1) {
              break label902;
            }
            j = -1;
            if (this.aeI != -1) {
              break label971;
            }
            if (!bool1) {
              break label930;
            }
            if (!bool1) {
              break label940;
            }
            localObject1 = this.fvf;
            if (this.aal != -1) {
              break label935;
            }
            k = n;
            ((o)localObject1).setWindowLayoutMode(k, 0);
            this.fvf.update(j, i);
            localObject1 = this.fvf;
            if ((this.aeQ) || (this.aeP)) {
              break label988;
            }
          }
          for (bool1 = bool2;; bool1 = false)
          {
            ((o)localObject1).setOutsideTouchable(bool1);
            if (!this.hxj) {
              break label994;
            }
            this.fvf.showAtLocation(this.aeU, 17, 0, 0);
            return;
            bool1 = false;
            break;
            localLayoutParams2.gravity = 80;
            ((FrameLayout)localObject2).addView((View)localObject1, localLayoutParams1);
            ((FrameLayout)localObject2).addView(localView, localLayoutParams2);
            break label283;
            localLayoutParams2.gravity = 48;
            ((FrameLayout)localObject2).addView((View)localObject1, localLayoutParams1);
            ((FrameLayout)localObject2).addView(localView, localLayoutParams2);
            break label283;
            localObject1 = this.aeS;
            if (localObject1 == null) {
              break label1276;
            }
            i = ((View)localObject1).getMeasuredHeight();
            break label314;
            this.ec.setEmpty();
            k = 0;
            break label377;
            j = 0;
            break label390;
            switch (this.aal)
            {
            default: 
              j = View.MeasureSpec.makeMeasureSpec(this.aal, 1073741824);
            }
            for (;;)
            {
              m = this.uWw.ck(j, m - i);
              j = i;
              if (m > 0) {
                j = i + k;
              }
              i = j + m;
              break;
              j = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.ec.left + this.ec.right), -2147483648);
              continue;
              j = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.ec.left + this.ec.right), 1073741824);
            }
            if (this.aal == -2)
            {
              j = this.aeU.getWidth();
              break label550;
            }
            j = this.aal;
            break label550;
            i = -1;
            break label563;
            k = 0;
            break label585;
            localObject1 = this.fvf;
            if (this.aal == -1) {}
            for (k = -1;; k = 0)
            {
              ((o)localObject1).setWindowLayoutMode(k, -1);
              break;
            }
            if (this.aeI == -2) {
              break label592;
            }
            i = this.aeI;
            break label592;
          }
          this.fvf.showAtLocation(this.aeU, 53, this.aeJ, this.aeK);
          return;
          label1016:
          if (this.aal == -1)
          {
            j = -1;
            if (this.aeI != -1) {
              break label1202;
            }
            i = -1;
            this.fvf.setWindowLayoutMode(j, i);
            localObject1 = this.fvf;
            if ((this.aeQ) || (this.aeP)) {
              break label1240;
            }
            bool1 = bool3;
            ((o)localObject1).setOutsideTouchable(bool1);
            this.fvf.setTouchInterceptor(this.uWt);
            if (!this.hxj) {
              break label1246;
            }
            this.fvf.showAtLocation(this.aeU, 17, 0, 0);
          }
          for (;;)
          {
            this.uWw.setSelection(-1);
            if ((!this.afd) || (this.uWw.isInTouchMode())) {
              clearListSelection();
            }
            if (this.afd) {
              break;
            }
            this.mHandler.post(this.uWv);
            return;
            if (this.aal == -2)
            {
              this.fvf.setWidth(this.aeU.getWidth());
              j = 0;
              break label1026;
            }
            this.fvf.setWidth(this.aal);
            j = 0;
            break label1026;
            if (this.aeI == -2)
            {
              this.fvf.setHeight(i);
              i = 0;
              break label1036;
            }
            this.fvf.setHeight(this.aeI);
            i = 0;
            break label1036;
            bool1 = false;
            break label1069;
            this.fvf.showAtLocation(this.aeU, 53, this.aeJ, this.aeK);
          }
        }
        label994:
        label1276:
        i = 0;
      }
    }
  }
  
  private final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      MMListPopupWindow.this.clearListSelection();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMListPopupWindow
 * JD-Core Version:    0.7.0.1
 */