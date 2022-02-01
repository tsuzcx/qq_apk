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
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.p;

public abstract class t
  implements View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private DialogInterface.OnCancelListener CJj;
  private MMListPopupWindow Pfj;
  private int Pfk = 2131820873;
  private ViewGroup QwT;
  private PopupWindow.OnDismissListener QwU;
  private boolean QwV = true;
  private View QwW;
  private int QwX;
  private int QwY = 0;
  private int QwZ = 0;
  private float Qxa = 0.0F;
  private float Qxb = 0.0F;
  private ViewTreeObserver afI;
  private int ahi;
  private int dividerHeight;
  protected Context mContext;
  private boolean mLL = false;
  private boolean owx = false;
  private BaseAdapter pXY;
  private int pcA = 0;
  private View qK;
  
  public t(Context paramContext)
  {
    this.mContext = paramContext;
    paramContext = paramContext.getResources();
    this.ahi = Math.min(paramContext.getDisplayMetrics().widthPixels * 4 / 5, paramContext.getDimensionPixelSize(2131165540));
    ViewGroup localViewGroup;
    if ((this.mContext instanceof Activity))
    {
      localViewGroup = (ViewGroup)((Activity)this.mContext).getWindow().getDecorView();
      if (localViewGroup.getChildCount() <= 0) {
        break label183;
      }
    }
    label183:
    for (this.qK = localViewGroup.getChildAt(0);; this.qK = localViewGroup)
    {
      this.dividerHeight = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 1.0F);
      this.QwY = (paramContext.getDimensionPixelSize(2131165534) * 2);
      this.pcA = paramContext.getDimensionPixelSize(2131165259);
      this.QwZ = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 36.0F);
      this.pXY = anl();
      return;
    }
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
      if (this.QwT == null) {
        this.QwT = new FrameLayout(this.mContext);
      }
      localView = paramListAdapter.getView(j, localView, this.QwT);
      localView.measure(n, i1);
      k = Math.max(k, localView.getMeasuredWidth());
      j += 1;
      break;
      return k;
    }
  }
  
  private boolean isLandscape()
  {
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    return localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels;
  }
  
  public final void CL(boolean paramBoolean)
  {
    this.owx = paramBoolean;
    if (paramBoolean)
    {
      this.Pfk = 2131820813;
      return;
    }
    this.Pfk = 2131820873;
  }
  
  protected abstract BaseAdapter anl();
  
  public final void dismiss()
  {
    if (isShowing()) {
      this.Pfj.dismiss();
    }
  }
  
  public final boolean isShowing()
  {
    return (this.Pfj != null) && (this.Pfj.kuK.isShowing());
  }
  
  public boolean iv()
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
      k = at.aH(this.mContext, 2131165314);
      j = i;
      if ((this.mContext instanceof Activity))
      {
        ((Activity)this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
        j = ((Activity)this.mContext).getWindow().getDecorView().getHeight();
        localObject2 = new int[2];
        ((Activity)this.mContext).getWindow().getDecorView().getLocationOnScreen((int[])localObject2);
        if ((j - ((Rect)localObject1).height() < 0) || (localObject2[1] <= 200)) {
          break label859;
        }
        j = i + (j - ((Rect)localObject1).height());
      }
      this.mLL = isLandscape();
      if (this.Pfj == null) {
        this.Pfj = new MMListPopupWindow(this.mContext, null, 0);
      }
      this.Pfj.setOnDismissListener(this);
      this.Pfj.ars = this;
      this.Pfj.setAdapter(this.pXY);
      this.Pfj.setModal(true);
      this.Pfj.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131234322));
      this.Pfj.setAnimationStyle(this.Pfk);
      this.Pfj.are = k;
      this.Pfj.arp = this.qK;
      if (this.qK != null)
      {
        if (this.afI != null) {
          break label870;
        }
        bool = true;
        label277:
        this.afI = this.qK.getViewTreeObserver();
        Log.v("MicroMsg.SubMenuHelperBase", "tryshow addGlobalListener:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          this.afI.addOnGlobalLayoutListener(this);
        }
      }
      this.Pfj.setVerticalOffset(j);
      this.Pfj.owx = this.owx;
      this.Pfj.setContentWidth(Math.min(b(this.pXY), this.ahi));
      this.Pfj.kC();
      if ((this.Qxa != 0.0F) && (this.Qxb != 0.0F))
      {
        localObject1 = new DisplayMetrics();
        ((Activity)this.mContext).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        if (((DisplayMetrics)localObject1).widthPixels <= ((DisplayMetrics)localObject1).heightPixels) {
          break label876;
        }
        i = 1;
        label432:
        localObject1 = new Rect();
        ((Activity)this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
        j = ((Activity)this.mContext).getWindow().getDecorView().getHeight();
        if (j <= ((Rect)localObject1).height()) {
          break label946;
        }
        j = ((Rect)localObject1).height();
      }
    }
    label934:
    label946:
    for (;;)
    {
      if (i != 0)
      {
        i = (int)(this.Qxb * j);
        label504:
        Log.d("MicroMsg.SubMenuHelperBase", "menuHeightPercentPort(%f), menuHeightPercentLand(%f), frameHeight(%d), decorViewHeight(%d), menuHeight(%d)", new Object[] { Float.valueOf(this.Qxa), Float.valueOf(this.Qxb), Integer.valueOf(((Rect)localObject1).height()), Integer.valueOf(j), Integer.valueOf(i) });
        i = Math.round(i / this.pcA);
        if ((i <= 0) || (this.pXY == null)) {
          break label934;
        }
        j = this.pcA * i + this.QwY;
        if ((j == 0) || (j >= this.pXY.getCount() * this.pcA)) {
          break label893;
        }
        j = this.pcA;
        k = this.QwY;
        int m = this.QwZ;
        this.Pfj.ard = ((i - 1) * j + k + m);
      }
      for (;;)
      {
        if ((this.Pfj != null) && (this.QwW != null))
        {
          localObject1 = this.Pfj;
          localObject2 = this.QwW;
          bool = ((MMListPopupWindow)localObject1).kuK.isShowing();
          if (bool) {
            ((MMListPopupWindow)localObject1).kB();
          }
          ((MMListPopupWindow)localObject1).arn = ((View)localObject2);
          if (bool) {
            ((MMListPopupWindow)localObject1).show();
          }
          this.Pfj.aro = this.QwX;
        }
        this.Pfj.show();
        this.Pfj.ORx.setOnKeyListener(this);
        this.Pfj.ORx.setSelector(new ColorDrawable(this.mContext.getResources().getColor(2131101287)));
        this.Pfj.ORx.setDividerHeight(0);
        this.Pfj.ORx.setVerticalScrollBarEnabled(true);
        this.Pfj.ORx.setHorizontalScrollBarEnabled(false);
        return true;
        localObject2 = this.mContext.getResources().getDisplayMetrics();
        if (((DisplayMetrics)localObject2).widthPixels > ((DisplayMetrics)localObject2).heightPixels)
        {
          i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 40.0F);
          break;
        }
        i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 49.0F);
        break;
        label859:
        j = i + ((Rect)localObject1).top;
        break label143;
        label870:
        bool = false;
        break label277;
        label876:
        i = 0;
        break label432;
        i = (int)(this.Qxa * j);
        break label504;
        label893:
        Log.w("MicroMsg.SubMenuHelperBase", "[cpan] menuheight:%d,listHeight:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(this.pXY.getCount() * this.pcA) });
        continue;
        Log.e("MicroMsg.SubMenuHelperBase", "[cpan] setpopuHeight error.");
      }
    }
  }
  
  public void onDismiss()
  {
    if (this.afI != null)
    {
      if (!this.afI.isAlive()) {
        this.afI = this.qK.getViewTreeObserver();
      }
      this.afI.removeGlobalOnLayoutListener(this);
      this.afI = null;
    }
    if (this.CJj != null) {
      this.CJj.onCancel(null);
    }
    if (this.QwU != null) {
      this.QwU.onDismiss();
    }
  }
  
  public void onGlobalLayout()
  {
    Log.v("MicroMsg.SubMenuHelperBase", "onGlobalLayout showing:%b, anchorshown:%b", new Object[] { Boolean.valueOf(isShowing()), Boolean.valueOf(this.qK.isShown()) });
    if (isShowing())
    {
      View localView = this.qK;
      if ((localView != null) && (localView.isShown())) {
        break label64;
      }
      dismiss();
    }
    label64:
    while ((!isShowing()) || (this.mLL == isLandscape())) {
      return;
    }
    this.Pfj.dismiss();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    b localb = new b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    a.b("com/tencent/mm/ui/tools/SubMenuHelperBase", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    dismiss();
    a.a(this, "com/tencent/mm/ui/tools/SubMenuHelperBase", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    b localb = new b();
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.bm(paramKeyEvent);
    a.b("com/tencent/mm/ui/tools/SubMenuHelperBase", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
    Log.v("MicroMsg.SubMenuHelperBase", "onKey");
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      dismiss();
      a.a(true, this, "com/tencent/mm/ui/tools/SubMenuHelperBase", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
      return true;
    }
    a.a(false, this, "com/tencent/mm/ui/tools/SubMenuHelperBase", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.t
 * JD-Core Version:    0.7.0.1
 */