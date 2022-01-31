package com.tencent.mm.ui.widget.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v7.app.i;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.ci.a.f;
import com.tencent.mm.ci.a.g;
import com.tencent.mm.ci.a.j;
import com.tencent.mm.ui.aq;

public final class b
  extends i
{
  private Context mContext;
  
  public b(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private b(Context paramContext, byte paramByte)
  {
    super(paramContext, a.j.CustomSheetStyle);
    this.mContext = paramContext;
    et();
  }
  
  private View b(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    int i = 0;
    Object localObject1 = getWindow();
    Object localObject2;
    label69:
    ViewGroup localViewGroup;
    View localView;
    if (biH())
    {
      ((Window)localObject1).setGravity(5);
      ((Window)localObject1).setWindowAnimations(a.j.RightToLeftAnimation);
      ((Window)localObject1).getDecorView().setPadding(0, 0, 0, 0);
      localObject2 = ((Window)localObject1).getAttributes();
      if (!biH()) {
        break label275;
      }
      ((WindowManager.LayoutParams)localObject2).width = -2;
      ((WindowManager.LayoutParams)localObject2).height = -1;
      ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
      localViewGroup = (ViewGroup)LayoutInflater.from(this.mContext).inflate(a.g.menu_sheet_dialog, null);
      localView = localViewGroup.findViewById(a.f.touch_outside);
      localObject1 = paramView;
      if (paramInt != 0)
      {
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = getLayoutInflater().inflate(paramInt, localViewGroup, false);
        }
      }
      if (!biH()) {
        break label310;
      }
      localObject2 = (FrameLayout)localViewGroup.findViewById(a.f.menu_sheet_right_container);
      paramView = (View)localObject2;
      if (localObject2 != null)
      {
        paramView = (CoordinatorLayout.d)((FrameLayout)localObject2).getLayoutParams();
        if (!aq.gw(this.mContext)) {
          break label378;
        }
      }
    }
    label203:
    label212:
    label227:
    label378:
    for (paramInt = aq.gv(this.mContext);; paramInt = 0)
    {
      if (getRotation() == 1)
      {
        paramView.setMargins(0, 0, paramInt, 0);
        ((FrameLayout)localObject2).setLayoutParams(paramView);
        paramView = (View)localObject2;
        paramView.setVisibility(0);
        if (paramLayoutParams != null) {
          break label325;
        }
        paramView.addView((View)localObject1);
        if (Build.VERSION.SDK_INT >= 11) {
          break label335;
        }
        paramInt = 1;
      }
      for (;;)
      {
        if (paramInt != 0) {
          localView.setOnClickListener(new b.1(this));
        }
        return localViewGroup;
        ((Window)localObject1).setGravity(80);
        ((Window)localObject1).setWindowAnimations(a.j.BottomToTopAnimation);
        break;
        ((WindowManager.LayoutParams)localObject2).width = -1;
        ((WindowManager.LayoutParams)localObject2).height = -2;
        break label69;
        if (getRotation() != 3) {
          break label203;
        }
        paramView.setMargins(paramInt, 0, 0, 0);
        break label203;
        paramView = (FrameLayout)localViewGroup.findViewById(a.f.menu_sheet_bottom_container);
        break label212;
        paramView.addView((View)localObject1, paramLayoutParams);
        break label227;
        paramView = new TypedValue();
        paramInt = i;
        if (getContext().getTheme().resolveAttribute(16843611, paramView, true))
        {
          paramInt = i;
          if (paramView.data != 0) {
            paramInt = 1;
          }
        }
      }
    }
  }
  
  private boolean biH()
  {
    return this.mContext.getResources().getConfiguration().orientation == 2;
  }
  
  @SuppressLint({"WrongConstant"})
  private int getRotation()
  {
    return getWindow().getWindowManager().getDefaultDisplay().getRotation();
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setLayout(-1, -1);
  }
  
  public final void setContentView(int paramInt)
  {
    super.setContentView(b(paramInt, null, null));
  }
  
  public final void setContentView(View paramView)
  {
    super.setContentView(b(0, paramView, null));
  }
  
  public final void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(b(0, paramView, paramLayoutParams));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.b
 * JD-Core Version:    0.7.0.1
 */