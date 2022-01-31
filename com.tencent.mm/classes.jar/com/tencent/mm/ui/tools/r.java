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
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.o;

public abstract class r
  implements View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private ViewGroup AxR;
  private PopupWindow.OnDismissListener AxS;
  private boolean AxT = true;
  private View AxU;
  private int AxV;
  private int AxW = 0;
  private int AxX = 0;
  private int AxY = 0;
  private float AxZ = 0.0F;
  private float Aya = 0.0F;
  private ViewTreeObserver VF;
  private int Xf;
  private int dividerHeight;
  private View iU;
  private boolean jpt = false;
  private BaseAdapter krV;
  protected Context mContext;
  private boolean vnS = false;
  private DialogInterface.OnCancelListener yTy;
  private MMListPopupWindow zxr;
  private int zxs = 2131493189;
  
  public r(Context paramContext)
  {
    this.mContext = paramContext;
    paramContext = paramContext.getResources();
    this.Xf = Math.min(paramContext.getDisplayMetrics().widthPixels * 4 / 5, paramContext.getDimensionPixelSize(2131427813));
    ViewGroup localViewGroup;
    if ((this.mContext instanceof Activity))
    {
      localViewGroup = (ViewGroup)((Activity)this.mContext).getWindow().getDecorView();
      if (localViewGroup.getChildCount() <= 0) {
        break label183;
      }
    }
    label183:
    for (this.iU = localViewGroup.getChildAt(0);; this.iU = localViewGroup)
    {
      this.dividerHeight = BackwardSupportUtil.b.b(this.mContext, 1.0F);
      this.AxW = (paramContext.getDimensionPixelSize(2131427808) * 2);
      this.AxX = paramContext.getDimensionPixelSize(2131427562);
      this.AxY = BackwardSupportUtil.b.b(this.mContext, 36.0F);
      this.krV = Kp();
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
      if (this.AxR == null) {
        this.AxR = new FrameLayout(this.mContext);
      }
      localView = paramListAdapter.getView(j, localView, this.AxR);
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
  
  protected abstract BaseAdapter Kp();
  
  public final void dismiss()
  {
    if (isShowing()) {
      this.zxr.dismiss();
    }
  }
  
  public boolean gr()
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
      k = al.ap(this.mContext, 2131427598);
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
      this.vnS = isLandscape();
      if (this.zxr == null) {
        this.zxr = new MMListPopupWindow(this.mContext, null, 0);
      }
      this.zxr.setOnDismissListener(this);
      this.zxr.ahl = this;
      this.zxr.setAdapter(this.krV);
      this.zxr.setModal(true);
      this.zxr.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130839858));
      this.zxr.setAnimationStyle(this.zxs);
      this.zxr.agY = k;
      this.zxr.ahj = this.iU;
      if (this.iU != null)
      {
        if (this.VF != null) {
          break label869;
        }
        bool = true;
        label276:
        this.VF = this.iU.getViewTreeObserver();
        ab.v("MicroMsg.SubMenuHelperBase", "tryshow addGlobalListener:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          this.VF.addOnGlobalLayoutListener(this);
        }
      }
      this.zxr.setVerticalOffset(j);
      this.zxr.jpt = this.jpt;
      this.zxr.setContentWidth(Math.min(b(this.krV), this.Xf));
      this.zxr.iD();
      if ((this.AxZ != 0.0F) && (this.Aya != 0.0F))
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
        i = (int)(this.Aya * j);
        label503:
        ab.d("MicroMsg.SubMenuHelperBase", "menuHeightPercentPort(%f), menuHeightPercentLand(%f), frameHeight(%d), decorViewHeight(%d), menuHeight(%d)", new Object[] { Float.valueOf(this.AxZ), Float.valueOf(this.Aya), Integer.valueOf(((Rect)localObject1).height()), Integer.valueOf(j), Integer.valueOf(i) });
        i = Math.round(i / this.AxX);
        if ((i <= 0) || (this.krV == null)) {
          break label933;
        }
        j = this.AxX * i + this.AxW;
        if ((j == 0) || (j >= this.krV.getCount() * this.AxX)) {
          break label892;
        }
        j = this.AxX;
        k = this.AxW;
        int m = this.AxY;
        this.zxr.agX = ((i - 1) * j + k + m);
      }
      for (;;)
      {
        if ((this.zxr != null) && (this.AxU != null))
        {
          localObject1 = this.zxr;
          localObject2 = this.AxU;
          bool = ((MMListPopupWindow)localObject1).gMK.isShowing();
          if (bool) {
            ((MMListPopupWindow)localObject1).iC();
          }
          ((MMListPopupWindow)localObject1).ahh = ((View)localObject2);
          if (bool) {
            ((MMListPopupWindow)localObject1).show();
          }
          this.zxr.ahi = this.AxV;
        }
        this.zxr.show();
        this.zxr.zkP.setOnKeyListener(this);
        this.zxr.zkP.setSelector(new ColorDrawable(this.mContext.getResources().getColor(2131690605)));
        this.zxr.zkP.setDividerHeight(0);
        this.zxr.zkP.setVerticalScrollBarEnabled(true);
        this.zxr.zkP.setHorizontalScrollBarEnabled(false);
        return true;
        localObject2 = this.mContext.getResources().getDisplayMetrics();
        if (((DisplayMetrics)localObject2).widthPixels > ((DisplayMetrics)localObject2).heightPixels)
        {
          i = BackwardSupportUtil.b.b(this.mContext, 40.0F);
          break;
        }
        i = BackwardSupportUtil.b.b(this.mContext, 49.0F);
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
        i = (int)(this.AxZ * j);
        break label503;
        label892:
        ab.w("MicroMsg.SubMenuHelperBase", "[cpan] menuheight:%d,listHeight:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(this.krV.getCount() * this.AxX) });
        continue;
        ab.e("MicroMsg.SubMenuHelperBase", "[cpan] setpopuHeight error.");
      }
    }
  }
  
  public final boolean isShowing()
  {
    return (this.zxr != null) && (this.zxr.gMK.isShowing());
  }
  
  public void onDismiss()
  {
    if (this.VF != null)
    {
      if (!this.VF.isAlive()) {
        this.VF = this.iU.getViewTreeObserver();
      }
      this.VF.removeGlobalOnLayoutListener(this);
      this.VF = null;
    }
    if (this.yTy != null) {
      this.yTy.onCancel(null);
    }
    if (this.AxS != null) {
      this.AxS.onDismiss();
    }
  }
  
  public void onGlobalLayout()
  {
    ab.v("MicroMsg.SubMenuHelperBase", "onGlobalLayout showing:%b, anchorshown:%b", new Object[] { Boolean.valueOf(isShowing()), Boolean.valueOf(this.iU.isShown()) });
    if (isShowing())
    {
      View localView = this.iU;
      if ((localView != null) && (localView.isShown())) {
        break label64;
      }
      dismiss();
    }
    label64:
    while ((!isShowing()) || (this.vnS == isLandscape())) {
      return;
    }
    this.zxr.dismiss();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    dismiss();
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    ab.v("MicroMsg.SubMenuHelperBase", "onKey");
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      dismiss();
      return true;
    }
    return false;
  }
  
  public final void rv(boolean paramBoolean)
  {
    this.jpt = paramBoolean;
    if (paramBoolean)
    {
      this.zxs = 2131493136;
      return;
    }
    this.zxs = 2131493189;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.r
 * JD-Core Version:    0.7.0.1
 */