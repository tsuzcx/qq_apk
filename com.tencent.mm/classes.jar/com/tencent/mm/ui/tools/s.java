package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.o;

public abstract class s
  implements View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private MMListPopupWindow Jzo;
  private int Jzp = 2131820865;
  private ViewGroup KLA;
  private PopupWindow.OnDismissListener KLB;
  private boolean KLC = true;
  private View KLD;
  private int KLE;
  private int KLF = 0;
  private int KLG = 0;
  private float KLH = 0.0F;
  private float KLI = 0.0F;
  private ViewTreeObserver afv;
  private int agV;
  private int dividerHeight;
  private boolean lzE = false;
  protected Context mContext;
  private int nMf = 0;
  private boolean nhI = false;
  private BaseAdapter oDI;
  private View qI;
  private DialogInterface.OnCancelListener yps;
  
  public s(Context paramContext)
  {
    this.mContext = paramContext;
    paramContext = paramContext.getResources();
    this.agV = Math.min(paramContext.getDisplayMetrics().widthPixels * 4 / 5, paramContext.getDimensionPixelSize(2131165522));
    ViewGroup localViewGroup;
    if ((this.mContext instanceof Activity))
    {
      localViewGroup = (ViewGroup)((Activity)this.mContext).getWindow().getDecorView();
      if (localViewGroup.getChildCount() <= 0) {
        break label183;
      }
    }
    label183:
    for (this.qI = localViewGroup.getChildAt(0);; this.qI = localViewGroup)
    {
      this.dividerHeight = BackwardSupportUtil.b.g(this.mContext, 1.0F);
      this.KLF = (paramContext.getDimensionPixelSize(2131165516) * 2);
      this.nMf = paramContext.getDimensionPixelSize(2131165255);
      this.KLG = BackwardSupportUtil.b.g(this.mContext, 36.0F);
      this.oDI = Zp();
      return;
    }
  }
  
  private boolean aol()
  {
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    return localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels;
  }
  
  private int b(ListAdapter paramListAdapter)
  {
    int n = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i2 = paramListAdapter.getCount();
    int j = 0;
    int i = 0;
    View localView = null;
    int k = 0;
    if (j < i2)
    {
      int m = paramListAdapter.getItemViewType(j);
      if (m == i) {
        break label127;
      }
      localView = null;
      i = m;
    }
    label127:
    for (;;)
    {
      if (this.KLA == null) {
        this.KLA = new FrameLayout(this.mContext);
      }
      localView = paramListAdapter.getView(j, localView, this.KLA);
      localView.measure(n, i1);
      k = Math.max(k, localView.getMeasuredWidth());
      j += 1;
      break;
      return k;
    }
  }
  
  protected abstract BaseAdapter Zp();
  
  public final void dismiss()
  {
    if (isShowing()) {
      this.Jzo.dismiss();
    }
  }
  
  public boolean il()
  {
    Object localObject1 = new Rect();
    int i;
    int k;
    int j;
    Object localObject2;
    label143:
    boolean bool;
    if ((this.mContext instanceof AppCompatActivity))
    {
      i = ((AppCompatActivity)this.mContext).getSupportActionBar().getHeight();
      k = aq.ay(this.mContext, 2131165303);
      j = i;
      if ((this.mContext instanceof Activity))
      {
        ((Activity)this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
        j = ((Activity)this.mContext).getWindow().getDecorView().getHeight();
        localObject2 = new int[2];
        ((Activity)this.mContext).getWindow().getDecorView().getLocationOnScreen((int[])localObject2);
        if ((j - ((Rect)localObject1).height() < 0) || (localObject2[1] <= 200)) {
          break label858;
        }
        j = i + (j - ((Rect)localObject1).height());
      }
      this.lzE = aol();
      if (this.Jzo == null) {
        this.Jzo = new MMListPopupWindow(this.mContext, null, 0);
      }
      this.Jzo.setOnDismissListener(this);
      this.Jzo.arf = this;
      this.Jzo.setAdapter(this.oDI);
      this.Jzo.setModal(true);
      this.Jzo.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131233518));
      this.Jzo.setAnimationStyle(this.Jzp);
      this.Jzo.aqS = k;
      this.Jzo.ard = this.qI;
      if (this.qI != null)
      {
        if (this.afv != null) {
          break label869;
        }
        bool = true;
        label276:
        this.afv = this.qI.getViewTreeObserver();
        ad.v("MicroMsg.SubMenuHelperBase", "tryshow addGlobalListener:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          this.afv.addOnGlobalLayoutListener(this);
        }
      }
      this.Jzo.setVerticalOffset(j);
      this.Jzo.nhI = this.nhI;
      this.Jzo.setContentWidth(Math.min(b(this.oDI), this.agV));
      this.Jzo.kw();
      if ((this.KLH != 0.0F) && (this.KLI != 0.0F))
      {
        localObject1 = new DisplayMetrics();
        ((Activity)this.mContext).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        if (((DisplayMetrics)localObject1).widthPixels <= ((DisplayMetrics)localObject1).heightPixels) {
          break label875;
        }
        i = 1;
        label431:
        localObject1 = new Rect();
        ((Activity)this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
        j = ((Activity)this.mContext).getWindow().getDecorView().getHeight();
        if (j <= ((Rect)localObject1).height()) {
          break label945;
        }
        j = ((Rect)localObject1).height();
      }
    }
    label933:
    label945:
    for (;;)
    {
      if (i != 0)
      {
        i = (int)(this.KLI * j);
        label503:
        ad.d("MicroMsg.SubMenuHelperBase", "menuHeightPercentPort(%f), menuHeightPercentLand(%f), frameHeight(%d), decorViewHeight(%d), menuHeight(%d)", new Object[] { Float.valueOf(this.KLH), Float.valueOf(this.KLI), Integer.valueOf(((Rect)localObject1).height()), Integer.valueOf(j), Integer.valueOf(i) });
        i = Math.round(i / this.nMf);
        if ((i <= 0) || (this.oDI == null)) {
          break label933;
        }
        j = this.nMf * i + this.KLF;
        if ((j == 0) || (j >= this.oDI.getCount() * this.nMf)) {
          break label892;
        }
        j = this.nMf;
        k = this.KLF;
        int m = this.KLG;
        this.Jzo.aqR = ((i - 1) * j + k + m);
      }
      for (;;)
      {
        if ((this.Jzo != null) && (this.KLD != null))
        {
          localObject1 = this.Jzo;
          localObject2 = this.KLD;
          bool = ((MMListPopupWindow)localObject1).jtC.isShowing();
          if (bool) {
            ((MMListPopupWindow)localObject1).kv();
          }
          ((MMListPopupWindow)localObject1).arb = ((View)localObject2);
          if (bool) {
            ((MMListPopupWindow)localObject1).show();
          }
          this.Jzo.arc = this.KLE;
        }
        this.Jzo.show();
        this.Jzo.JlR.setOnKeyListener(this);
        this.Jzo.JlR.setSelector(new ColorDrawable(this.mContext.getResources().getColor(2131101053)));
        this.Jzo.JlR.setDividerHeight(0);
        this.Jzo.JlR.setVerticalScrollBarEnabled(true);
        this.Jzo.JlR.setHorizontalScrollBarEnabled(false);
        return true;
        localObject2 = this.mContext.getResources().getDisplayMetrics();
        if (((DisplayMetrics)localObject2).widthPixels > ((DisplayMetrics)localObject2).heightPixels)
        {
          i = BackwardSupportUtil.b.g(this.mContext, 40.0F);
          break;
        }
        i = BackwardSupportUtil.b.g(this.mContext, 49.0F);
        break;
        label858:
        j = i + ((Rect)localObject1).top;
        break label143;
        label869:
        bool = false;
        break label276;
        label875:
        i = 0;
        break label431;
        i = (int)(this.KLH * j);
        break label503;
        label892:
        ad.w("MicroMsg.SubMenuHelperBase", "[cpan] menuheight:%d,listHeight:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(this.oDI.getCount() * this.nMf) });
        continue;
        ad.e("MicroMsg.SubMenuHelperBase", "[cpan] setpopuHeight error.");
      }
    }
  }
  
  public final boolean isShowing()
  {
    return (this.Jzo != null) && (this.Jzo.jtC.isShowing());
  }
  
  public void onDismiss()
  {
    if (this.afv != null)
    {
      if (!this.afv.isAlive()) {
        this.afv = this.qI.getViewTreeObserver();
      }
      this.afv.removeGlobalOnLayoutListener(this);
      this.afv = null;
    }
    if (this.yps != null) {
      this.yps.onCancel(null);
    }
    if (this.KLB != null) {
      this.KLB.onDismiss();
    }
  }
  
  public void onGlobalLayout()
  {
    ad.v("MicroMsg.SubMenuHelperBase", "onGlobalLayout showing:%b, anchorshown:%b", new Object[] { Boolean.valueOf(isShowing()), Boolean.valueOf(this.qI.isShown()) });
    if (isShowing())
    {
      View localView = this.qI;
      if ((localView != null) && (localView.isShown())) {
        break label64;
      }
      dismiss();
    }
    label64:
    while ((!isShowing()) || (this.lzE == aol())) {
      return;
    }
    this.Jzo.dismiss();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    b localb = new b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mr(paramInt);
    localb.qY(paramLong);
    a.b("com/tencent/mm/ui/tools/SubMenuHelperBase", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
    dismiss();
    a.a(this, "com/tencent/mm/ui/tools/SubMenuHelperBase", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    b localb = new b();
    localb.bd(paramView);
    localb.mr(paramInt);
    localb.bd(paramKeyEvent);
    a.b("com/tencent/mm/ui/tools/SubMenuHelperBase", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahq());
    ad.v("MicroMsg.SubMenuHelperBase", "onKey");
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      dismiss();
      a.a(true, this, "com/tencent/mm/ui/tools/SubMenuHelperBase", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
      return true;
    }
    a.a(false, this, "com/tencent/mm/ui/tools/SubMenuHelperBase", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
    return false;
  }
  
  public final void yD(boolean paramBoolean)
  {
    this.nhI = paramBoolean;
    if (paramBoolean)
    {
      this.Jzp = 2131820809;
      return;
    }
    this.Jzp = 2131820865;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.s
 * JD-Core Version:    0.7.0.1
 */