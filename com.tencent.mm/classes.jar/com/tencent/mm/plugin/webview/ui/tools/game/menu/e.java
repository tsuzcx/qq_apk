package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.j;

public final class e
  extends androidx.appcompat.app.e
{
  private Context mContext;
  
  public e(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private e(Context paramContext, byte paramByte)
  {
    super(paramContext, c.j.GameMenuSheetStyle);
    AppMethodBeat.i(80990);
    bb();
    this.mContext = paramContext;
    AppMethodBeat.o(80990);
  }
  
  private View b(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(80995);
    Object localObject1 = getWindow();
    Object localObject2;
    View localView;
    if (isLandscape())
    {
      ((Window)localObject1).setGravity(5);
      ((Window)localObject1).setWindowAnimations(c.j.RightToLeftAnimation);
      ((Window)localObject1).getDecorView().setPadding(0, 0, 0, 0);
      localObject2 = ((Window)localObject1).getAttributes();
      ((WindowManager.LayoutParams)localObject2).width = -1;
      ((WindowManager.LayoutParams)localObject2).height = -1;
      ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
      localObject2 = (ViewGroup)LayoutInflater.from(this.mContext).inflate(c.g.game_menu_sheet_dialog, null);
      localView = ((ViewGroup)localObject2).findViewById(c.f.touch_outside);
      localObject1 = paramView;
      if (paramInt != 0)
      {
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = getLayoutInflater().inflate(paramInt, (ViewGroup)localObject2, false);
        }
      }
      if (!isLandscape()) {
        break label206;
      }
      paramView = (FrameLayout)((ViewGroup)localObject2).findViewById(c.f.menu_sheet_right_container);
      label145:
      paramView.setVisibility(0);
      if (paramLayoutParams != null) {
        break label221;
      }
      paramView.addView((View)localObject1);
    }
    for (;;)
    {
      if (haG()) {
        localView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(80989);
            b localb = new b();
            localb.bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/webview/ui/tools/game/menu/GameSheetDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (e.this.isShowing()) {
              e.this.cancel();
            }
            a.a(this, "com/tencent/mm/plugin/webview/ui/tools/game/menu/GameSheetDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(80989);
          }
        });
      }
      AppMethodBeat.o(80995);
      return localObject2;
      ((Window)localObject1).setGravity(80);
      ((Window)localObject1).setWindowAnimations(c.j.BottomToTopAnimation);
      break;
      label206:
      paramView = (FrameLayout)((ViewGroup)localObject2).findViewById(c.f.menu_sheet_bottom_container);
      break label145;
      label221:
      paramView.addView((View)localObject1, paramLayoutParams);
    }
  }
  
  private boolean haG()
  {
    AppMethodBeat.i(80996);
    if (Build.VERSION.SDK_INT < 11)
    {
      AppMethodBeat.o(80996);
      return true;
    }
    TypedValue localTypedValue = new TypedValue();
    if (getContext().getTheme().resolveAttribute(16843611, localTypedValue, true))
    {
      if (localTypedValue.data != 0)
      {
        AppMethodBeat.o(80996);
        return true;
      }
      AppMethodBeat.o(80996);
      return false;
    }
    AppMethodBeat.o(80996);
    return false;
  }
  
  private boolean isLandscape()
  {
    AppMethodBeat.i(80997);
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    if (localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels)
    {
      AppMethodBeat.o(80997);
      return true;
    }
    AppMethodBeat.o(80997);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80992);
    super.onCreate(paramBundle);
    getWindow().setLayout(-1, -1);
    AppMethodBeat.o(80992);
  }
  
  public final void setContentView(int paramInt)
  {
    AppMethodBeat.i(80991);
    super.setContentView(b(paramInt, null, null));
    AppMethodBeat.o(80991);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(80993);
    super.setContentView(b(0, paramView, null));
    AppMethodBeat.o(80993);
  }
  
  public final void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(80994);
    super.setContentView(b(0, paramView, paramLayoutParams));
    AppMethodBeat.o(80994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.e
 * JD-Core Version:    0.7.0.1
 */