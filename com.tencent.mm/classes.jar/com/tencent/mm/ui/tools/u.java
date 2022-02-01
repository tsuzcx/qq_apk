package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
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
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.l;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.r;

public abstract class u
  implements View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private DialogInterface.OnCancelListener IOJ;
  private MMListPopupWindow WyB;
  private int WyC = a.l.DropMenuAnimation;
  private ViewGroup XUZ;
  private PopupWindow.OnDismissListener XVa;
  private boolean XVb = true;
  private View XVc;
  private int XVd;
  private int XVe = 0;
  private int XVf = 0;
  private float XVg = 0.0F;
  private float XVh = 0.0F;
  private int jau;
  private View lJ;
  private ViewTreeObserver lS;
  protected Context mContext;
  private int nv;
  private boolean pMD = false;
  private boolean rzr = false;
  private int seC = 0;
  private BaseAdapter ttU;
  
  public u(Context paramContext)
  {
    this.mContext = paramContext;
    paramContext = paramContext.getResources();
    this.nv = Math.min(paramContext.getDisplayMetrics().widthPixels * 4 / 5, paramContext.getDimensionPixelSize(a.e.PlusMenuWidth));
    ViewGroup localViewGroup;
    if ((this.mContext instanceof Activity))
    {
      localViewGroup = (ViewGroup)((Activity)this.mContext).getWindow().getDecorView();
      if (localViewGroup.getChildCount() <= 0) {
        break label187;
      }
    }
    label187:
    for (this.lJ = localViewGroup.getChildAt(0);; this.lJ = localViewGroup)
    {
      this.jau = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 1.0F);
      this.XVe = (paramContext.getDimensionPixelSize(a.e.NormalPadding) * 2);
      this.seC = paramContext.getDimensionPixelSize(a.e.DefaultListItemHeight);
      this.XVf = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 36.0F);
      this.ttU = atn();
      return;
    }
  }
  
  private int c(ListAdapter paramListAdapter)
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
      if (this.XUZ == null) {
        this.XUZ = new FrameLayout(this.mContext);
      }
      localView = paramListAdapter.getView(j, localView, this.XUZ);
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
  
  public final void Hf(boolean paramBoolean)
  {
    this.rzr = paramBoolean;
    if (paramBoolean)
    {
      this.WyC = a.l.CenterMenuAnimation;
      return;
    }
    this.WyC = a.l.DropMenuAnimation;
  }
  
  protected abstract BaseAdapter atn();
  
  public boolean cB()
  {
    Object localObject1 = new Rect();
    int i;
    int k;
    int j;
    Object localObject2;
    label144:
    boolean bool;
    if ((this.mContext instanceof AppCompatActivity))
    {
      i = ((AppCompatActivity)this.mContext).getSupportActionBar().getHeight();
      k = aw.aZ(this.mContext, a.e.Edge_A);
      j = i;
      if ((this.mContext instanceof Activity))
      {
        ((Activity)this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
        j = ((Activity)this.mContext).getWindow().getDecorView().getHeight();
        localObject2 = new int[2];
        ((Activity)this.mContext).getWindow().getDecorView().getLocationOnScreen((int[])localObject2);
        if ((j - ((Rect)localObject1).height() < 0) || (localObject2[1] <= 200)) {
          break label860;
        }
        j = i + (j - ((Rect)localObject1).height());
      }
      this.pMD = isLandscape();
      if (this.WyB == null) {
        this.WyB = new MMListPopupWindow(this.mContext, null, 0);
      }
      this.WyB.setOnDismissListener(this);
      this.WyB.tp = this;
      this.WyB.setAdapter(this.ttU);
      this.WyB.P(true);
      this.WyB.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.f.ofm_menu_bg));
      this.WyB.ax(this.WyC);
      this.WyB.ta = k;
      this.WyB.tl = this.lJ;
      if (this.lJ != null)
      {
        if (this.lS != null) {
          break label871;
        }
        bool = true;
        label278:
        this.lS = this.lJ.getViewTreeObserver();
        Log.v("MicroMsg.SubMenuHelperBase", "tryshow addGlobalListener:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          this.lS.addOnGlobalLayoutListener(this);
        }
      }
      this.WyB.ah(j);
      this.WyB.rzr = this.rzr;
      this.WyB.setContentWidth(Math.min(c(this.ttU), this.nv));
      this.WyB.dN();
      if ((this.XVg != 0.0F) && (this.XVh != 0.0F))
      {
        localObject1 = new DisplayMetrics();
        ((Activity)this.mContext).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        if (((DisplayMetrics)localObject1).widthPixels <= ((DisplayMetrics)localObject1).heightPixels) {
          break label877;
        }
        i = 1;
        label433:
        localObject1 = new Rect();
        ((Activity)this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
        j = ((Activity)this.mContext).getWindow().getDecorView().getHeight();
        if (j <= ((Rect)localObject1).height()) {
          break label947;
        }
        j = ((Rect)localObject1).height();
      }
    }
    label935:
    label947:
    for (;;)
    {
      if (i != 0)
      {
        i = (int)(this.XVh * j);
        label505:
        Log.d("MicroMsg.SubMenuHelperBase", "menuHeightPercentPort(%f), menuHeightPercentLand(%f), frameHeight(%d), decorViewHeight(%d), menuHeight(%d)", new Object[] { Float.valueOf(this.XVg), Float.valueOf(this.XVh), Integer.valueOf(((Rect)localObject1).height()), Integer.valueOf(j), Integer.valueOf(i) });
        i = Math.round(i / this.seC);
        if ((i <= 0) || (this.ttU == null)) {
          break label935;
        }
        j = this.seC * i + this.XVe;
        if ((j == 0) || (j >= this.ttU.getCount() * this.seC)) {
          break label894;
        }
        j = this.seC;
        k = this.XVe;
        int m = this.XVf;
        this.WyB.sZ = ((i - 1) * j + k + m);
      }
      for (;;)
      {
        if ((this.WyB != null) && (this.XVc != null))
        {
          localObject1 = this.WyB;
          localObject2 = this.XVc;
          bool = ((MMListPopupWindow)localObject1).nmy.isShowing();
          if (bool) {
            ((MMListPopupWindow)localObject1).dM();
          }
          ((MMListPopupWindow)localObject1).tj = ((View)localObject2);
          if (bool) {
            ((MMListPopupWindow)localObject1).show();
          }
          this.WyB.tk = this.XVd;
        }
        this.WyB.show();
        this.WyB.WkJ.setOnKeyListener(this);
        this.WyB.WkJ.setSelector(new ColorDrawable(this.mContext.getResources().getColor(a.d.transparent)));
        this.WyB.WkJ.setDividerHeight(0);
        this.WyB.WkJ.setVerticalScrollBarEnabled(true);
        this.WyB.WkJ.setHorizontalScrollBarEnabled(false);
        return true;
        localObject2 = this.mContext.getResources().getDisplayMetrics();
        if (((DisplayMetrics)localObject2).widthPixels > ((DisplayMetrics)localObject2).heightPixels)
        {
          i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 40.0F);
          break;
        }
        i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 49.0F);
        break;
        label860:
        j = i + ((Rect)localObject1).top;
        break label144;
        label871:
        bool = false;
        break label278;
        label877:
        i = 0;
        break label433;
        i = (int)(this.XVg * j);
        break label505;
        label894:
        Log.w("MicroMsg.SubMenuHelperBase", "[cpan] menuheight:%d,listHeight:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(this.ttU.getCount() * this.seC) });
        continue;
        Log.e("MicroMsg.SubMenuHelperBase", "[cpan] setpopuHeight error.");
      }
    }
  }
  
  public final void dismiss()
  {
    if (isShowing()) {
      this.WyB.dismiss();
    }
  }
  
  public final boolean isShowing()
  {
    return (this.WyB != null) && (this.WyB.nmy.isShowing());
  }
  
  public void onDismiss()
  {
    if (this.lS != null)
    {
      if (!this.lS.isAlive()) {
        this.lS = this.lJ.getViewTreeObserver();
      }
      this.lS.removeGlobalOnLayoutListener(this);
      this.lS = null;
    }
    if (this.IOJ != null) {
      this.IOJ.onCancel(null);
    }
    if (this.XVa != null) {
      this.XVa.onDismiss();
    }
  }
  
  public void onGlobalLayout()
  {
    Log.v("MicroMsg.SubMenuHelperBase", "onGlobalLayout showing:%b, anchorshown:%b", new Object[] { Boolean.valueOf(isShowing()), Boolean.valueOf(this.lJ.isShown()) });
    if (isShowing())
    {
      View localView = this.lJ;
      if ((localView != null) && (localView.isShown())) {
        break label64;
      }
      dismiss();
    }
    label64:
    while ((!isShowing()) || (this.pMD == isLandscape())) {
      return;
    }
    this.WyB.dismiss();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    b localb = new b();
    localb.bn(paramAdapterView);
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.Fs(paramLong);
    a.c("com/tencent/mm/ui/tools/SubMenuHelperBase", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
    dismiss();
    a.a(this, "com/tencent/mm/ui/tools/SubMenuHelperBase", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    b localb = new b();
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.bn(paramKeyEvent);
    a.c("com/tencent/mm/ui/tools/SubMenuHelperBase", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aFi());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.u
 * JD-Core Version:    0.7.0.1
 */