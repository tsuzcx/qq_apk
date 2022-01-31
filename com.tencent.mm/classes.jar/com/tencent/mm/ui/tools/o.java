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
import com.tencent.mm.ac.a.d;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.f;
import com.tencent.mm.ac.a.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMListPopupWindow;

public abstract class o
  implements View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private ViewTreeObserver US;
  private int Ws;
  private int dividerHeight;
  private View hX;
  private boolean hxj = false;
  private BaseAdapter iqN;
  protected Context mContext;
  private boolean rwZ = false;
  private DialogInterface.OnCancelListener uGw;
  private MMListPopupWindow vix;
  private int viy = a.l.DropMenuAnimation;
  private ViewGroup wfb;
  private PopupWindow.OnDismissListener wfc;
  private boolean wfd = true;
  private View wfe;
  private int wff;
  private int wfg = 0;
  private int wfh = 0;
  private int wfi = 0;
  private float wfj = 0.0F;
  private float wfk = 0.0F;
  
  public o(Context paramContext)
  {
    this.mContext = paramContext;
    paramContext = paramContext.getResources();
    this.Ws = Math.min(paramContext.getDisplayMetrics().widthPixels * 4 / 5, paramContext.getDimensionPixelSize(a.e.abc_config_prefDialogWidth));
    ViewGroup localViewGroup;
    if ((this.mContext instanceof Activity))
    {
      localViewGroup = (ViewGroup)((Activity)this.mContext).getWindow().getDecorView();
      if (localViewGroup.getChildCount() <= 0) {
        break label187;
      }
    }
    label187:
    for (this.hX = localViewGroup.getChildAt(0);; this.hX = localViewGroup)
    {
      this.dividerHeight = BackwardSupportUtil.b.b(this.mContext, 1.0F);
      this.wfg = (paramContext.getDimensionPixelSize(a.e.NormalPadding) * 2);
      this.wfh = paramContext.getDimensionPixelSize(a.e.SmallListHeight);
      this.wfi = BackwardSupportUtil.b.b(this.mContext, 36.0F);
      this.iqN = xX();
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
      if (this.wfb == null) {
        this.wfb = new FrameLayout(this.mContext);
      }
      localView = paramListAdapter.getView(j, localView, this.wfb);
      localView.measure(n, i1);
      k = Math.max(k, localView.getMeasuredWidth());
      j += 1;
      break;
      return k;
    }
  }
  
  private boolean biH()
  {
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    return localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels;
  }
  
  public final void dismiss()
  {
    if (isShowing()) {
      this.vix.dismiss();
    }
  }
  
  public boolean fy()
  {
    Object localObject1 = new Rect();
    int i;
    int j;
    Object localObject2;
    if ((this.mContext instanceof AppCompatActivity))
    {
      i = ((AppCompatActivity)this.mContext).getSupportActionBar().getHeight();
      i -= this.mContext.getResources().getDimensionPixelSize(a.e.NormalPadding);
      if (!(this.mContext instanceof Activity)) {
        break label960;
      }
      ((Activity)this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
      j = ((Activity)this.mContext).getWindow().getDecorView().getHeight();
      localObject2 = new int[2];
      ((Activity)this.mContext).getWindow().getDecorView().getLocationOnScreen((int[])localObject2);
      if ((j - ((Rect)localObject1).height() < 0) || (localObject2[1] <= 200)) {
        break label870;
      }
      i = j - ((Rect)localObject1).height() + i;
    }
    label147:
    label288:
    label443:
    label957:
    label960:
    for (;;)
    {
      this.rwZ = biH();
      if ((this.vix == null) || (true == this.wfd)) {
        this.vix = new MMListPopupWindow(this.mContext, null, 0);
      }
      this.vix.setOnDismissListener(this);
      this.vix.aeW = this;
      this.vix.setAdapter(this.iqN);
      this.vix.cAM();
      this.vix.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.f.ofm_menu_bg));
      this.vix.setAnimationStyle(this.viy);
      this.vix.aeJ = 0;
      this.vix.aeU = this.hX;
      boolean bool;
      if (this.hX != null)
      {
        if (this.US != null) {
          break label881;
        }
        bool = true;
        this.US = this.hX.getViewTreeObserver();
        y.v("MicroMsg.SubMenuHelperBase", "tryshow addGlobalListener:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          this.US.addOnGlobalLayoutListener(this);
        }
      }
      this.vix.setVerticalOffset(i);
      this.vix.hxj = this.hxj;
      this.vix.setContentWidth(Math.min(b(this.iqN), this.Ws));
      this.vix.hf();
      if ((this.wfj != 0.0F) && (this.wfk != 0.0F))
      {
        localObject1 = new DisplayMetrics();
        ((Activity)this.mContext).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        if (((DisplayMetrics)localObject1).widthPixels <= ((DisplayMetrics)localObject1).heightPixels) {
          break label887;
        }
        i = 1;
        localObject1 = new Rect();
        ((Activity)this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
        j = ((Activity)this.mContext).getWindow().getDecorView().getHeight();
        if (j <= ((Rect)localObject1).height()) {
          break label957;
        }
        j = ((Rect)localObject1).height();
      }
      for (;;)
      {
        if (i != 0)
        {
          i = (int)(this.wfk * j);
          y.d("MicroMsg.SubMenuHelperBase", "menuHeightPercentPort(%f), menuHeightPercentLand(%f), frameHeight(%d), decorViewHeight(%d), menuHeight(%d)", new Object[] { Float.valueOf(this.wfj), Float.valueOf(this.wfk), Integer.valueOf(((Rect)localObject1).height()), Integer.valueOf(j), Integer.valueOf(i) });
          i = Math.round(i / this.wfh);
          if ((i <= 0) || (this.iqN == null)) {
            break label945;
          }
          j = this.wfh * i + this.wfg;
          if ((j == 0) || (j >= this.iqN.getCount() * this.wfh)) {
            break label904;
          }
          j = this.wfh;
          int k = this.wfg;
          int m = this.wfi;
          this.vix.aeI = ((i - 1) * j + k + m);
        }
        for (;;)
        {
          if ((this.vix != null) && (this.wfe != null))
          {
            localObject1 = this.vix;
            localObject2 = this.wfe;
            bool = ((MMListPopupWindow)localObject1).fvf.isShowing();
            if (bool) {
              ((MMListPopupWindow)localObject1).asA();
            }
            ((MMListPopupWindow)localObject1).aeS = ((View)localObject2);
            if (bool) {
              ((MMListPopupWindow)localObject1).show();
            }
            this.vix.aeT = this.wff;
          }
          this.vix.show();
          this.vix.uWw.setOnKeyListener(this);
          this.vix.uWw.setSelector(new ColorDrawable(this.mContext.getResources().getColor(a.d.transparent)));
          this.vix.uWw.setDividerHeight(0);
          this.vix.uWw.setVerticalScrollBarEnabled(true);
          this.vix.uWw.setHorizontalScrollBarEnabled(false);
          return true;
          localObject2 = this.mContext.getResources().getDisplayMetrics();
          if (((DisplayMetrics)localObject2).widthPixels > ((DisplayMetrics)localObject2).heightPixels)
          {
            i = BackwardSupportUtil.b.b(this.mContext, 40.0F);
            break;
          }
          i = BackwardSupportUtil.b.b(this.mContext, 49.0F);
          break;
          label870:
          i = ((Rect)localObject1).top + i;
          break label147;
          label881:
          bool = false;
          break label288;
          label887:
          i = 0;
          break label443;
          i = (int)(this.wfj * j);
          break label515;
          y.w("MicroMsg.SubMenuHelperBase", "[cpan] menuheight:%d,listHeight:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(this.iqN.getCount() * this.wfh) });
          continue;
          y.e("MicroMsg.SubMenuHelperBase", "[cpan] setpopuHeight error.");
        }
      }
    }
  }
  
  public final boolean isShowing()
  {
    return (this.vix != null) && (this.vix.fvf.isShowing());
  }
  
  public final void nL(boolean paramBoolean)
  {
    this.hxj = paramBoolean;
    if (paramBoolean)
    {
      this.viy = a.l.CenterMenuAnimation;
      return;
    }
    this.viy = a.l.DropMenuAnimation;
  }
  
  public void onDismiss()
  {
    this.vix = null;
    if (this.US != null)
    {
      if (!this.US.isAlive()) {
        this.US = this.hX.getViewTreeObserver();
      }
      this.US.removeGlobalOnLayoutListener(this);
      this.US = null;
    }
    if (this.uGw != null) {
      this.uGw.onCancel(null);
    }
    if (this.wfc != null) {
      this.wfc.onDismiss();
    }
  }
  
  public void onGlobalLayout()
  {
    y.v("MicroMsg.SubMenuHelperBase", "onGlobalLayout showing:%b, anchorshown:%b", new Object[] { Boolean.valueOf(isShowing()), Boolean.valueOf(this.hX.isShown()) });
    if (isShowing())
    {
      View localView = this.hX;
      if ((localView != null) && (localView.isShown())) {
        break label64;
      }
      dismiss();
    }
    label64:
    while ((!isShowing()) || (this.rwZ == biH())) {
      return;
    }
    this.vix.dismiss();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    dismiss();
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    y.v("MicroMsg.SubMenuHelperBase", "onKey");
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      dismiss();
      return true;
    }
    return false;
  }
  
  public abstract BaseAdapter xX();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.o
 * JD-Core Version:    0.7.0.1
 */