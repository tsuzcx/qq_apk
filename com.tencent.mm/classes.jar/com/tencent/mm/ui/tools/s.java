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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.o;

public abstract class s
  implements View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private MMListPopupWindow GlI;
  private int GlJ = 2131820865;
  private ViewGroup HtZ;
  private PopupWindow.OnDismissListener Hua;
  private boolean Hub = true;
  private View Huc;
  private int Hud;
  private int Hue = 0;
  private int Huf = 0;
  private float Hug = 0.0F;
  private float Huh = 0.0F;
  private ViewTreeObserver acK;
  private int aek;
  private int dividerHeight;
  private boolean kBm = false;
  protected Context mContext;
  private int mJv = 0;
  private boolean mfl = false;
  private View nO;
  private BaseAdapter nxo;
  private DialogInterface.OnCancelListener vQI;
  
  public s(Context paramContext)
  {
    this.mContext = paramContext;
    paramContext = paramContext.getResources();
    this.aek = Math.min(paramContext.getDisplayMetrics().widthPixels * 4 / 5, paramContext.getDimensionPixelSize(2131165522));
    ViewGroup localViewGroup;
    if ((this.mContext instanceof Activity))
    {
      localViewGroup = (ViewGroup)((Activity)this.mContext).getWindow().getDecorView();
      if (localViewGroup.getChildCount() <= 0) {
        break label183;
      }
    }
    label183:
    for (this.nO = localViewGroup.getChildAt(0);; this.nO = localViewGroup)
    {
      this.dividerHeight = BackwardSupportUtil.b.g(this.mContext, 1.0F);
      this.Hue = (paramContext.getDimensionPixelSize(2131165516) * 2);
      this.mJv = paramContext.getDimensionPixelSize(2131165255);
      this.Huf = BackwardSupportUtil.b.g(this.mContext, 36.0F);
      this.nxo = VY();
      return;
    }
  }
  
  private boolean aov()
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
      if (this.HtZ == null) {
        this.HtZ = new FrameLayout(this.mContext);
      }
      localView = paramListAdapter.getView(j, localView, this.HtZ);
      localView.measure(n, i1);
      k = Math.max(k, localView.getMeasuredWidth());
      j += 1;
      break;
      return k;
    }
  }
  
  protected abstract BaseAdapter VY();
  
  public final void dismiss()
  {
    if (isShowing()) {
      this.GlI.dismiss();
    }
  }
  
  public boolean hM()
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
      k = ao.ap(this.mContext, 2131165303);
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
      this.kBm = aov();
      if (this.GlI == null) {
        this.GlI = new MMListPopupWindow(this.mContext, null, 0);
      }
      this.GlI.setOnDismissListener(this);
      this.GlI.aos = this;
      this.GlI.setAdapter(this.nxo);
      this.GlI.setModal(true);
      this.GlI.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131233518));
      this.GlI.setAnimationStyle(this.GlJ);
      this.GlI.aof = k;
      this.GlI.aoq = this.nO;
      if (this.nO != null)
      {
        if (this.acK != null) {
          break label869;
        }
        bool = true;
        label276:
        this.acK = this.nO.getViewTreeObserver();
        ad.v("MicroMsg.SubMenuHelperBase", "tryshow addGlobalListener:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          this.acK.addOnGlobalLayoutListener(this);
        }
      }
      this.GlI.setVerticalOffset(j);
      this.GlI.mfl = this.mfl;
      this.GlI.setContentWidth(Math.min(b(this.nxo), this.aek));
      this.GlI.jY();
      if ((this.Hug != 0.0F) && (this.Huh != 0.0F))
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
        i = (int)(this.Huh * j);
        label503:
        ad.d("MicroMsg.SubMenuHelperBase", "menuHeightPercentPort(%f), menuHeightPercentLand(%f), frameHeight(%d), decorViewHeight(%d), menuHeight(%d)", new Object[] { Float.valueOf(this.Hug), Float.valueOf(this.Huh), Integer.valueOf(((Rect)localObject1).height()), Integer.valueOf(j), Integer.valueOf(i) });
        i = Math.round(i / this.mJv);
        if ((i <= 0) || (this.nxo == null)) {
          break label933;
        }
        j = this.mJv * i + this.Hue;
        if ((j == 0) || (j >= this.nxo.getCount() * this.mJv)) {
          break label892;
        }
        j = this.mJv;
        k = this.Hue;
        int m = this.Huf;
        this.GlI.aoe = ((i - 1) * j + k + m);
      }
      for (;;)
      {
        if ((this.GlI != null) && (this.Huc != null))
        {
          localObject1 = this.GlI;
          localObject2 = this.Huc;
          bool = ((MMListPopupWindow)localObject1).iAs.isShowing();
          if (bool) {
            ((MMListPopupWindow)localObject1).jX();
          }
          ((MMListPopupWindow)localObject1).aoo = ((View)localObject2);
          if (bool) {
            ((MMListPopupWindow)localObject1).show();
          }
          this.GlI.aop = this.Hud;
        }
        this.GlI.show();
        this.GlI.FYm.setOnKeyListener(this);
        this.GlI.FYm.setSelector(new ColorDrawable(this.mContext.getResources().getColor(2131101053)));
        this.GlI.FYm.setDividerHeight(0);
        this.GlI.FYm.setVerticalScrollBarEnabled(true);
        this.GlI.FYm.setHorizontalScrollBarEnabled(false);
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
        i = (int)(this.Hug * j);
        break label503;
        label892:
        ad.w("MicroMsg.SubMenuHelperBase", "[cpan] menuheight:%d,listHeight:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(this.nxo.getCount() * this.mJv) });
        continue;
        ad.e("MicroMsg.SubMenuHelperBase", "[cpan] setpopuHeight error.");
      }
    }
  }
  
  public final boolean isShowing()
  {
    return (this.GlI != null) && (this.GlI.iAs.isShowing());
  }
  
  public void onDismiss()
  {
    if (this.acK != null)
    {
      if (!this.acK.isAlive()) {
        this.acK = this.nO.getViewTreeObserver();
      }
      this.acK.removeGlobalOnLayoutListener(this);
      this.acK = null;
    }
    if (this.vQI != null) {
      this.vQI.onCancel(null);
    }
    if (this.Hua != null) {
      this.Hua.onDismiss();
    }
  }
  
  public void onGlobalLayout()
  {
    ad.v("MicroMsg.SubMenuHelperBase", "onGlobalLayout showing:%b, anchorshown:%b", new Object[] { Boolean.valueOf(isShowing()), Boolean.valueOf(this.nO.isShown()) });
    if (isShowing())
    {
      View localView = this.nO;
      if ((localView != null) && (localView.isShown())) {
        break label64;
      }
      dismiss();
    }
    label64:
    while ((!isShowing()) || (this.kBm == aov())) {
      return;
    }
    this.GlI.dismiss();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    dismiss();
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    ad.v("MicroMsg.SubMenuHelperBase", "onKey");
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      dismiss();
      return true;
    }
    return false;
  }
  
  public final void wI(boolean paramBoolean)
  {
    this.mfl = paramBoolean;
    if (paramBoolean)
    {
      this.GlJ = 2131820809;
      return;
    }
    this.GlJ = 2131820865;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.s
 * JD-Core Version:    0.7.0.1
 */