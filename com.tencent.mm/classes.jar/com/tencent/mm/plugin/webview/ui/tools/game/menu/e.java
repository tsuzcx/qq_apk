package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.i;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.m;

public final class e
  extends i
{
  private Context mContext;
  
  public e(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private e(Context paramContext, byte paramByte)
  {
    super(paramContext, R.m.GameMenuSheetStyle);
    et();
    this.mContext = paramContext;
  }
  
  private View b(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    Object localObject1 = getWindow();
    Object localObject2;
    View localView;
    if (biH())
    {
      ((Window)localObject1).setGravity(5);
      ((Window)localObject1).setWindowAnimations(R.m.RightToLeftAnimation);
      ((Window)localObject1).getDecorView().setPadding(0, 0, 0, 0);
      localObject2 = ((Window)localObject1).getAttributes();
      ((WindowManager.LayoutParams)localObject2).width = -1;
      ((WindowManager.LayoutParams)localObject2).height = -1;
      ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
      localObject2 = (ViewGroup)LayoutInflater.from(this.mContext).inflate(R.i.game_menu_sheet_dialog, null);
      localView = ((ViewGroup)localObject2).findViewById(R.h.touch_outside);
      localObject1 = paramView;
      if (paramInt != 0)
      {
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = getLayoutInflater().inflate(paramInt, (ViewGroup)localObject2, false);
        }
      }
      if (!biH()) {
        break label203;
      }
      paramView = (FrameLayout)((ViewGroup)localObject2).findViewById(R.h.menu_sheet_right_container);
      label140:
      paramView.setVisibility(0);
      if (paramLayoutParams != null) {
        break label218;
      }
      paramView.addView((View)localObject1);
      label155:
      if (Build.VERSION.SDK_INT >= 11) {
        break label228;
      }
      paramInt = 1;
    }
    for (;;)
    {
      if (paramInt != 0) {
        localView.setOnClickListener(new e.1(this));
      }
      return localObject2;
      ((Window)localObject1).setGravity(80);
      ((Window)localObject1).setWindowAnimations(R.m.BottomToTopAnimation);
      break;
      label203:
      paramView = (FrameLayout)((ViewGroup)localObject2).findViewById(R.h.menu_sheet_bottom_container);
      break label140;
      label218:
      paramView.addView((View)localObject1, paramLayoutParams);
      break label155;
      label228:
      paramView = new TypedValue();
      if (getContext().getTheme().resolveAttribute(16843611, paramView, true))
      {
        if (paramView.data != 0) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
      }
      else {
        paramInt = 0;
      }
    }
  }
  
  private boolean biH()
  {
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    return localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.e
 * JD-Core Version:    0.7.0.1
 */