package com.tencent.mm.ui.widget.snackbar;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ci.a.f;
import com.tencent.mm.ci.a.g;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aq;

public final class a
{
  Handler mHandler = new Handler();
  View mParentView;
  SnackContainer wpO;
  b wpP;
  a.c wpQ;
  private final View.OnClickListener wpR = new a.1(this);
  
  public a(Activity paramActivity, int paramInt)
  {
    View localView = paramActivity.findViewById(16908290);
    Object localObject = (LayoutInflater)paramActivity.getSystemService("layout_inflater");
    ((LayoutInflater)localObject).inflate(a.g.snackbar_container, (ViewGroup)localView);
    localObject = ((LayoutInflater)localObject).inflate(a.g.snackbar_main, (ViewGroup)localView, false);
    a((ViewGroup)localView, (View)localObject, paramInt, paramActivity);
  }
  
  public a(Context paramContext, View paramView, int paramInt)
  {
    if ((paramView == null) && ((paramContext instanceof Activity))) {
      paramView = ((Activity)paramContext).findViewById(16908290);
    }
    for (;;)
    {
      Object localObject = (LayoutInflater)paramContext.getSystemService("layout_inflater");
      ((LayoutInflater)localObject).inflate(a.g.snackbar_container, (ViewGroup)paramView);
      localObject = ((LayoutInflater)localObject).inflate(a.g.snackbar_main, (ViewGroup)paramView, false);
      a((ViewGroup)paramView, (View)localObject, paramInt, paramContext);
      return;
    }
  }
  
  private void a(ViewGroup paramViewGroup, View paramView, int paramInt, Context paramContext)
  {
    if (paramViewGroup == null) {
      return;
    }
    this.wpO = ((SnackContainer)paramViewGroup.findViewById(a.f.snackContainer));
    if (this.wpO == null) {
      this.wpO = new SnackContainer(paramViewGroup);
    }
    this.mParentView = paramView;
    if (paramInt == 36) {
      this.wpO.setOnTouchListener(new a.2(this));
    }
    ((TextView)paramView.findViewById(a.f.snackButton)).setOnClickListener(this.wpR);
    boolean bool2 = aq.gw(paramContext);
    paramInt = aq.gv(paramContext);
    ao.t("snackbar:isNavBarVisibility : %B,navBarHeightd:%d", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(paramInt) });
    paramViewGroup = (Activity)paramContext;
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramViewGroup = paramViewGroup.getWindow().getAttributes();
      if (paramViewGroup.flags != (paramViewGroup.flags & 0xF7FFFFFF | 0x8000000)) {}
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      ao.t("snackbar:isNavBarTranslucent : %B", new Object[] { Boolean.valueOf(bool1) });
      if ((!bool1) || (!bool2)) {
        break;
      }
      paramViewGroup = (LinearLayout)paramView.findViewById(a.f.snackBar);
      paramView = (ViewGroup.MarginLayoutParams)paramViewGroup.getLayoutParams();
      paramView.bottomMargin = paramInt;
      paramViewGroup.setLayoutParams(paramView);
      return;
    }
  }
  
  public static abstract interface b
  {
    public abstract void amw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.a
 * JD-Core Version:    0.7.0.1
 */