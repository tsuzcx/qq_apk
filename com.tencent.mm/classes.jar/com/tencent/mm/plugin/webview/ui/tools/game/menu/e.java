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
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends android.support.v7.app.e
{
  private Context mContext;
  
  public e(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private e(Context paramContext, byte paramByte)
  {
    super(paramContext, 2131820966);
    AppMethodBeat.i(80990);
    gl();
    this.mContext = paramContext;
    AppMethodBeat.o(80990);
  }
  
  private boolean aov()
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
  
  private View b(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(80995);
    Object localObject1 = getWindow();
    Object localObject2;
    View localView;
    if (aov())
    {
      ((Window)localObject1).setGravity(5);
      ((Window)localObject1).setWindowAnimations(2131821249);
      ((Window)localObject1).getDecorView().setPadding(0, 0, 0, 0);
      localObject2 = ((Window)localObject1).getAttributes();
      ((WindowManager.LayoutParams)localObject2).width = -1;
      ((WindowManager.LayoutParams)localObject2).height = -1;
      ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
      localObject2 = (ViewGroup)LayoutInflater.from(this.mContext).inflate(2131494348, null);
      localView = ((ViewGroup)localObject2).findViewById(2131306045);
      localObject1 = paramView;
      if (paramInt != 0)
      {
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = getLayoutInflater().inflate(paramInt, (ViewGroup)localObject2, false);
        }
      }
      if (!aov()) {
        break label201;
      }
      paramView = (FrameLayout)((ViewGroup)localObject2).findViewById(2131302250);
      label141:
      paramView.setVisibility(0);
      if (paramLayoutParams != null) {
        break label215;
      }
      paramView.addView((View)localObject1);
    }
    for (;;)
    {
      if (eqd()) {
        localView.setOnClickListener(new e.1(this));
      }
      AppMethodBeat.o(80995);
      return localObject2;
      ((Window)localObject1).setGravity(80);
      ((Window)localObject1).setWindowAnimations(2131820789);
      break;
      label201:
      paramView = (FrameLayout)((ViewGroup)localObject2).findViewById(2131302249);
      break label141;
      label215:
      paramView.addView((View)localObject1, paramLayoutParams);
    }
  }
  
  private boolean eqd()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.e
 * JD-Core Version:    0.7.0.1
 */