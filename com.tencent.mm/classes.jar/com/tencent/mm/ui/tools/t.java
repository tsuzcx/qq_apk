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
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.bd;

public abstract class t
  implements View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private DialogInterface.OnCancelListener OTa;
  private MMListPopupWindow aefY;
  private int aefZ = a.l.DropMenuAnimation;
  private ViewGroup afLo;
  private PopupWindow.OnDismissListener afLp;
  private boolean afLq = true;
  private View afLr;
  private int afLs;
  private int afLt = 0;
  private int afLu = 0;
  private float afLv = 0.0F;
  private float afLw = 0.0F;
  private int lCp;
  protected Context mContext;
  private View mF;
  private ViewTreeObserver mP;
  private int ou;
  private boolean sRw = false;
  private boolean uKu = false;
  private int vqq = 0;
  private BaseAdapter wyr;
  
  public t(Context paramContext)
  {
    this.mContext = paramContext;
    paramContext = paramContext.getResources();
    this.ou = Math.min(paramContext.getDisplayMetrics().widthPixels * 4 / 5, paramContext.getDimensionPixelSize(a.e.PlusMenuWidth));
    ViewGroup localViewGroup;
    if ((this.mContext instanceof Activity))
    {
      localViewGroup = (ViewGroup)((Activity)this.mContext).getWindow().getDecorView();
      if (localViewGroup.getChildCount() <= 0) {
        break label187;
      }
    }
    label187:
    for (this.mF = localViewGroup.getChildAt(0);; this.mF = localViewGroup)
    {
      this.lCp = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 1.0F);
      this.afLt = (paramContext.getDimensionPixelSize(a.e.NormalPadding) * 2);
      this.vqq = paramContext.getDimensionPixelSize(a.e.DefaultListItemHeight);
      this.afLu = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 36.0F);
      this.wyr = aNu();
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
      if (this.afLo == null) {
        this.afLo = new FrameLayout(this.mContext);
      }
      localView = paramListAdapter.getView(j, localView, this.afLo);
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
  
  public final void Na(boolean paramBoolean)
  {
    this.uKu = paramBoolean;
    if (paramBoolean)
    {
      this.aefZ = a.l.CenterMenuAnimation;
      return;
    }
    this.aefZ = a.l.DropMenuAnimation;
  }
  
  protected abstract BaseAdapter aNu();
  
  public final void dismiss()
  {
    if (isShowing()) {
      this.aefY.dismiss();
    }
  }
  
  public boolean du()
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
      k = bd.bs(this.mContext, a.e.Edge_A);
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
      this.sRw = isLandscape();
      if (this.aefY == null) {
        this.aefY = new MMListPopupWindow(this.mContext, null, 0);
      }
      this.aefY.setOnDismissListener(this);
      this.aefY.un = this;
      this.aefY.setAdapter(this.wyr);
      this.aefY.LA(true);
      this.aefY.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.f.ofm_menu_bg));
      this.aefY.aAU(this.aefZ);
      this.aefY.tZ = k;
      this.aefY.ul = this.mF;
      if (this.mF != null)
      {
        if (this.mP != null) {
          break label871;
        }
        bool = true;
        label278:
        this.mP = this.mF.getViewTreeObserver();
        Log.v("MicroMsg.SubMenuHelperBase", "tryshow addGlobalListener:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          this.mP.addOnGlobalLayoutListener(this);
        }
      }
      this.aefY.ad(j);
      this.aefY.uKu = this.uKu;
      this.aefY.setContentWidth(Math.min(c(this.wyr), this.ou));
      this.aefY.eN();
      if ((this.afLv != 0.0F) && (this.afLw != 0.0F))
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
        i = (int)(this.afLw * j);
        label505:
        Log.d("MicroMsg.SubMenuHelperBase", "menuHeightPercentPort(%f), menuHeightPercentLand(%f), frameHeight(%d), decorViewHeight(%d), menuHeight(%d)", new Object[] { Float.valueOf(this.afLv), Float.valueOf(this.afLw), Integer.valueOf(((Rect)localObject1).height()), Integer.valueOf(j), Integer.valueOf(i) });
        i = Math.round(i / this.vqq);
        if ((i <= 0) || (this.wyr == null)) {
          break label935;
        }
        j = this.vqq * i + this.afLt;
        if ((j == 0) || (j >= this.wyr.getCount() * this.vqq)) {
          break label894;
        }
        j = this.vqq;
        k = this.afLt;
        int m = this.afLu;
        this.aefY.tY = ((i - 1) * j + k + m);
      }
      for (;;)
      {
        if ((this.aefY != null) && (this.afLr != null))
        {
          localObject1 = this.aefY;
          localObject2 = this.afLr;
          bool = ((MMListPopupWindow)localObject1).qjH.isShowing();
          if (bool) {
            ((MMListPopupWindow)localObject1).eM();
          }
          ((MMListPopupWindow)localObject1).uj = ((View)localObject2);
          if (bool) {
            ((MMListPopupWindow)localObject1).show();
          }
          this.aefY.uk = this.afLs;
        }
        this.aefY.show();
        this.aefY.adRQ.setOnKeyListener(this);
        this.aefY.adRQ.setSelector(new ColorDrawable(this.mContext.getResources().getColor(a.d.transparent)));
        this.aefY.adRQ.setDividerHeight(0);
        this.aefY.adRQ.setVerticalScrollBarEnabled(true);
        this.aefY.adRQ.setHorizontalScrollBarEnabled(false);
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
        i = (int)(this.afLv * j);
        break label505;
        label894:
        Log.w("MicroMsg.SubMenuHelperBase", "[cpan] menuheight:%d,listHeight:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(this.wyr.getCount() * this.vqq) });
        continue;
        Log.e("MicroMsg.SubMenuHelperBase", "[cpan] setpopuHeight error.");
      }
    }
  }
  
  public final boolean isShowing()
  {
    return (this.aefY != null) && (this.aefY.qjH.isShowing());
  }
  
  public void onDismiss()
  {
    if (this.mP != null)
    {
      if (!this.mP.isAlive()) {
        this.mP = this.mF.getViewTreeObserver();
      }
      this.mP.removeGlobalOnLayoutListener(this);
      this.mP = null;
    }
    if (this.OTa != null) {
      this.OTa.onCancel(null);
    }
    if (this.afLp != null) {
      this.afLp.onDismiss();
    }
  }
  
  public void onGlobalLayout()
  {
    Log.v("MicroMsg.SubMenuHelperBase", "onGlobalLayout showing:%b, anchorshown:%b", new Object[] { Boolean.valueOf(isShowing()), Boolean.valueOf(this.mF.isShown()) });
    if (isShowing())
    {
      View localView = this.mF;
      if ((localView != null) && (localView.isShown())) {
        break label64;
      }
      dismiss();
    }
    label64:
    while ((!isShowing()) || (this.sRw == isLandscape())) {
      return;
    }
    this.aefY.dismiss();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    b localb = new b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    a.c("com/tencent/mm/ui/tools/SubMenuHelperBase", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    dismiss();
    a.a(this, "com/tencent/mm/ui/tools/SubMenuHelperBase", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    b localb = new b();
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.cH(paramKeyEvent);
    a.c("com/tencent/mm/ui/tools/SubMenuHelperBase", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aYj());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.t
 * JD-Core Version:    0.7.0.1
 */