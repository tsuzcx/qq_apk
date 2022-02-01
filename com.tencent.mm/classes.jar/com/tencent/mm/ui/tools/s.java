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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.o;

public abstract class s
  implements View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private MMListPopupWindow HLx;
  private int HLy = 2131820865;
  private int IUA;
  private int IUB = 0;
  private int IUC = 0;
  private float IUD = 0.0F;
  private float IUE = 0.0F;
  private ViewGroup IUw;
  private PopupWindow.OnDismissListener IUx;
  private boolean IUy = true;
  private View IUz;
  private ViewTreeObserver adE;
  private int afe;
  private int dividerHeight;
  private boolean lcE = false;
  protected Context mContext;
  private boolean mHk = false;
  private int nly = 0;
  private View oP;
  private BaseAdapter oao;
  private DialogInterface.OnCancelListener xbq;
  
  public s(Context paramContext)
  {
    this.mContext = paramContext;
    paramContext = paramContext.getResources();
    this.afe = Math.min(paramContext.getDisplayMetrics().widthPixels * 4 / 5, paramContext.getDimensionPixelSize(2131165522));
    ViewGroup localViewGroup;
    if ((this.mContext instanceof Activity))
    {
      localViewGroup = (ViewGroup)((Activity)this.mContext).getWindow().getDecorView();
      if (localViewGroup.getChildCount() <= 0) {
        break label183;
      }
    }
    label183:
    for (this.oP = localViewGroup.getChildAt(0);; this.oP = localViewGroup)
    {
      this.dividerHeight = BackwardSupportUtil.b.g(this.mContext, 1.0F);
      this.IUB = (paramContext.getDimensionPixelSize(2131165516) * 2);
      this.nly = paramContext.getDimensionPixelSize(2131165255);
      this.IUC = BackwardSupportUtil.b.g(this.mContext, 36.0F);
      this.oao = WW();
      return;
    }
  }
  
  private boolean aly()
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
      if (this.IUw == null) {
        this.IUw = new FrameLayout(this.mContext);
      }
      localView = paramListAdapter.getView(j, localView, this.IUw);
      localView.measure(n, i1);
      k = Math.max(k, localView.getMeasuredWidth());
      j += 1;
      break;
      return k;
    }
  }
  
  protected abstract BaseAdapter WW();
  
  public final void dismiss()
  {
    if (isShowing()) {
      this.HLx.dismiss();
    }
  }
  
  public boolean hU()
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
      k = ao.av(this.mContext, 2131165303);
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
      this.lcE = aly();
      if (this.HLx == null) {
        this.HLx = new MMListPopupWindow(this.mContext, null, 0);
      }
      this.HLx.setOnDismissListener(this);
      this.HLx.apn = this;
      this.HLx.setAdapter(this.oao);
      this.HLx.setModal(true);
      this.HLx.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131233518));
      this.HLx.setAnimationStyle(this.HLy);
      this.HLx.apa = k;
      this.HLx.apl = this.oP;
      if (this.oP != null)
      {
        if (this.adE != null) {
          break label869;
        }
        bool = true;
        label276:
        this.adE = this.oP.getViewTreeObserver();
        ac.v("MicroMsg.SubMenuHelperBase", "tryshow addGlobalListener:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          this.adE.addOnGlobalLayoutListener(this);
        }
      }
      this.HLx.setVerticalOffset(j);
      this.HLx.mHk = this.mHk;
      this.HLx.setContentWidth(Math.min(b(this.oao), this.afe));
      this.HLx.kg();
      if ((this.IUD != 0.0F) && (this.IUE != 0.0F))
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
        i = (int)(this.IUE * j);
        label503:
        ac.d("MicroMsg.SubMenuHelperBase", "menuHeightPercentPort(%f), menuHeightPercentLand(%f), frameHeight(%d), decorViewHeight(%d), menuHeight(%d)", new Object[] { Float.valueOf(this.IUD), Float.valueOf(this.IUE), Integer.valueOf(((Rect)localObject1).height()), Integer.valueOf(j), Integer.valueOf(i) });
        i = Math.round(i / this.nly);
        if ((i <= 0) || (this.oao == null)) {
          break label933;
        }
        j = this.nly * i + this.IUB;
        if ((j == 0) || (j >= this.oao.getCount() * this.nly)) {
          break label892;
        }
        j = this.nly;
        k = this.IUB;
        int m = this.IUC;
        this.HLx.aoZ = ((i - 1) * j + k + m);
      }
      for (;;)
      {
        if ((this.HLx != null) && (this.IUz != null))
        {
          localObject1 = this.HLx;
          localObject2 = this.IUz;
          bool = ((MMListPopupWindow)localObject1).jat.isShowing();
          if (bool) {
            ((MMListPopupWindow)localObject1).kf();
          }
          ((MMListPopupWindow)localObject1).apj = ((View)localObject2);
          if (bool) {
            ((MMListPopupWindow)localObject1).show();
          }
          this.HLx.apk = this.IUA;
        }
        this.HLx.show();
        this.HLx.Hyb.setOnKeyListener(this);
        this.HLx.Hyb.setSelector(new ColorDrawable(this.mContext.getResources().getColor(2131101053)));
        this.HLx.Hyb.setDividerHeight(0);
        this.HLx.Hyb.setVerticalScrollBarEnabled(true);
        this.HLx.Hyb.setHorizontalScrollBarEnabled(false);
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
        i = (int)(this.IUD * j);
        break label503;
        label892:
        ac.w("MicroMsg.SubMenuHelperBase", "[cpan] menuheight:%d,listHeight:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(this.oao.getCount() * this.nly) });
        continue;
        ac.e("MicroMsg.SubMenuHelperBase", "[cpan] setpopuHeight error.");
      }
    }
  }
  
  public final boolean isShowing()
  {
    return (this.HLx != null) && (this.HLx.jat.isShowing());
  }
  
  public void onDismiss()
  {
    if (this.adE != null)
    {
      if (!this.adE.isAlive()) {
        this.adE = this.oP.getViewTreeObserver();
      }
      this.adE.removeGlobalOnLayoutListener(this);
      this.adE = null;
    }
    if (this.xbq != null) {
      this.xbq.onCancel(null);
    }
    if (this.IUx != null) {
      this.IUx.onDismiss();
    }
  }
  
  public void onGlobalLayout()
  {
    ac.v("MicroMsg.SubMenuHelperBase", "onGlobalLayout showing:%b, anchorshown:%b", new Object[] { Boolean.valueOf(isShowing()), Boolean.valueOf(this.oP.isShown()) });
    if (isShowing())
    {
      View localView = this.oP;
      if ((localView != null) && (localView.isShown())) {
        break label64;
      }
      dismiss();
    }
    label64:
    while ((!isShowing()) || (this.lcE == aly())) {
      return;
    }
    this.HLx.dismiss();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    dismiss();
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    ac.v("MicroMsg.SubMenuHelperBase", "onKey");
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      dismiss();
      return true;
    }
    return false;
  }
  
  public final void xP(boolean paramBoolean)
  {
    this.mHk = paramBoolean;
    if (paramBoolean)
    {
      this.HLy = 2131820809;
      return;
    }
    this.HLy = 2131820865;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.s
 * JD-Core Version:    0.7.0.1
 */